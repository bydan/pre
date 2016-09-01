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


import com.bydan.erp.contabilidad.util.FacturaProveedorServicioConstantesFunciones;
import com.bydan.erp.contabilidad.util.FacturaProveedorServicioParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.FacturaProveedorServicioParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.facturacion.util.*;
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
final public class FacturaProveedorServicioConstantesFunciones extends FacturaProveedorServicioConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="FacturaProveedorServicio";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="FacturaProveedorServicio"+FacturaProveedorServicioConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="FacturaProveedorServicioHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="FacturaProveedorServicioHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=FacturaProveedorServicioConstantesFunciones.SCHEMA+"_"+FacturaProveedorServicioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/FacturaProveedorServicioHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=FacturaProveedorServicioConstantesFunciones.SCHEMA+"_"+FacturaProveedorServicioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=FacturaProveedorServicioConstantesFunciones.SCHEMA+"_"+FacturaProveedorServicioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/FacturaProveedorServicioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=FacturaProveedorServicioConstantesFunciones.SCHEMA+"_"+FacturaProveedorServicioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FacturaProveedorServicioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/FacturaProveedorServicioHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FacturaProveedorServicioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FacturaProveedorServicioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/FacturaProveedorServicioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FacturaProveedorServicioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=FacturaProveedorServicioConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+FacturaProveedorServicioConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=FacturaProveedorServicioConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+FacturaProveedorServicioConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Factura Proveedors";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Factura Proveedor";
	public static final String SCLASSWEBTITULO_LOWER="Factura Proveedor Servicio";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="FacturaProveedorServicio";
	public static final String OBJECTNAME="facturaproveedorservicio";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="factura_proveedor_servicio";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select facturaproveedorservicio from "+FacturaProveedorServicioConstantesFunciones.SPERSISTENCENAME+" facturaproveedorservicio";
	public static String QUERYSELECTNATIVE="select "+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".id,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".version_row,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".id_empresa,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".id_sucursal,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".id_ejercicio,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".id_periodo,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".id_anio,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".id_mes,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".id_modulo,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".id_transaccion,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".id_factura,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".numero_factura,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".id_cliente,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".ruc,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".id_tipo_documento,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".plazo,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".con_rise,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".fecha_emision,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".fecha_vence,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".id_empleado_solicita,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".id_empleado,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".detalle,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".numero_retencion,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".numero_autorizacion,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".numero_serie,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".id_tipo_tributario,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".fecha_validez,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".anexo_factura_inicio,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".anexo_factura_fin,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".id_moneda,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".valor_servicios0,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".total_iva,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".iva_porcentaje,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".total,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".numero_mayor,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".codigo_asiento,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".id_tipo_retencion_fuente1,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".id_tipo_retencion_iva1,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".anexo_numero_autorizacion,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".anexo_numeso_serie,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".anexo_fecha_validez,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".id_cuenta_contable_credito_fiscal_servicios,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".descripcion,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".id_tipo_movimiento,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".id_tipo_movimiento_modulo,"+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME+".id_tipo_transaccion_modulo from "+FacturaProveedorServicioConstantesFunciones.SCHEMA+"."+FacturaProveedorServicioConstantesFunciones.TABLENAME;//+" as "+FacturaProveedorServicioConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected FacturaProveedorServicioConstantesFuncionesAdditional facturaproveedorservicioConstantesFuncionesAdditional=null;
	
	public FacturaProveedorServicioConstantesFuncionesAdditional getFacturaProveedorServicioConstantesFuncionesAdditional() {
		return this.facturaproveedorservicioConstantesFuncionesAdditional;
	}
	
	public void setFacturaProveedorServicioConstantesFuncionesAdditional(FacturaProveedorServicioConstantesFuncionesAdditional facturaproveedorservicioConstantesFuncionesAdditional) {
		try {
			this.facturaproveedorservicioConstantesFuncionesAdditional=facturaproveedorservicioConstantesFuncionesAdditional;
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
    public static final String IDTRANSACCION= "id_transaccion";
    public static final String IDFACTURA= "id_factura";
    public static final String NUMEROFACTURA= "numero_factura";
    public static final String IDCLIENTE= "id_cliente";
    public static final String RUC= "ruc";
    public static final String IDTIPODOCUMENTO= "id_tipo_documento";
    public static final String PLAZO= "plazo";
    public static final String CONRISE= "con_rise";
    public static final String FECHAEMISION= "fecha_emision";
    public static final String FECHAVENCE= "fecha_vence";
    public static final String IDEMPLEADOSOLICITA= "id_empleado_solicita";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String DETALLE= "detalle";
    public static final String NUMERORETENCION= "numero_retencion";
    public static final String NUMEROAUTORIZACION= "numero_autorizacion";
    public static final String NUMEROSERIE= "numero_serie";
    public static final String IDTIPOTRIBUTARIO= "id_tipo_tributario";
    public static final String FECHAVALIDEZ= "fecha_validez";
    public static final String ANEXOFACTURAINICIO= "anexo_factura_inicio";
    public static final String ANEXOFACTURAFIN= "anexo_factura_fin";
    public static final String IDMONEDA= "id_moneda";
    public static final String VALORSERVICIOS0= "valor_servicios0";
    public static final String TOTALIVA= "total_iva";
    public static final String IVAPORCENTAJE= "iva_porcentaje";
    public static final String TOTAL= "total";
    public static final String NUMEROMAYOR= "numero_mayor";
    public static final String CODIGOASIENTO= "codigo_asiento";
    public static final String IDTIPORETENCIONFUENTE1= "id_tipo_retencion_fuente1";
    public static final String IDTIPORETENCIONIVA1= "id_tipo_retencion_iva1";
    public static final String ANEXONUMEROAUTORIZACION= "anexo_numero_autorizacion";
    public static final String ANEXONUMESOSERIE= "anexo_numeso_serie";
    public static final String ANEXOFECHAVALIDEZ= "anexo_fecha_validez";
    public static final String IDCUENTACONTABLECREDITOFISCALSERVICIOS= "id_cuenta_contable_credito_fiscal_servicios";
    public static final String DESCRIPCION= "descripcion";
    public static final String IDTIPOMOVIMIENTO= "id_tipo_movimiento";
    public static final String IDTIPOMOVIMIENTOMODULO= "id_tipo_movimiento_modulo";
    public static final String IDTIPOTRANSACCIONMODULO= "id_tipo_transaccion_modulo";
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
    	public static final String LABEL_IDTRANSACCION= "Comprobante";
		public static final String LABEL_IDTRANSACCION_LOWER= "Comprobante";
    	public static final String LABEL_IDFACTURA= "Factura";
		public static final String LABEL_IDFACTURA_LOWER= "Factura";
    	public static final String LABEL_NUMEROFACTURA= "No Factura";
		public static final String LABEL_NUMEROFACTURA_LOWER= "No Factura";
    	public static final String LABEL_IDCLIENTE= "Proveedor";
		public static final String LABEL_IDCLIENTE_LOWER= "Proveedor";
    	public static final String LABEL_RUC= "Ruc";
		public static final String LABEL_RUC_LOWER= "Ruc";
    	public static final String LABEL_IDTIPODOCUMENTO= "T. Documento";
		public static final String LABEL_IDTIPODOCUMENTO_LOWER= "T. Documento";
    	public static final String LABEL_PLAZO= "Plazo";
		public static final String LABEL_PLAZO_LOWER= "Plazo";
    	public static final String LABEL_CONRISE= "Con Rise";
		public static final String LABEL_CONRISE_LOWER= "Rise";
    	public static final String LABEL_FECHAEMISION= "F. Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "Fecha Emi";
    	public static final String LABEL_FECHAVENCE= "F. Vence";
		public static final String LABEL_FECHAVENCE_LOWER= "Fecha Vence";
    	public static final String LABEL_IDEMPLEADOSOLICITA= "Empl. Solicita";
		public static final String LABEL_IDEMPLEADOSOLICITA_LOWER= "Empl Solicita";
    	public static final String LABEL_IDEMPLEADO= "Empl. Autoriza";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empl Autoriza";
    	public static final String LABEL_DETALLE= "Detalle";
		public static final String LABEL_DETALLE_LOWER= "Detalle";
    	public static final String LABEL_NUMERORETENCION= "No Retencion";
		public static final String LABEL_NUMERORETENCION_LOWER= "No Retencion";
    	public static final String LABEL_NUMEROAUTORIZACION= "No Autorizacion";
		public static final String LABEL_NUMEROAUTORIZACION_LOWER= "No Autori.";
    	public static final String LABEL_NUMEROSERIE= "No Serie";
		public static final String LABEL_NUMEROSERIE_LOWER= "No Serie";
    	public static final String LABEL_IDTIPOTRIBUTARIO= "T. Tributario";
		public static final String LABEL_IDTIPOTRIBUTARIO_LOWER= "Sust. Tributario";
    	public static final String LABEL_FECHAVALIDEZ= "F. Validez";
		public static final String LABEL_FECHAVALIDEZ_LOWER= "Fec Validez";
    	public static final String LABEL_ANEXOFACTURAINICIO= "Fac Ini";
		public static final String LABEL_ANEXOFACTURAINICIO_LOWER= "Fac Ini";
    	public static final String LABEL_ANEXOFACTURAFIN= "Fac Fin";
		public static final String LABEL_ANEXOFACTURAFIN_LOWER= "Fac Fin";
    	public static final String LABEL_IDMONEDA= "Moneda";
		public static final String LABEL_IDMONEDA_LOWER= "Moneda";
    	public static final String LABEL_VALORSERVICIOS0= "Valor Servicios0";
		public static final String LABEL_VALORSERVICIOS0_LOWER= "Val Servicios 0";
    	public static final String LABEL_TOTALIVA= "Total Iva";
		public static final String LABEL_TOTALIVA_LOWER= "Total Iva";
    	public static final String LABEL_IVAPORCENTAJE= "Iva Porcentaje";
		public static final String LABEL_IVAPORCENTAJE_LOWER= "Iva %";
    	public static final String LABEL_TOTAL= "Total";
		public static final String LABEL_TOTAL_LOWER= "Total";
    	public static final String LABEL_NUMEROMAYOR= "Numero Mayor";
		public static final String LABEL_NUMEROMAYOR_LOWER= "Numero Mayor";
    	public static final String LABEL_CODIGOASIENTO= "Codigo Asiento";
		public static final String LABEL_CODIGOASIENTO_LOWER= "Codigo Asiento";
    	public static final String LABEL_IDTIPORETENCIONFUENTE1= "Tipo Retencion Fuente1";
		public static final String LABEL_IDTIPORETENCIONFUENTE1_LOWER= "RET FUENTE 1 ->";
    	public static final String LABEL_IDTIPORETENCIONIVA1= "Tipo Retencion Iva1";
		public static final String LABEL_IDTIPORETENCIONIVA1_LOWER= "RET IVA BIEN ->";
    	public static final String LABEL_ANEXONUMEROAUTORIZACION= "Anexo Numero Autorizacion";
		public static final String LABEL_ANEXONUMEROAUTORIZACION_LOWER= "No Autorizacion";
    	public static final String LABEL_ANEXONUMESOSERIE= "Anexo Numeso Serie";
		public static final String LABEL_ANEXONUMESOSERIE_LOWER= "No Serie";
    	public static final String LABEL_ANEXOFECHAVALIDEZ= "Anexo Fecha Validez";
		public static final String LABEL_ANEXOFECHAVALIDEZ_LOWER= "Fec Validez";
    	public static final String LABEL_IDCUENTACONTABLECREDITOFISCALSERVICIOS= "Idcuenta Contable Credito Fiscal Servicios";
		public static final String LABEL_IDCUENTACONTABLECREDITOFISCALSERVICIOS_LOWER= "C.Credito Fiscal Servicios";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_IDTIPOMOVIMIENTO= "Tipo Movimiento";
		public static final String LABEL_IDTIPOMOVIMIENTO_LOWER= "Tipo Movimiento";
    	public static final String LABEL_IDTIPOMOVIMIENTOMODULO= "Tipo Movimiento Modulo";
		public static final String LABEL_IDTIPOMOVIMIENTOMODULO_LOWER= "Tipo Movimiento Modulo";
    	public static final String LABEL_IDTIPOTRANSACCIONMODULO= "Tipo Comprobante";
		public static final String LABEL_IDTIPOTRANSACCIONMODULO_LOWER= "Tipo Comprobante";
	
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXNUMERO_FACTURA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_FACTURA=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXRUC=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXRUC=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
	public static final String SREGEXDETALLE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDETALLE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_RETENCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_RETENCION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_AUTORIZACION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_AUTORIZACION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_SERIE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_SERIE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXANEXO_FACTURA_INICIO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXANEXO_FACTURA_INICIO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXANEXO_FACTURA_FIN=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXANEXO_FACTURA_FIN=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
	public static final String SREGEXNUMERO_MAYOR=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_MAYOR=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO_ASIENTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_ASIENTO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXANEXO_NUMERO_AUTORIZACION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXANEXO_NUMERO_AUTORIZACION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXANEXO_NUMESO_SERIE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXANEXO_NUMESO_SERIE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
	
	public static String getFacturaProveedorServicioLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(FacturaProveedorServicioConstantesFunciones.IDEMPRESA)) {sLabelColumna=FacturaProveedorServicioConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(FacturaProveedorServicioConstantesFunciones.IDSUCURSAL)) {sLabelColumna=FacturaProveedorServicioConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(FacturaProveedorServicioConstantesFunciones.IDEJERCICIO)) {sLabelColumna=FacturaProveedorServicioConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(FacturaProveedorServicioConstantesFunciones.IDPERIODO)) {sLabelColumna=FacturaProveedorServicioConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(FacturaProveedorServicioConstantesFunciones.IDANIO)) {sLabelColumna=FacturaProveedorServicioConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(FacturaProveedorServicioConstantesFunciones.IDMES)) {sLabelColumna=FacturaProveedorServicioConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(FacturaProveedorServicioConstantesFunciones.IDMODULO)) {sLabelColumna=FacturaProveedorServicioConstantesFunciones.LABEL_IDMODULO;}
		if(sNombreColumna.equals(FacturaProveedorServicioConstantesFunciones.IDTRANSACCION)) {sLabelColumna=FacturaProveedorServicioConstantesFunciones.LABEL_IDTRANSACCION;}
		if(sNombreColumna.equals(FacturaProveedorServicioConstantesFunciones.IDFACTURA)) {sLabelColumna=FacturaProveedorServicioConstantesFunciones.LABEL_IDFACTURA;}
		if(sNombreColumna.equals(FacturaProveedorServicioConstantesFunciones.NUMEROFACTURA)) {sLabelColumna=FacturaProveedorServicioConstantesFunciones.LABEL_NUMEROFACTURA;}
		if(sNombreColumna.equals(FacturaProveedorServicioConstantesFunciones.IDCLIENTE)) {sLabelColumna=FacturaProveedorServicioConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(FacturaProveedorServicioConstantesFunciones.RUC)) {sLabelColumna=FacturaProveedorServicioConstantesFunciones.LABEL_RUC;}
		if(sNombreColumna.equals(FacturaProveedorServicioConstantesFunciones.IDTIPODOCUMENTO)) {sLabelColumna=FacturaProveedorServicioConstantesFunciones.LABEL_IDTIPODOCUMENTO;}
		if(sNombreColumna.equals(FacturaProveedorServicioConstantesFunciones.PLAZO)) {sLabelColumna=FacturaProveedorServicioConstantesFunciones.LABEL_PLAZO;}
		if(sNombreColumna.equals(FacturaProveedorServicioConstantesFunciones.CONRISE)) {sLabelColumna=FacturaProveedorServicioConstantesFunciones.LABEL_CONRISE;}
		if(sNombreColumna.equals(FacturaProveedorServicioConstantesFunciones.FECHAEMISION)) {sLabelColumna=FacturaProveedorServicioConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(FacturaProveedorServicioConstantesFunciones.FECHAVENCE)) {sLabelColumna=FacturaProveedorServicioConstantesFunciones.LABEL_FECHAVENCE;}
		if(sNombreColumna.equals(FacturaProveedorServicioConstantesFunciones.IDEMPLEADOSOLICITA)) {sLabelColumna=FacturaProveedorServicioConstantesFunciones.LABEL_IDEMPLEADOSOLICITA;}
		if(sNombreColumna.equals(FacturaProveedorServicioConstantesFunciones.IDEMPLEADO)) {sLabelColumna=FacturaProveedorServicioConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(FacturaProveedorServicioConstantesFunciones.DETALLE)) {sLabelColumna=FacturaProveedorServicioConstantesFunciones.LABEL_DETALLE;}
		if(sNombreColumna.equals(FacturaProveedorServicioConstantesFunciones.NUMERORETENCION)) {sLabelColumna=FacturaProveedorServicioConstantesFunciones.LABEL_NUMERORETENCION;}
		if(sNombreColumna.equals(FacturaProveedorServicioConstantesFunciones.NUMEROAUTORIZACION)) {sLabelColumna=FacturaProveedorServicioConstantesFunciones.LABEL_NUMEROAUTORIZACION;}
		if(sNombreColumna.equals(FacturaProveedorServicioConstantesFunciones.NUMEROSERIE)) {sLabelColumna=FacturaProveedorServicioConstantesFunciones.LABEL_NUMEROSERIE;}
		if(sNombreColumna.equals(FacturaProveedorServicioConstantesFunciones.IDTIPOTRIBUTARIO)) {sLabelColumna=FacturaProveedorServicioConstantesFunciones.LABEL_IDTIPOTRIBUTARIO;}
		if(sNombreColumna.equals(FacturaProveedorServicioConstantesFunciones.FECHAVALIDEZ)) {sLabelColumna=FacturaProveedorServicioConstantesFunciones.LABEL_FECHAVALIDEZ;}
		if(sNombreColumna.equals(FacturaProveedorServicioConstantesFunciones.ANEXOFACTURAINICIO)) {sLabelColumna=FacturaProveedorServicioConstantesFunciones.LABEL_ANEXOFACTURAINICIO;}
		if(sNombreColumna.equals(FacturaProveedorServicioConstantesFunciones.ANEXOFACTURAFIN)) {sLabelColumna=FacturaProveedorServicioConstantesFunciones.LABEL_ANEXOFACTURAFIN;}
		if(sNombreColumna.equals(FacturaProveedorServicioConstantesFunciones.IDMONEDA)) {sLabelColumna=FacturaProveedorServicioConstantesFunciones.LABEL_IDMONEDA;}
		if(sNombreColumna.equals(FacturaProveedorServicioConstantesFunciones.VALORSERVICIOS0)) {sLabelColumna=FacturaProveedorServicioConstantesFunciones.LABEL_VALORSERVICIOS0;}
		if(sNombreColumna.equals(FacturaProveedorServicioConstantesFunciones.TOTALIVA)) {sLabelColumna=FacturaProveedorServicioConstantesFunciones.LABEL_TOTALIVA;}
		if(sNombreColumna.equals(FacturaProveedorServicioConstantesFunciones.IVAPORCENTAJE)) {sLabelColumna=FacturaProveedorServicioConstantesFunciones.LABEL_IVAPORCENTAJE;}
		if(sNombreColumna.equals(FacturaProveedorServicioConstantesFunciones.TOTAL)) {sLabelColumna=FacturaProveedorServicioConstantesFunciones.LABEL_TOTAL;}
		if(sNombreColumna.equals(FacturaProveedorServicioConstantesFunciones.NUMEROMAYOR)) {sLabelColumna=FacturaProveedorServicioConstantesFunciones.LABEL_NUMEROMAYOR;}
		if(sNombreColumna.equals(FacturaProveedorServicioConstantesFunciones.CODIGOASIENTO)) {sLabelColumna=FacturaProveedorServicioConstantesFunciones.LABEL_CODIGOASIENTO;}
		if(sNombreColumna.equals(FacturaProveedorServicioConstantesFunciones.IDTIPORETENCIONFUENTE1)) {sLabelColumna=FacturaProveedorServicioConstantesFunciones.LABEL_IDTIPORETENCIONFUENTE1;}
		if(sNombreColumna.equals(FacturaProveedorServicioConstantesFunciones.IDTIPORETENCIONIVA1)) {sLabelColumna=FacturaProveedorServicioConstantesFunciones.LABEL_IDTIPORETENCIONIVA1;}
		if(sNombreColumna.equals(FacturaProveedorServicioConstantesFunciones.ANEXONUMEROAUTORIZACION)) {sLabelColumna=FacturaProveedorServicioConstantesFunciones.LABEL_ANEXONUMEROAUTORIZACION;}
		if(sNombreColumna.equals(FacturaProveedorServicioConstantesFunciones.ANEXONUMESOSERIE)) {sLabelColumna=FacturaProveedorServicioConstantesFunciones.LABEL_ANEXONUMESOSERIE;}
		if(sNombreColumna.equals(FacturaProveedorServicioConstantesFunciones.ANEXOFECHAVALIDEZ)) {sLabelColumna=FacturaProveedorServicioConstantesFunciones.LABEL_ANEXOFECHAVALIDEZ;}
		if(sNombreColumna.equals(FacturaProveedorServicioConstantesFunciones.IDCUENTACONTABLECREDITOFISCALSERVICIOS)) {sLabelColumna=FacturaProveedorServicioConstantesFunciones.LABEL_IDCUENTACONTABLECREDITOFISCALSERVICIOS;}
		if(sNombreColumna.equals(FacturaProveedorServicioConstantesFunciones.DESCRIPCION)) {sLabelColumna=FacturaProveedorServicioConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(FacturaProveedorServicioConstantesFunciones.IDTIPOMOVIMIENTO)) {sLabelColumna=FacturaProveedorServicioConstantesFunciones.LABEL_IDTIPOMOVIMIENTO;}
		if(sNombreColumna.equals(FacturaProveedorServicioConstantesFunciones.IDTIPOMOVIMIENTOMODULO)) {sLabelColumna=FacturaProveedorServicioConstantesFunciones.LABEL_IDTIPOMOVIMIENTOMODULO;}
		if(sNombreColumna.equals(FacturaProveedorServicioConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {sLabelColumna=FacturaProveedorServicioConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getcon_riseDescripcion(FacturaProveedorServicio facturaproveedorservicio) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!facturaproveedorservicio.getcon_rise()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_riseHtmlDescripcion(FacturaProveedorServicio facturaproveedorservicio) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(facturaproveedorservicio.getId(),facturaproveedorservicio.getcon_rise());

		return sDescripcion;
	}	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getFacturaProveedorServicioDescripcion(FacturaProveedorServicio facturaproveedorservicio) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(facturaproveedorservicio !=null/* && facturaproveedorservicio.getId()!=0*/) {
			if(facturaproveedorservicio.getId()!=null) {
				sDescripcion=facturaproveedorservicio.getId().toString();
			}//facturaproveedorserviciofacturaproveedorservicio.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getFacturaProveedorServicioDescripcionDetallado(FacturaProveedorServicio facturaproveedorservicio) {
		String sDescripcion="";
			
		sDescripcion+=FacturaProveedorServicioConstantesFunciones.ID+"=";
		sDescripcion+=facturaproveedorservicio.getId().toString()+",";
		sDescripcion+=FacturaProveedorServicioConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=facturaproveedorservicio.getVersionRow().toString()+",";
		sDescripcion+=FacturaProveedorServicioConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=facturaproveedorservicio.getid_empresa().toString()+",";
		sDescripcion+=FacturaProveedorServicioConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=facturaproveedorservicio.getid_sucursal().toString()+",";
		sDescripcion+=FacturaProveedorServicioConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=facturaproveedorservicio.getid_ejercicio().toString()+",";
		sDescripcion+=FacturaProveedorServicioConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=facturaproveedorservicio.getid_periodo().toString()+",";
		sDescripcion+=FacturaProveedorServicioConstantesFunciones.IDANIO+"=";
		sDescripcion+=facturaproveedorservicio.getid_anio().toString()+",";
		sDescripcion+=FacturaProveedorServicioConstantesFunciones.IDMES+"=";
		sDescripcion+=facturaproveedorservicio.getid_mes().toString()+",";
		sDescripcion+=FacturaProveedorServicioConstantesFunciones.IDMODULO+"=";
		sDescripcion+=facturaproveedorservicio.getid_modulo().toString()+",";
		sDescripcion+=FacturaProveedorServicioConstantesFunciones.IDTRANSACCION+"=";
		sDescripcion+=facturaproveedorservicio.getid_transaccion().toString()+",";
		sDescripcion+=FacturaProveedorServicioConstantesFunciones.IDFACTURA+"=";
		sDescripcion+=facturaproveedorservicio.getid_factura().toString()+",";
		sDescripcion+=FacturaProveedorServicioConstantesFunciones.NUMEROFACTURA+"=";
		sDescripcion+=facturaproveedorservicio.getnumero_factura()+",";
		sDescripcion+=FacturaProveedorServicioConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=facturaproveedorservicio.getid_cliente().toString()+",";
		sDescripcion+=FacturaProveedorServicioConstantesFunciones.RUC+"=";
		sDescripcion+=facturaproveedorservicio.getruc()+",";
		sDescripcion+=FacturaProveedorServicioConstantesFunciones.IDTIPODOCUMENTO+"=";
		sDescripcion+=facturaproveedorservicio.getid_tipo_documento().toString()+",";
		sDescripcion+=FacturaProveedorServicioConstantesFunciones.PLAZO+"=";
		sDescripcion+=facturaproveedorservicio.getplazo().toString()+",";
		sDescripcion+=FacturaProveedorServicioConstantesFunciones.CONRISE+"=";
		sDescripcion+=facturaproveedorservicio.getcon_rise().toString()+",";
		sDescripcion+=FacturaProveedorServicioConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=facturaproveedorservicio.getfecha_emision().toString()+",";
		sDescripcion+=FacturaProveedorServicioConstantesFunciones.FECHAVENCE+"=";
		sDescripcion+=facturaproveedorservicio.getfecha_vence().toString()+",";
		sDescripcion+=FacturaProveedorServicioConstantesFunciones.IDEMPLEADOSOLICITA+"=";
		sDescripcion+=facturaproveedorservicio.getid_empleado_solicita().toString()+",";
		sDescripcion+=FacturaProveedorServicioConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=facturaproveedorservicio.getid_empleado().toString()+",";
		sDescripcion+=FacturaProveedorServicioConstantesFunciones.DETALLE+"=";
		sDescripcion+=facturaproveedorservicio.getdetalle()+",";
		sDescripcion+=FacturaProveedorServicioConstantesFunciones.NUMERORETENCION+"=";
		sDescripcion+=facturaproveedorservicio.getnumero_retencion()+",";
		sDescripcion+=FacturaProveedorServicioConstantesFunciones.NUMEROAUTORIZACION+"=";
		sDescripcion+=facturaproveedorservicio.getnumero_autorizacion()+",";
		sDescripcion+=FacturaProveedorServicioConstantesFunciones.NUMEROSERIE+"=";
		sDescripcion+=facturaproveedorservicio.getnumero_serie()+",";
		sDescripcion+=FacturaProveedorServicioConstantesFunciones.IDTIPOTRIBUTARIO+"=";
		sDescripcion+=facturaproveedorservicio.getid_tipo_tributario().toString()+",";
		sDescripcion+=FacturaProveedorServicioConstantesFunciones.FECHAVALIDEZ+"=";
		sDescripcion+=facturaproveedorservicio.getfecha_validez().toString()+",";
		sDescripcion+=FacturaProveedorServicioConstantesFunciones.ANEXOFACTURAINICIO+"=";
		sDescripcion+=facturaproveedorservicio.getanexo_factura_inicio()+",";
		sDescripcion+=FacturaProveedorServicioConstantesFunciones.ANEXOFACTURAFIN+"=";
		sDescripcion+=facturaproveedorservicio.getanexo_factura_fin()+",";
		sDescripcion+=FacturaProveedorServicioConstantesFunciones.IDMONEDA+"=";
		sDescripcion+=facturaproveedorservicio.getid_moneda().toString()+",";
		sDescripcion+=FacturaProveedorServicioConstantesFunciones.VALORSERVICIOS0+"=";
		sDescripcion+=facturaproveedorservicio.getvalor_servicios0().toString()+",";
		sDescripcion+=FacturaProveedorServicioConstantesFunciones.TOTALIVA+"=";
		sDescripcion+=facturaproveedorservicio.gettotal_iva().toString()+",";
		sDescripcion+=FacturaProveedorServicioConstantesFunciones.IVAPORCENTAJE+"=";
		sDescripcion+=facturaproveedorservicio.getiva_porcentaje().toString()+",";
		sDescripcion+=FacturaProveedorServicioConstantesFunciones.TOTAL+"=";
		sDescripcion+=facturaproveedorservicio.gettotal().toString()+",";
		sDescripcion+=FacturaProveedorServicioConstantesFunciones.NUMEROMAYOR+"=";
		sDescripcion+=facturaproveedorservicio.getnumero_mayor()+",";
		sDescripcion+=FacturaProveedorServicioConstantesFunciones.CODIGOASIENTO+"=";
		sDescripcion+=facturaproveedorservicio.getcodigo_asiento()+",";
		sDescripcion+=FacturaProveedorServicioConstantesFunciones.IDTIPORETENCIONFUENTE1+"=";
		sDescripcion+=facturaproveedorservicio.getid_tipo_retencion_fuente1().toString()+",";
		sDescripcion+=FacturaProveedorServicioConstantesFunciones.IDTIPORETENCIONIVA1+"=";
		sDescripcion+=facturaproveedorservicio.getid_tipo_retencion_iva1().toString()+",";
		sDescripcion+=FacturaProveedorServicioConstantesFunciones.ANEXONUMEROAUTORIZACION+"=";
		sDescripcion+=facturaproveedorservicio.getanexo_numero_autorizacion()+",";
		sDescripcion+=FacturaProveedorServicioConstantesFunciones.ANEXONUMESOSERIE+"=";
		sDescripcion+=facturaproveedorservicio.getanexo_numeso_serie()+",";
		sDescripcion+=FacturaProveedorServicioConstantesFunciones.ANEXOFECHAVALIDEZ+"=";
		sDescripcion+=facturaproveedorservicio.getanexo_fecha_validez().toString()+",";
		sDescripcion+=FacturaProveedorServicioConstantesFunciones.IDCUENTACONTABLECREDITOFISCALSERVICIOS+"=";
		sDescripcion+=facturaproveedorservicio.getid_cuenta_contable_credito_fiscal_servicios().toString()+",";
		sDescripcion+=FacturaProveedorServicioConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=facturaproveedorservicio.getdescripcion()+",";
		sDescripcion+=FacturaProveedorServicioConstantesFunciones.IDTIPOMOVIMIENTO+"=";
		sDescripcion+=facturaproveedorservicio.getid_tipo_movimiento().toString()+",";
		sDescripcion+=FacturaProveedorServicioConstantesFunciones.IDTIPOMOVIMIENTOMODULO+"=";
		sDescripcion+=facturaproveedorservicio.getid_tipo_movimiento_modulo().toString()+",";
		sDescripcion+=FacturaProveedorServicioConstantesFunciones.IDTIPOTRANSACCIONMODULO+"=";
		sDescripcion+=facturaproveedorservicio.getid_tipo_transaccion_modulo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setFacturaProveedorServicioDescripcion(FacturaProveedorServicio facturaproveedorservicio,String sValor) throws Exception {			
		if(facturaproveedorservicio !=null) {
			//facturaproveedorserviciofacturaproveedorservicio.getId().toString();
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

	public static String getTransaccionDescripcion(Transaccion transaccion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transaccion!=null/*&&transaccion.getId()>0*/) {
			sDescripcion=TransaccionConstantesFunciones.getTransaccionDescripcion(transaccion);
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

	public static String getClienteDescripcion(Cliente cliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cliente!=null/*&&cliente.getId()>0*/) {
			sDescripcion=ClienteConstantesFunciones.getClienteDescripcion(cliente);
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

	public static String getEmpleadoSolicitaDescripcion(Empleado empleado) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empleado!=null/*&&empleado.getId()>0*/) {
			sDescripcion=EmpleadoConstantesFunciones.getEmpleadoDescripcion(empleado);
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

	public static String getTipoTributarioDescripcion(TipoTributario tipotributario) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipotributario!=null/*&&tipotributario.getId()>0*/) {
			sDescripcion=TipoTributarioConstantesFunciones.getTipoTributarioDescripcion(tipotributario);
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

	public static String getTipoRetencionFuente1Descripcion(TipoRetencion tiporetencion) {
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

	public static String getCuentaContableCreditoFiscalServiciosDescripcion(CuentaContable cuentacontable) {
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
		} else if(sNombreIndice.equals("FK_IdCuentaContableCreditoFiscalServicios")) {
			sNombreIndice="Tipo=  Por Idcuenta Contable Credito Fiscal Servicios";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpleado")) {
			sNombreIndice="Tipo=  Por Empl. Autoriza";
		} else if(sNombreIndice.equals("FK_IdEmpleadoSolicita")) {
			sNombreIndice="Tipo=  Por Empl. Solicita";
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
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoDocumento")) {
			sNombreIndice="Tipo=  Por T. Documento";
		} else if(sNombreIndice.equals("FK_IdTipoMovimiento")) {
			sNombreIndice="Tipo=  Por Tipo Movimiento";
		} else if(sNombreIndice.equals("FK_IdTipoMovimientoModulo")) {
			sNombreIndice="Tipo=  Por Tipo Movimiento Modulo";
		} else if(sNombreIndice.equals("FK_IdTipoRetencionFuente1")) {
			sNombreIndice="Tipo=  Por Tipo Retencion Fuente1";
		} else if(sNombreIndice.equals("FK_IdTipoRetencionIva1")) {
			sNombreIndice="Tipo=  Por Tipo Retencion Iva1";
		} else if(sNombreIndice.equals("FK_IdTipoTransaccionModulo")) {
			sNombreIndice="Tipo=  Por Tipo Comprobante";
		} else if(sNombreIndice.equals("FK_IdTipoTributario")) {
			sNombreIndice="Tipo=  Por T. Tributario";
		} else if(sNombreIndice.equals("FK_IdTransaccion")) {
			sNombreIndice="Tipo=  Por Comprobante";
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

	public static String getDetalleIndiceFK_IdCuentaContableCreditoFiscalServicios(Long id_cuenta_contable_credito_fiscal_servicios) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_credito_fiscal_servicios!=null) {sDetalleIndice+=" Codigo Unico De Idcuenta Contable Credito Fiscal Servicios="+id_cuenta_contable_credito_fiscal_servicios.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEjercicio(Long id_ejercicio) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpleado(Long id_empleado) {
		String sDetalleIndice=" Parametros->";
		if(id_empleado!=null) {sDetalleIndice+=" Codigo Unico De Empl. Autoriza="+id_empleado.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpleadoSolicita(Long id_empleado_solicita) {
		String sDetalleIndice=" Parametros->";
		if(id_empleado_solicita!=null) {sDetalleIndice+=" Codigo Unico De Empl. Solicita="+id_empleado_solicita.toString();} 

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
		if(id_tipo_retencion_fuente1!=null) {sDetalleIndice+=" Codigo Unico De Tipo Retencion Fuente1="+id_tipo_retencion_fuente1.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoRetencionIva1(Long id_tipo_retencion_iva1) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_retencion_iva1!=null) {sDetalleIndice+=" Codigo Unico De Tipo Retencion Iva1="+id_tipo_retencion_iva1.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoTransaccionModulo(Long id_tipo_transaccion_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_transaccion_modulo!=null) {sDetalleIndice+=" Codigo Unico De Tipo Comprobante="+id_tipo_transaccion_modulo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoTributario(Long id_tipo_tributario) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_tributario!=null) {sDetalleIndice+=" Codigo Unico De T. Tributario="+id_tipo_tributario.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransaccion(Long id_transaccion) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion!=null) {sDetalleIndice+=" Codigo Unico De Comprobante="+id_transaccion.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosFacturaProveedorServicio(FacturaProveedorServicio facturaproveedorservicio,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		facturaproveedorservicio.setnumero_factura(facturaproveedorservicio.getnumero_factura().trim());
		facturaproveedorservicio.setruc(facturaproveedorservicio.getruc().trim());
		facturaproveedorservicio.setdetalle(facturaproveedorservicio.getdetalle().trim());
		facturaproveedorservicio.setnumero_retencion(facturaproveedorservicio.getnumero_retencion().trim());
		facturaproveedorservicio.setnumero_autorizacion(facturaproveedorservicio.getnumero_autorizacion().trim());
		facturaproveedorservicio.setnumero_serie(facturaproveedorservicio.getnumero_serie().trim());
		facturaproveedorservicio.setanexo_factura_inicio(facturaproveedorservicio.getanexo_factura_inicio().trim());
		facturaproveedorservicio.setanexo_factura_fin(facturaproveedorservicio.getanexo_factura_fin().trim());
		facturaproveedorservicio.setnumero_mayor(facturaproveedorservicio.getnumero_mayor().trim());
		facturaproveedorservicio.setcodigo_asiento(facturaproveedorservicio.getcodigo_asiento().trim());
		facturaproveedorservicio.setanexo_numero_autorizacion(facturaproveedorservicio.getanexo_numero_autorizacion().trim());
		facturaproveedorservicio.setanexo_numeso_serie(facturaproveedorservicio.getanexo_numeso_serie().trim());
		facturaproveedorservicio.setdescripcion(facturaproveedorservicio.getdescripcion().trim());
	}
	
	public static void quitarEspaciosFacturaProveedorServicios(List<FacturaProveedorServicio> facturaproveedorservicios,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(FacturaProveedorServicio facturaproveedorservicio: facturaproveedorservicios) {
			facturaproveedorservicio.setnumero_factura(facturaproveedorservicio.getnumero_factura().trim());
			facturaproveedorservicio.setruc(facturaproveedorservicio.getruc().trim());
			facturaproveedorservicio.setdetalle(facturaproveedorservicio.getdetalle().trim());
			facturaproveedorservicio.setnumero_retencion(facturaproveedorservicio.getnumero_retencion().trim());
			facturaproveedorservicio.setnumero_autorizacion(facturaproveedorservicio.getnumero_autorizacion().trim());
			facturaproveedorservicio.setnumero_serie(facturaproveedorservicio.getnumero_serie().trim());
			facturaproveedorservicio.setanexo_factura_inicio(facturaproveedorservicio.getanexo_factura_inicio().trim());
			facturaproveedorservicio.setanexo_factura_fin(facturaproveedorservicio.getanexo_factura_fin().trim());
			facturaproveedorservicio.setnumero_mayor(facturaproveedorservicio.getnumero_mayor().trim());
			facturaproveedorservicio.setcodigo_asiento(facturaproveedorservicio.getcodigo_asiento().trim());
			facturaproveedorservicio.setanexo_numero_autorizacion(facturaproveedorservicio.getanexo_numero_autorizacion().trim());
			facturaproveedorservicio.setanexo_numeso_serie(facturaproveedorservicio.getanexo_numeso_serie().trim());
			facturaproveedorservicio.setdescripcion(facturaproveedorservicio.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresFacturaProveedorServicio(FacturaProveedorServicio facturaproveedorservicio,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && facturaproveedorservicio.getConCambioAuxiliar()) {
			facturaproveedorservicio.setIsDeleted(facturaproveedorservicio.getIsDeletedAuxiliar());	
			facturaproveedorservicio.setIsNew(facturaproveedorservicio.getIsNewAuxiliar());	
			facturaproveedorservicio.setIsChanged(facturaproveedorservicio.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			facturaproveedorservicio.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			facturaproveedorservicio.setIsDeletedAuxiliar(false);	
			facturaproveedorservicio.setIsNewAuxiliar(false);	
			facturaproveedorservicio.setIsChangedAuxiliar(false);
			
			facturaproveedorservicio.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresFacturaProveedorServicios(List<FacturaProveedorServicio> facturaproveedorservicios,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(FacturaProveedorServicio facturaproveedorservicio : facturaproveedorservicios) {
			if(conAsignarBase && facturaproveedorservicio.getConCambioAuxiliar()) {
				facturaproveedorservicio.setIsDeleted(facturaproveedorservicio.getIsDeletedAuxiliar());	
				facturaproveedorservicio.setIsNew(facturaproveedorservicio.getIsNewAuxiliar());	
				facturaproveedorservicio.setIsChanged(facturaproveedorservicio.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				facturaproveedorservicio.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				facturaproveedorservicio.setIsDeletedAuxiliar(false);	
				facturaproveedorservicio.setIsNewAuxiliar(false);	
				facturaproveedorservicio.setIsChangedAuxiliar(false);
				
				facturaproveedorservicio.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresFacturaProveedorServicio(FacturaProveedorServicio facturaproveedorservicio,Boolean conEnteros) throws Exception  {
		facturaproveedorservicio.setvalor_servicios0(0.0);
		facturaproveedorservicio.settotal_iva(0.0);
		facturaproveedorservicio.setiva_porcentaje(0.0);
		facturaproveedorservicio.settotal(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			facturaproveedorservicio.setplazo(0);
		}
	}		
	
	public static void InicializarValoresFacturaProveedorServicios(List<FacturaProveedorServicio> facturaproveedorservicios,Boolean conEnteros) throws Exception  {
		
		for(FacturaProveedorServicio facturaproveedorservicio: facturaproveedorservicios) {
			facturaproveedorservicio.setvalor_servicios0(0.0);
			facturaproveedorservicio.settotal_iva(0.0);
			facturaproveedorservicio.setiva_porcentaje(0.0);
			facturaproveedorservicio.settotal(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				facturaproveedorservicio.setplazo(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaFacturaProveedorServicio(List<FacturaProveedorServicio> facturaproveedorservicios,FacturaProveedorServicio facturaproveedorservicioAux) throws Exception  {
		FacturaProveedorServicioConstantesFunciones.InicializarValoresFacturaProveedorServicio(facturaproveedorservicioAux,true);
		
		for(FacturaProveedorServicio facturaproveedorservicio: facturaproveedorservicios) {
			if(facturaproveedorservicio.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			facturaproveedorservicioAux.setplazo(facturaproveedorservicioAux.getplazo()+facturaproveedorservicio.getplazo());			
			facturaproveedorservicioAux.setvalor_servicios0(facturaproveedorservicioAux.getvalor_servicios0()+facturaproveedorservicio.getvalor_servicios0());			
			facturaproveedorservicioAux.settotal_iva(facturaproveedorservicioAux.gettotal_iva()+facturaproveedorservicio.gettotal_iva());			
			facturaproveedorservicioAux.setiva_porcentaje(facturaproveedorservicioAux.getiva_porcentaje()+facturaproveedorservicio.getiva_porcentaje());			
			facturaproveedorservicioAux.settotal(facturaproveedorservicioAux.gettotal()+facturaproveedorservicio.gettotal());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesFacturaProveedorServicio(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=FacturaProveedorServicioConstantesFunciones.getArrayColumnasGlobalesFacturaProveedorServicio(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesFacturaProveedorServicio(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FacturaProveedorServicioConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FacturaProveedorServicioConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FacturaProveedorServicioConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FacturaProveedorServicioConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FacturaProveedorServicioConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FacturaProveedorServicioConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FacturaProveedorServicioConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FacturaProveedorServicioConstantesFunciones.IDPERIODO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FacturaProveedorServicioConstantesFunciones.IDMODULO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FacturaProveedorServicioConstantesFunciones.IDMODULO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FacturaProveedorServicioConstantesFunciones.IDMONEDA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FacturaProveedorServicioConstantesFunciones.IDMONEDA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoFacturaProveedorServicio(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<FacturaProveedorServicio> facturaproveedorservicios,FacturaProveedorServicio facturaproveedorservicio,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(FacturaProveedorServicio facturaproveedorservicioAux: facturaproveedorservicios) {
			if(facturaproveedorservicioAux!=null && facturaproveedorservicio!=null) {
				if((facturaproveedorservicioAux.getId()==null && facturaproveedorservicio.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(facturaproveedorservicioAux.getId()!=null && facturaproveedorservicio.getId()!=null){
					if(facturaproveedorservicioAux.getId().equals(facturaproveedorservicio.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaFacturaProveedorServicio(List<FacturaProveedorServicio> facturaproveedorservicios) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valor_servicios0Total=0.0;
		Double total_ivaTotal=0.0;
		Double iva_porcentajeTotal=0.0;
		Double totalTotal=0.0;
	
		for(FacturaProveedorServicio facturaproveedorservicio: facturaproveedorservicios) {			
			if(facturaproveedorservicio.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valor_servicios0Total+=facturaproveedorservicio.getvalor_servicios0();
			total_ivaTotal+=facturaproveedorservicio.gettotal_iva();
			iva_porcentajeTotal+=facturaproveedorservicio.getiva_porcentaje();
			totalTotal+=facturaproveedorservicio.gettotal();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaProveedorServicioConstantesFunciones.VALORSERVICIOS0);
		datoGeneral.setsDescripcion(FacturaProveedorServicioConstantesFunciones.LABEL_VALORSERVICIOS0);
		datoGeneral.setdValorDouble(valor_servicios0Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaProveedorServicioConstantesFunciones.TOTALIVA);
		datoGeneral.setsDescripcion(FacturaProveedorServicioConstantesFunciones.LABEL_TOTALIVA);
		datoGeneral.setdValorDouble(total_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaProveedorServicioConstantesFunciones.IVAPORCENTAJE);
		datoGeneral.setsDescripcion(FacturaProveedorServicioConstantesFunciones.LABEL_IVAPORCENTAJE);
		datoGeneral.setdValorDouble(iva_porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaProveedorServicioConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(FacturaProveedorServicioConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaFacturaProveedorServicio() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,FacturaProveedorServicioConstantesFunciones.LABEL_ID, FacturaProveedorServicioConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorServicioConstantesFunciones.LABEL_VERSIONROW, FacturaProveedorServicioConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorServicioConstantesFunciones.LABEL_IDEMPRESA, FacturaProveedorServicioConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorServicioConstantesFunciones.LABEL_IDSUCURSAL, FacturaProveedorServicioConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorServicioConstantesFunciones.LABEL_IDEJERCICIO, FacturaProveedorServicioConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorServicioConstantesFunciones.LABEL_IDPERIODO, FacturaProveedorServicioConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorServicioConstantesFunciones.LABEL_IDANIO, FacturaProveedorServicioConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorServicioConstantesFunciones.LABEL_IDMES, FacturaProveedorServicioConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorServicioConstantesFunciones.LABEL_IDMODULO, FacturaProveedorServicioConstantesFunciones.IDMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorServicioConstantesFunciones.LABEL_IDTRANSACCION, FacturaProveedorServicioConstantesFunciones.IDTRANSACCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorServicioConstantesFunciones.LABEL_IDFACTURA, FacturaProveedorServicioConstantesFunciones.IDFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorServicioConstantesFunciones.LABEL_NUMEROFACTURA, FacturaProveedorServicioConstantesFunciones.NUMEROFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorServicioConstantesFunciones.LABEL_IDCLIENTE, FacturaProveedorServicioConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorServicioConstantesFunciones.LABEL_RUC, FacturaProveedorServicioConstantesFunciones.RUC,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorServicioConstantesFunciones.LABEL_IDTIPODOCUMENTO, FacturaProveedorServicioConstantesFunciones.IDTIPODOCUMENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorServicioConstantesFunciones.LABEL_PLAZO, FacturaProveedorServicioConstantesFunciones.PLAZO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorServicioConstantesFunciones.LABEL_CONRISE, FacturaProveedorServicioConstantesFunciones.CONRISE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorServicioConstantesFunciones.LABEL_FECHAEMISION, FacturaProveedorServicioConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorServicioConstantesFunciones.LABEL_FECHAVENCE, FacturaProveedorServicioConstantesFunciones.FECHAVENCE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorServicioConstantesFunciones.LABEL_IDEMPLEADOSOLICITA, FacturaProveedorServicioConstantesFunciones.IDEMPLEADOSOLICITA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorServicioConstantesFunciones.LABEL_IDEMPLEADO, FacturaProveedorServicioConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorServicioConstantesFunciones.LABEL_DETALLE, FacturaProveedorServicioConstantesFunciones.DETALLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorServicioConstantesFunciones.LABEL_NUMERORETENCION, FacturaProveedorServicioConstantesFunciones.NUMERORETENCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorServicioConstantesFunciones.LABEL_NUMEROAUTORIZACION, FacturaProveedorServicioConstantesFunciones.NUMEROAUTORIZACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorServicioConstantesFunciones.LABEL_NUMEROSERIE, FacturaProveedorServicioConstantesFunciones.NUMEROSERIE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorServicioConstantesFunciones.LABEL_IDTIPOTRIBUTARIO, FacturaProveedorServicioConstantesFunciones.IDTIPOTRIBUTARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorServicioConstantesFunciones.LABEL_FECHAVALIDEZ, FacturaProveedorServicioConstantesFunciones.FECHAVALIDEZ,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorServicioConstantesFunciones.LABEL_ANEXOFACTURAINICIO, FacturaProveedorServicioConstantesFunciones.ANEXOFACTURAINICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorServicioConstantesFunciones.LABEL_ANEXOFACTURAFIN, FacturaProveedorServicioConstantesFunciones.ANEXOFACTURAFIN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorServicioConstantesFunciones.LABEL_IDMONEDA, FacturaProveedorServicioConstantesFunciones.IDMONEDA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorServicioConstantesFunciones.LABEL_VALORSERVICIOS0, FacturaProveedorServicioConstantesFunciones.VALORSERVICIOS0,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorServicioConstantesFunciones.LABEL_TOTALIVA, FacturaProveedorServicioConstantesFunciones.TOTALIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorServicioConstantesFunciones.LABEL_IVAPORCENTAJE, FacturaProveedorServicioConstantesFunciones.IVAPORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorServicioConstantesFunciones.LABEL_TOTAL, FacturaProveedorServicioConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorServicioConstantesFunciones.LABEL_NUMEROMAYOR, FacturaProveedorServicioConstantesFunciones.NUMEROMAYOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorServicioConstantesFunciones.LABEL_CODIGOASIENTO, FacturaProveedorServicioConstantesFunciones.CODIGOASIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorServicioConstantesFunciones.LABEL_IDTIPORETENCIONFUENTE1, FacturaProveedorServicioConstantesFunciones.IDTIPORETENCIONFUENTE1,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorServicioConstantesFunciones.LABEL_IDTIPORETENCIONIVA1, FacturaProveedorServicioConstantesFunciones.IDTIPORETENCIONIVA1,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorServicioConstantesFunciones.LABEL_ANEXONUMEROAUTORIZACION, FacturaProveedorServicioConstantesFunciones.ANEXONUMEROAUTORIZACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorServicioConstantesFunciones.LABEL_ANEXONUMESOSERIE, FacturaProveedorServicioConstantesFunciones.ANEXONUMESOSERIE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorServicioConstantesFunciones.LABEL_ANEXOFECHAVALIDEZ, FacturaProveedorServicioConstantesFunciones.ANEXOFECHAVALIDEZ,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorServicioConstantesFunciones.LABEL_IDCUENTACONTABLECREDITOFISCALSERVICIOS, FacturaProveedorServicioConstantesFunciones.IDCUENTACONTABLECREDITOFISCALSERVICIOS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorServicioConstantesFunciones.LABEL_DESCRIPCION, FacturaProveedorServicioConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorServicioConstantesFunciones.LABEL_IDTIPOMOVIMIENTO, FacturaProveedorServicioConstantesFunciones.IDTIPOMOVIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorServicioConstantesFunciones.LABEL_IDTIPOMOVIMIENTOMODULO, FacturaProveedorServicioConstantesFunciones.IDTIPOMOVIMIENTOMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaProveedorServicioConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO, FacturaProveedorServicioConstantesFunciones.IDTIPOTRANSACCIONMODULO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasFacturaProveedorServicio() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorServicioConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorServicioConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorServicioConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorServicioConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorServicioConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorServicioConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorServicioConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorServicioConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorServicioConstantesFunciones.IDMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorServicioConstantesFunciones.IDTRANSACCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorServicioConstantesFunciones.IDFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorServicioConstantesFunciones.NUMEROFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorServicioConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorServicioConstantesFunciones.RUC;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorServicioConstantesFunciones.IDTIPODOCUMENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorServicioConstantesFunciones.PLAZO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorServicioConstantesFunciones.CONRISE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorServicioConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorServicioConstantesFunciones.FECHAVENCE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorServicioConstantesFunciones.IDEMPLEADOSOLICITA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorServicioConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorServicioConstantesFunciones.DETALLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorServicioConstantesFunciones.NUMERORETENCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorServicioConstantesFunciones.NUMEROAUTORIZACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorServicioConstantesFunciones.NUMEROSERIE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorServicioConstantesFunciones.IDTIPOTRIBUTARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorServicioConstantesFunciones.FECHAVALIDEZ;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorServicioConstantesFunciones.ANEXOFACTURAINICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorServicioConstantesFunciones.ANEXOFACTURAFIN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorServicioConstantesFunciones.IDMONEDA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorServicioConstantesFunciones.VALORSERVICIOS0;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorServicioConstantesFunciones.TOTALIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorServicioConstantesFunciones.IVAPORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorServicioConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorServicioConstantesFunciones.NUMEROMAYOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorServicioConstantesFunciones.CODIGOASIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorServicioConstantesFunciones.IDTIPORETENCIONFUENTE1;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorServicioConstantesFunciones.IDTIPORETENCIONIVA1;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorServicioConstantesFunciones.ANEXONUMEROAUTORIZACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorServicioConstantesFunciones.ANEXONUMESOSERIE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorServicioConstantesFunciones.ANEXOFECHAVALIDEZ;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorServicioConstantesFunciones.IDCUENTACONTABLECREDITOFISCALSERVICIOS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorServicioConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorServicioConstantesFunciones.IDTIPOMOVIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorServicioConstantesFunciones.IDTIPOMOVIMIENTOMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaProveedorServicioConstantesFunciones.IDTIPOTRANSACCIONMODULO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFacturaProveedorServicio() throws Exception  {
		return FacturaProveedorServicioConstantesFunciones.getTiposSeleccionarFacturaProveedorServicio(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFacturaProveedorServicio(Boolean conFk) throws Exception  {
		return FacturaProveedorServicioConstantesFunciones.getTiposSeleccionarFacturaProveedorServicio(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFacturaProveedorServicio(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorServicioConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(FacturaProveedorServicioConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorServicioConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(FacturaProveedorServicioConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorServicioConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(FacturaProveedorServicioConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorServicioConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(FacturaProveedorServicioConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorServicioConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(FacturaProveedorServicioConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorServicioConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(FacturaProveedorServicioConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorServicioConstantesFunciones.LABEL_IDMODULO);
			reporte.setsDescripcion(FacturaProveedorServicioConstantesFunciones.LABEL_IDMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorServicioConstantesFunciones.LABEL_IDTRANSACCION);
			reporte.setsDescripcion(FacturaProveedorServicioConstantesFunciones.LABEL_IDTRANSACCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorServicioConstantesFunciones.LABEL_IDFACTURA);
			reporte.setsDescripcion(FacturaProveedorServicioConstantesFunciones.LABEL_IDFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorServicioConstantesFunciones.LABEL_NUMEROFACTURA);
			reporte.setsDescripcion(FacturaProveedorServicioConstantesFunciones.LABEL_NUMEROFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorServicioConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(FacturaProveedorServicioConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorServicioConstantesFunciones.LABEL_RUC);
			reporte.setsDescripcion(FacturaProveedorServicioConstantesFunciones.LABEL_RUC);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorServicioConstantesFunciones.LABEL_IDTIPODOCUMENTO);
			reporte.setsDescripcion(FacturaProveedorServicioConstantesFunciones.LABEL_IDTIPODOCUMENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorServicioConstantesFunciones.LABEL_PLAZO);
			reporte.setsDescripcion(FacturaProveedorServicioConstantesFunciones.LABEL_PLAZO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorServicioConstantesFunciones.LABEL_CONRISE);
			reporte.setsDescripcion(FacturaProveedorServicioConstantesFunciones.LABEL_CONRISE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorServicioConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(FacturaProveedorServicioConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorServicioConstantesFunciones.LABEL_FECHAVENCE);
			reporte.setsDescripcion(FacturaProveedorServicioConstantesFunciones.LABEL_FECHAVENCE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorServicioConstantesFunciones.LABEL_IDEMPLEADOSOLICITA);
			reporte.setsDescripcion(FacturaProveedorServicioConstantesFunciones.LABEL_IDEMPLEADOSOLICITA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorServicioConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(FacturaProveedorServicioConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorServicioConstantesFunciones.LABEL_DETALLE);
			reporte.setsDescripcion(FacturaProveedorServicioConstantesFunciones.LABEL_DETALLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorServicioConstantesFunciones.LABEL_NUMERORETENCION);
			reporte.setsDescripcion(FacturaProveedorServicioConstantesFunciones.LABEL_NUMERORETENCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorServicioConstantesFunciones.LABEL_NUMEROAUTORIZACION);
			reporte.setsDescripcion(FacturaProveedorServicioConstantesFunciones.LABEL_NUMEROAUTORIZACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorServicioConstantesFunciones.LABEL_NUMEROSERIE);
			reporte.setsDescripcion(FacturaProveedorServicioConstantesFunciones.LABEL_NUMEROSERIE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorServicioConstantesFunciones.LABEL_IDTIPOTRIBUTARIO);
			reporte.setsDescripcion(FacturaProveedorServicioConstantesFunciones.LABEL_IDTIPOTRIBUTARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorServicioConstantesFunciones.LABEL_FECHAVALIDEZ);
			reporte.setsDescripcion(FacturaProveedorServicioConstantesFunciones.LABEL_FECHAVALIDEZ);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorServicioConstantesFunciones.LABEL_ANEXOFACTURAINICIO);
			reporte.setsDescripcion(FacturaProveedorServicioConstantesFunciones.LABEL_ANEXOFACTURAINICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorServicioConstantesFunciones.LABEL_ANEXOFACTURAFIN);
			reporte.setsDescripcion(FacturaProveedorServicioConstantesFunciones.LABEL_ANEXOFACTURAFIN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorServicioConstantesFunciones.LABEL_IDMONEDA);
			reporte.setsDescripcion(FacturaProveedorServicioConstantesFunciones.LABEL_IDMONEDA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorServicioConstantesFunciones.LABEL_VALORSERVICIOS0);
			reporte.setsDescripcion(FacturaProveedorServicioConstantesFunciones.LABEL_VALORSERVICIOS0);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorServicioConstantesFunciones.LABEL_TOTALIVA);
			reporte.setsDescripcion(FacturaProveedorServicioConstantesFunciones.LABEL_TOTALIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorServicioConstantesFunciones.LABEL_IVAPORCENTAJE);
			reporte.setsDescripcion(FacturaProveedorServicioConstantesFunciones.LABEL_IVAPORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorServicioConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(FacturaProveedorServicioConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorServicioConstantesFunciones.LABEL_NUMEROMAYOR);
			reporte.setsDescripcion(FacturaProveedorServicioConstantesFunciones.LABEL_NUMEROMAYOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorServicioConstantesFunciones.LABEL_CODIGOASIENTO);
			reporte.setsDescripcion(FacturaProveedorServicioConstantesFunciones.LABEL_CODIGOASIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorServicioConstantesFunciones.LABEL_IDTIPORETENCIONFUENTE1);
			reporte.setsDescripcion(FacturaProveedorServicioConstantesFunciones.LABEL_IDTIPORETENCIONFUENTE1);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorServicioConstantesFunciones.LABEL_IDTIPORETENCIONIVA1);
			reporte.setsDescripcion(FacturaProveedorServicioConstantesFunciones.LABEL_IDTIPORETENCIONIVA1);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorServicioConstantesFunciones.LABEL_ANEXONUMEROAUTORIZACION);
			reporte.setsDescripcion(FacturaProveedorServicioConstantesFunciones.LABEL_ANEXONUMEROAUTORIZACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorServicioConstantesFunciones.LABEL_ANEXONUMESOSERIE);
			reporte.setsDescripcion(FacturaProveedorServicioConstantesFunciones.LABEL_ANEXONUMESOSERIE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorServicioConstantesFunciones.LABEL_ANEXOFECHAVALIDEZ);
			reporte.setsDescripcion(FacturaProveedorServicioConstantesFunciones.LABEL_ANEXOFECHAVALIDEZ);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorServicioConstantesFunciones.LABEL_IDCUENTACONTABLECREDITOFISCALSERVICIOS);
			reporte.setsDescripcion(FacturaProveedorServicioConstantesFunciones.LABEL_IDCUENTACONTABLECREDITOFISCALSERVICIOS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorServicioConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(FacturaProveedorServicioConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorServicioConstantesFunciones.LABEL_IDTIPOMOVIMIENTO);
			reporte.setsDescripcion(FacturaProveedorServicioConstantesFunciones.LABEL_IDTIPOMOVIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorServicioConstantesFunciones.LABEL_IDTIPOMOVIMIENTOMODULO);
			reporte.setsDescripcion(FacturaProveedorServicioConstantesFunciones.LABEL_IDTIPOMOVIMIENTOMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaProveedorServicioConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO);
			reporte.setsDescripcion(FacturaProveedorServicioConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesFacturaProveedorServicio(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesFacturaProveedorServicio(FacturaProveedorServicio facturaproveedorservicioAux) throws Exception {
		
			facturaproveedorservicioAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(facturaproveedorservicioAux.getEmpresa()));
			facturaproveedorservicioAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(facturaproveedorservicioAux.getSucursal()));
			facturaproveedorservicioAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(facturaproveedorservicioAux.getEjercicio()));
			facturaproveedorservicioAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(facturaproveedorservicioAux.getPeriodo()));
			facturaproveedorservicioAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(facturaproveedorservicioAux.getAnio()));
			facturaproveedorservicioAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(facturaproveedorservicioAux.getMes()));
			facturaproveedorservicioAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(facturaproveedorservicioAux.getModulo()));
			facturaproveedorservicioAux.settransaccion_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(facturaproveedorservicioAux.getTransaccion()));
			facturaproveedorservicioAux.setfactura_descripcion(FacturaConstantesFunciones.getFacturaDescripcion(facturaproveedorservicioAux.getFactura()));
			facturaproveedorservicioAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(facturaproveedorservicioAux.getCliente()));
			facturaproveedorservicioAux.settipodocumento_descripcion(TipoDocumentoConstantesFunciones.getTipoDocumentoDescripcion(facturaproveedorservicioAux.getTipoDocumento()));
			facturaproveedorservicioAux.setempleadosolicita_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(facturaproveedorservicioAux.getEmpleadoSolicita()));
			facturaproveedorservicioAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(facturaproveedorservicioAux.getEmpleado()));
			facturaproveedorservicioAux.settipotributario_descripcion(TipoTributarioConstantesFunciones.getTipoTributarioDescripcion(facturaproveedorservicioAux.getTipoTributario()));
			facturaproveedorservicioAux.setmoneda_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(facturaproveedorservicioAux.getMoneda()));
			facturaproveedorservicioAux.settiporetencionfuente1_descripcion(TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(facturaproveedorservicioAux.getTipoRetencionFuente1()));
			facturaproveedorservicioAux.settiporetencioniva1_descripcion(TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(facturaproveedorservicioAux.getTipoRetencionIva1()));
			facturaproveedorservicioAux.setcuentacontablecreditofiscalservicios_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(facturaproveedorservicioAux.getCuentaContableCreditoFiscalServicios()));
			facturaproveedorservicioAux.settipomovimiento_descripcion(TipoMovimientoConstantesFunciones.getTipoMovimientoDescripcion(facturaproveedorservicioAux.getTipoMovimiento()));
			facturaproveedorservicioAux.settipomovimientomodulo_descripcion(TipoMovimientoModuloConstantesFunciones.getTipoMovimientoModuloDescripcion(facturaproveedorservicioAux.getTipoMovimientoModulo()));
			facturaproveedorservicioAux.settipotransaccionmodulo_descripcion(TipoTransaccionModuloConstantesFunciones.getTipoTransaccionModuloDescripcion(facturaproveedorservicioAux.getTipoTransaccionModulo()));		
	}
	
	public static void refrescarForeignKeysDescripcionesFacturaProveedorServicio(List<FacturaProveedorServicio> facturaproveedorserviciosTemp) throws Exception {
		for(FacturaProveedorServicio facturaproveedorservicioAux:facturaproveedorserviciosTemp) {
			
			facturaproveedorservicioAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(facturaproveedorservicioAux.getEmpresa()));
			facturaproveedorservicioAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(facturaproveedorservicioAux.getSucursal()));
			facturaproveedorservicioAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(facturaproveedorservicioAux.getEjercicio()));
			facturaproveedorservicioAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(facturaproveedorservicioAux.getPeriodo()));
			facturaproveedorservicioAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(facturaproveedorservicioAux.getAnio()));
			facturaproveedorservicioAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(facturaproveedorservicioAux.getMes()));
			facturaproveedorservicioAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(facturaproveedorservicioAux.getModulo()));
			facturaproveedorservicioAux.settransaccion_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(facturaproveedorservicioAux.getTransaccion()));
			facturaproveedorservicioAux.setfactura_descripcion(FacturaConstantesFunciones.getFacturaDescripcion(facturaproveedorservicioAux.getFactura()));
			facturaproveedorservicioAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(facturaproveedorservicioAux.getCliente()));
			facturaproveedorservicioAux.settipodocumento_descripcion(TipoDocumentoConstantesFunciones.getTipoDocumentoDescripcion(facturaproveedorservicioAux.getTipoDocumento()));
			facturaproveedorservicioAux.setempleadosolicita_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(facturaproveedorservicioAux.getEmpleadoSolicita()));
			facturaproveedorservicioAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(facturaproveedorservicioAux.getEmpleado()));
			facturaproveedorservicioAux.settipotributario_descripcion(TipoTributarioConstantesFunciones.getTipoTributarioDescripcion(facturaproveedorservicioAux.getTipoTributario()));
			facturaproveedorservicioAux.setmoneda_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(facturaproveedorservicioAux.getMoneda()));
			facturaproveedorservicioAux.settiporetencionfuente1_descripcion(TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(facturaproveedorservicioAux.getTipoRetencionFuente1()));
			facturaproveedorservicioAux.settiporetencioniva1_descripcion(TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(facturaproveedorservicioAux.getTipoRetencionIva1()));
			facturaproveedorservicioAux.setcuentacontablecreditofiscalservicios_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(facturaproveedorservicioAux.getCuentaContableCreditoFiscalServicios()));
			facturaproveedorservicioAux.settipomovimiento_descripcion(TipoMovimientoConstantesFunciones.getTipoMovimientoDescripcion(facturaproveedorservicioAux.getTipoMovimiento()));
			facturaproveedorservicioAux.settipomovimientomodulo_descripcion(TipoMovimientoModuloConstantesFunciones.getTipoMovimientoModuloDescripcion(facturaproveedorservicioAux.getTipoMovimientoModulo()));
			facturaproveedorservicioAux.settipotransaccionmodulo_descripcion(TipoTransaccionModuloConstantesFunciones.getTipoTransaccionModuloDescripcion(facturaproveedorservicioAux.getTipoTransaccionModulo()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfFacturaProveedorServicio(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
				classes.add(new Classe(Transaccion.class));
				classes.add(new Classe(Factura.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(TipoDocumento.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(TipoTributario.class));
				classes.add(new Classe(Moneda.class));
				classes.add(new Classe(TipoRetencion.class));
				classes.add(new Classe(TipoRetencion.class));
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
					if(clas.clas.equals(Transaccion.class)) {
						classes.add(new Classe(Transaccion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Factura.class)) {
						classes.add(new Classe(Factura.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoDocumento.class)) {
						classes.add(new Classe(TipoDocumento.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoTributario.class)) {
						classes.add(new Classe(TipoTributario.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Moneda.class)) {
						classes.add(new Classe(Moneda.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfFacturaProveedorServicio(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Factura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Factura.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(TipoDocumento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDocumento.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(TipoTributario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoTributario.class)); continue;
					}

					if(Moneda.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Moneda.class)); continue;
					}

					if(TipoRetencion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRetencion.class)); continue;
					}

					if(TipoRetencion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRetencion.class)); continue;
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

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Factura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Factura.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(TipoDocumento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDocumento.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(TipoTributario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoTributario.class)); continue;
					}

					if(Moneda.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Moneda.class)); continue;
					}

					if(TipoRetencion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRetencion.class)); continue;
					}

					if(TipoRetencion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRetencion.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfFacturaProveedorServicio(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return FacturaProveedorServicioConstantesFunciones.getClassesRelationshipsOfFacturaProveedorServicio(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfFacturaProveedorServicio(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfFacturaProveedorServicio(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return FacturaProveedorServicioConstantesFunciones.getClassesRelationshipsFromStringsOfFacturaProveedorServicio(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfFacturaProveedorServicio(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {
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
	public static void actualizarLista(FacturaProveedorServicio facturaproveedorservicio,List<FacturaProveedorServicio> facturaproveedorservicios,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			FacturaProveedorServicio facturaproveedorservicioEncontrado=null;
			
			for(FacturaProveedorServicio facturaproveedorservicioLocal:facturaproveedorservicios) {
				if(facturaproveedorservicioLocal.getId().equals(facturaproveedorservicio.getId())) {
					facturaproveedorservicioEncontrado=facturaproveedorservicioLocal;
					
					facturaproveedorservicioLocal.setIsChanged(facturaproveedorservicio.getIsChanged());
					facturaproveedorservicioLocal.setIsNew(facturaproveedorservicio.getIsNew());
					facturaproveedorservicioLocal.setIsDeleted(facturaproveedorservicio.getIsDeleted());
					
					facturaproveedorservicioLocal.setGeneralEntityOriginal(facturaproveedorservicio.getGeneralEntityOriginal());
					
					facturaproveedorservicioLocal.setId(facturaproveedorservicio.getId());	
					facturaproveedorservicioLocal.setVersionRow(facturaproveedorservicio.getVersionRow());	
					facturaproveedorservicioLocal.setid_empresa(facturaproveedorservicio.getid_empresa());	
					facturaproveedorservicioLocal.setid_sucursal(facturaproveedorservicio.getid_sucursal());	
					facturaproveedorservicioLocal.setid_ejercicio(facturaproveedorservicio.getid_ejercicio());	
					facturaproveedorservicioLocal.setid_periodo(facturaproveedorservicio.getid_periodo());	
					facturaproveedorservicioLocal.setid_anio(facturaproveedorservicio.getid_anio());	
					facturaproveedorservicioLocal.setid_mes(facturaproveedorservicio.getid_mes());	
					facturaproveedorservicioLocal.setid_modulo(facturaproveedorservicio.getid_modulo());	
					facturaproveedorservicioLocal.setid_transaccion(facturaproveedorservicio.getid_transaccion());	
					facturaproveedorservicioLocal.setid_factura(facturaproveedorservicio.getid_factura());	
					facturaproveedorservicioLocal.setnumero_factura(facturaproveedorservicio.getnumero_factura());	
					facturaproveedorservicioLocal.setid_cliente(facturaproveedorservicio.getid_cliente());	
					facturaproveedorservicioLocal.setruc(facturaproveedorservicio.getruc());	
					facturaproveedorservicioLocal.setid_tipo_documento(facturaproveedorservicio.getid_tipo_documento());	
					facturaproveedorservicioLocal.setplazo(facturaproveedorservicio.getplazo());	
					facturaproveedorservicioLocal.setcon_rise(facturaproveedorservicio.getcon_rise());	
					facturaproveedorservicioLocal.setfecha_emision(facturaproveedorservicio.getfecha_emision());	
					facturaproveedorservicioLocal.setfecha_vence(facturaproveedorservicio.getfecha_vence());	
					facturaproveedorservicioLocal.setid_empleado_solicita(facturaproveedorservicio.getid_empleado_solicita());	
					facturaproveedorservicioLocal.setid_empleado(facturaproveedorservicio.getid_empleado());	
					facturaproveedorservicioLocal.setdetalle(facturaproveedorservicio.getdetalle());	
					facturaproveedorservicioLocal.setnumero_retencion(facturaproveedorservicio.getnumero_retencion());	
					facturaproveedorservicioLocal.setnumero_autorizacion(facturaproveedorservicio.getnumero_autorizacion());	
					facturaproveedorservicioLocal.setnumero_serie(facturaproveedorservicio.getnumero_serie());	
					facturaproveedorservicioLocal.setid_tipo_tributario(facturaproveedorservicio.getid_tipo_tributario());	
					facturaproveedorservicioLocal.setfecha_validez(facturaproveedorservicio.getfecha_validez());	
					facturaproveedorservicioLocal.setanexo_factura_inicio(facturaproveedorservicio.getanexo_factura_inicio());	
					facturaproveedorservicioLocal.setanexo_factura_fin(facturaproveedorservicio.getanexo_factura_fin());	
					facturaproveedorservicioLocal.setid_moneda(facturaproveedorservicio.getid_moneda());	
					facturaproveedorservicioLocal.setvalor_servicios0(facturaproveedorservicio.getvalor_servicios0());	
					facturaproveedorservicioLocal.settotal_iva(facturaproveedorservicio.gettotal_iva());	
					facturaproveedorservicioLocal.setiva_porcentaje(facturaproveedorservicio.getiva_porcentaje());	
					facturaproveedorservicioLocal.settotal(facturaproveedorservicio.gettotal());	
					facturaproveedorservicioLocal.setnumero_mayor(facturaproveedorservicio.getnumero_mayor());	
					facturaproveedorservicioLocal.setcodigo_asiento(facturaproveedorservicio.getcodigo_asiento());	
					facturaproveedorservicioLocal.setid_tipo_retencion_fuente1(facturaproveedorservicio.getid_tipo_retencion_fuente1());	
					facturaproveedorservicioLocal.setid_tipo_retencion_iva1(facturaproveedorservicio.getid_tipo_retencion_iva1());	
					facturaproveedorservicioLocal.setanexo_numero_autorizacion(facturaproveedorservicio.getanexo_numero_autorizacion());	
					facturaproveedorservicioLocal.setanexo_numeso_serie(facturaproveedorservicio.getanexo_numeso_serie());	
					facturaproveedorservicioLocal.setanexo_fecha_validez(facturaproveedorservicio.getanexo_fecha_validez());	
					facturaproveedorservicioLocal.setid_cuenta_contable_credito_fiscal_servicios(facturaproveedorservicio.getid_cuenta_contable_credito_fiscal_servicios());	
					facturaproveedorservicioLocal.setdescripcion(facturaproveedorservicio.getdescripcion());	
					facturaproveedorservicioLocal.setid_tipo_movimiento(facturaproveedorservicio.getid_tipo_movimiento());	
					facturaproveedorservicioLocal.setid_tipo_movimiento_modulo(facturaproveedorservicio.getid_tipo_movimiento_modulo());	
					facturaproveedorservicioLocal.setid_tipo_transaccion_modulo(facturaproveedorservicio.getid_tipo_transaccion_modulo());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!facturaproveedorservicio.getIsDeleted()) {
				if(!existe) {
					facturaproveedorservicios.add(facturaproveedorservicio);
				}
			} else {
				if(facturaproveedorservicioEncontrado!=null && permiteQuitar)  {
					facturaproveedorservicios.remove(facturaproveedorservicioEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(FacturaProveedorServicio facturaproveedorservicio,List<FacturaProveedorServicio> facturaproveedorservicios) throws Exception {
		try	{			
			for(FacturaProveedorServicio facturaproveedorservicioLocal:facturaproveedorservicios) {
				if(facturaproveedorservicioLocal.getId().equals(facturaproveedorservicio.getId())) {
					facturaproveedorservicioLocal.setIsSelected(facturaproveedorservicio.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesFacturaProveedorServicio(List<FacturaProveedorServicio> facturaproveedorserviciosAux) throws Exception {
		//this.facturaproveedorserviciosAux=facturaproveedorserviciosAux;
		
		for(FacturaProveedorServicio facturaproveedorservicioAux:facturaproveedorserviciosAux) {
			if(facturaproveedorservicioAux.getIsChanged()) {
				facturaproveedorservicioAux.setIsChanged(false);
			}		
			
			if(facturaproveedorservicioAux.getIsNew()) {
				facturaproveedorservicioAux.setIsNew(false);
			}	
			
			if(facturaproveedorservicioAux.getIsDeleted()) {
				facturaproveedorservicioAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesFacturaProveedorServicio(FacturaProveedorServicio facturaproveedorservicioAux) throws Exception {
		//this.facturaproveedorservicioAux=facturaproveedorservicioAux;
		
			if(facturaproveedorservicioAux.getIsChanged()) {
				facturaproveedorservicioAux.setIsChanged(false);
			}		
			
			if(facturaproveedorservicioAux.getIsNew()) {
				facturaproveedorservicioAux.setIsNew(false);
			}	
			
			if(facturaproveedorservicioAux.getIsDeleted()) {
				facturaproveedorservicioAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(FacturaProveedorServicio facturaproveedorservicioAsignar,FacturaProveedorServicio facturaproveedorservicio) throws Exception {
		facturaproveedorservicioAsignar.setId(facturaproveedorservicio.getId());	
		facturaproveedorservicioAsignar.setVersionRow(facturaproveedorservicio.getVersionRow());	
		facturaproveedorservicioAsignar.setid_empresa(facturaproveedorservicio.getid_empresa());
		facturaproveedorservicioAsignar.setempresa_descripcion(facturaproveedorservicio.getempresa_descripcion());	
		facturaproveedorservicioAsignar.setid_sucursal(facturaproveedorservicio.getid_sucursal());
		facturaproveedorservicioAsignar.setsucursal_descripcion(facturaproveedorservicio.getsucursal_descripcion());	
		facturaproveedorservicioAsignar.setid_ejercicio(facturaproveedorservicio.getid_ejercicio());
		facturaproveedorservicioAsignar.setejercicio_descripcion(facturaproveedorservicio.getejercicio_descripcion());	
		facturaproveedorservicioAsignar.setid_periodo(facturaproveedorservicio.getid_periodo());
		facturaproveedorservicioAsignar.setperiodo_descripcion(facturaproveedorservicio.getperiodo_descripcion());	
		facturaproveedorservicioAsignar.setid_anio(facturaproveedorservicio.getid_anio());
		facturaproveedorservicioAsignar.setanio_descripcion(facturaproveedorservicio.getanio_descripcion());	
		facturaproveedorservicioAsignar.setid_mes(facturaproveedorservicio.getid_mes());
		facturaproveedorservicioAsignar.setmes_descripcion(facturaproveedorservicio.getmes_descripcion());	
		facturaproveedorservicioAsignar.setid_modulo(facturaproveedorservicio.getid_modulo());
		facturaproveedorservicioAsignar.setmodulo_descripcion(facturaproveedorservicio.getmodulo_descripcion());	
		facturaproveedorservicioAsignar.setid_transaccion(facturaproveedorservicio.getid_transaccion());
		facturaproveedorservicioAsignar.settransaccion_descripcion(facturaproveedorservicio.gettransaccion_descripcion());	
		facturaproveedorservicioAsignar.setid_factura(facturaproveedorservicio.getid_factura());
		facturaproveedorservicioAsignar.setfactura_descripcion(facturaproveedorservicio.getfactura_descripcion());	
		facturaproveedorservicioAsignar.setnumero_factura(facturaproveedorservicio.getnumero_factura());	
		facturaproveedorservicioAsignar.setid_cliente(facturaproveedorservicio.getid_cliente());
		facturaproveedorservicioAsignar.setcliente_descripcion(facturaproveedorservicio.getcliente_descripcion());	
		facturaproveedorservicioAsignar.setruc(facturaproveedorservicio.getruc());	
		facturaproveedorservicioAsignar.setid_tipo_documento(facturaproveedorservicio.getid_tipo_documento());
		facturaproveedorservicioAsignar.settipodocumento_descripcion(facturaproveedorservicio.gettipodocumento_descripcion());	
		facturaproveedorservicioAsignar.setplazo(facturaproveedorservicio.getplazo());	
		facturaproveedorservicioAsignar.setcon_rise(facturaproveedorservicio.getcon_rise());	
		facturaproveedorservicioAsignar.setfecha_emision(facturaproveedorservicio.getfecha_emision());	
		facturaproveedorservicioAsignar.setfecha_vence(facturaproveedorservicio.getfecha_vence());	
		facturaproveedorservicioAsignar.setid_empleado_solicita(facturaproveedorservicio.getid_empleado_solicita());
		facturaproveedorservicioAsignar.setempleadosolicita_descripcion(facturaproveedorservicio.getempleadosolicita_descripcion());	
		facturaproveedorservicioAsignar.setid_empleado(facturaproveedorservicio.getid_empleado());
		facturaproveedorservicioAsignar.setempleado_descripcion(facturaproveedorservicio.getempleado_descripcion());	
		facturaproveedorservicioAsignar.setdetalle(facturaproveedorservicio.getdetalle());	
		facturaproveedorservicioAsignar.setnumero_retencion(facturaproveedorservicio.getnumero_retencion());	
		facturaproveedorservicioAsignar.setnumero_autorizacion(facturaproveedorservicio.getnumero_autorizacion());	
		facturaproveedorservicioAsignar.setnumero_serie(facturaproveedorservicio.getnumero_serie());	
		facturaproveedorservicioAsignar.setid_tipo_tributario(facturaproveedorservicio.getid_tipo_tributario());
		facturaproveedorservicioAsignar.settipotributario_descripcion(facturaproveedorservicio.gettipotributario_descripcion());	
		facturaproveedorservicioAsignar.setfecha_validez(facturaproveedorservicio.getfecha_validez());	
		facturaproveedorservicioAsignar.setanexo_factura_inicio(facturaproveedorservicio.getanexo_factura_inicio());	
		facturaproveedorservicioAsignar.setanexo_factura_fin(facturaproveedorservicio.getanexo_factura_fin());	
		facturaproveedorservicioAsignar.setid_moneda(facturaproveedorservicio.getid_moneda());
		facturaproveedorservicioAsignar.setmoneda_descripcion(facturaproveedorservicio.getmoneda_descripcion());	
		facturaproveedorservicioAsignar.setvalor_servicios0(facturaproveedorservicio.getvalor_servicios0());	
		facturaproveedorservicioAsignar.settotal_iva(facturaproveedorservicio.gettotal_iva());	
		facturaproveedorservicioAsignar.setiva_porcentaje(facturaproveedorservicio.getiva_porcentaje());	
		facturaproveedorservicioAsignar.settotal(facturaproveedorservicio.gettotal());	
		facturaproveedorservicioAsignar.setnumero_mayor(facturaproveedorservicio.getnumero_mayor());	
		facturaproveedorservicioAsignar.setcodigo_asiento(facturaproveedorservicio.getcodigo_asiento());	
		facturaproveedorservicioAsignar.setid_tipo_retencion_fuente1(facturaproveedorservicio.getid_tipo_retencion_fuente1());
		facturaproveedorservicioAsignar.settiporetencionfuente1_descripcion(facturaproveedorservicio.gettiporetencionfuente1_descripcion());	
		facturaproveedorservicioAsignar.setid_tipo_retencion_iva1(facturaproveedorservicio.getid_tipo_retencion_iva1());
		facturaproveedorservicioAsignar.settiporetencioniva1_descripcion(facturaproveedorservicio.gettiporetencioniva1_descripcion());	
		facturaproveedorservicioAsignar.setanexo_numero_autorizacion(facturaproveedorservicio.getanexo_numero_autorizacion());	
		facturaproveedorservicioAsignar.setanexo_numeso_serie(facturaproveedorservicio.getanexo_numeso_serie());	
		facturaproveedorservicioAsignar.setanexo_fecha_validez(facturaproveedorservicio.getanexo_fecha_validez());	
		facturaproveedorservicioAsignar.setid_cuenta_contable_credito_fiscal_servicios(facturaproveedorservicio.getid_cuenta_contable_credito_fiscal_servicios());
		facturaproveedorservicioAsignar.setcuentacontablecreditofiscalservicios_descripcion(facturaproveedorservicio.getcuentacontablecreditofiscalservicios_descripcion());	
		facturaproveedorservicioAsignar.setdescripcion(facturaproveedorservicio.getdescripcion());	
		facturaproveedorservicioAsignar.setid_tipo_movimiento(facturaproveedorservicio.getid_tipo_movimiento());
		facturaproveedorservicioAsignar.settipomovimiento_descripcion(facturaproveedorservicio.gettipomovimiento_descripcion());	
		facturaproveedorservicioAsignar.setid_tipo_movimiento_modulo(facturaproveedorservicio.getid_tipo_movimiento_modulo());
		facturaproveedorservicioAsignar.settipomovimientomodulo_descripcion(facturaproveedorservicio.gettipomovimientomodulo_descripcion());	
		facturaproveedorservicioAsignar.setid_tipo_transaccion_modulo(facturaproveedorservicio.getid_tipo_transaccion_modulo());
		facturaproveedorservicioAsignar.settipotransaccionmodulo_descripcion(facturaproveedorservicio.gettipotransaccionmodulo_descripcion());	
	}
	
	public static void inicializarFacturaProveedorServicio(FacturaProveedorServicio facturaproveedorservicio) throws Exception {
		try {
				facturaproveedorservicio.setId(0L);	
					
				facturaproveedorservicio.setid_empresa(-1L);	
				facturaproveedorservicio.setid_sucursal(-1L);	
				facturaproveedorservicio.setid_ejercicio(-1L);	
				facturaproveedorservicio.setid_periodo(-1L);	
				facturaproveedorservicio.setid_anio(null);	
				facturaproveedorservicio.setid_mes(null);	
				facturaproveedorservicio.setid_modulo(-1L);	
				facturaproveedorservicio.setid_transaccion(-1L);	
				facturaproveedorservicio.setid_factura(null);	
				facturaproveedorservicio.setnumero_factura("");	
				facturaproveedorservicio.setid_cliente(-1L);	
				facturaproveedorservicio.setruc("");	
				facturaproveedorservicio.setid_tipo_documento(-1L);	
				facturaproveedorservicio.setplazo(0);	
				facturaproveedorservicio.setcon_rise(false);	
				facturaproveedorservicio.setfecha_emision(new Date());	
				facturaproveedorservicio.setfecha_vence(new Date());	
				facturaproveedorservicio.setid_empleado_solicita(-1L);	
				facturaproveedorservicio.setid_empleado(null);	
				facturaproveedorservicio.setdetalle("");	
				facturaproveedorservicio.setnumero_retencion("");	
				facturaproveedorservicio.setnumero_autorizacion("");	
				facturaproveedorservicio.setnumero_serie("");	
				facturaproveedorservicio.setid_tipo_tributario(null);	
				facturaproveedorservicio.setfecha_validez(new Date());	
				facturaproveedorservicio.setanexo_factura_inicio("");	
				facturaproveedorservicio.setanexo_factura_fin("");	
				facturaproveedorservicio.setid_moneda(-1L);	
				facturaproveedorservicio.setvalor_servicios0(0.0);	
				facturaproveedorservicio.settotal_iva(0.0);	
				facturaproveedorservicio.setiva_porcentaje(0.0);	
				facturaproveedorservicio.settotal(0.0);	
				facturaproveedorservicio.setnumero_mayor("");	
				facturaproveedorservicio.setcodigo_asiento("");	
				facturaproveedorservicio.setid_tipo_retencion_fuente1(-1L);	
				facturaproveedorservicio.setid_tipo_retencion_iva1(-1L);	
				facturaproveedorservicio.setanexo_numero_autorizacion("");	
				facturaproveedorservicio.setanexo_numeso_serie("");	
				facturaproveedorservicio.setanexo_fecha_validez(new Date());	
				facturaproveedorservicio.setid_cuenta_contable_credito_fiscal_servicios(-1L);	
				facturaproveedorservicio.setdescripcion("");	
				facturaproveedorservicio.setid_tipo_movimiento(null);	
				facturaproveedorservicio.setid_tipo_movimiento_modulo(null);	
				facturaproveedorservicio.setid_tipo_transaccion_modulo(null);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderFacturaProveedorServicio(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorServicioConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorServicioConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorServicioConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorServicioConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorServicioConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorServicioConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorServicioConstantesFunciones.LABEL_IDMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorServicioConstantesFunciones.LABEL_IDTRANSACCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorServicioConstantesFunciones.LABEL_IDFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorServicioConstantesFunciones.LABEL_NUMEROFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorServicioConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorServicioConstantesFunciones.LABEL_RUC);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorServicioConstantesFunciones.LABEL_IDTIPODOCUMENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorServicioConstantesFunciones.LABEL_PLAZO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorServicioConstantesFunciones.LABEL_CONRISE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorServicioConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorServicioConstantesFunciones.LABEL_FECHAVENCE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorServicioConstantesFunciones.LABEL_IDEMPLEADOSOLICITA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorServicioConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorServicioConstantesFunciones.LABEL_DETALLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorServicioConstantesFunciones.LABEL_NUMERORETENCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorServicioConstantesFunciones.LABEL_NUMEROAUTORIZACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorServicioConstantesFunciones.LABEL_NUMEROSERIE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorServicioConstantesFunciones.LABEL_IDTIPOTRIBUTARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorServicioConstantesFunciones.LABEL_FECHAVALIDEZ);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorServicioConstantesFunciones.LABEL_ANEXOFACTURAINICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorServicioConstantesFunciones.LABEL_ANEXOFACTURAFIN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorServicioConstantesFunciones.LABEL_IDMONEDA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorServicioConstantesFunciones.LABEL_VALORSERVICIOS0);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorServicioConstantesFunciones.LABEL_TOTALIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorServicioConstantesFunciones.LABEL_IVAPORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorServicioConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorServicioConstantesFunciones.LABEL_NUMEROMAYOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorServicioConstantesFunciones.LABEL_CODIGOASIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorServicioConstantesFunciones.LABEL_IDTIPORETENCIONFUENTE1);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorServicioConstantesFunciones.LABEL_IDTIPORETENCIONIVA1);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorServicioConstantesFunciones.LABEL_ANEXONUMEROAUTORIZACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorServicioConstantesFunciones.LABEL_ANEXONUMESOSERIE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorServicioConstantesFunciones.LABEL_ANEXOFECHAVALIDEZ);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorServicioConstantesFunciones.LABEL_IDCUENTACONTABLECREDITOFISCALSERVICIOS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorServicioConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorServicioConstantesFunciones.LABEL_IDTIPOMOVIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorServicioConstantesFunciones.LABEL_IDTIPOMOVIMIENTOMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaProveedorServicioConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataFacturaProveedorServicio(String sTipo,Row row,Workbook workbook,FacturaProveedorServicio facturaproveedorservicio,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedorservicio.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedorservicio.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedorservicio.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedorservicio.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedorservicio.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedorservicio.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedorservicio.getmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedorservicio.gettransaccion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedorservicio.getfactura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedorservicio.getnumero_factura());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedorservicio.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedorservicio.getruc());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedorservicio.gettipodocumento_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedorservicio.getplazo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(facturaproveedorservicio.getcon_rise()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedorservicio.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedorservicio.getfecha_vence());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedorservicio.getempleadosolicita_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedorservicio.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedorservicio.getdetalle());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedorservicio.getnumero_retencion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedorservicio.getnumero_autorizacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedorservicio.getnumero_serie());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedorservicio.gettipotributario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedorservicio.getfecha_validez());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedorservicio.getanexo_factura_inicio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedorservicio.getanexo_factura_fin());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedorservicio.getmoneda_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedorservicio.getvalor_servicios0());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedorservicio.gettotal_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedorservicio.getiva_porcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedorservicio.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedorservicio.getnumero_mayor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedorservicio.getcodigo_asiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedorservicio.gettiporetencionfuente1_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedorservicio.gettiporetencioniva1_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedorservicio.getanexo_numero_autorizacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedorservicio.getanexo_numeso_serie());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedorservicio.getanexo_fecha_validez());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedorservicio.getcuentacontablecreditofiscalservicios_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedorservicio.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedorservicio.gettipomovimiento_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedorservicio.gettipomovimientomodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaproveedorservicio.gettipotransaccionmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryFacturaProveedorServicio=Constantes.SFINALQUERY;
	
	public String getsFinalQueryFacturaProveedorServicio() {
		return this.sFinalQueryFacturaProveedorServicio;
	}
	
	public void setsFinalQueryFacturaProveedorServicio(String sFinalQueryFacturaProveedorServicio) {
		this.sFinalQueryFacturaProveedorServicio= sFinalQueryFacturaProveedorServicio;
	}
	
	public Border resaltarSeleccionarFacturaProveedorServicio=null;
	
	public Border setResaltarSeleccionarFacturaProveedorServicio(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorServicioBeanSwingJInternalFrame facturaproveedorservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//facturaproveedorservicioBeanSwingJInternalFrame.jTtoolBarFacturaProveedorServicio.setBorder(borderResaltar);
		
		this.resaltarSeleccionarFacturaProveedorServicio= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarFacturaProveedorServicio() {
		return this.resaltarSeleccionarFacturaProveedorServicio;
	}
	
	public void setResaltarSeleccionarFacturaProveedorServicio(Border borderResaltarSeleccionarFacturaProveedorServicio) {
		this.resaltarSeleccionarFacturaProveedorServicio= borderResaltarSeleccionarFacturaProveedorServicio;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridFacturaProveedorServicio=null;
	public Boolean mostraridFacturaProveedorServicio=true;
	public Boolean activaridFacturaProveedorServicio=true;

	public Border resaltarid_empresaFacturaProveedorServicio=null;
	public Boolean mostrarid_empresaFacturaProveedorServicio=true;
	public Boolean activarid_empresaFacturaProveedorServicio=true;
	public Boolean cargarid_empresaFacturaProveedorServicio=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaFacturaProveedorServicio=false;//ConEventDepend=true

	public Border resaltarid_sucursalFacturaProveedorServicio=null;
	public Boolean mostrarid_sucursalFacturaProveedorServicio=true;
	public Boolean activarid_sucursalFacturaProveedorServicio=true;
	public Boolean cargarid_sucursalFacturaProveedorServicio=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalFacturaProveedorServicio=false;//ConEventDepend=true

	public Border resaltarid_ejercicioFacturaProveedorServicio=null;
	public Boolean mostrarid_ejercicioFacturaProveedorServicio=true;
	public Boolean activarid_ejercicioFacturaProveedorServicio=true;
	public Boolean cargarid_ejercicioFacturaProveedorServicio=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioFacturaProveedorServicio=false;//ConEventDepend=true

	public Border resaltarid_periodoFacturaProveedorServicio=null;
	public Boolean mostrarid_periodoFacturaProveedorServicio=true;
	public Boolean activarid_periodoFacturaProveedorServicio=true;
	public Boolean cargarid_periodoFacturaProveedorServicio=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoFacturaProveedorServicio=false;//ConEventDepend=true

	public Border resaltarid_anioFacturaProveedorServicio=null;
	public Boolean mostrarid_anioFacturaProveedorServicio=true;
	public Boolean activarid_anioFacturaProveedorServicio=false;
	public Boolean cargarid_anioFacturaProveedorServicio=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioFacturaProveedorServicio=false;//ConEventDepend=true

	public Border resaltarid_mesFacturaProveedorServicio=null;
	public Boolean mostrarid_mesFacturaProveedorServicio=true;
	public Boolean activarid_mesFacturaProveedorServicio=false;
	public Boolean cargarid_mesFacturaProveedorServicio=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesFacturaProveedorServicio=false;//ConEventDepend=true

	public Border resaltarid_moduloFacturaProveedorServicio=null;
	public Boolean mostrarid_moduloFacturaProveedorServicio=true;
	public Boolean activarid_moduloFacturaProveedorServicio=true;
	public Boolean cargarid_moduloFacturaProveedorServicio=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_moduloFacturaProveedorServicio=false;//ConEventDepend=true

	public Border resaltarid_transaccionFacturaProveedorServicio=null;
	public Boolean mostrarid_transaccionFacturaProveedorServicio=true;
	public Boolean activarid_transaccionFacturaProveedorServicio=true;
	public Boolean cargarid_transaccionFacturaProveedorServicio=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccionFacturaProveedorServicio=false;//ConEventDepend=true

	public Border resaltarid_facturaFacturaProveedorServicio=null;
	public Boolean mostrarid_facturaFacturaProveedorServicio=true;
	public Boolean activarid_facturaFacturaProveedorServicio=true;
	public Boolean cargarid_facturaFacturaProveedorServicio=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_facturaFacturaProveedorServicio=false;//ConEventDepend=true

	public Border resaltarnumero_facturaFacturaProveedorServicio=null;
	public Boolean mostrarnumero_facturaFacturaProveedorServicio=true;
	public Boolean activarnumero_facturaFacturaProveedorServicio=true;

	public Border resaltarid_clienteFacturaProveedorServicio=null;
	public Boolean mostrarid_clienteFacturaProveedorServicio=true;
	public Boolean activarid_clienteFacturaProveedorServicio=true;
	public Boolean cargarid_clienteFacturaProveedorServicio=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteFacturaProveedorServicio=false;//ConEventDepend=true

	public Border resaltarrucFacturaProveedorServicio=null;
	public Boolean mostrarrucFacturaProveedorServicio=true;
	public Boolean activarrucFacturaProveedorServicio=false;

	public Border resaltarid_tipo_documentoFacturaProveedorServicio=null;
	public Boolean mostrarid_tipo_documentoFacturaProveedorServicio=true;
	public Boolean activarid_tipo_documentoFacturaProveedorServicio=true;
	public Boolean cargarid_tipo_documentoFacturaProveedorServicio=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_documentoFacturaProveedorServicio=false;//ConEventDepend=true

	public Border resaltarplazoFacturaProveedorServicio=null;
	public Boolean mostrarplazoFacturaProveedorServicio=true;
	public Boolean activarplazoFacturaProveedorServicio=true;

	public Border resaltarcon_riseFacturaProveedorServicio=null;
	public Boolean mostrarcon_riseFacturaProveedorServicio=true;
	public Boolean activarcon_riseFacturaProveedorServicio=true;

	public Border resaltarfecha_emisionFacturaProveedorServicio=null;
	public Boolean mostrarfecha_emisionFacturaProveedorServicio=true;
	public Boolean activarfecha_emisionFacturaProveedorServicio=true;

	public Border resaltarfecha_venceFacturaProveedorServicio=null;
	public Boolean mostrarfecha_venceFacturaProveedorServicio=true;
	public Boolean activarfecha_venceFacturaProveedorServicio=true;

	public Border resaltarid_empleado_solicitaFacturaProveedorServicio=null;
	public Boolean mostrarid_empleado_solicitaFacturaProveedorServicio=true;
	public Boolean activarid_empleado_solicitaFacturaProveedorServicio=true;
	public Boolean cargarid_empleado_solicitaFacturaProveedorServicio=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleado_solicitaFacturaProveedorServicio=false;//ConEventDepend=true

	public Border resaltarid_empleadoFacturaProveedorServicio=null;
	public Boolean mostrarid_empleadoFacturaProveedorServicio=true;
	public Boolean activarid_empleadoFacturaProveedorServicio=true;
	public Boolean cargarid_empleadoFacturaProveedorServicio=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoFacturaProveedorServicio=false;//ConEventDepend=true

	public Border resaltardetalleFacturaProveedorServicio=null;
	public Boolean mostrardetalleFacturaProveedorServicio=true;
	public Boolean activardetalleFacturaProveedorServicio=true;

	public Border resaltarnumero_retencionFacturaProveedorServicio=null;
	public Boolean mostrarnumero_retencionFacturaProveedorServicio=true;
	public Boolean activarnumero_retencionFacturaProveedorServicio=true;

	public Border resaltarnumero_autorizacionFacturaProveedorServicio=null;
	public Boolean mostrarnumero_autorizacionFacturaProveedorServicio=true;
	public Boolean activarnumero_autorizacionFacturaProveedorServicio=true;

	public Border resaltarnumero_serieFacturaProveedorServicio=null;
	public Boolean mostrarnumero_serieFacturaProveedorServicio=true;
	public Boolean activarnumero_serieFacturaProveedorServicio=true;

	public Border resaltarid_tipo_tributarioFacturaProveedorServicio=null;
	public Boolean mostrarid_tipo_tributarioFacturaProveedorServicio=true;
	public Boolean activarid_tipo_tributarioFacturaProveedorServicio=true;
	public Boolean cargarid_tipo_tributarioFacturaProveedorServicio=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_tributarioFacturaProveedorServicio=false;//ConEventDepend=true

	public Border resaltarfecha_validezFacturaProveedorServicio=null;
	public Boolean mostrarfecha_validezFacturaProveedorServicio=true;
	public Boolean activarfecha_validezFacturaProveedorServicio=true;

	public Border resaltaranexo_factura_inicioFacturaProveedorServicio=null;
	public Boolean mostraranexo_factura_inicioFacturaProveedorServicio=true;
	public Boolean activaranexo_factura_inicioFacturaProveedorServicio=true;

	public Border resaltaranexo_factura_finFacturaProveedorServicio=null;
	public Boolean mostraranexo_factura_finFacturaProveedorServicio=true;
	public Boolean activaranexo_factura_finFacturaProveedorServicio=true;

	public Border resaltarid_monedaFacturaProveedorServicio=null;
	public Boolean mostrarid_monedaFacturaProveedorServicio=true;
	public Boolean activarid_monedaFacturaProveedorServicio=false;
	public Boolean cargarid_monedaFacturaProveedorServicio=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_monedaFacturaProveedorServicio=false;//ConEventDepend=true

	public Border resaltarvalor_servicios0FacturaProveedorServicio=null;
	public Boolean mostrarvalor_servicios0FacturaProveedorServicio=true;
	public Boolean activarvalor_servicios0FacturaProveedorServicio=false;

	public Border resaltartotal_ivaFacturaProveedorServicio=null;
	public Boolean mostrartotal_ivaFacturaProveedorServicio=true;
	public Boolean activartotal_ivaFacturaProveedorServicio=false;

	public Border resaltariva_porcentajeFacturaProveedorServicio=null;
	public Boolean mostrariva_porcentajeFacturaProveedorServicio=true;
	public Boolean activariva_porcentajeFacturaProveedorServicio=false;

	public Border resaltartotalFacturaProveedorServicio=null;
	public Boolean mostrartotalFacturaProveedorServicio=true;
	public Boolean activartotalFacturaProveedorServicio=false;

	public Border resaltarnumero_mayorFacturaProveedorServicio=null;
	public Boolean mostrarnumero_mayorFacturaProveedorServicio=true;
	public Boolean activarnumero_mayorFacturaProveedorServicio=false;

	public Border resaltarcodigo_asientoFacturaProveedorServicio=null;
	public Boolean mostrarcodigo_asientoFacturaProveedorServicio=true;
	public Boolean activarcodigo_asientoFacturaProveedorServicio=false;

	public Border resaltarid_tipo_retencion_fuente1FacturaProveedorServicio=null;
	public Boolean mostrarid_tipo_retencion_fuente1FacturaProveedorServicio=true;
	public Boolean activarid_tipo_retencion_fuente1FacturaProveedorServicio=false;
	public Boolean cargarid_tipo_retencion_fuente1FacturaProveedorServicio=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_retencion_fuente1FacturaProveedorServicio=false;//ConEventDepend=true

	public Border resaltarid_tipo_retencion_iva1FacturaProveedorServicio=null;
	public Boolean mostrarid_tipo_retencion_iva1FacturaProveedorServicio=true;
	public Boolean activarid_tipo_retencion_iva1FacturaProveedorServicio=false;
	public Boolean cargarid_tipo_retencion_iva1FacturaProveedorServicio=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_retencion_iva1FacturaProveedorServicio=false;//ConEventDepend=true

	public Border resaltaranexo_numero_autorizacionFacturaProveedorServicio=null;
	public Boolean mostraranexo_numero_autorizacionFacturaProveedorServicio=true;
	public Boolean activaranexo_numero_autorizacionFacturaProveedorServicio=false;

	public Border resaltaranexo_numeso_serieFacturaProveedorServicio=null;
	public Boolean mostraranexo_numeso_serieFacturaProveedorServicio=true;
	public Boolean activaranexo_numeso_serieFacturaProveedorServicio=false;

	public Border resaltaranexo_fecha_validezFacturaProveedorServicio=null;
	public Boolean mostraranexo_fecha_validezFacturaProveedorServicio=true;
	public Boolean activaranexo_fecha_validezFacturaProveedorServicio=false;

	public Border resaltarid_cuenta_contable_credito_fiscal_serviciosFacturaProveedorServicio=null;
	public Boolean mostrarid_cuenta_contable_credito_fiscal_serviciosFacturaProveedorServicio=true;
	public Boolean activarid_cuenta_contable_credito_fiscal_serviciosFacturaProveedorServicio=false;
	public Boolean cargarid_cuenta_contable_credito_fiscal_serviciosFacturaProveedorServicio=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_credito_fiscal_serviciosFacturaProveedorServicio=false;//ConEventDepend=true

	public Border resaltardescripcionFacturaProveedorServicio=null;
	public Boolean mostrardescripcionFacturaProveedorServicio=true;
	public Boolean activardescripcionFacturaProveedorServicio=false;

	public Border resaltarid_tipo_movimientoFacturaProveedorServicio=null;
	public Boolean mostrarid_tipo_movimientoFacturaProveedorServicio=true;
	public Boolean activarid_tipo_movimientoFacturaProveedorServicio=false;
	public Boolean cargarid_tipo_movimientoFacturaProveedorServicio=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_movimientoFacturaProveedorServicio=false;//ConEventDepend=true

	public Border resaltarid_tipo_movimiento_moduloFacturaProveedorServicio=null;
	public Boolean mostrarid_tipo_movimiento_moduloFacturaProveedorServicio=true;
	public Boolean activarid_tipo_movimiento_moduloFacturaProveedorServicio=false;
	public Boolean cargarid_tipo_movimiento_moduloFacturaProveedorServicio=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_movimiento_moduloFacturaProveedorServicio=false;//ConEventDepend=true

	public Border resaltarid_tipo_transaccion_moduloFacturaProveedorServicio=null;
	public Boolean mostrarid_tipo_transaccion_moduloFacturaProveedorServicio=true;
	public Boolean activarid_tipo_transaccion_moduloFacturaProveedorServicio=false;
	public Boolean cargarid_tipo_transaccion_moduloFacturaProveedorServicio=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_transaccion_moduloFacturaProveedorServicio=false;//ConEventDepend=true

	
	

	public Border setResaltaridFacturaProveedorServicio(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorServicioBeanSwingJInternalFrame facturaproveedorservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorservicioBeanSwingJInternalFrame.jTtoolBarFacturaProveedorServicio.setBorder(borderResaltar);
		
		this.resaltaridFacturaProveedorServicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridFacturaProveedorServicio() {
		return this.resaltaridFacturaProveedorServicio;
	}

	public void setResaltaridFacturaProveedorServicio(Border borderResaltar) {
		this.resaltaridFacturaProveedorServicio= borderResaltar;
	}

	public Boolean getMostraridFacturaProveedorServicio() {
		return this.mostraridFacturaProveedorServicio;
	}

	public void setMostraridFacturaProveedorServicio(Boolean mostraridFacturaProveedorServicio) {
		this.mostraridFacturaProveedorServicio= mostraridFacturaProveedorServicio;
	}

	public Boolean getActivaridFacturaProveedorServicio() {
		return this.activaridFacturaProveedorServicio;
	}

	public void setActivaridFacturaProveedorServicio(Boolean activaridFacturaProveedorServicio) {
		this.activaridFacturaProveedorServicio= activaridFacturaProveedorServicio;
	}

	public Border setResaltarid_empresaFacturaProveedorServicio(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorServicioBeanSwingJInternalFrame facturaproveedorservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorservicioBeanSwingJInternalFrame.jTtoolBarFacturaProveedorServicio.setBorder(borderResaltar);
		
		this.resaltarid_empresaFacturaProveedorServicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaFacturaProveedorServicio() {
		return this.resaltarid_empresaFacturaProveedorServicio;
	}

	public void setResaltarid_empresaFacturaProveedorServicio(Border borderResaltar) {
		this.resaltarid_empresaFacturaProveedorServicio= borderResaltar;
	}

	public Boolean getMostrarid_empresaFacturaProveedorServicio() {
		return this.mostrarid_empresaFacturaProveedorServicio;
	}

	public void setMostrarid_empresaFacturaProveedorServicio(Boolean mostrarid_empresaFacturaProveedorServicio) {
		this.mostrarid_empresaFacturaProveedorServicio= mostrarid_empresaFacturaProveedorServicio;
	}

	public Boolean getActivarid_empresaFacturaProveedorServicio() {
		return this.activarid_empresaFacturaProveedorServicio;
	}

	public void setActivarid_empresaFacturaProveedorServicio(Boolean activarid_empresaFacturaProveedorServicio) {
		this.activarid_empresaFacturaProveedorServicio= activarid_empresaFacturaProveedorServicio;
	}

	public Boolean getCargarid_empresaFacturaProveedorServicio() {
		return this.cargarid_empresaFacturaProveedorServicio;
	}

	public void setCargarid_empresaFacturaProveedorServicio(Boolean cargarid_empresaFacturaProveedorServicio) {
		this.cargarid_empresaFacturaProveedorServicio= cargarid_empresaFacturaProveedorServicio;
	}

	public Border setResaltarid_sucursalFacturaProveedorServicio(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorServicioBeanSwingJInternalFrame facturaproveedorservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorservicioBeanSwingJInternalFrame.jTtoolBarFacturaProveedorServicio.setBorder(borderResaltar);
		
		this.resaltarid_sucursalFacturaProveedorServicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalFacturaProveedorServicio() {
		return this.resaltarid_sucursalFacturaProveedorServicio;
	}

	public void setResaltarid_sucursalFacturaProveedorServicio(Border borderResaltar) {
		this.resaltarid_sucursalFacturaProveedorServicio= borderResaltar;
	}

	public Boolean getMostrarid_sucursalFacturaProveedorServicio() {
		return this.mostrarid_sucursalFacturaProveedorServicio;
	}

	public void setMostrarid_sucursalFacturaProveedorServicio(Boolean mostrarid_sucursalFacturaProveedorServicio) {
		this.mostrarid_sucursalFacturaProveedorServicio= mostrarid_sucursalFacturaProveedorServicio;
	}

	public Boolean getActivarid_sucursalFacturaProveedorServicio() {
		return this.activarid_sucursalFacturaProveedorServicio;
	}

	public void setActivarid_sucursalFacturaProveedorServicio(Boolean activarid_sucursalFacturaProveedorServicio) {
		this.activarid_sucursalFacturaProveedorServicio= activarid_sucursalFacturaProveedorServicio;
	}

	public Boolean getCargarid_sucursalFacturaProveedorServicio() {
		return this.cargarid_sucursalFacturaProveedorServicio;
	}

	public void setCargarid_sucursalFacturaProveedorServicio(Boolean cargarid_sucursalFacturaProveedorServicio) {
		this.cargarid_sucursalFacturaProveedorServicio= cargarid_sucursalFacturaProveedorServicio;
	}

	public Border setResaltarid_ejercicioFacturaProveedorServicio(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorServicioBeanSwingJInternalFrame facturaproveedorservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorservicioBeanSwingJInternalFrame.jTtoolBarFacturaProveedorServicio.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioFacturaProveedorServicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioFacturaProveedorServicio() {
		return this.resaltarid_ejercicioFacturaProveedorServicio;
	}

	public void setResaltarid_ejercicioFacturaProveedorServicio(Border borderResaltar) {
		this.resaltarid_ejercicioFacturaProveedorServicio= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioFacturaProveedorServicio() {
		return this.mostrarid_ejercicioFacturaProveedorServicio;
	}

	public void setMostrarid_ejercicioFacturaProveedorServicio(Boolean mostrarid_ejercicioFacturaProveedorServicio) {
		this.mostrarid_ejercicioFacturaProveedorServicio= mostrarid_ejercicioFacturaProveedorServicio;
	}

	public Boolean getActivarid_ejercicioFacturaProveedorServicio() {
		return this.activarid_ejercicioFacturaProveedorServicio;
	}

	public void setActivarid_ejercicioFacturaProveedorServicio(Boolean activarid_ejercicioFacturaProveedorServicio) {
		this.activarid_ejercicioFacturaProveedorServicio= activarid_ejercicioFacturaProveedorServicio;
	}

	public Boolean getCargarid_ejercicioFacturaProveedorServicio() {
		return this.cargarid_ejercicioFacturaProveedorServicio;
	}

	public void setCargarid_ejercicioFacturaProveedorServicio(Boolean cargarid_ejercicioFacturaProveedorServicio) {
		this.cargarid_ejercicioFacturaProveedorServicio= cargarid_ejercicioFacturaProveedorServicio;
	}

	public Border setResaltarid_periodoFacturaProveedorServicio(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorServicioBeanSwingJInternalFrame facturaproveedorservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorservicioBeanSwingJInternalFrame.jTtoolBarFacturaProveedorServicio.setBorder(borderResaltar);
		
		this.resaltarid_periodoFacturaProveedorServicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoFacturaProveedorServicio() {
		return this.resaltarid_periodoFacturaProveedorServicio;
	}

	public void setResaltarid_periodoFacturaProveedorServicio(Border borderResaltar) {
		this.resaltarid_periodoFacturaProveedorServicio= borderResaltar;
	}

	public Boolean getMostrarid_periodoFacturaProveedorServicio() {
		return this.mostrarid_periodoFacturaProveedorServicio;
	}

	public void setMostrarid_periodoFacturaProveedorServicio(Boolean mostrarid_periodoFacturaProveedorServicio) {
		this.mostrarid_periodoFacturaProveedorServicio= mostrarid_periodoFacturaProveedorServicio;
	}

	public Boolean getActivarid_periodoFacturaProveedorServicio() {
		return this.activarid_periodoFacturaProveedorServicio;
	}

	public void setActivarid_periodoFacturaProveedorServicio(Boolean activarid_periodoFacturaProveedorServicio) {
		this.activarid_periodoFacturaProveedorServicio= activarid_periodoFacturaProveedorServicio;
	}

	public Boolean getCargarid_periodoFacturaProveedorServicio() {
		return this.cargarid_periodoFacturaProveedorServicio;
	}

	public void setCargarid_periodoFacturaProveedorServicio(Boolean cargarid_periodoFacturaProveedorServicio) {
		this.cargarid_periodoFacturaProveedorServicio= cargarid_periodoFacturaProveedorServicio;
	}

	public Border setResaltarid_anioFacturaProveedorServicio(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorServicioBeanSwingJInternalFrame facturaproveedorservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorservicioBeanSwingJInternalFrame.jTtoolBarFacturaProveedorServicio.setBorder(borderResaltar);
		
		this.resaltarid_anioFacturaProveedorServicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioFacturaProveedorServicio() {
		return this.resaltarid_anioFacturaProveedorServicio;
	}

	public void setResaltarid_anioFacturaProveedorServicio(Border borderResaltar) {
		this.resaltarid_anioFacturaProveedorServicio= borderResaltar;
	}

	public Boolean getMostrarid_anioFacturaProveedorServicio() {
		return this.mostrarid_anioFacturaProveedorServicio;
	}

	public void setMostrarid_anioFacturaProveedorServicio(Boolean mostrarid_anioFacturaProveedorServicio) {
		this.mostrarid_anioFacturaProveedorServicio= mostrarid_anioFacturaProveedorServicio;
	}

	public Boolean getActivarid_anioFacturaProveedorServicio() {
		return this.activarid_anioFacturaProveedorServicio;
	}

	public void setActivarid_anioFacturaProveedorServicio(Boolean activarid_anioFacturaProveedorServicio) {
		this.activarid_anioFacturaProveedorServicio= activarid_anioFacturaProveedorServicio;
	}

	public Boolean getCargarid_anioFacturaProveedorServicio() {
		return this.cargarid_anioFacturaProveedorServicio;
	}

	public void setCargarid_anioFacturaProveedorServicio(Boolean cargarid_anioFacturaProveedorServicio) {
		this.cargarid_anioFacturaProveedorServicio= cargarid_anioFacturaProveedorServicio;
	}

	public Border setResaltarid_mesFacturaProveedorServicio(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorServicioBeanSwingJInternalFrame facturaproveedorservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorservicioBeanSwingJInternalFrame.jTtoolBarFacturaProveedorServicio.setBorder(borderResaltar);
		
		this.resaltarid_mesFacturaProveedorServicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesFacturaProveedorServicio() {
		return this.resaltarid_mesFacturaProveedorServicio;
	}

	public void setResaltarid_mesFacturaProveedorServicio(Border borderResaltar) {
		this.resaltarid_mesFacturaProveedorServicio= borderResaltar;
	}

	public Boolean getMostrarid_mesFacturaProveedorServicio() {
		return this.mostrarid_mesFacturaProveedorServicio;
	}

	public void setMostrarid_mesFacturaProveedorServicio(Boolean mostrarid_mesFacturaProveedorServicio) {
		this.mostrarid_mesFacturaProveedorServicio= mostrarid_mesFacturaProveedorServicio;
	}

	public Boolean getActivarid_mesFacturaProveedorServicio() {
		return this.activarid_mesFacturaProveedorServicio;
	}

	public void setActivarid_mesFacturaProveedorServicio(Boolean activarid_mesFacturaProveedorServicio) {
		this.activarid_mesFacturaProveedorServicio= activarid_mesFacturaProveedorServicio;
	}

	public Boolean getCargarid_mesFacturaProveedorServicio() {
		return this.cargarid_mesFacturaProveedorServicio;
	}

	public void setCargarid_mesFacturaProveedorServicio(Boolean cargarid_mesFacturaProveedorServicio) {
		this.cargarid_mesFacturaProveedorServicio= cargarid_mesFacturaProveedorServicio;
	}

	public Border setResaltarid_moduloFacturaProveedorServicio(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorServicioBeanSwingJInternalFrame facturaproveedorservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorservicioBeanSwingJInternalFrame.jTtoolBarFacturaProveedorServicio.setBorder(borderResaltar);
		
		this.resaltarid_moduloFacturaProveedorServicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_moduloFacturaProveedorServicio() {
		return this.resaltarid_moduloFacturaProveedorServicio;
	}

	public void setResaltarid_moduloFacturaProveedorServicio(Border borderResaltar) {
		this.resaltarid_moduloFacturaProveedorServicio= borderResaltar;
	}

	public Boolean getMostrarid_moduloFacturaProveedorServicio() {
		return this.mostrarid_moduloFacturaProveedorServicio;
	}

	public void setMostrarid_moduloFacturaProveedorServicio(Boolean mostrarid_moduloFacturaProveedorServicio) {
		this.mostrarid_moduloFacturaProveedorServicio= mostrarid_moduloFacturaProveedorServicio;
	}

	public Boolean getActivarid_moduloFacturaProveedorServicio() {
		return this.activarid_moduloFacturaProveedorServicio;
	}

	public void setActivarid_moduloFacturaProveedorServicio(Boolean activarid_moduloFacturaProveedorServicio) {
		this.activarid_moduloFacturaProveedorServicio= activarid_moduloFacturaProveedorServicio;
	}

	public Boolean getCargarid_moduloFacturaProveedorServicio() {
		return this.cargarid_moduloFacturaProveedorServicio;
	}

	public void setCargarid_moduloFacturaProveedorServicio(Boolean cargarid_moduloFacturaProveedorServicio) {
		this.cargarid_moduloFacturaProveedorServicio= cargarid_moduloFacturaProveedorServicio;
	}

	public Border setResaltarid_transaccionFacturaProveedorServicio(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorServicioBeanSwingJInternalFrame facturaproveedorservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorservicioBeanSwingJInternalFrame.jTtoolBarFacturaProveedorServicio.setBorder(borderResaltar);
		
		this.resaltarid_transaccionFacturaProveedorServicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccionFacturaProveedorServicio() {
		return this.resaltarid_transaccionFacturaProveedorServicio;
	}

	public void setResaltarid_transaccionFacturaProveedorServicio(Border borderResaltar) {
		this.resaltarid_transaccionFacturaProveedorServicio= borderResaltar;
	}

	public Boolean getMostrarid_transaccionFacturaProveedorServicio() {
		return this.mostrarid_transaccionFacturaProveedorServicio;
	}

	public void setMostrarid_transaccionFacturaProveedorServicio(Boolean mostrarid_transaccionFacturaProveedorServicio) {
		this.mostrarid_transaccionFacturaProveedorServicio= mostrarid_transaccionFacturaProveedorServicio;
	}

	public Boolean getActivarid_transaccionFacturaProveedorServicio() {
		return this.activarid_transaccionFacturaProveedorServicio;
	}

	public void setActivarid_transaccionFacturaProveedorServicio(Boolean activarid_transaccionFacturaProveedorServicio) {
		this.activarid_transaccionFacturaProveedorServicio= activarid_transaccionFacturaProveedorServicio;
	}

	public Boolean getCargarid_transaccionFacturaProveedorServicio() {
		return this.cargarid_transaccionFacturaProveedorServicio;
	}

	public void setCargarid_transaccionFacturaProveedorServicio(Boolean cargarid_transaccionFacturaProveedorServicio) {
		this.cargarid_transaccionFacturaProveedorServicio= cargarid_transaccionFacturaProveedorServicio;
	}

	public Border setResaltarid_facturaFacturaProveedorServicio(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorServicioBeanSwingJInternalFrame facturaproveedorservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorservicioBeanSwingJInternalFrame.jTtoolBarFacturaProveedorServicio.setBorder(borderResaltar);
		
		this.resaltarid_facturaFacturaProveedorServicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_facturaFacturaProveedorServicio() {
		return this.resaltarid_facturaFacturaProveedorServicio;
	}

	public void setResaltarid_facturaFacturaProveedorServicio(Border borderResaltar) {
		this.resaltarid_facturaFacturaProveedorServicio= borderResaltar;
	}

	public Boolean getMostrarid_facturaFacturaProveedorServicio() {
		return this.mostrarid_facturaFacturaProveedorServicio;
	}

	public void setMostrarid_facturaFacturaProveedorServicio(Boolean mostrarid_facturaFacturaProveedorServicio) {
		this.mostrarid_facturaFacturaProveedorServicio= mostrarid_facturaFacturaProveedorServicio;
	}

	public Boolean getActivarid_facturaFacturaProveedorServicio() {
		return this.activarid_facturaFacturaProveedorServicio;
	}

	public void setActivarid_facturaFacturaProveedorServicio(Boolean activarid_facturaFacturaProveedorServicio) {
		this.activarid_facturaFacturaProveedorServicio= activarid_facturaFacturaProveedorServicio;
	}

	public Boolean getCargarid_facturaFacturaProveedorServicio() {
		return this.cargarid_facturaFacturaProveedorServicio;
	}

	public void setCargarid_facturaFacturaProveedorServicio(Boolean cargarid_facturaFacturaProveedorServicio) {
		this.cargarid_facturaFacturaProveedorServicio= cargarid_facturaFacturaProveedorServicio;
	}

	public Border setResaltarnumero_facturaFacturaProveedorServicio(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorServicioBeanSwingJInternalFrame facturaproveedorservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorservicioBeanSwingJInternalFrame.jTtoolBarFacturaProveedorServicio.setBorder(borderResaltar);
		
		this.resaltarnumero_facturaFacturaProveedorServicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_facturaFacturaProveedorServicio() {
		return this.resaltarnumero_facturaFacturaProveedorServicio;
	}

	public void setResaltarnumero_facturaFacturaProveedorServicio(Border borderResaltar) {
		this.resaltarnumero_facturaFacturaProveedorServicio= borderResaltar;
	}

	public Boolean getMostrarnumero_facturaFacturaProveedorServicio() {
		return this.mostrarnumero_facturaFacturaProveedorServicio;
	}

	public void setMostrarnumero_facturaFacturaProveedorServicio(Boolean mostrarnumero_facturaFacturaProveedorServicio) {
		this.mostrarnumero_facturaFacturaProveedorServicio= mostrarnumero_facturaFacturaProveedorServicio;
	}

	public Boolean getActivarnumero_facturaFacturaProveedorServicio() {
		return this.activarnumero_facturaFacturaProveedorServicio;
	}

	public void setActivarnumero_facturaFacturaProveedorServicio(Boolean activarnumero_facturaFacturaProveedorServicio) {
		this.activarnumero_facturaFacturaProveedorServicio= activarnumero_facturaFacturaProveedorServicio;
	}

	public Border setResaltarid_clienteFacturaProveedorServicio(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorServicioBeanSwingJInternalFrame facturaproveedorservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorservicioBeanSwingJInternalFrame.jTtoolBarFacturaProveedorServicio.setBorder(borderResaltar);
		
		this.resaltarid_clienteFacturaProveedorServicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteFacturaProveedorServicio() {
		return this.resaltarid_clienteFacturaProveedorServicio;
	}

	public void setResaltarid_clienteFacturaProveedorServicio(Border borderResaltar) {
		this.resaltarid_clienteFacturaProveedorServicio= borderResaltar;
	}

	public Boolean getMostrarid_clienteFacturaProveedorServicio() {
		return this.mostrarid_clienteFacturaProveedorServicio;
	}

	public void setMostrarid_clienteFacturaProveedorServicio(Boolean mostrarid_clienteFacturaProveedorServicio) {
		this.mostrarid_clienteFacturaProveedorServicio= mostrarid_clienteFacturaProveedorServicio;
	}

	public Boolean getActivarid_clienteFacturaProveedorServicio() {
		return this.activarid_clienteFacturaProveedorServicio;
	}

	public void setActivarid_clienteFacturaProveedorServicio(Boolean activarid_clienteFacturaProveedorServicio) {
		this.activarid_clienteFacturaProveedorServicio= activarid_clienteFacturaProveedorServicio;
	}

	public Boolean getCargarid_clienteFacturaProveedorServicio() {
		return this.cargarid_clienteFacturaProveedorServicio;
	}

	public void setCargarid_clienteFacturaProveedorServicio(Boolean cargarid_clienteFacturaProveedorServicio) {
		this.cargarid_clienteFacturaProveedorServicio= cargarid_clienteFacturaProveedorServicio;
	}

	public Border setResaltarrucFacturaProveedorServicio(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorServicioBeanSwingJInternalFrame facturaproveedorservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorservicioBeanSwingJInternalFrame.jTtoolBarFacturaProveedorServicio.setBorder(borderResaltar);
		
		this.resaltarrucFacturaProveedorServicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarrucFacturaProveedorServicio() {
		return this.resaltarrucFacturaProveedorServicio;
	}

	public void setResaltarrucFacturaProveedorServicio(Border borderResaltar) {
		this.resaltarrucFacturaProveedorServicio= borderResaltar;
	}

	public Boolean getMostrarrucFacturaProveedorServicio() {
		return this.mostrarrucFacturaProveedorServicio;
	}

	public void setMostrarrucFacturaProveedorServicio(Boolean mostrarrucFacturaProveedorServicio) {
		this.mostrarrucFacturaProveedorServicio= mostrarrucFacturaProveedorServicio;
	}

	public Boolean getActivarrucFacturaProveedorServicio() {
		return this.activarrucFacturaProveedorServicio;
	}

	public void setActivarrucFacturaProveedorServicio(Boolean activarrucFacturaProveedorServicio) {
		this.activarrucFacturaProveedorServicio= activarrucFacturaProveedorServicio;
	}

	public Border setResaltarid_tipo_documentoFacturaProveedorServicio(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorServicioBeanSwingJInternalFrame facturaproveedorservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorservicioBeanSwingJInternalFrame.jTtoolBarFacturaProveedorServicio.setBorder(borderResaltar);
		
		this.resaltarid_tipo_documentoFacturaProveedorServicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_documentoFacturaProveedorServicio() {
		return this.resaltarid_tipo_documentoFacturaProveedorServicio;
	}

	public void setResaltarid_tipo_documentoFacturaProveedorServicio(Border borderResaltar) {
		this.resaltarid_tipo_documentoFacturaProveedorServicio= borderResaltar;
	}

	public Boolean getMostrarid_tipo_documentoFacturaProveedorServicio() {
		return this.mostrarid_tipo_documentoFacturaProveedorServicio;
	}

	public void setMostrarid_tipo_documentoFacturaProveedorServicio(Boolean mostrarid_tipo_documentoFacturaProveedorServicio) {
		this.mostrarid_tipo_documentoFacturaProveedorServicio= mostrarid_tipo_documentoFacturaProveedorServicio;
	}

	public Boolean getActivarid_tipo_documentoFacturaProveedorServicio() {
		return this.activarid_tipo_documentoFacturaProveedorServicio;
	}

	public void setActivarid_tipo_documentoFacturaProveedorServicio(Boolean activarid_tipo_documentoFacturaProveedorServicio) {
		this.activarid_tipo_documentoFacturaProveedorServicio= activarid_tipo_documentoFacturaProveedorServicio;
	}

	public Boolean getCargarid_tipo_documentoFacturaProveedorServicio() {
		return this.cargarid_tipo_documentoFacturaProveedorServicio;
	}

	public void setCargarid_tipo_documentoFacturaProveedorServicio(Boolean cargarid_tipo_documentoFacturaProveedorServicio) {
		this.cargarid_tipo_documentoFacturaProveedorServicio= cargarid_tipo_documentoFacturaProveedorServicio;
	}

	public Border setResaltarplazoFacturaProveedorServicio(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorServicioBeanSwingJInternalFrame facturaproveedorservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorservicioBeanSwingJInternalFrame.jTtoolBarFacturaProveedorServicio.setBorder(borderResaltar);
		
		this.resaltarplazoFacturaProveedorServicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarplazoFacturaProveedorServicio() {
		return this.resaltarplazoFacturaProveedorServicio;
	}

	public void setResaltarplazoFacturaProveedorServicio(Border borderResaltar) {
		this.resaltarplazoFacturaProveedorServicio= borderResaltar;
	}

	public Boolean getMostrarplazoFacturaProveedorServicio() {
		return this.mostrarplazoFacturaProveedorServicio;
	}

	public void setMostrarplazoFacturaProveedorServicio(Boolean mostrarplazoFacturaProveedorServicio) {
		this.mostrarplazoFacturaProveedorServicio= mostrarplazoFacturaProveedorServicio;
	}

	public Boolean getActivarplazoFacturaProveedorServicio() {
		return this.activarplazoFacturaProveedorServicio;
	}

	public void setActivarplazoFacturaProveedorServicio(Boolean activarplazoFacturaProveedorServicio) {
		this.activarplazoFacturaProveedorServicio= activarplazoFacturaProveedorServicio;
	}

	public Border setResaltarcon_riseFacturaProveedorServicio(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorServicioBeanSwingJInternalFrame facturaproveedorservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorservicioBeanSwingJInternalFrame.jTtoolBarFacturaProveedorServicio.setBorder(borderResaltar);
		
		this.resaltarcon_riseFacturaProveedorServicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_riseFacturaProveedorServicio() {
		return this.resaltarcon_riseFacturaProveedorServicio;
	}

	public void setResaltarcon_riseFacturaProveedorServicio(Border borderResaltar) {
		this.resaltarcon_riseFacturaProveedorServicio= borderResaltar;
	}

	public Boolean getMostrarcon_riseFacturaProveedorServicio() {
		return this.mostrarcon_riseFacturaProveedorServicio;
	}

	public void setMostrarcon_riseFacturaProveedorServicio(Boolean mostrarcon_riseFacturaProveedorServicio) {
		this.mostrarcon_riseFacturaProveedorServicio= mostrarcon_riseFacturaProveedorServicio;
	}

	public Boolean getActivarcon_riseFacturaProveedorServicio() {
		return this.activarcon_riseFacturaProveedorServicio;
	}

	public void setActivarcon_riseFacturaProveedorServicio(Boolean activarcon_riseFacturaProveedorServicio) {
		this.activarcon_riseFacturaProveedorServicio= activarcon_riseFacturaProveedorServicio;
	}

	public Border setResaltarfecha_emisionFacturaProveedorServicio(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorServicioBeanSwingJInternalFrame facturaproveedorservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorservicioBeanSwingJInternalFrame.jTtoolBarFacturaProveedorServicio.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionFacturaProveedorServicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionFacturaProveedorServicio() {
		return this.resaltarfecha_emisionFacturaProveedorServicio;
	}

	public void setResaltarfecha_emisionFacturaProveedorServicio(Border borderResaltar) {
		this.resaltarfecha_emisionFacturaProveedorServicio= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionFacturaProveedorServicio() {
		return this.mostrarfecha_emisionFacturaProveedorServicio;
	}

	public void setMostrarfecha_emisionFacturaProveedorServicio(Boolean mostrarfecha_emisionFacturaProveedorServicio) {
		this.mostrarfecha_emisionFacturaProveedorServicio= mostrarfecha_emisionFacturaProveedorServicio;
	}

	public Boolean getActivarfecha_emisionFacturaProveedorServicio() {
		return this.activarfecha_emisionFacturaProveedorServicio;
	}

	public void setActivarfecha_emisionFacturaProveedorServicio(Boolean activarfecha_emisionFacturaProveedorServicio) {
		this.activarfecha_emisionFacturaProveedorServicio= activarfecha_emisionFacturaProveedorServicio;
	}

	public Border setResaltarfecha_venceFacturaProveedorServicio(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorServicioBeanSwingJInternalFrame facturaproveedorservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorservicioBeanSwingJInternalFrame.jTtoolBarFacturaProveedorServicio.setBorder(borderResaltar);
		
		this.resaltarfecha_venceFacturaProveedorServicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_venceFacturaProveedorServicio() {
		return this.resaltarfecha_venceFacturaProveedorServicio;
	}

	public void setResaltarfecha_venceFacturaProveedorServicio(Border borderResaltar) {
		this.resaltarfecha_venceFacturaProveedorServicio= borderResaltar;
	}

	public Boolean getMostrarfecha_venceFacturaProveedorServicio() {
		return this.mostrarfecha_venceFacturaProveedorServicio;
	}

	public void setMostrarfecha_venceFacturaProveedorServicio(Boolean mostrarfecha_venceFacturaProveedorServicio) {
		this.mostrarfecha_venceFacturaProveedorServicio= mostrarfecha_venceFacturaProveedorServicio;
	}

	public Boolean getActivarfecha_venceFacturaProveedorServicio() {
		return this.activarfecha_venceFacturaProveedorServicio;
	}

	public void setActivarfecha_venceFacturaProveedorServicio(Boolean activarfecha_venceFacturaProveedorServicio) {
		this.activarfecha_venceFacturaProveedorServicio= activarfecha_venceFacturaProveedorServicio;
	}

	public Border setResaltarid_empleado_solicitaFacturaProveedorServicio(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorServicioBeanSwingJInternalFrame facturaproveedorservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorservicioBeanSwingJInternalFrame.jTtoolBarFacturaProveedorServicio.setBorder(borderResaltar);
		
		this.resaltarid_empleado_solicitaFacturaProveedorServicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleado_solicitaFacturaProveedorServicio() {
		return this.resaltarid_empleado_solicitaFacturaProveedorServicio;
	}

	public void setResaltarid_empleado_solicitaFacturaProveedorServicio(Border borderResaltar) {
		this.resaltarid_empleado_solicitaFacturaProveedorServicio= borderResaltar;
	}

	public Boolean getMostrarid_empleado_solicitaFacturaProveedorServicio() {
		return this.mostrarid_empleado_solicitaFacturaProveedorServicio;
	}

	public void setMostrarid_empleado_solicitaFacturaProveedorServicio(Boolean mostrarid_empleado_solicitaFacturaProveedorServicio) {
		this.mostrarid_empleado_solicitaFacturaProveedorServicio= mostrarid_empleado_solicitaFacturaProveedorServicio;
	}

	public Boolean getActivarid_empleado_solicitaFacturaProveedorServicio() {
		return this.activarid_empleado_solicitaFacturaProveedorServicio;
	}

	public void setActivarid_empleado_solicitaFacturaProveedorServicio(Boolean activarid_empleado_solicitaFacturaProveedorServicio) {
		this.activarid_empleado_solicitaFacturaProveedorServicio= activarid_empleado_solicitaFacturaProveedorServicio;
	}

	public Boolean getCargarid_empleado_solicitaFacturaProveedorServicio() {
		return this.cargarid_empleado_solicitaFacturaProveedorServicio;
	}

	public void setCargarid_empleado_solicitaFacturaProveedorServicio(Boolean cargarid_empleado_solicitaFacturaProveedorServicio) {
		this.cargarid_empleado_solicitaFacturaProveedorServicio= cargarid_empleado_solicitaFacturaProveedorServicio;
	}

	public Border setResaltarid_empleadoFacturaProveedorServicio(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorServicioBeanSwingJInternalFrame facturaproveedorservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorservicioBeanSwingJInternalFrame.jTtoolBarFacturaProveedorServicio.setBorder(borderResaltar);
		
		this.resaltarid_empleadoFacturaProveedorServicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoFacturaProveedorServicio() {
		return this.resaltarid_empleadoFacturaProveedorServicio;
	}

	public void setResaltarid_empleadoFacturaProveedorServicio(Border borderResaltar) {
		this.resaltarid_empleadoFacturaProveedorServicio= borderResaltar;
	}

	public Boolean getMostrarid_empleadoFacturaProveedorServicio() {
		return this.mostrarid_empleadoFacturaProveedorServicio;
	}

	public void setMostrarid_empleadoFacturaProveedorServicio(Boolean mostrarid_empleadoFacturaProveedorServicio) {
		this.mostrarid_empleadoFacturaProveedorServicio= mostrarid_empleadoFacturaProveedorServicio;
	}

	public Boolean getActivarid_empleadoFacturaProveedorServicio() {
		return this.activarid_empleadoFacturaProveedorServicio;
	}

	public void setActivarid_empleadoFacturaProveedorServicio(Boolean activarid_empleadoFacturaProveedorServicio) {
		this.activarid_empleadoFacturaProveedorServicio= activarid_empleadoFacturaProveedorServicio;
	}

	public Boolean getCargarid_empleadoFacturaProveedorServicio() {
		return this.cargarid_empleadoFacturaProveedorServicio;
	}

	public void setCargarid_empleadoFacturaProveedorServicio(Boolean cargarid_empleadoFacturaProveedorServicio) {
		this.cargarid_empleadoFacturaProveedorServicio= cargarid_empleadoFacturaProveedorServicio;
	}

	public Border setResaltardetalleFacturaProveedorServicio(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorServicioBeanSwingJInternalFrame facturaproveedorservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorservicioBeanSwingJInternalFrame.jTtoolBarFacturaProveedorServicio.setBorder(borderResaltar);
		
		this.resaltardetalleFacturaProveedorServicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardetalleFacturaProveedorServicio() {
		return this.resaltardetalleFacturaProveedorServicio;
	}

	public void setResaltardetalleFacturaProveedorServicio(Border borderResaltar) {
		this.resaltardetalleFacturaProveedorServicio= borderResaltar;
	}

	public Boolean getMostrardetalleFacturaProveedorServicio() {
		return this.mostrardetalleFacturaProveedorServicio;
	}

	public void setMostrardetalleFacturaProveedorServicio(Boolean mostrardetalleFacturaProveedorServicio) {
		this.mostrardetalleFacturaProveedorServicio= mostrardetalleFacturaProveedorServicio;
	}

	public Boolean getActivardetalleFacturaProveedorServicio() {
		return this.activardetalleFacturaProveedorServicio;
	}

	public void setActivardetalleFacturaProveedorServicio(Boolean activardetalleFacturaProveedorServicio) {
		this.activardetalleFacturaProveedorServicio= activardetalleFacturaProveedorServicio;
	}

	public Border setResaltarnumero_retencionFacturaProveedorServicio(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorServicioBeanSwingJInternalFrame facturaproveedorservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorservicioBeanSwingJInternalFrame.jTtoolBarFacturaProveedorServicio.setBorder(borderResaltar);
		
		this.resaltarnumero_retencionFacturaProveedorServicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_retencionFacturaProveedorServicio() {
		return this.resaltarnumero_retencionFacturaProveedorServicio;
	}

	public void setResaltarnumero_retencionFacturaProveedorServicio(Border borderResaltar) {
		this.resaltarnumero_retencionFacturaProveedorServicio= borderResaltar;
	}

	public Boolean getMostrarnumero_retencionFacturaProveedorServicio() {
		return this.mostrarnumero_retencionFacturaProveedorServicio;
	}

	public void setMostrarnumero_retencionFacturaProveedorServicio(Boolean mostrarnumero_retencionFacturaProveedorServicio) {
		this.mostrarnumero_retencionFacturaProveedorServicio= mostrarnumero_retencionFacturaProveedorServicio;
	}

	public Boolean getActivarnumero_retencionFacturaProveedorServicio() {
		return this.activarnumero_retencionFacturaProveedorServicio;
	}

	public void setActivarnumero_retencionFacturaProveedorServicio(Boolean activarnumero_retencionFacturaProveedorServicio) {
		this.activarnumero_retencionFacturaProveedorServicio= activarnumero_retencionFacturaProveedorServicio;
	}

	public Border setResaltarnumero_autorizacionFacturaProveedorServicio(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorServicioBeanSwingJInternalFrame facturaproveedorservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorservicioBeanSwingJInternalFrame.jTtoolBarFacturaProveedorServicio.setBorder(borderResaltar);
		
		this.resaltarnumero_autorizacionFacturaProveedorServicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_autorizacionFacturaProveedorServicio() {
		return this.resaltarnumero_autorizacionFacturaProveedorServicio;
	}

	public void setResaltarnumero_autorizacionFacturaProveedorServicio(Border borderResaltar) {
		this.resaltarnumero_autorizacionFacturaProveedorServicio= borderResaltar;
	}

	public Boolean getMostrarnumero_autorizacionFacturaProveedorServicio() {
		return this.mostrarnumero_autorizacionFacturaProveedorServicio;
	}

	public void setMostrarnumero_autorizacionFacturaProveedorServicio(Boolean mostrarnumero_autorizacionFacturaProveedorServicio) {
		this.mostrarnumero_autorizacionFacturaProveedorServicio= mostrarnumero_autorizacionFacturaProveedorServicio;
	}

	public Boolean getActivarnumero_autorizacionFacturaProveedorServicio() {
		return this.activarnumero_autorizacionFacturaProveedorServicio;
	}

	public void setActivarnumero_autorizacionFacturaProveedorServicio(Boolean activarnumero_autorizacionFacturaProveedorServicio) {
		this.activarnumero_autorizacionFacturaProveedorServicio= activarnumero_autorizacionFacturaProveedorServicio;
	}

	public Border setResaltarnumero_serieFacturaProveedorServicio(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorServicioBeanSwingJInternalFrame facturaproveedorservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorservicioBeanSwingJInternalFrame.jTtoolBarFacturaProveedorServicio.setBorder(borderResaltar);
		
		this.resaltarnumero_serieFacturaProveedorServicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_serieFacturaProveedorServicio() {
		return this.resaltarnumero_serieFacturaProveedorServicio;
	}

	public void setResaltarnumero_serieFacturaProveedorServicio(Border borderResaltar) {
		this.resaltarnumero_serieFacturaProveedorServicio= borderResaltar;
	}

	public Boolean getMostrarnumero_serieFacturaProveedorServicio() {
		return this.mostrarnumero_serieFacturaProveedorServicio;
	}

	public void setMostrarnumero_serieFacturaProveedorServicio(Boolean mostrarnumero_serieFacturaProveedorServicio) {
		this.mostrarnumero_serieFacturaProveedorServicio= mostrarnumero_serieFacturaProveedorServicio;
	}

	public Boolean getActivarnumero_serieFacturaProveedorServicio() {
		return this.activarnumero_serieFacturaProveedorServicio;
	}

	public void setActivarnumero_serieFacturaProveedorServicio(Boolean activarnumero_serieFacturaProveedorServicio) {
		this.activarnumero_serieFacturaProveedorServicio= activarnumero_serieFacturaProveedorServicio;
	}

	public Border setResaltarid_tipo_tributarioFacturaProveedorServicio(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorServicioBeanSwingJInternalFrame facturaproveedorservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorservicioBeanSwingJInternalFrame.jTtoolBarFacturaProveedorServicio.setBorder(borderResaltar);
		
		this.resaltarid_tipo_tributarioFacturaProveedorServicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_tributarioFacturaProveedorServicio() {
		return this.resaltarid_tipo_tributarioFacturaProveedorServicio;
	}

	public void setResaltarid_tipo_tributarioFacturaProveedorServicio(Border borderResaltar) {
		this.resaltarid_tipo_tributarioFacturaProveedorServicio= borderResaltar;
	}

	public Boolean getMostrarid_tipo_tributarioFacturaProveedorServicio() {
		return this.mostrarid_tipo_tributarioFacturaProveedorServicio;
	}

	public void setMostrarid_tipo_tributarioFacturaProveedorServicio(Boolean mostrarid_tipo_tributarioFacturaProveedorServicio) {
		this.mostrarid_tipo_tributarioFacturaProveedorServicio= mostrarid_tipo_tributarioFacturaProveedorServicio;
	}

	public Boolean getActivarid_tipo_tributarioFacturaProveedorServicio() {
		return this.activarid_tipo_tributarioFacturaProveedorServicio;
	}

	public void setActivarid_tipo_tributarioFacturaProveedorServicio(Boolean activarid_tipo_tributarioFacturaProveedorServicio) {
		this.activarid_tipo_tributarioFacturaProveedorServicio= activarid_tipo_tributarioFacturaProveedorServicio;
	}

	public Boolean getCargarid_tipo_tributarioFacturaProveedorServicio() {
		return this.cargarid_tipo_tributarioFacturaProveedorServicio;
	}

	public void setCargarid_tipo_tributarioFacturaProveedorServicio(Boolean cargarid_tipo_tributarioFacturaProveedorServicio) {
		this.cargarid_tipo_tributarioFacturaProveedorServicio= cargarid_tipo_tributarioFacturaProveedorServicio;
	}

	public Border setResaltarfecha_validezFacturaProveedorServicio(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorServicioBeanSwingJInternalFrame facturaproveedorservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorservicioBeanSwingJInternalFrame.jTtoolBarFacturaProveedorServicio.setBorder(borderResaltar);
		
		this.resaltarfecha_validezFacturaProveedorServicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_validezFacturaProveedorServicio() {
		return this.resaltarfecha_validezFacturaProveedorServicio;
	}

	public void setResaltarfecha_validezFacturaProveedorServicio(Border borderResaltar) {
		this.resaltarfecha_validezFacturaProveedorServicio= borderResaltar;
	}

	public Boolean getMostrarfecha_validezFacturaProveedorServicio() {
		return this.mostrarfecha_validezFacturaProveedorServicio;
	}

	public void setMostrarfecha_validezFacturaProveedorServicio(Boolean mostrarfecha_validezFacturaProveedorServicio) {
		this.mostrarfecha_validezFacturaProveedorServicio= mostrarfecha_validezFacturaProveedorServicio;
	}

	public Boolean getActivarfecha_validezFacturaProveedorServicio() {
		return this.activarfecha_validezFacturaProveedorServicio;
	}

	public void setActivarfecha_validezFacturaProveedorServicio(Boolean activarfecha_validezFacturaProveedorServicio) {
		this.activarfecha_validezFacturaProveedorServicio= activarfecha_validezFacturaProveedorServicio;
	}

	public Border setResaltaranexo_factura_inicioFacturaProveedorServicio(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorServicioBeanSwingJInternalFrame facturaproveedorservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorservicioBeanSwingJInternalFrame.jTtoolBarFacturaProveedorServicio.setBorder(borderResaltar);
		
		this.resaltaranexo_factura_inicioFacturaProveedorServicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaranexo_factura_inicioFacturaProveedorServicio() {
		return this.resaltaranexo_factura_inicioFacturaProveedorServicio;
	}

	public void setResaltaranexo_factura_inicioFacturaProveedorServicio(Border borderResaltar) {
		this.resaltaranexo_factura_inicioFacturaProveedorServicio= borderResaltar;
	}

	public Boolean getMostraranexo_factura_inicioFacturaProveedorServicio() {
		return this.mostraranexo_factura_inicioFacturaProveedorServicio;
	}

	public void setMostraranexo_factura_inicioFacturaProveedorServicio(Boolean mostraranexo_factura_inicioFacturaProveedorServicio) {
		this.mostraranexo_factura_inicioFacturaProveedorServicio= mostraranexo_factura_inicioFacturaProveedorServicio;
	}

	public Boolean getActivaranexo_factura_inicioFacturaProveedorServicio() {
		return this.activaranexo_factura_inicioFacturaProveedorServicio;
	}

	public void setActivaranexo_factura_inicioFacturaProveedorServicio(Boolean activaranexo_factura_inicioFacturaProveedorServicio) {
		this.activaranexo_factura_inicioFacturaProveedorServicio= activaranexo_factura_inicioFacturaProveedorServicio;
	}

	public Border setResaltaranexo_factura_finFacturaProveedorServicio(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorServicioBeanSwingJInternalFrame facturaproveedorservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorservicioBeanSwingJInternalFrame.jTtoolBarFacturaProveedorServicio.setBorder(borderResaltar);
		
		this.resaltaranexo_factura_finFacturaProveedorServicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaranexo_factura_finFacturaProveedorServicio() {
		return this.resaltaranexo_factura_finFacturaProveedorServicio;
	}

	public void setResaltaranexo_factura_finFacturaProveedorServicio(Border borderResaltar) {
		this.resaltaranexo_factura_finFacturaProveedorServicio= borderResaltar;
	}

	public Boolean getMostraranexo_factura_finFacturaProveedorServicio() {
		return this.mostraranexo_factura_finFacturaProveedorServicio;
	}

	public void setMostraranexo_factura_finFacturaProveedorServicio(Boolean mostraranexo_factura_finFacturaProveedorServicio) {
		this.mostraranexo_factura_finFacturaProveedorServicio= mostraranexo_factura_finFacturaProveedorServicio;
	}

	public Boolean getActivaranexo_factura_finFacturaProveedorServicio() {
		return this.activaranexo_factura_finFacturaProveedorServicio;
	}

	public void setActivaranexo_factura_finFacturaProveedorServicio(Boolean activaranexo_factura_finFacturaProveedorServicio) {
		this.activaranexo_factura_finFacturaProveedorServicio= activaranexo_factura_finFacturaProveedorServicio;
	}

	public Border setResaltarid_monedaFacturaProveedorServicio(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorServicioBeanSwingJInternalFrame facturaproveedorservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorservicioBeanSwingJInternalFrame.jTtoolBarFacturaProveedorServicio.setBorder(borderResaltar);
		
		this.resaltarid_monedaFacturaProveedorServicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_monedaFacturaProveedorServicio() {
		return this.resaltarid_monedaFacturaProveedorServicio;
	}

	public void setResaltarid_monedaFacturaProveedorServicio(Border borderResaltar) {
		this.resaltarid_monedaFacturaProveedorServicio= borderResaltar;
	}

	public Boolean getMostrarid_monedaFacturaProveedorServicio() {
		return this.mostrarid_monedaFacturaProveedorServicio;
	}

	public void setMostrarid_monedaFacturaProveedorServicio(Boolean mostrarid_monedaFacturaProveedorServicio) {
		this.mostrarid_monedaFacturaProveedorServicio= mostrarid_monedaFacturaProveedorServicio;
	}

	public Boolean getActivarid_monedaFacturaProveedorServicio() {
		return this.activarid_monedaFacturaProveedorServicio;
	}

	public void setActivarid_monedaFacturaProveedorServicio(Boolean activarid_monedaFacturaProveedorServicio) {
		this.activarid_monedaFacturaProveedorServicio= activarid_monedaFacturaProveedorServicio;
	}

	public Boolean getCargarid_monedaFacturaProveedorServicio() {
		return this.cargarid_monedaFacturaProveedorServicio;
	}

	public void setCargarid_monedaFacturaProveedorServicio(Boolean cargarid_monedaFacturaProveedorServicio) {
		this.cargarid_monedaFacturaProveedorServicio= cargarid_monedaFacturaProveedorServicio;
	}

	public Border setResaltarvalor_servicios0FacturaProveedorServicio(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorServicioBeanSwingJInternalFrame facturaproveedorservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorservicioBeanSwingJInternalFrame.jTtoolBarFacturaProveedorServicio.setBorder(borderResaltar);
		
		this.resaltarvalor_servicios0FacturaProveedorServicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_servicios0FacturaProveedorServicio() {
		return this.resaltarvalor_servicios0FacturaProveedorServicio;
	}

	public void setResaltarvalor_servicios0FacturaProveedorServicio(Border borderResaltar) {
		this.resaltarvalor_servicios0FacturaProveedorServicio= borderResaltar;
	}

	public Boolean getMostrarvalor_servicios0FacturaProveedorServicio() {
		return this.mostrarvalor_servicios0FacturaProveedorServicio;
	}

	public void setMostrarvalor_servicios0FacturaProveedorServicio(Boolean mostrarvalor_servicios0FacturaProveedorServicio) {
		this.mostrarvalor_servicios0FacturaProveedorServicio= mostrarvalor_servicios0FacturaProveedorServicio;
	}

	public Boolean getActivarvalor_servicios0FacturaProveedorServicio() {
		return this.activarvalor_servicios0FacturaProveedorServicio;
	}

	public void setActivarvalor_servicios0FacturaProveedorServicio(Boolean activarvalor_servicios0FacturaProveedorServicio) {
		this.activarvalor_servicios0FacturaProveedorServicio= activarvalor_servicios0FacturaProveedorServicio;
	}

	public Border setResaltartotal_ivaFacturaProveedorServicio(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorServicioBeanSwingJInternalFrame facturaproveedorservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorservicioBeanSwingJInternalFrame.jTtoolBarFacturaProveedorServicio.setBorder(borderResaltar);
		
		this.resaltartotal_ivaFacturaProveedorServicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_ivaFacturaProveedorServicio() {
		return this.resaltartotal_ivaFacturaProveedorServicio;
	}

	public void setResaltartotal_ivaFacturaProveedorServicio(Border borderResaltar) {
		this.resaltartotal_ivaFacturaProveedorServicio= borderResaltar;
	}

	public Boolean getMostrartotal_ivaFacturaProveedorServicio() {
		return this.mostrartotal_ivaFacturaProveedorServicio;
	}

	public void setMostrartotal_ivaFacturaProveedorServicio(Boolean mostrartotal_ivaFacturaProveedorServicio) {
		this.mostrartotal_ivaFacturaProveedorServicio= mostrartotal_ivaFacturaProveedorServicio;
	}

	public Boolean getActivartotal_ivaFacturaProveedorServicio() {
		return this.activartotal_ivaFacturaProveedorServicio;
	}

	public void setActivartotal_ivaFacturaProveedorServicio(Boolean activartotal_ivaFacturaProveedorServicio) {
		this.activartotal_ivaFacturaProveedorServicio= activartotal_ivaFacturaProveedorServicio;
	}

	public Border setResaltariva_porcentajeFacturaProveedorServicio(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorServicioBeanSwingJInternalFrame facturaproveedorservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorservicioBeanSwingJInternalFrame.jTtoolBarFacturaProveedorServicio.setBorder(borderResaltar);
		
		this.resaltariva_porcentajeFacturaProveedorServicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltariva_porcentajeFacturaProveedorServicio() {
		return this.resaltariva_porcentajeFacturaProveedorServicio;
	}

	public void setResaltariva_porcentajeFacturaProveedorServicio(Border borderResaltar) {
		this.resaltariva_porcentajeFacturaProveedorServicio= borderResaltar;
	}

	public Boolean getMostrariva_porcentajeFacturaProveedorServicio() {
		return this.mostrariva_porcentajeFacturaProveedorServicio;
	}

	public void setMostrariva_porcentajeFacturaProveedorServicio(Boolean mostrariva_porcentajeFacturaProveedorServicio) {
		this.mostrariva_porcentajeFacturaProveedorServicio= mostrariva_porcentajeFacturaProveedorServicio;
	}

	public Boolean getActivariva_porcentajeFacturaProveedorServicio() {
		return this.activariva_porcentajeFacturaProveedorServicio;
	}

	public void setActivariva_porcentajeFacturaProveedorServicio(Boolean activariva_porcentajeFacturaProveedorServicio) {
		this.activariva_porcentajeFacturaProveedorServicio= activariva_porcentajeFacturaProveedorServicio;
	}

	public Border setResaltartotalFacturaProveedorServicio(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorServicioBeanSwingJInternalFrame facturaproveedorservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorservicioBeanSwingJInternalFrame.jTtoolBarFacturaProveedorServicio.setBorder(borderResaltar);
		
		this.resaltartotalFacturaProveedorServicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalFacturaProveedorServicio() {
		return this.resaltartotalFacturaProveedorServicio;
	}

	public void setResaltartotalFacturaProveedorServicio(Border borderResaltar) {
		this.resaltartotalFacturaProveedorServicio= borderResaltar;
	}

	public Boolean getMostrartotalFacturaProveedorServicio() {
		return this.mostrartotalFacturaProveedorServicio;
	}

	public void setMostrartotalFacturaProveedorServicio(Boolean mostrartotalFacturaProveedorServicio) {
		this.mostrartotalFacturaProveedorServicio= mostrartotalFacturaProveedorServicio;
	}

	public Boolean getActivartotalFacturaProveedorServicio() {
		return this.activartotalFacturaProveedorServicio;
	}

	public void setActivartotalFacturaProveedorServicio(Boolean activartotalFacturaProveedorServicio) {
		this.activartotalFacturaProveedorServicio= activartotalFacturaProveedorServicio;
	}

	public Border setResaltarnumero_mayorFacturaProveedorServicio(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorServicioBeanSwingJInternalFrame facturaproveedorservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorservicioBeanSwingJInternalFrame.jTtoolBarFacturaProveedorServicio.setBorder(borderResaltar);
		
		this.resaltarnumero_mayorFacturaProveedorServicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_mayorFacturaProveedorServicio() {
		return this.resaltarnumero_mayorFacturaProveedorServicio;
	}

	public void setResaltarnumero_mayorFacturaProveedorServicio(Border borderResaltar) {
		this.resaltarnumero_mayorFacturaProveedorServicio= borderResaltar;
	}

	public Boolean getMostrarnumero_mayorFacturaProveedorServicio() {
		return this.mostrarnumero_mayorFacturaProveedorServicio;
	}

	public void setMostrarnumero_mayorFacturaProveedorServicio(Boolean mostrarnumero_mayorFacturaProveedorServicio) {
		this.mostrarnumero_mayorFacturaProveedorServicio= mostrarnumero_mayorFacturaProveedorServicio;
	}

	public Boolean getActivarnumero_mayorFacturaProveedorServicio() {
		return this.activarnumero_mayorFacturaProveedorServicio;
	}

	public void setActivarnumero_mayorFacturaProveedorServicio(Boolean activarnumero_mayorFacturaProveedorServicio) {
		this.activarnumero_mayorFacturaProveedorServicio= activarnumero_mayorFacturaProveedorServicio;
	}

	public Border setResaltarcodigo_asientoFacturaProveedorServicio(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorServicioBeanSwingJInternalFrame facturaproveedorservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorservicioBeanSwingJInternalFrame.jTtoolBarFacturaProveedorServicio.setBorder(borderResaltar);
		
		this.resaltarcodigo_asientoFacturaProveedorServicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_asientoFacturaProveedorServicio() {
		return this.resaltarcodigo_asientoFacturaProveedorServicio;
	}

	public void setResaltarcodigo_asientoFacturaProveedorServicio(Border borderResaltar) {
		this.resaltarcodigo_asientoFacturaProveedorServicio= borderResaltar;
	}

	public Boolean getMostrarcodigo_asientoFacturaProveedorServicio() {
		return this.mostrarcodigo_asientoFacturaProveedorServicio;
	}

	public void setMostrarcodigo_asientoFacturaProveedorServicio(Boolean mostrarcodigo_asientoFacturaProveedorServicio) {
		this.mostrarcodigo_asientoFacturaProveedorServicio= mostrarcodigo_asientoFacturaProveedorServicio;
	}

	public Boolean getActivarcodigo_asientoFacturaProveedorServicio() {
		return this.activarcodigo_asientoFacturaProveedorServicio;
	}

	public void setActivarcodigo_asientoFacturaProveedorServicio(Boolean activarcodigo_asientoFacturaProveedorServicio) {
		this.activarcodigo_asientoFacturaProveedorServicio= activarcodigo_asientoFacturaProveedorServicio;
	}

	public Border setResaltarid_tipo_retencion_fuente1FacturaProveedorServicio(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorServicioBeanSwingJInternalFrame facturaproveedorservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorservicioBeanSwingJInternalFrame.jTtoolBarFacturaProveedorServicio.setBorder(borderResaltar);
		
		this.resaltarid_tipo_retencion_fuente1FacturaProveedorServicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_retencion_fuente1FacturaProveedorServicio() {
		return this.resaltarid_tipo_retencion_fuente1FacturaProveedorServicio;
	}

	public void setResaltarid_tipo_retencion_fuente1FacturaProveedorServicio(Border borderResaltar) {
		this.resaltarid_tipo_retencion_fuente1FacturaProveedorServicio= borderResaltar;
	}

	public Boolean getMostrarid_tipo_retencion_fuente1FacturaProveedorServicio() {
		return this.mostrarid_tipo_retencion_fuente1FacturaProveedorServicio;
	}

	public void setMostrarid_tipo_retencion_fuente1FacturaProveedorServicio(Boolean mostrarid_tipo_retencion_fuente1FacturaProveedorServicio) {
		this.mostrarid_tipo_retencion_fuente1FacturaProveedorServicio= mostrarid_tipo_retencion_fuente1FacturaProveedorServicio;
	}

	public Boolean getActivarid_tipo_retencion_fuente1FacturaProveedorServicio() {
		return this.activarid_tipo_retencion_fuente1FacturaProveedorServicio;
	}

	public void setActivarid_tipo_retencion_fuente1FacturaProveedorServicio(Boolean activarid_tipo_retencion_fuente1FacturaProveedorServicio) {
		this.activarid_tipo_retencion_fuente1FacturaProveedorServicio= activarid_tipo_retencion_fuente1FacturaProveedorServicio;
	}

	public Boolean getCargarid_tipo_retencion_fuente1FacturaProveedorServicio() {
		return this.cargarid_tipo_retencion_fuente1FacturaProveedorServicio;
	}

	public void setCargarid_tipo_retencion_fuente1FacturaProveedorServicio(Boolean cargarid_tipo_retencion_fuente1FacturaProveedorServicio) {
		this.cargarid_tipo_retencion_fuente1FacturaProveedorServicio= cargarid_tipo_retencion_fuente1FacturaProveedorServicio;
	}

	public Border setResaltarid_tipo_retencion_iva1FacturaProveedorServicio(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorServicioBeanSwingJInternalFrame facturaproveedorservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorservicioBeanSwingJInternalFrame.jTtoolBarFacturaProveedorServicio.setBorder(borderResaltar);
		
		this.resaltarid_tipo_retencion_iva1FacturaProveedorServicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_retencion_iva1FacturaProveedorServicio() {
		return this.resaltarid_tipo_retencion_iva1FacturaProveedorServicio;
	}

	public void setResaltarid_tipo_retencion_iva1FacturaProveedorServicio(Border borderResaltar) {
		this.resaltarid_tipo_retencion_iva1FacturaProveedorServicio= borderResaltar;
	}

	public Boolean getMostrarid_tipo_retencion_iva1FacturaProveedorServicio() {
		return this.mostrarid_tipo_retencion_iva1FacturaProveedorServicio;
	}

	public void setMostrarid_tipo_retencion_iva1FacturaProveedorServicio(Boolean mostrarid_tipo_retencion_iva1FacturaProveedorServicio) {
		this.mostrarid_tipo_retencion_iva1FacturaProveedorServicio= mostrarid_tipo_retencion_iva1FacturaProveedorServicio;
	}

	public Boolean getActivarid_tipo_retencion_iva1FacturaProveedorServicio() {
		return this.activarid_tipo_retencion_iva1FacturaProveedorServicio;
	}

	public void setActivarid_tipo_retencion_iva1FacturaProveedorServicio(Boolean activarid_tipo_retencion_iva1FacturaProveedorServicio) {
		this.activarid_tipo_retencion_iva1FacturaProveedorServicio= activarid_tipo_retencion_iva1FacturaProveedorServicio;
	}

	public Boolean getCargarid_tipo_retencion_iva1FacturaProveedorServicio() {
		return this.cargarid_tipo_retencion_iva1FacturaProveedorServicio;
	}

	public void setCargarid_tipo_retencion_iva1FacturaProveedorServicio(Boolean cargarid_tipo_retencion_iva1FacturaProveedorServicio) {
		this.cargarid_tipo_retencion_iva1FacturaProveedorServicio= cargarid_tipo_retencion_iva1FacturaProveedorServicio;
	}

	public Border setResaltaranexo_numero_autorizacionFacturaProveedorServicio(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorServicioBeanSwingJInternalFrame facturaproveedorservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorservicioBeanSwingJInternalFrame.jTtoolBarFacturaProveedorServicio.setBorder(borderResaltar);
		
		this.resaltaranexo_numero_autorizacionFacturaProveedorServicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaranexo_numero_autorizacionFacturaProveedorServicio() {
		return this.resaltaranexo_numero_autorizacionFacturaProveedorServicio;
	}

	public void setResaltaranexo_numero_autorizacionFacturaProveedorServicio(Border borderResaltar) {
		this.resaltaranexo_numero_autorizacionFacturaProveedorServicio= borderResaltar;
	}

	public Boolean getMostraranexo_numero_autorizacionFacturaProveedorServicio() {
		return this.mostraranexo_numero_autorizacionFacturaProveedorServicio;
	}

	public void setMostraranexo_numero_autorizacionFacturaProveedorServicio(Boolean mostraranexo_numero_autorizacionFacturaProveedorServicio) {
		this.mostraranexo_numero_autorizacionFacturaProveedorServicio= mostraranexo_numero_autorizacionFacturaProveedorServicio;
	}

	public Boolean getActivaranexo_numero_autorizacionFacturaProveedorServicio() {
		return this.activaranexo_numero_autorizacionFacturaProveedorServicio;
	}

	public void setActivaranexo_numero_autorizacionFacturaProveedorServicio(Boolean activaranexo_numero_autorizacionFacturaProveedorServicio) {
		this.activaranexo_numero_autorizacionFacturaProveedorServicio= activaranexo_numero_autorizacionFacturaProveedorServicio;
	}

	public Border setResaltaranexo_numeso_serieFacturaProveedorServicio(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorServicioBeanSwingJInternalFrame facturaproveedorservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorservicioBeanSwingJInternalFrame.jTtoolBarFacturaProveedorServicio.setBorder(borderResaltar);
		
		this.resaltaranexo_numeso_serieFacturaProveedorServicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaranexo_numeso_serieFacturaProveedorServicio() {
		return this.resaltaranexo_numeso_serieFacturaProveedorServicio;
	}

	public void setResaltaranexo_numeso_serieFacturaProveedorServicio(Border borderResaltar) {
		this.resaltaranexo_numeso_serieFacturaProveedorServicio= borderResaltar;
	}

	public Boolean getMostraranexo_numeso_serieFacturaProveedorServicio() {
		return this.mostraranexo_numeso_serieFacturaProveedorServicio;
	}

	public void setMostraranexo_numeso_serieFacturaProveedorServicio(Boolean mostraranexo_numeso_serieFacturaProveedorServicio) {
		this.mostraranexo_numeso_serieFacturaProveedorServicio= mostraranexo_numeso_serieFacturaProveedorServicio;
	}

	public Boolean getActivaranexo_numeso_serieFacturaProveedorServicio() {
		return this.activaranexo_numeso_serieFacturaProveedorServicio;
	}

	public void setActivaranexo_numeso_serieFacturaProveedorServicio(Boolean activaranexo_numeso_serieFacturaProveedorServicio) {
		this.activaranexo_numeso_serieFacturaProveedorServicio= activaranexo_numeso_serieFacturaProveedorServicio;
	}

	public Border setResaltaranexo_fecha_validezFacturaProveedorServicio(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorServicioBeanSwingJInternalFrame facturaproveedorservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorservicioBeanSwingJInternalFrame.jTtoolBarFacturaProveedorServicio.setBorder(borderResaltar);
		
		this.resaltaranexo_fecha_validezFacturaProveedorServicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaranexo_fecha_validezFacturaProveedorServicio() {
		return this.resaltaranexo_fecha_validezFacturaProveedorServicio;
	}

	public void setResaltaranexo_fecha_validezFacturaProveedorServicio(Border borderResaltar) {
		this.resaltaranexo_fecha_validezFacturaProveedorServicio= borderResaltar;
	}

	public Boolean getMostraranexo_fecha_validezFacturaProveedorServicio() {
		return this.mostraranexo_fecha_validezFacturaProveedorServicio;
	}

	public void setMostraranexo_fecha_validezFacturaProveedorServicio(Boolean mostraranexo_fecha_validezFacturaProveedorServicio) {
		this.mostraranexo_fecha_validezFacturaProveedorServicio= mostraranexo_fecha_validezFacturaProveedorServicio;
	}

	public Boolean getActivaranexo_fecha_validezFacturaProveedorServicio() {
		return this.activaranexo_fecha_validezFacturaProveedorServicio;
	}

	public void setActivaranexo_fecha_validezFacturaProveedorServicio(Boolean activaranexo_fecha_validezFacturaProveedorServicio) {
		this.activaranexo_fecha_validezFacturaProveedorServicio= activaranexo_fecha_validezFacturaProveedorServicio;
	}

	public Border setResaltarid_cuenta_contable_credito_fiscal_serviciosFacturaProveedorServicio(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorServicioBeanSwingJInternalFrame facturaproveedorservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorservicioBeanSwingJInternalFrame.jTtoolBarFacturaProveedorServicio.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_credito_fiscal_serviciosFacturaProveedorServicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_credito_fiscal_serviciosFacturaProveedorServicio() {
		return this.resaltarid_cuenta_contable_credito_fiscal_serviciosFacturaProveedorServicio;
	}

	public void setResaltarid_cuenta_contable_credito_fiscal_serviciosFacturaProveedorServicio(Border borderResaltar) {
		this.resaltarid_cuenta_contable_credito_fiscal_serviciosFacturaProveedorServicio= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_credito_fiscal_serviciosFacturaProveedorServicio() {
		return this.mostrarid_cuenta_contable_credito_fiscal_serviciosFacturaProveedorServicio;
	}

	public void setMostrarid_cuenta_contable_credito_fiscal_serviciosFacturaProveedorServicio(Boolean mostrarid_cuenta_contable_credito_fiscal_serviciosFacturaProveedorServicio) {
		this.mostrarid_cuenta_contable_credito_fiscal_serviciosFacturaProveedorServicio= mostrarid_cuenta_contable_credito_fiscal_serviciosFacturaProveedorServicio;
	}

	public Boolean getActivarid_cuenta_contable_credito_fiscal_serviciosFacturaProveedorServicio() {
		return this.activarid_cuenta_contable_credito_fiscal_serviciosFacturaProveedorServicio;
	}

	public void setActivarid_cuenta_contable_credito_fiscal_serviciosFacturaProveedorServicio(Boolean activarid_cuenta_contable_credito_fiscal_serviciosFacturaProveedorServicio) {
		this.activarid_cuenta_contable_credito_fiscal_serviciosFacturaProveedorServicio= activarid_cuenta_contable_credito_fiscal_serviciosFacturaProveedorServicio;
	}

	public Boolean getCargarid_cuenta_contable_credito_fiscal_serviciosFacturaProveedorServicio() {
		return this.cargarid_cuenta_contable_credito_fiscal_serviciosFacturaProveedorServicio;
	}

	public void setCargarid_cuenta_contable_credito_fiscal_serviciosFacturaProveedorServicio(Boolean cargarid_cuenta_contable_credito_fiscal_serviciosFacturaProveedorServicio) {
		this.cargarid_cuenta_contable_credito_fiscal_serviciosFacturaProveedorServicio= cargarid_cuenta_contable_credito_fiscal_serviciosFacturaProveedorServicio;
	}

	public Border setResaltardescripcionFacturaProveedorServicio(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorServicioBeanSwingJInternalFrame facturaproveedorservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorservicioBeanSwingJInternalFrame.jTtoolBarFacturaProveedorServicio.setBorder(borderResaltar);
		
		this.resaltardescripcionFacturaProveedorServicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionFacturaProveedorServicio() {
		return this.resaltardescripcionFacturaProveedorServicio;
	}

	public void setResaltardescripcionFacturaProveedorServicio(Border borderResaltar) {
		this.resaltardescripcionFacturaProveedorServicio= borderResaltar;
	}

	public Boolean getMostrardescripcionFacturaProveedorServicio() {
		return this.mostrardescripcionFacturaProveedorServicio;
	}

	public void setMostrardescripcionFacturaProveedorServicio(Boolean mostrardescripcionFacturaProveedorServicio) {
		this.mostrardescripcionFacturaProveedorServicio= mostrardescripcionFacturaProveedorServicio;
	}

	public Boolean getActivardescripcionFacturaProveedorServicio() {
		return this.activardescripcionFacturaProveedorServicio;
	}

	public void setActivardescripcionFacturaProveedorServicio(Boolean activardescripcionFacturaProveedorServicio) {
		this.activardescripcionFacturaProveedorServicio= activardescripcionFacturaProveedorServicio;
	}

	public Border setResaltarid_tipo_movimientoFacturaProveedorServicio(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorServicioBeanSwingJInternalFrame facturaproveedorservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorservicioBeanSwingJInternalFrame.jTtoolBarFacturaProveedorServicio.setBorder(borderResaltar);
		
		this.resaltarid_tipo_movimientoFacturaProveedorServicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_movimientoFacturaProveedorServicio() {
		return this.resaltarid_tipo_movimientoFacturaProveedorServicio;
	}

	public void setResaltarid_tipo_movimientoFacturaProveedorServicio(Border borderResaltar) {
		this.resaltarid_tipo_movimientoFacturaProveedorServicio= borderResaltar;
	}

	public Boolean getMostrarid_tipo_movimientoFacturaProveedorServicio() {
		return this.mostrarid_tipo_movimientoFacturaProveedorServicio;
	}

	public void setMostrarid_tipo_movimientoFacturaProveedorServicio(Boolean mostrarid_tipo_movimientoFacturaProveedorServicio) {
		this.mostrarid_tipo_movimientoFacturaProveedorServicio= mostrarid_tipo_movimientoFacturaProveedorServicio;
	}

	public Boolean getActivarid_tipo_movimientoFacturaProveedorServicio() {
		return this.activarid_tipo_movimientoFacturaProveedorServicio;
	}

	public void setActivarid_tipo_movimientoFacturaProveedorServicio(Boolean activarid_tipo_movimientoFacturaProveedorServicio) {
		this.activarid_tipo_movimientoFacturaProveedorServicio= activarid_tipo_movimientoFacturaProveedorServicio;
	}

	public Boolean getCargarid_tipo_movimientoFacturaProveedorServicio() {
		return this.cargarid_tipo_movimientoFacturaProveedorServicio;
	}

	public void setCargarid_tipo_movimientoFacturaProveedorServicio(Boolean cargarid_tipo_movimientoFacturaProveedorServicio) {
		this.cargarid_tipo_movimientoFacturaProveedorServicio= cargarid_tipo_movimientoFacturaProveedorServicio;
	}

	public Border setResaltarid_tipo_movimiento_moduloFacturaProveedorServicio(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorServicioBeanSwingJInternalFrame facturaproveedorservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorservicioBeanSwingJInternalFrame.jTtoolBarFacturaProveedorServicio.setBorder(borderResaltar);
		
		this.resaltarid_tipo_movimiento_moduloFacturaProveedorServicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_movimiento_moduloFacturaProveedorServicio() {
		return this.resaltarid_tipo_movimiento_moduloFacturaProveedorServicio;
	}

	public void setResaltarid_tipo_movimiento_moduloFacturaProveedorServicio(Border borderResaltar) {
		this.resaltarid_tipo_movimiento_moduloFacturaProveedorServicio= borderResaltar;
	}

	public Boolean getMostrarid_tipo_movimiento_moduloFacturaProveedorServicio() {
		return this.mostrarid_tipo_movimiento_moduloFacturaProveedorServicio;
	}

	public void setMostrarid_tipo_movimiento_moduloFacturaProveedorServicio(Boolean mostrarid_tipo_movimiento_moduloFacturaProveedorServicio) {
		this.mostrarid_tipo_movimiento_moduloFacturaProveedorServicio= mostrarid_tipo_movimiento_moduloFacturaProveedorServicio;
	}

	public Boolean getActivarid_tipo_movimiento_moduloFacturaProveedorServicio() {
		return this.activarid_tipo_movimiento_moduloFacturaProveedorServicio;
	}

	public void setActivarid_tipo_movimiento_moduloFacturaProveedorServicio(Boolean activarid_tipo_movimiento_moduloFacturaProveedorServicio) {
		this.activarid_tipo_movimiento_moduloFacturaProveedorServicio= activarid_tipo_movimiento_moduloFacturaProveedorServicio;
	}

	public Boolean getCargarid_tipo_movimiento_moduloFacturaProveedorServicio() {
		return this.cargarid_tipo_movimiento_moduloFacturaProveedorServicio;
	}

	public void setCargarid_tipo_movimiento_moduloFacturaProveedorServicio(Boolean cargarid_tipo_movimiento_moduloFacturaProveedorServicio) {
		this.cargarid_tipo_movimiento_moduloFacturaProveedorServicio= cargarid_tipo_movimiento_moduloFacturaProveedorServicio;
	}

	public Border setResaltarid_tipo_transaccion_moduloFacturaProveedorServicio(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorServicioBeanSwingJInternalFrame facturaproveedorservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaproveedorservicioBeanSwingJInternalFrame.jTtoolBarFacturaProveedorServicio.setBorder(borderResaltar);
		
		this.resaltarid_tipo_transaccion_moduloFacturaProveedorServicio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_transaccion_moduloFacturaProveedorServicio() {
		return this.resaltarid_tipo_transaccion_moduloFacturaProveedorServicio;
	}

	public void setResaltarid_tipo_transaccion_moduloFacturaProveedorServicio(Border borderResaltar) {
		this.resaltarid_tipo_transaccion_moduloFacturaProveedorServicio= borderResaltar;
	}

	public Boolean getMostrarid_tipo_transaccion_moduloFacturaProveedorServicio() {
		return this.mostrarid_tipo_transaccion_moduloFacturaProveedorServicio;
	}

	public void setMostrarid_tipo_transaccion_moduloFacturaProveedorServicio(Boolean mostrarid_tipo_transaccion_moduloFacturaProveedorServicio) {
		this.mostrarid_tipo_transaccion_moduloFacturaProveedorServicio= mostrarid_tipo_transaccion_moduloFacturaProveedorServicio;
	}

	public Boolean getActivarid_tipo_transaccion_moduloFacturaProveedorServicio() {
		return this.activarid_tipo_transaccion_moduloFacturaProveedorServicio;
	}

	public void setActivarid_tipo_transaccion_moduloFacturaProveedorServicio(Boolean activarid_tipo_transaccion_moduloFacturaProveedorServicio) {
		this.activarid_tipo_transaccion_moduloFacturaProveedorServicio= activarid_tipo_transaccion_moduloFacturaProveedorServicio;
	}

	public Boolean getCargarid_tipo_transaccion_moduloFacturaProveedorServicio() {
		return this.cargarid_tipo_transaccion_moduloFacturaProveedorServicio;
	}

	public void setCargarid_tipo_transaccion_moduloFacturaProveedorServicio(Boolean cargarid_tipo_transaccion_moduloFacturaProveedorServicio) {
		this.cargarid_tipo_transaccion_moduloFacturaProveedorServicio= cargarid_tipo_transaccion_moduloFacturaProveedorServicio;
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
		
		
		this.setMostraridFacturaProveedorServicio(esInicial);
		this.setMostrarid_empresaFacturaProveedorServicio(esInicial);
		this.setMostrarid_sucursalFacturaProveedorServicio(esInicial);
		this.setMostrarid_ejercicioFacturaProveedorServicio(esInicial);
		this.setMostrarid_periodoFacturaProveedorServicio(esInicial);
		this.setMostrarid_anioFacturaProveedorServicio(esInicial);
		this.setMostrarid_mesFacturaProveedorServicio(esInicial);
		this.setMostrarid_moduloFacturaProveedorServicio(esInicial);
		this.setMostrarid_transaccionFacturaProveedorServicio(esInicial);
		this.setMostrarid_facturaFacturaProveedorServicio(esInicial);
		this.setMostrarnumero_facturaFacturaProveedorServicio(esInicial);
		this.setMostrarid_clienteFacturaProveedorServicio(esInicial);
		this.setMostrarrucFacturaProveedorServicio(esInicial);
		this.setMostrarid_tipo_documentoFacturaProveedorServicio(esInicial);
		this.setMostrarplazoFacturaProveedorServicio(esInicial);
		this.setMostrarcon_riseFacturaProveedorServicio(esInicial);
		this.setMostrarfecha_emisionFacturaProveedorServicio(esInicial);
		this.setMostrarfecha_venceFacturaProveedorServicio(esInicial);
		this.setMostrarid_empleado_solicitaFacturaProveedorServicio(esInicial);
		this.setMostrarid_empleadoFacturaProveedorServicio(esInicial);
		this.setMostrardetalleFacturaProveedorServicio(esInicial);
		this.setMostrarnumero_retencionFacturaProveedorServicio(esInicial);
		this.setMostrarnumero_autorizacionFacturaProveedorServicio(esInicial);
		this.setMostrarnumero_serieFacturaProveedorServicio(esInicial);
		this.setMostrarid_tipo_tributarioFacturaProveedorServicio(esInicial);
		this.setMostrarfecha_validezFacturaProveedorServicio(esInicial);
		this.setMostraranexo_factura_inicioFacturaProveedorServicio(esInicial);
		this.setMostraranexo_factura_finFacturaProveedorServicio(esInicial);
		this.setMostrarid_monedaFacturaProveedorServicio(esInicial);
		this.setMostrarvalor_servicios0FacturaProveedorServicio(esInicial);
		this.setMostrartotal_ivaFacturaProveedorServicio(esInicial);
		this.setMostrariva_porcentajeFacturaProveedorServicio(esInicial);
		this.setMostrartotalFacturaProveedorServicio(esInicial);
		this.setMostrarnumero_mayorFacturaProveedorServicio(esInicial);
		this.setMostrarcodigo_asientoFacturaProveedorServicio(esInicial);
		this.setMostrarid_tipo_retencion_fuente1FacturaProveedorServicio(esInicial);
		this.setMostrarid_tipo_retencion_iva1FacturaProveedorServicio(esInicial);
		this.setMostraranexo_numero_autorizacionFacturaProveedorServicio(esInicial);
		this.setMostraranexo_numeso_serieFacturaProveedorServicio(esInicial);
		this.setMostraranexo_fecha_validezFacturaProveedorServicio(esInicial);
		this.setMostrarid_cuenta_contable_credito_fiscal_serviciosFacturaProveedorServicio(esInicial);
		this.setMostrardescripcionFacturaProveedorServicio(esInicial);
		this.setMostrarid_tipo_movimientoFacturaProveedorServicio(esInicial);
		this.setMostrarid_tipo_movimiento_moduloFacturaProveedorServicio(esInicial);
		this.setMostrarid_tipo_transaccion_moduloFacturaProveedorServicio(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.ID)) {
				this.setMostraridFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.IDMES)) {
				this.setMostrarid_mesFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.IDMODULO)) {
				this.setMostrarid_moduloFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.IDTRANSACCION)) {
				this.setMostrarid_transaccionFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.IDFACTURA)) {
				this.setMostrarid_facturaFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.NUMEROFACTURA)) {
				this.setMostrarnumero_facturaFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.RUC)) {
				this.setMostrarrucFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.IDTIPODOCUMENTO)) {
				this.setMostrarid_tipo_documentoFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.PLAZO)) {
				this.setMostrarplazoFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.CONRISE)) {
				this.setMostrarcon_riseFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.FECHAVENCE)) {
				this.setMostrarfecha_venceFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.IDEMPLEADOSOLICITA)) {
				this.setMostrarid_empleado_solicitaFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.DETALLE)) {
				this.setMostrardetalleFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.NUMERORETENCION)) {
				this.setMostrarnumero_retencionFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.NUMEROAUTORIZACION)) {
				this.setMostrarnumero_autorizacionFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.NUMEROSERIE)) {
				this.setMostrarnumero_serieFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.IDTIPOTRIBUTARIO)) {
				this.setMostrarid_tipo_tributarioFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.FECHAVALIDEZ)) {
				this.setMostrarfecha_validezFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.ANEXOFACTURAINICIO)) {
				this.setMostraranexo_factura_inicioFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.ANEXOFACTURAFIN)) {
				this.setMostraranexo_factura_finFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.IDMONEDA)) {
				this.setMostrarid_monedaFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.VALORSERVICIOS0)) {
				this.setMostrarvalor_servicios0FacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.TOTALIVA)) {
				this.setMostrartotal_ivaFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.IVAPORCENTAJE)) {
				this.setMostrariva_porcentajeFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.TOTAL)) {
				this.setMostrartotalFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.NUMEROMAYOR)) {
				this.setMostrarnumero_mayorFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.CODIGOASIENTO)) {
				this.setMostrarcodigo_asientoFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.IDTIPORETENCIONFUENTE1)) {
				this.setMostrarid_tipo_retencion_fuente1FacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.IDTIPORETENCIONIVA1)) {
				this.setMostrarid_tipo_retencion_iva1FacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.ANEXONUMEROAUTORIZACION)) {
				this.setMostraranexo_numero_autorizacionFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.ANEXONUMESOSERIE)) {
				this.setMostraranexo_numeso_serieFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.ANEXOFECHAVALIDEZ)) {
				this.setMostraranexo_fecha_validezFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.IDCUENTACONTABLECREDITOFISCALSERVICIOS)) {
				this.setMostrarid_cuenta_contable_credito_fiscal_serviciosFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.IDTIPOMOVIMIENTO)) {
				this.setMostrarid_tipo_movimientoFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.IDTIPOMOVIMIENTOMODULO)) {
				this.setMostrarid_tipo_movimiento_moduloFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {
				this.setMostrarid_tipo_transaccion_moduloFacturaProveedorServicio(esAsigna);
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
		
		
		this.setActivaridFacturaProveedorServicio(esInicial);
		this.setActivarid_empresaFacturaProveedorServicio(esInicial);
		this.setActivarid_sucursalFacturaProveedorServicio(esInicial);
		this.setActivarid_ejercicioFacturaProveedorServicio(esInicial);
		this.setActivarid_periodoFacturaProveedorServicio(esInicial);
		this.setActivarid_anioFacturaProveedorServicio(esInicial);
		this.setActivarid_mesFacturaProveedorServicio(esInicial);
		this.setActivarid_moduloFacturaProveedorServicio(esInicial);
		this.setActivarid_transaccionFacturaProveedorServicio(esInicial);
		this.setActivarid_facturaFacturaProveedorServicio(esInicial);
		this.setActivarnumero_facturaFacturaProveedorServicio(esInicial);
		this.setActivarid_clienteFacturaProveedorServicio(esInicial);
		this.setActivarrucFacturaProveedorServicio(esInicial);
		this.setActivarid_tipo_documentoFacturaProveedorServicio(esInicial);
		this.setActivarplazoFacturaProveedorServicio(esInicial);
		this.setActivarcon_riseFacturaProveedorServicio(esInicial);
		this.setActivarfecha_emisionFacturaProveedorServicio(esInicial);
		this.setActivarfecha_venceFacturaProveedorServicio(esInicial);
		this.setActivarid_empleado_solicitaFacturaProveedorServicio(esInicial);
		this.setActivarid_empleadoFacturaProveedorServicio(esInicial);
		this.setActivardetalleFacturaProveedorServicio(esInicial);
		this.setActivarnumero_retencionFacturaProveedorServicio(esInicial);
		this.setActivarnumero_autorizacionFacturaProveedorServicio(esInicial);
		this.setActivarnumero_serieFacturaProveedorServicio(esInicial);
		this.setActivarid_tipo_tributarioFacturaProveedorServicio(esInicial);
		this.setActivarfecha_validezFacturaProveedorServicio(esInicial);
		this.setActivaranexo_factura_inicioFacturaProveedorServicio(esInicial);
		this.setActivaranexo_factura_finFacturaProveedorServicio(esInicial);
		this.setActivarid_monedaFacturaProveedorServicio(esInicial);
		this.setActivarvalor_servicios0FacturaProveedorServicio(esInicial);
		this.setActivartotal_ivaFacturaProveedorServicio(esInicial);
		this.setActivariva_porcentajeFacturaProveedorServicio(esInicial);
		this.setActivartotalFacturaProveedorServicio(esInicial);
		this.setActivarnumero_mayorFacturaProveedorServicio(esInicial);
		this.setActivarcodigo_asientoFacturaProveedorServicio(esInicial);
		this.setActivarid_tipo_retencion_fuente1FacturaProveedorServicio(esInicial);
		this.setActivarid_tipo_retencion_iva1FacturaProveedorServicio(esInicial);
		this.setActivaranexo_numero_autorizacionFacturaProveedorServicio(esInicial);
		this.setActivaranexo_numeso_serieFacturaProveedorServicio(esInicial);
		this.setActivaranexo_fecha_validezFacturaProveedorServicio(esInicial);
		this.setActivarid_cuenta_contable_credito_fiscal_serviciosFacturaProveedorServicio(esInicial);
		this.setActivardescripcionFacturaProveedorServicio(esInicial);
		this.setActivarid_tipo_movimientoFacturaProveedorServicio(esInicial);
		this.setActivarid_tipo_movimiento_moduloFacturaProveedorServicio(esInicial);
		this.setActivarid_tipo_transaccion_moduloFacturaProveedorServicio(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.ID)) {
				this.setActivaridFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.IDANIO)) {
				this.setActivarid_anioFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.IDMES)) {
				this.setActivarid_mesFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.IDMODULO)) {
				this.setActivarid_moduloFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.IDTRANSACCION)) {
				this.setActivarid_transaccionFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.IDFACTURA)) {
				this.setActivarid_facturaFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.NUMEROFACTURA)) {
				this.setActivarnumero_facturaFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.RUC)) {
				this.setActivarrucFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.IDTIPODOCUMENTO)) {
				this.setActivarid_tipo_documentoFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.PLAZO)) {
				this.setActivarplazoFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.CONRISE)) {
				this.setActivarcon_riseFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.FECHAVENCE)) {
				this.setActivarfecha_venceFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.IDEMPLEADOSOLICITA)) {
				this.setActivarid_empleado_solicitaFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.DETALLE)) {
				this.setActivardetalleFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.NUMERORETENCION)) {
				this.setActivarnumero_retencionFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.NUMEROAUTORIZACION)) {
				this.setActivarnumero_autorizacionFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.NUMEROSERIE)) {
				this.setActivarnumero_serieFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.IDTIPOTRIBUTARIO)) {
				this.setActivarid_tipo_tributarioFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.FECHAVALIDEZ)) {
				this.setActivarfecha_validezFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.ANEXOFACTURAINICIO)) {
				this.setActivaranexo_factura_inicioFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.ANEXOFACTURAFIN)) {
				this.setActivaranexo_factura_finFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.IDMONEDA)) {
				this.setActivarid_monedaFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.VALORSERVICIOS0)) {
				this.setActivarvalor_servicios0FacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.TOTALIVA)) {
				this.setActivartotal_ivaFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.IVAPORCENTAJE)) {
				this.setActivariva_porcentajeFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.TOTAL)) {
				this.setActivartotalFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.NUMEROMAYOR)) {
				this.setActivarnumero_mayorFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.CODIGOASIENTO)) {
				this.setActivarcodigo_asientoFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.IDTIPORETENCIONFUENTE1)) {
				this.setActivarid_tipo_retencion_fuente1FacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.IDTIPORETENCIONIVA1)) {
				this.setActivarid_tipo_retencion_iva1FacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.ANEXONUMEROAUTORIZACION)) {
				this.setActivaranexo_numero_autorizacionFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.ANEXONUMESOSERIE)) {
				this.setActivaranexo_numeso_serieFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.ANEXOFECHAVALIDEZ)) {
				this.setActivaranexo_fecha_validezFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.IDCUENTACONTABLECREDITOFISCALSERVICIOS)) {
				this.setActivarid_cuenta_contable_credito_fiscal_serviciosFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.IDTIPOMOVIMIENTO)) {
				this.setActivarid_tipo_movimientoFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.IDTIPOMOVIMIENTOMODULO)) {
				this.setActivarid_tipo_movimiento_moduloFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {
				this.setActivarid_tipo_transaccion_moduloFacturaProveedorServicio(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,FacturaProveedorServicioBeanSwingJInternalFrame facturaproveedorservicioBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridFacturaProveedorServicio(esInicial);
		this.setResaltarid_empresaFacturaProveedorServicio(esInicial);
		this.setResaltarid_sucursalFacturaProveedorServicio(esInicial);
		this.setResaltarid_ejercicioFacturaProveedorServicio(esInicial);
		this.setResaltarid_periodoFacturaProveedorServicio(esInicial);
		this.setResaltarid_anioFacturaProveedorServicio(esInicial);
		this.setResaltarid_mesFacturaProveedorServicio(esInicial);
		this.setResaltarid_moduloFacturaProveedorServicio(esInicial);
		this.setResaltarid_transaccionFacturaProveedorServicio(esInicial);
		this.setResaltarid_facturaFacturaProveedorServicio(esInicial);
		this.setResaltarnumero_facturaFacturaProveedorServicio(esInicial);
		this.setResaltarid_clienteFacturaProveedorServicio(esInicial);
		this.setResaltarrucFacturaProveedorServicio(esInicial);
		this.setResaltarid_tipo_documentoFacturaProveedorServicio(esInicial);
		this.setResaltarplazoFacturaProveedorServicio(esInicial);
		this.setResaltarcon_riseFacturaProveedorServicio(esInicial);
		this.setResaltarfecha_emisionFacturaProveedorServicio(esInicial);
		this.setResaltarfecha_venceFacturaProveedorServicio(esInicial);
		this.setResaltarid_empleado_solicitaFacturaProveedorServicio(esInicial);
		this.setResaltarid_empleadoFacturaProveedorServicio(esInicial);
		this.setResaltardetalleFacturaProveedorServicio(esInicial);
		this.setResaltarnumero_retencionFacturaProveedorServicio(esInicial);
		this.setResaltarnumero_autorizacionFacturaProveedorServicio(esInicial);
		this.setResaltarnumero_serieFacturaProveedorServicio(esInicial);
		this.setResaltarid_tipo_tributarioFacturaProveedorServicio(esInicial);
		this.setResaltarfecha_validezFacturaProveedorServicio(esInicial);
		this.setResaltaranexo_factura_inicioFacturaProveedorServicio(esInicial);
		this.setResaltaranexo_factura_finFacturaProveedorServicio(esInicial);
		this.setResaltarid_monedaFacturaProveedorServicio(esInicial);
		this.setResaltarvalor_servicios0FacturaProveedorServicio(esInicial);
		this.setResaltartotal_ivaFacturaProveedorServicio(esInicial);
		this.setResaltariva_porcentajeFacturaProveedorServicio(esInicial);
		this.setResaltartotalFacturaProveedorServicio(esInicial);
		this.setResaltarnumero_mayorFacturaProveedorServicio(esInicial);
		this.setResaltarcodigo_asientoFacturaProveedorServicio(esInicial);
		this.setResaltarid_tipo_retencion_fuente1FacturaProveedorServicio(esInicial);
		this.setResaltarid_tipo_retencion_iva1FacturaProveedorServicio(esInicial);
		this.setResaltaranexo_numero_autorizacionFacturaProveedorServicio(esInicial);
		this.setResaltaranexo_numeso_serieFacturaProveedorServicio(esInicial);
		this.setResaltaranexo_fecha_validezFacturaProveedorServicio(esInicial);
		this.setResaltarid_cuenta_contable_credito_fiscal_serviciosFacturaProveedorServicio(esInicial);
		this.setResaltardescripcionFacturaProveedorServicio(esInicial);
		this.setResaltarid_tipo_movimientoFacturaProveedorServicio(esInicial);
		this.setResaltarid_tipo_movimiento_moduloFacturaProveedorServicio(esInicial);
		this.setResaltarid_tipo_transaccion_moduloFacturaProveedorServicio(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.ID)) {
				this.setResaltaridFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.IDMES)) {
				this.setResaltarid_mesFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.IDMODULO)) {
				this.setResaltarid_moduloFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.IDTRANSACCION)) {
				this.setResaltarid_transaccionFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.IDFACTURA)) {
				this.setResaltarid_facturaFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.NUMEROFACTURA)) {
				this.setResaltarnumero_facturaFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.RUC)) {
				this.setResaltarrucFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.IDTIPODOCUMENTO)) {
				this.setResaltarid_tipo_documentoFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.PLAZO)) {
				this.setResaltarplazoFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.CONRISE)) {
				this.setResaltarcon_riseFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.FECHAVENCE)) {
				this.setResaltarfecha_venceFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.IDEMPLEADOSOLICITA)) {
				this.setResaltarid_empleado_solicitaFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.DETALLE)) {
				this.setResaltardetalleFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.NUMERORETENCION)) {
				this.setResaltarnumero_retencionFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.NUMEROAUTORIZACION)) {
				this.setResaltarnumero_autorizacionFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.NUMEROSERIE)) {
				this.setResaltarnumero_serieFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.IDTIPOTRIBUTARIO)) {
				this.setResaltarid_tipo_tributarioFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.FECHAVALIDEZ)) {
				this.setResaltarfecha_validezFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.ANEXOFACTURAINICIO)) {
				this.setResaltaranexo_factura_inicioFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.ANEXOFACTURAFIN)) {
				this.setResaltaranexo_factura_finFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.IDMONEDA)) {
				this.setResaltarid_monedaFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.VALORSERVICIOS0)) {
				this.setResaltarvalor_servicios0FacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.TOTALIVA)) {
				this.setResaltartotal_ivaFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.IVAPORCENTAJE)) {
				this.setResaltariva_porcentajeFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.TOTAL)) {
				this.setResaltartotalFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.NUMEROMAYOR)) {
				this.setResaltarnumero_mayorFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.CODIGOASIENTO)) {
				this.setResaltarcodigo_asientoFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.IDTIPORETENCIONFUENTE1)) {
				this.setResaltarid_tipo_retencion_fuente1FacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.IDTIPORETENCIONIVA1)) {
				this.setResaltarid_tipo_retencion_iva1FacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.ANEXONUMEROAUTORIZACION)) {
				this.setResaltaranexo_numero_autorizacionFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.ANEXONUMESOSERIE)) {
				this.setResaltaranexo_numeso_serieFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.ANEXOFECHAVALIDEZ)) {
				this.setResaltaranexo_fecha_validezFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.IDCUENTACONTABLECREDITOFISCALSERVICIOS)) {
				this.setResaltarid_cuenta_contable_credito_fiscal_serviciosFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.IDTIPOMOVIMIENTO)) {
				this.setResaltarid_tipo_movimientoFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.IDTIPOMOVIMIENTOMODULO)) {
				this.setResaltarid_tipo_movimiento_moduloFacturaProveedorServicio(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaProveedorServicioConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {
				this.setResaltarid_tipo_transaccion_moduloFacturaProveedorServicio(esAsigna);
				continue;
			}
		}
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


		for(Classe clase:clases) {
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


		for(Classe clase:clases) {
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,FacturaProveedorServicioBeanSwingJInternalFrame facturaproveedorservicioBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}


		for(Classe clase:clases) {
		}		
	}
	
	


	public Boolean mostrarFK_IdClienteFacturaProveedorServicio=true;

	public Boolean getMostrarFK_IdClienteFacturaProveedorServicio() {
		return this.mostrarFK_IdClienteFacturaProveedorServicio;
	}

	public void setMostrarFK_IdClienteFacturaProveedorServicio(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteFacturaProveedorServicio= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableCreditoFiscalServiciosFacturaProveedorServicio=true;

	public Boolean getMostrarFK_IdCuentaContableCreditoFiscalServiciosFacturaProveedorServicio() {
		return this.mostrarFK_IdCuentaContableCreditoFiscalServiciosFacturaProveedorServicio;
	}

	public void setMostrarFK_IdCuentaContableCreditoFiscalServiciosFacturaProveedorServicio(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableCreditoFiscalServiciosFacturaProveedorServicio= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioFacturaProveedorServicio=true;

	public Boolean getMostrarFK_IdEjercicioFacturaProveedorServicio() {
		return this.mostrarFK_IdEjercicioFacturaProveedorServicio;
	}

	public void setMostrarFK_IdEjercicioFacturaProveedorServicio(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioFacturaProveedorServicio= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpleadoFacturaProveedorServicio=true;

	public Boolean getMostrarFK_IdEmpleadoFacturaProveedorServicio() {
		return this.mostrarFK_IdEmpleadoFacturaProveedorServicio;
	}

	public void setMostrarFK_IdEmpleadoFacturaProveedorServicio(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoFacturaProveedorServicio= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaFacturaProveedorServicio=true;

	public Boolean getMostrarFK_IdEmpresaFacturaProveedorServicio() {
		return this.mostrarFK_IdEmpresaFacturaProveedorServicio;
	}

	public void setMostrarFK_IdEmpresaFacturaProveedorServicio(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaFacturaProveedorServicio= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdModuloFacturaProveedorServicio=true;

	public Boolean getMostrarFK_IdModuloFacturaProveedorServicio() {
		return this.mostrarFK_IdModuloFacturaProveedorServicio;
	}

	public void setMostrarFK_IdModuloFacturaProveedorServicio(Boolean visibilidadResaltar) {
		this.mostrarFK_IdModuloFacturaProveedorServicio= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoFacturaProveedorServicio=true;

	public Boolean getMostrarFK_IdPeriodoFacturaProveedorServicio() {
		return this.mostrarFK_IdPeriodoFacturaProveedorServicio;
	}

	public void setMostrarFK_IdPeriodoFacturaProveedorServicio(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoFacturaProveedorServicio= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalFacturaProveedorServicio=true;

	public Boolean getMostrarFK_IdSucursalFacturaProveedorServicio() {
		return this.mostrarFK_IdSucursalFacturaProveedorServicio;
	}

	public void setMostrarFK_IdSucursalFacturaProveedorServicio(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalFacturaProveedorServicio= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoDocumentoFacturaProveedorServicio=true;

	public Boolean getMostrarFK_IdTipoDocumentoFacturaProveedorServicio() {
		return this.mostrarFK_IdTipoDocumentoFacturaProveedorServicio;
	}

	public void setMostrarFK_IdTipoDocumentoFacturaProveedorServicio(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoDocumentoFacturaProveedorServicio= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoMovimientoModuloFacturaProveedorServicio=true;

	public Boolean getMostrarFK_IdTipoMovimientoModuloFacturaProveedorServicio() {
		return this.mostrarFK_IdTipoMovimientoModuloFacturaProveedorServicio;
	}

	public void setMostrarFK_IdTipoMovimientoModuloFacturaProveedorServicio(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoMovimientoModuloFacturaProveedorServicio= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoRetencionFuente1FacturaProveedorServicio=true;

	public Boolean getMostrarFK_IdTipoRetencionFuente1FacturaProveedorServicio() {
		return this.mostrarFK_IdTipoRetencionFuente1FacturaProveedorServicio;
	}

	public void setMostrarFK_IdTipoRetencionFuente1FacturaProveedorServicio(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoRetencionFuente1FacturaProveedorServicio= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoRetencionIva1FacturaProveedorServicio=true;

	public Boolean getMostrarFK_IdTipoRetencionIva1FacturaProveedorServicio() {
		return this.mostrarFK_IdTipoRetencionIva1FacturaProveedorServicio;
	}

	public void setMostrarFK_IdTipoRetencionIva1FacturaProveedorServicio(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoRetencionIva1FacturaProveedorServicio= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoTransaccionModuloFacturaProveedorServicio=true;

	public Boolean getMostrarFK_IdTipoTransaccionModuloFacturaProveedorServicio() {
		return this.mostrarFK_IdTipoTransaccionModuloFacturaProveedorServicio;
	}

	public void setMostrarFK_IdTipoTransaccionModuloFacturaProveedorServicio(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoTransaccionModuloFacturaProveedorServicio= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoTributarioFacturaProveedorServicio=true;

	public Boolean getMostrarFK_IdTipoTributarioFacturaProveedorServicio() {
		return this.mostrarFK_IdTipoTributarioFacturaProveedorServicio;
	}

	public void setMostrarFK_IdTipoTributarioFacturaProveedorServicio(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoTributarioFacturaProveedorServicio= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTransaccionFacturaProveedorServicio=true;

	public Boolean getMostrarFK_IdTransaccionFacturaProveedorServicio() {
		return this.mostrarFK_IdTransaccionFacturaProveedorServicio;
	}

	public void setMostrarFK_IdTransaccionFacturaProveedorServicio(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTransaccionFacturaProveedorServicio= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdClienteFacturaProveedorServicio=true;

	public Boolean getActivarFK_IdClienteFacturaProveedorServicio() {
		return this.activarFK_IdClienteFacturaProveedorServicio;
	}

	public void setActivarFK_IdClienteFacturaProveedorServicio(Boolean habilitarResaltar) {
		this.activarFK_IdClienteFacturaProveedorServicio= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableCreditoFiscalServiciosFacturaProveedorServicio=true;

	public Boolean getActivarFK_IdCuentaContableCreditoFiscalServiciosFacturaProveedorServicio() {
		return this.activarFK_IdCuentaContableCreditoFiscalServiciosFacturaProveedorServicio;
	}

	public void setActivarFK_IdCuentaContableCreditoFiscalServiciosFacturaProveedorServicio(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableCreditoFiscalServiciosFacturaProveedorServicio= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioFacturaProveedorServicio=true;

	public Boolean getActivarFK_IdEjercicioFacturaProveedorServicio() {
		return this.activarFK_IdEjercicioFacturaProveedorServicio;
	}

	public void setActivarFK_IdEjercicioFacturaProveedorServicio(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioFacturaProveedorServicio= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpleadoFacturaProveedorServicio=true;

	public Boolean getActivarFK_IdEmpleadoFacturaProveedorServicio() {
		return this.activarFK_IdEmpleadoFacturaProveedorServicio;
	}

	public void setActivarFK_IdEmpleadoFacturaProveedorServicio(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoFacturaProveedorServicio= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaFacturaProveedorServicio=true;

	public Boolean getActivarFK_IdEmpresaFacturaProveedorServicio() {
		return this.activarFK_IdEmpresaFacturaProveedorServicio;
	}

	public void setActivarFK_IdEmpresaFacturaProveedorServicio(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaFacturaProveedorServicio= habilitarResaltar;
	}

	public Boolean activarFK_IdModuloFacturaProveedorServicio=true;

	public Boolean getActivarFK_IdModuloFacturaProveedorServicio() {
		return this.activarFK_IdModuloFacturaProveedorServicio;
	}

	public void setActivarFK_IdModuloFacturaProveedorServicio(Boolean habilitarResaltar) {
		this.activarFK_IdModuloFacturaProveedorServicio= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoFacturaProveedorServicio=true;

	public Boolean getActivarFK_IdPeriodoFacturaProveedorServicio() {
		return this.activarFK_IdPeriodoFacturaProveedorServicio;
	}

	public void setActivarFK_IdPeriodoFacturaProveedorServicio(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoFacturaProveedorServicio= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalFacturaProveedorServicio=true;

	public Boolean getActivarFK_IdSucursalFacturaProveedorServicio() {
		return this.activarFK_IdSucursalFacturaProveedorServicio;
	}

	public void setActivarFK_IdSucursalFacturaProveedorServicio(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalFacturaProveedorServicio= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoDocumentoFacturaProveedorServicio=true;

	public Boolean getActivarFK_IdTipoDocumentoFacturaProveedorServicio() {
		return this.activarFK_IdTipoDocumentoFacturaProveedorServicio;
	}

	public void setActivarFK_IdTipoDocumentoFacturaProveedorServicio(Boolean habilitarResaltar) {
		this.activarFK_IdTipoDocumentoFacturaProveedorServicio= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoMovimientoModuloFacturaProveedorServicio=true;

	public Boolean getActivarFK_IdTipoMovimientoModuloFacturaProveedorServicio() {
		return this.activarFK_IdTipoMovimientoModuloFacturaProveedorServicio;
	}

	public void setActivarFK_IdTipoMovimientoModuloFacturaProveedorServicio(Boolean habilitarResaltar) {
		this.activarFK_IdTipoMovimientoModuloFacturaProveedorServicio= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoRetencionFuente1FacturaProveedorServicio=true;

	public Boolean getActivarFK_IdTipoRetencionFuente1FacturaProveedorServicio() {
		return this.activarFK_IdTipoRetencionFuente1FacturaProveedorServicio;
	}

	public void setActivarFK_IdTipoRetencionFuente1FacturaProveedorServicio(Boolean habilitarResaltar) {
		this.activarFK_IdTipoRetencionFuente1FacturaProveedorServicio= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoRetencionIva1FacturaProveedorServicio=true;

	public Boolean getActivarFK_IdTipoRetencionIva1FacturaProveedorServicio() {
		return this.activarFK_IdTipoRetencionIva1FacturaProveedorServicio;
	}

	public void setActivarFK_IdTipoRetencionIva1FacturaProveedorServicio(Boolean habilitarResaltar) {
		this.activarFK_IdTipoRetencionIva1FacturaProveedorServicio= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoTransaccionModuloFacturaProveedorServicio=true;

	public Boolean getActivarFK_IdTipoTransaccionModuloFacturaProveedorServicio() {
		return this.activarFK_IdTipoTransaccionModuloFacturaProveedorServicio;
	}

	public void setActivarFK_IdTipoTransaccionModuloFacturaProveedorServicio(Boolean habilitarResaltar) {
		this.activarFK_IdTipoTransaccionModuloFacturaProveedorServicio= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoTributarioFacturaProveedorServicio=true;

	public Boolean getActivarFK_IdTipoTributarioFacturaProveedorServicio() {
		return this.activarFK_IdTipoTributarioFacturaProveedorServicio;
	}

	public void setActivarFK_IdTipoTributarioFacturaProveedorServicio(Boolean habilitarResaltar) {
		this.activarFK_IdTipoTributarioFacturaProveedorServicio= habilitarResaltar;
	}

	public Boolean activarFK_IdTransaccionFacturaProveedorServicio=true;

	public Boolean getActivarFK_IdTransaccionFacturaProveedorServicio() {
		return this.activarFK_IdTransaccionFacturaProveedorServicio;
	}

	public void setActivarFK_IdTransaccionFacturaProveedorServicio(Boolean habilitarResaltar) {
		this.activarFK_IdTransaccionFacturaProveedorServicio= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdClienteFacturaProveedorServicio=null;

	public Border getResaltarFK_IdClienteFacturaProveedorServicio() {
		return this.resaltarFK_IdClienteFacturaProveedorServicio;
	}

	public void setResaltarFK_IdClienteFacturaProveedorServicio(Border borderResaltar) {
		this.resaltarFK_IdClienteFacturaProveedorServicio= borderResaltar;
	}

	public void setResaltarFK_IdClienteFacturaProveedorServicio(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorServicioBeanSwingJInternalFrame facturaproveedorservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteFacturaProveedorServicio= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableCreditoFiscalServiciosFacturaProveedorServicio=null;

	public Border getResaltarFK_IdCuentaContableCreditoFiscalServiciosFacturaProveedorServicio() {
		return this.resaltarFK_IdCuentaContableCreditoFiscalServiciosFacturaProveedorServicio;
	}

	public void setResaltarFK_IdCuentaContableCreditoFiscalServiciosFacturaProveedorServicio(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableCreditoFiscalServiciosFacturaProveedorServicio= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableCreditoFiscalServiciosFacturaProveedorServicio(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorServicioBeanSwingJInternalFrame facturaproveedorservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableCreditoFiscalServiciosFacturaProveedorServicio= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioFacturaProveedorServicio=null;

	public Border getResaltarFK_IdEjercicioFacturaProveedorServicio() {
		return this.resaltarFK_IdEjercicioFacturaProveedorServicio;
	}

	public void setResaltarFK_IdEjercicioFacturaProveedorServicio(Border borderResaltar) {
		this.resaltarFK_IdEjercicioFacturaProveedorServicio= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioFacturaProveedorServicio(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorServicioBeanSwingJInternalFrame facturaproveedorservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioFacturaProveedorServicio= borderResaltar;
	}

	public Border resaltarFK_IdEmpleadoFacturaProveedorServicio=null;

	public Border getResaltarFK_IdEmpleadoFacturaProveedorServicio() {
		return this.resaltarFK_IdEmpleadoFacturaProveedorServicio;
	}

	public void setResaltarFK_IdEmpleadoFacturaProveedorServicio(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoFacturaProveedorServicio= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoFacturaProveedorServicio(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorServicioBeanSwingJInternalFrame facturaproveedorservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoFacturaProveedorServicio= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaFacturaProveedorServicio=null;

	public Border getResaltarFK_IdEmpresaFacturaProveedorServicio() {
		return this.resaltarFK_IdEmpresaFacturaProveedorServicio;
	}

	public void setResaltarFK_IdEmpresaFacturaProveedorServicio(Border borderResaltar) {
		this.resaltarFK_IdEmpresaFacturaProveedorServicio= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaFacturaProveedorServicio(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorServicioBeanSwingJInternalFrame facturaproveedorservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaFacturaProveedorServicio= borderResaltar;
	}

	public Border resaltarFK_IdModuloFacturaProveedorServicio=null;

	public Border getResaltarFK_IdModuloFacturaProveedorServicio() {
		return this.resaltarFK_IdModuloFacturaProveedorServicio;
	}

	public void setResaltarFK_IdModuloFacturaProveedorServicio(Border borderResaltar) {
		this.resaltarFK_IdModuloFacturaProveedorServicio= borderResaltar;
	}

	public void setResaltarFK_IdModuloFacturaProveedorServicio(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorServicioBeanSwingJInternalFrame facturaproveedorservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdModuloFacturaProveedorServicio= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoFacturaProveedorServicio=null;

	public Border getResaltarFK_IdPeriodoFacturaProveedorServicio() {
		return this.resaltarFK_IdPeriodoFacturaProveedorServicio;
	}

	public void setResaltarFK_IdPeriodoFacturaProveedorServicio(Border borderResaltar) {
		this.resaltarFK_IdPeriodoFacturaProveedorServicio= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoFacturaProveedorServicio(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorServicioBeanSwingJInternalFrame facturaproveedorservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoFacturaProveedorServicio= borderResaltar;
	}

	public Border resaltarFK_IdSucursalFacturaProveedorServicio=null;

	public Border getResaltarFK_IdSucursalFacturaProveedorServicio() {
		return this.resaltarFK_IdSucursalFacturaProveedorServicio;
	}

	public void setResaltarFK_IdSucursalFacturaProveedorServicio(Border borderResaltar) {
		this.resaltarFK_IdSucursalFacturaProveedorServicio= borderResaltar;
	}

	public void setResaltarFK_IdSucursalFacturaProveedorServicio(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorServicioBeanSwingJInternalFrame facturaproveedorservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalFacturaProveedorServicio= borderResaltar;
	}

	public Border resaltarFK_IdTipoDocumentoFacturaProveedorServicio=null;

	public Border getResaltarFK_IdTipoDocumentoFacturaProveedorServicio() {
		return this.resaltarFK_IdTipoDocumentoFacturaProveedorServicio;
	}

	public void setResaltarFK_IdTipoDocumentoFacturaProveedorServicio(Border borderResaltar) {
		this.resaltarFK_IdTipoDocumentoFacturaProveedorServicio= borderResaltar;
	}

	public void setResaltarFK_IdTipoDocumentoFacturaProveedorServicio(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorServicioBeanSwingJInternalFrame facturaproveedorservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoDocumentoFacturaProveedorServicio= borderResaltar;
	}

	public Border resaltarFK_IdTipoMovimientoModuloFacturaProveedorServicio=null;

	public Border getResaltarFK_IdTipoMovimientoModuloFacturaProveedorServicio() {
		return this.resaltarFK_IdTipoMovimientoModuloFacturaProveedorServicio;
	}

	public void setResaltarFK_IdTipoMovimientoModuloFacturaProveedorServicio(Border borderResaltar) {
		this.resaltarFK_IdTipoMovimientoModuloFacturaProveedorServicio= borderResaltar;
	}

	public void setResaltarFK_IdTipoMovimientoModuloFacturaProveedorServicio(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorServicioBeanSwingJInternalFrame facturaproveedorservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoMovimientoModuloFacturaProveedorServicio= borderResaltar;
	}

	public Border resaltarFK_IdTipoRetencionFuente1FacturaProveedorServicio=null;

	public Border getResaltarFK_IdTipoRetencionFuente1FacturaProveedorServicio() {
		return this.resaltarFK_IdTipoRetencionFuente1FacturaProveedorServicio;
	}

	public void setResaltarFK_IdTipoRetencionFuente1FacturaProveedorServicio(Border borderResaltar) {
		this.resaltarFK_IdTipoRetencionFuente1FacturaProveedorServicio= borderResaltar;
	}

	public void setResaltarFK_IdTipoRetencionFuente1FacturaProveedorServicio(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorServicioBeanSwingJInternalFrame facturaproveedorservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoRetencionFuente1FacturaProveedorServicio= borderResaltar;
	}

	public Border resaltarFK_IdTipoRetencionIva1FacturaProveedorServicio=null;

	public Border getResaltarFK_IdTipoRetencionIva1FacturaProveedorServicio() {
		return this.resaltarFK_IdTipoRetencionIva1FacturaProveedorServicio;
	}

	public void setResaltarFK_IdTipoRetencionIva1FacturaProveedorServicio(Border borderResaltar) {
		this.resaltarFK_IdTipoRetencionIva1FacturaProveedorServicio= borderResaltar;
	}

	public void setResaltarFK_IdTipoRetencionIva1FacturaProveedorServicio(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorServicioBeanSwingJInternalFrame facturaproveedorservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoRetencionIva1FacturaProveedorServicio= borderResaltar;
	}

	public Border resaltarFK_IdTipoTransaccionModuloFacturaProveedorServicio=null;

	public Border getResaltarFK_IdTipoTransaccionModuloFacturaProveedorServicio() {
		return this.resaltarFK_IdTipoTransaccionModuloFacturaProveedorServicio;
	}

	public void setResaltarFK_IdTipoTransaccionModuloFacturaProveedorServicio(Border borderResaltar) {
		this.resaltarFK_IdTipoTransaccionModuloFacturaProveedorServicio= borderResaltar;
	}

	public void setResaltarFK_IdTipoTransaccionModuloFacturaProveedorServicio(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorServicioBeanSwingJInternalFrame facturaproveedorservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoTransaccionModuloFacturaProveedorServicio= borderResaltar;
	}

	public Border resaltarFK_IdTipoTributarioFacturaProveedorServicio=null;

	public Border getResaltarFK_IdTipoTributarioFacturaProveedorServicio() {
		return this.resaltarFK_IdTipoTributarioFacturaProveedorServicio;
	}

	public void setResaltarFK_IdTipoTributarioFacturaProveedorServicio(Border borderResaltar) {
		this.resaltarFK_IdTipoTributarioFacturaProveedorServicio= borderResaltar;
	}

	public void setResaltarFK_IdTipoTributarioFacturaProveedorServicio(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorServicioBeanSwingJInternalFrame facturaproveedorservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoTributarioFacturaProveedorServicio= borderResaltar;
	}

	public Border resaltarFK_IdTransaccionFacturaProveedorServicio=null;

	public Border getResaltarFK_IdTransaccionFacturaProveedorServicio() {
		return this.resaltarFK_IdTransaccionFacturaProveedorServicio;
	}

	public void setResaltarFK_IdTransaccionFacturaProveedorServicio(Border borderResaltar) {
		this.resaltarFK_IdTransaccionFacturaProveedorServicio= borderResaltar;
	}

	public void setResaltarFK_IdTransaccionFacturaProveedorServicio(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaProveedorServicioBeanSwingJInternalFrame facturaproveedorservicioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTransaccionFacturaProveedorServicio= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}