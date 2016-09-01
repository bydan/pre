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
import com.bydan.framework.erp.business.dataaccess.DataAccessHelperSinIdGenerated;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.inventario.util.*;//EstadoDetalleOrdenCompraConstantesFunciones;










@SuppressWarnings("unused")
final public class EstadoDetalleOrdenCompraDataAccess extends  EstadoDetalleOrdenCompraDataAccessAdditional{ //EstadoDetalleOrdenCompraDataAccessAdditional,DataAccessHelper<EstadoDetalleOrdenCompra>
	//static Logger logger = Logger.getLogger(EstadoDetalleOrdenCompraDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="estado_detalle_orden_compra";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+EstadoDetalleOrdenCompraConstantesFunciones.SCHEMA+"."+EstadoDetalleOrdenCompraConstantesFunciones.TABLENAME+"(id,version_row,codigo,nombre)values(?,current_timestamp,?,?)";
	public static String QUERYUPDATE="update "+EstadoDetalleOrdenCompraConstantesFunciones.SCHEMA+"."+EstadoDetalleOrdenCompraConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+EstadoDetalleOrdenCompraConstantesFunciones.SCHEMA+"."+EstadoDetalleOrdenCompraConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select estadodetalleordencompra from "+EstadoDetalleOrdenCompraConstantesFunciones.SPERSISTENCENAME+" estadodetalleordencompra";
	public static String QUERYSELECTNATIVE="select "+EstadoDetalleOrdenCompraConstantesFunciones.SCHEMA+"."+EstadoDetalleOrdenCompraConstantesFunciones.TABLENAME+".id,"+EstadoDetalleOrdenCompraConstantesFunciones.SCHEMA+"."+EstadoDetalleOrdenCompraConstantesFunciones.TABLENAME+".version_row,"+EstadoDetalleOrdenCompraConstantesFunciones.SCHEMA+"."+EstadoDetalleOrdenCompraConstantesFunciones.TABLENAME+".codigo,"+EstadoDetalleOrdenCompraConstantesFunciones.SCHEMA+"."+EstadoDetalleOrdenCompraConstantesFunciones.TABLENAME+".nombre from "+EstadoDetalleOrdenCompraConstantesFunciones.SCHEMA+"."+EstadoDetalleOrdenCompraConstantesFunciones.TABLENAME;//+" as "+EstadoDetalleOrdenCompraConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+EstadoDetalleOrdenCompraConstantesFunciones.SCHEMA+"."+EstadoDetalleOrdenCompraConstantesFunciones.TABLENAME+".id,"+EstadoDetalleOrdenCompraConstantesFunciones.SCHEMA+"."+EstadoDetalleOrdenCompraConstantesFunciones.TABLENAME+".version_row,"+EstadoDetalleOrdenCompraConstantesFunciones.SCHEMA+"."+EstadoDetalleOrdenCompraConstantesFunciones.TABLENAME+".codigo from "+EstadoDetalleOrdenCompraConstantesFunciones.SCHEMA+"."+EstadoDetalleOrdenCompraConstantesFunciones.TABLENAME;//+" as "+EstadoDetalleOrdenCompraConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+EstadoDetalleOrdenCompraConstantesFunciones.SCHEMA+"."+EstadoDetalleOrdenCompraConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_ESTADODETALLEORDENCOMPRA_INSERT(?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_ESTADODETALLEORDENCOMPRA_UPDATE(?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_ESTADODETALLEORDENCOMPRA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_ESTADODETALLEORDENCOMPRA_SELECT(?,?)";
	
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
	
	
	protected EstadoDetalleOrdenCompraDataAccessAdditional estadodetalleordencompraDataAccessAdditional=null;
	
	public EstadoDetalleOrdenCompraDataAccessAdditional getEstadoDetalleOrdenCompraDataAccessAdditional() {
		return this.estadodetalleordencompraDataAccessAdditional;
	}
	
