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
package com.bydan.erp.seguridad.business.dataaccess;

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

import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.seguridad.util.*;//ParametroSeguridadConstantesFunciones;










@SuppressWarnings("unused")
final public class ParametroSeguridadDataAccess extends  ParametroSeguridadDataAccessAdditional{ //ParametroSeguridadDataAccessAdditional,DataAccessHelper<ParametroSeguridad>
	//static Logger logger = Logger.getLogger(ParametroSeguridadDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="parametro_seguridad";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ParametroSeguridadConstantesFunciones.SCHEMA+"."+ParametroSeguridadConstantesFunciones.TABLENAME+"(version_row,id_empresa,con_cartera,con_copiar_clientes,con_copiar_proveedores,con_generar_cliente_prove,cliente_con_secuencial_auto,cliente_num_maximo_iniciales,prove_con_secuencial_auto,prove_num_maximo_iniciales,con_validar_grupos,acti_fijo_con_secuencial_auto)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+ParametroSeguridadConstantesFunciones.SCHEMA+"."+ParametroSeguridadConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,con_cartera=?,con_copiar_clientes=?,con_copiar_proveedores=?,con_generar_cliente_prove=?,cliente_con_secuencial_auto=?,cliente_num_maximo_iniciales=?,prove_con_secuencial_auto=?,prove_num_maximo_iniciales=?,con_validar_grupos=?,acti_fijo_con_secuencial_auto=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ParametroSeguridadConstantesFunciones.SCHEMA+"."+ParametroSeguridadConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select parametroseguridad from "+ParametroSeguridadConstantesFunciones.SPERSISTENCENAME+" parametroseguridad";
	public static String QUERYSELECTNATIVE="select "+ParametroSeguridadConstantesFunciones.SCHEMA+"."+ParametroSeguridadConstantesFunciones.TABLENAME+".id,"+ParametroSeguridadConstantesFunciones.SCHEMA+"."+ParametroSeguridadConstantesFunciones.TABLENAME+".version_row,"+ParametroSeguridadConstantesFunciones.SCHEMA+"."+ParametroSeguridadConstantesFunciones.TABLENAME+".id_empresa,"+ParametroSeguridadConstantesFunciones.SCHEMA+"."+ParametroSeguridadConstantesFunciones.TABLENAME+".con_cartera,"+ParametroSeguridadConstantesFunciones.SCHEMA+"."+ParametroSeguridadConstantesFunciones.TABLENAME+".con_copiar_clientes,"+ParametroSeguridadConstantesFunciones.SCHEMA+"."+ParametroSeguridadConstantesFunciones.TABLENAME+".con_copiar_proveedores,"+ParametroSeguridadConstantesFunciones.SCHEMA+"."+ParametroSeguridadConstantesFunciones.TABLENAME+".con_generar_cliente_prove,"+ParametroSeguridadConstantesFunciones.SCHEMA+"."+ParametroSeguridadConstantesFunciones.TABLENAME+".cliente_con_secuencial_auto,"+ParametroSeguridadConstantesFunciones.SCHEMA+"."+ParametroSeguridadConstantesFunciones.TABLENAME+".cliente_num_maximo_iniciales,"+ParametroSeguridadConstantesFunciones.SCHEMA+"."+ParametroSeguridadConstantesFunciones.TABLENAME+".prove_con_secuencial_auto,"+ParametroSeguridadConstantesFunciones.SCHEMA+"."+ParametroSeguridadConstantesFunciones.TABLENAME+".prove_num_maximo_iniciales,"+ParametroSeguridadConstantesFunciones.SCHEMA+"."+ParametroSeguridadConstantesFunciones.TABLENAME+".con_validar_grupos,"+ParametroSeguridadConstantesFunciones.SCHEMA+"."+ParametroSeguridadConstantesFunciones.TABLENAME+".acti_fijo_con_secuencial_auto from "+ParametroSeguridadConstantesFunciones.SCHEMA+"."+ParametroSeguridadConstantesFunciones.TABLENAME;//+" as "+ParametroSeguridadConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ParametroSeguridadConstantesFunciones.SCHEMA+"."+ParametroSeguridadConstantesFunciones.TABLENAME+".id,"+ParametroSeguridadConstantesFunciones.SCHEMA+"."+ParametroSeguridadConstantesFunciones.TABLENAME+".version_row from "+ParametroSeguridadConstantesFunciones.SCHEMA+"."+ParametroSeguridadConstantesFunciones.TABLENAME;//+" as "+ParametroSeguridadConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ParametroSeguridadConstantesFunciones.SCHEMA+"."+ParametroSeguridadConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,con_cartera=?,con_copiar_clientes=?,con_copiar_proveedores=?,con_generar_cliente_prove=?,cliente_con_secuencial_auto=?,cliente_num_maximo_iniciales=?,prove_con_secuencial_auto=?,prove_num_maximo_iniciales=?,con_validar_grupos=?,acti_fijo_con_secuencial_auto=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PARAMETROSEGURIDAD_INSERT(?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PARAMETROSEGURIDAD_UPDATE(?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PARAMETROSEGURIDAD_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PARAMETROSEGURIDAD_SELECT(?,?)";
	
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
	
	
	protected ParametroSeguridadDataAccessAdditional parametroseguridadDataAccessAdditional=null;
	
