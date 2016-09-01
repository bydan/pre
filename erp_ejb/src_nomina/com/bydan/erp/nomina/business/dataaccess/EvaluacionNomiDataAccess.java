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
import com.bydan.erp.nomina.util.*;//EvaluacionNomiConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class EvaluacionNomiDataAccess extends  EvaluacionNomiDataAccessAdditional{ //EvaluacionNomiDataAccessAdditional,DataAccessHelper<EvaluacionNomi>
	//static Logger logger = Logger.getLogger(EvaluacionNomiDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="evaluacion_nomi";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+EvaluacionNomiConstantesFunciones.SCHEMA+"."+EvaluacionNomiConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_ejercicio,id_periodo,id_empleado,id_empleado_evaluador,id_formato_nomi,id_estructura,fecha,instrucciones,descripcion,descripcion2,descripcion3,descripcion4)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+EvaluacionNomiConstantesFunciones.SCHEMA+"."+EvaluacionNomiConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_empleado=?,id_empleado_evaluador=?,id_formato_nomi=?,id_estructura=?,fecha=?,instrucciones=?,descripcion=?,descripcion2=?,descripcion3=?,descripcion4=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+EvaluacionNomiConstantesFunciones.SCHEMA+"."+EvaluacionNomiConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select evaluacionnomi from "+EvaluacionNomiConstantesFunciones.SPERSISTENCENAME+" evaluacionnomi";
	public static String QUERYSELECTNATIVE="select "+EvaluacionNomiConstantesFunciones.SCHEMA+"."+EvaluacionNomiConstantesFunciones.TABLENAME+".id,"+EvaluacionNomiConstantesFunciones.SCHEMA+"."+EvaluacionNomiConstantesFunciones.TABLENAME+".version_row,"+EvaluacionNomiConstantesFunciones.SCHEMA+"."+EvaluacionNomiConstantesFunciones.TABLENAME+".id_empresa,"+EvaluacionNomiConstantesFunciones.SCHEMA+"."+EvaluacionNomiConstantesFunciones.TABLENAME+".id_sucursal,"+EvaluacionNomiConstantesFunciones.SCHEMA+"."+EvaluacionNomiConstantesFunciones.TABLENAME+".id_ejercicio,"+EvaluacionNomiConstantesFunciones.SCHEMA+"."+EvaluacionNomiConstantesFunciones.TABLENAME+".id_periodo,"+EvaluacionNomiConstantesFunciones.SCHEMA+"."+EvaluacionNomiConstantesFunciones.TABLENAME+".id_empleado,"+EvaluacionNomiConstantesFunciones.SCHEMA+"."+EvaluacionNomiConstantesFunciones.TABLENAME+".id_empleado_evaluador,"+EvaluacionNomiConstantesFunciones.SCHEMA+"."+EvaluacionNomiConstantesFunciones.TABLENAME+".id_formato_nomi,"+EvaluacionNomiConstantesFunciones.SCHEMA+"."+EvaluacionNomiConstantesFunciones.TABLENAME+".id_estructura,"+EvaluacionNomiConstantesFunciones.SCHEMA+"."+EvaluacionNomiConstantesFunciones.TABLENAME+".fecha,"+EvaluacionNomiConstantesFunciones.SCHEMA+"."+EvaluacionNomiConstantesFunciones.TABLENAME+".instrucciones,"+EvaluacionNomiConstantesFunciones.SCHEMA+"."+EvaluacionNomiConstantesFunciones.TABLENAME+".descripcion,"+EvaluacionNomiConstantesFunciones.SCHEMA+"."+EvaluacionNomiConstantesFunciones.TABLENAME+".descripcion2,"+EvaluacionNomiConstantesFunciones.SCHEMA+"."+EvaluacionNomiConstantesFunciones.TABLENAME+".descripcion3,"+EvaluacionNomiConstantesFunciones.SCHEMA+"."+EvaluacionNomiConstantesFunciones.TABLENAME+".descripcion4 from "+EvaluacionNomiConstantesFunciones.SCHEMA+"."+EvaluacionNomiConstantesFunciones.TABLENAME;//+" as "+EvaluacionNomiConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+EvaluacionNomiConstantesFunciones.SCHEMA+"."+EvaluacionNomiConstantesFunciones.TABLENAME+".id,"+EvaluacionNomiConstantesFunciones.SCHEMA+"."+EvaluacionNomiConstantesFunciones.TABLENAME+".version_row from "+EvaluacionNomiConstantesFunciones.SCHEMA+"."+EvaluacionNomiConstantesFunciones.TABLENAME;//+" as "+EvaluacionNomiConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+EvaluacionNomiConstantesFunciones.SCHEMA+"."+EvaluacionNomiConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_empleado=?,id_empleado_evaluador=?,id_formato_nomi=?,id_estructura=?,fecha=?,instrucciones=?,descripcion=?,descripcion2=?,descripcion3=?,descripcion4=?";
	
	public static String STOREPROCEDUREINSERT="call SP_EVALUACIONNOMI_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_EVALUACIONNOMI_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_EVALUACIONNOMI_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_EVALUACIONNOMI_SELECT(?,?)";
	
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
	
	
	protected EvaluacionNomiDataAccessAdditional evaluacionnomiDataAccessAdditional=null;
	
	public EvaluacionNomiDataAccessAdditional getEvaluacionNomiDataAccessAdditional() {
		return this.evaluacionnomiDataAccessAdditional;
	}
	
	public void setEvaluacionNomiDataAccessAdditional(EvaluacionNomiDataAccessAdditional evaluacionnomiDataAccessAdditional) {
		try {
			this.evaluacionnomiDataAccessAdditional=evaluacionnomiDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public EvaluacionNomiDataAccess() {
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
		EvaluacionNomiDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		EvaluacionNomiDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		EvaluacionNomiDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setEvaluacionNomiOriginal(EvaluacionNomi evaluacionnomi)throws Exception  {
		evaluacionnomi.setEvaluacionNomiOriginal((EvaluacionNomi)evaluacionnomi.clone());		
	}
	
	public void setEvaluacionNomisOriginal(List<EvaluacionNomi> evaluacionnomis)throws Exception  {
		
		for(EvaluacionNomi evaluacionnomi:evaluacionnomis){
			evaluacionnomi.setEvaluacionNomiOriginal((EvaluacionNomi)evaluacionnomi.clone());
		}
	}
	
	public static void setEvaluacionNomiOriginalStatic(EvaluacionNomi evaluacionnomi)throws Exception  {
		evaluacionnomi.setEvaluacionNomiOriginal((EvaluacionNomi)evaluacionnomi.clone());		
	}
	
	public static void setEvaluacionNomisOriginalStatic(List<EvaluacionNomi> evaluacionnomis)throws Exception  {
		
		for(EvaluacionNomi evaluacionnomi:evaluacionnomis){
			evaluacionnomi.setEvaluacionNomiOriginal((EvaluacionNomi)evaluacionnomi.clone());
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
	
	public  EvaluacionNomi getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		EvaluacionNomi entity = new EvaluacionNomi();		
		
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
	
	public  EvaluacionNomi getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		EvaluacionNomi entity = new EvaluacionNomi();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EvaluacionNomiDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EvaluacionNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.EvaluacionNomi.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setEvaluacionNomiOriginal(new EvaluacionNomi());
      	    	entity=super.getEntity("",entity,resultSet,EvaluacionNomiDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEvaluacionNomi("",entity,resultSet); 
				
				//entity.setEvaluacionNomiOriginal(super.getEntity("",entity.getEvaluacionNomiOriginal(),resultSet,EvaluacionNomiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEvaluacionNomiOriginal(this.getEntityEvaluacionNomi("",entity.getEvaluacionNomiOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseEvaluacionNomi(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  EvaluacionNomi getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EvaluacionNomi entity = new EvaluacionNomi();
				
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
	
	public  EvaluacionNomi getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EvaluacionNomi entity = new EvaluacionNomi();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EvaluacionNomiDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EvaluacionNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EvaluacionNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.EvaluacionNomi.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setEvaluacionNomiOriginal(new EvaluacionNomi());
      	    	entity=super.getEntity("",entity,resultSet,EvaluacionNomiDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEvaluacionNomi("",entity,resultSet);    
				
				//entity.setEvaluacionNomiOriginal(super.getEntity("",entity.getEvaluacionNomiOriginal(),resultSet,EvaluacionNomiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEvaluacionNomiOriginal(this.getEntityEvaluacionNomi("",entity.getEvaluacionNomiOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseEvaluacionNomi(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //EvaluacionNomi
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		EvaluacionNomi entity = new EvaluacionNomi();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EvaluacionNomiDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EvaluacionNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EvaluacionNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.EvaluacionNomi.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseEvaluacionNomi(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<EvaluacionNomi> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EvaluacionNomi> entities = new  ArrayList<EvaluacionNomi>();
		EvaluacionNomi entity = new EvaluacionNomi();		  
		
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
	
	public  List<EvaluacionNomi> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EvaluacionNomi> entities = new  ArrayList<EvaluacionNomi>();
		EvaluacionNomi entity = new EvaluacionNomi();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=EvaluacionNomiDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EvaluacionNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EvaluacionNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EvaluacionNomi();
      	    	entity=super.getEntity("",entity,resultSet,EvaluacionNomiDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEvaluacionNomi("",entity,resultSet);
      	    	
				//entity.setEvaluacionNomiOriginal( new EvaluacionNomi());
      	    	//entity.setEvaluacionNomiOriginal(super.getEntity("",entity.getEvaluacionNomiOriginal(),resultSet,EvaluacionNomiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEvaluacionNomiOriginal(this.getEntityEvaluacionNomi("",entity.getEvaluacionNomiOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEvaluacionNomis(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEvaluacionNomi(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<EvaluacionNomi> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EvaluacionNomi> entities = new  ArrayList<EvaluacionNomi>();
		EvaluacionNomi entity = new EvaluacionNomi();		  
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
	
	public  List<EvaluacionNomi> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EvaluacionNomi> entities = new  ArrayList<EvaluacionNomi>();
		EvaluacionNomi entity = new EvaluacionNomi();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EvaluacionNomi();
				
				if(conMapGenerico) {
					entity.inicializarMapEvaluacionNomi();
					//entity.setMapEvaluacionNomi(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapEvaluacionNomiValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEvaluacionNomi().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EvaluacionNomiDataAccess.ISWITHSCHEMA);         		
					entity=EvaluacionNomiDataAccess.getEntityEvaluacionNomi("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEvaluacionNomiOriginal( new EvaluacionNomi());
					////entity.setEvaluacionNomiOriginal(super.getEntity("",entity.getEvaluacionNomiOriginal(),resultSet,EvaluacionNomiDataAccess.ISWITHSCHEMA));         		
					////entity.setEvaluacionNomiOriginal(this.getEntityEvaluacionNomi("",entity.getEvaluacionNomiOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEvaluacionNomis(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEvaluacionNomi(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public EvaluacionNomi getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EvaluacionNomi entity = new EvaluacionNomi();		  
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
	
	public  EvaluacionNomi getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EvaluacionNomi entity = new EvaluacionNomi();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EvaluacionNomi();
				
				if(conMapGenerico) {
					entity.inicializarMapEvaluacionNomi();
					//entity.setMapEvaluacionNomi(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapEvaluacionNomiValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEvaluacionNomi().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EvaluacionNomiDataAccess.ISWITHSCHEMA);         		
					entity=EvaluacionNomiDataAccess.getEntityEvaluacionNomi("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEvaluacionNomiOriginal( new EvaluacionNomi());
					////entity.setEvaluacionNomiOriginal(super.getEntity("",entity.getEvaluacionNomiOriginal(),resultSet,EvaluacionNomiDataAccess.ISWITHSCHEMA));         		
					////entity.setEvaluacionNomiOriginal(this.getEntityEvaluacionNomi("",entity.getEvaluacionNomiOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseEvaluacionNomi(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEvaluacionNomi(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static EvaluacionNomi getEntityEvaluacionNomi(String strPrefijo,EvaluacionNomi entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = EvaluacionNomi.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = EvaluacionNomi.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					EvaluacionNomiDataAccess.setFieldReflectionEvaluacionNomi(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasEvaluacionNomi=EvaluacionNomiConstantesFunciones.getTodosTiposColumnasEvaluacionNomi();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasEvaluacionNomi) {
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
							field = EvaluacionNomi.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = EvaluacionNomi.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						EvaluacionNomiDataAccess.setFieldReflectionEvaluacionNomi(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionEvaluacionNomi(Field field,String strPrefijo,String sColumn,EvaluacionNomi entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case EvaluacionNomiConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EvaluacionNomiConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EvaluacionNomiConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EvaluacionNomiConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EvaluacionNomiConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EvaluacionNomiConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EvaluacionNomiConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EvaluacionNomiConstantesFunciones.IDEMPLEADOEVALUADOR:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EvaluacionNomiConstantesFunciones.IDFORMATONOMI:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EvaluacionNomiConstantesFunciones.IDESTRUCTURA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EvaluacionNomiConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case EvaluacionNomiConstantesFunciones.INSTRUCCIONES:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EvaluacionNomiConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EvaluacionNomiConstantesFunciones.DESCRIPCION2:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EvaluacionNomiConstantesFunciones.DESCRIPCION3:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EvaluacionNomiConstantesFunciones.DESCRIPCION4:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EvaluacionNomi>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<EvaluacionNomi> entities = new  ArrayList<EvaluacionNomi>();
		EvaluacionNomi entity = new EvaluacionNomi();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EvaluacionNomiDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EvaluacionNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EvaluacionNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new EvaluacionNomi();
					entity=super.getEntity("",entity,resultSet,EvaluacionNomiDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityEvaluacionNomi("",entity,resultSet);
					
					//entity.setEvaluacionNomiOriginal( new EvaluacionNomi());
					//entity.setEvaluacionNomiOriginal(super.getEntity("",entity.getEvaluacionNomiOriginal(),resultSet,EvaluacionNomiDataAccess.ISWITHSCHEMA));         		
					//entity.setEvaluacionNomiOriginal(this.getEntityEvaluacionNomi("",entity.getEvaluacionNomiOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseEvaluacionNomis(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEvaluacionNomi(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EvaluacionNomi>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<EvaluacionNomi> entities = new  ArrayList<EvaluacionNomi>();
		EvaluacionNomi entity = new EvaluacionNomi();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EvaluacionNomiDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EvaluacionNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EvaluacionNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<EvaluacionNomi> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EvaluacionNomi> entities = new  ArrayList<EvaluacionNomi>();
		EvaluacionNomi entity = new EvaluacionNomi();		  
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
	
	public  List<EvaluacionNomi> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EvaluacionNomi> entities = new  ArrayList<EvaluacionNomi>();
		EvaluacionNomi entity = new EvaluacionNomi();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EvaluacionNomi();
      	    	entity=super.getEntity("",entity,resultSet,EvaluacionNomiDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEvaluacionNomi("",entity,resultSet);
      	    	
				//entity.setEvaluacionNomiOriginal( new EvaluacionNomi());
      	    	//entity.setEvaluacionNomiOriginal(super.getEntity("",entity.getEvaluacionNomiOriginal(),resultSet,EvaluacionNomiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEvaluacionNomiOriginal(this.getEntityEvaluacionNomi("",entity.getEvaluacionNomiOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseEvaluacionNomis(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEvaluacionNomi(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<EvaluacionNomi> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EvaluacionNomi> entities = new  ArrayList<EvaluacionNomi>();
		EvaluacionNomi entity = new EvaluacionNomi();		  
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
	
	public  List<EvaluacionNomi> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EvaluacionNomi> entities = new  ArrayList<EvaluacionNomi>();
		EvaluacionNomi entity = new EvaluacionNomi();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EvaluacionNomi();
      	    	entity=super.getEntity("",entity,resultSet,EvaluacionNomiDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEvaluacionNomi("",entity,resultSet);
      	    	
				//entity.setEvaluacionNomiOriginal( new EvaluacionNomi());
      	    	//entity.setEvaluacionNomiOriginal(super.getEntity("",entity.getEvaluacionNomiOriginal(),resultSet,EvaluacionNomiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEvaluacionNomiOriginal(this.getEntityEvaluacionNomi("",entity.getEvaluacionNomiOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEvaluacionNomis(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public EvaluacionNomi getEntityEvaluacionNomi(String strPrefijo,EvaluacionNomi entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+EvaluacionNomiConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+EvaluacionNomiConstantesFunciones.IDSUCURSAL));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+EvaluacionNomiConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+EvaluacionNomiConstantesFunciones.IDPERIODO));
				entity.setid_empleado(resultSet.getLong(strPrefijo+EvaluacionNomiConstantesFunciones.IDEMPLEADO));
				entity.setid_empleado_evaluador(resultSet.getLong(strPrefijo+EvaluacionNomiConstantesFunciones.IDEMPLEADOEVALUADOR));
				entity.setid_formato_nomi(resultSet.getLong(strPrefijo+EvaluacionNomiConstantesFunciones.IDFORMATONOMI));
				entity.setid_estructura(resultSet.getLong(strPrefijo+EvaluacionNomiConstantesFunciones.IDESTRUCTURA));
				entity.setfecha(new Date(resultSet.getDate(strPrefijo+EvaluacionNomiConstantesFunciones.FECHA).getTime()));
				entity.setinstrucciones(resultSet.getString(strPrefijo+EvaluacionNomiConstantesFunciones.INSTRUCCIONES));
				entity.setdescripcion(resultSet.getString(strPrefijo+EvaluacionNomiConstantesFunciones.DESCRIPCION));
				entity.setdescripcion2(resultSet.getString(strPrefijo+EvaluacionNomiConstantesFunciones.DESCRIPCION2));
				entity.setdescripcion3(resultSet.getString(strPrefijo+EvaluacionNomiConstantesFunciones.DESCRIPCION3));
				entity.setdescripcion4(resultSet.getString(strPrefijo+EvaluacionNomiConstantesFunciones.DESCRIPCION4));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowEvaluacionNomi(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(EvaluacionNomi entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=EvaluacionNomiDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=EvaluacionNomiDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=EvaluacionNomiDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=EvaluacionNomiDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(EvaluacionNomiConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,EvaluacionNomiDataAccess.TABLENAME,EvaluacionNomiDataAccess.ISWITHSTOREPROCEDURES);
			
			EvaluacionNomiDataAccess.setEvaluacionNomiOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,EvaluacionNomi relevaluacionnomi)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relevaluacionnomi.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,EvaluacionNomi relevaluacionnomi)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relevaluacionnomi.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,EvaluacionNomi relevaluacionnomi)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relevaluacionnomi.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,EvaluacionNomi relevaluacionnomi)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,relevaluacionnomi.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public Empleado getEmpleado(Connexion connexion,EvaluacionNomi relevaluacionnomi)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relevaluacionnomi.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public Empleado getEmpleadoEvaluador(Connexion connexion,EvaluacionNomi relevaluacionnomi)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relevaluacionnomi.getid_empleado_evaluador());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public FormatoNomi getFormatoNomi(Connexion connexion,EvaluacionNomi relevaluacionnomi)throws SQLException,Exception {

		FormatoNomi formatonomi= new FormatoNomi();

		try {
			FormatoNomiDataAccess formatonomiDataAccess=new FormatoNomiDataAccess();

			formatonomiDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			formatonomiDataAccess.setConnexionType(this.connexionType);
			formatonomiDataAccess.setParameterDbType(this.parameterDbType);

			formatonomi=formatonomiDataAccess.getEntity(connexion,relevaluacionnomi.getid_formato_nomi());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formatonomi;

	}

	public Estructura getEstructura(Connexion connexion,EvaluacionNomi relevaluacionnomi)throws SQLException,Exception {

		Estructura estructura= new Estructura();

		try {
			EstructuraDataAccess estructuraDataAccess=new EstructuraDataAccess();

			estructuraDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estructuraDataAccess.setConnexionType(this.connexionType);
			estructuraDataAccess.setParameterDbType(this.parameterDbType);

			estructura=estructuraDataAccess.getEntity(connexion,relevaluacionnomi.getid_estructura());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estructura;

	}


		
		public List<DetalleEvaluacionNomi> getDetalleEvaluacionNomis(Connexion connexion,EvaluacionNomi evaluacionnomi)throws SQLException,Exception {

		List<DetalleEvaluacionNomi> detalleevaluacionnomis= new ArrayList<DetalleEvaluacionNomi>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EvaluacionNomiConstantesFunciones.SCHEMA+".evaluacion_nomi ON "+DetalleEvaluacionNomiConstantesFunciones.SCHEMA+".detalle_evaluacion_nomi.id_evaluacion_nomi="+EvaluacionNomiConstantesFunciones.SCHEMA+".evaluacion_nomi.id WHERE "+EvaluacionNomiConstantesFunciones.SCHEMA+".evaluacion_nomi.id="+String.valueOf(evaluacionnomi.getId());
			} else {
				sQuery=" INNER JOIN detalleevaluacionnomi.EvaluacionNomi WHERE detalleevaluacionnomi.EvaluacionNomi.id="+String.valueOf(evaluacionnomi.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleEvaluacionNomiDataAccess detalleevaluacionnomiDataAccess=new DetalleEvaluacionNomiDataAccess();

			detalleevaluacionnomiDataAccess.setConnexionType(this.connexionType);
			detalleevaluacionnomiDataAccess.setParameterDbType(this.parameterDbType);
			detalleevaluacionnomis=detalleevaluacionnomiDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalleevaluacionnomis;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,EvaluacionNomi evaluacionnomi) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!evaluacionnomi.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(evaluacionnomi.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(evaluacionnomi.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(evaluacionnomi.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(evaluacionnomi.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(evaluacionnomi.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado_evaluador=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado_evaluador.setValue(evaluacionnomi.getid_empleado_evaluador());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado_evaluador);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_formato_nomi=new ParameterValue<Long>();
					parameterMaintenanceValueid_formato_nomi.setValue(evaluacionnomi.getid_formato_nomi());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_formato_nomi);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estructura=new ParameterValue<Long>();
					parameterMaintenanceValueid_estructura.setValue(evaluacionnomi.getid_estructura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estructura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha=new ParameterValue<Date>();
					parameterMaintenanceValuefecha.setValue(evaluacionnomi.getfecha());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueinstrucciones=new ParameterValue<String>();
					parameterMaintenanceValueinstrucciones.setValue(evaluacionnomi.getinstrucciones());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueinstrucciones);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(evaluacionnomi.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion2=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion2.setValue(evaluacionnomi.getdescripcion2());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion2);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion3=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion3.setValue(evaluacionnomi.getdescripcion3());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion3);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion4=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion4.setValue(evaluacionnomi.getdescripcion4());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion4);
					parametersTemp.add(parameterMaintenance);
					
						if(!evaluacionnomi.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(evaluacionnomi.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(evaluacionnomi.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(evaluacionnomi.getId());
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
	
	public void setIsNewIsChangedFalseEvaluacionNomi(EvaluacionNomi evaluacionnomi)throws Exception  {		
		evaluacionnomi.setIsNew(false);
		evaluacionnomi.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseEvaluacionNomis(List<EvaluacionNomi> evaluacionnomis)throws Exception  {				
		for(EvaluacionNomi evaluacionnomi:evaluacionnomis) {
			evaluacionnomi.setIsNew(false);
			evaluacionnomi.setIsChanged(false);
		}
	}
	
	public void generarExportarEvaluacionNomi(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
