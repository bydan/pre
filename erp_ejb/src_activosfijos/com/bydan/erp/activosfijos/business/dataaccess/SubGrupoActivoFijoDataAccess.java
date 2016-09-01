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
import com.bydan.erp.activosfijos.util.*;//SubGrupoActivoFijoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.activosfijos.util.*;




@SuppressWarnings("unused")
final public class SubGrupoActivoFijoDataAccess extends  SubGrupoActivoFijoDataAccessAdditional{ //SubGrupoActivoFijoDataAccessAdditional,DataAccessHelper<SubGrupoActivoFijo>
	//static Logger logger = Logger.getLogger(SubGrupoActivoFijoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="sub_grupo_activo_fijo";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+SubGrupoActivoFijoConstantesFunciones.SCHEMA+"."+SubGrupoActivoFijoConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_detalle_grupo_activo_fijo,codigo,nombre,siglas,es_vehiculo)values(current_timestamp,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+SubGrupoActivoFijoConstantesFunciones.SCHEMA+"."+SubGrupoActivoFijoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_detalle_grupo_activo_fijo=?,codigo=?,nombre=?,siglas=?,es_vehiculo=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+SubGrupoActivoFijoConstantesFunciones.SCHEMA+"."+SubGrupoActivoFijoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select subgrupoactivofijo from "+SubGrupoActivoFijoConstantesFunciones.SPERSISTENCENAME+" subgrupoactivofijo";
	public static String QUERYSELECTNATIVE="select "+SubGrupoActivoFijoConstantesFunciones.SCHEMA+"."+SubGrupoActivoFijoConstantesFunciones.TABLENAME+".id,"+SubGrupoActivoFijoConstantesFunciones.SCHEMA+"."+SubGrupoActivoFijoConstantesFunciones.TABLENAME+".version_row,"+SubGrupoActivoFijoConstantesFunciones.SCHEMA+"."+SubGrupoActivoFijoConstantesFunciones.TABLENAME+".id_empresa,"+SubGrupoActivoFijoConstantesFunciones.SCHEMA+"."+SubGrupoActivoFijoConstantesFunciones.TABLENAME+".id_detalle_grupo_activo_fijo,"+SubGrupoActivoFijoConstantesFunciones.SCHEMA+"."+SubGrupoActivoFijoConstantesFunciones.TABLENAME+".codigo,"+SubGrupoActivoFijoConstantesFunciones.SCHEMA+"."+SubGrupoActivoFijoConstantesFunciones.TABLENAME+".nombre,"+SubGrupoActivoFijoConstantesFunciones.SCHEMA+"."+SubGrupoActivoFijoConstantesFunciones.TABLENAME+".siglas,"+SubGrupoActivoFijoConstantesFunciones.SCHEMA+"."+SubGrupoActivoFijoConstantesFunciones.TABLENAME+".es_vehiculo from "+SubGrupoActivoFijoConstantesFunciones.SCHEMA+"."+SubGrupoActivoFijoConstantesFunciones.TABLENAME;//+" as "+SubGrupoActivoFijoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+SubGrupoActivoFijoConstantesFunciones.SCHEMA+"."+SubGrupoActivoFijoConstantesFunciones.TABLENAME+".id,"+SubGrupoActivoFijoConstantesFunciones.SCHEMA+"."+SubGrupoActivoFijoConstantesFunciones.TABLENAME+".version_row,"+SubGrupoActivoFijoConstantesFunciones.SCHEMA+"."+SubGrupoActivoFijoConstantesFunciones.TABLENAME+".codigo from "+SubGrupoActivoFijoConstantesFunciones.SCHEMA+"."+SubGrupoActivoFijoConstantesFunciones.TABLENAME;//+" as "+SubGrupoActivoFijoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+SubGrupoActivoFijoConstantesFunciones.SCHEMA+"."+SubGrupoActivoFijoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_detalle_grupo_activo_fijo=?,codigo=?,nombre=?,siglas=?,es_vehiculo=?";
	
	public static String STOREPROCEDUREINSERT="call SP_SUBGRUPOACTIVOFIJO_INSERT(?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_SUBGRUPOACTIVOFIJO_UPDATE(?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_SUBGRUPOACTIVOFIJO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_SUBGRUPOACTIVOFIJO_SELECT(?,?)";
	
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
	
	
	protected SubGrupoActivoFijoDataAccessAdditional subgrupoactivofijoDataAccessAdditional=null;
	
	public SubGrupoActivoFijoDataAccessAdditional getSubGrupoActivoFijoDataAccessAdditional() {
		return this.subgrupoactivofijoDataAccessAdditional;
	}
	
