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
import com.bydan.erp.produccion.util.*;//ProductoOrdenDetaProduManoConstantesFunciones;


import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.inventario.business.dataaccess.*;


import com.bydan.erp.inventario.util.*;




@SuppressWarnings("unused")
final public class ProductoOrdenDetaProduManoDataAccess extends  ProductoOrdenDetaProduManoDataAccessAdditional{ //ProductoOrdenDetaProduManoDataAccessAdditional,DataAccessHelper<ProductoOrdenDetaProduMano>
	//static Logger logger = Logger.getLogger(ProductoOrdenDetaProduManoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="producto_orden_deta_produ_mano";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ProductoOrdenDetaProduManoConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduManoConstantesFunciones.TABLENAME+"(version_row,id_orden_deta_produ,id_tipo_mano_produ_empresa,id_tipo_proceso_empresa_produ,id_unidad,cantidad,costo,costo_total,descripcion)values(current_timestamp,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+ProductoOrdenDetaProduManoConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduManoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_orden_deta_produ=?,id_tipo_mano_produ_empresa=?,id_tipo_proceso_empresa_produ=?,id_unidad=?,cantidad=?,costo=?,costo_total=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ProductoOrdenDetaProduManoConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduManoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select productoordendetaprodumano from "+ProductoOrdenDetaProduManoConstantesFunciones.SPERSISTENCENAME+" productoordendetaprodumano";
	public static String QUERYSELECTNATIVE="select "+ProductoOrdenDetaProduManoConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduManoConstantesFunciones.TABLENAME+".id,"+ProductoOrdenDetaProduManoConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduManoConstantesFunciones.TABLENAME+".version_row,"+ProductoOrdenDetaProduManoConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduManoConstantesFunciones.TABLENAME+".id_orden_deta_produ,"+ProductoOrdenDetaProduManoConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduManoConstantesFunciones.TABLENAME+".id_tipo_mano_produ_empresa,"+ProductoOrdenDetaProduManoConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduManoConstantesFunciones.TABLENAME+".id_tipo_proceso_empresa_produ,"+ProductoOrdenDetaProduManoConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduManoConstantesFunciones.TABLENAME+".id_unidad,"+ProductoOrdenDetaProduManoConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduManoConstantesFunciones.TABLENAME+".cantidad,"+ProductoOrdenDetaProduManoConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduManoConstantesFunciones.TABLENAME+".costo,"+ProductoOrdenDetaProduManoConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduManoConstantesFunciones.TABLENAME+".costo_total,"+ProductoOrdenDetaProduManoConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduManoConstantesFunciones.TABLENAME+".descripcion from "+ProductoOrdenDetaProduManoConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduManoConstantesFunciones.TABLENAME;//+" as "+ProductoOrdenDetaProduManoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ProductoOrdenDetaProduManoConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduManoConstantesFunciones.TABLENAME+".id,"+ProductoOrdenDetaProduManoConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduManoConstantesFunciones.TABLENAME+".version_row from "+ProductoOrdenDetaProduManoConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduManoConstantesFunciones.TABLENAME;//+" as "+ProductoOrdenDetaProduManoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ProductoOrdenDetaProduManoConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduManoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_orden_deta_produ=?,id_tipo_mano_produ_empresa=?,id_tipo_proceso_empresa_produ=?,id_unidad=?,cantidad=?,costo=?,costo_total=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PRODUCTOORDENDETAPRODUMANO_INSERT(?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PRODUCTOORDENDETAPRODUMANO_UPDATE(?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PRODUCTOORDENDETAPRODUMANO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PRODUCTOORDENDETAPRODUMANO_SELECT(?,?)";
	
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
	
	
	protected ProductoOrdenDetaProduManoDataAccessAdditional productoordendetaprodumanoDataAccessAdditional=null;
	
	public ProductoOrdenDetaProduManoDataAccessAdditional getProductoOrdenDetaProduManoDataAccessAdditional() {
		return this.productoordendetaprodumanoDataAccessAdditional;
	}
	
