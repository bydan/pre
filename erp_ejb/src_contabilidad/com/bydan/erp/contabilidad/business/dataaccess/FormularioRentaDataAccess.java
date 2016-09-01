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
package com.bydan.erp.contabilidad.business.dataaccess;

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

import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.contabilidad.util.*;//FormularioRentaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class FormularioRentaDataAccess extends  FormularioRentaDataAccessAdditional{ //FormularioRentaDataAccessAdditional,DataAccessHelper<FormularioRenta>
	//static Logger logger = Logger.getLogger(FormularioRentaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="formulario_renta";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+FormularioRentaConstantesFunciones.SCHEMA+"."+FormularioRentaConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_ejercicio,id_periodo,id_dato_formulario_renta,id_cuenta_contable,id_tipo_retencion,id_parametro_formulario_iva,id_pais,valor_pagado,impuesto_retenido,base_impornible)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+FormularioRentaConstantesFunciones.SCHEMA+"."+FormularioRentaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_ejercicio=?,id_periodo=?,id_dato_formulario_renta=?,id_cuenta_contable=?,id_tipo_retencion=?,id_parametro_formulario_iva=?,id_pais=?,valor_pagado=?,impuesto_retenido=?,base_impornible=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+FormularioRentaConstantesFunciones.SCHEMA+"."+FormularioRentaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select formulariorenta from "+FormularioRentaConstantesFunciones.SPERSISTENCENAME+" formulariorenta";
	public static String QUERYSELECTNATIVE="select "+FormularioRentaConstantesFunciones.SCHEMA+"."+FormularioRentaConstantesFunciones.TABLENAME+".id,"+FormularioRentaConstantesFunciones.SCHEMA+"."+FormularioRentaConstantesFunciones.TABLENAME+".version_row,"+FormularioRentaConstantesFunciones.SCHEMA+"."+FormularioRentaConstantesFunciones.TABLENAME+".id_empresa,"+FormularioRentaConstantesFunciones.SCHEMA+"."+FormularioRentaConstantesFunciones.TABLENAME+".id_ejercicio,"+FormularioRentaConstantesFunciones.SCHEMA+"."+FormularioRentaConstantesFunciones.TABLENAME+".id_periodo,"+FormularioRentaConstantesFunciones.SCHEMA+"."+FormularioRentaConstantesFunciones.TABLENAME+".id_dato_formulario_renta,"+FormularioRentaConstantesFunciones.SCHEMA+"."+FormularioRentaConstantesFunciones.TABLENAME+".id_cuenta_contable,"+FormularioRentaConstantesFunciones.SCHEMA+"."+FormularioRentaConstantesFunciones.TABLENAME+".id_tipo_retencion,"+FormularioRentaConstantesFunciones.SCHEMA+"."+FormularioRentaConstantesFunciones.TABLENAME+".id_parametro_formulario_iva,"+FormularioRentaConstantesFunciones.SCHEMA+"."+FormularioRentaConstantesFunciones.TABLENAME+".id_pais,"+FormularioRentaConstantesFunciones.SCHEMA+"."+FormularioRentaConstantesFunciones.TABLENAME+".valor_pagado,"+FormularioRentaConstantesFunciones.SCHEMA+"."+FormularioRentaConstantesFunciones.TABLENAME+".impuesto_retenido,"+FormularioRentaConstantesFunciones.SCHEMA+"."+FormularioRentaConstantesFunciones.TABLENAME+".base_impornible from "+FormularioRentaConstantesFunciones.SCHEMA+"."+FormularioRentaConstantesFunciones.TABLENAME;//+" as "+FormularioRentaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+FormularioRentaConstantesFunciones.SCHEMA+"."+FormularioRentaConstantesFunciones.TABLENAME+".id,"+FormularioRentaConstantesFunciones.SCHEMA+"."+FormularioRentaConstantesFunciones.TABLENAME+".version_row from "+FormularioRentaConstantesFunciones.SCHEMA+"."+FormularioRentaConstantesFunciones.TABLENAME;//+" as "+FormularioRentaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+FormularioRentaConstantesFunciones.SCHEMA+"."+FormularioRentaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_ejercicio=?,id_periodo=?,id_dato_formulario_renta=?,id_cuenta_contable=?,id_tipo_retencion=?,id_parametro_formulario_iva=?,id_pais=?,valor_pagado=?,impuesto_retenido=?,base_impornible=?";
	
	public static String STOREPROCEDUREINSERT="call SP_FORMULARIORENTA_INSERT(?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_FORMULARIORENTA_UPDATE(?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_FORMULARIORENTA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_FORMULARIORENTA_SELECT(?,?)";
	
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
	
	
	protected FormularioRentaDataAccessAdditional formulariorentaDataAccessAdditional=null;
	
	public FormularioRentaDataAccessAdditional getFormularioRentaDataAccessAdditional() {
		return this.formulariorentaDataAccessAdditional;
	}
	
	public void setFormularioRentaDataAccessAdditional(FormularioRentaDataAccessAdditional formulariorentaDataAccessAdditional) {
		try {
			this.formulariorentaDataAccessAdditional=formulariorentaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public FormularioRentaDataAccess() {
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
		FormularioRentaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		FormularioRentaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		FormularioRentaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setFormularioRentaOriginal(FormularioRenta formulariorenta)throws Exception  {
		formulariorenta.setFormularioRentaOriginal((FormularioRenta)formulariorenta.clone());		
	}
	
	public void setFormularioRentasOriginal(List<FormularioRenta> formulariorentas)throws Exception  {
		
		for(FormularioRenta formulariorenta:formulariorentas){
			formulariorenta.setFormularioRentaOriginal((FormularioRenta)formulariorenta.clone());
		}
	}
	
	public static void setFormularioRentaOriginalStatic(FormularioRenta formulariorenta)throws Exception  {
		formulariorenta.setFormularioRentaOriginal((FormularioRenta)formulariorenta.clone());		
	}
	
	public static void setFormularioRentasOriginalStatic(List<FormularioRenta> formulariorentas)throws Exception  {
		
		for(FormularioRenta formulariorenta:formulariorentas){
			formulariorenta.setFormularioRentaOriginal((FormularioRenta)formulariorenta.clone());
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
	
	public  FormularioRenta getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		FormularioRenta entity = new FormularioRenta();		
		
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
	
	public  FormularioRenta getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		FormularioRenta entity = new FormularioRenta();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=FormularioRentaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=FormularioRentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Contabilidad.FormularioRenta.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setFormularioRentaOriginal(new FormularioRenta());
      	    	entity=super.getEntity("",entity,resultSet,FormularioRentaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityFormularioRenta("",entity,resultSet); 
				
				//entity.setFormularioRentaOriginal(super.getEntity("",entity.getFormularioRentaOriginal(),resultSet,FormularioRentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFormularioRentaOriginal(this.getEntityFormularioRenta("",entity.getFormularioRentaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseFormularioRenta(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  FormularioRenta getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		FormularioRenta entity = new FormularioRenta();
				
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
	
	public  FormularioRenta getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		FormularioRenta entity = new FormularioRenta();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=FormularioRentaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=FormularioRentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FormularioRentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.FormularioRenta.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setFormularioRentaOriginal(new FormularioRenta());
      	    	entity=super.getEntity("",entity,resultSet,FormularioRentaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityFormularioRenta("",entity,resultSet);    
				
				//entity.setFormularioRentaOriginal(super.getEntity("",entity.getFormularioRentaOriginal(),resultSet,FormularioRentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFormularioRentaOriginal(this.getEntityFormularioRenta("",entity.getFormularioRentaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseFormularioRenta(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //FormularioRenta
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		FormularioRenta entity = new FormularioRenta();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=FormularioRentaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=FormularioRentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FormularioRentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.FormularioRenta.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseFormularioRenta(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<FormularioRenta> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<FormularioRenta> entities = new  ArrayList<FormularioRenta>();
		FormularioRenta entity = new FormularioRenta();		  
		
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
	
	public  List<FormularioRenta> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<FormularioRenta> entities = new  ArrayList<FormularioRenta>();
		FormularioRenta entity = new FormularioRenta();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=FormularioRentaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=FormularioRentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FormularioRentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FormularioRenta();
      	    	entity=super.getEntity("",entity,resultSet,FormularioRentaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityFormularioRenta("",entity,resultSet);
      	    	
				//entity.setFormularioRentaOriginal( new FormularioRenta());
      	    	//entity.setFormularioRentaOriginal(super.getEntity("",entity.getFormularioRentaOriginal(),resultSet,FormularioRentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFormularioRentaOriginal(this.getEntityFormularioRenta("",entity.getFormularioRentaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseFormularioRentas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFormularioRenta(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<FormularioRenta> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<FormularioRenta> entities = new  ArrayList<FormularioRenta>();
		FormularioRenta entity = new FormularioRenta();		  
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
	
	public  List<FormularioRenta> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<FormularioRenta> entities = new  ArrayList<FormularioRenta>();
		FormularioRenta entity = new FormularioRenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FormularioRenta();
				
				if(conMapGenerico) {
					entity.inicializarMapFormularioRenta();
					//entity.setMapFormularioRenta(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapFormularioRentaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapFormularioRenta().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,FormularioRentaDataAccess.ISWITHSCHEMA);         		
					entity=FormularioRentaDataAccess.getEntityFormularioRenta("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setFormularioRentaOriginal( new FormularioRenta());
					////entity.setFormularioRentaOriginal(super.getEntity("",entity.getFormularioRentaOriginal(),resultSet,FormularioRentaDataAccess.ISWITHSCHEMA));         		
					////entity.setFormularioRentaOriginal(this.getEntityFormularioRenta("",entity.getFormularioRentaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseFormularioRentas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFormularioRenta(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public FormularioRenta getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		FormularioRenta entity = new FormularioRenta();		  
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
	
	public  FormularioRenta getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		FormularioRenta entity = new FormularioRenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FormularioRenta();
				
				if(conMapGenerico) {
					entity.inicializarMapFormularioRenta();
					//entity.setMapFormularioRenta(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapFormularioRentaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapFormularioRenta().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,FormularioRentaDataAccess.ISWITHSCHEMA);         		
					entity=FormularioRentaDataAccess.getEntityFormularioRenta("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setFormularioRentaOriginal( new FormularioRenta());
					////entity.setFormularioRentaOriginal(super.getEntity("",entity.getFormularioRentaOriginal(),resultSet,FormularioRentaDataAccess.ISWITHSCHEMA));         		
					////entity.setFormularioRentaOriginal(this.getEntityFormularioRenta("",entity.getFormularioRentaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseFormularioRenta(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFormularioRenta(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static FormularioRenta getEntityFormularioRenta(String strPrefijo,FormularioRenta entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = FormularioRenta.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = FormularioRenta.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					FormularioRentaDataAccess.setFieldReflectionFormularioRenta(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasFormularioRenta=FormularioRentaConstantesFunciones.getTodosTiposColumnasFormularioRenta();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasFormularioRenta) {
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
							field = FormularioRenta.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = FormularioRenta.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						FormularioRentaDataAccess.setFieldReflectionFormularioRenta(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionFormularioRenta(Field field,String strPrefijo,String sColumn,FormularioRenta entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case FormularioRentaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FormularioRentaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FormularioRentaConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FormularioRentaConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FormularioRentaConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FormularioRentaConstantesFunciones.IDDATOFORMULARIORENTA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FormularioRentaConstantesFunciones.IDCUENTACONTABLE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FormularioRentaConstantesFunciones.IDTIPORETENCION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FormularioRentaConstantesFunciones.IDPARAMETROFORMULARIOIVA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FormularioRentaConstantesFunciones.IDPAIS:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FormularioRentaConstantesFunciones.VALORPAGADO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FormularioRentaConstantesFunciones.IMPUESTORETENIDO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FormularioRentaConstantesFunciones.BASEIMPORNIBLE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<FormularioRenta>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<FormularioRenta> entities = new  ArrayList<FormularioRenta>();
		FormularioRenta entity = new FormularioRenta();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=FormularioRentaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=FormularioRentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FormularioRentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new FormularioRenta();
					entity=super.getEntity("",entity,resultSet,FormularioRentaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityFormularioRenta("",entity,resultSet);
					
					//entity.setFormularioRentaOriginal( new FormularioRenta());
					//entity.setFormularioRentaOriginal(super.getEntity("",entity.getFormularioRentaOriginal(),resultSet,FormularioRentaDataAccess.ISWITHSCHEMA));         		
					//entity.setFormularioRentaOriginal(this.getEntityFormularioRenta("",entity.getFormularioRentaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseFormularioRentas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFormularioRenta(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<FormularioRenta>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<FormularioRenta> entities = new  ArrayList<FormularioRenta>();
		FormularioRenta entity = new FormularioRenta();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=FormularioRentaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=FormularioRentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FormularioRentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<FormularioRenta> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<FormularioRenta> entities = new  ArrayList<FormularioRenta>();
		FormularioRenta entity = new FormularioRenta();		  
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
	
	public  List<FormularioRenta> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<FormularioRenta> entities = new  ArrayList<FormularioRenta>();
		FormularioRenta entity = new FormularioRenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FormularioRenta();
      	    	entity=super.getEntity("",entity,resultSet,FormularioRentaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityFormularioRenta("",entity,resultSet);
      	    	
				//entity.setFormularioRentaOriginal( new FormularioRenta());
      	    	//entity.setFormularioRentaOriginal(super.getEntity("",entity.getFormularioRentaOriginal(),resultSet,FormularioRentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFormularioRentaOriginal(this.getEntityFormularioRenta("",entity.getFormularioRentaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseFormularioRentas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFormularioRenta(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<FormularioRenta> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<FormularioRenta> entities = new  ArrayList<FormularioRenta>();
		FormularioRenta entity = new FormularioRenta();		  
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
	
	public  List<FormularioRenta> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<FormularioRenta> entities = new  ArrayList<FormularioRenta>();
		FormularioRenta entity = new FormularioRenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FormularioRenta();
      	    	entity=super.getEntity("",entity,resultSet,FormularioRentaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityFormularioRenta("",entity,resultSet);
      	    	
				//entity.setFormularioRentaOriginal( new FormularioRenta());
      	    	//entity.setFormularioRentaOriginal(super.getEntity("",entity.getFormularioRentaOriginal(),resultSet,FormularioRentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFormularioRentaOriginal(this.getEntityFormularioRenta("",entity.getFormularioRentaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseFormularioRentas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public FormularioRenta getEntityFormularioRenta(String strPrefijo,FormularioRenta entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+FormularioRentaConstantesFunciones.IDEMPRESA));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+FormularioRentaConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+FormularioRentaConstantesFunciones.IDPERIODO));
				entity.setid_dato_formulario_renta(resultSet.getLong(strPrefijo+FormularioRentaConstantesFunciones.IDDATOFORMULARIORENTA));
				entity.setid_cuenta_contable(resultSet.getLong(strPrefijo+FormularioRentaConstantesFunciones.IDCUENTACONTABLE));
				entity.setid_tipo_retencion(resultSet.getLong(strPrefijo+FormularioRentaConstantesFunciones.IDTIPORETENCION));
				entity.setid_parametro_formulario_iva(resultSet.getLong(strPrefijo+FormularioRentaConstantesFunciones.IDPARAMETROFORMULARIOIVA));
				entity.setid_pais(resultSet.getLong(strPrefijo+FormularioRentaConstantesFunciones.IDPAIS));
				entity.setvalor_pagado(resultSet.getDouble(strPrefijo+FormularioRentaConstantesFunciones.VALORPAGADO));
				entity.setimpuesto_retenido(resultSet.getDouble(strPrefijo+FormularioRentaConstantesFunciones.IMPUESTORETENIDO));
				entity.setbase_impornible(resultSet.getDouble(strPrefijo+FormularioRentaConstantesFunciones.BASEIMPORNIBLE));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowFormularioRenta(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(FormularioRenta entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=FormularioRentaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=FormularioRentaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=FormularioRentaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=FormularioRentaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(FormularioRentaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,FormularioRentaDataAccess.TABLENAME,FormularioRentaDataAccess.ISWITHSTOREPROCEDURES);
			
			FormularioRentaDataAccess.setFormularioRentaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,FormularioRenta relformulariorenta)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relformulariorenta.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Ejercicio getEjercicio(Connexion connexion,FormularioRenta relformulariorenta)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relformulariorenta.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,FormularioRenta relformulariorenta)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,relformulariorenta.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public DatoFormularioRenta getDatoFormularioRenta(Connexion connexion,FormularioRenta relformulariorenta)throws SQLException,Exception {

		DatoFormularioRenta datoformulariorenta= new DatoFormularioRenta();

		try {
			DatoFormularioRentaDataAccess datoformulariorentaDataAccess=new DatoFormularioRentaDataAccess();

			datoformulariorentaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			datoformulariorentaDataAccess.setConnexionType(this.connexionType);
			datoformulariorentaDataAccess.setParameterDbType(this.parameterDbType);

			datoformulariorenta=datoformulariorentaDataAccess.getEntity(connexion,relformulariorenta.getid_dato_formulario_renta());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return datoformulariorenta;

	}

	public CuentaContable getCuentaContable(Connexion connexion,FormularioRenta relformulariorenta)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relformulariorenta.getid_cuenta_contable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public TipoRetencion getTipoRetencion(Connexion connexion,FormularioRenta relformulariorenta)throws SQLException,Exception {

		TipoRetencion tiporetencion= new TipoRetencion();

		try {
			TipoRetencionDataAccess tiporetencionDataAccess=new TipoRetencionDataAccess();

			tiporetencionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tiporetencionDataAccess.setConnexionType(this.connexionType);
			tiporetencionDataAccess.setParameterDbType(this.parameterDbType);

			tiporetencion=tiporetencionDataAccess.getEntity(connexion,relformulariorenta.getid_tipo_retencion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tiporetencion;

	}

	public ParametroFormularioIva getParametroFormularioIva(Connexion connexion,FormularioRenta relformulariorenta)throws SQLException,Exception {

		ParametroFormularioIva parametroformularioiva= new ParametroFormularioIva();

		try {
			ParametroFormularioIvaDataAccess parametroformularioivaDataAccess=new ParametroFormularioIvaDataAccess();

			parametroformularioivaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			parametroformularioivaDataAccess.setConnexionType(this.connexionType);
			parametroformularioivaDataAccess.setParameterDbType(this.parameterDbType);

			parametroformularioiva=parametroformularioivaDataAccess.getEntity(connexion,relformulariorenta.getid_parametro_formulario_iva());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return parametroformularioiva;

	}

	public Pais getPais(Connexion connexion,FormularioRenta relformulariorenta)throws SQLException,Exception {

		Pais pais= new Pais();

		try {
			PaisDataAccess paisDataAccess=new PaisDataAccess();

			paisDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			paisDataAccess.setConnexionType(this.connexionType);
			paisDataAccess.setParameterDbType(this.parameterDbType);

			pais=paisDataAccess.getEntity(connexion,relformulariorenta.getid_pais());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pais;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,FormularioRenta formulariorenta) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!formulariorenta.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(formulariorenta.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(formulariorenta.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(formulariorenta.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_dato_formulario_renta=new ParameterValue<Long>();
					parameterMaintenanceValueid_dato_formulario_renta.setValue(formulariorenta.getid_dato_formulario_renta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_dato_formulario_renta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable.setValue(formulariorenta.getid_cuenta_contable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_retencion=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_retencion.setValue(formulariorenta.getid_tipo_retencion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_retencion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_parametro_formulario_iva=new ParameterValue<Long>();
					parameterMaintenanceValueid_parametro_formulario_iva.setValue(formulariorenta.getid_parametro_formulario_iva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_parametro_formulario_iva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_pais=new ParameterValue<Long>();
					parameterMaintenanceValueid_pais.setValue(formulariorenta.getid_pais());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_pais);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_pagado=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_pagado.setValue(formulariorenta.getvalor_pagado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_pagado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueimpuesto_retenido=new ParameterValue<Double>();
					parameterMaintenanceValueimpuesto_retenido.setValue(formulariorenta.getimpuesto_retenido());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueimpuesto_retenido);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuebase_impornible=new ParameterValue<Double>();
					parameterMaintenanceValuebase_impornible.setValue(formulariorenta.getbase_impornible());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuebase_impornible);
					parametersTemp.add(parameterMaintenance);
					
						if(!formulariorenta.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(formulariorenta.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(formulariorenta.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(formulariorenta.getId());
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
	
	public void setIsNewIsChangedFalseFormularioRenta(FormularioRenta formulariorenta)throws Exception  {		
		formulariorenta.setIsNew(false);
		formulariorenta.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseFormularioRentas(List<FormularioRenta> formulariorentas)throws Exception  {				
		for(FormularioRenta formulariorenta:formulariorentas) {
			formulariorenta.setIsNew(false);
			formulariorenta.setIsChanged(false);
		}
	}
	
	public void generarExportarFormularioRenta(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
