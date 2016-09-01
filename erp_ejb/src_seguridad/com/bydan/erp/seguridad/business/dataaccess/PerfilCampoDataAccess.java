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
import com.bydan.erp.seguridad.util.*;//PerfilCampoConstantesFunciones;










@SuppressWarnings("unused")
final public class PerfilCampoDataAccess extends  PerfilCampoDataAccessAdditional{ //PerfilCampoDataAccessAdditional,DataAccessHelper<PerfilCampo>
	//static Logger logger = Logger.getLogger(PerfilCampoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="perfil_campo";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+PerfilCampoConstantesFunciones.SCHEMA+"."+PerfilCampoConstantesFunciones.TABLENAME+"(version_row,id_perfil,id_campo,todo,ingreso,modificacion,eliminacion,consulta,estado)values(current_timestamp,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+PerfilCampoConstantesFunciones.SCHEMA+"."+PerfilCampoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_perfil=?,id_campo=?,todo=?,ingreso=?,modificacion=?,eliminacion=?,consulta=?,estado=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+PerfilCampoConstantesFunciones.SCHEMA+"."+PerfilCampoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select perfilcampo from "+PerfilCampoConstantesFunciones.SPERSISTENCENAME+" perfilcampo";
	public static String QUERYSELECTNATIVE="select "+PerfilCampoConstantesFunciones.SCHEMA+"."+PerfilCampoConstantesFunciones.TABLENAME+".id,"+PerfilCampoConstantesFunciones.SCHEMA+"."+PerfilCampoConstantesFunciones.TABLENAME+".version_row,"+PerfilCampoConstantesFunciones.SCHEMA+"."+PerfilCampoConstantesFunciones.TABLENAME+".id_perfil,"+PerfilCampoConstantesFunciones.SCHEMA+"."+PerfilCampoConstantesFunciones.TABLENAME+".id_campo,"+PerfilCampoConstantesFunciones.SCHEMA+"."+PerfilCampoConstantesFunciones.TABLENAME+".todo,"+PerfilCampoConstantesFunciones.SCHEMA+"."+PerfilCampoConstantesFunciones.TABLENAME+".ingreso,"+PerfilCampoConstantesFunciones.SCHEMA+"."+PerfilCampoConstantesFunciones.TABLENAME+".modificacion,"+PerfilCampoConstantesFunciones.SCHEMA+"."+PerfilCampoConstantesFunciones.TABLENAME+".eliminacion,"+PerfilCampoConstantesFunciones.SCHEMA+"."+PerfilCampoConstantesFunciones.TABLENAME+".consulta,"+PerfilCampoConstantesFunciones.SCHEMA+"."+PerfilCampoConstantesFunciones.TABLENAME+".estado from "+PerfilCampoConstantesFunciones.SCHEMA+"."+PerfilCampoConstantesFunciones.TABLENAME;//+" as "+PerfilCampoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+PerfilCampoConstantesFunciones.SCHEMA+"."+PerfilCampoConstantesFunciones.TABLENAME+".id,"+PerfilCampoConstantesFunciones.SCHEMA+"."+PerfilCampoConstantesFunciones.TABLENAME+".version_row from "+PerfilCampoConstantesFunciones.SCHEMA+"."+PerfilCampoConstantesFunciones.TABLENAME;//+" as "+PerfilCampoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+PerfilCampoConstantesFunciones.SCHEMA+"."+PerfilCampoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_perfil=?,id_campo=?,todo=?,ingreso=?,modificacion=?,eliminacion=?,consulta=?,estado=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PERFILCAMPO_INSERT(?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PERFILCAMPO_UPDATE(?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PERFILCAMPO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PERFILCAMPO_SELECT(?,?)";
	
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
	
	
	protected PerfilCampoDataAccessAdditional perfilcampoDataAccessAdditional=null;
	
	public PerfilCampoDataAccessAdditional getPerfilCampoDataAccessAdditional() {
		return this.perfilcampoDataAccessAdditional;
	}
	
