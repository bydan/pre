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
package com.bydan.erp.facturacion.business.dataaccess;

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

import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.facturacion.util.*;//EstadoFactuImpreConstantesFunciones;










@SuppressWarnings("unused")
final public class EstadoFactuImpreDataAccess extends  EstadoFactuImpreDataAccessAdditional{ //EstadoFactuImpreDataAccessAdditional,DataAccessHelper<EstadoFactuImpre>
	//static Logger logger = Logger.getLogger(EstadoFactuImpreDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="estado_factu_impre";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+EstadoFactuImpreConstantesFunciones.SCHEMA+"."+EstadoFactuImpreConstantesFunciones.TABLENAME+"(version_row,codigo,nombre)values(current_timestamp,?,?)";
	public static String QUERYUPDATE="update "+EstadoFactuImpreConstantesFunciones.SCHEMA+"."+EstadoFactuImpreConstantesFunciones.TABLENAME+" set version_row=current_timestamp,codigo=?,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+EstadoFactuImpreConstantesFunciones.SCHEMA+"."+EstadoFactuImpreConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select estadofactuimpre from "+EstadoFactuImpreConstantesFunciones.SPERSISTENCENAME+" estadofactuimpre";
	public static String QUERYSELECTNATIVE="select "+EstadoFactuImpreConstantesFunciones.SCHEMA+"."+EstadoFactuImpreConstantesFunciones.TABLENAME+".id,"+EstadoFactuImpreConstantesFunciones.SCHEMA+"."+EstadoFactuImpreConstantesFunciones.TABLENAME+".version_row,"+EstadoFactuImpreConstantesFunciones.SCHEMA+"."+EstadoFactuImpreConstantesFunciones.TABLENAME+".codigo,"+EstadoFactuImpreConstantesFunciones.SCHEMA+"."+EstadoFactuImpreConstantesFunciones.TABLENAME+".nombre from "+EstadoFactuImpreConstantesFunciones.SCHEMA+"."+EstadoFactuImpreConstantesFunciones.TABLENAME;//+" as "+EstadoFactuImpreConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+EstadoFactuImpreConstantesFunciones.SCHEMA+"."+EstadoFactuImpreConstantesFunciones.TABLENAME+".id,"+EstadoFactuImpreConstantesFunciones.SCHEMA+"."+EstadoFactuImpreConstantesFunciones.TABLENAME+".version_row,"+EstadoFactuImpreConstantesFunciones.SCHEMA+"."+EstadoFactuImpreConstantesFunciones.TABLENAME+".codigo from "+EstadoFactuImpreConstantesFunciones.SCHEMA+"."+EstadoFactuImpreConstantesFunciones.TABLENAME;//+" as "+EstadoFactuImpreConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+EstadoFactuImpreConstantesFunciones.SCHEMA+"."+EstadoFactuImpreConstantesFunciones.TABLENAME+" set version_row=current_timestamp,codigo=?,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_ESTADOFACTUIMPRE_INSERT(?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_ESTADOFACTUIMPRE_UPDATE(?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_ESTADOFACTUIMPRE_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_ESTADOFACTUIMPRE_SELECT(?,?)";
	
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
	
	
	protected EstadoFactuImpreDataAccessAdditional estadofactuimpreDataAccessAdditional=null;
	
	public EstadoFactuImpreDataAccessAdditional getEstadoFactuImpreDataAccessAdditional() {
		return this.estadofactuimpreDataAccessAdditional;
	}
	
