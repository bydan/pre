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
import com.bydan.erp.contabilidad.util.*;//DetalleAsientoContableCajaChicaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.facturacion.util.*;




@SuppressWarnings("unused")
final public class DetalleAsientoContableCajaChicaDataAccess extends  DetalleAsientoContableCajaChicaDataAccessAdditional{ //DetalleAsientoContableCajaChicaDataAccessAdditional,DataAccessHelper<DetalleAsientoContableCajaChica>
	//static Logger logger = Logger.getLogger(DetalleAsientoContableCajaChicaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="detalle_asiento_contable_caja_chica";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_modulo,id_ejercicio,id_periodo,id_anio,id_mes,id_asiento_contable_caja_chica,id_tipo_gasto_empresa,fecha_emision,id_transaccion,id_factura,es_proveedor,id_asiento_contable,detalle,valor_bien_tarifa12,valor_servicio_tarifa12,porcentaje_iva,valor_bien_tarifa0,valor_servicio_tarifa0,valor_iva,valor_bien_ice,valor_servicio_ice,id_centro_costo,id_tipo_cambio,id_tipo_transaccion_modulo,fecha)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_modulo=?,id_ejercicio=?,id_periodo=?,id_anio=?,id_mes=?,id_asiento_contable_caja_chica=?,id_tipo_gasto_empresa=?,fecha_emision=?,id_transaccion=?,id_factura=?,es_proveedor=?,id_asiento_contable=?,detalle=?,valor_bien_tarifa12=?,valor_servicio_tarifa12=?,porcentaje_iva=?,valor_bien_tarifa0=?,valor_servicio_tarifa0=?,valor_iva=?,valor_bien_ice=?,valor_servicio_ice=?,id_centro_costo=?,id_tipo_cambio=?,id_tipo_transaccion_modulo=?,fecha=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select detalleasientocontablecajachica from "+DetalleAsientoContableCajaChicaConstantesFunciones.SPERSISTENCENAME+" detalleasientocontablecajachica";
	public static String QUERYSELECTNATIVE="select "+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME+".id,"+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME+".version_row,"+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME+".id_empresa,"+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME+".id_sucursal,"+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME+".id_modulo,"+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME+".id_ejercicio,"+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME+".id_periodo,"+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME+".id_anio,"+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME+".id_mes,"+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME+".id_asiento_contable_caja_chica,"+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME+".id_tipo_gasto_empresa,"+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME+".fecha_emision,"+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME+".id_transaccion,"+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME+".id_factura,"+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME+".es_proveedor,"+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME+".id_asiento_contable,"+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME+".detalle,"+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME+".valor_bien_tarifa12,"+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME+".valor_servicio_tarifa12,"+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME+".porcentaje_iva,"+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME+".valor_bien_tarifa0,"+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME+".valor_servicio_tarifa0,"+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME+".valor_iva,"+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME+".valor_bien_ice,"+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME+".valor_servicio_ice,"+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME+".id_centro_costo,"+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME+".id_tipo_cambio,"+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME+".id_tipo_transaccion_modulo,"+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME+".fecha from "+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME;//+" as "+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME+".id,"+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME+".version_row from "+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME;//+" as "+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_modulo=?,id_ejercicio=?,id_periodo=?,id_anio=?,id_mes=?,id_asiento_contable_caja_chica=?,id_tipo_gasto_empresa=?,fecha_emision=?,id_transaccion=?,id_factura=?,es_proveedor=?,id_asiento_contable=?,detalle=?,valor_bien_tarifa12=?,valor_servicio_tarifa12=?,porcentaje_iva=?,valor_bien_tarifa0=?,valor_servicio_tarifa0=?,valor_iva=?,valor_bien_ice=?,valor_servicio_ice=?,id_centro_costo=?,id_tipo_cambio=?,id_tipo_transaccion_modulo=?,fecha=?";
	
	public static String STOREPROCEDUREINSERT="call SP_DETALLEASIENTOCONTABLECAJACHICA_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_DETALLEASIENTOCONTABLECAJACHICA_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_DETALLEASIENTOCONTABLECAJACHICA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_DETALLEASIENTOCONTABLECAJACHICA_SELECT(?,?)";
	
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
	
	
	protected DetalleAsientoContableCajaChicaDataAccessAdditional detalleasientocontablecajachicaDataAccessAdditional=null;
	
	public DetalleAsientoContableCajaChicaDataAccessAdditional getDetalleAsientoContableCajaChicaDataAccessAdditional() {
		return this.detalleasientocontablecajachicaDataAccessAdditional;
	}
	
