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
package com.bydan.erp.comisiones.business.dataaccess;

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

import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.comisiones.util.*;//ComisionMarcaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;




@SuppressWarnings("unused")
final public class ComisionMarcaDataAccess extends  ComisionMarcaDataAccessAdditional{ //ComisionMarcaDataAccessAdditional,DataAccessHelper<ComisionMarca>
	//static Logger logger = Logger.getLogger(ComisionMarcaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="comision_marca";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ComisionMarcaConstantesFunciones.SCHEMA+"."+ComisionMarcaConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_comision_config,id_vendedor,id_linea,id_linea_grupo,id_linea_categoria,id_linea_marca,id_estado_comision,porcentaje,descripcion)values(current_timestamp,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+ComisionMarcaConstantesFunciones.SCHEMA+"."+ComisionMarcaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_comision_config=?,id_vendedor=?,id_linea=?,id_linea_grupo=?,id_linea_categoria=?,id_linea_marca=?,id_estado_comision=?,porcentaje=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ComisionMarcaConstantesFunciones.SCHEMA+"."+ComisionMarcaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select comisionmarca from "+ComisionMarcaConstantesFunciones.SPERSISTENCENAME+" comisionmarca";
	public static String QUERYSELECTNATIVE="select "+ComisionMarcaConstantesFunciones.SCHEMA+"."+ComisionMarcaConstantesFunciones.TABLENAME+".id,"+ComisionMarcaConstantesFunciones.SCHEMA+"."+ComisionMarcaConstantesFunciones.TABLENAME+".version_row,"+ComisionMarcaConstantesFunciones.SCHEMA+"."+ComisionMarcaConstantesFunciones.TABLENAME+".id_empresa,"+ComisionMarcaConstantesFunciones.SCHEMA+"."+ComisionMarcaConstantesFunciones.TABLENAME+".id_comision_config,"+ComisionMarcaConstantesFunciones.SCHEMA+"."+ComisionMarcaConstantesFunciones.TABLENAME+".id_vendedor,"+ComisionMarcaConstantesFunciones.SCHEMA+"."+ComisionMarcaConstantesFunciones.TABLENAME+".id_linea,"+ComisionMarcaConstantesFunciones.SCHEMA+"."+ComisionMarcaConstantesFunciones.TABLENAME+".id_linea_grupo,"+ComisionMarcaConstantesFunciones.SCHEMA+"."+ComisionMarcaConstantesFunciones.TABLENAME+".id_linea_categoria,"+ComisionMarcaConstantesFunciones.SCHEMA+"."+ComisionMarcaConstantesFunciones.TABLENAME+".id_linea_marca,"+ComisionMarcaConstantesFunciones.SCHEMA+"."+ComisionMarcaConstantesFunciones.TABLENAME+".id_estado_comision,"+ComisionMarcaConstantesFunciones.SCHEMA+"."+ComisionMarcaConstantesFunciones.TABLENAME+".porcentaje,"+ComisionMarcaConstantesFunciones.SCHEMA+"."+ComisionMarcaConstantesFunciones.TABLENAME+".descripcion from "+ComisionMarcaConstantesFunciones.SCHEMA+"."+ComisionMarcaConstantesFunciones.TABLENAME;//+" as "+ComisionMarcaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ComisionMarcaConstantesFunciones.SCHEMA+"."+ComisionMarcaConstantesFunciones.TABLENAME+".id,"+ComisionMarcaConstantesFunciones.SCHEMA+"."+ComisionMarcaConstantesFunciones.TABLENAME+".version_row from "+ComisionMarcaConstantesFunciones.SCHEMA+"."+ComisionMarcaConstantesFunciones.TABLENAME;//+" as "+ComisionMarcaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ComisionMarcaConstantesFunciones.SCHEMA+"."+ComisionMarcaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_comision_config=?,id_vendedor=?,id_linea=?,id_linea_grupo=?,id_linea_categoria=?,id_linea_marca=?,id_estado_comision=?,porcentaje=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_COMISIONMARCA_INSERT(?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_COMISIONMARCA_UPDATE(?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_COMISIONMARCA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_COMISIONMARCA_SELECT(?,?)";
	
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
	
	
	protected ComisionMarcaDataAccessAdditional comisionmarcaDataAccessAdditional=null;
	
