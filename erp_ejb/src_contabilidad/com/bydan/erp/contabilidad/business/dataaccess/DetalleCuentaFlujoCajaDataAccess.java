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
package com.bydan.erp.contabilidad.business.dataaccess;

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

import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.contabilidad.util.*;//DetalleCuentaFlujoCajaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class DetalleCuentaFlujoCajaDataAccess extends  DetalleCuentaFlujoCajaDataAccessAdditional{ //DetalleCuentaFlujoCajaDataAccessAdditional,DataAccessHelper<DetalleCuentaFlujoCaja>
	//static Logger logger = Logger.getLogger(DetalleCuentaFlujoCajaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="detalle_cuenta_flujo_caja";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+DetalleCuentaFlujoCajaConstantesFunciones.SCHEMA+"."+DetalleCuentaFlujoCajaConstantesFunciones.TABLENAME+"(version_row,id_tipo_operacion,id_cuenta_flujo_caja,id_cuenta_contable,esta_activo)values(current_timestamp,?,?,?,?)";
	public static String QUERYUPDATE="update "+DetalleCuentaFlujoCajaConstantesFunciones.SCHEMA+"."+DetalleCuentaFlujoCajaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_tipo_operacion=?,id_cuenta_flujo_caja=?,id_cuenta_contable=?,esta_activo=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+DetalleCuentaFlujoCajaConstantesFunciones.SCHEMA+"."+DetalleCuentaFlujoCajaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select detallecuentaflujocaja from "+DetalleCuentaFlujoCajaConstantesFunciones.SPERSISTENCENAME+" detallecuentaflujocaja";
	public static String QUERYSELECTNATIVE="select "+DetalleCuentaFlujoCajaConstantesFunciones.SCHEMA+"."+DetalleCuentaFlujoCajaConstantesFunciones.TABLENAME+".id,"+DetalleCuentaFlujoCajaConstantesFunciones.SCHEMA+"."+DetalleCuentaFlujoCajaConstantesFunciones.TABLENAME+".version_row,"+DetalleCuentaFlujoCajaConstantesFunciones.SCHEMA+"."+DetalleCuentaFlujoCajaConstantesFunciones.TABLENAME+".id_tipo_operacion,"+DetalleCuentaFlujoCajaConstantesFunciones.SCHEMA+"."+DetalleCuentaFlujoCajaConstantesFunciones.TABLENAME+".id_cuenta_flujo_caja,"+DetalleCuentaFlujoCajaConstantesFunciones.SCHEMA+"."+DetalleCuentaFlujoCajaConstantesFunciones.TABLENAME+".id_cuenta_contable,"+DetalleCuentaFlujoCajaConstantesFunciones.SCHEMA+"."+DetalleCuentaFlujoCajaConstantesFunciones.TABLENAME+".esta_activo from "+DetalleCuentaFlujoCajaConstantesFunciones.SCHEMA+"."+DetalleCuentaFlujoCajaConstantesFunciones.TABLENAME;//+" as "+DetalleCuentaFlujoCajaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+DetalleCuentaFlujoCajaConstantesFunciones.SCHEMA+"."+DetalleCuentaFlujoCajaConstantesFunciones.TABLENAME+".id,"+DetalleCuentaFlujoCajaConstantesFunciones.SCHEMA+"."+DetalleCuentaFlujoCajaConstantesFunciones.TABLENAME+".version_row from "+DetalleCuentaFlujoCajaConstantesFunciones.SCHEMA+"."+DetalleCuentaFlujoCajaConstantesFunciones.TABLENAME;//+" as "+DetalleCuentaFlujoCajaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+DetalleCuentaFlujoCajaConstantesFunciones.SCHEMA+"."+DetalleCuentaFlujoCajaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_tipo_operacion=?,id_cuenta_flujo_caja=?,id_cuenta_contable=?,esta_activo=?";
	
	public static String STOREPROCEDUREINSERT="call SP_DETALLECUENTAFLUJOCAJA_INSERT(?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_DETALLECUENTAFLUJOCAJA_UPDATE(?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_DETALLECUENTAFLUJOCAJA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_DETALLECUENTAFLUJOCAJA_SELECT(?,?)";
	
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
	
	
	protected DetalleCuentaFlujoCajaDataAccessAdditional detallecuentaflujocajaDataAccessAdditional=null;
	
	public DetalleCuentaFlujoCajaDataAccessAdditional getDetalleCuentaFlujoCajaDataAccessAdditional() {
		return this.detallecuentaflujocajaDataAccessAdditional;
	}
	
	public void setDetalleCuentaFlujoCajaDataAccessAdditional(DetalleCuentaFlujoCajaDataAccessAdditional detallecuentaflujocajaDataAccessAdditional) {
		try {
			this.detallecuentaflujocajaDataAccessAdditional=detallecuentaflujocajaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public DetalleCuentaFlujoCajaDataAccess() {
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
		DetalleCuentaFlujoCajaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		DetalleCuentaFlujoCajaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		DetalleCuentaFlujoCajaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setDetalleCuentaFlujoCajaOriginal(DetalleCuentaFlujoCaja detallecuentaflujocaja)throws Exception  {
		detallecuentaflujocaja.setDetalleCuentaFlujoCajaOriginal((DetalleCuentaFlujoCaja)detallecuentaflujocaja.clone());		
	}
	
	public void setDetalleCuentaFlujoCajasOriginal(List<DetalleCuentaFlujoCaja> detallecuentaflujocajas)throws Exception  {
		
		for(DetalleCuentaFlujoCaja detallecuentaflujocaja:detallecuentaflujocajas){
			detallecuentaflujocaja.setDetalleCuentaFlujoCajaOriginal((DetalleCuentaFlujoCaja)detallecuentaflujocaja.clone());
		}
	}
	
	public static void setDetalleCuentaFlujoCajaOriginalStatic(DetalleCuentaFlujoCaja detallecuentaflujocaja)throws Exception  {
		detallecuentaflujocaja.setDetalleCuentaFlujoCajaOriginal((DetalleCuentaFlujoCaja)detallecuentaflujocaja.clone());		
	}
	
	public static void setDetalleCuentaFlujoCajasOriginalStatic(List<DetalleCuentaFlujoCaja> detallecuentaflujocajas)throws Exception  {
		
		for(DetalleCuentaFlujoCaja detallecuentaflujocaja:detallecuentaflujocajas){
			detallecuentaflujocaja.setDetalleCuentaFlujoCajaOriginal((DetalleCuentaFlujoCaja)detallecuentaflujocaja.clone());
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
	
	public  DetalleCuentaFlujoCaja getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		DetalleCuentaFlujoCaja entity = new DetalleCuentaFlujoCaja();		
		
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
	
	public  DetalleCuentaFlujoCaja getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		DetalleCuentaFlujoCaja entity = new DetalleCuentaFlujoCaja();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleCuentaFlujoCajaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleCuentaFlujoCajaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Contabilidad.DetalleCuentaFlujoCaja.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setDetalleCuentaFlujoCajaOriginal(new DetalleCuentaFlujoCaja());
      	    	entity=super.getEntity("",entity,resultSet,DetalleCuentaFlujoCajaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetalleCuentaFlujoCaja("",entity,resultSet); 
				
				//entity.setDetalleCuentaFlujoCajaOriginal(super.getEntity("",entity.getDetalleCuentaFlujoCajaOriginal(),resultSet,DetalleCuentaFlujoCajaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleCuentaFlujoCajaOriginal(this.getEntityDetalleCuentaFlujoCaja("",entity.getDetalleCuentaFlujoCajaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseDetalleCuentaFlujoCaja(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  DetalleCuentaFlujoCaja getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetalleCuentaFlujoCaja entity = new DetalleCuentaFlujoCaja();
				
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
	
	public  DetalleCuentaFlujoCaja getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetalleCuentaFlujoCaja entity = new DetalleCuentaFlujoCaja();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleCuentaFlujoCajaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleCuentaFlujoCajaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleCuentaFlujoCajaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.DetalleCuentaFlujoCaja.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setDetalleCuentaFlujoCajaOriginal(new DetalleCuentaFlujoCaja());
      	    	entity=super.getEntity("",entity,resultSet,DetalleCuentaFlujoCajaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetalleCuentaFlujoCaja("",entity,resultSet);    
				
				//entity.setDetalleCuentaFlujoCajaOriginal(super.getEntity("",entity.getDetalleCuentaFlujoCajaOriginal(),resultSet,DetalleCuentaFlujoCajaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleCuentaFlujoCajaOriginal(this.getEntityDetalleCuentaFlujoCaja("",entity.getDetalleCuentaFlujoCajaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseDetalleCuentaFlujoCaja(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //DetalleCuentaFlujoCaja
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		DetalleCuentaFlujoCaja entity = new DetalleCuentaFlujoCaja();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleCuentaFlujoCajaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleCuentaFlujoCajaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleCuentaFlujoCajaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.DetalleCuentaFlujoCaja.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseDetalleCuentaFlujoCaja(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<DetalleCuentaFlujoCaja> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetalleCuentaFlujoCaja> entities = new  ArrayList<DetalleCuentaFlujoCaja>();
		DetalleCuentaFlujoCaja entity = new DetalleCuentaFlujoCaja();		  
		
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
	
	public  List<DetalleCuentaFlujoCaja> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetalleCuentaFlujoCaja> entities = new  ArrayList<DetalleCuentaFlujoCaja>();
		DetalleCuentaFlujoCaja entity = new DetalleCuentaFlujoCaja();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleCuentaFlujoCajaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleCuentaFlujoCajaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleCuentaFlujoCajaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleCuentaFlujoCaja();
      	    	entity=super.getEntity("",entity,resultSet,DetalleCuentaFlujoCajaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleCuentaFlujoCaja("",entity,resultSet);
      	    	
				//entity.setDetalleCuentaFlujoCajaOriginal( new DetalleCuentaFlujoCaja());
      	    	//entity.setDetalleCuentaFlujoCajaOriginal(super.getEntity("",entity.getDetalleCuentaFlujoCajaOriginal(),resultSet,DetalleCuentaFlujoCajaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleCuentaFlujoCajaOriginal(this.getEntityDetalleCuentaFlujoCaja("",entity.getDetalleCuentaFlujoCajaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleCuentaFlujoCajas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleCuentaFlujoCaja(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetalleCuentaFlujoCaja> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetalleCuentaFlujoCaja> entities = new  ArrayList<DetalleCuentaFlujoCaja>();
		DetalleCuentaFlujoCaja entity = new DetalleCuentaFlujoCaja();		  
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
	
	public  List<DetalleCuentaFlujoCaja> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetalleCuentaFlujoCaja> entities = new  ArrayList<DetalleCuentaFlujoCaja>();
		DetalleCuentaFlujoCaja entity = new DetalleCuentaFlujoCaja();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleCuentaFlujoCaja();
				
				if(conMapGenerico) {
					entity.inicializarMapDetalleCuentaFlujoCaja();
					//entity.setMapDetalleCuentaFlujoCaja(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapDetalleCuentaFlujoCajaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetalleCuentaFlujoCaja().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetalleCuentaFlujoCajaDataAccess.ISWITHSCHEMA);         		
					entity=DetalleCuentaFlujoCajaDataAccess.getEntityDetalleCuentaFlujoCaja("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetalleCuentaFlujoCajaOriginal( new DetalleCuentaFlujoCaja());
					////entity.setDetalleCuentaFlujoCajaOriginal(super.getEntity("",entity.getDetalleCuentaFlujoCajaOriginal(),resultSet,DetalleCuentaFlujoCajaDataAccess.ISWITHSCHEMA));         		
					////entity.setDetalleCuentaFlujoCajaOriginal(this.getEntityDetalleCuentaFlujoCaja("",entity.getDetalleCuentaFlujoCajaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleCuentaFlujoCajas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleCuentaFlujoCaja(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public DetalleCuentaFlujoCaja getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetalleCuentaFlujoCaja entity = new DetalleCuentaFlujoCaja();		  
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
	
	public  DetalleCuentaFlujoCaja getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetalleCuentaFlujoCaja entity = new DetalleCuentaFlujoCaja();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleCuentaFlujoCaja();
				
				if(conMapGenerico) {
					entity.inicializarMapDetalleCuentaFlujoCaja();
					//entity.setMapDetalleCuentaFlujoCaja(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapDetalleCuentaFlujoCajaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetalleCuentaFlujoCaja().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetalleCuentaFlujoCajaDataAccess.ISWITHSCHEMA);         		
					entity=DetalleCuentaFlujoCajaDataAccess.getEntityDetalleCuentaFlujoCaja("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetalleCuentaFlujoCajaOriginal( new DetalleCuentaFlujoCaja());
					////entity.setDetalleCuentaFlujoCajaOriginal(super.getEntity("",entity.getDetalleCuentaFlujoCajaOriginal(),resultSet,DetalleCuentaFlujoCajaDataAccess.ISWITHSCHEMA));         		
					////entity.setDetalleCuentaFlujoCajaOriginal(this.getEntityDetalleCuentaFlujoCaja("",entity.getDetalleCuentaFlujoCajaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseDetalleCuentaFlujoCaja(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleCuentaFlujoCaja(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static DetalleCuentaFlujoCaja getEntityDetalleCuentaFlujoCaja(String strPrefijo,DetalleCuentaFlujoCaja entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = DetalleCuentaFlujoCaja.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = DetalleCuentaFlujoCaja.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					DetalleCuentaFlujoCajaDataAccess.setFieldReflectionDetalleCuentaFlujoCaja(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasDetalleCuentaFlujoCaja=DetalleCuentaFlujoCajaConstantesFunciones.getTodosTiposColumnasDetalleCuentaFlujoCaja();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasDetalleCuentaFlujoCaja) {
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
							field = DetalleCuentaFlujoCaja.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = DetalleCuentaFlujoCaja.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						DetalleCuentaFlujoCajaDataAccess.setFieldReflectionDetalleCuentaFlujoCaja(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionDetalleCuentaFlujoCaja(Field field,String strPrefijo,String sColumn,DetalleCuentaFlujoCaja entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case DetalleCuentaFlujoCajaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleCuentaFlujoCajaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleCuentaFlujoCajaConstantesFunciones.IDTIPOOPERACION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleCuentaFlujoCajaConstantesFunciones.IDCUENTAFLUJOCAJA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleCuentaFlujoCajaConstantesFunciones.IDCUENTACONTABLE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleCuentaFlujoCajaConstantesFunciones.ESTAACTIVO:
					field.set(entity,resultSet.getBoolean(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetalleCuentaFlujoCaja>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<DetalleCuentaFlujoCaja> entities = new  ArrayList<DetalleCuentaFlujoCaja>();
		DetalleCuentaFlujoCaja entity = new DetalleCuentaFlujoCaja();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleCuentaFlujoCajaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleCuentaFlujoCajaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleCuentaFlujoCajaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new DetalleCuentaFlujoCaja();
					entity=super.getEntity("",entity,resultSet,DetalleCuentaFlujoCajaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityDetalleCuentaFlujoCaja("",entity,resultSet);
					
					//entity.setDetalleCuentaFlujoCajaOriginal( new DetalleCuentaFlujoCaja());
					//entity.setDetalleCuentaFlujoCajaOriginal(super.getEntity("",entity.getDetalleCuentaFlujoCajaOriginal(),resultSet,DetalleCuentaFlujoCajaDataAccess.ISWITHSCHEMA));         		
					//entity.setDetalleCuentaFlujoCajaOriginal(this.getEntityDetalleCuentaFlujoCaja("",entity.getDetalleCuentaFlujoCajaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseDetalleCuentaFlujoCajas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleCuentaFlujoCaja(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetalleCuentaFlujoCaja>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<DetalleCuentaFlujoCaja> entities = new  ArrayList<DetalleCuentaFlujoCaja>();
		DetalleCuentaFlujoCaja entity = new DetalleCuentaFlujoCaja();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleCuentaFlujoCajaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleCuentaFlujoCajaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleCuentaFlujoCajaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<DetalleCuentaFlujoCaja> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleCuentaFlujoCaja> entities = new  ArrayList<DetalleCuentaFlujoCaja>();
		DetalleCuentaFlujoCaja entity = new DetalleCuentaFlujoCaja();		  
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
	
	public  List<DetalleCuentaFlujoCaja> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleCuentaFlujoCaja> entities = new  ArrayList<DetalleCuentaFlujoCaja>();
		DetalleCuentaFlujoCaja entity = new DetalleCuentaFlujoCaja();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleCuentaFlujoCaja();
      	    	entity=super.getEntity("",entity,resultSet,DetalleCuentaFlujoCajaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleCuentaFlujoCaja("",entity,resultSet);
      	    	
				//entity.setDetalleCuentaFlujoCajaOriginal( new DetalleCuentaFlujoCaja());
      	    	//entity.setDetalleCuentaFlujoCajaOriginal(super.getEntity("",entity.getDetalleCuentaFlujoCajaOriginal(),resultSet,DetalleCuentaFlujoCajaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleCuentaFlujoCajaOriginal(this.getEntityDetalleCuentaFlujoCaja("",entity.getDetalleCuentaFlujoCajaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseDetalleCuentaFlujoCajas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleCuentaFlujoCaja(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetalleCuentaFlujoCaja> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleCuentaFlujoCaja> entities = new  ArrayList<DetalleCuentaFlujoCaja>();
		DetalleCuentaFlujoCaja entity = new DetalleCuentaFlujoCaja();		  
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
	
	public  List<DetalleCuentaFlujoCaja> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleCuentaFlujoCaja> entities = new  ArrayList<DetalleCuentaFlujoCaja>();
		DetalleCuentaFlujoCaja entity = new DetalleCuentaFlujoCaja();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleCuentaFlujoCaja();
      	    	entity=super.getEntity("",entity,resultSet,DetalleCuentaFlujoCajaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleCuentaFlujoCaja("",entity,resultSet);
      	    	
				//entity.setDetalleCuentaFlujoCajaOriginal( new DetalleCuentaFlujoCaja());
      	    	//entity.setDetalleCuentaFlujoCajaOriginal(super.getEntity("",entity.getDetalleCuentaFlujoCajaOriginal(),resultSet,DetalleCuentaFlujoCajaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleCuentaFlujoCajaOriginal(this.getEntityDetalleCuentaFlujoCaja("",entity.getDetalleCuentaFlujoCajaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleCuentaFlujoCajas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public DetalleCuentaFlujoCaja getEntityDetalleCuentaFlujoCaja(String strPrefijo,DetalleCuentaFlujoCaja entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_tipo_operacion(resultSet.getLong(strPrefijo+DetalleCuentaFlujoCajaConstantesFunciones.IDTIPOOPERACION));
				entity.setid_cuenta_flujo_caja(resultSet.getLong(strPrefijo+DetalleCuentaFlujoCajaConstantesFunciones.IDCUENTAFLUJOCAJA));
				entity.setid_cuenta_contable(resultSet.getLong(strPrefijo+DetalleCuentaFlujoCajaConstantesFunciones.IDCUENTACONTABLE));
				entity.setesta_activo(resultSet.getBoolean(strPrefijo+DetalleCuentaFlujoCajaConstantesFunciones.ESTAACTIVO));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowDetalleCuentaFlujoCaja(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(DetalleCuentaFlujoCaja entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=DetalleCuentaFlujoCajaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=DetalleCuentaFlujoCajaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=DetalleCuentaFlujoCajaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=DetalleCuentaFlujoCajaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(DetalleCuentaFlujoCajaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,DetalleCuentaFlujoCajaDataAccess.TABLENAME,DetalleCuentaFlujoCajaDataAccess.ISWITHSTOREPROCEDURES);
			
			DetalleCuentaFlujoCajaDataAccess.setDetalleCuentaFlujoCajaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public TipoOperacion getTipoOperacion(Connexion connexion,DetalleCuentaFlujoCaja reldetallecuentaflujocaja)throws SQLException,Exception {

		TipoOperacion tipooperacion= new TipoOperacion();

		try {
			TipoOperacionDataAccess tipooperacionDataAccess=new TipoOperacionDataAccess();

			tipooperacionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipooperacionDataAccess.setConnexionType(this.connexionType);
			tipooperacionDataAccess.setParameterDbType(this.parameterDbType);

			tipooperacion=tipooperacionDataAccess.getEntity(connexion,reldetallecuentaflujocaja.getid_tipo_operacion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipooperacion;

	}

	public CuentaFlujoCaja getCuentaFlujoCaja(Connexion connexion,DetalleCuentaFlujoCaja reldetallecuentaflujocaja)throws SQLException,Exception {

		CuentaFlujoCaja cuentaflujocaja= new CuentaFlujoCaja();

		try {
			CuentaFlujoCajaDataAccess cuentaflujocajaDataAccess=new CuentaFlujoCajaDataAccess();

			cuentaflujocajaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentaflujocajaDataAccess.setConnexionType(this.connexionType);
			cuentaflujocajaDataAccess.setParameterDbType(this.parameterDbType);

			cuentaflujocaja=cuentaflujocajaDataAccess.getEntity(connexion,reldetallecuentaflujocaja.getid_cuenta_flujo_caja());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentaflujocaja;

	}

	public CuentaContable getCuentaContable(Connexion connexion,DetalleCuentaFlujoCaja reldetallecuentaflujocaja)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,reldetallecuentaflujocaja.getid_cuenta_contable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,DetalleCuentaFlujoCaja detallecuentaflujocaja) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!detallecuentaflujocaja.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_operacion=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_operacion.setValue(detallecuentaflujocaja.getid_tipo_operacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_operacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_flujo_caja=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_flujo_caja.setValue(detallecuentaflujocaja.getid_cuenta_flujo_caja());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_flujo_caja);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable.setValue(detallecuentaflujocaja.getid_cuenta_contable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValueesta_activo=new ParameterValue<Boolean>();
					parameterMaintenanceValueesta_activo.setValue(detallecuentaflujocaja.getesta_activo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueesta_activo);
					parametersTemp.add(parameterMaintenance);
					
						if(!detallecuentaflujocaja.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(detallecuentaflujocaja.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(detallecuentaflujocaja.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(detallecuentaflujocaja.getId());
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
	
	public void setIsNewIsChangedFalseDetalleCuentaFlujoCaja(DetalleCuentaFlujoCaja detallecuentaflujocaja)throws Exception  {		
		detallecuentaflujocaja.setIsNew(false);
		detallecuentaflujocaja.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseDetalleCuentaFlujoCajas(List<DetalleCuentaFlujoCaja> detallecuentaflujocajas)throws Exception  {				
		for(DetalleCuentaFlujoCaja detallecuentaflujocaja:detallecuentaflujocajas) {
			detallecuentaflujocaja.setIsNew(false);
			detallecuentaflujocaja.setIsChanged(false);
		}
	}
	
	public void generarExportarDetalleCuentaFlujoCaja(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
