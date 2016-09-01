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
import com.bydan.erp.seguridad.util.*;//PerfilOpcionConstantesFunciones;










@SuppressWarnings("unused")
final public class PerfilOpcionDataAccess extends  PerfilOpcionDataAccessAdditional{ //PerfilOpcionDataAccessAdditional,DataAccessHelper<PerfilOpcion>
	//static Logger logger = Logger.getLogger(PerfilOpcionDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="perfil_opcion";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+PerfilOpcionConstantesFunciones.SCHEMA+"."+PerfilOpcionConstantesFunciones.TABLENAME+"(version_row,id_sistema,id_modulo,id_grupo_opcion,id_perfil,id_opcion,todo,ingreso,modificacion,eliminacion,guardar_cambios,consulta,busqueda,reporte,orden,paginacion_medio,paginacion_alto,paginacion_todo,duplicar,copiar,con_precargar,estado)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+PerfilOpcionConstantesFunciones.SCHEMA+"."+PerfilOpcionConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_sistema=?,id_modulo=?,id_grupo_opcion=?,id_perfil=?,id_opcion=?,todo=?,ingreso=?,modificacion=?,eliminacion=?,guardar_cambios=?,consulta=?,busqueda=?,reporte=?,orden=?,paginacion_medio=?,paginacion_alto=?,paginacion_todo=?,duplicar=?,copiar=?,con_precargar=?,estado=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+PerfilOpcionConstantesFunciones.SCHEMA+"."+PerfilOpcionConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select perfilopcion from "+PerfilOpcionConstantesFunciones.SPERSISTENCENAME+" perfilopcion";
	public static String QUERYSELECTNATIVE="select "+PerfilOpcionConstantesFunciones.SCHEMA+"."+PerfilOpcionConstantesFunciones.TABLENAME+".id,"+PerfilOpcionConstantesFunciones.SCHEMA+"."+PerfilOpcionConstantesFunciones.TABLENAME+".version_row,"+PerfilOpcionConstantesFunciones.SCHEMA+"."+PerfilOpcionConstantesFunciones.TABLENAME+".id_sistema,"+PerfilOpcionConstantesFunciones.SCHEMA+"."+PerfilOpcionConstantesFunciones.TABLENAME+".id_modulo,"+PerfilOpcionConstantesFunciones.SCHEMA+"."+PerfilOpcionConstantesFunciones.TABLENAME+".id_grupo_opcion,"+PerfilOpcionConstantesFunciones.SCHEMA+"."+PerfilOpcionConstantesFunciones.TABLENAME+".id_perfil,"+PerfilOpcionConstantesFunciones.SCHEMA+"."+PerfilOpcionConstantesFunciones.TABLENAME+".id_opcion,"+PerfilOpcionConstantesFunciones.SCHEMA+"."+PerfilOpcionConstantesFunciones.TABLENAME+".todo,"+PerfilOpcionConstantesFunciones.SCHEMA+"."+PerfilOpcionConstantesFunciones.TABLENAME+".ingreso,"+PerfilOpcionConstantesFunciones.SCHEMA+"."+PerfilOpcionConstantesFunciones.TABLENAME+".modificacion,"+PerfilOpcionConstantesFunciones.SCHEMA+"."+PerfilOpcionConstantesFunciones.TABLENAME+".eliminacion,"+PerfilOpcionConstantesFunciones.SCHEMA+"."+PerfilOpcionConstantesFunciones.TABLENAME+".guardar_cambios,"+PerfilOpcionConstantesFunciones.SCHEMA+"."+PerfilOpcionConstantesFunciones.TABLENAME+".consulta,"+PerfilOpcionConstantesFunciones.SCHEMA+"."+PerfilOpcionConstantesFunciones.TABLENAME+".busqueda,"+PerfilOpcionConstantesFunciones.SCHEMA+"."+PerfilOpcionConstantesFunciones.TABLENAME+".reporte,"+PerfilOpcionConstantesFunciones.SCHEMA+"."+PerfilOpcionConstantesFunciones.TABLENAME+".orden,"+PerfilOpcionConstantesFunciones.SCHEMA+"."+PerfilOpcionConstantesFunciones.TABLENAME+".paginacion_medio,"+PerfilOpcionConstantesFunciones.SCHEMA+"."+PerfilOpcionConstantesFunciones.TABLENAME+".paginacion_alto,"+PerfilOpcionConstantesFunciones.SCHEMA+"."+PerfilOpcionConstantesFunciones.TABLENAME+".paginacion_todo,"+PerfilOpcionConstantesFunciones.SCHEMA+"."+PerfilOpcionConstantesFunciones.TABLENAME+".duplicar,"+PerfilOpcionConstantesFunciones.SCHEMA+"."+PerfilOpcionConstantesFunciones.TABLENAME+".copiar,"+PerfilOpcionConstantesFunciones.SCHEMA+"."+PerfilOpcionConstantesFunciones.TABLENAME+".con_precargar,"+PerfilOpcionConstantesFunciones.SCHEMA+"."+PerfilOpcionConstantesFunciones.TABLENAME+".estado from "+PerfilOpcionConstantesFunciones.SCHEMA+"."+PerfilOpcionConstantesFunciones.TABLENAME;//+" as "+PerfilOpcionConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+PerfilOpcionConstantesFunciones.SCHEMA+"."+PerfilOpcionConstantesFunciones.TABLENAME+".id,"+PerfilOpcionConstantesFunciones.SCHEMA+"."+PerfilOpcionConstantesFunciones.TABLENAME+".version_row from "+PerfilOpcionConstantesFunciones.SCHEMA+"."+PerfilOpcionConstantesFunciones.TABLENAME;//+" as "+PerfilOpcionConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+PerfilOpcionConstantesFunciones.SCHEMA+"."+PerfilOpcionConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_sistema=?,id_modulo=?,id_grupo_opcion=?,id_perfil=?,id_opcion=?,todo=?,ingreso=?,modificacion=?,eliminacion=?,guardar_cambios=?,consulta=?,busqueda=?,reporte=?,orden=?,paginacion_medio=?,paginacion_alto=?,paginacion_todo=?,duplicar=?,copiar=?,con_precargar=?,estado=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PERFILOPCION_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PERFILOPCION_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PERFILOPCION_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PERFILOPCION_SELECT(?,?)";
	
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
	
	
	protected PerfilOpcionDataAccessAdditional perfilopcionDataAccessAdditional=null;
	
