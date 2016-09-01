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
import com.bydan.erp.nomina.util.*;//ImpuestoRentaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class ImpuestoRentaDataAccess extends  ImpuestoRentaDataAccessAdditional{ //ImpuestoRentaDataAccessAdditional,DataAccessHelper<ImpuestoRenta>
	//static Logger logger = Logger.getLogger(ImpuestoRentaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="impuesto_renta";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ImpuestoRentaConstantesFunciones.SCHEMA+"."+ImpuestoRentaConstantesFunciones.TABLENAME+"(version_row,id_empresa,desde,hasta,impuesto,porcentaje)values(current_timestamp,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+ImpuestoRentaConstantesFunciones.SCHEMA+"."+ImpuestoRentaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,desde=?,hasta=?,impuesto=?,porcentaje=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ImpuestoRentaConstantesFunciones.SCHEMA+"."+ImpuestoRentaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select impuestorenta from "+ImpuestoRentaConstantesFunciones.SPERSISTENCENAME+" impuestorenta";
	public static String QUERYSELECTNATIVE="select "+ImpuestoRentaConstantesFunciones.SCHEMA+"."+ImpuestoRentaConstantesFunciones.TABLENAME+".id,"+ImpuestoRentaConstantesFunciones.SCHEMA+"."+ImpuestoRentaConstantesFunciones.TABLENAME+".version_row,"+ImpuestoRentaConstantesFunciones.SCHEMA+"."+ImpuestoRentaConstantesFunciones.TABLENAME+".id_empresa,"+ImpuestoRentaConstantesFunciones.SCHEMA+"."+ImpuestoRentaConstantesFunciones.TABLENAME+".desde,"+ImpuestoRentaConstantesFunciones.SCHEMA+"."+ImpuestoRentaConstantesFunciones.TABLENAME+".hasta,"+ImpuestoRentaConstantesFunciones.SCHEMA+"."+ImpuestoRentaConstantesFunciones.TABLENAME+".impuesto,"+ImpuestoRentaConstantesFunciones.SCHEMA+"."+ImpuestoRentaConstantesFunciones.TABLENAME+".porcentaje from "+ImpuestoRentaConstantesFunciones.SCHEMA+"."+ImpuestoRentaConstantesFunciones.TABLENAME;//+" as "+ImpuestoRentaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ImpuestoRentaConstantesFunciones.SCHEMA+"."+ImpuestoRentaConstantesFunciones.TABLENAME+".id,"+ImpuestoRentaConstantesFunciones.SCHEMA+"."+ImpuestoRentaConstantesFunciones.TABLENAME+".version_row from "+ImpuestoRentaConstantesFunciones.SCHEMA+"."+ImpuestoRentaConstantesFunciones.TABLENAME;//+" as "+ImpuestoRentaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ImpuestoRentaConstantesFunciones.SCHEMA+"."+ImpuestoRentaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,desde=?,hasta=?,impuesto=?,porcentaje=?";
	
	public static String STOREPROCEDUREINSERT="call SP_IMPUESTORENTA_INSERT(?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_IMPUESTORENTA_UPDATE(?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_IMPUESTORENTA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_IMPUESTORENTA_SELECT(?,?)";
	
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
	
	
	protected ImpuestoRentaDataAccessAdditional impuestorentaDataAccessAdditional=null;
	
	public ImpuestoRentaDataAccessAdditional getImpuestoRentaDataAccessAdditional() {
		return this.impuestorentaDataAccessAdditional;
	}
	
	public void setImpuestoRentaDataAccessAdditional(ImpuestoRentaDataAccessAdditional impuestorentaDataAccessAdditional) {
		try {
			this.impuestorentaDataAccessAdditional=impuestorentaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ImpuestoRentaDataAccess() {
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
		ImpuestoRentaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ImpuestoRentaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ImpuestoRentaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setImpuestoRentaOriginal(ImpuestoRenta impuestorenta)throws Exception  {
		impuestorenta.setImpuestoRentaOriginal((ImpuestoRenta)impuestorenta.clone());		
	}
	
	public void setImpuestoRentasOriginal(List<ImpuestoRenta> impuestorentas)throws Exception  {
		
		for(ImpuestoRenta impuestorenta:impuestorentas){
			impuestorenta.setImpuestoRentaOriginal((ImpuestoRenta)impuestorenta.clone());
		}
	}
	
	public static void setImpuestoRentaOriginalStatic(ImpuestoRenta impuestorenta)throws Exception  {
		impuestorenta.setImpuestoRentaOriginal((ImpuestoRenta)impuestorenta.clone());		
	}
	
	public static void setImpuestoRentasOriginalStatic(List<ImpuestoRenta> impuestorentas)throws Exception  {
		
		for(ImpuestoRenta impuestorenta:impuestorentas){
			impuestorenta.setImpuestoRentaOriginal((ImpuestoRenta)impuestorenta.clone());
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
	
	public  ImpuestoRenta getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		ImpuestoRenta entity = new ImpuestoRenta();		
		
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
	
	public  ImpuestoRenta getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		ImpuestoRenta entity = new ImpuestoRenta();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ImpuestoRentaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ImpuestoRentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.ImpuestoRenta.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setImpuestoRentaOriginal(new ImpuestoRenta());
      	    	entity=super.getEntity("",entity,resultSet,ImpuestoRentaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityImpuestoRenta("",entity,resultSet); 
				
				//entity.setImpuestoRentaOriginal(super.getEntity("",entity.getImpuestoRentaOriginal(),resultSet,ImpuestoRentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setImpuestoRentaOriginal(this.getEntityImpuestoRenta("",entity.getImpuestoRentaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseImpuestoRenta(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  ImpuestoRenta getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ImpuestoRenta entity = new ImpuestoRenta();
				
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
	
	public  ImpuestoRenta getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ImpuestoRenta entity = new ImpuestoRenta();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ImpuestoRentaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ImpuestoRentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ImpuestoRentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.ImpuestoRenta.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setImpuestoRentaOriginal(new ImpuestoRenta());
      	    	entity=super.getEntity("",entity,resultSet,ImpuestoRentaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityImpuestoRenta("",entity,resultSet);    
				
				//entity.setImpuestoRentaOriginal(super.getEntity("",entity.getImpuestoRentaOriginal(),resultSet,ImpuestoRentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setImpuestoRentaOriginal(this.getEntityImpuestoRenta("",entity.getImpuestoRentaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseImpuestoRenta(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //ImpuestoRenta
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		ImpuestoRenta entity = new ImpuestoRenta();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ImpuestoRentaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ImpuestoRentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ImpuestoRentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.ImpuestoRenta.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseImpuestoRenta(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<ImpuestoRenta> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ImpuestoRenta> entities = new  ArrayList<ImpuestoRenta>();
		ImpuestoRenta entity = new ImpuestoRenta();		  
		
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
	
	public  List<ImpuestoRenta> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ImpuestoRenta> entities = new  ArrayList<ImpuestoRenta>();
		ImpuestoRenta entity = new ImpuestoRenta();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ImpuestoRentaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ImpuestoRentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ImpuestoRentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ImpuestoRenta();
      	    	entity=super.getEntity("",entity,resultSet,ImpuestoRentaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityImpuestoRenta("",entity,resultSet);
      	    	
				//entity.setImpuestoRentaOriginal( new ImpuestoRenta());
      	    	//entity.setImpuestoRentaOriginal(super.getEntity("",entity.getImpuestoRentaOriginal(),resultSet,ImpuestoRentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setImpuestoRentaOriginal(this.getEntityImpuestoRenta("",entity.getImpuestoRentaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseImpuestoRentas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarImpuestoRenta(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ImpuestoRenta> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ImpuestoRenta> entities = new  ArrayList<ImpuestoRenta>();
		ImpuestoRenta entity = new ImpuestoRenta();		  
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
	
	public  List<ImpuestoRenta> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ImpuestoRenta> entities = new  ArrayList<ImpuestoRenta>();
		ImpuestoRenta entity = new ImpuestoRenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ImpuestoRenta();
				
				if(conMapGenerico) {
					entity.inicializarMapImpuestoRenta();
					//entity.setMapImpuestoRenta(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapImpuestoRentaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapImpuestoRenta().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ImpuestoRentaDataAccess.ISWITHSCHEMA);         		
					entity=ImpuestoRentaDataAccess.getEntityImpuestoRenta("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setImpuestoRentaOriginal( new ImpuestoRenta());
					////entity.setImpuestoRentaOriginal(super.getEntity("",entity.getImpuestoRentaOriginal(),resultSet,ImpuestoRentaDataAccess.ISWITHSCHEMA));         		
					////entity.setImpuestoRentaOriginal(this.getEntityImpuestoRenta("",entity.getImpuestoRentaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseImpuestoRentas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarImpuestoRenta(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public ImpuestoRenta getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ImpuestoRenta entity = new ImpuestoRenta();		  
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
	
	public  ImpuestoRenta getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ImpuestoRenta entity = new ImpuestoRenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ImpuestoRenta();
				
				if(conMapGenerico) {
					entity.inicializarMapImpuestoRenta();
					//entity.setMapImpuestoRenta(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapImpuestoRentaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapImpuestoRenta().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ImpuestoRentaDataAccess.ISWITHSCHEMA);         		
					entity=ImpuestoRentaDataAccess.getEntityImpuestoRenta("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setImpuestoRentaOriginal( new ImpuestoRenta());
					////entity.setImpuestoRentaOriginal(super.getEntity("",entity.getImpuestoRentaOriginal(),resultSet,ImpuestoRentaDataAccess.ISWITHSCHEMA));         		
					////entity.setImpuestoRentaOriginal(this.getEntityImpuestoRenta("",entity.getImpuestoRentaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseImpuestoRenta(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarImpuestoRenta(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ImpuestoRenta getEntityImpuestoRenta(String strPrefijo,ImpuestoRenta entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = ImpuestoRenta.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = ImpuestoRenta.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ImpuestoRentaDataAccess.setFieldReflectionImpuestoRenta(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasImpuestoRenta=ImpuestoRentaConstantesFunciones.getTodosTiposColumnasImpuestoRenta();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasImpuestoRenta) {
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
							field = ImpuestoRenta.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = ImpuestoRenta.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ImpuestoRentaDataAccess.setFieldReflectionImpuestoRenta(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionImpuestoRenta(Field field,String strPrefijo,String sColumn,ImpuestoRenta entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ImpuestoRentaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ImpuestoRentaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ImpuestoRentaConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ImpuestoRentaConstantesFunciones.DESDE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ImpuestoRentaConstantesFunciones.HASTA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ImpuestoRentaConstantesFunciones.IMPUESTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ImpuestoRentaConstantesFunciones.PORCENTAJE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ImpuestoRenta>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<ImpuestoRenta> entities = new  ArrayList<ImpuestoRenta>();
		ImpuestoRenta entity = new ImpuestoRenta();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ImpuestoRentaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ImpuestoRentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ImpuestoRentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new ImpuestoRenta();
					entity=super.getEntity("",entity,resultSet,ImpuestoRentaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityImpuestoRenta("",entity,resultSet);
					
					//entity.setImpuestoRentaOriginal( new ImpuestoRenta());
					//entity.setImpuestoRentaOriginal(super.getEntity("",entity.getImpuestoRentaOriginal(),resultSet,ImpuestoRentaDataAccess.ISWITHSCHEMA));         		
					//entity.setImpuestoRentaOriginal(this.getEntityImpuestoRenta("",entity.getImpuestoRentaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseImpuestoRentas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarImpuestoRenta(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ImpuestoRenta>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<ImpuestoRenta> entities = new  ArrayList<ImpuestoRenta>();
		ImpuestoRenta entity = new ImpuestoRenta();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ImpuestoRentaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ImpuestoRentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ImpuestoRentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<ImpuestoRenta> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ImpuestoRenta> entities = new  ArrayList<ImpuestoRenta>();
		ImpuestoRenta entity = new ImpuestoRenta();		  
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
	
	public  List<ImpuestoRenta> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ImpuestoRenta> entities = new  ArrayList<ImpuestoRenta>();
		ImpuestoRenta entity = new ImpuestoRenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ImpuestoRenta();
      	    	entity=super.getEntity("",entity,resultSet,ImpuestoRentaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityImpuestoRenta("",entity,resultSet);
      	    	
				//entity.setImpuestoRentaOriginal( new ImpuestoRenta());
      	    	//entity.setImpuestoRentaOriginal(super.getEntity("",entity.getImpuestoRentaOriginal(),resultSet,ImpuestoRentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setImpuestoRentaOriginal(this.getEntityImpuestoRenta("",entity.getImpuestoRentaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseImpuestoRentas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarImpuestoRenta(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ImpuestoRenta> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ImpuestoRenta> entities = new  ArrayList<ImpuestoRenta>();
		ImpuestoRenta entity = new ImpuestoRenta();		  
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
	
	public  List<ImpuestoRenta> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ImpuestoRenta> entities = new  ArrayList<ImpuestoRenta>();
		ImpuestoRenta entity = new ImpuestoRenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ImpuestoRenta();
      	    	entity=super.getEntity("",entity,resultSet,ImpuestoRentaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityImpuestoRenta("",entity,resultSet);
      	    	
				//entity.setImpuestoRentaOriginal( new ImpuestoRenta());
      	    	//entity.setImpuestoRentaOriginal(super.getEntity("",entity.getImpuestoRentaOriginal(),resultSet,ImpuestoRentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setImpuestoRentaOriginal(this.getEntityImpuestoRenta("",entity.getImpuestoRentaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseImpuestoRentas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public ImpuestoRenta getEntityImpuestoRenta(String strPrefijo,ImpuestoRenta entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+ImpuestoRentaConstantesFunciones.IDEMPRESA));
				entity.setdesde(resultSet.getDouble(strPrefijo+ImpuestoRentaConstantesFunciones.DESDE));
				entity.sethasta(resultSet.getDouble(strPrefijo+ImpuestoRentaConstantesFunciones.HASTA));
				entity.setimpuesto(resultSet.getDouble(strPrefijo+ImpuestoRentaConstantesFunciones.IMPUESTO));
				entity.setporcentaje(resultSet.getDouble(strPrefijo+ImpuestoRentaConstantesFunciones.PORCENTAJE));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowImpuestoRenta(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(ImpuestoRenta entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ImpuestoRentaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ImpuestoRentaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ImpuestoRentaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ImpuestoRentaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ImpuestoRentaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ImpuestoRentaDataAccess.TABLENAME,ImpuestoRentaDataAccess.ISWITHSTOREPROCEDURES);
			
			ImpuestoRentaDataAccess.setImpuestoRentaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,ImpuestoRenta relimpuestorenta)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relimpuestorenta.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,ImpuestoRenta impuestorenta) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!impuestorenta.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(impuestorenta.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedesde=new ParameterValue<Double>();
					parameterMaintenanceValuedesde.setValue(impuestorenta.getdesde());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedesde);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuehasta=new ParameterValue<Double>();
					parameterMaintenanceValuehasta.setValue(impuestorenta.gethasta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuehasta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueimpuesto=new ParameterValue<Double>();
					parameterMaintenanceValueimpuesto.setValue(impuestorenta.getimpuesto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueimpuesto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcentaje=new ParameterValue<Double>();
					parameterMaintenanceValueporcentaje.setValue(impuestorenta.getporcentaje());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcentaje);
					parametersTemp.add(parameterMaintenance);
					
						if(!impuestorenta.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(impuestorenta.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(impuestorenta.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(impuestorenta.getId());
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
	
	public void setIsNewIsChangedFalseImpuestoRenta(ImpuestoRenta impuestorenta)throws Exception  {		
		impuestorenta.setIsNew(false);
		impuestorenta.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseImpuestoRentas(List<ImpuestoRenta> impuestorentas)throws Exception  {				
		for(ImpuestoRenta impuestorenta:impuestorentas) {
			impuestorenta.setIsNew(false);
			impuestorenta.setIsChanged(false);
		}
	}
	
	public void generarExportarImpuestoRenta(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