	public void setEstadoDetalleOrdenCompraDataAccessAdditional(EstadoDetalleOrdenCompraDataAccessAdditional estadodetalleordencompraDataAccessAdditional) {
		try {
			this.estadodetalleordencompraDataAccessAdditional=estadodetalleordencompraDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public EstadoDetalleOrdenCompraDataAccess() {
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
		EstadoDetalleOrdenCompraDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		EstadoDetalleOrdenCompraDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		EstadoDetalleOrdenCompraDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setEstadoDetalleOrdenCompraOriginal(EstadoDetalleOrdenCompra estadodetalleordencompra)throws Exception  {
		estadodetalleordencompra.setEstadoDetalleOrdenCompraOriginal((EstadoDetalleOrdenCompra)estadodetalleordencompra.clone());		
	}
	
	public void setEstadoDetalleOrdenComprasOriginal(List<EstadoDetalleOrdenCompra> estadodetalleordencompras)throws Exception  {
		
		for(EstadoDetalleOrdenCompra estadodetalleordencompra:estadodetalleordencompras){
			estadodetalleordencompra.setEstadoDetalleOrdenCompraOriginal((EstadoDetalleOrdenCompra)estadodetalleordencompra.clone());
		}
	}
	
	public static void setEstadoDetalleOrdenCompraOriginalStatic(EstadoDetalleOrdenCompra estadodetalleordencompra)throws Exception  {
		estadodetalleordencompra.setEstadoDetalleOrdenCompraOriginal((EstadoDetalleOrdenCompra)estadodetalleordencompra.clone());		
	}
	
	public static void setEstadoDetalleOrdenComprasOriginalStatic(List<EstadoDetalleOrdenCompra> estadodetalleordencompras)throws Exception  {
		
		for(EstadoDetalleOrdenCompra estadodetalleordencompra:estadodetalleordencompras){
			estadodetalleordencompra.setEstadoDetalleOrdenCompraOriginal((EstadoDetalleOrdenCompra)estadodetalleordencompra.clone());
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
	
	public  EstadoDetalleOrdenCompra getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		EstadoDetalleOrdenCompra entity = new EstadoDetalleOrdenCompra();		
		
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
	
	public  EstadoDetalleOrdenCompra getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		EstadoDetalleOrdenCompra entity = new EstadoDetalleOrdenCompra();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoDetalleOrdenCompraDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoDetalleOrdenCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.EstadoDetalleOrdenCompra.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setEstadoDetalleOrdenCompraOriginal(new EstadoDetalleOrdenCompra());
      	    	entity=super.getEntity("",entity,resultSet,EstadoDetalleOrdenCompraDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEstadoDetalleOrdenCompra("",entity,resultSet); 
				
				//entity.setEstadoDetalleOrdenCompraOriginal(super.getEntity("",entity.getEstadoDetalleOrdenCompraOriginal(),resultSet,EstadoDetalleOrdenCompraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoDetalleOrdenCompraOriginal(this.getEntityEstadoDetalleOrdenCompra("",entity.getEstadoDetalleOrdenCompraOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseEstadoDetalleOrdenCompra(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  EstadoDetalleOrdenCompra getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EstadoDetalleOrdenCompra entity = new EstadoDetalleOrdenCompra();
				
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
	
	public  EstadoDetalleOrdenCompra getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EstadoDetalleOrdenCompra entity = new EstadoDetalleOrdenCompra();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoDetalleOrdenCompraDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoDetalleOrdenCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoDetalleOrdenCompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.EstadoDetalleOrdenCompra.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setEstadoDetalleOrdenCompraOriginal(new EstadoDetalleOrdenCompra());
      	    	entity=super.getEntity("",entity,resultSet,EstadoDetalleOrdenCompraDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEstadoDetalleOrdenCompra("",entity,resultSet);    
				
				//entity.setEstadoDetalleOrdenCompraOriginal(super.getEntity("",entity.getEstadoDetalleOrdenCompraOriginal(),resultSet,EstadoDetalleOrdenCompraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoDetalleOrdenCompraOriginal(this.getEntityEstadoDetalleOrdenCompra("",entity.getEstadoDetalleOrdenCompraOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseEstadoDetalleOrdenCompra(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //EstadoDetalleOrdenCompra
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		EstadoDetalleOrdenCompra entity = new EstadoDetalleOrdenCompra();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoDetalleOrdenCompraDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoDetalleOrdenCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoDetalleOrdenCompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.EstadoDetalleOrdenCompra.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseEstadoDetalleOrdenCompra(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<EstadoDetalleOrdenCompra> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EstadoDetalleOrdenCompra> entities = new  ArrayList<EstadoDetalleOrdenCompra>();
		EstadoDetalleOrdenCompra entity = new EstadoDetalleOrdenCompra();		  
		
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
	
	public  List<EstadoDetalleOrdenCompra> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EstadoDetalleOrdenCompra> entities = new  ArrayList<EstadoDetalleOrdenCompra>();
		EstadoDetalleOrdenCompra entity = new EstadoDetalleOrdenCompra();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoDetalleOrdenCompraDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoDetalleOrdenCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoDetalleOrdenCompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoDetalleOrdenCompra();
      	    	entity=super.getEntity("",entity,resultSet,EstadoDetalleOrdenCompraDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoDetalleOrdenCompra("",entity,resultSet);
      	    	
				//entity.setEstadoDetalleOrdenCompraOriginal( new EstadoDetalleOrdenCompra());
      	    	//entity.setEstadoDetalleOrdenCompraOriginal(super.getEntity("",entity.getEstadoDetalleOrdenCompraOriginal(),resultSet,EstadoDetalleOrdenCompraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoDetalleOrdenCompraOriginal(this.getEntityEstadoDetalleOrdenCompra("",entity.getEstadoDetalleOrdenCompraOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoDetalleOrdenCompras(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoDetalleOrdenCompra(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<EstadoDetalleOrdenCompra> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EstadoDetalleOrdenCompra> entities = new  ArrayList<EstadoDetalleOrdenCompra>();
		EstadoDetalleOrdenCompra entity = new EstadoDetalleOrdenCompra();		  
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
	
	public  List<EstadoDetalleOrdenCompra> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EstadoDetalleOrdenCompra> entities = new  ArrayList<EstadoDetalleOrdenCompra>();
		EstadoDetalleOrdenCompra entity = new EstadoDetalleOrdenCompra();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoDetalleOrdenCompra();
				
				if(conMapGenerico) {
					entity.inicializarMapEstadoDetalleOrdenCompra();
					//entity.setMapEstadoDetalleOrdenCompra(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapEstadoDetalleOrdenCompraValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEstadoDetalleOrdenCompra().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EstadoDetalleOrdenCompraDataAccess.ISWITHSCHEMA);         		
					entity=EstadoDetalleOrdenCompraDataAccess.getEntityEstadoDetalleOrdenCompra("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEstadoDetalleOrdenCompraOriginal( new EstadoDetalleOrdenCompra());
					////entity.setEstadoDetalleOrdenCompraOriginal(super.getEntity("",entity.getEstadoDetalleOrdenCompraOriginal(),resultSet,EstadoDetalleOrdenCompraDataAccess.ISWITHSCHEMA));         		
					////entity.setEstadoDetalleOrdenCompraOriginal(this.getEntityEstadoDetalleOrdenCompra("",entity.getEstadoDetalleOrdenCompraOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoDetalleOrdenCompras(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoDetalleOrdenCompra(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public EstadoDetalleOrdenCompra getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EstadoDetalleOrdenCompra entity = new EstadoDetalleOrdenCompra();		  
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
	
	public  EstadoDetalleOrdenCompra getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EstadoDetalleOrdenCompra entity = new EstadoDetalleOrdenCompra();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoDetalleOrdenCompra();
				
				if(conMapGenerico) {
					entity.inicializarMapEstadoDetalleOrdenCompra();
					//entity.setMapEstadoDetalleOrdenCompra(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapEstadoDetalleOrdenCompraValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEstadoDetalleOrdenCompra().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EstadoDetalleOrdenCompraDataAccess.ISWITHSCHEMA);         		
					entity=EstadoDetalleOrdenCompraDataAccess.getEntityEstadoDetalleOrdenCompra("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEstadoDetalleOrdenCompraOriginal( new EstadoDetalleOrdenCompra());
					////entity.setEstadoDetalleOrdenCompraOriginal(super.getEntity("",entity.getEstadoDetalleOrdenCompraOriginal(),resultSet,EstadoDetalleOrdenCompraDataAccess.ISWITHSCHEMA));         		
					////entity.setEstadoDetalleOrdenCompraOriginal(this.getEntityEstadoDetalleOrdenCompra("",entity.getEstadoDetalleOrdenCompraOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseEstadoDetalleOrdenCompra(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoDetalleOrdenCompra(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static EstadoDetalleOrdenCompra getEntityEstadoDetalleOrdenCompra(String strPrefijo,EstadoDetalleOrdenCompra entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = EstadoDetalleOrdenCompra.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = EstadoDetalleOrdenCompra.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					EstadoDetalleOrdenCompraDataAccess.setFieldReflectionEstadoDetalleOrdenCompra(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasEstadoDetalleOrdenCompra=EstadoDetalleOrdenCompraConstantesFunciones.getTodosTiposColumnasEstadoDetalleOrdenCompra();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasEstadoDetalleOrdenCompra) {
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
							field = EstadoDetalleOrdenCompra.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = EstadoDetalleOrdenCompra.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						EstadoDetalleOrdenCompraDataAccess.setFieldReflectionEstadoDetalleOrdenCompra(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionEstadoDetalleOrdenCompra(Field field,String strPrefijo,String sColumn,EstadoDetalleOrdenCompra entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case EstadoDetalleOrdenCompraConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EstadoDetalleOrdenCompraConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EstadoDetalleOrdenCompraConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EstadoDetalleOrdenCompraConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EstadoDetalleOrdenCompra>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<EstadoDetalleOrdenCompra> entities = new  ArrayList<EstadoDetalleOrdenCompra>();
		EstadoDetalleOrdenCompra entity = new EstadoDetalleOrdenCompra();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoDetalleOrdenCompraDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoDetalleOrdenCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoDetalleOrdenCompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new EstadoDetalleOrdenCompra();
					entity=super.getEntity("",entity,resultSet,EstadoDetalleOrdenCompraDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityEstadoDetalleOrdenCompra("",entity,resultSet);
					
					//entity.setEstadoDetalleOrdenCompraOriginal( new EstadoDetalleOrdenCompra());
					//entity.setEstadoDetalleOrdenCompraOriginal(super.getEntity("",entity.getEstadoDetalleOrdenCompraOriginal(),resultSet,EstadoDetalleOrdenCompraDataAccess.ISWITHSCHEMA));         		
					//entity.setEstadoDetalleOrdenCompraOriginal(this.getEntityEstadoDetalleOrdenCompra("",entity.getEstadoDetalleOrdenCompraOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseEstadoDetalleOrdenCompras(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoDetalleOrdenCompra(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EstadoDetalleOrdenCompra>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<EstadoDetalleOrdenCompra> entities = new  ArrayList<EstadoDetalleOrdenCompra>();
		EstadoDetalleOrdenCompra entity = new EstadoDetalleOrdenCompra();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoDetalleOrdenCompraDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoDetalleOrdenCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoDetalleOrdenCompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<EstadoDetalleOrdenCompra> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoDetalleOrdenCompra> entities = new  ArrayList<EstadoDetalleOrdenCompra>();
		EstadoDetalleOrdenCompra entity = new EstadoDetalleOrdenCompra();		  
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
	
	public  List<EstadoDetalleOrdenCompra> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoDetalleOrdenCompra> entities = new  ArrayList<EstadoDetalleOrdenCompra>();
		EstadoDetalleOrdenCompra entity = new EstadoDetalleOrdenCompra();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoDetalleOrdenCompra();
      	    	entity=super.getEntity("",entity,resultSet,EstadoDetalleOrdenCompraDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoDetalleOrdenCompra("",entity,resultSet);
      	    	
				//entity.setEstadoDetalleOrdenCompraOriginal( new EstadoDetalleOrdenCompra());
      	    	//entity.setEstadoDetalleOrdenCompraOriginal(super.getEntity("",entity.getEstadoDetalleOrdenCompraOriginal(),resultSet,EstadoDetalleOrdenCompraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoDetalleOrdenCompraOriginal(this.getEntityEstadoDetalleOrdenCompra("",entity.getEstadoDetalleOrdenCompraOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseEstadoDetalleOrdenCompras(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoDetalleOrdenCompra(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<EstadoDetalleOrdenCompra> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoDetalleOrdenCompra> entities = new  ArrayList<EstadoDetalleOrdenCompra>();
		EstadoDetalleOrdenCompra entity = new EstadoDetalleOrdenCompra();		  
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
	
	public  List<EstadoDetalleOrdenCompra> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoDetalleOrdenCompra> entities = new  ArrayList<EstadoDetalleOrdenCompra>();
		EstadoDetalleOrdenCompra entity = new EstadoDetalleOrdenCompra();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoDetalleOrdenCompra();
      	    	entity=super.getEntity("",entity,resultSet,EstadoDetalleOrdenCompraDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoDetalleOrdenCompra("",entity,resultSet);
      	    	
				//entity.setEstadoDetalleOrdenCompraOriginal( new EstadoDetalleOrdenCompra());
      	    	//entity.setEstadoDetalleOrdenCompraOriginal(super.getEntity("",entity.getEstadoDetalleOrdenCompraOriginal(),resultSet,EstadoDetalleOrdenCompraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoDetalleOrdenCompraOriginal(this.getEntityEstadoDetalleOrdenCompra("",entity.getEstadoDetalleOrdenCompraOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoDetalleOrdenCompras(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public EstadoDetalleOrdenCompra getEntityEstadoDetalleOrdenCompra(String strPrefijo,EstadoDetalleOrdenCompra entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setcodigo(resultSet.getString(strPrefijo+EstadoDetalleOrdenCompraConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+EstadoDetalleOrdenCompraConstantesFunciones.NOMBRE));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+EstadoDetalleOrdenCompraConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowEstadoDetalleOrdenCompra(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(EstadoDetalleOrdenCompra entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=EstadoDetalleOrdenCompraDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=EstadoDetalleOrdenCompraDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=EstadoDetalleOrdenCompraDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=EstadoDetalleOrdenCompraDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(EstadoDetalleOrdenCompraConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,EstadoDetalleOrdenCompraDataAccess.TABLENAME,EstadoDetalleOrdenCompraDataAccess.ISWITHSTOREPROCEDURES);
			
			EstadoDetalleOrdenCompraDataAccess.setEstadoDetalleOrdenCompraOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
	
		
		public List<DetalleOrdenCompra> getDetalleOrdenCompras(Connexion connexion,EstadoDetalleOrdenCompra estadodetalleordencompra)throws SQLException,Exception {

		List<DetalleOrdenCompra> detalleordencompras= new ArrayList<DetalleOrdenCompra>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstadoDetalleOrdenCompraConstantesFunciones.SCHEMA+".estado_detalle_orden_compra ON "+DetalleOrdenCompraConstantesFunciones.SCHEMA+".detalle_orden_compra.id_estado_detalle_orden_compra="+EstadoDetalleOrdenCompraConstantesFunciones.SCHEMA+".estado_detalle_orden_compra.id WHERE "+EstadoDetalleOrdenCompraConstantesFunciones.SCHEMA+".estado_detalle_orden_compra.id="+String.valueOf(estadodetalleordencompra.getId());
			} else {
				sQuery=" INNER JOIN detalleordencompra.EstadoDetalleOrdenCompra WHERE detalleordencompra.EstadoDetalleOrdenCompra.id="+String.valueOf(estadodetalleordencompra.getId());

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


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,EstadoDetalleOrdenCompra estadodetalleordencompra) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!estadodetalleordencompra.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid=new ParameterValue<Long>();
					parameterMaintenanceValueid.setValue(estadodetalleordencompra.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(estadodetalleordencompra.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(estadodetalleordencompra.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!estadodetalleordencompra.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(estadodetalleordencompra.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(estadodetalleordencompra.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(estadodetalleordencompra.getId());
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
	
	public void setIsNewIsChangedFalseEstadoDetalleOrdenCompra(EstadoDetalleOrdenCompra estadodetalleordencompra)throws Exception  {		
		estadodetalleordencompra.setIsNew(false);
		estadodetalleordencompra.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseEstadoDetalleOrdenCompras(List<EstadoDetalleOrdenCompra> estadodetalleordencompras)throws Exception  {				
		for(EstadoDetalleOrdenCompra estadodetalleordencompra:estadodetalleordencompras) {
			estadodetalleordencompra.setIsNew(false);
			estadodetalleordencompra.setIsChanged(false);
		}
	}
	
	public void generarExportarEstadoDetalleOrdenCompra(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
