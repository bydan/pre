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
package com.bydan.erp.contabilidad.business.dataaccess;

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

import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.contabilidad.util.*;//EmpresaEspecialConstantesFunciones;










@SuppressWarnings("unused")
final public class EmpresaEspecialDataAccess extends  EmpresaEspecialDataAccessAdditional{ //EmpresaEspecialDataAccessAdditional,DataAccessHelper<EmpresaEspecial>
	//static Logger logger = Logger.getLogger(EmpresaEspecialDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="empresa_especial";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+EmpresaEspecialConstantesFunciones.SCHEMA+"."+EmpresaEspecialConstantesFunciones.TABLENAME+"(version_row,numero_resolucion,fecha_resolucion)values(current_timestamp,?,?)";
	public static String QUERYUPDATE="update "+EmpresaEspecialConstantesFunciones.SCHEMA+"."+EmpresaEspecialConstantesFunciones.TABLENAME+" set version_row=current_timestamp,numero_resolucion=?,fecha_resolucion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+EmpresaEspecialConstantesFunciones.SCHEMA+"."+EmpresaEspecialConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select empresaespecial from "+EmpresaEspecialConstantesFunciones.SPERSISTENCENAME+" empresaespecial";
	public static String QUERYSELECTNATIVE="select "+EmpresaEspecialConstantesFunciones.SCHEMA+"."+EmpresaEspecialConstantesFunciones.TABLENAME+".id,"+EmpresaEspecialConstantesFunciones.SCHEMA+"."+EmpresaEspecialConstantesFunciones.TABLENAME+".version_row,"+EmpresaEspecialConstantesFunciones.SCHEMA+"."+EmpresaEspecialConstantesFunciones.TABLENAME+".numero_resolucion,"+EmpresaEspecialConstantesFunciones.SCHEMA+"."+EmpresaEspecialConstantesFunciones.TABLENAME+".fecha_resolucion from "+EmpresaEspecialConstantesFunciones.SCHEMA+"."+EmpresaEspecialConstantesFunciones.TABLENAME;//+" as "+EmpresaEspecialConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+EmpresaEspecialConstantesFunciones.SCHEMA+"."+EmpresaEspecialConstantesFunciones.TABLENAME+".id,"+EmpresaEspecialConstantesFunciones.SCHEMA+"."+EmpresaEspecialConstantesFunciones.TABLENAME+".version_row,"+EmpresaEspecialConstantesFunciones.SCHEMA+"."+EmpresaEspecialConstantesFunciones.TABLENAME+".numero_resolucion from "+EmpresaEspecialConstantesFunciones.SCHEMA+"."+EmpresaEspecialConstantesFunciones.TABLENAME;//+" as "+EmpresaEspecialConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+EmpresaEspecialConstantesFunciones.SCHEMA+"."+EmpresaEspecialConstantesFunciones.TABLENAME+" set version_row=current_timestamp,numero_resolucion=?,fecha_resolucion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_EMPRESAESPECIAL_INSERT(?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_EMPRESAESPECIAL_UPDATE(?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_EMPRESAESPECIAL_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_EMPRESAESPECIAL_SELECT(?,?)";
	
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
	
	
	protected EmpresaEspecialDataAccessAdditional empresaespecialDataAccessAdditional=null;
	
	public EmpresaEspecialDataAccessAdditional getEmpresaEspecialDataAccessAdditional() {
		return this.empresaespecialDataAccessAdditional;
	}
	
