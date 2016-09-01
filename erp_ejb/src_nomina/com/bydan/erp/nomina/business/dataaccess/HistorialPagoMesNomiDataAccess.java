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
import com.bydan.erp.nomina.util.*;//HistorialPagoMesNomiConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class HistorialPagoMesNomiDataAccess extends  HistorialPagoMesNomiDataAccessAdditional{ //HistorialPagoMesNomiDataAccessAdditional,DataAccessHelper<HistorialPagoMesNomi>
	//static Logger logger = Logger.getLogger(HistorialPagoMesNomiDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="historial_pago_mes_nomi";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+HistorialPagoMesNomiConstantesFunciones.SCHEMA+"."+HistorialPagoMesNomiConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_empleado,id_rubro_emplea,id_anio,id_mes,valor)values(current_timestamp,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+HistorialPagoMesNomiConstantesFunciones.SCHEMA+"."+HistorialPagoMesNomiConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_empleado=?,id_rubro_emplea=?,id_anio=?,id_mes=?,valor=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+HistorialPagoMesNomiConstantesFunciones.SCHEMA+"."+HistorialPagoMesNomiConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select historialpagomesnomi from "+HistorialPagoMesNomiConstantesFunciones.SPERSISTENCENAME+" historialpagomesnomi";
	public static String QUERYSELECTNATIVE="select "+HistorialPagoMesNomiConstantesFunciones.SCHEMA+"."+HistorialPagoMesNomiConstantesFunciones.TABLENAME+".id,"+HistorialPagoMesNomiConstantesFunciones.SCHEMA+"."+HistorialPagoMesNomiConstantesFunciones.TABLENAME+".version_row,"+HistorialPagoMesNomiConstantesFunciones.SCHEMA+"."+HistorialPagoMesNomiConstantesFunciones.TABLENAME+".id_empresa,"+HistorialPagoMesNomiConstantesFunciones.SCHEMA+"."+HistorialPagoMesNomiConstantesFunciones.TABLENAME+".id_empleado,"+HistorialPagoMesNomiConstantesFunciones.SCHEMA+"."+HistorialPagoMesNomiConstantesFunciones.TABLENAME+".id_rubro_emplea,"+HistorialPagoMesNomiConstantesFunciones.SCHEMA+"."+HistorialPagoMesNomiConstantesFunciones.TABLENAME+".id_anio,"+HistorialPagoMesNomiConstantesFunciones.SCHEMA+"."+HistorialPagoMesNomiConstantesFunciones.TABLENAME+".id_mes,"+HistorialPagoMesNomiConstantesFunciones.SCHEMA+"."+HistorialPagoMesNomiConstantesFunciones.TABLENAME+".valor from "+HistorialPagoMesNomiConstantesFunciones.SCHEMA+"."+HistorialPagoMesNomiConstantesFunciones.TABLENAME;//+" as "+HistorialPagoMesNomiConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+HistorialPagoMesNomiConstantesFunciones.SCHEMA+"."+HistorialPagoMesNomiConstantesFunciones.TABLENAME+".id,"+HistorialPagoMesNomiConstantesFunciones.SCHEMA+"."+HistorialPagoMesNomiConstantesFunciones.TABLENAME+".version_row from "+HistorialPagoMesNomiConstantesFunciones.SCHEMA+"."+HistorialPagoMesNomiConstantesFunciones.TABLENAME;//+" as "+HistorialPagoMesNomiConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+HistorialPagoMesNomiConstantesFunciones.SCHEMA+"."+HistorialPagoMesNomiConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_empleado=?,id_rubro_emplea=?,id_anio=?,id_mes=?,valor=?";
	
	public static String STOREPROCEDUREINSERT="call SP_HISTORIALPAGOMESNOMI_INSERT(?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_HISTORIALPAGOMESNOMI_UPDATE(?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_HISTORIALPAGOMESNOMI_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_HISTORIALPAGOMESNOMI_SELECT(?,?)";
	
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
	
	
	protected HistorialPagoMesNomiDataAccessAdditional historialpagomesnomiDataAccessAdditional=null;
	
	public HistorialPagoMesNomiDataAccessAdditional getHistorialPagoMesNomiDataAccessAdditional() {
		return this.historialpagomesnomiDataAccessAdditional;
	}
	
	public void setHistorialPagoMesNomiDataAccessAdditional(HistorialPagoMesNomiDataAccessAdditional historialpagomesnomiDataAccessAdditional) {
		try {
			this.historialpagomesnomiDataAccessAdditional=historialpagomesnomiDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public HistorialPagoMesNomiDataAccess() {
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
		HistorialPagoMesNomiDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		HistorialPagoMesNomiDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		HistorialPagoMesNomiDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setHistorialPagoMesNomiOriginal(HistorialPagoMesNomi historialpagomesnomi)throws Exception  {
		historialpagomesnomi.setHistorialPagoMesNomiOriginal((HistorialPagoMesNomi)historialpagomesnomi.clone());		
	}
	
	public void setHistorialPagoMesNomisOriginal(List<HistorialPagoMesNomi> historialpagomesnomis)throws Exception  {
		
		for(HistorialPagoMesNomi historialpagomesnomi:historialpagomesnomis){
			historialpagomesnomi.setHistorialPagoMesNomiOriginal((HistorialPagoMesNomi)historialpagomesnomi.clone());
		}
	}
	
	public static void setHistorialPagoMesNomiOriginalStatic(HistorialPagoMesNomi historialpagomesnomi)throws Exception  {
		historialpagomesnomi.setHistorialPagoMesNomiOriginal((HistorialPagoMesNomi)historialpagomesnomi.clone());		
	}
	
	public static void setHistorialPagoMesNomisOriginalStatic(List<HistorialPagoMesNomi> historialpagomesnomis)throws Exception  {
		
		for(HistorialPagoMesNomi historialpagomesnomi:historialpagomesnomis){
			historialpagomesnomi.setHistorialPagoMesNomiOriginal((HistorialPagoMesNomi)historialpagomesnomi.clone());
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
	
	public  HistorialPagoMesNomi getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		HistorialPagoMesNomi entity = new HistorialPagoMesNomi();		
		
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
	
	public  HistorialPagoMesNomi getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		HistorialPagoMesNomi entity = new HistorialPagoMesNomi();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=HistorialPagoMesNomiDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=HistorialPagoMesNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.HistorialPagoMesNomi.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setHistorialPagoMesNomiOriginal(new HistorialPagoMesNomi());
      	    	entity=super.getEntity("",entity,resultSet,HistorialPagoMesNomiDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityHistorialPagoMesNomi("",entity,resultSet); 
				
				//entity.setHistorialPagoMesNomiOriginal(super.getEntity("",entity.getHistorialPagoMesNomiOriginal(),resultSet,HistorialPagoMesNomiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setHistorialPagoMesNomiOriginal(this.getEntityHistorialPagoMesNomi("",entity.getHistorialPagoMesNomiOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseHistorialPagoMesNomi(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  HistorialPagoMesNomi getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		HistorialPagoMesNomi entity = new HistorialPagoMesNomi();
				
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
	
	public  HistorialPagoMesNomi getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		HistorialPagoMesNomi entity = new HistorialPagoMesNomi();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=HistorialPagoMesNomiDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=HistorialPagoMesNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,HistorialPagoMesNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.HistorialPagoMesNomi.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setHistorialPagoMesNomiOriginal(new HistorialPagoMesNomi());
      	    	entity=super.getEntity("",entity,resultSet,HistorialPagoMesNomiDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityHistorialPagoMesNomi("",entity,resultSet);    
				
				//entity.setHistorialPagoMesNomiOriginal(super.getEntity("",entity.getHistorialPagoMesNomiOriginal(),resultSet,HistorialPagoMesNomiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setHistorialPagoMesNomiOriginal(this.getEntityHistorialPagoMesNomi("",entity.getHistorialPagoMesNomiOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseHistorialPagoMesNomi(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //HistorialPagoMesNomi
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		HistorialPagoMesNomi entity = new HistorialPagoMesNomi();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=HistorialPagoMesNomiDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=HistorialPagoMesNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,HistorialPagoMesNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.HistorialPagoMesNomi.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseHistorialPagoMesNomi(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<HistorialPagoMesNomi> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<HistorialPagoMesNomi> entities = new  ArrayList<HistorialPagoMesNomi>();
		HistorialPagoMesNomi entity = new HistorialPagoMesNomi();		  
		
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
	
	public  List<HistorialPagoMesNomi> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<HistorialPagoMesNomi> entities = new  ArrayList<HistorialPagoMesNomi>();
		HistorialPagoMesNomi entity = new HistorialPagoMesNomi();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=HistorialPagoMesNomiDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=HistorialPagoMesNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,HistorialPagoMesNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new HistorialPagoMesNomi();
      	    	entity=super.getEntity("",entity,resultSet,HistorialPagoMesNomiDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityHistorialPagoMesNomi("",entity,resultSet);
      	    	
				//entity.setHistorialPagoMesNomiOriginal( new HistorialPagoMesNomi());
      	    	//entity.setHistorialPagoMesNomiOriginal(super.getEntity("",entity.getHistorialPagoMesNomiOriginal(),resultSet,HistorialPagoMesNomiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setHistorialPagoMesNomiOriginal(this.getEntityHistorialPagoMesNomi("",entity.getHistorialPagoMesNomiOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseHistorialPagoMesNomis(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarHistorialPagoMesNomi(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<HistorialPagoMesNomi> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<HistorialPagoMesNomi> entities = new  ArrayList<HistorialPagoMesNomi>();
		HistorialPagoMesNomi entity = new HistorialPagoMesNomi();		  
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
	
	public  List<HistorialPagoMesNomi> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<HistorialPagoMesNomi> entities = new  ArrayList<HistorialPagoMesNomi>();
		HistorialPagoMesNomi entity = new HistorialPagoMesNomi();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new HistorialPagoMesNomi();
				
				if(conMapGenerico) {
					entity.inicializarMapHistorialPagoMesNomi();
					//entity.setMapHistorialPagoMesNomi(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapHistorialPagoMesNomiValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapHistorialPagoMesNomi().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,HistorialPagoMesNomiDataAccess.ISWITHSCHEMA);         		
					entity=HistorialPagoMesNomiDataAccess.getEntityHistorialPagoMesNomi("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setHistorialPagoMesNomiOriginal( new HistorialPagoMesNomi());
					////entity.setHistorialPagoMesNomiOriginal(super.getEntity("",entity.getHistorialPagoMesNomiOriginal(),resultSet,HistorialPagoMesNomiDataAccess.ISWITHSCHEMA));         		
					////entity.setHistorialPagoMesNomiOriginal(this.getEntityHistorialPagoMesNomi("",entity.getHistorialPagoMesNomiOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseHistorialPagoMesNomis(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarHistorialPagoMesNomi(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public HistorialPagoMesNomi getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		HistorialPagoMesNomi entity = new HistorialPagoMesNomi();		  
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
	
	public  HistorialPagoMesNomi getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		HistorialPagoMesNomi entity = new HistorialPagoMesNomi();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new HistorialPagoMesNomi();
				
				if(conMapGenerico) {
					entity.inicializarMapHistorialPagoMesNomi();
					//entity.setMapHistorialPagoMesNomi(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapHistorialPagoMesNomiValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapHistorialPagoMesNomi().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,HistorialPagoMesNomiDataAccess.ISWITHSCHEMA);         		
					entity=HistorialPagoMesNomiDataAccess.getEntityHistorialPagoMesNomi("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setHistorialPagoMesNomiOriginal( new HistorialPagoMesNomi());
					////entity.setHistorialPagoMesNomiOriginal(super.getEntity("",entity.getHistorialPagoMesNomiOriginal(),resultSet,HistorialPagoMesNomiDataAccess.ISWITHSCHEMA));         		
					////entity.setHistorialPagoMesNomiOriginal(this.getEntityHistorialPagoMesNomi("",entity.getHistorialPagoMesNomiOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseHistorialPagoMesNomi(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarHistorialPagoMesNomi(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static HistorialPagoMesNomi getEntityHistorialPagoMesNomi(String strPrefijo,HistorialPagoMesNomi entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = HistorialPagoMesNomi.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = HistorialPagoMesNomi.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					HistorialPagoMesNomiDataAccess.setFieldReflectionHistorialPagoMesNomi(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasHistorialPagoMesNomi=HistorialPagoMesNomiConstantesFunciones.getTodosTiposColumnasHistorialPagoMesNomi();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasHistorialPagoMesNomi) {
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
							field = HistorialPagoMesNomi.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = HistorialPagoMesNomi.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						HistorialPagoMesNomiDataAccess.setFieldReflectionHistorialPagoMesNomi(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionHistorialPagoMesNomi(Field field,String strPrefijo,String sColumn,HistorialPagoMesNomi entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case HistorialPagoMesNomiConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case HistorialPagoMesNomiConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case HistorialPagoMesNomiConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case HistorialPagoMesNomiConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case HistorialPagoMesNomiConstantesFunciones.IDRUBROEMPLEA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case HistorialPagoMesNomiConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case HistorialPagoMesNomiConstantesFunciones.IDMES:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case HistorialPagoMesNomiConstantesFunciones.VALOR:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<HistorialPagoMesNomi>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<HistorialPagoMesNomi> entities = new  ArrayList<HistorialPagoMesNomi>();
		HistorialPagoMesNomi entity = new HistorialPagoMesNomi();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=HistorialPagoMesNomiDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=HistorialPagoMesNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,HistorialPagoMesNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new HistorialPagoMesNomi();
					entity=super.getEntity("",entity,resultSet,HistorialPagoMesNomiDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityHistorialPagoMesNomi("",entity,resultSet);
					
					//entity.setHistorialPagoMesNomiOriginal( new HistorialPagoMesNomi());
					//entity.setHistorialPagoMesNomiOriginal(super.getEntity("",entity.getHistorialPagoMesNomiOriginal(),resultSet,HistorialPagoMesNomiDataAccess.ISWITHSCHEMA));         		
					//entity.setHistorialPagoMesNomiOriginal(this.getEntityHistorialPagoMesNomi("",entity.getHistorialPagoMesNomiOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseHistorialPagoMesNomis(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarHistorialPagoMesNomi(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<HistorialPagoMesNomi>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<HistorialPagoMesNomi> entities = new  ArrayList<HistorialPagoMesNomi>();
		HistorialPagoMesNomi entity = new HistorialPagoMesNomi();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=HistorialPagoMesNomiDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=HistorialPagoMesNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,HistorialPagoMesNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<HistorialPagoMesNomi> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<HistorialPagoMesNomi> entities = new  ArrayList<HistorialPagoMesNomi>();
		HistorialPagoMesNomi entity = new HistorialPagoMesNomi();		  
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
	
	public  List<HistorialPagoMesNomi> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<HistorialPagoMesNomi> entities = new  ArrayList<HistorialPagoMesNomi>();
		HistorialPagoMesNomi entity = new HistorialPagoMesNomi();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new HistorialPagoMesNomi();
      	    	entity=super.getEntity("",entity,resultSet,HistorialPagoMesNomiDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityHistorialPagoMesNomi("",entity,resultSet);
      	    	
				//entity.setHistorialPagoMesNomiOriginal( new HistorialPagoMesNomi());
      	    	//entity.setHistorialPagoMesNomiOriginal(super.getEntity("",entity.getHistorialPagoMesNomiOriginal(),resultSet,HistorialPagoMesNomiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setHistorialPagoMesNomiOriginal(this.getEntityHistorialPagoMesNomi("",entity.getHistorialPagoMesNomiOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseHistorialPagoMesNomis(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarHistorialPagoMesNomi(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<HistorialPagoMesNomi> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<HistorialPagoMesNomi> entities = new  ArrayList<HistorialPagoMesNomi>();
		HistorialPagoMesNomi entity = new HistorialPagoMesNomi();		  
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
	
	public  List<HistorialPagoMesNomi> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<HistorialPagoMesNomi> entities = new  ArrayList<HistorialPagoMesNomi>();
		HistorialPagoMesNomi entity = new HistorialPagoMesNomi();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new HistorialPagoMesNomi();
      	    	entity=super.getEntity("",entity,resultSet,HistorialPagoMesNomiDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityHistorialPagoMesNomi("",entity,resultSet);
      	    	
				//entity.setHistorialPagoMesNomiOriginal( new HistorialPagoMesNomi());
      	    	//entity.setHistorialPagoMesNomiOriginal(super.getEntity("",entity.getHistorialPagoMesNomiOriginal(),resultSet,HistorialPagoMesNomiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setHistorialPagoMesNomiOriginal(this.getEntityHistorialPagoMesNomi("",entity.getHistorialPagoMesNomiOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseHistorialPagoMesNomis(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public HistorialPagoMesNomi getEntityHistorialPagoMesNomi(String strPrefijo,HistorialPagoMesNomi entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+HistorialPagoMesNomiConstantesFunciones.IDEMPRESA));
				entity.setid_empleado(resultSet.getLong(strPrefijo+HistorialPagoMesNomiConstantesFunciones.IDEMPLEADO));
				entity.setid_rubro_emplea(resultSet.getLong(strPrefijo+HistorialPagoMesNomiConstantesFunciones.IDRUBROEMPLEA));
				entity.setid_anio(resultSet.getLong(strPrefijo+HistorialPagoMesNomiConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
				entity.setid_mes(resultSet.getLong(strPrefijo+HistorialPagoMesNomiConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
				entity.setvalor(resultSet.getDouble(strPrefijo+HistorialPagoMesNomiConstantesFunciones.VALOR));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowHistorialPagoMesNomi(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(HistorialPagoMesNomi entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=HistorialPagoMesNomiDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=HistorialPagoMesNomiDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=HistorialPagoMesNomiDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=HistorialPagoMesNomiDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(HistorialPagoMesNomiConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,HistorialPagoMesNomiDataAccess.TABLENAME,HistorialPagoMesNomiDataAccess.ISWITHSTOREPROCEDURES);
			
			HistorialPagoMesNomiDataAccess.setHistorialPagoMesNomiOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,HistorialPagoMesNomi relhistorialpagomesnomi)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relhistorialpagomesnomi.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Empleado getEmpleado(Connexion connexion,HistorialPagoMesNomi relhistorialpagomesnomi)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relhistorialpagomesnomi.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public RubroEmplea getRubroEmplea(Connexion connexion,HistorialPagoMesNomi relhistorialpagomesnomi)throws SQLException,Exception {

		RubroEmplea rubroemplea= new RubroEmplea();

		try {
			RubroEmpleaDataAccess rubroempleaDataAccess=new RubroEmpleaDataAccess();

			rubroempleaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			rubroempleaDataAccess.setConnexionType(this.connexionType);
			rubroempleaDataAccess.setParameterDbType(this.parameterDbType);

			rubroemplea=rubroempleaDataAccess.getEntity(connexion,relhistorialpagomesnomi.getid_rubro_emplea());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return rubroemplea;

	}

	public Anio getAnio(Connexion connexion,HistorialPagoMesNomi relhistorialpagomesnomi)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);

			anio=anioDataAccess.getEntity(connexion,relhistorialpagomesnomi.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Mes getMes(Connexion connexion,HistorialPagoMesNomi relhistorialpagomesnomi)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,relhistorialpagomesnomi.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,HistorialPagoMesNomi historialpagomesnomi) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!historialpagomesnomi.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(historialpagomesnomi.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(historialpagomesnomi.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_rubro_emplea=new ParameterValue<Long>();
					parameterMaintenanceValueid_rubro_emplea.setValue(historialpagomesnomi.getid_rubro_emplea());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_rubro_emplea);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_anio=new ParameterValue<Long>();
					parameterMaintenanceValueid_anio.setValue(historialpagomesnomi.getid_anio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_anio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes.setValue(historialpagomesnomi.getid_mes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor=new ParameterValue<Double>();
					parameterMaintenanceValuevalor.setValue(historialpagomesnomi.getvalor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor);
					parametersTemp.add(parameterMaintenance);
					
						if(!historialpagomesnomi.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(historialpagomesnomi.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(historialpagomesnomi.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(historialpagomesnomi.getId());
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
	
	public void setIsNewIsChangedFalseHistorialPagoMesNomi(HistorialPagoMesNomi historialpagomesnomi)throws Exception  {		
		historialpagomesnomi.setIsNew(false);
		historialpagomesnomi.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseHistorialPagoMesNomis(List<HistorialPagoMesNomi> historialpagomesnomis)throws Exception  {				
		for(HistorialPagoMesNomi historialpagomesnomi:historialpagomesnomis) {
			historialpagomesnomi.setIsNew(false);
			historialpagomesnomi.setIsChanged(false);
		}
	}
	
	public void generarExportarHistorialPagoMesNomi(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
