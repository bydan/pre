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
package com.bydan.erp.inventario.business.dataaccess;

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

import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.inventario.util.*;//ParametroInvenConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class ParametroInvenDataAccess extends  ParametroInvenDataAccessAdditional{ //ParametroInvenDataAccessAdditional,DataAccessHelper<ParametroInven>
	//static Logger logger = Logger.getLogger(ParametroInvenDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="parametro_inven";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ParametroInvenConstantesFunciones.SCHEMA+"."+ParametroInvenConstantesFunciones.TABLENAME+"(version_row,id_empresa,secuencial_pedido,numero_serie,numero_decimales,numero_items_requisicion,con_cuenta_contable,con_cuenta_contable_linea,con_cuenta_banco,con_copiar_producto,con_crear_producto_sucursal,con_crear_lista_precio_sucursal_bodega,con_compras_aprobacion,con_envio_mail)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+ParametroInvenConstantesFunciones.SCHEMA+"."+ParametroInvenConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,secuencial_pedido=?,numero_serie=?,numero_decimales=?,numero_items_requisicion=?,con_cuenta_contable=?,con_cuenta_contable_linea=?,con_cuenta_banco=?,con_copiar_producto=?,con_crear_producto_sucursal=?,con_crear_lista_precio_sucursal_bodega=?,con_compras_aprobacion=?,con_envio_mail=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ParametroInvenConstantesFunciones.SCHEMA+"."+ParametroInvenConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select parametroinven from "+ParametroInvenConstantesFunciones.SPERSISTENCENAME+" parametroinven";
	public static String QUERYSELECTNATIVE="select "+ParametroInvenConstantesFunciones.SCHEMA+"."+ParametroInvenConstantesFunciones.TABLENAME+".id,"+ParametroInvenConstantesFunciones.SCHEMA+"."+ParametroInvenConstantesFunciones.TABLENAME+".version_row,"+ParametroInvenConstantesFunciones.SCHEMA+"."+ParametroInvenConstantesFunciones.TABLENAME+".id_empresa,"+ParametroInvenConstantesFunciones.SCHEMA+"."+ParametroInvenConstantesFunciones.TABLENAME+".secuencial_pedido,"+ParametroInvenConstantesFunciones.SCHEMA+"."+ParametroInvenConstantesFunciones.TABLENAME+".numero_serie,"+ParametroInvenConstantesFunciones.SCHEMA+"."+ParametroInvenConstantesFunciones.TABLENAME+".numero_decimales,"+ParametroInvenConstantesFunciones.SCHEMA+"."+ParametroInvenConstantesFunciones.TABLENAME+".numero_items_requisicion,"+ParametroInvenConstantesFunciones.SCHEMA+"."+ParametroInvenConstantesFunciones.TABLENAME+".con_cuenta_contable,"+ParametroInvenConstantesFunciones.SCHEMA+"."+ParametroInvenConstantesFunciones.TABLENAME+".con_cuenta_contable_linea,"+ParametroInvenConstantesFunciones.SCHEMA+"."+ParametroInvenConstantesFunciones.TABLENAME+".con_cuenta_banco,"+ParametroInvenConstantesFunciones.SCHEMA+"."+ParametroInvenConstantesFunciones.TABLENAME+".con_copiar_producto,"+ParametroInvenConstantesFunciones.SCHEMA+"."+ParametroInvenConstantesFunciones.TABLENAME+".con_crear_producto_sucursal,"+ParametroInvenConstantesFunciones.SCHEMA+"."+ParametroInvenConstantesFunciones.TABLENAME+".con_crear_lista_precio_sucursal_bodega,"+ParametroInvenConstantesFunciones.SCHEMA+"."+ParametroInvenConstantesFunciones.TABLENAME+".con_compras_aprobacion,"+ParametroInvenConstantesFunciones.SCHEMA+"."+ParametroInvenConstantesFunciones.TABLENAME+".con_envio_mail from "+ParametroInvenConstantesFunciones.SCHEMA+"."+ParametroInvenConstantesFunciones.TABLENAME;//+" as "+ParametroInvenConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ParametroInvenConstantesFunciones.SCHEMA+"."+ParametroInvenConstantesFunciones.TABLENAME+".id,"+ParametroInvenConstantesFunciones.SCHEMA+"."+ParametroInvenConstantesFunciones.TABLENAME+".version_row from "+ParametroInvenConstantesFunciones.SCHEMA+"."+ParametroInvenConstantesFunciones.TABLENAME;//+" as "+ParametroInvenConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ParametroInvenConstantesFunciones.SCHEMA+"."+ParametroInvenConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,secuencial_pedido=?,numero_serie=?,numero_decimales=?,numero_items_requisicion=?,con_cuenta_contable=?,con_cuenta_contable_linea=?,con_cuenta_banco=?,con_copiar_producto=?,con_crear_producto_sucursal=?,con_crear_lista_precio_sucursal_bodega=?,con_compras_aprobacion=?,con_envio_mail=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PARAMETROINVEN_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PARAMETROINVEN_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PARAMETROINVEN_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PARAMETROINVEN_SELECT(?,?)";
	
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
	
	
	protected ParametroInvenDataAccessAdditional parametroinvenDataAccessAdditional=null;
	
	public ParametroInvenDataAccessAdditional getParametroInvenDataAccessAdditional() {
		return this.parametroinvenDataAccessAdditional;
	}
	
	public void setParametroInvenDataAccessAdditional(ParametroInvenDataAccessAdditional parametroinvenDataAccessAdditional) {
		try {
			this.parametroinvenDataAccessAdditional=parametroinvenDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ParametroInvenDataAccess() {
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
		ParametroInvenDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ParametroInvenDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ParametroInvenDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setParametroInvenOriginal(ParametroInven parametroinven)throws Exception  {
		parametroinven.setParametroInvenOriginal((ParametroInven)parametroinven.clone());		
	}
	
	public void setParametroInvensOriginal(List<ParametroInven> parametroinvens)throws Exception  {
		
		for(ParametroInven parametroinven:parametroinvens){
			parametroinven.setParametroInvenOriginal((ParametroInven)parametroinven.clone());
		}
	}
	
	public static void setParametroInvenOriginalStatic(ParametroInven parametroinven)throws Exception  {
		parametroinven.setParametroInvenOriginal((ParametroInven)parametroinven.clone());		
	}
	
	public static void setParametroInvensOriginalStatic(List<ParametroInven> parametroinvens)throws Exception  {
		
		for(ParametroInven parametroinven:parametroinvens){
			parametroinven.setParametroInvenOriginal((ParametroInven)parametroinven.clone());
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
	
	public  ParametroInven getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		ParametroInven entity = new ParametroInven();		
		
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
	
	public  ParametroInven getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		ParametroInven entity = new ParametroInven();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroInvenDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroInvenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.ParametroInven.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setParametroInvenOriginal(new ParametroInven());
      	    	entity=super.getEntity("",entity,resultSet,ParametroInvenDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityParametroInven("",entity,resultSet); 
				
				//entity.setParametroInvenOriginal(super.getEntity("",entity.getParametroInvenOriginal(),resultSet,ParametroInvenDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroInvenOriginal(this.getEntityParametroInven("",entity.getParametroInvenOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseParametroInven(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  ParametroInven getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ParametroInven entity = new ParametroInven();
				
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
	
	public  ParametroInven getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ParametroInven entity = new ParametroInven();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroInvenDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroInvenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroInvenDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.ParametroInven.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setParametroInvenOriginal(new ParametroInven());
      	    	entity=super.getEntity("",entity,resultSet,ParametroInvenDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityParametroInven("",entity,resultSet);    
				
				//entity.setParametroInvenOriginal(super.getEntity("",entity.getParametroInvenOriginal(),resultSet,ParametroInvenDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroInvenOriginal(this.getEntityParametroInven("",entity.getParametroInvenOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseParametroInven(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //ParametroInven
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		ParametroInven entity = new ParametroInven();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroInvenDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroInvenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroInvenDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.ParametroInven.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseParametroInven(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<ParametroInven> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ParametroInven> entities = new  ArrayList<ParametroInven>();
		ParametroInven entity = new ParametroInven();		  
		
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
	
	public  List<ParametroInven> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ParametroInven> entities = new  ArrayList<ParametroInven>();
		ParametroInven entity = new ParametroInven();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroInvenDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroInvenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroInvenDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroInven();
      	    	entity=super.getEntity("",entity,resultSet,ParametroInvenDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroInven("",entity,resultSet);
      	    	
				//entity.setParametroInvenOriginal( new ParametroInven());
      	    	//entity.setParametroInvenOriginal(super.getEntity("",entity.getParametroInvenOriginal(),resultSet,ParametroInvenDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroInvenOriginal(this.getEntityParametroInven("",entity.getParametroInvenOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroInvens(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroInven(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ParametroInven> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ParametroInven> entities = new  ArrayList<ParametroInven>();
		ParametroInven entity = new ParametroInven();		  
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
	
	public  List<ParametroInven> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ParametroInven> entities = new  ArrayList<ParametroInven>();
		ParametroInven entity = new ParametroInven();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroInven();
				
				if(conMapGenerico) {
					entity.inicializarMapParametroInven();
					//entity.setMapParametroInven(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapParametroInvenValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapParametroInven().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ParametroInvenDataAccess.ISWITHSCHEMA);         		
					entity=ParametroInvenDataAccess.getEntityParametroInven("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setParametroInvenOriginal( new ParametroInven());
					////entity.setParametroInvenOriginal(super.getEntity("",entity.getParametroInvenOriginal(),resultSet,ParametroInvenDataAccess.ISWITHSCHEMA));         		
					////entity.setParametroInvenOriginal(this.getEntityParametroInven("",entity.getParametroInvenOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroInvens(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroInven(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public ParametroInven getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ParametroInven entity = new ParametroInven();		  
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
	
	public  ParametroInven getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ParametroInven entity = new ParametroInven();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroInven();
				
				if(conMapGenerico) {
					entity.inicializarMapParametroInven();
					//entity.setMapParametroInven(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapParametroInvenValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapParametroInven().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ParametroInvenDataAccess.ISWITHSCHEMA);         		
					entity=ParametroInvenDataAccess.getEntityParametroInven("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setParametroInvenOriginal( new ParametroInven());
					////entity.setParametroInvenOriginal(super.getEntity("",entity.getParametroInvenOriginal(),resultSet,ParametroInvenDataAccess.ISWITHSCHEMA));         		
					////entity.setParametroInvenOriginal(this.getEntityParametroInven("",entity.getParametroInvenOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseParametroInven(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroInven(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ParametroInven getEntityParametroInven(String strPrefijo,ParametroInven entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = ParametroInven.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = ParametroInven.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ParametroInvenDataAccess.setFieldReflectionParametroInven(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasParametroInven=ParametroInvenConstantesFunciones.getTodosTiposColumnasParametroInven();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasParametroInven) {
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
							field = ParametroInven.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = ParametroInven.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ParametroInvenDataAccess.setFieldReflectionParametroInven(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionParametroInven(Field field,String strPrefijo,String sColumn,ParametroInven entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ParametroInvenConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroInvenConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ParametroInvenConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroInvenConstantesFunciones.SECUENCIALPEDIDO:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case ParametroInvenConstantesFunciones.NUMEROSERIE:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case ParametroInvenConstantesFunciones.NUMERODECIMALES:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case ParametroInvenConstantesFunciones.NUMEROITEMSREQUISICION:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case ParametroInvenConstantesFunciones.CONCUENTACONTABLE:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroInvenConstantesFunciones.CONCUENTACONTABLELINEA:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroInvenConstantesFunciones.CONCUENTABANCO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroInvenConstantesFunciones.CONCOPIARPRODUCTO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroInvenConstantesFunciones.CONCREARPRODUCTOSUCURSAL:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroInvenConstantesFunciones.CONCREARLISTAPRECIOSUCURSALBODEGA:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroInvenConstantesFunciones.CONCOMPRASAPROBACION:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroInvenConstantesFunciones.CONENVIOMAIL:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ParametroInven>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<ParametroInven> entities = new  ArrayList<ParametroInven>();
		ParametroInven entity = new ParametroInven();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroInvenDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroInvenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroInvenDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new ParametroInven();
					entity=super.getEntity("",entity,resultSet,ParametroInvenDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityParametroInven("",entity,resultSet);
					
					//entity.setParametroInvenOriginal( new ParametroInven());
					//entity.setParametroInvenOriginal(super.getEntity("",entity.getParametroInvenOriginal(),resultSet,ParametroInvenDataAccess.ISWITHSCHEMA));         		
					//entity.setParametroInvenOriginal(this.getEntityParametroInven("",entity.getParametroInvenOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseParametroInvens(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroInven(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ParametroInven>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<ParametroInven> entities = new  ArrayList<ParametroInven>();
		ParametroInven entity = new ParametroInven();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroInvenDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroInvenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroInvenDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<ParametroInven> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroInven> entities = new  ArrayList<ParametroInven>();
		ParametroInven entity = new ParametroInven();		  
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
	
	public  List<ParametroInven> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroInven> entities = new  ArrayList<ParametroInven>();
		ParametroInven entity = new ParametroInven();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroInven();
      	    	entity=super.getEntity("",entity,resultSet,ParametroInvenDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroInven("",entity,resultSet);
      	    	
				//entity.setParametroInvenOriginal( new ParametroInven());
      	    	//entity.setParametroInvenOriginal(super.getEntity("",entity.getParametroInvenOriginal(),resultSet,ParametroInvenDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroInvenOriginal(this.getEntityParametroInven("",entity.getParametroInvenOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseParametroInvens(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroInven(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ParametroInven> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroInven> entities = new  ArrayList<ParametroInven>();
		ParametroInven entity = new ParametroInven();		  
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
	
	public  List<ParametroInven> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroInven> entities = new  ArrayList<ParametroInven>();
		ParametroInven entity = new ParametroInven();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroInven();
      	    	entity=super.getEntity("",entity,resultSet,ParametroInvenDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroInven("",entity,resultSet);
      	    	
				//entity.setParametroInvenOriginal( new ParametroInven());
      	    	//entity.setParametroInvenOriginal(super.getEntity("",entity.getParametroInvenOriginal(),resultSet,ParametroInvenDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroInvenOriginal(this.getEntityParametroInven("",entity.getParametroInvenOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroInvens(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public ParametroInven getEntityParametroInven(String strPrefijo,ParametroInven entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+ParametroInvenConstantesFunciones.IDEMPRESA));
				entity.setsecuencial_pedido(resultSet.getInt(strPrefijo+ParametroInvenConstantesFunciones.SECUENCIALPEDIDO));
				entity.setnumero_serie(resultSet.getInt(strPrefijo+ParametroInvenConstantesFunciones.NUMEROSERIE));
				entity.setnumero_decimales(resultSet.getInt(strPrefijo+ParametroInvenConstantesFunciones.NUMERODECIMALES));
				entity.setnumero_items_requisicion(resultSet.getInt(strPrefijo+ParametroInvenConstantesFunciones.NUMEROITEMSREQUISICION));
				entity.setcon_cuenta_contable(resultSet.getBoolean(strPrefijo+ParametroInvenConstantesFunciones.CONCUENTACONTABLE));
				entity.setcon_cuenta_contable_linea(resultSet.getBoolean(strPrefijo+ParametroInvenConstantesFunciones.CONCUENTACONTABLELINEA));
				entity.setcon_cuenta_banco(resultSet.getBoolean(strPrefijo+ParametroInvenConstantesFunciones.CONCUENTABANCO));
				entity.setcon_copiar_producto(resultSet.getBoolean(strPrefijo+ParametroInvenConstantesFunciones.CONCOPIARPRODUCTO));
				entity.setcon_crear_producto_sucursal(resultSet.getBoolean(strPrefijo+ParametroInvenConstantesFunciones.CONCREARPRODUCTOSUCURSAL));
				entity.setcon_crear_lista_precio_sucursal_bodega(resultSet.getBoolean(strPrefijo+ParametroInvenConstantesFunciones.CONCREARLISTAPRECIOSUCURSALBODEGA));
				entity.setcon_compras_aprobacion(resultSet.getBoolean(strPrefijo+ParametroInvenConstantesFunciones.CONCOMPRASAPROBACION));
				entity.setcon_envio_mail(resultSet.getBoolean(strPrefijo+ParametroInvenConstantesFunciones.CONENVIOMAIL));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowParametroInven(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(ParametroInven entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ParametroInvenDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ParametroInvenDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ParametroInvenDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ParametroInvenDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ParametroInvenConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ParametroInvenDataAccess.TABLENAME,ParametroInvenDataAccess.ISWITHSTOREPROCEDURES);
			
			ParametroInvenDataAccess.setParametroInvenOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,ParametroInven relparametroinven)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relparametroinven.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,ParametroInven parametroinven) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!parametroinven.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(parametroinven.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuesecuencial_pedido=new ParameterValue<Integer>();
					parameterMaintenanceValuesecuencial_pedido.setValue(parametroinven.getsecuencial_pedido());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesecuencial_pedido);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuenumero_serie=new ParameterValue<Integer>();
					parameterMaintenanceValuenumero_serie.setValue(parametroinven.getnumero_serie());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_serie);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuenumero_decimales=new ParameterValue<Integer>();
					parameterMaintenanceValuenumero_decimales.setValue(parametroinven.getnumero_decimales());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_decimales);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuenumero_items_requisicion=new ParameterValue<Integer>();
					parameterMaintenanceValuenumero_items_requisicion.setValue(parametroinven.getnumero_items_requisicion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_items_requisicion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_cuenta_contable=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_cuenta_contable.setValue(parametroinven.getcon_cuenta_contable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_cuenta_contable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_cuenta_contable_linea=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_cuenta_contable_linea.setValue(parametroinven.getcon_cuenta_contable_linea());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_cuenta_contable_linea);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_cuenta_banco=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_cuenta_banco.setValue(parametroinven.getcon_cuenta_banco());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_cuenta_banco);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_copiar_producto=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_copiar_producto.setValue(parametroinven.getcon_copiar_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_copiar_producto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_crear_producto_sucursal=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_crear_producto_sucursal.setValue(parametroinven.getcon_crear_producto_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_crear_producto_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_crear_lista_precio_sucursal_bodega=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_crear_lista_precio_sucursal_bodega.setValue(parametroinven.getcon_crear_lista_precio_sucursal_bodega());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_crear_lista_precio_sucursal_bodega);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_compras_aprobacion=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_compras_aprobacion.setValue(parametroinven.getcon_compras_aprobacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_compras_aprobacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_envio_mail=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_envio_mail.setValue(parametroinven.getcon_envio_mail());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_envio_mail);
					parametersTemp.add(parameterMaintenance);
					
						if(!parametroinven.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(parametroinven.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(parametroinven.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(parametroinven.getId());
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
	
	public void setIsNewIsChangedFalseParametroInven(ParametroInven parametroinven)throws Exception  {		
		parametroinven.setIsNew(false);
		parametroinven.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseParametroInvens(List<ParametroInven> parametroinvens)throws Exception  {				
		for(ParametroInven parametroinven:parametroinvens) {
			parametroinven.setIsNew(false);
			parametroinven.setIsChanged(false);
		}
	}
	
	public void generarExportarParametroInven(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
