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
import com.bydan.erp.contabilidad.util.*;//CentroCostoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.importaciones.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.activosfijos.util.*;




@SuppressWarnings("unused")
final public class CentroCostoDataAccess extends  CentroCostoDataAccessAdditional{ //CentroCostoDataAccessAdditional,DataAccessHelper<CentroCosto>
	//static Logger logger = Logger.getLogger(CentroCostoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="centro_costo";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+CentroCostoConstantesFunciones.SCHEMA+"."+CentroCostoConstantesFunciones.TABLENAME+"(version_row,id_empresa,codigo,nombre,id_centro_costo,porcentaje,valor,orden,es_final,descripcion)values(current_timestamp,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+CentroCostoConstantesFunciones.SCHEMA+"."+CentroCostoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,codigo=?,nombre=?,id_centro_costo=?,porcentaje=?,valor=?,orden=?,es_final=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+CentroCostoConstantesFunciones.SCHEMA+"."+CentroCostoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select centrocosto from "+CentroCostoConstantesFunciones.SPERSISTENCENAME+" centrocosto";
	public static String QUERYSELECTNATIVE="select "+CentroCostoConstantesFunciones.SCHEMA+"."+CentroCostoConstantesFunciones.TABLENAME+".id,"+CentroCostoConstantesFunciones.SCHEMA+"."+CentroCostoConstantesFunciones.TABLENAME+".version_row,"+CentroCostoConstantesFunciones.SCHEMA+"."+CentroCostoConstantesFunciones.TABLENAME+".id_empresa,"+CentroCostoConstantesFunciones.SCHEMA+"."+CentroCostoConstantesFunciones.TABLENAME+".codigo,"+CentroCostoConstantesFunciones.SCHEMA+"."+CentroCostoConstantesFunciones.TABLENAME+".nombre,"+CentroCostoConstantesFunciones.SCHEMA+"."+CentroCostoConstantesFunciones.TABLENAME+".id_centro_costo,"+CentroCostoConstantesFunciones.SCHEMA+"."+CentroCostoConstantesFunciones.TABLENAME+".porcentaje,"+CentroCostoConstantesFunciones.SCHEMA+"."+CentroCostoConstantesFunciones.TABLENAME+".valor,"+CentroCostoConstantesFunciones.SCHEMA+"."+CentroCostoConstantesFunciones.TABLENAME+".orden,"+CentroCostoConstantesFunciones.SCHEMA+"."+CentroCostoConstantesFunciones.TABLENAME+".es_final,"+CentroCostoConstantesFunciones.SCHEMA+"."+CentroCostoConstantesFunciones.TABLENAME+".descripcion from "+CentroCostoConstantesFunciones.SCHEMA+"."+CentroCostoConstantesFunciones.TABLENAME;//+" as "+CentroCostoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+CentroCostoConstantesFunciones.SCHEMA+"."+CentroCostoConstantesFunciones.TABLENAME+".id,"+CentroCostoConstantesFunciones.SCHEMA+"."+CentroCostoConstantesFunciones.TABLENAME+".version_row,"+CentroCostoConstantesFunciones.SCHEMA+"."+CentroCostoConstantesFunciones.TABLENAME+".codigo,"+CentroCostoConstantesFunciones.SCHEMA+"."+CentroCostoConstantesFunciones.TABLENAME+".nombre from "+CentroCostoConstantesFunciones.SCHEMA+"."+CentroCostoConstantesFunciones.TABLENAME;//+" as "+CentroCostoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+CentroCostoConstantesFunciones.SCHEMA+"."+CentroCostoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,codigo=?,nombre=?,id_centro_costo=?,porcentaje=?,valor=?,orden=?,es_final=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_CENTROCOSTO_INSERT(?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_CENTROCOSTO_UPDATE(?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_CENTROCOSTO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_CENTROCOSTO_SELECT(?,?)";
	
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
	
	
	protected CentroCostoDataAccessAdditional centrocostoDataAccessAdditional=null;
	
	public CentroCostoDataAccessAdditional getCentroCostoDataAccessAdditional() {
		return this.centrocostoDataAccessAdditional;
	}
	
