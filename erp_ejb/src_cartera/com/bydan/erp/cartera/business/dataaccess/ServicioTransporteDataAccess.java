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
package com.bydan.erp.cartera.business.dataaccess;

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

import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.cartera.util.*;//ServicioTransporteConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.activosfijos.util.*;




@SuppressWarnings("unused")
final public class ServicioTransporteDataAccess extends  ServicioTransporteDataAccessAdditional{ //ServicioTransporteDataAccessAdditional,DataAccessHelper<ServicioTransporte>
	//static Logger logger = Logger.getLogger(ServicioTransporteDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="servicio_transporte";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ServicioTransporteConstantesFunciones.SCHEMA+"."+ServicioTransporteConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_ejercicio,id_periodo,id_cliente,id_cliente_proveedor,id_transportista,id_vehiculo,id_ruta_transporte,id_detalle_activo_fijo,fecha_ingreso,fecha_entrega,codigo_guia1,codigo_guia2,precio,valor_iva,valor_total,descripcion)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+ServicioTransporteConstantesFunciones.SCHEMA+"."+ServicioTransporteConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_cliente=?,id_cliente_proveedor=?,id_transportista=?,id_vehiculo=?,id_ruta_transporte=?,id_detalle_activo_fijo=?,fecha_ingreso=?,fecha_entrega=?,codigo_guia1=?,codigo_guia2=?,precio=?,valor_iva=?,valor_total=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ServicioTransporteConstantesFunciones.SCHEMA+"."+ServicioTransporteConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select serviciotransporte from "+ServicioTransporteConstantesFunciones.SPERSISTENCENAME+" serviciotransporte";
	public static String QUERYSELECTNATIVE="select "+ServicioTransporteConstantesFunciones.SCHEMA+"."+ServicioTransporteConstantesFunciones.TABLENAME+".id,"+ServicioTransporteConstantesFunciones.SCHEMA+"."+ServicioTransporteConstantesFunciones.TABLENAME+".version_row,"+ServicioTransporteConstantesFunciones.SCHEMA+"."+ServicioTransporteConstantesFunciones.TABLENAME+".id_empresa,"+ServicioTransporteConstantesFunciones.SCHEMA+"."+ServicioTransporteConstantesFunciones.TABLENAME+".id_sucursal,"+ServicioTransporteConstantesFunciones.SCHEMA+"."+ServicioTransporteConstantesFunciones.TABLENAME+".id_ejercicio,"+ServicioTransporteConstantesFunciones.SCHEMA+"."+ServicioTransporteConstantesFunciones.TABLENAME+".id_periodo,"+ServicioTransporteConstantesFunciones.SCHEMA+"."+ServicioTransporteConstantesFunciones.TABLENAME+".id_cliente,"+ServicioTransporteConstantesFunciones.SCHEMA+"."+ServicioTransporteConstantesFunciones.TABLENAME+".id_cliente_proveedor,"+ServicioTransporteConstantesFunciones.SCHEMA+"."+ServicioTransporteConstantesFunciones.TABLENAME+".id_transportista,"+ServicioTransporteConstantesFunciones.SCHEMA+"."+ServicioTransporteConstantesFunciones.TABLENAME+".id_vehiculo,"+ServicioTransporteConstantesFunciones.SCHEMA+"."+ServicioTransporteConstantesFunciones.TABLENAME+".id_ruta_transporte,"+ServicioTransporteConstantesFunciones.SCHEMA+"."+ServicioTransporteConstantesFunciones.TABLENAME+".id_detalle_activo_fijo,"+ServicioTransporteConstantesFunciones.SCHEMA+"."+ServicioTransporteConstantesFunciones.TABLENAME+".fecha_ingreso,"+ServicioTransporteConstantesFunciones.SCHEMA+"."+ServicioTransporteConstantesFunciones.TABLENAME+".fecha_entrega,"+ServicioTransporteConstantesFunciones.SCHEMA+"."+ServicioTransporteConstantesFunciones.TABLENAME+".codigo_guia1,"+ServicioTransporteConstantesFunciones.SCHEMA+"."+ServicioTransporteConstantesFunciones.TABLENAME+".codigo_guia2,"+ServicioTransporteConstantesFunciones.SCHEMA+"."+ServicioTransporteConstantesFunciones.TABLENAME+".precio,"+ServicioTransporteConstantesFunciones.SCHEMA+"."+ServicioTransporteConstantesFunciones.TABLENAME+".valor_iva,"+ServicioTransporteConstantesFunciones.SCHEMA+"."+ServicioTransporteConstantesFunciones.TABLENAME+".valor_total,"+ServicioTransporteConstantesFunciones.SCHEMA+"."+ServicioTransporteConstantesFunciones.TABLENAME+".descripcion from "+ServicioTransporteConstantesFunciones.SCHEMA+"."+ServicioTransporteConstantesFunciones.TABLENAME;//+" as "+ServicioTransporteConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ServicioTransporteConstantesFunciones.SCHEMA+"."+ServicioTransporteConstantesFunciones.TABLENAME+".id,"+ServicioTransporteConstantesFunciones.SCHEMA+"."+ServicioTransporteConstantesFunciones.TABLENAME+".version_row from "+ServicioTransporteConstantesFunciones.SCHEMA+"."+ServicioTransporteConstantesFunciones.TABLENAME;//+" as "+ServicioTransporteConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ServicioTransporteConstantesFunciones.SCHEMA+"."+ServicioTransporteConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_cliente=?,id_cliente_proveedor=?,id_transportista=?,id_vehiculo=?,id_ruta_transporte=?,id_detalle_activo_fijo=?,fecha_ingreso=?,fecha_entrega=?,codigo_guia1=?,codigo_guia2=?,precio=?,valor_iva=?,valor_total=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_SERVICIOTRANSPORTE_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_SERVICIOTRANSPORTE_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_SERVICIOTRANSPORTE_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_SERVICIOTRANSPORTE_SELECT(?,?)";
	
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
	
	
	protected ServicioTransporteDataAccessAdditional serviciotransporteDataAccessAdditional=null;
	
