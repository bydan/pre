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
import com.bydan.erp.inventario.util.*;//DetalleRequisicionConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class DetalleRequisicionDataAccess extends  DetalleRequisicionDataAccessAdditional{ //DetalleRequisicionDataAccessAdditional,DataAccessHelper<DetalleRequisicion>
	//static Logger logger = Logger.getLogger(DetalleRequisicionDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="detalle_requisicion";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+DetalleRequisicionConstantesFunciones.SCHEMA+"."+DetalleRequisicionConstantesFunciones.TABLENAME+"(version_row,id_requisicion,id_empresa,id_sucursal,id_ejercicio,id_periodo,id_anio,id_mes,id_bodega,id_producto,id_unidad,cantidad,descripcion,fecha_autoriza)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+DetalleRequisicionConstantesFunciones.SCHEMA+"."+DetalleRequisicionConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_requisicion=?,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_anio=?,id_mes=?,id_bodega=?,id_producto=?,id_unidad=?,cantidad=?,descripcion=?,fecha_autoriza=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+DetalleRequisicionConstantesFunciones.SCHEMA+"."+DetalleRequisicionConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select detallerequisicion from "+DetalleRequisicionConstantesFunciones.SPERSISTENCENAME+" detallerequisicion";
	public static String QUERYSELECTNATIVE="select "+DetalleRequisicionConstantesFunciones.SCHEMA+"."+DetalleRequisicionConstantesFunciones.TABLENAME+".id,"+DetalleRequisicionConstantesFunciones.SCHEMA+"."+DetalleRequisicionConstantesFunciones.TABLENAME+".version_row,"+DetalleRequisicionConstantesFunciones.SCHEMA+"."+DetalleRequisicionConstantesFunciones.TABLENAME+".id_requisicion,"+DetalleRequisicionConstantesFunciones.SCHEMA+"."+DetalleRequisicionConstantesFunciones.TABLENAME+".id_empresa,"+DetalleRequisicionConstantesFunciones.SCHEMA+"."+DetalleRequisicionConstantesFunciones.TABLENAME+".id_sucursal,"+DetalleRequisicionConstantesFunciones.SCHEMA+"."+DetalleRequisicionConstantesFunciones.TABLENAME+".id_ejercicio,"+DetalleRequisicionConstantesFunciones.SCHEMA+"."+DetalleRequisicionConstantesFunciones.TABLENAME+".id_periodo,"+DetalleRequisicionConstantesFunciones.SCHEMA+"."+DetalleRequisicionConstantesFunciones.TABLENAME+".id_anio,"+DetalleRequisicionConstantesFunciones.SCHEMA+"."+DetalleRequisicionConstantesFunciones.TABLENAME+".id_mes,"+DetalleRequisicionConstantesFunciones.SCHEMA+"."+DetalleRequisicionConstantesFunciones.TABLENAME+".id_bodega,"+DetalleRequisicionConstantesFunciones.SCHEMA+"."+DetalleRequisicionConstantesFunciones.TABLENAME+".id_producto,"+DetalleRequisicionConstantesFunciones.SCHEMA+"."+DetalleRequisicionConstantesFunciones.TABLENAME+".id_unidad,"+DetalleRequisicionConstantesFunciones.SCHEMA+"."+DetalleRequisicionConstantesFunciones.TABLENAME+".cantidad,"+DetalleRequisicionConstantesFunciones.SCHEMA+"."+DetalleRequisicionConstantesFunciones.TABLENAME+".descripcion,"+DetalleRequisicionConstantesFunciones.SCHEMA+"."+DetalleRequisicionConstantesFunciones.TABLENAME+".fecha_autoriza from "+DetalleRequisicionConstantesFunciones.SCHEMA+"."+DetalleRequisicionConstantesFunciones.TABLENAME;//+" as "+DetalleRequisicionConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+DetalleRequisicionConstantesFunciones.SCHEMA+"."+DetalleRequisicionConstantesFunciones.TABLENAME+".id,"+DetalleRequisicionConstantesFunciones.SCHEMA+"."+DetalleRequisicionConstantesFunciones.TABLENAME+".version_row from "+DetalleRequisicionConstantesFunciones.SCHEMA+"."+DetalleRequisicionConstantesFunciones.TABLENAME;//+" as "+DetalleRequisicionConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+DetalleRequisicionConstantesFunciones.SCHEMA+"."+DetalleRequisicionConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_requisicion=?,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_anio=?,id_mes=?,id_bodega=?,id_producto=?,id_unidad=?,cantidad=?,descripcion=?,fecha_autoriza=?";
	
	public static String STOREPROCEDUREINSERT="call SP_DETALLEREQUISICION_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_DETALLEREQUISICION_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_DETALLEREQUISICION_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_DETALLEREQUISICION_SELECT(?,?)";
	
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
	
	
	protected DetalleRequisicionDataAccessAdditional detallerequisicionDataAccessAdditional=null;
	
	public DetalleRequisicionDataAccessAdditional getDetalleRequisicionDataAccessAdditional() {
		return this.detallerequisicionDataAccessAdditional;
	}
	
	public void setDetalleRequisicionDataAccessAdditional(DetalleRequisicionDataAccessAdditional detallerequisicionDataAccessAdditional) {
		try {
			this.detallerequisicionDataAccessAdditional=detallerequisicionDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public DetalleRequisicionDataAccess() {
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
		DetalleRequisicionDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		DetalleRequisicionDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		DetalleRequisicionDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setDetalleRequisicionOriginal(DetalleRequisicion detallerequisicion)throws Exception  {
		detallerequisicion.setDetalleRequisicionOriginal((DetalleRequisicion)detallerequisicion.clone());		
	}
	
	public void setDetalleRequisicionsOriginal(List<DetalleRequisicion> detallerequisicions)throws Exception  {
		
		for(DetalleRequisicion detallerequisicion:detallerequisicions){
			detallerequisicion.setDetalleRequisicionOriginal((DetalleRequisicion)detallerequisicion.clone());
		}
	}
	
	public static void setDetalleRequisicionOriginalStatic(DetalleRequisicion detallerequisicion)throws Exception  {
		detallerequisicion.setDetalleRequisicionOriginal((DetalleRequisicion)detallerequisicion.clone());		
	}
	
	public static void setDetalleRequisicionsOriginalStatic(List<DetalleRequisicion> detallerequisicions)throws Exception  {
		
		for(DetalleRequisicion detallerequisicion:detallerequisicions){
			detallerequisicion.setDetalleRequisicionOriginal((DetalleRequisicion)detallerequisicion.clone());
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
	
	public  DetalleRequisicion getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		DetalleRequisicion entity = new DetalleRequisicion();		
		
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
	
	public  DetalleRequisicion getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		DetalleRequisicion entity = new DetalleRequisicion();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleRequisicionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleRequisicionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.DetalleRequisicion.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setDetalleRequisicionOriginal(new DetalleRequisicion());
      	    	entity=super.getEntity("",entity,resultSet,DetalleRequisicionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetalleRequisicion("",entity,resultSet); 
				
				//entity.setDetalleRequisicionOriginal(super.getEntity("",entity.getDetalleRequisicionOriginal(),resultSet,DetalleRequisicionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleRequisicionOriginal(this.getEntityDetalleRequisicion("",entity.getDetalleRequisicionOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseDetalleRequisicion(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  DetalleRequisicion getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetalleRequisicion entity = new DetalleRequisicion();
				
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
	
	public  DetalleRequisicion getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetalleRequisicion entity = new DetalleRequisicion();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleRequisicionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleRequisicionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleRequisicionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.DetalleRequisicion.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setDetalleRequisicionOriginal(new DetalleRequisicion());
      	    	entity=super.getEntity("",entity,resultSet,DetalleRequisicionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetalleRequisicion("",entity,resultSet);    
				
				//entity.setDetalleRequisicionOriginal(super.getEntity("",entity.getDetalleRequisicionOriginal(),resultSet,DetalleRequisicionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleRequisicionOriginal(this.getEntityDetalleRequisicion("",entity.getDetalleRequisicionOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseDetalleRequisicion(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //DetalleRequisicion
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		DetalleRequisicion entity = new DetalleRequisicion();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleRequisicionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleRequisicionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleRequisicionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.DetalleRequisicion.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseDetalleRequisicion(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<DetalleRequisicion> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetalleRequisicion> entities = new  ArrayList<DetalleRequisicion>();
		DetalleRequisicion entity = new DetalleRequisicion();		  
		
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
	
	public  List<DetalleRequisicion> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetalleRequisicion> entities = new  ArrayList<DetalleRequisicion>();
		DetalleRequisicion entity = new DetalleRequisicion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleRequisicionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleRequisicionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleRequisicionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleRequisicion();
      	    	entity=super.getEntity("",entity,resultSet,DetalleRequisicionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleRequisicion("",entity,resultSet);
      	    	
				//entity.setDetalleRequisicionOriginal( new DetalleRequisicion());
      	    	//entity.setDetalleRequisicionOriginal(super.getEntity("",entity.getDetalleRequisicionOriginal(),resultSet,DetalleRequisicionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleRequisicionOriginal(this.getEntityDetalleRequisicion("",entity.getDetalleRequisicionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleRequisicions(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleRequisicion(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetalleRequisicion> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetalleRequisicion> entities = new  ArrayList<DetalleRequisicion>();
		DetalleRequisicion entity = new DetalleRequisicion();		  
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
	
	public  List<DetalleRequisicion> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetalleRequisicion> entities = new  ArrayList<DetalleRequisicion>();
		DetalleRequisicion entity = new DetalleRequisicion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleRequisicion();
				
				if(conMapGenerico) {
					entity.inicializarMapDetalleRequisicion();
					//entity.setMapDetalleRequisicion(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapDetalleRequisicionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetalleRequisicion().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetalleRequisicionDataAccess.ISWITHSCHEMA);         		
					entity=DetalleRequisicionDataAccess.getEntityDetalleRequisicion("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetalleRequisicionOriginal( new DetalleRequisicion());
					////entity.setDetalleRequisicionOriginal(super.getEntity("",entity.getDetalleRequisicionOriginal(),resultSet,DetalleRequisicionDataAccess.ISWITHSCHEMA));         		
					////entity.setDetalleRequisicionOriginal(this.getEntityDetalleRequisicion("",entity.getDetalleRequisicionOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleRequisicions(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleRequisicion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public DetalleRequisicion getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetalleRequisicion entity = new DetalleRequisicion();		  
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
	
	public  DetalleRequisicion getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetalleRequisicion entity = new DetalleRequisicion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleRequisicion();
				
				if(conMapGenerico) {
					entity.inicializarMapDetalleRequisicion();
					//entity.setMapDetalleRequisicion(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapDetalleRequisicionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetalleRequisicion().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetalleRequisicionDataAccess.ISWITHSCHEMA);         		
					entity=DetalleRequisicionDataAccess.getEntityDetalleRequisicion("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetalleRequisicionOriginal( new DetalleRequisicion());
					////entity.setDetalleRequisicionOriginal(super.getEntity("",entity.getDetalleRequisicionOriginal(),resultSet,DetalleRequisicionDataAccess.ISWITHSCHEMA));         		
					////entity.setDetalleRequisicionOriginal(this.getEntityDetalleRequisicion("",entity.getDetalleRequisicionOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseDetalleRequisicion(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleRequisicion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static DetalleRequisicion getEntityDetalleRequisicion(String strPrefijo,DetalleRequisicion entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = DetalleRequisicion.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = DetalleRequisicion.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					DetalleRequisicionDataAccess.setFieldReflectionDetalleRequisicion(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasDetalleRequisicion=DetalleRequisicionConstantesFunciones.getTodosTiposColumnasDetalleRequisicion();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasDetalleRequisicion) {
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
							field = DetalleRequisicion.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = DetalleRequisicion.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						DetalleRequisicionDataAccess.setFieldReflectionDetalleRequisicion(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionDetalleRequisicion(Field field,String strPrefijo,String sColumn,DetalleRequisicion entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case DetalleRequisicionConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleRequisicionConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleRequisicionConstantesFunciones.IDREQUISICION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleRequisicionConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleRequisicionConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleRequisicionConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleRequisicionConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleRequisicionConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleRequisicionConstantesFunciones.IDMES:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleRequisicionConstantesFunciones.IDBODEGA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleRequisicionConstantesFunciones.IDPRODUCTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleRequisicionConstantesFunciones.IDUNIDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleRequisicionConstantesFunciones.CANTIDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleRequisicionConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleRequisicionConstantesFunciones.FECHAAUTORIZA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetalleRequisicion>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<DetalleRequisicion> entities = new  ArrayList<DetalleRequisicion>();
		DetalleRequisicion entity = new DetalleRequisicion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleRequisicionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleRequisicionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleRequisicionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new DetalleRequisicion();
					entity=super.getEntity("",entity,resultSet,DetalleRequisicionDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityDetalleRequisicion("",entity,resultSet);
					
					//entity.setDetalleRequisicionOriginal( new DetalleRequisicion());
					//entity.setDetalleRequisicionOriginal(super.getEntity("",entity.getDetalleRequisicionOriginal(),resultSet,DetalleRequisicionDataAccess.ISWITHSCHEMA));         		
					//entity.setDetalleRequisicionOriginal(this.getEntityDetalleRequisicion("",entity.getDetalleRequisicionOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseDetalleRequisicions(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleRequisicion(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetalleRequisicion>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<DetalleRequisicion> entities = new  ArrayList<DetalleRequisicion>();
		DetalleRequisicion entity = new DetalleRequisicion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleRequisicionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleRequisicionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleRequisicionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<DetalleRequisicion> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleRequisicion> entities = new  ArrayList<DetalleRequisicion>();
		DetalleRequisicion entity = new DetalleRequisicion();		  
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
	
	public  List<DetalleRequisicion> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleRequisicion> entities = new  ArrayList<DetalleRequisicion>();
		DetalleRequisicion entity = new DetalleRequisicion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleRequisicion();
      	    	entity=super.getEntity("",entity,resultSet,DetalleRequisicionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleRequisicion("",entity,resultSet);
      	    	
				//entity.setDetalleRequisicionOriginal( new DetalleRequisicion());
      	    	//entity.setDetalleRequisicionOriginal(super.getEntity("",entity.getDetalleRequisicionOriginal(),resultSet,DetalleRequisicionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleRequisicionOriginal(this.getEntityDetalleRequisicion("",entity.getDetalleRequisicionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseDetalleRequisicions(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleRequisicion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetalleRequisicion> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleRequisicion> entities = new  ArrayList<DetalleRequisicion>();
		DetalleRequisicion entity = new DetalleRequisicion();		  
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
	
	public  List<DetalleRequisicion> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleRequisicion> entities = new  ArrayList<DetalleRequisicion>();
		DetalleRequisicion entity = new DetalleRequisicion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleRequisicion();
      	    	entity=super.getEntity("",entity,resultSet,DetalleRequisicionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleRequisicion("",entity,resultSet);
      	    	
				//entity.setDetalleRequisicionOriginal( new DetalleRequisicion());
      	    	//entity.setDetalleRequisicionOriginal(super.getEntity("",entity.getDetalleRequisicionOriginal(),resultSet,DetalleRequisicionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleRequisicionOriginal(this.getEntityDetalleRequisicion("",entity.getDetalleRequisicionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleRequisicions(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public DetalleRequisicion getEntityDetalleRequisicion(String strPrefijo,DetalleRequisicion entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_requisicion(resultSet.getLong(strPrefijo+DetalleRequisicionConstantesFunciones.IDREQUISICION));
				entity.setid_empresa(resultSet.getLong(strPrefijo+DetalleRequisicionConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+DetalleRequisicionConstantesFunciones.IDSUCURSAL));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+DetalleRequisicionConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+DetalleRequisicionConstantesFunciones.IDPERIODO));
				entity.setid_anio(resultSet.getLong(strPrefijo+DetalleRequisicionConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
				entity.setid_mes(resultSet.getLong(strPrefijo+DetalleRequisicionConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
				entity.setid_bodega(resultSet.getLong(strPrefijo+DetalleRequisicionConstantesFunciones.IDBODEGA));
				entity.setid_producto(resultSet.getLong(strPrefijo+DetalleRequisicionConstantesFunciones.IDPRODUCTO));
				entity.setid_unidad(resultSet.getLong(strPrefijo+DetalleRequisicionConstantesFunciones.IDUNIDAD));
				entity.setcantidad(resultSet.getLong(strPrefijo+DetalleRequisicionConstantesFunciones.CANTIDAD));
				entity.setdescripcion(resultSet.getString(strPrefijo+DetalleRequisicionConstantesFunciones.DESCRIPCION));
				entity.setfecha_autoriza(new Date(resultSet.getDate(strPrefijo+DetalleRequisicionConstantesFunciones.FECHAAUTORIZA).getTime()));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowDetalleRequisicion(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(DetalleRequisicion entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=DetalleRequisicionDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=DetalleRequisicionDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=DetalleRequisicionDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=DetalleRequisicionDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(DetalleRequisicionConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,DetalleRequisicionDataAccess.TABLENAME,DetalleRequisicionDataAccess.ISWITHSTOREPROCEDURES);
			
			DetalleRequisicionDataAccess.setDetalleRequisicionOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Requisicion getRequisicion(Connexion connexion,DetalleRequisicion reldetallerequisicion)throws SQLException,Exception {

		Requisicion requisicion= new Requisicion();

		try {
			RequisicionDataAccess requisicionDataAccess=new RequisicionDataAccess();

			requisicionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			requisicionDataAccess.setConnexionType(this.connexionType);
			requisicionDataAccess.setParameterDbType(this.parameterDbType);

			requisicion=requisicionDataAccess.getEntity(connexion,reldetallerequisicion.getid_requisicion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return requisicion;

	}

	public Empresa getEmpresa(Connexion connexion,DetalleRequisicion reldetallerequisicion)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reldetallerequisicion.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,DetalleRequisicion reldetallerequisicion)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,reldetallerequisicion.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,DetalleRequisicion reldetallerequisicion)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,reldetallerequisicion.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,DetalleRequisicion reldetallerequisicion)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,reldetallerequisicion.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public Anio getAnio(Connexion connexion,DetalleRequisicion reldetallerequisicion)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);

			anio=anioDataAccess.getEntity(connexion,reldetallerequisicion.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Mes getMes(Connexion connexion,DetalleRequisicion reldetallerequisicion)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,reldetallerequisicion.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}

	public Bodega getBodega(Connexion connexion,DetalleRequisicion reldetallerequisicion)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);

			bodega=bodegaDataAccess.getEntity(connexion,reldetallerequisicion.getid_bodega());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}

	public Producto getProducto(Connexion connexion,DetalleRequisicion reldetallerequisicion)throws SQLException,Exception {

		Producto producto= new Producto();

		try {
			ProductoDataAccess productoDataAccess=new ProductoDataAccess();

			productoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			productoDataAccess.setConnexionType(this.connexionType);
			productoDataAccess.setParameterDbType(this.parameterDbType);

			producto=productoDataAccess.getEntity(connexion,reldetallerequisicion.getid_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return producto;

	}

	public Unidad getUnidad(Connexion connexion,DetalleRequisicion reldetallerequisicion)throws SQLException,Exception {

		Unidad unidad= new Unidad();

		try {
			UnidadDataAccess unidadDataAccess=new UnidadDataAccess();

			unidadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			unidadDataAccess.setConnexionType(this.connexionType);
			unidadDataAccess.setParameterDbType(this.parameterDbType);

			unidad=unidadDataAccess.getEntity(connexion,reldetallerequisicion.getid_unidad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return unidad;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,DetalleRequisicion detallerequisicion) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!detallerequisicion.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_requisicion=new ParameterValue<Long>();
					parameterMaintenanceValueid_requisicion.setValue(detallerequisicion.getid_requisicion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_requisicion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(detallerequisicion.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(detallerequisicion.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(detallerequisicion.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(detallerequisicion.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_anio=new ParameterValue<Long>();
					parameterMaintenanceValueid_anio.setValue(detallerequisicion.getid_anio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_anio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes.setValue(detallerequisicion.getid_mes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_bodega=new ParameterValue<Long>();
					parameterMaintenanceValueid_bodega.setValue(detallerequisicion.getid_bodega());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_bodega);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_producto=new ParameterValue<Long>();
					parameterMaintenanceValueid_producto.setValue(detallerequisicion.getid_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_producto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_unidad=new ParameterValue<Long>();
					parameterMaintenanceValueid_unidad.setValue(detallerequisicion.getid_unidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_unidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValuecantidad=new ParameterValue<Long>();
					parameterMaintenanceValuecantidad.setValue(detallerequisicion.getcantidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecantidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(detallerequisicion.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_autoriza=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_autoriza.setValue(detallerequisicion.getfecha_autoriza());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_autoriza);
					parametersTemp.add(parameterMaintenance);
					
						if(!detallerequisicion.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(detallerequisicion.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(detallerequisicion.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(detallerequisicion.getId());
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
	
	public void setIsNewIsChangedFalseDetalleRequisicion(DetalleRequisicion detallerequisicion)throws Exception  {		
		detallerequisicion.setIsNew(false);
		detallerequisicion.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseDetalleRequisicions(List<DetalleRequisicion> detallerequisicions)throws Exception  {				
		for(DetalleRequisicion detallerequisicion:detallerequisicions) {
			detallerequisicion.setIsNew(false);
			detallerequisicion.setIsChanged(false);
		}
	}
	
	public void generarExportarDetalleRequisicion(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
