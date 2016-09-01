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
package com.bydan.erp.sris.business.dataaccess;

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

import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.sris.util.*;//PeriodoDeclaraConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class PeriodoDeclaraDataAccess extends  PeriodoDeclaraDataAccessAdditional{ //PeriodoDeclaraDataAccessAdditional,DataAccessHelper<PeriodoDeclara>
	//static Logger logger = Logger.getLogger(PeriodoDeclaraDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="periodo_declara";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+PeriodoDeclaraConstantesFunciones.SCHEMA+"."+PeriodoDeclaraConstantesFunciones.TABLENAME+"(version_row,codigo,id_anio,id_mes,fecha,esta_activo)values(current_timestamp,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+PeriodoDeclaraConstantesFunciones.SCHEMA+"."+PeriodoDeclaraConstantesFunciones.TABLENAME+" set version_row=current_timestamp,codigo=?,id_anio=?,id_mes=?,fecha=?,esta_activo=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+PeriodoDeclaraConstantesFunciones.SCHEMA+"."+PeriodoDeclaraConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select periododeclara from "+PeriodoDeclaraConstantesFunciones.SPERSISTENCENAME+" periododeclara";
	public static String QUERYSELECTNATIVE="select "+PeriodoDeclaraConstantesFunciones.SCHEMA+"."+PeriodoDeclaraConstantesFunciones.TABLENAME+".id,"+PeriodoDeclaraConstantesFunciones.SCHEMA+"."+PeriodoDeclaraConstantesFunciones.TABLENAME+".version_row,"+PeriodoDeclaraConstantesFunciones.SCHEMA+"."+PeriodoDeclaraConstantesFunciones.TABLENAME+".codigo,"+PeriodoDeclaraConstantesFunciones.SCHEMA+"."+PeriodoDeclaraConstantesFunciones.TABLENAME+".id_anio,"+PeriodoDeclaraConstantesFunciones.SCHEMA+"."+PeriodoDeclaraConstantesFunciones.TABLENAME+".id_mes,"+PeriodoDeclaraConstantesFunciones.SCHEMA+"."+PeriodoDeclaraConstantesFunciones.TABLENAME+".fecha,"+PeriodoDeclaraConstantesFunciones.SCHEMA+"."+PeriodoDeclaraConstantesFunciones.TABLENAME+".esta_activo from "+PeriodoDeclaraConstantesFunciones.SCHEMA+"."+PeriodoDeclaraConstantesFunciones.TABLENAME;//+" as "+PeriodoDeclaraConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+PeriodoDeclaraConstantesFunciones.SCHEMA+"."+PeriodoDeclaraConstantesFunciones.TABLENAME+".id,"+PeriodoDeclaraConstantesFunciones.SCHEMA+"."+PeriodoDeclaraConstantesFunciones.TABLENAME+".version_row,"+PeriodoDeclaraConstantesFunciones.SCHEMA+"."+PeriodoDeclaraConstantesFunciones.TABLENAME+".codigo,"+PeriodoDeclaraConstantesFunciones.SCHEMA+"."+PeriodoDeclaraConstantesFunciones.TABLENAME+".id_anio,"+PeriodoDeclaraConstantesFunciones.SCHEMA+"."+PeriodoDeclaraConstantesFunciones.TABLENAME+".id_mes from "+PeriodoDeclaraConstantesFunciones.SCHEMA+"."+PeriodoDeclaraConstantesFunciones.TABLENAME;//+" as "+PeriodoDeclaraConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+PeriodoDeclaraConstantesFunciones.SCHEMA+"."+PeriodoDeclaraConstantesFunciones.TABLENAME+" set version_row=current_timestamp,codigo=?,id_anio=?,id_mes=?,fecha=?,esta_activo=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PERIODODECLARA_INSERT(?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PERIODODECLARA_UPDATE(?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PERIODODECLARA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PERIODODECLARA_SELECT(?,?)";
	
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
	
	
	protected PeriodoDeclaraDataAccessAdditional periododeclaraDataAccessAdditional=null;
	
	public PeriodoDeclaraDataAccessAdditional getPeriodoDeclaraDataAccessAdditional() {
		return this.periododeclaraDataAccessAdditional;
	}
	
	public void setPeriodoDeclaraDataAccessAdditional(PeriodoDeclaraDataAccessAdditional periododeclaraDataAccessAdditional) {
		try {
			this.periododeclaraDataAccessAdditional=periododeclaraDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public PeriodoDeclaraDataAccess() {
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
		PeriodoDeclaraDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		PeriodoDeclaraDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		PeriodoDeclaraDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setPeriodoDeclaraOriginal(PeriodoDeclara periododeclara)throws Exception  {
		periododeclara.setPeriodoDeclaraOriginal((PeriodoDeclara)periododeclara.clone());		
	}
	
	public void setPeriodoDeclarasOriginal(List<PeriodoDeclara> periododeclaras)throws Exception  {
		
		for(PeriodoDeclara periododeclara:periododeclaras){
			periododeclara.setPeriodoDeclaraOriginal((PeriodoDeclara)periododeclara.clone());
		}
	}
	
	public static void setPeriodoDeclaraOriginalStatic(PeriodoDeclara periododeclara)throws Exception  {
		periododeclara.setPeriodoDeclaraOriginal((PeriodoDeclara)periododeclara.clone());		
	}
	
	public static void setPeriodoDeclarasOriginalStatic(List<PeriodoDeclara> periododeclaras)throws Exception  {
		
		for(PeriodoDeclara periododeclara:periododeclaras){
			periododeclara.setPeriodoDeclaraOriginal((PeriodoDeclara)periododeclara.clone());
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
	
	public  PeriodoDeclara getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		PeriodoDeclara entity = new PeriodoDeclara();		
		
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
	
	public  PeriodoDeclara getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		PeriodoDeclara entity = new PeriodoDeclara();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PeriodoDeclaraDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PeriodoDeclaraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Sris.PeriodoDeclara.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setPeriodoDeclaraOriginal(new PeriodoDeclara());
      	    	entity=super.getEntity("",entity,resultSet,PeriodoDeclaraDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPeriodoDeclara("",entity,resultSet); 
				
				//entity.setPeriodoDeclaraOriginal(super.getEntity("",entity.getPeriodoDeclaraOriginal(),resultSet,PeriodoDeclaraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPeriodoDeclaraOriginal(this.getEntityPeriodoDeclara("",entity.getPeriodoDeclaraOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalsePeriodoDeclara(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  PeriodoDeclara getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		PeriodoDeclara entity = new PeriodoDeclara();
				
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
	
	public  PeriodoDeclara getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		PeriodoDeclara entity = new PeriodoDeclara();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PeriodoDeclaraDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PeriodoDeclaraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PeriodoDeclaraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Sris.PeriodoDeclara.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setPeriodoDeclaraOriginal(new PeriodoDeclara());
      	    	entity=super.getEntity("",entity,resultSet,PeriodoDeclaraDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPeriodoDeclara("",entity,resultSet);    
				
				//entity.setPeriodoDeclaraOriginal(super.getEntity("",entity.getPeriodoDeclaraOriginal(),resultSet,PeriodoDeclaraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPeriodoDeclaraOriginal(this.getEntityPeriodoDeclara("",entity.getPeriodoDeclaraOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalsePeriodoDeclara(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //PeriodoDeclara
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		PeriodoDeclara entity = new PeriodoDeclara();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PeriodoDeclaraDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PeriodoDeclaraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PeriodoDeclaraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Sris.PeriodoDeclara.isActive=1
        	 
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
				//this.setIsNewIsChangedFalsePeriodoDeclara(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<PeriodoDeclara> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<PeriodoDeclara> entities = new  ArrayList<PeriodoDeclara>();
		PeriodoDeclara entity = new PeriodoDeclara();		  
		
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
	
	public  List<PeriodoDeclara> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<PeriodoDeclara> entities = new  ArrayList<PeriodoDeclara>();
		PeriodoDeclara entity = new PeriodoDeclara();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=PeriodoDeclaraDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PeriodoDeclaraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PeriodoDeclaraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PeriodoDeclara();
      	    	entity=super.getEntity("",entity,resultSet,PeriodoDeclaraDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPeriodoDeclara("",entity,resultSet);
      	    	
				//entity.setPeriodoDeclaraOriginal( new PeriodoDeclara());
      	    	//entity.setPeriodoDeclaraOriginal(super.getEntity("",entity.getPeriodoDeclaraOriginal(),resultSet,PeriodoDeclaraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPeriodoDeclaraOriginal(this.getEntityPeriodoDeclara("",entity.getPeriodoDeclaraOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePeriodoDeclaras(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPeriodoDeclara(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<PeriodoDeclara> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<PeriodoDeclara> entities = new  ArrayList<PeriodoDeclara>();
		PeriodoDeclara entity = new PeriodoDeclara();		  
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
	
	public  List<PeriodoDeclara> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<PeriodoDeclara> entities = new  ArrayList<PeriodoDeclara>();
		PeriodoDeclara entity = new PeriodoDeclara();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PeriodoDeclara();
				
				if(conMapGenerico) {
					entity.inicializarMapPeriodoDeclara();
					//entity.setMapPeriodoDeclara(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapPeriodoDeclaraValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPeriodoDeclara().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PeriodoDeclaraDataAccess.ISWITHSCHEMA);         		
					entity=PeriodoDeclaraDataAccess.getEntityPeriodoDeclara("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setPeriodoDeclaraOriginal( new PeriodoDeclara());
					////entity.setPeriodoDeclaraOriginal(super.getEntity("",entity.getPeriodoDeclaraOriginal(),resultSet,PeriodoDeclaraDataAccess.ISWITHSCHEMA));         		
					////entity.setPeriodoDeclaraOriginal(this.getEntityPeriodoDeclara("",entity.getPeriodoDeclaraOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePeriodoDeclaras(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPeriodoDeclara(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public PeriodoDeclara getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		PeriodoDeclara entity = new PeriodoDeclara();		  
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
	
	public  PeriodoDeclara getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		PeriodoDeclara entity = new PeriodoDeclara();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PeriodoDeclara();
				
				if(conMapGenerico) {
					entity.inicializarMapPeriodoDeclara();
					//entity.setMapPeriodoDeclara(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapPeriodoDeclaraValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPeriodoDeclara().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PeriodoDeclaraDataAccess.ISWITHSCHEMA);         		
					entity=PeriodoDeclaraDataAccess.getEntityPeriodoDeclara("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setPeriodoDeclaraOriginal( new PeriodoDeclara());
					////entity.setPeriodoDeclaraOriginal(super.getEntity("",entity.getPeriodoDeclaraOriginal(),resultSet,PeriodoDeclaraDataAccess.ISWITHSCHEMA));         		
					////entity.setPeriodoDeclaraOriginal(this.getEntityPeriodoDeclara("",entity.getPeriodoDeclaraOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalsePeriodoDeclara(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPeriodoDeclara(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static PeriodoDeclara getEntityPeriodoDeclara(String strPrefijo,PeriodoDeclara entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = PeriodoDeclara.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = PeriodoDeclara.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					PeriodoDeclaraDataAccess.setFieldReflectionPeriodoDeclara(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasPeriodoDeclara=PeriodoDeclaraConstantesFunciones.getTodosTiposColumnasPeriodoDeclara();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasPeriodoDeclara) {
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
							field = PeriodoDeclara.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = PeriodoDeclara.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						PeriodoDeclaraDataAccess.setFieldReflectionPeriodoDeclara(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionPeriodoDeclara(Field field,String strPrefijo,String sColumn,PeriodoDeclara entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case PeriodoDeclaraConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PeriodoDeclaraConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PeriodoDeclaraConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PeriodoDeclaraConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PeriodoDeclaraConstantesFunciones.IDMES:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PeriodoDeclaraConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case PeriodoDeclaraConstantesFunciones.ESTAACTIVO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<PeriodoDeclara>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<PeriodoDeclara> entities = new  ArrayList<PeriodoDeclara>();
		PeriodoDeclara entity = new PeriodoDeclara();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PeriodoDeclaraDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PeriodoDeclaraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PeriodoDeclaraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new PeriodoDeclara();
					entity=super.getEntity("",entity,resultSet,PeriodoDeclaraDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityPeriodoDeclara("",entity,resultSet);
					
					//entity.setPeriodoDeclaraOriginal( new PeriodoDeclara());
					//entity.setPeriodoDeclaraOriginal(super.getEntity("",entity.getPeriodoDeclaraOriginal(),resultSet,PeriodoDeclaraDataAccess.ISWITHSCHEMA));         		
					//entity.setPeriodoDeclaraOriginal(this.getEntityPeriodoDeclara("",entity.getPeriodoDeclaraOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalsePeriodoDeclaras(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPeriodoDeclara(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<PeriodoDeclara>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<PeriodoDeclara> entities = new  ArrayList<PeriodoDeclara>();
		PeriodoDeclara entity = new PeriodoDeclara();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PeriodoDeclaraDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PeriodoDeclaraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PeriodoDeclaraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<PeriodoDeclara> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PeriodoDeclara> entities = new  ArrayList<PeriodoDeclara>();
		PeriodoDeclara entity = new PeriodoDeclara();		  
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
	
	public  List<PeriodoDeclara> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PeriodoDeclara> entities = new  ArrayList<PeriodoDeclara>();
		PeriodoDeclara entity = new PeriodoDeclara();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PeriodoDeclara();
      	    	entity=super.getEntity("",entity,resultSet,PeriodoDeclaraDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPeriodoDeclara("",entity,resultSet);
      	    	
				//entity.setPeriodoDeclaraOriginal( new PeriodoDeclara());
      	    	//entity.setPeriodoDeclaraOriginal(super.getEntity("",entity.getPeriodoDeclaraOriginal(),resultSet,PeriodoDeclaraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPeriodoDeclaraOriginal(this.getEntityPeriodoDeclara("",entity.getPeriodoDeclaraOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalsePeriodoDeclaras(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPeriodoDeclara(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<PeriodoDeclara> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PeriodoDeclara> entities = new  ArrayList<PeriodoDeclara>();
		PeriodoDeclara entity = new PeriodoDeclara();		  
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
	
	public  List<PeriodoDeclara> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PeriodoDeclara> entities = new  ArrayList<PeriodoDeclara>();
		PeriodoDeclara entity = new PeriodoDeclara();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PeriodoDeclara();
      	    	entity=super.getEntity("",entity,resultSet,PeriodoDeclaraDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPeriodoDeclara("",entity,resultSet);
      	    	
				//entity.setPeriodoDeclaraOriginal( new PeriodoDeclara());
      	    	//entity.setPeriodoDeclaraOriginal(super.getEntity("",entity.getPeriodoDeclaraOriginal(),resultSet,PeriodoDeclaraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPeriodoDeclaraOriginal(this.getEntityPeriodoDeclara("",entity.getPeriodoDeclaraOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePeriodoDeclaras(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public PeriodoDeclara getEntityPeriodoDeclara(String strPrefijo,PeriodoDeclara entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setcodigo(resultSet.getString(strPrefijo+PeriodoDeclaraConstantesFunciones.CODIGO));
				entity.setid_anio(resultSet.getLong(strPrefijo+PeriodoDeclaraConstantesFunciones.IDANIO));
				entity.setid_mes(resultSet.getLong(strPrefijo+PeriodoDeclaraConstantesFunciones.IDMES));
				entity.setfecha(new Date(resultSet.getDate(strPrefijo+PeriodoDeclaraConstantesFunciones.FECHA).getTime()));
				entity.setesta_activo(resultSet.getBoolean(strPrefijo+PeriodoDeclaraConstantesFunciones.ESTAACTIVO));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+PeriodoDeclaraConstantesFunciones.CODIGO));entity.setid_anio(resultSet.getLong(strPrefijo+PeriodoDeclaraConstantesFunciones.IDANIO));entity.setid_mes(resultSet.getLong(strPrefijo+PeriodoDeclaraConstantesFunciones.IDMES));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowPeriodoDeclara(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(PeriodoDeclara entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=PeriodoDeclaraDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=PeriodoDeclaraDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=PeriodoDeclaraDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=PeriodoDeclaraDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(PeriodoDeclaraConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,PeriodoDeclaraDataAccess.TABLENAME,PeriodoDeclaraDataAccess.ISWITHSTOREPROCEDURES);
			
			PeriodoDeclaraDataAccess.setPeriodoDeclaraOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Anio getAnio(Connexion connexion,PeriodoDeclara relperiododeclara)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);

			anio=anioDataAccess.getEntity(connexion,relperiododeclara.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Mes getMes(Connexion connexion,PeriodoDeclara relperiododeclara)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,relperiododeclara.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}


		
		public List<TransaccionLocal> getTransaccionLocals(Connexion connexion,PeriodoDeclara periododeclara)throws SQLException,Exception {

		List<TransaccionLocal> transaccionlocals= new ArrayList<TransaccionLocal>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+PeriodoDeclaraConstantesFunciones.SCHEMA+".periodo_declara ON "+TransaccionLocalConstantesFunciones.SCHEMA+".transaccion_local.id_periodo_declara="+PeriodoDeclaraConstantesFunciones.SCHEMA+".periodo_declara.id WHERE "+PeriodoDeclaraConstantesFunciones.SCHEMA+".periodo_declara.id="+String.valueOf(periododeclara.getId());
			} else {
				sQuery=" INNER JOIN transaccionlocal.PeriodoDeclara WHERE transaccionlocal.PeriodoDeclara.id="+String.valueOf(periododeclara.getId());

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

	public List<RetencionVenta> getRetencionVentas(Connexion connexion,PeriodoDeclara periododeclara)throws SQLException,Exception {

		List<RetencionVenta> retencionventas= new ArrayList<RetencionVenta>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+PeriodoDeclaraConstantesFunciones.SCHEMA+".periodo_declara ON "+RetencionVentaConstantesFunciones.SCHEMA+".retencion_venta.id_periodo_declara="+PeriodoDeclaraConstantesFunciones.SCHEMA+".periodo_declara.id WHERE "+PeriodoDeclaraConstantesFunciones.SCHEMA+".periodo_declara.id="+String.valueOf(periododeclara.getId());
			} else {
				sQuery=" INNER JOIN retencionventa.PeriodoDeclara WHERE retencionventa.PeriodoDeclara.id="+String.valueOf(periododeclara.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			RetencionVentaDataAccess retencionventaDataAccess=new RetencionVentaDataAccess();

			retencionventaDataAccess.setConnexionType(this.connexionType);
			retencionventaDataAccess.setParameterDbType(this.parameterDbType);
			retencionventas=retencionventaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return retencionventas;

	}

	public List<FacturaDiario> getFacturaDiarios(Connexion connexion,PeriodoDeclara periododeclara)throws SQLException,Exception {

		List<FacturaDiario> facturadiarios= new ArrayList<FacturaDiario>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+PeriodoDeclaraConstantesFunciones.SCHEMA+".periodo_declara ON "+FacturaDiarioConstantesFunciones.SCHEMA+".factura_diario.id_periodo_declara="+PeriodoDeclaraConstantesFunciones.SCHEMA+".periodo_declara.id WHERE "+PeriodoDeclaraConstantesFunciones.SCHEMA+".periodo_declara.id="+String.valueOf(periododeclara.getId());
			} else {
				sQuery=" INNER JOIN facturadiario.PeriodoDeclara WHERE facturadiario.PeriodoDeclara.id="+String.valueOf(periododeclara.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			FacturaDiarioDataAccess facturadiarioDataAccess=new FacturaDiarioDataAccess();

			facturadiarioDataAccess.setConnexionType(this.connexionType);
			facturadiarioDataAccess.setParameterDbType(this.parameterDbType);
			facturadiarios=facturadiarioDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return facturadiarios;

	}

	public List<DocumentoAnulado> getDocumentoAnulados(Connexion connexion,PeriodoDeclara periododeclara)throws SQLException,Exception {

		List<DocumentoAnulado> documentoanulados= new ArrayList<DocumentoAnulado>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+PeriodoDeclaraConstantesFunciones.SCHEMA+".periodo_declara ON "+DocumentoAnuladoConstantesFunciones.SCHEMA+".documento_anulado.id_periodo_declara="+PeriodoDeclaraConstantesFunciones.SCHEMA+".periodo_declara.id WHERE "+PeriodoDeclaraConstantesFunciones.SCHEMA+".periodo_declara.id="+String.valueOf(periododeclara.getId());
			} else {
				sQuery=" INNER JOIN documentoanulado.PeriodoDeclara WHERE documentoanulado.PeriodoDeclara.id="+String.valueOf(periododeclara.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DocumentoAnuladoDataAccess documentoanuladoDataAccess=new DocumentoAnuladoDataAccess();

			documentoanuladoDataAccess.setConnexionType(this.connexionType);
			documentoanuladoDataAccess.setParameterDbType(this.parameterDbType);
			documentoanulados=documentoanuladoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return documentoanulados;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,PeriodoDeclara periododeclara) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!periododeclara.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(periododeclara.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_anio=new ParameterValue<Long>();
					parameterMaintenanceValueid_anio.setValue(periododeclara.getid_anio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_anio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes.setValue(periododeclara.getid_mes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha=new ParameterValue<Date>();
					parameterMaintenanceValuefecha.setValue(periododeclara.getfecha());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValueesta_activo=new ParameterValue<Boolean>();
					parameterMaintenanceValueesta_activo.setValue(periododeclara.getesta_activo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueesta_activo);
					parametersTemp.add(parameterMaintenance);
					
						if(!periododeclara.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(periododeclara.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(periododeclara.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(periododeclara.getId());
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
	
	public void setIsNewIsChangedFalsePeriodoDeclara(PeriodoDeclara periododeclara)throws Exception  {		
		periododeclara.setIsNew(false);
		periododeclara.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalsePeriodoDeclaras(List<PeriodoDeclara> periododeclaras)throws Exception  {				
		for(PeriodoDeclara periododeclara:periododeclaras) {
			periododeclara.setIsNew(false);
			periododeclara.setIsChanged(false);
		}
	}
	
	public void generarExportarPeriodoDeclara(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
