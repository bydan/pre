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
import com.bydan.erp.produccion.util.*;//ProductoOrdenDetaProduMermaConstantesFunciones;


import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.inventario.business.dataaccess.*;


import com.bydan.erp.inventario.util.*;




@SuppressWarnings("unused")
final public class ProductoOrdenDetaProduMermaDataAccess extends  ProductoOrdenDetaProduMermaDataAccessAdditional{ //ProductoOrdenDetaProduMermaDataAccessAdditional,DataAccessHelper<ProductoOrdenDetaProduMerma>
	//static Logger logger = Logger.getLogger(ProductoOrdenDetaProduMermaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="producto_orden_deta_produ_merma";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ProductoOrdenDetaProduMermaConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduMermaConstantesFunciones.TABLENAME+"(version_row,id_orden_deta_produ,id_tipo_merma_empresa,id_unidad,cantidad,costo,costo_total,descripcion)values(current_timestamp,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+ProductoOrdenDetaProduMermaConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduMermaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_orden_deta_produ=?,id_tipo_merma_empresa=?,id_unidad=?,cantidad=?,costo=?,costo_total=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ProductoOrdenDetaProduMermaConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduMermaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select productoordendetaprodumerma from "+ProductoOrdenDetaProduMermaConstantesFunciones.SPERSISTENCENAME+" productoordendetaprodumerma";
	public static String QUERYSELECTNATIVE="select "+ProductoOrdenDetaProduMermaConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduMermaConstantesFunciones.TABLENAME+".id,"+ProductoOrdenDetaProduMermaConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduMermaConstantesFunciones.TABLENAME+".version_row,"+ProductoOrdenDetaProduMermaConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduMermaConstantesFunciones.TABLENAME+".id_orden_deta_produ,"+ProductoOrdenDetaProduMermaConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduMermaConstantesFunciones.TABLENAME+".id_tipo_merma_empresa,"+ProductoOrdenDetaProduMermaConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduMermaConstantesFunciones.TABLENAME+".id_unidad,"+ProductoOrdenDetaProduMermaConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduMermaConstantesFunciones.TABLENAME+".cantidad,"+ProductoOrdenDetaProduMermaConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduMermaConstantesFunciones.TABLENAME+".costo,"+ProductoOrdenDetaProduMermaConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduMermaConstantesFunciones.TABLENAME+".costo_total,"+ProductoOrdenDetaProduMermaConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduMermaConstantesFunciones.TABLENAME+".descripcion from "+ProductoOrdenDetaProduMermaConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduMermaConstantesFunciones.TABLENAME;//+" as "+ProductoOrdenDetaProduMermaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ProductoOrdenDetaProduMermaConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduMermaConstantesFunciones.TABLENAME+".id,"+ProductoOrdenDetaProduMermaConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduMermaConstantesFunciones.TABLENAME+".version_row from "+ProductoOrdenDetaProduMermaConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduMermaConstantesFunciones.TABLENAME;//+" as "+ProductoOrdenDetaProduMermaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ProductoOrdenDetaProduMermaConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduMermaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_orden_deta_produ=?,id_tipo_merma_empresa=?,id_unidad=?,cantidad=?,costo=?,costo_total=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PRODUCTOORDENDETAPRODUMERMA_INSERT(?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PRODUCTOORDENDETAPRODUMERMA_UPDATE(?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PRODUCTOORDENDETAPRODUMERMA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PRODUCTOORDENDETAPRODUMERMA_SELECT(?,?)";
	
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
	
	
	protected ProductoOrdenDetaProduMermaDataAccessAdditional productoordendetaprodumermaDataAccessAdditional=null;
	
	public ProductoOrdenDetaProduMermaDataAccessAdditional getProductoOrdenDetaProduMermaDataAccessAdditional() {
		return this.productoordendetaprodumermaDataAccessAdditional;
	}
	
