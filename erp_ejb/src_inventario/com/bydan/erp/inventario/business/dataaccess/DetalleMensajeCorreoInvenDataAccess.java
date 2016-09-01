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
import com.bydan.erp.inventario.util.*;//DetalleMensajeCorreoInvenConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;




@SuppressWarnings("unused")
final public class DetalleMensajeCorreoInvenDataAccess extends  DetalleMensajeCorreoInvenDataAccessAdditional{ //DetalleMensajeCorreoInvenDataAccessAdditional,DataAccessHelper<DetalleMensajeCorreoInven>
	//static Logger logger = Logger.getLogger(DetalleMensajeCorreoInvenDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="detalle_mensaje_correo_inven";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+DetalleMensajeCorreoInvenConstantesFunciones.SCHEMA+"."+DetalleMensajeCorreoInvenConstantesFunciones.TABLENAME+"(version_row,id_mensaje_correo_inven,id_empresa,id_sucursal,id_modulo,id_usuario,id_empleado,esta_activo)values(current_timestamp,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+DetalleMensajeCorreoInvenConstantesFunciones.SCHEMA+"."+DetalleMensajeCorreoInvenConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_mensaje_correo_inven=?,id_empresa=?,id_sucursal=?,id_modulo=?,id_usuario=?,id_empleado=?,esta_activo=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+DetalleMensajeCorreoInvenConstantesFunciones.SCHEMA+"."+DetalleMensajeCorreoInvenConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select detallemensajecorreoinven from "+DetalleMensajeCorreoInvenConstantesFunciones.SPERSISTENCENAME+" detallemensajecorreoinven";
	public static String QUERYSELECTNATIVE="select "+DetalleMensajeCorreoInvenConstantesFunciones.SCHEMA+"."+DetalleMensajeCorreoInvenConstantesFunciones.TABLENAME+".id,"+DetalleMensajeCorreoInvenConstantesFunciones.SCHEMA+"."+DetalleMensajeCorreoInvenConstantesFunciones.TABLENAME+".version_row,"+DetalleMensajeCorreoInvenConstantesFunciones.SCHEMA+"."+DetalleMensajeCorreoInvenConstantesFunciones.TABLENAME+".id_mensaje_correo_inven,"+DetalleMensajeCorreoInvenConstantesFunciones.SCHEMA+"."+DetalleMensajeCorreoInvenConstantesFunciones.TABLENAME+".id_empresa,"+DetalleMensajeCorreoInvenConstantesFunciones.SCHEMA+"."+DetalleMensajeCorreoInvenConstantesFunciones.TABLENAME+".id_sucursal,"+DetalleMensajeCorreoInvenConstantesFunciones.SCHEMA+"."+DetalleMensajeCorreoInvenConstantesFunciones.TABLENAME+".id_modulo,"+DetalleMensajeCorreoInvenConstantesFunciones.SCHEMA+"."+DetalleMensajeCorreoInvenConstantesFunciones.TABLENAME+".id_usuario,"+DetalleMensajeCorreoInvenConstantesFunciones.SCHEMA+"."+DetalleMensajeCorreoInvenConstantesFunciones.TABLENAME+".id_empleado,"+DetalleMensajeCorreoInvenConstantesFunciones.SCHEMA+"."+DetalleMensajeCorreoInvenConstantesFunciones.TABLENAME+".esta_activo from "+DetalleMensajeCorreoInvenConstantesFunciones.SCHEMA+"."+DetalleMensajeCorreoInvenConstantesFunciones.TABLENAME;//+" as "+DetalleMensajeCorreoInvenConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+DetalleMensajeCorreoInvenConstantesFunciones.SCHEMA+"."+DetalleMensajeCorreoInvenConstantesFunciones.TABLENAME+".id,"+DetalleMensajeCorreoInvenConstantesFunciones.SCHEMA+"."+DetalleMensajeCorreoInvenConstantesFunciones.TABLENAME+".version_row from "+DetalleMensajeCorreoInvenConstantesFunciones.SCHEMA+"."+DetalleMensajeCorreoInvenConstantesFunciones.TABLENAME;//+" as "+DetalleMensajeCorreoInvenConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+DetalleMensajeCorreoInvenConstantesFunciones.SCHEMA+"."+DetalleMensajeCorreoInvenConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_mensaje_correo_inven=?,id_empresa=?,id_sucursal=?,id_modulo=?,id_usuario=?,id_empleado=?,esta_activo=?";
	
