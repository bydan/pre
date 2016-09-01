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
import com.bydan.erp.inventario.util.*;//RequisicionConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class RequisicionDataAccess extends  RequisicionDataAccessAdditional{ //RequisicionDataAccessAdditional,DataAccessHelper<Requisicion>
	//static Logger logger = Logger.getLogger(RequisicionDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="requisicion";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+RequisicionConstantesFunciones.SCHEMA+"."+RequisicionConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,numero_secuencial,id_tipo_requisicion,fecha,hora,id_empleado,id_estado_requisicion,id_formato,id_bodega_solicitar,descripcion,id_bodega_solicita)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+RequisicionConstantesFunciones.SCHEMA+"."+RequisicionConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,numero_secuencial=?,id_tipo_requisicion=?,fecha=?,hora=?,id_empleado=?,id_estado_requisicion=?,id_formato=?,id_bodega_solicitar=?,descripcion=?,id_bodega_solicita=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+RequisicionConstantesFunciones.SCHEMA+"."+RequisicionConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select requisicion from "+RequisicionConstantesFunciones.SPERSISTENCENAME+" requisicion";
	public static String QUERYSELECTNATIVE="select "+RequisicionConstantesFunciones.SCHEMA+"."+RequisicionConstantesFunciones.TABLENAME+".id,"+RequisicionConstantesFunciones.SCHEMA+"."+RequisicionConstantesFunciones.TABLENAME+".version_row,"+RequisicionConstantesFunciones.SCHEMA+"."+RequisicionConstantesFunciones.TABLENAME+".id_empresa,"+RequisicionConstantesFunciones.SCHEMA+"."+RequisicionConstantesFunciones.TABLENAME+".id_sucursal,"+RequisicionConstantesFunciones.SCHEMA+"."+RequisicionConstantesFunciones.TABLENAME+".numero_secuencial,"+RequisicionConstantesFunciones.SCHEMA+"."+RequisicionConstantesFunciones.TABLENAME+".id_tipo_requisicion,"+RequisicionConstantesFunciones.SCHEMA+"."+RequisicionConstantesFunciones.TABLENAME+".fecha,"+RequisicionConstantesFunciones.SCHEMA+"."+RequisicionConstantesFunciones.TABLENAME+".hora,"+RequisicionConstantesFunciones.SCHEMA+"."+RequisicionConstantesFunciones.TABLENAME+".id_empleado,"+RequisicionConstantesFunciones.SCHEMA+"."+RequisicionConstantesFunciones.TABLENAME+".id_estado_requisicion,"+RequisicionConstantesFunciones.SCHEMA+"."+RequisicionConstantesFunciones.TABLENAME+".id_formato,"+RequisicionConstantesFunciones.SCHEMA+"."+RequisicionConstantesFunciones.TABLENAME+".id_bodega_solicitar,"+RequisicionConstantesFunciones.SCHEMA+"."+RequisicionConstantesFunciones.TABLENAME+".descripcion,"+RequisicionConstantesFunciones.SCHEMA+"."+RequisicionConstantesFunciones.TABLENAME+".id_bodega_solicita from "+RequisicionConstantesFunciones.SCHEMA+"."+RequisicionConstantesFunciones.TABLENAME;//+" as "+RequisicionConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+RequisicionConstantesFunciones.SCHEMA+"."+RequisicionConstantesFunciones.TABLENAME+".id,"+RequisicionConstantesFunciones.SCHEMA+"."+RequisicionConstantesFunciones.TABLENAME+".version_row,"+RequisicionConstantesFunciones.SCHEMA+"."+RequisicionConstantesFunciones.TABLENAME+".numero_secuencial from "+RequisicionConstantesFunciones.SCHEMA+"."+RequisicionConstantesFunciones.TABLENAME;//+" as "+RequisicionConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+RequisicionConstantesFunciones.SCHEMA+"."+RequisicionConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,numero_secuencial=?,id_tipo_requisicion=?,fecha=?,hora=?,id_empleado=?,id_estado_requisicion=?,id_formato=?,id_bodega_solicitar=?,descripcion=?,id_bodega_solicita=?";
	
	public static String STOREPROCEDUREINSERT="call SP_REQUISICION_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_REQUISICION_UPDATE(?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_REQUISICION_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_REQUISICION_SELECT(?,?)";
	
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
	
	
	protected RequisicionDataAccessAdditional requisicionDataAccessAdditional=null;
	
	public RequisicionDataAccessAdditional getRequisicionDataAccessAdditional() {
		return this.requisicionDataAccessAdditional;
	}
	
	public void setRequisicionDataAccessAdditional(RequisicionDataAccessAdditional requisicionDataAccessAdditional) {
		try {
			this.requisicionDataAccessAdditional=requisicionDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public RequisicionDataAccess() {
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
		RequisicionDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		RequisicionDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		RequisicionDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setRequisicionOriginal(Requisicion requisicion)throws Exception  {
		requisicion.setRequisicionOriginal((Requisicion)requisicion.clone());		
	}
	
	public void setRequisicionsOriginal(List<Requisicion> requisicions)throws Exception  {
		
		for(Requisicion requisicion:requisicions){
			requisicion.setRequisicionOriginal((Requisicion)requisicion.clone());
		}
	}
	
	public static void setRequisicionOriginalStatic(Requisicion requisicion)throws Exception  {
		requisicion.setRequisicionOriginal((Requisicion)requisicion.clone());		
	}
	
	public static void setRequisicionsOriginalStatic(List<Requisicion> requisicions)throws Exception  {
		
		for(Requisicion requisicion:requisicions){
			requisicion.setRequisicionOriginal((Requisicion)requisicion.clone());
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
	
	public  Requisicion getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		Requisicion entity = new Requisicion();		
		
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
	
	public  Requisicion getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		Requisicion entity = new Requisicion();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=RequisicionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=RequisicionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.Requisicion.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setRequisicionOriginal(new Requisicion());
      	    	entity=super.getEntity("",entity,resultSet,RequisicionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityRequisicion("",entity,resultSet); 
				
				//entity.setRequisicionOriginal(super.getEntity("",entity.getRequisicionOriginal(),resultSet,RequisicionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRequisicionOriginal(this.getEntityRequisicion("",entity.getRequisicionOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseRequisicion(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  Requisicion getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Requisicion entity = new Requisicion();
				
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
	
	public  Requisicion getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Requisicion entity = new Requisicion();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=RequisicionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=RequisicionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RequisicionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.Requisicion.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setRequisicionOriginal(new Requisicion());
      	    	entity=super.getEntity("",entity,resultSet,RequisicionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityRequisicion("",entity,resultSet);    
				
				//entity.setRequisicionOriginal(super.getEntity("",entity.getRequisicionOriginal(),resultSet,RequisicionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRequisicionOriginal(this.getEntityRequisicion("",entity.getRequisicionOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseRequisicion(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //Requisicion
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		Requisicion entity = new Requisicion();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=RequisicionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=RequisicionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RequisicionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.Requisicion.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseRequisicion(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<Requisicion> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Requisicion> entities = new  ArrayList<Requisicion>();
		Requisicion entity = new Requisicion();		  
		
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
	
	public  List<Requisicion> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Requisicion> entities = new  ArrayList<Requisicion>();
		Requisicion entity = new Requisicion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=RequisicionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=RequisicionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RequisicionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Requisicion();
      	    	entity=super.getEntity("",entity,resultSet,RequisicionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityRequisicion("",entity,resultSet);
      	    	
				//entity.setRequisicionOriginal( new Requisicion());
      	    	//entity.setRequisicionOriginal(super.getEntity("",entity.getRequisicionOriginal(),resultSet,RequisicionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRequisicionOriginal(this.getEntityRequisicion("",entity.getRequisicionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseRequisicions(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRequisicion(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Requisicion> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Requisicion> entities = new  ArrayList<Requisicion>();
		Requisicion entity = new Requisicion();		  
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
	
	public  List<Requisicion> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Requisicion> entities = new  ArrayList<Requisicion>();
		Requisicion entity = new Requisicion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Requisicion();
				
				if(conMapGenerico) {
					entity.inicializarMapRequisicion();
					//entity.setMapRequisicion(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapRequisicionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapRequisicion().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,RequisicionDataAccess.ISWITHSCHEMA);         		
					entity=RequisicionDataAccess.getEntityRequisicion("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setRequisicionOriginal( new Requisicion());
					////entity.setRequisicionOriginal(super.getEntity("",entity.getRequisicionOriginal(),resultSet,RequisicionDataAccess.ISWITHSCHEMA));         		
					////entity.setRequisicionOriginal(this.getEntityRequisicion("",entity.getRequisicionOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseRequisicions(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRequisicion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public Requisicion getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Requisicion entity = new Requisicion();		  
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
	
	public  Requisicion getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Requisicion entity = new Requisicion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Requisicion();
				
				if(conMapGenerico) {
					entity.inicializarMapRequisicion();
					//entity.setMapRequisicion(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapRequisicionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapRequisicion().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,RequisicionDataAccess.ISWITHSCHEMA);         		
					entity=RequisicionDataAccess.getEntityRequisicion("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setRequisicionOriginal( new Requisicion());
					////entity.setRequisicionOriginal(super.getEntity("",entity.getRequisicionOriginal(),resultSet,RequisicionDataAccess.ISWITHSCHEMA));         		
					////entity.setRequisicionOriginal(this.getEntityRequisicion("",entity.getRequisicionOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseRequisicion(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRequisicion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static Requisicion getEntityRequisicion(String strPrefijo,Requisicion entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = Requisicion.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = Requisicion.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					RequisicionDataAccess.setFieldReflectionRequisicion(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasRequisicion=RequisicionConstantesFunciones.getTodosTiposColumnasRequisicion();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasRequisicion) {
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
							field = Requisicion.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = Requisicion.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						RequisicionDataAccess.setFieldReflectionRequisicion(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionRequisicion(Field field,String strPrefijo,String sColumn,Requisicion entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case RequisicionConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RequisicionConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RequisicionConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RequisicionConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RequisicionConstantesFunciones.NUMEROSECUENCIAL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RequisicionConstantesFunciones.IDTIPOREQUISICION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RequisicionConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case RequisicionConstantesFunciones.HORA:
					field.set(entity,resultSet.getTime(sCampo));
					break;
				
				case RequisicionConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RequisicionConstantesFunciones.IDESTADOREQUISICION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RequisicionConstantesFunciones.IDFORMATO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RequisicionConstantesFunciones.IDBODEGASOLICITAR:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RequisicionConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RequisicionConstantesFunciones.IDBODEGASOLICITA:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Requisicion>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<Requisicion> entities = new  ArrayList<Requisicion>();
		Requisicion entity = new Requisicion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=RequisicionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=RequisicionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RequisicionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new Requisicion();
					entity=super.getEntity("",entity,resultSet,RequisicionDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityRequisicion("",entity,resultSet);
					
					//entity.setRequisicionOriginal( new Requisicion());
					//entity.setRequisicionOriginal(super.getEntity("",entity.getRequisicionOriginal(),resultSet,RequisicionDataAccess.ISWITHSCHEMA));         		
					//entity.setRequisicionOriginal(this.getEntityRequisicion("",entity.getRequisicionOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseRequisicions(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRequisicion(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Requisicion>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<Requisicion> entities = new  ArrayList<Requisicion>();
		Requisicion entity = new Requisicion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=RequisicionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=RequisicionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RequisicionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<Requisicion> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Requisicion> entities = new  ArrayList<Requisicion>();
		Requisicion entity = new Requisicion();		  
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
	
	public  List<Requisicion> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Requisicion> entities = new  ArrayList<Requisicion>();
		Requisicion entity = new Requisicion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Requisicion();
      	    	entity=super.getEntity("",entity,resultSet,RequisicionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityRequisicion("",entity,resultSet);
      	    	
				//entity.setRequisicionOriginal( new Requisicion());
      	    	//entity.setRequisicionOriginal(super.getEntity("",entity.getRequisicionOriginal(),resultSet,RequisicionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRequisicionOriginal(this.getEntityRequisicion("",entity.getRequisicionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseRequisicions(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRequisicion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Requisicion> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Requisicion> entities = new  ArrayList<Requisicion>();
		Requisicion entity = new Requisicion();		  
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
	
	public  List<Requisicion> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Requisicion> entities = new  ArrayList<Requisicion>();
		Requisicion entity = new Requisicion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Requisicion();
      	    	entity=super.getEntity("",entity,resultSet,RequisicionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityRequisicion("",entity,resultSet);
      	    	
				//entity.setRequisicionOriginal( new Requisicion());
      	    	//entity.setRequisicionOriginal(super.getEntity("",entity.getRequisicionOriginal(),resultSet,RequisicionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRequisicionOriginal(this.getEntityRequisicion("",entity.getRequisicionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseRequisicions(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public Requisicion getEntityRequisicion(String strPrefijo,Requisicion entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+RequisicionConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+RequisicionConstantesFunciones.IDSUCURSAL));
				entity.setnumero_secuencial(resultSet.getString(strPrefijo+RequisicionConstantesFunciones.NUMEROSECUENCIAL));
				entity.setid_tipo_requisicion(resultSet.getLong(strPrefijo+RequisicionConstantesFunciones.IDTIPOREQUISICION));
				entity.setfecha(new Date(resultSet.getDate(strPrefijo+RequisicionConstantesFunciones.FECHA).getTime()));
				entity.sethora(resultSet.getTime(strPrefijo+RequisicionConstantesFunciones.HORA));
				entity.setid_empleado(resultSet.getLong(strPrefijo+RequisicionConstantesFunciones.IDEMPLEADO));
				entity.setid_estado_requisicion(resultSet.getLong(strPrefijo+RequisicionConstantesFunciones.IDESTADOREQUISICION));
				entity.setid_formato(resultSet.getLong(strPrefijo+RequisicionConstantesFunciones.IDFORMATO));
				entity.setid_bodega_solicitar(resultSet.getLong(strPrefijo+RequisicionConstantesFunciones.IDBODEGASOLICITAR));
				entity.setdescripcion(resultSet.getString(strPrefijo+RequisicionConstantesFunciones.DESCRIPCION));
				entity.setid_bodega_solicita(resultSet.getLong(strPrefijo+RequisicionConstantesFunciones.IDBODEGASOLICITA));
			} else {
				entity.setnumero_secuencial(resultSet.getString(strPrefijo+RequisicionConstantesFunciones.NUMEROSECUENCIAL));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowRequisicion(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(Requisicion entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=RequisicionDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=RequisicionDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=RequisicionDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=RequisicionDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(RequisicionConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,RequisicionDataAccess.TABLENAME,RequisicionDataAccess.ISWITHSTOREPROCEDURES);
			
			RequisicionDataAccess.setRequisicionOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,Requisicion relrequisicion)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relrequisicion.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,Requisicion relrequisicion)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relrequisicion.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public TipoRequisicion getTipoRequisicion(Connexion connexion,Requisicion relrequisicion)throws SQLException,Exception {

		TipoRequisicion tiporequisicion= new TipoRequisicion();

		try {
			TipoRequisicionDataAccess tiporequisicionDataAccess=new TipoRequisicionDataAccess();

			tiporequisicionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tiporequisicionDataAccess.setConnexionType(this.connexionType);
			tiporequisicionDataAccess.setParameterDbType(this.parameterDbType);

			tiporequisicion=tiporequisicionDataAccess.getEntity(connexion,relrequisicion.getid_tipo_requisicion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tiporequisicion;

	}

	public Empleado getEmpleado(Connexion connexion,Requisicion relrequisicion)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relrequisicion.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public EstadoRequisicion getEstadoRequisicion(Connexion connexion,Requisicion relrequisicion)throws SQLException,Exception {

		EstadoRequisicion estadorequisicion= new EstadoRequisicion();

		try {
			EstadoRequisicionDataAccess estadorequisicionDataAccess=new EstadoRequisicionDataAccess();

			estadorequisicionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadorequisicionDataAccess.setConnexionType(this.connexionType);
			estadorequisicionDataAccess.setParameterDbType(this.parameterDbType);

			estadorequisicion=estadorequisicionDataAccess.getEntity(connexion,relrequisicion.getid_estado_requisicion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadorequisicion;

	}

	public Formato getFormato(Connexion connexion,Requisicion relrequisicion)throws SQLException,Exception {

		Formato formato= new Formato();

		try {
			FormatoDataAccess formatoDataAccess=new FormatoDataAccess();

			formatoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			formatoDataAccess.setConnexionType(this.connexionType);
			formatoDataAccess.setParameterDbType(this.parameterDbType);

			formato=formatoDataAccess.getEntity(connexion,relrequisicion.getid_formato());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formato;

	}

	public Bodega getBodegaSolicitar(Connexion connexion,Requisicion relrequisicion)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);

			bodega=bodegaDataAccess.getEntity(connexion,relrequisicion.getid_bodega_solicitar());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}

	public Bodega getBodegaSolicita(Connexion connexion,Requisicion relrequisicion)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);

			bodega=bodegaDataAccess.getEntity(connexion,relrequisicion.getid_bodega_solicita());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}


		
		public List<DetalleRequisicion> getDetalleRequisicions(Connexion connexion,Requisicion requisicion)throws SQLException,Exception {

		List<DetalleRequisicion> detallerequisicions= new ArrayList<DetalleRequisicion>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+RequisicionConstantesFunciones.SCHEMA+".requisicion ON "+DetalleRequisicionConstantesFunciones.SCHEMA+".detalle_requisicion.id_requisicion="+RequisicionConstantesFunciones.SCHEMA+".requisicion.id WHERE "+RequisicionConstantesFunciones.SCHEMA+".requisicion.id="+String.valueOf(requisicion.getId());
			} else {
				sQuery=" INNER JOIN detallerequisicion.Requisicion WHERE detallerequisicion.Requisicion.id="+String.valueOf(requisicion.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleRequisicionDataAccess detallerequisicionDataAccess=new DetalleRequisicionDataAccess();

			detallerequisicionDataAccess.setConnexionType(this.connexionType);
			detallerequisicionDataAccess.setParameterDbType(this.parameterDbType);
			detallerequisicions=detallerequisicionDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detallerequisicions;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,Requisicion requisicion) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!requisicion.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(requisicion.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(requisicion.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_secuencial=new ParameterValue<String>();
					parameterMaintenanceValuenumero_secuencial.setValue(requisicion.getnumero_secuencial());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_secuencial);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_requisicion=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_requisicion.setValue(requisicion.getid_tipo_requisicion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_requisicion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha=new ParameterValue<Date>();
					parameterMaintenanceValuefecha.setValue(requisicion.getfecha());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.TIME);
					ParameterValue<Time> parameterMaintenanceValuehora=new ParameterValue<Time>();
					parameterMaintenanceValuehora.setValue(requisicion.gethora());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuehora);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(requisicion.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_requisicion=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_requisicion.setValue(requisicion.getid_estado_requisicion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_requisicion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_formato=new ParameterValue<Long>();
					parameterMaintenanceValueid_formato.setValue(requisicion.getid_formato());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_formato);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_bodega_solicitar=new ParameterValue<Long>();
					parameterMaintenanceValueid_bodega_solicitar.setValue(requisicion.getid_bodega_solicitar());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_bodega_solicitar);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(requisicion.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_bodega_solicita=new ParameterValue<Long>();
					parameterMaintenanceValueid_bodega_solicita.setValue(requisicion.getid_bodega_solicita());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_bodega_solicita);
					parametersTemp.add(parameterMaintenance);
					
						if(!requisicion.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(requisicion.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(requisicion.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(requisicion.getId());
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
	
	public void setIsNewIsChangedFalseRequisicion(Requisicion requisicion)throws Exception  {		
		requisicion.setIsNew(false);
		requisicion.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseRequisicions(List<Requisicion> requisicions)throws Exception  {				
		for(Requisicion requisicion:requisicions) {
			requisicion.setIsNew(false);
			requisicion.setIsChanged(false);
		}
	}
	
	public void generarExportarRequisicion(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
