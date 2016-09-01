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
import com.bydan.erp.cartera.util.*;//AccionistaConstantesFunciones;










@SuppressWarnings("unused")
final public class AccionistaDataAccess extends  AccionistaDataAccessAdditional{ //AccionistaDataAccessAdditional,DataAccessHelper<Accionista>
	//static Logger logger = Logger.getLogger(AccionistaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="accionista";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+AccionistaConstantesFunciones.SCHEMA+"."+AccionistaConstantesFunciones.TABLENAME+"(version_row,idcliente,idvalorclienteinversion,idvaloridentificacion,identificacion,apellidopaterno,apellidomaterno,primernombre,segundonombre,nombrecorto,participacion,esactivo)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+AccionistaConstantesFunciones.SCHEMA+"."+AccionistaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,idcliente=?,idvalorclienteinversion=?,idvaloridentificacion=?,identificacion=?,apellidopaterno=?,apellidomaterno=?,primernombre=?,segundonombre=?,nombrecorto=?,participacion=?,esactivo=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+AccionistaConstantesFunciones.SCHEMA+"."+AccionistaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select accionista from "+AccionistaConstantesFunciones.SPERSISTENCENAME+" accionista";
	public static String QUERYSELECTNATIVE="select "+AccionistaConstantesFunciones.SCHEMA+"."+AccionistaConstantesFunciones.TABLENAME+".id,"+AccionistaConstantesFunciones.SCHEMA+"."+AccionistaConstantesFunciones.TABLENAME+".version_row,"+AccionistaConstantesFunciones.SCHEMA+"."+AccionistaConstantesFunciones.TABLENAME+".idcliente,"+AccionistaConstantesFunciones.SCHEMA+"."+AccionistaConstantesFunciones.TABLENAME+".idvalorclienteinversion,"+AccionistaConstantesFunciones.SCHEMA+"."+AccionistaConstantesFunciones.TABLENAME+".idvaloridentificacion,"+AccionistaConstantesFunciones.SCHEMA+"."+AccionistaConstantesFunciones.TABLENAME+".identificacion,"+AccionistaConstantesFunciones.SCHEMA+"."+AccionistaConstantesFunciones.TABLENAME+".apellidopaterno,"+AccionistaConstantesFunciones.SCHEMA+"."+AccionistaConstantesFunciones.TABLENAME+".apellidomaterno,"+AccionistaConstantesFunciones.SCHEMA+"."+AccionistaConstantesFunciones.TABLENAME+".primernombre,"+AccionistaConstantesFunciones.SCHEMA+"."+AccionistaConstantesFunciones.TABLENAME+".segundonombre,"+AccionistaConstantesFunciones.SCHEMA+"."+AccionistaConstantesFunciones.TABLENAME+".nombrecorto,"+AccionistaConstantesFunciones.SCHEMA+"."+AccionistaConstantesFunciones.TABLENAME+".participacion,"+AccionistaConstantesFunciones.SCHEMA+"."+AccionistaConstantesFunciones.TABLENAME+".esactivo from "+AccionistaConstantesFunciones.SCHEMA+"."+AccionistaConstantesFunciones.TABLENAME;//+" as "+AccionistaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+AccionistaConstantesFunciones.SCHEMA+"."+AccionistaConstantesFunciones.TABLENAME+".id,"+AccionistaConstantesFunciones.SCHEMA+"."+AccionistaConstantesFunciones.TABLENAME+".version_row from "+AccionistaConstantesFunciones.SCHEMA+"."+AccionistaConstantesFunciones.TABLENAME;//+" as "+AccionistaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+AccionistaConstantesFunciones.SCHEMA+"."+AccionistaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,idcliente=?,idvalorclienteinversion=?,idvaloridentificacion=?,identificacion=?,apellidopaterno=?,apellidomaterno=?,primernombre=?,segundonombre=?,nombrecorto=?,participacion=?,esactivo=?";
	
	public static String STOREPROCEDUREINSERT="call SP_ACCIONISTA_INSERT(?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_ACCIONISTA_UPDATE(?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_ACCIONISTA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_ACCIONISTA_SELECT(?,?)";
	
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
	
	
	protected AccionistaDataAccessAdditional accionistaDataAccessAdditional=null;
	
	public AccionistaDataAccessAdditional getAccionistaDataAccessAdditional() {
		return this.accionistaDataAccessAdditional;
	}
	
