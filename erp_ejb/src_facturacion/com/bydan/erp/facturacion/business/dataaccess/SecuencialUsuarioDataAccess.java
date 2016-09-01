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
package com.bydan.erp.facturacion.business.dataaccess;

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

import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.facturacion.util.*;//SecuencialUsuarioConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class SecuencialUsuarioDataAccess extends  SecuencialUsuarioDataAccessAdditional{ //SecuencialUsuarioDataAccessAdditional,DataAccessHelper<SecuencialUsuario>
	//static Logger logger = Logger.getLogger(SecuencialUsuarioDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="secuencial_usuario";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+SecuencialUsuarioConstantesFunciones.SCHEMA+"."+SecuencialUsuarioConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_usuario,id_tipo_documento_general,serie,autorizacion,secuencial,digitos,fecha_inicio,fecha_fin,esta_activo)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+SecuencialUsuarioConstantesFunciones.SCHEMA+"."+SecuencialUsuarioConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_usuario=?,id_tipo_documento_general=?,serie=?,autorizacion=?,secuencial=?,digitos=?,fecha_inicio=?,fecha_fin=?,esta_activo=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+SecuencialUsuarioConstantesFunciones.SCHEMA+"."+SecuencialUsuarioConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select secuencialusuario from "+SecuencialUsuarioConstantesFunciones.SPERSISTENCENAME+" secuencialusuario";
	public static String QUERYSELECTNATIVE="select "+SecuencialUsuarioConstantesFunciones.SCHEMA+"."+SecuencialUsuarioConstantesFunciones.TABLENAME+".id,"+SecuencialUsuarioConstantesFunciones.SCHEMA+"."+SecuencialUsuarioConstantesFunciones.TABLENAME+".version_row,"+SecuencialUsuarioConstantesFunciones.SCHEMA+"."+SecuencialUsuarioConstantesFunciones.TABLENAME+".id_empresa,"+SecuencialUsuarioConstantesFunciones.SCHEMA+"."+SecuencialUsuarioConstantesFunciones.TABLENAME+".id_sucursal,"+SecuencialUsuarioConstantesFunciones.SCHEMA+"."+SecuencialUsuarioConstantesFunciones.TABLENAME+".id_usuario,"+SecuencialUsuarioConstantesFunciones.SCHEMA+"."+SecuencialUsuarioConstantesFunciones.TABLENAME+".id_tipo_documento_general,"+SecuencialUsuarioConstantesFunciones.SCHEMA+"."+SecuencialUsuarioConstantesFunciones.TABLENAME+".serie,"+SecuencialUsuarioConstantesFunciones.SCHEMA+"."+SecuencialUsuarioConstantesFunciones.TABLENAME+".autorizacion,"+SecuencialUsuarioConstantesFunciones.SCHEMA+"."+SecuencialUsuarioConstantesFunciones.TABLENAME+".secuencial,"+SecuencialUsuarioConstantesFunciones.SCHEMA+"."+SecuencialUsuarioConstantesFunciones.TABLENAME+".digitos,"+SecuencialUsuarioConstantesFunciones.SCHEMA+"."+SecuencialUsuarioConstantesFunciones.TABLENAME+".fecha_inicio,"+SecuencialUsuarioConstantesFunciones.SCHEMA+"."+SecuencialUsuarioConstantesFunciones.TABLENAME+".fecha_fin,"+SecuencialUsuarioConstantesFunciones.SCHEMA+"."+SecuencialUsuarioConstantesFunciones.TABLENAME+".esta_activo from "+SecuencialUsuarioConstantesFunciones.SCHEMA+"."+SecuencialUsuarioConstantesFunciones.TABLENAME;//+" as "+SecuencialUsuarioConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+SecuencialUsuarioConstantesFunciones.SCHEMA+"."+SecuencialUsuarioConstantesFunciones.TABLENAME+".id,"+SecuencialUsuarioConstantesFunciones.SCHEMA+"."+SecuencialUsuarioConstantesFunciones.TABLENAME+".version_row from "+SecuencialUsuarioConstantesFunciones.SCHEMA+"."+SecuencialUsuarioConstantesFunciones.TABLENAME;//+" as "+SecuencialUsuarioConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+SecuencialUsuarioConstantesFunciones.SCHEMA+"."+SecuencialUsuarioConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_usuario=?,id_tipo_documento_general=?,serie=?,autorizacion=?,secuencial=?,digitos=?,fecha_inicio=?,fecha_fin=?,esta_activo=?";
	
	public static String STOREPROCEDUREINSERT="call SP_SECUENCIALUSUARIO_INSERT(?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_SECUENCIALUSUARIO_UPDATE(?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_SECUENCIALUSUARIO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_SECUENCIALUSUARIO_SELECT(?,?)";
	
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
	
	
	protected SecuencialUsuarioDataAccessAdditional secuencialusuarioDataAccessAdditional=null;
	
	public SecuencialUsuarioDataAccessAdditional getSecuencialUsuarioDataAccessAdditional() {
		return this.secuencialusuarioDataAccessAdditional;
	}
	
	public void setSecuencialUsuarioDataAccessAdditional(SecuencialUsuarioDataAccessAdditional secuencialusuarioDataAccessAdditional) {
		try {
			this.secuencialusuarioDataAccessAdditional=secuencialusuarioDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public SecuencialUsuarioDataAccess() {
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
		SecuencialUsuarioDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		SecuencialUsuarioDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		SecuencialUsuarioDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setSecuencialUsuarioOriginal(SecuencialUsuario secuencialusuario)throws Exception  {
		secuencialusuario.setSecuencialUsuarioOriginal((SecuencialUsuario)secuencialusuario.clone());		
	}
	
	public void setSecuencialUsuariosOriginal(List<SecuencialUsuario> secuencialusuarios)throws Exception  {
		
		for(SecuencialUsuario secuencialusuario:secuencialusuarios){
			secuencialusuario.setSecuencialUsuarioOriginal((SecuencialUsuario)secuencialusuario.clone());
		}
	}
	
	public static void setSecuencialUsuarioOriginalStatic(SecuencialUsuario secuencialusuario)throws Exception  {
		secuencialusuario.setSecuencialUsuarioOriginal((SecuencialUsuario)secuencialusuario.clone());		
	}
	
	public static void setSecuencialUsuariosOriginalStatic(List<SecuencialUsuario> secuencialusuarios)throws Exception  {
		
		for(SecuencialUsuario secuencialusuario:secuencialusuarios){
			secuencialusuario.setSecuencialUsuarioOriginal((SecuencialUsuario)secuencialusuario.clone());
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
	
	public  SecuencialUsuario getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		SecuencialUsuario entity = new SecuencialUsuario();		
		
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
	
	public  SecuencialUsuario getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		SecuencialUsuario entity = new SecuencialUsuario();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=SecuencialUsuarioDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=SecuencialUsuarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Facturacion.SecuencialUsuario.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setSecuencialUsuarioOriginal(new SecuencialUsuario());
      	    	entity=super.getEntity("",entity,resultSet,SecuencialUsuarioDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntitySecuencialUsuario("",entity,resultSet); 
				
				//entity.setSecuencialUsuarioOriginal(super.getEntity("",entity.getSecuencialUsuarioOriginal(),resultSet,SecuencialUsuarioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setSecuencialUsuarioOriginal(this.getEntitySecuencialUsuario("",entity.getSecuencialUsuarioOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseSecuencialUsuario(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  SecuencialUsuario getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		SecuencialUsuario entity = new SecuencialUsuario();
				
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
	
	public  SecuencialUsuario getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		SecuencialUsuario entity = new SecuencialUsuario();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=SecuencialUsuarioDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=SecuencialUsuarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,SecuencialUsuarioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.SecuencialUsuario.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setSecuencialUsuarioOriginal(new SecuencialUsuario());
      	    	entity=super.getEntity("",entity,resultSet,SecuencialUsuarioDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntitySecuencialUsuario("",entity,resultSet);    
				
				//entity.setSecuencialUsuarioOriginal(super.getEntity("",entity.getSecuencialUsuarioOriginal(),resultSet,SecuencialUsuarioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setSecuencialUsuarioOriginal(this.getEntitySecuencialUsuario("",entity.getSecuencialUsuarioOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseSecuencialUsuario(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //SecuencialUsuario
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		SecuencialUsuario entity = new SecuencialUsuario();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=SecuencialUsuarioDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=SecuencialUsuarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,SecuencialUsuarioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.SecuencialUsuario.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseSecuencialUsuario(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<SecuencialUsuario> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<SecuencialUsuario> entities = new  ArrayList<SecuencialUsuario>();
		SecuencialUsuario entity = new SecuencialUsuario();		  
		
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
	
	public  List<SecuencialUsuario> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<SecuencialUsuario> entities = new  ArrayList<SecuencialUsuario>();
		SecuencialUsuario entity = new SecuencialUsuario();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=SecuencialUsuarioDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=SecuencialUsuarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,SecuencialUsuarioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new SecuencialUsuario();
      	    	entity=super.getEntity("",entity,resultSet,SecuencialUsuarioDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntitySecuencialUsuario("",entity,resultSet);
      	    	
				//entity.setSecuencialUsuarioOriginal( new SecuencialUsuario());
      	    	//entity.setSecuencialUsuarioOriginal(super.getEntity("",entity.getSecuencialUsuarioOriginal(),resultSet,SecuencialUsuarioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setSecuencialUsuarioOriginal(this.getEntitySecuencialUsuario("",entity.getSecuencialUsuarioOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseSecuencialUsuarios(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarSecuencialUsuario(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<SecuencialUsuario> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<SecuencialUsuario> entities = new  ArrayList<SecuencialUsuario>();
		SecuencialUsuario entity = new SecuencialUsuario();		  
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
	
	public  List<SecuencialUsuario> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<SecuencialUsuario> entities = new  ArrayList<SecuencialUsuario>();
		SecuencialUsuario entity = new SecuencialUsuario();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new SecuencialUsuario();
				
				if(conMapGenerico) {
					entity.inicializarMapSecuencialUsuario();
					//entity.setMapSecuencialUsuario(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapSecuencialUsuarioValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapSecuencialUsuario().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,SecuencialUsuarioDataAccess.ISWITHSCHEMA);         		
					entity=SecuencialUsuarioDataAccess.getEntitySecuencialUsuario("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setSecuencialUsuarioOriginal( new SecuencialUsuario());
					////entity.setSecuencialUsuarioOriginal(super.getEntity("",entity.getSecuencialUsuarioOriginal(),resultSet,SecuencialUsuarioDataAccess.ISWITHSCHEMA));         		
					////entity.setSecuencialUsuarioOriginal(this.getEntitySecuencialUsuario("",entity.getSecuencialUsuarioOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseSecuencialUsuarios(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarSecuencialUsuario(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public SecuencialUsuario getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		SecuencialUsuario entity = new SecuencialUsuario();		  
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
	
	public  SecuencialUsuario getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		SecuencialUsuario entity = new SecuencialUsuario();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new SecuencialUsuario();
				
				if(conMapGenerico) {
					entity.inicializarMapSecuencialUsuario();
					//entity.setMapSecuencialUsuario(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapSecuencialUsuarioValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapSecuencialUsuario().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,SecuencialUsuarioDataAccess.ISWITHSCHEMA);         		
					entity=SecuencialUsuarioDataAccess.getEntitySecuencialUsuario("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setSecuencialUsuarioOriginal( new SecuencialUsuario());
					////entity.setSecuencialUsuarioOriginal(super.getEntity("",entity.getSecuencialUsuarioOriginal(),resultSet,SecuencialUsuarioDataAccess.ISWITHSCHEMA));         		
					////entity.setSecuencialUsuarioOriginal(this.getEntitySecuencialUsuario("",entity.getSecuencialUsuarioOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseSecuencialUsuario(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarSecuencialUsuario(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static SecuencialUsuario getEntitySecuencialUsuario(String strPrefijo,SecuencialUsuario entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = SecuencialUsuario.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = SecuencialUsuario.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					SecuencialUsuarioDataAccess.setFieldReflectionSecuencialUsuario(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasSecuencialUsuario=SecuencialUsuarioConstantesFunciones.getTodosTiposColumnasSecuencialUsuario();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasSecuencialUsuario) {
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
							field = SecuencialUsuario.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = SecuencialUsuario.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						SecuencialUsuarioDataAccess.setFieldReflectionSecuencialUsuario(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionSecuencialUsuario(Field field,String strPrefijo,String sColumn,SecuencialUsuario entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case SecuencialUsuarioConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SecuencialUsuarioConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SecuencialUsuarioConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SecuencialUsuarioConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SecuencialUsuarioConstantesFunciones.IDUSUARIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SecuencialUsuarioConstantesFunciones.IDTIPODOCUMENTOGENERAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SecuencialUsuarioConstantesFunciones.SERIE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SecuencialUsuarioConstantesFunciones.AUTORIZACION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SecuencialUsuarioConstantesFunciones.SECUENCIAL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SecuencialUsuarioConstantesFunciones.DIGITOS:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case SecuencialUsuarioConstantesFunciones.FECHAINICIO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case SecuencialUsuarioConstantesFunciones.FECHAFIN:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case SecuencialUsuarioConstantesFunciones.ESTAACTIVO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<SecuencialUsuario>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<SecuencialUsuario> entities = new  ArrayList<SecuencialUsuario>();
		SecuencialUsuario entity = new SecuencialUsuario();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=SecuencialUsuarioDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=SecuencialUsuarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,SecuencialUsuarioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new SecuencialUsuario();
					entity=super.getEntity("",entity,resultSet,SecuencialUsuarioDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntitySecuencialUsuario("",entity,resultSet);
					
					//entity.setSecuencialUsuarioOriginal( new SecuencialUsuario());
					//entity.setSecuencialUsuarioOriginal(super.getEntity("",entity.getSecuencialUsuarioOriginal(),resultSet,SecuencialUsuarioDataAccess.ISWITHSCHEMA));         		
					//entity.setSecuencialUsuarioOriginal(this.getEntitySecuencialUsuario("",entity.getSecuencialUsuarioOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseSecuencialUsuarios(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarSecuencialUsuario(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<SecuencialUsuario>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<SecuencialUsuario> entities = new  ArrayList<SecuencialUsuario>();
		SecuencialUsuario entity = new SecuencialUsuario();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=SecuencialUsuarioDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=SecuencialUsuarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,SecuencialUsuarioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<SecuencialUsuario> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<SecuencialUsuario> entities = new  ArrayList<SecuencialUsuario>();
		SecuencialUsuario entity = new SecuencialUsuario();		  
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
	
	public  List<SecuencialUsuario> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<SecuencialUsuario> entities = new  ArrayList<SecuencialUsuario>();
		SecuencialUsuario entity = new SecuencialUsuario();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new SecuencialUsuario();
      	    	entity=super.getEntity("",entity,resultSet,SecuencialUsuarioDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntitySecuencialUsuario("",entity,resultSet);
      	    	
				//entity.setSecuencialUsuarioOriginal( new SecuencialUsuario());
      	    	//entity.setSecuencialUsuarioOriginal(super.getEntity("",entity.getSecuencialUsuarioOriginal(),resultSet,SecuencialUsuarioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setSecuencialUsuarioOriginal(this.getEntitySecuencialUsuario("",entity.getSecuencialUsuarioOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseSecuencialUsuarios(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarSecuencialUsuario(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<SecuencialUsuario> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<SecuencialUsuario> entities = new  ArrayList<SecuencialUsuario>();
		SecuencialUsuario entity = new SecuencialUsuario();		  
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
	
	public  List<SecuencialUsuario> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<SecuencialUsuario> entities = new  ArrayList<SecuencialUsuario>();
		SecuencialUsuario entity = new SecuencialUsuario();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new SecuencialUsuario();
      	    	entity=super.getEntity("",entity,resultSet,SecuencialUsuarioDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntitySecuencialUsuario("",entity,resultSet);
      	    	
				//entity.setSecuencialUsuarioOriginal( new SecuencialUsuario());
      	    	//entity.setSecuencialUsuarioOriginal(super.getEntity("",entity.getSecuencialUsuarioOriginal(),resultSet,SecuencialUsuarioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setSecuencialUsuarioOriginal(this.getEntitySecuencialUsuario("",entity.getSecuencialUsuarioOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseSecuencialUsuarios(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public SecuencialUsuario getEntitySecuencialUsuario(String strPrefijo,SecuencialUsuario entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+SecuencialUsuarioConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+SecuencialUsuarioConstantesFunciones.IDSUCURSAL));
				entity.setid_usuario(resultSet.getLong(strPrefijo+SecuencialUsuarioConstantesFunciones.IDUSUARIO));
				entity.setid_tipo_documento_general(resultSet.getLong(strPrefijo+SecuencialUsuarioConstantesFunciones.IDTIPODOCUMENTOGENERAL));
				entity.setserie(resultSet.getString(strPrefijo+SecuencialUsuarioConstantesFunciones.SERIE));
				entity.setautorizacion(resultSet.getString(strPrefijo+SecuencialUsuarioConstantesFunciones.AUTORIZACION));
				entity.setsecuencial(resultSet.getString(strPrefijo+SecuencialUsuarioConstantesFunciones.SECUENCIAL));
				entity.setdigitos(resultSet.getInt(strPrefijo+SecuencialUsuarioConstantesFunciones.DIGITOS));
				entity.setfecha_inicio(new Date(resultSet.getDate(strPrefijo+SecuencialUsuarioConstantesFunciones.FECHAINICIO).getTime()));
				entity.setfecha_fin(new Date(resultSet.getDate(strPrefijo+SecuencialUsuarioConstantesFunciones.FECHAFIN).getTime()));
				entity.setesta_activo(resultSet.getBoolean(strPrefijo+SecuencialUsuarioConstantesFunciones.ESTAACTIVO));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowSecuencialUsuario(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(SecuencialUsuario entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=SecuencialUsuarioDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=SecuencialUsuarioDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=SecuencialUsuarioDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=SecuencialUsuarioDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(SecuencialUsuarioConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,SecuencialUsuarioDataAccess.TABLENAME,SecuencialUsuarioDataAccess.ISWITHSTOREPROCEDURES);
			
			SecuencialUsuarioDataAccess.setSecuencialUsuarioOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,SecuencialUsuario relsecuencialusuario)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relsecuencialusuario.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,SecuencialUsuario relsecuencialusuario)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relsecuencialusuario.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Usuario getUsuario(Connexion connexion,SecuencialUsuario relsecuencialusuario)throws SQLException,Exception {

		Usuario usuario= new Usuario();

		try {
			UsuarioDataAccess usuarioDataAccess=new UsuarioDataAccess();

			usuarioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			usuarioDataAccess.setConnexionType(this.connexionType);
			usuarioDataAccess.setParameterDbType(this.parameterDbType);

			usuario=usuarioDataAccess.getEntity(connexion,relsecuencialusuario.getid_usuario());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return usuario;

	}

	public TipoDocumentoGeneral getTipoDocumentoGeneral(Connexion connexion,SecuencialUsuario relsecuencialusuario)throws SQLException,Exception {

		TipoDocumentoGeneral tipodocumentogeneral= new TipoDocumentoGeneral();

		try {
			TipoDocumentoGeneralDataAccess tipodocumentogeneralDataAccess=new TipoDocumentoGeneralDataAccess();

			tipodocumentogeneralDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipodocumentogeneralDataAccess.setConnexionType(this.connexionType);
			tipodocumentogeneralDataAccess.setParameterDbType(this.parameterDbType);

			tipodocumentogeneral=tipodocumentogeneralDataAccess.getEntity(connexion,relsecuencialusuario.getid_tipo_documento_general());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipodocumentogeneral;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,SecuencialUsuario secuencialusuario) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!secuencialusuario.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(secuencialusuario.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(secuencialusuario.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_usuario=new ParameterValue<Long>();
					parameterMaintenanceValueid_usuario.setValue(secuencialusuario.getid_usuario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_usuario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_documento_general=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_documento_general.setValue(secuencialusuario.getid_tipo_documento_general());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_documento_general);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueserie=new ParameterValue<String>();
					parameterMaintenanceValueserie.setValue(secuencialusuario.getserie());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueserie);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueautorizacion=new ParameterValue<String>();
					parameterMaintenanceValueautorizacion.setValue(secuencialusuario.getautorizacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueautorizacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuesecuencial=new ParameterValue<String>();
					parameterMaintenanceValuesecuencial.setValue(secuencialusuario.getsecuencial());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesecuencial);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuedigitos=new ParameterValue<Integer>();
					parameterMaintenanceValuedigitos.setValue(secuencialusuario.getdigitos());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedigitos);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_inicio=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_inicio.setValue(secuencialusuario.getfecha_inicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_inicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_fin=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_fin.setValue(secuencialusuario.getfecha_fin());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_fin);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValueesta_activo=new ParameterValue<Boolean>();
					parameterMaintenanceValueesta_activo.setValue(secuencialusuario.getesta_activo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueesta_activo);
					parametersTemp.add(parameterMaintenance);
					
						if(!secuencialusuario.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(secuencialusuario.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(secuencialusuario.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(secuencialusuario.getId());
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
	
	public void setIsNewIsChangedFalseSecuencialUsuario(SecuencialUsuario secuencialusuario)throws Exception  {		
		secuencialusuario.setIsNew(false);
		secuencialusuario.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseSecuencialUsuarios(List<SecuencialUsuario> secuencialusuarios)throws Exception  {				
		for(SecuencialUsuario secuencialusuario:secuencialusuarios) {
			secuencialusuario.setIsNew(false);
			secuencialusuario.setIsChanged(false);
		}
	}
	
	public void generarExportarSecuencialUsuario(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
