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
import com.bydan.erp.contabilidad.util.*;//FormularioIvaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class FormularioIvaDataAccess extends  FormularioIvaDataAccessAdditional{ //FormularioIvaDataAccessAdditional,DataAccessHelper<FormularioIva>
	//static Logger logger = Logger.getLogger(FormularioIvaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="formulario_iva";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+FormularioIvaConstantesFunciones.SCHEMA+"."+FormularioIvaConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_ejercicio,id_periodo,id_dato_formulario_iva,id_grupo_parametro_formulario_iva,id_parametro_formulario_iva,valor)values(current_timestamp,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+FormularioIvaConstantesFunciones.SCHEMA+"."+FormularioIvaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_ejercicio=?,id_periodo=?,id_dato_formulario_iva=?,id_grupo_parametro_formulario_iva=?,id_parametro_formulario_iva=?,valor=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+FormularioIvaConstantesFunciones.SCHEMA+"."+FormularioIvaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select formularioiva from "+FormularioIvaConstantesFunciones.SPERSISTENCENAME+" formularioiva";
	public static String QUERYSELECTNATIVE="select "+FormularioIvaConstantesFunciones.SCHEMA+"."+FormularioIvaConstantesFunciones.TABLENAME+".id,"+FormularioIvaConstantesFunciones.SCHEMA+"."+FormularioIvaConstantesFunciones.TABLENAME+".version_row,"+FormularioIvaConstantesFunciones.SCHEMA+"."+FormularioIvaConstantesFunciones.TABLENAME+".id_empresa,"+FormularioIvaConstantesFunciones.SCHEMA+"."+FormularioIvaConstantesFunciones.TABLENAME+".id_ejercicio,"+FormularioIvaConstantesFunciones.SCHEMA+"."+FormularioIvaConstantesFunciones.TABLENAME+".id_periodo,"+FormularioIvaConstantesFunciones.SCHEMA+"."+FormularioIvaConstantesFunciones.TABLENAME+".id_dato_formulario_iva,"+FormularioIvaConstantesFunciones.SCHEMA+"."+FormularioIvaConstantesFunciones.TABLENAME+".id_grupo_parametro_formulario_iva,"+FormularioIvaConstantesFunciones.SCHEMA+"."+FormularioIvaConstantesFunciones.TABLENAME+".id_parametro_formulario_iva,"+FormularioIvaConstantesFunciones.SCHEMA+"."+FormularioIvaConstantesFunciones.TABLENAME+".valor from "+FormularioIvaConstantesFunciones.SCHEMA+"."+FormularioIvaConstantesFunciones.TABLENAME;//+" as "+FormularioIvaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+FormularioIvaConstantesFunciones.SCHEMA+"."+FormularioIvaConstantesFunciones.TABLENAME+".id,"+FormularioIvaConstantesFunciones.SCHEMA+"."+FormularioIvaConstantesFunciones.TABLENAME+".version_row from "+FormularioIvaConstantesFunciones.SCHEMA+"."+FormularioIvaConstantesFunciones.TABLENAME;//+" as "+FormularioIvaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+FormularioIvaConstantesFunciones.SCHEMA+"."+FormularioIvaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_ejercicio=?,id_periodo=?,id_dato_formulario_iva=?,id_grupo_parametro_formulario_iva=?,id_parametro_formulario_iva=?,valor=?";
	
	public static String STOREPROCEDUREINSERT="call SP_FORMULARIOIVA_INSERT(?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_FORMULARIOIVA_UPDATE(?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_FORMULARIOIVA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_FORMULARIOIVA_SELECT(?,?)";
	
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
	
	
	protected FormularioIvaDataAccessAdditional formularioivaDataAccessAdditional=null;
	
	public FormularioIvaDataAccessAdditional getFormularioIvaDataAccessAdditional() {
		return this.formularioivaDataAccessAdditional;
	}
	
	public void setFormularioIvaDataAccessAdditional(FormularioIvaDataAccessAdditional formularioivaDataAccessAdditional) {
		try {
			this.formularioivaDataAccessAdditional=formularioivaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public FormularioIvaDataAccess() {
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
		FormularioIvaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		FormularioIvaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		FormularioIvaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setFormularioIvaOriginal(FormularioIva formularioiva)throws Exception  {
		formularioiva.setFormularioIvaOriginal((FormularioIva)formularioiva.clone());		
	}
	
	public void setFormularioIvasOriginal(List<FormularioIva> formularioivas)throws Exception  {
		
		for(FormularioIva formularioiva:formularioivas){
			formularioiva.setFormularioIvaOriginal((FormularioIva)formularioiva.clone());
		}
	}
	
	public static void setFormularioIvaOriginalStatic(FormularioIva formularioiva)throws Exception  {
		formularioiva.setFormularioIvaOriginal((FormularioIva)formularioiva.clone());		
	}
	
	public static void setFormularioIvasOriginalStatic(List<FormularioIva> formularioivas)throws Exception  {
		
		for(FormularioIva formularioiva:formularioivas){
			formularioiva.setFormularioIvaOriginal((FormularioIva)formularioiva.clone());
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
	
	public  FormularioIva getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		FormularioIva entity = new FormularioIva();		
		
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
	
	public  FormularioIva getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		FormularioIva entity = new FormularioIva();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=FormularioIvaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=FormularioIvaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Contabilidad.FormularioIva.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setFormularioIvaOriginal(new FormularioIva());
      	    	entity=super.getEntity("",entity,resultSet,FormularioIvaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityFormularioIva("",entity,resultSet); 
				
				//entity.setFormularioIvaOriginal(super.getEntity("",entity.getFormularioIvaOriginal(),resultSet,FormularioIvaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFormularioIvaOriginal(this.getEntityFormularioIva("",entity.getFormularioIvaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseFormularioIva(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  FormularioIva getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		FormularioIva entity = new FormularioIva();
				
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
	
	public  FormularioIva getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		FormularioIva entity = new FormularioIva();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=FormularioIvaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=FormularioIvaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FormularioIvaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.FormularioIva.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setFormularioIvaOriginal(new FormularioIva());
      	    	entity=super.getEntity("",entity,resultSet,FormularioIvaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityFormularioIva("",entity,resultSet);    
				
				//entity.setFormularioIvaOriginal(super.getEntity("",entity.getFormularioIvaOriginal(),resultSet,FormularioIvaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFormularioIvaOriginal(this.getEntityFormularioIva("",entity.getFormularioIvaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseFormularioIva(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //FormularioIva
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		FormularioIva entity = new FormularioIva();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=FormularioIvaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=FormularioIvaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FormularioIvaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.FormularioIva.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseFormularioIva(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<FormularioIva> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<FormularioIva> entities = new  ArrayList<FormularioIva>();
		FormularioIva entity = new FormularioIva();		  
		
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
	
	public  List<FormularioIva> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<FormularioIva> entities = new  ArrayList<FormularioIva>();
		FormularioIva entity = new FormularioIva();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=FormularioIvaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=FormularioIvaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FormularioIvaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FormularioIva();
      	    	entity=super.getEntity("",entity,resultSet,FormularioIvaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityFormularioIva("",entity,resultSet);
      	    	
				//entity.setFormularioIvaOriginal( new FormularioIva());
      	    	//entity.setFormularioIvaOriginal(super.getEntity("",entity.getFormularioIvaOriginal(),resultSet,FormularioIvaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFormularioIvaOriginal(this.getEntityFormularioIva("",entity.getFormularioIvaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseFormularioIvas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFormularioIva(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<FormularioIva> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<FormularioIva> entities = new  ArrayList<FormularioIva>();
		FormularioIva entity = new FormularioIva();		  
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
	
	public  List<FormularioIva> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<FormularioIva> entities = new  ArrayList<FormularioIva>();
		FormularioIva entity = new FormularioIva();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FormularioIva();
				
				if(conMapGenerico) {
					entity.inicializarMapFormularioIva();
					//entity.setMapFormularioIva(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapFormularioIvaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapFormularioIva().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,FormularioIvaDataAccess.ISWITHSCHEMA);         		
					entity=FormularioIvaDataAccess.getEntityFormularioIva("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setFormularioIvaOriginal( new FormularioIva());
					////entity.setFormularioIvaOriginal(super.getEntity("",entity.getFormularioIvaOriginal(),resultSet,FormularioIvaDataAccess.ISWITHSCHEMA));         		
					////entity.setFormularioIvaOriginal(this.getEntityFormularioIva("",entity.getFormularioIvaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseFormularioIvas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFormularioIva(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public FormularioIva getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		FormularioIva entity = new FormularioIva();		  
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
	
	public  FormularioIva getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		FormularioIva entity = new FormularioIva();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FormularioIva();
				
				if(conMapGenerico) {
					entity.inicializarMapFormularioIva();
					//entity.setMapFormularioIva(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapFormularioIvaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapFormularioIva().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,FormularioIvaDataAccess.ISWITHSCHEMA);         		
					entity=FormularioIvaDataAccess.getEntityFormularioIva("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setFormularioIvaOriginal( new FormularioIva());
					////entity.setFormularioIvaOriginal(super.getEntity("",entity.getFormularioIvaOriginal(),resultSet,FormularioIvaDataAccess.ISWITHSCHEMA));         		
					////entity.setFormularioIvaOriginal(this.getEntityFormularioIva("",entity.getFormularioIvaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseFormularioIva(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFormularioIva(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static FormularioIva getEntityFormularioIva(String strPrefijo,FormularioIva entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = FormularioIva.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = FormularioIva.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					FormularioIvaDataAccess.setFieldReflectionFormularioIva(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasFormularioIva=FormularioIvaConstantesFunciones.getTodosTiposColumnasFormularioIva();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasFormularioIva) {
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
							field = FormularioIva.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = FormularioIva.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						FormularioIvaDataAccess.setFieldReflectionFormularioIva(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionFormularioIva(Field field,String strPrefijo,String sColumn,FormularioIva entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case FormularioIvaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FormularioIvaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FormularioIvaConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FormularioIvaConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FormularioIvaConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FormularioIvaConstantesFunciones.IDDATOFORMULARIOIVA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FormularioIvaConstantesFunciones.IDGRUPOPARAMETROFORMULARIOIVA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FormularioIvaConstantesFunciones.IDPARAMETROFORMULARIOIVA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FormularioIvaConstantesFunciones.VALOR:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<FormularioIva>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<FormularioIva> entities = new  ArrayList<FormularioIva>();
		FormularioIva entity = new FormularioIva();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=FormularioIvaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=FormularioIvaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FormularioIvaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new FormularioIva();
					entity=super.getEntity("",entity,resultSet,FormularioIvaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityFormularioIva("",entity,resultSet);
					
					//entity.setFormularioIvaOriginal( new FormularioIva());
					//entity.setFormularioIvaOriginal(super.getEntity("",entity.getFormularioIvaOriginal(),resultSet,FormularioIvaDataAccess.ISWITHSCHEMA));         		
					//entity.setFormularioIvaOriginal(this.getEntityFormularioIva("",entity.getFormularioIvaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseFormularioIvas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFormularioIva(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<FormularioIva>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<FormularioIva> entities = new  ArrayList<FormularioIva>();
		FormularioIva entity = new FormularioIva();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=FormularioIvaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=FormularioIvaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FormularioIvaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<FormularioIva> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<FormularioIva> entities = new  ArrayList<FormularioIva>();
		FormularioIva entity = new FormularioIva();		  
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
	
	public  List<FormularioIva> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<FormularioIva> entities = new  ArrayList<FormularioIva>();
		FormularioIva entity = new FormularioIva();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FormularioIva();
      	    	entity=super.getEntity("",entity,resultSet,FormularioIvaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityFormularioIva("",entity,resultSet);
      	    	
				//entity.setFormularioIvaOriginal( new FormularioIva());
      	    	//entity.setFormularioIvaOriginal(super.getEntity("",entity.getFormularioIvaOriginal(),resultSet,FormularioIvaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFormularioIvaOriginal(this.getEntityFormularioIva("",entity.getFormularioIvaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseFormularioIvas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFormularioIva(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<FormularioIva> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<FormularioIva> entities = new  ArrayList<FormularioIva>();
		FormularioIva entity = new FormularioIva();		  
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
	
	public  List<FormularioIva> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<FormularioIva> entities = new  ArrayList<FormularioIva>();
		FormularioIva entity = new FormularioIva();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FormularioIva();
      	    	entity=super.getEntity("",entity,resultSet,FormularioIvaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityFormularioIva("",entity,resultSet);
      	    	
				//entity.setFormularioIvaOriginal( new FormularioIva());
      	    	//entity.setFormularioIvaOriginal(super.getEntity("",entity.getFormularioIvaOriginal(),resultSet,FormularioIvaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFormularioIvaOriginal(this.getEntityFormularioIva("",entity.getFormularioIvaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseFormularioIvas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public FormularioIva getEntityFormularioIva(String strPrefijo,FormularioIva entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+FormularioIvaConstantesFunciones.IDEMPRESA));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+FormularioIvaConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+FormularioIvaConstantesFunciones.IDPERIODO));
				entity.setid_dato_formulario_iva(resultSet.getLong(strPrefijo+FormularioIvaConstantesFunciones.IDDATOFORMULARIOIVA));
				entity.setid_grupo_parametro_formulario_iva(resultSet.getLong(strPrefijo+FormularioIvaConstantesFunciones.IDGRUPOPARAMETROFORMULARIOIVA));
				entity.setid_parametro_formulario_iva(resultSet.getLong(strPrefijo+FormularioIvaConstantesFunciones.IDPARAMETROFORMULARIOIVA));
				entity.setvalor(resultSet.getDouble(strPrefijo+FormularioIvaConstantesFunciones.VALOR));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowFormularioIva(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(FormularioIva entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=FormularioIvaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=FormularioIvaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=FormularioIvaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=FormularioIvaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(FormularioIvaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,FormularioIvaDataAccess.TABLENAME,FormularioIvaDataAccess.ISWITHSTOREPROCEDURES);
			
			FormularioIvaDataAccess.setFormularioIvaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,FormularioIva relformularioiva)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relformularioiva.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Ejercicio getEjercicio(Connexion connexion,FormularioIva relformularioiva)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relformularioiva.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,FormularioIva relformularioiva)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,relformularioiva.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public DatoFormularioIva getDatoFormularioIva(Connexion connexion,FormularioIva relformularioiva)throws SQLException,Exception {

		DatoFormularioIva datoformularioiva= new DatoFormularioIva();

		try {
			DatoFormularioIvaDataAccess datoformularioivaDataAccess=new DatoFormularioIvaDataAccess();

			datoformularioivaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			datoformularioivaDataAccess.setConnexionType(this.connexionType);
			datoformularioivaDataAccess.setParameterDbType(this.parameterDbType);

			datoformularioiva=datoformularioivaDataAccess.getEntity(connexion,relformularioiva.getid_dato_formulario_iva());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return datoformularioiva;

	}

	public GrupoParametroFormularioIva getGrupoParametroFormularioIva(Connexion connexion,FormularioIva relformularioiva)throws SQLException,Exception {

		GrupoParametroFormularioIva grupoparametroformularioiva= new GrupoParametroFormularioIva();

		try {
			GrupoParametroFormularioIvaDataAccess grupoparametroformularioivaDataAccess=new GrupoParametroFormularioIvaDataAccess();

			grupoparametroformularioivaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			grupoparametroformularioivaDataAccess.setConnexionType(this.connexionType);
			grupoparametroformularioivaDataAccess.setParameterDbType(this.parameterDbType);

			grupoparametroformularioiva=grupoparametroformularioivaDataAccess.getEntity(connexion,relformularioiva.getid_grupo_parametro_formulario_iva());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return grupoparametroformularioiva;

	}

	public ParametroFormularioIva getParametroFormularioIva(Connexion connexion,FormularioIva relformularioiva)throws SQLException,Exception {

		ParametroFormularioIva parametroformularioiva= new ParametroFormularioIva();

		try {
			ParametroFormularioIvaDataAccess parametroformularioivaDataAccess=new ParametroFormularioIvaDataAccess();

			parametroformularioivaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			parametroformularioivaDataAccess.setConnexionType(this.connexionType);
			parametroformularioivaDataAccess.setParameterDbType(this.parameterDbType);

			parametroformularioiva=parametroformularioivaDataAccess.getEntity(connexion,relformularioiva.getid_parametro_formulario_iva());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return parametroformularioiva;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,FormularioIva formularioiva) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!formularioiva.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(formularioiva.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(formularioiva.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(formularioiva.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_dato_formulario_iva=new ParameterValue<Long>();
					parameterMaintenanceValueid_dato_formulario_iva.setValue(formularioiva.getid_dato_formulario_iva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_dato_formulario_iva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_grupo_parametro_formulario_iva=new ParameterValue<Long>();
					parameterMaintenanceValueid_grupo_parametro_formulario_iva.setValue(formularioiva.getid_grupo_parametro_formulario_iva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_grupo_parametro_formulario_iva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_parametro_formulario_iva=new ParameterValue<Long>();
					parameterMaintenanceValueid_parametro_formulario_iva.setValue(formularioiva.getid_parametro_formulario_iva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_parametro_formulario_iva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor=new ParameterValue<Double>();
					parameterMaintenanceValuevalor.setValue(formularioiva.getvalor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor);
					parametersTemp.add(parameterMaintenance);
					
						if(!formularioiva.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(formularioiva.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(formularioiva.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(formularioiva.getId());
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
	
	public void setIsNewIsChangedFalseFormularioIva(FormularioIva formularioiva)throws Exception  {		
		formularioiva.setIsNew(false);
		formularioiva.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseFormularioIvas(List<FormularioIva> formularioivas)throws Exception  {				
		for(FormularioIva formularioiva:formularioivas) {
			formularioiva.setIsNew(false);
			formularioiva.setIsChanged(false);
		}
	}
	
	public void generarExportarFormularioIva(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
