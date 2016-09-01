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
package com.bydan.erp.contabilidad.business.dataaccess;

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

import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.contabilidad.util.*;//EstadoAsientoContableConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;




@SuppressWarnings("unused")
final public class EstadoAsientoContableDataAccess extends  DataAccessHelperSinIdGenerated<EstadoAsientoContable>{ //EstadoAsientoContableDataAccessAdditional,DataAccessHelper<EstadoAsientoContable>
	//static Logger logger = Logger.getLogger(EstadoAsientoContableDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="estado_asiento_contable";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+EstadoAsientoContableConstantesFunciones.SCHEMA+"."+EstadoAsientoContableConstantesFunciones.TABLENAME+"(id,version_row,codigo,nombre,id_color_general)values(?,current_timestamp,?,?,?)";
	public static String QUERYUPDATE="update "+EstadoAsientoContableConstantesFunciones.SCHEMA+"."+EstadoAsientoContableConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=?,id_color_general=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+EstadoAsientoContableConstantesFunciones.SCHEMA+"."+EstadoAsientoContableConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select estadoasientocontable from "+EstadoAsientoContableConstantesFunciones.SPERSISTENCENAME+" estadoasientocontable";
	public static String QUERYSELECTNATIVE="select "+EstadoAsientoContableConstantesFunciones.SCHEMA+"."+EstadoAsientoContableConstantesFunciones.TABLENAME+".id,"+EstadoAsientoContableConstantesFunciones.SCHEMA+"."+EstadoAsientoContableConstantesFunciones.TABLENAME+".version_row,"+EstadoAsientoContableConstantesFunciones.SCHEMA+"."+EstadoAsientoContableConstantesFunciones.TABLENAME+".codigo,"+EstadoAsientoContableConstantesFunciones.SCHEMA+"."+EstadoAsientoContableConstantesFunciones.TABLENAME+".nombre,"+EstadoAsientoContableConstantesFunciones.SCHEMA+"."+EstadoAsientoContableConstantesFunciones.TABLENAME+".id_color_general from "+EstadoAsientoContableConstantesFunciones.SCHEMA+"."+EstadoAsientoContableConstantesFunciones.TABLENAME;//+" as "+EstadoAsientoContableConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+EstadoAsientoContableConstantesFunciones.SCHEMA+"."+EstadoAsientoContableConstantesFunciones.TABLENAME+".id,"+EstadoAsientoContableConstantesFunciones.SCHEMA+"."+EstadoAsientoContableConstantesFunciones.TABLENAME+".version_row,"+EstadoAsientoContableConstantesFunciones.SCHEMA+"."+EstadoAsientoContableConstantesFunciones.TABLENAME+".codigo from "+EstadoAsientoContableConstantesFunciones.SCHEMA+"."+EstadoAsientoContableConstantesFunciones.TABLENAME;//+" as "+EstadoAsientoContableConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+EstadoAsientoContableConstantesFunciones.SCHEMA+"."+EstadoAsientoContableConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=?,id_color_general=?";
	
