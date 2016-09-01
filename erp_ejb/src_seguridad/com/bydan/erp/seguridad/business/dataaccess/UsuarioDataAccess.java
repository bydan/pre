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
import com.bydan.erp.seguridad.util.*;//UsuarioConstantesFunciones;


import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;


import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.sris.business.dataaccess.*;
import com.bydan.erp.importaciones.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.dataaccess.*;


import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.sris.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.activosfijos.util.*;




@SuppressWarnings("unused")
final public class UsuarioDataAccess extends  UsuarioDataAccessAdditional{ //UsuarioDataAccessAdditional,DataAccessHelper<Usuario>
	//static Logger logger = Logger.getLogger(UsuarioDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="usuario";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+UsuarioConstantesFunciones.SCHEMA+"."+UsuarioConstantesFunciones.TABLENAME+"(version_row,id_empresa,user_name,clave,confirmar_clave,nombre,codigo_alterno,tipo,estado)values(current_timestamp,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+UsuarioConstantesFunciones.SCHEMA+"."+UsuarioConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,user_name=?,clave=?,confirmar_clave=?,nombre=?,codigo_alterno=?,tipo=?,estado=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+UsuarioConstantesFunciones.SCHEMA+"."+UsuarioConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select usuario from "+UsuarioConstantesFunciones.SPERSISTENCENAME+" usuario";
	public static String QUERYSELECTNATIVE="select "+UsuarioConstantesFunciones.SCHEMA+"."+UsuarioConstantesFunciones.TABLENAME+".id,"+UsuarioConstantesFunciones.SCHEMA+"."+UsuarioConstantesFunciones.TABLENAME+".version_row,"+UsuarioConstantesFunciones.SCHEMA+"."+UsuarioConstantesFunciones.TABLENAME+".id_empresa,"+UsuarioConstantesFunciones.SCHEMA+"."+UsuarioConstantesFunciones.TABLENAME+".user_name,"+UsuarioConstantesFunciones.SCHEMA+"."+UsuarioConstantesFunciones.TABLENAME+".clave,"+UsuarioConstantesFunciones.SCHEMA+"."+UsuarioConstantesFunciones.TABLENAME+".confirmar_clave,"+UsuarioConstantesFunciones.SCHEMA+"."+UsuarioConstantesFunciones.TABLENAME+".nombre,"+UsuarioConstantesFunciones.SCHEMA+"."+UsuarioConstantesFunciones.TABLENAME+".codigo_alterno,"+UsuarioConstantesFunciones.SCHEMA+"."+UsuarioConstantesFunciones.TABLENAME+".tipo,"+UsuarioConstantesFunciones.SCHEMA+"."+UsuarioConstantesFunciones.TABLENAME+".estado from "+UsuarioConstantesFunciones.SCHEMA+"."+UsuarioConstantesFunciones.TABLENAME;//+" as "+UsuarioConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+UsuarioConstantesFunciones.SCHEMA+"."+UsuarioConstantesFunciones.TABLENAME+".id,"+UsuarioConstantesFunciones.SCHEMA+"."+UsuarioConstantesFunciones.TABLENAME+".version_row,"+UsuarioConstantesFunciones.SCHEMA+"."+UsuarioConstantesFunciones.TABLENAME+".user_name from "+UsuarioConstantesFunciones.SCHEMA+"."+UsuarioConstantesFunciones.TABLENAME;//+" as "+UsuarioConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+UsuarioConstantesFunciones.SCHEMA+"."+UsuarioConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,user_name=?,clave=?,confirmar_clave=?,nombre=?,codigo_alterno=?,tipo=?,estado=?";
	
	public static String STOREPROCEDUREINSERT="call SP_USUARIO_INSERT(?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_USUARIO_UPDATE(?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_USUARIO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_USUARIO_SELECT(?,?)";
	
	public static Boolean ISDELETECASCADE=true;
	public static boolean ISWITHSCHEMA=true;
	public static boolean ISWITHSTOREPROCEDURES=false;
	
	protected Boolean isForForeingKeyData=false;
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	
	
	private Object entityObject;
	
	private List<Object> entitiesObject;
	
	protected DatosCliente datosCliente;
	
	
	protected UsuarioDataAccessAdditional usuarioDataAccessAdditional=null;
	
	public UsuarioDataAccessAdditional getUsuarioDataAccessAdditional() {
		return this.usuarioDataAccessAdditional;
	}
	
