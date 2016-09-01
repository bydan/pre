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
import com.bydan.erp.facturacion.util.*;//TipoEstadoPedidoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class TipoEstadoPedidoDataAccess extends  DataAccessHelperSinIdGenerated<TipoEstadoPedido>{ //TipoEstadoPedidoDataAccessAdditional,DataAccessHelper<TipoEstadoPedido>
	//static Logger logger = Logger.getLogger(TipoEstadoPedidoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_estado_pedido";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoEstadoPedidoConstantesFunciones.SCHEMA+"."+TipoEstadoPedidoConstantesFunciones.TABLENAME+"(id,version_row,id_pais,nombre)values(?,current_timestamp,?,?)";
	public static String QUERYUPDATE="update "+TipoEstadoPedidoConstantesFunciones.SCHEMA+"."+TipoEstadoPedidoConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,id_pais=?,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoEstadoPedidoConstantesFunciones.SCHEMA+"."+TipoEstadoPedidoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tipoestadopedido from "+TipoEstadoPedidoConstantesFunciones.SPERSISTENCENAME+" tipoestadopedido";
	public static String QUERYSELECTNATIVE="select "+TipoEstadoPedidoConstantesFunciones.SCHEMA+"."+TipoEstadoPedidoConstantesFunciones.TABLENAME+".id,"+TipoEstadoPedidoConstantesFunciones.SCHEMA+"."+TipoEstadoPedidoConstantesFunciones.TABLENAME+".version_row,"+TipoEstadoPedidoConstantesFunciones.SCHEMA+"."+TipoEstadoPedidoConstantesFunciones.TABLENAME+".id_pais,"+TipoEstadoPedidoConstantesFunciones.SCHEMA+"."+TipoEstadoPedidoConstantesFunciones.TABLENAME+".nombre from "+TipoEstadoPedidoConstantesFunciones.SCHEMA+"."+TipoEstadoPedidoConstantesFunciones.TABLENAME;//+" as "+TipoEstadoPedidoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoEstadoPedidoConstantesFunciones.SCHEMA+"."+TipoEstadoPedidoConstantesFunciones.TABLENAME+".id,"+TipoEstadoPedidoConstantesFunciones.SCHEMA+"."+TipoEstadoPedidoConstantesFunciones.TABLENAME+".version_row,"+TipoEstadoPedidoConstantesFunciones.SCHEMA+"."+TipoEstadoPedidoConstantesFunciones.TABLENAME+".nombre from "+TipoEstadoPedidoConstantesFunciones.SCHEMA+"."+TipoEstadoPedidoConstantesFunciones.TABLENAME;//+" as "+TipoEstadoPedidoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoEstadoPedidoConstantesFunciones.SCHEMA+"."+TipoEstadoPedidoConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,id_pais=?,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPOESTADOPEDIDO_INSERT(?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPOESTADOPEDIDO_UPDATE(?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPOESTADOPEDIDO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPOESTADOPEDIDO_SELECT(?,?)";
	
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
	
	
	public TipoEstadoPedidoDataAccess() {
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
		TipoEstadoPedidoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoEstadoPedidoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoEstadoPedidoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoEstadoPedidoOriginal(TipoEstadoPedido tipoestadopedido)throws Exception  {
		tipoestadopedido.setTipoEstadoPedidoOriginal((TipoEstadoPedido)tipoestadopedido.clone());		
	}
	
	public void setTipoEstadoPedidosOriginal(List<TipoEstadoPedido> tipoestadopedidos)throws Exception  {
		
		for(TipoEstadoPedido tipoestadopedido:tipoestadopedidos){
			tipoestadopedido.setTipoEstadoPedidoOriginal((TipoEstadoPedido)tipoestadopedido.clone());
		}
	}
	
	public static void setTipoEstadoPedidoOriginalStatic(TipoEstadoPedido tipoestadopedido)throws Exception  {
		tipoestadopedido.setTipoEstadoPedidoOriginal((TipoEstadoPedido)tipoestadopedido.clone());		
	}
	
	public static void setTipoEstadoPedidosOriginalStatic(List<TipoEstadoPedido> tipoestadopedidos)throws Exception  {
		
		for(TipoEstadoPedido tipoestadopedido:tipoestadopedidos){
			tipoestadopedido.setTipoEstadoPedidoOriginal((TipoEstadoPedido)tipoestadopedido.clone());
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
	
	public  TipoEstadoPedido getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoEstadoPedido entity = new TipoEstadoPedido();		
		
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
	
	public  TipoEstadoPedido getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoEstadoPedido entity = new TipoEstadoPedido();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoEstadoPedidoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoEstadoPedidoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Facturacion.TipoEstadoPedido.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoEstadoPedidoOriginal(new TipoEstadoPedido());
      	    	entity=super.getEntity("",entity,resultSet,TipoEstadoPedidoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoEstadoPedido("",entity,resultSet); 
				
				//entity.setTipoEstadoPedidoOriginal(super.getEntity("",entity.getTipoEstadoPedidoOriginal(),resultSet,TipoEstadoPedidoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoEstadoPedidoOriginal(this.getEntityTipoEstadoPedido("",entity.getTipoEstadoPedidoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoEstadoPedido(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoEstadoPedido getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoEstadoPedido entity = new TipoEstadoPedido();
				
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
	
	public  TipoEstadoPedido getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoEstadoPedido entity = new TipoEstadoPedido();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoEstadoPedidoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoEstadoPedidoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoEstadoPedidoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.TipoEstadoPedido.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoEstadoPedidoOriginal(new TipoEstadoPedido());
      	    	entity=super.getEntity("",entity,resultSet,TipoEstadoPedidoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoEstadoPedido("",entity,resultSet);    
				
				//entity.setTipoEstadoPedidoOriginal(super.getEntity("",entity.getTipoEstadoPedidoOriginal(),resultSet,TipoEstadoPedidoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoEstadoPedidoOriginal(this.getEntityTipoEstadoPedido("",entity.getTipoEstadoPedidoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoEstadoPedido(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoEstadoPedido
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoEstadoPedido entity = new TipoEstadoPedido();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoEstadoPedidoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoEstadoPedidoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoEstadoPedidoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.TipoEstadoPedido.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoEstadoPedido(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoEstadoPedido> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoEstadoPedido> entities = new  ArrayList<TipoEstadoPedido>();
		TipoEstadoPedido entity = new TipoEstadoPedido();		  
		
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
	
	public  List<TipoEstadoPedido> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoEstadoPedido> entities = new  ArrayList<TipoEstadoPedido>();
		TipoEstadoPedido entity = new TipoEstadoPedido();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoEstadoPedidoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoEstadoPedidoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoEstadoPedidoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoEstadoPedido();
      	    	entity=super.getEntity("",entity,resultSet,TipoEstadoPedidoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoEstadoPedido("",entity,resultSet);
      	    	
				//entity.setTipoEstadoPedidoOriginal( new TipoEstadoPedido());
      	    	//entity.setTipoEstadoPedidoOriginal(super.getEntity("",entity.getTipoEstadoPedidoOriginal(),resultSet,TipoEstadoPedidoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoEstadoPedidoOriginal(this.getEntityTipoEstadoPedido("",entity.getTipoEstadoPedidoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoEstadoPedidos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoEstadoPedido(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoEstadoPedido> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoEstadoPedido> entities = new  ArrayList<TipoEstadoPedido>();
		TipoEstadoPedido entity = new TipoEstadoPedido();		  
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
	
	public  List<TipoEstadoPedido> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoEstadoPedido> entities = new  ArrayList<TipoEstadoPedido>();
		TipoEstadoPedido entity = new TipoEstadoPedido();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoEstadoPedido();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoEstadoPedido();
					//entity.setMapTipoEstadoPedido(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoEstadoPedidoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoEstadoPedido().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoEstadoPedidoDataAccess.ISWITHSCHEMA);         		
					entity=TipoEstadoPedidoDataAccess.getEntityTipoEstadoPedido("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoEstadoPedidoOriginal( new TipoEstadoPedido());
					////entity.setTipoEstadoPedidoOriginal(super.getEntity("",entity.getTipoEstadoPedidoOriginal(),resultSet,TipoEstadoPedidoDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoEstadoPedidoOriginal(this.getEntityTipoEstadoPedido("",entity.getTipoEstadoPedidoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoEstadoPedidos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoEstadoPedido(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoEstadoPedido getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoEstadoPedido entity = new TipoEstadoPedido();		  
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
	
	public  TipoEstadoPedido getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoEstadoPedido entity = new TipoEstadoPedido();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoEstadoPedido();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoEstadoPedido();
					//entity.setMapTipoEstadoPedido(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoEstadoPedidoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoEstadoPedido().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoEstadoPedidoDataAccess.ISWITHSCHEMA);         		
					entity=TipoEstadoPedidoDataAccess.getEntityTipoEstadoPedido("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoEstadoPedidoOriginal( new TipoEstadoPedido());
					////entity.setTipoEstadoPedidoOriginal(super.getEntity("",entity.getTipoEstadoPedidoOriginal(),resultSet,TipoEstadoPedidoDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoEstadoPedidoOriginal(this.getEntityTipoEstadoPedido("",entity.getTipoEstadoPedidoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoEstadoPedido(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoEstadoPedido(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoEstadoPedido getEntityTipoEstadoPedido(String strPrefijo,TipoEstadoPedido entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoEstadoPedido.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoEstadoPedido.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoEstadoPedidoDataAccess.setFieldReflectionTipoEstadoPedido(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoEstadoPedido=TipoEstadoPedidoConstantesFunciones.getTodosTiposColumnasTipoEstadoPedido();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoEstadoPedido) {
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
							field = TipoEstadoPedido.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoEstadoPedido.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoEstadoPedidoDataAccess.setFieldReflectionTipoEstadoPedido(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoEstadoPedido(Field field,String strPrefijo,String sColumn,TipoEstadoPedido entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoEstadoPedidoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoEstadoPedidoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoEstadoPedidoConstantesFunciones.IDPAIS:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoEstadoPedidoConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoEstadoPedido>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoEstadoPedido> entities = new  ArrayList<TipoEstadoPedido>();
		TipoEstadoPedido entity = new TipoEstadoPedido();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoEstadoPedidoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoEstadoPedidoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoEstadoPedidoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoEstadoPedido();
					entity=super.getEntity("",entity,resultSet,TipoEstadoPedidoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoEstadoPedido("",entity,resultSet);
					
					//entity.setTipoEstadoPedidoOriginal( new TipoEstadoPedido());
					//entity.setTipoEstadoPedidoOriginal(super.getEntity("",entity.getTipoEstadoPedidoOriginal(),resultSet,TipoEstadoPedidoDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoEstadoPedidoOriginal(this.getEntityTipoEstadoPedido("",entity.getTipoEstadoPedidoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoEstadoPedidos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoEstadoPedido(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoEstadoPedido>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoEstadoPedido> entities = new  ArrayList<TipoEstadoPedido>();
		TipoEstadoPedido entity = new TipoEstadoPedido();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoEstadoPedidoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoEstadoPedidoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoEstadoPedidoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoEstadoPedido> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoEstadoPedido> entities = new  ArrayList<TipoEstadoPedido>();
		TipoEstadoPedido entity = new TipoEstadoPedido();		  
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
	
	public  List<TipoEstadoPedido> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoEstadoPedido> entities = new  ArrayList<TipoEstadoPedido>();
		TipoEstadoPedido entity = new TipoEstadoPedido();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoEstadoPedido();
      	    	entity=super.getEntity("",entity,resultSet,TipoEstadoPedidoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoEstadoPedido("",entity,resultSet);
      	    	
				//entity.setTipoEstadoPedidoOriginal( new TipoEstadoPedido());
      	    	//entity.setTipoEstadoPedidoOriginal(super.getEntity("",entity.getTipoEstadoPedidoOriginal(),resultSet,TipoEstadoPedidoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoEstadoPedidoOriginal(this.getEntityTipoEstadoPedido("",entity.getTipoEstadoPedidoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoEstadoPedidos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoEstadoPedido(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	
	
	public TipoEstadoPedido getEntityTipoEstadoPedido(String strPrefijo,TipoEstadoPedido entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_pais(resultSet.getLong(strPrefijo+TipoEstadoPedidoConstantesFunciones.IDPAIS));
				entity.setnombre(resultSet.getString(strPrefijo+TipoEstadoPedidoConstantesFunciones.NOMBRE));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+TipoEstadoPedidoConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoEstadoPedido(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoEstadoPedido entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoEstadoPedidoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoEstadoPedidoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoEstadoPedidoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoEstadoPedidoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoEstadoPedidoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,TipoEstadoPedidoDataAccess.TABLENAME,TipoEstadoPedidoDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoEstadoPedidoDataAccess.setTipoEstadoPedidoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Pais getPais(Connexion connexion,TipoEstadoPedido reltipoestadopedido)throws SQLException,Exception {

		Pais pais= new Pais();

		try {
			PaisDataAccess paisDataAccess=new PaisDataAccess();

			paisDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			paisDataAccess.setConnexionType(this.connexionType);
			paisDataAccess.setParameterDbType(this.parameterDbType);

			pais=paisDataAccess.getEntity(connexion,reltipoestadopedido.getid_pais());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pais;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoEstadoPedido tipoestadopedido) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tipoestadopedido.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid=new ParameterValue<Long>();
					parameterMaintenanceValueid.setValue(tipoestadopedido.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_pais=new ParameterValue<Long>();
					parameterMaintenanceValueid_pais.setValue(tipoestadopedido.getid_pais());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_pais);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tipoestadopedido.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!tipoestadopedido.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tipoestadopedido.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tipoestadopedido.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tipoestadopedido.getId());
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
	
	public void setIsNewIsChangedFalseTipoEstadoPedido(TipoEstadoPedido tipoestadopedido)throws Exception  {		
		tipoestadopedido.setIsNew(false);
		tipoestadopedido.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoEstadoPedidos(List<TipoEstadoPedido> tipoestadopedidos)throws Exception  {				
		for(TipoEstadoPedido tipoestadopedido:tipoestadopedidos) {
			tipoestadopedido.setIsNew(false);
			tipoestadopedido.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoEstadoPedido(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