	public static String STOREPROCEDUREINSERT="call SP_ESTADOASIENTOCONTABLE_INSERT(?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_ESTADOASIENTOCONTABLE_UPDATE(?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_ESTADOASIENTOCONTABLE_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_ESTADOASIENTOCONTABLE_SELECT(?,?)";
	
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
	
	
	public EstadoAsientoContableDataAccess() {
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
		EstadoAsientoContableDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		EstadoAsientoContableDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		EstadoAsientoContableDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setEstadoAsientoContableOriginal(EstadoAsientoContable estadoasientocontable)throws Exception  {
		estadoasientocontable.setEstadoAsientoContableOriginal((EstadoAsientoContable)estadoasientocontable.clone());		
	}
	
	public void setEstadoAsientoContablesOriginal(List<EstadoAsientoContable> estadoasientocontables)throws Exception  {
		
		for(EstadoAsientoContable estadoasientocontable:estadoasientocontables){
			estadoasientocontable.setEstadoAsientoContableOriginal((EstadoAsientoContable)estadoasientocontable.clone());
		}
	}
	
	public static void setEstadoAsientoContableOriginalStatic(EstadoAsientoContable estadoasientocontable)throws Exception  {
		estadoasientocontable.setEstadoAsientoContableOriginal((EstadoAsientoContable)estadoasientocontable.clone());		
	}
	
	public static void setEstadoAsientoContablesOriginalStatic(List<EstadoAsientoContable> estadoasientocontables)throws Exception  {
		
		for(EstadoAsientoContable estadoasientocontable:estadoasientocontables){
			estadoasientocontable.setEstadoAsientoContableOriginal((EstadoAsientoContable)estadoasientocontable.clone());
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
	
	public  EstadoAsientoContable getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		EstadoAsientoContable entity = new EstadoAsientoContable();		
		
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
	
	public  EstadoAsientoContable getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		EstadoAsientoContable entity = new EstadoAsientoContable();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoAsientoContableDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoAsientoContableDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Contabilidad.EstadoAsientoContable.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setEstadoAsientoContableOriginal(new EstadoAsientoContable());
      	    	entity=super.getEntity("",entity,resultSet,EstadoAsientoContableDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEstadoAsientoContable("",entity,resultSet); 
				
				//entity.setEstadoAsientoContableOriginal(super.getEntity("",entity.getEstadoAsientoContableOriginal(),resultSet,EstadoAsientoContableDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoAsientoContableOriginal(this.getEntityEstadoAsientoContable("",entity.getEstadoAsientoContableOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseEstadoAsientoContable(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  EstadoAsientoContable getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EstadoAsientoContable entity = new EstadoAsientoContable();
				
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
	
	public  EstadoAsientoContable getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EstadoAsientoContable entity = new EstadoAsientoContable();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoAsientoContableDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoAsientoContableDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoAsientoContableDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.EstadoAsientoContable.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setEstadoAsientoContableOriginal(new EstadoAsientoContable());
      	    	entity=super.getEntity("",entity,resultSet,EstadoAsientoContableDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEstadoAsientoContable("",entity,resultSet);    
				
				//entity.setEstadoAsientoContableOriginal(super.getEntity("",entity.getEstadoAsientoContableOriginal(),resultSet,EstadoAsientoContableDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoAsientoContableOriginal(this.getEntityEstadoAsientoContable("",entity.getEstadoAsientoContableOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseEstadoAsientoContable(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //EstadoAsientoContable
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		EstadoAsientoContable entity = new EstadoAsientoContable();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoAsientoContableDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoAsientoContableDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoAsientoContableDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.EstadoAsientoContable.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseEstadoAsientoContable(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<EstadoAsientoContable> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EstadoAsientoContable> entities = new  ArrayList<EstadoAsientoContable>();
		EstadoAsientoContable entity = new EstadoAsientoContable();		  
		
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
	
	public  List<EstadoAsientoContable> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EstadoAsientoContable> entities = new  ArrayList<EstadoAsientoContable>();
		EstadoAsientoContable entity = new EstadoAsientoContable();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoAsientoContableDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoAsientoContableDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoAsientoContableDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoAsientoContable();
      	    	entity=super.getEntity("",entity,resultSet,EstadoAsientoContableDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoAsientoContable("",entity,resultSet);
      	    	
				//entity.setEstadoAsientoContableOriginal( new EstadoAsientoContable());
      	    	//entity.setEstadoAsientoContableOriginal(super.getEntity("",entity.getEstadoAsientoContableOriginal(),resultSet,EstadoAsientoContableDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoAsientoContableOriginal(this.getEntityEstadoAsientoContable("",entity.getEstadoAsientoContableOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoAsientoContables(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoAsientoContable(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<EstadoAsientoContable> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EstadoAsientoContable> entities = new  ArrayList<EstadoAsientoContable>();
		EstadoAsientoContable entity = new EstadoAsientoContable();		  
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
	
	public  List<EstadoAsientoContable> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EstadoAsientoContable> entities = new  ArrayList<EstadoAsientoContable>();
		EstadoAsientoContable entity = new EstadoAsientoContable();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoAsientoContable();
				
				if(conMapGenerico) {
					entity.inicializarMapEstadoAsientoContable();
					//entity.setMapEstadoAsientoContable(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapEstadoAsientoContableValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEstadoAsientoContable().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EstadoAsientoContableDataAccess.ISWITHSCHEMA);         		
					entity=EstadoAsientoContableDataAccess.getEntityEstadoAsientoContable("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEstadoAsientoContableOriginal( new EstadoAsientoContable());
					////entity.setEstadoAsientoContableOriginal(super.getEntity("",entity.getEstadoAsientoContableOriginal(),resultSet,EstadoAsientoContableDataAccess.ISWITHSCHEMA));         		
					////entity.setEstadoAsientoContableOriginal(this.getEntityEstadoAsientoContable("",entity.getEstadoAsientoContableOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoAsientoContables(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoAsientoContable(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public EstadoAsientoContable getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EstadoAsientoContable entity = new EstadoAsientoContable();		  
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
	
	public  EstadoAsientoContable getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EstadoAsientoContable entity = new EstadoAsientoContable();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoAsientoContable();
				
				if(conMapGenerico) {
					entity.inicializarMapEstadoAsientoContable();
					//entity.setMapEstadoAsientoContable(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapEstadoAsientoContableValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEstadoAsientoContable().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EstadoAsientoContableDataAccess.ISWITHSCHEMA);         		
					entity=EstadoAsientoContableDataAccess.getEntityEstadoAsientoContable("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEstadoAsientoContableOriginal( new EstadoAsientoContable());
					////entity.setEstadoAsientoContableOriginal(super.getEntity("",entity.getEstadoAsientoContableOriginal(),resultSet,EstadoAsientoContableDataAccess.ISWITHSCHEMA));         		
					////entity.setEstadoAsientoContableOriginal(this.getEntityEstadoAsientoContable("",entity.getEstadoAsientoContableOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseEstadoAsientoContable(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoAsientoContable(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static EstadoAsientoContable getEntityEstadoAsientoContable(String strPrefijo,EstadoAsientoContable entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = EstadoAsientoContable.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = EstadoAsientoContable.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					EstadoAsientoContableDataAccess.setFieldReflectionEstadoAsientoContable(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasEstadoAsientoContable=EstadoAsientoContableConstantesFunciones.getTodosTiposColumnasEstadoAsientoContable();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasEstadoAsientoContable) {
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
							field = EstadoAsientoContable.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = EstadoAsientoContable.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						EstadoAsientoContableDataAccess.setFieldReflectionEstadoAsientoContable(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionEstadoAsientoContable(Field field,String strPrefijo,String sColumn,EstadoAsientoContable entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case EstadoAsientoContableConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EstadoAsientoContableConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EstadoAsientoContableConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EstadoAsientoContableConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EstadoAsientoContableConstantesFunciones.IDCOLORGENERAL:
					field.set(entity,resultSet.getLong(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EstadoAsientoContable>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<EstadoAsientoContable> entities = new  ArrayList<EstadoAsientoContable>();
		EstadoAsientoContable entity = new EstadoAsientoContable();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoAsientoContableDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoAsientoContableDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoAsientoContableDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new EstadoAsientoContable();
					entity=super.getEntity("",entity,resultSet,EstadoAsientoContableDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityEstadoAsientoContable("",entity,resultSet);
					
					//entity.setEstadoAsientoContableOriginal( new EstadoAsientoContable());
					//entity.setEstadoAsientoContableOriginal(super.getEntity("",entity.getEstadoAsientoContableOriginal(),resultSet,EstadoAsientoContableDataAccess.ISWITHSCHEMA));         		
					//entity.setEstadoAsientoContableOriginal(this.getEntityEstadoAsientoContable("",entity.getEstadoAsientoContableOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseEstadoAsientoContables(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoAsientoContable(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EstadoAsientoContable>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<EstadoAsientoContable> entities = new  ArrayList<EstadoAsientoContable>();
		EstadoAsientoContable entity = new EstadoAsientoContable();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoAsientoContableDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoAsientoContableDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoAsientoContableDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<EstadoAsientoContable> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoAsientoContable> entities = new  ArrayList<EstadoAsientoContable>();
		EstadoAsientoContable entity = new EstadoAsientoContable();		  
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
	
	public  List<EstadoAsientoContable> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoAsientoContable> entities = new  ArrayList<EstadoAsientoContable>();
		EstadoAsientoContable entity = new EstadoAsientoContable();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoAsientoContable();
      	    	entity=super.getEntity("",entity,resultSet,EstadoAsientoContableDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoAsientoContable("",entity,resultSet);
      	    	
				//entity.setEstadoAsientoContableOriginal( new EstadoAsientoContable());
      	    	//entity.setEstadoAsientoContableOriginal(super.getEntity("",entity.getEstadoAsientoContableOriginal(),resultSet,EstadoAsientoContableDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoAsientoContableOriginal(this.getEntityEstadoAsientoContable("",entity.getEstadoAsientoContableOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseEstadoAsientoContables(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoAsientoContable(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	
	
	public EstadoAsientoContable getEntityEstadoAsientoContable(String strPrefijo,EstadoAsientoContable entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setcodigo(resultSet.getString(strPrefijo+EstadoAsientoContableConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+EstadoAsientoContableConstantesFunciones.NOMBRE));
				entity.setid_color_general(resultSet.getLong(strPrefijo+EstadoAsientoContableConstantesFunciones.IDCOLORGENERAL));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+EstadoAsientoContableConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowEstadoAsientoContable(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(EstadoAsientoContable entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=EstadoAsientoContableDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=EstadoAsientoContableDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=EstadoAsientoContableDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=EstadoAsientoContableDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(EstadoAsientoContableConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,EstadoAsientoContableDataAccess.TABLENAME,EstadoAsientoContableDataAccess.ISWITHSTOREPROCEDURES);
			
			EstadoAsientoContableDataAccess.setEstadoAsientoContableOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public ColorGeneral getColorGeneral(Connexion connexion,EstadoAsientoContable relestadoasientocontable)throws SQLException,Exception {

		ColorGeneral colorgeneral= new ColorGeneral();

		try {
			ColorGeneralDataAccess colorgeneralDataAccess=new ColorGeneralDataAccess();

			colorgeneralDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			colorgeneralDataAccess.setConnexionType(this.connexionType);
			colorgeneralDataAccess.setParameterDbType(this.parameterDbType);

			colorgeneral=colorgeneralDataAccess.getEntity(connexion,relestadoasientocontable.getid_color_general());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return colorgeneral;

	}


		
		public List<ParametroContabilidadDefecto> getParametroContabilidadDefectos(Connexion connexion,EstadoAsientoContable estadoasientocontable)throws SQLException,Exception {

		List<ParametroContabilidadDefecto> parametrocontabilidaddefectos= new ArrayList<ParametroContabilidadDefecto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstadoAsientoContableConstantesFunciones.SCHEMA+".estado_asiento_contable ON "+ParametroContabilidadDefectoConstantesFunciones.SCHEMA+".parametro_contabilidad_defecto.id_estado_asiento_contable="+EstadoAsientoContableConstantesFunciones.SCHEMA+".estado_asiento_contable.id WHERE "+EstadoAsientoContableConstantesFunciones.SCHEMA+".estado_asiento_contable.id="+String.valueOf(estadoasientocontable.getId());
			} else {
				sQuery=" INNER JOIN parametrocontabilidaddefecto.EstadoAsientoContable WHERE parametrocontabilidaddefecto.EstadoAsientoContable.id="+String.valueOf(estadoasientocontable.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ParametroContabilidadDefectoDataAccess parametrocontabilidaddefectoDataAccess=new ParametroContabilidadDefectoDataAccess();

			parametrocontabilidaddefectoDataAccess.setConnexionType(this.connexionType);
			parametrocontabilidaddefectoDataAccess.setParameterDbType(this.parameterDbType);
			parametrocontabilidaddefectos=parametrocontabilidaddefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return parametrocontabilidaddefectos;

	}

	public List<AsientoContable> getAsientoContables(Connexion connexion,EstadoAsientoContable estadoasientocontable)throws SQLException,Exception {

		List<AsientoContable> asientocontables= new ArrayList<AsientoContable>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstadoAsientoContableConstantesFunciones.SCHEMA+".estado_asiento_contable ON "+AsientoContableConstantesFunciones.SCHEMA+".asiento_contable.id_estado_asiento_contable="+EstadoAsientoContableConstantesFunciones.SCHEMA+".estado_asiento_contable.id WHERE "+EstadoAsientoContableConstantesFunciones.SCHEMA+".estado_asiento_contable.id="+String.valueOf(estadoasientocontable.getId());
			} else {
				sQuery=" INNER JOIN asientocontable.EstadoAsientoContable WHERE asientocontable.EstadoAsientoContable.id="+String.valueOf(estadoasientocontable.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			AsientoContableDataAccess asientocontableDataAccess=new AsientoContableDataAccess();

			asientocontableDataAccess.setConnexionType(this.connexionType);
			asientocontableDataAccess.setParameterDbType(this.parameterDbType);
			asientocontables=asientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return asientocontables;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,EstadoAsientoContable estadoasientocontable) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!estadoasientocontable.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid=new ParameterValue<Long>();
					parameterMaintenanceValueid.setValue(estadoasientocontable.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(estadoasientocontable.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(estadoasientocontable.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_color_general=new ParameterValue<Long>();
					parameterMaintenanceValueid_color_general.setValue(estadoasientocontable.getid_color_general());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_color_general);
					parametersTemp.add(parameterMaintenance);
					
						if(!estadoasientocontable.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(estadoasientocontable.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(estadoasientocontable.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(estadoasientocontable.getId());
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
	
	public void setIsNewIsChangedFalseEstadoAsientoContable(EstadoAsientoContable estadoasientocontable)throws Exception  {		
		estadoasientocontable.setIsNew(false);
		estadoasientocontable.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseEstadoAsientoContables(List<EstadoAsientoContable> estadoasientocontables)throws Exception  {				
		for(EstadoAsientoContable estadoasientocontable:estadoasientocontables) {
			estadoasientocontable.setIsNew(false);
			estadoasientocontable.setIsChanged(false);
		}
	}
	
	public void generarExportarEstadoAsientoContable(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
