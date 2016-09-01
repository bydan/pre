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
import com.bydan.erp.nomina.util.*;//ProfesionEmpleaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class ProfesionEmpleaDataAccess extends  ProfesionEmpleaDataAccessAdditional{ //ProfesionEmpleaDataAccessAdditional,DataAccessHelper<ProfesionEmplea>
	//static Logger logger = Logger.getLogger(ProfesionEmpleaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="profesion_emplea";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ProfesionEmpleaConstantesFunciones.SCHEMA+"."+ProfesionEmpleaConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_empleado,id_profesion)values(current_timestamp,?,?,?)";
	public static String QUERYUPDATE="update "+ProfesionEmpleaConstantesFunciones.SCHEMA+"."+ProfesionEmpleaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_empleado=?,id_profesion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ProfesionEmpleaConstantesFunciones.SCHEMA+"."+ProfesionEmpleaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select profesionemplea from "+ProfesionEmpleaConstantesFunciones.SPERSISTENCENAME+" profesionemplea";
	public static String QUERYSELECTNATIVE="select "+ProfesionEmpleaConstantesFunciones.SCHEMA+"."+ProfesionEmpleaConstantesFunciones.TABLENAME+".id,"+ProfesionEmpleaConstantesFunciones.SCHEMA+"."+ProfesionEmpleaConstantesFunciones.TABLENAME+".version_row,"+ProfesionEmpleaConstantesFunciones.SCHEMA+"."+ProfesionEmpleaConstantesFunciones.TABLENAME+".id_empresa,"+ProfesionEmpleaConstantesFunciones.SCHEMA+"."+ProfesionEmpleaConstantesFunciones.TABLENAME+".id_empleado,"+ProfesionEmpleaConstantesFunciones.SCHEMA+"."+ProfesionEmpleaConstantesFunciones.TABLENAME+".id_profesion from "+ProfesionEmpleaConstantesFunciones.SCHEMA+"."+ProfesionEmpleaConstantesFunciones.TABLENAME;//+" as "+ProfesionEmpleaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ProfesionEmpleaConstantesFunciones.SCHEMA+"."+ProfesionEmpleaConstantesFunciones.TABLENAME+".id,"+ProfesionEmpleaConstantesFunciones.SCHEMA+"."+ProfesionEmpleaConstantesFunciones.TABLENAME+".version_row from "+ProfesionEmpleaConstantesFunciones.SCHEMA+"."+ProfesionEmpleaConstantesFunciones.TABLENAME;//+" as "+ProfesionEmpleaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ProfesionEmpleaConstantesFunciones.SCHEMA+"."+ProfesionEmpleaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_empleado=?,id_profesion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PROFESIONEMPLEA_INSERT(?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PROFESIONEMPLEA_UPDATE(?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PROFESIONEMPLEA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PROFESIONEMPLEA_SELECT(?,?)";
	
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
	
	
	protected ProfesionEmpleaDataAccessAdditional profesionempleaDataAccessAdditional=null;
	
	public ProfesionEmpleaDataAccessAdditional getProfesionEmpleaDataAccessAdditional() {
		return this.profesionempleaDataAccessAdditional;
	}
	
	public void setProfesionEmpleaDataAccessAdditional(ProfesionEmpleaDataAccessAdditional profesionempleaDataAccessAdditional) {
		try {
			this.profesionempleaDataAccessAdditional=profesionempleaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ProfesionEmpleaDataAccess() {
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
		ProfesionEmpleaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ProfesionEmpleaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ProfesionEmpleaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setProfesionEmpleaOriginal(ProfesionEmplea profesionemplea)throws Exception  {
		profesionemplea.setProfesionEmpleaOriginal((ProfesionEmplea)profesionemplea.clone());		
	}
	
	public void setProfesionEmpleasOriginal(List<ProfesionEmplea> profesionempleas)throws Exception  {
		
		for(ProfesionEmplea profesionemplea:profesionempleas){
			profesionemplea.setProfesionEmpleaOriginal((ProfesionEmplea)profesionemplea.clone());
		}
	}
	
	public static void setProfesionEmpleaOriginalStatic(ProfesionEmplea profesionemplea)throws Exception  {
		profesionemplea.setProfesionEmpleaOriginal((ProfesionEmplea)profesionemplea.clone());		
	}
	
	public static void setProfesionEmpleasOriginalStatic(List<ProfesionEmplea> profesionempleas)throws Exception  {
		
		for(ProfesionEmplea profesionemplea:profesionempleas){
			profesionemplea.setProfesionEmpleaOriginal((ProfesionEmplea)profesionemplea.clone());
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
	
	public  ProfesionEmplea getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		ProfesionEmplea entity = new ProfesionEmplea();		
		
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
	
	public  ProfesionEmplea getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		ProfesionEmplea entity = new ProfesionEmplea();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ProfesionEmpleaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ProfesionEmpleaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.ProfesionEmplea.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setProfesionEmpleaOriginal(new ProfesionEmplea());
      	    	entity=super.getEntity("",entity,resultSet,ProfesionEmpleaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityProfesionEmplea("",entity,resultSet); 
				
				//entity.setProfesionEmpleaOriginal(super.getEntity("",entity.getProfesionEmpleaOriginal(),resultSet,ProfesionEmpleaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProfesionEmpleaOriginal(this.getEntityProfesionEmplea("",entity.getProfesionEmpleaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseProfesionEmplea(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  ProfesionEmplea getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ProfesionEmplea entity = new ProfesionEmplea();
				
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
	
	public  ProfesionEmplea getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ProfesionEmplea entity = new ProfesionEmplea();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ProfesionEmpleaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ProfesionEmpleaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProfesionEmpleaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.ProfesionEmplea.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setProfesionEmpleaOriginal(new ProfesionEmplea());
      	    	entity=super.getEntity("",entity,resultSet,ProfesionEmpleaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityProfesionEmplea("",entity,resultSet);    
				
				//entity.setProfesionEmpleaOriginal(super.getEntity("",entity.getProfesionEmpleaOriginal(),resultSet,ProfesionEmpleaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProfesionEmpleaOriginal(this.getEntityProfesionEmplea("",entity.getProfesionEmpleaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseProfesionEmplea(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //ProfesionEmplea
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		ProfesionEmplea entity = new ProfesionEmplea();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ProfesionEmpleaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ProfesionEmpleaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProfesionEmpleaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.ProfesionEmplea.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseProfesionEmplea(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<ProfesionEmplea> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ProfesionEmplea> entities = new  ArrayList<ProfesionEmplea>();
		ProfesionEmplea entity = new ProfesionEmplea();		  
		
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
	
	public  List<ProfesionEmplea> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ProfesionEmplea> entities = new  ArrayList<ProfesionEmplea>();
		ProfesionEmplea entity = new ProfesionEmplea();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ProfesionEmpleaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ProfesionEmpleaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProfesionEmpleaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProfesionEmplea();
      	    	entity=super.getEntity("",entity,resultSet,ProfesionEmpleaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityProfesionEmplea("",entity,resultSet);
      	    	
				//entity.setProfesionEmpleaOriginal( new ProfesionEmplea());
      	    	//entity.setProfesionEmpleaOriginal(super.getEntity("",entity.getProfesionEmpleaOriginal(),resultSet,ProfesionEmpleaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProfesionEmpleaOriginal(this.getEntityProfesionEmplea("",entity.getProfesionEmpleaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseProfesionEmpleas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProfesionEmplea(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ProfesionEmplea> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProfesionEmplea> entities = new  ArrayList<ProfesionEmplea>();
		ProfesionEmplea entity = new ProfesionEmplea();		  
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
	
	public  List<ProfesionEmplea> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProfesionEmplea> entities = new  ArrayList<ProfesionEmplea>();
		ProfesionEmplea entity = new ProfesionEmplea();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProfesionEmplea();
				
				if(conMapGenerico) {
					entity.inicializarMapProfesionEmplea();
					//entity.setMapProfesionEmplea(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapProfesionEmpleaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapProfesionEmplea().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProfesionEmpleaDataAccess.ISWITHSCHEMA);         		
					entity=ProfesionEmpleaDataAccess.getEntityProfesionEmplea("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setProfesionEmpleaOriginal( new ProfesionEmplea());
					////entity.setProfesionEmpleaOriginal(super.getEntity("",entity.getProfesionEmpleaOriginal(),resultSet,ProfesionEmpleaDataAccess.ISWITHSCHEMA));         		
					////entity.setProfesionEmpleaOriginal(this.getEntityProfesionEmplea("",entity.getProfesionEmpleaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseProfesionEmpleas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProfesionEmplea(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public ProfesionEmplea getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ProfesionEmplea entity = new ProfesionEmplea();		  
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
	
	public  ProfesionEmplea getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ProfesionEmplea entity = new ProfesionEmplea();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProfesionEmplea();
				
				if(conMapGenerico) {
					entity.inicializarMapProfesionEmplea();
					//entity.setMapProfesionEmplea(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapProfesionEmpleaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapProfesionEmplea().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProfesionEmpleaDataAccess.ISWITHSCHEMA);         		
					entity=ProfesionEmpleaDataAccess.getEntityProfesionEmplea("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setProfesionEmpleaOriginal( new ProfesionEmplea());
					////entity.setProfesionEmpleaOriginal(super.getEntity("",entity.getProfesionEmpleaOriginal(),resultSet,ProfesionEmpleaDataAccess.ISWITHSCHEMA));         		
					////entity.setProfesionEmpleaOriginal(this.getEntityProfesionEmplea("",entity.getProfesionEmpleaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseProfesionEmplea(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProfesionEmplea(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ProfesionEmplea getEntityProfesionEmplea(String strPrefijo,ProfesionEmplea entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = ProfesionEmplea.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = ProfesionEmplea.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ProfesionEmpleaDataAccess.setFieldReflectionProfesionEmplea(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasProfesionEmplea=ProfesionEmpleaConstantesFunciones.getTodosTiposColumnasProfesionEmplea();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasProfesionEmplea) {
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
							field = ProfesionEmplea.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = ProfesionEmplea.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ProfesionEmpleaDataAccess.setFieldReflectionProfesionEmplea(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionProfesionEmplea(Field field,String strPrefijo,String sColumn,ProfesionEmplea entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ProfesionEmpleaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProfesionEmpleaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProfesionEmpleaConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProfesionEmpleaConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProfesionEmpleaConstantesFunciones.IDPROFESION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ProfesionEmplea>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<ProfesionEmplea> entities = new  ArrayList<ProfesionEmplea>();
		ProfesionEmplea entity = new ProfesionEmplea();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ProfesionEmpleaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ProfesionEmpleaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProfesionEmpleaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new ProfesionEmplea();
					entity=super.getEntity("",entity,resultSet,ProfesionEmpleaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityProfesionEmplea("",entity,resultSet);
					
					//entity.setProfesionEmpleaOriginal( new ProfesionEmplea());
					//entity.setProfesionEmpleaOriginal(super.getEntity("",entity.getProfesionEmpleaOriginal(),resultSet,ProfesionEmpleaDataAccess.ISWITHSCHEMA));         		
					//entity.setProfesionEmpleaOriginal(this.getEntityProfesionEmplea("",entity.getProfesionEmpleaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseProfesionEmpleas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProfesionEmplea(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ProfesionEmplea>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<ProfesionEmplea> entities = new  ArrayList<ProfesionEmplea>();
		ProfesionEmplea entity = new ProfesionEmplea();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ProfesionEmpleaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ProfesionEmpleaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProfesionEmpleaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<ProfesionEmplea> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProfesionEmplea> entities = new  ArrayList<ProfesionEmplea>();
		ProfesionEmplea entity = new ProfesionEmplea();		  
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
	
	public  List<ProfesionEmplea> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProfesionEmplea> entities = new  ArrayList<ProfesionEmplea>();
		ProfesionEmplea entity = new ProfesionEmplea();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProfesionEmplea();
      	    	entity=super.getEntity("",entity,resultSet,ProfesionEmpleaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityProfesionEmplea("",entity,resultSet);
      	    	
				//entity.setProfesionEmpleaOriginal( new ProfesionEmplea());
      	    	//entity.setProfesionEmpleaOriginal(super.getEntity("",entity.getProfesionEmpleaOriginal(),resultSet,ProfesionEmpleaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProfesionEmpleaOriginal(this.getEntityProfesionEmplea("",entity.getProfesionEmpleaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseProfesionEmpleas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProfesionEmplea(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ProfesionEmplea> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProfesionEmplea> entities = new  ArrayList<ProfesionEmplea>();
		ProfesionEmplea entity = new ProfesionEmplea();		  
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
	
	public  List<ProfesionEmplea> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProfesionEmplea> entities = new  ArrayList<ProfesionEmplea>();
		ProfesionEmplea entity = new ProfesionEmplea();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProfesionEmplea();
      	    	entity=super.getEntity("",entity,resultSet,ProfesionEmpleaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityProfesionEmplea("",entity,resultSet);
      	    	
				//entity.setProfesionEmpleaOriginal( new ProfesionEmplea());
      	    	//entity.setProfesionEmpleaOriginal(super.getEntity("",entity.getProfesionEmpleaOriginal(),resultSet,ProfesionEmpleaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProfesionEmpleaOriginal(this.getEntityProfesionEmplea("",entity.getProfesionEmpleaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseProfesionEmpleas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public ProfesionEmplea getEntityProfesionEmplea(String strPrefijo,ProfesionEmplea entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+ProfesionEmpleaConstantesFunciones.IDEMPRESA));
				entity.setid_empleado(resultSet.getLong(strPrefijo+ProfesionEmpleaConstantesFunciones.IDEMPLEADO));
				entity.setid_profesion(resultSet.getLong(strPrefijo+ProfesionEmpleaConstantesFunciones.IDPROFESION));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowProfesionEmplea(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(ProfesionEmplea entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ProfesionEmpleaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ProfesionEmpleaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ProfesionEmpleaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ProfesionEmpleaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ProfesionEmpleaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ProfesionEmpleaDataAccess.TABLENAME,ProfesionEmpleaDataAccess.ISWITHSTOREPROCEDURES);
			
			ProfesionEmpleaDataAccess.setProfesionEmpleaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,ProfesionEmplea relprofesionemplea)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relprofesionemplea.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Empleado getEmpleado(Connexion connexion,ProfesionEmplea relprofesionemplea)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relprofesionemplea.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public Profesion getProfesion(Connexion connexion,ProfesionEmplea relprofesionemplea)throws SQLException,Exception {

		Profesion profesion= new Profesion();

		try {
			ProfesionDataAccess profesionDataAccess=new ProfesionDataAccess();

			profesionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			profesionDataAccess.setConnexionType(this.connexionType);
			profesionDataAccess.setParameterDbType(this.parameterDbType);

			profesion=profesionDataAccess.getEntity(connexion,relprofesionemplea.getid_profesion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return profesion;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,ProfesionEmplea profesionemplea) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!profesionemplea.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(profesionemplea.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(profesionemplea.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_profesion=new ParameterValue<Long>();
					parameterMaintenanceValueid_profesion.setValue(profesionemplea.getid_profesion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_profesion);
					parametersTemp.add(parameterMaintenance);
					
						if(!profesionemplea.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(profesionemplea.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(profesionemplea.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(profesionemplea.getId());
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
	
	public void setIsNewIsChangedFalseProfesionEmplea(ProfesionEmplea profesionemplea)throws Exception  {		
		profesionemplea.setIsNew(false);
		profesionemplea.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseProfesionEmpleas(List<ProfesionEmplea> profesionempleas)throws Exception  {				
		for(ProfesionEmplea profesionemplea:profesionempleas) {
			profesionemplea.setIsNew(false);
			profesionemplea.setIsChanged(false);
		}
	}
	
	public void generarExportarProfesionEmplea(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
