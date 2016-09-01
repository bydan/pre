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
package com.bydan.erp.produccion.business.dataaccess;

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

import com.bydan.erp.produccion.business.entity.*;
import com.bydan.erp.produccion.util.*;//ProductoProduManoConstantesFunciones;


import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.inventario.business.dataaccess.*;


import com.bydan.erp.inventario.util.*;




@SuppressWarnings("unused")
final public class ProductoProduManoDataAccess extends  ProductoProduManoDataAccessAdditional{ //ProductoProduManoDataAccessAdditional,DataAccessHelper<ProductoProduMano>
	//static Logger logger = Logger.getLogger(ProductoProduManoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="producto_produ_mano";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ProductoProduManoConstantesFunciones.SCHEMA+"."+ProductoProduManoConstantesFunciones.TABLENAME+"(version_row,id_producto_defi_produ,id_tipo_mano_produ_empresa,id_tipo_proceso_empresa_produ,id_unidad,cantidad,costo,costo_total,descripcion)values(current_timestamp,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+ProductoProduManoConstantesFunciones.SCHEMA+"."+ProductoProduManoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_producto_defi_produ=?,id_tipo_mano_produ_empresa=?,id_tipo_proceso_empresa_produ=?,id_unidad=?,cantidad=?,costo=?,costo_total=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ProductoProduManoConstantesFunciones.SCHEMA+"."+ProductoProduManoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select productoprodumano from "+ProductoProduManoConstantesFunciones.SPERSISTENCENAME+" productoprodumano";
	public static String QUERYSELECTNATIVE="select "+ProductoProduManoConstantesFunciones.SCHEMA+"."+ProductoProduManoConstantesFunciones.TABLENAME+".id,"+ProductoProduManoConstantesFunciones.SCHEMA+"."+ProductoProduManoConstantesFunciones.TABLENAME+".version_row,"+ProductoProduManoConstantesFunciones.SCHEMA+"."+ProductoProduManoConstantesFunciones.TABLENAME+".id_producto_defi_produ,"+ProductoProduManoConstantesFunciones.SCHEMA+"."+ProductoProduManoConstantesFunciones.TABLENAME+".id_tipo_mano_produ_empresa,"+ProductoProduManoConstantesFunciones.SCHEMA+"."+ProductoProduManoConstantesFunciones.TABLENAME+".id_tipo_proceso_empresa_produ,"+ProductoProduManoConstantesFunciones.SCHEMA+"."+ProductoProduManoConstantesFunciones.TABLENAME+".id_unidad,"+ProductoProduManoConstantesFunciones.SCHEMA+"."+ProductoProduManoConstantesFunciones.TABLENAME+".cantidad,"+ProductoProduManoConstantesFunciones.SCHEMA+"."+ProductoProduManoConstantesFunciones.TABLENAME+".costo,"+ProductoProduManoConstantesFunciones.SCHEMA+"."+ProductoProduManoConstantesFunciones.TABLENAME+".costo_total,"+ProductoProduManoConstantesFunciones.SCHEMA+"."+ProductoProduManoConstantesFunciones.TABLENAME+".descripcion from "+ProductoProduManoConstantesFunciones.SCHEMA+"."+ProductoProduManoConstantesFunciones.TABLENAME;//+" as "+ProductoProduManoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ProductoProduManoConstantesFunciones.SCHEMA+"."+ProductoProduManoConstantesFunciones.TABLENAME+".id,"+ProductoProduManoConstantesFunciones.SCHEMA+"."+ProductoProduManoConstantesFunciones.TABLENAME+".version_row from "+ProductoProduManoConstantesFunciones.SCHEMA+"."+ProductoProduManoConstantesFunciones.TABLENAME;//+" as "+ProductoProduManoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ProductoProduManoConstantesFunciones.SCHEMA+"."+ProductoProduManoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_producto_defi_produ=?,id_tipo_mano_produ_empresa=?,id_tipo_proceso_empresa_produ=?,id_unidad=?,cantidad=?,costo=?,costo_total=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PRODUCTOPRODUMANO_INSERT(?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PRODUCTOPRODUMANO_UPDATE(?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PRODUCTOPRODUMANO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PRODUCTOPRODUMANO_SELECT(?,?)";
	
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
	
	
	protected ProductoProduManoDataAccessAdditional productoprodumanoDataAccessAdditional=null;
	
