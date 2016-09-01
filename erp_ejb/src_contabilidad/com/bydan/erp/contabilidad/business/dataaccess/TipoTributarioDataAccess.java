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
import com.bydan.erp.contabilidad.util.*;//TipoTributarioConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.sris.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.sris.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.inventario.util.*;




@SuppressWarnings("unused")
final public class TipoTributarioDataAccess extends  TipoTributarioDataAccessAdditional{ //TipoTributarioDataAccessAdditional,DataAccessHelper<TipoTributario>
	//static Logger logger = Logger.getLogger(TipoTributarioDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_tributario";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoTributarioConstantesFunciones.SCHEMA+"."+TipoTributarioConstantesFunciones.TABLENAME+"(version_row,id_pais,codigo,nombre)values(current_timestamp,?,?,?)";
	public static String QUERYUPDATE="update "+TipoTributarioConstantesFunciones.SCHEMA+"."+TipoTributarioConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_pais=?,codigo=?,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoTributarioConstantesFunciones.SCHEMA+"."+TipoTributarioConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tipotributario from "+TipoTributarioConstantesFunciones.SPERSISTENCENAME+" tipotributario";
	public static String QUERYSELECTNATIVE="select "+TipoTributarioConstantesFunciones.SCHEMA+"."+TipoTributarioConstantesFunciones.TABLENAME+".id,"+TipoTributarioConstantesFunciones.SCHEMA+"."+TipoTributarioConstantesFunciones.TABLENAME+".version_row,"+TipoTributarioConstantesFunciones.SCHEMA+"."+TipoTributarioConstantesFunciones.TABLENAME+".id_pais,"+TipoTributarioConstantesFunciones.SCHEMA+"."+TipoTributarioConstantesFunciones.TABLENAME+".codigo,"+TipoTributarioConstantesFunciones.SCHEMA+"."+TipoTributarioConstantesFunciones.TABLENAME+".nombre from "+TipoTributarioConstantesFunciones.SCHEMA+"."+TipoTributarioConstantesFunciones.TABLENAME;//+" as "+TipoTributarioConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoTributarioConstantesFunciones.SCHEMA+"."+TipoTributarioConstantesFunciones.TABLENAME+".id,"+TipoTributarioConstantesFunciones.SCHEMA+"."+TipoTributarioConstantesFunciones.TABLENAME+".version_row,"+TipoTributarioConstantesFunciones.SCHEMA+"."+TipoTributarioConstantesFunciones.TABLENAME+".codigo from "+TipoTributarioConstantesFunciones.SCHEMA+"."+TipoTributarioConstantesFunciones.TABLENAME;//+" as "+TipoTributarioConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoTributarioConstantesFunciones.SCHEMA+"."+TipoTributarioConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_pais=?,codigo=?,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPOTRIBUTARIO_INSERT(?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPOTRIBUTARIO_UPDATE(?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPOTRIBUTARIO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPOTRIBUTARIO_SELECT(?,?)";
	
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
	
	
	protected TipoTributarioDataAccessAdditional tipotributarioDataAccessAdditional=null;
	
	public TipoTributarioDataAccessAdditional getTipoTributarioDataAccessAdditional() {
		return this.tipotributarioDataAccessAdditional;
	}
	
