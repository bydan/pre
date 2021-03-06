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
import com.bydan.erp.contabilidad.util.*;//MonedaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class MonedaDataAccess extends  MonedaDataAccessAdditional{ //MonedaDataAccessAdditional,DataAccessHelper<Moneda>
	//static Logger logger = Logger.getLogger(MonedaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="moneda";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+MonedaConstantesFunciones.SCHEMA+"."+MonedaConstantesFunciones.TABLENAME+"(version_row,id_empresa,nombre,sigla,simbolo,esta_activo)values(current_timestamp,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+MonedaConstantesFunciones.SCHEMA+"."+MonedaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,nombre=?,sigla=?,simbolo=?,esta_activo=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+MonedaConstantesFunciones.SCHEMA+"."+MonedaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select moneda from "+MonedaConstantesFunciones.SPERSISTENCENAME+" moneda";
	public static String QUERYSELECTNATIVE="select "+MonedaConstantesFunciones.SCHEMA+"."+MonedaConstantesFunciones.TABLENAME+".id,"+MonedaConstantesFunciones.SCHEMA+"."+MonedaConstantesFunciones.TABLENAME+".version_row,"+MonedaConstantesFunciones.SCHEMA+"."+MonedaConstantesFunciones.TABLENAME+".id_empresa,"+MonedaConstantesFunciones.SCHEMA+"."+MonedaConstantesFunciones.TABLENAME+".nombre,"+MonedaConstantesFunciones.SCHEMA+"."+MonedaConstantesFunciones.TABLENAME+".sigla,"+MonedaConstantesFunciones.SCHEMA+"."+MonedaConstantesFunciones.TABLENAME+".simbolo,"+MonedaConstantesFunciones.SCHEMA+"."+MonedaConstantesFunciones.TABLENAME+".esta_activo from "+MonedaConstantesFunciones.SCHEMA+"."+MonedaConstantesFunciones.TABLENAME;//+" as "+MonedaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+MonedaConstantesFunciones.SCHEMA+"."+MonedaConstantesFunciones.TABLENAME+".id,"+MonedaConstantesFunciones.SCHEMA+"."+MonedaConstantesFunciones.TABLENAME+".version_row,"+MonedaConstantesFunciones.SCHEMA+"."+MonedaConstantesFunciones.TABLENAME+".nombre from "+MonedaConstantesFunciones.SCHEMA+"."+MonedaConstantesFunciones.TABLENAME;//+" as "+MonedaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+MonedaConstantesFunciones.SCHEMA+"."+MonedaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,nombre=?,sigla=?,simbolo=?,esta_activo=?";
	
	public static String STOREPROCEDUREINSERT="call SP_MONEDA_INSERT(?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_MONEDA_UPDATE(?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_MONEDA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_MONEDA_SELECT(?,?)";
	
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
	
	
	protected MonedaDataAccessAdditional monedaDataAccessAdditional=null;
	
	public MonedaDataAccessAdditional getMonedaDataAccessAdditional() {
		return this.monedaDataAccessAdditional;
	}
	
	public void setMonedaDataAccessAdditional(MonedaDataAccessAdditional monedaDataAccessAdditional) {
		try {
			this.monedaDataAccessAdditional=monedaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public MonedaDataAccess() {
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
		MonedaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		MonedaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		MonedaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setMonedaOriginal(Moneda moneda)throws Exception  {
		moneda.setMonedaOriginal((Moneda)moneda.clone());		
	}
	
	public void setMonedasOriginal(List<Moneda> monedas)throws Exception  {
		
		for(Moneda moneda:monedas){
			moneda.setMonedaOriginal((Moneda)moneda.clone());
		}
	}
	
	public static void setMonedaOriginalStatic(Moneda moneda)throws Exception  {
		moneda.setMonedaOriginal((Moneda)moneda.clone());		
	}
	
	public static void setMonedasOriginalStatic(List<Moneda> monedas)throws Exception  {
		
		for(Moneda moneda:monedas){
			moneda.setMonedaOriginal((Moneda)moneda.clone());
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
	
	public  Moneda getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		Moneda entity = new Moneda();		
		
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
	
	public  Moneda getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		Moneda entity = new Moneda();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=MonedaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=MonedaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Contabilidad.Moneda.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setMonedaOriginal(new Moneda());
      	    	entity=super.getEntity("",entity,resultSet,MonedaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityMoneda("",entity,resultSet); 
				
				//entity.setMonedaOriginal(super.getEntity("",entity.getMonedaOriginal(),resultSet,MonedaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setMonedaOriginal(this.getEntityMoneda("",entity.getMonedaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseMoneda(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  Moneda getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Moneda entity = new Moneda();
				
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
	
	public  Moneda getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Moneda entity = new Moneda();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=MonedaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=MonedaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,MonedaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.Moneda.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setMonedaOriginal(new Moneda());
      	    	entity=super.getEntity("",entity,resultSet,MonedaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityMoneda("",entity,resultSet);    
				
				//entity.setMonedaOriginal(super.getEntity("",entity.getMonedaOriginal(),resultSet,MonedaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setMonedaOriginal(this.getEntityMoneda("",entity.getMonedaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseMoneda(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //Moneda
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		Moneda entity = new Moneda();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=MonedaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=MonedaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,MonedaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.Moneda.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseMoneda(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<Moneda> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Moneda> entities = new  ArrayList<Moneda>();
		Moneda entity = new Moneda();		  
		
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
	
	public  List<Moneda> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Moneda> entities = new  ArrayList<Moneda>();
		Moneda entity = new Moneda();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=MonedaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=MonedaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,MonedaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Moneda();
      	    	entity=super.getEntity("",entity,resultSet,MonedaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityMoneda("",entity,resultSet);
      	    	
				//entity.setMonedaOriginal( new Moneda());
      	    	//entity.setMonedaOriginal(super.getEntity("",entity.getMonedaOriginal(),resultSet,MonedaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setMonedaOriginal(this.getEntityMoneda("",entity.getMonedaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseMonedas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarMoneda(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Moneda> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Moneda> entities = new  ArrayList<Moneda>();
		Moneda entity = new Moneda();		  
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
	
	public  List<Moneda> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Moneda> entities = new  ArrayList<Moneda>();
		Moneda entity = new Moneda();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Moneda();
				
				if(conMapGenerico) {
					entity.inicializarMapMoneda();
					//entity.setMapMoneda(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapMonedaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapMoneda().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,MonedaDataAccess.ISWITHSCHEMA);         		
					entity=MonedaDataAccess.getEntityMoneda("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setMonedaOriginal( new Moneda());
					////entity.setMonedaOriginal(super.getEntity("",entity.getMonedaOriginal(),resultSet,MonedaDataAccess.ISWITHSCHEMA));         		
					////entity.setMonedaOriginal(this.getEntityMoneda("",entity.getMonedaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseMonedas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarMoneda(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public Moneda getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Moneda entity = new Moneda();		  
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
	
	public  Moneda getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Moneda entity = new Moneda();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Moneda();
				
				if(conMapGenerico) {
					entity.inicializarMapMoneda();
					//entity.setMapMoneda(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapMonedaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapMoneda().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,MonedaDataAccess.ISWITHSCHEMA);         		
					entity=MonedaDataAccess.getEntityMoneda("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setMonedaOriginal( new Moneda());
					////entity.setMonedaOriginal(super.getEntity("",entity.getMonedaOriginal(),resultSet,MonedaDataAccess.ISWITHSCHEMA));         		
					////entity.setMonedaOriginal(this.getEntityMoneda("",entity.getMonedaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseMoneda(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarMoneda(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static Moneda getEntityMoneda(String strPrefijo,Moneda entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = Moneda.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = Moneda.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					MonedaDataAccess.setFieldReflectionMoneda(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasMoneda=MonedaConstantesFunciones.getTodosTiposColumnasMoneda();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasMoneda) {
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
							field = Moneda.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = Moneda.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						MonedaDataAccess.setFieldReflectionMoneda(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionMoneda(Field field,String strPrefijo,String sColumn,Moneda entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case MonedaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case MonedaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case MonedaConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case MonedaConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case MonedaConstantesFunciones.SIGLA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case MonedaConstantesFunciones.SIMBOLO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case MonedaConstantesFunciones.ESTAACTIVO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Moneda>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<Moneda> entities = new  ArrayList<Moneda>();
		Moneda entity = new Moneda();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=MonedaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=MonedaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,MonedaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new Moneda();
					entity=super.getEntity("",entity,resultSet,MonedaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityMoneda("",entity,resultSet);
					
					//entity.setMonedaOriginal( new Moneda());
					//entity.setMonedaOriginal(super.getEntity("",entity.getMonedaOriginal(),resultSet,MonedaDataAccess.ISWITHSCHEMA));         		
					//entity.setMonedaOriginal(this.getEntityMoneda("",entity.getMonedaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseMonedas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarMoneda(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Moneda>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<Moneda> entities = new  ArrayList<Moneda>();
		Moneda entity = new Moneda();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=MonedaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=MonedaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,MonedaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<Moneda> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Moneda> entities = new  ArrayList<Moneda>();
		Moneda entity = new Moneda();		  
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
	
	public  List<Moneda> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Moneda> entities = new  ArrayList<Moneda>();
		Moneda entity = new Moneda();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Moneda();
      	    	entity=super.getEntity("",entity,resultSet,MonedaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityMoneda("",entity,resultSet);
      	    	
				//entity.setMonedaOriginal( new Moneda());
      	    	//entity.setMonedaOriginal(super.getEntity("",entity.getMonedaOriginal(),resultSet,MonedaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setMonedaOriginal(this.getEntityMoneda("",entity.getMonedaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseMonedas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarMoneda(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Moneda> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Moneda> entities = new  ArrayList<Moneda>();
		Moneda entity = new Moneda();		  
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
	
	public  List<Moneda> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Moneda> entities = new  ArrayList<Moneda>();
		Moneda entity = new Moneda();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Moneda();
      	    	entity=super.getEntity("",entity,resultSet,MonedaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityMoneda("",entity,resultSet);
      	    	
				//entity.setMonedaOriginal( new Moneda());
      	    	//entity.setMonedaOriginal(super.getEntity("",entity.getMonedaOriginal(),resultSet,MonedaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setMonedaOriginal(this.getEntityMoneda("",entity.getMonedaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseMonedas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public Moneda getEntityMoneda(String strPrefijo,Moneda entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+MonedaConstantesFunciones.IDEMPRESA));
				entity.setnombre(resultSet.getString(strPrefijo+MonedaConstantesFunciones.NOMBRE));
				entity.setsigla(resultSet.getString(strPrefijo+MonedaConstantesFunciones.SIGLA));
				entity.setsimbolo(resultSet.getString(strPrefijo+MonedaConstantesFunciones.SIMBOLO));
				entity.setesta_activo(resultSet.getBoolean(strPrefijo+MonedaConstantesFunciones.ESTAACTIVO));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+MonedaConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowMoneda(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(Moneda entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=MonedaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=MonedaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=MonedaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=MonedaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(MonedaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,MonedaDataAccess.TABLENAME,MonedaDataAccess.ISWITHSTOREPROCEDURES);
			
			MonedaDataAccess.setMonedaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,Moneda relmoneda)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relmoneda.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,Moneda moneda) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!moneda.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(moneda.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(moneda.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuesigla=new ParameterValue<String>();
					parameterMaintenanceValuesigla.setValue(moneda.getsigla());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesigla);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuesimbolo=new ParameterValue<String>();
					parameterMaintenanceValuesimbolo.setValue(moneda.getsimbolo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesimbolo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValueesta_activo=new ParameterValue<Boolean>();
					parameterMaintenanceValueesta_activo.setValue(moneda.getesta_activo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueesta_activo);
					parametersTemp.add(parameterMaintenance);
					
						if(!moneda.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(moneda.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(moneda.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(moneda.getId());
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
	
	public void setIsNewIsChangedFalseMoneda(Moneda moneda)throws Exception  {		
		moneda.setIsNew(false);
		moneda.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseMonedas(List<Moneda> monedas)throws Exception  {				
		for(Moneda moneda:monedas) {
			moneda.setIsNew(false);
			moneda.setIsChanged(false);
		}
	}
	
	public void generarExportarMoneda(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
