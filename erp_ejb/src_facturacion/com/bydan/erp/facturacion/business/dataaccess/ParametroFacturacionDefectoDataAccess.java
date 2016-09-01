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
package com.bydan.erp.facturacion.business.dataaccess;

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

import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.facturacion.util.*;//ParametroFacturacionDefectoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;




@SuppressWarnings("unused")
final public class ParametroFacturacionDefectoDataAccess extends  ParametroFacturacionDefectoDataAccessAdditional{ //ParametroFacturacionDefectoDataAccessAdditional,DataAccessHelper<ParametroFacturacionDefecto>
	//static Logger logger = Logger.getLogger(ParametroFacturacionDefectoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="parametro_facturacion_defecto";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ParametroFacturacionDefectoConstantesFunciones.SCHEMA+"."+ParametroFacturacionDefectoConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_tipo_via_transporte)values(current_timestamp,?,?,?)";
	public static String QUERYUPDATE="update "+ParametroFacturacionDefectoConstantesFunciones.SCHEMA+"."+ParametroFacturacionDefectoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_tipo_via_transporte=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ParametroFacturacionDefectoConstantesFunciones.SCHEMA+"."+ParametroFacturacionDefectoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select parametrofacturaciondefecto from "+ParametroFacturacionDefectoConstantesFunciones.SPERSISTENCENAME+" parametrofacturaciondefecto";
	public static String QUERYSELECTNATIVE="select "+ParametroFacturacionDefectoConstantesFunciones.SCHEMA+"."+ParametroFacturacionDefectoConstantesFunciones.TABLENAME+".id,"+ParametroFacturacionDefectoConstantesFunciones.SCHEMA+"."+ParametroFacturacionDefectoConstantesFunciones.TABLENAME+".version_row,"+ParametroFacturacionDefectoConstantesFunciones.SCHEMA+"."+ParametroFacturacionDefectoConstantesFunciones.TABLENAME+".id_empresa,"+ParametroFacturacionDefectoConstantesFunciones.SCHEMA+"."+ParametroFacturacionDefectoConstantesFunciones.TABLENAME+".id_sucursal,"+ParametroFacturacionDefectoConstantesFunciones.SCHEMA+"."+ParametroFacturacionDefectoConstantesFunciones.TABLENAME+".id_tipo_via_transporte from "+ParametroFacturacionDefectoConstantesFunciones.SCHEMA+"."+ParametroFacturacionDefectoConstantesFunciones.TABLENAME;//+" as "+ParametroFacturacionDefectoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ParametroFacturacionDefectoConstantesFunciones.SCHEMA+"."+ParametroFacturacionDefectoConstantesFunciones.TABLENAME+".id,"+ParametroFacturacionDefectoConstantesFunciones.SCHEMA+"."+ParametroFacturacionDefectoConstantesFunciones.TABLENAME+".version_row from "+ParametroFacturacionDefectoConstantesFunciones.SCHEMA+"."+ParametroFacturacionDefectoConstantesFunciones.TABLENAME;//+" as "+ParametroFacturacionDefectoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ParametroFacturacionDefectoConstantesFunciones.SCHEMA+"."+ParametroFacturacionDefectoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_tipo_via_transporte=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PARAMETROFACTURACIONDEFECTO_INSERT(?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PARAMETROFACTURACIONDEFECTO_UPDATE(?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PARAMETROFACTURACIONDEFECTO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PARAMETROFACTURACIONDEFECTO_SELECT(?,?)";
	
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
	
	
	protected ParametroFacturacionDefectoDataAccessAdditional parametrofacturaciondefectoDataAccessAdditional=null;
	
	public ParametroFacturacionDefectoDataAccessAdditional getParametroFacturacionDefectoDataAccessAdditional() {
		return this.parametrofacturaciondefectoDataAccessAdditional;
	}
	
