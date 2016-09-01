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
import com.bydan.erp.facturacion.util.*;//TipoParamFactuSecuenciaTrabajoConstantesFunciones;










@SuppressWarnings("unused")
final public class TipoParamFactuSecuenciaTrabajoDataAccess extends  TipoParamFactuSecuenciaTrabajoDataAccessAdditional{ //TipoParamFactuSecuenciaTrabajoDataAccessAdditional,DataAccessHelper<TipoParamFactuSecuenciaTrabajo>
	//static Logger logger = Logger.getLogger(TipoParamFactuSecuenciaTrabajoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_param_factu_secuencia_trabajo";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoParamFactuSecuenciaTrabajoConstantesFunciones.SCHEMA+"."+TipoParamFactuSecuenciaTrabajoConstantesFunciones.TABLENAME+"(id,version_row,nombre)values(?,current_timestamp,?)";
	public static String QUERYUPDATE="update "+TipoParamFactuSecuenciaTrabajoConstantesFunciones.SCHEMA+"."+TipoParamFactuSecuenciaTrabajoConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoParamFactuSecuenciaTrabajoConstantesFunciones.SCHEMA+"."+TipoParamFactuSecuenciaTrabajoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tipoparamfactusecuenciatrabajo from "+TipoParamFactuSecuenciaTrabajoConstantesFunciones.SPERSISTENCENAME+" tipoparamfactusecuenciatrabajo";
	public static String QUERYSELECTNATIVE="select "+TipoParamFactuSecuenciaTrabajoConstantesFunciones.SCHEMA+"."+TipoParamFactuSecuenciaTrabajoConstantesFunciones.TABLENAME+".id,"+TipoParamFactuSecuenciaTrabajoConstantesFunciones.SCHEMA+"."+TipoParamFactuSecuenciaTrabajoConstantesFunciones.TABLENAME+".version_row,"+TipoParamFactuSecuenciaTrabajoConstantesFunciones.SCHEMA+"."+TipoParamFactuSecuenciaTrabajoConstantesFunciones.TABLENAME+".nombre from "+TipoParamFactuSecuenciaTrabajoConstantesFunciones.SCHEMA+"."+TipoParamFactuSecuenciaTrabajoConstantesFunciones.TABLENAME;//+" as "+TipoParamFactuSecuenciaTrabajoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoParamFactuSecuenciaTrabajoConstantesFunciones.SCHEMA+"."+TipoParamFactuSecuenciaTrabajoConstantesFunciones.TABLENAME+".id,"+TipoParamFactuSecuenciaTrabajoConstantesFunciones.SCHEMA+"."+TipoParamFactuSecuenciaTrabajoConstantesFunciones.TABLENAME+".version_row,"+TipoParamFactuSecuenciaTrabajoConstantesFunciones.SCHEMA+"."+TipoParamFactuSecuenciaTrabajoConstantesFunciones.TABLENAME+".nombre from "+TipoParamFactuSecuenciaTrabajoConstantesFunciones.SCHEMA+"."+TipoParamFactuSecuenciaTrabajoConstantesFunciones.TABLENAME;//+" as "+TipoParamFactuSecuenciaTrabajoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoParamFactuSecuenciaTrabajoConstantesFunciones.SCHEMA+"."+TipoParamFactuSecuenciaTrabajoConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPOPARAMFACTUSECUENCIATRABAJO_INSERT(?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPOPARAMFACTUSECUENCIATRABAJO_UPDATE(? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPOPARAMFACTUSECUENCIATRABAJO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPOPARAMFACTUSECUENCIATRABAJO_SELECT(?,?)";
	
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
	
	
	protected TipoParamFactuSecuenciaTrabajoDataAccessAdditional tipoparamfactusecuenciatrabajoDataAccessAdditional=null;
	
	public TipoParamFactuSecuenciaTrabajoDataAccessAdditional getTipoParamFactuSecuenciaTrabajoDataAccessAdditional() {
		return this.tipoparamfactusecuenciatrabajoDataAccessAdditional;
	}
	
