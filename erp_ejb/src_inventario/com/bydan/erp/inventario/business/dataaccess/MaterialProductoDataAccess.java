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
import com.bydan.erp.inventario.util.*;//MaterialProductoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;




@SuppressWarnings("unused")
final public class MaterialProductoDataAccess extends  MaterialProductoDataAccessAdditional{ //MaterialProductoDataAccessAdditional,DataAccessHelper<MaterialProducto>
	//static Logger logger = Logger.getLogger(MaterialProductoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="material_producto";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+MaterialProductoConstantesFunciones.SCHEMA+"."+MaterialProductoConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_tipo_producto,codigo,nombre)values(current_timestamp,?,?,?,?)";
	public static String QUERYUPDATE="update "+MaterialProductoConstantesFunciones.SCHEMA+"."+MaterialProductoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_tipo_producto=?,codigo=?,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+MaterialProductoConstantesFunciones.SCHEMA+"."+MaterialProductoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select materialproducto from "+MaterialProductoConstantesFunciones.SPERSISTENCENAME+" materialproducto";
	public static String QUERYSELECTNATIVE="select "+MaterialProductoConstantesFunciones.SCHEMA+"."+MaterialProductoConstantesFunciones.TABLENAME+".id,"+MaterialProductoConstantesFunciones.SCHEMA+"."+MaterialProductoConstantesFunciones.TABLENAME+".version_row,"+MaterialProductoConstantesFunciones.SCHEMA+"."+MaterialProductoConstantesFunciones.TABLENAME+".id_empresa,"+MaterialProductoConstantesFunciones.SCHEMA+"."+MaterialProductoConstantesFunciones.TABLENAME+".id_tipo_producto,"+MaterialProductoConstantesFunciones.SCHEMA+"."+MaterialProductoConstantesFunciones.TABLENAME+".codigo,"+MaterialProductoConstantesFunciones.SCHEMA+"."+MaterialProductoConstantesFunciones.TABLENAME+".nombre from "+MaterialProductoConstantesFunciones.SCHEMA+"."+MaterialProductoConstantesFunciones.TABLENAME;//+" as "+MaterialProductoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+MaterialProductoConstantesFunciones.SCHEMA+"."+MaterialProductoConstantesFunciones.TABLENAME+".id,"+MaterialProductoConstantesFunciones.SCHEMA+"."+MaterialProductoConstantesFunciones.TABLENAME+".version_row,"+MaterialProductoConstantesFunciones.SCHEMA+"."+MaterialProductoConstantesFunciones.TABLENAME+".codigo from "+MaterialProductoConstantesFunciones.SCHEMA+"."+MaterialProductoConstantesFunciones.TABLENAME;//+" as "+MaterialProductoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+MaterialProductoConstantesFunciones.SCHEMA+"."+MaterialProductoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_tipo_producto=?,codigo=?,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_MATERIALPRODUCTO_INSERT(?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_MATERIALPRODUCTO_UPDATE(?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_MATERIALPRODUCTO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_MATERIALPRODUCTO_SELECT(?,?)";
	
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
	
	
	protected MaterialProductoDataAccessAdditional materialproductoDataAccessAdditional=null;
	
	public MaterialProductoDataAccessAdditional getMaterialProductoDataAccessAdditional() {
		return this.materialproductoDataAccessAdditional;
	}
	
