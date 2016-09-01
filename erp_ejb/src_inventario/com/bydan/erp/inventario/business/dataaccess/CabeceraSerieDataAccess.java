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
package com.bydan.erp.inventario.business.dataaccess;

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

import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.inventario.util.*;//CabeceraSerieConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class CabeceraSerieDataAccess extends  CabeceraSerieDataAccessAdditional{ //CabeceraSerieDataAccessAdditional,DataAccessHelper<CabeceraSerie>
	//static Logger logger = Logger.getLogger(CabeceraSerieDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="cabecera_serie";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+CabeceraSerieConstantesFunciones.SCHEMA+"."+CabeceraSerieConstantesFunciones.TABLENAME+"(version_row,id_empresa,nombre,formula,con_formula,con_totalizar)values(current_timestamp,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+CabeceraSerieConstantesFunciones.SCHEMA+"."+CabeceraSerieConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,nombre=?,formula=?,con_formula=?,con_totalizar=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+CabeceraSerieConstantesFunciones.SCHEMA+"."+CabeceraSerieConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select cabeceraserie from "+CabeceraSerieConstantesFunciones.SPERSISTENCENAME+" cabeceraserie";
	public static String QUERYSELECTNATIVE="select "+CabeceraSerieConstantesFunciones.SCHEMA+"."+CabeceraSerieConstantesFunciones.TABLENAME+".id,"+CabeceraSerieConstantesFunciones.SCHEMA+"."+CabeceraSerieConstantesFunciones.TABLENAME+".version_row,"+CabeceraSerieConstantesFunciones.SCHEMA+"."+CabeceraSerieConstantesFunciones.TABLENAME+".id_empresa,"+CabeceraSerieConstantesFunciones.SCHEMA+"."+CabeceraSerieConstantesFunciones.TABLENAME+".nombre,"+CabeceraSerieConstantesFunciones.SCHEMA+"."+CabeceraSerieConstantesFunciones.TABLENAME+".formula,"+CabeceraSerieConstantesFunciones.SCHEMA+"."+CabeceraSerieConstantesFunciones.TABLENAME+".con_formula,"+CabeceraSerieConstantesFunciones.SCHEMA+"."+CabeceraSerieConstantesFunciones.TABLENAME+".con_totalizar from "+CabeceraSerieConstantesFunciones.SCHEMA+"."+CabeceraSerieConstantesFunciones.TABLENAME;//+" as "+CabeceraSerieConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+CabeceraSerieConstantesFunciones.SCHEMA+"."+CabeceraSerieConstantesFunciones.TABLENAME+".id,"+CabeceraSerieConstantesFunciones.SCHEMA+"."+CabeceraSerieConstantesFunciones.TABLENAME+".version_row,"+CabeceraSerieConstantesFunciones.SCHEMA+"."+CabeceraSerieConstantesFunciones.TABLENAME+".nombre from "+CabeceraSerieConstantesFunciones.SCHEMA+"."+CabeceraSerieConstantesFunciones.TABLENAME;//+" as "+CabeceraSerieConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+CabeceraSerieConstantesFunciones.SCHEMA+"."+CabeceraSerieConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,nombre=?,formula=?,con_formula=?,con_totalizar=?";
	
	public static String STOREPROCEDUREINSERT="call SP_CABECERASERIE_INSERT(?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_CABECERASERIE_UPDATE(?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_CABECERASERIE_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_CABECERASERIE_SELECT(?,?)";
	
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
	
	
	protected CabeceraSerieDataAccessAdditional cabeceraserieDataAccessAdditional=null;
	
	public CabeceraSerieDataAccessAdditional getCabeceraSerieDataAccessAdditional() {
		return this.cabeceraserieDataAccessAdditional;
	}
	
	public void setCabeceraSerieDataAccessAdditional(CabeceraSerieDataAccessAdditional cabeceraserieDataAccessAdditional) {
		try {
			this.cabeceraserieDataAccessAdditional=cabeceraserieDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public CabeceraSerieDataAccess() {
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
		CabeceraSerieDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		CabeceraSerieDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		CabeceraSerieDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setCabeceraSerieOriginal(CabeceraSerie cabeceraserie)throws Exception  {
		cabeceraserie.setCabeceraSerieOriginal((CabeceraSerie)cabeceraserie.clone());		
	}
	
	public void setCabeceraSeriesOriginal(List<CabeceraSerie> cabeceraseries)throws Exception  {
		
		for(CabeceraSerie cabeceraserie:cabeceraseries){
			cabeceraserie.setCabeceraSerieOriginal((CabeceraSerie)cabeceraserie.clone());
		}
	}
	
	public static void setCabeceraSerieOriginalStatic(CabeceraSerie cabeceraserie)throws Exception  {
		cabeceraserie.setCabeceraSerieOriginal((CabeceraSerie)cabeceraserie.clone());		
	}
	
	public static void setCabeceraSeriesOriginalStatic(List<CabeceraSerie> cabeceraseries)throws Exception  {
		
		for(CabeceraSerie cabeceraserie:cabeceraseries){
			cabeceraserie.setCabeceraSerieOriginal((CabeceraSerie)cabeceraserie.clone());
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
	
	public  CabeceraSerie getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		CabeceraSerie entity = new CabeceraSerie();		
		
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
	
	public  CabeceraSerie getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		CabeceraSerie entity = new CabeceraSerie();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=CabeceraSerieDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CabeceraSerieDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.CabeceraSerie.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setCabeceraSerieOriginal(new CabeceraSerie());
      	    	entity=super.getEntity("",entity,resultSet,CabeceraSerieDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityCabeceraSerie("",entity,resultSet); 
				
				//entity.setCabeceraSerieOriginal(super.getEntity("",entity.getCabeceraSerieOriginal(),resultSet,CabeceraSerieDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCabeceraSerieOriginal(this.getEntityCabeceraSerie("",entity.getCabeceraSerieOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseCabeceraSerie(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  CabeceraSerie getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		CabeceraSerie entity = new CabeceraSerie();
				
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
	
	public  CabeceraSerie getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		CabeceraSerie entity = new CabeceraSerie();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=CabeceraSerieDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CabeceraSerieDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CabeceraSerieDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.CabeceraSerie.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setCabeceraSerieOriginal(new CabeceraSerie());
      	    	entity=super.getEntity("",entity,resultSet,CabeceraSerieDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityCabeceraSerie("",entity,resultSet);    
				
				//entity.setCabeceraSerieOriginal(super.getEntity("",entity.getCabeceraSerieOriginal(),resultSet,CabeceraSerieDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCabeceraSerieOriginal(this.getEntityCabeceraSerie("",entity.getCabeceraSerieOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseCabeceraSerie(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //CabeceraSerie
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		CabeceraSerie entity = new CabeceraSerie();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CabeceraSerieDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CabeceraSerieDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CabeceraSerieDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.CabeceraSerie.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseCabeceraSerie(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<CabeceraSerie> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<CabeceraSerie> entities = new  ArrayList<CabeceraSerie>();
		CabeceraSerie entity = new CabeceraSerie();		  
		
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
	
	public  List<CabeceraSerie> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<CabeceraSerie> entities = new  ArrayList<CabeceraSerie>();
		CabeceraSerie entity = new CabeceraSerie();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=CabeceraSerieDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CabeceraSerieDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CabeceraSerieDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CabeceraSerie();
      	    	entity=super.getEntity("",entity,resultSet,CabeceraSerieDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCabeceraSerie("",entity,resultSet);
      	    	
				//entity.setCabeceraSerieOriginal( new CabeceraSerie());
      	    	//entity.setCabeceraSerieOriginal(super.getEntity("",entity.getCabeceraSerieOriginal(),resultSet,CabeceraSerieDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCabeceraSerieOriginal(this.getEntityCabeceraSerie("",entity.getCabeceraSerieOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCabeceraSeries(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCabeceraSerie(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<CabeceraSerie> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<CabeceraSerie> entities = new  ArrayList<CabeceraSerie>();
		CabeceraSerie entity = new CabeceraSerie();		  
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
	
	public  List<CabeceraSerie> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<CabeceraSerie> entities = new  ArrayList<CabeceraSerie>();
		CabeceraSerie entity = new CabeceraSerie();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CabeceraSerie();
				
				if(conMapGenerico) {
					entity.inicializarMapCabeceraSerie();
					//entity.setMapCabeceraSerie(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapCabeceraSerieValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapCabeceraSerie().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CabeceraSerieDataAccess.ISWITHSCHEMA);         		
					entity=CabeceraSerieDataAccess.getEntityCabeceraSerie("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setCabeceraSerieOriginal( new CabeceraSerie());
					////entity.setCabeceraSerieOriginal(super.getEntity("",entity.getCabeceraSerieOriginal(),resultSet,CabeceraSerieDataAccess.ISWITHSCHEMA));         		
					////entity.setCabeceraSerieOriginal(this.getEntityCabeceraSerie("",entity.getCabeceraSerieOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCabeceraSeries(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCabeceraSerie(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public CabeceraSerie getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		CabeceraSerie entity = new CabeceraSerie();		  
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
	
	public  CabeceraSerie getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		CabeceraSerie entity = new CabeceraSerie();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CabeceraSerie();
				
				if(conMapGenerico) {
					entity.inicializarMapCabeceraSerie();
					//entity.setMapCabeceraSerie(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapCabeceraSerieValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapCabeceraSerie().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CabeceraSerieDataAccess.ISWITHSCHEMA);         		
					entity=CabeceraSerieDataAccess.getEntityCabeceraSerie("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setCabeceraSerieOriginal( new CabeceraSerie());
					////entity.setCabeceraSerieOriginal(super.getEntity("",entity.getCabeceraSerieOriginal(),resultSet,CabeceraSerieDataAccess.ISWITHSCHEMA));         		
					////entity.setCabeceraSerieOriginal(this.getEntityCabeceraSerie("",entity.getCabeceraSerieOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseCabeceraSerie(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCabeceraSerie(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static CabeceraSerie getEntityCabeceraSerie(String strPrefijo,CabeceraSerie entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = CabeceraSerie.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = CabeceraSerie.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					CabeceraSerieDataAccess.setFieldReflectionCabeceraSerie(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasCabeceraSerie=CabeceraSerieConstantesFunciones.getTodosTiposColumnasCabeceraSerie();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasCabeceraSerie) {
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
							field = CabeceraSerie.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = CabeceraSerie.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						CabeceraSerieDataAccess.setFieldReflectionCabeceraSerie(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionCabeceraSerie(Field field,String strPrefijo,String sColumn,CabeceraSerie entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case CabeceraSerieConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CabeceraSerieConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CabeceraSerieConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CabeceraSerieConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CabeceraSerieConstantesFunciones.FORMULA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CabeceraSerieConstantesFunciones.CONFORMULA:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case CabeceraSerieConstantesFunciones.CONTOTALIZAR:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<CabeceraSerie>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<CabeceraSerie> entities = new  ArrayList<CabeceraSerie>();
		CabeceraSerie entity = new CabeceraSerie();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CabeceraSerieDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CabeceraSerieDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CabeceraSerieDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new CabeceraSerie();
					entity=super.getEntity("",entity,resultSet,CabeceraSerieDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityCabeceraSerie("",entity,resultSet);
					
					//entity.setCabeceraSerieOriginal( new CabeceraSerie());
					//entity.setCabeceraSerieOriginal(super.getEntity("",entity.getCabeceraSerieOriginal(),resultSet,CabeceraSerieDataAccess.ISWITHSCHEMA));         		
					//entity.setCabeceraSerieOriginal(this.getEntityCabeceraSerie("",entity.getCabeceraSerieOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseCabeceraSeries(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCabeceraSerie(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<CabeceraSerie>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<CabeceraSerie> entities = new  ArrayList<CabeceraSerie>();
		CabeceraSerie entity = new CabeceraSerie();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CabeceraSerieDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CabeceraSerieDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CabeceraSerieDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<CabeceraSerie> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CabeceraSerie> entities = new  ArrayList<CabeceraSerie>();
		CabeceraSerie entity = new CabeceraSerie();		  
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
	
	public  List<CabeceraSerie> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CabeceraSerie> entities = new  ArrayList<CabeceraSerie>();
		CabeceraSerie entity = new CabeceraSerie();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CabeceraSerie();
      	    	entity=super.getEntity("",entity,resultSet,CabeceraSerieDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCabeceraSerie("",entity,resultSet);
      	    	
				//entity.setCabeceraSerieOriginal( new CabeceraSerie());
      	    	//entity.setCabeceraSerieOriginal(super.getEntity("",entity.getCabeceraSerieOriginal(),resultSet,CabeceraSerieDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCabeceraSerieOriginal(this.getEntityCabeceraSerie("",entity.getCabeceraSerieOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseCabeceraSeries(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCabeceraSerie(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<CabeceraSerie> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CabeceraSerie> entities = new  ArrayList<CabeceraSerie>();
		CabeceraSerie entity = new CabeceraSerie();		  
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
	
	public  List<CabeceraSerie> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CabeceraSerie> entities = new  ArrayList<CabeceraSerie>();
		CabeceraSerie entity = new CabeceraSerie();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CabeceraSerie();
      	    	entity=super.getEntity("",entity,resultSet,CabeceraSerieDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCabeceraSerie("",entity,resultSet);
      	    	
				//entity.setCabeceraSerieOriginal( new CabeceraSerie());
      	    	//entity.setCabeceraSerieOriginal(super.getEntity("",entity.getCabeceraSerieOriginal(),resultSet,CabeceraSerieDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCabeceraSerieOriginal(this.getEntityCabeceraSerie("",entity.getCabeceraSerieOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCabeceraSeries(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public CabeceraSerie getEntityCabeceraSerie(String strPrefijo,CabeceraSerie entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+CabeceraSerieConstantesFunciones.IDEMPRESA));
				entity.setnombre(resultSet.getString(strPrefijo+CabeceraSerieConstantesFunciones.NOMBRE));
				entity.setformula(resultSet.getString(strPrefijo+CabeceraSerieConstantesFunciones.FORMULA));
				entity.setcon_formula(resultSet.getBoolean(strPrefijo+CabeceraSerieConstantesFunciones.CONFORMULA));
				entity.setcon_totalizar(resultSet.getBoolean(strPrefijo+CabeceraSerieConstantesFunciones.CONTOTALIZAR));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+CabeceraSerieConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowCabeceraSerie(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(CabeceraSerie entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=CabeceraSerieDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=CabeceraSerieDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=CabeceraSerieDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=CabeceraSerieDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(CabeceraSerieConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,CabeceraSerieDataAccess.TABLENAME,CabeceraSerieDataAccess.ISWITHSTOREPROCEDURES);
			
			CabeceraSerieDataAccess.setCabeceraSerieOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,CabeceraSerie relcabeceraserie)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relcabeceraserie.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,CabeceraSerie cabeceraserie) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!cabeceraserie.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(cabeceraserie.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(cabeceraserie.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueformula=new ParameterValue<String>();
					parameterMaintenanceValueformula.setValue(cabeceraserie.getformula());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueformula);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_formula=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_formula.setValue(cabeceraserie.getcon_formula());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_formula);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_totalizar=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_totalizar.setValue(cabeceraserie.getcon_totalizar());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_totalizar);
					parametersTemp.add(parameterMaintenance);
					
						if(!cabeceraserie.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(cabeceraserie.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(cabeceraserie.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(cabeceraserie.getId());
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
	
	public void setIsNewIsChangedFalseCabeceraSerie(CabeceraSerie cabeceraserie)throws Exception  {		
		cabeceraserie.setIsNew(false);
		cabeceraserie.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseCabeceraSeries(List<CabeceraSerie> cabeceraseries)throws Exception  {				
		for(CabeceraSerie cabeceraserie:cabeceraseries) {
			cabeceraserie.setIsNew(false);
			cabeceraserie.setIsChanged(false);
		}
	}
	
	public void generarExportarCabeceraSerie(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
