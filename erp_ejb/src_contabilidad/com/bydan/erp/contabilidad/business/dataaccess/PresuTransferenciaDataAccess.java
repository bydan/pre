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
import com.bydan.erp.contabilidad.util.*;//PresuTransferenciaConstantesFunciones;


import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.nomina.business.dataaccess.*;


import com.bydan.erp.nomina.util.*;




@SuppressWarnings("unused")
final public class PresuTransferenciaDataAccess extends  PresuTransferenciaDataAccessAdditional{ //PresuTransferenciaDataAccessAdditional,DataAccessHelper<PresuTransferencia>
	//static Logger logger = Logger.getLogger(PresuTransferenciaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="presu_transferencia";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+PresuTransferenciaConstantesFunciones.SCHEMA+"."+PresuTransferenciaConstantesFunciones.TABLENAME+"(version_row,id_presu_proyecto,id_cuenta_contable,id_cuenta_contable_destino,id_empleado,fecha,valor,descripcion)values(current_timestamp,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+PresuTransferenciaConstantesFunciones.SCHEMA+"."+PresuTransferenciaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_presu_proyecto=?,id_cuenta_contable=?,id_cuenta_contable_destino=?,id_empleado=?,fecha=?,valor=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+PresuTransferenciaConstantesFunciones.SCHEMA+"."+PresuTransferenciaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select presutransferencia from "+PresuTransferenciaConstantesFunciones.SPERSISTENCENAME+" presutransferencia";
	public static String QUERYSELECTNATIVE="select "+PresuTransferenciaConstantesFunciones.SCHEMA+"."+PresuTransferenciaConstantesFunciones.TABLENAME+".id,"+PresuTransferenciaConstantesFunciones.SCHEMA+"."+PresuTransferenciaConstantesFunciones.TABLENAME+".version_row,"+PresuTransferenciaConstantesFunciones.SCHEMA+"."+PresuTransferenciaConstantesFunciones.TABLENAME+".id_presu_proyecto,"+PresuTransferenciaConstantesFunciones.SCHEMA+"."+PresuTransferenciaConstantesFunciones.TABLENAME+".id_cuenta_contable,"+PresuTransferenciaConstantesFunciones.SCHEMA+"."+PresuTransferenciaConstantesFunciones.TABLENAME+".id_cuenta_contable_destino,"+PresuTransferenciaConstantesFunciones.SCHEMA+"."+PresuTransferenciaConstantesFunciones.TABLENAME+".id_empleado,"+PresuTransferenciaConstantesFunciones.SCHEMA+"."+PresuTransferenciaConstantesFunciones.TABLENAME+".fecha,"+PresuTransferenciaConstantesFunciones.SCHEMA+"."+PresuTransferenciaConstantesFunciones.TABLENAME+".valor,"+PresuTransferenciaConstantesFunciones.SCHEMA+"."+PresuTransferenciaConstantesFunciones.TABLENAME+".descripcion from "+PresuTransferenciaConstantesFunciones.SCHEMA+"."+PresuTransferenciaConstantesFunciones.TABLENAME;//+" as "+PresuTransferenciaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+PresuTransferenciaConstantesFunciones.SCHEMA+"."+PresuTransferenciaConstantesFunciones.TABLENAME+".id,"+PresuTransferenciaConstantesFunciones.SCHEMA+"."+PresuTransferenciaConstantesFunciones.TABLENAME+".version_row from "+PresuTransferenciaConstantesFunciones.SCHEMA+"."+PresuTransferenciaConstantesFunciones.TABLENAME;//+" as "+PresuTransferenciaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+PresuTransferenciaConstantesFunciones.SCHEMA+"."+PresuTransferenciaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_presu_proyecto=?,id_cuenta_contable=?,id_cuenta_contable_destino=?,id_empleado=?,fecha=?,valor=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PRESUTRANSFERENCIA_INSERT(?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PRESUTRANSFERENCIA_UPDATE(?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PRESUTRANSFERENCIA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PRESUTRANSFERENCIA_SELECT(?,?)";
	
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
	
	
	protected PresuTransferenciaDataAccessAdditional presutransferenciaDataAccessAdditional=null;
	
	public PresuTransferenciaDataAccessAdditional getPresuTransferenciaDataAccessAdditional() {
		return this.presutransferenciaDataAccessAdditional;
	}
	
