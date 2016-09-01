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
import com.bydan.erp.nomina.util.*;//EstructuraConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.activosfijos.util.*;




@SuppressWarnings("unused")
final public class EstructuraDataAccess extends  EstructuraDataAccessAdditional{ //EstructuraDataAccessAdditional,DataAccessHelper<Estructura>
	//static Logger logger = Logger.getLogger(EstructuraDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="estructura";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+EstructuraConstantesFunciones.SCHEMA+"."+EstructuraConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_estructura,id_tipo_pago__n_m,id_numero_patronal,id_cuenta_contable,id_tipo_estructura,id_pais,id_ciudad,codigo,numero,valor_anticipo,porcentaje_anticipo,nombre,es_jefe,es_anual,porcentaje,valor)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+EstructuraConstantesFunciones.SCHEMA+"."+EstructuraConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_estructura=?,id_tipo_pago__n_m=?,id_numero_patronal=?,id_cuenta_contable=?,id_tipo_estructura=?,id_pais=?,id_ciudad=?,codigo=?,numero=?,valor_anticipo=?,porcentaje_anticipo=?,nombre=?,es_jefe=?,es_anual=?,porcentaje=?,valor=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+EstructuraConstantesFunciones.SCHEMA+"."+EstructuraConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select estructura from "+EstructuraConstantesFunciones.SPERSISTENCENAME+" estructura";
	public static String QUERYSELECTNATIVE="select "+EstructuraConstantesFunciones.SCHEMA+"."+EstructuraConstantesFunciones.TABLENAME+".id,"+EstructuraConstantesFunciones.SCHEMA+"."+EstructuraConstantesFunciones.TABLENAME+".version_row,"+EstructuraConstantesFunciones.SCHEMA+"."+EstructuraConstantesFunciones.TABLENAME+".id_empresa,"+EstructuraConstantesFunciones.SCHEMA+"."+EstructuraConstantesFunciones.TABLENAME+".id_sucursal,"+EstructuraConstantesFunciones.SCHEMA+"."+EstructuraConstantesFunciones.TABLENAME+".id_estructura,"+EstructuraConstantesFunciones.SCHEMA+"."+EstructuraConstantesFunciones.TABLENAME+".id_tipo_pago__n_m,"+EstructuraConstantesFunciones.SCHEMA+"."+EstructuraConstantesFunciones.TABLENAME+".id_numero_patronal,"+EstructuraConstantesFunciones.SCHEMA+"."+EstructuraConstantesFunciones.TABLENAME+".id_cuenta_contable,"+EstructuraConstantesFunciones.SCHEMA+"."+EstructuraConstantesFunciones.TABLENAME+".id_tipo_estructura,"+EstructuraConstantesFunciones.SCHEMA+"."+EstructuraConstantesFunciones.TABLENAME+".id_pais,"+EstructuraConstantesFunciones.SCHEMA+"."+EstructuraConstantesFunciones.TABLENAME+".id_ciudad,"+EstructuraConstantesFunciones.SCHEMA+"."+EstructuraConstantesFunciones.TABLENAME+".codigo,"+EstructuraConstantesFunciones.SCHEMA+"."+EstructuraConstantesFunciones.TABLENAME+".numero,"+EstructuraConstantesFunciones.SCHEMA+"."+EstructuraConstantesFunciones.TABLENAME+".valor_anticipo,"+EstructuraConstantesFunciones.SCHEMA+"."+EstructuraConstantesFunciones.TABLENAME+".porcentaje_anticipo,"+EstructuraConstantesFunciones.SCHEMA+"."+EstructuraConstantesFunciones.TABLENAME+".nombre,"+EstructuraConstantesFunciones.SCHEMA+"."+EstructuraConstantesFunciones.TABLENAME+".es_jefe,"+EstructuraConstantesFunciones.SCHEMA+"."+EstructuraConstantesFunciones.TABLENAME+".es_anual,"+EstructuraConstantesFunciones.SCHEMA+"."+EstructuraConstantesFunciones.TABLENAME+".porcentaje,"+EstructuraConstantesFunciones.SCHEMA+"."+EstructuraConstantesFunciones.TABLENAME+".valor from "+EstructuraConstantesFunciones.SCHEMA+"."+EstructuraConstantesFunciones.TABLENAME;//+" as "+EstructuraConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+EstructuraConstantesFunciones.SCHEMA+"."+EstructuraConstantesFunciones.TABLENAME+".id,"+EstructuraConstantesFunciones.SCHEMA+"."+EstructuraConstantesFunciones.TABLENAME+".version_row,"+EstructuraConstantesFunciones.SCHEMA+"."+EstructuraConstantesFunciones.TABLENAME+".codigo,"+EstructuraConstantesFunciones.SCHEMA+"."+EstructuraConstantesFunciones.TABLENAME+".nombre from "+EstructuraConstantesFunciones.SCHEMA+"."+EstructuraConstantesFunciones.TABLENAME;//+" as "+EstructuraConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+EstructuraConstantesFunciones.SCHEMA+"."+EstructuraConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_estructura=?,id_tipo_pago__n_m=?,id_numero_patronal=?,id_cuenta_contable=?,id_tipo_estructura=?,id_pais=?,id_ciudad=?,codigo=?,numero=?,valor_anticipo=?,porcentaje_anticipo=?,nombre=?,es_jefe=?,es_anual=?,porcentaje=?,valor=?";
	
	public static String STOREPROCEDUREINSERT="call SP_ESTRUCTURA_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_ESTRUCTURA_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_ESTRUCTURA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_ESTRUCTURA_SELECT(?,?)";
	
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
	
	
	protected EstructuraDataAccessAdditional estructuraDataAccessAdditional=null;
	
	public EstructuraDataAccessAdditional getEstructuraDataAccessAdditional() {
		return this.estructuraDataAccessAdditional;
	}
	
