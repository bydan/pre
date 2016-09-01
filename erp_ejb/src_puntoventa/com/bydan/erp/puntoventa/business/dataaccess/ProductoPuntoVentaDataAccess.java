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
package com.bydan.erp.puntoventa.business.dataaccess;

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

import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.puntoventa.util.*;//ProductoPuntoVentaConstantesFunciones;


import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.inventario.business.dataaccess.*;


import com.bydan.erp.inventario.util.*;




@SuppressWarnings("unused")
final public class ProductoPuntoVentaDataAccess extends  ProductoPuntoVentaDataAccessAdditional{ //ProductoPuntoVentaDataAccessAdditional,DataAccessHelper<ProductoPuntoVenta>
	//static Logger logger = Logger.getLogger(ProductoPuntoVentaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="producto_punto_venta";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ProductoPuntoVentaConstantesFunciones.SCHEMA+"."+ProductoPuntoVentaConstantesFunciones.TABLENAME+"(version_row,id_linea,id_linea_grupo,id_linea_categoria,id_linea_marca,id_producto,esta_activo)values(current_timestamp,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+ProductoPuntoVentaConstantesFunciones.SCHEMA+"."+ProductoPuntoVentaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_linea=?,id_linea_grupo=?,id_linea_categoria=?,id_linea_marca=?,id_producto=?,esta_activo=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ProductoPuntoVentaConstantesFunciones.SCHEMA+"."+ProductoPuntoVentaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select productopuntoventa from "+ProductoPuntoVentaConstantesFunciones.SPERSISTENCENAME+" productopuntoventa";
	public static String QUERYSELECTNATIVE="select "+ProductoPuntoVentaConstantesFunciones.SCHEMA+"."+ProductoPuntoVentaConstantesFunciones.TABLENAME+".id,"+ProductoPuntoVentaConstantesFunciones.SCHEMA+"."+ProductoPuntoVentaConstantesFunciones.TABLENAME+".version_row,"+ProductoPuntoVentaConstantesFunciones.SCHEMA+"."+ProductoPuntoVentaConstantesFunciones.TABLENAME+".id_linea,"+ProductoPuntoVentaConstantesFunciones.SCHEMA+"."+ProductoPuntoVentaConstantesFunciones.TABLENAME+".id_linea_grupo,"+ProductoPuntoVentaConstantesFunciones.SCHEMA+"."+ProductoPuntoVentaConstantesFunciones.TABLENAME+".id_linea_categoria,"+ProductoPuntoVentaConstantesFunciones.SCHEMA+"."+ProductoPuntoVentaConstantesFunciones.TABLENAME+".id_linea_marca,"+ProductoPuntoVentaConstantesFunciones.SCHEMA+"."+ProductoPuntoVentaConstantesFunciones.TABLENAME+".id_producto,"+ProductoPuntoVentaConstantesFunciones.SCHEMA+"."+ProductoPuntoVentaConstantesFunciones.TABLENAME+".esta_activo from "+ProductoPuntoVentaConstantesFunciones.SCHEMA+"."+ProductoPuntoVentaConstantesFunciones.TABLENAME;//+" as "+ProductoPuntoVentaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ProductoPuntoVentaConstantesFunciones.SCHEMA+"."+ProductoPuntoVentaConstantesFunciones.TABLENAME+".id,"+ProductoPuntoVentaConstantesFunciones.SCHEMA+"."+ProductoPuntoVentaConstantesFunciones.TABLENAME+".version_row from "+ProductoPuntoVentaConstantesFunciones.SCHEMA+"."+ProductoPuntoVentaConstantesFunciones.TABLENAME;//+" as "+ProductoPuntoVentaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ProductoPuntoVentaConstantesFunciones.SCHEMA+"."+ProductoPuntoVentaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_linea=?,id_linea_grupo=?,id_linea_categoria=?,id_linea_marca=?,id_producto=?,esta_activo=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PRODUCTOPUNTOVENTA_INSERT(?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PRODUCTOPUNTOVENTA_UPDATE(?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PRODUCTOPUNTOVENTA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PRODUCTOPUNTOVENTA_SELECT(?,?)";
	
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
	
	
	protected ProductoPuntoVentaDataAccessAdditional productopuntoventaDataAccessAdditional=null;
	
