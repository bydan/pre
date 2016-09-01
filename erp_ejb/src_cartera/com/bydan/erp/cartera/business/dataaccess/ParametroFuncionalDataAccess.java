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
import com.bydan.erp.cartera.util.*;//ParametroFuncionalConstantesFunciones;










@SuppressWarnings("unused")
final public class ParametroFuncionalDataAccess extends  ParametroFuncionalDataAccessAdditional{ //ParametroFuncionalDataAccessAdditional,DataAccessHelper<ParametroFuncional>
	//static Logger logger = Logger.getLogger(ParametroFuncionalDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="parametro_funcional";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ParametroFuncionalConstantesFunciones.SCHEMA+"."+ParametroFuncionalConstantesFunciones.TABLENAME+"(version_row,con_copia_clientes,con_copia_proveedor,con_proveedor_cliente)values(current_timestamp,?,?,?)";
	public static String QUERYUPDATE="update "+ParametroFuncionalConstantesFunciones.SCHEMA+"."+ParametroFuncionalConstantesFunciones.TABLENAME+" set version_row=current_timestamp,con_copia_clientes=?,con_copia_proveedor=?,con_proveedor_cliente=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ParametroFuncionalConstantesFunciones.SCHEMA+"."+ParametroFuncionalConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select parametrofuncional from "+ParametroFuncionalConstantesFunciones.SPERSISTENCENAME+" parametrofuncional";
	public static String QUERYSELECTNATIVE="select "+ParametroFuncionalConstantesFunciones.SCHEMA+"."+ParametroFuncionalConstantesFunciones.TABLENAME+".id,"+ParametroFuncionalConstantesFunciones.SCHEMA+"."+ParametroFuncionalConstantesFunciones.TABLENAME+".version_row,"+ParametroFuncionalConstantesFunciones.SCHEMA+"."+ParametroFuncionalConstantesFunciones.TABLENAME+".con_copia_clientes,"+ParametroFuncionalConstantesFunciones.SCHEMA+"."+ParametroFuncionalConstantesFunciones.TABLENAME+".con_copia_proveedor,"+ParametroFuncionalConstantesFunciones.SCHEMA+"."+ParametroFuncionalConstantesFunciones.TABLENAME+".con_proveedor_cliente from "+ParametroFuncionalConstantesFunciones.SCHEMA+"."+ParametroFuncionalConstantesFunciones.TABLENAME;//+" as "+ParametroFuncionalConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ParametroFuncionalConstantesFunciones.SCHEMA+"."+ParametroFuncionalConstantesFunciones.TABLENAME+".id,"+ParametroFuncionalConstantesFunciones.SCHEMA+"."+ParametroFuncionalConstantesFunciones.TABLENAME+".version_row from "+ParametroFuncionalConstantesFunciones.SCHEMA+"."+ParametroFuncionalConstantesFunciones.TABLENAME;//+" as "+ParametroFuncionalConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ParametroFuncionalConstantesFunciones.SCHEMA+"."+ParametroFuncionalConstantesFunciones.TABLENAME+" set version_row=current_timestamp,con_copia_clientes=?,con_copia_proveedor=?,con_proveedor_cliente=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PARAMETROFUNCIONAL_INSERT(?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PARAMETROFUNCIONAL_UPDATE(?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PARAMETROFUNCIONAL_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PARAMETROFUNCIONAL_SELECT(?,?)";
	
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
	
	
	protected ParametroFuncionalDataAccessAdditional parametrofuncionalDataAccessAdditional=null;
	
	public ParametroFuncionalDataAccessAdditional getParametroFuncionalDataAccessAdditional() {
		return this.parametrofuncionalDataAccessAdditional;
	}
	
