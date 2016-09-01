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
import com.bydan.erp.puntoventa.util.*;//CajeroTurnoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.comisiones.util.*;




@SuppressWarnings("unused")
final public class CajeroTurnoDataAccess extends  CajeroTurnoDataAccessAdditional{ //CajeroTurnoDataAccessAdditional,DataAccessHelper<CajeroTurno>
	//static Logger logger = Logger.getLogger(CajeroTurnoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="cajero_turno";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+CajeroTurnoConstantesFunciones.SCHEMA+"."+CajeroTurnoConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_usuario,id_vendedor,id_caja,id_mesa,id_turno_pun_ven,hora_inicio,hora_fin,hora_servicio)values(current_timestamp,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+CajeroTurnoConstantesFunciones.SCHEMA+"."+CajeroTurnoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_usuario=?,id_vendedor=?,id_caja=?,id_mesa=?,id_turno_pun_ven=?,hora_inicio=?,hora_fin=?,hora_servicio=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+CajeroTurnoConstantesFunciones.SCHEMA+"."+CajeroTurnoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select cajeroturno from "+CajeroTurnoConstantesFunciones.SPERSISTENCENAME+" cajeroturno";
	public static String QUERYSELECTNATIVE="select "+CajeroTurnoConstantesFunciones.SCHEMA+"."+CajeroTurnoConstantesFunciones.TABLENAME+".id,"+CajeroTurnoConstantesFunciones.SCHEMA+"."+CajeroTurnoConstantesFunciones.TABLENAME+".version_row,"+CajeroTurnoConstantesFunciones.SCHEMA+"."+CajeroTurnoConstantesFunciones.TABLENAME+".id_empresa,"+CajeroTurnoConstantesFunciones.SCHEMA+"."+CajeroTurnoConstantesFunciones.TABLENAME+".id_sucursal,"+CajeroTurnoConstantesFunciones.SCHEMA+"."+CajeroTurnoConstantesFunciones.TABLENAME+".id_usuario,"+CajeroTurnoConstantesFunciones.SCHEMA+"."+CajeroTurnoConstantesFunciones.TABLENAME+".id_vendedor,"+CajeroTurnoConstantesFunciones.SCHEMA+"."+CajeroTurnoConstantesFunciones.TABLENAME+".id_caja,"+CajeroTurnoConstantesFunciones.SCHEMA+"."+CajeroTurnoConstantesFunciones.TABLENAME+".id_mesa,"+CajeroTurnoConstantesFunciones.SCHEMA+"."+CajeroTurnoConstantesFunciones.TABLENAME+".id_turno_pun_ven,"+CajeroTurnoConstantesFunciones.SCHEMA+"."+CajeroTurnoConstantesFunciones.TABLENAME+".hora_inicio,"+CajeroTurnoConstantesFunciones.SCHEMA+"."+CajeroTurnoConstantesFunciones.TABLENAME+".hora_fin,"+CajeroTurnoConstantesFunciones.SCHEMA+"."+CajeroTurnoConstantesFunciones.TABLENAME+".hora_servicio from "+CajeroTurnoConstantesFunciones.SCHEMA+"."+CajeroTurnoConstantesFunciones.TABLENAME;//+" as "+CajeroTurnoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+CajeroTurnoConstantesFunciones.SCHEMA+"."+CajeroTurnoConstantesFunciones.TABLENAME+".id,"+CajeroTurnoConstantesFunciones.SCHEMA+"."+CajeroTurnoConstantesFunciones.TABLENAME+".version_row from "+CajeroTurnoConstantesFunciones.SCHEMA+"."+CajeroTurnoConstantesFunciones.TABLENAME;//+" as "+CajeroTurnoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+CajeroTurnoConstantesFunciones.SCHEMA+"."+CajeroTurnoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_usuario=?,id_vendedor=?,id_caja=?,id_mesa=?,id_turno_pun_ven=?,hora_inicio=?,hora_fin=?,hora_servicio=?";
	
	public static String STOREPROCEDUREINSERT="call SP_CAJEROTURNO_INSERT(?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_CAJEROTURNO_UPDATE(?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_CAJEROTURNO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_CAJEROTURNO_SELECT(?,?)";
	
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
	
	
	protected CajeroTurnoDataAccessAdditional cajeroturnoDataAccessAdditional=null;
	
