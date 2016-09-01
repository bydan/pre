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
import com.bydan.erp.seguridad.util.*;//OpcionConstantesFunciones;










@SuppressWarnings("unused")
final public class OpcionDataAccess extends  OpcionDataAccessAdditional{ //OpcionDataAccessAdditional,DataAccessHelper<Opcion>
	//static Logger logger = Logger.getLogger(OpcionDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="opcion";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+OpcionConstantesFunciones.SCHEMA+"."+OpcionConstantesFunciones.TABLENAME+"(version_row,id_sistema,id_modulo,id_grupo_opcion,id_opcion,codigo,nombre,id_tipo_tecla_mascara,tecla,posicion,icon_name,nombre_clase,sub_modulo,paquete,paquete_original,path_auxiliar,es_para_menu,con_mostrar_acciones_campo,es_guardar_relaciones,estado)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+OpcionConstantesFunciones.SCHEMA+"."+OpcionConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_sistema=?,id_modulo=?,id_grupo_opcion=?,id_opcion=?,codigo=?,nombre=?,id_tipo_tecla_mascara=?,tecla=?,posicion=?,icon_name=?,nombre_clase=?,sub_modulo=?,paquete=?,paquete_original=?,path_auxiliar=?,es_para_menu=?,con_mostrar_acciones_campo=?,es_guardar_relaciones=?,estado=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+OpcionConstantesFunciones.SCHEMA+"."+OpcionConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select opcion from "+OpcionConstantesFunciones.SPERSISTENCENAME+" opcion";
	public static String QUERYSELECTNATIVE="select "+OpcionConstantesFunciones.SCHEMA+"."+OpcionConstantesFunciones.TABLENAME+".id,"+OpcionConstantesFunciones.SCHEMA+"."+OpcionConstantesFunciones.TABLENAME+".version_row,"+OpcionConstantesFunciones.SCHEMA+"."+OpcionConstantesFunciones.TABLENAME+".id_sistema,"+OpcionConstantesFunciones.SCHEMA+"."+OpcionConstantesFunciones.TABLENAME+".id_modulo,"+OpcionConstantesFunciones.SCHEMA+"."+OpcionConstantesFunciones.TABLENAME+".id_grupo_opcion,"+OpcionConstantesFunciones.SCHEMA+"."+OpcionConstantesFunciones.TABLENAME+".id_opcion,"+OpcionConstantesFunciones.SCHEMA+"."+OpcionConstantesFunciones.TABLENAME+".codigo,"+OpcionConstantesFunciones.SCHEMA+"."+OpcionConstantesFunciones.TABLENAME+".nombre,"+OpcionConstantesFunciones.SCHEMA+"."+OpcionConstantesFunciones.TABLENAME+".id_tipo_tecla_mascara,"+OpcionConstantesFunciones.SCHEMA+"."+OpcionConstantesFunciones.TABLENAME+".tecla,"+OpcionConstantesFunciones.SCHEMA+"."+OpcionConstantesFunciones.TABLENAME+".posicion,"+OpcionConstantesFunciones.SCHEMA+"."+OpcionConstantesFunciones.TABLENAME+".icon_name,"+OpcionConstantesFunciones.SCHEMA+"."+OpcionConstantesFunciones.TABLENAME+".nombre_clase,"+OpcionConstantesFunciones.SCHEMA+"."+OpcionConstantesFunciones.TABLENAME+".sub_modulo,"+OpcionConstantesFunciones.SCHEMA+"."+OpcionConstantesFunciones.TABLENAME+".paquete,"+OpcionConstantesFunciones.SCHEMA+"."+OpcionConstantesFunciones.TABLENAME+".paquete_original,"+OpcionConstantesFunciones.SCHEMA+"."+OpcionConstantesFunciones.TABLENAME+".path_auxiliar,"+OpcionConstantesFunciones.SCHEMA+"."+OpcionConstantesFunciones.TABLENAME+".es_para_menu,"+OpcionConstantesFunciones.SCHEMA+"."+OpcionConstantesFunciones.TABLENAME+".con_mostrar_acciones_campo,"+OpcionConstantesFunciones.SCHEMA+"."+OpcionConstantesFunciones.TABLENAME+".es_guardar_relaciones,"+OpcionConstantesFunciones.SCHEMA+"."+OpcionConstantesFunciones.TABLENAME+".estado from "+OpcionConstantesFunciones.SCHEMA+"."+OpcionConstantesFunciones.TABLENAME;//+" as "+OpcionConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+OpcionConstantesFunciones.SCHEMA+"."+OpcionConstantesFunciones.TABLENAME+".id,"+OpcionConstantesFunciones.SCHEMA+"."+OpcionConstantesFunciones.TABLENAME+".version_row,"+OpcionConstantesFunciones.SCHEMA+"."+OpcionConstantesFunciones.TABLENAME+".codigo from "+OpcionConstantesFunciones.SCHEMA+"."+OpcionConstantesFunciones.TABLENAME;//+" as "+OpcionConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+OpcionConstantesFunciones.SCHEMA+"."+OpcionConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_sistema=?,id_modulo=?,id_grupo_opcion=?,id_opcion=?,codigo=?,nombre=?,id_tipo_tecla_mascara=?,tecla=?,posicion=?,icon_name=?,nombre_clase=?,sub_modulo=?,paquete=?,paquete_original=?,path_auxiliar=?,es_para_menu=?,con_mostrar_acciones_campo=?,es_guardar_relaciones=?,estado=?";
	
