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
import com.bydan.erp.contabilidad.util.*;//AsientoContableCajaChicaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.tesoreria.util.*;




@SuppressWarnings("unused")
final public class AsientoContableCajaChicaDataAccess extends  AsientoContableCajaChicaDataAccessAdditional{ //AsientoContableCajaChicaDataAccessAdditional,DataAccessHelper<AsientoContableCajaChica>
	//static Logger logger = Logger.getLogger(AsientoContableCajaChicaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="asiento_contable_caja_chica";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+AsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+AsientoContableCajaChicaConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_ejercicio,id_periodo,id_usuario,id_anio,id_mes,secuencial,id_moneda,fecha,id_empleado,id_estado_asiento_contable,es_proveedor,id_cliente,id_transaccion,id_tipo_documento,id_cuenta_contable,detalle,id_modulo,id_tipo_movimiento,id_tipo_transaccion_modulo,id_tipo_movimiento_modulo)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+AsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+AsientoContableCajaChicaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_usuario=?,id_anio=?,id_mes=?,secuencial=?,id_moneda=?,fecha=?,id_empleado=?,id_estado_asiento_contable=?,es_proveedor=?,id_cliente=?,id_transaccion=?,id_tipo_documento=?,id_cuenta_contable=?,detalle=?,id_modulo=?,id_tipo_movimiento=?,id_tipo_transaccion_modulo=?,id_tipo_movimiento_modulo=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+AsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+AsientoContableCajaChicaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select asientocontablecajachica from "+AsientoContableCajaChicaConstantesFunciones.SPERSISTENCENAME+" asientocontablecajachica";
	public static String QUERYSELECTNATIVE="select "+AsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+AsientoContableCajaChicaConstantesFunciones.TABLENAME+".id,"+AsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+AsientoContableCajaChicaConstantesFunciones.TABLENAME+".version_row,"+AsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+AsientoContableCajaChicaConstantesFunciones.TABLENAME+".id_empresa,"+AsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+AsientoContableCajaChicaConstantesFunciones.TABLENAME+".id_sucursal,"+AsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+AsientoContableCajaChicaConstantesFunciones.TABLENAME+".id_ejercicio,"+AsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+AsientoContableCajaChicaConstantesFunciones.TABLENAME+".id_periodo,"+AsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+AsientoContableCajaChicaConstantesFunciones.TABLENAME+".id_usuario,"+AsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+AsientoContableCajaChicaConstantesFunciones.TABLENAME+".id_anio,"+AsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+AsientoContableCajaChicaConstantesFunciones.TABLENAME+".id_mes,"+AsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+AsientoContableCajaChicaConstantesFunciones.TABLENAME+".secuencial,"+AsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+AsientoContableCajaChicaConstantesFunciones.TABLENAME+".id_moneda,"+AsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+AsientoContableCajaChicaConstantesFunciones.TABLENAME+".fecha,"+AsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+AsientoContableCajaChicaConstantesFunciones.TABLENAME+".id_empleado,"+AsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+AsientoContableCajaChicaConstantesFunciones.TABLENAME+".id_estado_asiento_contable,"+AsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+AsientoContableCajaChicaConstantesFunciones.TABLENAME+".es_proveedor,"+AsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+AsientoContableCajaChicaConstantesFunciones.TABLENAME+".id_cliente,"+AsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+AsientoContableCajaChicaConstantesFunciones.TABLENAME+".id_transaccion,"+AsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+AsientoContableCajaChicaConstantesFunciones.TABLENAME+".id_tipo_documento,"+AsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+AsientoContableCajaChicaConstantesFunciones.TABLENAME+".id_cuenta_contable,"+AsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+AsientoContableCajaChicaConstantesFunciones.TABLENAME+".detalle,"+AsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+AsientoContableCajaChicaConstantesFunciones.TABLENAME+".id_modulo,"+AsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+AsientoContableCajaChicaConstantesFunciones.TABLENAME+".id_tipo_movimiento,"+AsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+AsientoContableCajaChicaConstantesFunciones.TABLENAME+".id_tipo_transaccion_modulo,"+AsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+AsientoContableCajaChicaConstantesFunciones.TABLENAME+".id_tipo_movimiento_modulo from "+AsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+AsientoContableCajaChicaConstantesFunciones.TABLENAME;//+" as "+AsientoContableCajaChicaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+AsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+AsientoContableCajaChicaConstantesFunciones.TABLENAME+".id,"+AsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+AsientoContableCajaChicaConstantesFunciones.TABLENAME+".version_row,"+AsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+AsientoContableCajaChicaConstantesFunciones.TABLENAME+".secuencial from "+AsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+AsientoContableCajaChicaConstantesFunciones.TABLENAME;//+" as "+AsientoContableCajaChicaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+AsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+AsientoContableCajaChicaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_usuario=?,id_anio=?,id_mes=?,secuencial=?,id_moneda=?,fecha=?,id_empleado=?,id_estado_asiento_contable=?,es_proveedor=?,id_cliente=?,id_transaccion=?,id_tipo_documento=?,id_cuenta_contable=?,detalle=?,id_modulo=?,id_tipo_movimiento=?,id_tipo_transaccion_modulo=?,id_tipo_movimiento_modulo=?";
	
