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
import com.bydan.framework.erp.business.dataaccess.DataAccessHelper;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.nomina.util.*;//CargoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;




@SuppressWarnings("unused")
final public class CargoDataAccess extends  CargoDataAccessAdditional{ //CargoDataAccessAdditional,DataAccessHelper<Cargo>
	//static Logger logger = Logger.getLogger(CargoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="cargo";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+CargoConstantesFunciones.SCHEMA+"."+CargoConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_cargo,id_cuenta_contable,id_numero_patronal,id_tipo_pago__n_m,id_cargo_grupo,codigo,nombre,valor_anticipo,porcentaje_anticipo,es_jefe,es_anual,porcentaje,valor)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+CargoConstantesFunciones.SCHEMA+"."+CargoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_cargo=?,id_cuenta_contable=?,id_numero_patronal=?,id_tipo_pago__n_m=?,id_cargo_grupo=?,codigo=?,nombre=?,valor_anticipo=?,porcentaje_anticipo=?,es_jefe=?,es_anual=?,porcentaje=?,valor=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+CargoConstantesFunciones.SCHEMA+"."+CargoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select cargo from "+CargoConstantesFunciones.SPERSISTENCENAME+" cargo";
	public static String QUERYSELECTNATIVE="select "+CargoConstantesFunciones.SCHEMA+"."+CargoConstantesFunciones.TABLENAME+".id,"+CargoConstantesFunciones.SCHEMA+"."+CargoConstantesFunciones.TABLENAME+".version_row,"+CargoConstantesFunciones.SCHEMA+"."+CargoConstantesFunciones.TABLENAME+".id_empresa,"+CargoConstantesFunciones.SCHEMA+"."+CargoConstantesFunciones.TABLENAME+".id_cargo,"+CargoConstantesFunciones.SCHEMA+"."+CargoConstantesFunciones.TABLENAME+".id_cuenta_contable,"+CargoConstantesFunciones.SCHEMA+"."+CargoConstantesFunciones.TABLENAME+".id_numero_patronal,"+CargoConstantesFunciones.SCHEMA+"."+CargoConstantesFunciones.TABLENAME+".id_tipo_pago__n_m,"+CargoConstantesFunciones.SCHEMA+"."+CargoConstantesFunciones.TABLENAME+".id_cargo_grupo,"+CargoConstantesFunciones.SCHEMA+"."+CargoConstantesFunciones.TABLENAME+".codigo,"+CargoConstantesFunciones.SCHEMA+"."+CargoConstantesFunciones.TABLENAME+".nombre,"+CargoConstantesFunciones.SCHEMA+"."+CargoConstantesFunciones.TABLENAME+".valor_anticipo,"+CargoConstantesFunciones.SCHEMA+"."+CargoConstantesFunciones.TABLENAME+".porcentaje_anticipo,"+CargoConstantesFunciones.SCHEMA+"."+CargoConstantesFunciones.TABLENAME+".es_jefe,"+CargoConstantesFunciones.SCHEMA+"."+CargoConstantesFunciones.TABLENAME+".es_anual,"+CargoConstantesFunciones.SCHEMA+"."+CargoConstantesFunciones.TABLENAME+".porcentaje,"+CargoConstantesFunciones.SCHEMA+"."+CargoConstantesFunciones.TABLENAME+".valor from "+CargoConstantesFunciones.SCHEMA+"."+CargoConstantesFunciones.TABLENAME;//+" as "+CargoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+CargoConstantesFunciones.SCHEMA+"."+CargoConstantesFunciones.TABLENAME+".id,"+CargoConstantesFunciones.SCHEMA+"."+CargoConstantesFunciones.TABLENAME+".version_row,"+CargoConstantesFunciones.SCHEMA+"."+CargoConstantesFunciones.TABLENAME+".codigo from "+CargoConstantesFunciones.SCHEMA+"."+CargoConstantesFunciones.TABLENAME;//+" as "+CargoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+CargoConstantesFunciones.SCHEMA+"."+CargoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_cargo=?,id_cuenta_contable=?,id_numero_patronal=?,id_tipo_pago__n_m=?,id_cargo_grupo=?,codigo=?,nombre=?,valor_anticipo=?,porcentaje_anticipo=?,es_jefe=?,es_anual=?,porcentaje=?,valor=?";
	
	public static String STOREPROCEDUREINSERT="call SP_CARGO_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_CARGO_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_CARGO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_CARGO_SELECT(?,?)";
	
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
	
	
	protected CargoDataAccessAdditional cargoDataAccessAdditional=null;
	
