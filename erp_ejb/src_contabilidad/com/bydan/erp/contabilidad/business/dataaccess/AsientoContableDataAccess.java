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
import com.bydan.erp.contabilidad.util.*;//AsientoContableConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;




@SuppressWarnings("unused")
final public class AsientoContableDataAccess extends  AsientoContableDataAccessAdditional{ //AsientoContableDataAccessAdditional,DataAccessHelper<AsientoContable>
	//static Logger logger = Logger.getLogger(AsientoContableDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="asiento_contable";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_ejercicio,id_periodo,id_anio,id_mes,id_modulo,id_usuario,id_tipo_documento,codigo,fecha,id_tipo_movimiento,numero_mayor,id_moneda,es_retencion,numero_retencion,valor,es_retencion_iva,numero_retencion_iva,cotizacion,id_cliente,id_tipo_descripcion_asiento,id_formato,beneficiario,descripcion,fecha_emision,fecha_finalizacion,id_estado_asiento_contable,id_tipo_movimiento_modulo)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_anio=?,id_mes=?,id_modulo=?,id_usuario=?,id_tipo_documento=?,codigo=?,fecha=?,id_tipo_movimiento=?,numero_mayor=?,id_moneda=?,es_retencion=?,numero_retencion=?,valor=?,es_retencion_iva=?,numero_retencion_iva=?,cotizacion=?,id_cliente=?,id_tipo_descripcion_asiento=?,id_formato=?,beneficiario=?,descripcion=?,fecha_emision=?,fecha_finalizacion=?,id_estado_asiento_contable=?,id_tipo_movimiento_modulo=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select asientocontable from "+AsientoContableConstantesFunciones.SPERSISTENCENAME+" asientocontable";
	public static String QUERYSELECTNATIVE="select "+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME+".id,"+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME+".version_row,"+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME+".id_empresa,"+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME+".id_sucursal,"+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME+".id_ejercicio,"+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME+".id_periodo,"+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME+".id_anio,"+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME+".id_mes,"+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME+".id_modulo,"+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME+".id_usuario,"+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME+".id_tipo_documento,"+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME+".codigo,"+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME+".fecha,"+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME+".id_tipo_movimiento,"+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME+".numero_mayor,"+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME+".id_moneda,"+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME+".es_retencion,"+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME+".numero_retencion,"+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME+".valor,"+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME+".es_retencion_iva,"+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME+".numero_retencion_iva,"+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME+".cotizacion,"+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME+".id_cliente,"+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME+".id_tipo_descripcion_asiento,"+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME+".id_formato,"+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME+".beneficiario,"+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME+".descripcion,"+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME+".fecha_emision,"+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME+".fecha_finalizacion,"+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME+".id_estado_asiento_contable,"+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME+".id_tipo_movimiento_modulo from "+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME;//+" as "+AsientoContableConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME+".id,"+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME+".version_row,"+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME+".codigo from "+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME;//+" as "+AsientoContableConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_anio=?,id_mes=?,id_modulo=?,id_usuario=?,id_tipo_documento=?,codigo=?,fecha=?,id_tipo_movimiento=?,numero_mayor=?,id_moneda=?,es_retencion=?,numero_retencion=?,valor=?,es_retencion_iva=?,numero_retencion_iva=?,cotizacion=?,id_cliente=?,id_tipo_descripcion_asiento=?,id_formato=?,beneficiario=?,descripcion=?,fecha_emision=?,fecha_finalizacion=?,id_estado_asiento_contable=?,id_tipo_movimiento_modulo=?";
	
	public static String STOREPROCEDUREINSERT="call SP_ASIENTOCONTABLE_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_ASIENTOCONTABLE_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_ASIENTOCONTABLE_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_ASIENTOCONTABLE_SELECT(?,?)";
	
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
	
	
	protected AsientoContableDataAccessAdditional asientocontableDataAccessAdditional=null;
	
	public AsientoContableDataAccessAdditional getAsientoContableDataAccessAdditional() {
		return this.asientocontableDataAccessAdditional;
	}
	