	public CajeroTurnoDataAccessAdditional getCajeroTurnoDataAccessAdditional() {
		return this.cajeroturnoDataAccessAdditional;
	}
	
	public void setCajeroTurnoDataAccessAdditional(CajeroTurnoDataAccessAdditional cajeroturnoDataAccessAdditional) {
		try {
			this.cajeroturnoDataAccessAdditional=cajeroturnoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public CajeroTurnoDataAccess() {
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
		CajeroTurnoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		CajeroTurnoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		CajeroTurnoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setCajeroTurnoOriginal(CajeroTurno cajeroturno)throws Exception  {
		cajeroturno.setCajeroTurnoOriginal((CajeroTurno)cajeroturno.clone());		
	}
	
	public void setCajeroTurnosOriginal(List<CajeroTurno> cajeroturnos)throws Exception  {
		
		for(CajeroTurno cajeroturno:cajeroturnos){
			cajeroturno.setCajeroTurnoOriginal((CajeroTurno)cajeroturno.clone());
		}
	}
	
	public static void setCajeroTurnoOriginalStatic(CajeroTurno cajeroturno)throws Exception  {
		cajeroturno.setCajeroTurnoOriginal((CajeroTurno)cajeroturno.clone());		
	}
	
	public static void setCajeroTurnosOriginalStatic(List<CajeroTurno> cajeroturnos)throws Exception  {
		
		for(CajeroTurno cajeroturno:cajeroturnos){
			cajeroturno.setCajeroTurnoOriginal((CajeroTurno)cajeroturno.clone());
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
	
	public  CajeroTurno getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		CajeroTurno entity = new CajeroTurno();		
		
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
	
	public  CajeroTurno getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		CajeroTurno entity = new CajeroTurno();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=CajeroTurnoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CajeroTurnoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//PuntoVenta.CajeroTurno.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setCajeroTurnoOriginal(new CajeroTurno());
      	    	entity=super.getEntity("",entity,resultSet,CajeroTurnoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityCajeroTurno("",entity,resultSet); 
				
				//entity.setCajeroTurnoOriginal(super.getEntity("",entity.getCajeroTurnoOriginal(),resultSet,CajeroTurnoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCajeroTurnoOriginal(this.getEntityCajeroTurno("",entity.getCajeroTurnoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseCajeroTurno(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  CajeroTurno getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		CajeroTurno entity = new CajeroTurno();
				
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
	
	public  CajeroTurno getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		CajeroTurno entity = new CajeroTurno();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=CajeroTurnoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CajeroTurnoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CajeroTurnoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//PuntoVenta.CajeroTurno.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setCajeroTurnoOriginal(new CajeroTurno());
      	    	entity=super.getEntity("",entity,resultSet,CajeroTurnoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityCajeroTurno("",entity,resultSet);    
				
				//entity.setCajeroTurnoOriginal(super.getEntity("",entity.getCajeroTurnoOriginal(),resultSet,CajeroTurnoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCajeroTurnoOriginal(this.getEntityCajeroTurno("",entity.getCajeroTurnoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseCajeroTurno(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //CajeroTurno
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		CajeroTurno entity = new CajeroTurno();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CajeroTurnoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CajeroTurnoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CajeroTurnoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//PuntoVenta.CajeroTurno.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseCajeroTurno(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<CajeroTurno> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<CajeroTurno> entities = new  ArrayList<CajeroTurno>();
		CajeroTurno entity = new CajeroTurno();		  
		
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
	
	public  List<CajeroTurno> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<CajeroTurno> entities = new  ArrayList<CajeroTurno>();
		CajeroTurno entity = new CajeroTurno();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=CajeroTurnoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CajeroTurnoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CajeroTurnoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CajeroTurno();
      	    	entity=super.getEntity("",entity,resultSet,CajeroTurnoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCajeroTurno("",entity,resultSet);
      	    	
				//entity.setCajeroTurnoOriginal( new CajeroTurno());
      	    	//entity.setCajeroTurnoOriginal(super.getEntity("",entity.getCajeroTurnoOriginal(),resultSet,CajeroTurnoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCajeroTurnoOriginal(this.getEntityCajeroTurno("",entity.getCajeroTurnoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCajeroTurnos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCajeroTurno(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<CajeroTurno> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<CajeroTurno> entities = new  ArrayList<CajeroTurno>();
		CajeroTurno entity = new CajeroTurno();		  
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
	
	public  List<CajeroTurno> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<CajeroTurno> entities = new  ArrayList<CajeroTurno>();
		CajeroTurno entity = new CajeroTurno();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CajeroTurno();
				
				if(conMapGenerico) {
					entity.inicializarMapCajeroTurno();
					//entity.setMapCajeroTurno(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapCajeroTurnoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapCajeroTurno().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CajeroTurnoDataAccess.ISWITHSCHEMA);         		
					entity=CajeroTurnoDataAccess.getEntityCajeroTurno("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setCajeroTurnoOriginal( new CajeroTurno());
					////entity.setCajeroTurnoOriginal(super.getEntity("",entity.getCajeroTurnoOriginal(),resultSet,CajeroTurnoDataAccess.ISWITHSCHEMA));         		
					////entity.setCajeroTurnoOriginal(this.getEntityCajeroTurno("",entity.getCajeroTurnoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCajeroTurnos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCajeroTurno(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public CajeroTurno getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		CajeroTurno entity = new CajeroTurno();		  
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
	
	public  CajeroTurno getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		CajeroTurno entity = new CajeroTurno();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CajeroTurno();
				
				if(conMapGenerico) {
					entity.inicializarMapCajeroTurno();
					//entity.setMapCajeroTurno(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapCajeroTurnoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapCajeroTurno().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CajeroTurnoDataAccess.ISWITHSCHEMA);         		
					entity=CajeroTurnoDataAccess.getEntityCajeroTurno("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setCajeroTurnoOriginal( new CajeroTurno());
					////entity.setCajeroTurnoOriginal(super.getEntity("",entity.getCajeroTurnoOriginal(),resultSet,CajeroTurnoDataAccess.ISWITHSCHEMA));         		
					////entity.setCajeroTurnoOriginal(this.getEntityCajeroTurno("",entity.getCajeroTurnoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseCajeroTurno(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCajeroTurno(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static CajeroTurno getEntityCajeroTurno(String strPrefijo,CajeroTurno entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = CajeroTurno.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = CajeroTurno.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					CajeroTurnoDataAccess.setFieldReflectionCajeroTurno(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasCajeroTurno=CajeroTurnoConstantesFunciones.getTodosTiposColumnasCajeroTurno();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasCajeroTurno) {
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
							field = CajeroTurno.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = CajeroTurno.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						CajeroTurnoDataAccess.setFieldReflectionCajeroTurno(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionCajeroTurno(Field field,String strPrefijo,String sColumn,CajeroTurno entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case CajeroTurnoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CajeroTurnoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CajeroTurnoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CajeroTurnoConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CajeroTurnoConstantesFunciones.IDUSUARIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CajeroTurnoConstantesFunciones.IDVENDEDOR:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CajeroTurnoConstantesFunciones.IDCAJA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CajeroTurnoConstantesFunciones.IDMESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CajeroTurnoConstantesFunciones.IDTURNOPUNVEN:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CajeroTurnoConstantesFunciones.HORAINICIO:
					field.set(entity,resultSet.getTime(sCampo));
					break;
				
				case CajeroTurnoConstantesFunciones.HORAFIN:
					field.set(entity,resultSet.getTime(sCampo));
					break;
				
				case CajeroTurnoConstantesFunciones.HORASERVICIO:
					field.set(entity,resultSet.getTime(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<CajeroTurno>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<CajeroTurno> entities = new  ArrayList<CajeroTurno>();
		CajeroTurno entity = new CajeroTurno();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CajeroTurnoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CajeroTurnoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CajeroTurnoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new CajeroTurno();
					entity=super.getEntity("",entity,resultSet,CajeroTurnoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityCajeroTurno("",entity,resultSet);
					
					//entity.setCajeroTurnoOriginal( new CajeroTurno());
					//entity.setCajeroTurnoOriginal(super.getEntity("",entity.getCajeroTurnoOriginal(),resultSet,CajeroTurnoDataAccess.ISWITHSCHEMA));         		
					//entity.setCajeroTurnoOriginal(this.getEntityCajeroTurno("",entity.getCajeroTurnoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseCajeroTurnos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCajeroTurno(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<CajeroTurno>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<CajeroTurno> entities = new  ArrayList<CajeroTurno>();
		CajeroTurno entity = new CajeroTurno();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CajeroTurnoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CajeroTurnoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CajeroTurnoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<CajeroTurno> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CajeroTurno> entities = new  ArrayList<CajeroTurno>();
		CajeroTurno entity = new CajeroTurno();		  
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
	
	public  List<CajeroTurno> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CajeroTurno> entities = new  ArrayList<CajeroTurno>();
		CajeroTurno entity = new CajeroTurno();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CajeroTurno();
      	    	entity=super.getEntity("",entity,resultSet,CajeroTurnoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCajeroTurno("",entity,resultSet);
      	    	
				//entity.setCajeroTurnoOriginal( new CajeroTurno());
      	    	//entity.setCajeroTurnoOriginal(super.getEntity("",entity.getCajeroTurnoOriginal(),resultSet,CajeroTurnoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCajeroTurnoOriginal(this.getEntityCajeroTurno("",entity.getCajeroTurnoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseCajeroTurnos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCajeroTurno(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<CajeroTurno> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CajeroTurno> entities = new  ArrayList<CajeroTurno>();
		CajeroTurno entity = new CajeroTurno();		  
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
	
	public  List<CajeroTurno> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CajeroTurno> entities = new  ArrayList<CajeroTurno>();
		CajeroTurno entity = new CajeroTurno();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CajeroTurno();
      	    	entity=super.getEntity("",entity,resultSet,CajeroTurnoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCajeroTurno("",entity,resultSet);
      	    	
				//entity.setCajeroTurnoOriginal( new CajeroTurno());
      	    	//entity.setCajeroTurnoOriginal(super.getEntity("",entity.getCajeroTurnoOriginal(),resultSet,CajeroTurnoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCajeroTurnoOriginal(this.getEntityCajeroTurno("",entity.getCajeroTurnoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCajeroTurnos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public CajeroTurno getEntityCajeroTurno(String strPrefijo,CajeroTurno entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+CajeroTurnoConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+CajeroTurnoConstantesFunciones.IDSUCURSAL));
				entity.setid_usuario(resultSet.getLong(strPrefijo+CajeroTurnoConstantesFunciones.IDUSUARIO));
				entity.setid_vendedor(resultSet.getLong(strPrefijo+CajeroTurnoConstantesFunciones.IDVENDEDOR));
				entity.setid_caja(resultSet.getLong(strPrefijo+CajeroTurnoConstantesFunciones.IDCAJA));
				entity.setid_mesa(resultSet.getLong(strPrefijo+CajeroTurnoConstantesFunciones.IDMESA));
				entity.setid_turno_pun_ven(resultSet.getLong(strPrefijo+CajeroTurnoConstantesFunciones.IDTURNOPUNVEN));
				entity.sethora_inicio(resultSet.getTime(strPrefijo+CajeroTurnoConstantesFunciones.HORAINICIO));
				entity.sethora_fin(resultSet.getTime(strPrefijo+CajeroTurnoConstantesFunciones.HORAFIN));
				entity.sethora_servicio(resultSet.getTime(strPrefijo+CajeroTurnoConstantesFunciones.HORASERVICIO));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowCajeroTurno(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(CajeroTurno entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=CajeroTurnoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=CajeroTurnoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=CajeroTurnoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=CajeroTurnoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(CajeroTurnoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,CajeroTurnoDataAccess.TABLENAME,CajeroTurnoDataAccess.ISWITHSTOREPROCEDURES);
			
			CajeroTurnoDataAccess.setCajeroTurnoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,CajeroTurno relcajeroturno)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relcajeroturno.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,CajeroTurno relcajeroturno)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relcajeroturno.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Usuario getUsuario(Connexion connexion,CajeroTurno relcajeroturno)throws SQLException,Exception {

		Usuario usuario= new Usuario();

		try {
			UsuarioDataAccess usuarioDataAccess=new UsuarioDataAccess();

			usuarioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			usuarioDataAccess.setConnexionType(this.connexionType);
			usuarioDataAccess.setParameterDbType(this.parameterDbType);

			usuario=usuarioDataAccess.getEntity(connexion,relcajeroturno.getid_usuario());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return usuario;

	}

	public Vendedor getVendedor(Connexion connexion,CajeroTurno relcajeroturno)throws SQLException,Exception {

		Vendedor vendedor= new Vendedor();

		try {
			VendedorDataAccess vendedorDataAccess=new VendedorDataAccess();

			vendedorDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			vendedorDataAccess.setConnexionType(this.connexionType);
			vendedorDataAccess.setParameterDbType(this.parameterDbType);

			vendedor=vendedorDataAccess.getEntity(connexion,relcajeroturno.getid_vendedor());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return vendedor;

	}

	public Caja getCaja(Connexion connexion,CajeroTurno relcajeroturno)throws SQLException,Exception {

		Caja caja= new Caja();

		try {
			CajaDataAccess cajaDataAccess=new CajaDataAccess();

			cajaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cajaDataAccess.setConnexionType(this.connexionType);
			cajaDataAccess.setParameterDbType(this.parameterDbType);

			caja=cajaDataAccess.getEntity(connexion,relcajeroturno.getid_caja());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return caja;

	}

	public Mesa getMesa(Connexion connexion,CajeroTurno relcajeroturno)throws SQLException,Exception {

		Mesa mesa= new Mesa();

		try {
			MesaDataAccess mesaDataAccess=new MesaDataAccess();

			mesaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesaDataAccess.setConnexionType(this.connexionType);
			mesaDataAccess.setParameterDbType(this.parameterDbType);

			mesa=mesaDataAccess.getEntity(connexion,relcajeroturno.getid_mesa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mesa;

	}

	public TurnoPunVen getTurnoPunVen(Connexion connexion,CajeroTurno relcajeroturno)throws SQLException,Exception {

		TurnoPunVen turnopunven= new TurnoPunVen();

		try {
			TurnoPunVenDataAccess turnopunvenDataAccess=new TurnoPunVenDataAccess();

			turnopunvenDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			turnopunvenDataAccess.setConnexionType(this.connexionType);
			turnopunvenDataAccess.setParameterDbType(this.parameterDbType);

			turnopunven=turnopunvenDataAccess.getEntity(connexion,relcajeroturno.getid_turno_pun_ven());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return turnopunven;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,CajeroTurno cajeroturno) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!cajeroturno.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(cajeroturno.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(cajeroturno.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_usuario=new ParameterValue<Long>();
					parameterMaintenanceValueid_usuario.setValue(cajeroturno.getid_usuario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_usuario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_vendedor=new ParameterValue<Long>();
					parameterMaintenanceValueid_vendedor.setValue(cajeroturno.getid_vendedor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_vendedor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_caja=new ParameterValue<Long>();
					parameterMaintenanceValueid_caja.setValue(cajeroturno.getid_caja());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_caja);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mesa=new ParameterValue<Long>();
					parameterMaintenanceValueid_mesa.setValue(cajeroturno.getid_mesa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mesa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_turno_pun_ven=new ParameterValue<Long>();
					parameterMaintenanceValueid_turno_pun_ven.setValue(cajeroturno.getid_turno_pun_ven());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_turno_pun_ven);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.TIME);
					ParameterValue<Time> parameterMaintenanceValuehora_inicio=new ParameterValue<Time>();
					parameterMaintenanceValuehora_inicio.setValue(cajeroturno.gethora_inicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuehora_inicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.TIME);
					ParameterValue<Time> parameterMaintenanceValuehora_fin=new ParameterValue<Time>();
					parameterMaintenanceValuehora_fin.setValue(cajeroturno.gethora_fin());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuehora_fin);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.TIME);
					ParameterValue<Time> parameterMaintenanceValuehora_servicio=new ParameterValue<Time>();
					parameterMaintenanceValuehora_servicio.setValue(cajeroturno.gethora_servicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuehora_servicio);
					parametersTemp.add(parameterMaintenance);
					
						if(!cajeroturno.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(cajeroturno.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(cajeroturno.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(cajeroturno.getId());
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
	
	public void setIsNewIsChangedFalseCajeroTurno(CajeroTurno cajeroturno)throws Exception  {		
		cajeroturno.setIsNew(false);
		cajeroturno.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseCajeroTurnos(List<CajeroTurno> cajeroturnos)throws Exception  {				
		for(CajeroTurno cajeroturno:cajeroturnos) {
			cajeroturno.setIsNew(false);
			cajeroturno.setIsChanged(false);
		}
	}
	
	public void generarExportarCajeroTurno(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
