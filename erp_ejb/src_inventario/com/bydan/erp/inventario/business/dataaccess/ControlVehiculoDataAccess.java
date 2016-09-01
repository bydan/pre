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
import com.bydan.framework.erp.business.dataaccess.DataAccessHelper;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.inventario.util.*;//ControlVehiculoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class ControlVehiculoDataAccess extends  ControlVehiculoDataAccessAdditional{ //ControlVehiculoDataAccessAdditional,DataAccessHelper<ControlVehiculo>
	//static Logger logger = Logger.getLogger(ControlVehiculoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="control_vehiculo";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ControlVehiculoConstantesFunciones.SCHEMA+"."+ControlVehiculoConstantesFunciones.TABLENAME+"(version_row,id_empresa,nombre_conductor,numero_placa,fecha_entrada,fecha_salida)values(current_timestamp,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+ControlVehiculoConstantesFunciones.SCHEMA+"."+ControlVehiculoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,nombre_conductor=?,numero_placa=?,fecha_entrada=?,fecha_salida=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ControlVehiculoConstantesFunciones.SCHEMA+"."+ControlVehiculoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select controlvehiculo from "+ControlVehiculoConstantesFunciones.SPERSISTENCENAME+" controlvehiculo";
	public static String QUERYSELECTNATIVE="select "+ControlVehiculoConstantesFunciones.SCHEMA+"."+ControlVehiculoConstantesFunciones.TABLENAME+".id,"+ControlVehiculoConstantesFunciones.SCHEMA+"."+ControlVehiculoConstantesFunciones.TABLENAME+".version_row,"+ControlVehiculoConstantesFunciones.SCHEMA+"."+ControlVehiculoConstantesFunciones.TABLENAME+".id_empresa,"+ControlVehiculoConstantesFunciones.SCHEMA+"."+ControlVehiculoConstantesFunciones.TABLENAME+".nombre_conductor,"+ControlVehiculoConstantesFunciones.SCHEMA+"."+ControlVehiculoConstantesFunciones.TABLENAME+".numero_placa,"+ControlVehiculoConstantesFunciones.SCHEMA+"."+ControlVehiculoConstantesFunciones.TABLENAME+".fecha_entrada,"+ControlVehiculoConstantesFunciones.SCHEMA+"."+ControlVehiculoConstantesFunciones.TABLENAME+".fecha_salida from "+ControlVehiculoConstantesFunciones.SCHEMA+"."+ControlVehiculoConstantesFunciones.TABLENAME;//+" as "+ControlVehiculoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ControlVehiculoConstantesFunciones.SCHEMA+"."+ControlVehiculoConstantesFunciones.TABLENAME+".id,"+ControlVehiculoConstantesFunciones.SCHEMA+"."+ControlVehiculoConstantesFunciones.TABLENAME+".version_row,"+ControlVehiculoConstantesFunciones.SCHEMA+"."+ControlVehiculoConstantesFunciones.TABLENAME+".numero_placa from "+ControlVehiculoConstantesFunciones.SCHEMA+"."+ControlVehiculoConstantesFunciones.TABLENAME;//+" as "+ControlVehiculoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ControlVehiculoConstantesFunciones.SCHEMA+"."+ControlVehiculoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,nombre_conductor=?,numero_placa=?,fecha_entrada=?,fecha_salida=?";
	
	public static String STOREPROCEDUREINSERT="call SP_CONTROLVEHICULO_INSERT(?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_CONTROLVEHICULO_UPDATE(?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_CONTROLVEHICULO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_CONTROLVEHICULO_SELECT(?,?)";
	
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
	
	
	protected ControlVehiculoDataAccessAdditional controlvehiculoDataAccessAdditional=null;
	
	public ControlVehiculoDataAccessAdditional getControlVehiculoDataAccessAdditional() {
		return this.controlvehiculoDataAccessAdditional;
	}
	
	public void setControlVehiculoDataAccessAdditional(ControlVehiculoDataAccessAdditional controlvehiculoDataAccessAdditional) {
		try {
			this.controlvehiculoDataAccessAdditional=controlvehiculoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ControlVehiculoDataAccess() {
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
		ControlVehiculoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ControlVehiculoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ControlVehiculoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setControlVehiculoOriginal(ControlVehiculo controlvehiculo)throws Exception  {
		controlvehiculo.setControlVehiculoOriginal((ControlVehiculo)controlvehiculo.clone());		
	}
	
	public void setControlVehiculosOriginal(List<ControlVehiculo> controlvehiculos)throws Exception  {
		
		for(ControlVehiculo controlvehiculo:controlvehiculos){
			controlvehiculo.setControlVehiculoOriginal((ControlVehiculo)controlvehiculo.clone());
		}
	}
	
	public static void setControlVehiculoOriginalStatic(ControlVehiculo controlvehiculo)throws Exception  {
		controlvehiculo.setControlVehiculoOriginal((ControlVehiculo)controlvehiculo.clone());		
	}
	
	public static void setControlVehiculosOriginalStatic(List<ControlVehiculo> controlvehiculos)throws Exception  {
		
		for(ControlVehiculo controlvehiculo:controlvehiculos){
			controlvehiculo.setControlVehiculoOriginal((ControlVehiculo)controlvehiculo.clone());
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
	
	public  ControlVehiculo getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		ControlVehiculo entity = new ControlVehiculo();		
		
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
	
	public  ControlVehiculo getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		ControlVehiculo entity = new ControlVehiculo();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ControlVehiculoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ControlVehiculoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.ControlVehiculo.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setControlVehiculoOriginal(new ControlVehiculo());
      	    	entity=super.getEntity("",entity,resultSet,ControlVehiculoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityControlVehiculo("",entity,resultSet); 
				
				//entity.setControlVehiculoOriginal(super.getEntity("",entity.getControlVehiculoOriginal(),resultSet,ControlVehiculoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setControlVehiculoOriginal(this.getEntityControlVehiculo("",entity.getControlVehiculoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseControlVehiculo(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  ControlVehiculo getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ControlVehiculo entity = new ControlVehiculo();
				
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
	
	public  ControlVehiculo getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ControlVehiculo entity = new ControlVehiculo();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ControlVehiculoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ControlVehiculoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ControlVehiculoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.ControlVehiculo.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setControlVehiculoOriginal(new ControlVehiculo());
      	    	entity=super.getEntity("",entity,resultSet,ControlVehiculoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityControlVehiculo("",entity,resultSet);    
				
				//entity.setControlVehiculoOriginal(super.getEntity("",entity.getControlVehiculoOriginal(),resultSet,ControlVehiculoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setControlVehiculoOriginal(this.getEntityControlVehiculo("",entity.getControlVehiculoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseControlVehiculo(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //ControlVehiculo
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		ControlVehiculo entity = new ControlVehiculo();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ControlVehiculoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ControlVehiculoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ControlVehiculoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.ControlVehiculo.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseControlVehiculo(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<ControlVehiculo> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ControlVehiculo> entities = new  ArrayList<ControlVehiculo>();
		ControlVehiculo entity = new ControlVehiculo();		  
		
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
	
	public  List<ControlVehiculo> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ControlVehiculo> entities = new  ArrayList<ControlVehiculo>();
		ControlVehiculo entity = new ControlVehiculo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ControlVehiculoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ControlVehiculoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ControlVehiculoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ControlVehiculo();
      	    	entity=super.getEntity("",entity,resultSet,ControlVehiculoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityControlVehiculo("",entity,resultSet);
      	    	
				//entity.setControlVehiculoOriginal( new ControlVehiculo());
      	    	//entity.setControlVehiculoOriginal(super.getEntity("",entity.getControlVehiculoOriginal(),resultSet,ControlVehiculoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setControlVehiculoOriginal(this.getEntityControlVehiculo("",entity.getControlVehiculoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseControlVehiculos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarControlVehiculo(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ControlVehiculo> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ControlVehiculo> entities = new  ArrayList<ControlVehiculo>();
		ControlVehiculo entity = new ControlVehiculo();		  
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
	
	public  List<ControlVehiculo> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ControlVehiculo> entities = new  ArrayList<ControlVehiculo>();
		ControlVehiculo entity = new ControlVehiculo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ControlVehiculo();
				
				if(conMapGenerico) {
					entity.inicializarMapControlVehiculo();
					//entity.setMapControlVehiculo(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapControlVehiculoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapControlVehiculo().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ControlVehiculoDataAccess.ISWITHSCHEMA);         		
					entity=ControlVehiculoDataAccess.getEntityControlVehiculo("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setControlVehiculoOriginal( new ControlVehiculo());
					////entity.setControlVehiculoOriginal(super.getEntity("",entity.getControlVehiculoOriginal(),resultSet,ControlVehiculoDataAccess.ISWITHSCHEMA));         		
					////entity.setControlVehiculoOriginal(this.getEntityControlVehiculo("",entity.getControlVehiculoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseControlVehiculos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarControlVehiculo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public ControlVehiculo getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ControlVehiculo entity = new ControlVehiculo();		  
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
	
	public  ControlVehiculo getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ControlVehiculo entity = new ControlVehiculo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ControlVehiculo();
				
				if(conMapGenerico) {
					entity.inicializarMapControlVehiculo();
					//entity.setMapControlVehiculo(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapControlVehiculoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapControlVehiculo().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ControlVehiculoDataAccess.ISWITHSCHEMA);         		
					entity=ControlVehiculoDataAccess.getEntityControlVehiculo("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setControlVehiculoOriginal( new ControlVehiculo());
					////entity.setControlVehiculoOriginal(super.getEntity("",entity.getControlVehiculoOriginal(),resultSet,ControlVehiculoDataAccess.ISWITHSCHEMA));         		
					////entity.setControlVehiculoOriginal(this.getEntityControlVehiculo("",entity.getControlVehiculoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseControlVehiculo(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarControlVehiculo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ControlVehiculo getEntityControlVehiculo(String strPrefijo,ControlVehiculo entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = ControlVehiculo.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = ControlVehiculo.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ControlVehiculoDataAccess.setFieldReflectionControlVehiculo(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasControlVehiculo=ControlVehiculoConstantesFunciones.getTodosTiposColumnasControlVehiculo();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasControlVehiculo) {
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
							field = ControlVehiculo.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = ControlVehiculo.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ControlVehiculoDataAccess.setFieldReflectionControlVehiculo(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionControlVehiculo(Field field,String strPrefijo,String sColumn,ControlVehiculo entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ControlVehiculoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ControlVehiculoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ControlVehiculoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ControlVehiculoConstantesFunciones.NOMBRECONDUCTOR:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ControlVehiculoConstantesFunciones.NUMEROPLACA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ControlVehiculoConstantesFunciones.FECHAENTRADA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case ControlVehiculoConstantesFunciones.FECHASALIDA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ControlVehiculo>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<ControlVehiculo> entities = new  ArrayList<ControlVehiculo>();
		ControlVehiculo entity = new ControlVehiculo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ControlVehiculoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ControlVehiculoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ControlVehiculoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new ControlVehiculo();
					entity=super.getEntity("",entity,resultSet,ControlVehiculoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityControlVehiculo("",entity,resultSet);
					
					//entity.setControlVehiculoOriginal( new ControlVehiculo());
					//entity.setControlVehiculoOriginal(super.getEntity("",entity.getControlVehiculoOriginal(),resultSet,ControlVehiculoDataAccess.ISWITHSCHEMA));         		
					//entity.setControlVehiculoOriginal(this.getEntityControlVehiculo("",entity.getControlVehiculoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseControlVehiculos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarControlVehiculo(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ControlVehiculo>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<ControlVehiculo> entities = new  ArrayList<ControlVehiculo>();
		ControlVehiculo entity = new ControlVehiculo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ControlVehiculoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ControlVehiculoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ControlVehiculoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<ControlVehiculo> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ControlVehiculo> entities = new  ArrayList<ControlVehiculo>();
		ControlVehiculo entity = new ControlVehiculo();		  
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
	
	public  List<ControlVehiculo> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ControlVehiculo> entities = new  ArrayList<ControlVehiculo>();
		ControlVehiculo entity = new ControlVehiculo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ControlVehiculo();
      	    	entity=super.getEntity("",entity,resultSet,ControlVehiculoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityControlVehiculo("",entity,resultSet);
      	    	
				//entity.setControlVehiculoOriginal( new ControlVehiculo());
      	    	//entity.setControlVehiculoOriginal(super.getEntity("",entity.getControlVehiculoOriginal(),resultSet,ControlVehiculoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setControlVehiculoOriginal(this.getEntityControlVehiculo("",entity.getControlVehiculoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseControlVehiculos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarControlVehiculo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ControlVehiculo> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ControlVehiculo> entities = new  ArrayList<ControlVehiculo>();
		ControlVehiculo entity = new ControlVehiculo();		  
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
	
	public  List<ControlVehiculo> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ControlVehiculo> entities = new  ArrayList<ControlVehiculo>();
		ControlVehiculo entity = new ControlVehiculo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ControlVehiculo();
      	    	entity=super.getEntity("",entity,resultSet,ControlVehiculoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityControlVehiculo("",entity,resultSet);
      	    	
				//entity.setControlVehiculoOriginal( new ControlVehiculo());
      	    	//entity.setControlVehiculoOriginal(super.getEntity("",entity.getControlVehiculoOriginal(),resultSet,ControlVehiculoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setControlVehiculoOriginal(this.getEntityControlVehiculo("",entity.getControlVehiculoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseControlVehiculos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public ControlVehiculo getEntityControlVehiculo(String strPrefijo,ControlVehiculo entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+ControlVehiculoConstantesFunciones.IDEMPRESA));
				entity.setnombre_conductor(resultSet.getString(strPrefijo+ControlVehiculoConstantesFunciones.NOMBRECONDUCTOR));
				entity.setnumero_placa(resultSet.getString(strPrefijo+ControlVehiculoConstantesFunciones.NUMEROPLACA));
				entity.setfecha_entrada(new Date(resultSet.getDate(strPrefijo+ControlVehiculoConstantesFunciones.FECHAENTRADA).getTime()));
				entity.setfecha_salida(new Date(resultSet.getDate(strPrefijo+ControlVehiculoConstantesFunciones.FECHASALIDA).getTime()));
			} else {
				entity.setnumero_placa(resultSet.getString(strPrefijo+ControlVehiculoConstantesFunciones.NUMEROPLACA));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowControlVehiculo(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(ControlVehiculo entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ControlVehiculoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ControlVehiculoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ControlVehiculoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ControlVehiculoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ControlVehiculoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ControlVehiculoDataAccess.TABLENAME,ControlVehiculoDataAccess.ISWITHSTOREPROCEDURES);
			
			ControlVehiculoDataAccess.setControlVehiculoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,ControlVehiculo relcontrolvehiculo)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relcontrolvehiculo.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,ControlVehiculo controlvehiculo) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!controlvehiculo.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(controlvehiculo.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre_conductor=new ParameterValue<String>();
					parameterMaintenanceValuenombre_conductor.setValue(controlvehiculo.getnombre_conductor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre_conductor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_placa=new ParameterValue<String>();
					parameterMaintenanceValuenumero_placa.setValue(controlvehiculo.getnumero_placa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_placa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_entrada=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_entrada.setValue(controlvehiculo.getfecha_entrada());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_entrada);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_salida=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_salida.setValue(controlvehiculo.getfecha_salida());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_salida);
					parametersTemp.add(parameterMaintenance);
					
						if(!controlvehiculo.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(controlvehiculo.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(controlvehiculo.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(controlvehiculo.getId());
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
	
	public void setIsNewIsChangedFalseControlVehiculo(ControlVehiculo controlvehiculo)throws Exception  {		
		controlvehiculo.setIsNew(false);
		controlvehiculo.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseControlVehiculos(List<ControlVehiculo> controlvehiculos)throws Exception  {				
		for(ControlVehiculo controlvehiculo:controlvehiculos) {
			controlvehiculo.setIsNew(false);
			controlvehiculo.setIsChanged(false);
		}
	}
	
	public void generarExportarControlVehiculo(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
