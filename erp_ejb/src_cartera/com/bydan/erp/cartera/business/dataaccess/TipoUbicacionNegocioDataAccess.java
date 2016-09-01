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
import com.bydan.erp.cartera.util.*;//TipoUbicacionNegocioConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class TipoUbicacionNegocioDataAccess extends  DataAccessHelper<TipoUbicacionNegocio>{ //TipoUbicacionNegocioDataAccessAdditional,DataAccessHelper<TipoUbicacionNegocio>
	//static Logger logger = Logger.getLogger(TipoUbicacionNegocioDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_ubicacion_negocio";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoUbicacionNegocioConstantesFunciones.SCHEMA+"."+TipoUbicacionNegocioConstantesFunciones.TABLENAME+"(version_row,id_empresa,codigo,nombre)values(current_timestamp,?,?,?)";
	public static String QUERYUPDATE="update "+TipoUbicacionNegocioConstantesFunciones.SCHEMA+"."+TipoUbicacionNegocioConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,codigo=?,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoUbicacionNegocioConstantesFunciones.SCHEMA+"."+TipoUbicacionNegocioConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tipoubicacionnegocio from "+TipoUbicacionNegocioConstantesFunciones.SPERSISTENCENAME+" tipoubicacionnegocio";
	public static String QUERYSELECTNATIVE="select "+TipoUbicacionNegocioConstantesFunciones.SCHEMA+"."+TipoUbicacionNegocioConstantesFunciones.TABLENAME+".id,"+TipoUbicacionNegocioConstantesFunciones.SCHEMA+"."+TipoUbicacionNegocioConstantesFunciones.TABLENAME+".version_row,"+TipoUbicacionNegocioConstantesFunciones.SCHEMA+"."+TipoUbicacionNegocioConstantesFunciones.TABLENAME+".id_empresa,"+TipoUbicacionNegocioConstantesFunciones.SCHEMA+"."+TipoUbicacionNegocioConstantesFunciones.TABLENAME+".codigo,"+TipoUbicacionNegocioConstantesFunciones.SCHEMA+"."+TipoUbicacionNegocioConstantesFunciones.TABLENAME+".nombre from "+TipoUbicacionNegocioConstantesFunciones.SCHEMA+"."+TipoUbicacionNegocioConstantesFunciones.TABLENAME;//+" as "+TipoUbicacionNegocioConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoUbicacionNegocioConstantesFunciones.SCHEMA+"."+TipoUbicacionNegocioConstantesFunciones.TABLENAME+".id,"+TipoUbicacionNegocioConstantesFunciones.SCHEMA+"."+TipoUbicacionNegocioConstantesFunciones.TABLENAME+".version_row,"+TipoUbicacionNegocioConstantesFunciones.SCHEMA+"."+TipoUbicacionNegocioConstantesFunciones.TABLENAME+".codigo from "+TipoUbicacionNegocioConstantesFunciones.SCHEMA+"."+TipoUbicacionNegocioConstantesFunciones.TABLENAME;//+" as "+TipoUbicacionNegocioConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoUbicacionNegocioConstantesFunciones.SCHEMA+"."+TipoUbicacionNegocioConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,codigo=?,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPOUBICACIONNEGOCIO_INSERT(?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPOUBICACIONNEGOCIO_UPDATE(?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPOUBICACIONNEGOCIO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPOUBICACIONNEGOCIO_SELECT(?,?)";
	
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
	
	
	public TipoUbicacionNegocioDataAccess() {
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
		TipoUbicacionNegocioDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoUbicacionNegocioDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoUbicacionNegocioDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoUbicacionNegocioOriginal(TipoUbicacionNegocio tipoubicacionnegocio)throws Exception  {
		tipoubicacionnegocio.setTipoUbicacionNegocioOriginal((TipoUbicacionNegocio)tipoubicacionnegocio.clone());		
	}
	
	public void setTipoUbicacionNegociosOriginal(List<TipoUbicacionNegocio> tipoubicacionnegocios)throws Exception  {
		
		for(TipoUbicacionNegocio tipoubicacionnegocio:tipoubicacionnegocios){
			tipoubicacionnegocio.setTipoUbicacionNegocioOriginal((TipoUbicacionNegocio)tipoubicacionnegocio.clone());
		}
	}
	
	public static void setTipoUbicacionNegocioOriginalStatic(TipoUbicacionNegocio tipoubicacionnegocio)throws Exception  {
		tipoubicacionnegocio.setTipoUbicacionNegocioOriginal((TipoUbicacionNegocio)tipoubicacionnegocio.clone());		
	}
	
	public static void setTipoUbicacionNegociosOriginalStatic(List<TipoUbicacionNegocio> tipoubicacionnegocios)throws Exception  {
		
		for(TipoUbicacionNegocio tipoubicacionnegocio:tipoubicacionnegocios){
			tipoubicacionnegocio.setTipoUbicacionNegocioOriginal((TipoUbicacionNegocio)tipoubicacionnegocio.clone());
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
	
	public  TipoUbicacionNegocio getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoUbicacionNegocio entity = new TipoUbicacionNegocio();		
		
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
	
	public  TipoUbicacionNegocio getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoUbicacionNegocio entity = new TipoUbicacionNegocio();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoUbicacionNegocioDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoUbicacionNegocioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Cartera.TipoUbicacionNegocio.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoUbicacionNegocioOriginal(new TipoUbicacionNegocio());
      	    	entity=super.getEntity("",entity,resultSet,TipoUbicacionNegocioDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoUbicacionNegocio("",entity,resultSet); 
				
				//entity.setTipoUbicacionNegocioOriginal(super.getEntity("",entity.getTipoUbicacionNegocioOriginal(),resultSet,TipoUbicacionNegocioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoUbicacionNegocioOriginal(this.getEntityTipoUbicacionNegocio("",entity.getTipoUbicacionNegocioOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoUbicacionNegocio(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoUbicacionNegocio getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoUbicacionNegocio entity = new TipoUbicacionNegocio();
				
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
	
	public  TipoUbicacionNegocio getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoUbicacionNegocio entity = new TipoUbicacionNegocio();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoUbicacionNegocioDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoUbicacionNegocioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoUbicacionNegocioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.TipoUbicacionNegocio.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoUbicacionNegocioOriginal(new TipoUbicacionNegocio());
      	    	entity=super.getEntity("",entity,resultSet,TipoUbicacionNegocioDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoUbicacionNegocio("",entity,resultSet);    
				
				//entity.setTipoUbicacionNegocioOriginal(super.getEntity("",entity.getTipoUbicacionNegocioOriginal(),resultSet,TipoUbicacionNegocioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoUbicacionNegocioOriginal(this.getEntityTipoUbicacionNegocio("",entity.getTipoUbicacionNegocioOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoUbicacionNegocio(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoUbicacionNegocio
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoUbicacionNegocio entity = new TipoUbicacionNegocio();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoUbicacionNegocioDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoUbicacionNegocioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoUbicacionNegocioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.TipoUbicacionNegocio.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoUbicacionNegocio(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoUbicacionNegocio> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoUbicacionNegocio> entities = new  ArrayList<TipoUbicacionNegocio>();
		TipoUbicacionNegocio entity = new TipoUbicacionNegocio();		  
		
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
	
	public  List<TipoUbicacionNegocio> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoUbicacionNegocio> entities = new  ArrayList<TipoUbicacionNegocio>();
		TipoUbicacionNegocio entity = new TipoUbicacionNegocio();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoUbicacionNegocioDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoUbicacionNegocioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoUbicacionNegocioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoUbicacionNegocio();
      	    	entity=super.getEntity("",entity,resultSet,TipoUbicacionNegocioDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoUbicacionNegocio("",entity,resultSet);
      	    	
				//entity.setTipoUbicacionNegocioOriginal( new TipoUbicacionNegocio());
      	    	//entity.setTipoUbicacionNegocioOriginal(super.getEntity("",entity.getTipoUbicacionNegocioOriginal(),resultSet,TipoUbicacionNegocioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoUbicacionNegocioOriginal(this.getEntityTipoUbicacionNegocio("",entity.getTipoUbicacionNegocioOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoUbicacionNegocios(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoUbicacionNegocio(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoUbicacionNegocio> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoUbicacionNegocio> entities = new  ArrayList<TipoUbicacionNegocio>();
		TipoUbicacionNegocio entity = new TipoUbicacionNegocio();		  
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
	
	public  List<TipoUbicacionNegocio> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoUbicacionNegocio> entities = new  ArrayList<TipoUbicacionNegocio>();
		TipoUbicacionNegocio entity = new TipoUbicacionNegocio();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoUbicacionNegocio();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoUbicacionNegocio();
					//entity.setMapTipoUbicacionNegocio(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoUbicacionNegocioValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoUbicacionNegocio().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoUbicacionNegocioDataAccess.ISWITHSCHEMA);         		
					entity=TipoUbicacionNegocioDataAccess.getEntityTipoUbicacionNegocio("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoUbicacionNegocioOriginal( new TipoUbicacionNegocio());
					////entity.setTipoUbicacionNegocioOriginal(super.getEntity("",entity.getTipoUbicacionNegocioOriginal(),resultSet,TipoUbicacionNegocioDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoUbicacionNegocioOriginal(this.getEntityTipoUbicacionNegocio("",entity.getTipoUbicacionNegocioOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoUbicacionNegocios(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoUbicacionNegocio(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoUbicacionNegocio getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoUbicacionNegocio entity = new TipoUbicacionNegocio();		  
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
	
	public  TipoUbicacionNegocio getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoUbicacionNegocio entity = new TipoUbicacionNegocio();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoUbicacionNegocio();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoUbicacionNegocio();
					//entity.setMapTipoUbicacionNegocio(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoUbicacionNegocioValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoUbicacionNegocio().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoUbicacionNegocioDataAccess.ISWITHSCHEMA);         		
					entity=TipoUbicacionNegocioDataAccess.getEntityTipoUbicacionNegocio("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoUbicacionNegocioOriginal( new TipoUbicacionNegocio());
					////entity.setTipoUbicacionNegocioOriginal(super.getEntity("",entity.getTipoUbicacionNegocioOriginal(),resultSet,TipoUbicacionNegocioDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoUbicacionNegocioOriginal(this.getEntityTipoUbicacionNegocio("",entity.getTipoUbicacionNegocioOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoUbicacionNegocio(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoUbicacionNegocio(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoUbicacionNegocio getEntityTipoUbicacionNegocio(String strPrefijo,TipoUbicacionNegocio entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoUbicacionNegocio.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoUbicacionNegocio.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoUbicacionNegocioDataAccess.setFieldReflectionTipoUbicacionNegocio(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoUbicacionNegocio=TipoUbicacionNegocioConstantesFunciones.getTodosTiposColumnasTipoUbicacionNegocio();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoUbicacionNegocio) {
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
							field = TipoUbicacionNegocio.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoUbicacionNegocio.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoUbicacionNegocioDataAccess.setFieldReflectionTipoUbicacionNegocio(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoUbicacionNegocio(Field field,String strPrefijo,String sColumn,TipoUbicacionNegocio entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoUbicacionNegocioConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoUbicacionNegocioConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoUbicacionNegocioConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoUbicacionNegocioConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoUbicacionNegocioConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoUbicacionNegocio>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoUbicacionNegocio> entities = new  ArrayList<TipoUbicacionNegocio>();
		TipoUbicacionNegocio entity = new TipoUbicacionNegocio();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoUbicacionNegocioDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoUbicacionNegocioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoUbicacionNegocioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoUbicacionNegocio();
					entity=super.getEntity("",entity,resultSet,TipoUbicacionNegocioDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoUbicacionNegocio("",entity,resultSet);
					
					//entity.setTipoUbicacionNegocioOriginal( new TipoUbicacionNegocio());
					//entity.setTipoUbicacionNegocioOriginal(super.getEntity("",entity.getTipoUbicacionNegocioOriginal(),resultSet,TipoUbicacionNegocioDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoUbicacionNegocioOriginal(this.getEntityTipoUbicacionNegocio("",entity.getTipoUbicacionNegocioOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoUbicacionNegocios(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoUbicacionNegocio(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoUbicacionNegocio>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoUbicacionNegocio> entities = new  ArrayList<TipoUbicacionNegocio>();
		TipoUbicacionNegocio entity = new TipoUbicacionNegocio();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoUbicacionNegocioDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoUbicacionNegocioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoUbicacionNegocioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoUbicacionNegocio> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoUbicacionNegocio> entities = new  ArrayList<TipoUbicacionNegocio>();
		TipoUbicacionNegocio entity = new TipoUbicacionNegocio();		  
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
	
	public  List<TipoUbicacionNegocio> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoUbicacionNegocio> entities = new  ArrayList<TipoUbicacionNegocio>();
		TipoUbicacionNegocio entity = new TipoUbicacionNegocio();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoUbicacionNegocio();
      	    	entity=super.getEntity("",entity,resultSet,TipoUbicacionNegocioDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoUbicacionNegocio("",entity,resultSet);
      	    	
				//entity.setTipoUbicacionNegocioOriginal( new TipoUbicacionNegocio());
      	    	//entity.setTipoUbicacionNegocioOriginal(super.getEntity("",entity.getTipoUbicacionNegocioOriginal(),resultSet,TipoUbicacionNegocioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoUbicacionNegocioOriginal(this.getEntityTipoUbicacionNegocio("",entity.getTipoUbicacionNegocioOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoUbicacionNegocios(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoUbicacionNegocio(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	
	
	public TipoUbicacionNegocio getEntityTipoUbicacionNegocio(String strPrefijo,TipoUbicacionNegocio entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+TipoUbicacionNegocioConstantesFunciones.IDEMPRESA));
				entity.setcodigo(resultSet.getString(strPrefijo+TipoUbicacionNegocioConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+TipoUbicacionNegocioConstantesFunciones.NOMBRE));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+TipoUbicacionNegocioConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoUbicacionNegocio(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoUbicacionNegocio entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoUbicacionNegocioDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoUbicacionNegocioDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoUbicacionNegocioDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoUbicacionNegocioDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoUbicacionNegocioConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,TipoUbicacionNegocioDataAccess.TABLENAME,TipoUbicacionNegocioDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoUbicacionNegocioDataAccess.setTipoUbicacionNegocioOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,TipoUbicacionNegocio reltipoubicacionnegocio)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reltipoubicacionnegocio.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}


		
		public List<NegocioCliente> getNegocioClientes(Connexion connexion,TipoUbicacionNegocio tipoubicacionnegocio)throws SQLException,Exception {

		List<NegocioCliente> negocioclientes= new ArrayList<NegocioCliente>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoUbicacionNegocioConstantesFunciones.SCHEMA+".tipo_ubicacion_negocio ON "+NegocioClienteConstantesFunciones.SCHEMA+".negocio_cliente.id_tipo_ubicacion_negocio="+TipoUbicacionNegocioConstantesFunciones.SCHEMA+".tipo_ubicacion_negocio.id WHERE "+TipoUbicacionNegocioConstantesFunciones.SCHEMA+".tipo_ubicacion_negocio.id="+String.valueOf(tipoubicacionnegocio.getId());
			} else {
				sQuery=" INNER JOIN negociocliente.TipoUbicacionNegocio WHERE negociocliente.TipoUbicacionNegocio.id="+String.valueOf(tipoubicacionnegocio.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			NegocioClienteDataAccess negocioclienteDataAccess=new NegocioClienteDataAccess();

			negocioclienteDataAccess.setConnexionType(this.connexionType);
			negocioclienteDataAccess.setParameterDbType(this.parameterDbType);
			negocioclientes=negocioclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return negocioclientes;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoUbicacionNegocio tipoubicacionnegocio) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tipoubicacionnegocio.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(tipoubicacionnegocio.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(tipoubicacionnegocio.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tipoubicacionnegocio.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!tipoubicacionnegocio.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tipoubicacionnegocio.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tipoubicacionnegocio.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tipoubicacionnegocio.getId());
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
	
	public void setIsNewIsChangedFalseTipoUbicacionNegocio(TipoUbicacionNegocio tipoubicacionnegocio)throws Exception  {		
		tipoubicacionnegocio.setIsNew(false);
		tipoubicacionnegocio.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoUbicacionNegocios(List<TipoUbicacionNegocio> tipoubicacionnegocios)throws Exception  {				
		for(TipoUbicacionNegocio tipoubicacionnegocio:tipoubicacionnegocios) {
			tipoubicacionnegocio.setIsNew(false);
			tipoubicacionnegocio.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoUbicacionNegocio(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
