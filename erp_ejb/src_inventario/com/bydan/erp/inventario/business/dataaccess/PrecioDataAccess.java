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
import com.bydan.erp.inventario.util.*;//PrecioConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class PrecioDataAccess extends  PrecioDataAccessAdditional{ //PrecioDataAccessAdditional,DataAccessHelper<Precio>
	//static Logger logger = Logger.getLogger(PrecioDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="precio";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+PrecioConstantesFunciones.SCHEMA+"."+PrecioConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_bodega,id_producto,id_linea,id_linea_grupo,id_linea_categoria,id_linea_marca,id_rango_unidad_venta,id_tipo_precio,precio,descuento,precio_minimo,con_impuesto,id_estado_precio)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+PrecioConstantesFunciones.SCHEMA+"."+PrecioConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_bodega=?,id_producto=?,id_linea=?,id_linea_grupo=?,id_linea_categoria=?,id_linea_marca=?,id_rango_unidad_venta=?,id_tipo_precio=?,precio=?,descuento=?,precio_minimo=?,con_impuesto=?,id_estado_precio=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+PrecioConstantesFunciones.SCHEMA+"."+PrecioConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select precio from "+PrecioConstantesFunciones.SPERSISTENCENAME+" precio";
	public static String QUERYSELECTNATIVE="select "+PrecioConstantesFunciones.SCHEMA+"."+PrecioConstantesFunciones.TABLENAME+".id,"+PrecioConstantesFunciones.SCHEMA+"."+PrecioConstantesFunciones.TABLENAME+".version_row,"+PrecioConstantesFunciones.SCHEMA+"."+PrecioConstantesFunciones.TABLENAME+".id_empresa,"+PrecioConstantesFunciones.SCHEMA+"."+PrecioConstantesFunciones.TABLENAME+".id_sucursal,"+PrecioConstantesFunciones.SCHEMA+"."+PrecioConstantesFunciones.TABLENAME+".id_bodega,"+PrecioConstantesFunciones.SCHEMA+"."+PrecioConstantesFunciones.TABLENAME+".id_producto,"+PrecioConstantesFunciones.SCHEMA+"."+PrecioConstantesFunciones.TABLENAME+".id_linea,"+PrecioConstantesFunciones.SCHEMA+"."+PrecioConstantesFunciones.TABLENAME+".id_linea_grupo,"+PrecioConstantesFunciones.SCHEMA+"."+PrecioConstantesFunciones.TABLENAME+".id_linea_categoria,"+PrecioConstantesFunciones.SCHEMA+"."+PrecioConstantesFunciones.TABLENAME+".id_linea_marca,"+PrecioConstantesFunciones.SCHEMA+"."+PrecioConstantesFunciones.TABLENAME+".id_rango_unidad_venta,"+PrecioConstantesFunciones.SCHEMA+"."+PrecioConstantesFunciones.TABLENAME+".id_tipo_precio,"+PrecioConstantesFunciones.SCHEMA+"."+PrecioConstantesFunciones.TABLENAME+".precio,"+PrecioConstantesFunciones.SCHEMA+"."+PrecioConstantesFunciones.TABLENAME+".descuento,"+PrecioConstantesFunciones.SCHEMA+"."+PrecioConstantesFunciones.TABLENAME+".precio_minimo,"+PrecioConstantesFunciones.SCHEMA+"."+PrecioConstantesFunciones.TABLENAME+".con_impuesto,"+PrecioConstantesFunciones.SCHEMA+"."+PrecioConstantesFunciones.TABLENAME+".id_estado_precio from "+PrecioConstantesFunciones.SCHEMA+"."+PrecioConstantesFunciones.TABLENAME;//+" as "+PrecioConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+PrecioConstantesFunciones.SCHEMA+"."+PrecioConstantesFunciones.TABLENAME+".id,"+PrecioConstantesFunciones.SCHEMA+"."+PrecioConstantesFunciones.TABLENAME+".version_row from "+PrecioConstantesFunciones.SCHEMA+"."+PrecioConstantesFunciones.TABLENAME;//+" as "+PrecioConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+PrecioConstantesFunciones.SCHEMA+"."+PrecioConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_bodega=?,id_producto=?,id_linea=?,id_linea_grupo=?,id_linea_categoria=?,id_linea_marca=?,id_rango_unidad_venta=?,id_tipo_precio=?,precio=?,descuento=?,precio_minimo=?,con_impuesto=?,id_estado_precio=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PRECIO_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PRECIO_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PRECIO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PRECIO_SELECT(?,?)";
	
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
	
	
	protected PrecioDataAccessAdditional precioDataAccessAdditional=null;
	
	public PrecioDataAccessAdditional getPrecioDataAccessAdditional() {
		return this.precioDataAccessAdditional;
	}
	
	public void setPrecioDataAccessAdditional(PrecioDataAccessAdditional precioDataAccessAdditional) {
		try {
			this.precioDataAccessAdditional=precioDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public PrecioDataAccess() {
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
		PrecioDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		PrecioDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		PrecioDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setPrecioOriginal(Precio precio)throws Exception  {
		precio.setPrecioOriginal((Precio)precio.clone());		
	}
	
	public void setPreciosOriginal(List<Precio> precios)throws Exception  {
		
		for(Precio precio:precios){
			precio.setPrecioOriginal((Precio)precio.clone());
		}
	}
	
	public static void setPrecioOriginalStatic(Precio precio)throws Exception  {
		precio.setPrecioOriginal((Precio)precio.clone());		
	}
	
	public static void setPreciosOriginalStatic(List<Precio> precios)throws Exception  {
		
		for(Precio precio:precios){
			precio.setPrecioOriginal((Precio)precio.clone());
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
	
	public  Precio getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		Precio entity = new Precio();		
		
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
	
	public  Precio getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		Precio entity = new Precio();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PrecioDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PrecioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.Precio.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setPrecioOriginal(new Precio());
      	    	entity=super.getEntity("",entity,resultSet,PrecioDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPrecio("",entity,resultSet); 
				
				//entity.setPrecioOriginal(super.getEntity("",entity.getPrecioOriginal(),resultSet,PrecioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPrecioOriginal(this.getEntityPrecio("",entity.getPrecioOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalsePrecio(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  Precio getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Precio entity = new Precio();
				
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
	
	public  Precio getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Precio entity = new Precio();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PrecioDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PrecioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PrecioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.Precio.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setPrecioOriginal(new Precio());
      	    	entity=super.getEntity("",entity,resultSet,PrecioDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPrecio("",entity,resultSet);    
				
				//entity.setPrecioOriginal(super.getEntity("",entity.getPrecioOriginal(),resultSet,PrecioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPrecioOriginal(this.getEntityPrecio("",entity.getPrecioOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalsePrecio(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //Precio
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		Precio entity = new Precio();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PrecioDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PrecioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PrecioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.Precio.isActive=1
        	 
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
				//this.setIsNewIsChangedFalsePrecio(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<Precio> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Precio> entities = new  ArrayList<Precio>();
		Precio entity = new Precio();		  
		
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
	
	public  List<Precio> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Precio> entities = new  ArrayList<Precio>();
		Precio entity = new Precio();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=PrecioDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PrecioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PrecioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Precio();
      	    	entity=super.getEntity("",entity,resultSet,PrecioDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPrecio("",entity,resultSet);
      	    	
				//entity.setPrecioOriginal( new Precio());
      	    	//entity.setPrecioOriginal(super.getEntity("",entity.getPrecioOriginal(),resultSet,PrecioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPrecioOriginal(this.getEntityPrecio("",entity.getPrecioOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePrecios(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPrecio(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Precio> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Precio> entities = new  ArrayList<Precio>();
		Precio entity = new Precio();		  
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
	
	public  List<Precio> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Precio> entities = new  ArrayList<Precio>();
		Precio entity = new Precio();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Precio();
				
				if(conMapGenerico) {
					entity.inicializarMapPrecio();
					//entity.setMapPrecio(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapPrecioValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPrecio().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PrecioDataAccess.ISWITHSCHEMA);         		
					entity=PrecioDataAccess.getEntityPrecio("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setPrecioOriginal( new Precio());
					////entity.setPrecioOriginal(super.getEntity("",entity.getPrecioOriginal(),resultSet,PrecioDataAccess.ISWITHSCHEMA));         		
					////entity.setPrecioOriginal(this.getEntityPrecio("",entity.getPrecioOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePrecios(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPrecio(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public Precio getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Precio entity = new Precio();		  
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
	
	public  Precio getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Precio entity = new Precio();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Precio();
				
				if(conMapGenerico) {
					entity.inicializarMapPrecio();
					//entity.setMapPrecio(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapPrecioValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPrecio().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PrecioDataAccess.ISWITHSCHEMA);         		
					entity=PrecioDataAccess.getEntityPrecio("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setPrecioOriginal( new Precio());
					////entity.setPrecioOriginal(super.getEntity("",entity.getPrecioOriginal(),resultSet,PrecioDataAccess.ISWITHSCHEMA));         		
					////entity.setPrecioOriginal(this.getEntityPrecio("",entity.getPrecioOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalsePrecio(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPrecio(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static Precio getEntityPrecio(String strPrefijo,Precio entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = Precio.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = Precio.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					PrecioDataAccess.setFieldReflectionPrecio(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasPrecio=PrecioConstantesFunciones.getTodosTiposColumnasPrecio();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasPrecio) {
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
							field = Precio.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = Precio.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						PrecioDataAccess.setFieldReflectionPrecio(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionPrecio(Field field,String strPrefijo,String sColumn,Precio entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case PrecioConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PrecioConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PrecioConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PrecioConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PrecioConstantesFunciones.IDBODEGA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PrecioConstantesFunciones.IDPRODUCTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PrecioConstantesFunciones.IDLINEA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PrecioConstantesFunciones.IDLINEAGRUPO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PrecioConstantesFunciones.IDLINEACATEGORIA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PrecioConstantesFunciones.IDLINEAMARCA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PrecioConstantesFunciones.IDRANGOUNIDADVENTA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PrecioConstantesFunciones.IDTIPOPRECIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PrecioConstantesFunciones.PRECIO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PrecioConstantesFunciones.DESCUENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PrecioConstantesFunciones.PRECIOMINIMO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PrecioConstantesFunciones.CONIMPUESTO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case PrecioConstantesFunciones.IDESTADOPRECIO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Precio>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<Precio> entities = new  ArrayList<Precio>();
		Precio entity = new Precio();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PrecioDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PrecioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PrecioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new Precio();
					entity=super.getEntity("",entity,resultSet,PrecioDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityPrecio("",entity,resultSet);
					
					//entity.setPrecioOriginal( new Precio());
					//entity.setPrecioOriginal(super.getEntity("",entity.getPrecioOriginal(),resultSet,PrecioDataAccess.ISWITHSCHEMA));         		
					//entity.setPrecioOriginal(this.getEntityPrecio("",entity.getPrecioOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalsePrecios(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPrecio(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Precio>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<Precio> entities = new  ArrayList<Precio>();
		Precio entity = new Precio();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PrecioDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PrecioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PrecioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<Precio> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Precio> entities = new  ArrayList<Precio>();
		Precio entity = new Precio();		  
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
	
	public  List<Precio> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Precio> entities = new  ArrayList<Precio>();
		Precio entity = new Precio();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Precio();
      	    	entity=super.getEntity("",entity,resultSet,PrecioDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPrecio("",entity,resultSet);
      	    	
				//entity.setPrecioOriginal( new Precio());
      	    	//entity.setPrecioOriginal(super.getEntity("",entity.getPrecioOriginal(),resultSet,PrecioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPrecioOriginal(this.getEntityPrecio("",entity.getPrecioOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalsePrecios(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPrecio(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Precio> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Precio> entities = new  ArrayList<Precio>();
		Precio entity = new Precio();		  
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
	
	public  List<Precio> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Precio> entities = new  ArrayList<Precio>();
		Precio entity = new Precio();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Precio();
      	    	entity=super.getEntity("",entity,resultSet,PrecioDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPrecio("",entity,resultSet);
      	    	
				//entity.setPrecioOriginal( new Precio());
      	    	//entity.setPrecioOriginal(super.getEntity("",entity.getPrecioOriginal(),resultSet,PrecioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPrecioOriginal(this.getEntityPrecio("",entity.getPrecioOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePrecios(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public Precio getEntityPrecio(String strPrefijo,Precio entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+PrecioConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+PrecioConstantesFunciones.IDSUCURSAL));
				entity.setid_bodega(resultSet.getLong(strPrefijo+PrecioConstantesFunciones.IDBODEGA));
				entity.setid_producto(resultSet.getLong(strPrefijo+PrecioConstantesFunciones.IDPRODUCTO));
				entity.setid_linea(resultSet.getLong(strPrefijo+PrecioConstantesFunciones.IDLINEA));if(resultSet.wasNull()) {entity.setid_linea(null); }
				entity.setid_linea_grupo(resultSet.getLong(strPrefijo+PrecioConstantesFunciones.IDLINEAGRUPO));if(resultSet.wasNull()) {entity.setid_linea_grupo(null); }
				entity.setid_linea_categoria(resultSet.getLong(strPrefijo+PrecioConstantesFunciones.IDLINEACATEGORIA));if(resultSet.wasNull()) {entity.setid_linea_categoria(null); }
				entity.setid_linea_marca(resultSet.getLong(strPrefijo+PrecioConstantesFunciones.IDLINEAMARCA));if(resultSet.wasNull()) {entity.setid_linea_marca(null); }
				entity.setid_rango_unidad_venta(resultSet.getLong(strPrefijo+PrecioConstantesFunciones.IDRANGOUNIDADVENTA));
				entity.setid_tipo_precio(resultSet.getLong(strPrefijo+PrecioConstantesFunciones.IDTIPOPRECIO));
				entity.setprecio(resultSet.getDouble(strPrefijo+PrecioConstantesFunciones.PRECIO));
				entity.setdescuento(resultSet.getDouble(strPrefijo+PrecioConstantesFunciones.DESCUENTO));
				entity.setprecio_minimo(resultSet.getDouble(strPrefijo+PrecioConstantesFunciones.PRECIOMINIMO));
				entity.setcon_impuesto(resultSet.getBoolean(strPrefijo+PrecioConstantesFunciones.CONIMPUESTO));
				entity.setid_estado_precio(resultSet.getLong(strPrefijo+PrecioConstantesFunciones.IDESTADOPRECIO));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowPrecio(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(Precio entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=PrecioDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=PrecioDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=PrecioDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=PrecioDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(PrecioConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,PrecioDataAccess.TABLENAME,PrecioDataAccess.ISWITHSTOREPROCEDURES);
			
			PrecioDataAccess.setPrecioOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,Precio relprecio)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relprecio.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,Precio relprecio)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relprecio.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Bodega getBodega(Connexion connexion,Precio relprecio)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);

			bodega=bodegaDataAccess.getEntity(connexion,relprecio.getid_bodega());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}

	public Producto getProducto(Connexion connexion,Precio relprecio)throws SQLException,Exception {

		Producto producto= new Producto();

		try {
			ProductoDataAccess productoDataAccess=new ProductoDataAccess();

			productoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			productoDataAccess.setConnexionType(this.connexionType);
			productoDataAccess.setParameterDbType(this.parameterDbType);

			producto=productoDataAccess.getEntity(connexion,relprecio.getid_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return producto;

	}

	public Linea getLinea(Connexion connexion,Precio relprecio)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);

			linea=lineaDataAccess.getEntity(connexion,relprecio.getid_linea());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaGrupo(Connexion connexion,Precio relprecio)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);

			linea=lineaDataAccess.getEntity(connexion,relprecio.getid_linea_grupo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaCategoria(Connexion connexion,Precio relprecio)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);

			linea=lineaDataAccess.getEntity(connexion,relprecio.getid_linea_categoria());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaMarca(Connexion connexion,Precio relprecio)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);

			linea=lineaDataAccess.getEntity(connexion,relprecio.getid_linea_marca());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public RangoUnidadVenta getRangoUnidadVenta(Connexion connexion,Precio relprecio)throws SQLException,Exception {

		RangoUnidadVenta rangounidadventa= new RangoUnidadVenta();

		try {
			RangoUnidadVentaDataAccess rangounidadventaDataAccess=new RangoUnidadVentaDataAccess();

			rangounidadventaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			rangounidadventaDataAccess.setConnexionType(this.connexionType);
			rangounidadventaDataAccess.setParameterDbType(this.parameterDbType);

			rangounidadventa=rangounidadventaDataAccess.getEntity(connexion,relprecio.getid_rango_unidad_venta());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return rangounidadventa;

	}

	public TipoPrecio getTipoPrecio(Connexion connexion,Precio relprecio)throws SQLException,Exception {

		TipoPrecio tipoprecio= new TipoPrecio();

		try {
			TipoPrecioDataAccess tipoprecioDataAccess=new TipoPrecioDataAccess();

			tipoprecioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoprecioDataAccess.setConnexionType(this.connexionType);
			tipoprecioDataAccess.setParameterDbType(this.parameterDbType);

			tipoprecio=tipoprecioDataAccess.getEntity(connexion,relprecio.getid_tipo_precio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoprecio;

	}

	public EstadoPrecio getEstadoPrecio(Connexion connexion,Precio relprecio)throws SQLException,Exception {

		EstadoPrecio estadoprecio= new EstadoPrecio();

		try {
			EstadoPrecioDataAccess estadoprecioDataAccess=new EstadoPrecioDataAccess();

			estadoprecioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadoprecioDataAccess.setConnexionType(this.connexionType);
			estadoprecioDataAccess.setParameterDbType(this.parameterDbType);

			estadoprecio=estadoprecioDataAccess.getEntity(connexion,relprecio.getid_estado_precio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadoprecio;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,Precio precio) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!precio.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(precio.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(precio.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_bodega=new ParameterValue<Long>();
					parameterMaintenanceValueid_bodega.setValue(precio.getid_bodega());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_bodega);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_producto=new ParameterValue<Long>();
					parameterMaintenanceValueid_producto.setValue(precio.getid_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_producto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_linea=new ParameterValue<Long>();
					parameterMaintenanceValueid_linea.setValue(precio.getid_linea());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_linea);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_linea_grupo=new ParameterValue<Long>();
					parameterMaintenanceValueid_linea_grupo.setValue(precio.getid_linea_grupo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_linea_grupo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_linea_categoria=new ParameterValue<Long>();
					parameterMaintenanceValueid_linea_categoria.setValue(precio.getid_linea_categoria());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_linea_categoria);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_linea_marca=new ParameterValue<Long>();
					parameterMaintenanceValueid_linea_marca.setValue(precio.getid_linea_marca());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_linea_marca);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_rango_unidad_venta=new ParameterValue<Long>();
					parameterMaintenanceValueid_rango_unidad_venta.setValue(precio.getid_rango_unidad_venta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_rango_unidad_venta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_precio=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_precio.setValue(precio.getid_tipo_precio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_precio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueprecio=new ParameterValue<Double>();
					parameterMaintenanceValueprecio.setValue(precio.getprecio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueprecio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedescuento=new ParameterValue<Double>();
					parameterMaintenanceValuedescuento.setValue(precio.getdescuento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescuento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueprecio_minimo=new ParameterValue<Double>();
					parameterMaintenanceValueprecio_minimo.setValue(precio.getprecio_minimo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueprecio_minimo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_impuesto=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_impuesto.setValue(precio.getcon_impuesto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_impuesto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_precio=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_precio.setValue(precio.getid_estado_precio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_precio);
					parametersTemp.add(parameterMaintenance);
					
						if(!precio.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(precio.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(precio.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(precio.getId());
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
	
	public void setIsNewIsChangedFalsePrecio(Precio precio)throws Exception  {		
		precio.setIsNew(false);
		precio.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalsePrecios(List<Precio> precios)throws Exception  {				
		for(Precio precio:precios) {
			precio.setIsNew(false);
			precio.setIsChanged(false);
		}
	}
	
	public void generarExportarPrecio(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