	public void setEmpresaEspecialDataAccessAdditional(EmpresaEspecialDataAccessAdditional empresaespecialDataAccessAdditional) {
		try {
			this.empresaespecialDataAccessAdditional=empresaespecialDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public EmpresaEspecialDataAccess() {
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
		EmpresaEspecialDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		EmpresaEspecialDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		EmpresaEspecialDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setEmpresaEspecialOriginal(EmpresaEspecial empresaespecial)throws Exception  {
		empresaespecial.setEmpresaEspecialOriginal((EmpresaEspecial)empresaespecial.clone());		
	}
	
	public void setEmpresaEspecialsOriginal(List<EmpresaEspecial> empresaespecials)throws Exception  {
		
		for(EmpresaEspecial empresaespecial:empresaespecials){
			empresaespecial.setEmpresaEspecialOriginal((EmpresaEspecial)empresaespecial.clone());
		}
	}
	
	public static void setEmpresaEspecialOriginalStatic(EmpresaEspecial empresaespecial)throws Exception  {
		empresaespecial.setEmpresaEspecialOriginal((EmpresaEspecial)empresaespecial.clone());		
	}
	
	public static void setEmpresaEspecialsOriginalStatic(List<EmpresaEspecial> empresaespecials)throws Exception  {
		
		for(EmpresaEspecial empresaespecial:empresaespecials){
			empresaespecial.setEmpresaEspecialOriginal((EmpresaEspecial)empresaespecial.clone());
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
	
	public  EmpresaEspecial getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		EmpresaEspecial entity = new EmpresaEspecial();		
		
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
	
	public  EmpresaEspecial getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		EmpresaEspecial entity = new EmpresaEspecial();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EmpresaEspecialDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EmpresaEspecialDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Contabilidad.EmpresaEspecial.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setEmpresaEspecialOriginal(new EmpresaEspecial());
      	    	entity=super.getEntity("",entity,resultSet,EmpresaEspecialDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEmpresaEspecial("",entity,resultSet); 
				
				//entity.setEmpresaEspecialOriginal(super.getEntity("",entity.getEmpresaEspecialOriginal(),resultSet,EmpresaEspecialDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmpresaEspecialOriginal(this.getEntityEmpresaEspecial("",entity.getEmpresaEspecialOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseEmpresaEspecial(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  EmpresaEspecial getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EmpresaEspecial entity = new EmpresaEspecial();
				
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
	
	public  EmpresaEspecial getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EmpresaEspecial entity = new EmpresaEspecial();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EmpresaEspecialDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EmpresaEspecialDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmpresaEspecialDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.EmpresaEspecial.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setEmpresaEspecialOriginal(new EmpresaEspecial());
      	    	entity=super.getEntity("",entity,resultSet,EmpresaEspecialDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEmpresaEspecial("",entity,resultSet);    
				
				//entity.setEmpresaEspecialOriginal(super.getEntity("",entity.getEmpresaEspecialOriginal(),resultSet,EmpresaEspecialDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmpresaEspecialOriginal(this.getEntityEmpresaEspecial("",entity.getEmpresaEspecialOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseEmpresaEspecial(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //EmpresaEspecial
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		EmpresaEspecial entity = new EmpresaEspecial();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EmpresaEspecialDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EmpresaEspecialDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmpresaEspecialDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.EmpresaEspecial.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseEmpresaEspecial(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<EmpresaEspecial> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EmpresaEspecial> entities = new  ArrayList<EmpresaEspecial>();
		EmpresaEspecial entity = new EmpresaEspecial();		  
		
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
	
	public  List<EmpresaEspecial> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EmpresaEspecial> entities = new  ArrayList<EmpresaEspecial>();
		EmpresaEspecial entity = new EmpresaEspecial();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=EmpresaEspecialDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EmpresaEspecialDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmpresaEspecialDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EmpresaEspecial();
      	    	entity=super.getEntity("",entity,resultSet,EmpresaEspecialDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEmpresaEspecial("",entity,resultSet);
      	    	
				//entity.setEmpresaEspecialOriginal( new EmpresaEspecial());
      	    	//entity.setEmpresaEspecialOriginal(super.getEntity("",entity.getEmpresaEspecialOriginal(),resultSet,EmpresaEspecialDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmpresaEspecialOriginal(this.getEntityEmpresaEspecial("",entity.getEmpresaEspecialOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEmpresaEspecials(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmpresaEspecial(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<EmpresaEspecial> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EmpresaEspecial> entities = new  ArrayList<EmpresaEspecial>();
		EmpresaEspecial entity = new EmpresaEspecial();		  
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
	
	public  List<EmpresaEspecial> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EmpresaEspecial> entities = new  ArrayList<EmpresaEspecial>();
		EmpresaEspecial entity = new EmpresaEspecial();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EmpresaEspecial();
				
				if(conMapGenerico) {
					entity.inicializarMapEmpresaEspecial();
					//entity.setMapEmpresaEspecial(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapEmpresaEspecialValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEmpresaEspecial().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EmpresaEspecialDataAccess.ISWITHSCHEMA);         		
					entity=EmpresaEspecialDataAccess.getEntityEmpresaEspecial("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEmpresaEspecialOriginal( new EmpresaEspecial());
					////entity.setEmpresaEspecialOriginal(super.getEntity("",entity.getEmpresaEspecialOriginal(),resultSet,EmpresaEspecialDataAccess.ISWITHSCHEMA));         		
					////entity.setEmpresaEspecialOriginal(this.getEntityEmpresaEspecial("",entity.getEmpresaEspecialOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEmpresaEspecials(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmpresaEspecial(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public EmpresaEspecial getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EmpresaEspecial entity = new EmpresaEspecial();		  
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
	
	public  EmpresaEspecial getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EmpresaEspecial entity = new EmpresaEspecial();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EmpresaEspecial();
				
				if(conMapGenerico) {
					entity.inicializarMapEmpresaEspecial();
					//entity.setMapEmpresaEspecial(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapEmpresaEspecialValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEmpresaEspecial().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EmpresaEspecialDataAccess.ISWITHSCHEMA);         		
					entity=EmpresaEspecialDataAccess.getEntityEmpresaEspecial("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEmpresaEspecialOriginal( new EmpresaEspecial());
					////entity.setEmpresaEspecialOriginal(super.getEntity("",entity.getEmpresaEspecialOriginal(),resultSet,EmpresaEspecialDataAccess.ISWITHSCHEMA));         		
					////entity.setEmpresaEspecialOriginal(this.getEntityEmpresaEspecial("",entity.getEmpresaEspecialOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseEmpresaEspecial(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmpresaEspecial(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static EmpresaEspecial getEntityEmpresaEspecial(String strPrefijo,EmpresaEspecial entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = EmpresaEspecial.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = EmpresaEspecial.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					EmpresaEspecialDataAccess.setFieldReflectionEmpresaEspecial(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasEmpresaEspecial=EmpresaEspecialConstantesFunciones.getTodosTiposColumnasEmpresaEspecial();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasEmpresaEspecial) {
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
							field = EmpresaEspecial.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = EmpresaEspecial.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						EmpresaEspecialDataAccess.setFieldReflectionEmpresaEspecial(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionEmpresaEspecial(Field field,String strPrefijo,String sColumn,EmpresaEspecial entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case EmpresaEspecialConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmpresaEspecialConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EmpresaEspecialConstantesFunciones.NUMERORESOLUCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EmpresaEspecialConstantesFunciones.FECHARESOLUCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EmpresaEspecial>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<EmpresaEspecial> entities = new  ArrayList<EmpresaEspecial>();
		EmpresaEspecial entity = new EmpresaEspecial();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EmpresaEspecialDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EmpresaEspecialDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmpresaEspecialDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new EmpresaEspecial();
					entity=super.getEntity("",entity,resultSet,EmpresaEspecialDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityEmpresaEspecial("",entity,resultSet);
					
					//entity.setEmpresaEspecialOriginal( new EmpresaEspecial());
					//entity.setEmpresaEspecialOriginal(super.getEntity("",entity.getEmpresaEspecialOriginal(),resultSet,EmpresaEspecialDataAccess.ISWITHSCHEMA));         		
					//entity.setEmpresaEspecialOriginal(this.getEntityEmpresaEspecial("",entity.getEmpresaEspecialOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseEmpresaEspecials(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmpresaEspecial(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EmpresaEspecial>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<EmpresaEspecial> entities = new  ArrayList<EmpresaEspecial>();
		EmpresaEspecial entity = new EmpresaEspecial();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EmpresaEspecialDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EmpresaEspecialDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmpresaEspecialDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<EmpresaEspecial> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EmpresaEspecial> entities = new  ArrayList<EmpresaEspecial>();
		EmpresaEspecial entity = new EmpresaEspecial();		  
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
	
	public  List<EmpresaEspecial> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EmpresaEspecial> entities = new  ArrayList<EmpresaEspecial>();
		EmpresaEspecial entity = new EmpresaEspecial();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EmpresaEspecial();
      	    	entity=super.getEntity("",entity,resultSet,EmpresaEspecialDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEmpresaEspecial("",entity,resultSet);
      	    	
				//entity.setEmpresaEspecialOriginal( new EmpresaEspecial());
      	    	//entity.setEmpresaEspecialOriginal(super.getEntity("",entity.getEmpresaEspecialOriginal(),resultSet,EmpresaEspecialDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmpresaEspecialOriginal(this.getEntityEmpresaEspecial("",entity.getEmpresaEspecialOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseEmpresaEspecials(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmpresaEspecial(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<EmpresaEspecial> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EmpresaEspecial> entities = new  ArrayList<EmpresaEspecial>();
		EmpresaEspecial entity = new EmpresaEspecial();		  
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
	
	public  List<EmpresaEspecial> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EmpresaEspecial> entities = new  ArrayList<EmpresaEspecial>();
		EmpresaEspecial entity = new EmpresaEspecial();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EmpresaEspecial();
      	    	entity=super.getEntity("",entity,resultSet,EmpresaEspecialDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEmpresaEspecial("",entity,resultSet);
      	    	
				//entity.setEmpresaEspecialOriginal( new EmpresaEspecial());
      	    	//entity.setEmpresaEspecialOriginal(super.getEntity("",entity.getEmpresaEspecialOriginal(),resultSet,EmpresaEspecialDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmpresaEspecialOriginal(this.getEntityEmpresaEspecial("",entity.getEmpresaEspecialOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEmpresaEspecials(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public EmpresaEspecial getEntityEmpresaEspecial(String strPrefijo,EmpresaEspecial entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setnumero_resolucion(resultSet.getString(strPrefijo+EmpresaEspecialConstantesFunciones.NUMERORESOLUCION));
				entity.setfecha_resolucion(new Date(resultSet.getDate(strPrefijo+EmpresaEspecialConstantesFunciones.FECHARESOLUCION).getTime()));
			} else {
				entity.setnumero_resolucion(resultSet.getString(strPrefijo+EmpresaEspecialConstantesFunciones.NUMERORESOLUCION));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowEmpresaEspecial(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(EmpresaEspecial entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=EmpresaEspecialDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=EmpresaEspecialDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=EmpresaEspecialDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=EmpresaEspecialDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(EmpresaEspecialConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,EmpresaEspecialDataAccess.TABLENAME,EmpresaEspecialDataAccess.ISWITHSTOREPROCEDURES);
			
			EmpresaEspecialDataAccess.setEmpresaEspecialOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
	
		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,EmpresaEspecial empresaespecial) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!empresaespecial.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_resolucion=new ParameterValue<String>();
					parameterMaintenanceValuenumero_resolucion.setValue(empresaespecial.getnumero_resolucion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_resolucion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_resolucion=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_resolucion.setValue(empresaespecial.getfecha_resolucion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_resolucion);
					parametersTemp.add(parameterMaintenance);
					
						if(!empresaespecial.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(empresaespecial.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(empresaespecial.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(empresaespecial.getId());
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
	
	public void setIsNewIsChangedFalseEmpresaEspecial(EmpresaEspecial empresaespecial)throws Exception  {		
		empresaespecial.setIsNew(false);
		empresaespecial.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseEmpresaEspecials(List<EmpresaEspecial> empresaespecials)throws Exception  {				
		for(EmpresaEspecial empresaespecial:empresaespecials) {
			empresaespecial.setIsNew(false);
			empresaespecial.setIsChanged(false);
		}
	}
	
	public void generarExportarEmpresaEspecial(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
