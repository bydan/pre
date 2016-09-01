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
import com.bydan.framework.erp.business.dataaccess.DataAccessHelperSinIdGenerated;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.nomina.util.*;//TipoGrupoRubroEmpleaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class TipoGrupoRubroEmpleaDataAccess extends  DataAccessHelperSinIdGenerated<TipoGrupoRubroEmplea>{ //TipoGrupoRubroEmpleaDataAccessAdditional,DataAccessHelper<TipoGrupoRubroEmplea>
	//static Logger logger = Logger.getLogger(TipoGrupoRubroEmpleaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_grupo_rubro_emplea";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoGrupoRubroEmpleaConstantesFunciones.SCHEMA+"."+TipoGrupoRubroEmpleaConstantesFunciones.TABLENAME+"(id,version_row,codigo,nombre)values(?,current_timestamp,?,?)";
	public static String QUERYUPDATE="update "+TipoGrupoRubroEmpleaConstantesFunciones.SCHEMA+"."+TipoGrupoRubroEmpleaConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoGrupoRubroEmpleaConstantesFunciones.SCHEMA+"."+TipoGrupoRubroEmpleaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tipogruporubroemplea from "+TipoGrupoRubroEmpleaConstantesFunciones.SPERSISTENCENAME+" tipogruporubroemplea";
	public static String QUERYSELECTNATIVE="select "+TipoGrupoRubroEmpleaConstantesFunciones.SCHEMA+"."+TipoGrupoRubroEmpleaConstantesFunciones.TABLENAME+".id,"+TipoGrupoRubroEmpleaConstantesFunciones.SCHEMA+"."+TipoGrupoRubroEmpleaConstantesFunciones.TABLENAME+".version_row,"+TipoGrupoRubroEmpleaConstantesFunciones.SCHEMA+"."+TipoGrupoRubroEmpleaConstantesFunciones.TABLENAME+".codigo,"+TipoGrupoRubroEmpleaConstantesFunciones.SCHEMA+"."+TipoGrupoRubroEmpleaConstantesFunciones.TABLENAME+".nombre from "+TipoGrupoRubroEmpleaConstantesFunciones.SCHEMA+"."+TipoGrupoRubroEmpleaConstantesFunciones.TABLENAME;//+" as "+TipoGrupoRubroEmpleaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoGrupoRubroEmpleaConstantesFunciones.SCHEMA+"."+TipoGrupoRubroEmpleaConstantesFunciones.TABLENAME+".id,"+TipoGrupoRubroEmpleaConstantesFunciones.SCHEMA+"."+TipoGrupoRubroEmpleaConstantesFunciones.TABLENAME+".version_row,"+TipoGrupoRubroEmpleaConstantesFunciones.SCHEMA+"."+TipoGrupoRubroEmpleaConstantesFunciones.TABLENAME+".codigo from "+TipoGrupoRubroEmpleaConstantesFunciones.SCHEMA+"."+TipoGrupoRubroEmpleaConstantesFunciones.TABLENAME;//+" as "+TipoGrupoRubroEmpleaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoGrupoRubroEmpleaConstantesFunciones.SCHEMA+"."+TipoGrupoRubroEmpleaConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPOGRUPORUBROEMPLEA_INSERT(?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPOGRUPORUBROEMPLEA_UPDATE(?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPOGRUPORUBROEMPLEA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPOGRUPORUBROEMPLEA_SELECT(?,?)";
	
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
	
	
	public TipoGrupoRubroEmpleaDataAccess() {
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
		TipoGrupoRubroEmpleaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoGrupoRubroEmpleaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoGrupoRubroEmpleaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoGrupoRubroEmpleaOriginal(TipoGrupoRubroEmplea tipogruporubroemplea)throws Exception  {
		tipogruporubroemplea.setTipoGrupoRubroEmpleaOriginal((TipoGrupoRubroEmplea)tipogruporubroemplea.clone());		
	}
	
	public void setTipoGrupoRubroEmpleasOriginal(List<TipoGrupoRubroEmplea> tipogruporubroempleas)throws Exception  {
		
		for(TipoGrupoRubroEmplea tipogruporubroemplea:tipogruporubroempleas){
			tipogruporubroemplea.setTipoGrupoRubroEmpleaOriginal((TipoGrupoRubroEmplea)tipogruporubroemplea.clone());
		}
	}
	
	public static void setTipoGrupoRubroEmpleaOriginalStatic(TipoGrupoRubroEmplea tipogruporubroemplea)throws Exception  {
		tipogruporubroemplea.setTipoGrupoRubroEmpleaOriginal((TipoGrupoRubroEmplea)tipogruporubroemplea.clone());		
	}
	
	public static void setTipoGrupoRubroEmpleasOriginalStatic(List<TipoGrupoRubroEmplea> tipogruporubroempleas)throws Exception  {
		
		for(TipoGrupoRubroEmplea tipogruporubroemplea:tipogruporubroempleas){
			tipogruporubroemplea.setTipoGrupoRubroEmpleaOriginal((TipoGrupoRubroEmplea)tipogruporubroemplea.clone());
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
	
	public  TipoGrupoRubroEmplea getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoGrupoRubroEmplea entity = new TipoGrupoRubroEmplea();		
		
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
	
	public  TipoGrupoRubroEmplea getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoGrupoRubroEmplea entity = new TipoGrupoRubroEmplea();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoGrupoRubroEmpleaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoGrupoRubroEmpleaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.TipoGrupoRubroEmplea.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoGrupoRubroEmpleaOriginal(new TipoGrupoRubroEmplea());
      	    	entity=super.getEntity("",entity,resultSet,TipoGrupoRubroEmpleaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoGrupoRubroEmplea("",entity,resultSet); 
				
				//entity.setTipoGrupoRubroEmpleaOriginal(super.getEntity("",entity.getTipoGrupoRubroEmpleaOriginal(),resultSet,TipoGrupoRubroEmpleaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoGrupoRubroEmpleaOriginal(this.getEntityTipoGrupoRubroEmplea("",entity.getTipoGrupoRubroEmpleaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoGrupoRubroEmplea(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoGrupoRubroEmplea getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoGrupoRubroEmplea entity = new TipoGrupoRubroEmplea();
				
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
	
	public  TipoGrupoRubroEmplea getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoGrupoRubroEmplea entity = new TipoGrupoRubroEmplea();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoGrupoRubroEmpleaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoGrupoRubroEmpleaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoGrupoRubroEmpleaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.TipoGrupoRubroEmplea.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoGrupoRubroEmpleaOriginal(new TipoGrupoRubroEmplea());
      	    	entity=super.getEntity("",entity,resultSet,TipoGrupoRubroEmpleaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoGrupoRubroEmplea("",entity,resultSet);    
				
				//entity.setTipoGrupoRubroEmpleaOriginal(super.getEntity("",entity.getTipoGrupoRubroEmpleaOriginal(),resultSet,TipoGrupoRubroEmpleaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoGrupoRubroEmpleaOriginal(this.getEntityTipoGrupoRubroEmplea("",entity.getTipoGrupoRubroEmpleaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoGrupoRubroEmplea(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoGrupoRubroEmplea
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoGrupoRubroEmplea entity = new TipoGrupoRubroEmplea();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoGrupoRubroEmpleaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoGrupoRubroEmpleaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoGrupoRubroEmpleaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.TipoGrupoRubroEmplea.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoGrupoRubroEmplea(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoGrupoRubroEmplea> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoGrupoRubroEmplea> entities = new  ArrayList<TipoGrupoRubroEmplea>();
		TipoGrupoRubroEmplea entity = new TipoGrupoRubroEmplea();		  
		
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
	
	public  List<TipoGrupoRubroEmplea> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoGrupoRubroEmplea> entities = new  ArrayList<TipoGrupoRubroEmplea>();
		TipoGrupoRubroEmplea entity = new TipoGrupoRubroEmplea();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoGrupoRubroEmpleaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoGrupoRubroEmpleaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoGrupoRubroEmpleaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoGrupoRubroEmplea();
      	    	entity=super.getEntity("",entity,resultSet,TipoGrupoRubroEmpleaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoGrupoRubroEmplea("",entity,resultSet);
      	    	
				//entity.setTipoGrupoRubroEmpleaOriginal( new TipoGrupoRubroEmplea());
      	    	//entity.setTipoGrupoRubroEmpleaOriginal(super.getEntity("",entity.getTipoGrupoRubroEmpleaOriginal(),resultSet,TipoGrupoRubroEmpleaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoGrupoRubroEmpleaOriginal(this.getEntityTipoGrupoRubroEmplea("",entity.getTipoGrupoRubroEmpleaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoGrupoRubroEmpleas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoGrupoRubroEmplea(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoGrupoRubroEmplea> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoGrupoRubroEmplea> entities = new  ArrayList<TipoGrupoRubroEmplea>();
		TipoGrupoRubroEmplea entity = new TipoGrupoRubroEmplea();		  
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
	
	public  List<TipoGrupoRubroEmplea> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoGrupoRubroEmplea> entities = new  ArrayList<TipoGrupoRubroEmplea>();
		TipoGrupoRubroEmplea entity = new TipoGrupoRubroEmplea();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoGrupoRubroEmplea();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoGrupoRubroEmplea();
					//entity.setMapTipoGrupoRubroEmplea(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoGrupoRubroEmpleaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoGrupoRubroEmplea().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoGrupoRubroEmpleaDataAccess.ISWITHSCHEMA);         		
					entity=TipoGrupoRubroEmpleaDataAccess.getEntityTipoGrupoRubroEmplea("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoGrupoRubroEmpleaOriginal( new TipoGrupoRubroEmplea());
					////entity.setTipoGrupoRubroEmpleaOriginal(super.getEntity("",entity.getTipoGrupoRubroEmpleaOriginal(),resultSet,TipoGrupoRubroEmpleaDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoGrupoRubroEmpleaOriginal(this.getEntityTipoGrupoRubroEmplea("",entity.getTipoGrupoRubroEmpleaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoGrupoRubroEmpleas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoGrupoRubroEmplea(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoGrupoRubroEmplea getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoGrupoRubroEmplea entity = new TipoGrupoRubroEmplea();		  
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
	
	public  TipoGrupoRubroEmplea getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoGrupoRubroEmplea entity = new TipoGrupoRubroEmplea();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoGrupoRubroEmplea();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoGrupoRubroEmplea();
					//entity.setMapTipoGrupoRubroEmplea(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoGrupoRubroEmpleaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoGrupoRubroEmplea().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoGrupoRubroEmpleaDataAccess.ISWITHSCHEMA);         		
					entity=TipoGrupoRubroEmpleaDataAccess.getEntityTipoGrupoRubroEmplea("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoGrupoRubroEmpleaOriginal( new TipoGrupoRubroEmplea());
					////entity.setTipoGrupoRubroEmpleaOriginal(super.getEntity("",entity.getTipoGrupoRubroEmpleaOriginal(),resultSet,TipoGrupoRubroEmpleaDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoGrupoRubroEmpleaOriginal(this.getEntityTipoGrupoRubroEmplea("",entity.getTipoGrupoRubroEmpleaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoGrupoRubroEmplea(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoGrupoRubroEmplea(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoGrupoRubroEmplea getEntityTipoGrupoRubroEmplea(String strPrefijo,TipoGrupoRubroEmplea entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoGrupoRubroEmplea.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoGrupoRubroEmplea.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoGrupoRubroEmpleaDataAccess.setFieldReflectionTipoGrupoRubroEmplea(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoGrupoRubroEmplea=TipoGrupoRubroEmpleaConstantesFunciones.getTodosTiposColumnasTipoGrupoRubroEmplea();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoGrupoRubroEmplea) {
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
							field = TipoGrupoRubroEmplea.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoGrupoRubroEmplea.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoGrupoRubroEmpleaDataAccess.setFieldReflectionTipoGrupoRubroEmplea(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoGrupoRubroEmplea(Field field,String strPrefijo,String sColumn,TipoGrupoRubroEmplea entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoGrupoRubroEmpleaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoGrupoRubroEmpleaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoGrupoRubroEmpleaConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoGrupoRubroEmpleaConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoGrupoRubroEmplea>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoGrupoRubroEmplea> entities = new  ArrayList<TipoGrupoRubroEmplea>();
		TipoGrupoRubroEmplea entity = new TipoGrupoRubroEmplea();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoGrupoRubroEmpleaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoGrupoRubroEmpleaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoGrupoRubroEmpleaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoGrupoRubroEmplea();
					entity=super.getEntity("",entity,resultSet,TipoGrupoRubroEmpleaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoGrupoRubroEmplea("",entity,resultSet);
					
					//entity.setTipoGrupoRubroEmpleaOriginal( new TipoGrupoRubroEmplea());
					//entity.setTipoGrupoRubroEmpleaOriginal(super.getEntity("",entity.getTipoGrupoRubroEmpleaOriginal(),resultSet,TipoGrupoRubroEmpleaDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoGrupoRubroEmpleaOriginal(this.getEntityTipoGrupoRubroEmplea("",entity.getTipoGrupoRubroEmpleaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoGrupoRubroEmpleas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoGrupoRubroEmplea(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoGrupoRubroEmplea>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoGrupoRubroEmplea> entities = new  ArrayList<TipoGrupoRubroEmplea>();
		TipoGrupoRubroEmplea entity = new TipoGrupoRubroEmplea();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoGrupoRubroEmpleaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoGrupoRubroEmpleaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoGrupoRubroEmpleaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoGrupoRubroEmplea> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoGrupoRubroEmplea> entities = new  ArrayList<TipoGrupoRubroEmplea>();
		TipoGrupoRubroEmplea entity = new TipoGrupoRubroEmplea();		  
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
	
	public  List<TipoGrupoRubroEmplea> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoGrupoRubroEmplea> entities = new  ArrayList<TipoGrupoRubroEmplea>();
		TipoGrupoRubroEmplea entity = new TipoGrupoRubroEmplea();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoGrupoRubroEmplea();
      	    	entity=super.getEntity("",entity,resultSet,TipoGrupoRubroEmpleaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoGrupoRubroEmplea("",entity,resultSet);
      	    	
				//entity.setTipoGrupoRubroEmpleaOriginal( new TipoGrupoRubroEmplea());
      	    	//entity.setTipoGrupoRubroEmpleaOriginal(super.getEntity("",entity.getTipoGrupoRubroEmpleaOriginal(),resultSet,TipoGrupoRubroEmpleaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoGrupoRubroEmpleaOriginal(this.getEntityTipoGrupoRubroEmplea("",entity.getTipoGrupoRubroEmpleaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoGrupoRubroEmpleas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoGrupoRubroEmplea(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	
	
	public TipoGrupoRubroEmplea getEntityTipoGrupoRubroEmplea(String strPrefijo,TipoGrupoRubroEmplea entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setcodigo(resultSet.getString(strPrefijo+TipoGrupoRubroEmpleaConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+TipoGrupoRubroEmpleaConstantesFunciones.NOMBRE));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+TipoGrupoRubroEmpleaConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoGrupoRubroEmplea(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoGrupoRubroEmplea entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoGrupoRubroEmpleaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoGrupoRubroEmpleaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoGrupoRubroEmpleaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoGrupoRubroEmpleaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoGrupoRubroEmpleaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,TipoGrupoRubroEmpleaDataAccess.TABLENAME,TipoGrupoRubroEmpleaDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoGrupoRubroEmpleaDataAccess.setTipoGrupoRubroEmpleaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
	
		
		public List<RubroEmplea> getRubroEmpleas(Connexion connexion,TipoGrupoRubroEmplea tipogruporubroemplea)throws SQLException,Exception {

		List<RubroEmplea> rubroempleas= new ArrayList<RubroEmplea>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoGrupoRubroEmpleaConstantesFunciones.SCHEMA+".tipo_grupo_rubro_emplea ON "+RubroEmpleaConstantesFunciones.SCHEMA+".rubro_emplea.id_tipo_grupo_rubro_emplea="+TipoGrupoRubroEmpleaConstantesFunciones.SCHEMA+".tipo_grupo_rubro_emplea.id WHERE "+TipoGrupoRubroEmpleaConstantesFunciones.SCHEMA+".tipo_grupo_rubro_emplea.id="+String.valueOf(tipogruporubroemplea.getId());
			} else {
				sQuery=" INNER JOIN rubroemplea.TipoGrupoRubroEmplea WHERE rubroemplea.TipoGrupoRubroEmplea.id="+String.valueOf(tipogruporubroemplea.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			RubroEmpleaDataAccess rubroempleaDataAccess=new RubroEmpleaDataAccess();

			rubroempleaDataAccess.setConnexionType(this.connexionType);
			rubroempleaDataAccess.setParameterDbType(this.parameterDbType);
			rubroempleas=rubroempleaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return rubroempleas;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoGrupoRubroEmplea tipogruporubroemplea) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tipogruporubroemplea.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid=new ParameterValue<Long>();
					parameterMaintenanceValueid.setValue(tipogruporubroemplea.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(tipogruporubroemplea.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tipogruporubroemplea.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!tipogruporubroemplea.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tipogruporubroemplea.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tipogruporubroemplea.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tipogruporubroemplea.getId());
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
	
	public void setIsNewIsChangedFalseTipoGrupoRubroEmplea(TipoGrupoRubroEmplea tipogruporubroemplea)throws Exception  {		
		tipogruporubroemplea.setIsNew(false);
		tipogruporubroemplea.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoGrupoRubroEmpleas(List<TipoGrupoRubroEmplea> tipogruporubroempleas)throws Exception  {				
		for(TipoGrupoRubroEmplea tipogruporubroemplea:tipogruporubroempleas) {
			tipogruporubroemplea.setIsNew(false);
			tipogruporubroemplea.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoGrupoRubroEmplea(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
