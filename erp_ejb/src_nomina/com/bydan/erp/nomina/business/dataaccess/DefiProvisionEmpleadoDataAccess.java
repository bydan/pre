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
import com.bydan.erp.nomina.util.*;//DefiProvisionEmpleadoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class DefiProvisionEmpleadoDataAccess extends  DefiProvisionEmpleadoDataAccessAdditional{ //DefiProvisionEmpleadoDataAccessAdditional,DataAccessHelper<DefiProvisionEmpleado>
	//static Logger logger = Logger.getLogger(DefiProvisionEmpleadoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="defi_provision_empleado";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+DefiProvisionEmpleadoConstantesFunciones.SCHEMA+"."+DefiProvisionEmpleadoConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_rubro_emplea,id_formato,nombre,dia_inicial,id_mes_inicial,dia_final,id_mes_final,para_liquidacion,descripcion)values(current_timestamp,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+DefiProvisionEmpleadoConstantesFunciones.SCHEMA+"."+DefiProvisionEmpleadoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_rubro_emplea=?,id_formato=?,nombre=?,dia_inicial=?,id_mes_inicial=?,dia_final=?,id_mes_final=?,para_liquidacion=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+DefiProvisionEmpleadoConstantesFunciones.SCHEMA+"."+DefiProvisionEmpleadoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select defiprovisionempleado from "+DefiProvisionEmpleadoConstantesFunciones.SPERSISTENCENAME+" defiprovisionempleado";
	public static String QUERYSELECTNATIVE="select "+DefiProvisionEmpleadoConstantesFunciones.SCHEMA+"."+DefiProvisionEmpleadoConstantesFunciones.TABLENAME+".id,"+DefiProvisionEmpleadoConstantesFunciones.SCHEMA+"."+DefiProvisionEmpleadoConstantesFunciones.TABLENAME+".version_row,"+DefiProvisionEmpleadoConstantesFunciones.SCHEMA+"."+DefiProvisionEmpleadoConstantesFunciones.TABLENAME+".id_empresa,"+DefiProvisionEmpleadoConstantesFunciones.SCHEMA+"."+DefiProvisionEmpleadoConstantesFunciones.TABLENAME+".id_rubro_emplea,"+DefiProvisionEmpleadoConstantesFunciones.SCHEMA+"."+DefiProvisionEmpleadoConstantesFunciones.TABLENAME+".id_formato,"+DefiProvisionEmpleadoConstantesFunciones.SCHEMA+"."+DefiProvisionEmpleadoConstantesFunciones.TABLENAME+".nombre,"+DefiProvisionEmpleadoConstantesFunciones.SCHEMA+"."+DefiProvisionEmpleadoConstantesFunciones.TABLENAME+".dia_inicial,"+DefiProvisionEmpleadoConstantesFunciones.SCHEMA+"."+DefiProvisionEmpleadoConstantesFunciones.TABLENAME+".id_mes_inicial,"+DefiProvisionEmpleadoConstantesFunciones.SCHEMA+"."+DefiProvisionEmpleadoConstantesFunciones.TABLENAME+".dia_final,"+DefiProvisionEmpleadoConstantesFunciones.SCHEMA+"."+DefiProvisionEmpleadoConstantesFunciones.TABLENAME+".id_mes_final,"+DefiProvisionEmpleadoConstantesFunciones.SCHEMA+"."+DefiProvisionEmpleadoConstantesFunciones.TABLENAME+".para_liquidacion,"+DefiProvisionEmpleadoConstantesFunciones.SCHEMA+"."+DefiProvisionEmpleadoConstantesFunciones.TABLENAME+".descripcion from "+DefiProvisionEmpleadoConstantesFunciones.SCHEMA+"."+DefiProvisionEmpleadoConstantesFunciones.TABLENAME;//+" as "+DefiProvisionEmpleadoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+DefiProvisionEmpleadoConstantesFunciones.SCHEMA+"."+DefiProvisionEmpleadoConstantesFunciones.TABLENAME+".id,"+DefiProvisionEmpleadoConstantesFunciones.SCHEMA+"."+DefiProvisionEmpleadoConstantesFunciones.TABLENAME+".version_row,"+DefiProvisionEmpleadoConstantesFunciones.SCHEMA+"."+DefiProvisionEmpleadoConstantesFunciones.TABLENAME+".nombre from "+DefiProvisionEmpleadoConstantesFunciones.SCHEMA+"."+DefiProvisionEmpleadoConstantesFunciones.TABLENAME;//+" as "+DefiProvisionEmpleadoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+DefiProvisionEmpleadoConstantesFunciones.SCHEMA+"."+DefiProvisionEmpleadoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_rubro_emplea=?,id_formato=?,nombre=?,dia_inicial=?,id_mes_inicial=?,dia_final=?,id_mes_final=?,para_liquidacion=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_DEFIPROVISIONEMPLEADO_INSERT(?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_DEFIPROVISIONEMPLEADO_UPDATE(?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_DEFIPROVISIONEMPLEADO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_DEFIPROVISIONEMPLEADO_SELECT(?,?)";
	
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
	
	
	protected DefiProvisionEmpleadoDataAccessAdditional defiprovisionempleadoDataAccessAdditional=null;
	
	public DefiProvisionEmpleadoDataAccessAdditional getDefiProvisionEmpleadoDataAccessAdditional() {
		return this.defiprovisionempleadoDataAccessAdditional;
	}
	
	public void setDefiProvisionEmpleadoDataAccessAdditional(DefiProvisionEmpleadoDataAccessAdditional defiprovisionempleadoDataAccessAdditional) {
		try {
			this.defiprovisionempleadoDataAccessAdditional=defiprovisionempleadoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public DefiProvisionEmpleadoDataAccess() {
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
		DefiProvisionEmpleadoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		DefiProvisionEmpleadoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		DefiProvisionEmpleadoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setDefiProvisionEmpleadoOriginal(DefiProvisionEmpleado defiprovisionempleado)throws Exception  {
		defiprovisionempleado.setDefiProvisionEmpleadoOriginal((DefiProvisionEmpleado)defiprovisionempleado.clone());		
	}
	
	public void setDefiProvisionEmpleadosOriginal(List<DefiProvisionEmpleado> defiprovisionempleados)throws Exception  {
		
		for(DefiProvisionEmpleado defiprovisionempleado:defiprovisionempleados){
			defiprovisionempleado.setDefiProvisionEmpleadoOriginal((DefiProvisionEmpleado)defiprovisionempleado.clone());
		}
	}
	
	public static void setDefiProvisionEmpleadoOriginalStatic(DefiProvisionEmpleado defiprovisionempleado)throws Exception  {
		defiprovisionempleado.setDefiProvisionEmpleadoOriginal((DefiProvisionEmpleado)defiprovisionempleado.clone());		
	}
	
	public static void setDefiProvisionEmpleadosOriginalStatic(List<DefiProvisionEmpleado> defiprovisionempleados)throws Exception  {
		
		for(DefiProvisionEmpleado defiprovisionempleado:defiprovisionempleados){
			defiprovisionempleado.setDefiProvisionEmpleadoOriginal((DefiProvisionEmpleado)defiprovisionempleado.clone());
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
	
	public  DefiProvisionEmpleado getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		DefiProvisionEmpleado entity = new DefiProvisionEmpleado();		
		
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
	
	public  DefiProvisionEmpleado getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		DefiProvisionEmpleado entity = new DefiProvisionEmpleado();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DefiProvisionEmpleadoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DefiProvisionEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.DefiProvisionEmpleado.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setDefiProvisionEmpleadoOriginal(new DefiProvisionEmpleado());
      	    	entity=super.getEntity("",entity,resultSet,DefiProvisionEmpleadoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDefiProvisionEmpleado("",entity,resultSet); 
				
				//entity.setDefiProvisionEmpleadoOriginal(super.getEntity("",entity.getDefiProvisionEmpleadoOriginal(),resultSet,DefiProvisionEmpleadoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDefiProvisionEmpleadoOriginal(this.getEntityDefiProvisionEmpleado("",entity.getDefiProvisionEmpleadoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseDefiProvisionEmpleado(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  DefiProvisionEmpleado getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DefiProvisionEmpleado entity = new DefiProvisionEmpleado();
				
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
	
	public  DefiProvisionEmpleado getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DefiProvisionEmpleado entity = new DefiProvisionEmpleado();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DefiProvisionEmpleadoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DefiProvisionEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DefiProvisionEmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.DefiProvisionEmpleado.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setDefiProvisionEmpleadoOriginal(new DefiProvisionEmpleado());
      	    	entity=super.getEntity("",entity,resultSet,DefiProvisionEmpleadoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDefiProvisionEmpleado("",entity,resultSet);    
				
				//entity.setDefiProvisionEmpleadoOriginal(super.getEntity("",entity.getDefiProvisionEmpleadoOriginal(),resultSet,DefiProvisionEmpleadoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDefiProvisionEmpleadoOriginal(this.getEntityDefiProvisionEmpleado("",entity.getDefiProvisionEmpleadoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseDefiProvisionEmpleado(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //DefiProvisionEmpleado
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		DefiProvisionEmpleado entity = new DefiProvisionEmpleado();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DefiProvisionEmpleadoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DefiProvisionEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DefiProvisionEmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.DefiProvisionEmpleado.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseDefiProvisionEmpleado(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<DefiProvisionEmpleado> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DefiProvisionEmpleado> entities = new  ArrayList<DefiProvisionEmpleado>();
		DefiProvisionEmpleado entity = new DefiProvisionEmpleado();		  
		
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
	
	public  List<DefiProvisionEmpleado> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DefiProvisionEmpleado> entities = new  ArrayList<DefiProvisionEmpleado>();
		DefiProvisionEmpleado entity = new DefiProvisionEmpleado();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=DefiProvisionEmpleadoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DefiProvisionEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DefiProvisionEmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DefiProvisionEmpleado();
      	    	entity=super.getEntity("",entity,resultSet,DefiProvisionEmpleadoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDefiProvisionEmpleado("",entity,resultSet);
      	    	
				//entity.setDefiProvisionEmpleadoOriginal( new DefiProvisionEmpleado());
      	    	//entity.setDefiProvisionEmpleadoOriginal(super.getEntity("",entity.getDefiProvisionEmpleadoOriginal(),resultSet,DefiProvisionEmpleadoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDefiProvisionEmpleadoOriginal(this.getEntityDefiProvisionEmpleado("",entity.getDefiProvisionEmpleadoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDefiProvisionEmpleados(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDefiProvisionEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DefiProvisionEmpleado> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DefiProvisionEmpleado> entities = new  ArrayList<DefiProvisionEmpleado>();
		DefiProvisionEmpleado entity = new DefiProvisionEmpleado();		  
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
	
	public  List<DefiProvisionEmpleado> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DefiProvisionEmpleado> entities = new  ArrayList<DefiProvisionEmpleado>();
		DefiProvisionEmpleado entity = new DefiProvisionEmpleado();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DefiProvisionEmpleado();
				
				if(conMapGenerico) {
					entity.inicializarMapDefiProvisionEmpleado();
					//entity.setMapDefiProvisionEmpleado(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapDefiProvisionEmpleadoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDefiProvisionEmpleado().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DefiProvisionEmpleadoDataAccess.ISWITHSCHEMA);         		
					entity=DefiProvisionEmpleadoDataAccess.getEntityDefiProvisionEmpleado("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDefiProvisionEmpleadoOriginal( new DefiProvisionEmpleado());
					////entity.setDefiProvisionEmpleadoOriginal(super.getEntity("",entity.getDefiProvisionEmpleadoOriginal(),resultSet,DefiProvisionEmpleadoDataAccess.ISWITHSCHEMA));         		
					////entity.setDefiProvisionEmpleadoOriginal(this.getEntityDefiProvisionEmpleado("",entity.getDefiProvisionEmpleadoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDefiProvisionEmpleados(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDefiProvisionEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public DefiProvisionEmpleado getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DefiProvisionEmpleado entity = new DefiProvisionEmpleado();		  
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
	
	public  DefiProvisionEmpleado getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DefiProvisionEmpleado entity = new DefiProvisionEmpleado();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DefiProvisionEmpleado();
				
				if(conMapGenerico) {
					entity.inicializarMapDefiProvisionEmpleado();
					//entity.setMapDefiProvisionEmpleado(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapDefiProvisionEmpleadoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDefiProvisionEmpleado().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DefiProvisionEmpleadoDataAccess.ISWITHSCHEMA);         		
					entity=DefiProvisionEmpleadoDataAccess.getEntityDefiProvisionEmpleado("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDefiProvisionEmpleadoOriginal( new DefiProvisionEmpleado());
					////entity.setDefiProvisionEmpleadoOriginal(super.getEntity("",entity.getDefiProvisionEmpleadoOriginal(),resultSet,DefiProvisionEmpleadoDataAccess.ISWITHSCHEMA));         		
					////entity.setDefiProvisionEmpleadoOriginal(this.getEntityDefiProvisionEmpleado("",entity.getDefiProvisionEmpleadoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseDefiProvisionEmpleado(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDefiProvisionEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static DefiProvisionEmpleado getEntityDefiProvisionEmpleado(String strPrefijo,DefiProvisionEmpleado entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = DefiProvisionEmpleado.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = DefiProvisionEmpleado.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					DefiProvisionEmpleadoDataAccess.setFieldReflectionDefiProvisionEmpleado(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasDefiProvisionEmpleado=DefiProvisionEmpleadoConstantesFunciones.getTodosTiposColumnasDefiProvisionEmpleado();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasDefiProvisionEmpleado) {
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
							field = DefiProvisionEmpleado.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = DefiProvisionEmpleado.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						DefiProvisionEmpleadoDataAccess.setFieldReflectionDefiProvisionEmpleado(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionDefiProvisionEmpleado(Field field,String strPrefijo,String sColumn,DefiProvisionEmpleado entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case DefiProvisionEmpleadoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DefiProvisionEmpleadoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DefiProvisionEmpleadoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DefiProvisionEmpleadoConstantesFunciones.IDRUBROEMPLEA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DefiProvisionEmpleadoConstantesFunciones.IDFORMATO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DefiProvisionEmpleadoConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DefiProvisionEmpleadoConstantesFunciones.DIAINICIAL:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case DefiProvisionEmpleadoConstantesFunciones.IDMESINICIAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DefiProvisionEmpleadoConstantesFunciones.DIAFINAL:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case DefiProvisionEmpleadoConstantesFunciones.IDMESFINAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DefiProvisionEmpleadoConstantesFunciones.PARALIQUIDACION:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case DefiProvisionEmpleadoConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DefiProvisionEmpleado>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<DefiProvisionEmpleado> entities = new  ArrayList<DefiProvisionEmpleado>();
		DefiProvisionEmpleado entity = new DefiProvisionEmpleado();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DefiProvisionEmpleadoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DefiProvisionEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DefiProvisionEmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new DefiProvisionEmpleado();
					entity=super.getEntity("",entity,resultSet,DefiProvisionEmpleadoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityDefiProvisionEmpleado("",entity,resultSet);
					
					//entity.setDefiProvisionEmpleadoOriginal( new DefiProvisionEmpleado());
					//entity.setDefiProvisionEmpleadoOriginal(super.getEntity("",entity.getDefiProvisionEmpleadoOriginal(),resultSet,DefiProvisionEmpleadoDataAccess.ISWITHSCHEMA));         		
					//entity.setDefiProvisionEmpleadoOriginal(this.getEntityDefiProvisionEmpleado("",entity.getDefiProvisionEmpleadoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseDefiProvisionEmpleados(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDefiProvisionEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DefiProvisionEmpleado>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<DefiProvisionEmpleado> entities = new  ArrayList<DefiProvisionEmpleado>();
		DefiProvisionEmpleado entity = new DefiProvisionEmpleado();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DefiProvisionEmpleadoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DefiProvisionEmpleadoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DefiProvisionEmpleadoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<DefiProvisionEmpleado> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DefiProvisionEmpleado> entities = new  ArrayList<DefiProvisionEmpleado>();
		DefiProvisionEmpleado entity = new DefiProvisionEmpleado();		  
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
	
	public  List<DefiProvisionEmpleado> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DefiProvisionEmpleado> entities = new  ArrayList<DefiProvisionEmpleado>();
		DefiProvisionEmpleado entity = new DefiProvisionEmpleado();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DefiProvisionEmpleado();
      	    	entity=super.getEntity("",entity,resultSet,DefiProvisionEmpleadoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDefiProvisionEmpleado("",entity,resultSet);
      	    	
				//entity.setDefiProvisionEmpleadoOriginal( new DefiProvisionEmpleado());
      	    	//entity.setDefiProvisionEmpleadoOriginal(super.getEntity("",entity.getDefiProvisionEmpleadoOriginal(),resultSet,DefiProvisionEmpleadoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDefiProvisionEmpleadoOriginal(this.getEntityDefiProvisionEmpleado("",entity.getDefiProvisionEmpleadoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseDefiProvisionEmpleados(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDefiProvisionEmpleado(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DefiProvisionEmpleado> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DefiProvisionEmpleado> entities = new  ArrayList<DefiProvisionEmpleado>();
		DefiProvisionEmpleado entity = new DefiProvisionEmpleado();		  
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
	
	public  List<DefiProvisionEmpleado> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DefiProvisionEmpleado> entities = new  ArrayList<DefiProvisionEmpleado>();
		DefiProvisionEmpleado entity = new DefiProvisionEmpleado();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DefiProvisionEmpleado();
      	    	entity=super.getEntity("",entity,resultSet,DefiProvisionEmpleadoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDefiProvisionEmpleado("",entity,resultSet);
      	    	
				//entity.setDefiProvisionEmpleadoOriginal( new DefiProvisionEmpleado());
      	    	//entity.setDefiProvisionEmpleadoOriginal(super.getEntity("",entity.getDefiProvisionEmpleadoOriginal(),resultSet,DefiProvisionEmpleadoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDefiProvisionEmpleadoOriginal(this.getEntityDefiProvisionEmpleado("",entity.getDefiProvisionEmpleadoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDefiProvisionEmpleados(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public DefiProvisionEmpleado getEntityDefiProvisionEmpleado(String strPrefijo,DefiProvisionEmpleado entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+DefiProvisionEmpleadoConstantesFunciones.IDEMPRESA));
				entity.setid_rubro_emplea(resultSet.getLong(strPrefijo+DefiProvisionEmpleadoConstantesFunciones.IDRUBROEMPLEA));
				entity.setid_formato(resultSet.getLong(strPrefijo+DefiProvisionEmpleadoConstantesFunciones.IDFORMATO));
				entity.setnombre(resultSet.getString(strPrefijo+DefiProvisionEmpleadoConstantesFunciones.NOMBRE));
				entity.setdia_inicial(resultSet.getInt(strPrefijo+DefiProvisionEmpleadoConstantesFunciones.DIAINICIAL));
				entity.setid_mes_inicial(resultSet.getLong(strPrefijo+DefiProvisionEmpleadoConstantesFunciones.IDMESINICIAL));
				entity.setdia_final(resultSet.getInt(strPrefijo+DefiProvisionEmpleadoConstantesFunciones.DIAFINAL));
				entity.setid_mes_final(resultSet.getLong(strPrefijo+DefiProvisionEmpleadoConstantesFunciones.IDMESFINAL));
				entity.setpara_liquidacion(resultSet.getBoolean(strPrefijo+DefiProvisionEmpleadoConstantesFunciones.PARALIQUIDACION));
				entity.setdescripcion(resultSet.getString(strPrefijo+DefiProvisionEmpleadoConstantesFunciones.DESCRIPCION));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+DefiProvisionEmpleadoConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowDefiProvisionEmpleado(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(DefiProvisionEmpleado entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=DefiProvisionEmpleadoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=DefiProvisionEmpleadoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=DefiProvisionEmpleadoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=DefiProvisionEmpleadoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(DefiProvisionEmpleadoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,DefiProvisionEmpleadoDataAccess.TABLENAME,DefiProvisionEmpleadoDataAccess.ISWITHSTOREPROCEDURES);
			
			DefiProvisionEmpleadoDataAccess.setDefiProvisionEmpleadoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,DefiProvisionEmpleado reldefiprovisionempleado)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reldefiprovisionempleado.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public RubroEmplea getRubroEmplea(Connexion connexion,DefiProvisionEmpleado reldefiprovisionempleado)throws SQLException,Exception {

		RubroEmplea rubroemplea= new RubroEmplea();

		try {
			RubroEmpleaDataAccess rubroempleaDataAccess=new RubroEmpleaDataAccess();

			rubroempleaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			rubroempleaDataAccess.setConnexionType(this.connexionType);
			rubroempleaDataAccess.setParameterDbType(this.parameterDbType);

			rubroemplea=rubroempleaDataAccess.getEntity(connexion,reldefiprovisionempleado.getid_rubro_emplea());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return rubroemplea;

	}

	public Formato getFormato(Connexion connexion,DefiProvisionEmpleado reldefiprovisionempleado)throws SQLException,Exception {

		Formato formato= new Formato();

		try {
			FormatoDataAccess formatoDataAccess=new FormatoDataAccess();

			formatoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			formatoDataAccess.setConnexionType(this.connexionType);
			formatoDataAccess.setParameterDbType(this.parameterDbType);

			formato=formatoDataAccess.getEntity(connexion,reldefiprovisionempleado.getid_formato());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formato;

	}

	public Mes getMesInicial(Connexion connexion,DefiProvisionEmpleado reldefiprovisionempleado)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,reldefiprovisionempleado.getid_mes_inicial());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}

	public Mes getMesFinal(Connexion connexion,DefiProvisionEmpleado reldefiprovisionempleado)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,reldefiprovisionempleado.getid_mes_final());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}


		
		public List<ProvisionEmpleado> getProvisionEmpleados(Connexion connexion,DefiProvisionEmpleado defiprovisionempleado)throws SQLException,Exception {

		List<ProvisionEmpleado> provisionempleados= new ArrayList<ProvisionEmpleado>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+DefiProvisionEmpleadoConstantesFunciones.SCHEMA+".defi_provision_empleado ON "+ProvisionEmpleadoConstantesFunciones.SCHEMA+".provision_empleado.id_defi_provision_empleado="+DefiProvisionEmpleadoConstantesFunciones.SCHEMA+".defi_provision_empleado.id WHERE "+DefiProvisionEmpleadoConstantesFunciones.SCHEMA+".defi_provision_empleado.id="+String.valueOf(defiprovisionempleado.getId());
			} else {
				sQuery=" INNER JOIN provisionempleado.DefiProvisionEmpleado WHERE provisionempleado.DefiProvisionEmpleado.id="+String.valueOf(defiprovisionempleado.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ProvisionEmpleadoDataAccess provisionempleadoDataAccess=new ProvisionEmpleadoDataAccess();

			provisionempleadoDataAccess.setConnexionType(this.connexionType);
			provisionempleadoDataAccess.setParameterDbType(this.parameterDbType);
			provisionempleados=provisionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return provisionempleados;

	}

	public List<Cuota> getCuotas(Connexion connexion,DefiProvisionEmpleado defiprovisionempleado)throws SQLException,Exception {

		List<Cuota> cuotas= new ArrayList<Cuota>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+DefiProvisionEmpleadoConstantesFunciones.SCHEMA+".defi_provision_empleado ON "+CuotaConstantesFunciones.SCHEMA+".cuota.id_defi_provision_empleado="+DefiProvisionEmpleadoConstantesFunciones.SCHEMA+".defi_provision_empleado.id WHERE "+DefiProvisionEmpleadoConstantesFunciones.SCHEMA+".defi_provision_empleado.id="+String.valueOf(defiprovisionempleado.getId());
			} else {
				sQuery=" INNER JOIN cuota.DefiProvisionEmpleado WHERE cuota.DefiProvisionEmpleado.id="+String.valueOf(defiprovisionempleado.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			CuotaDataAccess cuotaDataAccess=new CuotaDataAccess();

			cuotaDataAccess.setConnexionType(this.connexionType);
			cuotaDataAccess.setParameterDbType(this.parameterDbType);
			cuotas=cuotaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuotas;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,DefiProvisionEmpleado defiprovisionempleado) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!defiprovisionempleado.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(defiprovisionempleado.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_rubro_emplea=new ParameterValue<Long>();
					parameterMaintenanceValueid_rubro_emplea.setValue(defiprovisionempleado.getid_rubro_emplea());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_rubro_emplea);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_formato=new ParameterValue<Long>();
					parameterMaintenanceValueid_formato.setValue(defiprovisionempleado.getid_formato());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_formato);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(defiprovisionempleado.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuedia_inicial=new ParameterValue<Integer>();
					parameterMaintenanceValuedia_inicial.setValue(defiprovisionempleado.getdia_inicial());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedia_inicial);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes_inicial=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes_inicial.setValue(defiprovisionempleado.getid_mes_inicial());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes_inicial);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuedia_final=new ParameterValue<Integer>();
					parameterMaintenanceValuedia_final.setValue(defiprovisionempleado.getdia_final());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedia_final);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes_final=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes_final.setValue(defiprovisionempleado.getid_mes_final());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes_final);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuepara_liquidacion=new ParameterValue<Boolean>();
					parameterMaintenanceValuepara_liquidacion.setValue(defiprovisionempleado.getpara_liquidacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuepara_liquidacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(defiprovisionempleado.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!defiprovisionempleado.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(defiprovisionempleado.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(defiprovisionempleado.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(defiprovisionempleado.getId());
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
	
	public void setIsNewIsChangedFalseDefiProvisionEmpleado(DefiProvisionEmpleado defiprovisionempleado)throws Exception  {		
		defiprovisionempleado.setIsNew(false);
		defiprovisionempleado.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseDefiProvisionEmpleados(List<DefiProvisionEmpleado> defiprovisionempleados)throws Exception  {				
		for(DefiProvisionEmpleado defiprovisionempleado:defiprovisionempleados) {
			defiprovisionempleado.setIsNew(false);
			defiprovisionempleado.setIsChanged(false);
		}
	}
	
	public void generarExportarDefiProvisionEmpleado(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
