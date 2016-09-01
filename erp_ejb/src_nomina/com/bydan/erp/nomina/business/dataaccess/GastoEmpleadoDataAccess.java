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
import com.bydan.erp.nomina.util.*;//GastoEmpleadoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class GastoEmpleadoDataAccess extends  GastoEmpleadoDataAccessAdditional{ //GastoEmpleadoDataAccessAdditional,DataAccessHelper<GastoEmpleado>
	//static Logger logger = Logger.getLogger(GastoEmpleadoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="gasto_empleado";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+GastoEmpleadoConstantesFunciones.SCHEMA+"."+GastoEmpleadoConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_empleado,id_ejercicio,id_pais,id_ciudad,id_anio,id_mes,dia,id_usuario,id_estado_gasto_empleado,total_ingreso_actual,total_ingreso_otro,total_ingreso,gasto_vivienda,gasto_educacion,gasto_salud,gasto_vestimenta,gasto_alimentacion,total_gasto_actual,total_gasto,fecha,porcentaje,valor_maximo,valor_maximo_porcentaje)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+GastoEmpleadoConstantesFunciones.SCHEMA+"."+GastoEmpleadoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_empleado=?,id_ejercicio=?,id_pais=?,id_ciudad=?,id_anio=?,id_mes=?,dia=?,id_usuario=?,id_estado_gasto_empleado=?,total_ingreso_actual=?,total_ingreso_otro=?,total_ingreso=?,gasto_vivienda=?,gasto_educacion=?,gasto_salud=?,gasto_vestimenta=?,gasto_alimentacion=?,total_gasto_actual=?,total_gasto=?,fecha=?,porcentaje=?,valor_maximo=?,valor_maximo_porcentaje=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+GastoEmpleadoConstantesFunciones.SCHEMA+"."+GastoEmpleadoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select gastoempleado from "+GastoEmpleadoConstantesFunciones.SPERSISTENCENAME+" gastoempleado";
	public static String QUERYSELECTNATIVE="select "+GastoEmpleadoConstantesFunciones.SCHEMA+"."+GastoEmpleadoConstantesFunciones.TABLENAME+".id,"+GastoEmpleadoConstantesFunciones.SCHEMA+"."+GastoEmpleadoConstantesFunciones.TABLENAME+".version_row,"+GastoEmpleadoConstantesFunciones.SCHEMA+"."+GastoEmpleadoConstantesFunciones.TABLENAME+".id_empresa,"+GastoEmpleadoConstantesFunciones.SCHEMA+"."+GastoEmpleadoConstantesFunciones.TABLENAME+".id_sucursal,"+GastoEmpleadoConstantesFunciones.SCHEMA+"."+GastoEmpleadoConstantesFunciones.TABLENAME+".id_empleado,"+GastoEmpleadoConstantesFunciones.SCHEMA+"."+GastoEmpleadoConstantesFunciones.TABLENAME+".id_ejercicio,"+GastoEmpleadoConstantesFunciones.SCHEMA+"."+GastoEmpleadoConstantesFunciones.TABLENAME+".id_pais,"+GastoEmpleadoConstantesFunciones.SCHEMA+"."+GastoEmpleadoConstantesFunciones.TABLENAME+".id_ciudad,"+GastoEmpleadoConstantesFunciones.SCHEMA+"."+GastoEmpleadoConstantesFunciones.TABLENAME+".id_anio,"+GastoEmpleadoConstantesFunciones.SCHEMA+"."+GastoEmpleadoConstantesFunciones.TABLENAME+".id_mes,"+GastoEmpleadoConstantesFunciones.SCHEMA+"."+GastoEmpleadoConstantesFunciones.TABLENAME+".dia,"+GastoEmpleadoConstantesFunciones.SCHEMA+"."+GastoEmpleadoConstantesFunciones.TABLENAME+".id_usuario,"+GastoEmpleadoConstantesFunciones.SCHEMA+"."+GastoEmpleadoConstantesFunciones.TABLENAME+".id_estado_gasto_empleado,"+GastoEmpleadoConstantesFunciones.SCHEMA+"."+GastoEmpleadoConstantesFunciones.TABLENAME+".total_ingreso_actual,"+GastoEmpleadoConstantesFunciones.SCHEMA+"."+GastoEmpleadoConstantesFunciones.TABLENAME+".total_ingreso_otro,"+GastoEmpleadoConstantesFunciones.SCHEMA+"."+GastoEmpleadoConstantesFunciones.TABLENAME+".total_ingreso,"+GastoEmpleadoConstantesFunciones.SCHEMA+"."+GastoEmpleadoConstantesFunciones.TABLENAME+".gasto_vivienda,"+GastoEmpleadoConstantesFunciones.SCHEMA+"."+GastoEmpleadoConstantesFunciones.TABLENAME+".gasto_educacion,"+GastoEmpleadoConstantesFunciones.SCHEMA+"."+GastoEmpleadoConstantesFunciones.TABLENAME+".gasto_salud,"+GastoEmpleadoConstantesFunciones.SCHEMA+"."+GastoEmpleadoConstantesFunciones.TABLENAME+".gasto_vestimenta,"+GastoEmpleadoConstantesFunciones.SCHEMA+"."+GastoEmpleadoConstantesFunciones.TABLENAME+".gasto_alimentacion,"+GastoEmpleadoConstantesFunciones.SCHEMA+"."+GastoEmpleadoConstantesFunciones.TABLENAME+".total_gasto_actual,"+GastoEmpleadoConstantesFunciones.SCHEMA+"."+GastoEmpleadoConstantesFunciones.TABLENAME+".total_gasto,"+GastoEmpleadoConstantesFunciones.SCHEMA+"."+GastoEmpleadoConstantesFunciones.TABLENAME+".fecha,"+GastoEmpleadoConstantesFunciones.SCHEMA+"."+GastoEmpleadoConstantesFunciones.TABLENAME+".porcentaje,"+GastoEmpleadoConstantesFunciones.SCHEMA+"."+GastoEmpleadoConstantesFunciones.TABLENAME+".valor_maximo,"+GastoEmpleadoConstantesFunciones.SCHEMA+"."+GastoEmpleadoConstantesFunciones.TABLENAME+".valor_maximo_porcentaje from "+GastoEmpleadoConstantesFunciones.SCHEMA+"."+GastoEmpleadoConstantesFunciones.TABLENAME;//+" as "+GastoEmpleadoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+GastoEmpleadoConstantesFunciones.SCHEMA+"."+GastoEmpleadoConstantesFunciones.TABLENAME+".id,"+GastoEmpleadoConstantesFunciones.SCHEMA+"."+GastoEmpleadoConstantesFunciones.TABLENAME+".version_row from "+GastoEmpleadoConstantesFunciones.SCHEMA+"."+GastoEmpleadoConstantesFunciones.TABLENAME;//+" as "+GastoEmpleadoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+GastoEmpleadoConstantesFunciones.SCHEMA+"."+GastoEmpleadoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_empleado=?,id_ejercicio=?,id_pais=?,id_ciudad=?,id_anio=?,id_mes=?,dia=?,id_usuario=?,id_estado_gasto_empleado=?,total_ingreso_actual=?,total_ingreso_otro=?,total_ingreso=?,gasto_vivienda=?,gasto_educacion=?,gasto_salud=?,gasto_vestimenta=?,gasto_alimentacion=?,total_gasto_actual=?,total_gasto=?,fecha=?,porcentaje=?,valor_maximo=?,valor_maximo_porcentaje=?";
	
	public static String STOREPROCEDUREINSERT="call SP_GASTOEMPLEADO_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_GASTOEMPLEADO_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_GASTOEMPLEADO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_GASTOEMPLEADO_SELECT(?,?)";
	
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
	
	
	protected GastoEmpleadoDataAccessAdditional gastoempleadoDataAccessAdditional=null;
	
	public GastoEmpleadoDataAccessAdditional getGastoEmpleadoDataAccessAdditional() {
		return this.gastoempleadoDataAccessAdditional;
	}
	
	public void setGastoEmpleadoDataAccessAdditional(GastoEmpleadoDataAccessAdditional gastoempleadoDataAccessAdditional) {
		try {
			this.gastoempleadoDataAccessAdditional=gastoempleadoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public GastoEmpleadoDataAccess() {
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
		GastoEmpleadoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		GastoEmpleadoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		GastoEmpleadoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setGastoEmpleadoOriginal(GastoEmpleado gastoempleado)throws Exception  {
		gastoempleado.setGastoEmpleadoOriginal((GastoEmpleado)gastoempleado.clone());		
	}
	
	public void setGastoEmpleadosOriginal(List<GastoEmpleado> gastoempleados)throws Exception  {
		
		for(GastoEmpleado gastoempleado:gastoempleados){
			gastoempleado.setGastoEmpleadoOriginal((GastoEmpleado)gastoempleado.clone());
		}
	}
	
	public static void setGastoEmpleadoOriginalStatic(GastoEmpleado gastoempleado)throws Exception  {
		gastoempleado.setGastoEmpleadoOriginal((GastoEmpleado)gastoempleado.clone());		
	}
	
	public static void setGastoEmpleadosOriginalStatic(List<GastoEmpleado> gastoempleados)throws Exception  {
		
		for(GastoEmpleado gastoempleado:gastoempleados){
			gastoempleado.setGastoEmpleadoOriginal((GastoEmpleado)gastoempleado.clone());
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
	
	public  GastoEmpleado getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		GastoEmpleado entity = new GastoEmpleado();		
		
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
	
	public  GastoEmpleado getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		GastoEmpleado entity = new GastoEmpleado();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=GastoEmpleadoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=GastoEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.GastoEmpleado.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setGastoEmpleadoOriginal(new GastoEmpleado());
      	    	entity=super.getEntity("",entity,resultSet,GastoEmpleadoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityGastoEmpleado("",entity,resultSet); 
				
				//entity.setGastoEmpleadoOriginal(super.getEntity("",entity.getGastoEmpleadoOriginal(),resultSet,GastoEmpleadoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setGastoEmpleadoOriginal(this.getEntityGastoEmpleado("",entity.getGastoEmpleadoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseGastoEmpleado(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  GastoEmpleado getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		GastoEmpleado entity = new GastoEmpleado();
				
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
	
	public  GastoEmpleado getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		GastoEmpleado entity = new GastoEmpleado();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=GastoEmpleadoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=GastoEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,GastoEmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.GastoEmpleado.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setGastoEmpleadoOriginal(new GastoEmpleado());
      	    	entity=super.getEntity("",entity,resultSet,GastoEmpleadoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityGastoEmpleado("",entity,resultSet);    
				
				//entity.setGastoEmpleadoOriginal(super.getEntity("",entity.getGastoEmpleadoOriginal(),resultSet,GastoEmpleadoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setGastoEmpleadoOriginal(this.getEntityGastoEmpleado("",entity.getGastoEmpleadoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseGastoEmpleado(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //GastoEmpleado
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		GastoEmpleado entity = new GastoEmpleado();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=GastoEmpleadoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=GastoEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,GastoEmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.GastoEmpleado.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseGastoEmpleado(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<GastoEmpleado> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<GastoEmpleado> entities = new  ArrayList<GastoEmpleado>();
		GastoEmpleado entity = new GastoEmpleado();		  
		
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
	
	public  List<GastoEmpleado> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<GastoEmpleado> entities = new  ArrayList<GastoEmpleado>();
		GastoEmpleado entity = new GastoEmpleado();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=GastoEmpleadoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=GastoEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,GastoEmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new GastoEmpleado();
      	    	entity=super.getEntity("",entity,resultSet,GastoEmpleadoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityGastoEmpleado("",entity,resultSet);
      	    	
				//entity.setGastoEmpleadoOriginal( new GastoEmpleado());
      	    	//entity.setGastoEmpleadoOriginal(super.getEntity("",entity.getGastoEmpleadoOriginal(),resultSet,GastoEmpleadoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setGastoEmpleadoOriginal(this.getEntityGastoEmpleado("",entity.getGastoEmpleadoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseGastoEmpleados(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarGastoEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<GastoEmpleado> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<GastoEmpleado> entities = new  ArrayList<GastoEmpleado>();
		GastoEmpleado entity = new GastoEmpleado();		  
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
	
	public  List<GastoEmpleado> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<GastoEmpleado> entities = new  ArrayList<GastoEmpleado>();
		GastoEmpleado entity = new GastoEmpleado();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new GastoEmpleado();
				
				if(conMapGenerico) {
					entity.inicializarMapGastoEmpleado();
					//entity.setMapGastoEmpleado(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapGastoEmpleadoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapGastoEmpleado().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,GastoEmpleadoDataAccess.ISWITHSCHEMA);         		
					entity=GastoEmpleadoDataAccess.getEntityGastoEmpleado("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setGastoEmpleadoOriginal( new GastoEmpleado());
					////entity.setGastoEmpleadoOriginal(super.getEntity("",entity.getGastoEmpleadoOriginal(),resultSet,GastoEmpleadoDataAccess.ISWITHSCHEMA));         		
					////entity.setGastoEmpleadoOriginal(this.getEntityGastoEmpleado("",entity.getGastoEmpleadoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseGastoEmpleados(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarGastoEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public GastoEmpleado getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		GastoEmpleado entity = new GastoEmpleado();		  
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
	
	public  GastoEmpleado getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		GastoEmpleado entity = new GastoEmpleado();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new GastoEmpleado();
				
				if(conMapGenerico) {
					entity.inicializarMapGastoEmpleado();
					//entity.setMapGastoEmpleado(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapGastoEmpleadoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapGastoEmpleado().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,GastoEmpleadoDataAccess.ISWITHSCHEMA);         		
					entity=GastoEmpleadoDataAccess.getEntityGastoEmpleado("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setGastoEmpleadoOriginal( new GastoEmpleado());
					////entity.setGastoEmpleadoOriginal(super.getEntity("",entity.getGastoEmpleadoOriginal(),resultSet,GastoEmpleadoDataAccess.ISWITHSCHEMA));         		
					////entity.setGastoEmpleadoOriginal(this.getEntityGastoEmpleado("",entity.getGastoEmpleadoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseGastoEmpleado(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarGastoEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static GastoEmpleado getEntityGastoEmpleado(String strPrefijo,GastoEmpleado entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = GastoEmpleado.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = GastoEmpleado.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					GastoEmpleadoDataAccess.setFieldReflectionGastoEmpleado(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasGastoEmpleado=GastoEmpleadoConstantesFunciones.getTodosTiposColumnasGastoEmpleado();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasGastoEmpleado) {
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
							field = GastoEmpleado.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = GastoEmpleado.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						GastoEmpleadoDataAccess.setFieldReflectionGastoEmpleado(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionGastoEmpleado(Field field,String strPrefijo,String sColumn,GastoEmpleado entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case GastoEmpleadoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case GastoEmpleadoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case GastoEmpleadoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case GastoEmpleadoConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case GastoEmpleadoConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case GastoEmpleadoConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case GastoEmpleadoConstantesFunciones.IDPAIS:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case GastoEmpleadoConstantesFunciones.IDCIUDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case GastoEmpleadoConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case GastoEmpleadoConstantesFunciones.IDMES:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case GastoEmpleadoConstantesFunciones.DIA:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case GastoEmpleadoConstantesFunciones.IDUSUARIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case GastoEmpleadoConstantesFunciones.IDESTADOGASTOEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case GastoEmpleadoConstantesFunciones.TOTALINGRESOACTUAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case GastoEmpleadoConstantesFunciones.TOTALINGRESOOTRO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case GastoEmpleadoConstantesFunciones.TOTALINGRESO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case GastoEmpleadoConstantesFunciones.GASTOVIVIENDA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case GastoEmpleadoConstantesFunciones.GASTOEDUCACION:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case GastoEmpleadoConstantesFunciones.GASTOSALUD:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case GastoEmpleadoConstantesFunciones.GASTOVESTIMENTA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case GastoEmpleadoConstantesFunciones.GASTOALIMENTACION:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case GastoEmpleadoConstantesFunciones.TOTALGASTOACTUAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case GastoEmpleadoConstantesFunciones.TOTALGASTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case GastoEmpleadoConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case GastoEmpleadoConstantesFunciones.PORCENTAJE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case GastoEmpleadoConstantesFunciones.VALORMAXIMO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case GastoEmpleadoConstantesFunciones.VALORMAXIMOPORCENTAJE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<GastoEmpleado>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<GastoEmpleado> entities = new  ArrayList<GastoEmpleado>();
		GastoEmpleado entity = new GastoEmpleado();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=GastoEmpleadoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=GastoEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,GastoEmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new GastoEmpleado();
					entity=super.getEntity("",entity,resultSet,GastoEmpleadoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityGastoEmpleado("",entity,resultSet);
					
					//entity.setGastoEmpleadoOriginal( new GastoEmpleado());
					//entity.setGastoEmpleadoOriginal(super.getEntity("",entity.getGastoEmpleadoOriginal(),resultSet,GastoEmpleadoDataAccess.ISWITHSCHEMA));         		
					//entity.setGastoEmpleadoOriginal(this.getEntityGastoEmpleado("",entity.getGastoEmpleadoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseGastoEmpleados(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarGastoEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<GastoEmpleado>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<GastoEmpleado> entities = new  ArrayList<GastoEmpleado>();
		GastoEmpleado entity = new GastoEmpleado();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=GastoEmpleadoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=GastoEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,GastoEmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<GastoEmpleado> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<GastoEmpleado> entities = new  ArrayList<GastoEmpleado>();
		GastoEmpleado entity = new GastoEmpleado();		  
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
	
	public  List<GastoEmpleado> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<GastoEmpleado> entities = new  ArrayList<GastoEmpleado>();
		GastoEmpleado entity = new GastoEmpleado();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new GastoEmpleado();
      	    	entity=super.getEntity("",entity,resultSet,GastoEmpleadoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityGastoEmpleado("",entity,resultSet);
      	    	
				//entity.setGastoEmpleadoOriginal( new GastoEmpleado());
      	    	//entity.setGastoEmpleadoOriginal(super.getEntity("",entity.getGastoEmpleadoOriginal(),resultSet,GastoEmpleadoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setGastoEmpleadoOriginal(this.getEntityGastoEmpleado("",entity.getGastoEmpleadoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseGastoEmpleados(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarGastoEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<GastoEmpleado> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<GastoEmpleado> entities = new  ArrayList<GastoEmpleado>();
		GastoEmpleado entity = new GastoEmpleado();		  
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
	
	public  List<GastoEmpleado> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<GastoEmpleado> entities = new  ArrayList<GastoEmpleado>();
		GastoEmpleado entity = new GastoEmpleado();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new GastoEmpleado();
      	    	entity=super.getEntity("",entity,resultSet,GastoEmpleadoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityGastoEmpleado("",entity,resultSet);
      	    	
				//entity.setGastoEmpleadoOriginal( new GastoEmpleado());
      	    	//entity.setGastoEmpleadoOriginal(super.getEntity("",entity.getGastoEmpleadoOriginal(),resultSet,GastoEmpleadoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setGastoEmpleadoOriginal(this.getEntityGastoEmpleado("",entity.getGastoEmpleadoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseGastoEmpleados(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public GastoEmpleado getEntityGastoEmpleado(String strPrefijo,GastoEmpleado entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+GastoEmpleadoConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+GastoEmpleadoConstantesFunciones.IDSUCURSAL));
				entity.setid_empleado(resultSet.getLong(strPrefijo+GastoEmpleadoConstantesFunciones.IDEMPLEADO));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+GastoEmpleadoConstantesFunciones.IDEJERCICIO));
				entity.setid_pais(resultSet.getLong(strPrefijo+GastoEmpleadoConstantesFunciones.IDPAIS));
				entity.setid_ciudad(resultSet.getLong(strPrefijo+GastoEmpleadoConstantesFunciones.IDCIUDAD));
				entity.setid_anio(resultSet.getLong(strPrefijo+GastoEmpleadoConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
				entity.setid_mes(resultSet.getLong(strPrefijo+GastoEmpleadoConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
				entity.setdia(resultSet.getInt(strPrefijo+GastoEmpleadoConstantesFunciones.DIA));
				entity.setid_usuario(resultSet.getLong(strPrefijo+GastoEmpleadoConstantesFunciones.IDUSUARIO));
				entity.setid_estado_gasto_empleado(resultSet.getLong(strPrefijo+GastoEmpleadoConstantesFunciones.IDESTADOGASTOEMPLEADO));
				entity.settotal_ingreso_actual(resultSet.getDouble(strPrefijo+GastoEmpleadoConstantesFunciones.TOTALINGRESOACTUAL));
				entity.settotal_ingreso_otro(resultSet.getDouble(strPrefijo+GastoEmpleadoConstantesFunciones.TOTALINGRESOOTRO));
				entity.settotal_ingreso(resultSet.getDouble(strPrefijo+GastoEmpleadoConstantesFunciones.TOTALINGRESO));
				entity.setgasto_vivienda(resultSet.getDouble(strPrefijo+GastoEmpleadoConstantesFunciones.GASTOVIVIENDA));
				entity.setgasto_educacion(resultSet.getDouble(strPrefijo+GastoEmpleadoConstantesFunciones.GASTOEDUCACION));
				entity.setgasto_salud(resultSet.getDouble(strPrefijo+GastoEmpleadoConstantesFunciones.GASTOSALUD));
				entity.setgasto_vestimenta(resultSet.getDouble(strPrefijo+GastoEmpleadoConstantesFunciones.GASTOVESTIMENTA));
				entity.setgasto_alimentacion(resultSet.getDouble(strPrefijo+GastoEmpleadoConstantesFunciones.GASTOALIMENTACION));
				entity.settotal_gasto_actual(resultSet.getDouble(strPrefijo+GastoEmpleadoConstantesFunciones.TOTALGASTOACTUAL));
				entity.settotal_gasto(resultSet.getDouble(strPrefijo+GastoEmpleadoConstantesFunciones.TOTALGASTO));
				entity.setfecha(new Date(resultSet.getDate(strPrefijo+GastoEmpleadoConstantesFunciones.FECHA).getTime()));
				entity.setporcentaje(resultSet.getDouble(strPrefijo+GastoEmpleadoConstantesFunciones.PORCENTAJE));
				entity.setvalor_maximo(resultSet.getDouble(strPrefijo+GastoEmpleadoConstantesFunciones.VALORMAXIMO));
				entity.setvalor_maximo_porcentaje(resultSet.getDouble(strPrefijo+GastoEmpleadoConstantesFunciones.VALORMAXIMOPORCENTAJE));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowGastoEmpleado(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(GastoEmpleado entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=GastoEmpleadoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=GastoEmpleadoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=GastoEmpleadoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=GastoEmpleadoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(GastoEmpleadoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,GastoEmpleadoDataAccess.TABLENAME,GastoEmpleadoDataAccess.ISWITHSTOREPROCEDURES);
			
			GastoEmpleadoDataAccess.setGastoEmpleadoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,GastoEmpleado relgastoempleado)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relgastoempleado.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,GastoEmpleado relgastoempleado)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relgastoempleado.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Empleado getEmpleado(Connexion connexion,GastoEmpleado relgastoempleado)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relgastoempleado.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public Ejercicio getEjercicio(Connexion connexion,GastoEmpleado relgastoempleado)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relgastoempleado.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Pais getPais(Connexion connexion,GastoEmpleado relgastoempleado)throws SQLException,Exception {

		Pais pais= new Pais();

		try {
			PaisDataAccess paisDataAccess=new PaisDataAccess();

			paisDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			paisDataAccess.setConnexionType(this.connexionType);
			paisDataAccess.setParameterDbType(this.parameterDbType);

			pais=paisDataAccess.getEntity(connexion,relgastoempleado.getid_pais());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pais;

	}

	public Ciudad getCiudad(Connexion connexion,GastoEmpleado relgastoempleado)throws SQLException,Exception {

		Ciudad ciudad= new Ciudad();

		try {
			CiudadDataAccess ciudadDataAccess=new CiudadDataAccess();

			ciudadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ciudadDataAccess.setConnexionType(this.connexionType);
			ciudadDataAccess.setParameterDbType(this.parameterDbType);

			ciudad=ciudadDataAccess.getEntity(connexion,relgastoempleado.getid_ciudad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ciudad;

	}

	public Anio getAnio(Connexion connexion,GastoEmpleado relgastoempleado)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);

			anio=anioDataAccess.getEntity(connexion,relgastoempleado.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Mes getMes(Connexion connexion,GastoEmpleado relgastoempleado)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,relgastoempleado.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}

	public Usuario getUsuario(Connexion connexion,GastoEmpleado relgastoempleado)throws SQLException,Exception {

		Usuario usuario= new Usuario();

		try {
			UsuarioDataAccess usuarioDataAccess=new UsuarioDataAccess();

			usuarioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			usuarioDataAccess.setConnexionType(this.connexionType);
			usuarioDataAccess.setParameterDbType(this.parameterDbType);

			usuario=usuarioDataAccess.getEntity(connexion,relgastoempleado.getid_usuario());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return usuario;

	}

	public EstadoGastoEmpleado getEstadoGastoEmpleado(Connexion connexion,GastoEmpleado relgastoempleado)throws SQLException,Exception {

		EstadoGastoEmpleado estadogastoempleado= new EstadoGastoEmpleado();

		try {
			EstadoGastoEmpleadoDataAccess estadogastoempleadoDataAccess=new EstadoGastoEmpleadoDataAccess();

			estadogastoempleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadogastoempleadoDataAccess.setConnexionType(this.connexionType);
			estadogastoempleadoDataAccess.setParameterDbType(this.parameterDbType);

			estadogastoempleado=estadogastoempleadoDataAccess.getEntity(connexion,relgastoempleado.getid_estado_gasto_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadogastoempleado;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,GastoEmpleado gastoempleado) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!gastoempleado.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(gastoempleado.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(gastoempleado.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(gastoempleado.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(gastoempleado.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_pais=new ParameterValue<Long>();
					parameterMaintenanceValueid_pais.setValue(gastoempleado.getid_pais());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_pais);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ciudad=new ParameterValue<Long>();
					parameterMaintenanceValueid_ciudad.setValue(gastoempleado.getid_ciudad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ciudad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_anio=new ParameterValue<Long>();
					parameterMaintenanceValueid_anio.setValue(gastoempleado.getid_anio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_anio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes.setValue(gastoempleado.getid_mes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuedia=new ParameterValue<Integer>();
					parameterMaintenanceValuedia.setValue(gastoempleado.getdia());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedia);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_usuario=new ParameterValue<Long>();
					parameterMaintenanceValueid_usuario.setValue(gastoempleado.getid_usuario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_usuario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_gasto_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_gasto_empleado.setValue(gastoempleado.getid_estado_gasto_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_gasto_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal_ingreso_actual=new ParameterValue<Double>();
					parameterMaintenanceValuetotal_ingreso_actual.setValue(gastoempleado.gettotal_ingreso_actual());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal_ingreso_actual);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal_ingreso_otro=new ParameterValue<Double>();
					parameterMaintenanceValuetotal_ingreso_otro.setValue(gastoempleado.gettotal_ingreso_otro());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal_ingreso_otro);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal_ingreso=new ParameterValue<Double>();
					parameterMaintenanceValuetotal_ingreso.setValue(gastoempleado.gettotal_ingreso());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal_ingreso);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuegasto_vivienda=new ParameterValue<Double>();
					parameterMaintenanceValuegasto_vivienda.setValue(gastoempleado.getgasto_vivienda());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuegasto_vivienda);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuegasto_educacion=new ParameterValue<Double>();
					parameterMaintenanceValuegasto_educacion.setValue(gastoempleado.getgasto_educacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuegasto_educacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuegasto_salud=new ParameterValue<Double>();
					parameterMaintenanceValuegasto_salud.setValue(gastoempleado.getgasto_salud());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuegasto_salud);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuegasto_vestimenta=new ParameterValue<Double>();
					parameterMaintenanceValuegasto_vestimenta.setValue(gastoempleado.getgasto_vestimenta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuegasto_vestimenta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuegasto_alimentacion=new ParameterValue<Double>();
					parameterMaintenanceValuegasto_alimentacion.setValue(gastoempleado.getgasto_alimentacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuegasto_alimentacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal_gasto_actual=new ParameterValue<Double>();
					parameterMaintenanceValuetotal_gasto_actual.setValue(gastoempleado.gettotal_gasto_actual());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal_gasto_actual);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal_gasto=new ParameterValue<Double>();
					parameterMaintenanceValuetotal_gasto.setValue(gastoempleado.gettotal_gasto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal_gasto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha=new ParameterValue<Date>();
					parameterMaintenanceValuefecha.setValue(gastoempleado.getfecha());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcentaje=new ParameterValue<Double>();
					parameterMaintenanceValueporcentaje.setValue(gastoempleado.getporcentaje());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcentaje);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_maximo=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_maximo.setValue(gastoempleado.getvalor_maximo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_maximo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_maximo_porcentaje=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_maximo_porcentaje.setValue(gastoempleado.getvalor_maximo_porcentaje());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_maximo_porcentaje);
					parametersTemp.add(parameterMaintenance);
					
						if(!gastoempleado.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(gastoempleado.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(gastoempleado.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(gastoempleado.getId());
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
	
	public void setIsNewIsChangedFalseGastoEmpleado(GastoEmpleado gastoempleado)throws Exception  {		
		gastoempleado.setIsNew(false);
		gastoempleado.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseGastoEmpleados(List<GastoEmpleado> gastoempleados)throws Exception  {				
		for(GastoEmpleado gastoempleado:gastoempleados) {
			gastoempleado.setIsNew(false);
			gastoempleado.setIsChanged(false);
		}
	}
	
	public void generarExportarGastoEmpleado(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
