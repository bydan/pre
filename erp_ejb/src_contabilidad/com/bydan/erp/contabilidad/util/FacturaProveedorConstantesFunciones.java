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
package com.bydan.erp.contabilidad.util;

import org.apache.log4j.Logger;
import java.sql.Time;
import java.sql.Timestamp;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.swing.border.Border;
import java.io.InputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Date;
//import java.util.ArrayList;

import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.GeneralEntityReturnGeneral;
import com.bydan.framework.erp.business.entity.GeneralEntityParameterGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.OrderBy;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.entity.Reporte;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;


import com.bydan.erp.contabilidad.util.FacturaProveedorConstantesFunciones;
import com.bydan.erp.contabilidad.util.FacturaProveedorParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.FacturaProveedorParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class FacturaProveedorConstantesFunciones extends FacturaProveedorConstantesFuncionesAdditional {		
	
	
	
	public static String S_TIPOREPORTE_EXTRA="";
	
	//USADO MAS EN RELACIONADO PARA MANTENIMIENTO MAESTRO-DETALLE
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOS=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOS;
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOS=Constantes.ISWING_TAMANIOMINIMO_TABLADATOS;
	
	//PARA TABLA RELACIONES(DESCRIPCION HEIGHTPE_REL_TAB)
	public static Integer ALTO_TABPANE_RELACIONES=Constantes.ISWING_ALTO_TABPANE + Funciones2.getValorProporcion(Constantes.ISWING_ALTO_TABPANE,0);
	
	//PARA TABLA RELACIONADO(DESCRIPTION HEIGHTPE_REL)
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL,0);		
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL,0);	
	
	//PARA CAMBIAR TODO--> SE CAMBIA EN TABLA RELACIONES Y TABLAS RELACIONADOS
	/*
	PARA MANEJAR EL TAB RELACIONES CON TABLA DE DATOS SE DEBE MODIFICAR Y VERIFICAR LOS VALORES CONTANTES:	
		final public static Integer ISWING_TAMANIOMAXIMO_TABLADATOSREL=240;//230;350;		
		final public static Integer ISWING_TAMANIOMINIMO_TABLADATOSREL=240;//230;260
		
		final public static Integer ISWING_ALTO_TABPANE=375;//375;400;260;
	CASO CONTRARIO, ESTOS VALORES SERIAN PARA CADA CASO (NO CONSTANTES)
	
	NOTA:
	* LA ALINEACION HORIZONTAL,FALTA
	*/
	
	
	public static final String SFINALQUERY=Constantes.SFINALQUERY;	
	public static final String SNOMBREOPCION="FacturaProveedor";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="FacturaProveedor"+FacturaProveedorConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="FacturaProveedorHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="FacturaProveedorHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=FacturaProveedorConstantesFunciones.SCHEMA+"_"+FacturaProveedorConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/FacturaProveedorHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=FacturaProveedorConstantesFunciones.SCHEMA+"_"+FacturaProveedorConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=FacturaProveedorConstantesFunciones.SCHEMA+"_"+FacturaProveedorConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/FacturaProveedorHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=FacturaProveedorConstantesFunciones.SCHEMA+"_"+FacturaProveedorConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FacturaProveedorConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/FacturaProveedorHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FacturaProveedorConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FacturaProveedorConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/FacturaProveedorHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FacturaProveedorConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=FacturaProveedorConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+FacturaProveedorConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=FacturaProveedorConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+FacturaProveedorConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Factura Proveedors";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Factura Proveedor";
	public static final String SCLASSWEBTITULO_LOWER="Factura Proveedor";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="FacturaProveedor";
	public static final String OBJECTNAME="facturaproveedor";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="factura_proveedor";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select facturaproveedor from "+FacturaProveedorConstantesFunciones.SPERSISTENCENAME+" facturaproveedor";
	public static String QUERYSELECTNATIVE="select "+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".id,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".version_row,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".id_empresa,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".id_sucursal,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".id_ejercicio,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".id_periodo,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".id_anio,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".id_mes,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".id_modulo,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".id_plantilla_factura,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".id_tipo_documento,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".plazo,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".id_factura,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".numero_factura,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".id_transaccion,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".fecha_emision,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".id_cliente,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".ruc,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".id_empleado_solicita,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".fecha_vence,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".id_moneda,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".id_empleado,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".con_activos,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".con_rise,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".con_sitios,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".detalle,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".valor_bienes12,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".valor_servicios12,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".total_valor12,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".valor_bienes0,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".valor_servicios0,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".total_valor0,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".bienes_ice,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".servicios_ice,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".total_ice,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".bienes_iva,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".servicios_iva,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".total_iva,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".iva_porcentaje,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".total,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".con_monto_objeto_iva,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".numero_retencion,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".numero_serie,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".numero_autorizacion,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".fecha_validez,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".id_tipo_retencion_fuente1,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".ret_fuente1_porcentaje,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".ret_fuente1_base,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".ret_fuente1_retenido,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".id_tipo_retencion_fuente2,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".ret_fuente2_porcentaje,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".ret_fuente2_base,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".ret_fuente2_retenido,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".id_tipo_retencion_iva1,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".ret_iva_bien_porcentaje,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".ret_iva_bien_base,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".ret_iva_bien_retenido,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".id_tipo_retencion_iva2,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".ret_iva_servicio_porcentaje,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".ret_iva_servicio_base,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".ret_iva_servicio_retenido,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".anexo_numero_autorizacion,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".anexo_numeso_serie,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".anexo_fecha_validez,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".id_tipo_tributario,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".anexo_factura_inicio,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".anexo_factura_fin,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".id_cuenta_contable_credito_fiscal_bienes,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".id_responsable_fondo,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".id_cuenta_contable_credito_fiscal_servicios,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".secuencial,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".id_cuenta_contable_gasto,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".gasto_valor,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".id_cuenta_contable_gasto2,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".gasto_valor2,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".gasto_nombre,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".gasto_nombre2,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".id_cuenta_contable_credito_fin,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".id_cuenta_contable_credito_fin2,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".id_cuenta_contable_credito,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".descripcion,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".id_tipo_movimiento,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".id_tipo_movimiento_modulo,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".id_tipo_transaccion_modulo,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".numero_mayor,"+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME+".codigo_asiento from "+FacturaProveedorConstantesFunciones.SCHEMA+"."+FacturaProveedorConstantesFunciones.TABLENAME;//+" as "+FacturaProveedorConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=true;
	
	
	protected FacturaProveedorConstantesFuncionesAdditional facturaproveedorConstantesFuncionesAdditional=null;
	
	public FacturaProveedorConstantesFuncionesAdditional getFacturaProveedorConstantesFuncionesAdditional() {
		return this.facturaproveedorConstantesFuncionesAdditional;
	}
	
	public void setFacturaProveedorConstantesFuncionesAdditional(FacturaProveedorConstantesFuncionesAdditional facturaproveedorConstantesFuncionesAdditional) {
		try {
			this.facturaproveedorConstantesFuncionesAdditional=facturaproveedorConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDPERIODO= "id_periodo";
    public static final String IDANIO= "id_anio";
    public static final String IDMES= "id_mes";
    public static final String IDMODULO= "id_modulo";
    public static final String IDPLANTILLAFACTURA= "id_plantilla_factura";
    public static final String IDTIPODOCUMENTO= "id_tipo_documento";
    public static final String PLAZO= "plazo";
    public static final String IDFACTURA= "id_factura";
    public static final String NUMEROFACTURA= "numero_factura";
    public static final String IDTRANSACCION= "id_transaccion";
    public static final String FECHAEMISION= "fecha_emision";
    public static final String IDCLIENTE= "id_cliente";
    public static final String RUC= "ruc";
    public static final String IDEMPLEADOSOLICITA= "id_empleado_solicita";
    public static final String FECHAVENCE= "fecha_vence";
    public static final String IDMONEDA= "id_moneda";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String CONACTIVOS= "con_activos";
    public static final String CONRISE= "con_rise";
    public static final String CONSITIOS= "con_sitios";
    public static final String DETALLE= "detalle";
    public static final String VALORBIENES12= "valor_bienes12";
    public static final String VALORSERVICIOS12= "valor_servicios12";
    public static final String TOTALVALOR12= "total_valor12";
    public static final String VALORBIENES0= "valor_bienes0";
    public static final String VALORSERVICIOS0= "valor_servicios0";
    public static final String TOTALVALOR0= "total_valor0";
    public static final String BIENESICE= "bienes_ice";
    public static final String SERVICIOSICE= "servicios_ice";
    public static final String TOTALICE= "total_ice";
    public static final String BIENESIVA= "bienes_iva";
    public static final String SERVICIOSIVA= "servicios_iva";
    public static final String TOTALIVA= "total_iva";
    public static final String IVAPORCENTAJE= "iva_porcentaje";
    public static final String TOTAL= "total";
    public static final String CONMONTOOBJETOIVA= "con_monto_objeto_iva";
    public static final String NUMERORETENCION= "numero_retencion";
    public static final String NUMEROSERIE= "numero_serie";
    public static final String NUMEROAUTORIZACION= "numero_autorizacion";
    public static final String FECHAVALIDEZ= "fecha_validez";
    public static final String IDTIPORETENCIONFUENTE1= "id_tipo_retencion_fuente1";
    public static final String RETFUENTE1PORCENTAJE= "ret_fuente1_porcentaje";
    public static final String RETFUENTE1BASE= "ret_fuente1_base";
    public static final String RETFUENTE1RETENIDO= "ret_fuente1_retenido";
    public static final String IDTIPORETENCIONFUENTE2= "id_tipo_retencion_fuente2";
    public static final String RETFUENTE2PORCENTAJE= "ret_fuente2_porcentaje";
    public static final String RETFUENTE2BASE= "ret_fuente2_base";
    public static final String RETFUENTE2RETENIDO= "ret_fuente2_retenido";
    public static final String IDTIPORETENCIONIVA1= "id_tipo_retencion_iva1";
    public static final String RETIVABIENPORCENTAJE= "ret_iva_bien_porcentaje";
    public static final String RETIVABIENBASE= "ret_iva_bien_base";
    public static final String RETIVABIENRETENIDO= "ret_iva_bien_retenido";
    public static final String IDTIPORETENCIONIVA2= "id_tipo_retencion_iva2";
    public static final String RETIVASERVICIOPORCENTAJE= "ret_iva_servicio_porcentaje";
    public static final String RETIVASERVICIOBASE= "ret_iva_servicio_base";
    public static final String RETIVASERVICIORETENIDO= "ret_iva_servicio_retenido";
    public static final String ANEXONUMEROAUTORIZACION= "anexo_numero_autorizacion";
    public static final String ANEXONUMESOSERIE= "anexo_numeso_serie";
    public static final String ANEXOFECHAVALIDEZ= "anexo_fecha_validez";
    public static final String IDTIPOTRIBUTARIO= "id_tipo_tributario";
    public static final String ANEXOFACTURAINICIO= "anexo_factura_inicio";
    public static final String ANEXOFACTURAFIN= "anexo_factura_fin";
    public static final String IDCUENTACONTABLECREDITOFISCALBIENES= "id_cuenta_contable_credito_fiscal_bienes";
    public static final String IDRESPONSABLEFONDO= "id_responsable_fondo";
    public static final String IDCUENTACONTABLECREDITOFISCALSERVICIOS= "id_cuenta_contable_credito_fiscal_servicios";
    public static final String SECUENCIAL= "secuencial";
    public static final String IDCUENTACONTABLEGASTO= "id_cuenta_contable_gasto";
    public static final String GASTOVALOR= "gasto_valor";
    public static final String IDCUENTACONTABLEGASTO2= "id_cuenta_contable_gasto2";
    public static final String GASTOVALOR2= "gasto_valor2";
    public static final String GASTONOMBRE= "gasto_nombre";
    public static final String GASTONOMBRE2= "gasto_nombre2";
    public static final String IDCUENTACONTABLECREDITOFIN= "id_cuenta_contable_credito_fin";
    public static final String IDCUENTACONTABLECREDITOFIN2= "id_cuenta_contable_credito_fin2";
    public static final String IDCUENTACONTABLECREDITO= "id_cuenta_contable_credito";
    public static final String DESCRIPCION= "descripcion";
    public static final String IDTIPOMOVIMIENTO= "id_tipo_movimiento";
    public static final String IDTIPOMOVIMIENTOMODULO= "id_tipo_movimiento_modulo";
    public static final String IDTIPOTRANSACCIONMODULO= "id_tipo_transaccion_modulo";
    public static final String NUMEROMAYOR= "numero_mayor";
    public static final String CODIGOASIENTO= "codigo_asiento";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_IDPERIODO= "Periodo";
		public static final String LABEL_IDPERIODO_LOWER= "Periodo";
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_IDMES= "Mes";
		public static final String LABEL_IDMES_LOWER= "Mes";
    	public static final String LABEL_IDMODULO= "Modulo";
		public static final String LABEL_IDMODULO_LOWER= "Modulo";
    	public static final String LABEL_IDPLANTILLAFACTURA= "Plantilla Factura";
		public static final String LABEL_IDPLANTILLAFACTURA_LOWER= "Plantilla Factura";
    	public static final String LABEL_IDTIPODOCUMENTO= "T. Documento";
		public static final String LABEL_IDTIPODOCUMENTO_LOWER= "T. Documento";
    	public static final String LABEL_PLAZO= "Plazo";
		public static final String LABEL_PLAZO_LOWER= "Plazo";
    	public static final String LABEL_IDFACTURA= "Factura";
		public static final String LABEL_IDFACTURA_LOWER= "Factura";
    	public static final String LABEL_NUMEROFACTURA= "No Factura";
		public static final String LABEL_NUMEROFACTURA_LOWER= "No Factura";
    	public static final String LABEL_IDTRANSACCION= "T.Comprobante";
		public static final String LABEL_IDTRANSACCION_LOWER= "Comprobante";
    	public static final String LABEL_FECHAEMISION= "F. Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "Fecha Emi";
    	public static final String LABEL_IDCLIENTE= "Proveedor";
		public static final String LABEL_IDCLIENTE_LOWER= "Proveedor";
    	public static final String LABEL_RUC= "Ruc";
		public static final String LABEL_RUC_LOWER= "Ruc";
    	public static final String LABEL_IDEMPLEADOSOLICITA= "Empl.Solicita";
		public static final String LABEL_IDEMPLEADOSOLICITA_LOWER= "Empl Solicita";
    	public static final String LABEL_FECHAVENCE= "F. Vence";
		public static final String LABEL_FECHAVENCE_LOWER= "Fecha Vence";
    	public static final String LABEL_IDMONEDA= "Moneda";
		public static final String LABEL_IDMONEDA_LOWER= "Moneda";
    	public static final String LABEL_IDEMPLEADO= "Empl.Autoriza";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empl Autoriza";
    	public static final String LABEL_CONACTIVOS= "Activos";
		public static final String LABEL_CONACTIVOS_LOWER= "Activos";
    	public static final String LABEL_CONRISE= "Rise";
		public static final String LABEL_CONRISE_LOWER= "Rise";
    	public static final String LABEL_CONSITIOS= "Sitios";
		public static final String LABEL_CONSITIOS_LOWER= "Sitios";
    	public static final String LABEL_DETALLE= "Detalle";
		public static final String LABEL_DETALLE_LOWER= "Detalle";
    	public static final String LABEL_VALORBIENES12= "Valor12% B";
		public static final String LABEL_VALORBIENES12_LOWER= "Val Bienes 12";
    	public static final String LABEL_VALORSERVICIOS12= "Valor 12% S";
		public static final String LABEL_VALORSERVICIOS12_LOWER= "Val Servicios 12";
    	public static final String LABEL_TOTALVALOR12= "Total 12%";
		public static final String LABEL_TOTALVALOR12_LOWER= "Total Val 12";
    	public static final String LABEL_VALORBIENES0= "Valor 0% B";
		public static final String LABEL_VALORBIENES0_LOWER= "Val Bienes 0";
    	public static final String LABEL_VALORSERVICIOS0= "Valor 0% S";
		public static final String LABEL_VALORSERVICIOS0_LOWER= "Val Servicios 0";
    	public static final String LABEL_TOTALVALOR0= "Total 0%";
		public static final String LABEL_TOTALVALOR0_LOWER= "Total Val 0";
    	public static final String LABEL_BIENESICE= "ICE B.";
		public static final String LABEL_BIENESICE_LOWER= "Bienes Ice";
    	public static final String LABEL_SERVICIOSICE= "ICE S.";
		public static final String LABEL_SERVICIOSICE_LOWER= "Servicios Ice";
    	public static final String LABEL_TOTALICE= "Total ICE";
		public static final String LABEL_TOTALICE_LOWER= "Total Ice";
    	public static final String LABEL_BIENESIVA= "IVA B.";
		public static final String LABEL_BIENESIVA_LOWER= "Bienes Iva";
    	public static final String LABEL_SERVICIOSIVA= "IVA S.";
		public static final String LABEL_SERVICIOSIVA_LOWER= "Servicios Iva";
    	public static final String LABEL_TOTALIVA= "Total IVA";
		public static final String LABEL_TOTALIVA_LOWER= "Total Iva";
    	public static final String LABEL_IVAPORCENTAJE= "IVA %";
		public static final String LABEL_IVAPORCENTAJE_LOWER= "Iva %";
    	public static final String LABEL_TOTAL= "Total";
		public static final String LABEL_TOTAL_LOWER= "Total";
    	public static final String LABEL_CONMONTOOBJETOIVA= "Monto Sin Iva";
		public static final String LABEL_CONMONTOOBJETOIVA_LOWER= "Monto Sin Iva";
    	public static final String LABEL_NUMERORETENCION= "No Retencion";
		public static final String LABEL_NUMERORETENCION_LOWER= "No Retencion";
    	public static final String LABEL_NUMEROSERIE= "No Serie";
		public static final String LABEL_NUMEROSERIE_LOWER= "No Serie";
    	public static final String LABEL_NUMEROAUTORIZACION= "No Autori.";
		public static final String LABEL_NUMEROAUTORIZACION_LOWER= "No Autorizacion";
    	public static final String LABEL_FECHAVALIDEZ= "F. Validez";
		public static final String LABEL_FECHAVALIDEZ_LOWER= "Fec Validez";
    	public static final String LABEL_IDTIPORETENCIONFUENTE1= "Ret. Fuente 1";
		public static final String LABEL_IDTIPORETENCIONFUENTE1_LOWER= "RET FUENTE 1 ->";
    	public static final String LABEL_RETFUENTE1PORCENTAJE= "% F1";
		public static final String LABEL_RETFUENTE1PORCENTAJE_LOWER= "%";
    	public static final String LABEL_RETFUENTE1BASE= "Base F1";
		public static final String LABEL_RETFUENTE1BASE_LOWER= "Base";
    	public static final String LABEL_RETFUENTE1RETENIDO= "Val Retenido F1";
		public static final String LABEL_RETFUENTE1RETENIDO_LOWER= "Retenido";
    	public static final String LABEL_IDTIPORETENCIONFUENTE2= "Ret Fuente 2";
		public static final String LABEL_IDTIPORETENCIONFUENTE2_LOWER= "RET FUENTE 2 ->";
    	public static final String LABEL_RETFUENTE2PORCENTAJE= "% F2";
		public static final String LABEL_RETFUENTE2PORCENTAJE_LOWER= "%";
    	public static final String LABEL_RETFUENTE2BASE= "Base F2";
		public static final String LABEL_RETFUENTE2BASE_LOWER= "Base";
    	public static final String LABEL_RETFUENTE2RETENIDO= "Val Retenido F2";
		public static final String LABEL_RETFUENTE2RETENIDO_LOWER= "Retenido";
    	public static final String LABEL_IDTIPORETENCIONIVA1= "Ret Iva B.";
		public static final String LABEL_IDTIPORETENCIONIVA1_LOWER= "RET IVA BIEN ->";
    	public static final String LABEL_RETIVABIENPORCENTAJE= "% IB";
		public static final String LABEL_RETIVABIENPORCENTAJE_LOWER= "%";
    	public static final String LABEL_RETIVABIENBASE= "Base IB";
		public static final String LABEL_RETIVABIENBASE_LOWER= "Base";
    	public static final String LABEL_RETIVABIENRETENIDO= "Val Retenido IB";
		public static final String LABEL_RETIVABIENRETENIDO_LOWER= "Retenido";
    	public static final String LABEL_IDTIPORETENCIONIVA2= "Ret Iva S.";
		public static final String LABEL_IDTIPORETENCIONIVA2_LOWER= "RET IVA SERVICIO->";
    	public static final String LABEL_RETIVASERVICIOPORCENTAJE= "% IS";
		public static final String LABEL_RETIVASERVICIOPORCENTAJE_LOWER= "%";
    	public static final String LABEL_RETIVASERVICIOBASE= "Base IS";
		public static final String LABEL_RETIVASERVICIOBASE_LOWER= "Base";
    	public static final String LABEL_RETIVASERVICIORETENIDO= "Val Retenido IS";
		public static final String LABEL_RETIVASERVICIORETENIDO_LOWER= "Retenido";
    	public static final String LABEL_ANEXONUMEROAUTORIZACION= "No Autori";
		public static final String LABEL_ANEXONUMEROAUTORIZACION_LOWER= "No Autorizacion";
    	public static final String LABEL_ANEXONUMESOSERIE= "No Serie.";
		public static final String LABEL_ANEXONUMESOSERIE_LOWER= "No Serie";
    	public static final String LABEL_ANEXOFECHAVALIDEZ= "F. Validez.";
		public static final String LABEL_ANEXOFECHAVALIDEZ_LOWER= "Fec Validez";
    	public static final String LABEL_IDTIPOTRIBUTARIO= "Sustento Trib.";
		public static final String LABEL_IDTIPOTRIBUTARIO_LOWER= "T Tributario";
    	public static final String LABEL_ANEXOFACTURAINICIO= "Fac Ini";
		public static final String LABEL_ANEXOFACTURAINICIO_LOWER= "Fac Ini";
    	public static final String LABEL_ANEXOFACTURAFIN= "Fac Fin";
		public static final String LABEL_ANEXOFACTURAFIN_LOWER= "Fac Fin";
    	public static final String LABEL_IDCUENTACONTABLECREDITOFISCALBIENES= "Credito Fiscal Bienes";
		public static final String LABEL_IDCUENTACONTABLECREDITOFISCALBIENES_LOWER= "C.Credito Fiscal Bienes";
    	public static final String LABEL_IDRESPONSABLEFONDO= "Responsable";
		public static final String LABEL_IDRESPONSABLEFONDO_LOWER= "Responsable";
    	public static final String LABEL_IDCUENTACONTABLECREDITOFISCALSERVICIOS= "Credito Fiscal Servicios";
		public static final String LABEL_IDCUENTACONTABLECREDITOFISCALSERVICIOS_LOWER= "C.Credito Fiscal Servicios";
    	public static final String LABEL_SECUENCIAL= "Secuencial";
		public static final String LABEL_SECUENCIAL_LOWER= "Secuencial";
    	public static final String LABEL_IDCUENTACONTABLEGASTO= "C. Gasto";
		public static final String LABEL_IDCUENTACONTABLEGASTO_LOWER= "C.Gasto";
    	public static final String LABEL_GASTOVALOR= "Valor 1";
		public static final String LABEL_GASTOVALOR_LOWER= "Valor";
    	public static final String LABEL_IDCUENTACONTABLEGASTO2= "C. Gasto 2";
		public static final String LABEL_IDCUENTACONTABLEGASTO2_LOWER= "C.Gasto 2";
    	public static final String LABEL_GASTOVALOR2= "Valor 2";
		public static final String LABEL_GASTOVALOR2_LOWER= "Valor 2";
    	public static final String LABEL_GASTONOMBRE= "Gasto Nombre";
		public static final String LABEL_GASTONOMBRE_LOWER= "Gasto Nombre";
    	public static final String LABEL_GASTONOMBRE2= "Gasto Nombre2";
		public static final String LABEL_GASTONOMBRE2_LOWER= "Gasto Nombre2";
    	public static final String LABEL_IDCUENTACONTABLECREDITOFIN= "Cuenta Contable Credito Fin";
		public static final String LABEL_IDCUENTACONTABLECREDITOFIN_LOWER= "Cuenta Contable Credito Fin";
    	public static final String LABEL_IDCUENTACONTABLECREDITOFIN2= "Cuenta Contable Credito Fin 2";
		public static final String LABEL_IDCUENTACONTABLECREDITOFIN2_LOWER= "Cuenta Contable Credito Fin2";
    	public static final String LABEL_IDCUENTACONTABLECREDITO= "Cuenta Contable Credito";
		public static final String LABEL_IDCUENTACONTABLECREDITO_LOWER= "Cuenta Contable Credito";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_IDTIPOMOVIMIENTO= "Tipo Movimiento";
		public static final String LABEL_IDTIPOMOVIMIENTO_LOWER= "Tipo Movimiento";
    	public static final String LABEL_IDTIPOMOVIMIENTOMODULO= "Tipo Movimiento Modulo";
		public static final String LABEL_IDTIPOMOVIMIENTOMODULO_LOWER= "Tipo Movimiento Modulo";
    	public static final String LABEL_IDTIPOTRANSACCIONMODULO= "Tipo Comprobante";
		public static final String LABEL_IDTIPOTRANSACCIONMODULO_LOWER= "Tipo Comprobante";
    	public static final String LABEL_NUMEROMAYOR= "Numero Mayor";
		public static final String LABEL_NUMEROMAYOR_LOWER= "Numero Mayor";
    	public static final String LABEL_CODIGOASIENTO= "Codigo Asiento";
		public static final String LABEL_CODIGOASIENTO_LOWER= "Codigo Asiento";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXNUMERO_FACTURA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_FACTURA=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
	public static final String SREGEXRUC=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXRUC=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
	public static final String SREGEXDETALLE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDETALLE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXNUMERO_RETENCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_RETENCION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_SERIE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_SERIE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_AUTORIZACION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_AUTORIZACION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXANEXO_NUMERO_AUTORIZACION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXANEXO_NUMERO_AUTORIZACION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXANEXO_NUMESO_SERIE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXANEXO_NUMESO_SERIE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXANEXO_FACTURA_INICIO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXANEXO_FACTURA_INICIO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXANEXO_FACTURA_FIN=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXANEXO_FACTURA_FIN=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
	public static final String SREGEXSECUENCIAL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSECUENCIAL=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
	public static final String SREGEXGASTO_NOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXGASTO_NOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXGASTO_NOMBRE2=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXGASTO_NOMBRE2=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
	public static final String SREGEXNUMERO_MAYOR=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_MAYOR=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO_ASIENTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_ASIENTO=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getFacturaProveedorLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.IDEMPRESA)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.IDSUCURSAL)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.IDEJERCICIO)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.IDPERIODO)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.IDANIO)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.IDMES)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.IDMODULO)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_IDMODULO;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.IDPLANTILLAFACTURA)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_IDPLANTILLAFACTURA;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.IDTIPODOCUMENTO)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_IDTIPODOCUMENTO;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.PLAZO)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_PLAZO;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.IDFACTURA)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_IDFACTURA;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.NUMEROFACTURA)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_NUMEROFACTURA;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.IDTRANSACCION)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_IDTRANSACCION;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.FECHAEMISION)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.IDCLIENTE)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.RUC)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_RUC;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.IDEMPLEADOSOLICITA)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_IDEMPLEADOSOLICITA;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.FECHAVENCE)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_FECHAVENCE;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.IDMONEDA)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_IDMONEDA;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.IDEMPLEADO)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.CONACTIVOS)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_CONACTIVOS;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.CONRISE)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_CONRISE;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.CONSITIOS)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_CONSITIOS;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.DETALLE)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_DETALLE;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.VALORBIENES12)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_VALORBIENES12;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.VALORSERVICIOS12)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_VALORSERVICIOS12;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.TOTALVALOR12)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_TOTALVALOR12;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.VALORBIENES0)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_VALORBIENES0;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.VALORSERVICIOS0)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_VALORSERVICIOS0;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.TOTALVALOR0)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_TOTALVALOR0;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.BIENESICE)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_BIENESICE;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.SERVICIOSICE)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_SERVICIOSICE;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.TOTALICE)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_TOTALICE;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.BIENESIVA)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_BIENESIVA;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.SERVICIOSIVA)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_SERVICIOSIVA;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.TOTALIVA)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_TOTALIVA;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.IVAPORCENTAJE)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_IVAPORCENTAJE;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.TOTAL)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_TOTAL;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.CONMONTOOBJETOIVA)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_CONMONTOOBJETOIVA;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.NUMERORETENCION)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_NUMERORETENCION;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.NUMEROSERIE)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_NUMEROSERIE;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.NUMEROAUTORIZACION)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_NUMEROAUTORIZACION;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.FECHAVALIDEZ)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_FECHAVALIDEZ;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.IDTIPORETENCIONFUENTE1)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_IDTIPORETENCIONFUENTE1;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.RETFUENTE1PORCENTAJE)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_RETFUENTE1PORCENTAJE;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.RETFUENTE1BASE)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_RETFUENTE1BASE;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.RETFUENTE1RETENIDO)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_RETFUENTE1RETENIDO;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.IDTIPORETENCIONFUENTE2)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_IDTIPORETENCIONFUENTE2;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.RETFUENTE2PORCENTAJE)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_RETFUENTE2PORCENTAJE;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.RETFUENTE2BASE)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_RETFUENTE2BASE;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.RETFUENTE2RETENIDO)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_RETFUENTE2RETENIDO;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.IDTIPORETENCIONIVA1)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_IDTIPORETENCIONIVA1;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.RETIVABIENPORCENTAJE)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_RETIVABIENPORCENTAJE;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.RETIVABIENBASE)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_RETIVABIENBASE;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.RETIVABIENRETENIDO)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_RETIVABIENRETENIDO;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.IDTIPORETENCIONIVA2)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_IDTIPORETENCIONIVA2;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.RETIVASERVICIOPORCENTAJE)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_RETIVASERVICIOPORCENTAJE;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.RETIVASERVICIOBASE)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_RETIVASERVICIOBASE;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.RETIVASERVICIORETENIDO)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_RETIVASERVICIORETENIDO;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.ANEXONUMEROAUTORIZACION)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_ANEXONUMEROAUTORIZACION;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.ANEXONUMESOSERIE)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_ANEXONUMESOSERIE;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.ANEXOFECHAVALIDEZ)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_ANEXOFECHAVALIDEZ;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.IDTIPOTRIBUTARIO)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_IDTIPOTRIBUTARIO;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.ANEXOFACTURAINICIO)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_ANEXOFACTURAINICIO;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.ANEXOFACTURAFIN)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_ANEXOFACTURAFIN;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.IDCUENTACONTABLECREDITOFISCALBIENES)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_IDCUENTACONTABLECREDITOFISCALBIENES;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.IDRESPONSABLEFONDO)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_IDRESPONSABLEFONDO;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.IDCUENTACONTABLECREDITOFISCALSERVICIOS)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_IDCUENTACONTABLECREDITOFISCALSERVICIOS;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.SECUENCIAL)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_SECUENCIAL;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.IDCUENTACONTABLEGASTO)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_IDCUENTACONTABLEGASTO;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.GASTOVALOR)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_GASTOVALOR;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.IDCUENTACONTABLEGASTO2)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_IDCUENTACONTABLEGASTO2;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.GASTOVALOR2)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_GASTOVALOR2;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.GASTONOMBRE)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_GASTONOMBRE;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.GASTONOMBRE2)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_GASTONOMBRE2;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.IDCUENTACONTABLECREDITOFIN)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_IDCUENTACONTABLECREDITOFIN;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.IDCUENTACONTABLECREDITOFIN2)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_IDCUENTACONTABLECREDITOFIN2;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.IDCUENTACONTABLECREDITO)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.DESCRIPCION)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.IDTIPOMOVIMIENTO)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_IDTIPOMOVIMIENTO;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.IDTIPOMOVIMIENTOMODULO)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_IDTIPOMOVIMIENTOMODULO;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.NUMEROMAYOR)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_NUMEROMAYOR;}
		if(sNombreColumna.equals(FacturaProveedorConstantesFunciones.CODIGOASIENTO)) {sLabelColumna=FacturaProveedorConstantesFunciones.LABEL_CODIGOASIENTO;}
		
		if(sLabelColumna.equals("")) {
			sLabelColumna=sNombreColumna;	
		}
		return sLabelColumna;
	}
	
	
	
	public static String getNombreEjb_JBoss81(String sAplicacion,String sModule,String sClaseEjb,String sInterfaceEjb) throws Exception {
		String sDescripcion="";

		sDescripcion="ejb:"+sAplicacion+"/"+sModule+"/"+sClaseEjb+"!" + sInterfaceEjb;
		
		return sDescripcion;
	}
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getcon_activosDescripcion(FacturaProveedor facturaproveedor) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!facturaproveedor.getcon_activos()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_activosHtmlDescripcion(FacturaProveedor facturaproveedor) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(facturaproveedor.getId(),facturaproveedor.getcon_activos());

		return sDescripcion;
	}	
		
	public static String getcon_riseDescripcion(FacturaProveedor facturaproveedor) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!facturaproveedor.getcon_rise()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_riseHtmlDescripcion(FacturaProveedor facturaproveedor) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(facturaproveedor.getId(),facturaproveedor.getcon_rise());

		return sDescripcion;
	}	
		
	public static String getcon_sitiosDescripcion(FacturaProveedor facturaproveedor) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!facturaproveedor.getcon_sitios()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_sitiosHtmlDescripcion(FacturaProveedor facturaproveedor) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(facturaproveedor.getId(),facturaproveedor.getcon_sitios());

		return sDescripcion;
	}	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getcon_monto_objeto_ivaDescripcion(FacturaProveedor facturaproveedor) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!facturaproveedor.getcon_monto_objeto_iva()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_monto_objeto_ivaHtmlDescripcion(FacturaProveedor facturaproveedor) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(facturaproveedor.getId(),facturaproveedor.getcon_monto_objeto_iva());

		return sDescripcion;
	}	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getFacturaProveedorDescripcion(FacturaProveedor facturaproveedor) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(facturaproveedor !=null/* && facturaproveedor.getId()!=0*/) {
			if(facturaproveedor.getId()!=null) {
				sDescripcion=facturaproveedor.getId().toString();
			}//facturaproveedorfacturaproveedor.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getFacturaProveedorDescripcionDetallado(FacturaProveedor facturaproveedor) {
		String sDescripcion="";
			
		sDescripcion+=FacturaProveedorConstantesFunciones.ID+"=";
		sDescripcion+=facturaproveedor.getId().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=facturaproveedor.getVersionRow().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=facturaproveedor.getid_empresa().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=facturaproveedor.getid_sucursal().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=facturaproveedor.getid_ejercicio().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=facturaproveedor.getid_periodo().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.IDANIO+"=";
		sDescripcion+=facturaproveedor.getid_anio().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.IDMES+"=";
		sDescripcion+=facturaproveedor.getid_mes().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.IDMODULO+"=";
		sDescripcion+=facturaproveedor.getid_modulo().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.IDPLANTILLAFACTURA+"=";
		sDescripcion+=facturaproveedor.getid_plantilla_factura().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.IDTIPODOCUMENTO+"=";
		sDescripcion+=facturaproveedor.getid_tipo_documento().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.PLAZO+"=";
		sDescripcion+=facturaproveedor.getplazo().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.IDFACTURA+"=";
		sDescripcion+=facturaproveedor.getid_factura().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.NUMEROFACTURA+"=";
		sDescripcion+=facturaproveedor.getnumero_factura()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.IDTRANSACCION+"=";
		sDescripcion+=facturaproveedor.getid_transaccion().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=facturaproveedor.getfecha_emision().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=facturaproveedor.getid_cliente().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.RUC+"=";
		sDescripcion+=facturaproveedor.getruc()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.IDEMPLEADOSOLICITA+"=";
		sDescripcion+=facturaproveedor.getid_empleado_solicita().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.FECHAVENCE+"=";
		sDescripcion+=facturaproveedor.getfecha_vence().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.IDMONEDA+"=";
		sDescripcion+=facturaproveedor.getid_moneda().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=facturaproveedor.getid_empleado().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.CONACTIVOS+"=";
		sDescripcion+=facturaproveedor.getcon_activos().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.CONRISE+"=";
		sDescripcion+=facturaproveedor.getcon_rise().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.CONSITIOS+"=";
		sDescripcion+=facturaproveedor.getcon_sitios().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.DETALLE+"=";
		sDescripcion+=facturaproveedor.getdetalle()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.VALORBIENES12+"=";
		sDescripcion+=facturaproveedor.getvalor_bienes12().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.VALORSERVICIOS12+"=";
		sDescripcion+=facturaproveedor.getvalor_servicios12().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.TOTALVALOR12+"=";
		sDescripcion+=facturaproveedor.gettotal_valor12().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.VALORBIENES0+"=";
		sDescripcion+=facturaproveedor.getvalor_bienes0().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.VALORSERVICIOS0+"=";
		sDescripcion+=facturaproveedor.getvalor_servicios0().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.TOTALVALOR0+"=";
		sDescripcion+=facturaproveedor.gettotal_valor0().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.BIENESICE+"=";
		sDescripcion+=facturaproveedor.getbienes_ice().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.SERVICIOSICE+"=";
		sDescripcion+=facturaproveedor.getservicios_ice().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.TOTALICE+"=";
		sDescripcion+=facturaproveedor.gettotal_ice().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.BIENESIVA+"=";
		sDescripcion+=facturaproveedor.getbienes_iva().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.SERVICIOSIVA+"=";
		sDescripcion+=facturaproveedor.getservicios_iva().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.TOTALIVA+"=";
		sDescripcion+=facturaproveedor.gettotal_iva().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.IVAPORCENTAJE+"=";
		sDescripcion+=facturaproveedor.getiva_porcentaje().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.TOTAL+"=";
		sDescripcion+=facturaproveedor.gettotal().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.CONMONTOOBJETOIVA+"=";
		sDescripcion+=facturaproveedor.getcon_monto_objeto_iva().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.NUMERORETENCION+"=";
		sDescripcion+=facturaproveedor.getnumero_retencion()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.NUMEROSERIE+"=";
		sDescripcion+=facturaproveedor.getnumero_serie()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.NUMEROAUTORIZACION+"=";
		sDescripcion+=facturaproveedor.getnumero_autorizacion()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.FECHAVALIDEZ+"=";
		sDescripcion+=facturaproveedor.getfecha_validez().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.IDTIPORETENCIONFUENTE1+"=";
		sDescripcion+=facturaproveedor.getid_tipo_retencion_fuente1().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.RETFUENTE1PORCENTAJE+"=";
		sDescripcion+=facturaproveedor.getret_fuente1_porcentaje().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.RETFUENTE1BASE+"=";
		sDescripcion+=facturaproveedor.getret_fuente1_base().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.RETFUENTE1RETENIDO+"=";
		sDescripcion+=facturaproveedor.getret_fuente1_retenido().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.IDTIPORETENCIONFUENTE2+"=";
		sDescripcion+=facturaproveedor.getid_tipo_retencion_fuente2().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.RETFUENTE2PORCENTAJE+"=";
		sDescripcion+=facturaproveedor.getret_fuente2_porcentaje().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.RETFUENTE2BASE+"=";
		sDescripcion+=facturaproveedor.getret_fuente2_base().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.RETFUENTE2RETENIDO+"=";
		sDescripcion+=facturaproveedor.getret_fuente2_retenido().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.IDTIPORETENCIONIVA1+"=";
		sDescripcion+=facturaproveedor.getid_tipo_retencion_iva1().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.RETIVABIENPORCENTAJE+"=";
		sDescripcion+=facturaproveedor.getret_iva_bien_porcentaje().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.RETIVABIENBASE+"=";
		sDescripcion+=facturaproveedor.getret_iva_bien_base().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.RETIVABIENRETENIDO+"=";
		sDescripcion+=facturaproveedor.getret_iva_bien_retenido().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.IDTIPORETENCIONIVA2+"=";
		sDescripcion+=facturaproveedor.getid_tipo_retencion_iva2().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.RETIVASERVICIOPORCENTAJE+"=";
		sDescripcion+=facturaproveedor.getret_iva_servicio_porcentaje().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.RETIVASERVICIOBASE+"=";
		sDescripcion+=facturaproveedor.getret_iva_servicio_base().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.RETIVASERVICIORETENIDO+"=";
		sDescripcion+=facturaproveedor.getret_iva_servicio_retenido().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.ANEXONUMEROAUTORIZACION+"=";
		sDescripcion+=facturaproveedor.getanexo_numero_autorizacion()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.ANEXONUMESOSERIE+"=";
		sDescripcion+=facturaproveedor.getanexo_numeso_serie()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.ANEXOFECHAVALIDEZ+"=";
		sDescripcion+=facturaproveedor.getanexo_fecha_validez().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.IDTIPOTRIBUTARIO+"=";
		sDescripcion+=facturaproveedor.getid_tipo_tributario().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.ANEXOFACTURAINICIO+"=";
		sDescripcion+=facturaproveedor.getanexo_factura_inicio()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.ANEXOFACTURAFIN+"=";
		sDescripcion+=facturaproveedor.getanexo_factura_fin()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.IDCUENTACONTABLECREDITOFISCALBIENES+"=";
		sDescripcion+=facturaproveedor.getid_cuenta_contable_credito_fiscal_bienes().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.IDRESPONSABLEFONDO+"=";
		sDescripcion+=facturaproveedor.getid_responsable_fondo().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.IDCUENTACONTABLECREDITOFISCALSERVICIOS+"=";
		sDescripcion+=facturaproveedor.getid_cuenta_contable_credito_fiscal_servicios().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.SECUENCIAL+"=";
		sDescripcion+=facturaproveedor.getsecuencial()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.IDCUENTACONTABLEGASTO+"=";
		sDescripcion+=facturaproveedor.getid_cuenta_contable_gasto().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.GASTOVALOR+"=";
		sDescripcion+=facturaproveedor.getgasto_valor().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.IDCUENTACONTABLEGASTO2+"=";
		sDescripcion+=facturaproveedor.getid_cuenta_contable_gasto2().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.GASTOVALOR2+"=";
		sDescripcion+=facturaproveedor.getgasto_valor2().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.GASTONOMBRE+"=";
		sDescripcion+=facturaproveedor.getgasto_nombre()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.GASTONOMBRE2+"=";
		sDescripcion+=facturaproveedor.getgasto_nombre2()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.IDCUENTACONTABLECREDITOFIN+"=";
		sDescripcion+=facturaproveedor.getid_cuenta_contable_credito_fin().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.IDCUENTACONTABLECREDITOFIN2+"=";
		sDescripcion+=facturaproveedor.getid_cuenta_contable_credito_fin2().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.IDCUENTACONTABLECREDITO+"=";
		sDescripcion+=facturaproveedor.getid_cuenta_contable_credito().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=facturaproveedor.getdescripcion()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.IDTIPOMOVIMIENTO+"=";
		sDescripcion+=facturaproveedor.getid_tipo_movimiento().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.IDTIPOMOVIMIENTOMODULO+"=";
		sDescripcion+=facturaproveedor.getid_tipo_movimiento_modulo().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.IDTIPOTRANSACCIONMODULO+"=";
		sDescripcion+=facturaproveedor.getid_tipo_transaccion_modulo().toString()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.NUMEROMAYOR+"=";
		sDescripcion+=facturaproveedor.getnumero_mayor()+",";
		sDescripcion+=FacturaProveedorConstantesFunciones.CODIGOASIENTO+"=";
		sDescripcion+=facturaproveedor.getcodigo_asiento()+",";
			
		return sDescripcion;
	}
	
	public static void setFacturaProveedorDescripcion(FacturaProveedor facturaproveedor,String sValor) throws Exception {			
		if(facturaproveedor !=null) {
			//facturaproveedorfacturaproveedor.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getSucursalDescripcion(Sucursal sucursal) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(sucursal!=null/*&&sucursal.getId()>0*/) {
			sDescripcion=SucursalConstantesFunciones.getSucursalDescripcion(sucursal);
		}

		return sDescripcion;
	}

	public static String getEjercicioDescripcion(Ejercicio ejercicio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(ejercicio!=null/*&&ejercicio.getId()>0*/) {
			sDescripcion=EjercicioConstantesFunciones.getEjercicioDescripcion(ejercicio);
		}

		return sDescripcion;
	}

	public static String getPeriodoDescripcion(Periodo periodo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(periodo!=null/*&&periodo.getId()>0*/) {
			sDescripcion=PeriodoConstantesFunciones.getPeriodoDescripcion(periodo);
		}

		return sDescripcion;
	}

	public static String getAnioDescripcion(Anio anio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(anio!=null/*&&anio.getId()>0*/) {
			sDescripcion=AnioConstantesFunciones.getAnioDescripcion(anio);
		}

		return sDescripcion;
	}

	public static String getMesDescripcion(Mes mes) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(mes!=null/*&&mes.getId()>0*/) {
			sDescripcion=MesConstantesFunciones.getMesDescripcion(mes);
		}

		return sDescripcion;
	}

	public static String getModuloDescripcion(Modulo modulo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(modulo!=null/*&&modulo.getId()>0*/) {
			sDescripcion=ModuloConstantesFunciones.getModuloDescripcion(modulo);
		}

		return sDescripcion;
	}

	public static String getPlantillaFacturaDescripcion(PlantillaFactura plantillafactura) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(plantillafactura!=null/*&&plantillafactura.getId()>0*/) {
			sDescripcion=PlantillaFacturaConstantesFunciones.getPlantillaFacturaDescripcion(plantillafactura);
		}

		return sDescripcion;
	}

	public static String getTipoDocumentoDescripcion(TipoDocumento tipodocumento) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipodocumento!=null/*&&tipodocumento.getId()>0*/) {
			sDescripcion=TipoDocumentoConstantesFunciones.getTipoDocumentoDescripcion(tipodocumento);
		}

		return sDescripcion;
	}

	public static String getFacturaDescripcion(Factura factura) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(factura!=null/*&&factura.getId()>0*/) {
			sDescripcion=FacturaConstantesFunciones.getFacturaDescripcion(factura);
		}

		return sDescripcion;
	}

	public static String getTransaccionDescripcion(Transaccion transaccion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transaccion!=null/*&&transaccion.getId()>0*/) {
			sDescripcion=TransaccionConstantesFunciones.getTransaccionDescripcion(transaccion);
		}

		return sDescripcion;
	}

	public static String getClienteDescripcion(Cliente cliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cliente!=null/*&&cliente.getId()>0*/) {
			sDescripcion=ClienteConstantesFunciones.getClienteDescripcion(cliente);
		}

		return sDescripcion;
	}

	public static String getEmpleadoSolicitaDescripcion(Empleado empleado) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empleado!=null/*&&empleado.getId()>0*/) {
			sDescripcion=EmpleadoConstantesFunciones.getEmpleadoDescripcion(empleado);
		}

		return sDescripcion;
	}

	public static String getMonedaDescripcion(Moneda moneda) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(moneda!=null/*&&moneda.getId()>0*/) {
			sDescripcion=MonedaConstantesFunciones.getMonedaDescripcion(moneda);
		}

		return sDescripcion;
	}

	public static String getEmpleadoDescripcion(Empleado empleado) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empleado!=null/*&&empleado.getId()>0*/) {
			sDescripcion=EmpleadoConstantesFunciones.getEmpleadoDescripcion(empleado);
		}

		return sDescripcion;
	}

	public static String getTipoRetencionFuente1Descripcion(TipoRetencion tiporetencion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tiporetencion!=null/*&&tiporetencion.getId()>0*/) {
			sDescripcion=TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(tiporetencion);
		}

		return sDescripcion;
	}

	public static String getTipoRetencionFuente2Descripcion(TipoRetencion tiporetencion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tiporetencion!=null/*&&tiporetencion.getId()>0*/) {
			sDescripcion=TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(tiporetencion);
		}

		return sDescripcion;
	}

	public static String getTipoRetencionIva1Descripcion(TipoRetencion tiporetencion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tiporetencion!=null/*&&tiporetencion.getId()>0*/) {
			sDescripcion=TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(tiporetencion);
		}

		return sDescripcion;
	}

	public static String getTipoRetencionIva2Descripcion(TipoRetencion tiporetencion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tiporetencion!=null/*&&tiporetencion.getId()>0*/) {
			sDescripcion=TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(tiporetencion);
		}

		return sDescripcion;
	}

	public static String getTipoTributarioDescripcion(TipoTributario tipotributario) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipotributario!=null/*&&tipotributario.getId()>0*/) {
			sDescripcion=TipoTributarioConstantesFunciones.getTipoTributarioDescripcion(tipotributario);
		}

		return sDescripcion;
	}

	public static String getCuentaContableCreditoFiscalBienesDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getResponsableFondoDescripcion(ResponsableFondo responsablefondo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(responsablefondo!=null/*&&responsablefondo.getId()>0*/) {
			sDescripcion=ResponsableFondoConstantesFunciones.getResponsableFondoDescripcion(responsablefondo);
		}

		return sDescripcion;
	}

	public static String getCuentaContableCreditoFiscalServiciosDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableGastoDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableGasto2Descripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableCreditoFinDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableCreditoFin2Descripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableCreditoDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getTipoMovimientoDescripcion(TipoMovimiento tipomovimiento) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipomovimiento!=null/*&&tipomovimiento.getId()>0*/) {
			sDescripcion=TipoMovimientoConstantesFunciones.getTipoMovimientoDescripcion(tipomovimiento);
		}

		return sDescripcion;
	}

	public static String getTipoMovimientoModuloDescripcion(TipoMovimientoModulo tipomovimientomodulo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipomovimientomodulo!=null/*&&tipomovimientomodulo.getId()>0*/) {
			sDescripcion=TipoMovimientoModuloConstantesFunciones.getTipoMovimientoModuloDescripcion(tipomovimientomodulo);
		}

		return sDescripcion;
	}

	public static String getTipoTransaccionModuloDescripcion(TipoTransaccionModulo tipotransaccionmodulo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipotransaccionmodulo!=null/*&&tipotransaccionmodulo.getId()>0*/) {
			sDescripcion=TipoTransaccionModuloConstantesFunciones.getTipoTransaccionModuloDescripcion(tipotransaccionmodulo);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdAnio")) {
			sNombreIndice="Tipo=  Por Anio";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Proveedor";
		} else if(sNombreIndice.equals("FK_IdCuentaContableCredito")) {
			sNombreIndice="Tipo=  Por Cuenta Contable Credito";
		} else if(sNombreIndice.equals("FK_IdCuentaContableCreditoFin")) {
			sNombreIndice="Tipo=  Por Cuenta Contable Credito Fin";
		} else if(sNombreIndice.equals("FK_IdCuentaContableCreditoFin2")) {
			sNombreIndice="Tipo=  Por Cuenta Contable Credito Fin 2";
		} else if(sNombreIndice.equals("FK_IdCuentaContableCreditoFiscalBienes")) {
			sNombreIndice="Tipo=  Por Credito Fiscal Bienes";
		} else if(sNombreIndice.equals("FK_IdCuentaContableCreditoFiscalServicios")) {
			sNombreIndice="Tipo=  Por Credito Fiscal Servicios";
		} else if(sNombreIndice.equals("FK_IdCuentaContableGasto")) {
			sNombreIndice="Tipo=  Por C. Gasto";
		} else if(sNombreIndice.equals("FK_IdCuentaContableGasto2")) {
			sNombreIndice="Tipo=  Por C. Gasto 2";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpleado")) {
			sNombreIndice="Tipo=  Por Empl.Autoriza";
		} else if(sNombreIndice.equals("FK_IdEmpleadoSolicita")) {
			sNombreIndice="Tipo=  Por Empl.Solicita";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdFactura")) {
			sNombreIndice="Tipo=  Por Factura";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		} else if(sNombreIndice.equals("FK_IdModulo")) {
			sNombreIndice="Tipo=  Por Modulo";
		} else if(sNombreIndice.equals("FK_IdMoneda")) {
			sNombreIndice="Tipo=  Por Moneda";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdPlantillaFactura")) {
			sNombreIndice="Tipo=  Por Plantilla Factura";
		} else if(sNombreIndice.equals("FK_IdResponsableFondo")) {
			sNombreIndice="Tipo=  Por Responsable";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoDocumento")) {
			sNombreIndice="Tipo=  Por T. Documento";
		} else if(sNombreIndice.equals("FK_IdTipoMovimiento")) {
			sNombreIndice="Tipo=  Por Tipo Movimiento";
		} else if(sNombreIndice.equals("FK_IdTipoMovimientoModulo")) {
			sNombreIndice="Tipo=  Por Tipo Movimiento Modulo";
		} else if(sNombreIndice.equals("FK_IdTipoRetencionFuente1")) {
			sNombreIndice="Tipo=  Por Ret. Fuente 1";
		} else if(sNombreIndice.equals("FK_IdTipoRetencionFuente2")) {
			sNombreIndice="Tipo=  Por Ret Fuente 2";
		} else if(sNombreIndice.equals("FK_IdTipoRetencionIva1")) {
			sNombreIndice="Tipo=  Por Ret Iva B.";
		} else if(sNombreIndice.equals("FK_IdTipoRetencionIva2")) {
			sNombreIndice="Tipo=  Por Ret Iva S.";
		} else if(sNombreIndice.equals("FK_IdTipoTransaccionModulo")) {
			sNombreIndice="Tipo=  Por Tipo Comprobante";
		} else if(sNombreIndice.equals("FK_IdTipoTributario")) {
			sNombreIndice="Tipo=  Por Sustento Trib.";
		} else if(sNombreIndice.equals("FK_IdTransaccion")) {
			sNombreIndice="Tipo=  Por T.Comprobante";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdAnio(Long id_anio) {
		String sDetalleIndice=" Parametros->";
		if(id_anio!=null) {sDetalleIndice+=" Codigo Unico De Anio="+id_anio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCliente(Long id_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_cliente!=null) {sDetalleIndice+=" Codigo Unico De Proveedor="+id_cliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableCredito(Long id_cuenta_contable_credito) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_credito!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Contable Credito="+id_cuenta_contable_credito.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableCreditoFin(Long id_cuenta_contable_credito_fin) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_credito_fin!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Contable Credito Fin="+id_cuenta_contable_credito_fin.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableCreditoFin2(Long id_cuenta_contable_credito_fin2) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_credito_fin2!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Contable Credito Fin 2="+id_cuenta_contable_credito_fin2.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableCreditoFiscalBienes(Long id_cuenta_contable_credito_fiscal_bienes) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_credito_fiscal_bienes!=null) {sDetalleIndice+=" Codigo Unico De Credito Fiscal Bienes="+id_cuenta_contable_credito_fiscal_bienes.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableCreditoFiscalServicios(Long id_cuenta_contable_credito_fiscal_servicios) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_credito_fiscal_servicios!=null) {sDetalleIndice+=" Codigo Unico De Credito Fiscal Servicios="+id_cuenta_contable_credito_fiscal_servicios.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableGasto(Long id_cuenta_contable_gasto) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_gasto!=null) {sDetalleIndice+=" Codigo Unico De C. Gasto="+id_cuenta_contable_gasto.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableGasto2(Long id_cuenta_contable_gasto2) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_gasto2!=null) {sDetalleIndice+=" Codigo Unico De C. Gasto 2="+id_cuenta_contable_gasto2.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEjercicio(Long id_ejercicio) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpleado(Long id_empleado) {
		String sDetalleIndice=" Parametros->";
		if(id_empleado!=null) {sDetalleIndice+=" Codigo Unico De Empl.Autoriza="+id_empleado.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpleadoSolicita(Long id_empleado_solicita) {
		String sDetalleIndice=" Parametros->";
		if(id_empleado_solicita!=null) {sDetalleIndice+=" Codigo Unico De Empl.Solicita="+id_empleado_solicita.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdFactura(Long id_factura) {
		String sDetalleIndice=" Parametros->";
		if(id_factura!=null) {sDetalleIndice+=" Codigo Unico De Factura="+id_factura.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMes(Long id_mes) {
		String sDetalleIndice=" Parametros->";
		if(id_mes!=null) {sDetalleIndice+=" Codigo Unico De Mes="+id_mes.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdModulo(Long id_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id_modulo!=null) {sDetalleIndice+=" Codigo Unico De Modulo="+id_modulo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMoneda(Long id_moneda) {
		String sDetalleIndice=" Parametros->";
		if(id_moneda!=null) {sDetalleIndice+=" Codigo Unico De Moneda="+id_moneda.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPeriodo(Long id_periodo) {
		String sDetalleIndice=" Parametros->";
		if(id_periodo!=null) {sDetalleIndice+=" Codigo Unico De Periodo="+id_periodo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPlantillaFactura(Long id_plantilla_factura) {
		String sDetalleIndice=" Parametros->";
		if(id_plantilla_factura!=null) {sDetalleIndice+=" Codigo Unico De Plantilla Factura="+id_plantilla_factura.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdResponsableFondo(Long id_responsable_fondo) {
		String sDetalleIndice=" Parametros->";
		if(id_responsable_fondo!=null) {sDetalleIndice+=" Codigo Unico De Responsable="+id_responsable_fondo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoDocumento(Long id_tipo_documento) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_documento!=null) {sDetalleIndice+=" Codigo Unico De T. Documento="+id_tipo_documento.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoMovimiento(Long id_tipo_movimiento) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_movimiento!=null) {sDetalleIndice+=" Codigo Unico De Tipo Movimiento="+id_tipo_movimiento.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoMovimientoModulo(Long id_tipo_movimiento_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_movimiento_modulo!=null) {sDetalleIndice+=" Codigo Unico De Tipo Movimiento Modulo="+id_tipo_movimiento_modulo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoRetencionFuente1(Long id_tipo_retencion_fuente1) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_retencion_fuente1!=null) {sDetalleIndice+=" Codigo Unico De Ret. Fuente 1="+id_tipo_retencion_fuente1.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoRetencionFuente2(Long id_tipo_retencion_fuente2) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_retencion_fuente2!=null) {sDetalleIndice+=" Codigo Unico De Ret Fuente 2="+id_tipo_retencion_fuente2.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoRetencionIva1(Long id_tipo_retencion_iva1) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_retencion_iva1!=null) {sDetalleIndice+=" Codigo Unico De Ret Iva B.="+id_tipo_retencion_iva1.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoRetencionIva2(Long id_tipo_retencion_iva2) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_retencion_iva2!=null) {sDetalleIndice+=" Codigo Unico De Ret Iva S.="+id_tipo_retencion_iva2.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoTransaccionModulo(Long id_tipo_transaccion_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_transaccion_modulo!=null) {sDetalleIndice+=" Codigo Unico De Tipo Comprobante="+id_tipo_transaccion_modulo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoTributario(Long id_tipo_tributario) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_tributario!=null) {sDetalleIndice+=" Codigo Unico De Sustento Trib.="+id_tipo_tributario.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransaccion(Long id_transaccion) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion!=null) {sDetalleIndice+=" Codigo Unico De T.Comprobante="+id_transaccion.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosFacturaProveedor(FacturaProveedor facturaproveedor,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		facturaproveedor.setnumero_factura(facturaproveedor.getnumero_factura().trim());
		facturaproveedor.setruc(facturaproveedor.getruc().trim());
		facturaproveedor.setdetalle(facturaproveedor.getdetalle().trim());
		facturaproveedor.setnumero_retencion(facturaproveedor.getnumero_retencion().trim());
		facturaproveedor.setnumero_serie(facturaproveedor.getnumero_serie().trim());
		facturaproveedor.setnumero_autorizacion(facturaproveedor.getnumero_autorizacion().trim());
		facturaproveedor.setanexo_numero_autorizacion(facturaproveedor.getanexo_numero_autorizacion().trim());
		facturaproveedor.setanexo_numeso_serie(facturaproveedor.getanexo_numeso_serie().trim());
		facturaproveedor.setanexo_factura_inicio(facturaproveedor.getanexo_factura_inicio().trim());
		facturaproveedor.setanexo_factura_fin(facturaproveedor.getanexo_factura_fin().trim());
		facturaproveedor.setsecuencial(facturaproveedor.getsecuencial().trim());
		facturaproveedor.setgasto_nombre(facturaproveedor.getgasto_nombre().trim());
		facturaproveedor.setgasto_nombre2(facturaproveedor.getgasto_nombre2().trim());
		facturaproveedor.setdescripcion(facturaproveedor.getdescripcion().trim());
		facturaproveedor.setnumero_mayor(facturaproveedor.getnumero_mayor().trim());
		facturaproveedor.setcodigo_asiento(facturaproveedor.getcodigo_asiento().trim());
	}
	
	public static void quitarEspaciosFacturaProveedors(List<FacturaProveedor> facturaproveedors,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(FacturaProveedor facturaproveedor: facturaproveedors) {
			facturaproveedor.setnumero_factura(facturaproveedor.getnumero_factura().trim());
			facturaproveedor.setruc(facturaproveedor.getruc().trim());
			facturaproveedor.setdetalle(facturaproveedor.getdetalle().trim());
			facturaproveedor.setnumero_retencion(facturaproveedor.getnumero_retencion().trim());
			facturaproveedor.setnumero_serie(facturaproveedor.getnumero_serie().trim());
			facturaproveedor.setnumero_autorizacion(facturaproveedor.getnumero_autorizacion().trim());
			facturaproveedor.setanexo_numero_autorizacion(facturaproveedor.getanexo_numero_autorizacion().trim());
			facturaproveedor.setanexo_numeso_serie(facturaproveedor.getanexo_numeso_serie().trim());
			facturaproveedor.setanexo_factura_inicio(facturaproveedor.getanexo_factura_inicio().trim());
			facturaproveedor.setanexo_factura_fin(facturaproveedor.getanexo_factura_fin().trim());
			facturaproveedor.setsecuencial(facturaproveedor.getsecuencial().trim());
			facturaproveedor.setgasto_nombre(facturaproveedor.getgasto_nombre().trim());
			facturaproveedor.setgasto_nombre2(facturaproveedor.getgasto_nombre2().trim());
			facturaproveedor.setdescripcion(facturaproveedor.getdescripcion().trim());
			facturaproveedor.setnumero_mayor(facturaproveedor.getnumero_mayor().trim());
			facturaproveedor.setcodigo_asiento(facturaproveedor.getcodigo_asiento().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresFacturaProveedor(FacturaProveedor facturaproveedor,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && facturaproveedor.getConCambioAuxiliar()) {
			facturaproveedor.setIsDeleted(facturaproveedor.getIsDeletedAuxiliar());	
			facturaproveedor.setIsNew(facturaproveedor.getIsNewAuxiliar());	
			facturaproveedor.setIsChanged(facturaproveedor.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			facturaproveedor.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			facturaproveedor.setIsDeletedAuxiliar(false);	
			facturaproveedor.setIsNewAuxiliar(false);	
			facturaproveedor.setIsChangedAuxiliar(false);
			
			facturaproveedor.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresFacturaProveedors(List<FacturaProveedor> facturaproveedors,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(FacturaProveedor facturaproveedor : facturaproveedors) {
			if(conAsignarBase && facturaproveedor.getConCambioAuxiliar()) {
				facturaproveedor.setIsDeleted(facturaproveedor.getIsDeletedAuxiliar());	
				facturaproveedor.setIsNew(facturaproveedor.getIsNewAuxiliar());	
				facturaproveedor.setIsChanged(facturaproveedor.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				facturaproveedor.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				facturaproveedor.setIsDeletedAuxiliar(false);	
				facturaproveedor.setIsNewAuxiliar(false);	
				facturaproveedor.setIsChangedAuxiliar(false);
				
				facturaproveedor.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresFacturaProveedor(FacturaProveedor facturaproveedor,Boolean conEnteros) throws Exception  {
		facturaproveedor.setvalor_bienes12(0.0);
		facturaproveedor.setvalor_servicios12(0.0);
		facturaproveedor.settotal_valor12(0.0);
		facturaproveedor.setvalor_bienes0(0.0);
		facturaproveedor.setvalor_servicios0(0.0);
		facturaproveedor.settotal_valor0(0.0);
		facturaproveedor.setbienes_ice(0.0);
		facturaproveedor.setservicios_ice(0.0);
		facturaproveedor.settotal_ice(0.0);
		facturaproveedor.setbienes_iva(0.0);
		facturaproveedor.setservicios_iva(0.0);
		facturaproveedor.settotal_iva(0.0);
		facturaproveedor.setiva_porcentaje(0.0);
		facturaproveedor.settotal(0.0);
		facturaproveedor.setret_fuente1_porcentaje(0.0);
		facturaproveedor.setret_fuente1_base(0.0);
		facturaproveedor.setret_fuente1_retenido(0.0);
		facturaproveedor.setret_fuente2_porcentaje(0.0);
		facturaproveedor.setret_fuente2_base(0.0);
		facturaproveedor.setret_fuente2_retenido(0.0);
		facturaproveedor.setret_iva_bien_porcentaje(0.0);
		facturaproveedor.setret_iva_bien_base(0.0);
		facturaproveedor.setret_iva_bien_retenido(0.0);
		facturaproveedor.setret_iva_servicio_porcentaje(0.0);
		facturaproveedor.setret_iva_servicio_base(0.0);
		facturaproveedor.setret_iva_servicio_retenido(0.0);
		facturaproveedor.setgasto_valor(0.0);
		facturaproveedor.setgasto_valor2(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			facturaproveedor.setplazo(0);
		}
	}		
	
	public static void InicializarValoresFacturaProveedors(List<FacturaProveedor> facturaproveedors,Boolean conEnteros) throws Exception  {
		
		for(FacturaProveedor facturaproveedor: facturaproveedors) {
			facturaproveedor.setvalor_bienes12(0.0);
			facturaproveedor.setvalor_servicios12(0.0);
			facturaproveedor.settotal_valor12(0.0);
			facturaproveedor.setvalor_bienes0(0.0);
			facturaproveedor.setvalor_servicios0(0.0);
			facturaproveedor.settotal_valor0(0.0);
			facturaproveedor.setbienes_ice(0.0);
			facturaproveedor.setservicios_ice(0.0);
			facturaproveedor.settotal_ice(0.0);
			facturaproveedor.setbienes_iva(0.0);
			facturaproveedor.setservicios_iva(0.0);
			facturaproveedor.settotal_iva(0.0);
			facturaproveedor.setiva_porcentaje(0.0);
			facturaproveedor.settotal(0.0);
			facturaproveedor.setret_fuente1_porcentaje(0.0);
			facturaproveedor.setret_fuente1_base(0.0);
			facturaproveedor.setret_fuente1_retenido(0.0);
			facturaproveedor.setret_fuente2_porcentaje(0.0);
			facturaproveedor.setret_fuente2_base(0.0);
			facturaproveedor.setret_fuente2_retenido(0.0);
			facturaproveedor.setret_iva_bien_porcentaje(0.0);
			facturaproveedor.setret_iva_bien_base(0.0);
			facturaproveedor.setret_iva_bien_retenido(0.0);
			facturaproveedor.setret_iva_servicio_porcentaje(0.0);
			facturaproveedor.setret_iva_servicio_base(0.0);
			facturaproveedor.setret_iva_servicio_retenido(0.0);
			facturaproveedor.setgasto_valor(0.0);
			facturaproveedor.setgasto_valor2(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				facturaproveedor.setplazo(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaFacturaProveedor(List<FacturaProveedor> facturaproveedors,FacturaProveedor facturaproveedorAux) throws Exception  {
		FacturaProveedorConstantesFunciones.InicializarValoresFacturaProveedor(facturaproveedorAux,true);
		
		for(FacturaProveedor facturaproveedor: facturaproveedors) {
			if(facturaproveedor.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			facturaproveedorAux.setplazo(facturaproveedorAux.getplazo()+facturaproveedor.getplazo());			
			facturaproveedorAux.setvalor_bienes12(facturaproveedorAux.getvalor_bienes12()+facturaproveedor.getvalor_bienes12());			
			facturaproveedorAux.setvalor_servicios12(facturaproveedorAux.getvalor_servicios12()+facturaproveedor.getvalor_servicios12());			
			facturaproveedorAux.settotal_valor12(facturaproveedorAux.gettotal_valor12()+facturaproveedor.gettotal_valor12());			
			facturaproveedorAux.setvalor_bienes0(facturaproveedorAux.getvalor_bienes0()+facturaproveedor.getvalor_bienes0());			
			facturaproveedorAux.setvalor_servicios0(facturaproveedorAux.getvalor_servicios0()+facturaproveedor.getvalor_servicios0());			
			facturaproveedorAux.settotal_valor0(facturaproveedorAux.gettotal_valor0()+facturaproveedor.gettotal_valor0());			
			facturaproveedorAux.setbienes_ice(facturaproveedorAux.getbienes_ice()+facturaproveedor.getbienes_ice());			
			facturaproveedorAux.setservicios_ice(facturaproveedorAux.getservicios_ice()+facturaproveedor.getservicios_ice());			
			facturaproveedorAux.settotal_ice(facturaproveedorAux.gettotal_ice()+facturaproveedor.gettotal_ice());			
			facturaproveedorAux.setbienes_iva(facturaproveedorAux.getbienes_iva()+facturaproveedor.getbienes_iva());			
			facturaproveedorAux.setservicios_iva(facturaproveedorAux.getservicios_iva()+facturaproveedor.getservicios_iva());			
			facturaproveedorAux.settotal_iva(facturaproveedorAux.gettotal_iva()+facturaproveedor.gettotal_iva());			
			facturaproveedorAux.setiva_porcentaje(facturaproveedorAux.getiva_porcentaje()+facturaproveedor.getiva_porcentaje());			
			facturaproveedorAux.settotal(facturaproveedorAux.gettotal()+facturaproveedor.gettotal());			
			facturaproveedorAux.setret_fuente1_porcentaje(facturaproveedorAux.getret_fuente1_porcentaje()+facturaproveedor.getret_fuente1_porcentaje());			
			facturaproveedorAux.setret_fuente1_base(facturaproveedorAux.getret_fuente1_base()+facturaproveedor.getret_fuente1_base());			
			facturaproveedorAux.setret_fuente1_retenido(facturaproveedorAux.getret_fuente1_retenido()+facturaproveedor.getret_fuente1_retenido());			
			facturaproveedorAux.setret_fuente2_porcentaje(facturaproveedorAux.getret_fuente2_porcentaje()+facturaproveedor.getret_fuente2_porcentaje());			
			facturaproveedorAux.setret_fuente2_base(facturaproveedorAux.getret_fuente2_base()+facturaproveedor.getret_fuente2_base());			
			facturaproveedorAux.setret_fuente2_retenido(facturaproveedorAux.getret_fuente2_retenido()+facturaproveedor.getret_fuente2_retenido());			
			facturaproveedorAux.setret_iva_bien_porcentaje(facturaproveedorAux.getret_iva_bien_porcentaje()+facturaproveedor.getret_iva_bien_porcentaje());			
			facturaproveedorAux.setret_iva_bien_base(facturaproveedorAux.getret_iva_bien_base()+facturaproveedor.getret_iva_bien_base());			
			facturaproveedorAux.setret_iva_bien_retenido(facturaproveedorAux.getret_iva_bien_retenido()+facturaproveedor.getret_iva_bien_retenido());			
			facturaproveedorAux.setret_iva_servicio_porcentaje(facturaproveedorAux.getret_iva_servicio_porcentaje()+facturaproveedor.getret_iva_servicio_porcentaje());			
			facturaproveedorAux.setret_iva_servicio_base(facturaproveedorAux.getret_iva_servicio_base()+facturaproveedor.getret_iva_servicio_base());			
			facturaproveedorAux.setret_iva_servicio_retenido(facturaproveedorAux.getret_iva_servicio_retenido()+facturaproveedor.getret_iva_servicio_retenido());			
			facturaproveedorAux.setgasto_valor(facturaproveedorAux.getgasto_valor()+facturaproveedor.getgasto_valor());			
			facturaproveedorAux.setgasto_valor2(facturaproveedorAux.getgasto_valor2()+facturaproveedor.getgasto_valor2());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesFacturaProveedor(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=FacturaProveedorConstantesFunciones.getArrayColumnasGlobalesFacturaProveedor(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesFacturaProveedor(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FacturaProveedorConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FacturaProveedorConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FacturaProveedorConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FacturaProveedorConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FacturaProveedorConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FacturaProveedorConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FacturaProveedorConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FacturaProveedorConstantesFunciones.IDPERIODO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FacturaProveedorConstantesFunciones.IDMODULO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FacturaProveedorConstantesFunciones.IDMODULO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FacturaProveedorConstantesFunciones.IDMONEDA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FacturaProveedorConstantesFunciones.IDMONEDA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoFacturaProveedor(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<FacturaProveedor> facturaproveedors,FacturaProveedor facturaproveedor,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(FacturaProveedor facturaproveedorAux: facturaproveedors) {
			if(facturaproveedorAux!=null && facturaproveedor!=null) {
				if((facturaproveedorAux.getId()==null && facturaproveedor.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(facturaproveedorAux.getId()!=null && facturaproveedor.getId()!=null){
					if(facturaproveedorAux.getId().equals(facturaproveedor.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaFacturaProveedor(List<FacturaProveedor> facturaproveedors) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valor_bienes12Total=0.0;
		Double valor_servicios12Total=0.0;
		Double total_valor12Total=0.0;
		Double valor_bienes0Total=0.0;
		Double valor_servicios0Total=0.0;
		Double total_valor0Total=0.0;
		Double bienes_iceTotal=0.0;
		Double servicios_iceTotal=0.0;
		Double total_iceTotal=0.0;
		Double bienes_ivaTotal=0.0;
		Double servicios_ivaTotal=0.0;
		Double total_ivaTotal=0.0;
		Double iva_porcentajeTotal=0.0;
		Double totalTotal=0.0;
		Double ret_fuente1_porcentajeTotal=0.0;
		Double ret_fuente1_baseTotal=0.0;
		Double ret_fuente1_retenidoTotal=0.0;
		Double ret_fuente2_porcentajeTotal=0.0;
		Double ret_fuente2_baseTotal=0.0;
		Double ret_fuente2_retenidoTotal=0.0;
		Double ret_iva_bien_porcentajeTotal=0.0;
		Double ret_iva_bien_baseTotal=0.0;
		Double ret_iva_bien_retenidoTotal=0.0;
		Double ret_iva_servicio_porcentajeTotal=0.0;
		Double ret_iva_servicio_baseTotal=0.0;
		Double ret_iva_servicio_retenidoTotal=0.0;
		Double gasto_valorTotal=0.0;
		Double gasto_valor2Total=0.0;
	
		for(FacturaProveedor facturaproveedor: facturaproveedors) {			
			if(facturaproveedor.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valor_bienes12Total+=facturaproveedor.getvalor_bienes12();
			valor_servicios12Total+=facturaproveedor.getvalor_servicios12();
			total_valor12Total+=facturaproveedor.gettotal_valor12();
			valor_bienes0Total+=facturaproveedor.getvalor_bienes0();
			valor_servicios0Total+=facturaproveedor.getvalor_servicios0();
			total_valor0Total+=facturaproveedor.gettotal_valor0();
			bienes_iceTotal+=facturaproveedor.getbienes_ice();
			servicios_iceTotal+=facturaproveedor.getservicios_ice();
			total_iceTotal+=facturaproveedor.gettotal_ice();
			bienes_ivaTotal+=facturaproveedor.getbienes_iva();
			servicios_ivaTotal+=facturaproveedor.getservicios_iva();
			total_ivaTotal+=facturaproveedor.gettotal_iva();
			iva_porcentajeTotal+=facturaproveedor.getiva_porcentaje();
			totalTotal+=facturaproveedor.gettotal();
			ret_fuente1_porcentajeTotal+=facturaproveedor.getret_fuente1_porcentaje();
			ret_fuente1_baseTotal+=facturaproveedor.getret_fuente1_base();
			ret_fuente1_retenidoTotal+=facturaproveedor.getret_fuente1_retenido();
			ret_fuente2_porcentajeTotal+=facturaproveedor.getret_fuente2_porcentaje();
			ret_fuente2_baseTotal+=facturaproveedor.getret_fuente2_base();
			ret_fuente2_retenidoTotal+=facturaproveedor.getret_fuente2_retenido();
			ret_iva_bien_porcentajeTotal+=facturaproveedor.getret_iva_bien_porcentaje();
			ret_iva_bien_baseTotal+=facturaproveedor.getret_iva_bien_base();
			ret_iva_bien_retenidoTotal+=facturaproveedor.getret_iva_bien_retenido();
			ret_iva_servicio_porcentajeTotal+=facturaproveedor.getret_iva_servicio_porcentaje();
			ret_iva_servicio_baseTotal+=facturaproveedor.getret_iva_servicio_base();
			ret_iva_servicio_retenidoTotal+=facturaproveedor.getret_iva_servicio_retenido();
			gasto_valorTotal+=facturaproveedor.getgasto_valor();
			gasto_valor2Total+=facturaproveedor.getgasto_valor2();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaProveedorConstantesFunciones.VALORBIENES12);
		datoGeneral.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_VALORBIENES12);
		datoGeneral.setdValorDouble(valor_bienes12Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaProveedorConstantesFunciones.VALORSERVICIOS12);
		datoGeneral.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_VALORSERVICIOS12);
		datoGeneral.setdValorDouble(valor_servicios12Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaProveedorConstantesFunciones.TOTALVALOR12);
		datoGeneral.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_TOTALVALOR12);
		datoGeneral.setdValorDouble(total_valor12Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaProveedorConstantesFunciones.VALORBIENES0);
		datoGeneral.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_VALORBIENES0);
		datoGeneral.setdValorDouble(valor_bienes0Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaProveedorConstantesFunciones.VALORSERVICIOS0);
		datoGeneral.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_VALORSERVICIOS0);
		datoGeneral.setdValorDouble(valor_servicios0Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaProveedorConstantesFunciones.TOTALVALOR0);
		datoGeneral.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_TOTALVALOR0);
		datoGeneral.setdValorDouble(total_valor0Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaProveedorConstantesFunciones.BIENESICE);
		datoGeneral.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_BIENESICE);
		datoGeneral.setdValorDouble(bienes_iceTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaProveedorConstantesFunciones.SERVICIOSICE);
		datoGeneral.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_SERVICIOSICE);
		datoGeneral.setdValorDouble(servicios_iceTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaProveedorConstantesFunciones.TOTALICE);
		datoGeneral.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_TOTALICE);
		datoGeneral.setdValorDouble(total_iceTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaProveedorConstantesFunciones.BIENESIVA);
		datoGeneral.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_BIENESIVA);
		datoGeneral.setdValorDouble(bienes_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaProveedorConstantesFunciones.SERVICIOSIVA);
		datoGeneral.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_SERVICIOSIVA);
		datoGeneral.setdValorDouble(servicios_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaProveedorConstantesFunciones.TOTALIVA);
		datoGeneral.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_TOTALIVA);
		datoGeneral.setdValorDouble(total_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaProveedorConstantesFunciones.IVAPORCENTAJE);
		datoGeneral.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_IVAPORCENTAJE);
		datoGeneral.setdValorDouble(iva_porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaProveedorConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaProveedorConstantesFunciones.RETFUENTE1PORCENTAJE);
		datoGeneral.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_RETFUENTE1PORCENTAJE);
		datoGeneral.setdValorDouble(ret_fuente1_porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaProveedorConstantesFunciones.RETFUENTE1BASE);
		datoGeneral.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_RETFUENTE1BASE);
		datoGeneral.setdValorDouble(ret_fuente1_baseTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaProveedorConstantesFunciones.RETFUENTE1RETENIDO);
		datoGeneral.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_RETFUENTE1RETENIDO);
		datoGeneral.setdValorDouble(ret_fuente1_retenidoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaProveedorConstantesFunciones.RETFUENTE2PORCENTAJE);
		datoGeneral.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_RETFUENTE2PORCENTAJE);
		datoGeneral.setdValorDouble(ret_fuente2_porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaProveedorConstantesFunciones.RETFUENTE2BASE);
		datoGeneral.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_RETFUENTE2BASE);
		datoGeneral.setdValorDouble(ret_fuente2_baseTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaProveedorConstantesFunciones.RETFUENTE2RETENIDO);
		datoGeneral.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_RETFUENTE2RETENIDO);
		datoGeneral.setdValorDouble(ret_fuente2_retenidoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaProveedorConstantesFunciones.RETIVABIENPORCENTAJE);
		datoGeneral.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_RETIVABIENPORCENTAJE);
		datoGeneral.setdValorDouble(ret_iva_bien_porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaProveedorConstantesFunciones.RETIVABIENBASE);
		datoGeneral.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_RETIVABIENBASE);
		datoGeneral.setdValorDouble(ret_iva_bien_baseTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaProveedorConstantesFunciones.RETIVABIENRETENIDO);
		datoGeneral.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_RETIVABIENRETENIDO);
		datoGeneral.setdValorDouble(ret_iva_bien_retenidoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaProveedorConstantesFunciones.RETIVASERVICIOPORCENTAJE);
		datoGeneral.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_RETIVASERVICIOPORCENTAJE);
		datoGeneral.setdValorDouble(ret_iva_servicio_porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaProveedorConstantesFunciones.RETIVASERVICIOBASE);
		datoGeneral.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_RETIVASERVICIOBASE);
		datoGeneral.setdValorDouble(ret_iva_servicio_baseTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaProveedorConstantesFunciones.RETIVASERVICIORETENIDO);
		datoGeneral.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_RETIVASERVICIORETENIDO);
		datoGeneral.setdValorDouble(ret_iva_servicio_retenidoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaProveedorConstantesFunciones.GASTOVALOR);
		datoGeneral.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_GASTOVALOR);
		datoGeneral.setdValorDouble(gasto_valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaProveedorConstantesFunciones.GASTOVALOR2);
		datoGeneral.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_GASTOVALOR2);
		datoGeneral.setdValorDouble(gasto_valor2Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaFacturaProveedor() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_ID, FacturaProveedorConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_VERSIONROW, FacturaProveedorConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_IDEMPRESA, FacturaProveedorConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_IDSUCURSAL, FacturaProveedorConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_IDEJERCICIO, FacturaProveedorConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_IDPERIODO, FacturaProveedorConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_IDANIO, FacturaProveedorConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_IDMES, FacturaProveedorConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_IDMODULO, FacturaProveedorConstantesFunciones.IDMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_IDPLANTILLAFACTURA, FacturaProveedorConstantesFunciones.IDPLANTILLAFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_IDTIPODOCUMENTO, FacturaProveedorConstantesFunciones.IDTIPODOCUMENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_PLAZO, FacturaProveedorConstantesFunciones.PLAZO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_IDFACTURA, FacturaProveedorConstantesFunciones.IDFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_NUMEROFACTURA, FacturaProveedorConstantesFunciones.NUMEROFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_IDTRANSACCION, FacturaProveedorConstantesFunciones.IDTRANSACCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_FECHAEMISION, FacturaProveedorConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_IDCLIENTE, FacturaProveedorConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_RUC, FacturaProveedorConstantesFunciones.RUC,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_IDEMPLEADOSOLICITA, FacturaProveedorConstantesFunciones.IDEMPLEADOSOLICITA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_FECHAVENCE, FacturaProveedorConstantesFunciones.FECHAVENCE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_IDMONEDA, FacturaProveedorConstantesFunciones.IDMONEDA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_IDEMPLEADO, FacturaProveedorConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_CONACTIVOS, FacturaProveedorConstantesFunciones.CONACTIVOS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_CONRISE, FacturaProveedorConstantesFunciones.CONRISE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_CONSITIOS, FacturaProveedorConstantesFunciones.CONSITIOS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_DETALLE, FacturaProveedorConstantesFunciones.DETALLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_VALORBIENES12, FacturaProveedorConstantesFunciones.VALORBIENES12,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_VALORSERVICIOS12, FacturaProveedorConstantesFunciones.VALORSERVICIOS12,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_TOTALVALOR12, FacturaProveedorConstantesFunciones.TOTALVALOR12,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_VALORBIENES0, FacturaProveedorConstantesFunciones.VALORBIENES0,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_VALORSERVICIOS0, FacturaProveedorConstantesFunciones.VALORSERVICIOS0,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_TOTALVALOR0, FacturaProveedorConstantesFunciones.TOTALVALOR0,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_BIENESICE, FacturaProveedorConstantesFunciones.BIENESICE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_SERVICIOSICE, FacturaProveedorConstantesFunciones.SERVICIOSICE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_TOTALICE, FacturaProveedorConstantesFunciones.TOTALICE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_BIENESIVA, FacturaProveedorConstantesFunciones.BIENESIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_SERVICIOSIVA, FacturaProveedorConstantesFunciones.SERVICIOSIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_TOTALIVA, FacturaProveedorConstantesFunciones.TOTALIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_IVAPORCENTAJE, FacturaProveedorConstantesFunciones.IVAPORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_TOTAL, FacturaProveedorConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_CONMONTOOBJETOIVA, FacturaProveedorConstantesFunciones.CONMONTOOBJETOIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_NUMERORETENCION, FacturaProveedorConstantesFunciones.NUMERORETENCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_NUMEROSERIE, FacturaProveedorConstantesFunciones.NUMEROSERIE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_NUMEROAUTORIZACION, FacturaProveedorConstantesFunciones.NUMEROAUTORIZACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_FECHAVALIDEZ, FacturaProveedorConstantesFunciones.FECHAVALIDEZ,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_IDTIPORETENCIONFUENTE1, FacturaProveedorConstantesFunciones.IDTIPORETENCIONFUENTE1,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_RETFUENTE1PORCENTAJE, FacturaProveedorConstantesFunciones.RETFUENTE1PORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_RETFUENTE1BASE, FacturaProveedorConstantesFunciones.RETFUENTE1BASE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_RETFUENTE1RETENIDO, FacturaProveedorConstantesFunciones.RETFUENTE1RETENIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_IDTIPORETENCIONFUENTE2, FacturaProveedorConstantesFunciones.IDTIPORETENCIONFUENTE2,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_RETFUENTE2PORCENTAJE, FacturaProveedorConstantesFunciones.RETFUENTE2PORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_RETFUENTE2BASE, FacturaProveedorConstantesFunciones.RETFUENTE2BASE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_RETFUENTE2RETENIDO, FacturaProveedorConstantesFunciones.RETFUENTE2RETENIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_IDTIPORETENCIONIVA1, FacturaProveedorConstantesFunciones.IDTIPORETENCIONIVA1,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_RETIVABIENPORCENTAJE, FacturaProveedorConstantesFunciones.RETIVABIENPORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_RETIVABIENBASE, FacturaProveedorConstantesFunciones.RETIVABIENBASE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_RETIVABIENRETENIDO, FacturaProveedorConstantesFunciones.RETIVABIENRETENIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_IDTIPORETENCIONIVA2, FacturaProveedorConstantesFunciones.IDTIPORETENCIONIVA2,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_RETIVASERVICIOPORCENTAJE, FacturaProveedorConstantesFunciones.RETIVASERVICIOPORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_RETIVASERVICIOBASE, FacturaProveedorConstantesFunciones.RETIVASERVICIOBASE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_RETIVASERVICIORETENIDO, FacturaProveedorConstantesFunciones.RETIVASERVICIORETENIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_ANEXONUMEROAUTORIZACION, FacturaProveedorConstantesFunciones.ANEXONUMEROAUTORIZACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_ANEXONUMESOSERIE, FacturaProveedorConstantesFunciones.ANEXONUMESOSERIE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_ANEXOFECHAVALIDEZ, FacturaProveedorConstantesFunciones.ANEXOFECHAVALIDEZ,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_IDTIPOTRIBUTARIO, FacturaProveedorConstantesFunciones.IDTIPOTRIBUTARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_ANEXOFACTURAINICIO, FacturaProveedorConstantesFunciones.ANEXOFACTURAINICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_ANEXOFACTURAFIN, FacturaProveedorConstantesFunciones.ANEXOFACTURAFIN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_IDCUENTACONTABLECREDITOFISCALBIENES, FacturaProveedorConstantesFunciones.IDCUENTACONTABLECREDITOFISCALBIENES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_IDRESPONSABLEFONDO, FacturaProveedorConstantesFunciones.IDRESPONSABLEFONDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_IDCUENTACONTABLECREDITOFISCALSERVICIOS, FacturaProveedorConstantesFunciones.IDCUENTACONTABLECREDITOFISCALSERVICIOS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_SECUENCIAL, FacturaProveedorConstantesFunciones.SECUENCIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_IDCUENTACONTABLEGASTO, FacturaProveedorConstantesFunciones.IDCUENTACONTABLEGASTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_GASTOVALOR, FacturaProveedorConstantesFunciones.GASTOVALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_IDCUENTACONTABLEGASTO2, FacturaProveedorConstantesFunciones.IDCUENTACONTABLEGASTO2,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_GASTOVALOR2, FacturaProveedorConstantesFunciones.GASTOVALOR2,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_GASTONOMBRE, FacturaProveedorConstantesFunciones.GASTONOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_GASTONOMBRE2, FacturaProveedorConstantesFunciones.GASTONOMBRE2,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_IDCUENTACONTABLECREDITOFIN, FacturaProveedorConstantesFunciones.IDCUENTACONTABLECREDITOFIN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_IDCUENTACONTABLECREDITOFIN2, FacturaProveedorConstantesFunciones.IDCUENTACONTABLECREDITOFIN2,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO, FacturaProveedorConstantesFunciones.IDCUENTACONTABLECREDITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_DESCRIPCION, FacturaProveedorConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_IDTIPOMOVIMIENTO, FacturaProveedorConstantesFunciones.IDTIPOMOVIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_IDTIPOMOVIMIENTOMODULO, FacturaProveedorConstantesFunciones.IDTIPOMOVIMIENTOMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO, FacturaProveedorConstantesFunciones.IDTIPOTRANSACCIONMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_NUMEROMAYOR, FacturaProveedorConstantesFunciones.NUMEROMAYOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorConstantesFunciones.LABEL_CODIGOASIENTO, FacturaProveedorConstantesFunciones.CODIGOASIENTO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasFacturaProveedor() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.IDMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.IDPLANTILLAFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.IDTIPODOCUMENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.PLAZO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.IDFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.NUMEROFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.IDTRANSACCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.RUC;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.IDEMPLEADOSOLICITA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.FECHAVENCE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.IDMONEDA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.CONACTIVOS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.CONRISE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.CONSITIOS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.DETALLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.VALORBIENES12;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.VALORSERVICIOS12;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.TOTALVALOR12;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.VALORBIENES0;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.VALORSERVICIOS0;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.TOTALVALOR0;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.BIENESICE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.SERVICIOSICE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.TOTALICE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.BIENESIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.SERVICIOSIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.TOTALIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.IVAPORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.CONMONTOOBJETOIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.NUMERORETENCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.NUMEROSERIE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.NUMEROAUTORIZACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.FECHAVALIDEZ;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.IDTIPORETENCIONFUENTE1;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.RETFUENTE1PORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.RETFUENTE1BASE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.RETFUENTE1RETENIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.IDTIPORETENCIONFUENTE2;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.RETFUENTE2PORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.RETFUENTE2BASE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.RETFUENTE2RETENIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.IDTIPORETENCIONIVA1;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.RETIVABIENPORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.RETIVABIENBASE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.RETIVABIENRETENIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.IDTIPORETENCIONIVA2;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.RETIVASERVICIOPORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.RETIVASERVICIOBASE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.RETIVASERVICIORETENIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.ANEXONUMEROAUTORIZACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.ANEXONUMESOSERIE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.ANEXOFECHAVALIDEZ;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.IDTIPOTRIBUTARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.ANEXOFACTURAINICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.ANEXOFACTURAFIN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.IDCUENTACONTABLECREDITOFISCALBIENES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.IDRESPONSABLEFONDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.IDCUENTACONTABLECREDITOFISCALSERVICIOS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.SECUENCIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.IDCUENTACONTABLEGASTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.GASTOVALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.IDCUENTACONTABLEGASTO2;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.GASTOVALOR2;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.GASTONOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.GASTONOMBRE2;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.IDCUENTACONTABLECREDITOFIN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.IDCUENTACONTABLECREDITOFIN2;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.IDCUENTACONTABLECREDITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.IDTIPOMOVIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.IDTIPOMOVIMIENTOMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.IDTIPOTRANSACCIONMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.NUMEROMAYOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorConstantesFunciones.CODIGOASIENTO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFacturaProveedor() throws Exception  {
		return FacturaProveedorConstantesFunciones.getTiposSeleccionarFacturaProveedor(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFacturaProveedor(Boolean conFk) throws Exception  {
		return FacturaProveedorConstantesFunciones.getTiposSeleccionarFacturaProveedor(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFacturaProveedor(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_IDMODULO);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_IDMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_IDPLANTILLAFACTURA);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_IDPLANTILLAFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_IDTIPODOCUMENTO);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_IDTIPODOCUMENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_PLAZO);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_PLAZO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_IDFACTURA);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_IDFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_NUMEROFACTURA);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_NUMEROFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_IDTRANSACCION);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_IDTRANSACCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_RUC);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_RUC);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_IDEMPLEADOSOLICITA);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_IDEMPLEADOSOLICITA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_FECHAVENCE);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_FECHAVENCE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_IDMONEDA);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_IDMONEDA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_CONACTIVOS);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_CONACTIVOS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_CONRISE);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_CONRISE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_CONSITIOS);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_CONSITIOS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_DETALLE);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_DETALLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_VALORBIENES12);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_VALORBIENES12);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_VALORSERVICIOS12);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_VALORSERVICIOS12);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_TOTALVALOR12);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_TOTALVALOR12);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_VALORBIENES0);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_VALORBIENES0);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_VALORSERVICIOS0);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_VALORSERVICIOS0);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_TOTALVALOR0);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_TOTALVALOR0);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_BIENESICE);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_BIENESICE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_SERVICIOSICE);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_SERVICIOSICE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_TOTALICE);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_TOTALICE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_BIENESIVA);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_BIENESIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_SERVICIOSIVA);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_SERVICIOSIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_TOTALIVA);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_TOTALIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_IVAPORCENTAJE);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_IVAPORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_CONMONTOOBJETOIVA);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_CONMONTOOBJETOIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_NUMERORETENCION);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_NUMERORETENCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_NUMEROSERIE);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_NUMEROSERIE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_NUMEROAUTORIZACION);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_NUMEROAUTORIZACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_FECHAVALIDEZ);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_FECHAVALIDEZ);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_IDTIPORETENCIONFUENTE1);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_IDTIPORETENCIONFUENTE1);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_RETFUENTE1PORCENTAJE);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_RETFUENTE1PORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_RETFUENTE1BASE);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_RETFUENTE1BASE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_RETFUENTE1RETENIDO);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_RETFUENTE1RETENIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_IDTIPORETENCIONFUENTE2);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_IDTIPORETENCIONFUENTE2);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_RETFUENTE2PORCENTAJE);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_RETFUENTE2PORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_RETFUENTE2BASE);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_RETFUENTE2BASE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_RETFUENTE2RETENIDO);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_RETFUENTE2RETENIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_IDTIPORETENCIONIVA1);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_IDTIPORETENCIONIVA1);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_RETIVABIENPORCENTAJE);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_RETIVABIENPORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_RETIVABIENBASE);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_RETIVABIENBASE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_RETIVABIENRETENIDO);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_RETIVABIENRETENIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_IDTIPORETENCIONIVA2);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_IDTIPORETENCIONIVA2);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_RETIVASERVICIOPORCENTAJE);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_RETIVASERVICIOPORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_RETIVASERVICIOBASE);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_RETIVASERVICIOBASE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_RETIVASERVICIORETENIDO);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_RETIVASERVICIORETENIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_ANEXONUMEROAUTORIZACION);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_ANEXONUMEROAUTORIZACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_ANEXONUMESOSERIE);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_ANEXONUMESOSERIE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_ANEXOFECHAVALIDEZ);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_ANEXOFECHAVALIDEZ);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_IDTIPOTRIBUTARIO);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_IDTIPOTRIBUTARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_ANEXOFACTURAINICIO);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_ANEXOFACTURAINICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_ANEXOFACTURAFIN);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_ANEXOFACTURAFIN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_IDCUENTACONTABLECREDITOFISCALBIENES);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_IDCUENTACONTABLECREDITOFISCALBIENES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_IDRESPONSABLEFONDO);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_IDRESPONSABLEFONDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_IDCUENTACONTABLECREDITOFISCALSERVICIOS);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_IDCUENTACONTABLECREDITOFISCALSERVICIOS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_SECUENCIAL);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_SECUENCIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_IDCUENTACONTABLEGASTO);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_IDCUENTACONTABLEGASTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_GASTOVALOR);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_GASTOVALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_IDCUENTACONTABLEGASTO2);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_IDCUENTACONTABLEGASTO2);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_GASTOVALOR2);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_GASTOVALOR2);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_GASTONOMBRE);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_GASTONOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_GASTONOMBRE2);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_GASTONOMBRE2);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_IDCUENTACONTABLECREDITOFIN);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_IDCUENTACONTABLECREDITOFIN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_IDCUENTACONTABLECREDITOFIN2);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_IDCUENTACONTABLECREDITOFIN2);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_IDTIPOMOVIMIENTO);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_IDTIPOMOVIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_IDTIPOMOVIMIENTOMODULO);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_IDTIPOMOVIMIENTOMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_NUMEROMAYOR);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_NUMEROMAYOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorConstantesFunciones.LABEL_CODIGOASIENTO);
			reporte.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_CODIGOASIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesFacturaProveedor(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesFacturaProveedor(FacturaProveedor facturaproveedorAux) throws Exception {
		
			facturaproveedorAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(facturaproveedorAux.getEmpresa()));
			facturaproveedorAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(facturaproveedorAux.getSucursal()));
			facturaproveedorAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(facturaproveedorAux.getEjercicio()));
			facturaproveedorAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(facturaproveedorAux.getPeriodo()));
			facturaproveedorAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(facturaproveedorAux.getAnio()));
			facturaproveedorAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(facturaproveedorAux.getMes()));
			facturaproveedorAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(facturaproveedorAux.getModulo()));
			facturaproveedorAux.setplantillafactura_descripcion(PlantillaFacturaConstantesFunciones.getPlantillaFacturaDescripcion(facturaproveedorAux.getPlantillaFactura()));
			facturaproveedorAux.settipodocumento_descripcion(TipoDocumentoConstantesFunciones.getTipoDocumentoDescripcion(facturaproveedorAux.getTipoDocumento()));
			facturaproveedorAux.setfactura_descripcion(FacturaConstantesFunciones.getFacturaDescripcion(facturaproveedorAux.getFactura()));
			facturaproveedorAux.settransaccion_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(facturaproveedorAux.getTransaccion()));
			facturaproveedorAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(facturaproveedorAux.getCliente()));
			facturaproveedorAux.setempleadosolicita_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(facturaproveedorAux.getEmpleadoSolicita()));
			facturaproveedorAux.setmoneda_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(facturaproveedorAux.getMoneda()));
			facturaproveedorAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(facturaproveedorAux.getEmpleado()));
			facturaproveedorAux.settiporetencionfuente1_descripcion(TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(facturaproveedorAux.getTipoRetencionFuente1()));
			facturaproveedorAux.settiporetencionfuente2_descripcion(TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(facturaproveedorAux.getTipoRetencionFuente2()));
			facturaproveedorAux.settiporetencioniva1_descripcion(TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(facturaproveedorAux.getTipoRetencionIva1()));
			facturaproveedorAux.settiporetencioniva2_descripcion(TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(facturaproveedorAux.getTipoRetencionIva2()));
			facturaproveedorAux.settipotributario_descripcion(TipoTributarioConstantesFunciones.getTipoTributarioDescripcion(facturaproveedorAux.getTipoTributario()));
			facturaproveedorAux.setcuentacontablecreditofiscalbienes_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(facturaproveedorAux.getCuentaContableCreditoFiscalBienes()));
			facturaproveedorAux.setresponsablefondo_descripcion(ResponsableFondoConstantesFunciones.getResponsableFondoDescripcion(facturaproveedorAux.getResponsableFondo()));
			facturaproveedorAux.setcuentacontablecreditofiscalservicios_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(facturaproveedorAux.getCuentaContableCreditoFiscalServicios()));
			facturaproveedorAux.setcuentacontablegasto_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(facturaproveedorAux.getCuentaContableGasto()));
			facturaproveedorAux.setcuentacontablegasto2_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(facturaproveedorAux.getCuentaContableGasto2()));
			facturaproveedorAux.setcuentacontablecreditofin_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(facturaproveedorAux.getCuentaContableCreditoFin()));
			facturaproveedorAux.setcuentacontablecreditofin2_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(facturaproveedorAux.getCuentaContableCreditoFin2()));
			facturaproveedorAux.setcuentacontablecredito_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(facturaproveedorAux.getCuentaContableCredito()));
			facturaproveedorAux.settipomovimiento_descripcion(TipoMovimientoConstantesFunciones.getTipoMovimientoDescripcion(facturaproveedorAux.getTipoMovimiento()));
			facturaproveedorAux.settipomovimientomodulo_descripcion(TipoMovimientoModuloConstantesFunciones.getTipoMovimientoModuloDescripcion(facturaproveedorAux.getTipoMovimientoModulo()));
			facturaproveedorAux.settipotransaccionmodulo_descripcion(TipoTransaccionModuloConstantesFunciones.getTipoTransaccionModuloDescripcion(facturaproveedorAux.getTipoTransaccionModulo()));		
	}
	
	public static void refrescarForeignKeysDescripcionesFacturaProveedor(List<FacturaProveedor> facturaproveedorsTemp) throws Exception {
		for(FacturaProveedor facturaproveedorAux:facturaproveedorsTemp) {
			
			facturaproveedorAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(facturaproveedorAux.getEmpresa()));
			facturaproveedorAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(facturaproveedorAux.getSucursal()));
			facturaproveedorAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(facturaproveedorAux.getEjercicio()));
			facturaproveedorAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(facturaproveedorAux.getPeriodo()));
			facturaproveedorAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(facturaproveedorAux.getAnio()));
			facturaproveedorAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(facturaproveedorAux.getMes()));
			facturaproveedorAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(facturaproveedorAux.getModulo()));
			facturaproveedorAux.setplantillafactura_descripcion(PlantillaFacturaConstantesFunciones.getPlantillaFacturaDescripcion(facturaproveedorAux.getPlantillaFactura()));
			facturaproveedorAux.settipodocumento_descripcion(TipoDocumentoConstantesFunciones.getTipoDocumentoDescripcion(facturaproveedorAux.getTipoDocumento()));
			facturaproveedorAux.setfactura_descripcion(FacturaConstantesFunciones.getFacturaDescripcion(facturaproveedorAux.getFactura()));
			facturaproveedorAux.settransaccion_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(facturaproveedorAux.getTransaccion()));
			facturaproveedorAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(facturaproveedorAux.getCliente()));
			facturaproveedorAux.setempleadosolicita_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(facturaproveedorAux.getEmpleadoSolicita()));
			facturaproveedorAux.setmoneda_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(facturaproveedorAux.getMoneda()));
			facturaproveedorAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(facturaproveedorAux.getEmpleado()));
			facturaproveedorAux.settiporetencionfuente1_descripcion(TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(facturaproveedorAux.getTipoRetencionFuente1()));
			facturaproveedorAux.settiporetencionfuente2_descripcion(TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(facturaproveedorAux.getTipoRetencionFuente2()));
			facturaproveedorAux.settiporetencioniva1_descripcion(TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(facturaproveedorAux.getTipoRetencionIva1()));
			facturaproveedorAux.settiporetencioniva2_descripcion(TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(facturaproveedorAux.getTipoRetencionIva2()));
			facturaproveedorAux.settipotributario_descripcion(TipoTributarioConstantesFunciones.getTipoTributarioDescripcion(facturaproveedorAux.getTipoTributario()));
			facturaproveedorAux.setcuentacontablecreditofiscalbienes_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(facturaproveedorAux.getCuentaContableCreditoFiscalBienes()));
			facturaproveedorAux.setresponsablefondo_descripcion(ResponsableFondoConstantesFunciones.getResponsableFondoDescripcion(facturaproveedorAux.getResponsableFondo()));
			facturaproveedorAux.setcuentacontablecreditofiscalservicios_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(facturaproveedorAux.getCuentaContableCreditoFiscalServicios()));
			facturaproveedorAux.setcuentacontablegasto_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(facturaproveedorAux.getCuentaContableGasto()));
			facturaproveedorAux.setcuentacontablegasto2_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(facturaproveedorAux.getCuentaContableGasto2()));
			facturaproveedorAux.setcuentacontablecreditofin_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(facturaproveedorAux.getCuentaContableCreditoFin()));
			facturaproveedorAux.setcuentacontablecreditofin2_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(facturaproveedorAux.getCuentaContableCreditoFin2()));
			facturaproveedorAux.setcuentacontablecredito_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(facturaproveedorAux.getCuentaContableCredito()));
			facturaproveedorAux.settipomovimiento_descripcion(TipoMovimientoConstantesFunciones.getTipoMovimientoDescripcion(facturaproveedorAux.getTipoMovimiento()));
			facturaproveedorAux.settipomovimientomodulo_descripcion(TipoMovimientoModuloConstantesFunciones.getTipoMovimientoModuloDescripcion(facturaproveedorAux.getTipoMovimientoModulo()));
			facturaproveedorAux.settipotransaccionmodulo_descripcion(TipoTransaccionModuloConstantesFunciones.getTipoTransaccionModuloDescripcion(facturaproveedorAux.getTipoTransaccionModulo()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfFacturaProveedor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Mes.class));
				classes.add(new Classe(Modulo.class));
				classes.add(new Classe(PlantillaFactura.class));
				classes.add(new Classe(TipoDocumento.class));
				classes.add(new Classe(Factura.class));
				classes.add(new Classe(Transaccion.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(Moneda.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(TipoRetencion.class));
				classes.add(new Classe(TipoRetencion.class));
				classes.add(new Classe(TipoRetencion.class));
				classes.add(new Classe(TipoRetencion.class));
				classes.add(new Classe(TipoTributario.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(ResponsableFondo.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(TipoMovimiento.class));
				classes.add(new Classe(TipoMovimientoModulo.class));
				classes.add(new Classe(TipoTransaccionModulo.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Sucursal.class)) {
						classes.add(new Classe(Sucursal.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Ejercicio.class)) {
						classes.add(new Classe(Ejercicio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Periodo.class)) {
						classes.add(new Classe(Periodo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Anio.class)) {
						classes.add(new Classe(Anio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Mes.class)) {
						classes.add(new Classe(Mes.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Modulo.class)) {
						classes.add(new Classe(Modulo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(PlantillaFactura.class)) {
						classes.add(new Classe(PlantillaFactura.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoDocumento.class)) {
						classes.add(new Classe(TipoDocumento.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Factura.class)) {
						classes.add(new Classe(Factura.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Transaccion.class)) {
						classes.add(new Classe(Transaccion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Moneda.class)) {
						classes.add(new Classe(Moneda.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoRetencion.class)) {
						classes.add(new Classe(TipoRetencion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoRetencion.class)) {
						classes.add(new Classe(TipoRetencion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoRetencion.class)) {
						classes.add(new Classe(TipoRetencion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoRetencion.class)) {
						classes.add(new Classe(TipoRetencion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoTributario.class)) {
						classes.add(new Classe(TipoTributario.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ResponsableFondo.class)) {
						classes.add(new Classe(ResponsableFondo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoMovimiento.class)) {
						classes.add(new Classe(TipoMovimiento.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoMovimientoModulo.class)) {
						classes.add(new Classe(TipoMovimientoModulo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoTransaccionModulo.class)) {
						classes.add(new Classe(TipoTransaccionModulo.class));
					}
				}

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfFacturaProveedor(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
					}

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}

					if(PlantillaFactura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PlantillaFactura.class)); continue;
					}

					if(TipoDocumento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDocumento.class)); continue;
					}

					if(Factura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Factura.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Moneda.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Moneda.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(TipoRetencion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRetencion.class)); continue;
					}

					if(TipoRetencion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRetencion.class)); continue;
					}

					if(TipoRetencion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRetencion.class)); continue;
					}

					if(TipoRetencion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRetencion.class)); continue;
					}

					if(TipoTributario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoTributario.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(ResponsableFondo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ResponsableFondo.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(TipoMovimiento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoMovimiento.class)); continue;
					}

					if(TipoMovimientoModulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoMovimientoModulo.class)); continue;
					}

					if(TipoTransaccionModulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoTransaccionModulo.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
					}

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}

					if(PlantillaFactura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PlantillaFactura.class)); continue;
					}

					if(TipoDocumento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDocumento.class)); continue;
					}

					if(Factura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Factura.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Moneda.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Moneda.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(TipoRetencion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRetencion.class)); continue;
					}

					if(TipoRetencion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRetencion.class)); continue;
					}

					if(TipoRetencion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRetencion.class)); continue;
					}

					if(TipoRetencion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRetencion.class)); continue;
					}

					if(TipoTributario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoTributario.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(ResponsableFondo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ResponsableFondo.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(TipoMovimiento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoMovimiento.class)); continue;
					}

					if(TipoMovimientoModulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoMovimientoModulo.class)); continue;
					}

					if(TipoTransaccionModulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoTransaccionModulo.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfFacturaProveedor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return FacturaProveedorConstantesFunciones.getClassesRelationshipsOfFacturaProveedor(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfFacturaProveedor(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(DetalleFacturaProveedor.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleFacturaProveedor.class)) {
						classes.add(new Classe(DetalleFacturaProveedor.class)); break;
					}
				}

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfFacturaProveedor(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return FacturaProveedorConstantesFunciones.getClassesRelationshipsFromStringsOfFacturaProveedor(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfFacturaProveedor(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleFacturaProveedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleFacturaProveedor.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleFacturaProveedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleFacturaProveedor.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}		
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(FacturaProveedor facturaproveedor,List<FacturaProveedor> facturaproveedors,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			FacturaProveedor facturaproveedorEncontrado=null;
			
			for(FacturaProveedor facturaproveedorLocal:facturaproveedors) {
				if(facturaproveedorLocal.getId().equals(facturaproveedor.getId())) {
					facturaproveedorEncontrado=facturaproveedorLocal;
					
					facturaproveedorLocal.setIsChanged(facturaproveedor.getIsChanged());
					facturaproveedorLocal.setIsNew(facturaproveedor.getIsNew());
					facturaproveedorLocal.setIsDeleted(facturaproveedor.getIsDeleted());
					
					facturaproveedorLocal.setGeneralEntityOriginal(facturaproveedor.getGeneralEntityOriginal());
					
					facturaproveedorLocal.setId(facturaproveedor.getId());	
					facturaproveedorLocal.setVersionRow(facturaproveedor.getVersionRow());	
					facturaproveedorLocal.setid_empresa(facturaproveedor.getid_empresa());	
					facturaproveedorLocal.setid_sucursal(facturaproveedor.getid_sucursal());	
					facturaproveedorLocal.setid_ejercicio(facturaproveedor.getid_ejercicio());	
					facturaproveedorLocal.setid_periodo(facturaproveedor.getid_periodo());	
					facturaproveedorLocal.setid_anio(facturaproveedor.getid_anio());	
					facturaproveedorLocal.setid_mes(facturaproveedor.getid_mes());	
					facturaproveedorLocal.setid_modulo(facturaproveedor.getid_modulo());	
					facturaproveedorLocal.setid_plantilla_factura(facturaproveedor.getid_plantilla_factura());	
					facturaproveedorLocal.setid_tipo_documento(facturaproveedor.getid_tipo_documento());	
					facturaproveedorLocal.setplazo(facturaproveedor.getplazo());	
					facturaproveedorLocal.setid_factura(facturaproveedor.getid_factura());	
					facturaproveedorLocal.setnumero_factura(facturaproveedor.getnumero_factura());	
					facturaproveedorLocal.setid_transaccion(facturaproveedor.getid_transaccion());	
					facturaproveedorLocal.setfecha_emision(facturaproveedor.getfecha_emision());	
					facturaproveedorLocal.setid_cliente(facturaproveedor.getid_cliente());	
					facturaproveedorLocal.setruc(facturaproveedor.getruc());	
					facturaproveedorLocal.setid_empleado_solicita(facturaproveedor.getid_empleado_solicita());	
					facturaproveedorLocal.setfecha_vence(facturaproveedor.getfecha_vence());	
					facturaproveedorLocal.setid_moneda(facturaproveedor.getid_moneda());	
					facturaproveedorLocal.setid_empleado(facturaproveedor.getid_empleado());	
					facturaproveedorLocal.setcon_activos(facturaproveedor.getcon_activos());	
					facturaproveedorLocal.setcon_rise(facturaproveedor.getcon_rise());	
					facturaproveedorLocal.setcon_sitios(facturaproveedor.getcon_sitios());	
					facturaproveedorLocal.setdetalle(facturaproveedor.getdetalle());	
					facturaproveedorLocal.setvalor_bienes12(facturaproveedor.getvalor_bienes12());	
					facturaproveedorLocal.setvalor_servicios12(facturaproveedor.getvalor_servicios12());	
					facturaproveedorLocal.settotal_valor12(facturaproveedor.gettotal_valor12());	
					facturaproveedorLocal.setvalor_bienes0(facturaproveedor.getvalor_bienes0());	
					facturaproveedorLocal.setvalor_servicios0(facturaproveedor.getvalor_servicios0());	
					facturaproveedorLocal.settotal_valor0(facturaproveedor.gettotal_valor0());	
					facturaproveedorLocal.setbienes_ice(facturaproveedor.getbienes_ice());	
					facturaproveedorLocal.setservicios_ice(facturaproveedor.getservicios_ice());	
					facturaproveedorLocal.settotal_ice(facturaproveedor.gettotal_ice());	
					facturaproveedorLocal.setbienes_iva(facturaproveedor.getbienes_iva());	
					facturaproveedorLocal.setservicios_iva(facturaproveedor.getservicios_iva());	
					facturaproveedorLocal.settotal_iva(facturaproveedor.gettotal_iva());	
					facturaproveedorLocal.setiva_porcentaje(facturaproveedor.getiva_porcentaje());	
					facturaproveedorLocal.settotal(facturaproveedor.gettotal());	
					facturaproveedorLocal.setcon_monto_objeto_iva(facturaproveedor.getcon_monto_objeto_iva());	
					facturaproveedorLocal.setnumero_retencion(facturaproveedor.getnumero_retencion());	
					facturaproveedorLocal.setnumero_serie(facturaproveedor.getnumero_serie());	
					facturaproveedorLocal.setnumero_autorizacion(facturaproveedor.getnumero_autorizacion());	
					facturaproveedorLocal.setfecha_validez(facturaproveedor.getfecha_validez());	
					facturaproveedorLocal.setid_tipo_retencion_fuente1(facturaproveedor.getid_tipo_retencion_fuente1());	
					facturaproveedorLocal.setret_fuente1_porcentaje(facturaproveedor.getret_fuente1_porcentaje());	
					facturaproveedorLocal.setret_fuente1_base(facturaproveedor.getret_fuente1_base());	
					facturaproveedorLocal.setret_fuente1_retenido(facturaproveedor.getret_fuente1_retenido());	
					facturaproveedorLocal.setid_tipo_retencion_fuente2(facturaproveedor.getid_tipo_retencion_fuente2());	
					facturaproveedorLocal.setret_fuente2_porcentaje(facturaproveedor.getret_fuente2_porcentaje());	
					facturaproveedorLocal.setret_fuente2_base(facturaproveedor.getret_fuente2_base());	
					facturaproveedorLocal.setret_fuente2_retenido(facturaproveedor.getret_fuente2_retenido());	
					facturaproveedorLocal.setid_tipo_retencion_iva1(facturaproveedor.getid_tipo_retencion_iva1());	
					facturaproveedorLocal.setret_iva_bien_porcentaje(facturaproveedor.getret_iva_bien_porcentaje());	
					facturaproveedorLocal.setret_iva_bien_base(facturaproveedor.getret_iva_bien_base());	
					facturaproveedorLocal.setret_iva_bien_retenido(facturaproveedor.getret_iva_bien_retenido());	
					facturaproveedorLocal.setid_tipo_retencion_iva2(facturaproveedor.getid_tipo_retencion_iva2());	
					facturaproveedorLocal.setret_iva_servicio_porcentaje(facturaproveedor.getret_iva_servicio_porcentaje());	
					facturaproveedorLocal.setret_iva_servicio_base(facturaproveedor.getret_iva_servicio_base());	
					facturaproveedorLocal.setret_iva_servicio_retenido(facturaproveedor.getret_iva_servicio_retenido());	
					facturaproveedorLocal.setanexo_numero_autorizacion(facturaproveedor.getanexo_numero_autorizacion());	
					facturaproveedorLocal.setanexo_numeso_serie(facturaproveedor.getanexo_numeso_serie());	
					facturaproveedorLocal.setanexo_fecha_validez(facturaproveedor.getanexo_fecha_validez());	
					facturaproveedorLocal.setid_tipo_tributario(facturaproveedor.getid_tipo_tributario());	
					facturaproveedorLocal.setanexo_factura_inicio(facturaproveedor.getanexo_factura_inicio());	
					facturaproveedorLocal.setanexo_factura_fin(facturaproveedor.getanexo_factura_fin());	
					facturaproveedorLocal.setid_cuenta_contable_credito_fiscal_bienes(facturaproveedor.getid_cuenta_contable_credito_fiscal_bienes());	
					facturaproveedorLocal.setid_responsable_fondo(facturaproveedor.getid_responsable_fondo());	
					facturaproveedorLocal.setid_cuenta_contable_credito_fiscal_servicios(facturaproveedor.getid_cuenta_contable_credito_fiscal_servicios());	
					facturaproveedorLocal.setsecuencial(facturaproveedor.getsecuencial());	
					facturaproveedorLocal.setid_cuenta_contable_gasto(facturaproveedor.getid_cuenta_contable_gasto());	
					facturaproveedorLocal.setgasto_valor(facturaproveedor.getgasto_valor());	
					facturaproveedorLocal.setid_cuenta_contable_gasto2(facturaproveedor.getid_cuenta_contable_gasto2());	
					facturaproveedorLocal.setgasto_valor2(facturaproveedor.getgasto_valor2());	
					facturaproveedorLocal.setgasto_nombre(facturaproveedor.getgasto_nombre());	
					facturaproveedorLocal.setgasto_nombre2(facturaproveedor.getgasto_nombre2());	
					facturaproveedorLocal.setid_cuenta_contable_credito_fin(facturaproveedor.getid_cuenta_contable_credito_fin());	
					facturaproveedorLocal.setid_cuenta_contable_credito_fin2(facturaproveedor.getid_cuenta_contable_credito_fin2());	
					facturaproveedorLocal.setid_cuenta_contable_credito(facturaproveedor.getid_cuenta_contable_credito());	
					facturaproveedorLocal.setdescripcion(facturaproveedor.getdescripcion());	
					facturaproveedorLocal.setid_tipo_movimiento(facturaproveedor.getid_tipo_movimiento());	
					facturaproveedorLocal.setid_tipo_movimiento_modulo(facturaproveedor.getid_tipo_movimiento_modulo());	
					facturaproveedorLocal.setid_tipo_transaccion_modulo(facturaproveedor.getid_tipo_transaccion_modulo());	
					facturaproveedorLocal.setnumero_mayor(facturaproveedor.getnumero_mayor());	
					facturaproveedorLocal.setcodigo_asiento(facturaproveedor.getcodigo_asiento());	
					
					
					facturaproveedorLocal.setDetalleFacturaProveedors(facturaproveedor.getDetalleFacturaProveedors());
					
					existe=true;
					break;
				}
			}
			
			if(!facturaproveedor.getIsDeleted()) {
				if(!existe) {
					facturaproveedors.add(facturaproveedor);
				}
			} else {
				if(facturaproveedorEncontrado!=null && permiteQuitar)  {
					facturaproveedors.remove(facturaproveedorEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(FacturaProveedor facturaproveedor,List<FacturaProveedor> facturaproveedors) throws Exception {
		try	{			
			for(FacturaProveedor facturaproveedorLocal:facturaproveedors) {
				if(facturaproveedorLocal.getId().equals(facturaproveedor.getId())) {
					facturaproveedorLocal.setIsSelected(facturaproveedor.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesFacturaProveedor(List<FacturaProveedor> facturaproveedorsAux) throws Exception {
		//this.facturaproveedorsAux=facturaproveedorsAux;
		
		for(FacturaProveedor facturaproveedorAux:facturaproveedorsAux) {
			if(facturaproveedorAux.getIsChanged()) {
				facturaproveedorAux.setIsChanged(false);
			}		
			
			if(facturaproveedorAux.getIsNew()) {
				facturaproveedorAux.setIsNew(false);
			}	
			
			if(facturaproveedorAux.getIsDeleted()) {
				facturaproveedorAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesFacturaProveedor(FacturaProveedor facturaproveedorAux) throws Exception {
		//this.facturaproveedorAux=facturaproveedorAux;
		
			if(facturaproveedorAux.getIsChanged()) {
				facturaproveedorAux.setIsChanged(false);
			}		
			
			if(facturaproveedorAux.getIsNew()) {
				facturaproveedorAux.setIsNew(false);
			}	
			
			if(facturaproveedorAux.getIsDeleted()) {
				facturaproveedorAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(FacturaProveedor facturaproveedorAsignar,FacturaProveedor facturaproveedor) throws Exception {
		facturaproveedorAsignar.setId(facturaproveedor.getId());	
		facturaproveedorAsignar.setVersionRow(facturaproveedor.getVersionRow());	
		facturaproveedorAsignar.setid_empresa(facturaproveedor.getid_empresa());
		facturaproveedorAsignar.setempresa_descripcion(facturaproveedor.getempresa_descripcion());	
		facturaproveedorAsignar.setid_sucursal(facturaproveedor.getid_sucursal());
		facturaproveedorAsignar.setsucursal_descripcion(facturaproveedor.getsucursal_descripcion());	
		facturaproveedorAsignar.setid_ejercicio(facturaproveedor.getid_ejercicio());
		facturaproveedorAsignar.setejercicio_descripcion(facturaproveedor.getejercicio_descripcion());	
		facturaproveedorAsignar.setid_periodo(facturaproveedor.getid_periodo());
		facturaproveedorAsignar.setperiodo_descripcion(facturaproveedor.getperiodo_descripcion());	
		facturaproveedorAsignar.setid_anio(facturaproveedor.getid_anio());
		facturaproveedorAsignar.setanio_descripcion(facturaproveedor.getanio_descripcion());	
		facturaproveedorAsignar.setid_mes(facturaproveedor.getid_mes());
		facturaproveedorAsignar.setmes_descripcion(facturaproveedor.getmes_descripcion());	
		facturaproveedorAsignar.setid_modulo(facturaproveedor.getid_modulo());
		facturaproveedorAsignar.setmodulo_descripcion(facturaproveedor.getmodulo_descripcion());	
		facturaproveedorAsignar.setid_plantilla_factura(facturaproveedor.getid_plantilla_factura());
		facturaproveedorAsignar.setplantillafactura_descripcion(facturaproveedor.getplantillafactura_descripcion());	
		facturaproveedorAsignar.setid_tipo_documento(facturaproveedor.getid_tipo_documento());
		facturaproveedorAsignar.settipodocumento_descripcion(facturaproveedor.gettipodocumento_descripcion());	
		facturaproveedorAsignar.setplazo(facturaproveedor.getplazo());	
		facturaproveedorAsignar.setid_factura(facturaproveedor.getid_factura());
		facturaproveedorAsignar.setfactura_descripcion(facturaproveedor.getfactura_descripcion());	
		facturaproveedorAsignar.setnumero_factura(facturaproveedor.getnumero_factura());	
		facturaproveedorAsignar.setid_transaccion(facturaproveedor.getid_transaccion());
		facturaproveedorAsignar.settransaccion_descripcion(facturaproveedor.gettransaccion_descripcion());	
		facturaproveedorAsignar.setfecha_emision(facturaproveedor.getfecha_emision());	
		facturaproveedorAsignar.setid_cliente(facturaproveedor.getid_cliente());
		facturaproveedorAsignar.setcliente_descripcion(facturaproveedor.getcliente_descripcion());	
		facturaproveedorAsignar.setruc(facturaproveedor.getruc());	
		facturaproveedorAsignar.setid_empleado_solicita(facturaproveedor.getid_empleado_solicita());
		facturaproveedorAsignar.setempleadosolicita_descripcion(facturaproveedor.getempleadosolicita_descripcion());	
		facturaproveedorAsignar.setfecha_vence(facturaproveedor.getfecha_vence());	
		facturaproveedorAsignar.setid_moneda(facturaproveedor.getid_moneda());
		facturaproveedorAsignar.setmoneda_descripcion(facturaproveedor.getmoneda_descripcion());	
		facturaproveedorAsignar.setid_empleado(facturaproveedor.getid_empleado());
		facturaproveedorAsignar.setempleado_descripcion(facturaproveedor.getempleado_descripcion());	
		facturaproveedorAsignar.setcon_activos(facturaproveedor.getcon_activos());	
		facturaproveedorAsignar.setcon_rise(facturaproveedor.getcon_rise());	
		facturaproveedorAsignar.setcon_sitios(facturaproveedor.getcon_sitios());	
		facturaproveedorAsignar.setdetalle(facturaproveedor.getdetalle());	
		facturaproveedorAsignar.setvalor_bienes12(facturaproveedor.getvalor_bienes12());	
		facturaproveedorAsignar.setvalor_servicios12(facturaproveedor.getvalor_servicios12());	
		facturaproveedorAsignar.settotal_valor12(facturaproveedor.gettotal_valor12());	
		facturaproveedorAsignar.setvalor_bienes0(facturaproveedor.getvalor_bienes0());	
		facturaproveedorAsignar.setvalor_servicios0(facturaproveedor.getvalor_servicios0());	
		facturaproveedorAsignar.settotal_valor0(facturaproveedor.gettotal_valor0());	
		facturaproveedorAsignar.setbienes_ice(facturaproveedor.getbienes_ice());	
		facturaproveedorAsignar.setservicios_ice(facturaproveedor.getservicios_ice());	
		facturaproveedorAsignar.settotal_ice(facturaproveedor.gettotal_ice());	
		facturaproveedorAsignar.setbienes_iva(facturaproveedor.getbienes_iva());	
		facturaproveedorAsignar.setservicios_iva(facturaproveedor.getservicios_iva());	
		facturaproveedorAsignar.settotal_iva(facturaproveedor.gettotal_iva());	
		facturaproveedorAsignar.setiva_porcentaje(facturaproveedor.getiva_porcentaje());	
		facturaproveedorAsignar.settotal(facturaproveedor.gettotal());	
		facturaproveedorAsignar.setcon_monto_objeto_iva(facturaproveedor.getcon_monto_objeto_iva());	
		facturaproveedorAsignar.setnumero_retencion(facturaproveedor.getnumero_retencion());	
		facturaproveedorAsignar.setnumero_serie(facturaproveedor.getnumero_serie());	
		facturaproveedorAsignar.setnumero_autorizacion(facturaproveedor.getnumero_autorizacion());	
		facturaproveedorAsignar.setfecha_validez(facturaproveedor.getfecha_validez());	
		facturaproveedorAsignar.setid_tipo_retencion_fuente1(facturaproveedor.getid_tipo_retencion_fuente1());
		facturaproveedorAsignar.settiporetencionfuente1_descripcion(facturaproveedor.gettiporetencionfuente1_descripcion());	
		facturaproveedorAsignar.setret_fuente1_porcentaje(facturaproveedor.getret_fuente1_porcentaje());	
		facturaproveedorAsignar.setret_fuente1_base(facturaproveedor.getret_fuente1_base());	
		facturaproveedorAsignar.setret_fuente1_retenido(facturaproveedor.getret_fuente1_retenido());	
		facturaproveedorAsignar.setid_tipo_retencion_fuente2(facturaproveedor.getid_tipo_retencion_fuente2());
		facturaproveedorAsignar.settiporetencionfuente2_descripcion(facturaproveedor.gettiporetencionfuente2_descripcion());	
		facturaproveedorAsignar.setret_fuente2_porcentaje(facturaproveedor.getret_fuente2_porcentaje());	
		facturaproveedorAsignar.setret_fuente2_base(facturaproveedor.getret_fuente2_base());	
		facturaproveedorAsignar.setret_fuente2_retenido(facturaproveedor.getret_fuente2_retenido());	
		facturaproveedorAsignar.setid_tipo_retencion_iva1(facturaproveedor.getid_tipo_retencion_iva1());
		facturaproveedorAsignar.settiporetencioniva1_descripcion(facturaproveedor.gettiporetencioniva1_descripcion());	
		facturaproveedorAsignar.setret_iva_bien_porcentaje(facturaproveedor.getret_iva_bien_porcentaje());	
		facturaproveedorAsignar.setret_iva_bien_base(facturaproveedor.getret_iva_bien_base());	
		facturaproveedorAsignar.setret_iva_bien_retenido(facturaproveedor.getret_iva_bien_retenido());	
		facturaproveedorAsignar.setid_tipo_retencion_iva2(facturaproveedor.getid_tipo_retencion_iva2());
		facturaproveedorAsignar.settiporetencioniva2_descripcion(facturaproveedor.gettiporetencioniva2_descripcion());	
		facturaproveedorAsignar.setret_iva_servicio_porcentaje(facturaproveedor.getret_iva_servicio_porcentaje());	
		facturaproveedorAsignar.setret_iva_servicio_base(facturaproveedor.getret_iva_servicio_base());	
		facturaproveedorAsignar.setret_iva_servicio_retenido(facturaproveedor.getret_iva_servicio_retenido());	
		facturaproveedorAsignar.setanexo_numero_autorizacion(facturaproveedor.getanexo_numero_autorizacion());	
		facturaproveedorAsignar.setanexo_numeso_serie(facturaproveedor.getanexo_numeso_serie());	
		facturaproveedorAsignar.setanexo_fecha_validez(facturaproveedor.getanexo_fecha_validez());	
		facturaproveedorAsignar.setid_tipo_tributario(facturaproveedor.getid_tipo_tributario());
		facturaproveedorAsignar.settipotributario_descripcion(facturaproveedor.gettipotributario_descripcion());	
		facturaproveedorAsignar.setanexo_factura_inicio(facturaproveedor.getanexo_factura_inicio());	
		facturaproveedorAsignar.setanexo_factura_fin(facturaproveedor.getanexo_factura_fin());	
		facturaproveedorAsignar.setid_cuenta_contable_credito_fiscal_bienes(facturaproveedor.getid_cuenta_contable_credito_fiscal_bienes());
		facturaproveedorAsignar.setcuentacontablecreditofiscalbienes_descripcion(facturaproveedor.getcuentacontablecreditofiscalbienes_descripcion());	
		facturaproveedorAsignar.setid_responsable_fondo(facturaproveedor.getid_responsable_fondo());
		facturaproveedorAsignar.setresponsablefondo_descripcion(facturaproveedor.getresponsablefondo_descripcion());	
		facturaproveedorAsignar.setid_cuenta_contable_credito_fiscal_servicios(facturaproveedor.getid_cuenta_contable_credito_fiscal_servicios());
		facturaproveedorAsignar.setcuentacontablecreditofiscalservicios_descripcion(facturaproveedor.getcuentacontablecreditofiscalservicios_descripcion());	
		facturaproveedorAsignar.setsecuencial(facturaproveedor.getsecuencial());	
		facturaproveedorAsignar.setid_cuenta_contable_gasto(facturaproveedor.getid_cuenta_contable_gasto());
		facturaproveedorAsignar.setcuentacontablegasto_descripcion(facturaproveedor.getcuentacontablegasto_descripcion());	
		facturaproveedorAsignar.setgasto_valor(facturaproveedor.getgasto_valor());	
		facturaproveedorAsignar.setid_cuenta_contable_gasto2(facturaproveedor.getid_cuenta_contable_gasto2());
		facturaproveedorAsignar.setcuentacontablegasto2_descripcion(facturaproveedor.getcuentacontablegasto2_descripcion());	
		facturaproveedorAsignar.setgasto_valor2(facturaproveedor.getgasto_valor2());	
		facturaproveedorAsignar.setgasto_nombre(facturaproveedor.getgasto_nombre());	
		facturaproveedorAsignar.setgasto_nombre2(facturaproveedor.getgasto_nombre2());	
		facturaproveedorAsignar.setid_cuenta_contable_credito_fin(facturaproveedor.getid_cuenta_contable_credito_fin());
		facturaproveedorAsignar.setcuentacontablecreditofin_descripcion(facturaproveedor.getcuentacontablecreditofin_descripcion());	
		facturaproveedorAsignar.setid_cuenta_contable_credito_fin2(facturaproveedor.getid_cuenta_contable_credito_fin2());
		facturaproveedorAsignar.setcuentacontablecreditofin2_descripcion(facturaproveedor.getcuentacontablecreditofin2_descripcion());	
		facturaproveedorAsignar.setid_cuenta_contable_credito(facturaproveedor.getid_cuenta_contable_credito());
		facturaproveedorAsignar.setcuentacontablecredito_descripcion(facturaproveedor.getcuentacontablecredito_descripcion());	
		facturaproveedorAsignar.setdescripcion(facturaproveedor.getdescripcion());	
		facturaproveedorAsignar.setid_tipo_movimiento(facturaproveedor.getid_tipo_movimiento());
		facturaproveedorAsignar.settipomovimiento_descripcion(facturaproveedor.gettipomovimiento_descripcion());	
		facturaproveedorAsignar.setid_tipo_movimiento_modulo(facturaproveedor.getid_tipo_movimiento_modulo());
		facturaproveedorAsignar.settipomovimientomodulo_descripcion(facturaproveedor.gettipomovimientomodulo_descripcion());	
		facturaproveedorAsignar.setid_tipo_transaccion_modulo(facturaproveedor.getid_tipo_transaccion_modulo());
		facturaproveedorAsignar.settipotransaccionmodulo_descripcion(facturaproveedor.gettipotransaccionmodulo_descripcion());	
		facturaproveedorAsignar.setnumero_mayor(facturaproveedor.getnumero_mayor());	
		facturaproveedorAsignar.setcodigo_asiento(facturaproveedor.getcodigo_asiento());	
	}
	
	public static void inicializarFacturaProveedor(FacturaProveedor facturaproveedor) throws Exception {
		try {
				facturaproveedor.setId(0L);	
					
				facturaproveedor.setid_empresa(-1L);	
				facturaproveedor.setid_sucursal(-1L);	
				facturaproveedor.setid_ejercicio(-1L);	
				facturaproveedor.setid_periodo(-1L);	
				facturaproveedor.setid_anio(null);	
				facturaproveedor.setid_mes(null);	
				facturaproveedor.setid_modulo(-1L);	
				facturaproveedor.setid_plantilla_factura(null);	
				facturaproveedor.setid_tipo_documento(-1L);	
				facturaproveedor.setplazo(0);	
				facturaproveedor.setid_factura(-1L);	
				facturaproveedor.setnumero_factura("");	
				facturaproveedor.setid_transaccion(-1L);	
				facturaproveedor.setfecha_emision(new Date());	
				facturaproveedor.setid_cliente(-1L);	
				facturaproveedor.setruc("");	
				facturaproveedor.setid_empleado_solicita(-1L);	
				facturaproveedor.setfecha_vence(new Date());	
				facturaproveedor.setid_moneda(-1L);	
				facturaproveedor.setid_empleado(-1L);	
				facturaproveedor.setcon_activos(false);	
				facturaproveedor.setcon_rise(false);	
				facturaproveedor.setcon_sitios(false);	
				facturaproveedor.setdetalle("");	
				facturaproveedor.setvalor_bienes12(0.0);	
				facturaproveedor.setvalor_servicios12(0.0);	
				facturaproveedor.settotal_valor12(0.0);	
				facturaproveedor.setvalor_bienes0(0.0);	
				facturaproveedor.setvalor_servicios0(0.0);	
				facturaproveedor.settotal_valor0(0.0);	
				facturaproveedor.setbienes_ice(0.0);	
				facturaproveedor.setservicios_ice(0.0);	
				facturaproveedor.settotal_ice(0.0);	
				facturaproveedor.setbienes_iva(0.0);	
				facturaproveedor.setservicios_iva(0.0);	
				facturaproveedor.settotal_iva(0.0);	
				facturaproveedor.setiva_porcentaje(0.0);	
				facturaproveedor.settotal(0.0);	
				facturaproveedor.setcon_monto_objeto_iva(false);	
				facturaproveedor.setnumero_retencion("");	
				facturaproveedor.setnumero_serie("");	
				facturaproveedor.setnumero_autorizacion("");	
				facturaproveedor.setfecha_validez(new Date());	
				facturaproveedor.setid_tipo_retencion_fuente1(-1L);	
				facturaproveedor.setret_fuente1_porcentaje(0.0);	
				facturaproveedor.setret_fuente1_base(0.0);	
				facturaproveedor.setret_fuente1_retenido(0.0);	
				facturaproveedor.setid_tipo_retencion_fuente2(-1L);	
				facturaproveedor.setret_fuente2_porcentaje(0.0);	
				facturaproveedor.setret_fuente2_base(0.0);	
				facturaproveedor.setret_fuente2_retenido(0.0);	
				facturaproveedor.setid_tipo_retencion_iva1(-1L);	
				facturaproveedor.setret_iva_bien_porcentaje(0.0);	
				facturaproveedor.setret_iva_bien_base(0.0);	
				facturaproveedor.setret_iva_bien_retenido(0.0);	
				facturaproveedor.setid_tipo_retencion_iva2(-1L);	
				facturaproveedor.setret_iva_servicio_porcentaje(0.0);	
				facturaproveedor.setret_iva_servicio_base(0.0);	
				facturaproveedor.setret_iva_servicio_retenido(0.0);	
				facturaproveedor.setanexo_numero_autorizacion("");	
				facturaproveedor.setanexo_numeso_serie("");	
				facturaproveedor.setanexo_fecha_validez(new Date());	
				facturaproveedor.setid_tipo_tributario(-1L);	
				facturaproveedor.setanexo_factura_inicio("");	
				facturaproveedor.setanexo_factura_fin("");	
				facturaproveedor.setid_cuenta_contable_credito_fiscal_bienes(-1L);	
				facturaproveedor.setid_responsable_fondo(-1L);	
				facturaproveedor.setid_cuenta_contable_credito_fiscal_servicios(-1L);	
				facturaproveedor.setsecuencial("");	
				facturaproveedor.setid_cuenta_contable_gasto(-1L);	
				facturaproveedor.setgasto_valor(0.0);	
				facturaproveedor.setid_cuenta_contable_gasto2(-1L);	
				facturaproveedor.setgasto_valor2(0.0);	
				facturaproveedor.setgasto_nombre(null);	
				facturaproveedor.setgasto_nombre2(null);	
				facturaproveedor.setid_cuenta_contable_credito_fin(null);	
				facturaproveedor.setid_cuenta_contable_credito_fin2(null);	
				facturaproveedor.setid_cuenta_contable_credito(null);	
				facturaproveedor.setdescripcion("");	
				facturaproveedor.setid_tipo_movimiento(null);	
				facturaproveedor.setid_tipo_movimiento_modulo(null);	
				facturaproveedor.setid_tipo_transaccion_modulo(null);	
				facturaproveedor.setnumero_mayor("");	
				facturaproveedor.setcodigo_asiento("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderFacturaProveedor(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_IDMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_IDPLANTILLAFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_IDTIPODOCUMENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_PLAZO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_IDFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_NUMEROFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_IDTRANSACCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_RUC);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_IDEMPLEADOSOLICITA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_FECHAVENCE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_IDMONEDA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_CONACTIVOS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_CONRISE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_CONSITIOS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_DETALLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_VALORBIENES12);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_VALORSERVICIOS12);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_TOTALVALOR12);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_VALORBIENES0);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_VALORSERVICIOS0);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_TOTALVALOR0);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_BIENESICE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_SERVICIOSICE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_TOTALICE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_BIENESIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_SERVICIOSIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_TOTALIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_IVAPORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_CONMONTOOBJETOIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_NUMERORETENCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_NUMEROSERIE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_NUMEROAUTORIZACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_FECHAVALIDEZ);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_IDTIPORETENCIONFUENTE1);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_RETFUENTE1PORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_RETFUENTE1BASE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_RETFUENTE1RETENIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_IDTIPORETENCIONFUENTE2);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_RETFUENTE2PORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_RETFUENTE2BASE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_RETFUENTE2RETENIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_IDTIPORETENCIONIVA1);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_RETIVABIENPORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_RETIVABIENBASE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_RETIVABIENRETENIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_IDTIPORETENCIONIVA2);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_RETIVASERVICIOPORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_RETIVASERVICIOBASE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_RETIVASERVICIORETENIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_ANEXONUMEROAUTORIZACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_ANEXONUMESOSERIE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_ANEXOFECHAVALIDEZ);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_IDTIPOTRIBUTARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_ANEXOFACTURAINICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_ANEXOFACTURAFIN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_IDCUENTACONTABLECREDITOFISCALBIENES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_IDRESPONSABLEFONDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_IDCUENTACONTABLECREDITOFISCALSERVICIOS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_SECUENCIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_IDCUENTACONTABLEGASTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_GASTOVALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_IDCUENTACONTABLEGASTO2);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_GASTOVALOR2);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_GASTONOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_GASTONOMBRE2);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_IDCUENTACONTABLECREDITOFIN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_IDCUENTACONTABLECREDITOFIN2);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_IDTIPOMOVIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_IDTIPOMOVIMIENTOMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_NUMEROMAYOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorConstantesFunciones.LABEL_CODIGOASIENTO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataFacturaProveedor(String sTipo,Row row,Workbook workbook,FacturaProveedor facturaproveedor,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.getmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.getplantillafactura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.gettipodocumento_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.getplazo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.getfactura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.getnumero_factura());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.gettransaccion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.getruc());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.getempleadosolicita_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.getfecha_vence());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.getmoneda_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(facturaproveedor.getcon_activos()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(facturaproveedor.getcon_rise()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(facturaproveedor.getcon_sitios()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.getdetalle());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.getvalor_bienes12());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.getvalor_servicios12());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.gettotal_valor12());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.getvalor_bienes0());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.getvalor_servicios0());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.gettotal_valor0());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.getbienes_ice());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.getservicios_ice());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.gettotal_ice());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.getbienes_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.getservicios_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.gettotal_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.getiva_porcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(facturaproveedor.getcon_monto_objeto_iva()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.getnumero_retencion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.getnumero_serie());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.getnumero_autorizacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.getfecha_validez());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.gettiporetencionfuente1_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.getret_fuente1_porcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.getret_fuente1_base());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.getret_fuente1_retenido());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.gettiporetencionfuente2_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.getret_fuente2_porcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.getret_fuente2_base());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.getret_fuente2_retenido());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.gettiporetencioniva1_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.getret_iva_bien_porcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.getret_iva_bien_base());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.getret_iva_bien_retenido());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.gettiporetencioniva2_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.getret_iva_servicio_porcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.getret_iva_servicio_base());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.getret_iva_servicio_retenido());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.getanexo_numero_autorizacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.getanexo_numeso_serie());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.getanexo_fecha_validez());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.gettipotributario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.getanexo_factura_inicio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.getanexo_factura_fin());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.getcuentacontablecreditofiscalbienes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.getresponsablefondo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.getcuentacontablecreditofiscalservicios_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.getsecuencial());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.getcuentacontablegasto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.getgasto_valor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.getcuentacontablegasto2_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.getgasto_valor2());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.getgasto_nombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.getgasto_nombre2());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.getcuentacontablecreditofin_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.getcuentacontablecreditofin2_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.getcuentacontablecredito_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.gettipomovimiento_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.gettipomovimientomodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.gettipotransaccionmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.getnumero_mayor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedor.getcodigo_asiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryFacturaProveedor=Constantes.SFINALQUERY;
	
	public String getsFinalQueryFacturaProveedor() {
		return this.sFinalQueryFacturaProveedor;
	}
	
	public void setsFinalQueryFacturaProveedor(String sFinalQueryFacturaProveedor) {
		this.sFinalQueryFacturaProveedor= sFinalQueryFacturaProveedor;
	}
	
	public Border resaltarSeleccionarFacturaProveedor=null;
	
	public Border setResaltarSeleccionarFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarSeleccionarFacturaProveedor= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarFacturaProveedor() {
		return this.resaltarSeleccionarFacturaProveedor;
	}
	
	public void setResaltarSeleccionarFacturaProveedor(Border borderResaltarSeleccionarFacturaProveedor) {
		this.resaltarSeleccionarFacturaProveedor= borderResaltarSeleccionarFacturaProveedor;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridFacturaProveedor=null;
	public Boolean mostraridFacturaProveedor=true;
	public Boolean activaridFacturaProveedor=true;

	public Border resaltarid_empresaFacturaProveedor=null;
	public Boolean mostrarid_empresaFacturaProveedor=true;
	public Boolean activarid_empresaFacturaProveedor=true;
	public Boolean cargarid_empresaFacturaProveedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaFacturaProveedor=false;//ConEventDepend=true

	public Border resaltarid_sucursalFacturaProveedor=null;
	public Boolean mostrarid_sucursalFacturaProveedor=true;
	public Boolean activarid_sucursalFacturaProveedor=true;
	public Boolean cargarid_sucursalFacturaProveedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalFacturaProveedor=false;//ConEventDepend=true

	public Border resaltarid_ejercicioFacturaProveedor=null;
	public Boolean mostrarid_ejercicioFacturaProveedor=true;
	public Boolean activarid_ejercicioFacturaProveedor=true;
	public Boolean cargarid_ejercicioFacturaProveedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioFacturaProveedor=false;//ConEventDepend=true

	public Border resaltarid_periodoFacturaProveedor=null;
	public Boolean mostrarid_periodoFacturaProveedor=true;
	public Boolean activarid_periodoFacturaProveedor=true;
	public Boolean cargarid_periodoFacturaProveedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoFacturaProveedor=false;//ConEventDepend=true

	public Border resaltarid_anioFacturaProveedor=null;
	public Boolean mostrarid_anioFacturaProveedor=true;
	public Boolean activarid_anioFacturaProveedor=false;
	public Boolean cargarid_anioFacturaProveedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioFacturaProveedor=false;//ConEventDepend=true

	public Border resaltarid_mesFacturaProveedor=null;
	public Boolean mostrarid_mesFacturaProveedor=true;
	public Boolean activarid_mesFacturaProveedor=false;
	public Boolean cargarid_mesFacturaProveedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesFacturaProveedor=false;//ConEventDepend=true

	public Border resaltarid_moduloFacturaProveedor=null;
	public Boolean mostrarid_moduloFacturaProveedor=true;
	public Boolean activarid_moduloFacturaProveedor=true;
	public Boolean cargarid_moduloFacturaProveedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_moduloFacturaProveedor=false;//ConEventDepend=true

	public Border resaltarid_plantilla_facturaFacturaProveedor=null;
	public Boolean mostrarid_plantilla_facturaFacturaProveedor=true;
	public Boolean activarid_plantilla_facturaFacturaProveedor=true;
	public Boolean cargarid_plantilla_facturaFacturaProveedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_plantilla_facturaFacturaProveedor=false;//ConEventDepend=true

	public Border resaltarid_tipo_documentoFacturaProveedor=null;
	public Boolean mostrarid_tipo_documentoFacturaProveedor=true;
	public Boolean activarid_tipo_documentoFacturaProveedor=true;
	public Boolean cargarid_tipo_documentoFacturaProveedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_documentoFacturaProveedor=false;//ConEventDepend=true

	public Border resaltarplazoFacturaProveedor=null;
	public Boolean mostrarplazoFacturaProveedor=true;
	public Boolean activarplazoFacturaProveedor=true;

	public Border resaltarid_facturaFacturaProveedor=null;
	public Boolean mostrarid_facturaFacturaProveedor=true;
	public Boolean activarid_facturaFacturaProveedor=true;
	public Boolean cargarid_facturaFacturaProveedor=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_facturaFacturaProveedor=false;//ConEventDepend=true

	public Border resaltarnumero_facturaFacturaProveedor=null;
	public Boolean mostrarnumero_facturaFacturaProveedor=true;
	public Boolean activarnumero_facturaFacturaProveedor=false;

	public Border resaltarid_transaccionFacturaProveedor=null;
	public Boolean mostrarid_transaccionFacturaProveedor=true;
	public Boolean activarid_transaccionFacturaProveedor=true;
	public Boolean cargarid_transaccionFacturaProveedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccionFacturaProveedor=false;//ConEventDepend=true

	public Border resaltarfecha_emisionFacturaProveedor=null;
	public Boolean mostrarfecha_emisionFacturaProveedor=true;
	public Boolean activarfecha_emisionFacturaProveedor=true;

	public Border resaltarid_clienteFacturaProveedor=null;
	public Boolean mostrarid_clienteFacturaProveedor=true;
	public Boolean activarid_clienteFacturaProveedor=true;
	public Boolean cargarid_clienteFacturaProveedor=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteFacturaProveedor=false;//ConEventDepend=true

	public Border resaltarrucFacturaProveedor=null;
	public Boolean mostrarrucFacturaProveedor=true;
	public Boolean activarrucFacturaProveedor=false;

	public Border resaltarid_empleado_solicitaFacturaProveedor=null;
	public Boolean mostrarid_empleado_solicitaFacturaProveedor=true;
	public Boolean activarid_empleado_solicitaFacturaProveedor=true;
	public Boolean cargarid_empleado_solicitaFacturaProveedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleado_solicitaFacturaProveedor=false;//ConEventDepend=true

	public Border resaltarfecha_venceFacturaProveedor=null;
	public Boolean mostrarfecha_venceFacturaProveedor=true;
	public Boolean activarfecha_venceFacturaProveedor=false;

	public Border resaltarid_monedaFacturaProveedor=null;
	public Boolean mostrarid_monedaFacturaProveedor=true;
	public Boolean activarid_monedaFacturaProveedor=true;
	public Boolean cargarid_monedaFacturaProveedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_monedaFacturaProveedor=false;//ConEventDepend=true

	public Border resaltarid_empleadoFacturaProveedor=null;
	public Boolean mostrarid_empleadoFacturaProveedor=true;
	public Boolean activarid_empleadoFacturaProveedor=true;
	public Boolean cargarid_empleadoFacturaProveedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoFacturaProveedor=false;//ConEventDepend=true

	public Border resaltarcon_activosFacturaProveedor=null;
	public Boolean mostrarcon_activosFacturaProveedor=true;
	public Boolean activarcon_activosFacturaProveedor=true;

	public Border resaltarcon_riseFacturaProveedor=null;
	public Boolean mostrarcon_riseFacturaProveedor=true;
	public Boolean activarcon_riseFacturaProveedor=true;

	public Border resaltarcon_sitiosFacturaProveedor=null;
	public Boolean mostrarcon_sitiosFacturaProveedor=true;
	public Boolean activarcon_sitiosFacturaProveedor=true;

	public Border resaltardetalleFacturaProveedor=null;
	public Boolean mostrardetalleFacturaProveedor=true;
	public Boolean activardetalleFacturaProveedor=true;

	public Border resaltarvalor_bienes12FacturaProveedor=null;
	public Boolean mostrarvalor_bienes12FacturaProveedor=true;
	public Boolean activarvalor_bienes12FacturaProveedor=true;

	public Border resaltarvalor_servicios12FacturaProveedor=null;
	public Boolean mostrarvalor_servicios12FacturaProveedor=true;
	public Boolean activarvalor_servicios12FacturaProveedor=true;

	public Border resaltartotal_valor12FacturaProveedor=null;
	public Boolean mostrartotal_valor12FacturaProveedor=true;
	public Boolean activartotal_valor12FacturaProveedor=true;

	public Border resaltarvalor_bienes0FacturaProveedor=null;
	public Boolean mostrarvalor_bienes0FacturaProveedor=true;
	public Boolean activarvalor_bienes0FacturaProveedor=true;

	public Border resaltarvalor_servicios0FacturaProveedor=null;
	public Boolean mostrarvalor_servicios0FacturaProveedor=true;
	public Boolean activarvalor_servicios0FacturaProveedor=true;

	public Border resaltartotal_valor0FacturaProveedor=null;
	public Boolean mostrartotal_valor0FacturaProveedor=true;
	public Boolean activartotal_valor0FacturaProveedor=true;

	public Border resaltarbienes_iceFacturaProveedor=null;
	public Boolean mostrarbienes_iceFacturaProveedor=true;
	public Boolean activarbienes_iceFacturaProveedor=true;

	public Border resaltarservicios_iceFacturaProveedor=null;
	public Boolean mostrarservicios_iceFacturaProveedor=true;
	public Boolean activarservicios_iceFacturaProveedor=true;

	public Border resaltartotal_iceFacturaProveedor=null;
	public Boolean mostrartotal_iceFacturaProveedor=true;
	public Boolean activartotal_iceFacturaProveedor=true;

	public Border resaltarbienes_ivaFacturaProveedor=null;
	public Boolean mostrarbienes_ivaFacturaProveedor=true;
	public Boolean activarbienes_ivaFacturaProveedor=true;

	public Border resaltarservicios_ivaFacturaProveedor=null;
	public Boolean mostrarservicios_ivaFacturaProveedor=true;
	public Boolean activarservicios_ivaFacturaProveedor=true;

	public Border resaltartotal_ivaFacturaProveedor=null;
	public Boolean mostrartotal_ivaFacturaProveedor=true;
	public Boolean activartotal_ivaFacturaProveedor=true;

	public Border resaltariva_porcentajeFacturaProveedor=null;
	public Boolean mostrariva_porcentajeFacturaProveedor=true;
	public Boolean activariva_porcentajeFacturaProveedor=true;

	public Border resaltartotalFacturaProveedor=null;
	public Boolean mostrartotalFacturaProveedor=true;
	public Boolean activartotalFacturaProveedor=true;

	public Border resaltarcon_monto_objeto_ivaFacturaProveedor=null;
	public Boolean mostrarcon_monto_objeto_ivaFacturaProveedor=true;
	public Boolean activarcon_monto_objeto_ivaFacturaProveedor=true;

	public Border resaltarnumero_retencionFacturaProveedor=null;
	public Boolean mostrarnumero_retencionFacturaProveedor=true;
	public Boolean activarnumero_retencionFacturaProveedor=true;

	public Border resaltarnumero_serieFacturaProveedor=null;
	public Boolean mostrarnumero_serieFacturaProveedor=true;
	public Boolean activarnumero_serieFacturaProveedor=true;

	public Border resaltarnumero_autorizacionFacturaProveedor=null;
	public Boolean mostrarnumero_autorizacionFacturaProveedor=true;
	public Boolean activarnumero_autorizacionFacturaProveedor=true;

	public Border resaltarfecha_validezFacturaProveedor=null;
	public Boolean mostrarfecha_validezFacturaProveedor=true;
	public Boolean activarfecha_validezFacturaProveedor=true;

	public Border resaltarid_tipo_retencion_fuente1FacturaProveedor=null;
	public Boolean mostrarid_tipo_retencion_fuente1FacturaProveedor=true;
	public Boolean activarid_tipo_retencion_fuente1FacturaProveedor=true;
	public Boolean cargarid_tipo_retencion_fuente1FacturaProveedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_retencion_fuente1FacturaProveedor=false;//ConEventDepend=true

	public Border resaltarret_fuente1_porcentajeFacturaProveedor=null;
	public Boolean mostrarret_fuente1_porcentajeFacturaProveedor=true;
	public Boolean activarret_fuente1_porcentajeFacturaProveedor=true;

	public Border resaltarret_fuente1_baseFacturaProveedor=null;
	public Boolean mostrarret_fuente1_baseFacturaProveedor=true;
	public Boolean activarret_fuente1_baseFacturaProveedor=true;

	public Border resaltarret_fuente1_retenidoFacturaProveedor=null;
	public Boolean mostrarret_fuente1_retenidoFacturaProveedor=true;
	public Boolean activarret_fuente1_retenidoFacturaProveedor=true;

	public Border resaltarid_tipo_retencion_fuente2FacturaProveedor=null;
	public Boolean mostrarid_tipo_retencion_fuente2FacturaProveedor=true;
	public Boolean activarid_tipo_retencion_fuente2FacturaProveedor=true;
	public Boolean cargarid_tipo_retencion_fuente2FacturaProveedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_retencion_fuente2FacturaProveedor=false;//ConEventDepend=true

	public Border resaltarret_fuente2_porcentajeFacturaProveedor=null;
	public Boolean mostrarret_fuente2_porcentajeFacturaProveedor=true;
	public Boolean activarret_fuente2_porcentajeFacturaProveedor=true;

	public Border resaltarret_fuente2_baseFacturaProveedor=null;
	public Boolean mostrarret_fuente2_baseFacturaProveedor=true;
	public Boolean activarret_fuente2_baseFacturaProveedor=true;

	public Border resaltarret_fuente2_retenidoFacturaProveedor=null;
	public Boolean mostrarret_fuente2_retenidoFacturaProveedor=true;
	public Boolean activarret_fuente2_retenidoFacturaProveedor=true;

	public Border resaltarid_tipo_retencion_iva1FacturaProveedor=null;
	public Boolean mostrarid_tipo_retencion_iva1FacturaProveedor=true;
	public Boolean activarid_tipo_retencion_iva1FacturaProveedor=true;
	public Boolean cargarid_tipo_retencion_iva1FacturaProveedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_retencion_iva1FacturaProveedor=false;//ConEventDepend=true

	public Border resaltarret_iva_bien_porcentajeFacturaProveedor=null;
	public Boolean mostrarret_iva_bien_porcentajeFacturaProveedor=true;
	public Boolean activarret_iva_bien_porcentajeFacturaProveedor=true;

	public Border resaltarret_iva_bien_baseFacturaProveedor=null;
	public Boolean mostrarret_iva_bien_baseFacturaProveedor=true;
	public Boolean activarret_iva_bien_baseFacturaProveedor=true;

	public Border resaltarret_iva_bien_retenidoFacturaProveedor=null;
	public Boolean mostrarret_iva_bien_retenidoFacturaProveedor=true;
	public Boolean activarret_iva_bien_retenidoFacturaProveedor=true;

	public Border resaltarid_tipo_retencion_iva2FacturaProveedor=null;
	public Boolean mostrarid_tipo_retencion_iva2FacturaProveedor=true;
	public Boolean activarid_tipo_retencion_iva2FacturaProveedor=true;
	public Boolean cargarid_tipo_retencion_iva2FacturaProveedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_retencion_iva2FacturaProveedor=false;//ConEventDepend=true

	public Border resaltarret_iva_servicio_porcentajeFacturaProveedor=null;
	public Boolean mostrarret_iva_servicio_porcentajeFacturaProveedor=true;
	public Boolean activarret_iva_servicio_porcentajeFacturaProveedor=true;

	public Border resaltarret_iva_servicio_baseFacturaProveedor=null;
	public Boolean mostrarret_iva_servicio_baseFacturaProveedor=true;
	public Boolean activarret_iva_servicio_baseFacturaProveedor=true;

	public Border resaltarret_iva_servicio_retenidoFacturaProveedor=null;
	public Boolean mostrarret_iva_servicio_retenidoFacturaProveedor=true;
	public Boolean activarret_iva_servicio_retenidoFacturaProveedor=true;

	public Border resaltaranexo_numero_autorizacionFacturaProveedor=null;
	public Boolean mostraranexo_numero_autorizacionFacturaProveedor=true;
	public Boolean activaranexo_numero_autorizacionFacturaProveedor=true;

	public Border resaltaranexo_numeso_serieFacturaProveedor=null;
	public Boolean mostraranexo_numeso_serieFacturaProveedor=true;
	public Boolean activaranexo_numeso_serieFacturaProveedor=true;

	public Border resaltaranexo_fecha_validezFacturaProveedor=null;
	public Boolean mostraranexo_fecha_validezFacturaProveedor=true;
	public Boolean activaranexo_fecha_validezFacturaProveedor=true;

	public Border resaltarid_tipo_tributarioFacturaProveedor=null;
	public Boolean mostrarid_tipo_tributarioFacturaProveedor=true;
	public Boolean activarid_tipo_tributarioFacturaProveedor=true;
	public Boolean cargarid_tipo_tributarioFacturaProveedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_tributarioFacturaProveedor=false;//ConEventDepend=true

	public Border resaltaranexo_factura_inicioFacturaProveedor=null;
	public Boolean mostraranexo_factura_inicioFacturaProveedor=true;
	public Boolean activaranexo_factura_inicioFacturaProveedor=true;

	public Border resaltaranexo_factura_finFacturaProveedor=null;
	public Boolean mostraranexo_factura_finFacturaProveedor=true;
	public Boolean activaranexo_factura_finFacturaProveedor=true;

	public Border resaltarid_cuenta_contable_credito_fiscal_bienesFacturaProveedor=null;
	public Boolean mostrarid_cuenta_contable_credito_fiscal_bienesFacturaProveedor=true;
	public Boolean activarid_cuenta_contable_credito_fiscal_bienesFacturaProveedor=true;
	public Boolean cargarid_cuenta_contable_credito_fiscal_bienesFacturaProveedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_credito_fiscal_bienesFacturaProveedor=false;//ConEventDepend=true

	public Border resaltarid_responsable_fondoFacturaProveedor=null;
	public Boolean mostrarid_responsable_fondoFacturaProveedor=true;
	public Boolean activarid_responsable_fondoFacturaProveedor=true;
	public Boolean cargarid_responsable_fondoFacturaProveedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_responsable_fondoFacturaProveedor=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_credito_fiscal_serviciosFacturaProveedor=null;
	public Boolean mostrarid_cuenta_contable_credito_fiscal_serviciosFacturaProveedor=true;
	public Boolean activarid_cuenta_contable_credito_fiscal_serviciosFacturaProveedor=true;
	public Boolean cargarid_cuenta_contable_credito_fiscal_serviciosFacturaProveedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_credito_fiscal_serviciosFacturaProveedor=false;//ConEventDepend=true

	public Border resaltarsecuencialFacturaProveedor=null;
	public Boolean mostrarsecuencialFacturaProveedor=true;
	public Boolean activarsecuencialFacturaProveedor=true;

	public Border resaltarid_cuenta_contable_gastoFacturaProveedor=null;
	public Boolean mostrarid_cuenta_contable_gastoFacturaProveedor=true;
	public Boolean activarid_cuenta_contable_gastoFacturaProveedor=true;
	public Boolean cargarid_cuenta_contable_gastoFacturaProveedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_gastoFacturaProveedor=false;//ConEventDepend=true

	public Border resaltargasto_valorFacturaProveedor=null;
	public Boolean mostrargasto_valorFacturaProveedor=true;
	public Boolean activargasto_valorFacturaProveedor=true;

	public Border resaltarid_cuenta_contable_gasto2FacturaProveedor=null;
	public Boolean mostrarid_cuenta_contable_gasto2FacturaProveedor=true;
	public Boolean activarid_cuenta_contable_gasto2FacturaProveedor=true;
	public Boolean cargarid_cuenta_contable_gasto2FacturaProveedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_gasto2FacturaProveedor=false;//ConEventDepend=true

	public Border resaltargasto_valor2FacturaProveedor=null;
	public Boolean mostrargasto_valor2FacturaProveedor=true;
	public Boolean activargasto_valor2FacturaProveedor=true;

	public Border resaltargasto_nombreFacturaProveedor=null;
	public Boolean mostrargasto_nombreFacturaProveedor=true;
	public Boolean activargasto_nombreFacturaProveedor=false;

	public Border resaltargasto_nombre2FacturaProveedor=null;
	public Boolean mostrargasto_nombre2FacturaProveedor=true;
	public Boolean activargasto_nombre2FacturaProveedor=false;

	public Border resaltarid_cuenta_contable_credito_finFacturaProveedor=null;
	public Boolean mostrarid_cuenta_contable_credito_finFacturaProveedor=true;
	public Boolean activarid_cuenta_contable_credito_finFacturaProveedor=false;
	public Boolean cargarid_cuenta_contable_credito_finFacturaProveedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_credito_finFacturaProveedor=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_credito_fin2FacturaProveedor=null;
	public Boolean mostrarid_cuenta_contable_credito_fin2FacturaProveedor=true;
	public Boolean activarid_cuenta_contable_credito_fin2FacturaProveedor=false;
	public Boolean cargarid_cuenta_contable_credito_fin2FacturaProveedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_credito_fin2FacturaProveedor=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_creditoFacturaProveedor=null;
	public Boolean mostrarid_cuenta_contable_creditoFacturaProveedor=true;
	public Boolean activarid_cuenta_contable_creditoFacturaProveedor=false;
	public Boolean cargarid_cuenta_contable_creditoFacturaProveedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_creditoFacturaProveedor=false;//ConEventDepend=true

	public Border resaltardescripcionFacturaProveedor=null;
	public Boolean mostrardescripcionFacturaProveedor=true;
	public Boolean activardescripcionFacturaProveedor=false;

	public Border resaltarid_tipo_movimientoFacturaProveedor=null;
	public Boolean mostrarid_tipo_movimientoFacturaProveedor=true;
	public Boolean activarid_tipo_movimientoFacturaProveedor=false;
	public Boolean cargarid_tipo_movimientoFacturaProveedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_movimientoFacturaProveedor=false;//ConEventDepend=true

	public Border resaltarid_tipo_movimiento_moduloFacturaProveedor=null;
	public Boolean mostrarid_tipo_movimiento_moduloFacturaProveedor=true;
	public Boolean activarid_tipo_movimiento_moduloFacturaProveedor=false;
	public Boolean cargarid_tipo_movimiento_moduloFacturaProveedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_movimiento_moduloFacturaProveedor=false;//ConEventDepend=true

	public Border resaltarid_tipo_transaccion_moduloFacturaProveedor=null;
	public Boolean mostrarid_tipo_transaccion_moduloFacturaProveedor=true;
	public Boolean activarid_tipo_transaccion_moduloFacturaProveedor=false;
	public Boolean cargarid_tipo_transaccion_moduloFacturaProveedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_transaccion_moduloFacturaProveedor=false;//ConEventDepend=true

	public Border resaltarnumero_mayorFacturaProveedor=null;
	public Boolean mostrarnumero_mayorFacturaProveedor=true;
	public Boolean activarnumero_mayorFacturaProveedor=false;

	public Border resaltarcodigo_asientoFacturaProveedor=null;
	public Boolean mostrarcodigo_asientoFacturaProveedor=true;
	public Boolean activarcodigo_asientoFacturaProveedor=false;

	
	

	public Border setResaltaridFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltaridFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridFacturaProveedor() {
		return this.resaltaridFacturaProveedor;
	}

	public void setResaltaridFacturaProveedor(Border borderResaltar) {
		this.resaltaridFacturaProveedor= borderResaltar;
	}

	public Boolean getMostraridFacturaProveedor() {
		return this.mostraridFacturaProveedor;
	}

	public void setMostraridFacturaProveedor(Boolean mostraridFacturaProveedor) {
		this.mostraridFacturaProveedor= mostraridFacturaProveedor;
	}

	public Boolean getActivaridFacturaProveedor() {
		return this.activaridFacturaProveedor;
	}

	public void setActivaridFacturaProveedor(Boolean activaridFacturaProveedor) {
		this.activaridFacturaProveedor= activaridFacturaProveedor;
	}

	public Border setResaltarid_empresaFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarid_empresaFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaFacturaProveedor() {
		return this.resaltarid_empresaFacturaProveedor;
	}

	public void setResaltarid_empresaFacturaProveedor(Border borderResaltar) {
		this.resaltarid_empresaFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarid_empresaFacturaProveedor() {
		return this.mostrarid_empresaFacturaProveedor;
	}

	public void setMostrarid_empresaFacturaProveedor(Boolean mostrarid_empresaFacturaProveedor) {
		this.mostrarid_empresaFacturaProveedor= mostrarid_empresaFacturaProveedor;
	}

	public Boolean getActivarid_empresaFacturaProveedor() {
		return this.activarid_empresaFacturaProveedor;
	}

	public void setActivarid_empresaFacturaProveedor(Boolean activarid_empresaFacturaProveedor) {
		this.activarid_empresaFacturaProveedor= activarid_empresaFacturaProveedor;
	}

	public Boolean getCargarid_empresaFacturaProveedor() {
		return this.cargarid_empresaFacturaProveedor;
	}

	public void setCargarid_empresaFacturaProveedor(Boolean cargarid_empresaFacturaProveedor) {
		this.cargarid_empresaFacturaProveedor= cargarid_empresaFacturaProveedor;
	}

	public Border setResaltarid_sucursalFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarid_sucursalFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalFacturaProveedor() {
		return this.resaltarid_sucursalFacturaProveedor;
	}

	public void setResaltarid_sucursalFacturaProveedor(Border borderResaltar) {
		this.resaltarid_sucursalFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarid_sucursalFacturaProveedor() {
		return this.mostrarid_sucursalFacturaProveedor;
	}

	public void setMostrarid_sucursalFacturaProveedor(Boolean mostrarid_sucursalFacturaProveedor) {
		this.mostrarid_sucursalFacturaProveedor= mostrarid_sucursalFacturaProveedor;
	}

	public Boolean getActivarid_sucursalFacturaProveedor() {
		return this.activarid_sucursalFacturaProveedor;
	}

	public void setActivarid_sucursalFacturaProveedor(Boolean activarid_sucursalFacturaProveedor) {
		this.activarid_sucursalFacturaProveedor= activarid_sucursalFacturaProveedor;
	}

	public Boolean getCargarid_sucursalFacturaProveedor() {
		return this.cargarid_sucursalFacturaProveedor;
	}

	public void setCargarid_sucursalFacturaProveedor(Boolean cargarid_sucursalFacturaProveedor) {
		this.cargarid_sucursalFacturaProveedor= cargarid_sucursalFacturaProveedor;
	}

	public Border setResaltarid_ejercicioFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioFacturaProveedor() {
		return this.resaltarid_ejercicioFacturaProveedor;
	}

	public void setResaltarid_ejercicioFacturaProveedor(Border borderResaltar) {
		this.resaltarid_ejercicioFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioFacturaProveedor() {
		return this.mostrarid_ejercicioFacturaProveedor;
	}

	public void setMostrarid_ejercicioFacturaProveedor(Boolean mostrarid_ejercicioFacturaProveedor) {
		this.mostrarid_ejercicioFacturaProveedor= mostrarid_ejercicioFacturaProveedor;
	}

	public Boolean getActivarid_ejercicioFacturaProveedor() {
		return this.activarid_ejercicioFacturaProveedor;
	}

	public void setActivarid_ejercicioFacturaProveedor(Boolean activarid_ejercicioFacturaProveedor) {
		this.activarid_ejercicioFacturaProveedor= activarid_ejercicioFacturaProveedor;
	}

	public Boolean getCargarid_ejercicioFacturaProveedor() {
		return this.cargarid_ejercicioFacturaProveedor;
	}

	public void setCargarid_ejercicioFacturaProveedor(Boolean cargarid_ejercicioFacturaProveedor) {
		this.cargarid_ejercicioFacturaProveedor= cargarid_ejercicioFacturaProveedor;
	}

	public Border setResaltarid_periodoFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarid_periodoFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoFacturaProveedor() {
		return this.resaltarid_periodoFacturaProveedor;
	}

	public void setResaltarid_periodoFacturaProveedor(Border borderResaltar) {
		this.resaltarid_periodoFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarid_periodoFacturaProveedor() {
		return this.mostrarid_periodoFacturaProveedor;
	}

	public void setMostrarid_periodoFacturaProveedor(Boolean mostrarid_periodoFacturaProveedor) {
		this.mostrarid_periodoFacturaProveedor= mostrarid_periodoFacturaProveedor;
	}

	public Boolean getActivarid_periodoFacturaProveedor() {
		return this.activarid_periodoFacturaProveedor;
	}

	public void setActivarid_periodoFacturaProveedor(Boolean activarid_periodoFacturaProveedor) {
		this.activarid_periodoFacturaProveedor= activarid_periodoFacturaProveedor;
	}

	public Boolean getCargarid_periodoFacturaProveedor() {
		return this.cargarid_periodoFacturaProveedor;
	}

	public void setCargarid_periodoFacturaProveedor(Boolean cargarid_periodoFacturaProveedor) {
		this.cargarid_periodoFacturaProveedor= cargarid_periodoFacturaProveedor;
	}

	public Border setResaltarid_anioFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarid_anioFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioFacturaProveedor() {
		return this.resaltarid_anioFacturaProveedor;
	}

	public void setResaltarid_anioFacturaProveedor(Border borderResaltar) {
		this.resaltarid_anioFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarid_anioFacturaProveedor() {
		return this.mostrarid_anioFacturaProveedor;
	}

	public void setMostrarid_anioFacturaProveedor(Boolean mostrarid_anioFacturaProveedor) {
		this.mostrarid_anioFacturaProveedor= mostrarid_anioFacturaProveedor;
	}

	public Boolean getActivarid_anioFacturaProveedor() {
		return this.activarid_anioFacturaProveedor;
	}

	public void setActivarid_anioFacturaProveedor(Boolean activarid_anioFacturaProveedor) {
		this.activarid_anioFacturaProveedor= activarid_anioFacturaProveedor;
	}

	public Boolean getCargarid_anioFacturaProveedor() {
		return this.cargarid_anioFacturaProveedor;
	}

	public void setCargarid_anioFacturaProveedor(Boolean cargarid_anioFacturaProveedor) {
		this.cargarid_anioFacturaProveedor= cargarid_anioFacturaProveedor;
	}

	public Border setResaltarid_mesFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarid_mesFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesFacturaProveedor() {
		return this.resaltarid_mesFacturaProveedor;
	}

	public void setResaltarid_mesFacturaProveedor(Border borderResaltar) {
		this.resaltarid_mesFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarid_mesFacturaProveedor() {
		return this.mostrarid_mesFacturaProveedor;
	}

	public void setMostrarid_mesFacturaProveedor(Boolean mostrarid_mesFacturaProveedor) {
		this.mostrarid_mesFacturaProveedor= mostrarid_mesFacturaProveedor;
	}

	public Boolean getActivarid_mesFacturaProveedor() {
		return this.activarid_mesFacturaProveedor;
	}

	public void setActivarid_mesFacturaProveedor(Boolean activarid_mesFacturaProveedor) {
		this.activarid_mesFacturaProveedor= activarid_mesFacturaProveedor;
	}

	public Boolean getCargarid_mesFacturaProveedor() {
		return this.cargarid_mesFacturaProveedor;
	}

	public void setCargarid_mesFacturaProveedor(Boolean cargarid_mesFacturaProveedor) {
		this.cargarid_mesFacturaProveedor= cargarid_mesFacturaProveedor;
	}

	public Border setResaltarid_moduloFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarid_moduloFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_moduloFacturaProveedor() {
		return this.resaltarid_moduloFacturaProveedor;
	}

	public void setResaltarid_moduloFacturaProveedor(Border borderResaltar) {
		this.resaltarid_moduloFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarid_moduloFacturaProveedor() {
		return this.mostrarid_moduloFacturaProveedor;
	}

	public void setMostrarid_moduloFacturaProveedor(Boolean mostrarid_moduloFacturaProveedor) {
		this.mostrarid_moduloFacturaProveedor= mostrarid_moduloFacturaProveedor;
	}

	public Boolean getActivarid_moduloFacturaProveedor() {
		return this.activarid_moduloFacturaProveedor;
	}

	public void setActivarid_moduloFacturaProveedor(Boolean activarid_moduloFacturaProveedor) {
		this.activarid_moduloFacturaProveedor= activarid_moduloFacturaProveedor;
	}

	public Boolean getCargarid_moduloFacturaProveedor() {
		return this.cargarid_moduloFacturaProveedor;
	}

	public void setCargarid_moduloFacturaProveedor(Boolean cargarid_moduloFacturaProveedor) {
		this.cargarid_moduloFacturaProveedor= cargarid_moduloFacturaProveedor;
	}

	public Border setResaltarid_plantilla_facturaFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarid_plantilla_facturaFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_plantilla_facturaFacturaProveedor() {
		return this.resaltarid_plantilla_facturaFacturaProveedor;
	}

	public void setResaltarid_plantilla_facturaFacturaProveedor(Border borderResaltar) {
		this.resaltarid_plantilla_facturaFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarid_plantilla_facturaFacturaProveedor() {
		return this.mostrarid_plantilla_facturaFacturaProveedor;
	}

	public void setMostrarid_plantilla_facturaFacturaProveedor(Boolean mostrarid_plantilla_facturaFacturaProveedor) {
		this.mostrarid_plantilla_facturaFacturaProveedor= mostrarid_plantilla_facturaFacturaProveedor;
	}

	public Boolean getActivarid_plantilla_facturaFacturaProveedor() {
		return this.activarid_plantilla_facturaFacturaProveedor;
	}

	public void setActivarid_plantilla_facturaFacturaProveedor(Boolean activarid_plantilla_facturaFacturaProveedor) {
		this.activarid_plantilla_facturaFacturaProveedor= activarid_plantilla_facturaFacturaProveedor;
	}

	public Boolean getCargarid_plantilla_facturaFacturaProveedor() {
		return this.cargarid_plantilla_facturaFacturaProveedor;
	}

	public void setCargarid_plantilla_facturaFacturaProveedor(Boolean cargarid_plantilla_facturaFacturaProveedor) {
		this.cargarid_plantilla_facturaFacturaProveedor= cargarid_plantilla_facturaFacturaProveedor;
	}

	public Border setResaltarid_tipo_documentoFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarid_tipo_documentoFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_documentoFacturaProveedor() {
		return this.resaltarid_tipo_documentoFacturaProveedor;
	}

	public void setResaltarid_tipo_documentoFacturaProveedor(Border borderResaltar) {
		this.resaltarid_tipo_documentoFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarid_tipo_documentoFacturaProveedor() {
		return this.mostrarid_tipo_documentoFacturaProveedor;
	}

	public void setMostrarid_tipo_documentoFacturaProveedor(Boolean mostrarid_tipo_documentoFacturaProveedor) {
		this.mostrarid_tipo_documentoFacturaProveedor= mostrarid_tipo_documentoFacturaProveedor;
	}

	public Boolean getActivarid_tipo_documentoFacturaProveedor() {
		return this.activarid_tipo_documentoFacturaProveedor;
	}

	public void setActivarid_tipo_documentoFacturaProveedor(Boolean activarid_tipo_documentoFacturaProveedor) {
		this.activarid_tipo_documentoFacturaProveedor= activarid_tipo_documentoFacturaProveedor;
	}

	public Boolean getCargarid_tipo_documentoFacturaProveedor() {
		return this.cargarid_tipo_documentoFacturaProveedor;
	}

	public void setCargarid_tipo_documentoFacturaProveedor(Boolean cargarid_tipo_documentoFacturaProveedor) {
		this.cargarid_tipo_documentoFacturaProveedor= cargarid_tipo_documentoFacturaProveedor;
	}

	public Border setResaltarplazoFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarplazoFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarplazoFacturaProveedor() {
		return this.resaltarplazoFacturaProveedor;
	}

	public void setResaltarplazoFacturaProveedor(Border borderResaltar) {
		this.resaltarplazoFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarplazoFacturaProveedor() {
		return this.mostrarplazoFacturaProveedor;
	}

	public void setMostrarplazoFacturaProveedor(Boolean mostrarplazoFacturaProveedor) {
		this.mostrarplazoFacturaProveedor= mostrarplazoFacturaProveedor;
	}

	public Boolean getActivarplazoFacturaProveedor() {
		return this.activarplazoFacturaProveedor;
	}

	public void setActivarplazoFacturaProveedor(Boolean activarplazoFacturaProveedor) {
		this.activarplazoFacturaProveedor= activarplazoFacturaProveedor;
	}

	public Border setResaltarid_facturaFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarid_facturaFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_facturaFacturaProveedor() {
		return this.resaltarid_facturaFacturaProveedor;
	}

	public void setResaltarid_facturaFacturaProveedor(Border borderResaltar) {
		this.resaltarid_facturaFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarid_facturaFacturaProveedor() {
		return this.mostrarid_facturaFacturaProveedor;
	}

	public void setMostrarid_facturaFacturaProveedor(Boolean mostrarid_facturaFacturaProveedor) {
		this.mostrarid_facturaFacturaProveedor= mostrarid_facturaFacturaProveedor;
	}

	public Boolean getActivarid_facturaFacturaProveedor() {
		return this.activarid_facturaFacturaProveedor;
	}

	public void setActivarid_facturaFacturaProveedor(Boolean activarid_facturaFacturaProveedor) {
		this.activarid_facturaFacturaProveedor= activarid_facturaFacturaProveedor;
	}

	public Boolean getCargarid_facturaFacturaProveedor() {
		return this.cargarid_facturaFacturaProveedor;
	}

	public void setCargarid_facturaFacturaProveedor(Boolean cargarid_facturaFacturaProveedor) {
		this.cargarid_facturaFacturaProveedor= cargarid_facturaFacturaProveedor;
	}

	public Border setResaltarnumero_facturaFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarnumero_facturaFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_facturaFacturaProveedor() {
		return this.resaltarnumero_facturaFacturaProveedor;
	}

	public void setResaltarnumero_facturaFacturaProveedor(Border borderResaltar) {
		this.resaltarnumero_facturaFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarnumero_facturaFacturaProveedor() {
		return this.mostrarnumero_facturaFacturaProveedor;
	}

	public void setMostrarnumero_facturaFacturaProveedor(Boolean mostrarnumero_facturaFacturaProveedor) {
		this.mostrarnumero_facturaFacturaProveedor= mostrarnumero_facturaFacturaProveedor;
	}

	public Boolean getActivarnumero_facturaFacturaProveedor() {
		return this.activarnumero_facturaFacturaProveedor;
	}

	public void setActivarnumero_facturaFacturaProveedor(Boolean activarnumero_facturaFacturaProveedor) {
		this.activarnumero_facturaFacturaProveedor= activarnumero_facturaFacturaProveedor;
	}

	public Border setResaltarid_transaccionFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarid_transaccionFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccionFacturaProveedor() {
		return this.resaltarid_transaccionFacturaProveedor;
	}

	public void setResaltarid_transaccionFacturaProveedor(Border borderResaltar) {
		this.resaltarid_transaccionFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarid_transaccionFacturaProveedor() {
		return this.mostrarid_transaccionFacturaProveedor;
	}

	public void setMostrarid_transaccionFacturaProveedor(Boolean mostrarid_transaccionFacturaProveedor) {
		this.mostrarid_transaccionFacturaProveedor= mostrarid_transaccionFacturaProveedor;
	}

	public Boolean getActivarid_transaccionFacturaProveedor() {
		return this.activarid_transaccionFacturaProveedor;
	}

	public void setActivarid_transaccionFacturaProveedor(Boolean activarid_transaccionFacturaProveedor) {
		this.activarid_transaccionFacturaProveedor= activarid_transaccionFacturaProveedor;
	}

	public Boolean getCargarid_transaccionFacturaProveedor() {
		return this.cargarid_transaccionFacturaProveedor;
	}

	public void setCargarid_transaccionFacturaProveedor(Boolean cargarid_transaccionFacturaProveedor) {
		this.cargarid_transaccionFacturaProveedor= cargarid_transaccionFacturaProveedor;
	}

	public Border setResaltarfecha_emisionFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionFacturaProveedor() {
		return this.resaltarfecha_emisionFacturaProveedor;
	}

	public void setResaltarfecha_emisionFacturaProveedor(Border borderResaltar) {
		this.resaltarfecha_emisionFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionFacturaProveedor() {
		return this.mostrarfecha_emisionFacturaProveedor;
	}

	public void setMostrarfecha_emisionFacturaProveedor(Boolean mostrarfecha_emisionFacturaProveedor) {
		this.mostrarfecha_emisionFacturaProveedor= mostrarfecha_emisionFacturaProveedor;
	}

	public Boolean getActivarfecha_emisionFacturaProveedor() {
		return this.activarfecha_emisionFacturaProveedor;
	}

	public void setActivarfecha_emisionFacturaProveedor(Boolean activarfecha_emisionFacturaProveedor) {
		this.activarfecha_emisionFacturaProveedor= activarfecha_emisionFacturaProveedor;
	}

	public Border setResaltarid_clienteFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarid_clienteFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteFacturaProveedor() {
		return this.resaltarid_clienteFacturaProveedor;
	}

	public void setResaltarid_clienteFacturaProveedor(Border borderResaltar) {
		this.resaltarid_clienteFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarid_clienteFacturaProveedor() {
		return this.mostrarid_clienteFacturaProveedor;
	}

	public void setMostrarid_clienteFacturaProveedor(Boolean mostrarid_clienteFacturaProveedor) {
		this.mostrarid_clienteFacturaProveedor= mostrarid_clienteFacturaProveedor;
	}

	public Boolean getActivarid_clienteFacturaProveedor() {
		return this.activarid_clienteFacturaProveedor;
	}

	public void setActivarid_clienteFacturaProveedor(Boolean activarid_clienteFacturaProveedor) {
		this.activarid_clienteFacturaProveedor= activarid_clienteFacturaProveedor;
	}

	public Boolean getCargarid_clienteFacturaProveedor() {
		return this.cargarid_clienteFacturaProveedor;
	}

	public void setCargarid_clienteFacturaProveedor(Boolean cargarid_clienteFacturaProveedor) {
		this.cargarid_clienteFacturaProveedor= cargarid_clienteFacturaProveedor;
	}

	public Border setResaltarrucFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarrucFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarrucFacturaProveedor() {
		return this.resaltarrucFacturaProveedor;
	}

	public void setResaltarrucFacturaProveedor(Border borderResaltar) {
		this.resaltarrucFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarrucFacturaProveedor() {
		return this.mostrarrucFacturaProveedor;
	}

	public void setMostrarrucFacturaProveedor(Boolean mostrarrucFacturaProveedor) {
		this.mostrarrucFacturaProveedor= mostrarrucFacturaProveedor;
	}

	public Boolean getActivarrucFacturaProveedor() {
		return this.activarrucFacturaProveedor;
	}

	public void setActivarrucFacturaProveedor(Boolean activarrucFacturaProveedor) {
		this.activarrucFacturaProveedor= activarrucFacturaProveedor;
	}

	public Border setResaltarid_empleado_solicitaFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarid_empleado_solicitaFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleado_solicitaFacturaProveedor() {
		return this.resaltarid_empleado_solicitaFacturaProveedor;
	}

	public void setResaltarid_empleado_solicitaFacturaProveedor(Border borderResaltar) {
		this.resaltarid_empleado_solicitaFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarid_empleado_solicitaFacturaProveedor() {
		return this.mostrarid_empleado_solicitaFacturaProveedor;
	}

	public void setMostrarid_empleado_solicitaFacturaProveedor(Boolean mostrarid_empleado_solicitaFacturaProveedor) {
		this.mostrarid_empleado_solicitaFacturaProveedor= mostrarid_empleado_solicitaFacturaProveedor;
	}

	public Boolean getActivarid_empleado_solicitaFacturaProveedor() {
		return this.activarid_empleado_solicitaFacturaProveedor;
	}

	public void setActivarid_empleado_solicitaFacturaProveedor(Boolean activarid_empleado_solicitaFacturaProveedor) {
		this.activarid_empleado_solicitaFacturaProveedor= activarid_empleado_solicitaFacturaProveedor;
	}

	public Boolean getCargarid_empleado_solicitaFacturaProveedor() {
		return this.cargarid_empleado_solicitaFacturaProveedor;
	}

	public void setCargarid_empleado_solicitaFacturaProveedor(Boolean cargarid_empleado_solicitaFacturaProveedor) {
		this.cargarid_empleado_solicitaFacturaProveedor= cargarid_empleado_solicitaFacturaProveedor;
	}

	public Border setResaltarfecha_venceFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarfecha_venceFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_venceFacturaProveedor() {
		return this.resaltarfecha_venceFacturaProveedor;
	}

	public void setResaltarfecha_venceFacturaProveedor(Border borderResaltar) {
		this.resaltarfecha_venceFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarfecha_venceFacturaProveedor() {
		return this.mostrarfecha_venceFacturaProveedor;
	}

	public void setMostrarfecha_venceFacturaProveedor(Boolean mostrarfecha_venceFacturaProveedor) {
		this.mostrarfecha_venceFacturaProveedor= mostrarfecha_venceFacturaProveedor;
	}

	public Boolean getActivarfecha_venceFacturaProveedor() {
		return this.activarfecha_venceFacturaProveedor;
	}

	public void setActivarfecha_venceFacturaProveedor(Boolean activarfecha_venceFacturaProveedor) {
		this.activarfecha_venceFacturaProveedor= activarfecha_venceFacturaProveedor;
	}

	public Border setResaltarid_monedaFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarid_monedaFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_monedaFacturaProveedor() {
		return this.resaltarid_monedaFacturaProveedor;
	}

	public void setResaltarid_monedaFacturaProveedor(Border borderResaltar) {
		this.resaltarid_monedaFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarid_monedaFacturaProveedor() {
		return this.mostrarid_monedaFacturaProveedor;
	}

	public void setMostrarid_monedaFacturaProveedor(Boolean mostrarid_monedaFacturaProveedor) {
		this.mostrarid_monedaFacturaProveedor= mostrarid_monedaFacturaProveedor;
	}

	public Boolean getActivarid_monedaFacturaProveedor() {
		return this.activarid_monedaFacturaProveedor;
	}

	public void setActivarid_monedaFacturaProveedor(Boolean activarid_monedaFacturaProveedor) {
		this.activarid_monedaFacturaProveedor= activarid_monedaFacturaProveedor;
	}

	public Boolean getCargarid_monedaFacturaProveedor() {
		return this.cargarid_monedaFacturaProveedor;
	}

	public void setCargarid_monedaFacturaProveedor(Boolean cargarid_monedaFacturaProveedor) {
		this.cargarid_monedaFacturaProveedor= cargarid_monedaFacturaProveedor;
	}

	public Border setResaltarid_empleadoFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarid_empleadoFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoFacturaProveedor() {
		return this.resaltarid_empleadoFacturaProveedor;
	}

	public void setResaltarid_empleadoFacturaProveedor(Border borderResaltar) {
		this.resaltarid_empleadoFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarid_empleadoFacturaProveedor() {
		return this.mostrarid_empleadoFacturaProveedor;
	}

	public void setMostrarid_empleadoFacturaProveedor(Boolean mostrarid_empleadoFacturaProveedor) {
		this.mostrarid_empleadoFacturaProveedor= mostrarid_empleadoFacturaProveedor;
	}

	public Boolean getActivarid_empleadoFacturaProveedor() {
		return this.activarid_empleadoFacturaProveedor;
	}

	public void setActivarid_empleadoFacturaProveedor(Boolean activarid_empleadoFacturaProveedor) {
		this.activarid_empleadoFacturaProveedor= activarid_empleadoFacturaProveedor;
	}

	public Boolean getCargarid_empleadoFacturaProveedor() {
		return this.cargarid_empleadoFacturaProveedor;
	}

	public void setCargarid_empleadoFacturaProveedor(Boolean cargarid_empleadoFacturaProveedor) {
		this.cargarid_empleadoFacturaProveedor= cargarid_empleadoFacturaProveedor;
	}

	public Border setResaltarcon_activosFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarcon_activosFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_activosFacturaProveedor() {
		return this.resaltarcon_activosFacturaProveedor;
	}

	public void setResaltarcon_activosFacturaProveedor(Border borderResaltar) {
		this.resaltarcon_activosFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarcon_activosFacturaProveedor() {
		return this.mostrarcon_activosFacturaProveedor;
	}

	public void setMostrarcon_activosFacturaProveedor(Boolean mostrarcon_activosFacturaProveedor) {
		this.mostrarcon_activosFacturaProveedor= mostrarcon_activosFacturaProveedor;
	}

	public Boolean getActivarcon_activosFacturaProveedor() {
		return this.activarcon_activosFacturaProveedor;
	}

	public void setActivarcon_activosFacturaProveedor(Boolean activarcon_activosFacturaProveedor) {
		this.activarcon_activosFacturaProveedor= activarcon_activosFacturaProveedor;
	}

	public Border setResaltarcon_riseFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarcon_riseFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_riseFacturaProveedor() {
		return this.resaltarcon_riseFacturaProveedor;
	}

	public void setResaltarcon_riseFacturaProveedor(Border borderResaltar) {
		this.resaltarcon_riseFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarcon_riseFacturaProveedor() {
		return this.mostrarcon_riseFacturaProveedor;
	}

	public void setMostrarcon_riseFacturaProveedor(Boolean mostrarcon_riseFacturaProveedor) {
		this.mostrarcon_riseFacturaProveedor= mostrarcon_riseFacturaProveedor;
	}

	public Boolean getActivarcon_riseFacturaProveedor() {
		return this.activarcon_riseFacturaProveedor;
	}

	public void setActivarcon_riseFacturaProveedor(Boolean activarcon_riseFacturaProveedor) {
		this.activarcon_riseFacturaProveedor= activarcon_riseFacturaProveedor;
	}

	public Border setResaltarcon_sitiosFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarcon_sitiosFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_sitiosFacturaProveedor() {
		return this.resaltarcon_sitiosFacturaProveedor;
	}

	public void setResaltarcon_sitiosFacturaProveedor(Border borderResaltar) {
		this.resaltarcon_sitiosFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarcon_sitiosFacturaProveedor() {
		return this.mostrarcon_sitiosFacturaProveedor;
	}

	public void setMostrarcon_sitiosFacturaProveedor(Boolean mostrarcon_sitiosFacturaProveedor) {
		this.mostrarcon_sitiosFacturaProveedor= mostrarcon_sitiosFacturaProveedor;
	}

	public Boolean getActivarcon_sitiosFacturaProveedor() {
		return this.activarcon_sitiosFacturaProveedor;
	}

	public void setActivarcon_sitiosFacturaProveedor(Boolean activarcon_sitiosFacturaProveedor) {
		this.activarcon_sitiosFacturaProveedor= activarcon_sitiosFacturaProveedor;
	}

	public Border setResaltardetalleFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltardetalleFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardetalleFacturaProveedor() {
		return this.resaltardetalleFacturaProveedor;
	}

	public void setResaltardetalleFacturaProveedor(Border borderResaltar) {
		this.resaltardetalleFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrardetalleFacturaProveedor() {
		return this.mostrardetalleFacturaProveedor;
	}

	public void setMostrardetalleFacturaProveedor(Boolean mostrardetalleFacturaProveedor) {
		this.mostrardetalleFacturaProveedor= mostrardetalleFacturaProveedor;
	}

	public Boolean getActivardetalleFacturaProveedor() {
		return this.activardetalleFacturaProveedor;
	}

	public void setActivardetalleFacturaProveedor(Boolean activardetalleFacturaProveedor) {
		this.activardetalleFacturaProveedor= activardetalleFacturaProveedor;
	}

	public Border setResaltarvalor_bienes12FacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarvalor_bienes12FacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_bienes12FacturaProveedor() {
		return this.resaltarvalor_bienes12FacturaProveedor;
	}

	public void setResaltarvalor_bienes12FacturaProveedor(Border borderResaltar) {
		this.resaltarvalor_bienes12FacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarvalor_bienes12FacturaProveedor() {
		return this.mostrarvalor_bienes12FacturaProveedor;
	}

	public void setMostrarvalor_bienes12FacturaProveedor(Boolean mostrarvalor_bienes12FacturaProveedor) {
		this.mostrarvalor_bienes12FacturaProveedor= mostrarvalor_bienes12FacturaProveedor;
	}

	public Boolean getActivarvalor_bienes12FacturaProveedor() {
		return this.activarvalor_bienes12FacturaProveedor;
	}

	public void setActivarvalor_bienes12FacturaProveedor(Boolean activarvalor_bienes12FacturaProveedor) {
		this.activarvalor_bienes12FacturaProveedor= activarvalor_bienes12FacturaProveedor;
	}

	public Border setResaltarvalor_servicios12FacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarvalor_servicios12FacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_servicios12FacturaProveedor() {
		return this.resaltarvalor_servicios12FacturaProveedor;
	}

	public void setResaltarvalor_servicios12FacturaProveedor(Border borderResaltar) {
		this.resaltarvalor_servicios12FacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarvalor_servicios12FacturaProveedor() {
		return this.mostrarvalor_servicios12FacturaProveedor;
	}

	public void setMostrarvalor_servicios12FacturaProveedor(Boolean mostrarvalor_servicios12FacturaProveedor) {
		this.mostrarvalor_servicios12FacturaProveedor= mostrarvalor_servicios12FacturaProveedor;
	}

	public Boolean getActivarvalor_servicios12FacturaProveedor() {
		return this.activarvalor_servicios12FacturaProveedor;
	}

	public void setActivarvalor_servicios12FacturaProveedor(Boolean activarvalor_servicios12FacturaProveedor) {
		this.activarvalor_servicios12FacturaProveedor= activarvalor_servicios12FacturaProveedor;
	}

	public Border setResaltartotal_valor12FacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltartotal_valor12FacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_valor12FacturaProveedor() {
		return this.resaltartotal_valor12FacturaProveedor;
	}

	public void setResaltartotal_valor12FacturaProveedor(Border borderResaltar) {
		this.resaltartotal_valor12FacturaProveedor= borderResaltar;
	}

	public Boolean getMostrartotal_valor12FacturaProveedor() {
		return this.mostrartotal_valor12FacturaProveedor;
	}

	public void setMostrartotal_valor12FacturaProveedor(Boolean mostrartotal_valor12FacturaProveedor) {
		this.mostrartotal_valor12FacturaProveedor= mostrartotal_valor12FacturaProveedor;
	}

	public Boolean getActivartotal_valor12FacturaProveedor() {
		return this.activartotal_valor12FacturaProveedor;
	}

	public void setActivartotal_valor12FacturaProveedor(Boolean activartotal_valor12FacturaProveedor) {
		this.activartotal_valor12FacturaProveedor= activartotal_valor12FacturaProveedor;
	}

	public Border setResaltarvalor_bienes0FacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarvalor_bienes0FacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_bienes0FacturaProveedor() {
		return this.resaltarvalor_bienes0FacturaProveedor;
	}

	public void setResaltarvalor_bienes0FacturaProveedor(Border borderResaltar) {
		this.resaltarvalor_bienes0FacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarvalor_bienes0FacturaProveedor() {
		return this.mostrarvalor_bienes0FacturaProveedor;
	}

	public void setMostrarvalor_bienes0FacturaProveedor(Boolean mostrarvalor_bienes0FacturaProveedor) {
		this.mostrarvalor_bienes0FacturaProveedor= mostrarvalor_bienes0FacturaProveedor;
	}

	public Boolean getActivarvalor_bienes0FacturaProveedor() {
		return this.activarvalor_bienes0FacturaProveedor;
	}

	public void setActivarvalor_bienes0FacturaProveedor(Boolean activarvalor_bienes0FacturaProveedor) {
		this.activarvalor_bienes0FacturaProveedor= activarvalor_bienes0FacturaProveedor;
	}

	public Border setResaltarvalor_servicios0FacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarvalor_servicios0FacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_servicios0FacturaProveedor() {
		return this.resaltarvalor_servicios0FacturaProveedor;
	}

	public void setResaltarvalor_servicios0FacturaProveedor(Border borderResaltar) {
		this.resaltarvalor_servicios0FacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarvalor_servicios0FacturaProveedor() {
		return this.mostrarvalor_servicios0FacturaProveedor;
	}

	public void setMostrarvalor_servicios0FacturaProveedor(Boolean mostrarvalor_servicios0FacturaProveedor) {
		this.mostrarvalor_servicios0FacturaProveedor= mostrarvalor_servicios0FacturaProveedor;
	}

	public Boolean getActivarvalor_servicios0FacturaProveedor() {
		return this.activarvalor_servicios0FacturaProveedor;
	}

	public void setActivarvalor_servicios0FacturaProveedor(Boolean activarvalor_servicios0FacturaProveedor) {
		this.activarvalor_servicios0FacturaProveedor= activarvalor_servicios0FacturaProveedor;
	}

	public Border setResaltartotal_valor0FacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltartotal_valor0FacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_valor0FacturaProveedor() {
		return this.resaltartotal_valor0FacturaProveedor;
	}

	public void setResaltartotal_valor0FacturaProveedor(Border borderResaltar) {
		this.resaltartotal_valor0FacturaProveedor= borderResaltar;
	}

	public Boolean getMostrartotal_valor0FacturaProveedor() {
		return this.mostrartotal_valor0FacturaProveedor;
	}

	public void setMostrartotal_valor0FacturaProveedor(Boolean mostrartotal_valor0FacturaProveedor) {
		this.mostrartotal_valor0FacturaProveedor= mostrartotal_valor0FacturaProveedor;
	}

	public Boolean getActivartotal_valor0FacturaProveedor() {
		return this.activartotal_valor0FacturaProveedor;
	}

	public void setActivartotal_valor0FacturaProveedor(Boolean activartotal_valor0FacturaProveedor) {
		this.activartotal_valor0FacturaProveedor= activartotal_valor0FacturaProveedor;
	}

	public Border setResaltarbienes_iceFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarbienes_iceFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarbienes_iceFacturaProveedor() {
		return this.resaltarbienes_iceFacturaProveedor;
	}

	public void setResaltarbienes_iceFacturaProveedor(Border borderResaltar) {
		this.resaltarbienes_iceFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarbienes_iceFacturaProveedor() {
		return this.mostrarbienes_iceFacturaProveedor;
	}

	public void setMostrarbienes_iceFacturaProveedor(Boolean mostrarbienes_iceFacturaProveedor) {
		this.mostrarbienes_iceFacturaProveedor= mostrarbienes_iceFacturaProveedor;
	}

	public Boolean getActivarbienes_iceFacturaProveedor() {
		return this.activarbienes_iceFacturaProveedor;
	}

	public void setActivarbienes_iceFacturaProveedor(Boolean activarbienes_iceFacturaProveedor) {
		this.activarbienes_iceFacturaProveedor= activarbienes_iceFacturaProveedor;
	}

	public Border setResaltarservicios_iceFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarservicios_iceFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarservicios_iceFacturaProveedor() {
		return this.resaltarservicios_iceFacturaProveedor;
	}

	public void setResaltarservicios_iceFacturaProveedor(Border borderResaltar) {
		this.resaltarservicios_iceFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarservicios_iceFacturaProveedor() {
		return this.mostrarservicios_iceFacturaProveedor;
	}

	public void setMostrarservicios_iceFacturaProveedor(Boolean mostrarservicios_iceFacturaProveedor) {
		this.mostrarservicios_iceFacturaProveedor= mostrarservicios_iceFacturaProveedor;
	}

	public Boolean getActivarservicios_iceFacturaProveedor() {
		return this.activarservicios_iceFacturaProveedor;
	}

	public void setActivarservicios_iceFacturaProveedor(Boolean activarservicios_iceFacturaProveedor) {
		this.activarservicios_iceFacturaProveedor= activarservicios_iceFacturaProveedor;
	}

	public Border setResaltartotal_iceFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltartotal_iceFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_iceFacturaProveedor() {
		return this.resaltartotal_iceFacturaProveedor;
	}

	public void setResaltartotal_iceFacturaProveedor(Border borderResaltar) {
		this.resaltartotal_iceFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrartotal_iceFacturaProveedor() {
		return this.mostrartotal_iceFacturaProveedor;
	}

	public void setMostrartotal_iceFacturaProveedor(Boolean mostrartotal_iceFacturaProveedor) {
		this.mostrartotal_iceFacturaProveedor= mostrartotal_iceFacturaProveedor;
	}

	public Boolean getActivartotal_iceFacturaProveedor() {
		return this.activartotal_iceFacturaProveedor;
	}

	public void setActivartotal_iceFacturaProveedor(Boolean activartotal_iceFacturaProveedor) {
		this.activartotal_iceFacturaProveedor= activartotal_iceFacturaProveedor;
	}

	public Border setResaltarbienes_ivaFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarbienes_ivaFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarbienes_ivaFacturaProveedor() {
		return this.resaltarbienes_ivaFacturaProveedor;
	}

	public void setResaltarbienes_ivaFacturaProveedor(Border borderResaltar) {
		this.resaltarbienes_ivaFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarbienes_ivaFacturaProveedor() {
		return this.mostrarbienes_ivaFacturaProveedor;
	}

	public void setMostrarbienes_ivaFacturaProveedor(Boolean mostrarbienes_ivaFacturaProveedor) {
		this.mostrarbienes_ivaFacturaProveedor= mostrarbienes_ivaFacturaProveedor;
	}

	public Boolean getActivarbienes_ivaFacturaProveedor() {
		return this.activarbienes_ivaFacturaProveedor;
	}

	public void setActivarbienes_ivaFacturaProveedor(Boolean activarbienes_ivaFacturaProveedor) {
		this.activarbienes_ivaFacturaProveedor= activarbienes_ivaFacturaProveedor;
	}

	public Border setResaltarservicios_ivaFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarservicios_ivaFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarservicios_ivaFacturaProveedor() {
		return this.resaltarservicios_ivaFacturaProveedor;
	}

	public void setResaltarservicios_ivaFacturaProveedor(Border borderResaltar) {
		this.resaltarservicios_ivaFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarservicios_ivaFacturaProveedor() {
		return this.mostrarservicios_ivaFacturaProveedor;
	}

	public void setMostrarservicios_ivaFacturaProveedor(Boolean mostrarservicios_ivaFacturaProveedor) {
		this.mostrarservicios_ivaFacturaProveedor= mostrarservicios_ivaFacturaProveedor;
	}

	public Boolean getActivarservicios_ivaFacturaProveedor() {
		return this.activarservicios_ivaFacturaProveedor;
	}

	public void setActivarservicios_ivaFacturaProveedor(Boolean activarservicios_ivaFacturaProveedor) {
		this.activarservicios_ivaFacturaProveedor= activarservicios_ivaFacturaProveedor;
	}

	public Border setResaltartotal_ivaFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltartotal_ivaFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_ivaFacturaProveedor() {
		return this.resaltartotal_ivaFacturaProveedor;
	}

	public void setResaltartotal_ivaFacturaProveedor(Border borderResaltar) {
		this.resaltartotal_ivaFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrartotal_ivaFacturaProveedor() {
		return this.mostrartotal_ivaFacturaProveedor;
	}

	public void setMostrartotal_ivaFacturaProveedor(Boolean mostrartotal_ivaFacturaProveedor) {
		this.mostrartotal_ivaFacturaProveedor= mostrartotal_ivaFacturaProveedor;
	}

	public Boolean getActivartotal_ivaFacturaProveedor() {
		return this.activartotal_ivaFacturaProveedor;
	}

	public void setActivartotal_ivaFacturaProveedor(Boolean activartotal_ivaFacturaProveedor) {
		this.activartotal_ivaFacturaProveedor= activartotal_ivaFacturaProveedor;
	}

	public Border setResaltariva_porcentajeFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltariva_porcentajeFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltariva_porcentajeFacturaProveedor() {
		return this.resaltariva_porcentajeFacturaProveedor;
	}

	public void setResaltariva_porcentajeFacturaProveedor(Border borderResaltar) {
		this.resaltariva_porcentajeFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrariva_porcentajeFacturaProveedor() {
		return this.mostrariva_porcentajeFacturaProveedor;
	}

	public void setMostrariva_porcentajeFacturaProveedor(Boolean mostrariva_porcentajeFacturaProveedor) {
		this.mostrariva_porcentajeFacturaProveedor= mostrariva_porcentajeFacturaProveedor;
	}

	public Boolean getActivariva_porcentajeFacturaProveedor() {
		return this.activariva_porcentajeFacturaProveedor;
	}

	public void setActivariva_porcentajeFacturaProveedor(Boolean activariva_porcentajeFacturaProveedor) {
		this.activariva_porcentajeFacturaProveedor= activariva_porcentajeFacturaProveedor;
	}

	public Border setResaltartotalFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltartotalFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalFacturaProveedor() {
		return this.resaltartotalFacturaProveedor;
	}

	public void setResaltartotalFacturaProveedor(Border borderResaltar) {
		this.resaltartotalFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrartotalFacturaProveedor() {
		return this.mostrartotalFacturaProveedor;
	}

	public void setMostrartotalFacturaProveedor(Boolean mostrartotalFacturaProveedor) {
		this.mostrartotalFacturaProveedor= mostrartotalFacturaProveedor;
	}

	public Boolean getActivartotalFacturaProveedor() {
		return this.activartotalFacturaProveedor;
	}

	public void setActivartotalFacturaProveedor(Boolean activartotalFacturaProveedor) {
		this.activartotalFacturaProveedor= activartotalFacturaProveedor;
	}

	public Border setResaltarcon_monto_objeto_ivaFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarcon_monto_objeto_ivaFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_monto_objeto_ivaFacturaProveedor() {
		return this.resaltarcon_monto_objeto_ivaFacturaProveedor;
	}

	public void setResaltarcon_monto_objeto_ivaFacturaProveedor(Border borderResaltar) {
		this.resaltarcon_monto_objeto_ivaFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarcon_monto_objeto_ivaFacturaProveedor() {
		return this.mostrarcon_monto_objeto_ivaFacturaProveedor;
	}

	public void setMostrarcon_monto_objeto_ivaFacturaProveedor(Boolean mostrarcon_monto_objeto_ivaFacturaProveedor) {
		this.mostrarcon_monto_objeto_ivaFacturaProveedor= mostrarcon_monto_objeto_ivaFacturaProveedor;
	}

	public Boolean getActivarcon_monto_objeto_ivaFacturaProveedor() {
		return this.activarcon_monto_objeto_ivaFacturaProveedor;
	}

	public void setActivarcon_monto_objeto_ivaFacturaProveedor(Boolean activarcon_monto_objeto_ivaFacturaProveedor) {
		this.activarcon_monto_objeto_ivaFacturaProveedor= activarcon_monto_objeto_ivaFacturaProveedor;
	}

	public Border setResaltarnumero_retencionFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarnumero_retencionFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_retencionFacturaProveedor() {
		return this.resaltarnumero_retencionFacturaProveedor;
	}

	public void setResaltarnumero_retencionFacturaProveedor(Border borderResaltar) {
		this.resaltarnumero_retencionFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarnumero_retencionFacturaProveedor() {
		return this.mostrarnumero_retencionFacturaProveedor;
	}

	public void setMostrarnumero_retencionFacturaProveedor(Boolean mostrarnumero_retencionFacturaProveedor) {
		this.mostrarnumero_retencionFacturaProveedor= mostrarnumero_retencionFacturaProveedor;
	}

	public Boolean getActivarnumero_retencionFacturaProveedor() {
		return this.activarnumero_retencionFacturaProveedor;
	}

	public void setActivarnumero_retencionFacturaProveedor(Boolean activarnumero_retencionFacturaProveedor) {
		this.activarnumero_retencionFacturaProveedor= activarnumero_retencionFacturaProveedor;
	}

	public Border setResaltarnumero_serieFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarnumero_serieFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_serieFacturaProveedor() {
		return this.resaltarnumero_serieFacturaProveedor;
	}

	public void setResaltarnumero_serieFacturaProveedor(Border borderResaltar) {
		this.resaltarnumero_serieFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarnumero_serieFacturaProveedor() {
		return this.mostrarnumero_serieFacturaProveedor;
	}

	public void setMostrarnumero_serieFacturaProveedor(Boolean mostrarnumero_serieFacturaProveedor) {
		this.mostrarnumero_serieFacturaProveedor= mostrarnumero_serieFacturaProveedor;
	}

	public Boolean getActivarnumero_serieFacturaProveedor() {
		return this.activarnumero_serieFacturaProveedor;
	}

	public void setActivarnumero_serieFacturaProveedor(Boolean activarnumero_serieFacturaProveedor) {
		this.activarnumero_serieFacturaProveedor= activarnumero_serieFacturaProveedor;
	}

	public Border setResaltarnumero_autorizacionFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarnumero_autorizacionFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_autorizacionFacturaProveedor() {
		return this.resaltarnumero_autorizacionFacturaProveedor;
	}

	public void setResaltarnumero_autorizacionFacturaProveedor(Border borderResaltar) {
		this.resaltarnumero_autorizacionFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarnumero_autorizacionFacturaProveedor() {
		return this.mostrarnumero_autorizacionFacturaProveedor;
	}

	public void setMostrarnumero_autorizacionFacturaProveedor(Boolean mostrarnumero_autorizacionFacturaProveedor) {
		this.mostrarnumero_autorizacionFacturaProveedor= mostrarnumero_autorizacionFacturaProveedor;
	}

	public Boolean getActivarnumero_autorizacionFacturaProveedor() {
		return this.activarnumero_autorizacionFacturaProveedor;
	}

	public void setActivarnumero_autorizacionFacturaProveedor(Boolean activarnumero_autorizacionFacturaProveedor) {
		this.activarnumero_autorizacionFacturaProveedor= activarnumero_autorizacionFacturaProveedor;
	}

	public Border setResaltarfecha_validezFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarfecha_validezFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_validezFacturaProveedor() {
		return this.resaltarfecha_validezFacturaProveedor;
	}

	public void setResaltarfecha_validezFacturaProveedor(Border borderResaltar) {
		this.resaltarfecha_validezFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarfecha_validezFacturaProveedor() {
		return this.mostrarfecha_validezFacturaProveedor;
	}

	public void setMostrarfecha_validezFacturaProveedor(Boolean mostrarfecha_validezFacturaProveedor) {
		this.mostrarfecha_validezFacturaProveedor= mostrarfecha_validezFacturaProveedor;
	}

	public Boolean getActivarfecha_validezFacturaProveedor() {
		return this.activarfecha_validezFacturaProveedor;
	}

	public void setActivarfecha_validezFacturaProveedor(Boolean activarfecha_validezFacturaProveedor) {
		this.activarfecha_validezFacturaProveedor= activarfecha_validezFacturaProveedor;
	}

	public Border setResaltarid_tipo_retencion_fuente1FacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarid_tipo_retencion_fuente1FacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_retencion_fuente1FacturaProveedor() {
		return this.resaltarid_tipo_retencion_fuente1FacturaProveedor;
	}

	public void setResaltarid_tipo_retencion_fuente1FacturaProveedor(Border borderResaltar) {
		this.resaltarid_tipo_retencion_fuente1FacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarid_tipo_retencion_fuente1FacturaProveedor() {
		return this.mostrarid_tipo_retencion_fuente1FacturaProveedor;
	}

	public void setMostrarid_tipo_retencion_fuente1FacturaProveedor(Boolean mostrarid_tipo_retencion_fuente1FacturaProveedor) {
		this.mostrarid_tipo_retencion_fuente1FacturaProveedor= mostrarid_tipo_retencion_fuente1FacturaProveedor;
	}

	public Boolean getActivarid_tipo_retencion_fuente1FacturaProveedor() {
		return this.activarid_tipo_retencion_fuente1FacturaProveedor;
	}

	public void setActivarid_tipo_retencion_fuente1FacturaProveedor(Boolean activarid_tipo_retencion_fuente1FacturaProveedor) {
		this.activarid_tipo_retencion_fuente1FacturaProveedor= activarid_tipo_retencion_fuente1FacturaProveedor;
	}

	public Boolean getCargarid_tipo_retencion_fuente1FacturaProveedor() {
		return this.cargarid_tipo_retencion_fuente1FacturaProveedor;
	}

	public void setCargarid_tipo_retencion_fuente1FacturaProveedor(Boolean cargarid_tipo_retencion_fuente1FacturaProveedor) {
		this.cargarid_tipo_retencion_fuente1FacturaProveedor= cargarid_tipo_retencion_fuente1FacturaProveedor;
	}

	public Border setResaltarret_fuente1_porcentajeFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarret_fuente1_porcentajeFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarret_fuente1_porcentajeFacturaProveedor() {
		return this.resaltarret_fuente1_porcentajeFacturaProveedor;
	}

	public void setResaltarret_fuente1_porcentajeFacturaProveedor(Border borderResaltar) {
		this.resaltarret_fuente1_porcentajeFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarret_fuente1_porcentajeFacturaProveedor() {
		return this.mostrarret_fuente1_porcentajeFacturaProveedor;
	}

	public void setMostrarret_fuente1_porcentajeFacturaProveedor(Boolean mostrarret_fuente1_porcentajeFacturaProveedor) {
		this.mostrarret_fuente1_porcentajeFacturaProveedor= mostrarret_fuente1_porcentajeFacturaProveedor;
	}

	public Boolean getActivarret_fuente1_porcentajeFacturaProveedor() {
		return this.activarret_fuente1_porcentajeFacturaProveedor;
	}

	public void setActivarret_fuente1_porcentajeFacturaProveedor(Boolean activarret_fuente1_porcentajeFacturaProveedor) {
		this.activarret_fuente1_porcentajeFacturaProveedor= activarret_fuente1_porcentajeFacturaProveedor;
	}

	public Border setResaltarret_fuente1_baseFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarret_fuente1_baseFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarret_fuente1_baseFacturaProveedor() {
		return this.resaltarret_fuente1_baseFacturaProveedor;
	}

	public void setResaltarret_fuente1_baseFacturaProveedor(Border borderResaltar) {
		this.resaltarret_fuente1_baseFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarret_fuente1_baseFacturaProveedor() {
		return this.mostrarret_fuente1_baseFacturaProveedor;
	}

	public void setMostrarret_fuente1_baseFacturaProveedor(Boolean mostrarret_fuente1_baseFacturaProveedor) {
		this.mostrarret_fuente1_baseFacturaProveedor= mostrarret_fuente1_baseFacturaProveedor;
	}

	public Boolean getActivarret_fuente1_baseFacturaProveedor() {
		return this.activarret_fuente1_baseFacturaProveedor;
	}

	public void setActivarret_fuente1_baseFacturaProveedor(Boolean activarret_fuente1_baseFacturaProveedor) {
		this.activarret_fuente1_baseFacturaProveedor= activarret_fuente1_baseFacturaProveedor;
	}

	public Border setResaltarret_fuente1_retenidoFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarret_fuente1_retenidoFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarret_fuente1_retenidoFacturaProveedor() {
		return this.resaltarret_fuente1_retenidoFacturaProveedor;
	}

	public void setResaltarret_fuente1_retenidoFacturaProveedor(Border borderResaltar) {
		this.resaltarret_fuente1_retenidoFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarret_fuente1_retenidoFacturaProveedor() {
		return this.mostrarret_fuente1_retenidoFacturaProveedor;
	}

	public void setMostrarret_fuente1_retenidoFacturaProveedor(Boolean mostrarret_fuente1_retenidoFacturaProveedor) {
		this.mostrarret_fuente1_retenidoFacturaProveedor= mostrarret_fuente1_retenidoFacturaProveedor;
	}

	public Boolean getActivarret_fuente1_retenidoFacturaProveedor() {
		return this.activarret_fuente1_retenidoFacturaProveedor;
	}

	public void setActivarret_fuente1_retenidoFacturaProveedor(Boolean activarret_fuente1_retenidoFacturaProveedor) {
		this.activarret_fuente1_retenidoFacturaProveedor= activarret_fuente1_retenidoFacturaProveedor;
	}

	public Border setResaltarid_tipo_retencion_fuente2FacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarid_tipo_retencion_fuente2FacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_retencion_fuente2FacturaProveedor() {
		return this.resaltarid_tipo_retencion_fuente2FacturaProveedor;
	}

	public void setResaltarid_tipo_retencion_fuente2FacturaProveedor(Border borderResaltar) {
		this.resaltarid_tipo_retencion_fuente2FacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarid_tipo_retencion_fuente2FacturaProveedor() {
		return this.mostrarid_tipo_retencion_fuente2FacturaProveedor;
	}

	public void setMostrarid_tipo_retencion_fuente2FacturaProveedor(Boolean mostrarid_tipo_retencion_fuente2FacturaProveedor) {
		this.mostrarid_tipo_retencion_fuente2FacturaProveedor= mostrarid_tipo_retencion_fuente2FacturaProveedor;
	}

	public Boolean getActivarid_tipo_retencion_fuente2FacturaProveedor() {
		return this.activarid_tipo_retencion_fuente2FacturaProveedor;
	}

	public void setActivarid_tipo_retencion_fuente2FacturaProveedor(Boolean activarid_tipo_retencion_fuente2FacturaProveedor) {
		this.activarid_tipo_retencion_fuente2FacturaProveedor= activarid_tipo_retencion_fuente2FacturaProveedor;
	}

	public Boolean getCargarid_tipo_retencion_fuente2FacturaProveedor() {
		return this.cargarid_tipo_retencion_fuente2FacturaProveedor;
	}

	public void setCargarid_tipo_retencion_fuente2FacturaProveedor(Boolean cargarid_tipo_retencion_fuente2FacturaProveedor) {
		this.cargarid_tipo_retencion_fuente2FacturaProveedor= cargarid_tipo_retencion_fuente2FacturaProveedor;
	}

	public Border setResaltarret_fuente2_porcentajeFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarret_fuente2_porcentajeFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarret_fuente2_porcentajeFacturaProveedor() {
		return this.resaltarret_fuente2_porcentajeFacturaProveedor;
	}

	public void setResaltarret_fuente2_porcentajeFacturaProveedor(Border borderResaltar) {
		this.resaltarret_fuente2_porcentajeFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarret_fuente2_porcentajeFacturaProveedor() {
		return this.mostrarret_fuente2_porcentajeFacturaProveedor;
	}

	public void setMostrarret_fuente2_porcentajeFacturaProveedor(Boolean mostrarret_fuente2_porcentajeFacturaProveedor) {
		this.mostrarret_fuente2_porcentajeFacturaProveedor= mostrarret_fuente2_porcentajeFacturaProveedor;
	}

	public Boolean getActivarret_fuente2_porcentajeFacturaProveedor() {
		return this.activarret_fuente2_porcentajeFacturaProveedor;
	}

	public void setActivarret_fuente2_porcentajeFacturaProveedor(Boolean activarret_fuente2_porcentajeFacturaProveedor) {
		this.activarret_fuente2_porcentajeFacturaProveedor= activarret_fuente2_porcentajeFacturaProveedor;
	}

	public Border setResaltarret_fuente2_baseFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarret_fuente2_baseFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarret_fuente2_baseFacturaProveedor() {
		return this.resaltarret_fuente2_baseFacturaProveedor;
	}

	public void setResaltarret_fuente2_baseFacturaProveedor(Border borderResaltar) {
		this.resaltarret_fuente2_baseFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarret_fuente2_baseFacturaProveedor() {
		return this.mostrarret_fuente2_baseFacturaProveedor;
	}

	public void setMostrarret_fuente2_baseFacturaProveedor(Boolean mostrarret_fuente2_baseFacturaProveedor) {
		this.mostrarret_fuente2_baseFacturaProveedor= mostrarret_fuente2_baseFacturaProveedor;
	}

	public Boolean getActivarret_fuente2_baseFacturaProveedor() {
		return this.activarret_fuente2_baseFacturaProveedor;
	}

	public void setActivarret_fuente2_baseFacturaProveedor(Boolean activarret_fuente2_baseFacturaProveedor) {
		this.activarret_fuente2_baseFacturaProveedor= activarret_fuente2_baseFacturaProveedor;
	}

	public Border setResaltarret_fuente2_retenidoFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarret_fuente2_retenidoFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarret_fuente2_retenidoFacturaProveedor() {
		return this.resaltarret_fuente2_retenidoFacturaProveedor;
	}

	public void setResaltarret_fuente2_retenidoFacturaProveedor(Border borderResaltar) {
		this.resaltarret_fuente2_retenidoFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarret_fuente2_retenidoFacturaProveedor() {
		return this.mostrarret_fuente2_retenidoFacturaProveedor;
	}

	public void setMostrarret_fuente2_retenidoFacturaProveedor(Boolean mostrarret_fuente2_retenidoFacturaProveedor) {
		this.mostrarret_fuente2_retenidoFacturaProveedor= mostrarret_fuente2_retenidoFacturaProveedor;
	}

	public Boolean getActivarret_fuente2_retenidoFacturaProveedor() {
		return this.activarret_fuente2_retenidoFacturaProveedor;
	}

	public void setActivarret_fuente2_retenidoFacturaProveedor(Boolean activarret_fuente2_retenidoFacturaProveedor) {
		this.activarret_fuente2_retenidoFacturaProveedor= activarret_fuente2_retenidoFacturaProveedor;
	}

	public Border setResaltarid_tipo_retencion_iva1FacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarid_tipo_retencion_iva1FacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_retencion_iva1FacturaProveedor() {
		return this.resaltarid_tipo_retencion_iva1FacturaProveedor;
	}

	public void setResaltarid_tipo_retencion_iva1FacturaProveedor(Border borderResaltar) {
		this.resaltarid_tipo_retencion_iva1FacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarid_tipo_retencion_iva1FacturaProveedor() {
		return this.mostrarid_tipo_retencion_iva1FacturaProveedor;
	}

	public void setMostrarid_tipo_retencion_iva1FacturaProveedor(Boolean mostrarid_tipo_retencion_iva1FacturaProveedor) {
		this.mostrarid_tipo_retencion_iva1FacturaProveedor= mostrarid_tipo_retencion_iva1FacturaProveedor;
	}

	public Boolean getActivarid_tipo_retencion_iva1FacturaProveedor() {
		return this.activarid_tipo_retencion_iva1FacturaProveedor;
	}

	public void setActivarid_tipo_retencion_iva1FacturaProveedor(Boolean activarid_tipo_retencion_iva1FacturaProveedor) {
		this.activarid_tipo_retencion_iva1FacturaProveedor= activarid_tipo_retencion_iva1FacturaProveedor;
	}

	public Boolean getCargarid_tipo_retencion_iva1FacturaProveedor() {
		return this.cargarid_tipo_retencion_iva1FacturaProveedor;
	}

	public void setCargarid_tipo_retencion_iva1FacturaProveedor(Boolean cargarid_tipo_retencion_iva1FacturaProveedor) {
		this.cargarid_tipo_retencion_iva1FacturaProveedor= cargarid_tipo_retencion_iva1FacturaProveedor;
	}

	public Border setResaltarret_iva_bien_porcentajeFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarret_iva_bien_porcentajeFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarret_iva_bien_porcentajeFacturaProveedor() {
		return this.resaltarret_iva_bien_porcentajeFacturaProveedor;
	}

	public void setResaltarret_iva_bien_porcentajeFacturaProveedor(Border borderResaltar) {
		this.resaltarret_iva_bien_porcentajeFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarret_iva_bien_porcentajeFacturaProveedor() {
		return this.mostrarret_iva_bien_porcentajeFacturaProveedor;
	}

	public void setMostrarret_iva_bien_porcentajeFacturaProveedor(Boolean mostrarret_iva_bien_porcentajeFacturaProveedor) {
		this.mostrarret_iva_bien_porcentajeFacturaProveedor= mostrarret_iva_bien_porcentajeFacturaProveedor;
	}

	public Boolean getActivarret_iva_bien_porcentajeFacturaProveedor() {
		return this.activarret_iva_bien_porcentajeFacturaProveedor;
	}

	public void setActivarret_iva_bien_porcentajeFacturaProveedor(Boolean activarret_iva_bien_porcentajeFacturaProveedor) {
		this.activarret_iva_bien_porcentajeFacturaProveedor= activarret_iva_bien_porcentajeFacturaProveedor;
	}

	public Border setResaltarret_iva_bien_baseFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarret_iva_bien_baseFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarret_iva_bien_baseFacturaProveedor() {
		return this.resaltarret_iva_bien_baseFacturaProveedor;
	}

	public void setResaltarret_iva_bien_baseFacturaProveedor(Border borderResaltar) {
		this.resaltarret_iva_bien_baseFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarret_iva_bien_baseFacturaProveedor() {
		return this.mostrarret_iva_bien_baseFacturaProveedor;
	}

	public void setMostrarret_iva_bien_baseFacturaProveedor(Boolean mostrarret_iva_bien_baseFacturaProveedor) {
		this.mostrarret_iva_bien_baseFacturaProveedor= mostrarret_iva_bien_baseFacturaProveedor;
	}

	public Boolean getActivarret_iva_bien_baseFacturaProveedor() {
		return this.activarret_iva_bien_baseFacturaProveedor;
	}

	public void setActivarret_iva_bien_baseFacturaProveedor(Boolean activarret_iva_bien_baseFacturaProveedor) {
		this.activarret_iva_bien_baseFacturaProveedor= activarret_iva_bien_baseFacturaProveedor;
	}

	public Border setResaltarret_iva_bien_retenidoFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarret_iva_bien_retenidoFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarret_iva_bien_retenidoFacturaProveedor() {
		return this.resaltarret_iva_bien_retenidoFacturaProveedor;
	}

	public void setResaltarret_iva_bien_retenidoFacturaProveedor(Border borderResaltar) {
		this.resaltarret_iva_bien_retenidoFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarret_iva_bien_retenidoFacturaProveedor() {
		return this.mostrarret_iva_bien_retenidoFacturaProveedor;
	}

	public void setMostrarret_iva_bien_retenidoFacturaProveedor(Boolean mostrarret_iva_bien_retenidoFacturaProveedor) {
		this.mostrarret_iva_bien_retenidoFacturaProveedor= mostrarret_iva_bien_retenidoFacturaProveedor;
	}

	public Boolean getActivarret_iva_bien_retenidoFacturaProveedor() {
		return this.activarret_iva_bien_retenidoFacturaProveedor;
	}

	public void setActivarret_iva_bien_retenidoFacturaProveedor(Boolean activarret_iva_bien_retenidoFacturaProveedor) {
		this.activarret_iva_bien_retenidoFacturaProveedor= activarret_iva_bien_retenidoFacturaProveedor;
	}

	public Border setResaltarid_tipo_retencion_iva2FacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarid_tipo_retencion_iva2FacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_retencion_iva2FacturaProveedor() {
		return this.resaltarid_tipo_retencion_iva2FacturaProveedor;
	}

	public void setResaltarid_tipo_retencion_iva2FacturaProveedor(Border borderResaltar) {
		this.resaltarid_tipo_retencion_iva2FacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarid_tipo_retencion_iva2FacturaProveedor() {
		return this.mostrarid_tipo_retencion_iva2FacturaProveedor;
	}

	public void setMostrarid_tipo_retencion_iva2FacturaProveedor(Boolean mostrarid_tipo_retencion_iva2FacturaProveedor) {
		this.mostrarid_tipo_retencion_iva2FacturaProveedor= mostrarid_tipo_retencion_iva2FacturaProveedor;
	}

	public Boolean getActivarid_tipo_retencion_iva2FacturaProveedor() {
		return this.activarid_tipo_retencion_iva2FacturaProveedor;
	}

	public void setActivarid_tipo_retencion_iva2FacturaProveedor(Boolean activarid_tipo_retencion_iva2FacturaProveedor) {
		this.activarid_tipo_retencion_iva2FacturaProveedor= activarid_tipo_retencion_iva2FacturaProveedor;
	}

	public Boolean getCargarid_tipo_retencion_iva2FacturaProveedor() {
		return this.cargarid_tipo_retencion_iva2FacturaProveedor;
	}

	public void setCargarid_tipo_retencion_iva2FacturaProveedor(Boolean cargarid_tipo_retencion_iva2FacturaProveedor) {
		this.cargarid_tipo_retencion_iva2FacturaProveedor= cargarid_tipo_retencion_iva2FacturaProveedor;
	}

	public Border setResaltarret_iva_servicio_porcentajeFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarret_iva_servicio_porcentajeFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarret_iva_servicio_porcentajeFacturaProveedor() {
		return this.resaltarret_iva_servicio_porcentajeFacturaProveedor;
	}

	public void setResaltarret_iva_servicio_porcentajeFacturaProveedor(Border borderResaltar) {
		this.resaltarret_iva_servicio_porcentajeFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarret_iva_servicio_porcentajeFacturaProveedor() {
		return this.mostrarret_iva_servicio_porcentajeFacturaProveedor;
	}

	public void setMostrarret_iva_servicio_porcentajeFacturaProveedor(Boolean mostrarret_iva_servicio_porcentajeFacturaProveedor) {
		this.mostrarret_iva_servicio_porcentajeFacturaProveedor= mostrarret_iva_servicio_porcentajeFacturaProveedor;
	}

	public Boolean getActivarret_iva_servicio_porcentajeFacturaProveedor() {
		return this.activarret_iva_servicio_porcentajeFacturaProveedor;
	}

	public void setActivarret_iva_servicio_porcentajeFacturaProveedor(Boolean activarret_iva_servicio_porcentajeFacturaProveedor) {
		this.activarret_iva_servicio_porcentajeFacturaProveedor= activarret_iva_servicio_porcentajeFacturaProveedor;
	}

	public Border setResaltarret_iva_servicio_baseFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarret_iva_servicio_baseFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarret_iva_servicio_baseFacturaProveedor() {
		return this.resaltarret_iva_servicio_baseFacturaProveedor;
	}

	public void setResaltarret_iva_servicio_baseFacturaProveedor(Border borderResaltar) {
		this.resaltarret_iva_servicio_baseFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarret_iva_servicio_baseFacturaProveedor() {
		return this.mostrarret_iva_servicio_baseFacturaProveedor;
	}

	public void setMostrarret_iva_servicio_baseFacturaProveedor(Boolean mostrarret_iva_servicio_baseFacturaProveedor) {
		this.mostrarret_iva_servicio_baseFacturaProveedor= mostrarret_iva_servicio_baseFacturaProveedor;
	}

	public Boolean getActivarret_iva_servicio_baseFacturaProveedor() {
		return this.activarret_iva_servicio_baseFacturaProveedor;
	}

	public void setActivarret_iva_servicio_baseFacturaProveedor(Boolean activarret_iva_servicio_baseFacturaProveedor) {
		this.activarret_iva_servicio_baseFacturaProveedor= activarret_iva_servicio_baseFacturaProveedor;
	}

	public Border setResaltarret_iva_servicio_retenidoFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarret_iva_servicio_retenidoFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarret_iva_servicio_retenidoFacturaProveedor() {
		return this.resaltarret_iva_servicio_retenidoFacturaProveedor;
	}

	public void setResaltarret_iva_servicio_retenidoFacturaProveedor(Border borderResaltar) {
		this.resaltarret_iva_servicio_retenidoFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarret_iva_servicio_retenidoFacturaProveedor() {
		return this.mostrarret_iva_servicio_retenidoFacturaProveedor;
	}

	public void setMostrarret_iva_servicio_retenidoFacturaProveedor(Boolean mostrarret_iva_servicio_retenidoFacturaProveedor) {
		this.mostrarret_iva_servicio_retenidoFacturaProveedor= mostrarret_iva_servicio_retenidoFacturaProveedor;
	}

	public Boolean getActivarret_iva_servicio_retenidoFacturaProveedor() {
		return this.activarret_iva_servicio_retenidoFacturaProveedor;
	}

	public void setActivarret_iva_servicio_retenidoFacturaProveedor(Boolean activarret_iva_servicio_retenidoFacturaProveedor) {
		this.activarret_iva_servicio_retenidoFacturaProveedor= activarret_iva_servicio_retenidoFacturaProveedor;
	}

	public Border setResaltaranexo_numero_autorizacionFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltaranexo_numero_autorizacionFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaranexo_numero_autorizacionFacturaProveedor() {
		return this.resaltaranexo_numero_autorizacionFacturaProveedor;
	}

	public void setResaltaranexo_numero_autorizacionFacturaProveedor(Border borderResaltar) {
		this.resaltaranexo_numero_autorizacionFacturaProveedor= borderResaltar;
	}

	public Boolean getMostraranexo_numero_autorizacionFacturaProveedor() {
		return this.mostraranexo_numero_autorizacionFacturaProveedor;
	}

	public void setMostraranexo_numero_autorizacionFacturaProveedor(Boolean mostraranexo_numero_autorizacionFacturaProveedor) {
		this.mostraranexo_numero_autorizacionFacturaProveedor= mostraranexo_numero_autorizacionFacturaProveedor;
	}

	public Boolean getActivaranexo_numero_autorizacionFacturaProveedor() {
		return this.activaranexo_numero_autorizacionFacturaProveedor;
	}

	public void setActivaranexo_numero_autorizacionFacturaProveedor(Boolean activaranexo_numero_autorizacionFacturaProveedor) {
		this.activaranexo_numero_autorizacionFacturaProveedor= activaranexo_numero_autorizacionFacturaProveedor;
	}

	public Border setResaltaranexo_numeso_serieFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltaranexo_numeso_serieFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaranexo_numeso_serieFacturaProveedor() {
		return this.resaltaranexo_numeso_serieFacturaProveedor;
	}

	public void setResaltaranexo_numeso_serieFacturaProveedor(Border borderResaltar) {
		this.resaltaranexo_numeso_serieFacturaProveedor= borderResaltar;
	}

	public Boolean getMostraranexo_numeso_serieFacturaProveedor() {
		return this.mostraranexo_numeso_serieFacturaProveedor;
	}

	public void setMostraranexo_numeso_serieFacturaProveedor(Boolean mostraranexo_numeso_serieFacturaProveedor) {
		this.mostraranexo_numeso_serieFacturaProveedor= mostraranexo_numeso_serieFacturaProveedor;
	}

	public Boolean getActivaranexo_numeso_serieFacturaProveedor() {
		return this.activaranexo_numeso_serieFacturaProveedor;
	}

	public void setActivaranexo_numeso_serieFacturaProveedor(Boolean activaranexo_numeso_serieFacturaProveedor) {
		this.activaranexo_numeso_serieFacturaProveedor= activaranexo_numeso_serieFacturaProveedor;
	}

	public Border setResaltaranexo_fecha_validezFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltaranexo_fecha_validezFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaranexo_fecha_validezFacturaProveedor() {
		return this.resaltaranexo_fecha_validezFacturaProveedor;
	}

	public void setResaltaranexo_fecha_validezFacturaProveedor(Border borderResaltar) {
		this.resaltaranexo_fecha_validezFacturaProveedor= borderResaltar;
	}

	public Boolean getMostraranexo_fecha_validezFacturaProveedor() {
		return this.mostraranexo_fecha_validezFacturaProveedor;
	}

	public void setMostraranexo_fecha_validezFacturaProveedor(Boolean mostraranexo_fecha_validezFacturaProveedor) {
		this.mostraranexo_fecha_validezFacturaProveedor= mostraranexo_fecha_validezFacturaProveedor;
	}

	public Boolean getActivaranexo_fecha_validezFacturaProveedor() {
		return this.activaranexo_fecha_validezFacturaProveedor;
	}

	public void setActivaranexo_fecha_validezFacturaProveedor(Boolean activaranexo_fecha_validezFacturaProveedor) {
		this.activaranexo_fecha_validezFacturaProveedor= activaranexo_fecha_validezFacturaProveedor;
	}

	public Border setResaltarid_tipo_tributarioFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarid_tipo_tributarioFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_tributarioFacturaProveedor() {
		return this.resaltarid_tipo_tributarioFacturaProveedor;
	}

	public void setResaltarid_tipo_tributarioFacturaProveedor(Border borderResaltar) {
		this.resaltarid_tipo_tributarioFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarid_tipo_tributarioFacturaProveedor() {
		return this.mostrarid_tipo_tributarioFacturaProveedor;
	}

	public void setMostrarid_tipo_tributarioFacturaProveedor(Boolean mostrarid_tipo_tributarioFacturaProveedor) {
		this.mostrarid_tipo_tributarioFacturaProveedor= mostrarid_tipo_tributarioFacturaProveedor;
	}

	public Boolean getActivarid_tipo_tributarioFacturaProveedor() {
		return this.activarid_tipo_tributarioFacturaProveedor;
	}

	public void setActivarid_tipo_tributarioFacturaProveedor(Boolean activarid_tipo_tributarioFacturaProveedor) {
		this.activarid_tipo_tributarioFacturaProveedor= activarid_tipo_tributarioFacturaProveedor;
	}

	public Boolean getCargarid_tipo_tributarioFacturaProveedor() {
		return this.cargarid_tipo_tributarioFacturaProveedor;
	}

	public void setCargarid_tipo_tributarioFacturaProveedor(Boolean cargarid_tipo_tributarioFacturaProveedor) {
		this.cargarid_tipo_tributarioFacturaProveedor= cargarid_tipo_tributarioFacturaProveedor;
	}

	public Border setResaltaranexo_factura_inicioFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltaranexo_factura_inicioFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaranexo_factura_inicioFacturaProveedor() {
		return this.resaltaranexo_factura_inicioFacturaProveedor;
	}

	public void setResaltaranexo_factura_inicioFacturaProveedor(Border borderResaltar) {
		this.resaltaranexo_factura_inicioFacturaProveedor= borderResaltar;
	}

	public Boolean getMostraranexo_factura_inicioFacturaProveedor() {
		return this.mostraranexo_factura_inicioFacturaProveedor;
	}

	public void setMostraranexo_factura_inicioFacturaProveedor(Boolean mostraranexo_factura_inicioFacturaProveedor) {
		this.mostraranexo_factura_inicioFacturaProveedor= mostraranexo_factura_inicioFacturaProveedor;
	}

	public Boolean getActivaranexo_factura_inicioFacturaProveedor() {
		return this.activaranexo_factura_inicioFacturaProveedor;
	}

	public void setActivaranexo_factura_inicioFacturaProveedor(Boolean activaranexo_factura_inicioFacturaProveedor) {
		this.activaranexo_factura_inicioFacturaProveedor= activaranexo_factura_inicioFacturaProveedor;
	}

	public Border setResaltaranexo_factura_finFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltaranexo_factura_finFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaranexo_factura_finFacturaProveedor() {
		return this.resaltaranexo_factura_finFacturaProveedor;
	}

	public void setResaltaranexo_factura_finFacturaProveedor(Border borderResaltar) {
		this.resaltaranexo_factura_finFacturaProveedor= borderResaltar;
	}

	public Boolean getMostraranexo_factura_finFacturaProveedor() {
		return this.mostraranexo_factura_finFacturaProveedor;
	}

	public void setMostraranexo_factura_finFacturaProveedor(Boolean mostraranexo_factura_finFacturaProveedor) {
		this.mostraranexo_factura_finFacturaProveedor= mostraranexo_factura_finFacturaProveedor;
	}

	public Boolean getActivaranexo_factura_finFacturaProveedor() {
		return this.activaranexo_factura_finFacturaProveedor;
	}

	public void setActivaranexo_factura_finFacturaProveedor(Boolean activaranexo_factura_finFacturaProveedor) {
		this.activaranexo_factura_finFacturaProveedor= activaranexo_factura_finFacturaProveedor;
	}

	public Border setResaltarid_cuenta_contable_credito_fiscal_bienesFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_credito_fiscal_bienesFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_credito_fiscal_bienesFacturaProveedor() {
		return this.resaltarid_cuenta_contable_credito_fiscal_bienesFacturaProveedor;
	}

	public void setResaltarid_cuenta_contable_credito_fiscal_bienesFacturaProveedor(Border borderResaltar) {
		this.resaltarid_cuenta_contable_credito_fiscal_bienesFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_credito_fiscal_bienesFacturaProveedor() {
		return this.mostrarid_cuenta_contable_credito_fiscal_bienesFacturaProveedor;
	}

	public void setMostrarid_cuenta_contable_credito_fiscal_bienesFacturaProveedor(Boolean mostrarid_cuenta_contable_credito_fiscal_bienesFacturaProveedor) {
		this.mostrarid_cuenta_contable_credito_fiscal_bienesFacturaProveedor= mostrarid_cuenta_contable_credito_fiscal_bienesFacturaProveedor;
	}

	public Boolean getActivarid_cuenta_contable_credito_fiscal_bienesFacturaProveedor() {
		return this.activarid_cuenta_contable_credito_fiscal_bienesFacturaProveedor;
	}

	public void setActivarid_cuenta_contable_credito_fiscal_bienesFacturaProveedor(Boolean activarid_cuenta_contable_credito_fiscal_bienesFacturaProveedor) {
		this.activarid_cuenta_contable_credito_fiscal_bienesFacturaProveedor= activarid_cuenta_contable_credito_fiscal_bienesFacturaProveedor;
	}

	public Boolean getCargarid_cuenta_contable_credito_fiscal_bienesFacturaProveedor() {
		return this.cargarid_cuenta_contable_credito_fiscal_bienesFacturaProveedor;
	}

	public void setCargarid_cuenta_contable_credito_fiscal_bienesFacturaProveedor(Boolean cargarid_cuenta_contable_credito_fiscal_bienesFacturaProveedor) {
		this.cargarid_cuenta_contable_credito_fiscal_bienesFacturaProveedor= cargarid_cuenta_contable_credito_fiscal_bienesFacturaProveedor;
	}

	public Border setResaltarid_responsable_fondoFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarid_responsable_fondoFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_responsable_fondoFacturaProveedor() {
		return this.resaltarid_responsable_fondoFacturaProveedor;
	}

	public void setResaltarid_responsable_fondoFacturaProveedor(Border borderResaltar) {
		this.resaltarid_responsable_fondoFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarid_responsable_fondoFacturaProveedor() {
		return this.mostrarid_responsable_fondoFacturaProveedor;
	}

	public void setMostrarid_responsable_fondoFacturaProveedor(Boolean mostrarid_responsable_fondoFacturaProveedor) {
		this.mostrarid_responsable_fondoFacturaProveedor= mostrarid_responsable_fondoFacturaProveedor;
	}

	public Boolean getActivarid_responsable_fondoFacturaProveedor() {
		return this.activarid_responsable_fondoFacturaProveedor;
	}

	public void setActivarid_responsable_fondoFacturaProveedor(Boolean activarid_responsable_fondoFacturaProveedor) {
		this.activarid_responsable_fondoFacturaProveedor= activarid_responsable_fondoFacturaProveedor;
	}

	public Boolean getCargarid_responsable_fondoFacturaProveedor() {
		return this.cargarid_responsable_fondoFacturaProveedor;
	}

	public void setCargarid_responsable_fondoFacturaProveedor(Boolean cargarid_responsable_fondoFacturaProveedor) {
		this.cargarid_responsable_fondoFacturaProveedor= cargarid_responsable_fondoFacturaProveedor;
	}

	public Border setResaltarid_cuenta_contable_credito_fiscal_serviciosFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_credito_fiscal_serviciosFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_credito_fiscal_serviciosFacturaProveedor() {
		return this.resaltarid_cuenta_contable_credito_fiscal_serviciosFacturaProveedor;
	}

	public void setResaltarid_cuenta_contable_credito_fiscal_serviciosFacturaProveedor(Border borderResaltar) {
		this.resaltarid_cuenta_contable_credito_fiscal_serviciosFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_credito_fiscal_serviciosFacturaProveedor() {
		return this.mostrarid_cuenta_contable_credito_fiscal_serviciosFacturaProveedor;
	}

	public void setMostrarid_cuenta_contable_credito_fiscal_serviciosFacturaProveedor(Boolean mostrarid_cuenta_contable_credito_fiscal_serviciosFacturaProveedor) {
		this.mostrarid_cuenta_contable_credito_fiscal_serviciosFacturaProveedor= mostrarid_cuenta_contable_credito_fiscal_serviciosFacturaProveedor;
	}

	public Boolean getActivarid_cuenta_contable_credito_fiscal_serviciosFacturaProveedor() {
		return this.activarid_cuenta_contable_credito_fiscal_serviciosFacturaProveedor;
	}

	public void setActivarid_cuenta_contable_credito_fiscal_serviciosFacturaProveedor(Boolean activarid_cuenta_contable_credito_fiscal_serviciosFacturaProveedor) {
		this.activarid_cuenta_contable_credito_fiscal_serviciosFacturaProveedor= activarid_cuenta_contable_credito_fiscal_serviciosFacturaProveedor;
	}

	public Boolean getCargarid_cuenta_contable_credito_fiscal_serviciosFacturaProveedor() {
		return this.cargarid_cuenta_contable_credito_fiscal_serviciosFacturaProveedor;
	}

	public void setCargarid_cuenta_contable_credito_fiscal_serviciosFacturaProveedor(Boolean cargarid_cuenta_contable_credito_fiscal_serviciosFacturaProveedor) {
		this.cargarid_cuenta_contable_credito_fiscal_serviciosFacturaProveedor= cargarid_cuenta_contable_credito_fiscal_serviciosFacturaProveedor;
	}

	public Border setResaltarsecuencialFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarsecuencialFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsecuencialFacturaProveedor() {
		return this.resaltarsecuencialFacturaProveedor;
	}

	public void setResaltarsecuencialFacturaProveedor(Border borderResaltar) {
		this.resaltarsecuencialFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarsecuencialFacturaProveedor() {
		return this.mostrarsecuencialFacturaProveedor;
	}

	public void setMostrarsecuencialFacturaProveedor(Boolean mostrarsecuencialFacturaProveedor) {
		this.mostrarsecuencialFacturaProveedor= mostrarsecuencialFacturaProveedor;
	}

	public Boolean getActivarsecuencialFacturaProveedor() {
		return this.activarsecuencialFacturaProveedor;
	}

	public void setActivarsecuencialFacturaProveedor(Boolean activarsecuencialFacturaProveedor) {
		this.activarsecuencialFacturaProveedor= activarsecuencialFacturaProveedor;
	}

	public Border setResaltarid_cuenta_contable_gastoFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_gastoFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_gastoFacturaProveedor() {
		return this.resaltarid_cuenta_contable_gastoFacturaProveedor;
	}

	public void setResaltarid_cuenta_contable_gastoFacturaProveedor(Border borderResaltar) {
		this.resaltarid_cuenta_contable_gastoFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_gastoFacturaProveedor() {
		return this.mostrarid_cuenta_contable_gastoFacturaProveedor;
	}

	public void setMostrarid_cuenta_contable_gastoFacturaProveedor(Boolean mostrarid_cuenta_contable_gastoFacturaProveedor) {
		this.mostrarid_cuenta_contable_gastoFacturaProveedor= mostrarid_cuenta_contable_gastoFacturaProveedor;
	}

	public Boolean getActivarid_cuenta_contable_gastoFacturaProveedor() {
		return this.activarid_cuenta_contable_gastoFacturaProveedor;
	}

	public void setActivarid_cuenta_contable_gastoFacturaProveedor(Boolean activarid_cuenta_contable_gastoFacturaProveedor) {
		this.activarid_cuenta_contable_gastoFacturaProveedor= activarid_cuenta_contable_gastoFacturaProveedor;
	}

	public Boolean getCargarid_cuenta_contable_gastoFacturaProveedor() {
		return this.cargarid_cuenta_contable_gastoFacturaProveedor;
	}

	public void setCargarid_cuenta_contable_gastoFacturaProveedor(Boolean cargarid_cuenta_contable_gastoFacturaProveedor) {
		this.cargarid_cuenta_contable_gastoFacturaProveedor= cargarid_cuenta_contable_gastoFacturaProveedor;
	}

	public Border setResaltargasto_valorFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltargasto_valorFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltargasto_valorFacturaProveedor() {
		return this.resaltargasto_valorFacturaProveedor;
	}

	public void setResaltargasto_valorFacturaProveedor(Border borderResaltar) {
		this.resaltargasto_valorFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrargasto_valorFacturaProveedor() {
		return this.mostrargasto_valorFacturaProveedor;
	}

	public void setMostrargasto_valorFacturaProveedor(Boolean mostrargasto_valorFacturaProveedor) {
		this.mostrargasto_valorFacturaProveedor= mostrargasto_valorFacturaProveedor;
	}

	public Boolean getActivargasto_valorFacturaProveedor() {
		return this.activargasto_valorFacturaProveedor;
	}

	public void setActivargasto_valorFacturaProveedor(Boolean activargasto_valorFacturaProveedor) {
		this.activargasto_valorFacturaProveedor= activargasto_valorFacturaProveedor;
	}

	public Border setResaltarid_cuenta_contable_gasto2FacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_gasto2FacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_gasto2FacturaProveedor() {
		return this.resaltarid_cuenta_contable_gasto2FacturaProveedor;
	}

	public void setResaltarid_cuenta_contable_gasto2FacturaProveedor(Border borderResaltar) {
		this.resaltarid_cuenta_contable_gasto2FacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_gasto2FacturaProveedor() {
		return this.mostrarid_cuenta_contable_gasto2FacturaProveedor;
	}

	public void setMostrarid_cuenta_contable_gasto2FacturaProveedor(Boolean mostrarid_cuenta_contable_gasto2FacturaProveedor) {
		this.mostrarid_cuenta_contable_gasto2FacturaProveedor= mostrarid_cuenta_contable_gasto2FacturaProveedor;
	}

	public Boolean getActivarid_cuenta_contable_gasto2FacturaProveedor() {
		return this.activarid_cuenta_contable_gasto2FacturaProveedor;
	}

	public void setActivarid_cuenta_contable_gasto2FacturaProveedor(Boolean activarid_cuenta_contable_gasto2FacturaProveedor) {
		this.activarid_cuenta_contable_gasto2FacturaProveedor= activarid_cuenta_contable_gasto2FacturaProveedor;
	}

	public Boolean getCargarid_cuenta_contable_gasto2FacturaProveedor() {
		return this.cargarid_cuenta_contable_gasto2FacturaProveedor;
	}

	public void setCargarid_cuenta_contable_gasto2FacturaProveedor(Boolean cargarid_cuenta_contable_gasto2FacturaProveedor) {
		this.cargarid_cuenta_contable_gasto2FacturaProveedor= cargarid_cuenta_contable_gasto2FacturaProveedor;
	}

	public Border setResaltargasto_valor2FacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltargasto_valor2FacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltargasto_valor2FacturaProveedor() {
		return this.resaltargasto_valor2FacturaProveedor;
	}

	public void setResaltargasto_valor2FacturaProveedor(Border borderResaltar) {
		this.resaltargasto_valor2FacturaProveedor= borderResaltar;
	}

	public Boolean getMostrargasto_valor2FacturaProveedor() {
		return this.mostrargasto_valor2FacturaProveedor;
	}

	public void setMostrargasto_valor2FacturaProveedor(Boolean mostrargasto_valor2FacturaProveedor) {
		this.mostrargasto_valor2FacturaProveedor= mostrargasto_valor2FacturaProveedor;
	}

	public Boolean getActivargasto_valor2FacturaProveedor() {
		return this.activargasto_valor2FacturaProveedor;
	}

	public void setActivargasto_valor2FacturaProveedor(Boolean activargasto_valor2FacturaProveedor) {
		this.activargasto_valor2FacturaProveedor= activargasto_valor2FacturaProveedor;
	}

	public Border setResaltargasto_nombreFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltargasto_nombreFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltargasto_nombreFacturaProveedor() {
		return this.resaltargasto_nombreFacturaProveedor;
	}

	public void setResaltargasto_nombreFacturaProveedor(Border borderResaltar) {
		this.resaltargasto_nombreFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrargasto_nombreFacturaProveedor() {
		return this.mostrargasto_nombreFacturaProveedor;
	}

	public void setMostrargasto_nombreFacturaProveedor(Boolean mostrargasto_nombreFacturaProveedor) {
		this.mostrargasto_nombreFacturaProveedor= mostrargasto_nombreFacturaProveedor;
	}

	public Boolean getActivargasto_nombreFacturaProveedor() {
		return this.activargasto_nombreFacturaProveedor;
	}

	public void setActivargasto_nombreFacturaProveedor(Boolean activargasto_nombreFacturaProveedor) {
		this.activargasto_nombreFacturaProveedor= activargasto_nombreFacturaProveedor;
	}

	public Border setResaltargasto_nombre2FacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltargasto_nombre2FacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltargasto_nombre2FacturaProveedor() {
		return this.resaltargasto_nombre2FacturaProveedor;
	}

	public void setResaltargasto_nombre2FacturaProveedor(Border borderResaltar) {
		this.resaltargasto_nombre2FacturaProveedor= borderResaltar;
	}

	public Boolean getMostrargasto_nombre2FacturaProveedor() {
		return this.mostrargasto_nombre2FacturaProveedor;
	}

	public void setMostrargasto_nombre2FacturaProveedor(Boolean mostrargasto_nombre2FacturaProveedor) {
		this.mostrargasto_nombre2FacturaProveedor= mostrargasto_nombre2FacturaProveedor;
	}

	public Boolean getActivargasto_nombre2FacturaProveedor() {
		return this.activargasto_nombre2FacturaProveedor;
	}

	public void setActivargasto_nombre2FacturaProveedor(Boolean activargasto_nombre2FacturaProveedor) {
		this.activargasto_nombre2FacturaProveedor= activargasto_nombre2FacturaProveedor;
	}

	public Border setResaltarid_cuenta_contable_credito_finFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_credito_finFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_credito_finFacturaProveedor() {
		return this.resaltarid_cuenta_contable_credito_finFacturaProveedor;
	}

	public void setResaltarid_cuenta_contable_credito_finFacturaProveedor(Border borderResaltar) {
		this.resaltarid_cuenta_contable_credito_finFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_credito_finFacturaProveedor() {
		return this.mostrarid_cuenta_contable_credito_finFacturaProveedor;
	}

	public void setMostrarid_cuenta_contable_credito_finFacturaProveedor(Boolean mostrarid_cuenta_contable_credito_finFacturaProveedor) {
		this.mostrarid_cuenta_contable_credito_finFacturaProveedor= mostrarid_cuenta_contable_credito_finFacturaProveedor;
	}

	public Boolean getActivarid_cuenta_contable_credito_finFacturaProveedor() {
		return this.activarid_cuenta_contable_credito_finFacturaProveedor;
	}

	public void setActivarid_cuenta_contable_credito_finFacturaProveedor(Boolean activarid_cuenta_contable_credito_finFacturaProveedor) {
		this.activarid_cuenta_contable_credito_finFacturaProveedor= activarid_cuenta_contable_credito_finFacturaProveedor;
	}

	public Boolean getCargarid_cuenta_contable_credito_finFacturaProveedor() {
		return this.cargarid_cuenta_contable_credito_finFacturaProveedor;
	}

	public void setCargarid_cuenta_contable_credito_finFacturaProveedor(Boolean cargarid_cuenta_contable_credito_finFacturaProveedor) {
		this.cargarid_cuenta_contable_credito_finFacturaProveedor= cargarid_cuenta_contable_credito_finFacturaProveedor;
	}

	public Border setResaltarid_cuenta_contable_credito_fin2FacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_credito_fin2FacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_credito_fin2FacturaProveedor() {
		return this.resaltarid_cuenta_contable_credito_fin2FacturaProveedor;
	}

	public void setResaltarid_cuenta_contable_credito_fin2FacturaProveedor(Border borderResaltar) {
		this.resaltarid_cuenta_contable_credito_fin2FacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_credito_fin2FacturaProveedor() {
		return this.mostrarid_cuenta_contable_credito_fin2FacturaProveedor;
	}

	public void setMostrarid_cuenta_contable_credito_fin2FacturaProveedor(Boolean mostrarid_cuenta_contable_credito_fin2FacturaProveedor) {
		this.mostrarid_cuenta_contable_credito_fin2FacturaProveedor= mostrarid_cuenta_contable_credito_fin2FacturaProveedor;
	}

	public Boolean getActivarid_cuenta_contable_credito_fin2FacturaProveedor() {
		return this.activarid_cuenta_contable_credito_fin2FacturaProveedor;
	}

	public void setActivarid_cuenta_contable_credito_fin2FacturaProveedor(Boolean activarid_cuenta_contable_credito_fin2FacturaProveedor) {
		this.activarid_cuenta_contable_credito_fin2FacturaProveedor= activarid_cuenta_contable_credito_fin2FacturaProveedor;
	}

	public Boolean getCargarid_cuenta_contable_credito_fin2FacturaProveedor() {
		return this.cargarid_cuenta_contable_credito_fin2FacturaProveedor;
	}

	public void setCargarid_cuenta_contable_credito_fin2FacturaProveedor(Boolean cargarid_cuenta_contable_credito_fin2FacturaProveedor) {
		this.cargarid_cuenta_contable_credito_fin2FacturaProveedor= cargarid_cuenta_contable_credito_fin2FacturaProveedor;
	}

	public Border setResaltarid_cuenta_contable_creditoFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_creditoFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_creditoFacturaProveedor() {
		return this.resaltarid_cuenta_contable_creditoFacturaProveedor;
	}

	public void setResaltarid_cuenta_contable_creditoFacturaProveedor(Border borderResaltar) {
		this.resaltarid_cuenta_contable_creditoFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_creditoFacturaProveedor() {
		return this.mostrarid_cuenta_contable_creditoFacturaProveedor;
	}

	public void setMostrarid_cuenta_contable_creditoFacturaProveedor(Boolean mostrarid_cuenta_contable_creditoFacturaProveedor) {
		this.mostrarid_cuenta_contable_creditoFacturaProveedor= mostrarid_cuenta_contable_creditoFacturaProveedor;
	}

	public Boolean getActivarid_cuenta_contable_creditoFacturaProveedor() {
		return this.activarid_cuenta_contable_creditoFacturaProveedor;
	}

	public void setActivarid_cuenta_contable_creditoFacturaProveedor(Boolean activarid_cuenta_contable_creditoFacturaProveedor) {
		this.activarid_cuenta_contable_creditoFacturaProveedor= activarid_cuenta_contable_creditoFacturaProveedor;
	}

	public Boolean getCargarid_cuenta_contable_creditoFacturaProveedor() {
		return this.cargarid_cuenta_contable_creditoFacturaProveedor;
	}

	public void setCargarid_cuenta_contable_creditoFacturaProveedor(Boolean cargarid_cuenta_contable_creditoFacturaProveedor) {
		this.cargarid_cuenta_contable_creditoFacturaProveedor= cargarid_cuenta_contable_creditoFacturaProveedor;
	}

	public Border setResaltardescripcionFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltardescripcionFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionFacturaProveedor() {
		return this.resaltardescripcionFacturaProveedor;
	}

	public void setResaltardescripcionFacturaProveedor(Border borderResaltar) {
		this.resaltardescripcionFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrardescripcionFacturaProveedor() {
		return this.mostrardescripcionFacturaProveedor;
	}

	public void setMostrardescripcionFacturaProveedor(Boolean mostrardescripcionFacturaProveedor) {
		this.mostrardescripcionFacturaProveedor= mostrardescripcionFacturaProveedor;
	}

	public Boolean getActivardescripcionFacturaProveedor() {
		return this.activardescripcionFacturaProveedor;
	}

	public void setActivardescripcionFacturaProveedor(Boolean activardescripcionFacturaProveedor) {
		this.activardescripcionFacturaProveedor= activardescripcionFacturaProveedor;
	}

	public Border setResaltarid_tipo_movimientoFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarid_tipo_movimientoFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_movimientoFacturaProveedor() {
		return this.resaltarid_tipo_movimientoFacturaProveedor;
	}

	public void setResaltarid_tipo_movimientoFacturaProveedor(Border borderResaltar) {
		this.resaltarid_tipo_movimientoFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarid_tipo_movimientoFacturaProveedor() {
		return this.mostrarid_tipo_movimientoFacturaProveedor;
	}

	public void setMostrarid_tipo_movimientoFacturaProveedor(Boolean mostrarid_tipo_movimientoFacturaProveedor) {
		this.mostrarid_tipo_movimientoFacturaProveedor= mostrarid_tipo_movimientoFacturaProveedor;
	}

	public Boolean getActivarid_tipo_movimientoFacturaProveedor() {
		return this.activarid_tipo_movimientoFacturaProveedor;
	}

	public void setActivarid_tipo_movimientoFacturaProveedor(Boolean activarid_tipo_movimientoFacturaProveedor) {
		this.activarid_tipo_movimientoFacturaProveedor= activarid_tipo_movimientoFacturaProveedor;
	}

	public Boolean getCargarid_tipo_movimientoFacturaProveedor() {
		return this.cargarid_tipo_movimientoFacturaProveedor;
	}

	public void setCargarid_tipo_movimientoFacturaProveedor(Boolean cargarid_tipo_movimientoFacturaProveedor) {
		this.cargarid_tipo_movimientoFacturaProveedor= cargarid_tipo_movimientoFacturaProveedor;
	}

	public Border setResaltarid_tipo_movimiento_moduloFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarid_tipo_movimiento_moduloFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_movimiento_moduloFacturaProveedor() {
		return this.resaltarid_tipo_movimiento_moduloFacturaProveedor;
	}

	public void setResaltarid_tipo_movimiento_moduloFacturaProveedor(Border borderResaltar) {
		this.resaltarid_tipo_movimiento_moduloFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarid_tipo_movimiento_moduloFacturaProveedor() {
		return this.mostrarid_tipo_movimiento_moduloFacturaProveedor;
	}

	public void setMostrarid_tipo_movimiento_moduloFacturaProveedor(Boolean mostrarid_tipo_movimiento_moduloFacturaProveedor) {
		this.mostrarid_tipo_movimiento_moduloFacturaProveedor= mostrarid_tipo_movimiento_moduloFacturaProveedor;
	}

	public Boolean getActivarid_tipo_movimiento_moduloFacturaProveedor() {
		return this.activarid_tipo_movimiento_moduloFacturaProveedor;
	}

	public void setActivarid_tipo_movimiento_moduloFacturaProveedor(Boolean activarid_tipo_movimiento_moduloFacturaProveedor) {
		this.activarid_tipo_movimiento_moduloFacturaProveedor= activarid_tipo_movimiento_moduloFacturaProveedor;
	}

	public Boolean getCargarid_tipo_movimiento_moduloFacturaProveedor() {
		return this.cargarid_tipo_movimiento_moduloFacturaProveedor;
	}

	public void setCargarid_tipo_movimiento_moduloFacturaProveedor(Boolean cargarid_tipo_movimiento_moduloFacturaProveedor) {
		this.cargarid_tipo_movimiento_moduloFacturaProveedor= cargarid_tipo_movimiento_moduloFacturaProveedor;
	}

	public Border setResaltarid_tipo_transaccion_moduloFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarid_tipo_transaccion_moduloFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_transaccion_moduloFacturaProveedor() {
		return this.resaltarid_tipo_transaccion_moduloFacturaProveedor;
	}

	public void setResaltarid_tipo_transaccion_moduloFacturaProveedor(Border borderResaltar) {
		this.resaltarid_tipo_transaccion_moduloFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarid_tipo_transaccion_moduloFacturaProveedor() {
		return this.mostrarid_tipo_transaccion_moduloFacturaProveedor;
	}

	public void setMostrarid_tipo_transaccion_moduloFacturaProveedor(Boolean mostrarid_tipo_transaccion_moduloFacturaProveedor) {
		this.mostrarid_tipo_transaccion_moduloFacturaProveedor= mostrarid_tipo_transaccion_moduloFacturaProveedor;
	}

	public Boolean getActivarid_tipo_transaccion_moduloFacturaProveedor() {
		return this.activarid_tipo_transaccion_moduloFacturaProveedor;
	}

	public void setActivarid_tipo_transaccion_moduloFacturaProveedor(Boolean activarid_tipo_transaccion_moduloFacturaProveedor) {
		this.activarid_tipo_transaccion_moduloFacturaProveedor= activarid_tipo_transaccion_moduloFacturaProveedor;
	}

	public Boolean getCargarid_tipo_transaccion_moduloFacturaProveedor() {
		return this.cargarid_tipo_transaccion_moduloFacturaProveedor;
	}

	public void setCargarid_tipo_transaccion_moduloFacturaProveedor(Boolean cargarid_tipo_transaccion_moduloFacturaProveedor) {
		this.cargarid_tipo_transaccion_moduloFacturaProveedor= cargarid_tipo_transaccion_moduloFacturaProveedor;
	}

	public Border setResaltarnumero_mayorFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarnumero_mayorFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_mayorFacturaProveedor() {
		return this.resaltarnumero_mayorFacturaProveedor;
	}

	public void setResaltarnumero_mayorFacturaProveedor(Border borderResaltar) {
		this.resaltarnumero_mayorFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarnumero_mayorFacturaProveedor() {
		return this.mostrarnumero_mayorFacturaProveedor;
	}

	public void setMostrarnumero_mayorFacturaProveedor(Boolean mostrarnumero_mayorFacturaProveedor) {
		this.mostrarnumero_mayorFacturaProveedor= mostrarnumero_mayorFacturaProveedor;
	}

	public Boolean getActivarnumero_mayorFacturaProveedor() {
		return this.activarnumero_mayorFacturaProveedor;
	}

	public void setActivarnumero_mayorFacturaProveedor(Boolean activarnumero_mayorFacturaProveedor) {
		this.activarnumero_mayorFacturaProveedor= activarnumero_mayorFacturaProveedor;
	}

	public Border setResaltarcodigo_asientoFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltar);
		
		this.resaltarcodigo_asientoFacturaProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_asientoFacturaProveedor() {
		return this.resaltarcodigo_asientoFacturaProveedor;
	}

	public void setResaltarcodigo_asientoFacturaProveedor(Border borderResaltar) {
		this.resaltarcodigo_asientoFacturaProveedor= borderResaltar;
	}

	public Boolean getMostrarcodigo_asientoFacturaProveedor() {
		return this.mostrarcodigo_asientoFacturaProveedor;
	}

	public void setMostrarcodigo_asientoFacturaProveedor(Boolean mostrarcodigo_asientoFacturaProveedor) {
		this.mostrarcodigo_asientoFacturaProveedor= mostrarcodigo_asientoFacturaProveedor;
	}

	public Boolean getActivarcodigo_asientoFacturaProveedor() {
		return this.activarcodigo_asientoFacturaProveedor;
	}

	public void setActivarcodigo_asientoFacturaProveedor(Boolean activarcodigo_asientoFacturaProveedor) {
		this.activarcodigo_asientoFacturaProveedor= activarcodigo_asientoFacturaProveedor;
	}
	
	public void setMostrarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setMostraridFacturaProveedor(esInicial);
		this.setMostrarid_empresaFacturaProveedor(esInicial);
		this.setMostrarid_sucursalFacturaProveedor(esInicial);
		this.setMostrarid_ejercicioFacturaProveedor(esInicial);
		this.setMostrarid_periodoFacturaProveedor(esInicial);
		this.setMostrarid_anioFacturaProveedor(esInicial);
		this.setMostrarid_mesFacturaProveedor(esInicial);
		this.setMostrarid_moduloFacturaProveedor(esInicial);
		this.setMostrarid_plantilla_facturaFacturaProveedor(esInicial);
		this.setMostrarid_tipo_documentoFacturaProveedor(esInicial);
		this.setMostrarplazoFacturaProveedor(esInicial);
		this.setMostrarid_facturaFacturaProveedor(esInicial);
		this.setMostrarnumero_facturaFacturaProveedor(esInicial);
		this.setMostrarid_transaccionFacturaProveedor(esInicial);
		this.setMostrarfecha_emisionFacturaProveedor(esInicial);
		this.setMostrarid_clienteFacturaProveedor(esInicial);
		this.setMostrarrucFacturaProveedor(esInicial);
		this.setMostrarid_empleado_solicitaFacturaProveedor(esInicial);
		this.setMostrarfecha_venceFacturaProveedor(esInicial);
		this.setMostrarid_monedaFacturaProveedor(esInicial);
		this.setMostrarid_empleadoFacturaProveedor(esInicial);
		this.setMostrarcon_activosFacturaProveedor(esInicial);
		this.setMostrarcon_riseFacturaProveedor(esInicial);
		this.setMostrarcon_sitiosFacturaProveedor(esInicial);
		this.setMostrardetalleFacturaProveedor(esInicial);
		this.setMostrarvalor_bienes12FacturaProveedor(esInicial);
		this.setMostrarvalor_servicios12FacturaProveedor(esInicial);
		this.setMostrartotal_valor12FacturaProveedor(esInicial);
		this.setMostrarvalor_bienes0FacturaProveedor(esInicial);
		this.setMostrarvalor_servicios0FacturaProveedor(esInicial);
		this.setMostrartotal_valor0FacturaProveedor(esInicial);
		this.setMostrarbienes_iceFacturaProveedor(esInicial);
		this.setMostrarservicios_iceFacturaProveedor(esInicial);
		this.setMostrartotal_iceFacturaProveedor(esInicial);
		this.setMostrarbienes_ivaFacturaProveedor(esInicial);
		this.setMostrarservicios_ivaFacturaProveedor(esInicial);
		this.setMostrartotal_ivaFacturaProveedor(esInicial);
		this.setMostrariva_porcentajeFacturaProveedor(esInicial);
		this.setMostrartotalFacturaProveedor(esInicial);
		this.setMostrarcon_monto_objeto_ivaFacturaProveedor(esInicial);
		this.setMostrarnumero_retencionFacturaProveedor(esInicial);
		this.setMostrarnumero_serieFacturaProveedor(esInicial);
		this.setMostrarnumero_autorizacionFacturaProveedor(esInicial);
		this.setMostrarfecha_validezFacturaProveedor(esInicial);
		this.setMostrarid_tipo_retencion_fuente1FacturaProveedor(esInicial);
		this.setMostrarret_fuente1_porcentajeFacturaProveedor(esInicial);
		this.setMostrarret_fuente1_baseFacturaProveedor(esInicial);
		this.setMostrarret_fuente1_retenidoFacturaProveedor(esInicial);
		this.setMostrarid_tipo_retencion_fuente2FacturaProveedor(esInicial);
		this.setMostrarret_fuente2_porcentajeFacturaProveedor(esInicial);
		this.setMostrarret_fuente2_baseFacturaProveedor(esInicial);
		this.setMostrarret_fuente2_retenidoFacturaProveedor(esInicial);
		this.setMostrarid_tipo_retencion_iva1FacturaProveedor(esInicial);
		this.setMostrarret_iva_bien_porcentajeFacturaProveedor(esInicial);
		this.setMostrarret_iva_bien_baseFacturaProveedor(esInicial);
		this.setMostrarret_iva_bien_retenidoFacturaProveedor(esInicial);
		this.setMostrarid_tipo_retencion_iva2FacturaProveedor(esInicial);
		this.setMostrarret_iva_servicio_porcentajeFacturaProveedor(esInicial);
		this.setMostrarret_iva_servicio_baseFacturaProveedor(esInicial);
		this.setMostrarret_iva_servicio_retenidoFacturaProveedor(esInicial);
		this.setMostraranexo_numero_autorizacionFacturaProveedor(esInicial);
		this.setMostraranexo_numeso_serieFacturaProveedor(esInicial);
		this.setMostraranexo_fecha_validezFacturaProveedor(esInicial);
		this.setMostrarid_tipo_tributarioFacturaProveedor(esInicial);
		this.setMostraranexo_factura_inicioFacturaProveedor(esInicial);
		this.setMostraranexo_factura_finFacturaProveedor(esInicial);
		this.setMostrarid_cuenta_contable_credito_fiscal_bienesFacturaProveedor(esInicial);
		this.setMostrarid_responsable_fondoFacturaProveedor(esInicial);
		this.setMostrarid_cuenta_contable_credito_fiscal_serviciosFacturaProveedor(esInicial);
		this.setMostrarsecuencialFacturaProveedor(esInicial);
		this.setMostrarid_cuenta_contable_gastoFacturaProveedor(esInicial);
		this.setMostrargasto_valorFacturaProveedor(esInicial);
		this.setMostrarid_cuenta_contable_gasto2FacturaProveedor(esInicial);
		this.setMostrargasto_valor2FacturaProveedor(esInicial);
		this.setMostrargasto_nombreFacturaProveedor(esInicial);
		this.setMostrargasto_nombre2FacturaProveedor(esInicial);
		this.setMostrarid_cuenta_contable_credito_finFacturaProveedor(esInicial);
		this.setMostrarid_cuenta_contable_credito_fin2FacturaProveedor(esInicial);
		this.setMostrarid_cuenta_contable_creditoFacturaProveedor(esInicial);
		this.setMostrardescripcionFacturaProveedor(esInicial);
		this.setMostrarid_tipo_movimientoFacturaProveedor(esInicial);
		this.setMostrarid_tipo_movimiento_moduloFacturaProveedor(esInicial);
		this.setMostrarid_tipo_transaccion_moduloFacturaProveedor(esInicial);
		this.setMostrarnumero_mayorFacturaProveedor(esInicial);
		this.setMostrarcodigo_asientoFacturaProveedor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.ID)) {
				this.setMostraridFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDMES)) {
				this.setMostrarid_mesFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDMODULO)) {
				this.setMostrarid_moduloFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDPLANTILLAFACTURA)) {
				this.setMostrarid_plantilla_facturaFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDTIPODOCUMENTO)) {
				this.setMostrarid_tipo_documentoFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.PLAZO)) {
				this.setMostrarplazoFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDFACTURA)) {
				this.setMostrarid_facturaFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.NUMEROFACTURA)) {
				this.setMostrarnumero_facturaFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDTRANSACCION)) {
				this.setMostrarid_transaccionFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.RUC)) {
				this.setMostrarrucFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDEMPLEADOSOLICITA)) {
				this.setMostrarid_empleado_solicitaFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.FECHAVENCE)) {
				this.setMostrarfecha_venceFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDMONEDA)) {
				this.setMostrarid_monedaFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.CONACTIVOS)) {
				this.setMostrarcon_activosFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.CONRISE)) {
				this.setMostrarcon_riseFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.CONSITIOS)) {
				this.setMostrarcon_sitiosFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.DETALLE)) {
				this.setMostrardetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.VALORBIENES12)) {
				this.setMostrarvalor_bienes12FacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.VALORSERVICIOS12)) {
				this.setMostrarvalor_servicios12FacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.TOTALVALOR12)) {
				this.setMostrartotal_valor12FacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.VALORBIENES0)) {
				this.setMostrarvalor_bienes0FacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.VALORSERVICIOS0)) {
				this.setMostrarvalor_servicios0FacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.TOTALVALOR0)) {
				this.setMostrartotal_valor0FacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.BIENESICE)) {
				this.setMostrarbienes_iceFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.SERVICIOSICE)) {
				this.setMostrarservicios_iceFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.TOTALICE)) {
				this.setMostrartotal_iceFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.BIENESIVA)) {
				this.setMostrarbienes_ivaFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.SERVICIOSIVA)) {
				this.setMostrarservicios_ivaFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.TOTALIVA)) {
				this.setMostrartotal_ivaFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IVAPORCENTAJE)) {
				this.setMostrariva_porcentajeFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.TOTAL)) {
				this.setMostrartotalFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.CONMONTOOBJETOIVA)) {
				this.setMostrarcon_monto_objeto_ivaFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.NUMERORETENCION)) {
				this.setMostrarnumero_retencionFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.NUMEROSERIE)) {
				this.setMostrarnumero_serieFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.NUMEROAUTORIZACION)) {
				this.setMostrarnumero_autorizacionFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.FECHAVALIDEZ)) {
				this.setMostrarfecha_validezFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDTIPORETENCIONFUENTE1)) {
				this.setMostrarid_tipo_retencion_fuente1FacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.RETFUENTE1PORCENTAJE)) {
				this.setMostrarret_fuente1_porcentajeFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.RETFUENTE1BASE)) {
				this.setMostrarret_fuente1_baseFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.RETFUENTE1RETENIDO)) {
				this.setMostrarret_fuente1_retenidoFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDTIPORETENCIONFUENTE2)) {
				this.setMostrarid_tipo_retencion_fuente2FacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.RETFUENTE2PORCENTAJE)) {
				this.setMostrarret_fuente2_porcentajeFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.RETFUENTE2BASE)) {
				this.setMostrarret_fuente2_baseFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.RETFUENTE2RETENIDO)) {
				this.setMostrarret_fuente2_retenidoFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDTIPORETENCIONIVA1)) {
				this.setMostrarid_tipo_retencion_iva1FacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.RETIVABIENPORCENTAJE)) {
				this.setMostrarret_iva_bien_porcentajeFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.RETIVABIENBASE)) {
				this.setMostrarret_iva_bien_baseFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.RETIVABIENRETENIDO)) {
				this.setMostrarret_iva_bien_retenidoFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDTIPORETENCIONIVA2)) {
				this.setMostrarid_tipo_retencion_iva2FacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.RETIVASERVICIOPORCENTAJE)) {
				this.setMostrarret_iva_servicio_porcentajeFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.RETIVASERVICIOBASE)) {
				this.setMostrarret_iva_servicio_baseFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.RETIVASERVICIORETENIDO)) {
				this.setMostrarret_iva_servicio_retenidoFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.ANEXONUMEROAUTORIZACION)) {
				this.setMostraranexo_numero_autorizacionFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.ANEXONUMESOSERIE)) {
				this.setMostraranexo_numeso_serieFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.ANEXOFECHAVALIDEZ)) {
				this.setMostraranexo_fecha_validezFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDTIPOTRIBUTARIO)) {
				this.setMostrarid_tipo_tributarioFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.ANEXOFACTURAINICIO)) {
				this.setMostraranexo_factura_inicioFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.ANEXOFACTURAFIN)) {
				this.setMostraranexo_factura_finFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDCUENTACONTABLECREDITOFISCALBIENES)) {
				this.setMostrarid_cuenta_contable_credito_fiscal_bienesFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDRESPONSABLEFONDO)) {
				this.setMostrarid_responsable_fondoFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDCUENTACONTABLECREDITOFISCALSERVICIOS)) {
				this.setMostrarid_cuenta_contable_credito_fiscal_serviciosFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.SECUENCIAL)) {
				this.setMostrarsecuencialFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDCUENTACONTABLEGASTO)) {
				this.setMostrarid_cuenta_contable_gastoFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.GASTOVALOR)) {
				this.setMostrargasto_valorFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDCUENTACONTABLEGASTO2)) {
				this.setMostrarid_cuenta_contable_gasto2FacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.GASTOVALOR2)) {
				this.setMostrargasto_valor2FacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.GASTONOMBRE)) {
				this.setMostrargasto_nombreFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.GASTONOMBRE2)) {
				this.setMostrargasto_nombre2FacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDCUENTACONTABLECREDITOFIN)) {
				this.setMostrarid_cuenta_contable_credito_finFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDCUENTACONTABLECREDITOFIN2)) {
				this.setMostrarid_cuenta_contable_credito_fin2FacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDCUENTACONTABLECREDITO)) {
				this.setMostrarid_cuenta_contable_creditoFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDTIPOMOVIMIENTO)) {
				this.setMostrarid_tipo_movimientoFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDTIPOMOVIMIENTOMODULO)) {
				this.setMostrarid_tipo_movimiento_moduloFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {
				this.setMostrarid_tipo_transaccion_moduloFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.NUMEROMAYOR)) {
				this.setMostrarnumero_mayorFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.CODIGOASIENTO)) {
				this.setMostrarcodigo_asientoFacturaProveedor(esAsigna);
				continue;
			}
		}
	}
	
	public void setActivarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setActivaridFacturaProveedor(esInicial);
		this.setActivarid_empresaFacturaProveedor(esInicial);
		this.setActivarid_sucursalFacturaProveedor(esInicial);
		this.setActivarid_ejercicioFacturaProveedor(esInicial);
		this.setActivarid_periodoFacturaProveedor(esInicial);
		this.setActivarid_anioFacturaProveedor(esInicial);
		this.setActivarid_mesFacturaProveedor(esInicial);
		this.setActivarid_moduloFacturaProveedor(esInicial);
		this.setActivarid_plantilla_facturaFacturaProveedor(esInicial);
		this.setActivarid_tipo_documentoFacturaProveedor(esInicial);
		this.setActivarplazoFacturaProveedor(esInicial);
		this.setActivarid_facturaFacturaProveedor(esInicial);
		this.setActivarnumero_facturaFacturaProveedor(esInicial);
		this.setActivarid_transaccionFacturaProveedor(esInicial);
		this.setActivarfecha_emisionFacturaProveedor(esInicial);
		this.setActivarid_clienteFacturaProveedor(esInicial);
		this.setActivarrucFacturaProveedor(esInicial);
		this.setActivarid_empleado_solicitaFacturaProveedor(esInicial);
		this.setActivarfecha_venceFacturaProveedor(esInicial);
		this.setActivarid_monedaFacturaProveedor(esInicial);
		this.setActivarid_empleadoFacturaProveedor(esInicial);
		this.setActivarcon_activosFacturaProveedor(esInicial);
		this.setActivarcon_riseFacturaProveedor(esInicial);
		this.setActivarcon_sitiosFacturaProveedor(esInicial);
		this.setActivardetalleFacturaProveedor(esInicial);
		this.setActivarvalor_bienes12FacturaProveedor(esInicial);
		this.setActivarvalor_servicios12FacturaProveedor(esInicial);
		this.setActivartotal_valor12FacturaProveedor(esInicial);
		this.setActivarvalor_bienes0FacturaProveedor(esInicial);
		this.setActivarvalor_servicios0FacturaProveedor(esInicial);
		this.setActivartotal_valor0FacturaProveedor(esInicial);
		this.setActivarbienes_iceFacturaProveedor(esInicial);
		this.setActivarservicios_iceFacturaProveedor(esInicial);
		this.setActivartotal_iceFacturaProveedor(esInicial);
		this.setActivarbienes_ivaFacturaProveedor(esInicial);
		this.setActivarservicios_ivaFacturaProveedor(esInicial);
		this.setActivartotal_ivaFacturaProveedor(esInicial);
		this.setActivariva_porcentajeFacturaProveedor(esInicial);
		this.setActivartotalFacturaProveedor(esInicial);
		this.setActivarcon_monto_objeto_ivaFacturaProveedor(esInicial);
		this.setActivarnumero_retencionFacturaProveedor(esInicial);
		this.setActivarnumero_serieFacturaProveedor(esInicial);
		this.setActivarnumero_autorizacionFacturaProveedor(esInicial);
		this.setActivarfecha_validezFacturaProveedor(esInicial);
		this.setActivarid_tipo_retencion_fuente1FacturaProveedor(esInicial);
		this.setActivarret_fuente1_porcentajeFacturaProveedor(esInicial);
		this.setActivarret_fuente1_baseFacturaProveedor(esInicial);
		this.setActivarret_fuente1_retenidoFacturaProveedor(esInicial);
		this.setActivarid_tipo_retencion_fuente2FacturaProveedor(esInicial);
		this.setActivarret_fuente2_porcentajeFacturaProveedor(esInicial);
		this.setActivarret_fuente2_baseFacturaProveedor(esInicial);
		this.setActivarret_fuente2_retenidoFacturaProveedor(esInicial);
		this.setActivarid_tipo_retencion_iva1FacturaProveedor(esInicial);
		this.setActivarret_iva_bien_porcentajeFacturaProveedor(esInicial);
		this.setActivarret_iva_bien_baseFacturaProveedor(esInicial);
		this.setActivarret_iva_bien_retenidoFacturaProveedor(esInicial);
		this.setActivarid_tipo_retencion_iva2FacturaProveedor(esInicial);
		this.setActivarret_iva_servicio_porcentajeFacturaProveedor(esInicial);
		this.setActivarret_iva_servicio_baseFacturaProveedor(esInicial);
		this.setActivarret_iva_servicio_retenidoFacturaProveedor(esInicial);
		this.setActivaranexo_numero_autorizacionFacturaProveedor(esInicial);
		this.setActivaranexo_numeso_serieFacturaProveedor(esInicial);
		this.setActivaranexo_fecha_validezFacturaProveedor(esInicial);
		this.setActivarid_tipo_tributarioFacturaProveedor(esInicial);
		this.setActivaranexo_factura_inicioFacturaProveedor(esInicial);
		this.setActivaranexo_factura_finFacturaProveedor(esInicial);
		this.setActivarid_cuenta_contable_credito_fiscal_bienesFacturaProveedor(esInicial);
		this.setActivarid_responsable_fondoFacturaProveedor(esInicial);
		this.setActivarid_cuenta_contable_credito_fiscal_serviciosFacturaProveedor(esInicial);
		this.setActivarsecuencialFacturaProveedor(esInicial);
		this.setActivarid_cuenta_contable_gastoFacturaProveedor(esInicial);
		this.setActivargasto_valorFacturaProveedor(esInicial);
		this.setActivarid_cuenta_contable_gasto2FacturaProveedor(esInicial);
		this.setActivargasto_valor2FacturaProveedor(esInicial);
		this.setActivargasto_nombreFacturaProveedor(esInicial);
		this.setActivargasto_nombre2FacturaProveedor(esInicial);
		this.setActivarid_cuenta_contable_credito_finFacturaProveedor(esInicial);
		this.setActivarid_cuenta_contable_credito_fin2FacturaProveedor(esInicial);
		this.setActivarid_cuenta_contable_creditoFacturaProveedor(esInicial);
		this.setActivardescripcionFacturaProveedor(esInicial);
		this.setActivarid_tipo_movimientoFacturaProveedor(esInicial);
		this.setActivarid_tipo_movimiento_moduloFacturaProveedor(esInicial);
		this.setActivarid_tipo_transaccion_moduloFacturaProveedor(esInicial);
		this.setActivarnumero_mayorFacturaProveedor(esInicial);
		this.setActivarcodigo_asientoFacturaProveedor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.ID)) {
				this.setActivaridFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDANIO)) {
				this.setActivarid_anioFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDMES)) {
				this.setActivarid_mesFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDMODULO)) {
				this.setActivarid_moduloFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDPLANTILLAFACTURA)) {
				this.setActivarid_plantilla_facturaFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDTIPODOCUMENTO)) {
				this.setActivarid_tipo_documentoFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.PLAZO)) {
				this.setActivarplazoFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDFACTURA)) {
				this.setActivarid_facturaFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.NUMEROFACTURA)) {
				this.setActivarnumero_facturaFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDTRANSACCION)) {
				this.setActivarid_transaccionFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.RUC)) {
				this.setActivarrucFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDEMPLEADOSOLICITA)) {
				this.setActivarid_empleado_solicitaFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.FECHAVENCE)) {
				this.setActivarfecha_venceFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDMONEDA)) {
				this.setActivarid_monedaFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.CONACTIVOS)) {
				this.setActivarcon_activosFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.CONRISE)) {
				this.setActivarcon_riseFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.CONSITIOS)) {
				this.setActivarcon_sitiosFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.DETALLE)) {
				this.setActivardetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.VALORBIENES12)) {
				this.setActivarvalor_bienes12FacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.VALORSERVICIOS12)) {
				this.setActivarvalor_servicios12FacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.TOTALVALOR12)) {
				this.setActivartotal_valor12FacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.VALORBIENES0)) {
				this.setActivarvalor_bienes0FacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.VALORSERVICIOS0)) {
				this.setActivarvalor_servicios0FacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.TOTALVALOR0)) {
				this.setActivartotal_valor0FacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.BIENESICE)) {
				this.setActivarbienes_iceFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.SERVICIOSICE)) {
				this.setActivarservicios_iceFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.TOTALICE)) {
				this.setActivartotal_iceFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.BIENESIVA)) {
				this.setActivarbienes_ivaFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.SERVICIOSIVA)) {
				this.setActivarservicios_ivaFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.TOTALIVA)) {
				this.setActivartotal_ivaFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IVAPORCENTAJE)) {
				this.setActivariva_porcentajeFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.TOTAL)) {
				this.setActivartotalFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.CONMONTOOBJETOIVA)) {
				this.setActivarcon_monto_objeto_ivaFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.NUMERORETENCION)) {
				this.setActivarnumero_retencionFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.NUMEROSERIE)) {
				this.setActivarnumero_serieFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.NUMEROAUTORIZACION)) {
				this.setActivarnumero_autorizacionFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.FECHAVALIDEZ)) {
				this.setActivarfecha_validezFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDTIPORETENCIONFUENTE1)) {
				this.setActivarid_tipo_retencion_fuente1FacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.RETFUENTE1PORCENTAJE)) {
				this.setActivarret_fuente1_porcentajeFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.RETFUENTE1BASE)) {
				this.setActivarret_fuente1_baseFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.RETFUENTE1RETENIDO)) {
				this.setActivarret_fuente1_retenidoFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDTIPORETENCIONFUENTE2)) {
				this.setActivarid_tipo_retencion_fuente2FacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.RETFUENTE2PORCENTAJE)) {
				this.setActivarret_fuente2_porcentajeFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.RETFUENTE2BASE)) {
				this.setActivarret_fuente2_baseFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.RETFUENTE2RETENIDO)) {
				this.setActivarret_fuente2_retenidoFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDTIPORETENCIONIVA1)) {
				this.setActivarid_tipo_retencion_iva1FacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.RETIVABIENPORCENTAJE)) {
				this.setActivarret_iva_bien_porcentajeFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.RETIVABIENBASE)) {
				this.setActivarret_iva_bien_baseFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.RETIVABIENRETENIDO)) {
				this.setActivarret_iva_bien_retenidoFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDTIPORETENCIONIVA2)) {
				this.setActivarid_tipo_retencion_iva2FacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.RETIVASERVICIOPORCENTAJE)) {
				this.setActivarret_iva_servicio_porcentajeFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.RETIVASERVICIOBASE)) {
				this.setActivarret_iva_servicio_baseFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.RETIVASERVICIORETENIDO)) {
				this.setActivarret_iva_servicio_retenidoFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.ANEXONUMEROAUTORIZACION)) {
				this.setActivaranexo_numero_autorizacionFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.ANEXONUMESOSERIE)) {
				this.setActivaranexo_numeso_serieFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.ANEXOFECHAVALIDEZ)) {
				this.setActivaranexo_fecha_validezFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDTIPOTRIBUTARIO)) {
				this.setActivarid_tipo_tributarioFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.ANEXOFACTURAINICIO)) {
				this.setActivaranexo_factura_inicioFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.ANEXOFACTURAFIN)) {
				this.setActivaranexo_factura_finFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDCUENTACONTABLECREDITOFISCALBIENES)) {
				this.setActivarid_cuenta_contable_credito_fiscal_bienesFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDRESPONSABLEFONDO)) {
				this.setActivarid_responsable_fondoFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDCUENTACONTABLECREDITOFISCALSERVICIOS)) {
				this.setActivarid_cuenta_contable_credito_fiscal_serviciosFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.SECUENCIAL)) {
				this.setActivarsecuencialFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDCUENTACONTABLEGASTO)) {
				this.setActivarid_cuenta_contable_gastoFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.GASTOVALOR)) {
				this.setActivargasto_valorFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDCUENTACONTABLEGASTO2)) {
				this.setActivarid_cuenta_contable_gasto2FacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.GASTOVALOR2)) {
				this.setActivargasto_valor2FacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.GASTONOMBRE)) {
				this.setActivargasto_nombreFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.GASTONOMBRE2)) {
				this.setActivargasto_nombre2FacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDCUENTACONTABLECREDITOFIN)) {
				this.setActivarid_cuenta_contable_credito_finFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDCUENTACONTABLECREDITOFIN2)) {
				this.setActivarid_cuenta_contable_credito_fin2FacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDCUENTACONTABLECREDITO)) {
				this.setActivarid_cuenta_contable_creditoFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDTIPOMOVIMIENTO)) {
				this.setActivarid_tipo_movimientoFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDTIPOMOVIMIENTOMODULO)) {
				this.setActivarid_tipo_movimiento_moduloFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {
				this.setActivarid_tipo_transaccion_moduloFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.NUMEROMAYOR)) {
				this.setActivarnumero_mayorFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.CODIGOASIENTO)) {
				this.setActivarcodigo_asientoFacturaProveedor(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridFacturaProveedor(esInicial);
		this.setResaltarid_empresaFacturaProveedor(esInicial);
		this.setResaltarid_sucursalFacturaProveedor(esInicial);
		this.setResaltarid_ejercicioFacturaProveedor(esInicial);
		this.setResaltarid_periodoFacturaProveedor(esInicial);
		this.setResaltarid_anioFacturaProveedor(esInicial);
		this.setResaltarid_mesFacturaProveedor(esInicial);
		this.setResaltarid_moduloFacturaProveedor(esInicial);
		this.setResaltarid_plantilla_facturaFacturaProveedor(esInicial);
		this.setResaltarid_tipo_documentoFacturaProveedor(esInicial);
		this.setResaltarplazoFacturaProveedor(esInicial);
		this.setResaltarid_facturaFacturaProveedor(esInicial);
		this.setResaltarnumero_facturaFacturaProveedor(esInicial);
		this.setResaltarid_transaccionFacturaProveedor(esInicial);
		this.setResaltarfecha_emisionFacturaProveedor(esInicial);
		this.setResaltarid_clienteFacturaProveedor(esInicial);
		this.setResaltarrucFacturaProveedor(esInicial);
		this.setResaltarid_empleado_solicitaFacturaProveedor(esInicial);
		this.setResaltarfecha_venceFacturaProveedor(esInicial);
		this.setResaltarid_monedaFacturaProveedor(esInicial);
		this.setResaltarid_empleadoFacturaProveedor(esInicial);
		this.setResaltarcon_activosFacturaProveedor(esInicial);
		this.setResaltarcon_riseFacturaProveedor(esInicial);
		this.setResaltarcon_sitiosFacturaProveedor(esInicial);
		this.setResaltardetalleFacturaProveedor(esInicial);
		this.setResaltarvalor_bienes12FacturaProveedor(esInicial);
		this.setResaltarvalor_servicios12FacturaProveedor(esInicial);
		this.setResaltartotal_valor12FacturaProveedor(esInicial);
		this.setResaltarvalor_bienes0FacturaProveedor(esInicial);
		this.setResaltarvalor_servicios0FacturaProveedor(esInicial);
		this.setResaltartotal_valor0FacturaProveedor(esInicial);
		this.setResaltarbienes_iceFacturaProveedor(esInicial);
		this.setResaltarservicios_iceFacturaProveedor(esInicial);
		this.setResaltartotal_iceFacturaProveedor(esInicial);
		this.setResaltarbienes_ivaFacturaProveedor(esInicial);
		this.setResaltarservicios_ivaFacturaProveedor(esInicial);
		this.setResaltartotal_ivaFacturaProveedor(esInicial);
		this.setResaltariva_porcentajeFacturaProveedor(esInicial);
		this.setResaltartotalFacturaProveedor(esInicial);
		this.setResaltarcon_monto_objeto_ivaFacturaProveedor(esInicial);
		this.setResaltarnumero_retencionFacturaProveedor(esInicial);
		this.setResaltarnumero_serieFacturaProveedor(esInicial);
		this.setResaltarnumero_autorizacionFacturaProveedor(esInicial);
		this.setResaltarfecha_validezFacturaProveedor(esInicial);
		this.setResaltarid_tipo_retencion_fuente1FacturaProveedor(esInicial);
		this.setResaltarret_fuente1_porcentajeFacturaProveedor(esInicial);
		this.setResaltarret_fuente1_baseFacturaProveedor(esInicial);
		this.setResaltarret_fuente1_retenidoFacturaProveedor(esInicial);
		this.setResaltarid_tipo_retencion_fuente2FacturaProveedor(esInicial);
		this.setResaltarret_fuente2_porcentajeFacturaProveedor(esInicial);
		this.setResaltarret_fuente2_baseFacturaProveedor(esInicial);
		this.setResaltarret_fuente2_retenidoFacturaProveedor(esInicial);
		this.setResaltarid_tipo_retencion_iva1FacturaProveedor(esInicial);
		this.setResaltarret_iva_bien_porcentajeFacturaProveedor(esInicial);
		this.setResaltarret_iva_bien_baseFacturaProveedor(esInicial);
		this.setResaltarret_iva_bien_retenidoFacturaProveedor(esInicial);
		this.setResaltarid_tipo_retencion_iva2FacturaProveedor(esInicial);
		this.setResaltarret_iva_servicio_porcentajeFacturaProveedor(esInicial);
		this.setResaltarret_iva_servicio_baseFacturaProveedor(esInicial);
		this.setResaltarret_iva_servicio_retenidoFacturaProveedor(esInicial);
		this.setResaltaranexo_numero_autorizacionFacturaProveedor(esInicial);
		this.setResaltaranexo_numeso_serieFacturaProveedor(esInicial);
		this.setResaltaranexo_fecha_validezFacturaProveedor(esInicial);
		this.setResaltarid_tipo_tributarioFacturaProveedor(esInicial);
		this.setResaltaranexo_factura_inicioFacturaProveedor(esInicial);
		this.setResaltaranexo_factura_finFacturaProveedor(esInicial);
		this.setResaltarid_cuenta_contable_credito_fiscal_bienesFacturaProveedor(esInicial);
		this.setResaltarid_responsable_fondoFacturaProveedor(esInicial);
		this.setResaltarid_cuenta_contable_credito_fiscal_serviciosFacturaProveedor(esInicial);
		this.setResaltarsecuencialFacturaProveedor(esInicial);
		this.setResaltarid_cuenta_contable_gastoFacturaProveedor(esInicial);
		this.setResaltargasto_valorFacturaProveedor(esInicial);
		this.setResaltarid_cuenta_contable_gasto2FacturaProveedor(esInicial);
		this.setResaltargasto_valor2FacturaProveedor(esInicial);
		this.setResaltargasto_nombreFacturaProveedor(esInicial);
		this.setResaltargasto_nombre2FacturaProveedor(esInicial);
		this.setResaltarid_cuenta_contable_credito_finFacturaProveedor(esInicial);
		this.setResaltarid_cuenta_contable_credito_fin2FacturaProveedor(esInicial);
		this.setResaltarid_cuenta_contable_creditoFacturaProveedor(esInicial);
		this.setResaltardescripcionFacturaProveedor(esInicial);
		this.setResaltarid_tipo_movimientoFacturaProveedor(esInicial);
		this.setResaltarid_tipo_movimiento_moduloFacturaProveedor(esInicial);
		this.setResaltarid_tipo_transaccion_moduloFacturaProveedor(esInicial);
		this.setResaltarnumero_mayorFacturaProveedor(esInicial);
		this.setResaltarcodigo_asientoFacturaProveedor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.ID)) {
				this.setResaltaridFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDMES)) {
				this.setResaltarid_mesFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDMODULO)) {
				this.setResaltarid_moduloFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDPLANTILLAFACTURA)) {
				this.setResaltarid_plantilla_facturaFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDTIPODOCUMENTO)) {
				this.setResaltarid_tipo_documentoFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.PLAZO)) {
				this.setResaltarplazoFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDFACTURA)) {
				this.setResaltarid_facturaFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.NUMEROFACTURA)) {
				this.setResaltarnumero_facturaFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDTRANSACCION)) {
				this.setResaltarid_transaccionFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.RUC)) {
				this.setResaltarrucFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDEMPLEADOSOLICITA)) {
				this.setResaltarid_empleado_solicitaFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.FECHAVENCE)) {
				this.setResaltarfecha_venceFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDMONEDA)) {
				this.setResaltarid_monedaFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.CONACTIVOS)) {
				this.setResaltarcon_activosFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.CONRISE)) {
				this.setResaltarcon_riseFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.CONSITIOS)) {
				this.setResaltarcon_sitiosFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.DETALLE)) {
				this.setResaltardetalleFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.VALORBIENES12)) {
				this.setResaltarvalor_bienes12FacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.VALORSERVICIOS12)) {
				this.setResaltarvalor_servicios12FacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.TOTALVALOR12)) {
				this.setResaltartotal_valor12FacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.VALORBIENES0)) {
				this.setResaltarvalor_bienes0FacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.VALORSERVICIOS0)) {
				this.setResaltarvalor_servicios0FacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.TOTALVALOR0)) {
				this.setResaltartotal_valor0FacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.BIENESICE)) {
				this.setResaltarbienes_iceFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.SERVICIOSICE)) {
				this.setResaltarservicios_iceFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.TOTALICE)) {
				this.setResaltartotal_iceFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.BIENESIVA)) {
				this.setResaltarbienes_ivaFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.SERVICIOSIVA)) {
				this.setResaltarservicios_ivaFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.TOTALIVA)) {
				this.setResaltartotal_ivaFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IVAPORCENTAJE)) {
				this.setResaltariva_porcentajeFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.TOTAL)) {
				this.setResaltartotalFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.CONMONTOOBJETOIVA)) {
				this.setResaltarcon_monto_objeto_ivaFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.NUMERORETENCION)) {
				this.setResaltarnumero_retencionFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.NUMEROSERIE)) {
				this.setResaltarnumero_serieFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.NUMEROAUTORIZACION)) {
				this.setResaltarnumero_autorizacionFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.FECHAVALIDEZ)) {
				this.setResaltarfecha_validezFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDTIPORETENCIONFUENTE1)) {
				this.setResaltarid_tipo_retencion_fuente1FacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.RETFUENTE1PORCENTAJE)) {
				this.setResaltarret_fuente1_porcentajeFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.RETFUENTE1BASE)) {
				this.setResaltarret_fuente1_baseFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.RETFUENTE1RETENIDO)) {
				this.setResaltarret_fuente1_retenidoFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDTIPORETENCIONFUENTE2)) {
				this.setResaltarid_tipo_retencion_fuente2FacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.RETFUENTE2PORCENTAJE)) {
				this.setResaltarret_fuente2_porcentajeFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.RETFUENTE2BASE)) {
				this.setResaltarret_fuente2_baseFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.RETFUENTE2RETENIDO)) {
				this.setResaltarret_fuente2_retenidoFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDTIPORETENCIONIVA1)) {
				this.setResaltarid_tipo_retencion_iva1FacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.RETIVABIENPORCENTAJE)) {
				this.setResaltarret_iva_bien_porcentajeFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.RETIVABIENBASE)) {
				this.setResaltarret_iva_bien_baseFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.RETIVABIENRETENIDO)) {
				this.setResaltarret_iva_bien_retenidoFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDTIPORETENCIONIVA2)) {
				this.setResaltarid_tipo_retencion_iva2FacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.RETIVASERVICIOPORCENTAJE)) {
				this.setResaltarret_iva_servicio_porcentajeFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.RETIVASERVICIOBASE)) {
				this.setResaltarret_iva_servicio_baseFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.RETIVASERVICIORETENIDO)) {
				this.setResaltarret_iva_servicio_retenidoFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.ANEXONUMEROAUTORIZACION)) {
				this.setResaltaranexo_numero_autorizacionFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.ANEXONUMESOSERIE)) {
				this.setResaltaranexo_numeso_serieFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.ANEXOFECHAVALIDEZ)) {
				this.setResaltaranexo_fecha_validezFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDTIPOTRIBUTARIO)) {
				this.setResaltarid_tipo_tributarioFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.ANEXOFACTURAINICIO)) {
				this.setResaltaranexo_factura_inicioFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.ANEXOFACTURAFIN)) {
				this.setResaltaranexo_factura_finFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDCUENTACONTABLECREDITOFISCALBIENES)) {
				this.setResaltarid_cuenta_contable_credito_fiscal_bienesFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDRESPONSABLEFONDO)) {
				this.setResaltarid_responsable_fondoFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDCUENTACONTABLECREDITOFISCALSERVICIOS)) {
				this.setResaltarid_cuenta_contable_credito_fiscal_serviciosFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.SECUENCIAL)) {
				this.setResaltarsecuencialFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDCUENTACONTABLEGASTO)) {
				this.setResaltarid_cuenta_contable_gastoFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.GASTOVALOR)) {
				this.setResaltargasto_valorFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDCUENTACONTABLEGASTO2)) {
				this.setResaltarid_cuenta_contable_gasto2FacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.GASTOVALOR2)) {
				this.setResaltargasto_valor2FacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.GASTONOMBRE)) {
				this.setResaltargasto_nombreFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.GASTONOMBRE2)) {
				this.setResaltargasto_nombre2FacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDCUENTACONTABLECREDITOFIN)) {
				this.setResaltarid_cuenta_contable_credito_finFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDCUENTACONTABLECREDITOFIN2)) {
				this.setResaltarid_cuenta_contable_credito_fin2FacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDCUENTACONTABLECREDITO)) {
				this.setResaltarid_cuenta_contable_creditoFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDTIPOMOVIMIENTO)) {
				this.setResaltarid_tipo_movimientoFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDTIPOMOVIMIENTOMODULO)) {
				this.setResaltarid_tipo_movimiento_moduloFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {
				this.setResaltarid_tipo_transaccion_moduloFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.NUMEROMAYOR)) {
				this.setResaltarnumero_mayorFacturaProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorConstantesFunciones.CODIGOASIENTO)) {
				this.setResaltarcodigo_asientoFacturaProveedor(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDetalleFacturaProveedorFacturaProveedor=null;

	public Border getResaltarDetalleFacturaProveedorFacturaProveedor() {
		return this.resaltarDetalleFacturaProveedorFacturaProveedor;
	}

	public void setResaltarDetalleFacturaProveedorFacturaProveedor(Border borderResaltarDetalleFacturaProveedor) {
		if(borderResaltarDetalleFacturaProveedor!=null) {
			this.resaltarDetalleFacturaProveedorFacturaProveedor= borderResaltarDetalleFacturaProveedor;
		}
	}

	public Border setResaltarDetalleFacturaProveedorFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltarDetalleFacturaProveedor=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//facturaproveedorBeanSwingJInternalFrame.jTtoolBarFacturaProveedor.setBorder(borderResaltarDetalleFacturaProveedor);
			
		this.resaltarDetalleFacturaProveedorFacturaProveedor= borderResaltarDetalleFacturaProveedor;

		 return borderResaltarDetalleFacturaProveedor;
	}



	public Boolean mostrarDetalleFacturaProveedorFacturaProveedor=true;

	public Boolean getMostrarDetalleFacturaProveedorFacturaProveedor() {
		return this.mostrarDetalleFacturaProveedorFacturaProveedor;
	}

	public void setMostrarDetalleFacturaProveedorFacturaProveedor(Boolean visibilidadResaltarDetalleFacturaProveedor) {
		this.mostrarDetalleFacturaProveedorFacturaProveedor= visibilidadResaltarDetalleFacturaProveedor;
	}



	public Boolean activarDetalleFacturaProveedorFacturaProveedor=true;

	public Boolean gethabilitarResaltarDetalleFacturaProveedorFacturaProveedor() {
		return this.activarDetalleFacturaProveedorFacturaProveedor;
	}

	public void setActivarDetalleFacturaProveedorFacturaProveedor(Boolean habilitarResaltarDetalleFacturaProveedor) {
		this.activarDetalleFacturaProveedorFacturaProveedor= habilitarResaltarDetalleFacturaProveedor;
	}
		
		
	public void setMostrarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}

		this.setMostrarDetalleFacturaProveedorFacturaProveedor(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleFacturaProveedor.class)) {
				this.setMostrarDetalleFacturaProveedorFacturaProveedor(esAsigna);
				continue;
			}
		}		
	}
	
	public void setActivarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}

		this.setActivarDetalleFacturaProveedorFacturaProveedor(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleFacturaProveedor.class)) {
				this.setActivarDetalleFacturaProveedorFacturaProveedor(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDetalleFacturaProveedorFacturaProveedor(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleFacturaProveedor.class)) {
				this.setResaltarDetalleFacturaProveedorFacturaProveedor(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdClienteFacturaProveedor=true;

	public Boolean getMostrarFK_IdClienteFacturaProveedor() {
		return this.mostrarFK_IdClienteFacturaProveedor;
	}

	public void setMostrarFK_IdClienteFacturaProveedor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteFacturaProveedor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableCreditoFiscalBienesFacturaProveedor=true;

	public Boolean getMostrarFK_IdCuentaContableCreditoFiscalBienesFacturaProveedor() {
		return this.mostrarFK_IdCuentaContableCreditoFiscalBienesFacturaProveedor;
	}

	public void setMostrarFK_IdCuentaContableCreditoFiscalBienesFacturaProveedor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableCreditoFiscalBienesFacturaProveedor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableCreditoFiscalServiciosFacturaProveedor=true;

	public Boolean getMostrarFK_IdCuentaContableCreditoFiscalServiciosFacturaProveedor() {
		return this.mostrarFK_IdCuentaContableCreditoFiscalServiciosFacturaProveedor;
	}

	public void setMostrarFK_IdCuentaContableCreditoFiscalServiciosFacturaProveedor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableCreditoFiscalServiciosFacturaProveedor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableGasto2FacturaProveedor=true;

	public Boolean getMostrarFK_IdCuentaContableGasto2FacturaProveedor() {
		return this.mostrarFK_IdCuentaContableGasto2FacturaProveedor;
	}

	public void setMostrarFK_IdCuentaContableGasto2FacturaProveedor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableGasto2FacturaProveedor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioFacturaProveedor=true;

	public Boolean getMostrarFK_IdEjercicioFacturaProveedor() {
		return this.mostrarFK_IdEjercicioFacturaProveedor;
	}

	public void setMostrarFK_IdEjercicioFacturaProveedor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioFacturaProveedor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpleadoFacturaProveedor=true;

	public Boolean getMostrarFK_IdEmpleadoFacturaProveedor() {
		return this.mostrarFK_IdEmpleadoFacturaProveedor;
	}

	public void setMostrarFK_IdEmpleadoFacturaProveedor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoFacturaProveedor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaFacturaProveedor=true;

	public Boolean getMostrarFK_IdEmpresaFacturaProveedor() {
		return this.mostrarFK_IdEmpresaFacturaProveedor;
	}

	public void setMostrarFK_IdEmpresaFacturaProveedor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaFacturaProveedor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdModuloFacturaProveedor=true;

	public Boolean getMostrarFK_IdModuloFacturaProveedor() {
		return this.mostrarFK_IdModuloFacturaProveedor;
	}

	public void setMostrarFK_IdModuloFacturaProveedor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdModuloFacturaProveedor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoFacturaProveedor=true;

	public Boolean getMostrarFK_IdPeriodoFacturaProveedor() {
		return this.mostrarFK_IdPeriodoFacturaProveedor;
	}

	public void setMostrarFK_IdPeriodoFacturaProveedor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoFacturaProveedor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPlantillaFacturaFacturaProveedor=true;

	public Boolean getMostrarFK_IdPlantillaFacturaFacturaProveedor() {
		return this.mostrarFK_IdPlantillaFacturaFacturaProveedor;
	}

	public void setMostrarFK_IdPlantillaFacturaFacturaProveedor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPlantillaFacturaFacturaProveedor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdResponsableFondoFacturaProveedor=true;

	public Boolean getMostrarFK_IdResponsableFondoFacturaProveedor() {
		return this.mostrarFK_IdResponsableFondoFacturaProveedor;
	}

	public void setMostrarFK_IdResponsableFondoFacturaProveedor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdResponsableFondoFacturaProveedor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalFacturaProveedor=true;

	public Boolean getMostrarFK_IdSucursalFacturaProveedor() {
		return this.mostrarFK_IdSucursalFacturaProveedor;
	}

	public void setMostrarFK_IdSucursalFacturaProveedor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalFacturaProveedor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoDocumentoFacturaProveedor=true;

	public Boolean getMostrarFK_IdTipoDocumentoFacturaProveedor() {
		return this.mostrarFK_IdTipoDocumentoFacturaProveedor;
	}

	public void setMostrarFK_IdTipoDocumentoFacturaProveedor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoDocumentoFacturaProveedor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoMovimientoModuloFacturaProveedor=true;

	public Boolean getMostrarFK_IdTipoMovimientoModuloFacturaProveedor() {
		return this.mostrarFK_IdTipoMovimientoModuloFacturaProveedor;
	}

	public void setMostrarFK_IdTipoMovimientoModuloFacturaProveedor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoMovimientoModuloFacturaProveedor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoRetencionFuente1FacturaProveedor=true;

	public Boolean getMostrarFK_IdTipoRetencionFuente1FacturaProveedor() {
		return this.mostrarFK_IdTipoRetencionFuente1FacturaProveedor;
	}

	public void setMostrarFK_IdTipoRetencionFuente1FacturaProveedor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoRetencionFuente1FacturaProveedor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoRetencionIva1FacturaProveedor=true;

	public Boolean getMostrarFK_IdTipoRetencionIva1FacturaProveedor() {
		return this.mostrarFK_IdTipoRetencionIva1FacturaProveedor;
	}

	public void setMostrarFK_IdTipoRetencionIva1FacturaProveedor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoRetencionIva1FacturaProveedor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoTransaccionModuloFacturaProveedor=true;

	public Boolean getMostrarFK_IdTipoTransaccionModuloFacturaProveedor() {
		return this.mostrarFK_IdTipoTransaccionModuloFacturaProveedor;
	}

	public void setMostrarFK_IdTipoTransaccionModuloFacturaProveedor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoTransaccionModuloFacturaProveedor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoTributarioFacturaProveedor=true;

	public Boolean getMostrarFK_IdTipoTributarioFacturaProveedor() {
		return this.mostrarFK_IdTipoTributarioFacturaProveedor;
	}

	public void setMostrarFK_IdTipoTributarioFacturaProveedor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoTributarioFacturaProveedor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTransaccionFacturaProveedor=true;

	public Boolean getMostrarFK_IdTransaccionFacturaProveedor() {
		return this.mostrarFK_IdTransaccionFacturaProveedor;
	}

	public void setMostrarFK_IdTransaccionFacturaProveedor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTransaccionFacturaProveedor= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdClienteFacturaProveedor=true;

	public Boolean getActivarFK_IdClienteFacturaProveedor() {
		return this.activarFK_IdClienteFacturaProveedor;
	}

	public void setActivarFK_IdClienteFacturaProveedor(Boolean habilitarResaltar) {
		this.activarFK_IdClienteFacturaProveedor= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableCreditoFiscalBienesFacturaProveedor=true;

	public Boolean getActivarFK_IdCuentaContableCreditoFiscalBienesFacturaProveedor() {
		return this.activarFK_IdCuentaContableCreditoFiscalBienesFacturaProveedor;
	}

	public void setActivarFK_IdCuentaContableCreditoFiscalBienesFacturaProveedor(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableCreditoFiscalBienesFacturaProveedor= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableCreditoFiscalServiciosFacturaProveedor=true;

	public Boolean getActivarFK_IdCuentaContableCreditoFiscalServiciosFacturaProveedor() {
		return this.activarFK_IdCuentaContableCreditoFiscalServiciosFacturaProveedor;
	}

	public void setActivarFK_IdCuentaContableCreditoFiscalServiciosFacturaProveedor(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableCreditoFiscalServiciosFacturaProveedor= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableGasto2FacturaProveedor=true;

	public Boolean getActivarFK_IdCuentaContableGasto2FacturaProveedor() {
		return this.activarFK_IdCuentaContableGasto2FacturaProveedor;
	}

	public void setActivarFK_IdCuentaContableGasto2FacturaProveedor(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableGasto2FacturaProveedor= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioFacturaProveedor=true;

	public Boolean getActivarFK_IdEjercicioFacturaProveedor() {
		return this.activarFK_IdEjercicioFacturaProveedor;
	}

	public void setActivarFK_IdEjercicioFacturaProveedor(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioFacturaProveedor= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpleadoFacturaProveedor=true;

	public Boolean getActivarFK_IdEmpleadoFacturaProveedor() {
		return this.activarFK_IdEmpleadoFacturaProveedor;
	}

	public void setActivarFK_IdEmpleadoFacturaProveedor(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoFacturaProveedor= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaFacturaProveedor=true;

	public Boolean getActivarFK_IdEmpresaFacturaProveedor() {
		return this.activarFK_IdEmpresaFacturaProveedor;
	}

	public void setActivarFK_IdEmpresaFacturaProveedor(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaFacturaProveedor= habilitarResaltar;
	}

	public Boolean activarFK_IdModuloFacturaProveedor=true;

	public Boolean getActivarFK_IdModuloFacturaProveedor() {
		return this.activarFK_IdModuloFacturaProveedor;
	}

	public void setActivarFK_IdModuloFacturaProveedor(Boolean habilitarResaltar) {
		this.activarFK_IdModuloFacturaProveedor= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoFacturaProveedor=true;

	public Boolean getActivarFK_IdPeriodoFacturaProveedor() {
		return this.activarFK_IdPeriodoFacturaProveedor;
	}

	public void setActivarFK_IdPeriodoFacturaProveedor(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoFacturaProveedor= habilitarResaltar;
	}

	public Boolean activarFK_IdPlantillaFacturaFacturaProveedor=true;

	public Boolean getActivarFK_IdPlantillaFacturaFacturaProveedor() {
		return this.activarFK_IdPlantillaFacturaFacturaProveedor;
	}

	public void setActivarFK_IdPlantillaFacturaFacturaProveedor(Boolean habilitarResaltar) {
		this.activarFK_IdPlantillaFacturaFacturaProveedor= habilitarResaltar;
	}

	public Boolean activarFK_IdResponsableFondoFacturaProveedor=true;

	public Boolean getActivarFK_IdResponsableFondoFacturaProveedor() {
		return this.activarFK_IdResponsableFondoFacturaProveedor;
	}

	public void setActivarFK_IdResponsableFondoFacturaProveedor(Boolean habilitarResaltar) {
		this.activarFK_IdResponsableFondoFacturaProveedor= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalFacturaProveedor=true;

	public Boolean getActivarFK_IdSucursalFacturaProveedor() {
		return this.activarFK_IdSucursalFacturaProveedor;
	}

	public void setActivarFK_IdSucursalFacturaProveedor(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalFacturaProveedor= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoDocumentoFacturaProveedor=true;

	public Boolean getActivarFK_IdTipoDocumentoFacturaProveedor() {
		return this.activarFK_IdTipoDocumentoFacturaProveedor;
	}

	public void setActivarFK_IdTipoDocumentoFacturaProveedor(Boolean habilitarResaltar) {
		this.activarFK_IdTipoDocumentoFacturaProveedor= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoMovimientoModuloFacturaProveedor=true;

	public Boolean getActivarFK_IdTipoMovimientoModuloFacturaProveedor() {
		return this.activarFK_IdTipoMovimientoModuloFacturaProveedor;
	}

	public void setActivarFK_IdTipoMovimientoModuloFacturaProveedor(Boolean habilitarResaltar) {
		this.activarFK_IdTipoMovimientoModuloFacturaProveedor= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoRetencionFuente1FacturaProveedor=true;

	public Boolean getActivarFK_IdTipoRetencionFuente1FacturaProveedor() {
		return this.activarFK_IdTipoRetencionFuente1FacturaProveedor;
	}

	public void setActivarFK_IdTipoRetencionFuente1FacturaProveedor(Boolean habilitarResaltar) {
		this.activarFK_IdTipoRetencionFuente1FacturaProveedor= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoRetencionIva1FacturaProveedor=true;

	public Boolean getActivarFK_IdTipoRetencionIva1FacturaProveedor() {
		return this.activarFK_IdTipoRetencionIva1FacturaProveedor;
	}

	public void setActivarFK_IdTipoRetencionIva1FacturaProveedor(Boolean habilitarResaltar) {
		this.activarFK_IdTipoRetencionIva1FacturaProveedor= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoTransaccionModuloFacturaProveedor=true;

	public Boolean getActivarFK_IdTipoTransaccionModuloFacturaProveedor() {
		return this.activarFK_IdTipoTransaccionModuloFacturaProveedor;
	}

	public void setActivarFK_IdTipoTransaccionModuloFacturaProveedor(Boolean habilitarResaltar) {
		this.activarFK_IdTipoTransaccionModuloFacturaProveedor= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoTributarioFacturaProveedor=true;

	public Boolean getActivarFK_IdTipoTributarioFacturaProveedor() {
		return this.activarFK_IdTipoTributarioFacturaProveedor;
	}

	public void setActivarFK_IdTipoTributarioFacturaProveedor(Boolean habilitarResaltar) {
		this.activarFK_IdTipoTributarioFacturaProveedor= habilitarResaltar;
	}

	public Boolean activarFK_IdTransaccionFacturaProveedor=true;

	public Boolean getActivarFK_IdTransaccionFacturaProveedor() {
		return this.activarFK_IdTransaccionFacturaProveedor;
	}

	public void setActivarFK_IdTransaccionFacturaProveedor(Boolean habilitarResaltar) {
		this.activarFK_IdTransaccionFacturaProveedor= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdClienteFacturaProveedor=null;

	public Border getResaltarFK_IdClienteFacturaProveedor() {
		return this.resaltarFK_IdClienteFacturaProveedor;
	}

	public void setResaltarFK_IdClienteFacturaProveedor(Border borderResaltar) {
		this.resaltarFK_IdClienteFacturaProveedor= borderResaltar;
	}

	public void setResaltarFK_IdClienteFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteFacturaProveedor= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableCreditoFiscalBienesFacturaProveedor=null;

	public Border getResaltarFK_IdCuentaContableCreditoFiscalBienesFacturaProveedor() {
		return this.resaltarFK_IdCuentaContableCreditoFiscalBienesFacturaProveedor;
	}

	public void setResaltarFK_IdCuentaContableCreditoFiscalBienesFacturaProveedor(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableCreditoFiscalBienesFacturaProveedor= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableCreditoFiscalBienesFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableCreditoFiscalBienesFacturaProveedor= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableCreditoFiscalServiciosFacturaProveedor=null;

	public Border getResaltarFK_IdCuentaContableCreditoFiscalServiciosFacturaProveedor() {
		return this.resaltarFK_IdCuentaContableCreditoFiscalServiciosFacturaProveedor;
	}

	public void setResaltarFK_IdCuentaContableCreditoFiscalServiciosFacturaProveedor(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableCreditoFiscalServiciosFacturaProveedor= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableCreditoFiscalServiciosFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableCreditoFiscalServiciosFacturaProveedor= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableGasto2FacturaProveedor=null;

	public Border getResaltarFK_IdCuentaContableGasto2FacturaProveedor() {
		return this.resaltarFK_IdCuentaContableGasto2FacturaProveedor;
	}

	public void setResaltarFK_IdCuentaContableGasto2FacturaProveedor(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableGasto2FacturaProveedor= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableGasto2FacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableGasto2FacturaProveedor= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioFacturaProveedor=null;

	public Border getResaltarFK_IdEjercicioFacturaProveedor() {
		return this.resaltarFK_IdEjercicioFacturaProveedor;
	}

	public void setResaltarFK_IdEjercicioFacturaProveedor(Border borderResaltar) {
		this.resaltarFK_IdEjercicioFacturaProveedor= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioFacturaProveedor= borderResaltar;
	}

	public Border resaltarFK_IdEmpleadoFacturaProveedor=null;

	public Border getResaltarFK_IdEmpleadoFacturaProveedor() {
		return this.resaltarFK_IdEmpleadoFacturaProveedor;
	}

	public void setResaltarFK_IdEmpleadoFacturaProveedor(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoFacturaProveedor= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoFacturaProveedor= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaFacturaProveedor=null;

	public Border getResaltarFK_IdEmpresaFacturaProveedor() {
		return this.resaltarFK_IdEmpresaFacturaProveedor;
	}

	public void setResaltarFK_IdEmpresaFacturaProveedor(Border borderResaltar) {
		this.resaltarFK_IdEmpresaFacturaProveedor= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaFacturaProveedor= borderResaltar;
	}

	public Border resaltarFK_IdModuloFacturaProveedor=null;

	public Border getResaltarFK_IdModuloFacturaProveedor() {
		return this.resaltarFK_IdModuloFacturaProveedor;
	}

	public void setResaltarFK_IdModuloFacturaProveedor(Border borderResaltar) {
		this.resaltarFK_IdModuloFacturaProveedor= borderResaltar;
	}

	public void setResaltarFK_IdModuloFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdModuloFacturaProveedor= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoFacturaProveedor=null;

	public Border getResaltarFK_IdPeriodoFacturaProveedor() {
		return this.resaltarFK_IdPeriodoFacturaProveedor;
	}

	public void setResaltarFK_IdPeriodoFacturaProveedor(Border borderResaltar) {
		this.resaltarFK_IdPeriodoFacturaProveedor= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoFacturaProveedor= borderResaltar;
	}

	public Border resaltarFK_IdPlantillaFacturaFacturaProveedor=null;

	public Border getResaltarFK_IdPlantillaFacturaFacturaProveedor() {
		return this.resaltarFK_IdPlantillaFacturaFacturaProveedor;
	}

	public void setResaltarFK_IdPlantillaFacturaFacturaProveedor(Border borderResaltar) {
		this.resaltarFK_IdPlantillaFacturaFacturaProveedor= borderResaltar;
	}

	public void setResaltarFK_IdPlantillaFacturaFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPlantillaFacturaFacturaProveedor= borderResaltar;
	}

	public Border resaltarFK_IdResponsableFondoFacturaProveedor=null;

	public Border getResaltarFK_IdResponsableFondoFacturaProveedor() {
		return this.resaltarFK_IdResponsableFondoFacturaProveedor;
	}

	public void setResaltarFK_IdResponsableFondoFacturaProveedor(Border borderResaltar) {
		this.resaltarFK_IdResponsableFondoFacturaProveedor= borderResaltar;
	}

	public void setResaltarFK_IdResponsableFondoFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdResponsableFondoFacturaProveedor= borderResaltar;
	}

	public Border resaltarFK_IdSucursalFacturaProveedor=null;

	public Border getResaltarFK_IdSucursalFacturaProveedor() {
		return this.resaltarFK_IdSucursalFacturaProveedor;
	}

	public void setResaltarFK_IdSucursalFacturaProveedor(Border borderResaltar) {
		this.resaltarFK_IdSucursalFacturaProveedor= borderResaltar;
	}

	public void setResaltarFK_IdSucursalFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalFacturaProveedor= borderResaltar;
	}

	public Border resaltarFK_IdTipoDocumentoFacturaProveedor=null;

	public Border getResaltarFK_IdTipoDocumentoFacturaProveedor() {
		return this.resaltarFK_IdTipoDocumentoFacturaProveedor;
	}

	public void setResaltarFK_IdTipoDocumentoFacturaProveedor(Border borderResaltar) {
		this.resaltarFK_IdTipoDocumentoFacturaProveedor= borderResaltar;
	}

	public void setResaltarFK_IdTipoDocumentoFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoDocumentoFacturaProveedor= borderResaltar;
	}

	public Border resaltarFK_IdTipoMovimientoModuloFacturaProveedor=null;

	public Border getResaltarFK_IdTipoMovimientoModuloFacturaProveedor() {
		return this.resaltarFK_IdTipoMovimientoModuloFacturaProveedor;
	}

	public void setResaltarFK_IdTipoMovimientoModuloFacturaProveedor(Border borderResaltar) {
		this.resaltarFK_IdTipoMovimientoModuloFacturaProveedor= borderResaltar;
	}

	public void setResaltarFK_IdTipoMovimientoModuloFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoMovimientoModuloFacturaProveedor= borderResaltar;
	}

	public Border resaltarFK_IdTipoRetencionFuente1FacturaProveedor=null;

	public Border getResaltarFK_IdTipoRetencionFuente1FacturaProveedor() {
		return this.resaltarFK_IdTipoRetencionFuente1FacturaProveedor;
	}

	public void setResaltarFK_IdTipoRetencionFuente1FacturaProveedor(Border borderResaltar) {
		this.resaltarFK_IdTipoRetencionFuente1FacturaProveedor= borderResaltar;
	}

	public void setResaltarFK_IdTipoRetencionFuente1FacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoRetencionFuente1FacturaProveedor= borderResaltar;
	}

	public Border resaltarFK_IdTipoRetencionIva1FacturaProveedor=null;

	public Border getResaltarFK_IdTipoRetencionIva1FacturaProveedor() {
		return this.resaltarFK_IdTipoRetencionIva1FacturaProveedor;
	}

	public void setResaltarFK_IdTipoRetencionIva1FacturaProveedor(Border borderResaltar) {
		this.resaltarFK_IdTipoRetencionIva1FacturaProveedor= borderResaltar;
	}

	public void setResaltarFK_IdTipoRetencionIva1FacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoRetencionIva1FacturaProveedor= borderResaltar;
	}

	public Border resaltarFK_IdTipoTransaccionModuloFacturaProveedor=null;

	public Border getResaltarFK_IdTipoTransaccionModuloFacturaProveedor() {
		return this.resaltarFK_IdTipoTransaccionModuloFacturaProveedor;
	}

	public void setResaltarFK_IdTipoTransaccionModuloFacturaProveedor(Border borderResaltar) {
		this.resaltarFK_IdTipoTransaccionModuloFacturaProveedor= borderResaltar;
	}

	public void setResaltarFK_IdTipoTransaccionModuloFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoTransaccionModuloFacturaProveedor= borderResaltar;
	}

	public Border resaltarFK_IdTipoTributarioFacturaProveedor=null;

	public Border getResaltarFK_IdTipoTributarioFacturaProveedor() {
		return this.resaltarFK_IdTipoTributarioFacturaProveedor;
	}

	public void setResaltarFK_IdTipoTributarioFacturaProveedor(Border borderResaltar) {
		this.resaltarFK_IdTipoTributarioFacturaProveedor= borderResaltar;
	}

	public void setResaltarFK_IdTipoTributarioFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoTributarioFacturaProveedor= borderResaltar;
	}

	public Border resaltarFK_IdTransaccionFacturaProveedor=null;

	public Border getResaltarFK_IdTransaccionFacturaProveedor() {
		return this.resaltarFK_IdTransaccionFacturaProveedor;
	}

	public void setResaltarFK_IdTransaccionFacturaProveedor(Border borderResaltar) {
		this.resaltarFK_IdTransaccionFacturaProveedor= borderResaltar;
	}

	public void setResaltarFK_IdTransaccionFacturaProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorBeanSwingJInternalFrame facturaproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTransaccionFacturaProveedor= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}