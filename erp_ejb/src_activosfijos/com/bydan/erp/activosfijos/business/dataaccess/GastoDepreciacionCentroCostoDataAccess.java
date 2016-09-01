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
import com.bydan.erp.activosfijos.util.*;//GastoDepreciacionCentroCostoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class GastoDepreciacionCentroCostoDataAccess extends  GastoDepreciacionCentroCostoDataAccessAdditional{ //GastoDepreciacionCentroCostoDataAccessAdditional,DataAccessHelper<GastoDepreciacionCentroCosto>
	//static Logger logger = Logger.getLogger(GastoDepreciacionCentroCostoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="gasto_depreciacion_centro_costo";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+GastoDepreciacionCentroCostoConstantesFunciones.SCHEMA+"."+GastoDepreciacionCentroCostoConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_centro_costo,id_detalle_activo_fijo,id_cuenta_contable,porcentaje)values(current_timestamp,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+GastoDepreciacionCentroCostoConstantesFunciones.SCHEMA+"."+GastoDepreciacionCentroCostoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_centro_costo=?,id_detalle_activo_fijo=?,id_cuenta_contable=?,porcentaje=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+GastoDepreciacionCentroCostoConstantesFunciones.SCHEMA+"."+GastoDepreciacionCentroCostoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select gastodepreciacioncentrocosto from "+GastoDepreciacionCentroCostoConstantesFunciones.SPERSISTENCENAME+" gastodepreciacioncentrocosto";
	public static String QUERYSELECTNATIVE="select "+GastoDepreciacionCentroCostoConstantesFunciones.SCHEMA+"."+GastoDepreciacionCentroCostoConstantesFunciones.TABLENAME+".id,"+GastoDepreciacionCentroCostoConstantesFunciones.SCHEMA+"."+GastoDepreciacionCentroCostoConstantesFunciones.TABLENAME+".version_row,"+GastoDepreciacionCentroCostoConstantesFunciones.SCHEMA+"."+GastoDepreciacionCentroCostoConstantesFunciones.TABLENAME+".id_empresa,"+GastoDepreciacionCentroCostoConstantesFunciones.SCHEMA+"."+GastoDepreciacionCentroCostoConstantesFunciones.TABLENAME+".id_sucursal,"+GastoDepreciacionCentroCostoConstantesFunciones.SCHEMA+"."+GastoDepreciacionCentroCostoConstantesFunciones.TABLENAME+".id_centro_costo,"+GastoDepreciacionCentroCostoConstantesFunciones.SCHEMA+"."+GastoDepreciacionCentroCostoConstantesFunciones.TABLENAME+".id_detalle_activo_fijo,"+GastoDepreciacionCentroCostoConstantesFunciones.SCHEMA+"."+GastoDepreciacionCentroCostoConstantesFunciones.TABLENAME+".id_cuenta_contable,"+GastoDepreciacionCentroCostoConstantesFunciones.SCHEMA+"."+GastoDepreciacionCentroCostoConstantesFunciones.TABLENAME+".porcentaje from "+GastoDepreciacionCentroCostoConstantesFunciones.SCHEMA+"."+GastoDepreciacionCentroCostoConstantesFunciones.TABLENAME;//+" as "+GastoDepreciacionCentroCostoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+GastoDepreciacionCentroCostoConstantesFunciones.SCHEMA+"."+GastoDepreciacionCentroCostoConstantesFunciones.TABLENAME+".id,"+GastoDepreciacionCentroCostoConstantesFunciones.SCHEMA+"."+GastoDepreciacionCentroCostoConstantesFunciones.TABLENAME+".version_row from "+GastoDepreciacionCentroCostoConstantesFunciones.SCHEMA+"."+GastoDepreciacionCentroCostoConstantesFunciones.TABLENAME;//+" as "+GastoDepreciacionCentroCostoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+GastoDepreciacionCentroCostoConstantesFunciones.SCHEMA+"."+GastoDepreciacionCentroCostoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_centro_costo=?,id_detalle_activo_fijo=?,id_cuenta_contable=?,porcentaje=?";
	
	public static String STOREPROCEDUREINSERT="call SP_GASTODEPRECIACIONCENTROCOSTO_INSERT(?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_GASTODEPRECIACIONCENTROCOSTO_UPDATE(?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_GASTODEPRECIACIONCENTROCOSTO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_GASTODEPRECIACIONCENTROCOSTO_SELECT(?,?)";
	
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
	
	
	protected GastoDepreciacionCentroCostoDataAccessAdditional gastodepreciacioncentrocostoDataAccessAdditional=null;
	
	public GastoDepreciacionCentroCostoDataAccessAdditional getGastoDepreciacionCentroCostoDataAccessAdditional() {
		return this.gastodepreciacioncentrocostoDataAccessAdditional;
	}
	
	public void setGastoDepreciacionCentroCostoDataAccessAdditional(GastoDepreciacionCentroCostoDataAccessAdditional gastodepreciacioncentrocostoDataAccessAdditional) {
		try {
			this.gastodepreciacioncentrocostoDataAccessAdditional=gastodepreciacioncentrocostoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public GastoDepreciacionCentroCostoDataAccess() {
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
		GastoDepreciacionCentroCostoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		GastoDepreciacionCentroCostoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		GastoDepreciacionCentroCostoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setGastoDepreciacionCentroCostoOriginal(GastoDepreciacionCentroCosto gastodepreciacioncentrocosto)throws Exception  {
		gastodepreciacioncentrocosto.setGastoDepreciacionCentroCostoOriginal((GastoDepreciacionCentroCosto)gastodepreciacioncentrocosto.clone());		
	}
	
	public void setGastoDepreciacionCentroCostosOriginal(List<GastoDepreciacionCentroCosto> gastodepreciacioncentrocostos)throws Exception  {
		
		for(GastoDepreciacionCentroCosto gastodepreciacioncentrocosto:gastodepreciacioncentrocostos){
			gastodepreciacioncentrocosto.setGastoDepreciacionCentroCostoOriginal((GastoDepreciacionCentroCosto)gastodepreciacioncentrocosto.clone());
		}
	}
	
	public static void setGastoDepreciacionCentroCostoOriginalStatic(GastoDepreciacionCentroCosto gastodepreciacioncentrocosto)throws Exception  {
		gastodepreciacioncentrocosto.setGastoDepreciacionCentroCostoOriginal((GastoDepreciacionCentroCosto)gastodepreciacioncentrocosto.clone());		
	}
	
	public static void setGastoDepreciacionCentroCostosOriginalStatic(List<GastoDepreciacionCentroCosto> gastodepreciacioncentrocostos)throws Exception  {
		
		for(GastoDepreciacionCentroCosto gastodepreciacioncentrocosto:gastodepreciacioncentrocostos){
			gastodepreciacioncentrocosto.setGastoDepreciacionCentroCostoOriginal((GastoDepreciacionCentroCosto)gastodepreciacioncentrocosto.clone());
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
	
	public  GastoDepreciacionCentroCosto getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		GastoDepreciacionCentroCosto entity = new GastoDepreciacionCentroCosto();		
		
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
	
	public  GastoDepreciacionCentroCosto getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		GastoDepreciacionCentroCosto entity = new GastoDepreciacionCentroCosto();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=GastoDepreciacionCentroCostoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=GastoDepreciacionCentroCostoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//ActivosFijos.GastoDepreciacionCentroCosto.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setGastoDepreciacionCentroCostoOriginal(new GastoDepreciacionCentroCosto());
      	    	entity=super.getEntity("",entity,resultSet,GastoDepreciacionCentroCostoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityGastoDepreciacionCentroCosto("",entity,resultSet); 
				
				//entity.setGastoDepreciacionCentroCostoOriginal(super.getEntity("",entity.getGastoDepreciacionCentroCostoOriginal(),resultSet,GastoDepreciacionCentroCostoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setGastoDepreciacionCentroCostoOriginal(this.getEntityGastoDepreciacionCentroCosto("",entity.getGastoDepreciacionCentroCostoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseGastoDepreciacionCentroCosto(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  GastoDepreciacionCentroCosto getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		GastoDepreciacionCentroCosto entity = new GastoDepreciacionCentroCosto();
				
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
	
	public  GastoDepreciacionCentroCosto getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		GastoDepreciacionCentroCosto entity = new GastoDepreciacionCentroCosto();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=GastoDepreciacionCentroCostoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=GastoDepreciacionCentroCostoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,GastoDepreciacionCentroCostoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//ActivosFijos.GastoDepreciacionCentroCosto.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setGastoDepreciacionCentroCostoOriginal(new GastoDepreciacionCentroCosto());
      	    	entity=super.getEntity("",entity,resultSet,GastoDepreciacionCentroCostoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityGastoDepreciacionCentroCosto("",entity,resultSet);    
				
				//entity.setGastoDepreciacionCentroCostoOriginal(super.getEntity("",entity.getGastoDepreciacionCentroCostoOriginal(),resultSet,GastoDepreciacionCentroCostoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setGastoDepreciacionCentroCostoOriginal(this.getEntityGastoDepreciacionCentroCosto("",entity.getGastoDepreciacionCentroCostoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseGastoDepreciacionCentroCosto(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //GastoDepreciacionCentroCosto
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		GastoDepreciacionCentroCosto entity = new GastoDepreciacionCentroCosto();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=GastoDepreciacionCentroCostoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=GastoDepreciacionCentroCostoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,GastoDepreciacionCentroCostoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//ActivosFijos.GastoDepreciacionCentroCosto.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseGastoDepreciacionCentroCosto(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<GastoDepreciacionCentroCosto> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<GastoDepreciacionCentroCosto> entities = new  ArrayList<GastoDepreciacionCentroCosto>();
		GastoDepreciacionCentroCosto entity = new GastoDepreciacionCentroCosto();		  
		
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
	
	public  List<GastoDepreciacionCentroCosto> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<GastoDepreciacionCentroCosto> entities = new  ArrayList<GastoDepreciacionCentroCosto>();
		GastoDepreciacionCentroCosto entity = new GastoDepreciacionCentroCosto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=GastoDepreciacionCentroCostoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=GastoDepreciacionCentroCostoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,GastoDepreciacionCentroCostoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new GastoDepreciacionCentroCosto();
      	    	entity=super.getEntity("",entity,resultSet,GastoDepreciacionCentroCostoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityGastoDepreciacionCentroCosto("",entity,resultSet);
      	    	
				//entity.setGastoDepreciacionCentroCostoOriginal( new GastoDepreciacionCentroCosto());
      	    	//entity.setGastoDepreciacionCentroCostoOriginal(super.getEntity("",entity.getGastoDepreciacionCentroCostoOriginal(),resultSet,GastoDepreciacionCentroCostoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setGastoDepreciacionCentroCostoOriginal(this.getEntityGastoDepreciacionCentroCosto("",entity.getGastoDepreciacionCentroCostoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseGastoDepreciacionCentroCostos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarGastoDepreciacionCentroCosto(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<GastoDepreciacionCentroCosto> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<GastoDepreciacionCentroCosto> entities = new  ArrayList<GastoDepreciacionCentroCosto>();
		GastoDepreciacionCentroCosto entity = new GastoDepreciacionCentroCosto();		  
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
	
	public  List<GastoDepreciacionCentroCosto> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<GastoDepreciacionCentroCosto> entities = new  ArrayList<GastoDepreciacionCentroCosto>();
		GastoDepreciacionCentroCosto entity = new GastoDepreciacionCentroCosto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new GastoDepreciacionCentroCosto();
				
				if(conMapGenerico) {
					entity.inicializarMapGastoDepreciacionCentroCosto();
					//entity.setMapGastoDepreciacionCentroCosto(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapGastoDepreciacionCentroCostoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapGastoDepreciacionCentroCosto().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,GastoDepreciacionCentroCostoDataAccess.ISWITHSCHEMA);         		
					entity=GastoDepreciacionCentroCostoDataAccess.getEntityGastoDepreciacionCentroCosto("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setGastoDepreciacionCentroCostoOriginal( new GastoDepreciacionCentroCosto());
					////entity.setGastoDepreciacionCentroCostoOriginal(super.getEntity("",entity.getGastoDepreciacionCentroCostoOriginal(),resultSet,GastoDepreciacionCentroCostoDataAccess.ISWITHSCHEMA));         		
					////entity.setGastoDepreciacionCentroCostoOriginal(this.getEntityGastoDepreciacionCentroCosto("",entity.getGastoDepreciacionCentroCostoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseGastoDepreciacionCentroCostos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarGastoDepreciacionCentroCosto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public GastoDepreciacionCentroCosto getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		GastoDepreciacionCentroCosto entity = new GastoDepreciacionCentroCosto();		  
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
	
	public  GastoDepreciacionCentroCosto getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		GastoDepreciacionCentroCosto entity = new GastoDepreciacionCentroCosto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new GastoDepreciacionCentroCosto();
				
				if(conMapGenerico) {
					entity.inicializarMapGastoDepreciacionCentroCosto();
					//entity.setMapGastoDepreciacionCentroCosto(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapGastoDepreciacionCentroCostoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapGastoDepreciacionCentroCosto().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,GastoDepreciacionCentroCostoDataAccess.ISWITHSCHEMA);         		
					entity=GastoDepreciacionCentroCostoDataAccess.getEntityGastoDepreciacionCentroCosto("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setGastoDepreciacionCentroCostoOriginal( new GastoDepreciacionCentroCosto());
					////entity.setGastoDepreciacionCentroCostoOriginal(super.getEntity("",entity.getGastoDepreciacionCentroCostoOriginal(),resultSet,GastoDepreciacionCentroCostoDataAccess.ISWITHSCHEMA));         		
					////entity.setGastoDepreciacionCentroCostoOriginal(this.getEntityGastoDepreciacionCentroCosto("",entity.getGastoDepreciacionCentroCostoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseGastoDepreciacionCentroCosto(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarGastoDepreciacionCentroCosto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static GastoDepreciacionCentroCosto getEntityGastoDepreciacionCentroCosto(String strPrefijo,GastoDepreciacionCentroCosto entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = GastoDepreciacionCentroCosto.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = GastoDepreciacionCentroCosto.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					GastoDepreciacionCentroCostoDataAccess.setFieldReflectionGastoDepreciacionCentroCosto(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasGastoDepreciacionCentroCosto=GastoDepreciacionCentroCostoConstantesFunciones.getTodosTiposColumnasGastoDepreciacionCentroCosto();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasGastoDepreciacionCentroCosto) {
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
							field = GastoDepreciacionCentroCosto.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = GastoDepreciacionCentroCosto.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						GastoDepreciacionCentroCostoDataAccess.setFieldReflectionGastoDepreciacionCentroCosto(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionGastoDepreciacionCentroCosto(Field field,String strPrefijo,String sColumn,GastoDepreciacionCentroCosto entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case GastoDepreciacionCentroCostoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case GastoDepreciacionCentroCostoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case GastoDepreciacionCentroCostoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case GastoDepreciacionCentroCostoConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case GastoDepreciacionCentroCostoConstantesFunciones.IDCENTROCOSTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case GastoDepreciacionCentroCostoConstantesFunciones.IDDETALLEACTIVOFIJO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case GastoDepreciacionCentroCostoConstantesFunciones.IDCUENTACONTABLE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case GastoDepreciacionCentroCostoConstantesFunciones.PORCENTAJE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<GastoDepreciacionCentroCosto>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<GastoDepreciacionCentroCosto> entities = new  ArrayList<GastoDepreciacionCentroCosto>();
		GastoDepreciacionCentroCosto entity = new GastoDepreciacionCentroCosto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=GastoDepreciacionCentroCostoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=GastoDepreciacionCentroCostoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,GastoDepreciacionCentroCostoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new GastoDepreciacionCentroCosto();
					entity=super.getEntity("",entity,resultSet,GastoDepreciacionCentroCostoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityGastoDepreciacionCentroCosto("",entity,resultSet);
					
					//entity.setGastoDepreciacionCentroCostoOriginal( new GastoDepreciacionCentroCosto());
					//entity.setGastoDepreciacionCentroCostoOriginal(super.getEntity("",entity.getGastoDepreciacionCentroCostoOriginal(),resultSet,GastoDepreciacionCentroCostoDataAccess.ISWITHSCHEMA));         		
					//entity.setGastoDepreciacionCentroCostoOriginal(this.getEntityGastoDepreciacionCentroCosto("",entity.getGastoDepreciacionCentroCostoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseGastoDepreciacionCentroCostos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarGastoDepreciacionCentroCosto(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<GastoDepreciacionCentroCosto>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<GastoDepreciacionCentroCosto> entities = new  ArrayList<GastoDepreciacionCentroCosto>();
		GastoDepreciacionCentroCosto entity = new GastoDepreciacionCentroCosto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=GastoDepreciacionCentroCostoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=GastoDepreciacionCentroCostoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,GastoDepreciacionCentroCostoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<GastoDepreciacionCentroCosto> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<GastoDepreciacionCentroCosto> entities = new  ArrayList<GastoDepreciacionCentroCosto>();
		GastoDepreciacionCentroCosto entity = new GastoDepreciacionCentroCosto();		  
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
	
	public  List<GastoDepreciacionCentroCosto> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<GastoDepreciacionCentroCosto> entities = new  ArrayList<GastoDepreciacionCentroCosto>();
		GastoDepreciacionCentroCosto entity = new GastoDepreciacionCentroCosto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new GastoDepreciacionCentroCosto();
      	    	entity=super.getEntity("",entity,resultSet,GastoDepreciacionCentroCostoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityGastoDepreciacionCentroCosto("",entity,resultSet);
      	    	
				//entity.setGastoDepreciacionCentroCostoOriginal( new GastoDepreciacionCentroCosto());
      	    	//entity.setGastoDepreciacionCentroCostoOriginal(super.getEntity("",entity.getGastoDepreciacionCentroCostoOriginal(),resultSet,GastoDepreciacionCentroCostoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setGastoDepreciacionCentroCostoOriginal(this.getEntityGastoDepreciacionCentroCosto("",entity.getGastoDepreciacionCentroCostoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseGastoDepreciacionCentroCostos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarGastoDepreciacionCentroCosto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<GastoDepreciacionCentroCosto> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<GastoDepreciacionCentroCosto> entities = new  ArrayList<GastoDepreciacionCentroCosto>();
		GastoDepreciacionCentroCosto entity = new GastoDepreciacionCentroCosto();		  
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
	
	public  List<GastoDepreciacionCentroCosto> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<GastoDepreciacionCentroCosto> entities = new  ArrayList<GastoDepreciacionCentroCosto>();
		GastoDepreciacionCentroCosto entity = new GastoDepreciacionCentroCosto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new GastoDepreciacionCentroCosto();
      	    	entity=super.getEntity("",entity,resultSet,GastoDepreciacionCentroCostoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityGastoDepreciacionCentroCosto("",entity,resultSet);
      	    	
				//entity.setGastoDepreciacionCentroCostoOriginal( new GastoDepreciacionCentroCosto());
      	    	//entity.setGastoDepreciacionCentroCostoOriginal(super.getEntity("",entity.getGastoDepreciacionCentroCostoOriginal(),resultSet,GastoDepreciacionCentroCostoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setGastoDepreciacionCentroCostoOriginal(this.getEntityGastoDepreciacionCentroCosto("",entity.getGastoDepreciacionCentroCostoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseGastoDepreciacionCentroCostos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public GastoDepreciacionCentroCosto getEntityGastoDepreciacionCentroCosto(String strPrefijo,GastoDepreciacionCentroCosto entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+GastoDepreciacionCentroCostoConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+GastoDepreciacionCentroCostoConstantesFunciones.IDSUCURSAL));
				entity.setid_centro_costo(resultSet.getLong(strPrefijo+GastoDepreciacionCentroCostoConstantesFunciones.IDCENTROCOSTO));if(resultSet.wasNull()) {entity.setid_centro_costo(null); }
				entity.setid_detalle_activo_fijo(resultSet.getLong(strPrefijo+GastoDepreciacionCentroCostoConstantesFunciones.IDDETALLEACTIVOFIJO));
				entity.setid_cuenta_contable(resultSet.getLong(strPrefijo+GastoDepreciacionCentroCostoConstantesFunciones.IDCUENTACONTABLE));
				entity.setporcentaje(resultSet.getDouble(strPrefijo+GastoDepreciacionCentroCostoConstantesFunciones.PORCENTAJE));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowGastoDepreciacionCentroCosto(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(GastoDepreciacionCentroCosto entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=GastoDepreciacionCentroCostoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=GastoDepreciacionCentroCostoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=GastoDepreciacionCentroCostoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=GastoDepreciacionCentroCostoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(GastoDepreciacionCentroCostoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,GastoDepreciacionCentroCostoDataAccess.TABLENAME,GastoDepreciacionCentroCostoDataAccess.ISWITHSTOREPROCEDURES);
			
			GastoDepreciacionCentroCostoDataAccess.setGastoDepreciacionCentroCostoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,GastoDepreciacionCentroCosto relgastodepreciacioncentrocosto)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relgastodepreciacioncentrocosto.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,GastoDepreciacionCentroCosto relgastodepreciacioncentrocosto)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relgastodepreciacioncentrocosto.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public CentroCosto getCentroCosto(Connexion connexion,GastoDepreciacionCentroCosto relgastodepreciacioncentrocosto)throws SQLException,Exception {

		CentroCosto centrocosto= new CentroCosto();

		try {
			CentroCostoDataAccess centrocostoDataAccess=new CentroCostoDataAccess();

			centrocostoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			centrocostoDataAccess.setConnexionType(this.connexionType);
			centrocostoDataAccess.setParameterDbType(this.parameterDbType);

			centrocosto=centrocostoDataAccess.getEntity(connexion,relgastodepreciacioncentrocosto.getid_centro_costo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return centrocosto;

	}

	public DetalleActivoFijo getDetalleActivoFijo(Connexion connexion,GastoDepreciacionCentroCosto relgastodepreciacioncentrocosto)throws SQLException,Exception {

		DetalleActivoFijo detalleactivofijo= new DetalleActivoFijo();

		try {
			DetalleActivoFijoDataAccess detalleactivofijoDataAccess=new DetalleActivoFijoDataAccess();

			detalleactivofijoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			detalleactivofijoDataAccess.setConnexionType(this.connexionType);
			detalleactivofijoDataAccess.setParameterDbType(this.parameterDbType);

			detalleactivofijo=detalleactivofijoDataAccess.getEntity(connexion,relgastodepreciacioncentrocosto.getid_detalle_activo_fijo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalleactivofijo;

	}

	public CuentaContable getCuentaContable(Connexion connexion,GastoDepreciacionCentroCosto relgastodepreciacioncentrocosto)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relgastodepreciacioncentrocosto.getid_cuenta_contable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,GastoDepreciacionCentroCosto gastodepreciacioncentrocosto) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!gastodepreciacioncentrocosto.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(gastodepreciacioncentrocosto.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(gastodepreciacioncentrocosto.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_centro_costo=new ParameterValue<Long>();
					parameterMaintenanceValueid_centro_costo.setValue(gastodepreciacioncentrocosto.getid_centro_costo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_centro_costo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_detalle_activo_fijo=new ParameterValue<Long>();
					parameterMaintenanceValueid_detalle_activo_fijo.setValue(gastodepreciacioncentrocosto.getid_detalle_activo_fijo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_detalle_activo_fijo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable.setValue(gastodepreciacioncentrocosto.getid_cuenta_contable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcentaje=new ParameterValue<Double>();
					parameterMaintenanceValueporcentaje.setValue(gastodepreciacioncentrocosto.getporcentaje());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcentaje);
					parametersTemp.add(parameterMaintenance);
					
						if(!gastodepreciacioncentrocosto.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(gastodepreciacioncentrocosto.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(gastodepreciacioncentrocosto.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(gastodepreciacioncentrocosto.getId());
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
	
	public void setIsNewIsChangedFalseGastoDepreciacionCentroCosto(GastoDepreciacionCentroCosto gastodepreciacioncentrocosto)throws Exception  {		
		gastodepreciacioncentrocosto.setIsNew(false);
		gastodepreciacioncentrocosto.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseGastoDepreciacionCentroCostos(List<GastoDepreciacionCentroCosto> gastodepreciacioncentrocostos)throws Exception  {				
		for(GastoDepreciacionCentroCosto gastodepreciacioncentrocosto:gastodepreciacioncentrocostos) {
			gastodepreciacioncentrocosto.setIsNew(false);
			gastodepreciacioncentrocosto.setIsChanged(false);
		}
	}
	
	public void generarExportarGastoDepreciacionCentroCosto(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