	public ComisionMarcaDataAccessAdditional getComisionMarcaDataAccessAdditional() {
		return this.comisionmarcaDataAccessAdditional;
	}
	
	public void setComisionMarcaDataAccessAdditional(ComisionMarcaDataAccessAdditional comisionmarcaDataAccessAdditional) {
		try {
			this.comisionmarcaDataAccessAdditional=comisionmarcaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ComisionMarcaDataAccess() {
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
		ComisionMarcaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ComisionMarcaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ComisionMarcaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setComisionMarcaOriginal(ComisionMarca comisionmarca)throws Exception  {
		comisionmarca.setComisionMarcaOriginal((ComisionMarca)comisionmarca.clone());		
	}
	
	public void setComisionMarcasOriginal(List<ComisionMarca> comisionmarcas)throws Exception  {
		
		for(ComisionMarca comisionmarca:comisionmarcas){
			comisionmarca.setComisionMarcaOriginal((ComisionMarca)comisionmarca.clone());
		}
	}
	
	public static void setComisionMarcaOriginalStatic(ComisionMarca comisionmarca)throws Exception  {
		comisionmarca.setComisionMarcaOriginal((ComisionMarca)comisionmarca.clone());		
	}
	
	public static void setComisionMarcasOriginalStatic(List<ComisionMarca> comisionmarcas)throws Exception  {
		
		for(ComisionMarca comisionmarca:comisionmarcas){
			comisionmarca.setComisionMarcaOriginal((ComisionMarca)comisionmarca.clone());
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
	
	public  ComisionMarca getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		ComisionMarca entity = new ComisionMarca();		
		
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
	
	public  ComisionMarca getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		ComisionMarca entity = new ComisionMarca();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ComisionMarcaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ComisionMarcaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Comisiones.ComisionMarca.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setComisionMarcaOriginal(new ComisionMarca());
      	    	entity=super.getEntity("",entity,resultSet,ComisionMarcaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityComisionMarca("",entity,resultSet); 
				
				//entity.setComisionMarcaOriginal(super.getEntity("",entity.getComisionMarcaOriginal(),resultSet,ComisionMarcaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setComisionMarcaOriginal(this.getEntityComisionMarca("",entity.getComisionMarcaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseComisionMarca(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  ComisionMarca getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ComisionMarca entity = new ComisionMarca();
				
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
	
	public  ComisionMarca getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ComisionMarca entity = new ComisionMarca();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ComisionMarcaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ComisionMarcaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ComisionMarcaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Comisiones.ComisionMarca.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setComisionMarcaOriginal(new ComisionMarca());
      	    	entity=super.getEntity("",entity,resultSet,ComisionMarcaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityComisionMarca("",entity,resultSet);    
				
				//entity.setComisionMarcaOriginal(super.getEntity("",entity.getComisionMarcaOriginal(),resultSet,ComisionMarcaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setComisionMarcaOriginal(this.getEntityComisionMarca("",entity.getComisionMarcaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseComisionMarca(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //ComisionMarca
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		ComisionMarca entity = new ComisionMarca();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ComisionMarcaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ComisionMarcaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ComisionMarcaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Comisiones.ComisionMarca.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseComisionMarca(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<ComisionMarca> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ComisionMarca> entities = new  ArrayList<ComisionMarca>();
		ComisionMarca entity = new ComisionMarca();		  
		
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
	
	public  List<ComisionMarca> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ComisionMarca> entities = new  ArrayList<ComisionMarca>();
		ComisionMarca entity = new ComisionMarca();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ComisionMarcaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ComisionMarcaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ComisionMarcaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ComisionMarca();
      	    	entity=super.getEntity("",entity,resultSet,ComisionMarcaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityComisionMarca("",entity,resultSet);
      	    	
				//entity.setComisionMarcaOriginal( new ComisionMarca());
      	    	//entity.setComisionMarcaOriginal(super.getEntity("",entity.getComisionMarcaOriginal(),resultSet,ComisionMarcaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setComisionMarcaOriginal(this.getEntityComisionMarca("",entity.getComisionMarcaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseComisionMarcas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarComisionMarca(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ComisionMarca> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ComisionMarca> entities = new  ArrayList<ComisionMarca>();
		ComisionMarca entity = new ComisionMarca();		  
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
	
	public  List<ComisionMarca> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ComisionMarca> entities = new  ArrayList<ComisionMarca>();
		ComisionMarca entity = new ComisionMarca();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ComisionMarca();
				
				if(conMapGenerico) {
					entity.inicializarMapComisionMarca();
					//entity.setMapComisionMarca(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapComisionMarcaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapComisionMarca().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ComisionMarcaDataAccess.ISWITHSCHEMA);         		
					entity=ComisionMarcaDataAccess.getEntityComisionMarca("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setComisionMarcaOriginal( new ComisionMarca());
					////entity.setComisionMarcaOriginal(super.getEntity("",entity.getComisionMarcaOriginal(),resultSet,ComisionMarcaDataAccess.ISWITHSCHEMA));         		
					////entity.setComisionMarcaOriginal(this.getEntityComisionMarca("",entity.getComisionMarcaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseComisionMarcas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarComisionMarca(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public ComisionMarca getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ComisionMarca entity = new ComisionMarca();		  
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
	
	public  ComisionMarca getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ComisionMarca entity = new ComisionMarca();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ComisionMarca();
				
				if(conMapGenerico) {
					entity.inicializarMapComisionMarca();
					//entity.setMapComisionMarca(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapComisionMarcaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapComisionMarca().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ComisionMarcaDataAccess.ISWITHSCHEMA);         		
					entity=ComisionMarcaDataAccess.getEntityComisionMarca("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setComisionMarcaOriginal( new ComisionMarca());
					////entity.setComisionMarcaOriginal(super.getEntity("",entity.getComisionMarcaOriginal(),resultSet,ComisionMarcaDataAccess.ISWITHSCHEMA));         		
					////entity.setComisionMarcaOriginal(this.getEntityComisionMarca("",entity.getComisionMarcaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseComisionMarca(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarComisionMarca(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ComisionMarca getEntityComisionMarca(String strPrefijo,ComisionMarca entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = ComisionMarca.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = ComisionMarca.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ComisionMarcaDataAccess.setFieldReflectionComisionMarca(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasComisionMarca=ComisionMarcaConstantesFunciones.getTodosTiposColumnasComisionMarca();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasComisionMarca) {
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
							field = ComisionMarca.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = ComisionMarca.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ComisionMarcaDataAccess.setFieldReflectionComisionMarca(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionComisionMarca(Field field,String strPrefijo,String sColumn,ComisionMarca entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ComisionMarcaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ComisionMarcaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ComisionMarcaConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ComisionMarcaConstantesFunciones.IDCOMISIONCONFIG:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ComisionMarcaConstantesFunciones.IDVENDEDOR:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ComisionMarcaConstantesFunciones.IDLINEA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ComisionMarcaConstantesFunciones.IDLINEAGRUPO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ComisionMarcaConstantesFunciones.IDLINEACATEGORIA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ComisionMarcaConstantesFunciones.IDLINEAMARCA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ComisionMarcaConstantesFunciones.IDESTADOCOMISION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ComisionMarcaConstantesFunciones.PORCENTAJE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ComisionMarcaConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ComisionMarca>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<ComisionMarca> entities = new  ArrayList<ComisionMarca>();
		ComisionMarca entity = new ComisionMarca();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ComisionMarcaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ComisionMarcaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ComisionMarcaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new ComisionMarca();
					entity=super.getEntity("",entity,resultSet,ComisionMarcaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityComisionMarca("",entity,resultSet);
					
					//entity.setComisionMarcaOriginal( new ComisionMarca());
					//entity.setComisionMarcaOriginal(super.getEntity("",entity.getComisionMarcaOriginal(),resultSet,ComisionMarcaDataAccess.ISWITHSCHEMA));         		
					//entity.setComisionMarcaOriginal(this.getEntityComisionMarca("",entity.getComisionMarcaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseComisionMarcas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarComisionMarca(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ComisionMarca>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<ComisionMarca> entities = new  ArrayList<ComisionMarca>();
		ComisionMarca entity = new ComisionMarca();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ComisionMarcaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ComisionMarcaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ComisionMarcaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<ComisionMarca> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ComisionMarca> entities = new  ArrayList<ComisionMarca>();
		ComisionMarca entity = new ComisionMarca();		  
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
	
	public  List<ComisionMarca> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ComisionMarca> entities = new  ArrayList<ComisionMarca>();
		ComisionMarca entity = new ComisionMarca();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ComisionMarca();
      	    	entity=super.getEntity("",entity,resultSet,ComisionMarcaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityComisionMarca("",entity,resultSet);
      	    	
				//entity.setComisionMarcaOriginal( new ComisionMarca());
      	    	//entity.setComisionMarcaOriginal(super.getEntity("",entity.getComisionMarcaOriginal(),resultSet,ComisionMarcaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setComisionMarcaOriginal(this.getEntityComisionMarca("",entity.getComisionMarcaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseComisionMarcas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarComisionMarca(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ComisionMarca> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ComisionMarca> entities = new  ArrayList<ComisionMarca>();
		ComisionMarca entity = new ComisionMarca();		  
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
	
	public  List<ComisionMarca> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ComisionMarca> entities = new  ArrayList<ComisionMarca>();
		ComisionMarca entity = new ComisionMarca();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ComisionMarca();
      	    	entity=super.getEntity("",entity,resultSet,ComisionMarcaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityComisionMarca("",entity,resultSet);
      	    	
				//entity.setComisionMarcaOriginal( new ComisionMarca());
      	    	//entity.setComisionMarcaOriginal(super.getEntity("",entity.getComisionMarcaOriginal(),resultSet,ComisionMarcaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setComisionMarcaOriginal(this.getEntityComisionMarca("",entity.getComisionMarcaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseComisionMarcas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public ComisionMarca getEntityComisionMarca(String strPrefijo,ComisionMarca entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+ComisionMarcaConstantesFunciones.IDEMPRESA));
				entity.setid_comision_config(resultSet.getLong(strPrefijo+ComisionMarcaConstantesFunciones.IDCOMISIONCONFIG));
				entity.setid_vendedor(resultSet.getLong(strPrefijo+ComisionMarcaConstantesFunciones.IDVENDEDOR));
				entity.setid_linea(resultSet.getLong(strPrefijo+ComisionMarcaConstantesFunciones.IDLINEA));
				entity.setid_linea_grupo(resultSet.getLong(strPrefijo+ComisionMarcaConstantesFunciones.IDLINEAGRUPO));
				entity.setid_linea_categoria(resultSet.getLong(strPrefijo+ComisionMarcaConstantesFunciones.IDLINEACATEGORIA));
				entity.setid_linea_marca(resultSet.getLong(strPrefijo+ComisionMarcaConstantesFunciones.IDLINEAMARCA));
				entity.setid_estado_comision(resultSet.getLong(strPrefijo+ComisionMarcaConstantesFunciones.IDESTADOCOMISION));
				entity.setporcentaje(resultSet.getDouble(strPrefijo+ComisionMarcaConstantesFunciones.PORCENTAJE));
				entity.setdescripcion(resultSet.getString(strPrefijo+ComisionMarcaConstantesFunciones.DESCRIPCION));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowComisionMarca(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(ComisionMarca entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ComisionMarcaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ComisionMarcaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ComisionMarcaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ComisionMarcaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ComisionMarcaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ComisionMarcaDataAccess.TABLENAME,ComisionMarcaDataAccess.ISWITHSTOREPROCEDURES);
			
			ComisionMarcaDataAccess.setComisionMarcaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,ComisionMarca relcomisionmarca)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relcomisionmarca.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public ComisionConfig getComisionConfig(Connexion connexion,ComisionMarca relcomisionmarca)throws SQLException,Exception {

		ComisionConfig comisionconfig= new ComisionConfig();

		try {
			ComisionConfigDataAccess comisionconfigDataAccess=new ComisionConfigDataAccess();

			comisionconfigDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			comisionconfigDataAccess.setConnexionType(this.connexionType);
			comisionconfigDataAccess.setParameterDbType(this.parameterDbType);

			comisionconfig=comisionconfigDataAccess.getEntity(connexion,relcomisionmarca.getid_comision_config());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return comisionconfig;

	}

	public Vendedor getVendedor(Connexion connexion,ComisionMarca relcomisionmarca)throws SQLException,Exception {

		Vendedor vendedor= new Vendedor();

		try {
			VendedorDataAccess vendedorDataAccess=new VendedorDataAccess();

			vendedorDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			vendedorDataAccess.setConnexionType(this.connexionType);
			vendedorDataAccess.setParameterDbType(this.parameterDbType);

			vendedor=vendedorDataAccess.getEntity(connexion,relcomisionmarca.getid_vendedor());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return vendedor;

	}

	public Linea getLinea(Connexion connexion,ComisionMarca relcomisionmarca)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);

			linea=lineaDataAccess.getEntity(connexion,relcomisionmarca.getid_linea());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaGrupo(Connexion connexion,ComisionMarca relcomisionmarca)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);

			linea=lineaDataAccess.getEntity(connexion,relcomisionmarca.getid_linea_grupo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaCategoria(Connexion connexion,ComisionMarca relcomisionmarca)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);

			linea=lineaDataAccess.getEntity(connexion,relcomisionmarca.getid_linea_categoria());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaMarca(Connexion connexion,ComisionMarca relcomisionmarca)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);

			linea=lineaDataAccess.getEntity(connexion,relcomisionmarca.getid_linea_marca());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public EstadoComision getEstadoComision(Connexion connexion,ComisionMarca relcomisionmarca)throws SQLException,Exception {

		EstadoComision estadocomision= new EstadoComision();

		try {
			EstadoComisionDataAccess estadocomisionDataAccess=new EstadoComisionDataAccess();

			estadocomisionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadocomisionDataAccess.setConnexionType(this.connexionType);
			estadocomisionDataAccess.setParameterDbType(this.parameterDbType);

			estadocomision=estadocomisionDataAccess.getEntity(connexion,relcomisionmarca.getid_estado_comision());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadocomision;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,ComisionMarca comisionmarca) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!comisionmarca.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(comisionmarca.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_comision_config=new ParameterValue<Long>();
					parameterMaintenanceValueid_comision_config.setValue(comisionmarca.getid_comision_config());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_comision_config);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_vendedor=new ParameterValue<Long>();
					parameterMaintenanceValueid_vendedor.setValue(comisionmarca.getid_vendedor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_vendedor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_linea=new ParameterValue<Long>();
					parameterMaintenanceValueid_linea.setValue(comisionmarca.getid_linea());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_linea);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_linea_grupo=new ParameterValue<Long>();
					parameterMaintenanceValueid_linea_grupo.setValue(comisionmarca.getid_linea_grupo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_linea_grupo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_linea_categoria=new ParameterValue<Long>();
					parameterMaintenanceValueid_linea_categoria.setValue(comisionmarca.getid_linea_categoria());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_linea_categoria);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_linea_marca=new ParameterValue<Long>();
					parameterMaintenanceValueid_linea_marca.setValue(comisionmarca.getid_linea_marca());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_linea_marca);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_comision=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_comision.setValue(comisionmarca.getid_estado_comision());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_comision);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcentaje=new ParameterValue<Double>();
					parameterMaintenanceValueporcentaje.setValue(comisionmarca.getporcentaje());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcentaje);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(comisionmarca.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!comisionmarca.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(comisionmarca.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(comisionmarca.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(comisionmarca.getId());
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
	
	public void setIsNewIsChangedFalseComisionMarca(ComisionMarca comisionmarca)throws Exception  {		
		comisionmarca.setIsNew(false);
		comisionmarca.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseComisionMarcas(List<ComisionMarca> comisionmarcas)throws Exception  {				
		for(ComisionMarca comisionmarca:comisionmarcas) {
			comisionmarca.setIsNew(false);
			comisionmarca.setIsChanged(false);
		}
	}
	
	public void generarExportarComisionMarca(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
