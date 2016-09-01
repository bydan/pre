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
import com.bydan.erp.cartera.util.*;//EstadoGarantiaClienteConstantesFunciones;










@SuppressWarnings("unused")
final public class EstadoGarantiaClienteDataAccess extends  EstadoGarantiaClienteDataAccessAdditional{ //EstadoGarantiaClienteDataAccessAdditional,DataAccessHelper<EstadoGarantiaCliente>
	//static Logger logger = Logger.getLogger(EstadoGarantiaClienteDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="estado_garantia_cliente";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+EstadoGarantiaClienteConstantesFunciones.SCHEMA+"."+EstadoGarantiaClienteConstantesFunciones.TABLENAME+"(id,version_row,codigo,nombre)values(?,current_timestamp,?,?)";
	public static String QUERYUPDATE="update "+EstadoGarantiaClienteConstantesFunciones.SCHEMA+"."+EstadoGarantiaClienteConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+EstadoGarantiaClienteConstantesFunciones.SCHEMA+"."+EstadoGarantiaClienteConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select estadogarantiacliente from "+EstadoGarantiaClienteConstantesFunciones.SPERSISTENCENAME+" estadogarantiacliente";
	public static String QUERYSELECTNATIVE="select "+EstadoGarantiaClienteConstantesFunciones.SCHEMA+"."+EstadoGarantiaClienteConstantesFunciones.TABLENAME+".id,"+EstadoGarantiaClienteConstantesFunciones.SCHEMA+"."+EstadoGarantiaClienteConstantesFunciones.TABLENAME+".version_row,"+EstadoGarantiaClienteConstantesFunciones.SCHEMA+"."+EstadoGarantiaClienteConstantesFunciones.TABLENAME+".codigo,"+EstadoGarantiaClienteConstantesFunciones.SCHEMA+"."+EstadoGarantiaClienteConstantesFunciones.TABLENAME+".nombre from "+EstadoGarantiaClienteConstantesFunciones.SCHEMA+"."+EstadoGarantiaClienteConstantesFunciones.TABLENAME;//+" as "+EstadoGarantiaClienteConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+EstadoGarantiaClienteConstantesFunciones.SCHEMA+"."+EstadoGarantiaClienteConstantesFunciones.TABLENAME+".id,"+EstadoGarantiaClienteConstantesFunciones.SCHEMA+"."+EstadoGarantiaClienteConstantesFunciones.TABLENAME+".version_row,"+EstadoGarantiaClienteConstantesFunciones.SCHEMA+"."+EstadoGarantiaClienteConstantesFunciones.TABLENAME+".codigo from "+EstadoGarantiaClienteConstantesFunciones.SCHEMA+"."+EstadoGarantiaClienteConstantesFunciones.TABLENAME;//+" as "+EstadoGarantiaClienteConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+EstadoGarantiaClienteConstantesFunciones.SCHEMA+"."+EstadoGarantiaClienteConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_ESTADOGARANTIACLIENTE_INSERT(?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_ESTADOGARANTIACLIENTE_UPDATE(?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_ESTADOGARANTIACLIENTE_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_ESTADOGARANTIACLIENTE_SELECT(?,?)";
	
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
	
	
	protected EstadoGarantiaClienteDataAccessAdditional estadogarantiaclienteDataAccessAdditional=null;
	
	public EstadoGarantiaClienteDataAccessAdditional getEstadoGarantiaClienteDataAccessAdditional() {
		return this.estadogarantiaclienteDataAccessAdditional;
	}
	
