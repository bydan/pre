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
package com.bydan.erp.activosfijos.business.dataaccess;

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

import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.activosfijos.util.*;//GastoDepreciacionConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class GastoDepreciacionDataAccess extends  GastoDepreciacionDataAccessAdditional{ //GastoDepreciacionDataAccessAdditional,DataAccessHelper<GastoDepreciacion>
	//static Logger logger = Logger.getLogger(GastoDepreciacionDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="gasto_depreciacion";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+GastoDepreciacionConstantesFunciones.SCHEMA+"."+GastoDepreciacionConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_detalle_grupo_activo_fijo,anio,valor)values(current_timestamp,?,?,?,?)";
	public static String QUERYUPDATE="update "+GastoDepreciacionConstantesFunciones.SCHEMA+"."+GastoDepreciacionConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_detalle_grupo_activo_fijo=?,anio=?,valor=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+GastoDepreciacionConstantesFunciones.SCHEMA+"."+GastoDepreciacionConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select gastodepreciacion from "+GastoDepreciacionConstantesFunciones.SPERSISTENCENAME+" gastodepreciacion";
	public static String QUERYSELECTNATIVE="select "+GastoDepreciacionConstantesFunciones.SCHEMA+"."+GastoDepreciacionConstantesFunciones.TABLENAME+".id,"+GastoDepreciacionConstantesFunciones.SCHEMA+"."+GastoDepreciacionConstantesFunciones.TABLENAME+".version_row,"+GastoDepreciacionConstantesFunciones.SCHEMA+"."+GastoDepreciacionConstantesFunciones.TABLENAME+".id_empresa,"+GastoDepreciacionConstantesFunciones.SCHEMA+"."+GastoDepreciacionConstantesFunciones.TABLENAME+".id_detalle_grupo_activo_fijo,"+GastoDepreciacionConstantesFunciones.SCHEMA+"."+GastoDepreciacionConstantesFunciones.TABLENAME+".anio,"+GastoDepreciacionConstantesFunciones.SCHEMA+"."+GastoDepreciacionConstantesFunciones.TABLENAME+".valor from "+GastoDepreciacionConstantesFunciones.SCHEMA+"."+GastoDepreciacionConstantesFunciones.TABLENAME;//+" as "+GastoDepreciacionConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+GastoDepreciacionConstantesFunciones.SCHEMA+"."+GastoDepreciacionConstantesFunciones.TABLENAME+".id,"+GastoDepreciacionConstantesFunciones.SCHEMA+"."+GastoDepreciacionConstantesFunciones.TABLENAME+".version_row from "+GastoDepreciacionConstantesFunciones.SCHEMA+"."+GastoDepreciacionConstantesFunciones.TABLENAME;//+" as "+GastoDepreciacionConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+GastoDepreciacionConstantesFunciones.SCHEMA+"."+GastoDepreciacionConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_detalle_grupo_activo_fijo=?,anio=?,valor=?";
	
	public static String STOREPROCEDUREINSERT="call SP_GASTODEPRECIACION_INSERT(?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_GASTODEPRECIACION_UPDATE(?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_GASTODEPRECIACION_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_GASTODEPRECIACION_SELECT(?,?)";
	
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
	
	
	protected GastoDepreciacionDataAccessAdditional gastodepreciacionDataAccessAdditional=null;
	
	public GastoDepreciacionDataAccessAdditional getGastoDepreciacionDataAccessAdditional() {
		return this.gastodepreciacionDataAccessAdditional;
	}
	
	public void setGastoDepreciacionDataAccessAdditional(GastoDepreciacionDataAccessAdditional gastodepreciacionDataAccessAdditional) {
		try {
			this.gastodepreciacionDataAccessAdditional=gastodepreciacionDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public GastoDepreciacionDataAccess() {
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
		GastoDepreciacionDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		GastoDepreciacionDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		GastoDepreciacionDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setGastoDepreciacionOriginal(GastoDepreciacion gastodepreciacion)throws Exception  {
		gastodepreciacion.setGastoDepreciacionOriginal((GastoDepreciacion)gastodepreciacion.clone());		
	}
	
	public void setGastoDepreciacionsOriginal(List<GastoDepreciacion> gastodepreciacions)throws Exception  {
		
		for(GastoDepreciacion gastodepreciacion:gastodepreciacions){
			gastodepreciacion.setGastoDepreciacionOriginal((GastoDepreciacion)gastodepreciacion.clone());
		}
	}
	
	public static void setGastoDepreciacionOriginalStatic(GastoDepreciacion gastodepreciacion)throws Exception  {
		gastodepreciacion.setGastoDepreciacionOriginal((GastoDepreciacion)gastodepreciacion.clone());		
	}
	
	public static void setGastoDepreciacionsOriginalStatic(List<GastoDepreciacion> gastodepreciacions)throws Exception  {
		
		for(GastoDepreciacion gastodepreciacion:gastodepreciacions){
			gastodepreciacion.setGastoDepreciacionOriginal((GastoDepreciacion)gastodepreciacion.clone());
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
	
	public  GastoDepreciacion getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		GastoDepreciacion entity = new GastoDepreciacion();		
		
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
	
	public  GastoDepreciacion getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		GastoDepreciacion entity = new GastoDepreciacion();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=GastoDepreciacionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=GastoDepreciacionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//ActivosFijos.GastoDepreciacion.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setGastoDepreciacionOriginal(new GastoDepreciacion());
      	    	entity=super.getEntity("",entity,resultSet,GastoDepreciacionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityGastoDepreciacion("",entity,resultSet); 
				
				//entity.setGastoDepreciacionOriginal(super.getEntity("",entity.getGastoDepreciacionOriginal(),resultSet,GastoDepreciacionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setGastoDepreciacionOriginal(this.getEntityGastoDepreciacion("",entity.getGastoDepreciacionOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseGastoDepreciacion(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  GastoDepreciacion getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		GastoDepreciacion entity = new GastoDepreciacion();
				
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
	
	public  GastoDepreciacion getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		GastoDepreciacion entity = new GastoDepreciacion();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=GastoDepreciacionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=GastoDepreciacionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,GastoDepreciacionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//ActivosFijos.GastoDepreciacion.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setGastoDepreciacionOriginal(new GastoDepreciacion());
      	    	entity=super.getEntity("",entity,resultSet,GastoDepreciacionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityGastoDepreciacion("",entity,resultSet);    
				
				//entity.setGastoDepreciacionOriginal(super.getEntity("",entity.getGastoDepreciacionOriginal(),resultSet,GastoDepreciacionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setGastoDepreciacionOriginal(this.getEntityGastoDepreciacion("",entity.getGastoDepreciacionOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseGastoDepreciacion(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //GastoDepreciacion
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		GastoDepreciacion entity = new GastoDepreciacion();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=GastoDepreciacionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=GastoDepreciacionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,GastoDepreciacionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//ActivosFijos.GastoDepreciacion.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseGastoDepreciacion(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<GastoDepreciacion> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<GastoDepreciacion> entities = new  ArrayList<GastoDepreciacion>();
		GastoDepreciacion entity = new GastoDepreciacion();		  
		
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
	
	public  List<GastoDepreciacion> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<GastoDepreciacion> entities = new  ArrayList<GastoDepreciacion>();
		GastoDepreciacion entity = new GastoDepreciacion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=GastoDepreciacionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=GastoDepreciacionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,GastoDepreciacionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new GastoDepreciacion();
      	    	entity=super.getEntity("",entity,resultSet,GastoDepreciacionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityGastoDepreciacion("",entity,resultSet);
      	    	
				//entity.setGastoDepreciacionOriginal( new GastoDepreciacion());
      	    	//entity.setGastoDepreciacionOriginal(super.getEntity("",entity.getGastoDepreciacionOriginal(),resultSet,GastoDepreciacionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setGastoDepreciacionOriginal(this.getEntityGastoDepreciacion("",entity.getGastoDepreciacionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseGastoDepreciacions(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarGastoDepreciacion(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<GastoDepreciacion> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<GastoDepreciacion> entities = new  ArrayList<GastoDepreciacion>();
		GastoDepreciacion entity = new GastoDepreciacion();		  
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
	
	public  List<GastoDepreciacion> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<GastoDepreciacion> entities = new  ArrayList<GastoDepreciacion>();
		GastoDepreciacion entity = new GastoDepreciacion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new GastoDepreciacion();
				
				if(conMapGenerico) {
					entity.inicializarMapGastoDepreciacion();
					//entity.setMapGastoDepreciacion(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapGastoDepreciacionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapGastoDepreciacion().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,GastoDepreciacionDataAccess.ISWITHSCHEMA);         		
					entity=GastoDepreciacionDataAccess.getEntityGastoDepreciacion("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setGastoDepreciacionOriginal( new GastoDepreciacion());
					////entity.setGastoDepreciacionOriginal(super.getEntity("",entity.getGastoDepreciacionOriginal(),resultSet,GastoDepreciacionDataAccess.ISWITHSCHEMA));         		
					////entity.setGastoDepreciacionOriginal(this.getEntityGastoDepreciacion("",entity.getGastoDepreciacionOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseGastoDepreciacions(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarGastoDepreciacion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public GastoDepreciacion getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		GastoDepreciacion entity = new GastoDepreciacion();		  
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
	
	public  GastoDepreciacion getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		GastoDepreciacion entity = new GastoDepreciacion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new GastoDepreciacion();
				
				if(conMapGenerico) {
					entity.inicializarMapGastoDepreciacion();
					//entity.setMapGastoDepreciacion(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapGastoDepreciacionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapGastoDepreciacion().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,GastoDepreciacionDataAccess.ISWITHSCHEMA);         		
					entity=GastoDepreciacionDataAccess.getEntityGastoDepreciacion("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setGastoDepreciacionOriginal( new GastoDepreciacion());
					////entity.setGastoDepreciacionOriginal(super.getEntity("",entity.getGastoDepreciacionOriginal(),resultSet,GastoDepreciacionDataAccess.ISWITHSCHEMA));         		
					////entity.setGastoDepreciacionOriginal(this.getEntityGastoDepreciacion("",entity.getGastoDepreciacionOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseGastoDepreciacion(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarGastoDepreciacion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static GastoDepreciacion getEntityGastoDepreciacion(String strPrefijo,GastoDepreciacion entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = GastoDepreciacion.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = GastoDepreciacion.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					GastoDepreciacionDataAccess.setFieldReflectionGastoDepreciacion(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasGastoDepreciacion=GastoDepreciacionConstantesFunciones.getTodosTiposColumnasGastoDepreciacion();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasGastoDepreciacion) {
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
							field = GastoDepreciacion.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = GastoDepreciacion.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						GastoDepreciacionDataAccess.setFieldReflectionGastoDepreciacion(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionGastoDepreciacion(Field field,String strPrefijo,String sColumn,GastoDepreciacion entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case GastoDepreciacionConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case GastoDepreciacionConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case GastoDepreciacionConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case GastoDepreciacionConstantesFunciones.IDDETALLEGRUPOACTIVOFIJO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case GastoDepreciacionConstantesFunciones.ANIO:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case GastoDepreciacionConstantesFunciones.VALOR:
					field.set(entity,resultSet.getDouble(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<GastoDepreciacion>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<GastoDepreciacion> entities = new  ArrayList<GastoDepreciacion>();
		GastoDepreciacion entity = new GastoDepreciacion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=GastoDepreciacionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=GastoDepreciacionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,GastoDepreciacionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new GastoDepreciacion();
					entity=super.getEntity("",entity,resultSet,GastoDepreciacionDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityGastoDepreciacion("",entity,resultSet);
					
					//entity.setGastoDepreciacionOriginal( new GastoDepreciacion());
					//entity.setGastoDepreciacionOriginal(super.getEntity("",entity.getGastoDepreciacionOriginal(),resultSet,GastoDepreciacionDataAccess.ISWITHSCHEMA));         		
					//entity.setGastoDepreciacionOriginal(this.getEntityGastoDepreciacion("",entity.getGastoDepreciacionOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseGastoDepreciacions(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarGastoDepreciacion(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<GastoDepreciacion>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<GastoDepreciacion> entities = new  ArrayList<GastoDepreciacion>();
		GastoDepreciacion entity = new GastoDepreciacion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=GastoDepreciacionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=GastoDepreciacionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,GastoDepreciacionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<GastoDepreciacion> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<GastoDepreciacion> entities = new  ArrayList<GastoDepreciacion>();
		GastoDepreciacion entity = new GastoDepreciacion();		  
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
	
	public  List<GastoDepreciacion> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<GastoDepreciacion> entities = new  ArrayList<GastoDepreciacion>();
		GastoDepreciacion entity = new GastoDepreciacion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new GastoDepreciacion();
      	    	entity=super.getEntity("",entity,resultSet,GastoDepreciacionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityGastoDepreciacion("",entity,resultSet);
      	    	
				//entity.setGastoDepreciacionOriginal( new GastoDepreciacion());
      	    	//entity.setGastoDepreciacionOriginal(super.getEntity("",entity.getGastoDepreciacionOriginal(),resultSet,GastoDepreciacionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setGastoDepreciacionOriginal(this.getEntityGastoDepreciacion("",entity.getGastoDepreciacionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseGastoDepreciacions(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarGastoDepreciacion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<GastoDepreciacion> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<GastoDepreciacion> entities = new  ArrayList<GastoDepreciacion>();
		GastoDepreciacion entity = new GastoDepreciacion();		  
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
	
	public  List<GastoDepreciacion> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<GastoDepreciacion> entities = new  ArrayList<GastoDepreciacion>();
		GastoDepreciacion entity = new GastoDepreciacion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new GastoDepreciacion();
      	    	entity=super.getEntity("",entity,resultSet,GastoDepreciacionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityGastoDepreciacion("",entity,resultSet);
      	    	
				//entity.setGastoDepreciacionOriginal( new GastoDepreciacion());
      	    	//entity.setGastoDepreciacionOriginal(super.getEntity("",entity.getGastoDepreciacionOriginal(),resultSet,GastoDepreciacionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setGastoDepreciacionOriginal(this.getEntityGastoDepreciacion("",entity.getGastoDepreciacionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseGastoDepreciacions(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public GastoDepreciacion getEntityGastoDepreciacion(String strPrefijo,GastoDepreciacion entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+GastoDepreciacionConstantesFunciones.IDEMPRESA));
				entity.setid_detalle_grupo_activo_fijo(resultSet.getLong(strPrefijo+GastoDepreciacionConstantesFunciones.IDDETALLEGRUPOACTIVOFIJO));
				entity.setanio(resultSet.getInt(strPrefijo+GastoDepreciacionConstantesFunciones.ANIO));
				entity.setvalor(resultSet.getDouble(strPrefijo+GastoDepreciacionConstantesFunciones.VALOR));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowGastoDepreciacion(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(GastoDepreciacion entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=GastoDepreciacionDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=GastoDepreciacionDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=GastoDepreciacionDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=GastoDepreciacionDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(GastoDepreciacionConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,GastoDepreciacionDataAccess.TABLENAME,GastoDepreciacionDataAccess.ISWITHSTOREPROCEDURES);
			
			GastoDepreciacionDataAccess.setGastoDepreciacionOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,GastoDepreciacion relgastodepreciacion)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relgastodepreciacion.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public DetalleGrupoActivoFijo getDetalleGrupoActivoFijo(Connexion connexion,GastoDepreciacion relgastodepreciacion)throws SQLException,Exception {

		DetalleGrupoActivoFijo detallegrupoactivofijo= new DetalleGrupoActivoFijo();

		try {
			DetalleGrupoActivoFijoDataAccess detallegrupoactivofijoDataAccess=new DetalleGrupoActivoFijoDataAccess();

			detallegrupoactivofijoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			detallegrupoactivofijoDataAccess.setConnexionType(this.connexionType);
			detallegrupoactivofijoDataAccess.setParameterDbType(this.parameterDbType);

			detallegrupoactivofijo=detallegrupoactivofijoDataAccess.getEntity(connexion,relgastodepreciacion.getid_detalle_grupo_activo_fijo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detallegrupoactivofijo;

	}


		
		public List<CuentaContaGastoDepre> getCuentaContaGastoDepres(Connexion connexion,GastoDepreciacion gastodepreciacion)throws SQLException,Exception {

		List<CuentaContaGastoDepre> cuentacontagastodepres= new ArrayList<CuentaContaGastoDepre>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+GastoDepreciacionConstantesFunciones.SCHEMA+".gasto_depreciacion ON "+CuentaContaGastoDepreConstantesFunciones.SCHEMA+".cuenta_conta_gasto_depre.id_gasto_depreciacion="+GastoDepreciacionConstantesFunciones.SCHEMA+".gasto_depreciacion.id WHERE "+GastoDepreciacionConstantesFunciones.SCHEMA+".gasto_depreciacion.id="+String.valueOf(gastodepreciacion.getId());
			} else {
				sQuery=" INNER JOIN cuentacontagastodepre.GastoDepreciacion WHERE cuentacontagastodepre.GastoDepreciacion.id="+String.valueOf(gastodepreciacion.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			CuentaContaGastoDepreDataAccess cuentacontagastodepreDataAccess=new CuentaContaGastoDepreDataAccess();

			cuentacontagastodepreDataAccess.setConnexionType(this.connexionType);
			cuentacontagastodepreDataAccess.setParameterDbType(this.parameterDbType);
			cuentacontagastodepres=cuentacontagastodepreDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontagastodepres;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,GastoDepreciacion gastodepreciacion) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!gastodepreciacion.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(gastodepreciacion.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_detalle_grupo_activo_fijo=new ParameterValue<Long>();
					parameterMaintenanceValueid_detalle_grupo_activo_fijo.setValue(gastodepreciacion.getid_detalle_grupo_activo_fijo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_detalle_grupo_activo_fijo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValueanio=new ParameterValue<Integer>();
					parameterMaintenanceValueanio.setValue(gastodepreciacion.getanio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueanio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor=new ParameterValue<Double>();
					parameterMaintenanceValuevalor.setValue(gastodepreciacion.getvalor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor);
					parametersTemp.add(parameterMaintenance);
					
						if(!gastodepreciacion.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(gastodepreciacion.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(gastodepreciacion.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(gastodepreciacion.getId());
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
	
	public void setIsNewIsChangedFalseGastoDepreciacion(GastoDepreciacion gastodepreciacion)throws Exception  {		
		gastodepreciacion.setIsNew(false);
		gastodepreciacion.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseGastoDepreciacions(List<GastoDepreciacion> gastodepreciacions)throws Exception  {				
		for(GastoDepreciacion gastodepreciacion:gastodepreciacions) {
			gastodepreciacion.setIsNew(false);
			gastodepreciacion.setIsChanged(false);
		}
	}
	
	public void generarExportarGastoDepreciacion(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