	public CargoDataAccessAdditional getCargoDataAccessAdditional() {
		return this.cargoDataAccessAdditional;
	}
	
	public void setCargoDataAccessAdditional(CargoDataAccessAdditional cargoDataAccessAdditional) {
		try {
			this.cargoDataAccessAdditional=cargoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public CargoDataAccess() {
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
		CargoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		CargoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		CargoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setCargoOriginal(Cargo cargo)throws Exception  {
		cargo.setCargoOriginal((Cargo)cargo.clone());		
	}
	
	public void setCargosOriginal(List<Cargo> cargos)throws Exception  {
		
		for(Cargo cargo:cargos){
			cargo.setCargoOriginal((Cargo)cargo.clone());
		}
	}
	
	public static void setCargoOriginalStatic(Cargo cargo)throws Exception  {
		cargo.setCargoOriginal((Cargo)cargo.clone());		
	}
	
	public static void setCargosOriginalStatic(List<Cargo> cargos)throws Exception  {
		
		for(Cargo cargo:cargos){
			cargo.setCargoOriginal((Cargo)cargo.clone());
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
	
	public  Cargo getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		Cargo entity = new Cargo();		
		
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
	
	public  Cargo getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		Cargo entity = new Cargo();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=CargoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CargoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.Cargo.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setCargoOriginal(new Cargo());
      	    	entity=super.getEntity("",entity,resultSet,CargoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityCargo("",entity,resultSet); 
				
				//entity.setCargoOriginal(super.getEntity("",entity.getCargoOriginal(),resultSet,CargoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCargoOriginal(this.getEntityCargo("",entity.getCargoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseCargo(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  Cargo getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Cargo entity = new Cargo();
				
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
	
	public  Cargo getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Cargo entity = new Cargo();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=CargoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CargoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CargoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.Cargo.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setCargoOriginal(new Cargo());
      	    	entity=super.getEntity("",entity,resultSet,CargoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityCargo("",entity,resultSet);    
				
				//entity.setCargoOriginal(super.getEntity("",entity.getCargoOriginal(),resultSet,CargoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCargoOriginal(this.getEntityCargo("",entity.getCargoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseCargo(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //Cargo
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		Cargo entity = new Cargo();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CargoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CargoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CargoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.Cargo.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseCargo(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<Cargo> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Cargo> entities = new  ArrayList<Cargo>();
		Cargo entity = new Cargo();		  
		
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
	
	public  List<Cargo> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Cargo> entities = new  ArrayList<Cargo>();
		Cargo entity = new Cargo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=CargoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CargoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CargoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Cargo();
      	    	entity=super.getEntity("",entity,resultSet,CargoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCargo("",entity,resultSet);
      	    	
				//entity.setCargoOriginal( new Cargo());
      	    	//entity.setCargoOriginal(super.getEntity("",entity.getCargoOriginal(),resultSet,CargoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCargoOriginal(this.getEntityCargo("",entity.getCargoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCargos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCargo(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Cargo> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Cargo> entities = new  ArrayList<Cargo>();
		Cargo entity = new Cargo();		  
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
	
	public  List<Cargo> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Cargo> entities = new  ArrayList<Cargo>();
		Cargo entity = new Cargo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Cargo();
				
				if(conMapGenerico) {
					entity.inicializarMapCargo();
					//entity.setMapCargo(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapCargoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapCargo().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CargoDataAccess.ISWITHSCHEMA);         		
					entity=CargoDataAccess.getEntityCargo("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setCargoOriginal( new Cargo());
					////entity.setCargoOriginal(super.getEntity("",entity.getCargoOriginal(),resultSet,CargoDataAccess.ISWITHSCHEMA));         		
					////entity.setCargoOriginal(this.getEntityCargo("",entity.getCargoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCargos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCargo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public Cargo getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Cargo entity = new Cargo();		  
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
	
	public  Cargo getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Cargo entity = new Cargo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Cargo();
				
				if(conMapGenerico) {
					entity.inicializarMapCargo();
					//entity.setMapCargo(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapCargoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapCargo().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CargoDataAccess.ISWITHSCHEMA);         		
					entity=CargoDataAccess.getEntityCargo("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setCargoOriginal( new Cargo());
					////entity.setCargoOriginal(super.getEntity("",entity.getCargoOriginal(),resultSet,CargoDataAccess.ISWITHSCHEMA));         		
					////entity.setCargoOriginal(this.getEntityCargo("",entity.getCargoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseCargo(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCargo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static Cargo getEntityCargo(String strPrefijo,Cargo entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = Cargo.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = Cargo.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					CargoDataAccess.setFieldReflectionCargo(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasCargo=CargoConstantesFunciones.getTodosTiposColumnasCargo();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasCargo) {
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
							field = Cargo.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = Cargo.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						CargoDataAccess.setFieldReflectionCargo(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionCargo(Field field,String strPrefijo,String sColumn,Cargo entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case CargoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CargoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CargoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CargoConstantesFunciones.IDCARGO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CargoConstantesFunciones.IDCUENTACONTABLE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CargoConstantesFunciones.IDNUMEROPATRONAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CargoConstantesFunciones.IDTIPOPAGO_NM:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CargoConstantesFunciones.IDCARGOGRUPO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CargoConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CargoConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CargoConstantesFunciones.VALORANTICIPO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CargoConstantesFunciones.PORCENTAJEANTICIPO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CargoConstantesFunciones.ESJEFE:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case CargoConstantesFunciones.ESANUAL:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case CargoConstantesFunciones.PORCENTAJE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CargoConstantesFunciones.VALOR:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Cargo>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<Cargo> entities = new  ArrayList<Cargo>();
		Cargo entity = new Cargo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CargoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CargoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CargoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new Cargo();
					entity=super.getEntity("",entity,resultSet,CargoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityCargo("",entity,resultSet);
					
					//entity.setCargoOriginal( new Cargo());
					//entity.setCargoOriginal(super.getEntity("",entity.getCargoOriginal(),resultSet,CargoDataAccess.ISWITHSCHEMA));         		
					//entity.setCargoOriginal(this.getEntityCargo("",entity.getCargoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseCargos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCargo(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Cargo>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<Cargo> entities = new  ArrayList<Cargo>();
		Cargo entity = new Cargo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CargoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CargoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CargoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<Cargo> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Cargo> entities = new  ArrayList<Cargo>();
		Cargo entity = new Cargo();		  
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
	
	public  List<Cargo> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Cargo> entities = new  ArrayList<Cargo>();
		Cargo entity = new Cargo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Cargo();
      	    	entity=super.getEntity("",entity,resultSet,CargoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCargo("",entity,resultSet);
      	    	
				//entity.setCargoOriginal( new Cargo());
      	    	//entity.setCargoOriginal(super.getEntity("",entity.getCargoOriginal(),resultSet,CargoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCargoOriginal(this.getEntityCargo("",entity.getCargoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseCargos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCargo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Cargo> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Cargo> entities = new  ArrayList<Cargo>();
		Cargo entity = new Cargo();		  
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
	
	public  List<Cargo> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Cargo> entities = new  ArrayList<Cargo>();
		Cargo entity = new Cargo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Cargo();
      	    	entity=super.getEntity("",entity,resultSet,CargoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCargo("",entity,resultSet);
      	    	
				//entity.setCargoOriginal( new Cargo());
      	    	//entity.setCargoOriginal(super.getEntity("",entity.getCargoOriginal(),resultSet,CargoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCargoOriginal(this.getEntityCargo("",entity.getCargoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCargos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public Cargo getEntityCargo(String strPrefijo,Cargo entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+CargoConstantesFunciones.IDEMPRESA));
				entity.setid_cargo(resultSet.getLong(strPrefijo+CargoConstantesFunciones.IDCARGO));
				entity.setid_cuenta_contable(resultSet.getLong(strPrefijo+CargoConstantesFunciones.IDCUENTACONTABLE));
				entity.setid_numero_patronal(resultSet.getLong(strPrefijo+CargoConstantesFunciones.IDNUMEROPATRONAL));
				entity.setid_tipo_pago__n_m(resultSet.getLong(strPrefijo+CargoConstantesFunciones.IDTIPOPAGO_NM));
				entity.setid_cargo_grupo(resultSet.getLong(strPrefijo+CargoConstantesFunciones.IDCARGOGRUPO));
				entity.setcodigo(resultSet.getString(strPrefijo+CargoConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+CargoConstantesFunciones.NOMBRE));
				entity.setvalor_anticipo(resultSet.getDouble(strPrefijo+CargoConstantesFunciones.VALORANTICIPO));
				entity.setporcentaje_anticipo(resultSet.getDouble(strPrefijo+CargoConstantesFunciones.PORCENTAJEANTICIPO));
				entity.setes_jefe(resultSet.getBoolean(strPrefijo+CargoConstantesFunciones.ESJEFE));
				entity.setes_anual(resultSet.getBoolean(strPrefijo+CargoConstantesFunciones.ESANUAL));
				entity.setporcentaje(resultSet.getDouble(strPrefijo+CargoConstantesFunciones.PORCENTAJE));
				entity.setvalor(resultSet.getDouble(strPrefijo+CargoConstantesFunciones.VALOR));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+CargoConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowCargo(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(Cargo entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=CargoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=CargoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=CargoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=CargoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(CargoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,CargoDataAccess.TABLENAME,CargoDataAccess.ISWITHSTOREPROCEDURES);
			
			CargoDataAccess.setCargoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,Cargo relcargo)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relcargo.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Cargo getCargo(Connexion connexion,Cargo relcargo)throws SQLException,Exception {

		Cargo cargo= new Cargo();

		try {
			CargoDataAccess cargoDataAccess=new CargoDataAccess();

			cargoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cargoDataAccess.setConnexionType(this.connexionType);
			cargoDataAccess.setParameterDbType(this.parameterDbType);

			cargo=cargoDataAccess.getEntity(connexion,relcargo.getid_cargo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cargo;

	}

	public CuentaContable getCuentaContable(Connexion connexion,Cargo relcargo)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relcargo.getid_cuenta_contable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public NumeroPatronal getNumeroPatronal(Connexion connexion,Cargo relcargo)throws SQLException,Exception {

		NumeroPatronal numeropatronal= new NumeroPatronal();

		try {
			NumeroPatronalDataAccess numeropatronalDataAccess=new NumeroPatronalDataAccess();

			numeropatronalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			numeropatronalDataAccess.setConnexionType(this.connexionType);
			numeropatronalDataAccess.setParameterDbType(this.parameterDbType);

			numeropatronal=numeropatronalDataAccess.getEntity(connexion,relcargo.getid_numero_patronal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return numeropatronal;

	}

	public TipoPago_NM getTipoPago_NM(Connexion connexion,Cargo relcargo)throws SQLException,Exception {

		TipoPago_NM tipopago_nm= new TipoPago_NM();

		try {
			TipoPago_NMDataAccess tipopago_nmDataAccess=new TipoPago_NMDataAccess();

			tipopago_nmDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipopago_nmDataAccess.setConnexionType(this.connexionType);
			tipopago_nmDataAccess.setParameterDbType(this.parameterDbType);

			tipopago_nm=tipopago_nmDataAccess.getEntity(connexion,relcargo.getid_tipo_pago__n_m());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipopago_nm;

	}

	public CargoGrupo getCargoGrupo(Connexion connexion,Cargo relcargo)throws SQLException,Exception {

		CargoGrupo cargogrupo= new CargoGrupo();

		try {
			CargoGrupoDataAccess cargogrupoDataAccess=new CargoGrupoDataAccess();

			cargogrupoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cargogrupoDataAccess.setConnexionType(this.connexionType);
			cargogrupoDataAccess.setParameterDbType(this.parameterDbType);

			cargogrupo=cargogrupoDataAccess.getEntity(connexion,relcargo.getid_cargo_grupo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cargogrupo;

	}


		
		public List<AsistenciaMensual> getAsistenciaMensuals(Connexion connexion,Cargo cargo)throws SQLException,Exception {

		List<AsistenciaMensual> asistenciamensuals= new ArrayList<AsistenciaMensual>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CargoConstantesFunciones.SCHEMA+".cargo ON "+AsistenciaMensualConstantesFunciones.SCHEMA+".asistencia_mensual.id_cargo="+CargoConstantesFunciones.SCHEMA+".cargo.id WHERE "+CargoConstantesFunciones.SCHEMA+".cargo.id="+String.valueOf(cargo.getId());
			} else {
				sQuery=" INNER JOIN asistenciamensual.Cargo WHERE asistenciamensual.Cargo.id="+String.valueOf(cargo.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			AsistenciaMensualDataAccess asistenciamensualDataAccess=new AsistenciaMensualDataAccess();

			asistenciamensualDataAccess.setConnexionType(this.connexionType);
			asistenciamensualDataAccess.setParameterDbType(this.parameterDbType);
			asistenciamensuals=asistenciamensualDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return asistenciamensuals;

	}

	public List<EmpleadoEstructura> getEmpleadoEstructuras(Connexion connexion,Cargo cargo)throws SQLException,Exception {

		List<EmpleadoEstructura> empleadoestructuras= new ArrayList<EmpleadoEstructura>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CargoConstantesFunciones.SCHEMA+".cargo ON "+EmpleadoEstructuraConstantesFunciones.SCHEMA+".empleado_estructura.id_cargo="+CargoConstantesFunciones.SCHEMA+".cargo.id WHERE "+CargoConstantesFunciones.SCHEMA+".cargo.id="+String.valueOf(cargo.getId());
			} else {
				sQuery=" INNER JOIN empleadoestructura.Cargo WHERE empleadoestructura.Cargo.id="+String.valueOf(cargo.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			EmpleadoEstructuraDataAccess empleadoestructuraDataAccess=new EmpleadoEstructuraDataAccess();

			empleadoestructuraDataAccess.setConnexionType(this.connexionType);
			empleadoestructuraDataAccess.setParameterDbType(this.parameterDbType);
			empleadoestructuras=empleadoestructuraDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleadoestructuras;

	}

	public List<Empleado> getEmpleados(Connexion connexion,Cargo cargo)throws SQLException,Exception {

		List<Empleado> empleados= new ArrayList<Empleado>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CargoConstantesFunciones.SCHEMA+".cargo ON "+EmpleadoConstantesFunciones.SCHEMA+".empleado.id_cargo="+CargoConstantesFunciones.SCHEMA+".cargo.id WHERE "+CargoConstantesFunciones.SCHEMA+".cargo.id="+String.valueOf(cargo.getId());
			} else {
				sQuery=" INNER JOIN empleado.Cargo WHERE empleado.Cargo.id="+String.valueOf(cargo.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);
			empleados=empleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleados;

	}

	public List<Cargo> getCargos(Connexion connexion,Cargo cargo)throws SQLException,Exception {

		List<Cargo> cargos= new ArrayList<Cargo>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CargoConstantesFunciones.SCHEMA+".cargo ON "+CargoConstantesFunciones.SCHEMA+".cargo.id_cargo="+CargoConstantesFunciones.SCHEMA+".cargo.id WHERE "+CargoConstantesFunciones.SCHEMA+".cargo.id="+String.valueOf(cargo.getId());
			} else {
				sQuery=" INNER JOIN cargo.Cargo WHERE cargo.Cargo.id="+String.valueOf(cargo.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			CargoDataAccess cargoDataAccess=new CargoDataAccess();

			cargoDataAccess.setConnexionType(this.connexionType);
			cargoDataAccess.setParameterDbType(this.parameterDbType);
			cargos=cargoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cargos;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,Cargo cargo) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!cargo.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(cargo.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cargo=new ParameterValue<Long>();
					parameterMaintenanceValueid_cargo.setValue(cargo.getid_cargo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cargo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable.setValue(cargo.getid_cuenta_contable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_numero_patronal=new ParameterValue<Long>();
					parameterMaintenanceValueid_numero_patronal.setValue(cargo.getid_numero_patronal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_numero_patronal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_pago__n_m=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_pago__n_m.setValue(cargo.getid_tipo_pago__n_m());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_pago__n_m);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cargo_grupo=new ParameterValue<Long>();
					parameterMaintenanceValueid_cargo_grupo.setValue(cargo.getid_cargo_grupo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cargo_grupo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(cargo.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(cargo.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_anticipo=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_anticipo.setValue(cargo.getvalor_anticipo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_anticipo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcentaje_anticipo=new ParameterValue<Double>();
					parameterMaintenanceValueporcentaje_anticipo.setValue(cargo.getporcentaje_anticipo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcentaje_anticipo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_jefe=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_jefe.setValue(cargo.getes_jefe());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_jefe);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_anual=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_anual.setValue(cargo.getes_anual());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_anual);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcentaje=new ParameterValue<Double>();
					parameterMaintenanceValueporcentaje.setValue(cargo.getporcentaje());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcentaje);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor=new ParameterValue<Double>();
					parameterMaintenanceValuevalor.setValue(cargo.getvalor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor);
					parametersTemp.add(parameterMaintenance);
					
						if(!cargo.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(cargo.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(cargo.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(cargo.getId());
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
	
	public void setIsNewIsChangedFalseCargo(Cargo cargo)throws Exception  {		
		cargo.setIsNew(false);
		cargo.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseCargos(List<Cargo> cargos)throws Exception  {				
		for(Cargo cargo:cargos) {
			cargo.setIsNew(false);
			cargo.setIsChanged(false);
		}
	}
	
	public void generarExportarCargo(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
