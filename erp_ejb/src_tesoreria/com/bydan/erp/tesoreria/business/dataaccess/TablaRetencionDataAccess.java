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
package com.bydan.erp.tesoreria.business.dataaccess;

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

import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.tesoreria.util.*;//TablaRetencionConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class TablaRetencionDataAccess extends  TablaRetencionDataAccessAdditional{ //TablaRetencionDataAccessAdditional,DataAccessHelper<TablaRetencion>
	//static Logger logger = Logger.getLogger(TablaRetencionDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tabla_retencion";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TablaRetencionConstantesFunciones.SCHEMA+"."+TablaRetencionConstantesFunciones.TABLENAME+"(version_row,id_empresa,codigo,nombre,porcentaje,monto_minimo,id_tipo_retencion,id_cuenta_contable_debito,id_cuenta_contable_credito,es_debito,es_retencion_fuente,con_secuencial,con_sub_total_factura,con_iva_factura)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+TablaRetencionConstantesFunciones.SCHEMA+"."+TablaRetencionConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,codigo=?,nombre=?,porcentaje=?,monto_minimo=?,id_tipo_retencion=?,id_cuenta_contable_debito=?,id_cuenta_contable_credito=?,es_debito=?,es_retencion_fuente=?,con_secuencial=?,con_sub_total_factura=?,con_iva_factura=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TablaRetencionConstantesFunciones.SCHEMA+"."+TablaRetencionConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tablaretencion from "+TablaRetencionConstantesFunciones.SPERSISTENCENAME+" tablaretencion";
	public static String QUERYSELECTNATIVE="select "+TablaRetencionConstantesFunciones.SCHEMA+"."+TablaRetencionConstantesFunciones.TABLENAME+".id,"+TablaRetencionConstantesFunciones.SCHEMA+"."+TablaRetencionConstantesFunciones.TABLENAME+".version_row,"+TablaRetencionConstantesFunciones.SCHEMA+"."+TablaRetencionConstantesFunciones.TABLENAME+".id_empresa,"+TablaRetencionConstantesFunciones.SCHEMA+"."+TablaRetencionConstantesFunciones.TABLENAME+".codigo,"+TablaRetencionConstantesFunciones.SCHEMA+"."+TablaRetencionConstantesFunciones.TABLENAME+".nombre,"+TablaRetencionConstantesFunciones.SCHEMA+"."+TablaRetencionConstantesFunciones.TABLENAME+".porcentaje,"+TablaRetencionConstantesFunciones.SCHEMA+"."+TablaRetencionConstantesFunciones.TABLENAME+".monto_minimo,"+TablaRetencionConstantesFunciones.SCHEMA+"."+TablaRetencionConstantesFunciones.TABLENAME+".id_tipo_retencion,"+TablaRetencionConstantesFunciones.SCHEMA+"."+TablaRetencionConstantesFunciones.TABLENAME+".id_cuenta_contable_debito,"+TablaRetencionConstantesFunciones.SCHEMA+"."+TablaRetencionConstantesFunciones.TABLENAME+".id_cuenta_contable_credito,"+TablaRetencionConstantesFunciones.SCHEMA+"."+TablaRetencionConstantesFunciones.TABLENAME+".es_debito,"+TablaRetencionConstantesFunciones.SCHEMA+"."+TablaRetencionConstantesFunciones.TABLENAME+".es_retencion_fuente,"+TablaRetencionConstantesFunciones.SCHEMA+"."+TablaRetencionConstantesFunciones.TABLENAME+".con_secuencial,"+TablaRetencionConstantesFunciones.SCHEMA+"."+TablaRetencionConstantesFunciones.TABLENAME+".con_sub_total_factura,"+TablaRetencionConstantesFunciones.SCHEMA+"."+TablaRetencionConstantesFunciones.TABLENAME+".con_iva_factura from "+TablaRetencionConstantesFunciones.SCHEMA+"."+TablaRetencionConstantesFunciones.TABLENAME;//+" as "+TablaRetencionConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TablaRetencionConstantesFunciones.SCHEMA+"."+TablaRetencionConstantesFunciones.TABLENAME+".id,"+TablaRetencionConstantesFunciones.SCHEMA+"."+TablaRetencionConstantesFunciones.TABLENAME+".version_row,"+TablaRetencionConstantesFunciones.SCHEMA+"."+TablaRetencionConstantesFunciones.TABLENAME+".codigo from "+TablaRetencionConstantesFunciones.SCHEMA+"."+TablaRetencionConstantesFunciones.TABLENAME;//+" as "+TablaRetencionConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TablaRetencionConstantesFunciones.SCHEMA+"."+TablaRetencionConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,codigo=?,nombre=?,porcentaje=?,monto_minimo=?,id_tipo_retencion=?,id_cuenta_contable_debito=?,id_cuenta_contable_credito=?,es_debito=?,es_retencion_fuente=?,con_secuencial=?,con_sub_total_factura=?,con_iva_factura=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TABLARETENCION_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TABLARETENCION_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TABLARETENCION_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TABLARETENCION_SELECT(?,?)";
	
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
	
	
	protected TablaRetencionDataAccessAdditional tablaretencionDataAccessAdditional=null;
	
	public TablaRetencionDataAccessAdditional getTablaRetencionDataAccessAdditional() {
		return this.tablaretencionDataAccessAdditional;
	}
	
	public void setTablaRetencionDataAccessAdditional(TablaRetencionDataAccessAdditional tablaretencionDataAccessAdditional) {
		try {
			this.tablaretencionDataAccessAdditional=tablaretencionDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TablaRetencionDataAccess() {
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
		TablaRetencionDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TablaRetencionDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TablaRetencionDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTablaRetencionOriginal(TablaRetencion tablaretencion)throws Exception  {
		tablaretencion.setTablaRetencionOriginal((TablaRetencion)tablaretencion.clone());		
	}
	
	public void setTablaRetencionsOriginal(List<TablaRetencion> tablaretencions)throws Exception  {
		
		for(TablaRetencion tablaretencion:tablaretencions){
			tablaretencion.setTablaRetencionOriginal((TablaRetencion)tablaretencion.clone());
		}
	}
	
	public static void setTablaRetencionOriginalStatic(TablaRetencion tablaretencion)throws Exception  {
		tablaretencion.setTablaRetencionOriginal((TablaRetencion)tablaretencion.clone());		
	}
	
	public static void setTablaRetencionsOriginalStatic(List<TablaRetencion> tablaretencions)throws Exception  {
		
		for(TablaRetencion tablaretencion:tablaretencions){
			tablaretencion.setTablaRetencionOriginal((TablaRetencion)tablaretencion.clone());
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
	
	public  TablaRetencion getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TablaRetencion entity = new TablaRetencion();		
		
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
	
	public  TablaRetencion getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TablaRetencion entity = new TablaRetencion();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TablaRetencionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TablaRetencionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Tesoreria.TablaRetencion.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTablaRetencionOriginal(new TablaRetencion());
      	    	entity=super.getEntity("",entity,resultSet,TablaRetencionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTablaRetencion("",entity,resultSet); 
				
				//entity.setTablaRetencionOriginal(super.getEntity("",entity.getTablaRetencionOriginal(),resultSet,TablaRetencionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTablaRetencionOriginal(this.getEntityTablaRetencion("",entity.getTablaRetencionOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTablaRetencion(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TablaRetencion getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TablaRetencion entity = new TablaRetencion();
				
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
	
	public  TablaRetencion getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TablaRetencion entity = new TablaRetencion();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TablaRetencionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TablaRetencionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TablaRetencionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Tesoreria.TablaRetencion.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTablaRetencionOriginal(new TablaRetencion());
      	    	entity=super.getEntity("",entity,resultSet,TablaRetencionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTablaRetencion("",entity,resultSet);    
				
				//entity.setTablaRetencionOriginal(super.getEntity("",entity.getTablaRetencionOriginal(),resultSet,TablaRetencionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTablaRetencionOriginal(this.getEntityTablaRetencion("",entity.getTablaRetencionOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTablaRetencion(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TablaRetencion
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TablaRetencion entity = new TablaRetencion();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TablaRetencionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TablaRetencionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TablaRetencionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Tesoreria.TablaRetencion.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTablaRetencion(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TablaRetencion> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TablaRetencion> entities = new  ArrayList<TablaRetencion>();
		TablaRetencion entity = new TablaRetencion();		  
		
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
	
	public  List<TablaRetencion> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TablaRetencion> entities = new  ArrayList<TablaRetencion>();
		TablaRetencion entity = new TablaRetencion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TablaRetencionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TablaRetencionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TablaRetencionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TablaRetencion();
      	    	entity=super.getEntity("",entity,resultSet,TablaRetencionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTablaRetencion("",entity,resultSet);
      	    	
				//entity.setTablaRetencionOriginal( new TablaRetencion());
      	    	//entity.setTablaRetencionOriginal(super.getEntity("",entity.getTablaRetencionOriginal(),resultSet,TablaRetencionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTablaRetencionOriginal(this.getEntityTablaRetencion("",entity.getTablaRetencionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTablaRetencions(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTablaRetencion(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TablaRetencion> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TablaRetencion> entities = new  ArrayList<TablaRetencion>();
		TablaRetencion entity = new TablaRetencion();		  
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
	
	public  List<TablaRetencion> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TablaRetencion> entities = new  ArrayList<TablaRetencion>();
		TablaRetencion entity = new TablaRetencion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TablaRetencion();
				
				if(conMapGenerico) {
					entity.inicializarMapTablaRetencion();
					//entity.setMapTablaRetencion(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTablaRetencionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTablaRetencion().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TablaRetencionDataAccess.ISWITHSCHEMA);         		
					entity=TablaRetencionDataAccess.getEntityTablaRetencion("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTablaRetencionOriginal( new TablaRetencion());
					////entity.setTablaRetencionOriginal(super.getEntity("",entity.getTablaRetencionOriginal(),resultSet,TablaRetencionDataAccess.ISWITHSCHEMA));         		
					////entity.setTablaRetencionOriginal(this.getEntityTablaRetencion("",entity.getTablaRetencionOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTablaRetencions(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTablaRetencion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TablaRetencion getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TablaRetencion entity = new TablaRetencion();		  
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
	
	public  TablaRetencion getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TablaRetencion entity = new TablaRetencion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TablaRetencion();
				
				if(conMapGenerico) {
					entity.inicializarMapTablaRetencion();
					//entity.setMapTablaRetencion(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTablaRetencionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTablaRetencion().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TablaRetencionDataAccess.ISWITHSCHEMA);         		
					entity=TablaRetencionDataAccess.getEntityTablaRetencion("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTablaRetencionOriginal( new TablaRetencion());
					////entity.setTablaRetencionOriginal(super.getEntity("",entity.getTablaRetencionOriginal(),resultSet,TablaRetencionDataAccess.ISWITHSCHEMA));         		
					////entity.setTablaRetencionOriginal(this.getEntityTablaRetencion("",entity.getTablaRetencionOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTablaRetencion(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTablaRetencion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TablaRetencion getEntityTablaRetencion(String strPrefijo,TablaRetencion entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TablaRetencion.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TablaRetencion.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TablaRetencionDataAccess.setFieldReflectionTablaRetencion(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTablaRetencion=TablaRetencionConstantesFunciones.getTodosTiposColumnasTablaRetencion();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTablaRetencion) {
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
							field = TablaRetencion.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TablaRetencion.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TablaRetencionDataAccess.setFieldReflectionTablaRetencion(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTablaRetencion(Field field,String strPrefijo,String sColumn,TablaRetencion entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TablaRetencionConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TablaRetencionConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TablaRetencionConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TablaRetencionConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TablaRetencionConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TablaRetencionConstantesFunciones.PORCENTAJE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case TablaRetencionConstantesFunciones.MONTOMINIMO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case TablaRetencionConstantesFunciones.IDTIPORETENCION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TablaRetencionConstantesFunciones.IDCUENTACONTABLEDEBITO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TablaRetencionConstantesFunciones.IDCUENTACONTABLECREDITO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TablaRetencionConstantesFunciones.ESDEBITO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case TablaRetencionConstantesFunciones.ESRETENCIONFUENTE:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case TablaRetencionConstantesFunciones.CONSECUENCIAL:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case TablaRetencionConstantesFunciones.CONSUBTOTALFACTURA:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case TablaRetencionConstantesFunciones.CONIVAFACTURA:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TablaRetencion>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TablaRetencion> entities = new  ArrayList<TablaRetencion>();
		TablaRetencion entity = new TablaRetencion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TablaRetencionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TablaRetencionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TablaRetencionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TablaRetencion();
					entity=super.getEntity("",entity,resultSet,TablaRetencionDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTablaRetencion("",entity,resultSet);
					
					//entity.setTablaRetencionOriginal( new TablaRetencion());
					//entity.setTablaRetencionOriginal(super.getEntity("",entity.getTablaRetencionOriginal(),resultSet,TablaRetencionDataAccess.ISWITHSCHEMA));         		
					//entity.setTablaRetencionOriginal(this.getEntityTablaRetencion("",entity.getTablaRetencionOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTablaRetencions(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTablaRetencion(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TablaRetencion>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TablaRetencion> entities = new  ArrayList<TablaRetencion>();
		TablaRetencion entity = new TablaRetencion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TablaRetencionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TablaRetencionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TablaRetencionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TablaRetencion> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TablaRetencion> entities = new  ArrayList<TablaRetencion>();
		TablaRetencion entity = new TablaRetencion();		  
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
	
	public  List<TablaRetencion> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TablaRetencion> entities = new  ArrayList<TablaRetencion>();
		TablaRetencion entity = new TablaRetencion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TablaRetencion();
      	    	entity=super.getEntity("",entity,resultSet,TablaRetencionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTablaRetencion("",entity,resultSet);
      	    	
				//entity.setTablaRetencionOriginal( new TablaRetencion());
      	    	//entity.setTablaRetencionOriginal(super.getEntity("",entity.getTablaRetencionOriginal(),resultSet,TablaRetencionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTablaRetencionOriginal(this.getEntityTablaRetencion("",entity.getTablaRetencionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTablaRetencions(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTablaRetencion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TablaRetencion> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TablaRetencion> entities = new  ArrayList<TablaRetencion>();
		TablaRetencion entity = new TablaRetencion();		  
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
	
	public  List<TablaRetencion> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TablaRetencion> entities = new  ArrayList<TablaRetencion>();
		TablaRetencion entity = new TablaRetencion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TablaRetencion();
      	    	entity=super.getEntity("",entity,resultSet,TablaRetencionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTablaRetencion("",entity,resultSet);
      	    	
				//entity.setTablaRetencionOriginal( new TablaRetencion());
      	    	//entity.setTablaRetencionOriginal(super.getEntity("",entity.getTablaRetencionOriginal(),resultSet,TablaRetencionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTablaRetencionOriginal(this.getEntityTablaRetencion("",entity.getTablaRetencionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTablaRetencions(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public TablaRetencion getEntityTablaRetencion(String strPrefijo,TablaRetencion entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+TablaRetencionConstantesFunciones.IDEMPRESA));
				entity.setcodigo(resultSet.getString(strPrefijo+TablaRetencionConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+TablaRetencionConstantesFunciones.NOMBRE));
				entity.setporcentaje(resultSet.getDouble(strPrefijo+TablaRetencionConstantesFunciones.PORCENTAJE));
				entity.setmonto_minimo(resultSet.getDouble(strPrefijo+TablaRetencionConstantesFunciones.MONTOMINIMO));
				entity.setid_tipo_retencion(resultSet.getLong(strPrefijo+TablaRetencionConstantesFunciones.IDTIPORETENCION));
				entity.setid_cuenta_contable_debito(resultSet.getLong(strPrefijo+TablaRetencionConstantesFunciones.IDCUENTACONTABLEDEBITO));
				entity.setid_cuenta_contable_credito(resultSet.getLong(strPrefijo+TablaRetencionConstantesFunciones.IDCUENTACONTABLECREDITO));if(resultSet.wasNull()) {entity.setid_cuenta_contable_credito(null); }
				entity.setes_debito(resultSet.getBoolean(strPrefijo+TablaRetencionConstantesFunciones.ESDEBITO));
				entity.setes_retencion_fuente(resultSet.getBoolean(strPrefijo+TablaRetencionConstantesFunciones.ESRETENCIONFUENTE));
				entity.setcon_secuencial(resultSet.getBoolean(strPrefijo+TablaRetencionConstantesFunciones.CONSECUENCIAL));
				entity.setcon_sub_total_factura(resultSet.getBoolean(strPrefijo+TablaRetencionConstantesFunciones.CONSUBTOTALFACTURA));
				entity.setcon_iva_factura(resultSet.getBoolean(strPrefijo+TablaRetencionConstantesFunciones.CONIVAFACTURA));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+TablaRetencionConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTablaRetencion(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TablaRetencion entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TablaRetencionDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TablaRetencionDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TablaRetencionDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TablaRetencionDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TablaRetencionConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,TablaRetencionDataAccess.TABLENAME,TablaRetencionDataAccess.ISWITHSTOREPROCEDURES);
			
			TablaRetencionDataAccess.setTablaRetencionOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,TablaRetencion reltablaretencion)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reltablaretencion.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public TipoRetencion getTipoRetencion(Connexion connexion,TablaRetencion reltablaretencion)throws SQLException,Exception {

		TipoRetencion tiporetencion= new TipoRetencion();

		try {
			TipoRetencionDataAccess tiporetencionDataAccess=new TipoRetencionDataAccess();

			tiporetencionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tiporetencionDataAccess.setConnexionType(this.connexionType);
			tiporetencionDataAccess.setParameterDbType(this.parameterDbType);

			tiporetencion=tiporetencionDataAccess.getEntity(connexion,reltablaretencion.getid_tipo_retencion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tiporetencion;

	}

	public CuentaContable getCuentaContableDebito(Connexion connexion,TablaRetencion reltablaretencion)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,reltablaretencion.getid_cuenta_contable_debito());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableCredito(Connexion connexion,TablaRetencion reltablaretencion)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,reltablaretencion.getid_cuenta_contable_credito());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TablaRetencion tablaretencion) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tablaretencion.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(tablaretencion.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(tablaretencion.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tablaretencion.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcentaje=new ParameterValue<Double>();
					parameterMaintenanceValueporcentaje.setValue(tablaretencion.getporcentaje());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcentaje);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuemonto_minimo=new ParameterValue<Double>();
					parameterMaintenanceValuemonto_minimo.setValue(tablaretencion.getmonto_minimo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuemonto_minimo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_retencion=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_retencion.setValue(tablaretencion.getid_tipo_retencion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_retencion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_debito=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_debito.setValue(tablaretencion.getid_cuenta_contable_debito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_debito);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_credito=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_credito.setValue(tablaretencion.getid_cuenta_contable_credito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_credito);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_debito=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_debito.setValue(tablaretencion.getes_debito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_debito);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_retencion_fuente=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_retencion_fuente.setValue(tablaretencion.getes_retencion_fuente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_retencion_fuente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_secuencial=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_secuencial.setValue(tablaretencion.getcon_secuencial());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_secuencial);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_sub_total_factura=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_sub_total_factura.setValue(tablaretencion.getcon_sub_total_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_sub_total_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_iva_factura=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_iva_factura.setValue(tablaretencion.getcon_iva_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_iva_factura);
					parametersTemp.add(parameterMaintenance);
					
						if(!tablaretencion.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tablaretencion.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tablaretencion.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tablaretencion.getId());
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
	
	public void setIsNewIsChangedFalseTablaRetencion(TablaRetencion tablaretencion)throws Exception  {		
		tablaretencion.setIsNew(false);
		tablaretencion.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTablaRetencions(List<TablaRetencion> tablaretencions)throws Exception  {				
		for(TablaRetencion tablaretencion:tablaretencions) {
			tablaretencion.setIsNew(false);
			tablaretencion.setIsChanged(false);
		}
	}
	
	public void generarExportarTablaRetencion(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
