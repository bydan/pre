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
import com.bydan.erp.activosfijos.util.*;//ResponsableActivoFijoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;




@SuppressWarnings("unused")
final public class ResponsableActivoFijoDataAccess extends  ResponsableActivoFijoDataAccessAdditional{ //ResponsableActivoFijoDataAccessAdditional,DataAccessHelper<ResponsableActivoFijo>
	//static Logger logger = Logger.getLogger(ResponsableActivoFijoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="responsable_activo_fijo";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ResponsableActivoFijoConstantesFunciones.SCHEMA+"."+ResponsableActivoFijoConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_detalle_activo_fijo,id_estructura,id_empleado,ubicacion,fecha,descripcion)values(current_timestamp,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+ResponsableActivoFijoConstantesFunciones.SCHEMA+"."+ResponsableActivoFijoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_detalle_activo_fijo=?,id_estructura=?,id_empleado=?,ubicacion=?,fecha=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ResponsableActivoFijoConstantesFunciones.SCHEMA+"."+ResponsableActivoFijoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select responsableactivofijo from "+ResponsableActivoFijoConstantesFunciones.SPERSISTENCENAME+" responsableactivofijo";
	public static String QUERYSELECTNATIVE="select "+ResponsableActivoFijoConstantesFunciones.SCHEMA+"."+ResponsableActivoFijoConstantesFunciones.TABLENAME+".id,"+ResponsableActivoFijoConstantesFunciones.SCHEMA+"."+ResponsableActivoFijoConstantesFunciones.TABLENAME+".version_row,"+ResponsableActivoFijoConstantesFunciones.SCHEMA+"."+ResponsableActivoFijoConstantesFunciones.TABLENAME+".id_empresa,"+ResponsableActivoFijoConstantesFunciones.SCHEMA+"."+ResponsableActivoFijoConstantesFunciones.TABLENAME+".id_sucursal,"+ResponsableActivoFijoConstantesFunciones.SCHEMA+"."+ResponsableActivoFijoConstantesFunciones.TABLENAME+".id_detalle_activo_fijo,"+ResponsableActivoFijoConstantesFunciones.SCHEMA+"."+ResponsableActivoFijoConstantesFunciones.TABLENAME+".id_estructura,"+ResponsableActivoFijoConstantesFunciones.SCHEMA+"."+ResponsableActivoFijoConstantesFunciones.TABLENAME+".id_empleado,"+ResponsableActivoFijoConstantesFunciones.SCHEMA+"."+ResponsableActivoFijoConstantesFunciones.TABLENAME+".ubicacion,"+ResponsableActivoFijoConstantesFunciones.SCHEMA+"."+ResponsableActivoFijoConstantesFunciones.TABLENAME+".fecha,"+ResponsableActivoFijoConstantesFunciones.SCHEMA+"."+ResponsableActivoFijoConstantesFunciones.TABLENAME+".descripcion from "+ResponsableActivoFijoConstantesFunciones.SCHEMA+"."+ResponsableActivoFijoConstantesFunciones.TABLENAME;//+" as "+ResponsableActivoFijoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ResponsableActivoFijoConstantesFunciones.SCHEMA+"."+ResponsableActivoFijoConstantesFunciones.TABLENAME+".id,"+ResponsableActivoFijoConstantesFunciones.SCHEMA+"."+ResponsableActivoFijoConstantesFunciones.TABLENAME+".version_row from "+ResponsableActivoFijoConstantesFunciones.SCHEMA+"."+ResponsableActivoFijoConstantesFunciones.TABLENAME;//+" as "+ResponsableActivoFijoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ResponsableActivoFijoConstantesFunciones.SCHEMA+"."+ResponsableActivoFijoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_detalle_activo_fijo=?,id_estructura=?,id_empleado=?,ubicacion=?,fecha=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_RESPONSABLEACTIVOFIJO_INSERT(?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_RESPONSABLEACTIVOFIJO_UPDATE(?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_RESPONSABLEACTIVOFIJO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_RESPONSABLEACTIVOFIJO_SELECT(?,?)";
	
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
	
	
	protected ResponsableActivoFijoDataAccessAdditional responsableactivofijoDataAccessAdditional=null;
	