	public void setProductoOrdenDetaProduMermaDataAccessAdditional(ProductoOrdenDetaProduMermaDataAccessAdditional productoordendetaprodumermaDataAccessAdditional) {
		try {
			this.productoordendetaprodumermaDataAccessAdditional=productoordendetaprodumermaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ProductoOrdenDetaProduMermaDataAccess() {
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
		ProductoOrdenDetaProduMermaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ProductoOrdenDetaProduMermaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ProductoOrdenDetaProduMermaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setProductoOrdenDetaProduMermaOriginal(ProductoOrdenDetaProduMerma productoordendetaprodumerma)throws Exception  {
		productoordendetaprodumerma.setProductoOrdenDetaProduMermaOriginal((ProductoOrdenDetaProduMerma)productoordendetaprodumerma.clone());		
	}
	
	public void setProductoOrdenDetaProduMermasOriginal(List<ProductoOrdenDetaProduMerma> productoordendetaprodumermas)throws Exception  {
		
		for(ProductoOrdenDetaProduMerma productoordendetaprodumerma:productoordendetaprodumermas){
			productoordendetaprodumerma.setProductoOrdenDetaProduMermaOriginal((ProductoOrdenDetaProduMerma)productoordendetaprodumerma.clone());
		}
	}
	
	public static void setProductoOrdenDetaProduMermaOriginalStatic(ProductoOrdenDetaProduMerma productoordendetaprodumerma)throws Exception  {
		productoordendetaprodumerma.setProductoOrdenDetaProduMermaOriginal((ProductoOrdenDetaProduMerma)productoordendetaprodumerma.clone());		
	}
	
	public static void setProductoOrdenDetaProduMermasOriginalStatic(List<ProductoOrdenDetaProduMerma> productoordendetaprodumermas)throws Exception  {
		
		for(ProductoOrdenDetaProduMerma productoordendetaprodumerma:productoordendetaprodumermas){
			productoordendetaprodumerma.setProductoOrdenDetaProduMermaOriginal((ProductoOrdenDetaProduMerma)productoordendetaprodumerma.clone());
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
	
	public  ProductoOrdenDetaProduMerma getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		ProductoOrdenDetaProduMerma entity = new ProductoOrdenDetaProduMerma();		
		
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
	
	public  ProductoOrdenDetaProduMerma getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		ProductoOrdenDetaProduMerma entity = new ProductoOrdenDetaProduMerma();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ProductoOrdenDetaProduMermaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ProductoOrdenDetaProduMermaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Produccion.ProductoOrdenDetaProduMerma.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setProductoOrdenDetaProduMermaOriginal(new ProductoOrdenDetaProduMerma());
      	    	entity=super.getEntity("",entity,resultSet,ProductoOrdenDetaProduMermaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityProductoOrdenDetaProduMerma("",entity,resultSet); 
				
				//entity.setProductoOrdenDetaProduMermaOriginal(super.getEntity("",entity.getProductoOrdenDetaProduMermaOriginal(),resultSet,ProductoOrdenDetaProduMermaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoOrdenDetaProduMermaOriginal(this.getEntityProductoOrdenDetaProduMerma("",entity.getProductoOrdenDetaProduMermaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseProductoOrdenDetaProduMerma(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  ProductoOrdenDetaProduMerma getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ProductoOrdenDetaProduMerma entity = new ProductoOrdenDetaProduMerma();
				
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
	
	public  ProductoOrdenDetaProduMerma getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ProductoOrdenDetaProduMerma entity = new ProductoOrdenDetaProduMerma();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ProductoOrdenDetaProduMermaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ProductoOrdenDetaProduMermaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoOrdenDetaProduMermaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Produccion.ProductoOrdenDetaProduMerma.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setProductoOrdenDetaProduMermaOriginal(new ProductoOrdenDetaProduMerma());
      	    	entity=super.getEntity("",entity,resultSet,ProductoOrdenDetaProduMermaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityProductoOrdenDetaProduMerma("",entity,resultSet);    
				
				//entity.setProductoOrdenDetaProduMermaOriginal(super.getEntity("",entity.getProductoOrdenDetaProduMermaOriginal(),resultSet,ProductoOrdenDetaProduMermaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoOrdenDetaProduMermaOriginal(this.getEntityProductoOrdenDetaProduMerma("",entity.getProductoOrdenDetaProduMermaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseProductoOrdenDetaProduMerma(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //ProductoOrdenDetaProduMerma
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		ProductoOrdenDetaProduMerma entity = new ProductoOrdenDetaProduMerma();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ProductoOrdenDetaProduMermaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ProductoOrdenDetaProduMermaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoOrdenDetaProduMermaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Produccion.ProductoOrdenDetaProduMerma.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseProductoOrdenDetaProduMerma(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<ProductoOrdenDetaProduMerma> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ProductoOrdenDetaProduMerma> entities = new  ArrayList<ProductoOrdenDetaProduMerma>();
		ProductoOrdenDetaProduMerma entity = new ProductoOrdenDetaProduMerma();		  
		
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
	
	public  List<ProductoOrdenDetaProduMerma> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ProductoOrdenDetaProduMerma> entities = new  ArrayList<ProductoOrdenDetaProduMerma>();
		ProductoOrdenDetaProduMerma entity = new ProductoOrdenDetaProduMerma();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ProductoOrdenDetaProduMermaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ProductoOrdenDetaProduMermaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoOrdenDetaProduMermaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoOrdenDetaProduMerma();
      	    	entity=super.getEntity("",entity,resultSet,ProductoOrdenDetaProduMermaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityProductoOrdenDetaProduMerma("",entity,resultSet);
      	    	
				//entity.setProductoOrdenDetaProduMermaOriginal( new ProductoOrdenDetaProduMerma());
      	    	//entity.setProductoOrdenDetaProduMermaOriginal(super.getEntity("",entity.getProductoOrdenDetaProduMermaOriginal(),resultSet,ProductoOrdenDetaProduMermaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoOrdenDetaProduMermaOriginal(this.getEntityProductoOrdenDetaProduMerma("",entity.getProductoOrdenDetaProduMermaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseProductoOrdenDetaProduMermas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoOrdenDetaProduMerma(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ProductoOrdenDetaProduMerma> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProductoOrdenDetaProduMerma> entities = new  ArrayList<ProductoOrdenDetaProduMerma>();
		ProductoOrdenDetaProduMerma entity = new ProductoOrdenDetaProduMerma();		  
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
	
	public  List<ProductoOrdenDetaProduMerma> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProductoOrdenDetaProduMerma> entities = new  ArrayList<ProductoOrdenDetaProduMerma>();
		ProductoOrdenDetaProduMerma entity = new ProductoOrdenDetaProduMerma();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoOrdenDetaProduMerma();
				
				if(conMapGenerico) {
					entity.inicializarMapProductoOrdenDetaProduMerma();
					//entity.setMapProductoOrdenDetaProduMerma(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapProductoOrdenDetaProduMermaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapProductoOrdenDetaProduMerma().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProductoOrdenDetaProduMermaDataAccess.ISWITHSCHEMA);         		
					entity=ProductoOrdenDetaProduMermaDataAccess.getEntityProductoOrdenDetaProduMerma("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setProductoOrdenDetaProduMermaOriginal( new ProductoOrdenDetaProduMerma());
					////entity.setProductoOrdenDetaProduMermaOriginal(super.getEntity("",entity.getProductoOrdenDetaProduMermaOriginal(),resultSet,ProductoOrdenDetaProduMermaDataAccess.ISWITHSCHEMA));         		
					////entity.setProductoOrdenDetaProduMermaOriginal(this.getEntityProductoOrdenDetaProduMerma("",entity.getProductoOrdenDetaProduMermaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseProductoOrdenDetaProduMermas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoOrdenDetaProduMerma(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public ProductoOrdenDetaProduMerma getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ProductoOrdenDetaProduMerma entity = new ProductoOrdenDetaProduMerma();		  
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
	
	public  ProductoOrdenDetaProduMerma getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ProductoOrdenDetaProduMerma entity = new ProductoOrdenDetaProduMerma();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoOrdenDetaProduMerma();
				
				if(conMapGenerico) {
					entity.inicializarMapProductoOrdenDetaProduMerma();
					//entity.setMapProductoOrdenDetaProduMerma(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapProductoOrdenDetaProduMermaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapProductoOrdenDetaProduMerma().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProductoOrdenDetaProduMermaDataAccess.ISWITHSCHEMA);         		
					entity=ProductoOrdenDetaProduMermaDataAccess.getEntityProductoOrdenDetaProduMerma("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setProductoOrdenDetaProduMermaOriginal( new ProductoOrdenDetaProduMerma());
					////entity.setProductoOrdenDetaProduMermaOriginal(super.getEntity("",entity.getProductoOrdenDetaProduMermaOriginal(),resultSet,ProductoOrdenDetaProduMermaDataAccess.ISWITHSCHEMA));         		
					////entity.setProductoOrdenDetaProduMermaOriginal(this.getEntityProductoOrdenDetaProduMerma("",entity.getProductoOrdenDetaProduMermaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseProductoOrdenDetaProduMerma(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoOrdenDetaProduMerma(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ProductoOrdenDetaProduMerma getEntityProductoOrdenDetaProduMerma(String strPrefijo,ProductoOrdenDetaProduMerma entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = ProductoOrdenDetaProduMerma.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = ProductoOrdenDetaProduMerma.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ProductoOrdenDetaProduMermaDataAccess.setFieldReflectionProductoOrdenDetaProduMerma(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasProductoOrdenDetaProduMerma=ProductoOrdenDetaProduMermaConstantesFunciones.getTodosTiposColumnasProductoOrdenDetaProduMerma();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasProductoOrdenDetaProduMerma) {
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
							field = ProductoOrdenDetaProduMerma.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = ProductoOrdenDetaProduMerma.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ProductoOrdenDetaProduMermaDataAccess.setFieldReflectionProductoOrdenDetaProduMerma(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionProductoOrdenDetaProduMerma(Field field,String strPrefijo,String sColumn,ProductoOrdenDetaProduMerma entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ProductoOrdenDetaProduMermaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoOrdenDetaProduMermaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProductoOrdenDetaProduMermaConstantesFunciones.IDORDENDETAPRODU:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoOrdenDetaProduMermaConstantesFunciones.IDTIPOMERMAEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoOrdenDetaProduMermaConstantesFunciones.IDUNIDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoOrdenDetaProduMermaConstantesFunciones.CANTIDAD:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case ProductoOrdenDetaProduMermaConstantesFunciones.COSTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductoOrdenDetaProduMermaConstantesFunciones.COSTOTOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductoOrdenDetaProduMermaConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ProductoOrdenDetaProduMerma>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<ProductoOrdenDetaProduMerma> entities = new  ArrayList<ProductoOrdenDetaProduMerma>();
		ProductoOrdenDetaProduMerma entity = new ProductoOrdenDetaProduMerma();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ProductoOrdenDetaProduMermaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ProductoOrdenDetaProduMermaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoOrdenDetaProduMermaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new ProductoOrdenDetaProduMerma();
					entity=super.getEntity("",entity,resultSet,ProductoOrdenDetaProduMermaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityProductoOrdenDetaProduMerma("",entity,resultSet);
					
					//entity.setProductoOrdenDetaProduMermaOriginal( new ProductoOrdenDetaProduMerma());
					//entity.setProductoOrdenDetaProduMermaOriginal(super.getEntity("",entity.getProductoOrdenDetaProduMermaOriginal(),resultSet,ProductoOrdenDetaProduMermaDataAccess.ISWITHSCHEMA));         		
					//entity.setProductoOrdenDetaProduMermaOriginal(this.getEntityProductoOrdenDetaProduMerma("",entity.getProductoOrdenDetaProduMermaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseProductoOrdenDetaProduMermas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoOrdenDetaProduMerma(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ProductoOrdenDetaProduMerma>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<ProductoOrdenDetaProduMerma> entities = new  ArrayList<ProductoOrdenDetaProduMerma>();
		ProductoOrdenDetaProduMerma entity = new ProductoOrdenDetaProduMerma();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ProductoOrdenDetaProduMermaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ProductoOrdenDetaProduMermaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoOrdenDetaProduMermaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<ProductoOrdenDetaProduMerma> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductoOrdenDetaProduMerma> entities = new  ArrayList<ProductoOrdenDetaProduMerma>();
		ProductoOrdenDetaProduMerma entity = new ProductoOrdenDetaProduMerma();		  
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
	
	public  List<ProductoOrdenDetaProduMerma> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductoOrdenDetaProduMerma> entities = new  ArrayList<ProductoOrdenDetaProduMerma>();
		ProductoOrdenDetaProduMerma entity = new ProductoOrdenDetaProduMerma();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoOrdenDetaProduMerma();
      	    	entity=super.getEntity("",entity,resultSet,ProductoOrdenDetaProduMermaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityProductoOrdenDetaProduMerma("",entity,resultSet);
      	    	
				//entity.setProductoOrdenDetaProduMermaOriginal( new ProductoOrdenDetaProduMerma());
      	    	//entity.setProductoOrdenDetaProduMermaOriginal(super.getEntity("",entity.getProductoOrdenDetaProduMermaOriginal(),resultSet,ProductoOrdenDetaProduMermaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoOrdenDetaProduMermaOriginal(this.getEntityProductoOrdenDetaProduMerma("",entity.getProductoOrdenDetaProduMermaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseProductoOrdenDetaProduMermas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoOrdenDetaProduMerma(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ProductoOrdenDetaProduMerma> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductoOrdenDetaProduMerma> entities = new  ArrayList<ProductoOrdenDetaProduMerma>();
		ProductoOrdenDetaProduMerma entity = new ProductoOrdenDetaProduMerma();		  
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
	
	public  List<ProductoOrdenDetaProduMerma> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductoOrdenDetaProduMerma> entities = new  ArrayList<ProductoOrdenDetaProduMerma>();
		ProductoOrdenDetaProduMerma entity = new ProductoOrdenDetaProduMerma();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoOrdenDetaProduMerma();
      	    	entity=super.getEntity("",entity,resultSet,ProductoOrdenDetaProduMermaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityProductoOrdenDetaProduMerma("",entity,resultSet);
      	    	
				//entity.setProductoOrdenDetaProduMermaOriginal( new ProductoOrdenDetaProduMerma());
      	    	//entity.setProductoOrdenDetaProduMermaOriginal(super.getEntity("",entity.getProductoOrdenDetaProduMermaOriginal(),resultSet,ProductoOrdenDetaProduMermaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoOrdenDetaProduMermaOriginal(this.getEntityProductoOrdenDetaProduMerma("",entity.getProductoOrdenDetaProduMermaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseProductoOrdenDetaProduMermas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public ProductoOrdenDetaProduMerma getEntityProductoOrdenDetaProduMerma(String strPrefijo,ProductoOrdenDetaProduMerma entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_orden_deta_produ(resultSet.getLong(strPrefijo+ProductoOrdenDetaProduMermaConstantesFunciones.IDORDENDETAPRODU));
				entity.setid_tipo_merma_empresa(resultSet.getLong(strPrefijo+ProductoOrdenDetaProduMermaConstantesFunciones.IDTIPOMERMAEMPRESA));
				entity.setid_unidad(resultSet.getLong(strPrefijo+ProductoOrdenDetaProduMermaConstantesFunciones.IDUNIDAD));
				entity.setcantidad(resultSet.getInt(strPrefijo+ProductoOrdenDetaProduMermaConstantesFunciones.CANTIDAD));
				entity.setcosto(resultSet.getDouble(strPrefijo+ProductoOrdenDetaProduMermaConstantesFunciones.COSTO));
				entity.setcosto_total(resultSet.getDouble(strPrefijo+ProductoOrdenDetaProduMermaConstantesFunciones.COSTOTOTAL));
				entity.setdescripcion(resultSet.getString(strPrefijo+ProductoOrdenDetaProduMermaConstantesFunciones.DESCRIPCION));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowProductoOrdenDetaProduMerma(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(ProductoOrdenDetaProduMerma entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ProductoOrdenDetaProduMermaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ProductoOrdenDetaProduMermaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ProductoOrdenDetaProduMermaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ProductoOrdenDetaProduMermaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ProductoOrdenDetaProduMermaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ProductoOrdenDetaProduMermaDataAccess.TABLENAME,ProductoOrdenDetaProduMermaDataAccess.ISWITHSTOREPROCEDURES);
			
			ProductoOrdenDetaProduMermaDataAccess.setProductoOrdenDetaProduMermaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public OrdenDetaProdu getOrdenDetaProdu(Connexion connexion,ProductoOrdenDetaProduMerma relproductoordendetaprodumerma)throws SQLException,Exception {

		OrdenDetaProdu ordendetaprodu= new OrdenDetaProdu();

		try {
			OrdenDetaProduDataAccess ordendetaproduDataAccess=new OrdenDetaProduDataAccess();

			ordendetaproduDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ordendetaproduDataAccess.setConnexionType(this.connexionType);
			ordendetaproduDataAccess.setParameterDbType(this.parameterDbType);

			ordendetaprodu=ordendetaproduDataAccess.getEntity(connexion,relproductoordendetaprodumerma.getid_orden_deta_produ());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ordendetaprodu;

	}

	public TipoMermaEmpresa getTipoMermaEmpresa(Connexion connexion,ProductoOrdenDetaProduMerma relproductoordendetaprodumerma)throws SQLException,Exception {

		TipoMermaEmpresa tipomermaempresa= new TipoMermaEmpresa();

		try {
			TipoMermaEmpresaDataAccess tipomermaempresaDataAccess=new TipoMermaEmpresaDataAccess();

			tipomermaempresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipomermaempresaDataAccess.setConnexionType(this.connexionType);
			tipomermaempresaDataAccess.setParameterDbType(this.parameterDbType);

			tipomermaempresa=tipomermaempresaDataAccess.getEntity(connexion,relproductoordendetaprodumerma.getid_tipo_merma_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipomermaempresa;

	}

	public Unidad getUnidad(Connexion connexion,ProductoOrdenDetaProduMerma relproductoordendetaprodumerma)throws SQLException,Exception {

		Unidad unidad= new Unidad();

		try {
			UnidadDataAccess unidadDataAccess=new UnidadDataAccess();

			unidadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			unidadDataAccess.setConnexionType(this.connexionType);
			unidadDataAccess.setParameterDbType(this.parameterDbType);

			unidad=unidadDataAccess.getEntity(connexion,relproductoordendetaprodumerma.getid_unidad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return unidad;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,ProductoOrdenDetaProduMerma productoordendetaprodumerma) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!productoordendetaprodumerma.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_orden_deta_produ=new ParameterValue<Long>();
					parameterMaintenanceValueid_orden_deta_produ.setValue(productoordendetaprodumerma.getid_orden_deta_produ());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_orden_deta_produ);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_merma_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_merma_empresa.setValue(productoordendetaprodumerma.getid_tipo_merma_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_merma_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_unidad=new ParameterValue<Long>();
					parameterMaintenanceValueid_unidad.setValue(productoordendetaprodumerma.getid_unidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_unidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuecantidad=new ParameterValue<Integer>();
					parameterMaintenanceValuecantidad.setValue(productoordendetaprodumerma.getcantidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecantidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecosto=new ParameterValue<Double>();
					parameterMaintenanceValuecosto.setValue(productoordendetaprodumerma.getcosto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecosto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecosto_total=new ParameterValue<Double>();
					parameterMaintenanceValuecosto_total.setValue(productoordendetaprodumerma.getcosto_total());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecosto_total);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(productoordendetaprodumerma.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!productoordendetaprodumerma.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(productoordendetaprodumerma.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(productoordendetaprodumerma.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(productoordendetaprodumerma.getId());
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
	
	public void setIsNewIsChangedFalseProductoOrdenDetaProduMerma(ProductoOrdenDetaProduMerma productoordendetaprodumerma)throws Exception  {		
		productoordendetaprodumerma.setIsNew(false);
		productoordendetaprodumerma.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseProductoOrdenDetaProduMermas(List<ProductoOrdenDetaProduMerma> productoordendetaprodumermas)throws Exception  {				
		for(ProductoOrdenDetaProduMerma productoordendetaprodumerma:productoordendetaprodumermas) {
			productoordendetaprodumerma.setIsNew(false);
			productoordendetaprodumerma.setIsChanged(false);
		}
	}
	
	public void generarExportarProductoOrdenDetaProduMerma(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
