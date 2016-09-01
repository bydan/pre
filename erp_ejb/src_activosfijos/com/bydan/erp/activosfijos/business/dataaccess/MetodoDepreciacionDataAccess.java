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
import com.bydan.erp.activosfijos.util.*;//MetodoDepreciacionConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class MetodoDepreciacionDataAccess extends  MetodoDepreciacionDataAccessAdditional{ //MetodoDepreciacionDataAccessAdditional,DataAccessHelper<MetodoDepreciacion>
	//static Logger logger = Logger.getLogger(MetodoDepreciacionDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="metodo_depreciacion";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+MetodoDepreciacionConstantesFunciones.SCHEMA+"."+MetodoDepreciacionConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_detalle_activo_fijo,id_anio,fecha_desde,fecha_hasta,porcentaje,valor,numero_dias)values(current_timestamp,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+MetodoDepreciacionConstantesFunciones.SCHEMA+"."+MetodoDepreciacionConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_detalle_activo_fijo=?,id_anio=?,fecha_desde=?,fecha_hasta=?,porcentaje=?,valor=?,numero_dias=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+MetodoDepreciacionConstantesFunciones.SCHEMA+"."+MetodoDepreciacionConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select metododepreciacion from "+MetodoDepreciacionConstantesFunciones.SPERSISTENCENAME+" metododepreciacion";
	public static String QUERYSELECTNATIVE="select "+MetodoDepreciacionConstantesFunciones.SCHEMA+"."+MetodoDepreciacionConstantesFunciones.TABLENAME+".id,"+MetodoDepreciacionConstantesFunciones.SCHEMA+"."+MetodoDepreciacionConstantesFunciones.TABLENAME+".version_row,"+MetodoDepreciacionConstantesFunciones.SCHEMA+"."+MetodoDepreciacionConstantesFunciones.TABLENAME+".id_empresa,"+MetodoDepreciacionConstantesFunciones.SCHEMA+"."+MetodoDepreciacionConstantesFunciones.TABLENAME+".id_sucursal,"+MetodoDepreciacionConstantesFunciones.SCHEMA+"."+MetodoDepreciacionConstantesFunciones.TABLENAME+".id_detalle_activo_fijo,"+MetodoDepreciacionConstantesFunciones.SCHEMA+"."+MetodoDepreciacionConstantesFunciones.TABLENAME+".id_anio,"+MetodoDepreciacionConstantesFunciones.SCHEMA+"."+MetodoDepreciacionConstantesFunciones.TABLENAME+".fecha_desde,"+MetodoDepreciacionConstantesFunciones.SCHEMA+"."+MetodoDepreciacionConstantesFunciones.TABLENAME+".fecha_hasta,"+MetodoDepreciacionConstantesFunciones.SCHEMA+"."+MetodoDepreciacionConstantesFunciones.TABLENAME+".porcentaje,"+MetodoDepreciacionConstantesFunciones.SCHEMA+"."+MetodoDepreciacionConstantesFunciones.TABLENAME+".valor,"+MetodoDepreciacionConstantesFunciones.SCHEMA+"."+MetodoDepreciacionConstantesFunciones.TABLENAME+".numero_dias from "+MetodoDepreciacionConstantesFunciones.SCHEMA+"."+MetodoDepreciacionConstantesFunciones.TABLENAME;//+" as "+MetodoDepreciacionConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+MetodoDepreciacionConstantesFunciones.SCHEMA+"."+MetodoDepreciacionConstantesFunciones.TABLENAME+".id,"+MetodoDepreciacionConstantesFunciones.SCHEMA+"."+MetodoDepreciacionConstantesFunciones.TABLENAME+".version_row from "+MetodoDepreciacionConstantesFunciones.SCHEMA+"."+MetodoDepreciacionConstantesFunciones.TABLENAME;//+" as "+MetodoDepreciacionConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+MetodoDepreciacionConstantesFunciones.SCHEMA+"."+MetodoDepreciacionConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_detalle_activo_fijo=?,id_anio=?,fecha_desde=?,fecha_hasta=?,porcentaje=?,valor=?,numero_dias=?";
	
	public static String STOREPROCEDUREINSERT="call SP_METODODEPRECIACION_INSERT(?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_METODODEPRECIACION_UPDATE(?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_METODODEPRECIACION_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_METODODEPRECIACION_SELECT(?,?)";
	
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
	
	
	protected MetodoDepreciacionDataAccessAdditional metododepreciacionDataAccessAdditional=null;
	
	public MetodoDepreciacionDataAccessAdditional getMetodoDepreciacionDataAccessAdditional() {
		return this.metododepreciacionDataAccessAdditional;
	}
	
	public void setMetodoDepreciacionDataAccessAdditional(MetodoDepreciacionDataAccessAdditional metododepreciacionDataAccessAdditional) {
		try {
			this.metododepreciacionDataAccessAdditional=metododepreciacionDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public MetodoDepreciacionDataAccess() {
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
		MetodoDepreciacionDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		MetodoDepreciacionDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		MetodoDepreciacionDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setMetodoDepreciacionOriginal(MetodoDepreciacion metododepreciacion)throws Exception  {
		metododepreciacion.setMetodoDepreciacionOriginal((MetodoDepreciacion)metododepreciacion.clone());		
	}
	
	public void setMetodoDepreciacionsOriginal(List<MetodoDepreciacion> metododepreciacions)throws Exception  {
		
		for(MetodoDepreciacion metododepreciacion:metododepreciacions){
			metododepreciacion.setMetodoDepreciacionOriginal((MetodoDepreciacion)metododepreciacion.clone());
		}
	}
	
	public static void setMetodoDepreciacionOriginalStatic(MetodoDepreciacion metododepreciacion)throws Exception  {
		metododepreciacion.setMetodoDepreciacionOriginal((MetodoDepreciacion)metododepreciacion.clone());		
	}
	
	public static void setMetodoDepreciacionsOriginalStatic(List<MetodoDepreciacion> metododepreciacions)throws Exception  {
		
		for(MetodoDepreciacion metododepreciacion:metododepreciacions){
			metododepreciacion.setMetodoDepreciacionOriginal((MetodoDepreciacion)metododepreciacion.clone());
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
	
	public  MetodoDepreciacion getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		MetodoDepreciacion entity = new MetodoDepreciacion();		
		
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
	
	public  MetodoDepreciacion getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		MetodoDepreciacion entity = new MetodoDepreciacion();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=MetodoDepreciacionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=MetodoDepreciacionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//ActivosFijos.MetodoDepreciacion.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setMetodoDepreciacionOriginal(new MetodoDepreciacion());
      	    	entity=super.getEntity("",entity,resultSet,MetodoDepreciacionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityMetodoDepreciacion("",entity,resultSet); 
				
				//entity.setMetodoDepreciacionOriginal(super.getEntity("",entity.getMetodoDepreciacionOriginal(),resultSet,MetodoDepreciacionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setMetodoDepreciacionOriginal(this.getEntityMetodoDepreciacion("",entity.getMetodoDepreciacionOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseMetodoDepreciacion(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  MetodoDepreciacion getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		MetodoDepreciacion entity = new MetodoDepreciacion();
				
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
	
	public  MetodoDepreciacion getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		MetodoDepreciacion entity = new MetodoDepreciacion();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=MetodoDepreciacionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=MetodoDepreciacionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,MetodoDepreciacionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//ActivosFijos.MetodoDepreciacion.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setMetodoDepreciacionOriginal(new MetodoDepreciacion());
      	    	entity=super.getEntity("",entity,resultSet,MetodoDepreciacionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityMetodoDepreciacion("",entity,resultSet);    
				
				//entity.setMetodoDepreciacionOriginal(super.getEntity("",entity.getMetodoDepreciacionOriginal(),resultSet,MetodoDepreciacionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setMetodoDepreciacionOriginal(this.getEntityMetodoDepreciacion("",entity.getMetodoDepreciacionOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseMetodoDepreciacion(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //MetodoDepreciacion
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		MetodoDepreciacion entity = new MetodoDepreciacion();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=MetodoDepreciacionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=MetodoDepreciacionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,MetodoDepreciacionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//ActivosFijos.MetodoDepreciacion.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseMetodoDepreciacion(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<MetodoDepreciacion> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<MetodoDepreciacion> entities = new  ArrayList<MetodoDepreciacion>();
		MetodoDepreciacion entity = new MetodoDepreciacion();		  
		
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
	
	public  List<MetodoDepreciacion> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<MetodoDepreciacion> entities = new  ArrayList<MetodoDepreciacion>();
		MetodoDepreciacion entity = new MetodoDepreciacion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=MetodoDepreciacionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=MetodoDepreciacionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,MetodoDepreciacionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new MetodoDepreciacion();
      	    	entity=super.getEntity("",entity,resultSet,MetodoDepreciacionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityMetodoDepreciacion("",entity,resultSet);
      	    	
				//entity.setMetodoDepreciacionOriginal( new MetodoDepreciacion());
      	    	//entity.setMetodoDepreciacionOriginal(super.getEntity("",entity.getMetodoDepreciacionOriginal(),resultSet,MetodoDepreciacionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setMetodoDepreciacionOriginal(this.getEntityMetodoDepreciacion("",entity.getMetodoDepreciacionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseMetodoDepreciacions(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarMetodoDepreciacion(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<MetodoDepreciacion> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<MetodoDepreciacion> entities = new  ArrayList<MetodoDepreciacion>();
		MetodoDepreciacion entity = new MetodoDepreciacion();		  
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
	
	public  List<MetodoDepreciacion> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<MetodoDepreciacion> entities = new  ArrayList<MetodoDepreciacion>();
		MetodoDepreciacion entity = new MetodoDepreciacion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new MetodoDepreciacion();
				
				if(conMapGenerico) {
					entity.inicializarMapMetodoDepreciacion();
					//entity.setMapMetodoDepreciacion(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapMetodoDepreciacionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapMetodoDepreciacion().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,MetodoDepreciacionDataAccess.ISWITHSCHEMA);         		
					entity=MetodoDepreciacionDataAccess.getEntityMetodoDepreciacion("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setMetodoDepreciacionOriginal( new MetodoDepreciacion());
					////entity.setMetodoDepreciacionOriginal(super.getEntity("",entity.getMetodoDepreciacionOriginal(),resultSet,MetodoDepreciacionDataAccess.ISWITHSCHEMA));         		
					////entity.setMetodoDepreciacionOriginal(this.getEntityMetodoDepreciacion("",entity.getMetodoDepreciacionOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseMetodoDepreciacions(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarMetodoDepreciacion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public MetodoDepreciacion getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		MetodoDepreciacion entity = new MetodoDepreciacion();		  
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
	
	public  MetodoDepreciacion getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		MetodoDepreciacion entity = new MetodoDepreciacion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new MetodoDepreciacion();
				
				if(conMapGenerico) {
					entity.inicializarMapMetodoDepreciacion();
					//entity.setMapMetodoDepreciacion(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapMetodoDepreciacionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapMetodoDepreciacion().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,MetodoDepreciacionDataAccess.ISWITHSCHEMA);         		
					entity=MetodoDepreciacionDataAccess.getEntityMetodoDepreciacion("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setMetodoDepreciacionOriginal( new MetodoDepreciacion());
					////entity.setMetodoDepreciacionOriginal(super.getEntity("",entity.getMetodoDepreciacionOriginal(),resultSet,MetodoDepreciacionDataAccess.ISWITHSCHEMA));         		
					////entity.setMetodoDepreciacionOriginal(this.getEntityMetodoDepreciacion("",entity.getMetodoDepreciacionOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseMetodoDepreciacion(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarMetodoDepreciacion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static MetodoDepreciacion getEntityMetodoDepreciacion(String strPrefijo,MetodoDepreciacion entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = MetodoDepreciacion.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = MetodoDepreciacion.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					MetodoDepreciacionDataAccess.setFieldReflectionMetodoDepreciacion(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasMetodoDepreciacion=MetodoDepreciacionConstantesFunciones.getTodosTiposColumnasMetodoDepreciacion();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasMetodoDepreciacion) {
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
							field = MetodoDepreciacion.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = MetodoDepreciacion.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						MetodoDepreciacionDataAccess.setFieldReflectionMetodoDepreciacion(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionMetodoDepreciacion(Field field,String strPrefijo,String sColumn,MetodoDepreciacion entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case MetodoDepreciacionConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case MetodoDepreciacionConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case MetodoDepreciacionConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case MetodoDepreciacionConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case MetodoDepreciacionConstantesFunciones.IDDETALLEACTIVOFIJO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case MetodoDepreciacionConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case MetodoDepreciacionConstantesFunciones.FECHADESDE:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case MetodoDepreciacionConstantesFunciones.FECHAHASTA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case MetodoDepreciacionConstantesFunciones.PORCENTAJE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case MetodoDepreciacionConstantesFunciones.VALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case MetodoDepreciacionConstantesFunciones.NUMERODIAS:
					field.set(entity,resultSet.getInt(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<MetodoDepreciacion>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<MetodoDepreciacion> entities = new  ArrayList<MetodoDepreciacion>();
		MetodoDepreciacion entity = new MetodoDepreciacion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=MetodoDepreciacionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=MetodoDepreciacionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,MetodoDepreciacionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new MetodoDepreciacion();
					entity=super.getEntity("",entity,resultSet,MetodoDepreciacionDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityMetodoDepreciacion("",entity,resultSet);
					
					//entity.setMetodoDepreciacionOriginal( new MetodoDepreciacion());
					//entity.setMetodoDepreciacionOriginal(super.getEntity("",entity.getMetodoDepreciacionOriginal(),resultSet,MetodoDepreciacionDataAccess.ISWITHSCHEMA));         		
					//entity.setMetodoDepreciacionOriginal(this.getEntityMetodoDepreciacion("",entity.getMetodoDepreciacionOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseMetodoDepreciacions(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarMetodoDepreciacion(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<MetodoDepreciacion>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<MetodoDepreciacion> entities = new  ArrayList<MetodoDepreciacion>();
		MetodoDepreciacion entity = new MetodoDepreciacion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=MetodoDepreciacionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=MetodoDepreciacionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,MetodoDepreciacionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<MetodoDepreciacion> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<MetodoDepreciacion> entities = new  ArrayList<MetodoDepreciacion>();
		MetodoDepreciacion entity = new MetodoDepreciacion();		  
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
	
	public  List<MetodoDepreciacion> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<MetodoDepreciacion> entities = new  ArrayList<MetodoDepreciacion>();
		MetodoDepreciacion entity = new MetodoDepreciacion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new MetodoDepreciacion();
      	    	entity=super.getEntity("",entity,resultSet,MetodoDepreciacionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityMetodoDepreciacion("",entity,resultSet);
      	    	
				//entity.setMetodoDepreciacionOriginal( new MetodoDepreciacion());
      	    	//entity.setMetodoDepreciacionOriginal(super.getEntity("",entity.getMetodoDepreciacionOriginal(),resultSet,MetodoDepreciacionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setMetodoDepreciacionOriginal(this.getEntityMetodoDepreciacion("",entity.getMetodoDepreciacionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseMetodoDepreciacions(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarMetodoDepreciacion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<MetodoDepreciacion> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<MetodoDepreciacion> entities = new  ArrayList<MetodoDepreciacion>();
		MetodoDepreciacion entity = new MetodoDepreciacion();		  
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
	
	public  List<MetodoDepreciacion> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<MetodoDepreciacion> entities = new  ArrayList<MetodoDepreciacion>();
		MetodoDepreciacion entity = new MetodoDepreciacion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new MetodoDepreciacion();
      	    	entity=super.getEntity("",entity,resultSet,MetodoDepreciacionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityMetodoDepreciacion("",entity,resultSet);
      	    	
				//entity.setMetodoDepreciacionOriginal( new MetodoDepreciacion());
      	    	//entity.setMetodoDepreciacionOriginal(super.getEntity("",entity.getMetodoDepreciacionOriginal(),resultSet,MetodoDepreciacionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setMetodoDepreciacionOriginal(this.getEntityMetodoDepreciacion("",entity.getMetodoDepreciacionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseMetodoDepreciacions(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public MetodoDepreciacion getEntityMetodoDepreciacion(String strPrefijo,MetodoDepreciacion entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+MetodoDepreciacionConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+MetodoDepreciacionConstantesFunciones.IDSUCURSAL));
				entity.setid_detalle_activo_fijo(resultSet.getLong(strPrefijo+MetodoDepreciacionConstantesFunciones.IDDETALLEACTIVOFIJO));
				entity.setid_anio(resultSet.getLong(strPrefijo+MetodoDepreciacionConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
				entity.setfecha_desde(new Date(resultSet.getDate(strPrefijo+MetodoDepreciacionConstantesFunciones.FECHADESDE).getTime()));
				entity.setfecha_hasta(new Date(resultSet.getDate(strPrefijo+MetodoDepreciacionConstantesFunciones.FECHAHASTA).getTime()));
				entity.setporcentaje(resultSet.getDouble(strPrefijo+MetodoDepreciacionConstantesFunciones.PORCENTAJE));
				entity.setvalor(resultSet.getDouble(strPrefijo+MetodoDepreciacionConstantesFunciones.VALOR));
				entity.setnumero_dias(resultSet.getInt(strPrefijo+MetodoDepreciacionConstantesFunciones.NUMERODIAS));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowMetodoDepreciacion(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(MetodoDepreciacion entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=MetodoDepreciacionDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=MetodoDepreciacionDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=MetodoDepreciacionDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=MetodoDepreciacionDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(MetodoDepreciacionConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,MetodoDepreciacionDataAccess.TABLENAME,MetodoDepreciacionDataAccess.ISWITHSTOREPROCEDURES);
			
			MetodoDepreciacionDataAccess.setMetodoDepreciacionOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,MetodoDepreciacion relmetododepreciacion)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relmetododepreciacion.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,MetodoDepreciacion relmetododepreciacion)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relmetododepreciacion.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public DetalleActivoFijo getDetalleActivoFijo(Connexion connexion,MetodoDepreciacion relmetododepreciacion)throws SQLException,Exception {

		DetalleActivoFijo detalleactivofijo= new DetalleActivoFijo();

		try {
			DetalleActivoFijoDataAccess detalleactivofijoDataAccess=new DetalleActivoFijoDataAccess();

			detalleactivofijoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			detalleactivofijoDataAccess.setConnexionType(this.connexionType);
			detalleactivofijoDataAccess.setParameterDbType(this.parameterDbType);

			detalleactivofijo=detalleactivofijoDataAccess.getEntity(connexion,relmetododepreciacion.getid_detalle_activo_fijo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalleactivofijo;

	}

	public Anio getAnio(Connexion connexion,MetodoDepreciacion relmetododepreciacion)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);

			anio=anioDataAccess.getEntity(connexion,relmetododepreciacion.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,MetodoDepreciacion metododepreciacion) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!metododepreciacion.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(metododepreciacion.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(metododepreciacion.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_detalle_activo_fijo=new ParameterValue<Long>();
					parameterMaintenanceValueid_detalle_activo_fijo.setValue(metododepreciacion.getid_detalle_activo_fijo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_detalle_activo_fijo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_anio=new ParameterValue<Long>();
					parameterMaintenanceValueid_anio.setValue(metododepreciacion.getid_anio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_anio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_desde=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_desde.setValue(metododepreciacion.getfecha_desde());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_desde);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_hasta=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_hasta.setValue(metododepreciacion.getfecha_hasta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_hasta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcentaje=new ParameterValue<Double>();
					parameterMaintenanceValueporcentaje.setValue(metododepreciacion.getporcentaje());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcentaje);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor=new ParameterValue<Double>();
					parameterMaintenanceValuevalor.setValue(metododepreciacion.getvalor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuenumero_dias=new ParameterValue<Integer>();
					parameterMaintenanceValuenumero_dias.setValue(metododepreciacion.getnumero_dias());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_dias);
					parametersTemp.add(parameterMaintenance);
					
						if(!metododepreciacion.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(metododepreciacion.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(metododepreciacion.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(metododepreciacion.getId());
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
	
	public void setIsNewIsChangedFalseMetodoDepreciacion(MetodoDepreciacion metododepreciacion)throws Exception  {		
		metododepreciacion.setIsNew(false);
		metododepreciacion.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseMetodoDepreciacions(List<MetodoDepreciacion> metododepreciacions)throws Exception  {				
		for(MetodoDepreciacion metododepreciacion:metododepreciacions) {
			metododepreciacion.setIsNew(false);
			metododepreciacion.setIsChanged(false);
		}
	}
	
	public void generarExportarMetodoDepreciacion(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
