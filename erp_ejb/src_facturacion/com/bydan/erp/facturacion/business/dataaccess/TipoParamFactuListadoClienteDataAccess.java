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
package com.bydan.erp.facturacion.business.dataaccess;

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
import com.bydan.framework.erp.business.dataaccess.DataAccessHelperSinIdGenerated;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.facturacion.util.*;//TipoParamFactuListadoClienteConstantesFunciones;










@SuppressWarnings("unused")
final public class TipoParamFactuListadoClienteDataAccess extends  TipoParamFactuListadoClienteDataAccessAdditional{ //TipoParamFactuListadoClienteDataAccessAdditional,DataAccessHelper<TipoParamFactuListadoCliente>
	//static Logger logger = Logger.getLogger(TipoParamFactuListadoClienteDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_param_factu_listado_cliente";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoParamFactuListadoClienteConstantesFunciones.SCHEMA+"."+TipoParamFactuListadoClienteConstantesFunciones.TABLENAME+"(id,version_row,nombre)values(?,current_timestamp,?)";
	public static String QUERYUPDATE="update "+TipoParamFactuListadoClienteConstantesFunciones.SCHEMA+"."+TipoParamFactuListadoClienteConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoParamFactuListadoClienteConstantesFunciones.SCHEMA+"."+TipoParamFactuListadoClienteConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tipoparamfactulistadocliente from "+TipoParamFactuListadoClienteConstantesFunciones.SPERSISTENCENAME+" tipoparamfactulistadocliente";
	public static String QUERYSELECTNATIVE="select "+TipoParamFactuListadoClienteConstantesFunciones.SCHEMA+"."+TipoParamFactuListadoClienteConstantesFunciones.TABLENAME+".id,"+TipoParamFactuListadoClienteConstantesFunciones.SCHEMA+"."+TipoParamFactuListadoClienteConstantesFunciones.TABLENAME+".version_row,"+TipoParamFactuListadoClienteConstantesFunciones.SCHEMA+"."+TipoParamFactuListadoClienteConstantesFunciones.TABLENAME+".nombre from "+TipoParamFactuListadoClienteConstantesFunciones.SCHEMA+"."+TipoParamFactuListadoClienteConstantesFunciones.TABLENAME;//+" as "+TipoParamFactuListadoClienteConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoParamFactuListadoClienteConstantesFunciones.SCHEMA+"."+TipoParamFactuListadoClienteConstantesFunciones.TABLENAME+".id,"+TipoParamFactuListadoClienteConstantesFunciones.SCHEMA+"."+TipoParamFactuListadoClienteConstantesFunciones.TABLENAME+".version_row,"+TipoParamFactuListadoClienteConstantesFunciones.SCHEMA+"."+TipoParamFactuListadoClienteConstantesFunciones.TABLENAME+".nombre from "+TipoParamFactuListadoClienteConstantesFunciones.SCHEMA+"."+TipoParamFactuListadoClienteConstantesFunciones.TABLENAME;//+" as "+TipoParamFactuListadoClienteConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoParamFactuListadoClienteConstantesFunciones.SCHEMA+"."+TipoParamFactuListadoClienteConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPOPARAMFACTULISTADOCLIENTE_INSERT(?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPOPARAMFACTULISTADOCLIENTE_UPDATE(? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPOPARAMFACTULISTADOCLIENTE_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPOPARAMFACTULISTADOCLIENTE_SELECT(?,?)";
	
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
	
	
	protected TipoParamFactuListadoClienteDataAccessAdditional tipoparamfactulistadoclienteDataAccessAdditional=null;
	
	public TipoParamFactuListadoClienteDataAccessAdditional getTipoParamFactuListadoClienteDataAccessAdditional() {
		return this.tipoparamfactulistadoclienteDataAccessAdditional;
	}
	
