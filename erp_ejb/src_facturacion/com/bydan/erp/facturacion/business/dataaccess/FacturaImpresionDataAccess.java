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
import com.bydan.erp.facturacion.util.*;//FacturaImpresionConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class FacturaImpresionDataAccess extends  FacturaImpresionDataAccessAdditional{ //FacturaImpresionDataAccessAdditional,DataAccessHelper<FacturaImpresion>
	//static Logger logger = Logger.getLogger(FacturaImpresionDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="factura_impresion";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+FacturaImpresionConstantesFunciones.SCHEMA+"."+FacturaImpresionConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_factura,id_estado_factu_impre)values(current_timestamp,?,?,?,?)";
	public static String QUERYUPDATE="update "+FacturaImpresionConstantesFunciones.SCHEMA+"."+FacturaImpresionConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_factura=?,id_estado_factu_impre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+FacturaImpresionConstantesFunciones.SCHEMA+"."+FacturaImpresionConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select facturaimpresion from "+FacturaImpresionConstantesFunciones.SPERSISTENCENAME+" facturaimpresion";
	public static String QUERYSELECTNATIVE="select "+FacturaImpresionConstantesFunciones.SCHEMA+"."+FacturaImpresionConstantesFunciones.TABLENAME+".id,"+FacturaImpresionConstantesFunciones.SCHEMA+"."+FacturaImpresionConstantesFunciones.TABLENAME+".version_row,"+FacturaImpresionConstantesFunciones.SCHEMA+"."+FacturaImpresionConstantesFunciones.TABLENAME+".id_empresa,"+FacturaImpresionConstantesFunciones.SCHEMA+"."+FacturaImpresionConstantesFunciones.TABLENAME+".id_sucursal,"+FacturaImpresionConstantesFunciones.SCHEMA+"."+FacturaImpresionConstantesFunciones.TABLENAME+".id_factura,"+FacturaImpresionConstantesFunciones.SCHEMA+"."+FacturaImpresionConstantesFunciones.TABLENAME+".id_estado_factu_impre from "+FacturaImpresionConstantesFunciones.SCHEMA+"."+FacturaImpresionConstantesFunciones.TABLENAME;//+" as "+FacturaImpresionConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+FacturaImpresionConstantesFunciones.SCHEMA+"."+FacturaImpresionConstantesFunciones.TABLENAME+".id,"+FacturaImpresionConstantesFunciones.SCHEMA+"."+FacturaImpresionConstantesFunciones.TABLENAME+".version_row from "+FacturaImpresionConstantesFunciones.SCHEMA+"."+FacturaImpresionConstantesFunciones.TABLENAME;//+" as "+FacturaImpresionConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+FacturaImpresionConstantesFunciones.SCHEMA+"."+FacturaImpresionConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_factura=?,id_estado_factu_impre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_FACTURAIMPRESION_INSERT(?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_FACTURAIMPRESION_UPDATE(?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_FACTURAIMPRESION_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_FACTURAIMPRESION_SELECT(?,?)";
	
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
	
	
	protected FacturaImpresionDataAccessAdditional facturaimpresionDataAccessAdditional=null;
	
	public FacturaImpresionDataAccessAdditional getFacturaImpresionDataAccessAdditional() {
		return this.facturaimpresionDataAccessAdditional;
	}
	
	public void setFacturaImpresionDataAccessAdditional(FacturaImpresionDataAccessAdditional facturaimpresionDataAccessAdditional) {
		try {
			this.facturaimpresionDataAccessAdditional=facturaimpresionDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public FacturaImpresionDataAccess() {
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
		FacturaImpresionDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		FacturaImpresionDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		FacturaImpresionDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setFacturaImpresionOriginal(FacturaImpresion facturaimpresion)throws Exception  {
		facturaimpresion.setFacturaImpresionOriginal((FacturaImpresion)facturaimpresion.clone());		
	}
	
	public void setFacturaImpresionsOriginal(List<FacturaImpresion> facturaimpresions)throws Exception  {
		
		for(FacturaImpresion facturaimpresion:facturaimpresions){
			facturaimpresion.setFacturaImpresionOriginal((FacturaImpresion)facturaimpresion.clone());
		}
	}
	
	public static void setFacturaImpresionOriginalStatic(FacturaImpresion facturaimpresion)throws Exception  {
		facturaimpresion.setFacturaImpresionOriginal((FacturaImpresion)facturaimpresion.clone());		
	}
	
	public static void setFacturaImpresionsOriginalStatic(List<FacturaImpresion> facturaimpresions)throws Exception  {
		
		for(FacturaImpresion facturaimpresion:facturaimpresions){
			facturaimpresion.setFacturaImpresionOriginal((FacturaImpresion)facturaimpresion.clone());
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
	
	public  FacturaImpresion getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		FacturaImpresion entity = new FacturaImpresion();		
		
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
	
	public  FacturaImpresion getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		FacturaImpresion entity = new FacturaImpresion();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=FacturaImpresionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=FacturaImpresionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Facturacion.FacturaImpresion.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setFacturaImpresionOriginal(new FacturaImpresion());
      	    	entity=super.getEntity("",entity,resultSet,FacturaImpresionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityFacturaImpresion("",entity,resultSet); 
				
				//entity.setFacturaImpresionOriginal(super.getEntity("",entity.getFacturaImpresionOriginal(),resultSet,FacturaImpresionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFacturaImpresionOriginal(this.getEntityFacturaImpresion("",entity.getFacturaImpresionOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseFacturaImpresion(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  FacturaImpresion getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		FacturaImpresion entity = new FacturaImpresion();
				
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
	
	public  FacturaImpresion getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		FacturaImpresion entity = new FacturaImpresion();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=FacturaImpresionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=FacturaImpresionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FacturaImpresionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.FacturaImpresion.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setFacturaImpresionOriginal(new FacturaImpresion());
      	    	entity=super.getEntity("",entity,resultSet,FacturaImpresionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityFacturaImpresion("",entity,resultSet);    
				
				//entity.setFacturaImpresionOriginal(super.getEntity("",entity.getFacturaImpresionOriginal(),resultSet,FacturaImpresionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFacturaImpresionOriginal(this.getEntityFacturaImpresion("",entity.getFacturaImpresionOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseFacturaImpresion(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //FacturaImpresion
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		FacturaImpresion entity = new FacturaImpresion();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=FacturaImpresionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=FacturaImpresionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FacturaImpresionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.FacturaImpresion.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseFacturaImpresion(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<FacturaImpresion> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<FacturaImpresion> entities = new  ArrayList<FacturaImpresion>();
		FacturaImpresion entity = new FacturaImpresion();		  
		
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
	
	public  List<FacturaImpresion> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<FacturaImpresion> entities = new  ArrayList<FacturaImpresion>();
		FacturaImpresion entity = new FacturaImpresion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=FacturaImpresionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=FacturaImpresionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FacturaImpresionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FacturaImpresion();
      	    	entity=super.getEntity("",entity,resultSet,FacturaImpresionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityFacturaImpresion("",entity,resultSet);
      	    	
				//entity.setFacturaImpresionOriginal( new FacturaImpresion());
      	    	//entity.setFacturaImpresionOriginal(super.getEntity("",entity.getFacturaImpresionOriginal(),resultSet,FacturaImpresionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFacturaImpresionOriginal(this.getEntityFacturaImpresion("",entity.getFacturaImpresionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseFacturaImpresions(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFacturaImpresion(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<FacturaImpresion> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<FacturaImpresion> entities = new  ArrayList<FacturaImpresion>();
		FacturaImpresion entity = new FacturaImpresion();		  
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
	
	public  List<FacturaImpresion> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<FacturaImpresion> entities = new  ArrayList<FacturaImpresion>();
		FacturaImpresion entity = new FacturaImpresion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FacturaImpresion();
				
				if(conMapGenerico) {
					entity.inicializarMapFacturaImpresion();
					//entity.setMapFacturaImpresion(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapFacturaImpresionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapFacturaImpresion().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,FacturaImpresionDataAccess.ISWITHSCHEMA);         		
					entity=FacturaImpresionDataAccess.getEntityFacturaImpresion("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setFacturaImpresionOriginal( new FacturaImpresion());
					////entity.setFacturaImpresionOriginal(super.getEntity("",entity.getFacturaImpresionOriginal(),resultSet,FacturaImpresionDataAccess.ISWITHSCHEMA));         		
					////entity.setFacturaImpresionOriginal(this.getEntityFacturaImpresion("",entity.getFacturaImpresionOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseFacturaImpresions(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFacturaImpresion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public FacturaImpresion getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		FacturaImpresion entity = new FacturaImpresion();		  
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
	
	public  FacturaImpresion getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		FacturaImpresion entity = new FacturaImpresion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FacturaImpresion();
				
				if(conMapGenerico) {
					entity.inicializarMapFacturaImpresion();
					//entity.setMapFacturaImpresion(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapFacturaImpresionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapFacturaImpresion().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,FacturaImpresionDataAccess.ISWITHSCHEMA);         		
					entity=FacturaImpresionDataAccess.getEntityFacturaImpresion("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setFacturaImpresionOriginal( new FacturaImpresion());
					////entity.setFacturaImpresionOriginal(super.getEntity("",entity.getFacturaImpresionOriginal(),resultSet,FacturaImpresionDataAccess.ISWITHSCHEMA));         		
					////entity.setFacturaImpresionOriginal(this.getEntityFacturaImpresion("",entity.getFacturaImpresionOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseFacturaImpresion(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFacturaImpresion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static FacturaImpresion getEntityFacturaImpresion(String strPrefijo,FacturaImpresion entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = FacturaImpresion.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = FacturaImpresion.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					FacturaImpresionDataAccess.setFieldReflectionFacturaImpresion(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasFacturaImpresion=FacturaImpresionConstantesFunciones.getTodosTiposColumnasFacturaImpresion();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasFacturaImpresion) {
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
							field = FacturaImpresion.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = FacturaImpresion.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						FacturaImpresionDataAccess.setFieldReflectionFacturaImpresion(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionFacturaImpresion(Field field,String strPrefijo,String sColumn,FacturaImpresion entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case FacturaImpresionConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaImpresionConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FacturaImpresionConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaImpresionConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaImpresionConstantesFunciones.IDFACTURA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaImpresionConstantesFunciones.IDESTADOFACTUIMPRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<FacturaImpresion>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<FacturaImpresion> entities = new  ArrayList<FacturaImpresion>();
		FacturaImpresion entity = new FacturaImpresion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=FacturaImpresionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=FacturaImpresionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FacturaImpresionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new FacturaImpresion();
					entity=super.getEntity("",entity,resultSet,FacturaImpresionDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityFacturaImpresion("",entity,resultSet);
					
					//entity.setFacturaImpresionOriginal( new FacturaImpresion());
					//entity.setFacturaImpresionOriginal(super.getEntity("",entity.getFacturaImpresionOriginal(),resultSet,FacturaImpresionDataAccess.ISWITHSCHEMA));         		
					//entity.setFacturaImpresionOriginal(this.getEntityFacturaImpresion("",entity.getFacturaImpresionOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseFacturaImpresions(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFacturaImpresion(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<FacturaImpresion>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<FacturaImpresion> entities = new  ArrayList<FacturaImpresion>();
		FacturaImpresion entity = new FacturaImpresion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=FacturaImpresionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=FacturaImpresionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FacturaImpresionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<FacturaImpresion> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<FacturaImpresion> entities = new  ArrayList<FacturaImpresion>();
		FacturaImpresion entity = new FacturaImpresion();		  
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
	
	public  List<FacturaImpresion> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<FacturaImpresion> entities = new  ArrayList<FacturaImpresion>();
		FacturaImpresion entity = new FacturaImpresion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FacturaImpresion();
      	    	entity=super.getEntity("",entity,resultSet,FacturaImpresionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityFacturaImpresion("",entity,resultSet);
      	    	
				//entity.setFacturaImpresionOriginal( new FacturaImpresion());
      	    	//entity.setFacturaImpresionOriginal(super.getEntity("",entity.getFacturaImpresionOriginal(),resultSet,FacturaImpresionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFacturaImpresionOriginal(this.getEntityFacturaImpresion("",entity.getFacturaImpresionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseFacturaImpresions(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFacturaImpresion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<FacturaImpresion> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<FacturaImpresion> entities = new  ArrayList<FacturaImpresion>();
		FacturaImpresion entity = new FacturaImpresion();		  
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
	
	public  List<FacturaImpresion> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<FacturaImpresion> entities = new  ArrayList<FacturaImpresion>();
		FacturaImpresion entity = new FacturaImpresion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FacturaImpresion();
      	    	entity=super.getEntity("",entity,resultSet,FacturaImpresionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityFacturaImpresion("",entity,resultSet);
      	    	
				//entity.setFacturaImpresionOriginal( new FacturaImpresion());
      	    	//entity.setFacturaImpresionOriginal(super.getEntity("",entity.getFacturaImpresionOriginal(),resultSet,FacturaImpresionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFacturaImpresionOriginal(this.getEntityFacturaImpresion("",entity.getFacturaImpresionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseFacturaImpresions(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public FacturaImpresion getEntityFacturaImpresion(String strPrefijo,FacturaImpresion entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+FacturaImpresionConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+FacturaImpresionConstantesFunciones.IDSUCURSAL));
				entity.setid_factura(resultSet.getLong(strPrefijo+FacturaImpresionConstantesFunciones.IDFACTURA));
				entity.setid_estado_factu_impre(resultSet.getLong(strPrefijo+FacturaImpresionConstantesFunciones.IDESTADOFACTUIMPRE));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowFacturaImpresion(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(FacturaImpresion entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=FacturaImpresionDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=FacturaImpresionDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=FacturaImpresionDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=FacturaImpresionDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(FacturaImpresionConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,FacturaImpresionDataAccess.TABLENAME,FacturaImpresionDataAccess.ISWITHSTOREPROCEDURES);
			
			FacturaImpresionDataAccess.setFacturaImpresionOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,FacturaImpresion relfacturaimpresion)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relfacturaimpresion.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,FacturaImpresion relfacturaimpresion)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relfacturaimpresion.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Factura getFactura(Connexion connexion,FacturaImpresion relfacturaimpresion)throws SQLException,Exception {

		Factura factura= new Factura();

		try {
			FacturaDataAccess facturaDataAccess=new FacturaDataAccess();

			facturaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			facturaDataAccess.setConnexionType(this.connexionType);
			facturaDataAccess.setParameterDbType(this.parameterDbType);

			factura=facturaDataAccess.getEntity(connexion,relfacturaimpresion.getid_factura());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return factura;

	}

	public EstadoFactuImpre getEstadoFactuImpre(Connexion connexion,FacturaImpresion relfacturaimpresion)throws SQLException,Exception {

		EstadoFactuImpre estadofactuimpre= new EstadoFactuImpre();

		try {
			EstadoFactuImpreDataAccess estadofactuimpreDataAccess=new EstadoFactuImpreDataAccess();

			estadofactuimpreDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadofactuimpreDataAccess.setConnexionType(this.connexionType);
			estadofactuimpreDataAccess.setParameterDbType(this.parameterDbType);

			estadofactuimpre=estadofactuimpreDataAccess.getEntity(connexion,relfacturaimpresion.getid_estado_factu_impre());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadofactuimpre;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,FacturaImpresion facturaimpresion) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!facturaimpresion.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(facturaimpresion.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(facturaimpresion.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_factura=new ParameterValue<Long>();
					parameterMaintenanceValueid_factura.setValue(facturaimpresion.getid_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_factu_impre=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_factu_impre.setValue(facturaimpresion.getid_estado_factu_impre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_factu_impre);
					parametersTemp.add(parameterMaintenance);
					
						if(!facturaimpresion.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(facturaimpresion.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(facturaimpresion.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(facturaimpresion.getId());
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
	
	public void setIsNewIsChangedFalseFacturaImpresion(FacturaImpresion facturaimpresion)throws Exception  {		
		facturaimpresion.setIsNew(false);
		facturaimpresion.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseFacturaImpresions(List<FacturaImpresion> facturaimpresions)throws Exception  {				
		for(FacturaImpresion facturaimpresion:facturaimpresions) {
			facturaimpresion.setIsNew(false);
			facturaimpresion.setIsChanged(false);
		}
	}
	
	public void generarExportarFacturaImpresion(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