	public void setParametroFacturacionDefectoDataAccessAdditional(ParametroFacturacionDefectoDataAccessAdditional parametrofacturaciondefectoDataAccessAdditional) {
		try {
			this.parametrofacturaciondefectoDataAccessAdditional=parametrofacturaciondefectoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ParametroFacturacionDefectoDataAccess() {
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
		ParametroFacturacionDefectoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ParametroFacturacionDefectoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ParametroFacturacionDefectoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setParametroFacturacionDefectoOriginal(ParametroFacturacionDefecto parametrofacturaciondefecto)throws Exception  {
		parametrofacturaciondefecto.setParametroFacturacionDefectoOriginal((ParametroFacturacionDefecto)parametrofacturaciondefecto.clone());		
	}
	
	public void setParametroFacturacionDefectosOriginal(List<ParametroFacturacionDefecto> parametrofacturaciondefectos)throws Exception  {
		
		for(ParametroFacturacionDefecto parametrofacturaciondefecto:parametrofacturaciondefectos){
			parametrofacturaciondefecto.setParametroFacturacionDefectoOriginal((ParametroFacturacionDefecto)parametrofacturaciondefecto.clone());
		}
	}
	
	public static void setParametroFacturacionDefectoOriginalStatic(ParametroFacturacionDefecto parametrofacturaciondefecto)throws Exception  {
		parametrofacturaciondefecto.setParametroFacturacionDefectoOriginal((ParametroFacturacionDefecto)parametrofacturaciondefecto.clone());		
	}
	
	public static void setParametroFacturacionDefectosOriginalStatic(List<ParametroFacturacionDefecto> parametrofacturaciondefectos)throws Exception  {
		
		for(ParametroFacturacionDefecto parametrofacturaciondefecto:parametrofacturaciondefectos){
			parametrofacturaciondefecto.setParametroFacturacionDefectoOriginal((ParametroFacturacionDefecto)parametrofacturaciondefecto.clone());
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
	
	public  ParametroFacturacionDefecto getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		ParametroFacturacionDefecto entity = new ParametroFacturacionDefecto();		
		
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
	
	public  ParametroFacturacionDefecto getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		ParametroFacturacionDefecto entity = new ParametroFacturacionDefecto();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroFacturacionDefectoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroFacturacionDefectoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Facturacion.ParametroFacturacionDefecto.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setParametroFacturacionDefectoOriginal(new ParametroFacturacionDefecto());
      	    	entity=super.getEntity("",entity,resultSet,ParametroFacturacionDefectoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityParametroFacturacionDefecto("",entity,resultSet); 
				
				//entity.setParametroFacturacionDefectoOriginal(super.getEntity("",entity.getParametroFacturacionDefectoOriginal(),resultSet,ParametroFacturacionDefectoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroFacturacionDefectoOriginal(this.getEntityParametroFacturacionDefecto("",entity.getParametroFacturacionDefectoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseParametroFacturacionDefecto(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  ParametroFacturacionDefecto getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ParametroFacturacionDefecto entity = new ParametroFacturacionDefecto();
				
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
	
	public  ParametroFacturacionDefecto getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ParametroFacturacionDefecto entity = new ParametroFacturacionDefecto();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroFacturacionDefectoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroFacturacionDefectoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroFacturacionDefectoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.ParametroFacturacionDefecto.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setParametroFacturacionDefectoOriginal(new ParametroFacturacionDefecto());
      	    	entity=super.getEntity("",entity,resultSet,ParametroFacturacionDefectoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityParametroFacturacionDefecto("",entity,resultSet);    
				
				//entity.setParametroFacturacionDefectoOriginal(super.getEntity("",entity.getParametroFacturacionDefectoOriginal(),resultSet,ParametroFacturacionDefectoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroFacturacionDefectoOriginal(this.getEntityParametroFacturacionDefecto("",entity.getParametroFacturacionDefectoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseParametroFacturacionDefecto(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //ParametroFacturacionDefecto
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		ParametroFacturacionDefecto entity = new ParametroFacturacionDefecto();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroFacturacionDefectoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroFacturacionDefectoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroFacturacionDefectoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.ParametroFacturacionDefecto.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseParametroFacturacionDefecto(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<ParametroFacturacionDefecto> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ParametroFacturacionDefecto> entities = new  ArrayList<ParametroFacturacionDefecto>();
		ParametroFacturacionDefecto entity = new ParametroFacturacionDefecto();		  
		
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
	
	public  List<ParametroFacturacionDefecto> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ParametroFacturacionDefecto> entities = new  ArrayList<ParametroFacturacionDefecto>();
		ParametroFacturacionDefecto entity = new ParametroFacturacionDefecto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroFacturacionDefectoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroFacturacionDefectoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroFacturacionDefectoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroFacturacionDefecto();
      	    	entity=super.getEntity("",entity,resultSet,ParametroFacturacionDefectoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroFacturacionDefecto("",entity,resultSet);
      	    	
				//entity.setParametroFacturacionDefectoOriginal( new ParametroFacturacionDefecto());
      	    	//entity.setParametroFacturacionDefectoOriginal(super.getEntity("",entity.getParametroFacturacionDefectoOriginal(),resultSet,ParametroFacturacionDefectoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroFacturacionDefectoOriginal(this.getEntityParametroFacturacionDefecto("",entity.getParametroFacturacionDefectoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroFacturacionDefectos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroFacturacionDefecto(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ParametroFacturacionDefecto> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ParametroFacturacionDefecto> entities = new  ArrayList<ParametroFacturacionDefecto>();
		ParametroFacturacionDefecto entity = new ParametroFacturacionDefecto();		  
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
	
	public  List<ParametroFacturacionDefecto> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ParametroFacturacionDefecto> entities = new  ArrayList<ParametroFacturacionDefecto>();
		ParametroFacturacionDefecto entity = new ParametroFacturacionDefecto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroFacturacionDefecto();
				
				if(conMapGenerico) {
					entity.inicializarMapParametroFacturacionDefecto();
					//entity.setMapParametroFacturacionDefecto(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapParametroFacturacionDefectoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapParametroFacturacionDefecto().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ParametroFacturacionDefectoDataAccess.ISWITHSCHEMA);         		
					entity=ParametroFacturacionDefectoDataAccess.getEntityParametroFacturacionDefecto("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setParametroFacturacionDefectoOriginal( new ParametroFacturacionDefecto());
					////entity.setParametroFacturacionDefectoOriginal(super.getEntity("",entity.getParametroFacturacionDefectoOriginal(),resultSet,ParametroFacturacionDefectoDataAccess.ISWITHSCHEMA));         		
					////entity.setParametroFacturacionDefectoOriginal(this.getEntityParametroFacturacionDefecto("",entity.getParametroFacturacionDefectoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroFacturacionDefectos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroFacturacionDefecto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public ParametroFacturacionDefecto getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ParametroFacturacionDefecto entity = new ParametroFacturacionDefecto();		  
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
	
	public  ParametroFacturacionDefecto getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ParametroFacturacionDefecto entity = new ParametroFacturacionDefecto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroFacturacionDefecto();
				
				if(conMapGenerico) {
					entity.inicializarMapParametroFacturacionDefecto();
					//entity.setMapParametroFacturacionDefecto(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapParametroFacturacionDefectoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapParametroFacturacionDefecto().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ParametroFacturacionDefectoDataAccess.ISWITHSCHEMA);         		
					entity=ParametroFacturacionDefectoDataAccess.getEntityParametroFacturacionDefecto("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setParametroFacturacionDefectoOriginal( new ParametroFacturacionDefecto());
					////entity.setParametroFacturacionDefectoOriginal(super.getEntity("",entity.getParametroFacturacionDefectoOriginal(),resultSet,ParametroFacturacionDefectoDataAccess.ISWITHSCHEMA));         		
					////entity.setParametroFacturacionDefectoOriginal(this.getEntityParametroFacturacionDefecto("",entity.getParametroFacturacionDefectoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseParametroFacturacionDefecto(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroFacturacionDefecto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ParametroFacturacionDefecto getEntityParametroFacturacionDefecto(String strPrefijo,ParametroFacturacionDefecto entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = ParametroFacturacionDefecto.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = ParametroFacturacionDefecto.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ParametroFacturacionDefectoDataAccess.setFieldReflectionParametroFacturacionDefecto(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasParametroFacturacionDefecto=ParametroFacturacionDefectoConstantesFunciones.getTodosTiposColumnasParametroFacturacionDefecto();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasParametroFacturacionDefecto) {
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
							field = ParametroFacturacionDefecto.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = ParametroFacturacionDefecto.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ParametroFacturacionDefectoDataAccess.setFieldReflectionParametroFacturacionDefecto(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionParametroFacturacionDefecto(Field field,String strPrefijo,String sColumn,ParametroFacturacionDefecto entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ParametroFacturacionDefectoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFacturacionDefectoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ParametroFacturacionDefectoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFacturacionDefectoConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFacturacionDefectoConstantesFunciones.IDTIPOVIATRANSPORTE:
					field.set(entity,resultSet.getLong(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ParametroFacturacionDefecto>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<ParametroFacturacionDefecto> entities = new  ArrayList<ParametroFacturacionDefecto>();
		ParametroFacturacionDefecto entity = new ParametroFacturacionDefecto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroFacturacionDefectoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroFacturacionDefectoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroFacturacionDefectoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new ParametroFacturacionDefecto();
					entity=super.getEntity("",entity,resultSet,ParametroFacturacionDefectoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityParametroFacturacionDefecto("",entity,resultSet);
					
					//entity.setParametroFacturacionDefectoOriginal( new ParametroFacturacionDefecto());
					//entity.setParametroFacturacionDefectoOriginal(super.getEntity("",entity.getParametroFacturacionDefectoOriginal(),resultSet,ParametroFacturacionDefectoDataAccess.ISWITHSCHEMA));         		
					//entity.setParametroFacturacionDefectoOriginal(this.getEntityParametroFacturacionDefecto("",entity.getParametroFacturacionDefectoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseParametroFacturacionDefectos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroFacturacionDefecto(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ParametroFacturacionDefecto>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<ParametroFacturacionDefecto> entities = new  ArrayList<ParametroFacturacionDefecto>();
		ParametroFacturacionDefecto entity = new ParametroFacturacionDefecto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroFacturacionDefectoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroFacturacionDefectoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroFacturacionDefectoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<ParametroFacturacionDefecto> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroFacturacionDefecto> entities = new  ArrayList<ParametroFacturacionDefecto>();
		ParametroFacturacionDefecto entity = new ParametroFacturacionDefecto();		  
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
	
	public  List<ParametroFacturacionDefecto> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroFacturacionDefecto> entities = new  ArrayList<ParametroFacturacionDefecto>();
		ParametroFacturacionDefecto entity = new ParametroFacturacionDefecto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroFacturacionDefecto();
      	    	entity=super.getEntity("",entity,resultSet,ParametroFacturacionDefectoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroFacturacionDefecto("",entity,resultSet);
      	    	
				//entity.setParametroFacturacionDefectoOriginal( new ParametroFacturacionDefecto());
      	    	//entity.setParametroFacturacionDefectoOriginal(super.getEntity("",entity.getParametroFacturacionDefectoOriginal(),resultSet,ParametroFacturacionDefectoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroFacturacionDefectoOriginal(this.getEntityParametroFacturacionDefecto("",entity.getParametroFacturacionDefectoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseParametroFacturacionDefectos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroFacturacionDefecto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ParametroFacturacionDefecto> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroFacturacionDefecto> entities = new  ArrayList<ParametroFacturacionDefecto>();
		ParametroFacturacionDefecto entity = new ParametroFacturacionDefecto();		  
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
	
	public  List<ParametroFacturacionDefecto> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroFacturacionDefecto> entities = new  ArrayList<ParametroFacturacionDefecto>();
		ParametroFacturacionDefecto entity = new ParametroFacturacionDefecto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroFacturacionDefecto();
      	    	entity=super.getEntity("",entity,resultSet,ParametroFacturacionDefectoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroFacturacionDefecto("",entity,resultSet);
      	    	
				//entity.setParametroFacturacionDefectoOriginal( new ParametroFacturacionDefecto());
      	    	//entity.setParametroFacturacionDefectoOriginal(super.getEntity("",entity.getParametroFacturacionDefectoOriginal(),resultSet,ParametroFacturacionDefectoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroFacturacionDefectoOriginal(this.getEntityParametroFacturacionDefecto("",entity.getParametroFacturacionDefectoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroFacturacionDefectos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public ParametroFacturacionDefecto getEntityParametroFacturacionDefecto(String strPrefijo,ParametroFacturacionDefecto entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+ParametroFacturacionDefectoConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+ParametroFacturacionDefectoConstantesFunciones.IDSUCURSAL));
				entity.setid_tipo_via_transporte(resultSet.getLong(strPrefijo+ParametroFacturacionDefectoConstantesFunciones.IDTIPOVIATRANSPORTE));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowParametroFacturacionDefecto(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(ParametroFacturacionDefecto entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ParametroFacturacionDefectoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ParametroFacturacionDefectoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ParametroFacturacionDefectoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ParametroFacturacionDefectoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ParametroFacturacionDefectoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ParametroFacturacionDefectoDataAccess.TABLENAME,ParametroFacturacionDefectoDataAccess.ISWITHSTOREPROCEDURES);
			
			ParametroFacturacionDefectoDataAccess.setParametroFacturacionDefectoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,ParametroFacturacionDefecto relparametrofacturaciondefecto)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relparametrofacturaciondefecto.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,ParametroFacturacionDefecto relparametrofacturaciondefecto)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relparametrofacturaciondefecto.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public TipoViaTransporte getTipoViaTransporte(Connexion connexion,ParametroFacturacionDefecto relparametrofacturaciondefecto)throws SQLException,Exception {

		TipoViaTransporte tipoviatransporte= new TipoViaTransporte();

		try {
			TipoViaTransporteDataAccess tipoviatransporteDataAccess=new TipoViaTransporteDataAccess();

			tipoviatransporteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoviatransporteDataAccess.setConnexionType(this.connexionType);
			tipoviatransporteDataAccess.setParameterDbType(this.parameterDbType);

			tipoviatransporte=tipoviatransporteDataAccess.getEntity(connexion,relparametrofacturaciondefecto.getid_tipo_via_transporte());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoviatransporte;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,ParametroFacturacionDefecto parametrofacturaciondefecto) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!parametrofacturaciondefecto.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(parametrofacturaciondefecto.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(parametrofacturaciondefecto.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_via_transporte=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_via_transporte.setValue(parametrofacturaciondefecto.getid_tipo_via_transporte());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_via_transporte);
					parametersTemp.add(parameterMaintenance);
					
						if(!parametrofacturaciondefecto.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(parametrofacturaciondefecto.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(parametrofacturaciondefecto.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(parametrofacturaciondefecto.getId());
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
	
	public void setIsNewIsChangedFalseParametroFacturacionDefecto(ParametroFacturacionDefecto parametrofacturaciondefecto)throws Exception  {		
		parametrofacturaciondefecto.setIsNew(false);
		parametrofacturaciondefecto.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseParametroFacturacionDefectos(List<ParametroFacturacionDefecto> parametrofacturaciondefectos)throws Exception  {				
		for(ParametroFacturacionDefecto parametrofacturaciondefecto:parametrofacturaciondefectos) {
			parametrofacturaciondefecto.setIsNew(false);
			parametrofacturaciondefecto.setIsChanged(false);
		}
	}
	
	public void generarExportarParametroFacturacionDefecto(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
