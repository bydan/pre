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
import com.bydan.erp.nomina.util.*;//TipoEvaluacionEmpleadoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class TipoEvaluacionEmpleadoDataAccess extends  TipoEvaluacionEmpleadoDataAccessAdditional{ //TipoEvaluacionEmpleadoDataAccessAdditional,DataAccessHelper<TipoEvaluacionEmpleado>
	//static Logger logger = Logger.getLogger(TipoEvaluacionEmpleadoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_evaluacion_empleado";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoEvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+TipoEvaluacionEmpleadoConstantesFunciones.TABLENAME+"(version_row,id_empresa,codigo,nombre)values(current_timestamp,?,?,?)";
	public static String QUERYUPDATE="update "+TipoEvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+TipoEvaluacionEmpleadoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,codigo=?,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoEvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+TipoEvaluacionEmpleadoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tipoevaluacionempleado from "+TipoEvaluacionEmpleadoConstantesFunciones.SPERSISTENCENAME+" tipoevaluacionempleado";
	public static String QUERYSELECTNATIVE="select "+TipoEvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+TipoEvaluacionEmpleadoConstantesFunciones.TABLENAME+".id,"+TipoEvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+TipoEvaluacionEmpleadoConstantesFunciones.TABLENAME+".version_row,"+TipoEvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+TipoEvaluacionEmpleadoConstantesFunciones.TABLENAME+".id_empresa,"+TipoEvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+TipoEvaluacionEmpleadoConstantesFunciones.TABLENAME+".codigo,"+TipoEvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+TipoEvaluacionEmpleadoConstantesFunciones.TABLENAME+".nombre from "+TipoEvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+TipoEvaluacionEmpleadoConstantesFunciones.TABLENAME;//+" as "+TipoEvaluacionEmpleadoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoEvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+TipoEvaluacionEmpleadoConstantesFunciones.TABLENAME+".id,"+TipoEvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+TipoEvaluacionEmpleadoConstantesFunciones.TABLENAME+".version_row,"+TipoEvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+TipoEvaluacionEmpleadoConstantesFunciones.TABLENAME+".codigo from "+TipoEvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+TipoEvaluacionEmpleadoConstantesFunciones.TABLENAME;//+" as "+TipoEvaluacionEmpleadoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoEvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+TipoEvaluacionEmpleadoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,codigo=?,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPOEVALUACIONEMPLEADO_INSERT(?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPOEVALUACIONEMPLEADO_UPDATE(?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPOEVALUACIONEMPLEADO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPOEVALUACIONEMPLEADO_SELECT(?,?)";
	
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
	
	
	protected TipoEvaluacionEmpleadoDataAccessAdditional tipoevaluacionempleadoDataAccessAdditional=null;
	
	public TipoEvaluacionEmpleadoDataAccessAdditional getTipoEvaluacionEmpleadoDataAccessAdditional() {
		return this.tipoevaluacionempleadoDataAccessAdditional;
	}
	
	public void setTipoEvaluacionEmpleadoDataAccessAdditional(TipoEvaluacionEmpleadoDataAccessAdditional tipoevaluacionempleadoDataAccessAdditional) {
		try {
			this.tipoevaluacionempleadoDataAccessAdditional=tipoevaluacionempleadoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TipoEvaluacionEmpleadoDataAccess() {
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
		TipoEvaluacionEmpleadoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoEvaluacionEmpleadoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoEvaluacionEmpleadoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoEvaluacionEmpleadoOriginal(TipoEvaluacionEmpleado tipoevaluacionempleado)throws Exception  {
		tipoevaluacionempleado.setTipoEvaluacionEmpleadoOriginal((TipoEvaluacionEmpleado)tipoevaluacionempleado.clone());		
	}
	
	public void setTipoEvaluacionEmpleadosOriginal(List<TipoEvaluacionEmpleado> tipoevaluacionempleados)throws Exception  {
		
		for(TipoEvaluacionEmpleado tipoevaluacionempleado:tipoevaluacionempleados){
			tipoevaluacionempleado.setTipoEvaluacionEmpleadoOriginal((TipoEvaluacionEmpleado)tipoevaluacionempleado.clone());
		}
	}
	
	public static void setTipoEvaluacionEmpleadoOriginalStatic(TipoEvaluacionEmpleado tipoevaluacionempleado)throws Exception  {
		tipoevaluacionempleado.setTipoEvaluacionEmpleadoOriginal((TipoEvaluacionEmpleado)tipoevaluacionempleado.clone());		
	}
	
	public static void setTipoEvaluacionEmpleadosOriginalStatic(List<TipoEvaluacionEmpleado> tipoevaluacionempleados)throws Exception  {
		
		for(TipoEvaluacionEmpleado tipoevaluacionempleado:tipoevaluacionempleados){
			tipoevaluacionempleado.setTipoEvaluacionEmpleadoOriginal((TipoEvaluacionEmpleado)tipoevaluacionempleado.clone());
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
	
	public  TipoEvaluacionEmpleado getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoEvaluacionEmpleado entity = new TipoEvaluacionEmpleado();		
		
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
	
	public  TipoEvaluacionEmpleado getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoEvaluacionEmpleado entity = new TipoEvaluacionEmpleado();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoEvaluacionEmpleadoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoEvaluacionEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.TipoEvaluacionEmpleado.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoEvaluacionEmpleadoOriginal(new TipoEvaluacionEmpleado());
      	    	entity=super.getEntity("",entity,resultSet,TipoEvaluacionEmpleadoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoEvaluacionEmpleado("",entity,resultSet); 
				
				//entity.setTipoEvaluacionEmpleadoOriginal(super.getEntity("",entity.getTipoEvaluacionEmpleadoOriginal(),resultSet,TipoEvaluacionEmpleadoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoEvaluacionEmpleadoOriginal(this.getEntityTipoEvaluacionEmpleado("",entity.getTipoEvaluacionEmpleadoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoEvaluacionEmpleado(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoEvaluacionEmpleado getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoEvaluacionEmpleado entity = new TipoEvaluacionEmpleado();
				
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
	
	public  TipoEvaluacionEmpleado getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoEvaluacionEmpleado entity = new TipoEvaluacionEmpleado();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoEvaluacionEmpleadoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoEvaluacionEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoEvaluacionEmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.TipoEvaluacionEmpleado.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoEvaluacionEmpleadoOriginal(new TipoEvaluacionEmpleado());
      	    	entity=super.getEntity("",entity,resultSet,TipoEvaluacionEmpleadoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoEvaluacionEmpleado("",entity,resultSet);    
				
				//entity.setTipoEvaluacionEmpleadoOriginal(super.getEntity("",entity.getTipoEvaluacionEmpleadoOriginal(),resultSet,TipoEvaluacionEmpleadoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoEvaluacionEmpleadoOriginal(this.getEntityTipoEvaluacionEmpleado("",entity.getTipoEvaluacionEmpleadoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoEvaluacionEmpleado(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoEvaluacionEmpleado
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoEvaluacionEmpleado entity = new TipoEvaluacionEmpleado();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoEvaluacionEmpleadoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoEvaluacionEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoEvaluacionEmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.TipoEvaluacionEmpleado.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoEvaluacionEmpleado(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoEvaluacionEmpleado> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoEvaluacionEmpleado> entities = new  ArrayList<TipoEvaluacionEmpleado>();
		TipoEvaluacionEmpleado entity = new TipoEvaluacionEmpleado();		  
		
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
	
	public  List<TipoEvaluacionEmpleado> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoEvaluacionEmpleado> entities = new  ArrayList<TipoEvaluacionEmpleado>();
		TipoEvaluacionEmpleado entity = new TipoEvaluacionEmpleado();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoEvaluacionEmpleadoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoEvaluacionEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoEvaluacionEmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoEvaluacionEmpleado();
      	    	entity=super.getEntity("",entity,resultSet,TipoEvaluacionEmpleadoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoEvaluacionEmpleado("",entity,resultSet);
      	    	
				//entity.setTipoEvaluacionEmpleadoOriginal( new TipoEvaluacionEmpleado());
      	    	//entity.setTipoEvaluacionEmpleadoOriginal(super.getEntity("",entity.getTipoEvaluacionEmpleadoOriginal(),resultSet,TipoEvaluacionEmpleadoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoEvaluacionEmpleadoOriginal(this.getEntityTipoEvaluacionEmpleado("",entity.getTipoEvaluacionEmpleadoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoEvaluacionEmpleados(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoEvaluacionEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoEvaluacionEmpleado> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoEvaluacionEmpleado> entities = new  ArrayList<TipoEvaluacionEmpleado>();
		TipoEvaluacionEmpleado entity = new TipoEvaluacionEmpleado();		  
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
	
	public  List<TipoEvaluacionEmpleado> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoEvaluacionEmpleado> entities = new  ArrayList<TipoEvaluacionEmpleado>();
		TipoEvaluacionEmpleado entity = new TipoEvaluacionEmpleado();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoEvaluacionEmpleado();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoEvaluacionEmpleado();
					//entity.setMapTipoEvaluacionEmpleado(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoEvaluacionEmpleadoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoEvaluacionEmpleado().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoEvaluacionEmpleadoDataAccess.ISWITHSCHEMA);         		
					entity=TipoEvaluacionEmpleadoDataAccess.getEntityTipoEvaluacionEmpleado("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoEvaluacionEmpleadoOriginal( new TipoEvaluacionEmpleado());
					////entity.setTipoEvaluacionEmpleadoOriginal(super.getEntity("",entity.getTipoEvaluacionEmpleadoOriginal(),resultSet,TipoEvaluacionEmpleadoDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoEvaluacionEmpleadoOriginal(this.getEntityTipoEvaluacionEmpleado("",entity.getTipoEvaluacionEmpleadoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoEvaluacionEmpleados(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoEvaluacionEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoEvaluacionEmpleado getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoEvaluacionEmpleado entity = new TipoEvaluacionEmpleado();		  
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
	
	public  TipoEvaluacionEmpleado getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoEvaluacionEmpleado entity = new TipoEvaluacionEmpleado();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoEvaluacionEmpleado();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoEvaluacionEmpleado();
					//entity.setMapTipoEvaluacionEmpleado(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoEvaluacionEmpleadoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoEvaluacionEmpleado().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoEvaluacionEmpleadoDataAccess.ISWITHSCHEMA);         		
					entity=TipoEvaluacionEmpleadoDataAccess.getEntityTipoEvaluacionEmpleado("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoEvaluacionEmpleadoOriginal( new TipoEvaluacionEmpleado());
					////entity.setTipoEvaluacionEmpleadoOriginal(super.getEntity("",entity.getTipoEvaluacionEmpleadoOriginal(),resultSet,TipoEvaluacionEmpleadoDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoEvaluacionEmpleadoOriginal(this.getEntityTipoEvaluacionEmpleado("",entity.getTipoEvaluacionEmpleadoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoEvaluacionEmpleado(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoEvaluacionEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoEvaluacionEmpleado getEntityTipoEvaluacionEmpleado(String strPrefijo,TipoEvaluacionEmpleado entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoEvaluacionEmpleado.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoEvaluacionEmpleado.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoEvaluacionEmpleadoDataAccess.setFieldReflectionTipoEvaluacionEmpleado(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoEvaluacionEmpleado=TipoEvaluacionEmpleadoConstantesFunciones.getTodosTiposColumnasTipoEvaluacionEmpleado();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoEvaluacionEmpleado) {
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
							field = TipoEvaluacionEmpleado.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoEvaluacionEmpleado.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoEvaluacionEmpleadoDataAccess.setFieldReflectionTipoEvaluacionEmpleado(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoEvaluacionEmpleado(Field field,String strPrefijo,String sColumn,TipoEvaluacionEmpleado entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoEvaluacionEmpleadoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoEvaluacionEmpleadoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoEvaluacionEmpleadoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoEvaluacionEmpleadoConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoEvaluacionEmpleadoConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoEvaluacionEmpleado>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoEvaluacionEmpleado> entities = new  ArrayList<TipoEvaluacionEmpleado>();
		TipoEvaluacionEmpleado entity = new TipoEvaluacionEmpleado();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoEvaluacionEmpleadoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoEvaluacionEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoEvaluacionEmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoEvaluacionEmpleado();
					entity=super.getEntity("",entity,resultSet,TipoEvaluacionEmpleadoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoEvaluacionEmpleado("",entity,resultSet);
					
					//entity.setTipoEvaluacionEmpleadoOriginal( new TipoEvaluacionEmpleado());
					//entity.setTipoEvaluacionEmpleadoOriginal(super.getEntity("",entity.getTipoEvaluacionEmpleadoOriginal(),resultSet,TipoEvaluacionEmpleadoDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoEvaluacionEmpleadoOriginal(this.getEntityTipoEvaluacionEmpleado("",entity.getTipoEvaluacionEmpleadoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoEvaluacionEmpleados(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoEvaluacionEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoEvaluacionEmpleado>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoEvaluacionEmpleado> entities = new  ArrayList<TipoEvaluacionEmpleado>();
		TipoEvaluacionEmpleado entity = new TipoEvaluacionEmpleado();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoEvaluacionEmpleadoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoEvaluacionEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoEvaluacionEmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoEvaluacionEmpleado> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoEvaluacionEmpleado> entities = new  ArrayList<TipoEvaluacionEmpleado>();
		TipoEvaluacionEmpleado entity = new TipoEvaluacionEmpleado();		  
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
	
	public  List<TipoEvaluacionEmpleado> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoEvaluacionEmpleado> entities = new  ArrayList<TipoEvaluacionEmpleado>();
		TipoEvaluacionEmpleado entity = new TipoEvaluacionEmpleado();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoEvaluacionEmpleado();
      	    	entity=super.getEntity("",entity,resultSet,TipoEvaluacionEmpleadoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoEvaluacionEmpleado("",entity,resultSet);
      	    	
				//entity.setTipoEvaluacionEmpleadoOriginal( new TipoEvaluacionEmpleado());
      	    	//entity.setTipoEvaluacionEmpleadoOriginal(super.getEntity("",entity.getTipoEvaluacionEmpleadoOriginal(),resultSet,TipoEvaluacionEmpleadoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoEvaluacionEmpleadoOriginal(this.getEntityTipoEvaluacionEmpleado("",entity.getTipoEvaluacionEmpleadoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoEvaluacionEmpleados(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoEvaluacionEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoEvaluacionEmpleado> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoEvaluacionEmpleado> entities = new  ArrayList<TipoEvaluacionEmpleado>();
		TipoEvaluacionEmpleado entity = new TipoEvaluacionEmpleado();		  
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
	
	public  List<TipoEvaluacionEmpleado> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoEvaluacionEmpleado> entities = new  ArrayList<TipoEvaluacionEmpleado>();
		TipoEvaluacionEmpleado entity = new TipoEvaluacionEmpleado();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoEvaluacionEmpleado();
      	    	entity=super.getEntity("",entity,resultSet,TipoEvaluacionEmpleadoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoEvaluacionEmpleado("",entity,resultSet);
      	    	
				//entity.setTipoEvaluacionEmpleadoOriginal( new TipoEvaluacionEmpleado());
      	    	//entity.setTipoEvaluacionEmpleadoOriginal(super.getEntity("",entity.getTipoEvaluacionEmpleadoOriginal(),resultSet,TipoEvaluacionEmpleadoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoEvaluacionEmpleadoOriginal(this.getEntityTipoEvaluacionEmpleado("",entity.getTipoEvaluacionEmpleadoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoEvaluacionEmpleados(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public TipoEvaluacionEmpleado getEntityTipoEvaluacionEmpleado(String strPrefijo,TipoEvaluacionEmpleado entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+TipoEvaluacionEmpleadoConstantesFunciones.IDEMPRESA));
				entity.setcodigo(resultSet.getString(strPrefijo+TipoEvaluacionEmpleadoConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+TipoEvaluacionEmpleadoConstantesFunciones.NOMBRE));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+TipoEvaluacionEmpleadoConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoEvaluacionEmpleado(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoEvaluacionEmpleado entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoEvaluacionEmpleadoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoEvaluacionEmpleadoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoEvaluacionEmpleadoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoEvaluacionEmpleadoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoEvaluacionEmpleadoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,TipoEvaluacionEmpleadoDataAccess.TABLENAME,TipoEvaluacionEmpleadoDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoEvaluacionEmpleadoDataAccess.setTipoEvaluacionEmpleadoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,TipoEvaluacionEmpleado reltipoevaluacionempleado)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reltipoevaluacionempleado.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}


		
		public List<EvaluacionEmpleado> getEvaluacionEmpleados(Connexion connexion,TipoEvaluacionEmpleado tipoevaluacionempleado)throws SQLException,Exception {

		List<EvaluacionEmpleado> evaluacionempleados= new ArrayList<EvaluacionEmpleado>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoEvaluacionEmpleadoConstantesFunciones.SCHEMA+".tipo_evaluacion_empleado ON "+EvaluacionEmpleadoConstantesFunciones.SCHEMA+".evaluacion_empleado.id_tipo_evaluacion_empleado="+TipoEvaluacionEmpleadoConstantesFunciones.SCHEMA+".tipo_evaluacion_empleado.id WHERE "+TipoEvaluacionEmpleadoConstantesFunciones.SCHEMA+".tipo_evaluacion_empleado.id="+String.valueOf(tipoevaluacionempleado.getId());
			} else {
				sQuery=" INNER JOIN evaluacionempleado.TipoEvaluacionEmpleado WHERE evaluacionempleado.TipoEvaluacionEmpleado.id="+String.valueOf(tipoevaluacionempleado.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			EvaluacionEmpleadoDataAccess evaluacionempleadoDataAccess=new EvaluacionEmpleadoDataAccess();

			evaluacionempleadoDataAccess.setConnexionType(this.connexionType);
			evaluacionempleadoDataAccess.setParameterDbType(this.parameterDbType);
			evaluacionempleados=evaluacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return evaluacionempleados;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoEvaluacionEmpleado tipoevaluacionempleado) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tipoevaluacionempleado.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(tipoevaluacionempleado.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(tipoevaluacionempleado.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tipoevaluacionempleado.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!tipoevaluacionempleado.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tipoevaluacionempleado.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tipoevaluacionempleado.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tipoevaluacionempleado.getId());
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
	
	public void setIsNewIsChangedFalseTipoEvaluacionEmpleado(TipoEvaluacionEmpleado tipoevaluacionempleado)throws Exception  {		
		tipoevaluacionempleado.setIsNew(false);
		tipoevaluacionempleado.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoEvaluacionEmpleados(List<TipoEvaluacionEmpleado> tipoevaluacionempleados)throws Exception  {				
		for(TipoEvaluacionEmpleado tipoevaluacionempleado:tipoevaluacionempleados) {
			tipoevaluacionempleado.setIsNew(false);
			tipoevaluacionempleado.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoEvaluacionEmpleado(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