	public ProductoPuntoVentaDataAccessAdditional getProductoPuntoVentaDataAccessAdditional() {
		return this.productopuntoventaDataAccessAdditional;
	}
	
	public void setProductoPuntoVentaDataAccessAdditional(ProductoPuntoVentaDataAccessAdditional productopuntoventaDataAccessAdditional) {
		try {
			this.productopuntoventaDataAccessAdditional=productopuntoventaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ProductoPuntoVentaDataAccess() {
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
		ProductoPuntoVentaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ProductoPuntoVentaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ProductoPuntoVentaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setProductoPuntoVentaOriginal(ProductoPuntoVenta productopuntoventa)throws Exception  {
		productopuntoventa.setProductoPuntoVentaOriginal((ProductoPuntoVenta)productopuntoventa.clone());		
	}
	
	public void setProductoPuntoVentasOriginal(List<ProductoPuntoVenta> productopuntoventas)throws Exception  {
		
		for(ProductoPuntoVenta productopuntoventa:productopuntoventas){
			productopuntoventa.setProductoPuntoVentaOriginal((ProductoPuntoVenta)productopuntoventa.clone());
		}
	}
	
	public static void setProductoPuntoVentaOriginalStatic(ProductoPuntoVenta productopuntoventa)throws Exception  {
		productopuntoventa.setProductoPuntoVentaOriginal((ProductoPuntoVenta)productopuntoventa.clone());		
	}
	
	public static void setProductoPuntoVentasOriginalStatic(List<ProductoPuntoVenta> productopuntoventas)throws Exception  {
		
		for(ProductoPuntoVenta productopuntoventa:productopuntoventas){
			productopuntoventa.setProductoPuntoVentaOriginal((ProductoPuntoVenta)productopuntoventa.clone());
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
	
	public  ProductoPuntoVenta getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		ProductoPuntoVenta entity = new ProductoPuntoVenta();		
		
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
	
	public  ProductoPuntoVenta getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		ProductoPuntoVenta entity = new ProductoPuntoVenta();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ProductoPuntoVentaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ProductoPuntoVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//PuntoVenta.ProductoPuntoVenta.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setProductoPuntoVentaOriginal(new ProductoPuntoVenta());
      	    	entity=super.getEntity("",entity,resultSet,ProductoPuntoVentaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityProductoPuntoVenta("",entity,resultSet); 
				
				//entity.setProductoPuntoVentaOriginal(super.getEntity("",entity.getProductoPuntoVentaOriginal(),resultSet,ProductoPuntoVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoPuntoVentaOriginal(this.getEntityProductoPuntoVenta("",entity.getProductoPuntoVentaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseProductoPuntoVenta(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  ProductoPuntoVenta getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ProductoPuntoVenta entity = new ProductoPuntoVenta();
				
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
	
	public  ProductoPuntoVenta getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ProductoPuntoVenta entity = new ProductoPuntoVenta();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ProductoPuntoVentaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ProductoPuntoVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoPuntoVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//PuntoVenta.ProductoPuntoVenta.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setProductoPuntoVentaOriginal(new ProductoPuntoVenta());
      	    	entity=super.getEntity("",entity,resultSet,ProductoPuntoVentaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityProductoPuntoVenta("",entity,resultSet);    
				
				//entity.setProductoPuntoVentaOriginal(super.getEntity("",entity.getProductoPuntoVentaOriginal(),resultSet,ProductoPuntoVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoPuntoVentaOriginal(this.getEntityProductoPuntoVenta("",entity.getProductoPuntoVentaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseProductoPuntoVenta(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //ProductoPuntoVenta
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		ProductoPuntoVenta entity = new ProductoPuntoVenta();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ProductoPuntoVentaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ProductoPuntoVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoPuntoVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//PuntoVenta.ProductoPuntoVenta.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseProductoPuntoVenta(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<ProductoPuntoVenta> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ProductoPuntoVenta> entities = new  ArrayList<ProductoPuntoVenta>();
		ProductoPuntoVenta entity = new ProductoPuntoVenta();		  
		
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
	
	public  List<ProductoPuntoVenta> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ProductoPuntoVenta> entities = new  ArrayList<ProductoPuntoVenta>();
		ProductoPuntoVenta entity = new ProductoPuntoVenta();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ProductoPuntoVentaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ProductoPuntoVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoPuntoVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoPuntoVenta();
      	    	entity=super.getEntity("",entity,resultSet,ProductoPuntoVentaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityProductoPuntoVenta("",entity,resultSet);
      	    	
				//entity.setProductoPuntoVentaOriginal( new ProductoPuntoVenta());
      	    	//entity.setProductoPuntoVentaOriginal(super.getEntity("",entity.getProductoPuntoVentaOriginal(),resultSet,ProductoPuntoVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoPuntoVentaOriginal(this.getEntityProductoPuntoVenta("",entity.getProductoPuntoVentaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseProductoPuntoVentas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoPuntoVenta(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ProductoPuntoVenta> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProductoPuntoVenta> entities = new  ArrayList<ProductoPuntoVenta>();
		ProductoPuntoVenta entity = new ProductoPuntoVenta();		  
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
	
	public  List<ProductoPuntoVenta> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProductoPuntoVenta> entities = new  ArrayList<ProductoPuntoVenta>();
		ProductoPuntoVenta entity = new ProductoPuntoVenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoPuntoVenta();
				
				if(conMapGenerico) {
					entity.inicializarMapProductoPuntoVenta();
					//entity.setMapProductoPuntoVenta(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapProductoPuntoVentaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapProductoPuntoVenta().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProductoPuntoVentaDataAccess.ISWITHSCHEMA);         		
					entity=ProductoPuntoVentaDataAccess.getEntityProductoPuntoVenta("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setProductoPuntoVentaOriginal( new ProductoPuntoVenta());
					////entity.setProductoPuntoVentaOriginal(super.getEntity("",entity.getProductoPuntoVentaOriginal(),resultSet,ProductoPuntoVentaDataAccess.ISWITHSCHEMA));         		
					////entity.setProductoPuntoVentaOriginal(this.getEntityProductoPuntoVenta("",entity.getProductoPuntoVentaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseProductoPuntoVentas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoPuntoVenta(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public ProductoPuntoVenta getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ProductoPuntoVenta entity = new ProductoPuntoVenta();		  
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
	
	public  ProductoPuntoVenta getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ProductoPuntoVenta entity = new ProductoPuntoVenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoPuntoVenta();
				
				if(conMapGenerico) {
					entity.inicializarMapProductoPuntoVenta();
					//entity.setMapProductoPuntoVenta(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapProductoPuntoVentaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapProductoPuntoVenta().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProductoPuntoVentaDataAccess.ISWITHSCHEMA);         		
					entity=ProductoPuntoVentaDataAccess.getEntityProductoPuntoVenta("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setProductoPuntoVentaOriginal( new ProductoPuntoVenta());
					////entity.setProductoPuntoVentaOriginal(super.getEntity("",entity.getProductoPuntoVentaOriginal(),resultSet,ProductoPuntoVentaDataAccess.ISWITHSCHEMA));         		
					////entity.setProductoPuntoVentaOriginal(this.getEntityProductoPuntoVenta("",entity.getProductoPuntoVentaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseProductoPuntoVenta(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoPuntoVenta(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ProductoPuntoVenta getEntityProductoPuntoVenta(String strPrefijo,ProductoPuntoVenta entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = ProductoPuntoVenta.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = ProductoPuntoVenta.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ProductoPuntoVentaDataAccess.setFieldReflectionProductoPuntoVenta(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasProductoPuntoVenta=ProductoPuntoVentaConstantesFunciones.getTodosTiposColumnasProductoPuntoVenta();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasProductoPuntoVenta) {
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
							field = ProductoPuntoVenta.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = ProductoPuntoVenta.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ProductoPuntoVentaDataAccess.setFieldReflectionProductoPuntoVenta(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionProductoPuntoVenta(Field field,String strPrefijo,String sColumn,ProductoPuntoVenta entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ProductoPuntoVentaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoPuntoVentaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProductoPuntoVentaConstantesFunciones.IDLINEA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoPuntoVentaConstantesFunciones.IDLINEAGRUPO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoPuntoVentaConstantesFunciones.IDLINEACATEGORIA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoPuntoVentaConstantesFunciones.IDLINEAMARCA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoPuntoVentaConstantesFunciones.IDPRODUCTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoPuntoVentaConstantesFunciones.ESTAACTIVO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ProductoPuntoVenta>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<ProductoPuntoVenta> entities = new  ArrayList<ProductoPuntoVenta>();
		ProductoPuntoVenta entity = new ProductoPuntoVenta();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ProductoPuntoVentaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ProductoPuntoVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoPuntoVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new ProductoPuntoVenta();
					entity=super.getEntity("",entity,resultSet,ProductoPuntoVentaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityProductoPuntoVenta("",entity,resultSet);
					
					//entity.setProductoPuntoVentaOriginal( new ProductoPuntoVenta());
					//entity.setProductoPuntoVentaOriginal(super.getEntity("",entity.getProductoPuntoVentaOriginal(),resultSet,ProductoPuntoVentaDataAccess.ISWITHSCHEMA));         		
					//entity.setProductoPuntoVentaOriginal(this.getEntityProductoPuntoVenta("",entity.getProductoPuntoVentaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseProductoPuntoVentas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoPuntoVenta(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ProductoPuntoVenta>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<ProductoPuntoVenta> entities = new  ArrayList<ProductoPuntoVenta>();
		ProductoPuntoVenta entity = new ProductoPuntoVenta();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ProductoPuntoVentaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ProductoPuntoVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoPuntoVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<ProductoPuntoVenta> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductoPuntoVenta> entities = new  ArrayList<ProductoPuntoVenta>();
		ProductoPuntoVenta entity = new ProductoPuntoVenta();		  
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
	
	public  List<ProductoPuntoVenta> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductoPuntoVenta> entities = new  ArrayList<ProductoPuntoVenta>();
		ProductoPuntoVenta entity = new ProductoPuntoVenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoPuntoVenta();
      	    	entity=super.getEntity("",entity,resultSet,ProductoPuntoVentaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityProductoPuntoVenta("",entity,resultSet);
      	    	
				//entity.setProductoPuntoVentaOriginal( new ProductoPuntoVenta());
      	    	//entity.setProductoPuntoVentaOriginal(super.getEntity("",entity.getProductoPuntoVentaOriginal(),resultSet,ProductoPuntoVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoPuntoVentaOriginal(this.getEntityProductoPuntoVenta("",entity.getProductoPuntoVentaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseProductoPuntoVentas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoPuntoVenta(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ProductoPuntoVenta> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductoPuntoVenta> entities = new  ArrayList<ProductoPuntoVenta>();
		ProductoPuntoVenta entity = new ProductoPuntoVenta();		  
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
	
	public  List<ProductoPuntoVenta> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductoPuntoVenta> entities = new  ArrayList<ProductoPuntoVenta>();
		ProductoPuntoVenta entity = new ProductoPuntoVenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoPuntoVenta();
      	    	entity=super.getEntity("",entity,resultSet,ProductoPuntoVentaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityProductoPuntoVenta("",entity,resultSet);
      	    	
				//entity.setProductoPuntoVentaOriginal( new ProductoPuntoVenta());
      	    	//entity.setProductoPuntoVentaOriginal(super.getEntity("",entity.getProductoPuntoVentaOriginal(),resultSet,ProductoPuntoVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoPuntoVentaOriginal(this.getEntityProductoPuntoVenta("",entity.getProductoPuntoVentaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseProductoPuntoVentas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public ProductoPuntoVenta getEntityProductoPuntoVenta(String strPrefijo,ProductoPuntoVenta entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_linea(resultSet.getLong(strPrefijo+ProductoPuntoVentaConstantesFunciones.IDLINEA));
				entity.setid_linea_grupo(resultSet.getLong(strPrefijo+ProductoPuntoVentaConstantesFunciones.IDLINEAGRUPO));if(resultSet.wasNull()) {entity.setid_linea_grupo(null); }
				entity.setid_linea_categoria(resultSet.getLong(strPrefijo+ProductoPuntoVentaConstantesFunciones.IDLINEACATEGORIA));if(resultSet.wasNull()) {entity.setid_linea_categoria(null); }
				entity.setid_linea_marca(resultSet.getLong(strPrefijo+ProductoPuntoVentaConstantesFunciones.IDLINEAMARCA));if(resultSet.wasNull()) {entity.setid_linea_marca(null); }
				entity.setid_producto(resultSet.getLong(strPrefijo+ProductoPuntoVentaConstantesFunciones.IDPRODUCTO));
				entity.setesta_activo(resultSet.getBoolean(strPrefijo+ProductoPuntoVentaConstantesFunciones.ESTAACTIVO));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowProductoPuntoVenta(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(ProductoPuntoVenta entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ProductoPuntoVentaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ProductoPuntoVentaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ProductoPuntoVentaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ProductoPuntoVentaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ProductoPuntoVentaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ProductoPuntoVentaDataAccess.TABLENAME,ProductoPuntoVentaDataAccess.ISWITHSTOREPROCEDURES);
			
			ProductoPuntoVentaDataAccess.setProductoPuntoVentaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Linea getLinea(Connexion connexion,ProductoPuntoVenta relproductopuntoventa)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);

			linea=lineaDataAccess.getEntity(connexion,relproductopuntoventa.getid_linea());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaGrupo(Connexion connexion,ProductoPuntoVenta relproductopuntoventa)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);

			linea=lineaDataAccess.getEntity(connexion,relproductopuntoventa.getid_linea_grupo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaCategoria(Connexion connexion,ProductoPuntoVenta relproductopuntoventa)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);

			linea=lineaDataAccess.getEntity(connexion,relproductopuntoventa.getid_linea_categoria());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaMarca(Connexion connexion,ProductoPuntoVenta relproductopuntoventa)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);

			linea=lineaDataAccess.getEntity(connexion,relproductopuntoventa.getid_linea_marca());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Producto getProducto(Connexion connexion,ProductoPuntoVenta relproductopuntoventa)throws SQLException,Exception {

		Producto producto= new Producto();

		try {
			ProductoDataAccess productoDataAccess=new ProductoDataAccess();

			productoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			productoDataAccess.setConnexionType(this.connexionType);
			productoDataAccess.setParameterDbType(this.parameterDbType);

			producto=productoDataAccess.getEntity(connexion,relproductopuntoventa.getid_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return producto;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,ProductoPuntoVenta productopuntoventa) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!productopuntoventa.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_linea=new ParameterValue<Long>();
					parameterMaintenanceValueid_linea.setValue(productopuntoventa.getid_linea());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_linea);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_linea_grupo=new ParameterValue<Long>();
					parameterMaintenanceValueid_linea_grupo.setValue(productopuntoventa.getid_linea_grupo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_linea_grupo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_linea_categoria=new ParameterValue<Long>();
					parameterMaintenanceValueid_linea_categoria.setValue(productopuntoventa.getid_linea_categoria());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_linea_categoria);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_linea_marca=new ParameterValue<Long>();
					parameterMaintenanceValueid_linea_marca.setValue(productopuntoventa.getid_linea_marca());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_linea_marca);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_producto=new ParameterValue<Long>();
					parameterMaintenanceValueid_producto.setValue(productopuntoventa.getid_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_producto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValueesta_activo=new ParameterValue<Boolean>();
					parameterMaintenanceValueesta_activo.setValue(productopuntoventa.getesta_activo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueesta_activo);
					parametersTemp.add(parameterMaintenance);
					
						if(!productopuntoventa.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(productopuntoventa.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(productopuntoventa.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(productopuntoventa.getId());
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
	
	public void setIsNewIsChangedFalseProductoPuntoVenta(ProductoPuntoVenta productopuntoventa)throws Exception  {		
		productopuntoventa.setIsNew(false);
		productopuntoventa.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseProductoPuntoVentas(List<ProductoPuntoVenta> productopuntoventas)throws Exception  {				
		for(ProductoPuntoVenta productopuntoventa:productopuntoventas) {
			productopuntoventa.setIsNew(false);
			productopuntoventa.setIsChanged(false);
		}
	}
	
	public void generarExportarProductoPuntoVenta(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
