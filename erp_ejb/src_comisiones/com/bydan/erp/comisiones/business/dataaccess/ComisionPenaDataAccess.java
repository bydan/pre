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
import com.bydan.erp.comisiones.util.*;//ComisionPenaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class ComisionPenaDataAccess extends  ComisionPenaDataAccessAdditional{ //ComisionPenaDataAccessAdditional,DataAccessHelper<ComisionPena>
	//static Logger logger = Logger.getLogger(ComisionPenaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="comision_pena";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ComisionPenaConstantesFunciones.SCHEMA+"."+ComisionPenaConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_comision_config,num_dias_inicio,num_dias_fin,porcentaje,descripcion)values(current_timestamp,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+ComisionPenaConstantesFunciones.SCHEMA+"."+ComisionPenaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_comision_config=?,num_dias_inicio=?,num_dias_fin=?,porcentaje=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ComisionPenaConstantesFunciones.SCHEMA+"."+ComisionPenaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select comisionpena from "+ComisionPenaConstantesFunciones.SPERSISTENCENAME+" comisionpena";
	public static String QUERYSELECTNATIVE="select "+ComisionPenaConstantesFunciones.SCHEMA+"."+ComisionPenaConstantesFunciones.TABLENAME+".id,"+ComisionPenaConstantesFunciones.SCHEMA+"."+ComisionPenaConstantesFunciones.TABLENAME+".version_row,"+ComisionPenaConstantesFunciones.SCHEMA+"."+ComisionPenaConstantesFunciones.TABLENAME+".id_empresa,"+ComisionPenaConstantesFunciones.SCHEMA+"."+ComisionPenaConstantesFunciones.TABLENAME+".id_comision_config,"+ComisionPenaConstantesFunciones.SCHEMA+"."+ComisionPenaConstantesFunciones.TABLENAME+".num_dias_inicio,"+ComisionPenaConstantesFunciones.SCHEMA+"."+ComisionPenaConstantesFunciones.TABLENAME+".num_dias_fin,"+ComisionPenaConstantesFunciones.SCHEMA+"."+ComisionPenaConstantesFunciones.TABLENAME+".porcentaje,"+ComisionPenaConstantesFunciones.SCHEMA+"."+ComisionPenaConstantesFunciones.TABLENAME+".descripcion from "+ComisionPenaConstantesFunciones.SCHEMA+"."+ComisionPenaConstantesFunciones.TABLENAME;//+" as "+ComisionPenaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ComisionPenaConstantesFunciones.SCHEMA+"."+ComisionPenaConstantesFunciones.TABLENAME+".id,"+ComisionPenaConstantesFunciones.SCHEMA+"."+ComisionPenaConstantesFunciones.TABLENAME+".version_row from "+ComisionPenaConstantesFunciones.SCHEMA+"."+ComisionPenaConstantesFunciones.TABLENAME;//+" as "+ComisionPenaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ComisionPenaConstantesFunciones.SCHEMA+"."+ComisionPenaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_comision_config=?,num_dias_inicio=?,num_dias_fin=?,porcentaje=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_COMISIONPENA_INSERT(?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_COMISIONPENA_UPDATE(?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_COMISIONPENA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_COMISIONPENA_SELECT(?,?)";
	
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
	
	
	protected ComisionPenaDataAccessAdditional comisionpenaDataAccessAdditional=null;
	
	public ComisionPenaDataAccessAdditional getComisionPenaDataAccessAdditional() {
		return this.comisionpenaDataAccessAdditional;
	}
	
	public void setComisionPenaDataAccessAdditional(ComisionPenaDataAccessAdditional comisionpenaDataAccessAdditional) {
		try {
			this.comisionpenaDataAccessAdditional=comisionpenaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ComisionPenaDataAccess() {
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
		ComisionPenaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ComisionPenaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ComisionPenaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setComisionPenaOriginal(ComisionPena comisionpena)throws Exception  {
		comisionpena.setComisionPenaOriginal((ComisionPena)comisionpena.clone());		
	}
	
	public void setComisionPenasOriginal(List<ComisionPena> comisionpenas)throws Exception  {
		
		for(ComisionPena comisionpena:comisionpenas){
			comisionpena.setComisionPenaOriginal((ComisionPena)comisionpena.clone());
		}
	}
	
	public static void setComisionPenaOriginalStatic(ComisionPena comisionpena)throws Exception  {
		comisionpena.setComisionPenaOriginal((ComisionPena)comisionpena.clone());		
	}
	
	public static void setComisionPenasOriginalStatic(List<ComisionPena> comisionpenas)throws Exception  {
		
		for(ComisionPena comisionpena:comisionpenas){
			comisionpena.setComisionPenaOriginal((ComisionPena)comisionpena.clone());
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
	
	public  ComisionPena getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		ComisionPena entity = new ComisionPena();		
		
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
	
	public  ComisionPena getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		ComisionPena entity = new ComisionPena();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ComisionPenaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ComisionPenaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Comisiones.ComisionPena.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setComisionPenaOriginal(new ComisionPena());
      	    	entity=super.getEntity("",entity,resultSet,ComisionPenaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityComisionPena("",entity,resultSet); 
				
				//entity.setComisionPenaOriginal(super.getEntity("",entity.getComisionPenaOriginal(),resultSet,ComisionPenaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setComisionPenaOriginal(this.getEntityComisionPena("",entity.getComisionPenaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseComisionPena(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  ComisionPena getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ComisionPena entity = new ComisionPena();
				
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
	
	public  ComisionPena getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ComisionPena entity = new ComisionPena();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ComisionPenaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ComisionPenaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ComisionPenaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Comisiones.ComisionPena.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setComisionPenaOriginal(new ComisionPena());
      	    	entity=super.getEntity("",entity,resultSet,ComisionPenaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityComisionPena("",entity,resultSet);    
				
				//entity.setComisionPenaOriginal(super.getEntity("",entity.getComisionPenaOriginal(),resultSet,ComisionPenaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setComisionPenaOriginal(this.getEntityComisionPena("",entity.getComisionPenaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseComisionPena(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //ComisionPena
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		ComisionPena entity = new ComisionPena();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ComisionPenaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ComisionPenaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ComisionPenaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Comisiones.ComisionPena.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseComisionPena(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<ComisionPena> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ComisionPena> entities = new  ArrayList<ComisionPena>();
		ComisionPena entity = new ComisionPena();		  
		
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
	
	public  List<ComisionPena> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ComisionPena> entities = new  ArrayList<ComisionPena>();
		ComisionPena entity = new ComisionPena();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ComisionPenaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ComisionPenaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ComisionPenaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ComisionPena();
      	    	entity=super.getEntity("",entity,resultSet,ComisionPenaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityComisionPena("",entity,resultSet);
      	    	
				//entity.setComisionPenaOriginal( new ComisionPena());
      	    	//entity.setComisionPenaOriginal(super.getEntity("",entity.getComisionPenaOriginal(),resultSet,ComisionPenaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setComisionPenaOriginal(this.getEntityComisionPena("",entity.getComisionPenaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseComisionPenas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarComisionPena(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ComisionPena> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ComisionPena> entities = new  ArrayList<ComisionPena>();
		ComisionPena entity = new ComisionPena();		  
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
	
	public  List<ComisionPena> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ComisionPena> entities = new  ArrayList<ComisionPena>();
		ComisionPena entity = new ComisionPena();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ComisionPena();
				
				if(conMapGenerico) {
					entity.inicializarMapComisionPena();
					//entity.setMapComisionPena(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapComisionPenaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapComisionPena().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ComisionPenaDataAccess.ISWITHSCHEMA);         		
					entity=ComisionPenaDataAccess.getEntityComisionPena("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setComisionPenaOriginal( new ComisionPena());
					////entity.setComisionPenaOriginal(super.getEntity("",entity.getComisionPenaOriginal(),resultSet,ComisionPenaDataAccess.ISWITHSCHEMA));         		
					////entity.setComisionPenaOriginal(this.getEntityComisionPena("",entity.getComisionPenaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseComisionPenas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarComisionPena(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public ComisionPena getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ComisionPena entity = new ComisionPena();		  
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
	
	public  ComisionPena getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ComisionPena entity = new ComisionPena();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ComisionPena();
				
				if(conMapGenerico) {
					entity.inicializarMapComisionPena();
					//entity.setMapComisionPena(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapComisionPenaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapComisionPena().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ComisionPenaDataAccess.ISWITHSCHEMA);         		
					entity=ComisionPenaDataAccess.getEntityComisionPena("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setComisionPenaOriginal( new ComisionPena());
					////entity.setComisionPenaOriginal(super.getEntity("",entity.getComisionPenaOriginal(),resultSet,ComisionPenaDataAccess.ISWITHSCHEMA));         		
					////entity.setComisionPenaOriginal(this.getEntityComisionPena("",entity.getComisionPenaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseComisionPena(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarComisionPena(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ComisionPena getEntityComisionPena(String strPrefijo,ComisionPena entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = ComisionPena.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = ComisionPena.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ComisionPenaDataAccess.setFieldReflectionComisionPena(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasComisionPena=ComisionPenaConstantesFunciones.getTodosTiposColumnasComisionPena();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasComisionPena) {
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
							field = ComisionPena.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = ComisionPena.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ComisionPenaDataAccess.setFieldReflectionComisionPena(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionComisionPena(Field field,String strPrefijo,String sColumn,ComisionPena entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ComisionPenaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ComisionPenaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ComisionPenaConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ComisionPenaConstantesFunciones.IDCOMISIONCONFIG:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ComisionPenaConstantesFunciones.NUMDIASINICIO:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case ComisionPenaConstantesFunciones.NUMDIASFIN:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case ComisionPenaConstantesFunciones.PORCENTAJE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ComisionPenaConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ComisionPena>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<ComisionPena> entities = new  ArrayList<ComisionPena>();
		ComisionPena entity = new ComisionPena();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ComisionPenaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ComisionPenaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ComisionPenaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new ComisionPena();
					entity=super.getEntity("",entity,resultSet,ComisionPenaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityComisionPena("",entity,resultSet);
					
					//entity.setComisionPenaOriginal( new ComisionPena());
					//entity.setComisionPenaOriginal(super.getEntity("",entity.getComisionPenaOriginal(),resultSet,ComisionPenaDataAccess.ISWITHSCHEMA));         		
					//entity.setComisionPenaOriginal(this.getEntityComisionPena("",entity.getComisionPenaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseComisionPenas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarComisionPena(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ComisionPena>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<ComisionPena> entities = new  ArrayList<ComisionPena>();
		ComisionPena entity = new ComisionPena();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ComisionPenaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ComisionPenaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ComisionPenaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<ComisionPena> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ComisionPena> entities = new  ArrayList<ComisionPena>();
		ComisionPena entity = new ComisionPena();		  
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
	
	public  List<ComisionPena> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ComisionPena> entities = new  ArrayList<ComisionPena>();
		ComisionPena entity = new ComisionPena();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ComisionPena();
      	    	entity=super.getEntity("",entity,resultSet,ComisionPenaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityComisionPena("",entity,resultSet);
      	    	
				//entity.setComisionPenaOriginal( new ComisionPena());
      	    	//entity.setComisionPenaOriginal(super.getEntity("",entity.getComisionPenaOriginal(),resultSet,ComisionPenaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setComisionPenaOriginal(this.getEntityComisionPena("",entity.getComisionPenaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseComisionPenas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarComisionPena(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ComisionPena> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ComisionPena> entities = new  ArrayList<ComisionPena>();
		ComisionPena entity = new ComisionPena();		  
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
	
	public  List<ComisionPena> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ComisionPena> entities = new  ArrayList<ComisionPena>();
		ComisionPena entity = new ComisionPena();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ComisionPena();
      	    	entity=super.getEntity("",entity,resultSet,ComisionPenaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityComisionPena("",entity,resultSet);
      	    	
				//entity.setComisionPenaOriginal( new ComisionPena());
      	    	//entity.setComisionPenaOriginal(super.getEntity("",entity.getComisionPenaOriginal(),resultSet,ComisionPenaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setComisionPenaOriginal(this.getEntityComisionPena("",entity.getComisionPenaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseComisionPenas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public ComisionPena getEntityComisionPena(String strPrefijo,ComisionPena entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+ComisionPenaConstantesFunciones.IDEMPRESA));
				entity.setid_comision_config(resultSet.getLong(strPrefijo+ComisionPenaConstantesFunciones.IDCOMISIONCONFIG));
				entity.setnum_dias_inicio(resultSet.getInt(strPrefijo+ComisionPenaConstantesFunciones.NUMDIASINICIO));
				entity.setnum_dias_fin(resultSet.getInt(strPrefijo+ComisionPenaConstantesFunciones.NUMDIASFIN));
				entity.setporcentaje(resultSet.getDouble(strPrefijo+ComisionPenaConstantesFunciones.PORCENTAJE));
				entity.setdescripcion(resultSet.getString(strPrefijo+ComisionPenaConstantesFunciones.DESCRIPCION));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowComisionPena(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(ComisionPena entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ComisionPenaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ComisionPenaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ComisionPenaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ComisionPenaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ComisionPenaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ComisionPenaDataAccess.TABLENAME,ComisionPenaDataAccess.ISWITHSTOREPROCEDURES);
			
			ComisionPenaDataAccess.setComisionPenaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,ComisionPena relcomisionpena)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relcomisionpena.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public ComisionConfig getComisionConfig(Connexion connexion,ComisionPena relcomisionpena)throws SQLException,Exception {

		ComisionConfig comisionconfig= new ComisionConfig();

		try {
			ComisionConfigDataAccess comisionconfigDataAccess=new ComisionConfigDataAccess();

			comisionconfigDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			comisionconfigDataAccess.setConnexionType(this.connexionType);
			comisionconfigDataAccess.setParameterDbType(this.parameterDbType);

			comisionconfig=comisionconfigDataAccess.getEntity(connexion,relcomisionpena.getid_comision_config());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return comisionconfig;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,ComisionPena comisionpena) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!comisionpena.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(comisionpena.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_comision_config=new ParameterValue<Long>();
					parameterMaintenanceValueid_comision_config.setValue(comisionpena.getid_comision_config());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_comision_config);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuenum_dias_inicio=new ParameterValue<Integer>();
					parameterMaintenanceValuenum_dias_inicio.setValue(comisionpena.getnum_dias_inicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenum_dias_inicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuenum_dias_fin=new ParameterValue<Integer>();
					parameterMaintenanceValuenum_dias_fin.setValue(comisionpena.getnum_dias_fin());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenum_dias_fin);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcentaje=new ParameterValue<Double>();
					parameterMaintenanceValueporcentaje.setValue(comisionpena.getporcentaje());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcentaje);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(comisionpena.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!comisionpena.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(comisionpena.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(comisionpena.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(comisionpena.getId());
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
	
	public void setIsNewIsChangedFalseComisionPena(ComisionPena comisionpena)throws Exception  {		
		comisionpena.setIsNew(false);
		comisionpena.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseComisionPenas(List<ComisionPena> comisionpenas)throws Exception  {				
		for(ComisionPena comisionpena:comisionpenas) {
			comisionpena.setIsNew(false);
			comisionpena.setIsChanged(false);
		}
	}
	
	public void generarExportarComisionPena(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
