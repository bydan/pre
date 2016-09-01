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
import com.bydan.erp.tesoreria.util.*;//ParametroTesoreriaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class ParametroTesoreriaDataAccess extends  ParametroTesoreriaDataAccessAdditional{ //ParametroTesoreriaDataAccessAdditional,DataAccessHelper<ParametroTesoreria>
	//static Logger logger = Logger.getLogger(ParametroTesoreriaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="parametro_tesoreria";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ParametroTesoreriaConstantesFunciones.SCHEMA+"."+ParametroTesoreriaConstantesFunciones.TABLENAME+"(version_row,id_empresa,con_anticipo_orden_compra,por_lotes,id_transaccion_cobrar_pago,id_transaccion_cobrar_debito,id_transaccion_cobrar_credito,id_transaccion_pagar_pago,id_transaccion_pagar_debito,id_transaccion_pagar_credito,descripcion)values(current_timestamp,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+ParametroTesoreriaConstantesFunciones.SCHEMA+"."+ParametroTesoreriaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,con_anticipo_orden_compra=?,por_lotes=?,id_transaccion_cobrar_pago=?,id_transaccion_cobrar_debito=?,id_transaccion_cobrar_credito=?,id_transaccion_pagar_pago=?,id_transaccion_pagar_debito=?,id_transaccion_pagar_credito=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ParametroTesoreriaConstantesFunciones.SCHEMA+"."+ParametroTesoreriaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select parametrotesoreria from "+ParametroTesoreriaConstantesFunciones.SPERSISTENCENAME+" parametrotesoreria";
	public static String QUERYSELECTNATIVE="select "+ParametroTesoreriaConstantesFunciones.SCHEMA+"."+ParametroTesoreriaConstantesFunciones.TABLENAME+".id,"+ParametroTesoreriaConstantesFunciones.SCHEMA+"."+ParametroTesoreriaConstantesFunciones.TABLENAME+".version_row,"+ParametroTesoreriaConstantesFunciones.SCHEMA+"."+ParametroTesoreriaConstantesFunciones.TABLENAME+".id_empresa,"+ParametroTesoreriaConstantesFunciones.SCHEMA+"."+ParametroTesoreriaConstantesFunciones.TABLENAME+".con_anticipo_orden_compra,"+ParametroTesoreriaConstantesFunciones.SCHEMA+"."+ParametroTesoreriaConstantesFunciones.TABLENAME+".por_lotes,"+ParametroTesoreriaConstantesFunciones.SCHEMA+"."+ParametroTesoreriaConstantesFunciones.TABLENAME+".id_transaccion_cobrar_pago,"+ParametroTesoreriaConstantesFunciones.SCHEMA+"."+ParametroTesoreriaConstantesFunciones.TABLENAME+".id_transaccion_cobrar_debito,"+ParametroTesoreriaConstantesFunciones.SCHEMA+"."+ParametroTesoreriaConstantesFunciones.TABLENAME+".id_transaccion_cobrar_credito,"+ParametroTesoreriaConstantesFunciones.SCHEMA+"."+ParametroTesoreriaConstantesFunciones.TABLENAME+".id_transaccion_pagar_pago,"+ParametroTesoreriaConstantesFunciones.SCHEMA+"."+ParametroTesoreriaConstantesFunciones.TABLENAME+".id_transaccion_pagar_debito,"+ParametroTesoreriaConstantesFunciones.SCHEMA+"."+ParametroTesoreriaConstantesFunciones.TABLENAME+".id_transaccion_pagar_credito,"+ParametroTesoreriaConstantesFunciones.SCHEMA+"."+ParametroTesoreriaConstantesFunciones.TABLENAME+".descripcion from "+ParametroTesoreriaConstantesFunciones.SCHEMA+"."+ParametroTesoreriaConstantesFunciones.TABLENAME;//+" as "+ParametroTesoreriaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ParametroTesoreriaConstantesFunciones.SCHEMA+"."+ParametroTesoreriaConstantesFunciones.TABLENAME+".id,"+ParametroTesoreriaConstantesFunciones.SCHEMA+"."+ParametroTesoreriaConstantesFunciones.TABLENAME+".version_row from "+ParametroTesoreriaConstantesFunciones.SCHEMA+"."+ParametroTesoreriaConstantesFunciones.TABLENAME;//+" as "+ParametroTesoreriaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ParametroTesoreriaConstantesFunciones.SCHEMA+"."+ParametroTesoreriaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,con_anticipo_orden_compra=?,por_lotes=?,id_transaccion_cobrar_pago=?,id_transaccion_cobrar_debito=?,id_transaccion_cobrar_credito=?,id_transaccion_pagar_pago=?,id_transaccion_pagar_debito=?,id_transaccion_pagar_credito=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PARAMETROTESORERIA_INSERT(?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PARAMETROTESORERIA_UPDATE(?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PARAMETROTESORERIA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PARAMETROTESORERIA_SELECT(?,?)";
	
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
	
	
	protected ParametroTesoreriaDataAccessAdditional parametrotesoreriaDataAccessAdditional=null;
	
	public ParametroTesoreriaDataAccessAdditional getParametroTesoreriaDataAccessAdditional() {
		return this.parametrotesoreriaDataAccessAdditional;
	}
	
	public void setParametroTesoreriaDataAccessAdditional(ParametroTesoreriaDataAccessAdditional parametrotesoreriaDataAccessAdditional) {
		try {
			this.parametrotesoreriaDataAccessAdditional=parametrotesoreriaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ParametroTesoreriaDataAccess() {
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
		ParametroTesoreriaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ParametroTesoreriaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ParametroTesoreriaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setParametroTesoreriaOriginal(ParametroTesoreria parametrotesoreria)throws Exception  {
		parametrotesoreria.setParametroTesoreriaOriginal((ParametroTesoreria)parametrotesoreria.clone());		
	}
	
	public void setParametroTesoreriasOriginal(List<ParametroTesoreria> parametrotesorerias)throws Exception  {
		
		for(ParametroTesoreria parametrotesoreria:parametrotesorerias){
			parametrotesoreria.setParametroTesoreriaOriginal((ParametroTesoreria)parametrotesoreria.clone());
		}
	}
	
	public static void setParametroTesoreriaOriginalStatic(ParametroTesoreria parametrotesoreria)throws Exception  {
		parametrotesoreria.setParametroTesoreriaOriginal((ParametroTesoreria)parametrotesoreria.clone());		
	}
	
	public static void setParametroTesoreriasOriginalStatic(List<ParametroTesoreria> parametrotesorerias)throws Exception  {
		
		for(ParametroTesoreria parametrotesoreria:parametrotesorerias){
			parametrotesoreria.setParametroTesoreriaOriginal((ParametroTesoreria)parametrotesoreria.clone());
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
	
	public  ParametroTesoreria getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		ParametroTesoreria entity = new ParametroTesoreria();		
		
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
	
	public  ParametroTesoreria getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		ParametroTesoreria entity = new ParametroTesoreria();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroTesoreriaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroTesoreriaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Tesoreria.ParametroTesoreria.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setParametroTesoreriaOriginal(new ParametroTesoreria());
      	    	entity=super.getEntity("",entity,resultSet,ParametroTesoreriaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityParametroTesoreria("",entity,resultSet); 
				
				//entity.setParametroTesoreriaOriginal(super.getEntity("",entity.getParametroTesoreriaOriginal(),resultSet,ParametroTesoreriaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroTesoreriaOriginal(this.getEntityParametroTesoreria("",entity.getParametroTesoreriaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseParametroTesoreria(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  ParametroTesoreria getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ParametroTesoreria entity = new ParametroTesoreria();
				
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
	
	public  ParametroTesoreria getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ParametroTesoreria entity = new ParametroTesoreria();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroTesoreriaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroTesoreriaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroTesoreriaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Tesoreria.ParametroTesoreria.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setParametroTesoreriaOriginal(new ParametroTesoreria());
      	    	entity=super.getEntity("",entity,resultSet,ParametroTesoreriaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityParametroTesoreria("",entity,resultSet);    
				
				//entity.setParametroTesoreriaOriginal(super.getEntity("",entity.getParametroTesoreriaOriginal(),resultSet,ParametroTesoreriaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroTesoreriaOriginal(this.getEntityParametroTesoreria("",entity.getParametroTesoreriaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseParametroTesoreria(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //ParametroTesoreria
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		ParametroTesoreria entity = new ParametroTesoreria();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroTesoreriaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroTesoreriaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroTesoreriaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Tesoreria.ParametroTesoreria.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseParametroTesoreria(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<ParametroTesoreria> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ParametroTesoreria> entities = new  ArrayList<ParametroTesoreria>();
		ParametroTesoreria entity = new ParametroTesoreria();		  
		
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
	
	public  List<ParametroTesoreria> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ParametroTesoreria> entities = new  ArrayList<ParametroTesoreria>();
		ParametroTesoreria entity = new ParametroTesoreria();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroTesoreriaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroTesoreriaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroTesoreriaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroTesoreria();
      	    	entity=super.getEntity("",entity,resultSet,ParametroTesoreriaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroTesoreria("",entity,resultSet);
      	    	
				//entity.setParametroTesoreriaOriginal( new ParametroTesoreria());
      	    	//entity.setParametroTesoreriaOriginal(super.getEntity("",entity.getParametroTesoreriaOriginal(),resultSet,ParametroTesoreriaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroTesoreriaOriginal(this.getEntityParametroTesoreria("",entity.getParametroTesoreriaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroTesorerias(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroTesoreria(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ParametroTesoreria> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ParametroTesoreria> entities = new  ArrayList<ParametroTesoreria>();
		ParametroTesoreria entity = new ParametroTesoreria();		  
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
	
	public  List<ParametroTesoreria> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ParametroTesoreria> entities = new  ArrayList<ParametroTesoreria>();
		ParametroTesoreria entity = new ParametroTesoreria();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroTesoreria();
				
				if(conMapGenerico) {
					entity.inicializarMapParametroTesoreria();
					//entity.setMapParametroTesoreria(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapParametroTesoreriaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapParametroTesoreria().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ParametroTesoreriaDataAccess.ISWITHSCHEMA);         		
					entity=ParametroTesoreriaDataAccess.getEntityParametroTesoreria("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setParametroTesoreriaOriginal( new ParametroTesoreria());
					////entity.setParametroTesoreriaOriginal(super.getEntity("",entity.getParametroTesoreriaOriginal(),resultSet,ParametroTesoreriaDataAccess.ISWITHSCHEMA));         		
					////entity.setParametroTesoreriaOriginal(this.getEntityParametroTesoreria("",entity.getParametroTesoreriaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroTesorerias(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroTesoreria(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public ParametroTesoreria getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ParametroTesoreria entity = new ParametroTesoreria();		  
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
	
	public  ParametroTesoreria getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ParametroTesoreria entity = new ParametroTesoreria();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroTesoreria();
				
				if(conMapGenerico) {
					entity.inicializarMapParametroTesoreria();
					//entity.setMapParametroTesoreria(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapParametroTesoreriaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapParametroTesoreria().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ParametroTesoreriaDataAccess.ISWITHSCHEMA);         		
					entity=ParametroTesoreriaDataAccess.getEntityParametroTesoreria("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setParametroTesoreriaOriginal( new ParametroTesoreria());
					////entity.setParametroTesoreriaOriginal(super.getEntity("",entity.getParametroTesoreriaOriginal(),resultSet,ParametroTesoreriaDataAccess.ISWITHSCHEMA));         		
					////entity.setParametroTesoreriaOriginal(this.getEntityParametroTesoreria("",entity.getParametroTesoreriaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseParametroTesoreria(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroTesoreria(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ParametroTesoreria getEntityParametroTesoreria(String strPrefijo,ParametroTesoreria entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = ParametroTesoreria.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = ParametroTesoreria.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ParametroTesoreriaDataAccess.setFieldReflectionParametroTesoreria(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasParametroTesoreria=ParametroTesoreriaConstantesFunciones.getTodosTiposColumnasParametroTesoreria();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasParametroTesoreria) {
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
							field = ParametroTesoreria.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = ParametroTesoreria.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ParametroTesoreriaDataAccess.setFieldReflectionParametroTesoreria(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionParametroTesoreria(Field field,String strPrefijo,String sColumn,ParametroTesoreria entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ParametroTesoreriaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroTesoreriaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ParametroTesoreriaConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroTesoreriaConstantesFunciones.CONANTICIPOORDENCOMPRA:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroTesoreriaConstantesFunciones.PORLOTES:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroTesoreriaConstantesFunciones.IDTRANSACCIONCOBRARPAGO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroTesoreriaConstantesFunciones.IDTRANSACCIONCOBRARDEBITO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroTesoreriaConstantesFunciones.IDTRANSACCIONCOBRARCREDITO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroTesoreriaConstantesFunciones.IDTRANSACCIONPAGARPAGO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroTesoreriaConstantesFunciones.IDTRANSACCIONPAGARDEBITO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroTesoreriaConstantesFunciones.IDTRANSACCIONPAGARCREDITO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroTesoreriaConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ParametroTesoreria>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<ParametroTesoreria> entities = new  ArrayList<ParametroTesoreria>();
		ParametroTesoreria entity = new ParametroTesoreria();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroTesoreriaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroTesoreriaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroTesoreriaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new ParametroTesoreria();
					entity=super.getEntity("",entity,resultSet,ParametroTesoreriaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityParametroTesoreria("",entity,resultSet);
					
					//entity.setParametroTesoreriaOriginal( new ParametroTesoreria());
					//entity.setParametroTesoreriaOriginal(super.getEntity("",entity.getParametroTesoreriaOriginal(),resultSet,ParametroTesoreriaDataAccess.ISWITHSCHEMA));         		
					//entity.setParametroTesoreriaOriginal(this.getEntityParametroTesoreria("",entity.getParametroTesoreriaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseParametroTesorerias(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroTesoreria(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ParametroTesoreria>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<ParametroTesoreria> entities = new  ArrayList<ParametroTesoreria>();
		ParametroTesoreria entity = new ParametroTesoreria();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroTesoreriaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroTesoreriaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroTesoreriaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<ParametroTesoreria> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroTesoreria> entities = new  ArrayList<ParametroTesoreria>();
		ParametroTesoreria entity = new ParametroTesoreria();		  
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
	
	public  List<ParametroTesoreria> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroTesoreria> entities = new  ArrayList<ParametroTesoreria>();
		ParametroTesoreria entity = new ParametroTesoreria();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroTesoreria();
      	    	entity=super.getEntity("",entity,resultSet,ParametroTesoreriaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroTesoreria("",entity,resultSet);
      	    	
				//entity.setParametroTesoreriaOriginal( new ParametroTesoreria());
      	    	//entity.setParametroTesoreriaOriginal(super.getEntity("",entity.getParametroTesoreriaOriginal(),resultSet,ParametroTesoreriaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroTesoreriaOriginal(this.getEntityParametroTesoreria("",entity.getParametroTesoreriaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseParametroTesorerias(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroTesoreria(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ParametroTesoreria> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroTesoreria> entities = new  ArrayList<ParametroTesoreria>();
		ParametroTesoreria entity = new ParametroTesoreria();		  
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
	
	public  List<ParametroTesoreria> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroTesoreria> entities = new  ArrayList<ParametroTesoreria>();
		ParametroTesoreria entity = new ParametroTesoreria();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroTesoreria();
      	    	entity=super.getEntity("",entity,resultSet,ParametroTesoreriaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroTesoreria("",entity,resultSet);
      	    	
				//entity.setParametroTesoreriaOriginal( new ParametroTesoreria());
      	    	//entity.setParametroTesoreriaOriginal(super.getEntity("",entity.getParametroTesoreriaOriginal(),resultSet,ParametroTesoreriaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroTesoreriaOriginal(this.getEntityParametroTesoreria("",entity.getParametroTesoreriaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroTesorerias(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public ParametroTesoreria getEntityParametroTesoreria(String strPrefijo,ParametroTesoreria entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+ParametroTesoreriaConstantesFunciones.IDEMPRESA));
				entity.setcon_anticipo_orden_compra(resultSet.getBoolean(strPrefijo+ParametroTesoreriaConstantesFunciones.CONANTICIPOORDENCOMPRA));
				entity.setpor_lotes(resultSet.getBoolean(strPrefijo+ParametroTesoreriaConstantesFunciones.PORLOTES));
				entity.setid_transaccion_cobrar_pago(resultSet.getLong(strPrefijo+ParametroTesoreriaConstantesFunciones.IDTRANSACCIONCOBRARPAGO));
				entity.setid_transaccion_cobrar_debito(resultSet.getLong(strPrefijo+ParametroTesoreriaConstantesFunciones.IDTRANSACCIONCOBRARDEBITO));
				entity.setid_transaccion_cobrar_credito(resultSet.getLong(strPrefijo+ParametroTesoreriaConstantesFunciones.IDTRANSACCIONCOBRARCREDITO));
				entity.setid_transaccion_pagar_pago(resultSet.getLong(strPrefijo+ParametroTesoreriaConstantesFunciones.IDTRANSACCIONPAGARPAGO));
				entity.setid_transaccion_pagar_debito(resultSet.getLong(strPrefijo+ParametroTesoreriaConstantesFunciones.IDTRANSACCIONPAGARDEBITO));
				entity.setid_transaccion_pagar_credito(resultSet.getLong(strPrefijo+ParametroTesoreriaConstantesFunciones.IDTRANSACCIONPAGARCREDITO));
				entity.setdescripcion(resultSet.getString(strPrefijo+ParametroTesoreriaConstantesFunciones.DESCRIPCION));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowParametroTesoreria(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(ParametroTesoreria entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ParametroTesoreriaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ParametroTesoreriaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ParametroTesoreriaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ParametroTesoreriaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ParametroTesoreriaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ParametroTesoreriaDataAccess.TABLENAME,ParametroTesoreriaDataAccess.ISWITHSTOREPROCEDURES);
			
			ParametroTesoreriaDataAccess.setParametroTesoreriaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,ParametroTesoreria relparametrotesoreria)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relparametrotesoreria.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Transaccion getTransaccionCobrarPago(Connexion connexion,ParametroTesoreria relparametrotesoreria)throws SQLException,Exception {

		Transaccion transaccion= new Transaccion();

		try {
			TransaccionDataAccess transaccionDataAccess=new TransaccionDataAccess();

			transaccionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transaccionDataAccess.setConnexionType(this.connexionType);
			transaccionDataAccess.setParameterDbType(this.parameterDbType);

			transaccion=transaccionDataAccess.getEntity(connexion,relparametrotesoreria.getid_transaccion_cobrar_pago());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccion;

	}

	public Transaccion getTransaccionCobrarDebito(Connexion connexion,ParametroTesoreria relparametrotesoreria)throws SQLException,Exception {

		Transaccion transaccion= new Transaccion();

		try {
			TransaccionDataAccess transaccionDataAccess=new TransaccionDataAccess();

			transaccionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transaccionDataAccess.setConnexionType(this.connexionType);
			transaccionDataAccess.setParameterDbType(this.parameterDbType);

			transaccion=transaccionDataAccess.getEntity(connexion,relparametrotesoreria.getid_transaccion_cobrar_debito());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccion;

	}

	public Transaccion getTransaccionCobrarCredito(Connexion connexion,ParametroTesoreria relparametrotesoreria)throws SQLException,Exception {

		Transaccion transaccion= new Transaccion();

		try {
			TransaccionDataAccess transaccionDataAccess=new TransaccionDataAccess();

			transaccionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transaccionDataAccess.setConnexionType(this.connexionType);
			transaccionDataAccess.setParameterDbType(this.parameterDbType);

			transaccion=transaccionDataAccess.getEntity(connexion,relparametrotesoreria.getid_transaccion_cobrar_credito());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccion;

	}

	public Transaccion getTransaccionPagarPago(Connexion connexion,ParametroTesoreria relparametrotesoreria)throws SQLException,Exception {

		Transaccion transaccion= new Transaccion();

		try {
			TransaccionDataAccess transaccionDataAccess=new TransaccionDataAccess();

			transaccionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transaccionDataAccess.setConnexionType(this.connexionType);
			transaccionDataAccess.setParameterDbType(this.parameterDbType);

			transaccion=transaccionDataAccess.getEntity(connexion,relparametrotesoreria.getid_transaccion_pagar_pago());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccion;

	}

	public Transaccion getTransaccionPagarDebito(Connexion connexion,ParametroTesoreria relparametrotesoreria)throws SQLException,Exception {

		Transaccion transaccion= new Transaccion();

		try {
			TransaccionDataAccess transaccionDataAccess=new TransaccionDataAccess();

			transaccionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transaccionDataAccess.setConnexionType(this.connexionType);
			transaccionDataAccess.setParameterDbType(this.parameterDbType);

			transaccion=transaccionDataAccess.getEntity(connexion,relparametrotesoreria.getid_transaccion_pagar_debito());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccion;

	}

	public Transaccion getTransaccionPagarCredito(Connexion connexion,ParametroTesoreria relparametrotesoreria)throws SQLException,Exception {

		Transaccion transaccion= new Transaccion();

		try {
			TransaccionDataAccess transaccionDataAccess=new TransaccionDataAccess();

			transaccionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transaccionDataAccess.setConnexionType(this.connexionType);
			transaccionDataAccess.setParameterDbType(this.parameterDbType);

			transaccion=transaccionDataAccess.getEntity(connexion,relparametrotesoreria.getid_transaccion_pagar_credito());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccion;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,ParametroTesoreria parametrotesoreria) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!parametrotesoreria.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(parametrotesoreria.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_anticipo_orden_compra=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_anticipo_orden_compra.setValue(parametrotesoreria.getcon_anticipo_orden_compra());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_anticipo_orden_compra);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuepor_lotes=new ParameterValue<Boolean>();
					parameterMaintenanceValuepor_lotes.setValue(parametrotesoreria.getpor_lotes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuepor_lotes);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transaccion_cobrar_pago=new ParameterValue<Long>();
					parameterMaintenanceValueid_transaccion_cobrar_pago.setValue(parametrotesoreria.getid_transaccion_cobrar_pago());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transaccion_cobrar_pago);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transaccion_cobrar_debito=new ParameterValue<Long>();
					parameterMaintenanceValueid_transaccion_cobrar_debito.setValue(parametrotesoreria.getid_transaccion_cobrar_debito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transaccion_cobrar_debito);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transaccion_cobrar_credito=new ParameterValue<Long>();
					parameterMaintenanceValueid_transaccion_cobrar_credito.setValue(parametrotesoreria.getid_transaccion_cobrar_credito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transaccion_cobrar_credito);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transaccion_pagar_pago=new ParameterValue<Long>();
					parameterMaintenanceValueid_transaccion_pagar_pago.setValue(parametrotesoreria.getid_transaccion_pagar_pago());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transaccion_pagar_pago);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transaccion_pagar_debito=new ParameterValue<Long>();
					parameterMaintenanceValueid_transaccion_pagar_debito.setValue(parametrotesoreria.getid_transaccion_pagar_debito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transaccion_pagar_debito);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transaccion_pagar_credito=new ParameterValue<Long>();
					parameterMaintenanceValueid_transaccion_pagar_credito.setValue(parametrotesoreria.getid_transaccion_pagar_credito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transaccion_pagar_credito);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(parametrotesoreria.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!parametrotesoreria.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(parametrotesoreria.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(parametrotesoreria.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(parametrotesoreria.getId());
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
	
	public void setIsNewIsChangedFalseParametroTesoreria(ParametroTesoreria parametrotesoreria)throws Exception  {		
		parametrotesoreria.setIsNew(false);
		parametrotesoreria.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseParametroTesorerias(List<ParametroTesoreria> parametrotesorerias)throws Exception  {				
		for(ParametroTesoreria parametrotesoreria:parametrotesorerias) {
			parametrotesoreria.setIsNew(false);
			parametrotesoreria.setIsChanged(false);
		}
	}
	
	public void generarExportarParametroTesoreria(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
