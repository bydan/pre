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
import com.bydan.erp.contabilidad.util.*;//DatoFormularioIvaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class DatoFormularioIvaDataAccess extends  DatoFormularioIvaDataAccessAdditional{ //DatoFormularioIvaDataAccessAdditional,DataAccessHelper<DatoFormularioIva>
	//static Logger logger = Logger.getLogger(DatoFormularioIvaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="dato_formulario_iva";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+DatoFormularioIvaConstantesFunciones.SCHEMA+"."+DatoFormularioIvaConstantesFunciones.TABLENAME+"(version_row,es_mensual,id_anio,id_mes,id_semestre,es_sustitutiva,numero_formulario)values(current_timestamp,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+DatoFormularioIvaConstantesFunciones.SCHEMA+"."+DatoFormularioIvaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,es_mensual=?,id_anio=?,id_mes=?,id_semestre=?,es_sustitutiva=?,numero_formulario=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+DatoFormularioIvaConstantesFunciones.SCHEMA+"."+DatoFormularioIvaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select datoformularioiva from "+DatoFormularioIvaConstantesFunciones.SPERSISTENCENAME+" datoformularioiva";
	public static String QUERYSELECTNATIVE="select "+DatoFormularioIvaConstantesFunciones.SCHEMA+"."+DatoFormularioIvaConstantesFunciones.TABLENAME+".id,"+DatoFormularioIvaConstantesFunciones.SCHEMA+"."+DatoFormularioIvaConstantesFunciones.TABLENAME+".version_row,"+DatoFormularioIvaConstantesFunciones.SCHEMA+"."+DatoFormularioIvaConstantesFunciones.TABLENAME+".es_mensual,"+DatoFormularioIvaConstantesFunciones.SCHEMA+"."+DatoFormularioIvaConstantesFunciones.TABLENAME+".id_anio,"+DatoFormularioIvaConstantesFunciones.SCHEMA+"."+DatoFormularioIvaConstantesFunciones.TABLENAME+".id_mes,"+DatoFormularioIvaConstantesFunciones.SCHEMA+"."+DatoFormularioIvaConstantesFunciones.TABLENAME+".id_semestre,"+DatoFormularioIvaConstantesFunciones.SCHEMA+"."+DatoFormularioIvaConstantesFunciones.TABLENAME+".es_sustitutiva,"+DatoFormularioIvaConstantesFunciones.SCHEMA+"."+DatoFormularioIvaConstantesFunciones.TABLENAME+".numero_formulario from "+DatoFormularioIvaConstantesFunciones.SCHEMA+"."+DatoFormularioIvaConstantesFunciones.TABLENAME;//+" as "+DatoFormularioIvaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+DatoFormularioIvaConstantesFunciones.SCHEMA+"."+DatoFormularioIvaConstantesFunciones.TABLENAME+".id,"+DatoFormularioIvaConstantesFunciones.SCHEMA+"."+DatoFormularioIvaConstantesFunciones.TABLENAME+".version_row from "+DatoFormularioIvaConstantesFunciones.SCHEMA+"."+DatoFormularioIvaConstantesFunciones.TABLENAME;//+" as "+DatoFormularioIvaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+DatoFormularioIvaConstantesFunciones.SCHEMA+"."+DatoFormularioIvaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,es_mensual=?,id_anio=?,id_mes=?,id_semestre=?,es_sustitutiva=?,numero_formulario=?";
	
	public static String STOREPROCEDUREINSERT="call SP_DATOFORMULARIOIVA_INSERT(?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_DATOFORMULARIOIVA_UPDATE(?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_DATOFORMULARIOIVA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_DATOFORMULARIOIVA_SELECT(?,?)";
	
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
	
	
	protected DatoFormularioIvaDataAccessAdditional datoformularioivaDataAccessAdditional=null;
	
	public DatoFormularioIvaDataAccessAdditional getDatoFormularioIvaDataAccessAdditional() {
		return this.datoformularioivaDataAccessAdditional;
	}
	
	public void setDatoFormularioIvaDataAccessAdditional(DatoFormularioIvaDataAccessAdditional datoformularioivaDataAccessAdditional) {
		try {
			this.datoformularioivaDataAccessAdditional=datoformularioivaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public DatoFormularioIvaDataAccess() {
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
		DatoFormularioIvaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		DatoFormularioIvaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		DatoFormularioIvaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setDatoFormularioIvaOriginal(DatoFormularioIva datoformularioiva)throws Exception  {
		datoformularioiva.setDatoFormularioIvaOriginal((DatoFormularioIva)datoformularioiva.clone());		
	}
	
	public void setDatoFormularioIvasOriginal(List<DatoFormularioIva> datoformularioivas)throws Exception  {
		
		for(DatoFormularioIva datoformularioiva:datoformularioivas){
			datoformularioiva.setDatoFormularioIvaOriginal((DatoFormularioIva)datoformularioiva.clone());
		}
	}
	
	public static void setDatoFormularioIvaOriginalStatic(DatoFormularioIva datoformularioiva)throws Exception  {
		datoformularioiva.setDatoFormularioIvaOriginal((DatoFormularioIva)datoformularioiva.clone());		
	}
	
	public static void setDatoFormularioIvasOriginalStatic(List<DatoFormularioIva> datoformularioivas)throws Exception  {
		
		for(DatoFormularioIva datoformularioiva:datoformularioivas){
			datoformularioiva.setDatoFormularioIvaOriginal((DatoFormularioIva)datoformularioiva.clone());
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
	
	public  DatoFormularioIva getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		DatoFormularioIva entity = new DatoFormularioIva();		
		
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
	
	public  DatoFormularioIva getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		DatoFormularioIva entity = new DatoFormularioIva();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DatoFormularioIvaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DatoFormularioIvaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Contabilidad.DatoFormularioIva.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setDatoFormularioIvaOriginal(new DatoFormularioIva());
      	    	entity=super.getEntity("",entity,resultSet,DatoFormularioIvaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDatoFormularioIva("",entity,resultSet); 
				
				//entity.setDatoFormularioIvaOriginal(super.getEntity("",entity.getDatoFormularioIvaOriginal(),resultSet,DatoFormularioIvaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDatoFormularioIvaOriginal(this.getEntityDatoFormularioIva("",entity.getDatoFormularioIvaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseDatoFormularioIva(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  DatoFormularioIva getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DatoFormularioIva entity = new DatoFormularioIva();
				
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
	
	public  DatoFormularioIva getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DatoFormularioIva entity = new DatoFormularioIva();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DatoFormularioIvaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DatoFormularioIvaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DatoFormularioIvaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.DatoFormularioIva.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setDatoFormularioIvaOriginal(new DatoFormularioIva());
      	    	entity=super.getEntity("",entity,resultSet,DatoFormularioIvaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDatoFormularioIva("",entity,resultSet);    
				
				//entity.setDatoFormularioIvaOriginal(super.getEntity("",entity.getDatoFormularioIvaOriginal(),resultSet,DatoFormularioIvaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDatoFormularioIvaOriginal(this.getEntityDatoFormularioIva("",entity.getDatoFormularioIvaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseDatoFormularioIva(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //DatoFormularioIva
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		DatoFormularioIva entity = new DatoFormularioIva();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DatoFormularioIvaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DatoFormularioIvaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DatoFormularioIvaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.DatoFormularioIva.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseDatoFormularioIva(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<DatoFormularioIva> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DatoFormularioIva> entities = new  ArrayList<DatoFormularioIva>();
		DatoFormularioIva entity = new DatoFormularioIva();		  
		
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
	
	public  List<DatoFormularioIva> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DatoFormularioIva> entities = new  ArrayList<DatoFormularioIva>();
		DatoFormularioIva entity = new DatoFormularioIva();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=DatoFormularioIvaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DatoFormularioIvaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DatoFormularioIvaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DatoFormularioIva();
      	    	entity=super.getEntity("",entity,resultSet,DatoFormularioIvaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDatoFormularioIva("",entity,resultSet);
      	    	
				//entity.setDatoFormularioIvaOriginal( new DatoFormularioIva());
      	    	//entity.setDatoFormularioIvaOriginal(super.getEntity("",entity.getDatoFormularioIvaOriginal(),resultSet,DatoFormularioIvaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDatoFormularioIvaOriginal(this.getEntityDatoFormularioIva("",entity.getDatoFormularioIvaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDatoFormularioIvas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDatoFormularioIva(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DatoFormularioIva> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DatoFormularioIva> entities = new  ArrayList<DatoFormularioIva>();
		DatoFormularioIva entity = new DatoFormularioIva();		  
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
	
	public  List<DatoFormularioIva> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DatoFormularioIva> entities = new  ArrayList<DatoFormularioIva>();
		DatoFormularioIva entity = new DatoFormularioIva();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DatoFormularioIva();
				
				if(conMapGenerico) {
					entity.inicializarMapDatoFormularioIva();
					//entity.setMapDatoFormularioIva(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapDatoFormularioIvaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDatoFormularioIva().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DatoFormularioIvaDataAccess.ISWITHSCHEMA);         		
					entity=DatoFormularioIvaDataAccess.getEntityDatoFormularioIva("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDatoFormularioIvaOriginal( new DatoFormularioIva());
					////entity.setDatoFormularioIvaOriginal(super.getEntity("",entity.getDatoFormularioIvaOriginal(),resultSet,DatoFormularioIvaDataAccess.ISWITHSCHEMA));         		
					////entity.setDatoFormularioIvaOriginal(this.getEntityDatoFormularioIva("",entity.getDatoFormularioIvaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDatoFormularioIvas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDatoFormularioIva(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public DatoFormularioIva getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DatoFormularioIva entity = new DatoFormularioIva();		  
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
	
	public  DatoFormularioIva getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DatoFormularioIva entity = new DatoFormularioIva();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DatoFormularioIva();
				
				if(conMapGenerico) {
					entity.inicializarMapDatoFormularioIva();
					//entity.setMapDatoFormularioIva(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapDatoFormularioIvaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDatoFormularioIva().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DatoFormularioIvaDataAccess.ISWITHSCHEMA);         		
					entity=DatoFormularioIvaDataAccess.getEntityDatoFormularioIva("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDatoFormularioIvaOriginal( new DatoFormularioIva());
					////entity.setDatoFormularioIvaOriginal(super.getEntity("",entity.getDatoFormularioIvaOriginal(),resultSet,DatoFormularioIvaDataAccess.ISWITHSCHEMA));         		
					////entity.setDatoFormularioIvaOriginal(this.getEntityDatoFormularioIva("",entity.getDatoFormularioIvaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseDatoFormularioIva(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDatoFormularioIva(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static DatoFormularioIva getEntityDatoFormularioIva(String strPrefijo,DatoFormularioIva entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = DatoFormularioIva.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = DatoFormularioIva.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					DatoFormularioIvaDataAccess.setFieldReflectionDatoFormularioIva(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasDatoFormularioIva=DatoFormularioIvaConstantesFunciones.getTodosTiposColumnasDatoFormularioIva();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasDatoFormularioIva) {
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
							field = DatoFormularioIva.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = DatoFormularioIva.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						DatoFormularioIvaDataAccess.setFieldReflectionDatoFormularioIva(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionDatoFormularioIva(Field field,String strPrefijo,String sColumn,DatoFormularioIva entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case DatoFormularioIvaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DatoFormularioIvaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DatoFormularioIvaConstantesFunciones.ESMENSUAL:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case DatoFormularioIvaConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DatoFormularioIvaConstantesFunciones.IDMES:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DatoFormularioIvaConstantesFunciones.IDSEMESTRE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DatoFormularioIvaConstantesFunciones.ESSUSTITUTIVA:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case DatoFormularioIvaConstantesFunciones.NUMEROFORMULARIO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DatoFormularioIva>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<DatoFormularioIva> entities = new  ArrayList<DatoFormularioIva>();
		DatoFormularioIva entity = new DatoFormularioIva();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DatoFormularioIvaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DatoFormularioIvaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DatoFormularioIvaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new DatoFormularioIva();
					entity=super.getEntity("",entity,resultSet,DatoFormularioIvaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityDatoFormularioIva("",entity,resultSet);
					
					//entity.setDatoFormularioIvaOriginal( new DatoFormularioIva());
					//entity.setDatoFormularioIvaOriginal(super.getEntity("",entity.getDatoFormularioIvaOriginal(),resultSet,DatoFormularioIvaDataAccess.ISWITHSCHEMA));         		
					//entity.setDatoFormularioIvaOriginal(this.getEntityDatoFormularioIva("",entity.getDatoFormularioIvaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseDatoFormularioIvas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDatoFormularioIva(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DatoFormularioIva>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<DatoFormularioIva> entities = new  ArrayList<DatoFormularioIva>();
		DatoFormularioIva entity = new DatoFormularioIva();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DatoFormularioIvaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DatoFormularioIvaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DatoFormularioIvaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<DatoFormularioIva> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DatoFormularioIva> entities = new  ArrayList<DatoFormularioIva>();
		DatoFormularioIva entity = new DatoFormularioIva();		  
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
	
	public  List<DatoFormularioIva> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DatoFormularioIva> entities = new  ArrayList<DatoFormularioIva>();
		DatoFormularioIva entity = new DatoFormularioIva();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DatoFormularioIva();
      	    	entity=super.getEntity("",entity,resultSet,DatoFormularioIvaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDatoFormularioIva("",entity,resultSet);
      	    	
				//entity.setDatoFormularioIvaOriginal( new DatoFormularioIva());
      	    	//entity.setDatoFormularioIvaOriginal(super.getEntity("",entity.getDatoFormularioIvaOriginal(),resultSet,DatoFormularioIvaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDatoFormularioIvaOriginal(this.getEntityDatoFormularioIva("",entity.getDatoFormularioIvaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseDatoFormularioIvas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDatoFormularioIva(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DatoFormularioIva> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DatoFormularioIva> entities = new  ArrayList<DatoFormularioIva>();
		DatoFormularioIva entity = new DatoFormularioIva();		  
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
	
	public  List<DatoFormularioIva> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DatoFormularioIva> entities = new  ArrayList<DatoFormularioIva>();
		DatoFormularioIva entity = new DatoFormularioIva();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DatoFormularioIva();
      	    	entity=super.getEntity("",entity,resultSet,DatoFormularioIvaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDatoFormularioIva("",entity,resultSet);
      	    	
				//entity.setDatoFormularioIvaOriginal( new DatoFormularioIva());
      	    	//entity.setDatoFormularioIvaOriginal(super.getEntity("",entity.getDatoFormularioIvaOriginal(),resultSet,DatoFormularioIvaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDatoFormularioIvaOriginal(this.getEntityDatoFormularioIva("",entity.getDatoFormularioIvaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDatoFormularioIvas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public DatoFormularioIva getEntityDatoFormularioIva(String strPrefijo,DatoFormularioIva entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setes_mensual(resultSet.getBoolean(strPrefijo+DatoFormularioIvaConstantesFunciones.ESMENSUAL));
				entity.setid_anio(resultSet.getLong(strPrefijo+DatoFormularioIvaConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
				entity.setid_mes(resultSet.getLong(strPrefijo+DatoFormularioIvaConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
				entity.setid_semestre(resultSet.getLong(strPrefijo+DatoFormularioIvaConstantesFunciones.IDSEMESTRE));
				entity.setes_sustitutiva(resultSet.getBoolean(strPrefijo+DatoFormularioIvaConstantesFunciones.ESSUSTITUTIVA));
				entity.setnumero_formulario(resultSet.getString(strPrefijo+DatoFormularioIvaConstantesFunciones.NUMEROFORMULARIO));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowDatoFormularioIva(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(DatoFormularioIva entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=DatoFormularioIvaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=DatoFormularioIvaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=DatoFormularioIvaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=DatoFormularioIvaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(DatoFormularioIvaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,DatoFormularioIvaDataAccess.TABLENAME,DatoFormularioIvaDataAccess.ISWITHSTOREPROCEDURES);
			
			DatoFormularioIvaDataAccess.setDatoFormularioIvaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Anio getAnio(Connexion connexion,DatoFormularioIva reldatoformularioiva)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);

			anio=anioDataAccess.getEntity(connexion,reldatoformularioiva.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Mes getMes(Connexion connexion,DatoFormularioIva reldatoformularioiva)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,reldatoformularioiva.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}

	public Semestre getSemestre(Connexion connexion,DatoFormularioIva reldatoformularioiva)throws SQLException,Exception {

		Semestre semestre= new Semestre();

		try {
			SemestreDataAccess semestreDataAccess=new SemestreDataAccess();

			semestreDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			semestreDataAccess.setConnexionType(this.connexionType);
			semestreDataAccess.setParameterDbType(this.parameterDbType);

			semestre=semestreDataAccess.getEntity(connexion,reldatoformularioiva.getid_semestre());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return semestre;

	}


		
		public List<FormularioIva> getFormularioIvas(Connexion connexion,DatoFormularioIva datoformularioiva)throws SQLException,Exception {

		List<FormularioIva> formularioivas= new ArrayList<FormularioIva>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+DatoFormularioIvaConstantesFunciones.SCHEMA+".dato_formulario_iva ON "+FormularioIvaConstantesFunciones.SCHEMA+".formulario_iva.id_dato_formulario_iva="+DatoFormularioIvaConstantesFunciones.SCHEMA+".dato_formulario_iva.id WHERE "+DatoFormularioIvaConstantesFunciones.SCHEMA+".dato_formulario_iva.id="+String.valueOf(datoformularioiva.getId());
			} else {
				sQuery=" INNER JOIN formularioiva.DatoFormularioIva WHERE formularioiva.DatoFormularioIva.id="+String.valueOf(datoformularioiva.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			FormularioIvaDataAccess formularioivaDataAccess=new FormularioIvaDataAccess();

			formularioivaDataAccess.setConnexionType(this.connexionType);
			formularioivaDataAccess.setParameterDbType(this.parameterDbType);
			formularioivas=formularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formularioivas;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,DatoFormularioIva datoformularioiva) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!datoformularioiva.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_mensual=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_mensual.setValue(datoformularioiva.getes_mensual());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_mensual);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_anio=new ParameterValue<Long>();
					parameterMaintenanceValueid_anio.setValue(datoformularioiva.getid_anio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_anio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes.setValue(datoformularioiva.getid_mes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_semestre=new ParameterValue<Long>();
					parameterMaintenanceValueid_semestre.setValue(datoformularioiva.getid_semestre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_semestre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_sustitutiva=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_sustitutiva.setValue(datoformularioiva.getes_sustitutiva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_sustitutiva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_formulario=new ParameterValue<String>();
					parameterMaintenanceValuenumero_formulario.setValue(datoformularioiva.getnumero_formulario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_formulario);
					parametersTemp.add(parameterMaintenance);
					
						if(!datoformularioiva.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(datoformularioiva.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(datoformularioiva.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(datoformularioiva.getId());
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
	
	public void setIsNewIsChangedFalseDatoFormularioIva(DatoFormularioIva datoformularioiva)throws Exception  {		
		datoformularioiva.setIsNew(false);
		datoformularioiva.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseDatoFormularioIvas(List<DatoFormularioIva> datoformularioivas)throws Exception  {				
		for(DatoFormularioIva datoformularioiva:datoformularioivas) {
			datoformularioiva.setIsNew(false);
			datoformularioiva.setIsChanged(false);
		}
	}
	
	public void generarExportarDatoFormularioIva(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
