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
import com.bydan.erp.contabilidad.util.*;//TipoDocumentoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.tesoreria.util.*;




@SuppressWarnings("unused")
final public class TipoDocumentoDataAccess extends  TipoDocumentoDataAccessAdditional{ //TipoDocumentoDataAccessAdditional,DataAccessHelper<TipoDocumento>
	//static Logger logger = Logger.getLogger(TipoDocumentoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_documento";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoDocumentoConstantesFunciones.SCHEMA+"."+TipoDocumentoConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_modulo,id_tipo_movimiento,codigo,nombre,id_tipo_movimiento_modulo,es_defecto,es_mayor)values(current_timestamp,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+TipoDocumentoConstantesFunciones.SCHEMA+"."+TipoDocumentoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_modulo=?,id_tipo_movimiento=?,codigo=?,nombre=?,id_tipo_movimiento_modulo=?,es_defecto=?,es_mayor=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoDocumentoConstantesFunciones.SCHEMA+"."+TipoDocumentoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tipodocumento from "+TipoDocumentoConstantesFunciones.SPERSISTENCENAME+" tipodocumento";
	public static String QUERYSELECTNATIVE="select "+TipoDocumentoConstantesFunciones.SCHEMA+"."+TipoDocumentoConstantesFunciones.TABLENAME+".id,"+TipoDocumentoConstantesFunciones.SCHEMA+"."+TipoDocumentoConstantesFunciones.TABLENAME+".version_row,"+TipoDocumentoConstantesFunciones.SCHEMA+"."+TipoDocumentoConstantesFunciones.TABLENAME+".id_empresa,"+TipoDocumentoConstantesFunciones.SCHEMA+"."+TipoDocumentoConstantesFunciones.TABLENAME+".id_modulo,"+TipoDocumentoConstantesFunciones.SCHEMA+"."+TipoDocumentoConstantesFunciones.TABLENAME+".id_tipo_movimiento,"+TipoDocumentoConstantesFunciones.SCHEMA+"."+TipoDocumentoConstantesFunciones.TABLENAME+".codigo,"+TipoDocumentoConstantesFunciones.SCHEMA+"."+TipoDocumentoConstantesFunciones.TABLENAME+".nombre,"+TipoDocumentoConstantesFunciones.SCHEMA+"."+TipoDocumentoConstantesFunciones.TABLENAME+".id_tipo_movimiento_modulo,"+TipoDocumentoConstantesFunciones.SCHEMA+"."+TipoDocumentoConstantesFunciones.TABLENAME+".es_defecto,"+TipoDocumentoConstantesFunciones.SCHEMA+"."+TipoDocumentoConstantesFunciones.TABLENAME+".es_mayor from "+TipoDocumentoConstantesFunciones.SCHEMA+"."+TipoDocumentoConstantesFunciones.TABLENAME;//+" as "+TipoDocumentoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoDocumentoConstantesFunciones.SCHEMA+"."+TipoDocumentoConstantesFunciones.TABLENAME+".id,"+TipoDocumentoConstantesFunciones.SCHEMA+"."+TipoDocumentoConstantesFunciones.TABLENAME+".version_row,"+TipoDocumentoConstantesFunciones.SCHEMA+"."+TipoDocumentoConstantesFunciones.TABLENAME+".codigo,"+TipoDocumentoConstantesFunciones.SCHEMA+"."+TipoDocumentoConstantesFunciones.TABLENAME+".nombre from "+TipoDocumentoConstantesFunciones.SCHEMA+"."+TipoDocumentoConstantesFunciones.TABLENAME;//+" as "+TipoDocumentoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoDocumentoConstantesFunciones.SCHEMA+"."+TipoDocumentoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_modulo=?,id_tipo_movimiento=?,codigo=?,nombre=?,id_tipo_movimiento_modulo=?,es_defecto=?,es_mayor=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPODOCUMENTO_INSERT(?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPODOCUMENTO_UPDATE(?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPODOCUMENTO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPODOCUMENTO_SELECT(?,?)";
	
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
	
	
	protected TipoDocumentoDataAccessAdditional tipodocumentoDataAccessAdditional=null;
	
	public TipoDocumentoDataAccessAdditional getTipoDocumentoDataAccessAdditional() {
		return this.tipodocumentoDataAccessAdditional;
	}
	
