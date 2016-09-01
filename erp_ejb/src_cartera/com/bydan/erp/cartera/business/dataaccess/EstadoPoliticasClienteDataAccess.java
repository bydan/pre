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
import com.bydan.erp.cartera.util.*;//EstadoPoliticasClienteConstantesFunciones;










@SuppressWarnings("unused")
final public class EstadoPoliticasClienteDataAccess extends  EstadoPoliticasClienteDataAccessAdditional{ //EstadoPoliticasClienteDataAccessAdditional,DataAccessHelper<EstadoPoliticasCliente>
	//static Logger logger = Logger.getLogger(EstadoPoliticasClienteDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="estado_politicas_cliente";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+EstadoPoliticasClienteConstantesFunciones.SCHEMA+"."+EstadoPoliticasClienteConstantesFunciones.TABLENAME+"(id,version_row,codigo,nombre)values(?,current_timestamp,?,?)";
	public static String QUERYUPDATE="update "+EstadoPoliticasClienteConstantesFunciones.SCHEMA+"."+EstadoPoliticasClienteConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+EstadoPoliticasClienteConstantesFunciones.SCHEMA+"."+EstadoPoliticasClienteConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select estadopoliticascliente from "+EstadoPoliticasClienteConstantesFunciones.SPERSISTENCENAME+" estadopoliticascliente";
	public static String QUERYSELECTNATIVE="select "+EstadoPoliticasClienteConstantesFunciones.SCHEMA+"."+EstadoPoliticasClienteConstantesFunciones.TABLENAME+".id,"+EstadoPoliticasClienteConstantesFunciones.SCHEMA+"."+EstadoPoliticasClienteConstantesFunciones.TABLENAME+".version_row,"+EstadoPoliticasClienteConstantesFunciones.SCHEMA+"."+EstadoPoliticasClienteConstantesFunciones.TABLENAME+".codigo,"+EstadoPoliticasClienteConstantesFunciones.SCHEMA+"."+EstadoPoliticasClienteConstantesFunciones.TABLENAME+".nombre from "+EstadoPoliticasClienteConstantesFunciones.SCHEMA+"."+EstadoPoliticasClienteConstantesFunciones.TABLENAME;//+" as "+EstadoPoliticasClienteConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+EstadoPoliticasClienteConstantesFunciones.SCHEMA+"."+EstadoPoliticasClienteConstantesFunciones.TABLENAME+".id,"+EstadoPoliticasClienteConstantesFunciones.SCHEMA+"."+EstadoPoliticasClienteConstantesFunciones.TABLENAME+".version_row,"+EstadoPoliticasClienteConstantesFunciones.SCHEMA+"."+EstadoPoliticasClienteConstantesFunciones.TABLENAME+".codigo from "+EstadoPoliticasClienteConstantesFunciones.SCHEMA+"."+EstadoPoliticasClienteConstantesFunciones.TABLENAME;//+" as "+EstadoPoliticasClienteConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+EstadoPoliticasClienteConstantesFunciones.SCHEMA+"."+EstadoPoliticasClienteConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_ESTADOPOLITICASCLIENTE_INSERT(?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_ESTADOPOLITICASCLIENTE_UPDATE(?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_ESTADOPOLITICASCLIENTE_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_ESTADOPOLITICASCLIENTE_SELECT(?,?)";
	
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
	
	
	protected EstadoPoliticasClienteDataAccessAdditional estadopoliticasclienteDataAccessAdditional=null;
	
	public EstadoPoliticasClienteDataAccessAdditional getEstadoPoliticasClienteDataAccessAdditional() {
		return this.estadopoliticasclienteDataAccessAdditional;
	}
	
