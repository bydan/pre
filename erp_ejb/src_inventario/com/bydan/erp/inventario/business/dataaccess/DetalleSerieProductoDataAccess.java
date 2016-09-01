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
import com.bydan.erp.inventario.util.*;//DetalleSerieProductoConstantesFunciones;










@SuppressWarnings("unused")
final public class DetalleSerieProductoDataAccess extends  DetalleSerieProductoDataAccessAdditional{ //DetalleSerieProductoDataAccessAdditional,DataAccessHelper<DetalleSerieProducto>
	//static Logger logger = Logger.getLogger(DetalleSerieProductoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="detalle_serie_producto";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+DetalleSerieProductoConstantesFunciones.SCHEMA+"."+DetalleSerieProductoConstantesFunciones.TABLENAME+"(version_row,id_serie_producto,nombre,descripcion)values(current_timestamp,?,?,?)";
	public static String QUERYUPDATE="update "+DetalleSerieProductoConstantesFunciones.SCHEMA+"."+DetalleSerieProductoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_serie_producto=?,nombre=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+DetalleSerieProductoConstantesFunciones.SCHEMA+"."+DetalleSerieProductoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select detalleserieproducto from "+DetalleSerieProductoConstantesFunciones.SPERSISTENCENAME+" detalleserieproducto";
	public static String QUERYSELECTNATIVE="select "+DetalleSerieProductoConstantesFunciones.SCHEMA+"."+DetalleSerieProductoConstantesFunciones.TABLENAME+".id,"+DetalleSerieProductoConstantesFunciones.SCHEMA+"."+DetalleSerieProductoConstantesFunciones.TABLENAME+".version_row,"+DetalleSerieProductoConstantesFunciones.SCHEMA+"."+DetalleSerieProductoConstantesFunciones.TABLENAME+".id_serie_producto,"+DetalleSerieProductoConstantesFunciones.SCHEMA+"."+DetalleSerieProductoConstantesFunciones.TABLENAME+".nombre,"+DetalleSerieProductoConstantesFunciones.SCHEMA+"."+DetalleSerieProductoConstantesFunciones.TABLENAME+".descripcion from "+DetalleSerieProductoConstantesFunciones.SCHEMA+"."+DetalleSerieProductoConstantesFunciones.TABLENAME;//+" as "+DetalleSerieProductoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+DetalleSerieProductoConstantesFunciones.SCHEMA+"."+DetalleSerieProductoConstantesFunciones.TABLENAME+".id,"+DetalleSerieProductoConstantesFunciones.SCHEMA+"."+DetalleSerieProductoConstantesFunciones.TABLENAME+".version_row,"+DetalleSerieProductoConstantesFunciones.SCHEMA+"."+DetalleSerieProductoConstantesFunciones.TABLENAME+".nombre from "+DetalleSerieProductoConstantesFunciones.SCHEMA+"."+DetalleSerieProductoConstantesFunciones.TABLENAME;//+" as "+DetalleSerieProductoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+DetalleSerieProductoConstantesFunciones.SCHEMA+"."+DetalleSerieProductoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_serie_producto=?,nombre=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_DETALLESERIEPRODUCTO_INSERT(?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_DETALLESERIEPRODUCTO_UPDATE(?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_DETALLESERIEPRODUCTO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_DETALLESERIEPRODUCTO_SELECT(?,?)";
	
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
	
	
	protected DetalleSerieProductoDataAccessAdditional detalleserieproductoDataAccessAdditional=null;
	
	public DetalleSerieProductoDataAccessAdditional getDetalleSerieProductoDataAccessAdditional() {
		return this.detalleserieproductoDataAccessAdditional;
	}
	
