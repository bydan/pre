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
import com.bydan.erp.inventario.util.*;//PrioridadPedidoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class PrioridadPedidoDataAccess extends  PrioridadPedidoDataAccessAdditional{ //PrioridadPedidoDataAccessAdditional,DataAccessHelper<PrioridadPedido>
	//static Logger logger = Logger.getLogger(PrioridadPedidoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="prioridad_pedido";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+PrioridadPedidoConstantesFunciones.SCHEMA+"."+PrioridadPedidoConstantesFunciones.TABLENAME+"(version_row,id_empresa,nombre,dia)values(current_timestamp,?,?,?)";
	public static String QUERYUPDATE="update "+PrioridadPedidoConstantesFunciones.SCHEMA+"."+PrioridadPedidoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,nombre=?,dia=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+PrioridadPedidoConstantesFunciones.SCHEMA+"."+PrioridadPedidoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select prioridadpedido from "+PrioridadPedidoConstantesFunciones.SPERSISTENCENAME+" prioridadpedido";
	public static String QUERYSELECTNATIVE="select "+PrioridadPedidoConstantesFunciones.SCHEMA+"."+PrioridadPedidoConstantesFunciones.TABLENAME+".id,"+PrioridadPedidoConstantesFunciones.SCHEMA+"."+PrioridadPedidoConstantesFunciones.TABLENAME+".version_row,"+PrioridadPedidoConstantesFunciones.SCHEMA+"."+PrioridadPedidoConstantesFunciones.TABLENAME+".id_empresa,"+PrioridadPedidoConstantesFunciones.SCHEMA+"."+PrioridadPedidoConstantesFunciones.TABLENAME+".nombre,"+PrioridadPedidoConstantesFunciones.SCHEMA+"."+PrioridadPedidoConstantesFunciones.TABLENAME+".dia from "+PrioridadPedidoConstantesFunciones.SCHEMA+"."+PrioridadPedidoConstantesFunciones.TABLENAME;//+" as "+PrioridadPedidoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+PrioridadPedidoConstantesFunciones.SCHEMA+"."+PrioridadPedidoConstantesFunciones.TABLENAME+".id,"+PrioridadPedidoConstantesFunciones.SCHEMA+"."+PrioridadPedidoConstantesFunciones.TABLENAME+".version_row,"+PrioridadPedidoConstantesFunciones.SCHEMA+"."+PrioridadPedidoConstantesFunciones.TABLENAME+".nombre from "+PrioridadPedidoConstantesFunciones.SCHEMA+"."+PrioridadPedidoConstantesFunciones.TABLENAME;//+" as "+PrioridadPedidoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+PrioridadPedidoConstantesFunciones.SCHEMA+"."+PrioridadPedidoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,nombre=?,dia=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PRIORIDADPEDIDO_INSERT(?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PRIORIDADPEDIDO_UPDATE(?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PRIORIDADPEDIDO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PRIORIDADPEDIDO_SELECT(?,?)";
	
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
	
	
	protected PrioridadPedidoDataAccessAdditional prioridadpedidoDataAccessAdditional=null;
	
	public PrioridadPedidoDataAccessAdditional getPrioridadPedidoDataAccessAdditional() {
		return this.prioridadpedidoDataAccessAdditional;
	}
	
	public void setPrioridadPedidoDataAccessAdditional(PrioridadPedidoDataAccessAdditional prioridadpedidoDataAccessAdditional) {
		try {
			this.prioridadpedidoDataAccessAdditional=prioridadpedidoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public PrioridadPedidoDataAccess() {
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
		PrioridadPedidoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		PrioridadPedidoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		PrioridadPedidoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setPrioridadPedidoOriginal(PrioridadPedido prioridadpedido)throws Exception  {
		prioridadpedido.setPrioridadPedidoOriginal((PrioridadPedido)prioridadpedido.clone());		
	}
	
	public void setPrioridadPedidosOriginal(List<PrioridadPedido> prioridadpedidos)throws Exception  {
		
		for(PrioridadPedido prioridadpedido:prioridadpedidos){
			prioridadpedido.setPrioridadPedidoOriginal((PrioridadPedido)prioridadpedido.clone());
		}
	}
	
	public static void setPrioridadPedidoOriginalStatic(PrioridadPedido prioridadpedido)throws Exception  {
		prioridadpedido.setPrioridadPedidoOriginal((PrioridadPedido)prioridadpedido.clone());		
	}
	
	public static void setPrioridadPedidosOriginalStatic(List<PrioridadPedido> prioridadpedidos)throws Exception  {
		
		for(PrioridadPedido prioridadpedido:prioridadpedidos){
			prioridadpedido.setPrioridadPedidoOriginal((PrioridadPedido)prioridadpedido.clone());
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
	
	public  PrioridadPedido getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		PrioridadPedido entity = new PrioridadPedido();		
		
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
	
	public  PrioridadPedido getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		PrioridadPedido entity = new PrioridadPedido();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PrioridadPedidoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PrioridadPedidoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.PrioridadPedido.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setPrioridadPedidoOriginal(new PrioridadPedido());
      	    	entity=super.getEntity("",entity,resultSet,PrioridadPedidoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPrioridadPedido("",entity,resultSet); 
				
				//entity.setPrioridadPedidoOriginal(super.getEntity("",entity.getPrioridadPedidoOriginal(),resultSet,PrioridadPedidoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPrioridadPedidoOriginal(this.getEntityPrioridadPedido("",entity.getPrioridadPedidoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalsePrioridadPedido(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  PrioridadPedido getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		PrioridadPedido entity = new PrioridadPedido();
				
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
	
	public  PrioridadPedido getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		PrioridadPedido entity = new PrioridadPedido();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PrioridadPedidoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PrioridadPedidoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PrioridadPedidoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.PrioridadPedido.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setPrioridadPedidoOriginal(new PrioridadPedido());
      	    	entity=super.getEntity("",entity,resultSet,PrioridadPedidoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPrioridadPedido("",entity,resultSet);    
				
				//entity.setPrioridadPedidoOriginal(super.getEntity("",entity.getPrioridadPedidoOriginal(),resultSet,PrioridadPedidoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPrioridadPedidoOriginal(this.getEntityPrioridadPedido("",entity.getPrioridadPedidoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalsePrioridadPedido(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //PrioridadPedido
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		PrioridadPedido entity = new PrioridadPedido();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PrioridadPedidoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PrioridadPedidoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PrioridadPedidoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.PrioridadPedido.isActive=1
        	 
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
				//this.setIsNewIsChangedFalsePrioridadPedido(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<PrioridadPedido> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<PrioridadPedido> entities = new  ArrayList<PrioridadPedido>();
		PrioridadPedido entity = new PrioridadPedido();		  
		
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
	
	public  List<PrioridadPedido> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<PrioridadPedido> entities = new  ArrayList<PrioridadPedido>();
		PrioridadPedido entity = new PrioridadPedido();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=PrioridadPedidoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PrioridadPedidoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PrioridadPedidoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PrioridadPedido();
      	    	entity=super.getEntity("",entity,resultSet,PrioridadPedidoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPrioridadPedido("",entity,resultSet);
      	    	
				//entity.setPrioridadPedidoOriginal( new PrioridadPedido());
      	    	//entity.setPrioridadPedidoOriginal(super.getEntity("",entity.getPrioridadPedidoOriginal(),resultSet,PrioridadPedidoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPrioridadPedidoOriginal(this.getEntityPrioridadPedido("",entity.getPrioridadPedidoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePrioridadPedidos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPrioridadPedido(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<PrioridadPedido> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<PrioridadPedido> entities = new  ArrayList<PrioridadPedido>();
		PrioridadPedido entity = new PrioridadPedido();		  
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
	
	public  List<PrioridadPedido> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<PrioridadPedido> entities = new  ArrayList<PrioridadPedido>();
		PrioridadPedido entity = new PrioridadPedido();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PrioridadPedido();
				
				if(conMapGenerico) {
					entity.inicializarMapPrioridadPedido();
					//entity.setMapPrioridadPedido(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapPrioridadPedidoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPrioridadPedido().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PrioridadPedidoDataAccess.ISWITHSCHEMA);         		
					entity=PrioridadPedidoDataAccess.getEntityPrioridadPedido("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setPrioridadPedidoOriginal( new PrioridadPedido());
					////entity.setPrioridadPedidoOriginal(super.getEntity("",entity.getPrioridadPedidoOriginal(),resultSet,PrioridadPedidoDataAccess.ISWITHSCHEMA));         		
					////entity.setPrioridadPedidoOriginal(this.getEntityPrioridadPedido("",entity.getPrioridadPedidoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePrioridadPedidos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPrioridadPedido(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public PrioridadPedido getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		PrioridadPedido entity = new PrioridadPedido();		  
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
	
	public  PrioridadPedido getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		PrioridadPedido entity = new PrioridadPedido();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PrioridadPedido();
				
				if(conMapGenerico) {
					entity.inicializarMapPrioridadPedido();
					//entity.setMapPrioridadPedido(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapPrioridadPedidoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPrioridadPedido().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PrioridadPedidoDataAccess.ISWITHSCHEMA);         		
					entity=PrioridadPedidoDataAccess.getEntityPrioridadPedido("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setPrioridadPedidoOriginal( new PrioridadPedido());
					////entity.setPrioridadPedidoOriginal(super.getEntity("",entity.getPrioridadPedidoOriginal(),resultSet,PrioridadPedidoDataAccess.ISWITHSCHEMA));         		
					////entity.setPrioridadPedidoOriginal(this.getEntityPrioridadPedido("",entity.getPrioridadPedidoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalsePrioridadPedido(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPrioridadPedido(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static PrioridadPedido getEntityPrioridadPedido(String strPrefijo,PrioridadPedido entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = PrioridadPedido.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = PrioridadPedido.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					PrioridadPedidoDataAccess.setFieldReflectionPrioridadPedido(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasPrioridadPedido=PrioridadPedidoConstantesFunciones.getTodosTiposColumnasPrioridadPedido();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasPrioridadPedido) {
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
							field = PrioridadPedido.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = PrioridadPedido.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						PrioridadPedidoDataAccess.setFieldReflectionPrioridadPedido(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionPrioridadPedido(Field field,String strPrefijo,String sColumn,PrioridadPedido entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case PrioridadPedidoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PrioridadPedidoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PrioridadPedidoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PrioridadPedidoConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PrioridadPedidoConstantesFunciones.DIA:
					field.set(entity,resultSet.getInt(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<PrioridadPedido>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<PrioridadPedido> entities = new  ArrayList<PrioridadPedido>();
		PrioridadPedido entity = new PrioridadPedido();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PrioridadPedidoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PrioridadPedidoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PrioridadPedidoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new PrioridadPedido();
					entity=super.getEntity("",entity,resultSet,PrioridadPedidoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityPrioridadPedido("",entity,resultSet);
					
					//entity.setPrioridadPedidoOriginal( new PrioridadPedido());
					//entity.setPrioridadPedidoOriginal(super.getEntity("",entity.getPrioridadPedidoOriginal(),resultSet,PrioridadPedidoDataAccess.ISWITHSCHEMA));         		
					//entity.setPrioridadPedidoOriginal(this.getEntityPrioridadPedido("",entity.getPrioridadPedidoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalsePrioridadPedidos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPrioridadPedido(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<PrioridadPedido>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<PrioridadPedido> entities = new  ArrayList<PrioridadPedido>();
		PrioridadPedido entity = new PrioridadPedido();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PrioridadPedidoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PrioridadPedidoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PrioridadPedidoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<PrioridadPedido> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PrioridadPedido> entities = new  ArrayList<PrioridadPedido>();
		PrioridadPedido entity = new PrioridadPedido();		  
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
	
	public  List<PrioridadPedido> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PrioridadPedido> entities = new  ArrayList<PrioridadPedido>();
		PrioridadPedido entity = new PrioridadPedido();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PrioridadPedido();
      	    	entity=super.getEntity("",entity,resultSet,PrioridadPedidoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPrioridadPedido("",entity,resultSet);
      	    	
				//entity.setPrioridadPedidoOriginal( new PrioridadPedido());
      	    	//entity.setPrioridadPedidoOriginal(super.getEntity("",entity.getPrioridadPedidoOriginal(),resultSet,PrioridadPedidoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPrioridadPedidoOriginal(this.getEntityPrioridadPedido("",entity.getPrioridadPedidoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalsePrioridadPedidos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPrioridadPedido(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<PrioridadPedido> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PrioridadPedido> entities = new  ArrayList<PrioridadPedido>();
		PrioridadPedido entity = new PrioridadPedido();		  
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
	
	public  List<PrioridadPedido> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PrioridadPedido> entities = new  ArrayList<PrioridadPedido>();
		PrioridadPedido entity = new PrioridadPedido();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PrioridadPedido();
      	    	entity=super.getEntity("",entity,resultSet,PrioridadPedidoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPrioridadPedido("",entity,resultSet);
      	    	
				//entity.setPrioridadPedidoOriginal( new PrioridadPedido());
      	    	//entity.setPrioridadPedidoOriginal(super.getEntity("",entity.getPrioridadPedidoOriginal(),resultSet,PrioridadPedidoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPrioridadPedidoOriginal(this.getEntityPrioridadPedido("",entity.getPrioridadPedidoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePrioridadPedidos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public PrioridadPedido getEntityPrioridadPedido(String strPrefijo,PrioridadPedido entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+PrioridadPedidoConstantesFunciones.IDEMPRESA));
				entity.setnombre(resultSet.getString(strPrefijo+PrioridadPedidoConstantesFunciones.NOMBRE));
				entity.setdia(resultSet.getInt(strPrefijo+PrioridadPedidoConstantesFunciones.DIA));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+PrioridadPedidoConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowPrioridadPedido(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(PrioridadPedido entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=PrioridadPedidoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=PrioridadPedidoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=PrioridadPedidoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=PrioridadPedidoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(PrioridadPedidoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,PrioridadPedidoDataAccess.TABLENAME,PrioridadPedidoDataAccess.ISWITHSTOREPROCEDURES);
			
			PrioridadPedidoDataAccess.setPrioridadPedidoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,PrioridadPedido relprioridadpedido)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relprioridadpedido.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}


		
		public List<ParametroCompra> getParametroCompras(Connexion connexion,PrioridadPedido prioridadpedido)throws SQLException,Exception {

		List<ParametroCompra> parametrocompras= new ArrayList<ParametroCompra>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+PrioridadPedidoConstantesFunciones.SCHEMA+".prioridad_pedido ON "+ParametroCompraConstantesFunciones.SCHEMA+".parametro_compra.id_prioridad_pedido="+PrioridadPedidoConstantesFunciones.SCHEMA+".prioridad_pedido.id WHERE "+PrioridadPedidoConstantesFunciones.SCHEMA+".prioridad_pedido.id="+String.valueOf(prioridadpedido.getId());
			} else {
				sQuery=" INNER JOIN parametrocompra.PrioridadPedido WHERE parametrocompra.PrioridadPedido.id="+String.valueOf(prioridadpedido.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ParametroCompraDataAccess parametrocompraDataAccess=new ParametroCompraDataAccess();

			parametrocompraDataAccess.setConnexionType(this.connexionType);
			parametrocompraDataAccess.setParameterDbType(this.parameterDbType);
			parametrocompras=parametrocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return parametrocompras;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,PrioridadPedido prioridadpedido) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!prioridadpedido.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(prioridadpedido.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(prioridadpedido.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuedia=new ParameterValue<Integer>();
					parameterMaintenanceValuedia.setValue(prioridadpedido.getdia());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedia);
					parametersTemp.add(parameterMaintenance);
					
						if(!prioridadpedido.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(prioridadpedido.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(prioridadpedido.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(prioridadpedido.getId());
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
	
	public void setIsNewIsChangedFalsePrioridadPedido(PrioridadPedido prioridadpedido)throws Exception  {		
		prioridadpedido.setIsNew(false);
		prioridadpedido.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalsePrioridadPedidos(List<PrioridadPedido> prioridadpedidos)throws Exception  {				
		for(PrioridadPedido prioridadpedido:prioridadpedidos) {
			prioridadpedido.setIsNew(false);
			prioridadpedido.setIsChanged(false);
		}
	}
	
	public void generarExportarPrioridadPedido(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
