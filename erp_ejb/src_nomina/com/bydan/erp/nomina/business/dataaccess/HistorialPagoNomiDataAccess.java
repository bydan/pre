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
package com.bydan.erp.nomina.business.dataaccess;

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

import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.nomina.util.*;//HistorialPagoNomiConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class HistorialPagoNomiDataAccess extends  HistorialPagoNomiDataAccessAdditional{ //HistorialPagoNomiDataAccessAdditional,DataAccessHelper<HistorialPagoNomi>
	//static Logger logger = Logger.getLogger(HistorialPagoNomiDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="historial_pago_nomi";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+HistorialPagoNomiConstantesFunciones.SCHEMA+"."+HistorialPagoNomiConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_estructura,id_empleado,id_rubro_emplea,id_mes,valor,fecha,fecha_liquidacion)values(current_timestamp,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+HistorialPagoNomiConstantesFunciones.SCHEMA+"."+HistorialPagoNomiConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_estructura=?,id_empleado=?,id_rubro_emplea=?,id_mes=?,valor=?,fecha=?,fecha_liquidacion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+HistorialPagoNomiConstantesFunciones.SCHEMA+"."+HistorialPagoNomiConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select historialpagonomi from "+HistorialPagoNomiConstantesFunciones.SPERSISTENCENAME+" historialpagonomi";
	public static String QUERYSELECTNATIVE="select "+HistorialPagoNomiConstantesFunciones.SCHEMA+"."+HistorialPagoNomiConstantesFunciones.TABLENAME+".id,"+HistorialPagoNomiConstantesFunciones.SCHEMA+"."+HistorialPagoNomiConstantesFunciones.TABLENAME+".version_row,"+HistorialPagoNomiConstantesFunciones.SCHEMA+"."+HistorialPagoNomiConstantesFunciones.TABLENAME+".id_empresa,"+HistorialPagoNomiConstantesFunciones.SCHEMA+"."+HistorialPagoNomiConstantesFunciones.TABLENAME+".id_estructura,"+HistorialPagoNomiConstantesFunciones.SCHEMA+"."+HistorialPagoNomiConstantesFunciones.TABLENAME+".id_empleado,"+HistorialPagoNomiConstantesFunciones.SCHEMA+"."+HistorialPagoNomiConstantesFunciones.TABLENAME+".id_rubro_emplea,"+HistorialPagoNomiConstantesFunciones.SCHEMA+"."+HistorialPagoNomiConstantesFunciones.TABLENAME+".id_mes,"+HistorialPagoNomiConstantesFunciones.SCHEMA+"."+HistorialPagoNomiConstantesFunciones.TABLENAME+".valor,"+HistorialPagoNomiConstantesFunciones.SCHEMA+"."+HistorialPagoNomiConstantesFunciones.TABLENAME+".fecha,"+HistorialPagoNomiConstantesFunciones.SCHEMA+"."+HistorialPagoNomiConstantesFunciones.TABLENAME+".fecha_liquidacion from "+HistorialPagoNomiConstantesFunciones.SCHEMA+"."+HistorialPagoNomiConstantesFunciones.TABLENAME;//+" as "+HistorialPagoNomiConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+HistorialPagoNomiConstantesFunciones.SCHEMA+"."+HistorialPagoNomiConstantesFunciones.TABLENAME+".id,"+HistorialPagoNomiConstantesFunciones.SCHEMA+"."+HistorialPagoNomiConstantesFunciones.TABLENAME+".version_row from "+HistorialPagoNomiConstantesFunciones.SCHEMA+"."+HistorialPagoNomiConstantesFunciones.TABLENAME;//+" as "+HistorialPagoNomiConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+HistorialPagoNomiConstantesFunciones.SCHEMA+"."+HistorialPagoNomiConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_estructura=?,id_empleado=?,id_rubro_emplea=?,id_mes=?,valor=?,fecha=?,fecha_liquidacion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_HISTORIALPAGONOMI_INSERT(?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_HISTORIALPAGONOMI_UPDATE(?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_HISTORIALPAGONOMI_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_HISTORIALPAGONOMI_SELECT(?,?)";
	
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
	
	
	protected HistorialPagoNomiDataAccessAdditional historialpagonomiDataAccessAdditional=null;
	
	public HistorialPagoNomiDataAccessAdditional getHistorialPagoNomiDataAccessAdditional() {
		return this.historialpagonomiDataAccessAdditional;
	}
	
	public void setHistorialPagoNomiDataAccessAdditional(HistorialPagoNomiDataAccessAdditional historialpagonomiDataAccessAdditional) {
		try {
			this.historialpagonomiDataAccessAdditional=historialpagonomiDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public HistorialPagoNomiDataAccess() {
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
		HistorialPagoNomiDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		HistorialPagoNomiDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		HistorialPagoNomiDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setHistorialPagoNomiOriginal(HistorialPagoNomi historialpagonomi)throws Exception  {
		historialpagonomi.setHistorialPagoNomiOriginal((HistorialPagoNomi)historialpagonomi.clone());		
	}
	
	public void setHistorialPagoNomisOriginal(List<HistorialPagoNomi> historialpagonomis)throws Exception  {
		
		for(HistorialPagoNomi historialpagonomi:historialpagonomis){
			historialpagonomi.setHistorialPagoNomiOriginal((HistorialPagoNomi)historialpagonomi.clone());
		}
	}
	
	public static void setHistorialPagoNomiOriginalStatic(HistorialPagoNomi historialpagonomi)throws Exception  {
		historialpagonomi.setHistorialPagoNomiOriginal((HistorialPagoNomi)historialpagonomi.clone());		
	}
	
	public static void setHistorialPagoNomisOriginalStatic(List<HistorialPagoNomi> historialpagonomis)throws Exception  {
		
		for(HistorialPagoNomi historialpagonomi:historialpagonomis){
			historialpagonomi.setHistorialPagoNomiOriginal((HistorialPagoNomi)historialpagonomi.clone());
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
	
	public  HistorialPagoNomi getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		HistorialPagoNomi entity = new HistorialPagoNomi();		
		
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
	
	public  HistorialPagoNomi getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		HistorialPagoNomi entity = new HistorialPagoNomi();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=HistorialPagoNomiDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=HistorialPagoNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.HistorialPagoNomi.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setHistorialPagoNomiOriginal(new HistorialPagoNomi());
      	    	entity=super.getEntity("",entity,resultSet,HistorialPagoNomiDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityHistorialPagoNomi("",entity,resultSet); 
				
				//entity.setHistorialPagoNomiOriginal(super.getEntity("",entity.getHistorialPagoNomiOriginal(),resultSet,HistorialPagoNomiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setHistorialPagoNomiOriginal(this.getEntityHistorialPagoNomi("",entity.getHistorialPagoNomiOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseHistorialPagoNomi(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  HistorialPagoNomi getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		HistorialPagoNomi entity = new HistorialPagoNomi();
				
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
	
	public  HistorialPagoNomi getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		HistorialPagoNomi entity = new HistorialPagoNomi();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=HistorialPagoNomiDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=HistorialPagoNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,HistorialPagoNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.HistorialPagoNomi.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setHistorialPagoNomiOriginal(new HistorialPagoNomi());
      	    	entity=super.getEntity("",entity,resultSet,HistorialPagoNomiDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityHistorialPagoNomi("",entity,resultSet);    
				
				//entity.setHistorialPagoNomiOriginal(super.getEntity("",entity.getHistorialPagoNomiOriginal(),resultSet,HistorialPagoNomiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setHistorialPagoNomiOriginal(this.getEntityHistorialPagoNomi("",entity.getHistorialPagoNomiOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseHistorialPagoNomi(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //HistorialPagoNomi
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		HistorialPagoNomi entity = new HistorialPagoNomi();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=HistorialPagoNomiDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=HistorialPagoNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,HistorialPagoNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.HistorialPagoNomi.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseHistorialPagoNomi(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<HistorialPagoNomi> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<HistorialPagoNomi> entities = new  ArrayList<HistorialPagoNomi>();
		HistorialPagoNomi entity = new HistorialPagoNomi();		  
		
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
	
	public  List<HistorialPagoNomi> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<HistorialPagoNomi> entities = new  ArrayList<HistorialPagoNomi>();
		HistorialPagoNomi entity = new HistorialPagoNomi();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=HistorialPagoNomiDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=HistorialPagoNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,HistorialPagoNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new HistorialPagoNomi();
      	    	entity=super.getEntity("",entity,resultSet,HistorialPagoNomiDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityHistorialPagoNomi("",entity,resultSet);
      	    	
				//entity.setHistorialPagoNomiOriginal( new HistorialPagoNomi());
      	    	//entity.setHistorialPagoNomiOriginal(super.getEntity("",entity.getHistorialPagoNomiOriginal(),resultSet,HistorialPagoNomiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setHistorialPagoNomiOriginal(this.getEntityHistorialPagoNomi("",entity.getHistorialPagoNomiOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseHistorialPagoNomis(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarHistorialPagoNomi(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<HistorialPagoNomi> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<HistorialPagoNomi> entities = new  ArrayList<HistorialPagoNomi>();
		HistorialPagoNomi entity = new HistorialPagoNomi();		  
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
	
	public  List<HistorialPagoNomi> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<HistorialPagoNomi> entities = new  ArrayList<HistorialPagoNomi>();
		HistorialPagoNomi entity = new HistorialPagoNomi();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new HistorialPagoNomi();
				
				if(conMapGenerico) {
					entity.inicializarMapHistorialPagoNomi();
					//entity.setMapHistorialPagoNomi(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapHistorialPagoNomiValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapHistorialPagoNomi().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,HistorialPagoNomiDataAccess.ISWITHSCHEMA);         		
					entity=HistorialPagoNomiDataAccess.getEntityHistorialPagoNomi("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setHistorialPagoNomiOriginal( new HistorialPagoNomi());
					////entity.setHistorialPagoNomiOriginal(super.getEntity("",entity.getHistorialPagoNomiOriginal(),resultSet,HistorialPagoNomiDataAccess.ISWITHSCHEMA));         		
					////entity.setHistorialPagoNomiOriginal(this.getEntityHistorialPagoNomi("",entity.getHistorialPagoNomiOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseHistorialPagoNomis(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarHistorialPagoNomi(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public HistorialPagoNomi getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		HistorialPagoNomi entity = new HistorialPagoNomi();		  
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
	
	public  HistorialPagoNomi getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		HistorialPagoNomi entity = new HistorialPagoNomi();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new HistorialPagoNomi();
				
				if(conMapGenerico) {
					entity.inicializarMapHistorialPagoNomi();
					//entity.setMapHistorialPagoNomi(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapHistorialPagoNomiValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapHistorialPagoNomi().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,HistorialPagoNomiDataAccess.ISWITHSCHEMA);         		
					entity=HistorialPagoNomiDataAccess.getEntityHistorialPagoNomi("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setHistorialPagoNomiOriginal( new HistorialPagoNomi());
					////entity.setHistorialPagoNomiOriginal(super.getEntity("",entity.getHistorialPagoNomiOriginal(),resultSet,HistorialPagoNomiDataAccess.ISWITHSCHEMA));         		
					////entity.setHistorialPagoNomiOriginal(this.getEntityHistorialPagoNomi("",entity.getHistorialPagoNomiOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseHistorialPagoNomi(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarHistorialPagoNomi(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static HistorialPagoNomi getEntityHistorialPagoNomi(String strPrefijo,HistorialPagoNomi entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = HistorialPagoNomi.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = HistorialPagoNomi.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					HistorialPagoNomiDataAccess.setFieldReflectionHistorialPagoNomi(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasHistorialPagoNomi=HistorialPagoNomiConstantesFunciones.getTodosTiposColumnasHistorialPagoNomi();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasHistorialPagoNomi) {
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
							field = HistorialPagoNomi.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = HistorialPagoNomi.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						HistorialPagoNomiDataAccess.setFieldReflectionHistorialPagoNomi(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionHistorialPagoNomi(Field field,String strPrefijo,String sColumn,HistorialPagoNomi entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case HistorialPagoNomiConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case HistorialPagoNomiConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case HistorialPagoNomiConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case HistorialPagoNomiConstantesFunciones.IDESTRUCTURA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case HistorialPagoNomiConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case HistorialPagoNomiConstantesFunciones.IDRUBROEMPLEA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case HistorialPagoNomiConstantesFunciones.IDMES:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case HistorialPagoNomiConstantesFunciones.VALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case HistorialPagoNomiConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case HistorialPagoNomiConstantesFunciones.FECHALIQUIDACION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<HistorialPagoNomi>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<HistorialPagoNomi> entities = new  ArrayList<HistorialPagoNomi>();
		HistorialPagoNomi entity = new HistorialPagoNomi();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=HistorialPagoNomiDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=HistorialPagoNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,HistorialPagoNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new HistorialPagoNomi();
					entity=super.getEntity("",entity,resultSet,HistorialPagoNomiDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityHistorialPagoNomi("",entity,resultSet);
					
					//entity.setHistorialPagoNomiOriginal( new HistorialPagoNomi());
					//entity.setHistorialPagoNomiOriginal(super.getEntity("",entity.getHistorialPagoNomiOriginal(),resultSet,HistorialPagoNomiDataAccess.ISWITHSCHEMA));         		
					//entity.setHistorialPagoNomiOriginal(this.getEntityHistorialPagoNomi("",entity.getHistorialPagoNomiOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseHistorialPagoNomis(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarHistorialPagoNomi(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<HistorialPagoNomi>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<HistorialPagoNomi> entities = new  ArrayList<HistorialPagoNomi>();
		HistorialPagoNomi entity = new HistorialPagoNomi();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=HistorialPagoNomiDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=HistorialPagoNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,HistorialPagoNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<HistorialPagoNomi> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<HistorialPagoNomi> entities = new  ArrayList<HistorialPagoNomi>();
		HistorialPagoNomi entity = new HistorialPagoNomi();		  
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
	
	public  List<HistorialPagoNomi> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<HistorialPagoNomi> entities = new  ArrayList<HistorialPagoNomi>();
		HistorialPagoNomi entity = new HistorialPagoNomi();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new HistorialPagoNomi();
      	    	entity=super.getEntity("",entity,resultSet,HistorialPagoNomiDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityHistorialPagoNomi("",entity,resultSet);
      	    	
				//entity.setHistorialPagoNomiOriginal( new HistorialPagoNomi());
      	    	//entity.setHistorialPagoNomiOriginal(super.getEntity("",entity.getHistorialPagoNomiOriginal(),resultSet,HistorialPagoNomiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setHistorialPagoNomiOriginal(this.getEntityHistorialPagoNomi("",entity.getHistorialPagoNomiOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseHistorialPagoNomis(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarHistorialPagoNomi(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<HistorialPagoNomi> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<HistorialPagoNomi> entities = new  ArrayList<HistorialPagoNomi>();
		HistorialPagoNomi entity = new HistorialPagoNomi();		  
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
	
	public  List<HistorialPagoNomi> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<HistorialPagoNomi> entities = new  ArrayList<HistorialPagoNomi>();
		HistorialPagoNomi entity = new HistorialPagoNomi();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new HistorialPagoNomi();
      	    	entity=super.getEntity("",entity,resultSet,HistorialPagoNomiDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityHistorialPagoNomi("",entity,resultSet);
      	    	
				//entity.setHistorialPagoNomiOriginal( new HistorialPagoNomi());
      	    	//entity.setHistorialPagoNomiOriginal(super.getEntity("",entity.getHistorialPagoNomiOriginal(),resultSet,HistorialPagoNomiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setHistorialPagoNomiOriginal(this.getEntityHistorialPagoNomi("",entity.getHistorialPagoNomiOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseHistorialPagoNomis(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public HistorialPagoNomi getEntityHistorialPagoNomi(String strPrefijo,HistorialPagoNomi entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+HistorialPagoNomiConstantesFunciones.IDEMPRESA));
				entity.setid_estructura(resultSet.getLong(strPrefijo+HistorialPagoNomiConstantesFunciones.IDESTRUCTURA));
				entity.setid_empleado(resultSet.getLong(strPrefijo+HistorialPagoNomiConstantesFunciones.IDEMPLEADO));
				entity.setid_rubro_emplea(resultSet.getLong(strPrefijo+HistorialPagoNomiConstantesFunciones.IDRUBROEMPLEA));
				entity.setid_mes(resultSet.getLong(strPrefijo+HistorialPagoNomiConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
				entity.setvalor(resultSet.getDouble(strPrefijo+HistorialPagoNomiConstantesFunciones.VALOR));
				entity.setfecha(new Date(resultSet.getDate(strPrefijo+HistorialPagoNomiConstantesFunciones.FECHA).getTime()));
				entity.setfecha_liquidacion(new Date(resultSet.getDate(strPrefijo+HistorialPagoNomiConstantesFunciones.FECHALIQUIDACION).getTime()));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowHistorialPagoNomi(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(HistorialPagoNomi entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=HistorialPagoNomiDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=HistorialPagoNomiDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=HistorialPagoNomiDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=HistorialPagoNomiDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(HistorialPagoNomiConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,HistorialPagoNomiDataAccess.TABLENAME,HistorialPagoNomiDataAccess.ISWITHSTOREPROCEDURES);
			
			HistorialPagoNomiDataAccess.setHistorialPagoNomiOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,HistorialPagoNomi relhistorialpagonomi)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relhistorialpagonomi.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Estructura getEstructura(Connexion connexion,HistorialPagoNomi relhistorialpagonomi)throws SQLException,Exception {

		Estructura estructura= new Estructura();

		try {
			EstructuraDataAccess estructuraDataAccess=new EstructuraDataAccess();

			estructuraDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estructuraDataAccess.setConnexionType(this.connexionType);
			estructuraDataAccess.setParameterDbType(this.parameterDbType);

			estructura=estructuraDataAccess.getEntity(connexion,relhistorialpagonomi.getid_estructura());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estructura;

	}

	public Empleado getEmpleado(Connexion connexion,HistorialPagoNomi relhistorialpagonomi)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relhistorialpagonomi.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public RubroEmplea getRubroEmplea(Connexion connexion,HistorialPagoNomi relhistorialpagonomi)throws SQLException,Exception {

		RubroEmplea rubroemplea= new RubroEmplea();

		try {
			RubroEmpleaDataAccess rubroempleaDataAccess=new RubroEmpleaDataAccess();

			rubroempleaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			rubroempleaDataAccess.setConnexionType(this.connexionType);
			rubroempleaDataAccess.setParameterDbType(this.parameterDbType);

			rubroemplea=rubroempleaDataAccess.getEntity(connexion,relhistorialpagonomi.getid_rubro_emplea());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return rubroemplea;

	}

	public Mes getMes(Connexion connexion,HistorialPagoNomi relhistorialpagonomi)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,relhistorialpagonomi.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,HistorialPagoNomi historialpagonomi) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!historialpagonomi.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(historialpagonomi.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estructura=new ParameterValue<Long>();
					parameterMaintenanceValueid_estructura.setValue(historialpagonomi.getid_estructura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estructura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(historialpagonomi.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_rubro_emplea=new ParameterValue<Long>();
					parameterMaintenanceValueid_rubro_emplea.setValue(historialpagonomi.getid_rubro_emplea());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_rubro_emplea);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes.setValue(historialpagonomi.getid_mes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor=new ParameterValue<Double>();
					parameterMaintenanceValuevalor.setValue(historialpagonomi.getvalor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha=new ParameterValue<Date>();
					parameterMaintenanceValuefecha.setValue(historialpagonomi.getfecha());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_liquidacion=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_liquidacion.setValue(historialpagonomi.getfecha_liquidacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_liquidacion);
					parametersTemp.add(parameterMaintenance);
					
						if(!historialpagonomi.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(historialpagonomi.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(historialpagonomi.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(historialpagonomi.getId());
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
	
	public void setIsNewIsChangedFalseHistorialPagoNomi(HistorialPagoNomi historialpagonomi)throws Exception  {		
		historialpagonomi.setIsNew(false);
		historialpagonomi.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseHistorialPagoNomis(List<HistorialPagoNomi> historialpagonomis)throws Exception  {				
		for(HistorialPagoNomi historialpagonomi:historialpagonomis) {
			historialpagonomi.setIsNew(false);
			historialpagonomi.setIsChanged(false);
		}
	}
	
	public void generarExportarHistorialPagoNomi(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
