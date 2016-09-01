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
package com.bydan.erp.puntoventa.business.dataaccess;

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

import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.puntoventa.util.*;//TarjetaCreditoConexionConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class TarjetaCreditoConexionDataAccess extends  TarjetaCreditoConexionDataAccessAdditional{ //TarjetaCreditoConexionDataAccessAdditional,DataAccessHelper<TarjetaCreditoConexion>
	//static Logger logger = Logger.getLogger(TarjetaCreditoConexionDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tarjeta_credito_conexion";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TarjetaCreditoConexionConstantesFunciones.SCHEMA+"."+TarjetaCreditoConexionConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_tarjeta_credito,id_conexion)values(current_timestamp,?,?,?,?)";
	public static String QUERYUPDATE="update "+TarjetaCreditoConexionConstantesFunciones.SCHEMA+"."+TarjetaCreditoConexionConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_tarjeta_credito=?,id_conexion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TarjetaCreditoConexionConstantesFunciones.SCHEMA+"."+TarjetaCreditoConexionConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tarjetacreditoconexion from "+TarjetaCreditoConexionConstantesFunciones.SPERSISTENCENAME+" tarjetacreditoconexion";
	public static String QUERYSELECTNATIVE="select "+TarjetaCreditoConexionConstantesFunciones.SCHEMA+"."+TarjetaCreditoConexionConstantesFunciones.TABLENAME+".id,"+TarjetaCreditoConexionConstantesFunciones.SCHEMA+"."+TarjetaCreditoConexionConstantesFunciones.TABLENAME+".version_row,"+TarjetaCreditoConexionConstantesFunciones.SCHEMA+"."+TarjetaCreditoConexionConstantesFunciones.TABLENAME+".id_empresa,"+TarjetaCreditoConexionConstantesFunciones.SCHEMA+"."+TarjetaCreditoConexionConstantesFunciones.TABLENAME+".id_sucursal,"+TarjetaCreditoConexionConstantesFunciones.SCHEMA+"."+TarjetaCreditoConexionConstantesFunciones.TABLENAME+".id_tarjeta_credito,"+TarjetaCreditoConexionConstantesFunciones.SCHEMA+"."+TarjetaCreditoConexionConstantesFunciones.TABLENAME+".id_conexion from "+TarjetaCreditoConexionConstantesFunciones.SCHEMA+"."+TarjetaCreditoConexionConstantesFunciones.TABLENAME;//+" as "+TarjetaCreditoConexionConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TarjetaCreditoConexionConstantesFunciones.SCHEMA+"."+TarjetaCreditoConexionConstantesFunciones.TABLENAME+".id,"+TarjetaCreditoConexionConstantesFunciones.SCHEMA+"."+TarjetaCreditoConexionConstantesFunciones.TABLENAME+".version_row from "+TarjetaCreditoConexionConstantesFunciones.SCHEMA+"."+TarjetaCreditoConexionConstantesFunciones.TABLENAME;//+" as "+TarjetaCreditoConexionConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TarjetaCreditoConexionConstantesFunciones.SCHEMA+"."+TarjetaCreditoConexionConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_tarjeta_credito=?,id_conexion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TARJETACREDITOCONEXION_INSERT(?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TARJETACREDITOCONEXION_UPDATE(?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TARJETACREDITOCONEXION_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TARJETACREDITOCONEXION_SELECT(?,?)";
	
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
	
	
	protected TarjetaCreditoConexionDataAccessAdditional tarjetacreditoconexionDataAccessAdditional=null;
	
	public TarjetaCreditoConexionDataAccessAdditional getTarjetaCreditoConexionDataAccessAdditional() {
		return this.tarjetacreditoconexionDataAccessAdditional;
	}
	
	public void setTarjetaCreditoConexionDataAccessAdditional(TarjetaCreditoConexionDataAccessAdditional tarjetacreditoconexionDataAccessAdditional) {
		try {
			this.tarjetacreditoconexionDataAccessAdditional=tarjetacreditoconexionDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TarjetaCreditoConexionDataAccess() {
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
		TarjetaCreditoConexionDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TarjetaCreditoConexionDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TarjetaCreditoConexionDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTarjetaCreditoConexionOriginal(TarjetaCreditoConexion tarjetacreditoconexion)throws Exception  {
		tarjetacreditoconexion.setTarjetaCreditoConexionOriginal((TarjetaCreditoConexion)tarjetacreditoconexion.clone());		
	}
	
	public void setTarjetaCreditoConexionsOriginal(List<TarjetaCreditoConexion> tarjetacreditoconexions)throws Exception  {
		
		for(TarjetaCreditoConexion tarjetacreditoconexion:tarjetacreditoconexions){
			tarjetacreditoconexion.setTarjetaCreditoConexionOriginal((TarjetaCreditoConexion)tarjetacreditoconexion.clone());
		}
	}
	
	public static void setTarjetaCreditoConexionOriginalStatic(TarjetaCreditoConexion tarjetacreditoconexion)throws Exception  {
		tarjetacreditoconexion.setTarjetaCreditoConexionOriginal((TarjetaCreditoConexion)tarjetacreditoconexion.clone());		
	}
	
	public static void setTarjetaCreditoConexionsOriginalStatic(List<TarjetaCreditoConexion> tarjetacreditoconexions)throws Exception  {
		
		for(TarjetaCreditoConexion tarjetacreditoconexion:tarjetacreditoconexions){
			tarjetacreditoconexion.setTarjetaCreditoConexionOriginal((TarjetaCreditoConexion)tarjetacreditoconexion.clone());
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
	
	public  TarjetaCreditoConexion getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TarjetaCreditoConexion entity = new TarjetaCreditoConexion();		
		
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
	
	public  TarjetaCreditoConexion getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TarjetaCreditoConexion entity = new TarjetaCreditoConexion();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TarjetaCreditoConexionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TarjetaCreditoConexionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//PuntoVenta.TarjetaCreditoConexion.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTarjetaCreditoConexionOriginal(new TarjetaCreditoConexion());
      	    	entity=super.getEntity("",entity,resultSet,TarjetaCreditoConexionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTarjetaCreditoConexion("",entity,resultSet); 
				
				//entity.setTarjetaCreditoConexionOriginal(super.getEntity("",entity.getTarjetaCreditoConexionOriginal(),resultSet,TarjetaCreditoConexionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTarjetaCreditoConexionOriginal(this.getEntityTarjetaCreditoConexion("",entity.getTarjetaCreditoConexionOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTarjetaCreditoConexion(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TarjetaCreditoConexion getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TarjetaCreditoConexion entity = new TarjetaCreditoConexion();
				
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
	
	public  TarjetaCreditoConexion getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TarjetaCreditoConexion entity = new TarjetaCreditoConexion();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TarjetaCreditoConexionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TarjetaCreditoConexionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TarjetaCreditoConexionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//PuntoVenta.TarjetaCreditoConexion.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTarjetaCreditoConexionOriginal(new TarjetaCreditoConexion());
      	    	entity=super.getEntity("",entity,resultSet,TarjetaCreditoConexionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTarjetaCreditoConexion("",entity,resultSet);    
				
				//entity.setTarjetaCreditoConexionOriginal(super.getEntity("",entity.getTarjetaCreditoConexionOriginal(),resultSet,TarjetaCreditoConexionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTarjetaCreditoConexionOriginal(this.getEntityTarjetaCreditoConexion("",entity.getTarjetaCreditoConexionOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTarjetaCreditoConexion(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TarjetaCreditoConexion
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TarjetaCreditoConexion entity = new TarjetaCreditoConexion();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TarjetaCreditoConexionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TarjetaCreditoConexionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TarjetaCreditoConexionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//PuntoVenta.TarjetaCreditoConexion.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTarjetaCreditoConexion(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TarjetaCreditoConexion> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TarjetaCreditoConexion> entities = new  ArrayList<TarjetaCreditoConexion>();
		TarjetaCreditoConexion entity = new TarjetaCreditoConexion();		  
		
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
	
	public  List<TarjetaCreditoConexion> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TarjetaCreditoConexion> entities = new  ArrayList<TarjetaCreditoConexion>();
		TarjetaCreditoConexion entity = new TarjetaCreditoConexion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TarjetaCreditoConexionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TarjetaCreditoConexionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TarjetaCreditoConexionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TarjetaCreditoConexion();
      	    	entity=super.getEntity("",entity,resultSet,TarjetaCreditoConexionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTarjetaCreditoConexion("",entity,resultSet);
      	    	
				//entity.setTarjetaCreditoConexionOriginal( new TarjetaCreditoConexion());
      	    	//entity.setTarjetaCreditoConexionOriginal(super.getEntity("",entity.getTarjetaCreditoConexionOriginal(),resultSet,TarjetaCreditoConexionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTarjetaCreditoConexionOriginal(this.getEntityTarjetaCreditoConexion("",entity.getTarjetaCreditoConexionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTarjetaCreditoConexions(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTarjetaCreditoConexion(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TarjetaCreditoConexion> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TarjetaCreditoConexion> entities = new  ArrayList<TarjetaCreditoConexion>();
		TarjetaCreditoConexion entity = new TarjetaCreditoConexion();		  
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
	
	public  List<TarjetaCreditoConexion> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TarjetaCreditoConexion> entities = new  ArrayList<TarjetaCreditoConexion>();
		TarjetaCreditoConexion entity = new TarjetaCreditoConexion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TarjetaCreditoConexion();
				
				if(conMapGenerico) {
					entity.inicializarMapTarjetaCreditoConexion();
					//entity.setMapTarjetaCreditoConexion(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTarjetaCreditoConexionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTarjetaCreditoConexion().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TarjetaCreditoConexionDataAccess.ISWITHSCHEMA);         		
					entity=TarjetaCreditoConexionDataAccess.getEntityTarjetaCreditoConexion("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTarjetaCreditoConexionOriginal( new TarjetaCreditoConexion());
					////entity.setTarjetaCreditoConexionOriginal(super.getEntity("",entity.getTarjetaCreditoConexionOriginal(),resultSet,TarjetaCreditoConexionDataAccess.ISWITHSCHEMA));         		
					////entity.setTarjetaCreditoConexionOriginal(this.getEntityTarjetaCreditoConexion("",entity.getTarjetaCreditoConexionOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTarjetaCreditoConexions(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTarjetaCreditoConexion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TarjetaCreditoConexion getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TarjetaCreditoConexion entity = new TarjetaCreditoConexion();		  
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
	
	public  TarjetaCreditoConexion getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TarjetaCreditoConexion entity = new TarjetaCreditoConexion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TarjetaCreditoConexion();
				
				if(conMapGenerico) {
					entity.inicializarMapTarjetaCreditoConexion();
					//entity.setMapTarjetaCreditoConexion(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTarjetaCreditoConexionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTarjetaCreditoConexion().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TarjetaCreditoConexionDataAccess.ISWITHSCHEMA);         		
					entity=TarjetaCreditoConexionDataAccess.getEntityTarjetaCreditoConexion("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTarjetaCreditoConexionOriginal( new TarjetaCreditoConexion());
					////entity.setTarjetaCreditoConexionOriginal(super.getEntity("",entity.getTarjetaCreditoConexionOriginal(),resultSet,TarjetaCreditoConexionDataAccess.ISWITHSCHEMA));         		
					////entity.setTarjetaCreditoConexionOriginal(this.getEntityTarjetaCreditoConexion("",entity.getTarjetaCreditoConexionOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTarjetaCreditoConexion(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTarjetaCreditoConexion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TarjetaCreditoConexion getEntityTarjetaCreditoConexion(String strPrefijo,TarjetaCreditoConexion entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TarjetaCreditoConexion.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TarjetaCreditoConexion.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TarjetaCreditoConexionDataAccess.setFieldReflectionTarjetaCreditoConexion(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTarjetaCreditoConexion=TarjetaCreditoConexionConstantesFunciones.getTodosTiposColumnasTarjetaCreditoConexion();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTarjetaCreditoConexion) {
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
							field = TarjetaCreditoConexion.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TarjetaCreditoConexion.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TarjetaCreditoConexionDataAccess.setFieldReflectionTarjetaCreditoConexion(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTarjetaCreditoConexion(Field field,String strPrefijo,String sColumn,TarjetaCreditoConexion entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TarjetaCreditoConexionConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TarjetaCreditoConexionConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TarjetaCreditoConexionConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TarjetaCreditoConexionConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TarjetaCreditoConexionConstantesFunciones.IDTARJETACREDITO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TarjetaCreditoConexionConstantesFunciones.IDCONEXION:
					field.set(entity,resultSet.getLong(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TarjetaCreditoConexion>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TarjetaCreditoConexion> entities = new  ArrayList<TarjetaCreditoConexion>();
		TarjetaCreditoConexion entity = new TarjetaCreditoConexion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TarjetaCreditoConexionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TarjetaCreditoConexionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TarjetaCreditoConexionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TarjetaCreditoConexion();
					entity=super.getEntity("",entity,resultSet,TarjetaCreditoConexionDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTarjetaCreditoConexion("",entity,resultSet);
					
					//entity.setTarjetaCreditoConexionOriginal( new TarjetaCreditoConexion());
					//entity.setTarjetaCreditoConexionOriginal(super.getEntity("",entity.getTarjetaCreditoConexionOriginal(),resultSet,TarjetaCreditoConexionDataAccess.ISWITHSCHEMA));         		
					//entity.setTarjetaCreditoConexionOriginal(this.getEntityTarjetaCreditoConexion("",entity.getTarjetaCreditoConexionOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTarjetaCreditoConexions(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTarjetaCreditoConexion(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TarjetaCreditoConexion>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TarjetaCreditoConexion> entities = new  ArrayList<TarjetaCreditoConexion>();
		TarjetaCreditoConexion entity = new TarjetaCreditoConexion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TarjetaCreditoConexionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TarjetaCreditoConexionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TarjetaCreditoConexionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TarjetaCreditoConexion> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TarjetaCreditoConexion> entities = new  ArrayList<TarjetaCreditoConexion>();
		TarjetaCreditoConexion entity = new TarjetaCreditoConexion();		  
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
	
	public  List<TarjetaCreditoConexion> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TarjetaCreditoConexion> entities = new  ArrayList<TarjetaCreditoConexion>();
		TarjetaCreditoConexion entity = new TarjetaCreditoConexion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TarjetaCreditoConexion();
      	    	entity=super.getEntity("",entity,resultSet,TarjetaCreditoConexionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTarjetaCreditoConexion("",entity,resultSet);
      	    	
				//entity.setTarjetaCreditoConexionOriginal( new TarjetaCreditoConexion());
      	    	//entity.setTarjetaCreditoConexionOriginal(super.getEntity("",entity.getTarjetaCreditoConexionOriginal(),resultSet,TarjetaCreditoConexionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTarjetaCreditoConexionOriginal(this.getEntityTarjetaCreditoConexion("",entity.getTarjetaCreditoConexionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTarjetaCreditoConexions(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTarjetaCreditoConexion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TarjetaCreditoConexion> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TarjetaCreditoConexion> entities = new  ArrayList<TarjetaCreditoConexion>();
		TarjetaCreditoConexion entity = new TarjetaCreditoConexion();		  
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
	
	public  List<TarjetaCreditoConexion> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TarjetaCreditoConexion> entities = new  ArrayList<TarjetaCreditoConexion>();
		TarjetaCreditoConexion entity = new TarjetaCreditoConexion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TarjetaCreditoConexion();
      	    	entity=super.getEntity("",entity,resultSet,TarjetaCreditoConexionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTarjetaCreditoConexion("",entity,resultSet);
      	    	
				//entity.setTarjetaCreditoConexionOriginal( new TarjetaCreditoConexion());
      	    	//entity.setTarjetaCreditoConexionOriginal(super.getEntity("",entity.getTarjetaCreditoConexionOriginal(),resultSet,TarjetaCreditoConexionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTarjetaCreditoConexionOriginal(this.getEntityTarjetaCreditoConexion("",entity.getTarjetaCreditoConexionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTarjetaCreditoConexions(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public TarjetaCreditoConexion getEntityTarjetaCreditoConexion(String strPrefijo,TarjetaCreditoConexion entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+TarjetaCreditoConexionConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+TarjetaCreditoConexionConstantesFunciones.IDSUCURSAL));
				entity.setid_tarjeta_credito(resultSet.getLong(strPrefijo+TarjetaCreditoConexionConstantesFunciones.IDTARJETACREDITO));
				entity.setid_conexion(resultSet.getLong(strPrefijo+TarjetaCreditoConexionConstantesFunciones.IDCONEXION));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTarjetaCreditoConexion(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TarjetaCreditoConexion entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TarjetaCreditoConexionDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TarjetaCreditoConexionDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TarjetaCreditoConexionDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TarjetaCreditoConexionDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TarjetaCreditoConexionConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,TarjetaCreditoConexionDataAccess.TABLENAME,TarjetaCreditoConexionDataAccess.ISWITHSTOREPROCEDURES);
			
			TarjetaCreditoConexionDataAccess.setTarjetaCreditoConexionOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,TarjetaCreditoConexion reltarjetacreditoconexion)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reltarjetacreditoconexion.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,TarjetaCreditoConexion reltarjetacreditoconexion)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,reltarjetacreditoconexion.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public TarjetaCredito getTarjetaCredito(Connexion connexion,TarjetaCreditoConexion reltarjetacreditoconexion)throws SQLException,Exception {

		TarjetaCredito tarjetacredito= new TarjetaCredito();

		try {
			TarjetaCreditoDataAccess tarjetacreditoDataAccess=new TarjetaCreditoDataAccess();

			tarjetacreditoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tarjetacreditoDataAccess.setConnexionType(this.connexionType);
			tarjetacreditoDataAccess.setParameterDbType(this.parameterDbType);

			tarjetacredito=tarjetacreditoDataAccess.getEntity(connexion,reltarjetacreditoconexion.getid_tarjeta_credito());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tarjetacredito;

	}

	public Conexion getConexion(Connexion connexion,TarjetaCreditoConexion reltarjetacreditoconexion)throws SQLException,Exception {

		Conexion conexion= new Conexion();

		try {
			ConexionDataAccess conexionDataAccess=new ConexionDataAccess();

			conexionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			conexionDataAccess.setConnexionType(this.connexionType);
			conexionDataAccess.setParameterDbType(this.parameterDbType);

			conexion=conexionDataAccess.getEntity(connexion,reltarjetacreditoconexion.getid_conexion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return conexion;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TarjetaCreditoConexion tarjetacreditoconexion) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tarjetacreditoconexion.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(tarjetacreditoconexion.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(tarjetacreditoconexion.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tarjeta_credito=new ParameterValue<Long>();
					parameterMaintenanceValueid_tarjeta_credito.setValue(tarjetacreditoconexion.getid_tarjeta_credito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tarjeta_credito);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_conexion=new ParameterValue<Long>();
					parameterMaintenanceValueid_conexion.setValue(tarjetacreditoconexion.getid_conexion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_conexion);
					parametersTemp.add(parameterMaintenance);
					
						if(!tarjetacreditoconexion.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tarjetacreditoconexion.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tarjetacreditoconexion.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tarjetacreditoconexion.getId());
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
	
	public void setIsNewIsChangedFalseTarjetaCreditoConexion(TarjetaCreditoConexion tarjetacreditoconexion)throws Exception  {		
		tarjetacreditoconexion.setIsNew(false);
		tarjetacreditoconexion.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTarjetaCreditoConexions(List<TarjetaCreditoConexion> tarjetacreditoconexions)throws Exception  {				
		for(TarjetaCreditoConexion tarjetacreditoconexion:tarjetacreditoconexions) {
			tarjetacreditoconexion.setIsNew(false);
			tarjetacreditoconexion.setIsChanged(false);
		}
	}
	
	public void generarExportarTarjetaCreditoConexion(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
