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
package com.bydan.erp.inventario.business.dataaccess;

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

import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.inventario.util.*;//AutoriConsepConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;




@SuppressWarnings("unused")
final public class AutoriConsepDataAccess extends  AutoriConsepDataAccessAdditional{ //AutoriConsepDataAccessAdditional,DataAccessHelper<AutoriConsep>
	//static Logger logger = Logger.getLogger(AutoriConsepDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="autori_consep";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+AutoriConsepConstantesFunciones.SCHEMA+"."+AutoriConsepConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_usuario,es_empresa,id_cliente,numero_autorizacion,id_tipo_autori_consep,id_empleado,fecha_emision,fecha_vencimiento,fecha_ultima,fecha,descripcion,nombre)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+AutoriConsepConstantesFunciones.SCHEMA+"."+AutoriConsepConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_usuario=?,es_empresa=?,id_cliente=?,numero_autorizacion=?,id_tipo_autori_consep=?,id_empleado=?,fecha_emision=?,fecha_vencimiento=?,fecha_ultima=?,fecha=?,descripcion=?,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+AutoriConsepConstantesFunciones.SCHEMA+"."+AutoriConsepConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select autoriconsep from "+AutoriConsepConstantesFunciones.SPERSISTENCENAME+" autoriconsep";
	public static String QUERYSELECTNATIVE="select "+AutoriConsepConstantesFunciones.SCHEMA+"."+AutoriConsepConstantesFunciones.TABLENAME+".id,"+AutoriConsepConstantesFunciones.SCHEMA+"."+AutoriConsepConstantesFunciones.TABLENAME+".version_row,"+AutoriConsepConstantesFunciones.SCHEMA+"."+AutoriConsepConstantesFunciones.TABLENAME+".id_empresa,"+AutoriConsepConstantesFunciones.SCHEMA+"."+AutoriConsepConstantesFunciones.TABLENAME+".id_usuario,"+AutoriConsepConstantesFunciones.SCHEMA+"."+AutoriConsepConstantesFunciones.TABLENAME+".es_empresa,"+AutoriConsepConstantesFunciones.SCHEMA+"."+AutoriConsepConstantesFunciones.TABLENAME+".id_cliente,"+AutoriConsepConstantesFunciones.SCHEMA+"."+AutoriConsepConstantesFunciones.TABLENAME+".numero_autorizacion,"+AutoriConsepConstantesFunciones.SCHEMA+"."+AutoriConsepConstantesFunciones.TABLENAME+".id_tipo_autori_consep,"+AutoriConsepConstantesFunciones.SCHEMA+"."+AutoriConsepConstantesFunciones.TABLENAME+".id_empleado,"+AutoriConsepConstantesFunciones.SCHEMA+"."+AutoriConsepConstantesFunciones.TABLENAME+".fecha_emision,"+AutoriConsepConstantesFunciones.SCHEMA+"."+AutoriConsepConstantesFunciones.TABLENAME+".fecha_vencimiento,"+AutoriConsepConstantesFunciones.SCHEMA+"."+AutoriConsepConstantesFunciones.TABLENAME+".fecha_ultima,"+AutoriConsepConstantesFunciones.SCHEMA+"."+AutoriConsepConstantesFunciones.TABLENAME+".fecha,"+AutoriConsepConstantesFunciones.SCHEMA+"."+AutoriConsepConstantesFunciones.TABLENAME+".descripcion,"+AutoriConsepConstantesFunciones.SCHEMA+"."+AutoriConsepConstantesFunciones.TABLENAME+".nombre from "+AutoriConsepConstantesFunciones.SCHEMA+"."+AutoriConsepConstantesFunciones.TABLENAME;//+" as "+AutoriConsepConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+AutoriConsepConstantesFunciones.SCHEMA+"."+AutoriConsepConstantesFunciones.TABLENAME+".id,"+AutoriConsepConstantesFunciones.SCHEMA+"."+AutoriConsepConstantesFunciones.TABLENAME+".version_row,"+AutoriConsepConstantesFunciones.SCHEMA+"."+AutoriConsepConstantesFunciones.TABLENAME+".nombre from "+AutoriConsepConstantesFunciones.SCHEMA+"."+AutoriConsepConstantesFunciones.TABLENAME;//+" as "+AutoriConsepConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+AutoriConsepConstantesFunciones.SCHEMA+"."+AutoriConsepConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_usuario=?,es_empresa=?,id_cliente=?,numero_autorizacion=?,id_tipo_autori_consep=?,id_empleado=?,fecha_emision=?,fecha_vencimiento=?,fecha_ultima=?,fecha=?,descripcion=?,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_AUTORICONSEP_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_AUTORICONSEP_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_AUTORICONSEP_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_AUTORICONSEP_SELECT(?,?)";
	
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
	
	
	protected AutoriConsepDataAccessAdditional autoriconsepDataAccessAdditional=null;
	
