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
import com.bydan.erp.contabilidad.util.*;//FacturaProveedorConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;




@SuppressWarnings("unused")
final public class FacturaProveedorDataAccess extends  FacturaProveedorDataAccessAdditional{ //FacturaProveedorDataAccessAdditional,DataAccessHelper<FacturaProveedor>
	//static Logger logger = Logger.getLogger(FacturaProveedorDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="factura_proveedor";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_ejercicio,id_periodo,id_anio,id_mes,id_modulo,id_plantilla_factura,id_tipo_documento,plazo,id_factura,numero_factura,id_transaccion,fecha_emision,id_cliente,ruc,id_empleado_solicita,fecha_vence,id_moneda,id_empleado,con_activos,con_rise,con_sitios,detalle,valor_bienes12,valor_servicios12,total_valor12,valor_bienes0,valor_servicios0,total_valor0,bienes_ice,servicios_ice,total_ice,bienes_iva,servicios_iva,total_iva,iva_porcentaje,total,con_monto_objeto_iva,numero_retencion,numero_serie,numero_autorizacion,fecha_validez,id_tipo_retencion_fuente1,ret_fuente1_porcentaje,ret_fuente1_base,ret_fuente1_retenido,id_tipo_retencion_fuente2,ret_fuente2_porcentaje,ret_fuente2_base,ret_fuente2_retenido,id_tipo_retencion_iva1,ret_iva_bien_porcentaje,ret_iva_bien_base,ret_iva_bien_retenido,id_tipo_retencion_iva2,ret_iva_servicio_porcentaje,ret_iva_servicio_base,ret_iva_servicio_retenido,anexo_numero_autorizacion,anexo_numeso_serie,anexo_fecha_validez,id_tipo_tributario,anexo_factura_inicio,anexo_factura_fin,id_cuenta_contable_credito_fiscal_bienes,id_responsable_fondo,id_cuenta_contable_credito_fiscal_servicios,secuencial,id_cuenta_contable_gasto,gasto_valor,id_cuenta_contable_gasto2,gasto_valor2,gasto_nombre,gasto_nombre2,id_cuenta_contable_credito_fin,id_cuenta_contable_credito_fin2,id_cuenta_contable_credito,descripcion,id_tipo_movimiento,id_tipo_movimiento_modulo,id_tipo_transaccion_modulo,numero_mayor,codigo_asiento)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_anio=?,id_mes=?,id_modulo=?,id_plantilla_factura=?,id_tipo_documento=?,plazo=?,id_factura=?,numero_factura=?,id_transaccion=?,fecha_emision=?,id_cliente=?,ruc=?,id_empleado_solicita=?,fecha_vence=?,id_moneda=?,id_empleado=?,con_activos=?,con_rise=?,con_sitios=?,detalle=?,valor_bienes12=?,valor_servicios12=?,total_valor12=?,valor_bienes0=?,valor_servicios0=?,total_valor0=?,bienes_ice=?,servicios_ice=?,total_ice=?,bienes_iva=?,servicios_iva=?,total_iva=?,iva_porcentaje=?,total=?,con_monto_objeto_iva=?,numero_retencion=?,numero_serie=?,numero_autorizacion=?,fecha_validez=?,id_tipo_retencion_fuente1=?,ret_fuente1_porcentaje=?,ret_fuente1_base=?,ret_fuente1_retenido=?,id_tipo_retencion_fuente2=?,ret_fuente2_porcentaje=?,ret_fuente2_base=?,ret_fuente2_retenido=?,id_tipo_retencion_iva1=?,ret_iva_bien_porcentaje=?,ret_iva_bien_base=?,ret_iva_bien_retenido=?,id_tipo_retencion_iva2=?,ret_iva_servicio_porcentaje=?,ret_iva_servicio_base=?,ret_iva_servicio_retenido=?,anexo_numero_autorizacion=?,anexo_numeso_serie=?,anexo_fecha_validez=?,id_tipo_tributario=?,anexo_factura_inicio=?,anexo_factura_fin=?,id_cuenta_contable_credito_fiscal_bienes=?,id_responsable_fondo=?,id_cuenta_contable_credito_fiscal_servicios=?,secuencial=?,id_cuenta_contable_gasto=?,gasto_valor=?,id_cuenta_contable_gasto2=?,gasto_valor2=?,gasto_nombre=?,gasto_nombre2=?,id_cuenta_contable_credito_fin=?,id_cuenta_contable_credito_fin2=?,id_cuenta_contable_credito=?,descripcion=?,id_tipo_movimiento=?,id_tipo_movimiento_modulo=?,id_tipo_transaccion_modulo=?,numero_mayor=?,codigo_asiento=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select facturaproveedor from "+FacturaProveedorConstantesFunciones.SPERSISTENCENAME+" facturaproveedor";
	public static String QUERYSELECTNATIVE="select "+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".id,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".version_row,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".id_empresa,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".id_sucursal,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".id_ejercicio,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".id_periodo,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".id_anio,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".id_mes,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".id_modulo,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".id_plantilla_factura,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".id_tipo_documento,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".plazo,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".id_factura,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".numero_factura,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".id_transaccion,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".fecha_emision,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".id_cliente,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".ruc,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".id_empleado_solicita,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".fecha_vence,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".id_moneda,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".id_empleado,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".con_activos,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".con_rise,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".con_sitios,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".detalle,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".valor_bienes12,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".valor_servicios12,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".total_valor12,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".valor_bienes0,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".valor_servicios0,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".total_valor0,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".bienes_ice,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".servicios_ice,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".total_ice,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".bienes_iva,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".servicios_iva,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".total_iva,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".iva_porcentaje,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".total,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".con_monto_objeto_iva,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".numero_retencion,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".numero_serie,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".numero_autorizacion,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".fecha_validez,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".id_tipo_retencion_fuente1,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".ret_fuente1_porcentaje,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".ret_fuente1_base,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".ret_fuente1_retenido,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".id_tipo_retencion_fuente2,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".ret_fuente2_porcentaje,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".ret_fuente2_base,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".ret_fuente2_retenido,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".id_tipo_retencion_iva1,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".ret_iva_bien_porcentaje,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".ret_iva_bien_base,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".ret_iva_bien_retenido,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".id_tipo_retencion_iva2,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".ret_iva_servicio_porcentaje,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".ret_iva_servicio_base,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".ret_iva_servicio_retenido,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".anexo_numero_autorizacion,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".anexo_numeso_serie,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".anexo_fecha_validez,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".id_tipo_tributario,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".anexo_factura_inicio,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".anexo_factura_fin,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".id_cuenta_contable_credito_fiscal_bienes,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".id_responsable_fondo,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".id_cuenta_contable_credito_fiscal_servicios,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".secuencial,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".id_cuenta_contable_gasto,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".gasto_valor,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".id_cuenta_contable_gasto2,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".gasto_valor2,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".gasto_nombre,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".gasto_nombre2,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".id_cuenta_contable_credito_fin,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".id_cuenta_contable_credito_fin2,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".id_cuenta_contable_credito,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".descripcion,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".id_tipo_movimiento,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".id_tipo_movimiento_modulo,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".id_tipo_transaccion_modulo,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".numero_mayor,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".codigo_asiento from "+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME;//+" as "+FacturaProveedorConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".id,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".version_row from "+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME;//+" as "+FacturaProveedorConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_anio=?,id_mes=?,id_modulo=?,id_plantilla_factura=?,id_tipo_documento=?,plazo=?,id_factura=?,numero_factura=?,id_transaccion=?,fecha_emision=?,id_cliente=?,ruc=?,id_empleado_solicita=?,fecha_vence=?,id_moneda=?,id_empleado=?,con_activos=?,con_rise=?,con_sitios=?,detalle=?,valor_bienes12=?,valor_servicios12=?,total_valor12=?,valor_bienes0=?,valor_servicios0=?,total_valor0=?,bienes_ice=?,servicios_ice=?,total_ice=?,bienes_iva=?,servicios_iva=?,total_iva=?,iva_porcentaje=?,total=?,con_monto_objeto_iva=?,numero_retencion=?,numero_serie=?,numero_autorizacion=?,fecha_validez=?,id_tipo_retencion_fuente1=?,ret_fuente1_porcentaje=?,ret_fuente1_base=?,ret_fuente1_retenido=?,id_tipo_retencion_fuente2=?,ret_fuente2_porcentaje=?,ret_fuente2_base=?,ret_fuente2_retenido=?,id_tipo_retencion_iva1=?,ret_iva_bien_porcentaje=?,ret_iva_bien_base=?,ret_iva_bien_retenido=?,id_tipo_retencion_iva2=?,ret_iva_servicio_porcentaje=?,ret_iva_servicio_base=?,ret_iva_servicio_retenido=?,anexo_numero_autorizacion=?,anexo_numeso_serie=?,anexo_fecha_validez=?,id_tipo_tributario=?,anexo_factura_inicio=?,anexo_factura_fin=?,id_cuenta_contable_credito_fiscal_bienes=?,id_responsable_fondo=?,id_cuenta_contable_credito_fiscal_servicios=?,secuencial=?,id_cuenta_contable_gasto=?,gasto_valor=?,id_cuenta_contable_gasto2=?,gasto_valor2=?,gasto_nombre=?,gasto_nombre2=?,id_cuenta_contable_credito_fin=?,id_cuenta_contable_credito_fin2=?,id_cuenta_contable_credito=?,descripcion=?,id_tipo_movimiento=?,id_tipo_movimiento_modulo=?,id_tipo_transaccion_modulo=?,numero_mayor=?,codigo_asiento=?";
	
