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
import com.bydan.erp.cartera.util.*;//ActividadEconomicaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class ActividadEconomicaDataAccess extends  ActividadEconomicaDataAccessAdditional{ //ActividadEconomicaDataAccessAdditional,DataAccessHelper<ActividadEconomica>
	//static Logger logger = Logger.getLogger(ActividadEconomicaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="actividad_economica";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ActividadEconomicaConstantesFunciones.SCHEMA+"."+ActividadEconomicaConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_cliente,nombre_negocio,actividad,id_pais,id_ciudad,direccion,telefono,ingreso_neto,ingreso_bruto)values(current_timestamp,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+ActividadEconomicaConstantesFunciones.SCHEMA+"."+ActividadEconomicaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_cliente=?,nombre_negocio=?,actividad=?,id_pais=?,id_ciudad=?,direccion=?,telefono=?,ingreso_neto=?,ingreso_bruto=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ActividadEconomicaConstantesFunciones.SCHEMA+"."+ActividadEconomicaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select actividadeconomica from "+ActividadEconomicaConstantesFunciones.SPERSISTENCENAME+" actividadeconomica";
	public static String QUERYSELECTNATIVE="select "+ActividadEconomicaConstantesFunciones.SCHEMA+"."+ActividadEconomicaConstantesFunciones.TABLENAME+".id,"+ActividadEconomicaConstantesFunciones.SCHEMA+"."+ActividadEconomicaConstantesFunciones.TABLENAME+".version_row,"+ActividadEconomicaConstantesFunciones.SCHEMA+"."+ActividadEconomicaConstantesFunciones.TABLENAME+".id_empresa,"+ActividadEconomicaConstantesFunciones.SCHEMA+"."+ActividadEconomicaConstantesFunciones.TABLENAME+".id_cliente,"+ActividadEconomicaConstantesFunciones.SCHEMA+"."+ActividadEconomicaConstantesFunciones.TABLENAME+".nombre_negocio,"+ActividadEconomicaConstantesFunciones.SCHEMA+"."+ActividadEconomicaConstantesFunciones.TABLENAME+".actividad,"+ActividadEconomicaConstantesFunciones.SCHEMA+"."+ActividadEconomicaConstantesFunciones.TABLENAME+".id_pais,"+ActividadEconomicaConstantesFunciones.SCHEMA+"."+ActividadEconomicaConstantesFunciones.TABLENAME+".id_ciudad,"+ActividadEconomicaConstantesFunciones.SCHEMA+"."+ActividadEconomicaConstantesFunciones.TABLENAME+".direccion,"+ActividadEconomicaConstantesFunciones.SCHEMA+"."+ActividadEconomicaConstantesFunciones.TABLENAME+".telefono,"+ActividadEconomicaConstantesFunciones.SCHEMA+"."+ActividadEconomicaConstantesFunciones.TABLENAME+".ingreso_neto,"+ActividadEconomicaConstantesFunciones.SCHEMA+"."+ActividadEconomicaConstantesFunciones.TABLENAME+".ingreso_bruto from "+ActividadEconomicaConstantesFunciones.SCHEMA+"."+ActividadEconomicaConstantesFunciones.TABLENAME;//+" as "+ActividadEconomicaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ActividadEconomicaConstantesFunciones.SCHEMA+"."+ActividadEconomicaConstantesFunciones.TABLENAME+".id,"+ActividadEconomicaConstantesFunciones.SCHEMA+"."+ActividadEconomicaConstantesFunciones.TABLENAME+".version_row,"+ActividadEconomicaConstantesFunciones.SCHEMA+"."+ActividadEconomicaConstantesFunciones.TABLENAME+".nombre_negocio from "+ActividadEconomicaConstantesFunciones.SCHEMA+"."+ActividadEconomicaConstantesFunciones.TABLENAME;//+" as "+ActividadEconomicaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ActividadEconomicaConstantesFunciones.SCHEMA+"."+ActividadEconomicaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_cliente=?,nombre_negocio=?,actividad=?,id_pais=?,id_ciudad=?,direccion=?,telefono=?,ingreso_neto=?,ingreso_bruto=?";
	
	public static String STOREPROCEDUREINSERT="call SP_ACTIVIDADECONOMICA_INSERT(?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_ACTIVIDADECONOMICA_UPDATE(?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_ACTIVIDADECONOMICA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_ACTIVIDADECONOMICA_SELECT(?,?)";
	
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
	
	
	protected ActividadEconomicaDataAccessAdditional actividadeconomicaDataAccessAdditional=null;
	
	public ActividadEconomicaDataAccessAdditional getActividadEconomicaDataAccessAdditional() {
		return this.actividadeconomicaDataAccessAdditional;
	}
	
	public void setActividadEconomicaDataAccessAdditional(ActividadEconomicaDataAccessAdditional actividadeconomicaDataAccessAdditional) {
		try {
			this.actividadeconomicaDataAccessAdditional=actividadeconomicaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ActividadEconomicaDataAccess() {
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
		ActividadEconomicaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ActividadEconomicaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ActividadEconomicaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setActividadEconomicaOriginal(ActividadEconomica actividadeconomica)throws Exception  {
		actividadeconomica.setActividadEconomicaOriginal((ActividadEconomica)actividadeconomica.clone());		
	}
	
	public void setActividadEconomicasOriginal(List<ActividadEconomica> actividadeconomicas)throws Exception  {
		
		for(ActividadEconomica actividadeconomica:actividadeconomicas){
			actividadeconomica.setActividadEconomicaOriginal((ActividadEconomica)actividadeconomica.clone());
		}
	}
	
	public static void setActividadEconomicaOriginalStatic(ActividadEconomica actividadeconomica)throws Exception  {
		actividadeconomica.setActividadEconomicaOriginal((ActividadEconomica)actividadeconomica.clone());		
	}
	
	public static void setActividadEconomicasOriginalStatic(List<ActividadEconomica> actividadeconomicas)throws Exception  {
		
		for(ActividadEconomica actividadeconomica:actividadeconomicas){
			actividadeconomica.setActividadEconomicaOriginal((ActividadEconomica)actividadeconomica.clone());
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
	
	public  ActividadEconomica getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		ActividadEconomica entity = new ActividadEconomica();		
		
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
	
	public  ActividadEconomica getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		ActividadEconomica entity = new ActividadEconomica();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ActividadEconomicaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ActividadEconomicaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Cartera.ActividadEconomica.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setActividadEconomicaOriginal(new ActividadEconomica());
      	    	entity=super.getEntity("",entity,resultSet,ActividadEconomicaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityActividadEconomica("",entity,resultSet); 
				
				//entity.setActividadEconomicaOriginal(super.getEntity("",entity.getActividadEconomicaOriginal(),resultSet,ActividadEconomicaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setActividadEconomicaOriginal(this.getEntityActividadEconomica("",entity.getActividadEconomicaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseActividadEconomica(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  ActividadEconomica getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ActividadEconomica entity = new ActividadEconomica();
				
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
	
	public  ActividadEconomica getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ActividadEconomica entity = new ActividadEconomica();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ActividadEconomicaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ActividadEconomicaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ActividadEconomicaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.ActividadEconomica.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setActividadEconomicaOriginal(new ActividadEconomica());
      	    	entity=super.getEntity("",entity,resultSet,ActividadEconomicaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityActividadEconomica("",entity,resultSet);    
				
				//entity.setActividadEconomicaOriginal(super.getEntity("",entity.getActividadEconomicaOriginal(),resultSet,ActividadEconomicaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setActividadEconomicaOriginal(this.getEntityActividadEconomica("",entity.getActividadEconomicaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseActividadEconomica(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //ActividadEconomica
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		ActividadEconomica entity = new ActividadEconomica();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ActividadEconomicaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ActividadEconomicaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ActividadEconomicaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.ActividadEconomica.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseActividadEconomica(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<ActividadEconomica> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ActividadEconomica> entities = new  ArrayList<ActividadEconomica>();
		ActividadEconomica entity = new ActividadEconomica();		  
		
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
	
	public  List<ActividadEconomica> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ActividadEconomica> entities = new  ArrayList<ActividadEconomica>();
		ActividadEconomica entity = new ActividadEconomica();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ActividadEconomicaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ActividadEconomicaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ActividadEconomicaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ActividadEconomica();
      	    	entity=super.getEntity("",entity,resultSet,ActividadEconomicaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityActividadEconomica("",entity,resultSet);
      	    	
				//entity.setActividadEconomicaOriginal( new ActividadEconomica());
      	    	//entity.setActividadEconomicaOriginal(super.getEntity("",entity.getActividadEconomicaOriginal(),resultSet,ActividadEconomicaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setActividadEconomicaOriginal(this.getEntityActividadEconomica("",entity.getActividadEconomicaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseActividadEconomicas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarActividadEconomica(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ActividadEconomica> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ActividadEconomica> entities = new  ArrayList<ActividadEconomica>();
		ActividadEconomica entity = new ActividadEconomica();		  
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
	
	public  List<ActividadEconomica> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ActividadEconomica> entities = new  ArrayList<ActividadEconomica>();
		ActividadEconomica entity = new ActividadEconomica();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ActividadEconomica();
				
				if(conMapGenerico) {
					entity.inicializarMapActividadEconomica();
					//entity.setMapActividadEconomica(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapActividadEconomicaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapActividadEconomica().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ActividadEconomicaDataAccess.ISWITHSCHEMA);         		
					entity=ActividadEconomicaDataAccess.getEntityActividadEconomica("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setActividadEconomicaOriginal( new ActividadEconomica());
					////entity.setActividadEconomicaOriginal(super.getEntity("",entity.getActividadEconomicaOriginal(),resultSet,ActividadEconomicaDataAccess.ISWITHSCHEMA));         		
					////entity.setActividadEconomicaOriginal(this.getEntityActividadEconomica("",entity.getActividadEconomicaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseActividadEconomicas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarActividadEconomica(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public ActividadEconomica getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ActividadEconomica entity = new ActividadEconomica();		  
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
	
	public  ActividadEconomica getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ActividadEconomica entity = new ActividadEconomica();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ActividadEconomica();
				
				if(conMapGenerico) {
					entity.inicializarMapActividadEconomica();
					//entity.setMapActividadEconomica(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapActividadEconomicaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapActividadEconomica().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ActividadEconomicaDataAccess.ISWITHSCHEMA);         		
					entity=ActividadEconomicaDataAccess.getEntityActividadEconomica("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setActividadEconomicaOriginal( new ActividadEconomica());
					////entity.setActividadEconomicaOriginal(super.getEntity("",entity.getActividadEconomicaOriginal(),resultSet,ActividadEconomicaDataAccess.ISWITHSCHEMA));         		
					////entity.setActividadEconomicaOriginal(this.getEntityActividadEconomica("",entity.getActividadEconomicaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseActividadEconomica(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarActividadEconomica(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ActividadEconomica getEntityActividadEconomica(String strPrefijo,ActividadEconomica entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = ActividadEconomica.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = ActividadEconomica.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ActividadEconomicaDataAccess.setFieldReflectionActividadEconomica(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasActividadEconomica=ActividadEconomicaConstantesFunciones.getTodosTiposColumnasActividadEconomica();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasActividadEconomica) {
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
							field = ActividadEconomica.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = ActividadEconomica.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ActividadEconomicaDataAccess.setFieldReflectionActividadEconomica(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionActividadEconomica(Field field,String strPrefijo,String sColumn,ActividadEconomica entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ActividadEconomicaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ActividadEconomicaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ActividadEconomicaConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ActividadEconomicaConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ActividadEconomicaConstantesFunciones.NOMBRENEGOCIO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ActividadEconomicaConstantesFunciones.ACTIVIDAD:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ActividadEconomicaConstantesFunciones.IDPAIS:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ActividadEconomicaConstantesFunciones.IDCIUDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ActividadEconomicaConstantesFunciones.DIRECCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ActividadEconomicaConstantesFunciones.TELEFONO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ActividadEconomicaConstantesFunciones.INGRESONETO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ActividadEconomicaConstantesFunciones.INGRESOBRUTO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ActividadEconomica>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<ActividadEconomica> entities = new  ArrayList<ActividadEconomica>();
		ActividadEconomica entity = new ActividadEconomica();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ActividadEconomicaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ActividadEconomicaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ActividadEconomicaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new ActividadEconomica();
					entity=super.getEntity("",entity,resultSet,ActividadEconomicaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityActividadEconomica("",entity,resultSet);
					
					//entity.setActividadEconomicaOriginal( new ActividadEconomica());
					//entity.setActividadEconomicaOriginal(super.getEntity("",entity.getActividadEconomicaOriginal(),resultSet,ActividadEconomicaDataAccess.ISWITHSCHEMA));         		
					//entity.setActividadEconomicaOriginal(this.getEntityActividadEconomica("",entity.getActividadEconomicaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseActividadEconomicas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarActividadEconomica(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ActividadEconomica>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<ActividadEconomica> entities = new  ArrayList<ActividadEconomica>();
		ActividadEconomica entity = new ActividadEconomica();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ActividadEconomicaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ActividadEconomicaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ActividadEconomicaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<ActividadEconomica> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ActividadEconomica> entities = new  ArrayList<ActividadEconomica>();
		ActividadEconomica entity = new ActividadEconomica();		  
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
	
	public  List<ActividadEconomica> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ActividadEconomica> entities = new  ArrayList<ActividadEconomica>();
		ActividadEconomica entity = new ActividadEconomica();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ActividadEconomica();
      	    	entity=super.getEntity("",entity,resultSet,ActividadEconomicaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityActividadEconomica("",entity,resultSet);
      	    	
				//entity.setActividadEconomicaOriginal( new ActividadEconomica());
      	    	//entity.setActividadEconomicaOriginal(super.getEntity("",entity.getActividadEconomicaOriginal(),resultSet,ActividadEconomicaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setActividadEconomicaOriginal(this.getEntityActividadEconomica("",entity.getActividadEconomicaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseActividadEconomicas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarActividadEconomica(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ActividadEconomica> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ActividadEconomica> entities = new  ArrayList<ActividadEconomica>();
		ActividadEconomica entity = new ActividadEconomica();		  
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
	
	public  List<ActividadEconomica> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ActividadEconomica> entities = new  ArrayList<ActividadEconomica>();
		ActividadEconomica entity = new ActividadEconomica();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ActividadEconomica();
      	    	entity=super.getEntity("",entity,resultSet,ActividadEconomicaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityActividadEconomica("",entity,resultSet);
      	    	
				//entity.setActividadEconomicaOriginal( new ActividadEconomica());
      	    	//entity.setActividadEconomicaOriginal(super.getEntity("",entity.getActividadEconomicaOriginal(),resultSet,ActividadEconomicaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setActividadEconomicaOriginal(this.getEntityActividadEconomica("",entity.getActividadEconomicaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseActividadEconomicas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public ActividadEconomica getEntityActividadEconomica(String strPrefijo,ActividadEconomica entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+ActividadEconomicaConstantesFunciones.IDEMPRESA));
				entity.setid_cliente(resultSet.getLong(strPrefijo+ActividadEconomicaConstantesFunciones.IDCLIENTE));
				entity.setnombre_negocio(resultSet.getString(strPrefijo+ActividadEconomicaConstantesFunciones.NOMBRENEGOCIO));
				entity.setactividad(resultSet.getString(strPrefijo+ActividadEconomicaConstantesFunciones.ACTIVIDAD));
				entity.setid_pais(resultSet.getLong(strPrefijo+ActividadEconomicaConstantesFunciones.IDPAIS));
				entity.setid_ciudad(resultSet.getLong(strPrefijo+ActividadEconomicaConstantesFunciones.IDCIUDAD));
				entity.setdireccion(resultSet.getString(strPrefijo+ActividadEconomicaConstantesFunciones.DIRECCION));
				entity.settelefono(resultSet.getString(strPrefijo+ActividadEconomicaConstantesFunciones.TELEFONO));
				entity.setingreso_neto(resultSet.getDouble(strPrefijo+ActividadEconomicaConstantesFunciones.INGRESONETO));
				entity.setingreso_bruto(resultSet.getDouble(strPrefijo+ActividadEconomicaConstantesFunciones.INGRESOBRUTO));
			} else {
				entity.setnombre_negocio(resultSet.getString(strPrefijo+ActividadEconomicaConstantesFunciones.NOMBRENEGOCIO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowActividadEconomica(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(ActividadEconomica entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ActividadEconomicaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ActividadEconomicaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ActividadEconomicaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ActividadEconomicaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ActividadEconomicaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ActividadEconomicaDataAccess.TABLENAME,ActividadEconomicaDataAccess.ISWITHSTOREPROCEDURES);
			
			ActividadEconomicaDataAccess.setActividadEconomicaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,ActividadEconomica relactividadeconomica)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relactividadeconomica.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Cliente getCliente(Connexion connexion,ActividadEconomica relactividadeconomica)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,relactividadeconomica.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public Pais getPais(Connexion connexion,ActividadEconomica relactividadeconomica)throws SQLException,Exception {

		Pais pais= new Pais();

		try {
			PaisDataAccess paisDataAccess=new PaisDataAccess();

			paisDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			paisDataAccess.setConnexionType(this.connexionType);
			paisDataAccess.setParameterDbType(this.parameterDbType);

			pais=paisDataAccess.getEntity(connexion,relactividadeconomica.getid_pais());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pais;

	}

	public Ciudad getCiudad(Connexion connexion,ActividadEconomica relactividadeconomica)throws SQLException,Exception {

		Ciudad ciudad= new Ciudad();

		try {
			CiudadDataAccess ciudadDataAccess=new CiudadDataAccess();

			ciudadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ciudadDataAccess.setConnexionType(this.connexionType);
			ciudadDataAccess.setParameterDbType(this.parameterDbType);

			ciudad=ciudadDataAccess.getEntity(connexion,relactividadeconomica.getid_ciudad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ciudad;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,ActividadEconomica actividadeconomica) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!actividadeconomica.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(actividadeconomica.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_cliente.setValue(actividadeconomica.getid_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre_negocio=new ParameterValue<String>();
					parameterMaintenanceValuenombre_negocio.setValue(actividadeconomica.getnombre_negocio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre_negocio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueactividad=new ParameterValue<String>();
					parameterMaintenanceValueactividad.setValue(actividadeconomica.getactividad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueactividad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_pais=new ParameterValue<Long>();
					parameterMaintenanceValueid_pais.setValue(actividadeconomica.getid_pais());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_pais);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ciudad=new ParameterValue<Long>();
					parameterMaintenanceValueid_ciudad.setValue(actividadeconomica.getid_ciudad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ciudad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedireccion=new ParameterValue<String>();
					parameterMaintenanceValuedireccion.setValue(actividadeconomica.getdireccion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedireccion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuetelefono=new ParameterValue<String>();
					parameterMaintenanceValuetelefono.setValue(actividadeconomica.gettelefono());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetelefono);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueingreso_neto=new ParameterValue<Double>();
					parameterMaintenanceValueingreso_neto.setValue(actividadeconomica.getingreso_neto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueingreso_neto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueingreso_bruto=new ParameterValue<Double>();
					parameterMaintenanceValueingreso_bruto.setValue(actividadeconomica.getingreso_bruto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueingreso_bruto);
					parametersTemp.add(parameterMaintenance);
					
						if(!actividadeconomica.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(actividadeconomica.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(actividadeconomica.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(actividadeconomica.getId());
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
	
	public void setIsNewIsChangedFalseActividadEconomica(ActividadEconomica actividadeconomica)throws Exception  {		
		actividadeconomica.setIsNew(false);
		actividadeconomica.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseActividadEconomicas(List<ActividadEconomica> actividadeconomicas)throws Exception  {				
		for(ActividadEconomica actividadeconomica:actividadeconomicas) {
			actividadeconomica.setIsNew(false);
			actividadeconomica.setIsChanged(false);
		}
	}
	
	public void generarExportarActividadEconomica(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
