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
package com.bydan.erp.activosfijos.business.dataaccess;

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

import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.activosfijos.util.*;//IndiceCorreccionActivoFijoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class IndiceCorreccionActivoFijoDataAccess extends  IndiceCorreccionActivoFijoDataAccessAdditional{ //IndiceCorreccionActivoFijoDataAccessAdditional,DataAccessHelper<IndiceCorreccionActivoFijo>
	//static Logger logger = Logger.getLogger(IndiceCorreccionActivoFijoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="indice_correccion_activo_fijo";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+IndiceCorreccionActivoFijoConstantesFunciones.SCHEMA+"."+IndiceCorreccionActivoFijoConstantesFunciones.TABLENAME+"(version_row,id_empresa,anio,valor)values(current_timestamp,?,?,?)";
	public static String QUERYUPDATE="update "+IndiceCorreccionActivoFijoConstantesFunciones.SCHEMA+"."+IndiceCorreccionActivoFijoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,anio=?,valor=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+IndiceCorreccionActivoFijoConstantesFunciones.SCHEMA+"."+IndiceCorreccionActivoFijoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select indicecorreccionactivofijo from "+IndiceCorreccionActivoFijoConstantesFunciones.SPERSISTENCENAME+" indicecorreccionactivofijo";
	public static String QUERYSELECTNATIVE="select "+IndiceCorreccionActivoFijoConstantesFunciones.SCHEMA+"."+IndiceCorreccionActivoFijoConstantesFunciones.TABLENAME+".id,"+IndiceCorreccionActivoFijoConstantesFunciones.SCHEMA+"."+IndiceCorreccionActivoFijoConstantesFunciones.TABLENAME+".version_row,"+IndiceCorreccionActivoFijoConstantesFunciones.SCHEMA+"."+IndiceCorreccionActivoFijoConstantesFunciones.TABLENAME+".id_empresa,"+IndiceCorreccionActivoFijoConstantesFunciones.SCHEMA+"."+IndiceCorreccionActivoFijoConstantesFunciones.TABLENAME+".anio,"+IndiceCorreccionActivoFijoConstantesFunciones.SCHEMA+"."+IndiceCorreccionActivoFijoConstantesFunciones.TABLENAME+".valor from "+IndiceCorreccionActivoFijoConstantesFunciones.SCHEMA+"."+IndiceCorreccionActivoFijoConstantesFunciones.TABLENAME;//+" as "+IndiceCorreccionActivoFijoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+IndiceCorreccionActivoFijoConstantesFunciones.SCHEMA+"."+IndiceCorreccionActivoFijoConstantesFunciones.TABLENAME+".id,"+IndiceCorreccionActivoFijoConstantesFunciones.SCHEMA+"."+IndiceCorreccionActivoFijoConstantesFunciones.TABLENAME+".version_row from "+IndiceCorreccionActivoFijoConstantesFunciones.SCHEMA+"."+IndiceCorreccionActivoFijoConstantesFunciones.TABLENAME;//+" as "+IndiceCorreccionActivoFijoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+IndiceCorreccionActivoFijoConstantesFunciones.SCHEMA+"."+IndiceCorreccionActivoFijoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,anio=?,valor=?";
	
	public static String STOREPROCEDUREINSERT="call SP_INDICECORRECCIONACTIVOFIJO_INSERT(?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_INDICECORRECCIONACTIVOFIJO_UPDATE(?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_INDICECORRECCIONACTIVOFIJO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_INDICECORRECCIONACTIVOFIJO_SELECT(?,?)";
	
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
	
	
	protected IndiceCorreccionActivoFijoDataAccessAdditional indicecorreccionactivofijoDataAccessAdditional=null;
	
	public IndiceCorreccionActivoFijoDataAccessAdditional getIndiceCorreccionActivoFijoDataAccessAdditional() {
		return this.indicecorreccionactivofijoDataAccessAdditional;
	}
	
	public void setIndiceCorreccionActivoFijoDataAccessAdditional(IndiceCorreccionActivoFijoDataAccessAdditional indicecorreccionactivofijoDataAccessAdditional) {
		try {
			this.indicecorreccionactivofijoDataAccessAdditional=indicecorreccionactivofijoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public IndiceCorreccionActivoFijoDataAccess() {
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
		IndiceCorreccionActivoFijoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		IndiceCorreccionActivoFijoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		IndiceCorreccionActivoFijoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setIndiceCorreccionActivoFijoOriginal(IndiceCorreccionActivoFijo indicecorreccionactivofijo)throws Exception  {
		indicecorreccionactivofijo.setIndiceCorreccionActivoFijoOriginal((IndiceCorreccionActivoFijo)indicecorreccionactivofijo.clone());		
	}
	
	public void setIndiceCorreccionActivoFijosOriginal(List<IndiceCorreccionActivoFijo> indicecorreccionactivofijos)throws Exception  {
		
		for(IndiceCorreccionActivoFijo indicecorreccionactivofijo:indicecorreccionactivofijos){
			indicecorreccionactivofijo.setIndiceCorreccionActivoFijoOriginal((IndiceCorreccionActivoFijo)indicecorreccionactivofijo.clone());
		}
	}
	
	public static void setIndiceCorreccionActivoFijoOriginalStatic(IndiceCorreccionActivoFijo indicecorreccionactivofijo)throws Exception  {
		indicecorreccionactivofijo.setIndiceCorreccionActivoFijoOriginal((IndiceCorreccionActivoFijo)indicecorreccionactivofijo.clone());		
	}
	
	public static void setIndiceCorreccionActivoFijosOriginalStatic(List<IndiceCorreccionActivoFijo> indicecorreccionactivofijos)throws Exception  {
		
		for(IndiceCorreccionActivoFijo indicecorreccionactivofijo:indicecorreccionactivofijos){
			indicecorreccionactivofijo.setIndiceCorreccionActivoFijoOriginal((IndiceCorreccionActivoFijo)indicecorreccionactivofijo.clone());
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
	
	public  IndiceCorreccionActivoFijo getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		IndiceCorreccionActivoFijo entity = new IndiceCorreccionActivoFijo();		
		
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
	
	public  IndiceCorreccionActivoFijo getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		IndiceCorreccionActivoFijo entity = new IndiceCorreccionActivoFijo();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=IndiceCorreccionActivoFijoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=IndiceCorreccionActivoFijoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//ActivosFijos.IndiceCorreccionActivoFijo.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setIndiceCorreccionActivoFijoOriginal(new IndiceCorreccionActivoFijo());
      	    	entity=super.getEntity("",entity,resultSet,IndiceCorreccionActivoFijoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityIndiceCorreccionActivoFijo("",entity,resultSet); 
				
				//entity.setIndiceCorreccionActivoFijoOriginal(super.getEntity("",entity.getIndiceCorreccionActivoFijoOriginal(),resultSet,IndiceCorreccionActivoFijoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setIndiceCorreccionActivoFijoOriginal(this.getEntityIndiceCorreccionActivoFijo("",entity.getIndiceCorreccionActivoFijoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseIndiceCorreccionActivoFijo(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  IndiceCorreccionActivoFijo getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		IndiceCorreccionActivoFijo entity = new IndiceCorreccionActivoFijo();
				
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
	
	public  IndiceCorreccionActivoFijo getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		IndiceCorreccionActivoFijo entity = new IndiceCorreccionActivoFijo();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=IndiceCorreccionActivoFijoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=IndiceCorreccionActivoFijoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,IndiceCorreccionActivoFijoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//ActivosFijos.IndiceCorreccionActivoFijo.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setIndiceCorreccionActivoFijoOriginal(new IndiceCorreccionActivoFijo());
      	    	entity=super.getEntity("",entity,resultSet,IndiceCorreccionActivoFijoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityIndiceCorreccionActivoFijo("",entity,resultSet);    
				
				//entity.setIndiceCorreccionActivoFijoOriginal(super.getEntity("",entity.getIndiceCorreccionActivoFijoOriginal(),resultSet,IndiceCorreccionActivoFijoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setIndiceCorreccionActivoFijoOriginal(this.getEntityIndiceCorreccionActivoFijo("",entity.getIndiceCorreccionActivoFijoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseIndiceCorreccionActivoFijo(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //IndiceCorreccionActivoFijo
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		IndiceCorreccionActivoFijo entity = new IndiceCorreccionActivoFijo();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=IndiceCorreccionActivoFijoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=IndiceCorreccionActivoFijoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,IndiceCorreccionActivoFijoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//ActivosFijos.IndiceCorreccionActivoFijo.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseIndiceCorreccionActivoFijo(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<IndiceCorreccionActivoFijo> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<IndiceCorreccionActivoFijo> entities = new  ArrayList<IndiceCorreccionActivoFijo>();
		IndiceCorreccionActivoFijo entity = new IndiceCorreccionActivoFijo();		  
		
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
	
	public  List<IndiceCorreccionActivoFijo> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<IndiceCorreccionActivoFijo> entities = new  ArrayList<IndiceCorreccionActivoFijo>();
		IndiceCorreccionActivoFijo entity = new IndiceCorreccionActivoFijo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=IndiceCorreccionActivoFijoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=IndiceCorreccionActivoFijoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,IndiceCorreccionActivoFijoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new IndiceCorreccionActivoFijo();
      	    	entity=super.getEntity("",entity,resultSet,IndiceCorreccionActivoFijoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityIndiceCorreccionActivoFijo("",entity,resultSet);
      	    	
				//entity.setIndiceCorreccionActivoFijoOriginal( new IndiceCorreccionActivoFijo());
      	    	//entity.setIndiceCorreccionActivoFijoOriginal(super.getEntity("",entity.getIndiceCorreccionActivoFijoOriginal(),resultSet,IndiceCorreccionActivoFijoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setIndiceCorreccionActivoFijoOriginal(this.getEntityIndiceCorreccionActivoFijo("",entity.getIndiceCorreccionActivoFijoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseIndiceCorreccionActivoFijos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarIndiceCorreccionActivoFijo(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<IndiceCorreccionActivoFijo> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<IndiceCorreccionActivoFijo> entities = new  ArrayList<IndiceCorreccionActivoFijo>();
		IndiceCorreccionActivoFijo entity = new IndiceCorreccionActivoFijo();		  
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
	
	public  List<IndiceCorreccionActivoFijo> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<IndiceCorreccionActivoFijo> entities = new  ArrayList<IndiceCorreccionActivoFijo>();
		IndiceCorreccionActivoFijo entity = new IndiceCorreccionActivoFijo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new IndiceCorreccionActivoFijo();
				
				if(conMapGenerico) {
					entity.inicializarMapIndiceCorreccionActivoFijo();
					//entity.setMapIndiceCorreccionActivoFijo(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapIndiceCorreccionActivoFijoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapIndiceCorreccionActivoFijo().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,IndiceCorreccionActivoFijoDataAccess.ISWITHSCHEMA);         		
					entity=IndiceCorreccionActivoFijoDataAccess.getEntityIndiceCorreccionActivoFijo("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setIndiceCorreccionActivoFijoOriginal( new IndiceCorreccionActivoFijo());
					////entity.setIndiceCorreccionActivoFijoOriginal(super.getEntity("",entity.getIndiceCorreccionActivoFijoOriginal(),resultSet,IndiceCorreccionActivoFijoDataAccess.ISWITHSCHEMA));         		
					////entity.setIndiceCorreccionActivoFijoOriginal(this.getEntityIndiceCorreccionActivoFijo("",entity.getIndiceCorreccionActivoFijoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseIndiceCorreccionActivoFijos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarIndiceCorreccionActivoFijo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public IndiceCorreccionActivoFijo getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		IndiceCorreccionActivoFijo entity = new IndiceCorreccionActivoFijo();		  
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
	
	public  IndiceCorreccionActivoFijo getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		IndiceCorreccionActivoFijo entity = new IndiceCorreccionActivoFijo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new IndiceCorreccionActivoFijo();
				
				if(conMapGenerico) {
					entity.inicializarMapIndiceCorreccionActivoFijo();
					//entity.setMapIndiceCorreccionActivoFijo(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapIndiceCorreccionActivoFijoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapIndiceCorreccionActivoFijo().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,IndiceCorreccionActivoFijoDataAccess.ISWITHSCHEMA);         		
					entity=IndiceCorreccionActivoFijoDataAccess.getEntityIndiceCorreccionActivoFijo("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setIndiceCorreccionActivoFijoOriginal( new IndiceCorreccionActivoFijo());
					////entity.setIndiceCorreccionActivoFijoOriginal(super.getEntity("",entity.getIndiceCorreccionActivoFijoOriginal(),resultSet,IndiceCorreccionActivoFijoDataAccess.ISWITHSCHEMA));         		
					////entity.setIndiceCorreccionActivoFijoOriginal(this.getEntityIndiceCorreccionActivoFijo("",entity.getIndiceCorreccionActivoFijoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseIndiceCorreccionActivoFijo(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarIndiceCorreccionActivoFijo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static IndiceCorreccionActivoFijo getEntityIndiceCorreccionActivoFijo(String strPrefijo,IndiceCorreccionActivoFijo entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = IndiceCorreccionActivoFijo.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = IndiceCorreccionActivoFijo.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					IndiceCorreccionActivoFijoDataAccess.setFieldReflectionIndiceCorreccionActivoFijo(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasIndiceCorreccionActivoFijo=IndiceCorreccionActivoFijoConstantesFunciones.getTodosTiposColumnasIndiceCorreccionActivoFijo();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasIndiceCorreccionActivoFijo) {
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
							field = IndiceCorreccionActivoFijo.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = IndiceCorreccionActivoFijo.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						IndiceCorreccionActivoFijoDataAccess.setFieldReflectionIndiceCorreccionActivoFijo(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionIndiceCorreccionActivoFijo(Field field,String strPrefijo,String sColumn,IndiceCorreccionActivoFijo entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case IndiceCorreccionActivoFijoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case IndiceCorreccionActivoFijoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case IndiceCorreccionActivoFijoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case IndiceCorreccionActivoFijoConstantesFunciones.ANIO:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case IndiceCorreccionActivoFijoConstantesFunciones.VALOR:
					field.set(entity,resultSet.getDouble(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<IndiceCorreccionActivoFijo>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<IndiceCorreccionActivoFijo> entities = new  ArrayList<IndiceCorreccionActivoFijo>();
		IndiceCorreccionActivoFijo entity = new IndiceCorreccionActivoFijo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=IndiceCorreccionActivoFijoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=IndiceCorreccionActivoFijoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,IndiceCorreccionActivoFijoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new IndiceCorreccionActivoFijo();
					entity=super.getEntity("",entity,resultSet,IndiceCorreccionActivoFijoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityIndiceCorreccionActivoFijo("",entity,resultSet);
					
					//entity.setIndiceCorreccionActivoFijoOriginal( new IndiceCorreccionActivoFijo());
					//entity.setIndiceCorreccionActivoFijoOriginal(super.getEntity("",entity.getIndiceCorreccionActivoFijoOriginal(),resultSet,IndiceCorreccionActivoFijoDataAccess.ISWITHSCHEMA));         		
					//entity.setIndiceCorreccionActivoFijoOriginal(this.getEntityIndiceCorreccionActivoFijo("",entity.getIndiceCorreccionActivoFijoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseIndiceCorreccionActivoFijos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarIndiceCorreccionActivoFijo(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<IndiceCorreccionActivoFijo>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<IndiceCorreccionActivoFijo> entities = new  ArrayList<IndiceCorreccionActivoFijo>();
		IndiceCorreccionActivoFijo entity = new IndiceCorreccionActivoFijo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=IndiceCorreccionActivoFijoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=IndiceCorreccionActivoFijoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,IndiceCorreccionActivoFijoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<IndiceCorreccionActivoFijo> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<IndiceCorreccionActivoFijo> entities = new  ArrayList<IndiceCorreccionActivoFijo>();
		IndiceCorreccionActivoFijo entity = new IndiceCorreccionActivoFijo();		  
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
	
	public  List<IndiceCorreccionActivoFijo> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<IndiceCorreccionActivoFijo> entities = new  ArrayList<IndiceCorreccionActivoFijo>();
		IndiceCorreccionActivoFijo entity = new IndiceCorreccionActivoFijo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new IndiceCorreccionActivoFijo();
      	    	entity=super.getEntity("",entity,resultSet,IndiceCorreccionActivoFijoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityIndiceCorreccionActivoFijo("",entity,resultSet);
      	    	
				//entity.setIndiceCorreccionActivoFijoOriginal( new IndiceCorreccionActivoFijo());
      	    	//entity.setIndiceCorreccionActivoFijoOriginal(super.getEntity("",entity.getIndiceCorreccionActivoFijoOriginal(),resultSet,IndiceCorreccionActivoFijoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setIndiceCorreccionActivoFijoOriginal(this.getEntityIndiceCorreccionActivoFijo("",entity.getIndiceCorreccionActivoFijoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseIndiceCorreccionActivoFijos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarIndiceCorreccionActivoFijo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<IndiceCorreccionActivoFijo> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<IndiceCorreccionActivoFijo> entities = new  ArrayList<IndiceCorreccionActivoFijo>();
		IndiceCorreccionActivoFijo entity = new IndiceCorreccionActivoFijo();		  
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
	
	public  List<IndiceCorreccionActivoFijo> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<IndiceCorreccionActivoFijo> entities = new  ArrayList<IndiceCorreccionActivoFijo>();
		IndiceCorreccionActivoFijo entity = new IndiceCorreccionActivoFijo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new IndiceCorreccionActivoFijo();
      	    	entity=super.getEntity("",entity,resultSet,IndiceCorreccionActivoFijoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityIndiceCorreccionActivoFijo("",entity,resultSet);
      	    	
				//entity.setIndiceCorreccionActivoFijoOriginal( new IndiceCorreccionActivoFijo());
      	    	//entity.setIndiceCorreccionActivoFijoOriginal(super.getEntity("",entity.getIndiceCorreccionActivoFijoOriginal(),resultSet,IndiceCorreccionActivoFijoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setIndiceCorreccionActivoFijoOriginal(this.getEntityIndiceCorreccionActivoFijo("",entity.getIndiceCorreccionActivoFijoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseIndiceCorreccionActivoFijos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public IndiceCorreccionActivoFijo getEntityIndiceCorreccionActivoFijo(String strPrefijo,IndiceCorreccionActivoFijo entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+IndiceCorreccionActivoFijoConstantesFunciones.IDEMPRESA));
				entity.setanio(resultSet.getInt(strPrefijo+IndiceCorreccionActivoFijoConstantesFunciones.ANIO));
				entity.setvalor(resultSet.getDouble(strPrefijo+IndiceCorreccionActivoFijoConstantesFunciones.VALOR));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowIndiceCorreccionActivoFijo(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(IndiceCorreccionActivoFijo entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=IndiceCorreccionActivoFijoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=IndiceCorreccionActivoFijoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=IndiceCorreccionActivoFijoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=IndiceCorreccionActivoFijoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(IndiceCorreccionActivoFijoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,IndiceCorreccionActivoFijoDataAccess.TABLENAME,IndiceCorreccionActivoFijoDataAccess.ISWITHSTOREPROCEDURES);
			
			IndiceCorreccionActivoFijoDataAccess.setIndiceCorreccionActivoFijoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,IndiceCorreccionActivoFijo relindicecorreccionactivofijo)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relindicecorreccionactivofijo.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,IndiceCorreccionActivoFijo indicecorreccionactivofijo) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!indicecorreccionactivofijo.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(indicecorreccionactivofijo.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValueanio=new ParameterValue<Integer>();
					parameterMaintenanceValueanio.setValue(indicecorreccionactivofijo.getanio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueanio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor=new ParameterValue<Double>();
					parameterMaintenanceValuevalor.setValue(indicecorreccionactivofijo.getvalor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor);
					parametersTemp.add(parameterMaintenance);
					
						if(!indicecorreccionactivofijo.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(indicecorreccionactivofijo.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(indicecorreccionactivofijo.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(indicecorreccionactivofijo.getId());
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
	
	public void setIsNewIsChangedFalseIndiceCorreccionActivoFijo(IndiceCorreccionActivoFijo indicecorreccionactivofijo)throws Exception  {		
		indicecorreccionactivofijo.setIsNew(false);
		indicecorreccionactivofijo.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseIndiceCorreccionActivoFijos(List<IndiceCorreccionActivoFijo> indicecorreccionactivofijos)throws Exception  {				
		for(IndiceCorreccionActivoFijo indicecorreccionactivofijo:indicecorreccionactivofijos) {
			indicecorreccionactivofijo.setIsNew(false);
			indicecorreccionactivofijo.setIsChanged(false);
		}
	}
	
	public void generarExportarIndiceCorreccionActivoFijo(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
