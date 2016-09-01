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
import com.bydan.erp.nomina.util.*;//EmpleadoPagoRubroConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class EmpleadoPagoRubroDataAccess extends  EmpleadoPagoRubroDataAccessAdditional{ //EmpleadoPagoRubroDataAccessAdditional,DataAccessHelper<EmpleadoPagoRubro>
	//static Logger logger = Logger.getLogger(EmpleadoPagoRubroDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="empleado_pago_rubro";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+EmpleadoPagoRubroConstantesFunciones.SCHEMA+"."+EmpleadoPagoRubroConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_empleado,id_estructura,id_rubro_emplea,id_anio,id_mes,valor_pago,fecha,fecha_liquidacion)values(current_timestamp,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+EmpleadoPagoRubroConstantesFunciones.SCHEMA+"."+EmpleadoPagoRubroConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_empleado=?,id_estructura=?,id_rubro_emplea=?,id_anio=?,id_mes=?,valor_pago=?,fecha=?,fecha_liquidacion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+EmpleadoPagoRubroConstantesFunciones.SCHEMA+"."+EmpleadoPagoRubroConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select empleadopagorubro from "+EmpleadoPagoRubroConstantesFunciones.SPERSISTENCENAME+" empleadopagorubro";
	public static String QUERYSELECTNATIVE="select "+EmpleadoPagoRubroConstantesFunciones.SCHEMA+"."+EmpleadoPagoRubroConstantesFunciones.TABLENAME+".id,"+EmpleadoPagoRubroConstantesFunciones.SCHEMA+"."+EmpleadoPagoRubroConstantesFunciones.TABLENAME+".version_row,"+EmpleadoPagoRubroConstantesFunciones.SCHEMA+"."+EmpleadoPagoRubroConstantesFunciones.TABLENAME+".id_empresa,"+EmpleadoPagoRubroConstantesFunciones.SCHEMA+"."+EmpleadoPagoRubroConstantesFunciones.TABLENAME+".id_empleado,"+EmpleadoPagoRubroConstantesFunciones.SCHEMA+"."+EmpleadoPagoRubroConstantesFunciones.TABLENAME+".id_estructura,"+EmpleadoPagoRubroConstantesFunciones.SCHEMA+"."+EmpleadoPagoRubroConstantesFunciones.TABLENAME+".id_rubro_emplea,"+EmpleadoPagoRubroConstantesFunciones.SCHEMA+"."+EmpleadoPagoRubroConstantesFunciones.TABLENAME+".id_anio,"+EmpleadoPagoRubroConstantesFunciones.SCHEMA+"."+EmpleadoPagoRubroConstantesFunciones.TABLENAME+".id_mes,"+EmpleadoPagoRubroConstantesFunciones.SCHEMA+"."+EmpleadoPagoRubroConstantesFunciones.TABLENAME+".valor_pago,"+EmpleadoPagoRubroConstantesFunciones.SCHEMA+"."+EmpleadoPagoRubroConstantesFunciones.TABLENAME+".fecha,"+EmpleadoPagoRubroConstantesFunciones.SCHEMA+"."+EmpleadoPagoRubroConstantesFunciones.TABLENAME+".fecha_liquidacion from "+EmpleadoPagoRubroConstantesFunciones.SCHEMA+"."+EmpleadoPagoRubroConstantesFunciones.TABLENAME;//+" as "+EmpleadoPagoRubroConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+EmpleadoPagoRubroConstantesFunciones.SCHEMA+"."+EmpleadoPagoRubroConstantesFunciones.TABLENAME+".id,"+EmpleadoPagoRubroConstantesFunciones.SCHEMA+"."+EmpleadoPagoRubroConstantesFunciones.TABLENAME+".version_row from "+EmpleadoPagoRubroConstantesFunciones.SCHEMA+"."+EmpleadoPagoRubroConstantesFunciones.TABLENAME;//+" as "+EmpleadoPagoRubroConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+EmpleadoPagoRubroConstantesFunciones.SCHEMA+"."+EmpleadoPagoRubroConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_empleado=?,id_estructura=?,id_rubro_emplea=?,id_anio=?,id_mes=?,valor_pago=?,fecha=?,fecha_liquidacion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_EMPLEADOPAGORUBRO_INSERT(?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_EMPLEADOPAGORUBRO_UPDATE(?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_EMPLEADOPAGORUBRO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_EMPLEADOPAGORUBRO_SELECT(?,?)";
	
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
	
	
	protected EmpleadoPagoRubroDataAccessAdditional empleadopagorubroDataAccessAdditional=null;
	
	public EmpleadoPagoRubroDataAccessAdditional getEmpleadoPagoRubroDataAccessAdditional() {
		return this.empleadopagorubroDataAccessAdditional;
	}
	
	public void setEmpleadoPagoRubroDataAccessAdditional(EmpleadoPagoRubroDataAccessAdditional empleadopagorubroDataAccessAdditional) {
		try {
			this.empleadopagorubroDataAccessAdditional=empleadopagorubroDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public EmpleadoPagoRubroDataAccess() {
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
		EmpleadoPagoRubroDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		EmpleadoPagoRubroDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		EmpleadoPagoRubroDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setEmpleadoPagoRubroOriginal(EmpleadoPagoRubro empleadopagorubro)throws Exception  {
		empleadopagorubro.setEmpleadoPagoRubroOriginal((EmpleadoPagoRubro)empleadopagorubro.clone());		
	}
	
	public void setEmpleadoPagoRubrosOriginal(List<EmpleadoPagoRubro> empleadopagorubros)throws Exception  {
		
		for(EmpleadoPagoRubro empleadopagorubro:empleadopagorubros){
			empleadopagorubro.setEmpleadoPagoRubroOriginal((EmpleadoPagoRubro)empleadopagorubro.clone());
		}
	}
	
	public static void setEmpleadoPagoRubroOriginalStatic(EmpleadoPagoRubro empleadopagorubro)throws Exception  {
		empleadopagorubro.setEmpleadoPagoRubroOriginal((EmpleadoPagoRubro)empleadopagorubro.clone());		
	}
	
	public static void setEmpleadoPagoRubrosOriginalStatic(List<EmpleadoPagoRubro> empleadopagorubros)throws Exception  {
		
		for(EmpleadoPagoRubro empleadopagorubro:empleadopagorubros){
			empleadopagorubro.setEmpleadoPagoRubroOriginal((EmpleadoPagoRubro)empleadopagorubro.clone());
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
	
	public  EmpleadoPagoRubro getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		EmpleadoPagoRubro entity = new EmpleadoPagoRubro();		
		
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
	
	public  EmpleadoPagoRubro getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		EmpleadoPagoRubro entity = new EmpleadoPagoRubro();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EmpleadoPagoRubroDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EmpleadoPagoRubroDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.EmpleadoPagoRubro.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setEmpleadoPagoRubroOriginal(new EmpleadoPagoRubro());
      	    	entity=super.getEntity("",entity,resultSet,EmpleadoPagoRubroDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEmpleadoPagoRubro("",entity,resultSet); 
				
				//entity.setEmpleadoPagoRubroOriginal(super.getEntity("",entity.getEmpleadoPagoRubroOriginal(),resultSet,EmpleadoPagoRubroDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmpleadoPagoRubroOriginal(this.getEntityEmpleadoPagoRubro("",entity.getEmpleadoPagoRubroOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseEmpleadoPagoRubro(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  EmpleadoPagoRubro getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EmpleadoPagoRubro entity = new EmpleadoPagoRubro();
				
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
	
	public  EmpleadoPagoRubro getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EmpleadoPagoRubro entity = new EmpleadoPagoRubro();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EmpleadoPagoRubroDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EmpleadoPagoRubroDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmpleadoPagoRubroDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.EmpleadoPagoRubro.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setEmpleadoPagoRubroOriginal(new EmpleadoPagoRubro());
      	    	entity=super.getEntity("",entity,resultSet,EmpleadoPagoRubroDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEmpleadoPagoRubro("",entity,resultSet);    
				
				//entity.setEmpleadoPagoRubroOriginal(super.getEntity("",entity.getEmpleadoPagoRubroOriginal(),resultSet,EmpleadoPagoRubroDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmpleadoPagoRubroOriginal(this.getEntityEmpleadoPagoRubro("",entity.getEmpleadoPagoRubroOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseEmpleadoPagoRubro(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //EmpleadoPagoRubro
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		EmpleadoPagoRubro entity = new EmpleadoPagoRubro();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EmpleadoPagoRubroDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EmpleadoPagoRubroDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmpleadoPagoRubroDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.EmpleadoPagoRubro.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseEmpleadoPagoRubro(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<EmpleadoPagoRubro> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EmpleadoPagoRubro> entities = new  ArrayList<EmpleadoPagoRubro>();
		EmpleadoPagoRubro entity = new EmpleadoPagoRubro();		  
		
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
	
	public  List<EmpleadoPagoRubro> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EmpleadoPagoRubro> entities = new  ArrayList<EmpleadoPagoRubro>();
		EmpleadoPagoRubro entity = new EmpleadoPagoRubro();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=EmpleadoPagoRubroDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EmpleadoPagoRubroDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmpleadoPagoRubroDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EmpleadoPagoRubro();
      	    	entity=super.getEntity("",entity,resultSet,EmpleadoPagoRubroDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEmpleadoPagoRubro("",entity,resultSet);
      	    	
				//entity.setEmpleadoPagoRubroOriginal( new EmpleadoPagoRubro());
      	    	//entity.setEmpleadoPagoRubroOriginal(super.getEntity("",entity.getEmpleadoPagoRubroOriginal(),resultSet,EmpleadoPagoRubroDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmpleadoPagoRubroOriginal(this.getEntityEmpleadoPagoRubro("",entity.getEmpleadoPagoRubroOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEmpleadoPagoRubros(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmpleadoPagoRubro(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<EmpleadoPagoRubro> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EmpleadoPagoRubro> entities = new  ArrayList<EmpleadoPagoRubro>();
		EmpleadoPagoRubro entity = new EmpleadoPagoRubro();		  
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
	
	public  List<EmpleadoPagoRubro> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EmpleadoPagoRubro> entities = new  ArrayList<EmpleadoPagoRubro>();
		EmpleadoPagoRubro entity = new EmpleadoPagoRubro();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EmpleadoPagoRubro();
				
				if(conMapGenerico) {
					entity.inicializarMapEmpleadoPagoRubro();
					//entity.setMapEmpleadoPagoRubro(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapEmpleadoPagoRubroValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEmpleadoPagoRubro().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EmpleadoPagoRubroDataAccess.ISWITHSCHEMA);         		
					entity=EmpleadoPagoRubroDataAccess.getEntityEmpleadoPagoRubro("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEmpleadoPagoRubroOriginal( new EmpleadoPagoRubro());
					////entity.setEmpleadoPagoRubroOriginal(super.getEntity("",entity.getEmpleadoPagoRubroOriginal(),resultSet,EmpleadoPagoRubroDataAccess.ISWITHSCHEMA));         		
					////entity.setEmpleadoPagoRubroOriginal(this.getEntityEmpleadoPagoRubro("",entity.getEmpleadoPagoRubroOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEmpleadoPagoRubros(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmpleadoPagoRubro(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public EmpleadoPagoRubro getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EmpleadoPagoRubro entity = new EmpleadoPagoRubro();		  
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
	
	public  EmpleadoPagoRubro getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EmpleadoPagoRubro entity = new EmpleadoPagoRubro();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EmpleadoPagoRubro();
				
				if(conMapGenerico) {
					entity.inicializarMapEmpleadoPagoRubro();
					//entity.setMapEmpleadoPagoRubro(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapEmpleadoPagoRubroValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEmpleadoPagoRubro().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EmpleadoPagoRubroDataAccess.ISWITHSCHEMA);         		
					entity=EmpleadoPagoRubroDataAccess.getEntityEmpleadoPagoRubro("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEmpleadoPagoRubroOriginal( new EmpleadoPagoRubro());
					////entity.setEmpleadoPagoRubroOriginal(super.getEntity("",entity.getEmpleadoPagoRubroOriginal(),resultSet,EmpleadoPagoRubroDataAccess.ISWITHSCHEMA));         		
					////entity.setEmpleadoPagoRubroOriginal(this.getEntityEmpleadoPagoRubro("",entity.getEmpleadoPagoRubroOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseEmpleadoPagoRubro(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmpleadoPagoRubro(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static EmpleadoPagoRubro getEntityEmpleadoPagoRubro(String strPrefijo,EmpleadoPagoRubro entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = EmpleadoPagoRubro.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = EmpleadoPagoRubro.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					EmpleadoPagoRubroDataAccess.setFieldReflectionEmpleadoPagoRubro(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasEmpleadoPagoRubro=EmpleadoPagoRubroConstantesFunciones.getTodosTiposColumnasEmpleadoPagoRubro();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasEmpleadoPagoRubro) {
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
							field = EmpleadoPagoRubro.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = EmpleadoPagoRubro.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						EmpleadoPagoRubroDataAccess.setFieldReflectionEmpleadoPagoRubro(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionEmpleadoPagoRubro(Field field,String strPrefijo,String sColumn,EmpleadoPagoRubro entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case EmpleadoPagoRubroConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmpleadoPagoRubroConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EmpleadoPagoRubroConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmpleadoPagoRubroConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmpleadoPagoRubroConstantesFunciones.IDESTRUCTURA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmpleadoPagoRubroConstantesFunciones.IDRUBROEMPLEA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmpleadoPagoRubroConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmpleadoPagoRubroConstantesFunciones.IDMES:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmpleadoPagoRubroConstantesFunciones.VALORPAGO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case EmpleadoPagoRubroConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case EmpleadoPagoRubroConstantesFunciones.FECHALIQUIDACION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EmpleadoPagoRubro>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<EmpleadoPagoRubro> entities = new  ArrayList<EmpleadoPagoRubro>();
		EmpleadoPagoRubro entity = new EmpleadoPagoRubro();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EmpleadoPagoRubroDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EmpleadoPagoRubroDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmpleadoPagoRubroDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new EmpleadoPagoRubro();
					entity=super.getEntity("",entity,resultSet,EmpleadoPagoRubroDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityEmpleadoPagoRubro("",entity,resultSet);
					
					//entity.setEmpleadoPagoRubroOriginal( new EmpleadoPagoRubro());
					//entity.setEmpleadoPagoRubroOriginal(super.getEntity("",entity.getEmpleadoPagoRubroOriginal(),resultSet,EmpleadoPagoRubroDataAccess.ISWITHSCHEMA));         		
					//entity.setEmpleadoPagoRubroOriginal(this.getEntityEmpleadoPagoRubro("",entity.getEmpleadoPagoRubroOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseEmpleadoPagoRubros(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmpleadoPagoRubro(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EmpleadoPagoRubro>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<EmpleadoPagoRubro> entities = new  ArrayList<EmpleadoPagoRubro>();
		EmpleadoPagoRubro entity = new EmpleadoPagoRubro();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EmpleadoPagoRubroDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EmpleadoPagoRubroDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmpleadoPagoRubroDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<EmpleadoPagoRubro> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EmpleadoPagoRubro> entities = new  ArrayList<EmpleadoPagoRubro>();
		EmpleadoPagoRubro entity = new EmpleadoPagoRubro();		  
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
	
	public  List<EmpleadoPagoRubro> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EmpleadoPagoRubro> entities = new  ArrayList<EmpleadoPagoRubro>();
		EmpleadoPagoRubro entity = new EmpleadoPagoRubro();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EmpleadoPagoRubro();
      	    	entity=super.getEntity("",entity,resultSet,EmpleadoPagoRubroDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEmpleadoPagoRubro("",entity,resultSet);
      	    	
				//entity.setEmpleadoPagoRubroOriginal( new EmpleadoPagoRubro());
      	    	//entity.setEmpleadoPagoRubroOriginal(super.getEntity("",entity.getEmpleadoPagoRubroOriginal(),resultSet,EmpleadoPagoRubroDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmpleadoPagoRubroOriginal(this.getEntityEmpleadoPagoRubro("",entity.getEmpleadoPagoRubroOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseEmpleadoPagoRubros(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmpleadoPagoRubro(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<EmpleadoPagoRubro> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EmpleadoPagoRubro> entities = new  ArrayList<EmpleadoPagoRubro>();
		EmpleadoPagoRubro entity = new EmpleadoPagoRubro();		  
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
	
	public  List<EmpleadoPagoRubro> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EmpleadoPagoRubro> entities = new  ArrayList<EmpleadoPagoRubro>();
		EmpleadoPagoRubro entity = new EmpleadoPagoRubro();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EmpleadoPagoRubro();
      	    	entity=super.getEntity("",entity,resultSet,EmpleadoPagoRubroDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEmpleadoPagoRubro("",entity,resultSet);
      	    	
				//entity.setEmpleadoPagoRubroOriginal( new EmpleadoPagoRubro());
      	    	//entity.setEmpleadoPagoRubroOriginal(super.getEntity("",entity.getEmpleadoPagoRubroOriginal(),resultSet,EmpleadoPagoRubroDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmpleadoPagoRubroOriginal(this.getEntityEmpleadoPagoRubro("",entity.getEmpleadoPagoRubroOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEmpleadoPagoRubros(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public EmpleadoPagoRubro getEntityEmpleadoPagoRubro(String strPrefijo,EmpleadoPagoRubro entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+EmpleadoPagoRubroConstantesFunciones.IDEMPRESA));
				entity.setid_empleado(resultSet.getLong(strPrefijo+EmpleadoPagoRubroConstantesFunciones.IDEMPLEADO));
				entity.setid_estructura(resultSet.getLong(strPrefijo+EmpleadoPagoRubroConstantesFunciones.IDESTRUCTURA));
				entity.setid_rubro_emplea(resultSet.getLong(strPrefijo+EmpleadoPagoRubroConstantesFunciones.IDRUBROEMPLEA));
				entity.setid_anio(resultSet.getLong(strPrefijo+EmpleadoPagoRubroConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
				entity.setid_mes(resultSet.getLong(strPrefijo+EmpleadoPagoRubroConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
				entity.setvalor_pago(resultSet.getDouble(strPrefijo+EmpleadoPagoRubroConstantesFunciones.VALORPAGO));
				entity.setfecha(new Date(resultSet.getDate(strPrefijo+EmpleadoPagoRubroConstantesFunciones.FECHA).getTime()));
				entity.setfecha_liquidacion(new Date(resultSet.getDate(strPrefijo+EmpleadoPagoRubroConstantesFunciones.FECHALIQUIDACION).getTime()));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowEmpleadoPagoRubro(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(EmpleadoPagoRubro entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=EmpleadoPagoRubroDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=EmpleadoPagoRubroDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=EmpleadoPagoRubroDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=EmpleadoPagoRubroDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(EmpleadoPagoRubroConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,EmpleadoPagoRubroDataAccess.TABLENAME,EmpleadoPagoRubroDataAccess.ISWITHSTOREPROCEDURES);
			
			EmpleadoPagoRubroDataAccess.setEmpleadoPagoRubroOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,EmpleadoPagoRubro relempleadopagorubro)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relempleadopagorubro.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Empleado getEmpleado(Connexion connexion,EmpleadoPagoRubro relempleadopagorubro)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relempleadopagorubro.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public Estructura getEstructura(Connexion connexion,EmpleadoPagoRubro relempleadopagorubro)throws SQLException,Exception {

		Estructura estructura= new Estructura();

		try {
			EstructuraDataAccess estructuraDataAccess=new EstructuraDataAccess();

			estructuraDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estructuraDataAccess.setConnexionType(this.connexionType);
			estructuraDataAccess.setParameterDbType(this.parameterDbType);

			estructura=estructuraDataAccess.getEntity(connexion,relempleadopagorubro.getid_estructura());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estructura;

	}

	public RubroEmplea getRubroEmplea(Connexion connexion,EmpleadoPagoRubro relempleadopagorubro)throws SQLException,Exception {

		RubroEmplea rubroemplea= new RubroEmplea();

		try {
			RubroEmpleaDataAccess rubroempleaDataAccess=new RubroEmpleaDataAccess();

			rubroempleaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			rubroempleaDataAccess.setConnexionType(this.connexionType);
			rubroempleaDataAccess.setParameterDbType(this.parameterDbType);

			rubroemplea=rubroempleaDataAccess.getEntity(connexion,relempleadopagorubro.getid_rubro_emplea());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return rubroemplea;

	}

	public Anio getAnio(Connexion connexion,EmpleadoPagoRubro relempleadopagorubro)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);

			anio=anioDataAccess.getEntity(connexion,relempleadopagorubro.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Mes getMes(Connexion connexion,EmpleadoPagoRubro relempleadopagorubro)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,relempleadopagorubro.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,EmpleadoPagoRubro empleadopagorubro) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!empleadopagorubro.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(empleadopagorubro.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(empleadopagorubro.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estructura=new ParameterValue<Long>();
					parameterMaintenanceValueid_estructura.setValue(empleadopagorubro.getid_estructura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estructura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_rubro_emplea=new ParameterValue<Long>();
					parameterMaintenanceValueid_rubro_emplea.setValue(empleadopagorubro.getid_rubro_emplea());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_rubro_emplea);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_anio=new ParameterValue<Long>();
					parameterMaintenanceValueid_anio.setValue(empleadopagorubro.getid_anio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_anio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes.setValue(empleadopagorubro.getid_mes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_pago=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_pago.setValue(empleadopagorubro.getvalor_pago());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_pago);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha=new ParameterValue<Date>();
					parameterMaintenanceValuefecha.setValue(empleadopagorubro.getfecha());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_liquidacion=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_liquidacion.setValue(empleadopagorubro.getfecha_liquidacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_liquidacion);
					parametersTemp.add(parameterMaintenance);
					
						if(!empleadopagorubro.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(empleadopagorubro.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(empleadopagorubro.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(empleadopagorubro.getId());
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
	
	public void setIsNewIsChangedFalseEmpleadoPagoRubro(EmpleadoPagoRubro empleadopagorubro)throws Exception  {		
		empleadopagorubro.setIsNew(false);
		empleadopagorubro.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseEmpleadoPagoRubros(List<EmpleadoPagoRubro> empleadopagorubros)throws Exception  {				
		for(EmpleadoPagoRubro empleadopagorubro:empleadopagorubros) {
			empleadopagorubro.setIsNew(false);
			empleadopagorubro.setIsChanged(false);
		}
	}
	
	public void generarExportarEmpleadoPagoRubro(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
