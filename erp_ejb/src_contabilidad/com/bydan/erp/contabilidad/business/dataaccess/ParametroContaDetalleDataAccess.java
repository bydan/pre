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
import com.bydan.erp.contabilidad.util.*;//ParametroContaDetalleConstantesFunciones;










@SuppressWarnings("unused")
final public class ParametroContaDetalleDataAccess extends  ParametroContaDetalleDataAccessAdditional{ //ParametroContaDetalleDataAccessAdditional,DataAccessHelper<ParametroContaDetalle>
	//static Logger logger = Logger.getLogger(ParametroContaDetalleDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="parametro_conta_detalle";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ParametroContaDetalleConstantesFunciones.SCHEMA+"."+ParametroContaDetalleConstantesFunciones.TABLENAME+"(version_row,id_parametro_conta,id_tipo_parametro_conta,id_cuenta_contable)values(current_timestamp,?,?,?)";
	public static String QUERYUPDATE="update "+ParametroContaDetalleConstantesFunciones.SCHEMA+"."+ParametroContaDetalleConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_parametro_conta=?,id_tipo_parametro_conta=?,id_cuenta_contable=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ParametroContaDetalleConstantesFunciones.SCHEMA+"."+ParametroContaDetalleConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select parametrocontadetalle from "+ParametroContaDetalleConstantesFunciones.SPERSISTENCENAME+" parametrocontadetalle";
	public static String QUERYSELECTNATIVE="select "+ParametroContaDetalleConstantesFunciones.SCHEMA+"."+ParametroContaDetalleConstantesFunciones.TABLENAME+".id,"+ParametroContaDetalleConstantesFunciones.SCHEMA+"."+ParametroContaDetalleConstantesFunciones.TABLENAME+".version_row,"+ParametroContaDetalleConstantesFunciones.SCHEMA+"."+ParametroContaDetalleConstantesFunciones.TABLENAME+".id_parametro_conta,"+ParametroContaDetalleConstantesFunciones.SCHEMA+"."+ParametroContaDetalleConstantesFunciones.TABLENAME+".id_tipo_parametro_conta,"+ParametroContaDetalleConstantesFunciones.SCHEMA+"."+ParametroContaDetalleConstantesFunciones.TABLENAME+".id_cuenta_contable from "+ParametroContaDetalleConstantesFunciones.SCHEMA+"."+ParametroContaDetalleConstantesFunciones.TABLENAME;//+" as "+ParametroContaDetalleConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ParametroContaDetalleConstantesFunciones.SCHEMA+"."+ParametroContaDetalleConstantesFunciones.TABLENAME+".id,"+ParametroContaDetalleConstantesFunciones.SCHEMA+"."+ParametroContaDetalleConstantesFunciones.TABLENAME+".version_row from "+ParametroContaDetalleConstantesFunciones.SCHEMA+"."+ParametroContaDetalleConstantesFunciones.TABLENAME;//+" as "+ParametroContaDetalleConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ParametroContaDetalleConstantesFunciones.SCHEMA+"."+ParametroContaDetalleConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_parametro_conta=?,id_tipo_parametro_conta=?,id_cuenta_contable=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PARAMETROCONTADETALLE_INSERT(?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PARAMETROCONTADETALLE_UPDATE(?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PARAMETROCONTADETALLE_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PARAMETROCONTADETALLE_SELECT(?,?)";
	
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
	
	
	protected ParametroContaDetalleDataAccessAdditional parametrocontadetalleDataAccessAdditional=null;
	
	public ParametroContaDetalleDataAccessAdditional getParametroContaDetalleDataAccessAdditional() {
		return this.parametrocontadetalleDataAccessAdditional;
	}
	
