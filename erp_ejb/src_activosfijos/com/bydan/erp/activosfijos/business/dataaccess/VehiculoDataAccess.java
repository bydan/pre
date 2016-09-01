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
import com.bydan.erp.activosfijos.util.*;//VehiculoConstantesFunciones;


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
final public class VehiculoDataAccess extends  VehiculoDataAccessAdditional{ //VehiculoDataAccessAdditional,DataAccessHelper<Vehiculo>
	//static Logger logger = Logger.getLogger(VehiculoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="vehiculo";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+VehiculoConstantesFunciones.SCHEMA+"."+VehiculoConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_detalle_activo_fijo,id_aseguradora,numero_poliza,fecha_emision,fecha_vencimiento,valor_asegurado,valor_deducible,numero_matricula,numero_motor,numero_chasis,numero_placa,valor_comercial,descripcion)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+VehiculoConstantesFunciones.SCHEMA+"."+VehiculoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_detalle_activo_fijo=?,id_aseguradora=?,numero_poliza=?,fecha_emision=?,fecha_vencimiento=?,valor_asegurado=?,valor_deducible=?,numero_matricula=?,numero_motor=?,numero_chasis=?,numero_placa=?,valor_comercial=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+VehiculoConstantesFunciones.SCHEMA+"."+VehiculoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select vehiculo from "+VehiculoConstantesFunciones.SPERSISTENCENAME+" vehiculo";
	public static String QUERYSELECTNATIVE="select "+VehiculoConstantesFunciones.SCHEMA+"."+VehiculoConstantesFunciones.TABLENAME+".id,"+VehiculoConstantesFunciones.SCHEMA+"."+VehiculoConstantesFunciones.TABLENAME+".version_row,"+VehiculoConstantesFunciones.SCHEMA+"."+VehiculoConstantesFunciones.TABLENAME+".id_empresa,"+VehiculoConstantesFunciones.SCHEMA+"."+VehiculoConstantesFunciones.TABLENAME+".id_sucursal,"+VehiculoConstantesFunciones.SCHEMA+"."+VehiculoConstantesFunciones.TABLENAME+".id_detalle_activo_fijo,"+VehiculoConstantesFunciones.SCHEMA+"."+VehiculoConstantesFunciones.TABLENAME+".id_aseguradora,"+VehiculoConstantesFunciones.SCHEMA+"."+VehiculoConstantesFunciones.TABLENAME+".numero_poliza,"+VehiculoConstantesFunciones.SCHEMA+"."+VehiculoConstantesFunciones.TABLENAME+".fecha_emision,"+VehiculoConstantesFunciones.SCHEMA+"."+VehiculoConstantesFunciones.TABLENAME+".fecha_vencimiento,"+VehiculoConstantesFunciones.SCHEMA+"."+VehiculoConstantesFunciones.TABLENAME+".valor_asegurado,"+VehiculoConstantesFunciones.SCHEMA+"."+VehiculoConstantesFunciones.TABLENAME+".valor_deducible,"+VehiculoConstantesFunciones.SCHEMA+"."+VehiculoConstantesFunciones.TABLENAME+".numero_matricula,"+VehiculoConstantesFunciones.SCHEMA+"."+VehiculoConstantesFunciones.TABLENAME+".numero_motor,"+VehiculoConstantesFunciones.SCHEMA+"."+VehiculoConstantesFunciones.TABLENAME+".numero_chasis,"+VehiculoConstantesFunciones.SCHEMA+"."+VehiculoConstantesFunciones.TABLENAME+".numero_placa,"+VehiculoConstantesFunciones.SCHEMA+"."+VehiculoConstantesFunciones.TABLENAME+".valor_comercial,"+VehiculoConstantesFunciones.SCHEMA+"."+VehiculoConstantesFunciones.TABLENAME+".descripcion from "+VehiculoConstantesFunciones.SCHEMA+"."+VehiculoConstantesFunciones.TABLENAME;//+" as "+VehiculoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+VehiculoConstantesFunciones.SCHEMA+"."+VehiculoConstantesFunciones.TABLENAME+".id,"+VehiculoConstantesFunciones.SCHEMA+"."+VehiculoConstantesFunciones.TABLENAME+".version_row from "+VehiculoConstantesFunciones.SCHEMA+"."+VehiculoConstantesFunciones.TABLENAME;//+" as "+VehiculoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+VehiculoConstantesFunciones.SCHEMA+"."+VehiculoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_detalle_activo_fijo=?,id_aseguradora=?,numero_poliza=?,fecha_emision=?,fecha_vencimiento=?,valor_asegurado=?,valor_deducible=?,numero_matricula=?,numero_motor=?,numero_chasis=?,numero_placa=?,valor_comercial=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_VEHICULO_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_VEHICULO_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_VEHICULO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_VEHICULO_SELECT(?,?)";
	
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
	
	
	protected VehiculoDataAccessAdditional vehiculoDataAccessAdditional=null;
	
