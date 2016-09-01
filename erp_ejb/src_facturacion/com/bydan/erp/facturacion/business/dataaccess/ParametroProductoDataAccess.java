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
import com.bydan.framework.erp.business.dataaccess.DataAccessHelper;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.facturacion.util.*;//ParametroProductoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;




@SuppressWarnings("unused")
final public class ParametroProductoDataAccess extends  ParametroProductoDataAccessAdditional{ //ParametroProductoDataAccessAdditional,DataAccessHelper<ParametroProducto>
	//static Logger logger = Logger.getLogger(ParametroProductoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="parametro_producto";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ParametroProductoConstantesFunciones.SCHEMA+"."+ParametroProductoConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_modulo,id_transaccion,id_tipo_transaccion_modulo,id_bodega,id_producto,id_formato,descripcion)values(current_timestamp,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+ParametroProductoConstantesFunciones.SCHEMA+"."+ParametroProductoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_modulo=?,id_transaccion=?,id_tipo_transaccion_modulo=?,id_bodega=?,id_producto=?,id_formato=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ParametroProductoConstantesFunciones.SCHEMA+"."+ParametroProductoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select parametroproducto from "+ParametroProductoConstantesFunciones.SPERSISTENCENAME+" parametroproducto";
	public static String QUERYSELECTNATIVE="select "+ParametroProductoConstantesFunciones.SCHEMA+"."+ParametroProductoConstantesFunciones.TABLENAME+".id,"+ParametroProductoConstantesFunciones.SCHEMA+"."+ParametroProductoConstantesFunciones.TABLENAME+".version_row,"+ParametroProductoConstantesFunciones.SCHEMA+"."+ParametroProductoConstantesFunciones.TABLENAME+".id_empresa,"+ParametroProductoConstantesFunciones.SCHEMA+"."+ParametroProductoConstantesFunciones.TABLENAME+".id_sucursal,"+ParametroProductoConstantesFunciones.SCHEMA+"."+ParametroProductoConstantesFunciones.TABLENAME+".id_modulo,"+ParametroProductoConstantesFunciones.SCHEMA+"."+ParametroProductoConstantesFunciones.TABLENAME+".id_transaccion,"+ParametroProductoConstantesFunciones.SCHEMA+"."+ParametroProductoConstantesFunciones.TABLENAME+".id_tipo_transaccion_modulo,"+ParametroProductoConstantesFunciones.SCHEMA+"."+ParametroProductoConstantesFunciones.TABLENAME+".id_bodega,"+ParametroProductoConstantesFunciones.SCHEMA+"."+ParametroProductoConstantesFunciones.TABLENAME+".id_producto,"+ParametroProductoConstantesFunciones.SCHEMA+"."+ParametroProductoConstantesFunciones.TABLENAME+".id_formato,"+ParametroProductoConstantesFunciones.SCHEMA+"."+ParametroProductoConstantesFunciones.TABLENAME+".descripcion from "+ParametroProductoConstantesFunciones.SCHEMA+"."+ParametroProductoConstantesFunciones.TABLENAME;//+" as "+ParametroProductoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ParametroProductoConstantesFunciones.SCHEMA+"."+ParametroProductoConstantesFunciones.TABLENAME+".id,"+ParametroProductoConstantesFunciones.SCHEMA+"."+ParametroProductoConstantesFunciones.TABLENAME+".version_row from "+ParametroProductoConstantesFunciones.SCHEMA+"."+ParametroProductoConstantesFunciones.TABLENAME;//+" as "+ParametroProductoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ParametroProductoConstantesFunciones.SCHEMA+"."+ParametroProductoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_modulo=?,id_transaccion=?,id_tipo_transaccion_modulo=?,id_bodega=?,id_producto=?,id_formato=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PARAMETROPRODUCTO_INSERT(?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PARAMETROPRODUCTO_UPDATE(?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PARAMETROPRODUCTO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PARAMETROPRODUCTO_SELECT(?,?)";
	
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
	
	
	protected ParametroProductoDataAccessAdditional parametroproductoDataAccessAdditional=null;
	