	public void setParametroContaDetalleDataAccessAdditional(ParametroContaDetalleDataAccessAdditional parametrocontadetalleDataAccessAdditional) {
		try {
			this.parametrocontadetalleDataAccessAdditional=parametrocontadetalleDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ParametroContaDetalleDataAccess() {
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
		ParametroContaDetalleDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ParametroContaDetalleDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ParametroContaDetalleDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setParametroContaDetalleOriginal(ParametroContaDetalle parametrocontadetalle)throws Exception  {
		parametrocontadetalle.setParametroContaDetalleOriginal((ParametroContaDetalle)parametrocontadetalle.clone());		
	}
	
	public void setParametroContaDetallesOriginal(List<ParametroContaDetalle> parametrocontadetalles)throws Exception  {
		
		for(ParametroContaDetalle parametrocontadetalle:parametrocontadetalles){
			parametrocontadetalle.setParametroContaDetalleOriginal((ParametroContaDetalle)parametrocontadetalle.clone());
		}
	}
	
	public static void setParametroContaDetalleOriginalStatic(ParametroContaDetalle parametrocontadetalle)throws Exception  {
		parametrocontadetalle.setParametroContaDetalleOriginal((ParametroContaDetalle)parametrocontadetalle.clone());		
	}
	
	public static void setParametroContaDetallesOriginalStatic(List<ParametroContaDetalle> parametrocontadetalles)throws Exception  {
		
		for(ParametroContaDetalle parametrocontadetalle:parametrocontadetalles){
			parametrocontadetalle.setParametroContaDetalleOriginal((ParametroContaDetalle)parametrocontadetalle.clone());
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
	
	public  ParametroContaDetalle getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		ParametroContaDetalle entity = new ParametroContaDetalle();		
		
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
	
	public  ParametroContaDetalle getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		ParametroContaDetalle entity = new ParametroContaDetalle();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroContaDetalleDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroContaDetalleDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Contabilidad.ParametroContaDetalle.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setParametroContaDetalleOriginal(new ParametroContaDetalle());
      	    	entity=super.getEntity("",entity,resultSet,ParametroContaDetalleDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityParametroContaDetalle("",entity,resultSet); 
				
				//entity.setParametroContaDetalleOriginal(super.getEntity("",entity.getParametroContaDetalleOriginal(),resultSet,ParametroContaDetalleDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroContaDetalleOriginal(this.getEntityParametroContaDetalle("",entity.getParametroContaDetalleOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseParametroContaDetalle(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  ParametroContaDetalle getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ParametroContaDetalle entity = new ParametroContaDetalle();
				
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
	
	public  ParametroContaDetalle getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ParametroContaDetalle entity = new ParametroContaDetalle();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroContaDetalleDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroContaDetalleDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroContaDetalleDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.ParametroContaDetalle.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setParametroContaDetalleOriginal(new ParametroContaDetalle());
      	    	entity=super.getEntity("",entity,resultSet,ParametroContaDetalleDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityParametroContaDetalle("",entity,resultSet);    
				
				//entity.setParametroContaDetalleOriginal(super.getEntity("",entity.getParametroContaDetalleOriginal(),resultSet,ParametroContaDetalleDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroContaDetalleOriginal(this.getEntityParametroContaDetalle("",entity.getParametroContaDetalleOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseParametroContaDetalle(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //ParametroContaDetalle
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		ParametroContaDetalle entity = new ParametroContaDetalle();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroContaDetalleDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroContaDetalleDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroContaDetalleDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.ParametroContaDetalle.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseParametroContaDetalle(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<ParametroContaDetalle> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ParametroContaDetalle> entities = new  ArrayList<ParametroContaDetalle>();
		ParametroContaDetalle entity = new ParametroContaDetalle();		  
		
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
	
	public  List<ParametroContaDetalle> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ParametroContaDetalle> entities = new  ArrayList<ParametroContaDetalle>();
		ParametroContaDetalle entity = new ParametroContaDetalle();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroContaDetalleDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroContaDetalleDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroContaDetalleDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroContaDetalle();
      	    	entity=super.getEntity("",entity,resultSet,ParametroContaDetalleDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroContaDetalle("",entity,resultSet);
      	    	
				//entity.setParametroContaDetalleOriginal( new ParametroContaDetalle());
      	    	//entity.setParametroContaDetalleOriginal(super.getEntity("",entity.getParametroContaDetalleOriginal(),resultSet,ParametroContaDetalleDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroContaDetalleOriginal(this.getEntityParametroContaDetalle("",entity.getParametroContaDetalleOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroContaDetalles(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroContaDetalle(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ParametroContaDetalle> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ParametroContaDetalle> entities = new  ArrayList<ParametroContaDetalle>();
		ParametroContaDetalle entity = new ParametroContaDetalle();		  
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
	
	public  List<ParametroContaDetalle> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ParametroContaDetalle> entities = new  ArrayList<ParametroContaDetalle>();
		ParametroContaDetalle entity = new ParametroContaDetalle();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroContaDetalle();
				
				if(conMapGenerico) {
					entity.inicializarMapParametroContaDetalle();
					//entity.setMapParametroContaDetalle(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapParametroContaDetalleValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapParametroContaDetalle().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ParametroContaDetalleDataAccess.ISWITHSCHEMA);         		
					entity=ParametroContaDetalleDataAccess.getEntityParametroContaDetalle("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setParametroContaDetalleOriginal( new ParametroContaDetalle());
					////entity.setParametroContaDetalleOriginal(super.getEntity("",entity.getParametroContaDetalleOriginal(),resultSet,ParametroContaDetalleDataAccess.ISWITHSCHEMA));         		
					////entity.setParametroContaDetalleOriginal(this.getEntityParametroContaDetalle("",entity.getParametroContaDetalleOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroContaDetalles(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroContaDetalle(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public ParametroContaDetalle getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ParametroContaDetalle entity = new ParametroContaDetalle();		  
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
	
	public  ParametroContaDetalle getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ParametroContaDetalle entity = new ParametroContaDetalle();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroContaDetalle();
				
				if(conMapGenerico) {
					entity.inicializarMapParametroContaDetalle();
					//entity.setMapParametroContaDetalle(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapParametroContaDetalleValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapParametroContaDetalle().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ParametroContaDetalleDataAccess.ISWITHSCHEMA);         		
					entity=ParametroContaDetalleDataAccess.getEntityParametroContaDetalle("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setParametroContaDetalleOriginal( new ParametroContaDetalle());
					////entity.setParametroContaDetalleOriginal(super.getEntity("",entity.getParametroContaDetalleOriginal(),resultSet,ParametroContaDetalleDataAccess.ISWITHSCHEMA));         		
					////entity.setParametroContaDetalleOriginal(this.getEntityParametroContaDetalle("",entity.getParametroContaDetalleOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseParametroContaDetalle(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroContaDetalle(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ParametroContaDetalle getEntityParametroContaDetalle(String strPrefijo,ParametroContaDetalle entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = ParametroContaDetalle.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = ParametroContaDetalle.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ParametroContaDetalleDataAccess.setFieldReflectionParametroContaDetalle(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasParametroContaDetalle=ParametroContaDetalleConstantesFunciones.getTodosTiposColumnasParametroContaDetalle();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasParametroContaDetalle) {
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
							field = ParametroContaDetalle.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = ParametroContaDetalle.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ParametroContaDetalleDataAccess.setFieldReflectionParametroContaDetalle(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionParametroContaDetalle(Field field,String strPrefijo,String sColumn,ParametroContaDetalle entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ParametroContaDetalleConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroContaDetalleConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ParametroContaDetalleConstantesFunciones.IDPARAMETROCONTA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroContaDetalleConstantesFunciones.IDTIPOPARAMETROCONTA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroContaDetalleConstantesFunciones.IDCUENTACONTABLE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ParametroContaDetalle>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<ParametroContaDetalle> entities = new  ArrayList<ParametroContaDetalle>();
		ParametroContaDetalle entity = new ParametroContaDetalle();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroContaDetalleDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroContaDetalleDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroContaDetalleDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new ParametroContaDetalle();
					entity=super.getEntity("",entity,resultSet,ParametroContaDetalleDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityParametroContaDetalle("",entity,resultSet);
					
					//entity.setParametroContaDetalleOriginal( new ParametroContaDetalle());
					//entity.setParametroContaDetalleOriginal(super.getEntity("",entity.getParametroContaDetalleOriginal(),resultSet,ParametroContaDetalleDataAccess.ISWITHSCHEMA));         		
					//entity.setParametroContaDetalleOriginal(this.getEntityParametroContaDetalle("",entity.getParametroContaDetalleOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseParametroContaDetalles(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroContaDetalle(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ParametroContaDetalle>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<ParametroContaDetalle> entities = new  ArrayList<ParametroContaDetalle>();
		ParametroContaDetalle entity = new ParametroContaDetalle();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroContaDetalleDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroContaDetalleDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroContaDetalleDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<ParametroContaDetalle> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroContaDetalle> entities = new  ArrayList<ParametroContaDetalle>();
		ParametroContaDetalle entity = new ParametroContaDetalle();		  
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
	
	public  List<ParametroContaDetalle> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroContaDetalle> entities = new  ArrayList<ParametroContaDetalle>();
		ParametroContaDetalle entity = new ParametroContaDetalle();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroContaDetalle();
      	    	entity=super.getEntity("",entity,resultSet,ParametroContaDetalleDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroContaDetalle("",entity,resultSet);
      	    	
				//entity.setParametroContaDetalleOriginal( new ParametroContaDetalle());
      	    	//entity.setParametroContaDetalleOriginal(super.getEntity("",entity.getParametroContaDetalleOriginal(),resultSet,ParametroContaDetalleDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroContaDetalleOriginal(this.getEntityParametroContaDetalle("",entity.getParametroContaDetalleOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseParametroContaDetalles(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroContaDetalle(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ParametroContaDetalle> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroContaDetalle> entities = new  ArrayList<ParametroContaDetalle>();
		ParametroContaDetalle entity = new ParametroContaDetalle();		  
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
	
	public  List<ParametroContaDetalle> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroContaDetalle> entities = new  ArrayList<ParametroContaDetalle>();
		ParametroContaDetalle entity = new ParametroContaDetalle();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroContaDetalle();
      	    	entity=super.getEntity("",entity,resultSet,ParametroContaDetalleDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroContaDetalle("",entity,resultSet);
      	    	
				//entity.setParametroContaDetalleOriginal( new ParametroContaDetalle());
      	    	//entity.setParametroContaDetalleOriginal(super.getEntity("",entity.getParametroContaDetalleOriginal(),resultSet,ParametroContaDetalleDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroContaDetalleOriginal(this.getEntityParametroContaDetalle("",entity.getParametroContaDetalleOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroContaDetalles(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public ParametroContaDetalle getEntityParametroContaDetalle(String strPrefijo,ParametroContaDetalle entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_parametro_conta(resultSet.getLong(strPrefijo+ParametroContaDetalleConstantesFunciones.IDPARAMETROCONTA));
				entity.setid_tipo_parametro_conta(resultSet.getLong(strPrefijo+ParametroContaDetalleConstantesFunciones.IDTIPOPARAMETROCONTA));
				entity.setid_cuenta_contable(resultSet.getLong(strPrefijo+ParametroContaDetalleConstantesFunciones.IDCUENTACONTABLE));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowParametroContaDetalle(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(ParametroContaDetalle entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ParametroContaDetalleDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ParametroContaDetalleDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ParametroContaDetalleDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ParametroContaDetalleDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ParametroContaDetalleConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ParametroContaDetalleDataAccess.TABLENAME,ParametroContaDetalleDataAccess.ISWITHSTOREPROCEDURES);
			
			ParametroContaDetalleDataAccess.setParametroContaDetalleOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public ParametroConta getParametroConta(Connexion connexion,ParametroContaDetalle relparametrocontadetalle)throws SQLException,Exception {

		ParametroConta parametroconta= new ParametroConta();

		try {
			ParametroContaDataAccess parametrocontaDataAccess=new ParametroContaDataAccess();

			parametrocontaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			parametrocontaDataAccess.setConnexionType(this.connexionType);
			parametrocontaDataAccess.setParameterDbType(this.parameterDbType);

			parametroconta=parametrocontaDataAccess.getEntity(connexion,relparametrocontadetalle.getid_parametro_conta());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return parametroconta;

	}

	public TipoParametroConta getTipoParametroConta(Connexion connexion,ParametroContaDetalle relparametrocontadetalle)throws SQLException,Exception {

		TipoParametroConta tipoparametroconta= new TipoParametroConta();

		try {
			TipoParametroContaDataAccess tipoparametrocontaDataAccess=new TipoParametroContaDataAccess();

			tipoparametrocontaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoparametrocontaDataAccess.setConnexionType(this.connexionType);
			tipoparametrocontaDataAccess.setParameterDbType(this.parameterDbType);

			tipoparametroconta=tipoparametrocontaDataAccess.getEntity(connexion,relparametrocontadetalle.getid_tipo_parametro_conta());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoparametroconta;

	}

	public CuentaContable getCuentaContable(Connexion connexion,ParametroContaDetalle relparametrocontadetalle)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relparametrocontadetalle.getid_cuenta_contable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,ParametroContaDetalle parametrocontadetalle) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!parametrocontadetalle.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_parametro_conta=new ParameterValue<Long>();
					parameterMaintenanceValueid_parametro_conta.setValue(parametrocontadetalle.getid_parametro_conta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_parametro_conta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_parametro_conta=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_parametro_conta.setValue(parametrocontadetalle.getid_tipo_parametro_conta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_parametro_conta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable.setValue(parametrocontadetalle.getid_cuenta_contable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable);
					parametersTemp.add(parameterMaintenance);
					
						if(!parametrocontadetalle.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(parametrocontadetalle.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(parametrocontadetalle.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(parametrocontadetalle.getId());
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
	
	public void setIsNewIsChangedFalseParametroContaDetalle(ParametroContaDetalle parametrocontadetalle)throws Exception  {		
		parametrocontadetalle.setIsNew(false);
		parametrocontadetalle.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseParametroContaDetalles(List<ParametroContaDetalle> parametrocontadetalles)throws Exception  {				
		for(ParametroContaDetalle parametrocontadetalle:parametrocontadetalles) {
			parametrocontadetalle.setIsNew(false);
			parametrocontadetalle.setIsChanged(false);
		}
	}
	
	public void generarExportarParametroContaDetalle(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
