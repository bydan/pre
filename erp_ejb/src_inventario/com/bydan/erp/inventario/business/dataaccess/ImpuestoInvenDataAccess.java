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
import com.bydan.erp.inventario.util.*;//ImpuestoInvenConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class ImpuestoInvenDataAccess extends  ImpuestoInvenDataAccessAdditional{ //ImpuestoInvenDataAccessAdditional,DataAccessHelper<ImpuestoInven>
	//static Logger logger = Logger.getLogger(ImpuestoInvenDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="impuesto_inven";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ImpuestoInvenConstantesFunciones.SCHEMA+"."+ImpuestoInvenConstantesFunciones.TABLENAME+"(version_row,id_empresa,nombre)values(current_timestamp,?,?)";
	public static String QUERYUPDATE="update "+ImpuestoInvenConstantesFunciones.SCHEMA+"."+ImpuestoInvenConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ImpuestoInvenConstantesFunciones.SCHEMA+"."+ImpuestoInvenConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select impuestoinven from "+ImpuestoInvenConstantesFunciones.SPERSISTENCENAME+" impuestoinven";
	public static String QUERYSELECTNATIVE="select "+ImpuestoInvenConstantesFunciones.SCHEMA+"."+ImpuestoInvenConstantesFunciones.TABLENAME+".id,"+ImpuestoInvenConstantesFunciones.SCHEMA+"."+ImpuestoInvenConstantesFunciones.TABLENAME+".version_row,"+ImpuestoInvenConstantesFunciones.SCHEMA+"."+ImpuestoInvenConstantesFunciones.TABLENAME+".id_empresa,"+ImpuestoInvenConstantesFunciones.SCHEMA+"."+ImpuestoInvenConstantesFunciones.TABLENAME+".nombre from "+ImpuestoInvenConstantesFunciones.SCHEMA+"."+ImpuestoInvenConstantesFunciones.TABLENAME;//+" as "+ImpuestoInvenConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ImpuestoInvenConstantesFunciones.SCHEMA+"."+ImpuestoInvenConstantesFunciones.TABLENAME+".id,"+ImpuestoInvenConstantesFunciones.SCHEMA+"."+ImpuestoInvenConstantesFunciones.TABLENAME+".version_row,"+ImpuestoInvenConstantesFunciones.SCHEMA+"."+ImpuestoInvenConstantesFunciones.TABLENAME+".nombre from "+ImpuestoInvenConstantesFunciones.SCHEMA+"."+ImpuestoInvenConstantesFunciones.TABLENAME;//+" as "+ImpuestoInvenConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ImpuestoInvenConstantesFunciones.SCHEMA+"."+ImpuestoInvenConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_IMPUESTOINVEN_INSERT(?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_IMPUESTOINVEN_UPDATE(?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_IMPUESTOINVEN_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_IMPUESTOINVEN_SELECT(?,?)";
	
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
	
	
	protected ImpuestoInvenDataAccessAdditional impuestoinvenDataAccessAdditional=null;
	
	public ImpuestoInvenDataAccessAdditional getImpuestoInvenDataAccessAdditional() {
		return this.impuestoinvenDataAccessAdditional;
	}
	
	public void setImpuestoInvenDataAccessAdditional(ImpuestoInvenDataAccessAdditional impuestoinvenDataAccessAdditional) {
		try {
			this.impuestoinvenDataAccessAdditional=impuestoinvenDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ImpuestoInvenDataAccess() {
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
		ImpuestoInvenDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ImpuestoInvenDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ImpuestoInvenDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setImpuestoInvenOriginal(ImpuestoInven impuestoinven)throws Exception  {
		impuestoinven.setImpuestoInvenOriginal((ImpuestoInven)impuestoinven.clone());		
	}
	
	public void setImpuestoInvensOriginal(List<ImpuestoInven> impuestoinvens)throws Exception  {
		
		for(ImpuestoInven impuestoinven:impuestoinvens){
			impuestoinven.setImpuestoInvenOriginal((ImpuestoInven)impuestoinven.clone());
		}
	}
	
	public static void setImpuestoInvenOriginalStatic(ImpuestoInven impuestoinven)throws Exception  {
		impuestoinven.setImpuestoInvenOriginal((ImpuestoInven)impuestoinven.clone());		
	}
	
	public static void setImpuestoInvensOriginalStatic(List<ImpuestoInven> impuestoinvens)throws Exception  {
		
		for(ImpuestoInven impuestoinven:impuestoinvens){
			impuestoinven.setImpuestoInvenOriginal((ImpuestoInven)impuestoinven.clone());
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
	
	public  ImpuestoInven getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		ImpuestoInven entity = new ImpuestoInven();		
		
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
	
	public  ImpuestoInven getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		ImpuestoInven entity = new ImpuestoInven();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ImpuestoInvenDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ImpuestoInvenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.ImpuestoInven.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setImpuestoInvenOriginal(new ImpuestoInven());
      	    	entity=super.getEntity("",entity,resultSet,ImpuestoInvenDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityImpuestoInven("",entity,resultSet); 
				
				//entity.setImpuestoInvenOriginal(super.getEntity("",entity.getImpuestoInvenOriginal(),resultSet,ImpuestoInvenDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setImpuestoInvenOriginal(this.getEntityImpuestoInven("",entity.getImpuestoInvenOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseImpuestoInven(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  ImpuestoInven getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ImpuestoInven entity = new ImpuestoInven();
				
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
	
	public  ImpuestoInven getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ImpuestoInven entity = new ImpuestoInven();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ImpuestoInvenDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ImpuestoInvenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ImpuestoInvenDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.ImpuestoInven.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setImpuestoInvenOriginal(new ImpuestoInven());
      	    	entity=super.getEntity("",entity,resultSet,ImpuestoInvenDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityImpuestoInven("",entity,resultSet);    
				
				//entity.setImpuestoInvenOriginal(super.getEntity("",entity.getImpuestoInvenOriginal(),resultSet,ImpuestoInvenDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setImpuestoInvenOriginal(this.getEntityImpuestoInven("",entity.getImpuestoInvenOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseImpuestoInven(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //ImpuestoInven
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		ImpuestoInven entity = new ImpuestoInven();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ImpuestoInvenDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ImpuestoInvenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ImpuestoInvenDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.ImpuestoInven.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseImpuestoInven(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<ImpuestoInven> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ImpuestoInven> entities = new  ArrayList<ImpuestoInven>();
		ImpuestoInven entity = new ImpuestoInven();		  
		
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
	
	public  List<ImpuestoInven> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ImpuestoInven> entities = new  ArrayList<ImpuestoInven>();
		ImpuestoInven entity = new ImpuestoInven();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ImpuestoInvenDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ImpuestoInvenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ImpuestoInvenDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ImpuestoInven();
      	    	entity=super.getEntity("",entity,resultSet,ImpuestoInvenDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityImpuestoInven("",entity,resultSet);
      	    	
				//entity.setImpuestoInvenOriginal( new ImpuestoInven());
      	    	//entity.setImpuestoInvenOriginal(super.getEntity("",entity.getImpuestoInvenOriginal(),resultSet,ImpuestoInvenDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setImpuestoInvenOriginal(this.getEntityImpuestoInven("",entity.getImpuestoInvenOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseImpuestoInvens(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarImpuestoInven(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ImpuestoInven> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ImpuestoInven> entities = new  ArrayList<ImpuestoInven>();
		ImpuestoInven entity = new ImpuestoInven();		  
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
	
	public  List<ImpuestoInven> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ImpuestoInven> entities = new  ArrayList<ImpuestoInven>();
		ImpuestoInven entity = new ImpuestoInven();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ImpuestoInven();
				
				if(conMapGenerico) {
					entity.inicializarMapImpuestoInven();
					//entity.setMapImpuestoInven(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapImpuestoInvenValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapImpuestoInven().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ImpuestoInvenDataAccess.ISWITHSCHEMA);         		
					entity=ImpuestoInvenDataAccess.getEntityImpuestoInven("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setImpuestoInvenOriginal( new ImpuestoInven());
					////entity.setImpuestoInvenOriginal(super.getEntity("",entity.getImpuestoInvenOriginal(),resultSet,ImpuestoInvenDataAccess.ISWITHSCHEMA));         		
					////entity.setImpuestoInvenOriginal(this.getEntityImpuestoInven("",entity.getImpuestoInvenOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseImpuestoInvens(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarImpuestoInven(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public ImpuestoInven getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ImpuestoInven entity = new ImpuestoInven();		  
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
	
	public  ImpuestoInven getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ImpuestoInven entity = new ImpuestoInven();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ImpuestoInven();
				
				if(conMapGenerico) {
					entity.inicializarMapImpuestoInven();
					//entity.setMapImpuestoInven(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapImpuestoInvenValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapImpuestoInven().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ImpuestoInvenDataAccess.ISWITHSCHEMA);         		
					entity=ImpuestoInvenDataAccess.getEntityImpuestoInven("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setImpuestoInvenOriginal( new ImpuestoInven());
					////entity.setImpuestoInvenOriginal(super.getEntity("",entity.getImpuestoInvenOriginal(),resultSet,ImpuestoInvenDataAccess.ISWITHSCHEMA));         		
					////entity.setImpuestoInvenOriginal(this.getEntityImpuestoInven("",entity.getImpuestoInvenOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseImpuestoInven(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarImpuestoInven(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ImpuestoInven getEntityImpuestoInven(String strPrefijo,ImpuestoInven entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = ImpuestoInven.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = ImpuestoInven.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ImpuestoInvenDataAccess.setFieldReflectionImpuestoInven(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasImpuestoInven=ImpuestoInvenConstantesFunciones.getTodosTiposColumnasImpuestoInven();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasImpuestoInven) {
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
							field = ImpuestoInven.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = ImpuestoInven.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ImpuestoInvenDataAccess.setFieldReflectionImpuestoInven(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionImpuestoInven(Field field,String strPrefijo,String sColumn,ImpuestoInven entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ImpuestoInvenConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ImpuestoInvenConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ImpuestoInvenConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ImpuestoInvenConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ImpuestoInven>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<ImpuestoInven> entities = new  ArrayList<ImpuestoInven>();
		ImpuestoInven entity = new ImpuestoInven();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ImpuestoInvenDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ImpuestoInvenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ImpuestoInvenDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new ImpuestoInven();
					entity=super.getEntity("",entity,resultSet,ImpuestoInvenDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityImpuestoInven("",entity,resultSet);
					
					//entity.setImpuestoInvenOriginal( new ImpuestoInven());
					//entity.setImpuestoInvenOriginal(super.getEntity("",entity.getImpuestoInvenOriginal(),resultSet,ImpuestoInvenDataAccess.ISWITHSCHEMA));         		
					//entity.setImpuestoInvenOriginal(this.getEntityImpuestoInven("",entity.getImpuestoInvenOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseImpuestoInvens(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarImpuestoInven(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ImpuestoInven>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<ImpuestoInven> entities = new  ArrayList<ImpuestoInven>();
		ImpuestoInven entity = new ImpuestoInven();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ImpuestoInvenDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ImpuestoInvenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ImpuestoInvenDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<ImpuestoInven> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ImpuestoInven> entities = new  ArrayList<ImpuestoInven>();
		ImpuestoInven entity = new ImpuestoInven();		  
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
	
	public  List<ImpuestoInven> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ImpuestoInven> entities = new  ArrayList<ImpuestoInven>();
		ImpuestoInven entity = new ImpuestoInven();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ImpuestoInven();
      	    	entity=super.getEntity("",entity,resultSet,ImpuestoInvenDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityImpuestoInven("",entity,resultSet);
      	    	
				//entity.setImpuestoInvenOriginal( new ImpuestoInven());
      	    	//entity.setImpuestoInvenOriginal(super.getEntity("",entity.getImpuestoInvenOriginal(),resultSet,ImpuestoInvenDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setImpuestoInvenOriginal(this.getEntityImpuestoInven("",entity.getImpuestoInvenOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseImpuestoInvens(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarImpuestoInven(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ImpuestoInven> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ImpuestoInven> entities = new  ArrayList<ImpuestoInven>();
		ImpuestoInven entity = new ImpuestoInven();		  
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
	
	public  List<ImpuestoInven> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ImpuestoInven> entities = new  ArrayList<ImpuestoInven>();
		ImpuestoInven entity = new ImpuestoInven();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ImpuestoInven();
      	    	entity=super.getEntity("",entity,resultSet,ImpuestoInvenDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityImpuestoInven("",entity,resultSet);
      	    	
				//entity.setImpuestoInvenOriginal( new ImpuestoInven());
      	    	//entity.setImpuestoInvenOriginal(super.getEntity("",entity.getImpuestoInvenOriginal(),resultSet,ImpuestoInvenDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setImpuestoInvenOriginal(this.getEntityImpuestoInven("",entity.getImpuestoInvenOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseImpuestoInvens(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public ImpuestoInven getEntityImpuestoInven(String strPrefijo,ImpuestoInven entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+ImpuestoInvenConstantesFunciones.IDEMPRESA));
				entity.setnombre(resultSet.getString(strPrefijo+ImpuestoInvenConstantesFunciones.NOMBRE));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+ImpuestoInvenConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowImpuestoInven(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(ImpuestoInven entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ImpuestoInvenDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ImpuestoInvenDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ImpuestoInvenDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ImpuestoInvenDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ImpuestoInvenConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ImpuestoInvenDataAccess.TABLENAME,ImpuestoInvenDataAccess.ISWITHSTOREPROCEDURES);
			
			ImpuestoInvenDataAccess.setImpuestoInvenOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,ImpuestoInven relimpuestoinven)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relimpuestoinven.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}


		
		public List<ProductoImpuesto> getProductoImpuestos(Connexion connexion,ImpuestoInven impuestoinven)throws SQLException,Exception {

		List<ProductoImpuesto> productoimpuestos= new ArrayList<ProductoImpuesto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ImpuestoInvenConstantesFunciones.SCHEMA+".impuesto_inven ON "+ProductoImpuestoConstantesFunciones.SCHEMA+".producto_impuesto.id_impuesto_inven="+ImpuestoInvenConstantesFunciones.SCHEMA+".impuesto_inven.id WHERE "+ImpuestoInvenConstantesFunciones.SCHEMA+".impuesto_inven.id="+String.valueOf(impuestoinven.getId());
			} else {
				sQuery=" INNER JOIN productoimpuesto.ImpuestoInven WHERE productoimpuesto.ImpuestoInven.id="+String.valueOf(impuestoinven.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ProductoImpuestoDataAccess productoimpuestoDataAccess=new ProductoImpuestoDataAccess();

			productoimpuestoDataAccess.setConnexionType(this.connexionType);
			productoimpuestoDataAccess.setParameterDbType(this.parameterDbType);
			productoimpuestos=productoimpuestoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return productoimpuestos;

	}

	public List<DetalleImpuestoInven> getDetalleImpuestoInvens(Connexion connexion,ImpuestoInven impuestoinven)throws SQLException,Exception {

		List<DetalleImpuestoInven> detalleimpuestoinvens= new ArrayList<DetalleImpuestoInven>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ImpuestoInvenConstantesFunciones.SCHEMA+".impuesto_inven ON "+DetalleImpuestoInvenConstantesFunciones.SCHEMA+".detalle_impuesto_inven.id_impuesto_inven="+ImpuestoInvenConstantesFunciones.SCHEMA+".impuesto_inven.id WHERE "+ImpuestoInvenConstantesFunciones.SCHEMA+".impuesto_inven.id="+String.valueOf(impuestoinven.getId());
			} else {
				sQuery=" INNER JOIN detalleimpuestoinven.ImpuestoInven WHERE detalleimpuestoinven.ImpuestoInven.id="+String.valueOf(impuestoinven.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleImpuestoInvenDataAccess detalleimpuestoinvenDataAccess=new DetalleImpuestoInvenDataAccess();

			detalleimpuestoinvenDataAccess.setConnexionType(this.connexionType);
			detalleimpuestoinvenDataAccess.setParameterDbType(this.parameterDbType);
			detalleimpuestoinvens=detalleimpuestoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalleimpuestoinvens;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,ImpuestoInven impuestoinven) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!impuestoinven.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(impuestoinven.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(impuestoinven.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!impuestoinven.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(impuestoinven.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(impuestoinven.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(impuestoinven.getId());
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
	
	public void setIsNewIsChangedFalseImpuestoInven(ImpuestoInven impuestoinven)throws Exception  {		
		impuestoinven.setIsNew(false);
		impuestoinven.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseImpuestoInvens(List<ImpuestoInven> impuestoinvens)throws Exception  {				
		for(ImpuestoInven impuestoinven:impuestoinvens) {
			impuestoinven.setIsNew(false);
			impuestoinven.setIsChanged(false);
		}
	}
	
	public void generarExportarImpuestoInven(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
