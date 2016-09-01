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
package com.bydan.erp.nomina.business.dataaccess;

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

import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.nomina.util.*;//SolicitudReemplazoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class SolicitudReemplazoDataAccess extends  SolicitudReemplazoDataAccessAdditional{ //SolicitudReemplazoDataAccessAdditional,DataAccessHelper<SolicitudReemplazo>
	//static Logger logger = Logger.getLogger(SolicitudReemplazoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="solicitud_reemplazo";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+SolicitudReemplazoConstantesFunciones.SCHEMA+"."+SolicitudReemplazoConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_empleado_jefe,id_empleado,id_empleado_reemplazo,id_estructura,id_estado_solicitud_nomi,secuencial,fecha_solicita,fecha_ejecuta,numero_horas,costo_unitario,costo_total,descripcion)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+SolicitudReemplazoConstantesFunciones.SCHEMA+"."+SolicitudReemplazoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_empleado_jefe=?,id_empleado=?,id_empleado_reemplazo=?,id_estructura=?,id_estado_solicitud_nomi=?,secuencial=?,fecha_solicita=?,fecha_ejecuta=?,numero_horas=?,costo_unitario=?,costo_total=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+SolicitudReemplazoConstantesFunciones.SCHEMA+"."+SolicitudReemplazoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select solicitudreemplazo from "+SolicitudReemplazoConstantesFunciones.SPERSISTENCENAME+" solicitudreemplazo";
	public static String QUERYSELECTNATIVE="select "+SolicitudReemplazoConstantesFunciones.SCHEMA+"."+SolicitudReemplazoConstantesFunciones.TABLENAME+".id,"+SolicitudReemplazoConstantesFunciones.SCHEMA+"."+SolicitudReemplazoConstantesFunciones.TABLENAME+".version_row,"+SolicitudReemplazoConstantesFunciones.SCHEMA+"."+SolicitudReemplazoConstantesFunciones.TABLENAME+".id_empresa,"+SolicitudReemplazoConstantesFunciones.SCHEMA+"."+SolicitudReemplazoConstantesFunciones.TABLENAME+".id_sucursal,"+SolicitudReemplazoConstantesFunciones.SCHEMA+"."+SolicitudReemplazoConstantesFunciones.TABLENAME+".id_empleado_jefe,"+SolicitudReemplazoConstantesFunciones.SCHEMA+"."+SolicitudReemplazoConstantesFunciones.TABLENAME+".id_empleado,"+SolicitudReemplazoConstantesFunciones.SCHEMA+"."+SolicitudReemplazoConstantesFunciones.TABLENAME+".id_empleado_reemplazo,"+SolicitudReemplazoConstantesFunciones.SCHEMA+"."+SolicitudReemplazoConstantesFunciones.TABLENAME+".id_estructura,"+SolicitudReemplazoConstantesFunciones.SCHEMA+"."+SolicitudReemplazoConstantesFunciones.TABLENAME+".id_estado_solicitud_nomi,"+SolicitudReemplazoConstantesFunciones.SCHEMA+"."+SolicitudReemplazoConstantesFunciones.TABLENAME+".secuencial,"+SolicitudReemplazoConstantesFunciones.SCHEMA+"."+SolicitudReemplazoConstantesFunciones.TABLENAME+".fecha_solicita,"+SolicitudReemplazoConstantesFunciones.SCHEMA+"."+SolicitudReemplazoConstantesFunciones.TABLENAME+".fecha_ejecuta,"+SolicitudReemplazoConstantesFunciones.SCHEMA+"."+SolicitudReemplazoConstantesFunciones.TABLENAME+".numero_horas,"+SolicitudReemplazoConstantesFunciones.SCHEMA+"."+SolicitudReemplazoConstantesFunciones.TABLENAME+".costo_unitario,"+SolicitudReemplazoConstantesFunciones.SCHEMA+"."+SolicitudReemplazoConstantesFunciones.TABLENAME+".costo_total,"+SolicitudReemplazoConstantesFunciones.SCHEMA+"."+SolicitudReemplazoConstantesFunciones.TABLENAME+".descripcion from "+SolicitudReemplazoConstantesFunciones.SCHEMA+"."+SolicitudReemplazoConstantesFunciones.TABLENAME;//+" as "+SolicitudReemplazoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+SolicitudReemplazoConstantesFunciones.SCHEMA+"."+SolicitudReemplazoConstantesFunciones.TABLENAME+".id,"+SolicitudReemplazoConstantesFunciones.SCHEMA+"."+SolicitudReemplazoConstantesFunciones.TABLENAME+".version_row from "+SolicitudReemplazoConstantesFunciones.SCHEMA+"."+SolicitudReemplazoConstantesFunciones.TABLENAME;//+" as "+SolicitudReemplazoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+SolicitudReemplazoConstantesFunciones.SCHEMA+"."+SolicitudReemplazoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_empleado_jefe=?,id_empleado=?,id_empleado_reemplazo=?,id_estructura=?,id_estado_solicitud_nomi=?,secuencial=?,fecha_solicita=?,fecha_ejecuta=?,numero_horas=?,costo_unitario=?,costo_total=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_SOLICITUDREEMPLAZO_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_SOLICITUDREEMPLAZO_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_SOLICITUDREEMPLAZO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_SOLICITUDREEMPLAZO_SELECT(?,?)";
	
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
	
	
	protected SolicitudReemplazoDataAccessAdditional solicitudreemplazoDataAccessAdditional=null;
	
	public SolicitudReemplazoDataAccessAdditional getSolicitudReemplazoDataAccessAdditional() {
		return this.solicitudreemplazoDataAccessAdditional;
	}
	
	public void setSolicitudReemplazoDataAccessAdditional(SolicitudReemplazoDataAccessAdditional solicitudreemplazoDataAccessAdditional) {
		try {
			this.solicitudreemplazoDataAccessAdditional=solicitudreemplazoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public SolicitudReemplazoDataAccess() {
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
		SolicitudReemplazoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		SolicitudReemplazoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		SolicitudReemplazoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setSolicitudReemplazoOriginal(SolicitudReemplazo solicitudreemplazo)throws Exception  {
		solicitudreemplazo.setSolicitudReemplazoOriginal((SolicitudReemplazo)solicitudreemplazo.clone());		
	}
	
	public void setSolicitudReemplazosOriginal(List<SolicitudReemplazo> solicitudreemplazos)throws Exception  {
		
		for(SolicitudReemplazo solicitudreemplazo:solicitudreemplazos){
			solicitudreemplazo.setSolicitudReemplazoOriginal((SolicitudReemplazo)solicitudreemplazo.clone());
		}
	}
	
	public static void setSolicitudReemplazoOriginalStatic(SolicitudReemplazo solicitudreemplazo)throws Exception  {
		solicitudreemplazo.setSolicitudReemplazoOriginal((SolicitudReemplazo)solicitudreemplazo.clone());		
	}
	
	public static void setSolicitudReemplazosOriginalStatic(List<SolicitudReemplazo> solicitudreemplazos)throws Exception  {
		
		for(SolicitudReemplazo solicitudreemplazo:solicitudreemplazos){
			solicitudreemplazo.setSolicitudReemplazoOriginal((SolicitudReemplazo)solicitudreemplazo.clone());
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
	
	public  SolicitudReemplazo getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		SolicitudReemplazo entity = new SolicitudReemplazo();		
		
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
	
	public  SolicitudReemplazo getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		SolicitudReemplazo entity = new SolicitudReemplazo();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=SolicitudReemplazoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=SolicitudReemplazoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.SolicitudReemplazo.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setSolicitudReemplazoOriginal(new SolicitudReemplazo());
      	    	entity=super.getEntity("",entity,resultSet,SolicitudReemplazoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntitySolicitudReemplazo("",entity,resultSet); 
				
				//entity.setSolicitudReemplazoOriginal(super.getEntity("",entity.getSolicitudReemplazoOriginal(),resultSet,SolicitudReemplazoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setSolicitudReemplazoOriginal(this.getEntitySolicitudReemplazo("",entity.getSolicitudReemplazoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseSolicitudReemplazo(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  SolicitudReemplazo getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		SolicitudReemplazo entity = new SolicitudReemplazo();
				
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
	
	public  SolicitudReemplazo getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		SolicitudReemplazo entity = new SolicitudReemplazo();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=SolicitudReemplazoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=SolicitudReemplazoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,SolicitudReemplazoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.SolicitudReemplazo.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setSolicitudReemplazoOriginal(new SolicitudReemplazo());
      	    	entity=super.getEntity("",entity,resultSet,SolicitudReemplazoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntitySolicitudReemplazo("",entity,resultSet);    
				
				//entity.setSolicitudReemplazoOriginal(super.getEntity("",entity.getSolicitudReemplazoOriginal(),resultSet,SolicitudReemplazoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setSolicitudReemplazoOriginal(this.getEntitySolicitudReemplazo("",entity.getSolicitudReemplazoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseSolicitudReemplazo(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //SolicitudReemplazo
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		SolicitudReemplazo entity = new SolicitudReemplazo();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=SolicitudReemplazoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=SolicitudReemplazoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,SolicitudReemplazoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.SolicitudReemplazo.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseSolicitudReemplazo(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<SolicitudReemplazo> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<SolicitudReemplazo> entities = new  ArrayList<SolicitudReemplazo>();
		SolicitudReemplazo entity = new SolicitudReemplazo();		  
		
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
	
	public  List<SolicitudReemplazo> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<SolicitudReemplazo> entities = new  ArrayList<SolicitudReemplazo>();
		SolicitudReemplazo entity = new SolicitudReemplazo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=SolicitudReemplazoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=SolicitudReemplazoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,SolicitudReemplazoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new SolicitudReemplazo();
      	    	entity=super.getEntity("",entity,resultSet,SolicitudReemplazoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntitySolicitudReemplazo("",entity,resultSet);
      	    	
				//entity.setSolicitudReemplazoOriginal( new SolicitudReemplazo());
      	    	//entity.setSolicitudReemplazoOriginal(super.getEntity("",entity.getSolicitudReemplazoOriginal(),resultSet,SolicitudReemplazoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setSolicitudReemplazoOriginal(this.getEntitySolicitudReemplazo("",entity.getSolicitudReemplazoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseSolicitudReemplazos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarSolicitudReemplazo(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<SolicitudReemplazo> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<SolicitudReemplazo> entities = new  ArrayList<SolicitudReemplazo>();
		SolicitudReemplazo entity = new SolicitudReemplazo();		  
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
	
	public  List<SolicitudReemplazo> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<SolicitudReemplazo> entities = new  ArrayList<SolicitudReemplazo>();
		SolicitudReemplazo entity = new SolicitudReemplazo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new SolicitudReemplazo();
				
				if(conMapGenerico) {
					entity.inicializarMapSolicitudReemplazo();
					//entity.setMapSolicitudReemplazo(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapSolicitudReemplazoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapSolicitudReemplazo().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,SolicitudReemplazoDataAccess.ISWITHSCHEMA);         		
					entity=SolicitudReemplazoDataAccess.getEntitySolicitudReemplazo("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setSolicitudReemplazoOriginal( new SolicitudReemplazo());
					////entity.setSolicitudReemplazoOriginal(super.getEntity("",entity.getSolicitudReemplazoOriginal(),resultSet,SolicitudReemplazoDataAccess.ISWITHSCHEMA));         		
					////entity.setSolicitudReemplazoOriginal(this.getEntitySolicitudReemplazo("",entity.getSolicitudReemplazoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseSolicitudReemplazos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarSolicitudReemplazo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public SolicitudReemplazo getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		SolicitudReemplazo entity = new SolicitudReemplazo();		  
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
	
	public  SolicitudReemplazo getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		SolicitudReemplazo entity = new SolicitudReemplazo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new SolicitudReemplazo();
				
				if(conMapGenerico) {
					entity.inicializarMapSolicitudReemplazo();
					//entity.setMapSolicitudReemplazo(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapSolicitudReemplazoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapSolicitudReemplazo().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,SolicitudReemplazoDataAccess.ISWITHSCHEMA);         		
					entity=SolicitudReemplazoDataAccess.getEntitySolicitudReemplazo("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setSolicitudReemplazoOriginal( new SolicitudReemplazo());
					////entity.setSolicitudReemplazoOriginal(super.getEntity("",entity.getSolicitudReemplazoOriginal(),resultSet,SolicitudReemplazoDataAccess.ISWITHSCHEMA));         		
					////entity.setSolicitudReemplazoOriginal(this.getEntitySolicitudReemplazo("",entity.getSolicitudReemplazoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseSolicitudReemplazo(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarSolicitudReemplazo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static SolicitudReemplazo getEntitySolicitudReemplazo(String strPrefijo,SolicitudReemplazo entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = SolicitudReemplazo.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = SolicitudReemplazo.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					SolicitudReemplazoDataAccess.setFieldReflectionSolicitudReemplazo(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasSolicitudReemplazo=SolicitudReemplazoConstantesFunciones.getTodosTiposColumnasSolicitudReemplazo();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasSolicitudReemplazo) {
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
							field = SolicitudReemplazo.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = SolicitudReemplazo.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						SolicitudReemplazoDataAccess.setFieldReflectionSolicitudReemplazo(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionSolicitudReemplazo(Field field,String strPrefijo,String sColumn,SolicitudReemplazo entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case SolicitudReemplazoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SolicitudReemplazoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SolicitudReemplazoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SolicitudReemplazoConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SolicitudReemplazoConstantesFunciones.IDEMPLEADOJEFE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SolicitudReemplazoConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SolicitudReemplazoConstantesFunciones.IDEMPLEADOREEMPLAZO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SolicitudReemplazoConstantesFunciones.IDESTRUCTURA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SolicitudReemplazoConstantesFunciones.IDESTADOSOLICITUDNOMI:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SolicitudReemplazoConstantesFunciones.SECUENCIAL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SolicitudReemplazoConstantesFunciones.FECHASOLICITA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case SolicitudReemplazoConstantesFunciones.FECHAEJECUTA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case SolicitudReemplazoConstantesFunciones.NUMEROHORAS:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case SolicitudReemplazoConstantesFunciones.COSTOUNITARIO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case SolicitudReemplazoConstantesFunciones.COSTOTOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case SolicitudReemplazoConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<SolicitudReemplazo>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<SolicitudReemplazo> entities = new  ArrayList<SolicitudReemplazo>();
		SolicitudReemplazo entity = new SolicitudReemplazo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=SolicitudReemplazoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=SolicitudReemplazoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,SolicitudReemplazoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new SolicitudReemplazo();
					entity=super.getEntity("",entity,resultSet,SolicitudReemplazoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntitySolicitudReemplazo("",entity,resultSet);
					
					//entity.setSolicitudReemplazoOriginal( new SolicitudReemplazo());
					//entity.setSolicitudReemplazoOriginal(super.getEntity("",entity.getSolicitudReemplazoOriginal(),resultSet,SolicitudReemplazoDataAccess.ISWITHSCHEMA));         		
					//entity.setSolicitudReemplazoOriginal(this.getEntitySolicitudReemplazo("",entity.getSolicitudReemplazoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseSolicitudReemplazos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarSolicitudReemplazo(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<SolicitudReemplazo>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<SolicitudReemplazo> entities = new  ArrayList<SolicitudReemplazo>();
		SolicitudReemplazo entity = new SolicitudReemplazo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=SolicitudReemplazoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=SolicitudReemplazoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,SolicitudReemplazoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<SolicitudReemplazo> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<SolicitudReemplazo> entities = new  ArrayList<SolicitudReemplazo>();
		SolicitudReemplazo entity = new SolicitudReemplazo();		  
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
	
	public  List<SolicitudReemplazo> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<SolicitudReemplazo> entities = new  ArrayList<SolicitudReemplazo>();
		SolicitudReemplazo entity = new SolicitudReemplazo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new SolicitudReemplazo();
      	    	entity=super.getEntity("",entity,resultSet,SolicitudReemplazoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntitySolicitudReemplazo("",entity,resultSet);
      	    	
				//entity.setSolicitudReemplazoOriginal( new SolicitudReemplazo());
      	    	//entity.setSolicitudReemplazoOriginal(super.getEntity("",entity.getSolicitudReemplazoOriginal(),resultSet,SolicitudReemplazoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setSolicitudReemplazoOriginal(this.getEntitySolicitudReemplazo("",entity.getSolicitudReemplazoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseSolicitudReemplazos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarSolicitudReemplazo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<SolicitudReemplazo> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<SolicitudReemplazo> entities = new  ArrayList<SolicitudReemplazo>();
		SolicitudReemplazo entity = new SolicitudReemplazo();		  
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
	
	public  List<SolicitudReemplazo> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<SolicitudReemplazo> entities = new  ArrayList<SolicitudReemplazo>();
		SolicitudReemplazo entity = new SolicitudReemplazo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new SolicitudReemplazo();
      	    	entity=super.getEntity("",entity,resultSet,SolicitudReemplazoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntitySolicitudReemplazo("",entity,resultSet);
      	    	
				//entity.setSolicitudReemplazoOriginal( new SolicitudReemplazo());
      	    	//entity.setSolicitudReemplazoOriginal(super.getEntity("",entity.getSolicitudReemplazoOriginal(),resultSet,SolicitudReemplazoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setSolicitudReemplazoOriginal(this.getEntitySolicitudReemplazo("",entity.getSolicitudReemplazoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseSolicitudReemplazos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public SolicitudReemplazo getEntitySolicitudReemplazo(String strPrefijo,SolicitudReemplazo entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+SolicitudReemplazoConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+SolicitudReemplazoConstantesFunciones.IDSUCURSAL));
				entity.setid_empleado_jefe(resultSet.getLong(strPrefijo+SolicitudReemplazoConstantesFunciones.IDEMPLEADOJEFE));
				entity.setid_empleado(resultSet.getLong(strPrefijo+SolicitudReemplazoConstantesFunciones.IDEMPLEADO));
				entity.setid_empleado_reemplazo(resultSet.getLong(strPrefijo+SolicitudReemplazoConstantesFunciones.IDEMPLEADOREEMPLAZO));
				entity.setid_estructura(resultSet.getLong(strPrefijo+SolicitudReemplazoConstantesFunciones.IDESTRUCTURA));
				entity.setid_estado_solicitud_nomi(resultSet.getLong(strPrefijo+SolicitudReemplazoConstantesFunciones.IDESTADOSOLICITUDNOMI));
				entity.setsecuencial(resultSet.getString(strPrefijo+SolicitudReemplazoConstantesFunciones.SECUENCIAL));
				entity.setfecha_solicita(new Date(resultSet.getDate(strPrefijo+SolicitudReemplazoConstantesFunciones.FECHASOLICITA).getTime()));
				entity.setfecha_ejecuta(new Date(resultSet.getDate(strPrefijo+SolicitudReemplazoConstantesFunciones.FECHAEJECUTA).getTime()));
				entity.setnumero_horas(resultSet.getInt(strPrefijo+SolicitudReemplazoConstantesFunciones.NUMEROHORAS));
				entity.setcosto_unitario(resultSet.getDouble(strPrefijo+SolicitudReemplazoConstantesFunciones.COSTOUNITARIO));
				entity.setcosto_total(resultSet.getDouble(strPrefijo+SolicitudReemplazoConstantesFunciones.COSTOTOTAL));
				entity.setdescripcion(resultSet.getString(strPrefijo+SolicitudReemplazoConstantesFunciones.DESCRIPCION));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowSolicitudReemplazo(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(SolicitudReemplazo entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=SolicitudReemplazoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=SolicitudReemplazoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=SolicitudReemplazoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=SolicitudReemplazoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(SolicitudReemplazoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,SolicitudReemplazoDataAccess.TABLENAME,SolicitudReemplazoDataAccess.ISWITHSTOREPROCEDURES);
			
			SolicitudReemplazoDataAccess.setSolicitudReemplazoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,SolicitudReemplazo relsolicitudreemplazo)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relsolicitudreemplazo.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,SolicitudReemplazo relsolicitudreemplazo)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relsolicitudreemplazo.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Empleado getEmpleadoJefe(Connexion connexion,SolicitudReemplazo relsolicitudreemplazo)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relsolicitudreemplazo.getid_empleado_jefe());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public Empleado getEmpleado(Connexion connexion,SolicitudReemplazo relsolicitudreemplazo)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relsolicitudreemplazo.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public Empleado getEmpleadoReemplazo(Connexion connexion,SolicitudReemplazo relsolicitudreemplazo)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relsolicitudreemplazo.getid_empleado_reemplazo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public Estructura getEstructura(Connexion connexion,SolicitudReemplazo relsolicitudreemplazo)throws SQLException,Exception {

		Estructura estructura= new Estructura();

		try {
			EstructuraDataAccess estructuraDataAccess=new EstructuraDataAccess();

			estructuraDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estructuraDataAccess.setConnexionType(this.connexionType);
			estructuraDataAccess.setParameterDbType(this.parameterDbType);

			estructura=estructuraDataAccess.getEntity(connexion,relsolicitudreemplazo.getid_estructura());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estructura;

	}

	public EstadoSolicitudNomi getEstadoSolicitudNomi(Connexion connexion,SolicitudReemplazo relsolicitudreemplazo)throws SQLException,Exception {

		EstadoSolicitudNomi estadosolicitudnomi= new EstadoSolicitudNomi();

		try {
			EstadoSolicitudNomiDataAccess estadosolicitudnomiDataAccess=new EstadoSolicitudNomiDataAccess();

			estadosolicitudnomiDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadosolicitudnomiDataAccess.setConnexionType(this.connexionType);
			estadosolicitudnomiDataAccess.setParameterDbType(this.parameterDbType);

			estadosolicitudnomi=estadosolicitudnomiDataAccess.getEntity(connexion,relsolicitudreemplazo.getid_estado_solicitud_nomi());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadosolicitudnomi;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,SolicitudReemplazo solicitudreemplazo) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!solicitudreemplazo.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(solicitudreemplazo.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(solicitudreemplazo.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado_jefe=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado_jefe.setValue(solicitudreemplazo.getid_empleado_jefe());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado_jefe);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(solicitudreemplazo.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado_reemplazo=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado_reemplazo.setValue(solicitudreemplazo.getid_empleado_reemplazo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado_reemplazo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estructura=new ParameterValue<Long>();
					parameterMaintenanceValueid_estructura.setValue(solicitudreemplazo.getid_estructura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estructura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_solicitud_nomi=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_solicitud_nomi.setValue(solicitudreemplazo.getid_estado_solicitud_nomi());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_solicitud_nomi);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuesecuencial=new ParameterValue<String>();
					parameterMaintenanceValuesecuencial.setValue(solicitudreemplazo.getsecuencial());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesecuencial);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_solicita=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_solicita.setValue(solicitudreemplazo.getfecha_solicita());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_solicita);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_ejecuta=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_ejecuta.setValue(solicitudreemplazo.getfecha_ejecuta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_ejecuta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuenumero_horas=new ParameterValue<Integer>();
					parameterMaintenanceValuenumero_horas.setValue(solicitudreemplazo.getnumero_horas());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_horas);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecosto_unitario=new ParameterValue<Double>();
					parameterMaintenanceValuecosto_unitario.setValue(solicitudreemplazo.getcosto_unitario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecosto_unitario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecosto_total=new ParameterValue<Double>();
					parameterMaintenanceValuecosto_total.setValue(solicitudreemplazo.getcosto_total());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecosto_total);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(solicitudreemplazo.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!solicitudreemplazo.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(solicitudreemplazo.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(solicitudreemplazo.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(solicitudreemplazo.getId());
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
	
	public void setIsNewIsChangedFalseSolicitudReemplazo(SolicitudReemplazo solicitudreemplazo)throws Exception  {		
		solicitudreemplazo.setIsNew(false);
		solicitudreemplazo.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseSolicitudReemplazos(List<SolicitudReemplazo> solicitudreemplazos)throws Exception  {				
		for(SolicitudReemplazo solicitudreemplazo:solicitudreemplazos) {
			solicitudreemplazo.setIsNew(false);
			solicitudreemplazo.setIsChanged(false);
		}
	}
	
	public void generarExportarSolicitudReemplazo(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
