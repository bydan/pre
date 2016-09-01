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
import com.bydan.framework.erp.business.dataaccess.DataAccessHelper;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.cartera.util.*;//EvaluacionProveedorConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class EvaluacionProveedorDataAccess extends  EvaluacionProveedorDataAccessAdditional{ //EvaluacionProveedorDataAccessAdditional,DataAccessHelper<EvaluacionProveedor>
	//static Logger logger = Logger.getLogger(EvaluacionProveedorDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="evaluacion_proveedor";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+EvaluacionProveedorConstantesFunciones.SCHEMA+"."+EvaluacionProveedorConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_ejercicio,id_periodo,id_cliente,fecha,contacto,evaluado,resultado,responsable,fecha_desde,fecha_hasta,observacion)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+EvaluacionProveedorConstantesFunciones.SCHEMA+"."+EvaluacionProveedorConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_cliente=?,fecha=?,contacto=?,evaluado=?,resultado=?,responsable=?,fecha_desde=?,fecha_hasta=?,observacion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+EvaluacionProveedorConstantesFunciones.SCHEMA+"."+EvaluacionProveedorConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select evaluacionproveedor from "+EvaluacionProveedorConstantesFunciones.SPERSISTENCENAME+" evaluacionproveedor";
	public static String QUERYSELECTNATIVE="select "+EvaluacionProveedorConstantesFunciones.SCHEMA+"."+EvaluacionProveedorConstantesFunciones.TABLENAME+".id,"+EvaluacionProveedorConstantesFunciones.SCHEMA+"."+EvaluacionProveedorConstantesFunciones.TABLENAME+".version_row,"+EvaluacionProveedorConstantesFunciones.SCHEMA+"."+EvaluacionProveedorConstantesFunciones.TABLENAME+".id_empresa,"+EvaluacionProveedorConstantesFunciones.SCHEMA+"."+EvaluacionProveedorConstantesFunciones.TABLENAME+".id_sucursal,"+EvaluacionProveedorConstantesFunciones.SCHEMA+"."+EvaluacionProveedorConstantesFunciones.TABLENAME+".id_ejercicio,"+EvaluacionProveedorConstantesFunciones.SCHEMA+"."+EvaluacionProveedorConstantesFunciones.TABLENAME+".id_periodo,"+EvaluacionProveedorConstantesFunciones.SCHEMA+"."+EvaluacionProveedorConstantesFunciones.TABLENAME+".id_cliente,"+EvaluacionProveedorConstantesFunciones.SCHEMA+"."+EvaluacionProveedorConstantesFunciones.TABLENAME+".fecha,"+EvaluacionProveedorConstantesFunciones.SCHEMA+"."+EvaluacionProveedorConstantesFunciones.TABLENAME+".contacto,"+EvaluacionProveedorConstantesFunciones.SCHEMA+"."+EvaluacionProveedorConstantesFunciones.TABLENAME+".evaluado,"+EvaluacionProveedorConstantesFunciones.SCHEMA+"."+EvaluacionProveedorConstantesFunciones.TABLENAME+".resultado,"+EvaluacionProveedorConstantesFunciones.SCHEMA+"."+EvaluacionProveedorConstantesFunciones.TABLENAME+".responsable,"+EvaluacionProveedorConstantesFunciones.SCHEMA+"."+EvaluacionProveedorConstantesFunciones.TABLENAME+".fecha_desde,"+EvaluacionProveedorConstantesFunciones.SCHEMA+"."+EvaluacionProveedorConstantesFunciones.TABLENAME+".fecha_hasta,"+EvaluacionProveedorConstantesFunciones.SCHEMA+"."+EvaluacionProveedorConstantesFunciones.TABLENAME+".observacion from "+EvaluacionProveedorConstantesFunciones.SCHEMA+"."+EvaluacionProveedorConstantesFunciones.TABLENAME;//+" as "+EvaluacionProveedorConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+EvaluacionProveedorConstantesFunciones.SCHEMA+"."+EvaluacionProveedorConstantesFunciones.TABLENAME+".id,"+EvaluacionProveedorConstantesFunciones.SCHEMA+"."+EvaluacionProveedorConstantesFunciones.TABLENAME+".version_row from "+EvaluacionProveedorConstantesFunciones.SCHEMA+"."+EvaluacionProveedorConstantesFunciones.TABLENAME;//+" as "+EvaluacionProveedorConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+EvaluacionProveedorConstantesFunciones.SCHEMA+"."+EvaluacionProveedorConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_cliente=?,fecha=?,contacto=?,evaluado=?,resultado=?,responsable=?,fecha_desde=?,fecha_hasta=?,observacion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_EVALUACIONPROVEEDOR_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_EVALUACIONPROVEEDOR_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_EVALUACIONPROVEEDOR_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_EVALUACIONPROVEEDOR_SELECT(?,?)";
	
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
	
	
	protected EvaluacionProveedorDataAccessAdditional evaluacionproveedorDataAccessAdditional=null;
	
	public EvaluacionProveedorDataAccessAdditional getEvaluacionProveedorDataAccessAdditional() {
		return this.evaluacionproveedorDataAccessAdditional;
	}
	
	public void setEvaluacionProveedorDataAccessAdditional(EvaluacionProveedorDataAccessAdditional evaluacionproveedorDataAccessAdditional) {
		try {
			this.evaluacionproveedorDataAccessAdditional=evaluacionproveedorDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public EvaluacionProveedorDataAccess() {
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
		EvaluacionProveedorDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		EvaluacionProveedorDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		EvaluacionProveedorDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setEvaluacionProveedorOriginal(EvaluacionProveedor evaluacionproveedor)throws Exception  {
		evaluacionproveedor.setEvaluacionProveedorOriginal((EvaluacionProveedor)evaluacionproveedor.clone());		
	}
	
	public void setEvaluacionProveedorsOriginal(List<EvaluacionProveedor> evaluacionproveedors)throws Exception  {
		
		for(EvaluacionProveedor evaluacionproveedor:evaluacionproveedors){
			evaluacionproveedor.setEvaluacionProveedorOriginal((EvaluacionProveedor)evaluacionproveedor.clone());
		}
	}
	
	public static void setEvaluacionProveedorOriginalStatic(EvaluacionProveedor evaluacionproveedor)throws Exception  {
		evaluacionproveedor.setEvaluacionProveedorOriginal((EvaluacionProveedor)evaluacionproveedor.clone());		
	}
	
	public static void setEvaluacionProveedorsOriginalStatic(List<EvaluacionProveedor> evaluacionproveedors)throws Exception  {
		
		for(EvaluacionProveedor evaluacionproveedor:evaluacionproveedors){
			evaluacionproveedor.setEvaluacionProveedorOriginal((EvaluacionProveedor)evaluacionproveedor.clone());
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
	
	public  EvaluacionProveedor getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		EvaluacionProveedor entity = new EvaluacionProveedor();		
		
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
	
	public  EvaluacionProveedor getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		EvaluacionProveedor entity = new EvaluacionProveedor();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EvaluacionProveedorDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EvaluacionProveedorDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Cartera.EvaluacionProveedor.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setEvaluacionProveedorOriginal(new EvaluacionProveedor());
      	    	entity=super.getEntity("",entity,resultSet,EvaluacionProveedorDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEvaluacionProveedor("",entity,resultSet); 
				
				//entity.setEvaluacionProveedorOriginal(super.getEntity("",entity.getEvaluacionProveedorOriginal(),resultSet,EvaluacionProveedorDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEvaluacionProveedorOriginal(this.getEntityEvaluacionProveedor("",entity.getEvaluacionProveedorOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseEvaluacionProveedor(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  EvaluacionProveedor getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EvaluacionProveedor entity = new EvaluacionProveedor();
				
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
	
	public  EvaluacionProveedor getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EvaluacionProveedor entity = new EvaluacionProveedor();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EvaluacionProveedorDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EvaluacionProveedorDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EvaluacionProveedorDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.EvaluacionProveedor.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setEvaluacionProveedorOriginal(new EvaluacionProveedor());
      	    	entity=super.getEntity("",entity,resultSet,EvaluacionProveedorDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEvaluacionProveedor("",entity,resultSet);    
				
				//entity.setEvaluacionProveedorOriginal(super.getEntity("",entity.getEvaluacionProveedorOriginal(),resultSet,EvaluacionProveedorDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEvaluacionProveedorOriginal(this.getEntityEvaluacionProveedor("",entity.getEvaluacionProveedorOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseEvaluacionProveedor(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //EvaluacionProveedor
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		EvaluacionProveedor entity = new EvaluacionProveedor();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EvaluacionProveedorDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EvaluacionProveedorDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EvaluacionProveedorDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.EvaluacionProveedor.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseEvaluacionProveedor(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<EvaluacionProveedor> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EvaluacionProveedor> entities = new  ArrayList<EvaluacionProveedor>();
		EvaluacionProveedor entity = new EvaluacionProveedor();		  
		
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
	
	public  List<EvaluacionProveedor> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EvaluacionProveedor> entities = new  ArrayList<EvaluacionProveedor>();
		EvaluacionProveedor entity = new EvaluacionProveedor();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=EvaluacionProveedorDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EvaluacionProveedorDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EvaluacionProveedorDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EvaluacionProveedor();
      	    	entity=super.getEntity("",entity,resultSet,EvaluacionProveedorDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEvaluacionProveedor("",entity,resultSet);
      	    	
				//entity.setEvaluacionProveedorOriginal( new EvaluacionProveedor());
      	    	//entity.setEvaluacionProveedorOriginal(super.getEntity("",entity.getEvaluacionProveedorOriginal(),resultSet,EvaluacionProveedorDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEvaluacionProveedorOriginal(this.getEntityEvaluacionProveedor("",entity.getEvaluacionProveedorOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEvaluacionProveedors(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEvaluacionProveedor(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<EvaluacionProveedor> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EvaluacionProveedor> entities = new  ArrayList<EvaluacionProveedor>();
		EvaluacionProveedor entity = new EvaluacionProveedor();		  
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
	
	public  List<EvaluacionProveedor> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EvaluacionProveedor> entities = new  ArrayList<EvaluacionProveedor>();
		EvaluacionProveedor entity = new EvaluacionProveedor();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EvaluacionProveedor();
				
				if(conMapGenerico) {
					entity.inicializarMapEvaluacionProveedor();
					//entity.setMapEvaluacionProveedor(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapEvaluacionProveedorValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEvaluacionProveedor().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EvaluacionProveedorDataAccess.ISWITHSCHEMA);         		
					entity=EvaluacionProveedorDataAccess.getEntityEvaluacionProveedor("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEvaluacionProveedorOriginal( new EvaluacionProveedor());
					////entity.setEvaluacionProveedorOriginal(super.getEntity("",entity.getEvaluacionProveedorOriginal(),resultSet,EvaluacionProveedorDataAccess.ISWITHSCHEMA));         		
					////entity.setEvaluacionProveedorOriginal(this.getEntityEvaluacionProveedor("",entity.getEvaluacionProveedorOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEvaluacionProveedors(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEvaluacionProveedor(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public EvaluacionProveedor getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EvaluacionProveedor entity = new EvaluacionProveedor();		  
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
	
	public  EvaluacionProveedor getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EvaluacionProveedor entity = new EvaluacionProveedor();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EvaluacionProveedor();
				
				if(conMapGenerico) {
					entity.inicializarMapEvaluacionProveedor();
					//entity.setMapEvaluacionProveedor(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapEvaluacionProveedorValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEvaluacionProveedor().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EvaluacionProveedorDataAccess.ISWITHSCHEMA);         		
					entity=EvaluacionProveedorDataAccess.getEntityEvaluacionProveedor("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEvaluacionProveedorOriginal( new EvaluacionProveedor());
					////entity.setEvaluacionProveedorOriginal(super.getEntity("",entity.getEvaluacionProveedorOriginal(),resultSet,EvaluacionProveedorDataAccess.ISWITHSCHEMA));         		
					////entity.setEvaluacionProveedorOriginal(this.getEntityEvaluacionProveedor("",entity.getEvaluacionProveedorOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseEvaluacionProveedor(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEvaluacionProveedor(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static EvaluacionProveedor getEntityEvaluacionProveedor(String strPrefijo,EvaluacionProveedor entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = EvaluacionProveedor.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = EvaluacionProveedor.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					EvaluacionProveedorDataAccess.setFieldReflectionEvaluacionProveedor(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasEvaluacionProveedor=EvaluacionProveedorConstantesFunciones.getTodosTiposColumnasEvaluacionProveedor();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasEvaluacionProveedor) {
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
							field = EvaluacionProveedor.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = EvaluacionProveedor.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						EvaluacionProveedorDataAccess.setFieldReflectionEvaluacionProveedor(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionEvaluacionProveedor(Field field,String strPrefijo,String sColumn,EvaluacionProveedor entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case EvaluacionProveedorConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EvaluacionProveedorConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EvaluacionProveedorConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EvaluacionProveedorConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EvaluacionProveedorConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EvaluacionProveedorConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EvaluacionProveedorConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EvaluacionProveedorConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case EvaluacionProveedorConstantesFunciones.CONTACTO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EvaluacionProveedorConstantesFunciones.EVALUADO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EvaluacionProveedorConstantesFunciones.RESULTADO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EvaluacionProveedorConstantesFunciones.RESPONSABLE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EvaluacionProveedorConstantesFunciones.FECHADESDE:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case EvaluacionProveedorConstantesFunciones.FECHAHASTA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case EvaluacionProveedorConstantesFunciones.OBSERVACION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EvaluacionProveedor>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<EvaluacionProveedor> entities = new  ArrayList<EvaluacionProveedor>();
		EvaluacionProveedor entity = new EvaluacionProveedor();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EvaluacionProveedorDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EvaluacionProveedorDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EvaluacionProveedorDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new EvaluacionProveedor();
					entity=super.getEntity("",entity,resultSet,EvaluacionProveedorDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityEvaluacionProveedor("",entity,resultSet);
					
					//entity.setEvaluacionProveedorOriginal( new EvaluacionProveedor());
					//entity.setEvaluacionProveedorOriginal(super.getEntity("",entity.getEvaluacionProveedorOriginal(),resultSet,EvaluacionProveedorDataAccess.ISWITHSCHEMA));         		
					//entity.setEvaluacionProveedorOriginal(this.getEntityEvaluacionProveedor("",entity.getEvaluacionProveedorOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseEvaluacionProveedors(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEvaluacionProveedor(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EvaluacionProveedor>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<EvaluacionProveedor> entities = new  ArrayList<EvaluacionProveedor>();
		EvaluacionProveedor entity = new EvaluacionProveedor();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EvaluacionProveedorDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EvaluacionProveedorDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EvaluacionProveedorDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<EvaluacionProveedor> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EvaluacionProveedor> entities = new  ArrayList<EvaluacionProveedor>();
		EvaluacionProveedor entity = new EvaluacionProveedor();		  
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
	
	public  List<EvaluacionProveedor> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EvaluacionProveedor> entities = new  ArrayList<EvaluacionProveedor>();
		EvaluacionProveedor entity = new EvaluacionProveedor();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EvaluacionProveedor();
      	    	entity=super.getEntity("",entity,resultSet,EvaluacionProveedorDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEvaluacionProveedor("",entity,resultSet);
      	    	
				//entity.setEvaluacionProveedorOriginal( new EvaluacionProveedor());
      	    	//entity.setEvaluacionProveedorOriginal(super.getEntity("",entity.getEvaluacionProveedorOriginal(),resultSet,EvaluacionProveedorDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEvaluacionProveedorOriginal(this.getEntityEvaluacionProveedor("",entity.getEvaluacionProveedorOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseEvaluacionProveedors(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEvaluacionProveedor(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<EvaluacionProveedor> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EvaluacionProveedor> entities = new  ArrayList<EvaluacionProveedor>();
		EvaluacionProveedor entity = new EvaluacionProveedor();		  
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
	
	public  List<EvaluacionProveedor> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EvaluacionProveedor> entities = new  ArrayList<EvaluacionProveedor>();
		EvaluacionProveedor entity = new EvaluacionProveedor();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EvaluacionProveedor();
      	    	entity=super.getEntity("",entity,resultSet,EvaluacionProveedorDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEvaluacionProveedor("",entity,resultSet);
      	    	
				//entity.setEvaluacionProveedorOriginal( new EvaluacionProveedor());
      	    	//entity.setEvaluacionProveedorOriginal(super.getEntity("",entity.getEvaluacionProveedorOriginal(),resultSet,EvaluacionProveedorDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEvaluacionProveedorOriginal(this.getEntityEvaluacionProveedor("",entity.getEvaluacionProveedorOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEvaluacionProveedors(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public EvaluacionProveedor getEntityEvaluacionProveedor(String strPrefijo,EvaluacionProveedor entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+EvaluacionProveedorConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+EvaluacionProveedorConstantesFunciones.IDSUCURSAL));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+EvaluacionProveedorConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+EvaluacionProveedorConstantesFunciones.IDPERIODO));
				entity.setid_cliente(resultSet.getLong(strPrefijo+EvaluacionProveedorConstantesFunciones.IDCLIENTE));
				entity.setfecha(new Date(resultSet.getDate(strPrefijo+EvaluacionProveedorConstantesFunciones.FECHA).getTime()));
				entity.setcontacto(resultSet.getString(strPrefijo+EvaluacionProveedorConstantesFunciones.CONTACTO));
				entity.setevaluado(resultSet.getString(strPrefijo+EvaluacionProveedorConstantesFunciones.EVALUADO));
				entity.setresultado(resultSet.getString(strPrefijo+EvaluacionProveedorConstantesFunciones.RESULTADO));
				entity.setresponsable(resultSet.getString(strPrefijo+EvaluacionProveedorConstantesFunciones.RESPONSABLE));
				entity.setfecha_desde(new Date(resultSet.getDate(strPrefijo+EvaluacionProveedorConstantesFunciones.FECHADESDE).getTime()));
				entity.setfecha_hasta(new Date(resultSet.getDate(strPrefijo+EvaluacionProveedorConstantesFunciones.FECHAHASTA).getTime()));
				entity.setobservacion(resultSet.getString(strPrefijo+EvaluacionProveedorConstantesFunciones.OBSERVACION));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowEvaluacionProveedor(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(EvaluacionProveedor entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=EvaluacionProveedorDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=EvaluacionProveedorDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=EvaluacionProveedorDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=EvaluacionProveedorDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(EvaluacionProveedorConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,EvaluacionProveedorDataAccess.TABLENAME,EvaluacionProveedorDataAccess.ISWITHSTOREPROCEDURES);
			
			EvaluacionProveedorDataAccess.setEvaluacionProveedorOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,EvaluacionProveedor relevaluacionproveedor)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relevaluacionproveedor.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,EvaluacionProveedor relevaluacionproveedor)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relevaluacionproveedor.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,EvaluacionProveedor relevaluacionproveedor)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relevaluacionproveedor.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,EvaluacionProveedor relevaluacionproveedor)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,relevaluacionproveedor.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public Cliente getCliente(Connexion connexion,EvaluacionProveedor relevaluacionproveedor)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,relevaluacionproveedor.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}


		
		public List<DetalleEvaluacionProveedor> getDetalleEvaluacionProveedors(Connexion connexion,EvaluacionProveedor evaluacionproveedor)throws SQLException,Exception {

		List<DetalleEvaluacionProveedor> detalleevaluacionproveedors= new ArrayList<DetalleEvaluacionProveedor>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EvaluacionProveedorConstantesFunciones.SCHEMA+".evaluacion_proveedor ON "+DetalleEvaluacionProveedorConstantesFunciones.SCHEMA+".detalle_evaluacion_proveedor.id_evaluacion_proveedor="+EvaluacionProveedorConstantesFunciones.SCHEMA+".evaluacion_proveedor.id WHERE "+EvaluacionProveedorConstantesFunciones.SCHEMA+".evaluacion_proveedor.id="+String.valueOf(evaluacionproveedor.getId());
			} else {
				sQuery=" INNER JOIN detalleevaluacionproveedor.EvaluacionProveedor WHERE detalleevaluacionproveedor.EvaluacionProveedor.id="+String.valueOf(evaluacionproveedor.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleEvaluacionProveedorDataAccess detalleevaluacionproveedorDataAccess=new DetalleEvaluacionProveedorDataAccess();

			detalleevaluacionproveedorDataAccess.setConnexionType(this.connexionType);
			detalleevaluacionproveedorDataAccess.setParameterDbType(this.parameterDbType);
			detalleevaluacionproveedors=detalleevaluacionproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalleevaluacionproveedors;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,EvaluacionProveedor evaluacionproveedor) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!evaluacionproveedor.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(evaluacionproveedor.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(evaluacionproveedor.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(evaluacionproveedor.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(evaluacionproveedor.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_cliente.setValue(evaluacionproveedor.getid_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha=new ParameterValue<Date>();
					parameterMaintenanceValuefecha.setValue(evaluacionproveedor.getfecha());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecontacto=new ParameterValue<String>();
					parameterMaintenanceValuecontacto.setValue(evaluacionproveedor.getcontacto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecontacto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueevaluado=new ParameterValue<String>();
					parameterMaintenanceValueevaluado.setValue(evaluacionproveedor.getevaluado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueevaluado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueresultado=new ParameterValue<String>();
					parameterMaintenanceValueresultado.setValue(evaluacionproveedor.getresultado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueresultado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueresponsable=new ParameterValue<String>();
					parameterMaintenanceValueresponsable.setValue(evaluacionproveedor.getresponsable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueresponsable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_desde=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_desde.setValue(evaluacionproveedor.getfecha_desde());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_desde);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_hasta=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_hasta.setValue(evaluacionproveedor.getfecha_hasta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_hasta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueobservacion=new ParameterValue<String>();
					parameterMaintenanceValueobservacion.setValue(evaluacionproveedor.getobservacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueobservacion);
					parametersTemp.add(parameterMaintenance);
					
						if(!evaluacionproveedor.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(evaluacionproveedor.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(evaluacionproveedor.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(evaluacionproveedor.getId());
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
	
	public void setIsNewIsChangedFalseEvaluacionProveedor(EvaluacionProveedor evaluacionproveedor)throws Exception  {		
		evaluacionproveedor.setIsNew(false);
		evaluacionproveedor.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseEvaluacionProveedors(List<EvaluacionProveedor> evaluacionproveedors)throws Exception  {				
		for(EvaluacionProveedor evaluacionproveedor:evaluacionproveedors) {
			evaluacionproveedor.setIsNew(false);
			evaluacionproveedor.setIsChanged(false);
		}
	}
	
	public void generarExportarEvaluacionProveedor(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
