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
package com.bydan.erp.tesoreria.business.dataaccess;

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

import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.tesoreria.util.*;//EstadoRegistroFormaPagoBancoConstantesFunciones;










@SuppressWarnings("unused")
final public class EstadoRegistroFormaPagoBancoDataAccess extends  DataAccessHelperSinIdGenerated<EstadoRegistroFormaPagoBanco>{ //EstadoRegistroFormaPagoBancoDataAccessAdditional,DataAccessHelper<EstadoRegistroFormaPagoBanco>
	//static Logger logger = Logger.getLogger(EstadoRegistroFormaPagoBancoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="estado_registro_forma_pago_banco";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+EstadoRegistroFormaPagoBancoConstantesFunciones.SCHEMA+"."+EstadoRegistroFormaPagoBancoConstantesFunciones.TABLENAME+"(id,version_row,codigo,nombre)values(?,current_timestamp,?,?)";
	public static String QUERYUPDATE="update "+EstadoRegistroFormaPagoBancoConstantesFunciones.SCHEMA+"."+EstadoRegistroFormaPagoBancoConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+EstadoRegistroFormaPagoBancoConstantesFunciones.SCHEMA+"."+EstadoRegistroFormaPagoBancoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select estadoregistroformapagobanco from "+EstadoRegistroFormaPagoBancoConstantesFunciones.SPERSISTENCENAME+" estadoregistroformapagobanco";
	public static String QUERYSELECTNATIVE="select "+EstadoRegistroFormaPagoBancoConstantesFunciones.SCHEMA+"."+EstadoRegistroFormaPagoBancoConstantesFunciones.TABLENAME+".id,"+EstadoRegistroFormaPagoBancoConstantesFunciones.SCHEMA+"."+EstadoRegistroFormaPagoBancoConstantesFunciones.TABLENAME+".version_row,"+EstadoRegistroFormaPagoBancoConstantesFunciones.SCHEMA+"."+EstadoRegistroFormaPagoBancoConstantesFunciones.TABLENAME+".codigo,"+EstadoRegistroFormaPagoBancoConstantesFunciones.SCHEMA+"."+EstadoRegistroFormaPagoBancoConstantesFunciones.TABLENAME+".nombre from "+EstadoRegistroFormaPagoBancoConstantesFunciones.SCHEMA+"."+EstadoRegistroFormaPagoBancoConstantesFunciones.TABLENAME;//+" as "+EstadoRegistroFormaPagoBancoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+EstadoRegistroFormaPagoBancoConstantesFunciones.SCHEMA+"."+EstadoRegistroFormaPagoBancoConstantesFunciones.TABLENAME+".id,"+EstadoRegistroFormaPagoBancoConstantesFunciones.SCHEMA+"."+EstadoRegistroFormaPagoBancoConstantesFunciones.TABLENAME+".version_row,"+EstadoRegistroFormaPagoBancoConstantesFunciones.SCHEMA+"."+EstadoRegistroFormaPagoBancoConstantesFunciones.TABLENAME+".codigo from "+EstadoRegistroFormaPagoBancoConstantesFunciones.SCHEMA+"."+EstadoRegistroFormaPagoBancoConstantesFunciones.TABLENAME;//+" as "+EstadoRegistroFormaPagoBancoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+EstadoRegistroFormaPagoBancoConstantesFunciones.SCHEMA+"."+EstadoRegistroFormaPagoBancoConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_ESTADOREGISTROFORMAPAGOBANCO_INSERT(?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_ESTADOREGISTROFORMAPAGOBANCO_UPDATE(?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_ESTADOREGISTROFORMAPAGOBANCO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_ESTADOREGISTROFORMAPAGOBANCO_SELECT(?,?)";
	
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
	
	
	public EstadoRegistroFormaPagoBancoDataAccess() {
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
		EstadoRegistroFormaPagoBancoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		EstadoRegistroFormaPagoBancoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		EstadoRegistroFormaPagoBancoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setEstadoRegistroFormaPagoBancoOriginal(EstadoRegistroFormaPagoBanco estadoregistroformapagobanco)throws Exception  {
		estadoregistroformapagobanco.setEstadoRegistroFormaPagoBancoOriginal((EstadoRegistroFormaPagoBanco)estadoregistroformapagobanco.clone());		
	}
	
	public void setEstadoRegistroFormaPagoBancosOriginal(List<EstadoRegistroFormaPagoBanco> estadoregistroformapagobancos)throws Exception  {
		
		for(EstadoRegistroFormaPagoBanco estadoregistroformapagobanco:estadoregistroformapagobancos){
			estadoregistroformapagobanco.setEstadoRegistroFormaPagoBancoOriginal((EstadoRegistroFormaPagoBanco)estadoregistroformapagobanco.clone());
		}
	}
	
	public static void setEstadoRegistroFormaPagoBancoOriginalStatic(EstadoRegistroFormaPagoBanco estadoregistroformapagobanco)throws Exception  {
		estadoregistroformapagobanco.setEstadoRegistroFormaPagoBancoOriginal((EstadoRegistroFormaPagoBanco)estadoregistroformapagobanco.clone());		
	}
	
	public static void setEstadoRegistroFormaPagoBancosOriginalStatic(List<EstadoRegistroFormaPagoBanco> estadoregistroformapagobancos)throws Exception  {
		
		for(EstadoRegistroFormaPagoBanco estadoregistroformapagobanco:estadoregistroformapagobancos){
			estadoregistroformapagobanco.setEstadoRegistroFormaPagoBancoOriginal((EstadoRegistroFormaPagoBanco)estadoregistroformapagobanco.clone());
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
	
	public  EstadoRegistroFormaPagoBanco getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		EstadoRegistroFormaPagoBanco entity = new EstadoRegistroFormaPagoBanco();		
		
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
	
	public  EstadoRegistroFormaPagoBanco getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		EstadoRegistroFormaPagoBanco entity = new EstadoRegistroFormaPagoBanco();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoRegistroFormaPagoBancoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoRegistroFormaPagoBancoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Tesoreria.EstadoRegistroFormaPagoBanco.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setEstadoRegistroFormaPagoBancoOriginal(new EstadoRegistroFormaPagoBanco());
      	    	entity=super.getEntity("",entity,resultSet,EstadoRegistroFormaPagoBancoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEstadoRegistroFormaPagoBanco("",entity,resultSet); 
				
				//entity.setEstadoRegistroFormaPagoBancoOriginal(super.getEntity("",entity.getEstadoRegistroFormaPagoBancoOriginal(),resultSet,EstadoRegistroFormaPagoBancoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoRegistroFormaPagoBancoOriginal(this.getEntityEstadoRegistroFormaPagoBanco("",entity.getEstadoRegistroFormaPagoBancoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseEstadoRegistroFormaPagoBanco(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  EstadoRegistroFormaPagoBanco getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EstadoRegistroFormaPagoBanco entity = new EstadoRegistroFormaPagoBanco();
				
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
	
	public  EstadoRegistroFormaPagoBanco getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EstadoRegistroFormaPagoBanco entity = new EstadoRegistroFormaPagoBanco();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoRegistroFormaPagoBancoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoRegistroFormaPagoBancoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoRegistroFormaPagoBancoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Tesoreria.EstadoRegistroFormaPagoBanco.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setEstadoRegistroFormaPagoBancoOriginal(new EstadoRegistroFormaPagoBanco());
      	    	entity=super.getEntity("",entity,resultSet,EstadoRegistroFormaPagoBancoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEstadoRegistroFormaPagoBanco("",entity,resultSet);    
				
				//entity.setEstadoRegistroFormaPagoBancoOriginal(super.getEntity("",entity.getEstadoRegistroFormaPagoBancoOriginal(),resultSet,EstadoRegistroFormaPagoBancoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoRegistroFormaPagoBancoOriginal(this.getEntityEstadoRegistroFormaPagoBanco("",entity.getEstadoRegistroFormaPagoBancoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseEstadoRegistroFormaPagoBanco(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //EstadoRegistroFormaPagoBanco
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		EstadoRegistroFormaPagoBanco entity = new EstadoRegistroFormaPagoBanco();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoRegistroFormaPagoBancoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoRegistroFormaPagoBancoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoRegistroFormaPagoBancoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Tesoreria.EstadoRegistroFormaPagoBanco.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseEstadoRegistroFormaPagoBanco(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<EstadoRegistroFormaPagoBanco> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EstadoRegistroFormaPagoBanco> entities = new  ArrayList<EstadoRegistroFormaPagoBanco>();
		EstadoRegistroFormaPagoBanco entity = new EstadoRegistroFormaPagoBanco();		  
		
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
	
	public  List<EstadoRegistroFormaPagoBanco> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EstadoRegistroFormaPagoBanco> entities = new  ArrayList<EstadoRegistroFormaPagoBanco>();
		EstadoRegistroFormaPagoBanco entity = new EstadoRegistroFormaPagoBanco();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoRegistroFormaPagoBancoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoRegistroFormaPagoBancoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoRegistroFormaPagoBancoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoRegistroFormaPagoBanco();
      	    	entity=super.getEntity("",entity,resultSet,EstadoRegistroFormaPagoBancoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoRegistroFormaPagoBanco("",entity,resultSet);
      	    	
				//entity.setEstadoRegistroFormaPagoBancoOriginal( new EstadoRegistroFormaPagoBanco());
      	    	//entity.setEstadoRegistroFormaPagoBancoOriginal(super.getEntity("",entity.getEstadoRegistroFormaPagoBancoOriginal(),resultSet,EstadoRegistroFormaPagoBancoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoRegistroFormaPagoBancoOriginal(this.getEntityEstadoRegistroFormaPagoBanco("",entity.getEstadoRegistroFormaPagoBancoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoRegistroFormaPagoBancos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoRegistroFormaPagoBanco(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<EstadoRegistroFormaPagoBanco> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EstadoRegistroFormaPagoBanco> entities = new  ArrayList<EstadoRegistroFormaPagoBanco>();
		EstadoRegistroFormaPagoBanco entity = new EstadoRegistroFormaPagoBanco();		  
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
	
	public  List<EstadoRegistroFormaPagoBanco> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EstadoRegistroFormaPagoBanco> entities = new  ArrayList<EstadoRegistroFormaPagoBanco>();
		EstadoRegistroFormaPagoBanco entity = new EstadoRegistroFormaPagoBanco();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoRegistroFormaPagoBanco();
				
				if(conMapGenerico) {
					entity.inicializarMapEstadoRegistroFormaPagoBanco();
					//entity.setMapEstadoRegistroFormaPagoBanco(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapEstadoRegistroFormaPagoBancoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEstadoRegistroFormaPagoBanco().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EstadoRegistroFormaPagoBancoDataAccess.ISWITHSCHEMA);         		
					entity=EstadoRegistroFormaPagoBancoDataAccess.getEntityEstadoRegistroFormaPagoBanco("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEstadoRegistroFormaPagoBancoOriginal( new EstadoRegistroFormaPagoBanco());
					////entity.setEstadoRegistroFormaPagoBancoOriginal(super.getEntity("",entity.getEstadoRegistroFormaPagoBancoOriginal(),resultSet,EstadoRegistroFormaPagoBancoDataAccess.ISWITHSCHEMA));         		
					////entity.setEstadoRegistroFormaPagoBancoOriginal(this.getEntityEstadoRegistroFormaPagoBanco("",entity.getEstadoRegistroFormaPagoBancoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoRegistroFormaPagoBancos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoRegistroFormaPagoBanco(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public EstadoRegistroFormaPagoBanco getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EstadoRegistroFormaPagoBanco entity = new EstadoRegistroFormaPagoBanco();		  
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
	
	public  EstadoRegistroFormaPagoBanco getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EstadoRegistroFormaPagoBanco entity = new EstadoRegistroFormaPagoBanco();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoRegistroFormaPagoBanco();
				
				if(conMapGenerico) {
					entity.inicializarMapEstadoRegistroFormaPagoBanco();
					//entity.setMapEstadoRegistroFormaPagoBanco(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapEstadoRegistroFormaPagoBancoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEstadoRegistroFormaPagoBanco().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EstadoRegistroFormaPagoBancoDataAccess.ISWITHSCHEMA);         		
					entity=EstadoRegistroFormaPagoBancoDataAccess.getEntityEstadoRegistroFormaPagoBanco("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEstadoRegistroFormaPagoBancoOriginal( new EstadoRegistroFormaPagoBanco());
					////entity.setEstadoRegistroFormaPagoBancoOriginal(super.getEntity("",entity.getEstadoRegistroFormaPagoBancoOriginal(),resultSet,EstadoRegistroFormaPagoBancoDataAccess.ISWITHSCHEMA));         		
					////entity.setEstadoRegistroFormaPagoBancoOriginal(this.getEntityEstadoRegistroFormaPagoBanco("",entity.getEstadoRegistroFormaPagoBancoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseEstadoRegistroFormaPagoBanco(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoRegistroFormaPagoBanco(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static EstadoRegistroFormaPagoBanco getEntityEstadoRegistroFormaPagoBanco(String strPrefijo,EstadoRegistroFormaPagoBanco entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = EstadoRegistroFormaPagoBanco.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = EstadoRegistroFormaPagoBanco.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					EstadoRegistroFormaPagoBancoDataAccess.setFieldReflectionEstadoRegistroFormaPagoBanco(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasEstadoRegistroFormaPagoBanco=EstadoRegistroFormaPagoBancoConstantesFunciones.getTodosTiposColumnasEstadoRegistroFormaPagoBanco();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasEstadoRegistroFormaPagoBanco) {
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
							field = EstadoRegistroFormaPagoBanco.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = EstadoRegistroFormaPagoBanco.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						EstadoRegistroFormaPagoBancoDataAccess.setFieldReflectionEstadoRegistroFormaPagoBanco(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionEstadoRegistroFormaPagoBanco(Field field,String strPrefijo,String sColumn,EstadoRegistroFormaPagoBanco entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case EstadoRegistroFormaPagoBancoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EstadoRegistroFormaPagoBancoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EstadoRegistroFormaPagoBancoConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EstadoRegistroFormaPagoBancoConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EstadoRegistroFormaPagoBanco>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<EstadoRegistroFormaPagoBanco> entities = new  ArrayList<EstadoRegistroFormaPagoBanco>();
		EstadoRegistroFormaPagoBanco entity = new EstadoRegistroFormaPagoBanco();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoRegistroFormaPagoBancoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoRegistroFormaPagoBancoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoRegistroFormaPagoBancoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new EstadoRegistroFormaPagoBanco();
					entity=super.getEntity("",entity,resultSet,EstadoRegistroFormaPagoBancoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityEstadoRegistroFormaPagoBanco("",entity,resultSet);
					
					//entity.setEstadoRegistroFormaPagoBancoOriginal( new EstadoRegistroFormaPagoBanco());
					//entity.setEstadoRegistroFormaPagoBancoOriginal(super.getEntity("",entity.getEstadoRegistroFormaPagoBancoOriginal(),resultSet,EstadoRegistroFormaPagoBancoDataAccess.ISWITHSCHEMA));         		
					//entity.setEstadoRegistroFormaPagoBancoOriginal(this.getEntityEstadoRegistroFormaPagoBanco("",entity.getEstadoRegistroFormaPagoBancoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseEstadoRegistroFormaPagoBancos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoRegistroFormaPagoBanco(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EstadoRegistroFormaPagoBanco>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<EstadoRegistroFormaPagoBanco> entities = new  ArrayList<EstadoRegistroFormaPagoBanco>();
		EstadoRegistroFormaPagoBanco entity = new EstadoRegistroFormaPagoBanco();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoRegistroFormaPagoBancoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoRegistroFormaPagoBancoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoRegistroFormaPagoBancoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<EstadoRegistroFormaPagoBanco> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoRegistroFormaPagoBanco> entities = new  ArrayList<EstadoRegistroFormaPagoBanco>();
		EstadoRegistroFormaPagoBanco entity = new EstadoRegistroFormaPagoBanco();		  
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
	
	public  List<EstadoRegistroFormaPagoBanco> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoRegistroFormaPagoBanco> entities = new  ArrayList<EstadoRegistroFormaPagoBanco>();
		EstadoRegistroFormaPagoBanco entity = new EstadoRegistroFormaPagoBanco();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoRegistroFormaPagoBanco();
      	    	entity=super.getEntity("",entity,resultSet,EstadoRegistroFormaPagoBancoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoRegistroFormaPagoBanco("",entity,resultSet);
      	    	
				//entity.setEstadoRegistroFormaPagoBancoOriginal( new EstadoRegistroFormaPagoBanco());
      	    	//entity.setEstadoRegistroFormaPagoBancoOriginal(super.getEntity("",entity.getEstadoRegistroFormaPagoBancoOriginal(),resultSet,EstadoRegistroFormaPagoBancoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoRegistroFormaPagoBancoOriginal(this.getEntityEstadoRegistroFormaPagoBanco("",entity.getEstadoRegistroFormaPagoBancoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseEstadoRegistroFormaPagoBancos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoRegistroFormaPagoBanco(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	
	
	public EstadoRegistroFormaPagoBanco getEntityEstadoRegistroFormaPagoBanco(String strPrefijo,EstadoRegistroFormaPagoBanco entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setcodigo(resultSet.getString(strPrefijo+EstadoRegistroFormaPagoBancoConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+EstadoRegistroFormaPagoBancoConstantesFunciones.NOMBRE));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+EstadoRegistroFormaPagoBancoConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowEstadoRegistroFormaPagoBanco(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(EstadoRegistroFormaPagoBanco entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=EstadoRegistroFormaPagoBancoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=EstadoRegistroFormaPagoBancoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=EstadoRegistroFormaPagoBancoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=EstadoRegistroFormaPagoBancoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(EstadoRegistroFormaPagoBancoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,EstadoRegistroFormaPagoBancoDataAccess.TABLENAME,EstadoRegistroFormaPagoBancoDataAccess.ISWITHSTOREPROCEDURES);
			
			EstadoRegistroFormaPagoBancoDataAccess.setEstadoRegistroFormaPagoBancoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
	
		
		public List<RegistroFormaPagoBanco> getRegistroFormaPagoBancos(Connexion connexion,EstadoRegistroFormaPagoBanco estadoregistroformapagobanco)throws SQLException,Exception {

		List<RegistroFormaPagoBanco> registroformapagobancos= new ArrayList<RegistroFormaPagoBanco>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstadoRegistroFormaPagoBancoConstantesFunciones.SCHEMA+".estado_registro_forma_pago_banco ON "+RegistroFormaPagoBancoConstantesFunciones.SCHEMA+".registro_forma_pago_banco.id_estado_registro_forma_pago_banco="+EstadoRegistroFormaPagoBancoConstantesFunciones.SCHEMA+".estado_registro_forma_pago_banco.id WHERE "+EstadoRegistroFormaPagoBancoConstantesFunciones.SCHEMA+".estado_registro_forma_pago_banco.id="+String.valueOf(estadoregistroformapagobanco.getId());
			} else {
				sQuery=" INNER JOIN registroformapagobanco.EstadoRegistroFormaPagoBanco WHERE registroformapagobanco.EstadoRegistroFormaPagoBanco.id="+String.valueOf(estadoregistroformapagobanco.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			RegistroFormaPagoBancoDataAccess registroformapagobancoDataAccess=new RegistroFormaPagoBancoDataAccess();

			registroformapagobancoDataAccess.setConnexionType(this.connexionType);
			registroformapagobancoDataAccess.setParameterDbType(this.parameterDbType);
			registroformapagobancos=registroformapagobancoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return registroformapagobancos;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,EstadoRegistroFormaPagoBanco estadoregistroformapagobanco) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!estadoregistroformapagobanco.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid=new ParameterValue<Long>();
					parameterMaintenanceValueid.setValue(estadoregistroformapagobanco.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(estadoregistroformapagobanco.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(estadoregistroformapagobanco.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!estadoregistroformapagobanco.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(estadoregistroformapagobanco.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(estadoregistroformapagobanco.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(estadoregistroformapagobanco.getId());
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
	
	public void setIsNewIsChangedFalseEstadoRegistroFormaPagoBanco(EstadoRegistroFormaPagoBanco estadoregistroformapagobanco)throws Exception  {		
		estadoregistroformapagobanco.setIsNew(false);
		estadoregistroformapagobanco.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseEstadoRegistroFormaPagoBancos(List<EstadoRegistroFormaPagoBanco> estadoregistroformapagobancos)throws Exception  {				
		for(EstadoRegistroFormaPagoBanco estadoregistroformapagobanco:estadoregistroformapagobancos) {
			estadoregistroformapagobanco.setIsNew(false);
			estadoregistroformapagobanco.setIsChanged(false);
		}
	}
	
	public void generarExportarEstadoRegistroFormaPagoBanco(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