	public static String STOREPROCEDUREINSERT="call SP_ASIENTOCONTABLECAJACHICA_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_ASIENTOCONTABLECAJACHICA_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_ASIENTOCONTABLECAJACHICA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_ASIENTOCONTABLECAJACHICA_SELECT(?,?)";
	
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
	
	
	protected AsientoContableCajaChicaDataAccessAdditional asientocontablecajachicaDataAccessAdditional=null;
	
	public AsientoContableCajaChicaDataAccessAdditional getAsientoContableCajaChicaDataAccessAdditional() {
		return this.asientocontablecajachicaDataAccessAdditional;
	}
	
	public void setAsientoContableCajaChicaDataAccessAdditional(AsientoContableCajaChicaDataAccessAdditional asientocontablecajachicaDataAccessAdditional) {
		try {
			this.asientocontablecajachicaDataAccessAdditional=asientocontablecajachicaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public AsientoContableCajaChicaDataAccess() {
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
		AsientoContableCajaChicaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		AsientoContableCajaChicaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		AsientoContableCajaChicaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setAsientoContableCajaChicaOriginal(AsientoContableCajaChica asientocontablecajachica)throws Exception  {
		asientocontablecajachica.setAsientoContableCajaChicaOriginal((AsientoContableCajaChica)asientocontablecajachica.clone());		
	}
	
	public void setAsientoContableCajaChicasOriginal(List<AsientoContableCajaChica> asientocontablecajachicas)throws Exception  {
		
		for(AsientoContableCajaChica asientocontablecajachica:asientocontablecajachicas){
			asientocontablecajachica.setAsientoContableCajaChicaOriginal((AsientoContableCajaChica)asientocontablecajachica.clone());
		}
	}
	
	public static void setAsientoContableCajaChicaOriginalStatic(AsientoContableCajaChica asientocontablecajachica)throws Exception  {
		asientocontablecajachica.setAsientoContableCajaChicaOriginal((AsientoContableCajaChica)asientocontablecajachica.clone());		
	}
	
	public static void setAsientoContableCajaChicasOriginalStatic(List<AsientoContableCajaChica> asientocontablecajachicas)throws Exception  {
		
		for(AsientoContableCajaChica asientocontablecajachica:asientocontablecajachicas){
			asientocontablecajachica.setAsientoContableCajaChicaOriginal((AsientoContableCajaChica)asientocontablecajachica.clone());
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
	
	public  AsientoContableCajaChica getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		AsientoContableCajaChica entity = new AsientoContableCajaChica();		
		
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
	
	public  AsientoContableCajaChica getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		AsientoContableCajaChica entity = new AsientoContableCajaChica();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=AsientoContableCajaChicaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=AsientoContableCajaChicaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Contabilidad.AsientoContableCajaChica.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setAsientoContableCajaChicaOriginal(new AsientoContableCajaChica());
      	    	entity=super.getEntity("",entity,resultSet,AsientoContableCajaChicaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityAsientoContableCajaChica("",entity,resultSet); 
				
				//entity.setAsientoContableCajaChicaOriginal(super.getEntity("",entity.getAsientoContableCajaChicaOriginal(),resultSet,AsientoContableCajaChicaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setAsientoContableCajaChicaOriginal(this.getEntityAsientoContableCajaChica("",entity.getAsientoContableCajaChicaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseAsientoContableCajaChica(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  AsientoContableCajaChica getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		AsientoContableCajaChica entity = new AsientoContableCajaChica();
				
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
	
	public  AsientoContableCajaChica getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		AsientoContableCajaChica entity = new AsientoContableCajaChica();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=AsientoContableCajaChicaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=AsientoContableCajaChicaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AsientoContableCajaChicaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.AsientoContableCajaChica.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setAsientoContableCajaChicaOriginal(new AsientoContableCajaChica());
      	    	entity=super.getEntity("",entity,resultSet,AsientoContableCajaChicaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityAsientoContableCajaChica("",entity,resultSet);    
				
				//entity.setAsientoContableCajaChicaOriginal(super.getEntity("",entity.getAsientoContableCajaChicaOriginal(),resultSet,AsientoContableCajaChicaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setAsientoContableCajaChicaOriginal(this.getEntityAsientoContableCajaChica("",entity.getAsientoContableCajaChicaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseAsientoContableCajaChica(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //AsientoContableCajaChica
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		AsientoContableCajaChica entity = new AsientoContableCajaChica();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=AsientoContableCajaChicaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=AsientoContableCajaChicaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AsientoContableCajaChicaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.AsientoContableCajaChica.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseAsientoContableCajaChica(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<AsientoContableCajaChica> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<AsientoContableCajaChica> entities = new  ArrayList<AsientoContableCajaChica>();
		AsientoContableCajaChica entity = new AsientoContableCajaChica();		  
		
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
	
	public  List<AsientoContableCajaChica> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<AsientoContableCajaChica> entities = new  ArrayList<AsientoContableCajaChica>();
		AsientoContableCajaChica entity = new AsientoContableCajaChica();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=AsientoContableCajaChicaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=AsientoContableCajaChicaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AsientoContableCajaChicaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new AsientoContableCajaChica();
      	    	entity=super.getEntity("",entity,resultSet,AsientoContableCajaChicaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityAsientoContableCajaChica("",entity,resultSet);
      	    	
				//entity.setAsientoContableCajaChicaOriginal( new AsientoContableCajaChica());
      	    	//entity.setAsientoContableCajaChicaOriginal(super.getEntity("",entity.getAsientoContableCajaChicaOriginal(),resultSet,AsientoContableCajaChicaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setAsientoContableCajaChicaOriginal(this.getEntityAsientoContableCajaChica("",entity.getAsientoContableCajaChicaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseAsientoContableCajaChicas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAsientoContableCajaChica(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<AsientoContableCajaChica> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<AsientoContableCajaChica> entities = new  ArrayList<AsientoContableCajaChica>();
		AsientoContableCajaChica entity = new AsientoContableCajaChica();		  
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
	
	public  List<AsientoContableCajaChica> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<AsientoContableCajaChica> entities = new  ArrayList<AsientoContableCajaChica>();
		AsientoContableCajaChica entity = new AsientoContableCajaChica();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new AsientoContableCajaChica();
				
				if(conMapGenerico) {
					entity.inicializarMapAsientoContableCajaChica();
					//entity.setMapAsientoContableCajaChica(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapAsientoContableCajaChicaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapAsientoContableCajaChica().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,AsientoContableCajaChicaDataAccess.ISWITHSCHEMA);         		
					entity=AsientoContableCajaChicaDataAccess.getEntityAsientoContableCajaChica("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setAsientoContableCajaChicaOriginal( new AsientoContableCajaChica());
					////entity.setAsientoContableCajaChicaOriginal(super.getEntity("",entity.getAsientoContableCajaChicaOriginal(),resultSet,AsientoContableCajaChicaDataAccess.ISWITHSCHEMA));         		
					////entity.setAsientoContableCajaChicaOriginal(this.getEntityAsientoContableCajaChica("",entity.getAsientoContableCajaChicaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseAsientoContableCajaChicas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAsientoContableCajaChica(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public AsientoContableCajaChica getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		AsientoContableCajaChica entity = new AsientoContableCajaChica();		  
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
	
	public  AsientoContableCajaChica getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		AsientoContableCajaChica entity = new AsientoContableCajaChica();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new AsientoContableCajaChica();
				
				if(conMapGenerico) {
					entity.inicializarMapAsientoContableCajaChica();
					//entity.setMapAsientoContableCajaChica(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapAsientoContableCajaChicaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapAsientoContableCajaChica().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,AsientoContableCajaChicaDataAccess.ISWITHSCHEMA);         		
					entity=AsientoContableCajaChicaDataAccess.getEntityAsientoContableCajaChica("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setAsientoContableCajaChicaOriginal( new AsientoContableCajaChica());
					////entity.setAsientoContableCajaChicaOriginal(super.getEntity("",entity.getAsientoContableCajaChicaOriginal(),resultSet,AsientoContableCajaChicaDataAccess.ISWITHSCHEMA));         		
					////entity.setAsientoContableCajaChicaOriginal(this.getEntityAsientoContableCajaChica("",entity.getAsientoContableCajaChicaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseAsientoContableCajaChica(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAsientoContableCajaChica(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static AsientoContableCajaChica getEntityAsientoContableCajaChica(String strPrefijo,AsientoContableCajaChica entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = AsientoContableCajaChica.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = AsientoContableCajaChica.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					AsientoContableCajaChicaDataAccess.setFieldReflectionAsientoContableCajaChica(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasAsientoContableCajaChica=AsientoContableCajaChicaConstantesFunciones.getTodosTiposColumnasAsientoContableCajaChica();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasAsientoContableCajaChica) {
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
							field = AsientoContableCajaChica.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = AsientoContableCajaChica.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						AsientoContableCajaChicaDataAccess.setFieldReflectionAsientoContableCajaChica(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionAsientoContableCajaChica(Field field,String strPrefijo,String sColumn,AsientoContableCajaChica entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case AsientoContableCajaChicaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AsientoContableCajaChicaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case AsientoContableCajaChicaConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AsientoContableCajaChicaConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AsientoContableCajaChicaConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AsientoContableCajaChicaConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AsientoContableCajaChicaConstantesFunciones.IDUSUARIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AsientoContableCajaChicaConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AsientoContableCajaChicaConstantesFunciones.IDMES:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AsientoContableCajaChicaConstantesFunciones.SECUENCIAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AsientoContableCajaChicaConstantesFunciones.IDMONEDA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AsientoContableCajaChicaConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case AsientoContableCajaChicaConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AsientoContableCajaChicaConstantesFunciones.IDESTADOASIENTOCONTABLECAJACHICA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AsientoContableCajaChicaConstantesFunciones.ESPROVEEDOR:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case AsientoContableCajaChicaConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AsientoContableCajaChicaConstantesFunciones.IDTRANSACCION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AsientoContableCajaChicaConstantesFunciones.IDTIPODOCUMENTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AsientoContableCajaChicaConstantesFunciones.IDCUENTACONTABLE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AsientoContableCajaChicaConstantesFunciones.DETALLE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case AsientoContableCajaChicaConstantesFunciones.IDMODULO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AsientoContableCajaChicaConstantesFunciones.IDTIPOMOVIMIENTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AsientoContableCajaChicaConstantesFunciones.IDTIPOTRANSACCIONMODULO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AsientoContableCajaChicaConstantesFunciones.IDTIPOMOVIMIENTOMODULO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<AsientoContableCajaChica>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<AsientoContableCajaChica> entities = new  ArrayList<AsientoContableCajaChica>();
		AsientoContableCajaChica entity = new AsientoContableCajaChica();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=AsientoContableCajaChicaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=AsientoContableCajaChicaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AsientoContableCajaChicaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new AsientoContableCajaChica();
					entity=super.getEntity("",entity,resultSet,AsientoContableCajaChicaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityAsientoContableCajaChica("",entity,resultSet);
					
					//entity.setAsientoContableCajaChicaOriginal( new AsientoContableCajaChica());
					//entity.setAsientoContableCajaChicaOriginal(super.getEntity("",entity.getAsientoContableCajaChicaOriginal(),resultSet,AsientoContableCajaChicaDataAccess.ISWITHSCHEMA));         		
					//entity.setAsientoContableCajaChicaOriginal(this.getEntityAsientoContableCajaChica("",entity.getAsientoContableCajaChicaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseAsientoContableCajaChicas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAsientoContableCajaChica(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<AsientoContableCajaChica>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<AsientoContableCajaChica> entities = new  ArrayList<AsientoContableCajaChica>();
		AsientoContableCajaChica entity = new AsientoContableCajaChica();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=AsientoContableCajaChicaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=AsientoContableCajaChicaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AsientoContableCajaChicaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<AsientoContableCajaChica> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<AsientoContableCajaChica> entities = new  ArrayList<AsientoContableCajaChica>();
		AsientoContableCajaChica entity = new AsientoContableCajaChica();		  
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
	
	public  List<AsientoContableCajaChica> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<AsientoContableCajaChica> entities = new  ArrayList<AsientoContableCajaChica>();
		AsientoContableCajaChica entity = new AsientoContableCajaChica();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new AsientoContableCajaChica();
      	    	entity=super.getEntity("",entity,resultSet,AsientoContableCajaChicaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityAsientoContableCajaChica("",entity,resultSet);
      	    	
				//entity.setAsientoContableCajaChicaOriginal( new AsientoContableCajaChica());
      	    	//entity.setAsientoContableCajaChicaOriginal(super.getEntity("",entity.getAsientoContableCajaChicaOriginal(),resultSet,AsientoContableCajaChicaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setAsientoContableCajaChicaOriginal(this.getEntityAsientoContableCajaChica("",entity.getAsientoContableCajaChicaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseAsientoContableCajaChicas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAsientoContableCajaChica(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<AsientoContableCajaChica> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<AsientoContableCajaChica> entities = new  ArrayList<AsientoContableCajaChica>();
		AsientoContableCajaChica entity = new AsientoContableCajaChica();		  
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
	
	public  List<AsientoContableCajaChica> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<AsientoContableCajaChica> entities = new  ArrayList<AsientoContableCajaChica>();
		AsientoContableCajaChica entity = new AsientoContableCajaChica();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new AsientoContableCajaChica();
      	    	entity=super.getEntity("",entity,resultSet,AsientoContableCajaChicaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityAsientoContableCajaChica("",entity,resultSet);
      	    	
				//entity.setAsientoContableCajaChicaOriginal( new AsientoContableCajaChica());
      	    	//entity.setAsientoContableCajaChicaOriginal(super.getEntity("",entity.getAsientoContableCajaChicaOriginal(),resultSet,AsientoContableCajaChicaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setAsientoContableCajaChicaOriginal(this.getEntityAsientoContableCajaChica("",entity.getAsientoContableCajaChicaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseAsientoContableCajaChicas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public AsientoContableCajaChica getEntityAsientoContableCajaChica(String strPrefijo,AsientoContableCajaChica entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+AsientoContableCajaChicaConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+AsientoContableCajaChicaConstantesFunciones.IDSUCURSAL));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+AsientoContableCajaChicaConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+AsientoContableCajaChicaConstantesFunciones.IDPERIODO));
				entity.setid_usuario(resultSet.getLong(strPrefijo+AsientoContableCajaChicaConstantesFunciones.IDUSUARIO));
				entity.setid_anio(resultSet.getLong(strPrefijo+AsientoContableCajaChicaConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
				entity.setid_mes(resultSet.getLong(strPrefijo+AsientoContableCajaChicaConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
				entity.setsecuencial(resultSet.getLong(strPrefijo+AsientoContableCajaChicaConstantesFunciones.SECUENCIAL));
				entity.setid_moneda(resultSet.getLong(strPrefijo+AsientoContableCajaChicaConstantesFunciones.IDMONEDA));
				entity.setfecha(new Date(resultSet.getDate(strPrefijo+AsientoContableCajaChicaConstantesFunciones.FECHA).getTime()));
				entity.setid_empleado(resultSet.getLong(strPrefijo+AsientoContableCajaChicaConstantesFunciones.IDEMPLEADO));
				entity.setid_estado_asiento_contable(resultSet.getLong(strPrefijo+AsientoContableCajaChicaConstantesFunciones.IDESTADOASIENTOCONTABLECAJACHICA));
				entity.setes_proveedor(resultSet.getBoolean(strPrefijo+AsientoContableCajaChicaConstantesFunciones.ESPROVEEDOR));
				entity.setid_cliente(resultSet.getLong(strPrefijo+AsientoContableCajaChicaConstantesFunciones.IDCLIENTE));
				entity.setid_transaccion(resultSet.getLong(strPrefijo+AsientoContableCajaChicaConstantesFunciones.IDTRANSACCION));
				entity.setid_tipo_documento(resultSet.getLong(strPrefijo+AsientoContableCajaChicaConstantesFunciones.IDTIPODOCUMENTO));
				entity.setid_cuenta_contable(resultSet.getLong(strPrefijo+AsientoContableCajaChicaConstantesFunciones.IDCUENTACONTABLE));
				entity.setdetalle(resultSet.getString(strPrefijo+AsientoContableCajaChicaConstantesFunciones.DETALLE));
				entity.setid_modulo(resultSet.getLong(strPrefijo+AsientoContableCajaChicaConstantesFunciones.IDMODULO));
				entity.setid_tipo_movimiento(resultSet.getLong(strPrefijo+AsientoContableCajaChicaConstantesFunciones.IDTIPOMOVIMIENTO));
				entity.setid_tipo_transaccion_modulo(resultSet.getLong(strPrefijo+AsientoContableCajaChicaConstantesFunciones.IDTIPOTRANSACCIONMODULO));if(resultSet.wasNull()) {entity.setid_tipo_transaccion_modulo(null); }
				entity.setid_tipo_movimiento_modulo(resultSet.getLong(strPrefijo+AsientoContableCajaChicaConstantesFunciones.IDTIPOMOVIMIENTOMODULO));
			} else {
				entity.setsecuencial(resultSet.getLong(strPrefijo+AsientoContableCajaChicaConstantesFunciones.SECUENCIAL));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowAsientoContableCajaChica(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(AsientoContableCajaChica entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=AsientoContableCajaChicaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=AsientoContableCajaChicaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=AsientoContableCajaChicaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=AsientoContableCajaChicaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(AsientoContableCajaChicaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,AsientoContableCajaChicaDataAccess.TABLENAME,AsientoContableCajaChicaDataAccess.ISWITHSTOREPROCEDURES);
			
			AsientoContableCajaChicaDataAccess.setAsientoContableCajaChicaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,AsientoContableCajaChica relasientocontablecajachica)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relasientocontablecajachica.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,AsientoContableCajaChica relasientocontablecajachica)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relasientocontablecajachica.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,AsientoContableCajaChica relasientocontablecajachica)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relasientocontablecajachica.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,AsientoContableCajaChica relasientocontablecajachica)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,relasientocontablecajachica.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public Usuario getUsuario(Connexion connexion,AsientoContableCajaChica relasientocontablecajachica)throws SQLException,Exception {

		Usuario usuario= new Usuario();

		try {
			UsuarioDataAccess usuarioDataAccess=new UsuarioDataAccess();

			usuarioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			usuarioDataAccess.setConnexionType(this.connexionType);
			usuarioDataAccess.setParameterDbType(this.parameterDbType);

			usuario=usuarioDataAccess.getEntity(connexion,relasientocontablecajachica.getid_usuario());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return usuario;

	}

	public Anio getAnio(Connexion connexion,AsientoContableCajaChica relasientocontablecajachica)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);

			anio=anioDataAccess.getEntity(connexion,relasientocontablecajachica.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Mes getMes(Connexion connexion,AsientoContableCajaChica relasientocontablecajachica)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,relasientocontablecajachica.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}

	public Moneda getMoneda(Connexion connexion,AsientoContableCajaChica relasientocontablecajachica)throws SQLException,Exception {

		Moneda moneda= new Moneda();

		try {
			MonedaDataAccess monedaDataAccess=new MonedaDataAccess();

			monedaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			monedaDataAccess.setConnexionType(this.connexionType);
			monedaDataAccess.setParameterDbType(this.parameterDbType);

			moneda=monedaDataAccess.getEntity(connexion,relasientocontablecajachica.getid_moneda());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return moneda;

	}

	public Empleado getEmpleado(Connexion connexion,AsientoContableCajaChica relasientocontablecajachica)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relasientocontablecajachica.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public EstadoAsientoContableCajaChica getEstadoAsientoContableCajaChica(Connexion connexion,AsientoContableCajaChica relasientocontablecajachica)throws SQLException,Exception {

		EstadoAsientoContableCajaChica estadoasientocontablecajachica= new EstadoAsientoContableCajaChica();

		try {
			EstadoAsientoContableCajaChicaDataAccess estadoasientocontablecajachicaDataAccess=new EstadoAsientoContableCajaChicaDataAccess();

			estadoasientocontablecajachicaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadoasientocontablecajachicaDataAccess.setConnexionType(this.connexionType);
			estadoasientocontablecajachicaDataAccess.setParameterDbType(this.parameterDbType);

			estadoasientocontablecajachica=estadoasientocontablecajachicaDataAccess.getEntity(connexion,relasientocontablecajachica.getid_estado_asiento_contable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadoasientocontablecajachica;

	}

	public Cliente getCliente(Connexion connexion,AsientoContableCajaChica relasientocontablecajachica)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,relasientocontablecajachica.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public Transaccion getTransaccion(Connexion connexion,AsientoContableCajaChica relasientocontablecajachica)throws SQLException,Exception {

		Transaccion transaccion= new Transaccion();

		try {
			TransaccionDataAccess transaccionDataAccess=new TransaccionDataAccess();

			transaccionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transaccionDataAccess.setConnexionType(this.connexionType);
			transaccionDataAccess.setParameterDbType(this.parameterDbType);

			transaccion=transaccionDataAccess.getEntity(connexion,relasientocontablecajachica.getid_transaccion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccion;

	}

	public TipoDocumento getTipoDocumento(Connexion connexion,AsientoContableCajaChica relasientocontablecajachica)throws SQLException,Exception {

		TipoDocumento tipodocumento= new TipoDocumento();

		try {
			TipoDocumentoDataAccess tipodocumentoDataAccess=new TipoDocumentoDataAccess();

			tipodocumentoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipodocumentoDataAccess.setConnexionType(this.connexionType);
			tipodocumentoDataAccess.setParameterDbType(this.parameterDbType);

			tipodocumento=tipodocumentoDataAccess.getEntity(connexion,relasientocontablecajachica.getid_tipo_documento());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipodocumento;

	}

	public CuentaContable getCuentaContable(Connexion connexion,AsientoContableCajaChica relasientocontablecajachica)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relasientocontablecajachica.getid_cuenta_contable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public Modulo getModulo(Connexion connexion,AsientoContableCajaChica relasientocontablecajachica)throws SQLException,Exception {

		Modulo modulo= new Modulo();

		try {
			ModuloDataAccess moduloDataAccess=new ModuloDataAccess();

			moduloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			moduloDataAccess.setConnexionType(this.connexionType);
			moduloDataAccess.setParameterDbType(this.parameterDbType);

			modulo=moduloDataAccess.getEntity(connexion,relasientocontablecajachica.getid_modulo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return modulo;

	}

	public TipoMovimiento getTipoMovimiento(Connexion connexion,AsientoContableCajaChica relasientocontablecajachica)throws SQLException,Exception {

		TipoMovimiento tipomovimiento= new TipoMovimiento();

		try {
			TipoMovimientoDataAccess tipomovimientoDataAccess=new TipoMovimientoDataAccess();

			tipomovimientoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipomovimientoDataAccess.setConnexionType(this.connexionType);
			tipomovimientoDataAccess.setParameterDbType(this.parameterDbType);

			tipomovimiento=tipomovimientoDataAccess.getEntity(connexion,relasientocontablecajachica.getid_tipo_movimiento());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipomovimiento;

	}

	public TipoTransaccionModulo getTipoTransaccionModulo(Connexion connexion,AsientoContableCajaChica relasientocontablecajachica)throws SQLException,Exception {

		TipoTransaccionModulo tipotransaccionmodulo= new TipoTransaccionModulo();

		try {
			TipoTransaccionModuloDataAccess tipotransaccionmoduloDataAccess=new TipoTransaccionModuloDataAccess();

			tipotransaccionmoduloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipotransaccionmoduloDataAccess.setConnexionType(this.connexionType);
			tipotransaccionmoduloDataAccess.setParameterDbType(this.parameterDbType);

			tipotransaccionmodulo=tipotransaccionmoduloDataAccess.getEntity(connexion,relasientocontablecajachica.getid_tipo_transaccion_modulo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipotransaccionmodulo;

	}

	public TipoMovimientoModulo getTipoMovimientoModulo(Connexion connexion,AsientoContableCajaChica relasientocontablecajachica)throws SQLException,Exception {

		TipoMovimientoModulo tipomovimientomodulo= new TipoMovimientoModulo();

		try {
			TipoMovimientoModuloDataAccess tipomovimientomoduloDataAccess=new TipoMovimientoModuloDataAccess();

			tipomovimientomoduloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipomovimientomoduloDataAccess.setConnexionType(this.connexionType);
			tipomovimientomoduloDataAccess.setParameterDbType(this.parameterDbType);

			tipomovimientomodulo=tipomovimientomoduloDataAccess.getEntity(connexion,relasientocontablecajachica.getid_tipo_movimiento_modulo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipomovimientomodulo;

	}


		
		public List<DetalleAsientoContableCajaChica> getDetalleAsientoContableCajaChicas(Connexion connexion,AsientoContableCajaChica asientocontablecajachica)throws SQLException,Exception {

		List<DetalleAsientoContableCajaChica> detalleasientocontablecajachicas= new ArrayList<DetalleAsientoContableCajaChica>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+AsientoContableCajaChicaConstantesFunciones.SCHEMA+".asiento_contable_caja_chica ON "+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+".detalle_asiento_contable_caja_chica.id_asiento_contable_caja_chica="+AsientoContableCajaChicaConstantesFunciones.SCHEMA+".asiento_contable_caja_chica.id WHERE "+AsientoContableCajaChicaConstantesFunciones.SCHEMA+".asiento_contable_caja_chica.id="+String.valueOf(asientocontablecajachica.getId());
			} else {
				sQuery=" INNER JOIN detalleasientocontablecajachica.AsientoContableCajaChica WHERE detalleasientocontablecajachica.AsientoContableCajaChica.id="+String.valueOf(asientocontablecajachica.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleAsientoContableCajaChicaDataAccess detalleasientocontablecajachicaDataAccess=new DetalleAsientoContableCajaChicaDataAccess();

			detalleasientocontablecajachicaDataAccess.setConnexionType(this.connexionType);
			detalleasientocontablecajachicaDataAccess.setParameterDbType(this.parameterDbType);
			detalleasientocontablecajachicas=detalleasientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalleasientocontablecajachicas;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,AsientoContableCajaChica asientocontablecajachica) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!asientocontablecajachica.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(asientocontablecajachica.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(asientocontablecajachica.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(asientocontablecajachica.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(asientocontablecajachica.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_usuario=new ParameterValue<Long>();
					parameterMaintenanceValueid_usuario.setValue(asientocontablecajachica.getid_usuario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_usuario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_anio=new ParameterValue<Long>();
					parameterMaintenanceValueid_anio.setValue(asientocontablecajachica.getid_anio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_anio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes.setValue(asientocontablecajachica.getid_mes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValuesecuencial=new ParameterValue<Long>();
					parameterMaintenanceValuesecuencial.setValue(asientocontablecajachica.getsecuencial());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesecuencial);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_moneda=new ParameterValue<Long>();
					parameterMaintenanceValueid_moneda.setValue(asientocontablecajachica.getid_moneda());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_moneda);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha=new ParameterValue<Date>();
					parameterMaintenanceValuefecha.setValue(asientocontablecajachica.getfecha());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(asientocontablecajachica.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_asiento_contable=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_asiento_contable.setValue(asientocontablecajachica.getid_estado_asiento_contable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_asiento_contable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_proveedor=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_proveedor.setValue(asientocontablecajachica.getes_proveedor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_proveedor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_cliente.setValue(asientocontablecajachica.getid_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transaccion=new ParameterValue<Long>();
					parameterMaintenanceValueid_transaccion.setValue(asientocontablecajachica.getid_transaccion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transaccion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_documento=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_documento.setValue(asientocontablecajachica.getid_tipo_documento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_documento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable.setValue(asientocontablecajachica.getid_cuenta_contable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedetalle=new ParameterValue<String>();
					parameterMaintenanceValuedetalle.setValue(asientocontablecajachica.getdetalle());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedetalle);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_modulo=new ParameterValue<Long>();
					parameterMaintenanceValueid_modulo.setValue(asientocontablecajachica.getid_modulo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_modulo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_movimiento=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_movimiento.setValue(asientocontablecajachica.getid_tipo_movimiento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_movimiento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_transaccion_modulo=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_transaccion_modulo.setValue(asientocontablecajachica.getid_tipo_transaccion_modulo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_transaccion_modulo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_movimiento_modulo=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_movimiento_modulo.setValue(asientocontablecajachica.getid_tipo_movimiento_modulo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_movimiento_modulo);
					parametersTemp.add(parameterMaintenance);
					
						if(!asientocontablecajachica.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(asientocontablecajachica.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(asientocontablecajachica.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(asientocontablecajachica.getId());
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
	
	public void setIsNewIsChangedFalseAsientoContableCajaChica(AsientoContableCajaChica asientocontablecajachica)throws Exception  {		
		asientocontablecajachica.setIsNew(false);
		asientocontablecajachica.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseAsientoContableCajaChicas(List<AsientoContableCajaChica> asientocontablecajachicas)throws Exception  {				
		for(AsientoContableCajaChica asientocontablecajachica:asientocontablecajachicas) {
			asientocontablecajachica.setIsNew(false);
			asientocontablecajachica.setIsChanged(false);
		}
	}
	
	public void generarExportarAsientoContableCajaChica(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