	public void setDetalleSerieProductoDataAccessAdditional(DetalleSerieProductoDataAccessAdditional detalleserieproductoDataAccessAdditional) {
		try {
			this.detalleserieproductoDataAccessAdditional=detalleserieproductoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public DetalleSerieProductoDataAccess() {
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
		DetalleSerieProductoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		DetalleSerieProductoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		DetalleSerieProductoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setDetalleSerieProductoOriginal(DetalleSerieProducto detalleserieproducto)throws Exception  {
		detalleserieproducto.setDetalleSerieProductoOriginal((DetalleSerieProducto)detalleserieproducto.clone());		
	}
	
	public void setDetalleSerieProductosOriginal(List<DetalleSerieProducto> detalleserieproductos)throws Exception  {
		
		for(DetalleSerieProducto detalleserieproducto:detalleserieproductos){
			detalleserieproducto.setDetalleSerieProductoOriginal((DetalleSerieProducto)detalleserieproducto.clone());
		}
	}
	
	public static void setDetalleSerieProductoOriginalStatic(DetalleSerieProducto detalleserieproducto)throws Exception  {
		detalleserieproducto.setDetalleSerieProductoOriginal((DetalleSerieProducto)detalleserieproducto.clone());		
	}
	
	public static void setDetalleSerieProductosOriginalStatic(List<DetalleSerieProducto> detalleserieproductos)throws Exception  {
		
		for(DetalleSerieProducto detalleserieproducto:detalleserieproductos){
			detalleserieproducto.setDetalleSerieProductoOriginal((DetalleSerieProducto)detalleserieproducto.clone());
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
	
	public  DetalleSerieProducto getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		DetalleSerieProducto entity = new DetalleSerieProducto();		
		
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
	
	public  DetalleSerieProducto getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		DetalleSerieProducto entity = new DetalleSerieProducto();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleSerieProductoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleSerieProductoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.DetalleSerieProducto.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setDetalleSerieProductoOriginal(new DetalleSerieProducto());
      	    	entity=super.getEntity("",entity,resultSet,DetalleSerieProductoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetalleSerieProducto("",entity,resultSet); 
				
				//entity.setDetalleSerieProductoOriginal(super.getEntity("",entity.getDetalleSerieProductoOriginal(),resultSet,DetalleSerieProductoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleSerieProductoOriginal(this.getEntityDetalleSerieProducto("",entity.getDetalleSerieProductoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseDetalleSerieProducto(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  DetalleSerieProducto getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetalleSerieProducto entity = new DetalleSerieProducto();
				
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
	
	public  DetalleSerieProducto getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetalleSerieProducto entity = new DetalleSerieProducto();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleSerieProductoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleSerieProductoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleSerieProductoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.DetalleSerieProducto.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setDetalleSerieProductoOriginal(new DetalleSerieProducto());
      	    	entity=super.getEntity("",entity,resultSet,DetalleSerieProductoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetalleSerieProducto("",entity,resultSet);    
				
				//entity.setDetalleSerieProductoOriginal(super.getEntity("",entity.getDetalleSerieProductoOriginal(),resultSet,DetalleSerieProductoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleSerieProductoOriginal(this.getEntityDetalleSerieProducto("",entity.getDetalleSerieProductoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseDetalleSerieProducto(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //DetalleSerieProducto
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		DetalleSerieProducto entity = new DetalleSerieProducto();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleSerieProductoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleSerieProductoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleSerieProductoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.DetalleSerieProducto.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseDetalleSerieProducto(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<DetalleSerieProducto> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetalleSerieProducto> entities = new  ArrayList<DetalleSerieProducto>();
		DetalleSerieProducto entity = new DetalleSerieProducto();		  
		
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
	
	public  List<DetalleSerieProducto> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetalleSerieProducto> entities = new  ArrayList<DetalleSerieProducto>();
		DetalleSerieProducto entity = new DetalleSerieProducto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleSerieProductoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleSerieProductoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleSerieProductoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleSerieProducto();
      	    	entity=super.getEntity("",entity,resultSet,DetalleSerieProductoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleSerieProducto("",entity,resultSet);
      	    	
				//entity.setDetalleSerieProductoOriginal( new DetalleSerieProducto());
      	    	//entity.setDetalleSerieProductoOriginal(super.getEntity("",entity.getDetalleSerieProductoOriginal(),resultSet,DetalleSerieProductoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleSerieProductoOriginal(this.getEntityDetalleSerieProducto("",entity.getDetalleSerieProductoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleSerieProductos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleSerieProducto(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetalleSerieProducto> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetalleSerieProducto> entities = new  ArrayList<DetalleSerieProducto>();
		DetalleSerieProducto entity = new DetalleSerieProducto();		  
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
	
	public  List<DetalleSerieProducto> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetalleSerieProducto> entities = new  ArrayList<DetalleSerieProducto>();
		DetalleSerieProducto entity = new DetalleSerieProducto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleSerieProducto();
				
				if(conMapGenerico) {
					entity.inicializarMapDetalleSerieProducto();
					//entity.setMapDetalleSerieProducto(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapDetalleSerieProductoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetalleSerieProducto().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetalleSerieProductoDataAccess.ISWITHSCHEMA);         		
					entity=DetalleSerieProductoDataAccess.getEntityDetalleSerieProducto("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetalleSerieProductoOriginal( new DetalleSerieProducto());
					////entity.setDetalleSerieProductoOriginal(super.getEntity("",entity.getDetalleSerieProductoOriginal(),resultSet,DetalleSerieProductoDataAccess.ISWITHSCHEMA));         		
					////entity.setDetalleSerieProductoOriginal(this.getEntityDetalleSerieProducto("",entity.getDetalleSerieProductoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleSerieProductos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleSerieProducto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public DetalleSerieProducto getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetalleSerieProducto entity = new DetalleSerieProducto();		  
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
	
	public  DetalleSerieProducto getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetalleSerieProducto entity = new DetalleSerieProducto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleSerieProducto();
				
				if(conMapGenerico) {
					entity.inicializarMapDetalleSerieProducto();
					//entity.setMapDetalleSerieProducto(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapDetalleSerieProductoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetalleSerieProducto().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetalleSerieProductoDataAccess.ISWITHSCHEMA);         		
					entity=DetalleSerieProductoDataAccess.getEntityDetalleSerieProducto("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetalleSerieProductoOriginal( new DetalleSerieProducto());
					////entity.setDetalleSerieProductoOriginal(super.getEntity("",entity.getDetalleSerieProductoOriginal(),resultSet,DetalleSerieProductoDataAccess.ISWITHSCHEMA));         		
					////entity.setDetalleSerieProductoOriginal(this.getEntityDetalleSerieProducto("",entity.getDetalleSerieProductoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseDetalleSerieProducto(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleSerieProducto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static DetalleSerieProducto getEntityDetalleSerieProducto(String strPrefijo,DetalleSerieProducto entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = DetalleSerieProducto.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = DetalleSerieProducto.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					DetalleSerieProductoDataAccess.setFieldReflectionDetalleSerieProducto(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasDetalleSerieProducto=DetalleSerieProductoConstantesFunciones.getTodosTiposColumnasDetalleSerieProducto();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasDetalleSerieProducto) {
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
							field = DetalleSerieProducto.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = DetalleSerieProducto.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						DetalleSerieProductoDataAccess.setFieldReflectionDetalleSerieProducto(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionDetalleSerieProducto(Field field,String strPrefijo,String sColumn,DetalleSerieProducto entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case DetalleSerieProductoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleSerieProductoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleSerieProductoConstantesFunciones.IDSERIEPRODUCTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleSerieProductoConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleSerieProductoConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetalleSerieProducto>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<DetalleSerieProducto> entities = new  ArrayList<DetalleSerieProducto>();
		DetalleSerieProducto entity = new DetalleSerieProducto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleSerieProductoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleSerieProductoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleSerieProductoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new DetalleSerieProducto();
					entity=super.getEntity("",entity,resultSet,DetalleSerieProductoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityDetalleSerieProducto("",entity,resultSet);
					
					//entity.setDetalleSerieProductoOriginal( new DetalleSerieProducto());
					//entity.setDetalleSerieProductoOriginal(super.getEntity("",entity.getDetalleSerieProductoOriginal(),resultSet,DetalleSerieProductoDataAccess.ISWITHSCHEMA));         		
					//entity.setDetalleSerieProductoOriginal(this.getEntityDetalleSerieProducto("",entity.getDetalleSerieProductoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseDetalleSerieProductos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleSerieProducto(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetalleSerieProducto>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<DetalleSerieProducto> entities = new  ArrayList<DetalleSerieProducto>();
		DetalleSerieProducto entity = new DetalleSerieProducto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleSerieProductoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleSerieProductoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleSerieProductoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<DetalleSerieProducto> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleSerieProducto> entities = new  ArrayList<DetalleSerieProducto>();
		DetalleSerieProducto entity = new DetalleSerieProducto();		  
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
	
	public  List<DetalleSerieProducto> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleSerieProducto> entities = new  ArrayList<DetalleSerieProducto>();
		DetalleSerieProducto entity = new DetalleSerieProducto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleSerieProducto();
      	    	entity=super.getEntity("",entity,resultSet,DetalleSerieProductoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleSerieProducto("",entity,resultSet);
      	    	
				//entity.setDetalleSerieProductoOriginal( new DetalleSerieProducto());
      	    	//entity.setDetalleSerieProductoOriginal(super.getEntity("",entity.getDetalleSerieProductoOriginal(),resultSet,DetalleSerieProductoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleSerieProductoOriginal(this.getEntityDetalleSerieProducto("",entity.getDetalleSerieProductoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseDetalleSerieProductos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleSerieProducto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetalleSerieProducto> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleSerieProducto> entities = new  ArrayList<DetalleSerieProducto>();
		DetalleSerieProducto entity = new DetalleSerieProducto();		  
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
	
	public  List<DetalleSerieProducto> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleSerieProducto> entities = new  ArrayList<DetalleSerieProducto>();
		DetalleSerieProducto entity = new DetalleSerieProducto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleSerieProducto();
      	    	entity=super.getEntity("",entity,resultSet,DetalleSerieProductoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleSerieProducto("",entity,resultSet);
      	    	
				//entity.setDetalleSerieProductoOriginal( new DetalleSerieProducto());
      	    	//entity.setDetalleSerieProductoOriginal(super.getEntity("",entity.getDetalleSerieProductoOriginal(),resultSet,DetalleSerieProductoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleSerieProductoOriginal(this.getEntityDetalleSerieProducto("",entity.getDetalleSerieProductoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleSerieProductos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public DetalleSerieProducto getEntityDetalleSerieProducto(String strPrefijo,DetalleSerieProducto entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_serie_producto(resultSet.getLong(strPrefijo+DetalleSerieProductoConstantesFunciones.IDSERIEPRODUCTO));
				entity.setnombre(resultSet.getString(strPrefijo+DetalleSerieProductoConstantesFunciones.NOMBRE));
				entity.setdescripcion(resultSet.getString(strPrefijo+DetalleSerieProductoConstantesFunciones.DESCRIPCION));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+DetalleSerieProductoConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowDetalleSerieProducto(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(DetalleSerieProducto entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=DetalleSerieProductoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=DetalleSerieProductoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=DetalleSerieProductoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=DetalleSerieProductoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(DetalleSerieProductoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,DetalleSerieProductoDataAccess.TABLENAME,DetalleSerieProductoDataAccess.ISWITHSTOREPROCEDURES);
			
			DetalleSerieProductoDataAccess.setDetalleSerieProductoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public SerieProducto getSerieProducto(Connexion connexion,DetalleSerieProducto reldetalleserieproducto)throws SQLException,Exception {

		SerieProducto serieproducto= new SerieProducto();

		try {
			SerieProductoDataAccess serieproductoDataAccess=new SerieProductoDataAccess();

			serieproductoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			serieproductoDataAccess.setConnexionType(this.connexionType);
			serieproductoDataAccess.setParameterDbType(this.parameterDbType);

			serieproducto=serieproductoDataAccess.getEntity(connexion,reldetalleserieproducto.getid_serie_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return serieproducto;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,DetalleSerieProducto detalleserieproducto) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!detalleserieproducto.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_serie_producto=new ParameterValue<Long>();
					parameterMaintenanceValueid_serie_producto.setValue(detalleserieproducto.getid_serie_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_serie_producto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(detalleserieproducto.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(detalleserieproducto.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!detalleserieproducto.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(detalleserieproducto.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(detalleserieproducto.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(detalleserieproducto.getId());
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
	
	public void setIsNewIsChangedFalseDetalleSerieProducto(DetalleSerieProducto detalleserieproducto)throws Exception  {		
		detalleserieproducto.setIsNew(false);
		detalleserieproducto.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseDetalleSerieProductos(List<DetalleSerieProducto> detalleserieproductos)throws Exception  {				
		for(DetalleSerieProducto detalleserieproducto:detalleserieproductos) {
			detalleserieproducto.setIsNew(false);
			detalleserieproducto.setIsChanged(false);
		}
	}
	
	public void generarExportarDetalleSerieProducto(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