	public void setEstadoGarantiaClienteDataAccessAdditional(EstadoGarantiaClienteDataAccessAdditional estadogarantiaclienteDataAccessAdditional) {
		try {
			this.estadogarantiaclienteDataAccessAdditional=estadogarantiaclienteDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public EstadoGarantiaClienteDataAccess() {
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
		EstadoGarantiaClienteDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		EstadoGarantiaClienteDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		EstadoGarantiaClienteDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setEstadoGarantiaClienteOriginal(EstadoGarantiaCliente estadogarantiacliente)throws Exception  {
		estadogarantiacliente.setEstadoGarantiaClienteOriginal((EstadoGarantiaCliente)estadogarantiacliente.clone());		
	}
	
	public void setEstadoGarantiaClientesOriginal(List<EstadoGarantiaCliente> estadogarantiaclientes)throws Exception  {
		
		for(EstadoGarantiaCliente estadogarantiacliente:estadogarantiaclientes){
			estadogarantiacliente.setEstadoGarantiaClienteOriginal((EstadoGarantiaCliente)estadogarantiacliente.clone());
		}
	}
	
	public static void setEstadoGarantiaClienteOriginalStatic(EstadoGarantiaCliente estadogarantiacliente)throws Exception  {
		estadogarantiacliente.setEstadoGarantiaClienteOriginal((EstadoGarantiaCliente)estadogarantiacliente.clone());		
	}
	
	public static void setEstadoGarantiaClientesOriginalStatic(List<EstadoGarantiaCliente> estadogarantiaclientes)throws Exception  {
		
		for(EstadoGarantiaCliente estadogarantiacliente:estadogarantiaclientes){
			estadogarantiacliente.setEstadoGarantiaClienteOriginal((EstadoGarantiaCliente)estadogarantiacliente.clone());
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
	
	public  EstadoGarantiaCliente getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		EstadoGarantiaCliente entity = new EstadoGarantiaCliente();		
		
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
	
	public  EstadoGarantiaCliente getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		EstadoGarantiaCliente entity = new EstadoGarantiaCliente();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoGarantiaClienteDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoGarantiaClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Cartera.EstadoGarantiaCliente.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setEstadoGarantiaClienteOriginal(new EstadoGarantiaCliente());
      	    	entity=super.getEntity("",entity,resultSet,EstadoGarantiaClienteDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEstadoGarantiaCliente("",entity,resultSet); 
				
				//entity.setEstadoGarantiaClienteOriginal(super.getEntity("",entity.getEstadoGarantiaClienteOriginal(),resultSet,EstadoGarantiaClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoGarantiaClienteOriginal(this.getEntityEstadoGarantiaCliente("",entity.getEstadoGarantiaClienteOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseEstadoGarantiaCliente(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  EstadoGarantiaCliente getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EstadoGarantiaCliente entity = new EstadoGarantiaCliente();
				
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
	
	public  EstadoGarantiaCliente getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EstadoGarantiaCliente entity = new EstadoGarantiaCliente();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoGarantiaClienteDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoGarantiaClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoGarantiaClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.EstadoGarantiaCliente.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setEstadoGarantiaClienteOriginal(new EstadoGarantiaCliente());
      	    	entity=super.getEntity("",entity,resultSet,EstadoGarantiaClienteDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEstadoGarantiaCliente("",entity,resultSet);    
				
				//entity.setEstadoGarantiaClienteOriginal(super.getEntity("",entity.getEstadoGarantiaClienteOriginal(),resultSet,EstadoGarantiaClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoGarantiaClienteOriginal(this.getEntityEstadoGarantiaCliente("",entity.getEstadoGarantiaClienteOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseEstadoGarantiaCliente(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //EstadoGarantiaCliente
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		EstadoGarantiaCliente entity = new EstadoGarantiaCliente();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoGarantiaClienteDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoGarantiaClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoGarantiaClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.EstadoGarantiaCliente.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseEstadoGarantiaCliente(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<EstadoGarantiaCliente> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EstadoGarantiaCliente> entities = new  ArrayList<EstadoGarantiaCliente>();
		EstadoGarantiaCliente entity = new EstadoGarantiaCliente();		  
		
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
	
	public  List<EstadoGarantiaCliente> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EstadoGarantiaCliente> entities = new  ArrayList<EstadoGarantiaCliente>();
		EstadoGarantiaCliente entity = new EstadoGarantiaCliente();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoGarantiaClienteDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoGarantiaClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoGarantiaClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoGarantiaCliente();
      	    	entity=super.getEntity("",entity,resultSet,EstadoGarantiaClienteDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoGarantiaCliente("",entity,resultSet);
      	    	
				//entity.setEstadoGarantiaClienteOriginal( new EstadoGarantiaCliente());
      	    	//entity.setEstadoGarantiaClienteOriginal(super.getEntity("",entity.getEstadoGarantiaClienteOriginal(),resultSet,EstadoGarantiaClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoGarantiaClienteOriginal(this.getEntityEstadoGarantiaCliente("",entity.getEstadoGarantiaClienteOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoGarantiaClientes(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoGarantiaCliente(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<EstadoGarantiaCliente> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EstadoGarantiaCliente> entities = new  ArrayList<EstadoGarantiaCliente>();
		EstadoGarantiaCliente entity = new EstadoGarantiaCliente();		  
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
	
	public  List<EstadoGarantiaCliente> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EstadoGarantiaCliente> entities = new  ArrayList<EstadoGarantiaCliente>();
		EstadoGarantiaCliente entity = new EstadoGarantiaCliente();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoGarantiaCliente();
				
				if(conMapGenerico) {
					entity.inicializarMapEstadoGarantiaCliente();
					//entity.setMapEstadoGarantiaCliente(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapEstadoGarantiaClienteValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEstadoGarantiaCliente().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EstadoGarantiaClienteDataAccess.ISWITHSCHEMA);         		
					entity=EstadoGarantiaClienteDataAccess.getEntityEstadoGarantiaCliente("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEstadoGarantiaClienteOriginal( new EstadoGarantiaCliente());
					////entity.setEstadoGarantiaClienteOriginal(super.getEntity("",entity.getEstadoGarantiaClienteOriginal(),resultSet,EstadoGarantiaClienteDataAccess.ISWITHSCHEMA));         		
					////entity.setEstadoGarantiaClienteOriginal(this.getEntityEstadoGarantiaCliente("",entity.getEstadoGarantiaClienteOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoGarantiaClientes(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoGarantiaCliente(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public EstadoGarantiaCliente getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EstadoGarantiaCliente entity = new EstadoGarantiaCliente();		  
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
	
	public  EstadoGarantiaCliente getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EstadoGarantiaCliente entity = new EstadoGarantiaCliente();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoGarantiaCliente();
				
				if(conMapGenerico) {
					entity.inicializarMapEstadoGarantiaCliente();
					//entity.setMapEstadoGarantiaCliente(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapEstadoGarantiaClienteValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEstadoGarantiaCliente().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EstadoGarantiaClienteDataAccess.ISWITHSCHEMA);         		
					entity=EstadoGarantiaClienteDataAccess.getEntityEstadoGarantiaCliente("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEstadoGarantiaClienteOriginal( new EstadoGarantiaCliente());
					////entity.setEstadoGarantiaClienteOriginal(super.getEntity("",entity.getEstadoGarantiaClienteOriginal(),resultSet,EstadoGarantiaClienteDataAccess.ISWITHSCHEMA));         		
					////entity.setEstadoGarantiaClienteOriginal(this.getEntityEstadoGarantiaCliente("",entity.getEstadoGarantiaClienteOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseEstadoGarantiaCliente(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoGarantiaCliente(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static EstadoGarantiaCliente getEntityEstadoGarantiaCliente(String strPrefijo,EstadoGarantiaCliente entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = EstadoGarantiaCliente.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = EstadoGarantiaCliente.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					EstadoGarantiaClienteDataAccess.setFieldReflectionEstadoGarantiaCliente(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasEstadoGarantiaCliente=EstadoGarantiaClienteConstantesFunciones.getTodosTiposColumnasEstadoGarantiaCliente();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasEstadoGarantiaCliente) {
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
							field = EstadoGarantiaCliente.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = EstadoGarantiaCliente.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						EstadoGarantiaClienteDataAccess.setFieldReflectionEstadoGarantiaCliente(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionEstadoGarantiaCliente(Field field,String strPrefijo,String sColumn,EstadoGarantiaCliente entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case EstadoGarantiaClienteConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EstadoGarantiaClienteConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EstadoGarantiaClienteConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EstadoGarantiaClienteConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EstadoGarantiaCliente>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<EstadoGarantiaCliente> entities = new  ArrayList<EstadoGarantiaCliente>();
		EstadoGarantiaCliente entity = new EstadoGarantiaCliente();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoGarantiaClienteDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoGarantiaClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoGarantiaClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new EstadoGarantiaCliente();
					entity=super.getEntity("",entity,resultSet,EstadoGarantiaClienteDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityEstadoGarantiaCliente("",entity,resultSet);
					
					//entity.setEstadoGarantiaClienteOriginal( new EstadoGarantiaCliente());
					//entity.setEstadoGarantiaClienteOriginal(super.getEntity("",entity.getEstadoGarantiaClienteOriginal(),resultSet,EstadoGarantiaClienteDataAccess.ISWITHSCHEMA));         		
					//entity.setEstadoGarantiaClienteOriginal(this.getEntityEstadoGarantiaCliente("",entity.getEstadoGarantiaClienteOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseEstadoGarantiaClientes(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoGarantiaCliente(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EstadoGarantiaCliente>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<EstadoGarantiaCliente> entities = new  ArrayList<EstadoGarantiaCliente>();
		EstadoGarantiaCliente entity = new EstadoGarantiaCliente();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoGarantiaClienteDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoGarantiaClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoGarantiaClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<EstadoGarantiaCliente> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoGarantiaCliente> entities = new  ArrayList<EstadoGarantiaCliente>();
		EstadoGarantiaCliente entity = new EstadoGarantiaCliente();		  
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
	
	public  List<EstadoGarantiaCliente> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoGarantiaCliente> entities = new  ArrayList<EstadoGarantiaCliente>();
		EstadoGarantiaCliente entity = new EstadoGarantiaCliente();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoGarantiaCliente();
      	    	entity=super.getEntity("",entity,resultSet,EstadoGarantiaClienteDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoGarantiaCliente("",entity,resultSet);
      	    	
				//entity.setEstadoGarantiaClienteOriginal( new EstadoGarantiaCliente());
      	    	//entity.setEstadoGarantiaClienteOriginal(super.getEntity("",entity.getEstadoGarantiaClienteOriginal(),resultSet,EstadoGarantiaClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoGarantiaClienteOriginal(this.getEntityEstadoGarantiaCliente("",entity.getEstadoGarantiaClienteOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseEstadoGarantiaClientes(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoGarantiaCliente(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<EstadoGarantiaCliente> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoGarantiaCliente> entities = new  ArrayList<EstadoGarantiaCliente>();
		EstadoGarantiaCliente entity = new EstadoGarantiaCliente();		  
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
	
	public  List<EstadoGarantiaCliente> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoGarantiaCliente> entities = new  ArrayList<EstadoGarantiaCliente>();
		EstadoGarantiaCliente entity = new EstadoGarantiaCliente();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoGarantiaCliente();
      	    	entity=super.getEntity("",entity,resultSet,EstadoGarantiaClienteDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoGarantiaCliente("",entity,resultSet);
      	    	
				//entity.setEstadoGarantiaClienteOriginal( new EstadoGarantiaCliente());
      	    	//entity.setEstadoGarantiaClienteOriginal(super.getEntity("",entity.getEstadoGarantiaClienteOriginal(),resultSet,EstadoGarantiaClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoGarantiaClienteOriginal(this.getEntityEstadoGarantiaCliente("",entity.getEstadoGarantiaClienteOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoGarantiaClientes(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public EstadoGarantiaCliente getEntityEstadoGarantiaCliente(String strPrefijo,EstadoGarantiaCliente entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setcodigo(resultSet.getString(strPrefijo+EstadoGarantiaClienteConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+EstadoGarantiaClienteConstantesFunciones.NOMBRE));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+EstadoGarantiaClienteConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowEstadoGarantiaCliente(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(EstadoGarantiaCliente entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=EstadoGarantiaClienteDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=EstadoGarantiaClienteDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=EstadoGarantiaClienteDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=EstadoGarantiaClienteDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(EstadoGarantiaClienteConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,EstadoGarantiaClienteDataAccess.TABLENAME,EstadoGarantiaClienteDataAccess.ISWITHSTOREPROCEDURES);
			
			EstadoGarantiaClienteDataAccess.setEstadoGarantiaClienteOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
	
		
		public List<GarantiaCliente> getGarantiaClientes(Connexion connexion,EstadoGarantiaCliente estadogarantiacliente)throws SQLException,Exception {

		List<GarantiaCliente> garantiaclientes= new ArrayList<GarantiaCliente>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstadoGarantiaClienteConstantesFunciones.SCHEMA+".estado_garantia_cliente ON "+GarantiaClienteConstantesFunciones.SCHEMA+".garantia_cliente.id_estado_garantia_cliente="+EstadoGarantiaClienteConstantesFunciones.SCHEMA+".estado_garantia_cliente.id WHERE "+EstadoGarantiaClienteConstantesFunciones.SCHEMA+".estado_garantia_cliente.id="+String.valueOf(estadogarantiacliente.getId());
			} else {
				sQuery=" INNER JOIN garantiacliente.EstadoGarantiaCliente WHERE garantiacliente.EstadoGarantiaCliente.id="+String.valueOf(estadogarantiacliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			GarantiaClienteDataAccess garantiaclienteDataAccess=new GarantiaClienteDataAccess();

			garantiaclienteDataAccess.setConnexionType(this.connexionType);
			garantiaclienteDataAccess.setParameterDbType(this.parameterDbType);
			garantiaclientes=garantiaclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return garantiaclientes;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,EstadoGarantiaCliente estadogarantiacliente) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!estadogarantiacliente.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid=new ParameterValue<Long>();
					parameterMaintenanceValueid.setValue(estadogarantiacliente.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(estadogarantiacliente.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(estadogarantiacliente.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!estadogarantiacliente.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(estadogarantiacliente.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(estadogarantiacliente.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(estadogarantiacliente.getId());
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
	
	public void setIsNewIsChangedFalseEstadoGarantiaCliente(EstadoGarantiaCliente estadogarantiacliente)throws Exception  {		
		estadogarantiacliente.setIsNew(false);
		estadogarantiacliente.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseEstadoGarantiaClientes(List<EstadoGarantiaCliente> estadogarantiaclientes)throws Exception  {				
		for(EstadoGarantiaCliente estadogarantiacliente:estadogarantiaclientes) {
			estadogarantiacliente.setIsNew(false);
			estadogarantiacliente.setIsChanged(false);
		}
	}
	
	public void generarExportarEstadoGarantiaCliente(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