	public void setCentroCostoDataAccessAdditional(CentroCostoDataAccessAdditional centrocostoDataAccessAdditional) {
		try {
			this.centrocostoDataAccessAdditional=centrocostoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public CentroCostoDataAccess() {
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
		CentroCostoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		CentroCostoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		CentroCostoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setCentroCostoOriginal(CentroCosto centrocosto)throws Exception  {
		centrocosto.setCentroCostoOriginal((CentroCosto)centrocosto.clone());		
	}
	
	public void setCentroCostosOriginal(List<CentroCosto> centrocostos)throws Exception  {
		
		for(CentroCosto centrocosto:centrocostos){
			centrocosto.setCentroCostoOriginal((CentroCosto)centrocosto.clone());
		}
	}
	
	public static void setCentroCostoOriginalStatic(CentroCosto centrocosto)throws Exception  {
		centrocosto.setCentroCostoOriginal((CentroCosto)centrocosto.clone());		
	}
	
	public static void setCentroCostosOriginalStatic(List<CentroCosto> centrocostos)throws Exception  {
		
		for(CentroCosto centrocosto:centrocostos){
			centrocosto.setCentroCostoOriginal((CentroCosto)centrocosto.clone());
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
	
	public  CentroCosto getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		CentroCosto entity = new CentroCosto();		
		
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
	
	public  CentroCosto getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		CentroCosto entity = new CentroCosto();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=CentroCostoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CentroCostoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Contabilidad.CentroCosto.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setCentroCostoOriginal(new CentroCosto());
      	    	entity=super.getEntity("",entity,resultSet,CentroCostoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityCentroCosto("",entity,resultSet); 
				
				//entity.setCentroCostoOriginal(super.getEntity("",entity.getCentroCostoOriginal(),resultSet,CentroCostoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCentroCostoOriginal(this.getEntityCentroCosto("",entity.getCentroCostoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseCentroCosto(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  CentroCosto getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		CentroCosto entity = new CentroCosto();
				
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
	
	public  CentroCosto getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		CentroCosto entity = new CentroCosto();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=CentroCostoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CentroCostoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CentroCostoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.CentroCosto.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setCentroCostoOriginal(new CentroCosto());
      	    	entity=super.getEntity("",entity,resultSet,CentroCostoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityCentroCosto("",entity,resultSet);    
				
				//entity.setCentroCostoOriginal(super.getEntity("",entity.getCentroCostoOriginal(),resultSet,CentroCostoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCentroCostoOriginal(this.getEntityCentroCosto("",entity.getCentroCostoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseCentroCosto(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //CentroCosto
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		CentroCosto entity = new CentroCosto();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CentroCostoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CentroCostoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CentroCostoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.CentroCosto.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseCentroCosto(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<CentroCosto> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<CentroCosto> entities = new  ArrayList<CentroCosto>();
		CentroCosto entity = new CentroCosto();		  
		
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
	
	public  List<CentroCosto> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<CentroCosto> entities = new  ArrayList<CentroCosto>();
		CentroCosto entity = new CentroCosto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=CentroCostoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CentroCostoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CentroCostoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CentroCosto();
      	    	entity=super.getEntity("",entity,resultSet,CentroCostoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCentroCosto("",entity,resultSet);
      	    	
				//entity.setCentroCostoOriginal( new CentroCosto());
      	    	//entity.setCentroCostoOriginal(super.getEntity("",entity.getCentroCostoOriginal(),resultSet,CentroCostoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCentroCostoOriginal(this.getEntityCentroCosto("",entity.getCentroCostoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCentroCostos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCentroCosto(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<CentroCosto> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<CentroCosto> entities = new  ArrayList<CentroCosto>();
		CentroCosto entity = new CentroCosto();		  
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
	
	public  List<CentroCosto> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<CentroCosto> entities = new  ArrayList<CentroCosto>();
		CentroCosto entity = new CentroCosto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CentroCosto();
				
				if(conMapGenerico) {
					entity.inicializarMapCentroCosto();
					//entity.setMapCentroCosto(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapCentroCostoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapCentroCosto().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CentroCostoDataAccess.ISWITHSCHEMA);         		
					entity=CentroCostoDataAccess.getEntityCentroCosto("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setCentroCostoOriginal( new CentroCosto());
					////entity.setCentroCostoOriginal(super.getEntity("",entity.getCentroCostoOriginal(),resultSet,CentroCostoDataAccess.ISWITHSCHEMA));         		
					////entity.setCentroCostoOriginal(this.getEntityCentroCosto("",entity.getCentroCostoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCentroCostos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCentroCosto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public CentroCosto getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		CentroCosto entity = new CentroCosto();		  
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
	
	public  CentroCosto getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		CentroCosto entity = new CentroCosto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CentroCosto();
				
				if(conMapGenerico) {
					entity.inicializarMapCentroCosto();
					//entity.setMapCentroCosto(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapCentroCostoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapCentroCosto().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CentroCostoDataAccess.ISWITHSCHEMA);         		
					entity=CentroCostoDataAccess.getEntityCentroCosto("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setCentroCostoOriginal( new CentroCosto());
					////entity.setCentroCostoOriginal(super.getEntity("",entity.getCentroCostoOriginal(),resultSet,CentroCostoDataAccess.ISWITHSCHEMA));         		
					////entity.setCentroCostoOriginal(this.getEntityCentroCosto("",entity.getCentroCostoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseCentroCosto(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCentroCosto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static CentroCosto getEntityCentroCosto(String strPrefijo,CentroCosto entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = CentroCosto.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = CentroCosto.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					CentroCostoDataAccess.setFieldReflectionCentroCosto(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasCentroCosto=CentroCostoConstantesFunciones.getTodosTiposColumnasCentroCosto();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasCentroCosto) {
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
							field = CentroCosto.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = CentroCosto.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						CentroCostoDataAccess.setFieldReflectionCentroCosto(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionCentroCosto(Field field,String strPrefijo,String sColumn,CentroCosto entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case CentroCostoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CentroCostoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CentroCostoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CentroCostoConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CentroCostoConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CentroCostoConstantesFunciones.IDCENTROCOSTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CentroCostoConstantesFunciones.PORCENTAJE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CentroCostoConstantesFunciones.VALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CentroCostoConstantesFunciones.ORDEN:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case CentroCostoConstantesFunciones.ESFINAL:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case CentroCostoConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<CentroCosto>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<CentroCosto> entities = new  ArrayList<CentroCosto>();
		CentroCosto entity = new CentroCosto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CentroCostoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CentroCostoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CentroCostoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new CentroCosto();
					entity=super.getEntity("",entity,resultSet,CentroCostoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityCentroCosto("",entity,resultSet);
					
					//entity.setCentroCostoOriginal( new CentroCosto());
					//entity.setCentroCostoOriginal(super.getEntity("",entity.getCentroCostoOriginal(),resultSet,CentroCostoDataAccess.ISWITHSCHEMA));         		
					//entity.setCentroCostoOriginal(this.getEntityCentroCosto("",entity.getCentroCostoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseCentroCostos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCentroCosto(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<CentroCosto>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<CentroCosto> entities = new  ArrayList<CentroCosto>();
		CentroCosto entity = new CentroCosto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CentroCostoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CentroCostoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CentroCostoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<CentroCosto> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CentroCosto> entities = new  ArrayList<CentroCosto>();
		CentroCosto entity = new CentroCosto();		  
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
	
	public  List<CentroCosto> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CentroCosto> entities = new  ArrayList<CentroCosto>();
		CentroCosto entity = new CentroCosto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CentroCosto();
      	    	entity=super.getEntity("",entity,resultSet,CentroCostoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCentroCosto("",entity,resultSet);
      	    	
				//entity.setCentroCostoOriginal( new CentroCosto());
      	    	//entity.setCentroCostoOriginal(super.getEntity("",entity.getCentroCostoOriginal(),resultSet,CentroCostoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCentroCostoOriginal(this.getEntityCentroCosto("",entity.getCentroCostoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseCentroCostos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCentroCosto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<CentroCosto> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CentroCosto> entities = new  ArrayList<CentroCosto>();
		CentroCosto entity = new CentroCosto();		  
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
	
	public  List<CentroCosto> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CentroCosto> entities = new  ArrayList<CentroCosto>();
		CentroCosto entity = new CentroCosto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CentroCosto();
      	    	entity=super.getEntity("",entity,resultSet,CentroCostoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCentroCosto("",entity,resultSet);
      	    	
				//entity.setCentroCostoOriginal( new CentroCosto());
      	    	//entity.setCentroCostoOriginal(super.getEntity("",entity.getCentroCostoOriginal(),resultSet,CentroCostoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCentroCostoOriginal(this.getEntityCentroCosto("",entity.getCentroCostoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCentroCostos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public CentroCosto getEntityCentroCosto(String strPrefijo,CentroCosto entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+CentroCostoConstantesFunciones.IDEMPRESA));
				entity.setcodigo(resultSet.getString(strPrefijo+CentroCostoConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+CentroCostoConstantesFunciones.NOMBRE));
				entity.setid_centro_costo(resultSet.getLong(strPrefijo+CentroCostoConstantesFunciones.IDCENTROCOSTO));if(resultSet.wasNull()) {entity.setid_centro_costo(null); }
				entity.setporcentaje(resultSet.getDouble(strPrefijo+CentroCostoConstantesFunciones.PORCENTAJE));
				entity.setvalor(resultSet.getDouble(strPrefijo+CentroCostoConstantesFunciones.VALOR));
				entity.setorden(resultSet.getInt(strPrefijo+CentroCostoConstantesFunciones.ORDEN));
				entity.setes_final(resultSet.getBoolean(strPrefijo+CentroCostoConstantesFunciones.ESFINAL));
				entity.setdescripcion(resultSet.getString(strPrefijo+CentroCostoConstantesFunciones.DESCRIPCION));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+CentroCostoConstantesFunciones.CODIGO));entity.setnombre(resultSet.getString(strPrefijo+CentroCostoConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowCentroCosto(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(CentroCosto entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=CentroCostoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=CentroCostoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=CentroCostoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=CentroCostoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(CentroCostoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,CentroCostoDataAccess.TABLENAME,CentroCostoDataAccess.ISWITHSTOREPROCEDURES);
			
			CentroCostoDataAccess.setCentroCostoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,CentroCosto relcentrocosto)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relcentrocosto.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public CentroCosto getCentroCosto(Connexion connexion,CentroCosto relcentrocosto)throws SQLException,Exception {

		CentroCosto centrocosto= new CentroCosto();

		try {
			CentroCostoDataAccess centrocostoDataAccess=new CentroCostoDataAccess();

			centrocostoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			centrocostoDataAccess.setConnexionType(this.connexionType);
			centrocostoDataAccess.setParameterDbType(this.parameterDbType);

			centrocosto=centrocostoDataAccess.getEntity(connexion,relcentrocosto.getid_centro_costo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return centrocosto;

	}


		
		public List<ParametroImpor> getParametroImpors(Connexion connexion,CentroCosto centrocosto)throws SQLException,Exception {

		List<ParametroImpor> parametroimpors= new ArrayList<ParametroImpor>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo ON "+ParametroImporConstantesFunciones.SCHEMA+".parametro_impor.id_centro_costo="+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id WHERE "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id="+String.valueOf(centrocosto.getId());
			} else {
				sQuery=" INNER JOIN parametroimpor.CentroCosto WHERE parametroimpor.CentroCosto.id="+String.valueOf(centrocosto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ParametroImporDataAccess parametroimporDataAccess=new ParametroImporDataAccess();

			parametroimporDataAccess.setConnexionType(this.connexionType);
			parametroimporDataAccess.setParameterDbType(this.parameterDbType);
			parametroimpors=parametroimporDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return parametroimpors;

	}

	public List<Empleado> getEmpleados(Connexion connexion,CentroCosto centrocosto)throws SQLException,Exception {

		List<Empleado> empleados= new ArrayList<Empleado>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo ON "+EmpleadoConstantesFunciones.SCHEMA+".empleado.id_centro_costo="+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id WHERE "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id="+String.valueOf(centrocosto.getId());
			} else {
				sQuery=" INNER JOIN empleado.CentroCosto WHERE empleado.CentroCosto.id="+String.valueOf(centrocosto.getId());

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

	public List<NotaCreditoSoli> getNotaCreditoSolis(Connexion connexion,CentroCosto centrocosto)throws SQLException,Exception {

		List<NotaCreditoSoli> notacreditosolis= new ArrayList<NotaCreditoSoli>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo ON "+NotaCreditoSoliConstantesFunciones.SCHEMA+".nota_credito_soli.id_centro_costo="+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id WHERE "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id="+String.valueOf(centrocosto.getId());
			} else {
				sQuery=" INNER JOIN notacreditosoli.CentroCosto WHERE notacreditosoli.CentroCosto.id="+String.valueOf(centrocosto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			NotaCreditoSoliDataAccess notacreditosoliDataAccess=new NotaCreditoSoliDataAccess();

			notacreditosoliDataAccess.setConnexionType(this.connexionType);
			notacreditosoliDataAccess.setParameterDbType(this.parameterDbType);
			notacreditosolis=notacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return notacreditosolis;

	}

	public List<DetalleAsientoContable> getDetalleAsientoContables(Connexion connexion,CentroCosto centrocosto)throws SQLException,Exception {

		List<DetalleAsientoContable> detalleasientocontables= new ArrayList<DetalleAsientoContable>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo ON "+DetalleAsientoContableConstantesFunciones.SCHEMA+".detalle_asiento_contable.id_centro_costo="+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id WHERE "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id="+String.valueOf(centrocosto.getId());
			} else {
				sQuery=" INNER JOIN detalleasientocontable.CentroCosto WHERE detalleasientocontable.CentroCosto.id="+String.valueOf(centrocosto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleAsientoContableDataAccess detalleasientocontableDataAccess=new DetalleAsientoContableDataAccess();

			detalleasientocontableDataAccess.setConnexionType(this.connexionType);
			detalleasientocontableDataAccess.setParameterDbType(this.parameterDbType);
			detalleasientocontables=detalleasientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalleasientocontables;

	}

	public List<Bodega> getBodegas(Connexion connexion,CentroCosto centrocosto)throws SQLException,Exception {

		List<Bodega> bodegas= new ArrayList<Bodega>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo ON "+BodegaConstantesFunciones.SCHEMA+".bodega.id_centro_costo="+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id WHERE "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id="+String.valueOf(centrocosto.getId());
			} else {
				sQuery=" INNER JOIN bodega.CentroCosto WHERE bodega.CentroCosto.id="+String.valueOf(centrocosto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);
			bodegas=bodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodegas;

	}

	public List<DetaNotaCreditoSoli> getDetaNotaCreditoSolis(Connexion connexion,CentroCosto centrocosto)throws SQLException,Exception {

		List<DetaNotaCreditoSoli> detanotacreditosolis= new ArrayList<DetaNotaCreditoSoli>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo ON "+DetaNotaCreditoSoliConstantesFunciones.SCHEMA+".deta_nota_credito_soli.id_centro_costo="+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id WHERE "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id="+String.valueOf(centrocosto.getId());
			} else {
				sQuery=" INNER JOIN detanotacreditosoli.CentroCosto WHERE detanotacreditosoli.CentroCosto.id="+String.valueOf(centrocosto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetaNotaCreditoSoliDataAccess detanotacreditosoliDataAccess=new DetaNotaCreditoSoliDataAccess();

			detanotacreditosoliDataAccess.setConnexionType(this.connexionType);
			detanotacreditosoliDataAccess.setParameterDbType(this.parameterDbType);
			detanotacreditosolis=detanotacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detanotacreditosolis;

	}

	public List<PedidoExpor> getPedidoExpors(Connexion connexion,CentroCosto centrocosto)throws SQLException,Exception {

		List<PedidoExpor> pedidoexpors= new ArrayList<PedidoExpor>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo ON "+PedidoExporConstantesFunciones.SCHEMA+".pedido_expor.id_centro_costo="+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id WHERE "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id="+String.valueOf(centrocosto.getId());
			} else {
				sQuery=" INNER JOIN pedidoexpor.CentroCosto WHERE pedidoexpor.CentroCosto.id="+String.valueOf(centrocosto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PedidoExporDataAccess pedidoexporDataAccess=new PedidoExporDataAccess();

			pedidoexporDataAccess.setConnexionType(this.connexionType);
			pedidoexporDataAccess.setParameterDbType(this.parameterDbType);
			pedidoexpors=pedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pedidoexpors;

	}

	public List<PresupuestoFlujoCaja> getPresupuestoFlujoCajas(Connexion connexion,CentroCosto centrocosto)throws SQLException,Exception {

		List<PresupuestoFlujoCaja> presupuestoflujocajas= new ArrayList<PresupuestoFlujoCaja>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo ON "+PresupuestoFlujoCajaConstantesFunciones.SCHEMA+".presupuesto_flujo_caja.id_centro_costo="+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id WHERE "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id="+String.valueOf(centrocosto.getId());
			} else {
				sQuery=" INNER JOIN presupuestoflujocaja.CentroCosto WHERE presupuestoflujocaja.CentroCosto.id="+String.valueOf(centrocosto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PresupuestoFlujoCajaDataAccess presupuestoflujocajaDataAccess=new PresupuestoFlujoCajaDataAccess();

			presupuestoflujocajaDataAccess.setConnexionType(this.connexionType);
			presupuestoflujocajaDataAccess.setParameterDbType(this.parameterDbType);
			presupuestoflujocajas=presupuestoflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return presupuestoflujocajas;

	}

	public List<NotaCredito> getNotaCreditos(Connexion connexion,CentroCosto centrocosto)throws SQLException,Exception {

		List<NotaCredito> notacreditos= new ArrayList<NotaCredito>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo ON "+NotaCreditoConstantesFunciones.SCHEMA+".nota_credito.id_centro_costo="+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id WHERE "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id="+String.valueOf(centrocosto.getId());
			} else {
				sQuery=" INNER JOIN notacredito.CentroCosto WHERE notacredito.CentroCosto.id="+String.valueOf(centrocosto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			NotaCreditoDataAccess notacreditoDataAccess=new NotaCreditoDataAccess();

			notacreditoDataAccess.setConnexionType(this.connexionType);
			notacreditoDataAccess.setParameterDbType(this.parameterDbType);
			notacreditos=notacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return notacreditos;

	}

	public List<Pedido> getPedidos(Connexion connexion,CentroCosto centrocosto)throws SQLException,Exception {

		List<Pedido> pedidos= new ArrayList<Pedido>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo ON "+PedidoConstantesFunciones.SCHEMA+".pedido.id_centro_costo="+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id WHERE "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id="+String.valueOf(centrocosto.getId());
			} else {
				sQuery=" INNER JOIN pedido.CentroCosto WHERE pedido.CentroCosto.id="+String.valueOf(centrocosto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PedidoDataAccess pedidoDataAccess=new PedidoDataAccess();

			pedidoDataAccess.setConnexionType(this.connexionType);
			pedidoDataAccess.setParameterDbType(this.parameterDbType);
			pedidos=pedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pedidos;

	}

	public List<GastoDepreciacionCentroCosto> getGastoDepreciacionCentroCostos(Connexion connexion,CentroCosto centrocosto)throws SQLException,Exception {

		List<GastoDepreciacionCentroCosto> gastodepreciacioncentrocostos= new ArrayList<GastoDepreciacionCentroCosto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo ON "+GastoDepreciacionCentroCostoConstantesFunciones.SCHEMA+".gasto_depreciacion_centro_costo.id_centro_costo="+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id WHERE "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id="+String.valueOf(centrocosto.getId());
			} else {
				sQuery=" INNER JOIN gastodepreciacioncentrocosto.CentroCosto WHERE gastodepreciacioncentrocosto.CentroCosto.id="+String.valueOf(centrocosto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			GastoDepreciacionCentroCostoDataAccess gastodepreciacioncentrocostoDataAccess=new GastoDepreciacionCentroCostoDataAccess();

			gastodepreciacioncentrocostoDataAccess.setConnexionType(this.connexionType);
			gastodepreciacioncentrocostoDataAccess.setParameterDbType(this.parameterDbType);
			gastodepreciacioncentrocostos=gastodepreciacioncentrocostoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return gastodepreciacioncentrocostos;

	}

	public List<DetalleGuiaRemision> getDetalleGuiaRemisions(Connexion connexion,CentroCosto centrocosto)throws SQLException,Exception {

		List<DetalleGuiaRemision> detalleguiaremisions= new ArrayList<DetalleGuiaRemision>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo ON "+DetalleGuiaRemisionConstantesFunciones.SCHEMA+".detalle_guia_remision.id_centro_costo="+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id WHERE "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id="+String.valueOf(centrocosto.getId());
			} else {
				sQuery=" INNER JOIN detalleguiaremision.CentroCosto WHERE detalleguiaremision.CentroCosto.id="+String.valueOf(centrocosto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleGuiaRemisionDataAccess detalleguiaremisionDataAccess=new DetalleGuiaRemisionDataAccess();

			detalleguiaremisionDataAccess.setConnexionType(this.connexionType);
			detalleguiaremisionDataAccess.setParameterDbType(this.parameterDbType);
			detalleguiaremisions=detalleguiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalleguiaremisions;

	}

	public List<LiquidacionImpor> getLiquidacionImpors(Connexion connexion,CentroCosto centrocosto)throws SQLException,Exception {

		List<LiquidacionImpor> liquidacionimpors= new ArrayList<LiquidacionImpor>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo ON "+LiquidacionImporConstantesFunciones.SCHEMA+".liquidacion_impor.id_centro_costo="+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id WHERE "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id="+String.valueOf(centrocosto.getId());
			} else {
				sQuery=" INNER JOIN liquidacionimpor.CentroCosto WHERE liquidacionimpor.CentroCosto.id="+String.valueOf(centrocosto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			LiquidacionImporDataAccess liquidacionimporDataAccess=new LiquidacionImporDataAccess();

			liquidacionimporDataAccess.setConnexionType(this.connexionType);
			liquidacionimporDataAccess.setParameterDbType(this.parameterDbType);
			liquidacionimpors=liquidacionimporDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return liquidacionimpors;

	}

	public List<BodegaProducto> getBodegaProductos(Connexion connexion,CentroCosto centrocosto)throws SQLException,Exception {

		List<BodegaProducto> bodegaproductos= new ArrayList<BodegaProducto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo ON "+BodegaProductoConstantesFunciones.SCHEMA+".bodega_producto.id_centro_costo="+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id WHERE "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id="+String.valueOf(centrocosto.getId());
			} else {
				sQuery=" INNER JOIN bodegaproducto.CentroCosto WHERE bodegaproducto.CentroCosto.id="+String.valueOf(centrocosto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			BodegaProductoDataAccess bodegaproductoDataAccess=new BodegaProductoDataAccess();

			bodegaproductoDataAccess.setConnexionType(this.connexionType);
			bodegaproductoDataAccess.setParameterDbType(this.parameterDbType);
			bodegaproductos=bodegaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodegaproductos;

	}

	public List<DetalleAsientoContableCajaChica> getDetalleAsientoContableCajaChicas(Connexion connexion,CentroCosto centrocosto)throws SQLException,Exception {

		List<DetalleAsientoContableCajaChica> detalleasientocontablecajachicas= new ArrayList<DetalleAsientoContableCajaChica>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo ON "+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+".detalle_asiento_contable_caja_chica.id_centro_costo="+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id WHERE "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id="+String.valueOf(centrocosto.getId());
			} else {
				sQuery=" INNER JOIN detalleasientocontablecajachica.CentroCosto WHERE detalleasientocontablecajachica.CentroCosto.id="+String.valueOf(centrocosto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleAsientoContableCajaChicaDataAccess detalleasientocontablecajachicaDataAccess=new DetalleAsientoContableCajaChicaDataAccess();

			detalleasientocontablecajachicaDataAccess.setConnexionType(this.connexionType);
			detalleasientocontablecajachicaDataAccess.setParameterDbType(this.parameterDbType);
			detalleasientocontablecajachicas=detalleasientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalleasientocontablecajachicas;

	}

	public List<DetalleOrdenCompra> getDetalleOrdenCompras(Connexion connexion,CentroCosto centrocosto)throws SQLException,Exception {

		List<DetalleOrdenCompra> detalleordencompras= new ArrayList<DetalleOrdenCompra>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo ON "+DetalleOrdenCompraConstantesFunciones.SCHEMA+".detalle_orden_compra.id_centro_costo="+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id WHERE "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id="+String.valueOf(centrocosto.getId());
			} else {
				sQuery=" INNER JOIN detalleordencompra.CentroCosto WHERE detalleordencompra.CentroCosto.id="+String.valueOf(centrocosto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleOrdenCompraDataAccess detalleordencompraDataAccess=new DetalleOrdenCompraDataAccess();

			detalleordencompraDataAccess.setConnexionType(this.connexionType);
			detalleordencompraDataAccess.setParameterDbType(this.parameterDbType);
			detalleordencompras=detalleordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalleordencompras;

	}

	public List<CentroCostoGrupoProducto> getCentroCostoGrupoProductos(Connexion connexion,CentroCosto centrocosto)throws SQLException,Exception {

		List<CentroCostoGrupoProducto> centrocostogrupoproductos= new ArrayList<CentroCostoGrupoProducto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo ON "+CentroCostoGrupoProductoConstantesFunciones.SCHEMA+".centro_costo_grupo_producto.id_centro_costo="+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id WHERE "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id="+String.valueOf(centrocosto.getId());
			} else {
				sQuery=" INNER JOIN centrocostogrupoproducto.CentroCosto WHERE centrocostogrupoproducto.CentroCosto.id="+String.valueOf(centrocosto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			CentroCostoGrupoProductoDataAccess centrocostogrupoproductoDataAccess=new CentroCostoGrupoProductoDataAccess();

			centrocostogrupoproductoDataAccess.setConnexionType(this.connexionType);
			centrocostogrupoproductoDataAccess.setParameterDbType(this.parameterDbType);
			centrocostogrupoproductos=centrocostogrupoproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return centrocostogrupoproductos;

	}

	public List<DetalleMovimientoInventario> getDetalleMovimientoInventarios(Connexion connexion,CentroCosto centrocosto)throws SQLException,Exception {

		List<DetalleMovimientoInventario> detallemovimientoinventarios= new ArrayList<DetalleMovimientoInventario>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo ON "+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+".detalle_movimiento_inventario.id_centro_costo="+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id WHERE "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id="+String.valueOf(centrocosto.getId());
			} else {
				sQuery=" INNER JOIN detallemovimientoinventario.CentroCosto WHERE detallemovimientoinventario.CentroCosto.id="+String.valueOf(centrocosto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleMovimientoInventarioDataAccess detallemovimientoinventarioDataAccess=new DetalleMovimientoInventarioDataAccess();

			detallemovimientoinventarioDataAccess.setConnexionType(this.connexionType);
			detallemovimientoinventarioDataAccess.setParameterDbType(this.parameterDbType);
			detallemovimientoinventarios=detallemovimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detallemovimientoinventarios;

	}

	public List<DetallePedidoCompraImpor> getDetallePedidoCompraImpors(Connexion connexion,CentroCosto centrocosto)throws SQLException,Exception {

		List<DetallePedidoCompraImpor> detallepedidocompraimpors= new ArrayList<DetallePedidoCompraImpor>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo ON "+DetallePedidoCompraImporConstantesFunciones.SCHEMA+".detalle_pedido_compra_impor.id_centro_costo="+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id WHERE "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id="+String.valueOf(centrocosto.getId());
			} else {
				sQuery=" INNER JOIN detallepedidocompraimpor.CentroCosto WHERE detallepedidocompraimpor.CentroCosto.id="+String.valueOf(centrocosto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetallePedidoCompraImporDataAccess detallepedidocompraimporDataAccess=new DetallePedidoCompraImporDataAccess();

			detallepedidocompraimporDataAccess.setConnexionType(this.connexionType);
			detallepedidocompraimporDataAccess.setParameterDbType(this.parameterDbType);
			detallepedidocompraimpors=detallepedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detallepedidocompraimpors;

	}

	public List<PresuProyecto> getPresuProyectos(Connexion connexion,CentroCosto centrocosto)throws SQLException,Exception {

		List<PresuProyecto> presuproyectos= new ArrayList<PresuProyecto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo ON "+PresuProyectoConstantesFunciones.SCHEMA+".presu_proyecto.id_centro_costo="+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id WHERE "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id="+String.valueOf(centrocosto.getId());
			} else {
				sQuery=" INNER JOIN presuproyecto.CentroCosto WHERE presuproyecto.CentroCosto.id="+String.valueOf(centrocosto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PresuProyectoDataAccess presuproyectoDataAccess=new PresuProyectoDataAccess();

			presuproyectoDataAccess.setConnexionType(this.connexionType);
			presuproyectoDataAccess.setParameterDbType(this.parameterDbType);
			presuproyectos=presuproyectoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return presuproyectos;

	}

	public List<ProductoCuentaContable> getProductoCuentaContables(Connexion connexion,CentroCosto centrocosto)throws SQLException,Exception {

		List<ProductoCuentaContable> productocuentacontables= new ArrayList<ProductoCuentaContable>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo ON "+ProductoCuentaContableConstantesFunciones.SCHEMA+".producto_cuenta_contable.id_centro_costo="+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id WHERE "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id="+String.valueOf(centrocosto.getId());
			} else {
				sQuery=" INNER JOIN productocuentacontable.CentroCosto WHERE productocuentacontable.CentroCosto.id="+String.valueOf(centrocosto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ProductoCuentaContableDataAccess productocuentacontableDataAccess=new ProductoCuentaContableDataAccess();

			productocuentacontableDataAccess.setConnexionType(this.connexionType);
			productocuentacontableDataAccess.setParameterDbType(this.parameterDbType);
			productocuentacontables=productocuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return productocuentacontables;

	}

	public List<CentroCostoEstructura> getCentroCostoEstructuras(Connexion connexion,CentroCosto centrocosto)throws SQLException,Exception {

		List<CentroCostoEstructura> centrocostoestructuras= new ArrayList<CentroCostoEstructura>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo ON "+CentroCostoEstructuraConstantesFunciones.SCHEMA+".centro_costo_estructura.id_centro_costo="+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id WHERE "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id="+String.valueOf(centrocosto.getId());
			} else {
				sQuery=" INNER JOIN centrocostoestructura.CentroCosto WHERE centrocostoestructura.CentroCosto.id="+String.valueOf(centrocosto.getId());

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

	public List<DetalleFactura> getDetalleFacturas(Connexion connexion,CentroCosto centrocosto)throws SQLException,Exception {

		List<DetalleFactura> detallefacturas= new ArrayList<DetalleFactura>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo ON "+DetalleFacturaConstantesFunciones.SCHEMA+".detalle_factura.id_centro_costo="+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id WHERE "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id="+String.valueOf(centrocosto.getId());
			} else {
				sQuery=" INNER JOIN detallefactura.CentroCosto WHERE detallefactura.CentroCosto.id="+String.valueOf(centrocosto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleFacturaDataAccess detallefacturaDataAccess=new DetalleFacturaDataAccess();

			detallefacturaDataAccess.setConnexionType(this.connexionType);
			detallefacturaDataAccess.setParameterDbType(this.parameterDbType);
			detallefacturas=detallefacturaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detallefacturas;

	}

	public List<CentroCosto> getCentroCostos(Connexion connexion,CentroCosto centrocosto)throws SQLException,Exception {

		List<CentroCosto> centrocostos= new ArrayList<CentroCosto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo ON "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id_centro_costo="+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id WHERE "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id="+String.valueOf(centrocosto.getId());
			} else {
				sQuery=" INNER JOIN centrocosto.CentroCosto WHERE centrocosto.CentroCosto.id="+String.valueOf(centrocosto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			CentroCostoDataAccess centrocostoDataAccess=new CentroCostoDataAccess();

			centrocostoDataAccess.setConnexionType(this.connexionType);
			centrocostoDataAccess.setParameterDbType(this.parameterDbType);
			centrocostos=centrocostoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return centrocostos;

	}

	public List<DetalleProforma> getDetalleProformas(Connexion connexion,CentroCosto centrocosto)throws SQLException,Exception {

		List<DetalleProforma> detalleproformas= new ArrayList<DetalleProforma>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo ON "+DetalleProformaConstantesFunciones.SCHEMA+".detalle_proforma.id_centro_costo="+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id WHERE "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id="+String.valueOf(centrocosto.getId());
			} else {
				sQuery=" INNER JOIN detalleproforma.CentroCosto WHERE detalleproforma.CentroCosto.id="+String.valueOf(centrocosto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleProformaDataAccess detalleproformaDataAccess=new DetalleProformaDataAccess();

			detalleproformaDataAccess.setConnexionType(this.connexionType);
			detalleproformaDataAccess.setParameterDbType(this.parameterDbType);
			detalleproformas=detalleproformaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalleproformas;

	}

	public List<DetalleServicioTransporte> getDetalleServicioTransportes(Connexion connexion,CentroCosto centrocosto)throws SQLException,Exception {

		List<DetalleServicioTransporte> detalleserviciotransportes= new ArrayList<DetalleServicioTransporte>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo ON "+DetalleServicioTransporteConstantesFunciones.SCHEMA+".detalle_servicio_transporte.id_centro_costo="+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id WHERE "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id="+String.valueOf(centrocosto.getId());
			} else {
				sQuery=" INNER JOIN detalleserviciotransporte.CentroCosto WHERE detalleserviciotransporte.CentroCosto.id="+String.valueOf(centrocosto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleServicioTransporteDataAccess detalleserviciotransporteDataAccess=new DetalleServicioTransporteDataAccess();

			detalleserviciotransporteDataAccess.setConnexionType(this.connexionType);
			detalleserviciotransporteDataAccess.setParameterDbType(this.parameterDbType);
			detalleserviciotransportes=detalleserviciotransporteDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalleserviciotransportes;

	}

	public List<CuentaContable> getCuentaContables(Connexion connexion,CentroCosto centrocosto)throws SQLException,Exception {

		List<CuentaContable> cuentacontables= new ArrayList<CuentaContable>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo ON "+CuentaContableConstantesFunciones.SCHEMA+".cuenta_contable.id_centro_costo="+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id WHERE "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id="+String.valueOf(centrocosto.getId());
			} else {
				sQuery=" INNER JOIN cuentacontable.CentroCosto WHERE cuentacontable.CentroCosto.id="+String.valueOf(centrocosto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);
			cuentacontables=cuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontables;

	}

	public List<GrupoCliente> getGrupoClientes(Connexion connexion,CentroCosto centrocosto)throws SQLException,Exception {

		List<GrupoCliente> grupoclientes= new ArrayList<GrupoCliente>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo ON "+GrupoClienteConstantesFunciones.SCHEMA+".grupo_cliente.id_centro_costo="+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id WHERE "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id="+String.valueOf(centrocosto.getId());
			} else {
				sQuery=" INNER JOIN grupocliente.CentroCosto WHERE grupocliente.CentroCosto.id="+String.valueOf(centrocosto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			GrupoClienteDataAccess grupoclienteDataAccess=new GrupoClienteDataAccess();

			grupoclienteDataAccess.setConnexionType(this.connexionType);
			grupoclienteDataAccess.setParameterDbType(this.parameterDbType);
			grupoclientes=grupoclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return grupoclientes;

	}

	public List<CentroCostoValor> getCentroCostoValors(Connexion connexion,CentroCosto centrocosto)throws SQLException,Exception {

		List<CentroCostoValor> centrocostovalors= new ArrayList<CentroCostoValor>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo ON "+CentroCostoValorConstantesFunciones.SCHEMA+".centro_costo_valor.id_centro_costo="+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id WHERE "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id="+String.valueOf(centrocosto.getId());
			} else {
				sQuery=" INNER JOIN centrocostovalor.CentroCosto WHERE centrocostovalor.CentroCosto.id="+String.valueOf(centrocosto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			CentroCostoValorDataAccess centrocostovalorDataAccess=new CentroCostoValorDataAccess();

			centrocostovalorDataAccess.setConnexionType(this.connexionType);
			centrocostovalorDataAccess.setParameterDbType(this.parameterDbType);
			centrocostovalors=centrocostovalorDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return centrocostovalors;

	}

	public List<DetalleLiquidacionImpor> getDetalleLiquidacionImpors(Connexion connexion,CentroCosto centrocosto)throws SQLException,Exception {

		List<DetalleLiquidacionImpor> detalleliquidacionimpors= new ArrayList<DetalleLiquidacionImpor>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo ON "+DetalleLiquidacionImporConstantesFunciones.SCHEMA+".detalle_liquidacion_impor.id_centro_costo="+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id WHERE "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id="+String.valueOf(centrocosto.getId());
			} else {
				sQuery=" INNER JOIN detalleliquidacionimpor.CentroCosto WHERE detalleliquidacionimpor.CentroCosto.id="+String.valueOf(centrocosto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleLiquidacionImporDataAccess detalleliquidacionimporDataAccess=new DetalleLiquidacionImporDataAccess();

			detalleliquidacionimporDataAccess.setConnexionType(this.connexionType);
			detalleliquidacionimporDataAccess.setParameterDbType(this.parameterDbType);
			detalleliquidacionimpors=detalleliquidacionimporDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalleliquidacionimpors;

	}

	public List<DetallePedidoCompra> getDetallePedidoCompras(Connexion connexion,CentroCosto centrocosto)throws SQLException,Exception {

		List<DetallePedidoCompra> detallepedidocompras= new ArrayList<DetallePedidoCompra>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo ON "+DetallePedidoCompraConstantesFunciones.SCHEMA+".detalle_pedido_compra.id_centro_costo="+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id WHERE "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id="+String.valueOf(centrocosto.getId());
			} else {
				sQuery=" INNER JOIN detallepedidocompra.CentroCosto WHERE detallepedidocompra.CentroCosto.id="+String.valueOf(centrocosto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetallePedidoCompraDataAccess detallepedidocompraDataAccess=new DetallePedidoCompraDataAccess();

			detallepedidocompraDataAccess.setConnexionType(this.connexionType);
			detallepedidocompraDataAccess.setParameterDbType(this.parameterDbType);
			detallepedidocompras=detallepedidocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detallepedidocompras;

	}

	public List<PresupuestoFlujoCajaTsr> getPresupuestoFlujoCajaTsrs(Connexion connexion,CentroCosto centrocosto)throws SQLException,Exception {

		List<PresupuestoFlujoCajaTsr> presupuestoflujocajatsrs= new ArrayList<PresupuestoFlujoCajaTsr>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo ON "+PresupuestoFlujoCajaTsrConstantesFunciones.SCHEMA+".presupuesto_flujo_caja_tsr.id_centro_costo="+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id WHERE "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id="+String.valueOf(centrocosto.getId());
			} else {
				sQuery=" INNER JOIN presupuestoflujocajatsr.CentroCosto WHERE presupuestoflujocajatsr.CentroCosto.id="+String.valueOf(centrocosto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PresupuestoFlujoCajaTsrDataAccess presupuestoflujocajatsrDataAccess=new PresupuestoFlujoCajaTsrDataAccess();

			presupuestoflujocajatsrDataAccess.setConnexionType(this.connexionType);
			presupuestoflujocajatsrDataAccess.setParameterDbType(this.parameterDbType);
			presupuestoflujocajatsrs=presupuestoflujocajatsrDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return presupuestoflujocajatsrs;

	}

	public List<CuentasContablesLineaProducto> getCuentasContablesLineaProductos(Connexion connexion,CentroCosto centrocosto)throws SQLException,Exception {

		List<CuentasContablesLineaProducto> cuentascontableslineaproductos= new ArrayList<CuentasContablesLineaProducto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo ON "+CuentasContablesLineaProductoConstantesFunciones.SCHEMA+".cuentas_contables_linea_producto.id_centro_costo="+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id WHERE "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id="+String.valueOf(centrocosto.getId());
			} else {
				sQuery=" INNER JOIN cuentascontableslineaproducto.CentroCosto WHERE cuentascontableslineaproducto.CentroCosto.id="+String.valueOf(centrocosto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			CuentasContablesLineaProductoDataAccess cuentascontableslineaproductoDataAccess=new CuentasContablesLineaProductoDataAccess();

			cuentascontableslineaproductoDataAccess.setConnexionType(this.connexionType);
			cuentascontableslineaproductoDataAccess.setParameterDbType(this.parameterDbType);
			cuentascontableslineaproductos=cuentascontableslineaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentascontableslineaproductos;

	}

	public List<DetalleFacturaProveedor> getDetalleFacturaProveedors(Connexion connexion,CentroCosto centrocosto)throws SQLException,Exception {

		List<DetalleFacturaProveedor> detallefacturaproveedors= new ArrayList<DetalleFacturaProveedor>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo ON "+DetalleFacturaProveedorConstantesFunciones.SCHEMA+".detalle_factura_proveedor.id_centro_costo="+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id WHERE "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id="+String.valueOf(centrocosto.getId());
			} else {
				sQuery=" INNER JOIN detallefacturaproveedor.CentroCosto WHERE detallefacturaproveedor.CentroCosto.id="+String.valueOf(centrocosto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleFacturaProveedorDataAccess detallefacturaproveedorDataAccess=new DetalleFacturaProveedorDataAccess();

			detallefacturaproveedorDataAccess.setConnexionType(this.connexionType);
			detallefacturaproveedorDataAccess.setParameterDbType(this.parameterDbType);
			detallefacturaproveedors=detallefacturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detallefacturaproveedors;

	}

	public List<AutoriPago> getAutoriPagos(Connexion connexion,CentroCosto centrocosto)throws SQLException,Exception {

		List<AutoriPago> autoripagos= new ArrayList<AutoriPago>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo ON "+AutoriPagoConstantesFunciones.SCHEMA+".autori_pago.id_centro_costo="+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id WHERE "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id="+String.valueOf(centrocosto.getId());
			} else {
				sQuery=" INNER JOIN autoripago.CentroCosto WHERE autoripago.CentroCosto.id="+String.valueOf(centrocosto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			AutoriPagoDataAccess autoripagoDataAccess=new AutoriPagoDataAccess();

			autoripagoDataAccess.setConnexionType(this.connexionType);
			autoripagoDataAccess.setParameterDbType(this.parameterDbType);
			autoripagos=autoripagoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return autoripagos;

	}

	public List<AsistenciaPorCentroCosto> getAsistenciaPorCentroCostos(Connexion connexion,CentroCosto centrocosto)throws SQLException,Exception {

		List<AsistenciaPorCentroCosto> asistenciaporcentrocostos= new ArrayList<AsistenciaPorCentroCosto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo ON "+AsistenciaPorCentroCostoConstantesFunciones.SCHEMA+".asistencia_por_centro_costo.id_centro_costo="+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id WHERE "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id="+String.valueOf(centrocosto.getId());
			} else {
				sQuery=" INNER JOIN asistenciaporcentrocosto.CentroCosto WHERE asistenciaporcentrocosto.CentroCosto.id="+String.valueOf(centrocosto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			AsistenciaPorCentroCostoDataAccess asistenciaporcentrocostoDataAccess=new AsistenciaPorCentroCostoDataAccess();

			asistenciaporcentrocostoDataAccess.setConnexionType(this.connexionType);
			asistenciaporcentrocostoDataAccess.setParameterDbType(this.parameterDbType);
			asistenciaporcentrocostos=asistenciaporcentrocostoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return asistenciaporcentrocostos;

	}

	public List<GrupoBodega> getGrupoBodegas(Connexion connexion,CentroCosto centrocosto)throws SQLException,Exception {

		List<GrupoBodega> grupobodegas= new ArrayList<GrupoBodega>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo ON "+GrupoBodegaConstantesFunciones.SCHEMA+".grupo_bodega.id_centro_costo="+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id WHERE "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id="+String.valueOf(centrocosto.getId());
			} else {
				sQuery=" INNER JOIN grupobodega.CentroCosto WHERE grupobodega.CentroCosto.id="+String.valueOf(centrocosto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			GrupoBodegaDataAccess grupobodegaDataAccess=new GrupoBodegaDataAccess();

			grupobodegaDataAccess.setConnexionType(this.connexionType);
			grupobodegaDataAccess.setParameterDbType(this.parameterDbType);
			grupobodegas=grupobodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return grupobodegas;

	}

	public List<Proforma> getProformas(Connexion connexion,CentroCosto centrocosto)throws SQLException,Exception {

		List<Proforma> proformas= new ArrayList<Proforma>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo ON "+ProformaConstantesFunciones.SCHEMA+".proforma.id_centro_costo="+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id WHERE "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id="+String.valueOf(centrocosto.getId());
			} else {
				sQuery=" INNER JOIN proforma.CentroCosto WHERE proforma.CentroCosto.id="+String.valueOf(centrocosto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ProformaDataAccess proformaDataAccess=new ProformaDataAccess();

			proformaDataAccess.setConnexionType(this.connexionType);
			proformaDataAccess.setParameterDbType(this.parameterDbType);
			proformas=proformaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return proformas;

	}

	public List<DetaNotaCredito> getDetaNotaCreditos(Connexion connexion,CentroCosto centrocosto)throws SQLException,Exception {

		List<DetaNotaCredito> detanotacreditos= new ArrayList<DetaNotaCredito>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo ON "+DetaNotaCreditoConstantesFunciones.SCHEMA+".deta_nota_credito.id_centro_costo="+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id WHERE "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id="+String.valueOf(centrocosto.getId());
			} else {
				sQuery=" INNER JOIN detanotacredito.CentroCosto WHERE detanotacredito.CentroCosto.id="+String.valueOf(centrocosto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetaNotaCreditoDataAccess detanotacreditoDataAccess=new DetaNotaCreditoDataAccess();

			detanotacreditoDataAccess.setConnexionType(this.connexionType);
			detanotacreditoDataAccess.setParameterDbType(this.parameterDbType);
			detanotacreditos=detanotacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detanotacreditos;

	}

	public List<Consignacion> getConsignacions(Connexion connexion,CentroCosto centrocosto)throws SQLException,Exception {

		List<Consignacion> consignacions= new ArrayList<Consignacion>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo ON "+ConsignacionConstantesFunciones.SCHEMA+".consignacion.id_centro_costo="+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id WHERE "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id="+String.valueOf(centrocosto.getId());
			} else {
				sQuery=" INNER JOIN consignacion.CentroCosto WHERE consignacion.CentroCosto.id="+String.valueOf(centrocosto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ConsignacionDataAccess consignacionDataAccess=new ConsignacionDataAccess();

			consignacionDataAccess.setConnexionType(this.connexionType);
			consignacionDataAccess.setParameterDbType(this.parameterDbType);
			consignacions=consignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return consignacions;

	}

	public List<PagoAuto> getPagoAutos(Connexion connexion,CentroCosto centrocosto)throws SQLException,Exception {

		List<PagoAuto> pagoautos= new ArrayList<PagoAuto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo ON "+PagoAutoConstantesFunciones.SCHEMA+".pago_auto.id_centro_costo="+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id WHERE "+CentroCostoConstantesFunciones.SCHEMA+".centro_costo.id="+String.valueOf(centrocosto.getId());
			} else {
				sQuery=" INNER JOIN pagoauto.CentroCosto WHERE pagoauto.CentroCosto.id="+String.valueOf(centrocosto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PagoAutoDataAccess pagoautoDataAccess=new PagoAutoDataAccess();

			pagoautoDataAccess.setConnexionType(this.connexionType);
			pagoautoDataAccess.setParameterDbType(this.parameterDbType);
			pagoautos=pagoautoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pagoautos;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,CentroCosto centrocosto) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!centrocosto.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(centrocosto.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(centrocosto.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(centrocosto.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_centro_costo=new ParameterValue<Long>();
					parameterMaintenanceValueid_centro_costo.setValue(centrocosto.getid_centro_costo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_centro_costo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcentaje=new ParameterValue<Double>();
					parameterMaintenanceValueporcentaje.setValue(centrocosto.getporcentaje());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcentaje);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor=new ParameterValue<Double>();
					parameterMaintenanceValuevalor.setValue(centrocosto.getvalor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValueorden=new ParameterValue<Integer>();
					parameterMaintenanceValueorden.setValue(centrocosto.getorden());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueorden);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_final=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_final.setValue(centrocosto.getes_final());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_final);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(centrocosto.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!centrocosto.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(centrocosto.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(centrocosto.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(centrocosto.getId());
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
	
	public void setIsNewIsChangedFalseCentroCosto(CentroCosto centrocosto)throws Exception  {		
		centrocosto.setIsNew(false);
		centrocosto.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseCentroCostos(List<CentroCosto> centrocostos)throws Exception  {				
		for(CentroCosto centrocosto:centrocostos) {
			centrocosto.setIsNew(false);
			centrocosto.setIsChanged(false);
		}
	}
	
	public void generarExportarCentroCosto(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