	public void setTipoTributarioDataAccessAdditional(TipoTributarioDataAccessAdditional tipotributarioDataAccessAdditional) {
		try {
			this.tipotributarioDataAccessAdditional=tipotributarioDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TipoTributarioDataAccess() {
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
		TipoTributarioDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoTributarioDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoTributarioDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoTributarioOriginal(TipoTributario tipotributario)throws Exception  {
		tipotributario.setTipoTributarioOriginal((TipoTributario)tipotributario.clone());		
	}
	
	public void setTipoTributariosOriginal(List<TipoTributario> tipotributarios)throws Exception  {
		
		for(TipoTributario tipotributario:tipotributarios){
			tipotributario.setTipoTributarioOriginal((TipoTributario)tipotributario.clone());
		}
	}
	
	public static void setTipoTributarioOriginalStatic(TipoTributario tipotributario)throws Exception  {
		tipotributario.setTipoTributarioOriginal((TipoTributario)tipotributario.clone());		
	}
	
	public static void setTipoTributariosOriginalStatic(List<TipoTributario> tipotributarios)throws Exception  {
		
		for(TipoTributario tipotributario:tipotributarios){
			tipotributario.setTipoTributarioOriginal((TipoTributario)tipotributario.clone());
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
	
	public  TipoTributario getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoTributario entity = new TipoTributario();		
		
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
	
	public  TipoTributario getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoTributario entity = new TipoTributario();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoTributarioDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoTributarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Contabilidad.TipoTributario.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoTributarioOriginal(new TipoTributario());
      	    	entity=super.getEntity("",entity,resultSet,TipoTributarioDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoTributario("",entity,resultSet); 
				
				//entity.setTipoTributarioOriginal(super.getEntity("",entity.getTipoTributarioOriginal(),resultSet,TipoTributarioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoTributarioOriginal(this.getEntityTipoTributario("",entity.getTipoTributarioOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoTributario(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoTributario getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoTributario entity = new TipoTributario();
				
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
	
	public  TipoTributario getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoTributario entity = new TipoTributario();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoTributarioDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoTributarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoTributarioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.TipoTributario.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoTributarioOriginal(new TipoTributario());
      	    	entity=super.getEntity("",entity,resultSet,TipoTributarioDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoTributario("",entity,resultSet);    
				
				//entity.setTipoTributarioOriginal(super.getEntity("",entity.getTipoTributarioOriginal(),resultSet,TipoTributarioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoTributarioOriginal(this.getEntityTipoTributario("",entity.getTipoTributarioOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoTributario(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoTributario
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoTributario entity = new TipoTributario();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoTributarioDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoTributarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoTributarioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.TipoTributario.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoTributario(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoTributario> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoTributario> entities = new  ArrayList<TipoTributario>();
		TipoTributario entity = new TipoTributario();		  
		
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
	
	public  List<TipoTributario> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoTributario> entities = new  ArrayList<TipoTributario>();
		TipoTributario entity = new TipoTributario();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoTributarioDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoTributarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoTributarioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoTributario();
      	    	entity=super.getEntity("",entity,resultSet,TipoTributarioDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoTributario("",entity,resultSet);
      	    	
				//entity.setTipoTributarioOriginal( new TipoTributario());
      	    	//entity.setTipoTributarioOriginal(super.getEntity("",entity.getTipoTributarioOriginal(),resultSet,TipoTributarioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoTributarioOriginal(this.getEntityTipoTributario("",entity.getTipoTributarioOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoTributarios(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoTributario(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoTributario> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoTributario> entities = new  ArrayList<TipoTributario>();
		TipoTributario entity = new TipoTributario();		  
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
	
	public  List<TipoTributario> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoTributario> entities = new  ArrayList<TipoTributario>();
		TipoTributario entity = new TipoTributario();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoTributario();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoTributario();
					//entity.setMapTipoTributario(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoTributarioValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoTributario().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoTributarioDataAccess.ISWITHSCHEMA);         		
					entity=TipoTributarioDataAccess.getEntityTipoTributario("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoTributarioOriginal( new TipoTributario());
					////entity.setTipoTributarioOriginal(super.getEntity("",entity.getTipoTributarioOriginal(),resultSet,TipoTributarioDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoTributarioOriginal(this.getEntityTipoTributario("",entity.getTipoTributarioOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoTributarios(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoTributario(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoTributario getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoTributario entity = new TipoTributario();		  
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
	
	public  TipoTributario getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoTributario entity = new TipoTributario();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoTributario();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoTributario();
					//entity.setMapTipoTributario(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoTributarioValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoTributario().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoTributarioDataAccess.ISWITHSCHEMA);         		
					entity=TipoTributarioDataAccess.getEntityTipoTributario("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoTributarioOriginal( new TipoTributario());
					////entity.setTipoTributarioOriginal(super.getEntity("",entity.getTipoTributarioOriginal(),resultSet,TipoTributarioDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoTributarioOriginal(this.getEntityTipoTributario("",entity.getTipoTributarioOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoTributario(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoTributario(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoTributario getEntityTipoTributario(String strPrefijo,TipoTributario entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoTributario.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoTributario.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoTributarioDataAccess.setFieldReflectionTipoTributario(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoTributario=TipoTributarioConstantesFunciones.getTodosTiposColumnasTipoTributario();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoTributario) {
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
							field = TipoTributario.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoTributario.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoTributarioDataAccess.setFieldReflectionTipoTributario(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoTributario(Field field,String strPrefijo,String sColumn,TipoTributario entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoTributarioConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoTributarioConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoTributarioConstantesFunciones.IDPAIS:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoTributarioConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoTributarioConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoTributario>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoTributario> entities = new  ArrayList<TipoTributario>();
		TipoTributario entity = new TipoTributario();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoTributarioDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoTributarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoTributarioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoTributario();
					entity=super.getEntity("",entity,resultSet,TipoTributarioDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoTributario("",entity,resultSet);
					
					//entity.setTipoTributarioOriginal( new TipoTributario());
					//entity.setTipoTributarioOriginal(super.getEntity("",entity.getTipoTributarioOriginal(),resultSet,TipoTributarioDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoTributarioOriginal(this.getEntityTipoTributario("",entity.getTipoTributarioOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoTributarios(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoTributario(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoTributario>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoTributario> entities = new  ArrayList<TipoTributario>();
		TipoTributario entity = new TipoTributario();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoTributarioDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoTributarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoTributarioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoTributario> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoTributario> entities = new  ArrayList<TipoTributario>();
		TipoTributario entity = new TipoTributario();		  
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
	
	public  List<TipoTributario> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoTributario> entities = new  ArrayList<TipoTributario>();
		TipoTributario entity = new TipoTributario();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoTributario();
      	    	entity=super.getEntity("",entity,resultSet,TipoTributarioDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoTributario("",entity,resultSet);
      	    	
				//entity.setTipoTributarioOriginal( new TipoTributario());
      	    	//entity.setTipoTributarioOriginal(super.getEntity("",entity.getTipoTributarioOriginal(),resultSet,TipoTributarioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoTributarioOriginal(this.getEntityTipoTributario("",entity.getTipoTributarioOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoTributarios(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoTributario(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoTributario> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoTributario> entities = new  ArrayList<TipoTributario>();
		TipoTributario entity = new TipoTributario();		  
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
	
	public  List<TipoTributario> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoTributario> entities = new  ArrayList<TipoTributario>();
		TipoTributario entity = new TipoTributario();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoTributario();
      	    	entity=super.getEntity("",entity,resultSet,TipoTributarioDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoTributario("",entity,resultSet);
      	    	
				//entity.setTipoTributarioOriginal( new TipoTributario());
      	    	//entity.setTipoTributarioOriginal(super.getEntity("",entity.getTipoTributarioOriginal(),resultSet,TipoTributarioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoTributarioOriginal(this.getEntityTipoTributario("",entity.getTipoTributarioOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoTributarios(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public TipoTributario getEntityTipoTributario(String strPrefijo,TipoTributario entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_pais(resultSet.getLong(strPrefijo+TipoTributarioConstantesFunciones.IDPAIS));
				entity.setcodigo(resultSet.getString(strPrefijo+TipoTributarioConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+TipoTributarioConstantesFunciones.NOMBRE));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+TipoTributarioConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoTributario(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoTributario entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoTributarioDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoTributarioDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoTributarioDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoTributarioDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoTributarioConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,TipoTributarioDataAccess.TABLENAME,TipoTributarioDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoTributarioDataAccess.setTipoTributarioOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Pais getPais(Connexion connexion,TipoTributario reltipotributario)throws SQLException,Exception {

		Pais pais= new Pais();

		try {
			PaisDataAccess paisDataAccess=new PaisDataAccess();

			paisDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			paisDataAccess.setConnexionType(this.connexionType);
			paisDataAccess.setParameterDbType(this.parameterDbType);

			pais=paisDataAccess.getEntity(connexion,reltipotributario.getid_pais());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pais;

	}


		
		public List<Sri> getSris(Connexion connexion,TipoTributario tipotributario)throws SQLException,Exception {

		List<Sri> sris= new ArrayList<Sri>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoTributarioConstantesFunciones.SCHEMA+".tipo_tributario ON "+SriConstantesFunciones.SCHEMA+".sri.id_tipo_tributario="+TipoTributarioConstantesFunciones.SCHEMA+".tipo_tributario.id WHERE "+TipoTributarioConstantesFunciones.SCHEMA+".tipo_tributario.id="+String.valueOf(tipotributario.getId());
			} else {
				sQuery=" INNER JOIN sri.TipoTributario WHERE sri.TipoTributario.id="+String.valueOf(tipotributario.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			SriDataAccess sriDataAccess=new SriDataAccess();

			sriDataAccess.setConnexionType(this.connexionType);
			sriDataAccess.setParameterDbType(this.parameterDbType);
			sris=sriDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sris;

	}

	public List<ImportarExportar> getImportarExportars(Connexion connexion,TipoTributario tipotributario)throws SQLException,Exception {

		List<ImportarExportar> importarexportars= new ArrayList<ImportarExportar>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoTributarioConstantesFunciones.SCHEMA+".tipo_tributario ON "+ImportarExportarConstantesFunciones.SCHEMA+".importar_exportar.id_tipo_tributario="+TipoTributarioConstantesFunciones.SCHEMA+".tipo_tributario.id WHERE "+TipoTributarioConstantesFunciones.SCHEMA+".tipo_tributario.id="+String.valueOf(tipotributario.getId());
			} else {
				sQuery=" INNER JOIN importarexportar.TipoTributario WHERE importarexportar.TipoTributario.id="+String.valueOf(tipotributario.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ImportarExportarDataAccess importarexportarDataAccess=new ImportarExportarDataAccess();

			importarexportarDataAccess.setConnexionType(this.connexionType);
			importarexportarDataAccess.setParameterDbType(this.parameterDbType);
			importarexportars=importarexportarDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return importarexportars;

	}

	public List<TransaccionLocal> getTransaccionLocals(Connexion connexion,TipoTributario tipotributario)throws SQLException,Exception {

		List<TransaccionLocal> transaccionlocals= new ArrayList<TransaccionLocal>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoTributarioConstantesFunciones.SCHEMA+".tipo_tributario ON "+TransaccionLocalConstantesFunciones.SCHEMA+".transaccion_local.id_tipo_tributario="+TipoTributarioConstantesFunciones.SCHEMA+".tipo_tributario.id WHERE "+TipoTributarioConstantesFunciones.SCHEMA+".tipo_tributario.id="+String.valueOf(tipotributario.getId());
			} else {
				sQuery=" INNER JOIN transaccionlocal.TipoTributario WHERE transaccionlocal.TipoTributario.id="+String.valueOf(tipotributario.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			TransaccionLocalDataAccess transaccionlocalDataAccess=new TransaccionLocalDataAccess();

			transaccionlocalDataAccess.setConnexionType(this.connexionType);
			transaccionlocalDataAccess.setParameterDbType(this.parameterDbType);
			transaccionlocals=transaccionlocalDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccionlocals;

	}

	public List<FacturaProveedorServicio> getFacturaProveedorServicios(Connexion connexion,TipoTributario tipotributario)throws SQLException,Exception {

		List<FacturaProveedorServicio> facturaproveedorservicios= new ArrayList<FacturaProveedorServicio>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoTributarioConstantesFunciones.SCHEMA+".tipo_tributario ON "+FacturaProveedorServicioConstantesFunciones.SCHEMA+".factura_proveedor_servicio.id_tipo_tributario="+TipoTributarioConstantesFunciones.SCHEMA+".tipo_tributario.id WHERE "+TipoTributarioConstantesFunciones.SCHEMA+".tipo_tributario.id="+String.valueOf(tipotributario.getId());
			} else {
				sQuery=" INNER JOIN facturaproveedorservicio.TipoTributario WHERE facturaproveedorservicio.TipoTributario.id="+String.valueOf(tipotributario.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			FacturaProveedorServicioDataAccess facturaproveedorservicioDataAccess=new FacturaProveedorServicioDataAccess();

			facturaproveedorservicioDataAccess.setConnexionType(this.connexionType);
			facturaproveedorservicioDataAccess.setParameterDbType(this.parameterDbType);
			facturaproveedorservicios=facturaproveedorservicioDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return facturaproveedorservicios;

	}

	public List<FacturaProveedor> getFacturaProveedors(Connexion connexion,TipoTributario tipotributario)throws SQLException,Exception {

		List<FacturaProveedor> facturaproveedors= new ArrayList<FacturaProveedor>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoTributarioConstantesFunciones.SCHEMA+".tipo_tributario ON "+FacturaProveedorConstantesFunciones.SCHEMA+".factura_proveedor.id_tipo_tributario="+TipoTributarioConstantesFunciones.SCHEMA+".tipo_tributario.id WHERE "+TipoTributarioConstantesFunciones.SCHEMA+".tipo_tributario.id="+String.valueOf(tipotributario.getId());
			} else {
				sQuery=" INNER JOIN facturaproveedor.TipoTributario WHERE facturaproveedor.TipoTributario.id="+String.valueOf(tipotributario.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			FacturaProveedorDataAccess facturaproveedorDataAccess=new FacturaProveedorDataAccess();

			facturaproveedorDataAccess.setConnexionType(this.connexionType);
			facturaproveedorDataAccess.setParameterDbType(this.parameterDbType);
			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return facturaproveedors;

	}

	public List<Definicion> getDefinicions(Connexion connexion,TipoTributario tipotributario)throws SQLException,Exception {

		List<Definicion> definicions= new ArrayList<Definicion>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoTributarioConstantesFunciones.SCHEMA+".tipo_tributario ON "+DefinicionConstantesFunciones.SCHEMA+".definicion.id_tipo_tributario="+TipoTributarioConstantesFunciones.SCHEMA+".tipo_tributario.id WHERE "+TipoTributarioConstantesFunciones.SCHEMA+".tipo_tributario.id="+String.valueOf(tipotributario.getId());
			} else {
				sQuery=" INNER JOIN definicion.TipoTributario WHERE definicion.TipoTributario.id="+String.valueOf(tipotributario.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DefinicionDataAccess definicionDataAccess=new DefinicionDataAccess();

			definicionDataAccess.setConnexionType(this.connexionType);
			definicionDataAccess.setParameterDbType(this.parameterDbType);
			definicions=definicionDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return definicions;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoTributario tipotributario) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tipotributario.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_pais=new ParameterValue<Long>();
					parameterMaintenanceValueid_pais.setValue(tipotributario.getid_pais());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_pais);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(tipotributario.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tipotributario.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!tipotributario.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tipotributario.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tipotributario.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tipotributario.getId());
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
	
	public void setIsNewIsChangedFalseTipoTributario(TipoTributario tipotributario)throws Exception  {		
		tipotributario.setIsNew(false);
		tipotributario.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoTributarios(List<TipoTributario> tipotributarios)throws Exception  {				
		for(TipoTributario tipotributario:tipotributarios) {
			tipotributario.setIsNew(false);
			tipotributario.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoTributario(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
