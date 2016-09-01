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
import com.bydan.erp.puntoventa.util.*;//ReciboPuntoVentaConstantesFunciones;


import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;


import com.bydan.erp.cartera.util.*;
import com.bydan.erp.tesoreria.util.*;




@SuppressWarnings("unused")
final public class ReciboPuntoVentaDataAccess extends  ReciboPuntoVentaDataAccessAdditional{ //ReciboPuntoVentaDataAccessAdditional,DataAccessHelper<ReciboPuntoVenta>
	//static Logger logger = Logger.getLogger(ReciboPuntoVentaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="recibo_punto_venta";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ReciboPuntoVentaConstantesFunciones.SCHEMA+"."+ReciboPuntoVentaConstantesFunciones.TABLENAME+"(version_row,id_cliente,id_banco,valor_efectivo,valor_cheque,numero_cheque,fecha)values(current_timestamp,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+ReciboPuntoVentaConstantesFunciones.SCHEMA+"."+ReciboPuntoVentaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_cliente=?,id_banco=?,valor_efectivo=?,valor_cheque=?,numero_cheque=?,fecha=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ReciboPuntoVentaConstantesFunciones.SCHEMA+"."+ReciboPuntoVentaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select recibopuntoventa from "+ReciboPuntoVentaConstantesFunciones.SPERSISTENCENAME+" recibopuntoventa";
	public static String QUERYSELECTNATIVE="select "+ReciboPuntoVentaConstantesFunciones.SCHEMA+"."+ReciboPuntoVentaConstantesFunciones.TABLENAME+".id,"+ReciboPuntoVentaConstantesFunciones.SCHEMA+"."+ReciboPuntoVentaConstantesFunciones.TABLENAME+".version_row,"+ReciboPuntoVentaConstantesFunciones.SCHEMA+"."+ReciboPuntoVentaConstantesFunciones.TABLENAME+".id_cliente,"+ReciboPuntoVentaConstantesFunciones.SCHEMA+"."+ReciboPuntoVentaConstantesFunciones.TABLENAME+".id_banco,"+ReciboPuntoVentaConstantesFunciones.SCHEMA+"."+ReciboPuntoVentaConstantesFunciones.TABLENAME+".valor_efectivo,"+ReciboPuntoVentaConstantesFunciones.SCHEMA+"."+ReciboPuntoVentaConstantesFunciones.TABLENAME+".valor_cheque,"+ReciboPuntoVentaConstantesFunciones.SCHEMA+"."+ReciboPuntoVentaConstantesFunciones.TABLENAME+".numero_cheque,"+ReciboPuntoVentaConstantesFunciones.SCHEMA+"."+ReciboPuntoVentaConstantesFunciones.TABLENAME+".fecha from "+ReciboPuntoVentaConstantesFunciones.SCHEMA+"."+ReciboPuntoVentaConstantesFunciones.TABLENAME;//+" as "+ReciboPuntoVentaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ReciboPuntoVentaConstantesFunciones.SCHEMA+"."+ReciboPuntoVentaConstantesFunciones.TABLENAME+".id,"+ReciboPuntoVentaConstantesFunciones.SCHEMA+"."+ReciboPuntoVentaConstantesFunciones.TABLENAME+".version_row from "+ReciboPuntoVentaConstantesFunciones.SCHEMA+"."+ReciboPuntoVentaConstantesFunciones.TABLENAME;//+" as "+ReciboPuntoVentaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ReciboPuntoVentaConstantesFunciones.SCHEMA+"."+ReciboPuntoVentaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_cliente=?,id_banco=?,valor_efectivo=?,valor_cheque=?,numero_cheque=?,fecha=?";
	
	public static String STOREPROCEDUREINSERT="call SP_RECIBOPUNTOVENTA_INSERT(?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_RECIBOPUNTOVENTA_UPDATE(?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_RECIBOPUNTOVENTA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_RECIBOPUNTOVENTA_SELECT(?,?)";
	
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
	
	
	protected ReciboPuntoVentaDataAccessAdditional recibopuntoventaDataAccessAdditional=null;
	
