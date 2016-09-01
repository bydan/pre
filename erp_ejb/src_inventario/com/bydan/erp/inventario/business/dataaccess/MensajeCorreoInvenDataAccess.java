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
import com.bydan.erp.inventario.util.*;//MensajeCorreoInvenConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class MensajeCorreoInvenDataAccess extends  MensajeCorreoInvenDataAccessAdditional{ //MensajeCorreoInvenDataAccessAdditional,DataAccessHelper<MensajeCorreoInven>
	//static Logger logger = Logger.getLogger(MensajeCorreoInvenDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="mensaje_correo_inven";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+MensajeCorreoInvenConstantesFunciones.SCHEMA+"."+MensajeCorreoInvenConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_modulo,id_tipo_mensaje_correo_inven,tema,mensaje,aviso,esta_activo)values(current_timestamp,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+MensajeCorreoInvenConstantesFunciones.SCHEMA+"."+MensajeCorreoInvenConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_modulo=?,id_tipo_mensaje_correo_inven=?,tema=?,mensaje=?,aviso=?,esta_activo=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+MensajeCorreoInvenConstantesFunciones.SCHEMA+"."+MensajeCorreoInvenConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select mensajecorreoinven from "+MensajeCorreoInvenConstantesFunciones.SPERSISTENCENAME+" mensajecorreoinven";
	public static String QUERYSELECTNATIVE="select "+MensajeCorreoInvenConstantesFunciones.SCHEMA+"."+MensajeCorreoInvenConstantesFunciones.TABLENAME+".id,"+MensajeCorreoInvenConstantesFunciones.SCHEMA+"."+MensajeCorreoInvenConstantesFunciones.TABLENAME+".version_row,"+MensajeCorreoInvenConstantesFunciones.SCHEMA+"."+MensajeCorreoInvenConstantesFunciones.TABLENAME+".id_empresa,"+MensajeCorreoInvenConstantesFunciones.SCHEMA+"."+MensajeCorreoInvenConstantesFunciones.TABLENAME+".id_sucursal,"+MensajeCorreoInvenConstantesFunciones.SCHEMA+"."+MensajeCorreoInvenConstantesFunciones.TABLENAME+".id_modulo,"+MensajeCorreoInvenConstantesFunciones.SCHEMA+"."+MensajeCorreoInvenConstantesFunciones.TABLENAME+".id_tipo_mensaje_correo_inven,"+MensajeCorreoInvenConstantesFunciones.SCHEMA+"."+MensajeCorreoInvenConstantesFunciones.TABLENAME+".tema,"+MensajeCorreoInvenConstantesFunciones.SCHEMA+"."+MensajeCorreoInvenConstantesFunciones.TABLENAME+".mensaje,"+MensajeCorreoInvenConstantesFunciones.SCHEMA+"."+MensajeCorreoInvenConstantesFunciones.TABLENAME+".aviso,"+MensajeCorreoInvenConstantesFunciones.SCHEMA+"."+MensajeCorreoInvenConstantesFunciones.TABLENAME+".esta_activo from "+MensajeCorreoInvenConstantesFunciones.SCHEMA+"."+MensajeCorreoInvenConstantesFunciones.TABLENAME;//+" as "+MensajeCorreoInvenConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+MensajeCorreoInvenConstantesFunciones.SCHEMA+"."+MensajeCorreoInvenConstantesFunciones.TABLENAME+".id,"+MensajeCorreoInvenConstantesFunciones.SCHEMA+"."+MensajeCorreoInvenConstantesFunciones.TABLENAME+".version_row from "+MensajeCorreoInvenConstantesFunciones.SCHEMA+"."+MensajeCorreoInvenConstantesFunciones.TABLENAME;//+" as "+MensajeCorreoInvenConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+MensajeCorreoInvenConstantesFunciones.SCHEMA+"."+MensajeCorreoInvenConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_modulo=?,id_tipo_mensaje_correo_inven=?,tema=?,mensaje=?,aviso=?,esta_activo=?";
	
	public static String STOREPROCEDUREINSERT="call SP_MENSAJECORREOINVEN_INSERT(?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_MENSAJECORREOINVEN_UPDATE(?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_MENSAJECORREOINVEN_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_MENSAJECORREOINVEN_SELECT(?,?)";
	
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
	
	
	protected MensajeCorreoInvenDataAccessAdditional mensajecorreoinvenDataAccessAdditional=null;
	
	public MensajeCorreoInvenDataAccessAdditional getMensajeCorreoInvenDataAccessAdditional() {
		return this.mensajecorreoinvenDataAccessAdditional;
	}
	
	public void setMensajeCorreoInvenDataAccessAdditional(MensajeCorreoInvenDataAccessAdditional mensajecorreoinvenDataAccessAdditional) {
		try {
			this.mensajecorreoinvenDataAccessAdditional=mensajecorreoinvenDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public MensajeCorreoInvenDataAccess() {
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
		MensajeCorreoInvenDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		MensajeCorreoInvenDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		MensajeCorreoInvenDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setMensajeCorreoInvenOriginal(MensajeCorreoInven mensajecorreoinven)throws Exception  {
		mensajecorreoinven.setMensajeCorreoInvenOriginal((MensajeCorreoInven)mensajecorreoinven.clone());		
	}
	
	public void setMensajeCorreoInvensOriginal(List<MensajeCorreoInven> mensajecorreoinvens)throws Exception  {
		
		for(MensajeCorreoInven mensajecorreoinven:mensajecorreoinvens){
			mensajecorreoinven.setMensajeCorreoInvenOriginal((MensajeCorreoInven)mensajecorreoinven.clone());
		}
	}
	
	public static void setMensajeCorreoInvenOriginalStatic(MensajeCorreoInven mensajecorreoinven)throws Exception  {
		mensajecorreoinven.setMensajeCorreoInvenOriginal((MensajeCorreoInven)mensajecorreoinven.clone());		
	}
	
	public static void setMensajeCorreoInvensOriginalStatic(List<MensajeCorreoInven> mensajecorreoinvens)throws Exception  {
		
		for(MensajeCorreoInven mensajecorreoinven:mensajecorreoinvens){
			mensajecorreoinven.setMensajeCorreoInvenOriginal((MensajeCorreoInven)mensajecorreoinven.clone());
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
	
	public  MensajeCorreoInven getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		MensajeCorreoInven entity = new MensajeCorreoInven();		
		
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
	
	public  MensajeCorreoInven getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		MensajeCorreoInven entity = new MensajeCorreoInven();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=MensajeCorreoInvenDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=MensajeCorreoInvenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.MensajeCorreoInven.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setMensajeCorreoInvenOriginal(new MensajeCorreoInven());
      	    	entity=super.getEntity("",entity,resultSet,MensajeCorreoInvenDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityMensajeCorreoInven("",entity,resultSet); 
				
				//entity.setMensajeCorreoInvenOriginal(super.getEntity("",entity.getMensajeCorreoInvenOriginal(),resultSet,MensajeCorreoInvenDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setMensajeCorreoInvenOriginal(this.getEntityMensajeCorreoInven("",entity.getMensajeCorreoInvenOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseMensajeCorreoInven(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  MensajeCorreoInven getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		MensajeCorreoInven entity = new MensajeCorreoInven();
				
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
	
	public  MensajeCorreoInven getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		MensajeCorreoInven entity = new MensajeCorreoInven();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=MensajeCorreoInvenDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=MensajeCorreoInvenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,MensajeCorreoInvenDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.MensajeCorreoInven.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setMensajeCorreoInvenOriginal(new MensajeCorreoInven());
      	    	entity=super.getEntity("",entity,resultSet,MensajeCorreoInvenDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityMensajeCorreoInven("",entity,resultSet);    
				
				//entity.setMensajeCorreoInvenOriginal(super.getEntity("",entity.getMensajeCorreoInvenOriginal(),resultSet,MensajeCorreoInvenDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setMensajeCorreoInvenOriginal(this.getEntityMensajeCorreoInven("",entity.getMensajeCorreoInvenOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseMensajeCorreoInven(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //MensajeCorreoInven
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		MensajeCorreoInven entity = new MensajeCorreoInven();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=MensajeCorreoInvenDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=MensajeCorreoInvenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,MensajeCorreoInvenDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.MensajeCorreoInven.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseMensajeCorreoInven(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<MensajeCorreoInven> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<MensajeCorreoInven> entities = new  ArrayList<MensajeCorreoInven>();
		MensajeCorreoInven entity = new MensajeCorreoInven();		  
		
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
	
	public  List<MensajeCorreoInven> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<MensajeCorreoInven> entities = new  ArrayList<MensajeCorreoInven>();
		MensajeCorreoInven entity = new MensajeCorreoInven();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=MensajeCorreoInvenDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=MensajeCorreoInvenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,MensajeCorreoInvenDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new MensajeCorreoInven();
      	    	entity=super.getEntity("",entity,resultSet,MensajeCorreoInvenDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityMensajeCorreoInven("",entity,resultSet);
      	    	
				//entity.setMensajeCorreoInvenOriginal( new MensajeCorreoInven());
      	    	//entity.setMensajeCorreoInvenOriginal(super.getEntity("",entity.getMensajeCorreoInvenOriginal(),resultSet,MensajeCorreoInvenDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setMensajeCorreoInvenOriginal(this.getEntityMensajeCorreoInven("",entity.getMensajeCorreoInvenOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseMensajeCorreoInvens(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarMensajeCorreoInven(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<MensajeCorreoInven> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<MensajeCorreoInven> entities = new  ArrayList<MensajeCorreoInven>();
		MensajeCorreoInven entity = new MensajeCorreoInven();		  
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
	
	public  List<MensajeCorreoInven> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<MensajeCorreoInven> entities = new  ArrayList<MensajeCorreoInven>();
		MensajeCorreoInven entity = new MensajeCorreoInven();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new MensajeCorreoInven();
				
				if(conMapGenerico) {
					entity.inicializarMapMensajeCorreoInven();
					//entity.setMapMensajeCorreoInven(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapMensajeCorreoInvenValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapMensajeCorreoInven().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,MensajeCorreoInvenDataAccess.ISWITHSCHEMA);         		
					entity=MensajeCorreoInvenDataAccess.getEntityMensajeCorreoInven("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setMensajeCorreoInvenOriginal( new MensajeCorreoInven());
					////entity.setMensajeCorreoInvenOriginal(super.getEntity("",entity.getMensajeCorreoInvenOriginal(),resultSet,MensajeCorreoInvenDataAccess.ISWITHSCHEMA));         		
					////entity.setMensajeCorreoInvenOriginal(this.getEntityMensajeCorreoInven("",entity.getMensajeCorreoInvenOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseMensajeCorreoInvens(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarMensajeCorreoInven(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public MensajeCorreoInven getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		MensajeCorreoInven entity = new MensajeCorreoInven();		  
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
	
	public  MensajeCorreoInven getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		MensajeCorreoInven entity = new MensajeCorreoInven();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new MensajeCorreoInven();
				
				if(conMapGenerico) {
					entity.inicializarMapMensajeCorreoInven();
					//entity.setMapMensajeCorreoInven(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapMensajeCorreoInvenValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapMensajeCorreoInven().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,MensajeCorreoInvenDataAccess.ISWITHSCHEMA);         		
					entity=MensajeCorreoInvenDataAccess.getEntityMensajeCorreoInven("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setMensajeCorreoInvenOriginal( new MensajeCorreoInven());
					////entity.setMensajeCorreoInvenOriginal(super.getEntity("",entity.getMensajeCorreoInvenOriginal(),resultSet,MensajeCorreoInvenDataAccess.ISWITHSCHEMA));         		
					////entity.setMensajeCorreoInvenOriginal(this.getEntityMensajeCorreoInven("",entity.getMensajeCorreoInvenOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseMensajeCorreoInven(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarMensajeCorreoInven(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static MensajeCorreoInven getEntityMensajeCorreoInven(String strPrefijo,MensajeCorreoInven entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = MensajeCorreoInven.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = MensajeCorreoInven.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					MensajeCorreoInvenDataAccess.setFieldReflectionMensajeCorreoInven(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasMensajeCorreoInven=MensajeCorreoInvenConstantesFunciones.getTodosTiposColumnasMensajeCorreoInven();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasMensajeCorreoInven) {
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
							field = MensajeCorreoInven.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = MensajeCorreoInven.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						MensajeCorreoInvenDataAccess.setFieldReflectionMensajeCorreoInven(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionMensajeCorreoInven(Field field,String strPrefijo,String sColumn,MensajeCorreoInven entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case MensajeCorreoInvenConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case MensajeCorreoInvenConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case MensajeCorreoInvenConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case MensajeCorreoInvenConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case MensajeCorreoInvenConstantesFunciones.IDMODULO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case MensajeCorreoInvenConstantesFunciones.IDTIPOMENSAJECORREOINVEN:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case MensajeCorreoInvenConstantesFunciones.TEMA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case MensajeCorreoInvenConstantesFunciones.MENSAJE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case MensajeCorreoInvenConstantesFunciones.AVISO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case MensajeCorreoInvenConstantesFunciones.ESTAACTIVO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<MensajeCorreoInven>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<MensajeCorreoInven> entities = new  ArrayList<MensajeCorreoInven>();
		MensajeCorreoInven entity = new MensajeCorreoInven();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=MensajeCorreoInvenDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=MensajeCorreoInvenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,MensajeCorreoInvenDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new MensajeCorreoInven();
					entity=super.getEntity("",entity,resultSet,MensajeCorreoInvenDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityMensajeCorreoInven("",entity,resultSet);
					
					//entity.setMensajeCorreoInvenOriginal( new MensajeCorreoInven());
					//entity.setMensajeCorreoInvenOriginal(super.getEntity("",entity.getMensajeCorreoInvenOriginal(),resultSet,MensajeCorreoInvenDataAccess.ISWITHSCHEMA));         		
					//entity.setMensajeCorreoInvenOriginal(this.getEntityMensajeCorreoInven("",entity.getMensajeCorreoInvenOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseMensajeCorreoInvens(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarMensajeCorreoInven(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<MensajeCorreoInven>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<MensajeCorreoInven> entities = new  ArrayList<MensajeCorreoInven>();
		MensajeCorreoInven entity = new MensajeCorreoInven();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=MensajeCorreoInvenDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=MensajeCorreoInvenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,MensajeCorreoInvenDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<MensajeCorreoInven> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<MensajeCorreoInven> entities = new  ArrayList<MensajeCorreoInven>();
		MensajeCorreoInven entity = new MensajeCorreoInven();		  
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
	
	public  List<MensajeCorreoInven> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<MensajeCorreoInven> entities = new  ArrayList<MensajeCorreoInven>();
		MensajeCorreoInven entity = new MensajeCorreoInven();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new MensajeCorreoInven();
      	    	entity=super.getEntity("",entity,resultSet,MensajeCorreoInvenDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityMensajeCorreoInven("",entity,resultSet);
      	    	
				//entity.setMensajeCorreoInvenOriginal( new MensajeCorreoInven());
      	    	//entity.setMensajeCorreoInvenOriginal(super.getEntity("",entity.getMensajeCorreoInvenOriginal(),resultSet,MensajeCorreoInvenDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setMensajeCorreoInvenOriginal(this.getEntityMensajeCorreoInven("",entity.getMensajeCorreoInvenOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseMensajeCorreoInvens(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarMensajeCorreoInven(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<MensajeCorreoInven> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<MensajeCorreoInven> entities = new  ArrayList<MensajeCorreoInven>();
		MensajeCorreoInven entity = new MensajeCorreoInven();		  
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
	
	public  List<MensajeCorreoInven> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<MensajeCorreoInven> entities = new  ArrayList<MensajeCorreoInven>();
		MensajeCorreoInven entity = new MensajeCorreoInven();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new MensajeCorreoInven();
      	    	entity=super.getEntity("",entity,resultSet,MensajeCorreoInvenDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityMensajeCorreoInven("",entity,resultSet);
      	    	
				//entity.setMensajeCorreoInvenOriginal( new MensajeCorreoInven());
      	    	//entity.setMensajeCorreoInvenOriginal(super.getEntity("",entity.getMensajeCorreoInvenOriginal(),resultSet,MensajeCorreoInvenDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setMensajeCorreoInvenOriginal(this.getEntityMensajeCorreoInven("",entity.getMensajeCorreoInvenOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseMensajeCorreoInvens(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public MensajeCorreoInven getEntityMensajeCorreoInven(String strPrefijo,MensajeCorreoInven entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+MensajeCorreoInvenConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+MensajeCorreoInvenConstantesFunciones.IDSUCURSAL));
				entity.setid_modulo(resultSet.getLong(strPrefijo+MensajeCorreoInvenConstantesFunciones.IDMODULO));
				entity.setid_tipo_mensaje_correo_inven(resultSet.getLong(strPrefijo+MensajeCorreoInvenConstantesFunciones.IDTIPOMENSAJECORREOINVEN));
				entity.settema(resultSet.getString(strPrefijo+MensajeCorreoInvenConstantesFunciones.TEMA));
				entity.setmensaje(resultSet.getString(strPrefijo+MensajeCorreoInvenConstantesFunciones.MENSAJE));
				entity.setaviso(resultSet.getString(strPrefijo+MensajeCorreoInvenConstantesFunciones.AVISO));
				entity.setesta_activo(resultSet.getBoolean(strPrefijo+MensajeCorreoInvenConstantesFunciones.ESTAACTIVO));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowMensajeCorreoInven(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(MensajeCorreoInven entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=MensajeCorreoInvenDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=MensajeCorreoInvenDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=MensajeCorreoInvenDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=MensajeCorreoInvenDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(MensajeCorreoInvenConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,MensajeCorreoInvenDataAccess.TABLENAME,MensajeCorreoInvenDataAccess.ISWITHSTOREPROCEDURES);
			
			MensajeCorreoInvenDataAccess.setMensajeCorreoInvenOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,MensajeCorreoInven relmensajecorreoinven)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relmensajecorreoinven.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,MensajeCorreoInven relmensajecorreoinven)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relmensajecorreoinven.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Modulo getModulo(Connexion connexion,MensajeCorreoInven relmensajecorreoinven)throws SQLException,Exception {

		Modulo modulo= new Modulo();

		try {
			ModuloDataAccess moduloDataAccess=new ModuloDataAccess();

			moduloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			moduloDataAccess.setConnexionType(this.connexionType);
			moduloDataAccess.setParameterDbType(this.parameterDbType);

			modulo=moduloDataAccess.getEntity(connexion,relmensajecorreoinven.getid_modulo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return modulo;

	}

	public TipoMensajeCorreoInven getTipoMensajeCorreoInven(Connexion connexion,MensajeCorreoInven relmensajecorreoinven)throws SQLException,Exception {

		TipoMensajeCorreoInven tipomensajecorreoinven= new TipoMensajeCorreoInven();

		try {
			TipoMensajeCorreoInvenDataAccess tipomensajecorreoinvenDataAccess=new TipoMensajeCorreoInvenDataAccess();

			tipomensajecorreoinvenDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipomensajecorreoinvenDataAccess.setConnexionType(this.connexionType);
			tipomensajecorreoinvenDataAccess.setParameterDbType(this.parameterDbType);

			tipomensajecorreoinven=tipomensajecorreoinvenDataAccess.getEntity(connexion,relmensajecorreoinven.getid_tipo_mensaje_correo_inven());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipomensajecorreoinven;

	}


		
		public List<DetalleMensajeCorreoInven> getDetalleMensajeCorreoInvens(Connexion connexion,MensajeCorreoInven mensajecorreoinven)throws SQLException,Exception {

		List<DetalleMensajeCorreoInven> detallemensajecorreoinvens= new ArrayList<DetalleMensajeCorreoInven>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+MensajeCorreoInvenConstantesFunciones.SCHEMA+".mensaje_correo_inven ON "+DetalleMensajeCorreoInvenConstantesFunciones.SCHEMA+".detalle_mensaje_correo_inven.id_mensaje_correo_inven="+MensajeCorreoInvenConstantesFunciones.SCHEMA+".mensaje_correo_inven.id WHERE "+MensajeCorreoInvenConstantesFunciones.SCHEMA+".mensaje_correo_inven.id="+String.valueOf(mensajecorreoinven.getId());
			} else {
				sQuery=" INNER JOIN detallemensajecorreoinven.MensajeCorreoInven WHERE detallemensajecorreoinven.MensajeCorreoInven.id="+String.valueOf(mensajecorreoinven.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleMensajeCorreoInvenDataAccess detallemensajecorreoinvenDataAccess=new DetalleMensajeCorreoInvenDataAccess();

			detallemensajecorreoinvenDataAccess.setConnexionType(this.connexionType);
			detallemensajecorreoinvenDataAccess.setParameterDbType(this.parameterDbType);
			detallemensajecorreoinvens=detallemensajecorreoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detallemensajecorreoinvens;

	}

	public List<MailMensajeCorreoInven> getMailMensajeCorreoInvens(Connexion connexion,MensajeCorreoInven mensajecorreoinven)throws SQLException,Exception {

		List<MailMensajeCorreoInven> mailmensajecorreoinvens= new ArrayList<MailMensajeCorreoInven>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+MensajeCorreoInvenConstantesFunciones.SCHEMA+".mensaje_correo_inven ON "+MailMensajeCorreoInvenConstantesFunciones.SCHEMA+".mail_mensaje_correo_inven.id_mensaje_correo_inven="+MensajeCorreoInvenConstantesFunciones.SCHEMA+".mensaje_correo_inven.id WHERE "+MensajeCorreoInvenConstantesFunciones.SCHEMA+".mensaje_correo_inven.id="+String.valueOf(mensajecorreoinven.getId());
			} else {
				sQuery=" INNER JOIN mailmensajecorreoinven.MensajeCorreoInven WHERE mailmensajecorreoinven.MensajeCorreoInven.id="+String.valueOf(mensajecorreoinven.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			MailMensajeCorreoInvenDataAccess mailmensajecorreoinvenDataAccess=new MailMensajeCorreoInvenDataAccess();

			mailmensajecorreoinvenDataAccess.setConnexionType(this.connexionType);
			mailmensajecorreoinvenDataAccess.setParameterDbType(this.parameterDbType);
			mailmensajecorreoinvens=mailmensajecorreoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mailmensajecorreoinvens;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,MensajeCorreoInven mensajecorreoinven) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!mensajecorreoinven.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(mensajecorreoinven.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(mensajecorreoinven.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_modulo=new ParameterValue<Long>();
					parameterMaintenanceValueid_modulo.setValue(mensajecorreoinven.getid_modulo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_modulo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_mensaje_correo_inven=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_mensaje_correo_inven.setValue(mensajecorreoinven.getid_tipo_mensaje_correo_inven());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_mensaje_correo_inven);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuetema=new ParameterValue<String>();
					parameterMaintenanceValuetema.setValue(mensajecorreoinven.gettema());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetema);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuemensaje=new ParameterValue<String>();
					parameterMaintenanceValuemensaje.setValue(mensajecorreoinven.getmensaje());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuemensaje);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueaviso=new ParameterValue<String>();
					parameterMaintenanceValueaviso.setValue(mensajecorreoinven.getaviso());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueaviso);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValueesta_activo=new ParameterValue<Boolean>();
					parameterMaintenanceValueesta_activo.setValue(mensajecorreoinven.getesta_activo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueesta_activo);
					parametersTemp.add(parameterMaintenance);
					
						if(!mensajecorreoinven.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(mensajecorreoinven.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(mensajecorreoinven.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(mensajecorreoinven.getId());
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
	
	public void setIsNewIsChangedFalseMensajeCorreoInven(MensajeCorreoInven mensajecorreoinven)throws Exception  {		
		mensajecorreoinven.setIsNew(false);
		mensajecorreoinven.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseMensajeCorreoInvens(List<MensajeCorreoInven> mensajecorreoinvens)throws Exception  {				
		for(MensajeCorreoInven mensajecorreoinven:mensajecorreoinvens) {
			mensajecorreoinven.setIsNew(false);
			mensajecorreoinven.setIsChanged(false);
		}
	}
	
	public void generarExportarMensajeCorreoInven(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