	public void setAccionistaDataAccessAdditional(AccionistaDataAccessAdditional accionistaDataAccessAdditional) {
		try {
			this.accionistaDataAccessAdditional=accionistaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public AccionistaDataAccess() {
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
		AccionistaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		AccionistaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		AccionistaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setAccionistaOriginal(Accionista accionista)throws Exception  {
		accionista.setAccionistaOriginal((Accionista)accionista.clone());		
	}
	
	public void setAccionistasOriginal(List<Accionista> accionistas)throws Exception  {
		
		for(Accionista accionista:accionistas){
			accionista.setAccionistaOriginal((Accionista)accionista.clone());
		}
	}
	
	public static void setAccionistaOriginalStatic(Accionista accionista)throws Exception  {
		accionista.setAccionistaOriginal((Accionista)accionista.clone());		
	}
	
	public static void setAccionistasOriginalStatic(List<Accionista> accionistas)throws Exception  {
		
		for(Accionista accionista:accionistas){
			accionista.setAccionistaOriginal((Accionista)accionista.clone());
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
	
	public  Accionista getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		Accionista entity = new Accionista();		
		
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
	
	public  Accionista getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		Accionista entity = new Accionista();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=AccionistaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=AccionistaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Cartera.Accionista.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setAccionistaOriginal(new Accionista());
      	    	entity=super.getEntity("",entity,resultSet,AccionistaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityAccionista("",entity,resultSet); 
				
				//entity.setAccionistaOriginal(super.getEntity("",entity.getAccionistaOriginal(),resultSet,AccionistaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setAccionistaOriginal(this.getEntityAccionista("",entity.getAccionistaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseAccionista(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  Accionista getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Accionista entity = new Accionista();
				
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
	
	public  Accionista getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Accionista entity = new Accionista();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=AccionistaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=AccionistaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AccionistaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.Accionista.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setAccionistaOriginal(new Accionista());
      	    	entity=super.getEntity("",entity,resultSet,AccionistaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityAccionista("",entity,resultSet);    
				
				//entity.setAccionistaOriginal(super.getEntity("",entity.getAccionistaOriginal(),resultSet,AccionistaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setAccionistaOriginal(this.getEntityAccionista("",entity.getAccionistaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseAccionista(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //Accionista
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		Accionista entity = new Accionista();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=AccionistaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=AccionistaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AccionistaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.Accionista.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseAccionista(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<Accionista> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Accionista> entities = new  ArrayList<Accionista>();
		Accionista entity = new Accionista();		  
		
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
	
	public  List<Accionista> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Accionista> entities = new  ArrayList<Accionista>();
		Accionista entity = new Accionista();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=AccionistaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=AccionistaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AccionistaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Accionista();
      	    	entity=super.getEntity("",entity,resultSet,AccionistaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityAccionista("",entity,resultSet);
      	    	
				//entity.setAccionistaOriginal( new Accionista());
      	    	//entity.setAccionistaOriginal(super.getEntity("",entity.getAccionistaOriginal(),resultSet,AccionistaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setAccionistaOriginal(this.getEntityAccionista("",entity.getAccionistaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseAccionistas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAccionista(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Accionista> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Accionista> entities = new  ArrayList<Accionista>();
		Accionista entity = new Accionista();		  
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
	
	public  List<Accionista> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Accionista> entities = new  ArrayList<Accionista>();
		Accionista entity = new Accionista();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Accionista();
				
				if(conMapGenerico) {
					entity.inicializarMapAccionista();
					//entity.setMapAccionista(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapAccionistaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapAccionista().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,AccionistaDataAccess.ISWITHSCHEMA);         		
					entity=AccionistaDataAccess.getEntityAccionista("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setAccionistaOriginal( new Accionista());
					////entity.setAccionistaOriginal(super.getEntity("",entity.getAccionistaOriginal(),resultSet,AccionistaDataAccess.ISWITHSCHEMA));         		
					////entity.setAccionistaOriginal(this.getEntityAccionista("",entity.getAccionistaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseAccionistas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAccionista(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public Accionista getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Accionista entity = new Accionista();		  
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
	
	public  Accionista getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Accionista entity = new Accionista();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Accionista();
				
				if(conMapGenerico) {
					entity.inicializarMapAccionista();
					//entity.setMapAccionista(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapAccionistaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapAccionista().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,AccionistaDataAccess.ISWITHSCHEMA);         		
					entity=AccionistaDataAccess.getEntityAccionista("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setAccionistaOriginal( new Accionista());
					////entity.setAccionistaOriginal(super.getEntity("",entity.getAccionistaOriginal(),resultSet,AccionistaDataAccess.ISWITHSCHEMA));         		
					////entity.setAccionistaOriginal(this.getEntityAccionista("",entity.getAccionistaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseAccionista(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAccionista(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static Accionista getEntityAccionista(String strPrefijo,Accionista entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = Accionista.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = Accionista.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					AccionistaDataAccess.setFieldReflectionAccionista(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasAccionista=AccionistaConstantesFunciones.getTodosTiposColumnasAccionista();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasAccionista) {
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
							field = Accionista.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = Accionista.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						AccionistaDataAccess.setFieldReflectionAccionista(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionAccionista(Field field,String strPrefijo,String sColumn,Accionista entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case AccionistaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AccionistaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case AccionistaConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AccionistaConstantesFunciones.IDTIPOINVERSION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AccionistaConstantesFunciones.IDTIPOIDENTIFICACION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AccionistaConstantesFunciones.IDENTIFICACION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case AccionistaConstantesFunciones.APELLIDOPATERNO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case AccionistaConstantesFunciones.APELLIDOMATERNO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case AccionistaConstantesFunciones.PRIMERNOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case AccionistaConstantesFunciones.SEGUNDONOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case AccionistaConstantesFunciones.NOMBRECORTO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case AccionistaConstantesFunciones.PARTICIPACION:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case AccionistaConstantesFunciones.ESACTIVO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Accionista>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<Accionista> entities = new  ArrayList<Accionista>();
		Accionista entity = new Accionista();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=AccionistaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=AccionistaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AccionistaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new Accionista();
					entity=super.getEntity("",entity,resultSet,AccionistaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityAccionista("",entity,resultSet);
					
					//entity.setAccionistaOriginal( new Accionista());
					//entity.setAccionistaOriginal(super.getEntity("",entity.getAccionistaOriginal(),resultSet,AccionistaDataAccess.ISWITHSCHEMA));         		
					//entity.setAccionistaOriginal(this.getEntityAccionista("",entity.getAccionistaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseAccionistas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAccionista(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Accionista>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<Accionista> entities = new  ArrayList<Accionista>();
		Accionista entity = new Accionista();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=AccionistaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=AccionistaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AccionistaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<Accionista> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Accionista> entities = new  ArrayList<Accionista>();
		Accionista entity = new Accionista();		  
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
	
	public  List<Accionista> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Accionista> entities = new  ArrayList<Accionista>();
		Accionista entity = new Accionista();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Accionista();
      	    	entity=super.getEntity("",entity,resultSet,AccionistaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityAccionista("",entity,resultSet);
      	    	
				//entity.setAccionistaOriginal( new Accionista());
      	    	//entity.setAccionistaOriginal(super.getEntity("",entity.getAccionistaOriginal(),resultSet,AccionistaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setAccionistaOriginal(this.getEntityAccionista("",entity.getAccionistaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseAccionistas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAccionista(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Accionista> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Accionista> entities = new  ArrayList<Accionista>();
		Accionista entity = new Accionista();		  
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
	
	public  List<Accionista> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Accionista> entities = new  ArrayList<Accionista>();
		Accionista entity = new Accionista();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Accionista();
      	    	entity=super.getEntity("",entity,resultSet,AccionistaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityAccionista("",entity,resultSet);
      	    	
				//entity.setAccionistaOriginal( new Accionista());
      	    	//entity.setAccionistaOriginal(super.getEntity("",entity.getAccionistaOriginal(),resultSet,AccionistaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setAccionistaOriginal(this.getEntityAccionista("",entity.getAccionistaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseAccionistas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public Accionista getEntityAccionista(String strPrefijo,Accionista entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setidcliente(resultSet.getLong(strPrefijo+AccionistaConstantesFunciones.IDCLIENTE));
				entity.setidvalorclienteinversion(resultSet.getLong(strPrefijo+AccionistaConstantesFunciones.IDTIPOINVERSION));
				entity.setidvaloridentificacion(resultSet.getLong(strPrefijo+AccionistaConstantesFunciones.IDTIPOIDENTIFICACION));
				entity.setidentificacion(resultSet.getString(strPrefijo+AccionistaConstantesFunciones.IDENTIFICACION));
				entity.setapellidopaterno(resultSet.getString(strPrefijo+AccionistaConstantesFunciones.APELLIDOPATERNO));
				entity.setapellidomaterno(resultSet.getString(strPrefijo+AccionistaConstantesFunciones.APELLIDOMATERNO));
				entity.setprimernombre(resultSet.getString(strPrefijo+AccionistaConstantesFunciones.PRIMERNOMBRE));
				entity.setsegundonombre(resultSet.getString(strPrefijo+AccionistaConstantesFunciones.SEGUNDONOMBRE));
				entity.setnombrecorto(resultSet.getString(strPrefijo+AccionistaConstantesFunciones.NOMBRECORTO));
				entity.setparticipacion(resultSet.getInt(strPrefijo+AccionistaConstantesFunciones.PARTICIPACION));
				entity.setesactivo(resultSet.getBoolean(strPrefijo+AccionistaConstantesFunciones.ESACTIVO));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowAccionista(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(Accionista entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=AccionistaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=AccionistaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=AccionistaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=AccionistaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(AccionistaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,AccionistaDataAccess.TABLENAME,AccionistaDataAccess.ISWITHSTOREPROCEDURES);
			
			AccionistaDataAccess.setAccionistaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Cliente getCliente(Connexion connexion,Accionista relaccionista)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,relaccionista.getidcliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public TipoInversion getTipoInversion(Connexion connexion,Accionista relaccionista)throws SQLException,Exception {

		TipoInversion tipoinversion= new TipoInversion();

		try {
			TipoInversionDataAccess tipoinversionDataAccess=new TipoInversionDataAccess();

			tipoinversionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoinversionDataAccess.setConnexionType(this.connexionType);
			tipoinversionDataAccess.setParameterDbType(this.parameterDbType);

			tipoinversion=tipoinversionDataAccess.getEntity(connexion,relaccionista.getidvalorclienteinversion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoinversion;

	}

	public TipoIdentificacion getTipoIdentificacion(Connexion connexion,Accionista relaccionista)throws SQLException,Exception {

		TipoIdentificacion tipoidentificacion= new TipoIdentificacion();

		try {
			TipoIdentificacionDataAccess tipoidentificacionDataAccess=new TipoIdentificacionDataAccess();

			tipoidentificacionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoidentificacionDataAccess.setConnexionType(this.connexionType);
			tipoidentificacionDataAccess.setParameterDbType(this.parameterDbType);

			tipoidentificacion=tipoidentificacionDataAccess.getEntity(connexion,relaccionista.getidvaloridentificacion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoidentificacion;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,Accionista accionista) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!accionista.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueidcliente=new ParameterValue<Long>();
					parameterMaintenanceValueidcliente.setValue(accionista.getidcliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueidcliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueidvalorclienteinversion=new ParameterValue<Long>();
					parameterMaintenanceValueidvalorclienteinversion.setValue(accionista.getidvalorclienteinversion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueidvalorclienteinversion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueidvaloridentificacion=new ParameterValue<Long>();
					parameterMaintenanceValueidvaloridentificacion.setValue(accionista.getidvaloridentificacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueidvaloridentificacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueidentificacion=new ParameterValue<String>();
					parameterMaintenanceValueidentificacion.setValue(accionista.getidentificacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueidentificacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueapellidopaterno=new ParameterValue<String>();
					parameterMaintenanceValueapellidopaterno.setValue(accionista.getapellidopaterno());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueapellidopaterno);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueapellidomaterno=new ParameterValue<String>();
					parameterMaintenanceValueapellidomaterno.setValue(accionista.getapellidomaterno());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueapellidomaterno);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueprimernombre=new ParameterValue<String>();
					parameterMaintenanceValueprimernombre.setValue(accionista.getprimernombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueprimernombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuesegundonombre=new ParameterValue<String>();
					parameterMaintenanceValuesegundonombre.setValue(accionista.getsegundonombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesegundonombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombrecorto=new ParameterValue<String>();
					parameterMaintenanceValuenombrecorto.setValue(accionista.getnombrecorto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombrecorto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValueparticipacion=new ParameterValue<Integer>();
					parameterMaintenanceValueparticipacion.setValue(accionista.getparticipacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueparticipacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValueesactivo=new ParameterValue<Boolean>();
					parameterMaintenanceValueesactivo.setValue(accionista.getesactivo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueesactivo);
					parametersTemp.add(parameterMaintenance);
					
						if(!accionista.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(accionista.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(accionista.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(accionista.getId());
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
	
	public void setIsNewIsChangedFalseAccionista(Accionista accionista)throws Exception  {		
		accionista.setIsNew(false);
		accionista.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseAccionistas(List<Accionista> accionistas)throws Exception  {				
		for(Accionista accionista:accionistas) {
			accionista.setIsNew(false);
			accionista.setIsChanged(false);
		}
	}
	
	public void generarExportarAccionista(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