	public void setMaterialProductoDataAccessAdditional(MaterialProductoDataAccessAdditional materialproductoDataAccessAdditional) {
		try {
			this.materialproductoDataAccessAdditional=materialproductoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public MaterialProductoDataAccess() {
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
		MaterialProductoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		MaterialProductoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		MaterialProductoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setMaterialProductoOriginal(MaterialProducto materialproducto)throws Exception  {
		materialproducto.setMaterialProductoOriginal((MaterialProducto)materialproducto.clone());		
	}
	
	public void setMaterialProductosOriginal(List<MaterialProducto> materialproductos)throws Exception  {
		
		for(MaterialProducto materialproducto:materialproductos){
			materialproducto.setMaterialProductoOriginal((MaterialProducto)materialproducto.clone());
		}
	}
	
	public static void setMaterialProductoOriginalStatic(MaterialProducto materialproducto)throws Exception  {
		materialproducto.setMaterialProductoOriginal((MaterialProducto)materialproducto.clone());		
	}
	
	public static void setMaterialProductosOriginalStatic(List<MaterialProducto> materialproductos)throws Exception  {
		
		for(MaterialProducto materialproducto:materialproductos){
			materialproducto.setMaterialProductoOriginal((MaterialProducto)materialproducto.clone());
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
	
	public  MaterialProducto getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		MaterialProducto entity = new MaterialProducto();		
		
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
	
	public  MaterialProducto getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		MaterialProducto entity = new MaterialProducto();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=MaterialProductoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=MaterialProductoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.MaterialProducto.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setMaterialProductoOriginal(new MaterialProducto());
      	    	entity=super.getEntity("",entity,resultSet,MaterialProductoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityMaterialProducto("",entity,resultSet); 
				
				//entity.setMaterialProductoOriginal(super.getEntity("",entity.getMaterialProductoOriginal(),resultSet,MaterialProductoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setMaterialProductoOriginal(this.getEntityMaterialProducto("",entity.getMaterialProductoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseMaterialProducto(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  MaterialProducto getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		MaterialProducto entity = new MaterialProducto();
				
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
	
	public  MaterialProducto getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		MaterialProducto entity = new MaterialProducto();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=MaterialProductoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=MaterialProductoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,MaterialProductoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.MaterialProducto.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setMaterialProductoOriginal(new MaterialProducto());
      	    	entity=super.getEntity("",entity,resultSet,MaterialProductoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityMaterialProducto("",entity,resultSet);    
				
				//entity.setMaterialProductoOriginal(super.getEntity("",entity.getMaterialProductoOriginal(),resultSet,MaterialProductoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setMaterialProductoOriginal(this.getEntityMaterialProducto("",entity.getMaterialProductoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseMaterialProducto(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //MaterialProducto
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		MaterialProducto entity = new MaterialProducto();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=MaterialProductoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=MaterialProductoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,MaterialProductoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.MaterialProducto.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseMaterialProducto(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<MaterialProducto> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<MaterialProducto> entities = new  ArrayList<MaterialProducto>();
		MaterialProducto entity = new MaterialProducto();		  
		
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
	
	public  List<MaterialProducto> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<MaterialProducto> entities = new  ArrayList<MaterialProducto>();
		MaterialProducto entity = new MaterialProducto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=MaterialProductoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=MaterialProductoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,MaterialProductoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new MaterialProducto();
      	    	entity=super.getEntity("",entity,resultSet,MaterialProductoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityMaterialProducto("",entity,resultSet);
      	    	
				//entity.setMaterialProductoOriginal( new MaterialProducto());
      	    	//entity.setMaterialProductoOriginal(super.getEntity("",entity.getMaterialProductoOriginal(),resultSet,MaterialProductoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setMaterialProductoOriginal(this.getEntityMaterialProducto("",entity.getMaterialProductoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseMaterialProductos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarMaterialProducto(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<MaterialProducto> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<MaterialProducto> entities = new  ArrayList<MaterialProducto>();
		MaterialProducto entity = new MaterialProducto();		  
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
	
	public  List<MaterialProducto> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<MaterialProducto> entities = new  ArrayList<MaterialProducto>();
		MaterialProducto entity = new MaterialProducto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new MaterialProducto();
				
				if(conMapGenerico) {
					entity.inicializarMapMaterialProducto();
					//entity.setMapMaterialProducto(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapMaterialProductoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapMaterialProducto().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,MaterialProductoDataAccess.ISWITHSCHEMA);         		
					entity=MaterialProductoDataAccess.getEntityMaterialProducto("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setMaterialProductoOriginal( new MaterialProducto());
					////entity.setMaterialProductoOriginal(super.getEntity("",entity.getMaterialProductoOriginal(),resultSet,MaterialProductoDataAccess.ISWITHSCHEMA));         		
					////entity.setMaterialProductoOriginal(this.getEntityMaterialProducto("",entity.getMaterialProductoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseMaterialProductos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarMaterialProducto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public MaterialProducto getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		MaterialProducto entity = new MaterialProducto();		  
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
	
	public  MaterialProducto getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		MaterialProducto entity = new MaterialProducto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new MaterialProducto();
				
				if(conMapGenerico) {
					entity.inicializarMapMaterialProducto();
					//entity.setMapMaterialProducto(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapMaterialProductoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapMaterialProducto().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,MaterialProductoDataAccess.ISWITHSCHEMA);         		
					entity=MaterialProductoDataAccess.getEntityMaterialProducto("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setMaterialProductoOriginal( new MaterialProducto());
					////entity.setMaterialProductoOriginal(super.getEntity("",entity.getMaterialProductoOriginal(),resultSet,MaterialProductoDataAccess.ISWITHSCHEMA));         		
					////entity.setMaterialProductoOriginal(this.getEntityMaterialProducto("",entity.getMaterialProductoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseMaterialProducto(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarMaterialProducto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static MaterialProducto getEntityMaterialProducto(String strPrefijo,MaterialProducto entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = MaterialProducto.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = MaterialProducto.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					MaterialProductoDataAccess.setFieldReflectionMaterialProducto(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasMaterialProducto=MaterialProductoConstantesFunciones.getTodosTiposColumnasMaterialProducto();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasMaterialProducto) {
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
							field = MaterialProducto.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = MaterialProducto.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						MaterialProductoDataAccess.setFieldReflectionMaterialProducto(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionMaterialProducto(Field field,String strPrefijo,String sColumn,MaterialProducto entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case MaterialProductoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case MaterialProductoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case MaterialProductoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case MaterialProductoConstantesFunciones.IDTIPOPRODUCTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case MaterialProductoConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case MaterialProductoConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<MaterialProducto>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<MaterialProducto> entities = new  ArrayList<MaterialProducto>();
		MaterialProducto entity = new MaterialProducto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=MaterialProductoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=MaterialProductoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,MaterialProductoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new MaterialProducto();
					entity=super.getEntity("",entity,resultSet,MaterialProductoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityMaterialProducto("",entity,resultSet);
					
					//entity.setMaterialProductoOriginal( new MaterialProducto());
					//entity.setMaterialProductoOriginal(super.getEntity("",entity.getMaterialProductoOriginal(),resultSet,MaterialProductoDataAccess.ISWITHSCHEMA));         		
					//entity.setMaterialProductoOriginal(this.getEntityMaterialProducto("",entity.getMaterialProductoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseMaterialProductos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarMaterialProducto(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<MaterialProducto>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<MaterialProducto> entities = new  ArrayList<MaterialProducto>();
		MaterialProducto entity = new MaterialProducto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=MaterialProductoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=MaterialProductoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,MaterialProductoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<MaterialProducto> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<MaterialProducto> entities = new  ArrayList<MaterialProducto>();
		MaterialProducto entity = new MaterialProducto();		  
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
	
	public  List<MaterialProducto> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<MaterialProducto> entities = new  ArrayList<MaterialProducto>();
		MaterialProducto entity = new MaterialProducto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new MaterialProducto();
      	    	entity=super.getEntity("",entity,resultSet,MaterialProductoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityMaterialProducto("",entity,resultSet);
      	    	
				//entity.setMaterialProductoOriginal( new MaterialProducto());
      	    	//entity.setMaterialProductoOriginal(super.getEntity("",entity.getMaterialProductoOriginal(),resultSet,MaterialProductoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setMaterialProductoOriginal(this.getEntityMaterialProducto("",entity.getMaterialProductoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseMaterialProductos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarMaterialProducto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<MaterialProducto> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<MaterialProducto> entities = new  ArrayList<MaterialProducto>();
		MaterialProducto entity = new MaterialProducto();		  
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
	
	public  List<MaterialProducto> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<MaterialProducto> entities = new  ArrayList<MaterialProducto>();
		MaterialProducto entity = new MaterialProducto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new MaterialProducto();
      	    	entity=super.getEntity("",entity,resultSet,MaterialProductoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityMaterialProducto("",entity,resultSet);
      	    	
				//entity.setMaterialProductoOriginal( new MaterialProducto());
      	    	//entity.setMaterialProductoOriginal(super.getEntity("",entity.getMaterialProductoOriginal(),resultSet,MaterialProductoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setMaterialProductoOriginal(this.getEntityMaterialProducto("",entity.getMaterialProductoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseMaterialProductos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public MaterialProducto getEntityMaterialProducto(String strPrefijo,MaterialProducto entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+MaterialProductoConstantesFunciones.IDEMPRESA));
				entity.setid_tipo_producto(resultSet.getLong(strPrefijo+MaterialProductoConstantesFunciones.IDTIPOPRODUCTO));
				entity.setcodigo(resultSet.getString(strPrefijo+MaterialProductoConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+MaterialProductoConstantesFunciones.NOMBRE));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+MaterialProductoConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowMaterialProducto(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(MaterialProducto entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=MaterialProductoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=MaterialProductoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=MaterialProductoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=MaterialProductoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(MaterialProductoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,MaterialProductoDataAccess.TABLENAME,MaterialProductoDataAccess.ISWITHSTOREPROCEDURES);
			
			MaterialProductoDataAccess.setMaterialProductoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,MaterialProducto relmaterialproducto)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relmaterialproducto.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public TipoProducto getTipoProducto(Connexion connexion,MaterialProducto relmaterialproducto)throws SQLException,Exception {

		TipoProducto tipoproducto= new TipoProducto();

		try {
			TipoProductoDataAccess tipoproductoDataAccess=new TipoProductoDataAccess();

			tipoproductoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoproductoDataAccess.setConnexionType(this.connexionType);
			tipoproductoDataAccess.setParameterDbType(this.parameterDbType);

			tipoproducto=tipoproductoDataAccess.getEntity(connexion,relmaterialproducto.getid_tipo_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoproducto;

	}


		
		public List<Producto> getProductos(Connexion connexion,MaterialProducto materialproducto)throws SQLException,Exception {

		List<Producto> productos= new ArrayList<Producto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+MaterialProductoConstantesFunciones.SCHEMA+".material_producto ON "+ProductoConstantesFunciones.SCHEMA+".producto.id_material_producto="+MaterialProductoConstantesFunciones.SCHEMA+".material_producto.id WHERE "+MaterialProductoConstantesFunciones.SCHEMA+".material_producto.id="+String.valueOf(materialproducto.getId());
			} else {
				sQuery=" INNER JOIN producto.MaterialProducto WHERE producto.MaterialProducto.id="+String.valueOf(materialproducto.getId());

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

	public List<ParametroInventarioDefecto> getParametroInventarioDefectos(Connexion connexion,MaterialProducto materialproducto)throws SQLException,Exception {

		List<ParametroInventarioDefecto> parametroinventariodefectos= new ArrayList<ParametroInventarioDefecto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+MaterialProductoConstantesFunciones.SCHEMA+".material_producto ON "+ParametroInventarioDefectoConstantesFunciones.SCHEMA+".parametro_inventario_defecto.id_material_producto="+MaterialProductoConstantesFunciones.SCHEMA+".material_producto.id WHERE "+MaterialProductoConstantesFunciones.SCHEMA+".material_producto.id="+String.valueOf(materialproducto.getId());
			} else {
				sQuery=" INNER JOIN parametroinventariodefecto.MaterialProducto WHERE parametroinventariodefecto.MaterialProducto.id="+String.valueOf(materialproducto.getId());

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


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,MaterialProducto materialproducto) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!materialproducto.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(materialproducto.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_producto=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_producto.setValue(materialproducto.getid_tipo_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_producto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(materialproducto.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(materialproducto.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!materialproducto.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(materialproducto.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(materialproducto.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(materialproducto.getId());
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
	
	public void setIsNewIsChangedFalseMaterialProducto(MaterialProducto materialproducto)throws Exception  {		
		materialproducto.setIsNew(false);
		materialproducto.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseMaterialProductos(List<MaterialProducto> materialproductos)throws Exception  {				
		for(MaterialProducto materialproducto:materialproductos) {
			materialproducto.setIsNew(false);
			materialproducto.setIsChanged(false);
		}
	}
	
	public void generarExportarMaterialProducto(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
