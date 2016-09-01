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
import com.bydan.erp.inventario.util.*;//RangoUnidadVentaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class RangoUnidadVentaDataAccess extends  RangoUnidadVentaDataAccessAdditional{ //RangoUnidadVentaDataAccessAdditional,DataAccessHelper<RangoUnidadVenta>
	//static Logger logger = Logger.getLogger(RangoUnidadVentaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="rango_unidad_venta";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+RangoUnidadVentaConstantesFunciones.SCHEMA+"."+RangoUnidadVentaConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_unidad,rango_inicial,rango_final)values(current_timestamp,?,?,?,?)";
	public static String QUERYUPDATE="update "+RangoUnidadVentaConstantesFunciones.SCHEMA+"."+RangoUnidadVentaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_unidad=?,rango_inicial=?,rango_final=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+RangoUnidadVentaConstantesFunciones.SCHEMA+"."+RangoUnidadVentaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select rangounidadventa from "+RangoUnidadVentaConstantesFunciones.SPERSISTENCENAME+" rangounidadventa";
	public static String QUERYSELECTNATIVE="select "+RangoUnidadVentaConstantesFunciones.SCHEMA+"."+RangoUnidadVentaConstantesFunciones.TABLENAME+".id,"+RangoUnidadVentaConstantesFunciones.SCHEMA+"."+RangoUnidadVentaConstantesFunciones.TABLENAME+".version_row,"+RangoUnidadVentaConstantesFunciones.SCHEMA+"."+RangoUnidadVentaConstantesFunciones.TABLENAME+".id_empresa,"+RangoUnidadVentaConstantesFunciones.SCHEMA+"."+RangoUnidadVentaConstantesFunciones.TABLENAME+".id_unidad,"+RangoUnidadVentaConstantesFunciones.SCHEMA+"."+RangoUnidadVentaConstantesFunciones.TABLENAME+".rango_inicial,"+RangoUnidadVentaConstantesFunciones.SCHEMA+"."+RangoUnidadVentaConstantesFunciones.TABLENAME+".rango_final from "+RangoUnidadVentaConstantesFunciones.SCHEMA+"."+RangoUnidadVentaConstantesFunciones.TABLENAME;//+" as "+RangoUnidadVentaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+RangoUnidadVentaConstantesFunciones.SCHEMA+"."+RangoUnidadVentaConstantesFunciones.TABLENAME+".id,"+RangoUnidadVentaConstantesFunciones.SCHEMA+"."+RangoUnidadVentaConstantesFunciones.TABLENAME+".version_row from "+RangoUnidadVentaConstantesFunciones.SCHEMA+"."+RangoUnidadVentaConstantesFunciones.TABLENAME;//+" as "+RangoUnidadVentaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+RangoUnidadVentaConstantesFunciones.SCHEMA+"."+RangoUnidadVentaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_unidad=?,rango_inicial=?,rango_final=?";
	
	public static String STOREPROCEDUREINSERT="call SP_RANGOUNIDADVENTA_INSERT(?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_RANGOUNIDADVENTA_UPDATE(?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_RANGOUNIDADVENTA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_RANGOUNIDADVENTA_SELECT(?,?)";
	
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
	
	
	protected RangoUnidadVentaDataAccessAdditional rangounidadventaDataAccessAdditional=null;
	
	public RangoUnidadVentaDataAccessAdditional getRangoUnidadVentaDataAccessAdditional() {
		return this.rangounidadventaDataAccessAdditional;
	}
	
	public void setRangoUnidadVentaDataAccessAdditional(RangoUnidadVentaDataAccessAdditional rangounidadventaDataAccessAdditional) {
		try {
			this.rangounidadventaDataAccessAdditional=rangounidadventaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public RangoUnidadVentaDataAccess() {
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
		RangoUnidadVentaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		RangoUnidadVentaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		RangoUnidadVentaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setRangoUnidadVentaOriginal(RangoUnidadVenta rangounidadventa)throws Exception  {
		rangounidadventa.setRangoUnidadVentaOriginal((RangoUnidadVenta)rangounidadventa.clone());		
	}
	
	public void setRangoUnidadVentasOriginal(List<RangoUnidadVenta> rangounidadventas)throws Exception  {
		
		for(RangoUnidadVenta rangounidadventa:rangounidadventas){
			rangounidadventa.setRangoUnidadVentaOriginal((RangoUnidadVenta)rangounidadventa.clone());
		}
	}
	
	public static void setRangoUnidadVentaOriginalStatic(RangoUnidadVenta rangounidadventa)throws Exception  {
		rangounidadventa.setRangoUnidadVentaOriginal((RangoUnidadVenta)rangounidadventa.clone());		
	}
	
	public static void setRangoUnidadVentasOriginalStatic(List<RangoUnidadVenta> rangounidadventas)throws Exception  {
		
		for(RangoUnidadVenta rangounidadventa:rangounidadventas){
			rangounidadventa.setRangoUnidadVentaOriginal((RangoUnidadVenta)rangounidadventa.clone());
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
	
	public  RangoUnidadVenta getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		RangoUnidadVenta entity = new RangoUnidadVenta();		
		
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
	
	public  RangoUnidadVenta getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		RangoUnidadVenta entity = new RangoUnidadVenta();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=RangoUnidadVentaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=RangoUnidadVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.RangoUnidadVenta.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setRangoUnidadVentaOriginal(new RangoUnidadVenta());
      	    	entity=super.getEntity("",entity,resultSet,RangoUnidadVentaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityRangoUnidadVenta("",entity,resultSet); 
				
				//entity.setRangoUnidadVentaOriginal(super.getEntity("",entity.getRangoUnidadVentaOriginal(),resultSet,RangoUnidadVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRangoUnidadVentaOriginal(this.getEntityRangoUnidadVenta("",entity.getRangoUnidadVentaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseRangoUnidadVenta(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  RangoUnidadVenta getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		RangoUnidadVenta entity = new RangoUnidadVenta();
				
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
	
	public  RangoUnidadVenta getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		RangoUnidadVenta entity = new RangoUnidadVenta();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=RangoUnidadVentaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=RangoUnidadVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RangoUnidadVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.RangoUnidadVenta.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setRangoUnidadVentaOriginal(new RangoUnidadVenta());
      	    	entity=super.getEntity("",entity,resultSet,RangoUnidadVentaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityRangoUnidadVenta("",entity,resultSet);    
				
				//entity.setRangoUnidadVentaOriginal(super.getEntity("",entity.getRangoUnidadVentaOriginal(),resultSet,RangoUnidadVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRangoUnidadVentaOriginal(this.getEntityRangoUnidadVenta("",entity.getRangoUnidadVentaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseRangoUnidadVenta(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //RangoUnidadVenta
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		RangoUnidadVenta entity = new RangoUnidadVenta();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=RangoUnidadVentaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=RangoUnidadVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RangoUnidadVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.RangoUnidadVenta.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseRangoUnidadVenta(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<RangoUnidadVenta> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<RangoUnidadVenta> entities = new  ArrayList<RangoUnidadVenta>();
		RangoUnidadVenta entity = new RangoUnidadVenta();		  
		
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
	
	public  List<RangoUnidadVenta> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<RangoUnidadVenta> entities = new  ArrayList<RangoUnidadVenta>();
		RangoUnidadVenta entity = new RangoUnidadVenta();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=RangoUnidadVentaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=RangoUnidadVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RangoUnidadVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new RangoUnidadVenta();
      	    	entity=super.getEntity("",entity,resultSet,RangoUnidadVentaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityRangoUnidadVenta("",entity,resultSet);
      	    	
				//entity.setRangoUnidadVentaOriginal( new RangoUnidadVenta());
      	    	//entity.setRangoUnidadVentaOriginal(super.getEntity("",entity.getRangoUnidadVentaOriginal(),resultSet,RangoUnidadVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRangoUnidadVentaOriginal(this.getEntityRangoUnidadVenta("",entity.getRangoUnidadVentaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseRangoUnidadVentas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRangoUnidadVenta(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<RangoUnidadVenta> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<RangoUnidadVenta> entities = new  ArrayList<RangoUnidadVenta>();
		RangoUnidadVenta entity = new RangoUnidadVenta();		  
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
	
	public  List<RangoUnidadVenta> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<RangoUnidadVenta> entities = new  ArrayList<RangoUnidadVenta>();
		RangoUnidadVenta entity = new RangoUnidadVenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new RangoUnidadVenta();
				
				if(conMapGenerico) {
					entity.inicializarMapRangoUnidadVenta();
					//entity.setMapRangoUnidadVenta(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapRangoUnidadVentaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapRangoUnidadVenta().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,RangoUnidadVentaDataAccess.ISWITHSCHEMA);         		
					entity=RangoUnidadVentaDataAccess.getEntityRangoUnidadVenta("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setRangoUnidadVentaOriginal( new RangoUnidadVenta());
					////entity.setRangoUnidadVentaOriginal(super.getEntity("",entity.getRangoUnidadVentaOriginal(),resultSet,RangoUnidadVentaDataAccess.ISWITHSCHEMA));         		
					////entity.setRangoUnidadVentaOriginal(this.getEntityRangoUnidadVenta("",entity.getRangoUnidadVentaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseRangoUnidadVentas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRangoUnidadVenta(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public RangoUnidadVenta getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		RangoUnidadVenta entity = new RangoUnidadVenta();		  
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
	
	public  RangoUnidadVenta getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		RangoUnidadVenta entity = new RangoUnidadVenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new RangoUnidadVenta();
				
				if(conMapGenerico) {
					entity.inicializarMapRangoUnidadVenta();
					//entity.setMapRangoUnidadVenta(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapRangoUnidadVentaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapRangoUnidadVenta().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,RangoUnidadVentaDataAccess.ISWITHSCHEMA);         		
					entity=RangoUnidadVentaDataAccess.getEntityRangoUnidadVenta("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setRangoUnidadVentaOriginal( new RangoUnidadVenta());
					////entity.setRangoUnidadVentaOriginal(super.getEntity("",entity.getRangoUnidadVentaOriginal(),resultSet,RangoUnidadVentaDataAccess.ISWITHSCHEMA));         		
					////entity.setRangoUnidadVentaOriginal(this.getEntityRangoUnidadVenta("",entity.getRangoUnidadVentaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseRangoUnidadVenta(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRangoUnidadVenta(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static RangoUnidadVenta getEntityRangoUnidadVenta(String strPrefijo,RangoUnidadVenta entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = RangoUnidadVenta.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = RangoUnidadVenta.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					RangoUnidadVentaDataAccess.setFieldReflectionRangoUnidadVenta(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasRangoUnidadVenta=RangoUnidadVentaConstantesFunciones.getTodosTiposColumnasRangoUnidadVenta();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasRangoUnidadVenta) {
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
							field = RangoUnidadVenta.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = RangoUnidadVenta.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						RangoUnidadVentaDataAccess.setFieldReflectionRangoUnidadVenta(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionRangoUnidadVenta(Field field,String strPrefijo,String sColumn,RangoUnidadVenta entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case RangoUnidadVentaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RangoUnidadVentaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RangoUnidadVentaConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RangoUnidadVentaConstantesFunciones.IDUNIDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RangoUnidadVentaConstantesFunciones.RANGOINICIAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case RangoUnidadVentaConstantesFunciones.RANGOFINAL:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<RangoUnidadVenta>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<RangoUnidadVenta> entities = new  ArrayList<RangoUnidadVenta>();
		RangoUnidadVenta entity = new RangoUnidadVenta();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=RangoUnidadVentaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=RangoUnidadVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RangoUnidadVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new RangoUnidadVenta();
					entity=super.getEntity("",entity,resultSet,RangoUnidadVentaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityRangoUnidadVenta("",entity,resultSet);
					
					//entity.setRangoUnidadVentaOriginal( new RangoUnidadVenta());
					//entity.setRangoUnidadVentaOriginal(super.getEntity("",entity.getRangoUnidadVentaOriginal(),resultSet,RangoUnidadVentaDataAccess.ISWITHSCHEMA));         		
					//entity.setRangoUnidadVentaOriginal(this.getEntityRangoUnidadVenta("",entity.getRangoUnidadVentaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseRangoUnidadVentas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRangoUnidadVenta(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<RangoUnidadVenta>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<RangoUnidadVenta> entities = new  ArrayList<RangoUnidadVenta>();
		RangoUnidadVenta entity = new RangoUnidadVenta();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=RangoUnidadVentaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=RangoUnidadVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RangoUnidadVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<RangoUnidadVenta> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<RangoUnidadVenta> entities = new  ArrayList<RangoUnidadVenta>();
		RangoUnidadVenta entity = new RangoUnidadVenta();		  
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
	
	public  List<RangoUnidadVenta> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<RangoUnidadVenta> entities = new  ArrayList<RangoUnidadVenta>();
		RangoUnidadVenta entity = new RangoUnidadVenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new RangoUnidadVenta();
      	    	entity=super.getEntity("",entity,resultSet,RangoUnidadVentaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityRangoUnidadVenta("",entity,resultSet);
      	    	
				//entity.setRangoUnidadVentaOriginal( new RangoUnidadVenta());
      	    	//entity.setRangoUnidadVentaOriginal(super.getEntity("",entity.getRangoUnidadVentaOriginal(),resultSet,RangoUnidadVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRangoUnidadVentaOriginal(this.getEntityRangoUnidadVenta("",entity.getRangoUnidadVentaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseRangoUnidadVentas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRangoUnidadVenta(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<RangoUnidadVenta> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<RangoUnidadVenta> entities = new  ArrayList<RangoUnidadVenta>();
		RangoUnidadVenta entity = new RangoUnidadVenta();		  
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
	
	public  List<RangoUnidadVenta> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<RangoUnidadVenta> entities = new  ArrayList<RangoUnidadVenta>();
		RangoUnidadVenta entity = new RangoUnidadVenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new RangoUnidadVenta();
      	    	entity=super.getEntity("",entity,resultSet,RangoUnidadVentaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityRangoUnidadVenta("",entity,resultSet);
      	    	
				//entity.setRangoUnidadVentaOriginal( new RangoUnidadVenta());
      	    	//entity.setRangoUnidadVentaOriginal(super.getEntity("",entity.getRangoUnidadVentaOriginal(),resultSet,RangoUnidadVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRangoUnidadVentaOriginal(this.getEntityRangoUnidadVenta("",entity.getRangoUnidadVentaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseRangoUnidadVentas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public RangoUnidadVenta getEntityRangoUnidadVenta(String strPrefijo,RangoUnidadVenta entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+RangoUnidadVentaConstantesFunciones.IDEMPRESA));
				entity.setid_unidad(resultSet.getLong(strPrefijo+RangoUnidadVentaConstantesFunciones.IDUNIDAD));
				entity.setrango_inicial(resultSet.getDouble(strPrefijo+RangoUnidadVentaConstantesFunciones.RANGOINICIAL));
				entity.setrango_final(resultSet.getDouble(strPrefijo+RangoUnidadVentaConstantesFunciones.RANGOFINAL));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowRangoUnidadVenta(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(RangoUnidadVenta entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=RangoUnidadVentaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=RangoUnidadVentaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=RangoUnidadVentaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=RangoUnidadVentaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(RangoUnidadVentaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,RangoUnidadVentaDataAccess.TABLENAME,RangoUnidadVentaDataAccess.ISWITHSTOREPROCEDURES);
			
			RangoUnidadVentaDataAccess.setRangoUnidadVentaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,RangoUnidadVenta relrangounidadventa)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relrangounidadventa.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Unidad getUnidad(Connexion connexion,RangoUnidadVenta relrangounidadventa)throws SQLException,Exception {

		Unidad unidad= new Unidad();

		try {
			UnidadDataAccess unidadDataAccess=new UnidadDataAccess();

			unidadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			unidadDataAccess.setConnexionType(this.connexionType);
			unidadDataAccess.setParameterDbType(this.parameterDbType);

			unidad=unidadDataAccess.getEntity(connexion,relrangounidadventa.getid_unidad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return unidad;

	}


		
		public List<Precio> getPrecios(Connexion connexion,RangoUnidadVenta rangounidadventa)throws SQLException,Exception {

		List<Precio> precios= new ArrayList<Precio>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+RangoUnidadVentaConstantesFunciones.SCHEMA+".rango_unidad_venta ON "+PrecioConstantesFunciones.SCHEMA+".precio.id_rango_unidad_venta="+RangoUnidadVentaConstantesFunciones.SCHEMA+".rango_unidad_venta.id WHERE "+RangoUnidadVentaConstantesFunciones.SCHEMA+".rango_unidad_venta.id="+String.valueOf(rangounidadventa.getId());
			} else {
				sQuery=" INNER JOIN precio.RangoUnidadVenta WHERE precio.RangoUnidadVenta.id="+String.valueOf(rangounidadventa.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PrecioDataAccess precioDataAccess=new PrecioDataAccess();

			precioDataAccess.setConnexionType(this.connexionType);
			precioDataAccess.setParameterDbType(this.parameterDbType);
			precios=precioDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return precios;

	}

	public List<ParametroInventarioDefecto> getParametroInventarioDefectos(Connexion connexion,RangoUnidadVenta rangounidadventa)throws SQLException,Exception {

		List<ParametroInventarioDefecto> parametroinventariodefectos= new ArrayList<ParametroInventarioDefecto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+RangoUnidadVentaConstantesFunciones.SCHEMA+".rango_unidad_venta ON "+ParametroInventarioDefectoConstantesFunciones.SCHEMA+".parametro_inventario_defecto.id_rango_unidad_venta="+RangoUnidadVentaConstantesFunciones.SCHEMA+".rango_unidad_venta.id WHERE "+RangoUnidadVentaConstantesFunciones.SCHEMA+".rango_unidad_venta.id="+String.valueOf(rangounidadventa.getId());
			} else {
				sQuery=" INNER JOIN parametroinventariodefecto.RangoUnidadVenta WHERE parametroinventariodefecto.RangoUnidadVenta.id="+String.valueOf(rangounidadventa.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ParametroInventarioDefectoDataAccess parametroinventariodefectoDataAccess=new ParametroInventarioDefectoDataAccess();

			parametroinventariodefectoDataAccess.setConnexionType(this.connexionType);
			parametroinventariodefectoDataAccess.setParameterDbType(this.parameterDbType);
			parametroinventariodefectos=parametroinventariodefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return parametroinventariodefectos;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,RangoUnidadVenta rangounidadventa) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!rangounidadventa.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(rangounidadventa.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_unidad=new ParameterValue<Long>();
					parameterMaintenanceValueid_unidad.setValue(rangounidadventa.getid_unidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_unidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuerango_inicial=new ParameterValue<Double>();
					parameterMaintenanceValuerango_inicial.setValue(rangounidadventa.getrango_inicial());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuerango_inicial);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuerango_final=new ParameterValue<Double>();
					parameterMaintenanceValuerango_final.setValue(rangounidadventa.getrango_final());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuerango_final);
					parametersTemp.add(parameterMaintenance);
					
						if(!rangounidadventa.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(rangounidadventa.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(rangounidadventa.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(rangounidadventa.getId());
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
	
	public void setIsNewIsChangedFalseRangoUnidadVenta(RangoUnidadVenta rangounidadventa)throws Exception  {		
		rangounidadventa.setIsNew(false);
		rangounidadventa.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseRangoUnidadVentas(List<RangoUnidadVenta> rangounidadventas)throws Exception  {				
		for(RangoUnidadVenta rangounidadventa:rangounidadventas) {
			rangounidadventa.setIsNew(false);
			rangounidadventa.setIsChanged(false);
		}
	}
	
	public void generarExportarRangoUnidadVenta(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