	public static String STOREPROCEDUREINSERT="call SP_FACTURAPROVEEDOR_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_FACTURAPROVEEDOR_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_FACTURAPROVEEDOR_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_FACTURAPROVEEDOR_SELECT(?,?)";
	
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
	
	
	protected FacturaProveedorDataAccessAdditional facturaproveedorDataAccessAdditional=null;
	
	public FacturaProveedorDataAccessAdditional getFacturaProveedorDataAccessAdditional() {
		return this.facturaproveedorDataAccessAdditional;
	}
	
	public void setFacturaProveedorDataAccessAdditional(FacturaProveedorDataAccessAdditional facturaproveedorDataAccessAdditional) {
		try {
			this.facturaproveedorDataAccessAdditional=facturaproveedorDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public FacturaProveedorDataAccess() {
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
		FacturaProveedorDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		FacturaProveedorDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		FacturaProveedorDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setFacturaProveedorOriginal(FacturaProveedor facturaproveedor)throws Exception  {
		facturaproveedor.setFacturaProveedorOriginal((FacturaProveedor)facturaproveedor.clone());		
	}
	
	public void setFacturaProveedorsOriginal(List<FacturaProveedor> facturaproveedors)throws Exception  {
		
		for(FacturaProveedor facturaproveedor:facturaproveedors){
			facturaproveedor.setFacturaProveedorOriginal((FacturaProveedor)facturaproveedor.clone());
		}
	}
	
	public static void setFacturaProveedorOriginalStatic(FacturaProveedor facturaproveedor)throws Exception  {
		facturaproveedor.setFacturaProveedorOriginal((FacturaProveedor)facturaproveedor.clone());		
	}
	
	public static void setFacturaProveedorsOriginalStatic(List<FacturaProveedor> facturaproveedors)throws Exception  {
		
		for(FacturaProveedor facturaproveedor:facturaproveedors){
			facturaproveedor.setFacturaProveedorOriginal((FacturaProveedor)facturaproveedor.clone());
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
	
	public  FacturaProveedor getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		FacturaProveedor entity = new FacturaProveedor();		
		
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
	
	public  FacturaProveedor getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		FacturaProveedor entity = new FacturaProveedor();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=FacturaProveedorDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=FacturaProveedorDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Contabilidad.FacturaProveedor.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setFacturaProveedorOriginal(new FacturaProveedor());
      	    	entity=super.getEntity("",entity,resultSet,FacturaProveedorDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityFacturaProveedor("",entity,resultSet); 
				
				//entity.setFacturaProveedorOriginal(super.getEntity("",entity.getFacturaProveedorOriginal(),resultSet,FacturaProveedorDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFacturaProveedorOriginal(this.getEntityFacturaProveedor("",entity.getFacturaProveedorOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseFacturaProveedor(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  FacturaProveedor getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		FacturaProveedor entity = new FacturaProveedor();
				
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
	
	public  FacturaProveedor getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		FacturaProveedor entity = new FacturaProveedor();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=FacturaProveedorDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=FacturaProveedorDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FacturaProveedorDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.FacturaProveedor.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setFacturaProveedorOriginal(new FacturaProveedor());
      	    	entity=super.getEntity("",entity,resultSet,FacturaProveedorDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityFacturaProveedor("",entity,resultSet);    
				
				//entity.setFacturaProveedorOriginal(super.getEntity("",entity.getFacturaProveedorOriginal(),resultSet,FacturaProveedorDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFacturaProveedorOriginal(this.getEntityFacturaProveedor("",entity.getFacturaProveedorOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseFacturaProveedor(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //FacturaProveedor
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		FacturaProveedor entity = new FacturaProveedor();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=FacturaProveedorDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=FacturaProveedorDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FacturaProveedorDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.FacturaProveedor.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseFacturaProveedor(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<FacturaProveedor> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<FacturaProveedor> entities = new  ArrayList<FacturaProveedor>();
		FacturaProveedor entity = new FacturaProveedor();		  
		
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
	
	public  List<FacturaProveedor> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<FacturaProveedor> entities = new  ArrayList<FacturaProveedor>();
		FacturaProveedor entity = new FacturaProveedor();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=FacturaProveedorDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=FacturaProveedorDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FacturaProveedorDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FacturaProveedor();
      	    	entity=super.getEntity("",entity,resultSet,FacturaProveedorDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityFacturaProveedor("",entity,resultSet);
      	    	
				//entity.setFacturaProveedorOriginal( new FacturaProveedor());
      	    	//entity.setFacturaProveedorOriginal(super.getEntity("",entity.getFacturaProveedorOriginal(),resultSet,FacturaProveedorDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFacturaProveedorOriginal(this.getEntityFacturaProveedor("",entity.getFacturaProveedorOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseFacturaProveedors(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFacturaProveedor(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<FacturaProveedor> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<FacturaProveedor> entities = new  ArrayList<FacturaProveedor>();
		FacturaProveedor entity = new FacturaProveedor();		  
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
	
	public  List<FacturaProveedor> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<FacturaProveedor> entities = new  ArrayList<FacturaProveedor>();
		FacturaProveedor entity = new FacturaProveedor();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FacturaProveedor();
				
				if(conMapGenerico) {
					entity.inicializarMapFacturaProveedor();
					//entity.setMapFacturaProveedor(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapFacturaProveedorValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapFacturaProveedor().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,FacturaProveedorDataAccess.ISWITHSCHEMA);         		
					entity=FacturaProveedorDataAccess.getEntityFacturaProveedor("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setFacturaProveedorOriginal( new FacturaProveedor());
					////entity.setFacturaProveedorOriginal(super.getEntity("",entity.getFacturaProveedorOriginal(),resultSet,FacturaProveedorDataAccess.ISWITHSCHEMA));         		
					////entity.setFacturaProveedorOriginal(this.getEntityFacturaProveedor("",entity.getFacturaProveedorOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseFacturaProveedors(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFacturaProveedor(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public FacturaProveedor getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		FacturaProveedor entity = new FacturaProveedor();		  
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
	
	public  FacturaProveedor getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		FacturaProveedor entity = new FacturaProveedor();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FacturaProveedor();
				
				if(conMapGenerico) {
					entity.inicializarMapFacturaProveedor();
					//entity.setMapFacturaProveedor(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapFacturaProveedorValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapFacturaProveedor().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,FacturaProveedorDataAccess.ISWITHSCHEMA);         		
					entity=FacturaProveedorDataAccess.getEntityFacturaProveedor("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setFacturaProveedorOriginal( new FacturaProveedor());
					////entity.setFacturaProveedorOriginal(super.getEntity("",entity.getFacturaProveedorOriginal(),resultSet,FacturaProveedorDataAccess.ISWITHSCHEMA));         		
					////entity.setFacturaProveedorOriginal(this.getEntityFacturaProveedor("",entity.getFacturaProveedorOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseFacturaProveedor(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFacturaProveedor(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static FacturaProveedor getEntityFacturaProveedor(String strPrefijo,FacturaProveedor entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = FacturaProveedor.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = FacturaProveedor.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					FacturaProveedorDataAccess.setFieldReflectionFacturaProveedor(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasFacturaProveedor=FacturaProveedorConstantesFunciones.getTodosTiposColumnasFacturaProveedor();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasFacturaProveedor) {
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
							field = FacturaProveedor.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = FacturaProveedor.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						FacturaProveedorDataAccess.setFieldReflectionFacturaProveedor(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionFacturaProveedor(Field field,String strPrefijo,String sColumn,FacturaProveedor entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case FacturaProveedorConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.IDMES:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.IDMODULO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.IDPLANTILLAFACTURA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.IDTIPODOCUMENTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.PLAZO:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.IDFACTURA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.NUMEROFACTURA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.IDTRANSACCION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.FECHAEMISION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case FacturaProveedorConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.RUC:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.IDEMPLEADOSOLICITA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.FECHAVENCE:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case FacturaProveedorConstantesFunciones.IDMONEDA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.CONACTIVOS:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.CONRISE:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.CONSITIOS:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.DETALLE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.VALORBIENES12:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.VALORSERVICIOS12:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.TOTALVALOR12:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.VALORBIENES0:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.VALORSERVICIOS0:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.TOTALVALOR0:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.BIENESICE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.SERVICIOSICE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.TOTALICE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.BIENESIVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.SERVICIOSIVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.TOTALIVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.IVAPORCENTAJE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.TOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.CONMONTOOBJETOIVA:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.NUMERORETENCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.NUMEROSERIE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.NUMEROAUTORIZACION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.FECHAVALIDEZ:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case FacturaProveedorConstantesFunciones.IDTIPORETENCIONFUENTE1:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.RETFUENTE1PORCENTAJE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.RETFUENTE1BASE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.RETFUENTE1RETENIDO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.IDTIPORETENCIONFUENTE2:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.RETFUENTE2PORCENTAJE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.RETFUENTE2BASE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.RETFUENTE2RETENIDO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.IDTIPORETENCIONIVA1:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.RETIVABIENPORCENTAJE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.RETIVABIENBASE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.RETIVABIENRETENIDO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.IDTIPORETENCIONIVA2:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.RETIVASERVICIOPORCENTAJE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.RETIVASERVICIOBASE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.RETIVASERVICIORETENIDO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.ANEXONUMEROAUTORIZACION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.ANEXONUMESOSERIE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.ANEXOFECHAVALIDEZ:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case FacturaProveedorConstantesFunciones.IDTIPOTRIBUTARIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.ANEXOFACTURAINICIO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.ANEXOFACTURAFIN:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.IDCUENTACONTABLECREDITOFISCALBIENES:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.IDRESPONSABLEFONDO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.IDCUENTACONTABLECREDITOFISCALSERVICIOS:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.SECUENCIAL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.IDCUENTACONTABLEGASTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.GASTOVALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.IDCUENTACONTABLEGASTO2:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.GASTOVALOR2:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.GASTONOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.GASTONOMBRE2:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.IDCUENTACONTABLECREDITOFIN:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.IDCUENTACONTABLECREDITOFIN2:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.IDCUENTACONTABLECREDITO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.IDTIPOMOVIMIENTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.IDTIPOMOVIMIENTOMODULO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.IDTIPOTRANSACCIONMODULO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.NUMEROMAYOR:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case FacturaProveedorConstantesFunciones.CODIGOASIENTO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<FacturaProveedor>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<FacturaProveedor> entities = new  ArrayList<FacturaProveedor>();
		FacturaProveedor entity = new FacturaProveedor();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=FacturaProveedorDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=FacturaProveedorDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FacturaProveedorDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new FacturaProveedor();
					entity=super.getEntity("",entity,resultSet,FacturaProveedorDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityFacturaProveedor("",entity,resultSet);
					
					//entity.setFacturaProveedorOriginal( new FacturaProveedor());
					//entity.setFacturaProveedorOriginal(super.getEntity("",entity.getFacturaProveedorOriginal(),resultSet,FacturaProveedorDataAccess.ISWITHSCHEMA));         		
					//entity.setFacturaProveedorOriginal(this.getEntityFacturaProveedor("",entity.getFacturaProveedorOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseFacturaProveedors(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFacturaProveedor(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<FacturaProveedor>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<FacturaProveedor> entities = new  ArrayList<FacturaProveedor>();
		FacturaProveedor entity = new FacturaProveedor();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=FacturaProveedorDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=FacturaProveedorDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,FacturaProveedorDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<FacturaProveedor> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<FacturaProveedor> entities = new  ArrayList<FacturaProveedor>();
		FacturaProveedor entity = new FacturaProveedor();		  
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
	
	public  List<FacturaProveedor> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<FacturaProveedor> entities = new  ArrayList<FacturaProveedor>();
		FacturaProveedor entity = new FacturaProveedor();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FacturaProveedor();
      	    	entity=super.getEntity("",entity,resultSet,FacturaProveedorDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityFacturaProveedor("",entity,resultSet);
      	    	
				//entity.setFacturaProveedorOriginal( new FacturaProveedor());
      	    	//entity.setFacturaProveedorOriginal(super.getEntity("",entity.getFacturaProveedorOriginal(),resultSet,FacturaProveedorDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFacturaProveedorOriginal(this.getEntityFacturaProveedor("",entity.getFacturaProveedorOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseFacturaProveedors(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarFacturaProveedor(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<FacturaProveedor> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<FacturaProveedor> entities = new  ArrayList<FacturaProveedor>();
		FacturaProveedor entity = new FacturaProveedor();		  
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
	
	public  List<FacturaProveedor> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<FacturaProveedor> entities = new  ArrayList<FacturaProveedor>();
		FacturaProveedor entity = new FacturaProveedor();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new FacturaProveedor();
      	    	entity=super.getEntity("",entity,resultSet,FacturaProveedorDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityFacturaProveedor("",entity,resultSet);
      	    	
				//entity.setFacturaProveedorOriginal( new FacturaProveedor());
      	    	//entity.setFacturaProveedorOriginal(super.getEntity("",entity.getFacturaProveedorOriginal(),resultSet,FacturaProveedorDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setFacturaProveedorOriginal(this.getEntityFacturaProveedor("",entity.getFacturaProveedorOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseFacturaProveedors(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public FacturaProveedor getEntityFacturaProveedor(String strPrefijo,FacturaProveedor entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+FacturaProveedorConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+FacturaProveedorConstantesFunciones.IDSUCURSAL));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+FacturaProveedorConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+FacturaProveedorConstantesFunciones.IDPERIODO));
				entity.setid_anio(resultSet.getLong(strPrefijo+FacturaProveedorConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
				entity.setid_mes(resultSet.getLong(strPrefijo+FacturaProveedorConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
				entity.setid_modulo(resultSet.getLong(strPrefijo+FacturaProveedorConstantesFunciones.IDMODULO));
				entity.setid_plantilla_factura(resultSet.getLong(strPrefijo+FacturaProveedorConstantesFunciones.IDPLANTILLAFACTURA));if(resultSet.wasNull()) {entity.setid_plantilla_factura(null); }
				entity.setid_tipo_documento(resultSet.getLong(strPrefijo+FacturaProveedorConstantesFunciones.IDTIPODOCUMENTO));
				entity.setplazo(resultSet.getInt(strPrefijo+FacturaProveedorConstantesFunciones.PLAZO));
				entity.setid_factura(resultSet.getLong(strPrefijo+FacturaProveedorConstantesFunciones.IDFACTURA));
				entity.setnumero_factura(resultSet.getString(strPrefijo+FacturaProveedorConstantesFunciones.NUMEROFACTURA));
				entity.setid_transaccion(resultSet.getLong(strPrefijo+FacturaProveedorConstantesFunciones.IDTRANSACCION));
				entity.setfecha_emision(new Date(resultSet.getDate(strPrefijo+FacturaProveedorConstantesFunciones.FECHAEMISION).getTime()));
				entity.setid_cliente(resultSet.getLong(strPrefijo+FacturaProveedorConstantesFunciones.IDCLIENTE));
				entity.setruc(resultSet.getString(strPrefijo+FacturaProveedorConstantesFunciones.RUC));
				entity.setid_empleado_solicita(resultSet.getLong(strPrefijo+FacturaProveedorConstantesFunciones.IDEMPLEADOSOLICITA));
				entity.setfecha_vence(new Date(resultSet.getDate(strPrefijo+FacturaProveedorConstantesFunciones.FECHAVENCE).getTime()));
				entity.setid_moneda(resultSet.getLong(strPrefijo+FacturaProveedorConstantesFunciones.IDMONEDA));
				entity.setid_empleado(resultSet.getLong(strPrefijo+FacturaProveedorConstantesFunciones.IDEMPLEADO));
				entity.setcon_activos(resultSet.getBoolean(strPrefijo+FacturaProveedorConstantesFunciones.CONACTIVOS));
				entity.setcon_rise(resultSet.getBoolean(strPrefijo+FacturaProveedorConstantesFunciones.CONRISE));
				entity.setcon_sitios(resultSet.getBoolean(strPrefijo+FacturaProveedorConstantesFunciones.CONSITIOS));
				entity.setdetalle(resultSet.getString(strPrefijo+FacturaProveedorConstantesFunciones.DETALLE));
				entity.setvalor_bienes12(resultSet.getDouble(strPrefijo+FacturaProveedorConstantesFunciones.VALORBIENES12));
				entity.setvalor_servicios12(resultSet.getDouble(strPrefijo+FacturaProveedorConstantesFunciones.VALORSERVICIOS12));
				entity.settotal_valor12(resultSet.getDouble(strPrefijo+FacturaProveedorConstantesFunciones.TOTALVALOR12));
				entity.setvalor_bienes0(resultSet.getDouble(strPrefijo+FacturaProveedorConstantesFunciones.VALORBIENES0));
				entity.setvalor_servicios0(resultSet.getDouble(strPrefijo+FacturaProveedorConstantesFunciones.VALORSERVICIOS0));
				entity.settotal_valor0(resultSet.getDouble(strPrefijo+FacturaProveedorConstantesFunciones.TOTALVALOR0));
				entity.setbienes_ice(resultSet.getDouble(strPrefijo+FacturaProveedorConstantesFunciones.BIENESICE));
				entity.setservicios_ice(resultSet.getDouble(strPrefijo+FacturaProveedorConstantesFunciones.SERVICIOSICE));
				entity.settotal_ice(resultSet.getDouble(strPrefijo+FacturaProveedorConstantesFunciones.TOTALICE));
				entity.setbienes_iva(resultSet.getDouble(strPrefijo+FacturaProveedorConstantesFunciones.BIENESIVA));
				entity.setservicios_iva(resultSet.getDouble(strPrefijo+FacturaProveedorConstantesFunciones.SERVICIOSIVA));
				entity.settotal_iva(resultSet.getDouble(strPrefijo+FacturaProveedorConstantesFunciones.TOTALIVA));
				entity.setiva_porcentaje(resultSet.getDouble(strPrefijo+FacturaProveedorConstantesFunciones.IVAPORCENTAJE));
				entity.settotal(resultSet.getDouble(strPrefijo+FacturaProveedorConstantesFunciones.TOTAL));
				entity.setcon_monto_objeto_iva(resultSet.getBoolean(strPrefijo+FacturaProveedorConstantesFunciones.CONMONTOOBJETOIVA));
				entity.setnumero_retencion(resultSet.getString(strPrefijo+FacturaProveedorConstantesFunciones.NUMERORETENCION));
				entity.setnumero_serie(resultSet.getString(strPrefijo+FacturaProveedorConstantesFunciones.NUMEROSERIE));
				entity.setnumero_autorizacion(resultSet.getString(strPrefijo+FacturaProveedorConstantesFunciones.NUMEROAUTORIZACION));
				entity.setfecha_validez(new Date(resultSet.getDate(strPrefijo+FacturaProveedorConstantesFunciones.FECHAVALIDEZ).getTime()));
				entity.setid_tipo_retencion_fuente1(resultSet.getLong(strPrefijo+FacturaProveedorConstantesFunciones.IDTIPORETENCIONFUENTE1));
				entity.setret_fuente1_porcentaje(resultSet.getDouble(strPrefijo+FacturaProveedorConstantesFunciones.RETFUENTE1PORCENTAJE));
				entity.setret_fuente1_base(resultSet.getDouble(strPrefijo+FacturaProveedorConstantesFunciones.RETFUENTE1BASE));
				entity.setret_fuente1_retenido(resultSet.getDouble(strPrefijo+FacturaProveedorConstantesFunciones.RETFUENTE1RETENIDO));
				entity.setid_tipo_retencion_fuente2(resultSet.getLong(strPrefijo+FacturaProveedorConstantesFunciones.IDTIPORETENCIONFUENTE2));
				entity.setret_fuente2_porcentaje(resultSet.getDouble(strPrefijo+FacturaProveedorConstantesFunciones.RETFUENTE2PORCENTAJE));
				entity.setret_fuente2_base(resultSet.getDouble(strPrefijo+FacturaProveedorConstantesFunciones.RETFUENTE2BASE));
				entity.setret_fuente2_retenido(resultSet.getDouble(strPrefijo+FacturaProveedorConstantesFunciones.RETFUENTE2RETENIDO));
				entity.setid_tipo_retencion_iva1(resultSet.getLong(strPrefijo+FacturaProveedorConstantesFunciones.IDTIPORETENCIONIVA1));
				entity.setret_iva_bien_porcentaje(resultSet.getDouble(strPrefijo+FacturaProveedorConstantesFunciones.RETIVABIENPORCENTAJE));
				entity.setret_iva_bien_base(resultSet.getDouble(strPrefijo+FacturaProveedorConstantesFunciones.RETIVABIENBASE));
				entity.setret_iva_bien_retenido(resultSet.getDouble(strPrefijo+FacturaProveedorConstantesFunciones.RETIVABIENRETENIDO));
				entity.setid_tipo_retencion_iva2(resultSet.getLong(strPrefijo+FacturaProveedorConstantesFunciones.IDTIPORETENCIONIVA2));
				entity.setret_iva_servicio_porcentaje(resultSet.getDouble(strPrefijo+FacturaProveedorConstantesFunciones.RETIVASERVICIOPORCENTAJE));
				entity.setret_iva_servicio_base(resultSet.getDouble(strPrefijo+FacturaProveedorConstantesFunciones.RETIVASERVICIOBASE));
				entity.setret_iva_servicio_retenido(resultSet.getDouble(strPrefijo+FacturaProveedorConstantesFunciones.RETIVASERVICIORETENIDO));
				entity.setanexo_numero_autorizacion(resultSet.getString(strPrefijo+FacturaProveedorConstantesFunciones.ANEXONUMEROAUTORIZACION));
				entity.setanexo_numeso_serie(resultSet.getString(strPrefijo+FacturaProveedorConstantesFunciones.ANEXONUMESOSERIE));
				entity.setanexo_fecha_validez(new Date(resultSet.getDate(strPrefijo+FacturaProveedorConstantesFunciones.ANEXOFECHAVALIDEZ).getTime()));
				entity.setid_tipo_tributario(resultSet.getLong(strPrefijo+FacturaProveedorConstantesFunciones.IDTIPOTRIBUTARIO));
				entity.setanexo_factura_inicio(resultSet.getString(strPrefijo+FacturaProveedorConstantesFunciones.ANEXOFACTURAINICIO));
				entity.setanexo_factura_fin(resultSet.getString(strPrefijo+FacturaProveedorConstantesFunciones.ANEXOFACTURAFIN));
				entity.setid_cuenta_contable_credito_fiscal_bienes(resultSet.getLong(strPrefijo+FacturaProveedorConstantesFunciones.IDCUENTACONTABLECREDITOFISCALBIENES));
				entity.setid_responsable_fondo(resultSet.getLong(strPrefijo+FacturaProveedorConstantesFunciones.IDRESPONSABLEFONDO));
				entity.setid_cuenta_contable_credito_fiscal_servicios(resultSet.getLong(strPrefijo+FacturaProveedorConstantesFunciones.IDCUENTACONTABLECREDITOFISCALSERVICIOS));
				entity.setsecuencial(resultSet.getString(strPrefijo+FacturaProveedorConstantesFunciones.SECUENCIAL));
				entity.setid_cuenta_contable_gasto(resultSet.getLong(strPrefijo+FacturaProveedorConstantesFunciones.IDCUENTACONTABLEGASTO));
				entity.setgasto_valor(resultSet.getDouble(strPrefijo+FacturaProveedorConstantesFunciones.GASTOVALOR));
				entity.setid_cuenta_contable_gasto2(resultSet.getLong(strPrefijo+FacturaProveedorConstantesFunciones.IDCUENTACONTABLEGASTO2));
				entity.setgasto_valor2(resultSet.getDouble(strPrefijo+FacturaProveedorConstantesFunciones.GASTOVALOR2));
				entity.setgasto_nombre(resultSet.getString(strPrefijo+FacturaProveedorConstantesFunciones.GASTONOMBRE));if(resultSet.wasNull()) {entity.setgasto_nombre(null); }
				entity.setgasto_nombre2(resultSet.getString(strPrefijo+FacturaProveedorConstantesFunciones.GASTONOMBRE2));if(resultSet.wasNull()) {entity.setgasto_nombre2(null); }
				entity.setid_cuenta_contable_credito_fin(resultSet.getLong(strPrefijo+FacturaProveedorConstantesFunciones.IDCUENTACONTABLECREDITOFIN));if(resultSet.wasNull()) {entity.setid_cuenta_contable_credito_fin(null); }
				entity.setid_cuenta_contable_credito_fin2(resultSet.getLong(strPrefijo+FacturaProveedorConstantesFunciones.IDCUENTACONTABLECREDITOFIN2));if(resultSet.wasNull()) {entity.setid_cuenta_contable_credito_fin2(null); }
				entity.setid_cuenta_contable_credito(resultSet.getLong(strPrefijo+FacturaProveedorConstantesFunciones.IDCUENTACONTABLECREDITO));if(resultSet.wasNull()) {entity.setid_cuenta_contable_credito(null); }
				entity.setdescripcion(resultSet.getString(strPrefijo+FacturaProveedorConstantesFunciones.DESCRIPCION));
				entity.setid_tipo_movimiento(resultSet.getLong(strPrefijo+FacturaProveedorConstantesFunciones.IDTIPOMOVIMIENTO));if(resultSet.wasNull()) {entity.setid_tipo_movimiento(null); }
				entity.setid_tipo_movimiento_modulo(resultSet.getLong(strPrefijo+FacturaProveedorConstantesFunciones.IDTIPOMOVIMIENTOMODULO));if(resultSet.wasNull()) {entity.setid_tipo_movimiento_modulo(null); }
				entity.setid_tipo_transaccion_modulo(resultSet.getLong(strPrefijo+FacturaProveedorConstantesFunciones.IDTIPOTRANSACCIONMODULO));if(resultSet.wasNull()) {entity.setid_tipo_transaccion_modulo(null); }
				entity.setnumero_mayor(resultSet.getString(strPrefijo+FacturaProveedorConstantesFunciones.NUMEROMAYOR));
				entity.setcodigo_asiento(resultSet.getString(strPrefijo+FacturaProveedorConstantesFunciones.CODIGOASIENTO));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowFacturaProveedor(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(FacturaProveedor entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=FacturaProveedorDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=FacturaProveedorDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=FacturaProveedorDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=FacturaProveedorDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(FacturaProveedorConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,FacturaProveedorDataAccess.TABLENAME,FacturaProveedorDataAccess.ISWITHSTOREPROCEDURES);
			
			FacturaProveedorDataAccess.setFacturaProveedorOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,FacturaProveedor relfacturaproveedor)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relfacturaproveedor.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,FacturaProveedor relfacturaproveedor)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relfacturaproveedor.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,FacturaProveedor relfacturaproveedor)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relfacturaproveedor.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,FacturaProveedor relfacturaproveedor)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,relfacturaproveedor.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public Anio getAnio(Connexion connexion,FacturaProveedor relfacturaproveedor)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);

			anio=anioDataAccess.getEntity(connexion,relfacturaproveedor.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Mes getMes(Connexion connexion,FacturaProveedor relfacturaproveedor)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,relfacturaproveedor.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}

	public Modulo getModulo(Connexion connexion,FacturaProveedor relfacturaproveedor)throws SQLException,Exception {

		Modulo modulo= new Modulo();

		try {
			ModuloDataAccess moduloDataAccess=new ModuloDataAccess();

			moduloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			moduloDataAccess.setConnexionType(this.connexionType);
			moduloDataAccess.setParameterDbType(this.parameterDbType);

			modulo=moduloDataAccess.getEntity(connexion,relfacturaproveedor.getid_modulo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return modulo;

	}

	public PlantillaFactura getPlantillaFactura(Connexion connexion,FacturaProveedor relfacturaproveedor)throws SQLException,Exception {

		PlantillaFactura plantillafactura= new PlantillaFactura();

		try {
			PlantillaFacturaDataAccess plantillafacturaDataAccess=new PlantillaFacturaDataAccess();

			plantillafacturaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			plantillafacturaDataAccess.setConnexionType(this.connexionType);
			plantillafacturaDataAccess.setParameterDbType(this.parameterDbType);

			plantillafactura=plantillafacturaDataAccess.getEntity(connexion,relfacturaproveedor.getid_plantilla_factura());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return plantillafactura;

	}

	public TipoDocumento getTipoDocumento(Connexion connexion,FacturaProveedor relfacturaproveedor)throws SQLException,Exception {

		TipoDocumento tipodocumento= new TipoDocumento();

		try {
			TipoDocumentoDataAccess tipodocumentoDataAccess=new TipoDocumentoDataAccess();

			tipodocumentoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipodocumentoDataAccess.setConnexionType(this.connexionType);
			tipodocumentoDataAccess.setParameterDbType(this.parameterDbType);

			tipodocumento=tipodocumentoDataAccess.getEntity(connexion,relfacturaproveedor.getid_tipo_documento());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipodocumento;

	}

	public Factura getFactura(Connexion connexion,FacturaProveedor relfacturaproveedor)throws SQLException,Exception {

		Factura factura= new Factura();

		try {
			FacturaDataAccess facturaDataAccess=new FacturaDataAccess();

			facturaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			facturaDataAccess.setConnexionType(this.connexionType);
			facturaDataAccess.setParameterDbType(this.parameterDbType);

			factura=facturaDataAccess.getEntity(connexion,relfacturaproveedor.getid_factura());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return factura;

	}

	public Transaccion getTransaccion(Connexion connexion,FacturaProveedor relfacturaproveedor)throws SQLException,Exception {

		Transaccion transaccion= new Transaccion();

		try {
			TransaccionDataAccess transaccionDataAccess=new TransaccionDataAccess();

			transaccionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transaccionDataAccess.setConnexionType(this.connexionType);
			transaccionDataAccess.setParameterDbType(this.parameterDbType);

			transaccion=transaccionDataAccess.getEntity(connexion,relfacturaproveedor.getid_transaccion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccion;

	}

	public Cliente getCliente(Connexion connexion,FacturaProveedor relfacturaproveedor)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,relfacturaproveedor.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public Empleado getEmpleadoSolicita(Connexion connexion,FacturaProveedor relfacturaproveedor)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relfacturaproveedor.getid_empleado_solicita());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public Moneda getMoneda(Connexion connexion,FacturaProveedor relfacturaproveedor)throws SQLException,Exception {

		Moneda moneda= new Moneda();

		try {
			MonedaDataAccess monedaDataAccess=new MonedaDataAccess();

			monedaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			monedaDataAccess.setConnexionType(this.connexionType);
			monedaDataAccess.setParameterDbType(this.parameterDbType);

			moneda=monedaDataAccess.getEntity(connexion,relfacturaproveedor.getid_moneda());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return moneda;

	}

	public Empleado getEmpleado(Connexion connexion,FacturaProveedor relfacturaproveedor)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relfacturaproveedor.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public TipoRetencion getTipoRetencionFuente1(Connexion connexion,FacturaProveedor relfacturaproveedor)throws SQLException,Exception {

		TipoRetencion tiporetencion= new TipoRetencion();

		try {
			TipoRetencionDataAccess tiporetencionDataAccess=new TipoRetencionDataAccess();

			tiporetencionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tiporetencionDataAccess.setConnexionType(this.connexionType);
			tiporetencionDataAccess.setParameterDbType(this.parameterDbType);

			tiporetencion=tiporetencionDataAccess.getEntity(connexion,relfacturaproveedor.getid_tipo_retencion_fuente1());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tiporetencion;

	}

	public TipoRetencion getTipoRetencionFuente2(Connexion connexion,FacturaProveedor relfacturaproveedor)throws SQLException,Exception {

		TipoRetencion tiporetencion= new TipoRetencion();

		try {
			TipoRetencionDataAccess tiporetencionDataAccess=new TipoRetencionDataAccess();

			tiporetencionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tiporetencionDataAccess.setConnexionType(this.connexionType);
			tiporetencionDataAccess.setParameterDbType(this.parameterDbType);

			tiporetencion=tiporetencionDataAccess.getEntity(connexion,relfacturaproveedor.getid_tipo_retencion_fuente2());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tiporetencion;

	}

	public TipoRetencion getTipoRetencionIva1(Connexion connexion,FacturaProveedor relfacturaproveedor)throws SQLException,Exception {

		TipoRetencion tiporetencion= new TipoRetencion();

		try {
			TipoRetencionDataAccess tiporetencionDataAccess=new TipoRetencionDataAccess();

			tiporetencionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tiporetencionDataAccess.setConnexionType(this.connexionType);
			tiporetencionDataAccess.setParameterDbType(this.parameterDbType);

			tiporetencion=tiporetencionDataAccess.getEntity(connexion,relfacturaproveedor.getid_tipo_retencion_iva1());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tiporetencion;

	}

	public TipoRetencion getTipoRetencionIva2(Connexion connexion,FacturaProveedor relfacturaproveedor)throws SQLException,Exception {

		TipoRetencion tiporetencion= new TipoRetencion();

		try {
			TipoRetencionDataAccess tiporetencionDataAccess=new TipoRetencionDataAccess();

			tiporetencionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tiporetencionDataAccess.setConnexionType(this.connexionType);
			tiporetencionDataAccess.setParameterDbType(this.parameterDbType);

			tiporetencion=tiporetencionDataAccess.getEntity(connexion,relfacturaproveedor.getid_tipo_retencion_iva2());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tiporetencion;

	}

	public TipoTributario getTipoTributario(Connexion connexion,FacturaProveedor relfacturaproveedor)throws SQLException,Exception {

		TipoTributario tipotributario= new TipoTributario();

		try {
			TipoTributarioDataAccess tipotributarioDataAccess=new TipoTributarioDataAccess();

			tipotributarioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipotributarioDataAccess.setConnexionType(this.connexionType);
			tipotributarioDataAccess.setParameterDbType(this.parameterDbType);

			tipotributario=tipotributarioDataAccess.getEntity(connexion,relfacturaproveedor.getid_tipo_tributario());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipotributario;

	}

	public CuentaContable getCuentaContableCreditoFiscalBienes(Connexion connexion,FacturaProveedor relfacturaproveedor)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relfacturaproveedor.getid_cuenta_contable_credito_fiscal_bienes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public ResponsableFondo getResponsableFondo(Connexion connexion,FacturaProveedor relfacturaproveedor)throws SQLException,Exception {

		ResponsableFondo responsablefondo= new ResponsableFondo();

		try {
			ResponsableFondoDataAccess responsablefondoDataAccess=new ResponsableFondoDataAccess();

			responsablefondoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			responsablefondoDataAccess.setConnexionType(this.connexionType);
			responsablefondoDataAccess.setParameterDbType(this.parameterDbType);

			responsablefondo=responsablefondoDataAccess.getEntity(connexion,relfacturaproveedor.getid_responsable_fondo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return responsablefondo;

	}

	public CuentaContable getCuentaContableCreditoFiscalServicios(Connexion connexion,FacturaProveedor relfacturaproveedor)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relfacturaproveedor.getid_cuenta_contable_credito_fiscal_servicios());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableGasto(Connexion connexion,FacturaProveedor relfacturaproveedor)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relfacturaproveedor.getid_cuenta_contable_gasto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableGasto2(Connexion connexion,FacturaProveedor relfacturaproveedor)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relfacturaproveedor.getid_cuenta_contable_gasto2());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableCreditoFin(Connexion connexion,FacturaProveedor relfacturaproveedor)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relfacturaproveedor.getid_cuenta_contable_credito_fin());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableCreditoFin2(Connexion connexion,FacturaProveedor relfacturaproveedor)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relfacturaproveedor.getid_cuenta_contable_credito_fin2());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableCredito(Connexion connexion,FacturaProveedor relfacturaproveedor)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relfacturaproveedor.getid_cuenta_contable_credito());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public TipoMovimiento getTipoMovimiento(Connexion connexion,FacturaProveedor relfacturaproveedor)throws SQLException,Exception {

		TipoMovimiento tipomovimiento= new TipoMovimiento();

		try {
			TipoMovimientoDataAccess tipomovimientoDataAccess=new TipoMovimientoDataAccess();

			tipomovimientoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipomovimientoDataAccess.setConnexionType(this.connexionType);
			tipomovimientoDataAccess.setParameterDbType(this.parameterDbType);

			tipomovimiento=tipomovimientoDataAccess.getEntity(connexion,relfacturaproveedor.getid_tipo_movimiento());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipomovimiento;

	}

	public TipoMovimientoModulo getTipoMovimientoModulo(Connexion connexion,FacturaProveedor relfacturaproveedor)throws SQLException,Exception {

		TipoMovimientoModulo tipomovimientomodulo= new TipoMovimientoModulo();

		try {
			TipoMovimientoModuloDataAccess tipomovimientomoduloDataAccess=new TipoMovimientoModuloDataAccess();

			tipomovimientomoduloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipomovimientomoduloDataAccess.setConnexionType(this.connexionType);
			tipomovimientomoduloDataAccess.setParameterDbType(this.parameterDbType);

			tipomovimientomodulo=tipomovimientomoduloDataAccess.getEntity(connexion,relfacturaproveedor.getid_tipo_movimiento_modulo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipomovimientomodulo;

	}

	public TipoTransaccionModulo getTipoTransaccionModulo(Connexion connexion,FacturaProveedor relfacturaproveedor)throws SQLException,Exception {

		TipoTransaccionModulo tipotransaccionmodulo= new TipoTransaccionModulo();

		try {
			TipoTransaccionModuloDataAccess tipotransaccionmoduloDataAccess=new TipoTransaccionModuloDataAccess();

			tipotransaccionmoduloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipotransaccionmoduloDataAccess.setConnexionType(this.connexionType);
			tipotransaccionmoduloDataAccess.setParameterDbType(this.parameterDbType);

			tipotransaccionmodulo=tipotransaccionmoduloDataAccess.getEntity(connexion,relfacturaproveedor.getid_tipo_transaccion_modulo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipotransaccionmodulo;

	}


		
		public List<DetalleFacturaProveedor> getDetalleFacturaProveedors(Connexion connexion,FacturaProveedor facturaproveedor)throws SQLException,Exception {

		List<DetalleFacturaProveedor> detallefacturaproveedors= new ArrayList<DetalleFacturaProveedor>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+FacturaProveedorConstantesFunciones.SCHEMA+".factura_proveedor ON "+DetalleFacturaProveedorConstantesFunciones.SCHEMA+".detalle_factura_proveedor.id_factura_proveedor="+FacturaProveedorConstantesFunciones.SCHEMA+".factura_proveedor.id WHERE "+FacturaProveedorConstantesFunciones.SCHEMA+".factura_proveedor.id="+String.valueOf(facturaproveedor.getId());
			} else {
				sQuery=" INNER JOIN detallefacturaproveedor.FacturaProveedor WHERE detallefacturaproveedor.FacturaProveedor.id="+String.valueOf(facturaproveedor.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleFacturaProveedorDataAccess detallefacturaproveedorDataAccess=new DetalleFacturaProveedorDataAccess();

			detallefacturaproveedorDataAccess.setConnexionType(this.connexionType);
			detallefacturaproveedorDataAccess.setParameterDbType(this.parameterDbType);
			detallefacturaproveedors=detallefacturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detallefacturaproveedors;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,FacturaProveedor facturaproveedor) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!facturaproveedor.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(facturaproveedor.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(facturaproveedor.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(facturaproveedor.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(facturaproveedor.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_anio=new ParameterValue<Long>();
					parameterMaintenanceValueid_anio.setValue(facturaproveedor.getid_anio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_anio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes.setValue(facturaproveedor.getid_mes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_modulo=new ParameterValue<Long>();
					parameterMaintenanceValueid_modulo.setValue(facturaproveedor.getid_modulo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_modulo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_plantilla_factura=new ParameterValue<Long>();
					parameterMaintenanceValueid_plantilla_factura.setValue(facturaproveedor.getid_plantilla_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_plantilla_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_documento=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_documento.setValue(facturaproveedor.getid_tipo_documento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_documento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValueplazo=new ParameterValue<Integer>();
					parameterMaintenanceValueplazo.setValue(facturaproveedor.getplazo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueplazo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_factura=new ParameterValue<Long>();
					parameterMaintenanceValueid_factura.setValue(facturaproveedor.getid_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_factura=new ParameterValue<String>();
					parameterMaintenanceValuenumero_factura.setValue(facturaproveedor.getnumero_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transaccion=new ParameterValue<Long>();
					parameterMaintenanceValueid_transaccion.setValue(facturaproveedor.getid_transaccion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transaccion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_emision=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_emision.setValue(facturaproveedor.getfecha_emision());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_emision);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_cliente.setValue(facturaproveedor.getid_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueruc=new ParameterValue<String>();
					parameterMaintenanceValueruc.setValue(facturaproveedor.getruc());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueruc);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado_solicita=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado_solicita.setValue(facturaproveedor.getid_empleado_solicita());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado_solicita);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_vence=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_vence.setValue(facturaproveedor.getfecha_vence());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_vence);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_moneda=new ParameterValue<Long>();
					parameterMaintenanceValueid_moneda.setValue(facturaproveedor.getid_moneda());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_moneda);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(facturaproveedor.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_activos=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_activos.setValue(facturaproveedor.getcon_activos());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_activos);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_rise=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_rise.setValue(facturaproveedor.getcon_rise());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_rise);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_sitios=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_sitios.setValue(facturaproveedor.getcon_sitios());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_sitios);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedetalle=new ParameterValue<String>();
					parameterMaintenanceValuedetalle.setValue(facturaproveedor.getdetalle());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedetalle);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_bienes12=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_bienes12.setValue(facturaproveedor.getvalor_bienes12());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_bienes12);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_servicios12=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_servicios12.setValue(facturaproveedor.getvalor_servicios12());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_servicios12);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal_valor12=new ParameterValue<Double>();
					parameterMaintenanceValuetotal_valor12.setValue(facturaproveedor.gettotal_valor12());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal_valor12);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_bienes0=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_bienes0.setValue(facturaproveedor.getvalor_bienes0());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_bienes0);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_servicios0=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_servicios0.setValue(facturaproveedor.getvalor_servicios0());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_servicios0);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal_valor0=new ParameterValue<Double>();
					parameterMaintenanceValuetotal_valor0.setValue(facturaproveedor.gettotal_valor0());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal_valor0);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuebienes_ice=new ParameterValue<Double>();
					parameterMaintenanceValuebienes_ice.setValue(facturaproveedor.getbienes_ice());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuebienes_ice);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueservicios_ice=new ParameterValue<Double>();
					parameterMaintenanceValueservicios_ice.setValue(facturaproveedor.getservicios_ice());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueservicios_ice);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal_ice=new ParameterValue<Double>();
					parameterMaintenanceValuetotal_ice.setValue(facturaproveedor.gettotal_ice());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal_ice);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuebienes_iva=new ParameterValue<Double>();
					parameterMaintenanceValuebienes_iva.setValue(facturaproveedor.getbienes_iva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuebienes_iva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueservicios_iva=new ParameterValue<Double>();
					parameterMaintenanceValueservicios_iva.setValue(facturaproveedor.getservicios_iva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueservicios_iva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal_iva=new ParameterValue<Double>();
					parameterMaintenanceValuetotal_iva.setValue(facturaproveedor.gettotal_iva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal_iva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueiva_porcentaje=new ParameterValue<Double>();
					parameterMaintenanceValueiva_porcentaje.setValue(facturaproveedor.getiva_porcentaje());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueiva_porcentaje);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal=new ParameterValue<Double>();
					parameterMaintenanceValuetotal.setValue(facturaproveedor.gettotal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_monto_objeto_iva=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_monto_objeto_iva.setValue(facturaproveedor.getcon_monto_objeto_iva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_monto_objeto_iva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_retencion=new ParameterValue<String>();
					parameterMaintenanceValuenumero_retencion.setValue(facturaproveedor.getnumero_retencion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_retencion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_serie=new ParameterValue<String>();
					parameterMaintenanceValuenumero_serie.setValue(facturaproveedor.getnumero_serie());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_serie);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_autorizacion=new ParameterValue<String>();
					parameterMaintenanceValuenumero_autorizacion.setValue(facturaproveedor.getnumero_autorizacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_autorizacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_validez=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_validez.setValue(facturaproveedor.getfecha_validez());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_validez);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_retencion_fuente1=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_retencion_fuente1.setValue(facturaproveedor.getid_tipo_retencion_fuente1());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_retencion_fuente1);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueret_fuente1_porcentaje=new ParameterValue<Double>();
					parameterMaintenanceValueret_fuente1_porcentaje.setValue(facturaproveedor.getret_fuente1_porcentaje());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueret_fuente1_porcentaje);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueret_fuente1_base=new ParameterValue<Double>();
					parameterMaintenanceValueret_fuente1_base.setValue(facturaproveedor.getret_fuente1_base());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueret_fuente1_base);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueret_fuente1_retenido=new ParameterValue<Double>();
					parameterMaintenanceValueret_fuente1_retenido.setValue(facturaproveedor.getret_fuente1_retenido());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueret_fuente1_retenido);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_retencion_fuente2=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_retencion_fuente2.setValue(facturaproveedor.getid_tipo_retencion_fuente2());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_retencion_fuente2);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueret_fuente2_porcentaje=new ParameterValue<Double>();
					parameterMaintenanceValueret_fuente2_porcentaje.setValue(facturaproveedor.getret_fuente2_porcentaje());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueret_fuente2_porcentaje);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueret_fuente2_base=new ParameterValue<Double>();
					parameterMaintenanceValueret_fuente2_base.setValue(facturaproveedor.getret_fuente2_base());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueret_fuente2_base);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueret_fuente2_retenido=new ParameterValue<Double>();
					parameterMaintenanceValueret_fuente2_retenido.setValue(facturaproveedor.getret_fuente2_retenido());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueret_fuente2_retenido);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_retencion_iva1=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_retencion_iva1.setValue(facturaproveedor.getid_tipo_retencion_iva1());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_retencion_iva1);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueret_iva_bien_porcentaje=new ParameterValue<Double>();
					parameterMaintenanceValueret_iva_bien_porcentaje.setValue(facturaproveedor.getret_iva_bien_porcentaje());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueret_iva_bien_porcentaje);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueret_iva_bien_base=new ParameterValue<Double>();
					parameterMaintenanceValueret_iva_bien_base.setValue(facturaproveedor.getret_iva_bien_base());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueret_iva_bien_base);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueret_iva_bien_retenido=new ParameterValue<Double>();
					parameterMaintenanceValueret_iva_bien_retenido.setValue(facturaproveedor.getret_iva_bien_retenido());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueret_iva_bien_retenido);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_retencion_iva2=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_retencion_iva2.setValue(facturaproveedor.getid_tipo_retencion_iva2());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_retencion_iva2);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueret_iva_servicio_porcentaje=new ParameterValue<Double>();
					parameterMaintenanceValueret_iva_servicio_porcentaje.setValue(facturaproveedor.getret_iva_servicio_porcentaje());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueret_iva_servicio_porcentaje);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueret_iva_servicio_base=new ParameterValue<Double>();
					parameterMaintenanceValueret_iva_servicio_base.setValue(facturaproveedor.getret_iva_servicio_base());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueret_iva_servicio_base);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueret_iva_servicio_retenido=new ParameterValue<Double>();
					parameterMaintenanceValueret_iva_servicio_retenido.setValue(facturaproveedor.getret_iva_servicio_retenido());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueret_iva_servicio_retenido);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueanexo_numero_autorizacion=new ParameterValue<String>();
					parameterMaintenanceValueanexo_numero_autorizacion.setValue(facturaproveedor.getanexo_numero_autorizacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueanexo_numero_autorizacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueanexo_numeso_serie=new ParameterValue<String>();
					parameterMaintenanceValueanexo_numeso_serie.setValue(facturaproveedor.getanexo_numeso_serie());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueanexo_numeso_serie);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValueanexo_fecha_validez=new ParameterValue<Date>();
					parameterMaintenanceValueanexo_fecha_validez.setValue(facturaproveedor.getanexo_fecha_validez());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueanexo_fecha_validez);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_tributario=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_tributario.setValue(facturaproveedor.getid_tipo_tributario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_tributario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueanexo_factura_inicio=new ParameterValue<String>();
					parameterMaintenanceValueanexo_factura_inicio.setValue(facturaproveedor.getanexo_factura_inicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueanexo_factura_inicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueanexo_factura_fin=new ParameterValue<String>();
					parameterMaintenanceValueanexo_factura_fin.setValue(facturaproveedor.getanexo_factura_fin());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueanexo_factura_fin);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_credito_fiscal_bienes=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_credito_fiscal_bienes.setValue(facturaproveedor.getid_cuenta_contable_credito_fiscal_bienes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_credito_fiscal_bienes);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_responsable_fondo=new ParameterValue<Long>();
					parameterMaintenanceValueid_responsable_fondo.setValue(facturaproveedor.getid_responsable_fondo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_responsable_fondo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_credito_fiscal_servicios=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_credito_fiscal_servicios.setValue(facturaproveedor.getid_cuenta_contable_credito_fiscal_servicios());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_credito_fiscal_servicios);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuesecuencial=new ParameterValue<String>();
					parameterMaintenanceValuesecuencial.setValue(facturaproveedor.getsecuencial());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesecuencial);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_gasto=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_gasto.setValue(facturaproveedor.getid_cuenta_contable_gasto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_gasto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuegasto_valor=new ParameterValue<Double>();
					parameterMaintenanceValuegasto_valor.setValue(facturaproveedor.getgasto_valor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuegasto_valor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_gasto2=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_gasto2.setValue(facturaproveedor.getid_cuenta_contable_gasto2());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_gasto2);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuegasto_valor2=new ParameterValue<Double>();
					parameterMaintenanceValuegasto_valor2.setValue(facturaproveedor.getgasto_valor2());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuegasto_valor2);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuegasto_nombre=new ParameterValue<String>();
					parameterMaintenanceValuegasto_nombre.setValue(facturaproveedor.getgasto_nombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuegasto_nombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuegasto_nombre2=new ParameterValue<String>();
					parameterMaintenanceValuegasto_nombre2.setValue(facturaproveedor.getgasto_nombre2());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuegasto_nombre2);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_credito_fin=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_credito_fin.setValue(facturaproveedor.getid_cuenta_contable_credito_fin());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_credito_fin);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_credito_fin2=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_credito_fin2.setValue(facturaproveedor.getid_cuenta_contable_credito_fin2());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_credito_fin2);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_credito=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_credito.setValue(facturaproveedor.getid_cuenta_contable_credito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_credito);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(facturaproveedor.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_movimiento=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_movimiento.setValue(facturaproveedor.getid_tipo_movimiento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_movimiento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_movimiento_modulo=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_movimiento_modulo.setValue(facturaproveedor.getid_tipo_movimiento_modulo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_movimiento_modulo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_transaccion_modulo=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_transaccion_modulo.setValue(facturaproveedor.getid_tipo_transaccion_modulo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_transaccion_modulo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_mayor=new ParameterValue<String>();
					parameterMaintenanceValuenumero_mayor.setValue(facturaproveedor.getnumero_mayor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_mayor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo_asiento=new ParameterValue<String>();
					parameterMaintenanceValuecodigo_asiento.setValue(facturaproveedor.getcodigo_asiento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo_asiento);
					parametersTemp.add(parameterMaintenance);
					
						if(!facturaproveedor.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(facturaproveedor.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(facturaproveedor.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(facturaproveedor.getId());
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
	
	public void setIsNewIsChangedFalseFacturaProveedor(FacturaProveedor facturaproveedor)throws Exception  {		
		facturaproveedor.setIsNew(false);
		facturaproveedor.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseFacturaProveedors(List<FacturaProveedor> facturaproveedors)throws Exception  {				
		for(FacturaProveedor facturaproveedor:facturaproveedors) {
			facturaproveedor.setIsNew(false);
			facturaproveedor.setIsChanged(false);
		}
	}
	
	public void generarExportarFacturaProveedor(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
