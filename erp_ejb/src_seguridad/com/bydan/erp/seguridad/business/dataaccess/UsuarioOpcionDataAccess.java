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
import com.bydan.erp.seguridad.util.*;//UsuarioOpcionConstantesFunciones;










@SuppressWarnings("unused")
final public class UsuarioOpcionDataAccess extends  UsuarioOpcionDataAccessAdditional{ //UsuarioOpcionDataAccessAdditional,DataAccessHelper<UsuarioOpcion>
	//static Logger logger = Logger.getLogger(UsuarioOpcionDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="usuario_opcion";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+UsuarioOpcionConstantesFunciones.SCHEMA+"."+UsuarioOpcionConstantesFunciones.TABLENAME+"(version_row,id_sistema,id_modulo,id_grupo_opcion,id_opcion,id_perfil,id_usuario,con_precargar,estado)values(current_timestamp,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+UsuarioOpcionConstantesFunciones.SCHEMA+"."+UsuarioOpcionConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_sistema=?,id_modulo=?,id_grupo_opcion=?,id_opcion=?,id_perfil=?,id_usuario=?,con_precargar=?,estado=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+UsuarioOpcionConstantesFunciones.SCHEMA+"."+UsuarioOpcionConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select usuarioopcion from "+UsuarioOpcionConstantesFunciones.SPERSISTENCENAME+" usuarioopcion";
	public static String QUERYSELECTNATIVE="select "+UsuarioOpcionConstantesFunciones.SCHEMA+"."+UsuarioOpcionConstantesFunciones.TABLENAME+".id,"+UsuarioOpcionConstantesFunciones.SCHEMA+"."+UsuarioOpcionConstantesFunciones.TABLENAME+".version_row,"+UsuarioOpcionConstantesFunciones.SCHEMA+"."+UsuarioOpcionConstantesFunciones.TABLENAME+".id_sistema,"+UsuarioOpcionConstantesFunciones.SCHEMA+"."+UsuarioOpcionConstantesFunciones.TABLENAME+".id_modulo,"+UsuarioOpcionConstantesFunciones.SCHEMA+"."+UsuarioOpcionConstantesFunciones.TABLENAME+".id_grupo_opcion,"+UsuarioOpcionConstantesFunciones.SCHEMA+"."+UsuarioOpcionConstantesFunciones.TABLENAME+".id_opcion,"+UsuarioOpcionConstantesFunciones.SCHEMA+"."+UsuarioOpcionConstantesFunciones.TABLENAME+".id_perfil,"+UsuarioOpcionConstantesFunciones.SCHEMA+"."+UsuarioOpcionConstantesFunciones.TABLENAME+".id_usuario,"+UsuarioOpcionConstantesFunciones.SCHEMA+"."+UsuarioOpcionConstantesFunciones.TABLENAME+".con_precargar,"+UsuarioOpcionConstantesFunciones.SCHEMA+"."+UsuarioOpcionConstantesFunciones.TABLENAME+".estado from "+UsuarioOpcionConstantesFunciones.SCHEMA+"."+UsuarioOpcionConstantesFunciones.TABLENAME;//+" as "+UsuarioOpcionConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+UsuarioOpcionConstantesFunciones.SCHEMA+"."+UsuarioOpcionConstantesFunciones.TABLENAME+".id,"+UsuarioOpcionConstantesFunciones.SCHEMA+"."+UsuarioOpcionConstantesFunciones.TABLENAME+".version_row from "+UsuarioOpcionConstantesFunciones.SCHEMA+"."+UsuarioOpcionConstantesFunciones.TABLENAME;//+" as "+UsuarioOpcionConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+UsuarioOpcionConstantesFunciones.SCHEMA+"."+UsuarioOpcionConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_sistema=?,id_modulo=?,id_grupo_opcion=?,id_opcion=?,id_perfil=?,id_usuario=?,con_precargar=?,estado=?";
	
	public static String STOREPROCEDUREINSERT="call SP_USUARIOOPCION_INSERT(?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_USUARIOOPCION_UPDATE(?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_USUARIOOPCION_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_USUARIOOPCION_SELECT(?,?)";
	
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
	
	
	protected UsuarioOpcionDataAccessAdditional usuarioopcionDataAccessAdditional=null;
	
	public UsuarioOpcionDataAccessAdditional getUsuarioOpcionDataAccessAdditional() {
		return this.usuarioopcionDataAccessAdditional;
	}
	
