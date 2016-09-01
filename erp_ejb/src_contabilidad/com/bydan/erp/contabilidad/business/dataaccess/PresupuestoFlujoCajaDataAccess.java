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
import com.bydan.erp.contabilidad.util.*;//PresupuestoFlujoCajaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class PresupuestoFlujoCajaDataAccess extends  PresupuestoFlujoCajaDataAccessAdditional{ //PresupuestoFlujoCajaDataAccessAdditional,DataAccessHelper<PresupuestoFlujoCaja>
	//static Logger logger = Logger.getLogger(PresupuestoFlujoCajaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="presupuesto_flujo_caja";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+PresupuestoFlujoCajaConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_cuenta_contable,id_ejercicio,id_periodo,id_centro_costo,valor,valor_efectivo,porcentaje,fecha_presupuesto,fecha_proceso,observacion,id_anio,id_mes)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+PresupuestoFlujoCajaConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_cuenta_contable=?,id_ejercicio=?,id_periodo=?,id_centro_costo=?,valor=?,valor_efectivo=?,porcentaje=?,fecha_presupuesto=?,fecha_proceso=?,observacion=?,id_anio=?,id_mes=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+PresupuestoFlujoCajaConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select presupuestoflujocaja from "+PresupuestoFlujoCajaConstantesFunciones.SPERSISTENCENAME+" presupuestoflujocaja";
	public static String QUERYSELECTNATIVE="select "+PresupuestoFlujoCajaConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaConstantesFunciones.TABLENAME+".id,"+PresupuestoFlujoCajaConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaConstantesFunciones.TABLENAME+".version_row,"+PresupuestoFlujoCajaConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaConstantesFunciones.TABLENAME+".id_empresa,"+PresupuestoFlujoCajaConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaConstantesFunciones.TABLENAME+".id_cuenta_contable,"+PresupuestoFlujoCajaConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaConstantesFunciones.TABLENAME+".id_ejercicio,"+PresupuestoFlujoCajaConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaConstantesFunciones.TABLENAME+".id_periodo,"+PresupuestoFlujoCajaConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaConstantesFunciones.TABLENAME+".id_centro_costo,"+PresupuestoFlujoCajaConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaConstantesFunciones.TABLENAME+".valor,"+PresupuestoFlujoCajaConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaConstantesFunciones.TABLENAME+".valor_efectivo,"+PresupuestoFlujoCajaConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaConstantesFunciones.TABLENAME+".porcentaje,"+PresupuestoFlujoCajaConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaConstantesFunciones.TABLENAME+".fecha_presupuesto,"+PresupuestoFlujoCajaConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaConstantesFunciones.TABLENAME+".fecha_proceso,"+PresupuestoFlujoCajaConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaConstantesFunciones.TABLENAME+".observacion,"+PresupuestoFlujoCajaConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaConstantesFunciones.TABLENAME+".id_anio,"+PresupuestoFlujoCajaConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaConstantesFunciones.TABLENAME+".id_mes from "+PresupuestoFlujoCajaConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaConstantesFunciones.TABLENAME;//+" as "+PresupuestoFlujoCajaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+PresupuestoFlujoCajaConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaConstantesFunciones.TABLENAME+".id,"+PresupuestoFlujoCajaConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaConstantesFunciones.TABLENAME+".version_row from "+PresupuestoFlujoCajaConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaConstantesFunciones.TABLENAME;//+" as "+PresupuestoFlujoCajaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+PresupuestoFlujoCajaConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_cuenta_contable=?,id_ejercicio=?,id_periodo=?,id_centro_costo=?,valor=?,valor_efectivo=?,porcentaje=?,fecha_presupuesto=?,fecha_proceso=?,observacion=?,id_anio=?,id_mes=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PRESUPUESTOFLUJOCAJA_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PRESUPUESTOFLUJOCAJA_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PRESUPUESTOFLUJOCAJA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PRESUPUESTOFLUJOCAJA_SELECT(?,?)";
	
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
	
	
	protected PresupuestoFlujoCajaDataAccessAdditional presupuestoflujocajaDataAccessAdditional=null;
	
	public PresupuestoFlujoCajaDataAccessAdditional getPresupuestoFlujoCajaDataAccessAdditional() {
		return this.presupuestoflujocajaDataAccessAdditional;
	}
	
	public void setPresupuestoFlujoCajaDataAccessAdditional(PresupuestoFlujoCajaDataAccessAdditional presupuestoflujocajaDataAccessAdditional) {
		try {
			this.presupuestoflujocajaDataAccessAdditional=presupuestoflujocajaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public PresupuestoFlujoCajaDataAccess() {
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
		PresupuestoFlujoCajaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		PresupuestoFlujoCajaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		PresupuestoFlujoCajaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setPresupuestoFlujoCajaOriginal(PresupuestoFlujoCaja presupuestoflujocaja)throws Exception  {
		presupuestoflujocaja.setPresupuestoFlujoCajaOriginal((PresupuestoFlujoCaja)presupuestoflujocaja.clone());		
	}
	
	public void setPresupuestoFlujoCajasOriginal(List<PresupuestoFlujoCaja> presupuestoflujocajas)throws Exception  {
		
		for(PresupuestoFlujoCaja presupuestoflujocaja:presupuestoflujocajas){
			presupuestoflujocaja.setPresupuestoFlujoCajaOriginal((PresupuestoFlujoCaja)presupuestoflujocaja.clone());
		}
	}
	
	public static void setPresupuestoFlujoCajaOriginalStatic(PresupuestoFlujoCaja presupuestoflujocaja)throws Exception  {
		presupuestoflujocaja.setPresupuestoFlujoCajaOriginal((PresupuestoFlujoCaja)presupuestoflujocaja.clone());		
	}
	
	public static void setPresupuestoFlujoCajasOriginalStatic(List<PresupuestoFlujoCaja> presupuestoflujocajas)throws Exception  {
		
		for(PresupuestoFlujoCaja presupuestoflujocaja:presupuestoflujocajas){
			presupuestoflujocaja.setPresupuestoFlujoCajaOriginal((PresupuestoFlujoCaja)presupuestoflujocaja.clone());
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
	
	public  PresupuestoFlujoCaja getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		PresupuestoFlujoCaja entity = new PresupuestoFlujoCaja();		
		
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
	
	public  PresupuestoFlujoCaja getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		PresupuestoFlujoCaja entity = new PresupuestoFlujoCaja();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PresupuestoFlujoCajaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PresupuestoFlujoCajaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Contabilidad.PresupuestoFlujoCaja.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setPresupuestoFlujoCajaOriginal(new PresupuestoFlujoCaja());
      	    	entity=super.getEntity("",entity,resultSet,PresupuestoFlujoCajaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPresupuestoFlujoCaja("",entity,resultSet); 
				
				//entity.setPresupuestoFlujoCajaOriginal(super.getEntity("",entity.getPresupuestoFlujoCajaOriginal(),resultSet,PresupuestoFlujoCajaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPresupuestoFlujoCajaOriginal(this.getEntityPresupuestoFlujoCaja("",entity.getPresupuestoFlujoCajaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalsePresupuestoFlujoCaja(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  PresupuestoFlujoCaja getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		PresupuestoFlujoCaja entity = new PresupuestoFlujoCaja();
				
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
	
	public  PresupuestoFlujoCaja getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		PresupuestoFlujoCaja entity = new PresupuestoFlujoCaja();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PresupuestoFlujoCajaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PresupuestoFlujoCajaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PresupuestoFlujoCajaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.PresupuestoFlujoCaja.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setPresupuestoFlujoCajaOriginal(new PresupuestoFlujoCaja());
      	    	entity=super.getEntity("",entity,resultSet,PresupuestoFlujoCajaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPresupuestoFlujoCaja("",entity,resultSet);    
				
				//entity.setPresupuestoFlujoCajaOriginal(super.getEntity("",entity.getPresupuestoFlujoCajaOriginal(),resultSet,PresupuestoFlujoCajaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPresupuestoFlujoCajaOriginal(this.getEntityPresupuestoFlujoCaja("",entity.getPresupuestoFlujoCajaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalsePresupuestoFlujoCaja(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //PresupuestoFlujoCaja
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		PresupuestoFlujoCaja entity = new PresupuestoFlujoCaja();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PresupuestoFlujoCajaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PresupuestoFlujoCajaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PresupuestoFlujoCajaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.PresupuestoFlujoCaja.isActive=1
        	 
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
				//this.setIsNewIsChangedFalsePresupuestoFlujoCaja(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<PresupuestoFlujoCaja> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<PresupuestoFlujoCaja> entities = new  ArrayList<PresupuestoFlujoCaja>();
		PresupuestoFlujoCaja entity = new PresupuestoFlujoCaja();		  
		
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
	
	public  List<PresupuestoFlujoCaja> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<PresupuestoFlujoCaja> entities = new  ArrayList<PresupuestoFlujoCaja>();
		PresupuestoFlujoCaja entity = new PresupuestoFlujoCaja();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=PresupuestoFlujoCajaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PresupuestoFlujoCajaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PresupuestoFlujoCajaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PresupuestoFlujoCaja();
      	    	entity=super.getEntity("",entity,resultSet,PresupuestoFlujoCajaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPresupuestoFlujoCaja("",entity,resultSet);
      	    	
				//entity.setPresupuestoFlujoCajaOriginal( new PresupuestoFlujoCaja());
      	    	//entity.setPresupuestoFlujoCajaOriginal(super.getEntity("",entity.getPresupuestoFlujoCajaOriginal(),resultSet,PresupuestoFlujoCajaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPresupuestoFlujoCajaOriginal(this.getEntityPresupuestoFlujoCaja("",entity.getPresupuestoFlujoCajaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePresupuestoFlujoCajas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPresupuestoFlujoCaja(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<PresupuestoFlujoCaja> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<PresupuestoFlujoCaja> entities = new  ArrayList<PresupuestoFlujoCaja>();
		PresupuestoFlujoCaja entity = new PresupuestoFlujoCaja();		  
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
	
	public  List<PresupuestoFlujoCaja> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<PresupuestoFlujoCaja> entities = new  ArrayList<PresupuestoFlujoCaja>();
		PresupuestoFlujoCaja entity = new PresupuestoFlujoCaja();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PresupuestoFlujoCaja();
				
				if(conMapGenerico) {
					entity.inicializarMapPresupuestoFlujoCaja();
					//entity.setMapPresupuestoFlujoCaja(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapPresupuestoFlujoCajaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPresupuestoFlujoCaja().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PresupuestoFlujoCajaDataAccess.ISWITHSCHEMA);         		
					entity=PresupuestoFlujoCajaDataAccess.getEntityPresupuestoFlujoCaja("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setPresupuestoFlujoCajaOriginal( new PresupuestoFlujoCaja());
					////entity.setPresupuestoFlujoCajaOriginal(super.getEntity("",entity.getPresupuestoFlujoCajaOriginal(),resultSet,PresupuestoFlujoCajaDataAccess.ISWITHSCHEMA));         		
					////entity.setPresupuestoFlujoCajaOriginal(this.getEntityPresupuestoFlujoCaja("",entity.getPresupuestoFlujoCajaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePresupuestoFlujoCajas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPresupuestoFlujoCaja(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public PresupuestoFlujoCaja getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		PresupuestoFlujoCaja entity = new PresupuestoFlujoCaja();		  
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
	
	public  PresupuestoFlujoCaja getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		PresupuestoFlujoCaja entity = new PresupuestoFlujoCaja();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PresupuestoFlujoCaja();
				
				if(conMapGenerico) {
					entity.inicializarMapPresupuestoFlujoCaja();
					//entity.setMapPresupuestoFlujoCaja(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapPresupuestoFlujoCajaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPresupuestoFlujoCaja().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PresupuestoFlujoCajaDataAccess.ISWITHSCHEMA);         		
					entity=PresupuestoFlujoCajaDataAccess.getEntityPresupuestoFlujoCaja("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setPresupuestoFlujoCajaOriginal( new PresupuestoFlujoCaja());
					////entity.setPresupuestoFlujoCajaOriginal(super.getEntity("",entity.getPresupuestoFlujoCajaOriginal(),resultSet,PresupuestoFlujoCajaDataAccess.ISWITHSCHEMA));         		
					////entity.setPresupuestoFlujoCajaOriginal(this.getEntityPresupuestoFlujoCaja("",entity.getPresupuestoFlujoCajaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalsePresupuestoFlujoCaja(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPresupuestoFlujoCaja(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static PresupuestoFlujoCaja getEntityPresupuestoFlujoCaja(String strPrefijo,PresupuestoFlujoCaja entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = PresupuestoFlujoCaja.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = PresupuestoFlujoCaja.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					PresupuestoFlujoCajaDataAccess.setFieldReflectionPresupuestoFlujoCaja(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasPresupuestoFlujoCaja=PresupuestoFlujoCajaConstantesFunciones.getTodosTiposColumnasPresupuestoFlujoCaja();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasPresupuestoFlujoCaja) {
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
							field = PresupuestoFlujoCaja.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = PresupuestoFlujoCaja.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						PresupuestoFlujoCajaDataAccess.setFieldReflectionPresupuestoFlujoCaja(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionPresupuestoFlujoCaja(Field field,String strPrefijo,String sColumn,PresupuestoFlujoCaja entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case PresupuestoFlujoCajaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresupuestoFlujoCajaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PresupuestoFlujoCajaConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresupuestoFlujoCajaConstantesFunciones.IDCUENTACONTABLE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresupuestoFlujoCajaConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresupuestoFlujoCajaConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresupuestoFlujoCajaConstantesFunciones.IDCENTROCOSTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresupuestoFlujoCajaConstantesFunciones.VALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PresupuestoFlujoCajaConstantesFunciones.VALOREFECTIVO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PresupuestoFlujoCajaConstantesFunciones.PORCENTAJE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PresupuestoFlujoCajaConstantesFunciones.FECHAPRESUPUESTO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case PresupuestoFlujoCajaConstantesFunciones.FECHAPROCESO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case PresupuestoFlujoCajaConstantesFunciones.OBSERVACION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PresupuestoFlujoCajaConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresupuestoFlujoCajaConstantesFunciones.IDMES:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<PresupuestoFlujoCaja>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<PresupuestoFlujoCaja> entities = new  ArrayList<PresupuestoFlujoCaja>();
		PresupuestoFlujoCaja entity = new PresupuestoFlujoCaja();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PresupuestoFlujoCajaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PresupuestoFlujoCajaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PresupuestoFlujoCajaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new PresupuestoFlujoCaja();
					entity=super.getEntity("",entity,resultSet,PresupuestoFlujoCajaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityPresupuestoFlujoCaja("",entity,resultSet);
					
					//entity.setPresupuestoFlujoCajaOriginal( new PresupuestoFlujoCaja());
					//entity.setPresupuestoFlujoCajaOriginal(super.getEntity("",entity.getPresupuestoFlujoCajaOriginal(),resultSet,PresupuestoFlujoCajaDataAccess.ISWITHSCHEMA));         		
					//entity.setPresupuestoFlujoCajaOriginal(this.getEntityPresupuestoFlujoCaja("",entity.getPresupuestoFlujoCajaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalsePresupuestoFlujoCajas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPresupuestoFlujoCaja(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<PresupuestoFlujoCaja>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<PresupuestoFlujoCaja> entities = new  ArrayList<PresupuestoFlujoCaja>();
		PresupuestoFlujoCaja entity = new PresupuestoFlujoCaja();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PresupuestoFlujoCajaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PresupuestoFlujoCajaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PresupuestoFlujoCajaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<PresupuestoFlujoCaja> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PresupuestoFlujoCaja> entities = new  ArrayList<PresupuestoFlujoCaja>();
		PresupuestoFlujoCaja entity = new PresupuestoFlujoCaja();		  
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
	
	public  List<PresupuestoFlujoCaja> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PresupuestoFlujoCaja> entities = new  ArrayList<PresupuestoFlujoCaja>();
		PresupuestoFlujoCaja entity = new PresupuestoFlujoCaja();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PresupuestoFlujoCaja();
      	    	entity=super.getEntity("",entity,resultSet,PresupuestoFlujoCajaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPresupuestoFlujoCaja("",entity,resultSet);
      	    	
				//entity.setPresupuestoFlujoCajaOriginal( new PresupuestoFlujoCaja());
      	    	//entity.setPresupuestoFlujoCajaOriginal(super.getEntity("",entity.getPresupuestoFlujoCajaOriginal(),resultSet,PresupuestoFlujoCajaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPresupuestoFlujoCajaOriginal(this.getEntityPresupuestoFlujoCaja("",entity.getPresupuestoFlujoCajaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalsePresupuestoFlujoCajas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPresupuestoFlujoCaja(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<PresupuestoFlujoCaja> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PresupuestoFlujoCaja> entities = new  ArrayList<PresupuestoFlujoCaja>();
		PresupuestoFlujoCaja entity = new PresupuestoFlujoCaja();		  
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
	
	public  List<PresupuestoFlujoCaja> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PresupuestoFlujoCaja> entities = new  ArrayList<PresupuestoFlujoCaja>();
		PresupuestoFlujoCaja entity = new PresupuestoFlujoCaja();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PresupuestoFlujoCaja();
      	    	entity=super.getEntity("",entity,resultSet,PresupuestoFlujoCajaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPresupuestoFlujoCaja("",entity,resultSet);
      	    	
				//entity.setPresupuestoFlujoCajaOriginal( new PresupuestoFlujoCaja());
      	    	//entity.setPresupuestoFlujoCajaOriginal(super.getEntity("",entity.getPresupuestoFlujoCajaOriginal(),resultSet,PresupuestoFlujoCajaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPresupuestoFlujoCajaOriginal(this.getEntityPresupuestoFlujoCaja("",entity.getPresupuestoFlujoCajaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePresupuestoFlujoCajas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public PresupuestoFlujoCaja getEntityPresupuestoFlujoCaja(String strPrefijo,PresupuestoFlujoCaja entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+PresupuestoFlujoCajaConstantesFunciones.IDEMPRESA));
				entity.setid_cuenta_contable(resultSet.getLong(strPrefijo+PresupuestoFlujoCajaConstantesFunciones.IDCUENTACONTABLE));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+PresupuestoFlujoCajaConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+PresupuestoFlujoCajaConstantesFunciones.IDPERIODO));
				entity.setid_centro_costo(resultSet.getLong(strPrefijo+PresupuestoFlujoCajaConstantesFunciones.IDCENTROCOSTO));if(resultSet.wasNull()) {entity.setid_centro_costo(null); }
				entity.setvalor(resultSet.getDouble(strPrefijo+PresupuestoFlujoCajaConstantesFunciones.VALOR));
				entity.setvalor_efectivo(resultSet.getDouble(strPrefijo+PresupuestoFlujoCajaConstantesFunciones.VALOREFECTIVO));
				entity.setporcentaje(resultSet.getDouble(strPrefijo+PresupuestoFlujoCajaConstantesFunciones.PORCENTAJE));
				entity.setfecha_presupuesto(new Date(resultSet.getDate(strPrefijo+PresupuestoFlujoCajaConstantesFunciones.FECHAPRESUPUESTO).getTime()));
				entity.setfecha_proceso(new Date(resultSet.getDate(strPrefijo+PresupuestoFlujoCajaConstantesFunciones.FECHAPROCESO).getTime()));
				entity.setobservacion(resultSet.getString(strPrefijo+PresupuestoFlujoCajaConstantesFunciones.OBSERVACION));
				entity.setid_anio(resultSet.getLong(strPrefijo+PresupuestoFlujoCajaConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
				entity.setid_mes(resultSet.getLong(strPrefijo+PresupuestoFlujoCajaConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowPresupuestoFlujoCaja(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(PresupuestoFlujoCaja entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=PresupuestoFlujoCajaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=PresupuestoFlujoCajaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=PresupuestoFlujoCajaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=PresupuestoFlujoCajaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(PresupuestoFlujoCajaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,PresupuestoFlujoCajaDataAccess.TABLENAME,PresupuestoFlujoCajaDataAccess.ISWITHSTOREPROCEDURES);
			
			PresupuestoFlujoCajaDataAccess.setPresupuestoFlujoCajaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,PresupuestoFlujoCaja relpresupuestoflujocaja)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relpresupuestoflujocaja.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public CuentaContable getCuentaContable(Connexion connexion,PresupuestoFlujoCaja relpresupuestoflujocaja)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relpresupuestoflujocaja.getid_cuenta_contable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public Ejercicio getEjercicio(Connexion connexion,PresupuestoFlujoCaja relpresupuestoflujocaja)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relpresupuestoflujocaja.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,PresupuestoFlujoCaja relpresupuestoflujocaja)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,relpresupuestoflujocaja.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public CentroCosto getCentroCosto(Connexion connexion,PresupuestoFlujoCaja relpresupuestoflujocaja)throws SQLException,Exception {

		CentroCosto centrocosto= new CentroCosto();

		try {
			CentroCostoDataAccess centrocostoDataAccess=new CentroCostoDataAccess();

			centrocostoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			centrocostoDataAccess.setConnexionType(this.connexionType);
			centrocostoDataAccess.setParameterDbType(this.parameterDbType);

			centrocosto=centrocostoDataAccess.getEntity(connexion,relpresupuestoflujocaja.getid_centro_costo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return centrocosto;

	}

	public Anio getAnio(Connexion connexion,PresupuestoFlujoCaja relpresupuestoflujocaja)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);

			anio=anioDataAccess.getEntity(connexion,relpresupuestoflujocaja.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Mes getMes(Connexion connexion,PresupuestoFlujoCaja relpresupuestoflujocaja)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,relpresupuestoflujocaja.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,PresupuestoFlujoCaja presupuestoflujocaja) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!presupuestoflujocaja.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(presupuestoflujocaja.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable.setValue(presupuestoflujocaja.getid_cuenta_contable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(presupuestoflujocaja.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(presupuestoflujocaja.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_centro_costo=new ParameterValue<Long>();
					parameterMaintenanceValueid_centro_costo.setValue(presupuestoflujocaja.getid_centro_costo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_centro_costo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor=new ParameterValue<Double>();
					parameterMaintenanceValuevalor.setValue(presupuestoflujocaja.getvalor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_efectivo=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_efectivo.setValue(presupuestoflujocaja.getvalor_efectivo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_efectivo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcentaje=new ParameterValue<Double>();
					parameterMaintenanceValueporcentaje.setValue(presupuestoflujocaja.getporcentaje());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcentaje);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_presupuesto=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_presupuesto.setValue(presupuestoflujocaja.getfecha_presupuesto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_presupuesto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_proceso=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_proceso.setValue(presupuestoflujocaja.getfecha_proceso());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_proceso);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueobservacion=new ParameterValue<String>();
					parameterMaintenanceValueobservacion.setValue(presupuestoflujocaja.getobservacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueobservacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_anio=new ParameterValue<Long>();
					parameterMaintenanceValueid_anio.setValue(presupuestoflujocaja.getid_anio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_anio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes.setValue(presupuestoflujocaja.getid_mes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes);
					parametersTemp.add(parameterMaintenance);
					
						if(!presupuestoflujocaja.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(presupuestoflujocaja.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(presupuestoflujocaja.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(presupuestoflujocaja.getId());
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
	
	public void setIsNewIsChangedFalsePresupuestoFlujoCaja(PresupuestoFlujoCaja presupuestoflujocaja)throws Exception  {		
		presupuestoflujocaja.setIsNew(false);
		presupuestoflujocaja.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalsePresupuestoFlujoCajas(List<PresupuestoFlujoCaja> presupuestoflujocajas)throws Exception  {				
		for(PresupuestoFlujoCaja presupuestoflujocaja:presupuestoflujocajas) {
			presupuestoflujocaja.setIsNew(false);
			presupuestoflujocaja.setIsChanged(false);
		}
	}
	
	public void generarExportarPresupuestoFlujoCaja(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