	public VehiculoDataAccessAdditional getVehiculoDataAccessAdditional() {
		return this.vehiculoDataAccessAdditional;
	}
	
	public void setVehiculoDataAccessAdditional(VehiculoDataAccessAdditional vehiculoDataAccessAdditional) {
		try {
			this.vehiculoDataAccessAdditional=vehiculoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public VehiculoDataAccess() {
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
		VehiculoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		VehiculoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		VehiculoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setVehiculoOriginal(Vehiculo vehiculo)throws Exception  {
		vehiculo.setVehiculoOriginal((Vehiculo)vehiculo.clone());		
	}
	
	public void setVehiculosOriginal(List<Vehiculo> vehiculos)throws Exception  {
		
		for(Vehiculo vehiculo:vehiculos){
			vehiculo.setVehiculoOriginal((Vehiculo)vehiculo.clone());
		}
	}
	
	public static void setVehiculoOriginalStatic(Vehiculo vehiculo)throws Exception  {
		vehiculo.setVehiculoOriginal((Vehiculo)vehiculo.clone());		
	}
	
	public static void setVehiculosOriginalStatic(List<Vehiculo> vehiculos)throws Exception  {
		
		for(Vehiculo vehiculo:vehiculos){
			vehiculo.setVehiculoOriginal((Vehiculo)vehiculo.clone());
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
	
	public  Vehiculo getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		Vehiculo entity = new Vehiculo();		
		
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
	
	public  Vehiculo getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		Vehiculo entity = new Vehiculo();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=VehiculoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=VehiculoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//ActivosFijos.Vehiculo.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setVehiculoOriginal(new Vehiculo());
      	    	entity=super.getEntity("",entity,resultSet,VehiculoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityVehiculo("",entity,resultSet); 
				
				//entity.setVehiculoOriginal(super.getEntity("",entity.getVehiculoOriginal(),resultSet,VehiculoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setVehiculoOriginal(this.getEntityVehiculo("",entity.getVehiculoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseVehiculo(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  Vehiculo getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Vehiculo entity = new Vehiculo();
				
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
	
	public  Vehiculo getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Vehiculo entity = new Vehiculo();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=VehiculoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=VehiculoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,VehiculoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//ActivosFijos.Vehiculo.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setVehiculoOriginal(new Vehiculo());
      	    	entity=super.getEntity("",entity,resultSet,VehiculoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityVehiculo("",entity,resultSet);    
				
				//entity.setVehiculoOriginal(super.getEntity("",entity.getVehiculoOriginal(),resultSet,VehiculoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setVehiculoOriginal(this.getEntityVehiculo("",entity.getVehiculoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseVehiculo(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //Vehiculo
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		Vehiculo entity = new Vehiculo();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=VehiculoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=VehiculoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,VehiculoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//ActivosFijos.Vehiculo.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseVehiculo(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<Vehiculo> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Vehiculo> entities = new  ArrayList<Vehiculo>();
		Vehiculo entity = new Vehiculo();		  
		
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
	
	public  List<Vehiculo> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Vehiculo> entities = new  ArrayList<Vehiculo>();
		Vehiculo entity = new Vehiculo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=VehiculoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=VehiculoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,VehiculoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Vehiculo();
      	    	entity=super.getEntity("",entity,resultSet,VehiculoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityVehiculo("",entity,resultSet);
      	    	
				//entity.setVehiculoOriginal( new Vehiculo());
      	    	//entity.setVehiculoOriginal(super.getEntity("",entity.getVehiculoOriginal(),resultSet,VehiculoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setVehiculoOriginal(this.getEntityVehiculo("",entity.getVehiculoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseVehiculos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarVehiculo(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Vehiculo> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Vehiculo> entities = new  ArrayList<Vehiculo>();
		Vehiculo entity = new Vehiculo();		  
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
	
	public  List<Vehiculo> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Vehiculo> entities = new  ArrayList<Vehiculo>();
		Vehiculo entity = new Vehiculo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Vehiculo();
				
				if(conMapGenerico) {
					entity.inicializarMapVehiculo();
					//entity.setMapVehiculo(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapVehiculoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapVehiculo().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,VehiculoDataAccess.ISWITHSCHEMA);         		
					entity=VehiculoDataAccess.getEntityVehiculo("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setVehiculoOriginal( new Vehiculo());
					////entity.setVehiculoOriginal(super.getEntity("",entity.getVehiculoOriginal(),resultSet,VehiculoDataAccess.ISWITHSCHEMA));         		
					////entity.setVehiculoOriginal(this.getEntityVehiculo("",entity.getVehiculoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseVehiculos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarVehiculo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public Vehiculo getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Vehiculo entity = new Vehiculo();		  
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
	
	public  Vehiculo getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Vehiculo entity = new Vehiculo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Vehiculo();
				
				if(conMapGenerico) {
					entity.inicializarMapVehiculo();
					//entity.setMapVehiculo(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapVehiculoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapVehiculo().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,VehiculoDataAccess.ISWITHSCHEMA);         		
					entity=VehiculoDataAccess.getEntityVehiculo("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setVehiculoOriginal( new Vehiculo());
					////entity.setVehiculoOriginal(super.getEntity("",entity.getVehiculoOriginal(),resultSet,VehiculoDataAccess.ISWITHSCHEMA));         		
					////entity.setVehiculoOriginal(this.getEntityVehiculo("",entity.getVehiculoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseVehiculo(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarVehiculo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static Vehiculo getEntityVehiculo(String strPrefijo,Vehiculo entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = Vehiculo.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = Vehiculo.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					VehiculoDataAccess.setFieldReflectionVehiculo(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasVehiculo=VehiculoConstantesFunciones.getTodosTiposColumnasVehiculo();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasVehiculo) {
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
							field = Vehiculo.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = Vehiculo.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						VehiculoDataAccess.setFieldReflectionVehiculo(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionVehiculo(Field field,String strPrefijo,String sColumn,Vehiculo entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case VehiculoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case VehiculoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case VehiculoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case VehiculoConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case VehiculoConstantesFunciones.IDDETALLEACTIVOFIJO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case VehiculoConstantesFunciones.IDASEGURADORA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case VehiculoConstantesFunciones.NUMEROPOLIZA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case VehiculoConstantesFunciones.FECHAEMISION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case VehiculoConstantesFunciones.FECHAVENCIMIENTO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case VehiculoConstantesFunciones.VALORASEGURADO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case VehiculoConstantesFunciones.VALORDEDUCIBLE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case VehiculoConstantesFunciones.NUMEROMATRICULA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case VehiculoConstantesFunciones.NUMEROMOTOR:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case VehiculoConstantesFunciones.NUMEROCHASIS:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case VehiculoConstantesFunciones.NUMEROPLACA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case VehiculoConstantesFunciones.VALORCOMERCIAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case VehiculoConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Vehiculo>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<Vehiculo> entities = new  ArrayList<Vehiculo>();
		Vehiculo entity = new Vehiculo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=VehiculoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=VehiculoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,VehiculoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new Vehiculo();
					entity=super.getEntity("",entity,resultSet,VehiculoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityVehiculo("",entity,resultSet);
					
					//entity.setVehiculoOriginal( new Vehiculo());
					//entity.setVehiculoOriginal(super.getEntity("",entity.getVehiculoOriginal(),resultSet,VehiculoDataAccess.ISWITHSCHEMA));         		
					//entity.setVehiculoOriginal(this.getEntityVehiculo("",entity.getVehiculoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseVehiculos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarVehiculo(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Vehiculo>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<Vehiculo> entities = new  ArrayList<Vehiculo>();
		Vehiculo entity = new Vehiculo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=VehiculoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=VehiculoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,VehiculoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<Vehiculo> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Vehiculo> entities = new  ArrayList<Vehiculo>();
		Vehiculo entity = new Vehiculo();		  
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
	
	public  List<Vehiculo> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Vehiculo> entities = new  ArrayList<Vehiculo>();
		Vehiculo entity = new Vehiculo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Vehiculo();
      	    	entity=super.getEntity("",entity,resultSet,VehiculoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityVehiculo("",entity,resultSet);
      	    	
				//entity.setVehiculoOriginal( new Vehiculo());
      	    	//entity.setVehiculoOriginal(super.getEntity("",entity.getVehiculoOriginal(),resultSet,VehiculoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setVehiculoOriginal(this.getEntityVehiculo("",entity.getVehiculoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseVehiculos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarVehiculo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Vehiculo> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Vehiculo> entities = new  ArrayList<Vehiculo>();
		Vehiculo entity = new Vehiculo();		  
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
	
	public  List<Vehiculo> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Vehiculo> entities = new  ArrayList<Vehiculo>();
		Vehiculo entity = new Vehiculo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Vehiculo();
      	    	entity=super.getEntity("",entity,resultSet,VehiculoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityVehiculo("",entity,resultSet);
      	    	
				//entity.setVehiculoOriginal( new Vehiculo());
      	    	//entity.setVehiculoOriginal(super.getEntity("",entity.getVehiculoOriginal(),resultSet,VehiculoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setVehiculoOriginal(this.getEntityVehiculo("",entity.getVehiculoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseVehiculos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public Vehiculo getEntityVehiculo(String strPrefijo,Vehiculo entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+VehiculoConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+VehiculoConstantesFunciones.IDSUCURSAL));
				entity.setid_detalle_activo_fijo(resultSet.getLong(strPrefijo+VehiculoConstantesFunciones.IDDETALLEACTIVOFIJO));
				entity.setid_aseguradora(resultSet.getLong(strPrefijo+VehiculoConstantesFunciones.IDASEGURADORA));
				entity.setnumero_poliza(resultSet.getString(strPrefijo+VehiculoConstantesFunciones.NUMEROPOLIZA));
				entity.setfecha_emision(new Date(resultSet.getDate(strPrefijo+VehiculoConstantesFunciones.FECHAEMISION).getTime()));
				entity.setfecha_vencimiento(new Date(resultSet.getDate(strPrefijo+VehiculoConstantesFunciones.FECHAVENCIMIENTO).getTime()));
				entity.setvalor_asegurado(resultSet.getDouble(strPrefijo+VehiculoConstantesFunciones.VALORASEGURADO));
				entity.setvalor_deducible(resultSet.getDouble(strPrefijo+VehiculoConstantesFunciones.VALORDEDUCIBLE));
				entity.setnumero_matricula(resultSet.getString(strPrefijo+VehiculoConstantesFunciones.NUMEROMATRICULA));
				entity.setnumero_motor(resultSet.getString(strPrefijo+VehiculoConstantesFunciones.NUMEROMOTOR));
				entity.setnumero_chasis(resultSet.getString(strPrefijo+VehiculoConstantesFunciones.NUMEROCHASIS));
				entity.setnumero_placa(resultSet.getString(strPrefijo+VehiculoConstantesFunciones.NUMEROPLACA));
				entity.setvalor_comercial(resultSet.getDouble(strPrefijo+VehiculoConstantesFunciones.VALORCOMERCIAL));
				entity.setdescripcion(resultSet.getString(strPrefijo+VehiculoConstantesFunciones.DESCRIPCION));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowVehiculo(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(Vehiculo entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=VehiculoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=VehiculoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=VehiculoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=VehiculoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(VehiculoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,VehiculoDataAccess.TABLENAME,VehiculoDataAccess.ISWITHSTOREPROCEDURES);
			
			VehiculoDataAccess.setVehiculoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,Vehiculo relvehiculo)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relvehiculo.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,Vehiculo relvehiculo)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relvehiculo.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public DetalleActivoFijo getDetalleActivoFijo(Connexion connexion,Vehiculo relvehiculo)throws SQLException,Exception {

		DetalleActivoFijo detalleactivofijo= new DetalleActivoFijo();

		try {
			DetalleActivoFijoDataAccess detalleactivofijoDataAccess=new DetalleActivoFijoDataAccess();

			detalleactivofijoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			detalleactivofijoDataAccess.setConnexionType(this.connexionType);
			detalleactivofijoDataAccess.setParameterDbType(this.parameterDbType);

			detalleactivofijo=detalleactivofijoDataAccess.getEntity(connexion,relvehiculo.getid_detalle_activo_fijo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalleactivofijo;

	}

	public Aseguradora getAseguradora(Connexion connexion,Vehiculo relvehiculo)throws SQLException,Exception {

		Aseguradora aseguradora= new Aseguradora();

		try {
			AseguradoraDataAccess aseguradoraDataAccess=new AseguradoraDataAccess();

			aseguradoraDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			aseguradoraDataAccess.setConnexionType(this.connexionType);
			aseguradoraDataAccess.setParameterDbType(this.parameterDbType);

			aseguradora=aseguradoraDataAccess.getEntity(connexion,relvehiculo.getid_aseguradora());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return aseguradora;

	}


		
		public List<ServicioTransporte> getServicioTransportes(Connexion connexion,Vehiculo vehiculo)throws SQLException,Exception {

		List<ServicioTransporte> serviciotransportes= new ArrayList<ServicioTransporte>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+VehiculoConstantesFunciones.SCHEMA+".vehiculo ON "+ServicioTransporteConstantesFunciones.SCHEMA+".servicio_transporte.id_vehiculo="+VehiculoConstantesFunciones.SCHEMA+".vehiculo.id WHERE "+VehiculoConstantesFunciones.SCHEMA+".vehiculo.id="+String.valueOf(vehiculo.getId());
			} else {
				sQuery=" INNER JOIN serviciotransporte.Vehiculo WHERE serviciotransporte.Vehiculo.id="+String.valueOf(vehiculo.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ServicioTransporteDataAccess serviciotransporteDataAccess=new ServicioTransporteDataAccess();

			serviciotransporteDataAccess.setConnexionType(this.connexionType);
			serviciotransporteDataAccess.setParameterDbType(this.parameterDbType);
			serviciotransportes=serviciotransporteDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return serviciotransportes;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,Vehiculo vehiculo) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!vehiculo.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(vehiculo.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(vehiculo.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_detalle_activo_fijo=new ParameterValue<Long>();
					parameterMaintenanceValueid_detalle_activo_fijo.setValue(vehiculo.getid_detalle_activo_fijo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_detalle_activo_fijo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_aseguradora=new ParameterValue<Long>();
					parameterMaintenanceValueid_aseguradora.setValue(vehiculo.getid_aseguradora());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_aseguradora);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_poliza=new ParameterValue<String>();
					parameterMaintenanceValuenumero_poliza.setValue(vehiculo.getnumero_poliza());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_poliza);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_emision=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_emision.setValue(vehiculo.getfecha_emision());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_emision);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_vencimiento=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_vencimiento.setValue(vehiculo.getfecha_vencimiento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_vencimiento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_asegurado=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_asegurado.setValue(vehiculo.getvalor_asegurado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_asegurado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_deducible=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_deducible.setValue(vehiculo.getvalor_deducible());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_deducible);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_matricula=new ParameterValue<String>();
					parameterMaintenanceValuenumero_matricula.setValue(vehiculo.getnumero_matricula());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_matricula);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_motor=new ParameterValue<String>();
					parameterMaintenanceValuenumero_motor.setValue(vehiculo.getnumero_motor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_motor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_chasis=new ParameterValue<String>();
					parameterMaintenanceValuenumero_chasis.setValue(vehiculo.getnumero_chasis());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_chasis);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_placa=new ParameterValue<String>();
					parameterMaintenanceValuenumero_placa.setValue(vehiculo.getnumero_placa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_placa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_comercial=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_comercial.setValue(vehiculo.getvalor_comercial());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_comercial);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(vehiculo.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!vehiculo.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(vehiculo.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(vehiculo.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(vehiculo.getId());
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
	
	public void setIsNewIsChangedFalseVehiculo(Vehiculo vehiculo)throws Exception  {		
		vehiculo.setIsNew(false);
		vehiculo.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseVehiculos(List<Vehiculo> vehiculos)throws Exception  {				
		for(Vehiculo vehiculo:vehiculos) {
			vehiculo.setIsNew(false);
			vehiculo.setIsChanged(false);
		}
	}
	
	public void generarExportarVehiculo(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
