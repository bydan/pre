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
import com.bydan.erp.nomina.util.*;//EmpleadoEMailConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class EmpleadoEMailDataAccess extends  EmpleadoEMailDataAccessAdditional{ //EmpleadoEMailDataAccessAdditional,DataAccessHelper<EmpleadoEMail>
	//static Logger logger = Logger.getLogger(EmpleadoEMailDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="empleado_e_mail";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+EmpleadoEMailConstantesFunciones.SCHEMA+"."+EmpleadoEMailConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_empleado,e_mail,descripcion,esta_activo)values(current_timestamp,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+EmpleadoEMailConstantesFunciones.SCHEMA+"."+EmpleadoEMailConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_empleado=?,e_mail=?,descripcion=?,esta_activo=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+EmpleadoEMailConstantesFunciones.SCHEMA+"."+EmpleadoEMailConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select empleadoemail from "+EmpleadoEMailConstantesFunciones.SPERSISTENCENAME+" empleadoemail";
	public static String QUERYSELECTNATIVE="select "+EmpleadoEMailConstantesFunciones.SCHEMA+"."+EmpleadoEMailConstantesFunciones.TABLENAME+".id,"+EmpleadoEMailConstantesFunciones.SCHEMA+"."+EmpleadoEMailConstantesFunciones.TABLENAME+".version_row,"+EmpleadoEMailConstantesFunciones.SCHEMA+"."+EmpleadoEMailConstantesFunciones.TABLENAME+".id_empresa,"+EmpleadoEMailConstantesFunciones.SCHEMA+"."+EmpleadoEMailConstantesFunciones.TABLENAME+".id_empleado,"+EmpleadoEMailConstantesFunciones.SCHEMA+"."+EmpleadoEMailConstantesFunciones.TABLENAME+".e_mail,"+EmpleadoEMailConstantesFunciones.SCHEMA+"."+EmpleadoEMailConstantesFunciones.TABLENAME+".descripcion,"+EmpleadoEMailConstantesFunciones.SCHEMA+"."+EmpleadoEMailConstantesFunciones.TABLENAME+".esta_activo from "+EmpleadoEMailConstantesFunciones.SCHEMA+"."+EmpleadoEMailConstantesFunciones.TABLENAME;//+" as "+EmpleadoEMailConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+EmpleadoEMailConstantesFunciones.SCHEMA+"."+EmpleadoEMailConstantesFunciones.TABLENAME+".id,"+EmpleadoEMailConstantesFunciones.SCHEMA+"."+EmpleadoEMailConstantesFunciones.TABLENAME+".version_row,"+EmpleadoEMailConstantesFunciones.SCHEMA+"."+EmpleadoEMailConstantesFunciones.TABLENAME+".e_mail from "+EmpleadoEMailConstantesFunciones.SCHEMA+"."+EmpleadoEMailConstantesFunciones.TABLENAME;//+" as "+EmpleadoEMailConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+EmpleadoEMailConstantesFunciones.SCHEMA+"."+EmpleadoEMailConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_empleado=?,e_mail=?,descripcion=?,esta_activo=?";
	
	public static String STOREPROCEDUREINSERT="call SP_EMPLEADOEMAIL_INSERT(?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_EMPLEADOEMAIL_UPDATE(?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_EMPLEADOEMAIL_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_EMPLEADOEMAIL_SELECT(?,?)";
	
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
	
	
	protected EmpleadoEMailDataAccessAdditional empleadoemailDataAccessAdditional=null;
	
	public EmpleadoEMailDataAccessAdditional getEmpleadoEMailDataAccessAdditional() {
		return this.empleadoemailDataAccessAdditional;
	}
	
	public void setEmpleadoEMailDataAccessAdditional(EmpleadoEMailDataAccessAdditional empleadoemailDataAccessAdditional) {
		try {
			this.empleadoemailDataAccessAdditional=empleadoemailDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public EmpleadoEMailDataAccess() {
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
		EmpleadoEMailDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		EmpleadoEMailDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		EmpleadoEMailDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setEmpleadoEMailOriginal(EmpleadoEMail empleadoemail)throws Exception  {
		empleadoemail.setEmpleadoEMailOriginal((EmpleadoEMail)empleadoemail.clone());		
	}
	
	public void setEmpleadoEMailsOriginal(List<EmpleadoEMail> empleadoemails)throws Exception  {
		
		for(EmpleadoEMail empleadoemail:empleadoemails){
			empleadoemail.setEmpleadoEMailOriginal((EmpleadoEMail)empleadoemail.clone());
		}
	}
	
	public static void setEmpleadoEMailOriginalStatic(EmpleadoEMail empleadoemail)throws Exception  {
		empleadoemail.setEmpleadoEMailOriginal((EmpleadoEMail)empleadoemail.clone());		
	}
	
	public static void setEmpleadoEMailsOriginalStatic(List<EmpleadoEMail> empleadoemails)throws Exception  {
		
		for(EmpleadoEMail empleadoemail:empleadoemails){
			empleadoemail.setEmpleadoEMailOriginal((EmpleadoEMail)empleadoemail.clone());
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
	
	public  EmpleadoEMail getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		EmpleadoEMail entity = new EmpleadoEMail();		
		
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
	
	public  EmpleadoEMail getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		EmpleadoEMail entity = new EmpleadoEMail();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EmpleadoEMailDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EmpleadoEMailDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.EmpleadoEMail.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setEmpleadoEMailOriginal(new EmpleadoEMail());
      	    	entity=super.getEntity("",entity,resultSet,EmpleadoEMailDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEmpleadoEMail("",entity,resultSet); 
				
				//entity.setEmpleadoEMailOriginal(super.getEntity("",entity.getEmpleadoEMailOriginal(),resultSet,EmpleadoEMailDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmpleadoEMailOriginal(this.getEntityEmpleadoEMail("",entity.getEmpleadoEMailOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseEmpleadoEMail(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  EmpleadoEMail getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EmpleadoEMail entity = new EmpleadoEMail();
				
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
	
	public  EmpleadoEMail getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EmpleadoEMail entity = new EmpleadoEMail();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EmpleadoEMailDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EmpleadoEMailDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmpleadoEMailDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.EmpleadoEMail.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setEmpleadoEMailOriginal(new EmpleadoEMail());
      	    	entity=super.getEntity("",entity,resultSet,EmpleadoEMailDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEmpleadoEMail("",entity,resultSet);    
				
				//entity.setEmpleadoEMailOriginal(super.getEntity("",entity.getEmpleadoEMailOriginal(),resultSet,EmpleadoEMailDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmpleadoEMailOriginal(this.getEntityEmpleadoEMail("",entity.getEmpleadoEMailOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseEmpleadoEMail(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //EmpleadoEMail
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		EmpleadoEMail entity = new EmpleadoEMail();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EmpleadoEMailDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EmpleadoEMailDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmpleadoEMailDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.EmpleadoEMail.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseEmpleadoEMail(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<EmpleadoEMail> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EmpleadoEMail> entities = new  ArrayList<EmpleadoEMail>();
		EmpleadoEMail entity = new EmpleadoEMail();		  
		
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
	
	public  List<EmpleadoEMail> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EmpleadoEMail> entities = new  ArrayList<EmpleadoEMail>();
		EmpleadoEMail entity = new EmpleadoEMail();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=EmpleadoEMailDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EmpleadoEMailDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmpleadoEMailDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EmpleadoEMail();
      	    	entity=super.getEntity("",entity,resultSet,EmpleadoEMailDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEmpleadoEMail("",entity,resultSet);
      	    	
				//entity.setEmpleadoEMailOriginal( new EmpleadoEMail());
      	    	//entity.setEmpleadoEMailOriginal(super.getEntity("",entity.getEmpleadoEMailOriginal(),resultSet,EmpleadoEMailDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmpleadoEMailOriginal(this.getEntityEmpleadoEMail("",entity.getEmpleadoEMailOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEmpleadoEMails(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmpleadoEMail(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<EmpleadoEMail> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EmpleadoEMail> entities = new  ArrayList<EmpleadoEMail>();
		EmpleadoEMail entity = new EmpleadoEMail();		  
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
	
	public  List<EmpleadoEMail> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EmpleadoEMail> entities = new  ArrayList<EmpleadoEMail>();
		EmpleadoEMail entity = new EmpleadoEMail();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EmpleadoEMail();
				
				if(conMapGenerico) {
					entity.inicializarMapEmpleadoEMail();
					//entity.setMapEmpleadoEMail(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapEmpleadoEMailValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEmpleadoEMail().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EmpleadoEMailDataAccess.ISWITHSCHEMA);         		
					entity=EmpleadoEMailDataAccess.getEntityEmpleadoEMail("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEmpleadoEMailOriginal( new EmpleadoEMail());
					////entity.setEmpleadoEMailOriginal(super.getEntity("",entity.getEmpleadoEMailOriginal(),resultSet,EmpleadoEMailDataAccess.ISWITHSCHEMA));         		
					////entity.setEmpleadoEMailOriginal(this.getEntityEmpleadoEMail("",entity.getEmpleadoEMailOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEmpleadoEMails(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmpleadoEMail(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public EmpleadoEMail getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EmpleadoEMail entity = new EmpleadoEMail();		  
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
	
	public  EmpleadoEMail getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EmpleadoEMail entity = new EmpleadoEMail();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EmpleadoEMail();
				
				if(conMapGenerico) {
					entity.inicializarMapEmpleadoEMail();
					//entity.setMapEmpleadoEMail(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapEmpleadoEMailValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEmpleadoEMail().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EmpleadoEMailDataAccess.ISWITHSCHEMA);         		
					entity=EmpleadoEMailDataAccess.getEntityEmpleadoEMail("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEmpleadoEMailOriginal( new EmpleadoEMail());
					////entity.setEmpleadoEMailOriginal(super.getEntity("",entity.getEmpleadoEMailOriginal(),resultSet,EmpleadoEMailDataAccess.ISWITHSCHEMA));         		
					////entity.setEmpleadoEMailOriginal(this.getEntityEmpleadoEMail("",entity.getEmpleadoEMailOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseEmpleadoEMail(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmpleadoEMail(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static EmpleadoEMail getEntityEmpleadoEMail(String strPrefijo,EmpleadoEMail entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = EmpleadoEMail.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = EmpleadoEMail.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					EmpleadoEMailDataAccess.setFieldReflectionEmpleadoEMail(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasEmpleadoEMail=EmpleadoEMailConstantesFunciones.getTodosTiposColumnasEmpleadoEMail();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasEmpleadoEMail) {
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
							field = EmpleadoEMail.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = EmpleadoEMail.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						EmpleadoEMailDataAccess.setFieldReflectionEmpleadoEMail(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionEmpleadoEMail(Field field,String strPrefijo,String sColumn,EmpleadoEMail entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case EmpleadoEMailConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmpleadoEMailConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EmpleadoEMailConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmpleadoEMailConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmpleadoEMailConstantesFunciones.EMAIL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EmpleadoEMailConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EmpleadoEMailConstantesFunciones.ESTAACTIVO:
					field.set(entity,resultSet.getBoolean(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EmpleadoEMail>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<EmpleadoEMail> entities = new  ArrayList<EmpleadoEMail>();
		EmpleadoEMail entity = new EmpleadoEMail();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EmpleadoEMailDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EmpleadoEMailDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmpleadoEMailDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new EmpleadoEMail();
					entity=super.getEntity("",entity,resultSet,EmpleadoEMailDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityEmpleadoEMail("",entity,resultSet);
					
					//entity.setEmpleadoEMailOriginal( new EmpleadoEMail());
					//entity.setEmpleadoEMailOriginal(super.getEntity("",entity.getEmpleadoEMailOriginal(),resultSet,EmpleadoEMailDataAccess.ISWITHSCHEMA));         		
					//entity.setEmpleadoEMailOriginal(this.getEntityEmpleadoEMail("",entity.getEmpleadoEMailOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseEmpleadoEMails(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmpleadoEMail(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EmpleadoEMail>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<EmpleadoEMail> entities = new  ArrayList<EmpleadoEMail>();
		EmpleadoEMail entity = new EmpleadoEMail();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EmpleadoEMailDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EmpleadoEMailDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmpleadoEMailDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<EmpleadoEMail> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EmpleadoEMail> entities = new  ArrayList<EmpleadoEMail>();
		EmpleadoEMail entity = new EmpleadoEMail();		  
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
	
	public  List<EmpleadoEMail> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EmpleadoEMail> entities = new  ArrayList<EmpleadoEMail>();
		EmpleadoEMail entity = new EmpleadoEMail();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EmpleadoEMail();
      	    	entity=super.getEntity("",entity,resultSet,EmpleadoEMailDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEmpleadoEMail("",entity,resultSet);
      	    	
				//entity.setEmpleadoEMailOriginal( new EmpleadoEMail());
      	    	//entity.setEmpleadoEMailOriginal(super.getEntity("",entity.getEmpleadoEMailOriginal(),resultSet,EmpleadoEMailDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmpleadoEMailOriginal(this.getEntityEmpleadoEMail("",entity.getEmpleadoEMailOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseEmpleadoEMails(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmpleadoEMail(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<EmpleadoEMail> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EmpleadoEMail> entities = new  ArrayList<EmpleadoEMail>();
		EmpleadoEMail entity = new EmpleadoEMail();		  
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
	
	public  List<EmpleadoEMail> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EmpleadoEMail> entities = new  ArrayList<EmpleadoEMail>();
		EmpleadoEMail entity = new EmpleadoEMail();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EmpleadoEMail();
      	    	entity=super.getEntity("",entity,resultSet,EmpleadoEMailDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEmpleadoEMail("",entity,resultSet);
      	    	
				//entity.setEmpleadoEMailOriginal( new EmpleadoEMail());
      	    	//entity.setEmpleadoEMailOriginal(super.getEntity("",entity.getEmpleadoEMailOriginal(),resultSet,EmpleadoEMailDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmpleadoEMailOriginal(this.getEntityEmpleadoEMail("",entity.getEmpleadoEMailOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEmpleadoEMails(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public EmpleadoEMail getEntityEmpleadoEMail(String strPrefijo,EmpleadoEMail entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+EmpleadoEMailConstantesFunciones.IDEMPRESA));
				entity.setid_empleado(resultSet.getLong(strPrefijo+EmpleadoEMailConstantesFunciones.IDEMPLEADO));
				entity.sete_mail(resultSet.getString(strPrefijo+EmpleadoEMailConstantesFunciones.EMAIL));
				entity.setdescripcion(resultSet.getString(strPrefijo+EmpleadoEMailConstantesFunciones.DESCRIPCION));
				entity.setesta_activo(resultSet.getBoolean(strPrefijo+EmpleadoEMailConstantesFunciones.ESTAACTIVO));
			} else {
				entity.sete_mail(resultSet.getString(strPrefijo+EmpleadoEMailConstantesFunciones.EMAIL));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowEmpleadoEMail(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(EmpleadoEMail entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=EmpleadoEMailDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=EmpleadoEMailDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=EmpleadoEMailDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=EmpleadoEMailDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(EmpleadoEMailConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,EmpleadoEMailDataAccess.TABLENAME,EmpleadoEMailDataAccess.ISWITHSTOREPROCEDURES);
			
			EmpleadoEMailDataAccess.setEmpleadoEMailOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,EmpleadoEMail relempleadoemail)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relempleadoemail.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Empleado getEmpleado(Connexion connexion,EmpleadoEMail relempleadoemail)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relempleadoemail.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,EmpleadoEMail empleadoemail) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!empleadoemail.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(empleadoemail.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(empleadoemail.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuee_mail=new ParameterValue<String>();
					parameterMaintenanceValuee_mail.setValue(empleadoemail.gete_mail());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuee_mail);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(empleadoemail.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValueesta_activo=new ParameterValue<Boolean>();
					parameterMaintenanceValueesta_activo.setValue(empleadoemail.getesta_activo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueesta_activo);
					parametersTemp.add(parameterMaintenance);
					
						if(!empleadoemail.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(empleadoemail.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(empleadoemail.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(empleadoemail.getId());
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
	
	public void setIsNewIsChangedFalseEmpleadoEMail(EmpleadoEMail empleadoemail)throws Exception  {		
		empleadoemail.setIsNew(false);
		empleadoemail.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseEmpleadoEMails(List<EmpleadoEMail> empleadoemails)throws Exception  {				
		for(EmpleadoEMail empleadoemail:empleadoemails) {
			empleadoemail.setIsNew(false);
			empleadoemail.setIsChanged(false);
		}
	}
	
	public void generarExportarEmpleadoEMail(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