	public void setParametroFuncionalDataAccessAdditional(ParametroFuncionalDataAccessAdditional parametrofuncionalDataAccessAdditional) {
		try {
			this.parametrofuncionalDataAccessAdditional=parametrofuncionalDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ParametroFuncionalDataAccess() {
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
		ParametroFuncionalDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ParametroFuncionalDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ParametroFuncionalDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setParametroFuncionalOriginal(ParametroFuncional parametrofuncional)throws Exception  {
		parametrofuncional.setParametroFuncionalOriginal((ParametroFuncional)parametrofuncional.clone());		
	}
	
	public void setParametroFuncionalsOriginal(List<ParametroFuncional> parametrofuncionals)throws Exception  {
		
		for(ParametroFuncional parametrofuncional:parametrofuncionals){
			parametrofuncional.setParametroFuncionalOriginal((ParametroFuncional)parametrofuncional.clone());
		}
	}
	
	public static void setParametroFuncionalOriginalStatic(ParametroFuncional parametrofuncional)throws Exception  {
		parametrofuncional.setParametroFuncionalOriginal((ParametroFuncional)parametrofuncional.clone());		
	}
	
	public static void setParametroFuncionalsOriginalStatic(List<ParametroFuncional> parametrofuncionals)throws Exception  {
		
		for(ParametroFuncional parametrofuncional:parametrofuncionals){
			parametrofuncional.setParametroFuncionalOriginal((ParametroFuncional)parametrofuncional.clone());
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
	
	public  ParametroFuncional getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		ParametroFuncional entity = new ParametroFuncional();		
		
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
	
	public  ParametroFuncional getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		ParametroFuncional entity = new ParametroFuncional();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroFuncionalDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroFuncionalDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Cartera.ParametroFuncional.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setParametroFuncionalOriginal(new ParametroFuncional());
      	    	entity=super.getEntity("",entity,resultSet,ParametroFuncionalDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityParametroFuncional("",entity,resultSet); 
				
				//entity.setParametroFuncionalOriginal(super.getEntity("",entity.getParametroFuncionalOriginal(),resultSet,ParametroFuncionalDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroFuncionalOriginal(this.getEntityParametroFuncional("",entity.getParametroFuncionalOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseParametroFuncional(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  ParametroFuncional getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ParametroFuncional entity = new ParametroFuncional();
				
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
	
	public  ParametroFuncional getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ParametroFuncional entity = new ParametroFuncional();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroFuncionalDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroFuncionalDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroFuncionalDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.ParametroFuncional.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setParametroFuncionalOriginal(new ParametroFuncional());
      	    	entity=super.getEntity("",entity,resultSet,ParametroFuncionalDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityParametroFuncional("",entity,resultSet);    
				
				//entity.setParametroFuncionalOriginal(super.getEntity("",entity.getParametroFuncionalOriginal(),resultSet,ParametroFuncionalDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroFuncionalOriginal(this.getEntityParametroFuncional("",entity.getParametroFuncionalOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseParametroFuncional(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //ParametroFuncional
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		ParametroFuncional entity = new ParametroFuncional();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroFuncionalDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroFuncionalDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroFuncionalDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.ParametroFuncional.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseParametroFuncional(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<ParametroFuncional> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ParametroFuncional> entities = new  ArrayList<ParametroFuncional>();
		ParametroFuncional entity = new ParametroFuncional();		  
		
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
	
	public  List<ParametroFuncional> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ParametroFuncional> entities = new  ArrayList<ParametroFuncional>();
		ParametroFuncional entity = new ParametroFuncional();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroFuncionalDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroFuncionalDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroFuncionalDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroFuncional();
      	    	entity=super.getEntity("",entity,resultSet,ParametroFuncionalDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroFuncional("",entity,resultSet);
      	    	
				//entity.setParametroFuncionalOriginal( new ParametroFuncional());
      	    	//entity.setParametroFuncionalOriginal(super.getEntity("",entity.getParametroFuncionalOriginal(),resultSet,ParametroFuncionalDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroFuncionalOriginal(this.getEntityParametroFuncional("",entity.getParametroFuncionalOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroFuncionals(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroFuncional(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ParametroFuncional> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ParametroFuncional> entities = new  ArrayList<ParametroFuncional>();
		ParametroFuncional entity = new ParametroFuncional();		  
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
	
	public  List<ParametroFuncional> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ParametroFuncional> entities = new  ArrayList<ParametroFuncional>();
		ParametroFuncional entity = new ParametroFuncional();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroFuncional();
				
				if(conMapGenerico) {
					entity.inicializarMapParametroFuncional();
					//entity.setMapParametroFuncional(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapParametroFuncionalValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapParametroFuncional().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ParametroFuncionalDataAccess.ISWITHSCHEMA);         		
					entity=ParametroFuncionalDataAccess.getEntityParametroFuncional("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setParametroFuncionalOriginal( new ParametroFuncional());
					////entity.setParametroFuncionalOriginal(super.getEntity("",entity.getParametroFuncionalOriginal(),resultSet,ParametroFuncionalDataAccess.ISWITHSCHEMA));         		
					////entity.setParametroFuncionalOriginal(this.getEntityParametroFuncional("",entity.getParametroFuncionalOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroFuncionals(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroFuncional(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public ParametroFuncional getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ParametroFuncional entity = new ParametroFuncional();		  
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
	
	public  ParametroFuncional getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ParametroFuncional entity = new ParametroFuncional();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroFuncional();
				
				if(conMapGenerico) {
					entity.inicializarMapParametroFuncional();
					//entity.setMapParametroFuncional(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapParametroFuncionalValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapParametroFuncional().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ParametroFuncionalDataAccess.ISWITHSCHEMA);         		
					entity=ParametroFuncionalDataAccess.getEntityParametroFuncional("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setParametroFuncionalOriginal( new ParametroFuncional());
					////entity.setParametroFuncionalOriginal(super.getEntity("",entity.getParametroFuncionalOriginal(),resultSet,ParametroFuncionalDataAccess.ISWITHSCHEMA));         		
					////entity.setParametroFuncionalOriginal(this.getEntityParametroFuncional("",entity.getParametroFuncionalOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseParametroFuncional(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroFuncional(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ParametroFuncional getEntityParametroFuncional(String strPrefijo,ParametroFuncional entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = ParametroFuncional.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = ParametroFuncional.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ParametroFuncionalDataAccess.setFieldReflectionParametroFuncional(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasParametroFuncional=ParametroFuncionalConstantesFunciones.getTodosTiposColumnasParametroFuncional();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasParametroFuncional) {
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
							field = ParametroFuncional.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = ParametroFuncional.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ParametroFuncionalDataAccess.setFieldReflectionParametroFuncional(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionParametroFuncional(Field field,String strPrefijo,String sColumn,ParametroFuncional entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ParametroFuncionalConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroFuncionalConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ParametroFuncionalConstantesFunciones.CONCOPIACLIENTES:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroFuncionalConstantesFunciones.CONCOPIAPROVEEDOR:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroFuncionalConstantesFunciones.CONPROVEEDORCLIENTE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ParametroFuncional>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<ParametroFuncional> entities = new  ArrayList<ParametroFuncional>();
		ParametroFuncional entity = new ParametroFuncional();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroFuncionalDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroFuncionalDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroFuncionalDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new ParametroFuncional();
					entity=super.getEntity("",entity,resultSet,ParametroFuncionalDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityParametroFuncional("",entity,resultSet);
					
					//entity.setParametroFuncionalOriginal( new ParametroFuncional());
					//entity.setParametroFuncionalOriginal(super.getEntity("",entity.getParametroFuncionalOriginal(),resultSet,ParametroFuncionalDataAccess.ISWITHSCHEMA));         		
					//entity.setParametroFuncionalOriginal(this.getEntityParametroFuncional("",entity.getParametroFuncionalOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseParametroFuncionals(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroFuncional(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ParametroFuncional>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<ParametroFuncional> entities = new  ArrayList<ParametroFuncional>();
		ParametroFuncional entity = new ParametroFuncional();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroFuncionalDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroFuncionalDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroFuncionalDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<ParametroFuncional> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroFuncional> entities = new  ArrayList<ParametroFuncional>();
		ParametroFuncional entity = new ParametroFuncional();		  
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
	
	public  List<ParametroFuncional> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroFuncional> entities = new  ArrayList<ParametroFuncional>();
		ParametroFuncional entity = new ParametroFuncional();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroFuncional();
      	    	entity=super.getEntity("",entity,resultSet,ParametroFuncionalDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroFuncional("",entity,resultSet);
      	    	
				//entity.setParametroFuncionalOriginal( new ParametroFuncional());
      	    	//entity.setParametroFuncionalOriginal(super.getEntity("",entity.getParametroFuncionalOriginal(),resultSet,ParametroFuncionalDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroFuncionalOriginal(this.getEntityParametroFuncional("",entity.getParametroFuncionalOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseParametroFuncionals(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroFuncional(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ParametroFuncional> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroFuncional> entities = new  ArrayList<ParametroFuncional>();
		ParametroFuncional entity = new ParametroFuncional();		  
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
	
	public  List<ParametroFuncional> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroFuncional> entities = new  ArrayList<ParametroFuncional>();
		ParametroFuncional entity = new ParametroFuncional();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroFuncional();
      	    	entity=super.getEntity("",entity,resultSet,ParametroFuncionalDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroFuncional("",entity,resultSet);
      	    	
				//entity.setParametroFuncionalOriginal( new ParametroFuncional());
      	    	//entity.setParametroFuncionalOriginal(super.getEntity("",entity.getParametroFuncionalOriginal(),resultSet,ParametroFuncionalDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroFuncionalOriginal(this.getEntityParametroFuncional("",entity.getParametroFuncionalOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroFuncionals(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public ParametroFuncional getEntityParametroFuncional(String strPrefijo,ParametroFuncional entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setcon_copia_clientes(resultSet.getBoolean(strPrefijo+ParametroFuncionalConstantesFunciones.CONCOPIACLIENTES));
				entity.setcon_copia_proveedor(resultSet.getBoolean(strPrefijo+ParametroFuncionalConstantesFunciones.CONCOPIAPROVEEDOR));
				entity.setcon_proveedor_cliente(resultSet.getBoolean(strPrefijo+ParametroFuncionalConstantesFunciones.CONPROVEEDORCLIENTE));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowParametroFuncional(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(ParametroFuncional entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ParametroFuncionalDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ParametroFuncionalDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ParametroFuncionalDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ParametroFuncionalDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ParametroFuncionalConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ParametroFuncionalDataAccess.TABLENAME,ParametroFuncionalDataAccess.ISWITHSTOREPROCEDURES);
			
			ParametroFuncionalDataAccess.setParametroFuncionalOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
	
		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,ParametroFuncional parametrofuncional) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!parametrofuncional.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_copia_clientes=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_copia_clientes.setValue(parametrofuncional.getcon_copia_clientes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_copia_clientes);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_copia_proveedor=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_copia_proveedor.setValue(parametrofuncional.getcon_copia_proveedor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_copia_proveedor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_proveedor_cliente=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_proveedor_cliente.setValue(parametrofuncional.getcon_proveedor_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_proveedor_cliente);
					parametersTemp.add(parameterMaintenance);
					
						if(!parametrofuncional.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(parametrofuncional.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(parametrofuncional.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(parametrofuncional.getId());
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
	
	public void setIsNewIsChangedFalseParametroFuncional(ParametroFuncional parametrofuncional)throws Exception  {		
		parametrofuncional.setIsNew(false);
		parametrofuncional.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseParametroFuncionals(List<ParametroFuncional> parametrofuncionals)throws Exception  {				
		for(ParametroFuncional parametrofuncional:parametrofuncionals) {
			parametrofuncional.setIsNew(false);
			parametrofuncional.setIsChanged(false);
		}
	}
	
	public void generarExportarParametroFuncional(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
