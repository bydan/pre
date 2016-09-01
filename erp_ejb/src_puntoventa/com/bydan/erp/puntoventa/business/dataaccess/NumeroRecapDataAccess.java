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
import com.bydan.erp.puntoventa.util.*;//NumeroRecapConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class NumeroRecapDataAccess extends  NumeroRecapDataAccessAdditional{ //NumeroRecapDataAccessAdditional,DataAccessHelper<NumeroRecap>
	//static Logger logger = Logger.getLogger(NumeroRecapDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="numero_recap";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+NumeroRecapConstantesFunciones.SCHEMA+"."+NumeroRecapConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_conexion,numero_recap,fecha)values(current_timestamp,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+NumeroRecapConstantesFunciones.SCHEMA+"."+NumeroRecapConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_conexion=?,numero_recap=?,fecha=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+NumeroRecapConstantesFunciones.SCHEMA+"."+NumeroRecapConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select numerorecap from "+NumeroRecapConstantesFunciones.SPERSISTENCENAME+" numerorecap";
	public static String QUERYSELECTNATIVE="select "+NumeroRecapConstantesFunciones.SCHEMA+"."+NumeroRecapConstantesFunciones.TABLENAME+".id,"+NumeroRecapConstantesFunciones.SCHEMA+"."+NumeroRecapConstantesFunciones.TABLENAME+".version_row,"+NumeroRecapConstantesFunciones.SCHEMA+"."+NumeroRecapConstantesFunciones.TABLENAME+".id_empresa,"+NumeroRecapConstantesFunciones.SCHEMA+"."+NumeroRecapConstantesFunciones.TABLENAME+".id_sucursal,"+NumeroRecapConstantesFunciones.SCHEMA+"."+NumeroRecapConstantesFunciones.TABLENAME+".id_conexion,"+NumeroRecapConstantesFunciones.SCHEMA+"."+NumeroRecapConstantesFunciones.TABLENAME+".numero_recap,"+NumeroRecapConstantesFunciones.SCHEMA+"."+NumeroRecapConstantesFunciones.TABLENAME+".fecha from "+NumeroRecapConstantesFunciones.SCHEMA+"."+NumeroRecapConstantesFunciones.TABLENAME;//+" as "+NumeroRecapConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+NumeroRecapConstantesFunciones.SCHEMA+"."+NumeroRecapConstantesFunciones.TABLENAME+".id,"+NumeroRecapConstantesFunciones.SCHEMA+"."+NumeroRecapConstantesFunciones.TABLENAME+".version_row from "+NumeroRecapConstantesFunciones.SCHEMA+"."+NumeroRecapConstantesFunciones.TABLENAME;//+" as "+NumeroRecapConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+NumeroRecapConstantesFunciones.SCHEMA+"."+NumeroRecapConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_conexion=?,numero_recap=?,fecha=?";
	
	public static String STOREPROCEDUREINSERT="call SP_NUMERORECAP_INSERT(?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_NUMERORECAP_UPDATE(?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_NUMERORECAP_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_NUMERORECAP_SELECT(?,?)";
	
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
	
	
	protected NumeroRecapDataAccessAdditional numerorecapDataAccessAdditional=null;
	
	public NumeroRecapDataAccessAdditional getNumeroRecapDataAccessAdditional() {
		return this.numerorecapDataAccessAdditional;
	}
	
	public void setNumeroRecapDataAccessAdditional(NumeroRecapDataAccessAdditional numerorecapDataAccessAdditional) {
		try {
			this.numerorecapDataAccessAdditional=numerorecapDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public NumeroRecapDataAccess() {
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
		NumeroRecapDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		NumeroRecapDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		NumeroRecapDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setNumeroRecapOriginal(NumeroRecap numerorecap)throws Exception  {
		numerorecap.setNumeroRecapOriginal((NumeroRecap)numerorecap.clone());		
	}
	
	public void setNumeroRecapsOriginal(List<NumeroRecap> numerorecaps)throws Exception  {
		
		for(NumeroRecap numerorecap:numerorecaps){
			numerorecap.setNumeroRecapOriginal((NumeroRecap)numerorecap.clone());
		}
	}
	
	public static void setNumeroRecapOriginalStatic(NumeroRecap numerorecap)throws Exception  {
		numerorecap.setNumeroRecapOriginal((NumeroRecap)numerorecap.clone());		
	}
	
	public static void setNumeroRecapsOriginalStatic(List<NumeroRecap> numerorecaps)throws Exception  {
		
		for(NumeroRecap numerorecap:numerorecaps){
			numerorecap.setNumeroRecapOriginal((NumeroRecap)numerorecap.clone());
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
	
	public  NumeroRecap getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		NumeroRecap entity = new NumeroRecap();		
		
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
	
	public  NumeroRecap getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		NumeroRecap entity = new NumeroRecap();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=NumeroRecapDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=NumeroRecapDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//PuntoVenta.NumeroRecap.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setNumeroRecapOriginal(new NumeroRecap());
      	    	entity=super.getEntity("",entity,resultSet,NumeroRecapDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityNumeroRecap("",entity,resultSet); 
				
				//entity.setNumeroRecapOriginal(super.getEntity("",entity.getNumeroRecapOriginal(),resultSet,NumeroRecapDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setNumeroRecapOriginal(this.getEntityNumeroRecap("",entity.getNumeroRecapOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseNumeroRecap(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  NumeroRecap getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		NumeroRecap entity = new NumeroRecap();
				
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
	
	public  NumeroRecap getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		NumeroRecap entity = new NumeroRecap();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=NumeroRecapDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=NumeroRecapDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,NumeroRecapDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//PuntoVenta.NumeroRecap.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setNumeroRecapOriginal(new NumeroRecap());
      	    	entity=super.getEntity("",entity,resultSet,NumeroRecapDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityNumeroRecap("",entity,resultSet);    
				
				//entity.setNumeroRecapOriginal(super.getEntity("",entity.getNumeroRecapOriginal(),resultSet,NumeroRecapDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setNumeroRecapOriginal(this.getEntityNumeroRecap("",entity.getNumeroRecapOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseNumeroRecap(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //NumeroRecap
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		NumeroRecap entity = new NumeroRecap();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=NumeroRecapDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=NumeroRecapDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,NumeroRecapDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//PuntoVenta.NumeroRecap.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseNumeroRecap(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<NumeroRecap> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<NumeroRecap> entities = new  ArrayList<NumeroRecap>();
		NumeroRecap entity = new NumeroRecap();		  
		
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
	
	public  List<NumeroRecap> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<NumeroRecap> entities = new  ArrayList<NumeroRecap>();
		NumeroRecap entity = new NumeroRecap();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=NumeroRecapDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=NumeroRecapDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,NumeroRecapDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new NumeroRecap();
      	    	entity=super.getEntity("",entity,resultSet,NumeroRecapDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityNumeroRecap("",entity,resultSet);
      	    	
				//entity.setNumeroRecapOriginal( new NumeroRecap());
      	    	//entity.setNumeroRecapOriginal(super.getEntity("",entity.getNumeroRecapOriginal(),resultSet,NumeroRecapDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setNumeroRecapOriginal(this.getEntityNumeroRecap("",entity.getNumeroRecapOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseNumeroRecaps(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarNumeroRecap(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<NumeroRecap> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<NumeroRecap> entities = new  ArrayList<NumeroRecap>();
		NumeroRecap entity = new NumeroRecap();		  
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
	
	public  List<NumeroRecap> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<NumeroRecap> entities = new  ArrayList<NumeroRecap>();
		NumeroRecap entity = new NumeroRecap();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new NumeroRecap();
				
				if(conMapGenerico) {
					entity.inicializarMapNumeroRecap();
					//entity.setMapNumeroRecap(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapNumeroRecapValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapNumeroRecap().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,NumeroRecapDataAccess.ISWITHSCHEMA);         		
					entity=NumeroRecapDataAccess.getEntityNumeroRecap("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setNumeroRecapOriginal( new NumeroRecap());
					////entity.setNumeroRecapOriginal(super.getEntity("",entity.getNumeroRecapOriginal(),resultSet,NumeroRecapDataAccess.ISWITHSCHEMA));         		
					////entity.setNumeroRecapOriginal(this.getEntityNumeroRecap("",entity.getNumeroRecapOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseNumeroRecaps(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarNumeroRecap(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public NumeroRecap getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		NumeroRecap entity = new NumeroRecap();		  
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
	
	public  NumeroRecap getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		NumeroRecap entity = new NumeroRecap();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new NumeroRecap();
				
				if(conMapGenerico) {
					entity.inicializarMapNumeroRecap();
					//entity.setMapNumeroRecap(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapNumeroRecapValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapNumeroRecap().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,NumeroRecapDataAccess.ISWITHSCHEMA);         		
					entity=NumeroRecapDataAccess.getEntityNumeroRecap("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setNumeroRecapOriginal( new NumeroRecap());
					////entity.setNumeroRecapOriginal(super.getEntity("",entity.getNumeroRecapOriginal(),resultSet,NumeroRecapDataAccess.ISWITHSCHEMA));         		
					////entity.setNumeroRecapOriginal(this.getEntityNumeroRecap("",entity.getNumeroRecapOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseNumeroRecap(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarNumeroRecap(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static NumeroRecap getEntityNumeroRecap(String strPrefijo,NumeroRecap entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = NumeroRecap.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = NumeroRecap.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					NumeroRecapDataAccess.setFieldReflectionNumeroRecap(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasNumeroRecap=NumeroRecapConstantesFunciones.getTodosTiposColumnasNumeroRecap();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasNumeroRecap) {
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
							field = NumeroRecap.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = NumeroRecap.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						NumeroRecapDataAccess.setFieldReflectionNumeroRecap(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionNumeroRecap(Field field,String strPrefijo,String sColumn,NumeroRecap entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case NumeroRecapConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NumeroRecapConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case NumeroRecapConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NumeroRecapConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NumeroRecapConstantesFunciones.IDCONEXION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NumeroRecapConstantesFunciones.NUMERORECAP:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case NumeroRecapConstantesFunciones.FECHA:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<NumeroRecap>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<NumeroRecap> entities = new  ArrayList<NumeroRecap>();
		NumeroRecap entity = new NumeroRecap();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=NumeroRecapDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=NumeroRecapDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,NumeroRecapDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new NumeroRecap();
					entity=super.getEntity("",entity,resultSet,NumeroRecapDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityNumeroRecap("",entity,resultSet);
					
					//entity.setNumeroRecapOriginal( new NumeroRecap());
					//entity.setNumeroRecapOriginal(super.getEntity("",entity.getNumeroRecapOriginal(),resultSet,NumeroRecapDataAccess.ISWITHSCHEMA));         		
					//entity.setNumeroRecapOriginal(this.getEntityNumeroRecap("",entity.getNumeroRecapOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseNumeroRecaps(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarNumeroRecap(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<NumeroRecap>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<NumeroRecap> entities = new  ArrayList<NumeroRecap>();
		NumeroRecap entity = new NumeroRecap();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=NumeroRecapDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=NumeroRecapDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,NumeroRecapDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<NumeroRecap> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<NumeroRecap> entities = new  ArrayList<NumeroRecap>();
		NumeroRecap entity = new NumeroRecap();		  
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
	
	public  List<NumeroRecap> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<NumeroRecap> entities = new  ArrayList<NumeroRecap>();
		NumeroRecap entity = new NumeroRecap();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new NumeroRecap();
      	    	entity=super.getEntity("",entity,resultSet,NumeroRecapDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityNumeroRecap("",entity,resultSet);
      	    	
				//entity.setNumeroRecapOriginal( new NumeroRecap());
      	    	//entity.setNumeroRecapOriginal(super.getEntity("",entity.getNumeroRecapOriginal(),resultSet,NumeroRecapDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setNumeroRecapOriginal(this.getEntityNumeroRecap("",entity.getNumeroRecapOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseNumeroRecaps(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarNumeroRecap(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<NumeroRecap> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<NumeroRecap> entities = new  ArrayList<NumeroRecap>();
		NumeroRecap entity = new NumeroRecap();		  
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
	
	public  List<NumeroRecap> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<NumeroRecap> entities = new  ArrayList<NumeroRecap>();
		NumeroRecap entity = new NumeroRecap();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new NumeroRecap();
      	    	entity=super.getEntity("",entity,resultSet,NumeroRecapDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityNumeroRecap("",entity,resultSet);
      	    	
				//entity.setNumeroRecapOriginal( new NumeroRecap());
      	    	//entity.setNumeroRecapOriginal(super.getEntity("",entity.getNumeroRecapOriginal(),resultSet,NumeroRecapDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setNumeroRecapOriginal(this.getEntityNumeroRecap("",entity.getNumeroRecapOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseNumeroRecaps(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public NumeroRecap getEntityNumeroRecap(String strPrefijo,NumeroRecap entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+NumeroRecapConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+NumeroRecapConstantesFunciones.IDSUCURSAL));
				entity.setid_conexion(resultSet.getLong(strPrefijo+NumeroRecapConstantesFunciones.IDCONEXION));
				entity.setnumero_recap(resultSet.getString(strPrefijo+NumeroRecapConstantesFunciones.NUMERORECAP));
				entity.setfecha(new Date(resultSet.getDate(strPrefijo+NumeroRecapConstantesFunciones.FECHA).getTime()));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowNumeroRecap(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(NumeroRecap entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=NumeroRecapDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=NumeroRecapDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=NumeroRecapDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=NumeroRecapDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(NumeroRecapConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,NumeroRecapDataAccess.TABLENAME,NumeroRecapDataAccess.ISWITHSTOREPROCEDURES);
			
			NumeroRecapDataAccess.setNumeroRecapOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,NumeroRecap relnumerorecap)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relnumerorecap.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,NumeroRecap relnumerorecap)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relnumerorecap.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Conexion getConexion(Connexion connexion,NumeroRecap relnumerorecap)throws SQLException,Exception {

		Conexion conexion= new Conexion();

		try {
			ConexionDataAccess conexionDataAccess=new ConexionDataAccess();

			conexionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			conexionDataAccess.setConnexionType(this.connexionType);
			conexionDataAccess.setParameterDbType(this.parameterDbType);

			conexion=conexionDataAccess.getEntity(connexion,relnumerorecap.getid_conexion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return conexion;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,NumeroRecap numerorecap) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!numerorecap.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(numerorecap.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(numerorecap.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_conexion=new ParameterValue<Long>();
					parameterMaintenanceValueid_conexion.setValue(numerorecap.getid_conexion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_conexion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_recap=new ParameterValue<String>();
					parameterMaintenanceValuenumero_recap.setValue(numerorecap.getnumero_recap());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_recap);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha=new ParameterValue<Date>();
					parameterMaintenanceValuefecha.setValue(numerorecap.getfecha());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha);
					parametersTemp.add(parameterMaintenance);
					
						if(!numerorecap.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(numerorecap.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(numerorecap.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(numerorecap.getId());
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
	
	public void setIsNewIsChangedFalseNumeroRecap(NumeroRecap numerorecap)throws Exception  {		
		numerorecap.setIsNew(false);
		numerorecap.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseNumeroRecaps(List<NumeroRecap> numerorecaps)throws Exception  {				
		for(NumeroRecap numerorecap:numerorecaps) {
			numerorecap.setIsNew(false);
			numerorecap.setIsChanged(false);
		}
	}
	
	public void generarExportarNumeroRecap(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
