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
import com.bydan.erp.cartera.util.*;//InformacionFinancieraConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class InformacionFinancieraDataAccess extends  InformacionFinancieraDataAccessAdditional{ //InformacionFinancieraDataAccessAdditional,DataAccessHelper<InformacionFinanciera>
	//static Logger logger = Logger.getLogger(InformacionFinancieraDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="informacionfinanciera";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+InformacionFinancieraConstantesFunciones.SCHEMA+"."+InformacionFinancieraConstantesFunciones.TABLENAME+"(version_row,id_empresa,idcliente,idvalorclientemovimiento,valor,descripcion,esactivo)values(current_timestamp,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+InformacionFinancieraConstantesFunciones.SCHEMA+"."+InformacionFinancieraConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,idcliente=?,idvalorclientemovimiento=?,valor=?,descripcion=?,esactivo=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+InformacionFinancieraConstantesFunciones.SCHEMA+"."+InformacionFinancieraConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select informacionfinanciera from "+InformacionFinancieraConstantesFunciones.SPERSISTENCENAME+" informacionfinanciera";
	public static String QUERYSELECTNATIVE="select "+InformacionFinancieraConstantesFunciones.SCHEMA+"."+InformacionFinancieraConstantesFunciones.TABLENAME+".id,"+InformacionFinancieraConstantesFunciones.SCHEMA+"."+InformacionFinancieraConstantesFunciones.TABLENAME+".version_row,"+InformacionFinancieraConstantesFunciones.SCHEMA+"."+InformacionFinancieraConstantesFunciones.TABLENAME+".id_empresa,"+InformacionFinancieraConstantesFunciones.SCHEMA+"."+InformacionFinancieraConstantesFunciones.TABLENAME+".idcliente,"+InformacionFinancieraConstantesFunciones.SCHEMA+"."+InformacionFinancieraConstantesFunciones.TABLENAME+".idvalorclientemovimiento,"+InformacionFinancieraConstantesFunciones.SCHEMA+"."+InformacionFinancieraConstantesFunciones.TABLENAME+".valor,"+InformacionFinancieraConstantesFunciones.SCHEMA+"."+InformacionFinancieraConstantesFunciones.TABLENAME+".descripcion,"+InformacionFinancieraConstantesFunciones.SCHEMA+"."+InformacionFinancieraConstantesFunciones.TABLENAME+".esactivo from "+InformacionFinancieraConstantesFunciones.SCHEMA+"."+InformacionFinancieraConstantesFunciones.TABLENAME;//+" as "+InformacionFinancieraConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+InformacionFinancieraConstantesFunciones.SCHEMA+"."+InformacionFinancieraConstantesFunciones.TABLENAME+".id,"+InformacionFinancieraConstantesFunciones.SCHEMA+"."+InformacionFinancieraConstantesFunciones.TABLENAME+".version_row from "+InformacionFinancieraConstantesFunciones.SCHEMA+"."+InformacionFinancieraConstantesFunciones.TABLENAME;//+" as "+InformacionFinancieraConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+InformacionFinancieraConstantesFunciones.SCHEMA+"."+InformacionFinancieraConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,idcliente=?,idvalorclientemovimiento=?,valor=?,descripcion=?,esactivo=?";
	
	public static String STOREPROCEDUREINSERT="call SP_INFORMACIONFINANCIERA_INSERT(?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_INFORMACIONFINANCIERA_UPDATE(?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_INFORMACIONFINANCIERA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_INFORMACIONFINANCIERA_SELECT(?,?)";
	
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
	
	
	protected InformacionFinancieraDataAccessAdditional informacionfinancieraDataAccessAdditional=null;
	
	public InformacionFinancieraDataAccessAdditional getInformacionFinancieraDataAccessAdditional() {
		return this.informacionfinancieraDataAccessAdditional;
	}
	
	public void setInformacionFinancieraDataAccessAdditional(InformacionFinancieraDataAccessAdditional informacionfinancieraDataAccessAdditional) {
		try {
			this.informacionfinancieraDataAccessAdditional=informacionfinancieraDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public InformacionFinancieraDataAccess() {
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
		InformacionFinancieraDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		InformacionFinancieraDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		InformacionFinancieraDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setInformacionFinancieraOriginal(InformacionFinanciera informacionfinanciera)throws Exception  {
		informacionfinanciera.setInformacionFinancieraOriginal((InformacionFinanciera)informacionfinanciera.clone());		
	}
	
	public void setInformacionFinancierasOriginal(List<InformacionFinanciera> informacionfinancieras)throws Exception  {
		
		for(InformacionFinanciera informacionfinanciera:informacionfinancieras){
			informacionfinanciera.setInformacionFinancieraOriginal((InformacionFinanciera)informacionfinanciera.clone());
		}
	}
	
	public static void setInformacionFinancieraOriginalStatic(InformacionFinanciera informacionfinanciera)throws Exception  {
		informacionfinanciera.setInformacionFinancieraOriginal((InformacionFinanciera)informacionfinanciera.clone());		
	}
	
	public static void setInformacionFinancierasOriginalStatic(List<InformacionFinanciera> informacionfinancieras)throws Exception  {
		
		for(InformacionFinanciera informacionfinanciera:informacionfinancieras){
			informacionfinanciera.setInformacionFinancieraOriginal((InformacionFinanciera)informacionfinanciera.clone());
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
	
	public  InformacionFinanciera getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		InformacionFinanciera entity = new InformacionFinanciera();		
		
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
	
	public  InformacionFinanciera getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		InformacionFinanciera entity = new InformacionFinanciera();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=InformacionFinancieraDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=InformacionFinancieraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Cartera.InformacionFinanciera.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setInformacionFinancieraOriginal(new InformacionFinanciera());
      	    	entity=super.getEntity("",entity,resultSet,InformacionFinancieraDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityInformacionFinanciera("",entity,resultSet); 
				
				//entity.setInformacionFinancieraOriginal(super.getEntity("",entity.getInformacionFinancieraOriginal(),resultSet,InformacionFinancieraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setInformacionFinancieraOriginal(this.getEntityInformacionFinanciera("",entity.getInformacionFinancieraOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseInformacionFinanciera(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  InformacionFinanciera getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		InformacionFinanciera entity = new InformacionFinanciera();
				
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
	
	public  InformacionFinanciera getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		InformacionFinanciera entity = new InformacionFinanciera();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=InformacionFinancieraDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=InformacionFinancieraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,InformacionFinancieraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.InformacionFinanciera.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setInformacionFinancieraOriginal(new InformacionFinanciera());
      	    	entity=super.getEntity("",entity,resultSet,InformacionFinancieraDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityInformacionFinanciera("",entity,resultSet);    
				
				//entity.setInformacionFinancieraOriginal(super.getEntity("",entity.getInformacionFinancieraOriginal(),resultSet,InformacionFinancieraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setInformacionFinancieraOriginal(this.getEntityInformacionFinanciera("",entity.getInformacionFinancieraOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseInformacionFinanciera(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //InformacionFinanciera
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		InformacionFinanciera entity = new InformacionFinanciera();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=InformacionFinancieraDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=InformacionFinancieraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,InformacionFinancieraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.InformacionFinanciera.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseInformacionFinanciera(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<InformacionFinanciera> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<InformacionFinanciera> entities = new  ArrayList<InformacionFinanciera>();
		InformacionFinanciera entity = new InformacionFinanciera();		  
		
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
	
	public  List<InformacionFinanciera> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<InformacionFinanciera> entities = new  ArrayList<InformacionFinanciera>();
		InformacionFinanciera entity = new InformacionFinanciera();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=InformacionFinancieraDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=InformacionFinancieraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,InformacionFinancieraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new InformacionFinanciera();
      	    	entity=super.getEntity("",entity,resultSet,InformacionFinancieraDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityInformacionFinanciera("",entity,resultSet);
      	    	
				//entity.setInformacionFinancieraOriginal( new InformacionFinanciera());
      	    	//entity.setInformacionFinancieraOriginal(super.getEntity("",entity.getInformacionFinancieraOriginal(),resultSet,InformacionFinancieraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setInformacionFinancieraOriginal(this.getEntityInformacionFinanciera("",entity.getInformacionFinancieraOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseInformacionFinancieras(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarInformacionFinanciera(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<InformacionFinanciera> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<InformacionFinanciera> entities = new  ArrayList<InformacionFinanciera>();
		InformacionFinanciera entity = new InformacionFinanciera();		  
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
	
	public  List<InformacionFinanciera> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<InformacionFinanciera> entities = new  ArrayList<InformacionFinanciera>();
		InformacionFinanciera entity = new InformacionFinanciera();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new InformacionFinanciera();
				
				if(conMapGenerico) {
					entity.inicializarMapInformacionFinanciera();
					//entity.setMapInformacionFinanciera(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapInformacionFinancieraValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapInformacionFinanciera().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,InformacionFinancieraDataAccess.ISWITHSCHEMA);         		
					entity=InformacionFinancieraDataAccess.getEntityInformacionFinanciera("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setInformacionFinancieraOriginal( new InformacionFinanciera());
					////entity.setInformacionFinancieraOriginal(super.getEntity("",entity.getInformacionFinancieraOriginal(),resultSet,InformacionFinancieraDataAccess.ISWITHSCHEMA));         		
					////entity.setInformacionFinancieraOriginal(this.getEntityInformacionFinanciera("",entity.getInformacionFinancieraOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseInformacionFinancieras(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarInformacionFinanciera(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public InformacionFinanciera getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		InformacionFinanciera entity = new InformacionFinanciera();		  
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
	
	public  InformacionFinanciera getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		InformacionFinanciera entity = new InformacionFinanciera();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new InformacionFinanciera();
				
				if(conMapGenerico) {
					entity.inicializarMapInformacionFinanciera();
					//entity.setMapInformacionFinanciera(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapInformacionFinancieraValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapInformacionFinanciera().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,InformacionFinancieraDataAccess.ISWITHSCHEMA);         		
					entity=InformacionFinancieraDataAccess.getEntityInformacionFinanciera("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setInformacionFinancieraOriginal( new InformacionFinanciera());
					////entity.setInformacionFinancieraOriginal(super.getEntity("",entity.getInformacionFinancieraOriginal(),resultSet,InformacionFinancieraDataAccess.ISWITHSCHEMA));         		
					////entity.setInformacionFinancieraOriginal(this.getEntityInformacionFinanciera("",entity.getInformacionFinancieraOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseInformacionFinanciera(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarInformacionFinanciera(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static InformacionFinanciera getEntityInformacionFinanciera(String strPrefijo,InformacionFinanciera entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = InformacionFinanciera.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = InformacionFinanciera.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					InformacionFinancieraDataAccess.setFieldReflectionInformacionFinanciera(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasInformacionFinanciera=InformacionFinancieraConstantesFunciones.getTodosTiposColumnasInformacionFinanciera();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasInformacionFinanciera) {
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
							field = InformacionFinanciera.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = InformacionFinanciera.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						InformacionFinancieraDataAccess.setFieldReflectionInformacionFinanciera(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionInformacionFinanciera(Field field,String strPrefijo,String sColumn,InformacionFinanciera entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case InformacionFinancieraConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case InformacionFinancieraConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case InformacionFinancieraConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case InformacionFinancieraConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case InformacionFinancieraConstantesFunciones.IDTIPOMOVIFINAN:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case InformacionFinancieraConstantesFunciones.VALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case InformacionFinancieraConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case InformacionFinancieraConstantesFunciones.ESACTIVO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<InformacionFinanciera>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<InformacionFinanciera> entities = new  ArrayList<InformacionFinanciera>();
		InformacionFinanciera entity = new InformacionFinanciera();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=InformacionFinancieraDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=InformacionFinancieraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,InformacionFinancieraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new InformacionFinanciera();
					entity=super.getEntity("",entity,resultSet,InformacionFinancieraDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityInformacionFinanciera("",entity,resultSet);
					
					//entity.setInformacionFinancieraOriginal( new InformacionFinanciera());
					//entity.setInformacionFinancieraOriginal(super.getEntity("",entity.getInformacionFinancieraOriginal(),resultSet,InformacionFinancieraDataAccess.ISWITHSCHEMA));         		
					//entity.setInformacionFinancieraOriginal(this.getEntityInformacionFinanciera("",entity.getInformacionFinancieraOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseInformacionFinancieras(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarInformacionFinanciera(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<InformacionFinanciera>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<InformacionFinanciera> entities = new  ArrayList<InformacionFinanciera>();
		InformacionFinanciera entity = new InformacionFinanciera();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=InformacionFinancieraDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=InformacionFinancieraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,InformacionFinancieraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<InformacionFinanciera> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<InformacionFinanciera> entities = new  ArrayList<InformacionFinanciera>();
		InformacionFinanciera entity = new InformacionFinanciera();		  
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
	
	public  List<InformacionFinanciera> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<InformacionFinanciera> entities = new  ArrayList<InformacionFinanciera>();
		InformacionFinanciera entity = new InformacionFinanciera();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new InformacionFinanciera();
      	    	entity=super.getEntity("",entity,resultSet,InformacionFinancieraDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityInformacionFinanciera("",entity,resultSet);
      	    	
				//entity.setInformacionFinancieraOriginal( new InformacionFinanciera());
      	    	//entity.setInformacionFinancieraOriginal(super.getEntity("",entity.getInformacionFinancieraOriginal(),resultSet,InformacionFinancieraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setInformacionFinancieraOriginal(this.getEntityInformacionFinanciera("",entity.getInformacionFinancieraOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseInformacionFinancieras(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarInformacionFinanciera(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<InformacionFinanciera> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<InformacionFinanciera> entities = new  ArrayList<InformacionFinanciera>();
		InformacionFinanciera entity = new InformacionFinanciera();		  
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
	
	public  List<InformacionFinanciera> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<InformacionFinanciera> entities = new  ArrayList<InformacionFinanciera>();
		InformacionFinanciera entity = new InformacionFinanciera();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new InformacionFinanciera();
      	    	entity=super.getEntity("",entity,resultSet,InformacionFinancieraDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityInformacionFinanciera("",entity,resultSet);
      	    	
				//entity.setInformacionFinancieraOriginal( new InformacionFinanciera());
      	    	//entity.setInformacionFinancieraOriginal(super.getEntity("",entity.getInformacionFinancieraOriginal(),resultSet,InformacionFinancieraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setInformacionFinancieraOriginal(this.getEntityInformacionFinanciera("",entity.getInformacionFinancieraOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseInformacionFinancieras(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public InformacionFinanciera getEntityInformacionFinanciera(String strPrefijo,InformacionFinanciera entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+InformacionFinancieraConstantesFunciones.IDEMPRESA));
				entity.setidcliente(resultSet.getLong(strPrefijo+InformacionFinancieraConstantesFunciones.IDCLIENTE));
				entity.setidvalorclientemovimiento(resultSet.getLong(strPrefijo+InformacionFinancieraConstantesFunciones.IDTIPOMOVIFINAN));
				entity.setvalor(resultSet.getDouble(strPrefijo+InformacionFinancieraConstantesFunciones.VALOR));
				entity.setdescripcion(resultSet.getString(strPrefijo+InformacionFinancieraConstantesFunciones.DESCRIPCION));
				entity.setesactivo(resultSet.getBoolean(strPrefijo+InformacionFinancieraConstantesFunciones.ESACTIVO));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowInformacionFinanciera(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(InformacionFinanciera entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=InformacionFinancieraDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=InformacionFinancieraDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=InformacionFinancieraDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=InformacionFinancieraDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(InformacionFinancieraConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,InformacionFinancieraDataAccess.TABLENAME,InformacionFinancieraDataAccess.ISWITHSTOREPROCEDURES);
			
			InformacionFinancieraDataAccess.setInformacionFinancieraOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,InformacionFinanciera relinformacionfinanciera)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relinformacionfinanciera.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Cliente getCliente(Connexion connexion,InformacionFinanciera relinformacionfinanciera)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,relinformacionfinanciera.getidcliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public TipoMoviFinan getTipoMoviFinan(Connexion connexion,InformacionFinanciera relinformacionfinanciera)throws SQLException,Exception {

		TipoMoviFinan tipomovifinan= new TipoMoviFinan();

		try {
			TipoMoviFinanDataAccess tipomovifinanDataAccess=new TipoMoviFinanDataAccess();

			tipomovifinanDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipomovifinanDataAccess.setConnexionType(this.connexionType);
			tipomovifinanDataAccess.setParameterDbType(this.parameterDbType);

			tipomovifinan=tipomovifinanDataAccess.getEntity(connexion,relinformacionfinanciera.getidvalorclientemovimiento());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipomovifinan;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,InformacionFinanciera informacionfinanciera) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!informacionfinanciera.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(informacionfinanciera.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueidcliente=new ParameterValue<Long>();
					parameterMaintenanceValueidcliente.setValue(informacionfinanciera.getidcliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueidcliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueidvalorclientemovimiento=new ParameterValue<Long>();
					parameterMaintenanceValueidvalorclientemovimiento.setValue(informacionfinanciera.getidvalorclientemovimiento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueidvalorclientemovimiento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor=new ParameterValue<Double>();
					parameterMaintenanceValuevalor.setValue(informacionfinanciera.getvalor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(informacionfinanciera.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValueesactivo=new ParameterValue<Boolean>();
					parameterMaintenanceValueesactivo.setValue(informacionfinanciera.getesactivo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueesactivo);
					parametersTemp.add(parameterMaintenance);
					
						if(!informacionfinanciera.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(informacionfinanciera.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(informacionfinanciera.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(informacionfinanciera.getId());
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
	
	public void setIsNewIsChangedFalseInformacionFinanciera(InformacionFinanciera informacionfinanciera)throws Exception  {		
		informacionfinanciera.setIsNew(false);
		informacionfinanciera.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseInformacionFinancieras(List<InformacionFinanciera> informacionfinancieras)throws Exception  {				
		for(InformacionFinanciera informacionfinanciera:informacionfinancieras) {
			informacionfinanciera.setIsNew(false);
			informacionfinanciera.setIsChanged(false);
		}
	}
	
	public void generarExportarInformacionFinanciera(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
