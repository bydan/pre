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
import com.bydan.erp.nomina.util.*;//CuotaConstantesFunciones;










@SuppressWarnings("unused")
final public class CuotaDataAccess extends  CuotaDataAccessAdditional{ //CuotaDataAccessAdditional,DataAccessHelper<Cuota>
	//static Logger logger = Logger.getLogger(CuotaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="cuota";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+CuotaConstantesFunciones.SCHEMA+"."+CuotaConstantesFunciones.TABLENAME+"(version_row,id_prestamo,id_estado_cuota,id_defi_provision_empleado,numero_cuota,capital,interes,total,fecha_liquidacion,monto_ajuste,interes_ajuste,fecha_vencimiento,descripcion)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+CuotaConstantesFunciones.SCHEMA+"."+CuotaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_prestamo=?,id_estado_cuota=?,id_defi_provision_empleado=?,numero_cuota=?,capital=?,interes=?,total=?,fecha_liquidacion=?,monto_ajuste=?,interes_ajuste=?,fecha_vencimiento=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+CuotaConstantesFunciones.SCHEMA+"."+CuotaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select cuota from "+CuotaConstantesFunciones.SPERSISTENCENAME+" cuota";
	public static String QUERYSELECTNATIVE="select "+CuotaConstantesFunciones.SCHEMA+"."+CuotaConstantesFunciones.TABLENAME+".id,"+CuotaConstantesFunciones.SCHEMA+"."+CuotaConstantesFunciones.TABLENAME+".version_row,"+CuotaConstantesFunciones.SCHEMA+"."+CuotaConstantesFunciones.TABLENAME+".id_prestamo,"+CuotaConstantesFunciones.SCHEMA+"."+CuotaConstantesFunciones.TABLENAME+".id_estado_cuota,"+CuotaConstantesFunciones.SCHEMA+"."+CuotaConstantesFunciones.TABLENAME+".id_defi_provision_empleado,"+CuotaConstantesFunciones.SCHEMA+"."+CuotaConstantesFunciones.TABLENAME+".numero_cuota,"+CuotaConstantesFunciones.SCHEMA+"."+CuotaConstantesFunciones.TABLENAME+".capital,"+CuotaConstantesFunciones.SCHEMA+"."+CuotaConstantesFunciones.TABLENAME+".interes,"+CuotaConstantesFunciones.SCHEMA+"."+CuotaConstantesFunciones.TABLENAME+".total,"+CuotaConstantesFunciones.SCHEMA+"."+CuotaConstantesFunciones.TABLENAME+".fecha_liquidacion,"+CuotaConstantesFunciones.SCHEMA+"."+CuotaConstantesFunciones.TABLENAME+".monto_ajuste,"+CuotaConstantesFunciones.SCHEMA+"."+CuotaConstantesFunciones.TABLENAME+".interes_ajuste,"+CuotaConstantesFunciones.SCHEMA+"."+CuotaConstantesFunciones.TABLENAME+".fecha_vencimiento,"+CuotaConstantesFunciones.SCHEMA+"."+CuotaConstantesFunciones.TABLENAME+".descripcion from "+CuotaConstantesFunciones.SCHEMA+"."+CuotaConstantesFunciones.TABLENAME;//+" as "+CuotaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+CuotaConstantesFunciones.SCHEMA+"."+CuotaConstantesFunciones.TABLENAME+".id,"+CuotaConstantesFunciones.SCHEMA+"."+CuotaConstantesFunciones.TABLENAME+".version_row from "+CuotaConstantesFunciones.SCHEMA+"."+CuotaConstantesFunciones.TABLENAME;//+" as "+CuotaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+CuotaConstantesFunciones.SCHEMA+"."+CuotaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_prestamo=?,id_estado_cuota=?,id_defi_provision_empleado=?,numero_cuota=?,capital=?,interes=?,total=?,fecha_liquidacion=?,monto_ajuste=?,interes_ajuste=?,fecha_vencimiento=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_CUOTA_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_CUOTA_UPDATE(?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_CUOTA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_CUOTA_SELECT(?,?)";
	
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
	
	
	protected CuotaDataAccessAdditional cuotaDataAccessAdditional=null;
	
	public CuotaDataAccessAdditional getCuotaDataAccessAdditional() {
		return this.cuotaDataAccessAdditional;
	}
	