	public void setUsuarioOpcionDataAccessAdditional(UsuarioOpcionDataAccessAdditional usuarioopcionDataAccessAdditional) {
		try {
			this.usuarioopcionDataAccessAdditional=usuarioopcionDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public UsuarioOpcionDataAccess() {
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
		UsuarioOpcionDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		UsuarioOpcionDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		UsuarioOpcionDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setUsuarioOpcionOriginal(UsuarioOpcion usuarioopcion)throws Exception  {
		usuarioopcion.setUsuarioOpcionOriginal((UsuarioOpcion)usuarioopcion.clone());		
	}
	
	public void setUsuarioOpcionsOriginal(List<UsuarioOpcion> usuarioopcions)throws Exception  {
		
		for(UsuarioOpcion usuarioopcion:usuarioopcions){
			usuarioopcion.setUsuarioOpcionOriginal((UsuarioOpcion)usuarioopcion.clone());
		}
	}
	
	public static void setUsuarioOpcionOriginalStatic(UsuarioOpcion usuarioopcion)throws Exception  {
		usuarioopcion.setUsuarioOpcionOriginal((UsuarioOpcion)usuarioopcion.clone());		
	}
	
	public static void setUsuarioOpcionsOriginalStatic(List<UsuarioOpcion> usuarioopcions)throws Exception  {
		
		for(UsuarioOpcion usuarioopcion:usuarioopcions){
			usuarioopcion.setUsuarioOpcionOriginal((UsuarioOpcion)usuarioopcion.clone());
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
	
	public  UsuarioOpcion getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		UsuarioOpcion entity = new UsuarioOpcion();		
		
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
	
	public  UsuarioOpcion getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		UsuarioOpcion entity = new UsuarioOpcion();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=UsuarioOpcionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=UsuarioOpcionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Seguridad.UsuarioOpcion.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setUsuarioOpcionOriginal(new UsuarioOpcion());
      	    	entity=super.getEntity("",entity,resultSet,UsuarioOpcionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityUsuarioOpcion("",entity,resultSet); 
				
				entity.setUsuarioOpcionOriginal(super.getEntity("",entity.getUsuarioOpcionOriginal(),resultSet,UsuarioOpcionDataAccess.ISWITHSCHEMA));         		
      	    	entity.setUsuarioOpcionOriginal(this.getEntityUsuarioOpcion("",entity.getUsuarioOpcionOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseUsuarioOpcion(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  UsuarioOpcion getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		UsuarioOpcion entity = new UsuarioOpcion();
				
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
	
	public  UsuarioOpcion getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		UsuarioOpcion entity = new UsuarioOpcion();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=UsuarioOpcionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=UsuarioOpcionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,UsuarioOpcionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Seguridad.UsuarioOpcion.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setUsuarioOpcionOriginal(new UsuarioOpcion());
      	    	entity=super.getEntity("",entity,resultSet,UsuarioOpcionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityUsuarioOpcion("",entity,resultSet);    
				
				entity.setUsuarioOpcionOriginal(super.getEntity("",entity.getUsuarioOpcionOriginal(),resultSet,UsuarioOpcionDataAccess.ISWITHSCHEMA));         		
      	    	entity.setUsuarioOpcionOriginal(this.getEntityUsuarioOpcion("",entity.getUsuarioOpcionOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseUsuarioOpcion(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //UsuarioOpcion
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		UsuarioOpcion entity = new UsuarioOpcion();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=UsuarioOpcionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=UsuarioOpcionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,UsuarioOpcionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Seguridad.UsuarioOpcion.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseUsuarioOpcion(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<UsuarioOpcion> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<UsuarioOpcion> entities = new  ArrayList<UsuarioOpcion>();
		UsuarioOpcion entity = new UsuarioOpcion();		  
		
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
	
	public  List<UsuarioOpcion> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<UsuarioOpcion> entities = new  ArrayList<UsuarioOpcion>();
		UsuarioOpcion entity = new UsuarioOpcion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=UsuarioOpcionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=UsuarioOpcionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,UsuarioOpcionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new UsuarioOpcion();
      	    	entity=super.getEntity("",entity,resultSet,UsuarioOpcionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityUsuarioOpcion("",entity,resultSet);
      	    	
				entity.setUsuarioOpcionOriginal( new UsuarioOpcion());
      	    	entity.setUsuarioOpcionOriginal(super.getEntity("",entity.getUsuarioOpcionOriginal(),resultSet,UsuarioOpcionDataAccess.ISWITHSCHEMA));         		
      	    	entity.setUsuarioOpcionOriginal(this.getEntityUsuarioOpcion("",entity.getUsuarioOpcionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseUsuarioOpcions(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarUsuarioOpcion(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<UsuarioOpcion> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<UsuarioOpcion> entities = new  ArrayList<UsuarioOpcion>();
		UsuarioOpcion entity = new UsuarioOpcion();		  
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
	
	public  List<UsuarioOpcion> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<UsuarioOpcion> entities = new  ArrayList<UsuarioOpcion>();
		UsuarioOpcion entity = new UsuarioOpcion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new UsuarioOpcion();
				
				if(conMapGenerico) {
					entity.inicializarMapUsuarioOpcion();
					//entity.setMapUsuarioOpcion(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapUsuarioOpcionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapUsuarioOpcion().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,UsuarioOpcionDataAccess.ISWITHSCHEMA);         		
					entity=UsuarioOpcionDataAccess.getEntityUsuarioOpcion("",entity,resultSet,listColumns,deepLoadType);
					
					//entity.setUsuarioOpcionOriginal( new UsuarioOpcion());
					//entity.setUsuarioOpcionOriginal(super.getEntity("",entity.getUsuarioOpcionOriginal(),resultSet,UsuarioOpcionDataAccess.ISWITHSCHEMA));         		
					//entity.setUsuarioOpcionOriginal(this.getEntityUsuarioOpcion("",entity.getUsuarioOpcionOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseUsuarioOpcions(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarUsuarioOpcion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public UsuarioOpcion getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		UsuarioOpcion entity = new UsuarioOpcion();		  
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
	
	public  UsuarioOpcion getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		UsuarioOpcion entity = new UsuarioOpcion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new UsuarioOpcion();
				
				if(conMapGenerico) {
					entity.inicializarMapUsuarioOpcion();
					//entity.setMapUsuarioOpcion(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapUsuarioOpcionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapUsuarioOpcion().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,UsuarioOpcionDataAccess.ISWITHSCHEMA);         		
					entity=UsuarioOpcionDataAccess.getEntityUsuarioOpcion("",entity,resultSet,listColumns,deepLoadType);
					
					//entity.setUsuarioOpcionOriginal( new UsuarioOpcion());
					//entity.setUsuarioOpcionOriginal(super.getEntity("",entity.getUsuarioOpcionOriginal(),resultSet,UsuarioOpcionDataAccess.ISWITHSCHEMA));         		
					//entity.setUsuarioOpcionOriginal(this.getEntityUsuarioOpcion("",entity.getUsuarioOpcionOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseUsuarioOpcion(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarUsuarioOpcion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static UsuarioOpcion getEntityUsuarioOpcion(String strPrefijo,UsuarioOpcion entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = UsuarioOpcion.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = UsuarioOpcion.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					UsuarioOpcionDataAccess.setFieldReflectionUsuarioOpcion(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasUsuarioOpcion=UsuarioOpcionConstantesFunciones.getTodosTiposColumnasUsuarioOpcion();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasUsuarioOpcion) {
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
							field = UsuarioOpcion.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = UsuarioOpcion.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						UsuarioOpcionDataAccess.setFieldReflectionUsuarioOpcion(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionUsuarioOpcion(Field field,String strPrefijo,String sColumn,UsuarioOpcion entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case UsuarioOpcionConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case UsuarioOpcionConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case UsuarioOpcionConstantesFunciones.IDSISTEMA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case UsuarioOpcionConstantesFunciones.IDMODULO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case UsuarioOpcionConstantesFunciones.IDGRUPOOPCION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case UsuarioOpcionConstantesFunciones.IDOPCION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case UsuarioOpcionConstantesFunciones.IDPERFIL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case UsuarioOpcionConstantesFunciones.IDUSUARIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case UsuarioOpcionConstantesFunciones.CONPRECARGAR:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case UsuarioOpcionConstantesFunciones.ESTADO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<UsuarioOpcion>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<UsuarioOpcion> entities = new  ArrayList<UsuarioOpcion>();
		UsuarioOpcion entity = new UsuarioOpcion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=UsuarioOpcionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=UsuarioOpcionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,UsuarioOpcionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new UsuarioOpcion();
					entity=super.getEntity("",entity,resultSet,UsuarioOpcionDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityUsuarioOpcion("",entity,resultSet);
					
					entity.setUsuarioOpcionOriginal( new UsuarioOpcion());
					entity.setUsuarioOpcionOriginal(super.getEntity("",entity.getUsuarioOpcionOriginal(),resultSet,UsuarioOpcionDataAccess.ISWITHSCHEMA));         		
					entity.setUsuarioOpcionOriginal(this.getEntityUsuarioOpcion("",entity.getUsuarioOpcionOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseUsuarioOpcions(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarUsuarioOpcion(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<UsuarioOpcion>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<UsuarioOpcion> entities = new  ArrayList<UsuarioOpcion>();
		UsuarioOpcion entity = new UsuarioOpcion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=UsuarioOpcionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=UsuarioOpcionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,UsuarioOpcionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<UsuarioOpcion> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<UsuarioOpcion> entities = new  ArrayList<UsuarioOpcion>();
		UsuarioOpcion entity = new UsuarioOpcion();		  
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
	
	public  List<UsuarioOpcion> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<UsuarioOpcion> entities = new  ArrayList<UsuarioOpcion>();
		UsuarioOpcion entity = new UsuarioOpcion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new UsuarioOpcion();
      	    	entity=super.getEntity("",entity,resultSet,UsuarioOpcionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityUsuarioOpcion("",entity,resultSet);
      	    	
				entity.setUsuarioOpcionOriginal( new UsuarioOpcion());
      	    	entity.setUsuarioOpcionOriginal(super.getEntity("",entity.getUsuarioOpcionOriginal(),resultSet,UsuarioOpcionDataAccess.ISWITHSCHEMA));         		
      	    	entity.setUsuarioOpcionOriginal(this.getEntityUsuarioOpcion("",entity.getUsuarioOpcionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseUsuarioOpcions(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarUsuarioOpcion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<UsuarioOpcion> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<UsuarioOpcion> entities = new  ArrayList<UsuarioOpcion>();
		UsuarioOpcion entity = new UsuarioOpcion();		  
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
	
	public  List<UsuarioOpcion> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<UsuarioOpcion> entities = new  ArrayList<UsuarioOpcion>();
		UsuarioOpcion entity = new UsuarioOpcion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new UsuarioOpcion();
      	    	entity=super.getEntity("",entity,resultSet,UsuarioOpcionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityUsuarioOpcion("",entity,resultSet);
      	    	
				entity.setUsuarioOpcionOriginal( new UsuarioOpcion());
      	    	entity.setUsuarioOpcionOriginal(super.getEntity("",entity.getUsuarioOpcionOriginal(),resultSet,UsuarioOpcionDataAccess.ISWITHSCHEMA));         		
      	    	entity.setUsuarioOpcionOriginal(this.getEntityUsuarioOpcion("",entity.getUsuarioOpcionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseUsuarioOpcions(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public UsuarioOpcion getEntityUsuarioOpcion(String strPrefijo,UsuarioOpcion entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_sistema(resultSet.getLong(strPrefijo+UsuarioOpcionConstantesFunciones.IDSISTEMA));
				entity.setid_modulo(resultSet.getLong(strPrefijo+UsuarioOpcionConstantesFunciones.IDMODULO));
				entity.setid_grupo_opcion(resultSet.getLong(strPrefijo+UsuarioOpcionConstantesFunciones.IDGRUPOOPCION));if(resultSet.wasNull()) {entity.setid_grupo_opcion(null); }
				entity.setid_opcion(resultSet.getLong(strPrefijo+UsuarioOpcionConstantesFunciones.IDOPCION));
				entity.setid_perfil(resultSet.getLong(strPrefijo+UsuarioOpcionConstantesFunciones.IDPERFIL));
				entity.setid_usuario(resultSet.getLong(strPrefijo+UsuarioOpcionConstantesFunciones.IDUSUARIO));
				entity.setcon_precargar(resultSet.getBoolean(strPrefijo+UsuarioOpcionConstantesFunciones.CONPRECARGAR));
				entity.setestado(resultSet.getBoolean(strPrefijo+UsuarioOpcionConstantesFunciones.ESTADO));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowUsuarioOpcion(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(UsuarioOpcion entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=UsuarioOpcionDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=UsuarioOpcionDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=UsuarioOpcionDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=UsuarioOpcionDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(UsuarioOpcionConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,UsuarioOpcionDataAccess.TABLENAME,UsuarioOpcionDataAccess.ISWITHSTOREPROCEDURES);
			
			UsuarioOpcionDataAccess.setUsuarioOpcionOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Sistema getSistema(Connexion connexion,UsuarioOpcion relusuarioopcion)throws SQLException,Exception {

		Sistema sistema= new Sistema();

		try {
			SistemaDataAccess sistemaDataAccess=new SistemaDataAccess();

			sistemaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sistemaDataAccess.setConnexionType(this.connexionType);
			sistemaDataAccess.setParameterDbType(this.parameterDbType);

			sistema=sistemaDataAccess.getEntity(connexion,relusuarioopcion.getid_sistema());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sistema;

	}

	public Modulo getModulo(Connexion connexion,UsuarioOpcion relusuarioopcion)throws SQLException,Exception {

		Modulo modulo= new Modulo();

		try {
			ModuloDataAccess moduloDataAccess=new ModuloDataAccess();

			moduloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			moduloDataAccess.setConnexionType(this.connexionType);
			moduloDataAccess.setParameterDbType(this.parameterDbType);

			modulo=moduloDataAccess.getEntity(connexion,relusuarioopcion.getid_modulo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return modulo;

	}

	public GrupoOpcion getGrupoOpcion(Connexion connexion,UsuarioOpcion relusuarioopcion)throws SQLException,Exception {

		GrupoOpcion grupoopcion= new GrupoOpcion();

		try {
			GrupoOpcionDataAccess grupoopcionDataAccess=new GrupoOpcionDataAccess();

			grupoopcionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			grupoopcionDataAccess.setConnexionType(this.connexionType);
			grupoopcionDataAccess.setParameterDbType(this.parameterDbType);

			grupoopcion=grupoopcionDataAccess.getEntity(connexion,relusuarioopcion.getid_grupo_opcion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return grupoopcion;

	}

	public Opcion getOpcion(Connexion connexion,UsuarioOpcion relusuarioopcion)throws SQLException,Exception {

		Opcion opcion= new Opcion();

		try {
			OpcionDataAccess opcionDataAccess=new OpcionDataAccess();

			opcionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			opcionDataAccess.setConnexionType(this.connexionType);
			opcionDataAccess.setParameterDbType(this.parameterDbType);

			opcion=opcionDataAccess.getEntity(connexion,relusuarioopcion.getid_opcion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return opcion;

	}

	public Perfil getPerfil(Connexion connexion,UsuarioOpcion relusuarioopcion)throws SQLException,Exception {

		Perfil perfil= new Perfil();

		try {
			PerfilDataAccess perfilDataAccess=new PerfilDataAccess();

			perfilDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			perfilDataAccess.setConnexionType(this.connexionType);
			perfilDataAccess.setParameterDbType(this.parameterDbType);

			perfil=perfilDataAccess.getEntity(connexion,relusuarioopcion.getid_perfil());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return perfil;

	}

	public Usuario getUsuario(Connexion connexion,UsuarioOpcion relusuarioopcion)throws SQLException,Exception {

		Usuario usuario= new Usuario();

		try {
			UsuarioDataAccess usuarioDataAccess=new UsuarioDataAccess();

			usuarioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			usuarioDataAccess.setConnexionType(this.connexionType);
			usuarioDataAccess.setParameterDbType(this.parameterDbType);

			usuario=usuarioDataAccess.getEntity(connexion,relusuarioopcion.getid_usuario());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return usuario;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,UsuarioOpcion usuarioopcion) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!usuarioopcion.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sistema=new ParameterValue<Long>();
					parameterMaintenanceValueid_sistema.setValue(usuarioopcion.getid_sistema());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sistema);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_modulo=new ParameterValue<Long>();
					parameterMaintenanceValueid_modulo.setValue(usuarioopcion.getid_modulo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_modulo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_grupo_opcion=new ParameterValue<Long>();
					parameterMaintenanceValueid_grupo_opcion.setValue(usuarioopcion.getid_grupo_opcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_grupo_opcion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_opcion=new ParameterValue<Long>();
					parameterMaintenanceValueid_opcion.setValue(usuarioopcion.getid_opcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_opcion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_perfil=new ParameterValue<Long>();
					parameterMaintenanceValueid_perfil.setValue(usuarioopcion.getid_perfil());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_perfil);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_usuario=new ParameterValue<Long>();
					parameterMaintenanceValueid_usuario.setValue(usuarioopcion.getid_usuario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_usuario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_precargar=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_precargar.setValue(usuarioopcion.getcon_precargar());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_precargar);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValueestado=new ParameterValue<Boolean>();
					parameterMaintenanceValueestado.setValue(usuarioopcion.getestado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueestado);
					parametersTemp.add(parameterMaintenance);
					
						if(!usuarioopcion.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(usuarioopcion.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(usuarioopcion.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(usuarioopcion.getId());
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
	
	public void setIsNewIsChangedFalseUsuarioOpcion(UsuarioOpcion usuarioopcion)throws Exception  {		
		usuarioopcion.setIsNew(false);
		usuarioopcion.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseUsuarioOpcions(List<UsuarioOpcion> usuarioopcions)throws Exception  {				
		for(UsuarioOpcion usuarioopcion:usuarioopcions) {
			usuarioopcion.setIsNew(false);
			usuarioopcion.setIsChanged(false);
		}
	}
	
	public void generarExportarUsuarioOpcion(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
