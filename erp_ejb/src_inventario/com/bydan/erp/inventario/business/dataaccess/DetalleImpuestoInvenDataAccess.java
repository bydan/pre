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
import com.bydan.erp.inventario.util.*;//DetalleImpuestoInvenConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class DetalleImpuestoInvenDataAccess extends  DetalleImpuestoInvenDataAccessAdditional{ //DetalleImpuestoInvenDataAccessAdditional,DataAccessHelper<DetalleImpuestoInven>
	//static Logger logger = Logger.getLogger(DetalleImpuestoInvenDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="detalle_impuesto_inven";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+DetalleImpuestoInvenConstantesFunciones.SCHEMA+"."+DetalleImpuestoInvenConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_bodega,id_producto,id_impuesto_inven,porcentaje,valor,descripcion)values(current_timestamp,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+DetalleImpuestoInvenConstantesFunciones.SCHEMA+"."+DetalleImpuestoInvenConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_bodega=?,id_producto=?,id_impuesto_inven=?,porcentaje=?,valor=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+DetalleImpuestoInvenConstantesFunciones.SCHEMA+"."+DetalleImpuestoInvenConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select detalleimpuestoinven from "+DetalleImpuestoInvenConstantesFunciones.SPERSISTENCENAME+" detalleimpuestoinven";
	public static String QUERYSELECTNATIVE="select "+DetalleImpuestoInvenConstantesFunciones.SCHEMA+"."+DetalleImpuestoInvenConstantesFunciones.TABLENAME+".id,"+DetalleImpuestoInvenConstantesFunciones.SCHEMA+"."+DetalleImpuestoInvenConstantesFunciones.TABLENAME+".version_row,"+DetalleImpuestoInvenConstantesFunciones.SCHEMA+"."+DetalleImpuestoInvenConstantesFunciones.TABLENAME+".id_empresa,"+DetalleImpuestoInvenConstantesFunciones.SCHEMA+"."+DetalleImpuestoInvenConstantesFunciones.TABLENAME+".id_sucursal,"+DetalleImpuestoInvenConstantesFunciones.SCHEMA+"."+DetalleImpuestoInvenConstantesFunciones.TABLENAME+".id_bodega,"+DetalleImpuestoInvenConstantesFunciones.SCHEMA+"."+DetalleImpuestoInvenConstantesFunciones.TABLENAME+".id_producto,"+DetalleImpuestoInvenConstantesFunciones.SCHEMA+"."+DetalleImpuestoInvenConstantesFunciones.TABLENAME+".id_impuesto_inven,"+DetalleImpuestoInvenConstantesFunciones.SCHEMA+"."+DetalleImpuestoInvenConstantesFunciones.TABLENAME+".porcentaje,"+DetalleImpuestoInvenConstantesFunciones.SCHEMA+"."+DetalleImpuestoInvenConstantesFunciones.TABLENAME+".valor,"+DetalleImpuestoInvenConstantesFunciones.SCHEMA+"."+DetalleImpuestoInvenConstantesFunciones.TABLENAME+".descripcion from "+DetalleImpuestoInvenConstantesFunciones.SCHEMA+"."+DetalleImpuestoInvenConstantesFunciones.TABLENAME;//+" as "+DetalleImpuestoInvenConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+DetalleImpuestoInvenConstantesFunciones.SCHEMA+"."+DetalleImpuestoInvenConstantesFunciones.TABLENAME+".id,"+DetalleImpuestoInvenConstantesFunciones.SCHEMA+"."+DetalleImpuestoInvenConstantesFunciones.TABLENAME+".version_row from "+DetalleImpuestoInvenConstantesFunciones.SCHEMA+"."+DetalleImpuestoInvenConstantesFunciones.TABLENAME;//+" as "+DetalleImpuestoInvenConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+DetalleImpuestoInvenConstantesFunciones.SCHEMA+"."+DetalleImpuestoInvenConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_bodega=?,id_producto=?,id_impuesto_inven=?,porcentaje=?,valor=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_DETALLEIMPUESTOINVEN_INSERT(?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_DETALLEIMPUESTOINVEN_UPDATE(?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_DETALLEIMPUESTOINVEN_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_DETALLEIMPUESTOINVEN_SELECT(?,?)";
	
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
	
	
	protected DetalleImpuestoInvenDataAccessAdditional detalleimpuestoinvenDataAccessAdditional=null;
	
	public DetalleImpuestoInvenDataAccessAdditional getDetalleImpuestoInvenDataAccessAdditional() {
		return this.detalleimpuestoinvenDataAccessAdditional;
	}
	
	public void setDetalleImpuestoInvenDataAccessAdditional(DetalleImpuestoInvenDataAccessAdditional detalleimpuestoinvenDataAccessAdditional) {
		try {
			this.detalleimpuestoinvenDataAccessAdditional=detalleimpuestoinvenDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public DetalleImpuestoInvenDataAccess() {
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
		DetalleImpuestoInvenDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		DetalleImpuestoInvenDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		DetalleImpuestoInvenDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setDetalleImpuestoInvenOriginal(DetalleImpuestoInven detalleimpuestoinven)throws Exception  {
		detalleimpuestoinven.setDetalleImpuestoInvenOriginal((DetalleImpuestoInven)detalleimpuestoinven.clone());		
	}
	
	public void setDetalleImpuestoInvensOriginal(List<DetalleImpuestoInven> detalleimpuestoinvens)throws Exception  {
		
		for(DetalleImpuestoInven detalleimpuestoinven:detalleimpuestoinvens){
			detalleimpuestoinven.setDetalleImpuestoInvenOriginal((DetalleImpuestoInven)detalleimpuestoinven.clone());
		}
	}
	
	public static void setDetalleImpuestoInvenOriginalStatic(DetalleImpuestoInven detalleimpuestoinven)throws Exception  {
		detalleimpuestoinven.setDetalleImpuestoInvenOriginal((DetalleImpuestoInven)detalleimpuestoinven.clone());		
	}
	
	public static void setDetalleImpuestoInvensOriginalStatic(List<DetalleImpuestoInven> detalleimpuestoinvens)throws Exception  {
		
		for(DetalleImpuestoInven detalleimpuestoinven:detalleimpuestoinvens){
			detalleimpuestoinven.setDetalleImpuestoInvenOriginal((DetalleImpuestoInven)detalleimpuestoinven.clone());
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
	
	public  DetalleImpuestoInven getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		DetalleImpuestoInven entity = new DetalleImpuestoInven();		
		
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
	
	public  DetalleImpuestoInven getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		DetalleImpuestoInven entity = new DetalleImpuestoInven();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleImpuestoInvenDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleImpuestoInvenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.DetalleImpuestoInven.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setDetalleImpuestoInvenOriginal(new DetalleImpuestoInven());
      	    	entity=super.getEntity("",entity,resultSet,DetalleImpuestoInvenDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetalleImpuestoInven("",entity,resultSet); 
				
				//entity.setDetalleImpuestoInvenOriginal(super.getEntity("",entity.getDetalleImpuestoInvenOriginal(),resultSet,DetalleImpuestoInvenDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleImpuestoInvenOriginal(this.getEntityDetalleImpuestoInven("",entity.getDetalleImpuestoInvenOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseDetalleImpuestoInven(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  DetalleImpuestoInven getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetalleImpuestoInven entity = new DetalleImpuestoInven();
				
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
	
	public  DetalleImpuestoInven getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetalleImpuestoInven entity = new DetalleImpuestoInven();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleImpuestoInvenDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleImpuestoInvenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleImpuestoInvenDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.DetalleImpuestoInven.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setDetalleImpuestoInvenOriginal(new DetalleImpuestoInven());
      	    	entity=super.getEntity("",entity,resultSet,DetalleImpuestoInvenDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetalleImpuestoInven("",entity,resultSet);    
				
				//entity.setDetalleImpuestoInvenOriginal(super.getEntity("",entity.getDetalleImpuestoInvenOriginal(),resultSet,DetalleImpuestoInvenDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleImpuestoInvenOriginal(this.getEntityDetalleImpuestoInven("",entity.getDetalleImpuestoInvenOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseDetalleImpuestoInven(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //DetalleImpuestoInven
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		DetalleImpuestoInven entity = new DetalleImpuestoInven();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleImpuestoInvenDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleImpuestoInvenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleImpuestoInvenDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.DetalleImpuestoInven.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseDetalleImpuestoInven(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<DetalleImpuestoInven> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetalleImpuestoInven> entities = new  ArrayList<DetalleImpuestoInven>();
		DetalleImpuestoInven entity = new DetalleImpuestoInven();		  
		
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
	
	public  List<DetalleImpuestoInven> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetalleImpuestoInven> entities = new  ArrayList<DetalleImpuestoInven>();
		DetalleImpuestoInven entity = new DetalleImpuestoInven();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleImpuestoInvenDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleImpuestoInvenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleImpuestoInvenDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleImpuestoInven();
      	    	entity=super.getEntity("",entity,resultSet,DetalleImpuestoInvenDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleImpuestoInven("",entity,resultSet);
      	    	
				//entity.setDetalleImpuestoInvenOriginal( new DetalleImpuestoInven());
      	    	//entity.setDetalleImpuestoInvenOriginal(super.getEntity("",entity.getDetalleImpuestoInvenOriginal(),resultSet,DetalleImpuestoInvenDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleImpuestoInvenOriginal(this.getEntityDetalleImpuestoInven("",entity.getDetalleImpuestoInvenOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleImpuestoInvens(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleImpuestoInven(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetalleImpuestoInven> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetalleImpuestoInven> entities = new  ArrayList<DetalleImpuestoInven>();
		DetalleImpuestoInven entity = new DetalleImpuestoInven();		  
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
	
	public  List<DetalleImpuestoInven> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetalleImpuestoInven> entities = new  ArrayList<DetalleImpuestoInven>();
		DetalleImpuestoInven entity = new DetalleImpuestoInven();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleImpuestoInven();
				
				if(conMapGenerico) {
					entity.inicializarMapDetalleImpuestoInven();
					//entity.setMapDetalleImpuestoInven(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapDetalleImpuestoInvenValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetalleImpuestoInven().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetalleImpuestoInvenDataAccess.ISWITHSCHEMA);         		
					entity=DetalleImpuestoInvenDataAccess.getEntityDetalleImpuestoInven("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetalleImpuestoInvenOriginal( new DetalleImpuestoInven());
					////entity.setDetalleImpuestoInvenOriginal(super.getEntity("",entity.getDetalleImpuestoInvenOriginal(),resultSet,DetalleImpuestoInvenDataAccess.ISWITHSCHEMA));         		
					////entity.setDetalleImpuestoInvenOriginal(this.getEntityDetalleImpuestoInven("",entity.getDetalleImpuestoInvenOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleImpuestoInvens(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleImpuestoInven(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public DetalleImpuestoInven getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetalleImpuestoInven entity = new DetalleImpuestoInven();		  
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
	
	public  DetalleImpuestoInven getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetalleImpuestoInven entity = new DetalleImpuestoInven();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleImpuestoInven();
				
				if(conMapGenerico) {
					entity.inicializarMapDetalleImpuestoInven();
					//entity.setMapDetalleImpuestoInven(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapDetalleImpuestoInvenValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetalleImpuestoInven().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetalleImpuestoInvenDataAccess.ISWITHSCHEMA);         		
					entity=DetalleImpuestoInvenDataAccess.getEntityDetalleImpuestoInven("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetalleImpuestoInvenOriginal( new DetalleImpuestoInven());
					////entity.setDetalleImpuestoInvenOriginal(super.getEntity("",entity.getDetalleImpuestoInvenOriginal(),resultSet,DetalleImpuestoInvenDataAccess.ISWITHSCHEMA));         		
					////entity.setDetalleImpuestoInvenOriginal(this.getEntityDetalleImpuestoInven("",entity.getDetalleImpuestoInvenOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseDetalleImpuestoInven(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleImpuestoInven(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static DetalleImpuestoInven getEntityDetalleImpuestoInven(String strPrefijo,DetalleImpuestoInven entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = DetalleImpuestoInven.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = DetalleImpuestoInven.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					DetalleImpuestoInvenDataAccess.setFieldReflectionDetalleImpuestoInven(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasDetalleImpuestoInven=DetalleImpuestoInvenConstantesFunciones.getTodosTiposColumnasDetalleImpuestoInven();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasDetalleImpuestoInven) {
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
							field = DetalleImpuestoInven.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = DetalleImpuestoInven.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						DetalleImpuestoInvenDataAccess.setFieldReflectionDetalleImpuestoInven(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionDetalleImpuestoInven(Field field,String strPrefijo,String sColumn,DetalleImpuestoInven entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case DetalleImpuestoInvenConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleImpuestoInvenConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleImpuestoInvenConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleImpuestoInvenConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleImpuestoInvenConstantesFunciones.IDBODEGA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleImpuestoInvenConstantesFunciones.IDPRODUCTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleImpuestoInvenConstantesFunciones.IDIMPUESTOINVEN:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleImpuestoInvenConstantesFunciones.PORCENTAJE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleImpuestoInvenConstantesFunciones.VALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleImpuestoInvenConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetalleImpuestoInven>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<DetalleImpuestoInven> entities = new  ArrayList<DetalleImpuestoInven>();
		DetalleImpuestoInven entity = new DetalleImpuestoInven();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleImpuestoInvenDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleImpuestoInvenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleImpuestoInvenDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new DetalleImpuestoInven();
					entity=super.getEntity("",entity,resultSet,DetalleImpuestoInvenDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityDetalleImpuestoInven("",entity,resultSet);
					
					//entity.setDetalleImpuestoInvenOriginal( new DetalleImpuestoInven());
					//entity.setDetalleImpuestoInvenOriginal(super.getEntity("",entity.getDetalleImpuestoInvenOriginal(),resultSet,DetalleImpuestoInvenDataAccess.ISWITHSCHEMA));         		
					//entity.setDetalleImpuestoInvenOriginal(this.getEntityDetalleImpuestoInven("",entity.getDetalleImpuestoInvenOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseDetalleImpuestoInvens(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleImpuestoInven(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetalleImpuestoInven>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<DetalleImpuestoInven> entities = new  ArrayList<DetalleImpuestoInven>();
		DetalleImpuestoInven entity = new DetalleImpuestoInven();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleImpuestoInvenDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleImpuestoInvenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleImpuestoInvenDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<DetalleImpuestoInven> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleImpuestoInven> entities = new  ArrayList<DetalleImpuestoInven>();
		DetalleImpuestoInven entity = new DetalleImpuestoInven();		  
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
	
	public  List<DetalleImpuestoInven> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleImpuestoInven> entities = new  ArrayList<DetalleImpuestoInven>();
		DetalleImpuestoInven entity = new DetalleImpuestoInven();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleImpuestoInven();
      	    	entity=super.getEntity("",entity,resultSet,DetalleImpuestoInvenDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleImpuestoInven("",entity,resultSet);
      	    	
				//entity.setDetalleImpuestoInvenOriginal( new DetalleImpuestoInven());
      	    	//entity.setDetalleImpuestoInvenOriginal(super.getEntity("",entity.getDetalleImpuestoInvenOriginal(),resultSet,DetalleImpuestoInvenDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleImpuestoInvenOriginal(this.getEntityDetalleImpuestoInven("",entity.getDetalleImpuestoInvenOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseDetalleImpuestoInvens(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleImpuestoInven(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetalleImpuestoInven> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleImpuestoInven> entities = new  ArrayList<DetalleImpuestoInven>();
		DetalleImpuestoInven entity = new DetalleImpuestoInven();		  
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
	
	public  List<DetalleImpuestoInven> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleImpuestoInven> entities = new  ArrayList<DetalleImpuestoInven>();
		DetalleImpuestoInven entity = new DetalleImpuestoInven();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleImpuestoInven();
      	    	entity=super.getEntity("",entity,resultSet,DetalleImpuestoInvenDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleImpuestoInven("",entity,resultSet);
      	    	
				//entity.setDetalleImpuestoInvenOriginal( new DetalleImpuestoInven());
      	    	//entity.setDetalleImpuestoInvenOriginal(super.getEntity("",entity.getDetalleImpuestoInvenOriginal(),resultSet,DetalleImpuestoInvenDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleImpuestoInvenOriginal(this.getEntityDetalleImpuestoInven("",entity.getDetalleImpuestoInvenOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleImpuestoInvens(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public DetalleImpuestoInven getEntityDetalleImpuestoInven(String strPrefijo,DetalleImpuestoInven entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+DetalleImpuestoInvenConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+DetalleImpuestoInvenConstantesFunciones.IDSUCURSAL));
				entity.setid_bodega(resultSet.getLong(strPrefijo+DetalleImpuestoInvenConstantesFunciones.IDBODEGA));
				entity.setid_producto(resultSet.getLong(strPrefijo+DetalleImpuestoInvenConstantesFunciones.IDPRODUCTO));
				entity.setid_impuesto_inven(resultSet.getLong(strPrefijo+DetalleImpuestoInvenConstantesFunciones.IDIMPUESTOINVEN));
				entity.setporcentaje(resultSet.getDouble(strPrefijo+DetalleImpuestoInvenConstantesFunciones.PORCENTAJE));
				entity.setvalor(resultSet.getDouble(strPrefijo+DetalleImpuestoInvenConstantesFunciones.VALOR));
				entity.setdescripcion(resultSet.getString(strPrefijo+DetalleImpuestoInvenConstantesFunciones.DESCRIPCION));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowDetalleImpuestoInven(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(DetalleImpuestoInven entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=DetalleImpuestoInvenDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=DetalleImpuestoInvenDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=DetalleImpuestoInvenDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=DetalleImpuestoInvenDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(DetalleImpuestoInvenConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,DetalleImpuestoInvenDataAccess.TABLENAME,DetalleImpuestoInvenDataAccess.ISWITHSTOREPROCEDURES);
			
			DetalleImpuestoInvenDataAccess.setDetalleImpuestoInvenOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,DetalleImpuestoInven reldetalleimpuestoinven)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reldetalleimpuestoinven.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,DetalleImpuestoInven reldetalleimpuestoinven)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,reldetalleimpuestoinven.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Bodega getBodega(Connexion connexion,DetalleImpuestoInven reldetalleimpuestoinven)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);

			bodega=bodegaDataAccess.getEntity(connexion,reldetalleimpuestoinven.getid_bodega());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}

	public Producto getProducto(Connexion connexion,DetalleImpuestoInven reldetalleimpuestoinven)throws SQLException,Exception {

		Producto producto= new Producto();

		try {
			ProductoDataAccess productoDataAccess=new ProductoDataAccess();

			productoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			productoDataAccess.setConnexionType(this.connexionType);
			productoDataAccess.setParameterDbType(this.parameterDbType);

			producto=productoDataAccess.getEntity(connexion,reldetalleimpuestoinven.getid_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return producto;

	}

	public ImpuestoInven getImpuestoInven(Connexion connexion,DetalleImpuestoInven reldetalleimpuestoinven)throws SQLException,Exception {

		ImpuestoInven impuestoinven= new ImpuestoInven();

		try {
			ImpuestoInvenDataAccess impuestoinvenDataAccess=new ImpuestoInvenDataAccess();

			impuestoinvenDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			impuestoinvenDataAccess.setConnexionType(this.connexionType);
			impuestoinvenDataAccess.setParameterDbType(this.parameterDbType);

			impuestoinven=impuestoinvenDataAccess.getEntity(connexion,reldetalleimpuestoinven.getid_impuesto_inven());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return impuestoinven;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,DetalleImpuestoInven detalleimpuestoinven) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!detalleimpuestoinven.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(detalleimpuestoinven.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(detalleimpuestoinven.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_bodega=new ParameterValue<Long>();
					parameterMaintenanceValueid_bodega.setValue(detalleimpuestoinven.getid_bodega());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_bodega);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_producto=new ParameterValue<Long>();
					parameterMaintenanceValueid_producto.setValue(detalleimpuestoinven.getid_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_producto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_impuesto_inven=new ParameterValue<Long>();
					parameterMaintenanceValueid_impuesto_inven.setValue(detalleimpuestoinven.getid_impuesto_inven());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_impuesto_inven);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcentaje=new ParameterValue<Double>();
					parameterMaintenanceValueporcentaje.setValue(detalleimpuestoinven.getporcentaje());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcentaje);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor=new ParameterValue<Double>();
					parameterMaintenanceValuevalor.setValue(detalleimpuestoinven.getvalor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(detalleimpuestoinven.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!detalleimpuestoinven.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(detalleimpuestoinven.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(detalleimpuestoinven.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(detalleimpuestoinven.getId());
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
	
	public void setIsNewIsChangedFalseDetalleImpuestoInven(DetalleImpuestoInven detalleimpuestoinven)throws Exception  {		
		detalleimpuestoinven.setIsNew(false);
		detalleimpuestoinven.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseDetalleImpuestoInvens(List<DetalleImpuestoInven> detalleimpuestoinvens)throws Exception  {				
		for(DetalleImpuestoInven detalleimpuestoinven:detalleimpuestoinvens) {
			detalleimpuestoinven.setIsNew(false);
			detalleimpuestoinven.setIsChanged(false);
		}
	}
	
	public void generarExportarDetalleImpuestoInven(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
