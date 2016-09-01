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
import com.bydan.erp.nomina.util.*;//CursoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class CursoDataAccess extends  CursoDataAccessAdditional{ //CursoDataAccessAdditional,DataAccessHelper<Curso>
	//static Logger logger = Logger.getLogger(CursoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="curso";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+CursoConstantesFunciones.SCHEMA+"."+CursoConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_empleado,id_tipo_curso,id_tipo_institucion,nombre,codigo_inscripcion,fecha_inicio,fecha_fin,numero_horas,es_aprobado,es_auspicio_empresa,descripcion)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+CursoConstantesFunciones.SCHEMA+"."+CursoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_empleado=?,id_tipo_curso=?,id_tipo_institucion=?,nombre=?,codigo_inscripcion=?,fecha_inicio=?,fecha_fin=?,numero_horas=?,es_aprobado=?,es_auspicio_empresa=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+CursoConstantesFunciones.SCHEMA+"."+CursoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select curso from "+CursoConstantesFunciones.SPERSISTENCENAME+" curso";
	public static String QUERYSELECTNATIVE="select "+CursoConstantesFunciones.SCHEMA+"."+CursoConstantesFunciones.TABLENAME+".id,"+CursoConstantesFunciones.SCHEMA+"."+CursoConstantesFunciones.TABLENAME+".version_row,"+CursoConstantesFunciones.SCHEMA+"."+CursoConstantesFunciones.TABLENAME+".id_empresa,"+CursoConstantesFunciones.SCHEMA+"."+CursoConstantesFunciones.TABLENAME+".id_empleado,"+CursoConstantesFunciones.SCHEMA+"."+CursoConstantesFunciones.TABLENAME+".id_tipo_curso,"+CursoConstantesFunciones.SCHEMA+"."+CursoConstantesFunciones.TABLENAME+".id_tipo_institucion,"+CursoConstantesFunciones.SCHEMA+"."+CursoConstantesFunciones.TABLENAME+".nombre,"+CursoConstantesFunciones.SCHEMA+"."+CursoConstantesFunciones.TABLENAME+".codigo_inscripcion,"+CursoConstantesFunciones.SCHEMA+"."+CursoConstantesFunciones.TABLENAME+".fecha_inicio,"+CursoConstantesFunciones.SCHEMA+"."+CursoConstantesFunciones.TABLENAME+".fecha_fin,"+CursoConstantesFunciones.SCHEMA+"."+CursoConstantesFunciones.TABLENAME+".numero_horas,"+CursoConstantesFunciones.SCHEMA+"."+CursoConstantesFunciones.TABLENAME+".es_aprobado,"+CursoConstantesFunciones.SCHEMA+"."+CursoConstantesFunciones.TABLENAME+".es_auspicio_empresa,"+CursoConstantesFunciones.SCHEMA+"."+CursoConstantesFunciones.TABLENAME+".descripcion from "+CursoConstantesFunciones.SCHEMA+"."+CursoConstantesFunciones.TABLENAME;//+" as "+CursoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+CursoConstantesFunciones.SCHEMA+"."+CursoConstantesFunciones.TABLENAME+".id,"+CursoConstantesFunciones.SCHEMA+"."+CursoConstantesFunciones.TABLENAME+".version_row,"+CursoConstantesFunciones.SCHEMA+"."+CursoConstantesFunciones.TABLENAME+".nombre from "+CursoConstantesFunciones.SCHEMA+"."+CursoConstantesFunciones.TABLENAME;//+" as "+CursoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+CursoConstantesFunciones.SCHEMA+"."+CursoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_empleado=?,id_tipo_curso=?,id_tipo_institucion=?,nombre=?,codigo_inscripcion=?,fecha_inicio=?,fecha_fin=?,numero_horas=?,es_aprobado=?,es_auspicio_empresa=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_CURSO_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_CURSO_UPDATE(?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_CURSO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_CURSO_SELECT(?,?)";
	
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
	
	
	protected CursoDataAccessAdditional cursoDataAccessAdditional=null;
	
	public CursoDataAccessAdditional getCursoDataAccessAdditional() {
		return this.cursoDataAccessAdditional;
	}
	
	public void setCursoDataAccessAdditional(CursoDataAccessAdditional cursoDataAccessAdditional) {
		try {
			this.cursoDataAccessAdditional=cursoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public CursoDataAccess() {
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
		CursoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		CursoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		CursoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setCursoOriginal(Curso curso)throws Exception  {
		curso.setCursoOriginal((Curso)curso.clone());		
	}
	
	public void setCursosOriginal(List<Curso> cursos)throws Exception  {
		
		for(Curso curso:cursos){
			curso.setCursoOriginal((Curso)curso.clone());
		}
	}
	
	public static void setCursoOriginalStatic(Curso curso)throws Exception  {
		curso.setCursoOriginal((Curso)curso.clone());		
	}
	
	public static void setCursosOriginalStatic(List<Curso> cursos)throws Exception  {
		
		for(Curso curso:cursos){
			curso.setCursoOriginal((Curso)curso.clone());
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
	
	public  Curso getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		Curso entity = new Curso();		
		
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
	
	public  Curso getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		Curso entity = new Curso();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=CursoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CursoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.Curso.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setCursoOriginal(new Curso());
      	    	entity=super.getEntity("",entity,resultSet,CursoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityCurso("",entity,resultSet); 
				
				//entity.setCursoOriginal(super.getEntity("",entity.getCursoOriginal(),resultSet,CursoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCursoOriginal(this.getEntityCurso("",entity.getCursoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseCurso(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  Curso getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Curso entity = new Curso();
				
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
	
	public  Curso getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Curso entity = new Curso();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=CursoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CursoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CursoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.Curso.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setCursoOriginal(new Curso());
      	    	entity=super.getEntity("",entity,resultSet,CursoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityCurso("",entity,resultSet);    
				
				//entity.setCursoOriginal(super.getEntity("",entity.getCursoOriginal(),resultSet,CursoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCursoOriginal(this.getEntityCurso("",entity.getCursoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseCurso(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //Curso
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		Curso entity = new Curso();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CursoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CursoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CursoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.Curso.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseCurso(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<Curso> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Curso> entities = new  ArrayList<Curso>();
		Curso entity = new Curso();		  
		
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
	
	public  List<Curso> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Curso> entities = new  ArrayList<Curso>();
		Curso entity = new Curso();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=CursoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CursoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CursoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Curso();
      	    	entity=super.getEntity("",entity,resultSet,CursoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCurso("",entity,resultSet);
      	    	
				//entity.setCursoOriginal( new Curso());
      	    	//entity.setCursoOriginal(super.getEntity("",entity.getCursoOriginal(),resultSet,CursoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCursoOriginal(this.getEntityCurso("",entity.getCursoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCursos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCurso(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Curso> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Curso> entities = new  ArrayList<Curso>();
		Curso entity = new Curso();		  
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
	
	public  List<Curso> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Curso> entities = new  ArrayList<Curso>();
		Curso entity = new Curso();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Curso();
				
				if(conMapGenerico) {
					entity.inicializarMapCurso();
					//entity.setMapCurso(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapCursoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapCurso().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CursoDataAccess.ISWITHSCHEMA);         		
					entity=CursoDataAccess.getEntityCurso("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setCursoOriginal( new Curso());
					////entity.setCursoOriginal(super.getEntity("",entity.getCursoOriginal(),resultSet,CursoDataAccess.ISWITHSCHEMA));         		
					////entity.setCursoOriginal(this.getEntityCurso("",entity.getCursoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCursos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCurso(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public Curso getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Curso entity = new Curso();		  
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
	
	public  Curso getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Curso entity = new Curso();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Curso();
				
				if(conMapGenerico) {
					entity.inicializarMapCurso();
					//entity.setMapCurso(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapCursoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapCurso().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CursoDataAccess.ISWITHSCHEMA);         		
					entity=CursoDataAccess.getEntityCurso("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setCursoOriginal( new Curso());
					////entity.setCursoOriginal(super.getEntity("",entity.getCursoOriginal(),resultSet,CursoDataAccess.ISWITHSCHEMA));         		
					////entity.setCursoOriginal(this.getEntityCurso("",entity.getCursoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseCurso(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCurso(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static Curso getEntityCurso(String strPrefijo,Curso entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = Curso.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = Curso.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					CursoDataAccess.setFieldReflectionCurso(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasCurso=CursoConstantesFunciones.getTodosTiposColumnasCurso();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasCurso) {
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
							field = Curso.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = Curso.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						CursoDataAccess.setFieldReflectionCurso(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionCurso(Field field,String strPrefijo,String sColumn,Curso entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case CursoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CursoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CursoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CursoConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CursoConstantesFunciones.IDTIPOCURSO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CursoConstantesFunciones.IDTIPOINSTITUCION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CursoConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CursoConstantesFunciones.CODIGOINSCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CursoConstantesFunciones.FECHAINICIO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case CursoConstantesFunciones.FECHAFIN:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case CursoConstantesFunciones.NUMEROHORAS:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case CursoConstantesFunciones.ESAPROBADO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case CursoConstantesFunciones.ESAUSPICIOEMPRESA:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case CursoConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Curso>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<Curso> entities = new  ArrayList<Curso>();
		Curso entity = new Curso();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CursoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CursoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CursoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new Curso();
					entity=super.getEntity("",entity,resultSet,CursoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityCurso("",entity,resultSet);
					
					//entity.setCursoOriginal( new Curso());
					//entity.setCursoOriginal(super.getEntity("",entity.getCursoOriginal(),resultSet,CursoDataAccess.ISWITHSCHEMA));         		
					//entity.setCursoOriginal(this.getEntityCurso("",entity.getCursoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseCursos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCurso(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Curso>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<Curso> entities = new  ArrayList<Curso>();
		Curso entity = new Curso();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CursoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CursoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CursoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<Curso> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Curso> entities = new  ArrayList<Curso>();
		Curso entity = new Curso();		  
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
	
	public  List<Curso> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Curso> entities = new  ArrayList<Curso>();
		Curso entity = new Curso();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Curso();
      	    	entity=super.getEntity("",entity,resultSet,CursoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCurso("",entity,resultSet);
      	    	
				//entity.setCursoOriginal( new Curso());
      	    	//entity.setCursoOriginal(super.getEntity("",entity.getCursoOriginal(),resultSet,CursoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCursoOriginal(this.getEntityCurso("",entity.getCursoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseCursos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCurso(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Curso> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Curso> entities = new  ArrayList<Curso>();
		Curso entity = new Curso();		  
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
	
	public  List<Curso> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Curso> entities = new  ArrayList<Curso>();
		Curso entity = new Curso();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Curso();
      	    	entity=super.getEntity("",entity,resultSet,CursoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCurso("",entity,resultSet);
      	    	
				//entity.setCursoOriginal( new Curso());
      	    	//entity.setCursoOriginal(super.getEntity("",entity.getCursoOriginal(),resultSet,CursoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCursoOriginal(this.getEntityCurso("",entity.getCursoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCursos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public Curso getEntityCurso(String strPrefijo,Curso entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+CursoConstantesFunciones.IDEMPRESA));
				entity.setid_empleado(resultSet.getLong(strPrefijo+CursoConstantesFunciones.IDEMPLEADO));
				entity.setid_tipo_curso(resultSet.getLong(strPrefijo+CursoConstantesFunciones.IDTIPOCURSO));
				entity.setid_tipo_institucion(resultSet.getLong(strPrefijo+CursoConstantesFunciones.IDTIPOINSTITUCION));
				entity.setnombre(resultSet.getString(strPrefijo+CursoConstantesFunciones.NOMBRE));
				entity.setcodigo_inscripcion(resultSet.getString(strPrefijo+CursoConstantesFunciones.CODIGOINSCRIPCION));
				entity.setfecha_inicio(new Date(resultSet.getDate(strPrefijo+CursoConstantesFunciones.FECHAINICIO).getTime()));
				entity.setfecha_fin(new Date(resultSet.getDate(strPrefijo+CursoConstantesFunciones.FECHAFIN).getTime()));
				entity.setnumero_horas(resultSet.getInt(strPrefijo+CursoConstantesFunciones.NUMEROHORAS));
				entity.setes_aprobado(resultSet.getBoolean(strPrefijo+CursoConstantesFunciones.ESAPROBADO));
				entity.setes_auspicio_empresa(resultSet.getBoolean(strPrefijo+CursoConstantesFunciones.ESAUSPICIOEMPRESA));
				entity.setdescripcion(resultSet.getString(strPrefijo+CursoConstantesFunciones.DESCRIPCION));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+CursoConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowCurso(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(Curso entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=CursoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=CursoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=CursoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=CursoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(CursoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,CursoDataAccess.TABLENAME,CursoDataAccess.ISWITHSTOREPROCEDURES);
			
			CursoDataAccess.setCursoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,Curso relcurso)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relcurso.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Empleado getEmpleado(Connexion connexion,Curso relcurso)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relcurso.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public TipoCurso getTipoCurso(Connexion connexion,Curso relcurso)throws SQLException,Exception {

		TipoCurso tipocurso= new TipoCurso();

		try {
			TipoCursoDataAccess tipocursoDataAccess=new TipoCursoDataAccess();

			tipocursoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipocursoDataAccess.setConnexionType(this.connexionType);
			tipocursoDataAccess.setParameterDbType(this.parameterDbType);

			tipocurso=tipocursoDataAccess.getEntity(connexion,relcurso.getid_tipo_curso());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipocurso;

	}

	public TipoInstitucion getTipoInstitucion(Connexion connexion,Curso relcurso)throws SQLException,Exception {

		TipoInstitucion tipoinstitucion= new TipoInstitucion();

		try {
			TipoInstitucionDataAccess tipoinstitucionDataAccess=new TipoInstitucionDataAccess();

			tipoinstitucionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoinstitucionDataAccess.setConnexionType(this.connexionType);
			tipoinstitucionDataAccess.setParameterDbType(this.parameterDbType);

			tipoinstitucion=tipoinstitucionDataAccess.getEntity(connexion,relcurso.getid_tipo_institucion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoinstitucion;

	}


		
		public List<DetalleCurso> getDetalleCursos(Connexion connexion,Curso curso)throws SQLException,Exception {

		List<DetalleCurso> detallecursos= new ArrayList<DetalleCurso>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CursoConstantesFunciones.SCHEMA+".curso ON "+DetalleCursoConstantesFunciones.SCHEMA+".detalle_curso.id_curso="+CursoConstantesFunciones.SCHEMA+".curso.id WHERE "+CursoConstantesFunciones.SCHEMA+".curso.id="+String.valueOf(curso.getId());
			} else {
				sQuery=" INNER JOIN detallecurso.Curso WHERE detallecurso.Curso.id="+String.valueOf(curso.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleCursoDataAccess detallecursoDataAccess=new DetalleCursoDataAccess();

			detallecursoDataAccess.setConnexionType(this.connexionType);
			detallecursoDataAccess.setParameterDbType(this.parameterDbType);
			detallecursos=detallecursoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detallecursos;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,Curso curso) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!curso.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(curso.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(curso.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_curso=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_curso.setValue(curso.getid_tipo_curso());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_curso);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_institucion=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_institucion.setValue(curso.getid_tipo_institucion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_institucion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(curso.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo_inscripcion=new ParameterValue<String>();
					parameterMaintenanceValuecodigo_inscripcion.setValue(curso.getcodigo_inscripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo_inscripcion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_inicio=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_inicio.setValue(curso.getfecha_inicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_inicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_fin=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_fin.setValue(curso.getfecha_fin());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_fin);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuenumero_horas=new ParameterValue<Integer>();
					parameterMaintenanceValuenumero_horas.setValue(curso.getnumero_horas());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_horas);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_aprobado=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_aprobado.setValue(curso.getes_aprobado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_aprobado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_auspicio_empresa=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_auspicio_empresa.setValue(curso.getes_auspicio_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_auspicio_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(curso.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!curso.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(curso.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(curso.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(curso.getId());
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
	
	public void setIsNewIsChangedFalseCurso(Curso curso)throws Exception  {		
		curso.setIsNew(false);
		curso.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseCursos(List<Curso> cursos)throws Exception  {				
		for(Curso curso:cursos) {
			curso.setIsNew(false);
			curso.setIsChanged(false);
		}
	}
	
	public void generarExportarCurso(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
