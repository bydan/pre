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
import com.bydan.erp.nomina.util.*;//SolicitudHoraExtraConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class SolicitudHoraExtraDataAccess extends  SolicitudHoraExtraDataAccessAdditional{ //SolicitudHoraExtraDataAccessAdditional,DataAccessHelper<SolicitudHoraExtra>
	//static Logger logger = Logger.getLogger(SolicitudHoraExtraDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="solicitud_hora_extra";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+SolicitudHoraExtraConstantesFunciones.SCHEMA+"."+SolicitudHoraExtraConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_empleado,id_estructura,id_empleado_jefe,id_estado_solicitud_nomi,id_empleado_reemplazo,secuencial,fecha_solicita,fecha_ejecuta,numero_horas,costo_unitario,costo_total,descripcion)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+SolicitudHoraExtraConstantesFunciones.SCHEMA+"."+SolicitudHoraExtraConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_empleado=?,id_estructura=?,id_empleado_jefe=?,id_estado_solicitud_nomi=?,id_empleado_reemplazo=?,secuencial=?,fecha_solicita=?,fecha_ejecuta=?,numero_horas=?,costo_unitario=?,costo_total=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+SolicitudHoraExtraConstantesFunciones.SCHEMA+"."+SolicitudHoraExtraConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select solicitudhoraextra from "+SolicitudHoraExtraConstantesFunciones.SPERSISTENCENAME+" solicitudhoraextra";
	public static String QUERYSELECTNATIVE="select "+SolicitudHoraExtraConstantesFunciones.SCHEMA+"."+SolicitudHoraExtraConstantesFunciones.TABLENAME+".id,"+SolicitudHoraExtraConstantesFunciones.SCHEMA+"."+SolicitudHoraExtraConstantesFunciones.TABLENAME+".version_row,"+SolicitudHoraExtraConstantesFunciones.SCHEMA+"."+SolicitudHoraExtraConstantesFunciones.TABLENAME+".id_empresa,"+SolicitudHoraExtraConstantesFunciones.SCHEMA+"."+SolicitudHoraExtraConstantesFunciones.TABLENAME+".id_sucursal,"+SolicitudHoraExtraConstantesFunciones.SCHEMA+"."+SolicitudHoraExtraConstantesFunciones.TABLENAME+".id_empleado,"+SolicitudHoraExtraConstantesFunciones.SCHEMA+"."+SolicitudHoraExtraConstantesFunciones.TABLENAME+".id_estructura,"+SolicitudHoraExtraConstantesFunciones.SCHEMA+"."+SolicitudHoraExtraConstantesFunciones.TABLENAME+".id_empleado_jefe,"+SolicitudHoraExtraConstantesFunciones.SCHEMA+"."+SolicitudHoraExtraConstantesFunciones.TABLENAME+".id_estado_solicitud_nomi,"+SolicitudHoraExtraConstantesFunciones.SCHEMA+"."+SolicitudHoraExtraConstantesFunciones.TABLENAME+".id_empleado_reemplazo,"+SolicitudHoraExtraConstantesFunciones.SCHEMA+"."+SolicitudHoraExtraConstantesFunciones.TABLENAME+".secuencial,"+SolicitudHoraExtraConstantesFunciones.SCHEMA+"."+SolicitudHoraExtraConstantesFunciones.TABLENAME+".fecha_solicita,"+SolicitudHoraExtraConstantesFunciones.SCHEMA+"."+SolicitudHoraExtraConstantesFunciones.TABLENAME+".fecha_ejecuta,"+SolicitudHoraExtraConstantesFunciones.SCHEMA+"."+SolicitudHoraExtraConstantesFunciones.TABLENAME+".numero_horas,"+SolicitudHoraExtraConstantesFunciones.SCHEMA+"."+SolicitudHoraExtraConstantesFunciones.TABLENAME+".costo_unitario,"+SolicitudHoraExtraConstantesFunciones.SCHEMA+"."+SolicitudHoraExtraConstantesFunciones.TABLENAME+".costo_total,"+SolicitudHoraExtraConstantesFunciones.SCHEMA+"."+SolicitudHoraExtraConstantesFunciones.TABLENAME+".descripcion from "+SolicitudHoraExtraConstantesFunciones.SCHEMA+"."+SolicitudHoraExtraConstantesFunciones.TABLENAME;//+" as "+SolicitudHoraExtraConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+SolicitudHoraExtraConstantesFunciones.SCHEMA+"."+SolicitudHoraExtraConstantesFunciones.TABLENAME+".id,"+SolicitudHoraExtraConstantesFunciones.SCHEMA+"."+SolicitudHoraExtraConstantesFunciones.TABLENAME+".version_row from "+SolicitudHoraExtraConstantesFunciones.SCHEMA+"."+SolicitudHoraExtraConstantesFunciones.TABLENAME;//+" as "+SolicitudHoraExtraConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+SolicitudHoraExtraConstantesFunciones.SCHEMA+"."+SolicitudHoraExtraConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_empleado=?,id_estructura=?,id_empleado_jefe=?,id_estado_solicitud_nomi=?,id_empleado_reemplazo=?,secuencial=?,fecha_solicita=?,fecha_ejecuta=?,numero_horas=?,costo_unitario=?,costo_total=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_SOLICITUDHORAEXTRA_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_SOLICITUDHORAEXTRA_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_SOLICITUDHORAEXTRA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_SOLICITUDHORAEXTRA_SELECT(?,?)";
	
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
	
	
	protected SolicitudHoraExtraDataAccessAdditional solicitudhoraextraDataAccessAdditional=null;
	
	public SolicitudHoraExtraDataAccessAdditional getSolicitudHoraExtraDataAccessAdditional() {
		return this.solicitudhoraextraDataAccessAdditional;
	}
	
	public void setSolicitudHoraExtraDataAccessAdditional(SolicitudHoraExtraDataAccessAdditional solicitudhoraextraDataAccessAdditional) {
		try {
			this.solicitudhoraextraDataAccessAdditional=solicitudhoraextraDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public SolicitudHoraExtraDataAccess() {
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
		SolicitudHoraExtraDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		SolicitudHoraExtraDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		SolicitudHoraExtraDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setSolicitudHoraExtraOriginal(SolicitudHoraExtra solicitudhoraextra)throws Exception  {
		solicitudhoraextra.setSolicitudHoraExtraOriginal((SolicitudHoraExtra)solicitudhoraextra.clone());		
	}
	
	public void setSolicitudHoraExtrasOriginal(List<SolicitudHoraExtra> solicitudhoraextras)throws Exception  {
		
		for(SolicitudHoraExtra solicitudhoraextra:solicitudhoraextras){
			solicitudhoraextra.setSolicitudHoraExtraOriginal((SolicitudHoraExtra)solicitudhoraextra.clone());
		}
	}
	
	public static void setSolicitudHoraExtraOriginalStatic(SolicitudHoraExtra solicitudhoraextra)throws Exception  {
		solicitudhoraextra.setSolicitudHoraExtraOriginal((SolicitudHoraExtra)solicitudhoraextra.clone());		
	}
	
	public static void setSolicitudHoraExtrasOriginalStatic(List<SolicitudHoraExtra> solicitudhoraextras)throws Exception  {
		
		for(SolicitudHoraExtra solicitudhoraextra:solicitudhoraextras){
			solicitudhoraextra.setSolicitudHoraExtraOriginal((SolicitudHoraExtra)solicitudhoraextra.clone());
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
	
	public  SolicitudHoraExtra getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		SolicitudHoraExtra entity = new SolicitudHoraExtra();		
		
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
	
	public  SolicitudHoraExtra getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		SolicitudHoraExtra entity = new SolicitudHoraExtra();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=SolicitudHoraExtraDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=SolicitudHoraExtraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.SolicitudHoraExtra.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setSolicitudHoraExtraOriginal(new SolicitudHoraExtra());
      	    	entity=super.getEntity("",entity,resultSet,SolicitudHoraExtraDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntitySolicitudHoraExtra("",entity,resultSet); 
				
				//entity.setSolicitudHoraExtraOriginal(super.getEntity("",entity.getSolicitudHoraExtraOriginal(),resultSet,SolicitudHoraExtraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setSolicitudHoraExtraOriginal(this.getEntitySolicitudHoraExtra("",entity.getSolicitudHoraExtraOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseSolicitudHoraExtra(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  SolicitudHoraExtra getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		SolicitudHoraExtra entity = new SolicitudHoraExtra();
				
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
	
	public  SolicitudHoraExtra getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		SolicitudHoraExtra entity = new SolicitudHoraExtra();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=SolicitudHoraExtraDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=SolicitudHoraExtraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,SolicitudHoraExtraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.SolicitudHoraExtra.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setSolicitudHoraExtraOriginal(new SolicitudHoraExtra());
      	    	entity=super.getEntity("",entity,resultSet,SolicitudHoraExtraDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntitySolicitudHoraExtra("",entity,resultSet);    
				
				//entity.setSolicitudHoraExtraOriginal(super.getEntity("",entity.getSolicitudHoraExtraOriginal(),resultSet,SolicitudHoraExtraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setSolicitudHoraExtraOriginal(this.getEntitySolicitudHoraExtra("",entity.getSolicitudHoraExtraOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseSolicitudHoraExtra(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //SolicitudHoraExtra
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		SolicitudHoraExtra entity = new SolicitudHoraExtra();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=SolicitudHoraExtraDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=SolicitudHoraExtraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,SolicitudHoraExtraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.SolicitudHoraExtra.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseSolicitudHoraExtra(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<SolicitudHoraExtra> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<SolicitudHoraExtra> entities = new  ArrayList<SolicitudHoraExtra>();
		SolicitudHoraExtra entity = new SolicitudHoraExtra();		  
		
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
	
	public  List<SolicitudHoraExtra> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<SolicitudHoraExtra> entities = new  ArrayList<SolicitudHoraExtra>();
		SolicitudHoraExtra entity = new SolicitudHoraExtra();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=SolicitudHoraExtraDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=SolicitudHoraExtraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,SolicitudHoraExtraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new SolicitudHoraExtra();
      	    	entity=super.getEntity("",entity,resultSet,SolicitudHoraExtraDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntitySolicitudHoraExtra("",entity,resultSet);
      	    	
				//entity.setSolicitudHoraExtraOriginal( new SolicitudHoraExtra());
      	    	//entity.setSolicitudHoraExtraOriginal(super.getEntity("",entity.getSolicitudHoraExtraOriginal(),resultSet,SolicitudHoraExtraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setSolicitudHoraExtraOriginal(this.getEntitySolicitudHoraExtra("",entity.getSolicitudHoraExtraOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseSolicitudHoraExtras(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarSolicitudHoraExtra(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<SolicitudHoraExtra> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<SolicitudHoraExtra> entities = new  ArrayList<SolicitudHoraExtra>();
		SolicitudHoraExtra entity = new SolicitudHoraExtra();		  
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
	
	public  List<SolicitudHoraExtra> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<SolicitudHoraExtra> entities = new  ArrayList<SolicitudHoraExtra>();
		SolicitudHoraExtra entity = new SolicitudHoraExtra();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new SolicitudHoraExtra();
				
				if(conMapGenerico) {
					entity.inicializarMapSolicitudHoraExtra();
					//entity.setMapSolicitudHoraExtra(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapSolicitudHoraExtraValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapSolicitudHoraExtra().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,SolicitudHoraExtraDataAccess.ISWITHSCHEMA);         		
					entity=SolicitudHoraExtraDataAccess.getEntitySolicitudHoraExtra("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setSolicitudHoraExtraOriginal( new SolicitudHoraExtra());
					////entity.setSolicitudHoraExtraOriginal(super.getEntity("",entity.getSolicitudHoraExtraOriginal(),resultSet,SolicitudHoraExtraDataAccess.ISWITHSCHEMA));         		
					////entity.setSolicitudHoraExtraOriginal(this.getEntitySolicitudHoraExtra("",entity.getSolicitudHoraExtraOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseSolicitudHoraExtras(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarSolicitudHoraExtra(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public SolicitudHoraExtra getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		SolicitudHoraExtra entity = new SolicitudHoraExtra();		  
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
	
	public  SolicitudHoraExtra getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		SolicitudHoraExtra entity = new SolicitudHoraExtra();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new SolicitudHoraExtra();
				
				if(conMapGenerico) {
					entity.inicializarMapSolicitudHoraExtra();
					//entity.setMapSolicitudHoraExtra(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapSolicitudHoraExtraValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapSolicitudHoraExtra().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,SolicitudHoraExtraDataAccess.ISWITHSCHEMA);         		
					entity=SolicitudHoraExtraDataAccess.getEntitySolicitudHoraExtra("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setSolicitudHoraExtraOriginal( new SolicitudHoraExtra());
					////entity.setSolicitudHoraExtraOriginal(super.getEntity("",entity.getSolicitudHoraExtraOriginal(),resultSet,SolicitudHoraExtraDataAccess.ISWITHSCHEMA));         		
					////entity.setSolicitudHoraExtraOriginal(this.getEntitySolicitudHoraExtra("",entity.getSolicitudHoraExtraOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseSolicitudHoraExtra(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarSolicitudHoraExtra(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static SolicitudHoraExtra getEntitySolicitudHoraExtra(String strPrefijo,SolicitudHoraExtra entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = SolicitudHoraExtra.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = SolicitudHoraExtra.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					SolicitudHoraExtraDataAccess.setFieldReflectionSolicitudHoraExtra(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasSolicitudHoraExtra=SolicitudHoraExtraConstantesFunciones.getTodosTiposColumnasSolicitudHoraExtra();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasSolicitudHoraExtra) {
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
							field = SolicitudHoraExtra.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = SolicitudHoraExtra.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						SolicitudHoraExtraDataAccess.setFieldReflectionSolicitudHoraExtra(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionSolicitudHoraExtra(Field field,String strPrefijo,String sColumn,SolicitudHoraExtra entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case SolicitudHoraExtraConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SolicitudHoraExtraConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SolicitudHoraExtraConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SolicitudHoraExtraConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SolicitudHoraExtraConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SolicitudHoraExtraConstantesFunciones.IDESTRUCTURA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SolicitudHoraExtraConstantesFunciones.IDEMPLEADOJEFE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SolicitudHoraExtraConstantesFunciones.IDESTADOSOLICITUDNOMI:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SolicitudHoraExtraConstantesFunciones.IDEMPLEADOREEMPLAZO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SolicitudHoraExtraConstantesFunciones.SECUENCIAL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SolicitudHoraExtraConstantesFunciones.FECHASOLICITA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case SolicitudHoraExtraConstantesFunciones.FECHAEJECUTA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case SolicitudHoraExtraConstantesFunciones.NUMEROHORAS:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case SolicitudHoraExtraConstantesFunciones.COSTOUNITARIO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case SolicitudHoraExtraConstantesFunciones.COSTOTOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case SolicitudHoraExtraConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<SolicitudHoraExtra>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<SolicitudHoraExtra> entities = new  ArrayList<SolicitudHoraExtra>();
		SolicitudHoraExtra entity = new SolicitudHoraExtra();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=SolicitudHoraExtraDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=SolicitudHoraExtraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,SolicitudHoraExtraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new SolicitudHoraExtra();
					entity=super.getEntity("",entity,resultSet,SolicitudHoraExtraDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntitySolicitudHoraExtra("",entity,resultSet);
					
					//entity.setSolicitudHoraExtraOriginal( new SolicitudHoraExtra());
					//entity.setSolicitudHoraExtraOriginal(super.getEntity("",entity.getSolicitudHoraExtraOriginal(),resultSet,SolicitudHoraExtraDataAccess.ISWITHSCHEMA));         		
					//entity.setSolicitudHoraExtraOriginal(this.getEntitySolicitudHoraExtra("",entity.getSolicitudHoraExtraOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseSolicitudHoraExtras(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarSolicitudHoraExtra(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<SolicitudHoraExtra>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<SolicitudHoraExtra> entities = new  ArrayList<SolicitudHoraExtra>();
		SolicitudHoraExtra entity = new SolicitudHoraExtra();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=SolicitudHoraExtraDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=SolicitudHoraExtraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,SolicitudHoraExtraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<SolicitudHoraExtra> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<SolicitudHoraExtra> entities = new  ArrayList<SolicitudHoraExtra>();
		SolicitudHoraExtra entity = new SolicitudHoraExtra();		  
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
	
	public  List<SolicitudHoraExtra> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<SolicitudHoraExtra> entities = new  ArrayList<SolicitudHoraExtra>();
		SolicitudHoraExtra entity = new SolicitudHoraExtra();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new SolicitudHoraExtra();
      	    	entity=super.getEntity("",entity,resultSet,SolicitudHoraExtraDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntitySolicitudHoraExtra("",entity,resultSet);
      	    	
				//entity.setSolicitudHoraExtraOriginal( new SolicitudHoraExtra());
      	    	//entity.setSolicitudHoraExtraOriginal(super.getEntity("",entity.getSolicitudHoraExtraOriginal(),resultSet,SolicitudHoraExtraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setSolicitudHoraExtraOriginal(this.getEntitySolicitudHoraExtra("",entity.getSolicitudHoraExtraOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseSolicitudHoraExtras(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarSolicitudHoraExtra(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<SolicitudHoraExtra> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<SolicitudHoraExtra> entities = new  ArrayList<SolicitudHoraExtra>();
		SolicitudHoraExtra entity = new SolicitudHoraExtra();		  
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
	
	public  List<SolicitudHoraExtra> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<SolicitudHoraExtra> entities = new  ArrayList<SolicitudHoraExtra>();
		SolicitudHoraExtra entity = new SolicitudHoraExtra();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new SolicitudHoraExtra();
      	    	entity=super.getEntity("",entity,resultSet,SolicitudHoraExtraDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntitySolicitudHoraExtra("",entity,resultSet);
      	    	
				//entity.setSolicitudHoraExtraOriginal( new SolicitudHoraExtra());
      	    	//entity.setSolicitudHoraExtraOriginal(super.getEntity("",entity.getSolicitudHoraExtraOriginal(),resultSet,SolicitudHoraExtraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setSolicitudHoraExtraOriginal(this.getEntitySolicitudHoraExtra("",entity.getSolicitudHoraExtraOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseSolicitudHoraExtras(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public SolicitudHoraExtra getEntitySolicitudHoraExtra(String strPrefijo,SolicitudHoraExtra entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+SolicitudHoraExtraConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+SolicitudHoraExtraConstantesFunciones.IDSUCURSAL));
				entity.setid_empleado(resultSet.getLong(strPrefijo+SolicitudHoraExtraConstantesFunciones.IDEMPLEADO));
				entity.setid_estructura(resultSet.getLong(strPrefijo+SolicitudHoraExtraConstantesFunciones.IDESTRUCTURA));
				entity.setid_empleado_jefe(resultSet.getLong(strPrefijo+SolicitudHoraExtraConstantesFunciones.IDEMPLEADOJEFE));
				entity.setid_estado_solicitud_nomi(resultSet.getLong(strPrefijo+SolicitudHoraExtraConstantesFunciones.IDESTADOSOLICITUDNOMI));
				entity.setid_empleado_reemplazo(resultSet.getLong(strPrefijo+SolicitudHoraExtraConstantesFunciones.IDEMPLEADOREEMPLAZO));
				entity.setsecuencial(resultSet.getString(strPrefijo+SolicitudHoraExtraConstantesFunciones.SECUENCIAL));
				entity.setfecha_solicita(new Date(resultSet.getDate(strPrefijo+SolicitudHoraExtraConstantesFunciones.FECHASOLICITA).getTime()));
				entity.setfecha_ejecuta(new Date(resultSet.getDate(strPrefijo+SolicitudHoraExtraConstantesFunciones.FECHAEJECUTA).getTime()));
				entity.setnumero_horas(resultSet.getInt(strPrefijo+SolicitudHoraExtraConstantesFunciones.NUMEROHORAS));
				entity.setcosto_unitario(resultSet.getDouble(strPrefijo+SolicitudHoraExtraConstantesFunciones.COSTOUNITARIO));
				entity.setcosto_total(resultSet.getDouble(strPrefijo+SolicitudHoraExtraConstantesFunciones.COSTOTOTAL));
				entity.setdescripcion(resultSet.getString(strPrefijo+SolicitudHoraExtraConstantesFunciones.DESCRIPCION));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowSolicitudHoraExtra(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(SolicitudHoraExtra entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=SolicitudHoraExtraDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=SolicitudHoraExtraDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=SolicitudHoraExtraDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=SolicitudHoraExtraDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(SolicitudHoraExtraConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,SolicitudHoraExtraDataAccess.TABLENAME,SolicitudHoraExtraDataAccess.ISWITHSTOREPROCEDURES);
			
			SolicitudHoraExtraDataAccess.setSolicitudHoraExtraOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,SolicitudHoraExtra relsolicitudhoraextra)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relsolicitudhoraextra.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,SolicitudHoraExtra relsolicitudhoraextra)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relsolicitudhoraextra.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Empleado getEmpleado(Connexion connexion,SolicitudHoraExtra relsolicitudhoraextra)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relsolicitudhoraextra.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public Estructura getEstructura(Connexion connexion,SolicitudHoraExtra relsolicitudhoraextra)throws SQLException,Exception {

		Estructura estructura= new Estructura();

		try {
			EstructuraDataAccess estructuraDataAccess=new EstructuraDataAccess();

			estructuraDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estructuraDataAccess.setConnexionType(this.connexionType);
			estructuraDataAccess.setParameterDbType(this.parameterDbType);

			estructura=estructuraDataAccess.getEntity(connexion,relsolicitudhoraextra.getid_estructura());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estructura;

	}

	public Empleado getEmpleadoJefe(Connexion connexion,SolicitudHoraExtra relsolicitudhoraextra)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relsolicitudhoraextra.getid_empleado_jefe());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public EstadoSolicitudNomi getEstadoSolicitudNomi(Connexion connexion,SolicitudHoraExtra relsolicitudhoraextra)throws SQLException,Exception {

		EstadoSolicitudNomi estadosolicitudnomi= new EstadoSolicitudNomi();

		try {
			EstadoSolicitudNomiDataAccess estadosolicitudnomiDataAccess=new EstadoSolicitudNomiDataAccess();

			estadosolicitudnomiDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadosolicitudnomiDataAccess.setConnexionType(this.connexionType);
			estadosolicitudnomiDataAccess.setParameterDbType(this.parameterDbType);

			estadosolicitudnomi=estadosolicitudnomiDataAccess.getEntity(connexion,relsolicitudhoraextra.getid_estado_solicitud_nomi());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadosolicitudnomi;

	}

	public Empleado getEmpleadoReemplazo(Connexion connexion,SolicitudHoraExtra relsolicitudhoraextra)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relsolicitudhoraextra.getid_empleado_reemplazo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,SolicitudHoraExtra solicitudhoraextra) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!solicitudhoraextra.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(solicitudhoraextra.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(solicitudhoraextra.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(solicitudhoraextra.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estructura=new ParameterValue<Long>();
					parameterMaintenanceValueid_estructura.setValue(solicitudhoraextra.getid_estructura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estructura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado_jefe=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado_jefe.setValue(solicitudhoraextra.getid_empleado_jefe());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado_jefe);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_solicitud_nomi=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_solicitud_nomi.setValue(solicitudhoraextra.getid_estado_solicitud_nomi());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_solicitud_nomi);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado_reemplazo=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado_reemplazo.setValue(solicitudhoraextra.getid_empleado_reemplazo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado_reemplazo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuesecuencial=new ParameterValue<String>();
					parameterMaintenanceValuesecuencial.setValue(solicitudhoraextra.getsecuencial());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesecuencial);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_solicita=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_solicita.setValue(solicitudhoraextra.getfecha_solicita());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_solicita);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_ejecuta=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_ejecuta.setValue(solicitudhoraextra.getfecha_ejecuta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_ejecuta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuenumero_horas=new ParameterValue<Integer>();
					parameterMaintenanceValuenumero_horas.setValue(solicitudhoraextra.getnumero_horas());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_horas);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecosto_unitario=new ParameterValue<Double>();
					parameterMaintenanceValuecosto_unitario.setValue(solicitudhoraextra.getcosto_unitario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecosto_unitario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecosto_total=new ParameterValue<Double>();
					parameterMaintenanceValuecosto_total.setValue(solicitudhoraextra.getcosto_total());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecosto_total);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(solicitudhoraextra.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!solicitudhoraextra.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(solicitudhoraextra.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(solicitudhoraextra.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(solicitudhoraextra.getId());
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
	
	public void setIsNewIsChangedFalseSolicitudHoraExtra(SolicitudHoraExtra solicitudhoraextra)throws Exception  {		
		solicitudhoraextra.setIsNew(false);
		solicitudhoraextra.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseSolicitudHoraExtras(List<SolicitudHoraExtra> solicitudhoraextras)throws Exception  {				
		for(SolicitudHoraExtra solicitudhoraextra:solicitudhoraextras) {
			solicitudhoraextra.setIsNew(false);
			solicitudhoraextra.setIsChanged(false);
		}
	}
	
	public void generarExportarSolicitudHoraExtra(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
