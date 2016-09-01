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
import com.bydan.framework.erp.business.dataaccess.DataAccessHelperSinIdGenerated;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.nomina.util.*;//EstadoSolicitudNomiConstantesFunciones;










@SuppressWarnings("unused")
final public class EstadoSolicitudNomiDataAccess extends  EstadoSolicitudNomiDataAccessAdditional{ //EstadoSolicitudNomiDataAccessAdditional,DataAccessHelper<EstadoSolicitudNomi>
	//static Logger logger = Logger.getLogger(EstadoSolicitudNomiDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="estado_solicitud_nomi";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+EstadoSolicitudNomiConstantesFunciones.SCHEMA+"."+EstadoSolicitudNomiConstantesFunciones.TABLENAME+"(id,version_row,codigo,nombre)values(?,current_timestamp,?,?)";
	public static String QUERYUPDATE="update "+EstadoSolicitudNomiConstantesFunciones.SCHEMA+"."+EstadoSolicitudNomiConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+EstadoSolicitudNomiConstantesFunciones.SCHEMA+"."+EstadoSolicitudNomiConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select estadosolicitudnomi from "+EstadoSolicitudNomiConstantesFunciones.SPERSISTENCENAME+" estadosolicitudnomi";
	public static String QUERYSELECTNATIVE="select "+EstadoSolicitudNomiConstantesFunciones.SCHEMA+"."+EstadoSolicitudNomiConstantesFunciones.TABLENAME+".id,"+EstadoSolicitudNomiConstantesFunciones.SCHEMA+"."+EstadoSolicitudNomiConstantesFunciones.TABLENAME+".version_row,"+EstadoSolicitudNomiConstantesFunciones.SCHEMA+"."+EstadoSolicitudNomiConstantesFunciones.TABLENAME+".codigo,"+EstadoSolicitudNomiConstantesFunciones.SCHEMA+"."+EstadoSolicitudNomiConstantesFunciones.TABLENAME+".nombre from "+EstadoSolicitudNomiConstantesFunciones.SCHEMA+"."+EstadoSolicitudNomiConstantesFunciones.TABLENAME;//+" as "+EstadoSolicitudNomiConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+EstadoSolicitudNomiConstantesFunciones.SCHEMA+"."+EstadoSolicitudNomiConstantesFunciones.TABLENAME+".id,"+EstadoSolicitudNomiConstantesFunciones.SCHEMA+"."+EstadoSolicitudNomiConstantesFunciones.TABLENAME+".version_row,"+EstadoSolicitudNomiConstantesFunciones.SCHEMA+"."+EstadoSolicitudNomiConstantesFunciones.TABLENAME+".codigo from "+EstadoSolicitudNomiConstantesFunciones.SCHEMA+"."+EstadoSolicitudNomiConstantesFunciones.TABLENAME;//+" as "+EstadoSolicitudNomiConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+EstadoSolicitudNomiConstantesFunciones.SCHEMA+"."+EstadoSolicitudNomiConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_ESTADOSOLICITUDNOMI_INSERT(?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_ESTADOSOLICITUDNOMI_UPDATE(?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_ESTADOSOLICITUDNOMI_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_ESTADOSOLICITUDNOMI_SELECT(?,?)";
	
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
	
	
	protected EstadoSolicitudNomiDataAccessAdditional estadosolicitudnomiDataAccessAdditional=null;
	
	public EstadoSolicitudNomiDataAccessAdditional getEstadoSolicitudNomiDataAccessAdditional() {
		return this.estadosolicitudnomiDataAccessAdditional;
	}
	
