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
import com.bydan.erp.nomina.util.*;//RubroEmpleaCuentaContableConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class RubroEmpleaCuentaContableDataAccess extends  RubroEmpleaCuentaContableDataAccessAdditional{ //RubroEmpleaCuentaContableDataAccessAdditional,DataAccessHelper<RubroEmpleaCuentaContable>
	//static Logger logger = Logger.getLogger(RubroEmpleaCuentaContableDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="rubro_emplea_cuenta_contable";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+RubroEmpleaCuentaContableConstantesFunciones.SCHEMA+"."+RubroEmpleaCuentaContableConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_rubro_emplea,id_cuenta_contable,id_estructura)values(current_timestamp,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+RubroEmpleaCuentaContableConstantesFunciones.SCHEMA+"."+RubroEmpleaCuentaContableConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_rubro_emplea=?,id_cuenta_contable=?,id_estructura=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+RubroEmpleaCuentaContableConstantesFunciones.SCHEMA+"."+RubroEmpleaCuentaContableConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select rubroempleacuentacontable from "+RubroEmpleaCuentaContableConstantesFunciones.SPERSISTENCENAME+" rubroempleacuentacontable";
	public static String QUERYSELECTNATIVE="select "+RubroEmpleaCuentaContableConstantesFunciones.SCHEMA+"."+RubroEmpleaCuentaContableConstantesFunciones.TABLENAME+".id,"+RubroEmpleaCuentaContableConstantesFunciones.SCHEMA+"."+RubroEmpleaCuentaContableConstantesFunciones.TABLENAME+".version_row,"+RubroEmpleaCuentaContableConstantesFunciones.SCHEMA+"."+RubroEmpleaCuentaContableConstantesFunciones.TABLENAME+".id_empresa,"+RubroEmpleaCuentaContableConstantesFunciones.SCHEMA+"."+RubroEmpleaCuentaContableConstantesFunciones.TABLENAME+".id_sucursal,"+RubroEmpleaCuentaContableConstantesFunciones.SCHEMA+"."+RubroEmpleaCuentaContableConstantesFunciones.TABLENAME+".id_rubro_emplea,"+RubroEmpleaCuentaContableConstantesFunciones.SCHEMA+"."+RubroEmpleaCuentaContableConstantesFunciones.TABLENAME+".id_cuenta_contable,"+RubroEmpleaCuentaContableConstantesFunciones.SCHEMA+"."+RubroEmpleaCuentaContableConstantesFunciones.TABLENAME+".id_estructura from "+RubroEmpleaCuentaContableConstantesFunciones.SCHEMA+"."+RubroEmpleaCuentaContableConstantesFunciones.TABLENAME;//+" as "+RubroEmpleaCuentaContableConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+RubroEmpleaCuentaContableConstantesFunciones.SCHEMA+"."+RubroEmpleaCuentaContableConstantesFunciones.TABLENAME+".id,"+RubroEmpleaCuentaContableConstantesFunciones.SCHEMA+"."+RubroEmpleaCuentaContableConstantesFunciones.TABLENAME+".version_row from "+RubroEmpleaCuentaContableConstantesFunciones.SCHEMA+"."+RubroEmpleaCuentaContableConstantesFunciones.TABLENAME;//+" as "+RubroEmpleaCuentaContableConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+RubroEmpleaCuentaContableConstantesFunciones.SCHEMA+"."+RubroEmpleaCuentaContableConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_rubro_emplea=?,id_cuenta_contable=?,id_estructura=?";
	
	public static String STOREPROCEDUREINSERT="call SP_RUBROEMPLEACUENTACONTABLE_INSERT(?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_RUBROEMPLEACUENTACONTABLE_UPDATE(?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_RUBROEMPLEACUENTACONTABLE_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_RUBROEMPLEACUENTACONTABLE_SELECT(?,?)";
	
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
	
	
	protected RubroEmpleaCuentaContableDataAccessAdditional rubroempleacuentacontableDataAccessAdditional=null;
	
	public RubroEmpleaCuentaContableDataAccessAdditional getRubroEmpleaCuentaContableDataAccessAdditional() {
		return this.rubroempleacuentacontableDataAccessAdditional;
	}
	
	public void setRubroEmpleaCuentaContableDataAccessAdditional(RubroEmpleaCuentaContableDataAccessAdditional rubroempleacuentacontableDataAccessAdditional) {
		try {
			this.rubroempleacuentacontableDataAccessAdditional=rubroempleacuentacontableDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public RubroEmpleaCuentaContableDataAccess() {
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
		RubroEmpleaCuentaContableDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		RubroEmpleaCuentaContableDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		RubroEmpleaCuentaContableDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setRubroEmpleaCuentaContableOriginal(RubroEmpleaCuentaContable rubroempleacuentacontable)throws Exception  {
		rubroempleacuentacontable.setRubroEmpleaCuentaContableOriginal((RubroEmpleaCuentaContable)rubroempleacuentacontable.clone());		
	}
	
	public void setRubroEmpleaCuentaContablesOriginal(List<RubroEmpleaCuentaContable> rubroempleacuentacontables)throws Exception  {
		
		for(RubroEmpleaCuentaContable rubroempleacuentacontable:rubroempleacuentacontables){
			rubroempleacuentacontable.setRubroEmpleaCuentaContableOriginal((RubroEmpleaCuentaContable)rubroempleacuentacontable.clone());
		}
	}
	
	public static void setRubroEmpleaCuentaContableOriginalStatic(RubroEmpleaCuentaContable rubroempleacuentacontable)throws Exception  {
		rubroempleacuentacontable.setRubroEmpleaCuentaContableOriginal((RubroEmpleaCuentaContable)rubroempleacuentacontable.clone());		
	}
	
	public static void setRubroEmpleaCuentaContablesOriginalStatic(List<RubroEmpleaCuentaContable> rubroempleacuentacontables)throws Exception  {
		
		for(RubroEmpleaCuentaContable rubroempleacuentacontable:rubroempleacuentacontables){
			rubroempleacuentacontable.setRubroEmpleaCuentaContableOriginal((RubroEmpleaCuentaContable)rubroempleacuentacontable.clone());
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
	
	public  RubroEmpleaCuentaContable getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		RubroEmpleaCuentaContable entity = new RubroEmpleaCuentaContable();		
		
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
	
	public  RubroEmpleaCuentaContable getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		RubroEmpleaCuentaContable entity = new RubroEmpleaCuentaContable();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=RubroEmpleaCuentaContableDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=RubroEmpleaCuentaContableDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.RubroEmpleaCuentaContable.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setRubroEmpleaCuentaContableOriginal(new RubroEmpleaCuentaContable());
      	    	entity=super.getEntity("",entity,resultSet,RubroEmpleaCuentaContableDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityRubroEmpleaCuentaContable("",entity,resultSet); 
				
				//entity.setRubroEmpleaCuentaContableOriginal(super.getEntity("",entity.getRubroEmpleaCuentaContableOriginal(),resultSet,RubroEmpleaCuentaContableDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRubroEmpleaCuentaContableOriginal(this.getEntityRubroEmpleaCuentaContable("",entity.getRubroEmpleaCuentaContableOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseRubroEmpleaCuentaContable(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  RubroEmpleaCuentaContable getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		RubroEmpleaCuentaContable entity = new RubroEmpleaCuentaContable();
				
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
	
	public  RubroEmpleaCuentaContable getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		RubroEmpleaCuentaContable entity = new RubroEmpleaCuentaContable();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=RubroEmpleaCuentaContableDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=RubroEmpleaCuentaContableDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RubroEmpleaCuentaContableDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.RubroEmpleaCuentaContable.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setRubroEmpleaCuentaContableOriginal(new RubroEmpleaCuentaContable());
      	    	entity=super.getEntity("",entity,resultSet,RubroEmpleaCuentaContableDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityRubroEmpleaCuentaContable("",entity,resultSet);    
				
				//entity.setRubroEmpleaCuentaContableOriginal(super.getEntity("",entity.getRubroEmpleaCuentaContableOriginal(),resultSet,RubroEmpleaCuentaContableDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRubroEmpleaCuentaContableOriginal(this.getEntityRubroEmpleaCuentaContable("",entity.getRubroEmpleaCuentaContableOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseRubroEmpleaCuentaContable(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //RubroEmpleaCuentaContable
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		RubroEmpleaCuentaContable entity = new RubroEmpleaCuentaContable();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=RubroEmpleaCuentaContableDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=RubroEmpleaCuentaContableDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RubroEmpleaCuentaContableDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.RubroEmpleaCuentaContable.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseRubroEmpleaCuentaContable(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<RubroEmpleaCuentaContable> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<RubroEmpleaCuentaContable> entities = new  ArrayList<RubroEmpleaCuentaContable>();
		RubroEmpleaCuentaContable entity = new RubroEmpleaCuentaContable();		  
		
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
	
	public  List<RubroEmpleaCuentaContable> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<RubroEmpleaCuentaContable> entities = new  ArrayList<RubroEmpleaCuentaContable>();
		RubroEmpleaCuentaContable entity = new RubroEmpleaCuentaContable();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=RubroEmpleaCuentaContableDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=RubroEmpleaCuentaContableDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RubroEmpleaCuentaContableDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new RubroEmpleaCuentaContable();
      	    	entity=super.getEntity("",entity,resultSet,RubroEmpleaCuentaContableDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityRubroEmpleaCuentaContable("",entity,resultSet);
      	    	
				//entity.setRubroEmpleaCuentaContableOriginal( new RubroEmpleaCuentaContable());
      	    	//entity.setRubroEmpleaCuentaContableOriginal(super.getEntity("",entity.getRubroEmpleaCuentaContableOriginal(),resultSet,RubroEmpleaCuentaContableDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRubroEmpleaCuentaContableOriginal(this.getEntityRubroEmpleaCuentaContable("",entity.getRubroEmpleaCuentaContableOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseRubroEmpleaCuentaContables(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRubroEmpleaCuentaContable(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<RubroEmpleaCuentaContable> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<RubroEmpleaCuentaContable> entities = new  ArrayList<RubroEmpleaCuentaContable>();
		RubroEmpleaCuentaContable entity = new RubroEmpleaCuentaContable();		  
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
	
	public  List<RubroEmpleaCuentaContable> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<RubroEmpleaCuentaContable> entities = new  ArrayList<RubroEmpleaCuentaContable>();
		RubroEmpleaCuentaContable entity = new RubroEmpleaCuentaContable();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new RubroEmpleaCuentaContable();
				
				if(conMapGenerico) {
					entity.inicializarMapRubroEmpleaCuentaContable();
					//entity.setMapRubroEmpleaCuentaContable(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapRubroEmpleaCuentaContableValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapRubroEmpleaCuentaContable().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,RubroEmpleaCuentaContableDataAccess.ISWITHSCHEMA);         		
					entity=RubroEmpleaCuentaContableDataAccess.getEntityRubroEmpleaCuentaContable("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setRubroEmpleaCuentaContableOriginal( new RubroEmpleaCuentaContable());
					////entity.setRubroEmpleaCuentaContableOriginal(super.getEntity("",entity.getRubroEmpleaCuentaContableOriginal(),resultSet,RubroEmpleaCuentaContableDataAccess.ISWITHSCHEMA));         		
					////entity.setRubroEmpleaCuentaContableOriginal(this.getEntityRubroEmpleaCuentaContable("",entity.getRubroEmpleaCuentaContableOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseRubroEmpleaCuentaContables(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRubroEmpleaCuentaContable(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public RubroEmpleaCuentaContable getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		RubroEmpleaCuentaContable entity = new RubroEmpleaCuentaContable();		  
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
	
	public  RubroEmpleaCuentaContable getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		RubroEmpleaCuentaContable entity = new RubroEmpleaCuentaContable();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new RubroEmpleaCuentaContable();
				
				if(conMapGenerico) {
					entity.inicializarMapRubroEmpleaCuentaContable();
					//entity.setMapRubroEmpleaCuentaContable(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapRubroEmpleaCuentaContableValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapRubroEmpleaCuentaContable().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,RubroEmpleaCuentaContableDataAccess.ISWITHSCHEMA);         		
					entity=RubroEmpleaCuentaContableDataAccess.getEntityRubroEmpleaCuentaContable("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setRubroEmpleaCuentaContableOriginal( new RubroEmpleaCuentaContable());
					////entity.setRubroEmpleaCuentaContableOriginal(super.getEntity("",entity.getRubroEmpleaCuentaContableOriginal(),resultSet,RubroEmpleaCuentaContableDataAccess.ISWITHSCHEMA));         		
					////entity.setRubroEmpleaCuentaContableOriginal(this.getEntityRubroEmpleaCuentaContable("",entity.getRubroEmpleaCuentaContableOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseRubroEmpleaCuentaContable(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRubroEmpleaCuentaContable(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static RubroEmpleaCuentaContable getEntityRubroEmpleaCuentaContable(String strPrefijo,RubroEmpleaCuentaContable entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = RubroEmpleaCuentaContable.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = RubroEmpleaCuentaContable.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					RubroEmpleaCuentaContableDataAccess.setFieldReflectionRubroEmpleaCuentaContable(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasRubroEmpleaCuentaContable=RubroEmpleaCuentaContableConstantesFunciones.getTodosTiposColumnasRubroEmpleaCuentaContable();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasRubroEmpleaCuentaContable) {
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
							field = RubroEmpleaCuentaContable.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = RubroEmpleaCuentaContable.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						RubroEmpleaCuentaContableDataAccess.setFieldReflectionRubroEmpleaCuentaContable(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionRubroEmpleaCuentaContable(Field field,String strPrefijo,String sColumn,RubroEmpleaCuentaContable entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case RubroEmpleaCuentaContableConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RubroEmpleaCuentaContableConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RubroEmpleaCuentaContableConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RubroEmpleaCuentaContableConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RubroEmpleaCuentaContableConstantesFunciones.IDRUBROEMPLEA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RubroEmpleaCuentaContableConstantesFunciones.IDCUENTACONTABLE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RubroEmpleaCuentaContableConstantesFunciones.IDESTRUCTURA:
					field.set(entity,resultSet.getLong(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<RubroEmpleaCuentaContable>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<RubroEmpleaCuentaContable> entities = new  ArrayList<RubroEmpleaCuentaContable>();
		RubroEmpleaCuentaContable entity = new RubroEmpleaCuentaContable();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=RubroEmpleaCuentaContableDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=RubroEmpleaCuentaContableDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RubroEmpleaCuentaContableDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new RubroEmpleaCuentaContable();
					entity=super.getEntity("",entity,resultSet,RubroEmpleaCuentaContableDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityRubroEmpleaCuentaContable("",entity,resultSet);
					
					//entity.setRubroEmpleaCuentaContableOriginal( new RubroEmpleaCuentaContable());
					//entity.setRubroEmpleaCuentaContableOriginal(super.getEntity("",entity.getRubroEmpleaCuentaContableOriginal(),resultSet,RubroEmpleaCuentaContableDataAccess.ISWITHSCHEMA));         		
					//entity.setRubroEmpleaCuentaContableOriginal(this.getEntityRubroEmpleaCuentaContable("",entity.getRubroEmpleaCuentaContableOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseRubroEmpleaCuentaContables(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRubroEmpleaCuentaContable(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<RubroEmpleaCuentaContable>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<RubroEmpleaCuentaContable> entities = new  ArrayList<RubroEmpleaCuentaContable>();
		RubroEmpleaCuentaContable entity = new RubroEmpleaCuentaContable();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=RubroEmpleaCuentaContableDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=RubroEmpleaCuentaContableDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RubroEmpleaCuentaContableDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<RubroEmpleaCuentaContable> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<RubroEmpleaCuentaContable> entities = new  ArrayList<RubroEmpleaCuentaContable>();
		RubroEmpleaCuentaContable entity = new RubroEmpleaCuentaContable();		  
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
	
	public  List<RubroEmpleaCuentaContable> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<RubroEmpleaCuentaContable> entities = new  ArrayList<RubroEmpleaCuentaContable>();
		RubroEmpleaCuentaContable entity = new RubroEmpleaCuentaContable();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new RubroEmpleaCuentaContable();
      	    	entity=super.getEntity("",entity,resultSet,RubroEmpleaCuentaContableDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityRubroEmpleaCuentaContable("",entity,resultSet);
      	    	
				//entity.setRubroEmpleaCuentaContableOriginal( new RubroEmpleaCuentaContable());
      	    	//entity.setRubroEmpleaCuentaContableOriginal(super.getEntity("",entity.getRubroEmpleaCuentaContableOriginal(),resultSet,RubroEmpleaCuentaContableDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRubroEmpleaCuentaContableOriginal(this.getEntityRubroEmpleaCuentaContable("",entity.getRubroEmpleaCuentaContableOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseRubroEmpleaCuentaContables(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRubroEmpleaCuentaContable(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<RubroEmpleaCuentaContable> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<RubroEmpleaCuentaContable> entities = new  ArrayList<RubroEmpleaCuentaContable>();
		RubroEmpleaCuentaContable entity = new RubroEmpleaCuentaContable();		  
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
	
	public  List<RubroEmpleaCuentaContable> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<RubroEmpleaCuentaContable> entities = new  ArrayList<RubroEmpleaCuentaContable>();
		RubroEmpleaCuentaContable entity = new RubroEmpleaCuentaContable();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new RubroEmpleaCuentaContable();
      	    	entity=super.getEntity("",entity,resultSet,RubroEmpleaCuentaContableDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityRubroEmpleaCuentaContable("",entity,resultSet);
      	    	
				//entity.setRubroEmpleaCuentaContableOriginal( new RubroEmpleaCuentaContable());
      	    	//entity.setRubroEmpleaCuentaContableOriginal(super.getEntity("",entity.getRubroEmpleaCuentaContableOriginal(),resultSet,RubroEmpleaCuentaContableDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRubroEmpleaCuentaContableOriginal(this.getEntityRubroEmpleaCuentaContable("",entity.getRubroEmpleaCuentaContableOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseRubroEmpleaCuentaContables(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public RubroEmpleaCuentaContable getEntityRubroEmpleaCuentaContable(String strPrefijo,RubroEmpleaCuentaContable entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+RubroEmpleaCuentaContableConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+RubroEmpleaCuentaContableConstantesFunciones.IDSUCURSAL));
				entity.setid_rubro_emplea(resultSet.getLong(strPrefijo+RubroEmpleaCuentaContableConstantesFunciones.IDRUBROEMPLEA));
				entity.setid_cuenta_contable(resultSet.getLong(strPrefijo+RubroEmpleaCuentaContableConstantesFunciones.IDCUENTACONTABLE));
				entity.setid_estructura(resultSet.getLong(strPrefijo+RubroEmpleaCuentaContableConstantesFunciones.IDESTRUCTURA));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowRubroEmpleaCuentaContable(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(RubroEmpleaCuentaContable entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=RubroEmpleaCuentaContableDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=RubroEmpleaCuentaContableDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=RubroEmpleaCuentaContableDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=RubroEmpleaCuentaContableDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(RubroEmpleaCuentaContableConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,RubroEmpleaCuentaContableDataAccess.TABLENAME,RubroEmpleaCuentaContableDataAccess.ISWITHSTOREPROCEDURES);
			
			RubroEmpleaCuentaContableDataAccess.setRubroEmpleaCuentaContableOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,RubroEmpleaCuentaContable relrubroempleacuentacontable)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relrubroempleacuentacontable.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,RubroEmpleaCuentaContable relrubroempleacuentacontable)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relrubroempleacuentacontable.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public RubroEmplea getRubroEmplea(Connexion connexion,RubroEmpleaCuentaContable relrubroempleacuentacontable)throws SQLException,Exception {

		RubroEmplea rubroemplea= new RubroEmplea();

		try {
			RubroEmpleaDataAccess rubroempleaDataAccess=new RubroEmpleaDataAccess();

			rubroempleaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			rubroempleaDataAccess.setConnexionType(this.connexionType);
			rubroempleaDataAccess.setParameterDbType(this.parameterDbType);

			rubroemplea=rubroempleaDataAccess.getEntity(connexion,relrubroempleacuentacontable.getid_rubro_emplea());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return rubroemplea;

	}

	public CuentaContable getCuentaContable(Connexion connexion,RubroEmpleaCuentaContable relrubroempleacuentacontable)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relrubroempleacuentacontable.getid_cuenta_contable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public Estructura getEstructura(Connexion connexion,RubroEmpleaCuentaContable relrubroempleacuentacontable)throws SQLException,Exception {

		Estructura estructura= new Estructura();

		try {
			EstructuraDataAccess estructuraDataAccess=new EstructuraDataAccess();

			estructuraDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estructuraDataAccess.setConnexionType(this.connexionType);
			estructuraDataAccess.setParameterDbType(this.parameterDbType);

			estructura=estructuraDataAccess.getEntity(connexion,relrubroempleacuentacontable.getid_estructura());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estructura;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,RubroEmpleaCuentaContable rubroempleacuentacontable) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!rubroempleacuentacontable.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(rubroempleacuentacontable.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(rubroempleacuentacontable.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_rubro_emplea=new ParameterValue<Long>();
					parameterMaintenanceValueid_rubro_emplea.setValue(rubroempleacuentacontable.getid_rubro_emplea());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_rubro_emplea);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable.setValue(rubroempleacuentacontable.getid_cuenta_contable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estructura=new ParameterValue<Long>();
					parameterMaintenanceValueid_estructura.setValue(rubroempleacuentacontable.getid_estructura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estructura);
					parametersTemp.add(parameterMaintenance);
					
						if(!rubroempleacuentacontable.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(rubroempleacuentacontable.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(rubroempleacuentacontable.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(rubroempleacuentacontable.getId());
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
	
	public void setIsNewIsChangedFalseRubroEmpleaCuentaContable(RubroEmpleaCuentaContable rubroempleacuentacontable)throws Exception  {		
		rubroempleacuentacontable.setIsNew(false);
		rubroempleacuentacontable.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseRubroEmpleaCuentaContables(List<RubroEmpleaCuentaContable> rubroempleacuentacontables)throws Exception  {				
		for(RubroEmpleaCuentaContable rubroempleacuentacontable:rubroempleacuentacontables) {
			rubroempleacuentacontable.setIsNew(false);
			rubroempleacuentacontable.setIsChanged(false);
		}
	}
	
	public void generarExportarRubroEmpleaCuentaContable(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