	public void setProductoOrdenDetaProduManoDataAccessAdditional(ProductoOrdenDetaProduManoDataAccessAdditional productoordendetaprodumanoDataAccessAdditional) {
		try {
			this.productoordendetaprodumanoDataAccessAdditional=productoordendetaprodumanoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ProductoOrdenDetaProduManoDataAccess() {
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
		ProductoOrdenDetaProduManoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ProductoOrdenDetaProduManoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ProductoOrdenDetaProduManoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setProductoOrdenDetaProduManoOriginal(ProductoOrdenDetaProduMano productoordendetaprodumano)throws Exception  {
		productoordendetaprodumano.setProductoOrdenDetaProduManoOriginal((ProductoOrdenDetaProduMano)productoordendetaprodumano.clone());		
	}
	
	public void setProductoOrdenDetaProduManosOriginal(List<ProductoOrdenDetaProduMano> productoordendetaprodumanos)throws Exception  {
		
		for(ProductoOrdenDetaProduMano productoordendetaprodumano:productoordendetaprodumanos){
			productoordendetaprodumano.setProductoOrdenDetaProduManoOriginal((ProductoOrdenDetaProduMano)productoordendetaprodumano.clone());
		}
	}
	
	public static void setProductoOrdenDetaProduManoOriginalStatic(ProductoOrdenDetaProduMano productoordendetaprodumano)throws Exception  {
		productoordendetaprodumano.setProductoOrdenDetaProduManoOriginal((ProductoOrdenDetaProduMano)productoordendetaprodumano.clone());		
	}
	
	public static void setProductoOrdenDetaProduManosOriginalStatic(List<ProductoOrdenDetaProduMano> productoordendetaprodumanos)throws Exception  {
		
		for(ProductoOrdenDetaProduMano productoordendetaprodumano:productoordendetaprodumanos){
			productoordendetaprodumano.setProductoOrdenDetaProduManoOriginal((ProductoOrdenDetaProduMano)productoordendetaprodumano.clone());
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
	
	public  ProductoOrdenDetaProduMano getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		ProductoOrdenDetaProduMano entity = new ProductoOrdenDetaProduMano();		
		
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
	
	public  ProductoOrdenDetaProduMano getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		ProductoOrdenDetaProduMano entity = new ProductoOrdenDetaProduMano();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ProductoOrdenDetaProduManoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ProductoOrdenDetaProduManoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Produccion.ProductoOrdenDetaProduMano.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setProductoOrdenDetaProduManoOriginal(new ProductoOrdenDetaProduMano());
      	    	entity=super.getEntity("",entity,resultSet,ProductoOrdenDetaProduManoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityProductoOrdenDetaProduMano("",entity,resultSet); 
				
				//entity.setProductoOrdenDetaProduManoOriginal(super.getEntity("",entity.getProductoOrdenDetaProduManoOriginal(),resultSet,ProductoOrdenDetaProduManoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoOrdenDetaProduManoOriginal(this.getEntityProductoOrdenDetaProduMano("",entity.getProductoOrdenDetaProduManoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseProductoOrdenDetaProduMano(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  ProductoOrdenDetaProduMano getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ProductoOrdenDetaProduMano entity = new ProductoOrdenDetaProduMano();
				
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
	
	public  ProductoOrdenDetaProduMano getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ProductoOrdenDetaProduMano entity = new ProductoOrdenDetaProduMano();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ProductoOrdenDetaProduManoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ProductoOrdenDetaProduManoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoOrdenDetaProduManoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Produccion.ProductoOrdenDetaProduMano.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setProductoOrdenDetaProduManoOriginal(new ProductoOrdenDetaProduMano());
      	    	entity=super.getEntity("",entity,resultSet,ProductoOrdenDetaProduManoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityProductoOrdenDetaProduMano("",entity,resultSet);    
				
				//entity.setProductoOrdenDetaProduManoOriginal(super.getEntity("",entity.getProductoOrdenDetaProduManoOriginal(),resultSet,ProductoOrdenDetaProduManoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoOrdenDetaProduManoOriginal(this.getEntityProductoOrdenDetaProduMano("",entity.getProductoOrdenDetaProduManoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseProductoOrdenDetaProduMano(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //ProductoOrdenDetaProduMano
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		ProductoOrdenDetaProduMano entity = new ProductoOrdenDetaProduMano();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ProductoOrdenDetaProduManoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ProductoOrdenDetaProduManoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoOrdenDetaProduManoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Produccion.ProductoOrdenDetaProduMano.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseProductoOrdenDetaProduMano(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<ProductoOrdenDetaProduMano> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ProductoOrdenDetaProduMano> entities = new  ArrayList<ProductoOrdenDetaProduMano>();
		ProductoOrdenDetaProduMano entity = new ProductoOrdenDetaProduMano();		  
		
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
	
	public  List<ProductoOrdenDetaProduMano> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ProductoOrdenDetaProduMano> entities = new  ArrayList<ProductoOrdenDetaProduMano>();
		ProductoOrdenDetaProduMano entity = new ProductoOrdenDetaProduMano();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ProductoOrdenDetaProduManoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ProductoOrdenDetaProduManoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoOrdenDetaProduManoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoOrdenDetaProduMano();
      	    	entity=super.getEntity("",entity,resultSet,ProductoOrdenDetaProduManoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityProductoOrdenDetaProduMano("",entity,resultSet);
      	    	
				//entity.setProductoOrdenDetaProduManoOriginal( new ProductoOrdenDetaProduMano());
      	    	//entity.setProductoOrdenDetaProduManoOriginal(super.getEntity("",entity.getProductoOrdenDetaProduManoOriginal(),resultSet,ProductoOrdenDetaProduManoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoOrdenDetaProduManoOriginal(this.getEntityProductoOrdenDetaProduMano("",entity.getProductoOrdenDetaProduManoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseProductoOrdenDetaProduManos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoOrdenDetaProduMano(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ProductoOrdenDetaProduMano> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProductoOrdenDetaProduMano> entities = new  ArrayList<ProductoOrdenDetaProduMano>();
		ProductoOrdenDetaProduMano entity = new ProductoOrdenDetaProduMano();		  
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
	
	public  List<ProductoOrdenDetaProduMano> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProductoOrdenDetaProduMano> entities = new  ArrayList<ProductoOrdenDetaProduMano>();
		ProductoOrdenDetaProduMano entity = new ProductoOrdenDetaProduMano();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoOrdenDetaProduMano();
				
				if(conMapGenerico) {
					entity.inicializarMapProductoOrdenDetaProduMano();
					//entity.setMapProductoOrdenDetaProduMano(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapProductoOrdenDetaProduManoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapProductoOrdenDetaProduMano().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProductoOrdenDetaProduManoDataAccess.ISWITHSCHEMA);         		
					entity=ProductoOrdenDetaProduManoDataAccess.getEntityProductoOrdenDetaProduMano("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setProductoOrdenDetaProduManoOriginal( new ProductoOrdenDetaProduMano());
					////entity.setProductoOrdenDetaProduManoOriginal(super.getEntity("",entity.getProductoOrdenDetaProduManoOriginal(),resultSet,ProductoOrdenDetaProduManoDataAccess.ISWITHSCHEMA));         		
					////entity.setProductoOrdenDetaProduManoOriginal(this.getEntityProductoOrdenDetaProduMano("",entity.getProductoOrdenDetaProduManoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseProductoOrdenDetaProduManos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoOrdenDetaProduMano(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public ProductoOrdenDetaProduMano getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ProductoOrdenDetaProduMano entity = new ProductoOrdenDetaProduMano();		  
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
	
	public  ProductoOrdenDetaProduMano getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ProductoOrdenDetaProduMano entity = new ProductoOrdenDetaProduMano();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoOrdenDetaProduMano();
				
				if(conMapGenerico) {
					entity.inicializarMapProductoOrdenDetaProduMano();
					//entity.setMapProductoOrdenDetaProduMano(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapProductoOrdenDetaProduManoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapProductoOrdenDetaProduMano().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProductoOrdenDetaProduManoDataAccess.ISWITHSCHEMA);         		
					entity=ProductoOrdenDetaProduManoDataAccess.getEntityProductoOrdenDetaProduMano("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setProductoOrdenDetaProduManoOriginal( new ProductoOrdenDetaProduMano());
					////entity.setProductoOrdenDetaProduManoOriginal(super.getEntity("",entity.getProductoOrdenDetaProduManoOriginal(),resultSet,ProductoOrdenDetaProduManoDataAccess.ISWITHSCHEMA));         		
					////entity.setProductoOrdenDetaProduManoOriginal(this.getEntityProductoOrdenDetaProduMano("",entity.getProductoOrdenDetaProduManoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseProductoOrdenDetaProduMano(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoOrdenDetaProduMano(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ProductoOrdenDetaProduMano getEntityProductoOrdenDetaProduMano(String strPrefijo,ProductoOrdenDetaProduMano entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = ProductoOrdenDetaProduMano.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = ProductoOrdenDetaProduMano.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ProductoOrdenDetaProduManoDataAccess.setFieldReflectionProductoOrdenDetaProduMano(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasProductoOrdenDetaProduMano=ProductoOrdenDetaProduManoConstantesFunciones.getTodosTiposColumnasProductoOrdenDetaProduMano();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasProductoOrdenDetaProduMano) {
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
							field = ProductoOrdenDetaProduMano.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = ProductoOrdenDetaProduMano.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ProductoOrdenDetaProduManoDataAccess.setFieldReflectionProductoOrdenDetaProduMano(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionProductoOrdenDetaProduMano(Field field,String strPrefijo,String sColumn,ProductoOrdenDetaProduMano entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ProductoOrdenDetaProduManoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoOrdenDetaProduManoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProductoOrdenDetaProduManoConstantesFunciones.IDORDENDETAPRODU:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoOrdenDetaProduManoConstantesFunciones.IDTIPOMANOPRODUEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoOrdenDetaProduManoConstantesFunciones.IDTIPOPROCESOEMPRESAPRODU:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoOrdenDetaProduManoConstantesFunciones.IDUNIDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoOrdenDetaProduManoConstantesFunciones.CANTIDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoOrdenDetaProduManoConstantesFunciones.COSTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductoOrdenDetaProduManoConstantesFunciones.COSTOTOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductoOrdenDetaProduManoConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ProductoOrdenDetaProduMano>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<ProductoOrdenDetaProduMano> entities = new  ArrayList<ProductoOrdenDetaProduMano>();
		ProductoOrdenDetaProduMano entity = new ProductoOrdenDetaProduMano();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ProductoOrdenDetaProduManoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ProductoOrdenDetaProduManoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoOrdenDetaProduManoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new ProductoOrdenDetaProduMano();
					entity=super.getEntity("",entity,resultSet,ProductoOrdenDetaProduManoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityProductoOrdenDetaProduMano("",entity,resultSet);
					
					//entity.setProductoOrdenDetaProduManoOriginal( new ProductoOrdenDetaProduMano());
					//entity.setProductoOrdenDetaProduManoOriginal(super.getEntity("",entity.getProductoOrdenDetaProduManoOriginal(),resultSet,ProductoOrdenDetaProduManoDataAccess.ISWITHSCHEMA));         		
					//entity.setProductoOrdenDetaProduManoOriginal(this.getEntityProductoOrdenDetaProduMano("",entity.getProductoOrdenDetaProduManoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseProductoOrdenDetaProduManos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoOrdenDetaProduMano(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ProductoOrdenDetaProduMano>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<ProductoOrdenDetaProduMano> entities = new  ArrayList<ProductoOrdenDetaProduMano>();
		ProductoOrdenDetaProduMano entity = new ProductoOrdenDetaProduMano();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ProductoOrdenDetaProduManoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ProductoOrdenDetaProduManoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoOrdenDetaProduManoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<ProductoOrdenDetaProduMano> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductoOrdenDetaProduMano> entities = new  ArrayList<ProductoOrdenDetaProduMano>();
		ProductoOrdenDetaProduMano entity = new ProductoOrdenDetaProduMano();		  
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
	
	public  List<ProductoOrdenDetaProduMano> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductoOrdenDetaProduMano> entities = new  ArrayList<ProductoOrdenDetaProduMano>();
		ProductoOrdenDetaProduMano entity = new ProductoOrdenDetaProduMano();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoOrdenDetaProduMano();
      	    	entity=super.getEntity("",entity,resultSet,ProductoOrdenDetaProduManoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityProductoOrdenDetaProduMano("",entity,resultSet);
      	    	
				//entity.setProductoOrdenDetaProduManoOriginal( new ProductoOrdenDetaProduMano());
      	    	//entity.setProductoOrdenDetaProduManoOriginal(super.getEntity("",entity.getProductoOrdenDetaProduManoOriginal(),resultSet,ProductoOrdenDetaProduManoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoOrdenDetaProduManoOriginal(this.getEntityProductoOrdenDetaProduMano("",entity.getProductoOrdenDetaProduManoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseProductoOrdenDetaProduManos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoOrdenDetaProduMano(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ProductoOrdenDetaProduMano> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductoOrdenDetaProduMano> entities = new  ArrayList<ProductoOrdenDetaProduMano>();
		ProductoOrdenDetaProduMano entity = new ProductoOrdenDetaProduMano();		  
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
	
	public  List<ProductoOrdenDetaProduMano> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductoOrdenDetaProduMano> entities = new  ArrayList<ProductoOrdenDetaProduMano>();
		ProductoOrdenDetaProduMano entity = new ProductoOrdenDetaProduMano();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoOrdenDetaProduMano();
      	    	entity=super.getEntity("",entity,resultSet,ProductoOrdenDetaProduManoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityProductoOrdenDetaProduMano("",entity,resultSet);
      	    	
				//entity.setProductoOrdenDetaProduManoOriginal( new ProductoOrdenDetaProduMano());
      	    	//entity.setProductoOrdenDetaProduManoOriginal(super.getEntity("",entity.getProductoOrdenDetaProduManoOriginal(),resultSet,ProductoOrdenDetaProduManoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoOrdenDetaProduManoOriginal(this.getEntityProductoOrdenDetaProduMano("",entity.getProductoOrdenDetaProduManoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseProductoOrdenDetaProduManos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public ProductoOrdenDetaProduMano getEntityProductoOrdenDetaProduMano(String strPrefijo,ProductoOrdenDetaProduMano entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_orden_deta_produ(resultSet.getLong(strPrefijo+ProductoOrdenDetaProduManoConstantesFunciones.IDORDENDETAPRODU));
				entity.setid_tipo_mano_produ_empresa(resultSet.getLong(strPrefijo+ProductoOrdenDetaProduManoConstantesFunciones.IDTIPOMANOPRODUEMPRESA));
				entity.setid_tipo_proceso_empresa_produ(resultSet.getLong(strPrefijo+ProductoOrdenDetaProduManoConstantesFunciones.IDTIPOPROCESOEMPRESAPRODU));
				entity.setid_unidad(resultSet.getLong(strPrefijo+ProductoOrdenDetaProduManoConstantesFunciones.IDUNIDAD));
				entity.setcantidad(resultSet.getLong(strPrefijo+ProductoOrdenDetaProduManoConstantesFunciones.CANTIDAD));
				entity.setcosto(resultSet.getDouble(strPrefijo+ProductoOrdenDetaProduManoConstantesFunciones.COSTO));
				entity.setcosto_total(resultSet.getDouble(strPrefijo+ProductoOrdenDetaProduManoConstantesFunciones.COSTOTOTAL));
				entity.setdescripcion(resultSet.getString(strPrefijo+ProductoOrdenDetaProduManoConstantesFunciones.DESCRIPCION));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowProductoOrdenDetaProduMano(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(ProductoOrdenDetaProduMano entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ProductoOrdenDetaProduManoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ProductoOrdenDetaProduManoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ProductoOrdenDetaProduManoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ProductoOrdenDetaProduManoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ProductoOrdenDetaProduManoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ProductoOrdenDetaProduManoDataAccess.TABLENAME,ProductoOrdenDetaProduManoDataAccess.ISWITHSTOREPROCEDURES);
			
			ProductoOrdenDetaProduManoDataAccess.setProductoOrdenDetaProduManoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public OrdenDetaProdu getOrdenDetaProdu(Connexion connexion,ProductoOrdenDetaProduMano relproductoordendetaprodumano)throws SQLException,Exception {

		OrdenDetaProdu ordendetaprodu= new OrdenDetaProdu();

		try {
			OrdenDetaProduDataAccess ordendetaproduDataAccess=new OrdenDetaProduDataAccess();

			ordendetaproduDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ordendetaproduDataAccess.setConnexionType(this.connexionType);
			ordendetaproduDataAccess.setParameterDbType(this.parameterDbType);

			ordendetaprodu=ordendetaproduDataAccess.getEntity(connexion,relproductoordendetaprodumano.getid_orden_deta_produ());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ordendetaprodu;

	}

	public TipoManoProduEmpresa getTipoManoProduEmpresa(Connexion connexion,ProductoOrdenDetaProduMano relproductoordendetaprodumano)throws SQLException,Exception {

		TipoManoProduEmpresa tipomanoproduempresa= new TipoManoProduEmpresa();

		try {
			TipoManoProduEmpresaDataAccess tipomanoproduempresaDataAccess=new TipoManoProduEmpresaDataAccess();

			tipomanoproduempresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipomanoproduempresaDataAccess.setConnexionType(this.connexionType);
			tipomanoproduempresaDataAccess.setParameterDbType(this.parameterDbType);

			tipomanoproduempresa=tipomanoproduempresaDataAccess.getEntity(connexion,relproductoordendetaprodumano.getid_tipo_mano_produ_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipomanoproduempresa;

	}

	public TipoProcesoEmpresaProdu getTipoProcesoEmpresaProdu(Connexion connexion,ProductoOrdenDetaProduMano relproductoordendetaprodumano)throws SQLException,Exception {

		TipoProcesoEmpresaProdu tipoprocesoempresaprodu= new TipoProcesoEmpresaProdu();

		try {
			TipoProcesoEmpresaProduDataAccess tipoprocesoempresaproduDataAccess=new TipoProcesoEmpresaProduDataAccess();

			tipoprocesoempresaproduDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoprocesoempresaproduDataAccess.setConnexionType(this.connexionType);
			tipoprocesoempresaproduDataAccess.setParameterDbType(this.parameterDbType);

			tipoprocesoempresaprodu=tipoprocesoempresaproduDataAccess.getEntity(connexion,relproductoordendetaprodumano.getid_tipo_proceso_empresa_produ());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoprocesoempresaprodu;

	}

	public Unidad getUnidad(Connexion connexion,ProductoOrdenDetaProduMano relproductoordendetaprodumano)throws SQLException,Exception {

		Unidad unidad= new Unidad();

		try {
			UnidadDataAccess unidadDataAccess=new UnidadDataAccess();

			unidadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			unidadDataAccess.setConnexionType(this.connexionType);
			unidadDataAccess.setParameterDbType(this.parameterDbType);

			unidad=unidadDataAccess.getEntity(connexion,relproductoordendetaprodumano.getid_unidad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return unidad;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,ProductoOrdenDetaProduMano productoordendetaprodumano) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!productoordendetaprodumano.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_orden_deta_produ=new ParameterValue<Long>();
					parameterMaintenanceValueid_orden_deta_produ.setValue(productoordendetaprodumano.getid_orden_deta_produ());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_orden_deta_produ);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_mano_produ_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_mano_produ_empresa.setValue(productoordendetaprodumano.getid_tipo_mano_produ_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_mano_produ_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_proceso_empresa_produ=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_proceso_empresa_produ.setValue(productoordendetaprodumano.getid_tipo_proceso_empresa_produ());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_proceso_empresa_produ);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_unidad=new ParameterValue<Long>();
					parameterMaintenanceValueid_unidad.setValue(productoordendetaprodumano.getid_unidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_unidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValuecantidad=new ParameterValue<Long>();
					parameterMaintenanceValuecantidad.setValue(productoordendetaprodumano.getcantidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecantidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecosto=new ParameterValue<Double>();
					parameterMaintenanceValuecosto.setValue(productoordendetaprodumano.getcosto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecosto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecosto_total=new ParameterValue<Double>();
					parameterMaintenanceValuecosto_total.setValue(productoordendetaprodumano.getcosto_total());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecosto_total);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(productoordendetaprodumano.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!productoordendetaprodumano.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(productoordendetaprodumano.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(productoordendetaprodumano.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(productoordendetaprodumano.getId());
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
	
	public void setIsNewIsChangedFalseProductoOrdenDetaProduMano(ProductoOrdenDetaProduMano productoordendetaprodumano)throws Exception  {		
		productoordendetaprodumano.setIsNew(false);
		productoordendetaprodumano.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseProductoOrdenDetaProduManos(List<ProductoOrdenDetaProduMano> productoordendetaprodumanos)throws Exception  {				
		for(ProductoOrdenDetaProduMano productoordendetaprodumano:productoordendetaprodumanos) {
			productoordendetaprodumano.setIsNew(false);
			productoordendetaprodumano.setIsChanged(false);
		}
	}
	
	public void generarExportarProductoOrdenDetaProduMano(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
