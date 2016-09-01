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
import com.bydan.erp.produccion.util.*;//ProductoOrdenDetaProduMaquinaConstantesFunciones;


import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.inventario.business.dataaccess.*;


import com.bydan.erp.inventario.util.*;




@SuppressWarnings("unused")
final public class ProductoOrdenDetaProduMaquinaDataAccess extends  ProductoOrdenDetaProduMaquinaDataAccessAdditional{ //ProductoOrdenDetaProduMaquinaDataAccessAdditional,DataAccessHelper<ProductoOrdenDetaProduMaquina>
	//static Logger logger = Logger.getLogger(ProductoOrdenDetaProduMaquinaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="producto_orden_deta_produ_maquina";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ProductoOrdenDetaProduMaquinaConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduMaquinaConstantesFunciones.TABLENAME+"(version_row,id_orden_deta_produ,id_tipo_area_empresa_produ,id_tipo_proceso_empresa_produ,id_tipo_merma_empresa,id_unidad,cantidad,costo,costo_total,descripcion)values(current_timestamp,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+ProductoOrdenDetaProduMaquinaConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduMaquinaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_orden_deta_produ=?,id_tipo_area_empresa_produ=?,id_tipo_proceso_empresa_produ=?,id_tipo_merma_empresa=?,id_unidad=?,cantidad=?,costo=?,costo_total=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ProductoOrdenDetaProduMaquinaConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduMaquinaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select productoordendetaprodumaquina from "+ProductoOrdenDetaProduMaquinaConstantesFunciones.SPERSISTENCENAME+" productoordendetaprodumaquina";
	public static String QUERYSELECTNATIVE="select "+ProductoOrdenDetaProduMaquinaConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduMaquinaConstantesFunciones.TABLENAME+".id,"+ProductoOrdenDetaProduMaquinaConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduMaquinaConstantesFunciones.TABLENAME+".version_row,"+ProductoOrdenDetaProduMaquinaConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduMaquinaConstantesFunciones.TABLENAME+".id_orden_deta_produ,"+ProductoOrdenDetaProduMaquinaConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduMaquinaConstantesFunciones.TABLENAME+".id_tipo_area_empresa_produ,"+ProductoOrdenDetaProduMaquinaConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduMaquinaConstantesFunciones.TABLENAME+".id_tipo_proceso_empresa_produ,"+ProductoOrdenDetaProduMaquinaConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduMaquinaConstantesFunciones.TABLENAME+".id_tipo_merma_empresa,"+ProductoOrdenDetaProduMaquinaConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduMaquinaConstantesFunciones.TABLENAME+".id_unidad,"+ProductoOrdenDetaProduMaquinaConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduMaquinaConstantesFunciones.TABLENAME+".cantidad,"+ProductoOrdenDetaProduMaquinaConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduMaquinaConstantesFunciones.TABLENAME+".costo,"+ProductoOrdenDetaProduMaquinaConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduMaquinaConstantesFunciones.TABLENAME+".costo_total,"+ProductoOrdenDetaProduMaquinaConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduMaquinaConstantesFunciones.TABLENAME+".descripcion from "+ProductoOrdenDetaProduMaquinaConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduMaquinaConstantesFunciones.TABLENAME;//+" as "+ProductoOrdenDetaProduMaquinaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ProductoOrdenDetaProduMaquinaConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduMaquinaConstantesFunciones.TABLENAME+".id,"+ProductoOrdenDetaProduMaquinaConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduMaquinaConstantesFunciones.TABLENAME+".version_row from "+ProductoOrdenDetaProduMaquinaConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduMaquinaConstantesFunciones.TABLENAME;//+" as "+ProductoOrdenDetaProduMaquinaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ProductoOrdenDetaProduMaquinaConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduMaquinaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_orden_deta_produ=?,id_tipo_area_empresa_produ=?,id_tipo_proceso_empresa_produ=?,id_tipo_merma_empresa=?,id_unidad=?,cantidad=?,costo=?,costo_total=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PRODUCTOORDENDETAPRODUMAQUINA_INSERT(?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PRODUCTOORDENDETAPRODUMAQUINA_UPDATE(?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PRODUCTOORDENDETAPRODUMAQUINA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PRODUCTOORDENDETAPRODUMAQUINA_SELECT(?,?)";
	
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
	
	
	protected ProductoOrdenDetaProduMaquinaDataAccessAdditional productoordendetaprodumaquinaDataAccessAdditional=null;
	
