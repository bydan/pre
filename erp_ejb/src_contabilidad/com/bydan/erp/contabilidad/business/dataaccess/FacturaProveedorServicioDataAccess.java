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
import com.bydan.erp.contabilidad.util.*;//FacturaProveedorServicioConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;




@SuppressWarnings("unused")
final public class FacturaProveedorServicioDataAccess extends  FacturaProveedorServicioDataAccessAdditional{ //FacturaProveedorServicioDataAccessAdditional,DataAccessHelper<FacturaProveedorServicio>
	//static Logger logger = Logger.getLogger(FacturaProveedorServicioDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="factura_proveedor_servicio";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_ejercicio,id_periodo,id_anio,id_mes,id_modulo,id_transaccion,id_factura,numero_factura,id_cliente,ruc,id_tipo_documento,plazo,con_rise,fecha_emision,fecha_vence,id_empleado_solicita,id_empleado,detalle,numero_retencion,numero_autorizacion,numero_serie,id_tipo_tributario,fecha_validez,anexo_factura_inicio,anexo_factura_fin,id_moneda,valor_servicios0,total_iva,iva_porcentaje,total,numero_mayor,codigo_asiento,id_tipo_retencion_fuente1,id_tipo_retencion_iva1,anexo_numero_autorizacion,anexo_numeso_serie,anexo_fecha_validez,id_cuenta_contable_credito_fiscal_servicios,descripcion,id_tipo_movimiento,id_tipo_movimiento_modulo,id_tipo_transaccion_modulo)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_anio=?,id_mes=?,id_modulo=?,id_transaccion=?,id_factura=?,numero_factura=?,id_cliente=?,ruc=?,id_tipo_documento=?,plazo=?,con_rise=?,fecha_emision=?,fecha_vence=?,id_empleado_solicita=?,id_empleado=?,detalle=?,numero_retencion=?,numero_autorizacion=?,numero_serie=?,id_tipo_tributario=?,fecha_validez=?,anexo_factura_inicio=?,anexo_factura_fin=?,id_moneda=?,valor_servicios0=?,total_iva=?,iva_porcentaje=?,total=?,numero_mayor=?,codigo_asiento=?,id_tipo_retencion_fuente1=?,id_tipo_retencion_iva1=?,anexo_numero_autorizacion=?,anexo_numeso_serie=?,anexo_fecha_validez=?,id_cuenta_contable_credito_fiscal_servicios=?,descripcion=?,id_tipo_movimiento=?,id_tipo_movimiento_modulo=?,id_tipo_transaccion_modulo=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select facturaproveedorservicio from "+FacturaProveedorServicioConstantesFunciones.SPERSISTENCENAME+" facturaproveedorservicio";
	public static String QUERYSELECTNATIVE="select "+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".id,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".version_row,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".id_empresa,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".id_sucursal,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".id_ejercicio,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".id_periodo,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".id_anio,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".id_mes,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".id_modulo,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".id_transaccion,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".id_factura,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".numero_factura,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".id_cliente,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".ruc,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".id_tipo_documento,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".plazo,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".con_rise,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".fecha_emision,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".fecha_vence,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".id_empleado_solicita,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".id_empleado,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".detalle,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".numero_retencion,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".numero_autorizacion,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".numero_serie,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".id_tipo_tributario,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".fecha_validez,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".anexo_factura_inicio,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".anexo_factura_fin,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".id_moneda,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".valor_servicios0,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".total_iva,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".iva_porcentaje,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".total,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".numero_mayor,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".codigo_asiento,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".id_tipo_retencion_fuente1,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".id_tipo_retencion_iva1,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".anexo_numero_autorizacion,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".anexo_numeso_serie,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".anexo_fecha_validez,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".id_cuenta_contable_credito_fiscal_servicios,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".descripcion,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".id_tipo_movimiento,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".id_tipo_movimiento_modulo,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".id_tipo_transaccion_modulo from "+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME;//+" as "+FacturaProveedorServicioConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".id,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".version_row from "+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME;//+" as "+FacturaProveedorServicioConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_anio=?,id_mes=?,id_modulo=?,id_transaccion=?,id_factura=?,numero_factura=?,id_cliente=?,ruc=?,id_tipo_documento=?,plazo=?,con_rise=?,fecha_emision=?,fecha_vence=?,id_empleado_solicita=?,id_empleado=?,detalle=?,numero_retencion=?,numero_autorizacion=?,numero_serie=?,id_tipo_tributario=?,fecha_validez=?,anexo_factura_inicio=?,anexo_factura_fin=?,id_moneda=?,valor_servicios0=?,total_iva=?,iva_porcentaje=?,total=?,numero_mayor=?,codigo_asiento=?,id_tipo_retencion_fuente1=?,id_tipo_retencion_iva1=?,anexo_numero_autorizacion=?,anexo_numeso_serie=?,anexo_fecha_validez=?,id_cuenta_contable_credito_fiscal_servicios=?,descripcion=?,id_tipo_movimiento=?,id_tipo_movimiento_modulo=?,id_tipo_transaccion_modulo=?";
	
	public static String STOREPROCEDUREINSERT="call SP_FACTURAPROVEEDORSERVICIO_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_FACTURAPROVEEDORSERVICIO_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_FACTURAPROVEEDORSERVICIO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_FACTURAPROVEEDORSERVICIO_SELECT(?,?)";
	
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
	
	
	protected FacturaProveedorServicioDataAccessAdditional facturaproveedorservicioDataAccessAdditional=null;
	