	public void setCuotaDataAccessAdditional(CuotaDataAccessAdditional cuotaDataAccessAdditional) {
		try {
			this.cuotaDataAccessAdditional=cuotaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public CuotaDataAccess() {
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
		CuotaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		CuotaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		CuotaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setCuotaOriginal(Cuota cuota)throws Exception  {
		cuota.setCuotaOriginal((Cuota)cuota.clone());		
	}
	
	public void setCuotasOriginal(List<Cuota> cuotas)throws Exception  {
		
		for(Cuota cuota:cuotas){
			cuota.setCuotaOriginal((Cuota)cuota.clone());
		}
	}
	
	public static void setCuotaOriginalStatic(Cuota cuota)throws Exception  {
		cuota.setCuotaOriginal((Cuota)cuota.clone());		
	}
	
	public static void setCuotasOriginalStatic(List<Cuota> cuotas)throws Exception  {
		
		for(Cuota cuota:cuotas){
			cuota.setCuotaOriginal((Cuota)cuota.clone());
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
	
	public  Cuota getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		Cuota entity = new Cuota();		
		
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
	
	public  Cuota getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		Cuota entity = new Cuota();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=CuotaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CuotaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.Cuota.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setCuotaOriginal(new Cuota());
      	    	entity=super.getEntity("",entity,resultSet,CuotaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityCuota("",entity,resultSet); 
				
				//entity.setCuotaOriginal(super.getEntity("",entity.getCuotaOriginal(),resultSet,CuotaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCuotaOriginal(this.getEntityCuota("",entity.getCuotaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseCuota(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  Cuota getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Cuota entity = new Cuota();
				
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
	
	public  Cuota getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Cuota entity = new Cuota();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=CuotaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CuotaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CuotaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.Cuota.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setCuotaOriginal(new Cuota());
      	    	entity=super.getEntity("",entity,resultSet,CuotaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityCuota("",entity,resultSet);    
				
				//entity.setCuotaOriginal(super.getEntity("",entity.getCuotaOriginal(),resultSet,CuotaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCuotaOriginal(this.getEntityCuota("",entity.getCuotaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseCuota(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //Cuota
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		Cuota entity = new Cuota();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CuotaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CuotaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CuotaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.Cuota.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseCuota(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<Cuota> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Cuota> entities = new  ArrayList<Cuota>();
		Cuota entity = new Cuota();		  
		
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
	
	public  List<Cuota> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Cuota> entities = new  ArrayList<Cuota>();
		Cuota entity = new Cuota();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=CuotaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CuotaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CuotaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Cuota();
      	    	entity=super.getEntity("",entity,resultSet,CuotaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCuota("",entity,resultSet);
      	    	
				//entity.setCuotaOriginal( new Cuota());
      	    	//entity.setCuotaOriginal(super.getEntity("",entity.getCuotaOriginal(),resultSet,CuotaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCuotaOriginal(this.getEntityCuota("",entity.getCuotaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCuotas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCuota(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Cuota> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Cuota> entities = new  ArrayList<Cuota>();
		Cuota entity = new Cuota();		  
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
	
	public  List<Cuota> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Cuota> entities = new  ArrayList<Cuota>();
		Cuota entity = new Cuota();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Cuota();
				
				if(conMapGenerico) {
					entity.inicializarMapCuota();
					//entity.setMapCuota(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapCuotaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapCuota().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CuotaDataAccess.ISWITHSCHEMA);         		
					entity=CuotaDataAccess.getEntityCuota("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setCuotaOriginal( new Cuota());
					////entity.setCuotaOriginal(super.getEntity("",entity.getCuotaOriginal(),resultSet,CuotaDataAccess.ISWITHSCHEMA));         		
					////entity.setCuotaOriginal(this.getEntityCuota("",entity.getCuotaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCuotas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCuota(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public Cuota getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Cuota entity = new Cuota();		  
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
	
	public  Cuota getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Cuota entity = new Cuota();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Cuota();
				
				if(conMapGenerico) {
					entity.inicializarMapCuota();
					//entity.setMapCuota(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapCuotaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapCuota().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CuotaDataAccess.ISWITHSCHEMA);         		
					entity=CuotaDataAccess.getEntityCuota("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setCuotaOriginal( new Cuota());
					////entity.setCuotaOriginal(super.getEntity("",entity.getCuotaOriginal(),resultSet,CuotaDataAccess.ISWITHSCHEMA));         		
					////entity.setCuotaOriginal(this.getEntityCuota("",entity.getCuotaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseCuota(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCuota(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static Cuota getEntityCuota(String strPrefijo,Cuota entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = Cuota.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = Cuota.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					CuotaDataAccess.setFieldReflectionCuota(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasCuota=CuotaConstantesFunciones.getTodosTiposColumnasCuota();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasCuota) {
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
							field = Cuota.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = Cuota.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						CuotaDataAccess.setFieldReflectionCuota(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionCuota(Field field,String strPrefijo,String sColumn,Cuota entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case CuotaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CuotaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CuotaConstantesFunciones.IDPRESTAMO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CuotaConstantesFunciones.IDESTADOCUOTA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CuotaConstantesFunciones.IDDEFIPROVISIONEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CuotaConstantesFunciones.NUMEROCUOTA:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case CuotaConstantesFunciones.CAPITAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CuotaConstantesFunciones.INTERES:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CuotaConstantesFunciones.TOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CuotaConstantesFunciones.FECHALIQUIDACION:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CuotaConstantesFunciones.MONTOAJUSTE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CuotaConstantesFunciones.INTERESAJUSTE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CuotaConstantesFunciones.FECHAVENCIMIENTO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case CuotaConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Cuota>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<Cuota> entities = new  ArrayList<Cuota>();
		Cuota entity = new Cuota();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CuotaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CuotaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CuotaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new Cuota();
					entity=super.getEntity("",entity,resultSet,CuotaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityCuota("",entity,resultSet);
					
					//entity.setCuotaOriginal( new Cuota());
					//entity.setCuotaOriginal(super.getEntity("",entity.getCuotaOriginal(),resultSet,CuotaDataAccess.ISWITHSCHEMA));         		
					//entity.setCuotaOriginal(this.getEntityCuota("",entity.getCuotaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseCuotas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCuota(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Cuota>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<Cuota> entities = new  ArrayList<Cuota>();
		Cuota entity = new Cuota();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CuotaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CuotaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CuotaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<Cuota> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Cuota> entities = new  ArrayList<Cuota>();
		Cuota entity = new Cuota();		  
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
	
	public  List<Cuota> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Cuota> entities = new  ArrayList<Cuota>();
		Cuota entity = new Cuota();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Cuota();
      	    	entity=super.getEntity("",entity,resultSet,CuotaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCuota("",entity,resultSet);
      	    	
				//entity.setCuotaOriginal( new Cuota());
      	    	//entity.setCuotaOriginal(super.getEntity("",entity.getCuotaOriginal(),resultSet,CuotaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCuotaOriginal(this.getEntityCuota("",entity.getCuotaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseCuotas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCuota(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Cuota> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Cuota> entities = new  ArrayList<Cuota>();
		Cuota entity = new Cuota();		  
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
	
	public  List<Cuota> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Cuota> entities = new  ArrayList<Cuota>();
		Cuota entity = new Cuota();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Cuota();
      	    	entity=super.getEntity("",entity,resultSet,CuotaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCuota("",entity,resultSet);
      	    	
				//entity.setCuotaOriginal( new Cuota());
      	    	//entity.setCuotaOriginal(super.getEntity("",entity.getCuotaOriginal(),resultSet,CuotaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCuotaOriginal(this.getEntityCuota("",entity.getCuotaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCuotas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public Cuota getEntityCuota(String strPrefijo,Cuota entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_prestamo(resultSet.getLong(strPrefijo+CuotaConstantesFunciones.IDPRESTAMO));
				entity.setid_estado_cuota(resultSet.getLong(strPrefijo+CuotaConstantesFunciones.IDESTADOCUOTA));
				entity.setid_defi_provision_empleado(resultSet.getLong(strPrefijo+CuotaConstantesFunciones.IDDEFIPROVISIONEMPLEADO));
				entity.setnumero_cuota(resultSet.getInt(strPrefijo+CuotaConstantesFunciones.NUMEROCUOTA));
				entity.setcapital(resultSet.getDouble(strPrefijo+CuotaConstantesFunciones.CAPITAL));
				entity.setinteres(resultSet.getDouble(strPrefijo+CuotaConstantesFunciones.INTERES));
				entity.settotal(resultSet.getDouble(strPrefijo+CuotaConstantesFunciones.TOTAL));
				entity.setfecha_liquidacion(resultSet.getDouble(strPrefijo+CuotaConstantesFunciones.FECHALIQUIDACION));
				entity.setmonto_ajuste(resultSet.getDouble(strPrefijo+CuotaConstantesFunciones.MONTOAJUSTE));
				entity.setinteres_ajuste(resultSet.getDouble(strPrefijo+CuotaConstantesFunciones.INTERESAJUSTE));
				entity.setfecha_vencimiento(new Date(resultSet.getDate(strPrefijo+CuotaConstantesFunciones.FECHAVENCIMIENTO).getTime()));
				entity.setdescripcion(resultSet.getString(strPrefijo+CuotaConstantesFunciones.DESCRIPCION));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowCuota(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(Cuota entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=CuotaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=CuotaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=CuotaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=CuotaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(CuotaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,CuotaDataAccess.TABLENAME,CuotaDataAccess.ISWITHSTOREPROCEDURES);
			
			CuotaDataAccess.setCuotaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Prestamo getPrestamo(Connexion connexion,Cuota relcuota)throws SQLException,Exception {

		Prestamo prestamo= new Prestamo();

		try {
			PrestamoDataAccess prestamoDataAccess=new PrestamoDataAccess();

			prestamoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			prestamoDataAccess.setConnexionType(this.connexionType);
			prestamoDataAccess.setParameterDbType(this.parameterDbType);

			prestamo=prestamoDataAccess.getEntity(connexion,relcuota.getid_prestamo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return prestamo;

	}

	public EstadoCuota getEstadoCuota(Connexion connexion,Cuota relcuota)throws SQLException,Exception {

		EstadoCuota estadocuota= new EstadoCuota();

		try {
			EstadoCuotaDataAccess estadocuotaDataAccess=new EstadoCuotaDataAccess();

			estadocuotaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadocuotaDataAccess.setConnexionType(this.connexionType);
			estadocuotaDataAccess.setParameterDbType(this.parameterDbType);

			estadocuota=estadocuotaDataAccess.getEntity(connexion,relcuota.getid_estado_cuota());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadocuota;

	}

	public DefiProvisionEmpleado getDefiProvisionEmpleado(Connexion connexion,Cuota relcuota)throws SQLException,Exception {

		DefiProvisionEmpleado defiprovisionempleado= new DefiProvisionEmpleado();

		try {
			DefiProvisionEmpleadoDataAccess defiprovisionempleadoDataAccess=new DefiProvisionEmpleadoDataAccess();

			defiprovisionempleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			defiprovisionempleadoDataAccess.setConnexionType(this.connexionType);
			defiprovisionempleadoDataAccess.setParameterDbType(this.parameterDbType);

			defiprovisionempleado=defiprovisionempleadoDataAccess.getEntity(connexion,relcuota.getid_defi_provision_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return defiprovisionempleado;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,Cuota cuota) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!cuota.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_prestamo=new ParameterValue<Long>();
					parameterMaintenanceValueid_prestamo.setValue(cuota.getid_prestamo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_prestamo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_cuota=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_cuota.setValue(cuota.getid_estado_cuota());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_cuota);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_defi_provision_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_defi_provision_empleado.setValue(cuota.getid_defi_provision_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_defi_provision_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuenumero_cuota=new ParameterValue<Integer>();
					parameterMaintenanceValuenumero_cuota.setValue(cuota.getnumero_cuota());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_cuota);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecapital=new ParameterValue<Double>();
					parameterMaintenanceValuecapital.setValue(cuota.getcapital());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecapital);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueinteres=new ParameterValue<Double>();
					parameterMaintenanceValueinteres.setValue(cuota.getinteres());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueinteres);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal=new ParameterValue<Double>();
					parameterMaintenanceValuetotal.setValue(cuota.gettotal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuefecha_liquidacion=new ParameterValue<Double>();
					parameterMaintenanceValuefecha_liquidacion.setValue(cuota.getfecha_liquidacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_liquidacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuemonto_ajuste=new ParameterValue<Double>();
					parameterMaintenanceValuemonto_ajuste.setValue(cuota.getmonto_ajuste());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuemonto_ajuste);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueinteres_ajuste=new ParameterValue<Double>();
					parameterMaintenanceValueinteres_ajuste.setValue(cuota.getinteres_ajuste());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueinteres_ajuste);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_vencimiento=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_vencimiento.setValue(cuota.getfecha_vencimiento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_vencimiento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(cuota.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!cuota.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(cuota.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(cuota.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(cuota.getId());
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
	
	public void setIsNewIsChangedFalseCuota(Cuota cuota)throws Exception  {		
		cuota.setIsNew(false);
		cuota.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseCuotas(List<Cuota> cuotas)throws Exception  {				
		for(Cuota cuota:cuotas) {
			cuota.setIsNew(false);
			cuota.setIsChanged(false);
		}
	}
	
	public void generarExportarCuota(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