	public void setDetalleAsientoContableCajaChicaDataAccessAdditional(DetalleAsientoContableCajaChicaDataAccessAdditional detalleasientocontablecajachicaDataAccessAdditional) {
		try {
			this.detalleasientocontablecajachicaDataAccessAdditional=detalleasientocontablecajachicaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public DetalleAsientoContableCajaChicaDataAccess() {
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
		DetalleAsientoContableCajaChicaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		DetalleAsientoContableCajaChicaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		DetalleAsientoContableCajaChicaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setDetalleAsientoContableCajaChicaOriginal(DetalleAsientoContableCajaChica detalleasientocontablecajachica)throws Exception  {
		detalleasientocontablecajachica.setDetalleAsientoContableCajaChicaOriginal((DetalleAsientoContableCajaChica)detalleasientocontablecajachica.clone());		
	}
	
	public void setDetalleAsientoContableCajaChicasOriginal(List<DetalleAsientoContableCajaChica> detalleasientocontablecajachicas)throws Exception  {
		
		for(DetalleAsientoContableCajaChica detalleasientocontablecajachica:detalleasientocontablecajachicas){
			detalleasientocontablecajachica.setDetalleAsientoContableCajaChicaOriginal((DetalleAsientoContableCajaChica)detalleasientocontablecajachica.clone());
		}
	}
	
	public static void setDetalleAsientoContableCajaChicaOriginalStatic(DetalleAsientoContableCajaChica detalleasientocontablecajachica)throws Exception  {
		detalleasientocontablecajachica.setDetalleAsientoContableCajaChicaOriginal((DetalleAsientoContableCajaChica)detalleasientocontablecajachica.clone());		
	}
	
	public static void setDetalleAsientoContableCajaChicasOriginalStatic(List<DetalleAsientoContableCajaChica> detalleasientocontablecajachicas)throws Exception  {
		
		for(DetalleAsientoContableCajaChica detalleasientocontablecajachica:detalleasientocontablecajachicas){
			detalleasientocontablecajachica.setDetalleAsientoContableCajaChicaOriginal((DetalleAsientoContableCajaChica)detalleasientocontablecajachica.clone());
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
	
	public  DetalleAsientoContableCajaChica getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		DetalleAsientoContableCajaChica entity = new DetalleAsientoContableCajaChica();		
		
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
	
	public  DetalleAsientoContableCajaChica getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		DetalleAsientoContableCajaChica entity = new DetalleAsientoContableCajaChica();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleAsientoContableCajaChicaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleAsientoContableCajaChicaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Contabilidad.DetalleAsientoContableCajaChica.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setDetalleAsientoContableCajaChicaOriginal(new DetalleAsientoContableCajaChica());
      	    	entity=super.getEntity("",entity,resultSet,DetalleAsientoContableCajaChicaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetalleAsientoContableCajaChica("",entity,resultSet); 
				
				//entity.setDetalleAsientoContableCajaChicaOriginal(super.getEntity("",entity.getDetalleAsientoContableCajaChicaOriginal(),resultSet,DetalleAsientoContableCajaChicaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleAsientoContableCajaChicaOriginal(this.getEntityDetalleAsientoContableCajaChica("",entity.getDetalleAsientoContableCajaChicaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseDetalleAsientoContableCajaChica(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  DetalleAsientoContableCajaChica getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetalleAsientoContableCajaChica entity = new DetalleAsientoContableCajaChica();
				
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
	
	public  DetalleAsientoContableCajaChica getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetalleAsientoContableCajaChica entity = new DetalleAsientoContableCajaChica();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleAsientoContableCajaChicaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleAsientoContableCajaChicaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleAsientoContableCajaChicaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.DetalleAsientoContableCajaChica.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setDetalleAsientoContableCajaChicaOriginal(new DetalleAsientoContableCajaChica());
      	    	entity=super.getEntity("",entity,resultSet,DetalleAsientoContableCajaChicaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetalleAsientoContableCajaChica("",entity,resultSet);    
				
				//entity.setDetalleAsientoContableCajaChicaOriginal(super.getEntity("",entity.getDetalleAsientoContableCajaChicaOriginal(),resultSet,DetalleAsientoContableCajaChicaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleAsientoContableCajaChicaOriginal(this.getEntityDetalleAsientoContableCajaChica("",entity.getDetalleAsientoContableCajaChicaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseDetalleAsientoContableCajaChica(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //DetalleAsientoContableCajaChica
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		DetalleAsientoContableCajaChica entity = new DetalleAsientoContableCajaChica();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleAsientoContableCajaChicaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleAsientoContableCajaChicaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleAsientoContableCajaChicaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.DetalleAsientoContableCajaChica.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseDetalleAsientoContableCajaChica(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<DetalleAsientoContableCajaChica> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetalleAsientoContableCajaChica> entities = new  ArrayList<DetalleAsientoContableCajaChica>();
		DetalleAsientoContableCajaChica entity = new DetalleAsientoContableCajaChica();		  
		
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
	
	public  List<DetalleAsientoContableCajaChica> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetalleAsientoContableCajaChica> entities = new  ArrayList<DetalleAsientoContableCajaChica>();
		DetalleAsientoContableCajaChica entity = new DetalleAsientoContableCajaChica();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleAsientoContableCajaChicaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleAsientoContableCajaChicaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleAsientoContableCajaChicaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleAsientoContableCajaChica();
      	    	entity=super.getEntity("",entity,resultSet,DetalleAsientoContableCajaChicaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleAsientoContableCajaChica("",entity,resultSet);
      	    	
				//entity.setDetalleAsientoContableCajaChicaOriginal( new DetalleAsientoContableCajaChica());
      	    	//entity.setDetalleAsientoContableCajaChicaOriginal(super.getEntity("",entity.getDetalleAsientoContableCajaChicaOriginal(),resultSet,DetalleAsientoContableCajaChicaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleAsientoContableCajaChicaOriginal(this.getEntityDetalleAsientoContableCajaChica("",entity.getDetalleAsientoContableCajaChicaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleAsientoContableCajaChicas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleAsientoContableCajaChica(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetalleAsientoContableCajaChica> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetalleAsientoContableCajaChica> entities = new  ArrayList<DetalleAsientoContableCajaChica>();
		DetalleAsientoContableCajaChica entity = new DetalleAsientoContableCajaChica();		  
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
	
	public  List<DetalleAsientoContableCajaChica> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetalleAsientoContableCajaChica> entities = new  ArrayList<DetalleAsientoContableCajaChica>();
		DetalleAsientoContableCajaChica entity = new DetalleAsientoContableCajaChica();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleAsientoContableCajaChica();
				
				if(conMapGenerico) {
					entity.inicializarMapDetalleAsientoContableCajaChica();
					//entity.setMapDetalleAsientoContableCajaChica(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapDetalleAsientoContableCajaChicaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetalleAsientoContableCajaChica().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetalleAsientoContableCajaChicaDataAccess.ISWITHSCHEMA);         		
					entity=DetalleAsientoContableCajaChicaDataAccess.getEntityDetalleAsientoContableCajaChica("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetalleAsientoContableCajaChicaOriginal( new DetalleAsientoContableCajaChica());
					////entity.setDetalleAsientoContableCajaChicaOriginal(super.getEntity("",entity.getDetalleAsientoContableCajaChicaOriginal(),resultSet,DetalleAsientoContableCajaChicaDataAccess.ISWITHSCHEMA));         		
					////entity.setDetalleAsientoContableCajaChicaOriginal(this.getEntityDetalleAsientoContableCajaChica("",entity.getDetalleAsientoContableCajaChicaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleAsientoContableCajaChicas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleAsientoContableCajaChica(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public DetalleAsientoContableCajaChica getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetalleAsientoContableCajaChica entity = new DetalleAsientoContableCajaChica();		  
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
	
	public  DetalleAsientoContableCajaChica getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetalleAsientoContableCajaChica entity = new DetalleAsientoContableCajaChica();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleAsientoContableCajaChica();
				
				if(conMapGenerico) {
					entity.inicializarMapDetalleAsientoContableCajaChica();
					//entity.setMapDetalleAsientoContableCajaChica(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapDetalleAsientoContableCajaChicaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetalleAsientoContableCajaChica().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetalleAsientoContableCajaChicaDataAccess.ISWITHSCHEMA);         		
					entity=DetalleAsientoContableCajaChicaDataAccess.getEntityDetalleAsientoContableCajaChica("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetalleAsientoContableCajaChicaOriginal( new DetalleAsientoContableCajaChica());
					////entity.setDetalleAsientoContableCajaChicaOriginal(super.getEntity("",entity.getDetalleAsientoContableCajaChicaOriginal(),resultSet,DetalleAsientoContableCajaChicaDataAccess.ISWITHSCHEMA));         		
					////entity.setDetalleAsientoContableCajaChicaOriginal(this.getEntityDetalleAsientoContableCajaChica("",entity.getDetalleAsientoContableCajaChicaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseDetalleAsientoContableCajaChica(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleAsientoContableCajaChica(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static DetalleAsientoContableCajaChica getEntityDetalleAsientoContableCajaChica(String strPrefijo,DetalleAsientoContableCajaChica entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = DetalleAsientoContableCajaChica.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = DetalleAsientoContableCajaChica.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					DetalleAsientoContableCajaChicaDataAccess.setFieldReflectionDetalleAsientoContableCajaChica(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasDetalleAsientoContableCajaChica=DetalleAsientoContableCajaChicaConstantesFunciones.getTodosTiposColumnasDetalleAsientoContableCajaChica();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasDetalleAsientoContableCajaChica) {
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
							field = DetalleAsientoContableCajaChica.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = DetalleAsientoContableCajaChica.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						DetalleAsientoContableCajaChicaDataAccess.setFieldReflectionDetalleAsientoContableCajaChica(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionDetalleAsientoContableCajaChica(Field field,String strPrefijo,String sColumn,DetalleAsientoContableCajaChica entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case DetalleAsientoContableCajaChicaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleAsientoContableCajaChicaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleAsientoContableCajaChicaConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleAsientoContableCajaChicaConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleAsientoContableCajaChicaConstantesFunciones.IDMODULO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleAsientoContableCajaChicaConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleAsientoContableCajaChicaConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleAsientoContableCajaChicaConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleAsientoContableCajaChicaConstantesFunciones.IDMES:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleAsientoContableCajaChicaConstantesFunciones.IDASIENTOCONTABLECAJACHICA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleAsientoContableCajaChicaConstantesFunciones.IDTIPOGASTOEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleAsientoContableCajaChicaConstantesFunciones.FECHAEMISION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case DetalleAsientoContableCajaChicaConstantesFunciones.IDTRANSACCION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleAsientoContableCajaChicaConstantesFunciones.IDFACTURA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleAsientoContableCajaChicaConstantesFunciones.ESPROVEEDOR:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case DetalleAsientoContableCajaChicaConstantesFunciones.IDASIENTOCONTABLE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleAsientoContableCajaChicaConstantesFunciones.DETALLE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleAsientoContableCajaChicaConstantesFunciones.VALORBIENTARIFA12:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleAsientoContableCajaChicaConstantesFunciones.VALORSERVICIOTARIFA12:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleAsientoContableCajaChicaConstantesFunciones.PORCENTAJEIVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleAsientoContableCajaChicaConstantesFunciones.VALORBIENTARIFA0:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleAsientoContableCajaChicaConstantesFunciones.VALORSERVICIOTARIFA0:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleAsientoContableCajaChicaConstantesFunciones.VALORIVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleAsientoContableCajaChicaConstantesFunciones.VALORBIENICE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleAsientoContableCajaChicaConstantesFunciones.VALORSERVICIOICE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleAsientoContableCajaChicaConstantesFunciones.IDCENTROCOSTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleAsientoContableCajaChicaConstantesFunciones.IDTIPOCAMBIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleAsientoContableCajaChicaConstantesFunciones.IDTIPOTRANSACCIONMODULO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleAsientoContableCajaChicaConstantesFunciones.FECHA:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetalleAsientoContableCajaChica>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<DetalleAsientoContableCajaChica> entities = new  ArrayList<DetalleAsientoContableCajaChica>();
		DetalleAsientoContableCajaChica entity = new DetalleAsientoContableCajaChica();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleAsientoContableCajaChicaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleAsientoContableCajaChicaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleAsientoContableCajaChicaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new DetalleAsientoContableCajaChica();
					entity=super.getEntity("",entity,resultSet,DetalleAsientoContableCajaChicaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityDetalleAsientoContableCajaChica("",entity,resultSet);
					
					//entity.setDetalleAsientoContableCajaChicaOriginal( new DetalleAsientoContableCajaChica());
					//entity.setDetalleAsientoContableCajaChicaOriginal(super.getEntity("",entity.getDetalleAsientoContableCajaChicaOriginal(),resultSet,DetalleAsientoContableCajaChicaDataAccess.ISWITHSCHEMA));         		
					//entity.setDetalleAsientoContableCajaChicaOriginal(this.getEntityDetalleAsientoContableCajaChica("",entity.getDetalleAsientoContableCajaChicaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseDetalleAsientoContableCajaChicas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleAsientoContableCajaChica(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetalleAsientoContableCajaChica>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<DetalleAsientoContableCajaChica> entities = new  ArrayList<DetalleAsientoContableCajaChica>();
		DetalleAsientoContableCajaChica entity = new DetalleAsientoContableCajaChica();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleAsientoContableCajaChicaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleAsientoContableCajaChicaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleAsientoContableCajaChicaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<DetalleAsientoContableCajaChica> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleAsientoContableCajaChica> entities = new  ArrayList<DetalleAsientoContableCajaChica>();
		DetalleAsientoContableCajaChica entity = new DetalleAsientoContableCajaChica();		  
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
	
	public  List<DetalleAsientoContableCajaChica> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleAsientoContableCajaChica> entities = new  ArrayList<DetalleAsientoContableCajaChica>();
		DetalleAsientoContableCajaChica entity = new DetalleAsientoContableCajaChica();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleAsientoContableCajaChica();
      	    	entity=super.getEntity("",entity,resultSet,DetalleAsientoContableCajaChicaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleAsientoContableCajaChica("",entity,resultSet);
      	    	
				//entity.setDetalleAsientoContableCajaChicaOriginal( new DetalleAsientoContableCajaChica());
      	    	//entity.setDetalleAsientoContableCajaChicaOriginal(super.getEntity("",entity.getDetalleAsientoContableCajaChicaOriginal(),resultSet,DetalleAsientoContableCajaChicaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleAsientoContableCajaChicaOriginal(this.getEntityDetalleAsientoContableCajaChica("",entity.getDetalleAsientoContableCajaChicaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseDetalleAsientoContableCajaChicas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleAsientoContableCajaChica(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetalleAsientoContableCajaChica> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleAsientoContableCajaChica> entities = new  ArrayList<DetalleAsientoContableCajaChica>();
		DetalleAsientoContableCajaChica entity = new DetalleAsientoContableCajaChica();		  
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
	
	public  List<DetalleAsientoContableCajaChica> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleAsientoContableCajaChica> entities = new  ArrayList<DetalleAsientoContableCajaChica>();
		DetalleAsientoContableCajaChica entity = new DetalleAsientoContableCajaChica();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleAsientoContableCajaChica();
      	    	entity=super.getEntity("",entity,resultSet,DetalleAsientoContableCajaChicaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleAsientoContableCajaChica("",entity,resultSet);
      	    	
				//entity.setDetalleAsientoContableCajaChicaOriginal( new DetalleAsientoContableCajaChica());
      	    	//entity.setDetalleAsientoContableCajaChicaOriginal(super.getEntity("",entity.getDetalleAsientoContableCajaChicaOriginal(),resultSet,DetalleAsientoContableCajaChicaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleAsientoContableCajaChicaOriginal(this.getEntityDetalleAsientoContableCajaChica("",entity.getDetalleAsientoContableCajaChicaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleAsientoContableCajaChicas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public DetalleAsientoContableCajaChica getEntityDetalleAsientoContableCajaChica(String strPrefijo,DetalleAsientoContableCajaChica entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+DetalleAsientoContableCajaChicaConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+DetalleAsientoContableCajaChicaConstantesFunciones.IDSUCURSAL));
				entity.setid_modulo(resultSet.getLong(strPrefijo+DetalleAsientoContableCajaChicaConstantesFunciones.IDMODULO));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+DetalleAsientoContableCajaChicaConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+DetalleAsientoContableCajaChicaConstantesFunciones.IDPERIODO));
				entity.setid_anio(resultSet.getLong(strPrefijo+DetalleAsientoContableCajaChicaConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
				entity.setid_mes(resultSet.getLong(strPrefijo+DetalleAsientoContableCajaChicaConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
				entity.setid_asiento_contable_caja_chica(resultSet.getLong(strPrefijo+DetalleAsientoContableCajaChicaConstantesFunciones.IDASIENTOCONTABLECAJACHICA));
				entity.setid_tipo_gasto_empresa(resultSet.getLong(strPrefijo+DetalleAsientoContableCajaChicaConstantesFunciones.IDTIPOGASTOEMPRESA));
				entity.setfecha_emision(new Date(resultSet.getDate(strPrefijo+DetalleAsientoContableCajaChicaConstantesFunciones.FECHAEMISION).getTime()));
				entity.setid_transaccion(resultSet.getLong(strPrefijo+DetalleAsientoContableCajaChicaConstantesFunciones.IDTRANSACCION));
				entity.setid_factura(resultSet.getLong(strPrefijo+DetalleAsientoContableCajaChicaConstantesFunciones.IDFACTURA));if(resultSet.wasNull()) {entity.setid_factura(null); }
				entity.setes_proveedor(resultSet.getBoolean(strPrefijo+DetalleAsientoContableCajaChicaConstantesFunciones.ESPROVEEDOR));
				entity.setid_asiento_contable(resultSet.getLong(strPrefijo+DetalleAsientoContableCajaChicaConstantesFunciones.IDASIENTOCONTABLE));if(resultSet.wasNull()) {entity.setid_asiento_contable(null); }
				entity.setdetalle(resultSet.getString(strPrefijo+DetalleAsientoContableCajaChicaConstantesFunciones.DETALLE));
				entity.setvalor_bien_tarifa12(resultSet.getDouble(strPrefijo+DetalleAsientoContableCajaChicaConstantesFunciones.VALORBIENTARIFA12));
				entity.setvalor_servicio_tarifa12(resultSet.getDouble(strPrefijo+DetalleAsientoContableCajaChicaConstantesFunciones.VALORSERVICIOTARIFA12));
				entity.setporcentaje_iva(resultSet.getDouble(strPrefijo+DetalleAsientoContableCajaChicaConstantesFunciones.PORCENTAJEIVA));
				entity.setvalor_bien_tarifa0(resultSet.getDouble(strPrefijo+DetalleAsientoContableCajaChicaConstantesFunciones.VALORBIENTARIFA0));
				entity.setvalor_servicio_tarifa0(resultSet.getDouble(strPrefijo+DetalleAsientoContableCajaChicaConstantesFunciones.VALORSERVICIOTARIFA0));
				entity.setvalor_iva(resultSet.getDouble(strPrefijo+DetalleAsientoContableCajaChicaConstantesFunciones.VALORIVA));
				entity.setvalor_bien_ice(resultSet.getDouble(strPrefijo+DetalleAsientoContableCajaChicaConstantesFunciones.VALORBIENICE));
				entity.setvalor_servicio_ice(resultSet.getDouble(strPrefijo+DetalleAsientoContableCajaChicaConstantesFunciones.VALORSERVICIOICE));
				entity.setid_centro_costo(resultSet.getLong(strPrefijo+DetalleAsientoContableCajaChicaConstantesFunciones.IDCENTROCOSTO));if(resultSet.wasNull()) {entity.setid_centro_costo(null); }
				entity.setid_tipo_cambio(resultSet.getLong(strPrefijo+DetalleAsientoContableCajaChicaConstantesFunciones.IDTIPOCAMBIO));if(resultSet.wasNull()) {entity.setid_tipo_cambio(null); }
				entity.setid_tipo_transaccion_modulo(resultSet.getLong(strPrefijo+DetalleAsientoContableCajaChicaConstantesFunciones.IDTIPOTRANSACCIONMODULO));if(resultSet.wasNull()) {entity.setid_tipo_transaccion_modulo(null); }
				entity.setfecha(new Date(resultSet.getDate(strPrefijo+DetalleAsientoContableCajaChicaConstantesFunciones.FECHA).getTime()));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowDetalleAsientoContableCajaChica(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(DetalleAsientoContableCajaChica entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=DetalleAsientoContableCajaChicaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=DetalleAsientoContableCajaChicaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=DetalleAsientoContableCajaChicaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=DetalleAsientoContableCajaChicaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(DetalleAsientoContableCajaChicaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,DetalleAsientoContableCajaChicaDataAccess.TABLENAME,DetalleAsientoContableCajaChicaDataAccess.ISWITHSTOREPROCEDURES);
			
			DetalleAsientoContableCajaChicaDataAccess.setDetalleAsientoContableCajaChicaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,DetalleAsientoContableCajaChica reldetalleasientocontablecajachica)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reldetalleasientocontablecajachica.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,DetalleAsientoContableCajaChica reldetalleasientocontablecajachica)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,reldetalleasientocontablecajachica.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Modulo getModulo(Connexion connexion,DetalleAsientoContableCajaChica reldetalleasientocontablecajachica)throws SQLException,Exception {

		Modulo modulo= new Modulo();

		try {
			ModuloDataAccess moduloDataAccess=new ModuloDataAccess();

			moduloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			moduloDataAccess.setConnexionType(this.connexionType);
			moduloDataAccess.setParameterDbType(this.parameterDbType);

			modulo=moduloDataAccess.getEntity(connexion,reldetalleasientocontablecajachica.getid_modulo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return modulo;

	}

	public Ejercicio getEjercicio(Connexion connexion,DetalleAsientoContableCajaChica reldetalleasientocontablecajachica)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,reldetalleasientocontablecajachica.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,DetalleAsientoContableCajaChica reldetalleasientocontablecajachica)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,reldetalleasientocontablecajachica.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public Anio getAnio(Connexion connexion,DetalleAsientoContableCajaChica reldetalleasientocontablecajachica)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);

			anio=anioDataAccess.getEntity(connexion,reldetalleasientocontablecajachica.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Mes getMes(Connexion connexion,DetalleAsientoContableCajaChica reldetalleasientocontablecajachica)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,reldetalleasientocontablecajachica.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}

	public AsientoContableCajaChica getAsientoContableCajaChica(Connexion connexion,DetalleAsientoContableCajaChica reldetalleasientocontablecajachica)throws SQLException,Exception {

		AsientoContableCajaChica asientocontablecajachica= new AsientoContableCajaChica();

		try {
			AsientoContableCajaChicaDataAccess asientocontablecajachicaDataAccess=new AsientoContableCajaChicaDataAccess();

			asientocontablecajachicaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			asientocontablecajachicaDataAccess.setConnexionType(this.connexionType);
			asientocontablecajachicaDataAccess.setParameterDbType(this.parameterDbType);

			asientocontablecajachica=asientocontablecajachicaDataAccess.getEntity(connexion,reldetalleasientocontablecajachica.getid_asiento_contable_caja_chica());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return asientocontablecajachica;

	}

	public TipoGastoEmpresa getTipoGastoEmpresa(Connexion connexion,DetalleAsientoContableCajaChica reldetalleasientocontablecajachica)throws SQLException,Exception {

		TipoGastoEmpresa tipogastoempresa= new TipoGastoEmpresa();

		try {
			TipoGastoEmpresaDataAccess tipogastoempresaDataAccess=new TipoGastoEmpresaDataAccess();

			tipogastoempresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipogastoempresaDataAccess.setConnexionType(this.connexionType);
			tipogastoempresaDataAccess.setParameterDbType(this.parameterDbType);

			tipogastoempresa=tipogastoempresaDataAccess.getEntity(connexion,reldetalleasientocontablecajachica.getid_tipo_gasto_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipogastoempresa;

	}

	public Transaccion getTransaccion(Connexion connexion,DetalleAsientoContableCajaChica reldetalleasientocontablecajachica)throws SQLException,Exception {

		Transaccion transaccion= new Transaccion();

		try {
			TransaccionDataAccess transaccionDataAccess=new TransaccionDataAccess();

			transaccionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transaccionDataAccess.setConnexionType(this.connexionType);
			transaccionDataAccess.setParameterDbType(this.parameterDbType);

			transaccion=transaccionDataAccess.getEntity(connexion,reldetalleasientocontablecajachica.getid_transaccion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccion;

	}

	public Factura getFactura(Connexion connexion,DetalleAsientoContableCajaChica reldetalleasientocontablecajachica)throws SQLException,Exception {

		Factura factura= new Factura();

		try {
			FacturaDataAccess facturaDataAccess=new FacturaDataAccess();

			facturaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			facturaDataAccess.setConnexionType(this.connexionType);
			facturaDataAccess.setParameterDbType(this.parameterDbType);

			factura=facturaDataAccess.getEntity(connexion,reldetalleasientocontablecajachica.getid_factura());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return factura;

	}

	public AsientoContable getAsientoContable(Connexion connexion,DetalleAsientoContableCajaChica reldetalleasientocontablecajachica)throws SQLException,Exception {

		AsientoContable asientocontable= new AsientoContable();

		try {
			AsientoContableDataAccess asientocontableDataAccess=new AsientoContableDataAccess();

			asientocontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			asientocontableDataAccess.setConnexionType(this.connexionType);
			asientocontableDataAccess.setParameterDbType(this.parameterDbType);

			asientocontable=asientocontableDataAccess.getEntity(connexion,reldetalleasientocontablecajachica.getid_asiento_contable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return asientocontable;

	}

	public CentroCosto getCentroCosto(Connexion connexion,DetalleAsientoContableCajaChica reldetalleasientocontablecajachica)throws SQLException,Exception {

		CentroCosto centrocosto= new CentroCosto();

		try {
			CentroCostoDataAccess centrocostoDataAccess=new CentroCostoDataAccess();

			centrocostoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			centrocostoDataAccess.setConnexionType(this.connexionType);
			centrocostoDataAccess.setParameterDbType(this.parameterDbType);

			centrocosto=centrocostoDataAccess.getEntity(connexion,reldetalleasientocontablecajachica.getid_centro_costo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return centrocosto;

	}

	public TipoCambio getTipoCambio(Connexion connexion,DetalleAsientoContableCajaChica reldetalleasientocontablecajachica)throws SQLException,Exception {

		TipoCambio tipocambio= new TipoCambio();

		try {
			TipoCambioDataAccess tipocambioDataAccess=new TipoCambioDataAccess();

			tipocambioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipocambioDataAccess.setConnexionType(this.connexionType);
			tipocambioDataAccess.setParameterDbType(this.parameterDbType);

			tipocambio=tipocambioDataAccess.getEntity(connexion,reldetalleasientocontablecajachica.getid_tipo_cambio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipocambio;

	}

	public TipoTransaccionModulo getTipoTransaccionModulo(Connexion connexion,DetalleAsientoContableCajaChica reldetalleasientocontablecajachica)throws SQLException,Exception {

		TipoTransaccionModulo tipotransaccionmodulo= new TipoTransaccionModulo();

		try {
			TipoTransaccionModuloDataAccess tipotransaccionmoduloDataAccess=new TipoTransaccionModuloDataAccess();

			tipotransaccionmoduloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipotransaccionmoduloDataAccess.setConnexionType(this.connexionType);
			tipotransaccionmoduloDataAccess.setParameterDbType(this.parameterDbType);

			tipotransaccionmodulo=tipotransaccionmoduloDataAccess.getEntity(connexion,reldetalleasientocontablecajachica.getid_tipo_transaccion_modulo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipotransaccionmodulo;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,DetalleAsientoContableCajaChica detalleasientocontablecajachica) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!detalleasientocontablecajachica.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(detalleasientocontablecajachica.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(detalleasientocontablecajachica.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_modulo=new ParameterValue<Long>();
					parameterMaintenanceValueid_modulo.setValue(detalleasientocontablecajachica.getid_modulo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_modulo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(detalleasientocontablecajachica.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(detalleasientocontablecajachica.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_anio=new ParameterValue<Long>();
					parameterMaintenanceValueid_anio.setValue(detalleasientocontablecajachica.getid_anio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_anio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes.setValue(detalleasientocontablecajachica.getid_mes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_asiento_contable_caja_chica=new ParameterValue<Long>();
					parameterMaintenanceValueid_asiento_contable_caja_chica.setValue(detalleasientocontablecajachica.getid_asiento_contable_caja_chica());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_asiento_contable_caja_chica);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_gasto_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_gasto_empresa.setValue(detalleasientocontablecajachica.getid_tipo_gasto_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_gasto_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_emision=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_emision.setValue(detalleasientocontablecajachica.getfecha_emision());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_emision);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transaccion=new ParameterValue<Long>();
					parameterMaintenanceValueid_transaccion.setValue(detalleasientocontablecajachica.getid_transaccion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transaccion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_factura=new ParameterValue<Long>();
					parameterMaintenanceValueid_factura.setValue(detalleasientocontablecajachica.getid_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_proveedor=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_proveedor.setValue(detalleasientocontablecajachica.getes_proveedor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_proveedor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_asiento_contable=new ParameterValue<Long>();
					parameterMaintenanceValueid_asiento_contable.setValue(detalleasientocontablecajachica.getid_asiento_contable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_asiento_contable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedetalle=new ParameterValue<String>();
					parameterMaintenanceValuedetalle.setValue(detalleasientocontablecajachica.getdetalle());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedetalle);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_bien_tarifa12=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_bien_tarifa12.setValue(detalleasientocontablecajachica.getvalor_bien_tarifa12());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_bien_tarifa12);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_servicio_tarifa12=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_servicio_tarifa12.setValue(detalleasientocontablecajachica.getvalor_servicio_tarifa12());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_servicio_tarifa12);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcentaje_iva=new ParameterValue<Double>();
					parameterMaintenanceValueporcentaje_iva.setValue(detalleasientocontablecajachica.getporcentaje_iva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcentaje_iva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_bien_tarifa0=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_bien_tarifa0.setValue(detalleasientocontablecajachica.getvalor_bien_tarifa0());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_bien_tarifa0);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_servicio_tarifa0=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_servicio_tarifa0.setValue(detalleasientocontablecajachica.getvalor_servicio_tarifa0());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_servicio_tarifa0);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_iva=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_iva.setValue(detalleasientocontablecajachica.getvalor_iva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_iva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_bien_ice=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_bien_ice.setValue(detalleasientocontablecajachica.getvalor_bien_ice());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_bien_ice);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_servicio_ice=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_servicio_ice.setValue(detalleasientocontablecajachica.getvalor_servicio_ice());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_servicio_ice);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_centro_costo=new ParameterValue<Long>();
					parameterMaintenanceValueid_centro_costo.setValue(detalleasientocontablecajachica.getid_centro_costo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_centro_costo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_cambio=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_cambio.setValue(detalleasientocontablecajachica.getid_tipo_cambio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_cambio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_transaccion_modulo=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_transaccion_modulo.setValue(detalleasientocontablecajachica.getid_tipo_transaccion_modulo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_transaccion_modulo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha=new ParameterValue<Date>();
					parameterMaintenanceValuefecha.setValue(detalleasientocontablecajachica.getfecha());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha);
					parametersTemp.add(parameterMaintenance);
					
						if(!detalleasientocontablecajachica.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(detalleasientocontablecajachica.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(detalleasientocontablecajachica.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(detalleasientocontablecajachica.getId());
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
	
	public void setIsNewIsChangedFalseDetalleAsientoContableCajaChica(DetalleAsientoContableCajaChica detalleasientocontablecajachica)throws Exception  {		
		detalleasientocontablecajachica.setIsNew(false);
		detalleasientocontablecajachica.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseDetalleAsientoContableCajaChicas(List<DetalleAsientoContableCajaChica> detalleasientocontablecajachicas)throws Exception  {				
		for(DetalleAsientoContableCajaChica detalleasientocontablecajachica:detalleasientocontablecajachicas) {
			detalleasientocontablecajachica.setIsNew(false);
			detalleasientocontablecajachica.setIsChanged(false);
		}
	}
	
	public void generarExportarDetalleAsientoContableCajaChica(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
