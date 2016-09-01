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
import com.bydan.erp.nomina.util.*;//EmpleadoImpuestoRentaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class EmpleadoImpuestoRentaDataAccess extends  EmpleadoImpuestoRentaDataAccessAdditional{ //EmpleadoImpuestoRentaDataAccessAdditional,DataAccessHelper<EmpleadoImpuestoRenta>
	//static Logger logger = Logger.getLogger(EmpleadoImpuestoRentaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="empleado_impuesto_renta";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+EmpleadoImpuestoRentaConstantesFunciones.SCHEMA+"."+EmpleadoImpuestoRentaConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_empleado,id_anio,id_mes,id_estructura,fecha,valor_pago,ingreso_liquido,aporte_iess)values(current_timestamp,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+EmpleadoImpuestoRentaConstantesFunciones.SCHEMA+"."+EmpleadoImpuestoRentaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_empleado=?,id_anio=?,id_mes=?,id_estructura=?,fecha=?,valor_pago=?,ingreso_liquido=?,aporte_iess=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+EmpleadoImpuestoRentaConstantesFunciones.SCHEMA+"."+EmpleadoImpuestoRentaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select empleadoimpuestorenta from "+EmpleadoImpuestoRentaConstantesFunciones.SPERSISTENCENAME+" empleadoimpuestorenta";
	public static String QUERYSELECTNATIVE="select "+EmpleadoImpuestoRentaConstantesFunciones.SCHEMA+"."+EmpleadoImpuestoRentaConstantesFunciones.TABLENAME+".id,"+EmpleadoImpuestoRentaConstantesFunciones.SCHEMA+"."+EmpleadoImpuestoRentaConstantesFunciones.TABLENAME+".version_row,"+EmpleadoImpuestoRentaConstantesFunciones.SCHEMA+"."+EmpleadoImpuestoRentaConstantesFunciones.TABLENAME+".id_empresa,"+EmpleadoImpuestoRentaConstantesFunciones.SCHEMA+"."+EmpleadoImpuestoRentaConstantesFunciones.TABLENAME+".id_empleado,"+EmpleadoImpuestoRentaConstantesFunciones.SCHEMA+"."+EmpleadoImpuestoRentaConstantesFunciones.TABLENAME+".id_anio,"+EmpleadoImpuestoRentaConstantesFunciones.SCHEMA+"."+EmpleadoImpuestoRentaConstantesFunciones.TABLENAME+".id_mes,"+EmpleadoImpuestoRentaConstantesFunciones.SCHEMA+"."+EmpleadoImpuestoRentaConstantesFunciones.TABLENAME+".id_estructura,"+EmpleadoImpuestoRentaConstantesFunciones.SCHEMA+"."+EmpleadoImpuestoRentaConstantesFunciones.TABLENAME+".fecha,"+EmpleadoImpuestoRentaConstantesFunciones.SCHEMA+"."+EmpleadoImpuestoRentaConstantesFunciones.TABLENAME+".valor_pago,"+EmpleadoImpuestoRentaConstantesFunciones.SCHEMA+"."+EmpleadoImpuestoRentaConstantesFunciones.TABLENAME+".ingreso_liquido,"+EmpleadoImpuestoRentaConstantesFunciones.SCHEMA+"."+EmpleadoImpuestoRentaConstantesFunciones.TABLENAME+".aporte_iess from "+EmpleadoImpuestoRentaConstantesFunciones.SCHEMA+"."+EmpleadoImpuestoRentaConstantesFunciones.TABLENAME;//+" as "+EmpleadoImpuestoRentaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+EmpleadoImpuestoRentaConstantesFunciones.SCHEMA+"."+EmpleadoImpuestoRentaConstantesFunciones.TABLENAME+".id,"+EmpleadoImpuestoRentaConstantesFunciones.SCHEMA+"."+EmpleadoImpuestoRentaConstantesFunciones.TABLENAME+".version_row from "+EmpleadoImpuestoRentaConstantesFunciones.SCHEMA+"."+EmpleadoImpuestoRentaConstantesFunciones.TABLENAME;//+" as "+EmpleadoImpuestoRentaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+EmpleadoImpuestoRentaConstantesFunciones.SCHEMA+"."+EmpleadoImpuestoRentaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_empleado=?,id_anio=?,id_mes=?,id_estructura=?,fecha=?,valor_pago=?,ingreso_liquido=?,aporte_iess=?";
	
	public static String STOREPROCEDUREINSERT="call SP_EMPLEADOIMPUESTORENTA_INSERT(?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_EMPLEADOIMPUESTORENTA_UPDATE(?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_EMPLEADOIMPUESTORENTA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_EMPLEADOIMPUESTORENTA_SELECT(?,?)";
	
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
	
	
	protected EmpleadoImpuestoRentaDataAccessAdditional empleadoimpuestorentaDataAccessAdditional=null;
	
	public EmpleadoImpuestoRentaDataAccessAdditional getEmpleadoImpuestoRentaDataAccessAdditional() {
		return this.empleadoimpuestorentaDataAccessAdditional;
	}
	
	public void setEmpleadoImpuestoRentaDataAccessAdditional(EmpleadoImpuestoRentaDataAccessAdditional empleadoimpuestorentaDataAccessAdditional) {
		try {
			this.empleadoimpuestorentaDataAccessAdditional=empleadoimpuestorentaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public EmpleadoImpuestoRentaDataAccess() {
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
		EmpleadoImpuestoRentaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		EmpleadoImpuestoRentaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		EmpleadoImpuestoRentaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setEmpleadoImpuestoRentaOriginal(EmpleadoImpuestoRenta empleadoimpuestorenta)throws Exception  {
		empleadoimpuestorenta.setEmpleadoImpuestoRentaOriginal((EmpleadoImpuestoRenta)empleadoimpuestorenta.clone());		
	}
	
	public void setEmpleadoImpuestoRentasOriginal(List<EmpleadoImpuestoRenta> empleadoimpuestorentas)throws Exception  {
		
		for(EmpleadoImpuestoRenta empleadoimpuestorenta:empleadoimpuestorentas){
			empleadoimpuestorenta.setEmpleadoImpuestoRentaOriginal((EmpleadoImpuestoRenta)empleadoimpuestorenta.clone());
		}
	}
	
	public static void setEmpleadoImpuestoRentaOriginalStatic(EmpleadoImpuestoRenta empleadoimpuestorenta)throws Exception  {
		empleadoimpuestorenta.setEmpleadoImpuestoRentaOriginal((EmpleadoImpuestoRenta)empleadoimpuestorenta.clone());		
	}
	
	public static void setEmpleadoImpuestoRentasOriginalStatic(List<EmpleadoImpuestoRenta> empleadoimpuestorentas)throws Exception  {
		
		for(EmpleadoImpuestoRenta empleadoimpuestorenta:empleadoimpuestorentas){
			empleadoimpuestorenta.setEmpleadoImpuestoRentaOriginal((EmpleadoImpuestoRenta)empleadoimpuestorenta.clone());
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
	
	public  EmpleadoImpuestoRenta getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		EmpleadoImpuestoRenta entity = new EmpleadoImpuestoRenta();		
		
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
	
	public  EmpleadoImpuestoRenta getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		EmpleadoImpuestoRenta entity = new EmpleadoImpuestoRenta();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EmpleadoImpuestoRentaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EmpleadoImpuestoRentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.EmpleadoImpuestoRenta.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setEmpleadoImpuestoRentaOriginal(new EmpleadoImpuestoRenta());
      	    	entity=super.getEntity("",entity,resultSet,EmpleadoImpuestoRentaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEmpleadoImpuestoRenta("",entity,resultSet); 
				
				//entity.setEmpleadoImpuestoRentaOriginal(super.getEntity("",entity.getEmpleadoImpuestoRentaOriginal(),resultSet,EmpleadoImpuestoRentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmpleadoImpuestoRentaOriginal(this.getEntityEmpleadoImpuestoRenta("",entity.getEmpleadoImpuestoRentaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseEmpleadoImpuestoRenta(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  EmpleadoImpuestoRenta getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EmpleadoImpuestoRenta entity = new EmpleadoImpuestoRenta();
				
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
	
	public  EmpleadoImpuestoRenta getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EmpleadoImpuestoRenta entity = new EmpleadoImpuestoRenta();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EmpleadoImpuestoRentaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EmpleadoImpuestoRentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmpleadoImpuestoRentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.EmpleadoImpuestoRenta.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setEmpleadoImpuestoRentaOriginal(new EmpleadoImpuestoRenta());
      	    	entity=super.getEntity("",entity,resultSet,EmpleadoImpuestoRentaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEmpleadoImpuestoRenta("",entity,resultSet);    
				
				//entity.setEmpleadoImpuestoRentaOriginal(super.getEntity("",entity.getEmpleadoImpuestoRentaOriginal(),resultSet,EmpleadoImpuestoRentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmpleadoImpuestoRentaOriginal(this.getEntityEmpleadoImpuestoRenta("",entity.getEmpleadoImpuestoRentaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseEmpleadoImpuestoRenta(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //EmpleadoImpuestoRenta
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		EmpleadoImpuestoRenta entity = new EmpleadoImpuestoRenta();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EmpleadoImpuestoRentaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EmpleadoImpuestoRentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmpleadoImpuestoRentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.EmpleadoImpuestoRenta.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseEmpleadoImpuestoRenta(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<EmpleadoImpuestoRenta> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EmpleadoImpuestoRenta> entities = new  ArrayList<EmpleadoImpuestoRenta>();
		EmpleadoImpuestoRenta entity = new EmpleadoImpuestoRenta();		  
		
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
	
	public  List<EmpleadoImpuestoRenta> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EmpleadoImpuestoRenta> entities = new  ArrayList<EmpleadoImpuestoRenta>();
		EmpleadoImpuestoRenta entity = new EmpleadoImpuestoRenta();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=EmpleadoImpuestoRentaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EmpleadoImpuestoRentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmpleadoImpuestoRentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EmpleadoImpuestoRenta();
      	    	entity=super.getEntity("",entity,resultSet,EmpleadoImpuestoRentaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEmpleadoImpuestoRenta("",entity,resultSet);
      	    	
				//entity.setEmpleadoImpuestoRentaOriginal( new EmpleadoImpuestoRenta());
      	    	//entity.setEmpleadoImpuestoRentaOriginal(super.getEntity("",entity.getEmpleadoImpuestoRentaOriginal(),resultSet,EmpleadoImpuestoRentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmpleadoImpuestoRentaOriginal(this.getEntityEmpleadoImpuestoRenta("",entity.getEmpleadoImpuestoRentaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEmpleadoImpuestoRentas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmpleadoImpuestoRenta(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<EmpleadoImpuestoRenta> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EmpleadoImpuestoRenta> entities = new  ArrayList<EmpleadoImpuestoRenta>();
		EmpleadoImpuestoRenta entity = new EmpleadoImpuestoRenta();		  
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
	
	public  List<EmpleadoImpuestoRenta> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EmpleadoImpuestoRenta> entities = new  ArrayList<EmpleadoImpuestoRenta>();
		EmpleadoImpuestoRenta entity = new EmpleadoImpuestoRenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EmpleadoImpuestoRenta();
				
				if(conMapGenerico) {
					entity.inicializarMapEmpleadoImpuestoRenta();
					//entity.setMapEmpleadoImpuestoRenta(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapEmpleadoImpuestoRentaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEmpleadoImpuestoRenta().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EmpleadoImpuestoRentaDataAccess.ISWITHSCHEMA);         		
					entity=EmpleadoImpuestoRentaDataAccess.getEntityEmpleadoImpuestoRenta("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEmpleadoImpuestoRentaOriginal( new EmpleadoImpuestoRenta());
					////entity.setEmpleadoImpuestoRentaOriginal(super.getEntity("",entity.getEmpleadoImpuestoRentaOriginal(),resultSet,EmpleadoImpuestoRentaDataAccess.ISWITHSCHEMA));         		
					////entity.setEmpleadoImpuestoRentaOriginal(this.getEntityEmpleadoImpuestoRenta("",entity.getEmpleadoImpuestoRentaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEmpleadoImpuestoRentas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmpleadoImpuestoRenta(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public EmpleadoImpuestoRenta getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EmpleadoImpuestoRenta entity = new EmpleadoImpuestoRenta();		  
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
	
	public  EmpleadoImpuestoRenta getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EmpleadoImpuestoRenta entity = new EmpleadoImpuestoRenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EmpleadoImpuestoRenta();
				
				if(conMapGenerico) {
					entity.inicializarMapEmpleadoImpuestoRenta();
					//entity.setMapEmpleadoImpuestoRenta(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapEmpleadoImpuestoRentaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEmpleadoImpuestoRenta().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EmpleadoImpuestoRentaDataAccess.ISWITHSCHEMA);         		
					entity=EmpleadoImpuestoRentaDataAccess.getEntityEmpleadoImpuestoRenta("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEmpleadoImpuestoRentaOriginal( new EmpleadoImpuestoRenta());
					////entity.setEmpleadoImpuestoRentaOriginal(super.getEntity("",entity.getEmpleadoImpuestoRentaOriginal(),resultSet,EmpleadoImpuestoRentaDataAccess.ISWITHSCHEMA));         		
					////entity.setEmpleadoImpuestoRentaOriginal(this.getEntityEmpleadoImpuestoRenta("",entity.getEmpleadoImpuestoRentaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseEmpleadoImpuestoRenta(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmpleadoImpuestoRenta(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static EmpleadoImpuestoRenta getEntityEmpleadoImpuestoRenta(String strPrefijo,EmpleadoImpuestoRenta entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = EmpleadoImpuestoRenta.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = EmpleadoImpuestoRenta.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					EmpleadoImpuestoRentaDataAccess.setFieldReflectionEmpleadoImpuestoRenta(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasEmpleadoImpuestoRenta=EmpleadoImpuestoRentaConstantesFunciones.getTodosTiposColumnasEmpleadoImpuestoRenta();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasEmpleadoImpuestoRenta) {
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
							field = EmpleadoImpuestoRenta.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = EmpleadoImpuestoRenta.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						EmpleadoImpuestoRentaDataAccess.setFieldReflectionEmpleadoImpuestoRenta(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionEmpleadoImpuestoRenta(Field field,String strPrefijo,String sColumn,EmpleadoImpuestoRenta entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case EmpleadoImpuestoRentaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmpleadoImpuestoRentaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EmpleadoImpuestoRentaConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmpleadoImpuestoRentaConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmpleadoImpuestoRentaConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmpleadoImpuestoRentaConstantesFunciones.IDMES:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmpleadoImpuestoRentaConstantesFunciones.IDESTRUCTURA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmpleadoImpuestoRentaConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case EmpleadoImpuestoRentaConstantesFunciones.VALORPAGO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case EmpleadoImpuestoRentaConstantesFunciones.INGRESOLIQUIDO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case EmpleadoImpuestoRentaConstantesFunciones.APORTEIESS:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EmpleadoImpuestoRenta>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<EmpleadoImpuestoRenta> entities = new  ArrayList<EmpleadoImpuestoRenta>();
		EmpleadoImpuestoRenta entity = new EmpleadoImpuestoRenta();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EmpleadoImpuestoRentaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EmpleadoImpuestoRentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmpleadoImpuestoRentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new EmpleadoImpuestoRenta();
					entity=super.getEntity("",entity,resultSet,EmpleadoImpuestoRentaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityEmpleadoImpuestoRenta("",entity,resultSet);
					
					//entity.setEmpleadoImpuestoRentaOriginal( new EmpleadoImpuestoRenta());
					//entity.setEmpleadoImpuestoRentaOriginal(super.getEntity("",entity.getEmpleadoImpuestoRentaOriginal(),resultSet,EmpleadoImpuestoRentaDataAccess.ISWITHSCHEMA));         		
					//entity.setEmpleadoImpuestoRentaOriginal(this.getEntityEmpleadoImpuestoRenta("",entity.getEmpleadoImpuestoRentaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseEmpleadoImpuestoRentas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmpleadoImpuestoRenta(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EmpleadoImpuestoRenta>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<EmpleadoImpuestoRenta> entities = new  ArrayList<EmpleadoImpuestoRenta>();
		EmpleadoImpuestoRenta entity = new EmpleadoImpuestoRenta();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EmpleadoImpuestoRentaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EmpleadoImpuestoRentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmpleadoImpuestoRentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<EmpleadoImpuestoRenta> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EmpleadoImpuestoRenta> entities = new  ArrayList<EmpleadoImpuestoRenta>();
		EmpleadoImpuestoRenta entity = new EmpleadoImpuestoRenta();		  
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
	
	public  List<EmpleadoImpuestoRenta> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EmpleadoImpuestoRenta> entities = new  ArrayList<EmpleadoImpuestoRenta>();
		EmpleadoImpuestoRenta entity = new EmpleadoImpuestoRenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EmpleadoImpuestoRenta();
      	    	entity=super.getEntity("",entity,resultSet,EmpleadoImpuestoRentaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEmpleadoImpuestoRenta("",entity,resultSet);
      	    	
				//entity.setEmpleadoImpuestoRentaOriginal( new EmpleadoImpuestoRenta());
      	    	//entity.setEmpleadoImpuestoRentaOriginal(super.getEntity("",entity.getEmpleadoImpuestoRentaOriginal(),resultSet,EmpleadoImpuestoRentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmpleadoImpuestoRentaOriginal(this.getEntityEmpleadoImpuestoRenta("",entity.getEmpleadoImpuestoRentaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseEmpleadoImpuestoRentas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmpleadoImpuestoRenta(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<EmpleadoImpuestoRenta> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EmpleadoImpuestoRenta> entities = new  ArrayList<EmpleadoImpuestoRenta>();
		EmpleadoImpuestoRenta entity = new EmpleadoImpuestoRenta();		  
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
	
	public  List<EmpleadoImpuestoRenta> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EmpleadoImpuestoRenta> entities = new  ArrayList<EmpleadoImpuestoRenta>();
		EmpleadoImpuestoRenta entity = new EmpleadoImpuestoRenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EmpleadoImpuestoRenta();
      	    	entity=super.getEntity("",entity,resultSet,EmpleadoImpuestoRentaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEmpleadoImpuestoRenta("",entity,resultSet);
      	    	
				//entity.setEmpleadoImpuestoRentaOriginal( new EmpleadoImpuestoRenta());
      	    	//entity.setEmpleadoImpuestoRentaOriginal(super.getEntity("",entity.getEmpleadoImpuestoRentaOriginal(),resultSet,EmpleadoImpuestoRentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmpleadoImpuestoRentaOriginal(this.getEntityEmpleadoImpuestoRenta("",entity.getEmpleadoImpuestoRentaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEmpleadoImpuestoRentas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public EmpleadoImpuestoRenta getEntityEmpleadoImpuestoRenta(String strPrefijo,EmpleadoImpuestoRenta entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+EmpleadoImpuestoRentaConstantesFunciones.IDEMPRESA));
				entity.setid_empleado(resultSet.getLong(strPrefijo+EmpleadoImpuestoRentaConstantesFunciones.IDEMPLEADO));
				entity.setid_anio(resultSet.getLong(strPrefijo+EmpleadoImpuestoRentaConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
				entity.setid_mes(resultSet.getLong(strPrefijo+EmpleadoImpuestoRentaConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
				entity.setid_estructura(resultSet.getLong(strPrefijo+EmpleadoImpuestoRentaConstantesFunciones.IDESTRUCTURA));
				entity.setfecha(new Date(resultSet.getDate(strPrefijo+EmpleadoImpuestoRentaConstantesFunciones.FECHA).getTime()));
				entity.setvalor_pago(resultSet.getDouble(strPrefijo+EmpleadoImpuestoRentaConstantesFunciones.VALORPAGO));
				entity.setingreso_liquido(resultSet.getDouble(strPrefijo+EmpleadoImpuestoRentaConstantesFunciones.INGRESOLIQUIDO));
				entity.setaporte_iess(resultSet.getDouble(strPrefijo+EmpleadoImpuestoRentaConstantesFunciones.APORTEIESS));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowEmpleadoImpuestoRenta(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(EmpleadoImpuestoRenta entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=EmpleadoImpuestoRentaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=EmpleadoImpuestoRentaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=EmpleadoImpuestoRentaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=EmpleadoImpuestoRentaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(EmpleadoImpuestoRentaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,EmpleadoImpuestoRentaDataAccess.TABLENAME,EmpleadoImpuestoRentaDataAccess.ISWITHSTOREPROCEDURES);
			
			EmpleadoImpuestoRentaDataAccess.setEmpleadoImpuestoRentaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,EmpleadoImpuestoRenta relempleadoimpuestorenta)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relempleadoimpuestorenta.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Empleado getEmpleado(Connexion connexion,EmpleadoImpuestoRenta relempleadoimpuestorenta)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relempleadoimpuestorenta.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public Anio getAnio(Connexion connexion,EmpleadoImpuestoRenta relempleadoimpuestorenta)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);

			anio=anioDataAccess.getEntity(connexion,relempleadoimpuestorenta.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Mes getMes(Connexion connexion,EmpleadoImpuestoRenta relempleadoimpuestorenta)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,relempleadoimpuestorenta.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}

	public Estructura getEstructura(Connexion connexion,EmpleadoImpuestoRenta relempleadoimpuestorenta)throws SQLException,Exception {

		Estructura estructura= new Estructura();

		try {
			EstructuraDataAccess estructuraDataAccess=new EstructuraDataAccess();

			estructuraDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estructuraDataAccess.setConnexionType(this.connexionType);
			estructuraDataAccess.setParameterDbType(this.parameterDbType);

			estructura=estructuraDataAccess.getEntity(connexion,relempleadoimpuestorenta.getid_estructura());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estructura;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,EmpleadoImpuestoRenta empleadoimpuestorenta) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!empleadoimpuestorenta.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(empleadoimpuestorenta.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(empleadoimpuestorenta.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_anio=new ParameterValue<Long>();
					parameterMaintenanceValueid_anio.setValue(empleadoimpuestorenta.getid_anio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_anio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes.setValue(empleadoimpuestorenta.getid_mes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estructura=new ParameterValue<Long>();
					parameterMaintenanceValueid_estructura.setValue(empleadoimpuestorenta.getid_estructura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estructura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha=new ParameterValue<Date>();
					parameterMaintenanceValuefecha.setValue(empleadoimpuestorenta.getfecha());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_pago=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_pago.setValue(empleadoimpuestorenta.getvalor_pago());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_pago);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueingreso_liquido=new ParameterValue<Double>();
					parameterMaintenanceValueingreso_liquido.setValue(empleadoimpuestorenta.getingreso_liquido());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueingreso_liquido);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueaporte_iess=new ParameterValue<Double>();
					parameterMaintenanceValueaporte_iess.setValue(empleadoimpuestorenta.getaporte_iess());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueaporte_iess);
					parametersTemp.add(parameterMaintenance);
					
						if(!empleadoimpuestorenta.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(empleadoimpuestorenta.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(empleadoimpuestorenta.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(empleadoimpuestorenta.getId());
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
	
	public void setIsNewIsChangedFalseEmpleadoImpuestoRenta(EmpleadoImpuestoRenta empleadoimpuestorenta)throws Exception  {		
		empleadoimpuestorenta.setIsNew(false);
		empleadoimpuestorenta.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseEmpleadoImpuestoRentas(List<EmpleadoImpuestoRenta> empleadoimpuestorentas)throws Exception  {				
		for(EmpleadoImpuestoRenta empleadoimpuestorenta:empleadoimpuestorentas) {
			empleadoimpuestorenta.setIsNew(false);
			empleadoimpuestorenta.setIsChanged(false);
		}
	}
	
	public void generarExportarEmpleadoImpuestoRenta(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