	public void setTipoParamFactuListadoClienteDataAccessAdditional(TipoParamFactuListadoClienteDataAccessAdditional tipoparamfactulistadoclienteDataAccessAdditional) {
		try {
			this.tipoparamfactulistadoclienteDataAccessAdditional=tipoparamfactulistadoclienteDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TipoParamFactuListadoClienteDataAccess() {
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
		TipoParamFactuListadoClienteDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoParamFactuListadoClienteDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoParamFactuListadoClienteDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoParamFactuListadoClienteOriginal(TipoParamFactuListadoCliente tipoparamfactulistadocliente)throws Exception  {
		tipoparamfactulistadocliente.setTipoParamFactuListadoClienteOriginal((TipoParamFactuListadoCliente)tipoparamfactulistadocliente.clone());		
	}
	
	public void setTipoParamFactuListadoClientesOriginal(List<TipoParamFactuListadoCliente> tipoparamfactulistadoclientes)throws Exception  {
		
		for(TipoParamFactuListadoCliente tipoparamfactulistadocliente:tipoparamfactulistadoclientes){
			tipoparamfactulistadocliente.setTipoParamFactuListadoClienteOriginal((TipoParamFactuListadoCliente)tipoparamfactulistadocliente.clone());
		}
	}
	
	public static void setTipoParamFactuListadoClienteOriginalStatic(TipoParamFactuListadoCliente tipoparamfactulistadocliente)throws Exception  {
		tipoparamfactulistadocliente.setTipoParamFactuListadoClienteOriginal((TipoParamFactuListadoCliente)tipoparamfactulistadocliente.clone());		
	}
	
	public static void setTipoParamFactuListadoClientesOriginalStatic(List<TipoParamFactuListadoCliente> tipoparamfactulistadoclientes)throws Exception  {
		
		for(TipoParamFactuListadoCliente tipoparamfactulistadocliente:tipoparamfactulistadoclientes){
			tipoparamfactulistadocliente.setTipoParamFactuListadoClienteOriginal((TipoParamFactuListadoCliente)tipoparamfactulistadocliente.clone());
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
	
	public  TipoParamFactuListadoCliente getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoParamFactuListadoCliente entity = new TipoParamFactuListadoCliente();		
		
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
	
	public  TipoParamFactuListadoCliente getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoParamFactuListadoCliente entity = new TipoParamFactuListadoCliente();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoParamFactuListadoClienteDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoParamFactuListadoClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Facturacion.TipoParamFactuListadoCliente.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoParamFactuListadoClienteOriginal(new TipoParamFactuListadoCliente());
      	    	entity=super.getEntity("",entity,resultSet,TipoParamFactuListadoClienteDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoParamFactuListadoCliente("",entity,resultSet); 
				
				//entity.setTipoParamFactuListadoClienteOriginal(super.getEntity("",entity.getTipoParamFactuListadoClienteOriginal(),resultSet,TipoParamFactuListadoClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoParamFactuListadoClienteOriginal(this.getEntityTipoParamFactuListadoCliente("",entity.getTipoParamFactuListadoClienteOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoParamFactuListadoCliente(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoParamFactuListadoCliente getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoParamFactuListadoCliente entity = new TipoParamFactuListadoCliente();
				
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
	
	public  TipoParamFactuListadoCliente getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoParamFactuListadoCliente entity = new TipoParamFactuListadoCliente();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoParamFactuListadoClienteDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoParamFactuListadoClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoParamFactuListadoClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.TipoParamFactuListadoCliente.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoParamFactuListadoClienteOriginal(new TipoParamFactuListadoCliente());
      	    	entity=super.getEntity("",entity,resultSet,TipoParamFactuListadoClienteDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoParamFactuListadoCliente("",entity,resultSet);    
				
				//entity.setTipoParamFactuListadoClienteOriginal(super.getEntity("",entity.getTipoParamFactuListadoClienteOriginal(),resultSet,TipoParamFactuListadoClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoParamFactuListadoClienteOriginal(this.getEntityTipoParamFactuListadoCliente("",entity.getTipoParamFactuListadoClienteOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoParamFactuListadoCliente(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoParamFactuListadoCliente
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoParamFactuListadoCliente entity = new TipoParamFactuListadoCliente();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoParamFactuListadoClienteDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoParamFactuListadoClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoParamFactuListadoClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.TipoParamFactuListadoCliente.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoParamFactuListadoCliente(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoParamFactuListadoCliente> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoParamFactuListadoCliente> entities = new  ArrayList<TipoParamFactuListadoCliente>();
		TipoParamFactuListadoCliente entity = new TipoParamFactuListadoCliente();		  
		
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
	
	public  List<TipoParamFactuListadoCliente> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoParamFactuListadoCliente> entities = new  ArrayList<TipoParamFactuListadoCliente>();
		TipoParamFactuListadoCliente entity = new TipoParamFactuListadoCliente();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoParamFactuListadoClienteDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoParamFactuListadoClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoParamFactuListadoClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoParamFactuListadoCliente();
      	    	entity=super.getEntity("",entity,resultSet,TipoParamFactuListadoClienteDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoParamFactuListadoCliente("",entity,resultSet);
      	    	
				//entity.setTipoParamFactuListadoClienteOriginal( new TipoParamFactuListadoCliente());
      	    	//entity.setTipoParamFactuListadoClienteOriginal(super.getEntity("",entity.getTipoParamFactuListadoClienteOriginal(),resultSet,TipoParamFactuListadoClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoParamFactuListadoClienteOriginal(this.getEntityTipoParamFactuListadoCliente("",entity.getTipoParamFactuListadoClienteOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoParamFactuListadoClientes(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoParamFactuListadoCliente(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoParamFactuListadoCliente> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoParamFactuListadoCliente> entities = new  ArrayList<TipoParamFactuListadoCliente>();
		TipoParamFactuListadoCliente entity = new TipoParamFactuListadoCliente();		  
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
	
	public  List<TipoParamFactuListadoCliente> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoParamFactuListadoCliente> entities = new  ArrayList<TipoParamFactuListadoCliente>();
		TipoParamFactuListadoCliente entity = new TipoParamFactuListadoCliente();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoParamFactuListadoCliente();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoParamFactuListadoCliente();
					//entity.setMapTipoParamFactuListadoCliente(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoParamFactuListadoClienteValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoParamFactuListadoCliente().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoParamFactuListadoClienteDataAccess.ISWITHSCHEMA);         		
					entity=TipoParamFactuListadoClienteDataAccess.getEntityTipoParamFactuListadoCliente("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoParamFactuListadoClienteOriginal( new TipoParamFactuListadoCliente());
					////entity.setTipoParamFactuListadoClienteOriginal(super.getEntity("",entity.getTipoParamFactuListadoClienteOriginal(),resultSet,TipoParamFactuListadoClienteDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoParamFactuListadoClienteOriginal(this.getEntityTipoParamFactuListadoCliente("",entity.getTipoParamFactuListadoClienteOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoParamFactuListadoClientes(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoParamFactuListadoCliente(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoParamFactuListadoCliente getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoParamFactuListadoCliente entity = new TipoParamFactuListadoCliente();		  
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
	
	public  TipoParamFactuListadoCliente getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoParamFactuListadoCliente entity = new TipoParamFactuListadoCliente();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoParamFactuListadoCliente();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoParamFactuListadoCliente();
					//entity.setMapTipoParamFactuListadoCliente(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoParamFactuListadoClienteValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoParamFactuListadoCliente().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoParamFactuListadoClienteDataAccess.ISWITHSCHEMA);         		
					entity=TipoParamFactuListadoClienteDataAccess.getEntityTipoParamFactuListadoCliente("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoParamFactuListadoClienteOriginal( new TipoParamFactuListadoCliente());
					////entity.setTipoParamFactuListadoClienteOriginal(super.getEntity("",entity.getTipoParamFactuListadoClienteOriginal(),resultSet,TipoParamFactuListadoClienteDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoParamFactuListadoClienteOriginal(this.getEntityTipoParamFactuListadoCliente("",entity.getTipoParamFactuListadoClienteOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoParamFactuListadoCliente(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoParamFactuListadoCliente(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoParamFactuListadoCliente getEntityTipoParamFactuListadoCliente(String strPrefijo,TipoParamFactuListadoCliente entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoParamFactuListadoCliente.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoParamFactuListadoCliente.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoParamFactuListadoClienteDataAccess.setFieldReflectionTipoParamFactuListadoCliente(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoParamFactuListadoCliente=TipoParamFactuListadoClienteConstantesFunciones.getTodosTiposColumnasTipoParamFactuListadoCliente();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoParamFactuListadoCliente) {
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
							field = TipoParamFactuListadoCliente.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoParamFactuListadoCliente.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoParamFactuListadoClienteDataAccess.setFieldReflectionTipoParamFactuListadoCliente(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoParamFactuListadoCliente(Field field,String strPrefijo,String sColumn,TipoParamFactuListadoCliente entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoParamFactuListadoClienteConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoParamFactuListadoClienteConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoParamFactuListadoClienteConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoParamFactuListadoCliente>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoParamFactuListadoCliente> entities = new  ArrayList<TipoParamFactuListadoCliente>();
		TipoParamFactuListadoCliente entity = new TipoParamFactuListadoCliente();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoParamFactuListadoClienteDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoParamFactuListadoClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoParamFactuListadoClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoParamFactuListadoCliente();
					entity=super.getEntity("",entity,resultSet,TipoParamFactuListadoClienteDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoParamFactuListadoCliente("",entity,resultSet);
					
					//entity.setTipoParamFactuListadoClienteOriginal( new TipoParamFactuListadoCliente());
					//entity.setTipoParamFactuListadoClienteOriginal(super.getEntity("",entity.getTipoParamFactuListadoClienteOriginal(),resultSet,TipoParamFactuListadoClienteDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoParamFactuListadoClienteOriginal(this.getEntityTipoParamFactuListadoCliente("",entity.getTipoParamFactuListadoClienteOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoParamFactuListadoClientes(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoParamFactuListadoCliente(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoParamFactuListadoCliente>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoParamFactuListadoCliente> entities = new  ArrayList<TipoParamFactuListadoCliente>();
		TipoParamFactuListadoCliente entity = new TipoParamFactuListadoCliente();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoParamFactuListadoClienteDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoParamFactuListadoClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoParamFactuListadoClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoParamFactuListadoCliente> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoParamFactuListadoCliente> entities = new  ArrayList<TipoParamFactuListadoCliente>();
		TipoParamFactuListadoCliente entity = new TipoParamFactuListadoCliente();		  
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
	
	public  List<TipoParamFactuListadoCliente> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoParamFactuListadoCliente> entities = new  ArrayList<TipoParamFactuListadoCliente>();
		TipoParamFactuListadoCliente entity = new TipoParamFactuListadoCliente();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoParamFactuListadoCliente();
      	    	entity=super.getEntity("",entity,resultSet,TipoParamFactuListadoClienteDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoParamFactuListadoCliente("",entity,resultSet);
      	    	
				//entity.setTipoParamFactuListadoClienteOriginal( new TipoParamFactuListadoCliente());
      	    	//entity.setTipoParamFactuListadoClienteOriginal(super.getEntity("",entity.getTipoParamFactuListadoClienteOriginal(),resultSet,TipoParamFactuListadoClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoParamFactuListadoClienteOriginal(this.getEntityTipoParamFactuListadoCliente("",entity.getTipoParamFactuListadoClienteOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoParamFactuListadoClientes(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoParamFactuListadoCliente(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoParamFactuListadoCliente> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoParamFactuListadoCliente> entities = new  ArrayList<TipoParamFactuListadoCliente>();
		TipoParamFactuListadoCliente entity = new TipoParamFactuListadoCliente();		  
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
	
	public  List<TipoParamFactuListadoCliente> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoParamFactuListadoCliente> entities = new  ArrayList<TipoParamFactuListadoCliente>();
		TipoParamFactuListadoCliente entity = new TipoParamFactuListadoCliente();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoParamFactuListadoCliente();
      	    	entity=super.getEntity("",entity,resultSet,TipoParamFactuListadoClienteDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoParamFactuListadoCliente("",entity,resultSet);
      	    	
				//entity.setTipoParamFactuListadoClienteOriginal( new TipoParamFactuListadoCliente());
      	    	//entity.setTipoParamFactuListadoClienteOriginal(super.getEntity("",entity.getTipoParamFactuListadoClienteOriginal(),resultSet,TipoParamFactuListadoClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoParamFactuListadoClienteOriginal(this.getEntityTipoParamFactuListadoCliente("",entity.getTipoParamFactuListadoClienteOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoParamFactuListadoClientes(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public TipoParamFactuListadoCliente getEntityTipoParamFactuListadoCliente(String strPrefijo,TipoParamFactuListadoCliente entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setnombre(resultSet.getString(strPrefijo+TipoParamFactuListadoClienteConstantesFunciones.NOMBRE));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+TipoParamFactuListadoClienteConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoParamFactuListadoCliente(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoParamFactuListadoCliente entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoParamFactuListadoClienteDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoParamFactuListadoClienteDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoParamFactuListadoClienteDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoParamFactuListadoClienteDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoParamFactuListadoClienteConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,TipoParamFactuListadoClienteDataAccess.TABLENAME,TipoParamFactuListadoClienteDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoParamFactuListadoClienteDataAccess.setTipoParamFactuListadoClienteOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
	
		
		public List<ParametroFactuPrincipal> getParametroFactuPrincipals(Connexion connexion,TipoParamFactuListadoCliente tipoparamfactulistadocliente)throws SQLException,Exception {

		List<ParametroFactuPrincipal> parametrofactuprincipals= new ArrayList<ParametroFactuPrincipal>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoParamFactuListadoClienteConstantesFunciones.SCHEMA+".tipo_param_factu_listado_cliente ON "+ParametroFactuPrincipalConstantesFunciones.SCHEMA+".parametro_factu_principal.id_tipo_param_factu_listado_cliente="+TipoParamFactuListadoClienteConstantesFunciones.SCHEMA+".tipo_param_factu_listado_cliente.id WHERE "+TipoParamFactuListadoClienteConstantesFunciones.SCHEMA+".tipo_param_factu_listado_cliente.id="+String.valueOf(tipoparamfactulistadocliente.getId());
			} else {
				sQuery=" INNER JOIN parametrofactuprincipal.TipoParamFactuListadoCliente WHERE parametrofactuprincipal.TipoParamFactuListadoCliente.id="+String.valueOf(tipoparamfactulistadocliente.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ParametroFactuPrincipalDataAccess parametrofactuprincipalDataAccess=new ParametroFactuPrincipalDataAccess();

			parametrofactuprincipalDataAccess.setConnexionType(this.connexionType);
			parametrofactuprincipalDataAccess.setParameterDbType(this.parameterDbType);
			parametrofactuprincipals=parametrofactuprincipalDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return parametrofactuprincipals;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoParamFactuListadoCliente tipoparamfactulistadocliente) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tipoparamfactulistadocliente.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid=new ParameterValue<Long>();
					parameterMaintenanceValueid.setValue(tipoparamfactulistadocliente.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tipoparamfactulistadocliente.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!tipoparamfactulistadocliente.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tipoparamfactulistadocliente.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tipoparamfactulistadocliente.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tipoparamfactulistadocliente.getId());
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
	
	public void setIsNewIsChangedFalseTipoParamFactuListadoCliente(TipoParamFactuListadoCliente tipoparamfactulistadocliente)throws Exception  {		
		tipoparamfactulistadocliente.setIsNew(false);
		tipoparamfactulistadocliente.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoParamFactuListadoClientes(List<TipoParamFactuListadoCliente> tipoparamfactulistadoclientes)throws Exception  {				
		for(TipoParamFactuListadoCliente tipoparamfactulistadocliente:tipoparamfactulistadoclientes) {
			tipoparamfactulistadocliente.setIsNew(false);
			tipoparamfactulistadocliente.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoParamFactuListadoCliente(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