	public void setEstadoFactuImpreDataAccessAdditional(EstadoFactuImpreDataAccessAdditional estadofactuimpreDataAccessAdditional) {
		try {
			this.estadofactuimpreDataAccessAdditional=estadofactuimpreDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public EstadoFactuImpreDataAccess() {
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
		EstadoFactuImpreDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		EstadoFactuImpreDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		EstadoFactuImpreDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setEstadoFactuImpreOriginal(EstadoFactuImpre estadofactuimpre)throws Exception  {
		estadofactuimpre.setEstadoFactuImpreOriginal((EstadoFactuImpre)estadofactuimpre.clone());		
	}
	
	public void setEstadoFactuImpresOriginal(List<EstadoFactuImpre> estadofactuimpres)throws Exception  {
		
		for(EstadoFactuImpre estadofactuimpre:estadofactuimpres){
			estadofactuimpre.setEstadoFactuImpreOriginal((EstadoFactuImpre)estadofactuimpre.clone());
		}
	}
	
	public static void setEstadoFactuImpreOriginalStatic(EstadoFactuImpre estadofactuimpre)throws Exception  {
		estadofactuimpre.setEstadoFactuImpreOriginal((EstadoFactuImpre)estadofactuimpre.clone());		
	}
	
	public static void setEstadoFactuImpresOriginalStatic(List<EstadoFactuImpre> estadofactuimpres)throws Exception  {
		
		for(EstadoFactuImpre estadofactuimpre:estadofactuimpres){
			estadofactuimpre.setEstadoFactuImpreOriginal((EstadoFactuImpre)estadofactuimpre.clone());
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
	
	public  EstadoFactuImpre getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		EstadoFactuImpre entity = new EstadoFactuImpre();		
		
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
	
	public  EstadoFactuImpre getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		EstadoFactuImpre entity = new EstadoFactuImpre();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoFactuImpreDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoFactuImpreDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Facturacion.EstadoFactuImpre.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setEstadoFactuImpreOriginal(new EstadoFactuImpre());
      	    	entity=super.getEntity("",entity,resultSet,EstadoFactuImpreDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEstadoFactuImpre("",entity,resultSet); 
				
				//entity.setEstadoFactuImpreOriginal(super.getEntity("",entity.getEstadoFactuImpreOriginal(),resultSet,EstadoFactuImpreDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoFactuImpreOriginal(this.getEntityEstadoFactuImpre("",entity.getEstadoFactuImpreOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseEstadoFactuImpre(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  EstadoFactuImpre getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EstadoFactuImpre entity = new EstadoFactuImpre();
				
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
	
	public  EstadoFactuImpre getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EstadoFactuImpre entity = new EstadoFactuImpre();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoFactuImpreDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoFactuImpreDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EstadoFactuImpreDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.EstadoFactuImpre.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setEstadoFactuImpreOriginal(new EstadoFactuImpre());
      	    	entity=super.getEntity("",entity,resultSet,EstadoFactuImpreDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEstadoFactuImpre("",entity,resultSet);    
				
				//entity.setEstadoFactuImpreOriginal(super.getEntity("",entity.getEstadoFactuImpreOriginal(),resultSet,EstadoFactuImpreDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoFactuImpreOriginal(this.getEntityEstadoFactuImpre("",entity.getEstadoFactuImpreOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseEstadoFactuImpre(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //EstadoFactuImpre
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		EstadoFactuImpre entity = new EstadoFactuImpre();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoFactuImpreDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoFactuImpreDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EstadoFactuImpreDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.EstadoFactuImpre.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseEstadoFactuImpre(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<EstadoFactuImpre> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EstadoFactuImpre> entities = new  ArrayList<EstadoFactuImpre>();
		EstadoFactuImpre entity = new EstadoFactuImpre();		  
		
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
	
	public  List<EstadoFactuImpre> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EstadoFactuImpre> entities = new  ArrayList<EstadoFactuImpre>();
		EstadoFactuImpre entity = new EstadoFactuImpre();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoFactuImpreDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoFactuImpreDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EstadoFactuImpreDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoFactuImpre();
      	    	entity=super.getEntity("",entity,resultSet,EstadoFactuImpreDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoFactuImpre("",entity,resultSet);
      	    	
				//entity.setEstadoFactuImpreOriginal( new EstadoFactuImpre());
      	    	//entity.setEstadoFactuImpreOriginal(super.getEntity("",entity.getEstadoFactuImpreOriginal(),resultSet,EstadoFactuImpreDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoFactuImpreOriginal(this.getEntityEstadoFactuImpre("",entity.getEstadoFactuImpreOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoFactuImpres(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoFactuImpre(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<EstadoFactuImpre> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EstadoFactuImpre> entities = new  ArrayList<EstadoFactuImpre>();
		EstadoFactuImpre entity = new EstadoFactuImpre();		  
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
	
	public  List<EstadoFactuImpre> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EstadoFactuImpre> entities = new  ArrayList<EstadoFactuImpre>();
		EstadoFactuImpre entity = new EstadoFactuImpre();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoFactuImpre();
				
				if(conMapGenerico) {
					entity.inicializarMapEstadoFactuImpre();
					//entity.setMapEstadoFactuImpre(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapEstadoFactuImpreValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEstadoFactuImpre().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EstadoFactuImpreDataAccess.ISWITHSCHEMA);         		
					entity=EstadoFactuImpreDataAccess.getEntityEstadoFactuImpre("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEstadoFactuImpreOriginal( new EstadoFactuImpre());
					////entity.setEstadoFactuImpreOriginal(super.getEntity("",entity.getEstadoFactuImpreOriginal(),resultSet,EstadoFactuImpreDataAccess.ISWITHSCHEMA));         		
					////entity.setEstadoFactuImpreOriginal(this.getEntityEstadoFactuImpre("",entity.getEstadoFactuImpreOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoFactuImpres(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoFactuImpre(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public EstadoFactuImpre getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EstadoFactuImpre entity = new EstadoFactuImpre();		  
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
	
	public  EstadoFactuImpre getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EstadoFactuImpre entity = new EstadoFactuImpre();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoFactuImpre();
				
				if(conMapGenerico) {
					entity.inicializarMapEstadoFactuImpre();
					//entity.setMapEstadoFactuImpre(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapEstadoFactuImpreValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEstadoFactuImpre().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EstadoFactuImpreDataAccess.ISWITHSCHEMA);         		
					entity=EstadoFactuImpreDataAccess.getEntityEstadoFactuImpre("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEstadoFactuImpreOriginal( new EstadoFactuImpre());
					////entity.setEstadoFactuImpreOriginal(super.getEntity("",entity.getEstadoFactuImpreOriginal(),resultSet,EstadoFactuImpreDataAccess.ISWITHSCHEMA));         		
					////entity.setEstadoFactuImpreOriginal(this.getEntityEstadoFactuImpre("",entity.getEstadoFactuImpreOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseEstadoFactuImpre(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoFactuImpre(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static EstadoFactuImpre getEntityEstadoFactuImpre(String strPrefijo,EstadoFactuImpre entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = EstadoFactuImpre.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = EstadoFactuImpre.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					EstadoFactuImpreDataAccess.setFieldReflectionEstadoFactuImpre(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasEstadoFactuImpre=EstadoFactuImpreConstantesFunciones.getTodosTiposColumnasEstadoFactuImpre();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasEstadoFactuImpre) {
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
							field = EstadoFactuImpre.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = EstadoFactuImpre.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						EstadoFactuImpreDataAccess.setFieldReflectionEstadoFactuImpre(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionEstadoFactuImpre(Field field,String strPrefijo,String sColumn,EstadoFactuImpre entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case EstadoFactuImpreConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EstadoFactuImpreConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EstadoFactuImpreConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EstadoFactuImpreConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EstadoFactuImpre>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<EstadoFactuImpre> entities = new  ArrayList<EstadoFactuImpre>();
		EstadoFactuImpre entity = new EstadoFactuImpre();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoFactuImpreDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoFactuImpreDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EstadoFactuImpreDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new EstadoFactuImpre();
					entity=super.getEntity("",entity,resultSet,EstadoFactuImpreDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityEstadoFactuImpre("",entity,resultSet);
					
					//entity.setEstadoFactuImpreOriginal( new EstadoFactuImpre());
					//entity.setEstadoFactuImpreOriginal(super.getEntity("",entity.getEstadoFactuImpreOriginal(),resultSet,EstadoFactuImpreDataAccess.ISWITHSCHEMA));         		
					//entity.setEstadoFactuImpreOriginal(this.getEntityEstadoFactuImpre("",entity.getEstadoFactuImpreOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseEstadoFactuImpres(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoFactuImpre(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EstadoFactuImpre>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<EstadoFactuImpre> entities = new  ArrayList<EstadoFactuImpre>();
		EstadoFactuImpre entity = new EstadoFactuImpre();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoFactuImpreDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoFactuImpreDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EstadoFactuImpreDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<EstadoFactuImpre> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoFactuImpre> entities = new  ArrayList<EstadoFactuImpre>();
		EstadoFactuImpre entity = new EstadoFactuImpre();		  
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
	
	public  List<EstadoFactuImpre> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoFactuImpre> entities = new  ArrayList<EstadoFactuImpre>();
		EstadoFactuImpre entity = new EstadoFactuImpre();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoFactuImpre();
      	    	entity=super.getEntity("",entity,resultSet,EstadoFactuImpreDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoFactuImpre("",entity,resultSet);
      	    	
				//entity.setEstadoFactuImpreOriginal( new EstadoFactuImpre());
      	    	//entity.setEstadoFactuImpreOriginal(super.getEntity("",entity.getEstadoFactuImpreOriginal(),resultSet,EstadoFactuImpreDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoFactuImpreOriginal(this.getEntityEstadoFactuImpre("",entity.getEstadoFactuImpreOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseEstadoFactuImpres(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoFactuImpre(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<EstadoFactuImpre> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoFactuImpre> entities = new  ArrayList<EstadoFactuImpre>();
		EstadoFactuImpre entity = new EstadoFactuImpre();		  
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
	
	public  List<EstadoFactuImpre> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoFactuImpre> entities = new  ArrayList<EstadoFactuImpre>();
		EstadoFactuImpre entity = new EstadoFactuImpre();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoFactuImpre();
      	    	entity=super.getEntity("",entity,resultSet,EstadoFactuImpreDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoFactuImpre("",entity,resultSet);
      	    	
				//entity.setEstadoFactuImpreOriginal( new EstadoFactuImpre());
      	    	//entity.setEstadoFactuImpreOriginal(super.getEntity("",entity.getEstadoFactuImpreOriginal(),resultSet,EstadoFactuImpreDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoFactuImpreOriginal(this.getEntityEstadoFactuImpre("",entity.getEstadoFactuImpreOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoFactuImpres(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public EstadoFactuImpre getEntityEstadoFactuImpre(String strPrefijo,EstadoFactuImpre entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setcodigo(resultSet.getString(strPrefijo+EstadoFactuImpreConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+EstadoFactuImpreConstantesFunciones.NOMBRE));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+EstadoFactuImpreConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowEstadoFactuImpre(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(EstadoFactuImpre entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=EstadoFactuImpreDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=EstadoFactuImpreDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=EstadoFactuImpreDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=EstadoFactuImpreDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(EstadoFactuImpreConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,EstadoFactuImpreDataAccess.TABLENAME,EstadoFactuImpreDataAccess.ISWITHSTOREPROCEDURES);
			
			EstadoFactuImpreDataAccess.setEstadoFactuImpreOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
	
		
		public List<FacturaImpresion> getFacturaImpresions(Connexion connexion,EstadoFactuImpre estadofactuimpre)throws SQLException,Exception {

		List<FacturaImpresion> facturaimpresions= new ArrayList<FacturaImpresion>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstadoFactuImpreConstantesFunciones.SCHEMA+".estado_factu_impre ON "+FacturaImpresionConstantesFunciones.SCHEMA+".factura_impresion.id_estado_factu_impre="+EstadoFactuImpreConstantesFunciones.SCHEMA+".estado_factu_impre.id WHERE "+EstadoFactuImpreConstantesFunciones.SCHEMA+".estado_factu_impre.id="+String.valueOf(estadofactuimpre.getId());
			} else {
				sQuery=" INNER JOIN facturaimpresion.EstadoFactuImpre WHERE facturaimpresion.EstadoFactuImpre.id="+String.valueOf(estadofactuimpre.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			FacturaImpresionDataAccess facturaimpresionDataAccess=new FacturaImpresionDataAccess();

			facturaimpresionDataAccess.setConnexionType(this.connexionType);
			facturaimpresionDataAccess.setParameterDbType(this.parameterDbType);
			facturaimpresions=facturaimpresionDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return facturaimpresions;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,EstadoFactuImpre estadofactuimpre) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!estadofactuimpre.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(estadofactuimpre.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(estadofactuimpre.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!estadofactuimpre.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(estadofactuimpre.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(estadofactuimpre.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(estadofactuimpre.getId());
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
	
	public void setIsNewIsChangedFalseEstadoFactuImpre(EstadoFactuImpre estadofactuimpre)throws Exception  {		
		estadofactuimpre.setIsNew(false);
		estadofactuimpre.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseEstadoFactuImpres(List<EstadoFactuImpre> estadofactuimpres)throws Exception  {				
		for(EstadoFactuImpre estadofactuimpre:estadofactuimpres) {
			estadofactuimpre.setIsNew(false);
			estadofactuimpre.setIsChanged(false);
		}
	}
	
	public void generarExportarEstadoFactuImpre(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