	public ProductoProduManoDataAccessAdditional getProductoProduManoDataAccessAdditional() {
		return this.productoprodumanoDataAccessAdditional;
	}
	
	public void setProductoProduManoDataAccessAdditional(ProductoProduManoDataAccessAdditional productoprodumanoDataAccessAdditional) {
		try {
			this.productoprodumanoDataAccessAdditional=productoprodumanoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ProductoProduManoDataAccess() {
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
		ProductoProduManoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ProductoProduManoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ProductoProduManoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setProductoProduManoOriginal(ProductoProduMano productoprodumano)throws Exception  {
		productoprodumano.setProductoProduManoOriginal((ProductoProduMano)productoprodumano.clone());		
	}
	
	public void setProductoProduManosOriginal(List<ProductoProduMano> productoprodumanos)throws Exception  {
		
		for(ProductoProduMano productoprodumano:productoprodumanos){
			productoprodumano.setProductoProduManoOriginal((ProductoProduMano)productoprodumano.clone());
		}
	}
	
	public static void setProductoProduManoOriginalStatic(ProductoProduMano productoprodumano)throws Exception  {
		productoprodumano.setProductoProduManoOriginal((ProductoProduMano)productoprodumano.clone());		
	}
	
	public static void setProductoProduManosOriginalStatic(List<ProductoProduMano> productoprodumanos)throws Exception  {
		
		for(ProductoProduMano productoprodumano:productoprodumanos){
			productoprodumano.setProductoProduManoOriginal((ProductoProduMano)productoprodumano.clone());
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
	
	public  ProductoProduMano getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		ProductoProduMano entity = new ProductoProduMano();		
		
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
	
	public  ProductoProduMano getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		ProductoProduMano entity = new ProductoProduMano();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ProductoProduManoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ProductoProduManoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Produccion.ProductoProduMano.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setProductoProduManoOriginal(new ProductoProduMano());
      	    	entity=super.getEntity("",entity,resultSet,ProductoProduManoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityProductoProduMano("",entity,resultSet); 
				
				//entity.setProductoProduManoOriginal(super.getEntity("",entity.getProductoProduManoOriginal(),resultSet,ProductoProduManoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoProduManoOriginal(this.getEntityProductoProduMano("",entity.getProductoProduManoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseProductoProduMano(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  ProductoProduMano getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ProductoProduMano entity = new ProductoProduMano();
				
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
	
	public  ProductoProduMano getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ProductoProduMano entity = new ProductoProduMano();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ProductoProduManoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ProductoProduManoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoProduManoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Produccion.ProductoProduMano.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setProductoProduManoOriginal(new ProductoProduMano());
      	    	entity=super.getEntity("",entity,resultSet,ProductoProduManoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityProductoProduMano("",entity,resultSet);    
				
				//entity.setProductoProduManoOriginal(super.getEntity("",entity.getProductoProduManoOriginal(),resultSet,ProductoProduManoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoProduManoOriginal(this.getEntityProductoProduMano("",entity.getProductoProduManoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseProductoProduMano(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //ProductoProduMano
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		ProductoProduMano entity = new ProductoProduMano();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ProductoProduManoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ProductoProduManoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoProduManoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Produccion.ProductoProduMano.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseProductoProduMano(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<ProductoProduMano> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ProductoProduMano> entities = new  ArrayList<ProductoProduMano>();
		ProductoProduMano entity = new ProductoProduMano();		  
		
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
	
	public  List<ProductoProduMano> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ProductoProduMano> entities = new  ArrayList<ProductoProduMano>();
		ProductoProduMano entity = new ProductoProduMano();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ProductoProduManoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ProductoProduManoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoProduManoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoProduMano();
      	    	entity=super.getEntity("",entity,resultSet,ProductoProduManoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityProductoProduMano("",entity,resultSet);
      	    	
				//entity.setProductoProduManoOriginal( new ProductoProduMano());
      	    	//entity.setProductoProduManoOriginal(super.getEntity("",entity.getProductoProduManoOriginal(),resultSet,ProductoProduManoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoProduManoOriginal(this.getEntityProductoProduMano("",entity.getProductoProduManoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseProductoProduManos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoProduMano(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ProductoProduMano> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProductoProduMano> entities = new  ArrayList<ProductoProduMano>();
		ProductoProduMano entity = new ProductoProduMano();		  
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
	
	public  List<ProductoProduMano> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProductoProduMano> entities = new  ArrayList<ProductoProduMano>();
		ProductoProduMano entity = new ProductoProduMano();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoProduMano();
				
				if(conMapGenerico) {
					entity.inicializarMapProductoProduMano();
					//entity.setMapProductoProduMano(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapProductoProduManoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapProductoProduMano().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProductoProduManoDataAccess.ISWITHSCHEMA);         		
					entity=ProductoProduManoDataAccess.getEntityProductoProduMano("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setProductoProduManoOriginal( new ProductoProduMano());
					////entity.setProductoProduManoOriginal(super.getEntity("",entity.getProductoProduManoOriginal(),resultSet,ProductoProduManoDataAccess.ISWITHSCHEMA));         		
					////entity.setProductoProduManoOriginal(this.getEntityProductoProduMano("",entity.getProductoProduManoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseProductoProduManos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoProduMano(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public ProductoProduMano getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ProductoProduMano entity = new ProductoProduMano();		  
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
	
	public  ProductoProduMano getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ProductoProduMano entity = new ProductoProduMano();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoProduMano();
				
				if(conMapGenerico) {
					entity.inicializarMapProductoProduMano();
					//entity.setMapProductoProduMano(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapProductoProduManoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapProductoProduMano().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProductoProduManoDataAccess.ISWITHSCHEMA);         		
					entity=ProductoProduManoDataAccess.getEntityProductoProduMano("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setProductoProduManoOriginal( new ProductoProduMano());
					////entity.setProductoProduManoOriginal(super.getEntity("",entity.getProductoProduManoOriginal(),resultSet,ProductoProduManoDataAccess.ISWITHSCHEMA));         		
					////entity.setProductoProduManoOriginal(this.getEntityProductoProduMano("",entity.getProductoProduManoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseProductoProduMano(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoProduMano(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ProductoProduMano getEntityProductoProduMano(String strPrefijo,ProductoProduMano entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = ProductoProduMano.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = ProductoProduMano.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ProductoProduManoDataAccess.setFieldReflectionProductoProduMano(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasProductoProduMano=ProductoProduManoConstantesFunciones.getTodosTiposColumnasProductoProduMano();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasProductoProduMano) {
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
							field = ProductoProduMano.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = ProductoProduMano.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ProductoProduManoDataAccess.setFieldReflectionProductoProduMano(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionProductoProduMano(Field field,String strPrefijo,String sColumn,ProductoProduMano entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ProductoProduManoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoProduManoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProductoProduManoConstantesFunciones.IDPRODUCTODEFIPRODU:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoProduManoConstantesFunciones.IDTIPOMANOPRODUEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoProduManoConstantesFunciones.IDTIPOPROCESOEMPRESAPRODU:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoProduManoConstantesFunciones.IDUNIDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoProduManoConstantesFunciones.CANTIDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoProduManoConstantesFunciones.COSTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductoProduManoConstantesFunciones.COSTOTOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductoProduManoConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ProductoProduMano>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<ProductoProduMano> entities = new  ArrayList<ProductoProduMano>();
		ProductoProduMano entity = new ProductoProduMano();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ProductoProduManoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ProductoProduManoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoProduManoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new ProductoProduMano();
					entity=super.getEntity("",entity,resultSet,ProductoProduManoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityProductoProduMano("",entity,resultSet);
					
					//entity.setProductoProduManoOriginal( new ProductoProduMano());
					//entity.setProductoProduManoOriginal(super.getEntity("",entity.getProductoProduManoOriginal(),resultSet,ProductoProduManoDataAccess.ISWITHSCHEMA));         		
					//entity.setProductoProduManoOriginal(this.getEntityProductoProduMano("",entity.getProductoProduManoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseProductoProduManos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoProduMano(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ProductoProduMano>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<ProductoProduMano> entities = new  ArrayList<ProductoProduMano>();
		ProductoProduMano entity = new ProductoProduMano();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ProductoProduManoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ProductoProduManoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoProduManoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<ProductoProduMano> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductoProduMano> entities = new  ArrayList<ProductoProduMano>();
		ProductoProduMano entity = new ProductoProduMano();		  
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
	
	public  List<ProductoProduMano> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductoProduMano> entities = new  ArrayList<ProductoProduMano>();
		ProductoProduMano entity = new ProductoProduMano();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoProduMano();
      	    	entity=super.getEntity("",entity,resultSet,ProductoProduManoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityProductoProduMano("",entity,resultSet);
      	    	
				//entity.setProductoProduManoOriginal( new ProductoProduMano());
      	    	//entity.setProductoProduManoOriginal(super.getEntity("",entity.getProductoProduManoOriginal(),resultSet,ProductoProduManoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoProduManoOriginal(this.getEntityProductoProduMano("",entity.getProductoProduManoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseProductoProduManos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoProduMano(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ProductoProduMano> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductoProduMano> entities = new  ArrayList<ProductoProduMano>();
		ProductoProduMano entity = new ProductoProduMano();		  
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
	
	public  List<ProductoProduMano> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductoProduMano> entities = new  ArrayList<ProductoProduMano>();
		ProductoProduMano entity = new ProductoProduMano();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoProduMano();
      	    	entity=super.getEntity("",entity,resultSet,ProductoProduManoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityProductoProduMano("",entity,resultSet);
      	    	
				//entity.setProductoProduManoOriginal( new ProductoProduMano());
      	    	//entity.setProductoProduManoOriginal(super.getEntity("",entity.getProductoProduManoOriginal(),resultSet,ProductoProduManoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoProduManoOriginal(this.getEntityProductoProduMano("",entity.getProductoProduManoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseProductoProduManos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public ProductoProduMano getEntityProductoProduMano(String strPrefijo,ProductoProduMano entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_producto_defi_produ(resultSet.getLong(strPrefijo+ProductoProduManoConstantesFunciones.IDPRODUCTODEFIPRODU));
				entity.setid_tipo_mano_produ_empresa(resultSet.getLong(strPrefijo+ProductoProduManoConstantesFunciones.IDTIPOMANOPRODUEMPRESA));
				entity.setid_tipo_proceso_empresa_produ(resultSet.getLong(strPrefijo+ProductoProduManoConstantesFunciones.IDTIPOPROCESOEMPRESAPRODU));
				entity.setid_unidad(resultSet.getLong(strPrefijo+ProductoProduManoConstantesFunciones.IDUNIDAD));
				entity.setcantidad(resultSet.getLong(strPrefijo+ProductoProduManoConstantesFunciones.CANTIDAD));
				entity.setcosto(resultSet.getDouble(strPrefijo+ProductoProduManoConstantesFunciones.COSTO));
				entity.setcosto_total(resultSet.getDouble(strPrefijo+ProductoProduManoConstantesFunciones.COSTOTOTAL));
				entity.setdescripcion(resultSet.getString(strPrefijo+ProductoProduManoConstantesFunciones.DESCRIPCION));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowProductoProduMano(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(ProductoProduMano entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ProductoProduManoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ProductoProduManoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ProductoProduManoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ProductoProduManoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ProductoProduManoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ProductoProduManoDataAccess.TABLENAME,ProductoProduManoDataAccess.ISWITHSTOREPROCEDURES);
			
			ProductoProduManoDataAccess.setProductoProduManoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public ProductoDefiProdu getProductoDefiProdu(Connexion connexion,ProductoProduMano relproductoprodumano)throws SQLException,Exception {

		ProductoDefiProdu productodefiprodu= new ProductoDefiProdu();

		try {
			ProductoDefiProduDataAccess productodefiproduDataAccess=new ProductoDefiProduDataAccess();

			productodefiproduDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			productodefiproduDataAccess.setConnexionType(this.connexionType);
			productodefiproduDataAccess.setParameterDbType(this.parameterDbType);

			productodefiprodu=productodefiproduDataAccess.getEntity(connexion,relproductoprodumano.getid_producto_defi_produ());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return productodefiprodu;

	}

	public TipoManoProduEmpresa getTipoManoProduEmpresa(Connexion connexion,ProductoProduMano relproductoprodumano)throws SQLException,Exception {

		TipoManoProduEmpresa tipomanoproduempresa= new TipoManoProduEmpresa();

		try {
			TipoManoProduEmpresaDataAccess tipomanoproduempresaDataAccess=new TipoManoProduEmpresaDataAccess();

			tipomanoproduempresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipomanoproduempresaDataAccess.setConnexionType(this.connexionType);
			tipomanoproduempresaDataAccess.setParameterDbType(this.parameterDbType);

			tipomanoproduempresa=tipomanoproduempresaDataAccess.getEntity(connexion,relproductoprodumano.getid_tipo_mano_produ_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipomanoproduempresa;

	}

	public TipoProcesoEmpresaProdu getTipoProcesoEmpresaProdu(Connexion connexion,ProductoProduMano relproductoprodumano)throws SQLException,Exception {

		TipoProcesoEmpresaProdu tipoprocesoempresaprodu= new TipoProcesoEmpresaProdu();

		try {
			TipoProcesoEmpresaProduDataAccess tipoprocesoempresaproduDataAccess=new TipoProcesoEmpresaProduDataAccess();

			tipoprocesoempresaproduDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoprocesoempresaproduDataAccess.setConnexionType(this.connexionType);
			tipoprocesoempresaproduDataAccess.setParameterDbType(this.parameterDbType);

			tipoprocesoempresaprodu=tipoprocesoempresaproduDataAccess.getEntity(connexion,relproductoprodumano.getid_tipo_proceso_empresa_produ());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoprocesoempresaprodu;

	}

	public Unidad getUnidad(Connexion connexion,ProductoProduMano relproductoprodumano)throws SQLException,Exception {

		Unidad unidad= new Unidad();

		try {
			UnidadDataAccess unidadDataAccess=new UnidadDataAccess();

			unidadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			unidadDataAccess.setConnexionType(this.connexionType);
			unidadDataAccess.setParameterDbType(this.parameterDbType);

			unidad=unidadDataAccess.getEntity(connexion,relproductoprodumano.getid_unidad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return unidad;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,ProductoProduMano productoprodumano) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!productoprodumano.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_producto_defi_produ=new ParameterValue<Long>();
					parameterMaintenanceValueid_producto_defi_produ.setValue(productoprodumano.getid_producto_defi_produ());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_producto_defi_produ);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_mano_produ_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_mano_produ_empresa.setValue(productoprodumano.getid_tipo_mano_produ_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_mano_produ_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_proceso_empresa_produ=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_proceso_empresa_produ.setValue(productoprodumano.getid_tipo_proceso_empresa_produ());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_proceso_empresa_produ);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_unidad=new ParameterValue<Long>();
					parameterMaintenanceValueid_unidad.setValue(productoprodumano.getid_unidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_unidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValuecantidad=new ParameterValue<Long>();
					parameterMaintenanceValuecantidad.setValue(productoprodumano.getcantidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecantidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecosto=new ParameterValue<Double>();
					parameterMaintenanceValuecosto.setValue(productoprodumano.getcosto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecosto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecosto_total=new ParameterValue<Double>();
					parameterMaintenanceValuecosto_total.setValue(productoprodumano.getcosto_total());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecosto_total);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(productoprodumano.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!productoprodumano.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(productoprodumano.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(productoprodumano.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(productoprodumano.getId());
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
	
	public void setIsNewIsChangedFalseProductoProduMano(ProductoProduMano productoprodumano)throws Exception  {		
		productoprodumano.setIsNew(false);
		productoprodumano.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseProductoProduManos(List<ProductoProduMano> productoprodumanos)throws Exception  {				
		for(ProductoProduMano productoprodumano:productoprodumanos) {
			productoprodumano.setIsNew(false);
			productoprodumano.setIsChanged(false);
		}
	}
	
	public void generarExportarProductoProduMano(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
