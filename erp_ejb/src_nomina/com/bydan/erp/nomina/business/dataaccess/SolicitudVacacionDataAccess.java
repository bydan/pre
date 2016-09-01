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
import com.bydan.erp.nomina.util.*;//SolicitudVacacionConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class SolicitudVacacionDataAccess extends  SolicitudVacacionDataAccessAdditional{ //SolicitudVacacionDataAccessAdditional,DataAccessHelper<SolicitudVacacion>
	//static Logger logger = Logger.getLogger(SolicitudVacacionDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="solicitud_vacacion";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+SolicitudVacacionConstantesFunciones.SCHEMA+"."+SolicitudVacacionConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_empleado_jefe,id_empleado,id_estructura,id_estado_solicitud_nomi,id_formato,secuencial,fecha_solicita,fecha_ejecuta,numero_horas,costo_unitario,costo_total,descripcion)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+SolicitudVacacionConstantesFunciones.SCHEMA+"."+SolicitudVacacionConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_empleado_jefe=?,id_empleado=?,id_estructura=?,id_estado_solicitud_nomi=?,id_formato=?,secuencial=?,fecha_solicita=?,fecha_ejecuta=?,numero_horas=?,costo_unitario=?,costo_total=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+SolicitudVacacionConstantesFunciones.SCHEMA+"."+SolicitudVacacionConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select solicitudvacacion from "+SolicitudVacacionConstantesFunciones.SPERSISTENCENAME+" solicitudvacacion";
	public static String QUERYSELECTNATIVE="select "+SolicitudVacacionConstantesFunciones.SCHEMA+"."+SolicitudVacacionConstantesFunciones.TABLENAME+".id,"+SolicitudVacacionConstantesFunciones.SCHEMA+"."+SolicitudVacacionConstantesFunciones.TABLENAME+".version_row,"+SolicitudVacacionConstantesFunciones.SCHEMA+"."+SolicitudVacacionConstantesFunciones.TABLENAME+".id_empresa,"+SolicitudVacacionConstantesFunciones.SCHEMA+"."+SolicitudVacacionConstantesFunciones.TABLENAME+".id_sucursal,"+SolicitudVacacionConstantesFunciones.SCHEMA+"."+SolicitudVacacionConstantesFunciones.TABLENAME+".id_empleado_jefe,"+SolicitudVacacionConstantesFunciones.SCHEMA+"."+SolicitudVacacionConstantesFunciones.TABLENAME+".id_empleado,"+SolicitudVacacionConstantesFunciones.SCHEMA+"."+SolicitudVacacionConstantesFunciones.TABLENAME+".id_estructura,"+SolicitudVacacionConstantesFunciones.SCHEMA+"."+SolicitudVacacionConstantesFunciones.TABLENAME+".id_estado_solicitud_nomi,"+SolicitudVacacionConstantesFunciones.SCHEMA+"."+SolicitudVacacionConstantesFunciones.TABLENAME+".id_formato,"+SolicitudVacacionConstantesFunciones.SCHEMA+"."+SolicitudVacacionConstantesFunciones.TABLENAME+".secuencial,"+SolicitudVacacionConstantesFunciones.SCHEMA+"."+SolicitudVacacionConstantesFunciones.TABLENAME+".fecha_solicita,"+SolicitudVacacionConstantesFunciones.SCHEMA+"."+SolicitudVacacionConstantesFunciones.TABLENAME+".fecha_ejecuta,"+SolicitudVacacionConstantesFunciones.SCHEMA+"."+SolicitudVacacionConstantesFunciones.TABLENAME+".numero_horas,"+SolicitudVacacionConstantesFunciones.SCHEMA+"."+SolicitudVacacionConstantesFunciones.TABLENAME+".costo_unitario,"+SolicitudVacacionConstantesFunciones.SCHEMA+"."+SolicitudVacacionConstantesFunciones.TABLENAME+".costo_total,"+SolicitudVacacionConstantesFunciones.SCHEMA+"."+SolicitudVacacionConstantesFunciones.TABLENAME+".descripcion from "+SolicitudVacacionConstantesFunciones.SCHEMA+"."+SolicitudVacacionConstantesFunciones.TABLENAME;//+" as "+SolicitudVacacionConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+SolicitudVacacionConstantesFunciones.SCHEMA+"."+SolicitudVacacionConstantesFunciones.TABLENAME+".id,"+SolicitudVacacionConstantesFunciones.SCHEMA+"."+SolicitudVacacionConstantesFunciones.TABLENAME+".version_row from "+SolicitudVacacionConstantesFunciones.SCHEMA+"."+SolicitudVacacionConstantesFunciones.TABLENAME;//+" as "+SolicitudVacacionConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+SolicitudVacacionConstantesFunciones.SCHEMA+"."+SolicitudVacacionConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_empleado_jefe=?,id_empleado=?,id_estructura=?,id_estado_solicitud_nomi=?,id_formato=?,secuencial=?,fecha_solicita=?,fecha_ejecuta=?,numero_horas=?,costo_unitario=?,costo_total=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_SOLICITUDVACACION_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_SOLICITUDVACACION_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_SOLICITUDVACACION_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_SOLICITUDVACACION_SELECT(?,?)";
	
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
	
	
	protected SolicitudVacacionDataAccessAdditional solicitudvacacionDataAccessAdditional=null;
	
	public SolicitudVacacionDataAccessAdditional getSolicitudVacacionDataAccessAdditional() {
		return this.solicitudvacacionDataAccessAdditional;
	}
	
	public void setSolicitudVacacionDataAccessAdditional(SolicitudVacacionDataAccessAdditional solicitudvacacionDataAccessAdditional) {
		try {
			this.solicitudvacacionDataAccessAdditional=solicitudvacacionDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public SolicitudVacacionDataAccess() {
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
		SolicitudVacacionDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		SolicitudVacacionDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		SolicitudVacacionDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setSolicitudVacacionOriginal(SolicitudVacacion solicitudvacacion)throws Exception  {
		solicitudvacacion.setSolicitudVacacionOriginal((SolicitudVacacion)solicitudvacacion.clone());		
	}
	
	public void setSolicitudVacacionsOriginal(List<SolicitudVacacion> solicitudvacacions)throws Exception  {
		
		for(SolicitudVacacion solicitudvacacion:solicitudvacacions){
			solicitudvacacion.setSolicitudVacacionOriginal((SolicitudVacacion)solicitudvacacion.clone());
		}
	}
	
	public static void setSolicitudVacacionOriginalStatic(SolicitudVacacion solicitudvacacion)throws Exception  {
		solicitudvacacion.setSolicitudVacacionOriginal((SolicitudVacacion)solicitudvacacion.clone());		
	}
	
	public static void setSolicitudVacacionsOriginalStatic(List<SolicitudVacacion> solicitudvacacions)throws Exception  {
		
		for(SolicitudVacacion solicitudvacacion:solicitudvacacions){
			solicitudvacacion.setSolicitudVacacionOriginal((SolicitudVacacion)solicitudvacacion.clone());
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
	
	public  SolicitudVacacion getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		SolicitudVacacion entity = new SolicitudVacacion();		
		
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
	
	public  SolicitudVacacion getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		SolicitudVacacion entity = new SolicitudVacacion();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=SolicitudVacacionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=SolicitudVacacionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.SolicitudVacacion.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setSolicitudVacacionOriginal(new SolicitudVacacion());
      	    	entity=super.getEntity("",entity,resultSet,SolicitudVacacionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntitySolicitudVacacion("",entity,resultSet); 
				
				//entity.setSolicitudVacacionOriginal(super.getEntity("",entity.getSolicitudVacacionOriginal(),resultSet,SolicitudVacacionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setSolicitudVacacionOriginal(this.getEntitySolicitudVacacion("",entity.getSolicitudVacacionOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseSolicitudVacacion(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  SolicitudVacacion getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		SolicitudVacacion entity = new SolicitudVacacion();
				
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
	
	public  SolicitudVacacion getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		SolicitudVacacion entity = new SolicitudVacacion();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=SolicitudVacacionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=SolicitudVacacionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,SolicitudVacacionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.SolicitudVacacion.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setSolicitudVacacionOriginal(new SolicitudVacacion());
      	    	entity=super.getEntity("",entity,resultSet,SolicitudVacacionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntitySolicitudVacacion("",entity,resultSet);    
				
				//entity.setSolicitudVacacionOriginal(super.getEntity("",entity.getSolicitudVacacionOriginal(),resultSet,SolicitudVacacionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setSolicitudVacacionOriginal(this.getEntitySolicitudVacacion("",entity.getSolicitudVacacionOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseSolicitudVacacion(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //SolicitudVacacion
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		SolicitudVacacion entity = new SolicitudVacacion();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=SolicitudVacacionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=SolicitudVacacionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,SolicitudVacacionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.SolicitudVacacion.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseSolicitudVacacion(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<SolicitudVacacion> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<SolicitudVacacion> entities = new  ArrayList<SolicitudVacacion>();
		SolicitudVacacion entity = new SolicitudVacacion();		  
		
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
	
	public  List<SolicitudVacacion> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<SolicitudVacacion> entities = new  ArrayList<SolicitudVacacion>();
		SolicitudVacacion entity = new SolicitudVacacion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=SolicitudVacacionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=SolicitudVacacionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,SolicitudVacacionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new SolicitudVacacion();
      	    	entity=super.getEntity("",entity,resultSet,SolicitudVacacionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntitySolicitudVacacion("",entity,resultSet);
      	    	
				//entity.setSolicitudVacacionOriginal( new SolicitudVacacion());
      	    	//entity.setSolicitudVacacionOriginal(super.getEntity("",entity.getSolicitudVacacionOriginal(),resultSet,SolicitudVacacionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setSolicitudVacacionOriginal(this.getEntitySolicitudVacacion("",entity.getSolicitudVacacionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseSolicitudVacacions(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarSolicitudVacacion(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<SolicitudVacacion> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<SolicitudVacacion> entities = new  ArrayList<SolicitudVacacion>();
		SolicitudVacacion entity = new SolicitudVacacion();		  
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
	
	public  List<SolicitudVacacion> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<SolicitudVacacion> entities = new  ArrayList<SolicitudVacacion>();
		SolicitudVacacion entity = new SolicitudVacacion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new SolicitudVacacion();
				
				if(conMapGenerico) {
					entity.inicializarMapSolicitudVacacion();
					//entity.setMapSolicitudVacacion(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapSolicitudVacacionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapSolicitudVacacion().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,SolicitudVacacionDataAccess.ISWITHSCHEMA);         		
					entity=SolicitudVacacionDataAccess.getEntitySolicitudVacacion("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setSolicitudVacacionOriginal( new SolicitudVacacion());
					////entity.setSolicitudVacacionOriginal(super.getEntity("",entity.getSolicitudVacacionOriginal(),resultSet,SolicitudVacacionDataAccess.ISWITHSCHEMA));         		
					////entity.setSolicitudVacacionOriginal(this.getEntitySolicitudVacacion("",entity.getSolicitudVacacionOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseSolicitudVacacions(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarSolicitudVacacion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public SolicitudVacacion getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		SolicitudVacacion entity = new SolicitudVacacion();		  
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
	
	public  SolicitudVacacion getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		SolicitudVacacion entity = new SolicitudVacacion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new SolicitudVacacion();
				
				if(conMapGenerico) {
					entity.inicializarMapSolicitudVacacion();
					//entity.setMapSolicitudVacacion(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapSolicitudVacacionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapSolicitudVacacion().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,SolicitudVacacionDataAccess.ISWITHSCHEMA);         		
					entity=SolicitudVacacionDataAccess.getEntitySolicitudVacacion("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setSolicitudVacacionOriginal( new SolicitudVacacion());
					////entity.setSolicitudVacacionOriginal(super.getEntity("",entity.getSolicitudVacacionOriginal(),resultSet,SolicitudVacacionDataAccess.ISWITHSCHEMA));         		
					////entity.setSolicitudVacacionOriginal(this.getEntitySolicitudVacacion("",entity.getSolicitudVacacionOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseSolicitudVacacion(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarSolicitudVacacion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static SolicitudVacacion getEntitySolicitudVacacion(String strPrefijo,SolicitudVacacion entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = SolicitudVacacion.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = SolicitudVacacion.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					SolicitudVacacionDataAccess.setFieldReflectionSolicitudVacacion(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasSolicitudVacacion=SolicitudVacacionConstantesFunciones.getTodosTiposColumnasSolicitudVacacion();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasSolicitudVacacion) {
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
							field = SolicitudVacacion.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = SolicitudVacacion.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						SolicitudVacacionDataAccess.setFieldReflectionSolicitudVacacion(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionSolicitudVacacion(Field field,String strPrefijo,String sColumn,SolicitudVacacion entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case SolicitudVacacionConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SolicitudVacacionConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SolicitudVacacionConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SolicitudVacacionConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SolicitudVacacionConstantesFunciones.IDEMPLEADOJEFE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SolicitudVacacionConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SolicitudVacacionConstantesFunciones.IDESTRUCTURA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SolicitudVacacionConstantesFunciones.IDESTADOSOLICITUDNOMI:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SolicitudVacacionConstantesFunciones.IDFORMATO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SolicitudVacacionConstantesFunciones.SECUENCIAL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SolicitudVacacionConstantesFunciones.FECHASOLICITA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case SolicitudVacacionConstantesFunciones.FECHAEJECUTA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case SolicitudVacacionConstantesFunciones.NUMEROHORAS:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case SolicitudVacacionConstantesFunciones.COSTOUNITARIO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case SolicitudVacacionConstantesFunciones.COSTOTOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case SolicitudVacacionConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<SolicitudVacacion>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<SolicitudVacacion> entities = new  ArrayList<SolicitudVacacion>();
		SolicitudVacacion entity = new SolicitudVacacion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=SolicitudVacacionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=SolicitudVacacionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,SolicitudVacacionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new SolicitudVacacion();
					entity=super.getEntity("",entity,resultSet,SolicitudVacacionDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntitySolicitudVacacion("",entity,resultSet);
					
					//entity.setSolicitudVacacionOriginal( new SolicitudVacacion());
					//entity.setSolicitudVacacionOriginal(super.getEntity("",entity.getSolicitudVacacionOriginal(),resultSet,SolicitudVacacionDataAccess.ISWITHSCHEMA));         		
					//entity.setSolicitudVacacionOriginal(this.getEntitySolicitudVacacion("",entity.getSolicitudVacacionOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseSolicitudVacacions(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarSolicitudVacacion(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<SolicitudVacacion>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<SolicitudVacacion> entities = new  ArrayList<SolicitudVacacion>();
		SolicitudVacacion entity = new SolicitudVacacion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=SolicitudVacacionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=SolicitudVacacionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,SolicitudVacacionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<SolicitudVacacion> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<SolicitudVacacion> entities = new  ArrayList<SolicitudVacacion>();
		SolicitudVacacion entity = new SolicitudVacacion();		  
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
	
	public  List<SolicitudVacacion> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<SolicitudVacacion> entities = new  ArrayList<SolicitudVacacion>();
		SolicitudVacacion entity = new SolicitudVacacion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new SolicitudVacacion();
      	    	entity=super.getEntity("",entity,resultSet,SolicitudVacacionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntitySolicitudVacacion("",entity,resultSet);
      	    	
				//entity.setSolicitudVacacionOriginal( new SolicitudVacacion());
      	    	//entity.setSolicitudVacacionOriginal(super.getEntity("",entity.getSolicitudVacacionOriginal(),resultSet,SolicitudVacacionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setSolicitudVacacionOriginal(this.getEntitySolicitudVacacion("",entity.getSolicitudVacacionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseSolicitudVacacions(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarSolicitudVacacion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<SolicitudVacacion> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<SolicitudVacacion> entities = new  ArrayList<SolicitudVacacion>();
		SolicitudVacacion entity = new SolicitudVacacion();		  
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
	
	public  List<SolicitudVacacion> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<SolicitudVacacion> entities = new  ArrayList<SolicitudVacacion>();
		SolicitudVacacion entity = new SolicitudVacacion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new SolicitudVacacion();
      	    	entity=super.getEntity("",entity,resultSet,SolicitudVacacionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntitySolicitudVacacion("",entity,resultSet);
      	    	
				//entity.setSolicitudVacacionOriginal( new SolicitudVacacion());
      	    	//entity.setSolicitudVacacionOriginal(super.getEntity("",entity.getSolicitudVacacionOriginal(),resultSet,SolicitudVacacionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setSolicitudVacacionOriginal(this.getEntitySolicitudVacacion("",entity.getSolicitudVacacionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseSolicitudVacacions(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public SolicitudVacacion getEntitySolicitudVacacion(String strPrefijo,SolicitudVacacion entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+SolicitudVacacionConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+SolicitudVacacionConstantesFunciones.IDSUCURSAL));
				entity.setid_empleado_jefe(resultSet.getLong(strPrefijo+SolicitudVacacionConstantesFunciones.IDEMPLEADOJEFE));
				entity.setid_empleado(resultSet.getLong(strPrefijo+SolicitudVacacionConstantesFunciones.IDEMPLEADO));
				entity.setid_estructura(resultSet.getLong(strPrefijo+SolicitudVacacionConstantesFunciones.IDESTRUCTURA));
				entity.setid_estado_solicitud_nomi(resultSet.getLong(strPrefijo+SolicitudVacacionConstantesFunciones.IDESTADOSOLICITUDNOMI));
				entity.setid_formato(resultSet.getLong(strPrefijo+SolicitudVacacionConstantesFunciones.IDFORMATO));
				entity.setsecuencial(resultSet.getString(strPrefijo+SolicitudVacacionConstantesFunciones.SECUENCIAL));
				entity.setfecha_solicita(new Date(resultSet.getDate(strPrefijo+SolicitudVacacionConstantesFunciones.FECHASOLICITA).getTime()));
				entity.setfecha_ejecuta(new Date(resultSet.getDate(strPrefijo+SolicitudVacacionConstantesFunciones.FECHAEJECUTA).getTime()));
				entity.setnumero_horas(resultSet.getInt(strPrefijo+SolicitudVacacionConstantesFunciones.NUMEROHORAS));
				entity.setcosto_unitario(resultSet.getDouble(strPrefijo+SolicitudVacacionConstantesFunciones.COSTOUNITARIO));
				entity.setcosto_total(resultSet.getDouble(strPrefijo+SolicitudVacacionConstantesFunciones.COSTOTOTAL));
				entity.setdescripcion(resultSet.getString(strPrefijo+SolicitudVacacionConstantesFunciones.DESCRIPCION));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowSolicitudVacacion(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(SolicitudVacacion entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=SolicitudVacacionDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=SolicitudVacacionDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=SolicitudVacacionDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=SolicitudVacacionDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(SolicitudVacacionConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,SolicitudVacacionDataAccess.TABLENAME,SolicitudVacacionDataAccess.ISWITHSTOREPROCEDURES);
			
			SolicitudVacacionDataAccess.setSolicitudVacacionOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,SolicitudVacacion relsolicitudvacacion)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relsolicitudvacacion.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,SolicitudVacacion relsolicitudvacacion)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relsolicitudvacacion.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Empleado getEmpleadoJefe(Connexion connexion,SolicitudVacacion relsolicitudvacacion)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relsolicitudvacacion.getid_empleado_jefe());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public Empleado getEmpleado(Connexion connexion,SolicitudVacacion relsolicitudvacacion)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relsolicitudvacacion.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public Estructura getEstructura(Connexion connexion,SolicitudVacacion relsolicitudvacacion)throws SQLException,Exception {

		Estructura estructura= new Estructura();

		try {
			EstructuraDataAccess estructuraDataAccess=new EstructuraDataAccess();

			estructuraDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estructuraDataAccess.setConnexionType(this.connexionType);
			estructuraDataAccess.setParameterDbType(this.parameterDbType);

			estructura=estructuraDataAccess.getEntity(connexion,relsolicitudvacacion.getid_estructura());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estructura;

	}

	public EstadoSolicitudNomi getEstadoSolicitudNomi(Connexion connexion,SolicitudVacacion relsolicitudvacacion)throws SQLException,Exception {

		EstadoSolicitudNomi estadosolicitudnomi= new EstadoSolicitudNomi();

		try {
			EstadoSolicitudNomiDataAccess estadosolicitudnomiDataAccess=new EstadoSolicitudNomiDataAccess();

			estadosolicitudnomiDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadosolicitudnomiDataAccess.setConnexionType(this.connexionType);
			estadosolicitudnomiDataAccess.setParameterDbType(this.parameterDbType);

			estadosolicitudnomi=estadosolicitudnomiDataAccess.getEntity(connexion,relsolicitudvacacion.getid_estado_solicitud_nomi());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadosolicitudnomi;

	}

	public Formato getFormato(Connexion connexion,SolicitudVacacion relsolicitudvacacion)throws SQLException,Exception {

		Formato formato= new Formato();

		try {
			FormatoDataAccess formatoDataAccess=new FormatoDataAccess();

			formatoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			formatoDataAccess.setConnexionType(this.connexionType);
			formatoDataAccess.setParameterDbType(this.parameterDbType);

			formato=formatoDataAccess.getEntity(connexion,relsolicitudvacacion.getid_formato());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formato;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,SolicitudVacacion solicitudvacacion) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!solicitudvacacion.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(solicitudvacacion.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(solicitudvacacion.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado_jefe=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado_jefe.setValue(solicitudvacacion.getid_empleado_jefe());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado_jefe);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(solicitudvacacion.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estructura=new ParameterValue<Long>();
					parameterMaintenanceValueid_estructura.setValue(solicitudvacacion.getid_estructura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estructura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_solicitud_nomi=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_solicitud_nomi.setValue(solicitudvacacion.getid_estado_solicitud_nomi());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_solicitud_nomi);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_formato=new ParameterValue<Long>();
					parameterMaintenanceValueid_formato.setValue(solicitudvacacion.getid_formato());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_formato);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuesecuencial=new ParameterValue<String>();
					parameterMaintenanceValuesecuencial.setValue(solicitudvacacion.getsecuencial());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesecuencial);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_solicita=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_solicita.setValue(solicitudvacacion.getfecha_solicita());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_solicita);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_ejecuta=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_ejecuta.setValue(solicitudvacacion.getfecha_ejecuta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_ejecuta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuenumero_horas=new ParameterValue<Integer>();
					parameterMaintenanceValuenumero_horas.setValue(solicitudvacacion.getnumero_horas());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_horas);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecosto_unitario=new ParameterValue<Double>();
					parameterMaintenanceValuecosto_unitario.setValue(solicitudvacacion.getcosto_unitario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecosto_unitario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecosto_total=new ParameterValue<Double>();
					parameterMaintenanceValuecosto_total.setValue(solicitudvacacion.getcosto_total());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecosto_total);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(solicitudvacacion.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!solicitudvacacion.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(solicitudvacacion.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(solicitudvacacion.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(solicitudvacacion.getId());
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
	
	public void setIsNewIsChangedFalseSolicitudVacacion(SolicitudVacacion solicitudvacacion)throws Exception  {		
		solicitudvacacion.setIsNew(false);
		solicitudvacacion.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseSolicitudVacacions(List<SolicitudVacacion> solicitudvacacions)throws Exception  {				
		for(SolicitudVacacion solicitudvacacion:solicitudvacacions) {
			solicitudvacacion.setIsNew(false);
			solicitudvacacion.setIsChanged(false);
		}
	}
	
	public void generarExportarSolicitudVacacion(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