	public static String STOREPROCEDUREINSERT="call SP_DETALLEMENSAJECORREOINVEN_INSERT(?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_DETALLEMENSAJECORREOINVEN_UPDATE(?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_DETALLEMENSAJECORREOINVEN_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_DETALLEMENSAJECORREOINVEN_SELECT(?,?)";
	
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
	
	
	protected DetalleMensajeCorreoInvenDataAccessAdditional detallemensajecorreoinvenDataAccessAdditional=null;
	
	public DetalleMensajeCorreoInvenDataAccessAdditional getDetalleMensajeCorreoInvenDataAccessAdditional() {
		return this.detallemensajecorreoinvenDataAccessAdditional;
	}
	
	public void setDetalleMensajeCorreoInvenDataAccessAdditional(DetalleMensajeCorreoInvenDataAccessAdditional detallemensajecorreoinvenDataAccessAdditional) {
		try {
			this.detallemensajecorreoinvenDataAccessAdditional=detallemensajecorreoinvenDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public DetalleMensajeCorreoInvenDataAccess() {
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
		DetalleMensajeCorreoInvenDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		DetalleMensajeCorreoInvenDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		DetalleMensajeCorreoInvenDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setDetalleMensajeCorreoInvenOriginal(DetalleMensajeCorreoInven detallemensajecorreoinven)throws Exception  {
		detallemensajecorreoinven.setDetalleMensajeCorreoInvenOriginal((DetalleMensajeCorreoInven)detallemensajecorreoinven.clone());		
	}
	
	public void setDetalleMensajeCorreoInvensOriginal(List<DetalleMensajeCorreoInven> detallemensajecorreoinvens)throws Exception  {
		
		for(DetalleMensajeCorreoInven detallemensajecorreoinven:detallemensajecorreoinvens){
			detallemensajecorreoinven.setDetalleMensajeCorreoInvenOriginal((DetalleMensajeCorreoInven)detallemensajecorreoinven.clone());
		}
	}
	
	public static void setDetalleMensajeCorreoInvenOriginalStatic(DetalleMensajeCorreoInven detallemensajecorreoinven)throws Exception  {
		detallemensajecorreoinven.setDetalleMensajeCorreoInvenOriginal((DetalleMensajeCorreoInven)detallemensajecorreoinven.clone());		
	}
	
	public static void setDetalleMensajeCorreoInvensOriginalStatic(List<DetalleMensajeCorreoInven> detallemensajecorreoinvens)throws Exception  {
		
		for(DetalleMensajeCorreoInven detallemensajecorreoinven:detallemensajecorreoinvens){
			detallemensajecorreoinven.setDetalleMensajeCorreoInvenOriginal((DetalleMensajeCorreoInven)detallemensajecorreoinven.clone());
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
	
	public  DetalleMensajeCorreoInven getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		DetalleMensajeCorreoInven entity = new DetalleMensajeCorreoInven();		
		
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
	
	public  DetalleMensajeCorreoInven getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		DetalleMensajeCorreoInven entity = new DetalleMensajeCorreoInven();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleMensajeCorreoInvenDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleMensajeCorreoInvenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.DetalleMensajeCorreoInven.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setDetalleMensajeCorreoInvenOriginal(new DetalleMensajeCorreoInven());
      	    	entity=super.getEntity("",entity,resultSet,DetalleMensajeCorreoInvenDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetalleMensajeCorreoInven("",entity,resultSet); 
				
				//entity.setDetalleMensajeCorreoInvenOriginal(super.getEntity("",entity.getDetalleMensajeCorreoInvenOriginal(),resultSet,DetalleMensajeCorreoInvenDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleMensajeCorreoInvenOriginal(this.getEntityDetalleMensajeCorreoInven("",entity.getDetalleMensajeCorreoInvenOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseDetalleMensajeCorreoInven(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  DetalleMensajeCorreoInven getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetalleMensajeCorreoInven entity = new DetalleMensajeCorreoInven();
				
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
	
	public  DetalleMensajeCorreoInven getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetalleMensajeCorreoInven entity = new DetalleMensajeCorreoInven();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleMensajeCorreoInvenDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleMensajeCorreoInvenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleMensajeCorreoInvenDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.DetalleMensajeCorreoInven.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setDetalleMensajeCorreoInvenOriginal(new DetalleMensajeCorreoInven());
      	    	entity=super.getEntity("",entity,resultSet,DetalleMensajeCorreoInvenDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetalleMensajeCorreoInven("",entity,resultSet);    
				
				//entity.setDetalleMensajeCorreoInvenOriginal(super.getEntity("",entity.getDetalleMensajeCorreoInvenOriginal(),resultSet,DetalleMensajeCorreoInvenDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleMensajeCorreoInvenOriginal(this.getEntityDetalleMensajeCorreoInven("",entity.getDetalleMensajeCorreoInvenOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseDetalleMensajeCorreoInven(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //DetalleMensajeCorreoInven
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		DetalleMensajeCorreoInven entity = new DetalleMensajeCorreoInven();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleMensajeCorreoInvenDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleMensajeCorreoInvenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleMensajeCorreoInvenDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.DetalleMensajeCorreoInven.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseDetalleMensajeCorreoInven(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<DetalleMensajeCorreoInven> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetalleMensajeCorreoInven> entities = new  ArrayList<DetalleMensajeCorreoInven>();
		DetalleMensajeCorreoInven entity = new DetalleMensajeCorreoInven();		  
		
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
	
	public  List<DetalleMensajeCorreoInven> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetalleMensajeCorreoInven> entities = new  ArrayList<DetalleMensajeCorreoInven>();
		DetalleMensajeCorreoInven entity = new DetalleMensajeCorreoInven();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleMensajeCorreoInvenDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleMensajeCorreoInvenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleMensajeCorreoInvenDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleMensajeCorreoInven();
      	    	entity=super.getEntity("",entity,resultSet,DetalleMensajeCorreoInvenDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleMensajeCorreoInven("",entity,resultSet);
      	    	
				//entity.setDetalleMensajeCorreoInvenOriginal( new DetalleMensajeCorreoInven());
      	    	//entity.setDetalleMensajeCorreoInvenOriginal(super.getEntity("",entity.getDetalleMensajeCorreoInvenOriginal(),resultSet,DetalleMensajeCorreoInvenDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleMensajeCorreoInvenOriginal(this.getEntityDetalleMensajeCorreoInven("",entity.getDetalleMensajeCorreoInvenOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleMensajeCorreoInvens(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleMensajeCorreoInven(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetalleMensajeCorreoInven> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetalleMensajeCorreoInven> entities = new  ArrayList<DetalleMensajeCorreoInven>();
		DetalleMensajeCorreoInven entity = new DetalleMensajeCorreoInven();		  
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
	
	public  List<DetalleMensajeCorreoInven> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetalleMensajeCorreoInven> entities = new  ArrayList<DetalleMensajeCorreoInven>();
		DetalleMensajeCorreoInven entity = new DetalleMensajeCorreoInven();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleMensajeCorreoInven();
				
				if(conMapGenerico) {
					entity.inicializarMapDetalleMensajeCorreoInven();
					//entity.setMapDetalleMensajeCorreoInven(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapDetalleMensajeCorreoInvenValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetalleMensajeCorreoInven().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetalleMensajeCorreoInvenDataAccess.ISWITHSCHEMA);         		
					entity=DetalleMensajeCorreoInvenDataAccess.getEntityDetalleMensajeCorreoInven("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetalleMensajeCorreoInvenOriginal( new DetalleMensajeCorreoInven());
					////entity.setDetalleMensajeCorreoInvenOriginal(super.getEntity("",entity.getDetalleMensajeCorreoInvenOriginal(),resultSet,DetalleMensajeCorreoInvenDataAccess.ISWITHSCHEMA));         		
					////entity.setDetalleMensajeCorreoInvenOriginal(this.getEntityDetalleMensajeCorreoInven("",entity.getDetalleMensajeCorreoInvenOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleMensajeCorreoInvens(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleMensajeCorreoInven(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public DetalleMensajeCorreoInven getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetalleMensajeCorreoInven entity = new DetalleMensajeCorreoInven();		  
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
	
	public  DetalleMensajeCorreoInven getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetalleMensajeCorreoInven entity = new DetalleMensajeCorreoInven();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleMensajeCorreoInven();
				
				if(conMapGenerico) {
					entity.inicializarMapDetalleMensajeCorreoInven();
					//entity.setMapDetalleMensajeCorreoInven(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapDetalleMensajeCorreoInvenValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetalleMensajeCorreoInven().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetalleMensajeCorreoInvenDataAccess.ISWITHSCHEMA);         		
					entity=DetalleMensajeCorreoInvenDataAccess.getEntityDetalleMensajeCorreoInven("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetalleMensajeCorreoInvenOriginal( new DetalleMensajeCorreoInven());
					////entity.setDetalleMensajeCorreoInvenOriginal(super.getEntity("",entity.getDetalleMensajeCorreoInvenOriginal(),resultSet,DetalleMensajeCorreoInvenDataAccess.ISWITHSCHEMA));         		
					////entity.setDetalleMensajeCorreoInvenOriginal(this.getEntityDetalleMensajeCorreoInven("",entity.getDetalleMensajeCorreoInvenOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseDetalleMensajeCorreoInven(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleMensajeCorreoInven(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static DetalleMensajeCorreoInven getEntityDetalleMensajeCorreoInven(String strPrefijo,DetalleMensajeCorreoInven entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = DetalleMensajeCorreoInven.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = DetalleMensajeCorreoInven.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					DetalleMensajeCorreoInvenDataAccess.setFieldReflectionDetalleMensajeCorreoInven(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasDetalleMensajeCorreoInven=DetalleMensajeCorreoInvenConstantesFunciones.getTodosTiposColumnasDetalleMensajeCorreoInven();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasDetalleMensajeCorreoInven) {
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
							field = DetalleMensajeCorreoInven.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = DetalleMensajeCorreoInven.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						DetalleMensajeCorreoInvenDataAccess.setFieldReflectionDetalleMensajeCorreoInven(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionDetalleMensajeCorreoInven(Field field,String strPrefijo,String sColumn,DetalleMensajeCorreoInven entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case DetalleMensajeCorreoInvenConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleMensajeCorreoInvenConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleMensajeCorreoInvenConstantesFunciones.IDMENSAJECORREOINVEN:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleMensajeCorreoInvenConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleMensajeCorreoInvenConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleMensajeCorreoInvenConstantesFunciones.IDMODULO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleMensajeCorreoInvenConstantesFunciones.IDUSUARIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleMensajeCorreoInvenConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleMensajeCorreoInvenConstantesFunciones.ESTAACTIVO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetalleMensajeCorreoInven>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<DetalleMensajeCorreoInven> entities = new  ArrayList<DetalleMensajeCorreoInven>();
		DetalleMensajeCorreoInven entity = new DetalleMensajeCorreoInven();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleMensajeCorreoInvenDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleMensajeCorreoInvenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleMensajeCorreoInvenDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new DetalleMensajeCorreoInven();
					entity=super.getEntity("",entity,resultSet,DetalleMensajeCorreoInvenDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityDetalleMensajeCorreoInven("",entity,resultSet);
					
					//entity.setDetalleMensajeCorreoInvenOriginal( new DetalleMensajeCorreoInven());
					//entity.setDetalleMensajeCorreoInvenOriginal(super.getEntity("",entity.getDetalleMensajeCorreoInvenOriginal(),resultSet,DetalleMensajeCorreoInvenDataAccess.ISWITHSCHEMA));         		
					//entity.setDetalleMensajeCorreoInvenOriginal(this.getEntityDetalleMensajeCorreoInven("",entity.getDetalleMensajeCorreoInvenOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseDetalleMensajeCorreoInvens(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleMensajeCorreoInven(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetalleMensajeCorreoInven>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<DetalleMensajeCorreoInven> entities = new  ArrayList<DetalleMensajeCorreoInven>();
		DetalleMensajeCorreoInven entity = new DetalleMensajeCorreoInven();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleMensajeCorreoInvenDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleMensajeCorreoInvenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleMensajeCorreoInvenDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<DetalleMensajeCorreoInven> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleMensajeCorreoInven> entities = new  ArrayList<DetalleMensajeCorreoInven>();
		DetalleMensajeCorreoInven entity = new DetalleMensajeCorreoInven();		  
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
	
	public  List<DetalleMensajeCorreoInven> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleMensajeCorreoInven> entities = new  ArrayList<DetalleMensajeCorreoInven>();
		DetalleMensajeCorreoInven entity = new DetalleMensajeCorreoInven();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleMensajeCorreoInven();
      	    	entity=super.getEntity("",entity,resultSet,DetalleMensajeCorreoInvenDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleMensajeCorreoInven("",entity,resultSet);
      	    	
				//entity.setDetalleMensajeCorreoInvenOriginal( new DetalleMensajeCorreoInven());
      	    	//entity.setDetalleMensajeCorreoInvenOriginal(super.getEntity("",entity.getDetalleMensajeCorreoInvenOriginal(),resultSet,DetalleMensajeCorreoInvenDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleMensajeCorreoInvenOriginal(this.getEntityDetalleMensajeCorreoInven("",entity.getDetalleMensajeCorreoInvenOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseDetalleMensajeCorreoInvens(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleMensajeCorreoInven(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetalleMensajeCorreoInven> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleMensajeCorreoInven> entities = new  ArrayList<DetalleMensajeCorreoInven>();
		DetalleMensajeCorreoInven entity = new DetalleMensajeCorreoInven();		  
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
	
	public  List<DetalleMensajeCorreoInven> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleMensajeCorreoInven> entities = new  ArrayList<DetalleMensajeCorreoInven>();
		DetalleMensajeCorreoInven entity = new DetalleMensajeCorreoInven();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleMensajeCorreoInven();
      	    	entity=super.getEntity("",entity,resultSet,DetalleMensajeCorreoInvenDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleMensajeCorreoInven("",entity,resultSet);
      	    	
				//entity.setDetalleMensajeCorreoInvenOriginal( new DetalleMensajeCorreoInven());
      	    	//entity.setDetalleMensajeCorreoInvenOriginal(super.getEntity("",entity.getDetalleMensajeCorreoInvenOriginal(),resultSet,DetalleMensajeCorreoInvenDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleMensajeCorreoInvenOriginal(this.getEntityDetalleMensajeCorreoInven("",entity.getDetalleMensajeCorreoInvenOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleMensajeCorreoInvens(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public DetalleMensajeCorreoInven getEntityDetalleMensajeCorreoInven(String strPrefijo,DetalleMensajeCorreoInven entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_mensaje_correo_inven(resultSet.getLong(strPrefijo+DetalleMensajeCorreoInvenConstantesFunciones.IDMENSAJECORREOINVEN));
				entity.setid_empresa(resultSet.getLong(strPrefijo+DetalleMensajeCorreoInvenConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+DetalleMensajeCorreoInvenConstantesFunciones.IDSUCURSAL));
				entity.setid_modulo(resultSet.getLong(strPrefijo+DetalleMensajeCorreoInvenConstantesFunciones.IDMODULO));
				entity.setid_usuario(resultSet.getLong(strPrefijo+DetalleMensajeCorreoInvenConstantesFunciones.IDUSUARIO));
				entity.setid_empleado(resultSet.getLong(strPrefijo+DetalleMensajeCorreoInvenConstantesFunciones.IDEMPLEADO));
				entity.setesta_activo(resultSet.getBoolean(strPrefijo+DetalleMensajeCorreoInvenConstantesFunciones.ESTAACTIVO));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowDetalleMensajeCorreoInven(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(DetalleMensajeCorreoInven entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=DetalleMensajeCorreoInvenDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=DetalleMensajeCorreoInvenDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=DetalleMensajeCorreoInvenDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=DetalleMensajeCorreoInvenDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(DetalleMensajeCorreoInvenConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,DetalleMensajeCorreoInvenDataAccess.TABLENAME,DetalleMensajeCorreoInvenDataAccess.ISWITHSTOREPROCEDURES);
			
			DetalleMensajeCorreoInvenDataAccess.setDetalleMensajeCorreoInvenOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public MensajeCorreoInven getMensajeCorreoInven(Connexion connexion,DetalleMensajeCorreoInven reldetallemensajecorreoinven)throws SQLException,Exception {

		MensajeCorreoInven mensajecorreoinven= new MensajeCorreoInven();

		try {
			MensajeCorreoInvenDataAccess mensajecorreoinvenDataAccess=new MensajeCorreoInvenDataAccess();

			mensajecorreoinvenDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mensajecorreoinvenDataAccess.setConnexionType(this.connexionType);
			mensajecorreoinvenDataAccess.setParameterDbType(this.parameterDbType);

			mensajecorreoinven=mensajecorreoinvenDataAccess.getEntity(connexion,reldetallemensajecorreoinven.getid_mensaje_correo_inven());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mensajecorreoinven;

	}

	public Empresa getEmpresa(Connexion connexion,DetalleMensajeCorreoInven reldetallemensajecorreoinven)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reldetallemensajecorreoinven.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,DetalleMensajeCorreoInven reldetallemensajecorreoinven)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,reldetallemensajecorreoinven.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Modulo getModulo(Connexion connexion,DetalleMensajeCorreoInven reldetallemensajecorreoinven)throws SQLException,Exception {

		Modulo modulo= new Modulo();

		try {
			ModuloDataAccess moduloDataAccess=new ModuloDataAccess();

			moduloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			moduloDataAccess.setConnexionType(this.connexionType);
			moduloDataAccess.setParameterDbType(this.parameterDbType);

			modulo=moduloDataAccess.getEntity(connexion,reldetallemensajecorreoinven.getid_modulo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return modulo;

	}

	public Usuario getUsuario(Connexion connexion,DetalleMensajeCorreoInven reldetallemensajecorreoinven)throws SQLException,Exception {

		Usuario usuario= new Usuario();

		try {
			UsuarioDataAccess usuarioDataAccess=new UsuarioDataAccess();

			usuarioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			usuarioDataAccess.setConnexionType(this.connexionType);
			usuarioDataAccess.setParameterDbType(this.parameterDbType);

			usuario=usuarioDataAccess.getEntity(connexion,reldetallemensajecorreoinven.getid_usuario());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return usuario;

	}

	public Empleado getEmpleado(Connexion connexion,DetalleMensajeCorreoInven reldetallemensajecorreoinven)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,reldetallemensajecorreoinven.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,DetalleMensajeCorreoInven detallemensajecorreoinven) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!detallemensajecorreoinven.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mensaje_correo_inven=new ParameterValue<Long>();
					parameterMaintenanceValueid_mensaje_correo_inven.setValue(detallemensajecorreoinven.getid_mensaje_correo_inven());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mensaje_correo_inven);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(detallemensajecorreoinven.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(detallemensajecorreoinven.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_modulo=new ParameterValue<Long>();
					parameterMaintenanceValueid_modulo.setValue(detallemensajecorreoinven.getid_modulo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_modulo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_usuario=new ParameterValue<Long>();
					parameterMaintenanceValueid_usuario.setValue(detallemensajecorreoinven.getid_usuario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_usuario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(detallemensajecorreoinven.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValueesta_activo=new ParameterValue<Boolean>();
					parameterMaintenanceValueesta_activo.setValue(detallemensajecorreoinven.getesta_activo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueesta_activo);
					parametersTemp.add(parameterMaintenance);
					
						if(!detallemensajecorreoinven.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(detallemensajecorreoinven.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(detallemensajecorreoinven.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(detallemensajecorreoinven.getId());
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
	
	public void setIsNewIsChangedFalseDetalleMensajeCorreoInven(DetalleMensajeCorreoInven detallemensajecorreoinven)throws Exception  {		
		detallemensajecorreoinven.setIsNew(false);
		detallemensajecorreoinven.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseDetalleMensajeCorreoInvens(List<DetalleMensajeCorreoInven> detallemensajecorreoinvens)throws Exception  {				
		for(DetalleMensajeCorreoInven detallemensajecorreoinven:detallemensajecorreoinvens) {
			detallemensajecorreoinven.setIsNew(false);
			detallemensajecorreoinven.setIsChanged(false);
		}
	}
	
	public void generarExportarDetalleMensajeCorreoInven(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