	public void setSubGrupoActivoFijoDataAccessAdditional(SubGrupoActivoFijoDataAccessAdditional subgrupoactivofijoDataAccessAdditional) {
		try {
			this.subgrupoactivofijoDataAccessAdditional=subgrupoactivofijoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public SubGrupoActivoFijoDataAccess() {
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
		SubGrupoActivoFijoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		SubGrupoActivoFijoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		SubGrupoActivoFijoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setSubGrupoActivoFijoOriginal(SubGrupoActivoFijo subgrupoactivofijo)throws Exception  {
		subgrupoactivofijo.setSubGrupoActivoFijoOriginal((SubGrupoActivoFijo)subgrupoactivofijo.clone());		
	}
	
	public void setSubGrupoActivoFijosOriginal(List<SubGrupoActivoFijo> subgrupoactivofijos)throws Exception  {
		
		for(SubGrupoActivoFijo subgrupoactivofijo:subgrupoactivofijos){
			subgrupoactivofijo.setSubGrupoActivoFijoOriginal((SubGrupoActivoFijo)subgrupoactivofijo.clone());
		}
	}
	
	public static void setSubGrupoActivoFijoOriginalStatic(SubGrupoActivoFijo subgrupoactivofijo)throws Exception  {
		subgrupoactivofijo.setSubGrupoActivoFijoOriginal((SubGrupoActivoFijo)subgrupoactivofijo.clone());		
	}
	
	public static void setSubGrupoActivoFijosOriginalStatic(List<SubGrupoActivoFijo> subgrupoactivofijos)throws Exception  {
		
		for(SubGrupoActivoFijo subgrupoactivofijo:subgrupoactivofijos){
			subgrupoactivofijo.setSubGrupoActivoFijoOriginal((SubGrupoActivoFijo)subgrupoactivofijo.clone());
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
	
	public  SubGrupoActivoFijo getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		SubGrupoActivoFijo entity = new SubGrupoActivoFijo();		
		
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
	
	public  SubGrupoActivoFijo getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		SubGrupoActivoFijo entity = new SubGrupoActivoFijo();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=SubGrupoActivoFijoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=SubGrupoActivoFijoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//ActivosFijos.SubGrupoActivoFijo.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setSubGrupoActivoFijoOriginal(new SubGrupoActivoFijo());
      	    	entity=super.getEntity("",entity,resultSet,SubGrupoActivoFijoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntitySubGrupoActivoFijo("",entity,resultSet); 
				
				//entity.setSubGrupoActivoFijoOriginal(super.getEntity("",entity.getSubGrupoActivoFijoOriginal(),resultSet,SubGrupoActivoFijoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setSubGrupoActivoFijoOriginal(this.getEntitySubGrupoActivoFijo("",entity.getSubGrupoActivoFijoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseSubGrupoActivoFijo(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  SubGrupoActivoFijo getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		SubGrupoActivoFijo entity = new SubGrupoActivoFijo();
				
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
	
	public  SubGrupoActivoFijo getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		SubGrupoActivoFijo entity = new SubGrupoActivoFijo();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=SubGrupoActivoFijoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=SubGrupoActivoFijoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,SubGrupoActivoFijoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//ActivosFijos.SubGrupoActivoFijo.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setSubGrupoActivoFijoOriginal(new SubGrupoActivoFijo());
      	    	entity=super.getEntity("",entity,resultSet,SubGrupoActivoFijoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntitySubGrupoActivoFijo("",entity,resultSet);    
				
				//entity.setSubGrupoActivoFijoOriginal(super.getEntity("",entity.getSubGrupoActivoFijoOriginal(),resultSet,SubGrupoActivoFijoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setSubGrupoActivoFijoOriginal(this.getEntitySubGrupoActivoFijo("",entity.getSubGrupoActivoFijoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseSubGrupoActivoFijo(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //SubGrupoActivoFijo
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		SubGrupoActivoFijo entity = new SubGrupoActivoFijo();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=SubGrupoActivoFijoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=SubGrupoActivoFijoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,SubGrupoActivoFijoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//ActivosFijos.SubGrupoActivoFijo.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseSubGrupoActivoFijo(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<SubGrupoActivoFijo> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<SubGrupoActivoFijo> entities = new  ArrayList<SubGrupoActivoFijo>();
		SubGrupoActivoFijo entity = new SubGrupoActivoFijo();		  
		
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
	
	public  List<SubGrupoActivoFijo> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<SubGrupoActivoFijo> entities = new  ArrayList<SubGrupoActivoFijo>();
		SubGrupoActivoFijo entity = new SubGrupoActivoFijo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=SubGrupoActivoFijoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=SubGrupoActivoFijoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,SubGrupoActivoFijoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new SubGrupoActivoFijo();
      	    	entity=super.getEntity("",entity,resultSet,SubGrupoActivoFijoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntitySubGrupoActivoFijo("",entity,resultSet);
      	    	
				//entity.setSubGrupoActivoFijoOriginal( new SubGrupoActivoFijo());
      	    	//entity.setSubGrupoActivoFijoOriginal(super.getEntity("",entity.getSubGrupoActivoFijoOriginal(),resultSet,SubGrupoActivoFijoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setSubGrupoActivoFijoOriginal(this.getEntitySubGrupoActivoFijo("",entity.getSubGrupoActivoFijoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseSubGrupoActivoFijos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarSubGrupoActivoFijo(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<SubGrupoActivoFijo> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<SubGrupoActivoFijo> entities = new  ArrayList<SubGrupoActivoFijo>();
		SubGrupoActivoFijo entity = new SubGrupoActivoFijo();		  
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
	
	public  List<SubGrupoActivoFijo> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<SubGrupoActivoFijo> entities = new  ArrayList<SubGrupoActivoFijo>();
		SubGrupoActivoFijo entity = new SubGrupoActivoFijo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new SubGrupoActivoFijo();
				
				if(conMapGenerico) {
					entity.inicializarMapSubGrupoActivoFijo();
					//entity.setMapSubGrupoActivoFijo(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapSubGrupoActivoFijoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapSubGrupoActivoFijo().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,SubGrupoActivoFijoDataAccess.ISWITHSCHEMA);         		
					entity=SubGrupoActivoFijoDataAccess.getEntitySubGrupoActivoFijo("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setSubGrupoActivoFijoOriginal( new SubGrupoActivoFijo());
					////entity.setSubGrupoActivoFijoOriginal(super.getEntity("",entity.getSubGrupoActivoFijoOriginal(),resultSet,SubGrupoActivoFijoDataAccess.ISWITHSCHEMA));         		
					////entity.setSubGrupoActivoFijoOriginal(this.getEntitySubGrupoActivoFijo("",entity.getSubGrupoActivoFijoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseSubGrupoActivoFijos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarSubGrupoActivoFijo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public SubGrupoActivoFijo getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		SubGrupoActivoFijo entity = new SubGrupoActivoFijo();		  
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
	
	public  SubGrupoActivoFijo getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		SubGrupoActivoFijo entity = new SubGrupoActivoFijo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new SubGrupoActivoFijo();
				
				if(conMapGenerico) {
					entity.inicializarMapSubGrupoActivoFijo();
					//entity.setMapSubGrupoActivoFijo(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapSubGrupoActivoFijoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapSubGrupoActivoFijo().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,SubGrupoActivoFijoDataAccess.ISWITHSCHEMA);         		
					entity=SubGrupoActivoFijoDataAccess.getEntitySubGrupoActivoFijo("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setSubGrupoActivoFijoOriginal( new SubGrupoActivoFijo());
					////entity.setSubGrupoActivoFijoOriginal(super.getEntity("",entity.getSubGrupoActivoFijoOriginal(),resultSet,SubGrupoActivoFijoDataAccess.ISWITHSCHEMA));         		
					////entity.setSubGrupoActivoFijoOriginal(this.getEntitySubGrupoActivoFijo("",entity.getSubGrupoActivoFijoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseSubGrupoActivoFijo(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarSubGrupoActivoFijo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static SubGrupoActivoFijo getEntitySubGrupoActivoFijo(String strPrefijo,SubGrupoActivoFijo entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = SubGrupoActivoFijo.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = SubGrupoActivoFijo.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					SubGrupoActivoFijoDataAccess.setFieldReflectionSubGrupoActivoFijo(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasSubGrupoActivoFijo=SubGrupoActivoFijoConstantesFunciones.getTodosTiposColumnasSubGrupoActivoFijo();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasSubGrupoActivoFijo) {
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
							field = SubGrupoActivoFijo.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = SubGrupoActivoFijo.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						SubGrupoActivoFijoDataAccess.setFieldReflectionSubGrupoActivoFijo(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionSubGrupoActivoFijo(Field field,String strPrefijo,String sColumn,SubGrupoActivoFijo entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case SubGrupoActivoFijoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SubGrupoActivoFijoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SubGrupoActivoFijoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SubGrupoActivoFijoConstantesFunciones.IDDETALLEGRUPOACTIVOFIJO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SubGrupoActivoFijoConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SubGrupoActivoFijoConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SubGrupoActivoFijoConstantesFunciones.SIGLAS:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SubGrupoActivoFijoConstantesFunciones.ESVEHICULO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<SubGrupoActivoFijo>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<SubGrupoActivoFijo> entities = new  ArrayList<SubGrupoActivoFijo>();
		SubGrupoActivoFijo entity = new SubGrupoActivoFijo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=SubGrupoActivoFijoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=SubGrupoActivoFijoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,SubGrupoActivoFijoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new SubGrupoActivoFijo();
					entity=super.getEntity("",entity,resultSet,SubGrupoActivoFijoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntitySubGrupoActivoFijo("",entity,resultSet);
					
					//entity.setSubGrupoActivoFijoOriginal( new SubGrupoActivoFijo());
					//entity.setSubGrupoActivoFijoOriginal(super.getEntity("",entity.getSubGrupoActivoFijoOriginal(),resultSet,SubGrupoActivoFijoDataAccess.ISWITHSCHEMA));         		
					//entity.setSubGrupoActivoFijoOriginal(this.getEntitySubGrupoActivoFijo("",entity.getSubGrupoActivoFijoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseSubGrupoActivoFijos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarSubGrupoActivoFijo(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<SubGrupoActivoFijo>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<SubGrupoActivoFijo> entities = new  ArrayList<SubGrupoActivoFijo>();
		SubGrupoActivoFijo entity = new SubGrupoActivoFijo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=SubGrupoActivoFijoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=SubGrupoActivoFijoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,SubGrupoActivoFijoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<SubGrupoActivoFijo> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<SubGrupoActivoFijo> entities = new  ArrayList<SubGrupoActivoFijo>();
		SubGrupoActivoFijo entity = new SubGrupoActivoFijo();		  
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
	
	public  List<SubGrupoActivoFijo> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<SubGrupoActivoFijo> entities = new  ArrayList<SubGrupoActivoFijo>();
		SubGrupoActivoFijo entity = new SubGrupoActivoFijo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new SubGrupoActivoFijo();
      	    	entity=super.getEntity("",entity,resultSet,SubGrupoActivoFijoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntitySubGrupoActivoFijo("",entity,resultSet);
      	    	
				//entity.setSubGrupoActivoFijoOriginal( new SubGrupoActivoFijo());
      	    	//entity.setSubGrupoActivoFijoOriginal(super.getEntity("",entity.getSubGrupoActivoFijoOriginal(),resultSet,SubGrupoActivoFijoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setSubGrupoActivoFijoOriginal(this.getEntitySubGrupoActivoFijo("",entity.getSubGrupoActivoFijoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseSubGrupoActivoFijos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarSubGrupoActivoFijo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<SubGrupoActivoFijo> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<SubGrupoActivoFijo> entities = new  ArrayList<SubGrupoActivoFijo>();
		SubGrupoActivoFijo entity = new SubGrupoActivoFijo();		  
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
	
	public  List<SubGrupoActivoFijo> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<SubGrupoActivoFijo> entities = new  ArrayList<SubGrupoActivoFijo>();
		SubGrupoActivoFijo entity = new SubGrupoActivoFijo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new SubGrupoActivoFijo();
      	    	entity=super.getEntity("",entity,resultSet,SubGrupoActivoFijoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntitySubGrupoActivoFijo("",entity,resultSet);
      	    	
				//entity.setSubGrupoActivoFijoOriginal( new SubGrupoActivoFijo());
      	    	//entity.setSubGrupoActivoFijoOriginal(super.getEntity("",entity.getSubGrupoActivoFijoOriginal(),resultSet,SubGrupoActivoFijoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setSubGrupoActivoFijoOriginal(this.getEntitySubGrupoActivoFijo("",entity.getSubGrupoActivoFijoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseSubGrupoActivoFijos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public SubGrupoActivoFijo getEntitySubGrupoActivoFijo(String strPrefijo,SubGrupoActivoFijo entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+SubGrupoActivoFijoConstantesFunciones.IDEMPRESA));
				entity.setid_detalle_grupo_activo_fijo(resultSet.getLong(strPrefijo+SubGrupoActivoFijoConstantesFunciones.IDDETALLEGRUPOACTIVOFIJO));
				entity.setcodigo(resultSet.getString(strPrefijo+SubGrupoActivoFijoConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+SubGrupoActivoFijoConstantesFunciones.NOMBRE));
				entity.setsiglas(resultSet.getString(strPrefijo+SubGrupoActivoFijoConstantesFunciones.SIGLAS));
				entity.setes_vehiculo(resultSet.getBoolean(strPrefijo+SubGrupoActivoFijoConstantesFunciones.ESVEHICULO));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+SubGrupoActivoFijoConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowSubGrupoActivoFijo(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(SubGrupoActivoFijo entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=SubGrupoActivoFijoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=SubGrupoActivoFijoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=SubGrupoActivoFijoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=SubGrupoActivoFijoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(SubGrupoActivoFijoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,SubGrupoActivoFijoDataAccess.TABLENAME,SubGrupoActivoFijoDataAccess.ISWITHSTOREPROCEDURES);
			
			SubGrupoActivoFijoDataAccess.setSubGrupoActivoFijoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,SubGrupoActivoFijo relsubgrupoactivofijo)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relsubgrupoactivofijo.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public DetalleGrupoActivoFijo getDetalleGrupoActivoFijo(Connexion connexion,SubGrupoActivoFijo relsubgrupoactivofijo)throws SQLException,Exception {

		DetalleGrupoActivoFijo detallegrupoactivofijo= new DetalleGrupoActivoFijo();

		try {
			DetalleGrupoActivoFijoDataAccess detallegrupoactivofijoDataAccess=new DetalleGrupoActivoFijoDataAccess();

			detallegrupoactivofijoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			detallegrupoactivofijoDataAccess.setConnexionType(this.connexionType);
			detallegrupoactivofijoDataAccess.setParameterDbType(this.parameterDbType);

			detallegrupoactivofijo=detallegrupoactivofijoDataAccess.getEntity(connexion,relsubgrupoactivofijo.getid_detalle_grupo_activo_fijo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detallegrupoactivofijo;

	}


		
		public List<DetalleActivoFijo> getDetalleActivoFijos(Connexion connexion,SubGrupoActivoFijo subgrupoactivofijo)throws SQLException,Exception {

		List<DetalleActivoFijo> detalleactivofijos= new ArrayList<DetalleActivoFijo>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+SubGrupoActivoFijoConstantesFunciones.SCHEMA+".sub_grupo_activo_fijo ON "+DetalleActivoFijoConstantesFunciones.SCHEMA+".detalle_activo_fijo.id_sub_grupo_activo_fijo="+SubGrupoActivoFijoConstantesFunciones.SCHEMA+".sub_grupo_activo_fijo.id WHERE "+SubGrupoActivoFijoConstantesFunciones.SCHEMA+".sub_grupo_activo_fijo.id="+String.valueOf(subgrupoactivofijo.getId());
			} else {
				sQuery=" INNER JOIN detalleactivofijo.SubGrupoActivoFijo WHERE detalleactivofijo.SubGrupoActivoFijo.id="+String.valueOf(subgrupoactivofijo.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleActivoFijoDataAccess detalleactivofijoDataAccess=new DetalleActivoFijoDataAccess();

			detalleactivofijoDataAccess.setConnexionType(this.connexionType);
			detalleactivofijoDataAccess.setParameterDbType(this.parameterDbType);
			detalleactivofijos=detalleactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalleactivofijos;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,SubGrupoActivoFijo subgrupoactivofijo) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!subgrupoactivofijo.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(subgrupoactivofijo.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_detalle_grupo_activo_fijo=new ParameterValue<Long>();
					parameterMaintenanceValueid_detalle_grupo_activo_fijo.setValue(subgrupoactivofijo.getid_detalle_grupo_activo_fijo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_detalle_grupo_activo_fijo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(subgrupoactivofijo.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(subgrupoactivofijo.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuesiglas=new ParameterValue<String>();
					parameterMaintenanceValuesiglas.setValue(subgrupoactivofijo.getsiglas());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesiglas);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_vehiculo=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_vehiculo.setValue(subgrupoactivofijo.getes_vehiculo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_vehiculo);
					parametersTemp.add(parameterMaintenance);
					
						if(!subgrupoactivofijo.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(subgrupoactivofijo.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(subgrupoactivofijo.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(subgrupoactivofijo.getId());
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
	
	public void setIsNewIsChangedFalseSubGrupoActivoFijo(SubGrupoActivoFijo subgrupoactivofijo)throws Exception  {		
		subgrupoactivofijo.setIsNew(false);
		subgrupoactivofijo.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseSubGrupoActivoFijos(List<SubGrupoActivoFijo> subgrupoactivofijos)throws Exception  {				
		for(SubGrupoActivoFijo subgrupoactivofijo:subgrupoactivofijos) {
			subgrupoactivofijo.setIsNew(false);
			subgrupoactivofijo.setIsChanged(false);
		}
	}
	
	public void generarExportarSubGrupoActivoFijo(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
