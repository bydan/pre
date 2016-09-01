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
import com.bydan.erp.cartera.util.*;//DireccionConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class DireccionDataAccess extends  DireccionDataAccessAdditional{ //DireccionDataAccessAdditional,DataAccessHelper<Direccion>
	//static Logger logger = Logger.getLogger(DireccionDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="direccion";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+DireccionConstantesFunciones.SCHEMA+"."+DireccionConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_cliente,id_tipo_direccion,id_tipo_vivienda,sector,barrio,calles,asegurada,direccion,esactivo)values(current_timestamp,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+DireccionConstantesFunciones.SCHEMA+"."+DireccionConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_cliente=?,id_tipo_direccion=?,id_tipo_vivienda=?,sector=?,barrio=?,calles=?,asegurada=?,direccion=?,esactivo=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+DireccionConstantesFunciones.SCHEMA+"."+DireccionConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select direccion from "+DireccionConstantesFunciones.SPERSISTENCENAME+" direccion";
	public static String QUERYSELECTNATIVE="select "+DireccionConstantesFunciones.SCHEMA+"."+DireccionConstantesFunciones.TABLENAME+".id,"+DireccionConstantesFunciones.SCHEMA+"."+DireccionConstantesFunciones.TABLENAME+".version_row,"+DireccionConstantesFunciones.SCHEMA+"."+DireccionConstantesFunciones.TABLENAME+".id_empresa,"+DireccionConstantesFunciones.SCHEMA+"."+DireccionConstantesFunciones.TABLENAME+".id_cliente,"+DireccionConstantesFunciones.SCHEMA+"."+DireccionConstantesFunciones.TABLENAME+".id_tipo_direccion,"+DireccionConstantesFunciones.SCHEMA+"."+DireccionConstantesFunciones.TABLENAME+".id_tipo_vivienda,"+DireccionConstantesFunciones.SCHEMA+"."+DireccionConstantesFunciones.TABLENAME+".sector,"+DireccionConstantesFunciones.SCHEMA+"."+DireccionConstantesFunciones.TABLENAME+".barrio,"+DireccionConstantesFunciones.SCHEMA+"."+DireccionConstantesFunciones.TABLENAME+".calles,"+DireccionConstantesFunciones.SCHEMA+"."+DireccionConstantesFunciones.TABLENAME+".asegurada,"+DireccionConstantesFunciones.SCHEMA+"."+DireccionConstantesFunciones.TABLENAME+".direccion,"+DireccionConstantesFunciones.SCHEMA+"."+DireccionConstantesFunciones.TABLENAME+".esactivo from "+DireccionConstantesFunciones.SCHEMA+"."+DireccionConstantesFunciones.TABLENAME;//+" as "+DireccionConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+DireccionConstantesFunciones.SCHEMA+"."+DireccionConstantesFunciones.TABLENAME+".id,"+DireccionConstantesFunciones.SCHEMA+"."+DireccionConstantesFunciones.TABLENAME+".version_row,"+DireccionConstantesFunciones.SCHEMA+"."+DireccionConstantesFunciones.TABLENAME+".direccion from "+DireccionConstantesFunciones.SCHEMA+"."+DireccionConstantesFunciones.TABLENAME;//+" as "+DireccionConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+DireccionConstantesFunciones.SCHEMA+"."+DireccionConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_cliente=?,id_tipo_direccion=?,id_tipo_vivienda=?,sector=?,barrio=?,calles=?,asegurada=?,direccion=?,esactivo=?";
	
	public static String STOREPROCEDUREINSERT="call SP_DIRECCION_INSERT(?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_DIRECCION_UPDATE(?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_DIRECCION_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_DIRECCION_SELECT(?,?)";
	
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
	
	
	protected DireccionDataAccessAdditional direccionDataAccessAdditional=null;
	
	public DireccionDataAccessAdditional getDireccionDataAccessAdditional() {
		return this.direccionDataAccessAdditional;
	}
	
	public void setDireccionDataAccessAdditional(DireccionDataAccessAdditional direccionDataAccessAdditional) {
		try {
			this.direccionDataAccessAdditional=direccionDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public DireccionDataAccess() {
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
		DireccionDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		DireccionDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		DireccionDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setDireccionOriginal(Direccion direccion)throws Exception  {
		direccion.setDireccionOriginal((Direccion)direccion.clone());		
	}
	
	public void setDireccionsOriginal(List<Direccion> direccions)throws Exception  {
		
		for(Direccion direccion:direccions){
			direccion.setDireccionOriginal((Direccion)direccion.clone());
		}
	}
	
	public static void setDireccionOriginalStatic(Direccion direccion)throws Exception  {
		direccion.setDireccionOriginal((Direccion)direccion.clone());		
	}
	
	public static void setDireccionsOriginalStatic(List<Direccion> direccions)throws Exception  {
		
		for(Direccion direccion:direccions){
			direccion.setDireccionOriginal((Direccion)direccion.clone());
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
	
	public  Direccion getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		Direccion entity = new Direccion();		
		
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
	
	public  Direccion getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		Direccion entity = new Direccion();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DireccionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DireccionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Cartera.Direccion.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setDireccionOriginal(new Direccion());
      	    	entity=super.getEntity("",entity,resultSet,DireccionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDireccion("",entity,resultSet); 
				
				//entity.setDireccionOriginal(super.getEntity("",entity.getDireccionOriginal(),resultSet,DireccionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDireccionOriginal(this.getEntityDireccion("",entity.getDireccionOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseDireccion(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  Direccion getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Direccion entity = new Direccion();
				
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
	
	public  Direccion getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Direccion entity = new Direccion();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DireccionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DireccionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DireccionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.Direccion.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setDireccionOriginal(new Direccion());
      	    	entity=super.getEntity("",entity,resultSet,DireccionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDireccion("",entity,resultSet);    
				
				//entity.setDireccionOriginal(super.getEntity("",entity.getDireccionOriginal(),resultSet,DireccionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDireccionOriginal(this.getEntityDireccion("",entity.getDireccionOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseDireccion(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //Direccion
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		Direccion entity = new Direccion();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DireccionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DireccionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DireccionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.Direccion.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseDireccion(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<Direccion> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Direccion> entities = new  ArrayList<Direccion>();
		Direccion entity = new Direccion();		  
		
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
	
	public  List<Direccion> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Direccion> entities = new  ArrayList<Direccion>();
		Direccion entity = new Direccion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=DireccionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DireccionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DireccionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Direccion();
      	    	entity=super.getEntity("",entity,resultSet,DireccionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDireccion("",entity,resultSet);
      	    	
				//entity.setDireccionOriginal( new Direccion());
      	    	//entity.setDireccionOriginal(super.getEntity("",entity.getDireccionOriginal(),resultSet,DireccionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDireccionOriginal(this.getEntityDireccion("",entity.getDireccionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDireccions(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDireccion(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Direccion> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Direccion> entities = new  ArrayList<Direccion>();
		Direccion entity = new Direccion();		  
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
	
	public  List<Direccion> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Direccion> entities = new  ArrayList<Direccion>();
		Direccion entity = new Direccion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Direccion();
				
				if(conMapGenerico) {
					entity.inicializarMapDireccion();
					//entity.setMapDireccion(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapDireccionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDireccion().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DireccionDataAccess.ISWITHSCHEMA);         		
					entity=DireccionDataAccess.getEntityDireccion("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDireccionOriginal( new Direccion());
					////entity.setDireccionOriginal(super.getEntity("",entity.getDireccionOriginal(),resultSet,DireccionDataAccess.ISWITHSCHEMA));         		
					////entity.setDireccionOriginal(this.getEntityDireccion("",entity.getDireccionOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDireccions(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDireccion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public Direccion getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Direccion entity = new Direccion();		  
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
	
	public  Direccion getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Direccion entity = new Direccion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Direccion();
				
				if(conMapGenerico) {
					entity.inicializarMapDireccion();
					//entity.setMapDireccion(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapDireccionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDireccion().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DireccionDataAccess.ISWITHSCHEMA);         		
					entity=DireccionDataAccess.getEntityDireccion("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDireccionOriginal( new Direccion());
					////entity.setDireccionOriginal(super.getEntity("",entity.getDireccionOriginal(),resultSet,DireccionDataAccess.ISWITHSCHEMA));         		
					////entity.setDireccionOriginal(this.getEntityDireccion("",entity.getDireccionOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseDireccion(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDireccion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static Direccion getEntityDireccion(String strPrefijo,Direccion entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = Direccion.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = Direccion.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					DireccionDataAccess.setFieldReflectionDireccion(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasDireccion=DireccionConstantesFunciones.getTodosTiposColumnasDireccion();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasDireccion) {
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
							field = Direccion.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = Direccion.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						DireccionDataAccess.setFieldReflectionDireccion(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionDireccion(Field field,String strPrefijo,String sColumn,Direccion entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case DireccionConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DireccionConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DireccionConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DireccionConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DireccionConstantesFunciones.IDTIPODIRECCION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DireccionConstantesFunciones.IDTIPOVIVIENDA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DireccionConstantesFunciones.SECTOR:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DireccionConstantesFunciones.BARRIO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DireccionConstantesFunciones.CALLES:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DireccionConstantesFunciones.ASEGURADA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DireccionConstantesFunciones.DIRECCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DireccionConstantesFunciones.ESACTIVO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Direccion>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<Direccion> entities = new  ArrayList<Direccion>();
		Direccion entity = new Direccion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DireccionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DireccionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DireccionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new Direccion();
					entity=super.getEntity("",entity,resultSet,DireccionDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityDireccion("",entity,resultSet);
					
					//entity.setDireccionOriginal( new Direccion());
					//entity.setDireccionOriginal(super.getEntity("",entity.getDireccionOriginal(),resultSet,DireccionDataAccess.ISWITHSCHEMA));         		
					//entity.setDireccionOriginal(this.getEntityDireccion("",entity.getDireccionOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseDireccions(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDireccion(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Direccion>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<Direccion> entities = new  ArrayList<Direccion>();
		Direccion entity = new Direccion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DireccionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DireccionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DireccionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<Direccion> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Direccion> entities = new  ArrayList<Direccion>();
		Direccion entity = new Direccion();		  
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
	
	public  List<Direccion> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Direccion> entities = new  ArrayList<Direccion>();
		Direccion entity = new Direccion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Direccion();
      	    	entity=super.getEntity("",entity,resultSet,DireccionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDireccion("",entity,resultSet);
      	    	
				//entity.setDireccionOriginal( new Direccion());
      	    	//entity.setDireccionOriginal(super.getEntity("",entity.getDireccionOriginal(),resultSet,DireccionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDireccionOriginal(this.getEntityDireccion("",entity.getDireccionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseDireccions(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDireccion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Direccion> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Direccion> entities = new  ArrayList<Direccion>();
		Direccion entity = new Direccion();		  
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
	
	public  List<Direccion> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Direccion> entities = new  ArrayList<Direccion>();
		Direccion entity = new Direccion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Direccion();
      	    	entity=super.getEntity("",entity,resultSet,DireccionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDireccion("",entity,resultSet);
      	    	
				//entity.setDireccionOriginal( new Direccion());
      	    	//entity.setDireccionOriginal(super.getEntity("",entity.getDireccionOriginal(),resultSet,DireccionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDireccionOriginal(this.getEntityDireccion("",entity.getDireccionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDireccions(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public Direccion getEntityDireccion(String strPrefijo,Direccion entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+DireccionConstantesFunciones.IDEMPRESA));
				entity.setid_cliente(resultSet.getLong(strPrefijo+DireccionConstantesFunciones.IDCLIENTE));
				entity.setid_tipo_direccion(resultSet.getLong(strPrefijo+DireccionConstantesFunciones.IDTIPODIRECCION));
				entity.setid_tipo_vivienda(resultSet.getLong(strPrefijo+DireccionConstantesFunciones.IDTIPOVIVIENDA));
				entity.setsector(resultSet.getString(strPrefijo+DireccionConstantesFunciones.SECTOR));
				entity.setbarrio(resultSet.getString(strPrefijo+DireccionConstantesFunciones.BARRIO));
				entity.setcalles(resultSet.getString(strPrefijo+DireccionConstantesFunciones.CALLES));
				entity.setasegurada(resultSet.getString(strPrefijo+DireccionConstantesFunciones.ASEGURADA));
				entity.setdireccion(resultSet.getString(strPrefijo+DireccionConstantesFunciones.DIRECCION));
				entity.setesactivo(resultSet.getBoolean(strPrefijo+DireccionConstantesFunciones.ESACTIVO));
			} else {
				entity.setdireccion(resultSet.getString(strPrefijo+DireccionConstantesFunciones.DIRECCION));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowDireccion(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(Direccion entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=DireccionDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=DireccionDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=DireccionDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=DireccionDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(DireccionConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,DireccionDataAccess.TABLENAME,DireccionDataAccess.ISWITHSTOREPROCEDURES);
			
			DireccionDataAccess.setDireccionOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,Direccion reldireccion)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reldireccion.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Cliente getCliente(Connexion connexion,Direccion reldireccion)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,reldireccion.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public TipoDireccion getTipoDireccion(Connexion connexion,Direccion reldireccion)throws SQLException,Exception {

		TipoDireccion tipodireccion= new TipoDireccion();

		try {
			TipoDireccionDataAccess tipodireccionDataAccess=new TipoDireccionDataAccess();

			tipodireccionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipodireccionDataAccess.setConnexionType(this.connexionType);
			tipodireccionDataAccess.setParameterDbType(this.parameterDbType);

			tipodireccion=tipodireccionDataAccess.getEntity(connexion,reldireccion.getid_tipo_direccion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipodireccion;

	}

	public TipoVivienda getTipoVivienda(Connexion connexion,Direccion reldireccion)throws SQLException,Exception {

		TipoVivienda tipovivienda= new TipoVivienda();

		try {
			TipoViviendaDataAccess tipoviviendaDataAccess=new TipoViviendaDataAccess();

			tipoviviendaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoviviendaDataAccess.setConnexionType(this.connexionType);
			tipoviviendaDataAccess.setParameterDbType(this.parameterDbType);

			tipovivienda=tipoviviendaDataAccess.getEntity(connexion,reldireccion.getid_tipo_vivienda());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipovivienda;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,Direccion direccion) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!direccion.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(direccion.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_cliente.setValue(direccion.getid_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_direccion=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_direccion.setValue(direccion.getid_tipo_direccion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_direccion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_vivienda=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_vivienda.setValue(direccion.getid_tipo_vivienda());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_vivienda);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuesector=new ParameterValue<String>();
					parameterMaintenanceValuesector.setValue(direccion.getsector());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesector);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuebarrio=new ParameterValue<String>();
					parameterMaintenanceValuebarrio.setValue(direccion.getbarrio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuebarrio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecalles=new ParameterValue<String>();
					parameterMaintenanceValuecalles.setValue(direccion.getcalles());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecalles);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueasegurada=new ParameterValue<String>();
					parameterMaintenanceValueasegurada.setValue(direccion.getasegurada());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueasegurada);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedireccion=new ParameterValue<String>();
					parameterMaintenanceValuedireccion.setValue(direccion.getdireccion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedireccion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValueesactivo=new ParameterValue<Boolean>();
					parameterMaintenanceValueesactivo.setValue(direccion.getesactivo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueesactivo);
					parametersTemp.add(parameterMaintenance);
					
						if(!direccion.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(direccion.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(direccion.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(direccion.getId());
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
	
	public void setIsNewIsChangedFalseDireccion(Direccion direccion)throws Exception  {		
		direccion.setIsNew(false);
		direccion.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseDireccions(List<Direccion> direccions)throws Exception  {				
		for(Direccion direccion:direccions) {
			direccion.setIsNew(false);
			direccion.setIsChanged(false);
		}
	}
	
	public void generarExportarDireccion(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
