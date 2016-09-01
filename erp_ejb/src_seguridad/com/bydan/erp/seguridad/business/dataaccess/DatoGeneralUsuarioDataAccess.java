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
import com.bydan.framework.erp.business.dataaccess.DataAccessHelperSinIdGenerated;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.seguridad.util.*;//DatoGeneralUsuarioConstantesFunciones;










@SuppressWarnings("unused")
final public class DatoGeneralUsuarioDataAccess extends  DatoGeneralUsuarioDataAccessAdditional{ //DatoGeneralUsuarioDataAccessAdditional,DataAccessHelper<DatoGeneralUsuario>
	//static Logger logger = Logger.getLogger(DatoGeneralUsuarioDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="dato_general_usuario";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+DatoGeneralUsuarioConstantesFunciones.SCHEMA+"."+DatoGeneralUsuarioConstantesFunciones.TABLENAME+"(id,version_row,id_pais,id_provincia,id_ciudad,cedula,apellidos,nombres,telefono,telefono_movil,e_mail,url,fecha_nacimiento,direccion)values(?,current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+DatoGeneralUsuarioConstantesFunciones.SCHEMA+"."+DatoGeneralUsuarioConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,id_pais=?,id_provincia=?,id_ciudad=?,cedula=?,apellidos=?,nombres=?,telefono=?,telefono_movil=?,e_mail=?,url=?,fecha_nacimiento=?,direccion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+DatoGeneralUsuarioConstantesFunciones.SCHEMA+"."+DatoGeneralUsuarioConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select datogeneralusuario from "+DatoGeneralUsuarioConstantesFunciones.SPERSISTENCENAME+" datogeneralusuario";
	public static String QUERYSELECTNATIVE="select "+DatoGeneralUsuarioConstantesFunciones.SCHEMA+"."+DatoGeneralUsuarioConstantesFunciones.TABLENAME+".id,"+DatoGeneralUsuarioConstantesFunciones.SCHEMA+"."+DatoGeneralUsuarioConstantesFunciones.TABLENAME+".version_row,"+DatoGeneralUsuarioConstantesFunciones.SCHEMA+"."+DatoGeneralUsuarioConstantesFunciones.TABLENAME+".id_pais,"+DatoGeneralUsuarioConstantesFunciones.SCHEMA+"."+DatoGeneralUsuarioConstantesFunciones.TABLENAME+".id_provincia,"+DatoGeneralUsuarioConstantesFunciones.SCHEMA+"."+DatoGeneralUsuarioConstantesFunciones.TABLENAME+".id_ciudad,"+DatoGeneralUsuarioConstantesFunciones.SCHEMA+"."+DatoGeneralUsuarioConstantesFunciones.TABLENAME+".cedula,"+DatoGeneralUsuarioConstantesFunciones.SCHEMA+"."+DatoGeneralUsuarioConstantesFunciones.TABLENAME+".apellidos,"+DatoGeneralUsuarioConstantesFunciones.SCHEMA+"."+DatoGeneralUsuarioConstantesFunciones.TABLENAME+".nombres,"+DatoGeneralUsuarioConstantesFunciones.SCHEMA+"."+DatoGeneralUsuarioConstantesFunciones.TABLENAME+".telefono,"+DatoGeneralUsuarioConstantesFunciones.SCHEMA+"."+DatoGeneralUsuarioConstantesFunciones.TABLENAME+".telefono_movil,"+DatoGeneralUsuarioConstantesFunciones.SCHEMA+"."+DatoGeneralUsuarioConstantesFunciones.TABLENAME+".e_mail,"+DatoGeneralUsuarioConstantesFunciones.SCHEMA+"."+DatoGeneralUsuarioConstantesFunciones.TABLENAME+".url,"+DatoGeneralUsuarioConstantesFunciones.SCHEMA+"."+DatoGeneralUsuarioConstantesFunciones.TABLENAME+".fecha_nacimiento,"+DatoGeneralUsuarioConstantesFunciones.SCHEMA+"."+DatoGeneralUsuarioConstantesFunciones.TABLENAME+".direccion from "+DatoGeneralUsuarioConstantesFunciones.SCHEMA+"."+DatoGeneralUsuarioConstantesFunciones.TABLENAME;//+" as "+DatoGeneralUsuarioConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+DatoGeneralUsuarioConstantesFunciones.SCHEMA+"."+DatoGeneralUsuarioConstantesFunciones.TABLENAME+".id,"+DatoGeneralUsuarioConstantesFunciones.SCHEMA+"."+DatoGeneralUsuarioConstantesFunciones.TABLENAME+".version_row from "+DatoGeneralUsuarioConstantesFunciones.SCHEMA+"."+DatoGeneralUsuarioConstantesFunciones.TABLENAME;//+" as "+DatoGeneralUsuarioConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+DatoGeneralUsuarioConstantesFunciones.SCHEMA+"."+DatoGeneralUsuarioConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,id_pais=?,id_provincia=?,id_ciudad=?,cedula=?,apellidos=?,nombres=?,telefono=?,telefono_movil=?,e_mail=?,url=?,fecha_nacimiento=?,direccion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_DATOGENERALUSUARIO_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_DATOGENERALUSUARIO_UPDATE(?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_DATOGENERALUSUARIO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_DATOGENERALUSUARIO_SELECT(?,?)";
	
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
	
	
	protected DatoGeneralUsuarioDataAccessAdditional datogeneralusuarioDataAccessAdditional=null;
	
