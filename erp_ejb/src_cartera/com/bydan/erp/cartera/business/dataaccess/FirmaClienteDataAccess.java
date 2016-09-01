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
package com.bydan.erp.cartera.business.dataaccess;

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

import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.cartera.util.*;//FirmaClienteConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class FirmaClienteDataAccess extends  FirmaClienteDataAccessAdditional{ //FirmaClienteDataAccessAdditional,DataAccessHelper<FirmaCliente>
	//static Logger logger = Logger.getLogger(FirmaClienteDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="firma_cliente";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+FirmaClienteConstantesFunciones.SCHEMA+"."+FirmaClienteConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_cliente,id_tipo_imagen,firma,path_firma)values(current_timestamp,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+FirmaClienteConstantesFunciones.SCHEMA+"."+FirmaClienteConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_cliente=?,id_tipo_imagen=?,firma=?,path_firma=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+FirmaClienteConstantesFunciones.SCHEMA+"."+FirmaClienteConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select firmacliente from "+FirmaClienteConstantesFunciones.SPERSISTENCENAME+" firmacliente";
	public static String QUERYSELECTNATIVE="select "+FirmaClienteConstantesFunciones.SCHEMA+"."+FirmaClienteConstantesFunciones.TABLENAME+".id,"+FirmaClienteConstantesFunciones.SCHEMA+"."+FirmaClienteConstantesFunciones.TABLENAME+".version_row,"+FirmaClienteConstantesFunciones.SCHEMA+"."+FirmaClienteConstantesFunciones.TABLENAME+".id_empresa,"+FirmaClienteConstantesFunciones.SCHEMA+"."+FirmaClienteConstantesFunciones.TABLENAME+".id_cliente,"+FirmaClienteConstantesFunciones.SCHEMA+"."+FirmaClienteConstantesFunciones.TABLENAME+".id_tipo_imagen,"+FirmaClienteConstantesFunciones.SCHEMA+"."+FirmaClienteConstantesFunciones.TABLENAME+".firma,"+FirmaClienteConstantesFunciones.SCHEMA+"."+FirmaClienteConstantesFunciones.TABLENAME+".path_firma from "+FirmaClienteConstantesFunciones.SCHEMA+"."+FirmaClienteConstantesFunciones.TABLENAME;//+" as "+FirmaClienteConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+FirmaClienteConstantesFunciones.SCHEMA+"."+FirmaClienteConstantesFunciones.TABLENAME+".id,"+FirmaClienteConstantesFunciones.SCHEMA+"."+FirmaClienteConstantesFunciones.TABLENAME+".version_row from "+FirmaClienteConstantesFunciones.SCHEMA+"."+FirmaClienteConstantesFunciones.TABLENAME;//+" as "+FirmaClienteConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+FirmaClienteConstantesFunciones.SCHEMA+"."+FirmaClienteConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_cliente=?,id_tipo_imagen=?,firma=?,path_firma=?";
	
	public static String STOREPROCEDUREINSERT="call SP_FIRMACLIENTE_INSERT(?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_FIRMACLIENTE_UPDATE(?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_FIRMACLIENTE_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_FIRMACLIENTE_SELECT(?,?)";
	
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
	
	
	protected FirmaClienteDataAccessAdditional firmaclienteDataAccessAdditional=null;
	
	public FirmaClienteDataAccessAdditional getFirmaClienteDataAccessAdditional() {
		return this.firmaclienteDataAccessAdditional;
	}
	
	public void setFirmaClienteDataAccessAdditional(FirmaClienteDataAccessAdditional firmaclienteDataAccessAdditional) {
		try {
			this.firmaclienteDataAccessAdditional=firmaclienteDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public FirmaClienteDataAccess() {
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
		FirmaClienteDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		FirmaClienteDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		FirmaClienteDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setFirmaClienteOriginal(FirmaCliente firmacliente)throws Exception  {
		firmacliente.setFirmaClienteOriginal((FirmaCliente)firmacliente.clone());		
	}
	
	public void setFirmaClientesOriginal(List<FirmaCliente> firmaclientes)throws Exception  {
		
		for(FirmaCliente firmacliente:firmaclientes){
			firmacliente.setFirmaClienteOriginal((FirmaCliente)firmacliente.clone());
		}
	}
	
	public static void setFirmaClienteOriginalStatic(FirmaCliente firmacliente)throws Exception  {
		firmacliente.setFirmaClienteOriginal((FirmaCliente)firmacliente.clone());		
	}
	
	public static void setFirmaClientesOriginalStatic(List<FirmaCliente> firmaclientes)throws Exception  {
		
		for(FirmaCliente firmacliente:firmaclientes){
			firmacliente.setFirmaClienteOriginal((FirmaCliente)firmacliente.clone());
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
	
	public  FirmaCliente getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		FirmaCliente entity = new FirmaCliente();		
		
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
	
	public  FirmaCliente getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		FirmaCliente entity = new FirmaCliente();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=FirmaClienteDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=FirmaClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Cartera.FirmaCliente.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setFirmaClienteOriginal(new FirmaCliente());
      	    	entity=super.getEntity("",entity,resultSet,FirmaClienteDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityFirmaCliente("",entity,resultSet); 
				
				//entity.setFirmaClienteOriginal(super.getEntity("",entity.getFirmaClienteOriginal(),resultSet,FirmaClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFirmaClienteOriginal(this.getEntityFirmaCliente("",entity.getFirmaClienteOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseFirmaCliente(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  FirmaCliente getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		FirmaCliente entity = new FirmaCliente();
				
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
	
	public  FirmaCliente getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		FirmaCliente entity = new FirmaCliente();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=FirmaClienteDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=FirmaClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FirmaClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.FirmaCliente.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setFirmaClienteOriginal(new FirmaCliente());
      	    	entity=super.getEntity("",entity,resultSet,FirmaClienteDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityFirmaCliente("",entity,resultSet);    
				
				//entity.setFirmaClienteOriginal(super.getEntity("",entity.getFirmaClienteOriginal(),resultSet,FirmaClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFirmaClienteOriginal(this.getEntityFirmaCliente("",entity.getFirmaClienteOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseFirmaCliente(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //FirmaCliente
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		FirmaCliente entity = new FirmaCliente();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=FirmaClienteDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=FirmaClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FirmaClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.FirmaCliente.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseFirmaCliente(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<FirmaCliente> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<FirmaCliente> entities = new  ArrayList<FirmaCliente>();
		FirmaCliente entity = new FirmaCliente();		  
		
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
	
	public  List<FirmaCliente> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<FirmaCliente> entities = new  ArrayList<FirmaCliente>();
		FirmaCliente entity = new FirmaCliente();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=FirmaClienteDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=FirmaClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FirmaClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FirmaCliente();
      	    	entity=super.getEntity("",entity,resultSet,FirmaClienteDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityFirmaCliente("",entity,resultSet);
      	    	
				//entity.setFirmaClienteOriginal( new FirmaCliente());
      	    	//entity.setFirmaClienteOriginal(super.getEntity("",entity.getFirmaClienteOriginal(),resultSet,FirmaClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFirmaClienteOriginal(this.getEntityFirmaCliente("",entity.getFirmaClienteOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseFirmaClientes(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFirmaCliente(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<FirmaCliente> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<FirmaCliente> entities = new  ArrayList<FirmaCliente>();
		FirmaCliente entity = new FirmaCliente();		  
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
	
	public  List<FirmaCliente> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<FirmaCliente> entities = new  ArrayList<FirmaCliente>();
		FirmaCliente entity = new FirmaCliente();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FirmaCliente();
				
				if(conMapGenerico) {
					entity.inicializarMapFirmaCliente();
					//entity.setMapFirmaCliente(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapFirmaClienteValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapFirmaCliente().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,FirmaClienteDataAccess.ISWITHSCHEMA);         		
					entity=FirmaClienteDataAccess.getEntityFirmaCliente("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setFirmaClienteOriginal( new FirmaCliente());
					////entity.setFirmaClienteOriginal(super.getEntity("",entity.getFirmaClienteOriginal(),resultSet,FirmaClienteDataAccess.ISWITHSCHEMA));         		
					////entity.setFirmaClienteOriginal(this.getEntityFirmaCliente("",entity.getFirmaClienteOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseFirmaClientes(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFirmaCliente(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public FirmaCliente getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		FirmaCliente entity = new FirmaCliente();		  
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
	
	public  FirmaCliente getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		FirmaCliente entity = new FirmaCliente();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FirmaCliente();
				
				if(conMapGenerico) {
					entity.inicializarMapFirmaCliente();
					//entity.setMapFirmaCliente(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapFirmaClienteValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapFirmaCliente().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,FirmaClienteDataAccess.ISWITHSCHEMA);         		
					entity=FirmaClienteDataAccess.getEntityFirmaCliente("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setFirmaClienteOriginal( new FirmaCliente());
					////entity.setFirmaClienteOriginal(super.getEntity("",entity.getFirmaClienteOriginal(),resultSet,FirmaClienteDataAccess.ISWITHSCHEMA));         		
					////entity.setFirmaClienteOriginal(this.getEntityFirmaCliente("",entity.getFirmaClienteOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseFirmaCliente(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFirmaCliente(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static FirmaCliente getEntityFirmaCliente(String strPrefijo,FirmaCliente entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = FirmaCliente.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = FirmaCliente.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					FirmaClienteDataAccess.setFieldReflectionFirmaCliente(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasFirmaCliente=FirmaClienteConstantesFunciones.getTodosTiposColumnasFirmaCliente();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasFirmaCliente) {
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
							field = FirmaCliente.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = FirmaCliente.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						FirmaClienteDataAccess.setFieldReflectionFirmaCliente(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionFirmaCliente(Field field,String strPrefijo,String sColumn,FirmaCliente entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case FirmaClienteConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FirmaClienteConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FirmaClienteConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FirmaClienteConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FirmaClienteConstantesFunciones.IDTIPOIMAGEN:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FirmaClienteConstantesFunciones.FIRMA:
					field.set(entity,resultSet.getBytes(sCampo));
					break;
				
				case FirmaClienteConstantesFunciones.PATHFIRMA:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<FirmaCliente>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<FirmaCliente> entities = new  ArrayList<FirmaCliente>();
		FirmaCliente entity = new FirmaCliente();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=FirmaClienteDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=FirmaClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FirmaClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new FirmaCliente();
					entity=super.getEntity("",entity,resultSet,FirmaClienteDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityFirmaCliente("",entity,resultSet);
					
					//entity.setFirmaClienteOriginal( new FirmaCliente());
					//entity.setFirmaClienteOriginal(super.getEntity("",entity.getFirmaClienteOriginal(),resultSet,FirmaClienteDataAccess.ISWITHSCHEMA));         		
					//entity.setFirmaClienteOriginal(this.getEntityFirmaCliente("",entity.getFirmaClienteOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseFirmaClientes(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFirmaCliente(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<FirmaCliente>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<FirmaCliente> entities = new  ArrayList<FirmaCliente>();
		FirmaCliente entity = new FirmaCliente();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=FirmaClienteDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=FirmaClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FirmaClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<FirmaCliente> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<FirmaCliente> entities = new  ArrayList<FirmaCliente>();
		FirmaCliente entity = new FirmaCliente();		  
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
	
	public  List<FirmaCliente> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<FirmaCliente> entities = new  ArrayList<FirmaCliente>();
		FirmaCliente entity = new FirmaCliente();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FirmaCliente();
      	    	entity=super.getEntity("",entity,resultSet,FirmaClienteDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityFirmaCliente("",entity,resultSet);
      	    	
				//entity.setFirmaClienteOriginal( new FirmaCliente());
      	    	//entity.setFirmaClienteOriginal(super.getEntity("",entity.getFirmaClienteOriginal(),resultSet,FirmaClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFirmaClienteOriginal(this.getEntityFirmaCliente("",entity.getFirmaClienteOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseFirmaClientes(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFirmaCliente(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<FirmaCliente> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<FirmaCliente> entities = new  ArrayList<FirmaCliente>();
		FirmaCliente entity = new FirmaCliente();		  
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
	
	public  List<FirmaCliente> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<FirmaCliente> entities = new  ArrayList<FirmaCliente>();
		FirmaCliente entity = new FirmaCliente();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FirmaCliente();
      	    	entity=super.getEntity("",entity,resultSet,FirmaClienteDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityFirmaCliente("",entity,resultSet);
      	    	
				//entity.setFirmaClienteOriginal( new FirmaCliente());
      	    	//entity.setFirmaClienteOriginal(super.getEntity("",entity.getFirmaClienteOriginal(),resultSet,FirmaClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFirmaClienteOriginal(this.getEntityFirmaCliente("",entity.getFirmaClienteOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseFirmaClientes(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public FirmaCliente getEntityFirmaCliente(String strPrefijo,FirmaCliente entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+FirmaClienteConstantesFunciones.IDEMPRESA));
				entity.setid_cliente(resultSet.getLong(strPrefijo+FirmaClienteConstantesFunciones.IDCLIENTE));
				entity.setid_tipo_imagen(resultSet.getLong(strPrefijo+FirmaClienteConstantesFunciones.IDTIPOIMAGEN));
				if(resultSet.getBytes(strPrefijo+FirmaClienteConstantesFunciones.FIRMA)!=null) {entity.setfirma(resultSet.getBytes(strPrefijo+FirmaClienteConstantesFunciones.FIRMA));}
				entity.setpath_firma(resultSet.getString(strPrefijo+FirmaClienteConstantesFunciones.PATHFIRMA));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowFirmaCliente(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(FirmaCliente entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=FirmaClienteDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=FirmaClienteDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=FirmaClienteDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=FirmaClienteDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(FirmaClienteConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,FirmaClienteDataAccess.TABLENAME,FirmaClienteDataAccess.ISWITHSTOREPROCEDURES);
			
			FirmaClienteDataAccess.setFirmaClienteOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,FirmaCliente relfirmacliente)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relfirmacliente.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Cliente getCliente(Connexion connexion,FirmaCliente relfirmacliente)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,relfirmacliente.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public TipoImagen getTipoImagen(Connexion connexion,FirmaCliente relfirmacliente)throws SQLException,Exception {

		TipoImagen tipoimagen= new TipoImagen();

		try {
			TipoImagenDataAccess tipoimagenDataAccess=new TipoImagenDataAccess();

			tipoimagenDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoimagenDataAccess.setConnexionType(this.connexionType);
			tipoimagenDataAccess.setParameterDbType(this.parameterDbType);

			tipoimagen=tipoimagenDataAccess.getEntity(connexion,relfirmacliente.getid_tipo_imagen());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoimagen;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,FirmaCliente firmacliente) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!firmacliente.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(firmacliente.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_cliente.setValue(firmacliente.getid_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_imagen=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_imagen.setValue(firmacliente.getid_tipo_imagen());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_imagen);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BYTES);
					ParameterValue<byte []> parameterMaintenanceValuefirma=new ParameterValue<byte []>();
					parameterMaintenanceValuefirma.setValue(firmacliente.getfirma());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefirma);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuepath_firma=new ParameterValue<String>();
					parameterMaintenanceValuepath_firma.setValue(firmacliente.getpath_firma());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuepath_firma);
					parametersTemp.add(parameterMaintenance);
					
						if(!firmacliente.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(firmacliente.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(firmacliente.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(firmacliente.getId());
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
	
	public void setIsNewIsChangedFalseFirmaCliente(FirmaCliente firmacliente)throws Exception  {		
		firmacliente.setIsNew(false);
		firmacliente.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseFirmaClientes(List<FirmaCliente> firmaclientes)throws Exception  {				
		for(FirmaCliente firmacliente:firmaclientes) {
			firmacliente.setIsNew(false);
			firmacliente.setIsChanged(false);
		}
	}
	
	public void generarExportarFirmaCliente(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
