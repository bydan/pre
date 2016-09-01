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
import com.bydan.erp.nomina.util.*;//NumeroPatronalConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.activosfijos.util.*;




@SuppressWarnings("unused")
final public class NumeroPatronalDataAccess extends  NumeroPatronalDataAccessAdditional{ //NumeroPatronalDataAccessAdditional,DataAccessHelper<NumeroPatronal>
	//static Logger logger = Logger.getLogger(NumeroPatronalDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="numero_patronal";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+NumeroPatronalConstantesFunciones.SCHEMA+"."+NumeroPatronalConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_provincia,id_canton,id_parroquia,numero,codigo_actividad,apellido,nombre,cedula,telefono,descripcion)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+NumeroPatronalConstantesFunciones.SCHEMA+"."+NumeroPatronalConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_provincia=?,id_canton=?,id_parroquia=?,numero=?,codigo_actividad=?,apellido=?,nombre=?,cedula=?,telefono=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+NumeroPatronalConstantesFunciones.SCHEMA+"."+NumeroPatronalConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select numeropatronal from "+NumeroPatronalConstantesFunciones.SPERSISTENCENAME+" numeropatronal";
	public static String QUERYSELECTNATIVE="select "+NumeroPatronalConstantesFunciones.SCHEMA+"."+NumeroPatronalConstantesFunciones.TABLENAME+".id,"+NumeroPatronalConstantesFunciones.SCHEMA+"."+NumeroPatronalConstantesFunciones.TABLENAME+".version_row,"+NumeroPatronalConstantesFunciones.SCHEMA+"."+NumeroPatronalConstantesFunciones.TABLENAME+".id_empresa,"+NumeroPatronalConstantesFunciones.SCHEMA+"."+NumeroPatronalConstantesFunciones.TABLENAME+".id_provincia,"+NumeroPatronalConstantesFunciones.SCHEMA+"."+NumeroPatronalConstantesFunciones.TABLENAME+".id_canton,"+NumeroPatronalConstantesFunciones.SCHEMA+"."+NumeroPatronalConstantesFunciones.TABLENAME+".id_parroquia,"+NumeroPatronalConstantesFunciones.SCHEMA+"."+NumeroPatronalConstantesFunciones.TABLENAME+".numero,"+NumeroPatronalConstantesFunciones.SCHEMA+"."+NumeroPatronalConstantesFunciones.TABLENAME+".codigo_actividad,"+NumeroPatronalConstantesFunciones.SCHEMA+"."+NumeroPatronalConstantesFunciones.TABLENAME+".apellido,"+NumeroPatronalConstantesFunciones.SCHEMA+"."+NumeroPatronalConstantesFunciones.TABLENAME+".nombre,"+NumeroPatronalConstantesFunciones.SCHEMA+"."+NumeroPatronalConstantesFunciones.TABLENAME+".cedula,"+NumeroPatronalConstantesFunciones.SCHEMA+"."+NumeroPatronalConstantesFunciones.TABLENAME+".telefono,"+NumeroPatronalConstantesFunciones.SCHEMA+"."+NumeroPatronalConstantesFunciones.TABLENAME+".descripcion from "+NumeroPatronalConstantesFunciones.SCHEMA+"."+NumeroPatronalConstantesFunciones.TABLENAME;//+" as "+NumeroPatronalConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+NumeroPatronalConstantesFunciones.SCHEMA+"."+NumeroPatronalConstantesFunciones.TABLENAME+".id,"+NumeroPatronalConstantesFunciones.SCHEMA+"."+NumeroPatronalConstantesFunciones.TABLENAME+".version_row,"+NumeroPatronalConstantesFunciones.SCHEMA+"."+NumeroPatronalConstantesFunciones.TABLENAME+".nombre from "+NumeroPatronalConstantesFunciones.SCHEMA+"."+NumeroPatronalConstantesFunciones.TABLENAME;//+" as "+NumeroPatronalConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+NumeroPatronalConstantesFunciones.SCHEMA+"."+NumeroPatronalConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_provincia=?,id_canton=?,id_parroquia=?,numero=?,codigo_actividad=?,apellido=?,nombre=?,cedula=?,telefono=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_NUMEROPATRONAL_INSERT(?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_NUMEROPATRONAL_UPDATE(?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_NUMEROPATRONAL_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_NUMEROPATRONAL_SELECT(?,?)";
	
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
	
	
	protected NumeroPatronalDataAccessAdditional numeropatronalDataAccessAdditional=null;
	
