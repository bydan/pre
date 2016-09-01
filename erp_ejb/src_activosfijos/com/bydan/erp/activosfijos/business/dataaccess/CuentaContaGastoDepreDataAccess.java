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
package com.bydan.erp.activosfijos.business.dataaccess;

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

import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.activosfijos.util.*;//CuentaContaGastoDepreConstantesFunciones;


import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class CuentaContaGastoDepreDataAccess extends  CuentaContaGastoDepreDataAccessAdditional{ //CuentaContaGastoDepreDataAccessAdditional,DataAccessHelper<CuentaContaGastoDepre>
	//static Logger logger = Logger.getLogger(CuentaContaGastoDepreDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="cuenta_conta_gasto_depre";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+CuentaContaGastoDepreConstantesFunciones.SCHEMA+"."+CuentaContaGastoDepreConstantesFunciones.TABLENAME+"(version_row,id_cuenta_contable,id_gasto_depreciacion)values(current_timestamp,?,?)";
	public static String QUERYUPDATE="update "+CuentaContaGastoDepreConstantesFunciones.SCHEMA+"."+CuentaContaGastoDepreConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_cuenta_contable=?,id_gasto_depreciacion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+CuentaContaGastoDepreConstantesFunciones.SCHEMA+"."+CuentaContaGastoDepreConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select cuentacontagastodepre from "+CuentaContaGastoDepreConstantesFunciones.SPERSISTENCENAME+" cuentacontagastodepre";
	public static String QUERYSELECTNATIVE="select "+CuentaContaGastoDepreConstantesFunciones.SCHEMA+"."+CuentaContaGastoDepreConstantesFunciones.TABLENAME+".id,"+CuentaContaGastoDepreConstantesFunciones.SCHEMA+"."+CuentaContaGastoDepreConstantesFunciones.TABLENAME+".version_row,"+CuentaContaGastoDepreConstantesFunciones.SCHEMA+"."+CuentaContaGastoDepreConstantesFunciones.TABLENAME+".id_cuenta_contable,"+CuentaContaGastoDepreConstantesFunciones.SCHEMA+"."+CuentaContaGastoDepreConstantesFunciones.TABLENAME+".id_gasto_depreciacion from "+CuentaContaGastoDepreConstantesFunciones.SCHEMA+"."+CuentaContaGastoDepreConstantesFunciones.TABLENAME;//+" as "+CuentaContaGastoDepreConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+CuentaContaGastoDepreConstantesFunciones.SCHEMA+"."+CuentaContaGastoDepreConstantesFunciones.TABLENAME+".id,"+CuentaContaGastoDepreConstantesFunciones.SCHEMA+"."+CuentaContaGastoDepreConstantesFunciones.TABLENAME+".version_row from "+CuentaContaGastoDepreConstantesFunciones.SCHEMA+"."+CuentaContaGastoDepreConstantesFunciones.TABLENAME;//+" as "+CuentaContaGastoDepreConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+CuentaContaGastoDepreConstantesFunciones.SCHEMA+"."+CuentaContaGastoDepreConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_cuenta_contable=?,id_gasto_depreciacion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_CUENTACONTAGASTODEPRE_INSERT(?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_CUENTACONTAGASTODEPRE_UPDATE(?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_CUENTACONTAGASTODEPRE_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_CUENTACONTAGASTODEPRE_SELECT(?,?)";
	
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
	
	
	protected CuentaContaGastoDepreDataAccessAdditional cuentacontagastodepreDataAccessAdditional=null;
	
	public CuentaContaGastoDepreDataAccessAdditional getCuentaContaGastoDepreDataAccessAdditional() {
		return this.cuentacontagastodepreDataAccessAdditional;
	}
	
	public void setCuentaContaGastoDepreDataAccessAdditional(CuentaContaGastoDepreDataAccessAdditional cuentacontagastodepreDataAccessAdditional) {
		try {
			this.cuentacontagastodepreDataAccessAdditional=cuentacontagastodepreDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public CuentaContaGastoDepreDataAccess() {
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
		CuentaContaGastoDepreDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		CuentaContaGastoDepreDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		CuentaContaGastoDepreDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setCuentaContaGastoDepreOriginal(CuentaContaGastoDepre cuentacontagastodepre)throws Exception  {
		cuentacontagastodepre.setCuentaContaGastoDepreOriginal((CuentaContaGastoDepre)cuentacontagastodepre.clone());		
	}
	
	public void setCuentaContaGastoDepresOriginal(List<CuentaContaGastoDepre> cuentacontagastodepres)throws Exception  {
		
		for(CuentaContaGastoDepre cuentacontagastodepre:cuentacontagastodepres){
			cuentacontagastodepre.setCuentaContaGastoDepreOriginal((CuentaContaGastoDepre)cuentacontagastodepre.clone());
		}
	}
	
	public static void setCuentaContaGastoDepreOriginalStatic(CuentaContaGastoDepre cuentacontagastodepre)throws Exception  {
		cuentacontagastodepre.setCuentaContaGastoDepreOriginal((CuentaContaGastoDepre)cuentacontagastodepre.clone());		
	}
	
	public static void setCuentaContaGastoDepresOriginalStatic(List<CuentaContaGastoDepre> cuentacontagastodepres)throws Exception  {
		
		for(CuentaContaGastoDepre cuentacontagastodepre:cuentacontagastodepres){
			cuentacontagastodepre.setCuentaContaGastoDepreOriginal((CuentaContaGastoDepre)cuentacontagastodepre.clone());
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
	
	public  CuentaContaGastoDepre getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		CuentaContaGastoDepre entity = new CuentaContaGastoDepre();		
		
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
	
	public  CuentaContaGastoDepre getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		CuentaContaGastoDepre entity = new CuentaContaGastoDepre();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=CuentaContaGastoDepreDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CuentaContaGastoDepreDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//ActivosFijos.CuentaContaGastoDepre.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setCuentaContaGastoDepreOriginal(new CuentaContaGastoDepre());
      	    	entity=super.getEntity("",entity,resultSet,CuentaContaGastoDepreDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityCuentaContaGastoDepre("",entity,resultSet); 
				
				//entity.setCuentaContaGastoDepreOriginal(super.getEntity("",entity.getCuentaContaGastoDepreOriginal(),resultSet,CuentaContaGastoDepreDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCuentaContaGastoDepreOriginal(this.getEntityCuentaContaGastoDepre("",entity.getCuentaContaGastoDepreOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseCuentaContaGastoDepre(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  CuentaContaGastoDepre getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		CuentaContaGastoDepre entity = new CuentaContaGastoDepre();
				
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
	
	public  CuentaContaGastoDepre getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		CuentaContaGastoDepre entity = new CuentaContaGastoDepre();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=CuentaContaGastoDepreDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CuentaContaGastoDepreDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CuentaContaGastoDepreDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//ActivosFijos.CuentaContaGastoDepre.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setCuentaContaGastoDepreOriginal(new CuentaContaGastoDepre());
      	    	entity=super.getEntity("",entity,resultSet,CuentaContaGastoDepreDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityCuentaContaGastoDepre("",entity,resultSet);    
				
				//entity.setCuentaContaGastoDepreOriginal(super.getEntity("",entity.getCuentaContaGastoDepreOriginal(),resultSet,CuentaContaGastoDepreDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCuentaContaGastoDepreOriginal(this.getEntityCuentaContaGastoDepre("",entity.getCuentaContaGastoDepreOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseCuentaContaGastoDepre(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //CuentaContaGastoDepre
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		CuentaContaGastoDepre entity = new CuentaContaGastoDepre();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CuentaContaGastoDepreDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CuentaContaGastoDepreDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CuentaContaGastoDepreDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//ActivosFijos.CuentaContaGastoDepre.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseCuentaContaGastoDepre(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<CuentaContaGastoDepre> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<CuentaContaGastoDepre> entities = new  ArrayList<CuentaContaGastoDepre>();
		CuentaContaGastoDepre entity = new CuentaContaGastoDepre();		  
		
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
	
	public  List<CuentaContaGastoDepre> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<CuentaContaGastoDepre> entities = new  ArrayList<CuentaContaGastoDepre>();
		CuentaContaGastoDepre entity = new CuentaContaGastoDepre();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=CuentaContaGastoDepreDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CuentaContaGastoDepreDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CuentaContaGastoDepreDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CuentaContaGastoDepre();
      	    	entity=super.getEntity("",entity,resultSet,CuentaContaGastoDepreDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCuentaContaGastoDepre("",entity,resultSet);
      	    	
				//entity.setCuentaContaGastoDepreOriginal( new CuentaContaGastoDepre());
      	    	//entity.setCuentaContaGastoDepreOriginal(super.getEntity("",entity.getCuentaContaGastoDepreOriginal(),resultSet,CuentaContaGastoDepreDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCuentaContaGastoDepreOriginal(this.getEntityCuentaContaGastoDepre("",entity.getCuentaContaGastoDepreOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCuentaContaGastoDepres(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCuentaContaGastoDepre(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<CuentaContaGastoDepre> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<CuentaContaGastoDepre> entities = new  ArrayList<CuentaContaGastoDepre>();
		CuentaContaGastoDepre entity = new CuentaContaGastoDepre();		  
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
	
	public  List<CuentaContaGastoDepre> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<CuentaContaGastoDepre> entities = new  ArrayList<CuentaContaGastoDepre>();
		CuentaContaGastoDepre entity = new CuentaContaGastoDepre();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CuentaContaGastoDepre();
				
				if(conMapGenerico) {
					entity.inicializarMapCuentaContaGastoDepre();
					//entity.setMapCuentaContaGastoDepre(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapCuentaContaGastoDepreValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapCuentaContaGastoDepre().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CuentaContaGastoDepreDataAccess.ISWITHSCHEMA);         		
					entity=CuentaContaGastoDepreDataAccess.getEntityCuentaContaGastoDepre("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setCuentaContaGastoDepreOriginal( new CuentaContaGastoDepre());
					////entity.setCuentaContaGastoDepreOriginal(super.getEntity("",entity.getCuentaContaGastoDepreOriginal(),resultSet,CuentaContaGastoDepreDataAccess.ISWITHSCHEMA));         		
					////entity.setCuentaContaGastoDepreOriginal(this.getEntityCuentaContaGastoDepre("",entity.getCuentaContaGastoDepreOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCuentaContaGastoDepres(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCuentaContaGastoDepre(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public CuentaContaGastoDepre getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		CuentaContaGastoDepre entity = new CuentaContaGastoDepre();		  
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
	
	public  CuentaContaGastoDepre getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		CuentaContaGastoDepre entity = new CuentaContaGastoDepre();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CuentaContaGastoDepre();
				
				if(conMapGenerico) {
					entity.inicializarMapCuentaContaGastoDepre();
					//entity.setMapCuentaContaGastoDepre(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapCuentaContaGastoDepreValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapCuentaContaGastoDepre().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CuentaContaGastoDepreDataAccess.ISWITHSCHEMA);         		
					entity=CuentaContaGastoDepreDataAccess.getEntityCuentaContaGastoDepre("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setCuentaContaGastoDepreOriginal( new CuentaContaGastoDepre());
					////entity.setCuentaContaGastoDepreOriginal(super.getEntity("",entity.getCuentaContaGastoDepreOriginal(),resultSet,CuentaContaGastoDepreDataAccess.ISWITHSCHEMA));         		
					////entity.setCuentaContaGastoDepreOriginal(this.getEntityCuentaContaGastoDepre("",entity.getCuentaContaGastoDepreOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseCuentaContaGastoDepre(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCuentaContaGastoDepre(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static CuentaContaGastoDepre getEntityCuentaContaGastoDepre(String strPrefijo,CuentaContaGastoDepre entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = CuentaContaGastoDepre.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = CuentaContaGastoDepre.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					CuentaContaGastoDepreDataAccess.setFieldReflectionCuentaContaGastoDepre(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasCuentaContaGastoDepre=CuentaContaGastoDepreConstantesFunciones.getTodosTiposColumnasCuentaContaGastoDepre();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasCuentaContaGastoDepre) {
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
							field = CuentaContaGastoDepre.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = CuentaContaGastoDepre.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						CuentaContaGastoDepreDataAccess.setFieldReflectionCuentaContaGastoDepre(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionCuentaContaGastoDepre(Field field,String strPrefijo,String sColumn,CuentaContaGastoDepre entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case CuentaContaGastoDepreConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CuentaContaGastoDepreConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CuentaContaGastoDepreConstantesFunciones.IDCUENTACONTABLE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CuentaContaGastoDepreConstantesFunciones.IDGASTODEPRECIACION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<CuentaContaGastoDepre>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<CuentaContaGastoDepre> entities = new  ArrayList<CuentaContaGastoDepre>();
		CuentaContaGastoDepre entity = new CuentaContaGastoDepre();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CuentaContaGastoDepreDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CuentaContaGastoDepreDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CuentaContaGastoDepreDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new CuentaContaGastoDepre();
					entity=super.getEntity("",entity,resultSet,CuentaContaGastoDepreDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityCuentaContaGastoDepre("",entity,resultSet);
					
					//entity.setCuentaContaGastoDepreOriginal( new CuentaContaGastoDepre());
					//entity.setCuentaContaGastoDepreOriginal(super.getEntity("",entity.getCuentaContaGastoDepreOriginal(),resultSet,CuentaContaGastoDepreDataAccess.ISWITHSCHEMA));         		
					//entity.setCuentaContaGastoDepreOriginal(this.getEntityCuentaContaGastoDepre("",entity.getCuentaContaGastoDepreOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseCuentaContaGastoDepres(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCuentaContaGastoDepre(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<CuentaContaGastoDepre>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<CuentaContaGastoDepre> entities = new  ArrayList<CuentaContaGastoDepre>();
		CuentaContaGastoDepre entity = new CuentaContaGastoDepre();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CuentaContaGastoDepreDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CuentaContaGastoDepreDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CuentaContaGastoDepreDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<CuentaContaGastoDepre> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CuentaContaGastoDepre> entities = new  ArrayList<CuentaContaGastoDepre>();
		CuentaContaGastoDepre entity = new CuentaContaGastoDepre();		  
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
	
	public  List<CuentaContaGastoDepre> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CuentaContaGastoDepre> entities = new  ArrayList<CuentaContaGastoDepre>();
		CuentaContaGastoDepre entity = new CuentaContaGastoDepre();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CuentaContaGastoDepre();
      	    	entity=super.getEntity("",entity,resultSet,CuentaContaGastoDepreDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCuentaContaGastoDepre("",entity,resultSet);
      	    	
				//entity.setCuentaContaGastoDepreOriginal( new CuentaContaGastoDepre());
      	    	//entity.setCuentaContaGastoDepreOriginal(super.getEntity("",entity.getCuentaContaGastoDepreOriginal(),resultSet,CuentaContaGastoDepreDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCuentaContaGastoDepreOriginal(this.getEntityCuentaContaGastoDepre("",entity.getCuentaContaGastoDepreOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseCuentaContaGastoDepres(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCuentaContaGastoDepre(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<CuentaContaGastoDepre> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CuentaContaGastoDepre> entities = new  ArrayList<CuentaContaGastoDepre>();
		CuentaContaGastoDepre entity = new CuentaContaGastoDepre();		  
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
	
	public  List<CuentaContaGastoDepre> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CuentaContaGastoDepre> entities = new  ArrayList<CuentaContaGastoDepre>();
		CuentaContaGastoDepre entity = new CuentaContaGastoDepre();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CuentaContaGastoDepre();
      	    	entity=super.getEntity("",entity,resultSet,CuentaContaGastoDepreDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCuentaContaGastoDepre("",entity,resultSet);
      	    	
				//entity.setCuentaContaGastoDepreOriginal( new CuentaContaGastoDepre());
      	    	//entity.setCuentaContaGastoDepreOriginal(super.getEntity("",entity.getCuentaContaGastoDepreOriginal(),resultSet,CuentaContaGastoDepreDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCuentaContaGastoDepreOriginal(this.getEntityCuentaContaGastoDepre("",entity.getCuentaContaGastoDepreOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCuentaContaGastoDepres(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public CuentaContaGastoDepre getEntityCuentaContaGastoDepre(String strPrefijo,CuentaContaGastoDepre entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_cuenta_contable(resultSet.getLong(strPrefijo+CuentaContaGastoDepreConstantesFunciones.IDCUENTACONTABLE));
				entity.setid_gasto_depreciacion(resultSet.getLong(strPrefijo+CuentaContaGastoDepreConstantesFunciones.IDGASTODEPRECIACION));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowCuentaContaGastoDepre(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(CuentaContaGastoDepre entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=CuentaContaGastoDepreDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=CuentaContaGastoDepreDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=CuentaContaGastoDepreDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=CuentaContaGastoDepreDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(CuentaContaGastoDepreConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,CuentaContaGastoDepreDataAccess.TABLENAME,CuentaContaGastoDepreDataAccess.ISWITHSTOREPROCEDURES);
			
			CuentaContaGastoDepreDataAccess.setCuentaContaGastoDepreOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public CuentaContable getCuentaContable(Connexion connexion,CuentaContaGastoDepre relcuentacontagastodepre)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relcuentacontagastodepre.getid_cuenta_contable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public GastoDepreciacion getGastoDepreciacion(Connexion connexion,CuentaContaGastoDepre relcuentacontagastodepre)throws SQLException,Exception {

		GastoDepreciacion gastodepreciacion= new GastoDepreciacion();

		try {
			GastoDepreciacionDataAccess gastodepreciacionDataAccess=new GastoDepreciacionDataAccess();

			gastodepreciacionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			gastodepreciacionDataAccess.setConnexionType(this.connexionType);
			gastodepreciacionDataAccess.setParameterDbType(this.parameterDbType);

			gastodepreciacion=gastodepreciacionDataAccess.getEntity(connexion,relcuentacontagastodepre.getid_gasto_depreciacion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return gastodepreciacion;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,CuentaContaGastoDepre cuentacontagastodepre) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!cuentacontagastodepre.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable.setValue(cuentacontagastodepre.getid_cuenta_contable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_gasto_depreciacion=new ParameterValue<Long>();
					parameterMaintenanceValueid_gasto_depreciacion.setValue(cuentacontagastodepre.getid_gasto_depreciacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_gasto_depreciacion);
					parametersTemp.add(parameterMaintenance);
					
						if(!cuentacontagastodepre.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(cuentacontagastodepre.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(cuentacontagastodepre.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(cuentacontagastodepre.getId());
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
	
	public void setIsNewIsChangedFalseCuentaContaGastoDepre(CuentaContaGastoDepre cuentacontagastodepre)throws Exception  {		
		cuentacontagastodepre.setIsNew(false);
		cuentacontagastodepre.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseCuentaContaGastoDepres(List<CuentaContaGastoDepre> cuentacontagastodepres)throws Exception  {				
		for(CuentaContaGastoDepre cuentacontagastodepre:cuentacontagastodepres) {
			cuentacontagastodepre.setIsNew(false);
			cuentacontagastodepre.setIsChanged(false);
		}
	}
	
	public void generarExportarCuentaContaGastoDepre(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
