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
import com.bydan.erp.produccion.util.*;//ProductoProduMermaConstantesFunciones;


import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.inventario.business.dataaccess.*;


import com.bydan.erp.inventario.util.*;




@SuppressWarnings("unused")
final public class ProductoProduMermaDataAccess extends  ProductoProduMermaDataAccessAdditional{ //ProductoProduMermaDataAccessAdditional,DataAccessHelper<ProductoProduMerma>
	//static Logger logger = Logger.getLogger(ProductoProduMermaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="producto_produ_merma";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ProductoProduMermaConstantesFunciones.SCHEMA+"."+ProductoProduMermaConstantesFunciones.TABLENAME+"(version_row,id_producto_defi_produ,id_tipo_merma_empresa,id_unidad,cantidad,costo,costo_total,descripcion)values(current_timestamp,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+ProductoProduMermaConstantesFunciones.SCHEMA+"."+ProductoProduMermaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_producto_defi_produ=?,id_tipo_merma_empresa=?,id_unidad=?,cantidad=?,costo=?,costo_total=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ProductoProduMermaConstantesFunciones.SCHEMA+"."+ProductoProduMermaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select productoprodumerma from "+ProductoProduMermaConstantesFunciones.SPERSISTENCENAME+" productoprodumerma";
	public static String QUERYSELECTNATIVE="select "+ProductoProduMermaConstantesFunciones.SCHEMA+"."+ProductoProduMermaConstantesFunciones.TABLENAME+".id,"+ProductoProduMermaConstantesFunciones.SCHEMA+"."+ProductoProduMermaConstantesFunciones.TABLENAME+".version_row,"+ProductoProduMermaConstantesFunciones.SCHEMA+"."+ProductoProduMermaConstantesFunciones.TABLENAME+".id_producto_defi_produ,"+ProductoProduMermaConstantesFunciones.SCHEMA+"."+ProductoProduMermaConstantesFunciones.TABLENAME+".id_tipo_merma_empresa,"+ProductoProduMermaConstantesFunciones.SCHEMA+"."+ProductoProduMermaConstantesFunciones.TABLENAME+".id_unidad,"+ProductoProduMermaConstantesFunciones.SCHEMA+"."+ProductoProduMermaConstantesFunciones.TABLENAME+".cantidad,"+ProductoProduMermaConstantesFunciones.SCHEMA+"."+ProductoProduMermaConstantesFunciones.TABLENAME+".costo,"+ProductoProduMermaConstantesFunciones.SCHEMA+"."+ProductoProduMermaConstantesFunciones.TABLENAME+".costo_total,"+ProductoProduMermaConstantesFunciones.SCHEMA+"."+ProductoProduMermaConstantesFunciones.TABLENAME+".descripcion from "+ProductoProduMermaConstantesFunciones.SCHEMA+"."+ProductoProduMermaConstantesFunciones.TABLENAME;//+" as "+ProductoProduMermaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ProductoProduMermaConstantesFunciones.SCHEMA+"."+ProductoProduMermaConstantesFunciones.TABLENAME+".id,"+ProductoProduMermaConstantesFunciones.SCHEMA+"."+ProductoProduMermaConstantesFunciones.TABLENAME+".version_row from "+ProductoProduMermaConstantesFunciones.SCHEMA+"."+ProductoProduMermaConstantesFunciones.TABLENAME;//+" as "+ProductoProduMermaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ProductoProduMermaConstantesFunciones.SCHEMA+"."+ProductoProduMermaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_producto_defi_produ=?,id_tipo_merma_empresa=?,id_unidad=?,cantidad=?,costo=?,costo_total=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PRODUCTOPRODUMERMA_INSERT(?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PRODUCTOPRODUMERMA_UPDATE(?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PRODUCTOPRODUMERMA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PRODUCTOPRODUMERMA_SELECT(?,?)";
	
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
	
	
	protected ProductoProduMermaDataAccessAdditional productoprodumermaDataAccessAdditional=null;
	