	public void setPerfilCampoDataAccessAdditional(PerfilCampoDataAccessAdditional perfilcampoDataAccessAdditional) {
		try {
			this.perfilcampoDataAccessAdditional=perfilcampoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public PerfilCampoDataAccess() {
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
		PerfilCampoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		PerfilCampoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		PerfilCampoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setPerfilCampoOriginal(PerfilCampo perfilcampo)throws Exception  {
		perfilcampo.setPerfilCampoOriginal((PerfilCampo)perfilcampo.clone());		
	}
	
	public void setPerfilCamposOriginal(List<PerfilCampo> perfilcampos)throws Exception  {
		
		for(PerfilCampo perfilcampo:perfilcampos){
			perfilcampo.setPerfilCampoOriginal((PerfilCampo)perfilcampo.clone());
		}
	}
	
	public static void setPerfilCampoOriginalStatic(PerfilCampo perfilcampo)throws Exception  {
		perfilcampo.setPerfilCampoOriginal((PerfilCampo)perfilcampo.clone());		
	}
	
	public static void setPerfilCamposOriginalStatic(List<PerfilCampo> perfilcampos)throws Exception  {
		
		for(PerfilCampo perfilcampo:perfilcampos){
			perfilcampo.setPerfilCampoOriginal((PerfilCampo)perfilcampo.clone());
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
	
	public  PerfilCampo getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		PerfilCampo entity = new PerfilCampo();		
		
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
	
	public  PerfilCampo getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		PerfilCampo entity = new PerfilCampo();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PerfilCampoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PerfilCampoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Seguridad.PerfilCampo.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setPerfilCampoOriginal(new PerfilCampo());
      	    	entity=super.getEntity("",entity,resultSet,PerfilCampoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPerfilCampo("",entity,resultSet); 
				
				entity.setPerfilCampoOriginal(super.getEntity("",entity.getPerfilCampoOriginal(),resultSet,PerfilCampoDataAccess.ISWITHSCHEMA));         		
      	    	entity.setPerfilCampoOriginal(this.getEntityPerfilCampo("",entity.getPerfilCampoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalsePerfilCampo(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  PerfilCampo getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		PerfilCampo entity = new PerfilCampo();
				
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
	
	public  PerfilCampo getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		PerfilCampo entity = new PerfilCampo();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PerfilCampoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PerfilCampoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PerfilCampoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Seguridad.PerfilCampo.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setPerfilCampoOriginal(new PerfilCampo());
      	    	entity=super.getEntity("",entity,resultSet,PerfilCampoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPerfilCampo("",entity,resultSet);    
				
				entity.setPerfilCampoOriginal(super.getEntity("",entity.getPerfilCampoOriginal(),resultSet,PerfilCampoDataAccess.ISWITHSCHEMA));         		
      	    	entity.setPerfilCampoOriginal(this.getEntityPerfilCampo("",entity.getPerfilCampoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalsePerfilCampo(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //PerfilCampo
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		PerfilCampo entity = new PerfilCampo();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PerfilCampoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PerfilCampoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PerfilCampoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Seguridad.PerfilCampo.isActive=1
        	 
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
				//this.setIsNewIsChangedFalsePerfilCampo(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<PerfilCampo> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<PerfilCampo> entities = new  ArrayList<PerfilCampo>();
		PerfilCampo entity = new PerfilCampo();		  
		
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
	
	public  List<PerfilCampo> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<PerfilCampo> entities = new  ArrayList<PerfilCampo>();
		PerfilCampo entity = new PerfilCampo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=PerfilCampoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PerfilCampoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PerfilCampoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PerfilCampo();
      	    	entity=super.getEntity("",entity,resultSet,PerfilCampoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPerfilCampo("",entity,resultSet);
      	    	
				entity.setPerfilCampoOriginal( new PerfilCampo());
      	    	entity.setPerfilCampoOriginal(super.getEntity("",entity.getPerfilCampoOriginal(),resultSet,PerfilCampoDataAccess.ISWITHSCHEMA));         		
      	    	entity.setPerfilCampoOriginal(this.getEntityPerfilCampo("",entity.getPerfilCampoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePerfilCampos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPerfilCampo(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<PerfilCampo> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<PerfilCampo> entities = new  ArrayList<PerfilCampo>();
		PerfilCampo entity = new PerfilCampo();		  
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
	
	public  List<PerfilCampo> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<PerfilCampo> entities = new  ArrayList<PerfilCampo>();
		PerfilCampo entity = new PerfilCampo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PerfilCampo();
				
				if(conMapGenerico) {
					entity.inicializarMapPerfilCampo();
					//entity.setMapPerfilCampo(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapPerfilCampoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPerfilCampo().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PerfilCampoDataAccess.ISWITHSCHEMA);         		
					entity=PerfilCampoDataAccess.getEntityPerfilCampo("",entity,resultSet,listColumns,deepLoadType);
					
					//entity.setPerfilCampoOriginal( new PerfilCampo());
					//entity.setPerfilCampoOriginal(super.getEntity("",entity.getPerfilCampoOriginal(),resultSet,PerfilCampoDataAccess.ISWITHSCHEMA));         		
					//entity.setPerfilCampoOriginal(this.getEntityPerfilCampo("",entity.getPerfilCampoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePerfilCampos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPerfilCampo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public PerfilCampo getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		PerfilCampo entity = new PerfilCampo();		  
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
	
	public  PerfilCampo getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		PerfilCampo entity = new PerfilCampo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PerfilCampo();
				
				if(conMapGenerico) {
					entity.inicializarMapPerfilCampo();
					//entity.setMapPerfilCampo(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapPerfilCampoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPerfilCampo().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PerfilCampoDataAccess.ISWITHSCHEMA);         		
					entity=PerfilCampoDataAccess.getEntityPerfilCampo("",entity,resultSet,listColumns,deepLoadType);
					
					//entity.setPerfilCampoOriginal( new PerfilCampo());
					//entity.setPerfilCampoOriginal(super.getEntity("",entity.getPerfilCampoOriginal(),resultSet,PerfilCampoDataAccess.ISWITHSCHEMA));         		
					//entity.setPerfilCampoOriginal(this.getEntityPerfilCampo("",entity.getPerfilCampoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalsePerfilCampo(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPerfilCampo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static PerfilCampo getEntityPerfilCampo(String strPrefijo,PerfilCampo entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = PerfilCampo.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = PerfilCampo.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					PerfilCampoDataAccess.setFieldReflectionPerfilCampo(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasPerfilCampo=PerfilCampoConstantesFunciones.getTodosTiposColumnasPerfilCampo();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasPerfilCampo) {
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
							field = PerfilCampo.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = PerfilCampo.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						PerfilCampoDataAccess.setFieldReflectionPerfilCampo(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionPerfilCampo(Field field,String strPrefijo,String sColumn,PerfilCampo entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case PerfilCampoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PerfilCampoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PerfilCampoConstantesFunciones.IDPERFIL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PerfilCampoConstantesFunciones.IDCAMPO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PerfilCampoConstantesFunciones.TODO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case PerfilCampoConstantesFunciones.INGRESO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case PerfilCampoConstantesFunciones.MODIFICACION:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case PerfilCampoConstantesFunciones.ELIMINACION:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case PerfilCampoConstantesFunciones.CONSULTA:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case PerfilCampoConstantesFunciones.ESTADO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<PerfilCampo>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<PerfilCampo> entities = new  ArrayList<PerfilCampo>();
		PerfilCampo entity = new PerfilCampo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PerfilCampoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PerfilCampoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PerfilCampoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new PerfilCampo();
					entity=super.getEntity("",entity,resultSet,PerfilCampoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityPerfilCampo("",entity,resultSet);
					
					entity.setPerfilCampoOriginal( new PerfilCampo());
					entity.setPerfilCampoOriginal(super.getEntity("",entity.getPerfilCampoOriginal(),resultSet,PerfilCampoDataAccess.ISWITHSCHEMA));         		
					entity.setPerfilCampoOriginal(this.getEntityPerfilCampo("",entity.getPerfilCampoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalsePerfilCampos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPerfilCampo(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<PerfilCampo>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<PerfilCampo> entities = new  ArrayList<PerfilCampo>();
		PerfilCampo entity = new PerfilCampo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PerfilCampoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PerfilCampoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PerfilCampoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<PerfilCampo> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PerfilCampo> entities = new  ArrayList<PerfilCampo>();
		PerfilCampo entity = new PerfilCampo();		  
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
	
	public  List<PerfilCampo> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PerfilCampo> entities = new  ArrayList<PerfilCampo>();
		PerfilCampo entity = new PerfilCampo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PerfilCampo();
      	    	entity=super.getEntity("",entity,resultSet,PerfilCampoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPerfilCampo("",entity,resultSet);
      	    	
				entity.setPerfilCampoOriginal( new PerfilCampo());
      	    	entity.setPerfilCampoOriginal(super.getEntity("",entity.getPerfilCampoOriginal(),resultSet,PerfilCampoDataAccess.ISWITHSCHEMA));         		
      	    	entity.setPerfilCampoOriginal(this.getEntityPerfilCampo("",entity.getPerfilCampoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalsePerfilCampos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPerfilCampo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<PerfilCampo> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PerfilCampo> entities = new  ArrayList<PerfilCampo>();
		PerfilCampo entity = new PerfilCampo();		  
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
	
	public  List<PerfilCampo> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PerfilCampo> entities = new  ArrayList<PerfilCampo>();
		PerfilCampo entity = new PerfilCampo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PerfilCampo();
      	    	entity=super.getEntity("",entity,resultSet,PerfilCampoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPerfilCampo("",entity,resultSet);
      	    	
				entity.setPerfilCampoOriginal( new PerfilCampo());
      	    	entity.setPerfilCampoOriginal(super.getEntity("",entity.getPerfilCampoOriginal(),resultSet,PerfilCampoDataAccess.ISWITHSCHEMA));         		
      	    	entity.setPerfilCampoOriginal(this.getEntityPerfilCampo("",entity.getPerfilCampoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePerfilCampos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public PerfilCampo getEntityPerfilCampo(String strPrefijo,PerfilCampo entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_perfil(resultSet.getLong(strPrefijo+PerfilCampoConstantesFunciones.IDPERFIL));
				entity.setid_campo(resultSet.getLong(strPrefijo+PerfilCampoConstantesFunciones.IDCAMPO));
				entity.settodo(resultSet.getBoolean(strPrefijo+PerfilCampoConstantesFunciones.TODO));
				entity.setingreso(resultSet.getBoolean(strPrefijo+PerfilCampoConstantesFunciones.INGRESO));
				entity.setmodificacion(resultSet.getBoolean(strPrefijo+PerfilCampoConstantesFunciones.MODIFICACION));
				entity.seteliminacion(resultSet.getBoolean(strPrefijo+PerfilCampoConstantesFunciones.ELIMINACION));
				entity.setconsulta(resultSet.getBoolean(strPrefijo+PerfilCampoConstantesFunciones.CONSULTA));
				entity.setestado(resultSet.getBoolean(strPrefijo+PerfilCampoConstantesFunciones.ESTADO));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowPerfilCampo(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(PerfilCampo entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=PerfilCampoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=PerfilCampoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=PerfilCampoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=PerfilCampoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(PerfilCampoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,PerfilCampoDataAccess.TABLENAME,PerfilCampoDataAccess.ISWITHSTOREPROCEDURES);
			
			PerfilCampoDataAccess.setPerfilCampoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Perfil getPerfil(Connexion connexion,PerfilCampo relperfilcampo)throws SQLException,Exception {

		Perfil perfil= new Perfil();

		try {
			PerfilDataAccess perfilDataAccess=new PerfilDataAccess();

			perfilDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			perfilDataAccess.setConnexionType(this.connexionType);
			perfilDataAccess.setParameterDbType(this.parameterDbType);

			perfil=perfilDataAccess.getEntity(connexion,relperfilcampo.getid_perfil());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return perfil;

	}

	public Campo getCampo(Connexion connexion,PerfilCampo relperfilcampo)throws SQLException,Exception {

		Campo campo= new Campo();

		try {
			CampoDataAccess campoDataAccess=new CampoDataAccess();

			campoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			campoDataAccess.setConnexionType(this.connexionType);
			campoDataAccess.setParameterDbType(this.parameterDbType);

			campo=campoDataAccess.getEntity(connexion,relperfilcampo.getid_campo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return campo;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,PerfilCampo perfilcampo) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!perfilcampo.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_perfil=new ParameterValue<Long>();
					parameterMaintenanceValueid_perfil.setValue(perfilcampo.getid_perfil());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_perfil);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_campo=new ParameterValue<Long>();
					parameterMaintenanceValueid_campo.setValue(perfilcampo.getid_campo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_campo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuetodo=new ParameterValue<Boolean>();
					parameterMaintenanceValuetodo.setValue(perfilcampo.gettodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValueingreso=new ParameterValue<Boolean>();
					parameterMaintenanceValueingreso.setValue(perfilcampo.getingreso());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueingreso);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuemodificacion=new ParameterValue<Boolean>();
					parameterMaintenanceValuemodificacion.setValue(perfilcampo.getmodificacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuemodificacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValueeliminacion=new ParameterValue<Boolean>();
					parameterMaintenanceValueeliminacion.setValue(perfilcampo.geteliminacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueeliminacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValueconsulta=new ParameterValue<Boolean>();
					parameterMaintenanceValueconsulta.setValue(perfilcampo.getconsulta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueconsulta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValueestado=new ParameterValue<Boolean>();
					parameterMaintenanceValueestado.setValue(perfilcampo.getestado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueestado);
					parametersTemp.add(parameterMaintenance);
					
						if(!perfilcampo.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(perfilcampo.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(perfilcampo.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(perfilcampo.getId());
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
	
	public void setIsNewIsChangedFalsePerfilCampo(PerfilCampo perfilcampo)throws Exception  {		
		perfilcampo.setIsNew(false);
		perfilcampo.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalsePerfilCampos(List<PerfilCampo> perfilcampos)throws Exception  {				
		for(PerfilCampo perfilcampo:perfilcampos) {
			perfilcampo.setIsNew(false);
			perfilcampo.setIsChanged(false);
		}
	}
	
	public void generarExportarPerfilCampo(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
