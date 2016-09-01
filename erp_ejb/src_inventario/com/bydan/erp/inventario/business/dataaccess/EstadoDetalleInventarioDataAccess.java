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
import com.bydan.framework.erp.business.dataaccess.DataAccessHelperSinIdGenerated;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.inventario.util.*;//EstadoDetalleInventarioConstantesFunciones;










@SuppressWarnings("unused")
final public class EstadoDetalleInventarioDataAccess extends  EstadoDetalleInventarioDataAccessAdditional{ //EstadoDetalleInventarioDataAccessAdditional,DataAccessHelper<EstadoDetalleInventario>
	//static Logger logger = Logger.getLogger(EstadoDetalleInventarioDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="estado_detalle_inventario";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+EstadoDetalleInventarioConstantesFunciones.SCHEMA+"."+EstadoDetalleInventarioConstantesFunciones.TABLENAME+"(id,version_row,codigo,nombre)values(?,current_timestamp,?,?)";
	public static String QUERYUPDATE="update "+EstadoDetalleInventarioConstantesFunciones.SCHEMA+"."+EstadoDetalleInventarioConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+EstadoDetalleInventarioConstantesFunciones.SCHEMA+"."+EstadoDetalleInventarioConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select estadodetalleinventario from "+EstadoDetalleInventarioConstantesFunciones.SPERSISTENCENAME+" estadodetalleinventario";
	public static String QUERYSELECTNATIVE="select "+EstadoDetalleInventarioConstantesFunciones.SCHEMA+"."+EstadoDetalleInventarioConstantesFunciones.TABLENAME+".id,"+EstadoDetalleInventarioConstantesFunciones.SCHEMA+"."+EstadoDetalleInventarioConstantesFunciones.TABLENAME+".version_row,"+EstadoDetalleInventarioConstantesFunciones.SCHEMA+"."+EstadoDetalleInventarioConstantesFunciones.TABLENAME+".codigo,"+EstadoDetalleInventarioConstantesFunciones.SCHEMA+"."+EstadoDetalleInventarioConstantesFunciones.TABLENAME+".nombre from "+EstadoDetalleInventarioConstantesFunciones.SCHEMA+"."+EstadoDetalleInventarioConstantesFunciones.TABLENAME;//+" as "+EstadoDetalleInventarioConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+EstadoDetalleInventarioConstantesFunciones.SCHEMA+"."+EstadoDetalleInventarioConstantesFunciones.TABLENAME+".id,"+EstadoDetalleInventarioConstantesFunciones.SCHEMA+"."+EstadoDetalleInventarioConstantesFunciones.TABLENAME+".version_row,"+EstadoDetalleInventarioConstantesFunciones.SCHEMA+"."+EstadoDetalleInventarioConstantesFunciones.TABLENAME+".codigo from "+EstadoDetalleInventarioConstantesFunciones.SCHEMA+"."+EstadoDetalleInventarioConstantesFunciones.TABLENAME;//+" as "+EstadoDetalleInventarioConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+EstadoDetalleInventarioConstantesFunciones.SCHEMA+"."+EstadoDetalleInventarioConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_ESTADODETALLEINVENTARIO_INSERT(?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_ESTADODETALLEINVENTARIO_UPDATE(?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_ESTADODETALLEINVENTARIO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_ESTADODETALLEINVENTARIO_SELECT(?,?)";
	
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
	
	
	protected EstadoDetalleInventarioDataAccessAdditional estadodetalleinventarioDataAccessAdditional=null;
	
	public EstadoDetalleInventarioDataAccessAdditional getEstadoDetalleInventarioDataAccessAdditional() {
		return this.estadodetalleinventarioDataAccessAdditional;
	}
	