	public void setTipoParamFactuSecuenciaTrabajoDataAccessAdditional(TipoParamFactuSecuenciaTrabajoDataAccessAdditional tipoparamfactusecuenciatrabajoDataAccessAdditional) {
		try {
			this.tipoparamfactusecuenciatrabajoDataAccessAdditional=tipoparamfactusecuenciatrabajoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TipoParamFactuSecuenciaTrabajoDataAccess() {
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
		TipoParamFactuSecuenciaTrabajoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoParamFactuSecuenciaTrabajoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoParamFactuSecuenciaTrabajoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoParamFactuSecuenciaTrabajoOriginal(TipoParamFactuSecuenciaTrabajo tipoparamfactusecuenciatrabajo)throws Exception  {
		tipoparamfactusecuenciatrabajo.setTipoParamFactuSecuenciaTrabajoOriginal((TipoParamFactuSecuenciaTrabajo)tipoparamfactusecuenciatrabajo.clone());		
	}
	
	public void setTipoParamFactuSecuenciaTrabajosOriginal(List<TipoParamFactuSecuenciaTrabajo> tipoparamfactusecuenciatrabajos)throws Exception  {
		
		for(TipoParamFactuSecuenciaTrabajo tipoparamfactusecuenciatrabajo:tipoparamfactusecuenciatrabajos){
			tipoparamfactusecuenciatrabajo.setTipoParamFactuSecuenciaTrabajoOriginal((TipoParamFactuSecuenciaTrabajo)tipoparamfactusecuenciatrabajo.clone());
		}
	}
	
	public static void setTipoParamFactuSecuenciaTrabajoOriginalStatic(TipoParamFactuSecuenciaTrabajo tipoparamfactusecuenciatrabajo)throws Exception  {
		tipoparamfactusecuenciatrabajo.setTipoParamFactuSecuenciaTrabajoOriginal((TipoParamFactuSecuenciaTrabajo)tipoparamfactusecuenciatrabajo.clone());		
	}
	
	public static void setTipoParamFactuSecuenciaTrabajosOriginalStatic(List<TipoParamFactuSecuenciaTrabajo> tipoparamfactusecuenciatrabajos)throws Exception  {
		
		for(TipoParamFactuSecuenciaTrabajo tipoparamfactusecuenciatrabajo:tipoparamfactusecuenciatrabajos){
			tipoparamfactusecuenciatrabajo.setTipoParamFactuSecuenciaTrabajoOriginal((TipoParamFactuSecuenciaTrabajo)tipoparamfactusecuenciatrabajo.clone());
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
	
	public  TipoParamFactuSecuenciaTrabajo getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoParamFactuSecuenciaTrabajo entity = new TipoParamFactuSecuenciaTrabajo();		
		
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
	
	public  TipoParamFactuSecuenciaTrabajo getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoParamFactuSecuenciaTrabajo entity = new TipoParamFactuSecuenciaTrabajo();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoParamFactuSecuenciaTrabajoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoParamFactuSecuenciaTrabajoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Facturacion.TipoParamFactuSecuenciaTrabajo.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoParamFactuSecuenciaTrabajoOriginal(new TipoParamFactuSecuenciaTrabajo());
      	    	entity=super.getEntity("",entity,resultSet,TipoParamFactuSecuenciaTrabajoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoParamFactuSecuenciaTrabajo("",entity,resultSet); 
				
				//entity.setTipoParamFactuSecuenciaTrabajoOriginal(super.getEntity("",entity.getTipoParamFactuSecuenciaTrabajoOriginal(),resultSet,TipoParamFactuSecuenciaTrabajoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoParamFactuSecuenciaTrabajoOriginal(this.getEntityTipoParamFactuSecuenciaTrabajo("",entity.getTipoParamFactuSecuenciaTrabajoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoParamFactuSecuenciaTrabajo(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoParamFactuSecuenciaTrabajo getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoParamFactuSecuenciaTrabajo entity = new TipoParamFactuSecuenciaTrabajo();
				
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
	
	public  TipoParamFactuSecuenciaTrabajo getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoParamFactuSecuenciaTrabajo entity = new TipoParamFactuSecuenciaTrabajo();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoParamFactuSecuenciaTrabajoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoParamFactuSecuenciaTrabajoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoParamFactuSecuenciaTrabajoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.TipoParamFactuSecuenciaTrabajo.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoParamFactuSecuenciaTrabajoOriginal(new TipoParamFactuSecuenciaTrabajo());
      	    	entity=super.getEntity("",entity,resultSet,TipoParamFactuSecuenciaTrabajoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoParamFactuSecuenciaTrabajo("",entity,resultSet);    
				
				//entity.setTipoParamFactuSecuenciaTrabajoOriginal(super.getEntity("",entity.getTipoParamFactuSecuenciaTrabajoOriginal(),resultSet,TipoParamFactuSecuenciaTrabajoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoParamFactuSecuenciaTrabajoOriginal(this.getEntityTipoParamFactuSecuenciaTrabajo("",entity.getTipoParamFactuSecuenciaTrabajoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoParamFactuSecuenciaTrabajo(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoParamFactuSecuenciaTrabajo
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoParamFactuSecuenciaTrabajo entity = new TipoParamFactuSecuenciaTrabajo();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoParamFactuSecuenciaTrabajoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoParamFactuSecuenciaTrabajoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoParamFactuSecuenciaTrabajoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.TipoParamFactuSecuenciaTrabajo.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoParamFactuSecuenciaTrabajo(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoParamFactuSecuenciaTrabajo> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoParamFactuSecuenciaTrabajo> entities = new  ArrayList<TipoParamFactuSecuenciaTrabajo>();
		TipoParamFactuSecuenciaTrabajo entity = new TipoParamFactuSecuenciaTrabajo();		  
		
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
	
	public  List<TipoParamFactuSecuenciaTrabajo> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoParamFactuSecuenciaTrabajo> entities = new  ArrayList<TipoParamFactuSecuenciaTrabajo>();
		TipoParamFactuSecuenciaTrabajo entity = new TipoParamFactuSecuenciaTrabajo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoParamFactuSecuenciaTrabajoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoParamFactuSecuenciaTrabajoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoParamFactuSecuenciaTrabajoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoParamFactuSecuenciaTrabajo();
      	    	entity=super.getEntity("",entity,resultSet,TipoParamFactuSecuenciaTrabajoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoParamFactuSecuenciaTrabajo("",entity,resultSet);
      	    	
				//entity.setTipoParamFactuSecuenciaTrabajoOriginal( new TipoParamFactuSecuenciaTrabajo());
      	    	//entity.setTipoParamFactuSecuenciaTrabajoOriginal(super.getEntity("",entity.getTipoParamFactuSecuenciaTrabajoOriginal(),resultSet,TipoParamFactuSecuenciaTrabajoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoParamFactuSecuenciaTrabajoOriginal(this.getEntityTipoParamFactuSecuenciaTrabajo("",entity.getTipoParamFactuSecuenciaTrabajoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoParamFactuSecuenciaTrabajos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoParamFactuSecuenciaTrabajo(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoParamFactuSecuenciaTrabajo> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoParamFactuSecuenciaTrabajo> entities = new  ArrayList<TipoParamFactuSecuenciaTrabajo>();
		TipoParamFactuSecuenciaTrabajo entity = new TipoParamFactuSecuenciaTrabajo();		  
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
	
	public  List<TipoParamFactuSecuenciaTrabajo> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoParamFactuSecuenciaTrabajo> entities = new  ArrayList<TipoParamFactuSecuenciaTrabajo>();
		TipoParamFactuSecuenciaTrabajo entity = new TipoParamFactuSecuenciaTrabajo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoParamFactuSecuenciaTrabajo();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoParamFactuSecuenciaTrabajo();
					//entity.setMapTipoParamFactuSecuenciaTrabajo(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoParamFactuSecuenciaTrabajoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoParamFactuSecuenciaTrabajo().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoParamFactuSecuenciaTrabajoDataAccess.ISWITHSCHEMA);         		
					entity=TipoParamFactuSecuenciaTrabajoDataAccess.getEntityTipoParamFactuSecuenciaTrabajo("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoParamFactuSecuenciaTrabajoOriginal( new TipoParamFactuSecuenciaTrabajo());
					////entity.setTipoParamFactuSecuenciaTrabajoOriginal(super.getEntity("",entity.getTipoParamFactuSecuenciaTrabajoOriginal(),resultSet,TipoParamFactuSecuenciaTrabajoDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoParamFactuSecuenciaTrabajoOriginal(this.getEntityTipoParamFactuSecuenciaTrabajo("",entity.getTipoParamFactuSecuenciaTrabajoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoParamFactuSecuenciaTrabajos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoParamFactuSecuenciaTrabajo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoParamFactuSecuenciaTrabajo getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoParamFactuSecuenciaTrabajo entity = new TipoParamFactuSecuenciaTrabajo();		  
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
	
	public  TipoParamFactuSecuenciaTrabajo getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoParamFactuSecuenciaTrabajo entity = new TipoParamFactuSecuenciaTrabajo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoParamFactuSecuenciaTrabajo();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoParamFactuSecuenciaTrabajo();
					//entity.setMapTipoParamFactuSecuenciaTrabajo(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoParamFactuSecuenciaTrabajoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoParamFactuSecuenciaTrabajo().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoParamFactuSecuenciaTrabajoDataAccess.ISWITHSCHEMA);         		
					entity=TipoParamFactuSecuenciaTrabajoDataAccess.getEntityTipoParamFactuSecuenciaTrabajo("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoParamFactuSecuenciaTrabajoOriginal( new TipoParamFactuSecuenciaTrabajo());
					////entity.setTipoParamFactuSecuenciaTrabajoOriginal(super.getEntity("",entity.getTipoParamFactuSecuenciaTrabajoOriginal(),resultSet,TipoParamFactuSecuenciaTrabajoDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoParamFactuSecuenciaTrabajoOriginal(this.getEntityTipoParamFactuSecuenciaTrabajo("",entity.getTipoParamFactuSecuenciaTrabajoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoParamFactuSecuenciaTrabajo(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoParamFactuSecuenciaTrabajo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoParamFactuSecuenciaTrabajo getEntityTipoParamFactuSecuenciaTrabajo(String strPrefijo,TipoParamFactuSecuenciaTrabajo entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoParamFactuSecuenciaTrabajo.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoParamFactuSecuenciaTrabajo.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoParamFactuSecuenciaTrabajoDataAccess.setFieldReflectionTipoParamFactuSecuenciaTrabajo(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoParamFactuSecuenciaTrabajo=TipoParamFactuSecuenciaTrabajoConstantesFunciones.getTodosTiposColumnasTipoParamFactuSecuenciaTrabajo();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoParamFactuSecuenciaTrabajo) {
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
							field = TipoParamFactuSecuenciaTrabajo.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoParamFactuSecuenciaTrabajo.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoParamFactuSecuenciaTrabajoDataAccess.setFieldReflectionTipoParamFactuSecuenciaTrabajo(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoParamFactuSecuenciaTrabajo(Field field,String strPrefijo,String sColumn,TipoParamFactuSecuenciaTrabajo entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoParamFactuSecuenciaTrabajoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoParamFactuSecuenciaTrabajoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoParamFactuSecuenciaTrabajoConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoParamFactuSecuenciaTrabajo>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoParamFactuSecuenciaTrabajo> entities = new  ArrayList<TipoParamFactuSecuenciaTrabajo>();
		TipoParamFactuSecuenciaTrabajo entity = new TipoParamFactuSecuenciaTrabajo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoParamFactuSecuenciaTrabajoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoParamFactuSecuenciaTrabajoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoParamFactuSecuenciaTrabajoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoParamFactuSecuenciaTrabajo();
					entity=super.getEntity("",entity,resultSet,TipoParamFactuSecuenciaTrabajoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoParamFactuSecuenciaTrabajo("",entity,resultSet);
					
					//entity.setTipoParamFactuSecuenciaTrabajoOriginal( new TipoParamFactuSecuenciaTrabajo());
					//entity.setTipoParamFactuSecuenciaTrabajoOriginal(super.getEntity("",entity.getTipoParamFactuSecuenciaTrabajoOriginal(),resultSet,TipoParamFactuSecuenciaTrabajoDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoParamFactuSecuenciaTrabajoOriginal(this.getEntityTipoParamFactuSecuenciaTrabajo("",entity.getTipoParamFactuSecuenciaTrabajoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoParamFactuSecuenciaTrabajos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoParamFactuSecuenciaTrabajo(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoParamFactuSecuenciaTrabajo>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoParamFactuSecuenciaTrabajo> entities = new  ArrayList<TipoParamFactuSecuenciaTrabajo>();
		TipoParamFactuSecuenciaTrabajo entity = new TipoParamFactuSecuenciaTrabajo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoParamFactuSecuenciaTrabajoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoParamFactuSecuenciaTrabajoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoParamFactuSecuenciaTrabajoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoParamFactuSecuenciaTrabajo> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoParamFactuSecuenciaTrabajo> entities = new  ArrayList<TipoParamFactuSecuenciaTrabajo>();
		TipoParamFactuSecuenciaTrabajo entity = new TipoParamFactuSecuenciaTrabajo();		  
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
	
	public  List<TipoParamFactuSecuenciaTrabajo> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoParamFactuSecuenciaTrabajo> entities = new  ArrayList<TipoParamFactuSecuenciaTrabajo>();
		TipoParamFactuSecuenciaTrabajo entity = new TipoParamFactuSecuenciaTrabajo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoParamFactuSecuenciaTrabajo();
      	    	entity=super.getEntity("",entity,resultSet,TipoParamFactuSecuenciaTrabajoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoParamFactuSecuenciaTrabajo("",entity,resultSet);
      	    	
				//entity.setTipoParamFactuSecuenciaTrabajoOriginal( new TipoParamFactuSecuenciaTrabajo());
      	    	//entity.setTipoParamFactuSecuenciaTrabajoOriginal(super.getEntity("",entity.getTipoParamFactuSecuenciaTrabajoOriginal(),resultSet,TipoParamFactuSecuenciaTrabajoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoParamFactuSecuenciaTrabajoOriginal(this.getEntityTipoParamFactuSecuenciaTrabajo("",entity.getTipoParamFactuSecuenciaTrabajoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoParamFactuSecuenciaTrabajos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoParamFactuSecuenciaTrabajo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoParamFactuSecuenciaTrabajo> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoParamFactuSecuenciaTrabajo> entities = new  ArrayList<TipoParamFactuSecuenciaTrabajo>();
		TipoParamFactuSecuenciaTrabajo entity = new TipoParamFactuSecuenciaTrabajo();		  
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
	
	public  List<TipoParamFactuSecuenciaTrabajo> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoParamFactuSecuenciaTrabajo> entities = new  ArrayList<TipoParamFactuSecuenciaTrabajo>();
		TipoParamFactuSecuenciaTrabajo entity = new TipoParamFactuSecuenciaTrabajo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoParamFactuSecuenciaTrabajo();
      	    	entity=super.getEntity("",entity,resultSet,TipoParamFactuSecuenciaTrabajoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoParamFactuSecuenciaTrabajo("",entity,resultSet);
      	    	
				//entity.setTipoParamFactuSecuenciaTrabajoOriginal( new TipoParamFactuSecuenciaTrabajo());
      	    	//entity.setTipoParamFactuSecuenciaTrabajoOriginal(super.getEntity("",entity.getTipoParamFactuSecuenciaTrabajoOriginal(),resultSet,TipoParamFactuSecuenciaTrabajoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoParamFactuSecuenciaTrabajoOriginal(this.getEntityTipoParamFactuSecuenciaTrabajo("",entity.getTipoParamFactuSecuenciaTrabajoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoParamFactuSecuenciaTrabajos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public TipoParamFactuSecuenciaTrabajo getEntityTipoParamFactuSecuenciaTrabajo(String strPrefijo,TipoParamFactuSecuenciaTrabajo entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setnombre(resultSet.getString(strPrefijo+TipoParamFactuSecuenciaTrabajoConstantesFunciones.NOMBRE));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+TipoParamFactuSecuenciaTrabajoConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoParamFactuSecuenciaTrabajo(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoParamFactuSecuenciaTrabajo entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoParamFactuSecuenciaTrabajoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoParamFactuSecuenciaTrabajoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoParamFactuSecuenciaTrabajoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoParamFactuSecuenciaTrabajoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoParamFactuSecuenciaTrabajoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,TipoParamFactuSecuenciaTrabajoDataAccess.TABLENAME,TipoParamFactuSecuenciaTrabajoDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoParamFactuSecuenciaTrabajoDataAccess.setTipoParamFactuSecuenciaTrabajoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
	
		
		public List<ParametroFactuPrincipal> getParametroFactuPrincipals(Connexion connexion,TipoParamFactuSecuenciaTrabajo tipoparamfactusecuenciatrabajo)throws SQLException,Exception {

		List<ParametroFactuPrincipal> parametrofactuprincipals= new ArrayList<ParametroFactuPrincipal>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoParamFactuSecuenciaTrabajoConstantesFunciones.SCHEMA+".tipo_param_factu_secuencia_trabajo ON "+ParametroFactuPrincipalConstantesFunciones.SCHEMA+".parametro_factu_principal.id_tipo_param_factu_secuencia_trabajo="+TipoParamFactuSecuenciaTrabajoConstantesFunciones.SCHEMA+".tipo_param_factu_secuencia_trabajo.id WHERE "+TipoParamFactuSecuenciaTrabajoConstantesFunciones.SCHEMA+".tipo_param_factu_secuencia_trabajo.id="+String.valueOf(tipoparamfactusecuenciatrabajo.getId());
			} else {
				sQuery=" INNER JOIN parametrofactuprincipal.TipoParamFactuSecuenciaTrabajo WHERE parametrofactuprincipal.TipoParamFactuSecuenciaTrabajo.id="+String.valueOf(tipoparamfactusecuenciatrabajo.getId());

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


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoParamFactuSecuenciaTrabajo tipoparamfactusecuenciatrabajo) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tipoparamfactusecuenciatrabajo.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid=new ParameterValue<Long>();
					parameterMaintenanceValueid.setValue(tipoparamfactusecuenciatrabajo.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tipoparamfactusecuenciatrabajo.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!tipoparamfactusecuenciatrabajo.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tipoparamfactusecuenciatrabajo.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tipoparamfactusecuenciatrabajo.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tipoparamfactusecuenciatrabajo.getId());
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
	
	public void setIsNewIsChangedFalseTipoParamFactuSecuenciaTrabajo(TipoParamFactuSecuenciaTrabajo tipoparamfactusecuenciatrabajo)throws Exception  {		
		tipoparamfactusecuenciatrabajo.setIsNew(false);
		tipoparamfactusecuenciatrabajo.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoParamFactuSecuenciaTrabajos(List<TipoParamFactuSecuenciaTrabajo> tipoparamfactusecuenciatrabajos)throws Exception  {				
		for(TipoParamFactuSecuenciaTrabajo tipoparamfactusecuenciatrabajo:tipoparamfactusecuenciatrabajos) {
			tipoparamfactusecuenciatrabajo.setIsNew(false);
			tipoparamfactusecuenciatrabajo.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoParamFactuSecuenciaTrabajo(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
