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
import com.bydan.erp.nomina.util.*;//TurnoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class TurnoDataAccess extends  TurnoDataAccessAdditional{ //TurnoDataAccessAdditional,DataAccessHelper<Turno>
	//static Logger logger = Logger.getLogger(TurnoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="turno";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TurnoConstantesFunciones.SCHEMA+"."+TurnoConstantesFunciones.TABLENAME+"(version_row,id_empresa,hora_entrada,hora_salida,hora_ingreso_receso,hora_salida_receso,hora_durante_receso,hora_ingreso_almuerzo,hora_salida_almuerzo,hora_durante_almuerzo,hora_ingreso25,hora_salida25,hora_ingreso50,hora_salida50,hora_ingreso100,hora_salida100,hora_ingreso200,hora_salida200)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+TurnoConstantesFunciones.SCHEMA+"."+TurnoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,hora_entrada=?,hora_salida=?,hora_ingreso_receso=?,hora_salida_receso=?,hora_durante_receso=?,hora_ingreso_almuerzo=?,hora_salida_almuerzo=?,hora_durante_almuerzo=?,hora_ingreso25=?,hora_salida25=?,hora_ingreso50=?,hora_salida50=?,hora_ingreso100=?,hora_salida100=?,hora_ingreso200=?,hora_salida200=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TurnoConstantesFunciones.SCHEMA+"."+TurnoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select turno from "+TurnoConstantesFunciones.SPERSISTENCENAME+" turno";
	public static String QUERYSELECTNATIVE="select "+TurnoConstantesFunciones.SCHEMA+"."+TurnoConstantesFunciones.TABLENAME+".id,"+TurnoConstantesFunciones.SCHEMA+"."+TurnoConstantesFunciones.TABLENAME+".version_row,"+TurnoConstantesFunciones.SCHEMA+"."+TurnoConstantesFunciones.TABLENAME+".id_empresa,"+TurnoConstantesFunciones.SCHEMA+"."+TurnoConstantesFunciones.TABLENAME+".hora_entrada,"+TurnoConstantesFunciones.SCHEMA+"."+TurnoConstantesFunciones.TABLENAME+".hora_salida,"+TurnoConstantesFunciones.SCHEMA+"."+TurnoConstantesFunciones.TABLENAME+".hora_ingreso_receso,"+TurnoConstantesFunciones.SCHEMA+"."+TurnoConstantesFunciones.TABLENAME+".hora_salida_receso,"+TurnoConstantesFunciones.SCHEMA+"."+TurnoConstantesFunciones.TABLENAME+".hora_durante_receso,"+TurnoConstantesFunciones.SCHEMA+"."+TurnoConstantesFunciones.TABLENAME+".hora_ingreso_almuerzo,"+TurnoConstantesFunciones.SCHEMA+"."+TurnoConstantesFunciones.TABLENAME+".hora_salida_almuerzo,"+TurnoConstantesFunciones.SCHEMA+"."+TurnoConstantesFunciones.TABLENAME+".hora_durante_almuerzo,"+TurnoConstantesFunciones.SCHEMA+"."+TurnoConstantesFunciones.TABLENAME+".hora_ingreso25,"+TurnoConstantesFunciones.SCHEMA+"."+TurnoConstantesFunciones.TABLENAME+".hora_salida25,"+TurnoConstantesFunciones.SCHEMA+"."+TurnoConstantesFunciones.TABLENAME+".hora_ingreso50,"+TurnoConstantesFunciones.SCHEMA+"."+TurnoConstantesFunciones.TABLENAME+".hora_salida50,"+TurnoConstantesFunciones.SCHEMA+"."+TurnoConstantesFunciones.TABLENAME+".hora_ingreso100,"+TurnoConstantesFunciones.SCHEMA+"."+TurnoConstantesFunciones.TABLENAME+".hora_salida100,"+TurnoConstantesFunciones.SCHEMA+"."+TurnoConstantesFunciones.TABLENAME+".hora_ingreso200,"+TurnoConstantesFunciones.SCHEMA+"."+TurnoConstantesFunciones.TABLENAME+".hora_salida200 from "+TurnoConstantesFunciones.SCHEMA+"."+TurnoConstantesFunciones.TABLENAME;//+" as "+TurnoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TurnoConstantesFunciones.SCHEMA+"."+TurnoConstantesFunciones.TABLENAME+".id,"+TurnoConstantesFunciones.SCHEMA+"."+TurnoConstantesFunciones.TABLENAME+".version_row from "+TurnoConstantesFunciones.SCHEMA+"."+TurnoConstantesFunciones.TABLENAME;//+" as "+TurnoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TurnoConstantesFunciones.SCHEMA+"."+TurnoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,hora_entrada=?,hora_salida=?,hora_ingreso_receso=?,hora_salida_receso=?,hora_durante_receso=?,hora_ingreso_almuerzo=?,hora_salida_almuerzo=?,hora_durante_almuerzo=?,hora_ingreso25=?,hora_salida25=?,hora_ingreso50=?,hora_salida50=?,hora_ingreso100=?,hora_salida100=?,hora_ingreso200=?,hora_salida200=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TURNO_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TURNO_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TURNO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TURNO_SELECT(?,?)";
	
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
	
	
	protected TurnoDataAccessAdditional turnoDataAccessAdditional=null;
	
	public TurnoDataAccessAdditional getTurnoDataAccessAdditional() {
		return this.turnoDataAccessAdditional;
	}
	
	public void setTurnoDataAccessAdditional(TurnoDataAccessAdditional turnoDataAccessAdditional) {
		try {
			this.turnoDataAccessAdditional=turnoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TurnoDataAccess() {
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
		TurnoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TurnoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TurnoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTurnoOriginal(Turno turno)throws Exception  {
		turno.setTurnoOriginal((Turno)turno.clone());		
	}
	
	public void setTurnosOriginal(List<Turno> turnos)throws Exception  {
		
		for(Turno turno:turnos){
			turno.setTurnoOriginal((Turno)turno.clone());
		}
	}
	
	public static void setTurnoOriginalStatic(Turno turno)throws Exception  {
		turno.setTurnoOriginal((Turno)turno.clone());		
	}
	
	public static void setTurnosOriginalStatic(List<Turno> turnos)throws Exception  {
		
		for(Turno turno:turnos){
			turno.setTurnoOriginal((Turno)turno.clone());
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
	
	public  Turno getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		Turno entity = new Turno();		
		
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
	
	public  Turno getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		Turno entity = new Turno();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TurnoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TurnoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.Turno.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTurnoOriginal(new Turno());
      	    	entity=super.getEntity("",entity,resultSet,TurnoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTurno("",entity,resultSet); 
				
				//entity.setTurnoOriginal(super.getEntity("",entity.getTurnoOriginal(),resultSet,TurnoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTurnoOriginal(this.getEntityTurno("",entity.getTurnoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTurno(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  Turno getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Turno entity = new Turno();
				
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
	
	public  Turno getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Turno entity = new Turno();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TurnoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TurnoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TurnoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.Turno.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTurnoOriginal(new Turno());
      	    	entity=super.getEntity("",entity,resultSet,TurnoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTurno("",entity,resultSet);    
				
				//entity.setTurnoOriginal(super.getEntity("",entity.getTurnoOriginal(),resultSet,TurnoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTurnoOriginal(this.getEntityTurno("",entity.getTurnoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTurno(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //Turno
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		Turno entity = new Turno();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TurnoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TurnoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TurnoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.Turno.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTurno(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<Turno> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Turno> entities = new  ArrayList<Turno>();
		Turno entity = new Turno();		  
		
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
	
	public  List<Turno> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Turno> entities = new  ArrayList<Turno>();
		Turno entity = new Turno();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TurnoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TurnoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TurnoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Turno();
      	    	entity=super.getEntity("",entity,resultSet,TurnoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTurno("",entity,resultSet);
      	    	
				//entity.setTurnoOriginal( new Turno());
      	    	//entity.setTurnoOriginal(super.getEntity("",entity.getTurnoOriginal(),resultSet,TurnoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTurnoOriginal(this.getEntityTurno("",entity.getTurnoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTurnos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTurno(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Turno> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Turno> entities = new  ArrayList<Turno>();
		Turno entity = new Turno();		  
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
	
	public  List<Turno> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Turno> entities = new  ArrayList<Turno>();
		Turno entity = new Turno();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Turno();
				
				if(conMapGenerico) {
					entity.inicializarMapTurno();
					//entity.setMapTurno(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTurnoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTurno().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TurnoDataAccess.ISWITHSCHEMA);         		
					entity=TurnoDataAccess.getEntityTurno("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTurnoOriginal( new Turno());
					////entity.setTurnoOriginal(super.getEntity("",entity.getTurnoOriginal(),resultSet,TurnoDataAccess.ISWITHSCHEMA));         		
					////entity.setTurnoOriginal(this.getEntityTurno("",entity.getTurnoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTurnos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTurno(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public Turno getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Turno entity = new Turno();		  
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
	
	public  Turno getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Turno entity = new Turno();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Turno();
				
				if(conMapGenerico) {
					entity.inicializarMapTurno();
					//entity.setMapTurno(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTurnoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTurno().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TurnoDataAccess.ISWITHSCHEMA);         		
					entity=TurnoDataAccess.getEntityTurno("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTurnoOriginal( new Turno());
					////entity.setTurnoOriginal(super.getEntity("",entity.getTurnoOriginal(),resultSet,TurnoDataAccess.ISWITHSCHEMA));         		
					////entity.setTurnoOriginal(this.getEntityTurno("",entity.getTurnoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTurno(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTurno(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static Turno getEntityTurno(String strPrefijo,Turno entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = Turno.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = Turno.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TurnoDataAccess.setFieldReflectionTurno(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTurno=TurnoConstantesFunciones.getTodosTiposColumnasTurno();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTurno) {
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
							field = Turno.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = Turno.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TurnoDataAccess.setFieldReflectionTurno(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTurno(Field field,String strPrefijo,String sColumn,Turno entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TurnoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TurnoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TurnoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TurnoConstantesFunciones.HORAENTRADA:
					field.set(entity,resultSet.getTime(sCampo));
					break;
				
				case TurnoConstantesFunciones.HORASALIDA:
					field.set(entity,resultSet.getTime(sCampo));
					break;
				
				case TurnoConstantesFunciones.HORAINGRESORECESO:
					field.set(entity,resultSet.getTime(sCampo));
					break;
				
				case TurnoConstantesFunciones.HORASALIDARECESO:
					field.set(entity,resultSet.getTime(sCampo));
					break;
				
				case TurnoConstantesFunciones.HORADURANTERECESO:
					field.set(entity,resultSet.getTime(sCampo));
					break;
				
				case TurnoConstantesFunciones.HORAINGRESOALMUERZO:
					field.set(entity,resultSet.getTime(sCampo));
					break;
				
				case TurnoConstantesFunciones.HORASALIDAALMUERZO:
					field.set(entity,resultSet.getTime(sCampo));
					break;
				
				case TurnoConstantesFunciones.HORADURANTEALMUERZO:
					field.set(entity,resultSet.getTime(sCampo));
					break;
				
				case TurnoConstantesFunciones.HORAINGRESO25:
					field.set(entity,resultSet.getTime(sCampo));
					break;
				
				case TurnoConstantesFunciones.HORASALIDA25:
					field.set(entity,resultSet.getTime(sCampo));
					break;
				
				case TurnoConstantesFunciones.HORAINGRESO50:
					field.set(entity,resultSet.getTime(sCampo));
					break;
				
				case TurnoConstantesFunciones.HORASALIDA50:
					field.set(entity,resultSet.getTime(sCampo));
					break;
				
				case TurnoConstantesFunciones.HORAINGRESO100:
					field.set(entity,resultSet.getTime(sCampo));
					break;
				
				case TurnoConstantesFunciones.HORASALIDA100:
					field.set(entity,resultSet.getTime(sCampo));
					break;
				
				case TurnoConstantesFunciones.HORAINGRESO200:
					field.set(entity,resultSet.getTime(sCampo));
					break;
				
				case TurnoConstantesFunciones.HORASALIDA200:
					field.set(entity,resultSet.getTime(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Turno>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<Turno> entities = new  ArrayList<Turno>();
		Turno entity = new Turno();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TurnoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TurnoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TurnoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new Turno();
					entity=super.getEntity("",entity,resultSet,TurnoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTurno("",entity,resultSet);
					
					//entity.setTurnoOriginal( new Turno());
					//entity.setTurnoOriginal(super.getEntity("",entity.getTurnoOriginal(),resultSet,TurnoDataAccess.ISWITHSCHEMA));         		
					//entity.setTurnoOriginal(this.getEntityTurno("",entity.getTurnoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTurnos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTurno(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Turno>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<Turno> entities = new  ArrayList<Turno>();
		Turno entity = new Turno();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TurnoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TurnoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TurnoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<Turno> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Turno> entities = new  ArrayList<Turno>();
		Turno entity = new Turno();		  
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
	
	public  List<Turno> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Turno> entities = new  ArrayList<Turno>();
		Turno entity = new Turno();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Turno();
      	    	entity=super.getEntity("",entity,resultSet,TurnoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTurno("",entity,resultSet);
      	    	
				//entity.setTurnoOriginal( new Turno());
      	    	//entity.setTurnoOriginal(super.getEntity("",entity.getTurnoOriginal(),resultSet,TurnoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTurnoOriginal(this.getEntityTurno("",entity.getTurnoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTurnos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTurno(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Turno> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Turno> entities = new  ArrayList<Turno>();
		Turno entity = new Turno();		  
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
	
	public  List<Turno> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Turno> entities = new  ArrayList<Turno>();
		Turno entity = new Turno();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Turno();
      	    	entity=super.getEntity("",entity,resultSet,TurnoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTurno("",entity,resultSet);
      	    	
				//entity.setTurnoOriginal( new Turno());
      	    	//entity.setTurnoOriginal(super.getEntity("",entity.getTurnoOriginal(),resultSet,TurnoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTurnoOriginal(this.getEntityTurno("",entity.getTurnoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTurnos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public Turno getEntityTurno(String strPrefijo,Turno entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+TurnoConstantesFunciones.IDEMPRESA));
				entity.sethora_entrada(resultSet.getTime(strPrefijo+TurnoConstantesFunciones.HORAENTRADA));
				entity.sethora_salida(resultSet.getTime(strPrefijo+TurnoConstantesFunciones.HORASALIDA));
				entity.sethora_ingreso_receso(resultSet.getTime(strPrefijo+TurnoConstantesFunciones.HORAINGRESORECESO));
				entity.sethora_salida_receso(resultSet.getTime(strPrefijo+TurnoConstantesFunciones.HORASALIDARECESO));
				entity.sethora_durante_receso(resultSet.getTime(strPrefijo+TurnoConstantesFunciones.HORADURANTERECESO));
				entity.sethora_ingreso_almuerzo(resultSet.getTime(strPrefijo+TurnoConstantesFunciones.HORAINGRESOALMUERZO));
				entity.sethora_salida_almuerzo(resultSet.getTime(strPrefijo+TurnoConstantesFunciones.HORASALIDAALMUERZO));
				entity.sethora_durante_almuerzo(resultSet.getTime(strPrefijo+TurnoConstantesFunciones.HORADURANTEALMUERZO));
				entity.sethora_ingreso25(resultSet.getTime(strPrefijo+TurnoConstantesFunciones.HORAINGRESO25));
				entity.sethora_salida25(resultSet.getTime(strPrefijo+TurnoConstantesFunciones.HORASALIDA25));
				entity.sethora_ingreso50(resultSet.getTime(strPrefijo+TurnoConstantesFunciones.HORAINGRESO50));
				entity.sethora_salida50(resultSet.getTime(strPrefijo+TurnoConstantesFunciones.HORASALIDA50));
				entity.sethora_ingreso100(resultSet.getTime(strPrefijo+TurnoConstantesFunciones.HORAINGRESO100));
				entity.sethora_salida100(resultSet.getTime(strPrefijo+TurnoConstantesFunciones.HORASALIDA100));
				entity.sethora_ingreso200(resultSet.getTime(strPrefijo+TurnoConstantesFunciones.HORAINGRESO200));
				entity.sethora_salida200(resultSet.getTime(strPrefijo+TurnoConstantesFunciones.HORASALIDA200));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTurno(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(Turno entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TurnoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TurnoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TurnoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TurnoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TurnoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,TurnoDataAccess.TABLENAME,TurnoDataAccess.ISWITHSTOREPROCEDURES);
			
			TurnoDataAccess.setTurnoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,Turno relturno)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relturno.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,Turno turno) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!turno.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(turno.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.TIME);
					ParameterValue<Time> parameterMaintenanceValuehora_entrada=new ParameterValue<Time>();
					parameterMaintenanceValuehora_entrada.setValue(turno.gethora_entrada());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuehora_entrada);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.TIME);
					ParameterValue<Time> parameterMaintenanceValuehora_salida=new ParameterValue<Time>();
					parameterMaintenanceValuehora_salida.setValue(turno.gethora_salida());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuehora_salida);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.TIME);
					ParameterValue<Time> parameterMaintenanceValuehora_ingreso_receso=new ParameterValue<Time>();
					parameterMaintenanceValuehora_ingreso_receso.setValue(turno.gethora_ingreso_receso());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuehora_ingreso_receso);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.TIME);
					ParameterValue<Time> parameterMaintenanceValuehora_salida_receso=new ParameterValue<Time>();
					parameterMaintenanceValuehora_salida_receso.setValue(turno.gethora_salida_receso());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuehora_salida_receso);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.TIME);
					ParameterValue<Time> parameterMaintenanceValuehora_durante_receso=new ParameterValue<Time>();
					parameterMaintenanceValuehora_durante_receso.setValue(turno.gethora_durante_receso());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuehora_durante_receso);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.TIME);
					ParameterValue<Time> parameterMaintenanceValuehora_ingreso_almuerzo=new ParameterValue<Time>();
					parameterMaintenanceValuehora_ingreso_almuerzo.setValue(turno.gethora_ingreso_almuerzo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuehora_ingreso_almuerzo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.TIME);
					ParameterValue<Time> parameterMaintenanceValuehora_salida_almuerzo=new ParameterValue<Time>();
					parameterMaintenanceValuehora_salida_almuerzo.setValue(turno.gethora_salida_almuerzo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuehora_salida_almuerzo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.TIME);
					ParameterValue<Time> parameterMaintenanceValuehora_durante_almuerzo=new ParameterValue<Time>();
					parameterMaintenanceValuehora_durante_almuerzo.setValue(turno.gethora_durante_almuerzo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuehora_durante_almuerzo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.TIME);
					ParameterValue<Time> parameterMaintenanceValuehora_ingreso25=new ParameterValue<Time>();
					parameterMaintenanceValuehora_ingreso25.setValue(turno.gethora_ingreso25());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuehora_ingreso25);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.TIME);
					ParameterValue<Time> parameterMaintenanceValuehora_salida25=new ParameterValue<Time>();
					parameterMaintenanceValuehora_salida25.setValue(turno.gethora_salida25());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuehora_salida25);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.TIME);
					ParameterValue<Time> parameterMaintenanceValuehora_ingreso50=new ParameterValue<Time>();
					parameterMaintenanceValuehora_ingreso50.setValue(turno.gethora_ingreso50());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuehora_ingreso50);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.TIME);
					ParameterValue<Time> parameterMaintenanceValuehora_salida50=new ParameterValue<Time>();
					parameterMaintenanceValuehora_salida50.setValue(turno.gethora_salida50());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuehora_salida50);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.TIME);
					ParameterValue<Time> parameterMaintenanceValuehora_ingreso100=new ParameterValue<Time>();
					parameterMaintenanceValuehora_ingreso100.setValue(turno.gethora_ingreso100());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuehora_ingreso100);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.TIME);
					ParameterValue<Time> parameterMaintenanceValuehora_salida100=new ParameterValue<Time>();
					parameterMaintenanceValuehora_salida100.setValue(turno.gethora_salida100());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuehora_salida100);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.TIME);
					ParameterValue<Time> parameterMaintenanceValuehora_ingreso200=new ParameterValue<Time>();
					parameterMaintenanceValuehora_ingreso200.setValue(turno.gethora_ingreso200());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuehora_ingreso200);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.TIME);
					ParameterValue<Time> parameterMaintenanceValuehora_salida200=new ParameterValue<Time>();
					parameterMaintenanceValuehora_salida200.setValue(turno.gethora_salida200());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuehora_salida200);
					parametersTemp.add(parameterMaintenance);
					
						if(!turno.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(turno.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(turno.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(turno.getId());
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
	
	public void setIsNewIsChangedFalseTurno(Turno turno)throws Exception  {		
		turno.setIsNew(false);
		turno.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTurnos(List<Turno> turnos)throws Exception  {				
		for(Turno turno:turnos) {
			turno.setIsNew(false);
			turno.setIsChanged(false);
		}
	}
	
	public void generarExportarTurno(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
