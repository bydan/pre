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
package com.bydan.erp.contabilidad.business.dataaccess;

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

import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.contabilidad.util.*;//TipoFlujoEfectivoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class TipoFlujoEfectivoDataAccess extends  TipoFlujoEfectivoDataAccessAdditional{ //TipoFlujoEfectivoDataAccessAdditional,DataAccessHelper<TipoFlujoEfectivo>
	//static Logger logger = Logger.getLogger(TipoFlujoEfectivoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_flujo_efectivo";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoFlujoEfectivoConstantesFunciones.SCHEMA+"."+TipoFlujoEfectivoConstantesFunciones.TABLENAME+"(version_row,id_empresa,nombre)values(current_timestamp,?,?)";
	public static String QUERYUPDATE="update "+TipoFlujoEfectivoConstantesFunciones.SCHEMA+"."+TipoFlujoEfectivoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoFlujoEfectivoConstantesFunciones.SCHEMA+"."+TipoFlujoEfectivoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tipoflujoefectivo from "+TipoFlujoEfectivoConstantesFunciones.SPERSISTENCENAME+" tipoflujoefectivo";
	public static String QUERYSELECTNATIVE="select "+TipoFlujoEfectivoConstantesFunciones.SCHEMA+"."+TipoFlujoEfectivoConstantesFunciones.TABLENAME+".id,"+TipoFlujoEfectivoConstantesFunciones.SCHEMA+"."+TipoFlujoEfectivoConstantesFunciones.TABLENAME+".version_row,"+TipoFlujoEfectivoConstantesFunciones.SCHEMA+"."+TipoFlujoEfectivoConstantesFunciones.TABLENAME+".id_empresa,"+TipoFlujoEfectivoConstantesFunciones.SCHEMA+"."+TipoFlujoEfectivoConstantesFunciones.TABLENAME+".nombre from "+TipoFlujoEfectivoConstantesFunciones.SCHEMA+"."+TipoFlujoEfectivoConstantesFunciones.TABLENAME;//+" as "+TipoFlujoEfectivoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoFlujoEfectivoConstantesFunciones.SCHEMA+"."+TipoFlujoEfectivoConstantesFunciones.TABLENAME+".id,"+TipoFlujoEfectivoConstantesFunciones.SCHEMA+"."+TipoFlujoEfectivoConstantesFunciones.TABLENAME+".version_row,"+TipoFlujoEfectivoConstantesFunciones.SCHEMA+"."+TipoFlujoEfectivoConstantesFunciones.TABLENAME+".nombre from "+TipoFlujoEfectivoConstantesFunciones.SCHEMA+"."+TipoFlujoEfectivoConstantesFunciones.TABLENAME;//+" as "+TipoFlujoEfectivoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoFlujoEfectivoConstantesFunciones.SCHEMA+"."+TipoFlujoEfectivoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPOFLUJOEFECTIVO_INSERT(?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPOFLUJOEFECTIVO_UPDATE(?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPOFLUJOEFECTIVO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPOFLUJOEFECTIVO_SELECT(?,?)";
	
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
	
	
	protected TipoFlujoEfectivoDataAccessAdditional tipoflujoefectivoDataAccessAdditional=null;
	
	public TipoFlujoEfectivoDataAccessAdditional getTipoFlujoEfectivoDataAccessAdditional() {
		return this.tipoflujoefectivoDataAccessAdditional;
	}
	
	public void setTipoFlujoEfectivoDataAccessAdditional(TipoFlujoEfectivoDataAccessAdditional tipoflujoefectivoDataAccessAdditional) {
		try {
			this.tipoflujoefectivoDataAccessAdditional=tipoflujoefectivoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TipoFlujoEfectivoDataAccess() {
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
		TipoFlujoEfectivoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoFlujoEfectivoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoFlujoEfectivoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoFlujoEfectivoOriginal(TipoFlujoEfectivo tipoflujoefectivo)throws Exception  {
		tipoflujoefectivo.setTipoFlujoEfectivoOriginal((TipoFlujoEfectivo)tipoflujoefectivo.clone());		
	}
	
	public void setTipoFlujoEfectivosOriginal(List<TipoFlujoEfectivo> tipoflujoefectivos)throws Exception  {
		
		for(TipoFlujoEfectivo tipoflujoefectivo:tipoflujoefectivos){
			tipoflujoefectivo.setTipoFlujoEfectivoOriginal((TipoFlujoEfectivo)tipoflujoefectivo.clone());
		}
	}
	
	public static void setTipoFlujoEfectivoOriginalStatic(TipoFlujoEfectivo tipoflujoefectivo)throws Exception  {
		tipoflujoefectivo.setTipoFlujoEfectivoOriginal((TipoFlujoEfectivo)tipoflujoefectivo.clone());		
	}
	
	public static void setTipoFlujoEfectivosOriginalStatic(List<TipoFlujoEfectivo> tipoflujoefectivos)throws Exception  {
		
		for(TipoFlujoEfectivo tipoflujoefectivo:tipoflujoefectivos){
			tipoflujoefectivo.setTipoFlujoEfectivoOriginal((TipoFlujoEfectivo)tipoflujoefectivo.clone());
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
	
	public  TipoFlujoEfectivo getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoFlujoEfectivo entity = new TipoFlujoEfectivo();		
		
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
	
	public  TipoFlujoEfectivo getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoFlujoEfectivo entity = new TipoFlujoEfectivo();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoFlujoEfectivoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoFlujoEfectivoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Contabilidad.TipoFlujoEfectivo.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoFlujoEfectivoOriginal(new TipoFlujoEfectivo());
      	    	entity=super.getEntity("",entity,resultSet,TipoFlujoEfectivoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoFlujoEfectivo("",entity,resultSet); 
				
				//entity.setTipoFlujoEfectivoOriginal(super.getEntity("",entity.getTipoFlujoEfectivoOriginal(),resultSet,TipoFlujoEfectivoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoFlujoEfectivoOriginal(this.getEntityTipoFlujoEfectivo("",entity.getTipoFlujoEfectivoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoFlujoEfectivo(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoFlujoEfectivo getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoFlujoEfectivo entity = new TipoFlujoEfectivo();
				
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
	
	public  TipoFlujoEfectivo getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoFlujoEfectivo entity = new TipoFlujoEfectivo();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoFlujoEfectivoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoFlujoEfectivoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoFlujoEfectivoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.TipoFlujoEfectivo.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoFlujoEfectivoOriginal(new TipoFlujoEfectivo());
      	    	entity=super.getEntity("",entity,resultSet,TipoFlujoEfectivoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoFlujoEfectivo("",entity,resultSet);    
				
				//entity.setTipoFlujoEfectivoOriginal(super.getEntity("",entity.getTipoFlujoEfectivoOriginal(),resultSet,TipoFlujoEfectivoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoFlujoEfectivoOriginal(this.getEntityTipoFlujoEfectivo("",entity.getTipoFlujoEfectivoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoFlujoEfectivo(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoFlujoEfectivo
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoFlujoEfectivo entity = new TipoFlujoEfectivo();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoFlujoEfectivoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoFlujoEfectivoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoFlujoEfectivoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.TipoFlujoEfectivo.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoFlujoEfectivo(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoFlujoEfectivo> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoFlujoEfectivo> entities = new  ArrayList<TipoFlujoEfectivo>();
		TipoFlujoEfectivo entity = new TipoFlujoEfectivo();		  
		
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
	
	public  List<TipoFlujoEfectivo> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoFlujoEfectivo> entities = new  ArrayList<TipoFlujoEfectivo>();
		TipoFlujoEfectivo entity = new TipoFlujoEfectivo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoFlujoEfectivoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoFlujoEfectivoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoFlujoEfectivoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoFlujoEfectivo();
      	    	entity=super.getEntity("",entity,resultSet,TipoFlujoEfectivoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoFlujoEfectivo("",entity,resultSet);
      	    	
				//entity.setTipoFlujoEfectivoOriginal( new TipoFlujoEfectivo());
      	    	//entity.setTipoFlujoEfectivoOriginal(super.getEntity("",entity.getTipoFlujoEfectivoOriginal(),resultSet,TipoFlujoEfectivoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoFlujoEfectivoOriginal(this.getEntityTipoFlujoEfectivo("",entity.getTipoFlujoEfectivoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoFlujoEfectivos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoFlujoEfectivo(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoFlujoEfectivo> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoFlujoEfectivo> entities = new  ArrayList<TipoFlujoEfectivo>();
		TipoFlujoEfectivo entity = new TipoFlujoEfectivo();		  
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
	
	public  List<TipoFlujoEfectivo> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoFlujoEfectivo> entities = new  ArrayList<TipoFlujoEfectivo>();
		TipoFlujoEfectivo entity = new TipoFlujoEfectivo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoFlujoEfectivo();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoFlujoEfectivo();
					//entity.setMapTipoFlujoEfectivo(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoFlujoEfectivoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoFlujoEfectivo().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoFlujoEfectivoDataAccess.ISWITHSCHEMA);         		
					entity=TipoFlujoEfectivoDataAccess.getEntityTipoFlujoEfectivo("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoFlujoEfectivoOriginal( new TipoFlujoEfectivo());
					////entity.setTipoFlujoEfectivoOriginal(super.getEntity("",entity.getTipoFlujoEfectivoOriginal(),resultSet,TipoFlujoEfectivoDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoFlujoEfectivoOriginal(this.getEntityTipoFlujoEfectivo("",entity.getTipoFlujoEfectivoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoFlujoEfectivos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoFlujoEfectivo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoFlujoEfectivo getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoFlujoEfectivo entity = new TipoFlujoEfectivo();		  
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
	
	public  TipoFlujoEfectivo getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoFlujoEfectivo entity = new TipoFlujoEfectivo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoFlujoEfectivo();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoFlujoEfectivo();
					//entity.setMapTipoFlujoEfectivo(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoFlujoEfectivoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoFlujoEfectivo().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoFlujoEfectivoDataAccess.ISWITHSCHEMA);         		
					entity=TipoFlujoEfectivoDataAccess.getEntityTipoFlujoEfectivo("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoFlujoEfectivoOriginal( new TipoFlujoEfectivo());
					////entity.setTipoFlujoEfectivoOriginal(super.getEntity("",entity.getTipoFlujoEfectivoOriginal(),resultSet,TipoFlujoEfectivoDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoFlujoEfectivoOriginal(this.getEntityTipoFlujoEfectivo("",entity.getTipoFlujoEfectivoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoFlujoEfectivo(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoFlujoEfectivo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoFlujoEfectivo getEntityTipoFlujoEfectivo(String strPrefijo,TipoFlujoEfectivo entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoFlujoEfectivo.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoFlujoEfectivo.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoFlujoEfectivoDataAccess.setFieldReflectionTipoFlujoEfectivo(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoFlujoEfectivo=TipoFlujoEfectivoConstantesFunciones.getTodosTiposColumnasTipoFlujoEfectivo();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoFlujoEfectivo) {
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
							field = TipoFlujoEfectivo.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoFlujoEfectivo.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoFlujoEfectivoDataAccess.setFieldReflectionTipoFlujoEfectivo(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoFlujoEfectivo(Field field,String strPrefijo,String sColumn,TipoFlujoEfectivo entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoFlujoEfectivoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoFlujoEfectivoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoFlujoEfectivoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoFlujoEfectivoConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoFlujoEfectivo>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoFlujoEfectivo> entities = new  ArrayList<TipoFlujoEfectivo>();
		TipoFlujoEfectivo entity = new TipoFlujoEfectivo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoFlujoEfectivoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoFlujoEfectivoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoFlujoEfectivoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoFlujoEfectivo();
					entity=super.getEntity("",entity,resultSet,TipoFlujoEfectivoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoFlujoEfectivo("",entity,resultSet);
					
					//entity.setTipoFlujoEfectivoOriginal( new TipoFlujoEfectivo());
					//entity.setTipoFlujoEfectivoOriginal(super.getEntity("",entity.getTipoFlujoEfectivoOriginal(),resultSet,TipoFlujoEfectivoDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoFlujoEfectivoOriginal(this.getEntityTipoFlujoEfectivo("",entity.getTipoFlujoEfectivoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoFlujoEfectivos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoFlujoEfectivo(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoFlujoEfectivo>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoFlujoEfectivo> entities = new  ArrayList<TipoFlujoEfectivo>();
		TipoFlujoEfectivo entity = new TipoFlujoEfectivo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoFlujoEfectivoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoFlujoEfectivoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoFlujoEfectivoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoFlujoEfectivo> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoFlujoEfectivo> entities = new  ArrayList<TipoFlujoEfectivo>();
		TipoFlujoEfectivo entity = new TipoFlujoEfectivo();		  
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
	
	public  List<TipoFlujoEfectivo> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoFlujoEfectivo> entities = new  ArrayList<TipoFlujoEfectivo>();
		TipoFlujoEfectivo entity = new TipoFlujoEfectivo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoFlujoEfectivo();
      	    	entity=super.getEntity("",entity,resultSet,TipoFlujoEfectivoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoFlujoEfectivo("",entity,resultSet);
      	    	
				//entity.setTipoFlujoEfectivoOriginal( new TipoFlujoEfectivo());
      	    	//entity.setTipoFlujoEfectivoOriginal(super.getEntity("",entity.getTipoFlujoEfectivoOriginal(),resultSet,TipoFlujoEfectivoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoFlujoEfectivoOriginal(this.getEntityTipoFlujoEfectivo("",entity.getTipoFlujoEfectivoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoFlujoEfectivos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoFlujoEfectivo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoFlujoEfectivo> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoFlujoEfectivo> entities = new  ArrayList<TipoFlujoEfectivo>();
		TipoFlujoEfectivo entity = new TipoFlujoEfectivo();		  
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
	
	public  List<TipoFlujoEfectivo> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoFlujoEfectivo> entities = new  ArrayList<TipoFlujoEfectivo>();
		TipoFlujoEfectivo entity = new TipoFlujoEfectivo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoFlujoEfectivo();
      	    	entity=super.getEntity("",entity,resultSet,TipoFlujoEfectivoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoFlujoEfectivo("",entity,resultSet);
      	    	
				//entity.setTipoFlujoEfectivoOriginal( new TipoFlujoEfectivo());
      	    	//entity.setTipoFlujoEfectivoOriginal(super.getEntity("",entity.getTipoFlujoEfectivoOriginal(),resultSet,TipoFlujoEfectivoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoFlujoEfectivoOriginal(this.getEntityTipoFlujoEfectivo("",entity.getTipoFlujoEfectivoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoFlujoEfectivos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public TipoFlujoEfectivo getEntityTipoFlujoEfectivo(String strPrefijo,TipoFlujoEfectivo entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+TipoFlujoEfectivoConstantesFunciones.IDEMPRESA));
				entity.setnombre(resultSet.getString(strPrefijo+TipoFlujoEfectivoConstantesFunciones.NOMBRE));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+TipoFlujoEfectivoConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoFlujoEfectivo(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoFlujoEfectivo entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoFlujoEfectivoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoFlujoEfectivoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoFlujoEfectivoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoFlujoEfectivoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoFlujoEfectivoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,TipoFlujoEfectivoDataAccess.TABLENAME,TipoFlujoEfectivoDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoFlujoEfectivoDataAccess.setTipoFlujoEfectivoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,TipoFlujoEfectivo reltipoflujoefectivo)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reltipoflujoefectivo.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}


		
		public List<CuentaContable> getCuentaContables(Connexion connexion,TipoFlujoEfectivo tipoflujoefectivo)throws SQLException,Exception {

		List<CuentaContable> cuentacontables= new ArrayList<CuentaContable>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoFlujoEfectivoConstantesFunciones.SCHEMA+".tipo_flujo_efectivo ON "+CuentaContableConstantesFunciones.SCHEMA+".cuenta_contable.id_tipo_flujo_efectivo="+TipoFlujoEfectivoConstantesFunciones.SCHEMA+".tipo_flujo_efectivo.id WHERE "+TipoFlujoEfectivoConstantesFunciones.SCHEMA+".tipo_flujo_efectivo.id="+String.valueOf(tipoflujoefectivo.getId());
			} else {
				sQuery=" INNER JOIN cuentacontable.TipoFlujoEfectivo WHERE cuentacontable.TipoFlujoEfectivo.id="+String.valueOf(tipoflujoefectivo.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);
			cuentacontables=cuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontables;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoFlujoEfectivo tipoflujoefectivo) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tipoflujoefectivo.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(tipoflujoefectivo.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tipoflujoefectivo.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!tipoflujoefectivo.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tipoflujoefectivo.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tipoflujoefectivo.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tipoflujoefectivo.getId());
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
	
	public void setIsNewIsChangedFalseTipoFlujoEfectivo(TipoFlujoEfectivo tipoflujoefectivo)throws Exception  {		
		tipoflujoefectivo.setIsNew(false);
		tipoflujoefectivo.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoFlujoEfectivos(List<TipoFlujoEfectivo> tipoflujoefectivos)throws Exception  {				
		for(TipoFlujoEfectivo tipoflujoefectivo:tipoflujoefectivos) {
			tipoflujoefectivo.setIsNew(false);
			tipoflujoefectivo.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoFlujoEfectivo(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
