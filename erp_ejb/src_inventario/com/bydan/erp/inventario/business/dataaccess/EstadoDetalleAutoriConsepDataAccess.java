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
import com.bydan.erp.inventario.util.*;//EstadoDetalleAutoriConsepConstantesFunciones;










@SuppressWarnings("unused")
final public class EstadoDetalleAutoriConsepDataAccess extends  DataAccessHelperSinIdGenerated<EstadoDetalleAutoriConsep>{ //EstadoDetalleAutoriConsepDataAccessAdditional,DataAccessHelper<EstadoDetalleAutoriConsep>
	//static Logger logger = Logger.getLogger(EstadoDetalleAutoriConsepDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="estado_detalle_autori_consep";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+EstadoDetalleAutoriConsepConstantesFunciones.SCHEMA+"."+EstadoDetalleAutoriConsepConstantesFunciones.TABLENAME+"(id,version_row,codigo,nombre)values(?,current_timestamp,?,?)";
	public static String QUERYUPDATE="update "+EstadoDetalleAutoriConsepConstantesFunciones.SCHEMA+"."+EstadoDetalleAutoriConsepConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+EstadoDetalleAutoriConsepConstantesFunciones.SCHEMA+"."+EstadoDetalleAutoriConsepConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select estadodetalleautoriconsep from "+EstadoDetalleAutoriConsepConstantesFunciones.SPERSISTENCENAME+" estadodetalleautoriconsep";
	public static String QUERYSELECTNATIVE="select "+EstadoDetalleAutoriConsepConstantesFunciones.SCHEMA+"."+EstadoDetalleAutoriConsepConstantesFunciones.TABLENAME+".id,"+EstadoDetalleAutoriConsepConstantesFunciones.SCHEMA+"."+EstadoDetalleAutoriConsepConstantesFunciones.TABLENAME+".version_row,"+EstadoDetalleAutoriConsepConstantesFunciones.SCHEMA+"."+EstadoDetalleAutoriConsepConstantesFunciones.TABLENAME+".codigo,"+EstadoDetalleAutoriConsepConstantesFunciones.SCHEMA+"."+EstadoDetalleAutoriConsepConstantesFunciones.TABLENAME+".nombre from "+EstadoDetalleAutoriConsepConstantesFunciones.SCHEMA+"."+EstadoDetalleAutoriConsepConstantesFunciones.TABLENAME;//+" as "+EstadoDetalleAutoriConsepConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+EstadoDetalleAutoriConsepConstantesFunciones.SCHEMA+"."+EstadoDetalleAutoriConsepConstantesFunciones.TABLENAME+".id,"+EstadoDetalleAutoriConsepConstantesFunciones.SCHEMA+"."+EstadoDetalleAutoriConsepConstantesFunciones.TABLENAME+".version_row,"+EstadoDetalleAutoriConsepConstantesFunciones.SCHEMA+"."+EstadoDetalleAutoriConsepConstantesFunciones.TABLENAME+".codigo from "+EstadoDetalleAutoriConsepConstantesFunciones.SCHEMA+"."+EstadoDetalleAutoriConsepConstantesFunciones.TABLENAME;//+" as "+EstadoDetalleAutoriConsepConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+EstadoDetalleAutoriConsepConstantesFunciones.SCHEMA+"."+EstadoDetalleAutoriConsepConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_ESTADODETALLEAUTORICONSEP_INSERT(?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_ESTADODETALLEAUTORICONSEP_UPDATE(?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_ESTADODETALLEAUTORICONSEP_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_ESTADODETALLEAUTORICONSEP_SELECT(?,?)";
	
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
	
	
	public EstadoDetalleAutoriConsepDataAccess() {
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
		EstadoDetalleAutoriConsepDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		EstadoDetalleAutoriConsepDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		EstadoDetalleAutoriConsepDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setEstadoDetalleAutoriConsepOriginal(EstadoDetalleAutoriConsep estadodetalleautoriconsep)throws Exception  {
		estadodetalleautoriconsep.setEstadoDetalleAutoriConsepOriginal((EstadoDetalleAutoriConsep)estadodetalleautoriconsep.clone());		
	}
	
	public void setEstadoDetalleAutoriConsepsOriginal(List<EstadoDetalleAutoriConsep> estadodetalleautoriconseps)throws Exception  {
		
		for(EstadoDetalleAutoriConsep estadodetalleautoriconsep:estadodetalleautoriconseps){
			estadodetalleautoriconsep.setEstadoDetalleAutoriConsepOriginal((EstadoDetalleAutoriConsep)estadodetalleautoriconsep.clone());
		}
	}
	
	public static void setEstadoDetalleAutoriConsepOriginalStatic(EstadoDetalleAutoriConsep estadodetalleautoriconsep)throws Exception  {
		estadodetalleautoriconsep.setEstadoDetalleAutoriConsepOriginal((EstadoDetalleAutoriConsep)estadodetalleautoriconsep.clone());		
	}
	
	public static void setEstadoDetalleAutoriConsepsOriginalStatic(List<EstadoDetalleAutoriConsep> estadodetalleautoriconseps)throws Exception  {
		
		for(EstadoDetalleAutoriConsep estadodetalleautoriconsep:estadodetalleautoriconseps){
			estadodetalleautoriconsep.setEstadoDetalleAutoriConsepOriginal((EstadoDetalleAutoriConsep)estadodetalleautoriconsep.clone());
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
	
	public  EstadoDetalleAutoriConsep getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		EstadoDetalleAutoriConsep entity = new EstadoDetalleAutoriConsep();		
		
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
	
	public  EstadoDetalleAutoriConsep getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		EstadoDetalleAutoriConsep entity = new EstadoDetalleAutoriConsep();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoDetalleAutoriConsepDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoDetalleAutoriConsepDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.EstadoDetalleAutoriConsep.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setEstadoDetalleAutoriConsepOriginal(new EstadoDetalleAutoriConsep());
      	    	entity=super.getEntity("",entity,resultSet,EstadoDetalleAutoriConsepDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEstadoDetalleAutoriConsep("",entity,resultSet); 
				
				//entity.setEstadoDetalleAutoriConsepOriginal(super.getEntity("",entity.getEstadoDetalleAutoriConsepOriginal(),resultSet,EstadoDetalleAutoriConsepDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoDetalleAutoriConsepOriginal(this.getEntityEstadoDetalleAutoriConsep("",entity.getEstadoDetalleAutoriConsepOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseEstadoDetalleAutoriConsep(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  EstadoDetalleAutoriConsep getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EstadoDetalleAutoriConsep entity = new EstadoDetalleAutoriConsep();
				
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
	
	public  EstadoDetalleAutoriConsep getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EstadoDetalleAutoriConsep entity = new EstadoDetalleAutoriConsep();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoDetalleAutoriConsepDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoDetalleAutoriConsepDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoDetalleAutoriConsepDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.EstadoDetalleAutoriConsep.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setEstadoDetalleAutoriConsepOriginal(new EstadoDetalleAutoriConsep());
      	    	entity=super.getEntity("",entity,resultSet,EstadoDetalleAutoriConsepDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEstadoDetalleAutoriConsep("",entity,resultSet);    
				
				//entity.setEstadoDetalleAutoriConsepOriginal(super.getEntity("",entity.getEstadoDetalleAutoriConsepOriginal(),resultSet,EstadoDetalleAutoriConsepDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoDetalleAutoriConsepOriginal(this.getEntityEstadoDetalleAutoriConsep("",entity.getEstadoDetalleAutoriConsepOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseEstadoDetalleAutoriConsep(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //EstadoDetalleAutoriConsep
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		EstadoDetalleAutoriConsep entity = new EstadoDetalleAutoriConsep();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoDetalleAutoriConsepDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoDetalleAutoriConsepDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoDetalleAutoriConsepDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.EstadoDetalleAutoriConsep.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseEstadoDetalleAutoriConsep(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<EstadoDetalleAutoriConsep> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EstadoDetalleAutoriConsep> entities = new  ArrayList<EstadoDetalleAutoriConsep>();
		EstadoDetalleAutoriConsep entity = new EstadoDetalleAutoriConsep();		  
		
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
	
	public  List<EstadoDetalleAutoriConsep> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EstadoDetalleAutoriConsep> entities = new  ArrayList<EstadoDetalleAutoriConsep>();
		EstadoDetalleAutoriConsep entity = new EstadoDetalleAutoriConsep();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoDetalleAutoriConsepDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoDetalleAutoriConsepDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoDetalleAutoriConsepDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoDetalleAutoriConsep();
      	    	entity=super.getEntity("",entity,resultSet,EstadoDetalleAutoriConsepDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoDetalleAutoriConsep("",entity,resultSet);
      	    	
				//entity.setEstadoDetalleAutoriConsepOriginal( new EstadoDetalleAutoriConsep());
      	    	//entity.setEstadoDetalleAutoriConsepOriginal(super.getEntity("",entity.getEstadoDetalleAutoriConsepOriginal(),resultSet,EstadoDetalleAutoriConsepDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoDetalleAutoriConsepOriginal(this.getEntityEstadoDetalleAutoriConsep("",entity.getEstadoDetalleAutoriConsepOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoDetalleAutoriConseps(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoDetalleAutoriConsep(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<EstadoDetalleAutoriConsep> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EstadoDetalleAutoriConsep> entities = new  ArrayList<EstadoDetalleAutoriConsep>();
		EstadoDetalleAutoriConsep entity = new EstadoDetalleAutoriConsep();		  
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
	
	public  List<EstadoDetalleAutoriConsep> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EstadoDetalleAutoriConsep> entities = new  ArrayList<EstadoDetalleAutoriConsep>();
		EstadoDetalleAutoriConsep entity = new EstadoDetalleAutoriConsep();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoDetalleAutoriConsep();
				
				if(conMapGenerico) {
					entity.inicializarMapEstadoDetalleAutoriConsep();
					//entity.setMapEstadoDetalleAutoriConsep(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapEstadoDetalleAutoriConsepValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEstadoDetalleAutoriConsep().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EstadoDetalleAutoriConsepDataAccess.ISWITHSCHEMA);         		
					entity=EstadoDetalleAutoriConsepDataAccess.getEntityEstadoDetalleAutoriConsep("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEstadoDetalleAutoriConsepOriginal( new EstadoDetalleAutoriConsep());
					////entity.setEstadoDetalleAutoriConsepOriginal(super.getEntity("",entity.getEstadoDetalleAutoriConsepOriginal(),resultSet,EstadoDetalleAutoriConsepDataAccess.ISWITHSCHEMA));         		
					////entity.setEstadoDetalleAutoriConsepOriginal(this.getEntityEstadoDetalleAutoriConsep("",entity.getEstadoDetalleAutoriConsepOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoDetalleAutoriConseps(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoDetalleAutoriConsep(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public EstadoDetalleAutoriConsep getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EstadoDetalleAutoriConsep entity = new EstadoDetalleAutoriConsep();		  
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
	
	public  EstadoDetalleAutoriConsep getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EstadoDetalleAutoriConsep entity = new EstadoDetalleAutoriConsep();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoDetalleAutoriConsep();
				
				if(conMapGenerico) {
					entity.inicializarMapEstadoDetalleAutoriConsep();
					//entity.setMapEstadoDetalleAutoriConsep(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapEstadoDetalleAutoriConsepValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEstadoDetalleAutoriConsep().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EstadoDetalleAutoriConsepDataAccess.ISWITHSCHEMA);         		
					entity=EstadoDetalleAutoriConsepDataAccess.getEntityEstadoDetalleAutoriConsep("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEstadoDetalleAutoriConsepOriginal( new EstadoDetalleAutoriConsep());
					////entity.setEstadoDetalleAutoriConsepOriginal(super.getEntity("",entity.getEstadoDetalleAutoriConsepOriginal(),resultSet,EstadoDetalleAutoriConsepDataAccess.ISWITHSCHEMA));         		
					////entity.setEstadoDetalleAutoriConsepOriginal(this.getEntityEstadoDetalleAutoriConsep("",entity.getEstadoDetalleAutoriConsepOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseEstadoDetalleAutoriConsep(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoDetalleAutoriConsep(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static EstadoDetalleAutoriConsep getEntityEstadoDetalleAutoriConsep(String strPrefijo,EstadoDetalleAutoriConsep entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = EstadoDetalleAutoriConsep.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = EstadoDetalleAutoriConsep.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					EstadoDetalleAutoriConsepDataAccess.setFieldReflectionEstadoDetalleAutoriConsep(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasEstadoDetalleAutoriConsep=EstadoDetalleAutoriConsepConstantesFunciones.getTodosTiposColumnasEstadoDetalleAutoriConsep();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasEstadoDetalleAutoriConsep) {
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
							field = EstadoDetalleAutoriConsep.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = EstadoDetalleAutoriConsep.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						EstadoDetalleAutoriConsepDataAccess.setFieldReflectionEstadoDetalleAutoriConsep(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionEstadoDetalleAutoriConsep(Field field,String strPrefijo,String sColumn,EstadoDetalleAutoriConsep entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case EstadoDetalleAutoriConsepConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EstadoDetalleAutoriConsepConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EstadoDetalleAutoriConsepConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EstadoDetalleAutoriConsepConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EstadoDetalleAutoriConsep>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<EstadoDetalleAutoriConsep> entities = new  ArrayList<EstadoDetalleAutoriConsep>();
		EstadoDetalleAutoriConsep entity = new EstadoDetalleAutoriConsep();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoDetalleAutoriConsepDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoDetalleAutoriConsepDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoDetalleAutoriConsepDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new EstadoDetalleAutoriConsep();
					entity=super.getEntity("",entity,resultSet,EstadoDetalleAutoriConsepDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityEstadoDetalleAutoriConsep("",entity,resultSet);
					
					//entity.setEstadoDetalleAutoriConsepOriginal( new EstadoDetalleAutoriConsep());
					//entity.setEstadoDetalleAutoriConsepOriginal(super.getEntity("",entity.getEstadoDetalleAutoriConsepOriginal(),resultSet,EstadoDetalleAutoriConsepDataAccess.ISWITHSCHEMA));         		
					//entity.setEstadoDetalleAutoriConsepOriginal(this.getEntityEstadoDetalleAutoriConsep("",entity.getEstadoDetalleAutoriConsepOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseEstadoDetalleAutoriConseps(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoDetalleAutoriConsep(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EstadoDetalleAutoriConsep>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<EstadoDetalleAutoriConsep> entities = new  ArrayList<EstadoDetalleAutoriConsep>();
		EstadoDetalleAutoriConsep entity = new EstadoDetalleAutoriConsep();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoDetalleAutoriConsepDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoDetalleAutoriConsepDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoDetalleAutoriConsepDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<EstadoDetalleAutoriConsep> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoDetalleAutoriConsep> entities = new  ArrayList<EstadoDetalleAutoriConsep>();
		EstadoDetalleAutoriConsep entity = new EstadoDetalleAutoriConsep();		  
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
	
	public  List<EstadoDetalleAutoriConsep> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoDetalleAutoriConsep> entities = new  ArrayList<EstadoDetalleAutoriConsep>();
		EstadoDetalleAutoriConsep entity = new EstadoDetalleAutoriConsep();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoDetalleAutoriConsep();
      	    	entity=super.getEntity("",entity,resultSet,EstadoDetalleAutoriConsepDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoDetalleAutoriConsep("",entity,resultSet);
      	    	
				//entity.setEstadoDetalleAutoriConsepOriginal( new EstadoDetalleAutoriConsep());
      	    	//entity.setEstadoDetalleAutoriConsepOriginal(super.getEntity("",entity.getEstadoDetalleAutoriConsepOriginal(),resultSet,EstadoDetalleAutoriConsepDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoDetalleAutoriConsepOriginal(this.getEntityEstadoDetalleAutoriConsep("",entity.getEstadoDetalleAutoriConsepOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseEstadoDetalleAutoriConseps(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoDetalleAutoriConsep(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	
	
	public EstadoDetalleAutoriConsep getEntityEstadoDetalleAutoriConsep(String strPrefijo,EstadoDetalleAutoriConsep entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setcodigo(resultSet.getString(strPrefijo+EstadoDetalleAutoriConsepConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+EstadoDetalleAutoriConsepConstantesFunciones.NOMBRE));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+EstadoDetalleAutoriConsepConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowEstadoDetalleAutoriConsep(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(EstadoDetalleAutoriConsep entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=EstadoDetalleAutoriConsepDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=EstadoDetalleAutoriConsepDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=EstadoDetalleAutoriConsepDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=EstadoDetalleAutoriConsepDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(EstadoDetalleAutoriConsepConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,EstadoDetalleAutoriConsepDataAccess.TABLENAME,EstadoDetalleAutoriConsepDataAccess.ISWITHSTOREPROCEDURES);
			
			EstadoDetalleAutoriConsepDataAccess.setEstadoDetalleAutoriConsepOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
	
		
		public List<DetalleAutoriConsep> getDetalleAutoriConseps(Connexion connexion,EstadoDetalleAutoriConsep estadodetalleautoriconsep)throws SQLException,Exception {

		List<DetalleAutoriConsep> detalleautoriconseps= new ArrayList<DetalleAutoriConsep>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstadoDetalleAutoriConsepConstantesFunciones.SCHEMA+".estado_detalle_autori_consep ON "+DetalleAutoriConsepConstantesFunciones.SCHEMA+".detalle_autori_consep.id_estado_detalle_autori_consep="+EstadoDetalleAutoriConsepConstantesFunciones.SCHEMA+".estado_detalle_autori_consep.id WHERE "+EstadoDetalleAutoriConsepConstantesFunciones.SCHEMA+".estado_detalle_autori_consep.id="+String.valueOf(estadodetalleautoriconsep.getId());
			} else {
				sQuery=" INNER JOIN detalleautoriconsep.EstadoDetalleAutoriConsep WHERE detalleautoriconsep.EstadoDetalleAutoriConsep.id="+String.valueOf(estadodetalleautoriconsep.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleAutoriConsepDataAccess detalleautoriconsepDataAccess=new DetalleAutoriConsepDataAccess();

			detalleautoriconsepDataAccess.setConnexionType(this.connexionType);
			detalleautoriconsepDataAccess.setParameterDbType(this.parameterDbType);
			detalleautoriconseps=detalleautoriconsepDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalleautoriconseps;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,EstadoDetalleAutoriConsep estadodetalleautoriconsep) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!estadodetalleautoriconsep.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid=new ParameterValue<Long>();
					parameterMaintenanceValueid.setValue(estadodetalleautoriconsep.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(estadodetalleautoriconsep.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(estadodetalleautoriconsep.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!estadodetalleautoriconsep.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(estadodetalleautoriconsep.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(estadodetalleautoriconsep.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(estadodetalleautoriconsep.getId());
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
	
	public void setIsNewIsChangedFalseEstadoDetalleAutoriConsep(EstadoDetalleAutoriConsep estadodetalleautoriconsep)throws Exception  {		
		estadodetalleautoriconsep.setIsNew(false);
		estadodetalleautoriconsep.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseEstadoDetalleAutoriConseps(List<EstadoDetalleAutoriConsep> estadodetalleautoriconseps)throws Exception  {				
		for(EstadoDetalleAutoriConsep estadodetalleautoriconsep:estadodetalleautoriconseps) {
			estadodetalleautoriconsep.setIsNew(false);
			estadodetalleautoriconsep.setIsChanged(false);
		}
	}
	
	public void generarExportarEstadoDetalleAutoriConsep(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