	public void setPresuTransferenciaDataAccessAdditional(PresuTransferenciaDataAccessAdditional presutransferenciaDataAccessAdditional) {
		try {
			this.presutransferenciaDataAccessAdditional=presutransferenciaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public PresuTransferenciaDataAccess() {
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
		PresuTransferenciaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		PresuTransferenciaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		PresuTransferenciaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setPresuTransferenciaOriginal(PresuTransferencia presutransferencia)throws Exception  {
		presutransferencia.setPresuTransferenciaOriginal((PresuTransferencia)presutransferencia.clone());		
	}
	
	public void setPresuTransferenciasOriginal(List<PresuTransferencia> presutransferencias)throws Exception  {
		
		for(PresuTransferencia presutransferencia:presutransferencias){
			presutransferencia.setPresuTransferenciaOriginal((PresuTransferencia)presutransferencia.clone());
		}
	}
	
	public static void setPresuTransferenciaOriginalStatic(PresuTransferencia presutransferencia)throws Exception  {
		presutransferencia.setPresuTransferenciaOriginal((PresuTransferencia)presutransferencia.clone());		
	}
	
	public static void setPresuTransferenciasOriginalStatic(List<PresuTransferencia> presutransferencias)throws Exception  {
		
		for(PresuTransferencia presutransferencia:presutransferencias){
			presutransferencia.setPresuTransferenciaOriginal((PresuTransferencia)presutransferencia.clone());
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
	
	public  PresuTransferencia getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		PresuTransferencia entity = new PresuTransferencia();		
		
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
	
	public  PresuTransferencia getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		PresuTransferencia entity = new PresuTransferencia();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PresuTransferenciaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PresuTransferenciaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Contabilidad.PresuTransferencia.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setPresuTransferenciaOriginal(new PresuTransferencia());
      	    	entity=super.getEntity("",entity,resultSet,PresuTransferenciaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPresuTransferencia("",entity,resultSet); 
				
				//entity.setPresuTransferenciaOriginal(super.getEntity("",entity.getPresuTransferenciaOriginal(),resultSet,PresuTransferenciaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPresuTransferenciaOriginal(this.getEntityPresuTransferencia("",entity.getPresuTransferenciaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalsePresuTransferencia(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  PresuTransferencia getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		PresuTransferencia entity = new PresuTransferencia();
				
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
	
	public  PresuTransferencia getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		PresuTransferencia entity = new PresuTransferencia();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PresuTransferenciaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PresuTransferenciaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PresuTransferenciaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.PresuTransferencia.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setPresuTransferenciaOriginal(new PresuTransferencia());
      	    	entity=super.getEntity("",entity,resultSet,PresuTransferenciaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPresuTransferencia("",entity,resultSet);    
				
				//entity.setPresuTransferenciaOriginal(super.getEntity("",entity.getPresuTransferenciaOriginal(),resultSet,PresuTransferenciaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPresuTransferenciaOriginal(this.getEntityPresuTransferencia("",entity.getPresuTransferenciaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalsePresuTransferencia(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //PresuTransferencia
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		PresuTransferencia entity = new PresuTransferencia();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PresuTransferenciaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PresuTransferenciaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PresuTransferenciaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.PresuTransferencia.isActive=1
        	 
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
				//this.setIsNewIsChangedFalsePresuTransferencia(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<PresuTransferencia> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<PresuTransferencia> entities = new  ArrayList<PresuTransferencia>();
		PresuTransferencia entity = new PresuTransferencia();		  
		
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
	
	public  List<PresuTransferencia> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<PresuTransferencia> entities = new  ArrayList<PresuTransferencia>();
		PresuTransferencia entity = new PresuTransferencia();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=PresuTransferenciaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PresuTransferenciaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PresuTransferenciaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PresuTransferencia();
      	    	entity=super.getEntity("",entity,resultSet,PresuTransferenciaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPresuTransferencia("",entity,resultSet);
      	    	
				//entity.setPresuTransferenciaOriginal( new PresuTransferencia());
      	    	//entity.setPresuTransferenciaOriginal(super.getEntity("",entity.getPresuTransferenciaOriginal(),resultSet,PresuTransferenciaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPresuTransferenciaOriginal(this.getEntityPresuTransferencia("",entity.getPresuTransferenciaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePresuTransferencias(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPresuTransferencia(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<PresuTransferencia> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<PresuTransferencia> entities = new  ArrayList<PresuTransferencia>();
		PresuTransferencia entity = new PresuTransferencia();		  
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
	
	public  List<PresuTransferencia> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<PresuTransferencia> entities = new  ArrayList<PresuTransferencia>();
		PresuTransferencia entity = new PresuTransferencia();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PresuTransferencia();
				
				if(conMapGenerico) {
					entity.inicializarMapPresuTransferencia();
					//entity.setMapPresuTransferencia(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapPresuTransferenciaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPresuTransferencia().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PresuTransferenciaDataAccess.ISWITHSCHEMA);         		
					entity=PresuTransferenciaDataAccess.getEntityPresuTransferencia("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setPresuTransferenciaOriginal( new PresuTransferencia());
					////entity.setPresuTransferenciaOriginal(super.getEntity("",entity.getPresuTransferenciaOriginal(),resultSet,PresuTransferenciaDataAccess.ISWITHSCHEMA));         		
					////entity.setPresuTransferenciaOriginal(this.getEntityPresuTransferencia("",entity.getPresuTransferenciaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePresuTransferencias(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPresuTransferencia(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public PresuTransferencia getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		PresuTransferencia entity = new PresuTransferencia();		  
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
	
	public  PresuTransferencia getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		PresuTransferencia entity = new PresuTransferencia();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PresuTransferencia();
				
				if(conMapGenerico) {
					entity.inicializarMapPresuTransferencia();
					//entity.setMapPresuTransferencia(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapPresuTransferenciaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPresuTransferencia().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PresuTransferenciaDataAccess.ISWITHSCHEMA);         		
					entity=PresuTransferenciaDataAccess.getEntityPresuTransferencia("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setPresuTransferenciaOriginal( new PresuTransferencia());
					////entity.setPresuTransferenciaOriginal(super.getEntity("",entity.getPresuTransferenciaOriginal(),resultSet,PresuTransferenciaDataAccess.ISWITHSCHEMA));         		
					////entity.setPresuTransferenciaOriginal(this.getEntityPresuTransferencia("",entity.getPresuTransferenciaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalsePresuTransferencia(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPresuTransferencia(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static PresuTransferencia getEntityPresuTransferencia(String strPrefijo,PresuTransferencia entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = PresuTransferencia.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = PresuTransferencia.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					PresuTransferenciaDataAccess.setFieldReflectionPresuTransferencia(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasPresuTransferencia=PresuTransferenciaConstantesFunciones.getTodosTiposColumnasPresuTransferencia();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasPresuTransferencia) {
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
							field = PresuTransferencia.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = PresuTransferencia.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						PresuTransferenciaDataAccess.setFieldReflectionPresuTransferencia(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionPresuTransferencia(Field field,String strPrefijo,String sColumn,PresuTransferencia entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case PresuTransferenciaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresuTransferenciaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PresuTransferenciaConstantesFunciones.IDPRESUPROYECTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresuTransferenciaConstantesFunciones.IDCUENTACONTABLE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresuTransferenciaConstantesFunciones.IDCUENTACONTABLEDESTINO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresuTransferenciaConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresuTransferenciaConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case PresuTransferenciaConstantesFunciones.VALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PresuTransferenciaConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<PresuTransferencia>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<PresuTransferencia> entities = new  ArrayList<PresuTransferencia>();
		PresuTransferencia entity = new PresuTransferencia();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PresuTransferenciaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PresuTransferenciaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PresuTransferenciaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new PresuTransferencia();
					entity=super.getEntity("",entity,resultSet,PresuTransferenciaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityPresuTransferencia("",entity,resultSet);
					
					//entity.setPresuTransferenciaOriginal( new PresuTransferencia());
					//entity.setPresuTransferenciaOriginal(super.getEntity("",entity.getPresuTransferenciaOriginal(),resultSet,PresuTransferenciaDataAccess.ISWITHSCHEMA));         		
					//entity.setPresuTransferenciaOriginal(this.getEntityPresuTransferencia("",entity.getPresuTransferenciaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalsePresuTransferencias(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPresuTransferencia(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<PresuTransferencia>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<PresuTransferencia> entities = new  ArrayList<PresuTransferencia>();
		PresuTransferencia entity = new PresuTransferencia();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PresuTransferenciaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PresuTransferenciaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PresuTransferenciaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<PresuTransferencia> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PresuTransferencia> entities = new  ArrayList<PresuTransferencia>();
		PresuTransferencia entity = new PresuTransferencia();		  
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
	
	public  List<PresuTransferencia> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PresuTransferencia> entities = new  ArrayList<PresuTransferencia>();
		PresuTransferencia entity = new PresuTransferencia();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PresuTransferencia();
      	    	entity=super.getEntity("",entity,resultSet,PresuTransferenciaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPresuTransferencia("",entity,resultSet);
      	    	
				//entity.setPresuTransferenciaOriginal( new PresuTransferencia());
      	    	//entity.setPresuTransferenciaOriginal(super.getEntity("",entity.getPresuTransferenciaOriginal(),resultSet,PresuTransferenciaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPresuTransferenciaOriginal(this.getEntityPresuTransferencia("",entity.getPresuTransferenciaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalsePresuTransferencias(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPresuTransferencia(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<PresuTransferencia> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PresuTransferencia> entities = new  ArrayList<PresuTransferencia>();
		PresuTransferencia entity = new PresuTransferencia();		  
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
	
	public  List<PresuTransferencia> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PresuTransferencia> entities = new  ArrayList<PresuTransferencia>();
		PresuTransferencia entity = new PresuTransferencia();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PresuTransferencia();
      	    	entity=super.getEntity("",entity,resultSet,PresuTransferenciaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPresuTransferencia("",entity,resultSet);
      	    	
				//entity.setPresuTransferenciaOriginal( new PresuTransferencia());
      	    	//entity.setPresuTransferenciaOriginal(super.getEntity("",entity.getPresuTransferenciaOriginal(),resultSet,PresuTransferenciaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPresuTransferenciaOriginal(this.getEntityPresuTransferencia("",entity.getPresuTransferenciaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePresuTransferencias(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public PresuTransferencia getEntityPresuTransferencia(String strPrefijo,PresuTransferencia entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_presu_proyecto(resultSet.getLong(strPrefijo+PresuTransferenciaConstantesFunciones.IDPRESUPROYECTO));
				entity.setid_cuenta_contable(resultSet.getLong(strPrefijo+PresuTransferenciaConstantesFunciones.IDCUENTACONTABLE));
				entity.setid_cuenta_contable_destino(resultSet.getLong(strPrefijo+PresuTransferenciaConstantesFunciones.IDCUENTACONTABLEDESTINO));
				entity.setid_empleado(resultSet.getLong(strPrefijo+PresuTransferenciaConstantesFunciones.IDEMPLEADO));
				entity.setfecha(new Date(resultSet.getDate(strPrefijo+PresuTransferenciaConstantesFunciones.FECHA).getTime()));
				entity.setvalor(resultSet.getDouble(strPrefijo+PresuTransferenciaConstantesFunciones.VALOR));
				entity.setdescripcion(resultSet.getString(strPrefijo+PresuTransferenciaConstantesFunciones.DESCRIPCION));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowPresuTransferencia(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(PresuTransferencia entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=PresuTransferenciaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=PresuTransferenciaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=PresuTransferenciaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=PresuTransferenciaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(PresuTransferenciaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,PresuTransferenciaDataAccess.TABLENAME,PresuTransferenciaDataAccess.ISWITHSTOREPROCEDURES);
			
			PresuTransferenciaDataAccess.setPresuTransferenciaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public PresuProyecto getPresuProyecto(Connexion connexion,PresuTransferencia relpresutransferencia)throws SQLException,Exception {

		PresuProyecto presuproyecto= new PresuProyecto();

		try {
			PresuProyectoDataAccess presuproyectoDataAccess=new PresuProyectoDataAccess();

			presuproyectoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			presuproyectoDataAccess.setConnexionType(this.connexionType);
			presuproyectoDataAccess.setParameterDbType(this.parameterDbType);

			presuproyecto=presuproyectoDataAccess.getEntity(connexion,relpresutransferencia.getid_presu_proyecto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return presuproyecto;

	}

	public CuentaContable getCuentaContable(Connexion connexion,PresuTransferencia relpresutransferencia)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relpresutransferencia.getid_cuenta_contable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableDestino(Connexion connexion,PresuTransferencia relpresutransferencia)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relpresutransferencia.getid_cuenta_contable_destino());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public Empleado getEmpleado(Connexion connexion,PresuTransferencia relpresutransferencia)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relpresutransferencia.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,PresuTransferencia presutransferencia) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!presutransferencia.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_presu_proyecto=new ParameterValue<Long>();
					parameterMaintenanceValueid_presu_proyecto.setValue(presutransferencia.getid_presu_proyecto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_presu_proyecto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable.setValue(presutransferencia.getid_cuenta_contable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_destino=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_destino.setValue(presutransferencia.getid_cuenta_contable_destino());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_destino);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(presutransferencia.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha=new ParameterValue<Date>();
					parameterMaintenanceValuefecha.setValue(presutransferencia.getfecha());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor=new ParameterValue<Double>();
					parameterMaintenanceValuevalor.setValue(presutransferencia.getvalor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(presutransferencia.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!presutransferencia.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(presutransferencia.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(presutransferencia.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(presutransferencia.getId());
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
	
	public void setIsNewIsChangedFalsePresuTransferencia(PresuTransferencia presutransferencia)throws Exception  {		
		presutransferencia.setIsNew(false);
		presutransferencia.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalsePresuTransferencias(List<PresuTransferencia> presutransferencias)throws Exception  {				
		for(PresuTransferencia presutransferencia:presutransferencias) {
			presutransferencia.setIsNew(false);
			presutransferencia.setIsChanged(false);
		}
	}
	
	public void generarExportarPresuTransferencia(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
