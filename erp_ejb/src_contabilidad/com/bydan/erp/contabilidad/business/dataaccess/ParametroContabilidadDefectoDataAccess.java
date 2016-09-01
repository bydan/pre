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
import com.bydan.erp.contabilidad.util.*;//ParametroContabilidadDefectoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class ParametroContabilidadDefectoDataAccess extends  ParametroContabilidadDefectoDataAccessAdditional{ //ParametroContabilidadDefectoDataAccessAdditional,DataAccessHelper<ParametroContabilidadDefecto>
	//static Logger logger = Logger.getLogger(ParametroContabilidadDefectoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="parametro_contabilidad_defecto";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ParametroContabilidadDefectoConstantesFunciones.SCHEMA+"."+ParametroContabilidadDefectoConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_tipo_moneda,id_moneda,id_modulo,id_tipo_intervalo,id_tipo_movimiento,id_tipo_documento,id_estado_asiento_contable)values(current_timestamp,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+ParametroContabilidadDefectoConstantesFunciones.SCHEMA+"."+ParametroContabilidadDefectoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_tipo_moneda=?,id_moneda=?,id_modulo=?,id_tipo_intervalo=?,id_tipo_movimiento=?,id_tipo_documento=?,id_estado_asiento_contable=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ParametroContabilidadDefectoConstantesFunciones.SCHEMA+"."+ParametroContabilidadDefectoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select parametrocontabilidaddefecto from "+ParametroContabilidadDefectoConstantesFunciones.SPERSISTENCENAME+" parametrocontabilidaddefecto";
	public static String QUERYSELECTNATIVE="select "+ParametroContabilidadDefectoConstantesFunciones.SCHEMA+"."+ParametroContabilidadDefectoConstantesFunciones.TABLENAME+".id,"+ParametroContabilidadDefectoConstantesFunciones.SCHEMA+"."+ParametroContabilidadDefectoConstantesFunciones.TABLENAME+".version_row,"+ParametroContabilidadDefectoConstantesFunciones.SCHEMA+"."+ParametroContabilidadDefectoConstantesFunciones.TABLENAME+".id_empresa,"+ParametroContabilidadDefectoConstantesFunciones.SCHEMA+"."+ParametroContabilidadDefectoConstantesFunciones.TABLENAME+".id_sucursal,"+ParametroContabilidadDefectoConstantesFunciones.SCHEMA+"."+ParametroContabilidadDefectoConstantesFunciones.TABLENAME+".id_tipo_moneda,"+ParametroContabilidadDefectoConstantesFunciones.SCHEMA+"."+ParametroContabilidadDefectoConstantesFunciones.TABLENAME+".id_moneda,"+ParametroContabilidadDefectoConstantesFunciones.SCHEMA+"."+ParametroContabilidadDefectoConstantesFunciones.TABLENAME+".id_modulo,"+ParametroContabilidadDefectoConstantesFunciones.SCHEMA+"."+ParametroContabilidadDefectoConstantesFunciones.TABLENAME+".id_tipo_intervalo,"+ParametroContabilidadDefectoConstantesFunciones.SCHEMA+"."+ParametroContabilidadDefectoConstantesFunciones.TABLENAME+".id_tipo_movimiento,"+ParametroContabilidadDefectoConstantesFunciones.SCHEMA+"."+ParametroContabilidadDefectoConstantesFunciones.TABLENAME+".id_tipo_documento,"+ParametroContabilidadDefectoConstantesFunciones.SCHEMA+"."+ParametroContabilidadDefectoConstantesFunciones.TABLENAME+".id_estado_asiento_contable from "+ParametroContabilidadDefectoConstantesFunciones.SCHEMA+"."+ParametroContabilidadDefectoConstantesFunciones.TABLENAME;//+" as "+ParametroContabilidadDefectoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ParametroContabilidadDefectoConstantesFunciones.SCHEMA+"."+ParametroContabilidadDefectoConstantesFunciones.TABLENAME+".id,"+ParametroContabilidadDefectoConstantesFunciones.SCHEMA+"."+ParametroContabilidadDefectoConstantesFunciones.TABLENAME+".version_row from "+ParametroContabilidadDefectoConstantesFunciones.SCHEMA+"."+ParametroContabilidadDefectoConstantesFunciones.TABLENAME;//+" as "+ParametroContabilidadDefectoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ParametroContabilidadDefectoConstantesFunciones.SCHEMA+"."+ParametroContabilidadDefectoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_tipo_moneda=?,id_moneda=?,id_modulo=?,id_tipo_intervalo=?,id_tipo_movimiento=?,id_tipo_documento=?,id_estado_asiento_contable=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PARAMETROCONTABILIDADDEFECTO_INSERT(?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PARAMETROCONTABILIDADDEFECTO_UPDATE(?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PARAMETROCONTABILIDADDEFECTO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PARAMETROCONTABILIDADDEFECTO_SELECT(?,?)";
	
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
	
	
	protected ParametroContabilidadDefectoDataAccessAdditional parametrocontabilidaddefectoDataAccessAdditional=null;
	
	public ParametroContabilidadDefectoDataAccessAdditional getParametroContabilidadDefectoDataAccessAdditional() {
		return this.parametrocontabilidaddefectoDataAccessAdditional;
	}
	
	public void setParametroContabilidadDefectoDataAccessAdditional(ParametroContabilidadDefectoDataAccessAdditional parametrocontabilidaddefectoDataAccessAdditional) {
		try {
			this.parametrocontabilidaddefectoDataAccessAdditional=parametrocontabilidaddefectoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ParametroContabilidadDefectoDataAccess() {
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
		ParametroContabilidadDefectoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ParametroContabilidadDefectoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ParametroContabilidadDefectoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setParametroContabilidadDefectoOriginal(ParametroContabilidadDefecto parametrocontabilidaddefecto)throws Exception  {
		parametrocontabilidaddefecto.setParametroContabilidadDefectoOriginal((ParametroContabilidadDefecto)parametrocontabilidaddefecto.clone());		
	}
	
	public void setParametroContabilidadDefectosOriginal(List<ParametroContabilidadDefecto> parametrocontabilidaddefectos)throws Exception  {
		
		for(ParametroContabilidadDefecto parametrocontabilidaddefecto:parametrocontabilidaddefectos){
			parametrocontabilidaddefecto.setParametroContabilidadDefectoOriginal((ParametroContabilidadDefecto)parametrocontabilidaddefecto.clone());
		}
	}
	
	public static void setParametroContabilidadDefectoOriginalStatic(ParametroContabilidadDefecto parametrocontabilidaddefecto)throws Exception  {
		parametrocontabilidaddefecto.setParametroContabilidadDefectoOriginal((ParametroContabilidadDefecto)parametrocontabilidaddefecto.clone());		
	}
	
	public static void setParametroContabilidadDefectosOriginalStatic(List<ParametroContabilidadDefecto> parametrocontabilidaddefectos)throws Exception  {
		
		for(ParametroContabilidadDefecto parametrocontabilidaddefecto:parametrocontabilidaddefectos){
			parametrocontabilidaddefecto.setParametroContabilidadDefectoOriginal((ParametroContabilidadDefecto)parametrocontabilidaddefecto.clone());
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
	
	public  ParametroContabilidadDefecto getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		ParametroContabilidadDefecto entity = new ParametroContabilidadDefecto();		
		
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
	
	public  ParametroContabilidadDefecto getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		ParametroContabilidadDefecto entity = new ParametroContabilidadDefecto();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroContabilidadDefectoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroContabilidadDefectoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Contabilidad.ParametroContabilidadDefecto.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setParametroContabilidadDefectoOriginal(new ParametroContabilidadDefecto());
      	    	entity=super.getEntity("",entity,resultSet,ParametroContabilidadDefectoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityParametroContabilidadDefecto("",entity,resultSet); 
				
				//entity.setParametroContabilidadDefectoOriginal(super.getEntity("",entity.getParametroContabilidadDefectoOriginal(),resultSet,ParametroContabilidadDefectoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroContabilidadDefectoOriginal(this.getEntityParametroContabilidadDefecto("",entity.getParametroContabilidadDefectoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseParametroContabilidadDefecto(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  ParametroContabilidadDefecto getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ParametroContabilidadDefecto entity = new ParametroContabilidadDefecto();
				
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
	
	public  ParametroContabilidadDefecto getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ParametroContabilidadDefecto entity = new ParametroContabilidadDefecto();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroContabilidadDefectoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroContabilidadDefectoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroContabilidadDefectoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.ParametroContabilidadDefecto.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setParametroContabilidadDefectoOriginal(new ParametroContabilidadDefecto());
      	    	entity=super.getEntity("",entity,resultSet,ParametroContabilidadDefectoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityParametroContabilidadDefecto("",entity,resultSet);    
				
				//entity.setParametroContabilidadDefectoOriginal(super.getEntity("",entity.getParametroContabilidadDefectoOriginal(),resultSet,ParametroContabilidadDefectoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroContabilidadDefectoOriginal(this.getEntityParametroContabilidadDefecto("",entity.getParametroContabilidadDefectoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseParametroContabilidadDefecto(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //ParametroContabilidadDefecto
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		ParametroContabilidadDefecto entity = new ParametroContabilidadDefecto();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroContabilidadDefectoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroContabilidadDefectoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroContabilidadDefectoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.ParametroContabilidadDefecto.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseParametroContabilidadDefecto(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<ParametroContabilidadDefecto> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ParametroContabilidadDefecto> entities = new  ArrayList<ParametroContabilidadDefecto>();
		ParametroContabilidadDefecto entity = new ParametroContabilidadDefecto();		  
		
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
	
	public  List<ParametroContabilidadDefecto> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ParametroContabilidadDefecto> entities = new  ArrayList<ParametroContabilidadDefecto>();
		ParametroContabilidadDefecto entity = new ParametroContabilidadDefecto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroContabilidadDefectoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroContabilidadDefectoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroContabilidadDefectoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroContabilidadDefecto();
      	    	entity=super.getEntity("",entity,resultSet,ParametroContabilidadDefectoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroContabilidadDefecto("",entity,resultSet);
      	    	
				//entity.setParametroContabilidadDefectoOriginal( new ParametroContabilidadDefecto());
      	    	//entity.setParametroContabilidadDefectoOriginal(super.getEntity("",entity.getParametroContabilidadDefectoOriginal(),resultSet,ParametroContabilidadDefectoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroContabilidadDefectoOriginal(this.getEntityParametroContabilidadDefecto("",entity.getParametroContabilidadDefectoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroContabilidadDefectos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroContabilidadDefecto(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ParametroContabilidadDefecto> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ParametroContabilidadDefecto> entities = new  ArrayList<ParametroContabilidadDefecto>();
		ParametroContabilidadDefecto entity = new ParametroContabilidadDefecto();		  
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
	
	public  List<ParametroContabilidadDefecto> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ParametroContabilidadDefecto> entities = new  ArrayList<ParametroContabilidadDefecto>();
		ParametroContabilidadDefecto entity = new ParametroContabilidadDefecto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroContabilidadDefecto();
				
				if(conMapGenerico) {
					entity.inicializarMapParametroContabilidadDefecto();
					//entity.setMapParametroContabilidadDefecto(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapParametroContabilidadDefectoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapParametroContabilidadDefecto().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ParametroContabilidadDefectoDataAccess.ISWITHSCHEMA);         		
					entity=ParametroContabilidadDefectoDataAccess.getEntityParametroContabilidadDefecto("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setParametroContabilidadDefectoOriginal( new ParametroContabilidadDefecto());
					////entity.setParametroContabilidadDefectoOriginal(super.getEntity("",entity.getParametroContabilidadDefectoOriginal(),resultSet,ParametroContabilidadDefectoDataAccess.ISWITHSCHEMA));         		
					////entity.setParametroContabilidadDefectoOriginal(this.getEntityParametroContabilidadDefecto("",entity.getParametroContabilidadDefectoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroContabilidadDefectos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroContabilidadDefecto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public ParametroContabilidadDefecto getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ParametroContabilidadDefecto entity = new ParametroContabilidadDefecto();		  
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
	
	public  ParametroContabilidadDefecto getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ParametroContabilidadDefecto entity = new ParametroContabilidadDefecto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroContabilidadDefecto();
				
				if(conMapGenerico) {
					entity.inicializarMapParametroContabilidadDefecto();
					//entity.setMapParametroContabilidadDefecto(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapParametroContabilidadDefectoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapParametroContabilidadDefecto().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ParametroContabilidadDefectoDataAccess.ISWITHSCHEMA);         		
					entity=ParametroContabilidadDefectoDataAccess.getEntityParametroContabilidadDefecto("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setParametroContabilidadDefectoOriginal( new ParametroContabilidadDefecto());
					////entity.setParametroContabilidadDefectoOriginal(super.getEntity("",entity.getParametroContabilidadDefectoOriginal(),resultSet,ParametroContabilidadDefectoDataAccess.ISWITHSCHEMA));         		
					////entity.setParametroContabilidadDefectoOriginal(this.getEntityParametroContabilidadDefecto("",entity.getParametroContabilidadDefectoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseParametroContabilidadDefecto(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroContabilidadDefecto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ParametroContabilidadDefecto getEntityParametroContabilidadDefecto(String strPrefijo,ParametroContabilidadDefecto entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = ParametroContabilidadDefecto.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = ParametroContabilidadDefecto.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ParametroContabilidadDefectoDataAccess.setFieldReflectionParametroContabilidadDefecto(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasParametroContabilidadDefecto=ParametroContabilidadDefectoConstantesFunciones.getTodosTiposColumnasParametroContabilidadDefecto();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasParametroContabilidadDefecto) {
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
							field = ParametroContabilidadDefecto.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = ParametroContabilidadDefecto.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ParametroContabilidadDefectoDataAccess.setFieldReflectionParametroContabilidadDefecto(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionParametroContabilidadDefecto(Field field,String strPrefijo,String sColumn,ParametroContabilidadDefecto entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ParametroContabilidadDefectoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroContabilidadDefectoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ParametroContabilidadDefectoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroContabilidadDefectoConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroContabilidadDefectoConstantesFunciones.IDTIPOMONEDA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroContabilidadDefectoConstantesFunciones.IDMONEDA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroContabilidadDefectoConstantesFunciones.IDMODULO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroContabilidadDefectoConstantesFunciones.IDTIPOINTERVALO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroContabilidadDefectoConstantesFunciones.IDTIPOMOVIMIENTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroContabilidadDefectoConstantesFunciones.IDTIPODOCUMENTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroContabilidadDefectoConstantesFunciones.IDESTADOASIENTOCONTABLE:
					field.set(entity,resultSet.getLong(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ParametroContabilidadDefecto>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<ParametroContabilidadDefecto> entities = new  ArrayList<ParametroContabilidadDefecto>();
		ParametroContabilidadDefecto entity = new ParametroContabilidadDefecto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroContabilidadDefectoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroContabilidadDefectoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroContabilidadDefectoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new ParametroContabilidadDefecto();
					entity=super.getEntity("",entity,resultSet,ParametroContabilidadDefectoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityParametroContabilidadDefecto("",entity,resultSet);
					
					//entity.setParametroContabilidadDefectoOriginal( new ParametroContabilidadDefecto());
					//entity.setParametroContabilidadDefectoOriginal(super.getEntity("",entity.getParametroContabilidadDefectoOriginal(),resultSet,ParametroContabilidadDefectoDataAccess.ISWITHSCHEMA));         		
					//entity.setParametroContabilidadDefectoOriginal(this.getEntityParametroContabilidadDefecto("",entity.getParametroContabilidadDefectoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseParametroContabilidadDefectos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroContabilidadDefecto(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ParametroContabilidadDefecto>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<ParametroContabilidadDefecto> entities = new  ArrayList<ParametroContabilidadDefecto>();
		ParametroContabilidadDefecto entity = new ParametroContabilidadDefecto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroContabilidadDefectoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroContabilidadDefectoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroContabilidadDefectoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<ParametroContabilidadDefecto> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroContabilidadDefecto> entities = new  ArrayList<ParametroContabilidadDefecto>();
		ParametroContabilidadDefecto entity = new ParametroContabilidadDefecto();		  
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
	
	public  List<ParametroContabilidadDefecto> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroContabilidadDefecto> entities = new  ArrayList<ParametroContabilidadDefecto>();
		ParametroContabilidadDefecto entity = new ParametroContabilidadDefecto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroContabilidadDefecto();
      	    	entity=super.getEntity("",entity,resultSet,ParametroContabilidadDefectoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroContabilidadDefecto("",entity,resultSet);
      	    	
				//entity.setParametroContabilidadDefectoOriginal( new ParametroContabilidadDefecto());
      	    	//entity.setParametroContabilidadDefectoOriginal(super.getEntity("",entity.getParametroContabilidadDefectoOriginal(),resultSet,ParametroContabilidadDefectoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroContabilidadDefectoOriginal(this.getEntityParametroContabilidadDefecto("",entity.getParametroContabilidadDefectoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseParametroContabilidadDefectos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroContabilidadDefecto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ParametroContabilidadDefecto> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroContabilidadDefecto> entities = new  ArrayList<ParametroContabilidadDefecto>();
		ParametroContabilidadDefecto entity = new ParametroContabilidadDefecto();		  
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
	
	public  List<ParametroContabilidadDefecto> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroContabilidadDefecto> entities = new  ArrayList<ParametroContabilidadDefecto>();
		ParametroContabilidadDefecto entity = new ParametroContabilidadDefecto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroContabilidadDefecto();
      	    	entity=super.getEntity("",entity,resultSet,ParametroContabilidadDefectoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroContabilidadDefecto("",entity,resultSet);
      	    	
				//entity.setParametroContabilidadDefectoOriginal( new ParametroContabilidadDefecto());
      	    	//entity.setParametroContabilidadDefectoOriginal(super.getEntity("",entity.getParametroContabilidadDefectoOriginal(),resultSet,ParametroContabilidadDefectoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroContabilidadDefectoOriginal(this.getEntityParametroContabilidadDefecto("",entity.getParametroContabilidadDefectoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroContabilidadDefectos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public ParametroContabilidadDefecto getEntityParametroContabilidadDefecto(String strPrefijo,ParametroContabilidadDefecto entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+ParametroContabilidadDefectoConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+ParametroContabilidadDefectoConstantesFunciones.IDSUCURSAL));
				entity.setid_tipo_moneda(resultSet.getLong(strPrefijo+ParametroContabilidadDefectoConstantesFunciones.IDTIPOMONEDA));
				entity.setid_moneda(resultSet.getLong(strPrefijo+ParametroContabilidadDefectoConstantesFunciones.IDMONEDA));
				entity.setid_modulo(resultSet.getLong(strPrefijo+ParametroContabilidadDefectoConstantesFunciones.IDMODULO));
				entity.setid_tipo_intervalo(resultSet.getLong(strPrefijo+ParametroContabilidadDefectoConstantesFunciones.IDTIPOINTERVALO));
				entity.setid_tipo_movimiento(resultSet.getLong(strPrefijo+ParametroContabilidadDefectoConstantesFunciones.IDTIPOMOVIMIENTO));
				entity.setid_tipo_documento(resultSet.getLong(strPrefijo+ParametroContabilidadDefectoConstantesFunciones.IDTIPODOCUMENTO));
				entity.setid_estado_asiento_contable(resultSet.getLong(strPrefijo+ParametroContabilidadDefectoConstantesFunciones.IDESTADOASIENTOCONTABLE));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowParametroContabilidadDefecto(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(ParametroContabilidadDefecto entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ParametroContabilidadDefectoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ParametroContabilidadDefectoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ParametroContabilidadDefectoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ParametroContabilidadDefectoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ParametroContabilidadDefectoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ParametroContabilidadDefectoDataAccess.TABLENAME,ParametroContabilidadDefectoDataAccess.ISWITHSTOREPROCEDURES);
			
			ParametroContabilidadDefectoDataAccess.setParametroContabilidadDefectoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,ParametroContabilidadDefecto relparametrocontabilidaddefecto)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relparametrocontabilidaddefecto.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,ParametroContabilidadDefecto relparametrocontabilidaddefecto)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relparametrocontabilidaddefecto.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public TipoMoneda getTipoMoneda(Connexion connexion,ParametroContabilidadDefecto relparametrocontabilidaddefecto)throws SQLException,Exception {

		TipoMoneda tipomoneda= new TipoMoneda();

		try {
			TipoMonedaDataAccess tipomonedaDataAccess=new TipoMonedaDataAccess();

			tipomonedaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipomonedaDataAccess.setConnexionType(this.connexionType);
			tipomonedaDataAccess.setParameterDbType(this.parameterDbType);

			tipomoneda=tipomonedaDataAccess.getEntity(connexion,relparametrocontabilidaddefecto.getid_tipo_moneda());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipomoneda;

	}

	public Moneda getMoneda(Connexion connexion,ParametroContabilidadDefecto relparametrocontabilidaddefecto)throws SQLException,Exception {

		Moneda moneda= new Moneda();

		try {
			MonedaDataAccess monedaDataAccess=new MonedaDataAccess();

			monedaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			monedaDataAccess.setConnexionType(this.connexionType);
			monedaDataAccess.setParameterDbType(this.parameterDbType);

			moneda=monedaDataAccess.getEntity(connexion,relparametrocontabilidaddefecto.getid_moneda());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return moneda;

	}

	public Modulo getModulo(Connexion connexion,ParametroContabilidadDefecto relparametrocontabilidaddefecto)throws SQLException,Exception {

		Modulo modulo= new Modulo();

		try {
			ModuloDataAccess moduloDataAccess=new ModuloDataAccess();

			moduloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			moduloDataAccess.setConnexionType(this.connexionType);
			moduloDataAccess.setParameterDbType(this.parameterDbType);

			modulo=moduloDataAccess.getEntity(connexion,relparametrocontabilidaddefecto.getid_modulo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return modulo;

	}

	public TipoIntervalo getTipoIntervalo(Connexion connexion,ParametroContabilidadDefecto relparametrocontabilidaddefecto)throws SQLException,Exception {

		TipoIntervalo tipointervalo= new TipoIntervalo();

		try {
			TipoIntervaloDataAccess tipointervaloDataAccess=new TipoIntervaloDataAccess();

			tipointervaloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipointervaloDataAccess.setConnexionType(this.connexionType);
			tipointervaloDataAccess.setParameterDbType(this.parameterDbType);

			tipointervalo=tipointervaloDataAccess.getEntity(connexion,relparametrocontabilidaddefecto.getid_tipo_intervalo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipointervalo;

	}

	public TipoMovimiento getTipoMovimiento(Connexion connexion,ParametroContabilidadDefecto relparametrocontabilidaddefecto)throws SQLException,Exception {

		TipoMovimiento tipomovimiento= new TipoMovimiento();

		try {
			TipoMovimientoDataAccess tipomovimientoDataAccess=new TipoMovimientoDataAccess();

			tipomovimientoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipomovimientoDataAccess.setConnexionType(this.connexionType);
			tipomovimientoDataAccess.setParameterDbType(this.parameterDbType);

			tipomovimiento=tipomovimientoDataAccess.getEntity(connexion,relparametrocontabilidaddefecto.getid_tipo_movimiento());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipomovimiento;

	}

	public TipoDocumento getTipoDocumento(Connexion connexion,ParametroContabilidadDefecto relparametrocontabilidaddefecto)throws SQLException,Exception {

		TipoDocumento tipodocumento= new TipoDocumento();

		try {
			TipoDocumentoDataAccess tipodocumentoDataAccess=new TipoDocumentoDataAccess();

			tipodocumentoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipodocumentoDataAccess.setConnexionType(this.connexionType);
			tipodocumentoDataAccess.setParameterDbType(this.parameterDbType);

			tipodocumento=tipodocumentoDataAccess.getEntity(connexion,relparametrocontabilidaddefecto.getid_tipo_documento());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipodocumento;

	}

	public EstadoAsientoContable getEstadoAsientoContable(Connexion connexion,ParametroContabilidadDefecto relparametrocontabilidaddefecto)throws SQLException,Exception {

		EstadoAsientoContable estadoasientocontable= new EstadoAsientoContable();

		try {
			EstadoAsientoContableDataAccess estadoasientocontableDataAccess=new EstadoAsientoContableDataAccess();

			//estadoasientocontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadoasientocontableDataAccess.setConnexionType(this.connexionType);
			estadoasientocontableDataAccess.setParameterDbType(this.parameterDbType);

			estadoasientocontable=estadoasientocontableDataAccess.getEntity(connexion,relparametrocontabilidaddefecto.getid_estado_asiento_contable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadoasientocontable;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,ParametroContabilidadDefecto parametrocontabilidaddefecto) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!parametrocontabilidaddefecto.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(parametrocontabilidaddefecto.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(parametrocontabilidaddefecto.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_moneda=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_moneda.setValue(parametrocontabilidaddefecto.getid_tipo_moneda());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_moneda);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_moneda=new ParameterValue<Long>();
					parameterMaintenanceValueid_moneda.setValue(parametrocontabilidaddefecto.getid_moneda());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_moneda);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_modulo=new ParameterValue<Long>();
					parameterMaintenanceValueid_modulo.setValue(parametrocontabilidaddefecto.getid_modulo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_modulo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_intervalo=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_intervalo.setValue(parametrocontabilidaddefecto.getid_tipo_intervalo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_intervalo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_movimiento=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_movimiento.setValue(parametrocontabilidaddefecto.getid_tipo_movimiento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_movimiento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_documento=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_documento.setValue(parametrocontabilidaddefecto.getid_tipo_documento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_documento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_asiento_contable=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_asiento_contable.setValue(parametrocontabilidaddefecto.getid_estado_asiento_contable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_asiento_contable);
					parametersTemp.add(parameterMaintenance);
					
						if(!parametrocontabilidaddefecto.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(parametrocontabilidaddefecto.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(parametrocontabilidaddefecto.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(parametrocontabilidaddefecto.getId());
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
	
	public void setIsNewIsChangedFalseParametroContabilidadDefecto(ParametroContabilidadDefecto parametrocontabilidaddefecto)throws Exception  {		
		parametrocontabilidaddefecto.setIsNew(false);
		parametrocontabilidaddefecto.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseParametroContabilidadDefectos(List<ParametroContabilidadDefecto> parametrocontabilidaddefectos)throws Exception  {				
		for(ParametroContabilidadDefecto parametrocontabilidaddefecto:parametrocontabilidaddefectos) {
			parametrocontabilidaddefecto.setIsNew(false);
			parametrocontabilidaddefecto.setIsChanged(false);
		}
	}
	
	public void generarExportarParametroContabilidadDefecto(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
