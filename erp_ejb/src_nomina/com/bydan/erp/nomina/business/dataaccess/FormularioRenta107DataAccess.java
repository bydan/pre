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
import com.bydan.erp.nomina.util.*;//FormularioRenta107ConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class FormularioRenta107DataAccess extends  FormularioRenta107DataAccessAdditional{ //FormularioRenta107DataAccessAdditional,DataAccessHelper<FormularioRenta107>
	//static Logger logger = Logger.getLogger(FormularioRenta107DataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="formulario_renta107";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+FormularioRenta107ConstantesFunciones.SCHEMA+"."+FormularioRenta107ConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_empleado,id_ejercicio,numero_pre_impreso,fecha_entrega,fecha_generacion)values(current_timestamp,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+FormularioRenta107ConstantesFunciones.SCHEMA+"."+FormularioRenta107ConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_empleado=?,id_ejercicio=?,numero_pre_impreso=?,fecha_entrega=?,fecha_generacion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+FormularioRenta107ConstantesFunciones.SCHEMA+"."+FormularioRenta107ConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select formulariorenta107 from "+FormularioRenta107ConstantesFunciones.SPERSISTENCENAME+" formulariorenta107";
	public static String QUERYSELECTNATIVE="select "+FormularioRenta107ConstantesFunciones.SCHEMA+"."+FormularioRenta107ConstantesFunciones.TABLENAME+".id,"+FormularioRenta107ConstantesFunciones.SCHEMA+"."+FormularioRenta107ConstantesFunciones.TABLENAME+".version_row,"+FormularioRenta107ConstantesFunciones.SCHEMA+"."+FormularioRenta107ConstantesFunciones.TABLENAME+".id_empresa,"+FormularioRenta107ConstantesFunciones.SCHEMA+"."+FormularioRenta107ConstantesFunciones.TABLENAME+".id_empleado,"+FormularioRenta107ConstantesFunciones.SCHEMA+"."+FormularioRenta107ConstantesFunciones.TABLENAME+".id_ejercicio,"+FormularioRenta107ConstantesFunciones.SCHEMA+"."+FormularioRenta107ConstantesFunciones.TABLENAME+".numero_pre_impreso,"+FormularioRenta107ConstantesFunciones.SCHEMA+"."+FormularioRenta107ConstantesFunciones.TABLENAME+".fecha_entrega,"+FormularioRenta107ConstantesFunciones.SCHEMA+"."+FormularioRenta107ConstantesFunciones.TABLENAME+".fecha_generacion from "+FormularioRenta107ConstantesFunciones.SCHEMA+"."+FormularioRenta107ConstantesFunciones.TABLENAME;//+" as "+FormularioRenta107ConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+FormularioRenta107ConstantesFunciones.SCHEMA+"."+FormularioRenta107ConstantesFunciones.TABLENAME+".id,"+FormularioRenta107ConstantesFunciones.SCHEMA+"."+FormularioRenta107ConstantesFunciones.TABLENAME+".version_row from "+FormularioRenta107ConstantesFunciones.SCHEMA+"."+FormularioRenta107ConstantesFunciones.TABLENAME;//+" as "+FormularioRenta107ConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+FormularioRenta107ConstantesFunciones.SCHEMA+"."+FormularioRenta107ConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_empleado=?,id_ejercicio=?,numero_pre_impreso=?,fecha_entrega=?,fecha_generacion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_FORMULARIORENTA107_INSERT(?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_FORMULARIORENTA107_UPDATE(?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_FORMULARIORENTA107_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_FORMULARIORENTA107_SELECT(?,?)";
	
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
	
	
	protected FormularioRenta107DataAccessAdditional formulariorenta107DataAccessAdditional=null;
	
	public FormularioRenta107DataAccessAdditional getFormularioRenta107DataAccessAdditional() {
		return this.formulariorenta107DataAccessAdditional;
	}
	
	public void setFormularioRenta107DataAccessAdditional(FormularioRenta107DataAccessAdditional formulariorenta107DataAccessAdditional) {
		try {
			this.formulariorenta107DataAccessAdditional=formulariorenta107DataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public FormularioRenta107DataAccess() {
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
		FormularioRenta107DataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		FormularioRenta107DataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		FormularioRenta107DataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setFormularioRenta107Original(FormularioRenta107 formulariorenta107)throws Exception  {
		formulariorenta107.setFormularioRenta107Original((FormularioRenta107)formulariorenta107.clone());		
	}
	
	public void setFormularioRenta107sOriginal(List<FormularioRenta107> formulariorenta107s)throws Exception  {
		
		for(FormularioRenta107 formulariorenta107:formulariorenta107s){
			formulariorenta107.setFormularioRenta107Original((FormularioRenta107)formulariorenta107.clone());
		}
	}
	
	public static void setFormularioRenta107OriginalStatic(FormularioRenta107 formulariorenta107)throws Exception  {
		formulariorenta107.setFormularioRenta107Original((FormularioRenta107)formulariorenta107.clone());		
	}
	
	public static void setFormularioRenta107sOriginalStatic(List<FormularioRenta107> formulariorenta107s)throws Exception  {
		
		for(FormularioRenta107 formulariorenta107:formulariorenta107s){
			formulariorenta107.setFormularioRenta107Original((FormularioRenta107)formulariorenta107.clone());
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
	
	public  FormularioRenta107 getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		FormularioRenta107 entity = new FormularioRenta107();		
		
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
	
	public  FormularioRenta107 getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		FormularioRenta107 entity = new FormularioRenta107();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=FormularioRenta107DataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=FormularioRenta107DataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.FormularioRenta107.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setFormularioRenta107Original(new FormularioRenta107());
      	    	entity=super.getEntity("",entity,resultSet,FormularioRenta107DataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityFormularioRenta107("",entity,resultSet); 
				
				//entity.setFormularioRenta107Original(super.getEntity("",entity.getFormularioRenta107Original(),resultSet,FormularioRenta107DataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFormularioRenta107Original(this.getEntityFormularioRenta107("",entity.getFormularioRenta107Original(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseFormularioRenta107(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  FormularioRenta107 getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		FormularioRenta107 entity = new FormularioRenta107();
				
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
	
	public  FormularioRenta107 getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		FormularioRenta107 entity = new FormularioRenta107();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=FormularioRenta107DataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=FormularioRenta107DataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FormularioRenta107DataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.FormularioRenta107.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setFormularioRenta107Original(new FormularioRenta107());
      	    	entity=super.getEntity("",entity,resultSet,FormularioRenta107DataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityFormularioRenta107("",entity,resultSet);    
				
				//entity.setFormularioRenta107Original(super.getEntity("",entity.getFormularioRenta107Original(),resultSet,FormularioRenta107DataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFormularioRenta107Original(this.getEntityFormularioRenta107("",entity.getFormularioRenta107Original(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseFormularioRenta107(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //FormularioRenta107
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		FormularioRenta107 entity = new FormularioRenta107();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=FormularioRenta107DataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=FormularioRenta107DataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FormularioRenta107DataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.FormularioRenta107.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseFormularioRenta107(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<FormularioRenta107> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<FormularioRenta107> entities = new  ArrayList<FormularioRenta107>();
		FormularioRenta107 entity = new FormularioRenta107();		  
		
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
	
	public  List<FormularioRenta107> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<FormularioRenta107> entities = new  ArrayList<FormularioRenta107>();
		FormularioRenta107 entity = new FormularioRenta107();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=FormularioRenta107DataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=FormularioRenta107DataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FormularioRenta107DataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FormularioRenta107();
      	    	entity=super.getEntity("",entity,resultSet,FormularioRenta107DataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityFormularioRenta107("",entity,resultSet);
      	    	
				//entity.setFormularioRenta107Original( new FormularioRenta107());
      	    	//entity.setFormularioRenta107Original(super.getEntity("",entity.getFormularioRenta107Original(),resultSet,FormularioRenta107DataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFormularioRenta107Original(this.getEntityFormularioRenta107("",entity.getFormularioRenta107Original(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseFormularioRenta107s(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFormularioRenta107(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<FormularioRenta107> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<FormularioRenta107> entities = new  ArrayList<FormularioRenta107>();
		FormularioRenta107 entity = new FormularioRenta107();		  
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
	
	public  List<FormularioRenta107> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<FormularioRenta107> entities = new  ArrayList<FormularioRenta107>();
		FormularioRenta107 entity = new FormularioRenta107();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FormularioRenta107();
				
				if(conMapGenerico) {
					entity.inicializarMapFormularioRenta107();
					//entity.setMapFormularioRenta107(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapFormularioRenta107Value(sColumn, resultSet.getObject(sColumn));
						//entity.getMapFormularioRenta107().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,FormularioRenta107DataAccess.ISWITHSCHEMA);         		
					entity=FormularioRenta107DataAccess.getEntityFormularioRenta107("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setFormularioRenta107Original( new FormularioRenta107());
					////entity.setFormularioRenta107Original(super.getEntity("",entity.getFormularioRenta107Original(),resultSet,FormularioRenta107DataAccess.ISWITHSCHEMA));         		
					////entity.setFormularioRenta107Original(this.getEntityFormularioRenta107("",entity.getFormularioRenta107Original(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseFormularioRenta107s(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFormularioRenta107(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public FormularioRenta107 getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		FormularioRenta107 entity = new FormularioRenta107();		  
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
	
	public  FormularioRenta107 getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		FormularioRenta107 entity = new FormularioRenta107();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FormularioRenta107();
				
				if(conMapGenerico) {
					entity.inicializarMapFormularioRenta107();
					//entity.setMapFormularioRenta107(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapFormularioRenta107Value(sColumn, resultSet.getObject(sColumn));
						//entity.getMapFormularioRenta107().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,FormularioRenta107DataAccess.ISWITHSCHEMA);         		
					entity=FormularioRenta107DataAccess.getEntityFormularioRenta107("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setFormularioRenta107Original( new FormularioRenta107());
					////entity.setFormularioRenta107Original(super.getEntity("",entity.getFormularioRenta107Original(),resultSet,FormularioRenta107DataAccess.ISWITHSCHEMA));         		
					////entity.setFormularioRenta107Original(this.getEntityFormularioRenta107("",entity.getFormularioRenta107Original(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseFormularioRenta107(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFormularioRenta107(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static FormularioRenta107 getEntityFormularioRenta107(String strPrefijo,FormularioRenta107 entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = FormularioRenta107.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = FormularioRenta107.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					FormularioRenta107DataAccess.setFieldReflectionFormularioRenta107(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasFormularioRenta107=FormularioRenta107ConstantesFunciones.getTodosTiposColumnasFormularioRenta107();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasFormularioRenta107) {
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
							field = FormularioRenta107.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = FormularioRenta107.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						FormularioRenta107DataAccess.setFieldReflectionFormularioRenta107(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionFormularioRenta107(Field field,String strPrefijo,String sColumn,FormularioRenta107 entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case FormularioRenta107ConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FormularioRenta107ConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FormularioRenta107ConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FormularioRenta107ConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FormularioRenta107ConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FormularioRenta107ConstantesFunciones.NUMEROPREIMPRESO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FormularioRenta107ConstantesFunciones.FECHAENTREGA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case FormularioRenta107ConstantesFunciones.FECHAGENERACION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<FormularioRenta107>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<FormularioRenta107> entities = new  ArrayList<FormularioRenta107>();
		FormularioRenta107 entity = new FormularioRenta107();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=FormularioRenta107DataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=FormularioRenta107DataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FormularioRenta107DataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new FormularioRenta107();
					entity=super.getEntity("",entity,resultSet,FormularioRenta107DataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityFormularioRenta107("",entity,resultSet);
					
					//entity.setFormularioRenta107Original( new FormularioRenta107());
					//entity.setFormularioRenta107Original(super.getEntity("",entity.getFormularioRenta107Original(),resultSet,FormularioRenta107DataAccess.ISWITHSCHEMA));         		
					//entity.setFormularioRenta107Original(this.getEntityFormularioRenta107("",entity.getFormularioRenta107Original(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseFormularioRenta107s(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFormularioRenta107(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<FormularioRenta107>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<FormularioRenta107> entities = new  ArrayList<FormularioRenta107>();
		FormularioRenta107 entity = new FormularioRenta107();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=FormularioRenta107DataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=FormularioRenta107DataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FormularioRenta107DataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<FormularioRenta107> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<FormularioRenta107> entities = new  ArrayList<FormularioRenta107>();
		FormularioRenta107 entity = new FormularioRenta107();		  
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
	
	public  List<FormularioRenta107> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<FormularioRenta107> entities = new  ArrayList<FormularioRenta107>();
		FormularioRenta107 entity = new FormularioRenta107();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FormularioRenta107();
      	    	entity=super.getEntity("",entity,resultSet,FormularioRenta107DataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityFormularioRenta107("",entity,resultSet);
      	    	
				//entity.setFormularioRenta107Original( new FormularioRenta107());
      	    	//entity.setFormularioRenta107Original(super.getEntity("",entity.getFormularioRenta107Original(),resultSet,FormularioRenta107DataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFormularioRenta107Original(this.getEntityFormularioRenta107("",entity.getFormularioRenta107Original(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseFormularioRenta107s(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFormularioRenta107(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<FormularioRenta107> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<FormularioRenta107> entities = new  ArrayList<FormularioRenta107>();
		FormularioRenta107 entity = new FormularioRenta107();		  
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
	
	public  List<FormularioRenta107> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<FormularioRenta107> entities = new  ArrayList<FormularioRenta107>();
		FormularioRenta107 entity = new FormularioRenta107();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FormularioRenta107();
      	    	entity=super.getEntity("",entity,resultSet,FormularioRenta107DataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityFormularioRenta107("",entity,resultSet);
      	    	
				//entity.setFormularioRenta107Original( new FormularioRenta107());
      	    	//entity.setFormularioRenta107Original(super.getEntity("",entity.getFormularioRenta107Original(),resultSet,FormularioRenta107DataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFormularioRenta107Original(this.getEntityFormularioRenta107("",entity.getFormularioRenta107Original(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseFormularioRenta107s(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public FormularioRenta107 getEntityFormularioRenta107(String strPrefijo,FormularioRenta107 entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+FormularioRenta107ConstantesFunciones.IDEMPRESA));
				entity.setid_empleado(resultSet.getLong(strPrefijo+FormularioRenta107ConstantesFunciones.IDEMPLEADO));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+FormularioRenta107ConstantesFunciones.IDEJERCICIO));
				entity.setnumero_pre_impreso(resultSet.getString(strPrefijo+FormularioRenta107ConstantesFunciones.NUMEROPREIMPRESO));
				entity.setfecha_entrega(new Date(resultSet.getDate(strPrefijo+FormularioRenta107ConstantesFunciones.FECHAENTREGA).getTime()));
				entity.setfecha_generacion(new Date(resultSet.getDate(strPrefijo+FormularioRenta107ConstantesFunciones.FECHAGENERACION).getTime()));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowFormularioRenta107(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(FormularioRenta107 entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=FormularioRenta107DataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=FormularioRenta107DataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=FormularioRenta107DataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=FormularioRenta107DataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(FormularioRenta107ConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,FormularioRenta107DataAccess.TABLENAME,FormularioRenta107DataAccess.ISWITHSTOREPROCEDURES);
			
			FormularioRenta107DataAccess.setFormularioRenta107OriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,FormularioRenta107 relformulariorenta107)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relformulariorenta107.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Empleado getEmpleado(Connexion connexion,FormularioRenta107 relformulariorenta107)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relformulariorenta107.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public Ejercicio getEjercicio(Connexion connexion,FormularioRenta107 relformulariorenta107)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relformulariorenta107.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}


		
		public List<DetalleFormularioRenta107> getDetalleFormularioRenta107s(Connexion connexion,FormularioRenta107 formulariorenta107)throws SQLException,Exception {

		List<DetalleFormularioRenta107> detalleformulariorenta107s= new ArrayList<DetalleFormularioRenta107>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+FormularioRenta107ConstantesFunciones.SCHEMA+".formulario_renta107 ON "+DetalleFormularioRenta107ConstantesFunciones.SCHEMA+".detalle_formulario_renta107.id_formulario_renta107="+FormularioRenta107ConstantesFunciones.SCHEMA+".formulario_renta107.id WHERE "+FormularioRenta107ConstantesFunciones.SCHEMA+".formulario_renta107.id="+String.valueOf(formulariorenta107.getId());
			} else {
				sQuery=" INNER JOIN detalleformulariorenta107.FormularioRenta107 WHERE detalleformulariorenta107.FormularioRenta107.id="+String.valueOf(formulariorenta107.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleFormularioRenta107DataAccess detalleformulariorenta107DataAccess=new DetalleFormularioRenta107DataAccess();

			detalleformulariorenta107DataAccess.setConnexionType(this.connexionType);
			detalleformulariorenta107DataAccess.setParameterDbType(this.parameterDbType);
			detalleformulariorenta107s=detalleformulariorenta107DataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalleformulariorenta107s;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,FormularioRenta107 formulariorenta107) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!formulariorenta107.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(formulariorenta107.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(formulariorenta107.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(formulariorenta107.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_pre_impreso=new ParameterValue<String>();
					parameterMaintenanceValuenumero_pre_impreso.setValue(formulariorenta107.getnumero_pre_impreso());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_pre_impreso);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_entrega=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_entrega.setValue(formulariorenta107.getfecha_entrega());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_entrega);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_generacion=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_generacion.setValue(formulariorenta107.getfecha_generacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_generacion);
					parametersTemp.add(parameterMaintenance);
					
						if(!formulariorenta107.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(formulariorenta107.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(formulariorenta107.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(formulariorenta107.getId());
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
	
	public void setIsNewIsChangedFalseFormularioRenta107(FormularioRenta107 formulariorenta107)throws Exception  {		
		formulariorenta107.setIsNew(false);
		formulariorenta107.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseFormularioRenta107s(List<FormularioRenta107> formulariorenta107s)throws Exception  {				
		for(FormularioRenta107 formulariorenta107:formulariorenta107s) {
			formulariorenta107.setIsNew(false);
			formulariorenta107.setIsChanged(false);
		}
	}
	
	public void generarExportarFormularioRenta107(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
