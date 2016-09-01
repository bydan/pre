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
import com.bydan.erp.cartera.util.*;//DetalleEvaluacionProveedorConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class DetalleEvaluacionProveedorDataAccess extends  DetalleEvaluacionProveedorDataAccessAdditional{ //DetalleEvaluacionProveedorDataAccessAdditional,DataAccessHelper<DetalleEvaluacionProveedor>
	//static Logger logger = Logger.getLogger(DetalleEvaluacionProveedorDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="detalle_evaluacion_proveedor";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+DetalleEvaluacionProveedorConstantesFunciones.SCHEMA+"."+DetalleEvaluacionProveedorConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_ejercicio,id_periodo,id_evaluacion_proveedor,id_pregunta_evaluacion,id_sub_pregunta_evaluacion,id_si_no,descripcion)values(current_timestamp,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+DetalleEvaluacionProveedorConstantesFunciones.SCHEMA+"."+DetalleEvaluacionProveedorConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_evaluacion_proveedor=?,id_pregunta_evaluacion=?,id_sub_pregunta_evaluacion=?,id_si_no=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+DetalleEvaluacionProveedorConstantesFunciones.SCHEMA+"."+DetalleEvaluacionProveedorConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select detalleevaluacionproveedor from "+DetalleEvaluacionProveedorConstantesFunciones.SPERSISTENCENAME+" detalleevaluacionproveedor";
	public static String QUERYSELECTNATIVE="select "+DetalleEvaluacionProveedorConstantesFunciones.SCHEMA+"."+DetalleEvaluacionProveedorConstantesFunciones.TABLENAME+".id,"+DetalleEvaluacionProveedorConstantesFunciones.SCHEMA+"."+DetalleEvaluacionProveedorConstantesFunciones.TABLENAME+".version_row,"+DetalleEvaluacionProveedorConstantesFunciones.SCHEMA+"."+DetalleEvaluacionProveedorConstantesFunciones.TABLENAME+".id_empresa,"+DetalleEvaluacionProveedorConstantesFunciones.SCHEMA+"."+DetalleEvaluacionProveedorConstantesFunciones.TABLENAME+".id_sucursal,"+DetalleEvaluacionProveedorConstantesFunciones.SCHEMA+"."+DetalleEvaluacionProveedorConstantesFunciones.TABLENAME+".id_ejercicio,"+DetalleEvaluacionProveedorConstantesFunciones.SCHEMA+"."+DetalleEvaluacionProveedorConstantesFunciones.TABLENAME+".id_periodo,"+DetalleEvaluacionProveedorConstantesFunciones.SCHEMA+"."+DetalleEvaluacionProveedorConstantesFunciones.TABLENAME+".id_evaluacion_proveedor,"+DetalleEvaluacionProveedorConstantesFunciones.SCHEMA+"."+DetalleEvaluacionProveedorConstantesFunciones.TABLENAME+".id_pregunta_evaluacion,"+DetalleEvaluacionProveedorConstantesFunciones.SCHEMA+"."+DetalleEvaluacionProveedorConstantesFunciones.TABLENAME+".id_sub_pregunta_evaluacion,"+DetalleEvaluacionProveedorConstantesFunciones.SCHEMA+"."+DetalleEvaluacionProveedorConstantesFunciones.TABLENAME+".id_si_no,"+DetalleEvaluacionProveedorConstantesFunciones.SCHEMA+"."+DetalleEvaluacionProveedorConstantesFunciones.TABLENAME+".descripcion from "+DetalleEvaluacionProveedorConstantesFunciones.SCHEMA+"."+DetalleEvaluacionProveedorConstantesFunciones.TABLENAME;//+" as "+DetalleEvaluacionProveedorConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+DetalleEvaluacionProveedorConstantesFunciones.SCHEMA+"."+DetalleEvaluacionProveedorConstantesFunciones.TABLENAME+".id,"+DetalleEvaluacionProveedorConstantesFunciones.SCHEMA+"."+DetalleEvaluacionProveedorConstantesFunciones.TABLENAME+".version_row from "+DetalleEvaluacionProveedorConstantesFunciones.SCHEMA+"."+DetalleEvaluacionProveedorConstantesFunciones.TABLENAME;//+" as "+DetalleEvaluacionProveedorConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+DetalleEvaluacionProveedorConstantesFunciones.SCHEMA+"."+DetalleEvaluacionProveedorConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_evaluacion_proveedor=?,id_pregunta_evaluacion=?,id_sub_pregunta_evaluacion=?,id_si_no=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_DETALLEEVALUACIONPROVEEDOR_INSERT(?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_DETALLEEVALUACIONPROVEEDOR_UPDATE(?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_DETALLEEVALUACIONPROVEEDOR_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_DETALLEEVALUACIONPROVEEDOR_SELECT(?,?)";
	
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
	
	
	protected DetalleEvaluacionProveedorDataAccessAdditional detalleevaluacionproveedorDataAccessAdditional=null;
	
	public DetalleEvaluacionProveedorDataAccessAdditional getDetalleEvaluacionProveedorDataAccessAdditional() {
		return this.detalleevaluacionproveedorDataAccessAdditional;
	}
	
	public void setDetalleEvaluacionProveedorDataAccessAdditional(DetalleEvaluacionProveedorDataAccessAdditional detalleevaluacionproveedorDataAccessAdditional) {
		try {
			this.detalleevaluacionproveedorDataAccessAdditional=detalleevaluacionproveedorDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public DetalleEvaluacionProveedorDataAccess() {
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
		DetalleEvaluacionProveedorDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		DetalleEvaluacionProveedorDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		DetalleEvaluacionProveedorDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setDetalleEvaluacionProveedorOriginal(DetalleEvaluacionProveedor detalleevaluacionproveedor)throws Exception  {
		detalleevaluacionproveedor.setDetalleEvaluacionProveedorOriginal((DetalleEvaluacionProveedor)detalleevaluacionproveedor.clone());		
	}
	
	public void setDetalleEvaluacionProveedorsOriginal(List<DetalleEvaluacionProveedor> detalleevaluacionproveedors)throws Exception  {
		
		for(DetalleEvaluacionProveedor detalleevaluacionproveedor:detalleevaluacionproveedors){
			detalleevaluacionproveedor.setDetalleEvaluacionProveedorOriginal((DetalleEvaluacionProveedor)detalleevaluacionproveedor.clone());
		}
	}
	
	public static void setDetalleEvaluacionProveedorOriginalStatic(DetalleEvaluacionProveedor detalleevaluacionproveedor)throws Exception  {
		detalleevaluacionproveedor.setDetalleEvaluacionProveedorOriginal((DetalleEvaluacionProveedor)detalleevaluacionproveedor.clone());		
	}
	
	public static void setDetalleEvaluacionProveedorsOriginalStatic(List<DetalleEvaluacionProveedor> detalleevaluacionproveedors)throws Exception  {
		
		for(DetalleEvaluacionProveedor detalleevaluacionproveedor:detalleevaluacionproveedors){
			detalleevaluacionproveedor.setDetalleEvaluacionProveedorOriginal((DetalleEvaluacionProveedor)detalleevaluacionproveedor.clone());
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
	
	public  DetalleEvaluacionProveedor getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		DetalleEvaluacionProveedor entity = new DetalleEvaluacionProveedor();		
		
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
	
	public  DetalleEvaluacionProveedor getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		DetalleEvaluacionProveedor entity = new DetalleEvaluacionProveedor();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleEvaluacionProveedorDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleEvaluacionProveedorDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Cartera.DetalleEvaluacionProveedor.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setDetalleEvaluacionProveedorOriginal(new DetalleEvaluacionProveedor());
      	    	entity=super.getEntity("",entity,resultSet,DetalleEvaluacionProveedorDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetalleEvaluacionProveedor("",entity,resultSet); 
				
				//entity.setDetalleEvaluacionProveedorOriginal(super.getEntity("",entity.getDetalleEvaluacionProveedorOriginal(),resultSet,DetalleEvaluacionProveedorDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleEvaluacionProveedorOriginal(this.getEntityDetalleEvaluacionProveedor("",entity.getDetalleEvaluacionProveedorOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseDetalleEvaluacionProveedor(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  DetalleEvaluacionProveedor getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetalleEvaluacionProveedor entity = new DetalleEvaluacionProveedor();
				
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
	
	public  DetalleEvaluacionProveedor getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetalleEvaluacionProveedor entity = new DetalleEvaluacionProveedor();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleEvaluacionProveedorDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleEvaluacionProveedorDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleEvaluacionProveedorDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.DetalleEvaluacionProveedor.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setDetalleEvaluacionProveedorOriginal(new DetalleEvaluacionProveedor());
      	    	entity=super.getEntity("",entity,resultSet,DetalleEvaluacionProveedorDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetalleEvaluacionProveedor("",entity,resultSet);    
				
				//entity.setDetalleEvaluacionProveedorOriginal(super.getEntity("",entity.getDetalleEvaluacionProveedorOriginal(),resultSet,DetalleEvaluacionProveedorDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleEvaluacionProveedorOriginal(this.getEntityDetalleEvaluacionProveedor("",entity.getDetalleEvaluacionProveedorOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseDetalleEvaluacionProveedor(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //DetalleEvaluacionProveedor
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		DetalleEvaluacionProveedor entity = new DetalleEvaluacionProveedor();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleEvaluacionProveedorDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleEvaluacionProveedorDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleEvaluacionProveedorDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.DetalleEvaluacionProveedor.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseDetalleEvaluacionProveedor(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<DetalleEvaluacionProveedor> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetalleEvaluacionProveedor> entities = new  ArrayList<DetalleEvaluacionProveedor>();
		DetalleEvaluacionProveedor entity = new DetalleEvaluacionProveedor();		  
		
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
	
	public  List<DetalleEvaluacionProveedor> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetalleEvaluacionProveedor> entities = new  ArrayList<DetalleEvaluacionProveedor>();
		DetalleEvaluacionProveedor entity = new DetalleEvaluacionProveedor();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleEvaluacionProveedorDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleEvaluacionProveedorDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleEvaluacionProveedorDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleEvaluacionProveedor();
      	    	entity=super.getEntity("",entity,resultSet,DetalleEvaluacionProveedorDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleEvaluacionProveedor("",entity,resultSet);
      	    	
				//entity.setDetalleEvaluacionProveedorOriginal( new DetalleEvaluacionProveedor());
      	    	//entity.setDetalleEvaluacionProveedorOriginal(super.getEntity("",entity.getDetalleEvaluacionProveedorOriginal(),resultSet,DetalleEvaluacionProveedorDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleEvaluacionProveedorOriginal(this.getEntityDetalleEvaluacionProveedor("",entity.getDetalleEvaluacionProveedorOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleEvaluacionProveedors(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleEvaluacionProveedor(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetalleEvaluacionProveedor> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetalleEvaluacionProveedor> entities = new  ArrayList<DetalleEvaluacionProveedor>();
		DetalleEvaluacionProveedor entity = new DetalleEvaluacionProveedor();		  
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
	
	public  List<DetalleEvaluacionProveedor> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetalleEvaluacionProveedor> entities = new  ArrayList<DetalleEvaluacionProveedor>();
		DetalleEvaluacionProveedor entity = new DetalleEvaluacionProveedor();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleEvaluacionProveedor();
				
				if(conMapGenerico) {
					entity.inicializarMapDetalleEvaluacionProveedor();
					//entity.setMapDetalleEvaluacionProveedor(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapDetalleEvaluacionProveedorValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetalleEvaluacionProveedor().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetalleEvaluacionProveedorDataAccess.ISWITHSCHEMA);         		
					entity=DetalleEvaluacionProveedorDataAccess.getEntityDetalleEvaluacionProveedor("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetalleEvaluacionProveedorOriginal( new DetalleEvaluacionProveedor());
					////entity.setDetalleEvaluacionProveedorOriginal(super.getEntity("",entity.getDetalleEvaluacionProveedorOriginal(),resultSet,DetalleEvaluacionProveedorDataAccess.ISWITHSCHEMA));         		
					////entity.setDetalleEvaluacionProveedorOriginal(this.getEntityDetalleEvaluacionProveedor("",entity.getDetalleEvaluacionProveedorOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleEvaluacionProveedors(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleEvaluacionProveedor(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public DetalleEvaluacionProveedor getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetalleEvaluacionProveedor entity = new DetalleEvaluacionProveedor();		  
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
	
	public  DetalleEvaluacionProveedor getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetalleEvaluacionProveedor entity = new DetalleEvaluacionProveedor();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleEvaluacionProveedor();
				
				if(conMapGenerico) {
					entity.inicializarMapDetalleEvaluacionProveedor();
					//entity.setMapDetalleEvaluacionProveedor(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapDetalleEvaluacionProveedorValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetalleEvaluacionProveedor().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetalleEvaluacionProveedorDataAccess.ISWITHSCHEMA);         		
					entity=DetalleEvaluacionProveedorDataAccess.getEntityDetalleEvaluacionProveedor("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetalleEvaluacionProveedorOriginal( new DetalleEvaluacionProveedor());
					////entity.setDetalleEvaluacionProveedorOriginal(super.getEntity("",entity.getDetalleEvaluacionProveedorOriginal(),resultSet,DetalleEvaluacionProveedorDataAccess.ISWITHSCHEMA));         		
					////entity.setDetalleEvaluacionProveedorOriginal(this.getEntityDetalleEvaluacionProveedor("",entity.getDetalleEvaluacionProveedorOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseDetalleEvaluacionProveedor(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleEvaluacionProveedor(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static DetalleEvaluacionProveedor getEntityDetalleEvaluacionProveedor(String strPrefijo,DetalleEvaluacionProveedor entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = DetalleEvaluacionProveedor.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = DetalleEvaluacionProveedor.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					DetalleEvaluacionProveedorDataAccess.setFieldReflectionDetalleEvaluacionProveedor(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasDetalleEvaluacionProveedor=DetalleEvaluacionProveedorConstantesFunciones.getTodosTiposColumnasDetalleEvaluacionProveedor();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasDetalleEvaluacionProveedor) {
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
							field = DetalleEvaluacionProveedor.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = DetalleEvaluacionProveedor.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						DetalleEvaluacionProveedorDataAccess.setFieldReflectionDetalleEvaluacionProveedor(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionDetalleEvaluacionProveedor(Field field,String strPrefijo,String sColumn,DetalleEvaluacionProveedor entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case DetalleEvaluacionProveedorConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleEvaluacionProveedorConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleEvaluacionProveedorConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleEvaluacionProveedorConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleEvaluacionProveedorConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleEvaluacionProveedorConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleEvaluacionProveedorConstantesFunciones.IDEVALUACIONPROVEEDOR:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleEvaluacionProveedorConstantesFunciones.IDPREGUNTAEVALUACION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleEvaluacionProveedorConstantesFunciones.IDSUBPREGUNTAEVALUACION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleEvaluacionProveedorConstantesFunciones.IDSINO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleEvaluacionProveedorConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetalleEvaluacionProveedor>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<DetalleEvaluacionProveedor> entities = new  ArrayList<DetalleEvaluacionProveedor>();
		DetalleEvaluacionProveedor entity = new DetalleEvaluacionProveedor();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleEvaluacionProveedorDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleEvaluacionProveedorDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleEvaluacionProveedorDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new DetalleEvaluacionProveedor();
					entity=super.getEntity("",entity,resultSet,DetalleEvaluacionProveedorDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityDetalleEvaluacionProveedor("",entity,resultSet);
					
					//entity.setDetalleEvaluacionProveedorOriginal( new DetalleEvaluacionProveedor());
					//entity.setDetalleEvaluacionProveedorOriginal(super.getEntity("",entity.getDetalleEvaluacionProveedorOriginal(),resultSet,DetalleEvaluacionProveedorDataAccess.ISWITHSCHEMA));         		
					//entity.setDetalleEvaluacionProveedorOriginal(this.getEntityDetalleEvaluacionProveedor("",entity.getDetalleEvaluacionProveedorOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseDetalleEvaluacionProveedors(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleEvaluacionProveedor(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetalleEvaluacionProveedor>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<DetalleEvaluacionProveedor> entities = new  ArrayList<DetalleEvaluacionProveedor>();
		DetalleEvaluacionProveedor entity = new DetalleEvaluacionProveedor();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleEvaluacionProveedorDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleEvaluacionProveedorDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleEvaluacionProveedorDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<DetalleEvaluacionProveedor> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleEvaluacionProveedor> entities = new  ArrayList<DetalleEvaluacionProveedor>();
		DetalleEvaluacionProveedor entity = new DetalleEvaluacionProveedor();		  
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
	
	public  List<DetalleEvaluacionProveedor> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleEvaluacionProveedor> entities = new  ArrayList<DetalleEvaluacionProveedor>();
		DetalleEvaluacionProveedor entity = new DetalleEvaluacionProveedor();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleEvaluacionProveedor();
      	    	entity=super.getEntity("",entity,resultSet,DetalleEvaluacionProveedorDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleEvaluacionProveedor("",entity,resultSet);
      	    	
				//entity.setDetalleEvaluacionProveedorOriginal( new DetalleEvaluacionProveedor());
      	    	//entity.setDetalleEvaluacionProveedorOriginal(super.getEntity("",entity.getDetalleEvaluacionProveedorOriginal(),resultSet,DetalleEvaluacionProveedorDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleEvaluacionProveedorOriginal(this.getEntityDetalleEvaluacionProveedor("",entity.getDetalleEvaluacionProveedorOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseDetalleEvaluacionProveedors(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleEvaluacionProveedor(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetalleEvaluacionProveedor> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleEvaluacionProveedor> entities = new  ArrayList<DetalleEvaluacionProveedor>();
		DetalleEvaluacionProveedor entity = new DetalleEvaluacionProveedor();		  
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
	
	public  List<DetalleEvaluacionProveedor> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleEvaluacionProveedor> entities = new  ArrayList<DetalleEvaluacionProveedor>();
		DetalleEvaluacionProveedor entity = new DetalleEvaluacionProveedor();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleEvaluacionProveedor();
      	    	entity=super.getEntity("",entity,resultSet,DetalleEvaluacionProveedorDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleEvaluacionProveedor("",entity,resultSet);
      	    	
				//entity.setDetalleEvaluacionProveedorOriginal( new DetalleEvaluacionProveedor());
      	    	//entity.setDetalleEvaluacionProveedorOriginal(super.getEntity("",entity.getDetalleEvaluacionProveedorOriginal(),resultSet,DetalleEvaluacionProveedorDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleEvaluacionProveedorOriginal(this.getEntityDetalleEvaluacionProveedor("",entity.getDetalleEvaluacionProveedorOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleEvaluacionProveedors(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public DetalleEvaluacionProveedor getEntityDetalleEvaluacionProveedor(String strPrefijo,DetalleEvaluacionProveedor entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+DetalleEvaluacionProveedorConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+DetalleEvaluacionProveedorConstantesFunciones.IDSUCURSAL));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+DetalleEvaluacionProveedorConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+DetalleEvaluacionProveedorConstantesFunciones.IDPERIODO));
				entity.setid_evaluacion_proveedor(resultSet.getLong(strPrefijo+DetalleEvaluacionProveedorConstantesFunciones.IDEVALUACIONPROVEEDOR));
				entity.setid_pregunta_evaluacion(resultSet.getLong(strPrefijo+DetalleEvaluacionProveedorConstantesFunciones.IDPREGUNTAEVALUACION));
				entity.setid_sub_pregunta_evaluacion(resultSet.getLong(strPrefijo+DetalleEvaluacionProveedorConstantesFunciones.IDSUBPREGUNTAEVALUACION));
				entity.setid_si_no(resultSet.getLong(strPrefijo+DetalleEvaluacionProveedorConstantesFunciones.IDSINO));
				entity.setdescripcion(resultSet.getString(strPrefijo+DetalleEvaluacionProveedorConstantesFunciones.DESCRIPCION));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowDetalleEvaluacionProveedor(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(DetalleEvaluacionProveedor entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=DetalleEvaluacionProveedorDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=DetalleEvaluacionProveedorDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=DetalleEvaluacionProveedorDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=DetalleEvaluacionProveedorDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(DetalleEvaluacionProveedorConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,DetalleEvaluacionProveedorDataAccess.TABLENAME,DetalleEvaluacionProveedorDataAccess.ISWITHSTOREPROCEDURES);
			
			DetalleEvaluacionProveedorDataAccess.setDetalleEvaluacionProveedorOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,DetalleEvaluacionProveedor reldetalleevaluacionproveedor)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reldetalleevaluacionproveedor.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,DetalleEvaluacionProveedor reldetalleevaluacionproveedor)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,reldetalleevaluacionproveedor.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,DetalleEvaluacionProveedor reldetalleevaluacionproveedor)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,reldetalleevaluacionproveedor.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,DetalleEvaluacionProveedor reldetalleevaluacionproveedor)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,reldetalleevaluacionproveedor.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public EvaluacionProveedor getEvaluacionProveedor(Connexion connexion,DetalleEvaluacionProveedor reldetalleevaluacionproveedor)throws SQLException,Exception {

		EvaluacionProveedor evaluacionproveedor= new EvaluacionProveedor();

		try {
			EvaluacionProveedorDataAccess evaluacionproveedorDataAccess=new EvaluacionProveedorDataAccess();

			evaluacionproveedorDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			evaluacionproveedorDataAccess.setConnexionType(this.connexionType);
			evaluacionproveedorDataAccess.setParameterDbType(this.parameterDbType);

			evaluacionproveedor=evaluacionproveedorDataAccess.getEntity(connexion,reldetalleevaluacionproveedor.getid_evaluacion_proveedor());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return evaluacionproveedor;

	}

	public PreguntaEvaluacion getPreguntaEvaluacion(Connexion connexion,DetalleEvaluacionProveedor reldetalleevaluacionproveedor)throws SQLException,Exception {

		PreguntaEvaluacion preguntaevaluacion= new PreguntaEvaluacion();

		try {
			PreguntaEvaluacionDataAccess preguntaevaluacionDataAccess=new PreguntaEvaluacionDataAccess();

			preguntaevaluacionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			preguntaevaluacionDataAccess.setConnexionType(this.connexionType);
			preguntaevaluacionDataAccess.setParameterDbType(this.parameterDbType);

			preguntaevaluacion=preguntaevaluacionDataAccess.getEntity(connexion,reldetalleevaluacionproveedor.getid_pregunta_evaluacion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return preguntaevaluacion;

	}

	public SubPreguntaEvaluacion getSubPreguntaEvaluacion(Connexion connexion,DetalleEvaluacionProveedor reldetalleevaluacionproveedor)throws SQLException,Exception {

		SubPreguntaEvaluacion subpreguntaevaluacion= new SubPreguntaEvaluacion();

		try {
			SubPreguntaEvaluacionDataAccess subpreguntaevaluacionDataAccess=new SubPreguntaEvaluacionDataAccess();

			subpreguntaevaluacionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			subpreguntaevaluacionDataAccess.setConnexionType(this.connexionType);
			subpreguntaevaluacionDataAccess.setParameterDbType(this.parameterDbType);

			subpreguntaevaluacion=subpreguntaevaluacionDataAccess.getEntity(connexion,reldetalleevaluacionproveedor.getid_sub_pregunta_evaluacion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return subpreguntaevaluacion;

	}

	public SiNo getSiNo(Connexion connexion,DetalleEvaluacionProveedor reldetalleevaluacionproveedor)throws SQLException,Exception {

		SiNo sino= new SiNo();

		try {
			SiNoDataAccess sinoDataAccess=new SiNoDataAccess();

			sinoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sinoDataAccess.setConnexionType(this.connexionType);
			sinoDataAccess.setParameterDbType(this.parameterDbType);

			sino=sinoDataAccess.getEntity(connexion,reldetalleevaluacionproveedor.getid_si_no());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sino;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,DetalleEvaluacionProveedor detalleevaluacionproveedor) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!detalleevaluacionproveedor.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(detalleevaluacionproveedor.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(detalleevaluacionproveedor.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(detalleevaluacionproveedor.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(detalleevaluacionproveedor.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_evaluacion_proveedor=new ParameterValue<Long>();
					parameterMaintenanceValueid_evaluacion_proveedor.setValue(detalleevaluacionproveedor.getid_evaluacion_proveedor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_evaluacion_proveedor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_pregunta_evaluacion=new ParameterValue<Long>();
					parameterMaintenanceValueid_pregunta_evaluacion.setValue(detalleevaluacionproveedor.getid_pregunta_evaluacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_pregunta_evaluacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sub_pregunta_evaluacion=new ParameterValue<Long>();
					parameterMaintenanceValueid_sub_pregunta_evaluacion.setValue(detalleevaluacionproveedor.getid_sub_pregunta_evaluacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sub_pregunta_evaluacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_si_no=new ParameterValue<Long>();
					parameterMaintenanceValueid_si_no.setValue(detalleevaluacionproveedor.getid_si_no());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_si_no);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(detalleevaluacionproveedor.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!detalleevaluacionproveedor.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(detalleevaluacionproveedor.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(detalleevaluacionproveedor.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(detalleevaluacionproveedor.getId());
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
	
	public void setIsNewIsChangedFalseDetalleEvaluacionProveedor(DetalleEvaluacionProveedor detalleevaluacionproveedor)throws Exception  {		
		detalleevaluacionproveedor.setIsNew(false);
		detalleevaluacionproveedor.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseDetalleEvaluacionProveedors(List<DetalleEvaluacionProveedor> detalleevaluacionproveedors)throws Exception  {				
		for(DetalleEvaluacionProveedor detalleevaluacionproveedor:detalleevaluacionproveedors) {
			detalleevaluacionproveedor.setIsNew(false);
			detalleevaluacionproveedor.setIsChanged(false);
		}
	}
	
	public void generarExportarDetalleEvaluacionProveedor(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