	public ProductoOrdenDetaProduMaquinaDataAccessAdditional getProductoOrdenDetaProduMaquinaDataAccessAdditional() {
		return this.productoordendetaprodumaquinaDataAccessAdditional;
	}
	
	public void setProductoOrdenDetaProduMaquinaDataAccessAdditional(ProductoOrdenDetaProduMaquinaDataAccessAdditional productoordendetaprodumaquinaDataAccessAdditional) {
		try {
			this.productoordendetaprodumaquinaDataAccessAdditional=productoordendetaprodumaquinaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ProductoOrdenDetaProduMaquinaDataAccess() {
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
		ProductoOrdenDetaProduMaquinaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ProductoOrdenDetaProduMaquinaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ProductoOrdenDetaProduMaquinaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setProductoOrdenDetaProduMaquinaOriginal(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina)throws Exception  {
		productoordendetaprodumaquina.setProductoOrdenDetaProduMaquinaOriginal((ProductoOrdenDetaProduMaquina)productoordendetaprodumaquina.clone());		
	}
	
	public void setProductoOrdenDetaProduMaquinasOriginal(List<ProductoOrdenDetaProduMaquina> productoordendetaprodumaquinas)throws Exception  {
		
		for(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina:productoordendetaprodumaquinas){
			productoordendetaprodumaquina.setProductoOrdenDetaProduMaquinaOriginal((ProductoOrdenDetaProduMaquina)productoordendetaprodumaquina.clone());
		}
	}
	
	public static void setProductoOrdenDetaProduMaquinaOriginalStatic(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina)throws Exception  {
		productoordendetaprodumaquina.setProductoOrdenDetaProduMaquinaOriginal((ProductoOrdenDetaProduMaquina)productoordendetaprodumaquina.clone());		
	}
	
	public static void setProductoOrdenDetaProduMaquinasOriginalStatic(List<ProductoOrdenDetaProduMaquina> productoordendetaprodumaquinas)throws Exception  {
		
		for(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina:productoordendetaprodumaquinas){
			productoordendetaprodumaquina.setProductoOrdenDetaProduMaquinaOriginal((ProductoOrdenDetaProduMaquina)productoordendetaprodumaquina.clone());
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
	
	public  ProductoOrdenDetaProduMaquina getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		ProductoOrdenDetaProduMaquina entity = new ProductoOrdenDetaProduMaquina();		
		
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
	
	public  ProductoOrdenDetaProduMaquina getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		ProductoOrdenDetaProduMaquina entity = new ProductoOrdenDetaProduMaquina();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ProductoOrdenDetaProduMaquinaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ProductoOrdenDetaProduMaquinaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Produccion.ProductoOrdenDetaProduMaquina.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setProductoOrdenDetaProduMaquinaOriginal(new ProductoOrdenDetaProduMaquina());
      	    	entity=super.getEntity("",entity,resultSet,ProductoOrdenDetaProduMaquinaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityProductoOrdenDetaProduMaquina("",entity,resultSet); 
				
				//entity.setProductoOrdenDetaProduMaquinaOriginal(super.getEntity("",entity.getProductoOrdenDetaProduMaquinaOriginal(),resultSet,ProductoOrdenDetaProduMaquinaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoOrdenDetaProduMaquinaOriginal(this.getEntityProductoOrdenDetaProduMaquina("",entity.getProductoOrdenDetaProduMaquinaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseProductoOrdenDetaProduMaquina(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  ProductoOrdenDetaProduMaquina getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ProductoOrdenDetaProduMaquina entity = new ProductoOrdenDetaProduMaquina();
				
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
	
	public  ProductoOrdenDetaProduMaquina getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ProductoOrdenDetaProduMaquina entity = new ProductoOrdenDetaProduMaquina();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ProductoOrdenDetaProduMaquinaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ProductoOrdenDetaProduMaquinaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoOrdenDetaProduMaquinaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Produccion.ProductoOrdenDetaProduMaquina.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setProductoOrdenDetaProduMaquinaOriginal(new ProductoOrdenDetaProduMaquina());
      	    	entity=super.getEntity("",entity,resultSet,ProductoOrdenDetaProduMaquinaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityProductoOrdenDetaProduMaquina("",entity,resultSet);    
				
				//entity.setProductoOrdenDetaProduMaquinaOriginal(super.getEntity("",entity.getProductoOrdenDetaProduMaquinaOriginal(),resultSet,ProductoOrdenDetaProduMaquinaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoOrdenDetaProduMaquinaOriginal(this.getEntityProductoOrdenDetaProduMaquina("",entity.getProductoOrdenDetaProduMaquinaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseProductoOrdenDetaProduMaquina(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //ProductoOrdenDetaProduMaquina
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		ProductoOrdenDetaProduMaquina entity = new ProductoOrdenDetaProduMaquina();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ProductoOrdenDetaProduMaquinaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ProductoOrdenDetaProduMaquinaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoOrdenDetaProduMaquinaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Produccion.ProductoOrdenDetaProduMaquina.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseProductoOrdenDetaProduMaquina(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<ProductoOrdenDetaProduMaquina> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ProductoOrdenDetaProduMaquina> entities = new  ArrayList<ProductoOrdenDetaProduMaquina>();
		ProductoOrdenDetaProduMaquina entity = new ProductoOrdenDetaProduMaquina();		  
		
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
	
	public  List<ProductoOrdenDetaProduMaquina> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ProductoOrdenDetaProduMaquina> entities = new  ArrayList<ProductoOrdenDetaProduMaquina>();
		ProductoOrdenDetaProduMaquina entity = new ProductoOrdenDetaProduMaquina();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ProductoOrdenDetaProduMaquinaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ProductoOrdenDetaProduMaquinaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoOrdenDetaProduMaquinaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoOrdenDetaProduMaquina();
      	    	entity=super.getEntity("",entity,resultSet,ProductoOrdenDetaProduMaquinaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityProductoOrdenDetaProduMaquina("",entity,resultSet);
      	    	
				//entity.setProductoOrdenDetaProduMaquinaOriginal( new ProductoOrdenDetaProduMaquina());
      	    	//entity.setProductoOrdenDetaProduMaquinaOriginal(super.getEntity("",entity.getProductoOrdenDetaProduMaquinaOriginal(),resultSet,ProductoOrdenDetaProduMaquinaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoOrdenDetaProduMaquinaOriginal(this.getEntityProductoOrdenDetaProduMaquina("",entity.getProductoOrdenDetaProduMaquinaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseProductoOrdenDetaProduMaquinas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoOrdenDetaProduMaquina(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ProductoOrdenDetaProduMaquina> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProductoOrdenDetaProduMaquina> entities = new  ArrayList<ProductoOrdenDetaProduMaquina>();
		ProductoOrdenDetaProduMaquina entity = new ProductoOrdenDetaProduMaquina();		  
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
	
	public  List<ProductoOrdenDetaProduMaquina> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProductoOrdenDetaProduMaquina> entities = new  ArrayList<ProductoOrdenDetaProduMaquina>();
		ProductoOrdenDetaProduMaquina entity = new ProductoOrdenDetaProduMaquina();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoOrdenDetaProduMaquina();
				
				if(conMapGenerico) {
					entity.inicializarMapProductoOrdenDetaProduMaquina();
					//entity.setMapProductoOrdenDetaProduMaquina(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapProductoOrdenDetaProduMaquinaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapProductoOrdenDetaProduMaquina().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProductoOrdenDetaProduMaquinaDataAccess.ISWITHSCHEMA);         		
					entity=ProductoOrdenDetaProduMaquinaDataAccess.getEntityProductoOrdenDetaProduMaquina("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setProductoOrdenDetaProduMaquinaOriginal( new ProductoOrdenDetaProduMaquina());
					////entity.setProductoOrdenDetaProduMaquinaOriginal(super.getEntity("",entity.getProductoOrdenDetaProduMaquinaOriginal(),resultSet,ProductoOrdenDetaProduMaquinaDataAccess.ISWITHSCHEMA));         		
					////entity.setProductoOrdenDetaProduMaquinaOriginal(this.getEntityProductoOrdenDetaProduMaquina("",entity.getProductoOrdenDetaProduMaquinaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseProductoOrdenDetaProduMaquinas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoOrdenDetaProduMaquina(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public ProductoOrdenDetaProduMaquina getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ProductoOrdenDetaProduMaquina entity = new ProductoOrdenDetaProduMaquina();		  
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
	
	public  ProductoOrdenDetaProduMaquina getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ProductoOrdenDetaProduMaquina entity = new ProductoOrdenDetaProduMaquina();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoOrdenDetaProduMaquina();
				
				if(conMapGenerico) {
					entity.inicializarMapProductoOrdenDetaProduMaquina();
					//entity.setMapProductoOrdenDetaProduMaquina(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapProductoOrdenDetaProduMaquinaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapProductoOrdenDetaProduMaquina().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProductoOrdenDetaProduMaquinaDataAccess.ISWITHSCHEMA);         		
					entity=ProductoOrdenDetaProduMaquinaDataAccess.getEntityProductoOrdenDetaProduMaquina("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setProductoOrdenDetaProduMaquinaOriginal( new ProductoOrdenDetaProduMaquina());
					////entity.setProductoOrdenDetaProduMaquinaOriginal(super.getEntity("",entity.getProductoOrdenDetaProduMaquinaOriginal(),resultSet,ProductoOrdenDetaProduMaquinaDataAccess.ISWITHSCHEMA));         		
					////entity.setProductoOrdenDetaProduMaquinaOriginal(this.getEntityProductoOrdenDetaProduMaquina("",entity.getProductoOrdenDetaProduMaquinaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseProductoOrdenDetaProduMaquina(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoOrdenDetaProduMaquina(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ProductoOrdenDetaProduMaquina getEntityProductoOrdenDetaProduMaquina(String strPrefijo,ProductoOrdenDetaProduMaquina entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = ProductoOrdenDetaProduMaquina.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = ProductoOrdenDetaProduMaquina.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ProductoOrdenDetaProduMaquinaDataAccess.setFieldReflectionProductoOrdenDetaProduMaquina(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasProductoOrdenDetaProduMaquina=ProductoOrdenDetaProduMaquinaConstantesFunciones.getTodosTiposColumnasProductoOrdenDetaProduMaquina();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasProductoOrdenDetaProduMaquina) {
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
							field = ProductoOrdenDetaProduMaquina.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = ProductoOrdenDetaProduMaquina.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ProductoOrdenDetaProduMaquinaDataAccess.setFieldReflectionProductoOrdenDetaProduMaquina(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionProductoOrdenDetaProduMaquina(Field field,String strPrefijo,String sColumn,ProductoOrdenDetaProduMaquina entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ProductoOrdenDetaProduMaquinaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoOrdenDetaProduMaquinaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProductoOrdenDetaProduMaquinaConstantesFunciones.IDORDENDETAPRODU:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoOrdenDetaProduMaquinaConstantesFunciones.IDTIPOAREAEMPRESAPRODU:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoOrdenDetaProduMaquinaConstantesFunciones.IDTIPOPROCESOEMPRESAPRODU:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoOrdenDetaProduMaquinaConstantesFunciones.IDTIPOMAQUINAEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoOrdenDetaProduMaquinaConstantesFunciones.IDUNIDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoOrdenDetaProduMaquinaConstantesFunciones.CANTIDAD:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case ProductoOrdenDetaProduMaquinaConstantesFunciones.COSTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductoOrdenDetaProduMaquinaConstantesFunciones.COSTOTOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductoOrdenDetaProduMaquinaConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ProductoOrdenDetaProduMaquina>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<ProductoOrdenDetaProduMaquina> entities = new  ArrayList<ProductoOrdenDetaProduMaquina>();
		ProductoOrdenDetaProduMaquina entity = new ProductoOrdenDetaProduMaquina();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ProductoOrdenDetaProduMaquinaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ProductoOrdenDetaProduMaquinaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoOrdenDetaProduMaquinaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new ProductoOrdenDetaProduMaquina();
					entity=super.getEntity("",entity,resultSet,ProductoOrdenDetaProduMaquinaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityProductoOrdenDetaProduMaquina("",entity,resultSet);
					
					//entity.setProductoOrdenDetaProduMaquinaOriginal( new ProductoOrdenDetaProduMaquina());
					//entity.setProductoOrdenDetaProduMaquinaOriginal(super.getEntity("",entity.getProductoOrdenDetaProduMaquinaOriginal(),resultSet,ProductoOrdenDetaProduMaquinaDataAccess.ISWITHSCHEMA));         		
					//entity.setProductoOrdenDetaProduMaquinaOriginal(this.getEntityProductoOrdenDetaProduMaquina("",entity.getProductoOrdenDetaProduMaquinaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseProductoOrdenDetaProduMaquinas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoOrdenDetaProduMaquina(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ProductoOrdenDetaProduMaquina>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<ProductoOrdenDetaProduMaquina> entities = new  ArrayList<ProductoOrdenDetaProduMaquina>();
		ProductoOrdenDetaProduMaquina entity = new ProductoOrdenDetaProduMaquina();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ProductoOrdenDetaProduMaquinaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ProductoOrdenDetaProduMaquinaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoOrdenDetaProduMaquinaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<ProductoOrdenDetaProduMaquina> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductoOrdenDetaProduMaquina> entities = new  ArrayList<ProductoOrdenDetaProduMaquina>();
		ProductoOrdenDetaProduMaquina entity = new ProductoOrdenDetaProduMaquina();		  
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
	
	public  List<ProductoOrdenDetaProduMaquina> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductoOrdenDetaProduMaquina> entities = new  ArrayList<ProductoOrdenDetaProduMaquina>();
		ProductoOrdenDetaProduMaquina entity = new ProductoOrdenDetaProduMaquina();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoOrdenDetaProduMaquina();
      	    	entity=super.getEntity("",entity,resultSet,ProductoOrdenDetaProduMaquinaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityProductoOrdenDetaProduMaquina("",entity,resultSet);
      	    	
				//entity.setProductoOrdenDetaProduMaquinaOriginal( new ProductoOrdenDetaProduMaquina());
      	    	//entity.setProductoOrdenDetaProduMaquinaOriginal(super.getEntity("",entity.getProductoOrdenDetaProduMaquinaOriginal(),resultSet,ProductoOrdenDetaProduMaquinaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoOrdenDetaProduMaquinaOriginal(this.getEntityProductoOrdenDetaProduMaquina("",entity.getProductoOrdenDetaProduMaquinaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseProductoOrdenDetaProduMaquinas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoOrdenDetaProduMaquina(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ProductoOrdenDetaProduMaquina> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductoOrdenDetaProduMaquina> entities = new  ArrayList<ProductoOrdenDetaProduMaquina>();
		ProductoOrdenDetaProduMaquina entity = new ProductoOrdenDetaProduMaquina();		  
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
	
	public  List<ProductoOrdenDetaProduMaquina> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductoOrdenDetaProduMaquina> entities = new  ArrayList<ProductoOrdenDetaProduMaquina>();
		ProductoOrdenDetaProduMaquina entity = new ProductoOrdenDetaProduMaquina();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoOrdenDetaProduMaquina();
      	    	entity=super.getEntity("",entity,resultSet,ProductoOrdenDetaProduMaquinaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityProductoOrdenDetaProduMaquina("",entity,resultSet);
      	    	
				//entity.setProductoOrdenDetaProduMaquinaOriginal( new ProductoOrdenDetaProduMaquina());
      	    	//entity.setProductoOrdenDetaProduMaquinaOriginal(super.getEntity("",entity.getProductoOrdenDetaProduMaquinaOriginal(),resultSet,ProductoOrdenDetaProduMaquinaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoOrdenDetaProduMaquinaOriginal(this.getEntityProductoOrdenDetaProduMaquina("",entity.getProductoOrdenDetaProduMaquinaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseProductoOrdenDetaProduMaquinas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public ProductoOrdenDetaProduMaquina getEntityProductoOrdenDetaProduMaquina(String strPrefijo,ProductoOrdenDetaProduMaquina entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_orden_deta_produ(resultSet.getLong(strPrefijo+ProductoOrdenDetaProduMaquinaConstantesFunciones.IDORDENDETAPRODU));
				entity.setid_tipo_area_empresa_produ(resultSet.getLong(strPrefijo+ProductoOrdenDetaProduMaquinaConstantesFunciones.IDTIPOAREAEMPRESAPRODU));
				entity.setid_tipo_proceso_empresa_produ(resultSet.getLong(strPrefijo+ProductoOrdenDetaProduMaquinaConstantesFunciones.IDTIPOPROCESOEMPRESAPRODU));
				entity.setid_tipo_merma_empresa(resultSet.getLong(strPrefijo+ProductoOrdenDetaProduMaquinaConstantesFunciones.IDTIPOMAQUINAEMPRESA));
				entity.setid_unidad(resultSet.getLong(strPrefijo+ProductoOrdenDetaProduMaquinaConstantesFunciones.IDUNIDAD));
				entity.setcantidad(resultSet.getInt(strPrefijo+ProductoOrdenDetaProduMaquinaConstantesFunciones.CANTIDAD));
				entity.setcosto(resultSet.getDouble(strPrefijo+ProductoOrdenDetaProduMaquinaConstantesFunciones.COSTO));
				entity.setcosto_total(resultSet.getDouble(strPrefijo+ProductoOrdenDetaProduMaquinaConstantesFunciones.COSTOTOTAL));
				entity.setdescripcion(resultSet.getString(strPrefijo+ProductoOrdenDetaProduMaquinaConstantesFunciones.DESCRIPCION));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowProductoOrdenDetaProduMaquina(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(ProductoOrdenDetaProduMaquina entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ProductoOrdenDetaProduMaquinaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ProductoOrdenDetaProduMaquinaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ProductoOrdenDetaProduMaquinaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ProductoOrdenDetaProduMaquinaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ProductoOrdenDetaProduMaquinaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ProductoOrdenDetaProduMaquinaDataAccess.TABLENAME,ProductoOrdenDetaProduMaquinaDataAccess.ISWITHSTOREPROCEDURES);
			
			ProductoOrdenDetaProduMaquinaDataAccess.setProductoOrdenDetaProduMaquinaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public OrdenDetaProdu getOrdenDetaProdu(Connexion connexion,ProductoOrdenDetaProduMaquina relproductoordendetaprodumaquina)throws SQLException,Exception {

		OrdenDetaProdu ordendetaprodu= new OrdenDetaProdu();

		try {
			OrdenDetaProduDataAccess ordendetaproduDataAccess=new OrdenDetaProduDataAccess();

			ordendetaproduDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ordendetaproduDataAccess.setConnexionType(this.connexionType);
			ordendetaproduDataAccess.setParameterDbType(this.parameterDbType);

			ordendetaprodu=ordendetaproduDataAccess.getEntity(connexion,relproductoordendetaprodumaquina.getid_orden_deta_produ());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ordendetaprodu;

	}

	public TipoAreaEmpresaProdu getTipoAreaEmpresaProdu(Connexion connexion,ProductoOrdenDetaProduMaquina relproductoordendetaprodumaquina)throws SQLException,Exception {

		TipoAreaEmpresaProdu tipoareaempresaprodu= new TipoAreaEmpresaProdu();

		try {
			TipoAreaEmpresaProduDataAccess tipoareaempresaproduDataAccess=new TipoAreaEmpresaProduDataAccess();

			tipoareaempresaproduDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoareaempresaproduDataAccess.setConnexionType(this.connexionType);
			tipoareaempresaproduDataAccess.setParameterDbType(this.parameterDbType);

			tipoareaempresaprodu=tipoareaempresaproduDataAccess.getEntity(connexion,relproductoordendetaprodumaquina.getid_tipo_area_empresa_produ());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoareaempresaprodu;

	}

	public TipoProcesoEmpresaProdu getTipoProcesoEmpresaProdu(Connexion connexion,ProductoOrdenDetaProduMaquina relproductoordendetaprodumaquina)throws SQLException,Exception {

		TipoProcesoEmpresaProdu tipoprocesoempresaprodu= new TipoProcesoEmpresaProdu();

		try {
			TipoProcesoEmpresaProduDataAccess tipoprocesoempresaproduDataAccess=new TipoProcesoEmpresaProduDataAccess();

			tipoprocesoempresaproduDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoprocesoempresaproduDataAccess.setConnexionType(this.connexionType);
			tipoprocesoempresaproduDataAccess.setParameterDbType(this.parameterDbType);

			tipoprocesoempresaprodu=tipoprocesoempresaproduDataAccess.getEntity(connexion,relproductoordendetaprodumaquina.getid_tipo_proceso_empresa_produ());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoprocesoempresaprodu;

	}

	public TipoMaquinaEmpresa getTipoMaquinaEmpresa(Connexion connexion,ProductoOrdenDetaProduMaquina relproductoordendetaprodumaquina)throws SQLException,Exception {

		TipoMaquinaEmpresa tipomaquinaempresa= new TipoMaquinaEmpresa();

		try {
			TipoMaquinaEmpresaDataAccess tipomaquinaempresaDataAccess=new TipoMaquinaEmpresaDataAccess();

			tipomaquinaempresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipomaquinaempresaDataAccess.setConnexionType(this.connexionType);
			tipomaquinaempresaDataAccess.setParameterDbType(this.parameterDbType);

			tipomaquinaempresa=tipomaquinaempresaDataAccess.getEntity(connexion,relproductoordendetaprodumaquina.getid_tipo_merma_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipomaquinaempresa;

	}

	public Unidad getUnidad(Connexion connexion,ProductoOrdenDetaProduMaquina relproductoordendetaprodumaquina)throws SQLException,Exception {

		Unidad unidad= new Unidad();

		try {
			UnidadDataAccess unidadDataAccess=new UnidadDataAccess();

			unidadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			unidadDataAccess.setConnexionType(this.connexionType);
			unidadDataAccess.setParameterDbType(this.parameterDbType);

			unidad=unidadDataAccess.getEntity(connexion,relproductoordendetaprodumaquina.getid_unidad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return unidad;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,ProductoOrdenDetaProduMaquina productoordendetaprodumaquina) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!productoordendetaprodumaquina.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_orden_deta_produ=new ParameterValue<Long>();
					parameterMaintenanceValueid_orden_deta_produ.setValue(productoordendetaprodumaquina.getid_orden_deta_produ());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_orden_deta_produ);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_area_empresa_produ=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_area_empresa_produ.setValue(productoordendetaprodumaquina.getid_tipo_area_empresa_produ());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_area_empresa_produ);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_proceso_empresa_produ=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_proceso_empresa_produ.setValue(productoordendetaprodumaquina.getid_tipo_proceso_empresa_produ());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_proceso_empresa_produ);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_merma_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_merma_empresa.setValue(productoordendetaprodumaquina.getid_tipo_merma_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_merma_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_unidad=new ParameterValue<Long>();
					parameterMaintenanceValueid_unidad.setValue(productoordendetaprodumaquina.getid_unidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_unidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuecantidad=new ParameterValue<Integer>();
					parameterMaintenanceValuecantidad.setValue(productoordendetaprodumaquina.getcantidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecantidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecosto=new ParameterValue<Double>();
					parameterMaintenanceValuecosto.setValue(productoordendetaprodumaquina.getcosto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecosto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecosto_total=new ParameterValue<Double>();
					parameterMaintenanceValuecosto_total.setValue(productoordendetaprodumaquina.getcosto_total());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecosto_total);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(productoordendetaprodumaquina.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!productoordendetaprodumaquina.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(productoordendetaprodumaquina.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(productoordendetaprodumaquina.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(productoordendetaprodumaquina.getId());
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
	
	public void setIsNewIsChangedFalseProductoOrdenDetaProduMaquina(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina)throws Exception  {		
		productoordendetaprodumaquina.setIsNew(false);
		productoordendetaprodumaquina.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseProductoOrdenDetaProduMaquinas(List<ProductoOrdenDetaProduMaquina> productoordendetaprodumaquinas)throws Exception  {				
		for(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina:productoordendetaprodumaquinas) {
			productoordendetaprodumaquina.setIsNew(false);
			productoordendetaprodumaquina.setIsChanged(false);
		}
	}
	
	public void generarExportarProductoOrdenDetaProduMaquina(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