	public ParametroSeguridadDataAccessAdditional getParametroSeguridadDataAccessAdditional() {
		return this.parametroseguridadDataAccessAdditional;
	}
	
	public void setParametroSeguridadDataAccessAdditional(ParametroSeguridadDataAccessAdditional parametroseguridadDataAccessAdditional) {
		try {
			this.parametroseguridadDataAccessAdditional=parametroseguridadDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ParametroSeguridadDataAccess() {
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
		ParametroSeguridadDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ParametroSeguridadDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ParametroSeguridadDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setParametroSeguridadOriginal(ParametroSeguridad parametroseguridad)throws Exception  {
		parametroseguridad.setParametroSeguridadOriginal((ParametroSeguridad)parametroseguridad.clone());		
	}
	
	public void setParametroSeguridadsOriginal(List<ParametroSeguridad> parametroseguridads)throws Exception  {
		
		for(ParametroSeguridad parametroseguridad:parametroseguridads){
			parametroseguridad.setParametroSeguridadOriginal((ParametroSeguridad)parametroseguridad.clone());
		}
	}
	
	public static void setParametroSeguridadOriginalStatic(ParametroSeguridad parametroseguridad)throws Exception  {
		parametroseguridad.setParametroSeguridadOriginal((ParametroSeguridad)parametroseguridad.clone());		
	}
	
	public static void setParametroSeguridadsOriginalStatic(List<ParametroSeguridad> parametroseguridads)throws Exception  {
		
		for(ParametroSeguridad parametroseguridad:parametroseguridads){
			parametroseguridad.setParametroSeguridadOriginal((ParametroSeguridad)parametroseguridad.clone());
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
	
	public  ParametroSeguridad getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		ParametroSeguridad entity = new ParametroSeguridad();		
		
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
	
	public  ParametroSeguridad getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		ParametroSeguridad entity = new ParametroSeguridad();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroSeguridadDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroSeguridadDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Seguridad.ParametroSeguridad.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setParametroSeguridadOriginal(new ParametroSeguridad());
      	    	entity=super.getEntity("",entity,resultSet,ParametroSeguridadDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityParametroSeguridad("",entity,resultSet); 
				
				//entity.setParametroSeguridadOriginal(super.getEntity("",entity.getParametroSeguridadOriginal(),resultSet,ParametroSeguridadDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroSeguridadOriginal(this.getEntityParametroSeguridad("",entity.getParametroSeguridadOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseParametroSeguridad(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  ParametroSeguridad getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ParametroSeguridad entity = new ParametroSeguridad();
				
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
	
	public  ParametroSeguridad getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ParametroSeguridad entity = new ParametroSeguridad();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroSeguridadDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroSeguridadDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroSeguridadDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Seguridad.ParametroSeguridad.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setParametroSeguridadOriginal(new ParametroSeguridad());
      	    	entity=super.getEntity("",entity,resultSet,ParametroSeguridadDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityParametroSeguridad("",entity,resultSet);    
				
				//entity.setParametroSeguridadOriginal(super.getEntity("",entity.getParametroSeguridadOriginal(),resultSet,ParametroSeguridadDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroSeguridadOriginal(this.getEntityParametroSeguridad("",entity.getParametroSeguridadOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseParametroSeguridad(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //ParametroSeguridad
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		ParametroSeguridad entity = new ParametroSeguridad();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroSeguridadDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroSeguridadDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroSeguridadDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Seguridad.ParametroSeguridad.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseParametroSeguridad(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<ParametroSeguridad> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ParametroSeguridad> entities = new  ArrayList<ParametroSeguridad>();
		ParametroSeguridad entity = new ParametroSeguridad();		  
		
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
	
	public  List<ParametroSeguridad> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ParametroSeguridad> entities = new  ArrayList<ParametroSeguridad>();
		ParametroSeguridad entity = new ParametroSeguridad();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroSeguridadDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroSeguridadDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroSeguridadDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroSeguridad();
      	    	entity=super.getEntity("",entity,resultSet,ParametroSeguridadDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroSeguridad("",entity,resultSet);
      	    	
				//entity.setParametroSeguridadOriginal( new ParametroSeguridad());
      	    	//entity.setParametroSeguridadOriginal(super.getEntity("",entity.getParametroSeguridadOriginal(),resultSet,ParametroSeguridadDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroSeguridadOriginal(this.getEntityParametroSeguridad("",entity.getParametroSeguridadOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroSeguridads(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroSeguridad(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ParametroSeguridad> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ParametroSeguridad> entities = new  ArrayList<ParametroSeguridad>();
		ParametroSeguridad entity = new ParametroSeguridad();		  
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
	
	public  List<ParametroSeguridad> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ParametroSeguridad> entities = new  ArrayList<ParametroSeguridad>();
		ParametroSeguridad entity = new ParametroSeguridad();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroSeguridad();
				
				if(conMapGenerico) {
					entity.inicializarMapParametroSeguridad();
					//entity.setMapParametroSeguridad(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapParametroSeguridadValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapParametroSeguridad().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ParametroSeguridadDataAccess.ISWITHSCHEMA);         		
					entity=ParametroSeguridadDataAccess.getEntityParametroSeguridad("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setParametroSeguridadOriginal( new ParametroSeguridad());
					////entity.setParametroSeguridadOriginal(super.getEntity("",entity.getParametroSeguridadOriginal(),resultSet,ParametroSeguridadDataAccess.ISWITHSCHEMA));         		
					////entity.setParametroSeguridadOriginal(this.getEntityParametroSeguridad("",entity.getParametroSeguridadOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroSeguridads(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroSeguridad(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public ParametroSeguridad getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ParametroSeguridad entity = new ParametroSeguridad();		  
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
	
	public  ParametroSeguridad getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ParametroSeguridad entity = new ParametroSeguridad();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroSeguridad();
				
				if(conMapGenerico) {
					entity.inicializarMapParametroSeguridad();
					//entity.setMapParametroSeguridad(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapParametroSeguridadValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapParametroSeguridad().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ParametroSeguridadDataAccess.ISWITHSCHEMA);         		
					entity=ParametroSeguridadDataAccess.getEntityParametroSeguridad("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setParametroSeguridadOriginal( new ParametroSeguridad());
					////entity.setParametroSeguridadOriginal(super.getEntity("",entity.getParametroSeguridadOriginal(),resultSet,ParametroSeguridadDataAccess.ISWITHSCHEMA));         		
					////entity.setParametroSeguridadOriginal(this.getEntityParametroSeguridad("",entity.getParametroSeguridadOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseParametroSeguridad(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroSeguridad(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ParametroSeguridad getEntityParametroSeguridad(String strPrefijo,ParametroSeguridad entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = ParametroSeguridad.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = ParametroSeguridad.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ParametroSeguridadDataAccess.setFieldReflectionParametroSeguridad(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasParametroSeguridad=ParametroSeguridadConstantesFunciones.getTodosTiposColumnasParametroSeguridad();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasParametroSeguridad) {
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
							field = ParametroSeguridad.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = ParametroSeguridad.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ParametroSeguridadDataAccess.setFieldReflectionParametroSeguridad(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionParametroSeguridad(Field field,String strPrefijo,String sColumn,ParametroSeguridad entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ParametroSeguridadConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroSeguridadConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ParametroSeguridadConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroSeguridadConstantesFunciones.CONCARTERA:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroSeguridadConstantesFunciones.CONCOPIARCLIENTES:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroSeguridadConstantesFunciones.CONCOPIARPROVEEDORES:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroSeguridadConstantesFunciones.CONGENERARCLIENTEPROVE:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroSeguridadConstantesFunciones.CLIENTECONSECUENCIALAUTO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroSeguridadConstantesFunciones.CLIENTENUMMAXIMOINICIALES:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case ParametroSeguridadConstantesFunciones.PROVECONSECUENCIALAUTO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroSeguridadConstantesFunciones.PROVENUMMAXIMOINICIALES:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case ParametroSeguridadConstantesFunciones.CONVALIDARGRUPOS:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroSeguridadConstantesFunciones.ACTIFIJOCONSECUENCIALAUTO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ParametroSeguridad>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<ParametroSeguridad> entities = new  ArrayList<ParametroSeguridad>();
		ParametroSeguridad entity = new ParametroSeguridad();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroSeguridadDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroSeguridadDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroSeguridadDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new ParametroSeguridad();
					entity=super.getEntity("",entity,resultSet,ParametroSeguridadDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityParametroSeguridad("",entity,resultSet);
					
					//entity.setParametroSeguridadOriginal( new ParametroSeguridad());
					//entity.setParametroSeguridadOriginal(super.getEntity("",entity.getParametroSeguridadOriginal(),resultSet,ParametroSeguridadDataAccess.ISWITHSCHEMA));         		
					//entity.setParametroSeguridadOriginal(this.getEntityParametroSeguridad("",entity.getParametroSeguridadOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseParametroSeguridads(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroSeguridad(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ParametroSeguridad>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<ParametroSeguridad> entities = new  ArrayList<ParametroSeguridad>();
		ParametroSeguridad entity = new ParametroSeguridad();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroSeguridadDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroSeguridadDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroSeguridadDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<ParametroSeguridad> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroSeguridad> entities = new  ArrayList<ParametroSeguridad>();
		ParametroSeguridad entity = new ParametroSeguridad();		  
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
	
	public  List<ParametroSeguridad> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroSeguridad> entities = new  ArrayList<ParametroSeguridad>();
		ParametroSeguridad entity = new ParametroSeguridad();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroSeguridad();
      	    	entity=super.getEntity("",entity,resultSet,ParametroSeguridadDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroSeguridad("",entity,resultSet);
      	    	
				//entity.setParametroSeguridadOriginal( new ParametroSeguridad());
      	    	//entity.setParametroSeguridadOriginal(super.getEntity("",entity.getParametroSeguridadOriginal(),resultSet,ParametroSeguridadDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroSeguridadOriginal(this.getEntityParametroSeguridad("",entity.getParametroSeguridadOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseParametroSeguridads(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroSeguridad(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	
	
	public ParametroSeguridad getEntityParametroSeguridad(String strPrefijo,ParametroSeguridad entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+ParametroSeguridadConstantesFunciones.IDEMPRESA));
				entity.setcon_cartera(resultSet.getBoolean(strPrefijo+ParametroSeguridadConstantesFunciones.CONCARTERA));
				entity.setcon_copiar_clientes(resultSet.getBoolean(strPrefijo+ParametroSeguridadConstantesFunciones.CONCOPIARCLIENTES));
				entity.setcon_copiar_proveedores(resultSet.getBoolean(strPrefijo+ParametroSeguridadConstantesFunciones.CONCOPIARPROVEEDORES));
				entity.setcon_generar_cliente_prove(resultSet.getBoolean(strPrefijo+ParametroSeguridadConstantesFunciones.CONGENERARCLIENTEPROVE));
				entity.setcliente_con_secuencial_auto(resultSet.getBoolean(strPrefijo+ParametroSeguridadConstantesFunciones.CLIENTECONSECUENCIALAUTO));
				entity.setcliente_num_maximo_iniciales(resultSet.getInt(strPrefijo+ParametroSeguridadConstantesFunciones.CLIENTENUMMAXIMOINICIALES));
				entity.setprove_con_secuencial_auto(resultSet.getBoolean(strPrefijo+ParametroSeguridadConstantesFunciones.PROVECONSECUENCIALAUTO));
				entity.setprove_num_maximo_iniciales(resultSet.getInt(strPrefijo+ParametroSeguridadConstantesFunciones.PROVENUMMAXIMOINICIALES));
				entity.setcon_validar_grupos(resultSet.getBoolean(strPrefijo+ParametroSeguridadConstantesFunciones.CONVALIDARGRUPOS));
				entity.setacti_fijo_con_secuencial_auto(resultSet.getBoolean(strPrefijo+ParametroSeguridadConstantesFunciones.ACTIFIJOCONSECUENCIALAUTO));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowParametroSeguridad(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(ParametroSeguridad entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ParametroSeguridadDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ParametroSeguridadDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ParametroSeguridadDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ParametroSeguridadDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ParametroSeguridadConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ParametroSeguridadDataAccess.TABLENAME,ParametroSeguridadDataAccess.ISWITHSTOREPROCEDURES);
			
			ParametroSeguridadDataAccess.setParametroSeguridadOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,ParametroSeguridad relparametroseguridad)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relparametroseguridad.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,ParametroSeguridad parametroseguridad) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!parametroseguridad.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(parametroseguridad.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_cartera=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_cartera.setValue(parametroseguridad.getcon_cartera());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_cartera);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_copiar_clientes=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_copiar_clientes.setValue(parametroseguridad.getcon_copiar_clientes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_copiar_clientes);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_copiar_proveedores=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_copiar_proveedores.setValue(parametroseguridad.getcon_copiar_proveedores());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_copiar_proveedores);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_generar_cliente_prove=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_generar_cliente_prove.setValue(parametroseguridad.getcon_generar_cliente_prove());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_generar_cliente_prove);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecliente_con_secuencial_auto=new ParameterValue<Boolean>();
					parameterMaintenanceValuecliente_con_secuencial_auto.setValue(parametroseguridad.getcliente_con_secuencial_auto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecliente_con_secuencial_auto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuecliente_num_maximo_iniciales=new ParameterValue<Integer>();
					parameterMaintenanceValuecliente_num_maximo_iniciales.setValue(parametroseguridad.getcliente_num_maximo_iniciales());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecliente_num_maximo_iniciales);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValueprove_con_secuencial_auto=new ParameterValue<Boolean>();
					parameterMaintenanceValueprove_con_secuencial_auto.setValue(parametroseguridad.getprove_con_secuencial_auto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueprove_con_secuencial_auto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValueprove_num_maximo_iniciales=new ParameterValue<Integer>();
					parameterMaintenanceValueprove_num_maximo_iniciales.setValue(parametroseguridad.getprove_num_maximo_iniciales());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueprove_num_maximo_iniciales);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_validar_grupos=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_validar_grupos.setValue(parametroseguridad.getcon_validar_grupos());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_validar_grupos);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValueacti_fijo_con_secuencial_auto=new ParameterValue<Boolean>();
					parameterMaintenanceValueacti_fijo_con_secuencial_auto.setValue(parametroseguridad.getacti_fijo_con_secuencial_auto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueacti_fijo_con_secuencial_auto);
					parametersTemp.add(parameterMaintenance);
					
						if(!parametroseguridad.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(parametroseguridad.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(parametroseguridad.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(parametroseguridad.getId());
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
	
	public void setIsNewIsChangedFalseParametroSeguridad(ParametroSeguridad parametroseguridad)throws Exception  {		
		parametroseguridad.setIsNew(false);
		parametroseguridad.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseParametroSeguridads(List<ParametroSeguridad> parametroseguridads)throws Exception  {				
		for(ParametroSeguridad parametroseguridad:parametroseguridads) {
			parametroseguridad.setIsNew(false);
			parametroseguridad.setIsChanged(false);
		}
	}
	
	public void generarExportarParametroSeguridad(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
