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
import com.bydan.erp.inventario.util.*;//NovedadProductoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class NovedadProductoDataAccess extends  NovedadProductoDataAccessAdditional{ //NovedadProductoDataAccessAdditional,DataAccessHelper<NovedadProducto>
	//static Logger logger = Logger.getLogger(NovedadProductoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="novedad_producto";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+NovedadProductoConstantesFunciones.SCHEMA+"."+NovedadProductoConstantesFunciones.TABLENAME+"(version_row,id_empresa,codigo,nombre)values(current_timestamp,?,?,?)";
	public static String QUERYUPDATE="update "+NovedadProductoConstantesFunciones.SCHEMA+"."+NovedadProductoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,codigo=?,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+NovedadProductoConstantesFunciones.SCHEMA+"."+NovedadProductoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select novedadproducto from "+NovedadProductoConstantesFunciones.SPERSISTENCENAME+" novedadproducto";
	public static String QUERYSELECTNATIVE="select "+NovedadProductoConstantesFunciones.SCHEMA+"."+NovedadProductoConstantesFunciones.TABLENAME+".id,"+NovedadProductoConstantesFunciones.SCHEMA+"."+NovedadProductoConstantesFunciones.TABLENAME+".version_row,"+NovedadProductoConstantesFunciones.SCHEMA+"."+NovedadProductoConstantesFunciones.TABLENAME+".id_empresa,"+NovedadProductoConstantesFunciones.SCHEMA+"."+NovedadProductoConstantesFunciones.TABLENAME+".codigo,"+NovedadProductoConstantesFunciones.SCHEMA+"."+NovedadProductoConstantesFunciones.TABLENAME+".nombre from "+NovedadProductoConstantesFunciones.SCHEMA+"."+NovedadProductoConstantesFunciones.TABLENAME;//+" as "+NovedadProductoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+NovedadProductoConstantesFunciones.SCHEMA+"."+NovedadProductoConstantesFunciones.TABLENAME+".id,"+NovedadProductoConstantesFunciones.SCHEMA+"."+NovedadProductoConstantesFunciones.TABLENAME+".version_row,"+NovedadProductoConstantesFunciones.SCHEMA+"."+NovedadProductoConstantesFunciones.TABLENAME+".codigo from "+NovedadProductoConstantesFunciones.SCHEMA+"."+NovedadProductoConstantesFunciones.TABLENAME;//+" as "+NovedadProductoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+NovedadProductoConstantesFunciones.SCHEMA+"."+NovedadProductoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,codigo=?,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_NOVEDADPRODUCTO_INSERT(?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_NOVEDADPRODUCTO_UPDATE(?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_NOVEDADPRODUCTO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_NOVEDADPRODUCTO_SELECT(?,?)";
	
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
	
	
	protected NovedadProductoDataAccessAdditional novedadproductoDataAccessAdditional=null;
	
	public NovedadProductoDataAccessAdditional getNovedadProductoDataAccessAdditional() {
		return this.novedadproductoDataAccessAdditional;
	}
	
	public void setNovedadProductoDataAccessAdditional(NovedadProductoDataAccessAdditional novedadproductoDataAccessAdditional) {
		try {
			this.novedadproductoDataAccessAdditional=novedadproductoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public NovedadProductoDataAccess() {
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
		NovedadProductoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		NovedadProductoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		NovedadProductoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setNovedadProductoOriginal(NovedadProducto novedadproducto)throws Exception  {
		novedadproducto.setNovedadProductoOriginal((NovedadProducto)novedadproducto.clone());		
	}
	
	public void setNovedadProductosOriginal(List<NovedadProducto> novedadproductos)throws Exception  {
		
		for(NovedadProducto novedadproducto:novedadproductos){
			novedadproducto.setNovedadProductoOriginal((NovedadProducto)novedadproducto.clone());
		}
	}
	
	public static void setNovedadProductoOriginalStatic(NovedadProducto novedadproducto)throws Exception  {
		novedadproducto.setNovedadProductoOriginal((NovedadProducto)novedadproducto.clone());		
	}
	
	public static void setNovedadProductosOriginalStatic(List<NovedadProducto> novedadproductos)throws Exception  {
		
		for(NovedadProducto novedadproducto:novedadproductos){
			novedadproducto.setNovedadProductoOriginal((NovedadProducto)novedadproducto.clone());
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
	
	public  NovedadProducto getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		NovedadProducto entity = new NovedadProducto();		
		
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
	
	public  NovedadProducto getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		NovedadProducto entity = new NovedadProducto();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=NovedadProductoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=NovedadProductoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.NovedadProducto.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setNovedadProductoOriginal(new NovedadProducto());
      	    	entity=super.getEntity("",entity,resultSet,NovedadProductoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityNovedadProducto("",entity,resultSet); 
				
				//entity.setNovedadProductoOriginal(super.getEntity("",entity.getNovedadProductoOriginal(),resultSet,NovedadProductoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setNovedadProductoOriginal(this.getEntityNovedadProducto("",entity.getNovedadProductoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseNovedadProducto(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  NovedadProducto getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		NovedadProducto entity = new NovedadProducto();
				
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
	
	public  NovedadProducto getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		NovedadProducto entity = new NovedadProducto();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=NovedadProductoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=NovedadProductoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,NovedadProductoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.NovedadProducto.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setNovedadProductoOriginal(new NovedadProducto());
      	    	entity=super.getEntity("",entity,resultSet,NovedadProductoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityNovedadProducto("",entity,resultSet);    
				
				//entity.setNovedadProductoOriginal(super.getEntity("",entity.getNovedadProductoOriginal(),resultSet,NovedadProductoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setNovedadProductoOriginal(this.getEntityNovedadProducto("",entity.getNovedadProductoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseNovedadProducto(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //NovedadProducto
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		NovedadProducto entity = new NovedadProducto();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=NovedadProductoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=NovedadProductoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,NovedadProductoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.NovedadProducto.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseNovedadProducto(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<NovedadProducto> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<NovedadProducto> entities = new  ArrayList<NovedadProducto>();
		NovedadProducto entity = new NovedadProducto();		  
		
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
	
	public  List<NovedadProducto> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<NovedadProducto> entities = new  ArrayList<NovedadProducto>();
		NovedadProducto entity = new NovedadProducto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=NovedadProductoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=NovedadProductoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,NovedadProductoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new NovedadProducto();
      	    	entity=super.getEntity("",entity,resultSet,NovedadProductoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityNovedadProducto("",entity,resultSet);
      	    	
				//entity.setNovedadProductoOriginal( new NovedadProducto());
      	    	//entity.setNovedadProductoOriginal(super.getEntity("",entity.getNovedadProductoOriginal(),resultSet,NovedadProductoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setNovedadProductoOriginal(this.getEntityNovedadProducto("",entity.getNovedadProductoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseNovedadProductos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarNovedadProducto(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<NovedadProducto> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<NovedadProducto> entities = new  ArrayList<NovedadProducto>();
		NovedadProducto entity = new NovedadProducto();		  
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
	
	public  List<NovedadProducto> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<NovedadProducto> entities = new  ArrayList<NovedadProducto>();
		NovedadProducto entity = new NovedadProducto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new NovedadProducto();
				
				if(conMapGenerico) {
					entity.inicializarMapNovedadProducto();
					//entity.setMapNovedadProducto(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapNovedadProductoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapNovedadProducto().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,NovedadProductoDataAccess.ISWITHSCHEMA);         		
					entity=NovedadProductoDataAccess.getEntityNovedadProducto("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setNovedadProductoOriginal( new NovedadProducto());
					////entity.setNovedadProductoOriginal(super.getEntity("",entity.getNovedadProductoOriginal(),resultSet,NovedadProductoDataAccess.ISWITHSCHEMA));         		
					////entity.setNovedadProductoOriginal(this.getEntityNovedadProducto("",entity.getNovedadProductoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseNovedadProductos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarNovedadProducto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public NovedadProducto getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		NovedadProducto entity = new NovedadProducto();		  
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
	
	public  NovedadProducto getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		NovedadProducto entity = new NovedadProducto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new NovedadProducto();
				
				if(conMapGenerico) {
					entity.inicializarMapNovedadProducto();
					//entity.setMapNovedadProducto(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapNovedadProductoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapNovedadProducto().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,NovedadProductoDataAccess.ISWITHSCHEMA);         		
					entity=NovedadProductoDataAccess.getEntityNovedadProducto("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setNovedadProductoOriginal( new NovedadProducto());
					////entity.setNovedadProductoOriginal(super.getEntity("",entity.getNovedadProductoOriginal(),resultSet,NovedadProductoDataAccess.ISWITHSCHEMA));         		
					////entity.setNovedadProductoOriginal(this.getEntityNovedadProducto("",entity.getNovedadProductoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseNovedadProducto(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarNovedadProducto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static NovedadProducto getEntityNovedadProducto(String strPrefijo,NovedadProducto entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = NovedadProducto.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = NovedadProducto.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					NovedadProductoDataAccess.setFieldReflectionNovedadProducto(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasNovedadProducto=NovedadProductoConstantesFunciones.getTodosTiposColumnasNovedadProducto();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasNovedadProducto) {
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
							field = NovedadProducto.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = NovedadProducto.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						NovedadProductoDataAccess.setFieldReflectionNovedadProducto(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionNovedadProducto(Field field,String strPrefijo,String sColumn,NovedadProducto entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case NovedadProductoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NovedadProductoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case NovedadProductoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NovedadProductoConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case NovedadProductoConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<NovedadProducto>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<NovedadProducto> entities = new  ArrayList<NovedadProducto>();
		NovedadProducto entity = new NovedadProducto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=NovedadProductoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=NovedadProductoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,NovedadProductoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new NovedadProducto();
					entity=super.getEntity("",entity,resultSet,NovedadProductoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityNovedadProducto("",entity,resultSet);
					
					//entity.setNovedadProductoOriginal( new NovedadProducto());
					//entity.setNovedadProductoOriginal(super.getEntity("",entity.getNovedadProductoOriginal(),resultSet,NovedadProductoDataAccess.ISWITHSCHEMA));         		
					//entity.setNovedadProductoOriginal(this.getEntityNovedadProducto("",entity.getNovedadProductoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseNovedadProductos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarNovedadProducto(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<NovedadProducto>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<NovedadProducto> entities = new  ArrayList<NovedadProducto>();
		NovedadProducto entity = new NovedadProducto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=NovedadProductoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=NovedadProductoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,NovedadProductoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<NovedadProducto> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<NovedadProducto> entities = new  ArrayList<NovedadProducto>();
		NovedadProducto entity = new NovedadProducto();		  
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
	
	public  List<NovedadProducto> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<NovedadProducto> entities = new  ArrayList<NovedadProducto>();
		NovedadProducto entity = new NovedadProducto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new NovedadProducto();
      	    	entity=super.getEntity("",entity,resultSet,NovedadProductoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityNovedadProducto("",entity,resultSet);
      	    	
				//entity.setNovedadProductoOriginal( new NovedadProducto());
      	    	//entity.setNovedadProductoOriginal(super.getEntity("",entity.getNovedadProductoOriginal(),resultSet,NovedadProductoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setNovedadProductoOriginal(this.getEntityNovedadProducto("",entity.getNovedadProductoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseNovedadProductos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarNovedadProducto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<NovedadProducto> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<NovedadProducto> entities = new  ArrayList<NovedadProducto>();
		NovedadProducto entity = new NovedadProducto();		  
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
	
	public  List<NovedadProducto> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<NovedadProducto> entities = new  ArrayList<NovedadProducto>();
		NovedadProducto entity = new NovedadProducto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new NovedadProducto();
      	    	entity=super.getEntity("",entity,resultSet,NovedadProductoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityNovedadProducto("",entity,resultSet);
      	    	
				//entity.setNovedadProductoOriginal( new NovedadProducto());
      	    	//entity.setNovedadProductoOriginal(super.getEntity("",entity.getNovedadProductoOriginal(),resultSet,NovedadProductoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setNovedadProductoOriginal(this.getEntityNovedadProducto("",entity.getNovedadProductoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseNovedadProductos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public NovedadProducto getEntityNovedadProducto(String strPrefijo,NovedadProducto entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+NovedadProductoConstantesFunciones.IDEMPRESA));
				entity.setcodigo(resultSet.getString(strPrefijo+NovedadProductoConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+NovedadProductoConstantesFunciones.NOMBRE));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+NovedadProductoConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowNovedadProducto(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(NovedadProducto entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=NovedadProductoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=NovedadProductoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=NovedadProductoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=NovedadProductoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(NovedadProductoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,NovedadProductoDataAccess.TABLENAME,NovedadProductoDataAccess.ISWITHSTOREPROCEDURES);
			
			NovedadProductoDataAccess.setNovedadProductoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,NovedadProducto relnovedadproducto)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relnovedadproducto.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}


		
		public List<DetalleFacturaProveedor> getDetalleFacturaProveedors(Connexion connexion,NovedadProducto novedadproducto)throws SQLException,Exception {

		List<DetalleFacturaProveedor> detallefacturaproveedors= new ArrayList<DetalleFacturaProveedor>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+NovedadProductoConstantesFunciones.SCHEMA+".novedad_producto ON "+DetalleFacturaProveedorConstantesFunciones.SCHEMA+".detalle_factura_proveedor.id_novedad_producto="+NovedadProductoConstantesFunciones.SCHEMA+".novedad_producto.id WHERE "+NovedadProductoConstantesFunciones.SCHEMA+".novedad_producto.id="+String.valueOf(novedadproducto.getId());
			} else {
				sQuery=" INNER JOIN detallefacturaproveedor.NovedadProducto WHERE detallefacturaproveedor.NovedadProducto.id="+String.valueOf(novedadproducto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleFacturaProveedorDataAccess detallefacturaproveedorDataAccess=new DetalleFacturaProveedorDataAccess();

			detallefacturaproveedorDataAccess.setConnexionType(this.connexionType);
			detallefacturaproveedorDataAccess.setParameterDbType(this.parameterDbType);
			detallefacturaproveedors=detallefacturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detallefacturaproveedors;

	}

	public List<NovedadSeguimiento> getNovedadSeguimientos(Connexion connexion,NovedadProducto novedadproducto)throws SQLException,Exception {

		List<NovedadSeguimiento> novedadseguimientos= new ArrayList<NovedadSeguimiento>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+NovedadProductoConstantesFunciones.SCHEMA+".novedad_producto ON "+NovedadSeguimientoConstantesFunciones.SCHEMA+".novedad_seguimiento.id_novedad_producto="+NovedadProductoConstantesFunciones.SCHEMA+".novedad_producto.id WHERE "+NovedadProductoConstantesFunciones.SCHEMA+".novedad_producto.id="+String.valueOf(novedadproducto.getId());
			} else {
				sQuery=" INNER JOIN novedadseguimiento.NovedadProducto WHERE novedadseguimiento.NovedadProducto.id="+String.valueOf(novedadproducto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			NovedadSeguimientoDataAccess novedadseguimientoDataAccess=new NovedadSeguimientoDataAccess();

			novedadseguimientoDataAccess.setConnexionType(this.connexionType);
			novedadseguimientoDataAccess.setParameterDbType(this.parameterDbType);
			novedadseguimientos=novedadseguimientoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return novedadseguimientos;

	}

	public List<DetalleCompra> getDetalleCompras(Connexion connexion,NovedadProducto novedadproducto)throws SQLException,Exception {

		List<DetalleCompra> detallecompras= new ArrayList<DetalleCompra>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+NovedadProductoConstantesFunciones.SCHEMA+".novedad_producto ON "+DetalleCompraConstantesFunciones.SCHEMA+".detalle_compra.id_novedad_producto="+NovedadProductoConstantesFunciones.SCHEMA+".novedad_producto.id WHERE "+NovedadProductoConstantesFunciones.SCHEMA+".novedad_producto.id="+String.valueOf(novedadproducto.getId());
			} else {
				sQuery=" INNER JOIN detallecompra.NovedadProducto WHERE detallecompra.NovedadProducto.id="+String.valueOf(novedadproducto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleCompraDataAccess detallecompraDataAccess=new DetalleCompraDataAccess();

			detallecompraDataAccess.setConnexionType(this.connexionType);
			detallecompraDataAccess.setParameterDbType(this.parameterDbType);
			detallecompras=detallecompraDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detallecompras;

	}

	public List<DetalleTransferencia> getDetalleTransferencias(Connexion connexion,NovedadProducto novedadproducto)throws SQLException,Exception {

		List<DetalleTransferencia> detalletransferencias= new ArrayList<DetalleTransferencia>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+NovedadProductoConstantesFunciones.SCHEMA+".novedad_producto ON "+DetalleTransferenciaConstantesFunciones.SCHEMA+".detalle_transferencia.id_novedad_producto="+NovedadProductoConstantesFunciones.SCHEMA+".novedad_producto.id WHERE "+NovedadProductoConstantesFunciones.SCHEMA+".novedad_producto.id="+String.valueOf(novedadproducto.getId());
			} else {
				sQuery=" INNER JOIN detalletransferencia.NovedadProducto WHERE detalletransferencia.NovedadProducto.id="+String.valueOf(novedadproducto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleTransferenciaDataAccess detalletransferenciaDataAccess=new DetalleTransferenciaDataAccess();

			detalletransferenciaDataAccess.setConnexionType(this.connexionType);
			detalletransferenciaDataAccess.setParameterDbType(this.parameterDbType);
			detalletransferencias=detalletransferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalletransferencias;

	}

	public List<DetalleMovimientoInventario> getDetalleMovimientoInventarios(Connexion connexion,NovedadProducto novedadproducto)throws SQLException,Exception {

		List<DetalleMovimientoInventario> detallemovimientoinventarios= new ArrayList<DetalleMovimientoInventario>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+NovedadProductoConstantesFunciones.SCHEMA+".novedad_producto ON "+DetalleMovimientoInventarioConstantesFunciones.SCHEMA+".detalle_movimiento_inventario.id_novedad_producto="+NovedadProductoConstantesFunciones.SCHEMA+".novedad_producto.id WHERE "+NovedadProductoConstantesFunciones.SCHEMA+".novedad_producto.id="+String.valueOf(novedadproducto.getId());
			} else {
				sQuery=" INNER JOIN detallemovimientoinventario.NovedadProducto WHERE detallemovimientoinventario.NovedadProducto.id="+String.valueOf(novedadproducto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleMovimientoInventarioDataAccess detallemovimientoinventarioDataAccess=new DetalleMovimientoInventarioDataAccess();

			detallemovimientoinventarioDataAccess.setConnexionType(this.connexionType);
			detallemovimientoinventarioDataAccess.setParameterDbType(this.parameterDbType);
			detallemovimientoinventarios=detallemovimientoinventarioDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detallemovimientoinventarios;

	}

	public List<DetalleOrdenCompra> getDetalleOrdenCompras(Connexion connexion,NovedadProducto novedadproducto)throws SQLException,Exception {

		List<DetalleOrdenCompra> detalleordencompras= new ArrayList<DetalleOrdenCompra>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+NovedadProductoConstantesFunciones.SCHEMA+".novedad_producto ON "+DetalleOrdenCompraConstantesFunciones.SCHEMA+".detalle_orden_compra.id_novedad_producto="+NovedadProductoConstantesFunciones.SCHEMA+".novedad_producto.id WHERE "+NovedadProductoConstantesFunciones.SCHEMA+".novedad_producto.id="+String.valueOf(novedadproducto.getId());
			} else {
				sQuery=" INNER JOIN detalleordencompra.NovedadProducto WHERE detalleordencompra.NovedadProducto.id="+String.valueOf(novedadproducto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleOrdenCompraDataAccess detalleordencompraDataAccess=new DetalleOrdenCompraDataAccess();

			detalleordencompraDataAccess.setConnexionType(this.connexionType);
			detalleordencompraDataAccess.setParameterDbType(this.parameterDbType);
			detalleordencompras=detalleordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalleordencompras;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,NovedadProducto novedadproducto) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!novedadproducto.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(novedadproducto.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(novedadproducto.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(novedadproducto.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!novedadproducto.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(novedadproducto.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(novedadproducto.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(novedadproducto.getId());
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
	
	public void setIsNewIsChangedFalseNovedadProducto(NovedadProducto novedadproducto)throws Exception  {		
		novedadproducto.setIsNew(false);
		novedadproducto.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseNovedadProductos(List<NovedadProducto> novedadproductos)throws Exception  {				
		for(NovedadProducto novedadproducto:novedadproductos) {
			novedadproducto.setIsNew(false);
			novedadproducto.setIsChanged(false);
		}
	}
	
	public void generarExportarNovedadProducto(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
