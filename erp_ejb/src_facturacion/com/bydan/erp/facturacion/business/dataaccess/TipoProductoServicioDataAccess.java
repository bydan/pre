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
import com.bydan.framework.erp.business.dataaccess.DataAccessHelperSinIdGenerated;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.facturacion.util.*;//TipoProductoServicioConstantesFunciones;


import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;


import com.bydan.erp.inventario.util.*;
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;




@SuppressWarnings("unused")
final public class TipoProductoServicioDataAccess extends  DataAccessHelperSinIdGenerated<TipoProductoServicio>{ //TipoProductoServicioDataAccessAdditional,DataAccessHelper<TipoProductoServicio>
	//static Logger logger = Logger.getLogger(TipoProductoServicioDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_producto_servicio";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoProductoServicioConstantesFunciones.SCHEMA+"."+TipoProductoServicioConstantesFunciones.TABLENAME+"(id,version_row,nombre)values(?,current_timestamp,?)";
	public static String QUERYUPDATE="update "+TipoProductoServicioConstantesFunciones.SCHEMA+"."+TipoProductoServicioConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoProductoServicioConstantesFunciones.SCHEMA+"."+TipoProductoServicioConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tipoproductoservicio from "+TipoProductoServicioConstantesFunciones.SPERSISTENCENAME+" tipoproductoservicio";
	public static String QUERYSELECTNATIVE="select "+TipoProductoServicioConstantesFunciones.SCHEMA+"."+TipoProductoServicioConstantesFunciones.TABLENAME+".id,"+TipoProductoServicioConstantesFunciones.SCHEMA+"."+TipoProductoServicioConstantesFunciones.TABLENAME+".version_row,"+TipoProductoServicioConstantesFunciones.SCHEMA+"."+TipoProductoServicioConstantesFunciones.TABLENAME+".nombre from "+TipoProductoServicioConstantesFunciones.SCHEMA+"."+TipoProductoServicioConstantesFunciones.TABLENAME;//+" as "+TipoProductoServicioConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoProductoServicioConstantesFunciones.SCHEMA+"."+TipoProductoServicioConstantesFunciones.TABLENAME+".id,"+TipoProductoServicioConstantesFunciones.SCHEMA+"."+TipoProductoServicioConstantesFunciones.TABLENAME+".version_row,"+TipoProductoServicioConstantesFunciones.SCHEMA+"."+TipoProductoServicioConstantesFunciones.TABLENAME+".nombre from "+TipoProductoServicioConstantesFunciones.SCHEMA+"."+TipoProductoServicioConstantesFunciones.TABLENAME;//+" as "+TipoProductoServicioConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoProductoServicioConstantesFunciones.SCHEMA+"."+TipoProductoServicioConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPOPRODUCTOSERVICIO_INSERT(?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPOPRODUCTOSERVICIO_UPDATE(? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPOPRODUCTOSERVICIO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPOPRODUCTOSERVICIO_SELECT(?,?)";
	
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
	
	
	public TipoProductoServicioDataAccess() {
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
		TipoProductoServicioDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoProductoServicioDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoProductoServicioDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoProductoServicioOriginal(TipoProductoServicio tipoproductoservicio)throws Exception  {
		tipoproductoservicio.setTipoProductoServicioOriginal((TipoProductoServicio)tipoproductoservicio.clone());		
	}
	
	public void setTipoProductoServiciosOriginal(List<TipoProductoServicio> tipoproductoservicios)throws Exception  {
		
		for(TipoProductoServicio tipoproductoservicio:tipoproductoservicios){
			tipoproductoservicio.setTipoProductoServicioOriginal((TipoProductoServicio)tipoproductoservicio.clone());
		}
	}
	
	public static void setTipoProductoServicioOriginalStatic(TipoProductoServicio tipoproductoservicio)throws Exception  {
		tipoproductoservicio.setTipoProductoServicioOriginal((TipoProductoServicio)tipoproductoservicio.clone());		
	}
	
	public static void setTipoProductoServiciosOriginalStatic(List<TipoProductoServicio> tipoproductoservicios)throws Exception  {
		
		for(TipoProductoServicio tipoproductoservicio:tipoproductoservicios){
			tipoproductoservicio.setTipoProductoServicioOriginal((TipoProductoServicio)tipoproductoservicio.clone());
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
	
	public  TipoProductoServicio getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoProductoServicio entity = new TipoProductoServicio();		
		
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
	
	public  TipoProductoServicio getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoProductoServicio entity = new TipoProductoServicio();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoProductoServicioDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoProductoServicioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Facturacion.TipoProductoServicio.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoProductoServicioOriginal(new TipoProductoServicio());
      	    	entity=super.getEntity("",entity,resultSet,TipoProductoServicioDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoProductoServicio("",entity,resultSet); 
				
				//entity.setTipoProductoServicioOriginal(super.getEntity("",entity.getTipoProductoServicioOriginal(),resultSet,TipoProductoServicioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoProductoServicioOriginal(this.getEntityTipoProductoServicio("",entity.getTipoProductoServicioOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoProductoServicio(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoProductoServicio getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoProductoServicio entity = new TipoProductoServicio();
				
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
	
	public  TipoProductoServicio getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoProductoServicio entity = new TipoProductoServicio();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoProductoServicioDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoProductoServicioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoProductoServicioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.TipoProductoServicio.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoProductoServicioOriginal(new TipoProductoServicio());
      	    	entity=super.getEntity("",entity,resultSet,TipoProductoServicioDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoProductoServicio("",entity,resultSet);    
				
				//entity.setTipoProductoServicioOriginal(super.getEntity("",entity.getTipoProductoServicioOriginal(),resultSet,TipoProductoServicioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoProductoServicioOriginal(this.getEntityTipoProductoServicio("",entity.getTipoProductoServicioOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoProductoServicio(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoProductoServicio
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoProductoServicio entity = new TipoProductoServicio();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoProductoServicioDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoProductoServicioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoProductoServicioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.TipoProductoServicio.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoProductoServicio(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoProductoServicio> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoProductoServicio> entities = new  ArrayList<TipoProductoServicio>();
		TipoProductoServicio entity = new TipoProductoServicio();		  
		
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
	
	public  List<TipoProductoServicio> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoProductoServicio> entities = new  ArrayList<TipoProductoServicio>();
		TipoProductoServicio entity = new TipoProductoServicio();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoProductoServicioDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoProductoServicioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoProductoServicioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoProductoServicio();
      	    	entity=super.getEntity("",entity,resultSet,TipoProductoServicioDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoProductoServicio("",entity,resultSet);
      	    	
				//entity.setTipoProductoServicioOriginal( new TipoProductoServicio());
      	    	//entity.setTipoProductoServicioOriginal(super.getEntity("",entity.getTipoProductoServicioOriginal(),resultSet,TipoProductoServicioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoProductoServicioOriginal(this.getEntityTipoProductoServicio("",entity.getTipoProductoServicioOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoProductoServicios(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoProductoServicio(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoProductoServicio> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoProductoServicio> entities = new  ArrayList<TipoProductoServicio>();
		TipoProductoServicio entity = new TipoProductoServicio();		  
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
	
	public  List<TipoProductoServicio> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoProductoServicio> entities = new  ArrayList<TipoProductoServicio>();
		TipoProductoServicio entity = new TipoProductoServicio();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoProductoServicio();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoProductoServicio();
					//entity.setMapTipoProductoServicio(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoProductoServicioValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoProductoServicio().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoProductoServicioDataAccess.ISWITHSCHEMA);         		
					entity=TipoProductoServicioDataAccess.getEntityTipoProductoServicio("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoProductoServicioOriginal( new TipoProductoServicio());
					////entity.setTipoProductoServicioOriginal(super.getEntity("",entity.getTipoProductoServicioOriginal(),resultSet,TipoProductoServicioDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoProductoServicioOriginal(this.getEntityTipoProductoServicio("",entity.getTipoProductoServicioOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoProductoServicios(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoProductoServicio(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoProductoServicio getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoProductoServicio entity = new TipoProductoServicio();		  
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
	
	public  TipoProductoServicio getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoProductoServicio entity = new TipoProductoServicio();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoProductoServicio();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoProductoServicio();
					//entity.setMapTipoProductoServicio(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoProductoServicioValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoProductoServicio().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoProductoServicioDataAccess.ISWITHSCHEMA);         		
					entity=TipoProductoServicioDataAccess.getEntityTipoProductoServicio("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoProductoServicioOriginal( new TipoProductoServicio());
					////entity.setTipoProductoServicioOriginal(super.getEntity("",entity.getTipoProductoServicioOriginal(),resultSet,TipoProductoServicioDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoProductoServicioOriginal(this.getEntityTipoProductoServicio("",entity.getTipoProductoServicioOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoProductoServicio(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoProductoServicio(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoProductoServicio getEntityTipoProductoServicio(String strPrefijo,TipoProductoServicio entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoProductoServicio.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoProductoServicio.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoProductoServicioDataAccess.setFieldReflectionTipoProductoServicio(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoProductoServicio=TipoProductoServicioConstantesFunciones.getTodosTiposColumnasTipoProductoServicio();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoProductoServicio) {
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
							field = TipoProductoServicio.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoProductoServicio.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoProductoServicioDataAccess.setFieldReflectionTipoProductoServicio(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoProductoServicio(Field field,String strPrefijo,String sColumn,TipoProductoServicio entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoProductoServicioConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoProductoServicioConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoProductoServicioConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoProductoServicio>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoProductoServicio> entities = new  ArrayList<TipoProductoServicio>();
		TipoProductoServicio entity = new TipoProductoServicio();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoProductoServicioDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoProductoServicioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoProductoServicioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoProductoServicio();
					entity=super.getEntity("",entity,resultSet,TipoProductoServicioDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoProductoServicio("",entity,resultSet);
					
					//entity.setTipoProductoServicioOriginal( new TipoProductoServicio());
					//entity.setTipoProductoServicioOriginal(super.getEntity("",entity.getTipoProductoServicioOriginal(),resultSet,TipoProductoServicioDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoProductoServicioOriginal(this.getEntityTipoProductoServicio("",entity.getTipoProductoServicioOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoProductoServicios(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoProductoServicio(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoProductoServicio>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoProductoServicio> entities = new  ArrayList<TipoProductoServicio>();
		TipoProductoServicio entity = new TipoProductoServicio();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoProductoServicioDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoProductoServicioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoProductoServicioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoProductoServicio> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoProductoServicio> entities = new  ArrayList<TipoProductoServicio>();
		TipoProductoServicio entity = new TipoProductoServicio();		  
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
	
	public  List<TipoProductoServicio> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoProductoServicio> entities = new  ArrayList<TipoProductoServicio>();
		TipoProductoServicio entity = new TipoProductoServicio();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoProductoServicio();
      	    	entity=super.getEntity("",entity,resultSet,TipoProductoServicioDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoProductoServicio("",entity,resultSet);
      	    	
				//entity.setTipoProductoServicioOriginal( new TipoProductoServicio());
      	    	//entity.setTipoProductoServicioOriginal(super.getEntity("",entity.getTipoProductoServicioOriginal(),resultSet,TipoProductoServicioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoProductoServicioOriginal(this.getEntityTipoProductoServicio("",entity.getTipoProductoServicioOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoProductoServicios(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoProductoServicio(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	
	
	public TipoProductoServicio getEntityTipoProductoServicio(String strPrefijo,TipoProductoServicio entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setnombre(resultSet.getString(strPrefijo+TipoProductoServicioConstantesFunciones.NOMBRE));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+TipoProductoServicioConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoProductoServicio(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoProductoServicio entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoProductoServicioDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoProductoServicioDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoProductoServicioDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoProductoServicioDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoProductoServicioConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,TipoProductoServicioDataAccess.TABLENAME,TipoProductoServicioDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoProductoServicioDataAccess.setTipoProductoServicioOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
	
		
		public List<Producto> getProductos(Connexion connexion,TipoProductoServicio tipoproductoservicio)throws SQLException,Exception {

		List<Producto> productos= new ArrayList<Producto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoProductoServicioConstantesFunciones.SCHEMA+".tipo_producto_servicio ON "+ProductoConstantesFunciones.SCHEMA+".producto.id_tipo_producto_servicio="+TipoProductoServicioConstantesFunciones.SCHEMA+".tipo_producto_servicio.id WHERE "+TipoProductoServicioConstantesFunciones.SCHEMA+".tipo_producto_servicio.id="+String.valueOf(tipoproductoservicio.getId());
			} else {
				sQuery=" INNER JOIN producto.TipoProductoServicio WHERE producto.TipoProductoServicio.id="+String.valueOf(tipoproductoservicio.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ProductoDataAccess productoDataAccess=new ProductoDataAccess();

			productoDataAccess.setConnexionType(this.connexionType);
			productoDataAccess.setParameterDbType(this.parameterDbType);
			productos=productoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return productos;

	}

	public List<CuentaContableTipo> getCuentaContableTipos(Connexion connexion,TipoProductoServicio tipoproductoservicio)throws SQLException,Exception {

		List<CuentaContableTipo> cuentacontabletipos= new ArrayList<CuentaContableTipo>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoProductoServicioConstantesFunciones.SCHEMA+".tipo_producto_servicio ON "+CuentaContableTipoConstantesFunciones.SCHEMA+".cuenta_contable_tipo.id_tipo_producto_servicio="+TipoProductoServicioConstantesFunciones.SCHEMA+".tipo_producto_servicio.id WHERE "+TipoProductoServicioConstantesFunciones.SCHEMA+".tipo_producto_servicio.id="+String.valueOf(tipoproductoservicio.getId());
			} else {
				sQuery=" INNER JOIN cuentacontabletipo.TipoProductoServicio WHERE cuentacontabletipo.TipoProductoServicio.id="+String.valueOf(tipoproductoservicio.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			CuentaContableTipoDataAccess cuentacontabletipoDataAccess=new CuentaContableTipoDataAccess();

			cuentacontabletipoDataAccess.setConnexionType(this.connexionType);
			cuentacontabletipoDataAccess.setParameterDbType(this.parameterDbType);
			cuentacontabletipos=cuentacontabletipoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontabletipos;

	}

	public List<ParametroInventarioDefecto> getParametroInventarioDefectos(Connexion connexion,TipoProductoServicio tipoproductoservicio)throws SQLException,Exception {

		List<ParametroInventarioDefecto> parametroinventariodefectos= new ArrayList<ParametroInventarioDefecto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoProductoServicioConstantesFunciones.SCHEMA+".tipo_producto_servicio ON "+ParametroInventarioDefectoConstantesFunciones.SCHEMA+".parametro_inventario_defecto.id_tipo_producto_servicio="+TipoProductoServicioConstantesFunciones.SCHEMA+".tipo_producto_servicio.id WHERE "+TipoProductoServicioConstantesFunciones.SCHEMA+".tipo_producto_servicio.id="+String.valueOf(tipoproductoservicio.getId());
			} else {
				sQuery=" INNER JOIN parametroinventariodefecto.TipoProductoServicio WHERE parametroinventariodefecto.TipoProductoServicio.id="+String.valueOf(tipoproductoservicio.getId());

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


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoProductoServicio tipoproductoservicio) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tipoproductoservicio.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid=new ParameterValue<Long>();
					parameterMaintenanceValueid.setValue(tipoproductoservicio.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tipoproductoservicio.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!tipoproductoservicio.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tipoproductoservicio.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tipoproductoservicio.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tipoproductoservicio.getId());
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
	
	public void setIsNewIsChangedFalseTipoProductoServicio(TipoProductoServicio tipoproductoservicio)throws Exception  {		
		tipoproductoservicio.setIsNew(false);
		tipoproductoservicio.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoProductoServicios(List<TipoProductoServicio> tipoproductoservicios)throws Exception  {				
		for(TipoProductoServicio tipoproductoservicio:tipoproductoservicios) {
			tipoproductoservicio.setIsNew(false);
			tipoproductoservicio.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoProductoServicio(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