	public ServicioTransporteDataAccessAdditional getServicioTransporteDataAccessAdditional() {
		return this.serviciotransporteDataAccessAdditional;
	}
	
	public void setServicioTransporteDataAccessAdditional(ServicioTransporteDataAccessAdditional serviciotransporteDataAccessAdditional) {
		try {
			this.serviciotransporteDataAccessAdditional=serviciotransporteDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ServicioTransporteDataAccess() {
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
		ServicioTransporteDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ServicioTransporteDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ServicioTransporteDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setServicioTransporteOriginal(ServicioTransporte serviciotransporte)throws Exception  {
		serviciotransporte.setServicioTransporteOriginal((ServicioTransporte)serviciotransporte.clone());		
	}
	
	public void setServicioTransportesOriginal(List<ServicioTransporte> serviciotransportes)throws Exception  {
		
		for(ServicioTransporte serviciotransporte:serviciotransportes){
			serviciotransporte.setServicioTransporteOriginal((ServicioTransporte)serviciotransporte.clone());
		}
	}
	
	public static void setServicioTransporteOriginalStatic(ServicioTransporte serviciotransporte)throws Exception  {
		serviciotransporte.setServicioTransporteOriginal((ServicioTransporte)serviciotransporte.clone());		
	}
	
	public static void setServicioTransportesOriginalStatic(List<ServicioTransporte> serviciotransportes)throws Exception  {
		
		for(ServicioTransporte serviciotransporte:serviciotransportes){
			serviciotransporte.setServicioTransporteOriginal((ServicioTransporte)serviciotransporte.clone());
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
	
	public  ServicioTransporte getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		ServicioTransporte entity = new ServicioTransporte();		
		
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
	
	public  ServicioTransporte getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		ServicioTransporte entity = new ServicioTransporte();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ServicioTransporteDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ServicioTransporteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Cartera.ServicioTransporte.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setServicioTransporteOriginal(new ServicioTransporte());
      	    	entity=super.getEntity("",entity,resultSet,ServicioTransporteDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityServicioTransporte("",entity,resultSet); 
				
				//entity.setServicioTransporteOriginal(super.getEntity("",entity.getServicioTransporteOriginal(),resultSet,ServicioTransporteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setServicioTransporteOriginal(this.getEntityServicioTransporte("",entity.getServicioTransporteOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseServicioTransporte(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  ServicioTransporte getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ServicioTransporte entity = new ServicioTransporte();
				
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
	
	public  ServicioTransporte getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ServicioTransporte entity = new ServicioTransporte();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ServicioTransporteDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ServicioTransporteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ServicioTransporteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.ServicioTransporte.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setServicioTransporteOriginal(new ServicioTransporte());
      	    	entity=super.getEntity("",entity,resultSet,ServicioTransporteDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityServicioTransporte("",entity,resultSet);    
				
				//entity.setServicioTransporteOriginal(super.getEntity("",entity.getServicioTransporteOriginal(),resultSet,ServicioTransporteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setServicioTransporteOriginal(this.getEntityServicioTransporte("",entity.getServicioTransporteOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseServicioTransporte(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //ServicioTransporte
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		ServicioTransporte entity = new ServicioTransporte();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ServicioTransporteDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ServicioTransporteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ServicioTransporteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.ServicioTransporte.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseServicioTransporte(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<ServicioTransporte> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ServicioTransporte> entities = new  ArrayList<ServicioTransporte>();
		ServicioTransporte entity = new ServicioTransporte();		  
		
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
	
	public  List<ServicioTransporte> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ServicioTransporte> entities = new  ArrayList<ServicioTransporte>();
		ServicioTransporte entity = new ServicioTransporte();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ServicioTransporteDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ServicioTransporteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ServicioTransporteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ServicioTransporte();
      	    	entity=super.getEntity("",entity,resultSet,ServicioTransporteDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityServicioTransporte("",entity,resultSet);
      	    	
				//entity.setServicioTransporteOriginal( new ServicioTransporte());
      	    	//entity.setServicioTransporteOriginal(super.getEntity("",entity.getServicioTransporteOriginal(),resultSet,ServicioTransporteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setServicioTransporteOriginal(this.getEntityServicioTransporte("",entity.getServicioTransporteOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseServicioTransportes(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarServicioTransporte(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ServicioTransporte> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ServicioTransporte> entities = new  ArrayList<ServicioTransporte>();
		ServicioTransporte entity = new ServicioTransporte();		  
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
	
	public  List<ServicioTransporte> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ServicioTransporte> entities = new  ArrayList<ServicioTransporte>();
		ServicioTransporte entity = new ServicioTransporte();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ServicioTransporte();
				
				if(conMapGenerico) {
					entity.inicializarMapServicioTransporte();
					//entity.setMapServicioTransporte(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapServicioTransporteValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapServicioTransporte().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ServicioTransporteDataAccess.ISWITHSCHEMA);         		
					entity=ServicioTransporteDataAccess.getEntityServicioTransporte("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setServicioTransporteOriginal( new ServicioTransporte());
					////entity.setServicioTransporteOriginal(super.getEntity("",entity.getServicioTransporteOriginal(),resultSet,ServicioTransporteDataAccess.ISWITHSCHEMA));         		
					////entity.setServicioTransporteOriginal(this.getEntityServicioTransporte("",entity.getServicioTransporteOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseServicioTransportes(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarServicioTransporte(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public ServicioTransporte getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ServicioTransporte entity = new ServicioTransporte();		  
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
	
	public  ServicioTransporte getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ServicioTransporte entity = new ServicioTransporte();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ServicioTransporte();
				
				if(conMapGenerico) {
					entity.inicializarMapServicioTransporte();
					//entity.setMapServicioTransporte(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapServicioTransporteValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapServicioTransporte().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ServicioTransporteDataAccess.ISWITHSCHEMA);         		
					entity=ServicioTransporteDataAccess.getEntityServicioTransporte("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setServicioTransporteOriginal( new ServicioTransporte());
					////entity.setServicioTransporteOriginal(super.getEntity("",entity.getServicioTransporteOriginal(),resultSet,ServicioTransporteDataAccess.ISWITHSCHEMA));         		
					////entity.setServicioTransporteOriginal(this.getEntityServicioTransporte("",entity.getServicioTransporteOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseServicioTransporte(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarServicioTransporte(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ServicioTransporte getEntityServicioTransporte(String strPrefijo,ServicioTransporte entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = ServicioTransporte.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = ServicioTransporte.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ServicioTransporteDataAccess.setFieldReflectionServicioTransporte(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasServicioTransporte=ServicioTransporteConstantesFunciones.getTodosTiposColumnasServicioTransporte();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasServicioTransporte) {
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
							field = ServicioTransporte.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = ServicioTransporte.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ServicioTransporteDataAccess.setFieldReflectionServicioTransporte(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionServicioTransporte(Field field,String strPrefijo,String sColumn,ServicioTransporte entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ServicioTransporteConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ServicioTransporteConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ServicioTransporteConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ServicioTransporteConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ServicioTransporteConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ServicioTransporteConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ServicioTransporteConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ServicioTransporteConstantesFunciones.IDCLIENTEPROVEEDOR:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ServicioTransporteConstantesFunciones.IDTRANSPORTISTA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ServicioTransporteConstantesFunciones.IDVEHICULO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ServicioTransporteConstantesFunciones.IDRUTATRANSPORTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ServicioTransporteConstantesFunciones.IDDETALLEACTIVOFIJO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ServicioTransporteConstantesFunciones.FECHAINGRESO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case ServicioTransporteConstantesFunciones.FECHAENTREGA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case ServicioTransporteConstantesFunciones.CODIGOGUIA1:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ServicioTransporteConstantesFunciones.CODIGOGUIA2:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ServicioTransporteConstantesFunciones.PRECIO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ServicioTransporteConstantesFunciones.VALORIVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ServicioTransporteConstantesFunciones.VALORTOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ServicioTransporteConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ServicioTransporte>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<ServicioTransporte> entities = new  ArrayList<ServicioTransporte>();
		ServicioTransporte entity = new ServicioTransporte();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ServicioTransporteDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ServicioTransporteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ServicioTransporteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new ServicioTransporte();
					entity=super.getEntity("",entity,resultSet,ServicioTransporteDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityServicioTransporte("",entity,resultSet);
					
					//entity.setServicioTransporteOriginal( new ServicioTransporte());
					//entity.setServicioTransporteOriginal(super.getEntity("",entity.getServicioTransporteOriginal(),resultSet,ServicioTransporteDataAccess.ISWITHSCHEMA));         		
					//entity.setServicioTransporteOriginal(this.getEntityServicioTransporte("",entity.getServicioTransporteOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseServicioTransportes(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarServicioTransporte(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ServicioTransporte>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<ServicioTransporte> entities = new  ArrayList<ServicioTransporte>();
		ServicioTransporte entity = new ServicioTransporte();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ServicioTransporteDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ServicioTransporteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ServicioTransporteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<ServicioTransporte> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ServicioTransporte> entities = new  ArrayList<ServicioTransporte>();
		ServicioTransporte entity = new ServicioTransporte();		  
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
	
	public  List<ServicioTransporte> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ServicioTransporte> entities = new  ArrayList<ServicioTransporte>();
		ServicioTransporte entity = new ServicioTransporte();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ServicioTransporte();
      	    	entity=super.getEntity("",entity,resultSet,ServicioTransporteDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityServicioTransporte("",entity,resultSet);
      	    	
				//entity.setServicioTransporteOriginal( new ServicioTransporte());
      	    	//entity.setServicioTransporteOriginal(super.getEntity("",entity.getServicioTransporteOriginal(),resultSet,ServicioTransporteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setServicioTransporteOriginal(this.getEntityServicioTransporte("",entity.getServicioTransporteOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseServicioTransportes(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarServicioTransporte(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ServicioTransporte> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ServicioTransporte> entities = new  ArrayList<ServicioTransporte>();
		ServicioTransporte entity = new ServicioTransporte();		  
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
	
	public  List<ServicioTransporte> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ServicioTransporte> entities = new  ArrayList<ServicioTransporte>();
		ServicioTransporte entity = new ServicioTransporte();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ServicioTransporte();
      	    	entity=super.getEntity("",entity,resultSet,ServicioTransporteDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityServicioTransporte("",entity,resultSet);
      	    	
				//entity.setServicioTransporteOriginal( new ServicioTransporte());
      	    	//entity.setServicioTransporteOriginal(super.getEntity("",entity.getServicioTransporteOriginal(),resultSet,ServicioTransporteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setServicioTransporteOriginal(this.getEntityServicioTransporte("",entity.getServicioTransporteOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseServicioTransportes(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public ServicioTransporte getEntityServicioTransporte(String strPrefijo,ServicioTransporte entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+ServicioTransporteConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+ServicioTransporteConstantesFunciones.IDSUCURSAL));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+ServicioTransporteConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+ServicioTransporteConstantesFunciones.IDPERIODO));
				entity.setid_cliente(resultSet.getLong(strPrefijo+ServicioTransporteConstantesFunciones.IDCLIENTE));
				entity.setid_cliente_proveedor(resultSet.getLong(strPrefijo+ServicioTransporteConstantesFunciones.IDCLIENTEPROVEEDOR));
				entity.setid_transportista(resultSet.getLong(strPrefijo+ServicioTransporteConstantesFunciones.IDTRANSPORTISTA));
				entity.setid_vehiculo(resultSet.getLong(strPrefijo+ServicioTransporteConstantesFunciones.IDVEHICULO));
				entity.setid_ruta_transporte(resultSet.getLong(strPrefijo+ServicioTransporteConstantesFunciones.IDRUTATRANSPORTE));
				entity.setid_detalle_activo_fijo(resultSet.getLong(strPrefijo+ServicioTransporteConstantesFunciones.IDDETALLEACTIVOFIJO));
				entity.setfecha_ingreso(new Date(resultSet.getDate(strPrefijo+ServicioTransporteConstantesFunciones.FECHAINGRESO).getTime()));
				entity.setfecha_entrega(new Date(resultSet.getDate(strPrefijo+ServicioTransporteConstantesFunciones.FECHAENTREGA).getTime()));
				entity.setcodigo_guia1(resultSet.getString(strPrefijo+ServicioTransporteConstantesFunciones.CODIGOGUIA1));
				entity.setcodigo_guia2(resultSet.getString(strPrefijo+ServicioTransporteConstantesFunciones.CODIGOGUIA2));
				entity.setprecio(resultSet.getDouble(strPrefijo+ServicioTransporteConstantesFunciones.PRECIO));
				entity.setvalor_iva(resultSet.getDouble(strPrefijo+ServicioTransporteConstantesFunciones.VALORIVA));
				entity.setvalor_total(resultSet.getDouble(strPrefijo+ServicioTransporteConstantesFunciones.VALORTOTAL));
				entity.setdescripcion(resultSet.getString(strPrefijo+ServicioTransporteConstantesFunciones.DESCRIPCION));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowServicioTransporte(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(ServicioTransporte entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ServicioTransporteDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ServicioTransporteDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ServicioTransporteDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ServicioTransporteDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ServicioTransporteConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ServicioTransporteDataAccess.TABLENAME,ServicioTransporteDataAccess.ISWITHSTOREPROCEDURES);
			
			ServicioTransporteDataAccess.setServicioTransporteOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,ServicioTransporte relserviciotransporte)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relserviciotransporte.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,ServicioTransporte relserviciotransporte)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relserviciotransporte.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,ServicioTransporte relserviciotransporte)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relserviciotransporte.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,ServicioTransporte relserviciotransporte)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,relserviciotransporte.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public Cliente getCliente(Connexion connexion,ServicioTransporte relserviciotransporte)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,relserviciotransporte.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public Cliente getClienteProveedor(Connexion connexion,ServicioTransporte relserviciotransporte)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,relserviciotransporte.getid_cliente_proveedor());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public Transportista getTransportista(Connexion connexion,ServicioTransporte relserviciotransporte)throws SQLException,Exception {

		Transportista transportista= new Transportista();

		try {
			TransportistaDataAccess transportistaDataAccess=new TransportistaDataAccess();

			transportistaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transportistaDataAccess.setConnexionType(this.connexionType);
			transportistaDataAccess.setParameterDbType(this.parameterDbType);

			transportista=transportistaDataAccess.getEntity(connexion,relserviciotransporte.getid_transportista());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transportista;

	}

	public Vehiculo getVehiculo(Connexion connexion,ServicioTransporte relserviciotransporte)throws SQLException,Exception {

		Vehiculo vehiculo= new Vehiculo();

		try {
			VehiculoDataAccess vehiculoDataAccess=new VehiculoDataAccess();

			vehiculoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			vehiculoDataAccess.setConnexionType(this.connexionType);
			vehiculoDataAccess.setParameterDbType(this.parameterDbType);

			vehiculo=vehiculoDataAccess.getEntity(connexion,relserviciotransporte.getid_vehiculo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return vehiculo;

	}

	public RutaTransporte getRutaTransporte(Connexion connexion,ServicioTransporte relserviciotransporte)throws SQLException,Exception {

		RutaTransporte rutatransporte= new RutaTransporte();

		try {
			RutaTransporteDataAccess rutatransporteDataAccess=new RutaTransporteDataAccess();

			rutatransporteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			rutatransporteDataAccess.setConnexionType(this.connexionType);
			rutatransporteDataAccess.setParameterDbType(this.parameterDbType);

			rutatransporte=rutatransporteDataAccess.getEntity(connexion,relserviciotransporte.getid_ruta_transporte());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return rutatransporte;

	}

	public DetalleActivoFijo getDetalleActivoFijo(Connexion connexion,ServicioTransporte relserviciotransporte)throws SQLException,Exception {

		DetalleActivoFijo detalleactivofijo= new DetalleActivoFijo();

		try {
			DetalleActivoFijoDataAccess detalleactivofijoDataAccess=new DetalleActivoFijoDataAccess();

			detalleactivofijoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			detalleactivofijoDataAccess.setConnexionType(this.connexionType);
			detalleactivofijoDataAccess.setParameterDbType(this.parameterDbType);

			detalleactivofijo=detalleactivofijoDataAccess.getEntity(connexion,relserviciotransporte.getid_detalle_activo_fijo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalleactivofijo;

	}


		
		public List<DetalleServicioTransporte> getDetalleServicioTransportes(Connexion connexion,ServicioTransporte serviciotransporte)throws SQLException,Exception {

		List<DetalleServicioTransporte> detalleserviciotransportes= new ArrayList<DetalleServicioTransporte>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ServicioTransporteConstantesFunciones.SCHEMA+".servicio_transporte ON "+DetalleServicioTransporteConstantesFunciones.SCHEMA+".detalle_servicio_transporte.id_servicio_transporte="+ServicioTransporteConstantesFunciones.SCHEMA+".servicio_transporte.id WHERE "+ServicioTransporteConstantesFunciones.SCHEMA+".servicio_transporte.id="+String.valueOf(serviciotransporte.getId());
			} else {
				sQuery=" INNER JOIN detalleserviciotransporte.ServicioTransporte WHERE detalleserviciotransporte.ServicioTransporte.id="+String.valueOf(serviciotransporte.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleServicioTransporteDataAccess detalleserviciotransporteDataAccess=new DetalleServicioTransporteDataAccess();

			detalleserviciotransporteDataAccess.setConnexionType(this.connexionType);
			detalleserviciotransporteDataAccess.setParameterDbType(this.parameterDbType);
			detalleserviciotransportes=detalleserviciotransporteDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalleserviciotransportes;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,ServicioTransporte serviciotransporte) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!serviciotransporte.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(serviciotransporte.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(serviciotransporte.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(serviciotransporte.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(serviciotransporte.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_cliente.setValue(serviciotransporte.getid_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cliente_proveedor=new ParameterValue<Long>();
					parameterMaintenanceValueid_cliente_proveedor.setValue(serviciotransporte.getid_cliente_proveedor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cliente_proveedor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transportista=new ParameterValue<Long>();
					parameterMaintenanceValueid_transportista.setValue(serviciotransporte.getid_transportista());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transportista);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_vehiculo=new ParameterValue<Long>();
					parameterMaintenanceValueid_vehiculo.setValue(serviciotransporte.getid_vehiculo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_vehiculo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ruta_transporte=new ParameterValue<Long>();
					parameterMaintenanceValueid_ruta_transporte.setValue(serviciotransporte.getid_ruta_transporte());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ruta_transporte);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_detalle_activo_fijo=new ParameterValue<Long>();
					parameterMaintenanceValueid_detalle_activo_fijo.setValue(serviciotransporte.getid_detalle_activo_fijo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_detalle_activo_fijo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_ingreso=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_ingreso.setValue(serviciotransporte.getfecha_ingreso());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_ingreso);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_entrega=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_entrega.setValue(serviciotransporte.getfecha_entrega());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_entrega);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo_guia1=new ParameterValue<String>();
					parameterMaintenanceValuecodigo_guia1.setValue(serviciotransporte.getcodigo_guia1());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo_guia1);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo_guia2=new ParameterValue<String>();
					parameterMaintenanceValuecodigo_guia2.setValue(serviciotransporte.getcodigo_guia2());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo_guia2);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueprecio=new ParameterValue<Double>();
					parameterMaintenanceValueprecio.setValue(serviciotransporte.getprecio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueprecio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_iva=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_iva.setValue(serviciotransporte.getvalor_iva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_iva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_total=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_total.setValue(serviciotransporte.getvalor_total());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_total);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(serviciotransporte.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!serviciotransporte.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(serviciotransporte.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(serviciotransporte.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(serviciotransporte.getId());
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
	
	public void setIsNewIsChangedFalseServicioTransporte(ServicioTransporte serviciotransporte)throws Exception  {		
		serviciotransporte.setIsNew(false);
		serviciotransporte.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseServicioTransportes(List<ServicioTransporte> serviciotransportes)throws Exception  {				
		for(ServicioTransporte serviciotransporte:serviciotransportes) {
			serviciotransporte.setIsNew(false);
			serviciotransporte.setIsChanged(false);
		}
	}
	
	public void generarExportarServicioTransporte(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
