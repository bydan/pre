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
package com.bydan.erp.seguridad.business.dataaccess;

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

import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.seguridad.util.*;//EmpresaConstantesFunciones;










@SuppressWarnings("unused")
final public class EmpresaDataAccess extends  EmpresaDataAccessAdditional{ //EmpresaDataAccessAdditional,DataAccessHelper<Empresa>
	//static Logger logger = Logger.getLogger(EmpresaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="empresa";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+EmpresaConstantesFunciones.SCHEMA+"."+EmpresaConstantesFunciones.TABLENAME+"(version_row,id_pais,id_ciudad,id_tipo_empresa,nombre,direccion,ruc,mail,telefono,fax,codigo_postal,iva,actividad_principal,actividad_secundaria,contador_nombre,contador_ruc,contador_licencia,representante_nombre,representante_cedula)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+EmpresaConstantesFunciones.SCHEMA+"."+EmpresaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_pais=?,id_ciudad=?,id_tipo_empresa=?,nombre=?,direccion=?,ruc=?,mail=?,telefono=?,fax=?,codigo_postal=?,iva=?,actividad_principal=?,actividad_secundaria=?,contador_nombre=?,contador_ruc=?,contador_licencia=?,representante_nombre=?,representante_cedula=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+EmpresaConstantesFunciones.SCHEMA+"."+EmpresaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select empresa from "+EmpresaConstantesFunciones.SPERSISTENCENAME+" empresa";
	public static String QUERYSELECTNATIVE="select "+EmpresaConstantesFunciones.SCHEMA+"."+EmpresaConstantesFunciones.TABLENAME+".id,"+EmpresaConstantesFunciones.SCHEMA+"."+EmpresaConstantesFunciones.TABLENAME+".version_row,"+EmpresaConstantesFunciones.SCHEMA+"."+EmpresaConstantesFunciones.TABLENAME+".id_pais,"+EmpresaConstantesFunciones.SCHEMA+"."+EmpresaConstantesFunciones.TABLENAME+".id_ciudad,"+EmpresaConstantesFunciones.SCHEMA+"."+EmpresaConstantesFunciones.TABLENAME+".id_tipo_empresa,"+EmpresaConstantesFunciones.SCHEMA+"."+EmpresaConstantesFunciones.TABLENAME+".nombre,"+EmpresaConstantesFunciones.SCHEMA+"."+EmpresaConstantesFunciones.TABLENAME+".direccion,"+EmpresaConstantesFunciones.SCHEMA+"."+EmpresaConstantesFunciones.TABLENAME+".ruc,"+EmpresaConstantesFunciones.SCHEMA+"."+EmpresaConstantesFunciones.TABLENAME+".mail,"+EmpresaConstantesFunciones.SCHEMA+"."+EmpresaConstantesFunciones.TABLENAME+".telefono,"+EmpresaConstantesFunciones.SCHEMA+"."+EmpresaConstantesFunciones.TABLENAME+".fax,"+EmpresaConstantesFunciones.SCHEMA+"."+EmpresaConstantesFunciones.TABLENAME+".codigo_postal,"+EmpresaConstantesFunciones.SCHEMA+"."+EmpresaConstantesFunciones.TABLENAME+".iva,"+EmpresaConstantesFunciones.SCHEMA+"."+EmpresaConstantesFunciones.TABLENAME+".actividad_principal,"+EmpresaConstantesFunciones.SCHEMA+"."+EmpresaConstantesFunciones.TABLENAME+".actividad_secundaria,"+EmpresaConstantesFunciones.SCHEMA+"."+EmpresaConstantesFunciones.TABLENAME+".contador_nombre,"+EmpresaConstantesFunciones.SCHEMA+"."+EmpresaConstantesFunciones.TABLENAME+".contador_ruc,"+EmpresaConstantesFunciones.SCHEMA+"."+EmpresaConstantesFunciones.TABLENAME+".contador_licencia,"+EmpresaConstantesFunciones.SCHEMA+"."+EmpresaConstantesFunciones.TABLENAME+".representante_nombre,"+EmpresaConstantesFunciones.SCHEMA+"."+EmpresaConstantesFunciones.TABLENAME+".representante_cedula from "+EmpresaConstantesFunciones.SCHEMA+"."+EmpresaConstantesFunciones.TABLENAME;//+" as "+EmpresaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+EmpresaConstantesFunciones.SCHEMA+"."+EmpresaConstantesFunciones.TABLENAME+".id,"+EmpresaConstantesFunciones.SCHEMA+"."+EmpresaConstantesFunciones.TABLENAME+".version_row,"+EmpresaConstantesFunciones.SCHEMA+"."+EmpresaConstantesFunciones.TABLENAME+".nombre from "+EmpresaConstantesFunciones.SCHEMA+"."+EmpresaConstantesFunciones.TABLENAME;//+" as "+EmpresaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+EmpresaConstantesFunciones.SCHEMA+"."+EmpresaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_pais=?,id_ciudad=?,id_tipo_empresa=?,nombre=?,direccion=?,ruc=?,mail=?,telefono=?,fax=?,codigo_postal=?,iva=?,actividad_principal=?,actividad_secundaria=?,contador_nombre=?,contador_ruc=?,contador_licencia=?,representante_nombre=?,representante_cedula=?";
	