	public void setEstadoDetalleInventarioDataAccessAdditional(EstadoDetalleInventarioDataAccessAdditional estadodetalleinventarioDataAccessAdditional) {
		try {
			this.estadodetalleinventarioDataAccessAdditional=estadodetalleinventarioDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public EstadoDetalleInventarioDataAccess() {
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
		EstadoDetalleInventarioDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		EstadoDetalleInventarioDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		EstadoDetalleInventarioDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setEstadoDetalleInventarioOriginal(EstadoDetalleInventario estadodetalleinventario)throws Exception  {
		estadodetalleinventario.setEstadoDetalleInventarioOriginal((EstadoDetalleInventario)estadodetalleinventario.clone());		
	}
	
	public void setEstadoDetalleInventariosOriginal(List<EstadoDetalleInventario> estadodetalleinventarios)throws Exception  {
		
		for(EstadoDetalleInventario estadodetalleinventario:estadodetalleinventarios){
			estadodetalleinventario.setEstadoDetalleInventarioOriginal((EstadoDetalleInventario)estadodetalleinventario.clone());
		}
	}
	
	public static void setEstadoDetalleInventarioOriginalStatic(EstadoDetalleInventario estadodetalleinventario)throws Exception  {
		estadodetalleinventario.setEstadoDetalleInventarioOriginal((EstadoDetalleInventario)estadodetalleinventario.clone());		
	}
	
	public static void setEstadoDetalleInventariosOriginalStatic(List<EstadoDetalleInventario> estadodetalleinventarios)throws Exception  {
		
		for(EstadoDetalleInventario estadodetalleinventario:estadodetalleinventarios){
			estadodetalleinventario.setEstadoDetalleInventarioOriginal((EstadoDetalleInventario)estadodetalleinventario.clone());
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
	
	public  EstadoDetalleInventario getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		EstadoDetalleInventario entity = new EstadoDetalleInventario();		
		
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
	
	public  EstadoDetalleInventario getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		EstadoDetalleInventario entity = new EstadoDetalleInventario();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoDetalleInventarioDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoDetalleInventarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.EstadoDetalleInventario.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setEstadoDetalleInventarioOriginal(new EstadoDetalleInventario());
      	    	entity=super.getEntity("",entity,resultSet,EstadoDetalleInventarioDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEstadoDetalleInventario("",entity,resultSet); 
				
				//entity.setEstadoDetalleInventarioOriginal(super.getEntity("",entity.getEstadoDetalleInventarioOriginal(),resultSet,EstadoDetalleInventarioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoDetalleInventarioOriginal(this.getEntityEstadoDetalleInventario("",entity.getEstadoDetalleInventarioOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseEstadoDetalleInventario(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  EstadoDetalleInventario getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EstadoDetalleInventario entity = new EstadoDetalleInventario();
				
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
	
	public  EstadoDetalleInventario getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EstadoDetalleInventario entity = new EstadoDetalleInventario();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoDetalleInventarioDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoDetalleInventarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoDetalleInventarioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.EstadoDetalleInventario.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setEstadoDetalleInventarioOriginal(new EstadoDetalleInventario());
      	    	entity=super.getEntity("",entity,resultSet,EstadoDetalleInventarioDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEstadoDetalleInventario("",entity,resultSet);    
				
				//entity.setEstadoDetalleInventarioOriginal(super.getEntity("",entity.getEstadoDetalleInventarioOriginal(),resultSet,EstadoDetalleInventarioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoDetalleInventarioOriginal(this.getEntityEstadoDetalleInventario("",entity.getEstadoDetalleInventarioOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseEstadoDetalleInventario(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //EstadoDetalleInventario
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		EstadoDetalleInventario entity = new EstadoDetalleInventario();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoDetalleInventarioDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoDetalleInventarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoDetalleInventarioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.EstadoDetalleInventario.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseEstadoDetalleInventario(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<EstadoDetalleInventario> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EstadoDetalleInventario> entities = new  ArrayList<EstadoDetalleInventario>();
		EstadoDetalleInventario entity = new EstadoDetalleInventario();		  
		
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
	
	public  List<EstadoDetalleInventario> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EstadoDetalleInventario> entities = new  ArrayList<EstadoDetalleInventario>();
		EstadoDetalleInventario entity = new EstadoDetalleInventario();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoDetalleInventarioDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoDetalleInventarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoDetalleInventarioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoDetalleInventario();
      	    	entity=super.getEntity("",entity,resultSet,EstadoDetalleInventarioDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoDetalleInventario("",entity,resultSet);
      	    	
				//entity.setEstadoDetalleInventarioOriginal( new EstadoDetalleInventario());
      	    	//entity.setEstadoDetalleInventarioOriginal(super.getEntity("",entity.getEstadoDetalleInventarioOriginal(),resultSet,EstadoDetalleInventarioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoDetalleInventarioOriginal(this.getEntityEstadoDetalleInventario("",entity.getEstadoDetalleInventarioOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoDetalleInventarios(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoDetalleInventario(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<EstadoDetalleInventario> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EstadoDetalleInventario> entities = new  ArrayList<EstadoDetalleInventario>();
		EstadoDetalleInventario entity = new EstadoDetalleInventario();		  
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
	
	public  List<EstadoDetalleInventario> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EstadoDetalleInventario> entities = new  ArrayList<EstadoDetalleInventario>();
		EstadoDetalleInventario entity = new EstadoDetalleInventario();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoDetalleInventario();
				
				if(conMapGenerico) {
					entity.inicializarMapEstadoDetalleInventario();
					//entity.setMapEstadoDetalleInventario(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapEstadoDetalleInventarioValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEstadoDetalleInventario().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EstadoDetalleInventarioDataAccess.ISWITHSCHEMA);         		
					entity=EstadoDetalleInventarioDataAccess.getEntityEstadoDetalleInventario("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEstadoDetalleInventarioOriginal( new EstadoDetalleInventario());
					////entity.setEstadoDetalleInventarioOriginal(super.getEntity("",entity.getEstadoDetalleInventarioOriginal(),resultSet,EstadoDetalleInventarioDataAccess.ISWITHSCHEMA));         		
					////entity.setEstadoDetalleInventarioOriginal(this.getEntityEstadoDetalleInventario("",entity.getEstadoDetalleInventarioOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoDetalleInventarios(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoDetalleInventario(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public EstadoDetalleInventario getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EstadoDetalleInventario entity = new EstadoDetalleInventario();		  
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
	
	public  EstadoDetalleInventario getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EstadoDetalleInventario entity = new EstadoDetalleInventario();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoDetalleInventario();
				
				if(conMapGenerico) {
					entity.inicializarMapEstadoDetalleInventario();
					//entity.setMapEstadoDetalleInventario(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapEstadoDetalleInventarioValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEstadoDetalleInventario().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EstadoDetalleInventarioDataAccess.ISWITHSCHEMA);         		
					entity=EstadoDetalleInventarioDataAccess.getEntityEstadoDetalleInventario("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEstadoDetalleInventarioOriginal( new EstadoDetalleInventario());
					////entity.setEstadoDetalleInventarioOriginal(super.getEntity("",entity.getEstadoDetalleInventarioOriginal(),resultSet,EstadoDetalleInventarioDataAccess.ISWITHSCHEMA));         		
					////entity.setEstadoDetalleInventarioOriginal(this.getEntityEstadoDetalleInventario("",entity.getEstadoDetalleInventarioOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseEstadoDetalleInventario(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoDetalleInventario(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static EstadoDetalleInventario getEntityEstadoDetalleInventario(String strPrefijo,EstadoDetalleInventario entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = EstadoDetalleInventario.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = EstadoDetalleInventario.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					EstadoDetalleInventarioDataAccess.setFieldReflectionEstadoDetalleInventario(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasEstadoDetalleInventario=EstadoDetalleInventarioConstantesFunciones.getTodosTiposColumnasEstadoDetalleInventario();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasEstadoDetalleInventario) {
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
							field = EstadoDetalleInventario.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = EstadoDetalleInventario.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						EstadoDetalleInventarioDataAccess.setFieldReflectionEstadoDetalleInventario(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionEstadoDetalleInventario(Field field,String strPrefijo,String sColumn,EstadoDetalleInventario entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case EstadoDetalleInventarioConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EstadoDetalleInventarioConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EstadoDetalleInventarioConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EstadoDetalleInventarioConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EstadoDetalleInventario>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<EstadoDetalleInventario> entities = new  ArrayList<EstadoDetalleInventario>();
		EstadoDetalleInventario entity = new EstadoDetalleInventario();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoDetalleInventarioDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoDetalleInventarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoDetalleInventarioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new EstadoDetalleInventario();
					entity=super.getEntity("",entity,resultSet,EstadoDetalleInventarioDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityEstadoDetalleInventario("",entity,resultSet);
					
					//entity.setEstadoDetalleInventarioOriginal( new EstadoDetalleInventario());
					//entity.setEstadoDetalleInventarioOriginal(super.getEntity("",entity.getEstadoDetalleInventarioOriginal(),resultSet,EstadoDetalleInventarioDataAccess.ISWITHSCHEMA));         		
					//entity.setEstadoDetalleInventarioOriginal(this.getEntityEstadoDetalleInventario("",entity.getEstadoDetalleInventarioOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseEstadoDetalleInventarios(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoDetalleInventario(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EstadoDetalleInventario>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<EstadoDetalleInventario> entities = new  ArrayList<EstadoDetalleInventario>();
		EstadoDetalleInventario entity = new EstadoDetalleInventario();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoDetalleInventarioDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoDetalleInventarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoDetalleInventarioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<EstadoDetalleInventario> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoDetalleInventario> entities = new  ArrayList<EstadoDetalleInventario>();
		EstadoDetalleInventario entity = new EstadoDetalleInventario();		  
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
	
	public  List<EstadoDetalleInventario> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoDetalleInventario> entities = new  ArrayList<EstadoDetalleInventario>();
		EstadoDetalleInventario entity = new EstadoDetalleInventario();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoDetalleInventario();
      	    	entity=super.getEntity("",entity,resultSet,EstadoDetalleInventarioDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoDetalleInventario("",entity,resultSet);
      	    	
				//entity.setEstadoDetalleInventarioOriginal( new EstadoDetalleInventario());
      	    	//entity.setEstadoDetalleInventarioOriginal(super.getEntity("",entity.getEstadoDetalleInventarioOriginal(),resultSet,EstadoDetalleInventarioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoDetalleInventarioOriginal(this.getEntityEstadoDetalleInventario("",entity.getEstadoDetalleInventarioOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseEstadoDetalleInventarios(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoDetalleInventario(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<EstadoDetalleInventario> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoDetalleInventario> entities = new  ArrayList<EstadoDetalleInventario>();
		EstadoDetalleInventario entity = new EstadoDetalleInventario();		  
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
	
	public  List<EstadoDetalleInventario> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoDetalleInventario> entities = new  ArrayList<EstadoDetalleInventario>();
		EstadoDetalleInventario entity = new EstadoDetalleInventario();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoDetalleInventario();
      	    	entity=super.getEntity("",entity,resultSet,EstadoDetalleInventarioDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoDetalleInventario("",entity,resultSet);
      	    	
				//entity.setEstadoDetalleInventarioOriginal( new EstadoDetalleInventario());
      	    	//entity.setEstadoDetalleInventarioOriginal(super.getEntity("",entity.getEstadoDetalleInventarioOriginal(),resultSet,EstadoDetalleInventarioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoDetalleInventarioOriginal(this.getEntityEstadoDetalleInventario("",entity.getEstadoDetalleInventarioOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoDetalleInventarios(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public EstadoDetalleInventario getEntityEstadoDetalleInventario(String strPrefijo,EstadoDetalleInventario entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setcodigo(resultSet.getString(strPrefijo+EstadoDetalleInventarioConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+EstadoDetalleInventarioConstantesFunciones.NOMBRE));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+EstadoDetalleInventarioConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowEstadoDetalleInventario(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(EstadoDetalleInventario entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=EstadoDetalleInventarioDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=EstadoDetalleInventarioDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=EstadoDetalleInventarioDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=EstadoDetalleInventarioDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(EstadoDetalleInventarioConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,EstadoDetalleInventarioDataAccess.TABLENAME,EstadoDetalleInventarioDataAccess.ISWITHSTOREPROCEDURES);
			
			EstadoDetalleInventarioDataAccess.setEstadoDetalleInventarioOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
	
		
		public List<DetalleCompra> getDetalleCompras(Connexion connexion,EstadoDetalleInventario estadodetalleinventario)throws SQLException,Exception {

		List<DetalleCompra> detallecompras= new ArrayList<DetalleCompra>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstadoDetalleInventarioConstantesFunciones.SCHEMA+".estado_detalle_inventario ON "+DetalleCompraConstantesFunciones.SCHEMA+".detalle_compra.id_estado_detalle_inventario="+EstadoDetalleInventarioConstantesFunciones.SCHEMA+".estado_detalle_inventario.id WHERE "+EstadoDetalleInventarioConstantesFunciones.SCHEMA+".estado_detalle_inventario.id="+String.valueOf(estadodetalleinventario.getId());
			} else {
				sQuery=" INNER JOIN detallecompra.EstadoDetalleInventario WHERE detallecompra.EstadoDetalleInventario.id="+String.valueOf(estadodetalleinventario.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleCompraDataAccess detallecompraDataAccess=new DetalleCompraDataAccess();

			detallecompraDataAccess.setConnexionType(this.connexionType);
			detallecompraDataAccess.setParameterDbType(this.parameterDbType);
			detallecompras=detallecompraDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detallecompras;

	}

	public List<DetalleTransferencia> getDetalleTransferencias(Connexion connexion,EstadoDetalleInventario estadodetalleinventario)throws SQLException,Exception {

		List<DetalleTransferencia> detalletransferencias= new ArrayList<DetalleTransferencia>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstadoDetalleInventarioConstantesFunciones.SCHEMA+".estado_detalle_inventario ON "+DetalleTransferenciaConstantesFunciones.SCHEMA+".detalle_transferencia.id_estado_detalle_inventario="+EstadoDetalleInventarioConstantesFunciones.SCHEMA+".estado_detalle_inventario.id WHERE "+EstadoDetalleInventarioConstantesFunciones.SCHEMA+".estado_detalle_inventario.id="+String.valueOf(estadodetalleinventario.getId());
			} else {
				sQuery=" INNER JOIN detalletransferencia.EstadoDetalleInventario WHERE detalletransferencia.EstadoDetalleInventario.id="+String.valueOf(estadodetalleinventario.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleTransferenciaDataAccess detalletransferenciaDataAccess=new DetalleTransferenciaDataAccess();

			detalletransferenciaDataAccess.setConnexionType(this.connexionType);
			detalletransferenciaDataAccess.setParameterDbType(this.parameterDbType);
			detalletransferencias=detalletransferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalletransferencias;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,EstadoDetalleInventario estadodetalleinventario) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!estadodetalleinventario.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid=new ParameterValue<Long>();
					parameterMaintenanceValueid.setValue(estadodetalleinventario.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(estadodetalleinventario.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(estadodetalleinventario.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!estadodetalleinventario.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(estadodetalleinventario.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(estadodetalleinventario.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(estadodetalleinventario.getId());
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
	
	public void setIsNewIsChangedFalseEstadoDetalleInventario(EstadoDetalleInventario estadodetalleinventario)throws Exception  {		
		estadodetalleinventario.setIsNew(false);
		estadodetalleinventario.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseEstadoDetalleInventarios(List<EstadoDetalleInventario> estadodetalleinventarios)throws Exception  {				
		for(EstadoDetalleInventario estadodetalleinventario:estadodetalleinventarios) {
			estadodetalleinventario.setIsNew(false);
			estadodetalleinventario.setIsChanged(false);
		}
	}
	
	public void generarExportarEstadoDetalleInventario(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