	public DatoGeneralUsuarioDataAccessAdditional getDatoGeneralUsuarioDataAccessAdditional() {
		return this.datogeneralusuarioDataAccessAdditional;
	}
	
	public void setDatoGeneralUsuarioDataAccessAdditional(DatoGeneralUsuarioDataAccessAdditional datogeneralusuarioDataAccessAdditional) {
		try {
			this.datogeneralusuarioDataAccessAdditional=datogeneralusuarioDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public DatoGeneralUsuarioDataAccess() {
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
		DatoGeneralUsuarioDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		DatoGeneralUsuarioDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		DatoGeneralUsuarioDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setDatoGeneralUsuarioOriginal(DatoGeneralUsuario datogeneralusuario)throws Exception  {
		datogeneralusuario.setDatoGeneralUsuarioOriginal((DatoGeneralUsuario)datogeneralusuario.clone());		
	}
	
	public void setDatoGeneralUsuariosOriginal(List<DatoGeneralUsuario> datogeneralusuarios)throws Exception  {
		
		for(DatoGeneralUsuario datogeneralusuario:datogeneralusuarios){
			datogeneralusuario.setDatoGeneralUsuarioOriginal((DatoGeneralUsuario)datogeneralusuario.clone());
		}
	}
	
	public static void setDatoGeneralUsuarioOriginalStatic(DatoGeneralUsuario datogeneralusuario)throws Exception  {
		datogeneralusuario.setDatoGeneralUsuarioOriginal((DatoGeneralUsuario)datogeneralusuario.clone());		
	}
	
	public static void setDatoGeneralUsuariosOriginalStatic(List<DatoGeneralUsuario> datogeneralusuarios)throws Exception  {
		
		for(DatoGeneralUsuario datogeneralusuario:datogeneralusuarios){
			datogeneralusuario.setDatoGeneralUsuarioOriginal((DatoGeneralUsuario)datogeneralusuario.clone());
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
	
	public  DatoGeneralUsuario getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		DatoGeneralUsuario entity = new DatoGeneralUsuario();		
		
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
	
	public  DatoGeneralUsuario getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		DatoGeneralUsuario entity = new DatoGeneralUsuario();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DatoGeneralUsuarioDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DatoGeneralUsuarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Seguridad.DatoGeneralUsuario.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setDatoGeneralUsuarioOriginal(new DatoGeneralUsuario());
      	    	entity=super.getEntity("",entity,resultSet,DatoGeneralUsuarioDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDatoGeneralUsuario("",entity,resultSet); 
				
				//entity.setDatoGeneralUsuarioOriginal(super.getEntity("",entity.getDatoGeneralUsuarioOriginal(),resultSet,DatoGeneralUsuarioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDatoGeneralUsuarioOriginal(this.getEntityDatoGeneralUsuario("",entity.getDatoGeneralUsuarioOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseDatoGeneralUsuario(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  DatoGeneralUsuario getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DatoGeneralUsuario entity = new DatoGeneralUsuario();
				
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
	
	public  DatoGeneralUsuario getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DatoGeneralUsuario entity = new DatoGeneralUsuario();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DatoGeneralUsuarioDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DatoGeneralUsuarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,DatoGeneralUsuarioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Seguridad.DatoGeneralUsuario.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setDatoGeneralUsuarioOriginal(new DatoGeneralUsuario());
      	    	entity=super.getEntity("",entity,resultSet,DatoGeneralUsuarioDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDatoGeneralUsuario("",entity,resultSet);    
				
				//entity.setDatoGeneralUsuarioOriginal(super.getEntity("",entity.getDatoGeneralUsuarioOriginal(),resultSet,DatoGeneralUsuarioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDatoGeneralUsuarioOriginal(this.getEntityDatoGeneralUsuario("",entity.getDatoGeneralUsuarioOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseDatoGeneralUsuario(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //DatoGeneralUsuario
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		DatoGeneralUsuario entity = new DatoGeneralUsuario();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DatoGeneralUsuarioDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DatoGeneralUsuarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,DatoGeneralUsuarioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Seguridad.DatoGeneralUsuario.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseDatoGeneralUsuario(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<DatoGeneralUsuario> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DatoGeneralUsuario> entities = new  ArrayList<DatoGeneralUsuario>();
		DatoGeneralUsuario entity = new DatoGeneralUsuario();		  
		
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
	
	public  List<DatoGeneralUsuario> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DatoGeneralUsuario> entities = new  ArrayList<DatoGeneralUsuario>();
		DatoGeneralUsuario entity = new DatoGeneralUsuario();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=DatoGeneralUsuarioDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DatoGeneralUsuarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,DatoGeneralUsuarioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DatoGeneralUsuario();
      	    	entity=super.getEntity("",entity,resultSet,DatoGeneralUsuarioDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDatoGeneralUsuario("",entity,resultSet);
      	    	
				//entity.setDatoGeneralUsuarioOriginal( new DatoGeneralUsuario());
      	    	//entity.setDatoGeneralUsuarioOriginal(super.getEntity("",entity.getDatoGeneralUsuarioOriginal(),resultSet,DatoGeneralUsuarioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDatoGeneralUsuarioOriginal(this.getEntityDatoGeneralUsuario("",entity.getDatoGeneralUsuarioOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDatoGeneralUsuarios(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDatoGeneralUsuario(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DatoGeneralUsuario> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DatoGeneralUsuario> entities = new  ArrayList<DatoGeneralUsuario>();
		DatoGeneralUsuario entity = new DatoGeneralUsuario();		  
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
	
	public  List<DatoGeneralUsuario> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DatoGeneralUsuario> entities = new  ArrayList<DatoGeneralUsuario>();
		DatoGeneralUsuario entity = new DatoGeneralUsuario();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DatoGeneralUsuario();
				
				if(conMapGenerico) {
					entity.inicializarMapDatoGeneralUsuario();
					//entity.setMapDatoGeneralUsuario(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapDatoGeneralUsuarioValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDatoGeneralUsuario().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DatoGeneralUsuarioDataAccess.ISWITHSCHEMA);         		
					entity=DatoGeneralUsuarioDataAccess.getEntityDatoGeneralUsuario("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDatoGeneralUsuarioOriginal( new DatoGeneralUsuario());
					////entity.setDatoGeneralUsuarioOriginal(super.getEntity("",entity.getDatoGeneralUsuarioOriginal(),resultSet,DatoGeneralUsuarioDataAccess.ISWITHSCHEMA));         		
					////entity.setDatoGeneralUsuarioOriginal(this.getEntityDatoGeneralUsuario("",entity.getDatoGeneralUsuarioOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDatoGeneralUsuarios(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDatoGeneralUsuario(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public DatoGeneralUsuario getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DatoGeneralUsuario entity = new DatoGeneralUsuario();		  
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
	
	public  DatoGeneralUsuario getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DatoGeneralUsuario entity = new DatoGeneralUsuario();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DatoGeneralUsuario();
				
				if(conMapGenerico) {
					entity.inicializarMapDatoGeneralUsuario();
					//entity.setMapDatoGeneralUsuario(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapDatoGeneralUsuarioValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDatoGeneralUsuario().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DatoGeneralUsuarioDataAccess.ISWITHSCHEMA);         		
					entity=DatoGeneralUsuarioDataAccess.getEntityDatoGeneralUsuario("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDatoGeneralUsuarioOriginal( new DatoGeneralUsuario());
					////entity.setDatoGeneralUsuarioOriginal(super.getEntity("",entity.getDatoGeneralUsuarioOriginal(),resultSet,DatoGeneralUsuarioDataAccess.ISWITHSCHEMA));         		
					////entity.setDatoGeneralUsuarioOriginal(this.getEntityDatoGeneralUsuario("",entity.getDatoGeneralUsuarioOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseDatoGeneralUsuario(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDatoGeneralUsuario(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static DatoGeneralUsuario getEntityDatoGeneralUsuario(String strPrefijo,DatoGeneralUsuario entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = DatoGeneralUsuario.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = DatoGeneralUsuario.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					DatoGeneralUsuarioDataAccess.setFieldReflectionDatoGeneralUsuario(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasDatoGeneralUsuario=DatoGeneralUsuarioConstantesFunciones.getTodosTiposColumnasDatoGeneralUsuario();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasDatoGeneralUsuario) {
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
							field = DatoGeneralUsuario.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = DatoGeneralUsuario.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						DatoGeneralUsuarioDataAccess.setFieldReflectionDatoGeneralUsuario(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionDatoGeneralUsuario(Field field,String strPrefijo,String sColumn,DatoGeneralUsuario entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case DatoGeneralUsuarioConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DatoGeneralUsuarioConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DatoGeneralUsuarioConstantesFunciones.IDPAIS:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DatoGeneralUsuarioConstantesFunciones.IDPROVINCIA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DatoGeneralUsuarioConstantesFunciones.IDCIUDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DatoGeneralUsuarioConstantesFunciones.CEDULA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DatoGeneralUsuarioConstantesFunciones.APELLIDOS:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DatoGeneralUsuarioConstantesFunciones.NOMBRES:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DatoGeneralUsuarioConstantesFunciones.TELEFONO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DatoGeneralUsuarioConstantesFunciones.TELEFONOMOVIL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DatoGeneralUsuarioConstantesFunciones.EMAIL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DatoGeneralUsuarioConstantesFunciones.URL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DatoGeneralUsuarioConstantesFunciones.FECHANACIMIENTO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case DatoGeneralUsuarioConstantesFunciones.DIRECCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DatoGeneralUsuario>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<DatoGeneralUsuario> entities = new  ArrayList<DatoGeneralUsuario>();
		DatoGeneralUsuario entity = new DatoGeneralUsuario();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DatoGeneralUsuarioDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DatoGeneralUsuarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,DatoGeneralUsuarioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new DatoGeneralUsuario();
					entity=super.getEntity("",entity,resultSet,DatoGeneralUsuarioDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityDatoGeneralUsuario("",entity,resultSet);
					
					//entity.setDatoGeneralUsuarioOriginal( new DatoGeneralUsuario());
					//entity.setDatoGeneralUsuarioOriginal(super.getEntity("",entity.getDatoGeneralUsuarioOriginal(),resultSet,DatoGeneralUsuarioDataAccess.ISWITHSCHEMA));         		
					//entity.setDatoGeneralUsuarioOriginal(this.getEntityDatoGeneralUsuario("",entity.getDatoGeneralUsuarioOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseDatoGeneralUsuarios(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDatoGeneralUsuario(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DatoGeneralUsuario>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<DatoGeneralUsuario> entities = new  ArrayList<DatoGeneralUsuario>();
		DatoGeneralUsuario entity = new DatoGeneralUsuario();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DatoGeneralUsuarioDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DatoGeneralUsuarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,DatoGeneralUsuarioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<DatoGeneralUsuario> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DatoGeneralUsuario> entities = new  ArrayList<DatoGeneralUsuario>();
		DatoGeneralUsuario entity = new DatoGeneralUsuario();		  
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
	
	public  List<DatoGeneralUsuario> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DatoGeneralUsuario> entities = new  ArrayList<DatoGeneralUsuario>();
		DatoGeneralUsuario entity = new DatoGeneralUsuario();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DatoGeneralUsuario();
      	    	entity=super.getEntity("",entity,resultSet,DatoGeneralUsuarioDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDatoGeneralUsuario("",entity,resultSet);
      	    	
				//entity.setDatoGeneralUsuarioOriginal( new DatoGeneralUsuario());
      	    	//entity.setDatoGeneralUsuarioOriginal(super.getEntity("",entity.getDatoGeneralUsuarioOriginal(),resultSet,DatoGeneralUsuarioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDatoGeneralUsuarioOriginal(this.getEntityDatoGeneralUsuario("",entity.getDatoGeneralUsuarioOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseDatoGeneralUsuarios(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDatoGeneralUsuario(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DatoGeneralUsuario> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DatoGeneralUsuario> entities = new  ArrayList<DatoGeneralUsuario>();
		DatoGeneralUsuario entity = new DatoGeneralUsuario();		  
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
	
	public  List<DatoGeneralUsuario> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DatoGeneralUsuario> entities = new  ArrayList<DatoGeneralUsuario>();
		DatoGeneralUsuario entity = new DatoGeneralUsuario();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DatoGeneralUsuario();
      	    	entity=super.getEntity("",entity,resultSet,DatoGeneralUsuarioDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDatoGeneralUsuario("",entity,resultSet);
      	    	
				//entity.setDatoGeneralUsuarioOriginal( new DatoGeneralUsuario());
      	    	//entity.setDatoGeneralUsuarioOriginal(super.getEntity("",entity.getDatoGeneralUsuarioOriginal(),resultSet,DatoGeneralUsuarioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDatoGeneralUsuarioOriginal(this.getEntityDatoGeneralUsuario("",entity.getDatoGeneralUsuarioOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDatoGeneralUsuarios(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public DatoGeneralUsuario getEntityDatoGeneralUsuario(String strPrefijo,DatoGeneralUsuario entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_pais(resultSet.getLong(strPrefijo+DatoGeneralUsuarioConstantesFunciones.IDPAIS));
				entity.setid_provincia(resultSet.getLong(strPrefijo+DatoGeneralUsuarioConstantesFunciones.IDPROVINCIA));
				entity.setid_ciudad(resultSet.getLong(strPrefijo+DatoGeneralUsuarioConstantesFunciones.IDCIUDAD));
				entity.setcedula(resultSet.getString(strPrefijo+DatoGeneralUsuarioConstantesFunciones.CEDULA));
				entity.setapellidos(resultSet.getString(strPrefijo+DatoGeneralUsuarioConstantesFunciones.APELLIDOS));
				entity.setnombres(resultSet.getString(strPrefijo+DatoGeneralUsuarioConstantesFunciones.NOMBRES));
				entity.settelefono(resultSet.getString(strPrefijo+DatoGeneralUsuarioConstantesFunciones.TELEFONO));
				entity.settelefono_movil(resultSet.getString(strPrefijo+DatoGeneralUsuarioConstantesFunciones.TELEFONOMOVIL));
				entity.sete_mail(resultSet.getString(strPrefijo+DatoGeneralUsuarioConstantesFunciones.EMAIL));
				entity.seturl(resultSet.getString(strPrefijo+DatoGeneralUsuarioConstantesFunciones.URL));
				entity.setfecha_nacimiento(new Date(resultSet.getDate(strPrefijo+DatoGeneralUsuarioConstantesFunciones.FECHANACIMIENTO).getTime()));
				entity.setdireccion(resultSet.getString(strPrefijo+DatoGeneralUsuarioConstantesFunciones.DIRECCION));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowDatoGeneralUsuario(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(DatoGeneralUsuario entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=DatoGeneralUsuarioDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=DatoGeneralUsuarioDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=DatoGeneralUsuarioDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=DatoGeneralUsuarioDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(DatoGeneralUsuarioConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,DatoGeneralUsuarioDataAccess.TABLENAME,DatoGeneralUsuarioDataAccess.ISWITHSTOREPROCEDURES);
			
			DatoGeneralUsuarioDataAccess.setDatoGeneralUsuarioOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Usuario getUsuario(Connexion connexion,DatoGeneralUsuario reldatogeneralusuario)throws SQLException,Exception {

		Usuario usuario= new Usuario();

		try {
			UsuarioDataAccess usuarioDataAccess=new UsuarioDataAccess();

			usuarioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			usuarioDataAccess.setConnexionType(this.connexionType);
			usuarioDataAccess.setParameterDbType(this.parameterDbType);

			usuario=usuarioDataAccess.getEntity(connexion,reldatogeneralusuario.getId());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return usuario;

	}

	public Pais getPais(Connexion connexion,DatoGeneralUsuario reldatogeneralusuario)throws SQLException,Exception {

		Pais pais= new Pais();

		try {
			PaisDataAccess paisDataAccess=new PaisDataAccess();

			paisDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			paisDataAccess.setConnexionType(this.connexionType);
			paisDataAccess.setParameterDbType(this.parameterDbType);

			pais=paisDataAccess.getEntity(connexion,reldatogeneralusuario.getid_pais());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pais;

	}

	public Provincia getProvincia(Connexion connexion,DatoGeneralUsuario reldatogeneralusuario)throws SQLException,Exception {

		Provincia provincia= new Provincia();

		try {
			ProvinciaDataAccess provinciaDataAccess=new ProvinciaDataAccess();

			provinciaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			provinciaDataAccess.setConnexionType(this.connexionType);
			provinciaDataAccess.setParameterDbType(this.parameterDbType);

			provincia=provinciaDataAccess.getEntity(connexion,reldatogeneralusuario.getid_provincia());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return provincia;

	}

	public Ciudad getCiudad(Connexion connexion,DatoGeneralUsuario reldatogeneralusuario)throws SQLException,Exception {

		Ciudad ciudad= new Ciudad();

		try {
			CiudadDataAccess ciudadDataAccess=new CiudadDataAccess();

			ciudadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ciudadDataAccess.setConnexionType(this.connexionType);
			ciudadDataAccess.setParameterDbType(this.parameterDbType);

			ciudad=ciudadDataAccess.getEntity(connexion,reldatogeneralusuario.getid_ciudad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ciudad;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,DatoGeneralUsuario datogeneralusuario) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!datogeneralusuario.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_usuario=new ParameterValue<Long>();
					parameterMaintenanceValueid_usuario.setValue(datogeneralusuario.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_usuario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_pais=new ParameterValue<Long>();
					parameterMaintenanceValueid_pais.setValue(datogeneralusuario.getid_pais());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_pais);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_provincia=new ParameterValue<Long>();
					parameterMaintenanceValueid_provincia.setValue(datogeneralusuario.getid_provincia());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_provincia);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ciudad=new ParameterValue<Long>();
					parameterMaintenanceValueid_ciudad.setValue(datogeneralusuario.getid_ciudad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ciudad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecedula=new ParameterValue<String>();
					parameterMaintenanceValuecedula.setValue(datogeneralusuario.getcedula());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecedula);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueapellidos=new ParameterValue<String>();
					parameterMaintenanceValueapellidos.setValue(datogeneralusuario.getapellidos());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueapellidos);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombres=new ParameterValue<String>();
					parameterMaintenanceValuenombres.setValue(datogeneralusuario.getnombres());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombres);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuetelefono=new ParameterValue<String>();
					parameterMaintenanceValuetelefono.setValue(datogeneralusuario.gettelefono());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetelefono);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuetelefono_movil=new ParameterValue<String>();
					parameterMaintenanceValuetelefono_movil.setValue(datogeneralusuario.gettelefono_movil());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetelefono_movil);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuee_mail=new ParameterValue<String>();
					parameterMaintenanceValuee_mail.setValue(datogeneralusuario.gete_mail());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuee_mail);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueurl=new ParameterValue<String>();
					parameterMaintenanceValueurl.setValue(datogeneralusuario.geturl());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueurl);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_nacimiento=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_nacimiento.setValue(datogeneralusuario.getfecha_nacimiento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_nacimiento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedireccion=new ParameterValue<String>();
					parameterMaintenanceValuedireccion.setValue(datogeneralusuario.getdireccion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedireccion);
					parametersTemp.add(parameterMaintenance);
					
						if(!datogeneralusuario.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(datogeneralusuario.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(datogeneralusuario.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(datogeneralusuario.getId());
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
	
	public void setIsNewIsChangedFalseDatoGeneralUsuario(DatoGeneralUsuario datogeneralusuario)throws Exception  {		
		datogeneralusuario.setIsNew(false);
		datogeneralusuario.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseDatoGeneralUsuarios(List<DatoGeneralUsuario> datogeneralusuarios)throws Exception  {				
		for(DatoGeneralUsuario datogeneralusuario:datogeneralusuarios) {
			datogeneralusuario.setIsNew(false);
			datogeneralusuario.setIsChanged(false);
		}
	}
	
	public void generarExportarDatoGeneralUsuario(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