	public void setUsuarioDataAccessAdditional(UsuarioDataAccessAdditional usuarioDataAccessAdditional) {
		try {
			this.usuarioDataAccessAdditional=usuarioDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public UsuarioDataAccess() {
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
		UsuarioDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		UsuarioDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		UsuarioDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setUsuarioOriginal(Usuario usuario)throws Exception  {
		usuario.setUsuarioOriginal((Usuario)usuario.clone());		
	}
	
	public void setUsuariosOriginal(List<Usuario> usuarios)throws Exception  {
		
		for(Usuario usuario:usuarios){
			usuario.setUsuarioOriginal((Usuario)usuario.clone());
		}
	}
	
	public static void setUsuarioOriginalStatic(Usuario usuario)throws Exception  {
		usuario.setUsuarioOriginal((Usuario)usuario.clone());		
	}
	
	public static void setUsuariosOriginalStatic(List<Usuario> usuarios)throws Exception  {
		
		for(Usuario usuario:usuarios){
			usuario.setUsuarioOriginal((Usuario)usuario.clone());
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
	
	public  Usuario getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		Usuario entity = new Usuario();		
		
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
	
	public  Usuario getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		Usuario entity = new Usuario();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=UsuarioDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=UsuarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Seguridad.Usuario.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setUsuarioOriginal(new Usuario());
      	    	entity=super.getEntity("",entity,resultSet,UsuarioDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityUsuario("",entity,resultSet); 
				
				entity.setUsuarioOriginal(super.getEntity("",entity.getUsuarioOriginal(),resultSet,UsuarioDataAccess.ISWITHSCHEMA));         		
      	    	entity.setUsuarioOriginal(this.getEntityUsuario("",entity.getUsuarioOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseUsuario(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  Usuario getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Usuario entity = new Usuario();
				
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
	
	public  Usuario getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Usuario entity = new Usuario();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=UsuarioDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=UsuarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,UsuarioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Seguridad.Usuario.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setUsuarioOriginal(new Usuario());
      	    	entity=super.getEntity("",entity,resultSet,UsuarioDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityUsuario("",entity,resultSet);    
				
				entity.setUsuarioOriginal(super.getEntity("",entity.getUsuarioOriginal(),resultSet,UsuarioDataAccess.ISWITHSCHEMA));         		
      	    	entity.setUsuarioOriginal(this.getEntityUsuario("",entity.getUsuarioOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseUsuario(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //Usuario
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		Usuario entity = new Usuario();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=UsuarioDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=UsuarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,UsuarioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Seguridad.Usuario.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseUsuario(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<Usuario> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Usuario> entities = new  ArrayList<Usuario>();
		Usuario entity = new Usuario();		  
		
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
	
	public  List<Usuario> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Usuario> entities = new  ArrayList<Usuario>();
		Usuario entity = new Usuario();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=UsuarioDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=UsuarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,UsuarioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Usuario();
      	    	entity=super.getEntity("",entity,resultSet,UsuarioDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityUsuario("",entity,resultSet);
      	    	
				entity.setUsuarioOriginal( new Usuario());
      	    	entity.setUsuarioOriginal(super.getEntity("",entity.getUsuarioOriginal(),resultSet,UsuarioDataAccess.ISWITHSCHEMA));         		
      	    	entity.setUsuarioOriginal(this.getEntityUsuario("",entity.getUsuarioOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseUsuarios(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarUsuario(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Usuario> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Usuario> entities = new  ArrayList<Usuario>();
		Usuario entity = new Usuario();		  
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
	
	public  List<Usuario> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Usuario> entities = new  ArrayList<Usuario>();
		Usuario entity = new Usuario();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Usuario();
				
				if(conMapGenerico) {
					entity.inicializarMapUsuario();
					//entity.setMapUsuario(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapUsuarioValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapUsuario().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,UsuarioDataAccess.ISWITHSCHEMA);         		
					entity=UsuarioDataAccess.getEntityUsuario("",entity,resultSet,listColumns,deepLoadType);
					
					//entity.setUsuarioOriginal( new Usuario());
					//entity.setUsuarioOriginal(super.getEntity("",entity.getUsuarioOriginal(),resultSet,UsuarioDataAccess.ISWITHSCHEMA));         		
					//entity.setUsuarioOriginal(this.getEntityUsuario("",entity.getUsuarioOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseUsuarios(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarUsuario(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public Usuario getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Usuario entity = new Usuario();		  
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
	
	public  Usuario getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Usuario entity = new Usuario();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Usuario();
				
				if(conMapGenerico) {
					entity.inicializarMapUsuario();
					//entity.setMapUsuario(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapUsuarioValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapUsuario().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,UsuarioDataAccess.ISWITHSCHEMA);         		
					entity=UsuarioDataAccess.getEntityUsuario("",entity,resultSet,listColumns,deepLoadType);
					
					//entity.setUsuarioOriginal( new Usuario());
					//entity.setUsuarioOriginal(super.getEntity("",entity.getUsuarioOriginal(),resultSet,UsuarioDataAccess.ISWITHSCHEMA));         		
					//entity.setUsuarioOriginal(this.getEntityUsuario("",entity.getUsuarioOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseUsuario(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarUsuario(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static Usuario getEntityUsuario(String strPrefijo,Usuario entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = Usuario.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = Usuario.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					UsuarioDataAccess.setFieldReflectionUsuario(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasUsuario=UsuarioConstantesFunciones.getTodosTiposColumnasUsuario();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasUsuario) {
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
							field = Usuario.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = Usuario.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						UsuarioDataAccess.setFieldReflectionUsuario(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionUsuario(Field field,String strPrefijo,String sColumn,Usuario entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case UsuarioConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case UsuarioConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case UsuarioConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case UsuarioConstantesFunciones.USERNAME:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case UsuarioConstantesFunciones.CLAVE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case UsuarioConstantesFunciones.CONFIRMARCLAVE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case UsuarioConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case UsuarioConstantesFunciones.CODIGOALTERNO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case UsuarioConstantesFunciones.TIPO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case UsuarioConstantesFunciones.ESTADO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Usuario>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<Usuario> entities = new  ArrayList<Usuario>();
		Usuario entity = new Usuario();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=UsuarioDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=UsuarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,UsuarioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new Usuario();
					entity=super.getEntity("",entity,resultSet,UsuarioDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityUsuario("",entity,resultSet);
					
					entity.setUsuarioOriginal( new Usuario());
					entity.setUsuarioOriginal(super.getEntity("",entity.getUsuarioOriginal(),resultSet,UsuarioDataAccess.ISWITHSCHEMA));         		
					entity.setUsuarioOriginal(this.getEntityUsuario("",entity.getUsuarioOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseUsuarios(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarUsuario(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Usuario>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<Usuario> entities = new  ArrayList<Usuario>();
		Usuario entity = new Usuario();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=UsuarioDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=UsuarioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,UsuarioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<Usuario> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Usuario> entities = new  ArrayList<Usuario>();
		Usuario entity = new Usuario();		  
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
	
	public  List<Usuario> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Usuario> entities = new  ArrayList<Usuario>();
		Usuario entity = new Usuario();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Usuario();
      	    	entity=super.getEntity("",entity,resultSet,UsuarioDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityUsuario("",entity,resultSet);
      	    	
				entity.setUsuarioOriginal( new Usuario());
      	    	entity.setUsuarioOriginal(super.getEntity("",entity.getUsuarioOriginal(),resultSet,UsuarioDataAccess.ISWITHSCHEMA));         		
      	    	entity.setUsuarioOriginal(this.getEntityUsuario("",entity.getUsuarioOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseUsuarios(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarUsuario(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Usuario> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Usuario> entities = new  ArrayList<Usuario>();
		Usuario entity = new Usuario();		  
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
	
	public  List<Usuario> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Usuario> entities = new  ArrayList<Usuario>();
		Usuario entity = new Usuario();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Usuario();
      	    	entity=super.getEntity("",entity,resultSet,UsuarioDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityUsuario("",entity,resultSet);
      	    	
				entity.setUsuarioOriginal( new Usuario());
      	    	entity.setUsuarioOriginal(super.getEntity("",entity.getUsuarioOriginal(),resultSet,UsuarioDataAccess.ISWITHSCHEMA));         		
      	    	entity.setUsuarioOriginal(this.getEntityUsuario("",entity.getUsuarioOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseUsuarios(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public Usuario getEntityUsuario(String strPrefijo,Usuario entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+UsuarioConstantesFunciones.IDEMPRESA));
				entity.setuser_name(resultSet.getString(strPrefijo+UsuarioConstantesFunciones.USERNAME));
				entity.setclave(resultSet.getString(strPrefijo+UsuarioConstantesFunciones.CLAVE));
				entity.setconfirmar_clave(resultSet.getString(strPrefijo+UsuarioConstantesFunciones.CONFIRMARCLAVE));
				entity.setnombre(resultSet.getString(strPrefijo+UsuarioConstantesFunciones.NOMBRE));
				entity.setcodigo_alterno(resultSet.getString(strPrefijo+UsuarioConstantesFunciones.CODIGOALTERNO));
				entity.settipo(resultSet.getBoolean(strPrefijo+UsuarioConstantesFunciones.TIPO));
				entity.setestado(resultSet.getBoolean(strPrefijo+UsuarioConstantesFunciones.ESTADO));
			} else {
				entity.setuser_name(resultSet.getString(strPrefijo+UsuarioConstantesFunciones.USERNAME));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowUsuario(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(Usuario entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=UsuarioDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=UsuarioDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=UsuarioDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=UsuarioDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(UsuarioConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,UsuarioDataAccess.TABLENAME,UsuarioDataAccess.ISWITHSTOREPROCEDURES);
			
			UsuarioDataAccess.setUsuarioOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,Usuario relusuario)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relusuario.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}


		
		public List<DepositoBanco> getDepositoBancos(Connexion connexion,Usuario usuario)throws SQLException,Exception {

		List<DepositoBanco> depositobancos= new ArrayList<DepositoBanco>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+UsuarioConstantesFunciones.SCHEMA+".usuario ON "+DepositoBancoConstantesFunciones.SCHEMA+".deposito_banco.id_usuario="+UsuarioConstantesFunciones.SCHEMA+".usuario.id WHERE "+UsuarioConstantesFunciones.SCHEMA+".usuario.id="+String.valueOf(usuario.getId());
			} else {
				sQuery=" INNER JOIN depositobanco.Usuario WHERE depositobanco.Usuario.id="+String.valueOf(usuario.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DepositoBancoDataAccess depositobancoDataAccess=new DepositoBancoDataAccess();

			depositobancoDataAccess.setConnexionType(this.connexionType);
			depositobancoDataAccess.setParameterDbType(this.parameterDbType);
			depositobancos=depositobancoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return depositobancos;

	}

	public List<HistorialCambioClave> getHistorialCambioClaves(Connexion connexion,Usuario usuario)throws SQLException,Exception {

		List<HistorialCambioClave> historialcambioclaves= new ArrayList<HistorialCambioClave>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+UsuarioConstantesFunciones.SCHEMA+".usuario ON "+HistorialCambioClaveConstantesFunciones.SCHEMA+".historial_cambio_clave.id_usuario="+UsuarioConstantesFunciones.SCHEMA+".usuario.id WHERE "+UsuarioConstantesFunciones.SCHEMA+".usuario.id="+String.valueOf(usuario.getId());
			} else {
				sQuery=" INNER JOIN historialcambioclave.Usuario WHERE historialcambioclave.Usuario.id="+String.valueOf(usuario.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			HistorialCambioClaveDataAccess historialcambioclaveDataAccess=new HistorialCambioClaveDataAccess();

			historialcambioclaveDataAccess.setConnexionType(this.connexionType);
			historialcambioclaveDataAccess.setParameterDbType(this.parameterDbType);
			historialcambioclaves=historialcambioclaveDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return historialcambioclaves;

	}

	public List<AutoriRetencion> getAutoriRetencions(Connexion connexion,Usuario usuario)throws SQLException,Exception {

		List<AutoriRetencion> autoriretencions= new ArrayList<AutoriRetencion>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+UsuarioConstantesFunciones.SCHEMA+".usuario ON "+AutoriRetencionConstantesFunciones.SCHEMA+".autori_retencion.id_usuario="+UsuarioConstantesFunciones.SCHEMA+".usuario.id WHERE "+UsuarioConstantesFunciones.SCHEMA+".usuario.id="+String.valueOf(usuario.getId());
			} else {
				sQuery=" INNER JOIN autoriretencion.Usuario WHERE autoriretencion.Usuario.id="+String.valueOf(usuario.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			AutoriRetencionDataAccess autoriretencionDataAccess=new AutoriRetencionDataAccess();

			autoriretencionDataAccess.setConnexionType(this.connexionType);
			autoriretencionDataAccess.setParameterDbType(this.parameterDbType);
			autoriretencions=autoriretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return autoriretencions;

	}

	public List<CajeroTurno> getCajeroTurnos(Connexion connexion,Usuario usuario)throws SQLException,Exception {

		List<CajeroTurno> cajeroturnos= new ArrayList<CajeroTurno>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+UsuarioConstantesFunciones.SCHEMA+".usuario ON "+CajeroTurnoConstantesFunciones.SCHEMA+".cajero_turno.id_usuario="+UsuarioConstantesFunciones.SCHEMA+".usuario.id WHERE "+UsuarioConstantesFunciones.SCHEMA+".usuario.id="+String.valueOf(usuario.getId());
			} else {
				sQuery=" INNER JOIN cajeroturno.Usuario WHERE cajeroturno.Usuario.id="+String.valueOf(usuario.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			CajeroTurnoDataAccess cajeroturnoDataAccess=new CajeroTurnoDataAccess();

			cajeroturnoDataAccess.setConnexionType(this.connexionType);
			cajeroturnoDataAccess.setParameterDbType(this.parameterDbType);
			cajeroturnos=cajeroturnoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cajeroturnos;

	}

	public List<DetalleLiquidacionImpor> getDetalleLiquidacionImpors(Connexion connexion,Usuario usuario)throws SQLException,Exception {

		List<DetalleLiquidacionImpor> detalleliquidacionimpors= new ArrayList<DetalleLiquidacionImpor>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+UsuarioConstantesFunciones.SCHEMA+".usuario ON "+DetalleLiquidacionImporConstantesFunciones.SCHEMA+".detalle_liquidacion_impor.id_usuario="+UsuarioConstantesFunciones.SCHEMA+".usuario.id WHERE "+UsuarioConstantesFunciones.SCHEMA+".usuario.id="+String.valueOf(usuario.getId());
			} else {
				sQuery=" INNER JOIN detalleliquidacionimpor.Usuario WHERE detalleliquidacionimpor.Usuario.id="+String.valueOf(usuario.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleLiquidacionImporDataAccess detalleliquidacionimporDataAccess=new DetalleLiquidacionImporDataAccess();

			detalleliquidacionimporDataAccess.setConnexionType(this.connexionType);
			detalleliquidacionimporDataAccess.setParameterDbType(this.parameterDbType);
			detalleliquidacionimpors=detalleliquidacionimporDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalleliquidacionimpors;

	}

	public List<NotaCreditoSoli> getNotaCreditoSolis(Connexion connexion,Usuario usuario)throws SQLException,Exception {

		List<NotaCreditoSoli> notacreditosolis= new ArrayList<NotaCreditoSoli>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+UsuarioConstantesFunciones.SCHEMA+".usuario ON "+NotaCreditoSoliConstantesFunciones.SCHEMA+".nota_credito_soli.id_usuario="+UsuarioConstantesFunciones.SCHEMA+".usuario.id WHERE "+UsuarioConstantesFunciones.SCHEMA+".usuario.id="+String.valueOf(usuario.getId());
			} else {
				sQuery=" INNER JOIN notacreditosoli.Usuario WHERE notacreditosoli.Usuario.id="+String.valueOf(usuario.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			NotaCreditoSoliDataAccess notacreditosoliDataAccess=new NotaCreditoSoliDataAccess();

			notacreditosoliDataAccess.setConnexionType(this.connexionType);
			notacreditosoliDataAccess.setParameterDbType(this.parameterDbType);
			notacreditosolis=notacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return notacreditosolis;

	}

	public List<PedidoExpor> getPedidoExpors(Connexion connexion,Usuario usuario)throws SQLException,Exception {

		List<PedidoExpor> pedidoexpors= new ArrayList<PedidoExpor>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+UsuarioConstantesFunciones.SCHEMA+".usuario ON "+PedidoExporConstantesFunciones.SCHEMA+".pedido_expor.id_usuario="+UsuarioConstantesFunciones.SCHEMA+".usuario.id WHERE "+UsuarioConstantesFunciones.SCHEMA+".usuario.id="+String.valueOf(usuario.getId());
			} else {
				sQuery=" INNER JOIN pedidoexpor.Usuario WHERE pedidoexpor.Usuario.id="+String.valueOf(usuario.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PedidoExporDataAccess pedidoexporDataAccess=new PedidoExporDataAccess();

			pedidoexporDataAccess.setConnexionType(this.connexionType);
			pedidoexporDataAccess.setParameterDbType(this.parameterDbType);
			pedidoexpors=pedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pedidoexpors;

	}

	public List<DescuentoTipoPrecio> getDescuentoTipoPrecios(Connexion connexion,Usuario usuario)throws SQLException,Exception {

		List<DescuentoTipoPrecio> descuentotipoprecios= new ArrayList<DescuentoTipoPrecio>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+UsuarioConstantesFunciones.SCHEMA+".usuario ON "+DescuentoTipoPrecioConstantesFunciones.SCHEMA+".descuento_tipo_precio.id_usuario="+UsuarioConstantesFunciones.SCHEMA+".usuario.id WHERE "+UsuarioConstantesFunciones.SCHEMA+".usuario.id="+String.valueOf(usuario.getId());
			} else {
				sQuery=" INNER JOIN descuentotipoprecio.Usuario WHERE descuentotipoprecio.Usuario.id="+String.valueOf(usuario.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DescuentoTipoPrecioDataAccess descuentotipoprecioDataAccess=new DescuentoTipoPrecioDataAccess();

			descuentotipoprecioDataAccess.setConnexionType(this.connexionType);
			descuentotipoprecioDataAccess.setParameterDbType(this.parameterDbType);
			descuentotipoprecios=descuentotipoprecioDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return descuentotipoprecios;

	}

	public List<GuiaRemision> getGuiaRemisions(Connexion connexion,Usuario usuario)throws SQLException,Exception {

		List<GuiaRemision> guiaremisions= new ArrayList<GuiaRemision>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+UsuarioConstantesFunciones.SCHEMA+".usuario ON "+GuiaRemisionConstantesFunciones.SCHEMA+".guia_remision.id_usuario="+UsuarioConstantesFunciones.SCHEMA+".usuario.id WHERE "+UsuarioConstantesFunciones.SCHEMA+".usuario.id="+String.valueOf(usuario.getId());
			} else {
				sQuery=" INNER JOIN guiaremision.Usuario WHERE guiaremision.Usuario.id="+String.valueOf(usuario.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			GuiaRemisionDataAccess guiaremisionDataAccess=new GuiaRemisionDataAccess();

			guiaremisionDataAccess.setConnexionType(this.connexionType);
			guiaremisionDataAccess.setParameterDbType(this.parameterDbType);
			guiaremisions=guiaremisionDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return guiaremisions;

	}

	public List<PedidoPuntoVenta> getPedidoPuntoVentas(Connexion connexion,Usuario usuario)throws SQLException,Exception {

		List<PedidoPuntoVenta> pedidopuntoventas= new ArrayList<PedidoPuntoVenta>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+UsuarioConstantesFunciones.SCHEMA+".usuario ON "+PedidoPuntoVentaConstantesFunciones.SCHEMA+".pedido_punto_venta.id_usuario="+UsuarioConstantesFunciones.SCHEMA+".usuario.id WHERE "+UsuarioConstantesFunciones.SCHEMA+".usuario.id="+String.valueOf(usuario.getId());
			} else {
				sQuery=" INNER JOIN pedidopuntoventa.Usuario WHERE pedidopuntoventa.Usuario.id="+String.valueOf(usuario.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PedidoPuntoVentaDataAccess pedidopuntoventaDataAccess=new PedidoPuntoVentaDataAccess();

			pedidopuntoventaDataAccess.setConnexionType(this.connexionType);
			pedidopuntoventaDataAccess.setParameterDbType(this.parameterDbType);
			pedidopuntoventas=pedidopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pedidopuntoventas;

	}

	public List<GastoEmpleado> getGastoEmpleados(Connexion connexion,Usuario usuario)throws SQLException,Exception {

		List<GastoEmpleado> gastoempleados= new ArrayList<GastoEmpleado>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+UsuarioConstantesFunciones.SCHEMA+".usuario ON "+GastoEmpleadoConstantesFunciones.SCHEMA+".gasto_empleado.id_usuario="+UsuarioConstantesFunciones.SCHEMA+".usuario.id WHERE "+UsuarioConstantesFunciones.SCHEMA+".usuario.id="+String.valueOf(usuario.getId());
			} else {
				sQuery=" INNER JOIN gastoempleado.Usuario WHERE gastoempleado.Usuario.id="+String.valueOf(usuario.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			GastoEmpleadoDataAccess gastoempleadoDataAccess=new GastoEmpleadoDataAccess();

			gastoempleadoDataAccess.setConnexionType(this.connexionType);
			gastoempleadoDataAccess.setParameterDbType(this.parameterDbType);
			gastoempleados=gastoempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return gastoempleados;

	}

	public List<SecuencialUsuario> getSecuencialUsuarios(Connexion connexion,Usuario usuario)throws SQLException,Exception {

		List<SecuencialUsuario> secuencialusuarios= new ArrayList<SecuencialUsuario>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+UsuarioConstantesFunciones.SCHEMA+".usuario ON "+SecuencialUsuarioConstantesFunciones.SCHEMA+".secuencial_usuario.id_usuario="+UsuarioConstantesFunciones.SCHEMA+".usuario.id WHERE "+UsuarioConstantesFunciones.SCHEMA+".usuario.id="+String.valueOf(usuario.getId());
			} else {
				sQuery=" INNER JOIN secuencialusuario.Usuario WHERE secuencialusuario.Usuario.id="+String.valueOf(usuario.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			SecuencialUsuarioDataAccess secuencialusuarioDataAccess=new SecuencialUsuarioDataAccess();

			secuencialusuarioDataAccess.setConnexionType(this.connexionType);
			secuencialusuarioDataAccess.setParameterDbType(this.parameterDbType);
			secuencialusuarios=secuencialusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return secuencialusuarios;

	}

	public List<MovimientoActivoFijo> getMovimientoActivoFijos(Connexion connexion,Usuario usuario)throws SQLException,Exception {

		List<MovimientoActivoFijo> movimientoactivofijos= new ArrayList<MovimientoActivoFijo>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+UsuarioConstantesFunciones.SCHEMA+".usuario ON "+MovimientoActivoFijoConstantesFunciones.SCHEMA+".movimiento_activo_fijo.id_usuario="+UsuarioConstantesFunciones.SCHEMA+".usuario.id WHERE "+UsuarioConstantesFunciones.SCHEMA+".usuario.id="+String.valueOf(usuario.getId());
			} else {
				sQuery=" INNER JOIN movimientoactivofijo.Usuario WHERE movimientoactivofijo.Usuario.id="+String.valueOf(usuario.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			MovimientoActivoFijoDataAccess movimientoactivofijoDataAccess=new MovimientoActivoFijoDataAccess();

			movimientoactivofijoDataAccess.setConnexionType(this.connexionType);
			movimientoactivofijoDataAccess.setParameterDbType(this.parameterDbType);
			movimientoactivofijos=movimientoactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return movimientoactivofijos;

	}

	public List<UsuarioOpcion> getUsuarioOpcions(Connexion connexion,Usuario usuario)throws SQLException,Exception {

		List<UsuarioOpcion> usuarioopcions= new ArrayList<UsuarioOpcion>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+UsuarioConstantesFunciones.SCHEMA+".usuario ON "+UsuarioOpcionConstantesFunciones.SCHEMA+".usuario_opcion.id_usuario="+UsuarioConstantesFunciones.SCHEMA+".usuario.id WHERE "+UsuarioConstantesFunciones.SCHEMA+".usuario.id="+String.valueOf(usuario.getId());
			} else {
				sQuery=" INNER JOIN usuarioopcion.Usuario WHERE usuarioopcion.Usuario.id="+String.valueOf(usuario.getId());

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

	public List<PedidoCompraImpor> getPedidoCompraImpors(Connexion connexion,Usuario usuario)throws SQLException,Exception {

		List<PedidoCompraImpor> pedidocompraimpors= new ArrayList<PedidoCompraImpor>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+UsuarioConstantesFunciones.SCHEMA+".usuario ON "+PedidoCompraImporConstantesFunciones.SCHEMA+".pedido_compra_impor.id_usuario="+UsuarioConstantesFunciones.SCHEMA+".usuario.id WHERE "+UsuarioConstantesFunciones.SCHEMA+".usuario.id="+String.valueOf(usuario.getId());
			} else {
				sQuery=" INNER JOIN pedidocompraimpor.Usuario WHERE pedidocompraimpor.Usuario.id="+String.valueOf(usuario.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PedidoCompraImporDataAccess pedidocompraimporDataAccess=new PedidoCompraImporDataAccess();

			pedidocompraimporDataAccess.setConnexionType(this.connexionType);
			pedidocompraimporDataAccess.setParameterDbType(this.parameterDbType);
			pedidocompraimpors=pedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pedidocompraimpors;

	}

	public List<OrdenCompra> getOrdenCompras(Connexion connexion,Usuario usuario)throws SQLException,Exception {

		List<OrdenCompra> ordencompras= new ArrayList<OrdenCompra>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+UsuarioConstantesFunciones.SCHEMA+".usuario ON "+OrdenCompraConstantesFunciones.SCHEMA+".orden_compra.id_usuario="+UsuarioConstantesFunciones.SCHEMA+".usuario.id WHERE "+UsuarioConstantesFunciones.SCHEMA+".usuario.id="+String.valueOf(usuario.getId());
			} else {
				sQuery=" INNER JOIN ordencompra.Usuario WHERE ordencompra.Usuario.id="+String.valueOf(usuario.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			OrdenCompraDataAccess ordencompraDataAccess=new OrdenCompraDataAccess();

			ordencompraDataAccess.setConnexionType(this.connexionType);
			ordencompraDataAccess.setParameterDbType(this.parameterDbType);
			ordencompras=ordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ordencompras;

	}

	public List<TurnoPunVen> getTurnoPunVens(Connexion connexion,Usuario usuario)throws SQLException,Exception {

		List<TurnoPunVen> turnopunvens= new ArrayList<TurnoPunVen>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+UsuarioConstantesFunciones.SCHEMA+".usuario ON "+TurnoPunVenConstantesFunciones.SCHEMA+".turno_pun_ven.id_usuario="+UsuarioConstantesFunciones.SCHEMA+".usuario.id WHERE "+UsuarioConstantesFunciones.SCHEMA+".usuario.id="+String.valueOf(usuario.getId());
			} else {
				sQuery=" INNER JOIN turnopunven.Usuario WHERE turnopunven.Usuario.id="+String.valueOf(usuario.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			TurnoPunVenDataAccess turnopunvenDataAccess=new TurnoPunVenDataAccess();

			turnopunvenDataAccess.setConnexionType(this.connexionType);
			turnopunvenDataAccess.setParameterDbType(this.parameterDbType);
			turnopunvens=turnopunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return turnopunvens;

	}

	public List<Novedad> getNovedads(Connexion connexion,Usuario usuario)throws SQLException,Exception {

		List<Novedad> novedads= new ArrayList<Novedad>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+UsuarioConstantesFunciones.SCHEMA+".usuario ON "+NovedadConstantesFunciones.SCHEMA+".novedad.id_usuario="+UsuarioConstantesFunciones.SCHEMA+".usuario.id WHERE "+UsuarioConstantesFunciones.SCHEMA+".usuario.id="+String.valueOf(usuario.getId());
			} else {
				sQuery=" INNER JOIN novedad.Usuario WHERE novedad.Usuario.id="+String.valueOf(usuario.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			NovedadDataAccess novedadDataAccess=new NovedadDataAccess();

			novedadDataAccess.setConnexionType(this.connexionType);
			novedadDataAccess.setParameterDbType(this.parameterDbType);
			novedads=novedadDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return novedads;

	}

	public ParametroGeneralUsuario getParametroGeneralUsuario(Connexion connexion,Usuario usuario)throws SQLException,Exception {

		ParametroGeneralUsuario parametrogeneralusuario= new ParametroGeneralUsuario();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+UsuarioConstantesFunciones.SCHEMA+".usuario ON "+ParametroGeneralUsuarioConstantesFunciones.SCHEMA+".parametro_general_usuario.id="+UsuarioConstantesFunciones.SCHEMA+".usuario.id WHERE "+UsuarioConstantesFunciones.SCHEMA+".usuario.id="+String.valueOf(usuario.getId());
			} else {
				sQuery=" INNER JOIN parametrogeneralusuario.Usuario WHERE parametrogeneralusuario.Usuario.id="+String.valueOf(usuario.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ParametroGeneralUsuarioDataAccess parametrogeneralusuarioDataAccess=new ParametroGeneralUsuarioDataAccess();

			parametrogeneralusuarioDataAccess.setConnexionType(this.connexionType);
			parametrogeneralusuarioDataAccess.setParameterDbType(this.parameterDbType);
			parametrogeneralusuario=parametrogeneralusuarioDataAccess.getEntity(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return parametrogeneralusuario;

	}

	public List<AutoriPagoOrdenCompra> getAutoriPagoOrdenCompras(Connexion connexion,Usuario usuario)throws SQLException,Exception {

		List<AutoriPagoOrdenCompra> autoripagoordencompras= new ArrayList<AutoriPagoOrdenCompra>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+UsuarioConstantesFunciones.SCHEMA+".usuario ON "+AutoriPagoOrdenCompraConstantesFunciones.SCHEMA+".autori_pago_orden_compra.id_usuario="+UsuarioConstantesFunciones.SCHEMA+".usuario.id WHERE "+UsuarioConstantesFunciones.SCHEMA+".usuario.id="+String.valueOf(usuario.getId());
			} else {
				sQuery=" INNER JOIN autoripagoordencompra.Usuario WHERE autoripagoordencompra.Usuario.id="+String.valueOf(usuario.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			AutoriPagoOrdenCompraDataAccess autoripagoordencompraDataAccess=new AutoriPagoOrdenCompraDataAccess();

			autoripagoordencompraDataAccess.setConnexionType(this.connexionType);
			autoripagoordencompraDataAccess.setParameterDbType(this.parameterDbType);
			autoripagoordencompras=autoripagoordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return autoripagoordencompras;

	}

	public List<CierreCaja> getCierreCajas(Connexion connexion,Usuario usuario)throws SQLException,Exception {

		List<CierreCaja> cierrecajas= new ArrayList<CierreCaja>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+UsuarioConstantesFunciones.SCHEMA+".usuario ON "+CierreCajaConstantesFunciones.SCHEMA+".cierre_caja.id_usuario="+UsuarioConstantesFunciones.SCHEMA+".usuario.id WHERE "+UsuarioConstantesFunciones.SCHEMA+".usuario.id="+String.valueOf(usuario.getId());
			} else {
				sQuery=" INNER JOIN cierrecaja.Usuario WHERE cierrecaja.Usuario.id="+String.valueOf(usuario.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			CierreCajaDataAccess cierrecajaDataAccess=new CierreCajaDataAccess();

			cierrecajaDataAccess.setConnexionType(this.connexionType);
			cierrecajaDataAccess.setParameterDbType(this.parameterDbType);
			cierrecajas=cierrecajaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cierrecajas;

	}

	public List<DescuentoMonto> getDescuentoMontos(Connexion connexion,Usuario usuario)throws SQLException,Exception {

		List<DescuentoMonto> descuentomontos= new ArrayList<DescuentoMonto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+UsuarioConstantesFunciones.SCHEMA+".usuario ON "+DescuentoMontoConstantesFunciones.SCHEMA+".descuento_monto.id_usuario="+UsuarioConstantesFunciones.SCHEMA+".usuario.id WHERE "+UsuarioConstantesFunciones.SCHEMA+".usuario.id="+String.valueOf(usuario.getId());
			} else {
				sQuery=" INNER JOIN descuentomonto.Usuario WHERE descuentomonto.Usuario.id="+String.valueOf(usuario.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DescuentoMontoDataAccess descuentomontoDataAccess=new DescuentoMontoDataAccess();

			descuentomontoDataAccess.setConnexionType(this.connexionType);
			descuentomontoDataAccess.setParameterDbType(this.parameterDbType);
			descuentomontos=descuentomontoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return descuentomontos;

	}

	public List<CajaEgreso> getCajaEgresos(Connexion connexion,Usuario usuario)throws SQLException,Exception {

		List<CajaEgreso> cajaegresos= new ArrayList<CajaEgreso>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+UsuarioConstantesFunciones.SCHEMA+".usuario ON "+CajaEgresoConstantesFunciones.SCHEMA+".caja_egreso.id_usuario="+UsuarioConstantesFunciones.SCHEMA+".usuario.id WHERE "+UsuarioConstantesFunciones.SCHEMA+".usuario.id="+String.valueOf(usuario.getId());
			} else {
				sQuery=" INNER JOIN cajaegreso.Usuario WHERE cajaegreso.Usuario.id="+String.valueOf(usuario.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			CajaEgresoDataAccess cajaegresoDataAccess=new CajaEgresoDataAccess();

			cajaegresoDataAccess.setConnexionType(this.connexionType);
			cajaegresoDataAccess.setParameterDbType(this.parameterDbType);
			cajaegresos=cajaegresoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cajaegresos;

	}

	public List<RequisicionCompra> getRequisicionCompras(Connexion connexion,Usuario usuario)throws SQLException,Exception {

		List<RequisicionCompra> requisicioncompras= new ArrayList<RequisicionCompra>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+UsuarioConstantesFunciones.SCHEMA+".usuario ON "+RequisicionCompraConstantesFunciones.SCHEMA+".requisicion_compra.id_usuario="+UsuarioConstantesFunciones.SCHEMA+".usuario.id WHERE "+UsuarioConstantesFunciones.SCHEMA+".usuario.id="+String.valueOf(usuario.getId());
			} else {
				sQuery=" INNER JOIN requisicioncompra.Usuario WHERE requisicioncompra.Usuario.id="+String.valueOf(usuario.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			RequisicionCompraDataAccess requisicioncompraDataAccess=new RequisicionCompraDataAccess();

			requisicioncompraDataAccess.setConnexionType(this.connexionType);
			requisicioncompraDataAccess.setParameterDbType(this.parameterDbType);
			requisicioncompras=requisicioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return requisicioncompras;

	}

	public List<NotaCreditoPuntoVenta> getNotaCreditoPuntoVentas(Connexion connexion,Usuario usuario)throws SQLException,Exception {

		List<NotaCreditoPuntoVenta> notacreditopuntoventas= new ArrayList<NotaCreditoPuntoVenta>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+UsuarioConstantesFunciones.SCHEMA+".usuario ON "+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+".nota_credito_punto_venta.id_usuario="+UsuarioConstantesFunciones.SCHEMA+".usuario.id WHERE "+UsuarioConstantesFunciones.SCHEMA+".usuario.id="+String.valueOf(usuario.getId());
			} else {
				sQuery=" INNER JOIN notacreditopuntoventa.Usuario WHERE notacreditopuntoventa.Usuario.id="+String.valueOf(usuario.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			NotaCreditoPuntoVentaDataAccess notacreditopuntoventaDataAccess=new NotaCreditoPuntoVentaDataAccess();

			notacreditopuntoventaDataAccess.setConnexionType(this.connexionType);
			notacreditopuntoventaDataAccess.setParameterDbType(this.parameterDbType);
			notacreditopuntoventas=notacreditopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return notacreditopuntoventas;

	}

	public List<PlaneacionCompra> getPlaneacionCompras(Connexion connexion,Usuario usuario)throws SQLException,Exception {

		List<PlaneacionCompra> planeacioncompras= new ArrayList<PlaneacionCompra>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+UsuarioConstantesFunciones.SCHEMA+".usuario ON "+PlaneacionCompraConstantesFunciones.SCHEMA+".planeacion_compra.id_usuario="+UsuarioConstantesFunciones.SCHEMA+".usuario.id WHERE "+UsuarioConstantesFunciones.SCHEMA+".usuario.id="+String.valueOf(usuario.getId());
			} else {
				sQuery=" INNER JOIN planeacioncompra.Usuario WHERE planeacioncompra.Usuario.id="+String.valueOf(usuario.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PlaneacionCompraDataAccess planeacioncompraDataAccess=new PlaneacionCompraDataAccess();

			planeacioncompraDataAccess.setConnexionType(this.connexionType);
			planeacioncompraDataAccess.setParameterDbType(this.parameterDbType);
			planeacioncompras=planeacioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return planeacioncompras;

	}

	public List<PedidoCompra> getPedidoCompras(Connexion connexion,Usuario usuario)throws SQLException,Exception {

		List<PedidoCompra> pedidocompras= new ArrayList<PedidoCompra>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+UsuarioConstantesFunciones.SCHEMA+".usuario ON "+PedidoCompraConstantesFunciones.SCHEMA+".pedido_compra.id_usuario="+UsuarioConstantesFunciones.SCHEMA+".usuario.id WHERE "+UsuarioConstantesFunciones.SCHEMA+".usuario.id="+String.valueOf(usuario.getId());
			} else {
				sQuery=" INNER JOIN pedidocompra.Usuario WHERE pedidocompra.Usuario.id="+String.valueOf(usuario.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PedidoCompraDataAccess pedidocompraDataAccess=new PedidoCompraDataAccess();

			pedidocompraDataAccess.setConnexionType(this.connexionType);
			pedidocompraDataAccess.setParameterDbType(this.parameterDbType);
			pedidocompras=pedidocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pedidocompras;

	}

	public List<PerfilUsuario> getPerfilUsuarios(Connexion connexion,Usuario usuario)throws SQLException,Exception {

		List<PerfilUsuario> perfilusuarios= new ArrayList<PerfilUsuario>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+UsuarioConstantesFunciones.SCHEMA+".usuario ON "+PerfilUsuarioConstantesFunciones.SCHEMA+".perfil_usuario.id_usuario="+UsuarioConstantesFunciones.SCHEMA+".usuario.id WHERE "+UsuarioConstantesFunciones.SCHEMA+".usuario.id="+String.valueOf(usuario.getId());
			} else {
				sQuery=" INNER JOIN perfilusuario.Usuario WHERE perfilusuario.Usuario.id="+String.valueOf(usuario.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PerfilUsuarioDataAccess perfilusuarioDataAccess=new PerfilUsuarioDataAccess();

			perfilusuarioDataAccess.setConnexionType(this.connexionType);
			perfilusuarioDataAccess.setParameterDbType(this.parameterDbType);
			perfilusuarios=perfilusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return perfilusuarios;

	}

	public List<Consignatario> getConsignatarios(Connexion connexion,Usuario usuario)throws SQLException,Exception {

		List<Consignatario> consignatarios= new ArrayList<Consignatario>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+UsuarioConstantesFunciones.SCHEMA+".usuario ON "+ConsignatarioConstantesFunciones.SCHEMA+".consignatario.id_usuario="+UsuarioConstantesFunciones.SCHEMA+".usuario.id WHERE "+UsuarioConstantesFunciones.SCHEMA+".usuario.id="+String.valueOf(usuario.getId());
			} else {
				sQuery=" INNER JOIN consignatario.Usuario WHERE consignatario.Usuario.id="+String.valueOf(usuario.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ConsignatarioDataAccess consignatarioDataAccess=new ConsignatarioDataAccess();

			consignatarioDataAccess.setConnexionType(this.connexionType);
			consignatarioDataAccess.setParameterDbType(this.parameterDbType);
			consignatarios=consignatarioDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return consignatarios;

	}

	public List<Transferencia> getTransferencias(Connexion connexion,Usuario usuario)throws SQLException,Exception {

		List<Transferencia> transferencias= new ArrayList<Transferencia>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+UsuarioConstantesFunciones.SCHEMA+".usuario ON "+TransferenciaConstantesFunciones.SCHEMA+".transferencia.id_usuario="+UsuarioConstantesFunciones.SCHEMA+".usuario.id WHERE "+UsuarioConstantesFunciones.SCHEMA+".usuario.id="+String.valueOf(usuario.getId());
			} else {
				sQuery=" INNER JOIN transferencia.Usuario WHERE transferencia.Usuario.id="+String.valueOf(usuario.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			TransferenciaDataAccess transferenciaDataAccess=new TransferenciaDataAccess();

			transferenciaDataAccess.setConnexionType(this.connexionType);
			transferenciaDataAccess.setParameterDbType(this.parameterDbType);
			transferencias=transferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transferencias;

	}

	public DatoGeneralUsuario getDatoGeneralUsuario(Connexion connexion,Usuario usuario)throws SQLException,Exception {

		DatoGeneralUsuario datogeneralusuario= new DatoGeneralUsuario();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+UsuarioConstantesFunciones.SCHEMA+".usuario ON "+DatoGeneralUsuarioConstantesFunciones.SCHEMA+".dato_general_usuario.id="+UsuarioConstantesFunciones.SCHEMA+".usuario.id WHERE "+UsuarioConstantesFunciones.SCHEMA+".usuario.id="+String.valueOf(usuario.getId());
			} else {
				sQuery=" INNER JOIN datogeneralusuario.Usuario WHERE datogeneralusuario.Usuario.id="+String.valueOf(usuario.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DatoGeneralUsuarioDataAccess datogeneralusuarioDataAccess=new DatoGeneralUsuarioDataAccess();

			datogeneralusuarioDataAccess.setConnexionType(this.connexionType);
			datogeneralusuarioDataAccess.setParameterDbType(this.parameterDbType);
			datogeneralusuario=datogeneralusuarioDataAccess.getEntity(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return datogeneralusuario;

	}

	public List<CajaIngreso> getCajaIngresos(Connexion connexion,Usuario usuario)throws SQLException,Exception {

		List<CajaIngreso> cajaingresos= new ArrayList<CajaIngreso>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+UsuarioConstantesFunciones.SCHEMA+".usuario ON "+CajaIngresoConstantesFunciones.SCHEMA+".caja_ingreso.id_usuario="+UsuarioConstantesFunciones.SCHEMA+".usuario.id WHERE "+UsuarioConstantesFunciones.SCHEMA+".usuario.id="+String.valueOf(usuario.getId());
			} else {
				sQuery=" INNER JOIN cajaingreso.Usuario WHERE cajaingreso.Usuario.id="+String.valueOf(usuario.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			CajaIngresoDataAccess cajaingresoDataAccess=new CajaIngresoDataAccess();

			cajaingresoDataAccess.setConnexionType(this.connexionType);
			cajaingresoDataAccess.setParameterDbType(this.parameterDbType);
			cajaingresos=cajaingresoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cajaingresos;

	}

	public List<ClienteCoa> getClienteCoas(Connexion connexion,Usuario usuario)throws SQLException,Exception {

		List<ClienteCoa> clientecoas= new ArrayList<ClienteCoa>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+UsuarioConstantesFunciones.SCHEMA+".usuario ON "+ClienteCoaConstantesFunciones.SCHEMA+".cliente_coa.id_usuario="+UsuarioConstantesFunciones.SCHEMA+".usuario.id WHERE "+UsuarioConstantesFunciones.SCHEMA+".usuario.id="+String.valueOf(usuario.getId());
			} else {
				sQuery=" INNER JOIN clientecoa.Usuario WHERE clientecoa.Usuario.id="+String.valueOf(usuario.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ClienteCoaDataAccess clientecoaDataAccess=new ClienteCoaDataAccess();

			clientecoaDataAccess.setConnexionType(this.connexionType);
			clientecoaDataAccess.setParameterDbType(this.parameterDbType);
			clientecoas=clientecoaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return clientecoas;

	}

	public List<Consignacion> getConsignacions(Connexion connexion,Usuario usuario)throws SQLException,Exception {

		List<Consignacion> consignacions= new ArrayList<Consignacion>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+UsuarioConstantesFunciones.SCHEMA+".usuario ON "+ConsignacionConstantesFunciones.SCHEMA+".consignacion.id_usuario="+UsuarioConstantesFunciones.SCHEMA+".usuario.id WHERE "+UsuarioConstantesFunciones.SCHEMA+".usuario.id="+String.valueOf(usuario.getId());
			} else {
				sQuery=" INNER JOIN consignacion.Usuario WHERE consignacion.Usuario.id="+String.valueOf(usuario.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ConsignacionDataAccess consignacionDataAccess=new ConsignacionDataAccess();

			consignacionDataAccess.setConnexionType(this.connexionType);
			consignacionDataAccess.setParameterDbType(this.parameterDbType);
			consignacions=consignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return consignacions;

	}

	public List<DetalleMensajeCorreoInven> getDetalleMensajeCorreoInvens(Connexion connexion,Usuario usuario)throws SQLException,Exception {

		List<DetalleMensajeCorreoInven> detallemensajecorreoinvens= new ArrayList<DetalleMensajeCorreoInven>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+UsuarioConstantesFunciones.SCHEMA+".usuario ON "+DetalleMensajeCorreoInvenConstantesFunciones.SCHEMA+".detalle_mensaje_correo_inven.id_usuario="+UsuarioConstantesFunciones.SCHEMA+".usuario.id WHERE "+UsuarioConstantesFunciones.SCHEMA+".usuario.id="+String.valueOf(usuario.getId());
			} else {
				sQuery=" INNER JOIN detallemensajecorreoinven.Usuario WHERE detallemensajecorreoinven.Usuario.id="+String.valueOf(usuario.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleMensajeCorreoInvenDataAccess detallemensajecorreoinvenDataAccess=new DetalleMensajeCorreoInvenDataAccess();

			detallemensajecorreoinvenDataAccess.setConnexionType(this.connexionType);
			detallemensajecorreoinvenDataAccess.setParameterDbType(this.parameterDbType);
			detallemensajecorreoinvens=detallemensajecorreoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detallemensajecorreoinvens;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,Usuario usuario) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!usuario.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(usuario.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueuser_name=new ParameterValue<String>();
					parameterMaintenanceValueuser_name.setValue(usuario.getuser_name());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueuser_name);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueclave=new ParameterValue<String>();
					parameterMaintenanceValueclave.setValue(usuario.getclave());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueclave);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueconfirmar_clave=new ParameterValue<String>();
					parameterMaintenanceValueconfirmar_clave.setValue(usuario.getconfirmar_clave());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueconfirmar_clave);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(usuario.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo_alterno=new ParameterValue<String>();
					parameterMaintenanceValuecodigo_alterno.setValue(usuario.getcodigo_alterno());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo_alterno);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuetipo=new ParameterValue<Boolean>();
					parameterMaintenanceValuetipo.setValue(usuario.gettipo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetipo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValueestado=new ParameterValue<Boolean>();
					parameterMaintenanceValueestado.setValue(usuario.getestado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueestado);
					parametersTemp.add(parameterMaintenance);
					
						if(!usuario.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(usuario.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(usuario.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(usuario.getId());
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
	
	public void setIsNewIsChangedFalseUsuario(Usuario usuario)throws Exception  {		
		usuario.setIsNew(false);
		usuario.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseUsuarios(List<Usuario> usuarios)throws Exception  {				
		for(Usuario usuario:usuarios) {
			usuario.setIsNew(false);
			usuario.setIsChanged(false);
		}
	}
	
	public void generarExportarUsuario(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
