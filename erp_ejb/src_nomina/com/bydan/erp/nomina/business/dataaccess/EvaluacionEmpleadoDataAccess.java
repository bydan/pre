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
import com.bydan.erp.nomina.util.*;//EvaluacionEmpleadoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class EvaluacionEmpleadoDataAccess extends  EvaluacionEmpleadoDataAccessAdditional{ //EvaluacionEmpleadoDataAccessAdditional,DataAccessHelper<EvaluacionEmpleado>
	//static Logger logger = Logger.getLogger(EvaluacionEmpleadoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="evaluacion_empleado";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+EvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+EvaluacionEmpleadoConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_ejercicio,id_periodo,id_estructura,id_empleado,id_empleado_evalua,id_tipo_evaluacion_empleado,fecha,esta_evaluado,id_anio,id_semestre,id_trimestre,id_bimestre,id_mes,observacion1,observacion2,observacion3,observacion4)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+EvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+EvaluacionEmpleadoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_estructura=?,id_empleado=?,id_empleado_evalua=?,id_tipo_evaluacion_empleado=?,fecha=?,esta_evaluado=?,id_anio=?,id_semestre=?,id_trimestre=?,id_bimestre=?,id_mes=?,observacion1=?,observacion2=?,observacion3=?,observacion4=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+EvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+EvaluacionEmpleadoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select evaluacionempleado from "+EvaluacionEmpleadoConstantesFunciones.SPERSISTENCENAME+" evaluacionempleado";
	public static String QUERYSELECTNATIVE="select "+EvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+EvaluacionEmpleadoConstantesFunciones.TABLENAME+".id,"+EvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+EvaluacionEmpleadoConstantesFunciones.TABLENAME+".version_row,"+EvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+EvaluacionEmpleadoConstantesFunciones.TABLENAME+".id_empresa,"+EvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+EvaluacionEmpleadoConstantesFunciones.TABLENAME+".id_sucursal,"+EvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+EvaluacionEmpleadoConstantesFunciones.TABLENAME+".id_ejercicio,"+EvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+EvaluacionEmpleadoConstantesFunciones.TABLENAME+".id_periodo,"+EvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+EvaluacionEmpleadoConstantesFunciones.TABLENAME+".id_estructura,"+EvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+EvaluacionEmpleadoConstantesFunciones.TABLENAME+".id_empleado,"+EvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+EvaluacionEmpleadoConstantesFunciones.TABLENAME+".id_empleado_evalua,"+EvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+EvaluacionEmpleadoConstantesFunciones.TABLENAME+".id_tipo_evaluacion_empleado,"+EvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+EvaluacionEmpleadoConstantesFunciones.TABLENAME+".fecha,"+EvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+EvaluacionEmpleadoConstantesFunciones.TABLENAME+".esta_evaluado,"+EvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+EvaluacionEmpleadoConstantesFunciones.TABLENAME+".id_anio,"+EvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+EvaluacionEmpleadoConstantesFunciones.TABLENAME+".id_semestre,"+EvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+EvaluacionEmpleadoConstantesFunciones.TABLENAME+".id_trimestre,"+EvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+EvaluacionEmpleadoConstantesFunciones.TABLENAME+".id_bimestre,"+EvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+EvaluacionEmpleadoConstantesFunciones.TABLENAME+".id_mes,"+EvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+EvaluacionEmpleadoConstantesFunciones.TABLENAME+".observacion1,"+EvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+EvaluacionEmpleadoConstantesFunciones.TABLENAME+".observacion2,"+EvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+EvaluacionEmpleadoConstantesFunciones.TABLENAME+".observacion3,"+EvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+EvaluacionEmpleadoConstantesFunciones.TABLENAME+".observacion4 from "+EvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+EvaluacionEmpleadoConstantesFunciones.TABLENAME;//+" as "+EvaluacionEmpleadoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+EvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+EvaluacionEmpleadoConstantesFunciones.TABLENAME+".id,"+EvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+EvaluacionEmpleadoConstantesFunciones.TABLENAME+".version_row from "+EvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+EvaluacionEmpleadoConstantesFunciones.TABLENAME;//+" as "+EvaluacionEmpleadoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+EvaluacionEmpleadoConstantesFunciones.SCHEMA+"."+EvaluacionEmpleadoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_estructura=?,id_empleado=?,id_empleado_evalua=?,id_tipo_evaluacion_empleado=?,fecha=?,esta_evaluado=?,id_anio=?,id_semestre=?,id_trimestre=?,id_bimestre=?,id_mes=?,observacion1=?,observacion2=?,observacion3=?,observacion4=?";
	
	public static String STOREPROCEDUREINSERT="call SP_EVALUACIONEMPLEADO_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_EVALUACIONEMPLEADO_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_EVALUACIONEMPLEADO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_EVALUACIONEMPLEADO_SELECT(?,?)";
	
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
	
	
	protected EvaluacionEmpleadoDataAccessAdditional evaluacionempleadoDataAccessAdditional=null;
	
	public EvaluacionEmpleadoDataAccessAdditional getEvaluacionEmpleadoDataAccessAdditional() {
		return this.evaluacionempleadoDataAccessAdditional;
	}
	
	public void setEvaluacionEmpleadoDataAccessAdditional(EvaluacionEmpleadoDataAccessAdditional evaluacionempleadoDataAccessAdditional) {
		try {
			this.evaluacionempleadoDataAccessAdditional=evaluacionempleadoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public EvaluacionEmpleadoDataAccess() {
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
		EvaluacionEmpleadoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		EvaluacionEmpleadoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		EvaluacionEmpleadoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setEvaluacionEmpleadoOriginal(EvaluacionEmpleado evaluacionempleado)throws Exception  {
		evaluacionempleado.setEvaluacionEmpleadoOriginal((EvaluacionEmpleado)evaluacionempleado.clone());		
	}
	
	public void setEvaluacionEmpleadosOriginal(List<EvaluacionEmpleado> evaluacionempleados)throws Exception  {
		
		for(EvaluacionEmpleado evaluacionempleado:evaluacionempleados){
			evaluacionempleado.setEvaluacionEmpleadoOriginal((EvaluacionEmpleado)evaluacionempleado.clone());
		}
	}
	
	public static void setEvaluacionEmpleadoOriginalStatic(EvaluacionEmpleado evaluacionempleado)throws Exception  {
		evaluacionempleado.setEvaluacionEmpleadoOriginal((EvaluacionEmpleado)evaluacionempleado.clone());		
	}
	
	public static void setEvaluacionEmpleadosOriginalStatic(List<EvaluacionEmpleado> evaluacionempleados)throws Exception  {
		
		for(EvaluacionEmpleado evaluacionempleado:evaluacionempleados){
			evaluacionempleado.setEvaluacionEmpleadoOriginal((EvaluacionEmpleado)evaluacionempleado.clone());
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
	
	public  EvaluacionEmpleado getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		EvaluacionEmpleado entity = new EvaluacionEmpleado();		
		
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
	
	public  EvaluacionEmpleado getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		EvaluacionEmpleado entity = new EvaluacionEmpleado();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EvaluacionEmpleadoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EvaluacionEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.EvaluacionEmpleado.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setEvaluacionEmpleadoOriginal(new EvaluacionEmpleado());
      	    	entity=super.getEntity("",entity,resultSet,EvaluacionEmpleadoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEvaluacionEmpleado("",entity,resultSet); 
				
				//entity.setEvaluacionEmpleadoOriginal(super.getEntity("",entity.getEvaluacionEmpleadoOriginal(),resultSet,EvaluacionEmpleadoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEvaluacionEmpleadoOriginal(this.getEntityEvaluacionEmpleado("",entity.getEvaluacionEmpleadoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseEvaluacionEmpleado(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  EvaluacionEmpleado getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EvaluacionEmpleado entity = new EvaluacionEmpleado();
				
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
	
	public  EvaluacionEmpleado getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EvaluacionEmpleado entity = new EvaluacionEmpleado();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EvaluacionEmpleadoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EvaluacionEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EvaluacionEmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.EvaluacionEmpleado.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setEvaluacionEmpleadoOriginal(new EvaluacionEmpleado());
      	    	entity=super.getEntity("",entity,resultSet,EvaluacionEmpleadoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEvaluacionEmpleado("",entity,resultSet);    
				
				//entity.setEvaluacionEmpleadoOriginal(super.getEntity("",entity.getEvaluacionEmpleadoOriginal(),resultSet,EvaluacionEmpleadoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEvaluacionEmpleadoOriginal(this.getEntityEvaluacionEmpleado("",entity.getEvaluacionEmpleadoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseEvaluacionEmpleado(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //EvaluacionEmpleado
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		EvaluacionEmpleado entity = new EvaluacionEmpleado();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EvaluacionEmpleadoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EvaluacionEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EvaluacionEmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.EvaluacionEmpleado.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseEvaluacionEmpleado(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<EvaluacionEmpleado> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EvaluacionEmpleado> entities = new  ArrayList<EvaluacionEmpleado>();
		EvaluacionEmpleado entity = new EvaluacionEmpleado();		  
		
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
	
	public  List<EvaluacionEmpleado> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EvaluacionEmpleado> entities = new  ArrayList<EvaluacionEmpleado>();
		EvaluacionEmpleado entity = new EvaluacionEmpleado();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=EvaluacionEmpleadoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EvaluacionEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EvaluacionEmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EvaluacionEmpleado();
      	    	entity=super.getEntity("",entity,resultSet,EvaluacionEmpleadoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEvaluacionEmpleado("",entity,resultSet);
      	    	
				//entity.setEvaluacionEmpleadoOriginal( new EvaluacionEmpleado());
      	    	//entity.setEvaluacionEmpleadoOriginal(super.getEntity("",entity.getEvaluacionEmpleadoOriginal(),resultSet,EvaluacionEmpleadoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEvaluacionEmpleadoOriginal(this.getEntityEvaluacionEmpleado("",entity.getEvaluacionEmpleadoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEvaluacionEmpleados(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEvaluacionEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<EvaluacionEmpleado> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EvaluacionEmpleado> entities = new  ArrayList<EvaluacionEmpleado>();
		EvaluacionEmpleado entity = new EvaluacionEmpleado();		  
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
	
	public  List<EvaluacionEmpleado> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EvaluacionEmpleado> entities = new  ArrayList<EvaluacionEmpleado>();
		EvaluacionEmpleado entity = new EvaluacionEmpleado();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EvaluacionEmpleado();
				
				if(conMapGenerico) {
					entity.inicializarMapEvaluacionEmpleado();
					//entity.setMapEvaluacionEmpleado(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapEvaluacionEmpleadoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEvaluacionEmpleado().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EvaluacionEmpleadoDataAccess.ISWITHSCHEMA);         		
					entity=EvaluacionEmpleadoDataAccess.getEntityEvaluacionEmpleado("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEvaluacionEmpleadoOriginal( new EvaluacionEmpleado());
					////entity.setEvaluacionEmpleadoOriginal(super.getEntity("",entity.getEvaluacionEmpleadoOriginal(),resultSet,EvaluacionEmpleadoDataAccess.ISWITHSCHEMA));         		
					////entity.setEvaluacionEmpleadoOriginal(this.getEntityEvaluacionEmpleado("",entity.getEvaluacionEmpleadoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEvaluacionEmpleados(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEvaluacionEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public EvaluacionEmpleado getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EvaluacionEmpleado entity = new EvaluacionEmpleado();		  
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
	
	public  EvaluacionEmpleado getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EvaluacionEmpleado entity = new EvaluacionEmpleado();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EvaluacionEmpleado();
				
				if(conMapGenerico) {
					entity.inicializarMapEvaluacionEmpleado();
					//entity.setMapEvaluacionEmpleado(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapEvaluacionEmpleadoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEvaluacionEmpleado().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EvaluacionEmpleadoDataAccess.ISWITHSCHEMA);         		
					entity=EvaluacionEmpleadoDataAccess.getEntityEvaluacionEmpleado("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEvaluacionEmpleadoOriginal( new EvaluacionEmpleado());
					////entity.setEvaluacionEmpleadoOriginal(super.getEntity("",entity.getEvaluacionEmpleadoOriginal(),resultSet,EvaluacionEmpleadoDataAccess.ISWITHSCHEMA));         		
					////entity.setEvaluacionEmpleadoOriginal(this.getEntityEvaluacionEmpleado("",entity.getEvaluacionEmpleadoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseEvaluacionEmpleado(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEvaluacionEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static EvaluacionEmpleado getEntityEvaluacionEmpleado(String strPrefijo,EvaluacionEmpleado entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = EvaluacionEmpleado.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = EvaluacionEmpleado.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					EvaluacionEmpleadoDataAccess.setFieldReflectionEvaluacionEmpleado(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasEvaluacionEmpleado=EvaluacionEmpleadoConstantesFunciones.getTodosTiposColumnasEvaluacionEmpleado();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasEvaluacionEmpleado) {
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
							field = EvaluacionEmpleado.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = EvaluacionEmpleado.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						EvaluacionEmpleadoDataAccess.setFieldReflectionEvaluacionEmpleado(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionEvaluacionEmpleado(Field field,String strPrefijo,String sColumn,EvaluacionEmpleado entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case EvaluacionEmpleadoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EvaluacionEmpleadoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EvaluacionEmpleadoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EvaluacionEmpleadoConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EvaluacionEmpleadoConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EvaluacionEmpleadoConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EvaluacionEmpleadoConstantesFunciones.IDESTRUCTURA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EvaluacionEmpleadoConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EvaluacionEmpleadoConstantesFunciones.IDEMPLEADOEVALUA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EvaluacionEmpleadoConstantesFunciones.IDTIPOEVALUACIONEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EvaluacionEmpleadoConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case EvaluacionEmpleadoConstantesFunciones.ESTAEVALUADO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case EvaluacionEmpleadoConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EvaluacionEmpleadoConstantesFunciones.IDSEMESTRE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EvaluacionEmpleadoConstantesFunciones.IDTRIMESTRE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EvaluacionEmpleadoConstantesFunciones.IDBIMESTRE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EvaluacionEmpleadoConstantesFunciones.IDMES:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EvaluacionEmpleadoConstantesFunciones.OBSERVACION1:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EvaluacionEmpleadoConstantesFunciones.OBSERVACION2:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EvaluacionEmpleadoConstantesFunciones.OBSERVACION3:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EvaluacionEmpleadoConstantesFunciones.OBSERVACION4:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EvaluacionEmpleado>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<EvaluacionEmpleado> entities = new  ArrayList<EvaluacionEmpleado>();
		EvaluacionEmpleado entity = new EvaluacionEmpleado();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EvaluacionEmpleadoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EvaluacionEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EvaluacionEmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new EvaluacionEmpleado();
					entity=super.getEntity("",entity,resultSet,EvaluacionEmpleadoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityEvaluacionEmpleado("",entity,resultSet);
					
					//entity.setEvaluacionEmpleadoOriginal( new EvaluacionEmpleado());
					//entity.setEvaluacionEmpleadoOriginal(super.getEntity("",entity.getEvaluacionEmpleadoOriginal(),resultSet,EvaluacionEmpleadoDataAccess.ISWITHSCHEMA));         		
					//entity.setEvaluacionEmpleadoOriginal(this.getEntityEvaluacionEmpleado("",entity.getEvaluacionEmpleadoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseEvaluacionEmpleados(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEvaluacionEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EvaluacionEmpleado>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<EvaluacionEmpleado> entities = new  ArrayList<EvaluacionEmpleado>();
		EvaluacionEmpleado entity = new EvaluacionEmpleado();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EvaluacionEmpleadoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EvaluacionEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EvaluacionEmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<EvaluacionEmpleado> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EvaluacionEmpleado> entities = new  ArrayList<EvaluacionEmpleado>();
		EvaluacionEmpleado entity = new EvaluacionEmpleado();		  
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
	
	public  List<EvaluacionEmpleado> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EvaluacionEmpleado> entities = new  ArrayList<EvaluacionEmpleado>();
		EvaluacionEmpleado entity = new EvaluacionEmpleado();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EvaluacionEmpleado();
      	    	entity=super.getEntity("",entity,resultSet,EvaluacionEmpleadoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEvaluacionEmpleado("",entity,resultSet);
      	    	
				//entity.setEvaluacionEmpleadoOriginal( new EvaluacionEmpleado());
      	    	//entity.setEvaluacionEmpleadoOriginal(super.getEntity("",entity.getEvaluacionEmpleadoOriginal(),resultSet,EvaluacionEmpleadoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEvaluacionEmpleadoOriginal(this.getEntityEvaluacionEmpleado("",entity.getEvaluacionEmpleadoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseEvaluacionEmpleados(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEvaluacionEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<EvaluacionEmpleado> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EvaluacionEmpleado> entities = new  ArrayList<EvaluacionEmpleado>();
		EvaluacionEmpleado entity = new EvaluacionEmpleado();		  
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
	
	public  List<EvaluacionEmpleado> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EvaluacionEmpleado> entities = new  ArrayList<EvaluacionEmpleado>();
		EvaluacionEmpleado entity = new EvaluacionEmpleado();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EvaluacionEmpleado();
      	    	entity=super.getEntity("",entity,resultSet,EvaluacionEmpleadoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEvaluacionEmpleado("",entity,resultSet);
      	    	
				//entity.setEvaluacionEmpleadoOriginal( new EvaluacionEmpleado());
      	    	//entity.setEvaluacionEmpleadoOriginal(super.getEntity("",entity.getEvaluacionEmpleadoOriginal(),resultSet,EvaluacionEmpleadoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEvaluacionEmpleadoOriginal(this.getEntityEvaluacionEmpleado("",entity.getEvaluacionEmpleadoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEvaluacionEmpleados(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public EvaluacionEmpleado getEntityEvaluacionEmpleado(String strPrefijo,EvaluacionEmpleado entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+EvaluacionEmpleadoConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+EvaluacionEmpleadoConstantesFunciones.IDSUCURSAL));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+EvaluacionEmpleadoConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+EvaluacionEmpleadoConstantesFunciones.IDPERIODO));
				entity.setid_estructura(resultSet.getLong(strPrefijo+EvaluacionEmpleadoConstantesFunciones.IDESTRUCTURA));
				entity.setid_empleado(resultSet.getLong(strPrefijo+EvaluacionEmpleadoConstantesFunciones.IDEMPLEADO));
				entity.setid_empleado_evalua(resultSet.getLong(strPrefijo+EvaluacionEmpleadoConstantesFunciones.IDEMPLEADOEVALUA));
				entity.setid_tipo_evaluacion_empleado(resultSet.getLong(strPrefijo+EvaluacionEmpleadoConstantesFunciones.IDTIPOEVALUACIONEMPLEADO));
				entity.setfecha(new Date(resultSet.getDate(strPrefijo+EvaluacionEmpleadoConstantesFunciones.FECHA).getTime()));
				entity.setesta_evaluado(resultSet.getBoolean(strPrefijo+EvaluacionEmpleadoConstantesFunciones.ESTAEVALUADO));
				entity.setid_anio(resultSet.getLong(strPrefijo+EvaluacionEmpleadoConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
				entity.setid_semestre(resultSet.getLong(strPrefijo+EvaluacionEmpleadoConstantesFunciones.IDSEMESTRE));
				entity.setid_trimestre(resultSet.getLong(strPrefijo+EvaluacionEmpleadoConstantesFunciones.IDTRIMESTRE));
				entity.setid_bimestre(resultSet.getLong(strPrefijo+EvaluacionEmpleadoConstantesFunciones.IDBIMESTRE));
				entity.setid_mes(resultSet.getLong(strPrefijo+EvaluacionEmpleadoConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
				entity.setobservacion1(resultSet.getString(strPrefijo+EvaluacionEmpleadoConstantesFunciones.OBSERVACION1));
				entity.setobservacion2(resultSet.getString(strPrefijo+EvaluacionEmpleadoConstantesFunciones.OBSERVACION2));
				entity.setobservacion3(resultSet.getString(strPrefijo+EvaluacionEmpleadoConstantesFunciones.OBSERVACION3));
				entity.setobservacion4(resultSet.getString(strPrefijo+EvaluacionEmpleadoConstantesFunciones.OBSERVACION4));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowEvaluacionEmpleado(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(EvaluacionEmpleado entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=EvaluacionEmpleadoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=EvaluacionEmpleadoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=EvaluacionEmpleadoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=EvaluacionEmpleadoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(EvaluacionEmpleadoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,EvaluacionEmpleadoDataAccess.TABLENAME,EvaluacionEmpleadoDataAccess.ISWITHSTOREPROCEDURES);
			
			EvaluacionEmpleadoDataAccess.setEvaluacionEmpleadoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,EvaluacionEmpleado relevaluacionempleado)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relevaluacionempleado.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,EvaluacionEmpleado relevaluacionempleado)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relevaluacionempleado.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,EvaluacionEmpleado relevaluacionempleado)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relevaluacionempleado.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,EvaluacionEmpleado relevaluacionempleado)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,relevaluacionempleado.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public Estructura getEstructura(Connexion connexion,EvaluacionEmpleado relevaluacionempleado)throws SQLException,Exception {

		Estructura estructura= new Estructura();

		try {
			EstructuraDataAccess estructuraDataAccess=new EstructuraDataAccess();

			estructuraDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estructuraDataAccess.setConnexionType(this.connexionType);
			estructuraDataAccess.setParameterDbType(this.parameterDbType);

			estructura=estructuraDataAccess.getEntity(connexion,relevaluacionempleado.getid_estructura());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estructura;

	}

	public Empleado getEmpleado(Connexion connexion,EvaluacionEmpleado relevaluacionempleado)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relevaluacionempleado.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public Empleado getEmpleadoEvalua(Connexion connexion,EvaluacionEmpleado relevaluacionempleado)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relevaluacionempleado.getid_empleado_evalua());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public TipoEvaluacionEmpleado getTipoEvaluacionEmpleado(Connexion connexion,EvaluacionEmpleado relevaluacionempleado)throws SQLException,Exception {

		TipoEvaluacionEmpleado tipoevaluacionempleado= new TipoEvaluacionEmpleado();

		try {
			TipoEvaluacionEmpleadoDataAccess tipoevaluacionempleadoDataAccess=new TipoEvaluacionEmpleadoDataAccess();

			tipoevaluacionempleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoevaluacionempleadoDataAccess.setConnexionType(this.connexionType);
			tipoevaluacionempleadoDataAccess.setParameterDbType(this.parameterDbType);

			tipoevaluacionempleado=tipoevaluacionempleadoDataAccess.getEntity(connexion,relevaluacionempleado.getid_tipo_evaluacion_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoevaluacionempleado;

	}

	public Anio getAnio(Connexion connexion,EvaluacionEmpleado relevaluacionempleado)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);

			anio=anioDataAccess.getEntity(connexion,relevaluacionempleado.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Semestre getSemestre(Connexion connexion,EvaluacionEmpleado relevaluacionempleado)throws SQLException,Exception {

		Semestre semestre= new Semestre();

		try {
			SemestreDataAccess semestreDataAccess=new SemestreDataAccess();

			semestreDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			semestreDataAccess.setConnexionType(this.connexionType);
			semestreDataAccess.setParameterDbType(this.parameterDbType);

			semestre=semestreDataAccess.getEntity(connexion,relevaluacionempleado.getid_semestre());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return semestre;

	}

	public Trimestre getTrimestre(Connexion connexion,EvaluacionEmpleado relevaluacionempleado)throws SQLException,Exception {

		Trimestre trimestre= new Trimestre();

		try {
			TrimestreDataAccess trimestreDataAccess=new TrimestreDataAccess();

			trimestreDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			trimestreDataAccess.setConnexionType(this.connexionType);
			trimestreDataAccess.setParameterDbType(this.parameterDbType);

			trimestre=trimestreDataAccess.getEntity(connexion,relevaluacionempleado.getid_trimestre());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return trimestre;

	}

	public Bimestre getBimestre(Connexion connexion,EvaluacionEmpleado relevaluacionempleado)throws SQLException,Exception {

		Bimestre bimestre= new Bimestre();

		try {
			BimestreDataAccess bimestreDataAccess=new BimestreDataAccess();

			bimestreDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bimestreDataAccess.setConnexionType(this.connexionType);
			bimestreDataAccess.setParameterDbType(this.parameterDbType);

			bimestre=bimestreDataAccess.getEntity(connexion,relevaluacionempleado.getid_bimestre());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bimestre;

	}

	public Mes getMes(Connexion connexion,EvaluacionEmpleado relevaluacionempleado)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,relevaluacionempleado.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}


		
		public List<CalificacionEmpleado> getCalificacionEmpleados(Connexion connexion,EvaluacionEmpleado evaluacionempleado)throws SQLException,Exception {

		List<CalificacionEmpleado> calificacionempleados= new ArrayList<CalificacionEmpleado>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EvaluacionEmpleadoConstantesFunciones.SCHEMA+".evaluacion_empleado ON "+CalificacionEmpleadoConstantesFunciones.SCHEMA+".calificacion_empleado.id_evaluacion_empleado="+EvaluacionEmpleadoConstantesFunciones.SCHEMA+".evaluacion_empleado.id WHERE "+EvaluacionEmpleadoConstantesFunciones.SCHEMA+".evaluacion_empleado.id="+String.valueOf(evaluacionempleado.getId());
			} else {
				sQuery=" INNER JOIN calificacionempleado.EvaluacionEmpleado WHERE calificacionempleado.EvaluacionEmpleado.id="+String.valueOf(evaluacionempleado.getId());

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


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,EvaluacionEmpleado evaluacionempleado) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!evaluacionempleado.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(evaluacionempleado.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(evaluacionempleado.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(evaluacionempleado.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(evaluacionempleado.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estructura=new ParameterValue<Long>();
					parameterMaintenanceValueid_estructura.setValue(evaluacionempleado.getid_estructura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estructura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(evaluacionempleado.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado_evalua=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado_evalua.setValue(evaluacionempleado.getid_empleado_evalua());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado_evalua);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_evaluacion_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_evaluacion_empleado.setValue(evaluacionempleado.getid_tipo_evaluacion_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_evaluacion_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha=new ParameterValue<Date>();
					parameterMaintenanceValuefecha.setValue(evaluacionempleado.getfecha());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValueesta_evaluado=new ParameterValue<Boolean>();
					parameterMaintenanceValueesta_evaluado.setValue(evaluacionempleado.getesta_evaluado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueesta_evaluado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_anio=new ParameterValue<Long>();
					parameterMaintenanceValueid_anio.setValue(evaluacionempleado.getid_anio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_anio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_semestre=new ParameterValue<Long>();
					parameterMaintenanceValueid_semestre.setValue(evaluacionempleado.getid_semestre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_semestre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_trimestre=new ParameterValue<Long>();
					parameterMaintenanceValueid_trimestre.setValue(evaluacionempleado.getid_trimestre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_trimestre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_bimestre=new ParameterValue<Long>();
					parameterMaintenanceValueid_bimestre.setValue(evaluacionempleado.getid_bimestre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_bimestre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes.setValue(evaluacionempleado.getid_mes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueobservacion1=new ParameterValue<String>();
					parameterMaintenanceValueobservacion1.setValue(evaluacionempleado.getobservacion1());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueobservacion1);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueobservacion2=new ParameterValue<String>();
					parameterMaintenanceValueobservacion2.setValue(evaluacionempleado.getobservacion2());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueobservacion2);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueobservacion3=new ParameterValue<String>();
					parameterMaintenanceValueobservacion3.setValue(evaluacionempleado.getobservacion3());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueobservacion3);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueobservacion4=new ParameterValue<String>();
					parameterMaintenanceValueobservacion4.setValue(evaluacionempleado.getobservacion4());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueobservacion4);
					parametersTemp.add(parameterMaintenance);
					
						if(!evaluacionempleado.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(evaluacionempleado.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(evaluacionempleado.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(evaluacionempleado.getId());
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
	
	public void setIsNewIsChangedFalseEvaluacionEmpleado(EvaluacionEmpleado evaluacionempleado)throws Exception  {		
		evaluacionempleado.setIsNew(false);
		evaluacionempleado.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseEvaluacionEmpleados(List<EvaluacionEmpleado> evaluacionempleados)throws Exception  {				
		for(EvaluacionEmpleado evaluacionempleado:evaluacionempleados) {
			evaluacionempleado.setIsNew(false);
			evaluacionempleado.setIsChanged(false);
		}
	}
	
	public void generarExportarEvaluacionEmpleado(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
