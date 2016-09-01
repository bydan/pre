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
import com.bydan.erp.facturacion.util.*;//VigenciaFueConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class VigenciaFueDataAccess extends  VigenciaFueDataAccessAdditional{ //VigenciaFueDataAccessAdditional,DataAccessHelper<VigenciaFue>
	//static Logger logger = Logger.getLogger(VigenciaFueDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="vigencia_fue";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+VigenciaFueConstantesFunciones.SCHEMA+"."+VigenciaFueConstantesFunciones.TABLENAME+"(version_row,id_pais,id_ciudad,fecha_inicio,fecha_fin,numero_embarques,fue,fecha_ultimo_embarque,valor,numero_cajas,esta_activo)values(current_timestamp,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+VigenciaFueConstantesFunciones.SCHEMA+"."+VigenciaFueConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_pais=?,id_ciudad=?,fecha_inicio=?,fecha_fin=?,numero_embarques=?,fue=?,fecha_ultimo_embarque=?,valor=?,numero_cajas=?,esta_activo=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+VigenciaFueConstantesFunciones.SCHEMA+"."+VigenciaFueConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select vigenciafue from "+VigenciaFueConstantesFunciones.SPERSISTENCENAME+" vigenciafue";
	public static String QUERYSELECTNATIVE="select "+VigenciaFueConstantesFunciones.SCHEMA+"."+VigenciaFueConstantesFunciones.TABLENAME+".id,"+VigenciaFueConstantesFunciones.SCHEMA+"."+VigenciaFueConstantesFunciones.TABLENAME+".version_row,"+VigenciaFueConstantesFunciones.SCHEMA+"."+VigenciaFueConstantesFunciones.TABLENAME+".id_pais,"+VigenciaFueConstantesFunciones.SCHEMA+"."+VigenciaFueConstantesFunciones.TABLENAME+".id_ciudad,"+VigenciaFueConstantesFunciones.SCHEMA+"."+VigenciaFueConstantesFunciones.TABLENAME+".fecha_inicio,"+VigenciaFueConstantesFunciones.SCHEMA+"."+VigenciaFueConstantesFunciones.TABLENAME+".fecha_fin,"+VigenciaFueConstantesFunciones.SCHEMA+"."+VigenciaFueConstantesFunciones.TABLENAME+".numero_embarques,"+VigenciaFueConstantesFunciones.SCHEMA+"."+VigenciaFueConstantesFunciones.TABLENAME+".fue,"+VigenciaFueConstantesFunciones.SCHEMA+"."+VigenciaFueConstantesFunciones.TABLENAME+".fecha_ultimo_embarque,"+VigenciaFueConstantesFunciones.SCHEMA+"."+VigenciaFueConstantesFunciones.TABLENAME+".valor,"+VigenciaFueConstantesFunciones.SCHEMA+"."+VigenciaFueConstantesFunciones.TABLENAME+".numero_cajas,"+VigenciaFueConstantesFunciones.SCHEMA+"."+VigenciaFueConstantesFunciones.TABLENAME+".esta_activo from "+VigenciaFueConstantesFunciones.SCHEMA+"."+VigenciaFueConstantesFunciones.TABLENAME;//+" as "+VigenciaFueConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+VigenciaFueConstantesFunciones.SCHEMA+"."+VigenciaFueConstantesFunciones.TABLENAME+".id,"+VigenciaFueConstantesFunciones.SCHEMA+"."+VigenciaFueConstantesFunciones.TABLENAME+".version_row,"+VigenciaFueConstantesFunciones.SCHEMA+"."+VigenciaFueConstantesFunciones.TABLENAME+".fecha_inicio from "+VigenciaFueConstantesFunciones.SCHEMA+"."+VigenciaFueConstantesFunciones.TABLENAME;//+" as "+VigenciaFueConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+VigenciaFueConstantesFunciones.SCHEMA+"."+VigenciaFueConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_pais=?,id_ciudad=?,fecha_inicio=?,fecha_fin=?,numero_embarques=?,fue=?,fecha_ultimo_embarque=?,valor=?,numero_cajas=?,esta_activo=?";
	
	public static String STOREPROCEDUREINSERT="call SP_VIGENCIAFUE_INSERT(?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_VIGENCIAFUE_UPDATE(?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_VIGENCIAFUE_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_VIGENCIAFUE_SELECT(?,?)";
	
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
	
	
	protected VigenciaFueDataAccessAdditional vigenciafueDataAccessAdditional=null;
	
	public VigenciaFueDataAccessAdditional getVigenciaFueDataAccessAdditional() {
		return this.vigenciafueDataAccessAdditional;
	}
	
	public void setVigenciaFueDataAccessAdditional(VigenciaFueDataAccessAdditional vigenciafueDataAccessAdditional) {
		try {
			this.vigenciafueDataAccessAdditional=vigenciafueDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public VigenciaFueDataAccess() {
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
		VigenciaFueDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		VigenciaFueDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		VigenciaFueDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setVigenciaFueOriginal(VigenciaFue vigenciafue)throws Exception  {
		vigenciafue.setVigenciaFueOriginal((VigenciaFue)vigenciafue.clone());		
	}
	
	public void setVigenciaFuesOriginal(List<VigenciaFue> vigenciafues)throws Exception  {
		
		for(VigenciaFue vigenciafue:vigenciafues){
			vigenciafue.setVigenciaFueOriginal((VigenciaFue)vigenciafue.clone());
		}
	}
	
	public static void setVigenciaFueOriginalStatic(VigenciaFue vigenciafue)throws Exception  {
		vigenciafue.setVigenciaFueOriginal((VigenciaFue)vigenciafue.clone());		
	}
	
	public static void setVigenciaFuesOriginalStatic(List<VigenciaFue> vigenciafues)throws Exception  {
		
		for(VigenciaFue vigenciafue:vigenciafues){
			vigenciafue.setVigenciaFueOriginal((VigenciaFue)vigenciafue.clone());
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
	
	public  VigenciaFue getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		VigenciaFue entity = new VigenciaFue();		
		
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
	
	public  VigenciaFue getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		VigenciaFue entity = new VigenciaFue();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=VigenciaFueDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=VigenciaFueDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Facturacion.VigenciaFue.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setVigenciaFueOriginal(new VigenciaFue());
      	    	entity=super.getEntity("",entity,resultSet,VigenciaFueDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityVigenciaFue("",entity,resultSet); 
				
				//entity.setVigenciaFueOriginal(super.getEntity("",entity.getVigenciaFueOriginal(),resultSet,VigenciaFueDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setVigenciaFueOriginal(this.getEntityVigenciaFue("",entity.getVigenciaFueOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseVigenciaFue(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  VigenciaFue getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		VigenciaFue entity = new VigenciaFue();
				
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
	
	public  VigenciaFue getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		VigenciaFue entity = new VigenciaFue();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=VigenciaFueDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=VigenciaFueDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,VigenciaFueDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.VigenciaFue.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setVigenciaFueOriginal(new VigenciaFue());
      	    	entity=super.getEntity("",entity,resultSet,VigenciaFueDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityVigenciaFue("",entity,resultSet);    
				
				//entity.setVigenciaFueOriginal(super.getEntity("",entity.getVigenciaFueOriginal(),resultSet,VigenciaFueDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setVigenciaFueOriginal(this.getEntityVigenciaFue("",entity.getVigenciaFueOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseVigenciaFue(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //VigenciaFue
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		VigenciaFue entity = new VigenciaFue();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=VigenciaFueDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=VigenciaFueDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,VigenciaFueDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.VigenciaFue.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseVigenciaFue(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<VigenciaFue> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<VigenciaFue> entities = new  ArrayList<VigenciaFue>();
		VigenciaFue entity = new VigenciaFue();		  
		
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
	
	public  List<VigenciaFue> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<VigenciaFue> entities = new  ArrayList<VigenciaFue>();
		VigenciaFue entity = new VigenciaFue();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=VigenciaFueDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=VigenciaFueDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,VigenciaFueDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new VigenciaFue();
      	    	entity=super.getEntity("",entity,resultSet,VigenciaFueDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityVigenciaFue("",entity,resultSet);
      	    	
				//entity.setVigenciaFueOriginal( new VigenciaFue());
      	    	//entity.setVigenciaFueOriginal(super.getEntity("",entity.getVigenciaFueOriginal(),resultSet,VigenciaFueDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setVigenciaFueOriginal(this.getEntityVigenciaFue("",entity.getVigenciaFueOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseVigenciaFues(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarVigenciaFue(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<VigenciaFue> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<VigenciaFue> entities = new  ArrayList<VigenciaFue>();
		VigenciaFue entity = new VigenciaFue();		  
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
	
	public  List<VigenciaFue> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<VigenciaFue> entities = new  ArrayList<VigenciaFue>();
		VigenciaFue entity = new VigenciaFue();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new VigenciaFue();
				
				if(conMapGenerico) {
					entity.inicializarMapVigenciaFue();
					//entity.setMapVigenciaFue(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapVigenciaFueValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapVigenciaFue().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,VigenciaFueDataAccess.ISWITHSCHEMA);         		
					entity=VigenciaFueDataAccess.getEntityVigenciaFue("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setVigenciaFueOriginal( new VigenciaFue());
					////entity.setVigenciaFueOriginal(super.getEntity("",entity.getVigenciaFueOriginal(),resultSet,VigenciaFueDataAccess.ISWITHSCHEMA));         		
					////entity.setVigenciaFueOriginal(this.getEntityVigenciaFue("",entity.getVigenciaFueOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseVigenciaFues(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarVigenciaFue(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public VigenciaFue getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		VigenciaFue entity = new VigenciaFue();		  
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
	
	public  VigenciaFue getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		VigenciaFue entity = new VigenciaFue();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new VigenciaFue();
				
				if(conMapGenerico) {
					entity.inicializarMapVigenciaFue();
					//entity.setMapVigenciaFue(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapVigenciaFueValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapVigenciaFue().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,VigenciaFueDataAccess.ISWITHSCHEMA);         		
					entity=VigenciaFueDataAccess.getEntityVigenciaFue("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setVigenciaFueOriginal( new VigenciaFue());
					////entity.setVigenciaFueOriginal(super.getEntity("",entity.getVigenciaFueOriginal(),resultSet,VigenciaFueDataAccess.ISWITHSCHEMA));         		
					////entity.setVigenciaFueOriginal(this.getEntityVigenciaFue("",entity.getVigenciaFueOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseVigenciaFue(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarVigenciaFue(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static VigenciaFue getEntityVigenciaFue(String strPrefijo,VigenciaFue entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = VigenciaFue.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = VigenciaFue.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					VigenciaFueDataAccess.setFieldReflectionVigenciaFue(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasVigenciaFue=VigenciaFueConstantesFunciones.getTodosTiposColumnasVigenciaFue();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasVigenciaFue) {
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
							field = VigenciaFue.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = VigenciaFue.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						VigenciaFueDataAccess.setFieldReflectionVigenciaFue(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionVigenciaFue(Field field,String strPrefijo,String sColumn,VigenciaFue entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case VigenciaFueConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case VigenciaFueConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case VigenciaFueConstantesFunciones.IDPAIS:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case VigenciaFueConstantesFunciones.IDCIUDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case VigenciaFueConstantesFunciones.FECHAINICIO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case VigenciaFueConstantesFunciones.FECHAFIN:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case VigenciaFueConstantesFunciones.NUMEROEMBARQUES:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case VigenciaFueConstantesFunciones.FUE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case VigenciaFueConstantesFunciones.FECHAULTIMOEMBARQUE:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case VigenciaFueConstantesFunciones.VALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case VigenciaFueConstantesFunciones.NUMEROCAJAS:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case VigenciaFueConstantesFunciones.ESTAACTIVO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<VigenciaFue>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<VigenciaFue> entities = new  ArrayList<VigenciaFue>();
		VigenciaFue entity = new VigenciaFue();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=VigenciaFueDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=VigenciaFueDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,VigenciaFueDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new VigenciaFue();
					entity=super.getEntity("",entity,resultSet,VigenciaFueDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityVigenciaFue("",entity,resultSet);
					
					//entity.setVigenciaFueOriginal( new VigenciaFue());
					//entity.setVigenciaFueOriginal(super.getEntity("",entity.getVigenciaFueOriginal(),resultSet,VigenciaFueDataAccess.ISWITHSCHEMA));         		
					//entity.setVigenciaFueOriginal(this.getEntityVigenciaFue("",entity.getVigenciaFueOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseVigenciaFues(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarVigenciaFue(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<VigenciaFue>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<VigenciaFue> entities = new  ArrayList<VigenciaFue>();
		VigenciaFue entity = new VigenciaFue();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=VigenciaFueDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=VigenciaFueDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,VigenciaFueDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<VigenciaFue> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<VigenciaFue> entities = new  ArrayList<VigenciaFue>();
		VigenciaFue entity = new VigenciaFue();		  
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
	
	public  List<VigenciaFue> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<VigenciaFue> entities = new  ArrayList<VigenciaFue>();
		VigenciaFue entity = new VigenciaFue();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new VigenciaFue();
      	    	entity=super.getEntity("",entity,resultSet,VigenciaFueDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityVigenciaFue("",entity,resultSet);
      	    	
				//entity.setVigenciaFueOriginal( new VigenciaFue());
      	    	//entity.setVigenciaFueOriginal(super.getEntity("",entity.getVigenciaFueOriginal(),resultSet,VigenciaFueDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setVigenciaFueOriginal(this.getEntityVigenciaFue("",entity.getVigenciaFueOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseVigenciaFues(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarVigenciaFue(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<VigenciaFue> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<VigenciaFue> entities = new  ArrayList<VigenciaFue>();
		VigenciaFue entity = new VigenciaFue();		  
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
	
	public  List<VigenciaFue> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<VigenciaFue> entities = new  ArrayList<VigenciaFue>();
		VigenciaFue entity = new VigenciaFue();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new VigenciaFue();
      	    	entity=super.getEntity("",entity,resultSet,VigenciaFueDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityVigenciaFue("",entity,resultSet);
      	    	
				//entity.setVigenciaFueOriginal( new VigenciaFue());
      	    	//entity.setVigenciaFueOriginal(super.getEntity("",entity.getVigenciaFueOriginal(),resultSet,VigenciaFueDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setVigenciaFueOriginal(this.getEntityVigenciaFue("",entity.getVigenciaFueOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseVigenciaFues(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public VigenciaFue getEntityVigenciaFue(String strPrefijo,VigenciaFue entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_pais(resultSet.getLong(strPrefijo+VigenciaFueConstantesFunciones.IDPAIS));
				entity.setid_ciudad(resultSet.getLong(strPrefijo+VigenciaFueConstantesFunciones.IDCIUDAD));
				entity.setfecha_inicio(new Date(resultSet.getDate(strPrefijo+VigenciaFueConstantesFunciones.FECHAINICIO).getTime()));
				entity.setfecha_fin(new Date(resultSet.getDate(strPrefijo+VigenciaFueConstantesFunciones.FECHAFIN).getTime()));
				entity.setnumero_embarques(resultSet.getInt(strPrefijo+VigenciaFueConstantesFunciones.NUMEROEMBARQUES));
				entity.setfue(resultSet.getString(strPrefijo+VigenciaFueConstantesFunciones.FUE));
				entity.setfecha_ultimo_embarque(new Date(resultSet.getDate(strPrefijo+VigenciaFueConstantesFunciones.FECHAULTIMOEMBARQUE).getTime()));
				entity.setvalor(resultSet.getDouble(strPrefijo+VigenciaFueConstantesFunciones.VALOR));
				entity.setnumero_cajas(resultSet.getInt(strPrefijo+VigenciaFueConstantesFunciones.NUMEROCAJAS));
				entity.setesta_activo(resultSet.getBoolean(strPrefijo+VigenciaFueConstantesFunciones.ESTAACTIVO));
			} else {
				entity.setfecha_inicio(new Date(resultSet.getDate(strPrefijo+VigenciaFueConstantesFunciones.FECHAINICIO).getTime()));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowVigenciaFue(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(VigenciaFue entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=VigenciaFueDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=VigenciaFueDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=VigenciaFueDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=VigenciaFueDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(VigenciaFueConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,VigenciaFueDataAccess.TABLENAME,VigenciaFueDataAccess.ISWITHSTOREPROCEDURES);
			
			VigenciaFueDataAccess.setVigenciaFueOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Pais getPais(Connexion connexion,VigenciaFue relvigenciafue)throws SQLException,Exception {

		Pais pais= new Pais();

		try {
			PaisDataAccess paisDataAccess=new PaisDataAccess();

			paisDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			paisDataAccess.setConnexionType(this.connexionType);
			paisDataAccess.setParameterDbType(this.parameterDbType);

			pais=paisDataAccess.getEntity(connexion,relvigenciafue.getid_pais());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pais;

	}

	public Ciudad getCiudad(Connexion connexion,VigenciaFue relvigenciafue)throws SQLException,Exception {

		Ciudad ciudad= new Ciudad();

		try {
			CiudadDataAccess ciudadDataAccess=new CiudadDataAccess();

			ciudadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ciudadDataAccess.setConnexionType(this.connexionType);
			ciudadDataAccess.setParameterDbType(this.parameterDbType);

			ciudad=ciudadDataAccess.getEntity(connexion,relvigenciafue.getid_ciudad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ciudad;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,VigenciaFue vigenciafue) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!vigenciafue.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_pais=new ParameterValue<Long>();
					parameterMaintenanceValueid_pais.setValue(vigenciafue.getid_pais());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_pais);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ciudad=new ParameterValue<Long>();
					parameterMaintenanceValueid_ciudad.setValue(vigenciafue.getid_ciudad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ciudad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_inicio=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_inicio.setValue(vigenciafue.getfecha_inicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_inicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_fin=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_fin.setValue(vigenciafue.getfecha_fin());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_fin);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuenumero_embarques=new ParameterValue<Integer>();
					parameterMaintenanceValuenumero_embarques.setValue(vigenciafue.getnumero_embarques());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_embarques);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuefue=new ParameterValue<String>();
					parameterMaintenanceValuefue.setValue(vigenciafue.getfue());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefue);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_ultimo_embarque=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_ultimo_embarque.setValue(vigenciafue.getfecha_ultimo_embarque());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_ultimo_embarque);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor=new ParameterValue<Double>();
					parameterMaintenanceValuevalor.setValue(vigenciafue.getvalor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuenumero_cajas=new ParameterValue<Integer>();
					parameterMaintenanceValuenumero_cajas.setValue(vigenciafue.getnumero_cajas());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_cajas);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValueesta_activo=new ParameterValue<Boolean>();
					parameterMaintenanceValueesta_activo.setValue(vigenciafue.getesta_activo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueesta_activo);
					parametersTemp.add(parameterMaintenance);
					
						if(!vigenciafue.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(vigenciafue.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(vigenciafue.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(vigenciafue.getId());
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
	
	public void setIsNewIsChangedFalseVigenciaFue(VigenciaFue vigenciafue)throws Exception  {		
		vigenciafue.setIsNew(false);
		vigenciafue.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseVigenciaFues(List<VigenciaFue> vigenciafues)throws Exception  {				
		for(VigenciaFue vigenciafue:vigenciafues) {
			vigenciafue.setIsNew(false);
			vigenciafue.setIsChanged(false);
		}
	}
	
	public void generarExportarVigenciaFue(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
