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
import com.bydan.erp.nomina.util.*;//EmpleadoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;




@SuppressWarnings("unused")
final public class EmpleadoDataAccess extends  EmpleadoDataAccessAdditional{ //EmpleadoDataAccessAdditional,DataAccessHelper<Empleado>
	//static Logger logger = Logger.getLogger(EmpleadoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="empleado";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_pais,id_provincia,id_ciudad,id_centro_costo,id_religion,id_estado_civil,id_tipo_genero,id_tipo_empleado,id_tipo_instruccion,id_cargo,id_estructura,id_estructura_seccion,id_estado_empleado,id_tipo_contrato,codigo,nombre,apellido,nombre_completo,mail,direccion,sueldo,telefono,id_tipo_cuenta_banco_global,numero_cuenta,tiene_casa,tiene_vehiculo)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_pais=?,id_provincia=?,id_ciudad=?,id_centro_costo=?,id_religion=?,id_estado_civil=?,id_tipo_genero=?,id_tipo_empleado=?,id_tipo_instruccion=?,id_cargo=?,id_estructura=?,id_estructura_seccion=?,id_estado_empleado=?,id_tipo_contrato=?,codigo=?,nombre=?,apellido=?,nombre_completo=?,mail=?,direccion=?,sueldo=?,telefono=?,id_tipo_cuenta_banco_global=?,numero_cuenta=?,tiene_casa=?,tiene_vehiculo=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select empleado from "+EmpleadoConstantesFunciones.SPERSISTENCENAME+" empleado";
	public static String QUERYSELECTNATIVE="select "+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME+".id,"+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME+".version_row,"+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME+".id_empresa,"+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME+".id_sucursal,"+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME+".id_pais,"+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME+".id_provincia,"+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME+".id_ciudad,"+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME+".id_centro_costo,"+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME+".id_religion,"+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME+".id_estado_civil,"+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME+".id_tipo_genero,"+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME+".id_tipo_empleado,"+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME+".id_tipo_instruccion,"+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME+".id_cargo,"+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME+".id_estructura,"+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME+".id_estructura_seccion,"+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME+".id_estado_empleado,"+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME+".id_tipo_contrato,"+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME+".codigo,"+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME+".nombre,"+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME+".apellido,"+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME+".nombre_completo,"+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME+".mail,"+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME+".direccion,"+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME+".sueldo,"+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME+".telefono,"+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME+".id_tipo_cuenta_banco_global,"+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME+".numero_cuenta,"+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME+".tiene_casa,"+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME+".tiene_vehiculo from "+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME;//+" as "+EmpleadoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME+".id,"+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME+".version_row,"+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME+".nombre_completo from "+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME;//+" as "+EmpleadoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+EmpleadoConstantesFunciones.SCHEMA+"."+EmpleadoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_pais=?,id_provincia=?,id_ciudad=?,id_centro_costo=?,id_religion=?,id_estado_civil=?,id_tipo_genero=?,id_tipo_empleado=?,id_tipo_instruccion=?,id_cargo=?,id_estructura=?,id_estructura_seccion=?,id_estado_empleado=?,id_tipo_contrato=?,codigo=?,nombre=?,apellido=?,nombre_completo=?,mail=?,direccion=?,sueldo=?,telefono=?,id_tipo_cuenta_banco_global=?,numero_cuenta=?,tiene_casa=?,tiene_vehiculo=?";
	
	public static String STOREPROCEDUREINSERT="call SP_EMPLEADO_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_EMPLEADO_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_EMPLEADO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_EMPLEADO_SELECT(?,?)";
	
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
	
	
	protected EmpleadoDataAccessAdditional empleadoDataAccessAdditional=null;
	
	public EmpleadoDataAccessAdditional getEmpleadoDataAccessAdditional() {
		return this.empleadoDataAccessAdditional;
	}
	