	public void setTipoDocumentoDataAccessAdditional(TipoDocumentoDataAccessAdditional tipodocumentoDataAccessAdditional) {
		try {
			this.tipodocumentoDataAccessAdditional=tipodocumentoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TipoDocumentoDataAccess() {
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
		TipoDocumentoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoDocumentoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoDocumentoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoDocumentoOriginal(TipoDocumento tipodocumento)throws Exception  {
		tipodocumento.setTipoDocumentoOriginal((TipoDocumento)tipodocumento.clone());		
	}
	
	public void setTipoDocumentosOriginal(List<TipoDocumento> tipodocumentos)throws Exception  {
		
		for(TipoDocumento tipodocumento:tipodocumentos){
			tipodocumento.setTipoDocumentoOriginal((TipoDocumento)tipodocumento.clone());
		}
	}
	
	public static void setTipoDocumentoOriginalStatic(TipoDocumento tipodocumento)throws Exception  {
		tipodocumento.setTipoDocumentoOriginal((TipoDocumento)tipodocumento.clone());		
	}
	
	public static void setTipoDocumentosOriginalStatic(List<TipoDocumento> tipodocumentos)throws Exception  {
		
		for(TipoDocumento tipodocumento:tipodocumentos){
			tipodocumento.setTipoDocumentoOriginal((TipoDocumento)tipodocumento.clone());
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
	
	public  TipoDocumento getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoDocumento entity = new TipoDocumento();		
		
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
	
	public  TipoDocumento getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoDocumento entity = new TipoDocumento();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoDocumentoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoDocumentoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Contabilidad.TipoDocumento.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoDocumentoOriginal(new TipoDocumento());
      	    	entity=super.getEntity("",entity,resultSet,TipoDocumentoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoDocumento("",entity,resultSet); 
				
				//entity.setTipoDocumentoOriginal(super.getEntity("",entity.getTipoDocumentoOriginal(),resultSet,TipoDocumentoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoDocumentoOriginal(this.getEntityTipoDocumento("",entity.getTipoDocumentoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoDocumento(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoDocumento getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoDocumento entity = new TipoDocumento();
				
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
	
	public  TipoDocumento getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoDocumento entity = new TipoDocumento();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoDocumentoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoDocumentoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoDocumentoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.TipoDocumento.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoDocumentoOriginal(new TipoDocumento());
      	    	entity=super.getEntity("",entity,resultSet,TipoDocumentoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoDocumento("",entity,resultSet);    
				
				//entity.setTipoDocumentoOriginal(super.getEntity("",entity.getTipoDocumentoOriginal(),resultSet,TipoDocumentoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoDocumentoOriginal(this.getEntityTipoDocumento("",entity.getTipoDocumentoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoDocumento(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoDocumento
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoDocumento entity = new TipoDocumento();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoDocumentoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoDocumentoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoDocumentoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.TipoDocumento.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoDocumento(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoDocumento> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoDocumento> entities = new  ArrayList<TipoDocumento>();
		TipoDocumento entity = new TipoDocumento();		  
		
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
	
	public  List<TipoDocumento> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoDocumento> entities = new  ArrayList<TipoDocumento>();
		TipoDocumento entity = new TipoDocumento();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoDocumentoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoDocumentoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoDocumentoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoDocumento();
      	    	entity=super.getEntity("",entity,resultSet,TipoDocumentoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoDocumento("",entity,resultSet);
      	    	
				//entity.setTipoDocumentoOriginal( new TipoDocumento());
      	    	//entity.setTipoDocumentoOriginal(super.getEntity("",entity.getTipoDocumentoOriginal(),resultSet,TipoDocumentoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoDocumentoOriginal(this.getEntityTipoDocumento("",entity.getTipoDocumentoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoDocumentos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoDocumento(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoDocumento> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoDocumento> entities = new  ArrayList<TipoDocumento>();
		TipoDocumento entity = new TipoDocumento();		  
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
	
	public  List<TipoDocumento> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoDocumento> entities = new  ArrayList<TipoDocumento>();
		TipoDocumento entity = new TipoDocumento();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoDocumento();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoDocumento();
					//entity.setMapTipoDocumento(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoDocumentoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoDocumento().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoDocumentoDataAccess.ISWITHSCHEMA);         		
					entity=TipoDocumentoDataAccess.getEntityTipoDocumento("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoDocumentoOriginal( new TipoDocumento());
					////entity.setTipoDocumentoOriginal(super.getEntity("",entity.getTipoDocumentoOriginal(),resultSet,TipoDocumentoDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoDocumentoOriginal(this.getEntityTipoDocumento("",entity.getTipoDocumentoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoDocumentos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoDocumento(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoDocumento getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoDocumento entity = new TipoDocumento();		  
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
	
	public  TipoDocumento getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoDocumento entity = new TipoDocumento();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoDocumento();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoDocumento();
					//entity.setMapTipoDocumento(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoDocumentoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoDocumento().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoDocumentoDataAccess.ISWITHSCHEMA);         		
					entity=TipoDocumentoDataAccess.getEntityTipoDocumento("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoDocumentoOriginal( new TipoDocumento());
					////entity.setTipoDocumentoOriginal(super.getEntity("",entity.getTipoDocumentoOriginal(),resultSet,TipoDocumentoDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoDocumentoOriginal(this.getEntityTipoDocumento("",entity.getTipoDocumentoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoDocumento(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoDocumento(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoDocumento getEntityTipoDocumento(String strPrefijo,TipoDocumento entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoDocumento.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoDocumento.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoDocumentoDataAccess.setFieldReflectionTipoDocumento(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoDocumento=TipoDocumentoConstantesFunciones.getTodosTiposColumnasTipoDocumento();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoDocumento) {
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
							field = TipoDocumento.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoDocumento.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoDocumentoDataAccess.setFieldReflectionTipoDocumento(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoDocumento(Field field,String strPrefijo,String sColumn,TipoDocumento entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoDocumentoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoDocumentoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoDocumentoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoDocumentoConstantesFunciones.IDMODULO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoDocumentoConstantesFunciones.IDTIPOMOVIMIENTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoDocumentoConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoDocumentoConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoDocumentoConstantesFunciones.IDTIPOMOVIMIENTOMODULO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoDocumentoConstantesFunciones.ESDEFECTO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case TipoDocumentoConstantesFunciones.ESMAYOR:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoDocumento>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoDocumento> entities = new  ArrayList<TipoDocumento>();
		TipoDocumento entity = new TipoDocumento();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoDocumentoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoDocumentoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoDocumentoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoDocumento();
					entity=super.getEntity("",entity,resultSet,TipoDocumentoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoDocumento("",entity,resultSet);
					
					//entity.setTipoDocumentoOriginal( new TipoDocumento());
					//entity.setTipoDocumentoOriginal(super.getEntity("",entity.getTipoDocumentoOriginal(),resultSet,TipoDocumentoDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoDocumentoOriginal(this.getEntityTipoDocumento("",entity.getTipoDocumentoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoDocumentos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoDocumento(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoDocumento>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoDocumento> entities = new  ArrayList<TipoDocumento>();
		TipoDocumento entity = new TipoDocumento();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoDocumentoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoDocumentoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoDocumentoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoDocumento> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoDocumento> entities = new  ArrayList<TipoDocumento>();
		TipoDocumento entity = new TipoDocumento();		  
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
	
	public  List<TipoDocumento> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoDocumento> entities = new  ArrayList<TipoDocumento>();
		TipoDocumento entity = new TipoDocumento();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoDocumento();
      	    	entity=super.getEntity("",entity,resultSet,TipoDocumentoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoDocumento("",entity,resultSet);
      	    	
				//entity.setTipoDocumentoOriginal( new TipoDocumento());
      	    	//entity.setTipoDocumentoOriginal(super.getEntity("",entity.getTipoDocumentoOriginal(),resultSet,TipoDocumentoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoDocumentoOriginal(this.getEntityTipoDocumento("",entity.getTipoDocumentoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoDocumentos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoDocumento(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoDocumento> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoDocumento> entities = new  ArrayList<TipoDocumento>();
		TipoDocumento entity = new TipoDocumento();		  
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
	
	public  List<TipoDocumento> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoDocumento> entities = new  ArrayList<TipoDocumento>();
		TipoDocumento entity = new TipoDocumento();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoDocumento();
      	    	entity=super.getEntity("",entity,resultSet,TipoDocumentoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoDocumento("",entity,resultSet);
      	    	
				//entity.setTipoDocumentoOriginal( new TipoDocumento());
      	    	//entity.setTipoDocumentoOriginal(super.getEntity("",entity.getTipoDocumentoOriginal(),resultSet,TipoDocumentoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoDocumentoOriginal(this.getEntityTipoDocumento("",entity.getTipoDocumentoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoDocumentos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public TipoDocumento getEntityTipoDocumento(String strPrefijo,TipoDocumento entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+TipoDocumentoConstantesFunciones.IDEMPRESA));
				entity.setid_modulo(resultSet.getLong(strPrefijo+TipoDocumentoConstantesFunciones.IDMODULO));
				entity.setid_tipo_movimiento(resultSet.getLong(strPrefijo+TipoDocumentoConstantesFunciones.IDTIPOMOVIMIENTO));
				entity.setcodigo(resultSet.getString(strPrefijo+TipoDocumentoConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+TipoDocumentoConstantesFunciones.NOMBRE));
				entity.setid_tipo_movimiento_modulo(resultSet.getLong(strPrefijo+TipoDocumentoConstantesFunciones.IDTIPOMOVIMIENTOMODULO));
				entity.setes_defecto(resultSet.getBoolean(strPrefijo+TipoDocumentoConstantesFunciones.ESDEFECTO));
				entity.setes_mayor(resultSet.getBoolean(strPrefijo+TipoDocumentoConstantesFunciones.ESMAYOR));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+TipoDocumentoConstantesFunciones.CODIGO));entity.setnombre(resultSet.getString(strPrefijo+TipoDocumentoConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoDocumento(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoDocumento entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoDocumentoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoDocumentoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoDocumentoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoDocumentoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoDocumentoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,TipoDocumentoDataAccess.TABLENAME,TipoDocumentoDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoDocumentoDataAccess.setTipoDocumentoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,TipoDocumento reltipodocumento)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reltipodocumento.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Modulo getModulo(Connexion connexion,TipoDocumento reltipodocumento)throws SQLException,Exception {

		Modulo modulo= new Modulo();

		try {
			ModuloDataAccess moduloDataAccess=new ModuloDataAccess();

			moduloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			moduloDataAccess.setConnexionType(this.connexionType);
			moduloDataAccess.setParameterDbType(this.parameterDbType);

			modulo=moduloDataAccess.getEntity(connexion,reltipodocumento.getid_modulo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return modulo;

	}

	public TipoMovimiento getTipoMovimiento(Connexion connexion,TipoDocumento reltipodocumento)throws SQLException,Exception {

		TipoMovimiento tipomovimiento= new TipoMovimiento();

		try {
			TipoMovimientoDataAccess tipomovimientoDataAccess=new TipoMovimientoDataAccess();

			tipomovimientoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipomovimientoDataAccess.setConnexionType(this.connexionType);
			tipomovimientoDataAccess.setParameterDbType(this.parameterDbType);

			tipomovimiento=tipomovimientoDataAccess.getEntity(connexion,reltipodocumento.getid_tipo_movimiento());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipomovimiento;

	}

	public TipoMovimientoModulo getTipoMovimientoModulo(Connexion connexion,TipoDocumento reltipodocumento)throws SQLException,Exception {

		TipoMovimientoModulo tipomovimientomodulo= new TipoMovimientoModulo();

		try {
			TipoMovimientoModuloDataAccess tipomovimientomoduloDataAccess=new TipoMovimientoModuloDataAccess();

			tipomovimientomoduloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipomovimientomoduloDataAccess.setConnexionType(this.connexionType);
			tipomovimientomoduloDataAccess.setParameterDbType(this.parameterDbType);

			tipomovimientomodulo=tipomovimientomoduloDataAccess.getEntity(connexion,reltipodocumento.getid_tipo_movimiento_modulo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipomovimientomodulo;

	}


		
		public List<FacturaProveedorServicio> getFacturaProveedorServicios(Connexion connexion,TipoDocumento tipodocumento)throws SQLException,Exception {

		List<FacturaProveedorServicio> facturaproveedorservicios= new ArrayList<FacturaProveedorServicio>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoDocumentoConstantesFunciones.SCHEMA+".tipo_documento ON "+FacturaProveedorServicioConstantesFunciones.SCHEMA+".factura_proveedor_servicio.id_tipo_documento="+TipoDocumentoConstantesFunciones.SCHEMA+".tipo_documento.id WHERE "+TipoDocumentoConstantesFunciones.SCHEMA+".tipo_documento.id="+String.valueOf(tipodocumento.getId());
			} else {
				sQuery=" INNER JOIN facturaproveedorservicio.TipoDocumento WHERE facturaproveedorservicio.TipoDocumento.id="+String.valueOf(tipodocumento.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			FacturaProveedorServicioDataAccess facturaproveedorservicioDataAccess=new FacturaProveedorServicioDataAccess();

			facturaproveedorservicioDataAccess.setConnexionType(this.connexionType);
			facturaproveedorservicioDataAccess.setParameterDbType(this.parameterDbType);
			facturaproveedorservicios=facturaproveedorservicioDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return facturaproveedorservicios;

	}

	public List<ParametroContabilidadDefecto> getParametroContabilidadDefectos(Connexion connexion,TipoDocumento tipodocumento)throws SQLException,Exception {

		List<ParametroContabilidadDefecto> parametrocontabilidaddefectos= new ArrayList<ParametroContabilidadDefecto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoDocumentoConstantesFunciones.SCHEMA+".tipo_documento ON "+ParametroContabilidadDefectoConstantesFunciones.SCHEMA+".parametro_contabilidad_defecto.id_tipo_documento="+TipoDocumentoConstantesFunciones.SCHEMA+".tipo_documento.id WHERE "+TipoDocumentoConstantesFunciones.SCHEMA+".tipo_documento.id="+String.valueOf(tipodocumento.getId());
			} else {
				sQuery=" INNER JOIN parametrocontabilidaddefecto.TipoDocumento WHERE parametrocontabilidaddefecto.TipoDocumento.id="+String.valueOf(tipodocumento.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ParametroContabilidadDefectoDataAccess parametrocontabilidaddefectoDataAccess=new ParametroContabilidadDefectoDataAccess();

			parametrocontabilidaddefectoDataAccess.setConnexionType(this.connexionType);
			parametrocontabilidaddefectoDataAccess.setParameterDbType(this.parameterDbType);
			parametrocontabilidaddefectos=parametrocontabilidaddefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return parametrocontabilidaddefectos;

	}

	public List<Definicion> getDefinicions(Connexion connexion,TipoDocumento tipodocumento)throws SQLException,Exception {

		List<Definicion> definicions= new ArrayList<Definicion>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoDocumentoConstantesFunciones.SCHEMA+".tipo_documento ON "+DefinicionConstantesFunciones.SCHEMA+".definicion.id_tipo_documento="+TipoDocumentoConstantesFunciones.SCHEMA+".tipo_documento.id WHERE "+TipoDocumentoConstantesFunciones.SCHEMA+".tipo_documento.id="+String.valueOf(tipodocumento.getId());
			} else {
				sQuery=" INNER JOIN definicion.TipoDocumento WHERE definicion.TipoDocumento.id="+String.valueOf(tipodocumento.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DefinicionDataAccess definicionDataAccess=new DefinicionDataAccess();

			definicionDataAccess.setConnexionType(this.connexionType);
			definicionDataAccess.setParameterDbType(this.parameterDbType);
			definicions=definicionDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return definicions;

	}

	public List<ParametroCompra> getParametroCompras(Connexion connexion,TipoDocumento tipodocumento)throws SQLException,Exception {

		List<ParametroCompra> parametrocompras= new ArrayList<ParametroCompra>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoDocumentoConstantesFunciones.SCHEMA+".tipo_documento ON "+ParametroCompraConstantesFunciones.SCHEMA+".parametro_compra.id_tipo_documento="+TipoDocumentoConstantesFunciones.SCHEMA+".tipo_documento.id WHERE "+TipoDocumentoConstantesFunciones.SCHEMA+".tipo_documento.id="+String.valueOf(tipodocumento.getId());
			} else {
				sQuery=" INNER JOIN parametrocompra.TipoDocumento WHERE parametrocompra.TipoDocumento.id="+String.valueOf(tipodocumento.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ParametroCompraDataAccess parametrocompraDataAccess=new ParametroCompraDataAccess();

			parametrocompraDataAccess.setConnexionType(this.connexionType);
			parametrocompraDataAccess.setParameterDbType(this.parameterDbType);
			parametrocompras=parametrocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return parametrocompras;

	}

	public List<ConfiguracionPunVen> getConfiguracionPunVenNotaVentas(Connexion connexion,TipoDocumento tipodocumento)throws SQLException,Exception {

		List<ConfiguracionPunVen> configuracionpunvennotaventas= new ArrayList<ConfiguracionPunVen>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoDocumentoConstantesFunciones.SCHEMA+".tipo_documento ON "+ConfiguracionPunVenConstantesFunciones.SCHEMA+".configuracion_pun_ven.id_tipo_documento="+TipoDocumentoConstantesFunciones.SCHEMA+".tipo_documento.id WHERE "+TipoDocumentoConstantesFunciones.SCHEMA+".tipo_documento.id="+String.valueOf(tipodocumento.getId());
			} else {
				sQuery=" INNER JOIN configuracionpunven.TipoDocumentoNotaVenta WHERE configuracionpunven.TipoDocumentoNotaVenta.id="+String.valueOf(tipodocumento.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ConfiguracionPunVenDataAccess configuracionpunvenDataAccess=new ConfiguracionPunVenDataAccess();

			configuracionpunvenDataAccess.setConnexionType(this.connexionType);
			configuracionpunvenDataAccess.setParameterDbType(this.parameterDbType);
			configuracionpunvennotaventas=configuracionpunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return configuracionpunvennotaventas;

	}

	public List<AsientoContable> getAsientoContables(Connexion connexion,TipoDocumento tipodocumento)throws SQLException,Exception {

		List<AsientoContable> asientocontables= new ArrayList<AsientoContable>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoDocumentoConstantesFunciones.SCHEMA+".tipo_documento ON "+AsientoContableConstantesFunciones.SCHEMA+".asiento_contable.id_tipo_documento="+TipoDocumentoConstantesFunciones.SCHEMA+".tipo_documento.id WHERE "+TipoDocumentoConstantesFunciones.SCHEMA+".tipo_documento.id="+String.valueOf(tipodocumento.getId());
			} else {
				sQuery=" INNER JOIN asientocontable.TipoDocumento WHERE asientocontable.TipoDocumento.id="+String.valueOf(tipodocumento.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			AsientoContableDataAccess asientocontableDataAccess=new AsientoContableDataAccess();

			asientocontableDataAccess.setConnexionType(this.connexionType);
			asientocontableDataAccess.setParameterDbType(this.parameterDbType);
			asientocontables=asientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return asientocontables;

	}

	public List<ParametroFactuPrincipal> getParametroFactuPrincipalNotaDebitos(Connexion connexion,TipoDocumento tipodocumento)throws SQLException,Exception {

		List<ParametroFactuPrincipal> parametrofactuprincipalnotadebitos= new ArrayList<ParametroFactuPrincipal>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoDocumentoConstantesFunciones.SCHEMA+".tipo_documento ON "+ParametroFactuPrincipalConstantesFunciones.SCHEMA+".parametro_factu_principal.id_tipo_documento="+TipoDocumentoConstantesFunciones.SCHEMA+".tipo_documento.id WHERE "+TipoDocumentoConstantesFunciones.SCHEMA+".tipo_documento.id="+String.valueOf(tipodocumento.getId());
			} else {
				sQuery=" INNER JOIN parametrofactuprincipal.TipoDocumentoNotaDebito WHERE parametrofactuprincipal.TipoDocumentoNotaDebito.id="+String.valueOf(tipodocumento.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ParametroFactuPrincipalDataAccess parametrofactuprincipalDataAccess=new ParametroFactuPrincipalDataAccess();

			parametrofactuprincipalDataAccess.setConnexionType(this.connexionType);
			parametrofactuprincipalDataAccess.setParameterDbType(this.parameterDbType);
			parametrofactuprincipalnotadebitos=parametrofactuprincipalDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return parametrofactuprincipalnotadebitos;

	}

	public List<FacturaProveedor> getFacturaProveedors(Connexion connexion,TipoDocumento tipodocumento)throws SQLException,Exception {

		List<FacturaProveedor> facturaproveedors= new ArrayList<FacturaProveedor>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoDocumentoConstantesFunciones.SCHEMA+".tipo_documento ON "+FacturaProveedorConstantesFunciones.SCHEMA+".factura_proveedor.id_tipo_documento="+TipoDocumentoConstantesFunciones.SCHEMA+".tipo_documento.id WHERE "+TipoDocumentoConstantesFunciones.SCHEMA+".tipo_documento.id="+String.valueOf(tipodocumento.getId());
			} else {
				sQuery=" INNER JOIN facturaproveedor.TipoDocumento WHERE facturaproveedor.TipoDocumento.id="+String.valueOf(tipodocumento.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			FacturaProveedorDataAccess facturaproveedorDataAccess=new FacturaProveedorDataAccess();

			facturaproveedorDataAccess.setConnexionType(this.connexionType);
			facturaproveedorDataAccess.setParameterDbType(this.parameterDbType);
			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return facturaproveedors;

	}

	public List<Secuencial> getSecuencials(Connexion connexion,TipoDocumento tipodocumento)throws SQLException,Exception {

		List<Secuencial> secuencials= new ArrayList<Secuencial>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoDocumentoConstantesFunciones.SCHEMA+".tipo_documento ON "+SecuencialConstantesFunciones.SCHEMA+".secuencial.id_tipo_documento="+TipoDocumentoConstantesFunciones.SCHEMA+".tipo_documento.id WHERE "+TipoDocumentoConstantesFunciones.SCHEMA+".tipo_documento.id="+String.valueOf(tipodocumento.getId());
			} else {
				sQuery=" INNER JOIN secuencial.TipoDocumento WHERE secuencial.TipoDocumento.id="+String.valueOf(tipodocumento.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			SecuencialDataAccess secuencialDataAccess=new SecuencialDataAccess();

			secuencialDataAccess.setConnexionType(this.connexionType);
			secuencialDataAccess.setParameterDbType(this.parameterDbType);
			secuencials=secuencialDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return secuencials;

	}

	public List<AsientoContableCajaChica> getAsientoContableCajaChicas(Connexion connexion,TipoDocumento tipodocumento)throws SQLException,Exception {

		List<AsientoContableCajaChica> asientocontablecajachicas= new ArrayList<AsientoContableCajaChica>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoDocumentoConstantesFunciones.SCHEMA+".tipo_documento ON "+AsientoContableCajaChicaConstantesFunciones.SCHEMA+".asiento_contable_caja_chica.id_tipo_documento="+TipoDocumentoConstantesFunciones.SCHEMA+".tipo_documento.id WHERE "+TipoDocumentoConstantesFunciones.SCHEMA+".tipo_documento.id="+String.valueOf(tipodocumento.getId());
			} else {
				sQuery=" INNER JOIN asientocontablecajachica.TipoDocumento WHERE asientocontablecajachica.TipoDocumento.id="+String.valueOf(tipodocumento.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			AsientoContableCajaChicaDataAccess asientocontablecajachicaDataAccess=new AsientoContableCajaChicaDataAccess();

			asientocontablecajachicaDataAccess.setConnexionType(this.connexionType);
			asientocontablecajachicaDataAccess.setParameterDbType(this.parameterDbType);
			asientocontablecajachicas=asientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return asientocontablecajachicas;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoDocumento tipodocumento) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tipodocumento.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(tipodocumento.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_modulo=new ParameterValue<Long>();
					parameterMaintenanceValueid_modulo.setValue(tipodocumento.getid_modulo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_modulo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_movimiento=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_movimiento.setValue(tipodocumento.getid_tipo_movimiento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_movimiento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(tipodocumento.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tipodocumento.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_movimiento_modulo=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_movimiento_modulo.setValue(tipodocumento.getid_tipo_movimiento_modulo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_movimiento_modulo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_defecto=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_defecto.setValue(tipodocumento.getes_defecto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_defecto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_mayor=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_mayor.setValue(tipodocumento.getes_mayor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_mayor);
					parametersTemp.add(parameterMaintenance);
					
						if(!tipodocumento.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tipodocumento.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tipodocumento.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tipodocumento.getId());
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
	
	public void setIsNewIsChangedFalseTipoDocumento(TipoDocumento tipodocumento)throws Exception  {		
		tipodocumento.setIsNew(false);
		tipodocumento.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoDocumentos(List<TipoDocumento> tipodocumentos)throws Exception  {				
		for(TipoDocumento tipodocumento:tipodocumentos) {
			tipodocumento.setIsNew(false);
			tipodocumento.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoDocumento(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