	public ParametroProductoDataAccessAdditional getParametroProductoDataAccessAdditional() {
		return this.parametroproductoDataAccessAdditional;
	}
	
	public void setParametroProductoDataAccessAdditional(ParametroProductoDataAccessAdditional parametroproductoDataAccessAdditional) {
		try {
			this.parametroproductoDataAccessAdditional=parametroproductoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ParametroProductoDataAccess() {
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
		ParametroProductoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ParametroProductoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ParametroProductoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setParametroProductoOriginal(ParametroProducto parametroproducto)throws Exception  {
		parametroproducto.setParametroProductoOriginal((ParametroProducto)parametroproducto.clone());		
	}
	
	public void setParametroProductosOriginal(List<ParametroProducto> parametroproductos)throws Exception  {
		
		for(ParametroProducto parametroproducto:parametroproductos){
			parametroproducto.setParametroProductoOriginal((ParametroProducto)parametroproducto.clone());
		}
	}
	
	public static void setParametroProductoOriginalStatic(ParametroProducto parametroproducto)throws Exception  {
		parametroproducto.setParametroProductoOriginal((ParametroProducto)parametroproducto.clone());		
	}
	
	public static void setParametroProductosOriginalStatic(List<ParametroProducto> parametroproductos)throws Exception  {
		
		for(ParametroProducto parametroproducto:parametroproductos){
			parametroproducto.setParametroProductoOriginal((ParametroProducto)parametroproducto.clone());
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
	
	public  ParametroProducto getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		ParametroProducto entity = new ParametroProducto();		
		
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
	
	public  ParametroProducto getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		ParametroProducto entity = new ParametroProducto();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroProductoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroProductoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Facturacion.ParametroProducto.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setParametroProductoOriginal(new ParametroProducto());
      	    	entity=super.getEntity("",entity,resultSet,ParametroProductoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityParametroProducto("",entity,resultSet); 
				
				//entity.setParametroProductoOriginal(super.getEntity("",entity.getParametroProductoOriginal(),resultSet,ParametroProductoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroProductoOriginal(this.getEntityParametroProducto("",entity.getParametroProductoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseParametroProducto(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  ParametroProducto getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ParametroProducto entity = new ParametroProducto();
				
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
	
	public  ParametroProducto getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ParametroProducto entity = new ParametroProducto();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroProductoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroProductoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroProductoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.ParametroProducto.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setParametroProductoOriginal(new ParametroProducto());
      	    	entity=super.getEntity("",entity,resultSet,ParametroProductoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityParametroProducto("",entity,resultSet);    
				
				//entity.setParametroProductoOriginal(super.getEntity("",entity.getParametroProductoOriginal(),resultSet,ParametroProductoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroProductoOriginal(this.getEntityParametroProducto("",entity.getParametroProductoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseParametroProducto(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //ParametroProducto
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		ParametroProducto entity = new ParametroProducto();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroProductoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroProductoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroProductoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.ParametroProducto.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseParametroProducto(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<ParametroProducto> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ParametroProducto> entities = new  ArrayList<ParametroProducto>();
		ParametroProducto entity = new ParametroProducto();		  
		
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
	
	public  List<ParametroProducto> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ParametroProducto> entities = new  ArrayList<ParametroProducto>();
		ParametroProducto entity = new ParametroProducto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroProductoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroProductoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroProductoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroProducto();
      	    	entity=super.getEntity("",entity,resultSet,ParametroProductoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroProducto("",entity,resultSet);
      	    	
				//entity.setParametroProductoOriginal( new ParametroProducto());
      	    	//entity.setParametroProductoOriginal(super.getEntity("",entity.getParametroProductoOriginal(),resultSet,ParametroProductoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroProductoOriginal(this.getEntityParametroProducto("",entity.getParametroProductoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroProductos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroProducto(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ParametroProducto> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ParametroProducto> entities = new  ArrayList<ParametroProducto>();
		ParametroProducto entity = new ParametroProducto();		  
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
	
	public  List<ParametroProducto> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ParametroProducto> entities = new  ArrayList<ParametroProducto>();
		ParametroProducto entity = new ParametroProducto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroProducto();
				
				if(conMapGenerico) {
					entity.inicializarMapParametroProducto();
					//entity.setMapParametroProducto(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapParametroProductoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapParametroProducto().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ParametroProductoDataAccess.ISWITHSCHEMA);         		
					entity=ParametroProductoDataAccess.getEntityParametroProducto("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setParametroProductoOriginal( new ParametroProducto());
					////entity.setParametroProductoOriginal(super.getEntity("",entity.getParametroProductoOriginal(),resultSet,ParametroProductoDataAccess.ISWITHSCHEMA));         		
					////entity.setParametroProductoOriginal(this.getEntityParametroProducto("",entity.getParametroProductoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroProductos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroProducto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public ParametroProducto getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ParametroProducto entity = new ParametroProducto();		  
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
	
	public  ParametroProducto getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ParametroProducto entity = new ParametroProducto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroProducto();
				
				if(conMapGenerico) {
					entity.inicializarMapParametroProducto();
					//entity.setMapParametroProducto(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapParametroProductoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapParametroProducto().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ParametroProductoDataAccess.ISWITHSCHEMA);         		
					entity=ParametroProductoDataAccess.getEntityParametroProducto("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setParametroProductoOriginal( new ParametroProducto());
					////entity.setParametroProductoOriginal(super.getEntity("",entity.getParametroProductoOriginal(),resultSet,ParametroProductoDataAccess.ISWITHSCHEMA));         		
					////entity.setParametroProductoOriginal(this.getEntityParametroProducto("",entity.getParametroProductoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseParametroProducto(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroProducto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ParametroProducto getEntityParametroProducto(String strPrefijo,ParametroProducto entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = ParametroProducto.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = ParametroProducto.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ParametroProductoDataAccess.setFieldReflectionParametroProducto(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasParametroProducto=ParametroProductoConstantesFunciones.getTodosTiposColumnasParametroProducto();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasParametroProducto) {
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
							field = ParametroProducto.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = ParametroProducto.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ParametroProductoDataAccess.setFieldReflectionParametroProducto(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionParametroProducto(Field field,String strPrefijo,String sColumn,ParametroProducto entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ParametroProductoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroProductoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ParametroProductoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroProductoConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroProductoConstantesFunciones.IDMODULO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroProductoConstantesFunciones.IDTRANSACCION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroProductoConstantesFunciones.IDTIPOTRANSACCIONMODULO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroProductoConstantesFunciones.IDBODEGA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroProductoConstantesFunciones.IDPRODUCTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroProductoConstantesFunciones.IDFORMATO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroProductoConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ParametroProducto>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<ParametroProducto> entities = new  ArrayList<ParametroProducto>();
		ParametroProducto entity = new ParametroProducto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroProductoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroProductoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroProductoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new ParametroProducto();
					entity=super.getEntity("",entity,resultSet,ParametroProductoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityParametroProducto("",entity,resultSet);
					
					//entity.setParametroProductoOriginal( new ParametroProducto());
					//entity.setParametroProductoOriginal(super.getEntity("",entity.getParametroProductoOriginal(),resultSet,ParametroProductoDataAccess.ISWITHSCHEMA));         		
					//entity.setParametroProductoOriginal(this.getEntityParametroProducto("",entity.getParametroProductoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseParametroProductos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroProducto(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ParametroProducto>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<ParametroProducto> entities = new  ArrayList<ParametroProducto>();
		ParametroProducto entity = new ParametroProducto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroProductoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroProductoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroProductoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<ParametroProducto> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroProducto> entities = new  ArrayList<ParametroProducto>();
		ParametroProducto entity = new ParametroProducto();		  
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
	
	public  List<ParametroProducto> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroProducto> entities = new  ArrayList<ParametroProducto>();
		ParametroProducto entity = new ParametroProducto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroProducto();
      	    	entity=super.getEntity("",entity,resultSet,ParametroProductoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroProducto("",entity,resultSet);
      	    	
				//entity.setParametroProductoOriginal( new ParametroProducto());
      	    	//entity.setParametroProductoOriginal(super.getEntity("",entity.getParametroProductoOriginal(),resultSet,ParametroProductoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroProductoOriginal(this.getEntityParametroProducto("",entity.getParametroProductoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseParametroProductos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroProducto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ParametroProducto> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroProducto> entities = new  ArrayList<ParametroProducto>();
		ParametroProducto entity = new ParametroProducto();		  
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
	
	public  List<ParametroProducto> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroProducto> entities = new  ArrayList<ParametroProducto>();
		ParametroProducto entity = new ParametroProducto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroProducto();
      	    	entity=super.getEntity("",entity,resultSet,ParametroProductoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroProducto("",entity,resultSet);
      	    	
				//entity.setParametroProductoOriginal( new ParametroProducto());
      	    	//entity.setParametroProductoOriginal(super.getEntity("",entity.getParametroProductoOriginal(),resultSet,ParametroProductoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroProductoOriginal(this.getEntityParametroProducto("",entity.getParametroProductoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroProductos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public ParametroProducto getEntityParametroProducto(String strPrefijo,ParametroProducto entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+ParametroProductoConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+ParametroProductoConstantesFunciones.IDSUCURSAL));
				entity.setid_modulo(resultSet.getLong(strPrefijo+ParametroProductoConstantesFunciones.IDMODULO));
				entity.setid_transaccion(resultSet.getLong(strPrefijo+ParametroProductoConstantesFunciones.IDTRANSACCION));
				entity.setid_tipo_transaccion_modulo(resultSet.getLong(strPrefijo+ParametroProductoConstantesFunciones.IDTIPOTRANSACCIONMODULO));if(resultSet.wasNull()) {entity.setid_tipo_transaccion_modulo(null); }
				entity.setid_bodega(resultSet.getLong(strPrefijo+ParametroProductoConstantesFunciones.IDBODEGA));
				entity.setid_producto(resultSet.getLong(strPrefijo+ParametroProductoConstantesFunciones.IDPRODUCTO));
				entity.setid_formato(resultSet.getLong(strPrefijo+ParametroProductoConstantesFunciones.IDFORMATO));if(resultSet.wasNull()) {entity.setid_formato(null); }
				entity.setdescripcion(resultSet.getString(strPrefijo+ParametroProductoConstantesFunciones.DESCRIPCION));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowParametroProducto(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(ParametroProducto entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ParametroProductoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ParametroProductoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ParametroProductoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ParametroProductoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ParametroProductoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ParametroProductoDataAccess.TABLENAME,ParametroProductoDataAccess.ISWITHSTOREPROCEDURES);
			
			ParametroProductoDataAccess.setParametroProductoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,ParametroProducto relparametroproducto)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relparametroproducto.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,ParametroProducto relparametroproducto)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relparametroproducto.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Modulo getModulo(Connexion connexion,ParametroProducto relparametroproducto)throws SQLException,Exception {

		Modulo modulo= new Modulo();

		try {
			ModuloDataAccess moduloDataAccess=new ModuloDataAccess();

			moduloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			moduloDataAccess.setConnexionType(this.connexionType);
			moduloDataAccess.setParameterDbType(this.parameterDbType);

			modulo=moduloDataAccess.getEntity(connexion,relparametroproducto.getid_modulo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return modulo;

	}

	public Transaccion getTransaccion(Connexion connexion,ParametroProducto relparametroproducto)throws SQLException,Exception {

		Transaccion transaccion= new Transaccion();

		try {
			TransaccionDataAccess transaccionDataAccess=new TransaccionDataAccess();

			transaccionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transaccionDataAccess.setConnexionType(this.connexionType);
			transaccionDataAccess.setParameterDbType(this.parameterDbType);

			transaccion=transaccionDataAccess.getEntity(connexion,relparametroproducto.getid_transaccion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccion;

	}

	public TipoTransaccionModulo getTipoTransaccionModulo(Connexion connexion,ParametroProducto relparametroproducto)throws SQLException,Exception {

		TipoTransaccionModulo tipotransaccionmodulo= new TipoTransaccionModulo();

		try {
			TipoTransaccionModuloDataAccess tipotransaccionmoduloDataAccess=new TipoTransaccionModuloDataAccess();

			tipotransaccionmoduloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipotransaccionmoduloDataAccess.setConnexionType(this.connexionType);
			tipotransaccionmoduloDataAccess.setParameterDbType(this.parameterDbType);

			tipotransaccionmodulo=tipotransaccionmoduloDataAccess.getEntity(connexion,relparametroproducto.getid_tipo_transaccion_modulo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipotransaccionmodulo;

	}

	public Bodega getBodega(Connexion connexion,ParametroProducto relparametroproducto)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);

			bodega=bodegaDataAccess.getEntity(connexion,relparametroproducto.getid_bodega());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}

	public Producto getProducto(Connexion connexion,ParametroProducto relparametroproducto)throws SQLException,Exception {

		Producto producto= new Producto();

		try {
			ProductoDataAccess productoDataAccess=new ProductoDataAccess();

			productoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			productoDataAccess.setConnexionType(this.connexionType);
			productoDataAccess.setParameterDbType(this.parameterDbType);

			producto=productoDataAccess.getEntity(connexion,relparametroproducto.getid_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return producto;

	}

	public Formato getFormato(Connexion connexion,ParametroProducto relparametroproducto)throws SQLException,Exception {

		Formato formato= new Formato();

		try {
			FormatoDataAccess formatoDataAccess=new FormatoDataAccess();

			formatoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			formatoDataAccess.setConnexionType(this.connexionType);
			formatoDataAccess.setParameterDbType(this.parameterDbType);

			formato=formatoDataAccess.getEntity(connexion,relparametroproducto.getid_formato());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formato;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,ParametroProducto parametroproducto) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!parametroproducto.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(parametroproducto.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(parametroproducto.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_modulo=new ParameterValue<Long>();
					parameterMaintenanceValueid_modulo.setValue(parametroproducto.getid_modulo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_modulo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transaccion=new ParameterValue<Long>();
					parameterMaintenanceValueid_transaccion.setValue(parametroproducto.getid_transaccion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transaccion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_transaccion_modulo=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_transaccion_modulo.setValue(parametroproducto.getid_tipo_transaccion_modulo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_transaccion_modulo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_bodega=new ParameterValue<Long>();
					parameterMaintenanceValueid_bodega.setValue(parametroproducto.getid_bodega());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_bodega);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_producto=new ParameterValue<Long>();
					parameterMaintenanceValueid_producto.setValue(parametroproducto.getid_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_producto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_formato=new ParameterValue<Long>();
					parameterMaintenanceValueid_formato.setValue(parametroproducto.getid_formato());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_formato);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(parametroproducto.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!parametroproducto.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(parametroproducto.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(parametroproducto.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(parametroproducto.getId());
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
	
	public void setIsNewIsChangedFalseParametroProducto(ParametroProducto parametroproducto)throws Exception  {		
		parametroproducto.setIsNew(false);
		parametroproducto.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseParametroProductos(List<ParametroProducto> parametroproductos)throws Exception  {				
		for(ParametroProducto parametroproducto:parametroproductos) {
			parametroproducto.setIsNew(false);
			parametroproducto.setIsChanged(false);
		}
	}
	
	public void generarExportarParametroProducto(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
