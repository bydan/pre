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
import com.bydan.framework.erp.business.dataaccess.DataAccessHelperSinIdGenerated;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.facturacion.util.*;//EstadoDetallePedidoConstantesFunciones;


import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.inventario.business.dataaccess.*;


import com.bydan.erp.inventario.util.*;




@SuppressWarnings("unused")
final public class EstadoDetallePedidoDataAccess extends  DataAccessHelperSinIdGenerated<EstadoDetallePedido>{ //EstadoDetallePedidoDataAccessAdditional,DataAccessHelper<EstadoDetallePedido>
	//static Logger logger = Logger.getLogger(EstadoDetallePedidoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="estado_detalle_pedido";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+EstadoDetallePedidoConstantesFunciones.SCHEMA+"."+EstadoDetallePedidoConstantesFunciones.TABLENAME+"(id,version_row,codigo,nombre)values(?,current_timestamp,?,?)";
	public static String QUERYUPDATE="update "+EstadoDetallePedidoConstantesFunciones.SCHEMA+"."+EstadoDetallePedidoConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+EstadoDetallePedidoConstantesFunciones.SCHEMA+"."+EstadoDetallePedidoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select estadodetallepedido from "+EstadoDetallePedidoConstantesFunciones.SPERSISTENCENAME+" estadodetallepedido";
	public static String QUERYSELECTNATIVE="select "+EstadoDetallePedidoConstantesFunciones.SCHEMA+"."+EstadoDetallePedidoConstantesFunciones.TABLENAME+".id,"+EstadoDetallePedidoConstantesFunciones.SCHEMA+"."+EstadoDetallePedidoConstantesFunciones.TABLENAME+".version_row,"+EstadoDetallePedidoConstantesFunciones.SCHEMA+"."+EstadoDetallePedidoConstantesFunciones.TABLENAME+".codigo,"+EstadoDetallePedidoConstantesFunciones.SCHEMA+"."+EstadoDetallePedidoConstantesFunciones.TABLENAME+".nombre from "+EstadoDetallePedidoConstantesFunciones.SCHEMA+"."+EstadoDetallePedidoConstantesFunciones.TABLENAME;//+" as "+EstadoDetallePedidoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+EstadoDetallePedidoConstantesFunciones.SCHEMA+"."+EstadoDetallePedidoConstantesFunciones.TABLENAME+".id,"+EstadoDetallePedidoConstantesFunciones.SCHEMA+"."+EstadoDetallePedidoConstantesFunciones.TABLENAME+".version_row,"+EstadoDetallePedidoConstantesFunciones.SCHEMA+"."+EstadoDetallePedidoConstantesFunciones.TABLENAME+".codigo from "+EstadoDetallePedidoConstantesFunciones.SCHEMA+"."+EstadoDetallePedidoConstantesFunciones.TABLENAME;//+" as "+EstadoDetallePedidoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+EstadoDetallePedidoConstantesFunciones.SCHEMA+"."+EstadoDetallePedidoConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_ESTADODETALLEPEDIDO_INSERT(?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_ESTADODETALLEPEDIDO_UPDATE(?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_ESTADODETALLEPEDIDO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_ESTADODETALLEPEDIDO_SELECT(?,?)";
	
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
	
	
	public EstadoDetallePedidoDataAccess() {
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
		EstadoDetallePedidoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		EstadoDetallePedidoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		EstadoDetallePedidoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setEstadoDetallePedidoOriginal(EstadoDetallePedido estadodetallepedido)throws Exception  {
		estadodetallepedido.setEstadoDetallePedidoOriginal((EstadoDetallePedido)estadodetallepedido.clone());		
	}
	
	public void setEstadoDetallePedidosOriginal(List<EstadoDetallePedido> estadodetallepedidos)throws Exception  {
		
		for(EstadoDetallePedido estadodetallepedido:estadodetallepedidos){
			estadodetallepedido.setEstadoDetallePedidoOriginal((EstadoDetallePedido)estadodetallepedido.clone());
		}
	}
	
	public static void setEstadoDetallePedidoOriginalStatic(EstadoDetallePedido estadodetallepedido)throws Exception  {
		estadodetallepedido.setEstadoDetallePedidoOriginal((EstadoDetallePedido)estadodetallepedido.clone());		
	}
	
	public static void setEstadoDetallePedidosOriginalStatic(List<EstadoDetallePedido> estadodetallepedidos)throws Exception  {
		
		for(EstadoDetallePedido estadodetallepedido:estadodetallepedidos){
			estadodetallepedido.setEstadoDetallePedidoOriginal((EstadoDetallePedido)estadodetallepedido.clone());
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
	
	public  EstadoDetallePedido getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		EstadoDetallePedido entity = new EstadoDetallePedido();		
		
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
	
	public  EstadoDetallePedido getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		EstadoDetallePedido entity = new EstadoDetallePedido();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoDetallePedidoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoDetallePedidoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Facturacion.EstadoDetallePedido.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setEstadoDetallePedidoOriginal(new EstadoDetallePedido());
      	    	entity=super.getEntity("",entity,resultSet,EstadoDetallePedidoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEstadoDetallePedido("",entity,resultSet); 
				
				//entity.setEstadoDetallePedidoOriginal(super.getEntity("",entity.getEstadoDetallePedidoOriginal(),resultSet,EstadoDetallePedidoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoDetallePedidoOriginal(this.getEntityEstadoDetallePedido("",entity.getEstadoDetallePedidoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseEstadoDetallePedido(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  EstadoDetallePedido getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EstadoDetallePedido entity = new EstadoDetallePedido();
				
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
	
	public  EstadoDetallePedido getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EstadoDetallePedido entity = new EstadoDetallePedido();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoDetallePedidoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoDetallePedidoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoDetallePedidoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.EstadoDetallePedido.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setEstadoDetallePedidoOriginal(new EstadoDetallePedido());
      	    	entity=super.getEntity("",entity,resultSet,EstadoDetallePedidoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEstadoDetallePedido("",entity,resultSet);    
				
				//entity.setEstadoDetallePedidoOriginal(super.getEntity("",entity.getEstadoDetallePedidoOriginal(),resultSet,EstadoDetallePedidoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoDetallePedidoOriginal(this.getEntityEstadoDetallePedido("",entity.getEstadoDetallePedidoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseEstadoDetallePedido(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //EstadoDetallePedido
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		EstadoDetallePedido entity = new EstadoDetallePedido();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoDetallePedidoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoDetallePedidoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoDetallePedidoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.EstadoDetallePedido.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseEstadoDetallePedido(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<EstadoDetallePedido> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EstadoDetallePedido> entities = new  ArrayList<EstadoDetallePedido>();
		EstadoDetallePedido entity = new EstadoDetallePedido();		  
		
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
	
	public  List<EstadoDetallePedido> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EstadoDetallePedido> entities = new  ArrayList<EstadoDetallePedido>();
		EstadoDetallePedido entity = new EstadoDetallePedido();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoDetallePedidoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoDetallePedidoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoDetallePedidoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoDetallePedido();
      	    	entity=super.getEntity("",entity,resultSet,EstadoDetallePedidoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoDetallePedido("",entity,resultSet);
      	    	
				//entity.setEstadoDetallePedidoOriginal( new EstadoDetallePedido());
      	    	//entity.setEstadoDetallePedidoOriginal(super.getEntity("",entity.getEstadoDetallePedidoOriginal(),resultSet,EstadoDetallePedidoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoDetallePedidoOriginal(this.getEntityEstadoDetallePedido("",entity.getEstadoDetallePedidoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoDetallePedidos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoDetallePedido(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<EstadoDetallePedido> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EstadoDetallePedido> entities = new  ArrayList<EstadoDetallePedido>();
		EstadoDetallePedido entity = new EstadoDetallePedido();		  
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
	
	public  List<EstadoDetallePedido> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EstadoDetallePedido> entities = new  ArrayList<EstadoDetallePedido>();
		EstadoDetallePedido entity = new EstadoDetallePedido();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoDetallePedido();
				
				if(conMapGenerico) {
					entity.inicializarMapEstadoDetallePedido();
					//entity.setMapEstadoDetallePedido(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapEstadoDetallePedidoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEstadoDetallePedido().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EstadoDetallePedidoDataAccess.ISWITHSCHEMA);         		
					entity=EstadoDetallePedidoDataAccess.getEntityEstadoDetallePedido("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEstadoDetallePedidoOriginal( new EstadoDetallePedido());
					////entity.setEstadoDetallePedidoOriginal(super.getEntity("",entity.getEstadoDetallePedidoOriginal(),resultSet,EstadoDetallePedidoDataAccess.ISWITHSCHEMA));         		
					////entity.setEstadoDetallePedidoOriginal(this.getEntityEstadoDetallePedido("",entity.getEstadoDetallePedidoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoDetallePedidos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoDetallePedido(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public EstadoDetallePedido getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EstadoDetallePedido entity = new EstadoDetallePedido();		  
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
	
	public  EstadoDetallePedido getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EstadoDetallePedido entity = new EstadoDetallePedido();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoDetallePedido();
				
				if(conMapGenerico) {
					entity.inicializarMapEstadoDetallePedido();
					//entity.setMapEstadoDetallePedido(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapEstadoDetallePedidoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEstadoDetallePedido().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EstadoDetallePedidoDataAccess.ISWITHSCHEMA);         		
					entity=EstadoDetallePedidoDataAccess.getEntityEstadoDetallePedido("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEstadoDetallePedidoOriginal( new EstadoDetallePedido());
					////entity.setEstadoDetallePedidoOriginal(super.getEntity("",entity.getEstadoDetallePedidoOriginal(),resultSet,EstadoDetallePedidoDataAccess.ISWITHSCHEMA));         		
					////entity.setEstadoDetallePedidoOriginal(this.getEntityEstadoDetallePedido("",entity.getEstadoDetallePedidoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseEstadoDetallePedido(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoDetallePedido(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static EstadoDetallePedido getEntityEstadoDetallePedido(String strPrefijo,EstadoDetallePedido entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = EstadoDetallePedido.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = EstadoDetallePedido.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					EstadoDetallePedidoDataAccess.setFieldReflectionEstadoDetallePedido(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasEstadoDetallePedido=EstadoDetallePedidoConstantesFunciones.getTodosTiposColumnasEstadoDetallePedido();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasEstadoDetallePedido) {
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
							field = EstadoDetallePedido.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = EstadoDetallePedido.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						EstadoDetallePedidoDataAccess.setFieldReflectionEstadoDetallePedido(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionEstadoDetallePedido(Field field,String strPrefijo,String sColumn,EstadoDetallePedido entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case EstadoDetallePedidoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EstadoDetallePedidoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EstadoDetallePedidoConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EstadoDetallePedidoConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EstadoDetallePedido>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<EstadoDetallePedido> entities = new  ArrayList<EstadoDetallePedido>();
		EstadoDetallePedido entity = new EstadoDetallePedido();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoDetallePedidoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoDetallePedidoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoDetallePedidoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new EstadoDetallePedido();
					entity=super.getEntity("",entity,resultSet,EstadoDetallePedidoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityEstadoDetallePedido("",entity,resultSet);
					
					//entity.setEstadoDetallePedidoOriginal( new EstadoDetallePedido());
					//entity.setEstadoDetallePedidoOriginal(super.getEntity("",entity.getEstadoDetallePedidoOriginal(),resultSet,EstadoDetallePedidoDataAccess.ISWITHSCHEMA));         		
					//entity.setEstadoDetallePedidoOriginal(this.getEntityEstadoDetallePedido("",entity.getEstadoDetallePedidoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseEstadoDetallePedidos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoDetallePedido(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EstadoDetallePedido>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<EstadoDetallePedido> entities = new  ArrayList<EstadoDetallePedido>();
		EstadoDetallePedido entity = new EstadoDetallePedido();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoDetallePedidoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoDetallePedidoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoDetallePedidoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<EstadoDetallePedido> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoDetallePedido> entities = new  ArrayList<EstadoDetallePedido>();
		EstadoDetallePedido entity = new EstadoDetallePedido();		  
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
	
	public  List<EstadoDetallePedido> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoDetallePedido> entities = new  ArrayList<EstadoDetallePedido>();
		EstadoDetallePedido entity = new EstadoDetallePedido();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoDetallePedido();
      	    	entity=super.getEntity("",entity,resultSet,EstadoDetallePedidoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoDetallePedido("",entity,resultSet);
      	    	
				//entity.setEstadoDetallePedidoOriginal( new EstadoDetallePedido());
      	    	//entity.setEstadoDetallePedidoOriginal(super.getEntity("",entity.getEstadoDetallePedidoOriginal(),resultSet,EstadoDetallePedidoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoDetallePedidoOriginal(this.getEntityEstadoDetallePedido("",entity.getEstadoDetallePedidoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseEstadoDetallePedidos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoDetallePedido(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	
	
	public EstadoDetallePedido getEntityEstadoDetallePedido(String strPrefijo,EstadoDetallePedido entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setcodigo(resultSet.getString(strPrefijo+EstadoDetallePedidoConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+EstadoDetallePedidoConstantesFunciones.NOMBRE));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+EstadoDetallePedidoConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowEstadoDetallePedido(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(EstadoDetallePedido entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=EstadoDetallePedidoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=EstadoDetallePedidoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=EstadoDetallePedidoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=EstadoDetallePedidoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(EstadoDetallePedidoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,EstadoDetallePedidoDataAccess.TABLENAME,EstadoDetallePedidoDataAccess.ISWITHSTOREPROCEDURES);
			
			EstadoDetallePedidoDataAccess.setEstadoDetallePedidoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
	
		
		public List<DetalleConsignacion> getDetalleConsignacions(Connexion connexion,EstadoDetallePedido estadodetallepedido)throws SQLException,Exception {

		List<DetalleConsignacion> detalleconsignacions= new ArrayList<DetalleConsignacion>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstadoDetallePedidoConstantesFunciones.SCHEMA+".estado_detalle_pedido ON "+DetalleConsignacionConstantesFunciones.SCHEMA+".detalle_consignacion.id_estado_detalle_pedido="+EstadoDetallePedidoConstantesFunciones.SCHEMA+".estado_detalle_pedido.id WHERE "+EstadoDetallePedidoConstantesFunciones.SCHEMA+".estado_detalle_pedido.id="+String.valueOf(estadodetallepedido.getId());
			} else {
				sQuery=" INNER JOIN detalleconsignacion.EstadoDetallePedido WHERE detalleconsignacion.EstadoDetallePedido.id="+String.valueOf(estadodetallepedido.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleConsignacionDataAccess detalleconsignacionDataAccess=new DetalleConsignacionDataAccess();

			detalleconsignacionDataAccess.setConnexionType(this.connexionType);
			detalleconsignacionDataAccess.setParameterDbType(this.parameterDbType);
			detalleconsignacions=detalleconsignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalleconsignacions;

	}

	public List<DetallePedido> getDetallePedidos(Connexion connexion,EstadoDetallePedido estadodetallepedido)throws SQLException,Exception {

		List<DetallePedido> detallepedidos= new ArrayList<DetallePedido>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstadoDetallePedidoConstantesFunciones.SCHEMA+".estado_detalle_pedido ON "+DetallePedidoConstantesFunciones.SCHEMA+".detalle_pedido.id_estado_detalle_pedido="+EstadoDetallePedidoConstantesFunciones.SCHEMA+".estado_detalle_pedido.id WHERE "+EstadoDetallePedidoConstantesFunciones.SCHEMA+".estado_detalle_pedido.id="+String.valueOf(estadodetallepedido.getId());
			} else {
				sQuery=" INNER JOIN detallepedido.EstadoDetallePedido WHERE detallepedido.EstadoDetallePedido.id="+String.valueOf(estadodetallepedido.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetallePedidoDataAccess detallepedidoDataAccess=new DetallePedidoDataAccess();

			detallepedidoDataAccess.setConnexionType(this.connexionType);
			detallepedidoDataAccess.setParameterDbType(this.parameterDbType);
			detallepedidos=detallepedidoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detallepedidos;

	}

	public List<DetallePedidoExpor> getDetallePedidoExporExpors(Connexion connexion,EstadoDetallePedido estadodetallepedido)throws SQLException,Exception {

		List<DetallePedidoExpor> detallepedidoexporexpors= new ArrayList<DetallePedidoExpor>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstadoDetallePedidoConstantesFunciones.SCHEMA+".estado_detalle_pedido ON "+DetallePedidoExporConstantesFunciones.SCHEMA+".detalle_pedido_expor.id_estado_detalle_pedido="+EstadoDetallePedidoConstantesFunciones.SCHEMA+".estado_detalle_pedido.id WHERE "+EstadoDetallePedidoConstantesFunciones.SCHEMA+".estado_detalle_pedido.id="+String.valueOf(estadodetallepedido.getId());
			} else {
				sQuery=" INNER JOIN detallepedidoexpor.EstadoDetallePedidoExpor WHERE detallepedidoexpor.EstadoDetallePedidoExpor.id="+String.valueOf(estadodetallepedido.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetallePedidoExporDataAccess detallepedidoexporDataAccess=new DetallePedidoExporDataAccess();

			detallepedidoexporDataAccess.setConnexionType(this.connexionType);
			detallepedidoexporDataAccess.setParameterDbType(this.parameterDbType);
			detallepedidoexporexpors=detallepedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detallepedidoexporexpors;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,EstadoDetallePedido estadodetallepedido) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!estadodetallepedido.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid=new ParameterValue<Long>();
					parameterMaintenanceValueid.setValue(estadodetallepedido.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(estadodetallepedido.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(estadodetallepedido.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!estadodetallepedido.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(estadodetallepedido.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(estadodetallepedido.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(estadodetallepedido.getId());
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
	
	public void setIsNewIsChangedFalseEstadoDetallePedido(EstadoDetallePedido estadodetallepedido)throws Exception  {		
		estadodetallepedido.setIsNew(false);
		estadodetallepedido.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseEstadoDetallePedidos(List<EstadoDetallePedido> estadodetallepedidos)throws Exception  {				
		for(EstadoDetallePedido estadodetallepedido:estadodetallepedidos) {
			estadodetallepedido.setIsNew(false);
			estadodetallepedido.setIsChanged(false);
		}
	}
	
	public void generarExportarEstadoDetallePedido(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