	public ReciboPuntoVentaDataAccessAdditional getReciboPuntoVentaDataAccessAdditional() {
		return this.recibopuntoventaDataAccessAdditional;
	}
	
	public void setReciboPuntoVentaDataAccessAdditional(ReciboPuntoVentaDataAccessAdditional recibopuntoventaDataAccessAdditional) {
		try {
			this.recibopuntoventaDataAccessAdditional=recibopuntoventaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ReciboPuntoVentaDataAccess() {
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
		ReciboPuntoVentaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ReciboPuntoVentaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ReciboPuntoVentaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setReciboPuntoVentaOriginal(ReciboPuntoVenta recibopuntoventa)throws Exception  {
		recibopuntoventa.setReciboPuntoVentaOriginal((ReciboPuntoVenta)recibopuntoventa.clone());		
	}
	
	public void setReciboPuntoVentasOriginal(List<ReciboPuntoVenta> recibopuntoventas)throws Exception  {
		
		for(ReciboPuntoVenta recibopuntoventa:recibopuntoventas){
			recibopuntoventa.setReciboPuntoVentaOriginal((ReciboPuntoVenta)recibopuntoventa.clone());
		}
	}
	
	public static void setReciboPuntoVentaOriginalStatic(ReciboPuntoVenta recibopuntoventa)throws Exception  {
		recibopuntoventa.setReciboPuntoVentaOriginal((ReciboPuntoVenta)recibopuntoventa.clone());		
	}
	
	public static void setReciboPuntoVentasOriginalStatic(List<ReciboPuntoVenta> recibopuntoventas)throws Exception  {
		
		for(ReciboPuntoVenta recibopuntoventa:recibopuntoventas){
			recibopuntoventa.setReciboPuntoVentaOriginal((ReciboPuntoVenta)recibopuntoventa.clone());
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
	
	public  ReciboPuntoVenta getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		ReciboPuntoVenta entity = new ReciboPuntoVenta();		
		
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
	
	public  ReciboPuntoVenta getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		ReciboPuntoVenta entity = new ReciboPuntoVenta();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ReciboPuntoVentaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ReciboPuntoVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//PuntoVenta.ReciboPuntoVenta.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setReciboPuntoVentaOriginal(new ReciboPuntoVenta());
      	    	entity=super.getEntity("",entity,resultSet,ReciboPuntoVentaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityReciboPuntoVenta("",entity,resultSet); 
				
				//entity.setReciboPuntoVentaOriginal(super.getEntity("",entity.getReciboPuntoVentaOriginal(),resultSet,ReciboPuntoVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setReciboPuntoVentaOriginal(this.getEntityReciboPuntoVenta("",entity.getReciboPuntoVentaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseReciboPuntoVenta(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  ReciboPuntoVenta getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ReciboPuntoVenta entity = new ReciboPuntoVenta();
				
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
	
	public  ReciboPuntoVenta getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ReciboPuntoVenta entity = new ReciboPuntoVenta();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ReciboPuntoVentaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ReciboPuntoVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ReciboPuntoVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//PuntoVenta.ReciboPuntoVenta.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setReciboPuntoVentaOriginal(new ReciboPuntoVenta());
      	    	entity=super.getEntity("",entity,resultSet,ReciboPuntoVentaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityReciboPuntoVenta("",entity,resultSet);    
				
				//entity.setReciboPuntoVentaOriginal(super.getEntity("",entity.getReciboPuntoVentaOriginal(),resultSet,ReciboPuntoVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setReciboPuntoVentaOriginal(this.getEntityReciboPuntoVenta("",entity.getReciboPuntoVentaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseReciboPuntoVenta(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //ReciboPuntoVenta
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		ReciboPuntoVenta entity = new ReciboPuntoVenta();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ReciboPuntoVentaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ReciboPuntoVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ReciboPuntoVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//PuntoVenta.ReciboPuntoVenta.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseReciboPuntoVenta(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<ReciboPuntoVenta> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ReciboPuntoVenta> entities = new  ArrayList<ReciboPuntoVenta>();
		ReciboPuntoVenta entity = new ReciboPuntoVenta();		  
		
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
	
	public  List<ReciboPuntoVenta> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ReciboPuntoVenta> entities = new  ArrayList<ReciboPuntoVenta>();
		ReciboPuntoVenta entity = new ReciboPuntoVenta();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ReciboPuntoVentaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ReciboPuntoVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ReciboPuntoVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ReciboPuntoVenta();
      	    	entity=super.getEntity("",entity,resultSet,ReciboPuntoVentaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityReciboPuntoVenta("",entity,resultSet);
      	    	
				//entity.setReciboPuntoVentaOriginal( new ReciboPuntoVenta());
      	    	//entity.setReciboPuntoVentaOriginal(super.getEntity("",entity.getReciboPuntoVentaOriginal(),resultSet,ReciboPuntoVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setReciboPuntoVentaOriginal(this.getEntityReciboPuntoVenta("",entity.getReciboPuntoVentaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseReciboPuntoVentas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarReciboPuntoVenta(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ReciboPuntoVenta> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ReciboPuntoVenta> entities = new  ArrayList<ReciboPuntoVenta>();
		ReciboPuntoVenta entity = new ReciboPuntoVenta();		  
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
	
	public  List<ReciboPuntoVenta> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ReciboPuntoVenta> entities = new  ArrayList<ReciboPuntoVenta>();
		ReciboPuntoVenta entity = new ReciboPuntoVenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ReciboPuntoVenta();
				
				if(conMapGenerico) {
					entity.inicializarMapReciboPuntoVenta();
					//entity.setMapReciboPuntoVenta(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapReciboPuntoVentaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapReciboPuntoVenta().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ReciboPuntoVentaDataAccess.ISWITHSCHEMA);         		
					entity=ReciboPuntoVentaDataAccess.getEntityReciboPuntoVenta("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setReciboPuntoVentaOriginal( new ReciboPuntoVenta());
					////entity.setReciboPuntoVentaOriginal(super.getEntity("",entity.getReciboPuntoVentaOriginal(),resultSet,ReciboPuntoVentaDataAccess.ISWITHSCHEMA));         		
					////entity.setReciboPuntoVentaOriginal(this.getEntityReciboPuntoVenta("",entity.getReciboPuntoVentaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseReciboPuntoVentas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarReciboPuntoVenta(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public ReciboPuntoVenta getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ReciboPuntoVenta entity = new ReciboPuntoVenta();		  
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
	
	public  ReciboPuntoVenta getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ReciboPuntoVenta entity = new ReciboPuntoVenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ReciboPuntoVenta();
				
				if(conMapGenerico) {
					entity.inicializarMapReciboPuntoVenta();
					//entity.setMapReciboPuntoVenta(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapReciboPuntoVentaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapReciboPuntoVenta().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ReciboPuntoVentaDataAccess.ISWITHSCHEMA);         		
					entity=ReciboPuntoVentaDataAccess.getEntityReciboPuntoVenta("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setReciboPuntoVentaOriginal( new ReciboPuntoVenta());
					////entity.setReciboPuntoVentaOriginal(super.getEntity("",entity.getReciboPuntoVentaOriginal(),resultSet,ReciboPuntoVentaDataAccess.ISWITHSCHEMA));         		
					////entity.setReciboPuntoVentaOriginal(this.getEntityReciboPuntoVenta("",entity.getReciboPuntoVentaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseReciboPuntoVenta(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarReciboPuntoVenta(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ReciboPuntoVenta getEntityReciboPuntoVenta(String strPrefijo,ReciboPuntoVenta entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = ReciboPuntoVenta.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = ReciboPuntoVenta.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ReciboPuntoVentaDataAccess.setFieldReflectionReciboPuntoVenta(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasReciboPuntoVenta=ReciboPuntoVentaConstantesFunciones.getTodosTiposColumnasReciboPuntoVenta();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasReciboPuntoVenta) {
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
							field = ReciboPuntoVenta.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = ReciboPuntoVenta.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ReciboPuntoVentaDataAccess.setFieldReflectionReciboPuntoVenta(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionReciboPuntoVenta(Field field,String strPrefijo,String sColumn,ReciboPuntoVenta entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ReciboPuntoVentaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ReciboPuntoVentaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ReciboPuntoVentaConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ReciboPuntoVentaConstantesFunciones.IDBANCO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ReciboPuntoVentaConstantesFunciones.VALOREFECTIVO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ReciboPuntoVentaConstantesFunciones.VALORCHEQUE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ReciboPuntoVentaConstantesFunciones.NUMEROCHEQUE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ReciboPuntoVentaConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ReciboPuntoVenta>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<ReciboPuntoVenta> entities = new  ArrayList<ReciboPuntoVenta>();
		ReciboPuntoVenta entity = new ReciboPuntoVenta();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ReciboPuntoVentaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ReciboPuntoVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ReciboPuntoVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new ReciboPuntoVenta();
					entity=super.getEntity("",entity,resultSet,ReciboPuntoVentaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityReciboPuntoVenta("",entity,resultSet);
					
					//entity.setReciboPuntoVentaOriginal( new ReciboPuntoVenta());
					//entity.setReciboPuntoVentaOriginal(super.getEntity("",entity.getReciboPuntoVentaOriginal(),resultSet,ReciboPuntoVentaDataAccess.ISWITHSCHEMA));         		
					//entity.setReciboPuntoVentaOriginal(this.getEntityReciboPuntoVenta("",entity.getReciboPuntoVentaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseReciboPuntoVentas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarReciboPuntoVenta(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ReciboPuntoVenta>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<ReciboPuntoVenta> entities = new  ArrayList<ReciboPuntoVenta>();
		ReciboPuntoVenta entity = new ReciboPuntoVenta();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ReciboPuntoVentaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ReciboPuntoVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ReciboPuntoVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<ReciboPuntoVenta> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ReciboPuntoVenta> entities = new  ArrayList<ReciboPuntoVenta>();
		ReciboPuntoVenta entity = new ReciboPuntoVenta();		  
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
	
	public  List<ReciboPuntoVenta> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ReciboPuntoVenta> entities = new  ArrayList<ReciboPuntoVenta>();
		ReciboPuntoVenta entity = new ReciboPuntoVenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ReciboPuntoVenta();
      	    	entity=super.getEntity("",entity,resultSet,ReciboPuntoVentaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityReciboPuntoVenta("",entity,resultSet);
      	    	
				//entity.setReciboPuntoVentaOriginal( new ReciboPuntoVenta());
      	    	//entity.setReciboPuntoVentaOriginal(super.getEntity("",entity.getReciboPuntoVentaOriginal(),resultSet,ReciboPuntoVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setReciboPuntoVentaOriginal(this.getEntityReciboPuntoVenta("",entity.getReciboPuntoVentaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseReciboPuntoVentas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarReciboPuntoVenta(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ReciboPuntoVenta> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ReciboPuntoVenta> entities = new  ArrayList<ReciboPuntoVenta>();
		ReciboPuntoVenta entity = new ReciboPuntoVenta();		  
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
	
	public  List<ReciboPuntoVenta> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ReciboPuntoVenta> entities = new  ArrayList<ReciboPuntoVenta>();
		ReciboPuntoVenta entity = new ReciboPuntoVenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ReciboPuntoVenta();
      	    	entity=super.getEntity("",entity,resultSet,ReciboPuntoVentaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityReciboPuntoVenta("",entity,resultSet);
      	    	
				//entity.setReciboPuntoVentaOriginal( new ReciboPuntoVenta());
      	    	//entity.setReciboPuntoVentaOriginal(super.getEntity("",entity.getReciboPuntoVentaOriginal(),resultSet,ReciboPuntoVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setReciboPuntoVentaOriginal(this.getEntityReciboPuntoVenta("",entity.getReciboPuntoVentaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseReciboPuntoVentas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public ReciboPuntoVenta getEntityReciboPuntoVenta(String strPrefijo,ReciboPuntoVenta entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_cliente(resultSet.getLong(strPrefijo+ReciboPuntoVentaConstantesFunciones.IDCLIENTE));
				entity.setid_banco(resultSet.getLong(strPrefijo+ReciboPuntoVentaConstantesFunciones.IDBANCO));
				entity.setvalor_efectivo(resultSet.getDouble(strPrefijo+ReciboPuntoVentaConstantesFunciones.VALOREFECTIVO));
				entity.setvalor_cheque(resultSet.getDouble(strPrefijo+ReciboPuntoVentaConstantesFunciones.VALORCHEQUE));
				entity.setnumero_cheque(resultSet.getString(strPrefijo+ReciboPuntoVentaConstantesFunciones.NUMEROCHEQUE));
				entity.setfecha(new Date(resultSet.getDate(strPrefijo+ReciboPuntoVentaConstantesFunciones.FECHA).getTime()));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowReciboPuntoVenta(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(ReciboPuntoVenta entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ReciboPuntoVentaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ReciboPuntoVentaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ReciboPuntoVentaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ReciboPuntoVentaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ReciboPuntoVentaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ReciboPuntoVentaDataAccess.TABLENAME,ReciboPuntoVentaDataAccess.ISWITHSTOREPROCEDURES);
			
			ReciboPuntoVentaDataAccess.setReciboPuntoVentaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Cliente getCliente(Connexion connexion,ReciboPuntoVenta relrecibopuntoventa)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,relrecibopuntoventa.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public Banco getBanco(Connexion connexion,ReciboPuntoVenta relrecibopuntoventa)throws SQLException,Exception {

		Banco banco= new Banco();

		try {
			BancoDataAccess bancoDataAccess=new BancoDataAccess();

			bancoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bancoDataAccess.setConnexionType(this.connexionType);
			bancoDataAccess.setParameterDbType(this.parameterDbType);

			banco=bancoDataAccess.getEntity(connexion,relrecibopuntoventa.getid_banco());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return banco;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,ReciboPuntoVenta recibopuntoventa) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!recibopuntoventa.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_cliente.setValue(recibopuntoventa.getid_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_banco=new ParameterValue<Long>();
					parameterMaintenanceValueid_banco.setValue(recibopuntoventa.getid_banco());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_banco);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_efectivo=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_efectivo.setValue(recibopuntoventa.getvalor_efectivo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_efectivo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_cheque=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_cheque.setValue(recibopuntoventa.getvalor_cheque());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_cheque);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_cheque=new ParameterValue<String>();
					parameterMaintenanceValuenumero_cheque.setValue(recibopuntoventa.getnumero_cheque());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_cheque);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha=new ParameterValue<Date>();
					parameterMaintenanceValuefecha.setValue(recibopuntoventa.getfecha());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha);
					parametersTemp.add(parameterMaintenance);
					
						if(!recibopuntoventa.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(recibopuntoventa.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(recibopuntoventa.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(recibopuntoventa.getId());
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
	
	public void setIsNewIsChangedFalseReciboPuntoVenta(ReciboPuntoVenta recibopuntoventa)throws Exception  {		
		recibopuntoventa.setIsNew(false);
		recibopuntoventa.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseReciboPuntoVentas(List<ReciboPuntoVenta> recibopuntoventas)throws Exception  {				
		for(ReciboPuntoVenta recibopuntoventa:recibopuntoventas) {
			recibopuntoventa.setIsNew(false);
			recibopuntoventa.setIsChanged(false);
		}
	}
	
	public void generarExportarReciboPuntoVenta(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