	public NumeroPatronalDataAccessAdditional getNumeroPatronalDataAccessAdditional() {
		return this.numeropatronalDataAccessAdditional;
	}
	
	public void setNumeroPatronalDataAccessAdditional(NumeroPatronalDataAccessAdditional numeropatronalDataAccessAdditional) {
		try {
			this.numeropatronalDataAccessAdditional=numeropatronalDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public NumeroPatronalDataAccess() {
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
		NumeroPatronalDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		NumeroPatronalDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		NumeroPatronalDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setNumeroPatronalOriginal(NumeroPatronal numeropatronal)throws Exception  {
		numeropatronal.setNumeroPatronalOriginal((NumeroPatronal)numeropatronal.clone());		
	}
	
	public void setNumeroPatronalsOriginal(List<NumeroPatronal> numeropatronals)throws Exception  {
		
		for(NumeroPatronal numeropatronal:numeropatronals){
			numeropatronal.setNumeroPatronalOriginal((NumeroPatronal)numeropatronal.clone());
		}
	}
	
	public static void setNumeroPatronalOriginalStatic(NumeroPatronal numeropatronal)throws Exception  {
		numeropatronal.setNumeroPatronalOriginal((NumeroPatronal)numeropatronal.clone());		
	}
	
	public static void setNumeroPatronalsOriginalStatic(List<NumeroPatronal> numeropatronals)throws Exception  {
		
		for(NumeroPatronal numeropatronal:numeropatronals){
			numeropatronal.setNumeroPatronalOriginal((NumeroPatronal)numeropatronal.clone());
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
	
	public  NumeroPatronal getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		NumeroPatronal entity = new NumeroPatronal();		
		
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
	
	public  NumeroPatronal getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		NumeroPatronal entity = new NumeroPatronal();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=NumeroPatronalDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=NumeroPatronalDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.NumeroPatronal.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setNumeroPatronalOriginal(new NumeroPatronal());
      	    	entity=super.getEntity("",entity,resultSet,NumeroPatronalDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityNumeroPatronal("",entity,resultSet); 
				
				//entity.setNumeroPatronalOriginal(super.getEntity("",entity.getNumeroPatronalOriginal(),resultSet,NumeroPatronalDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setNumeroPatronalOriginal(this.getEntityNumeroPatronal("",entity.getNumeroPatronalOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseNumeroPatronal(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  NumeroPatronal getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		NumeroPatronal entity = new NumeroPatronal();
				
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
	
	public  NumeroPatronal getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		NumeroPatronal entity = new NumeroPatronal();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=NumeroPatronalDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=NumeroPatronalDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,NumeroPatronalDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.NumeroPatronal.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setNumeroPatronalOriginal(new NumeroPatronal());
      	    	entity=super.getEntity("",entity,resultSet,NumeroPatronalDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityNumeroPatronal("",entity,resultSet);    
				
				//entity.setNumeroPatronalOriginal(super.getEntity("",entity.getNumeroPatronalOriginal(),resultSet,NumeroPatronalDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setNumeroPatronalOriginal(this.getEntityNumeroPatronal("",entity.getNumeroPatronalOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseNumeroPatronal(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //NumeroPatronal
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		NumeroPatronal entity = new NumeroPatronal();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=NumeroPatronalDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=NumeroPatronalDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,NumeroPatronalDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.NumeroPatronal.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseNumeroPatronal(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<NumeroPatronal> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<NumeroPatronal> entities = new  ArrayList<NumeroPatronal>();
		NumeroPatronal entity = new NumeroPatronal();		  
		
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
	
	public  List<NumeroPatronal> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<NumeroPatronal> entities = new  ArrayList<NumeroPatronal>();
		NumeroPatronal entity = new NumeroPatronal();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=NumeroPatronalDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=NumeroPatronalDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,NumeroPatronalDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new NumeroPatronal();
      	    	entity=super.getEntity("",entity,resultSet,NumeroPatronalDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityNumeroPatronal("",entity,resultSet);
      	    	
				//entity.setNumeroPatronalOriginal( new NumeroPatronal());
      	    	//entity.setNumeroPatronalOriginal(super.getEntity("",entity.getNumeroPatronalOriginal(),resultSet,NumeroPatronalDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setNumeroPatronalOriginal(this.getEntityNumeroPatronal("",entity.getNumeroPatronalOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseNumeroPatronals(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarNumeroPatronal(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<NumeroPatronal> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<NumeroPatronal> entities = new  ArrayList<NumeroPatronal>();
		NumeroPatronal entity = new NumeroPatronal();		  
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
	
	public  List<NumeroPatronal> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<NumeroPatronal> entities = new  ArrayList<NumeroPatronal>();
		NumeroPatronal entity = new NumeroPatronal();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new NumeroPatronal();
				
				if(conMapGenerico) {
					entity.inicializarMapNumeroPatronal();
					//entity.setMapNumeroPatronal(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapNumeroPatronalValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapNumeroPatronal().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,NumeroPatronalDataAccess.ISWITHSCHEMA);         		
					entity=NumeroPatronalDataAccess.getEntityNumeroPatronal("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setNumeroPatronalOriginal( new NumeroPatronal());
					////entity.setNumeroPatronalOriginal(super.getEntity("",entity.getNumeroPatronalOriginal(),resultSet,NumeroPatronalDataAccess.ISWITHSCHEMA));         		
					////entity.setNumeroPatronalOriginal(this.getEntityNumeroPatronal("",entity.getNumeroPatronalOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseNumeroPatronals(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarNumeroPatronal(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public NumeroPatronal getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		NumeroPatronal entity = new NumeroPatronal();		  
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
	
	public  NumeroPatronal getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		NumeroPatronal entity = new NumeroPatronal();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new NumeroPatronal();
				
				if(conMapGenerico) {
					entity.inicializarMapNumeroPatronal();
					//entity.setMapNumeroPatronal(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapNumeroPatronalValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapNumeroPatronal().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,NumeroPatronalDataAccess.ISWITHSCHEMA);         		
					entity=NumeroPatronalDataAccess.getEntityNumeroPatronal("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setNumeroPatronalOriginal( new NumeroPatronal());
					////entity.setNumeroPatronalOriginal(super.getEntity("",entity.getNumeroPatronalOriginal(),resultSet,NumeroPatronalDataAccess.ISWITHSCHEMA));         		
					////entity.setNumeroPatronalOriginal(this.getEntityNumeroPatronal("",entity.getNumeroPatronalOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseNumeroPatronal(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarNumeroPatronal(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static NumeroPatronal getEntityNumeroPatronal(String strPrefijo,NumeroPatronal entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = NumeroPatronal.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = NumeroPatronal.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					NumeroPatronalDataAccess.setFieldReflectionNumeroPatronal(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasNumeroPatronal=NumeroPatronalConstantesFunciones.getTodosTiposColumnasNumeroPatronal();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasNumeroPatronal) {
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
							field = NumeroPatronal.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = NumeroPatronal.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						NumeroPatronalDataAccess.setFieldReflectionNumeroPatronal(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionNumeroPatronal(Field field,String strPrefijo,String sColumn,NumeroPatronal entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case NumeroPatronalConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NumeroPatronalConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case NumeroPatronalConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NumeroPatronalConstantesFunciones.IDPROVINCIA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NumeroPatronalConstantesFunciones.IDCANTON:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NumeroPatronalConstantesFunciones.IDPARROQUIA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NumeroPatronalConstantesFunciones.NUMERO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case NumeroPatronalConstantesFunciones.CODIGOACTIVIDAD:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case NumeroPatronalConstantesFunciones.APELLIDO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case NumeroPatronalConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case NumeroPatronalConstantesFunciones.CEDULA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case NumeroPatronalConstantesFunciones.TELEFONO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case NumeroPatronalConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<NumeroPatronal>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<NumeroPatronal> entities = new  ArrayList<NumeroPatronal>();
		NumeroPatronal entity = new NumeroPatronal();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=NumeroPatronalDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=NumeroPatronalDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,NumeroPatronalDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new NumeroPatronal();
					entity=super.getEntity("",entity,resultSet,NumeroPatronalDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityNumeroPatronal("",entity,resultSet);
					
					//entity.setNumeroPatronalOriginal( new NumeroPatronal());
					//entity.setNumeroPatronalOriginal(super.getEntity("",entity.getNumeroPatronalOriginal(),resultSet,NumeroPatronalDataAccess.ISWITHSCHEMA));         		
					//entity.setNumeroPatronalOriginal(this.getEntityNumeroPatronal("",entity.getNumeroPatronalOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseNumeroPatronals(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarNumeroPatronal(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<NumeroPatronal>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<NumeroPatronal> entities = new  ArrayList<NumeroPatronal>();
		NumeroPatronal entity = new NumeroPatronal();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=NumeroPatronalDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=NumeroPatronalDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,NumeroPatronalDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<NumeroPatronal> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<NumeroPatronal> entities = new  ArrayList<NumeroPatronal>();
		NumeroPatronal entity = new NumeroPatronal();		  
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
	
	public  List<NumeroPatronal> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<NumeroPatronal> entities = new  ArrayList<NumeroPatronal>();
		NumeroPatronal entity = new NumeroPatronal();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new NumeroPatronal();
      	    	entity=super.getEntity("",entity,resultSet,NumeroPatronalDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityNumeroPatronal("",entity,resultSet);
      	    	
				//entity.setNumeroPatronalOriginal( new NumeroPatronal());
      	    	//entity.setNumeroPatronalOriginal(super.getEntity("",entity.getNumeroPatronalOriginal(),resultSet,NumeroPatronalDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setNumeroPatronalOriginal(this.getEntityNumeroPatronal("",entity.getNumeroPatronalOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseNumeroPatronals(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarNumeroPatronal(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<NumeroPatronal> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<NumeroPatronal> entities = new  ArrayList<NumeroPatronal>();
		NumeroPatronal entity = new NumeroPatronal();		  
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
	
	public  List<NumeroPatronal> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<NumeroPatronal> entities = new  ArrayList<NumeroPatronal>();
		NumeroPatronal entity = new NumeroPatronal();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new NumeroPatronal();
      	    	entity=super.getEntity("",entity,resultSet,NumeroPatronalDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityNumeroPatronal("",entity,resultSet);
      	    	
				//entity.setNumeroPatronalOriginal( new NumeroPatronal());
      	    	//entity.setNumeroPatronalOriginal(super.getEntity("",entity.getNumeroPatronalOriginal(),resultSet,NumeroPatronalDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setNumeroPatronalOriginal(this.getEntityNumeroPatronal("",entity.getNumeroPatronalOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseNumeroPatronals(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public NumeroPatronal getEntityNumeroPatronal(String strPrefijo,NumeroPatronal entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+NumeroPatronalConstantesFunciones.IDEMPRESA));
				entity.setid_provincia(resultSet.getLong(strPrefijo+NumeroPatronalConstantesFunciones.IDPROVINCIA));
				entity.setid_canton(resultSet.getLong(strPrefijo+NumeroPatronalConstantesFunciones.IDCANTON));
				entity.setid_parroquia(resultSet.getLong(strPrefijo+NumeroPatronalConstantesFunciones.IDPARROQUIA));
				entity.setnumero(resultSet.getString(strPrefijo+NumeroPatronalConstantesFunciones.NUMERO));
				entity.setcodigo_actividad(resultSet.getString(strPrefijo+NumeroPatronalConstantesFunciones.CODIGOACTIVIDAD));
				entity.setapellido(resultSet.getString(strPrefijo+NumeroPatronalConstantesFunciones.APELLIDO));
				entity.setnombre(resultSet.getString(strPrefijo+NumeroPatronalConstantesFunciones.NOMBRE));
				entity.setcedula(resultSet.getString(strPrefijo+NumeroPatronalConstantesFunciones.CEDULA));
				entity.settelefono(resultSet.getString(strPrefijo+NumeroPatronalConstantesFunciones.TELEFONO));
				entity.setdescripcion(resultSet.getString(strPrefijo+NumeroPatronalConstantesFunciones.DESCRIPCION));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+NumeroPatronalConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowNumeroPatronal(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(NumeroPatronal entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=NumeroPatronalDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=NumeroPatronalDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=NumeroPatronalDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=NumeroPatronalDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(NumeroPatronalConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,NumeroPatronalDataAccess.TABLENAME,NumeroPatronalDataAccess.ISWITHSTOREPROCEDURES);
			
			NumeroPatronalDataAccess.setNumeroPatronalOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,NumeroPatronal relnumeropatronal)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relnumeropatronal.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Provincia getProvincia(Connexion connexion,NumeroPatronal relnumeropatronal)throws SQLException,Exception {

		Provincia provincia= new Provincia();

		try {
			ProvinciaDataAccess provinciaDataAccess=new ProvinciaDataAccess();

			provinciaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			provinciaDataAccess.setConnexionType(this.connexionType);
			provinciaDataAccess.setParameterDbType(this.parameterDbType);

			provincia=provinciaDataAccess.getEntity(connexion,relnumeropatronal.getid_provincia());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return provincia;

	}

	public Canton getCanton(Connexion connexion,NumeroPatronal relnumeropatronal)throws SQLException,Exception {

		Canton canton= new Canton();

		try {
			CantonDataAccess cantonDataAccess=new CantonDataAccess();

			cantonDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cantonDataAccess.setConnexionType(this.connexionType);
			cantonDataAccess.setParameterDbType(this.parameterDbType);

			canton=cantonDataAccess.getEntity(connexion,relnumeropatronal.getid_canton());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return canton;

	}

	public Parroquia getParroquia(Connexion connexion,NumeroPatronal relnumeropatronal)throws SQLException,Exception {

		Parroquia parroquia= new Parroquia();

		try {
			ParroquiaDataAccess parroquiaDataAccess=new ParroquiaDataAccess();

			parroquiaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			parroquiaDataAccess.setConnexionType(this.connexionType);
			parroquiaDataAccess.setParameterDbType(this.parameterDbType);

			parroquia=parroquiaDataAccess.getEntity(connexion,relnumeropatronal.getid_parroquia());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return parroquia;

	}


		
		public List<DatoGeneralEmpleado> getDatoGeneralEmpleados(Connexion connexion,NumeroPatronal numeropatronal)throws SQLException,Exception {

		List<DatoGeneralEmpleado> datogeneralempleados= new ArrayList<DatoGeneralEmpleado>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+NumeroPatronalConstantesFunciones.SCHEMA+".numero_patronal ON "+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+".dato_general_empleado.id_numero_patronal="+NumeroPatronalConstantesFunciones.SCHEMA+".numero_patronal.id WHERE "+NumeroPatronalConstantesFunciones.SCHEMA+".numero_patronal.id="+String.valueOf(numeropatronal.getId());
			} else {
				sQuery=" INNER JOIN datogeneralempleado.NumeroPatronal WHERE datogeneralempleado.NumeroPatronal.id="+String.valueOf(numeropatronal.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DatoGeneralEmpleadoDataAccess datogeneralempleadoDataAccess=new DatoGeneralEmpleadoDataAccess();

			datogeneralempleadoDataAccess.setConnexionType(this.connexionType);
			datogeneralempleadoDataAccess.setParameterDbType(this.parameterDbType);
			datogeneralempleados=datogeneralempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return datogeneralempleados;

	}

	public List<Estructura> getEstructuras(Connexion connexion,NumeroPatronal numeropatronal)throws SQLException,Exception {

		List<Estructura> estructuras= new ArrayList<Estructura>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+NumeroPatronalConstantesFunciones.SCHEMA+".numero_patronal ON "+EstructuraConstantesFunciones.SCHEMA+".estructura.id_numero_patronal="+NumeroPatronalConstantesFunciones.SCHEMA+".numero_patronal.id WHERE "+NumeroPatronalConstantesFunciones.SCHEMA+".numero_patronal.id="+String.valueOf(numeropatronal.getId());
			} else {
				sQuery=" INNER JOIN estructura.NumeroPatronal WHERE estructura.NumeroPatronal.id="+String.valueOf(numeropatronal.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			EstructuraDataAccess estructuraDataAccess=new EstructuraDataAccess();

			estructuraDataAccess.setConnexionType(this.connexionType);
			estructuraDataAccess.setParameterDbType(this.parameterDbType);
			estructuras=estructuraDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estructuras;

	}

	public List<Cargo> getCargos(Connexion connexion,NumeroPatronal numeropatronal)throws SQLException,Exception {

		List<Cargo> cargos= new ArrayList<Cargo>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+NumeroPatronalConstantesFunciones.SCHEMA+".numero_patronal ON "+CargoConstantesFunciones.SCHEMA+".cargo.id_numero_patronal="+NumeroPatronalConstantesFunciones.SCHEMA+".numero_patronal.id WHERE "+NumeroPatronalConstantesFunciones.SCHEMA+".numero_patronal.id="+String.valueOf(numeropatronal.getId());
			} else {
				sQuery=" INNER JOIN cargo.NumeroPatronal WHERE cargo.NumeroPatronal.id="+String.valueOf(numeropatronal.getId());

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


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,NumeroPatronal numeropatronal) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!numeropatronal.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(numeropatronal.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_provincia=new ParameterValue<Long>();
					parameterMaintenanceValueid_provincia.setValue(numeropatronal.getid_provincia());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_provincia);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_canton=new ParameterValue<Long>();
					parameterMaintenanceValueid_canton.setValue(numeropatronal.getid_canton());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_canton);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_parroquia=new ParameterValue<Long>();
					parameterMaintenanceValueid_parroquia.setValue(numeropatronal.getid_parroquia());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_parroquia);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero=new ParameterValue<String>();
					parameterMaintenanceValuenumero.setValue(numeropatronal.getnumero());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo_actividad=new ParameterValue<String>();
					parameterMaintenanceValuecodigo_actividad.setValue(numeropatronal.getcodigo_actividad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo_actividad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueapellido=new ParameterValue<String>();
					parameterMaintenanceValueapellido.setValue(numeropatronal.getapellido());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueapellido);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(numeropatronal.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecedula=new ParameterValue<String>();
					parameterMaintenanceValuecedula.setValue(numeropatronal.getcedula());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecedula);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuetelefono=new ParameterValue<String>();
					parameterMaintenanceValuetelefono.setValue(numeropatronal.gettelefono());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetelefono);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(numeropatronal.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!numeropatronal.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(numeropatronal.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(numeropatronal.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(numeropatronal.getId());
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
	
	public void setIsNewIsChangedFalseNumeroPatronal(NumeroPatronal numeropatronal)throws Exception  {		
		numeropatronal.setIsNew(false);
		numeropatronal.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseNumeroPatronals(List<NumeroPatronal> numeropatronals)throws Exception  {				
		for(NumeroPatronal numeropatronal:numeropatronals) {
			numeropatronal.setIsNew(false);
			numeropatronal.setIsChanged(false);
		}
	}
	
	public void generarExportarNumeroPatronal(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
