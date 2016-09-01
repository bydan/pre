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
import com.bydan.erp.produccion.util.*;//ProductoProduMaquinaConstantesFunciones;


import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.inventario.business.dataaccess.*;


import com.bydan.erp.inventario.util.*;




@SuppressWarnings("unused")
final public class ProductoProduMaquinaDataAccess extends  ProductoProduMaquinaDataAccessAdditional{ //ProductoProduMaquinaDataAccessAdditional,DataAccessHelper<ProductoProduMaquina>
	//static Logger logger = Logger.getLogger(ProductoProduMaquinaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="producto_produ_maquina";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ProductoProduMaquinaConstantesFunciones.SCHEMA+"."+ProductoProduMaquinaConstantesFunciones.TABLENAME+"(version_row,id_producto_defi_produ,id_tipo_area_empresa_produ,id_tipo_proceso_empresa_produ,id_tipo_merma_empresa,id_unidad,cantidad,costo,costo_total,descripcion)values(current_timestamp,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+ProductoProduMaquinaConstantesFunciones.SCHEMA+"."+ProductoProduMaquinaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_producto_defi_produ=?,id_tipo_area_empresa_produ=?,id_tipo_proceso_empresa_produ=?,id_tipo_merma_empresa=?,id_unidad=?,cantidad=?,costo=?,costo_total=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ProductoProduMaquinaConstantesFunciones.SCHEMA+"."+ProductoProduMaquinaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select productoprodumaquina from "+ProductoProduMaquinaConstantesFunciones.SPERSISTENCENAME+" productoprodumaquina";
	public static String QUERYSELECTNATIVE="select "+ProductoProduMaquinaConstantesFunciones.SCHEMA+"."+ProductoProduMaquinaConstantesFunciones.TABLENAME+".id,"+ProductoProduMaquinaConstantesFunciones.SCHEMA+"."+ProductoProduMaquinaConstantesFunciones.TABLENAME+".version_row,"+ProductoProduMaquinaConstantesFunciones.SCHEMA+"."+ProductoProduMaquinaConstantesFunciones.TABLENAME+".id_producto_defi_produ,"+ProductoProduMaquinaConstantesFunciones.SCHEMA+"."+ProductoProduMaquinaConstantesFunciones.TABLENAME+".id_tipo_area_empresa_produ,"+ProductoProduMaquinaConstantesFunciones.SCHEMA+"."+ProductoProduMaquinaConstantesFunciones.TABLENAME+".id_tipo_proceso_empresa_produ,"+ProductoProduMaquinaConstantesFunciones.SCHEMA+"."+ProductoProduMaquinaConstantesFunciones.TABLENAME+".id_tipo_merma_empresa,"+ProductoProduMaquinaConstantesFunciones.SCHEMA+"."+ProductoProduMaquinaConstantesFunciones.TABLENAME+".id_unidad,"+ProductoProduMaquinaConstantesFunciones.SCHEMA+"."+ProductoProduMaquinaConstantesFunciones.TABLENAME+".cantidad,"+ProductoProduMaquinaConstantesFunciones.SCHEMA+"."+ProductoProduMaquinaConstantesFunciones.TABLENAME+".costo,"+ProductoProduMaquinaConstantesFunciones.SCHEMA+"."+ProductoProduMaquinaConstantesFunciones.TABLENAME+".costo_total,"+ProductoProduMaquinaConstantesFunciones.SCHEMA+"."+ProductoProduMaquinaConstantesFunciones.TABLENAME+".descripcion from "+ProductoProduMaquinaConstantesFunciones.SCHEMA+"."+ProductoProduMaquinaConstantesFunciones.TABLENAME;//+" as "+ProductoProduMaquinaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ProductoProduMaquinaConstantesFunciones.SCHEMA+"."+ProductoProduMaquinaConstantesFunciones.TABLENAME+".id,"+ProductoProduMaquinaConstantesFunciones.SCHEMA+"."+ProductoProduMaquinaConstantesFunciones.TABLENAME+".version_row from "+ProductoProduMaquinaConstantesFunciones.SCHEMA+"."+ProductoProduMaquinaConstantesFunciones.TABLENAME;//+" as "+ProductoProduMaquinaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ProductoProduMaquinaConstantesFunciones.SCHEMA+"."+ProductoProduMaquinaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_producto_defi_produ=?,id_tipo_area_empresa_produ=?,id_tipo_proceso_empresa_produ=?,id_tipo_merma_empresa=?,id_unidad=?,cantidad=?,costo=?,costo_total=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PRODUCTOPRODUMAQUINA_INSERT(?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PRODUCTOPRODUMAQUINA_UPDATE(?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PRODUCTOPRODUMAQUINA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PRODUCTOPRODUMAQUINA_SELECT(?,?)";
	
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
	
	
	protected ProductoProduMaquinaDataAccessAdditional productoprodumaquinaDataAccessAdditional=null;
	
