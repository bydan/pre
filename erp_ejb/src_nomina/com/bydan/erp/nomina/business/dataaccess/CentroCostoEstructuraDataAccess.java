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
package com.bydan.erp.nomina.business.dataaccess;

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

import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.nomina.util.*;//CentroCostoEstructuraConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class CentroCostoEstructuraDataAccess extends  CentroCostoEstructuraDataAccessAdditional{ //CentroCostoEstructuraDataAccessAdditional,DataAccessHelper<CentroCostoEstructura>
	//static Logger logger = Logger.getLogger(CentroCostoEstructuraDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="centro_costo_estructura";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+CentroCostoEstructuraConstantesFunciones.SCHEMA+"."+CentroCostoEstructuraConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_estructura,id_centro_costo,porcentaje)values(current_timestamp,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+CentroCostoEstructuraConstantesFunciones.SCHEMA+"."+CentroCostoEstructuraConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_estructura=?,id_centro_costo=?,porcentaje=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+CentroCostoEstructuraConstantesFunciones.SCHEMA+"."+CentroCostoEstructuraConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select centrocostoestructura from "+CentroCostoEstructuraConstantesFunciones.SPERSISTENCENAME+" centrocostoestructura";
	public static String QUERYSELECTNATIVE="select "+CentroCostoEstructuraConstantesFunciones.SCHEMA+"."+CentroCostoEstructuraConstantesFunciones.TABLENAME+".id,"+CentroCostoEstructuraConstantesFunciones.SCHEMA+"."+CentroCostoEstructuraConstantesFunciones.TABLENAME+".version_row,"+CentroCostoEstructuraConstantesFunciones.SCHEMA+"."+CentroCostoEstructuraConstantesFunciones.TABLENAME+".id_empresa,"+CentroCostoEstructuraConstantesFunciones.SCHEMA+"."+CentroCostoEstructuraConstantesFunciones.TABLENAME+".id_sucursal,"+CentroCostoEstructuraConstantesFunciones.SCHEMA+"."+CentroCostoEstructuraConstantesFunciones.TABLENAME+".id_estructura,"+CentroCostoEstructuraConstantesFunciones.SCHEMA+"."+CentroCostoEstructuraConstantesFunciones.TABLENAME+".id_centro_costo,"+CentroCostoEstructuraConstantesFunciones.SCHEMA+"."+CentroCostoEstructuraConstantesFunciones.TABLENAME+".porcentaje from "+CentroCostoEstructuraConstantesFunciones.SCHEMA+"."+CentroCostoEstructuraConstantesFunciones.TABLENAME;//+" as "+CentroCostoEstructuraConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+CentroCostoEstructuraConstantesFunciones.SCHEMA+"."+CentroCostoEstructuraConstantesFunciones.TABLENAME+".id,"+CentroCostoEstructuraConstantesFunciones.SCHEMA+"."+CentroCostoEstructuraConstantesFunciones.TABLENAME+".version_row from "+CentroCostoEstructuraConstantesFunciones.SCHEMA+"."+CentroCostoEstructuraConstantesFunciones.TABLENAME;//+" as "+CentroCostoEstructuraConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+CentroCostoEstructuraConstantesFunciones.SCHEMA+"."+CentroCostoEstructuraConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_estructura=?,id_centro_costo=?,porcentaje=?";
	
	public static String STOREPROCEDUREINSERT="call SP_CENTROCOSTOESTRUCTURA_INSERT(?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_CENTROCOSTOESTRUCTURA_UPDATE(?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_CENTROCOSTOESTRUCTURA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_CENTROCOSTOESTRUCTURA_SELECT(?,?)";
	
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
	
	
	protected CentroCostoEstructuraDataAccessAdditional centrocostoestructuraDataAccessAdditional=null;
	
	public CentroCostoEstructuraDataAccessAdditional getCentroCostoEstructuraDataAccessAdditional() {
		return this.centrocostoestructuraDataAccessAdditional;
	}
	
	public void setCentroCostoEstructuraDataAccessAdditional(CentroCostoEstructuraDataAccessAdditional centrocostoestructuraDataAccessAdditional) {
		try {
			this.centrocostoestructuraDataAccessAdditional=centrocostoestructuraDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public CentroCostoEstructuraDataAccess() {
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
		CentroCostoEstructuraDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		CentroCostoEstructuraDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		CentroCostoEstructuraDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setCentroCostoEstructuraOriginal(CentroCostoEstructura centrocostoestructura)throws Exception  {
		centrocostoestructura.setCentroCostoEstructuraOriginal((CentroCostoEstructura)centrocostoestructura.clone());		
	}
	
	public void setCentroCostoEstructurasOriginal(List<CentroCostoEstructura> centrocostoestructuras)throws Exception  {
		
		for(CentroCostoEstructura centrocostoestructura:centrocostoestructuras){
			centrocostoestructura.setCentroCostoEstructuraOriginal((CentroCostoEstructura)centrocostoestructura.clone());
		}
	}
	
	public static void setCentroCostoEstructuraOriginalStatic(CentroCostoEstructura centrocostoestructura)throws Exception  {
		centrocostoestructura.setCentroCostoEstructuraOriginal((CentroCostoEstructura)centrocostoestructura.clone());		
	}
	
	public static void setCentroCostoEstructurasOriginalStatic(List<CentroCostoEstructura> centrocostoestructuras)throws Exception  {
		
		for(CentroCostoEstructura centrocostoestructura:centrocostoestructuras){
			centrocostoestructura.setCentroCostoEstructuraOriginal((CentroCostoEstructura)centrocostoestructura.clone());
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
	
	public  CentroCostoEstructura getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		CentroCostoEstructura entity = new CentroCostoEstructura();		
		
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
	
	public  CentroCostoEstructura getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		CentroCostoEstructura entity = new CentroCostoEstructura();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=CentroCostoEstructuraDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CentroCostoEstructuraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.CentroCostoEstructura.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setCentroCostoEstructuraOriginal(new CentroCostoEstructura());
      	    	entity=super.getEntity("",entity,resultSet,CentroCostoEstructuraDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityCentroCostoEstructura("",entity,resultSet); 
				
				//entity.setCentroCostoEstructuraOriginal(super.getEntity("",entity.getCentroCostoEstructuraOriginal(),resultSet,CentroCostoEstructuraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCentroCostoEstructuraOriginal(this.getEntityCentroCostoEstructura("",entity.getCentroCostoEstructuraOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseCentroCostoEstructura(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  CentroCostoEstructura getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		CentroCostoEstructura entity = new CentroCostoEstructura();
				
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
	
	public  CentroCostoEstructura getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		CentroCostoEstructura entity = new CentroCostoEstructura();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=CentroCostoEstructuraDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CentroCostoEstructuraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CentroCostoEstructuraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.CentroCostoEstructura.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setCentroCostoEstructuraOriginal(new CentroCostoEstructura());
      	    	entity=super.getEntity("",entity,resultSet,CentroCostoEstructuraDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityCentroCostoEstructura("",entity,resultSet);    
				
				//entity.setCentroCostoEstructuraOriginal(super.getEntity("",entity.getCentroCostoEstructuraOriginal(),resultSet,CentroCostoEstructuraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCentroCostoEstructuraOriginal(this.getEntityCentroCostoEstructura("",entity.getCentroCostoEstructuraOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseCentroCostoEstructura(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //CentroCostoEstructura
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		CentroCostoEstructura entity = new CentroCostoEstructura();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CentroCostoEstructuraDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CentroCostoEstructuraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CentroCostoEstructuraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.CentroCostoEstructura.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseCentroCostoEstructura(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<CentroCostoEstructura> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<CentroCostoEstructura> entities = new  ArrayList<CentroCostoEstructura>();
		CentroCostoEstructura entity = new CentroCostoEstructura();		  
		
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
	
	public  List<CentroCostoEstructura> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<CentroCostoEstructura> entities = new  ArrayList<CentroCostoEstructura>();
		CentroCostoEstructura entity = new CentroCostoEstructura();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=CentroCostoEstructuraDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CentroCostoEstructuraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CentroCostoEstructuraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CentroCostoEstructura();
      	    	entity=super.getEntity("",entity,resultSet,CentroCostoEstructuraDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCentroCostoEstructura("",entity,resultSet);
      	    	
				//entity.setCentroCostoEstructuraOriginal( new CentroCostoEstructura());
      	    	//entity.setCentroCostoEstructuraOriginal(super.getEntity("",entity.getCentroCostoEstructuraOriginal(),resultSet,CentroCostoEstructuraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCentroCostoEstructuraOriginal(this.getEntityCentroCostoEstructura("",entity.getCentroCostoEstructuraOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCentroCostoEstructuras(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCentroCostoEstructura(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<CentroCostoEstructura> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<CentroCostoEstructura> entities = new  ArrayList<CentroCostoEstructura>();
		CentroCostoEstructura entity = new CentroCostoEstructura();		  
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
	
	public  List<CentroCostoEstructura> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<CentroCostoEstructura> entities = new  ArrayList<CentroCostoEstructura>();
		CentroCostoEstructura entity = new CentroCostoEstructura();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CentroCostoEstructura();
				
				if(conMapGenerico) {
					entity.inicializarMapCentroCostoEstructura();
					//entity.setMapCentroCostoEstructura(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapCentroCostoEstructuraValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapCentroCostoEstructura().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CentroCostoEstructuraDataAccess.ISWITHSCHEMA);         		
					entity=CentroCostoEstructuraDataAccess.getEntityCentroCostoEstructura("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setCentroCostoEstructuraOriginal( new CentroCostoEstructura());
					////entity.setCentroCostoEstructuraOriginal(super.getEntity("",entity.getCentroCostoEstructuraOriginal(),resultSet,CentroCostoEstructuraDataAccess.ISWITHSCHEMA));         		
					////entity.setCentroCostoEstructuraOriginal(this.getEntityCentroCostoEstructura("",entity.getCentroCostoEstructuraOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCentroCostoEstructuras(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCentroCostoEstructura(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public CentroCostoEstructura getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		CentroCostoEstructura entity = new CentroCostoEstructura();		  
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
	
	public  CentroCostoEstructura getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		CentroCostoEstructura entity = new CentroCostoEstructura();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CentroCostoEstructura();
				
				if(conMapGenerico) {
					entity.inicializarMapCentroCostoEstructura();
					//entity.setMapCentroCostoEstructura(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapCentroCostoEstructuraValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapCentroCostoEstructura().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CentroCostoEstructuraDataAccess.ISWITHSCHEMA);         		
					entity=CentroCostoEstructuraDataAccess.getEntityCentroCostoEstructura("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setCentroCostoEstructuraOriginal( new CentroCostoEstructura());
					////entity.setCentroCostoEstructuraOriginal(super.getEntity("",entity.getCentroCostoEstructuraOriginal(),resultSet,CentroCostoEstructuraDataAccess.ISWITHSCHEMA));         		
					////entity.setCentroCostoEstructuraOriginal(this.getEntityCentroCostoEstructura("",entity.getCentroCostoEstructuraOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseCentroCostoEstructura(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCentroCostoEstructura(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static CentroCostoEstructura getEntityCentroCostoEstructura(String strPrefijo,CentroCostoEstructura entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = CentroCostoEstructura.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = CentroCostoEstructura.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					CentroCostoEstructuraDataAccess.setFieldReflectionCentroCostoEstructura(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasCentroCostoEstructura=CentroCostoEstructuraConstantesFunciones.getTodosTiposColumnasCentroCostoEstructura();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasCentroCostoEstructura) {
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
							field = CentroCostoEstructura.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = CentroCostoEstructura.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						CentroCostoEstructuraDataAccess.setFieldReflectionCentroCostoEstructura(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionCentroCostoEstructura(Field field,String strPrefijo,String sColumn,CentroCostoEstructura entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case CentroCostoEstructuraConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CentroCostoEstructuraConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CentroCostoEstructuraConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CentroCostoEstructuraConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CentroCostoEstructuraConstantesFunciones.IDESTRUCTURA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CentroCostoEstructuraConstantesFunciones.IDCENTROCOSTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CentroCostoEstructuraConstantesFunciones.PORCENTAJE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<CentroCostoEstructura>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<CentroCostoEstructura> entities = new  ArrayList<CentroCostoEstructura>();
		CentroCostoEstructura entity = new CentroCostoEstructura();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CentroCostoEstructuraDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CentroCostoEstructuraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CentroCostoEstructuraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new CentroCostoEstructura();
					entity=super.getEntity("",entity,resultSet,CentroCostoEstructuraDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityCentroCostoEstructura("",entity,resultSet);
					
					//entity.setCentroCostoEstructuraOriginal( new CentroCostoEstructura());
					//entity.setCentroCostoEstructuraOriginal(super.getEntity("",entity.getCentroCostoEstructuraOriginal(),resultSet,CentroCostoEstructuraDataAccess.ISWITHSCHEMA));         		
					//entity.setCentroCostoEstructuraOriginal(this.getEntityCentroCostoEstructura("",entity.getCentroCostoEstructuraOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseCentroCostoEstructuras(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCentroCostoEstructura(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<CentroCostoEstructura>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<CentroCostoEstructura> entities = new  ArrayList<CentroCostoEstructura>();
		CentroCostoEstructura entity = new CentroCostoEstructura();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CentroCostoEstructuraDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CentroCostoEstructuraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CentroCostoEstructuraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<CentroCostoEstructura> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CentroCostoEstructura> entities = new  ArrayList<CentroCostoEstructura>();
		CentroCostoEstructura entity = new CentroCostoEstructura();		  
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
	
	public  List<CentroCostoEstructura> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CentroCostoEstructura> entities = new  ArrayList<CentroCostoEstructura>();
		CentroCostoEstructura entity = new CentroCostoEstructura();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CentroCostoEstructura();
      	    	entity=super.getEntity("",entity,resultSet,CentroCostoEstructuraDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCentroCostoEstructura("",entity,resultSet);
      	    	
				//entity.setCentroCostoEstructuraOriginal( new CentroCostoEstructura());
      	    	//entity.setCentroCostoEstructuraOriginal(super.getEntity("",entity.getCentroCostoEstructuraOriginal(),resultSet,CentroCostoEstructuraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCentroCostoEstructuraOriginal(this.getEntityCentroCostoEstructura("",entity.getCentroCostoEstructuraOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseCentroCostoEstructuras(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCentroCostoEstructura(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<CentroCostoEstructura> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CentroCostoEstructura> entities = new  ArrayList<CentroCostoEstructura>();
		CentroCostoEstructura entity = new CentroCostoEstructura();		  
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
	
	public  List<CentroCostoEstructura> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CentroCostoEstructura> entities = new  ArrayList<CentroCostoEstructura>();
		CentroCostoEstructura entity = new CentroCostoEstructura();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CentroCostoEstructura();
      	    	entity=super.getEntity("",entity,resultSet,CentroCostoEstructuraDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCentroCostoEstructura("",entity,resultSet);
      	    	
				//entity.setCentroCostoEstructuraOriginal( new CentroCostoEstructura());
      	    	//entity.setCentroCostoEstructuraOriginal(super.getEntity("",entity.getCentroCostoEstructuraOriginal(),resultSet,CentroCostoEstructuraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCentroCostoEstructuraOriginal(this.getEntityCentroCostoEstructura("",entity.getCentroCostoEstructuraOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCentroCostoEstructuras(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public CentroCostoEstructura getEntityCentroCostoEstructura(String strPrefijo,CentroCostoEstructura entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+CentroCostoEstructuraConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+CentroCostoEstructuraConstantesFunciones.IDSUCURSAL));
				entity.setid_estructura(resultSet.getLong(strPrefijo+CentroCostoEstructuraConstantesFunciones.IDESTRUCTURA));
				entity.setid_centro_costo(resultSet.getLong(strPrefijo+CentroCostoEstructuraConstantesFunciones.IDCENTROCOSTO));if(resultSet.wasNull()) {entity.setid_centro_costo(null); }
				entity.setporcentaje(resultSet.getDouble(strPrefijo+CentroCostoEstructuraConstantesFunciones.PORCENTAJE));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowCentroCostoEstructura(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(CentroCostoEstructura entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=CentroCostoEstructuraDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=CentroCostoEstructuraDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=CentroCostoEstructuraDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=CentroCostoEstructuraDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(CentroCostoEstructuraConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,CentroCostoEstructuraDataAccess.TABLENAME,CentroCostoEstructuraDataAccess.ISWITHSTOREPROCEDURES);
			
			CentroCostoEstructuraDataAccess.setCentroCostoEstructuraOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,CentroCostoEstructura relcentrocostoestructura)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relcentrocostoestructura.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,CentroCostoEstructura relcentrocostoestructura)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relcentrocostoestructura.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Estructura getEstructura(Connexion connexion,CentroCostoEstructura relcentrocostoestructura)throws SQLException,Exception {

		Estructura estructura= new Estructura();

		try {
			EstructuraDataAccess estructuraDataAccess=new EstructuraDataAccess();

			estructuraDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estructuraDataAccess.setConnexionType(this.connexionType);
			estructuraDataAccess.setParameterDbType(this.parameterDbType);

			estructura=estructuraDataAccess.getEntity(connexion,relcentrocostoestructura.getid_estructura());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estructura;

	}

	public CentroCosto getCentroCosto(Connexion connexion,CentroCostoEstructura relcentrocostoestructura)throws SQLException,Exception {

		CentroCosto centrocosto= new CentroCosto();

		try {
			CentroCostoDataAccess centrocostoDataAccess=new CentroCostoDataAccess();

			centrocostoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			centrocostoDataAccess.setConnexionType(this.connexionType);
			centrocostoDataAccess.setParameterDbType(this.parameterDbType);

			centrocosto=centrocostoDataAccess.getEntity(connexion,relcentrocostoestructura.getid_centro_costo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return centrocosto;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,CentroCostoEstructura centrocostoestructura) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!centrocostoestructura.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(centrocostoestructura.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(centrocostoestructura.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estructura=new ParameterValue<Long>();
					parameterMaintenanceValueid_estructura.setValue(centrocostoestructura.getid_estructura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estructura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_centro_costo=new ParameterValue<Long>();
					parameterMaintenanceValueid_centro_costo.setValue(centrocostoestructura.getid_centro_costo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_centro_costo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcentaje=new ParameterValue<Double>();
					parameterMaintenanceValueporcentaje.setValue(centrocostoestructura.getporcentaje());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcentaje);
					parametersTemp.add(parameterMaintenance);
					
						if(!centrocostoestructura.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(centrocostoestructura.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(centrocostoestructura.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(centrocostoestructura.getId());
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
	
	public void setIsNewIsChangedFalseCentroCostoEstructura(CentroCostoEstructura centrocostoestructura)throws Exception  {		
		centrocostoestructura.setIsNew(false);
		centrocostoestructura.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseCentroCostoEstructuras(List<CentroCostoEstructura> centrocostoestructuras)throws Exception  {				
		for(CentroCostoEstructura centrocostoestructura:centrocostoestructuras) {
			centrocostoestructura.setIsNew(false);
			centrocostoestructura.setIsChanged(false);
		}
	}
	
	public void generarExportarCentroCostoEstructura(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
