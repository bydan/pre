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
package com.bydan.erp.activosfijos.business.dataaccess;

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

import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.activosfijos.util.*;//EstadoActivoFijoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.activosfijos.util.*;




@SuppressWarnings("unused")
final public class EstadoActivoFijoDataAccess extends  DataAccessHelper<EstadoActivoFijo>{ //EstadoActivoFijoDataAccessAdditional,DataAccessHelper<EstadoActivoFijo>
	//static Logger logger = Logger.getLogger(EstadoActivoFijoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="estado_activo_fijo";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+EstadoActivoFijoConstantesFunciones.SCHEMA+"."+EstadoActivoFijoConstantesFunciones.TABLENAME+"(version_row,id_empresa,codigo,nombre)values(current_timestamp,?,?,?)";
	public static String QUERYUPDATE="update "+EstadoActivoFijoConstantesFunciones.SCHEMA+"."+EstadoActivoFijoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,codigo=?,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+EstadoActivoFijoConstantesFunciones.SCHEMA+"."+EstadoActivoFijoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select estadoactivofijo from "+EstadoActivoFijoConstantesFunciones.SPERSISTENCENAME+" estadoactivofijo";
	public static String QUERYSELECTNATIVE="select "+EstadoActivoFijoConstantesFunciones.SCHEMA+"."+EstadoActivoFijoConstantesFunciones.TABLENAME+".id,"+EstadoActivoFijoConstantesFunciones.SCHEMA+"."+EstadoActivoFijoConstantesFunciones.TABLENAME+".version_row,"+EstadoActivoFijoConstantesFunciones.SCHEMA+"."+EstadoActivoFijoConstantesFunciones.TABLENAME+".id_empresa,"+EstadoActivoFijoConstantesFunciones.SCHEMA+"."+EstadoActivoFijoConstantesFunciones.TABLENAME+".codigo,"+EstadoActivoFijoConstantesFunciones.SCHEMA+"."+EstadoActivoFijoConstantesFunciones.TABLENAME+".nombre from "+EstadoActivoFijoConstantesFunciones.SCHEMA+"."+EstadoActivoFijoConstantesFunciones.TABLENAME;//+" as "+EstadoActivoFijoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+EstadoActivoFijoConstantesFunciones.SCHEMA+"."+EstadoActivoFijoConstantesFunciones.TABLENAME+".id,"+EstadoActivoFijoConstantesFunciones.SCHEMA+"."+EstadoActivoFijoConstantesFunciones.TABLENAME+".version_row,"+EstadoActivoFijoConstantesFunciones.SCHEMA+"."+EstadoActivoFijoConstantesFunciones.TABLENAME+".codigo from "+EstadoActivoFijoConstantesFunciones.SCHEMA+"."+EstadoActivoFijoConstantesFunciones.TABLENAME;//+" as "+EstadoActivoFijoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+EstadoActivoFijoConstantesFunciones.SCHEMA+"."+EstadoActivoFijoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,codigo=?,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_ESTADOACTIVOFIJO_INSERT(?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_ESTADOACTIVOFIJO_UPDATE(?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_ESTADOACTIVOFIJO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_ESTADOACTIVOFIJO_SELECT(?,?)";
	
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
	
	
	public EstadoActivoFijoDataAccess() {
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
		EstadoActivoFijoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		EstadoActivoFijoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		EstadoActivoFijoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setEstadoActivoFijoOriginal(EstadoActivoFijo estadoactivofijo)throws Exception  {
		estadoactivofijo.setEstadoActivoFijoOriginal((EstadoActivoFijo)estadoactivofijo.clone());		
	}
	
	public void setEstadoActivoFijosOriginal(List<EstadoActivoFijo> estadoactivofijos)throws Exception  {
		
		for(EstadoActivoFijo estadoactivofijo:estadoactivofijos){
			estadoactivofijo.setEstadoActivoFijoOriginal((EstadoActivoFijo)estadoactivofijo.clone());
		}
	}
	
	public static void setEstadoActivoFijoOriginalStatic(EstadoActivoFijo estadoactivofijo)throws Exception  {
		estadoactivofijo.setEstadoActivoFijoOriginal((EstadoActivoFijo)estadoactivofijo.clone());		
	}
	
	public static void setEstadoActivoFijosOriginalStatic(List<EstadoActivoFijo> estadoactivofijos)throws Exception  {
		
		for(EstadoActivoFijo estadoactivofijo:estadoactivofijos){
			estadoactivofijo.setEstadoActivoFijoOriginal((EstadoActivoFijo)estadoactivofijo.clone());
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
	
	public  EstadoActivoFijo getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		EstadoActivoFijo entity = new EstadoActivoFijo();		
		
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
	
	public  EstadoActivoFijo getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		EstadoActivoFijo entity = new EstadoActivoFijo();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoActivoFijoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoActivoFijoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//ActivosFijos.EstadoActivoFijo.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setEstadoActivoFijoOriginal(new EstadoActivoFijo());
      	    	entity=super.getEntity("",entity,resultSet,EstadoActivoFijoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEstadoActivoFijo("",entity,resultSet); 
				
				//entity.setEstadoActivoFijoOriginal(super.getEntity("",entity.getEstadoActivoFijoOriginal(),resultSet,EstadoActivoFijoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoActivoFijoOriginal(this.getEntityEstadoActivoFijo("",entity.getEstadoActivoFijoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseEstadoActivoFijo(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  EstadoActivoFijo getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EstadoActivoFijo entity = new EstadoActivoFijo();
				
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
	
	public  EstadoActivoFijo getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EstadoActivoFijo entity = new EstadoActivoFijo();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoActivoFijoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoActivoFijoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EstadoActivoFijoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//ActivosFijos.EstadoActivoFijo.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setEstadoActivoFijoOriginal(new EstadoActivoFijo());
      	    	entity=super.getEntity("",entity,resultSet,EstadoActivoFijoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEstadoActivoFijo("",entity,resultSet);    
				
				//entity.setEstadoActivoFijoOriginal(super.getEntity("",entity.getEstadoActivoFijoOriginal(),resultSet,EstadoActivoFijoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoActivoFijoOriginal(this.getEntityEstadoActivoFijo("",entity.getEstadoActivoFijoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseEstadoActivoFijo(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //EstadoActivoFijo
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		EstadoActivoFijo entity = new EstadoActivoFijo();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoActivoFijoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoActivoFijoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EstadoActivoFijoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//ActivosFijos.EstadoActivoFijo.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseEstadoActivoFijo(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<EstadoActivoFijo> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EstadoActivoFijo> entities = new  ArrayList<EstadoActivoFijo>();
		EstadoActivoFijo entity = new EstadoActivoFijo();		  
		
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
	
	public  List<EstadoActivoFijo> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EstadoActivoFijo> entities = new  ArrayList<EstadoActivoFijo>();
		EstadoActivoFijo entity = new EstadoActivoFijo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoActivoFijoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoActivoFijoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EstadoActivoFijoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoActivoFijo();
      	    	entity=super.getEntity("",entity,resultSet,EstadoActivoFijoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoActivoFijo("",entity,resultSet);
      	    	
				//entity.setEstadoActivoFijoOriginal( new EstadoActivoFijo());
      	    	//entity.setEstadoActivoFijoOriginal(super.getEntity("",entity.getEstadoActivoFijoOriginal(),resultSet,EstadoActivoFijoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoActivoFijoOriginal(this.getEntityEstadoActivoFijo("",entity.getEstadoActivoFijoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoActivoFijos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoActivoFijo(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<EstadoActivoFijo> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EstadoActivoFijo> entities = new  ArrayList<EstadoActivoFijo>();
		EstadoActivoFijo entity = new EstadoActivoFijo();		  
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
	
	public  List<EstadoActivoFijo> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EstadoActivoFijo> entities = new  ArrayList<EstadoActivoFijo>();
		EstadoActivoFijo entity = new EstadoActivoFijo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoActivoFijo();
				
				if(conMapGenerico) {
					entity.inicializarMapEstadoActivoFijo();
					//entity.setMapEstadoActivoFijo(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapEstadoActivoFijoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEstadoActivoFijo().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EstadoActivoFijoDataAccess.ISWITHSCHEMA);         		
					entity=EstadoActivoFijoDataAccess.getEntityEstadoActivoFijo("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEstadoActivoFijoOriginal( new EstadoActivoFijo());
					////entity.setEstadoActivoFijoOriginal(super.getEntity("",entity.getEstadoActivoFijoOriginal(),resultSet,EstadoActivoFijoDataAccess.ISWITHSCHEMA));         		
					////entity.setEstadoActivoFijoOriginal(this.getEntityEstadoActivoFijo("",entity.getEstadoActivoFijoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoActivoFijos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoActivoFijo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public EstadoActivoFijo getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EstadoActivoFijo entity = new EstadoActivoFijo();		  
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
	
	public  EstadoActivoFijo getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EstadoActivoFijo entity = new EstadoActivoFijo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoActivoFijo();
				
				if(conMapGenerico) {
					entity.inicializarMapEstadoActivoFijo();
					//entity.setMapEstadoActivoFijo(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapEstadoActivoFijoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEstadoActivoFijo().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EstadoActivoFijoDataAccess.ISWITHSCHEMA);         		
					entity=EstadoActivoFijoDataAccess.getEntityEstadoActivoFijo("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEstadoActivoFijoOriginal( new EstadoActivoFijo());
					////entity.setEstadoActivoFijoOriginal(super.getEntity("",entity.getEstadoActivoFijoOriginal(),resultSet,EstadoActivoFijoDataAccess.ISWITHSCHEMA));         		
					////entity.setEstadoActivoFijoOriginal(this.getEntityEstadoActivoFijo("",entity.getEstadoActivoFijoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseEstadoActivoFijo(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoActivoFijo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static EstadoActivoFijo getEntityEstadoActivoFijo(String strPrefijo,EstadoActivoFijo entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = EstadoActivoFijo.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = EstadoActivoFijo.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					EstadoActivoFijoDataAccess.setFieldReflectionEstadoActivoFijo(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasEstadoActivoFijo=EstadoActivoFijoConstantesFunciones.getTodosTiposColumnasEstadoActivoFijo();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasEstadoActivoFijo) {
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
							field = EstadoActivoFijo.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = EstadoActivoFijo.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						EstadoActivoFijoDataAccess.setFieldReflectionEstadoActivoFijo(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionEstadoActivoFijo(Field field,String strPrefijo,String sColumn,EstadoActivoFijo entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case EstadoActivoFijoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EstadoActivoFijoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EstadoActivoFijoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EstadoActivoFijoConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EstadoActivoFijoConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EstadoActivoFijo>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<EstadoActivoFijo> entities = new  ArrayList<EstadoActivoFijo>();
		EstadoActivoFijo entity = new EstadoActivoFijo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoActivoFijoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoActivoFijoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EstadoActivoFijoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new EstadoActivoFijo();
					entity=super.getEntity("",entity,resultSet,EstadoActivoFijoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityEstadoActivoFijo("",entity,resultSet);
					
					//entity.setEstadoActivoFijoOriginal( new EstadoActivoFijo());
					//entity.setEstadoActivoFijoOriginal(super.getEntity("",entity.getEstadoActivoFijoOriginal(),resultSet,EstadoActivoFijoDataAccess.ISWITHSCHEMA));         		
					//entity.setEstadoActivoFijoOriginal(this.getEntityEstadoActivoFijo("",entity.getEstadoActivoFijoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseEstadoActivoFijos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoActivoFijo(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EstadoActivoFijo>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<EstadoActivoFijo> entities = new  ArrayList<EstadoActivoFijo>();
		EstadoActivoFijo entity = new EstadoActivoFijo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoActivoFijoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoActivoFijoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EstadoActivoFijoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<EstadoActivoFijo> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoActivoFijo> entities = new  ArrayList<EstadoActivoFijo>();
		EstadoActivoFijo entity = new EstadoActivoFijo();		  
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
	
	public  List<EstadoActivoFijo> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoActivoFijo> entities = new  ArrayList<EstadoActivoFijo>();
		EstadoActivoFijo entity = new EstadoActivoFijo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoActivoFijo();
      	    	entity=super.getEntity("",entity,resultSet,EstadoActivoFijoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoActivoFijo("",entity,resultSet);
      	    	
				//entity.setEstadoActivoFijoOriginal( new EstadoActivoFijo());
      	    	//entity.setEstadoActivoFijoOriginal(super.getEntity("",entity.getEstadoActivoFijoOriginal(),resultSet,EstadoActivoFijoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoActivoFijoOriginal(this.getEntityEstadoActivoFijo("",entity.getEstadoActivoFijoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseEstadoActivoFijos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoActivoFijo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	
	
	public EstadoActivoFijo getEntityEstadoActivoFijo(String strPrefijo,EstadoActivoFijo entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+EstadoActivoFijoConstantesFunciones.IDEMPRESA));
				entity.setcodigo(resultSet.getString(strPrefijo+EstadoActivoFijoConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+EstadoActivoFijoConstantesFunciones.NOMBRE));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+EstadoActivoFijoConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowEstadoActivoFijo(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(EstadoActivoFijo entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=EstadoActivoFijoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=EstadoActivoFijoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=EstadoActivoFijoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=EstadoActivoFijoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(EstadoActivoFijoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,EstadoActivoFijoDataAccess.TABLENAME,EstadoActivoFijoDataAccess.ISWITHSTOREPROCEDURES);
			
			EstadoActivoFijoDataAccess.setEstadoActivoFijoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,EstadoActivoFijo relestadoactivofijo)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relestadoactivofijo.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}


		
		public List<DetalleActivoFijo> getDetalleActivoFijos(Connexion connexion,EstadoActivoFijo estadoactivofijo)throws SQLException,Exception {

		List<DetalleActivoFijo> detalleactivofijos= new ArrayList<DetalleActivoFijo>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstadoActivoFijoConstantesFunciones.SCHEMA+".estado_activo_fijo ON "+DetalleActivoFijoConstantesFunciones.SCHEMA+".detalle_activo_fijo.id_estado_activo_fijo="+EstadoActivoFijoConstantesFunciones.SCHEMA+".estado_activo_fijo.id WHERE "+EstadoActivoFijoConstantesFunciones.SCHEMA+".estado_activo_fijo.id="+String.valueOf(estadoactivofijo.getId());
			} else {
				sQuery=" INNER JOIN detalleactivofijo.EstadoActivoFijo WHERE detalleactivofijo.EstadoActivoFijo.id="+String.valueOf(estadoactivofijo.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleActivoFijoDataAccess detalleactivofijoDataAccess=new DetalleActivoFijoDataAccess();

			detalleactivofijoDataAccess.setConnexionType(this.connexionType);
			detalleactivofijoDataAccess.setParameterDbType(this.parameterDbType);
			detalleactivofijos=detalleactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalleactivofijos;

	}

	public List<ParteActivoFijo> getParteActivoFijos(Connexion connexion,EstadoActivoFijo estadoactivofijo)throws SQLException,Exception {

		List<ParteActivoFijo> parteactivofijos= new ArrayList<ParteActivoFijo>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstadoActivoFijoConstantesFunciones.SCHEMA+".estado_activo_fijo ON "+ParteActivoFijoConstantesFunciones.SCHEMA+".parte_activo_fijo.id_estado_activo_fijo="+EstadoActivoFijoConstantesFunciones.SCHEMA+".estado_activo_fijo.id WHERE "+EstadoActivoFijoConstantesFunciones.SCHEMA+".estado_activo_fijo.id="+String.valueOf(estadoactivofijo.getId());
			} else {
				sQuery=" INNER JOIN parteactivofijo.EstadoActivoFijo WHERE parteactivofijo.EstadoActivoFijo.id="+String.valueOf(estadoactivofijo.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ParteActivoFijoDataAccess parteactivofijoDataAccess=new ParteActivoFijoDataAccess();

			parteactivofijoDataAccess.setConnexionType(this.connexionType);
			parteactivofijoDataAccess.setParameterDbType(this.parameterDbType);
			parteactivofijos=parteactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return parteactivofijos;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,EstadoActivoFijo estadoactivofijo) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!estadoactivofijo.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(estadoactivofijo.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(estadoactivofijo.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(estadoactivofijo.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!estadoactivofijo.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(estadoactivofijo.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(estadoactivofijo.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(estadoactivofijo.getId());
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
	
	public void setIsNewIsChangedFalseEstadoActivoFijo(EstadoActivoFijo estadoactivofijo)throws Exception  {		
		estadoactivofijo.setIsNew(false);
		estadoactivofijo.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseEstadoActivoFijos(List<EstadoActivoFijo> estadoactivofijos)throws Exception  {				
		for(EstadoActivoFijo estadoactivofijo:estadoactivofijos) {
			estadoactivofijo.setIsNew(false);
			estadoactivofijo.setIsChanged(false);
		}
	}
	
	public void generarExportarEstadoActivoFijo(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