	public void setEstructuraDataAccessAdditional(EstructuraDataAccessAdditional estructuraDataAccessAdditional) {
		try {
			this.estructuraDataAccessAdditional=estructuraDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public EstructuraDataAccess() {
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
		EstructuraDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		EstructuraDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		EstructuraDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setEstructuraOriginal(Estructura estructura)throws Exception  {
		estructura.setEstructuraOriginal((Estructura)estructura.clone());		
	}
	
	public void setEstructurasOriginal(List<Estructura> estructuras)throws Exception  {
		
		for(Estructura estructura:estructuras){
			estructura.setEstructuraOriginal((Estructura)estructura.clone());
		}
	}
	
	public static void setEstructuraOriginalStatic(Estructura estructura)throws Exception  {
		estructura.setEstructuraOriginal((Estructura)estructura.clone());		
	}
	
	public static void setEstructurasOriginalStatic(List<Estructura> estructuras)throws Exception  {
		
		for(Estructura estructura:estructuras){
			estructura.setEstructuraOriginal((Estructura)estructura.clone());
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
	
	public  Estructura getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		Estructura entity = new Estructura();		
		
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
	
	public  Estructura getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		Estructura entity = new Estructura();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EstructuraDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstructuraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.Estructura.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setEstructuraOriginal(new Estructura());
      	    	entity=super.getEntity("",entity,resultSet,EstructuraDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEstructura("",entity,resultSet); 
				
				//entity.setEstructuraOriginal(super.getEntity("",entity.getEstructuraOriginal(),resultSet,EstructuraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstructuraOriginal(this.getEntityEstructura("",entity.getEstructuraOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseEstructura(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  Estructura getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Estructura entity = new Estructura();
				
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
	
	public  Estructura getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Estructura entity = new Estructura();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EstructuraDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstructuraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EstructuraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.Estructura.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setEstructuraOriginal(new Estructura());
      	    	entity=super.getEntity("",entity,resultSet,EstructuraDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEstructura("",entity,resultSet);    
				
				//entity.setEstructuraOriginal(super.getEntity("",entity.getEstructuraOriginal(),resultSet,EstructuraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstructuraOriginal(this.getEntityEstructura("",entity.getEstructuraOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseEstructura(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //Estructura
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		Estructura entity = new Estructura();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstructuraDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstructuraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EstructuraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.Estructura.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseEstructura(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<Estructura> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Estructura> entities = new  ArrayList<Estructura>();
		Estructura entity = new Estructura();		  
		
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
	
	public  List<Estructura> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Estructura> entities = new  ArrayList<Estructura>();
		Estructura entity = new Estructura();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=EstructuraDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstructuraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EstructuraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Estructura();
      	    	entity=super.getEntity("",entity,resultSet,EstructuraDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstructura("",entity,resultSet);
      	    	
				//entity.setEstructuraOriginal( new Estructura());
      	    	//entity.setEstructuraOriginal(super.getEntity("",entity.getEstructuraOriginal(),resultSet,EstructuraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstructuraOriginal(this.getEntityEstructura("",entity.getEstructuraOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstructuras(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstructura(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Estructura> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Estructura> entities = new  ArrayList<Estructura>();
		Estructura entity = new Estructura();		  
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
	
	public  List<Estructura> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Estructura> entities = new  ArrayList<Estructura>();
		Estructura entity = new Estructura();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Estructura();
				
				if(conMapGenerico) {
					entity.inicializarMapEstructura();
					//entity.setMapEstructura(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapEstructuraValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEstructura().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EstructuraDataAccess.ISWITHSCHEMA);         		
					entity=EstructuraDataAccess.getEntityEstructura("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEstructuraOriginal( new Estructura());
					////entity.setEstructuraOriginal(super.getEntity("",entity.getEstructuraOriginal(),resultSet,EstructuraDataAccess.ISWITHSCHEMA));         		
					////entity.setEstructuraOriginal(this.getEntityEstructura("",entity.getEstructuraOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstructuras(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstructura(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public Estructura getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Estructura entity = new Estructura();		  
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
	
	public  Estructura getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Estructura entity = new Estructura();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Estructura();
				
				if(conMapGenerico) {
					entity.inicializarMapEstructura();
					//entity.setMapEstructura(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapEstructuraValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEstructura().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EstructuraDataAccess.ISWITHSCHEMA);         		
					entity=EstructuraDataAccess.getEntityEstructura("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEstructuraOriginal( new Estructura());
					////entity.setEstructuraOriginal(super.getEntity("",entity.getEstructuraOriginal(),resultSet,EstructuraDataAccess.ISWITHSCHEMA));         		
					////entity.setEstructuraOriginal(this.getEntityEstructura("",entity.getEstructuraOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseEstructura(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstructura(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static Estructura getEntityEstructura(String strPrefijo,Estructura entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = Estructura.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = Estructura.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					EstructuraDataAccess.setFieldReflectionEstructura(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasEstructura=EstructuraConstantesFunciones.getTodosTiposColumnasEstructura();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasEstructura) {
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
							field = Estructura.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = Estructura.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						EstructuraDataAccess.setFieldReflectionEstructura(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionEstructura(Field field,String strPrefijo,String sColumn,Estructura entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case EstructuraConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EstructuraConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EstructuraConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EstructuraConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EstructuraConstantesFunciones.IDESTRUCTURA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EstructuraConstantesFunciones.IDTIPOPAGO_NM:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EstructuraConstantesFunciones.IDNUMEROPATRONAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EstructuraConstantesFunciones.IDCUENTACONTABLE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EstructuraConstantesFunciones.IDTIPOESTRUCTURA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EstructuraConstantesFunciones.IDPAIS:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EstructuraConstantesFunciones.IDCIUDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EstructuraConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EstructuraConstantesFunciones.NUMERO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EstructuraConstantesFunciones.VALORANTICIPO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case EstructuraConstantesFunciones.PORCENTAJEANTICIPO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case EstructuraConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EstructuraConstantesFunciones.ESJEFE:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case EstructuraConstantesFunciones.ESANUAL:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case EstructuraConstantesFunciones.PORCENTAJE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case EstructuraConstantesFunciones.VALOR:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Estructura>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<Estructura> entities = new  ArrayList<Estructura>();
		Estructura entity = new Estructura();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstructuraDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstructuraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EstructuraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new Estructura();
					entity=super.getEntity("",entity,resultSet,EstructuraDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityEstructura("",entity,resultSet);
					
					//entity.setEstructuraOriginal( new Estructura());
					//entity.setEstructuraOriginal(super.getEntity("",entity.getEstructuraOriginal(),resultSet,EstructuraDataAccess.ISWITHSCHEMA));         		
					//entity.setEstructuraOriginal(this.getEntityEstructura("",entity.getEstructuraOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseEstructuras(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstructura(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Estructura>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<Estructura> entities = new  ArrayList<Estructura>();
		Estructura entity = new Estructura();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstructuraDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstructuraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EstructuraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<Estructura> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Estructura> entities = new  ArrayList<Estructura>();
		Estructura entity = new Estructura();		  
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
	
	public  List<Estructura> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Estructura> entities = new  ArrayList<Estructura>();
		Estructura entity = new Estructura();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Estructura();
      	    	entity=super.getEntity("",entity,resultSet,EstructuraDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstructura("",entity,resultSet);
      	    	
				//entity.setEstructuraOriginal( new Estructura());
      	    	//entity.setEstructuraOriginal(super.getEntity("",entity.getEstructuraOriginal(),resultSet,EstructuraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstructuraOriginal(this.getEntityEstructura("",entity.getEstructuraOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseEstructuras(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstructura(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Estructura> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Estructura> entities = new  ArrayList<Estructura>();
		Estructura entity = new Estructura();		  
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
	
	public  List<Estructura> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Estructura> entities = new  ArrayList<Estructura>();
		Estructura entity = new Estructura();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Estructura();
      	    	entity=super.getEntity("",entity,resultSet,EstructuraDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstructura("",entity,resultSet);
      	    	
				//entity.setEstructuraOriginal( new Estructura());
      	    	//entity.setEstructuraOriginal(super.getEntity("",entity.getEstructuraOriginal(),resultSet,EstructuraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstructuraOriginal(this.getEntityEstructura("",entity.getEstructuraOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstructuras(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public Estructura getEntityEstructura(String strPrefijo,Estructura entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+EstructuraConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+EstructuraConstantesFunciones.IDSUCURSAL));
				entity.setid_estructura(resultSet.getLong(strPrefijo+EstructuraConstantesFunciones.IDESTRUCTURA));if(resultSet.wasNull()) {entity.setid_estructura(null); }
				entity.setid_tipo_pago__n_m(resultSet.getLong(strPrefijo+EstructuraConstantesFunciones.IDTIPOPAGO_NM));
				entity.setid_numero_patronal(resultSet.getLong(strPrefijo+EstructuraConstantesFunciones.IDNUMEROPATRONAL));
				entity.setid_cuenta_contable(resultSet.getLong(strPrefijo+EstructuraConstantesFunciones.IDCUENTACONTABLE));
				entity.setid_tipo_estructura(resultSet.getLong(strPrefijo+EstructuraConstantesFunciones.IDTIPOESTRUCTURA));
				entity.setid_pais(resultSet.getLong(strPrefijo+EstructuraConstantesFunciones.IDPAIS));
				entity.setid_ciudad(resultSet.getLong(strPrefijo+EstructuraConstantesFunciones.IDCIUDAD));
				entity.setcodigo(resultSet.getString(strPrefijo+EstructuraConstantesFunciones.CODIGO));
				entity.setnumero(resultSet.getString(strPrefijo+EstructuraConstantesFunciones.NUMERO));
				entity.setvalor_anticipo(resultSet.getDouble(strPrefijo+EstructuraConstantesFunciones.VALORANTICIPO));
				entity.setporcentaje_anticipo(resultSet.getDouble(strPrefijo+EstructuraConstantesFunciones.PORCENTAJEANTICIPO));
				entity.setnombre(resultSet.getString(strPrefijo+EstructuraConstantesFunciones.NOMBRE));
				entity.setes_jefe(resultSet.getBoolean(strPrefijo+EstructuraConstantesFunciones.ESJEFE));
				entity.setes_anual(resultSet.getBoolean(strPrefijo+EstructuraConstantesFunciones.ESANUAL));
				entity.setporcentaje(resultSet.getDouble(strPrefijo+EstructuraConstantesFunciones.PORCENTAJE));
				entity.setvalor(resultSet.getDouble(strPrefijo+EstructuraConstantesFunciones.VALOR));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+EstructuraConstantesFunciones.CODIGO));entity.setnombre(resultSet.getString(strPrefijo+EstructuraConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowEstructura(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(Estructura entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=EstructuraDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=EstructuraDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=EstructuraDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=EstructuraDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(EstructuraConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,EstructuraDataAccess.TABLENAME,EstructuraDataAccess.ISWITHSTOREPROCEDURES);
			
			EstructuraDataAccess.setEstructuraOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,Estructura relestructura)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relestructura.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,Estructura relestructura)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relestructura.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Estructura getEstructura(Connexion connexion,Estructura relestructura)throws SQLException,Exception {

		Estructura estructura= new Estructura();

		try {
			EstructuraDataAccess estructuraDataAccess=new EstructuraDataAccess();

			estructuraDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estructuraDataAccess.setConnexionType(this.connexionType);
			estructuraDataAccess.setParameterDbType(this.parameterDbType);

			estructura=estructuraDataAccess.getEntity(connexion,relestructura.getid_estructura());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estructura;

	}

	public TipoPago_NM getTipoPago_NM(Connexion connexion,Estructura relestructura)throws SQLException,Exception {

		TipoPago_NM tipopago_nm= new TipoPago_NM();

		try {
			TipoPago_NMDataAccess tipopago_nmDataAccess=new TipoPago_NMDataAccess();

			tipopago_nmDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipopago_nmDataAccess.setConnexionType(this.connexionType);
			tipopago_nmDataAccess.setParameterDbType(this.parameterDbType);

			tipopago_nm=tipopago_nmDataAccess.getEntity(connexion,relestructura.getid_tipo_pago__n_m());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipopago_nm;

	}

	public NumeroPatronal getNumeroPatronal(Connexion connexion,Estructura relestructura)throws SQLException,Exception {

		NumeroPatronal numeropatronal= new NumeroPatronal();

		try {
			NumeroPatronalDataAccess numeropatronalDataAccess=new NumeroPatronalDataAccess();

			numeropatronalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			numeropatronalDataAccess.setConnexionType(this.connexionType);
			numeropatronalDataAccess.setParameterDbType(this.parameterDbType);

			numeropatronal=numeropatronalDataAccess.getEntity(connexion,relestructura.getid_numero_patronal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return numeropatronal;

	}

	public CuentaContable getCuentaContable(Connexion connexion,Estructura relestructura)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relestructura.getid_cuenta_contable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public TipoEstructura getTipoEstructura(Connexion connexion,Estructura relestructura)throws SQLException,Exception {

		TipoEstructura tipoestructura= new TipoEstructura();

		try {
			TipoEstructuraDataAccess tipoestructuraDataAccess=new TipoEstructuraDataAccess();

			tipoestructuraDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoestructuraDataAccess.setConnexionType(this.connexionType);
			tipoestructuraDataAccess.setParameterDbType(this.parameterDbType);

			tipoestructura=tipoestructuraDataAccess.getEntity(connexion,relestructura.getid_tipo_estructura());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoestructura;

	}

	public Pais getPais(Connexion connexion,Estructura relestructura)throws SQLException,Exception {

		Pais pais= new Pais();

		try {
			PaisDataAccess paisDataAccess=new PaisDataAccess();

			paisDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			paisDataAccess.setConnexionType(this.connexionType);
			paisDataAccess.setParameterDbType(this.parameterDbType);

			pais=paisDataAccess.getEntity(connexion,relestructura.getid_pais());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pais;

	}

	public Ciudad getCiudad(Connexion connexion,Estructura relestructura)throws SQLException,Exception {

		Ciudad ciudad= new Ciudad();

		try {
			CiudadDataAccess ciudadDataAccess=new CiudadDataAccess();

			ciudadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ciudadDataAccess.setConnexionType(this.connexionType);
			ciudadDataAccess.setParameterDbType(this.parameterDbType);

			ciudad=ciudadDataAccess.getEntity(connexion,relestructura.getid_ciudad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ciudad;

	}


		
		public List<CentroCostoEstructura> getCentroCostoEstructuras(Connexion connexion,Estructura estructura)throws SQLException,Exception {

		List<CentroCostoEstructura> centrocostoestructuras= new ArrayList<CentroCostoEstructura>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstructuraConstantesFunciones.SCHEMA+".estructura ON "+CentroCostoEstructuraConstantesFunciones.SCHEMA+".centro_costo_estructura.id_estructura="+EstructuraConstantesFunciones.SCHEMA+".estructura.id WHERE "+EstructuraConstantesFunciones.SCHEMA+".estructura.id="+String.valueOf(estructura.getId());
			} else {
				sQuery=" INNER JOIN centrocostoestructura.Estructura WHERE centrocostoestructura.Estructura.id="+String.valueOf(estructura.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			CentroCostoEstructuraDataAccess centrocostoestructuraDataAccess=new CentroCostoEstructuraDataAccess();

			centrocostoestructuraDataAccess.setConnexionType(this.connexionType);
			centrocostoestructuraDataAccess.setParameterDbType(this.parameterDbType);
			centrocostoestructuras=centrocostoestructuraDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return centrocostoestructuras;

	}

	public List<PlaniVacacion> getPlaniVacacionCargos(Connexion connexion,Estructura estructura)throws SQLException,Exception {

		List<PlaniVacacion> planivacacioncargos= new ArrayList<PlaniVacacion>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstructuraConstantesFunciones.SCHEMA+".estructura ON "+PlaniVacacionConstantesFunciones.SCHEMA+".plani_vacacion.id_estructura="+EstructuraConstantesFunciones.SCHEMA+".estructura.id WHERE "+EstructuraConstantesFunciones.SCHEMA+".estructura.id="+String.valueOf(estructura.getId());
			} else {
				sQuery=" INNER JOIN planivacacion.EstructuraCargo WHERE planivacacion.EstructuraCargo.id="+String.valueOf(estructura.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PlaniVacacionDataAccess planivacacionDataAccess=new PlaniVacacionDataAccess();

			planivacacionDataAccess.setConnexionType(this.connexionType);
			planivacacionDataAccess.setParameterDbType(this.parameterDbType);
			planivacacioncargos=planivacacionDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return planivacacioncargos;

	}

	public List<AsistenciaMensual> getAsistenciaMensuals(Connexion connexion,Estructura estructura)throws SQLException,Exception {

		List<AsistenciaMensual> asistenciamensuals= new ArrayList<AsistenciaMensual>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstructuraConstantesFunciones.SCHEMA+".estructura ON "+AsistenciaMensualConstantesFunciones.SCHEMA+".asistencia_mensual.id_estructura="+EstructuraConstantesFunciones.SCHEMA+".estructura.id WHERE "+EstructuraConstantesFunciones.SCHEMA+".estructura.id="+String.valueOf(estructura.getId());
			} else {
				sQuery=" INNER JOIN asistenciamensual.Estructura WHERE asistenciamensual.Estructura.id="+String.valueOf(estructura.getId());

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

	public List<EmpleadoProcesoRubro> getEmpleadoProcesoRubros(Connexion connexion,Estructura estructura)throws SQLException,Exception {

		List<EmpleadoProcesoRubro> empleadoprocesorubros= new ArrayList<EmpleadoProcesoRubro>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstructuraConstantesFunciones.SCHEMA+".estructura ON "+EmpleadoProcesoRubroConstantesFunciones.SCHEMA+".empleado_proceso_rubro.id_estructura="+EstructuraConstantesFunciones.SCHEMA+".estructura.id WHERE "+EstructuraConstantesFunciones.SCHEMA+".estructura.id="+String.valueOf(estructura.getId());
			} else {
				sQuery=" INNER JOIN empleadoprocesorubro.Estructura WHERE empleadoprocesorubro.Estructura.id="+String.valueOf(estructura.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			EmpleadoProcesoRubroDataAccess empleadoprocesorubroDataAccess=new EmpleadoProcesoRubroDataAccess();

			empleadoprocesorubroDataAccess.setConnexionType(this.connexionType);
			empleadoprocesorubroDataAccess.setParameterDbType(this.parameterDbType);
			empleadoprocesorubros=empleadoprocesorubroDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleadoprocesorubros;

	}

	public List<EmpleadoPagoRubro> getEmpleadoPagoRubros(Connexion connexion,Estructura estructura)throws SQLException,Exception {

		List<EmpleadoPagoRubro> empleadopagorubros= new ArrayList<EmpleadoPagoRubro>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstructuraConstantesFunciones.SCHEMA+".estructura ON "+EmpleadoPagoRubroConstantesFunciones.SCHEMA+".empleado_pago_rubro.id_estructura="+EstructuraConstantesFunciones.SCHEMA+".estructura.id WHERE "+EstructuraConstantesFunciones.SCHEMA+".estructura.id="+String.valueOf(estructura.getId());
			} else {
				sQuery=" INNER JOIN empleadopagorubro.Estructura WHERE empleadopagorubro.Estructura.id="+String.valueOf(estructura.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			EmpleadoPagoRubroDataAccess empleadopagorubroDataAccess=new EmpleadoPagoRubroDataAccess();

			empleadopagorubroDataAccess.setConnexionType(this.connexionType);
			empleadopagorubroDataAccess.setParameterDbType(this.parameterDbType);
			empleadopagorubros=empleadopagorubroDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleadopagorubros;

	}

	public List<ProvisionEmpleado> getProvisionEmpleados(Connexion connexion,Estructura estructura)throws SQLException,Exception {

		List<ProvisionEmpleado> provisionempleados= new ArrayList<ProvisionEmpleado>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstructuraConstantesFunciones.SCHEMA+".estructura ON "+ProvisionEmpleadoConstantesFunciones.SCHEMA+".provision_empleado.id_estructura="+EstructuraConstantesFunciones.SCHEMA+".estructura.id WHERE "+EstructuraConstantesFunciones.SCHEMA+".estructura.id="+String.valueOf(estructura.getId());
			} else {
				sQuery=" INNER JOIN provisionempleado.Estructura WHERE provisionempleado.Estructura.id="+String.valueOf(estructura.getId());

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

	public List<Empleado> getEmpleados(Connexion connexion,Estructura estructura)throws SQLException,Exception {

		List<Empleado> empleados= new ArrayList<Empleado>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstructuraConstantesFunciones.SCHEMA+".estructura ON "+EmpleadoConstantesFunciones.SCHEMA+".empleado.id_estructura="+EstructuraConstantesFunciones.SCHEMA+".estructura.id WHERE "+EstructuraConstantesFunciones.SCHEMA+".estructura.id="+String.valueOf(estructura.getId());
			} else {
				sQuery=" INNER JOIN empleado.Estructura WHERE empleado.Estructura.id="+String.valueOf(estructura.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);
			empleados=empleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleados;

	}

	public List<Estructura> getEstructuras(Connexion connexion,Estructura estructura)throws SQLException,Exception {

		List<Estructura> estructuras= new ArrayList<Estructura>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstructuraConstantesFunciones.SCHEMA+".estructura ON "+EstructuraConstantesFunciones.SCHEMA+".estructura.id_estructura="+EstructuraConstantesFunciones.SCHEMA+".estructura.id WHERE "+EstructuraConstantesFunciones.SCHEMA+".estructura.id="+String.valueOf(estructura.getId());
			} else {
				sQuery=" INNER JOIN estructura.Estructura WHERE estructura.Estructura.id="+String.valueOf(estructura.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			EstructuraDataAccess estructuraDataAccess=new EstructuraDataAccess();

			estructuraDataAccess.setConnexionType(this.connexionType);
			estructuraDataAccess.setParameterDbType(this.parameterDbType);
			estructuras=estructuraDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estructuras;

	}

	public List<EvaluacionEmpleado> getEvaluacionEmpleados(Connexion connexion,Estructura estructura)throws SQLException,Exception {

		List<EvaluacionEmpleado> evaluacionempleados= new ArrayList<EvaluacionEmpleado>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstructuraConstantesFunciones.SCHEMA+".estructura ON "+EvaluacionEmpleadoConstantesFunciones.SCHEMA+".evaluacion_empleado.id_estructura="+EstructuraConstantesFunciones.SCHEMA+".estructura.id WHERE "+EstructuraConstantesFunciones.SCHEMA+".estructura.id="+String.valueOf(estructura.getId());
			} else {
				sQuery=" INNER JOIN evaluacionempleado.Estructura WHERE evaluacionempleado.Estructura.id="+String.valueOf(estructura.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			EvaluacionEmpleadoDataAccess evaluacionempleadoDataAccess=new EvaluacionEmpleadoDataAccess();

			evaluacionempleadoDataAccess.setConnexionType(this.connexionType);
			evaluacionempleadoDataAccess.setParameterDbType(this.parameterDbType);
			evaluacionempleados=evaluacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return evaluacionempleados;

	}

	public List<EmpleadoImpuestoRenta> getEmpleadoImpuestoRentas(Connexion connexion,Estructura estructura)throws SQLException,Exception {

		List<EmpleadoImpuestoRenta> empleadoimpuestorentas= new ArrayList<EmpleadoImpuestoRenta>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstructuraConstantesFunciones.SCHEMA+".estructura ON "+EmpleadoImpuestoRentaConstantesFunciones.SCHEMA+".empleado_impuesto_renta.id_estructura="+EstructuraConstantesFunciones.SCHEMA+".estructura.id WHERE "+EstructuraConstantesFunciones.SCHEMA+".estructura.id="+String.valueOf(estructura.getId());
			} else {
				sQuery=" INNER JOIN empleadoimpuestorenta.Estructura WHERE empleadoimpuestorenta.Estructura.id="+String.valueOf(estructura.getId());

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

	public List<RubroEstructura> getRubroEstructuras(Connexion connexion,Estructura estructura)throws SQLException,Exception {

		List<RubroEstructura> rubroestructuras= new ArrayList<RubroEstructura>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstructuraConstantesFunciones.SCHEMA+".estructura ON "+RubroEstructuraConstantesFunciones.SCHEMA+".rubro_estructura.id_estructura="+EstructuraConstantesFunciones.SCHEMA+".estructura.id WHERE "+EstructuraConstantesFunciones.SCHEMA+".estructura.id="+String.valueOf(estructura.getId());
			} else {
				sQuery=" INNER JOIN rubroestructura.Estructura WHERE rubroestructura.Estructura.id="+String.valueOf(estructura.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			RubroEstructuraDataAccess rubroestructuraDataAccess=new RubroEstructuraDataAccess();

			rubroestructuraDataAccess.setConnexionType(this.connexionType);
			rubroestructuraDataAccess.setParameterDbType(this.parameterDbType);
			rubroestructuras=rubroestructuraDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return rubroestructuras;

	}

	public List<CierreRolMensual> getCierreRolMensuals(Connexion connexion,Estructura estructura)throws SQLException,Exception {

		List<CierreRolMensual> cierrerolmensuals= new ArrayList<CierreRolMensual>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstructuraConstantesFunciones.SCHEMA+".estructura ON "+CierreRolMensualConstantesFunciones.SCHEMA+".cierre_rol_mensual.id_estructura="+EstructuraConstantesFunciones.SCHEMA+".estructura.id WHERE "+EstructuraConstantesFunciones.SCHEMA+".estructura.id="+String.valueOf(estructura.getId());
			} else {
				sQuery=" INNER JOIN cierrerolmensual.Estructura WHERE cierrerolmensual.Estructura.id="+String.valueOf(estructura.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			CierreRolMensualDataAccess cierrerolmensualDataAccess=new CierreRolMensualDataAccess();

			cierrerolmensualDataAccess.setConnexionType(this.connexionType);
			cierrerolmensualDataAccess.setParameterDbType(this.parameterDbType);
			cierrerolmensuals=cierrerolmensualDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cierrerolmensuals;

	}

	public List<FormatoNomi> getFormatoNomis(Connexion connexion,Estructura estructura)throws SQLException,Exception {

		List<FormatoNomi> formatonomis= new ArrayList<FormatoNomi>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstructuraConstantesFunciones.SCHEMA+".estructura ON "+FormatoNomiConstantesFunciones.SCHEMA+".formato_nomi.id_estructura="+EstructuraConstantesFunciones.SCHEMA+".estructura.id WHERE "+EstructuraConstantesFunciones.SCHEMA+".estructura.id="+String.valueOf(estructura.getId());
			} else {
				sQuery=" INNER JOIN formatonomi.Estructura WHERE formatonomi.Estructura.id="+String.valueOf(estructura.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			FormatoNomiDataAccess formatonomiDataAccess=new FormatoNomiDataAccess();

			formatonomiDataAccess.setConnexionType(this.connexionType);
			formatonomiDataAccess.setParameterDbType(this.parameterDbType);
			formatonomis=formatonomiDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formatonomis;

	}

	public List<EmpleadoEstructura> getEmpleadoEstructuras(Connexion connexion,Estructura estructura)throws SQLException,Exception {

		List<EmpleadoEstructura> empleadoestructuras= new ArrayList<EmpleadoEstructura>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstructuraConstantesFunciones.SCHEMA+".estructura ON "+EmpleadoEstructuraConstantesFunciones.SCHEMA+".empleado_estructura.id_estructura="+EstructuraConstantesFunciones.SCHEMA+".estructura.id WHERE "+EstructuraConstantesFunciones.SCHEMA+".estructura.id="+String.valueOf(estructura.getId());
			} else {
				sQuery=" INNER JOIN empleadoestructura.Estructura WHERE empleadoestructura.Estructura.id="+String.valueOf(estructura.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			EmpleadoEstructuraDataAccess empleadoestructuraDataAccess=new EmpleadoEstructuraDataAccess();

			empleadoestructuraDataAccess.setConnexionType(this.connexionType);
			empleadoestructuraDataAccess.setParameterDbType(this.parameterDbType);
			empleadoestructuras=empleadoestructuraDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleadoestructuras;

	}

	public List<HistorialPagoNomi> getHistorialPagoNomis(Connexion connexion,Estructura estructura)throws SQLException,Exception {

		List<HistorialPagoNomi> historialpagonomis= new ArrayList<HistorialPagoNomi>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstructuraConstantesFunciones.SCHEMA+".estructura ON "+HistorialPagoNomiConstantesFunciones.SCHEMA+".historial_pago_nomi.id_estructura="+EstructuraConstantesFunciones.SCHEMA+".estructura.id WHERE "+EstructuraConstantesFunciones.SCHEMA+".estructura.id="+String.valueOf(estructura.getId());
			} else {
				sQuery=" INNER JOIN historialpagonomi.Estructura WHERE historialpagonomi.Estructura.id="+String.valueOf(estructura.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			HistorialPagoNomiDataAccess historialpagonomiDataAccess=new HistorialPagoNomiDataAccess();

			historialpagonomiDataAccess.setConnexionType(this.connexionType);
			historialpagonomiDataAccess.setParameterDbType(this.parameterDbType);
			historialpagonomis=historialpagonomiDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return historialpagonomis;

	}

	public List<AsistenciaDiaria> getAsistenciaDiarias(Connexion connexion,Estructura estructura)throws SQLException,Exception {

		List<AsistenciaDiaria> asistenciadiarias= new ArrayList<AsistenciaDiaria>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstructuraConstantesFunciones.SCHEMA+".estructura ON "+AsistenciaDiariaConstantesFunciones.SCHEMA+".asistencia_diaria.id_estructura="+EstructuraConstantesFunciones.SCHEMA+".estructura.id WHERE "+EstructuraConstantesFunciones.SCHEMA+".estructura.id="+String.valueOf(estructura.getId());
			} else {
				sQuery=" INNER JOIN asistenciadiaria.Estructura WHERE asistenciadiaria.Estructura.id="+String.valueOf(estructura.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			AsistenciaDiariaDataAccess asistenciadiariaDataAccess=new AsistenciaDiariaDataAccess();

			asistenciadiariaDataAccess.setConnexionType(this.connexionType);
			asistenciadiariaDataAccess.setParameterDbType(this.parameterDbType);
			asistenciadiarias=asistenciadiariaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return asistenciadiarias;

	}

	public List<FuncionEstruc> getFuncionEstrucs(Connexion connexion,Estructura estructura)throws SQLException,Exception {

		List<FuncionEstruc> funcionestrucs= new ArrayList<FuncionEstruc>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstructuraConstantesFunciones.SCHEMA+".estructura ON "+FuncionEstrucConstantesFunciones.SCHEMA+".funcion_estruc.id_estructura="+EstructuraConstantesFunciones.SCHEMA+".estructura.id WHERE "+EstructuraConstantesFunciones.SCHEMA+".estructura.id="+String.valueOf(estructura.getId());
			} else {
				sQuery=" INNER JOIN funcionestruc.Estructura WHERE funcionestruc.Estructura.id="+String.valueOf(estructura.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			FuncionEstrucDataAccess funcionestrucDataAccess=new FuncionEstrucDataAccess();

			funcionestrucDataAccess.setConnexionType(this.connexionType);
			funcionestrucDataAccess.setParameterDbType(this.parameterDbType);
			funcionestrucs=funcionestrucDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return funcionestrucs;

	}

	public List<SolicitudReemplazo> getSolicitudReemplazos(Connexion connexion,Estructura estructura)throws SQLException,Exception {

		List<SolicitudReemplazo> solicitudreemplazos= new ArrayList<SolicitudReemplazo>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstructuraConstantesFunciones.SCHEMA+".estructura ON "+SolicitudReemplazoConstantesFunciones.SCHEMA+".solicitud_reemplazo.id_estructura="+EstructuraConstantesFunciones.SCHEMA+".estructura.id WHERE "+EstructuraConstantesFunciones.SCHEMA+".estructura.id="+String.valueOf(estructura.getId());
			} else {
				sQuery=" INNER JOIN solicitudreemplazo.Estructura WHERE solicitudreemplazo.Estructura.id="+String.valueOf(estructura.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			SolicitudReemplazoDataAccess solicitudreemplazoDataAccess=new SolicitudReemplazoDataAccess();

			solicitudreemplazoDataAccess.setConnexionType(this.connexionType);
			solicitudreemplazoDataAccess.setParameterDbType(this.parameterDbType);
			solicitudreemplazos=solicitudreemplazoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return solicitudreemplazos;

	}

	public List<SolicitudHoraExtra> getSolicitudHoraExtras(Connexion connexion,Estructura estructura)throws SQLException,Exception {

		List<SolicitudHoraExtra> solicitudhoraextras= new ArrayList<SolicitudHoraExtra>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstructuraConstantesFunciones.SCHEMA+".estructura ON "+SolicitudHoraExtraConstantesFunciones.SCHEMA+".solicitud_hora_extra.id_estructura="+EstructuraConstantesFunciones.SCHEMA+".estructura.id WHERE "+EstructuraConstantesFunciones.SCHEMA+".estructura.id="+String.valueOf(estructura.getId());
			} else {
				sQuery=" INNER JOIN solicitudhoraextra.Estructura WHERE solicitudhoraextra.Estructura.id="+String.valueOf(estructura.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			SolicitudHoraExtraDataAccess solicitudhoraextraDataAccess=new SolicitudHoraExtraDataAccess();

			solicitudhoraextraDataAccess.setConnexionType(this.connexionType);
			solicitudhoraextraDataAccess.setParameterDbType(this.parameterDbType);
			solicitudhoraextras=solicitudhoraextraDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return solicitudhoraextras;

	}

	public List<EvaluacionNomi> getEvaluacionNomis(Connexion connexion,Estructura estructura)throws SQLException,Exception {

		List<EvaluacionNomi> evaluacionnomis= new ArrayList<EvaluacionNomi>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstructuraConstantesFunciones.SCHEMA+".estructura ON "+EvaluacionNomiConstantesFunciones.SCHEMA+".evaluacion_nomi.id_estructura="+EstructuraConstantesFunciones.SCHEMA+".estructura.id WHERE "+EstructuraConstantesFunciones.SCHEMA+".estructura.id="+String.valueOf(estructura.getId());
			} else {
				sQuery=" INNER JOIN evaluacionnomi.Estructura WHERE evaluacionnomi.Estructura.id="+String.valueOf(estructura.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			EvaluacionNomiDataAccess evaluacionnomiDataAccess=new EvaluacionNomiDataAccess();

			evaluacionnomiDataAccess.setConnexionType(this.connexionType);
			evaluacionnomiDataAccess.setParameterDbType(this.parameterDbType);
			evaluacionnomis=evaluacionnomiDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return evaluacionnomis;

	}

	public List<SolicitudVacacion> getSolicitudVacacions(Connexion connexion,Estructura estructura)throws SQLException,Exception {

		List<SolicitudVacacion> solicitudvacacions= new ArrayList<SolicitudVacacion>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstructuraConstantesFunciones.SCHEMA+".estructura ON "+SolicitudVacacionConstantesFunciones.SCHEMA+".solicitud_vacacion.id_estructura="+EstructuraConstantesFunciones.SCHEMA+".estructura.id WHERE "+EstructuraConstantesFunciones.SCHEMA+".estructura.id="+String.valueOf(estructura.getId());
			} else {
				sQuery=" INNER JOIN solicitudvacacion.Estructura WHERE solicitudvacacion.Estructura.id="+String.valueOf(estructura.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			SolicitudVacacionDataAccess solicitudvacacionDataAccess=new SolicitudVacacionDataAccess();

			solicitudvacacionDataAccess.setConnexionType(this.connexionType);
			solicitudvacacionDataAccess.setParameterDbType(this.parameterDbType);
			solicitudvacacions=solicitudvacacionDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return solicitudvacacions;

	}

	public List<ResponsableActivoFijo> getResponsableActivoFijos(Connexion connexion,Estructura estructura)throws SQLException,Exception {

		List<ResponsableActivoFijo> responsableactivofijos= new ArrayList<ResponsableActivoFijo>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstructuraConstantesFunciones.SCHEMA+".estructura ON "+ResponsableActivoFijoConstantesFunciones.SCHEMA+".responsable_activo_fijo.id_estructura="+EstructuraConstantesFunciones.SCHEMA+".estructura.id WHERE "+EstructuraConstantesFunciones.SCHEMA+".estructura.id="+String.valueOf(estructura.getId());
			} else {
				sQuery=" INNER JOIN responsableactivofijo.Estructura WHERE responsableactivofijo.Estructura.id="+String.valueOf(estructura.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ResponsableActivoFijoDataAccess responsableactivofijoDataAccess=new ResponsableActivoFijoDataAccess();

			responsableactivofijoDataAccess.setConnexionType(this.connexionType);
			responsableactivofijoDataAccess.setParameterDbType(this.parameterDbType);
			responsableactivofijos=responsableactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return responsableactivofijos;

	}

	public List<RubroEmpleaCuentaContable> getRubroEmpleaCuentaContables(Connexion connexion,Estructura estructura)throws SQLException,Exception {

		List<RubroEmpleaCuentaContable> rubroempleacuentacontables= new ArrayList<RubroEmpleaCuentaContable>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstructuraConstantesFunciones.SCHEMA+".estructura ON "+RubroEmpleaCuentaContableConstantesFunciones.SCHEMA+".rubro_emplea_cuenta_contable.id_estructura="+EstructuraConstantesFunciones.SCHEMA+".estructura.id WHERE "+EstructuraConstantesFunciones.SCHEMA+".estructura.id="+String.valueOf(estructura.getId());
			} else {
				sQuery=" INNER JOIN rubroempleacuentacontable.Estructura WHERE rubroempleacuentacontable.Estructura.id="+String.valueOf(estructura.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			RubroEmpleaCuentaContableDataAccess rubroempleacuentacontableDataAccess=new RubroEmpleaCuentaContableDataAccess();

			rubroempleacuentacontableDataAccess.setConnexionType(this.connexionType);
			rubroempleacuentacontableDataAccess.setParameterDbType(this.parameterDbType);
			rubroempleacuentacontables=rubroempleacuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return rubroempleacuentacontables;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,Estructura estructura) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!estructura.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(estructura.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(estructura.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estructura=new ParameterValue<Long>();
					parameterMaintenanceValueid_estructura.setValue(estructura.getid_estructura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estructura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_pago__n_m=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_pago__n_m.setValue(estructura.getid_tipo_pago__n_m());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_pago__n_m);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_numero_patronal=new ParameterValue<Long>();
					parameterMaintenanceValueid_numero_patronal.setValue(estructura.getid_numero_patronal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_numero_patronal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable.setValue(estructura.getid_cuenta_contable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_estructura=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_estructura.setValue(estructura.getid_tipo_estructura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_estructura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_pais=new ParameterValue<Long>();
					parameterMaintenanceValueid_pais.setValue(estructura.getid_pais());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_pais);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ciudad=new ParameterValue<Long>();
					parameterMaintenanceValueid_ciudad.setValue(estructura.getid_ciudad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ciudad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(estructura.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero=new ParameterValue<String>();
					parameterMaintenanceValuenumero.setValue(estructura.getnumero());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_anticipo=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_anticipo.setValue(estructura.getvalor_anticipo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_anticipo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcentaje_anticipo=new ParameterValue<Double>();
					parameterMaintenanceValueporcentaje_anticipo.setValue(estructura.getporcentaje_anticipo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcentaje_anticipo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(estructura.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_jefe=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_jefe.setValue(estructura.getes_jefe());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_jefe);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_anual=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_anual.setValue(estructura.getes_anual());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_anual);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcentaje=new ParameterValue<Double>();
					parameterMaintenanceValueporcentaje.setValue(estructura.getporcentaje());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcentaje);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor=new ParameterValue<Double>();
					parameterMaintenanceValuevalor.setValue(estructura.getvalor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor);
					parametersTemp.add(parameterMaintenance);
					
						if(!estructura.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(estructura.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(estructura.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(estructura.getId());
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
	
	public void setIsNewIsChangedFalseEstructura(Estructura estructura)throws Exception  {		
		estructura.setIsNew(false);
		estructura.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseEstructuras(List<Estructura> estructuras)throws Exception  {				
		for(Estructura estructura:estructuras) {
			estructura.setIsNew(false);
			estructura.setIsChanged(false);
		}
	}
	
	public void generarExportarEstructura(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