	public void setAsientoContableDataAccessAdditional(AsientoContableDataAccessAdditional asientocontableDataAccessAdditional) {
		try {
			this.asientocontableDataAccessAdditional=asientocontableDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public AsientoContableDataAccess() {
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
		AsientoContableDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		AsientoContableDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		AsientoContableDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setAsientoContableOriginal(AsientoContable asientocontable)throws Exception  {
		asientocontable.setAsientoContableOriginal((AsientoContable)asientocontable.clone());		
	}
	
	public void setAsientoContablesOriginal(List<AsientoContable> asientocontables)throws Exception  {
		
		for(AsientoContable asientocontable:asientocontables){
			asientocontable.setAsientoContableOriginal((AsientoContable)asientocontable.clone());
		}
	}
	
	public static void setAsientoContableOriginalStatic(AsientoContable asientocontable)throws Exception  {
		asientocontable.setAsientoContableOriginal((AsientoContable)asientocontable.clone());		
	}
	
	public static void setAsientoContablesOriginalStatic(List<AsientoContable> asientocontables)throws Exception  {
		
		for(AsientoContable asientocontable:asientocontables){
			asientocontable.setAsientoContableOriginal((AsientoContable)asientocontable.clone());
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
	
	public  AsientoContable getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		AsientoContable entity = new AsientoContable();		
		
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
	
	public  AsientoContable getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		AsientoContable entity = new AsientoContable();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=AsientoContableDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=AsientoContableDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Contabilidad.AsientoContable.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setAsientoContableOriginal(new AsientoContable());
      	    	entity=super.getEntity("",entity,resultSet,AsientoContableDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityAsientoContable("",entity,resultSet); 
				
				//entity.setAsientoContableOriginal(super.getEntity("",entity.getAsientoContableOriginal(),resultSet,AsientoContableDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setAsientoContableOriginal(this.getEntityAsientoContable("",entity.getAsientoContableOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseAsientoContable(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  AsientoContable getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		AsientoContable entity = new AsientoContable();
				
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
	
	public  AsientoContable getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		AsientoContable entity = new AsientoContable();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=AsientoContableDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=AsientoContableDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AsientoContableDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.AsientoContable.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setAsientoContableOriginal(new AsientoContable());
      	    	entity=super.getEntity("",entity,resultSet,AsientoContableDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityAsientoContable("",entity,resultSet);    
				
				//entity.setAsientoContableOriginal(super.getEntity("",entity.getAsientoContableOriginal(),resultSet,AsientoContableDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setAsientoContableOriginal(this.getEntityAsientoContable("",entity.getAsientoContableOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseAsientoContable(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //AsientoContable
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		AsientoContable entity = new AsientoContable();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=AsientoContableDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=AsientoContableDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AsientoContableDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.AsientoContable.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseAsientoContable(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<AsientoContable> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<AsientoContable> entities = new  ArrayList<AsientoContable>();
		AsientoContable entity = new AsientoContable();		  
		
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
	
	public  List<AsientoContable> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<AsientoContable> entities = new  ArrayList<AsientoContable>();
		AsientoContable entity = new AsientoContable();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=AsientoContableDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=AsientoContableDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AsientoContableDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new AsientoContable();
      	    	entity=super.getEntity("",entity,resultSet,AsientoContableDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityAsientoContable("",entity,resultSet);
      	    	
				//entity.setAsientoContableOriginal( new AsientoContable());
      	    	//entity.setAsientoContableOriginal(super.getEntity("",entity.getAsientoContableOriginal(),resultSet,AsientoContableDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setAsientoContableOriginal(this.getEntityAsientoContable("",entity.getAsientoContableOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseAsientoContables(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAsientoContable(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<AsientoContable> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<AsientoContable> entities = new  ArrayList<AsientoContable>();
		AsientoContable entity = new AsientoContable();		  
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
	
	public  List<AsientoContable> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<AsientoContable> entities = new  ArrayList<AsientoContable>();
		AsientoContable entity = new AsientoContable();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new AsientoContable();
				
				if(conMapGenerico) {
					entity.inicializarMapAsientoContable();
					//entity.setMapAsientoContable(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapAsientoContableValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapAsientoContable().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,AsientoContableDataAccess.ISWITHSCHEMA);         		
					entity=AsientoContableDataAccess.getEntityAsientoContable("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setAsientoContableOriginal( new AsientoContable());
					////entity.setAsientoContableOriginal(super.getEntity("",entity.getAsientoContableOriginal(),resultSet,AsientoContableDataAccess.ISWITHSCHEMA));         		
					////entity.setAsientoContableOriginal(this.getEntityAsientoContable("",entity.getAsientoContableOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseAsientoContables(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAsientoContable(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public AsientoContable getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		AsientoContable entity = new AsientoContable();		  
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
	
	public  AsientoContable getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		AsientoContable entity = new AsientoContable();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new AsientoContable();
				
				if(conMapGenerico) {
					entity.inicializarMapAsientoContable();
					//entity.setMapAsientoContable(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapAsientoContableValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapAsientoContable().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,AsientoContableDataAccess.ISWITHSCHEMA);         		
					entity=AsientoContableDataAccess.getEntityAsientoContable("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setAsientoContableOriginal( new AsientoContable());
					////entity.setAsientoContableOriginal(super.getEntity("",entity.getAsientoContableOriginal(),resultSet,AsientoContableDataAccess.ISWITHSCHEMA));         		
					////entity.setAsientoContableOriginal(this.getEntityAsientoContable("",entity.getAsientoContableOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseAsientoContable(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAsientoContable(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static AsientoContable getEntityAsientoContable(String strPrefijo,AsientoContable entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = AsientoContable.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = AsientoContable.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					AsientoContableDataAccess.setFieldReflectionAsientoContable(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasAsientoContable=AsientoContableConstantesFunciones.getTodosTiposColumnasAsientoContable();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasAsientoContable) {
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
							field = AsientoContable.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = AsientoContable.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						AsientoContableDataAccess.setFieldReflectionAsientoContable(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionAsientoContable(Field field,String strPrefijo,String sColumn,AsientoContable entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case AsientoContableConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AsientoContableConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case AsientoContableConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AsientoContableConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AsientoContableConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AsientoContableConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AsientoContableConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AsientoContableConstantesFunciones.IDMES:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AsientoContableConstantesFunciones.IDMODULO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AsientoContableConstantesFunciones.IDUSUARIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AsientoContableConstantesFunciones.IDTIPODOCUMENTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AsientoContableConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case AsientoContableConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case AsientoContableConstantesFunciones.IDTIPOMOVIMIENTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AsientoContableConstantesFunciones.NUMEROMAYOR:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case AsientoContableConstantesFunciones.IDMONEDA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AsientoContableConstantesFunciones.ESRETENCION:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case AsientoContableConstantesFunciones.NUMERORETENCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case AsientoContableConstantesFunciones.VALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case AsientoContableConstantesFunciones.ESRETENCIONIVA:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case AsientoContableConstantesFunciones.NUMERORETENCIONIVA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case AsientoContableConstantesFunciones.COTIZACION:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case AsientoContableConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AsientoContableConstantesFunciones.IDTIPODESCRIPCIONASIENTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AsientoContableConstantesFunciones.IDFORMATO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AsientoContableConstantesFunciones.BENEFICIARIO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case AsientoContableConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case AsientoContableConstantesFunciones.FECHAEMISION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case AsientoContableConstantesFunciones.FECHAFINALIZACION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case AsientoContableConstantesFunciones.IDESTADOASIENTOCONTABLE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AsientoContableConstantesFunciones.IDTIPOMOVIMIENTOMODULO:
					field.set(entity,resultSet.getLong(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<AsientoContable>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<AsientoContable> entities = new  ArrayList<AsientoContable>();
		AsientoContable entity = new AsientoContable();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=AsientoContableDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=AsientoContableDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AsientoContableDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new AsientoContable();
					entity=super.getEntity("",entity,resultSet,AsientoContableDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityAsientoContable("",entity,resultSet);
					
					//entity.setAsientoContableOriginal( new AsientoContable());
					//entity.setAsientoContableOriginal(super.getEntity("",entity.getAsientoContableOriginal(),resultSet,AsientoContableDataAccess.ISWITHSCHEMA));         		
					//entity.setAsientoContableOriginal(this.getEntityAsientoContable("",entity.getAsientoContableOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseAsientoContables(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAsientoContable(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<AsientoContable>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<AsientoContable> entities = new  ArrayList<AsientoContable>();
		AsientoContable entity = new AsientoContable();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=AsientoContableDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=AsientoContableDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AsientoContableDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<AsientoContable> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<AsientoContable> entities = new  ArrayList<AsientoContable>();
		AsientoContable entity = new AsientoContable();		  
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
	
	public  List<AsientoContable> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<AsientoContable> entities = new  ArrayList<AsientoContable>();
		AsientoContable entity = new AsientoContable();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new AsientoContable();
      	    	entity=super.getEntity("",entity,resultSet,AsientoContableDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityAsientoContable("",entity,resultSet);
      	    	
				//entity.setAsientoContableOriginal( new AsientoContable());
      	    	//entity.setAsientoContableOriginal(super.getEntity("",entity.getAsientoContableOriginal(),resultSet,AsientoContableDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setAsientoContableOriginal(this.getEntityAsientoContable("",entity.getAsientoContableOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseAsientoContables(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAsientoContable(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<AsientoContable> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<AsientoContable> entities = new  ArrayList<AsientoContable>();
		AsientoContable entity = new AsientoContable();		  
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
	
	public  List<AsientoContable> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<AsientoContable> entities = new  ArrayList<AsientoContable>();
		AsientoContable entity = new AsientoContable();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new AsientoContable();
      	    	entity=super.getEntity("",entity,resultSet,AsientoContableDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityAsientoContable("",entity,resultSet);
      	    	
				//entity.setAsientoContableOriginal( new AsientoContable());
      	    	//entity.setAsientoContableOriginal(super.getEntity("",entity.getAsientoContableOriginal(),resultSet,AsientoContableDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setAsientoContableOriginal(this.getEntityAsientoContable("",entity.getAsientoContableOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseAsientoContables(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public AsientoContable getEntityAsientoContable(String strPrefijo,AsientoContable entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+AsientoContableConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+AsientoContableConstantesFunciones.IDSUCURSAL));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+AsientoContableConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+AsientoContableConstantesFunciones.IDPERIODO));
				entity.setid_anio(resultSet.getLong(strPrefijo+AsientoContableConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
				entity.setid_mes(resultSet.getLong(strPrefijo+AsientoContableConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
				entity.setid_modulo(resultSet.getLong(strPrefijo+AsientoContableConstantesFunciones.IDMODULO));
				entity.setid_usuario(resultSet.getLong(strPrefijo+AsientoContableConstantesFunciones.IDUSUARIO));
				entity.setid_tipo_documento(resultSet.getLong(strPrefijo+AsientoContableConstantesFunciones.IDTIPODOCUMENTO));
				entity.setcodigo(resultSet.getString(strPrefijo+AsientoContableConstantesFunciones.CODIGO));
				entity.setfecha(new Date(resultSet.getDate(strPrefijo+AsientoContableConstantesFunciones.FECHA).getTime()));
				entity.setid_tipo_movimiento(resultSet.getLong(strPrefijo+AsientoContableConstantesFunciones.IDTIPOMOVIMIENTO));
				entity.setnumero_mayor(resultSet.getString(strPrefijo+AsientoContableConstantesFunciones.NUMEROMAYOR));
				entity.setid_moneda(resultSet.getLong(strPrefijo+AsientoContableConstantesFunciones.IDMONEDA));
				entity.setes_retencion(resultSet.getBoolean(strPrefijo+AsientoContableConstantesFunciones.ESRETENCION));
				entity.setnumero_retencion(resultSet.getString(strPrefijo+AsientoContableConstantesFunciones.NUMERORETENCION));
				entity.setvalor(resultSet.getDouble(strPrefijo+AsientoContableConstantesFunciones.VALOR));
				entity.setes_retencion_iva(resultSet.getBoolean(strPrefijo+AsientoContableConstantesFunciones.ESRETENCIONIVA));
				entity.setnumero_retencion_iva(resultSet.getString(strPrefijo+AsientoContableConstantesFunciones.NUMERORETENCIONIVA));
				entity.setcotizacion(resultSet.getDouble(strPrefijo+AsientoContableConstantesFunciones.COTIZACION));
				entity.setid_cliente(resultSet.getLong(strPrefijo+AsientoContableConstantesFunciones.IDCLIENTE));if(resultSet.wasNull()) {entity.setid_cliente(null); }
				entity.setid_tipo_descripcion_asiento(resultSet.getLong(strPrefijo+AsientoContableConstantesFunciones.IDTIPODESCRIPCIONASIENTO));
				entity.setid_formato(resultSet.getLong(strPrefijo+AsientoContableConstantesFunciones.IDFORMATO));if(resultSet.wasNull()) {entity.setid_formato(null); }
				entity.setbeneficiario(resultSet.getString(strPrefijo+AsientoContableConstantesFunciones.BENEFICIARIO));
				entity.setdescripcion(resultSet.getString(strPrefijo+AsientoContableConstantesFunciones.DESCRIPCION));
				entity.setfecha_emision(new Date(resultSet.getDate(strPrefijo+AsientoContableConstantesFunciones.FECHAEMISION).getTime()));
				entity.setfecha_finalizacion(new Date(resultSet.getDate(strPrefijo+AsientoContableConstantesFunciones.FECHAFINALIZACION).getTime()));
				entity.setid_estado_asiento_contable(resultSet.getLong(strPrefijo+AsientoContableConstantesFunciones.IDESTADOASIENTOCONTABLE));
				entity.setid_tipo_movimiento_modulo(resultSet.getLong(strPrefijo+AsientoContableConstantesFunciones.IDTIPOMOVIMIENTOMODULO));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+AsientoContableConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowAsientoContable(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(AsientoContable entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=AsientoContableDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=AsientoContableDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=AsientoContableDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=AsientoContableDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(AsientoContableConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,AsientoContableDataAccess.TABLENAME,AsientoContableDataAccess.ISWITHSTOREPROCEDURES);
			
			AsientoContableDataAccess.setAsientoContableOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,AsientoContable relasientocontable)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relasientocontable.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,AsientoContable relasientocontable)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relasientocontable.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,AsientoContable relasientocontable)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relasientocontable.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,AsientoContable relasientocontable)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,relasientocontable.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public Anio getAnio(Connexion connexion,AsientoContable relasientocontable)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);

			anio=anioDataAccess.getEntity(connexion,relasientocontable.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Mes getMes(Connexion connexion,AsientoContable relasientocontable)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,relasientocontable.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}

	public Modulo getModulo(Connexion connexion,AsientoContable relasientocontable)throws SQLException,Exception {

		Modulo modulo= new Modulo();

		try {
			ModuloDataAccess moduloDataAccess=new ModuloDataAccess();

			moduloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			moduloDataAccess.setConnexionType(this.connexionType);
			moduloDataAccess.setParameterDbType(this.parameterDbType);

			modulo=moduloDataAccess.getEntity(connexion,relasientocontable.getid_modulo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return modulo;

	}

	public Usuario getUsuario(Connexion connexion,AsientoContable relasientocontable)throws SQLException,Exception {

		Usuario usuario= new Usuario();

		try {
			UsuarioDataAccess usuarioDataAccess=new UsuarioDataAccess();

			usuarioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			usuarioDataAccess.setConnexionType(this.connexionType);
			usuarioDataAccess.setParameterDbType(this.parameterDbType);

			usuario=usuarioDataAccess.getEntity(connexion,relasientocontable.getid_usuario());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return usuario;

	}

	public TipoDocumento getTipoDocumento(Connexion connexion,AsientoContable relasientocontable)throws SQLException,Exception {

		TipoDocumento tipodocumento= new TipoDocumento();

		try {
			TipoDocumentoDataAccess tipodocumentoDataAccess=new TipoDocumentoDataAccess();

			tipodocumentoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipodocumentoDataAccess.setConnexionType(this.connexionType);
			tipodocumentoDataAccess.setParameterDbType(this.parameterDbType);

			tipodocumento=tipodocumentoDataAccess.getEntity(connexion,relasientocontable.getid_tipo_documento());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipodocumento;

	}

	public TipoMovimiento getTipoMovimiento(Connexion connexion,AsientoContable relasientocontable)throws SQLException,Exception {

		TipoMovimiento tipomovimiento= new TipoMovimiento();

		try {
			TipoMovimientoDataAccess tipomovimientoDataAccess=new TipoMovimientoDataAccess();

			tipomovimientoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipomovimientoDataAccess.setConnexionType(this.connexionType);
			tipomovimientoDataAccess.setParameterDbType(this.parameterDbType);

			tipomovimiento=tipomovimientoDataAccess.getEntity(connexion,relasientocontable.getid_tipo_movimiento());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipomovimiento;

	}

	public Moneda getMoneda(Connexion connexion,AsientoContable relasientocontable)throws SQLException,Exception {

		Moneda moneda= new Moneda();

		try {
			MonedaDataAccess monedaDataAccess=new MonedaDataAccess();

			monedaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			monedaDataAccess.setConnexionType(this.connexionType);
			monedaDataAccess.setParameterDbType(this.parameterDbType);

			moneda=monedaDataAccess.getEntity(connexion,relasientocontable.getid_moneda());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return moneda;

	}

	public Cliente getCliente(Connexion connexion,AsientoContable relasientocontable)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,relasientocontable.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public TipoDescripcionAsiento getTipoDescripcionAsiento(Connexion connexion,AsientoContable relasientocontable)throws SQLException,Exception {

		TipoDescripcionAsiento tipodescripcionasiento= new TipoDescripcionAsiento();

		try {
			TipoDescripcionAsientoDataAccess tipodescripcionasientoDataAccess=new TipoDescripcionAsientoDataAccess();

			tipodescripcionasientoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipodescripcionasientoDataAccess.setConnexionType(this.connexionType);
			tipodescripcionasientoDataAccess.setParameterDbType(this.parameterDbType);

			tipodescripcionasiento=tipodescripcionasientoDataAccess.getEntity(connexion,relasientocontable.getid_tipo_descripcion_asiento());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipodescripcionasiento;

	}

	public Formato getFormato(Connexion connexion,AsientoContable relasientocontable)throws SQLException,Exception {

		Formato formato= new Formato();

		try {
			FormatoDataAccess formatoDataAccess=new FormatoDataAccess();

			formatoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			formatoDataAccess.setConnexionType(this.connexionType);
			formatoDataAccess.setParameterDbType(this.parameterDbType);

			formato=formatoDataAccess.getEntity(connexion,relasientocontable.getid_formato());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formato;

	}

	public EstadoAsientoContable getEstadoAsientoContable(Connexion connexion,AsientoContable relasientocontable)throws SQLException,Exception {

		EstadoAsientoContable estadoasientocontable= new EstadoAsientoContable();

		try {
			EstadoAsientoContableDataAccess estadoasientocontableDataAccess=new EstadoAsientoContableDataAccess();

			//estadoasientocontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadoasientocontableDataAccess.setConnexionType(this.connexionType);
			estadoasientocontableDataAccess.setParameterDbType(this.parameterDbType);

			estadoasientocontable=estadoasientocontableDataAccess.getEntity(connexion,relasientocontable.getid_estado_asiento_contable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadoasientocontable;

	}

	public TipoMovimientoModulo getTipoMovimientoModulo(Connexion connexion,AsientoContable relasientocontable)throws SQLException,Exception {

		TipoMovimientoModulo tipomovimientomodulo= new TipoMovimientoModulo();

		try {
			TipoMovimientoModuloDataAccess tipomovimientomoduloDataAccess=new TipoMovimientoModuloDataAccess();

			tipomovimientomoduloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipomovimientomoduloDataAccess.setConnexionType(this.connexionType);
			tipomovimientomoduloDataAccess.setParameterDbType(this.parameterDbType);

			tipomovimientomodulo=tipomovimientomoduloDataAccess.getEntity(connexion,relasientocontable.getid_tipo_movimiento_modulo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipomovimientomodulo;

	}


		
		public List<Sri> getSris(Connexion connexion,AsientoContable asientocontable)throws SQLException,Exception {

		List<Sri> sris= new ArrayList<Sri>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+AsientoContableConstantesFunciones.SCHEMA+".asiento_contable ON "+SriConstantesFunciones.SCHEMA+".sri.id_asiento_contable="+AsientoContableConstantesFunciones.SCHEMA+".asiento_contable.id WHERE "+AsientoContableConstantesFunciones.SCHEMA+".asiento_contable.id="+String.valueOf(asientocontable.getId());
			} else {
				sQuery=" INNER JOIN sri.AsientoContable WHERE sri.AsientoContable.id="+String.valueOf(asientocontable.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			SriDataAccess sriDataAccess=new SriDataAccess();

			sriDataAccess.setConnexionType(this.connexionType);
			sriDataAccess.setParameterDbType(this.parameterDbType);
			sris=sriDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sris;

	}

	public List<ImportarExportar> getImportarExportars(Connexion connexion,AsientoContable asientocontable)throws SQLException,Exception {

		List<ImportarExportar> importarexportars= new ArrayList<ImportarExportar>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+AsientoContableConstantesFunciones.SCHEMA+".asiento_contable ON "+ImportarExportarConstantesFunciones.SCHEMA+".importar_exportar.id_asiento_contable="+AsientoContableConstantesFunciones.SCHEMA+".asiento_contable.id WHERE "+AsientoContableConstantesFunciones.SCHEMA+".asiento_contable.id="+String.valueOf(asientocontable.getId());
			} else {
				sQuery=" INNER JOIN importarexportar.AsientoContable WHERE importarexportar.AsientoContable.id="+String.valueOf(asientocontable.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ImportarExportarDataAccess importarexportarDataAccess=new ImportarExportarDataAccess();

			importarexportarDataAccess.setConnexionType(this.connexionType);
			importarexportarDataAccess.setParameterDbType(this.parameterDbType);
			importarexportars=importarexportarDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return importarexportars;

	}

	public List<DetalleMoviClienProve> getDetalleMoviClienProves(Connexion connexion,AsientoContable asientocontable)throws SQLException,Exception {

		List<DetalleMoviClienProve> detallemoviclienproves= new ArrayList<DetalleMoviClienProve>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+AsientoContableConstantesFunciones.SCHEMA+".asiento_contable ON "+DetalleMoviClienProveConstantesFunciones.SCHEMA+".detalle_movi_clien_prove.id_asiento_contable="+AsientoContableConstantesFunciones.SCHEMA+".asiento_contable.id WHERE "+AsientoContableConstantesFunciones.SCHEMA+".asiento_contable.id="+String.valueOf(asientocontable.getId());
			} else {
				sQuery=" INNER JOIN detallemoviclienprove.AsientoContable WHERE detallemoviclienprove.AsientoContable.id="+String.valueOf(asientocontable.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleMoviClienProveDataAccess detallemoviclienproveDataAccess=new DetalleMoviClienProveDataAccess();

			detallemoviclienproveDataAccess.setConnexionType(this.connexionType);
			detallemoviclienproveDataAccess.setParameterDbType(this.parameterDbType);
			detallemoviclienproves=detallemoviclienproveDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detallemoviclienproves;

	}

	public List<Prestamo> getPrestamos(Connexion connexion,AsientoContable asientocontable)throws SQLException,Exception {

		List<Prestamo> prestamos= new ArrayList<Prestamo>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+AsientoContableConstantesFunciones.SCHEMA+".asiento_contable ON "+PrestamoConstantesFunciones.SCHEMA+".prestamo.id_asiento_contable="+AsientoContableConstantesFunciones.SCHEMA+".asiento_contable.id WHERE "+AsientoContableConstantesFunciones.SCHEMA+".asiento_contable.id="+String.valueOf(asientocontable.getId());
			} else {
				sQuery=" INNER JOIN prestamo.AsientoContable WHERE prestamo.AsientoContable.id="+String.valueOf(asientocontable.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PrestamoDataAccess prestamoDataAccess=new PrestamoDataAccess();

			prestamoDataAccess.setConnexionType(this.connexionType);
			prestamoDataAccess.setParameterDbType(this.parameterDbType);
			prestamos=prestamoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return prestamos;

	}

	public List<DetalleAsientoContable> getDetalleAsientoContables(Connexion connexion,AsientoContable asientocontable)throws SQLException,Exception {

		List<DetalleAsientoContable> detalleasientocontables= new ArrayList<DetalleAsientoContable>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+AsientoContableConstantesFunciones.SCHEMA+".asiento_contable ON "+DetalleAsientoContableConstantesFunciones.SCHEMA+".detalle_asiento_contable.id_asiento_contable="+AsientoContableConstantesFunciones.SCHEMA+".asiento_contable.id WHERE "+AsientoContableConstantesFunciones.SCHEMA+".asiento_contable.id="+String.valueOf(asientocontable.getId());
			} else {
				sQuery=" INNER JOIN detalleasientocontable.AsientoContable WHERE detalleasientocontable.AsientoContable.id="+String.valueOf(asientocontable.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleAsientoContableDataAccess detalleasientocontableDataAccess=new DetalleAsientoContableDataAccess();

			detalleasientocontableDataAccess.setConnexionType(this.connexionType);
			detalleasientocontableDataAccess.setParameterDbType(this.parameterDbType);
			detalleasientocontables=detalleasientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalleasientocontables;

	}

	public List<Retencion> getRetencions(Connexion connexion,AsientoContable asientocontable)throws SQLException,Exception {

		List<Retencion> retencions= new ArrayList<Retencion>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+AsientoContableConstantesFunciones.SCHEMA+".asiento_contable ON "+RetencionConstantesFunciones.SCHEMA+".retencion.id_asiento_contable="+AsientoContableConstantesFunciones.SCHEMA+".asiento_contable.id WHERE "+AsientoContableConstantesFunciones.SCHEMA+".asiento_contable.id="+String.valueOf(asientocontable.getId());
			} else {
				sQuery=" INNER JOIN retencion.AsientoContable WHERE retencion.AsientoContable.id="+String.valueOf(asientocontable.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			RetencionDataAccess retencionDataAccess=new RetencionDataAccess();

			retencionDataAccess.setConnexionType(this.connexionType);
			retencionDataAccess.setParameterDbType(this.parameterDbType);
			retencions=retencionDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return retencions;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,AsientoContable asientocontable) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!asientocontable.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(asientocontable.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(asientocontable.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(asientocontable.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(asientocontable.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_anio=new ParameterValue<Long>();
					parameterMaintenanceValueid_anio.setValue(asientocontable.getid_anio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_anio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes.setValue(asientocontable.getid_mes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_modulo=new ParameterValue<Long>();
					parameterMaintenanceValueid_modulo.setValue(asientocontable.getid_modulo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_modulo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_usuario=new ParameterValue<Long>();
					parameterMaintenanceValueid_usuario.setValue(asientocontable.getid_usuario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_usuario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_documento=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_documento.setValue(asientocontable.getid_tipo_documento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_documento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(asientocontable.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha=new ParameterValue<Date>();
					parameterMaintenanceValuefecha.setValue(asientocontable.getfecha());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_movimiento=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_movimiento.setValue(asientocontable.getid_tipo_movimiento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_movimiento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_mayor=new ParameterValue<String>();
					parameterMaintenanceValuenumero_mayor.setValue(asientocontable.getnumero_mayor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_mayor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_moneda=new ParameterValue<Long>();
					parameterMaintenanceValueid_moneda.setValue(asientocontable.getid_moneda());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_moneda);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_retencion=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_retencion.setValue(asientocontable.getes_retencion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_retencion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_retencion=new ParameterValue<String>();
					parameterMaintenanceValuenumero_retencion.setValue(asientocontable.getnumero_retencion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_retencion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor=new ParameterValue<Double>();
					parameterMaintenanceValuevalor.setValue(asientocontable.getvalor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_retencion_iva=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_retencion_iva.setValue(asientocontable.getes_retencion_iva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_retencion_iva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_retencion_iva=new ParameterValue<String>();
					parameterMaintenanceValuenumero_retencion_iva.setValue(asientocontable.getnumero_retencion_iva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_retencion_iva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecotizacion=new ParameterValue<Double>();
					parameterMaintenanceValuecotizacion.setValue(asientocontable.getcotizacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecotizacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_cliente.setValue(asientocontable.getid_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_descripcion_asiento=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_descripcion_asiento.setValue(asientocontable.getid_tipo_descripcion_asiento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_descripcion_asiento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_formato=new ParameterValue<Long>();
					parameterMaintenanceValueid_formato.setValue(asientocontable.getid_formato());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_formato);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuebeneficiario=new ParameterValue<String>();
					parameterMaintenanceValuebeneficiario.setValue(asientocontable.getbeneficiario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuebeneficiario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(asientocontable.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_emision=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_emision.setValue(asientocontable.getfecha_emision());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_emision);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_finalizacion=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_finalizacion.setValue(asientocontable.getfecha_finalizacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_finalizacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_asiento_contable=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_asiento_contable.setValue(asientocontable.getid_estado_asiento_contable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_asiento_contable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_movimiento_modulo=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_movimiento_modulo.setValue(asientocontable.getid_tipo_movimiento_modulo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_movimiento_modulo);
					parametersTemp.add(parameterMaintenance);
					
						if(!asientocontable.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(asientocontable.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(asientocontable.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(asientocontable.getId());
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
	
	public void setIsNewIsChangedFalseAsientoContable(AsientoContable asientocontable)throws Exception  {		
		asientocontable.setIsNew(false);
		asientocontable.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseAsientoContables(List<AsientoContable> asientocontables)throws Exception  {				
		for(AsientoContable asientocontable:asientocontables) {
			asientocontable.setIsNew(false);
			asientocontable.setIsChanged(false);
		}
	}
	
	public void generarExportarAsientoContable(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