	public ProductoProduMermaDataAccessAdditional getProductoProduMermaDataAccessAdditional() {
		return this.productoprodumermaDataAccessAdditional;
	}
	
	public void setProductoProduMermaDataAccessAdditional(ProductoProduMermaDataAccessAdditional productoprodumermaDataAccessAdditional) {
		try {
			this.productoprodumermaDataAccessAdditional=productoprodumermaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ProductoProduMermaDataAccess() {
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
		ProductoProduMermaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ProductoProduMermaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ProductoProduMermaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setProductoProduMermaOriginal(ProductoProduMerma productoprodumerma)throws Exception  {
		productoprodumerma.setProductoProduMermaOriginal((ProductoProduMerma)productoprodumerma.clone());		
	}
	
	public void setProductoProduMermasOriginal(List<ProductoProduMerma> productoprodumermas)throws Exception  {
		
		for(ProductoProduMerma productoprodumerma:productoprodumermas){
			productoprodumerma.setProductoProduMermaOriginal((ProductoProduMerma)productoprodumerma.clone());
		}
	}
	
	public static void setProductoProduMermaOriginalStatic(ProductoProduMerma productoprodumerma)throws Exception  {
		productoprodumerma.setProductoProduMermaOriginal((ProductoProduMerma)productoprodumerma.clone());		
	}
	
	public static void setProductoProduMermasOriginalStatic(List<ProductoProduMerma> productoprodumermas)throws Exception  {
		
		for(ProductoProduMerma productoprodumerma:productoprodumermas){
			productoprodumerma.setProductoProduMermaOriginal((ProductoProduMerma)productoprodumerma.clone());
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
	
	public  ProductoProduMerma getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		ProductoProduMerma entity = new ProductoProduMerma();		
		
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
	
	public  ProductoProduMerma getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		ProductoProduMerma entity = new ProductoProduMerma();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ProductoProduMermaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ProductoProduMermaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Produccion.ProductoProduMerma.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setProductoProduMermaOriginal(new ProductoProduMerma());
      	    	entity=super.getEntity("",entity,resultSet,ProductoProduMermaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityProductoProduMerma("",entity,resultSet); 
				
				//entity.setProductoProduMermaOriginal(super.getEntity("",entity.getProductoProduMermaOriginal(),resultSet,ProductoProduMermaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoProduMermaOriginal(this.getEntityProductoProduMerma("",entity.getProductoProduMermaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseProductoProduMerma(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  ProductoProduMerma getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ProductoProduMerma entity = new ProductoProduMerma();
				
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
	
	public  ProductoProduMerma getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ProductoProduMerma entity = new ProductoProduMerma();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ProductoProduMermaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ProductoProduMermaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoProduMermaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Produccion.ProductoProduMerma.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setProductoProduMermaOriginal(new ProductoProduMerma());
      	    	entity=super.getEntity("",entity,resultSet,ProductoProduMermaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityProductoProduMerma("",entity,resultSet);    
				
				//entity.setProductoProduMermaOriginal(super.getEntity("",entity.getProductoProduMermaOriginal(),resultSet,ProductoProduMermaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoProduMermaOriginal(this.getEntityProductoProduMerma("",entity.getProductoProduMermaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseProductoProduMerma(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //ProductoProduMerma
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		ProductoProduMerma entity = new ProductoProduMerma();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ProductoProduMermaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ProductoProduMermaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoProduMermaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Produccion.ProductoProduMerma.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseProductoProduMerma(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<ProductoProduMerma> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ProductoProduMerma> entities = new  ArrayList<ProductoProduMerma>();
		ProductoProduMerma entity = new ProductoProduMerma();		  
		
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
	
	public  List<ProductoProduMerma> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ProductoProduMerma> entities = new  ArrayList<ProductoProduMerma>();
		ProductoProduMerma entity = new ProductoProduMerma();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ProductoProduMermaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ProductoProduMermaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoProduMermaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoProduMerma();
      	    	entity=super.getEntity("",entity,resultSet,ProductoProduMermaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityProductoProduMerma("",entity,resultSet);
      	    	
				//entity.setProductoProduMermaOriginal( new ProductoProduMerma());
      	    	//entity.setProductoProduMermaOriginal(super.getEntity("",entity.getProductoProduMermaOriginal(),resultSet,ProductoProduMermaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoProduMermaOriginal(this.getEntityProductoProduMerma("",entity.getProductoProduMermaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseProductoProduMermas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoProduMerma(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ProductoProduMerma> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProductoProduMerma> entities = new  ArrayList<ProductoProduMerma>();
		ProductoProduMerma entity = new ProductoProduMerma();		  
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
	
	public  List<ProductoProduMerma> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProductoProduMerma> entities = new  ArrayList<ProductoProduMerma>();
		ProductoProduMerma entity = new ProductoProduMerma();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoProduMerma();
				
				if(conMapGenerico) {
					entity.inicializarMapProductoProduMerma();
					//entity.setMapProductoProduMerma(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapProductoProduMermaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapProductoProduMerma().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProductoProduMermaDataAccess.ISWITHSCHEMA);         		
					entity=ProductoProduMermaDataAccess.getEntityProductoProduMerma("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setProductoProduMermaOriginal( new ProductoProduMerma());
					////entity.setProductoProduMermaOriginal(super.getEntity("",entity.getProductoProduMermaOriginal(),resultSet,ProductoProduMermaDataAccess.ISWITHSCHEMA));         		
					////entity.setProductoProduMermaOriginal(this.getEntityProductoProduMerma("",entity.getProductoProduMermaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseProductoProduMermas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoProduMerma(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public ProductoProduMerma getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ProductoProduMerma entity = new ProductoProduMerma();		  
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
	
	public  ProductoProduMerma getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ProductoProduMerma entity = new ProductoProduMerma();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoProduMerma();
				
				if(conMapGenerico) {
					entity.inicializarMapProductoProduMerma();
					//entity.setMapProductoProduMerma(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapProductoProduMermaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapProductoProduMerma().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProductoProduMermaDataAccess.ISWITHSCHEMA);         		
					entity=ProductoProduMermaDataAccess.getEntityProductoProduMerma("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setProductoProduMermaOriginal( new ProductoProduMerma());
					////entity.setProductoProduMermaOriginal(super.getEntity("",entity.getProductoProduMermaOriginal(),resultSet,ProductoProduMermaDataAccess.ISWITHSCHEMA));         		
					////entity.setProductoProduMermaOriginal(this.getEntityProductoProduMerma("",entity.getProductoProduMermaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseProductoProduMerma(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoProduMerma(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ProductoProduMerma getEntityProductoProduMerma(String strPrefijo,ProductoProduMerma entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = ProductoProduMerma.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = ProductoProduMerma.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ProductoProduMermaDataAccess.setFieldReflectionProductoProduMerma(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasProductoProduMerma=ProductoProduMermaConstantesFunciones.getTodosTiposColumnasProductoProduMerma();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasProductoProduMerma) {
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
							field = ProductoProduMerma.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = ProductoProduMerma.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ProductoProduMermaDataAccess.setFieldReflectionProductoProduMerma(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionProductoProduMerma(Field field,String strPrefijo,String sColumn,ProductoProduMerma entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ProductoProduMermaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoProduMermaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProductoProduMermaConstantesFunciones.IDPRODUCTODEFIPRODU:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoProduMermaConstantesFunciones.IDTIPOMERMAEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoProduMermaConstantesFunciones.IDUNIDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoProduMermaConstantesFunciones.CANTIDAD:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case ProductoProduMermaConstantesFunciones.COSTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductoProduMermaConstantesFunciones.COSTOTOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductoProduMermaConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ProductoProduMerma>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<ProductoProduMerma> entities = new  ArrayList<ProductoProduMerma>();
		ProductoProduMerma entity = new ProductoProduMerma();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ProductoProduMermaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ProductoProduMermaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoProduMermaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new ProductoProduMerma();
					entity=super.getEntity("",entity,resultSet,ProductoProduMermaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityProductoProduMerma("",entity,resultSet);
					
					//entity.setProductoProduMermaOriginal( new ProductoProduMerma());
					//entity.setProductoProduMermaOriginal(super.getEntity("",entity.getProductoProduMermaOriginal(),resultSet,ProductoProduMermaDataAccess.ISWITHSCHEMA));         		
					//entity.setProductoProduMermaOriginal(this.getEntityProductoProduMerma("",entity.getProductoProduMermaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseProductoProduMermas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoProduMerma(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ProductoProduMerma>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<ProductoProduMerma> entities = new  ArrayList<ProductoProduMerma>();
		ProductoProduMerma entity = new ProductoProduMerma();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ProductoProduMermaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ProductoProduMermaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoProduMermaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<ProductoProduMerma> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductoProduMerma> entities = new  ArrayList<ProductoProduMerma>();
		ProductoProduMerma entity = new ProductoProduMerma();		  
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
	
	public  List<ProductoProduMerma> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductoProduMerma> entities = new  ArrayList<ProductoProduMerma>();
		ProductoProduMerma entity = new ProductoProduMerma();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoProduMerma();
      	    	entity=super.getEntity("",entity,resultSet,ProductoProduMermaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityProductoProduMerma("",entity,resultSet);
      	    	
				//entity.setProductoProduMermaOriginal( new ProductoProduMerma());
      	    	//entity.setProductoProduMermaOriginal(super.getEntity("",entity.getProductoProduMermaOriginal(),resultSet,ProductoProduMermaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoProduMermaOriginal(this.getEntityProductoProduMerma("",entity.getProductoProduMermaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseProductoProduMermas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoProduMerma(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ProductoProduMerma> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductoProduMerma> entities = new  ArrayList<ProductoProduMerma>();
		ProductoProduMerma entity = new ProductoProduMerma();		  
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
	
	public  List<ProductoProduMerma> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductoProduMerma> entities = new  ArrayList<ProductoProduMerma>();
		ProductoProduMerma entity = new ProductoProduMerma();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoProduMerma();
      	    	entity=super.getEntity("",entity,resultSet,ProductoProduMermaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityProductoProduMerma("",entity,resultSet);
      	    	
				//entity.setProductoProduMermaOriginal( new ProductoProduMerma());
      	    	//entity.setProductoProduMermaOriginal(super.getEntity("",entity.getProductoProduMermaOriginal(),resultSet,ProductoProduMermaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoProduMermaOriginal(this.getEntityProductoProduMerma("",entity.getProductoProduMermaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseProductoProduMermas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public ProductoProduMerma getEntityProductoProduMerma(String strPrefijo,ProductoProduMerma entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_producto_defi_produ(resultSet.getLong(strPrefijo+ProductoProduMermaConstantesFunciones.IDPRODUCTODEFIPRODU));
				entity.setid_tipo_merma_empresa(resultSet.getLong(strPrefijo+ProductoProduMermaConstantesFunciones.IDTIPOMERMAEMPRESA));
				entity.setid_unidad(resultSet.getLong(strPrefijo+ProductoProduMermaConstantesFunciones.IDUNIDAD));
				entity.setcantidad(resultSet.getInt(strPrefijo+ProductoProduMermaConstantesFunciones.CANTIDAD));
				entity.setcosto(resultSet.getDouble(strPrefijo+ProductoProduMermaConstantesFunciones.COSTO));
				entity.setcosto_total(resultSet.getDouble(strPrefijo+ProductoProduMermaConstantesFunciones.COSTOTOTAL));
				entity.setdescripcion(resultSet.getString(strPrefijo+ProductoProduMermaConstantesFunciones.DESCRIPCION));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowProductoProduMerma(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(ProductoProduMerma entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ProductoProduMermaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ProductoProduMermaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ProductoProduMermaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ProductoProduMermaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ProductoProduMermaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ProductoProduMermaDataAccess.TABLENAME,ProductoProduMermaDataAccess.ISWITHSTOREPROCEDURES);
			
			ProductoProduMermaDataAccess.setProductoProduMermaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public ProductoDefiProdu getProductoDefiProdu(Connexion connexion,ProductoProduMerma relproductoprodumerma)throws SQLException,Exception {

		ProductoDefiProdu productodefiprodu= new ProductoDefiProdu();

		try {
			ProductoDefiProduDataAccess productodefiproduDataAccess=new ProductoDefiProduDataAccess();

			productodefiproduDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			productodefiproduDataAccess.setConnexionType(this.connexionType);
			productodefiproduDataAccess.setParameterDbType(this.parameterDbType);

			productodefiprodu=productodefiproduDataAccess.getEntity(connexion,relproductoprodumerma.getid_producto_defi_produ());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return productodefiprodu;

	}

	public TipoMermaEmpresa getTipoMermaEmpresa(Connexion connexion,ProductoProduMerma relproductoprodumerma)throws SQLException,Exception {

		TipoMermaEmpresa tipomermaempresa= new TipoMermaEmpresa();

		try {
			TipoMermaEmpresaDataAccess tipomermaempresaDataAccess=new TipoMermaEmpresaDataAccess();

			tipomermaempresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipomermaempresaDataAccess.setConnexionType(this.connexionType);
			tipomermaempresaDataAccess.setParameterDbType(this.parameterDbType);

			tipomermaempresa=tipomermaempresaDataAccess.getEntity(connexion,relproductoprodumerma.getid_tipo_merma_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipomermaempresa;

	}

	public Unidad getUnidad(Connexion connexion,ProductoProduMerma relproductoprodumerma)throws SQLException,Exception {

		Unidad unidad= new Unidad();

		try {
			UnidadDataAccess unidadDataAccess=new UnidadDataAccess();

			unidadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			unidadDataAccess.setConnexionType(this.connexionType);
			unidadDataAccess.setParameterDbType(this.parameterDbType);

			unidad=unidadDataAccess.getEntity(connexion,relproductoprodumerma.getid_unidad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return unidad;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,ProductoProduMerma productoprodumerma) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!productoprodumerma.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_producto_defi_produ=new ParameterValue<Long>();
					parameterMaintenanceValueid_producto_defi_produ.setValue(productoprodumerma.getid_producto_defi_produ());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_producto_defi_produ);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_merma_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_merma_empresa.setValue(productoprodumerma.getid_tipo_merma_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_merma_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_unidad=new ParameterValue<Long>();
					parameterMaintenanceValueid_unidad.setValue(productoprodumerma.getid_unidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_unidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuecantidad=new ParameterValue<Integer>();
					parameterMaintenanceValuecantidad.setValue(productoprodumerma.getcantidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecantidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecosto=new ParameterValue<Double>();
					parameterMaintenanceValuecosto.setValue(productoprodumerma.getcosto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecosto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecosto_total=new ParameterValue<Double>();
					parameterMaintenanceValuecosto_total.setValue(productoprodumerma.getcosto_total());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecosto_total);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(productoprodumerma.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!productoprodumerma.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(productoprodumerma.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(productoprodumerma.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(productoprodumerma.getId());
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
	
	public void setIsNewIsChangedFalseProductoProduMerma(ProductoProduMerma productoprodumerma)throws Exception  {		
		productoprodumerma.setIsNew(false);
		productoprodumerma.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseProductoProduMermas(List<ProductoProduMerma> productoprodumermas)throws Exception  {				
		for(ProductoProduMerma productoprodumerma:productoprodumermas) {
			productoprodumerma.setIsNew(false);
			productoprodumerma.setIsChanged(false);
		}
	}
	
	public void generarExportarProductoProduMerma(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
