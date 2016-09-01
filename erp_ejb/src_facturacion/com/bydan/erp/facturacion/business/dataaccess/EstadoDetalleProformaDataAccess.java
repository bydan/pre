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
import com.bydan.erp.facturacion.util.*;//EstadoDetalleProformaConstantesFunciones;










@SuppressWarnings("unused")
final public class EstadoDetalleProformaDataAccess extends  EstadoDetalleProformaDataAccessAdditional{ //EstadoDetalleProformaDataAccessAdditional,DataAccessHelper<EstadoDetalleProforma>
	//static Logger logger = Logger.getLogger(EstadoDetalleProformaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="estado_detalle_proforma";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+EstadoDetalleProformaConstantesFunciones.SCHEMA+"."+EstadoDetalleProformaConstantesFunciones.TABLENAME+"(version_row,codigo,nombre)values(current_timestamp,?,?)";
	public static String QUERYUPDATE="update "+EstadoDetalleProformaConstantesFunciones.SCHEMA+"."+EstadoDetalleProformaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,codigo=?,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+EstadoDetalleProformaConstantesFunciones.SCHEMA+"."+EstadoDetalleProformaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select estadodetalleproforma from "+EstadoDetalleProformaConstantesFunciones.SPERSISTENCENAME+" estadodetalleproforma";
	public static String QUERYSELECTNATIVE="select "+EstadoDetalleProformaConstantesFunciones.SCHEMA+"."+EstadoDetalleProformaConstantesFunciones.TABLENAME+".id,"+EstadoDetalleProformaConstantesFunciones.SCHEMA+"."+EstadoDetalleProformaConstantesFunciones.TABLENAME+".version_row,"+EstadoDetalleProformaConstantesFunciones.SCHEMA+"."+EstadoDetalleProformaConstantesFunciones.TABLENAME+".codigo,"+EstadoDetalleProformaConstantesFunciones.SCHEMA+"."+EstadoDetalleProformaConstantesFunciones.TABLENAME+".nombre from "+EstadoDetalleProformaConstantesFunciones.SCHEMA+"."+EstadoDetalleProformaConstantesFunciones.TABLENAME;//+" as "+EstadoDetalleProformaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+EstadoDetalleProformaConstantesFunciones.SCHEMA+"."+EstadoDetalleProformaConstantesFunciones.TABLENAME+".id,"+EstadoDetalleProformaConstantesFunciones.SCHEMA+"."+EstadoDetalleProformaConstantesFunciones.TABLENAME+".version_row,"+EstadoDetalleProformaConstantesFunciones.SCHEMA+"."+EstadoDetalleProformaConstantesFunciones.TABLENAME+".codigo from "+EstadoDetalleProformaConstantesFunciones.SCHEMA+"."+EstadoDetalleProformaConstantesFunciones.TABLENAME;//+" as "+EstadoDetalleProformaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+EstadoDetalleProformaConstantesFunciones.SCHEMA+"."+EstadoDetalleProformaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,codigo=?,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_ESTADODETALLEPROFORMA_INSERT(?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_ESTADODETALLEPROFORMA_UPDATE(?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_ESTADODETALLEPROFORMA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_ESTADODETALLEPROFORMA_SELECT(?,?)";
	
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
	
	
	protected EstadoDetalleProformaDataAccessAdditional estadodetalleproformaDataAccessAdditional=null;
	
	public EstadoDetalleProformaDataAccessAdditional getEstadoDetalleProformaDataAccessAdditional() {
		return this.estadodetalleproformaDataAccessAdditional;
	}
	
