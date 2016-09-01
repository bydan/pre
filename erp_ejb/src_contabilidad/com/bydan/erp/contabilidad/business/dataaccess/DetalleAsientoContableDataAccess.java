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
package com.bydan.erp.contabilidad.business.dataaccess;

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

import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.contabilidad.util.*;//DetalleAsientoContableConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class DetalleAsientoContableDataAccess extends  DetalleAsientoContableDataAccessAdditional{ //DetalleAsientoContableDataAccessAdditional,DataAccessHelper<DetalleAsientoContable>
	//static Logger logger = Logger.getLogger(DetalleAsientoContableDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="detalle_asiento_contable";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+DetalleAsientoContableConstantesFunciones.SCHEMA+"."+DetalleAsientoContableConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_asiento_contable,numero_documento,id_ejercicio,id_periodo,id_anio,id_mes,id_cuenta_contable,debito_local,credito_local,debito_extran,credito_extran,id_centro_actividad,id_centro_costo,cotizacion,detalle,id_tipo_cambio,con_centro_costo,fecha,numero_deposito)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+DetalleAsientoContableConstantesFunciones.SCHEMA+"."+DetalleAsientoContableConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_asiento_contable=?,numero_documento=?,id_ejercicio=?,id_periodo=?,id_anio=?,id_mes=?,id_cuenta_contable=?,debito_local=?,credito_local=?,debito_extran=?,credito_extran=?,id_centro_actividad=?,id_centro_costo=?,cotizacion=?,detalle=?,id_tipo_cambio=?,con_centro_costo=?,fecha=?,numero_deposito=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+DetalleAsientoContableConstantesFunciones.SCHEMA+"."+DetalleAsientoContableConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select detalleasientocontable from "+DetalleAsientoContableConstantesFunciones.SPERSISTENCENAME+" detalleasientocontable";
	public static String QUERYSELECTNATIVE="select "+DetalleAsientoContableConstantesFunciones.SCHEMA+"."+DetalleAsientoContableConstantesFunciones.TABLENAME+".id,"+DetalleAsientoContableConstantesFunciones.SCHEMA+"."+DetalleAsientoContableConstantesFunciones.TABLENAME+".version_row,"+DetalleAsientoContableConstantesFunciones.SCHEMA+"."+DetalleAsientoContableConstantesFunciones.TABLENAME+".id_empresa,"+DetalleAsientoContableConstantesFunciones.SCHEMA+"."+DetalleAsientoContableConstantesFunciones.TABLENAME+".id_sucursal,"+DetalleAsientoContableConstantesFunciones.SCHEMA+"."+DetalleAsientoContableConstantesFunciones.TABLENAME+".id_asiento_contable,"+DetalleAsientoContableConstantesFunciones.SCHEMA+"."+DetalleAsientoContableConstantesFunciones.TABLENAME+".numero_documento,"+DetalleAsientoContableConstantesFunciones.SCHEMA+"."+DetalleAsientoContableConstantesFunciones.TABLENAME+".id_ejercicio,"+DetalleAsientoContableConstantesFunciones.SCHEMA+"."+DetalleAsientoContableConstantesFunciones.TABLENAME+".id_periodo,"+DetalleAsientoContableConstantesFunciones.SCHEMA+"."+DetalleAsientoContableConstantesFunciones.TABLENAME+".id_anio,"+DetalleAsientoContableConstantesFunciones.SCHEMA+"."+DetalleAsientoContableConstantesFunciones.TABLENAME+".id_mes,"+DetalleAsientoContableConstantesFunciones.SCHEMA+"."+DetalleAsientoContableConstantesFunciones.TABLENAME+".id_cuenta_contable,"+DetalleAsientoContableConstantesFunciones.SCHEMA+"."+DetalleAsientoContableConstantesFunciones.TABLENAME+".debito_local,"+DetalleAsientoContableConstantesFunciones.SCHEMA+"."+DetalleAsientoContableConstantesFunciones.TABLENAME+".credito_local,"+DetalleAsientoContableConstantesFunciones.SCHEMA+"."+DetalleAsientoContableConstantesFunciones.TABLENAME+".debito_extran,"+DetalleAsientoContableConstantesFunciones.SCHEMA+"."+DetalleAsientoContableConstantesFunciones.TABLENAME+".credito_extran,"+DetalleAsientoContableConstantesFunciones.SCHEMA+"."+DetalleAsientoContableConstantesFunciones.TABLENAME+".id_centro_actividad,"+DetalleAsientoContableConstantesFunciones.SCHEMA+"."+DetalleAsientoContableConstantesFunciones.TABLENAME+".id_centro_costo,"+DetalleAsientoContableConstantesFunciones.SCHEMA+"."+DetalleAsientoContableConstantesFunciones.TABLENAME+".cotizacion,"+DetalleAsientoContableConstantesFunciones.SCHEMA+"."+DetalleAsientoContableConstantesFunciones.TABLENAME+".detalle,"+DetalleAsientoContableConstantesFunciones.SCHEMA+"."+DetalleAsientoContableConstantesFunciones.TABLENAME+".id_tipo_cambio,"+DetalleAsientoContableConstantesFunciones.SCHEMA+"."+DetalleAsientoContableConstantesFunciones.TABLENAME+".con_centro_costo,"+DetalleAsientoContableConstantesFunciones.SCHEMA+"."+DetalleAsientoContableConstantesFunciones.TABLENAME+".fecha,"+DetalleAsientoContableConstantesFunciones.SCHEMA+"."+DetalleAsientoContableConstantesFunciones.TABLENAME+".numero_deposito from "+DetalleAsientoContableConstantesFunciones.SCHEMA+"."+DetalleAsientoContableConstantesFunciones.TABLENAME;//+" as "+DetalleAsientoContableConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+DetalleAsientoContableConstantesFunciones.SCHEMA+"."+DetalleAsientoContableConstantesFunciones.TABLENAME+".id,"+DetalleAsientoContableConstantesFunciones.SCHEMA+"."+DetalleAsientoContableConstantesFunciones.TABLENAME+".version_row from "+DetalleAsientoContableConstantesFunciones.SCHEMA+"."+DetalleAsientoContableConstantesFunciones.TABLENAME;//+" as "+DetalleAsientoContableConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+DetalleAsientoContableConstantesFunciones.SCHEMA+"."+DetalleAsientoContableConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_asiento_contable=?,numero_documento=?,id_ejercicio=?,id_periodo=?,id_anio=?,id_mes=?,id_cuenta_contable=?,debito_local=?,credito_local=?,debito_extran=?,credito_extran=?,id_centro_actividad=?,id_centro_costo=?,cotizacion=?,detalle=?,id_tipo_cambio=?,con_centro_costo=?,fecha=?,numero_deposito=?";
	
	public static String STOREPROCEDUREINSERT="call SP_DETALLEASIENTOCONTABLE_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_DETALLEASIENTOCONTABLE_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_DETALLEASIENTOCONTABLE_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_DETALLEASIENTOCONTABLE_SELECT(?,?)";
	
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
	
	
	protected DetalleAsientoContableDataAccessAdditional detalleasientocontableDataAccessAdditional=null;
	
	public DetalleAsientoContableDataAccessAdditional getDetalleAsientoContableDataAccessAdditional() {
		return this.detalleasientocontableDataAccessAdditional;
	}
	
	public void setDetalleAsientoContableDataAccessAdditional(DetalleAsientoContableDataAccessAdditional detalleasientocontableDataAccessAdditional) {
		try {
			this.detalleasientocontableDataAccessAdditional=detalleasientocontableDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public DetalleAsientoContableDataAccess() {
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
		DetalleAsientoContableDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		DetalleAsientoContableDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		DetalleAsientoContableDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setDetalleAsientoContableOriginal(DetalleAsientoContable detalleasientocontable)throws Exception  {
		detalleasientocontable.setDetalleAsientoContableOriginal((DetalleAsientoContable)detalleasientocontable.clone());		
	}
	
	public void setDetalleAsientoContablesOriginal(List<DetalleAsientoContable> detalleasientocontables)throws Exception  {
		
		for(DetalleAsientoContable detalleasientocontable:detalleasientocontables){
			detalleasientocontable.setDetalleAsientoContableOriginal((DetalleAsientoContable)detalleasientocontable.clone());
		}
	}
	
	public static void setDetalleAsientoContableOriginalStatic(DetalleAsientoContable detalleasientocontable)throws Exception  {
		detalleasientocontable.setDetalleAsientoContableOriginal((DetalleAsientoContable)detalleasientocontable.clone());		
	}
	
	public static void setDetalleAsientoContablesOriginalStatic(List<DetalleAsientoContable> detalleasientocontables)throws Exception  {
		
		for(DetalleAsientoContable detalleasientocontable:detalleasientocontables){
			detalleasientocontable.setDetalleAsientoContableOriginal((DetalleAsientoContable)detalleasientocontable.clone());
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
	
	public  DetalleAsientoContable getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		DetalleAsientoContable entity = new DetalleAsientoContable();		
		
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
	
	public  DetalleAsientoContable getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		DetalleAsientoContable entity = new DetalleAsientoContable();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleAsientoContableDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleAsientoContableDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Contabilidad.DetalleAsientoContable.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setDetalleAsientoContableOriginal(new DetalleAsientoContable());
      	    	entity=super.getEntity("",entity,resultSet,DetalleAsientoContableDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetalleAsientoContable("",entity,resultSet); 
				
				//entity.setDetalleAsientoContableOriginal(super.getEntity("",entity.getDetalleAsientoContableOriginal(),resultSet,DetalleAsientoContableDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleAsientoContableOriginal(this.getEntityDetalleAsientoContable("",entity.getDetalleAsientoContableOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseDetalleAsientoContable(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  DetalleAsientoContable getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetalleAsientoContable entity = new DetalleAsientoContable();
				
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
	
	public  DetalleAsientoContable getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetalleAsientoContable entity = new DetalleAsientoContable();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleAsientoContableDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleAsientoContableDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleAsientoContableDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.DetalleAsientoContable.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setDetalleAsientoContableOriginal(new DetalleAsientoContable());
      	    	entity=super.getEntity("",entity,resultSet,DetalleAsientoContableDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetalleAsientoContable("",entity,resultSet);    
				
				//entity.setDetalleAsientoContableOriginal(super.getEntity("",entity.getDetalleAsientoContableOriginal(),resultSet,DetalleAsientoContableDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleAsientoContableOriginal(this.getEntityDetalleAsientoContable("",entity.getDetalleAsientoContableOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseDetalleAsientoContable(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //DetalleAsientoContable
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		DetalleAsientoContable entity = new DetalleAsientoContable();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleAsientoContableDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleAsientoContableDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleAsientoContableDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.DetalleAsientoContable.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseDetalleAsientoContable(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<DetalleAsientoContable> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetalleAsientoContable> entities = new  ArrayList<DetalleAsientoContable>();
		DetalleAsientoContable entity = new DetalleAsientoContable();		  
		
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
	
	public  List<DetalleAsientoContable> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetalleAsientoContable> entities = new  ArrayList<DetalleAsientoContable>();
		DetalleAsientoContable entity = new DetalleAsientoContable();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleAsientoContableDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleAsientoContableDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleAsientoContableDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleAsientoContable();
      	    	entity=super.getEntity("",entity,resultSet,DetalleAsientoContableDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleAsientoContable("",entity,resultSet);
      	    	
				//entity.setDetalleAsientoContableOriginal( new DetalleAsientoContable());
      	    	//entity.setDetalleAsientoContableOriginal(super.getEntity("",entity.getDetalleAsientoContableOriginal(),resultSet,DetalleAsientoContableDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleAsientoContableOriginal(this.getEntityDetalleAsientoContable("",entity.getDetalleAsientoContableOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleAsientoContables(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleAsientoContable(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetalleAsientoContable> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetalleAsientoContable> entities = new  ArrayList<DetalleAsientoContable>();
		DetalleAsientoContable entity = new DetalleAsientoContable();		  
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
	
	public  List<DetalleAsientoContable> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetalleAsientoContable> entities = new  ArrayList<DetalleAsientoContable>();
		DetalleAsientoContable entity = new DetalleAsientoContable();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleAsientoContable();
				
				if(conMapGenerico) {
					entity.inicializarMapDetalleAsientoContable();
					//entity.setMapDetalleAsientoContable(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapDetalleAsientoContableValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetalleAsientoContable().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetalleAsientoContableDataAccess.ISWITHSCHEMA);         		
					entity=DetalleAsientoContableDataAccess.getEntityDetalleAsientoContable("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetalleAsientoContableOriginal( new DetalleAsientoContable());
					////entity.setDetalleAsientoContableOriginal(super.getEntity("",entity.getDetalleAsientoContableOriginal(),resultSet,DetalleAsientoContableDataAccess.ISWITHSCHEMA));         		
					////entity.setDetalleAsientoContableOriginal(this.getEntityDetalleAsientoContable("",entity.getDetalleAsientoContableOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleAsientoContables(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleAsientoContable(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public DetalleAsientoContable getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetalleAsientoContable entity = new DetalleAsientoContable();		  
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
	
	public  DetalleAsientoContable getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetalleAsientoContable entity = new DetalleAsientoContable();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleAsientoContable();
				
				if(conMapGenerico) {
					entity.inicializarMapDetalleAsientoContable();
					//entity.setMapDetalleAsientoContable(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapDetalleAsientoContableValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetalleAsientoContable().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetalleAsientoContableDataAccess.ISWITHSCHEMA);         		
					entity=DetalleAsientoContableDataAccess.getEntityDetalleAsientoContable("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetalleAsientoContableOriginal( new DetalleAsientoContable());
					////entity.setDetalleAsientoContableOriginal(super.getEntity("",entity.getDetalleAsientoContableOriginal(),resultSet,DetalleAsientoContableDataAccess.ISWITHSCHEMA));         		
					////entity.setDetalleAsientoContableOriginal(this.getEntityDetalleAsientoContable("",entity.getDetalleAsientoContableOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseDetalleAsientoContable(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleAsientoContable(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static DetalleAsientoContable getEntityDetalleAsientoContable(String strPrefijo,DetalleAsientoContable entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = DetalleAsientoContable.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = DetalleAsientoContable.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					DetalleAsientoContableDataAccess.setFieldReflectionDetalleAsientoContable(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasDetalleAsientoContable=DetalleAsientoContableConstantesFunciones.getTodosTiposColumnasDetalleAsientoContable();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasDetalleAsientoContable) {
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
							field = DetalleAsientoContable.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = DetalleAsientoContable.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						DetalleAsientoContableDataAccess.setFieldReflectionDetalleAsientoContable(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionDetalleAsientoContable(Field field,String strPrefijo,String sColumn,DetalleAsientoContable entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case DetalleAsientoContableConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleAsientoContableConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleAsientoContableConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleAsientoContableConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleAsientoContableConstantesFunciones.IDASIENTOCONTABLE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleAsientoContableConstantesFunciones.NUMERODOCUMENTO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleAsientoContableConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleAsientoContableConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleAsientoContableConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleAsientoContableConstantesFunciones.IDMES:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleAsientoContableConstantesFunciones.IDCUENTACONTABLE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleAsientoContableConstantesFunciones.DEBITOLOCAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleAsientoContableConstantesFunciones.CREDITOLOCAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleAsientoContableConstantesFunciones.DEBITOEXTRAN:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleAsientoContableConstantesFunciones.CREDITOEXTRAN:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleAsientoContableConstantesFunciones.IDCENTROACTIVIDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleAsientoContableConstantesFunciones.IDCENTROCOSTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleAsientoContableConstantesFunciones.COTIZACION:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleAsientoContableConstantesFunciones.DETALLE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleAsientoContableConstantesFunciones.IDTIPOCAMBIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleAsientoContableConstantesFunciones.CONCENTROCOSTO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case DetalleAsientoContableConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case DetalleAsientoContableConstantesFunciones.NUMERODEPOSITO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetalleAsientoContable>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<DetalleAsientoContable> entities = new  ArrayList<DetalleAsientoContable>();
		DetalleAsientoContable entity = new DetalleAsientoContable();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleAsientoContableDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleAsientoContableDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleAsientoContableDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new DetalleAsientoContable();
					entity=super.getEntity("",entity,resultSet,DetalleAsientoContableDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityDetalleAsientoContable("",entity,resultSet);
					
					//entity.setDetalleAsientoContableOriginal( new DetalleAsientoContable());
					//entity.setDetalleAsientoContableOriginal(super.getEntity("",entity.getDetalleAsientoContableOriginal(),resultSet,DetalleAsientoContableDataAccess.ISWITHSCHEMA));         		
					//entity.setDetalleAsientoContableOriginal(this.getEntityDetalleAsientoContable("",entity.getDetalleAsientoContableOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseDetalleAsientoContables(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleAsientoContable(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetalleAsientoContable>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<DetalleAsientoContable> entities = new  ArrayList<DetalleAsientoContable>();
		DetalleAsientoContable entity = new DetalleAsientoContable();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleAsientoContableDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleAsientoContableDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleAsientoContableDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<DetalleAsientoContable> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleAsientoContable> entities = new  ArrayList<DetalleAsientoContable>();
		DetalleAsientoContable entity = new DetalleAsientoContable();		  
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
	
	public  List<DetalleAsientoContable> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleAsientoContable> entities = new  ArrayList<DetalleAsientoContable>();
		DetalleAsientoContable entity = new DetalleAsientoContable();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleAsientoContable();
      	    	entity=super.getEntity("",entity,resultSet,DetalleAsientoContableDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleAsientoContable("",entity,resultSet);
      	    	
				//entity.setDetalleAsientoContableOriginal( new DetalleAsientoContable());
      	    	//entity.setDetalleAsientoContableOriginal(super.getEntity("",entity.getDetalleAsientoContableOriginal(),resultSet,DetalleAsientoContableDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleAsientoContableOriginal(this.getEntityDetalleAsientoContable("",entity.getDetalleAsientoContableOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseDetalleAsientoContables(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleAsientoContable(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetalleAsientoContable> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleAsientoContable> entities = new  ArrayList<DetalleAsientoContable>();
		DetalleAsientoContable entity = new DetalleAsientoContable();		  
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
	
	public  List<DetalleAsientoContable> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleAsientoContable> entities = new  ArrayList<DetalleAsientoContable>();
		DetalleAsientoContable entity = new DetalleAsientoContable();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleAsientoContable();
      	    	entity=super.getEntity("",entity,resultSet,DetalleAsientoContableDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleAsientoContable("",entity,resultSet);
      	    	
				//entity.setDetalleAsientoContableOriginal( new DetalleAsientoContable());
      	    	//entity.setDetalleAsientoContableOriginal(super.getEntity("",entity.getDetalleAsientoContableOriginal(),resultSet,DetalleAsientoContableDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleAsientoContableOriginal(this.getEntityDetalleAsientoContable("",entity.getDetalleAsientoContableOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleAsientoContables(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public DetalleAsientoContable getEntityDetalleAsientoContable(String strPrefijo,DetalleAsientoContable entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+DetalleAsientoContableConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+DetalleAsientoContableConstantesFunciones.IDSUCURSAL));
				entity.setid_asiento_contable(resultSet.getLong(strPrefijo+DetalleAsientoContableConstantesFunciones.IDASIENTOCONTABLE));
				entity.setnumero_documento(resultSet.getString(strPrefijo+DetalleAsientoContableConstantesFunciones.NUMERODOCUMENTO));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+DetalleAsientoContableConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+DetalleAsientoContableConstantesFunciones.IDPERIODO));
				entity.setid_anio(resultSet.getLong(strPrefijo+DetalleAsientoContableConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
				entity.setid_mes(resultSet.getLong(strPrefijo+DetalleAsientoContableConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
				entity.setid_cuenta_contable(resultSet.getLong(strPrefijo+DetalleAsientoContableConstantesFunciones.IDCUENTACONTABLE));
				entity.setdebito_local(resultSet.getDouble(strPrefijo+DetalleAsientoContableConstantesFunciones.DEBITOLOCAL));
				entity.setcredito_local(resultSet.getDouble(strPrefijo+DetalleAsientoContableConstantesFunciones.CREDITOLOCAL));
				entity.setdebito_extran(resultSet.getDouble(strPrefijo+DetalleAsientoContableConstantesFunciones.DEBITOEXTRAN));
				entity.setcredito_extran(resultSet.getDouble(strPrefijo+DetalleAsientoContableConstantesFunciones.CREDITOEXTRAN));
				entity.setid_centro_actividad(resultSet.getLong(strPrefijo+DetalleAsientoContableConstantesFunciones.IDCENTROACTIVIDAD));if(resultSet.wasNull()) {entity.setid_centro_actividad(null); }
				entity.setid_centro_costo(resultSet.getLong(strPrefijo+DetalleAsientoContableConstantesFunciones.IDCENTROCOSTO));if(resultSet.wasNull()) {entity.setid_centro_costo(null); }
				entity.setcotizacion(resultSet.getDouble(strPrefijo+DetalleAsientoContableConstantesFunciones.COTIZACION));
				entity.setdetalle(resultSet.getString(strPrefijo+DetalleAsientoContableConstantesFunciones.DETALLE));
				entity.setid_tipo_cambio(resultSet.getLong(strPrefijo+DetalleAsientoContableConstantesFunciones.IDTIPOCAMBIO));if(resultSet.wasNull()) {entity.setid_tipo_cambio(null); }
				entity.setcon_centro_costo(resultSet.getBoolean(strPrefijo+DetalleAsientoContableConstantesFunciones.CONCENTROCOSTO));
				entity.setfecha(new Date(resultSet.getDate(strPrefijo+DetalleAsientoContableConstantesFunciones.FECHA).getTime()));
				entity.setnumero_deposito(resultSet.getString(strPrefijo+DetalleAsientoContableConstantesFunciones.NUMERODEPOSITO));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowDetalleAsientoContable(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(DetalleAsientoContable entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=DetalleAsientoContableDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=DetalleAsientoContableDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=DetalleAsientoContableDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=DetalleAsientoContableDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(DetalleAsientoContableConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,DetalleAsientoContableDataAccess.TABLENAME,DetalleAsientoContableDataAccess.ISWITHSTOREPROCEDURES);
			
			DetalleAsientoContableDataAccess.setDetalleAsientoContableOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,DetalleAsientoContable reldetalleasientocontable)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reldetalleasientocontable.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,DetalleAsientoContable reldetalleasientocontable)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,reldetalleasientocontable.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public AsientoContable getAsientoContable(Connexion connexion,DetalleAsientoContable reldetalleasientocontable)throws SQLException,Exception {

		AsientoContable asientocontable= new AsientoContable();

		try {
			AsientoContableDataAccess asientocontableDataAccess=new AsientoContableDataAccess();

			asientocontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			asientocontableDataAccess.setConnexionType(this.connexionType);
			asientocontableDataAccess.setParameterDbType(this.parameterDbType);

			asientocontable=asientocontableDataAccess.getEntity(connexion,reldetalleasientocontable.getid_asiento_contable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return asientocontable;

	}

	public Ejercicio getEjercicio(Connexion connexion,DetalleAsientoContable reldetalleasientocontable)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,reldetalleasientocontable.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,DetalleAsientoContable reldetalleasientocontable)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,reldetalleasientocontable.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public Anio getAnio(Connexion connexion,DetalleAsientoContable reldetalleasientocontable)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);

			anio=anioDataAccess.getEntity(connexion,reldetalleasientocontable.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Mes getMes(Connexion connexion,DetalleAsientoContable reldetalleasientocontable)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,reldetalleasientocontable.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}

	public CuentaContable getCuentaContable(Connexion connexion,DetalleAsientoContable reldetalleasientocontable)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,reldetalleasientocontable.getid_cuenta_contable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CentroActividad getCentroActividad(Connexion connexion,DetalleAsientoContable reldetalleasientocontable)throws SQLException,Exception {

		CentroActividad centroactividad= new CentroActividad();

		try {
			CentroActividadDataAccess centroactividadDataAccess=new CentroActividadDataAccess();

			centroactividadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			centroactividadDataAccess.setConnexionType(this.connexionType);
			centroactividadDataAccess.setParameterDbType(this.parameterDbType);

			centroactividad=centroactividadDataAccess.getEntity(connexion,reldetalleasientocontable.getid_centro_actividad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return centroactividad;

	}

	public CentroCosto getCentroCosto(Connexion connexion,DetalleAsientoContable reldetalleasientocontable)throws SQLException,Exception {

		CentroCosto centrocosto= new CentroCosto();

		try {
			CentroCostoDataAccess centrocostoDataAccess=new CentroCostoDataAccess();

			centrocostoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			centrocostoDataAccess.setConnexionType(this.connexionType);
			centrocostoDataAccess.setParameterDbType(this.parameterDbType);

			centrocosto=centrocostoDataAccess.getEntity(connexion,reldetalleasientocontable.getid_centro_costo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return centrocosto;

	}

	public TipoCambio getTipoCambio(Connexion connexion,DetalleAsientoContable reldetalleasientocontable)throws SQLException,Exception {

		TipoCambio tipocambio= new TipoCambio();

		try {
			TipoCambioDataAccess tipocambioDataAccess=new TipoCambioDataAccess();

			tipocambioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipocambioDataAccess.setConnexionType(this.connexionType);
			tipocambioDataAccess.setParameterDbType(this.parameterDbType);

			tipocambio=tipocambioDataAccess.getEntity(connexion,reldetalleasientocontable.getid_tipo_cambio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipocambio;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,DetalleAsientoContable detalleasientocontable) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!detalleasientocontable.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(detalleasientocontable.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(detalleasientocontable.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_asiento_contable=new ParameterValue<Long>();
					parameterMaintenanceValueid_asiento_contable.setValue(detalleasientocontable.getid_asiento_contable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_asiento_contable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_documento=new ParameterValue<String>();
					parameterMaintenanceValuenumero_documento.setValue(detalleasientocontable.getnumero_documento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_documento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(detalleasientocontable.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(detalleasientocontable.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_anio=new ParameterValue<Long>();
					parameterMaintenanceValueid_anio.setValue(detalleasientocontable.getid_anio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_anio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes.setValue(detalleasientocontable.getid_mes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable.setValue(detalleasientocontable.getid_cuenta_contable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedebito_local=new ParameterValue<Double>();
					parameterMaintenanceValuedebito_local.setValue(detalleasientocontable.getdebito_local());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedebito_local);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecredito_local=new ParameterValue<Double>();
					parameterMaintenanceValuecredito_local.setValue(detalleasientocontable.getcredito_local());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecredito_local);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedebito_extran=new ParameterValue<Double>();
					parameterMaintenanceValuedebito_extran.setValue(detalleasientocontable.getdebito_extran());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedebito_extran);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecredito_extran=new ParameterValue<Double>();
					parameterMaintenanceValuecredito_extran.setValue(detalleasientocontable.getcredito_extran());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecredito_extran);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_centro_actividad=new ParameterValue<Long>();
					parameterMaintenanceValueid_centro_actividad.setValue(detalleasientocontable.getid_centro_actividad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_centro_actividad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_centro_costo=new ParameterValue<Long>();
					parameterMaintenanceValueid_centro_costo.setValue(detalleasientocontable.getid_centro_costo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_centro_costo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecotizacion=new ParameterValue<Double>();
					parameterMaintenanceValuecotizacion.setValue(detalleasientocontable.getcotizacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecotizacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedetalle=new ParameterValue<String>();
					parameterMaintenanceValuedetalle.setValue(detalleasientocontable.getdetalle());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedetalle);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_cambio=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_cambio.setValue(detalleasientocontable.getid_tipo_cambio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_cambio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_centro_costo=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_centro_costo.setValue(detalleasientocontable.getcon_centro_costo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_centro_costo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha=new ParameterValue<Date>();
					parameterMaintenanceValuefecha.setValue(detalleasientocontable.getfecha());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_deposito=new ParameterValue<String>();
					parameterMaintenanceValuenumero_deposito.setValue(detalleasientocontable.getnumero_deposito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_deposito);
					parametersTemp.add(parameterMaintenance);
					
						if(!detalleasientocontable.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(detalleasientocontable.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(detalleasientocontable.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(detalleasientocontable.getId());
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
	
	public void setIsNewIsChangedFalseDetalleAsientoContable(DetalleAsientoContable detalleasientocontable)throws Exception  {		
		detalleasientocontable.setIsNew(false);
		detalleasientocontable.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseDetalleAsientoContables(List<DetalleAsientoContable> detalleasientocontables)throws Exception  {				
		for(DetalleAsientoContable detalleasientocontable:detalleasientocontables) {
			detalleasientocontable.setIsNew(false);
			detalleasientocontable.setIsChanged(false);
		}
	}
	
	public void generarExportarDetalleAsientoContable(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
