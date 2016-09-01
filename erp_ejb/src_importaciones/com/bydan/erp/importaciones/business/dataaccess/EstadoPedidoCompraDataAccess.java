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
package com.bydan.erp.importaciones.business.dataaccess;

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

import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.importaciones.util.*;//EstadoPedidoCompraConstantesFunciones;


import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.importaciones.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;


import com.bydan.erp.inventario.util.*;
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.facturacion.util.*;




@SuppressWarnings("unused")
final public class EstadoPedidoCompraDataAccess extends  DataAccessHelperSinIdGenerated<EstadoPedidoCompra>{ //EstadoPedidoCompraDataAccessAdditional,DataAccessHelper<EstadoPedidoCompra>
	//static Logger logger = Logger.getLogger(EstadoPedidoCompraDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="estado_pedido_compra";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+EstadoPedidoCompraConstantesFunciones.SCHEMA+"."+EstadoPedidoCompraConstantesFunciones.TABLENAME+"(id,version_row,codigo,nombre)values(?,current_timestamp,?,?)";
	public static String QUERYUPDATE="update "+EstadoPedidoCompraConstantesFunciones.SCHEMA+"."+EstadoPedidoCompraConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+EstadoPedidoCompraConstantesFunciones.SCHEMA+"."+EstadoPedidoCompraConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select estadopedidocompra from "+EstadoPedidoCompraConstantesFunciones.SPERSISTENCENAME+" estadopedidocompra";
	public static String QUERYSELECTNATIVE="select "+EstadoPedidoCompraConstantesFunciones.SCHEMA+"."+EstadoPedidoCompraConstantesFunciones.TABLENAME+".id,"+EstadoPedidoCompraConstantesFunciones.SCHEMA+"."+EstadoPedidoCompraConstantesFunciones.TABLENAME+".version_row,"+EstadoPedidoCompraConstantesFunciones.SCHEMA+"."+EstadoPedidoCompraConstantesFunciones.TABLENAME+".codigo,"+EstadoPedidoCompraConstantesFunciones.SCHEMA+"."+EstadoPedidoCompraConstantesFunciones.TABLENAME+".nombre from "+EstadoPedidoCompraConstantesFunciones.SCHEMA+"."+EstadoPedidoCompraConstantesFunciones.TABLENAME;//+" as "+EstadoPedidoCompraConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+EstadoPedidoCompraConstantesFunciones.SCHEMA+"."+EstadoPedidoCompraConstantesFunciones.TABLENAME+".id,"+EstadoPedidoCompraConstantesFunciones.SCHEMA+"."+EstadoPedidoCompraConstantesFunciones.TABLENAME+".version_row,"+EstadoPedidoCompraConstantesFunciones.SCHEMA+"."+EstadoPedidoCompraConstantesFunciones.TABLENAME+".codigo from "+EstadoPedidoCompraConstantesFunciones.SCHEMA+"."+EstadoPedidoCompraConstantesFunciones.TABLENAME;//+" as "+EstadoPedidoCompraConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+EstadoPedidoCompraConstantesFunciones.SCHEMA+"."+EstadoPedidoCompraConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_ESTADOPEDIDOCOMPRA_INSERT(?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_ESTADOPEDIDOCOMPRA_UPDATE(?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_ESTADOPEDIDOCOMPRA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_ESTADOPEDIDOCOMPRA_SELECT(?,?)";
	
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
	
	
	public EstadoPedidoCompraDataAccess() {
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
		EstadoPedidoCompraDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		EstadoPedidoCompraDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		EstadoPedidoCompraDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setEstadoPedidoCompraOriginal(EstadoPedidoCompra estadopedidocompra)throws Exception  {
		estadopedidocompra.setEstadoPedidoCompraOriginal((EstadoPedidoCompra)estadopedidocompra.clone());		
	}
	
	public void setEstadoPedidoComprasOriginal(List<EstadoPedidoCompra> estadopedidocompras)throws Exception  {
		
		for(EstadoPedidoCompra estadopedidocompra:estadopedidocompras){
			estadopedidocompra.setEstadoPedidoCompraOriginal((EstadoPedidoCompra)estadopedidocompra.clone());
		}
	}
	
	public static void setEstadoPedidoCompraOriginalStatic(EstadoPedidoCompra estadopedidocompra)throws Exception  {
		estadopedidocompra.setEstadoPedidoCompraOriginal((EstadoPedidoCompra)estadopedidocompra.clone());		
	}
	
	public static void setEstadoPedidoComprasOriginalStatic(List<EstadoPedidoCompra> estadopedidocompras)throws Exception  {
		
		for(EstadoPedidoCompra estadopedidocompra:estadopedidocompras){
			estadopedidocompra.setEstadoPedidoCompraOriginal((EstadoPedidoCompra)estadopedidocompra.clone());
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
	
	public  EstadoPedidoCompra getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		EstadoPedidoCompra entity = new EstadoPedidoCompra();		
		
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
	
	public  EstadoPedidoCompra getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		EstadoPedidoCompra entity = new EstadoPedidoCompra();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoPedidoCompraDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoPedidoCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Importaciones.EstadoPedidoCompra.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setEstadoPedidoCompraOriginal(new EstadoPedidoCompra());
      	    	entity=super.getEntity("",entity,resultSet,EstadoPedidoCompraDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEstadoPedidoCompra("",entity,resultSet); 
				
				//entity.setEstadoPedidoCompraOriginal(super.getEntity("",entity.getEstadoPedidoCompraOriginal(),resultSet,EstadoPedidoCompraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoPedidoCompraOriginal(this.getEntityEstadoPedidoCompra("",entity.getEstadoPedidoCompraOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseEstadoPedidoCompra(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  EstadoPedidoCompra getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EstadoPedidoCompra entity = new EstadoPedidoCompra();
				
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
	
	public  EstadoPedidoCompra getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EstadoPedidoCompra entity = new EstadoPedidoCompra();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoPedidoCompraDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoPedidoCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoPedidoCompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Importaciones.EstadoPedidoCompra.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setEstadoPedidoCompraOriginal(new EstadoPedidoCompra());
      	    	entity=super.getEntity("",entity,resultSet,EstadoPedidoCompraDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEstadoPedidoCompra("",entity,resultSet);    
				
				//entity.setEstadoPedidoCompraOriginal(super.getEntity("",entity.getEstadoPedidoCompraOriginal(),resultSet,EstadoPedidoCompraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoPedidoCompraOriginal(this.getEntityEstadoPedidoCompra("",entity.getEstadoPedidoCompraOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseEstadoPedidoCompra(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //EstadoPedidoCompra
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		EstadoPedidoCompra entity = new EstadoPedidoCompra();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoPedidoCompraDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoPedidoCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoPedidoCompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Importaciones.EstadoPedidoCompra.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseEstadoPedidoCompra(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<EstadoPedidoCompra> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EstadoPedidoCompra> entities = new  ArrayList<EstadoPedidoCompra>();
		EstadoPedidoCompra entity = new EstadoPedidoCompra();		  
		
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
	
	public  List<EstadoPedidoCompra> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EstadoPedidoCompra> entities = new  ArrayList<EstadoPedidoCompra>();
		EstadoPedidoCompra entity = new EstadoPedidoCompra();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoPedidoCompraDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoPedidoCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoPedidoCompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoPedidoCompra();
      	    	entity=super.getEntity("",entity,resultSet,EstadoPedidoCompraDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoPedidoCompra("",entity,resultSet);
      	    	
				//entity.setEstadoPedidoCompraOriginal( new EstadoPedidoCompra());
      	    	//entity.setEstadoPedidoCompraOriginal(super.getEntity("",entity.getEstadoPedidoCompraOriginal(),resultSet,EstadoPedidoCompraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoPedidoCompraOriginal(this.getEntityEstadoPedidoCompra("",entity.getEstadoPedidoCompraOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoPedidoCompras(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoPedidoCompra(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<EstadoPedidoCompra> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EstadoPedidoCompra> entities = new  ArrayList<EstadoPedidoCompra>();
		EstadoPedidoCompra entity = new EstadoPedidoCompra();		  
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
	
	public  List<EstadoPedidoCompra> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EstadoPedidoCompra> entities = new  ArrayList<EstadoPedidoCompra>();
		EstadoPedidoCompra entity = new EstadoPedidoCompra();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoPedidoCompra();
				
				if(conMapGenerico) {
					entity.inicializarMapEstadoPedidoCompra();
					//entity.setMapEstadoPedidoCompra(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapEstadoPedidoCompraValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEstadoPedidoCompra().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EstadoPedidoCompraDataAccess.ISWITHSCHEMA);         		
					entity=EstadoPedidoCompraDataAccess.getEntityEstadoPedidoCompra("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEstadoPedidoCompraOriginal( new EstadoPedidoCompra());
					////entity.setEstadoPedidoCompraOriginal(super.getEntity("",entity.getEstadoPedidoCompraOriginal(),resultSet,EstadoPedidoCompraDataAccess.ISWITHSCHEMA));         		
					////entity.setEstadoPedidoCompraOriginal(this.getEntityEstadoPedidoCompra("",entity.getEstadoPedidoCompraOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoPedidoCompras(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoPedidoCompra(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public EstadoPedidoCompra getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EstadoPedidoCompra entity = new EstadoPedidoCompra();		  
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
	
	public  EstadoPedidoCompra getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EstadoPedidoCompra entity = new EstadoPedidoCompra();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoPedidoCompra();
				
				if(conMapGenerico) {
					entity.inicializarMapEstadoPedidoCompra();
					//entity.setMapEstadoPedidoCompra(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapEstadoPedidoCompraValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEstadoPedidoCompra().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EstadoPedidoCompraDataAccess.ISWITHSCHEMA);         		
					entity=EstadoPedidoCompraDataAccess.getEntityEstadoPedidoCompra("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEstadoPedidoCompraOriginal( new EstadoPedidoCompra());
					////entity.setEstadoPedidoCompraOriginal(super.getEntity("",entity.getEstadoPedidoCompraOriginal(),resultSet,EstadoPedidoCompraDataAccess.ISWITHSCHEMA));         		
					////entity.setEstadoPedidoCompraOriginal(this.getEntityEstadoPedidoCompra("",entity.getEstadoPedidoCompraOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseEstadoPedidoCompra(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoPedidoCompra(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static EstadoPedidoCompra getEntityEstadoPedidoCompra(String strPrefijo,EstadoPedidoCompra entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = EstadoPedidoCompra.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = EstadoPedidoCompra.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					EstadoPedidoCompraDataAccess.setFieldReflectionEstadoPedidoCompra(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasEstadoPedidoCompra=EstadoPedidoCompraConstantesFunciones.getTodosTiposColumnasEstadoPedidoCompra();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasEstadoPedidoCompra) {
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
							field = EstadoPedidoCompra.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = EstadoPedidoCompra.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						EstadoPedidoCompraDataAccess.setFieldReflectionEstadoPedidoCompra(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionEstadoPedidoCompra(Field field,String strPrefijo,String sColumn,EstadoPedidoCompra entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case EstadoPedidoCompraConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EstadoPedidoCompraConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EstadoPedidoCompraConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EstadoPedidoCompraConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EstadoPedidoCompra>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<EstadoPedidoCompra> entities = new  ArrayList<EstadoPedidoCompra>();
		EstadoPedidoCompra entity = new EstadoPedidoCompra();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoPedidoCompraDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoPedidoCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoPedidoCompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new EstadoPedidoCompra();
					entity=super.getEntity("",entity,resultSet,EstadoPedidoCompraDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityEstadoPedidoCompra("",entity,resultSet);
					
					//entity.setEstadoPedidoCompraOriginal( new EstadoPedidoCompra());
					//entity.setEstadoPedidoCompraOriginal(super.getEntity("",entity.getEstadoPedidoCompraOriginal(),resultSet,EstadoPedidoCompraDataAccess.ISWITHSCHEMA));         		
					//entity.setEstadoPedidoCompraOriginal(this.getEntityEstadoPedidoCompra("",entity.getEstadoPedidoCompraOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseEstadoPedidoCompras(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoPedidoCompra(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EstadoPedidoCompra>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<EstadoPedidoCompra> entities = new  ArrayList<EstadoPedidoCompra>();
		EstadoPedidoCompra entity = new EstadoPedidoCompra();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoPedidoCompraDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoPedidoCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoPedidoCompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<EstadoPedidoCompra> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoPedidoCompra> entities = new  ArrayList<EstadoPedidoCompra>();
		EstadoPedidoCompra entity = new EstadoPedidoCompra();		  
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
	
	public  List<EstadoPedidoCompra> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoPedidoCompra> entities = new  ArrayList<EstadoPedidoCompra>();
		EstadoPedidoCompra entity = new EstadoPedidoCompra();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoPedidoCompra();
      	    	entity=super.getEntity("",entity,resultSet,EstadoPedidoCompraDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoPedidoCompra("",entity,resultSet);
      	    	
				//entity.setEstadoPedidoCompraOriginal( new EstadoPedidoCompra());
      	    	//entity.setEstadoPedidoCompraOriginal(super.getEntity("",entity.getEstadoPedidoCompraOriginal(),resultSet,EstadoPedidoCompraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoPedidoCompraOriginal(this.getEntityEstadoPedidoCompra("",entity.getEstadoPedidoCompraOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseEstadoPedidoCompras(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoPedidoCompra(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	
	
	public EstadoPedidoCompra getEntityEstadoPedidoCompra(String strPrefijo,EstadoPedidoCompra entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setcodigo(resultSet.getString(strPrefijo+EstadoPedidoCompraConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+EstadoPedidoCompraConstantesFunciones.NOMBRE));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+EstadoPedidoCompraConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowEstadoPedidoCompra(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(EstadoPedidoCompra entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=EstadoPedidoCompraDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=EstadoPedidoCompraDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=EstadoPedidoCompraDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=EstadoPedidoCompraDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(EstadoPedidoCompraConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,EstadoPedidoCompraDataAccess.TABLENAME,EstadoPedidoCompraDataAccess.ISWITHSTOREPROCEDURES);
			
			EstadoPedidoCompraDataAccess.setEstadoPedidoCompraOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
	
		
		public List<PedidoCompra> getPedidoCompras(Connexion connexion,EstadoPedidoCompra estadopedidocompra)throws SQLException,Exception {

		List<PedidoCompra> pedidocompras= new ArrayList<PedidoCompra>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstadoPedidoCompraConstantesFunciones.SCHEMA+".estado_pedido_compra ON "+PedidoCompraConstantesFunciones.SCHEMA+".pedido_compra.id_estado_pedido_compra="+EstadoPedidoCompraConstantesFunciones.SCHEMA+".estado_pedido_compra.id WHERE "+EstadoPedidoCompraConstantesFunciones.SCHEMA+".estado_pedido_compra.id="+String.valueOf(estadopedidocompra.getId());
			} else {
				sQuery=" INNER JOIN pedidocompra.EstadoPedidoCompra WHERE pedidocompra.EstadoPedidoCompra.id="+String.valueOf(estadopedidocompra.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PedidoCompraDataAccess pedidocompraDataAccess=new PedidoCompraDataAccess();

			pedidocompraDataAccess.setConnexionType(this.connexionType);
			pedidocompraDataAccess.setParameterDbType(this.parameterDbType);
			pedidocompras=pedidocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pedidocompras;

	}

	public List<PedidoCompraImpor> getPedidoCompraImpors(Connexion connexion,EstadoPedidoCompra estadopedidocompra)throws SQLException,Exception {

		List<PedidoCompraImpor> pedidocompraimpors= new ArrayList<PedidoCompraImpor>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstadoPedidoCompraConstantesFunciones.SCHEMA+".estado_pedido_compra ON "+PedidoCompraImporConstantesFunciones.SCHEMA+".pedido_compra_impor.id_estado_pedido_compra="+EstadoPedidoCompraConstantesFunciones.SCHEMA+".estado_pedido_compra.id WHERE "+EstadoPedidoCompraConstantesFunciones.SCHEMA+".estado_pedido_compra.id="+String.valueOf(estadopedidocompra.getId());
			} else {
				sQuery=" INNER JOIN pedidocompraimpor.EstadoPedidoCompra WHERE pedidocompraimpor.EstadoPedidoCompra.id="+String.valueOf(estadopedidocompra.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PedidoCompraImporDataAccess pedidocompraimporDataAccess=new PedidoCompraImporDataAccess();

			pedidocompraimporDataAccess.setConnexionType(this.connexionType);
			pedidocompraimporDataAccess.setParameterDbType(this.parameterDbType);
			pedidocompraimpors=pedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pedidocompraimpors;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,EstadoPedidoCompra estadopedidocompra) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!estadopedidocompra.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid=new ParameterValue<Long>();
					parameterMaintenanceValueid.setValue(estadopedidocompra.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(estadopedidocompra.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(estadopedidocompra.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!estadopedidocompra.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(estadopedidocompra.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(estadopedidocompra.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(estadopedidocompra.getId());
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
	
	public void setIsNewIsChangedFalseEstadoPedidoCompra(EstadoPedidoCompra estadopedidocompra)throws Exception  {		
		estadopedidocompra.setIsNew(false);
		estadopedidocompra.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseEstadoPedidoCompras(List<EstadoPedidoCompra> estadopedidocompras)throws Exception  {				
		for(EstadoPedidoCompra estadopedidocompra:estadopedidocompras) {
			estadopedidocompra.setIsNew(false);
			estadopedidocompra.setIsChanged(false);
		}
	}
	
	public void generarExportarEstadoPedidoCompra(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
