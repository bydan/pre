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
import com.bydan.erp.cartera.util.*;//VehiculoClienteConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class VehiculoClienteDataAccess extends  VehiculoClienteDataAccessAdditional{ //VehiculoClienteDataAccessAdditional,DataAccessHelper<VehiculoCliente>
	//static Logger logger = Logger.getLogger(VehiculoClienteDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="vehiculo_cliente";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+VehiculoClienteConstantesFunciones.SCHEMA+"."+VehiculoClienteConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_cliente,codigo,marca,modelo,placa,anio,es_prendado,valor_avaluo)values(current_timestamp,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+VehiculoClienteConstantesFunciones.SCHEMA+"."+VehiculoClienteConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_cliente=?,codigo=?,marca=?,modelo=?,placa=?,anio=?,es_prendado=?,valor_avaluo=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+VehiculoClienteConstantesFunciones.SCHEMA+"."+VehiculoClienteConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select vehiculocliente from "+VehiculoClienteConstantesFunciones.SPERSISTENCENAME+" vehiculocliente";
	public static String QUERYSELECTNATIVE="select "+VehiculoClienteConstantesFunciones.SCHEMA+"."+VehiculoClienteConstantesFunciones.TABLENAME+".id,"+VehiculoClienteConstantesFunciones.SCHEMA+"."+VehiculoClienteConstantesFunciones.TABLENAME+".version_row,"+VehiculoClienteConstantesFunciones.SCHEMA+"."+VehiculoClienteConstantesFunciones.TABLENAME+".id_empresa,"+VehiculoClienteConstantesFunciones.SCHEMA+"."+VehiculoClienteConstantesFunciones.TABLENAME+".id_cliente,"+VehiculoClienteConstantesFunciones.SCHEMA+"."+VehiculoClienteConstantesFunciones.TABLENAME+".codigo,"+VehiculoClienteConstantesFunciones.SCHEMA+"."+VehiculoClienteConstantesFunciones.TABLENAME+".marca,"+VehiculoClienteConstantesFunciones.SCHEMA+"."+VehiculoClienteConstantesFunciones.TABLENAME+".modelo,"+VehiculoClienteConstantesFunciones.SCHEMA+"."+VehiculoClienteConstantesFunciones.TABLENAME+".placa,"+VehiculoClienteConstantesFunciones.SCHEMA+"."+VehiculoClienteConstantesFunciones.TABLENAME+".anio,"+VehiculoClienteConstantesFunciones.SCHEMA+"."+VehiculoClienteConstantesFunciones.TABLENAME+".es_prendado,"+VehiculoClienteConstantesFunciones.SCHEMA+"."+VehiculoClienteConstantesFunciones.TABLENAME+".valor_avaluo from "+VehiculoClienteConstantesFunciones.SCHEMA+"."+VehiculoClienteConstantesFunciones.TABLENAME;//+" as "+VehiculoClienteConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+VehiculoClienteConstantesFunciones.SCHEMA+"."+VehiculoClienteConstantesFunciones.TABLENAME+".id,"+VehiculoClienteConstantesFunciones.SCHEMA+"."+VehiculoClienteConstantesFunciones.TABLENAME+".version_row,"+VehiculoClienteConstantesFunciones.SCHEMA+"."+VehiculoClienteConstantesFunciones.TABLENAME+".codigo from "+VehiculoClienteConstantesFunciones.SCHEMA+"."+VehiculoClienteConstantesFunciones.TABLENAME;//+" as "+VehiculoClienteConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+VehiculoClienteConstantesFunciones.SCHEMA+"."+VehiculoClienteConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_cliente=?,codigo=?,marca=?,modelo=?,placa=?,anio=?,es_prendado=?,valor_avaluo=?";
	
	public static String STOREPROCEDUREINSERT="call SP_VEHICULOCLIENTE_INSERT(?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_VEHICULOCLIENTE_UPDATE(?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_VEHICULOCLIENTE_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_VEHICULOCLIENTE_SELECT(?,?)";
	
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
	
	
	protected VehiculoClienteDataAccessAdditional vehiculoclienteDataAccessAdditional=null;
	
	public VehiculoClienteDataAccessAdditional getVehiculoClienteDataAccessAdditional() {
		return this.vehiculoclienteDataAccessAdditional;
	}
	
	public void setVehiculoClienteDataAccessAdditional(VehiculoClienteDataAccessAdditional vehiculoclienteDataAccessAdditional) {
		try {
			this.vehiculoclienteDataAccessAdditional=vehiculoclienteDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public VehiculoClienteDataAccess() {
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
		VehiculoClienteDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		VehiculoClienteDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		VehiculoClienteDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setVehiculoClienteOriginal(VehiculoCliente vehiculocliente)throws Exception  {
		vehiculocliente.setVehiculoClienteOriginal((VehiculoCliente)vehiculocliente.clone());		
	}
	
	public void setVehiculoClientesOriginal(List<VehiculoCliente> vehiculoclientes)throws Exception  {
		
		for(VehiculoCliente vehiculocliente:vehiculoclientes){
			vehiculocliente.setVehiculoClienteOriginal((VehiculoCliente)vehiculocliente.clone());
		}
	}
	
	public static void setVehiculoClienteOriginalStatic(VehiculoCliente vehiculocliente)throws Exception  {
		vehiculocliente.setVehiculoClienteOriginal((VehiculoCliente)vehiculocliente.clone());		
	}
	
	public static void setVehiculoClientesOriginalStatic(List<VehiculoCliente> vehiculoclientes)throws Exception  {
		
		for(VehiculoCliente vehiculocliente:vehiculoclientes){
			vehiculocliente.setVehiculoClienteOriginal((VehiculoCliente)vehiculocliente.clone());
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
	
	public  VehiculoCliente getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		VehiculoCliente entity = new VehiculoCliente();		
		
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
	
	public  VehiculoCliente getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		VehiculoCliente entity = new VehiculoCliente();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=VehiculoClienteDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=VehiculoClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Cartera.VehiculoCliente.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setVehiculoClienteOriginal(new VehiculoCliente());
      	    	entity=super.getEntity("",entity,resultSet,VehiculoClienteDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityVehiculoCliente("",entity,resultSet); 
				
				//entity.setVehiculoClienteOriginal(super.getEntity("",entity.getVehiculoClienteOriginal(),resultSet,VehiculoClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setVehiculoClienteOriginal(this.getEntityVehiculoCliente("",entity.getVehiculoClienteOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseVehiculoCliente(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  VehiculoCliente getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		VehiculoCliente entity = new VehiculoCliente();
				
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
	
	public  VehiculoCliente getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		VehiculoCliente entity = new VehiculoCliente();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=VehiculoClienteDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=VehiculoClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,VehiculoClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.VehiculoCliente.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setVehiculoClienteOriginal(new VehiculoCliente());
      	    	entity=super.getEntity("",entity,resultSet,VehiculoClienteDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityVehiculoCliente("",entity,resultSet);    
				
				//entity.setVehiculoClienteOriginal(super.getEntity("",entity.getVehiculoClienteOriginal(),resultSet,VehiculoClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setVehiculoClienteOriginal(this.getEntityVehiculoCliente("",entity.getVehiculoClienteOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseVehiculoCliente(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //VehiculoCliente
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		VehiculoCliente entity = new VehiculoCliente();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=VehiculoClienteDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=VehiculoClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,VehiculoClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.VehiculoCliente.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseVehiculoCliente(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<VehiculoCliente> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<VehiculoCliente> entities = new  ArrayList<VehiculoCliente>();
		VehiculoCliente entity = new VehiculoCliente();		  
		
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
	
	public  List<VehiculoCliente> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<VehiculoCliente> entities = new  ArrayList<VehiculoCliente>();
		VehiculoCliente entity = new VehiculoCliente();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=VehiculoClienteDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=VehiculoClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,VehiculoClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new VehiculoCliente();
      	    	entity=super.getEntity("",entity,resultSet,VehiculoClienteDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityVehiculoCliente("",entity,resultSet);
      	    	
				//entity.setVehiculoClienteOriginal( new VehiculoCliente());
      	    	//entity.setVehiculoClienteOriginal(super.getEntity("",entity.getVehiculoClienteOriginal(),resultSet,VehiculoClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setVehiculoClienteOriginal(this.getEntityVehiculoCliente("",entity.getVehiculoClienteOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseVehiculoClientes(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarVehiculoCliente(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<VehiculoCliente> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<VehiculoCliente> entities = new  ArrayList<VehiculoCliente>();
		VehiculoCliente entity = new VehiculoCliente();		  
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
	
	public  List<VehiculoCliente> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<VehiculoCliente> entities = new  ArrayList<VehiculoCliente>();
		VehiculoCliente entity = new VehiculoCliente();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new VehiculoCliente();
				
				if(conMapGenerico) {
					entity.inicializarMapVehiculoCliente();
					//entity.setMapVehiculoCliente(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapVehiculoClienteValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapVehiculoCliente().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,VehiculoClienteDataAccess.ISWITHSCHEMA);         		
					entity=VehiculoClienteDataAccess.getEntityVehiculoCliente("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setVehiculoClienteOriginal( new VehiculoCliente());
					////entity.setVehiculoClienteOriginal(super.getEntity("",entity.getVehiculoClienteOriginal(),resultSet,VehiculoClienteDataAccess.ISWITHSCHEMA));         		
					////entity.setVehiculoClienteOriginal(this.getEntityVehiculoCliente("",entity.getVehiculoClienteOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseVehiculoClientes(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarVehiculoCliente(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public VehiculoCliente getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		VehiculoCliente entity = new VehiculoCliente();		  
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
	
	public  VehiculoCliente getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		VehiculoCliente entity = new VehiculoCliente();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new VehiculoCliente();
				
				if(conMapGenerico) {
					entity.inicializarMapVehiculoCliente();
					//entity.setMapVehiculoCliente(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapVehiculoClienteValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapVehiculoCliente().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,VehiculoClienteDataAccess.ISWITHSCHEMA);         		
					entity=VehiculoClienteDataAccess.getEntityVehiculoCliente("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setVehiculoClienteOriginal( new VehiculoCliente());
					////entity.setVehiculoClienteOriginal(super.getEntity("",entity.getVehiculoClienteOriginal(),resultSet,VehiculoClienteDataAccess.ISWITHSCHEMA));         		
					////entity.setVehiculoClienteOriginal(this.getEntityVehiculoCliente("",entity.getVehiculoClienteOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseVehiculoCliente(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarVehiculoCliente(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static VehiculoCliente getEntityVehiculoCliente(String strPrefijo,VehiculoCliente entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = VehiculoCliente.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = VehiculoCliente.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					VehiculoClienteDataAccess.setFieldReflectionVehiculoCliente(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasVehiculoCliente=VehiculoClienteConstantesFunciones.getTodosTiposColumnasVehiculoCliente();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasVehiculoCliente) {
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
							field = VehiculoCliente.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = VehiculoCliente.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						VehiculoClienteDataAccess.setFieldReflectionVehiculoCliente(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionVehiculoCliente(Field field,String strPrefijo,String sColumn,VehiculoCliente entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case VehiculoClienteConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case VehiculoClienteConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case VehiculoClienteConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case VehiculoClienteConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case VehiculoClienteConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case VehiculoClienteConstantesFunciones.MARCA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case VehiculoClienteConstantesFunciones.MODELO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case VehiculoClienteConstantesFunciones.PLACA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case VehiculoClienteConstantesFunciones.ANIO:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case VehiculoClienteConstantesFunciones.ESPRENDADO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case VehiculoClienteConstantesFunciones.VALORAVALUO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<VehiculoCliente>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<VehiculoCliente> entities = new  ArrayList<VehiculoCliente>();
		VehiculoCliente entity = new VehiculoCliente();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=VehiculoClienteDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=VehiculoClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,VehiculoClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new VehiculoCliente();
					entity=super.getEntity("",entity,resultSet,VehiculoClienteDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityVehiculoCliente("",entity,resultSet);
					
					//entity.setVehiculoClienteOriginal( new VehiculoCliente());
					//entity.setVehiculoClienteOriginal(super.getEntity("",entity.getVehiculoClienteOriginal(),resultSet,VehiculoClienteDataAccess.ISWITHSCHEMA));         		
					//entity.setVehiculoClienteOriginal(this.getEntityVehiculoCliente("",entity.getVehiculoClienteOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseVehiculoClientes(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarVehiculoCliente(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<VehiculoCliente>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<VehiculoCliente> entities = new  ArrayList<VehiculoCliente>();
		VehiculoCliente entity = new VehiculoCliente();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=VehiculoClienteDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=VehiculoClienteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,VehiculoClienteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<VehiculoCliente> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<VehiculoCliente> entities = new  ArrayList<VehiculoCliente>();
		VehiculoCliente entity = new VehiculoCliente();		  
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
	
	public  List<VehiculoCliente> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<VehiculoCliente> entities = new  ArrayList<VehiculoCliente>();
		VehiculoCliente entity = new VehiculoCliente();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new VehiculoCliente();
      	    	entity=super.getEntity("",entity,resultSet,VehiculoClienteDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityVehiculoCliente("",entity,resultSet);
      	    	
				//entity.setVehiculoClienteOriginal( new VehiculoCliente());
      	    	//entity.setVehiculoClienteOriginal(super.getEntity("",entity.getVehiculoClienteOriginal(),resultSet,VehiculoClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setVehiculoClienteOriginal(this.getEntityVehiculoCliente("",entity.getVehiculoClienteOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseVehiculoClientes(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarVehiculoCliente(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<VehiculoCliente> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<VehiculoCliente> entities = new  ArrayList<VehiculoCliente>();
		VehiculoCliente entity = new VehiculoCliente();		  
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
	
	public  List<VehiculoCliente> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<VehiculoCliente> entities = new  ArrayList<VehiculoCliente>();
		VehiculoCliente entity = new VehiculoCliente();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new VehiculoCliente();
      	    	entity=super.getEntity("",entity,resultSet,VehiculoClienteDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityVehiculoCliente("",entity,resultSet);
      	    	
				//entity.setVehiculoClienteOriginal( new VehiculoCliente());
      	    	//entity.setVehiculoClienteOriginal(super.getEntity("",entity.getVehiculoClienteOriginal(),resultSet,VehiculoClienteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setVehiculoClienteOriginal(this.getEntityVehiculoCliente("",entity.getVehiculoClienteOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseVehiculoClientes(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public VehiculoCliente getEntityVehiculoCliente(String strPrefijo,VehiculoCliente entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+VehiculoClienteConstantesFunciones.IDEMPRESA));
				entity.setid_cliente(resultSet.getLong(strPrefijo+VehiculoClienteConstantesFunciones.IDCLIENTE));
				entity.setcodigo(resultSet.getString(strPrefijo+VehiculoClienteConstantesFunciones.CODIGO));
				entity.setmarca(resultSet.getString(strPrefijo+VehiculoClienteConstantesFunciones.MARCA));
				entity.setmodelo(resultSet.getString(strPrefijo+VehiculoClienteConstantesFunciones.MODELO));
				entity.setplaca(resultSet.getString(strPrefijo+VehiculoClienteConstantesFunciones.PLACA));
				entity.setanio(resultSet.getInt(strPrefijo+VehiculoClienteConstantesFunciones.ANIO));
				entity.setes_prendado(resultSet.getBoolean(strPrefijo+VehiculoClienteConstantesFunciones.ESPRENDADO));
				entity.setvalor_avaluo(resultSet.getDouble(strPrefijo+VehiculoClienteConstantesFunciones.VALORAVALUO));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+VehiculoClienteConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowVehiculoCliente(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(VehiculoCliente entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=VehiculoClienteDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=VehiculoClienteDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=VehiculoClienteDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=VehiculoClienteDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(VehiculoClienteConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,VehiculoClienteDataAccess.TABLENAME,VehiculoClienteDataAccess.ISWITHSTOREPROCEDURES);
			
			VehiculoClienteDataAccess.setVehiculoClienteOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,VehiculoCliente relvehiculocliente)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relvehiculocliente.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Cliente getCliente(Connexion connexion,VehiculoCliente relvehiculocliente)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,relvehiculocliente.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,VehiculoCliente vehiculocliente) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!vehiculocliente.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(vehiculocliente.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_cliente.setValue(vehiculocliente.getid_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(vehiculocliente.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuemarca=new ParameterValue<String>();
					parameterMaintenanceValuemarca.setValue(vehiculocliente.getmarca());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuemarca);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuemodelo=new ParameterValue<String>();
					parameterMaintenanceValuemodelo.setValue(vehiculocliente.getmodelo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuemodelo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueplaca=new ParameterValue<String>();
					parameterMaintenanceValueplaca.setValue(vehiculocliente.getplaca());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueplaca);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValueanio=new ParameterValue<Integer>();
					parameterMaintenanceValueanio.setValue(vehiculocliente.getanio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueanio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_prendado=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_prendado.setValue(vehiculocliente.getes_prendado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_prendado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_avaluo=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_avaluo.setValue(vehiculocliente.getvalor_avaluo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_avaluo);
					parametersTemp.add(parameterMaintenance);
					
						if(!vehiculocliente.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(vehiculocliente.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(vehiculocliente.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(vehiculocliente.getId());
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
	
	public void setIsNewIsChangedFalseVehiculoCliente(VehiculoCliente vehiculocliente)throws Exception  {		
		vehiculocliente.setIsNew(false);
		vehiculocliente.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseVehiculoClientes(List<VehiculoCliente> vehiculoclientes)throws Exception  {				
		for(VehiculoCliente vehiculocliente:vehiculoclientes) {
			vehiculocliente.setIsNew(false);
			vehiculocliente.setIsChanged(false);
		}
	}
	
	public void generarExportarVehiculoCliente(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