	public AutoriConsepDataAccessAdditional getAutoriConsepDataAccessAdditional() {
		return this.autoriconsepDataAccessAdditional;
	}
	
	public void setAutoriConsepDataAccessAdditional(AutoriConsepDataAccessAdditional autoriconsepDataAccessAdditional) {
		try {
			this.autoriconsepDataAccessAdditional=autoriconsepDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public AutoriConsepDataAccess() {
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
		AutoriConsepDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		AutoriConsepDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		AutoriConsepDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setAutoriConsepOriginal(AutoriConsep autoriconsep)throws Exception  {
		autoriconsep.setAutoriConsepOriginal((AutoriConsep)autoriconsep.clone());		
	}
	
	public void setAutoriConsepsOriginal(List<AutoriConsep> autoriconseps)throws Exception  {
		
		for(AutoriConsep autoriconsep:autoriconseps){
			autoriconsep.setAutoriConsepOriginal((AutoriConsep)autoriconsep.clone());
		}
	}
	
	public static void setAutoriConsepOriginalStatic(AutoriConsep autoriconsep)throws Exception  {
		autoriconsep.setAutoriConsepOriginal((AutoriConsep)autoriconsep.clone());		
	}
	
	public static void setAutoriConsepsOriginalStatic(List<AutoriConsep> autoriconseps)throws Exception  {
		
		for(AutoriConsep autoriconsep:autoriconseps){
			autoriconsep.setAutoriConsepOriginal((AutoriConsep)autoriconsep.clone());
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
	
	public  AutoriConsep getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		AutoriConsep entity = new AutoriConsep();		
		
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
	
	public  AutoriConsep getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		AutoriConsep entity = new AutoriConsep();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=AutoriConsepDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=AutoriConsepDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.AutoriConsep.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setAutoriConsepOriginal(new AutoriConsep());
      	    	entity=super.getEntity("",entity,resultSet,AutoriConsepDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityAutoriConsep("",entity,resultSet); 
				
				//entity.setAutoriConsepOriginal(super.getEntity("",entity.getAutoriConsepOriginal(),resultSet,AutoriConsepDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setAutoriConsepOriginal(this.getEntityAutoriConsep("",entity.getAutoriConsepOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseAutoriConsep(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  AutoriConsep getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		AutoriConsep entity = new AutoriConsep();
				
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
	
	public  AutoriConsep getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		AutoriConsep entity = new AutoriConsep();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=AutoriConsepDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=AutoriConsepDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AutoriConsepDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.AutoriConsep.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setAutoriConsepOriginal(new AutoriConsep());
      	    	entity=super.getEntity("",entity,resultSet,AutoriConsepDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityAutoriConsep("",entity,resultSet);    
				
				//entity.setAutoriConsepOriginal(super.getEntity("",entity.getAutoriConsepOriginal(),resultSet,AutoriConsepDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setAutoriConsepOriginal(this.getEntityAutoriConsep("",entity.getAutoriConsepOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseAutoriConsep(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //AutoriConsep
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		AutoriConsep entity = new AutoriConsep();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=AutoriConsepDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=AutoriConsepDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AutoriConsepDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.AutoriConsep.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseAutoriConsep(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<AutoriConsep> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<AutoriConsep> entities = new  ArrayList<AutoriConsep>();
		AutoriConsep entity = new AutoriConsep();		  
		
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
	
	public  List<AutoriConsep> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<AutoriConsep> entities = new  ArrayList<AutoriConsep>();
		AutoriConsep entity = new AutoriConsep();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=AutoriConsepDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=AutoriConsepDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AutoriConsepDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new AutoriConsep();
      	    	entity=super.getEntity("",entity,resultSet,AutoriConsepDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityAutoriConsep("",entity,resultSet);
      	    	
				//entity.setAutoriConsepOriginal( new AutoriConsep());
      	    	//entity.setAutoriConsepOriginal(super.getEntity("",entity.getAutoriConsepOriginal(),resultSet,AutoriConsepDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setAutoriConsepOriginal(this.getEntityAutoriConsep("",entity.getAutoriConsepOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseAutoriConseps(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAutoriConsep(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<AutoriConsep> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<AutoriConsep> entities = new  ArrayList<AutoriConsep>();
		AutoriConsep entity = new AutoriConsep();		  
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
	
	public  List<AutoriConsep> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<AutoriConsep> entities = new  ArrayList<AutoriConsep>();
		AutoriConsep entity = new AutoriConsep();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new AutoriConsep();
				
				if(conMapGenerico) {
					entity.inicializarMapAutoriConsep();
					//entity.setMapAutoriConsep(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapAutoriConsepValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapAutoriConsep().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,AutoriConsepDataAccess.ISWITHSCHEMA);         		
					entity=AutoriConsepDataAccess.getEntityAutoriConsep("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setAutoriConsepOriginal( new AutoriConsep());
					////entity.setAutoriConsepOriginal(super.getEntity("",entity.getAutoriConsepOriginal(),resultSet,AutoriConsepDataAccess.ISWITHSCHEMA));         		
					////entity.setAutoriConsepOriginal(this.getEntityAutoriConsep("",entity.getAutoriConsepOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseAutoriConseps(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAutoriConsep(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public AutoriConsep getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		AutoriConsep entity = new AutoriConsep();		  
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
	
	public  AutoriConsep getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		AutoriConsep entity = new AutoriConsep();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new AutoriConsep();
				
				if(conMapGenerico) {
					entity.inicializarMapAutoriConsep();
					//entity.setMapAutoriConsep(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapAutoriConsepValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapAutoriConsep().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,AutoriConsepDataAccess.ISWITHSCHEMA);         		
					entity=AutoriConsepDataAccess.getEntityAutoriConsep("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setAutoriConsepOriginal( new AutoriConsep());
					////entity.setAutoriConsepOriginal(super.getEntity("",entity.getAutoriConsepOriginal(),resultSet,AutoriConsepDataAccess.ISWITHSCHEMA));         		
					////entity.setAutoriConsepOriginal(this.getEntityAutoriConsep("",entity.getAutoriConsepOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseAutoriConsep(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAutoriConsep(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static AutoriConsep getEntityAutoriConsep(String strPrefijo,AutoriConsep entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = AutoriConsep.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = AutoriConsep.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					AutoriConsepDataAccess.setFieldReflectionAutoriConsep(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasAutoriConsep=AutoriConsepConstantesFunciones.getTodosTiposColumnasAutoriConsep();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasAutoriConsep) {
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
							field = AutoriConsep.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = AutoriConsep.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						AutoriConsepDataAccess.setFieldReflectionAutoriConsep(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionAutoriConsep(Field field,String strPrefijo,String sColumn,AutoriConsep entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case AutoriConsepConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AutoriConsepConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case AutoriConsepConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AutoriConsepConstantesFunciones.IDUSUARIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AutoriConsepConstantesFunciones.ESEMPRESA:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case AutoriConsepConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AutoriConsepConstantesFunciones.NUMEROAUTORIZACION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case AutoriConsepConstantesFunciones.IDTIPOAUTORICONSEP:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AutoriConsepConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AutoriConsepConstantesFunciones.FECHAEMISION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case AutoriConsepConstantesFunciones.FECHAVENCIMIENTO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case AutoriConsepConstantesFunciones.FECHAULTIMA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case AutoriConsepConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case AutoriConsepConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case AutoriConsepConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<AutoriConsep>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<AutoriConsep> entities = new  ArrayList<AutoriConsep>();
		AutoriConsep entity = new AutoriConsep();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=AutoriConsepDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=AutoriConsepDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AutoriConsepDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new AutoriConsep();
					entity=super.getEntity("",entity,resultSet,AutoriConsepDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityAutoriConsep("",entity,resultSet);
					
					//entity.setAutoriConsepOriginal( new AutoriConsep());
					//entity.setAutoriConsepOriginal(super.getEntity("",entity.getAutoriConsepOriginal(),resultSet,AutoriConsepDataAccess.ISWITHSCHEMA));         		
					//entity.setAutoriConsepOriginal(this.getEntityAutoriConsep("",entity.getAutoriConsepOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseAutoriConseps(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAutoriConsep(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<AutoriConsep>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<AutoriConsep> entities = new  ArrayList<AutoriConsep>();
		AutoriConsep entity = new AutoriConsep();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=AutoriConsepDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=AutoriConsepDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AutoriConsepDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<AutoriConsep> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<AutoriConsep> entities = new  ArrayList<AutoriConsep>();
		AutoriConsep entity = new AutoriConsep();		  
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
	
	public  List<AutoriConsep> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<AutoriConsep> entities = new  ArrayList<AutoriConsep>();
		AutoriConsep entity = new AutoriConsep();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new AutoriConsep();
      	    	entity=super.getEntity("",entity,resultSet,AutoriConsepDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityAutoriConsep("",entity,resultSet);
      	    	
				//entity.setAutoriConsepOriginal( new AutoriConsep());
      	    	//entity.setAutoriConsepOriginal(super.getEntity("",entity.getAutoriConsepOriginal(),resultSet,AutoriConsepDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setAutoriConsepOriginal(this.getEntityAutoriConsep("",entity.getAutoriConsepOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseAutoriConseps(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAutoriConsep(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<AutoriConsep> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<AutoriConsep> entities = new  ArrayList<AutoriConsep>();
		AutoriConsep entity = new AutoriConsep();		  
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
	
	public  List<AutoriConsep> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<AutoriConsep> entities = new  ArrayList<AutoriConsep>();
		AutoriConsep entity = new AutoriConsep();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new AutoriConsep();
      	    	entity=super.getEntity("",entity,resultSet,AutoriConsepDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityAutoriConsep("",entity,resultSet);
      	    	
				//entity.setAutoriConsepOriginal( new AutoriConsep());
      	    	//entity.setAutoriConsepOriginal(super.getEntity("",entity.getAutoriConsepOriginal(),resultSet,AutoriConsepDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setAutoriConsepOriginal(this.getEntityAutoriConsep("",entity.getAutoriConsepOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseAutoriConseps(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public AutoriConsep getEntityAutoriConsep(String strPrefijo,AutoriConsep entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+AutoriConsepConstantesFunciones.IDEMPRESA));
				entity.setid_usuario(resultSet.getLong(strPrefijo+AutoriConsepConstantesFunciones.IDUSUARIO));
				entity.setes_empresa(resultSet.getBoolean(strPrefijo+AutoriConsepConstantesFunciones.ESEMPRESA));
				entity.setid_cliente(resultSet.getLong(strPrefijo+AutoriConsepConstantesFunciones.IDCLIENTE));
				entity.setnumero_autorizacion(resultSet.getString(strPrefijo+AutoriConsepConstantesFunciones.NUMEROAUTORIZACION));
				entity.setid_tipo_autori_consep(resultSet.getLong(strPrefijo+AutoriConsepConstantesFunciones.IDTIPOAUTORICONSEP));
				entity.setid_empleado(resultSet.getLong(strPrefijo+AutoriConsepConstantesFunciones.IDEMPLEADO));
				entity.setfecha_emision(new Date(resultSet.getDate(strPrefijo+AutoriConsepConstantesFunciones.FECHAEMISION).getTime()));
				entity.setfecha_vencimiento(new Date(resultSet.getDate(strPrefijo+AutoriConsepConstantesFunciones.FECHAVENCIMIENTO).getTime()));
				entity.setfecha_ultima(new Date(resultSet.getDate(strPrefijo+AutoriConsepConstantesFunciones.FECHAULTIMA).getTime()));
				entity.setfecha(new Date(resultSet.getDate(strPrefijo+AutoriConsepConstantesFunciones.FECHA).getTime()));
				entity.setdescripcion(resultSet.getString(strPrefijo+AutoriConsepConstantesFunciones.DESCRIPCION));
				entity.setnombre(resultSet.getString(strPrefijo+AutoriConsepConstantesFunciones.NOMBRE));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+AutoriConsepConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowAutoriConsep(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(AutoriConsep entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=AutoriConsepDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=AutoriConsepDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=AutoriConsepDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=AutoriConsepDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(AutoriConsepConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,AutoriConsepDataAccess.TABLENAME,AutoriConsepDataAccess.ISWITHSTOREPROCEDURES);
			
			AutoriConsepDataAccess.setAutoriConsepOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,AutoriConsep relautoriconsep)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relautoriconsep.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Usuario getUsuario(Connexion connexion,AutoriConsep relautoriconsep)throws SQLException,Exception {

		Usuario usuario= new Usuario();

		try {
			UsuarioDataAccess usuarioDataAccess=new UsuarioDataAccess();

			usuarioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			usuarioDataAccess.setConnexionType(this.connexionType);
			usuarioDataAccess.setParameterDbType(this.parameterDbType);

			usuario=usuarioDataAccess.getEntity(connexion,relautoriconsep.getid_usuario());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return usuario;

	}

	public Cliente getCliente(Connexion connexion,AutoriConsep relautoriconsep)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,relautoriconsep.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public TipoAutoriConsep getTipoAutoriConsep(Connexion connexion,AutoriConsep relautoriconsep)throws SQLException,Exception {

		TipoAutoriConsep tipoautoriconsep= new TipoAutoriConsep();

		try {
			TipoAutoriConsepDataAccess tipoautoriconsepDataAccess=new TipoAutoriConsepDataAccess();

			tipoautoriconsepDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoautoriconsepDataAccess.setConnexionType(this.connexionType);
			tipoautoriconsepDataAccess.setParameterDbType(this.parameterDbType);

			tipoautoriconsep=tipoautoriconsepDataAccess.getEntity(connexion,relautoriconsep.getid_tipo_autori_consep());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoautoriconsep;

	}

	public Empleado getEmpleado(Connexion connexion,AutoriConsep relautoriconsep)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relautoriconsep.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}


		
		public List<DetalleAutoriConsep> getDetalleAutoriConseps(Connexion connexion,AutoriConsep autoriconsep)throws SQLException,Exception {

		List<DetalleAutoriConsep> detalleautoriconseps= new ArrayList<DetalleAutoriConsep>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+AutoriConsepConstantesFunciones.SCHEMA+".autori_consep ON "+DetalleAutoriConsepConstantesFunciones.SCHEMA+".detalle_autori_consep.id_autori_consep="+AutoriConsepConstantesFunciones.SCHEMA+".autori_consep.id WHERE "+AutoriConsepConstantesFunciones.SCHEMA+".autori_consep.id="+String.valueOf(autoriconsep.getId());
			} else {
				sQuery=" INNER JOIN detalleautoriconsep.AutoriConsep WHERE detalleautoriconsep.AutoriConsep.id="+String.valueOf(autoriconsep.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleAutoriConsepDataAccess detalleautoriconsepDataAccess=new DetalleAutoriConsepDataAccess();

			detalleautoriconsepDataAccess.setConnexionType(this.connexionType);
			detalleautoriconsepDataAccess.setParameterDbType(this.parameterDbType);
			detalleautoriconseps=detalleautoriconsepDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalleautoriconseps;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,AutoriConsep autoriconsep) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!autoriconsep.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(autoriconsep.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_usuario=new ParameterValue<Long>();
					parameterMaintenanceValueid_usuario.setValue(autoriconsep.getid_usuario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_usuario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_empresa=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_empresa.setValue(autoriconsep.getes_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_cliente.setValue(autoriconsep.getid_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_autorizacion=new ParameterValue<String>();
					parameterMaintenanceValuenumero_autorizacion.setValue(autoriconsep.getnumero_autorizacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_autorizacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_autori_consep=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_autori_consep.setValue(autoriconsep.getid_tipo_autori_consep());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_autori_consep);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(autoriconsep.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_emision=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_emision.setValue(autoriconsep.getfecha_emision());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_emision);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_vencimiento=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_vencimiento.setValue(autoriconsep.getfecha_vencimiento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_vencimiento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_ultima=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_ultima.setValue(autoriconsep.getfecha_ultima());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_ultima);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha=new ParameterValue<Date>();
					parameterMaintenanceValuefecha.setValue(autoriconsep.getfecha());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(autoriconsep.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(autoriconsep.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!autoriconsep.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(autoriconsep.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(autoriconsep.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(autoriconsep.getId());
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
	
	public void setIsNewIsChangedFalseAutoriConsep(AutoriConsep autoriconsep)throws Exception  {		
		autoriconsep.setIsNew(false);
		autoriconsep.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseAutoriConseps(List<AutoriConsep> autoriconseps)throws Exception  {				
		for(AutoriConsep autoriconsep:autoriconseps) {
			autoriconsep.setIsNew(false);
			autoriconsep.setIsChanged(false);
		}
	}
	
	public void generarExportarAutoriConsep(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