	public static String STOREPROCEDUREINSERT="call SP_EMPRESA_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_EMPRESA_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_EMPRESA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_EMPRESA_SELECT(?,?)";
	
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
	
	
	protected EmpresaDataAccessAdditional empresaDataAccessAdditional=null;
	
	public EmpresaDataAccessAdditional getEmpresaDataAccessAdditional() {
		return this.empresaDataAccessAdditional;
	}
	
	public void setEmpresaDataAccessAdditional(EmpresaDataAccessAdditional empresaDataAccessAdditional) {
		try {
			this.empresaDataAccessAdditional=empresaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public EmpresaDataAccess() {
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
		EmpresaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		EmpresaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		EmpresaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setEmpresaOriginal(Empresa empresa)throws Exception  {
		empresa.setEmpresaOriginal((Empresa)empresa.clone());		
	}
	
	public void setEmpresasOriginal(List<Empresa> empresas)throws Exception  {
		
		for(Empresa empresa:empresas){
			empresa.setEmpresaOriginal((Empresa)empresa.clone());
		}
	}
	
	public static void setEmpresaOriginalStatic(Empresa empresa)throws Exception  {
		empresa.setEmpresaOriginal((Empresa)empresa.clone());		
	}
	
	public static void setEmpresasOriginalStatic(List<Empresa> empresas)throws Exception  {
		
		for(Empresa empresa:empresas){
			empresa.setEmpresaOriginal((Empresa)empresa.clone());
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
	
	public  Empresa getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		Empresa entity = new Empresa();		
		
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
	
	public  Empresa getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		Empresa entity = new Empresa();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EmpresaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EmpresaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Seguridad.Empresa.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setEmpresaOriginal(new Empresa());
      	    	entity=super.getEntity("",entity,resultSet,EmpresaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEmpresa("",entity,resultSet); 
				
				//entity.setEmpresaOriginal(super.getEntity("",entity.getEmpresaOriginal(),resultSet,EmpresaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmpresaOriginal(this.getEntityEmpresa("",entity.getEmpresaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseEmpresa(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  Empresa getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Empresa entity = new Empresa();
				
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
	
	public  Empresa getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Empresa entity = new Empresa();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EmpresaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EmpresaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmpresaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Seguridad.Empresa.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setEmpresaOriginal(new Empresa());
      	    	entity=super.getEntity("",entity,resultSet,EmpresaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEmpresa("",entity,resultSet);    
				
				//entity.setEmpresaOriginal(super.getEntity("",entity.getEmpresaOriginal(),resultSet,EmpresaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmpresaOriginal(this.getEntityEmpresa("",entity.getEmpresaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseEmpresa(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //Empresa
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		Empresa entity = new Empresa();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EmpresaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EmpresaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmpresaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Seguridad.Empresa.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseEmpresa(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<Empresa> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Empresa> entities = new  ArrayList<Empresa>();
		Empresa entity = new Empresa();		  
		
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
	
	public  List<Empresa> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Empresa> entities = new  ArrayList<Empresa>();
		Empresa entity = new Empresa();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=EmpresaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EmpresaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmpresaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Empresa();
      	    	entity=super.getEntity("",entity,resultSet,EmpresaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEmpresa("",entity,resultSet);
      	    	
				//entity.setEmpresaOriginal( new Empresa());
      	    	//entity.setEmpresaOriginal(super.getEntity("",entity.getEmpresaOriginal(),resultSet,EmpresaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmpresaOriginal(this.getEntityEmpresa("",entity.getEmpresaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEmpresas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmpresa(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Empresa> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Empresa> entities = new  ArrayList<Empresa>();
		Empresa entity = new Empresa();		  
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
	
	public  List<Empresa> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Empresa> entities = new  ArrayList<Empresa>();
		Empresa entity = new Empresa();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Empresa();
				
				if(conMapGenerico) {
					entity.inicializarMapEmpresa();
					//entity.setMapEmpresa(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapEmpresaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEmpresa().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EmpresaDataAccess.ISWITHSCHEMA);         		
					entity=EmpresaDataAccess.getEntityEmpresa("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEmpresaOriginal( new Empresa());
					////entity.setEmpresaOriginal(super.getEntity("",entity.getEmpresaOriginal(),resultSet,EmpresaDataAccess.ISWITHSCHEMA));         		
					////entity.setEmpresaOriginal(this.getEntityEmpresa("",entity.getEmpresaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEmpresas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmpresa(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public Empresa getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Empresa entity = new Empresa();		  
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
	
	public  Empresa getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Empresa entity = new Empresa();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Empresa();
				
				if(conMapGenerico) {
					entity.inicializarMapEmpresa();
					//entity.setMapEmpresa(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapEmpresaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEmpresa().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EmpresaDataAccess.ISWITHSCHEMA);         		
					entity=EmpresaDataAccess.getEntityEmpresa("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEmpresaOriginal( new Empresa());
					////entity.setEmpresaOriginal(super.getEntity("",entity.getEmpresaOriginal(),resultSet,EmpresaDataAccess.ISWITHSCHEMA));         		
					////entity.setEmpresaOriginal(this.getEntityEmpresa("",entity.getEmpresaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseEmpresa(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmpresa(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static Empresa getEntityEmpresa(String strPrefijo,Empresa entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = Empresa.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = Empresa.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					EmpresaDataAccess.setFieldReflectionEmpresa(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasEmpresa=EmpresaConstantesFunciones.getTodosTiposColumnasEmpresa();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasEmpresa) {
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
							field = Empresa.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = Empresa.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						EmpresaDataAccess.setFieldReflectionEmpresa(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionEmpresa(Field field,String strPrefijo,String sColumn,Empresa entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case EmpresaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmpresaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EmpresaConstantesFunciones.IDPAIS:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmpresaConstantesFunciones.IDCIUDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmpresaConstantesFunciones.IDTIPOEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmpresaConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EmpresaConstantesFunciones.DIRECCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EmpresaConstantesFunciones.RUC:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EmpresaConstantesFunciones.MAIL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EmpresaConstantesFunciones.TELEFONO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EmpresaConstantesFunciones.FAX:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EmpresaConstantesFunciones.CODIGOPOSTAL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EmpresaConstantesFunciones.IVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case EmpresaConstantesFunciones.ACTIVIDADPRINCIPAL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EmpresaConstantesFunciones.ACTIVIDADSECUNDARIA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EmpresaConstantesFunciones.CONTADORNOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EmpresaConstantesFunciones.CONTADORRUC:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EmpresaConstantesFunciones.CONTADORLICENCIA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EmpresaConstantesFunciones.REPRESENTANTENOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EmpresaConstantesFunciones.REPRESENTANTECEDULA:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Empresa>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<Empresa> entities = new  ArrayList<Empresa>();
		Empresa entity = new Empresa();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EmpresaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EmpresaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmpresaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new Empresa();
					entity=super.getEntity("",entity,resultSet,EmpresaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityEmpresa("",entity,resultSet);
					
					//entity.setEmpresaOriginal( new Empresa());
					//entity.setEmpresaOriginal(super.getEntity("",entity.getEmpresaOriginal(),resultSet,EmpresaDataAccess.ISWITHSCHEMA));         		
					//entity.setEmpresaOriginal(this.getEntityEmpresa("",entity.getEmpresaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseEmpresas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmpresa(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Empresa>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<Empresa> entities = new  ArrayList<Empresa>();
		Empresa entity = new Empresa();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EmpresaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EmpresaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmpresaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<Empresa> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Empresa> entities = new  ArrayList<Empresa>();
		Empresa entity = new Empresa();		  
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
	
	public  List<Empresa> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Empresa> entities = new  ArrayList<Empresa>();
		Empresa entity = new Empresa();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Empresa();
      	    	entity=super.getEntity("",entity,resultSet,EmpresaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEmpresa("",entity,resultSet);
      	    	
				//entity.setEmpresaOriginal( new Empresa());
      	    	//entity.setEmpresaOriginal(super.getEntity("",entity.getEmpresaOriginal(),resultSet,EmpresaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmpresaOriginal(this.getEntityEmpresa("",entity.getEmpresaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseEmpresas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmpresa(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Empresa> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Empresa> entities = new  ArrayList<Empresa>();
		Empresa entity = new Empresa();		  
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
	
	public  List<Empresa> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Empresa> entities = new  ArrayList<Empresa>();
		Empresa entity = new Empresa();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Empresa();
      	    	entity=super.getEntity("",entity,resultSet,EmpresaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEmpresa("",entity,resultSet);
      	    	
				//entity.setEmpresaOriginal( new Empresa());
      	    	//entity.setEmpresaOriginal(super.getEntity("",entity.getEmpresaOriginal(),resultSet,EmpresaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmpresaOriginal(this.getEntityEmpresa("",entity.getEmpresaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEmpresas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public Empresa getEntityEmpresa(String strPrefijo,Empresa entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_pais(resultSet.getLong(strPrefijo+EmpresaConstantesFunciones.IDPAIS));
				entity.setid_ciudad(resultSet.getLong(strPrefijo+EmpresaConstantesFunciones.IDCIUDAD));
				entity.setid_tipo_empresa(resultSet.getLong(strPrefijo+EmpresaConstantesFunciones.IDTIPOEMPRESA));
				entity.setnombre(resultSet.getString(strPrefijo+EmpresaConstantesFunciones.NOMBRE));
				entity.setdireccion(resultSet.getString(strPrefijo+EmpresaConstantesFunciones.DIRECCION));
				entity.setruc(resultSet.getString(strPrefijo+EmpresaConstantesFunciones.RUC));
				entity.setmail(resultSet.getString(strPrefijo+EmpresaConstantesFunciones.MAIL));
				entity.settelefono(resultSet.getString(strPrefijo+EmpresaConstantesFunciones.TELEFONO));
				entity.setfax(resultSet.getString(strPrefijo+EmpresaConstantesFunciones.FAX));
				entity.setcodigo_postal(resultSet.getString(strPrefijo+EmpresaConstantesFunciones.CODIGOPOSTAL));
				entity.setiva(resultSet.getDouble(strPrefijo+EmpresaConstantesFunciones.IVA));
				entity.setactividad_principal(resultSet.getString(strPrefijo+EmpresaConstantesFunciones.ACTIVIDADPRINCIPAL));
				entity.setactividad_secundaria(resultSet.getString(strPrefijo+EmpresaConstantesFunciones.ACTIVIDADSECUNDARIA));
				entity.setcontador_nombre(resultSet.getString(strPrefijo+EmpresaConstantesFunciones.CONTADORNOMBRE));
				entity.setcontador_ruc(resultSet.getString(strPrefijo+EmpresaConstantesFunciones.CONTADORRUC));
				entity.setcontador_licencia(resultSet.getString(strPrefijo+EmpresaConstantesFunciones.CONTADORLICENCIA));
				entity.setrepresentante_nombre(resultSet.getString(strPrefijo+EmpresaConstantesFunciones.REPRESENTANTENOMBRE));
				entity.setrepresentante_cedula(resultSet.getString(strPrefijo+EmpresaConstantesFunciones.REPRESENTANTECEDULA));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+EmpresaConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowEmpresa(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(Empresa entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=EmpresaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=EmpresaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=EmpresaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=EmpresaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(EmpresaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,EmpresaDataAccess.TABLENAME,EmpresaDataAccess.ISWITHSTOREPROCEDURES);
			
			EmpresaDataAccess.setEmpresaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Pais getPais(Connexion connexion,Empresa relempresa)throws SQLException,Exception {

		Pais pais= new Pais();

		try {
			PaisDataAccess paisDataAccess=new PaisDataAccess();

			paisDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			paisDataAccess.setConnexionType(this.connexionType);
			paisDataAccess.setParameterDbType(this.parameterDbType);

			pais=paisDataAccess.getEntity(connexion,relempresa.getid_pais());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pais;

	}

	public Ciudad getCiudad(Connexion connexion,Empresa relempresa)throws SQLException,Exception {

		Ciudad ciudad= new Ciudad();

		try {
			CiudadDataAccess ciudadDataAccess=new CiudadDataAccess();

			ciudadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ciudadDataAccess.setConnexionType(this.connexionType);
			ciudadDataAccess.setParameterDbType(this.parameterDbType);

			ciudad=ciudadDataAccess.getEntity(connexion,relempresa.getid_ciudad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ciudad;

	}

	public TipoEmpresa getTipoEmpresa(Connexion connexion,Empresa relempresa)throws SQLException,Exception {

		TipoEmpresa tipoempresa= new TipoEmpresa();

		try {
			TipoEmpresaDataAccess tipoempresaDataAccess=new TipoEmpresaDataAccess();

			tipoempresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoempresaDataAccess.setConnexionType(this.connexionType);
			tipoempresaDataAccess.setParameterDbType(this.parameterDbType);

			tipoempresa=tipoempresaDataAccess.getEntity(connexion,relempresa.getid_tipo_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoempresa;

	}


		
		public List<Sucursal> getSucursals(Connexion connexion,Empresa empresa)throws SQLException,Exception {

		List<Sucursal> sucursals= new ArrayList<Sucursal>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EmpresaConstantesFunciones.SCHEMA+".empresa ON "+SucursalConstantesFunciones.SCHEMA+".sucursal.id_empresa="+EmpresaConstantesFunciones.SCHEMA+".empresa.id WHERE "+EmpresaConstantesFunciones.SCHEMA+".empresa.id="+String.valueOf(empresa.getId());
			} else {
				sQuery=" INNER JOIN sucursal.Empresa WHERE sucursal.Empresa.id="+String.valueOf(empresa.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);
			sucursals=sucursalDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursals;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,Empresa empresa) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!empresa.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_pais=new ParameterValue<Long>();
					parameterMaintenanceValueid_pais.setValue(empresa.getid_pais());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_pais);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ciudad=new ParameterValue<Long>();
					parameterMaintenanceValueid_ciudad.setValue(empresa.getid_ciudad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ciudad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_empresa.setValue(empresa.getid_tipo_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(empresa.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedireccion=new ParameterValue<String>();
					parameterMaintenanceValuedireccion.setValue(empresa.getdireccion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedireccion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueruc=new ParameterValue<String>();
					parameterMaintenanceValueruc.setValue(empresa.getruc());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueruc);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuemail=new ParameterValue<String>();
					parameterMaintenanceValuemail.setValue(empresa.getmail());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuemail);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuetelefono=new ParameterValue<String>();
					parameterMaintenanceValuetelefono.setValue(empresa.gettelefono());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetelefono);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuefax=new ParameterValue<String>();
					parameterMaintenanceValuefax.setValue(empresa.getfax());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefax);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo_postal=new ParameterValue<String>();
					parameterMaintenanceValuecodigo_postal.setValue(empresa.getcodigo_postal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo_postal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueiva=new ParameterValue<Double>();
					parameterMaintenanceValueiva.setValue(empresa.getiva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueiva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueactividad_principal=new ParameterValue<String>();
					parameterMaintenanceValueactividad_principal.setValue(empresa.getactividad_principal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueactividad_principal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueactividad_secundaria=new ParameterValue<String>();
					parameterMaintenanceValueactividad_secundaria.setValue(empresa.getactividad_secundaria());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueactividad_secundaria);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecontador_nombre=new ParameterValue<String>();
					parameterMaintenanceValuecontador_nombre.setValue(empresa.getcontador_nombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecontador_nombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecontador_ruc=new ParameterValue<String>();
					parameterMaintenanceValuecontador_ruc.setValue(empresa.getcontador_ruc());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecontador_ruc);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecontador_licencia=new ParameterValue<String>();
					parameterMaintenanceValuecontador_licencia.setValue(empresa.getcontador_licencia());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecontador_licencia);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuerepresentante_nombre=new ParameterValue<String>();
					parameterMaintenanceValuerepresentante_nombre.setValue(empresa.getrepresentante_nombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuerepresentante_nombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuerepresentante_cedula=new ParameterValue<String>();
					parameterMaintenanceValuerepresentante_cedula.setValue(empresa.getrepresentante_cedula());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuerepresentante_cedula);
					parametersTemp.add(parameterMaintenance);
					
						if(!empresa.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(empresa.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(empresa.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(empresa.getId());
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
	
	public void setIsNewIsChangedFalseEmpresa(Empresa empresa)throws Exception  {		
		empresa.setIsNew(false);
		empresa.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseEmpresas(List<Empresa> empresas)throws Exception  {				
		for(Empresa empresa:empresas) {
			empresa.setIsNew(false);
			empresa.setIsChanged(false);
		}
	}
	
	public void generarExportarEmpresa(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