	public ResponsableActivoFijoDataAccessAdditional getResponsableActivoFijoDataAccessAdditional() {
		return this.responsableactivofijoDataAccessAdditional;
	}
	
	public void setResponsableActivoFijoDataAccessAdditional(ResponsableActivoFijoDataAccessAdditional responsableactivofijoDataAccessAdditional) {
		try {
			this.responsableactivofijoDataAccessAdditional=responsableactivofijoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ResponsableActivoFijoDataAccess() {
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
		ResponsableActivoFijoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ResponsableActivoFijoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ResponsableActivoFijoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setResponsableActivoFijoOriginal(ResponsableActivoFijo responsableactivofijo)throws Exception  {
		responsableactivofijo.setResponsableActivoFijoOriginal((ResponsableActivoFijo)responsableactivofijo.clone());		
	}
	
	public void setResponsableActivoFijosOriginal(List<ResponsableActivoFijo> responsableactivofijos)throws Exception  {
		
		for(ResponsableActivoFijo responsableactivofijo:responsableactivofijos){
			responsableactivofijo.setResponsableActivoFijoOriginal((ResponsableActivoFijo)responsableactivofijo.clone());
		}
	}
	
	public static void setResponsableActivoFijoOriginalStatic(ResponsableActivoFijo responsableactivofijo)throws Exception  {
		responsableactivofijo.setResponsableActivoFijoOriginal((ResponsableActivoFijo)responsableactivofijo.clone());		
	}
	
	public static void setResponsableActivoFijosOriginalStatic(List<ResponsableActivoFijo> responsableactivofijos)throws Exception  {
		
		for(ResponsableActivoFijo responsableactivofijo:responsableactivofijos){
			responsableactivofijo.setResponsableActivoFijoOriginal((ResponsableActivoFijo)responsableactivofijo.clone());
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
	
	public  ResponsableActivoFijo getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		ResponsableActivoFijo entity = new ResponsableActivoFijo();		
		
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
	
	public  ResponsableActivoFijo getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		ResponsableActivoFijo entity = new ResponsableActivoFijo();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ResponsableActivoFijoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ResponsableActivoFijoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//ActivosFijos.ResponsableActivoFijo.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setResponsableActivoFijoOriginal(new ResponsableActivoFijo());
      	    	entity=super.getEntity("",entity,resultSet,ResponsableActivoFijoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityResponsableActivoFijo("",entity,resultSet); 
				
				//entity.setResponsableActivoFijoOriginal(super.getEntity("",entity.getResponsableActivoFijoOriginal(),resultSet,ResponsableActivoFijoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setResponsableActivoFijoOriginal(this.getEntityResponsableActivoFijo("",entity.getResponsableActivoFijoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseResponsableActivoFijo(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  ResponsableActivoFijo getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ResponsableActivoFijo entity = new ResponsableActivoFijo();
				
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
	
	public  ResponsableActivoFijo getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ResponsableActivoFijo entity = new ResponsableActivoFijo();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ResponsableActivoFijoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ResponsableActivoFijoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ResponsableActivoFijoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//ActivosFijos.ResponsableActivoFijo.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setResponsableActivoFijoOriginal(new ResponsableActivoFijo());
      	    	entity=super.getEntity("",entity,resultSet,ResponsableActivoFijoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityResponsableActivoFijo("",entity,resultSet);    
				
				//entity.setResponsableActivoFijoOriginal(super.getEntity("",entity.getResponsableActivoFijoOriginal(),resultSet,ResponsableActivoFijoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setResponsableActivoFijoOriginal(this.getEntityResponsableActivoFijo("",entity.getResponsableActivoFijoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseResponsableActivoFijo(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //ResponsableActivoFijo
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		ResponsableActivoFijo entity = new ResponsableActivoFijo();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ResponsableActivoFijoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ResponsableActivoFijoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ResponsableActivoFijoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//ActivosFijos.ResponsableActivoFijo.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseResponsableActivoFijo(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<ResponsableActivoFijo> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ResponsableActivoFijo> entities = new  ArrayList<ResponsableActivoFijo>();
		ResponsableActivoFijo entity = new ResponsableActivoFijo();		  
		
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
	
	public  List<ResponsableActivoFijo> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ResponsableActivoFijo> entities = new  ArrayList<ResponsableActivoFijo>();
		ResponsableActivoFijo entity = new ResponsableActivoFijo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ResponsableActivoFijoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ResponsableActivoFijoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ResponsableActivoFijoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ResponsableActivoFijo();
      	    	entity=super.getEntity("",entity,resultSet,ResponsableActivoFijoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityResponsableActivoFijo("",entity,resultSet);
      	    	
				//entity.setResponsableActivoFijoOriginal( new ResponsableActivoFijo());
      	    	//entity.setResponsableActivoFijoOriginal(super.getEntity("",entity.getResponsableActivoFijoOriginal(),resultSet,ResponsableActivoFijoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setResponsableActivoFijoOriginal(this.getEntityResponsableActivoFijo("",entity.getResponsableActivoFijoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseResponsableActivoFijos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarResponsableActivoFijo(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ResponsableActivoFijo> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ResponsableActivoFijo> entities = new  ArrayList<ResponsableActivoFijo>();
		ResponsableActivoFijo entity = new ResponsableActivoFijo();		  
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
	
	public  List<ResponsableActivoFijo> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ResponsableActivoFijo> entities = new  ArrayList<ResponsableActivoFijo>();
		ResponsableActivoFijo entity = new ResponsableActivoFijo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ResponsableActivoFijo();
				
				if(conMapGenerico) {
					entity.inicializarMapResponsableActivoFijo();
					//entity.setMapResponsableActivoFijo(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapResponsableActivoFijoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapResponsableActivoFijo().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ResponsableActivoFijoDataAccess.ISWITHSCHEMA);         		
					entity=ResponsableActivoFijoDataAccess.getEntityResponsableActivoFijo("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setResponsableActivoFijoOriginal( new ResponsableActivoFijo());
					////entity.setResponsableActivoFijoOriginal(super.getEntity("",entity.getResponsableActivoFijoOriginal(),resultSet,ResponsableActivoFijoDataAccess.ISWITHSCHEMA));         		
					////entity.setResponsableActivoFijoOriginal(this.getEntityResponsableActivoFijo("",entity.getResponsableActivoFijoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseResponsableActivoFijos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarResponsableActivoFijo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public ResponsableActivoFijo getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ResponsableActivoFijo entity = new ResponsableActivoFijo();		  
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
	
	public  ResponsableActivoFijo getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ResponsableActivoFijo entity = new ResponsableActivoFijo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ResponsableActivoFijo();
				
				if(conMapGenerico) {
					entity.inicializarMapResponsableActivoFijo();
					//entity.setMapResponsableActivoFijo(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapResponsableActivoFijoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapResponsableActivoFijo().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ResponsableActivoFijoDataAccess.ISWITHSCHEMA);         		
					entity=ResponsableActivoFijoDataAccess.getEntityResponsableActivoFijo("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setResponsableActivoFijoOriginal( new ResponsableActivoFijo());
					////entity.setResponsableActivoFijoOriginal(super.getEntity("",entity.getResponsableActivoFijoOriginal(),resultSet,ResponsableActivoFijoDataAccess.ISWITHSCHEMA));         		
					////entity.setResponsableActivoFijoOriginal(this.getEntityResponsableActivoFijo("",entity.getResponsableActivoFijoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseResponsableActivoFijo(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarResponsableActivoFijo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ResponsableActivoFijo getEntityResponsableActivoFijo(String strPrefijo,ResponsableActivoFijo entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = ResponsableActivoFijo.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = ResponsableActivoFijo.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ResponsableActivoFijoDataAccess.setFieldReflectionResponsableActivoFijo(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasResponsableActivoFijo=ResponsableActivoFijoConstantesFunciones.getTodosTiposColumnasResponsableActivoFijo();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasResponsableActivoFijo) {
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
							field = ResponsableActivoFijo.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = ResponsableActivoFijo.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ResponsableActivoFijoDataAccess.setFieldReflectionResponsableActivoFijo(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionResponsableActivoFijo(Field field,String strPrefijo,String sColumn,ResponsableActivoFijo entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ResponsableActivoFijoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ResponsableActivoFijoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ResponsableActivoFijoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ResponsableActivoFijoConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ResponsableActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ResponsableActivoFijoConstantesFunciones.IDESTRUCTURA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ResponsableActivoFijoConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ResponsableActivoFijoConstantesFunciones.UBICACION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ResponsableActivoFijoConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case ResponsableActivoFijoConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ResponsableActivoFijo>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<ResponsableActivoFijo> entities = new  ArrayList<ResponsableActivoFijo>();
		ResponsableActivoFijo entity = new ResponsableActivoFijo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ResponsableActivoFijoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ResponsableActivoFijoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ResponsableActivoFijoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new ResponsableActivoFijo();
					entity=super.getEntity("",entity,resultSet,ResponsableActivoFijoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityResponsableActivoFijo("",entity,resultSet);
					
					//entity.setResponsableActivoFijoOriginal( new ResponsableActivoFijo());
					//entity.setResponsableActivoFijoOriginal(super.getEntity("",entity.getResponsableActivoFijoOriginal(),resultSet,ResponsableActivoFijoDataAccess.ISWITHSCHEMA));         		
					//entity.setResponsableActivoFijoOriginal(this.getEntityResponsableActivoFijo("",entity.getResponsableActivoFijoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseResponsableActivoFijos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarResponsableActivoFijo(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ResponsableActivoFijo>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<ResponsableActivoFijo> entities = new  ArrayList<ResponsableActivoFijo>();
		ResponsableActivoFijo entity = new ResponsableActivoFijo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ResponsableActivoFijoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ResponsableActivoFijoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ResponsableActivoFijoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<ResponsableActivoFijo> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ResponsableActivoFijo> entities = new  ArrayList<ResponsableActivoFijo>();
		ResponsableActivoFijo entity = new ResponsableActivoFijo();		  
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
	
	public  List<ResponsableActivoFijo> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ResponsableActivoFijo> entities = new  ArrayList<ResponsableActivoFijo>();
		ResponsableActivoFijo entity = new ResponsableActivoFijo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ResponsableActivoFijo();
      	    	entity=super.getEntity("",entity,resultSet,ResponsableActivoFijoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityResponsableActivoFijo("",entity,resultSet);
      	    	
				//entity.setResponsableActivoFijoOriginal( new ResponsableActivoFijo());
      	    	//entity.setResponsableActivoFijoOriginal(super.getEntity("",entity.getResponsableActivoFijoOriginal(),resultSet,ResponsableActivoFijoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setResponsableActivoFijoOriginal(this.getEntityResponsableActivoFijo("",entity.getResponsableActivoFijoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseResponsableActivoFijos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarResponsableActivoFijo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ResponsableActivoFijo> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ResponsableActivoFijo> entities = new  ArrayList<ResponsableActivoFijo>();
		ResponsableActivoFijo entity = new ResponsableActivoFijo();		  
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
	
	public  List<ResponsableActivoFijo> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ResponsableActivoFijo> entities = new  ArrayList<ResponsableActivoFijo>();
		ResponsableActivoFijo entity = new ResponsableActivoFijo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ResponsableActivoFijo();
      	    	entity=super.getEntity("",entity,resultSet,ResponsableActivoFijoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityResponsableActivoFijo("",entity,resultSet);
      	    	
				//entity.setResponsableActivoFijoOriginal( new ResponsableActivoFijo());
      	    	//entity.setResponsableActivoFijoOriginal(super.getEntity("",entity.getResponsableActivoFijoOriginal(),resultSet,ResponsableActivoFijoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setResponsableActivoFijoOriginal(this.getEntityResponsableActivoFijo("",entity.getResponsableActivoFijoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseResponsableActivoFijos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public ResponsableActivoFijo getEntityResponsableActivoFijo(String strPrefijo,ResponsableActivoFijo entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+ResponsableActivoFijoConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+ResponsableActivoFijoConstantesFunciones.IDSUCURSAL));
				entity.setid_detalle_activo_fijo(resultSet.getLong(strPrefijo+ResponsableActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJO));
				entity.setid_estructura(resultSet.getLong(strPrefijo+ResponsableActivoFijoConstantesFunciones.IDESTRUCTURA));
				entity.setid_empleado(resultSet.getLong(strPrefijo+ResponsableActivoFijoConstantesFunciones.IDEMPLEADO));
				entity.setubicacion(resultSet.getString(strPrefijo+ResponsableActivoFijoConstantesFunciones.UBICACION));
				entity.setfecha(new Date(resultSet.getDate(strPrefijo+ResponsableActivoFijoConstantesFunciones.FECHA).getTime()));
				entity.setdescripcion(resultSet.getString(strPrefijo+ResponsableActivoFijoConstantesFunciones.DESCRIPCION));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowResponsableActivoFijo(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(ResponsableActivoFijo entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ResponsableActivoFijoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ResponsableActivoFijoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ResponsableActivoFijoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ResponsableActivoFijoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ResponsableActivoFijoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ResponsableActivoFijoDataAccess.TABLENAME,ResponsableActivoFijoDataAccess.ISWITHSTOREPROCEDURES);
			
			ResponsableActivoFijoDataAccess.setResponsableActivoFijoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,ResponsableActivoFijo relresponsableactivofijo)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relresponsableactivofijo.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,ResponsableActivoFijo relresponsableactivofijo)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relresponsableactivofijo.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public DetalleActivoFijo getDetalleActivoFijo(Connexion connexion,ResponsableActivoFijo relresponsableactivofijo)throws SQLException,Exception {

		DetalleActivoFijo detalleactivofijo= new DetalleActivoFijo();

		try {
			DetalleActivoFijoDataAccess detalleactivofijoDataAccess=new DetalleActivoFijoDataAccess();

			detalleactivofijoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			detalleactivofijoDataAccess.setConnexionType(this.connexionType);
			detalleactivofijoDataAccess.setParameterDbType(this.parameterDbType);

			detalleactivofijo=detalleactivofijoDataAccess.getEntity(connexion,relresponsableactivofijo.getid_detalle_activo_fijo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalleactivofijo;

	}

	public Estructura getEstructura(Connexion connexion,ResponsableActivoFijo relresponsableactivofijo)throws SQLException,Exception {

		Estructura estructura= new Estructura();

		try {
			EstructuraDataAccess estructuraDataAccess=new EstructuraDataAccess();

			estructuraDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estructuraDataAccess.setConnexionType(this.connexionType);
			estructuraDataAccess.setParameterDbType(this.parameterDbType);

			estructura=estructuraDataAccess.getEntity(connexion,relresponsableactivofijo.getid_estructura());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estructura;

	}

	public Empleado getEmpleado(Connexion connexion,ResponsableActivoFijo relresponsableactivofijo)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relresponsableactivofijo.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,ResponsableActivoFijo responsableactivofijo) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!responsableactivofijo.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(responsableactivofijo.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(responsableactivofijo.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_detalle_activo_fijo=new ParameterValue<Long>();
					parameterMaintenanceValueid_detalle_activo_fijo.setValue(responsableactivofijo.getid_detalle_activo_fijo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_detalle_activo_fijo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estructura=new ParameterValue<Long>();
					parameterMaintenanceValueid_estructura.setValue(responsableactivofijo.getid_estructura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estructura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(responsableactivofijo.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueubicacion=new ParameterValue<String>();
					parameterMaintenanceValueubicacion.setValue(responsableactivofijo.getubicacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueubicacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha=new ParameterValue<Date>();
					parameterMaintenanceValuefecha.setValue(responsableactivofijo.getfecha());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(responsableactivofijo.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!responsableactivofijo.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(responsableactivofijo.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(responsableactivofijo.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(responsableactivofijo.getId());
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
	
	public void setIsNewIsChangedFalseResponsableActivoFijo(ResponsableActivoFijo responsableactivofijo)throws Exception  {		
		responsableactivofijo.setIsNew(false);
		responsableactivofijo.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseResponsableActivoFijos(List<ResponsableActivoFijo> responsableactivofijos)throws Exception  {				
		for(ResponsableActivoFijo responsableactivofijo:responsableactivofijos) {
			responsableactivofijo.setIsNew(false);
			responsableactivofijo.setIsChanged(false);
		}
	}
	
	public void generarExportarResponsableActivoFijo(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