	public void setEstadoSolicitudNomiDataAccessAdditional(EstadoSolicitudNomiDataAccessAdditional estadosolicitudnomiDataAccessAdditional) {
		try {
			this.estadosolicitudnomiDataAccessAdditional=estadosolicitudnomiDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public EstadoSolicitudNomiDataAccess() {
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
		EstadoSolicitudNomiDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		EstadoSolicitudNomiDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		EstadoSolicitudNomiDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setEstadoSolicitudNomiOriginal(EstadoSolicitudNomi estadosolicitudnomi)throws Exception  {
		estadosolicitudnomi.setEstadoSolicitudNomiOriginal((EstadoSolicitudNomi)estadosolicitudnomi.clone());		
	}
	
	public void setEstadoSolicitudNomisOriginal(List<EstadoSolicitudNomi> estadosolicitudnomis)throws Exception  {
		
		for(EstadoSolicitudNomi estadosolicitudnomi:estadosolicitudnomis){
			estadosolicitudnomi.setEstadoSolicitudNomiOriginal((EstadoSolicitudNomi)estadosolicitudnomi.clone());
		}
	}
	
	public static void setEstadoSolicitudNomiOriginalStatic(EstadoSolicitudNomi estadosolicitudnomi)throws Exception  {
		estadosolicitudnomi.setEstadoSolicitudNomiOriginal((EstadoSolicitudNomi)estadosolicitudnomi.clone());		
	}
	
	public static void setEstadoSolicitudNomisOriginalStatic(List<EstadoSolicitudNomi> estadosolicitudnomis)throws Exception  {
		
		for(EstadoSolicitudNomi estadosolicitudnomi:estadosolicitudnomis){
			estadosolicitudnomi.setEstadoSolicitudNomiOriginal((EstadoSolicitudNomi)estadosolicitudnomi.clone());
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
	
	public  EstadoSolicitudNomi getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		EstadoSolicitudNomi entity = new EstadoSolicitudNomi();		
		
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
	
	public  EstadoSolicitudNomi getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		EstadoSolicitudNomi entity = new EstadoSolicitudNomi();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoSolicitudNomiDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoSolicitudNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.EstadoSolicitudNomi.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setEstadoSolicitudNomiOriginal(new EstadoSolicitudNomi());
      	    	entity=super.getEntity("",entity,resultSet,EstadoSolicitudNomiDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEstadoSolicitudNomi("",entity,resultSet); 
				
				//entity.setEstadoSolicitudNomiOriginal(super.getEntity("",entity.getEstadoSolicitudNomiOriginal(),resultSet,EstadoSolicitudNomiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoSolicitudNomiOriginal(this.getEntityEstadoSolicitudNomi("",entity.getEstadoSolicitudNomiOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseEstadoSolicitudNomi(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  EstadoSolicitudNomi getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EstadoSolicitudNomi entity = new EstadoSolicitudNomi();
				
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
	
	public  EstadoSolicitudNomi getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EstadoSolicitudNomi entity = new EstadoSolicitudNomi();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoSolicitudNomiDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoSolicitudNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoSolicitudNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.EstadoSolicitudNomi.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setEstadoSolicitudNomiOriginal(new EstadoSolicitudNomi());
      	    	entity=super.getEntity("",entity,resultSet,EstadoSolicitudNomiDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEstadoSolicitudNomi("",entity,resultSet);    
				
				//entity.setEstadoSolicitudNomiOriginal(super.getEntity("",entity.getEstadoSolicitudNomiOriginal(),resultSet,EstadoSolicitudNomiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoSolicitudNomiOriginal(this.getEntityEstadoSolicitudNomi("",entity.getEstadoSolicitudNomiOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseEstadoSolicitudNomi(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //EstadoSolicitudNomi
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		EstadoSolicitudNomi entity = new EstadoSolicitudNomi();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoSolicitudNomiDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoSolicitudNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoSolicitudNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.EstadoSolicitudNomi.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseEstadoSolicitudNomi(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<EstadoSolicitudNomi> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EstadoSolicitudNomi> entities = new  ArrayList<EstadoSolicitudNomi>();
		EstadoSolicitudNomi entity = new EstadoSolicitudNomi();		  
		
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
	
	public  List<EstadoSolicitudNomi> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EstadoSolicitudNomi> entities = new  ArrayList<EstadoSolicitudNomi>();
		EstadoSolicitudNomi entity = new EstadoSolicitudNomi();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoSolicitudNomiDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoSolicitudNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoSolicitudNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoSolicitudNomi();
      	    	entity=super.getEntity("",entity,resultSet,EstadoSolicitudNomiDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoSolicitudNomi("",entity,resultSet);
      	    	
				//entity.setEstadoSolicitudNomiOriginal( new EstadoSolicitudNomi());
      	    	//entity.setEstadoSolicitudNomiOriginal(super.getEntity("",entity.getEstadoSolicitudNomiOriginal(),resultSet,EstadoSolicitudNomiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoSolicitudNomiOriginal(this.getEntityEstadoSolicitudNomi("",entity.getEstadoSolicitudNomiOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoSolicitudNomis(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoSolicitudNomi(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<EstadoSolicitudNomi> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EstadoSolicitudNomi> entities = new  ArrayList<EstadoSolicitudNomi>();
		EstadoSolicitudNomi entity = new EstadoSolicitudNomi();		  
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
	
	public  List<EstadoSolicitudNomi> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EstadoSolicitudNomi> entities = new  ArrayList<EstadoSolicitudNomi>();
		EstadoSolicitudNomi entity = new EstadoSolicitudNomi();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoSolicitudNomi();
				
				if(conMapGenerico) {
					entity.inicializarMapEstadoSolicitudNomi();
					//entity.setMapEstadoSolicitudNomi(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapEstadoSolicitudNomiValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEstadoSolicitudNomi().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EstadoSolicitudNomiDataAccess.ISWITHSCHEMA);         		
					entity=EstadoSolicitudNomiDataAccess.getEntityEstadoSolicitudNomi("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEstadoSolicitudNomiOriginal( new EstadoSolicitudNomi());
					////entity.setEstadoSolicitudNomiOriginal(super.getEntity("",entity.getEstadoSolicitudNomiOriginal(),resultSet,EstadoSolicitudNomiDataAccess.ISWITHSCHEMA));         		
					////entity.setEstadoSolicitudNomiOriginal(this.getEntityEstadoSolicitudNomi("",entity.getEstadoSolicitudNomiOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoSolicitudNomis(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoSolicitudNomi(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public EstadoSolicitudNomi getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EstadoSolicitudNomi entity = new EstadoSolicitudNomi();		  
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
	
	public  EstadoSolicitudNomi getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EstadoSolicitudNomi entity = new EstadoSolicitudNomi();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoSolicitudNomi();
				
				if(conMapGenerico) {
					entity.inicializarMapEstadoSolicitudNomi();
					//entity.setMapEstadoSolicitudNomi(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapEstadoSolicitudNomiValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEstadoSolicitudNomi().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EstadoSolicitudNomiDataAccess.ISWITHSCHEMA);         		
					entity=EstadoSolicitudNomiDataAccess.getEntityEstadoSolicitudNomi("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEstadoSolicitudNomiOriginal( new EstadoSolicitudNomi());
					////entity.setEstadoSolicitudNomiOriginal(super.getEntity("",entity.getEstadoSolicitudNomiOriginal(),resultSet,EstadoSolicitudNomiDataAccess.ISWITHSCHEMA));         		
					////entity.setEstadoSolicitudNomiOriginal(this.getEntityEstadoSolicitudNomi("",entity.getEstadoSolicitudNomiOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseEstadoSolicitudNomi(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoSolicitudNomi(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static EstadoSolicitudNomi getEntityEstadoSolicitudNomi(String strPrefijo,EstadoSolicitudNomi entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = EstadoSolicitudNomi.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = EstadoSolicitudNomi.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					EstadoSolicitudNomiDataAccess.setFieldReflectionEstadoSolicitudNomi(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasEstadoSolicitudNomi=EstadoSolicitudNomiConstantesFunciones.getTodosTiposColumnasEstadoSolicitudNomi();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasEstadoSolicitudNomi) {
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
							field = EstadoSolicitudNomi.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = EstadoSolicitudNomi.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						EstadoSolicitudNomiDataAccess.setFieldReflectionEstadoSolicitudNomi(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionEstadoSolicitudNomi(Field field,String strPrefijo,String sColumn,EstadoSolicitudNomi entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case EstadoSolicitudNomiConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EstadoSolicitudNomiConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EstadoSolicitudNomiConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EstadoSolicitudNomiConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EstadoSolicitudNomi>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<EstadoSolicitudNomi> entities = new  ArrayList<EstadoSolicitudNomi>();
		EstadoSolicitudNomi entity = new EstadoSolicitudNomi();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoSolicitudNomiDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoSolicitudNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoSolicitudNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new EstadoSolicitudNomi();
					entity=super.getEntity("",entity,resultSet,EstadoSolicitudNomiDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityEstadoSolicitudNomi("",entity,resultSet);
					
					//entity.setEstadoSolicitudNomiOriginal( new EstadoSolicitudNomi());
					//entity.setEstadoSolicitudNomiOriginal(super.getEntity("",entity.getEstadoSolicitudNomiOriginal(),resultSet,EstadoSolicitudNomiDataAccess.ISWITHSCHEMA));         		
					//entity.setEstadoSolicitudNomiOriginal(this.getEntityEstadoSolicitudNomi("",entity.getEstadoSolicitudNomiOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseEstadoSolicitudNomis(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoSolicitudNomi(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EstadoSolicitudNomi>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<EstadoSolicitudNomi> entities = new  ArrayList<EstadoSolicitudNomi>();
		EstadoSolicitudNomi entity = new EstadoSolicitudNomi();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoSolicitudNomiDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoSolicitudNomiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoSolicitudNomiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<EstadoSolicitudNomi> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoSolicitudNomi> entities = new  ArrayList<EstadoSolicitudNomi>();
		EstadoSolicitudNomi entity = new EstadoSolicitudNomi();		  
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
	
	public  List<EstadoSolicitudNomi> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoSolicitudNomi> entities = new  ArrayList<EstadoSolicitudNomi>();
		EstadoSolicitudNomi entity = new EstadoSolicitudNomi();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoSolicitudNomi();
      	    	entity=super.getEntity("",entity,resultSet,EstadoSolicitudNomiDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoSolicitudNomi("",entity,resultSet);
      	    	
				//entity.setEstadoSolicitudNomiOriginal( new EstadoSolicitudNomi());
      	    	//entity.setEstadoSolicitudNomiOriginal(super.getEntity("",entity.getEstadoSolicitudNomiOriginal(),resultSet,EstadoSolicitudNomiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoSolicitudNomiOriginal(this.getEntityEstadoSolicitudNomi("",entity.getEstadoSolicitudNomiOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseEstadoSolicitudNomis(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoSolicitudNomi(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<EstadoSolicitudNomi> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoSolicitudNomi> entities = new  ArrayList<EstadoSolicitudNomi>();
		EstadoSolicitudNomi entity = new EstadoSolicitudNomi();		  
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
	
	public  List<EstadoSolicitudNomi> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoSolicitudNomi> entities = new  ArrayList<EstadoSolicitudNomi>();
		EstadoSolicitudNomi entity = new EstadoSolicitudNomi();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoSolicitudNomi();
      	    	entity=super.getEntity("",entity,resultSet,EstadoSolicitudNomiDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoSolicitudNomi("",entity,resultSet);
      	    	
				//entity.setEstadoSolicitudNomiOriginal( new EstadoSolicitudNomi());
      	    	//entity.setEstadoSolicitudNomiOriginal(super.getEntity("",entity.getEstadoSolicitudNomiOriginal(),resultSet,EstadoSolicitudNomiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoSolicitudNomiOriginal(this.getEntityEstadoSolicitudNomi("",entity.getEstadoSolicitudNomiOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoSolicitudNomis(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public EstadoSolicitudNomi getEntityEstadoSolicitudNomi(String strPrefijo,EstadoSolicitudNomi entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setcodigo(resultSet.getString(strPrefijo+EstadoSolicitudNomiConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+EstadoSolicitudNomiConstantesFunciones.NOMBRE));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+EstadoSolicitudNomiConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowEstadoSolicitudNomi(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(EstadoSolicitudNomi entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=EstadoSolicitudNomiDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=EstadoSolicitudNomiDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=EstadoSolicitudNomiDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=EstadoSolicitudNomiDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(EstadoSolicitudNomiConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,EstadoSolicitudNomiDataAccess.TABLENAME,EstadoSolicitudNomiDataAccess.ISWITHSTOREPROCEDURES);
			
			EstadoSolicitudNomiDataAccess.setEstadoSolicitudNomiOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
	
		
		public List<SolicitudReemplazo> getSolicitudReemplazos(Connexion connexion,EstadoSolicitudNomi estadosolicitudnomi)throws SQLException,Exception {

		List<SolicitudReemplazo> solicitudreemplazos= new ArrayList<SolicitudReemplazo>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstadoSolicitudNomiConstantesFunciones.SCHEMA+".estado_solicitud_nomi ON "+SolicitudReemplazoConstantesFunciones.SCHEMA+".solicitud_reemplazo.id_estado_solicitud_nomi="+EstadoSolicitudNomiConstantesFunciones.SCHEMA+".estado_solicitud_nomi.id WHERE "+EstadoSolicitudNomiConstantesFunciones.SCHEMA+".estado_solicitud_nomi.id="+String.valueOf(estadosolicitudnomi.getId());
			} else {
				sQuery=" INNER JOIN solicitudreemplazo.EstadoSolicitudNomi WHERE solicitudreemplazo.EstadoSolicitudNomi.id="+String.valueOf(estadosolicitudnomi.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			SolicitudReemplazoDataAccess solicitudreemplazoDataAccess=new SolicitudReemplazoDataAccess();

			solicitudreemplazoDataAccess.setConnexionType(this.connexionType);
			solicitudreemplazoDataAccess.setParameterDbType(this.parameterDbType);
			solicitudreemplazos=solicitudreemplazoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return solicitudreemplazos;

	}

	public List<SolicitudHoraExtra> getSolicitudHoraExtras(Connexion connexion,EstadoSolicitudNomi estadosolicitudnomi)throws SQLException,Exception {

		List<SolicitudHoraExtra> solicitudhoraextras= new ArrayList<SolicitudHoraExtra>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstadoSolicitudNomiConstantesFunciones.SCHEMA+".estado_solicitud_nomi ON "+SolicitudHoraExtraConstantesFunciones.SCHEMA+".solicitud_hora_extra.id_estado_solicitud_nomi="+EstadoSolicitudNomiConstantesFunciones.SCHEMA+".estado_solicitud_nomi.id WHERE "+EstadoSolicitudNomiConstantesFunciones.SCHEMA+".estado_solicitud_nomi.id="+String.valueOf(estadosolicitudnomi.getId());
			} else {
				sQuery=" INNER JOIN solicitudhoraextra.EstadoSolicitudNomi WHERE solicitudhoraextra.EstadoSolicitudNomi.id="+String.valueOf(estadosolicitudnomi.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			SolicitudHoraExtraDataAccess solicitudhoraextraDataAccess=new SolicitudHoraExtraDataAccess();

			solicitudhoraextraDataAccess.setConnexionType(this.connexionType);
			solicitudhoraextraDataAccess.setParameterDbType(this.parameterDbType);
			solicitudhoraextras=solicitudhoraextraDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return solicitudhoraextras;

	}

	public List<SolicitudVacacion> getSolicitudVacacions(Connexion connexion,EstadoSolicitudNomi estadosolicitudnomi)throws SQLException,Exception {

		List<SolicitudVacacion> solicitudvacacions= new ArrayList<SolicitudVacacion>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstadoSolicitudNomiConstantesFunciones.SCHEMA+".estado_solicitud_nomi ON "+SolicitudVacacionConstantesFunciones.SCHEMA+".solicitud_vacacion.id_estado_solicitud_nomi="+EstadoSolicitudNomiConstantesFunciones.SCHEMA+".estado_solicitud_nomi.id WHERE "+EstadoSolicitudNomiConstantesFunciones.SCHEMA+".estado_solicitud_nomi.id="+String.valueOf(estadosolicitudnomi.getId());
			} else {
				sQuery=" INNER JOIN solicitudvacacion.EstadoSolicitudNomi WHERE solicitudvacacion.EstadoSolicitudNomi.id="+String.valueOf(estadosolicitudnomi.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			SolicitudVacacionDataAccess solicitudvacacionDataAccess=new SolicitudVacacionDataAccess();

			solicitudvacacionDataAccess.setConnexionType(this.connexionType);
			solicitudvacacionDataAccess.setParameterDbType(this.parameterDbType);
			solicitudvacacions=solicitudvacacionDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return solicitudvacacions;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,EstadoSolicitudNomi estadosolicitudnomi) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!estadosolicitudnomi.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid=new ParameterValue<Long>();
					parameterMaintenanceValueid.setValue(estadosolicitudnomi.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(estadosolicitudnomi.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(estadosolicitudnomi.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!estadosolicitudnomi.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(estadosolicitudnomi.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(estadosolicitudnomi.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(estadosolicitudnomi.getId());
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
	
	public void setIsNewIsChangedFalseEstadoSolicitudNomi(EstadoSolicitudNomi estadosolicitudnomi)throws Exception  {		
		estadosolicitudnomi.setIsNew(false);
		estadosolicitudnomi.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseEstadoSolicitudNomis(List<EstadoSolicitudNomi> estadosolicitudnomis)throws Exception  {				
		for(EstadoSolicitudNomi estadosolicitudnomi:estadosolicitudnomis) {
			estadosolicitudnomi.setIsNew(false);
			estadosolicitudnomi.setIsChanged(false);
		}
	}
	
	public void generarExportarEstadoSolicitudNomi(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
