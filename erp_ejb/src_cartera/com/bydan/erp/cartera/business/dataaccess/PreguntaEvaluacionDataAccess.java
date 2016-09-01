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
import com.bydan.erp.cartera.util.*;//PreguntaEvaluacionConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class PreguntaEvaluacionDataAccess extends  PreguntaEvaluacionDataAccessAdditional{ //PreguntaEvaluacionDataAccessAdditional,DataAccessHelper<PreguntaEvaluacion>
	//static Logger logger = Logger.getLogger(PreguntaEvaluacionDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="pregunta_evaluacion";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+PreguntaEvaluacionConstantesFunciones.SCHEMA+"."+PreguntaEvaluacionConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_ejercicio,id_periodo,pregunta,calificacion,orden,id_anio,id_mes)values(current_timestamp,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+PreguntaEvaluacionConstantesFunciones.SCHEMA+"."+PreguntaEvaluacionConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,pregunta=?,calificacion=?,orden=?,id_anio=?,id_mes=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+PreguntaEvaluacionConstantesFunciones.SCHEMA+"."+PreguntaEvaluacionConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select preguntaevaluacion from "+PreguntaEvaluacionConstantesFunciones.SPERSISTENCENAME+" preguntaevaluacion";
	public static String QUERYSELECTNATIVE="select "+PreguntaEvaluacionConstantesFunciones.SCHEMA+"."+PreguntaEvaluacionConstantesFunciones.TABLENAME+".id,"+PreguntaEvaluacionConstantesFunciones.SCHEMA+"."+PreguntaEvaluacionConstantesFunciones.TABLENAME+".version_row,"+PreguntaEvaluacionConstantesFunciones.SCHEMA+"."+PreguntaEvaluacionConstantesFunciones.TABLENAME+".id_empresa,"+PreguntaEvaluacionConstantesFunciones.SCHEMA+"."+PreguntaEvaluacionConstantesFunciones.TABLENAME+".id_sucursal,"+PreguntaEvaluacionConstantesFunciones.SCHEMA+"."+PreguntaEvaluacionConstantesFunciones.TABLENAME+".id_ejercicio,"+PreguntaEvaluacionConstantesFunciones.SCHEMA+"."+PreguntaEvaluacionConstantesFunciones.TABLENAME+".id_periodo,"+PreguntaEvaluacionConstantesFunciones.SCHEMA+"."+PreguntaEvaluacionConstantesFunciones.TABLENAME+".pregunta,"+PreguntaEvaluacionConstantesFunciones.SCHEMA+"."+PreguntaEvaluacionConstantesFunciones.TABLENAME+".calificacion,"+PreguntaEvaluacionConstantesFunciones.SCHEMA+"."+PreguntaEvaluacionConstantesFunciones.TABLENAME+".orden,"+PreguntaEvaluacionConstantesFunciones.SCHEMA+"."+PreguntaEvaluacionConstantesFunciones.TABLENAME+".id_anio,"+PreguntaEvaluacionConstantesFunciones.SCHEMA+"."+PreguntaEvaluacionConstantesFunciones.TABLENAME+".id_mes from "+PreguntaEvaluacionConstantesFunciones.SCHEMA+"."+PreguntaEvaluacionConstantesFunciones.TABLENAME;//+" as "+PreguntaEvaluacionConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+PreguntaEvaluacionConstantesFunciones.SCHEMA+"."+PreguntaEvaluacionConstantesFunciones.TABLENAME+".id,"+PreguntaEvaluacionConstantesFunciones.SCHEMA+"."+PreguntaEvaluacionConstantesFunciones.TABLENAME+".version_row from "+PreguntaEvaluacionConstantesFunciones.SCHEMA+"."+PreguntaEvaluacionConstantesFunciones.TABLENAME;//+" as "+PreguntaEvaluacionConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+PreguntaEvaluacionConstantesFunciones.SCHEMA+"."+PreguntaEvaluacionConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,pregunta=?,calificacion=?,orden=?,id_anio=?,id_mes=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PREGUNTAEVALUACION_INSERT(?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PREGUNTAEVALUACION_UPDATE(?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PREGUNTAEVALUACION_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PREGUNTAEVALUACION_SELECT(?,?)";
	
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
	
	
	protected PreguntaEvaluacionDataAccessAdditional preguntaevaluacionDataAccessAdditional=null;
	
	public PreguntaEvaluacionDataAccessAdditional getPreguntaEvaluacionDataAccessAdditional() {
		return this.preguntaevaluacionDataAccessAdditional;
	}
	
	public void setPreguntaEvaluacionDataAccessAdditional(PreguntaEvaluacionDataAccessAdditional preguntaevaluacionDataAccessAdditional) {
		try {
			this.preguntaevaluacionDataAccessAdditional=preguntaevaluacionDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public PreguntaEvaluacionDataAccess() {
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
		PreguntaEvaluacionDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		PreguntaEvaluacionDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		PreguntaEvaluacionDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setPreguntaEvaluacionOriginal(PreguntaEvaluacion preguntaevaluacion)throws Exception  {
		preguntaevaluacion.setPreguntaEvaluacionOriginal((PreguntaEvaluacion)preguntaevaluacion.clone());		
	}
	
	public void setPreguntaEvaluacionsOriginal(List<PreguntaEvaluacion> preguntaevaluacions)throws Exception  {
		
		for(PreguntaEvaluacion preguntaevaluacion:preguntaevaluacions){
			preguntaevaluacion.setPreguntaEvaluacionOriginal((PreguntaEvaluacion)preguntaevaluacion.clone());
		}
	}
	
	public static void setPreguntaEvaluacionOriginalStatic(PreguntaEvaluacion preguntaevaluacion)throws Exception  {
		preguntaevaluacion.setPreguntaEvaluacionOriginal((PreguntaEvaluacion)preguntaevaluacion.clone());		
	}
	
	public static void setPreguntaEvaluacionsOriginalStatic(List<PreguntaEvaluacion> preguntaevaluacions)throws Exception  {
		
		for(PreguntaEvaluacion preguntaevaluacion:preguntaevaluacions){
			preguntaevaluacion.setPreguntaEvaluacionOriginal((PreguntaEvaluacion)preguntaevaluacion.clone());
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
	
	public  PreguntaEvaluacion getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		PreguntaEvaluacion entity = new PreguntaEvaluacion();		
		
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
	
	public  PreguntaEvaluacion getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		PreguntaEvaluacion entity = new PreguntaEvaluacion();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PreguntaEvaluacionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PreguntaEvaluacionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Cartera.PreguntaEvaluacion.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setPreguntaEvaluacionOriginal(new PreguntaEvaluacion());
      	    	entity=super.getEntity("",entity,resultSet,PreguntaEvaluacionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPreguntaEvaluacion("",entity,resultSet); 
				
				//entity.setPreguntaEvaluacionOriginal(super.getEntity("",entity.getPreguntaEvaluacionOriginal(),resultSet,PreguntaEvaluacionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPreguntaEvaluacionOriginal(this.getEntityPreguntaEvaluacion("",entity.getPreguntaEvaluacionOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalsePreguntaEvaluacion(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  PreguntaEvaluacion getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		PreguntaEvaluacion entity = new PreguntaEvaluacion();
				
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
	
	public  PreguntaEvaluacion getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		PreguntaEvaluacion entity = new PreguntaEvaluacion();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PreguntaEvaluacionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PreguntaEvaluacionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PreguntaEvaluacionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.PreguntaEvaluacion.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setPreguntaEvaluacionOriginal(new PreguntaEvaluacion());
      	    	entity=super.getEntity("",entity,resultSet,PreguntaEvaluacionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPreguntaEvaluacion("",entity,resultSet);    
				
				//entity.setPreguntaEvaluacionOriginal(super.getEntity("",entity.getPreguntaEvaluacionOriginal(),resultSet,PreguntaEvaluacionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPreguntaEvaluacionOriginal(this.getEntityPreguntaEvaluacion("",entity.getPreguntaEvaluacionOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalsePreguntaEvaluacion(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //PreguntaEvaluacion
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		PreguntaEvaluacion entity = new PreguntaEvaluacion();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PreguntaEvaluacionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PreguntaEvaluacionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PreguntaEvaluacionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.PreguntaEvaluacion.isActive=1
        	 
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
				//this.setIsNewIsChangedFalsePreguntaEvaluacion(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<PreguntaEvaluacion> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<PreguntaEvaluacion> entities = new  ArrayList<PreguntaEvaluacion>();
		PreguntaEvaluacion entity = new PreguntaEvaluacion();		  
		
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
	
	public  List<PreguntaEvaluacion> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<PreguntaEvaluacion> entities = new  ArrayList<PreguntaEvaluacion>();
		PreguntaEvaluacion entity = new PreguntaEvaluacion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=PreguntaEvaluacionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PreguntaEvaluacionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PreguntaEvaluacionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PreguntaEvaluacion();
      	    	entity=super.getEntity("",entity,resultSet,PreguntaEvaluacionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPreguntaEvaluacion("",entity,resultSet);
      	    	
				//entity.setPreguntaEvaluacionOriginal( new PreguntaEvaluacion());
      	    	//entity.setPreguntaEvaluacionOriginal(super.getEntity("",entity.getPreguntaEvaluacionOriginal(),resultSet,PreguntaEvaluacionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPreguntaEvaluacionOriginal(this.getEntityPreguntaEvaluacion("",entity.getPreguntaEvaluacionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePreguntaEvaluacions(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPreguntaEvaluacion(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<PreguntaEvaluacion> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<PreguntaEvaluacion> entities = new  ArrayList<PreguntaEvaluacion>();
		PreguntaEvaluacion entity = new PreguntaEvaluacion();		  
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
	
	public  List<PreguntaEvaluacion> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<PreguntaEvaluacion> entities = new  ArrayList<PreguntaEvaluacion>();
		PreguntaEvaluacion entity = new PreguntaEvaluacion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PreguntaEvaluacion();
				
				if(conMapGenerico) {
					entity.inicializarMapPreguntaEvaluacion();
					//entity.setMapPreguntaEvaluacion(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapPreguntaEvaluacionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPreguntaEvaluacion().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PreguntaEvaluacionDataAccess.ISWITHSCHEMA);         		
					entity=PreguntaEvaluacionDataAccess.getEntityPreguntaEvaluacion("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setPreguntaEvaluacionOriginal( new PreguntaEvaluacion());
					////entity.setPreguntaEvaluacionOriginal(super.getEntity("",entity.getPreguntaEvaluacionOriginal(),resultSet,PreguntaEvaluacionDataAccess.ISWITHSCHEMA));         		
					////entity.setPreguntaEvaluacionOriginal(this.getEntityPreguntaEvaluacion("",entity.getPreguntaEvaluacionOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePreguntaEvaluacions(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPreguntaEvaluacion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public PreguntaEvaluacion getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		PreguntaEvaluacion entity = new PreguntaEvaluacion();		  
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
	
	public  PreguntaEvaluacion getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		PreguntaEvaluacion entity = new PreguntaEvaluacion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PreguntaEvaluacion();
				
				if(conMapGenerico) {
					entity.inicializarMapPreguntaEvaluacion();
					//entity.setMapPreguntaEvaluacion(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapPreguntaEvaluacionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPreguntaEvaluacion().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PreguntaEvaluacionDataAccess.ISWITHSCHEMA);         		
					entity=PreguntaEvaluacionDataAccess.getEntityPreguntaEvaluacion("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setPreguntaEvaluacionOriginal( new PreguntaEvaluacion());
					////entity.setPreguntaEvaluacionOriginal(super.getEntity("",entity.getPreguntaEvaluacionOriginal(),resultSet,PreguntaEvaluacionDataAccess.ISWITHSCHEMA));         		
					////entity.setPreguntaEvaluacionOriginal(this.getEntityPreguntaEvaluacion("",entity.getPreguntaEvaluacionOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalsePreguntaEvaluacion(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPreguntaEvaluacion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static PreguntaEvaluacion getEntityPreguntaEvaluacion(String strPrefijo,PreguntaEvaluacion entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = PreguntaEvaluacion.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = PreguntaEvaluacion.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					PreguntaEvaluacionDataAccess.setFieldReflectionPreguntaEvaluacion(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasPreguntaEvaluacion=PreguntaEvaluacionConstantesFunciones.getTodosTiposColumnasPreguntaEvaluacion();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasPreguntaEvaluacion) {
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
							field = PreguntaEvaluacion.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = PreguntaEvaluacion.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						PreguntaEvaluacionDataAccess.setFieldReflectionPreguntaEvaluacion(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionPreguntaEvaluacion(Field field,String strPrefijo,String sColumn,PreguntaEvaluacion entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case PreguntaEvaluacionConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PreguntaEvaluacionConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PreguntaEvaluacionConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PreguntaEvaluacionConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PreguntaEvaluacionConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PreguntaEvaluacionConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PreguntaEvaluacionConstantesFunciones.PREGUNTA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PreguntaEvaluacionConstantesFunciones.CALIFICACION:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PreguntaEvaluacionConstantesFunciones.ORDEN:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case PreguntaEvaluacionConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PreguntaEvaluacionConstantesFunciones.IDMES:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<PreguntaEvaluacion>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<PreguntaEvaluacion> entities = new  ArrayList<PreguntaEvaluacion>();
		PreguntaEvaluacion entity = new PreguntaEvaluacion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PreguntaEvaluacionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PreguntaEvaluacionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PreguntaEvaluacionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new PreguntaEvaluacion();
					entity=super.getEntity("",entity,resultSet,PreguntaEvaluacionDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityPreguntaEvaluacion("",entity,resultSet);
					
					//entity.setPreguntaEvaluacionOriginal( new PreguntaEvaluacion());
					//entity.setPreguntaEvaluacionOriginal(super.getEntity("",entity.getPreguntaEvaluacionOriginal(),resultSet,PreguntaEvaluacionDataAccess.ISWITHSCHEMA));         		
					//entity.setPreguntaEvaluacionOriginal(this.getEntityPreguntaEvaluacion("",entity.getPreguntaEvaluacionOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalsePreguntaEvaluacions(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPreguntaEvaluacion(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<PreguntaEvaluacion>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<PreguntaEvaluacion> entities = new  ArrayList<PreguntaEvaluacion>();
		PreguntaEvaluacion entity = new PreguntaEvaluacion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PreguntaEvaluacionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PreguntaEvaluacionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PreguntaEvaluacionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<PreguntaEvaluacion> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PreguntaEvaluacion> entities = new  ArrayList<PreguntaEvaluacion>();
		PreguntaEvaluacion entity = new PreguntaEvaluacion();		  
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
	
	public  List<PreguntaEvaluacion> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PreguntaEvaluacion> entities = new  ArrayList<PreguntaEvaluacion>();
		PreguntaEvaluacion entity = new PreguntaEvaluacion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PreguntaEvaluacion();
      	    	entity=super.getEntity("",entity,resultSet,PreguntaEvaluacionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPreguntaEvaluacion("",entity,resultSet);
      	    	
				//entity.setPreguntaEvaluacionOriginal( new PreguntaEvaluacion());
      	    	//entity.setPreguntaEvaluacionOriginal(super.getEntity("",entity.getPreguntaEvaluacionOriginal(),resultSet,PreguntaEvaluacionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPreguntaEvaluacionOriginal(this.getEntityPreguntaEvaluacion("",entity.getPreguntaEvaluacionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalsePreguntaEvaluacions(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPreguntaEvaluacion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<PreguntaEvaluacion> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PreguntaEvaluacion> entities = new  ArrayList<PreguntaEvaluacion>();
		PreguntaEvaluacion entity = new PreguntaEvaluacion();		  
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
	
	public  List<PreguntaEvaluacion> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PreguntaEvaluacion> entities = new  ArrayList<PreguntaEvaluacion>();
		PreguntaEvaluacion entity = new PreguntaEvaluacion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PreguntaEvaluacion();
      	    	entity=super.getEntity("",entity,resultSet,PreguntaEvaluacionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPreguntaEvaluacion("",entity,resultSet);
      	    	
				//entity.setPreguntaEvaluacionOriginal( new PreguntaEvaluacion());
      	    	//entity.setPreguntaEvaluacionOriginal(super.getEntity("",entity.getPreguntaEvaluacionOriginal(),resultSet,PreguntaEvaluacionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPreguntaEvaluacionOriginal(this.getEntityPreguntaEvaluacion("",entity.getPreguntaEvaluacionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePreguntaEvaluacions(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public PreguntaEvaluacion getEntityPreguntaEvaluacion(String strPrefijo,PreguntaEvaluacion entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+PreguntaEvaluacionConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+PreguntaEvaluacionConstantesFunciones.IDSUCURSAL));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+PreguntaEvaluacionConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+PreguntaEvaluacionConstantesFunciones.IDPERIODO));
				entity.setpregunta(resultSet.getString(strPrefijo+PreguntaEvaluacionConstantesFunciones.PREGUNTA));
				entity.setcalificacion(resultSet.getDouble(strPrefijo+PreguntaEvaluacionConstantesFunciones.CALIFICACION));
				entity.setorden(resultSet.getInt(strPrefijo+PreguntaEvaluacionConstantesFunciones.ORDEN));
				entity.setid_anio(resultSet.getLong(strPrefijo+PreguntaEvaluacionConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
				entity.setid_mes(resultSet.getLong(strPrefijo+PreguntaEvaluacionConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowPreguntaEvaluacion(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(PreguntaEvaluacion entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=PreguntaEvaluacionDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=PreguntaEvaluacionDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=PreguntaEvaluacionDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=PreguntaEvaluacionDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(PreguntaEvaluacionConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,PreguntaEvaluacionDataAccess.TABLENAME,PreguntaEvaluacionDataAccess.ISWITHSTOREPROCEDURES);
			
			PreguntaEvaluacionDataAccess.setPreguntaEvaluacionOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,PreguntaEvaluacion relpreguntaevaluacion)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relpreguntaevaluacion.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,PreguntaEvaluacion relpreguntaevaluacion)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relpreguntaevaluacion.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,PreguntaEvaluacion relpreguntaevaluacion)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relpreguntaevaluacion.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,PreguntaEvaluacion relpreguntaevaluacion)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,relpreguntaevaluacion.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public Anio getAnio(Connexion connexion,PreguntaEvaluacion relpreguntaevaluacion)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);

			anio=anioDataAccess.getEntity(connexion,relpreguntaevaluacion.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Mes getMes(Connexion connexion,PreguntaEvaluacion relpreguntaevaluacion)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,relpreguntaevaluacion.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}


		
		public List<DetalleEvaluacionProveedor> getDetalleEvaluacionProveedors(Connexion connexion,PreguntaEvaluacion preguntaevaluacion)throws SQLException,Exception {

		List<DetalleEvaluacionProveedor> detalleevaluacionproveedors= new ArrayList<DetalleEvaluacionProveedor>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+PreguntaEvaluacionConstantesFunciones.SCHEMA+".pregunta_evaluacion ON "+DetalleEvaluacionProveedorConstantesFunciones.SCHEMA+".detalle_evaluacion_proveedor.id_pregunta_evaluacion="+PreguntaEvaluacionConstantesFunciones.SCHEMA+".pregunta_evaluacion.id WHERE "+PreguntaEvaluacionConstantesFunciones.SCHEMA+".pregunta_evaluacion.id="+String.valueOf(preguntaevaluacion.getId());
			} else {
				sQuery=" INNER JOIN detalleevaluacionproveedor.PreguntaEvaluacion WHERE detalleevaluacionproveedor.PreguntaEvaluacion.id="+String.valueOf(preguntaevaluacion.getId());

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

	public List<SubPreguntaEvaluacion> getSubPreguntaEvaluacions(Connexion connexion,PreguntaEvaluacion preguntaevaluacion)throws SQLException,Exception {

		List<SubPreguntaEvaluacion> subpreguntaevaluacions= new ArrayList<SubPreguntaEvaluacion>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+PreguntaEvaluacionConstantesFunciones.SCHEMA+".pregunta_evaluacion ON "+SubPreguntaEvaluacionConstantesFunciones.SCHEMA+".sub_pregunta_evaluacion.id_pregunta_evaluacion="+PreguntaEvaluacionConstantesFunciones.SCHEMA+".pregunta_evaluacion.id WHERE "+PreguntaEvaluacionConstantesFunciones.SCHEMA+".pregunta_evaluacion.id="+String.valueOf(preguntaevaluacion.getId());
			} else {
				sQuery=" INNER JOIN subpreguntaevaluacion.PreguntaEvaluacion WHERE subpreguntaevaluacion.PreguntaEvaluacion.id="+String.valueOf(preguntaevaluacion.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			SubPreguntaEvaluacionDataAccess subpreguntaevaluacionDataAccess=new SubPreguntaEvaluacionDataAccess();

			subpreguntaevaluacionDataAccess.setConnexionType(this.connexionType);
			subpreguntaevaluacionDataAccess.setParameterDbType(this.parameterDbType);
			subpreguntaevaluacions=subpreguntaevaluacionDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return subpreguntaevaluacions;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,PreguntaEvaluacion preguntaevaluacion) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!preguntaevaluacion.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(preguntaevaluacion.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(preguntaevaluacion.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(preguntaevaluacion.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(preguntaevaluacion.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuepregunta=new ParameterValue<String>();
					parameterMaintenanceValuepregunta.setValue(preguntaevaluacion.getpregunta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuepregunta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecalificacion=new ParameterValue<Double>();
					parameterMaintenanceValuecalificacion.setValue(preguntaevaluacion.getcalificacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecalificacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValueorden=new ParameterValue<Integer>();
					parameterMaintenanceValueorden.setValue(preguntaevaluacion.getorden());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueorden);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_anio=new ParameterValue<Long>();
					parameterMaintenanceValueid_anio.setValue(preguntaevaluacion.getid_anio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_anio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes.setValue(preguntaevaluacion.getid_mes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes);
					parametersTemp.add(parameterMaintenance);
					
						if(!preguntaevaluacion.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(preguntaevaluacion.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(preguntaevaluacion.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(preguntaevaluacion.getId());
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
	
	public void setIsNewIsChangedFalsePreguntaEvaluacion(PreguntaEvaluacion preguntaevaluacion)throws Exception  {		
		preguntaevaluacion.setIsNew(false);
		preguntaevaluacion.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalsePreguntaEvaluacions(List<PreguntaEvaluacion> preguntaevaluacions)throws Exception  {				
		for(PreguntaEvaluacion preguntaevaluacion:preguntaevaluacions) {
			preguntaevaluacion.setIsNew(false);
			preguntaevaluacion.setIsChanged(false);
		}
	}
	
	public void generarExportarPreguntaEvaluacion(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