	public void setEstadoDetalleProformaDataAccessAdditional(EstadoDetalleProformaDataAccessAdditional estadodetalleproformaDataAccessAdditional) {
		try {
			this.estadodetalleproformaDataAccessAdditional=estadodetalleproformaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public EstadoDetalleProformaDataAccess() {
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
		EstadoDetalleProformaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		EstadoDetalleProformaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		EstadoDetalleProformaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setEstadoDetalleProformaOriginal(EstadoDetalleProforma estadodetalleproforma)throws Exception  {
		estadodetalleproforma.setEstadoDetalleProformaOriginal((EstadoDetalleProforma)estadodetalleproforma.clone());		
	}
	
	public void setEstadoDetalleProformasOriginal(List<EstadoDetalleProforma> estadodetalleproformas)throws Exception  {
		
		for(EstadoDetalleProforma estadodetalleproforma:estadodetalleproformas){
			estadodetalleproforma.setEstadoDetalleProformaOriginal((EstadoDetalleProforma)estadodetalleproforma.clone());
		}
	}
	
	public static void setEstadoDetalleProformaOriginalStatic(EstadoDetalleProforma estadodetalleproforma)throws Exception  {
		estadodetalleproforma.setEstadoDetalleProformaOriginal((EstadoDetalleProforma)estadodetalleproforma.clone());		
	}
	
	public static void setEstadoDetalleProformasOriginalStatic(List<EstadoDetalleProforma> estadodetalleproformas)throws Exception  {
		
		for(EstadoDetalleProforma estadodetalleproforma:estadodetalleproformas){
			estadodetalleproforma.setEstadoDetalleProformaOriginal((EstadoDetalleProforma)estadodetalleproforma.clone());
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
	
	public  EstadoDetalleProforma getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		EstadoDetalleProforma entity = new EstadoDetalleProforma();		
		
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
	
	public  EstadoDetalleProforma getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		EstadoDetalleProforma entity = new EstadoDetalleProforma();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoDetalleProformaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoDetalleProformaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Facturacion.EstadoDetalleProforma.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setEstadoDetalleProformaOriginal(new EstadoDetalleProforma());
      	    	entity=super.getEntity("",entity,resultSet,EstadoDetalleProformaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEstadoDetalleProforma("",entity,resultSet); 
				
				//entity.setEstadoDetalleProformaOriginal(super.getEntity("",entity.getEstadoDetalleProformaOriginal(),resultSet,EstadoDetalleProformaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoDetalleProformaOriginal(this.getEntityEstadoDetalleProforma("",entity.getEstadoDetalleProformaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseEstadoDetalleProforma(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  EstadoDetalleProforma getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EstadoDetalleProforma entity = new EstadoDetalleProforma();
				
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
	
	public  EstadoDetalleProforma getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EstadoDetalleProforma entity = new EstadoDetalleProforma();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoDetalleProformaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoDetalleProformaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EstadoDetalleProformaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.EstadoDetalleProforma.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setEstadoDetalleProformaOriginal(new EstadoDetalleProforma());
      	    	entity=super.getEntity("",entity,resultSet,EstadoDetalleProformaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEstadoDetalleProforma("",entity,resultSet);    
				
				//entity.setEstadoDetalleProformaOriginal(super.getEntity("",entity.getEstadoDetalleProformaOriginal(),resultSet,EstadoDetalleProformaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoDetalleProformaOriginal(this.getEntityEstadoDetalleProforma("",entity.getEstadoDetalleProformaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseEstadoDetalleProforma(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //EstadoDetalleProforma
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		EstadoDetalleProforma entity = new EstadoDetalleProforma();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoDetalleProformaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoDetalleProformaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EstadoDetalleProformaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.EstadoDetalleProforma.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseEstadoDetalleProforma(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<EstadoDetalleProforma> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EstadoDetalleProforma> entities = new  ArrayList<EstadoDetalleProforma>();
		EstadoDetalleProforma entity = new EstadoDetalleProforma();		  
		
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
	
	public  List<EstadoDetalleProforma> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EstadoDetalleProforma> entities = new  ArrayList<EstadoDetalleProforma>();
		EstadoDetalleProforma entity = new EstadoDetalleProforma();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoDetalleProformaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoDetalleProformaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EstadoDetalleProformaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoDetalleProforma();
      	    	entity=super.getEntity("",entity,resultSet,EstadoDetalleProformaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoDetalleProforma("",entity,resultSet);
      	    	
				//entity.setEstadoDetalleProformaOriginal( new EstadoDetalleProforma());
      	    	//entity.setEstadoDetalleProformaOriginal(super.getEntity("",entity.getEstadoDetalleProformaOriginal(),resultSet,EstadoDetalleProformaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoDetalleProformaOriginal(this.getEntityEstadoDetalleProforma("",entity.getEstadoDetalleProformaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoDetalleProformas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoDetalleProforma(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<EstadoDetalleProforma> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EstadoDetalleProforma> entities = new  ArrayList<EstadoDetalleProforma>();
		EstadoDetalleProforma entity = new EstadoDetalleProforma();		  
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
	
	public  List<EstadoDetalleProforma> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EstadoDetalleProforma> entities = new  ArrayList<EstadoDetalleProforma>();
		EstadoDetalleProforma entity = new EstadoDetalleProforma();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoDetalleProforma();
				
				if(conMapGenerico) {
					entity.inicializarMapEstadoDetalleProforma();
					//entity.setMapEstadoDetalleProforma(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapEstadoDetalleProformaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEstadoDetalleProforma().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EstadoDetalleProformaDataAccess.ISWITHSCHEMA);         		
					entity=EstadoDetalleProformaDataAccess.getEntityEstadoDetalleProforma("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEstadoDetalleProformaOriginal( new EstadoDetalleProforma());
					////entity.setEstadoDetalleProformaOriginal(super.getEntity("",entity.getEstadoDetalleProformaOriginal(),resultSet,EstadoDetalleProformaDataAccess.ISWITHSCHEMA));         		
					////entity.setEstadoDetalleProformaOriginal(this.getEntityEstadoDetalleProforma("",entity.getEstadoDetalleProformaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoDetalleProformas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoDetalleProforma(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public EstadoDetalleProforma getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EstadoDetalleProforma entity = new EstadoDetalleProforma();		  
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
	
	public  EstadoDetalleProforma getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EstadoDetalleProforma entity = new EstadoDetalleProforma();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoDetalleProforma();
				
				if(conMapGenerico) {
					entity.inicializarMapEstadoDetalleProforma();
					//entity.setMapEstadoDetalleProforma(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapEstadoDetalleProformaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEstadoDetalleProforma().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EstadoDetalleProformaDataAccess.ISWITHSCHEMA);         		
					entity=EstadoDetalleProformaDataAccess.getEntityEstadoDetalleProforma("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEstadoDetalleProformaOriginal( new EstadoDetalleProforma());
					////entity.setEstadoDetalleProformaOriginal(super.getEntity("",entity.getEstadoDetalleProformaOriginal(),resultSet,EstadoDetalleProformaDataAccess.ISWITHSCHEMA));         		
					////entity.setEstadoDetalleProformaOriginal(this.getEntityEstadoDetalleProforma("",entity.getEstadoDetalleProformaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseEstadoDetalleProforma(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoDetalleProforma(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static EstadoDetalleProforma getEntityEstadoDetalleProforma(String strPrefijo,EstadoDetalleProforma entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = EstadoDetalleProforma.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = EstadoDetalleProforma.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					EstadoDetalleProformaDataAccess.setFieldReflectionEstadoDetalleProforma(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasEstadoDetalleProforma=EstadoDetalleProformaConstantesFunciones.getTodosTiposColumnasEstadoDetalleProforma();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasEstadoDetalleProforma) {
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
							field = EstadoDetalleProforma.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = EstadoDetalleProforma.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						EstadoDetalleProformaDataAccess.setFieldReflectionEstadoDetalleProforma(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionEstadoDetalleProforma(Field field,String strPrefijo,String sColumn,EstadoDetalleProforma entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case EstadoDetalleProformaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EstadoDetalleProformaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EstadoDetalleProformaConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EstadoDetalleProformaConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EstadoDetalleProforma>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<EstadoDetalleProforma> entities = new  ArrayList<EstadoDetalleProforma>();
		EstadoDetalleProforma entity = new EstadoDetalleProforma();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoDetalleProformaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoDetalleProformaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EstadoDetalleProformaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new EstadoDetalleProforma();
					entity=super.getEntity("",entity,resultSet,EstadoDetalleProformaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityEstadoDetalleProforma("",entity,resultSet);
					
					//entity.setEstadoDetalleProformaOriginal( new EstadoDetalleProforma());
					//entity.setEstadoDetalleProformaOriginal(super.getEntity("",entity.getEstadoDetalleProformaOriginal(),resultSet,EstadoDetalleProformaDataAccess.ISWITHSCHEMA));         		
					//entity.setEstadoDetalleProformaOriginal(this.getEntityEstadoDetalleProforma("",entity.getEstadoDetalleProformaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseEstadoDetalleProformas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoDetalleProforma(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EstadoDetalleProforma>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<EstadoDetalleProforma> entities = new  ArrayList<EstadoDetalleProforma>();
		EstadoDetalleProforma entity = new EstadoDetalleProforma();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoDetalleProformaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoDetalleProformaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EstadoDetalleProformaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<EstadoDetalleProforma> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoDetalleProforma> entities = new  ArrayList<EstadoDetalleProforma>();
		EstadoDetalleProforma entity = new EstadoDetalleProforma();		  
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
	
	public  List<EstadoDetalleProforma> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoDetalleProforma> entities = new  ArrayList<EstadoDetalleProforma>();
		EstadoDetalleProforma entity = new EstadoDetalleProforma();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoDetalleProforma();
      	    	entity=super.getEntity("",entity,resultSet,EstadoDetalleProformaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoDetalleProforma("",entity,resultSet);
      	    	
				//entity.setEstadoDetalleProformaOriginal( new EstadoDetalleProforma());
      	    	//entity.setEstadoDetalleProformaOriginal(super.getEntity("",entity.getEstadoDetalleProformaOriginal(),resultSet,EstadoDetalleProformaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoDetalleProformaOriginal(this.getEntityEstadoDetalleProforma("",entity.getEstadoDetalleProformaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseEstadoDetalleProformas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoDetalleProforma(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<EstadoDetalleProforma> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoDetalleProforma> entities = new  ArrayList<EstadoDetalleProforma>();
		EstadoDetalleProforma entity = new EstadoDetalleProforma();		  
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
	
	public  List<EstadoDetalleProforma> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoDetalleProforma> entities = new  ArrayList<EstadoDetalleProforma>();
		EstadoDetalleProforma entity = new EstadoDetalleProforma();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoDetalleProforma();
      	    	entity=super.getEntity("",entity,resultSet,EstadoDetalleProformaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoDetalleProforma("",entity,resultSet);
      	    	
				//entity.setEstadoDetalleProformaOriginal( new EstadoDetalleProforma());
      	    	//entity.setEstadoDetalleProformaOriginal(super.getEntity("",entity.getEstadoDetalleProformaOriginal(),resultSet,EstadoDetalleProformaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoDetalleProformaOriginal(this.getEntityEstadoDetalleProforma("",entity.getEstadoDetalleProformaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoDetalleProformas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public EstadoDetalleProforma getEntityEstadoDetalleProforma(String strPrefijo,EstadoDetalleProforma entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setcodigo(resultSet.getString(strPrefijo+EstadoDetalleProformaConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+EstadoDetalleProformaConstantesFunciones.NOMBRE));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+EstadoDetalleProformaConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowEstadoDetalleProforma(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(EstadoDetalleProforma entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=EstadoDetalleProformaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=EstadoDetalleProformaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=EstadoDetalleProformaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=EstadoDetalleProformaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(EstadoDetalleProformaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,EstadoDetalleProformaDataAccess.TABLENAME,EstadoDetalleProformaDataAccess.ISWITHSTOREPROCEDURES);
			
			EstadoDetalleProformaDataAccess.setEstadoDetalleProformaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
	
		
		public List<DetalleProforma> getDetalleProformas(Connexion connexion,EstadoDetalleProforma estadodetalleproforma)throws SQLException,Exception {

		List<DetalleProforma> detalleproformas= new ArrayList<DetalleProforma>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstadoDetalleProformaConstantesFunciones.SCHEMA+".estado_detalle_proforma ON "+DetalleProformaConstantesFunciones.SCHEMA+".detalle_proforma.id_estado_detalle_proforma="+EstadoDetalleProformaConstantesFunciones.SCHEMA+".estado_detalle_proforma.id WHERE "+EstadoDetalleProformaConstantesFunciones.SCHEMA+".estado_detalle_proforma.id="+String.valueOf(estadodetalleproforma.getId());
			} else {
				sQuery=" INNER JOIN detalleproforma.EstadoDetalleProforma WHERE detalleproforma.EstadoDetalleProforma.id="+String.valueOf(estadodetalleproforma.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleProformaDataAccess detalleproformaDataAccess=new DetalleProformaDataAccess();

			detalleproformaDataAccess.setConnexionType(this.connexionType);
			detalleproformaDataAccess.setParameterDbType(this.parameterDbType);
			detalleproformas=detalleproformaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalleproformas;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,EstadoDetalleProforma estadodetalleproforma) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!estadodetalleproforma.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(estadodetalleproforma.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(estadodetalleproforma.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!estadodetalleproforma.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(estadodetalleproforma.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(estadodetalleproforma.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(estadodetalleproforma.getId());
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
	
	public void setIsNewIsChangedFalseEstadoDetalleProforma(EstadoDetalleProforma estadodetalleproforma)throws Exception  {		
		estadodetalleproforma.setIsNew(false);
		estadodetalleproforma.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseEstadoDetalleProformas(List<EstadoDetalleProforma> estadodetalleproformas)throws Exception  {				
		for(EstadoDetalleProforma estadodetalleproforma:estadodetalleproformas) {
			estadodetalleproforma.setIsNew(false);
			estadodetalleproforma.setIsChanged(false);
		}
	}
	
	public void generarExportarEstadoDetalleProforma(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
