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
import com.bydan.erp.nomina.util.*;//PlaniVacacionConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class PlaniVacacionDataAccess extends  PlaniVacacionDataAccessAdditional{ //PlaniVacacionDataAccessAdditional,DataAccessHelper<PlaniVacacion>
	//static Logger logger = Logger.getLogger(PlaniVacacionDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="plani_vacacion";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+PlaniVacacionConstantesFunciones.SCHEMA+"."+PlaniVacacionConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_estructura,id_estructura_seccion,id_estructura_cargo,id_empleado,fecha_inicio,fecha_fin,id_mes,dias_anio,dias_realizadas,dias_pendiente,dias_tomados,dias_anticipadas,descripcion)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+PlaniVacacionConstantesFunciones.SCHEMA+"."+PlaniVacacionConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_estructura=?,id_estructura_seccion=?,id_estructura_cargo=?,id_empleado=?,fecha_inicio=?,fecha_fin=?,id_mes=?,dias_anio=?,dias_realizadas=?,dias_pendiente=?,dias_tomados=?,dias_anticipadas=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+PlaniVacacionConstantesFunciones.SCHEMA+"."+PlaniVacacionConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select planivacacion from "+PlaniVacacionConstantesFunciones.SPERSISTENCENAME+" planivacacion";
	public static String QUERYSELECTNATIVE="select "+PlaniVacacionConstantesFunciones.SCHEMA+"."+PlaniVacacionConstantesFunciones.TABLENAME+".id,"+PlaniVacacionConstantesFunciones.SCHEMA+"."+PlaniVacacionConstantesFunciones.TABLENAME+".version_row,"+PlaniVacacionConstantesFunciones.SCHEMA+"."+PlaniVacacionConstantesFunciones.TABLENAME+".id_empresa,"+PlaniVacacionConstantesFunciones.SCHEMA+"."+PlaniVacacionConstantesFunciones.TABLENAME+".id_sucursal,"+PlaniVacacionConstantesFunciones.SCHEMA+"."+PlaniVacacionConstantesFunciones.TABLENAME+".id_estructura,"+PlaniVacacionConstantesFunciones.SCHEMA+"."+PlaniVacacionConstantesFunciones.TABLENAME+".id_estructura_seccion,"+PlaniVacacionConstantesFunciones.SCHEMA+"."+PlaniVacacionConstantesFunciones.TABLENAME+".id_estructura_cargo,"+PlaniVacacionConstantesFunciones.SCHEMA+"."+PlaniVacacionConstantesFunciones.TABLENAME+".id_empleado,"+PlaniVacacionConstantesFunciones.SCHEMA+"."+PlaniVacacionConstantesFunciones.TABLENAME+".fecha_inicio,"+PlaniVacacionConstantesFunciones.SCHEMA+"."+PlaniVacacionConstantesFunciones.TABLENAME+".fecha_fin,"+PlaniVacacionConstantesFunciones.SCHEMA+"."+PlaniVacacionConstantesFunciones.TABLENAME+".id_mes,"+PlaniVacacionConstantesFunciones.SCHEMA+"."+PlaniVacacionConstantesFunciones.TABLENAME+".dias_anio,"+PlaniVacacionConstantesFunciones.SCHEMA+"."+PlaniVacacionConstantesFunciones.TABLENAME+".dias_realizadas,"+PlaniVacacionConstantesFunciones.SCHEMA+"."+PlaniVacacionConstantesFunciones.TABLENAME+".dias_pendiente,"+PlaniVacacionConstantesFunciones.SCHEMA+"."+PlaniVacacionConstantesFunciones.TABLENAME+".dias_tomados,"+PlaniVacacionConstantesFunciones.SCHEMA+"."+PlaniVacacionConstantesFunciones.TABLENAME+".dias_anticipadas,"+PlaniVacacionConstantesFunciones.SCHEMA+"."+PlaniVacacionConstantesFunciones.TABLENAME+".descripcion from "+PlaniVacacionConstantesFunciones.SCHEMA+"."+PlaniVacacionConstantesFunciones.TABLENAME;//+" as "+PlaniVacacionConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+PlaniVacacionConstantesFunciones.SCHEMA+"."+PlaniVacacionConstantesFunciones.TABLENAME+".id,"+PlaniVacacionConstantesFunciones.SCHEMA+"."+PlaniVacacionConstantesFunciones.TABLENAME+".version_row from "+PlaniVacacionConstantesFunciones.SCHEMA+"."+PlaniVacacionConstantesFunciones.TABLENAME;//+" as "+PlaniVacacionConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+PlaniVacacionConstantesFunciones.SCHEMA+"."+PlaniVacacionConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_estructura=?,id_estructura_seccion=?,id_estructura_cargo=?,id_empleado=?,fecha_inicio=?,fecha_fin=?,id_mes=?,dias_anio=?,dias_realizadas=?,dias_pendiente=?,dias_tomados=?,dias_anticipadas=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PLANIVACACION_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PLANIVACACION_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PLANIVACACION_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PLANIVACACION_SELECT(?,?)";
	
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
	
	
	protected PlaniVacacionDataAccessAdditional planivacacionDataAccessAdditional=null;
	
	public PlaniVacacionDataAccessAdditional getPlaniVacacionDataAccessAdditional() {
		return this.planivacacionDataAccessAdditional;
	}
	
	public void setPlaniVacacionDataAccessAdditional(PlaniVacacionDataAccessAdditional planivacacionDataAccessAdditional) {
		try {
			this.planivacacionDataAccessAdditional=planivacacionDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public PlaniVacacionDataAccess() {
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
		PlaniVacacionDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		PlaniVacacionDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		PlaniVacacionDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setPlaniVacacionOriginal(PlaniVacacion planivacacion)throws Exception  {
		planivacacion.setPlaniVacacionOriginal((PlaniVacacion)planivacacion.clone());		
	}
	
	public void setPlaniVacacionsOriginal(List<PlaniVacacion> planivacacions)throws Exception  {
		
		for(PlaniVacacion planivacacion:planivacacions){
			planivacacion.setPlaniVacacionOriginal((PlaniVacacion)planivacacion.clone());
		}
	}
	
	public static void setPlaniVacacionOriginalStatic(PlaniVacacion planivacacion)throws Exception  {
		planivacacion.setPlaniVacacionOriginal((PlaniVacacion)planivacacion.clone());		
	}
	
	public static void setPlaniVacacionsOriginalStatic(List<PlaniVacacion> planivacacions)throws Exception  {
		
		for(PlaniVacacion planivacacion:planivacacions){
			planivacacion.setPlaniVacacionOriginal((PlaniVacacion)planivacacion.clone());
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
	
	public  PlaniVacacion getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		PlaniVacacion entity = new PlaniVacacion();		
		
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
	
	public  PlaniVacacion getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		PlaniVacacion entity = new PlaniVacacion();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PlaniVacacionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PlaniVacacionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.PlaniVacacion.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setPlaniVacacionOriginal(new PlaniVacacion());
      	    	entity=super.getEntity("",entity,resultSet,PlaniVacacionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPlaniVacacion("",entity,resultSet); 
				
				//entity.setPlaniVacacionOriginal(super.getEntity("",entity.getPlaniVacacionOriginal(),resultSet,PlaniVacacionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPlaniVacacionOriginal(this.getEntityPlaniVacacion("",entity.getPlaniVacacionOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalsePlaniVacacion(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  PlaniVacacion getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		PlaniVacacion entity = new PlaniVacacion();
				
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
	
	public  PlaniVacacion getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		PlaniVacacion entity = new PlaniVacacion();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PlaniVacacionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PlaniVacacionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PlaniVacacionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.PlaniVacacion.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setPlaniVacacionOriginal(new PlaniVacacion());
      	    	entity=super.getEntity("",entity,resultSet,PlaniVacacionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPlaniVacacion("",entity,resultSet);    
				
				//entity.setPlaniVacacionOriginal(super.getEntity("",entity.getPlaniVacacionOriginal(),resultSet,PlaniVacacionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPlaniVacacionOriginal(this.getEntityPlaniVacacion("",entity.getPlaniVacacionOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalsePlaniVacacion(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //PlaniVacacion
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		PlaniVacacion entity = new PlaniVacacion();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PlaniVacacionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PlaniVacacionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PlaniVacacionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.PlaniVacacion.isActive=1
        	 
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
				//this.setIsNewIsChangedFalsePlaniVacacion(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<PlaniVacacion> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<PlaniVacacion> entities = new  ArrayList<PlaniVacacion>();
		PlaniVacacion entity = new PlaniVacacion();		  
		
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
	
	public  List<PlaniVacacion> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<PlaniVacacion> entities = new  ArrayList<PlaniVacacion>();
		PlaniVacacion entity = new PlaniVacacion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=PlaniVacacionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PlaniVacacionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PlaniVacacionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PlaniVacacion();
      	    	entity=super.getEntity("",entity,resultSet,PlaniVacacionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPlaniVacacion("",entity,resultSet);
      	    	
				//entity.setPlaniVacacionOriginal( new PlaniVacacion());
      	    	//entity.setPlaniVacacionOriginal(super.getEntity("",entity.getPlaniVacacionOriginal(),resultSet,PlaniVacacionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPlaniVacacionOriginal(this.getEntityPlaniVacacion("",entity.getPlaniVacacionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePlaniVacacions(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPlaniVacacion(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<PlaniVacacion> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<PlaniVacacion> entities = new  ArrayList<PlaniVacacion>();
		PlaniVacacion entity = new PlaniVacacion();		  
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
	
	public  List<PlaniVacacion> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<PlaniVacacion> entities = new  ArrayList<PlaniVacacion>();
		PlaniVacacion entity = new PlaniVacacion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PlaniVacacion();
				
				if(conMapGenerico) {
					entity.inicializarMapPlaniVacacion();
					//entity.setMapPlaniVacacion(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapPlaniVacacionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPlaniVacacion().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PlaniVacacionDataAccess.ISWITHSCHEMA);         		
					entity=PlaniVacacionDataAccess.getEntityPlaniVacacion("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setPlaniVacacionOriginal( new PlaniVacacion());
					////entity.setPlaniVacacionOriginal(super.getEntity("",entity.getPlaniVacacionOriginal(),resultSet,PlaniVacacionDataAccess.ISWITHSCHEMA));         		
					////entity.setPlaniVacacionOriginal(this.getEntityPlaniVacacion("",entity.getPlaniVacacionOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePlaniVacacions(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPlaniVacacion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public PlaniVacacion getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		PlaniVacacion entity = new PlaniVacacion();		  
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
	
	public  PlaniVacacion getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		PlaniVacacion entity = new PlaniVacacion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PlaniVacacion();
				
				if(conMapGenerico) {
					entity.inicializarMapPlaniVacacion();
					//entity.setMapPlaniVacacion(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapPlaniVacacionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPlaniVacacion().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PlaniVacacionDataAccess.ISWITHSCHEMA);         		
					entity=PlaniVacacionDataAccess.getEntityPlaniVacacion("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setPlaniVacacionOriginal( new PlaniVacacion());
					////entity.setPlaniVacacionOriginal(super.getEntity("",entity.getPlaniVacacionOriginal(),resultSet,PlaniVacacionDataAccess.ISWITHSCHEMA));         		
					////entity.setPlaniVacacionOriginal(this.getEntityPlaniVacacion("",entity.getPlaniVacacionOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalsePlaniVacacion(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPlaniVacacion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static PlaniVacacion getEntityPlaniVacacion(String strPrefijo,PlaniVacacion entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = PlaniVacacion.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = PlaniVacacion.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					PlaniVacacionDataAccess.setFieldReflectionPlaniVacacion(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasPlaniVacacion=PlaniVacacionConstantesFunciones.getTodosTiposColumnasPlaniVacacion();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasPlaniVacacion) {
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
							field = PlaniVacacion.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = PlaniVacacion.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						PlaniVacacionDataAccess.setFieldReflectionPlaniVacacion(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionPlaniVacacion(Field field,String strPrefijo,String sColumn,PlaniVacacion entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case PlaniVacacionConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PlaniVacacionConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PlaniVacacionConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PlaniVacacionConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PlaniVacacionConstantesFunciones.IDESTRUCTURA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PlaniVacacionConstantesFunciones.IDESTRUCTURASECCION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PlaniVacacionConstantesFunciones.IDESTRUCTURACARGO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PlaniVacacionConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PlaniVacacionConstantesFunciones.FECHAINICIO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case PlaniVacacionConstantesFunciones.FECHAFIN:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case PlaniVacacionConstantesFunciones.IDMES:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PlaniVacacionConstantesFunciones.DIASANIO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PlaniVacacionConstantesFunciones.DIASREALIZADAS:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PlaniVacacionConstantesFunciones.DIASPENDIENTE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PlaniVacacionConstantesFunciones.DIASTOMADOS:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PlaniVacacionConstantesFunciones.DIASANTICIPADAS:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PlaniVacacionConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<PlaniVacacion>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<PlaniVacacion> entities = new  ArrayList<PlaniVacacion>();
		PlaniVacacion entity = new PlaniVacacion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PlaniVacacionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PlaniVacacionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PlaniVacacionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new PlaniVacacion();
					entity=super.getEntity("",entity,resultSet,PlaniVacacionDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityPlaniVacacion("",entity,resultSet);
					
					//entity.setPlaniVacacionOriginal( new PlaniVacacion());
					//entity.setPlaniVacacionOriginal(super.getEntity("",entity.getPlaniVacacionOriginal(),resultSet,PlaniVacacionDataAccess.ISWITHSCHEMA));         		
					//entity.setPlaniVacacionOriginal(this.getEntityPlaniVacacion("",entity.getPlaniVacacionOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalsePlaniVacacions(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPlaniVacacion(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<PlaniVacacion>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<PlaniVacacion> entities = new  ArrayList<PlaniVacacion>();
		PlaniVacacion entity = new PlaniVacacion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PlaniVacacionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PlaniVacacionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PlaniVacacionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<PlaniVacacion> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PlaniVacacion> entities = new  ArrayList<PlaniVacacion>();
		PlaniVacacion entity = new PlaniVacacion();		  
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
	
	public  List<PlaniVacacion> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PlaniVacacion> entities = new  ArrayList<PlaniVacacion>();
		PlaniVacacion entity = new PlaniVacacion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PlaniVacacion();
      	    	entity=super.getEntity("",entity,resultSet,PlaniVacacionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPlaniVacacion("",entity,resultSet);
      	    	
				//entity.setPlaniVacacionOriginal( new PlaniVacacion());
      	    	//entity.setPlaniVacacionOriginal(super.getEntity("",entity.getPlaniVacacionOriginal(),resultSet,PlaniVacacionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPlaniVacacionOriginal(this.getEntityPlaniVacacion("",entity.getPlaniVacacionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalsePlaniVacacions(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPlaniVacacion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<PlaniVacacion> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PlaniVacacion> entities = new  ArrayList<PlaniVacacion>();
		PlaniVacacion entity = new PlaniVacacion();		  
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
	
	public  List<PlaniVacacion> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PlaniVacacion> entities = new  ArrayList<PlaniVacacion>();
		PlaniVacacion entity = new PlaniVacacion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PlaniVacacion();
      	    	entity=super.getEntity("",entity,resultSet,PlaniVacacionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPlaniVacacion("",entity,resultSet);
      	    	
				//entity.setPlaniVacacionOriginal( new PlaniVacacion());
      	    	//entity.setPlaniVacacionOriginal(super.getEntity("",entity.getPlaniVacacionOriginal(),resultSet,PlaniVacacionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPlaniVacacionOriginal(this.getEntityPlaniVacacion("",entity.getPlaniVacacionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePlaniVacacions(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public PlaniVacacion getEntityPlaniVacacion(String strPrefijo,PlaniVacacion entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+PlaniVacacionConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+PlaniVacacionConstantesFunciones.IDSUCURSAL));
				entity.setid_estructura(resultSet.getLong(strPrefijo+PlaniVacacionConstantesFunciones.IDESTRUCTURA));
				entity.setid_estructura_seccion(resultSet.getLong(strPrefijo+PlaniVacacionConstantesFunciones.IDESTRUCTURASECCION));
				entity.setid_estructura_cargo(resultSet.getLong(strPrefijo+PlaniVacacionConstantesFunciones.IDESTRUCTURACARGO));
				entity.setid_empleado(resultSet.getLong(strPrefijo+PlaniVacacionConstantesFunciones.IDEMPLEADO));
				entity.setfecha_inicio(new Date(resultSet.getDate(strPrefijo+PlaniVacacionConstantesFunciones.FECHAINICIO).getTime()));
				entity.setfecha_fin(new Date(resultSet.getDate(strPrefijo+PlaniVacacionConstantesFunciones.FECHAFIN).getTime()));
				entity.setid_mes(resultSet.getLong(strPrefijo+PlaniVacacionConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
				entity.setdias_anio(resultSet.getDouble(strPrefijo+PlaniVacacionConstantesFunciones.DIASANIO));
				entity.setdias_realizadas(resultSet.getDouble(strPrefijo+PlaniVacacionConstantesFunciones.DIASREALIZADAS));
				entity.setdias_pendiente(resultSet.getDouble(strPrefijo+PlaniVacacionConstantesFunciones.DIASPENDIENTE));
				entity.setdias_tomados(resultSet.getDouble(strPrefijo+PlaniVacacionConstantesFunciones.DIASTOMADOS));
				entity.setdias_anticipadas(resultSet.getDouble(strPrefijo+PlaniVacacionConstantesFunciones.DIASANTICIPADAS));
				entity.setdescripcion(resultSet.getString(strPrefijo+PlaniVacacionConstantesFunciones.DESCRIPCION));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowPlaniVacacion(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(PlaniVacacion entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=PlaniVacacionDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=PlaniVacacionDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=PlaniVacacionDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=PlaniVacacionDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(PlaniVacacionConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,PlaniVacacionDataAccess.TABLENAME,PlaniVacacionDataAccess.ISWITHSTOREPROCEDURES);
			
			PlaniVacacionDataAccess.setPlaniVacacionOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,PlaniVacacion relplanivacacion)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relplanivacacion.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,PlaniVacacion relplanivacacion)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relplanivacacion.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Estructura getEstructura(Connexion connexion,PlaniVacacion relplanivacacion)throws SQLException,Exception {

		Estructura estructura= new Estructura();

		try {
			EstructuraDataAccess estructuraDataAccess=new EstructuraDataAccess();

			estructuraDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estructuraDataAccess.setConnexionType(this.connexionType);
			estructuraDataAccess.setParameterDbType(this.parameterDbType);

			estructura=estructuraDataAccess.getEntity(connexion,relplanivacacion.getid_estructura());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estructura;

	}

	public Estructura getEstructuraSeccion(Connexion connexion,PlaniVacacion relplanivacacion)throws SQLException,Exception {

		Estructura estructura= new Estructura();

		try {
			EstructuraDataAccess estructuraDataAccess=new EstructuraDataAccess();

			estructuraDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estructuraDataAccess.setConnexionType(this.connexionType);
			estructuraDataAccess.setParameterDbType(this.parameterDbType);

			estructura=estructuraDataAccess.getEntity(connexion,relplanivacacion.getid_estructura_seccion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estructura;

	}

	public Estructura getEstructuraCargo(Connexion connexion,PlaniVacacion relplanivacacion)throws SQLException,Exception {

		Estructura estructura= new Estructura();

		try {
			EstructuraDataAccess estructuraDataAccess=new EstructuraDataAccess();

			estructuraDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estructuraDataAccess.setConnexionType(this.connexionType);
			estructuraDataAccess.setParameterDbType(this.parameterDbType);

			estructura=estructuraDataAccess.getEntity(connexion,relplanivacacion.getid_estructura_cargo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estructura;

	}

	public Empleado getEmpleado(Connexion connexion,PlaniVacacion relplanivacacion)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relplanivacacion.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public Mes getMes(Connexion connexion,PlaniVacacion relplanivacacion)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,relplanivacacion.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,PlaniVacacion planivacacion) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!planivacacion.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(planivacacion.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(planivacacion.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estructura=new ParameterValue<Long>();
					parameterMaintenanceValueid_estructura.setValue(planivacacion.getid_estructura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estructura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estructura_seccion=new ParameterValue<Long>();
					parameterMaintenanceValueid_estructura_seccion.setValue(planivacacion.getid_estructura_seccion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estructura_seccion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estructura_cargo=new ParameterValue<Long>();
					parameterMaintenanceValueid_estructura_cargo.setValue(planivacacion.getid_estructura_cargo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estructura_cargo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(planivacacion.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_inicio=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_inicio.setValue(planivacacion.getfecha_inicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_inicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_fin=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_fin.setValue(planivacacion.getfecha_fin());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_fin);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes.setValue(planivacacion.getid_mes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedias_anio=new ParameterValue<Double>();
					parameterMaintenanceValuedias_anio.setValue(planivacacion.getdias_anio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedias_anio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedias_realizadas=new ParameterValue<Double>();
					parameterMaintenanceValuedias_realizadas.setValue(planivacacion.getdias_realizadas());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedias_realizadas);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedias_pendiente=new ParameterValue<Double>();
					parameterMaintenanceValuedias_pendiente.setValue(planivacacion.getdias_pendiente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedias_pendiente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedias_tomados=new ParameterValue<Double>();
					parameterMaintenanceValuedias_tomados.setValue(planivacacion.getdias_tomados());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedias_tomados);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedias_anticipadas=new ParameterValue<Double>();
					parameterMaintenanceValuedias_anticipadas.setValue(planivacacion.getdias_anticipadas());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedias_anticipadas);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(planivacacion.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!planivacacion.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(planivacacion.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(planivacacion.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(planivacacion.getId());
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
	
	public void setIsNewIsChangedFalsePlaniVacacion(PlaniVacacion planivacacion)throws Exception  {		
		planivacacion.setIsNew(false);
		planivacacion.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalsePlaniVacacions(List<PlaniVacacion> planivacacions)throws Exception  {				
		for(PlaniVacacion planivacacion:planivacacions) {
			planivacacion.setIsNew(false);
			planivacacion.setIsChanged(false);
		}
	}
	
	public void generarExportarPlaniVacacion(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
