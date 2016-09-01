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
import com.bydan.erp.nomina.util.*;//TipoCalificacionEmpleadoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class TipoCalificacionEmpleadoDataAccess extends  TipoCalificacionEmpleadoDataAccessAdditional{ //TipoCalificacionEmpleadoDataAccessAdditional,DataAccessHelper<TipoCalificacionEmpleado>
	//static Logger logger = Logger.getLogger(TipoCalificacionEmpleadoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_calificacion_empleado";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoCalificacionEmpleadoConstantesFunciones.SCHEMA+"."+TipoCalificacionEmpleadoConstantesFunciones.TABLENAME+"(version_row,id_empresa,codigo,nombre)values(current_timestamp,?,?,?)";
	public static String QUERYUPDATE="update "+TipoCalificacionEmpleadoConstantesFunciones.SCHEMA+"."+TipoCalificacionEmpleadoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,codigo=?,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoCalificacionEmpleadoConstantesFunciones.SCHEMA+"."+TipoCalificacionEmpleadoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tipocalificacionempleado from "+TipoCalificacionEmpleadoConstantesFunciones.SPERSISTENCENAME+" tipocalificacionempleado";
	public static String QUERYSELECTNATIVE="select "+TipoCalificacionEmpleadoConstantesFunciones.SCHEMA+"."+TipoCalificacionEmpleadoConstantesFunciones.TABLENAME+".id,"+TipoCalificacionEmpleadoConstantesFunciones.SCHEMA+"."+TipoCalificacionEmpleadoConstantesFunciones.TABLENAME+".version_row,"+TipoCalificacionEmpleadoConstantesFunciones.SCHEMA+"."+TipoCalificacionEmpleadoConstantesFunciones.TABLENAME+".id_empresa,"+TipoCalificacionEmpleadoConstantesFunciones.SCHEMA+"."+TipoCalificacionEmpleadoConstantesFunciones.TABLENAME+".codigo,"+TipoCalificacionEmpleadoConstantesFunciones.SCHEMA+"."+TipoCalificacionEmpleadoConstantesFunciones.TABLENAME+".nombre from "+TipoCalificacionEmpleadoConstantesFunciones.SCHEMA+"."+TipoCalificacionEmpleadoConstantesFunciones.TABLENAME;//+" as "+TipoCalificacionEmpleadoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoCalificacionEmpleadoConstantesFunciones.SCHEMA+"."+TipoCalificacionEmpleadoConstantesFunciones.TABLENAME+".id,"+TipoCalificacionEmpleadoConstantesFunciones.SCHEMA+"."+TipoCalificacionEmpleadoConstantesFunciones.TABLENAME+".version_row,"+TipoCalificacionEmpleadoConstantesFunciones.SCHEMA+"."+TipoCalificacionEmpleadoConstantesFunciones.TABLENAME+".codigo from "+TipoCalificacionEmpleadoConstantesFunciones.SCHEMA+"."+TipoCalificacionEmpleadoConstantesFunciones.TABLENAME;//+" as "+TipoCalificacionEmpleadoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoCalificacionEmpleadoConstantesFunciones.SCHEMA+"."+TipoCalificacionEmpleadoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,codigo=?,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPOCALIFICACIONEMPLEADO_INSERT(?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPOCALIFICACIONEMPLEADO_UPDATE(?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPOCALIFICACIONEMPLEADO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPOCALIFICACIONEMPLEADO_SELECT(?,?)";
	
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
	
	
	protected TipoCalificacionEmpleadoDataAccessAdditional tipocalificacionempleadoDataAccessAdditional=null;
	
	public TipoCalificacionEmpleadoDataAccessAdditional getTipoCalificacionEmpleadoDataAccessAdditional() {
		return this.tipocalificacionempleadoDataAccessAdditional;
	}
	
	public void setTipoCalificacionEmpleadoDataAccessAdditional(TipoCalificacionEmpleadoDataAccessAdditional tipocalificacionempleadoDataAccessAdditional) {
		try {
			this.tipocalificacionempleadoDataAccessAdditional=tipocalificacionempleadoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TipoCalificacionEmpleadoDataAccess() {
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
		TipoCalificacionEmpleadoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoCalificacionEmpleadoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoCalificacionEmpleadoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoCalificacionEmpleadoOriginal(TipoCalificacionEmpleado tipocalificacionempleado)throws Exception  {
		tipocalificacionempleado.setTipoCalificacionEmpleadoOriginal((TipoCalificacionEmpleado)tipocalificacionempleado.clone());		
	}
	
	public void setTipoCalificacionEmpleadosOriginal(List<TipoCalificacionEmpleado> tipocalificacionempleados)throws Exception  {
		
		for(TipoCalificacionEmpleado tipocalificacionempleado:tipocalificacionempleados){
			tipocalificacionempleado.setTipoCalificacionEmpleadoOriginal((TipoCalificacionEmpleado)tipocalificacionempleado.clone());
		}
	}
	
	public static void setTipoCalificacionEmpleadoOriginalStatic(TipoCalificacionEmpleado tipocalificacionempleado)throws Exception  {
		tipocalificacionempleado.setTipoCalificacionEmpleadoOriginal((TipoCalificacionEmpleado)tipocalificacionempleado.clone());		
	}
	
	public static void setTipoCalificacionEmpleadosOriginalStatic(List<TipoCalificacionEmpleado> tipocalificacionempleados)throws Exception  {
		
		for(TipoCalificacionEmpleado tipocalificacionempleado:tipocalificacionempleados){
			tipocalificacionempleado.setTipoCalificacionEmpleadoOriginal((TipoCalificacionEmpleado)tipocalificacionempleado.clone());
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
	
	public  TipoCalificacionEmpleado getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoCalificacionEmpleado entity = new TipoCalificacionEmpleado();		
		
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
	
	public  TipoCalificacionEmpleado getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoCalificacionEmpleado entity = new TipoCalificacionEmpleado();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoCalificacionEmpleadoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoCalificacionEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.TipoCalificacionEmpleado.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoCalificacionEmpleadoOriginal(new TipoCalificacionEmpleado());
      	    	entity=super.getEntity("",entity,resultSet,TipoCalificacionEmpleadoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoCalificacionEmpleado("",entity,resultSet); 
				
				//entity.setTipoCalificacionEmpleadoOriginal(super.getEntity("",entity.getTipoCalificacionEmpleadoOriginal(),resultSet,TipoCalificacionEmpleadoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoCalificacionEmpleadoOriginal(this.getEntityTipoCalificacionEmpleado("",entity.getTipoCalificacionEmpleadoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoCalificacionEmpleado(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoCalificacionEmpleado getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoCalificacionEmpleado entity = new TipoCalificacionEmpleado();
				
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
	
	public  TipoCalificacionEmpleado getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoCalificacionEmpleado entity = new TipoCalificacionEmpleado();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoCalificacionEmpleadoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoCalificacionEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoCalificacionEmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.TipoCalificacionEmpleado.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoCalificacionEmpleadoOriginal(new TipoCalificacionEmpleado());
      	    	entity=super.getEntity("",entity,resultSet,TipoCalificacionEmpleadoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoCalificacionEmpleado("",entity,resultSet);    
				
				//entity.setTipoCalificacionEmpleadoOriginal(super.getEntity("",entity.getTipoCalificacionEmpleadoOriginal(),resultSet,TipoCalificacionEmpleadoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoCalificacionEmpleadoOriginal(this.getEntityTipoCalificacionEmpleado("",entity.getTipoCalificacionEmpleadoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoCalificacionEmpleado(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoCalificacionEmpleado
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoCalificacionEmpleado entity = new TipoCalificacionEmpleado();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoCalificacionEmpleadoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoCalificacionEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoCalificacionEmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.TipoCalificacionEmpleado.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoCalificacionEmpleado(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoCalificacionEmpleado> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoCalificacionEmpleado> entities = new  ArrayList<TipoCalificacionEmpleado>();
		TipoCalificacionEmpleado entity = new TipoCalificacionEmpleado();		  
		
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
	
	public  List<TipoCalificacionEmpleado> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoCalificacionEmpleado> entities = new  ArrayList<TipoCalificacionEmpleado>();
		TipoCalificacionEmpleado entity = new TipoCalificacionEmpleado();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoCalificacionEmpleadoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoCalificacionEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoCalificacionEmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoCalificacionEmpleado();
      	    	entity=super.getEntity("",entity,resultSet,TipoCalificacionEmpleadoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoCalificacionEmpleado("",entity,resultSet);
      	    	
				//entity.setTipoCalificacionEmpleadoOriginal( new TipoCalificacionEmpleado());
      	    	//entity.setTipoCalificacionEmpleadoOriginal(super.getEntity("",entity.getTipoCalificacionEmpleadoOriginal(),resultSet,TipoCalificacionEmpleadoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoCalificacionEmpleadoOriginal(this.getEntityTipoCalificacionEmpleado("",entity.getTipoCalificacionEmpleadoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoCalificacionEmpleados(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoCalificacionEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoCalificacionEmpleado> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoCalificacionEmpleado> entities = new  ArrayList<TipoCalificacionEmpleado>();
		TipoCalificacionEmpleado entity = new TipoCalificacionEmpleado();		  
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
	
	public  List<TipoCalificacionEmpleado> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoCalificacionEmpleado> entities = new  ArrayList<TipoCalificacionEmpleado>();
		TipoCalificacionEmpleado entity = new TipoCalificacionEmpleado();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoCalificacionEmpleado();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoCalificacionEmpleado();
					//entity.setMapTipoCalificacionEmpleado(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoCalificacionEmpleadoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoCalificacionEmpleado().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoCalificacionEmpleadoDataAccess.ISWITHSCHEMA);         		
					entity=TipoCalificacionEmpleadoDataAccess.getEntityTipoCalificacionEmpleado("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoCalificacionEmpleadoOriginal( new TipoCalificacionEmpleado());
					////entity.setTipoCalificacionEmpleadoOriginal(super.getEntity("",entity.getTipoCalificacionEmpleadoOriginal(),resultSet,TipoCalificacionEmpleadoDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoCalificacionEmpleadoOriginal(this.getEntityTipoCalificacionEmpleado("",entity.getTipoCalificacionEmpleadoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoCalificacionEmpleados(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoCalificacionEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoCalificacionEmpleado getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoCalificacionEmpleado entity = new TipoCalificacionEmpleado();		  
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
	
	public  TipoCalificacionEmpleado getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoCalificacionEmpleado entity = new TipoCalificacionEmpleado();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoCalificacionEmpleado();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoCalificacionEmpleado();
					//entity.setMapTipoCalificacionEmpleado(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoCalificacionEmpleadoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoCalificacionEmpleado().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoCalificacionEmpleadoDataAccess.ISWITHSCHEMA);         		
					entity=TipoCalificacionEmpleadoDataAccess.getEntityTipoCalificacionEmpleado("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoCalificacionEmpleadoOriginal( new TipoCalificacionEmpleado());
					////entity.setTipoCalificacionEmpleadoOriginal(super.getEntity("",entity.getTipoCalificacionEmpleadoOriginal(),resultSet,TipoCalificacionEmpleadoDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoCalificacionEmpleadoOriginal(this.getEntityTipoCalificacionEmpleado("",entity.getTipoCalificacionEmpleadoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoCalificacionEmpleado(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoCalificacionEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoCalificacionEmpleado getEntityTipoCalificacionEmpleado(String strPrefijo,TipoCalificacionEmpleado entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoCalificacionEmpleado.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoCalificacionEmpleado.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoCalificacionEmpleadoDataAccess.setFieldReflectionTipoCalificacionEmpleado(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoCalificacionEmpleado=TipoCalificacionEmpleadoConstantesFunciones.getTodosTiposColumnasTipoCalificacionEmpleado();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoCalificacionEmpleado) {
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
							field = TipoCalificacionEmpleado.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoCalificacionEmpleado.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoCalificacionEmpleadoDataAccess.setFieldReflectionTipoCalificacionEmpleado(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoCalificacionEmpleado(Field field,String strPrefijo,String sColumn,TipoCalificacionEmpleado entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoCalificacionEmpleadoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoCalificacionEmpleadoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoCalificacionEmpleadoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoCalificacionEmpleadoConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoCalificacionEmpleadoConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoCalificacionEmpleado>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoCalificacionEmpleado> entities = new  ArrayList<TipoCalificacionEmpleado>();
		TipoCalificacionEmpleado entity = new TipoCalificacionEmpleado();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoCalificacionEmpleadoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoCalificacionEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoCalificacionEmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoCalificacionEmpleado();
					entity=super.getEntity("",entity,resultSet,TipoCalificacionEmpleadoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoCalificacionEmpleado("",entity,resultSet);
					
					//entity.setTipoCalificacionEmpleadoOriginal( new TipoCalificacionEmpleado());
					//entity.setTipoCalificacionEmpleadoOriginal(super.getEntity("",entity.getTipoCalificacionEmpleadoOriginal(),resultSet,TipoCalificacionEmpleadoDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoCalificacionEmpleadoOriginal(this.getEntityTipoCalificacionEmpleado("",entity.getTipoCalificacionEmpleadoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoCalificacionEmpleados(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoCalificacionEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoCalificacionEmpleado>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoCalificacionEmpleado> entities = new  ArrayList<TipoCalificacionEmpleado>();
		TipoCalificacionEmpleado entity = new TipoCalificacionEmpleado();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoCalificacionEmpleadoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoCalificacionEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoCalificacionEmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoCalificacionEmpleado> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoCalificacionEmpleado> entities = new  ArrayList<TipoCalificacionEmpleado>();
		TipoCalificacionEmpleado entity = new TipoCalificacionEmpleado();		  
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
	
	public  List<TipoCalificacionEmpleado> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoCalificacionEmpleado> entities = new  ArrayList<TipoCalificacionEmpleado>();
		TipoCalificacionEmpleado entity = new TipoCalificacionEmpleado();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoCalificacionEmpleado();
      	    	entity=super.getEntity("",entity,resultSet,TipoCalificacionEmpleadoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoCalificacionEmpleado("",entity,resultSet);
      	    	
				//entity.setTipoCalificacionEmpleadoOriginal( new TipoCalificacionEmpleado());
      	    	//entity.setTipoCalificacionEmpleadoOriginal(super.getEntity("",entity.getTipoCalificacionEmpleadoOriginal(),resultSet,TipoCalificacionEmpleadoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoCalificacionEmpleadoOriginal(this.getEntityTipoCalificacionEmpleado("",entity.getTipoCalificacionEmpleadoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoCalificacionEmpleados(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoCalificacionEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoCalificacionEmpleado> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoCalificacionEmpleado> entities = new  ArrayList<TipoCalificacionEmpleado>();
		TipoCalificacionEmpleado entity = new TipoCalificacionEmpleado();		  
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
	
	public  List<TipoCalificacionEmpleado> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoCalificacionEmpleado> entities = new  ArrayList<TipoCalificacionEmpleado>();
		TipoCalificacionEmpleado entity = new TipoCalificacionEmpleado();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoCalificacionEmpleado();
      	    	entity=super.getEntity("",entity,resultSet,TipoCalificacionEmpleadoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoCalificacionEmpleado("",entity,resultSet);
      	    	
				//entity.setTipoCalificacionEmpleadoOriginal( new TipoCalificacionEmpleado());
      	    	//entity.setTipoCalificacionEmpleadoOriginal(super.getEntity("",entity.getTipoCalificacionEmpleadoOriginal(),resultSet,TipoCalificacionEmpleadoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoCalificacionEmpleadoOriginal(this.getEntityTipoCalificacionEmpleado("",entity.getTipoCalificacionEmpleadoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoCalificacionEmpleados(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public TipoCalificacionEmpleado getEntityTipoCalificacionEmpleado(String strPrefijo,TipoCalificacionEmpleado entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+TipoCalificacionEmpleadoConstantesFunciones.IDEMPRESA));
				entity.setcodigo(resultSet.getString(strPrefijo+TipoCalificacionEmpleadoConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+TipoCalificacionEmpleadoConstantesFunciones.NOMBRE));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+TipoCalificacionEmpleadoConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoCalificacionEmpleado(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoCalificacionEmpleado entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoCalificacionEmpleadoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoCalificacionEmpleadoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoCalificacionEmpleadoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoCalificacionEmpleadoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoCalificacionEmpleadoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,TipoCalificacionEmpleadoDataAccess.TABLENAME,TipoCalificacionEmpleadoDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoCalificacionEmpleadoDataAccess.setTipoCalificacionEmpleadoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,TipoCalificacionEmpleado reltipocalificacionempleado)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reltipocalificacionempleado.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}


		
		public List<CalificacionEmpleado> getCalificacionEmpleados(Connexion connexion,TipoCalificacionEmpleado tipocalificacionempleado)throws SQLException,Exception {

		List<CalificacionEmpleado> calificacionempleados= new ArrayList<CalificacionEmpleado>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoCalificacionEmpleadoConstantesFunciones.SCHEMA+".tipo_calificacion_empleado ON "+CalificacionEmpleadoConstantesFunciones.SCHEMA+".calificacion_empleado.id_tipo_calificacion_empleado="+TipoCalificacionEmpleadoConstantesFunciones.SCHEMA+".tipo_calificacion_empleado.id WHERE "+TipoCalificacionEmpleadoConstantesFunciones.SCHEMA+".tipo_calificacion_empleado.id="+String.valueOf(tipocalificacionempleado.getId());
			} else {
				sQuery=" INNER JOIN calificacionempleado.TipoCalificacionEmpleado WHERE calificacionempleado.TipoCalificacionEmpleado.id="+String.valueOf(tipocalificacionempleado.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			CalificacionEmpleadoDataAccess calificacionempleadoDataAccess=new CalificacionEmpleadoDataAccess();

			calificacionempleadoDataAccess.setConnexionType(this.connexionType);
			calificacionempleadoDataAccess.setParameterDbType(this.parameterDbType);
			calificacionempleados=calificacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return calificacionempleados;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoCalificacionEmpleado tipocalificacionempleado) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tipocalificacionempleado.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(tipocalificacionempleado.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(tipocalificacionempleado.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tipocalificacionempleado.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!tipocalificacionempleado.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tipocalificacionempleado.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tipocalificacionempleado.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tipocalificacionempleado.getId());
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
	
	public void setIsNewIsChangedFalseTipoCalificacionEmpleado(TipoCalificacionEmpleado tipocalificacionempleado)throws Exception  {		
		tipocalificacionempleado.setIsNew(false);
		tipocalificacionempleado.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoCalificacionEmpleados(List<TipoCalificacionEmpleado> tipocalificacionempleados)throws Exception  {				
		for(TipoCalificacionEmpleado tipocalificacionempleado:tipocalificacionempleados) {
			tipocalificacionempleado.setIsNew(false);
			tipocalificacionempleado.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoCalificacionEmpleado(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