	public void setEmpleadoDataAccessAdditional(EmpleadoDataAccessAdditional empleadoDataAccessAdditional) {
		try {
			this.empleadoDataAccessAdditional=empleadoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public EmpleadoDataAccess() {
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
		EmpleadoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		EmpleadoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		EmpleadoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setEmpleadoOriginal(Empleado empleado)throws Exception  {
		empleado.setEmpleadoOriginal((Empleado)empleado.clone());		
	}
	
	public void setEmpleadosOriginal(List<Empleado> empleados)throws Exception  {
		
		for(Empleado empleado:empleados){
			empleado.setEmpleadoOriginal((Empleado)empleado.clone());
		}
	}
	
	public static void setEmpleadoOriginalStatic(Empleado empleado)throws Exception  {
		empleado.setEmpleadoOriginal((Empleado)empleado.clone());		
	}
	
	public static void setEmpleadosOriginalStatic(List<Empleado> empleados)throws Exception  {
		
		for(Empleado empleado:empleados){
			empleado.setEmpleadoOriginal((Empleado)empleado.clone());
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
	
	public  Empleado getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		Empleado entity = new Empleado();		
		
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
	
	public  Empleado getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		Empleado entity = new Empleado();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EmpleadoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.Empleado.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setEmpleadoOriginal(new Empleado());
      	    	entity=super.getEntity("",entity,resultSet,EmpleadoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEmpleado("",entity,resultSet); 
				
				//entity.setEmpleadoOriginal(super.getEntity("",entity.getEmpleadoOriginal(),resultSet,EmpleadoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmpleadoOriginal(this.getEntityEmpleado("",entity.getEmpleadoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseEmpleado(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  Empleado getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Empleado entity = new Empleado();
				
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
	
	public  Empleado getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Empleado entity = new Empleado();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EmpleadoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.Empleado.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setEmpleadoOriginal(new Empleado());
      	    	entity=super.getEntity("",entity,resultSet,EmpleadoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEmpleado("",entity,resultSet);    
				
				//entity.setEmpleadoOriginal(super.getEntity("",entity.getEmpleadoOriginal(),resultSet,EmpleadoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmpleadoOriginal(this.getEntityEmpleado("",entity.getEmpleadoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseEmpleado(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //Empleado
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		Empleado entity = new Empleado();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EmpleadoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.Empleado.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseEmpleado(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<Empleado> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Empleado> entities = new  ArrayList<Empleado>();
		Empleado entity = new Empleado();		  
		
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
	
	public  List<Empleado> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Empleado> entities = new  ArrayList<Empleado>();
		Empleado entity = new Empleado();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=EmpleadoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Empleado();
      	    	entity=super.getEntity("",entity,resultSet,EmpleadoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEmpleado("",entity,resultSet);
      	    	
				//entity.setEmpleadoOriginal( new Empleado());
      	    	//entity.setEmpleadoOriginal(super.getEntity("",entity.getEmpleadoOriginal(),resultSet,EmpleadoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmpleadoOriginal(this.getEntityEmpleado("",entity.getEmpleadoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEmpleados(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Empleado> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Empleado> entities = new  ArrayList<Empleado>();
		Empleado entity = new Empleado();		  
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
	
	public  List<Empleado> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Empleado> entities = new  ArrayList<Empleado>();
		Empleado entity = new Empleado();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Empleado();
				
				if(conMapGenerico) {
					entity.inicializarMapEmpleado();
					//entity.setMapEmpleado(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapEmpleadoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEmpleado().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EmpleadoDataAccess.ISWITHSCHEMA);         		
					entity=EmpleadoDataAccess.getEntityEmpleado("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEmpleadoOriginal( new Empleado());
					////entity.setEmpleadoOriginal(super.getEntity("",entity.getEmpleadoOriginal(),resultSet,EmpleadoDataAccess.ISWITHSCHEMA));         		
					////entity.setEmpleadoOriginal(this.getEntityEmpleado("",entity.getEmpleadoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEmpleados(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public Empleado getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Empleado entity = new Empleado();		  
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
	
	public  Empleado getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Empleado entity = new Empleado();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Empleado();
				
				if(conMapGenerico) {
					entity.inicializarMapEmpleado();
					//entity.setMapEmpleado(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapEmpleadoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEmpleado().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EmpleadoDataAccess.ISWITHSCHEMA);         		
					entity=EmpleadoDataAccess.getEntityEmpleado("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEmpleadoOriginal( new Empleado());
					////entity.setEmpleadoOriginal(super.getEntity("",entity.getEmpleadoOriginal(),resultSet,EmpleadoDataAccess.ISWITHSCHEMA));         		
					////entity.setEmpleadoOriginal(this.getEntityEmpleado("",entity.getEmpleadoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseEmpleado(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static Empleado getEntityEmpleado(String strPrefijo,Empleado entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = Empleado.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = Empleado.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					EmpleadoDataAccess.setFieldReflectionEmpleado(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasEmpleado=EmpleadoConstantesFunciones.getTodosTiposColumnasEmpleado();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasEmpleado) {
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
							field = Empleado.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = Empleado.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						EmpleadoDataAccess.setFieldReflectionEmpleado(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionEmpleado(Field field,String strPrefijo,String sColumn,Empleado entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case EmpleadoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmpleadoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EmpleadoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmpleadoConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmpleadoConstantesFunciones.IDPAIS:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmpleadoConstantesFunciones.IDPROVINCIA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmpleadoConstantesFunciones.IDCIUDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmpleadoConstantesFunciones.IDCENTROCOSTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmpleadoConstantesFunciones.IDRELIGION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmpleadoConstantesFunciones.IDESTADOCIVIL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmpleadoConstantesFunciones.IDTIPOGENERO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmpleadoConstantesFunciones.IDTIPOEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmpleadoConstantesFunciones.IDTIPOINSTRUCCION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmpleadoConstantesFunciones.IDCARGO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmpleadoConstantesFunciones.IDESTRUCTURA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmpleadoConstantesFunciones.IDESTRUCTURASECCION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmpleadoConstantesFunciones.IDESTADOEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmpleadoConstantesFunciones.IDTIPOCONTRATO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmpleadoConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EmpleadoConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EmpleadoConstantesFunciones.APELLIDO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EmpleadoConstantesFunciones.NOMBRECOMPLETO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EmpleadoConstantesFunciones.MAIL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EmpleadoConstantesFunciones.DIRECCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EmpleadoConstantesFunciones.SUELDO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case EmpleadoConstantesFunciones.TELEFONO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EmpleadoConstantesFunciones.IDTIPOCUENTABANCOGLOBAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmpleadoConstantesFunciones.NUMEROCUENTA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EmpleadoConstantesFunciones.TIENECASA:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case EmpleadoConstantesFunciones.TIENEVEHICULO:
					field.set(entity,resultSet.getBoolean(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Empleado>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<Empleado> entities = new  ArrayList<Empleado>();
		Empleado entity = new Empleado();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EmpleadoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new Empleado();
					entity=super.getEntity("",entity,resultSet,EmpleadoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityEmpleado("",entity,resultSet);
					
					//entity.setEmpleadoOriginal( new Empleado());
					//entity.setEmpleadoOriginal(super.getEntity("",entity.getEmpleadoOriginal(),resultSet,EmpleadoDataAccess.ISWITHSCHEMA));         		
					//entity.setEmpleadoOriginal(this.getEntityEmpleado("",entity.getEmpleadoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseEmpleados(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Empleado>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<Empleado> entities = new  ArrayList<Empleado>();
		Empleado entity = new Empleado();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EmpleadoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<Empleado> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Empleado> entities = new  ArrayList<Empleado>();
		Empleado entity = new Empleado();		  
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
	
	public  List<Empleado> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Empleado> entities = new  ArrayList<Empleado>();
		Empleado entity = new Empleado();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Empleado();
      	    	entity=super.getEntity("",entity,resultSet,EmpleadoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEmpleado("",entity,resultSet);
      	    	
				//entity.setEmpleadoOriginal( new Empleado());
      	    	//entity.setEmpleadoOriginal(super.getEntity("",entity.getEmpleadoOriginal(),resultSet,EmpleadoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmpleadoOriginal(this.getEntityEmpleado("",entity.getEmpleadoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseEmpleados(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Empleado> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Empleado> entities = new  ArrayList<Empleado>();
		Empleado entity = new Empleado();		  
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
	
	public  List<Empleado> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Empleado> entities = new  ArrayList<Empleado>();
		Empleado entity = new Empleado();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Empleado();
      	    	entity=super.getEntity("",entity,resultSet,EmpleadoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEmpleado("",entity,resultSet);
      	    	
				//entity.setEmpleadoOriginal( new Empleado());
      	    	//entity.setEmpleadoOriginal(super.getEntity("",entity.getEmpleadoOriginal(),resultSet,EmpleadoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmpleadoOriginal(this.getEntityEmpleado("",entity.getEmpleadoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEmpleados(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public Empleado getEntityEmpleado(String strPrefijo,Empleado entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+EmpleadoConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+EmpleadoConstantesFunciones.IDSUCURSAL));
				entity.setid_pais(resultSet.getLong(strPrefijo+EmpleadoConstantesFunciones.IDPAIS));
				entity.setid_provincia(resultSet.getLong(strPrefijo+EmpleadoConstantesFunciones.IDPROVINCIA));
				entity.setid_ciudad(resultSet.getLong(strPrefijo+EmpleadoConstantesFunciones.IDCIUDAD));
				entity.setid_centro_costo(resultSet.getLong(strPrefijo+EmpleadoConstantesFunciones.IDCENTROCOSTO));if(resultSet.wasNull()) {entity.setid_centro_costo(null); }
				entity.setid_religion(resultSet.getLong(strPrefijo+EmpleadoConstantesFunciones.IDRELIGION));
				entity.setid_estado_civil(resultSet.getLong(strPrefijo+EmpleadoConstantesFunciones.IDESTADOCIVIL));
				entity.setid_tipo_genero(resultSet.getLong(strPrefijo+EmpleadoConstantesFunciones.IDTIPOGENERO));
				entity.setid_tipo_empleado(resultSet.getLong(strPrefijo+EmpleadoConstantesFunciones.IDTIPOEMPLEADO));
				entity.setid_tipo_instruccion(resultSet.getLong(strPrefijo+EmpleadoConstantesFunciones.IDTIPOINSTRUCCION));
				entity.setid_cargo(resultSet.getLong(strPrefijo+EmpleadoConstantesFunciones.IDCARGO));
				entity.setid_estructura(resultSet.getLong(strPrefijo+EmpleadoConstantesFunciones.IDESTRUCTURA));
				entity.setid_estructura_seccion(resultSet.getLong(strPrefijo+EmpleadoConstantesFunciones.IDESTRUCTURASECCION));
				entity.setid_estado_empleado(resultSet.getLong(strPrefijo+EmpleadoConstantesFunciones.IDESTADOEMPLEADO));
				entity.setid_tipo_contrato(resultSet.getLong(strPrefijo+EmpleadoConstantesFunciones.IDTIPOCONTRATO));
				entity.setcodigo(resultSet.getString(strPrefijo+EmpleadoConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+EmpleadoConstantesFunciones.NOMBRE));
				entity.setapellido(resultSet.getString(strPrefijo+EmpleadoConstantesFunciones.APELLIDO));
				entity.setnombre_completo(resultSet.getString(strPrefijo+EmpleadoConstantesFunciones.NOMBRECOMPLETO));
				entity.setmail(resultSet.getString(strPrefijo+EmpleadoConstantesFunciones.MAIL));
				entity.setdireccion(resultSet.getString(strPrefijo+EmpleadoConstantesFunciones.DIRECCION));
				entity.setsueldo(resultSet.getDouble(strPrefijo+EmpleadoConstantesFunciones.SUELDO));
				entity.settelefono(resultSet.getString(strPrefijo+EmpleadoConstantesFunciones.TELEFONO));
				entity.setid_tipo_cuenta_banco_global(resultSet.getLong(strPrefijo+EmpleadoConstantesFunciones.IDTIPOCUENTABANCOGLOBAL));
				entity.setnumero_cuenta(resultSet.getString(strPrefijo+EmpleadoConstantesFunciones.NUMEROCUENTA));
				entity.settiene_casa(resultSet.getBoolean(strPrefijo+EmpleadoConstantesFunciones.TIENECASA));
				entity.settiene_vehiculo(resultSet.getBoolean(strPrefijo+EmpleadoConstantesFunciones.TIENEVEHICULO));
			} else {
				entity.setnombre_completo(resultSet.getString(strPrefijo+EmpleadoConstantesFunciones.NOMBRECOMPLETO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowEmpleado(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(Empleado entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=EmpleadoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=EmpleadoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=EmpleadoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=EmpleadoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(EmpleadoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,EmpleadoDataAccess.TABLENAME,EmpleadoDataAccess.ISWITHSTOREPROCEDURES);
			
			EmpleadoDataAccess.setEmpleadoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,Empleado relempleado)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relempleado.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,Empleado relempleado)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relempleado.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Pais getPais(Connexion connexion,Empleado relempleado)throws SQLException,Exception {

		Pais pais= new Pais();

		try {
			PaisDataAccess paisDataAccess=new PaisDataAccess();

			paisDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			paisDataAccess.setConnexionType(this.connexionType);
			paisDataAccess.setParameterDbType(this.parameterDbType);

			pais=paisDataAccess.getEntity(connexion,relempleado.getid_pais());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pais;

	}

	public Provincia getProvincia(Connexion connexion,Empleado relempleado)throws SQLException,Exception {

		Provincia provincia= new Provincia();

		try {
			ProvinciaDataAccess provinciaDataAccess=new ProvinciaDataAccess();

			provinciaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			provinciaDataAccess.setConnexionType(this.connexionType);
			provinciaDataAccess.setParameterDbType(this.parameterDbType);

			provincia=provinciaDataAccess.getEntity(connexion,relempleado.getid_provincia());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return provincia;

	}

	public Ciudad getCiudad(Connexion connexion,Empleado relempleado)throws SQLException,Exception {

		Ciudad ciudad= new Ciudad();

		try {
			CiudadDataAccess ciudadDataAccess=new CiudadDataAccess();

			ciudadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ciudadDataAccess.setConnexionType(this.connexionType);
			ciudadDataAccess.setParameterDbType(this.parameterDbType);

			ciudad=ciudadDataAccess.getEntity(connexion,relempleado.getid_ciudad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ciudad;

	}

	public CentroCosto getCentroCosto(Connexion connexion,Empleado relempleado)throws SQLException,Exception {

		CentroCosto centrocosto= new CentroCosto();

		try {
			CentroCostoDataAccess centrocostoDataAccess=new CentroCostoDataAccess();

			centrocostoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			centrocostoDataAccess.setConnexionType(this.connexionType);
			centrocostoDataAccess.setParameterDbType(this.parameterDbType);

			centrocosto=centrocostoDataAccess.getEntity(connexion,relempleado.getid_centro_costo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return centrocosto;

	}

	public Religion getReligion(Connexion connexion,Empleado relempleado)throws SQLException,Exception {

		Religion religion= new Religion();

		try {
			ReligionDataAccess religionDataAccess=new ReligionDataAccess();

			religionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			religionDataAccess.setConnexionType(this.connexionType);
			religionDataAccess.setParameterDbType(this.parameterDbType);

			religion=religionDataAccess.getEntity(connexion,relempleado.getid_religion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return religion;

	}

	public EstadoCivil getEstadoCivil(Connexion connexion,Empleado relempleado)throws SQLException,Exception {

		EstadoCivil estadocivil= new EstadoCivil();

		try {
			EstadoCivilDataAccess estadocivilDataAccess=new EstadoCivilDataAccess();

			estadocivilDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadocivilDataAccess.setConnexionType(this.connexionType);
			estadocivilDataAccess.setParameterDbType(this.parameterDbType);

			estadocivil=estadocivilDataAccess.getEntity(connexion,relempleado.getid_estado_civil());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadocivil;

	}

	public TipoGenero getTipoGenero(Connexion connexion,Empleado relempleado)throws SQLException,Exception {

		TipoGenero tipogenero= new TipoGenero();

		try {
			TipoGeneroDataAccess tipogeneroDataAccess=new TipoGeneroDataAccess();

			tipogeneroDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipogeneroDataAccess.setConnexionType(this.connexionType);
			tipogeneroDataAccess.setParameterDbType(this.parameterDbType);

			tipogenero=tipogeneroDataAccess.getEntity(connexion,relempleado.getid_tipo_genero());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipogenero;

	}

	public TipoEmpleado getTipoEmpleado(Connexion connexion,Empleado relempleado)throws SQLException,Exception {

		TipoEmpleado tipoempleado= new TipoEmpleado();

		try {
			TipoEmpleadoDataAccess tipoempleadoDataAccess=new TipoEmpleadoDataAccess();

			tipoempleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoempleadoDataAccess.setConnexionType(this.connexionType);
			tipoempleadoDataAccess.setParameterDbType(this.parameterDbType);

			tipoempleado=tipoempleadoDataAccess.getEntity(connexion,relempleado.getid_tipo_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoempleado;

	}

	public TipoInstruccion getTipoInstruccion(Connexion connexion,Empleado relempleado)throws SQLException,Exception {

		TipoInstruccion tipoinstruccion= new TipoInstruccion();

		try {
			TipoInstruccionDataAccess tipoinstruccionDataAccess=new TipoInstruccionDataAccess();

			tipoinstruccionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoinstruccionDataAccess.setConnexionType(this.connexionType);
			tipoinstruccionDataAccess.setParameterDbType(this.parameterDbType);

			tipoinstruccion=tipoinstruccionDataAccess.getEntity(connexion,relempleado.getid_tipo_instruccion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoinstruccion;

	}

	public Cargo getCargo(Connexion connexion,Empleado relempleado)throws SQLException,Exception {

		Cargo cargo= new Cargo();

		try {
			CargoDataAccess cargoDataAccess=new CargoDataAccess();

			cargoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cargoDataAccess.setConnexionType(this.connexionType);
			cargoDataAccess.setParameterDbType(this.parameterDbType);

			cargo=cargoDataAccess.getEntity(connexion,relempleado.getid_cargo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cargo;

	}

	public Estructura getEstructura(Connexion connexion,Empleado relempleado)throws SQLException,Exception {

		Estructura estructura= new Estructura();

		try {
			EstructuraDataAccess estructuraDataAccess=new EstructuraDataAccess();

			estructuraDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estructuraDataAccess.setConnexionType(this.connexionType);
			estructuraDataAccess.setParameterDbType(this.parameterDbType);

			estructura=estructuraDataAccess.getEntity(connexion,relempleado.getid_estructura());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estructura;

	}

	public Estructura getEstructuraSeccion(Connexion connexion,Empleado relempleado)throws SQLException,Exception {

		Estructura estructura= new Estructura();

		try {
			EstructuraDataAccess estructuraDataAccess=new EstructuraDataAccess();

			estructuraDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estructuraDataAccess.setConnexionType(this.connexionType);
			estructuraDataAccess.setParameterDbType(this.parameterDbType);

			estructura=estructuraDataAccess.getEntity(connexion,relempleado.getid_estructura_seccion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estructura;

	}

	public EstadoEmpleado getEstadoEmpleado(Connexion connexion,Empleado relempleado)throws SQLException,Exception {

		EstadoEmpleado estadoempleado= new EstadoEmpleado();

		try {
			EstadoEmpleadoDataAccess estadoempleadoDataAccess=new EstadoEmpleadoDataAccess();

			estadoempleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadoempleadoDataAccess.setConnexionType(this.connexionType);
			estadoempleadoDataAccess.setParameterDbType(this.parameterDbType);

			estadoempleado=estadoempleadoDataAccess.getEntity(connexion,relempleado.getid_estado_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadoempleado;

	}

	public TipoContrato getTipoContrato(Connexion connexion,Empleado relempleado)throws SQLException,Exception {

		TipoContrato tipocontrato= new TipoContrato();

		try {
			TipoContratoDataAccess tipocontratoDataAccess=new TipoContratoDataAccess();

			tipocontratoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipocontratoDataAccess.setConnexionType(this.connexionType);
			tipocontratoDataAccess.setParameterDbType(this.parameterDbType);

			tipocontrato=tipocontratoDataAccess.getEntity(connexion,relempleado.getid_tipo_contrato());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipocontrato;

	}

	public TipoCuentaBancoGlobal getTipoCuentaBancoGlobal(Connexion connexion,Empleado relempleado)throws SQLException,Exception {

		TipoCuentaBancoGlobal tipocuentabancoglobal= new TipoCuentaBancoGlobal();

		try {
			TipoCuentaBancoGlobalDataAccess tipocuentabancoglobalDataAccess=new TipoCuentaBancoGlobalDataAccess();

			tipocuentabancoglobalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipocuentabancoglobalDataAccess.setConnexionType(this.connexionType);
			tipocuentabancoglobalDataAccess.setParameterDbType(this.parameterDbType);

			tipocuentabancoglobal=tipocuentabancoglobalDataAccess.getEntity(connexion,relempleado.getid_tipo_cuenta_banco_global());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipocuentabancoglobal;

	}


		
		public List<CargaFamiliar_NM> getCargaFamiliar_NMs(Connexion connexion,Empleado empleado)throws SQLException,Exception {

		List<CargaFamiliar_NM> cargafamiliar_nms= new ArrayList<CargaFamiliar_NM>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EmpleadoConstantesFunciones.SCHEMA+".empleado ON "+CargaFamiliar_NMConstantesFunciones.SCHEMA+".carga_familiar__n_m.id_empleado="+EmpleadoConstantesFunciones.SCHEMA+".empleado.id WHERE "+EmpleadoConstantesFunciones.SCHEMA+".empleado.id="+String.valueOf(empleado.getId());
			} else {
				sQuery=" INNER JOIN cargafamiliar_nm.Empleado WHERE cargafamiliar_nm.Empleado.id="+String.valueOf(empleado.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			CargaFamiliar_NMDataAccess cargafamiliar_nmDataAccess=new CargaFamiliar_NMDataAccess();

			cargafamiliar_nmDataAccess.setConnexionType(this.connexionType);
			cargafamiliar_nmDataAccess.setParameterDbType(this.parameterDbType);
			cargafamiliar_nms=cargafamiliar_nmDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cargafamiliar_nms;

	}

	public List<Curso> getCursos(Connexion connexion,Empleado empleado)throws SQLException,Exception {

		List<Curso> cursos= new ArrayList<Curso>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EmpleadoConstantesFunciones.SCHEMA+".empleado ON "+CursoConstantesFunciones.SCHEMA+".curso.id_empleado="+EmpleadoConstantesFunciones.SCHEMA+".empleado.id WHERE "+EmpleadoConstantesFunciones.SCHEMA+".empleado.id="+String.valueOf(empleado.getId());
			} else {
				sQuery=" INNER JOIN curso.Empleado WHERE curso.Empleado.id="+String.valueOf(empleado.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			CursoDataAccess cursoDataAccess=new CursoDataAccess();

			cursoDataAccess.setConnexionType(this.connexionType);
			cursoDataAccess.setParameterDbType(this.parameterDbType);
			cursos=cursoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cursos;

	}

	public List<Prestamo> getPrestamos(Connexion connexion,Empleado empleado)throws SQLException,Exception {

		List<Prestamo> prestamos= new ArrayList<Prestamo>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EmpleadoConstantesFunciones.SCHEMA+".empleado ON "+PrestamoConstantesFunciones.SCHEMA+".prestamo.id_empleado="+EmpleadoConstantesFunciones.SCHEMA+".empleado.id WHERE "+EmpleadoConstantesFunciones.SCHEMA+".empleado.id="+String.valueOf(empleado.getId());
			} else {
				sQuery=" INNER JOIN prestamo.Empleado WHERE prestamo.Empleado.id="+String.valueOf(empleado.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PrestamoDataAccess prestamoDataAccess=new PrestamoDataAccess();

			prestamoDataAccess.setConnexionType(this.connexionType);
			prestamoDataAccess.setParameterDbType(this.parameterDbType);
			prestamos=prestamoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return prestamos;

	}

	public List<EmpleadoIdioma> getEmpleadoIdiomas(Connexion connexion,Empleado empleado)throws SQLException,Exception {

		List<EmpleadoIdioma> empleadoidiomas= new ArrayList<EmpleadoIdioma>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EmpleadoConstantesFunciones.SCHEMA+".empleado ON "+EmpleadoIdiomaConstantesFunciones.SCHEMA+".empleado_idioma.id_empleado="+EmpleadoConstantesFunciones.SCHEMA+".empleado.id WHERE "+EmpleadoConstantesFunciones.SCHEMA+".empleado.id="+String.valueOf(empleado.getId());
			} else {
				sQuery=" INNER JOIN empleadoidioma.Empleado WHERE empleadoidioma.Empleado.id="+String.valueOf(empleado.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			EmpleadoIdiomaDataAccess empleadoidiomaDataAccess=new EmpleadoIdiomaDataAccess();

			empleadoidiomaDataAccess.setConnexionType(this.connexionType);
			empleadoidiomaDataAccess.setParameterDbType(this.parameterDbType);
			empleadoidiomas=empleadoidiomaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleadoidiomas;

	}

	public List<HistorialPagoMesNomi> getHistorialPagoMesNomis(Connexion connexion,Empleado empleado)throws SQLException,Exception {

		List<HistorialPagoMesNomi> historialpagomesnomis= new ArrayList<HistorialPagoMesNomi>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EmpleadoConstantesFunciones.SCHEMA+".empleado ON "+HistorialPagoMesNomiConstantesFunciones.SCHEMA+".historial_pago_mes_nomi.id_empleado="+EmpleadoConstantesFunciones.SCHEMA+".empleado.id WHERE "+EmpleadoConstantesFunciones.SCHEMA+".empleado.id="+String.valueOf(empleado.getId());
			} else {
				sQuery=" INNER JOIN historialpagomesnomi.Empleado WHERE historialpagomesnomi.Empleado.id="+String.valueOf(empleado.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			HistorialPagoMesNomiDataAccess historialpagomesnomiDataAccess=new HistorialPagoMesNomiDataAccess();

			historialpagomesnomiDataAccess.setConnexionType(this.connexionType);
			historialpagomesnomiDataAccess.setParameterDbType(this.parameterDbType);
			historialpagomesnomis=historialpagomesnomiDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return historialpagomesnomis;

	}

	public List<EmpleadoImpuestoRenta> getEmpleadoImpuestoRentas(Connexion connexion,Empleado empleado)throws SQLException,Exception {

		List<EmpleadoImpuestoRenta> empleadoimpuestorentas= new ArrayList<EmpleadoImpuestoRenta>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EmpleadoConstantesFunciones.SCHEMA+".empleado ON "+EmpleadoImpuestoRentaConstantesFunciones.SCHEMA+".empleado_impuesto_renta.id_empleado="+EmpleadoConstantesFunciones.SCHEMA+".empleado.id WHERE "+EmpleadoConstantesFunciones.SCHEMA+".empleado.id="+String.valueOf(empleado.getId());
			} else {
				sQuery=" INNER JOIN empleadoimpuestorenta.Empleado WHERE empleadoimpuestorenta.Empleado.id="+String.valueOf(empleado.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			EmpleadoImpuestoRentaDataAccess empleadoimpuestorentaDataAccess=new EmpleadoImpuestoRentaDataAccess();

			empleadoimpuestorentaDataAccess.setConnexionType(this.connexionType);
			empleadoimpuestorentaDataAccess.setParameterDbType(this.parameterDbType);
			empleadoimpuestorentas=empleadoimpuestorentaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleadoimpuestorentas;

	}

	public DatoGeneralEmpleado getDatoGeneralEmpleado(Connexion connexion,Empleado empleado)throws SQLException,Exception {

		DatoGeneralEmpleado datogeneralempleado= new DatoGeneralEmpleado();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EmpleadoConstantesFunciones.SCHEMA+".empleado ON "+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+".dato_general_empleado.id="+EmpleadoConstantesFunciones.SCHEMA+".empleado.id WHERE "+EmpleadoConstantesFunciones.SCHEMA+".empleado.id="+String.valueOf(empleado.getId());
			} else {
				sQuery=" INNER JOIN datogeneralempleado.Empleado WHERE datogeneralempleado.Empleado.id="+String.valueOf(empleado.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DatoGeneralEmpleadoDataAccess datogeneralempleadoDataAccess=new DatoGeneralEmpleadoDataAccess();

			datogeneralempleadoDataAccess.setConnexionType(this.connexionType);
			datogeneralempleadoDataAccess.setParameterDbType(this.parameterDbType);
			datogeneralempleado=datogeneralempleadoDataAccess.getEntity(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return datogeneralempleado;

	}

	public List<Area> getAreas(Connexion connexion,Empleado empleado)throws SQLException,Exception {

		List<Area> areas= new ArrayList<Area>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EmpleadoConstantesFunciones.SCHEMA+".empleado ON "+AreaConstantesFunciones.SCHEMA+".area.id_empleado="+EmpleadoConstantesFunciones.SCHEMA+".empleado.id WHERE "+EmpleadoConstantesFunciones.SCHEMA+".empleado.id="+String.valueOf(empleado.getId());
			} else {
				sQuery=" INNER JOIN area.Empleado WHERE area.Empleado.id="+String.valueOf(empleado.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			AreaDataAccess areaDataAccess=new AreaDataAccess();

			areaDataAccess.setConnexionType(this.connexionType);
			areaDataAccess.setParameterDbType(this.parameterDbType);
			areas=areaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return areas;

	}

	public List<GastoEmpleado> getGastoEmpleados(Connexion connexion,Empleado empleado)throws SQLException,Exception {

		List<GastoEmpleado> gastoempleados= new ArrayList<GastoEmpleado>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EmpleadoConstantesFunciones.SCHEMA+".empleado ON "+GastoEmpleadoConstantesFunciones.SCHEMA+".gasto_empleado.id_empleado="+EmpleadoConstantesFunciones.SCHEMA+".empleado.id WHERE "+EmpleadoConstantesFunciones.SCHEMA+".empleado.id="+String.valueOf(empleado.getId());
			} else {
				sQuery=" INNER JOIN gastoempleado.Empleado WHERE gastoempleado.Empleado.id="+String.valueOf(empleado.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			GastoEmpleadoDataAccess gastoempleadoDataAccess=new GastoEmpleadoDataAccess();

			gastoempleadoDataAccess.setConnexionType(this.connexionType);
			gastoempleadoDataAccess.setParameterDbType(this.parameterDbType);
			gastoempleados=gastoempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return gastoempleados;

	}

	public List<EmpleadoHobby> getEmpleadoHobbys(Connexion connexion,Empleado empleado)throws SQLException,Exception {

		List<EmpleadoHobby> empleadohobbys= new ArrayList<EmpleadoHobby>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EmpleadoConstantesFunciones.SCHEMA+".empleado ON "+EmpleadoHobbyConstantesFunciones.SCHEMA+".empleado_hobby.id_empleado="+EmpleadoConstantesFunciones.SCHEMA+".empleado.id WHERE "+EmpleadoConstantesFunciones.SCHEMA+".empleado.id="+String.valueOf(empleado.getId());
			} else {
				sQuery=" INNER JOIN empleadohobby.Empleado WHERE empleadohobby.Empleado.id="+String.valueOf(empleado.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			EmpleadoHobbyDataAccess empleadohobbyDataAccess=new EmpleadoHobbyDataAccess();

			empleadohobbyDataAccess.setConnexionType(this.connexionType);
			empleadohobbyDataAccess.setParameterDbType(this.parameterDbType);
			empleadohobbys=empleadohobbyDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleadohobbys;

	}

	public List<EmpleadoEMail> getEmpleadoEMails(Connexion connexion,Empleado empleado)throws SQLException,Exception {

		List<EmpleadoEMail> empleadoemails= new ArrayList<EmpleadoEMail>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EmpleadoConstantesFunciones.SCHEMA+".empleado ON "+EmpleadoEMailConstantesFunciones.SCHEMA+".empleado_e_mail.id_empleado="+EmpleadoConstantesFunciones.SCHEMA+".empleado.id WHERE "+EmpleadoConstantesFunciones.SCHEMA+".empleado.id="+String.valueOf(empleado.getId());
			} else {
				sQuery=" INNER JOIN empleadoemail.Empleado WHERE empleadoemail.Empleado.id="+String.valueOf(empleado.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			EmpleadoEMailDataAccess empleadoemailDataAccess=new EmpleadoEMailDataAccess();

			empleadoemailDataAccess.setConnexionType(this.connexionType);
			empleadoemailDataAccess.setParameterDbType(this.parameterDbType);
			empleadoemails=empleadoemailDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleadoemails;

	}

	public List<RasgoPersonal> getRasgoPersonals(Connexion connexion,Empleado empleado)throws SQLException,Exception {

		List<RasgoPersonal> rasgopersonals= new ArrayList<RasgoPersonal>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EmpleadoConstantesFunciones.SCHEMA+".empleado ON "+RasgoPersonalConstantesFunciones.SCHEMA+".rasgo_personal.id_empleado="+EmpleadoConstantesFunciones.SCHEMA+".empleado.id WHERE "+EmpleadoConstantesFunciones.SCHEMA+".empleado.id="+String.valueOf(empleado.getId());
			} else {
				sQuery=" INNER JOIN rasgopersonal.Empleado WHERE rasgopersonal.Empleado.id="+String.valueOf(empleado.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			RasgoPersonalDataAccess rasgopersonalDataAccess=new RasgoPersonalDataAccess();

			rasgopersonalDataAccess.setConnexionType(this.connexionType);
			rasgopersonalDataAccess.setParameterDbType(this.parameterDbType);
			rasgopersonals=rasgopersonalDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return rasgopersonals;

	}

	public List<Referencia> getReferencias(Connexion connexion,Empleado empleado)throws SQLException,Exception {

		List<Referencia> referencias= new ArrayList<Referencia>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EmpleadoConstantesFunciones.SCHEMA+".empleado ON "+ReferenciaConstantesFunciones.SCHEMA+".referencia.id_empleado="+EmpleadoConstantesFunciones.SCHEMA+".empleado.id WHERE "+EmpleadoConstantesFunciones.SCHEMA+".empleado.id="+String.valueOf(empleado.getId());
			} else {
				sQuery=" INNER JOIN referencia.Empleado WHERE referencia.Empleado.id="+String.valueOf(empleado.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ReferenciaDataAccess referenciaDataAccess=new ReferenciaDataAccess();

			referenciaDataAccess.setConnexionType(this.connexionType);
			referenciaDataAccess.setParameterDbType(this.parameterDbType);
			referencias=referenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return referencias;

	}

	public List<Telefono_NM> getTelefono_NMs(Connexion connexion,Empleado empleado)throws SQLException,Exception {

		List<Telefono_NM> telefono_nms= new ArrayList<Telefono_NM>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EmpleadoConstantesFunciones.SCHEMA+".empleado ON "+Telefono_NMConstantesFunciones.SCHEMA+".telefono__n_m.id_empleado="+EmpleadoConstantesFunciones.SCHEMA+".empleado.id WHERE "+EmpleadoConstantesFunciones.SCHEMA+".empleado.id="+String.valueOf(empleado.getId());
			} else {
				sQuery=" INNER JOIN telefono_nm.Empleado WHERE telefono_nm.Empleado.id="+String.valueOf(empleado.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			Telefono_NMDataAccess telefono_nmDataAccess=new Telefono_NMDataAccess();

			telefono_nmDataAccess.setConnexionType(this.connexionType);
			telefono_nmDataAccess.setParameterDbType(this.parameterDbType);
			telefono_nms=telefono_nmDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return telefono_nms;

	}

	public List<Novedad> getNovedads(Connexion connexion,Empleado empleado)throws SQLException,Exception {

		List<Novedad> novedads= new ArrayList<Novedad>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EmpleadoConstantesFunciones.SCHEMA+".empleado ON "+NovedadConstantesFunciones.SCHEMA+".novedad.id_empleado="+EmpleadoConstantesFunciones.SCHEMA+".empleado.id WHERE "+EmpleadoConstantesFunciones.SCHEMA+".empleado.id="+String.valueOf(empleado.getId());
			} else {
				sQuery=" INNER JOIN novedad.Empleado WHERE novedad.Empleado.id="+String.valueOf(empleado.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			NovedadDataAccess novedadDataAccess=new NovedadDataAccess();

			novedadDataAccess.setConnexionType(this.connexionType);
			novedadDataAccess.setParameterDbType(this.parameterDbType);
			novedads=novedadDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return novedads;

	}

	public List<EmpleadoHerra> getEmpleadoHerras(Connexion connexion,Empleado empleado)throws SQLException,Exception {

		List<EmpleadoHerra> empleadoherras= new ArrayList<EmpleadoHerra>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EmpleadoConstantesFunciones.SCHEMA+".empleado ON "+EmpleadoHerraConstantesFunciones.SCHEMA+".empleado_herra.id_empleado="+EmpleadoConstantesFunciones.SCHEMA+".empleado.id WHERE "+EmpleadoConstantesFunciones.SCHEMA+".empleado.id="+String.valueOf(empleado.getId());
			} else {
				sQuery=" INNER JOIN empleadoherra.Empleado WHERE empleadoherra.Empleado.id="+String.valueOf(empleado.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			EmpleadoHerraDataAccess empleadoherraDataAccess=new EmpleadoHerraDataAccess();

			empleadoherraDataAccess.setConnexionType(this.connexionType);
			empleadoherraDataAccess.setParameterDbType(this.parameterDbType);
			empleadoherras=empleadoherraDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleadoherras;

	}

	public List<EmpleadoEnfer> getEmpleadoEnfers(Connexion connexion,Empleado empleado)throws SQLException,Exception {

		List<EmpleadoEnfer> empleadoenfers= new ArrayList<EmpleadoEnfer>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EmpleadoConstantesFunciones.SCHEMA+".empleado ON "+EmpleadoEnferConstantesFunciones.SCHEMA+".empleado_enfer.id_empleado="+EmpleadoConstantesFunciones.SCHEMA+".empleado.id WHERE "+EmpleadoConstantesFunciones.SCHEMA+".empleado.id="+String.valueOf(empleado.getId());
			} else {
				sQuery=" INNER JOIN empleadoenfer.Empleado WHERE empleadoenfer.Empleado.id="+String.valueOf(empleado.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			EmpleadoEnferDataAccess empleadoenferDataAccess=new EmpleadoEnferDataAccess();

			empleadoenferDataAccess.setConnexionType(this.connexionType);
			empleadoenferDataAccess.setParameterDbType(this.parameterDbType);
			empleadoenfers=empleadoenferDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleadoenfers;

	}

	public List<Visa> getVisas(Connexion connexion,Empleado empleado)throws SQLException,Exception {

		List<Visa> visas= new ArrayList<Visa>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EmpleadoConstantesFunciones.SCHEMA+".empleado ON "+VisaConstantesFunciones.SCHEMA+".visa.id_empleado="+EmpleadoConstantesFunciones.SCHEMA+".empleado.id WHERE "+EmpleadoConstantesFunciones.SCHEMA+".empleado.id="+String.valueOf(empleado.getId());
			} else {
				sQuery=" INNER JOIN visa.Empleado WHERE visa.Empleado.id="+String.valueOf(empleado.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			VisaDataAccess visaDataAccess=new VisaDataAccess();

			visaDataAccess.setConnexionType(this.connexionType);
			visaDataAccess.setParameterDbType(this.parameterDbType);
			visas=visaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return visas;

	}

	public List<Seguro> getSeguros(Connexion connexion,Empleado empleado)throws SQLException,Exception {

		List<Seguro> seguros= new ArrayList<Seguro>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EmpleadoConstantesFunciones.SCHEMA+".empleado ON "+SeguroConstantesFunciones.SCHEMA+".seguro.id_empleado="+EmpleadoConstantesFunciones.SCHEMA+".empleado.id WHERE "+EmpleadoConstantesFunciones.SCHEMA+".empleado.id="+String.valueOf(empleado.getId());
			} else {
				sQuery=" INNER JOIN seguro.Empleado WHERE seguro.Empleado.id="+String.valueOf(empleado.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			SeguroDataAccess seguroDataAccess=new SeguroDataAccess();

			seguroDataAccess.setConnexionType(this.connexionType);
			seguroDataAccess.setParameterDbType(this.parameterDbType);
			seguros=seguroDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return seguros;

	}

	public List<AsistenciaMensual> getAsistenciaMensuals(Connexion connexion,Empleado empleado)throws SQLException,Exception {

		List<AsistenciaMensual> asistenciamensuals= new ArrayList<AsistenciaMensual>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EmpleadoConstantesFunciones.SCHEMA+".empleado ON "+AsistenciaMensualConstantesFunciones.SCHEMA+".asistencia_mensual.id_empleado="+EmpleadoConstantesFunciones.SCHEMA+".empleado.id WHERE "+EmpleadoConstantesFunciones.SCHEMA+".empleado.id="+String.valueOf(empleado.getId());
			} else {
				sQuery=" INNER JOIN asistenciamensual.Empleado WHERE asistenciamensual.Empleado.id="+String.valueOf(empleado.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			AsistenciaMensualDataAccess asistenciamensualDataAccess=new AsistenciaMensualDataAccess();

			asistenciamensualDataAccess.setConnexionType(this.connexionType);
			asistenciamensualDataAccess.setParameterDbType(this.parameterDbType);
			asistenciamensuals=asistenciamensualDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return asistenciamensuals;

	}

	public List<EmpleadoDisca> getEmpleadoDiscas(Connexion connexion,Empleado empleado)throws SQLException,Exception {

		List<EmpleadoDisca> empleadodiscas= new ArrayList<EmpleadoDisca>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EmpleadoConstantesFunciones.SCHEMA+".empleado ON "+EmpleadoDiscaConstantesFunciones.SCHEMA+".empleado_disca.id_empleado="+EmpleadoConstantesFunciones.SCHEMA+".empleado.id WHERE "+EmpleadoConstantesFunciones.SCHEMA+".empleado.id="+String.valueOf(empleado.getId());
			} else {
				sQuery=" INNER JOIN empleadodisca.Empleado WHERE empleadodisca.Empleado.id="+String.valueOf(empleado.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			EmpleadoDiscaDataAccess empleadodiscaDataAccess=new EmpleadoDiscaDataAccess();

			empleadodiscaDataAccess.setConnexionType(this.connexionType);
			empleadodiscaDataAccess.setParameterDbType(this.parameterDbType);
			empleadodiscas=empleadodiscaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleadodiscas;

	}

	public List<ProfesionEmplea> getProfesionEmpleas(Connexion connexion,Empleado empleado)throws SQLException,Exception {

		List<ProfesionEmplea> profesionempleas= new ArrayList<ProfesionEmplea>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EmpleadoConstantesFunciones.SCHEMA+".empleado ON "+ProfesionEmpleaConstantesFunciones.SCHEMA+".profesion_emplea.id_empleado="+EmpleadoConstantesFunciones.SCHEMA+".empleado.id WHERE "+EmpleadoConstantesFunciones.SCHEMA+".empleado.id="+String.valueOf(empleado.getId());
			} else {
				sQuery=" INNER JOIN profesionemplea.Empleado WHERE profesionemplea.Empleado.id="+String.valueOf(empleado.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ProfesionEmpleaDataAccess profesionempleaDataAccess=new ProfesionEmpleaDataAccess();

			profesionempleaDataAccess.setConnexionType(this.connexionType);
			profesionempleaDataAccess.setParameterDbType(this.parameterDbType);
			profesionempleas=profesionempleaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return profesionempleas;

	}

	public List<RubroEmpleado> getRubroEmpleados(Connexion connexion,Empleado empleado)throws SQLException,Exception {

		List<RubroEmpleado> rubroempleados= new ArrayList<RubroEmpleado>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EmpleadoConstantesFunciones.SCHEMA+".empleado ON "+RubroEmpleadoConstantesFunciones.SCHEMA+".rubro_empleado.id_empleado="+EmpleadoConstantesFunciones.SCHEMA+".empleado.id WHERE "+EmpleadoConstantesFunciones.SCHEMA+".empleado.id="+String.valueOf(empleado.getId());
			} else {
				sQuery=" INNER JOIN rubroempleado.Empleado WHERE rubroempleado.Empleado.id="+String.valueOf(empleado.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			RubroEmpleadoDataAccess rubroempleadoDataAccess=new RubroEmpleadoDataAccess();

			rubroempleadoDataAccess.setConnexionType(this.connexionType);
			rubroempleadoDataAccess.setParameterDbType(this.parameterDbType);
			rubroempleados=rubroempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return rubroempleados;

	}

	public List<EmpleadoConstante> getEmpleadoConstantes(Connexion connexion,Empleado empleado)throws SQLException,Exception {

		List<EmpleadoConstante> empleadoconstantes= new ArrayList<EmpleadoConstante>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EmpleadoConstantesFunciones.SCHEMA+".empleado ON "+EmpleadoConstanteConstantesFunciones.SCHEMA+".empleado_constante.id_empleado="+EmpleadoConstantesFunciones.SCHEMA+".empleado.id WHERE "+EmpleadoConstantesFunciones.SCHEMA+".empleado.id="+String.valueOf(empleado.getId());
			} else {
				sQuery=" INNER JOIN empleadoconstante.Empleado WHERE empleadoconstante.Empleado.id="+String.valueOf(empleado.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			EmpleadoConstanteDataAccess empleadoconstanteDataAccess=new EmpleadoConstanteDataAccess();

			empleadoconstanteDataAccess.setConnexionType(this.connexionType);
			empleadoconstanteDataAccess.setParameterDbType(this.parameterDbType);
			empleadoconstantes=empleadoconstanteDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleadoconstantes;

	}

	public List<TallaVestido> getTallaVestidos(Connexion connexion,Empleado empleado)throws SQLException,Exception {

		List<TallaVestido> tallavestidos= new ArrayList<TallaVestido>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EmpleadoConstantesFunciones.SCHEMA+".empleado ON "+TallaVestidoConstantesFunciones.SCHEMA+".talla_vestido.id_empleado="+EmpleadoConstantesFunciones.SCHEMA+".empleado.id WHERE "+EmpleadoConstantesFunciones.SCHEMA+".empleado.id="+String.valueOf(empleado.getId());
			} else {
				sQuery=" INNER JOIN tallavestido.Empleado WHERE tallavestido.Empleado.id="+String.valueOf(empleado.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			TallaVestidoDataAccess tallavestidoDataAccess=new TallaVestidoDataAccess();

			tallavestidoDataAccess.setConnexionType(this.connexionType);
			tallavestidoDataAccess.setParameterDbType(this.parameterDbType);
			tallavestidos=tallavestidoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tallavestidos;

	}

	public List<NovedadNomi> getNovedadNomis(Connexion connexion,Empleado empleado)throws SQLException,Exception {

		List<NovedadNomi> novedadnomis= new ArrayList<NovedadNomi>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EmpleadoConstantesFunciones.SCHEMA+".empleado ON "+NovedadNomiConstantesFunciones.SCHEMA+".novedad_nomi.id_empleado="+EmpleadoConstantesFunciones.SCHEMA+".empleado.id WHERE "+EmpleadoConstantesFunciones.SCHEMA+".empleado.id="+String.valueOf(empleado.getId());
			} else {
				sQuery=" INNER JOIN novedadnomi.Empleado WHERE novedadnomi.Empleado.id="+String.valueOf(empleado.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			NovedadNomiDataAccess novedadnomiDataAccess=new NovedadNomiDataAccess();

			novedadnomiDataAccess.setConnexionType(this.connexionType);
			novedadnomiDataAccess.setParameterDbType(this.parameterDbType);
			novedadnomis=novedadnomiDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return novedadnomis;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,Empleado empleado) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!empleado.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(empleado.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(empleado.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_pais=new ParameterValue<Long>();
					parameterMaintenanceValueid_pais.setValue(empleado.getid_pais());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_pais);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_provincia=new ParameterValue<Long>();
					parameterMaintenanceValueid_provincia.setValue(empleado.getid_provincia());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_provincia);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ciudad=new ParameterValue<Long>();
					parameterMaintenanceValueid_ciudad.setValue(empleado.getid_ciudad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ciudad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_centro_costo=new ParameterValue<Long>();
					parameterMaintenanceValueid_centro_costo.setValue(empleado.getid_centro_costo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_centro_costo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_religion=new ParameterValue<Long>();
					parameterMaintenanceValueid_religion.setValue(empleado.getid_religion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_religion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_civil=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_civil.setValue(empleado.getid_estado_civil());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_civil);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_genero=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_genero.setValue(empleado.getid_tipo_genero());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_genero);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_empleado.setValue(empleado.getid_tipo_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_instruccion=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_instruccion.setValue(empleado.getid_tipo_instruccion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_instruccion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cargo=new ParameterValue<Long>();
					parameterMaintenanceValueid_cargo.setValue(empleado.getid_cargo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cargo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estructura=new ParameterValue<Long>();
					parameterMaintenanceValueid_estructura.setValue(empleado.getid_estructura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estructura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estructura_seccion=new ParameterValue<Long>();
					parameterMaintenanceValueid_estructura_seccion.setValue(empleado.getid_estructura_seccion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estructura_seccion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_empleado.setValue(empleado.getid_estado_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_contrato=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_contrato.setValue(empleado.getid_tipo_contrato());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_contrato);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(empleado.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(empleado.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueapellido=new ParameterValue<String>();
					parameterMaintenanceValueapellido.setValue(empleado.getapellido());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueapellido);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre_completo=new ParameterValue<String>();
					parameterMaintenanceValuenombre_completo.setValue(empleado.getnombre_completo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre_completo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuemail=new ParameterValue<String>();
					parameterMaintenanceValuemail.setValue(empleado.getmail());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuemail);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedireccion=new ParameterValue<String>();
					parameterMaintenanceValuedireccion.setValue(empleado.getdireccion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedireccion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuesueldo=new ParameterValue<Double>();
					parameterMaintenanceValuesueldo.setValue(empleado.getsueldo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesueldo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuetelefono=new ParameterValue<String>();
					parameterMaintenanceValuetelefono.setValue(empleado.gettelefono());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetelefono);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_cuenta_banco_global=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_cuenta_banco_global.setValue(empleado.getid_tipo_cuenta_banco_global());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_cuenta_banco_global);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_cuenta=new ParameterValue<String>();
					parameterMaintenanceValuenumero_cuenta.setValue(empleado.getnumero_cuenta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_cuenta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuetiene_casa=new ParameterValue<Boolean>();
					parameterMaintenanceValuetiene_casa.setValue(empleado.gettiene_casa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetiene_casa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuetiene_vehiculo=new ParameterValue<Boolean>();
					parameterMaintenanceValuetiene_vehiculo.setValue(empleado.gettiene_vehiculo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetiene_vehiculo);
					parametersTemp.add(parameterMaintenance);
					
						if(!empleado.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(empleado.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(empleado.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(empleado.getId());
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
	
	public void setIsNewIsChangedFalseEmpleado(Empleado empleado)throws Exception  {		
		empleado.setIsNew(false);
		empleado.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseEmpleados(List<Empleado> empleados)throws Exception  {				
		for(Empleado empleado:empleados) {
			empleado.setIsNew(false);
			empleado.setIsChanged(false);
		}
	}
	
	public void generarExportarEmpleado(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
