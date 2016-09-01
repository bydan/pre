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
import com.bydan.erp.puntoventa.util.*;//CajaEgresoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class CajaEgresoDataAccess extends  CajaEgresoDataAccessAdditional{ //CajaEgresoDataAccessAdditional,DataAccessHelper<CajaEgreso>
	//static Logger logger = Logger.getLogger(CajaEgresoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="caja_egreso";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+CajaEgresoConstantesFunciones.SCHEMA+"."+CajaEgresoConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_usuario,id_caja,id_turno_pun_ven,secuencial,fecha,hora,valor)values(current_timestamp,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+CajaEgresoConstantesFunciones.SCHEMA+"."+CajaEgresoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_usuario=?,id_caja=?,id_turno_pun_ven=?,secuencial=?,fecha=?,hora=?,valor=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+CajaEgresoConstantesFunciones.SCHEMA+"."+CajaEgresoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select cajaegreso from "+CajaEgresoConstantesFunciones.SPERSISTENCENAME+" cajaegreso";
	public static String QUERYSELECTNATIVE="select "+CajaEgresoConstantesFunciones.SCHEMA+"."+CajaEgresoConstantesFunciones.TABLENAME+".id,"+CajaEgresoConstantesFunciones.SCHEMA+"."+CajaEgresoConstantesFunciones.TABLENAME+".version_row,"+CajaEgresoConstantesFunciones.SCHEMA+"."+CajaEgresoConstantesFunciones.TABLENAME+".id_empresa,"+CajaEgresoConstantesFunciones.SCHEMA+"."+CajaEgresoConstantesFunciones.TABLENAME+".id_sucursal,"+CajaEgresoConstantesFunciones.SCHEMA+"."+CajaEgresoConstantesFunciones.TABLENAME+".id_usuario,"+CajaEgresoConstantesFunciones.SCHEMA+"."+CajaEgresoConstantesFunciones.TABLENAME+".id_caja,"+CajaEgresoConstantesFunciones.SCHEMA+"."+CajaEgresoConstantesFunciones.TABLENAME+".id_turno_pun_ven,"+CajaEgresoConstantesFunciones.SCHEMA+"."+CajaEgresoConstantesFunciones.TABLENAME+".secuencial,"+CajaEgresoConstantesFunciones.SCHEMA+"."+CajaEgresoConstantesFunciones.TABLENAME+".fecha,"+CajaEgresoConstantesFunciones.SCHEMA+"."+CajaEgresoConstantesFunciones.TABLENAME+".hora,"+CajaEgresoConstantesFunciones.SCHEMA+"."+CajaEgresoConstantesFunciones.TABLENAME+".valor from "+CajaEgresoConstantesFunciones.SCHEMA+"."+CajaEgresoConstantesFunciones.TABLENAME;//+" as "+CajaEgresoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+CajaEgresoConstantesFunciones.SCHEMA+"."+CajaEgresoConstantesFunciones.TABLENAME+".id,"+CajaEgresoConstantesFunciones.SCHEMA+"."+CajaEgresoConstantesFunciones.TABLENAME+".version_row,"+CajaEgresoConstantesFunciones.SCHEMA+"."+CajaEgresoConstantesFunciones.TABLENAME+".secuencial from "+CajaEgresoConstantesFunciones.SCHEMA+"."+CajaEgresoConstantesFunciones.TABLENAME;//+" as "+CajaEgresoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+CajaEgresoConstantesFunciones.SCHEMA+"."+CajaEgresoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_usuario=?,id_caja=?,id_turno_pun_ven=?,secuencial=?,fecha=?,hora=?,valor=?";
	
	public static String STOREPROCEDUREINSERT="call SP_CAJAEGRESO_INSERT(?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_CAJAEGRESO_UPDATE(?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_CAJAEGRESO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_CAJAEGRESO_SELECT(?,?)";
	
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
	
	
	protected CajaEgresoDataAccessAdditional cajaegresoDataAccessAdditional=null;
	
	public CajaEgresoDataAccessAdditional getCajaEgresoDataAccessAdditional() {
		return this.cajaegresoDataAccessAdditional;
	}
	
	public void setCajaEgresoDataAccessAdditional(CajaEgresoDataAccessAdditional cajaegresoDataAccessAdditional) {
		try {
			this.cajaegresoDataAccessAdditional=cajaegresoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public CajaEgresoDataAccess() {
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
		CajaEgresoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		CajaEgresoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		CajaEgresoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setCajaEgresoOriginal(CajaEgreso cajaegreso)throws Exception  {
		cajaegreso.setCajaEgresoOriginal((CajaEgreso)cajaegreso.clone());		
	}
	
	public void setCajaEgresosOriginal(List<CajaEgreso> cajaegresos)throws Exception  {
		
		for(CajaEgreso cajaegreso:cajaegresos){
			cajaegreso.setCajaEgresoOriginal((CajaEgreso)cajaegreso.clone());
		}
	}
	
	public static void setCajaEgresoOriginalStatic(CajaEgreso cajaegreso)throws Exception  {
		cajaegreso.setCajaEgresoOriginal((CajaEgreso)cajaegreso.clone());		
	}
	
	public static void setCajaEgresosOriginalStatic(List<CajaEgreso> cajaegresos)throws Exception  {
		
		for(CajaEgreso cajaegreso:cajaegresos){
			cajaegreso.setCajaEgresoOriginal((CajaEgreso)cajaegreso.clone());
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
	
	public  CajaEgreso getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		CajaEgreso entity = new CajaEgreso();		
		
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
	
	public  CajaEgreso getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		CajaEgreso entity = new CajaEgreso();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=CajaEgresoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CajaEgresoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//PuntoVenta.CajaEgreso.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setCajaEgresoOriginal(new CajaEgreso());
      	    	entity=super.getEntity("",entity,resultSet,CajaEgresoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityCajaEgreso("",entity,resultSet); 
				
				//entity.setCajaEgresoOriginal(super.getEntity("",entity.getCajaEgresoOriginal(),resultSet,CajaEgresoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCajaEgresoOriginal(this.getEntityCajaEgreso("",entity.getCajaEgresoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseCajaEgreso(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  CajaEgreso getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		CajaEgreso entity = new CajaEgreso();
				
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
	
	public  CajaEgreso getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		CajaEgreso entity = new CajaEgreso();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=CajaEgresoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CajaEgresoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CajaEgresoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//PuntoVenta.CajaEgreso.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setCajaEgresoOriginal(new CajaEgreso());
      	    	entity=super.getEntity("",entity,resultSet,CajaEgresoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityCajaEgreso("",entity,resultSet);    
				
				//entity.setCajaEgresoOriginal(super.getEntity("",entity.getCajaEgresoOriginal(),resultSet,CajaEgresoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCajaEgresoOriginal(this.getEntityCajaEgreso("",entity.getCajaEgresoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseCajaEgreso(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //CajaEgreso
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		CajaEgreso entity = new CajaEgreso();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CajaEgresoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CajaEgresoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CajaEgresoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//PuntoVenta.CajaEgreso.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseCajaEgreso(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<CajaEgreso> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<CajaEgreso> entities = new  ArrayList<CajaEgreso>();
		CajaEgreso entity = new CajaEgreso();		  
		
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
	
	public  List<CajaEgreso> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<CajaEgreso> entities = new  ArrayList<CajaEgreso>();
		CajaEgreso entity = new CajaEgreso();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=CajaEgresoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CajaEgresoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CajaEgresoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CajaEgreso();
      	    	entity=super.getEntity("",entity,resultSet,CajaEgresoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCajaEgreso("",entity,resultSet);
      	    	
				//entity.setCajaEgresoOriginal( new CajaEgreso());
      	    	//entity.setCajaEgresoOriginal(super.getEntity("",entity.getCajaEgresoOriginal(),resultSet,CajaEgresoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCajaEgresoOriginal(this.getEntityCajaEgreso("",entity.getCajaEgresoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCajaEgresos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCajaEgreso(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<CajaEgreso> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<CajaEgreso> entities = new  ArrayList<CajaEgreso>();
		CajaEgreso entity = new CajaEgreso();		  
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
	
	public  List<CajaEgreso> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<CajaEgreso> entities = new  ArrayList<CajaEgreso>();
		CajaEgreso entity = new CajaEgreso();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CajaEgreso();
				
				if(conMapGenerico) {
					entity.inicializarMapCajaEgreso();
					//entity.setMapCajaEgreso(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapCajaEgresoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapCajaEgreso().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CajaEgresoDataAccess.ISWITHSCHEMA);         		
					entity=CajaEgresoDataAccess.getEntityCajaEgreso("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setCajaEgresoOriginal( new CajaEgreso());
					////entity.setCajaEgresoOriginal(super.getEntity("",entity.getCajaEgresoOriginal(),resultSet,CajaEgresoDataAccess.ISWITHSCHEMA));         		
					////entity.setCajaEgresoOriginal(this.getEntityCajaEgreso("",entity.getCajaEgresoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCajaEgresos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCajaEgreso(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public CajaEgreso getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		CajaEgreso entity = new CajaEgreso();		  
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
	
	public  CajaEgreso getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		CajaEgreso entity = new CajaEgreso();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CajaEgreso();
				
				if(conMapGenerico) {
					entity.inicializarMapCajaEgreso();
					//entity.setMapCajaEgreso(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapCajaEgresoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapCajaEgreso().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CajaEgresoDataAccess.ISWITHSCHEMA);         		
					entity=CajaEgresoDataAccess.getEntityCajaEgreso("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setCajaEgresoOriginal( new CajaEgreso());
					////entity.setCajaEgresoOriginal(super.getEntity("",entity.getCajaEgresoOriginal(),resultSet,CajaEgresoDataAccess.ISWITHSCHEMA));         		
					////entity.setCajaEgresoOriginal(this.getEntityCajaEgreso("",entity.getCajaEgresoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseCajaEgreso(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCajaEgreso(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static CajaEgreso getEntityCajaEgreso(String strPrefijo,CajaEgreso entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = CajaEgreso.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = CajaEgreso.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					CajaEgresoDataAccess.setFieldReflectionCajaEgreso(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasCajaEgreso=CajaEgresoConstantesFunciones.getTodosTiposColumnasCajaEgreso();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasCajaEgreso) {
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
							field = CajaEgreso.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = CajaEgreso.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						CajaEgresoDataAccess.setFieldReflectionCajaEgreso(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionCajaEgreso(Field field,String strPrefijo,String sColumn,CajaEgreso entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case CajaEgresoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CajaEgresoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CajaEgresoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CajaEgresoConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CajaEgresoConstantesFunciones.IDUSUARIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CajaEgresoConstantesFunciones.IDCAJA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CajaEgresoConstantesFunciones.IDTURNOPUNVEN:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CajaEgresoConstantesFunciones.SECUENCIAL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CajaEgresoConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case CajaEgresoConstantesFunciones.HORA:
					field.set(entity,resultSet.getTime(sCampo));
					break;
				
				case CajaEgresoConstantesFunciones.VALOR:
					field.set(entity,resultSet.getDouble(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<CajaEgreso>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<CajaEgreso> entities = new  ArrayList<CajaEgreso>();
		CajaEgreso entity = new CajaEgreso();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CajaEgresoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CajaEgresoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CajaEgresoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new CajaEgreso();
					entity=super.getEntity("",entity,resultSet,CajaEgresoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityCajaEgreso("",entity,resultSet);
					
					//entity.setCajaEgresoOriginal( new CajaEgreso());
					//entity.setCajaEgresoOriginal(super.getEntity("",entity.getCajaEgresoOriginal(),resultSet,CajaEgresoDataAccess.ISWITHSCHEMA));         		
					//entity.setCajaEgresoOriginal(this.getEntityCajaEgreso("",entity.getCajaEgresoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseCajaEgresos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCajaEgreso(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<CajaEgreso>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<CajaEgreso> entities = new  ArrayList<CajaEgreso>();
		CajaEgreso entity = new CajaEgreso();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CajaEgresoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CajaEgresoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CajaEgresoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<CajaEgreso> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CajaEgreso> entities = new  ArrayList<CajaEgreso>();
		CajaEgreso entity = new CajaEgreso();		  
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
	
	public  List<CajaEgreso> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CajaEgreso> entities = new  ArrayList<CajaEgreso>();
		CajaEgreso entity = new CajaEgreso();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CajaEgreso();
      	    	entity=super.getEntity("",entity,resultSet,CajaEgresoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCajaEgreso("",entity,resultSet);
      	    	
				//entity.setCajaEgresoOriginal( new CajaEgreso());
      	    	//entity.setCajaEgresoOriginal(super.getEntity("",entity.getCajaEgresoOriginal(),resultSet,CajaEgresoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCajaEgresoOriginal(this.getEntityCajaEgreso("",entity.getCajaEgresoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseCajaEgresos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCajaEgreso(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<CajaEgreso> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CajaEgreso> entities = new  ArrayList<CajaEgreso>();
		CajaEgreso entity = new CajaEgreso();		  
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
	
	public  List<CajaEgreso> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CajaEgreso> entities = new  ArrayList<CajaEgreso>();
		CajaEgreso entity = new CajaEgreso();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CajaEgreso();
      	    	entity=super.getEntity("",entity,resultSet,CajaEgresoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCajaEgreso("",entity,resultSet);
      	    	
				//entity.setCajaEgresoOriginal( new CajaEgreso());
      	    	//entity.setCajaEgresoOriginal(super.getEntity("",entity.getCajaEgresoOriginal(),resultSet,CajaEgresoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCajaEgresoOriginal(this.getEntityCajaEgreso("",entity.getCajaEgresoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCajaEgresos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public CajaEgreso getEntityCajaEgreso(String strPrefijo,CajaEgreso entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+CajaEgresoConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+CajaEgresoConstantesFunciones.IDSUCURSAL));
				entity.setid_usuario(resultSet.getLong(strPrefijo+CajaEgresoConstantesFunciones.IDUSUARIO));
				entity.setid_caja(resultSet.getLong(strPrefijo+CajaEgresoConstantesFunciones.IDCAJA));
				entity.setid_turno_pun_ven(resultSet.getLong(strPrefijo+CajaEgresoConstantesFunciones.IDTURNOPUNVEN));
				entity.setsecuencial(resultSet.getString(strPrefijo+CajaEgresoConstantesFunciones.SECUENCIAL));
				entity.setfecha(new Date(resultSet.getDate(strPrefijo+CajaEgresoConstantesFunciones.FECHA).getTime()));
				entity.sethora(resultSet.getTime(strPrefijo+CajaEgresoConstantesFunciones.HORA));
				entity.setvalor(resultSet.getDouble(strPrefijo+CajaEgresoConstantesFunciones.VALOR));
			} else {
				entity.setsecuencial(resultSet.getString(strPrefijo+CajaEgresoConstantesFunciones.SECUENCIAL));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowCajaEgreso(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(CajaEgreso entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=CajaEgresoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=CajaEgresoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=CajaEgresoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=CajaEgresoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(CajaEgresoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,CajaEgresoDataAccess.TABLENAME,CajaEgresoDataAccess.ISWITHSTOREPROCEDURES);
			
			CajaEgresoDataAccess.setCajaEgresoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,CajaEgreso relcajaegreso)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relcajaegreso.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,CajaEgreso relcajaegreso)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relcajaegreso.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Usuario getUsuario(Connexion connexion,CajaEgreso relcajaegreso)throws SQLException,Exception {

		Usuario usuario= new Usuario();

		try {
			UsuarioDataAccess usuarioDataAccess=new UsuarioDataAccess();

			usuarioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			usuarioDataAccess.setConnexionType(this.connexionType);
			usuarioDataAccess.setParameterDbType(this.parameterDbType);

			usuario=usuarioDataAccess.getEntity(connexion,relcajaegreso.getid_usuario());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return usuario;

	}

	public Caja getCaja(Connexion connexion,CajaEgreso relcajaegreso)throws SQLException,Exception {

		Caja caja= new Caja();

		try {
			CajaDataAccess cajaDataAccess=new CajaDataAccess();

			cajaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cajaDataAccess.setConnexionType(this.connexionType);
			cajaDataAccess.setParameterDbType(this.parameterDbType);

			caja=cajaDataAccess.getEntity(connexion,relcajaegreso.getid_caja());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return caja;

	}

	public TurnoPunVen getTurnoPunVen(Connexion connexion,CajaEgreso relcajaegreso)throws SQLException,Exception {

		TurnoPunVen turnopunven= new TurnoPunVen();

		try {
			TurnoPunVenDataAccess turnopunvenDataAccess=new TurnoPunVenDataAccess();

			turnopunvenDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			turnopunvenDataAccess.setConnexionType(this.connexionType);
			turnopunvenDataAccess.setParameterDbType(this.parameterDbType);

			turnopunven=turnopunvenDataAccess.getEntity(connexion,relcajaegreso.getid_turno_pun_ven());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return turnopunven;

	}


		
		public List<CajaEgresoDetalle> getCajaEgresoDetalles(Connexion connexion,CajaEgreso cajaegreso)throws SQLException,Exception {

		List<CajaEgresoDetalle> cajaegresodetalles= new ArrayList<CajaEgresoDetalle>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CajaEgresoConstantesFunciones.SCHEMA+".caja_egreso ON "+CajaEgresoDetalleConstantesFunciones.SCHEMA+".caja_egreso_detalle.id_caja_egreso="+CajaEgresoConstantesFunciones.SCHEMA+".caja_egreso.id WHERE "+CajaEgresoConstantesFunciones.SCHEMA+".caja_egreso.id="+String.valueOf(cajaegreso.getId());
			} else {
				sQuery=" INNER JOIN cajaegresodetalle.CajaEgreso WHERE cajaegresodetalle.CajaEgreso.id="+String.valueOf(cajaegreso.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			CajaEgresoDetalleDataAccess cajaegresodetalleDataAccess=new CajaEgresoDetalleDataAccess();

			cajaegresodetalleDataAccess.setConnexionType(this.connexionType);
			cajaegresodetalleDataAccess.setParameterDbType(this.parameterDbType);
			cajaegresodetalles=cajaegresodetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cajaegresodetalles;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,CajaEgreso cajaegreso) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!cajaegreso.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(cajaegreso.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(cajaegreso.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_usuario=new ParameterValue<Long>();
					parameterMaintenanceValueid_usuario.setValue(cajaegreso.getid_usuario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_usuario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_caja=new ParameterValue<Long>();
					parameterMaintenanceValueid_caja.setValue(cajaegreso.getid_caja());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_caja);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_turno_pun_ven=new ParameterValue<Long>();
					parameterMaintenanceValueid_turno_pun_ven.setValue(cajaegreso.getid_turno_pun_ven());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_turno_pun_ven);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuesecuencial=new ParameterValue<String>();
					parameterMaintenanceValuesecuencial.setValue(cajaegreso.getsecuencial());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesecuencial);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha=new ParameterValue<Date>();
					parameterMaintenanceValuefecha.setValue(cajaegreso.getfecha());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.TIME);
					ParameterValue<Time> parameterMaintenanceValuehora=new ParameterValue<Time>();
					parameterMaintenanceValuehora.setValue(cajaegreso.gethora());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuehora);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor=new ParameterValue<Double>();
					parameterMaintenanceValuevalor.setValue(cajaegreso.getvalor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor);
					parametersTemp.add(parameterMaintenance);
					
						if(!cajaegreso.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(cajaegreso.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(cajaegreso.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(cajaegreso.getId());
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
	
	public void setIsNewIsChangedFalseCajaEgreso(CajaEgreso cajaegreso)throws Exception  {		
		cajaegreso.setIsNew(false);
		cajaegreso.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseCajaEgresos(List<CajaEgreso> cajaegresos)throws Exception  {				
		for(CajaEgreso cajaegreso:cajaegresos) {
			cajaegreso.setIsNew(false);
			cajaegreso.setIsChanged(false);
		}
	}
	
	public void generarExportarCajaEgreso(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
