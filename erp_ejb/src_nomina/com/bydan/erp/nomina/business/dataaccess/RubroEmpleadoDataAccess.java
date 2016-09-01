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
import com.bydan.erp.nomina.util.*;//RubroEmpleadoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class RubroEmpleadoDataAccess extends  RubroEmpleadoDataAccessAdditional{ //RubroEmpleadoDataAccessAdditional,DataAccessHelper<RubroEmpleado>
	//static Logger logger = Logger.getLogger(RubroEmpleadoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="rubro_empleado";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+RubroEmpleadoConstantesFunciones.SCHEMA+"."+RubroEmpleadoConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_empleado,id_rubro_emplea,id_estado_rubro,valor)values(current_timestamp,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+RubroEmpleadoConstantesFunciones.SCHEMA+"."+RubroEmpleadoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_empleado=?,id_rubro_emplea=?,id_estado_rubro=?,valor=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+RubroEmpleadoConstantesFunciones.SCHEMA+"."+RubroEmpleadoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select rubroempleado from "+RubroEmpleadoConstantesFunciones.SPERSISTENCENAME+" rubroempleado";
	public static String QUERYSELECTNATIVE="select "+RubroEmpleadoConstantesFunciones.SCHEMA+"."+RubroEmpleadoConstantesFunciones.TABLENAME+".id,"+RubroEmpleadoConstantesFunciones.SCHEMA+"."+RubroEmpleadoConstantesFunciones.TABLENAME+".version_row,"+RubroEmpleadoConstantesFunciones.SCHEMA+"."+RubroEmpleadoConstantesFunciones.TABLENAME+".id_empresa,"+RubroEmpleadoConstantesFunciones.SCHEMA+"."+RubroEmpleadoConstantesFunciones.TABLENAME+".id_empleado,"+RubroEmpleadoConstantesFunciones.SCHEMA+"."+RubroEmpleadoConstantesFunciones.TABLENAME+".id_rubro_emplea,"+RubroEmpleadoConstantesFunciones.SCHEMA+"."+RubroEmpleadoConstantesFunciones.TABLENAME+".id_estado_rubro,"+RubroEmpleadoConstantesFunciones.SCHEMA+"."+RubroEmpleadoConstantesFunciones.TABLENAME+".valor from "+RubroEmpleadoConstantesFunciones.SCHEMA+"."+RubroEmpleadoConstantesFunciones.TABLENAME;//+" as "+RubroEmpleadoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+RubroEmpleadoConstantesFunciones.SCHEMA+"."+RubroEmpleadoConstantesFunciones.TABLENAME+".id,"+RubroEmpleadoConstantesFunciones.SCHEMA+"."+RubroEmpleadoConstantesFunciones.TABLENAME+".version_row from "+RubroEmpleadoConstantesFunciones.SCHEMA+"."+RubroEmpleadoConstantesFunciones.TABLENAME;//+" as "+RubroEmpleadoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+RubroEmpleadoConstantesFunciones.SCHEMA+"."+RubroEmpleadoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_empleado=?,id_rubro_emplea=?,id_estado_rubro=?,valor=?";
	
	public static String STOREPROCEDUREINSERT="call SP_RUBROEMPLEADO_INSERT(?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_RUBROEMPLEADO_UPDATE(?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_RUBROEMPLEADO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_RUBROEMPLEADO_SELECT(?,?)";
	
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
	
	
	protected RubroEmpleadoDataAccessAdditional rubroempleadoDataAccessAdditional=null;
	
	public RubroEmpleadoDataAccessAdditional getRubroEmpleadoDataAccessAdditional() {
		return this.rubroempleadoDataAccessAdditional;
	}
	
	public void setRubroEmpleadoDataAccessAdditional(RubroEmpleadoDataAccessAdditional rubroempleadoDataAccessAdditional) {
		try {
			this.rubroempleadoDataAccessAdditional=rubroempleadoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public RubroEmpleadoDataAccess() {
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
		RubroEmpleadoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		RubroEmpleadoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		RubroEmpleadoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setRubroEmpleadoOriginal(RubroEmpleado rubroempleado)throws Exception  {
		rubroempleado.setRubroEmpleadoOriginal((RubroEmpleado)rubroempleado.clone());		
	}
	
	public void setRubroEmpleadosOriginal(List<RubroEmpleado> rubroempleados)throws Exception  {
		
		for(RubroEmpleado rubroempleado:rubroempleados){
			rubroempleado.setRubroEmpleadoOriginal((RubroEmpleado)rubroempleado.clone());
		}
	}
	
	public static void setRubroEmpleadoOriginalStatic(RubroEmpleado rubroempleado)throws Exception  {
		rubroempleado.setRubroEmpleadoOriginal((RubroEmpleado)rubroempleado.clone());		
	}
	
	public static void setRubroEmpleadosOriginalStatic(List<RubroEmpleado> rubroempleados)throws Exception  {
		
		for(RubroEmpleado rubroempleado:rubroempleados){
			rubroempleado.setRubroEmpleadoOriginal((RubroEmpleado)rubroempleado.clone());
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
	
	public  RubroEmpleado getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		RubroEmpleado entity = new RubroEmpleado();		
		
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
	
	public  RubroEmpleado getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		RubroEmpleado entity = new RubroEmpleado();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=RubroEmpleadoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=RubroEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.RubroEmpleado.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setRubroEmpleadoOriginal(new RubroEmpleado());
      	    	entity=super.getEntity("",entity,resultSet,RubroEmpleadoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityRubroEmpleado("",entity,resultSet); 
				
				//entity.setRubroEmpleadoOriginal(super.getEntity("",entity.getRubroEmpleadoOriginal(),resultSet,RubroEmpleadoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRubroEmpleadoOriginal(this.getEntityRubroEmpleado("",entity.getRubroEmpleadoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseRubroEmpleado(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  RubroEmpleado getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		RubroEmpleado entity = new RubroEmpleado();
				
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
	
	public  RubroEmpleado getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		RubroEmpleado entity = new RubroEmpleado();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=RubroEmpleadoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=RubroEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RubroEmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.RubroEmpleado.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setRubroEmpleadoOriginal(new RubroEmpleado());
      	    	entity=super.getEntity("",entity,resultSet,RubroEmpleadoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityRubroEmpleado("",entity,resultSet);    
				
				//entity.setRubroEmpleadoOriginal(super.getEntity("",entity.getRubroEmpleadoOriginal(),resultSet,RubroEmpleadoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRubroEmpleadoOriginal(this.getEntityRubroEmpleado("",entity.getRubroEmpleadoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseRubroEmpleado(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //RubroEmpleado
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		RubroEmpleado entity = new RubroEmpleado();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=RubroEmpleadoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=RubroEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RubroEmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.RubroEmpleado.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseRubroEmpleado(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<RubroEmpleado> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<RubroEmpleado> entities = new  ArrayList<RubroEmpleado>();
		RubroEmpleado entity = new RubroEmpleado();		  
		
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
	
	public  List<RubroEmpleado> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<RubroEmpleado> entities = new  ArrayList<RubroEmpleado>();
		RubroEmpleado entity = new RubroEmpleado();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=RubroEmpleadoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=RubroEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RubroEmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new RubroEmpleado();
      	    	entity=super.getEntity("",entity,resultSet,RubroEmpleadoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityRubroEmpleado("",entity,resultSet);
      	    	
				//entity.setRubroEmpleadoOriginal( new RubroEmpleado());
      	    	//entity.setRubroEmpleadoOriginal(super.getEntity("",entity.getRubroEmpleadoOriginal(),resultSet,RubroEmpleadoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRubroEmpleadoOriginal(this.getEntityRubroEmpleado("",entity.getRubroEmpleadoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseRubroEmpleados(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRubroEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<RubroEmpleado> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<RubroEmpleado> entities = new  ArrayList<RubroEmpleado>();
		RubroEmpleado entity = new RubroEmpleado();		  
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
	
	public  List<RubroEmpleado> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<RubroEmpleado> entities = new  ArrayList<RubroEmpleado>();
		RubroEmpleado entity = new RubroEmpleado();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new RubroEmpleado();
				
				if(conMapGenerico) {
					entity.inicializarMapRubroEmpleado();
					//entity.setMapRubroEmpleado(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapRubroEmpleadoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapRubroEmpleado().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,RubroEmpleadoDataAccess.ISWITHSCHEMA);         		
					entity=RubroEmpleadoDataAccess.getEntityRubroEmpleado("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setRubroEmpleadoOriginal( new RubroEmpleado());
					////entity.setRubroEmpleadoOriginal(super.getEntity("",entity.getRubroEmpleadoOriginal(),resultSet,RubroEmpleadoDataAccess.ISWITHSCHEMA));         		
					////entity.setRubroEmpleadoOriginal(this.getEntityRubroEmpleado("",entity.getRubroEmpleadoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseRubroEmpleados(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRubroEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public RubroEmpleado getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		RubroEmpleado entity = new RubroEmpleado();		  
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
	
	public  RubroEmpleado getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		RubroEmpleado entity = new RubroEmpleado();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new RubroEmpleado();
				
				if(conMapGenerico) {
					entity.inicializarMapRubroEmpleado();
					//entity.setMapRubroEmpleado(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapRubroEmpleadoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapRubroEmpleado().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,RubroEmpleadoDataAccess.ISWITHSCHEMA);         		
					entity=RubroEmpleadoDataAccess.getEntityRubroEmpleado("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setRubroEmpleadoOriginal( new RubroEmpleado());
					////entity.setRubroEmpleadoOriginal(super.getEntity("",entity.getRubroEmpleadoOriginal(),resultSet,RubroEmpleadoDataAccess.ISWITHSCHEMA));         		
					////entity.setRubroEmpleadoOriginal(this.getEntityRubroEmpleado("",entity.getRubroEmpleadoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseRubroEmpleado(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRubroEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static RubroEmpleado getEntityRubroEmpleado(String strPrefijo,RubroEmpleado entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = RubroEmpleado.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = RubroEmpleado.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					RubroEmpleadoDataAccess.setFieldReflectionRubroEmpleado(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasRubroEmpleado=RubroEmpleadoConstantesFunciones.getTodosTiposColumnasRubroEmpleado();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasRubroEmpleado) {
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
							field = RubroEmpleado.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = RubroEmpleado.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						RubroEmpleadoDataAccess.setFieldReflectionRubroEmpleado(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionRubroEmpleado(Field field,String strPrefijo,String sColumn,RubroEmpleado entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case RubroEmpleadoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RubroEmpleadoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RubroEmpleadoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RubroEmpleadoConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RubroEmpleadoConstantesFunciones.IDRUBROEMPLEA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RubroEmpleadoConstantesFunciones.IDESTADORUBRO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RubroEmpleadoConstantesFunciones.VALOR:
					field.set(entity,resultSet.getDouble(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<RubroEmpleado>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<RubroEmpleado> entities = new  ArrayList<RubroEmpleado>();
		RubroEmpleado entity = new RubroEmpleado();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=RubroEmpleadoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=RubroEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RubroEmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new RubroEmpleado();
					entity=super.getEntity("",entity,resultSet,RubroEmpleadoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityRubroEmpleado("",entity,resultSet);
					
					//entity.setRubroEmpleadoOriginal( new RubroEmpleado());
					//entity.setRubroEmpleadoOriginal(super.getEntity("",entity.getRubroEmpleadoOriginal(),resultSet,RubroEmpleadoDataAccess.ISWITHSCHEMA));         		
					//entity.setRubroEmpleadoOriginal(this.getEntityRubroEmpleado("",entity.getRubroEmpleadoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseRubroEmpleados(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRubroEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<RubroEmpleado>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<RubroEmpleado> entities = new  ArrayList<RubroEmpleado>();
		RubroEmpleado entity = new RubroEmpleado();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=RubroEmpleadoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=RubroEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RubroEmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<RubroEmpleado> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<RubroEmpleado> entities = new  ArrayList<RubroEmpleado>();
		RubroEmpleado entity = new RubroEmpleado();		  
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
	
	public  List<RubroEmpleado> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<RubroEmpleado> entities = new  ArrayList<RubroEmpleado>();
		RubroEmpleado entity = new RubroEmpleado();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new RubroEmpleado();
      	    	entity=super.getEntity("",entity,resultSet,RubroEmpleadoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityRubroEmpleado("",entity,resultSet);
      	    	
				//entity.setRubroEmpleadoOriginal( new RubroEmpleado());
      	    	//entity.setRubroEmpleadoOriginal(super.getEntity("",entity.getRubroEmpleadoOriginal(),resultSet,RubroEmpleadoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRubroEmpleadoOriginal(this.getEntityRubroEmpleado("",entity.getRubroEmpleadoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseRubroEmpleados(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRubroEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<RubroEmpleado> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<RubroEmpleado> entities = new  ArrayList<RubroEmpleado>();
		RubroEmpleado entity = new RubroEmpleado();		  
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
	
	public  List<RubroEmpleado> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<RubroEmpleado> entities = new  ArrayList<RubroEmpleado>();
		RubroEmpleado entity = new RubroEmpleado();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new RubroEmpleado();
      	    	entity=super.getEntity("",entity,resultSet,RubroEmpleadoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityRubroEmpleado("",entity,resultSet);
      	    	
				//entity.setRubroEmpleadoOriginal( new RubroEmpleado());
      	    	//entity.setRubroEmpleadoOriginal(super.getEntity("",entity.getRubroEmpleadoOriginal(),resultSet,RubroEmpleadoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRubroEmpleadoOriginal(this.getEntityRubroEmpleado("",entity.getRubroEmpleadoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseRubroEmpleados(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public RubroEmpleado getEntityRubroEmpleado(String strPrefijo,RubroEmpleado entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+RubroEmpleadoConstantesFunciones.IDEMPRESA));
				entity.setid_empleado(resultSet.getLong(strPrefijo+RubroEmpleadoConstantesFunciones.IDEMPLEADO));
				entity.setid_rubro_emplea(resultSet.getLong(strPrefijo+RubroEmpleadoConstantesFunciones.IDRUBROEMPLEA));
				entity.setid_estado_rubro(resultSet.getLong(strPrefijo+RubroEmpleadoConstantesFunciones.IDESTADORUBRO));
				entity.setvalor(resultSet.getDouble(strPrefijo+RubroEmpleadoConstantesFunciones.VALOR));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowRubroEmpleado(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(RubroEmpleado entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=RubroEmpleadoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=RubroEmpleadoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=RubroEmpleadoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=RubroEmpleadoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(RubroEmpleadoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,RubroEmpleadoDataAccess.TABLENAME,RubroEmpleadoDataAccess.ISWITHSTOREPROCEDURES);
			
			RubroEmpleadoDataAccess.setRubroEmpleadoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,RubroEmpleado relrubroempleado)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relrubroempleado.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Empleado getEmpleado(Connexion connexion,RubroEmpleado relrubroempleado)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relrubroempleado.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public RubroEmplea getRubroEmplea(Connexion connexion,RubroEmpleado relrubroempleado)throws SQLException,Exception {

		RubroEmplea rubroemplea= new RubroEmplea();

		try {
			RubroEmpleaDataAccess rubroempleaDataAccess=new RubroEmpleaDataAccess();

			rubroempleaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			rubroempleaDataAccess.setConnexionType(this.connexionType);
			rubroempleaDataAccess.setParameterDbType(this.parameterDbType);

			rubroemplea=rubroempleaDataAccess.getEntity(connexion,relrubroempleado.getid_rubro_emplea());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return rubroemplea;

	}

	public EstadoRubro getEstadoRubro(Connexion connexion,RubroEmpleado relrubroempleado)throws SQLException,Exception {

		EstadoRubro estadorubro= new EstadoRubro();

		try {
			EstadoRubroDataAccess estadorubroDataAccess=new EstadoRubroDataAccess();

			estadorubroDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadorubroDataAccess.setConnexionType(this.connexionType);
			estadorubroDataAccess.setParameterDbType(this.parameterDbType);

			estadorubro=estadorubroDataAccess.getEntity(connexion,relrubroempleado.getid_estado_rubro());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadorubro;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,RubroEmpleado rubroempleado) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!rubroempleado.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(rubroempleado.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(rubroempleado.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_rubro_emplea=new ParameterValue<Long>();
					parameterMaintenanceValueid_rubro_emplea.setValue(rubroempleado.getid_rubro_emplea());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_rubro_emplea);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_rubro=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_rubro.setValue(rubroempleado.getid_estado_rubro());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_rubro);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor=new ParameterValue<Double>();
					parameterMaintenanceValuevalor.setValue(rubroempleado.getvalor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor);
					parametersTemp.add(parameterMaintenance);
					
						if(!rubroempleado.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(rubroempleado.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(rubroempleado.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(rubroempleado.getId());
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
	
	public void setIsNewIsChangedFalseRubroEmpleado(RubroEmpleado rubroempleado)throws Exception  {		
		rubroempleado.setIsNew(false);
		rubroempleado.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseRubroEmpleados(List<RubroEmpleado> rubroempleados)throws Exception  {				
		for(RubroEmpleado rubroempleado:rubroempleados) {
			rubroempleado.setIsNew(false);
			rubroempleado.setIsChanged(false);
		}
	}
	
	public void generarExportarRubroEmpleado(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