	public static String STOREPROCEDUREINSERT="call SP_OPCION_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_OPCION_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_OPCION_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_OPCION_SELECT(?,?)";
	
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
	
	
	protected OpcionDataAccessAdditional opcionDataAccessAdditional=null;
	
	public OpcionDataAccessAdditional getOpcionDataAccessAdditional() {
		return this.opcionDataAccessAdditional;
	}
	
	public void setOpcionDataAccessAdditional(OpcionDataAccessAdditional opcionDataAccessAdditional) {
		try {
			this.opcionDataAccessAdditional=opcionDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public OpcionDataAccess() {
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
		OpcionDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		OpcionDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		OpcionDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setOpcionOriginal(Opcion opcion)throws Exception  {
		opcion.setOpcionOriginal((Opcion)opcion.clone());		
	}
	
	public void setOpcionsOriginal(List<Opcion> opcions)throws Exception  {
		
		for(Opcion opcion:opcions){
			opcion.setOpcionOriginal((Opcion)opcion.clone());
		}
	}
	
	public static void setOpcionOriginalStatic(Opcion opcion)throws Exception  {
		opcion.setOpcionOriginal((Opcion)opcion.clone());		
	}
	
	public static void setOpcionsOriginalStatic(List<Opcion> opcions)throws Exception  {
		
		for(Opcion opcion:opcions){
			opcion.setOpcionOriginal((Opcion)opcion.clone());
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
	
	public  Opcion getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		Opcion entity = new Opcion();		
		
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
	
	public  Opcion getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		Opcion entity = new Opcion();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=OpcionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=OpcionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Seguridad.Opcion.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setOpcionOriginal(new Opcion());
      	    	entity=super.getEntity("",entity,resultSet,OpcionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityOpcion("",entity,resultSet); 
				
				entity.setOpcionOriginal(super.getEntity("",entity.getOpcionOriginal(),resultSet,OpcionDataAccess.ISWITHSCHEMA));         		
      	    	entity.setOpcionOriginal(this.getEntityOpcion("",entity.getOpcionOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseOpcion(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  Opcion getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Opcion entity = new Opcion();
				
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
	
	public  Opcion getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Opcion entity = new Opcion();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=OpcionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=OpcionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,OpcionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Seguridad.Opcion.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setOpcionOriginal(new Opcion());
      	    	entity=super.getEntity("",entity,resultSet,OpcionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityOpcion("",entity,resultSet);    
				
				entity.setOpcionOriginal(super.getEntity("",entity.getOpcionOriginal(),resultSet,OpcionDataAccess.ISWITHSCHEMA));         		
      	    	entity.setOpcionOriginal(this.getEntityOpcion("",entity.getOpcionOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseOpcion(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //Opcion
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		Opcion entity = new Opcion();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=OpcionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=OpcionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,OpcionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Seguridad.Opcion.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseOpcion(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<Opcion> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Opcion> entities = new  ArrayList<Opcion>();
		Opcion entity = new Opcion();		  
		
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
	
	public  List<Opcion> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Opcion> entities = new  ArrayList<Opcion>();
		Opcion entity = new Opcion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=OpcionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=OpcionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,OpcionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Opcion();
      	    	entity=super.getEntity("",entity,resultSet,OpcionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityOpcion("",entity,resultSet);
      	    	
				entity.setOpcionOriginal( new Opcion());
      	    	entity.setOpcionOriginal(super.getEntity("",entity.getOpcionOriginal(),resultSet,OpcionDataAccess.ISWITHSCHEMA));         		
      	    	entity.setOpcionOriginal(this.getEntityOpcion("",entity.getOpcionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseOpcions(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarOpcion(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Opcion> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Opcion> entities = new  ArrayList<Opcion>();
		Opcion entity = new Opcion();		  
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
	
	public  List<Opcion> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Opcion> entities = new  ArrayList<Opcion>();
		Opcion entity = new Opcion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Opcion();
				
				if(conMapGenerico) {
					entity.inicializarMapOpcion();
					//entity.setMapOpcion(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapOpcionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapOpcion().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,OpcionDataAccess.ISWITHSCHEMA);         		
					entity=OpcionDataAccess.getEntityOpcion("",entity,resultSet,listColumns,deepLoadType);
					
					//entity.setOpcionOriginal( new Opcion());
					//entity.setOpcionOriginal(super.getEntity("",entity.getOpcionOriginal(),resultSet,OpcionDataAccess.ISWITHSCHEMA));         		
					//entity.setOpcionOriginal(this.getEntityOpcion("",entity.getOpcionOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseOpcions(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarOpcion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public Opcion getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Opcion entity = new Opcion();		  
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
	
	public  Opcion getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Opcion entity = new Opcion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Opcion();
				
				if(conMapGenerico) {
					entity.inicializarMapOpcion();
					//entity.setMapOpcion(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapOpcionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapOpcion().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,OpcionDataAccess.ISWITHSCHEMA);         		
					entity=OpcionDataAccess.getEntityOpcion("",entity,resultSet,listColumns,deepLoadType);
					
					//entity.setOpcionOriginal( new Opcion());
					//entity.setOpcionOriginal(super.getEntity("",entity.getOpcionOriginal(),resultSet,OpcionDataAccess.ISWITHSCHEMA));         		
					//entity.setOpcionOriginal(this.getEntityOpcion("",entity.getOpcionOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseOpcion(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarOpcion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static Opcion getEntityOpcion(String strPrefijo,Opcion entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = Opcion.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = Opcion.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					OpcionDataAccess.setFieldReflectionOpcion(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasOpcion=OpcionConstantesFunciones.getTodosTiposColumnasOpcion();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasOpcion) {
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
							field = Opcion.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = Opcion.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						OpcionDataAccess.setFieldReflectionOpcion(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionOpcion(Field field,String strPrefijo,String sColumn,Opcion entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case OpcionConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case OpcionConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case OpcionConstantesFunciones.IDSISTEMA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case OpcionConstantesFunciones.IDMODULO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case OpcionConstantesFunciones.IDGRUPOOPCION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case OpcionConstantesFunciones.IDOPCION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case OpcionConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case OpcionConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case OpcionConstantesFunciones.IDTIPOTECLAMASCARA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case OpcionConstantesFunciones.TECLA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case OpcionConstantesFunciones.POSICION:
					field.set(entity,resultSet.getShort(sCampo));
					break;
				
				case OpcionConstantesFunciones.ICONNAME:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case OpcionConstantesFunciones.NOMBRECLASE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case OpcionConstantesFunciones.SUBMODULO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case OpcionConstantesFunciones.PAQUETE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case OpcionConstantesFunciones.PAQUETEORIGINAL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case OpcionConstantesFunciones.PATHAUXILIAR:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case OpcionConstantesFunciones.ESPARAMENU:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case OpcionConstantesFunciones.CONMOSTRARACCIONESCAMPO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case OpcionConstantesFunciones.ESGUARDARRELACIONES:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case OpcionConstantesFunciones.ESTADO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Opcion>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<Opcion> entities = new  ArrayList<Opcion>();
		Opcion entity = new Opcion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=OpcionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=OpcionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,OpcionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new Opcion();
					entity=super.getEntity("",entity,resultSet,OpcionDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityOpcion("",entity,resultSet);
					
					entity.setOpcionOriginal( new Opcion());
					entity.setOpcionOriginal(super.getEntity("",entity.getOpcionOriginal(),resultSet,OpcionDataAccess.ISWITHSCHEMA));         		
					entity.setOpcionOriginal(this.getEntityOpcion("",entity.getOpcionOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseOpcions(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarOpcion(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Opcion>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<Opcion> entities = new  ArrayList<Opcion>();
		Opcion entity = new Opcion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=OpcionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=OpcionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,OpcionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<Opcion> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Opcion> entities = new  ArrayList<Opcion>();
		Opcion entity = new Opcion();		  
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
	
	public  List<Opcion> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Opcion> entities = new  ArrayList<Opcion>();
		Opcion entity = new Opcion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Opcion();
      	    	entity=super.getEntity("",entity,resultSet,OpcionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityOpcion("",entity,resultSet);
      	    	
				entity.setOpcionOriginal( new Opcion());
      	    	entity.setOpcionOriginal(super.getEntity("",entity.getOpcionOriginal(),resultSet,OpcionDataAccess.ISWITHSCHEMA));         		
      	    	entity.setOpcionOriginal(this.getEntityOpcion("",entity.getOpcionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseOpcions(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarOpcion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Opcion> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Opcion> entities = new  ArrayList<Opcion>();
		Opcion entity = new Opcion();		  
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
	
	public  List<Opcion> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Opcion> entities = new  ArrayList<Opcion>();
		Opcion entity = new Opcion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Opcion();
      	    	entity=super.getEntity("",entity,resultSet,OpcionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityOpcion("",entity,resultSet);
      	    	
				entity.setOpcionOriginal( new Opcion());
      	    	entity.setOpcionOriginal(super.getEntity("",entity.getOpcionOriginal(),resultSet,OpcionDataAccess.ISWITHSCHEMA));         		
      	    	entity.setOpcionOriginal(this.getEntityOpcion("",entity.getOpcionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseOpcions(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public Opcion getEntityOpcion(String strPrefijo,Opcion entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_sistema(resultSet.getLong(strPrefijo+OpcionConstantesFunciones.IDSISTEMA));
				entity.setid_modulo(resultSet.getLong(strPrefijo+OpcionConstantesFunciones.IDMODULO));
				entity.setid_grupo_opcion(resultSet.getLong(strPrefijo+OpcionConstantesFunciones.IDGRUPOOPCION));if(resultSet.wasNull()) {entity.setid_grupo_opcion(null); }
				entity.setid_opcion(resultSet.getLong(strPrefijo+OpcionConstantesFunciones.IDOPCION));if(resultSet.wasNull()) {entity.setid_opcion(null); }
				entity.setcodigo(resultSet.getString(strPrefijo+OpcionConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+OpcionConstantesFunciones.NOMBRE));
				entity.setid_tipo_tecla_mascara(resultSet.getLong(strPrefijo+OpcionConstantesFunciones.IDTIPOTECLAMASCARA));
				entity.settecla(resultSet.getString(strPrefijo+OpcionConstantesFunciones.TECLA));
				entity.setposicion(resultSet.getShort(strPrefijo+OpcionConstantesFunciones.POSICION));
				entity.seticon_name(resultSet.getString(strPrefijo+OpcionConstantesFunciones.ICONNAME));
				entity.setnombre_clase(resultSet.getString(strPrefijo+OpcionConstantesFunciones.NOMBRECLASE));
				entity.setsub_modulo(resultSet.getString(strPrefijo+OpcionConstantesFunciones.SUBMODULO));
				entity.setpaquete(resultSet.getString(strPrefijo+OpcionConstantesFunciones.PAQUETE));
				entity.setpaquete_original(resultSet.getString(strPrefijo+OpcionConstantesFunciones.PAQUETEORIGINAL));
				entity.setpath_auxiliar(resultSet.getString(strPrefijo+OpcionConstantesFunciones.PATHAUXILIAR));
				entity.setes_para_menu(resultSet.getBoolean(strPrefijo+OpcionConstantesFunciones.ESPARAMENU));
				entity.setcon_mostrar_acciones_campo(resultSet.getBoolean(strPrefijo+OpcionConstantesFunciones.CONMOSTRARACCIONESCAMPO));
				entity.setes_guardar_relaciones(resultSet.getBoolean(strPrefijo+OpcionConstantesFunciones.ESGUARDARRELACIONES));
				entity.setestado(resultSet.getBoolean(strPrefijo+OpcionConstantesFunciones.ESTADO));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+OpcionConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowOpcion(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(Opcion entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=OpcionDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=OpcionDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=OpcionDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=OpcionDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(OpcionConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,OpcionDataAccess.TABLENAME,OpcionDataAccess.ISWITHSTOREPROCEDURES);
			
			OpcionDataAccess.setOpcionOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Sistema getSistema(Connexion connexion,Opcion relopcion)throws SQLException,Exception {

		Sistema sistema= new Sistema();

		try {
			SistemaDataAccess sistemaDataAccess=new SistemaDataAccess();

			sistemaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sistemaDataAccess.setConnexionType(this.connexionType);
			sistemaDataAccess.setParameterDbType(this.parameterDbType);

			sistema=sistemaDataAccess.getEntity(connexion,relopcion.getid_sistema());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sistema;

	}

	public Modulo getModulo(Connexion connexion,Opcion relopcion)throws SQLException,Exception {

		Modulo modulo= new Modulo();

		try {
			ModuloDataAccess moduloDataAccess=new ModuloDataAccess();

			moduloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			moduloDataAccess.setConnexionType(this.connexionType);
			moduloDataAccess.setParameterDbType(this.parameterDbType);

			modulo=moduloDataAccess.getEntity(connexion,relopcion.getid_modulo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return modulo;

	}

	public GrupoOpcion getGrupoOpcion(Connexion connexion,Opcion relopcion)throws SQLException,Exception {

		GrupoOpcion grupoopcion= new GrupoOpcion();

		try {
			GrupoOpcionDataAccess grupoopcionDataAccess=new GrupoOpcionDataAccess();

			grupoopcionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			grupoopcionDataAccess.setConnexionType(this.connexionType);
			grupoopcionDataAccess.setParameterDbType(this.parameterDbType);

			grupoopcion=grupoopcionDataAccess.getEntity(connexion,relopcion.getid_grupo_opcion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return grupoopcion;

	}

	public Opcion getOpcion(Connexion connexion,Opcion relopcion)throws SQLException,Exception {

		Opcion opcion= new Opcion();

		try {
			OpcionDataAccess opcionDataAccess=new OpcionDataAccess();

			opcionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			opcionDataAccess.setConnexionType(this.connexionType);
			opcionDataAccess.setParameterDbType(this.parameterDbType);

			opcion=opcionDataAccess.getEntity(connexion,relopcion.getid_opcion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return opcion;

	}

	public TipoTeclaMascara getTipoTeclaMascara(Connexion connexion,Opcion relopcion)throws SQLException,Exception {

		TipoTeclaMascara tipoteclamascara= new TipoTeclaMascara();

		try {
			TipoTeclaMascaraDataAccess tipoteclamascaraDataAccess=new TipoTeclaMascaraDataAccess();

			tipoteclamascaraDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoteclamascaraDataAccess.setConnexionType(this.connexionType);
			tipoteclamascaraDataAccess.setParameterDbType(this.parameterDbType);

			tipoteclamascara=tipoteclamascaraDataAccess.getEntity(connexion,relopcion.getid_tipo_tecla_mascara());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoteclamascara;

	}


		
		public List<UsuarioOpcion> getUsuarioOpcions(Connexion connexion,Opcion opcion)throws SQLException,Exception {

		List<UsuarioOpcion> usuarioopcions= new ArrayList<UsuarioOpcion>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+OpcionConstantesFunciones.SCHEMA+".opcion ON "+UsuarioOpcionConstantesFunciones.SCHEMA+".usuario_opcion.id_opcion="+OpcionConstantesFunciones.SCHEMA+".opcion.id WHERE "+OpcionConstantesFunciones.SCHEMA+".opcion.id="+String.valueOf(opcion.getId());
			} else {
				sQuery=" INNER JOIN usuarioopcion.Opcion WHERE usuarioopcion.Opcion.id="+String.valueOf(opcion.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			UsuarioOpcionDataAccess usuarioopcionDataAccess=new UsuarioOpcionDataAccess();

			usuarioopcionDataAccess.setConnexionType(this.connexionType);
			usuarioopcionDataAccess.setParameterDbType(this.parameterDbType);
			usuarioopcions=usuarioopcionDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return usuarioopcions;

	}

	public List<Opcion> getOpcions(Connexion connexion,Opcion opcion)throws SQLException,Exception {

		List<Opcion> opcions= new ArrayList<Opcion>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+OpcionConstantesFunciones.SCHEMA+".opcion ON "+OpcionConstantesFunciones.SCHEMA+".opcion.id_opcion="+OpcionConstantesFunciones.SCHEMA+".opcion.id WHERE "+OpcionConstantesFunciones.SCHEMA+".opcion.id="+String.valueOf(opcion.getId());
			} else {
				sQuery=" INNER JOIN opcion.Opcion WHERE opcion.Opcion.id="+String.valueOf(opcion.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			OpcionDataAccess opcionDataAccess=new OpcionDataAccess();

			opcionDataAccess.setConnexionType(this.connexionType);
			opcionDataAccess.setParameterDbType(this.parameterDbType);
			opcions=opcionDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return opcions;

	}

	public List<Accion> getAccions(Connexion connexion,Opcion opcion)throws SQLException,Exception {

		List<Accion> accions= new ArrayList<Accion>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+OpcionConstantesFunciones.SCHEMA+".opcion ON "+AccionConstantesFunciones.SCHEMA+".accion.id_opcion="+OpcionConstantesFunciones.SCHEMA+".opcion.id WHERE "+OpcionConstantesFunciones.SCHEMA+".opcion.id="+String.valueOf(opcion.getId());
			} else {
				sQuery=" INNER JOIN accion.Opcion WHERE accion.Opcion.id="+String.valueOf(opcion.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			AccionDataAccess accionDataAccess=new AccionDataAccess();

			accionDataAccess.setConnexionType(this.connexionType);
			accionDataAccess.setParameterDbType(this.parameterDbType);
			accions=accionDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return accions;

	}

	public List<PerfilOpcion> getPerfilOpcions(Connexion connexion,Opcion opcion)throws SQLException,Exception {

		List<PerfilOpcion> perfilopcions= new ArrayList<PerfilOpcion>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+OpcionConstantesFunciones.SCHEMA+".opcion ON "+PerfilOpcionConstantesFunciones.SCHEMA+".perfil_opcion.id_opcion="+OpcionConstantesFunciones.SCHEMA+".opcion.id WHERE "+OpcionConstantesFunciones.SCHEMA+".opcion.id="+String.valueOf(opcion.getId());
			} else {
				sQuery=" INNER JOIN perfilopcion.Opcion WHERE perfilopcion.Opcion.id="+String.valueOf(opcion.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PerfilOpcionDataAccess perfilopcionDataAccess=new PerfilOpcionDataAccess();

			perfilopcionDataAccess.setConnexionType(this.connexionType);
			perfilopcionDataAccess.setParameterDbType(this.parameterDbType);
			perfilopcions=perfilopcionDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return perfilopcions;

	}

	public List<Campo> getCampos(Connexion connexion,Opcion opcion)throws SQLException,Exception {

		List<Campo> campos= new ArrayList<Campo>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+OpcionConstantesFunciones.SCHEMA+".opcion ON "+CampoConstantesFunciones.SCHEMA+".campo.id_opcion="+OpcionConstantesFunciones.SCHEMA+".opcion.id WHERE "+OpcionConstantesFunciones.SCHEMA+".opcion.id="+String.valueOf(opcion.getId());
			} else {
				sQuery=" INNER JOIN campo.Opcion WHERE campo.Opcion.id="+String.valueOf(opcion.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			CampoDataAccess campoDataAccess=new CampoDataAccess();

			campoDataAccess.setConnexionType(this.connexionType);
			campoDataAccess.setParameterDbType(this.parameterDbType);
			campos=campoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return campos;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,Opcion opcion) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!opcion.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sistema=new ParameterValue<Long>();
					parameterMaintenanceValueid_sistema.setValue(opcion.getid_sistema());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sistema);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_modulo=new ParameterValue<Long>();
					parameterMaintenanceValueid_modulo.setValue(opcion.getid_modulo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_modulo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_grupo_opcion=new ParameterValue<Long>();
					parameterMaintenanceValueid_grupo_opcion.setValue(opcion.getid_grupo_opcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_grupo_opcion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_opcion=new ParameterValue<Long>();
					parameterMaintenanceValueid_opcion.setValue(opcion.getid_opcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_opcion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(opcion.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(opcion.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_tecla_mascara=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_tecla_mascara.setValue(opcion.getid_tipo_tecla_mascara());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_tecla_mascara);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuetecla=new ParameterValue<String>();
					parameterMaintenanceValuetecla.setValue(opcion.gettecla());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetecla);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.SHORT);
					ParameterValue<Short> parameterMaintenanceValueposicion=new ParameterValue<Short>();
					parameterMaintenanceValueposicion.setValue(opcion.getposicion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueposicion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueicon_name=new ParameterValue<String>();
					parameterMaintenanceValueicon_name.setValue(opcion.geticon_name());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueicon_name);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre_clase=new ParameterValue<String>();
					parameterMaintenanceValuenombre_clase.setValue(opcion.getnombre_clase());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre_clase);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuesub_modulo=new ParameterValue<String>();
					parameterMaintenanceValuesub_modulo.setValue(opcion.getsub_modulo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesub_modulo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuepaquete=new ParameterValue<String>();
					parameterMaintenanceValuepaquete.setValue(opcion.getpaquete());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuepaquete);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuepaquete_original=new ParameterValue<String>();
					parameterMaintenanceValuepaquete_original.setValue(opcion.getpaquete_original());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuepaquete_original);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuepath_auxiliar=new ParameterValue<String>();
					parameterMaintenanceValuepath_auxiliar.setValue(opcion.getpath_auxiliar());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuepath_auxiliar);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_para_menu=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_para_menu.setValue(opcion.getes_para_menu());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_para_menu);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_mostrar_acciones_campo=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_mostrar_acciones_campo.setValue(opcion.getcon_mostrar_acciones_campo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_mostrar_acciones_campo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_guardar_relaciones=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_guardar_relaciones.setValue(opcion.getes_guardar_relaciones());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_guardar_relaciones);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValueestado=new ParameterValue<Boolean>();
					parameterMaintenanceValueestado.setValue(opcion.getestado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueestado);
					parametersTemp.add(parameterMaintenance);
					
						if(!opcion.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(opcion.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(opcion.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(opcion.getId());
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
	
	public void setIsNewIsChangedFalseOpcion(Opcion opcion)throws Exception  {		
		opcion.setIsNew(false);
		opcion.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseOpcions(List<Opcion> opcions)throws Exception  {				
		for(Opcion opcion:opcions) {
			opcion.setIsNew(false);
			opcion.setIsChanged(false);
		}
	}
	
	public void generarExportarOpcion(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