	public void setEstadoPoliticasClienteDataAccessAdditional(EstadoPoliticasClienteDataAccessAdditional estadopoliticasclienteDataAccessAdditional) {
		try {
			this.estadopoliticasclienteDataAccessAdditional=estadopoliticasclienteDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public EstadoPoliticasClienteDataAccess() {
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
		EstadoPoliticasClienteDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		EstadoPoliticasClienteDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		EstadoPoliticasClienteDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setEstadoPoliticasClienteOriginal(EstadoPoliticasCliente estadopoliticascliente)throws Exception  {
		estadopoliticascliente.setEstadoPoliticasClienteOriginal((EstadoPoliticasCliente)estadopoliticascliente.clone());		
	}
	
	public void setEstadoPoliticasClientesOriginal(List<EstadoPoliticasCliente> estadopoliticasclientes)throws Exception  {
		
		for(EstadoPoliticasCliente estadopoliticascliente:estadopoliticasclientes){
			estadopoliticascliente.setEstadoPoliticasClienteOriginal((EstadoPoliticasCliente)estadopoliticascliente.clone());
		}
	}
	
	public static void setEstadoPoliticasClienteOriginalStatic(EstadoPoliticasCliente estadopoliticascliente)throws Exception  {
		estadopoliticascliente.setEstadoPoliticasClienteOriginal((EstadoPoliticasCliente)estadopoliticascliente.clone());		
	}
	
	public static void setEstadoPoliticasClientesOriginalStatic(List<EstadoPoliticasCliente> estadopoliticasclientes)throws Exception  {
		
		for(EstadoPoliticasCliente estadopoliticascliente:estadopoliticasclientes){
			estadopoliticascliente.setEstadoPoliticasClienteOriginal((EstadoPoliticasCliente)estadopoliticascliente.clone());
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
	
	public  EstadoPoliticasCliente getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		EstadoPoliticasCliente entity = new EstadoPoliticasCliente();		
		
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
	
	public  EstadoPoliticasCliente getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		EstadoPoliticasCliente entity = new EstadoPoliticasCliente();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoPoliticasClienteDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoPoliticasClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Cartera.EstadoPoliticasCliente.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setEstadoPoliticasClienteOriginal(new EstadoPoliticasCliente());
      	    	entity=super.getEntity("",entity,resultSet,EstadoPoliticasClienteDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEstadoPoliticasCliente("",entity,resultSet); 
				
				//entity.setEstadoPoliticasClienteOriginal(super.getEntity("",entity.getEstadoPoliticasClienteOriginal(),resultSet,EstadoPoliticasClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoPoliticasClienteOriginal(this.getEntityEstadoPoliticasCliente("",entity.getEstadoPoliticasClienteOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseEstadoPoliticasCliente(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  EstadoPoliticasCliente getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EstadoPoliticasCliente entity = new EstadoPoliticasCliente();
				
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
	
	public  EstadoPoliticasCliente getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EstadoPoliticasCliente entity = new EstadoPoliticasCliente();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoPoliticasClienteDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoPoliticasClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoPoliticasClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.EstadoPoliticasCliente.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setEstadoPoliticasClienteOriginal(new EstadoPoliticasCliente());
      	    	entity=super.getEntity("",entity,resultSet,EstadoPoliticasClienteDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEstadoPoliticasCliente("",entity,resultSet);    
				
				//entity.setEstadoPoliticasClienteOriginal(super.getEntity("",entity.getEstadoPoliticasClienteOriginal(),resultSet,EstadoPoliticasClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoPoliticasClienteOriginal(this.getEntityEstadoPoliticasCliente("",entity.getEstadoPoliticasClienteOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseEstadoPoliticasCliente(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //EstadoPoliticasCliente
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		EstadoPoliticasCliente entity = new EstadoPoliticasCliente();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoPoliticasClienteDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoPoliticasClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoPoliticasClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.EstadoPoliticasCliente.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseEstadoPoliticasCliente(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<EstadoPoliticasCliente> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EstadoPoliticasCliente> entities = new  ArrayList<EstadoPoliticasCliente>();
		EstadoPoliticasCliente entity = new EstadoPoliticasCliente();		  
		
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
	
	public  List<EstadoPoliticasCliente> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EstadoPoliticasCliente> entities = new  ArrayList<EstadoPoliticasCliente>();
		EstadoPoliticasCliente entity = new EstadoPoliticasCliente();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoPoliticasClienteDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoPoliticasClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoPoliticasClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoPoliticasCliente();
      	    	entity=super.getEntity("",entity,resultSet,EstadoPoliticasClienteDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoPoliticasCliente("",entity,resultSet);
      	    	
				//entity.setEstadoPoliticasClienteOriginal( new EstadoPoliticasCliente());
      	    	//entity.setEstadoPoliticasClienteOriginal(super.getEntity("",entity.getEstadoPoliticasClienteOriginal(),resultSet,EstadoPoliticasClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoPoliticasClienteOriginal(this.getEntityEstadoPoliticasCliente("",entity.getEstadoPoliticasClienteOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoPoliticasClientes(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoPoliticasCliente(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<EstadoPoliticasCliente> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EstadoPoliticasCliente> entities = new  ArrayList<EstadoPoliticasCliente>();
		EstadoPoliticasCliente entity = new EstadoPoliticasCliente();		  
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
	
	public  List<EstadoPoliticasCliente> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EstadoPoliticasCliente> entities = new  ArrayList<EstadoPoliticasCliente>();
		EstadoPoliticasCliente entity = new EstadoPoliticasCliente();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoPoliticasCliente();
				
				if(conMapGenerico) {
					entity.inicializarMapEstadoPoliticasCliente();
					//entity.setMapEstadoPoliticasCliente(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapEstadoPoliticasClienteValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEstadoPoliticasCliente().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EstadoPoliticasClienteDataAccess.ISWITHSCHEMA);         		
					entity=EstadoPoliticasClienteDataAccess.getEntityEstadoPoliticasCliente("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEstadoPoliticasClienteOriginal( new EstadoPoliticasCliente());
					////entity.setEstadoPoliticasClienteOriginal(super.getEntity("",entity.getEstadoPoliticasClienteOriginal(),resultSet,EstadoPoliticasClienteDataAccess.ISWITHSCHEMA));         		
					////entity.setEstadoPoliticasClienteOriginal(this.getEntityEstadoPoliticasCliente("",entity.getEstadoPoliticasClienteOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoPoliticasClientes(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoPoliticasCliente(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public EstadoPoliticasCliente getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EstadoPoliticasCliente entity = new EstadoPoliticasCliente();		  
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
	
	public  EstadoPoliticasCliente getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EstadoPoliticasCliente entity = new EstadoPoliticasCliente();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoPoliticasCliente();
				
				if(conMapGenerico) {
					entity.inicializarMapEstadoPoliticasCliente();
					//entity.setMapEstadoPoliticasCliente(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapEstadoPoliticasClienteValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEstadoPoliticasCliente().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EstadoPoliticasClienteDataAccess.ISWITHSCHEMA);         		
					entity=EstadoPoliticasClienteDataAccess.getEntityEstadoPoliticasCliente("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEstadoPoliticasClienteOriginal( new EstadoPoliticasCliente());
					////entity.setEstadoPoliticasClienteOriginal(super.getEntity("",entity.getEstadoPoliticasClienteOriginal(),resultSet,EstadoPoliticasClienteDataAccess.ISWITHSCHEMA));         		
					////entity.setEstadoPoliticasClienteOriginal(this.getEntityEstadoPoliticasCliente("",entity.getEstadoPoliticasClienteOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseEstadoPoliticasCliente(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoPoliticasCliente(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static EstadoPoliticasCliente getEntityEstadoPoliticasCliente(String strPrefijo,EstadoPoliticasCliente entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = EstadoPoliticasCliente.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = EstadoPoliticasCliente.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					EstadoPoliticasClienteDataAccess.setFieldReflectionEstadoPoliticasCliente(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasEstadoPoliticasCliente=EstadoPoliticasClienteConstantesFunciones.getTodosTiposColumnasEstadoPoliticasCliente();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasEstadoPoliticasCliente) {
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
							field = EstadoPoliticasCliente.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = EstadoPoliticasCliente.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						EstadoPoliticasClienteDataAccess.setFieldReflectionEstadoPoliticasCliente(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionEstadoPoliticasCliente(Field field,String strPrefijo,String sColumn,EstadoPoliticasCliente entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case EstadoPoliticasClienteConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EstadoPoliticasClienteConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EstadoPoliticasClienteConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EstadoPoliticasClienteConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EstadoPoliticasCliente>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<EstadoPoliticasCliente> entities = new  ArrayList<EstadoPoliticasCliente>();
		EstadoPoliticasCliente entity = new EstadoPoliticasCliente();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoPoliticasClienteDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoPoliticasClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoPoliticasClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new EstadoPoliticasCliente();
					entity=super.getEntity("",entity,resultSet,EstadoPoliticasClienteDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityEstadoPoliticasCliente("",entity,resultSet);
					
					//entity.setEstadoPoliticasClienteOriginal( new EstadoPoliticasCliente());
					//entity.setEstadoPoliticasClienteOriginal(super.getEntity("",entity.getEstadoPoliticasClienteOriginal(),resultSet,EstadoPoliticasClienteDataAccess.ISWITHSCHEMA));         		
					//entity.setEstadoPoliticasClienteOriginal(this.getEntityEstadoPoliticasCliente("",entity.getEstadoPoliticasClienteOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseEstadoPoliticasClientes(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoPoliticasCliente(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EstadoPoliticasCliente>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<EstadoPoliticasCliente> entities = new  ArrayList<EstadoPoliticasCliente>();
		EstadoPoliticasCliente entity = new EstadoPoliticasCliente();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoPoliticasClienteDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoPoliticasClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoPoliticasClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<EstadoPoliticasCliente> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoPoliticasCliente> entities = new  ArrayList<EstadoPoliticasCliente>();
		EstadoPoliticasCliente entity = new EstadoPoliticasCliente();		  
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
	
	public  List<EstadoPoliticasCliente> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoPoliticasCliente> entities = new  ArrayList<EstadoPoliticasCliente>();
		EstadoPoliticasCliente entity = new EstadoPoliticasCliente();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoPoliticasCliente();
      	    	entity=super.getEntity("",entity,resultSet,EstadoPoliticasClienteDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoPoliticasCliente("",entity,resultSet);
      	    	
				//entity.setEstadoPoliticasClienteOriginal( new EstadoPoliticasCliente());
      	    	//entity.setEstadoPoliticasClienteOriginal(super.getEntity("",entity.getEstadoPoliticasClienteOriginal(),resultSet,EstadoPoliticasClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoPoliticasClienteOriginal(this.getEntityEstadoPoliticasCliente("",entity.getEstadoPoliticasClienteOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseEstadoPoliticasClientes(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoPoliticasCliente(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<EstadoPoliticasCliente> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoPoliticasCliente> entities = new  ArrayList<EstadoPoliticasCliente>();
		EstadoPoliticasCliente entity = new EstadoPoliticasCliente();		  
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
	
	public  List<EstadoPoliticasCliente> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoPoliticasCliente> entities = new  ArrayList<EstadoPoliticasCliente>();
		EstadoPoliticasCliente entity = new EstadoPoliticasCliente();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoPoliticasCliente();
      	    	entity=super.getEntity("",entity,resultSet,EstadoPoliticasClienteDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoPoliticasCliente("",entity,resultSet);
      	    	
				//entity.setEstadoPoliticasClienteOriginal( new EstadoPoliticasCliente());
      	    	//entity.setEstadoPoliticasClienteOriginal(super.getEntity("",entity.getEstadoPoliticasClienteOriginal(),resultSet,EstadoPoliticasClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoPoliticasClienteOriginal(this.getEntityEstadoPoliticasCliente("",entity.getEstadoPoliticasClienteOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoPoliticasClientes(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public EstadoPoliticasCliente getEntityEstadoPoliticasCliente(String strPrefijo,EstadoPoliticasCliente entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setcodigo(resultSet.getString(strPrefijo+EstadoPoliticasClienteConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+EstadoPoliticasClienteConstantesFunciones.NOMBRE));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+EstadoPoliticasClienteConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowEstadoPoliticasCliente(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(EstadoPoliticasCliente entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=EstadoPoliticasClienteDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=EstadoPoliticasClienteDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=EstadoPoliticasClienteDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=EstadoPoliticasClienteDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(EstadoPoliticasClienteConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,EstadoPoliticasClienteDataAccess.TABLENAME,EstadoPoliticasClienteDataAccess.ISWITHSTOREPROCEDURES);
			
			EstadoPoliticasClienteDataAccess.setEstadoPoliticasClienteOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
	
		
		public List<PoliticasCliente> getPoliticasClientes(Connexion connexion,EstadoPoliticasCliente estadopoliticascliente)throws SQLException,Exception {

		List<PoliticasCliente> politicasclientes= new ArrayList<PoliticasCliente>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstadoPoliticasClienteConstantesFunciones.SCHEMA+".estado_politicas_cliente ON "+PoliticasClienteConstantesFunciones.SCHEMA+".politicas_cliente.id_estado_politicas_cliente="+EstadoPoliticasClienteConstantesFunciones.SCHEMA+".estado_politicas_cliente.id WHERE "+EstadoPoliticasClienteConstantesFunciones.SCHEMA+".estado_politicas_cliente.id="+String.valueOf(estadopoliticascliente.getId());
			} else {
				sQuery=" INNER JOIN politicascliente.EstadoPoliticasCliente WHERE politicascliente.EstadoPoliticasCliente.id="+String.valueOf(estadopoliticascliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PoliticasClienteDataAccess politicasclienteDataAccess=new PoliticasClienteDataAccess();

			politicasclienteDataAccess.setConnexionType(this.connexionType);
			politicasclienteDataAccess.setParameterDbType(this.parameterDbType);
			politicasclientes=politicasclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return politicasclientes;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,EstadoPoliticasCliente estadopoliticascliente) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!estadopoliticascliente.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid=new ParameterValue<Long>();
					parameterMaintenanceValueid.setValue(estadopoliticascliente.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(estadopoliticascliente.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(estadopoliticascliente.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!estadopoliticascliente.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(estadopoliticascliente.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(estadopoliticascliente.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(estadopoliticascliente.getId());
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
	
	public void setIsNewIsChangedFalseEstadoPoliticasCliente(EstadoPoliticasCliente estadopoliticascliente)throws Exception  {		
		estadopoliticascliente.setIsNew(false);
		estadopoliticascliente.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseEstadoPoliticasClientes(List<EstadoPoliticasCliente> estadopoliticasclientes)throws Exception  {				
		for(EstadoPoliticasCliente estadopoliticascliente:estadopoliticasclientes) {
			estadopoliticascliente.setIsNew(false);
			estadopoliticascliente.setIsChanged(false);
		}
	}
	
	public void generarExportarEstadoPoliticasCliente(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