	public FacturaProveedorServicioDataAccessAdditional getFacturaProveedorServicioDataAccessAdditional() {
		return this.facturaproveedorservicioDataAccessAdditional;
	}
	
	public void setFacturaProveedorServicioDataAccessAdditional(FacturaProveedorServicioDataAccessAdditional facturaproveedorservicioDataAccessAdditional) {
		try {
			this.facturaproveedorservicioDataAccessAdditional=facturaproveedorservicioDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public FacturaProveedorServicioDataAccess() {
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
		FacturaProveedorServicioDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		FacturaProveedorServicioDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		FacturaProveedorServicioDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setFacturaProveedorServicioOriginal(FacturaProveedorServicio facturaproveedorservicio)throws Exception  {
		facturaproveedorservicio.setFacturaProveedorServicioOriginal((FacturaProveedorServicio)facturaproveedorservicio.clone());		
	}
	
	public void setFacturaProveedorServiciosOriginal(List<FacturaProveedorServicio> facturaproveedorservicios)throws Exception  {
		
		for(FacturaProveedorServicio facturaproveedorservicio:facturaproveedorservicios){
			facturaproveedorservicio.setFacturaProveedorServicioOriginal((FacturaProveedorServicio)facturaproveedorservicio.clone());
		}
	}
	
	public static void setFacturaProveedorServicioOriginalStatic(FacturaProveedorServicio facturaproveedorservicio)throws Exception  {
		facturaproveedorservicio.setFacturaProveedorServicioOriginal((FacturaProveedorServicio)facturaproveedorservicio.clone());		
	}
	
	public static void setFacturaProveedorServiciosOriginalStatic(List<FacturaProveedorServicio> facturaproveedorservicios)throws Exception  {
		
		for(FacturaProveedorServicio facturaproveedorservicio:facturaproveedorservicios){
			facturaproveedorservicio.setFacturaProveedorServicioOriginal((FacturaProveedorServicio)facturaproveedorservicio.clone());
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
	
	public  FacturaProveedorServicio getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		FacturaProveedorServicio entity = new FacturaProveedorServicio();		
		
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
	
	public  FacturaProveedorServicio getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		FacturaProveedorServicio entity = new FacturaProveedorServicio();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=FacturaProveedorServicioDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=FacturaProveedorServicioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Contabilidad.FacturaProveedorServicio.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setFacturaProveedorServicioOriginal(new FacturaProveedorServicio());
      	    	entity=super.getEntity("",entity,resultSet,FacturaProveedorServicioDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityFacturaProveedorServicio("",entity,resultSet); 
				
				//entity.setFacturaProveedorServicioOriginal(super.getEntity("",entity.getFacturaProveedorServicioOriginal(),resultSet,FacturaProveedorServicioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFacturaProveedorServicioOriginal(this.getEntityFacturaProveedorServicio("",entity.getFacturaProveedorServicioOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseFacturaProveedorServicio(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  FacturaProveedorServicio getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		FacturaProveedorServicio entity = new FacturaProveedorServicio();
				
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
	
	public  FacturaProveedorServicio getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		FacturaProveedorServicio entity = new FacturaProveedorServicio();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=FacturaProveedorServicioDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=FacturaProveedorServicioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FacturaProveedorServicioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.FacturaProveedorServicio.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setFacturaProveedorServicioOriginal(new FacturaProveedorServicio());
      	    	entity=super.getEntity("",entity,resultSet,FacturaProveedorServicioDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityFacturaProveedorServicio("",entity,resultSet);    
				
				//entity.setFacturaProveedorServicioOriginal(super.getEntity("",entity.getFacturaProveedorServicioOriginal(),resultSet,FacturaProveedorServicioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFacturaProveedorServicioOriginal(this.getEntityFacturaProveedorServicio("",entity.getFacturaProveedorServicioOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseFacturaProveedorServicio(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //FacturaProveedorServicio
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		FacturaProveedorServicio entity = new FacturaProveedorServicio();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=FacturaProveedorServicioDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=FacturaProveedorServicioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FacturaProveedorServicioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.FacturaProveedorServicio.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseFacturaProveedorServicio(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<FacturaProveedorServicio> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<FacturaProveedorServicio> entities = new  ArrayList<FacturaProveedorServicio>();
		FacturaProveedorServicio entity = new FacturaProveedorServicio();		  
		
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
	
	public  List<FacturaProveedorServicio> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<FacturaProveedorServicio> entities = new  ArrayList<FacturaProveedorServicio>();
		FacturaProveedorServicio entity = new FacturaProveedorServicio();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=FacturaProveedorServicioDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=FacturaProveedorServicioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FacturaProveedorServicioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FacturaProveedorServicio();
      	    	entity=super.getEntity("",entity,resultSet,FacturaProveedorServicioDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityFacturaProveedorServicio("",entity,resultSet);
      	    	
				//entity.setFacturaProveedorServicioOriginal( new FacturaProveedorServicio());
      	    	//entity.setFacturaProveedorServicioOriginal(super.getEntity("",entity.getFacturaProveedorServicioOriginal(),resultSet,FacturaProveedorServicioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFacturaProveedorServicioOriginal(this.getEntityFacturaProveedorServicio("",entity.getFacturaProveedorServicioOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseFacturaProveedorServicios(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFacturaProveedorServicio(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<FacturaProveedorServicio> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<FacturaProveedorServicio> entities = new  ArrayList<FacturaProveedorServicio>();
		FacturaProveedorServicio entity = new FacturaProveedorServicio();		  
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
	
	public  List<FacturaProveedorServicio> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<FacturaProveedorServicio> entities = new  ArrayList<FacturaProveedorServicio>();
		FacturaProveedorServicio entity = new FacturaProveedorServicio();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FacturaProveedorServicio();
				
				if(conMapGenerico) {
					entity.inicializarMapFacturaProveedorServicio();
					//entity.setMapFacturaProveedorServicio(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapFacturaProveedorServicioValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapFacturaProveedorServicio().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,FacturaProveedorServicioDataAccess.ISWITHSCHEMA);         		
					entity=FacturaProveedorServicioDataAccess.getEntityFacturaProveedorServicio("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setFacturaProveedorServicioOriginal( new FacturaProveedorServicio());
					////entity.setFacturaProveedorServicioOriginal(super.getEntity("",entity.getFacturaProveedorServicioOriginal(),resultSet,FacturaProveedorServicioDataAccess.ISWITHSCHEMA));         		
					////entity.setFacturaProveedorServicioOriginal(this.getEntityFacturaProveedorServicio("",entity.getFacturaProveedorServicioOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseFacturaProveedorServicios(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFacturaProveedorServicio(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public FacturaProveedorServicio getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		FacturaProveedorServicio entity = new FacturaProveedorServicio();		  
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
	
	public  FacturaProveedorServicio getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		FacturaProveedorServicio entity = new FacturaProveedorServicio();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FacturaProveedorServicio();
				
				if(conMapGenerico) {
					entity.inicializarMapFacturaProveedorServicio();
					//entity.setMapFacturaProveedorServicio(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapFacturaProveedorServicioValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapFacturaProveedorServicio().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,FacturaProveedorServicioDataAccess.ISWITHSCHEMA);         		
					entity=FacturaProveedorServicioDataAccess.getEntityFacturaProveedorServicio("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setFacturaProveedorServicioOriginal( new FacturaProveedorServicio());
					////entity.setFacturaProveedorServicioOriginal(super.getEntity("",entity.getFacturaProveedorServicioOriginal(),resultSet,FacturaProveedorServicioDataAccess.ISWITHSCHEMA));         		
					////entity.setFacturaProveedorServicioOriginal(this.getEntityFacturaProveedorServicio("",entity.getFacturaProveedorServicioOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseFacturaProveedorServicio(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFacturaProveedorServicio(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static FacturaProveedorServicio getEntityFacturaProveedorServicio(String strPrefijo,FacturaProveedorServicio entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = FacturaProveedorServicio.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = FacturaProveedorServicio.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					FacturaProveedorServicioDataAccess.setFieldReflectionFacturaProveedorServicio(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasFacturaProveedorServicio=FacturaProveedorServicioConstantesFunciones.getTodosTiposColumnasFacturaProveedorServicio();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasFacturaProveedorServicio) {
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
							field = FacturaProveedorServicio.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = FacturaProveedorServicio.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						FacturaProveedorServicioDataAccess.setFieldReflectionFacturaProveedorServicio(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionFacturaProveedorServicio(Field field,String strPrefijo,String sColumn,FacturaProveedorServicio entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case FacturaProveedorServicioConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaProveedorServicioConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FacturaProveedorServicioConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaProveedorServicioConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaProveedorServicioConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaProveedorServicioConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaProveedorServicioConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaProveedorServicioConstantesFunciones.IDMES:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaProveedorServicioConstantesFunciones.IDMODULO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaProveedorServicioConstantesFunciones.IDTRANSACCION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaProveedorServicioConstantesFunciones.IDFACTURA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaProveedorServicioConstantesFunciones.NUMEROFACTURA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FacturaProveedorServicioConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaProveedorServicioConstantesFunciones.RUC:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FacturaProveedorServicioConstantesFunciones.IDTIPODOCUMENTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaProveedorServicioConstantesFunciones.PLAZO:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case FacturaProveedorServicioConstantesFunciones.CONRISE:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case FacturaProveedorServicioConstantesFunciones.FECHAEMISION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case FacturaProveedorServicioConstantesFunciones.FECHAVENCE:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case FacturaProveedorServicioConstantesFunciones.IDEMPLEADOSOLICITA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaProveedorServicioConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaProveedorServicioConstantesFunciones.DETALLE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FacturaProveedorServicioConstantesFunciones.NUMERORETENCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FacturaProveedorServicioConstantesFunciones.NUMEROAUTORIZACION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FacturaProveedorServicioConstantesFunciones.NUMEROSERIE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FacturaProveedorServicioConstantesFunciones.IDTIPOTRIBUTARIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaProveedorServicioConstantesFunciones.FECHAVALIDEZ:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case FacturaProveedorServicioConstantesFunciones.ANEXOFACTURAINICIO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FacturaProveedorServicioConstantesFunciones.ANEXOFACTURAFIN:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FacturaProveedorServicioConstantesFunciones.IDMONEDA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaProveedorServicioConstantesFunciones.VALORSERVICIOS0:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaProveedorServicioConstantesFunciones.TOTALIVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaProveedorServicioConstantesFunciones.IVAPORCENTAJE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaProveedorServicioConstantesFunciones.TOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaProveedorServicioConstantesFunciones.NUMEROMAYOR:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FacturaProveedorServicioConstantesFunciones.CODIGOASIENTO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FacturaProveedorServicioConstantesFunciones.IDTIPORETENCIONFUENTE1:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaProveedorServicioConstantesFunciones.IDTIPORETENCIONIVA1:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaProveedorServicioConstantesFunciones.ANEXONUMEROAUTORIZACION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FacturaProveedorServicioConstantesFunciones.ANEXONUMESOSERIE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FacturaProveedorServicioConstantesFunciones.ANEXOFECHAVALIDEZ:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case FacturaProveedorServicioConstantesFunciones.IDCUENTACONTABLECREDITOFISCALSERVICIOS:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaProveedorServicioConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FacturaProveedorServicioConstantesFunciones.IDTIPOMOVIMIENTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaProveedorServicioConstantesFunciones.IDTIPOMOVIMIENTOMODULO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaProveedorServicioConstantesFunciones.IDTIPOTRANSACCIONMODULO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<FacturaProveedorServicio>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<FacturaProveedorServicio> entities = new  ArrayList<FacturaProveedorServicio>();
		FacturaProveedorServicio entity = new FacturaProveedorServicio();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=FacturaProveedorServicioDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=FacturaProveedorServicioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FacturaProveedorServicioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new FacturaProveedorServicio();
					entity=super.getEntity("",entity,resultSet,FacturaProveedorServicioDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityFacturaProveedorServicio("",entity,resultSet);
					
					//entity.setFacturaProveedorServicioOriginal( new FacturaProveedorServicio());
					//entity.setFacturaProveedorServicioOriginal(super.getEntity("",entity.getFacturaProveedorServicioOriginal(),resultSet,FacturaProveedorServicioDataAccess.ISWITHSCHEMA));         		
					//entity.setFacturaProveedorServicioOriginal(this.getEntityFacturaProveedorServicio("",entity.getFacturaProveedorServicioOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseFacturaProveedorServicios(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFacturaProveedorServicio(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<FacturaProveedorServicio>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<FacturaProveedorServicio> entities = new  ArrayList<FacturaProveedorServicio>();
		FacturaProveedorServicio entity = new FacturaProveedorServicio();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=FacturaProveedorServicioDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=FacturaProveedorServicioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FacturaProveedorServicioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<FacturaProveedorServicio> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<FacturaProveedorServicio> entities = new  ArrayList<FacturaProveedorServicio>();
		FacturaProveedorServicio entity = new FacturaProveedorServicio();		  
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
	
	public  List<FacturaProveedorServicio> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<FacturaProveedorServicio> entities = new  ArrayList<FacturaProveedorServicio>();
		FacturaProveedorServicio entity = new FacturaProveedorServicio();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FacturaProveedorServicio();
      	    	entity=super.getEntity("",entity,resultSet,FacturaProveedorServicioDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityFacturaProveedorServicio("",entity,resultSet);
      	    	
				//entity.setFacturaProveedorServicioOriginal( new FacturaProveedorServicio());
      	    	//entity.setFacturaProveedorServicioOriginal(super.getEntity("",entity.getFacturaProveedorServicioOriginal(),resultSet,FacturaProveedorServicioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFacturaProveedorServicioOriginal(this.getEntityFacturaProveedorServicio("",entity.getFacturaProveedorServicioOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseFacturaProveedorServicios(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFacturaProveedorServicio(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<FacturaProveedorServicio> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<FacturaProveedorServicio> entities = new  ArrayList<FacturaProveedorServicio>();
		FacturaProveedorServicio entity = new FacturaProveedorServicio();		  
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
	
	public  List<FacturaProveedorServicio> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<FacturaProveedorServicio> entities = new  ArrayList<FacturaProveedorServicio>();
		FacturaProveedorServicio entity = new FacturaProveedorServicio();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FacturaProveedorServicio();
      	    	entity=super.getEntity("",entity,resultSet,FacturaProveedorServicioDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityFacturaProveedorServicio("",entity,resultSet);
      	    	
				//entity.setFacturaProveedorServicioOriginal( new FacturaProveedorServicio());
      	    	//entity.setFacturaProveedorServicioOriginal(super.getEntity("",entity.getFacturaProveedorServicioOriginal(),resultSet,FacturaProveedorServicioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFacturaProveedorServicioOriginal(this.getEntityFacturaProveedorServicio("",entity.getFacturaProveedorServicioOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseFacturaProveedorServicios(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public FacturaProveedorServicio getEntityFacturaProveedorServicio(String strPrefijo,FacturaProveedorServicio entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+FacturaProveedorServicioConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+FacturaProveedorServicioConstantesFunciones.IDSUCURSAL));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+FacturaProveedorServicioConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+FacturaProveedorServicioConstantesFunciones.IDPERIODO));
				entity.setid_anio(resultSet.getLong(strPrefijo+FacturaProveedorServicioConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
				entity.setid_mes(resultSet.getLong(strPrefijo+FacturaProveedorServicioConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
				entity.setid_modulo(resultSet.getLong(strPrefijo+FacturaProveedorServicioConstantesFunciones.IDMODULO));
				entity.setid_transaccion(resultSet.getLong(strPrefijo+FacturaProveedorServicioConstantesFunciones.IDTRANSACCION));
				entity.setid_factura(resultSet.getLong(strPrefijo+FacturaProveedorServicioConstantesFunciones.IDFACTURA));if(resultSet.wasNull()) {entity.setid_factura(null); }
				entity.setnumero_factura(resultSet.getString(strPrefijo+FacturaProveedorServicioConstantesFunciones.NUMEROFACTURA));
				entity.setid_cliente(resultSet.getLong(strPrefijo+FacturaProveedorServicioConstantesFunciones.IDCLIENTE));
				entity.setruc(resultSet.getString(strPrefijo+FacturaProveedorServicioConstantesFunciones.RUC));
				entity.setid_tipo_documento(resultSet.getLong(strPrefijo+FacturaProveedorServicioConstantesFunciones.IDTIPODOCUMENTO));
				entity.setplazo(resultSet.getInt(strPrefijo+FacturaProveedorServicioConstantesFunciones.PLAZO));
				entity.setcon_rise(resultSet.getBoolean(strPrefijo+FacturaProveedorServicioConstantesFunciones.CONRISE));
				entity.setfecha_emision(new Date(resultSet.getDate(strPrefijo+FacturaProveedorServicioConstantesFunciones.FECHAEMISION).getTime()));
				entity.setfecha_vence(new Date(resultSet.getDate(strPrefijo+FacturaProveedorServicioConstantesFunciones.FECHAVENCE).getTime()));
				entity.setid_empleado_solicita(resultSet.getLong(strPrefijo+FacturaProveedorServicioConstantesFunciones.IDEMPLEADOSOLICITA));
				entity.setid_empleado(resultSet.getLong(strPrefijo+FacturaProveedorServicioConstantesFunciones.IDEMPLEADO));if(resultSet.wasNull()) {entity.setid_empleado(null); }
				entity.setdetalle(resultSet.getString(strPrefijo+FacturaProveedorServicioConstantesFunciones.DETALLE));
				entity.setnumero_retencion(resultSet.getString(strPrefijo+FacturaProveedorServicioConstantesFunciones.NUMERORETENCION));
				entity.setnumero_autorizacion(resultSet.getString(strPrefijo+FacturaProveedorServicioConstantesFunciones.NUMEROAUTORIZACION));
				entity.setnumero_serie(resultSet.getString(strPrefijo+FacturaProveedorServicioConstantesFunciones.NUMEROSERIE));
				entity.setid_tipo_tributario(resultSet.getLong(strPrefijo+FacturaProveedorServicioConstantesFunciones.IDTIPOTRIBUTARIO));if(resultSet.wasNull()) {entity.setid_tipo_tributario(null); }
				entity.setfecha_validez(new Date(resultSet.getDate(strPrefijo+FacturaProveedorServicioConstantesFunciones.FECHAVALIDEZ).getTime()));
				entity.setanexo_factura_inicio(resultSet.getString(strPrefijo+FacturaProveedorServicioConstantesFunciones.ANEXOFACTURAINICIO));
				entity.setanexo_factura_fin(resultSet.getString(strPrefijo+FacturaProveedorServicioConstantesFunciones.ANEXOFACTURAFIN));
				entity.setid_moneda(resultSet.getLong(strPrefijo+FacturaProveedorServicioConstantesFunciones.IDMONEDA));
				entity.setvalor_servicios0(resultSet.getDouble(strPrefijo+FacturaProveedorServicioConstantesFunciones.VALORSERVICIOS0));
				entity.settotal_iva(resultSet.getDouble(strPrefijo+FacturaProveedorServicioConstantesFunciones.TOTALIVA));
				entity.setiva_porcentaje(resultSet.getDouble(strPrefijo+FacturaProveedorServicioConstantesFunciones.IVAPORCENTAJE));
				entity.settotal(resultSet.getDouble(strPrefijo+FacturaProveedorServicioConstantesFunciones.TOTAL));
				entity.setnumero_mayor(resultSet.getString(strPrefijo+FacturaProveedorServicioConstantesFunciones.NUMEROMAYOR));
				entity.setcodigo_asiento(resultSet.getString(strPrefijo+FacturaProveedorServicioConstantesFunciones.CODIGOASIENTO));
				entity.setid_tipo_retencion_fuente1(resultSet.getLong(strPrefijo+FacturaProveedorServicioConstantesFunciones.IDTIPORETENCIONFUENTE1));
				entity.setid_tipo_retencion_iva1(resultSet.getLong(strPrefijo+FacturaProveedorServicioConstantesFunciones.IDTIPORETENCIONIVA1));
				entity.setanexo_numero_autorizacion(resultSet.getString(strPrefijo+FacturaProveedorServicioConstantesFunciones.ANEXONUMEROAUTORIZACION));
				entity.setanexo_numeso_serie(resultSet.getString(strPrefijo+FacturaProveedorServicioConstantesFunciones.ANEXONUMESOSERIE));
				entity.setanexo_fecha_validez(new Date(resultSet.getDate(strPrefijo+FacturaProveedorServicioConstantesFunciones.ANEXOFECHAVALIDEZ).getTime()));
				entity.setid_cuenta_contable_credito_fiscal_servicios(resultSet.getLong(strPrefijo+FacturaProveedorServicioConstantesFunciones.IDCUENTACONTABLECREDITOFISCALSERVICIOS));
				entity.setdescripcion(resultSet.getString(strPrefijo+FacturaProveedorServicioConstantesFunciones.DESCRIPCION));
				entity.setid_tipo_movimiento(resultSet.getLong(strPrefijo+FacturaProveedorServicioConstantesFunciones.IDTIPOMOVIMIENTO));if(resultSet.wasNull()) {entity.setid_tipo_movimiento(null); }
				entity.setid_tipo_movimiento_modulo(resultSet.getLong(strPrefijo+FacturaProveedorServicioConstantesFunciones.IDTIPOMOVIMIENTOMODULO));if(resultSet.wasNull()) {entity.setid_tipo_movimiento_modulo(null); }
				entity.setid_tipo_transaccion_modulo(resultSet.getLong(strPrefijo+FacturaProveedorServicioConstantesFunciones.IDTIPOTRANSACCIONMODULO));if(resultSet.wasNull()) {entity.setid_tipo_transaccion_modulo(null); }
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowFacturaProveedorServicio(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(FacturaProveedorServicio entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=FacturaProveedorServicioDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=FacturaProveedorServicioDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=FacturaProveedorServicioDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=FacturaProveedorServicioDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(FacturaProveedorServicioConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,FacturaProveedorServicioDataAccess.TABLENAME,FacturaProveedorServicioDataAccess.ISWITHSTOREPROCEDURES);
			
			FacturaProveedorServicioDataAccess.setFacturaProveedorServicioOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,FacturaProveedorServicio relfacturaproveedorservicio)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relfacturaproveedorservicio.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,FacturaProveedorServicio relfacturaproveedorservicio)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relfacturaproveedorservicio.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,FacturaProveedorServicio relfacturaproveedorservicio)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relfacturaproveedorservicio.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,FacturaProveedorServicio relfacturaproveedorservicio)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,relfacturaproveedorservicio.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public Anio getAnio(Connexion connexion,FacturaProveedorServicio relfacturaproveedorservicio)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);

			anio=anioDataAccess.getEntity(connexion,relfacturaproveedorservicio.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Mes getMes(Connexion connexion,FacturaProveedorServicio relfacturaproveedorservicio)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,relfacturaproveedorservicio.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}

	public Modulo getModulo(Connexion connexion,FacturaProveedorServicio relfacturaproveedorservicio)throws SQLException,Exception {

		Modulo modulo= new Modulo();

		try {
			ModuloDataAccess moduloDataAccess=new ModuloDataAccess();

			moduloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			moduloDataAccess.setConnexionType(this.connexionType);
			moduloDataAccess.setParameterDbType(this.parameterDbType);

			modulo=moduloDataAccess.getEntity(connexion,relfacturaproveedorservicio.getid_modulo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return modulo;

	}

	public Transaccion getTransaccion(Connexion connexion,FacturaProveedorServicio relfacturaproveedorservicio)throws SQLException,Exception {

		Transaccion transaccion= new Transaccion();

		try {
			TransaccionDataAccess transaccionDataAccess=new TransaccionDataAccess();

			transaccionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transaccionDataAccess.setConnexionType(this.connexionType);
			transaccionDataAccess.setParameterDbType(this.parameterDbType);

			transaccion=transaccionDataAccess.getEntity(connexion,relfacturaproveedorservicio.getid_transaccion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccion;

	}

	public Factura getFactura(Connexion connexion,FacturaProveedorServicio relfacturaproveedorservicio)throws SQLException,Exception {

		Factura factura= new Factura();

		try {
			FacturaDataAccess facturaDataAccess=new FacturaDataAccess();

			facturaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			facturaDataAccess.setConnexionType(this.connexionType);
			facturaDataAccess.setParameterDbType(this.parameterDbType);

			factura=facturaDataAccess.getEntity(connexion,relfacturaproveedorservicio.getid_factura());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return factura;

	}

	public Cliente getCliente(Connexion connexion,FacturaProveedorServicio relfacturaproveedorservicio)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,relfacturaproveedorservicio.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public TipoDocumento getTipoDocumento(Connexion connexion,FacturaProveedorServicio relfacturaproveedorservicio)throws SQLException,Exception {

		TipoDocumento tipodocumento= new TipoDocumento();

		try {
			TipoDocumentoDataAccess tipodocumentoDataAccess=new TipoDocumentoDataAccess();

			tipodocumentoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipodocumentoDataAccess.setConnexionType(this.connexionType);
			tipodocumentoDataAccess.setParameterDbType(this.parameterDbType);

			tipodocumento=tipodocumentoDataAccess.getEntity(connexion,relfacturaproveedorservicio.getid_tipo_documento());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipodocumento;

	}

	public Empleado getEmpleadoSolicita(Connexion connexion,FacturaProveedorServicio relfacturaproveedorservicio)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relfacturaproveedorservicio.getid_empleado_solicita());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public Empleado getEmpleado(Connexion connexion,FacturaProveedorServicio relfacturaproveedorservicio)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relfacturaproveedorservicio.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public TipoTributario getTipoTributario(Connexion connexion,FacturaProveedorServicio relfacturaproveedorservicio)throws SQLException,Exception {

		TipoTributario tipotributario= new TipoTributario();

		try {
			TipoTributarioDataAccess tipotributarioDataAccess=new TipoTributarioDataAccess();

			tipotributarioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipotributarioDataAccess.setConnexionType(this.connexionType);
			tipotributarioDataAccess.setParameterDbType(this.parameterDbType);

			tipotributario=tipotributarioDataAccess.getEntity(connexion,relfacturaproveedorservicio.getid_tipo_tributario());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipotributario;

	}

	public Moneda getMoneda(Connexion connexion,FacturaProveedorServicio relfacturaproveedorservicio)throws SQLException,Exception {

		Moneda moneda= new Moneda();

		try {
			MonedaDataAccess monedaDataAccess=new MonedaDataAccess();

			monedaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			monedaDataAccess.setConnexionType(this.connexionType);
			monedaDataAccess.setParameterDbType(this.parameterDbType);

			moneda=monedaDataAccess.getEntity(connexion,relfacturaproveedorservicio.getid_moneda());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return moneda;

	}

	public TipoRetencion getTipoRetencionFuente1(Connexion connexion,FacturaProveedorServicio relfacturaproveedorservicio)throws SQLException,Exception {

		TipoRetencion tiporetencion= new TipoRetencion();

		try {
			TipoRetencionDataAccess tiporetencionDataAccess=new TipoRetencionDataAccess();

			tiporetencionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tiporetencionDataAccess.setConnexionType(this.connexionType);
			tiporetencionDataAccess.setParameterDbType(this.parameterDbType);

			tiporetencion=tiporetencionDataAccess.getEntity(connexion,relfacturaproveedorservicio.getid_tipo_retencion_fuente1());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tiporetencion;

	}

	public TipoRetencion getTipoRetencionIva1(Connexion connexion,FacturaProveedorServicio relfacturaproveedorservicio)throws SQLException,Exception {

		TipoRetencion tiporetencion= new TipoRetencion();

		try {
			TipoRetencionDataAccess tiporetencionDataAccess=new TipoRetencionDataAccess();

			tiporetencionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tiporetencionDataAccess.setConnexionType(this.connexionType);
			tiporetencionDataAccess.setParameterDbType(this.parameterDbType);

			tiporetencion=tiporetencionDataAccess.getEntity(connexion,relfacturaproveedorservicio.getid_tipo_retencion_iva1());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tiporetencion;

	}

	public CuentaContable getCuentaContableCreditoFiscalServicios(Connexion connexion,FacturaProveedorServicio relfacturaproveedorservicio)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relfacturaproveedorservicio.getid_cuenta_contable_credito_fiscal_servicios());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public TipoMovimiento getTipoMovimiento(Connexion connexion,FacturaProveedorServicio relfacturaproveedorservicio)throws SQLException,Exception {

		TipoMovimiento tipomovimiento= new TipoMovimiento();

		try {
			TipoMovimientoDataAccess tipomovimientoDataAccess=new TipoMovimientoDataAccess();

			tipomovimientoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipomovimientoDataAccess.setConnexionType(this.connexionType);
			tipomovimientoDataAccess.setParameterDbType(this.parameterDbType);

			tipomovimiento=tipomovimientoDataAccess.getEntity(connexion,relfacturaproveedorservicio.getid_tipo_movimiento());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipomovimiento;

	}

	public TipoMovimientoModulo getTipoMovimientoModulo(Connexion connexion,FacturaProveedorServicio relfacturaproveedorservicio)throws SQLException,Exception {

		TipoMovimientoModulo tipomovimientomodulo= new TipoMovimientoModulo();

		try {
			TipoMovimientoModuloDataAccess tipomovimientomoduloDataAccess=new TipoMovimientoModuloDataAccess();

			tipomovimientomoduloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipomovimientomoduloDataAccess.setConnexionType(this.connexionType);
			tipomovimientomoduloDataAccess.setParameterDbType(this.parameterDbType);

			tipomovimientomodulo=tipomovimientomoduloDataAccess.getEntity(connexion,relfacturaproveedorservicio.getid_tipo_movimiento_modulo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipomovimientomodulo;

	}

	public TipoTransaccionModulo getTipoTransaccionModulo(Connexion connexion,FacturaProveedorServicio relfacturaproveedorservicio)throws SQLException,Exception {

		TipoTransaccionModulo tipotransaccionmodulo= new TipoTransaccionModulo();

		try {
			TipoTransaccionModuloDataAccess tipotransaccionmoduloDataAccess=new TipoTransaccionModuloDataAccess();

			tipotransaccionmoduloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipotransaccionmoduloDataAccess.setConnexionType(this.connexionType);
			tipotransaccionmoduloDataAccess.setParameterDbType(this.parameterDbType);

			tipotransaccionmodulo=tipotransaccionmoduloDataAccess.getEntity(connexion,relfacturaproveedorservicio.getid_tipo_transaccion_modulo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipotransaccionmodulo;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,FacturaProveedorServicio facturaproveedorservicio) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!facturaproveedorservicio.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(facturaproveedorservicio.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(facturaproveedorservicio.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(facturaproveedorservicio.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(facturaproveedorservicio.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_anio=new ParameterValue<Long>();
					parameterMaintenanceValueid_anio.setValue(facturaproveedorservicio.getid_anio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_anio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes.setValue(facturaproveedorservicio.getid_mes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_modulo=new ParameterValue<Long>();
					parameterMaintenanceValueid_modulo.setValue(facturaproveedorservicio.getid_modulo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_modulo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transaccion=new ParameterValue<Long>();
					parameterMaintenanceValueid_transaccion.setValue(facturaproveedorservicio.getid_transaccion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transaccion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_factura=new ParameterValue<Long>();
					parameterMaintenanceValueid_factura.setValue(facturaproveedorservicio.getid_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_factura=new ParameterValue<String>();
					parameterMaintenanceValuenumero_factura.setValue(facturaproveedorservicio.getnumero_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_cliente.setValue(facturaproveedorservicio.getid_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueruc=new ParameterValue<String>();
					parameterMaintenanceValueruc.setValue(facturaproveedorservicio.getruc());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueruc);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_documento=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_documento.setValue(facturaproveedorservicio.getid_tipo_documento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_documento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValueplazo=new ParameterValue<Integer>();
					parameterMaintenanceValueplazo.setValue(facturaproveedorservicio.getplazo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueplazo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_rise=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_rise.setValue(facturaproveedorservicio.getcon_rise());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_rise);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_emision=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_emision.setValue(facturaproveedorservicio.getfecha_emision());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_emision);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_vence=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_vence.setValue(facturaproveedorservicio.getfecha_vence());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_vence);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado_solicita=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado_solicita.setValue(facturaproveedorservicio.getid_empleado_solicita());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado_solicita);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(facturaproveedorservicio.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedetalle=new ParameterValue<String>();
					parameterMaintenanceValuedetalle.setValue(facturaproveedorservicio.getdetalle());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedetalle);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_retencion=new ParameterValue<String>();
					parameterMaintenanceValuenumero_retencion.setValue(facturaproveedorservicio.getnumero_retencion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_retencion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_autorizacion=new ParameterValue<String>();
					parameterMaintenanceValuenumero_autorizacion.setValue(facturaproveedorservicio.getnumero_autorizacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_autorizacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_serie=new ParameterValue<String>();
					parameterMaintenanceValuenumero_serie.setValue(facturaproveedorservicio.getnumero_serie());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_serie);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_tributario=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_tributario.setValue(facturaproveedorservicio.getid_tipo_tributario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_tributario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_validez=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_validez.setValue(facturaproveedorservicio.getfecha_validez());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_validez);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueanexo_factura_inicio=new ParameterValue<String>();
					parameterMaintenanceValueanexo_factura_inicio.setValue(facturaproveedorservicio.getanexo_factura_inicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueanexo_factura_inicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueanexo_factura_fin=new ParameterValue<String>();
					parameterMaintenanceValueanexo_factura_fin.setValue(facturaproveedorservicio.getanexo_factura_fin());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueanexo_factura_fin);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_moneda=new ParameterValue<Long>();
					parameterMaintenanceValueid_moneda.setValue(facturaproveedorservicio.getid_moneda());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_moneda);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_servicios0=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_servicios0.setValue(facturaproveedorservicio.getvalor_servicios0());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_servicios0);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal_iva=new ParameterValue<Double>();
					parameterMaintenanceValuetotal_iva.setValue(facturaproveedorservicio.gettotal_iva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal_iva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueiva_porcentaje=new ParameterValue<Double>();
					parameterMaintenanceValueiva_porcentaje.setValue(facturaproveedorservicio.getiva_porcentaje());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueiva_porcentaje);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal=new ParameterValue<Double>();
					parameterMaintenanceValuetotal.setValue(facturaproveedorservicio.gettotal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_mayor=new ParameterValue<String>();
					parameterMaintenanceValuenumero_mayor.setValue(facturaproveedorservicio.getnumero_mayor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_mayor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo_asiento=new ParameterValue<String>();
					parameterMaintenanceValuecodigo_asiento.setValue(facturaproveedorservicio.getcodigo_asiento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo_asiento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_retencion_fuente1=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_retencion_fuente1.setValue(facturaproveedorservicio.getid_tipo_retencion_fuente1());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_retencion_fuente1);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_retencion_iva1=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_retencion_iva1.setValue(facturaproveedorservicio.getid_tipo_retencion_iva1());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_retencion_iva1);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueanexo_numero_autorizacion=new ParameterValue<String>();
					parameterMaintenanceValueanexo_numero_autorizacion.setValue(facturaproveedorservicio.getanexo_numero_autorizacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueanexo_numero_autorizacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueanexo_numeso_serie=new ParameterValue<String>();
					parameterMaintenanceValueanexo_numeso_serie.setValue(facturaproveedorservicio.getanexo_numeso_serie());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueanexo_numeso_serie);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValueanexo_fecha_validez=new ParameterValue<Date>();
					parameterMaintenanceValueanexo_fecha_validez.setValue(facturaproveedorservicio.getanexo_fecha_validez());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueanexo_fecha_validez);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_credito_fiscal_servicios=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_credito_fiscal_servicios.setValue(facturaproveedorservicio.getid_cuenta_contable_credito_fiscal_servicios());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_credito_fiscal_servicios);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(facturaproveedorservicio.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_movimiento=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_movimiento.setValue(facturaproveedorservicio.getid_tipo_movimiento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_movimiento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_movimiento_modulo=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_movimiento_modulo.setValue(facturaproveedorservicio.getid_tipo_movimiento_modulo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_movimiento_modulo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_transaccion_modulo=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_transaccion_modulo.setValue(facturaproveedorservicio.getid_tipo_transaccion_modulo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_transaccion_modulo);
					parametersTemp.add(parameterMaintenance);
					
						if(!facturaproveedorservicio.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(facturaproveedorservicio.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(facturaproveedorservicio.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(facturaproveedorservicio.getId());
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
	
	public void setIsNewIsChangedFalseFacturaProveedorServicio(FacturaProveedorServicio facturaproveedorservicio)throws Exception  {		
		facturaproveedorservicio.setIsNew(false);
		facturaproveedorservicio.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseFacturaProveedorServicios(List<FacturaProveedorServicio> facturaproveedorservicios)throws Exception  {				
		for(FacturaProveedorServicio facturaproveedorservicio:facturaproveedorservicios) {
			facturaproveedorservicio.setIsNew(false);
			facturaproveedorservicio.setIsChanged(false);
		}
	}
	
	public void generarExportarFacturaProveedorServicio(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
