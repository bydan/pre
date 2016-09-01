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
import com.bydan.erp.nomina.util.*;//CierreRolMensualConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class CierreRolMensualDataAccess extends  CierreRolMensualDataAccessAdditional{ //CierreRolMensualDataAccessAdditional,DataAccessHelper<CierreRolMensual>
	//static Logger logger = Logger.getLogger(CierreRolMensualDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="cierre_rol_mensual";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+CierreRolMensualConstantesFunciones.SCHEMA+"."+CierreRolMensualConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_ejercicio,id_empleado,id_estructura,id_estado_empleado,id_asiento_contable,porcentaje,fecha)values(current_timestamp,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+CierreRolMensualConstantesFunciones.SCHEMA+"."+CierreRolMensualConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_empleado=?,id_estructura=?,id_estado_empleado=?,id_asiento_contable=?,porcentaje=?,fecha=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+CierreRolMensualConstantesFunciones.SCHEMA+"."+CierreRolMensualConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select cierrerolmensual from "+CierreRolMensualConstantesFunciones.SPERSISTENCENAME+" cierrerolmensual";
	public static String QUERYSELECTNATIVE="select "+CierreRolMensualConstantesFunciones.SCHEMA+"."+CierreRolMensualConstantesFunciones.TABLENAME+".id,"+CierreRolMensualConstantesFunciones.SCHEMA+"."+CierreRolMensualConstantesFunciones.TABLENAME+".version_row,"+CierreRolMensualConstantesFunciones.SCHEMA+"."+CierreRolMensualConstantesFunciones.TABLENAME+".id_empresa,"+CierreRolMensualConstantesFunciones.SCHEMA+"."+CierreRolMensualConstantesFunciones.TABLENAME+".id_sucursal,"+CierreRolMensualConstantesFunciones.SCHEMA+"."+CierreRolMensualConstantesFunciones.TABLENAME+".id_ejercicio,"+CierreRolMensualConstantesFunciones.SCHEMA+"."+CierreRolMensualConstantesFunciones.TABLENAME+".id_empleado,"+CierreRolMensualConstantesFunciones.SCHEMA+"."+CierreRolMensualConstantesFunciones.TABLENAME+".id_estructura,"+CierreRolMensualConstantesFunciones.SCHEMA+"."+CierreRolMensualConstantesFunciones.TABLENAME+".id_estado_empleado,"+CierreRolMensualConstantesFunciones.SCHEMA+"."+CierreRolMensualConstantesFunciones.TABLENAME+".id_asiento_contable,"+CierreRolMensualConstantesFunciones.SCHEMA+"."+CierreRolMensualConstantesFunciones.TABLENAME+".porcentaje,"+CierreRolMensualConstantesFunciones.SCHEMA+"."+CierreRolMensualConstantesFunciones.TABLENAME+".fecha from "+CierreRolMensualConstantesFunciones.SCHEMA+"."+CierreRolMensualConstantesFunciones.TABLENAME;//+" as "+CierreRolMensualConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+CierreRolMensualConstantesFunciones.SCHEMA+"."+CierreRolMensualConstantesFunciones.TABLENAME+".id,"+CierreRolMensualConstantesFunciones.SCHEMA+"."+CierreRolMensualConstantesFunciones.TABLENAME+".version_row from "+CierreRolMensualConstantesFunciones.SCHEMA+"."+CierreRolMensualConstantesFunciones.TABLENAME;//+" as "+CierreRolMensualConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+CierreRolMensualConstantesFunciones.SCHEMA+"."+CierreRolMensualConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_empleado=?,id_estructura=?,id_estado_empleado=?,id_asiento_contable=?,porcentaje=?,fecha=?";
	
	public static String STOREPROCEDUREINSERT="call SP_CIERREROLMENSUAL_INSERT(?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_CIERREROLMENSUAL_UPDATE(?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_CIERREROLMENSUAL_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_CIERREROLMENSUAL_SELECT(?,?)";
	
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
	
	
	protected CierreRolMensualDataAccessAdditional cierrerolmensualDataAccessAdditional=null;
	
	public CierreRolMensualDataAccessAdditional getCierreRolMensualDataAccessAdditional() {
		return this.cierrerolmensualDataAccessAdditional;
	}
	
	public void setCierreRolMensualDataAccessAdditional(CierreRolMensualDataAccessAdditional cierrerolmensualDataAccessAdditional) {
		try {
			this.cierrerolmensualDataAccessAdditional=cierrerolmensualDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public CierreRolMensualDataAccess() {
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
		CierreRolMensualDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		CierreRolMensualDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		CierreRolMensualDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setCierreRolMensualOriginal(CierreRolMensual cierrerolmensual)throws Exception  {
		cierrerolmensual.setCierreRolMensualOriginal((CierreRolMensual)cierrerolmensual.clone());		
	}
	
	public void setCierreRolMensualsOriginal(List<CierreRolMensual> cierrerolmensuals)throws Exception  {
		
		for(CierreRolMensual cierrerolmensual:cierrerolmensuals){
			cierrerolmensual.setCierreRolMensualOriginal((CierreRolMensual)cierrerolmensual.clone());
		}
	}
	
	public static void setCierreRolMensualOriginalStatic(CierreRolMensual cierrerolmensual)throws Exception  {
		cierrerolmensual.setCierreRolMensualOriginal((CierreRolMensual)cierrerolmensual.clone());		
	}
	
	public static void setCierreRolMensualsOriginalStatic(List<CierreRolMensual> cierrerolmensuals)throws Exception  {
		
		for(CierreRolMensual cierrerolmensual:cierrerolmensuals){
			cierrerolmensual.setCierreRolMensualOriginal((CierreRolMensual)cierrerolmensual.clone());
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
	
	public  CierreRolMensual getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		CierreRolMensual entity = new CierreRolMensual();		
		
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
	
	public  CierreRolMensual getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		CierreRolMensual entity = new CierreRolMensual();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=CierreRolMensualDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CierreRolMensualDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.CierreRolMensual.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setCierreRolMensualOriginal(new CierreRolMensual());
      	    	entity=super.getEntity("",entity,resultSet,CierreRolMensualDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityCierreRolMensual("",entity,resultSet); 
				
				//entity.setCierreRolMensualOriginal(super.getEntity("",entity.getCierreRolMensualOriginal(),resultSet,CierreRolMensualDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCierreRolMensualOriginal(this.getEntityCierreRolMensual("",entity.getCierreRolMensualOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseCierreRolMensual(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  CierreRolMensual getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		CierreRolMensual entity = new CierreRolMensual();
				
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
	
	public  CierreRolMensual getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		CierreRolMensual entity = new CierreRolMensual();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=CierreRolMensualDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CierreRolMensualDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CierreRolMensualDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.CierreRolMensual.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setCierreRolMensualOriginal(new CierreRolMensual());
      	    	entity=super.getEntity("",entity,resultSet,CierreRolMensualDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityCierreRolMensual("",entity,resultSet);    
				
				//entity.setCierreRolMensualOriginal(super.getEntity("",entity.getCierreRolMensualOriginal(),resultSet,CierreRolMensualDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCierreRolMensualOriginal(this.getEntityCierreRolMensual("",entity.getCierreRolMensualOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseCierreRolMensual(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //CierreRolMensual
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		CierreRolMensual entity = new CierreRolMensual();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CierreRolMensualDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CierreRolMensualDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CierreRolMensualDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.CierreRolMensual.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseCierreRolMensual(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<CierreRolMensual> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<CierreRolMensual> entities = new  ArrayList<CierreRolMensual>();
		CierreRolMensual entity = new CierreRolMensual();		  
		
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
	
	public  List<CierreRolMensual> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<CierreRolMensual> entities = new  ArrayList<CierreRolMensual>();
		CierreRolMensual entity = new CierreRolMensual();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=CierreRolMensualDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CierreRolMensualDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CierreRolMensualDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CierreRolMensual();
      	    	entity=super.getEntity("",entity,resultSet,CierreRolMensualDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCierreRolMensual("",entity,resultSet);
      	    	
				//entity.setCierreRolMensualOriginal( new CierreRolMensual());
      	    	//entity.setCierreRolMensualOriginal(super.getEntity("",entity.getCierreRolMensualOriginal(),resultSet,CierreRolMensualDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCierreRolMensualOriginal(this.getEntityCierreRolMensual("",entity.getCierreRolMensualOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCierreRolMensuals(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCierreRolMensual(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<CierreRolMensual> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<CierreRolMensual> entities = new  ArrayList<CierreRolMensual>();
		CierreRolMensual entity = new CierreRolMensual();		  
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
	
	public  List<CierreRolMensual> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<CierreRolMensual> entities = new  ArrayList<CierreRolMensual>();
		CierreRolMensual entity = new CierreRolMensual();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CierreRolMensual();
				
				if(conMapGenerico) {
					entity.inicializarMapCierreRolMensual();
					//entity.setMapCierreRolMensual(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapCierreRolMensualValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapCierreRolMensual().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CierreRolMensualDataAccess.ISWITHSCHEMA);         		
					entity=CierreRolMensualDataAccess.getEntityCierreRolMensual("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setCierreRolMensualOriginal( new CierreRolMensual());
					////entity.setCierreRolMensualOriginal(super.getEntity("",entity.getCierreRolMensualOriginal(),resultSet,CierreRolMensualDataAccess.ISWITHSCHEMA));         		
					////entity.setCierreRolMensualOriginal(this.getEntityCierreRolMensual("",entity.getCierreRolMensualOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCierreRolMensuals(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCierreRolMensual(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public CierreRolMensual getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		CierreRolMensual entity = new CierreRolMensual();		  
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
	
	public  CierreRolMensual getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		CierreRolMensual entity = new CierreRolMensual();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CierreRolMensual();
				
				if(conMapGenerico) {
					entity.inicializarMapCierreRolMensual();
					//entity.setMapCierreRolMensual(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapCierreRolMensualValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapCierreRolMensual().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CierreRolMensualDataAccess.ISWITHSCHEMA);         		
					entity=CierreRolMensualDataAccess.getEntityCierreRolMensual("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setCierreRolMensualOriginal( new CierreRolMensual());
					////entity.setCierreRolMensualOriginal(super.getEntity("",entity.getCierreRolMensualOriginal(),resultSet,CierreRolMensualDataAccess.ISWITHSCHEMA));         		
					////entity.setCierreRolMensualOriginal(this.getEntityCierreRolMensual("",entity.getCierreRolMensualOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseCierreRolMensual(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCierreRolMensual(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static CierreRolMensual getEntityCierreRolMensual(String strPrefijo,CierreRolMensual entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = CierreRolMensual.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = CierreRolMensual.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					CierreRolMensualDataAccess.setFieldReflectionCierreRolMensual(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasCierreRolMensual=CierreRolMensualConstantesFunciones.getTodosTiposColumnasCierreRolMensual();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasCierreRolMensual) {
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
							field = CierreRolMensual.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = CierreRolMensual.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						CierreRolMensualDataAccess.setFieldReflectionCierreRolMensual(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionCierreRolMensual(Field field,String strPrefijo,String sColumn,CierreRolMensual entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case CierreRolMensualConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CierreRolMensualConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CierreRolMensualConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CierreRolMensualConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CierreRolMensualConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CierreRolMensualConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CierreRolMensualConstantesFunciones.IDESTRUCTURA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CierreRolMensualConstantesFunciones.IDESTADOEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CierreRolMensualConstantesFunciones.IDASIENTOCONTABLE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CierreRolMensualConstantesFunciones.PORCENTAJE:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case CierreRolMensualConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<CierreRolMensual>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<CierreRolMensual> entities = new  ArrayList<CierreRolMensual>();
		CierreRolMensual entity = new CierreRolMensual();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CierreRolMensualDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CierreRolMensualDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CierreRolMensualDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new CierreRolMensual();
					entity=super.getEntity("",entity,resultSet,CierreRolMensualDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityCierreRolMensual("",entity,resultSet);
					
					//entity.setCierreRolMensualOriginal( new CierreRolMensual());
					//entity.setCierreRolMensualOriginal(super.getEntity("",entity.getCierreRolMensualOriginal(),resultSet,CierreRolMensualDataAccess.ISWITHSCHEMA));         		
					//entity.setCierreRolMensualOriginal(this.getEntityCierreRolMensual("",entity.getCierreRolMensualOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseCierreRolMensuals(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCierreRolMensual(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<CierreRolMensual>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<CierreRolMensual> entities = new  ArrayList<CierreRolMensual>();
		CierreRolMensual entity = new CierreRolMensual();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CierreRolMensualDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CierreRolMensualDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CierreRolMensualDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<CierreRolMensual> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CierreRolMensual> entities = new  ArrayList<CierreRolMensual>();
		CierreRolMensual entity = new CierreRolMensual();		  
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
	
	public  List<CierreRolMensual> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CierreRolMensual> entities = new  ArrayList<CierreRolMensual>();
		CierreRolMensual entity = new CierreRolMensual();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CierreRolMensual();
      	    	entity=super.getEntity("",entity,resultSet,CierreRolMensualDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCierreRolMensual("",entity,resultSet);
      	    	
				//entity.setCierreRolMensualOriginal( new CierreRolMensual());
      	    	//entity.setCierreRolMensualOriginal(super.getEntity("",entity.getCierreRolMensualOriginal(),resultSet,CierreRolMensualDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCierreRolMensualOriginal(this.getEntityCierreRolMensual("",entity.getCierreRolMensualOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseCierreRolMensuals(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCierreRolMensual(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<CierreRolMensual> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CierreRolMensual> entities = new  ArrayList<CierreRolMensual>();
		CierreRolMensual entity = new CierreRolMensual();		  
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
	
	public  List<CierreRolMensual> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CierreRolMensual> entities = new  ArrayList<CierreRolMensual>();
		CierreRolMensual entity = new CierreRolMensual();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CierreRolMensual();
      	    	entity=super.getEntity("",entity,resultSet,CierreRolMensualDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCierreRolMensual("",entity,resultSet);
      	    	
				//entity.setCierreRolMensualOriginal( new CierreRolMensual());
      	    	//entity.setCierreRolMensualOriginal(super.getEntity("",entity.getCierreRolMensualOriginal(),resultSet,CierreRolMensualDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCierreRolMensualOriginal(this.getEntityCierreRolMensual("",entity.getCierreRolMensualOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCierreRolMensuals(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public CierreRolMensual getEntityCierreRolMensual(String strPrefijo,CierreRolMensual entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+CierreRolMensualConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+CierreRolMensualConstantesFunciones.IDSUCURSAL));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+CierreRolMensualConstantesFunciones.IDEJERCICIO));
				entity.setid_empleado(resultSet.getLong(strPrefijo+CierreRolMensualConstantesFunciones.IDEMPLEADO));
				entity.setid_estructura(resultSet.getLong(strPrefijo+CierreRolMensualConstantesFunciones.IDESTRUCTURA));
				entity.setid_estado_empleado(resultSet.getLong(strPrefijo+CierreRolMensualConstantesFunciones.IDESTADOEMPLEADO));
				entity.setid_asiento_contable(resultSet.getLong(strPrefijo+CierreRolMensualConstantesFunciones.IDASIENTOCONTABLE));
				entity.setporcentaje(resultSet.getInt(strPrefijo+CierreRolMensualConstantesFunciones.PORCENTAJE));
				entity.setfecha(new Date(resultSet.getDate(strPrefijo+CierreRolMensualConstantesFunciones.FECHA).getTime()));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowCierreRolMensual(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(CierreRolMensual entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=CierreRolMensualDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=CierreRolMensualDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=CierreRolMensualDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=CierreRolMensualDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(CierreRolMensualConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,CierreRolMensualDataAccess.TABLENAME,CierreRolMensualDataAccess.ISWITHSTOREPROCEDURES);
			
			CierreRolMensualDataAccess.setCierreRolMensualOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,CierreRolMensual relcierrerolmensual)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relcierrerolmensual.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,CierreRolMensual relcierrerolmensual)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relcierrerolmensual.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,CierreRolMensual relcierrerolmensual)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relcierrerolmensual.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Empleado getEmpleado(Connexion connexion,CierreRolMensual relcierrerolmensual)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relcierrerolmensual.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public Estructura getEstructura(Connexion connexion,CierreRolMensual relcierrerolmensual)throws SQLException,Exception {

		Estructura estructura= new Estructura();

		try {
			EstructuraDataAccess estructuraDataAccess=new EstructuraDataAccess();

			estructuraDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estructuraDataAccess.setConnexionType(this.connexionType);
			estructuraDataAccess.setParameterDbType(this.parameterDbType);

			estructura=estructuraDataAccess.getEntity(connexion,relcierrerolmensual.getid_estructura());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estructura;

	}

	public EstadoEmpleado getEstadoEmpleado(Connexion connexion,CierreRolMensual relcierrerolmensual)throws SQLException,Exception {

		EstadoEmpleado estadoempleado= new EstadoEmpleado();

		try {
			EstadoEmpleadoDataAccess estadoempleadoDataAccess=new EstadoEmpleadoDataAccess();

			estadoempleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadoempleadoDataAccess.setConnexionType(this.connexionType);
			estadoempleadoDataAccess.setParameterDbType(this.parameterDbType);

			estadoempleado=estadoempleadoDataAccess.getEntity(connexion,relcierrerolmensual.getid_estado_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadoempleado;

	}

	public AsientoContable getAsientoContable(Connexion connexion,CierreRolMensual relcierrerolmensual)throws SQLException,Exception {

		AsientoContable asientocontable= new AsientoContable();

		try {
			AsientoContableDataAccess asientocontableDataAccess=new AsientoContableDataAccess();

			asientocontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			asientocontableDataAccess.setConnexionType(this.connexionType);
			asientocontableDataAccess.setParameterDbType(this.parameterDbType);

			asientocontable=asientocontableDataAccess.getEntity(connexion,relcierrerolmensual.getid_asiento_contable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return asientocontable;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,CierreRolMensual cierrerolmensual) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!cierrerolmensual.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(cierrerolmensual.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(cierrerolmensual.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(cierrerolmensual.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(cierrerolmensual.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estructura=new ParameterValue<Long>();
					parameterMaintenanceValueid_estructura.setValue(cierrerolmensual.getid_estructura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estructura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_empleado.setValue(cierrerolmensual.getid_estado_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_asiento_contable=new ParameterValue<Long>();
					parameterMaintenanceValueid_asiento_contable.setValue(cierrerolmensual.getid_asiento_contable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_asiento_contable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValueporcentaje=new ParameterValue<Integer>();
					parameterMaintenanceValueporcentaje.setValue(cierrerolmensual.getporcentaje());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcentaje);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha=new ParameterValue<Date>();
					parameterMaintenanceValuefecha.setValue(cierrerolmensual.getfecha());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha);
					parametersTemp.add(parameterMaintenance);
					
						if(!cierrerolmensual.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(cierrerolmensual.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(cierrerolmensual.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(cierrerolmensual.getId());
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
	
	public void setIsNewIsChangedFalseCierreRolMensual(CierreRolMensual cierrerolmensual)throws Exception  {		
		cierrerolmensual.setIsNew(false);
		cierrerolmensual.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseCierreRolMensuals(List<CierreRolMensual> cierrerolmensuals)throws Exception  {				
		for(CierreRolMensual cierrerolmensual:cierrerolmensuals) {
			cierrerolmensual.setIsNew(false);
			cierrerolmensual.setIsChanged(false);
		}
	}
	
	public void generarExportarCierreRolMensual(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
