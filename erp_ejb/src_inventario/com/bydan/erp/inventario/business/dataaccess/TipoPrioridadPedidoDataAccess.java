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
import com.bydan.erp.inventario.util.*;//TipoPrioridadPedidoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class TipoPrioridadPedidoDataAccess extends  DataAccessHelper<TipoPrioridadPedido>{ //TipoPrioridadPedidoDataAccessAdditional,DataAccessHelper<TipoPrioridadPedido>
	//static Logger logger = Logger.getLogger(TipoPrioridadPedidoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_prioridad_pedido";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoPrioridadPedidoConstantesFunciones.SCHEMA+"."+TipoPrioridadPedidoConstantesFunciones.TABLENAME+"(version_row,id_pais,nombre)values(current_timestamp,?,?)";
	public static String QUERYUPDATE="update "+TipoPrioridadPedidoConstantesFunciones.SCHEMA+"."+TipoPrioridadPedidoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_pais=?,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoPrioridadPedidoConstantesFunciones.SCHEMA+"."+TipoPrioridadPedidoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tipoprioridadpedido from "+TipoPrioridadPedidoConstantesFunciones.SPERSISTENCENAME+" tipoprioridadpedido";
	public static String QUERYSELECTNATIVE="select "+TipoPrioridadPedidoConstantesFunciones.SCHEMA+"."+TipoPrioridadPedidoConstantesFunciones.TABLENAME+".id,"+TipoPrioridadPedidoConstantesFunciones.SCHEMA+"."+TipoPrioridadPedidoConstantesFunciones.TABLENAME+".version_row,"+TipoPrioridadPedidoConstantesFunciones.SCHEMA+"."+TipoPrioridadPedidoConstantesFunciones.TABLENAME+".id_pais,"+TipoPrioridadPedidoConstantesFunciones.SCHEMA+"."+TipoPrioridadPedidoConstantesFunciones.TABLENAME+".nombre from "+TipoPrioridadPedidoConstantesFunciones.SCHEMA+"."+TipoPrioridadPedidoConstantesFunciones.TABLENAME;//+" as "+TipoPrioridadPedidoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoPrioridadPedidoConstantesFunciones.SCHEMA+"."+TipoPrioridadPedidoConstantesFunciones.TABLENAME+".id,"+TipoPrioridadPedidoConstantesFunciones.SCHEMA+"."+TipoPrioridadPedidoConstantesFunciones.TABLENAME+".version_row,"+TipoPrioridadPedidoConstantesFunciones.SCHEMA+"."+TipoPrioridadPedidoConstantesFunciones.TABLENAME+".nombre from "+TipoPrioridadPedidoConstantesFunciones.SCHEMA+"."+TipoPrioridadPedidoConstantesFunciones.TABLENAME;//+" as "+TipoPrioridadPedidoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoPrioridadPedidoConstantesFunciones.SCHEMA+"."+TipoPrioridadPedidoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_pais=?,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPOPRIORIDADPEDIDO_INSERT(?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPOPRIORIDADPEDIDO_UPDATE(?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPOPRIORIDADPEDIDO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPOPRIORIDADPEDIDO_SELECT(?,?)";
	
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
	
	
	public TipoPrioridadPedidoDataAccess() {
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
		TipoPrioridadPedidoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoPrioridadPedidoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoPrioridadPedidoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoPrioridadPedidoOriginal(TipoPrioridadPedido tipoprioridadpedido)throws Exception  {
		tipoprioridadpedido.setTipoPrioridadPedidoOriginal((TipoPrioridadPedido)tipoprioridadpedido.clone());		
	}
	
	public void setTipoPrioridadPedidosOriginal(List<TipoPrioridadPedido> tipoprioridadpedidos)throws Exception  {
		
		for(TipoPrioridadPedido tipoprioridadpedido:tipoprioridadpedidos){
			tipoprioridadpedido.setTipoPrioridadPedidoOriginal((TipoPrioridadPedido)tipoprioridadpedido.clone());
		}
	}
	
	public static void setTipoPrioridadPedidoOriginalStatic(TipoPrioridadPedido tipoprioridadpedido)throws Exception  {
		tipoprioridadpedido.setTipoPrioridadPedidoOriginal((TipoPrioridadPedido)tipoprioridadpedido.clone());		
	}
	
	public static void setTipoPrioridadPedidosOriginalStatic(List<TipoPrioridadPedido> tipoprioridadpedidos)throws Exception  {
		
		for(TipoPrioridadPedido tipoprioridadpedido:tipoprioridadpedidos){
			tipoprioridadpedido.setTipoPrioridadPedidoOriginal((TipoPrioridadPedido)tipoprioridadpedido.clone());
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
	
	public  TipoPrioridadPedido getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoPrioridadPedido entity = new TipoPrioridadPedido();		
		
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
	
	public  TipoPrioridadPedido getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoPrioridadPedido entity = new TipoPrioridadPedido();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoPrioridadPedidoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoPrioridadPedidoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.TipoPrioridadPedido.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoPrioridadPedidoOriginal(new TipoPrioridadPedido());
      	    	entity=super.getEntity("",entity,resultSet,TipoPrioridadPedidoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoPrioridadPedido("",entity,resultSet); 
				
				//entity.setTipoPrioridadPedidoOriginal(super.getEntity("",entity.getTipoPrioridadPedidoOriginal(),resultSet,TipoPrioridadPedidoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoPrioridadPedidoOriginal(this.getEntityTipoPrioridadPedido("",entity.getTipoPrioridadPedidoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoPrioridadPedido(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoPrioridadPedido getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoPrioridadPedido entity = new TipoPrioridadPedido();
				
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
	
	public  TipoPrioridadPedido getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoPrioridadPedido entity = new TipoPrioridadPedido();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoPrioridadPedidoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoPrioridadPedidoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoPrioridadPedidoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.TipoPrioridadPedido.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoPrioridadPedidoOriginal(new TipoPrioridadPedido());
      	    	entity=super.getEntity("",entity,resultSet,TipoPrioridadPedidoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoPrioridadPedido("",entity,resultSet);    
				
				//entity.setTipoPrioridadPedidoOriginal(super.getEntity("",entity.getTipoPrioridadPedidoOriginal(),resultSet,TipoPrioridadPedidoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoPrioridadPedidoOriginal(this.getEntityTipoPrioridadPedido("",entity.getTipoPrioridadPedidoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoPrioridadPedido(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoPrioridadPedido
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoPrioridadPedido entity = new TipoPrioridadPedido();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoPrioridadPedidoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoPrioridadPedidoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoPrioridadPedidoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.TipoPrioridadPedido.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoPrioridadPedido(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoPrioridadPedido> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoPrioridadPedido> entities = new  ArrayList<TipoPrioridadPedido>();
		TipoPrioridadPedido entity = new TipoPrioridadPedido();		  
		
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
	
	public  List<TipoPrioridadPedido> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoPrioridadPedido> entities = new  ArrayList<TipoPrioridadPedido>();
		TipoPrioridadPedido entity = new TipoPrioridadPedido();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoPrioridadPedidoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoPrioridadPedidoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoPrioridadPedidoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoPrioridadPedido();
      	    	entity=super.getEntity("",entity,resultSet,TipoPrioridadPedidoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoPrioridadPedido("",entity,resultSet);
      	    	
				//entity.setTipoPrioridadPedidoOriginal( new TipoPrioridadPedido());
      	    	//entity.setTipoPrioridadPedidoOriginal(super.getEntity("",entity.getTipoPrioridadPedidoOriginal(),resultSet,TipoPrioridadPedidoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoPrioridadPedidoOriginal(this.getEntityTipoPrioridadPedido("",entity.getTipoPrioridadPedidoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoPrioridadPedidos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoPrioridadPedido(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoPrioridadPedido> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoPrioridadPedido> entities = new  ArrayList<TipoPrioridadPedido>();
		TipoPrioridadPedido entity = new TipoPrioridadPedido();		  
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
	
	public  List<TipoPrioridadPedido> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoPrioridadPedido> entities = new  ArrayList<TipoPrioridadPedido>();
		TipoPrioridadPedido entity = new TipoPrioridadPedido();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoPrioridadPedido();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoPrioridadPedido();
					//entity.setMapTipoPrioridadPedido(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoPrioridadPedidoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoPrioridadPedido().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoPrioridadPedidoDataAccess.ISWITHSCHEMA);         		
					entity=TipoPrioridadPedidoDataAccess.getEntityTipoPrioridadPedido("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoPrioridadPedidoOriginal( new TipoPrioridadPedido());
					////entity.setTipoPrioridadPedidoOriginal(super.getEntity("",entity.getTipoPrioridadPedidoOriginal(),resultSet,TipoPrioridadPedidoDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoPrioridadPedidoOriginal(this.getEntityTipoPrioridadPedido("",entity.getTipoPrioridadPedidoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoPrioridadPedidos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoPrioridadPedido(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoPrioridadPedido getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoPrioridadPedido entity = new TipoPrioridadPedido();		  
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
	
	public  TipoPrioridadPedido getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoPrioridadPedido entity = new TipoPrioridadPedido();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoPrioridadPedido();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoPrioridadPedido();
					//entity.setMapTipoPrioridadPedido(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoPrioridadPedidoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoPrioridadPedido().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoPrioridadPedidoDataAccess.ISWITHSCHEMA);         		
					entity=TipoPrioridadPedidoDataAccess.getEntityTipoPrioridadPedido("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoPrioridadPedidoOriginal( new TipoPrioridadPedido());
					////entity.setTipoPrioridadPedidoOriginal(super.getEntity("",entity.getTipoPrioridadPedidoOriginal(),resultSet,TipoPrioridadPedidoDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoPrioridadPedidoOriginal(this.getEntityTipoPrioridadPedido("",entity.getTipoPrioridadPedidoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoPrioridadPedido(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoPrioridadPedido(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoPrioridadPedido getEntityTipoPrioridadPedido(String strPrefijo,TipoPrioridadPedido entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoPrioridadPedido.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoPrioridadPedido.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoPrioridadPedidoDataAccess.setFieldReflectionTipoPrioridadPedido(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoPrioridadPedido=TipoPrioridadPedidoConstantesFunciones.getTodosTiposColumnasTipoPrioridadPedido();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoPrioridadPedido) {
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
							field = TipoPrioridadPedido.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoPrioridadPedido.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoPrioridadPedidoDataAccess.setFieldReflectionTipoPrioridadPedido(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoPrioridadPedido(Field field,String strPrefijo,String sColumn,TipoPrioridadPedido entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoPrioridadPedidoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoPrioridadPedidoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoPrioridadPedidoConstantesFunciones.IDPAIS:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoPrioridadPedidoConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoPrioridadPedido>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoPrioridadPedido> entities = new  ArrayList<TipoPrioridadPedido>();
		TipoPrioridadPedido entity = new TipoPrioridadPedido();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoPrioridadPedidoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoPrioridadPedidoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoPrioridadPedidoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoPrioridadPedido();
					entity=super.getEntity("",entity,resultSet,TipoPrioridadPedidoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoPrioridadPedido("",entity,resultSet);
					
					//entity.setTipoPrioridadPedidoOriginal( new TipoPrioridadPedido());
					//entity.setTipoPrioridadPedidoOriginal(super.getEntity("",entity.getTipoPrioridadPedidoOriginal(),resultSet,TipoPrioridadPedidoDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoPrioridadPedidoOriginal(this.getEntityTipoPrioridadPedido("",entity.getTipoPrioridadPedidoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoPrioridadPedidos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoPrioridadPedido(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoPrioridadPedido>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoPrioridadPedido> entities = new  ArrayList<TipoPrioridadPedido>();
		TipoPrioridadPedido entity = new TipoPrioridadPedido();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoPrioridadPedidoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoPrioridadPedidoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoPrioridadPedidoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoPrioridadPedido> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoPrioridadPedido> entities = new  ArrayList<TipoPrioridadPedido>();
		TipoPrioridadPedido entity = new TipoPrioridadPedido();		  
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
	
	public  List<TipoPrioridadPedido> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoPrioridadPedido> entities = new  ArrayList<TipoPrioridadPedido>();
		TipoPrioridadPedido entity = new TipoPrioridadPedido();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoPrioridadPedido();
      	    	entity=super.getEntity("",entity,resultSet,TipoPrioridadPedidoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoPrioridadPedido("",entity,resultSet);
      	    	
				//entity.setTipoPrioridadPedidoOriginal( new TipoPrioridadPedido());
      	    	//entity.setTipoPrioridadPedidoOriginal(super.getEntity("",entity.getTipoPrioridadPedidoOriginal(),resultSet,TipoPrioridadPedidoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoPrioridadPedidoOriginal(this.getEntityTipoPrioridadPedido("",entity.getTipoPrioridadPedidoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoPrioridadPedidos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoPrioridadPedido(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	
	
	public TipoPrioridadPedido getEntityTipoPrioridadPedido(String strPrefijo,TipoPrioridadPedido entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_pais(resultSet.getLong(strPrefijo+TipoPrioridadPedidoConstantesFunciones.IDPAIS));
				entity.setnombre(resultSet.getString(strPrefijo+TipoPrioridadPedidoConstantesFunciones.NOMBRE));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+TipoPrioridadPedidoConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoPrioridadPedido(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoPrioridadPedido entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoPrioridadPedidoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoPrioridadPedidoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoPrioridadPedidoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoPrioridadPedidoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoPrioridadPedidoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,TipoPrioridadPedidoDataAccess.TABLENAME,TipoPrioridadPedidoDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoPrioridadPedidoDataAccess.setTipoPrioridadPedidoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Pais getPais(Connexion connexion,TipoPrioridadPedido reltipoprioridadpedido)throws SQLException,Exception {

		Pais pais= new Pais();

		try {
			PaisDataAccess paisDataAccess=new PaisDataAccess();

			paisDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			paisDataAccess.setConnexionType(this.connexionType);
			paisDataAccess.setParameterDbType(this.parameterDbType);

			pais=paisDataAccess.getEntity(connexion,reltipoprioridadpedido.getid_pais());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pais;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoPrioridadPedido tipoprioridadpedido) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tipoprioridadpedido.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_pais=new ParameterValue<Long>();
					parameterMaintenanceValueid_pais.setValue(tipoprioridadpedido.getid_pais());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_pais);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tipoprioridadpedido.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!tipoprioridadpedido.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tipoprioridadpedido.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tipoprioridadpedido.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tipoprioridadpedido.getId());
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
	
	public void setIsNewIsChangedFalseTipoPrioridadPedido(TipoPrioridadPedido tipoprioridadpedido)throws Exception  {		
		tipoprioridadpedido.setIsNew(false);
		tipoprioridadpedido.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoPrioridadPedidos(List<TipoPrioridadPedido> tipoprioridadpedidos)throws Exception  {				
		for(TipoPrioridadPedido tipoprioridadpedido:tipoprioridadpedidos) {
			tipoprioridadpedido.setIsNew(false);
			tipoprioridadpedido.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoPrioridadPedido(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