	public ProductoProduMaquinaDataAccessAdditional getProductoProduMaquinaDataAccessAdditional() {
		return this.productoprodumaquinaDataAccessAdditional;
	}
	
	public void setProductoProduMaquinaDataAccessAdditional(ProductoProduMaquinaDataAccessAdditional productoprodumaquinaDataAccessAdditional) {
		try {
			this.productoprodumaquinaDataAccessAdditional=productoprodumaquinaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ProductoProduMaquinaDataAccess() {
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
		ProductoProduMaquinaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ProductoProduMaquinaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ProductoProduMaquinaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setProductoProduMaquinaOriginal(ProductoProduMaquina productoprodumaquina)throws Exception  {
		productoprodumaquina.setProductoProduMaquinaOriginal((ProductoProduMaquina)productoprodumaquina.clone());		
	}
	
	public void setProductoProduMaquinasOriginal(List<ProductoProduMaquina> productoprodumaquinas)throws Exception  {
		
		for(ProductoProduMaquina productoprodumaquina:productoprodumaquinas){
			productoprodumaquina.setProductoProduMaquinaOriginal((ProductoProduMaquina)productoprodumaquina.clone());
		}
	}
	
	public static void setProductoProduMaquinaOriginalStatic(ProductoProduMaquina productoprodumaquina)throws Exception  {
		productoprodumaquina.setProductoProduMaquinaOriginal((ProductoProduMaquina)productoprodumaquina.clone());		
	}
	
	public static void setProductoProduMaquinasOriginalStatic(List<ProductoProduMaquina> productoprodumaquinas)throws Exception  {
		
		for(ProductoProduMaquina productoprodumaquina:productoprodumaquinas){
			productoprodumaquina.setProductoProduMaquinaOriginal((ProductoProduMaquina)productoprodumaquina.clone());
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
	
	public  ProductoProduMaquina getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		ProductoProduMaquina entity = new ProductoProduMaquina();		
		
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
	
	public  ProductoProduMaquina getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		ProductoProduMaquina entity = new ProductoProduMaquina();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ProductoProduMaquinaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ProductoProduMaquinaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Produccion.ProductoProduMaquina.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setProductoProduMaquinaOriginal(new ProductoProduMaquina());
      	    	entity=super.getEntity("",entity,resultSet,ProductoProduMaquinaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityProductoProduMaquina("",entity,resultSet); 
				
				//entity.setProductoProduMaquinaOriginal(super.getEntity("",entity.getProductoProduMaquinaOriginal(),resultSet,ProductoProduMaquinaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoProduMaquinaOriginal(this.getEntityProductoProduMaquina("",entity.getProductoProduMaquinaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseProductoProduMaquina(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  ProductoProduMaquina getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ProductoProduMaquina entity = new ProductoProduMaquina();
				
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
	
	public  ProductoProduMaquina getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ProductoProduMaquina entity = new ProductoProduMaquina();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ProductoProduMaquinaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ProductoProduMaquinaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoProduMaquinaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Produccion.ProductoProduMaquina.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setProductoProduMaquinaOriginal(new ProductoProduMaquina());
      	    	entity=super.getEntity("",entity,resultSet,ProductoProduMaquinaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityProductoProduMaquina("",entity,resultSet);    
				
				//entity.setProductoProduMaquinaOriginal(super.getEntity("",entity.getProductoProduMaquinaOriginal(),resultSet,ProductoProduMaquinaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoProduMaquinaOriginal(this.getEntityProductoProduMaquina("",entity.getProductoProduMaquinaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseProductoProduMaquina(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //ProductoProduMaquina
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		ProductoProduMaquina entity = new ProductoProduMaquina();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ProductoProduMaquinaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ProductoProduMaquinaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoProduMaquinaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Produccion.ProductoProduMaquina.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseProductoProduMaquina(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<ProductoProduMaquina> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ProductoProduMaquina> entities = new  ArrayList<ProductoProduMaquina>();
		ProductoProduMaquina entity = new ProductoProduMaquina();		  
		
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
	
	public  List<ProductoProduMaquina> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ProductoProduMaquina> entities = new  ArrayList<ProductoProduMaquina>();
		ProductoProduMaquina entity = new ProductoProduMaquina();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ProductoProduMaquinaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ProductoProduMaquinaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoProduMaquinaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoProduMaquina();
      	    	entity=super.getEntity("",entity,resultSet,ProductoProduMaquinaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityProductoProduMaquina("",entity,resultSet);
      	    	
				//entity.setProductoProduMaquinaOriginal( new ProductoProduMaquina());
      	    	//entity.setProductoProduMaquinaOriginal(super.getEntity("",entity.getProductoProduMaquinaOriginal(),resultSet,ProductoProduMaquinaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoProduMaquinaOriginal(this.getEntityProductoProduMaquina("",entity.getProductoProduMaquinaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseProductoProduMaquinas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoProduMaquina(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ProductoProduMaquina> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProductoProduMaquina> entities = new  ArrayList<ProductoProduMaquina>();
		ProductoProduMaquina entity = new ProductoProduMaquina();		  
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
	
	public  List<ProductoProduMaquina> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProductoProduMaquina> entities = new  ArrayList<ProductoProduMaquina>();
		ProductoProduMaquina entity = new ProductoProduMaquina();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoProduMaquina();
				
				if(conMapGenerico) {
					entity.inicializarMapProductoProduMaquina();
					//entity.setMapProductoProduMaquina(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapProductoProduMaquinaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapProductoProduMaquina().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProductoProduMaquinaDataAccess.ISWITHSCHEMA);         		
					entity=ProductoProduMaquinaDataAccess.getEntityProductoProduMaquina("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setProductoProduMaquinaOriginal( new ProductoProduMaquina());
					////entity.setProductoProduMaquinaOriginal(super.getEntity("",entity.getProductoProduMaquinaOriginal(),resultSet,ProductoProduMaquinaDataAccess.ISWITHSCHEMA));         		
					////entity.setProductoProduMaquinaOriginal(this.getEntityProductoProduMaquina("",entity.getProductoProduMaquinaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseProductoProduMaquinas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoProduMaquina(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public ProductoProduMaquina getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ProductoProduMaquina entity = new ProductoProduMaquina();		  
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
	
	public  ProductoProduMaquina getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ProductoProduMaquina entity = new ProductoProduMaquina();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoProduMaquina();
				
				if(conMapGenerico) {
					entity.inicializarMapProductoProduMaquina();
					//entity.setMapProductoProduMaquina(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapProductoProduMaquinaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapProductoProduMaquina().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProductoProduMaquinaDataAccess.ISWITHSCHEMA);         		
					entity=ProductoProduMaquinaDataAccess.getEntityProductoProduMaquina("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setProductoProduMaquinaOriginal( new ProductoProduMaquina());
					////entity.setProductoProduMaquinaOriginal(super.getEntity("",entity.getProductoProduMaquinaOriginal(),resultSet,ProductoProduMaquinaDataAccess.ISWITHSCHEMA));         		
					////entity.setProductoProduMaquinaOriginal(this.getEntityProductoProduMaquina("",entity.getProductoProduMaquinaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseProductoProduMaquina(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoProduMaquina(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ProductoProduMaquina getEntityProductoProduMaquina(String strPrefijo,ProductoProduMaquina entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = ProductoProduMaquina.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = ProductoProduMaquina.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ProductoProduMaquinaDataAccess.setFieldReflectionProductoProduMaquina(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasProductoProduMaquina=ProductoProduMaquinaConstantesFunciones.getTodosTiposColumnasProductoProduMaquina();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasProductoProduMaquina) {
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
							field = ProductoProduMaquina.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = ProductoProduMaquina.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ProductoProduMaquinaDataAccess.setFieldReflectionProductoProduMaquina(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionProductoProduMaquina(Field field,String strPrefijo,String sColumn,ProductoProduMaquina entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ProductoProduMaquinaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoProduMaquinaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProductoProduMaquinaConstantesFunciones.IDPRODUCTODEFIPRODU:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoProduMaquinaConstantesFunciones.IDTIPOAREAEMPRESAPRODU:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoProduMaquinaConstantesFunciones.IDTIPOPROCESOEMPRESAPRODU:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoProduMaquinaConstantesFunciones.IDTIPOMAQUINAEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoProduMaquinaConstantesFunciones.IDUNIDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoProduMaquinaConstantesFunciones.CANTIDAD:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case ProductoProduMaquinaConstantesFunciones.COSTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductoProduMaquinaConstantesFunciones.COSTOTOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductoProduMaquinaConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ProductoProduMaquina>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<ProductoProduMaquina> entities = new  ArrayList<ProductoProduMaquina>();
		ProductoProduMaquina entity = new ProductoProduMaquina();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ProductoProduMaquinaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ProductoProduMaquinaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoProduMaquinaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new ProductoProduMaquina();
					entity=super.getEntity("",entity,resultSet,ProductoProduMaquinaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityProductoProduMaquina("",entity,resultSet);
					
					//entity.setProductoProduMaquinaOriginal( new ProductoProduMaquina());
					//entity.setProductoProduMaquinaOriginal(super.getEntity("",entity.getProductoProduMaquinaOriginal(),resultSet,ProductoProduMaquinaDataAccess.ISWITHSCHEMA));         		
					//entity.setProductoProduMaquinaOriginal(this.getEntityProductoProduMaquina("",entity.getProductoProduMaquinaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseProductoProduMaquinas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoProduMaquina(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ProductoProduMaquina>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<ProductoProduMaquina> entities = new  ArrayList<ProductoProduMaquina>();
		ProductoProduMaquina entity = new ProductoProduMaquina();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ProductoProduMaquinaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ProductoProduMaquinaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoProduMaquinaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<ProductoProduMaquina> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductoProduMaquina> entities = new  ArrayList<ProductoProduMaquina>();
		ProductoProduMaquina entity = new ProductoProduMaquina();		  
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
	
	public  List<ProductoProduMaquina> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductoProduMaquina> entities = new  ArrayList<ProductoProduMaquina>();
		ProductoProduMaquina entity = new ProductoProduMaquina();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoProduMaquina();
      	    	entity=super.getEntity("",entity,resultSet,ProductoProduMaquinaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityProductoProduMaquina("",entity,resultSet);
      	    	
				//entity.setProductoProduMaquinaOriginal( new ProductoProduMaquina());
      	    	//entity.setProductoProduMaquinaOriginal(super.getEntity("",entity.getProductoProduMaquinaOriginal(),resultSet,ProductoProduMaquinaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoProduMaquinaOriginal(this.getEntityProductoProduMaquina("",entity.getProductoProduMaquinaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseProductoProduMaquinas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoProduMaquina(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ProductoProduMaquina> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductoProduMaquina> entities = new  ArrayList<ProductoProduMaquina>();
		ProductoProduMaquina entity = new ProductoProduMaquina();		  
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
	
	public  List<ProductoProduMaquina> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductoProduMaquina> entities = new  ArrayList<ProductoProduMaquina>();
		ProductoProduMaquina entity = new ProductoProduMaquina();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoProduMaquina();
      	    	entity=super.getEntity("",entity,resultSet,ProductoProduMaquinaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityProductoProduMaquina("",entity,resultSet);
      	    	
				//entity.setProductoProduMaquinaOriginal( new ProductoProduMaquina());
      	    	//entity.setProductoProduMaquinaOriginal(super.getEntity("",entity.getProductoProduMaquinaOriginal(),resultSet,ProductoProduMaquinaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoProduMaquinaOriginal(this.getEntityProductoProduMaquina("",entity.getProductoProduMaquinaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseProductoProduMaquinas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public ProductoProduMaquina getEntityProductoProduMaquina(String strPrefijo,ProductoProduMaquina entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_producto_defi_produ(resultSet.getLong(strPrefijo+ProductoProduMaquinaConstantesFunciones.IDPRODUCTODEFIPRODU));
				entity.setid_tipo_area_empresa_produ(resultSet.getLong(strPrefijo+ProductoProduMaquinaConstantesFunciones.IDTIPOAREAEMPRESAPRODU));
				entity.setid_tipo_proceso_empresa_produ(resultSet.getLong(strPrefijo+ProductoProduMaquinaConstantesFunciones.IDTIPOPROCESOEMPRESAPRODU));
				entity.setid_tipo_merma_empresa(resultSet.getLong(strPrefijo+ProductoProduMaquinaConstantesFunciones.IDTIPOMAQUINAEMPRESA));
				entity.setid_unidad(resultSet.getLong(strPrefijo+ProductoProduMaquinaConstantesFunciones.IDUNIDAD));
				entity.setcantidad(resultSet.getInt(strPrefijo+ProductoProduMaquinaConstantesFunciones.CANTIDAD));
				entity.setcosto(resultSet.getDouble(strPrefijo+ProductoProduMaquinaConstantesFunciones.COSTO));
				entity.setcosto_total(resultSet.getDouble(strPrefijo+ProductoProduMaquinaConstantesFunciones.COSTOTOTAL));
				entity.setdescripcion(resultSet.getString(strPrefijo+ProductoProduMaquinaConstantesFunciones.DESCRIPCION));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowProductoProduMaquina(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(ProductoProduMaquina entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ProductoProduMaquinaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ProductoProduMaquinaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ProductoProduMaquinaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ProductoProduMaquinaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ProductoProduMaquinaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ProductoProduMaquinaDataAccess.TABLENAME,ProductoProduMaquinaDataAccess.ISWITHSTOREPROCEDURES);
			
			ProductoProduMaquinaDataAccess.setProductoProduMaquinaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public ProductoDefiProdu getProductoDefiProdu(Connexion connexion,ProductoProduMaquina relproductoprodumaquina)throws SQLException,Exception {

		ProductoDefiProdu productodefiprodu= new ProductoDefiProdu();

		try {
			ProductoDefiProduDataAccess productodefiproduDataAccess=new ProductoDefiProduDataAccess();

			productodefiproduDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			productodefiproduDataAccess.setConnexionType(this.connexionType);
			productodefiproduDataAccess.setParameterDbType(this.parameterDbType);

			productodefiprodu=productodefiproduDataAccess.getEntity(connexion,relproductoprodumaquina.getid_producto_defi_produ());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return productodefiprodu;

	}

	public TipoAreaEmpresaProdu getTipoAreaEmpresaProdu(Connexion connexion,ProductoProduMaquina relproductoprodumaquina)throws SQLException,Exception {

		TipoAreaEmpresaProdu tipoareaempresaprodu= new TipoAreaEmpresaProdu();

		try {
			TipoAreaEmpresaProduDataAccess tipoareaempresaproduDataAccess=new TipoAreaEmpresaProduDataAccess();

			tipoareaempresaproduDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoareaempresaproduDataAccess.setConnexionType(this.connexionType);
			tipoareaempresaproduDataAccess.setParameterDbType(this.parameterDbType);

			tipoareaempresaprodu=tipoareaempresaproduDataAccess.getEntity(connexion,relproductoprodumaquina.getid_tipo_area_empresa_produ());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoareaempresaprodu;

	}

	public TipoProcesoEmpresaProdu getTipoProcesoEmpresaProdu(Connexion connexion,ProductoProduMaquina relproductoprodumaquina)throws SQLException,Exception {

		TipoProcesoEmpresaProdu tipoprocesoempresaprodu= new TipoProcesoEmpresaProdu();

		try {
			TipoProcesoEmpresaProduDataAccess tipoprocesoempresaproduDataAccess=new TipoProcesoEmpresaProduDataAccess();

			tipoprocesoempresaproduDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoprocesoempresaproduDataAccess.setConnexionType(this.connexionType);
			tipoprocesoempresaproduDataAccess.setParameterDbType(this.parameterDbType);

			tipoprocesoempresaprodu=tipoprocesoempresaproduDataAccess.getEntity(connexion,relproductoprodumaquina.getid_tipo_proceso_empresa_produ());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoprocesoempresaprodu;

	}

	public TipoMaquinaEmpresa getTipoMaquinaEmpresa(Connexion connexion,ProductoProduMaquina relproductoprodumaquina)throws SQLException,Exception {

		TipoMaquinaEmpresa tipomaquinaempresa= new TipoMaquinaEmpresa();

		try {
			TipoMaquinaEmpresaDataAccess tipomaquinaempresaDataAccess=new TipoMaquinaEmpresaDataAccess();

			tipomaquinaempresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipomaquinaempresaDataAccess.setConnexionType(this.connexionType);
			tipomaquinaempresaDataAccess.setParameterDbType(this.parameterDbType);

			tipomaquinaempresa=tipomaquinaempresaDataAccess.getEntity(connexion,relproductoprodumaquina.getid_tipo_merma_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipomaquinaempresa;

	}

	public Unidad getUnidad(Connexion connexion,ProductoProduMaquina relproductoprodumaquina)throws SQLException,Exception {

		Unidad unidad= new Unidad();

		try {
			UnidadDataAccess unidadDataAccess=new UnidadDataAccess();

			unidadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			unidadDataAccess.setConnexionType(this.connexionType);
			unidadDataAccess.setParameterDbType(this.parameterDbType);

			unidad=unidadDataAccess.getEntity(connexion,relproductoprodumaquina.getid_unidad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return unidad;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,ProductoProduMaquina productoprodumaquina) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!productoprodumaquina.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_producto_defi_produ=new ParameterValue<Long>();
					parameterMaintenanceValueid_producto_defi_produ.setValue(productoprodumaquina.getid_producto_defi_produ());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_producto_defi_produ);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_area_empresa_produ=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_area_empresa_produ.setValue(productoprodumaquina.getid_tipo_area_empresa_produ());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_area_empresa_produ);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_proceso_empresa_produ=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_proceso_empresa_produ.setValue(productoprodumaquina.getid_tipo_proceso_empresa_produ());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_proceso_empresa_produ);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_merma_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_merma_empresa.setValue(productoprodumaquina.getid_tipo_merma_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_merma_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_unidad=new ParameterValue<Long>();
					parameterMaintenanceValueid_unidad.setValue(productoprodumaquina.getid_unidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_unidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuecantidad=new ParameterValue<Integer>();
					parameterMaintenanceValuecantidad.setValue(productoprodumaquina.getcantidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecantidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecosto=new ParameterValue<Double>();
					parameterMaintenanceValuecosto.setValue(productoprodumaquina.getcosto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecosto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecosto_total=new ParameterValue<Double>();
					parameterMaintenanceValuecosto_total.setValue(productoprodumaquina.getcosto_total());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecosto_total);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(productoprodumaquina.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!productoprodumaquina.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(productoprodumaquina.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(productoprodumaquina.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(productoprodumaquina.getId());
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
	
	public void setIsNewIsChangedFalseProductoProduMaquina(ProductoProduMaquina productoprodumaquina)throws Exception  {		
		productoprodumaquina.setIsNew(false);
		productoprodumaquina.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseProductoProduMaquinas(List<ProductoProduMaquina> productoprodumaquinas)throws Exception  {				
		for(ProductoProduMaquina productoprodumaquina:productoprodumaquinas) {
			productoprodumaquina.setIsNew(false);
			productoprodumaquina.setIsChanged(false);
		}
	}
	
	public void generarExportarProductoProduMaquina(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