	public PerfilOpcionDataAccessAdditional getPerfilOpcionDataAccessAdditional() {
		return this.perfilopcionDataAccessAdditional;
	}
	
	public void setPerfilOpcionDataAccessAdditional(PerfilOpcionDataAccessAdditional perfilopcionDataAccessAdditional) {
		try {
			this.perfilopcionDataAccessAdditional=perfilopcionDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public PerfilOpcionDataAccess() {
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
		PerfilOpcionDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		PerfilOpcionDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		PerfilOpcionDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setPerfilOpcionOriginal(PerfilOpcion perfilopcion)throws Exception  {
		perfilopcion.setPerfilOpcionOriginal((PerfilOpcion)perfilopcion.clone());		
	}
	
	public void setPerfilOpcionsOriginal(List<PerfilOpcion> perfilopcions)throws Exception  {
		
		for(PerfilOpcion perfilopcion:perfilopcions){
			perfilopcion.setPerfilOpcionOriginal((PerfilOpcion)perfilopcion.clone());
		}
	}
	
	public static void setPerfilOpcionOriginalStatic(PerfilOpcion perfilopcion)throws Exception  {
		perfilopcion.setPerfilOpcionOriginal((PerfilOpcion)perfilopcion.clone());		
	}
	
	public static void setPerfilOpcionsOriginalStatic(List<PerfilOpcion> perfilopcions)throws Exception  {
		
		for(PerfilOpcion perfilopcion:perfilopcions){
			perfilopcion.setPerfilOpcionOriginal((PerfilOpcion)perfilopcion.clone());
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
	
	public  PerfilOpcion getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		PerfilOpcion entity = new PerfilOpcion();		
		
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
	
	public  PerfilOpcion getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		PerfilOpcion entity = new PerfilOpcion();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PerfilOpcionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PerfilOpcionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Seguridad.PerfilOpcion.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setPerfilOpcionOriginal(new PerfilOpcion());
      	    	entity=super.getEntity("",entity,resultSet,PerfilOpcionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPerfilOpcion("",entity,resultSet); 
				
				entity.setPerfilOpcionOriginal(super.getEntity("",entity.getPerfilOpcionOriginal(),resultSet,PerfilOpcionDataAccess.ISWITHSCHEMA));         		
      	    	entity.setPerfilOpcionOriginal(this.getEntityPerfilOpcion("",entity.getPerfilOpcionOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalsePerfilOpcion(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  PerfilOpcion getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		PerfilOpcion entity = new PerfilOpcion();
				
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
	
	public  PerfilOpcion getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		PerfilOpcion entity = new PerfilOpcion();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PerfilOpcionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PerfilOpcionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PerfilOpcionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Seguridad.PerfilOpcion.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setPerfilOpcionOriginal(new PerfilOpcion());
      	    	entity=super.getEntity("",entity,resultSet,PerfilOpcionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPerfilOpcion("",entity,resultSet);    
				
				entity.setPerfilOpcionOriginal(super.getEntity("",entity.getPerfilOpcionOriginal(),resultSet,PerfilOpcionDataAccess.ISWITHSCHEMA));         		
      	    	entity.setPerfilOpcionOriginal(this.getEntityPerfilOpcion("",entity.getPerfilOpcionOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalsePerfilOpcion(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //PerfilOpcion
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		PerfilOpcion entity = new PerfilOpcion();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PerfilOpcionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PerfilOpcionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PerfilOpcionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Seguridad.PerfilOpcion.isActive=1
        	 
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
				//this.setIsNewIsChangedFalsePerfilOpcion(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<PerfilOpcion> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<PerfilOpcion> entities = new  ArrayList<PerfilOpcion>();
		PerfilOpcion entity = new PerfilOpcion();		  
		
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
	
	public  List<PerfilOpcion> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<PerfilOpcion> entities = new  ArrayList<PerfilOpcion>();
		PerfilOpcion entity = new PerfilOpcion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=PerfilOpcionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PerfilOpcionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PerfilOpcionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PerfilOpcion();
      	    	entity=super.getEntity("",entity,resultSet,PerfilOpcionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPerfilOpcion("",entity,resultSet);
      	    	
				entity.setPerfilOpcionOriginal( new PerfilOpcion());
      	    	entity.setPerfilOpcionOriginal(super.getEntity("",entity.getPerfilOpcionOriginal(),resultSet,PerfilOpcionDataAccess.ISWITHSCHEMA));         		
      	    	entity.setPerfilOpcionOriginal(this.getEntityPerfilOpcion("",entity.getPerfilOpcionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePerfilOpcions(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPerfilOpcion(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<PerfilOpcion> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<PerfilOpcion> entities = new  ArrayList<PerfilOpcion>();
		PerfilOpcion entity = new PerfilOpcion();		  
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
	
	public  List<PerfilOpcion> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<PerfilOpcion> entities = new  ArrayList<PerfilOpcion>();
		PerfilOpcion entity = new PerfilOpcion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PerfilOpcion();
				
				if(conMapGenerico) {
					entity.inicializarMapPerfilOpcion();
					//entity.setMapPerfilOpcion(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapPerfilOpcionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPerfilOpcion().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PerfilOpcionDataAccess.ISWITHSCHEMA);         		
					entity=PerfilOpcionDataAccess.getEntityPerfilOpcion("",entity,resultSet,listColumns,deepLoadType);
					
					//entity.setPerfilOpcionOriginal( new PerfilOpcion());
					//entity.setPerfilOpcionOriginal(super.getEntity("",entity.getPerfilOpcionOriginal(),resultSet,PerfilOpcionDataAccess.ISWITHSCHEMA));         		
					//entity.setPerfilOpcionOriginal(this.getEntityPerfilOpcion("",entity.getPerfilOpcionOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePerfilOpcions(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPerfilOpcion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public PerfilOpcion getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		PerfilOpcion entity = new PerfilOpcion();		  
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
	
	public  PerfilOpcion getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		PerfilOpcion entity = new PerfilOpcion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PerfilOpcion();
				
				if(conMapGenerico) {
					entity.inicializarMapPerfilOpcion();
					//entity.setMapPerfilOpcion(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapPerfilOpcionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPerfilOpcion().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PerfilOpcionDataAccess.ISWITHSCHEMA);         		
					entity=PerfilOpcionDataAccess.getEntityPerfilOpcion("",entity,resultSet,listColumns,deepLoadType);
					
					//entity.setPerfilOpcionOriginal( new PerfilOpcion());
					//entity.setPerfilOpcionOriginal(super.getEntity("",entity.getPerfilOpcionOriginal(),resultSet,PerfilOpcionDataAccess.ISWITHSCHEMA));         		
					//entity.setPerfilOpcionOriginal(this.getEntityPerfilOpcion("",entity.getPerfilOpcionOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalsePerfilOpcion(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPerfilOpcion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static PerfilOpcion getEntityPerfilOpcion(String strPrefijo,PerfilOpcion entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = PerfilOpcion.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = PerfilOpcion.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					PerfilOpcionDataAccess.setFieldReflectionPerfilOpcion(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasPerfilOpcion=PerfilOpcionConstantesFunciones.getTodosTiposColumnasPerfilOpcion();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasPerfilOpcion) {
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
							field = PerfilOpcion.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = PerfilOpcion.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						PerfilOpcionDataAccess.setFieldReflectionPerfilOpcion(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionPerfilOpcion(Field field,String strPrefijo,String sColumn,PerfilOpcion entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case PerfilOpcionConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PerfilOpcionConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PerfilOpcionConstantesFunciones.IDSISTEMA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PerfilOpcionConstantesFunciones.IDMODULO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PerfilOpcionConstantesFunciones.IDGRUPOOPCION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PerfilOpcionConstantesFunciones.IDPERFIL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PerfilOpcionConstantesFunciones.IDOPCION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PerfilOpcionConstantesFunciones.TODO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case PerfilOpcionConstantesFunciones.INGRESO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case PerfilOpcionConstantesFunciones.MODIFICACION:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case PerfilOpcionConstantesFunciones.ELIMINACION:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case PerfilOpcionConstantesFunciones.GUARDARCAMBIOS:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case PerfilOpcionConstantesFunciones.CONSULTA:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case PerfilOpcionConstantesFunciones.BUSQUEDA:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case PerfilOpcionConstantesFunciones.REPORTE:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case PerfilOpcionConstantesFunciones.ORDEN:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case PerfilOpcionConstantesFunciones.PAGINACIONMEDIO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case PerfilOpcionConstantesFunciones.PAGINACIONALTO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case PerfilOpcionConstantesFunciones.PAGINACIONTODO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case PerfilOpcionConstantesFunciones.DUPLICAR:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case PerfilOpcionConstantesFunciones.COPIAR:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case PerfilOpcionConstantesFunciones.CONPRECARGAR:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case PerfilOpcionConstantesFunciones.ESTADO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<PerfilOpcion>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<PerfilOpcion> entities = new  ArrayList<PerfilOpcion>();
		PerfilOpcion entity = new PerfilOpcion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PerfilOpcionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PerfilOpcionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PerfilOpcionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new PerfilOpcion();
					entity=super.getEntity("",entity,resultSet,PerfilOpcionDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityPerfilOpcion("",entity,resultSet);
					
					entity.setPerfilOpcionOriginal( new PerfilOpcion());
					entity.setPerfilOpcionOriginal(super.getEntity("",entity.getPerfilOpcionOriginal(),resultSet,PerfilOpcionDataAccess.ISWITHSCHEMA));         		
					entity.setPerfilOpcionOriginal(this.getEntityPerfilOpcion("",entity.getPerfilOpcionOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalsePerfilOpcions(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPerfilOpcion(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<PerfilOpcion>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<PerfilOpcion> entities = new  ArrayList<PerfilOpcion>();
		PerfilOpcion entity = new PerfilOpcion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PerfilOpcionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PerfilOpcionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PerfilOpcionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<PerfilOpcion> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PerfilOpcion> entities = new  ArrayList<PerfilOpcion>();
		PerfilOpcion entity = new PerfilOpcion();		  
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
	
	public  List<PerfilOpcion> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PerfilOpcion> entities = new  ArrayList<PerfilOpcion>();
		PerfilOpcion entity = new PerfilOpcion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PerfilOpcion();
      	    	entity=super.getEntity("",entity,resultSet,PerfilOpcionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPerfilOpcion("",entity,resultSet);
      	    	
				entity.setPerfilOpcionOriginal( new PerfilOpcion());
      	    	entity.setPerfilOpcionOriginal(super.getEntity("",entity.getPerfilOpcionOriginal(),resultSet,PerfilOpcionDataAccess.ISWITHSCHEMA));         		
      	    	entity.setPerfilOpcionOriginal(this.getEntityPerfilOpcion("",entity.getPerfilOpcionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalsePerfilOpcions(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPerfilOpcion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<PerfilOpcion> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PerfilOpcion> entities = new  ArrayList<PerfilOpcion>();
		PerfilOpcion entity = new PerfilOpcion();		  
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
	
	public  List<PerfilOpcion> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PerfilOpcion> entities = new  ArrayList<PerfilOpcion>();
		PerfilOpcion entity = new PerfilOpcion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PerfilOpcion();
      	    	entity=super.getEntity("",entity,resultSet,PerfilOpcionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPerfilOpcion("",entity,resultSet);
      	    	
				entity.setPerfilOpcionOriginal( new PerfilOpcion());
      	    	entity.setPerfilOpcionOriginal(super.getEntity("",entity.getPerfilOpcionOriginal(),resultSet,PerfilOpcionDataAccess.ISWITHSCHEMA));         		
      	    	entity.setPerfilOpcionOriginal(this.getEntityPerfilOpcion("",entity.getPerfilOpcionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePerfilOpcions(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public PerfilOpcion getEntityPerfilOpcion(String strPrefijo,PerfilOpcion entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_sistema(resultSet.getLong(strPrefijo+PerfilOpcionConstantesFunciones.IDSISTEMA));
				entity.setid_modulo(resultSet.getLong(strPrefijo+PerfilOpcionConstantesFunciones.IDMODULO));
				entity.setid_grupo_opcion(resultSet.getLong(strPrefijo+PerfilOpcionConstantesFunciones.IDGRUPOOPCION));if(resultSet.wasNull()) {entity.setid_grupo_opcion(null); }
				entity.setid_perfil(resultSet.getLong(strPrefijo+PerfilOpcionConstantesFunciones.IDPERFIL));
				entity.setid_opcion(resultSet.getLong(strPrefijo+PerfilOpcionConstantesFunciones.IDOPCION));
				entity.settodo(resultSet.getBoolean(strPrefijo+PerfilOpcionConstantesFunciones.TODO));
				entity.setingreso(resultSet.getBoolean(strPrefijo+PerfilOpcionConstantesFunciones.INGRESO));
				entity.setmodificacion(resultSet.getBoolean(strPrefijo+PerfilOpcionConstantesFunciones.MODIFICACION));
				entity.seteliminacion(resultSet.getBoolean(strPrefijo+PerfilOpcionConstantesFunciones.ELIMINACION));
				entity.setguardar_cambios(resultSet.getBoolean(strPrefijo+PerfilOpcionConstantesFunciones.GUARDARCAMBIOS));
				entity.setconsulta(resultSet.getBoolean(strPrefijo+PerfilOpcionConstantesFunciones.CONSULTA));
				entity.setbusqueda(resultSet.getBoolean(strPrefijo+PerfilOpcionConstantesFunciones.BUSQUEDA));
				entity.setreporte(resultSet.getBoolean(strPrefijo+PerfilOpcionConstantesFunciones.REPORTE));
				entity.setorden(resultSet.getBoolean(strPrefijo+PerfilOpcionConstantesFunciones.ORDEN));
				entity.setpaginacion_medio(resultSet.getBoolean(strPrefijo+PerfilOpcionConstantesFunciones.PAGINACIONMEDIO));
				entity.setpaginacion_alto(resultSet.getBoolean(strPrefijo+PerfilOpcionConstantesFunciones.PAGINACIONALTO));
				entity.setpaginacion_todo(resultSet.getBoolean(strPrefijo+PerfilOpcionConstantesFunciones.PAGINACIONTODO));
				entity.setduplicar(resultSet.getBoolean(strPrefijo+PerfilOpcionConstantesFunciones.DUPLICAR));
				entity.setcopiar(resultSet.getBoolean(strPrefijo+PerfilOpcionConstantesFunciones.COPIAR));
				entity.setcon_precargar(resultSet.getBoolean(strPrefijo+PerfilOpcionConstantesFunciones.CONPRECARGAR));
				entity.setestado(resultSet.getBoolean(strPrefijo+PerfilOpcionConstantesFunciones.ESTADO));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowPerfilOpcion(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(PerfilOpcion entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=PerfilOpcionDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=PerfilOpcionDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=PerfilOpcionDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=PerfilOpcionDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(PerfilOpcionConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,PerfilOpcionDataAccess.TABLENAME,PerfilOpcionDataAccess.ISWITHSTOREPROCEDURES);
			
			PerfilOpcionDataAccess.setPerfilOpcionOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Sistema getSistema(Connexion connexion,PerfilOpcion relperfilopcion)throws SQLException,Exception {

		Sistema sistema= new Sistema();

		try {
			SistemaDataAccess sistemaDataAccess=new SistemaDataAccess();

			sistemaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sistemaDataAccess.setConnexionType(this.connexionType);
			sistemaDataAccess.setParameterDbType(this.parameterDbType);

			sistema=sistemaDataAccess.getEntity(connexion,relperfilopcion.getid_sistema());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sistema;

	}

	public Modulo getModulo(Connexion connexion,PerfilOpcion relperfilopcion)throws SQLException,Exception {

		Modulo modulo= new Modulo();

		try {
			ModuloDataAccess moduloDataAccess=new ModuloDataAccess();

			moduloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			moduloDataAccess.setConnexionType(this.connexionType);
			moduloDataAccess.setParameterDbType(this.parameterDbType);

			modulo=moduloDataAccess.getEntity(connexion,relperfilopcion.getid_modulo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return modulo;

	}

	public GrupoOpcion getGrupoOpcion(Connexion connexion,PerfilOpcion relperfilopcion)throws SQLException,Exception {

		GrupoOpcion grupoopcion= new GrupoOpcion();

		try {
			GrupoOpcionDataAccess grupoopcionDataAccess=new GrupoOpcionDataAccess();

			grupoopcionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			grupoopcionDataAccess.setConnexionType(this.connexionType);
			grupoopcionDataAccess.setParameterDbType(this.parameterDbType);

			grupoopcion=grupoopcionDataAccess.getEntity(connexion,relperfilopcion.getid_grupo_opcion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return grupoopcion;

	}

	public Perfil getPerfil(Connexion connexion,PerfilOpcion relperfilopcion)throws SQLException,Exception {

		Perfil perfil= new Perfil();

		try {
			PerfilDataAccess perfilDataAccess=new PerfilDataAccess();

			perfilDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			perfilDataAccess.setConnexionType(this.connexionType);
			perfilDataAccess.setParameterDbType(this.parameterDbType);

			perfil=perfilDataAccess.getEntity(connexion,relperfilopcion.getid_perfil());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return perfil;

	}

	public Opcion getOpcion(Connexion connexion,PerfilOpcion relperfilopcion)throws SQLException,Exception {

		Opcion opcion= new Opcion();

		try {
			OpcionDataAccess opcionDataAccess=new OpcionDataAccess();

			opcionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			opcionDataAccess.setConnexionType(this.connexionType);
			opcionDataAccess.setParameterDbType(this.parameterDbType);

			opcion=opcionDataAccess.getEntity(connexion,relperfilopcion.getid_opcion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return opcion;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,PerfilOpcion perfilopcion) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!perfilopcion.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sistema=new ParameterValue<Long>();
					parameterMaintenanceValueid_sistema.setValue(perfilopcion.getid_sistema());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sistema);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_modulo=new ParameterValue<Long>();
					parameterMaintenanceValueid_modulo.setValue(perfilopcion.getid_modulo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_modulo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_grupo_opcion=new ParameterValue<Long>();
					parameterMaintenanceValueid_grupo_opcion.setValue(perfilopcion.getid_grupo_opcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_grupo_opcion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_perfil=new ParameterValue<Long>();
					parameterMaintenanceValueid_perfil.setValue(perfilopcion.getid_perfil());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_perfil);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_opcion=new ParameterValue<Long>();
					parameterMaintenanceValueid_opcion.setValue(perfilopcion.getid_opcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_opcion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuetodo=new ParameterValue<Boolean>();
					parameterMaintenanceValuetodo.setValue(perfilopcion.gettodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValueingreso=new ParameterValue<Boolean>();
					parameterMaintenanceValueingreso.setValue(perfilopcion.getingreso());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueingreso);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuemodificacion=new ParameterValue<Boolean>();
					parameterMaintenanceValuemodificacion.setValue(perfilopcion.getmodificacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuemodificacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValueeliminacion=new ParameterValue<Boolean>();
					parameterMaintenanceValueeliminacion.setValue(perfilopcion.geteliminacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueeliminacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValueguardar_cambios=new ParameterValue<Boolean>();
					parameterMaintenanceValueguardar_cambios.setValue(perfilopcion.getguardar_cambios());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueguardar_cambios);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValueconsulta=new ParameterValue<Boolean>();
					parameterMaintenanceValueconsulta.setValue(perfilopcion.getconsulta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueconsulta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuebusqueda=new ParameterValue<Boolean>();
					parameterMaintenanceValuebusqueda.setValue(perfilopcion.getbusqueda());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuebusqueda);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuereporte=new ParameterValue<Boolean>();
					parameterMaintenanceValuereporte.setValue(perfilopcion.getreporte());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuereporte);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValueorden=new ParameterValue<Boolean>();
					parameterMaintenanceValueorden.setValue(perfilopcion.getorden());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueorden);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuepaginacion_medio=new ParameterValue<Boolean>();
					parameterMaintenanceValuepaginacion_medio.setValue(perfilopcion.getpaginacion_medio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuepaginacion_medio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuepaginacion_alto=new ParameterValue<Boolean>();
					parameterMaintenanceValuepaginacion_alto.setValue(perfilopcion.getpaginacion_alto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuepaginacion_alto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuepaginacion_todo=new ParameterValue<Boolean>();
					parameterMaintenanceValuepaginacion_todo.setValue(perfilopcion.getpaginacion_todo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuepaginacion_todo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValueduplicar=new ParameterValue<Boolean>();
					parameterMaintenanceValueduplicar.setValue(perfilopcion.getduplicar());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueduplicar);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecopiar=new ParameterValue<Boolean>();
					parameterMaintenanceValuecopiar.setValue(perfilopcion.getcopiar());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecopiar);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_precargar=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_precargar.setValue(perfilopcion.getcon_precargar());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_precargar);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValueestado=new ParameterValue<Boolean>();
					parameterMaintenanceValueestado.setValue(perfilopcion.getestado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueestado);
					parametersTemp.add(parameterMaintenance);
					
						if(!perfilopcion.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(perfilopcion.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(perfilopcion.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(perfilopcion.getId());
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
	
	public void setIsNewIsChangedFalsePerfilOpcion(PerfilOpcion perfilopcion)throws Exception  {		
		perfilopcion.setIsNew(false);
		perfilopcion.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalsePerfilOpcions(List<PerfilOpcion> perfilopcions)throws Exception  {				
		for(PerfilOpcion perfilopcion:perfilopcions) {
			perfilopcion.setIsNew(false);
			perfilopcion.setIsChanged(false);
		}
	}
	
	public void generarExportarPerfilOpcion(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
