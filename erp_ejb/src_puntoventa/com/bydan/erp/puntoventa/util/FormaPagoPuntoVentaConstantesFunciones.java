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
package com.bydan.erp.puntoventa.util;

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


import com.bydan.erp.puntoventa.util.FormaPagoPuntoVentaConstantesFunciones;
import com.bydan.erp.puntoventa.util.FormaPagoPuntoVentaParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.FormaPagoPuntoVentaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.tesoreria.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.puntoventa.business.dataaccess.*;
//import com.bydan.erp.puntoventa.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class FormaPagoPuntoVentaConstantesFunciones extends FormaPagoPuntoVentaConstantesFuncionesAdditional {		
	
	
	
	public static String S_TIPOREPORTE_EXTRA="";
	
	//USADO MAS EN RELACIONADO PARA MANTENIMIENTO MAESTRO-DETALLE
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOS=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOS;
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOS=Constantes.ISWING_TAMANIOMINIMO_TABLADATOS;
	
	//PARA TABLA RELACIONES(DESCRIPCION HEIGHTPE_REL_TAB)
	public static Integer ALTO_TABPANE_RELACIONES=Constantes.ISWING_ALTO_TABPANE + Funciones2.getValorProporcion(Constantes.ISWING_ALTO_TABPANE,0);
	
	//PARA TABLA RELACIONADO(DESCRIPTION HEIGHTPE_REL)
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL,-20);		
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL,-20);	
	
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
	public static final String SNOMBREOPCION="FormaPagoPuntoVenta";
	public static final String SPATHOPCION="PuntoVenta";	
	public static final String SPATHMODULO="puntoventa/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="FormaPagoPuntoVenta"+FormaPagoPuntoVentaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="FormaPagoPuntoVentaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="FormaPagoPuntoVentaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"_"+FormaPagoPuntoVentaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/FormaPagoPuntoVentaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"_"+FormaPagoPuntoVentaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"_"+FormaPagoPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/FormaPagoPuntoVentaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"_"+FormaPagoPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FormaPagoPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/FormaPagoPuntoVentaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FormaPagoPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FormaPagoPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/FormaPagoPuntoVentaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FormaPagoPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=FormaPagoPuntoVentaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+FormaPagoPuntoVentaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=FormaPagoPuntoVentaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+FormaPagoPuntoVentaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Forma Pagoes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Forma Pago";
	public static final String SCLASSWEBTITULO_LOWER="Forma Pago Punto Venta";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="FormaPagoPuntoVenta";
	public static final String OBJECTNAME="formapagopuntoventa";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PUNTOVENTA;	
	public static final String TABLENAME="forma_pago_punto_venta";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select formapagopuntoventa from "+FormaPagoPuntoVentaConstantesFunciones.SPERSISTENCENAME+" formapagopuntoventa";
	public static String QUERYSELECTNATIVE="select "+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".id,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".version_row,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".id_empresa,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".id_sucursal,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".id_ejercicio,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".id_periodo,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".id_factura_punto_venta,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".id_tipo_forma_pago,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".porcentaje,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".valor,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".fecha,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".descripcion,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".fecha_inicio,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".numero_dias_plazo,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".fecha_fin,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".id_banco,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".id_cuenta_banco_pun_ven,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".id_tipo_riesgo_cheque,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".numero_cuenta,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".numero_cheque,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".girador,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".id_banco_tarjeta,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".id_tarjeta_credito,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".id_tipo_interes_tarjeta,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".id_tipo_pago_tarjeta,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".id_conexion,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".id_mes,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".numero,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".tarjeta_habiente,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".autorizacion,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".voucher,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".lote,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".cuota,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".valor_retencion,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".valor_comision,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".valor_calculado,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".valor_cancelado,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".valor_difiere,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".numero_retencion,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".numero_liquidacion,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".id_anio,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".id_cuenta_contable,"+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME+".id_asiento_contable from "+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+"."+FormaPagoPuntoVentaConstantesFunciones.TABLENAME;//+" as "+FormaPagoPuntoVentaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected FormaPagoPuntoVentaConstantesFuncionesAdditional formapagopuntoventaConstantesFuncionesAdditional=null;
	
	public FormaPagoPuntoVentaConstantesFuncionesAdditional getFormaPagoPuntoVentaConstantesFuncionesAdditional() {
		return this.formapagopuntoventaConstantesFuncionesAdditional;
	}
	
	public void setFormaPagoPuntoVentaConstantesFuncionesAdditional(FormaPagoPuntoVentaConstantesFuncionesAdditional formapagopuntoventaConstantesFuncionesAdditional) {
		try {
			this.formapagopuntoventaConstantesFuncionesAdditional=formapagopuntoventaConstantesFuncionesAdditional;
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
    public static final String IDFACTURAPUNTOVENTA= "id_factura_punto_venta";
    public static final String IDTIPOFORMAPAGO= "id_tipo_forma_pago";
    public static final String PORCENTAJE= "porcentaje";
    public static final String VALOR= "valor";
    public static final String FECHA= "fecha";
    public static final String DESCRIPCION= "descripcion";
    public static final String FECHAINICIO= "fecha_inicio";
    public static final String NUMERODIASPLAZO= "numero_dias_plazo";
    public static final String FECHAFIN= "fecha_fin";
    public static final String IDBANCO= "id_banco";
    public static final String IDCUENTABANCOPUNVEN= "id_cuenta_banco_pun_ven";
    public static final String IDTIPORIESGOCHEQUE= "id_tipo_riesgo_cheque";
    public static final String NUMEROCUENTA= "numero_cuenta";
    public static final String NUMEROCHEQUE= "numero_cheque";
    public static final String GIRADOR= "girador";
    public static final String IDBANCOTARJETA= "id_banco_tarjeta";
    public static final String IDTARJETACREDITO= "id_tarjeta_credito";
    public static final String IDTIPOINTERESTARJETA= "id_tipo_interes_tarjeta";
    public static final String IDTIPOPAGOTARJETA= "id_tipo_pago_tarjeta";
    public static final String IDCONEXION= "id_conexion";
    public static final String IDMES= "id_mes";
    public static final String NUMERO= "numero";
    public static final String TARJETAHABIENTE= "tarjeta_habiente";
    public static final String AUTORIZACION= "autorizacion";
    public static final String VOUCHER= "voucher";
    public static final String LOTE= "lote";
    public static final String CUOTA= "cuota";
    public static final String VALORRETENCION= "valor_retencion";
    public static final String VALORCOMISION= "valor_comision";
    public static final String VALORCALCULADO= "valor_calculado";
    public static final String VALORCANCELADO= "valor_cancelado";
    public static final String VALORDIFIERE= "valor_difiere";
    public static final String NUMERORETENCION= "numero_retencion";
    public static final String NUMEROLIQUIDACION= "numero_liquidacion";
    public static final String IDANIO= "id_anio";
    public static final String IDCUENTACONTABLE= "id_cuenta_contable";
    public static final String IDASIENTOCONTABLE= "id_asiento_contable";
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
    	public static final String LABEL_IDFACTURAPUNTOVENTA= "Factura Punto Venta";
		public static final String LABEL_IDFACTURAPUNTOVENTA_LOWER= "Factura Punto Venta";
    	public static final String LABEL_IDTIPOFORMAPAGO= "Tipo Forma Pago";
		public static final String LABEL_IDTIPOFORMAPAGO_LOWER= "Tipo Forma Pago";
    	public static final String LABEL_PORCENTAJE= "Porcentaje";
		public static final String LABEL_PORCENTAJE_LOWER= "Porcentaje";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_FECHAINICIO= "Fecha Inicio";
		public static final String LABEL_FECHAINICIO_LOWER= "Fecha Inicio";
    	public static final String LABEL_NUMERODIASPLAZO= "Numero Dias Plazo";
		public static final String LABEL_NUMERODIASPLAZO_LOWER= "Numero Dias Plazo";
    	public static final String LABEL_FECHAFIN= "Fecha Fin";
		public static final String LABEL_FECHAFIN_LOWER= "Fecha Fin";
    	public static final String LABEL_IDBANCO= "Banco";
		public static final String LABEL_IDBANCO_LOWER= "Banco";
    	public static final String LABEL_IDCUENTABANCOPUNVEN= "Cuenta Banco Pun Ven";
		public static final String LABEL_IDCUENTABANCOPUNVEN_LOWER= "Cuenta Banco Pun Ven";
    	public static final String LABEL_IDTIPORIESGOCHEQUE= "Tipo Riesgo Cheque";
		public static final String LABEL_IDTIPORIESGOCHEQUE_LOWER= "Tipo Riesgo Cheque";
    	public static final String LABEL_NUMEROCUENTA= "Numero Cuenta";
		public static final String LABEL_NUMEROCUENTA_LOWER= "Numero Cuenta";
    	public static final String LABEL_NUMEROCHEQUE= "Numero Cheque";
		public static final String LABEL_NUMEROCHEQUE_LOWER= "Numero Cheque";
    	public static final String LABEL_GIRADOR= "Girador";
		public static final String LABEL_GIRADOR_LOWER= "Girador";
    	public static final String LABEL_IDBANCOTARJETA= "Banco";
		public static final String LABEL_IDBANCOTARJETA_LOWER= "Banco Tarjeta";
    	public static final String LABEL_IDTARJETACREDITO= "Tarjeta Credito";
		public static final String LABEL_IDTARJETACREDITO_LOWER= "Tarjeta Credito";
    	public static final String LABEL_IDTIPOINTERESTARJETA= "Tipo Interes Tarjeta";
		public static final String LABEL_IDTIPOINTERESTARJETA_LOWER= "Tipo Interes Tarjeta";
    	public static final String LABEL_IDTIPOPAGOTARJETA= "Tipo Pago Tarjeta";
		public static final String LABEL_IDTIPOPAGOTARJETA_LOWER= "Tipo Pago Tarjeta";
    	public static final String LABEL_IDCONEXION= "Conexion";
		public static final String LABEL_IDCONEXION_LOWER= "Conexion";
    	public static final String LABEL_IDMES= "Mes";
		public static final String LABEL_IDMES_LOWER= "Mes";
    	public static final String LABEL_NUMERO= "Numero";
		public static final String LABEL_NUMERO_LOWER= "Numero";
    	public static final String LABEL_TARJETAHABIENTE= "Tarjeta Habiente";
		public static final String LABEL_TARJETAHABIENTE_LOWER= "Tarjeta Habiente";
    	public static final String LABEL_AUTORIZACION= "Autorizacion";
		public static final String LABEL_AUTORIZACION_LOWER= "Autorizacion";
    	public static final String LABEL_VOUCHER= "Voucher";
		public static final String LABEL_VOUCHER_LOWER= "Voucher";
    	public static final String LABEL_LOTE= "Lote";
		public static final String LABEL_LOTE_LOWER= "Lote";
    	public static final String LABEL_CUOTA= "Cuota";
		public static final String LABEL_CUOTA_LOWER= "Cuota";
    	public static final String LABEL_VALORRETENCION= "Valor Retencion";
		public static final String LABEL_VALORRETENCION_LOWER= "Valor Retencion";
    	public static final String LABEL_VALORCOMISION= "Valor Comision";
		public static final String LABEL_VALORCOMISION_LOWER= "Valor Comision";
    	public static final String LABEL_VALORCALCULADO= "Valor Calculado";
		public static final String LABEL_VALORCALCULADO_LOWER= "Valor Calculado";
    	public static final String LABEL_VALORCANCELADO= "Valor Cancelado";
		public static final String LABEL_VALORCANCELADO_LOWER= "Valor Cancelado";
    	public static final String LABEL_VALORDIFIERE= "Valor Difiere";
		public static final String LABEL_VALORDIFIERE_LOWER= "Valor Difiere";
    	public static final String LABEL_NUMERORETENCION= "Numero Retencion";
		public static final String LABEL_NUMERORETENCION_LOWER= "Numero Retencion";
    	public static final String LABEL_NUMEROLIQUIDACION= "Numero Liquidacion";
		public static final String LABEL_NUMEROLIQUIDACION_LOWER= "Numero Liquidacion";
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_IDCUENTACONTABLE= "Cuenta Contable";
		public static final String LABEL_IDCUENTACONTABLE_LOWER= "Cuenta Contable";
    	public static final String LABEL_IDASIENTOCONTABLE= "Asiento Contable";
		public static final String LABEL_IDASIENTOCONTABLE_LOWER= "Asiento Contable";
	
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
	public static final String SREGEXNUMERO_CUENTA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_CUENTA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_CHEQUE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_CHEQUE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXGIRADOR=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXGIRADOR=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
	public static final String SREGEXNUMERO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXTARJETA_HABIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXTARJETA_HABIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXAUTORIZACION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXAUTORIZACION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXVOUCHER=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXVOUCHER=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXLOTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXLOTE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
	public static final String SREGEXNUMERO_RETENCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_RETENCION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_LIQUIDACION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_LIQUIDACION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
	
	public static String getFormaPagoPuntoVentaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(FormaPagoPuntoVentaConstantesFunciones.IDEMPRESA)) {sLabelColumna=FormaPagoPuntoVentaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(FormaPagoPuntoVentaConstantesFunciones.IDSUCURSAL)) {sLabelColumna=FormaPagoPuntoVentaConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(FormaPagoPuntoVentaConstantesFunciones.IDEJERCICIO)) {sLabelColumna=FormaPagoPuntoVentaConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(FormaPagoPuntoVentaConstantesFunciones.IDPERIODO)) {sLabelColumna=FormaPagoPuntoVentaConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(FormaPagoPuntoVentaConstantesFunciones.IDFACTURAPUNTOVENTA)) {sLabelColumna=FormaPagoPuntoVentaConstantesFunciones.LABEL_IDFACTURAPUNTOVENTA;}
		if(sNombreColumna.equals(FormaPagoPuntoVentaConstantesFunciones.IDTIPOFORMAPAGO)) {sLabelColumna=FormaPagoPuntoVentaConstantesFunciones.LABEL_IDTIPOFORMAPAGO;}
		if(sNombreColumna.equals(FormaPagoPuntoVentaConstantesFunciones.PORCENTAJE)) {sLabelColumna=FormaPagoPuntoVentaConstantesFunciones.LABEL_PORCENTAJE;}
		if(sNombreColumna.equals(FormaPagoPuntoVentaConstantesFunciones.VALOR)) {sLabelColumna=FormaPagoPuntoVentaConstantesFunciones.LABEL_VALOR;}
		if(sNombreColumna.equals(FormaPagoPuntoVentaConstantesFunciones.FECHA)) {sLabelColumna=FormaPagoPuntoVentaConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(FormaPagoPuntoVentaConstantesFunciones.DESCRIPCION)) {sLabelColumna=FormaPagoPuntoVentaConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(FormaPagoPuntoVentaConstantesFunciones.FECHAINICIO)) {sLabelColumna=FormaPagoPuntoVentaConstantesFunciones.LABEL_FECHAINICIO;}
		if(sNombreColumna.equals(FormaPagoPuntoVentaConstantesFunciones.NUMERODIASPLAZO)) {sLabelColumna=FormaPagoPuntoVentaConstantesFunciones.LABEL_NUMERODIASPLAZO;}
		if(sNombreColumna.equals(FormaPagoPuntoVentaConstantesFunciones.FECHAFIN)) {sLabelColumna=FormaPagoPuntoVentaConstantesFunciones.LABEL_FECHAFIN;}
		if(sNombreColumna.equals(FormaPagoPuntoVentaConstantesFunciones.IDBANCO)) {sLabelColumna=FormaPagoPuntoVentaConstantesFunciones.LABEL_IDBANCO;}
		if(sNombreColumna.equals(FormaPagoPuntoVentaConstantesFunciones.IDCUENTABANCOPUNVEN)) {sLabelColumna=FormaPagoPuntoVentaConstantesFunciones.LABEL_IDCUENTABANCOPUNVEN;}
		if(sNombreColumna.equals(FormaPagoPuntoVentaConstantesFunciones.IDTIPORIESGOCHEQUE)) {sLabelColumna=FormaPagoPuntoVentaConstantesFunciones.LABEL_IDTIPORIESGOCHEQUE;}
		if(sNombreColumna.equals(FormaPagoPuntoVentaConstantesFunciones.NUMEROCUENTA)) {sLabelColumna=FormaPagoPuntoVentaConstantesFunciones.LABEL_NUMEROCUENTA;}
		if(sNombreColumna.equals(FormaPagoPuntoVentaConstantesFunciones.NUMEROCHEQUE)) {sLabelColumna=FormaPagoPuntoVentaConstantesFunciones.LABEL_NUMEROCHEQUE;}
		if(sNombreColumna.equals(FormaPagoPuntoVentaConstantesFunciones.GIRADOR)) {sLabelColumna=FormaPagoPuntoVentaConstantesFunciones.LABEL_GIRADOR;}
		if(sNombreColumna.equals(FormaPagoPuntoVentaConstantesFunciones.IDBANCOTARJETA)) {sLabelColumna=FormaPagoPuntoVentaConstantesFunciones.LABEL_IDBANCOTARJETA;}
		if(sNombreColumna.equals(FormaPagoPuntoVentaConstantesFunciones.IDTARJETACREDITO)) {sLabelColumna=FormaPagoPuntoVentaConstantesFunciones.LABEL_IDTARJETACREDITO;}
		if(sNombreColumna.equals(FormaPagoPuntoVentaConstantesFunciones.IDTIPOINTERESTARJETA)) {sLabelColumna=FormaPagoPuntoVentaConstantesFunciones.LABEL_IDTIPOINTERESTARJETA;}
		if(sNombreColumna.equals(FormaPagoPuntoVentaConstantesFunciones.IDTIPOPAGOTARJETA)) {sLabelColumna=FormaPagoPuntoVentaConstantesFunciones.LABEL_IDTIPOPAGOTARJETA;}
		if(sNombreColumna.equals(FormaPagoPuntoVentaConstantesFunciones.IDCONEXION)) {sLabelColumna=FormaPagoPuntoVentaConstantesFunciones.LABEL_IDCONEXION;}
		if(sNombreColumna.equals(FormaPagoPuntoVentaConstantesFunciones.IDMES)) {sLabelColumna=FormaPagoPuntoVentaConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(FormaPagoPuntoVentaConstantesFunciones.NUMERO)) {sLabelColumna=FormaPagoPuntoVentaConstantesFunciones.LABEL_NUMERO;}
		if(sNombreColumna.equals(FormaPagoPuntoVentaConstantesFunciones.TARJETAHABIENTE)) {sLabelColumna=FormaPagoPuntoVentaConstantesFunciones.LABEL_TARJETAHABIENTE;}
		if(sNombreColumna.equals(FormaPagoPuntoVentaConstantesFunciones.AUTORIZACION)) {sLabelColumna=FormaPagoPuntoVentaConstantesFunciones.LABEL_AUTORIZACION;}
		if(sNombreColumna.equals(FormaPagoPuntoVentaConstantesFunciones.VOUCHER)) {sLabelColumna=FormaPagoPuntoVentaConstantesFunciones.LABEL_VOUCHER;}
		if(sNombreColumna.equals(FormaPagoPuntoVentaConstantesFunciones.LOTE)) {sLabelColumna=FormaPagoPuntoVentaConstantesFunciones.LABEL_LOTE;}
		if(sNombreColumna.equals(FormaPagoPuntoVentaConstantesFunciones.CUOTA)) {sLabelColumna=FormaPagoPuntoVentaConstantesFunciones.LABEL_CUOTA;}
		if(sNombreColumna.equals(FormaPagoPuntoVentaConstantesFunciones.VALORRETENCION)) {sLabelColumna=FormaPagoPuntoVentaConstantesFunciones.LABEL_VALORRETENCION;}
		if(sNombreColumna.equals(FormaPagoPuntoVentaConstantesFunciones.VALORCOMISION)) {sLabelColumna=FormaPagoPuntoVentaConstantesFunciones.LABEL_VALORCOMISION;}
		if(sNombreColumna.equals(FormaPagoPuntoVentaConstantesFunciones.VALORCALCULADO)) {sLabelColumna=FormaPagoPuntoVentaConstantesFunciones.LABEL_VALORCALCULADO;}
		if(sNombreColumna.equals(FormaPagoPuntoVentaConstantesFunciones.VALORCANCELADO)) {sLabelColumna=FormaPagoPuntoVentaConstantesFunciones.LABEL_VALORCANCELADO;}
		if(sNombreColumna.equals(FormaPagoPuntoVentaConstantesFunciones.VALORDIFIERE)) {sLabelColumna=FormaPagoPuntoVentaConstantesFunciones.LABEL_VALORDIFIERE;}
		if(sNombreColumna.equals(FormaPagoPuntoVentaConstantesFunciones.NUMERORETENCION)) {sLabelColumna=FormaPagoPuntoVentaConstantesFunciones.LABEL_NUMERORETENCION;}
		if(sNombreColumna.equals(FormaPagoPuntoVentaConstantesFunciones.NUMEROLIQUIDACION)) {sLabelColumna=FormaPagoPuntoVentaConstantesFunciones.LABEL_NUMEROLIQUIDACION;}
		if(sNombreColumna.equals(FormaPagoPuntoVentaConstantesFunciones.IDANIO)) {sLabelColumna=FormaPagoPuntoVentaConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(FormaPagoPuntoVentaConstantesFunciones.IDCUENTACONTABLE)) {sLabelColumna=FormaPagoPuntoVentaConstantesFunciones.LABEL_IDCUENTACONTABLE;}
		if(sNombreColumna.equals(FormaPagoPuntoVentaConstantesFunciones.IDASIENTOCONTABLE)) {sLabelColumna=FormaPagoPuntoVentaConstantesFunciones.LABEL_IDASIENTOCONTABLE;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getFormaPagoPuntoVentaDescripcion(FormaPagoPuntoVenta formapagopuntoventa) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(formapagopuntoventa !=null/* && formapagopuntoventa.getId()!=0*/) {
			if(formapagopuntoventa.getId()!=null) {
				sDescripcion=formapagopuntoventa.getId().toString();
			}//formapagopuntoventaformapagopuntoventa.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getFormaPagoPuntoVentaDescripcionDetallado(FormaPagoPuntoVenta formapagopuntoventa) {
		String sDescripcion="";
			
		sDescripcion+=FormaPagoPuntoVentaConstantesFunciones.ID+"=";
		sDescripcion+=formapagopuntoventa.getId().toString()+",";
		sDescripcion+=FormaPagoPuntoVentaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=formapagopuntoventa.getVersionRow().toString()+",";
		sDescripcion+=FormaPagoPuntoVentaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=formapagopuntoventa.getid_empresa().toString()+",";
		sDescripcion+=FormaPagoPuntoVentaConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=formapagopuntoventa.getid_sucursal().toString()+",";
		sDescripcion+=FormaPagoPuntoVentaConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=formapagopuntoventa.getid_ejercicio().toString()+",";
		sDescripcion+=FormaPagoPuntoVentaConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=formapagopuntoventa.getid_periodo().toString()+",";
		sDescripcion+=FormaPagoPuntoVentaConstantesFunciones.IDFACTURAPUNTOVENTA+"=";
		sDescripcion+=formapagopuntoventa.getid_factura_punto_venta().toString()+",";
		sDescripcion+=FormaPagoPuntoVentaConstantesFunciones.IDTIPOFORMAPAGO+"=";
		sDescripcion+=formapagopuntoventa.getid_tipo_forma_pago().toString()+",";
		sDescripcion+=FormaPagoPuntoVentaConstantesFunciones.PORCENTAJE+"=";
		sDescripcion+=formapagopuntoventa.getporcentaje().toString()+",";
		sDescripcion+=FormaPagoPuntoVentaConstantesFunciones.VALOR+"=";
		sDescripcion+=formapagopuntoventa.getvalor().toString()+",";
		sDescripcion+=FormaPagoPuntoVentaConstantesFunciones.FECHA+"=";
		sDescripcion+=formapagopuntoventa.getfecha().toString()+",";
		sDescripcion+=FormaPagoPuntoVentaConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=formapagopuntoventa.getdescripcion()+",";
		sDescripcion+=FormaPagoPuntoVentaConstantesFunciones.FECHAINICIO+"=";
		sDescripcion+=formapagopuntoventa.getfecha_inicio().toString()+",";
		sDescripcion+=FormaPagoPuntoVentaConstantesFunciones.NUMERODIASPLAZO+"=";
		sDescripcion+=formapagopuntoventa.getnumero_dias_plazo().toString()+",";
		sDescripcion+=FormaPagoPuntoVentaConstantesFunciones.FECHAFIN+"=";
		sDescripcion+=formapagopuntoventa.getfecha_fin().toString()+",";
		sDescripcion+=FormaPagoPuntoVentaConstantesFunciones.IDBANCO+"=";
		sDescripcion+=formapagopuntoventa.getid_banco().toString()+",";
		sDescripcion+=FormaPagoPuntoVentaConstantesFunciones.IDCUENTABANCOPUNVEN+"=";
		sDescripcion+=formapagopuntoventa.getid_cuenta_banco_pun_ven().toString()+",";
		sDescripcion+=FormaPagoPuntoVentaConstantesFunciones.IDTIPORIESGOCHEQUE+"=";
		sDescripcion+=formapagopuntoventa.getid_tipo_riesgo_cheque().toString()+",";
		sDescripcion+=FormaPagoPuntoVentaConstantesFunciones.NUMEROCUENTA+"=";
		sDescripcion+=formapagopuntoventa.getnumero_cuenta()+",";
		sDescripcion+=FormaPagoPuntoVentaConstantesFunciones.NUMEROCHEQUE+"=";
		sDescripcion+=formapagopuntoventa.getnumero_cheque()+",";
		sDescripcion+=FormaPagoPuntoVentaConstantesFunciones.GIRADOR+"=";
		sDescripcion+=formapagopuntoventa.getgirador()+",";
		sDescripcion+=FormaPagoPuntoVentaConstantesFunciones.IDBANCOTARJETA+"=";
		sDescripcion+=formapagopuntoventa.getid_banco_tarjeta().toString()+",";
		sDescripcion+=FormaPagoPuntoVentaConstantesFunciones.IDTARJETACREDITO+"=";
		sDescripcion+=formapagopuntoventa.getid_tarjeta_credito().toString()+",";
		sDescripcion+=FormaPagoPuntoVentaConstantesFunciones.IDTIPOINTERESTARJETA+"=";
		sDescripcion+=formapagopuntoventa.getid_tipo_interes_tarjeta().toString()+",";
		sDescripcion+=FormaPagoPuntoVentaConstantesFunciones.IDTIPOPAGOTARJETA+"=";
		sDescripcion+=formapagopuntoventa.getid_tipo_pago_tarjeta().toString()+",";
		sDescripcion+=FormaPagoPuntoVentaConstantesFunciones.IDCONEXION+"=";
		sDescripcion+=formapagopuntoventa.getid_conexion().toString()+",";
		sDescripcion+=FormaPagoPuntoVentaConstantesFunciones.IDMES+"=";
		sDescripcion+=formapagopuntoventa.getid_mes().toString()+",";
		sDescripcion+=FormaPagoPuntoVentaConstantesFunciones.NUMERO+"=";
		sDescripcion+=formapagopuntoventa.getnumero()+",";
		sDescripcion+=FormaPagoPuntoVentaConstantesFunciones.TARJETAHABIENTE+"=";
		sDescripcion+=formapagopuntoventa.gettarjeta_habiente()+",";
		sDescripcion+=FormaPagoPuntoVentaConstantesFunciones.AUTORIZACION+"=";
		sDescripcion+=formapagopuntoventa.getautorizacion()+",";
		sDescripcion+=FormaPagoPuntoVentaConstantesFunciones.VOUCHER+"=";
		sDescripcion+=formapagopuntoventa.getvoucher()+",";
		sDescripcion+=FormaPagoPuntoVentaConstantesFunciones.LOTE+"=";
		sDescripcion+=formapagopuntoventa.getlote()+",";
		sDescripcion+=FormaPagoPuntoVentaConstantesFunciones.CUOTA+"=";
		sDescripcion+=formapagopuntoventa.getcuota().toString()+",";
		sDescripcion+=FormaPagoPuntoVentaConstantesFunciones.VALORRETENCION+"=";
		sDescripcion+=formapagopuntoventa.getvalor_retencion().toString()+",";
		sDescripcion+=FormaPagoPuntoVentaConstantesFunciones.VALORCOMISION+"=";
		sDescripcion+=formapagopuntoventa.getvalor_comision().toString()+",";
		sDescripcion+=FormaPagoPuntoVentaConstantesFunciones.VALORCALCULADO+"=";
		sDescripcion+=formapagopuntoventa.getvalor_calculado().toString()+",";
		sDescripcion+=FormaPagoPuntoVentaConstantesFunciones.VALORCANCELADO+"=";
		sDescripcion+=formapagopuntoventa.getvalor_cancelado().toString()+",";
		sDescripcion+=FormaPagoPuntoVentaConstantesFunciones.VALORDIFIERE+"=";
		sDescripcion+=formapagopuntoventa.getvalor_difiere().toString()+",";
		sDescripcion+=FormaPagoPuntoVentaConstantesFunciones.NUMERORETENCION+"=";
		sDescripcion+=formapagopuntoventa.getnumero_retencion()+",";
		sDescripcion+=FormaPagoPuntoVentaConstantesFunciones.NUMEROLIQUIDACION+"=";
		sDescripcion+=formapagopuntoventa.getnumero_liquidacion()+",";
		sDescripcion+=FormaPagoPuntoVentaConstantesFunciones.IDANIO+"=";
		sDescripcion+=formapagopuntoventa.getid_anio().toString()+",";
		sDescripcion+=FormaPagoPuntoVentaConstantesFunciones.IDCUENTACONTABLE+"=";
		sDescripcion+=formapagopuntoventa.getid_cuenta_contable().toString()+",";
		sDescripcion+=FormaPagoPuntoVentaConstantesFunciones.IDASIENTOCONTABLE+"=";
		sDescripcion+=formapagopuntoventa.getid_asiento_contable().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setFormaPagoPuntoVentaDescripcion(FormaPagoPuntoVenta formapagopuntoventa,String sValor) throws Exception {			
		if(formapagopuntoventa !=null) {
			//formapagopuntoventaformapagopuntoventa.getId().toString();
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

	public static String getFacturaPuntoVentaDescripcion(FacturaPuntoVenta facturapuntoventa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(facturapuntoventa!=null/*&&facturapuntoventa.getId()>0*/) {
			sDescripcion=FacturaPuntoVentaConstantesFunciones.getFacturaPuntoVentaDescripcion(facturapuntoventa);
		}

		return sDescripcion;
	}

	public static String getTipoFormaPagoDescripcion(TipoFormaPago tipoformapago) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoformapago!=null/*&&tipoformapago.getId()>0*/) {
			sDescripcion=TipoFormaPagoConstantesFunciones.getTipoFormaPagoDescripcion(tipoformapago);
		}

		return sDescripcion;
	}

	public static String getBancoDescripcion(Banco banco) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(banco!=null/*&&banco.getId()>0*/) {
			sDescripcion=BancoConstantesFunciones.getBancoDescripcion(banco);
		}

		return sDescripcion;
	}

	public static String getCuentaBancoPunVenDescripcion(CuentaBancoPunVen cuentabancopunven) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentabancopunven!=null/*&&cuentabancopunven.getId()>0*/) {
			sDescripcion=CuentaBancoPunVenConstantesFunciones.getCuentaBancoPunVenDescripcion(cuentabancopunven);
		}

		return sDescripcion;
	}

	public static String getTipoRiesgoChequeDescripcion(TipoRiesgoCheque tiporiesgocheque) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tiporiesgocheque!=null/*&&tiporiesgocheque.getId()>0*/) {
			sDescripcion=TipoRiesgoChequeConstantesFunciones.getTipoRiesgoChequeDescripcion(tiporiesgocheque);
		}

		return sDescripcion;
	}

	public static String getBancoTarjetaDescripcion(Banco banco) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(banco!=null/*&&banco.getId()>0*/) {
			sDescripcion=BancoConstantesFunciones.getBancoDescripcion(banco);
		}

		return sDescripcion;
	}

	public static String getTarjetaCreditoDescripcion(TarjetaCredito tarjetacredito) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tarjetacredito!=null/*&&tarjetacredito.getId()>0*/) {
			sDescripcion=TarjetaCreditoConstantesFunciones.getTarjetaCreditoDescripcion(tarjetacredito);
		}

		return sDescripcion;
	}

	public static String getTipoInteresTarjetaDescripcion(TipoInteresTarjeta tipointerestarjeta) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipointerestarjeta!=null/*&&tipointerestarjeta.getId()>0*/) {
			sDescripcion=TipoInteresTarjetaConstantesFunciones.getTipoInteresTarjetaDescripcion(tipointerestarjeta);
		}

		return sDescripcion;
	}

	public static String getTipoPagoTarjetaDescripcion(TipoPagoTarjeta tipopagotarjeta) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipopagotarjeta!=null/*&&tipopagotarjeta.getId()>0*/) {
			sDescripcion=TipoPagoTarjetaConstantesFunciones.getTipoPagoTarjetaDescripcion(tipopagotarjeta);
		}

		return sDescripcion;
	}

	public static String getConexionDescripcion(Conexion conexion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(conexion!=null/*&&conexion.getId()>0*/) {
			sDescripcion=ConexionConstantesFunciones.getConexionDescripcion(conexion);
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

	public static String getAnioDescripcion(Anio anio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(anio!=null/*&&anio.getId()>0*/) {
			sDescripcion=AnioConstantesFunciones.getAnioDescripcion(anio);
		}

		return sDescripcion;
	}

	public static String getCuentaContableDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getAsientoContableDescripcion(AsientoContable asientocontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(asientocontable!=null/*&&asientocontable.getId()>0*/) {
			sDescripcion=AsientoContableConstantesFunciones.getAsientoContableDescripcion(asientocontable);
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
		} else if(sNombreIndice.equals("FK_IdAsientoContable")) {
			sNombreIndice="Tipo=  Por Asiento Contable";
		} else if(sNombreIndice.equals("FK_IdBanco")) {
			sNombreIndice="Tipo=  Por Banco";
		} else if(sNombreIndice.equals("FK_IdBancoTarjeta")) {
			sNombreIndice="Tipo=  Por Banco";
		} else if(sNombreIndice.equals("FK_IdConexion")) {
			sNombreIndice="Tipo=  Por Conexion";
		} else if(sNombreIndice.equals("FK_IdCuentaBancoPunVen")) {
			sNombreIndice="Tipo=  Por Cuenta Banco Pun Ven";
		} else if(sNombreIndice.equals("FK_IdCuentaContable")) {
			sNombreIndice="Tipo=  Por Cuenta Contable";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdFacturaPuntoVenta")) {
			sNombreIndice="Tipo=  Por Factura Punto Venta";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTarjetaCredito")) {
			sNombreIndice="Tipo=  Por Tarjeta Credito";
		} else if(sNombreIndice.equals("FK_IdTipoFormaPago")) {
			sNombreIndice="Tipo=  Por Tipo Forma Pago";
		} else if(sNombreIndice.equals("FK_IdTipoInteresTarjeta")) {
			sNombreIndice="Tipo=  Por Tipo Interes Tarjeta";
		} else if(sNombreIndice.equals("FK_IdTipoPagoTarjeta")) {
			sNombreIndice="Tipo=  Por Tipo Pago Tarjeta";
		} else if(sNombreIndice.equals("FK_IdTipoRiesgoCheque")) {
			sNombreIndice="Tipo=  Por Tipo Riesgo Cheque";
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

	public static String getDetalleIndiceFK_IdAsientoContable(Long id_asiento_contable) {
		String sDetalleIndice=" Parametros->";
		if(id_asiento_contable!=null) {sDetalleIndice+=" Codigo Unico De Asiento Contable="+id_asiento_contable.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdBanco(Long id_banco) {
		String sDetalleIndice=" Parametros->";
		if(id_banco!=null) {sDetalleIndice+=" Codigo Unico De Banco="+id_banco.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdBancoTarjeta(Long id_banco_tarjeta) {
		String sDetalleIndice=" Parametros->";
		if(id_banco_tarjeta!=null) {sDetalleIndice+=" Codigo Unico De Banco="+id_banco_tarjeta.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdConexion(Long id_conexion) {
		String sDetalleIndice=" Parametros->";
		if(id_conexion!=null) {sDetalleIndice+=" Codigo Unico De Conexion="+id_conexion.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaBancoPunVen(Long id_cuenta_banco_pun_ven) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_banco_pun_ven!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Banco Pun Ven="+id_cuenta_banco_pun_ven.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContable(Long id_cuenta_contable) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Contable="+id_cuenta_contable.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEjercicio(Long id_ejercicio) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdFacturaPuntoVenta(Long id_factura_punto_venta) {
		String sDetalleIndice=" Parametros->";
		if(id_factura_punto_venta!=null) {sDetalleIndice+=" Codigo Unico De Factura Punto Venta="+id_factura_punto_venta.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMes(Long id_mes) {
		String sDetalleIndice=" Parametros->";
		if(id_mes!=null) {sDetalleIndice+=" Codigo Unico De Mes="+id_mes.toString();} 

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

	public static String getDetalleIndiceFK_IdTarjetaCredito(Long id_tarjeta_credito) {
		String sDetalleIndice=" Parametros->";
		if(id_tarjeta_credito!=null) {sDetalleIndice+=" Codigo Unico De Tarjeta Credito="+id_tarjeta_credito.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoFormaPago(Long id_tipo_forma_pago) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_forma_pago!=null) {sDetalleIndice+=" Codigo Unico De Tipo Forma Pago="+id_tipo_forma_pago.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoInteresTarjeta(Long id_tipo_interes_tarjeta) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_interes_tarjeta!=null) {sDetalleIndice+=" Codigo Unico De Tipo Interes Tarjeta="+id_tipo_interes_tarjeta.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoPagoTarjeta(Long id_tipo_pago_tarjeta) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_pago_tarjeta!=null) {sDetalleIndice+=" Codigo Unico De Tipo Pago Tarjeta="+id_tipo_pago_tarjeta.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoRiesgoCheque(Long id_tipo_riesgo_cheque) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_riesgo_cheque!=null) {sDetalleIndice+=" Codigo Unico De Tipo Riesgo Cheque="+id_tipo_riesgo_cheque.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosFormaPagoPuntoVenta(FormaPagoPuntoVenta formapagopuntoventa,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		formapagopuntoventa.setdescripcion(formapagopuntoventa.getdescripcion().trim());
		formapagopuntoventa.setnumero_cuenta(formapagopuntoventa.getnumero_cuenta().trim());
		formapagopuntoventa.setnumero_cheque(formapagopuntoventa.getnumero_cheque().trim());
		formapagopuntoventa.setgirador(formapagopuntoventa.getgirador().trim());
		formapagopuntoventa.setnumero(formapagopuntoventa.getnumero().trim());
		formapagopuntoventa.settarjeta_habiente(formapagopuntoventa.gettarjeta_habiente().trim());
		formapagopuntoventa.setautorizacion(formapagopuntoventa.getautorizacion().trim());
		formapagopuntoventa.setvoucher(formapagopuntoventa.getvoucher().trim());
		formapagopuntoventa.setlote(formapagopuntoventa.getlote().trim());
		formapagopuntoventa.setnumero_retencion(formapagopuntoventa.getnumero_retencion().trim());
		formapagopuntoventa.setnumero_liquidacion(formapagopuntoventa.getnumero_liquidacion().trim());
	}
	
	public static void quitarEspaciosFormaPagoPuntoVentas(List<FormaPagoPuntoVenta> formapagopuntoventas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(FormaPagoPuntoVenta formapagopuntoventa: formapagopuntoventas) {
			formapagopuntoventa.setdescripcion(formapagopuntoventa.getdescripcion().trim());
			formapagopuntoventa.setnumero_cuenta(formapagopuntoventa.getnumero_cuenta().trim());
			formapagopuntoventa.setnumero_cheque(formapagopuntoventa.getnumero_cheque().trim());
			formapagopuntoventa.setgirador(formapagopuntoventa.getgirador().trim());
			formapagopuntoventa.setnumero(formapagopuntoventa.getnumero().trim());
			formapagopuntoventa.settarjeta_habiente(formapagopuntoventa.gettarjeta_habiente().trim());
			formapagopuntoventa.setautorizacion(formapagopuntoventa.getautorizacion().trim());
			formapagopuntoventa.setvoucher(formapagopuntoventa.getvoucher().trim());
			formapagopuntoventa.setlote(formapagopuntoventa.getlote().trim());
			formapagopuntoventa.setnumero_retencion(formapagopuntoventa.getnumero_retencion().trim());
			formapagopuntoventa.setnumero_liquidacion(formapagopuntoventa.getnumero_liquidacion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresFormaPagoPuntoVenta(FormaPagoPuntoVenta formapagopuntoventa,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && formapagopuntoventa.getConCambioAuxiliar()) {
			formapagopuntoventa.setIsDeleted(formapagopuntoventa.getIsDeletedAuxiliar());	
			formapagopuntoventa.setIsNew(formapagopuntoventa.getIsNewAuxiliar());	
			formapagopuntoventa.setIsChanged(formapagopuntoventa.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			formapagopuntoventa.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			formapagopuntoventa.setIsDeletedAuxiliar(false);	
			formapagopuntoventa.setIsNewAuxiliar(false);	
			formapagopuntoventa.setIsChangedAuxiliar(false);
			
			formapagopuntoventa.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresFormaPagoPuntoVentas(List<FormaPagoPuntoVenta> formapagopuntoventas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(FormaPagoPuntoVenta formapagopuntoventa : formapagopuntoventas) {
			if(conAsignarBase && formapagopuntoventa.getConCambioAuxiliar()) {
				formapagopuntoventa.setIsDeleted(formapagopuntoventa.getIsDeletedAuxiliar());	
				formapagopuntoventa.setIsNew(formapagopuntoventa.getIsNewAuxiliar());	
				formapagopuntoventa.setIsChanged(formapagopuntoventa.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				formapagopuntoventa.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				formapagopuntoventa.setIsDeletedAuxiliar(false);	
				formapagopuntoventa.setIsNewAuxiliar(false);	
				formapagopuntoventa.setIsChangedAuxiliar(false);
				
				formapagopuntoventa.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresFormaPagoPuntoVenta(FormaPagoPuntoVenta formapagopuntoventa,Boolean conEnteros) throws Exception  {
		formapagopuntoventa.setporcentaje(0.0);
		formapagopuntoventa.setvalor(0.0);
		formapagopuntoventa.setvalor_retencion(0.0);
		formapagopuntoventa.setvalor_comision(0.0);
		formapagopuntoventa.setvalor_calculado(0.0);
		formapagopuntoventa.setvalor_cancelado(0.0);
		formapagopuntoventa.setvalor_difiere(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			formapagopuntoventa.setnumero_dias_plazo(0);
			formapagopuntoventa.setcuota(0);
		}
	}		
	
	public static void InicializarValoresFormaPagoPuntoVentas(List<FormaPagoPuntoVenta> formapagopuntoventas,Boolean conEnteros) throws Exception  {
		
		for(FormaPagoPuntoVenta formapagopuntoventa: formapagopuntoventas) {
			formapagopuntoventa.setporcentaje(0.0);
			formapagopuntoventa.setvalor(0.0);
			formapagopuntoventa.setvalor_retencion(0.0);
			formapagopuntoventa.setvalor_comision(0.0);
			formapagopuntoventa.setvalor_calculado(0.0);
			formapagopuntoventa.setvalor_cancelado(0.0);
			formapagopuntoventa.setvalor_difiere(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				formapagopuntoventa.setnumero_dias_plazo(0);
				formapagopuntoventa.setcuota(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaFormaPagoPuntoVenta(List<FormaPagoPuntoVenta> formapagopuntoventas,FormaPagoPuntoVenta formapagopuntoventaAux) throws Exception  {
		FormaPagoPuntoVentaConstantesFunciones.InicializarValoresFormaPagoPuntoVenta(formapagopuntoventaAux,true);
		
		for(FormaPagoPuntoVenta formapagopuntoventa: formapagopuntoventas) {
			if(formapagopuntoventa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			formapagopuntoventaAux.setporcentaje(formapagopuntoventaAux.getporcentaje()+formapagopuntoventa.getporcentaje());			
			formapagopuntoventaAux.setvalor(formapagopuntoventaAux.getvalor()+formapagopuntoventa.getvalor());			
			formapagopuntoventaAux.setnumero_dias_plazo(formapagopuntoventaAux.getnumero_dias_plazo()+formapagopuntoventa.getnumero_dias_plazo());			
			formapagopuntoventaAux.setcuota(formapagopuntoventaAux.getcuota()+formapagopuntoventa.getcuota());			
			formapagopuntoventaAux.setvalor_retencion(formapagopuntoventaAux.getvalor_retencion()+formapagopuntoventa.getvalor_retencion());			
			formapagopuntoventaAux.setvalor_comision(formapagopuntoventaAux.getvalor_comision()+formapagopuntoventa.getvalor_comision());			
			formapagopuntoventaAux.setvalor_calculado(formapagopuntoventaAux.getvalor_calculado()+formapagopuntoventa.getvalor_calculado());			
			formapagopuntoventaAux.setvalor_cancelado(formapagopuntoventaAux.getvalor_cancelado()+formapagopuntoventa.getvalor_cancelado());			
			formapagopuntoventaAux.setvalor_difiere(formapagopuntoventaAux.getvalor_difiere()+formapagopuntoventa.getvalor_difiere());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesFormaPagoPuntoVenta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=FormaPagoPuntoVentaConstantesFunciones.getArrayColumnasGlobalesFormaPagoPuntoVenta(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesFormaPagoPuntoVenta(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FormaPagoPuntoVentaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FormaPagoPuntoVentaConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FormaPagoPuntoVentaConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FormaPagoPuntoVentaConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FormaPagoPuntoVentaConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FormaPagoPuntoVentaConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FormaPagoPuntoVentaConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FormaPagoPuntoVentaConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoFormaPagoPuntoVenta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<FormaPagoPuntoVenta> formapagopuntoventas,FormaPagoPuntoVenta formapagopuntoventa,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(FormaPagoPuntoVenta formapagopuntoventaAux: formapagopuntoventas) {
			if(formapagopuntoventaAux!=null && formapagopuntoventa!=null) {
				if((formapagopuntoventaAux.getId()==null && formapagopuntoventa.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(formapagopuntoventaAux.getId()!=null && formapagopuntoventa.getId()!=null){
					if(formapagopuntoventaAux.getId().equals(formapagopuntoventa.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaFormaPagoPuntoVenta(List<FormaPagoPuntoVenta> formapagopuntoventas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double porcentajeTotal=0.0;
		Double valorTotal=0.0;
		Double valor_retencionTotal=0.0;
		Double valor_comisionTotal=0.0;
		Double valor_calculadoTotal=0.0;
		Double valor_canceladoTotal=0.0;
		Double valor_difiereTotal=0.0;
	
		for(FormaPagoPuntoVenta formapagopuntoventa: formapagopuntoventas) {			
			if(formapagopuntoventa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			porcentajeTotal+=formapagopuntoventa.getporcentaje();
			valorTotal+=formapagopuntoventa.getvalor();
			valor_retencionTotal+=formapagopuntoventa.getvalor_retencion();
			valor_comisionTotal+=formapagopuntoventa.getvalor_comision();
			valor_calculadoTotal+=formapagopuntoventa.getvalor_calculado();
			valor_canceladoTotal+=formapagopuntoventa.getvalor_cancelado();
			valor_difiereTotal+=formapagopuntoventa.getvalor_difiere();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FormaPagoPuntoVentaConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(FormaPagoPuntoVentaConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FormaPagoPuntoVentaConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(FormaPagoPuntoVentaConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FormaPagoPuntoVentaConstantesFunciones.VALORRETENCION);
		datoGeneral.setsDescripcion(FormaPagoPuntoVentaConstantesFunciones.LABEL_VALORRETENCION);
		datoGeneral.setdValorDouble(valor_retencionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FormaPagoPuntoVentaConstantesFunciones.VALORCOMISION);
		datoGeneral.setsDescripcion(FormaPagoPuntoVentaConstantesFunciones.LABEL_VALORCOMISION);
		datoGeneral.setdValorDouble(valor_comisionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FormaPagoPuntoVentaConstantesFunciones.VALORCALCULADO);
		datoGeneral.setsDescripcion(FormaPagoPuntoVentaConstantesFunciones.LABEL_VALORCALCULADO);
		datoGeneral.setdValorDouble(valor_calculadoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FormaPagoPuntoVentaConstantesFunciones.VALORCANCELADO);
		datoGeneral.setsDescripcion(FormaPagoPuntoVentaConstantesFunciones.LABEL_VALORCANCELADO);
		datoGeneral.setdValorDouble(valor_canceladoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FormaPagoPuntoVentaConstantesFunciones.VALORDIFIERE);
		datoGeneral.setsDescripcion(FormaPagoPuntoVentaConstantesFunciones.LABEL_VALORDIFIERE);
		datoGeneral.setdValorDouble(valor_difiereTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaFormaPagoPuntoVenta() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,FormaPagoPuntoVentaConstantesFunciones.LABEL_ID, FormaPagoPuntoVentaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoPuntoVentaConstantesFunciones.LABEL_VERSIONROW, FormaPagoPuntoVentaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoPuntoVentaConstantesFunciones.LABEL_IDEMPRESA, FormaPagoPuntoVentaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoPuntoVentaConstantesFunciones.LABEL_IDSUCURSAL, FormaPagoPuntoVentaConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoPuntoVentaConstantesFunciones.LABEL_IDEJERCICIO, FormaPagoPuntoVentaConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoPuntoVentaConstantesFunciones.LABEL_IDPERIODO, FormaPagoPuntoVentaConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoPuntoVentaConstantesFunciones.LABEL_IDFACTURAPUNTOVENTA, FormaPagoPuntoVentaConstantesFunciones.IDFACTURAPUNTOVENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoPuntoVentaConstantesFunciones.LABEL_IDTIPOFORMAPAGO, FormaPagoPuntoVentaConstantesFunciones.IDTIPOFORMAPAGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoPuntoVentaConstantesFunciones.LABEL_PORCENTAJE, FormaPagoPuntoVentaConstantesFunciones.PORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoPuntoVentaConstantesFunciones.LABEL_VALOR, FormaPagoPuntoVentaConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoPuntoVentaConstantesFunciones.LABEL_FECHA, FormaPagoPuntoVentaConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoPuntoVentaConstantesFunciones.LABEL_DESCRIPCION, FormaPagoPuntoVentaConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoPuntoVentaConstantesFunciones.LABEL_FECHAINICIO, FormaPagoPuntoVentaConstantesFunciones.FECHAINICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoPuntoVentaConstantesFunciones.LABEL_NUMERODIASPLAZO, FormaPagoPuntoVentaConstantesFunciones.NUMERODIASPLAZO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoPuntoVentaConstantesFunciones.LABEL_FECHAFIN, FormaPagoPuntoVentaConstantesFunciones.FECHAFIN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoPuntoVentaConstantesFunciones.LABEL_IDBANCO, FormaPagoPuntoVentaConstantesFunciones.IDBANCO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoPuntoVentaConstantesFunciones.LABEL_IDCUENTABANCOPUNVEN, FormaPagoPuntoVentaConstantesFunciones.IDCUENTABANCOPUNVEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoPuntoVentaConstantesFunciones.LABEL_IDTIPORIESGOCHEQUE, FormaPagoPuntoVentaConstantesFunciones.IDTIPORIESGOCHEQUE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoPuntoVentaConstantesFunciones.LABEL_NUMEROCUENTA, FormaPagoPuntoVentaConstantesFunciones.NUMEROCUENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoPuntoVentaConstantesFunciones.LABEL_NUMEROCHEQUE, FormaPagoPuntoVentaConstantesFunciones.NUMEROCHEQUE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoPuntoVentaConstantesFunciones.LABEL_GIRADOR, FormaPagoPuntoVentaConstantesFunciones.GIRADOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoPuntoVentaConstantesFunciones.LABEL_IDBANCOTARJETA, FormaPagoPuntoVentaConstantesFunciones.IDBANCOTARJETA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoPuntoVentaConstantesFunciones.LABEL_IDTARJETACREDITO, FormaPagoPuntoVentaConstantesFunciones.IDTARJETACREDITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoPuntoVentaConstantesFunciones.LABEL_IDTIPOINTERESTARJETA, FormaPagoPuntoVentaConstantesFunciones.IDTIPOINTERESTARJETA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoPuntoVentaConstantesFunciones.LABEL_IDTIPOPAGOTARJETA, FormaPagoPuntoVentaConstantesFunciones.IDTIPOPAGOTARJETA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoPuntoVentaConstantesFunciones.LABEL_IDCONEXION, FormaPagoPuntoVentaConstantesFunciones.IDCONEXION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoPuntoVentaConstantesFunciones.LABEL_IDMES, FormaPagoPuntoVentaConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoPuntoVentaConstantesFunciones.LABEL_NUMERO, FormaPagoPuntoVentaConstantesFunciones.NUMERO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoPuntoVentaConstantesFunciones.LABEL_TARJETAHABIENTE, FormaPagoPuntoVentaConstantesFunciones.TARJETAHABIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoPuntoVentaConstantesFunciones.LABEL_AUTORIZACION, FormaPagoPuntoVentaConstantesFunciones.AUTORIZACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoPuntoVentaConstantesFunciones.LABEL_VOUCHER, FormaPagoPuntoVentaConstantesFunciones.VOUCHER,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoPuntoVentaConstantesFunciones.LABEL_LOTE, FormaPagoPuntoVentaConstantesFunciones.LOTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoPuntoVentaConstantesFunciones.LABEL_CUOTA, FormaPagoPuntoVentaConstantesFunciones.CUOTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoPuntoVentaConstantesFunciones.LABEL_VALORRETENCION, FormaPagoPuntoVentaConstantesFunciones.VALORRETENCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoPuntoVentaConstantesFunciones.LABEL_VALORCOMISION, FormaPagoPuntoVentaConstantesFunciones.VALORCOMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoPuntoVentaConstantesFunciones.LABEL_VALORCALCULADO, FormaPagoPuntoVentaConstantesFunciones.VALORCALCULADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoPuntoVentaConstantesFunciones.LABEL_VALORCANCELADO, FormaPagoPuntoVentaConstantesFunciones.VALORCANCELADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoPuntoVentaConstantesFunciones.LABEL_VALORDIFIERE, FormaPagoPuntoVentaConstantesFunciones.VALORDIFIERE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoPuntoVentaConstantesFunciones.LABEL_NUMERORETENCION, FormaPagoPuntoVentaConstantesFunciones.NUMERORETENCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoPuntoVentaConstantesFunciones.LABEL_NUMEROLIQUIDACION, FormaPagoPuntoVentaConstantesFunciones.NUMEROLIQUIDACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoPuntoVentaConstantesFunciones.LABEL_IDANIO, FormaPagoPuntoVentaConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoPuntoVentaConstantesFunciones.LABEL_IDCUENTACONTABLE, FormaPagoPuntoVentaConstantesFunciones.IDCUENTACONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FormaPagoPuntoVentaConstantesFunciones.LABEL_IDASIENTOCONTABLE, FormaPagoPuntoVentaConstantesFunciones.IDASIENTOCONTABLE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasFormaPagoPuntoVenta() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=FormaPagoPuntoVentaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoPuntoVentaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoPuntoVentaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoPuntoVentaConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoPuntoVentaConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoPuntoVentaConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoPuntoVentaConstantesFunciones.IDFACTURAPUNTOVENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoPuntoVentaConstantesFunciones.IDTIPOFORMAPAGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoPuntoVentaConstantesFunciones.PORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoPuntoVentaConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoPuntoVentaConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoPuntoVentaConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoPuntoVentaConstantesFunciones.FECHAINICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoPuntoVentaConstantesFunciones.NUMERODIASPLAZO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoPuntoVentaConstantesFunciones.FECHAFIN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoPuntoVentaConstantesFunciones.IDBANCO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoPuntoVentaConstantesFunciones.IDCUENTABANCOPUNVEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoPuntoVentaConstantesFunciones.IDTIPORIESGOCHEQUE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoPuntoVentaConstantesFunciones.NUMEROCUENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoPuntoVentaConstantesFunciones.NUMEROCHEQUE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoPuntoVentaConstantesFunciones.GIRADOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoPuntoVentaConstantesFunciones.IDBANCOTARJETA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoPuntoVentaConstantesFunciones.IDTARJETACREDITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoPuntoVentaConstantesFunciones.IDTIPOINTERESTARJETA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoPuntoVentaConstantesFunciones.IDTIPOPAGOTARJETA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoPuntoVentaConstantesFunciones.IDCONEXION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoPuntoVentaConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoPuntoVentaConstantesFunciones.NUMERO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoPuntoVentaConstantesFunciones.TARJETAHABIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoPuntoVentaConstantesFunciones.AUTORIZACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoPuntoVentaConstantesFunciones.VOUCHER;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoPuntoVentaConstantesFunciones.LOTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoPuntoVentaConstantesFunciones.CUOTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoPuntoVentaConstantesFunciones.VALORRETENCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoPuntoVentaConstantesFunciones.VALORCOMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoPuntoVentaConstantesFunciones.VALORCALCULADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoPuntoVentaConstantesFunciones.VALORCANCELADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoPuntoVentaConstantesFunciones.VALORDIFIERE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoPuntoVentaConstantesFunciones.NUMERORETENCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoPuntoVentaConstantesFunciones.NUMEROLIQUIDACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoPuntoVentaConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoPuntoVentaConstantesFunciones.IDCUENTACONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FormaPagoPuntoVentaConstantesFunciones.IDASIENTOCONTABLE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFormaPagoPuntoVenta() throws Exception  {
		return FormaPagoPuntoVentaConstantesFunciones.getTiposSeleccionarFormaPagoPuntoVenta(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFormaPagoPuntoVenta(Boolean conFk) throws Exception  {
		return FormaPagoPuntoVentaConstantesFunciones.getTiposSeleccionarFormaPagoPuntoVenta(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFormaPagoPuntoVenta(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoPuntoVentaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(FormaPagoPuntoVentaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoPuntoVentaConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(FormaPagoPuntoVentaConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoPuntoVentaConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(FormaPagoPuntoVentaConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoPuntoVentaConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(FormaPagoPuntoVentaConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoPuntoVentaConstantesFunciones.LABEL_IDFACTURAPUNTOVENTA);
			reporte.setsDescripcion(FormaPagoPuntoVentaConstantesFunciones.LABEL_IDFACTURAPUNTOVENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoPuntoVentaConstantesFunciones.LABEL_IDTIPOFORMAPAGO);
			reporte.setsDescripcion(FormaPagoPuntoVentaConstantesFunciones.LABEL_IDTIPOFORMAPAGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoPuntoVentaConstantesFunciones.LABEL_PORCENTAJE);
			reporte.setsDescripcion(FormaPagoPuntoVentaConstantesFunciones.LABEL_PORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoPuntoVentaConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(FormaPagoPuntoVentaConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoPuntoVentaConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(FormaPagoPuntoVentaConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoPuntoVentaConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(FormaPagoPuntoVentaConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoPuntoVentaConstantesFunciones.LABEL_FECHAINICIO);
			reporte.setsDescripcion(FormaPagoPuntoVentaConstantesFunciones.LABEL_FECHAINICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoPuntoVentaConstantesFunciones.LABEL_NUMERODIASPLAZO);
			reporte.setsDescripcion(FormaPagoPuntoVentaConstantesFunciones.LABEL_NUMERODIASPLAZO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoPuntoVentaConstantesFunciones.LABEL_FECHAFIN);
			reporte.setsDescripcion(FormaPagoPuntoVentaConstantesFunciones.LABEL_FECHAFIN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoPuntoVentaConstantesFunciones.LABEL_IDBANCO);
			reporte.setsDescripcion(FormaPagoPuntoVentaConstantesFunciones.LABEL_IDBANCO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoPuntoVentaConstantesFunciones.LABEL_IDCUENTABANCOPUNVEN);
			reporte.setsDescripcion(FormaPagoPuntoVentaConstantesFunciones.LABEL_IDCUENTABANCOPUNVEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoPuntoVentaConstantesFunciones.LABEL_IDTIPORIESGOCHEQUE);
			reporte.setsDescripcion(FormaPagoPuntoVentaConstantesFunciones.LABEL_IDTIPORIESGOCHEQUE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoPuntoVentaConstantesFunciones.LABEL_NUMEROCUENTA);
			reporte.setsDescripcion(FormaPagoPuntoVentaConstantesFunciones.LABEL_NUMEROCUENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoPuntoVentaConstantesFunciones.LABEL_NUMEROCHEQUE);
			reporte.setsDescripcion(FormaPagoPuntoVentaConstantesFunciones.LABEL_NUMEROCHEQUE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoPuntoVentaConstantesFunciones.LABEL_GIRADOR);
			reporte.setsDescripcion(FormaPagoPuntoVentaConstantesFunciones.LABEL_GIRADOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoPuntoVentaConstantesFunciones.LABEL_IDBANCOTARJETA);
			reporte.setsDescripcion(FormaPagoPuntoVentaConstantesFunciones.LABEL_IDBANCOTARJETA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoPuntoVentaConstantesFunciones.LABEL_IDTARJETACREDITO);
			reporte.setsDescripcion(FormaPagoPuntoVentaConstantesFunciones.LABEL_IDTARJETACREDITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoPuntoVentaConstantesFunciones.LABEL_IDTIPOINTERESTARJETA);
			reporte.setsDescripcion(FormaPagoPuntoVentaConstantesFunciones.LABEL_IDTIPOINTERESTARJETA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoPuntoVentaConstantesFunciones.LABEL_IDTIPOPAGOTARJETA);
			reporte.setsDescripcion(FormaPagoPuntoVentaConstantesFunciones.LABEL_IDTIPOPAGOTARJETA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoPuntoVentaConstantesFunciones.LABEL_IDCONEXION);
			reporte.setsDescripcion(FormaPagoPuntoVentaConstantesFunciones.LABEL_IDCONEXION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoPuntoVentaConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(FormaPagoPuntoVentaConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoPuntoVentaConstantesFunciones.LABEL_NUMERO);
			reporte.setsDescripcion(FormaPagoPuntoVentaConstantesFunciones.LABEL_NUMERO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoPuntoVentaConstantesFunciones.LABEL_TARJETAHABIENTE);
			reporte.setsDescripcion(FormaPagoPuntoVentaConstantesFunciones.LABEL_TARJETAHABIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoPuntoVentaConstantesFunciones.LABEL_AUTORIZACION);
			reporte.setsDescripcion(FormaPagoPuntoVentaConstantesFunciones.LABEL_AUTORIZACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoPuntoVentaConstantesFunciones.LABEL_VOUCHER);
			reporte.setsDescripcion(FormaPagoPuntoVentaConstantesFunciones.LABEL_VOUCHER);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoPuntoVentaConstantesFunciones.LABEL_LOTE);
			reporte.setsDescripcion(FormaPagoPuntoVentaConstantesFunciones.LABEL_LOTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoPuntoVentaConstantesFunciones.LABEL_CUOTA);
			reporte.setsDescripcion(FormaPagoPuntoVentaConstantesFunciones.LABEL_CUOTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoPuntoVentaConstantesFunciones.LABEL_VALORRETENCION);
			reporte.setsDescripcion(FormaPagoPuntoVentaConstantesFunciones.LABEL_VALORRETENCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoPuntoVentaConstantesFunciones.LABEL_VALORCOMISION);
			reporte.setsDescripcion(FormaPagoPuntoVentaConstantesFunciones.LABEL_VALORCOMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoPuntoVentaConstantesFunciones.LABEL_VALORCALCULADO);
			reporte.setsDescripcion(FormaPagoPuntoVentaConstantesFunciones.LABEL_VALORCALCULADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoPuntoVentaConstantesFunciones.LABEL_VALORCANCELADO);
			reporte.setsDescripcion(FormaPagoPuntoVentaConstantesFunciones.LABEL_VALORCANCELADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoPuntoVentaConstantesFunciones.LABEL_VALORDIFIERE);
			reporte.setsDescripcion(FormaPagoPuntoVentaConstantesFunciones.LABEL_VALORDIFIERE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoPuntoVentaConstantesFunciones.LABEL_NUMERORETENCION);
			reporte.setsDescripcion(FormaPagoPuntoVentaConstantesFunciones.LABEL_NUMERORETENCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoPuntoVentaConstantesFunciones.LABEL_NUMEROLIQUIDACION);
			reporte.setsDescripcion(FormaPagoPuntoVentaConstantesFunciones.LABEL_NUMEROLIQUIDACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoPuntoVentaConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(FormaPagoPuntoVentaConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoPuntoVentaConstantesFunciones.LABEL_IDCUENTACONTABLE);
			reporte.setsDescripcion(FormaPagoPuntoVentaConstantesFunciones.LABEL_IDCUENTACONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FormaPagoPuntoVentaConstantesFunciones.LABEL_IDASIENTOCONTABLE);
			reporte.setsDescripcion(FormaPagoPuntoVentaConstantesFunciones.LABEL_IDASIENTOCONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesFormaPagoPuntoVenta(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesFormaPagoPuntoVenta(FormaPagoPuntoVenta formapagopuntoventaAux) throws Exception {
		
			formapagopuntoventaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(formapagopuntoventaAux.getEmpresa()));
			formapagopuntoventaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(formapagopuntoventaAux.getSucursal()));
			formapagopuntoventaAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(formapagopuntoventaAux.getEjercicio()));
			formapagopuntoventaAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(formapagopuntoventaAux.getPeriodo()));
			formapagopuntoventaAux.setfacturapuntoventa_descripcion(FacturaPuntoVentaConstantesFunciones.getFacturaPuntoVentaDescripcion(formapagopuntoventaAux.getFacturaPuntoVenta()));
			formapagopuntoventaAux.settipoformapago_descripcion(TipoFormaPagoConstantesFunciones.getTipoFormaPagoDescripcion(formapagopuntoventaAux.getTipoFormaPago()));
			formapagopuntoventaAux.setbanco_descripcion(BancoConstantesFunciones.getBancoDescripcion(formapagopuntoventaAux.getBanco()));
			formapagopuntoventaAux.setcuentabancopunven_descripcion(CuentaBancoPunVenConstantesFunciones.getCuentaBancoPunVenDescripcion(formapagopuntoventaAux.getCuentaBancoPunVen()));
			formapagopuntoventaAux.settiporiesgocheque_descripcion(TipoRiesgoChequeConstantesFunciones.getTipoRiesgoChequeDescripcion(formapagopuntoventaAux.getTipoRiesgoCheque()));
			formapagopuntoventaAux.setbancotarjeta_descripcion(BancoConstantesFunciones.getBancoDescripcion(formapagopuntoventaAux.getBancoTarjeta()));
			formapagopuntoventaAux.settarjetacredito_descripcion(TarjetaCreditoConstantesFunciones.getTarjetaCreditoDescripcion(formapagopuntoventaAux.getTarjetaCredito()));
			formapagopuntoventaAux.settipointerestarjeta_descripcion(TipoInteresTarjetaConstantesFunciones.getTipoInteresTarjetaDescripcion(formapagopuntoventaAux.getTipoInteresTarjeta()));
			formapagopuntoventaAux.settipopagotarjeta_descripcion(TipoPagoTarjetaConstantesFunciones.getTipoPagoTarjetaDescripcion(formapagopuntoventaAux.getTipoPagoTarjeta()));
			formapagopuntoventaAux.setconexion_descripcion(ConexionConstantesFunciones.getConexionDescripcion(formapagopuntoventaAux.getConexion()));
			formapagopuntoventaAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(formapagopuntoventaAux.getMes()));
			formapagopuntoventaAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(formapagopuntoventaAux.getAnio()));
			formapagopuntoventaAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(formapagopuntoventaAux.getCuentaContable()));
			formapagopuntoventaAux.setasientocontable_descripcion(AsientoContableConstantesFunciones.getAsientoContableDescripcion(formapagopuntoventaAux.getAsientoContable()));		
	}
	
	public static void refrescarForeignKeysDescripcionesFormaPagoPuntoVenta(List<FormaPagoPuntoVenta> formapagopuntoventasTemp) throws Exception {
		for(FormaPagoPuntoVenta formapagopuntoventaAux:formapagopuntoventasTemp) {
			
			formapagopuntoventaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(formapagopuntoventaAux.getEmpresa()));
			formapagopuntoventaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(formapagopuntoventaAux.getSucursal()));
			formapagopuntoventaAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(formapagopuntoventaAux.getEjercicio()));
			formapagopuntoventaAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(formapagopuntoventaAux.getPeriodo()));
			formapagopuntoventaAux.setfacturapuntoventa_descripcion(FacturaPuntoVentaConstantesFunciones.getFacturaPuntoVentaDescripcion(formapagopuntoventaAux.getFacturaPuntoVenta()));
			formapagopuntoventaAux.settipoformapago_descripcion(TipoFormaPagoConstantesFunciones.getTipoFormaPagoDescripcion(formapagopuntoventaAux.getTipoFormaPago()));
			formapagopuntoventaAux.setbanco_descripcion(BancoConstantesFunciones.getBancoDescripcion(formapagopuntoventaAux.getBanco()));
			formapagopuntoventaAux.setcuentabancopunven_descripcion(CuentaBancoPunVenConstantesFunciones.getCuentaBancoPunVenDescripcion(formapagopuntoventaAux.getCuentaBancoPunVen()));
			formapagopuntoventaAux.settiporiesgocheque_descripcion(TipoRiesgoChequeConstantesFunciones.getTipoRiesgoChequeDescripcion(formapagopuntoventaAux.getTipoRiesgoCheque()));
			formapagopuntoventaAux.setbancotarjeta_descripcion(BancoConstantesFunciones.getBancoDescripcion(formapagopuntoventaAux.getBancoTarjeta()));
			formapagopuntoventaAux.settarjetacredito_descripcion(TarjetaCreditoConstantesFunciones.getTarjetaCreditoDescripcion(formapagopuntoventaAux.getTarjetaCredito()));
			formapagopuntoventaAux.settipointerestarjeta_descripcion(TipoInteresTarjetaConstantesFunciones.getTipoInteresTarjetaDescripcion(formapagopuntoventaAux.getTipoInteresTarjeta()));
			formapagopuntoventaAux.settipopagotarjeta_descripcion(TipoPagoTarjetaConstantesFunciones.getTipoPagoTarjetaDescripcion(formapagopuntoventaAux.getTipoPagoTarjeta()));
			formapagopuntoventaAux.setconexion_descripcion(ConexionConstantesFunciones.getConexionDescripcion(formapagopuntoventaAux.getConexion()));
			formapagopuntoventaAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(formapagopuntoventaAux.getMes()));
			formapagopuntoventaAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(formapagopuntoventaAux.getAnio()));
			formapagopuntoventaAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(formapagopuntoventaAux.getCuentaContable()));
			formapagopuntoventaAux.setasientocontable_descripcion(AsientoContableConstantesFunciones.getAsientoContableDescripcion(formapagopuntoventaAux.getAsientoContable()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfFormaPagoPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(FacturaPuntoVenta.class));
				classes.add(new Classe(TipoFormaPago.class));
				classes.add(new Classe(Banco.class));
				classes.add(new Classe(CuentaBancoPunVen.class));
				classes.add(new Classe(TipoRiesgoCheque.class));
				classes.add(new Classe(Banco.class));
				classes.add(new Classe(TarjetaCredito.class));
				classes.add(new Classe(TipoInteresTarjeta.class));
				classes.add(new Classe(TipoPagoTarjeta.class));
				classes.add(new Classe(Conexion.class));
				classes.add(new Classe(Mes.class));
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(AsientoContable.class));
				
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
					if(clas.clas.equals(FacturaPuntoVenta.class)) {
						classes.add(new Classe(FacturaPuntoVenta.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoFormaPago.class)) {
						classes.add(new Classe(TipoFormaPago.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Banco.class)) {
						classes.add(new Classe(Banco.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaBancoPunVen.class)) {
						classes.add(new Classe(CuentaBancoPunVen.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoRiesgoCheque.class)) {
						classes.add(new Classe(TipoRiesgoCheque.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Banco.class)) {
						classes.add(new Classe(Banco.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TarjetaCredito.class)) {
						classes.add(new Classe(TarjetaCredito.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoInteresTarjeta.class)) {
						classes.add(new Classe(TipoInteresTarjeta.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoPagoTarjeta.class)) {
						classes.add(new Classe(TipoPagoTarjeta.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Conexion.class)) {
						classes.add(new Classe(Conexion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Mes.class)) {
						classes.add(new Classe(Mes.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Anio.class)) {
						classes.add(new Classe(Anio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(AsientoContable.class)) {
						classes.add(new Classe(AsientoContable.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfFormaPagoPuntoVenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(FacturaPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FacturaPuntoVenta.class)); continue;
					}

					if(TipoFormaPago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoFormaPago.class)); continue;
					}

					if(Banco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Banco.class)); continue;
					}

					if(CuentaBancoPunVen.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaBancoPunVen.class)); continue;
					}

					if(TipoRiesgoCheque.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRiesgoCheque.class)); continue;
					}

					if(Banco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Banco.class)); continue;
					}

					if(TarjetaCredito.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TarjetaCredito.class)); continue;
					}

					if(TipoInteresTarjeta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoInteresTarjeta.class)); continue;
					}

					if(TipoPagoTarjeta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoPagoTarjeta.class)); continue;
					}

					if(Conexion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Conexion.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(AsientoContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsientoContable.class)); continue;
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

					if(FacturaPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FacturaPuntoVenta.class)); continue;
					}

					if(TipoFormaPago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoFormaPago.class)); continue;
					}

					if(Banco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Banco.class)); continue;
					}

					if(CuentaBancoPunVen.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaBancoPunVen.class)); continue;
					}

					if(TipoRiesgoCheque.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRiesgoCheque.class)); continue;
					}

					if(Banco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Banco.class)); continue;
					}

					if(TarjetaCredito.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TarjetaCredito.class)); continue;
					}

					if(TipoInteresTarjeta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoInteresTarjeta.class)); continue;
					}

					if(TipoPagoTarjeta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoPagoTarjeta.class)); continue;
					}

					if(Conexion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Conexion.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(AsientoContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsientoContable.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfFormaPagoPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return FormaPagoPuntoVentaConstantesFunciones.getClassesRelationshipsOfFormaPagoPuntoVenta(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfFormaPagoPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfFormaPagoPuntoVenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return FormaPagoPuntoVentaConstantesFunciones.getClassesRelationshipsFromStringsOfFormaPagoPuntoVenta(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfFormaPagoPuntoVenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(FormaPagoPuntoVenta formapagopuntoventa,List<FormaPagoPuntoVenta> formapagopuntoventas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			FormaPagoPuntoVenta formapagopuntoventaEncontrado=null;
			
			for(FormaPagoPuntoVenta formapagopuntoventaLocal:formapagopuntoventas) {
				if(formapagopuntoventaLocal.getId().equals(formapagopuntoventa.getId())) {
					formapagopuntoventaEncontrado=formapagopuntoventaLocal;
					
					formapagopuntoventaLocal.setIsChanged(formapagopuntoventa.getIsChanged());
					formapagopuntoventaLocal.setIsNew(formapagopuntoventa.getIsNew());
					formapagopuntoventaLocal.setIsDeleted(formapagopuntoventa.getIsDeleted());
					
					formapagopuntoventaLocal.setGeneralEntityOriginal(formapagopuntoventa.getGeneralEntityOriginal());
					
					formapagopuntoventaLocal.setId(formapagopuntoventa.getId());	
					formapagopuntoventaLocal.setVersionRow(formapagopuntoventa.getVersionRow());	
					formapagopuntoventaLocal.setid_empresa(formapagopuntoventa.getid_empresa());	
					formapagopuntoventaLocal.setid_sucursal(formapagopuntoventa.getid_sucursal());	
					formapagopuntoventaLocal.setid_ejercicio(formapagopuntoventa.getid_ejercicio());	
					formapagopuntoventaLocal.setid_periodo(formapagopuntoventa.getid_periodo());	
					formapagopuntoventaLocal.setid_factura_punto_venta(formapagopuntoventa.getid_factura_punto_venta());	
					formapagopuntoventaLocal.setid_tipo_forma_pago(formapagopuntoventa.getid_tipo_forma_pago());	
					formapagopuntoventaLocal.setporcentaje(formapagopuntoventa.getporcentaje());	
					formapagopuntoventaLocal.setvalor(formapagopuntoventa.getvalor());	
					formapagopuntoventaLocal.setfecha(formapagopuntoventa.getfecha());	
					formapagopuntoventaLocal.setdescripcion(formapagopuntoventa.getdescripcion());	
					formapagopuntoventaLocal.setfecha_inicio(formapagopuntoventa.getfecha_inicio());	
					formapagopuntoventaLocal.setnumero_dias_plazo(formapagopuntoventa.getnumero_dias_plazo());	
					formapagopuntoventaLocal.setfecha_fin(formapagopuntoventa.getfecha_fin());	
					formapagopuntoventaLocal.setid_banco(formapagopuntoventa.getid_banco());	
					formapagopuntoventaLocal.setid_cuenta_banco_pun_ven(formapagopuntoventa.getid_cuenta_banco_pun_ven());	
					formapagopuntoventaLocal.setid_tipo_riesgo_cheque(formapagopuntoventa.getid_tipo_riesgo_cheque());	
					formapagopuntoventaLocal.setnumero_cuenta(formapagopuntoventa.getnumero_cuenta());	
					formapagopuntoventaLocal.setnumero_cheque(formapagopuntoventa.getnumero_cheque());	
					formapagopuntoventaLocal.setgirador(formapagopuntoventa.getgirador());	
					formapagopuntoventaLocal.setid_banco_tarjeta(formapagopuntoventa.getid_banco_tarjeta());	
					formapagopuntoventaLocal.setid_tarjeta_credito(formapagopuntoventa.getid_tarjeta_credito());	
					formapagopuntoventaLocal.setid_tipo_interes_tarjeta(formapagopuntoventa.getid_tipo_interes_tarjeta());	
					formapagopuntoventaLocal.setid_tipo_pago_tarjeta(formapagopuntoventa.getid_tipo_pago_tarjeta());	
					formapagopuntoventaLocal.setid_conexion(formapagopuntoventa.getid_conexion());	
					formapagopuntoventaLocal.setid_mes(formapagopuntoventa.getid_mes());	
					formapagopuntoventaLocal.setnumero(formapagopuntoventa.getnumero());	
					formapagopuntoventaLocal.settarjeta_habiente(formapagopuntoventa.gettarjeta_habiente());	
					formapagopuntoventaLocal.setautorizacion(formapagopuntoventa.getautorizacion());	
					formapagopuntoventaLocal.setvoucher(formapagopuntoventa.getvoucher());	
					formapagopuntoventaLocal.setlote(formapagopuntoventa.getlote());	
					formapagopuntoventaLocal.setcuota(formapagopuntoventa.getcuota());	
					formapagopuntoventaLocal.setvalor_retencion(formapagopuntoventa.getvalor_retencion());	
					formapagopuntoventaLocal.setvalor_comision(formapagopuntoventa.getvalor_comision());	
					formapagopuntoventaLocal.setvalor_calculado(formapagopuntoventa.getvalor_calculado());	
					formapagopuntoventaLocal.setvalor_cancelado(formapagopuntoventa.getvalor_cancelado());	
					formapagopuntoventaLocal.setvalor_difiere(formapagopuntoventa.getvalor_difiere());	
					formapagopuntoventaLocal.setnumero_retencion(formapagopuntoventa.getnumero_retencion());	
					formapagopuntoventaLocal.setnumero_liquidacion(formapagopuntoventa.getnumero_liquidacion());	
					formapagopuntoventaLocal.setid_anio(formapagopuntoventa.getid_anio());	
					formapagopuntoventaLocal.setid_cuenta_contable(formapagopuntoventa.getid_cuenta_contable());	
					formapagopuntoventaLocal.setid_asiento_contable(formapagopuntoventa.getid_asiento_contable());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!formapagopuntoventa.getIsDeleted()) {
				if(!existe) {
					formapagopuntoventas.add(formapagopuntoventa);
				}
			} else {
				if(formapagopuntoventaEncontrado!=null && permiteQuitar)  {
					formapagopuntoventas.remove(formapagopuntoventaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(FormaPagoPuntoVenta formapagopuntoventa,List<FormaPagoPuntoVenta> formapagopuntoventas) throws Exception {
		try	{			
			for(FormaPagoPuntoVenta formapagopuntoventaLocal:formapagopuntoventas) {
				if(formapagopuntoventaLocal.getId().equals(formapagopuntoventa.getId())) {
					formapagopuntoventaLocal.setIsSelected(formapagopuntoventa.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesFormaPagoPuntoVenta(List<FormaPagoPuntoVenta> formapagopuntoventasAux) throws Exception {
		//this.formapagopuntoventasAux=formapagopuntoventasAux;
		
		for(FormaPagoPuntoVenta formapagopuntoventaAux:formapagopuntoventasAux) {
			if(formapagopuntoventaAux.getIsChanged()) {
				formapagopuntoventaAux.setIsChanged(false);
			}		
			
			if(formapagopuntoventaAux.getIsNew()) {
				formapagopuntoventaAux.setIsNew(false);
			}	
			
			if(formapagopuntoventaAux.getIsDeleted()) {
				formapagopuntoventaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesFormaPagoPuntoVenta(FormaPagoPuntoVenta formapagopuntoventaAux) throws Exception {
		//this.formapagopuntoventaAux=formapagopuntoventaAux;
		
			if(formapagopuntoventaAux.getIsChanged()) {
				formapagopuntoventaAux.setIsChanged(false);
			}		
			
			if(formapagopuntoventaAux.getIsNew()) {
				formapagopuntoventaAux.setIsNew(false);
			}	
			
			if(formapagopuntoventaAux.getIsDeleted()) {
				formapagopuntoventaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(FormaPagoPuntoVenta formapagopuntoventaAsignar,FormaPagoPuntoVenta formapagopuntoventa) throws Exception {
		formapagopuntoventaAsignar.setId(formapagopuntoventa.getId());	
		formapagopuntoventaAsignar.setVersionRow(formapagopuntoventa.getVersionRow());	
		formapagopuntoventaAsignar.setid_empresa(formapagopuntoventa.getid_empresa());
		formapagopuntoventaAsignar.setempresa_descripcion(formapagopuntoventa.getempresa_descripcion());	
		formapagopuntoventaAsignar.setid_sucursal(formapagopuntoventa.getid_sucursal());
		formapagopuntoventaAsignar.setsucursal_descripcion(formapagopuntoventa.getsucursal_descripcion());	
		formapagopuntoventaAsignar.setid_ejercicio(formapagopuntoventa.getid_ejercicio());
		formapagopuntoventaAsignar.setejercicio_descripcion(formapagopuntoventa.getejercicio_descripcion());	
		formapagopuntoventaAsignar.setid_periodo(formapagopuntoventa.getid_periodo());
		formapagopuntoventaAsignar.setperiodo_descripcion(formapagopuntoventa.getperiodo_descripcion());	
		formapagopuntoventaAsignar.setid_factura_punto_venta(formapagopuntoventa.getid_factura_punto_venta());
		formapagopuntoventaAsignar.setfacturapuntoventa_descripcion(formapagopuntoventa.getfacturapuntoventa_descripcion());	
		formapagopuntoventaAsignar.setid_tipo_forma_pago(formapagopuntoventa.getid_tipo_forma_pago());
		formapagopuntoventaAsignar.settipoformapago_descripcion(formapagopuntoventa.gettipoformapago_descripcion());	
		formapagopuntoventaAsignar.setporcentaje(formapagopuntoventa.getporcentaje());	
		formapagopuntoventaAsignar.setvalor(formapagopuntoventa.getvalor());	
		formapagopuntoventaAsignar.setfecha(formapagopuntoventa.getfecha());	
		formapagopuntoventaAsignar.setdescripcion(formapagopuntoventa.getdescripcion());	
		formapagopuntoventaAsignar.setfecha_inicio(formapagopuntoventa.getfecha_inicio());	
		formapagopuntoventaAsignar.setnumero_dias_plazo(formapagopuntoventa.getnumero_dias_plazo());	
		formapagopuntoventaAsignar.setfecha_fin(formapagopuntoventa.getfecha_fin());	
		formapagopuntoventaAsignar.setid_banco(formapagopuntoventa.getid_banco());
		formapagopuntoventaAsignar.setbanco_descripcion(formapagopuntoventa.getbanco_descripcion());	
		formapagopuntoventaAsignar.setid_cuenta_banco_pun_ven(formapagopuntoventa.getid_cuenta_banco_pun_ven());
		formapagopuntoventaAsignar.setcuentabancopunven_descripcion(formapagopuntoventa.getcuentabancopunven_descripcion());	
		formapagopuntoventaAsignar.setid_tipo_riesgo_cheque(formapagopuntoventa.getid_tipo_riesgo_cheque());
		formapagopuntoventaAsignar.settiporiesgocheque_descripcion(formapagopuntoventa.gettiporiesgocheque_descripcion());	
		formapagopuntoventaAsignar.setnumero_cuenta(formapagopuntoventa.getnumero_cuenta());	
		formapagopuntoventaAsignar.setnumero_cheque(formapagopuntoventa.getnumero_cheque());	
		formapagopuntoventaAsignar.setgirador(formapagopuntoventa.getgirador());	
		formapagopuntoventaAsignar.setid_banco_tarjeta(formapagopuntoventa.getid_banco_tarjeta());
		formapagopuntoventaAsignar.setbancotarjeta_descripcion(formapagopuntoventa.getbancotarjeta_descripcion());	
		formapagopuntoventaAsignar.setid_tarjeta_credito(formapagopuntoventa.getid_tarjeta_credito());
		formapagopuntoventaAsignar.settarjetacredito_descripcion(formapagopuntoventa.gettarjetacredito_descripcion());	
		formapagopuntoventaAsignar.setid_tipo_interes_tarjeta(formapagopuntoventa.getid_tipo_interes_tarjeta());
		formapagopuntoventaAsignar.settipointerestarjeta_descripcion(formapagopuntoventa.gettipointerestarjeta_descripcion());	
		formapagopuntoventaAsignar.setid_tipo_pago_tarjeta(formapagopuntoventa.getid_tipo_pago_tarjeta());
		formapagopuntoventaAsignar.settipopagotarjeta_descripcion(formapagopuntoventa.gettipopagotarjeta_descripcion());	
		formapagopuntoventaAsignar.setid_conexion(formapagopuntoventa.getid_conexion());
		formapagopuntoventaAsignar.setconexion_descripcion(formapagopuntoventa.getconexion_descripcion());	
		formapagopuntoventaAsignar.setid_mes(formapagopuntoventa.getid_mes());
		formapagopuntoventaAsignar.setmes_descripcion(formapagopuntoventa.getmes_descripcion());	
		formapagopuntoventaAsignar.setnumero(formapagopuntoventa.getnumero());	
		formapagopuntoventaAsignar.settarjeta_habiente(formapagopuntoventa.gettarjeta_habiente());	
		formapagopuntoventaAsignar.setautorizacion(formapagopuntoventa.getautorizacion());	
		formapagopuntoventaAsignar.setvoucher(formapagopuntoventa.getvoucher());	
		formapagopuntoventaAsignar.setlote(formapagopuntoventa.getlote());	
		formapagopuntoventaAsignar.setcuota(formapagopuntoventa.getcuota());	
		formapagopuntoventaAsignar.setvalor_retencion(formapagopuntoventa.getvalor_retencion());	
		formapagopuntoventaAsignar.setvalor_comision(formapagopuntoventa.getvalor_comision());	
		formapagopuntoventaAsignar.setvalor_calculado(formapagopuntoventa.getvalor_calculado());	
		formapagopuntoventaAsignar.setvalor_cancelado(formapagopuntoventa.getvalor_cancelado());	
		formapagopuntoventaAsignar.setvalor_difiere(formapagopuntoventa.getvalor_difiere());	
		formapagopuntoventaAsignar.setnumero_retencion(formapagopuntoventa.getnumero_retencion());	
		formapagopuntoventaAsignar.setnumero_liquidacion(formapagopuntoventa.getnumero_liquidacion());	
		formapagopuntoventaAsignar.setid_anio(formapagopuntoventa.getid_anio());
		formapagopuntoventaAsignar.setanio_descripcion(formapagopuntoventa.getanio_descripcion());	
		formapagopuntoventaAsignar.setid_cuenta_contable(formapagopuntoventa.getid_cuenta_contable());
		formapagopuntoventaAsignar.setcuentacontable_descripcion(formapagopuntoventa.getcuentacontable_descripcion());	
		formapagopuntoventaAsignar.setid_asiento_contable(formapagopuntoventa.getid_asiento_contable());
		formapagopuntoventaAsignar.setasientocontable_descripcion(formapagopuntoventa.getasientocontable_descripcion());	
	}
	
	public static void inicializarFormaPagoPuntoVenta(FormaPagoPuntoVenta formapagopuntoventa) throws Exception {
		try {
				formapagopuntoventa.setId(0L);	
					
				formapagopuntoventa.setid_empresa(-1L);	
				formapagopuntoventa.setid_sucursal(-1L);	
				formapagopuntoventa.setid_ejercicio(-1L);	
				formapagopuntoventa.setid_periodo(-1L);	
				formapagopuntoventa.setid_factura_punto_venta(-1L);	
				formapagopuntoventa.setid_tipo_forma_pago(-1L);	
				formapagopuntoventa.setporcentaje(0.0);	
				formapagopuntoventa.setvalor(0.0);	
				formapagopuntoventa.setfecha(new Date());	
				formapagopuntoventa.setdescripcion("");	
				formapagopuntoventa.setfecha_inicio(new Date());	
				formapagopuntoventa.setnumero_dias_plazo(0);	
				formapagopuntoventa.setfecha_fin(new Date());	
				formapagopuntoventa.setid_banco(null);	
				formapagopuntoventa.setid_cuenta_banco_pun_ven(null);	
				formapagopuntoventa.setid_tipo_riesgo_cheque(null);	
				formapagopuntoventa.setnumero_cuenta("");	
				formapagopuntoventa.setnumero_cheque("");	
				formapagopuntoventa.setgirador("");	
				formapagopuntoventa.setid_banco_tarjeta(null);	
				formapagopuntoventa.setid_tarjeta_credito(null);	
				formapagopuntoventa.setid_tipo_interes_tarjeta(null);	
				formapagopuntoventa.setid_tipo_pago_tarjeta(null);	
				formapagopuntoventa.setid_conexion(null);	
				formapagopuntoventa.setid_mes(null);	
				formapagopuntoventa.setnumero("");	
				formapagopuntoventa.settarjeta_habiente("");	
				formapagopuntoventa.setautorizacion("");	
				formapagopuntoventa.setvoucher("");	
				formapagopuntoventa.setlote("");	
				formapagopuntoventa.setcuota(0);	
				formapagopuntoventa.setvalor_retencion(0.0);	
				formapagopuntoventa.setvalor_comision(0.0);	
				formapagopuntoventa.setvalor_calculado(0.0);	
				formapagopuntoventa.setvalor_cancelado(0.0);	
				formapagopuntoventa.setvalor_difiere(0.0);	
				formapagopuntoventa.setnumero_retencion("");	
				formapagopuntoventa.setnumero_liquidacion("");	
				formapagopuntoventa.setid_anio(null);	
				formapagopuntoventa.setid_cuenta_contable(null);	
				formapagopuntoventa.setid_asiento_contable(null);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderFormaPagoPuntoVenta(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoPuntoVentaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoPuntoVentaConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoPuntoVentaConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoPuntoVentaConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoPuntoVentaConstantesFunciones.LABEL_IDFACTURAPUNTOVENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoPuntoVentaConstantesFunciones.LABEL_IDTIPOFORMAPAGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoPuntoVentaConstantesFunciones.LABEL_PORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoPuntoVentaConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoPuntoVentaConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoPuntoVentaConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoPuntoVentaConstantesFunciones.LABEL_FECHAINICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoPuntoVentaConstantesFunciones.LABEL_NUMERODIASPLAZO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoPuntoVentaConstantesFunciones.LABEL_FECHAFIN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoPuntoVentaConstantesFunciones.LABEL_IDBANCO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoPuntoVentaConstantesFunciones.LABEL_IDCUENTABANCOPUNVEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoPuntoVentaConstantesFunciones.LABEL_IDTIPORIESGOCHEQUE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoPuntoVentaConstantesFunciones.LABEL_NUMEROCUENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoPuntoVentaConstantesFunciones.LABEL_NUMEROCHEQUE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoPuntoVentaConstantesFunciones.LABEL_GIRADOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoPuntoVentaConstantesFunciones.LABEL_IDBANCOTARJETA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoPuntoVentaConstantesFunciones.LABEL_IDTARJETACREDITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoPuntoVentaConstantesFunciones.LABEL_IDTIPOINTERESTARJETA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoPuntoVentaConstantesFunciones.LABEL_IDTIPOPAGOTARJETA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoPuntoVentaConstantesFunciones.LABEL_IDCONEXION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoPuntoVentaConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoPuntoVentaConstantesFunciones.LABEL_NUMERO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoPuntoVentaConstantesFunciones.LABEL_TARJETAHABIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoPuntoVentaConstantesFunciones.LABEL_AUTORIZACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoPuntoVentaConstantesFunciones.LABEL_VOUCHER);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoPuntoVentaConstantesFunciones.LABEL_LOTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoPuntoVentaConstantesFunciones.LABEL_CUOTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoPuntoVentaConstantesFunciones.LABEL_VALORRETENCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoPuntoVentaConstantesFunciones.LABEL_VALORCOMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoPuntoVentaConstantesFunciones.LABEL_VALORCALCULADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoPuntoVentaConstantesFunciones.LABEL_VALORCANCELADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoPuntoVentaConstantesFunciones.LABEL_VALORDIFIERE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoPuntoVentaConstantesFunciones.LABEL_NUMERORETENCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoPuntoVentaConstantesFunciones.LABEL_NUMEROLIQUIDACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoPuntoVentaConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoPuntoVentaConstantesFunciones.LABEL_IDCUENTACONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FormaPagoPuntoVentaConstantesFunciones.LABEL_IDASIENTOCONTABLE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataFormaPagoPuntoVenta(String sTipo,Row row,Workbook workbook,FormaPagoPuntoVenta formapagopuntoventa,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(formapagopuntoventa.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapagopuntoventa.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapagopuntoventa.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapagopuntoventa.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapagopuntoventa.getfacturapuntoventa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapagopuntoventa.gettipoformapago_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapagopuntoventa.getporcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapagopuntoventa.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapagopuntoventa.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapagopuntoventa.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapagopuntoventa.getfecha_inicio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapagopuntoventa.getnumero_dias_plazo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapagopuntoventa.getfecha_fin());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapagopuntoventa.getbanco_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapagopuntoventa.getcuentabancopunven_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapagopuntoventa.gettiporiesgocheque_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapagopuntoventa.getnumero_cuenta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapagopuntoventa.getnumero_cheque());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapagopuntoventa.getgirador());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapagopuntoventa.getbancotarjeta_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapagopuntoventa.gettarjetacredito_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapagopuntoventa.gettipointerestarjeta_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapagopuntoventa.gettipopagotarjeta_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapagopuntoventa.getconexion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapagopuntoventa.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapagopuntoventa.getnumero());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapagopuntoventa.gettarjeta_habiente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapagopuntoventa.getautorizacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapagopuntoventa.getvoucher());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapagopuntoventa.getlote());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapagopuntoventa.getcuota());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapagopuntoventa.getvalor_retencion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapagopuntoventa.getvalor_comision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapagopuntoventa.getvalor_calculado());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapagopuntoventa.getvalor_cancelado());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapagopuntoventa.getvalor_difiere());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapagopuntoventa.getnumero_retencion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapagopuntoventa.getnumero_liquidacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapagopuntoventa.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapagopuntoventa.getcuentacontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(formapagopuntoventa.getasientocontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryFormaPagoPuntoVenta=Constantes.SFINALQUERY;
	
	public String getsFinalQueryFormaPagoPuntoVenta() {
		return this.sFinalQueryFormaPagoPuntoVenta;
	}
	
	public void setsFinalQueryFormaPagoPuntoVenta(String sFinalQueryFormaPagoPuntoVenta) {
		this.sFinalQueryFormaPagoPuntoVenta= sFinalQueryFormaPagoPuntoVenta;
	}
	
	public Border resaltarSeleccionarFormaPagoPuntoVenta=null;
	
	public Border setResaltarSeleccionarFormaPagoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoPuntoVentaBeanSwingJInternalFrame formapagopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		/*
		//formapagopuntoventaBeanSwingJInternalFrame.jTtoolBarFormaPagoPuntoVenta.setBorder(borderResaltar);
		*/
		this.resaltarSeleccionarFormaPagoPuntoVenta= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarFormaPagoPuntoVenta() {
		return this.resaltarSeleccionarFormaPagoPuntoVenta;
	}
	
	public void setResaltarSeleccionarFormaPagoPuntoVenta(Border borderResaltarSeleccionarFormaPagoPuntoVenta) {
		this.resaltarSeleccionarFormaPagoPuntoVenta= borderResaltarSeleccionarFormaPagoPuntoVenta;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridFormaPagoPuntoVenta=null;
	public Boolean mostraridFormaPagoPuntoVenta=true;
	public Boolean activaridFormaPagoPuntoVenta=true;

	public Border resaltarid_empresaFormaPagoPuntoVenta=null;
	public Boolean mostrarid_empresaFormaPagoPuntoVenta=true;
	public Boolean activarid_empresaFormaPagoPuntoVenta=true;
	public Boolean cargarid_empresaFormaPagoPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaFormaPagoPuntoVenta=false;//ConEventDepend=true

	public Border resaltarid_sucursalFormaPagoPuntoVenta=null;
	public Boolean mostrarid_sucursalFormaPagoPuntoVenta=true;
	public Boolean activarid_sucursalFormaPagoPuntoVenta=true;
	public Boolean cargarid_sucursalFormaPagoPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalFormaPagoPuntoVenta=false;//ConEventDepend=true

	public Border resaltarid_ejercicioFormaPagoPuntoVenta=null;
	public Boolean mostrarid_ejercicioFormaPagoPuntoVenta=true;
	public Boolean activarid_ejercicioFormaPagoPuntoVenta=true;
	public Boolean cargarid_ejercicioFormaPagoPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioFormaPagoPuntoVenta=false;//ConEventDepend=true

	public Border resaltarid_periodoFormaPagoPuntoVenta=null;
	public Boolean mostrarid_periodoFormaPagoPuntoVenta=true;
	public Boolean activarid_periodoFormaPagoPuntoVenta=true;
	public Boolean cargarid_periodoFormaPagoPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoFormaPagoPuntoVenta=false;//ConEventDepend=true

	public Border resaltarid_factura_punto_ventaFormaPagoPuntoVenta=null;
	public Boolean mostrarid_factura_punto_ventaFormaPagoPuntoVenta=true;
	public Boolean activarid_factura_punto_ventaFormaPagoPuntoVenta=true;
	public Boolean cargarid_factura_punto_ventaFormaPagoPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_factura_punto_ventaFormaPagoPuntoVenta=false;//ConEventDepend=true

	public Border resaltarid_tipo_forma_pagoFormaPagoPuntoVenta=null;
	public Boolean mostrarid_tipo_forma_pagoFormaPagoPuntoVenta=true;
	public Boolean activarid_tipo_forma_pagoFormaPagoPuntoVenta=true;
	public Boolean cargarid_tipo_forma_pagoFormaPagoPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_forma_pagoFormaPagoPuntoVenta=false;//ConEventDepend=true

	public Border resaltarporcentajeFormaPagoPuntoVenta=null;
	public Boolean mostrarporcentajeFormaPagoPuntoVenta=true;
	public Boolean activarporcentajeFormaPagoPuntoVenta=true;

	public Border resaltarvalorFormaPagoPuntoVenta=null;
	public Boolean mostrarvalorFormaPagoPuntoVenta=true;
	public Boolean activarvalorFormaPagoPuntoVenta=true;

	public Border resaltarfechaFormaPagoPuntoVenta=null;
	public Boolean mostrarfechaFormaPagoPuntoVenta=true;
	public Boolean activarfechaFormaPagoPuntoVenta=false;

	public Border resaltardescripcionFormaPagoPuntoVenta=null;
	public Boolean mostrardescripcionFormaPagoPuntoVenta=true;
	public Boolean activardescripcionFormaPagoPuntoVenta=true;

	public Border resaltarfecha_inicioFormaPagoPuntoVenta=null;
	public Boolean mostrarfecha_inicioFormaPagoPuntoVenta=true;
	public Boolean activarfecha_inicioFormaPagoPuntoVenta=true;

	public Border resaltarnumero_dias_plazoFormaPagoPuntoVenta=null;
	public Boolean mostrarnumero_dias_plazoFormaPagoPuntoVenta=true;
	public Boolean activarnumero_dias_plazoFormaPagoPuntoVenta=true;

	public Border resaltarfecha_finFormaPagoPuntoVenta=null;
	public Boolean mostrarfecha_finFormaPagoPuntoVenta=true;
	public Boolean activarfecha_finFormaPagoPuntoVenta=true;

	public Border resaltarid_bancoFormaPagoPuntoVenta=null;
	public Boolean mostrarid_bancoFormaPagoPuntoVenta=true;
	public Boolean activarid_bancoFormaPagoPuntoVenta=true;
	public Boolean cargarid_bancoFormaPagoPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bancoFormaPagoPuntoVenta=false;//ConEventDepend=true

	public Border resaltarid_cuenta_banco_pun_venFormaPagoPuntoVenta=null;
	public Boolean mostrarid_cuenta_banco_pun_venFormaPagoPuntoVenta=true;
	public Boolean activarid_cuenta_banco_pun_venFormaPagoPuntoVenta=true;
	public Boolean cargarid_cuenta_banco_pun_venFormaPagoPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_banco_pun_venFormaPagoPuntoVenta=false;//ConEventDepend=true

	public Border resaltarid_tipo_riesgo_chequeFormaPagoPuntoVenta=null;
	public Boolean mostrarid_tipo_riesgo_chequeFormaPagoPuntoVenta=true;
	public Boolean activarid_tipo_riesgo_chequeFormaPagoPuntoVenta=true;
	public Boolean cargarid_tipo_riesgo_chequeFormaPagoPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_riesgo_chequeFormaPagoPuntoVenta=false;//ConEventDepend=true

	public Border resaltarnumero_cuentaFormaPagoPuntoVenta=null;
	public Boolean mostrarnumero_cuentaFormaPagoPuntoVenta=true;
	public Boolean activarnumero_cuentaFormaPagoPuntoVenta=true;

	public Border resaltarnumero_chequeFormaPagoPuntoVenta=null;
	public Boolean mostrarnumero_chequeFormaPagoPuntoVenta=true;
	public Boolean activarnumero_chequeFormaPagoPuntoVenta=true;

	public Border resaltargiradorFormaPagoPuntoVenta=null;
	public Boolean mostrargiradorFormaPagoPuntoVenta=true;
	public Boolean activargiradorFormaPagoPuntoVenta=true;

	public Border resaltarid_banco_tarjetaFormaPagoPuntoVenta=null;
	public Boolean mostrarid_banco_tarjetaFormaPagoPuntoVenta=true;
	public Boolean activarid_banco_tarjetaFormaPagoPuntoVenta=true;
	public Boolean cargarid_banco_tarjetaFormaPagoPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_banco_tarjetaFormaPagoPuntoVenta=false;//ConEventDepend=true

	public Border resaltarid_tarjeta_creditoFormaPagoPuntoVenta=null;
	public Boolean mostrarid_tarjeta_creditoFormaPagoPuntoVenta=true;
	public Boolean activarid_tarjeta_creditoFormaPagoPuntoVenta=true;
	public Boolean cargarid_tarjeta_creditoFormaPagoPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tarjeta_creditoFormaPagoPuntoVenta=false;//ConEventDepend=true

	public Border resaltarid_tipo_interes_tarjetaFormaPagoPuntoVenta=null;
	public Boolean mostrarid_tipo_interes_tarjetaFormaPagoPuntoVenta=true;
	public Boolean activarid_tipo_interes_tarjetaFormaPagoPuntoVenta=true;
	public Boolean cargarid_tipo_interes_tarjetaFormaPagoPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_interes_tarjetaFormaPagoPuntoVenta=false;//ConEventDepend=true

	public Border resaltarid_tipo_pago_tarjetaFormaPagoPuntoVenta=null;
	public Boolean mostrarid_tipo_pago_tarjetaFormaPagoPuntoVenta=true;
	public Boolean activarid_tipo_pago_tarjetaFormaPagoPuntoVenta=true;
	public Boolean cargarid_tipo_pago_tarjetaFormaPagoPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_pago_tarjetaFormaPagoPuntoVenta=false;//ConEventDepend=true

	public Border resaltarid_conexionFormaPagoPuntoVenta=null;
	public Boolean mostrarid_conexionFormaPagoPuntoVenta=true;
	public Boolean activarid_conexionFormaPagoPuntoVenta=true;
	public Boolean cargarid_conexionFormaPagoPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_conexionFormaPagoPuntoVenta=false;//ConEventDepend=true

	public Border resaltarid_mesFormaPagoPuntoVenta=null;
	public Boolean mostrarid_mesFormaPagoPuntoVenta=true;
	public Boolean activarid_mesFormaPagoPuntoVenta=true;
	public Boolean cargarid_mesFormaPagoPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesFormaPagoPuntoVenta=false;//ConEventDepend=true

	public Border resaltarnumeroFormaPagoPuntoVenta=null;
	public Boolean mostrarnumeroFormaPagoPuntoVenta=true;
	public Boolean activarnumeroFormaPagoPuntoVenta=true;

	public Border resaltartarjeta_habienteFormaPagoPuntoVenta=null;
	public Boolean mostrartarjeta_habienteFormaPagoPuntoVenta=true;
	public Boolean activartarjeta_habienteFormaPagoPuntoVenta=true;

	public Border resaltarautorizacionFormaPagoPuntoVenta=null;
	public Boolean mostrarautorizacionFormaPagoPuntoVenta=true;
	public Boolean activarautorizacionFormaPagoPuntoVenta=true;

	public Border resaltarvoucherFormaPagoPuntoVenta=null;
	public Boolean mostrarvoucherFormaPagoPuntoVenta=true;
	public Boolean activarvoucherFormaPagoPuntoVenta=true;

	public Border resaltarloteFormaPagoPuntoVenta=null;
	public Boolean mostrarloteFormaPagoPuntoVenta=true;
	public Boolean activarloteFormaPagoPuntoVenta=true;

	public Border resaltarcuotaFormaPagoPuntoVenta=null;
	public Boolean mostrarcuotaFormaPagoPuntoVenta=true;
	public Boolean activarcuotaFormaPagoPuntoVenta=true;

	public Border resaltarvalor_retencionFormaPagoPuntoVenta=null;
	public Boolean mostrarvalor_retencionFormaPagoPuntoVenta=true;
	public Boolean activarvalor_retencionFormaPagoPuntoVenta=true;

	public Border resaltarvalor_comisionFormaPagoPuntoVenta=null;
	public Boolean mostrarvalor_comisionFormaPagoPuntoVenta=true;
	public Boolean activarvalor_comisionFormaPagoPuntoVenta=true;

	public Border resaltarvalor_calculadoFormaPagoPuntoVenta=null;
	public Boolean mostrarvalor_calculadoFormaPagoPuntoVenta=true;
	public Boolean activarvalor_calculadoFormaPagoPuntoVenta=true;

	public Border resaltarvalor_canceladoFormaPagoPuntoVenta=null;
	public Boolean mostrarvalor_canceladoFormaPagoPuntoVenta=true;
	public Boolean activarvalor_canceladoFormaPagoPuntoVenta=true;

	public Border resaltarvalor_difiereFormaPagoPuntoVenta=null;
	public Boolean mostrarvalor_difiereFormaPagoPuntoVenta=true;
	public Boolean activarvalor_difiereFormaPagoPuntoVenta=true;

	public Border resaltarnumero_retencionFormaPagoPuntoVenta=null;
	public Boolean mostrarnumero_retencionFormaPagoPuntoVenta=true;
	public Boolean activarnumero_retencionFormaPagoPuntoVenta=true;

	public Border resaltarnumero_liquidacionFormaPagoPuntoVenta=null;
	public Boolean mostrarnumero_liquidacionFormaPagoPuntoVenta=true;
	public Boolean activarnumero_liquidacionFormaPagoPuntoVenta=true;

	public Border resaltarid_anioFormaPagoPuntoVenta=null;
	public Boolean mostrarid_anioFormaPagoPuntoVenta=true;
	public Boolean activarid_anioFormaPagoPuntoVenta=false;
	public Boolean cargarid_anioFormaPagoPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioFormaPagoPuntoVenta=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contableFormaPagoPuntoVenta=null;
	public Boolean mostrarid_cuenta_contableFormaPagoPuntoVenta=true;
	public Boolean activarid_cuenta_contableFormaPagoPuntoVenta=false;
	public Boolean cargarid_cuenta_contableFormaPagoPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contableFormaPagoPuntoVenta=false;//ConEventDepend=true

	public Border resaltarid_asiento_contableFormaPagoPuntoVenta=null;
	public Boolean mostrarid_asiento_contableFormaPagoPuntoVenta=true;
	public Boolean activarid_asiento_contableFormaPagoPuntoVenta=false;
	public Boolean cargarid_asiento_contableFormaPagoPuntoVenta=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_asiento_contableFormaPagoPuntoVenta=false;//ConEventDepend=true

	
	

	public Border setResaltaridFormaPagoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoPuntoVentaBeanSwingJInternalFrame formapagopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//formapagopuntoventaBeanSwingJInternalFrame.jTtoolBarFormaPagoPuntoVenta.setBorder(borderResaltar);
		*/
		this.resaltaridFormaPagoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridFormaPagoPuntoVenta() {
		return this.resaltaridFormaPagoPuntoVenta;
	}

	public void setResaltaridFormaPagoPuntoVenta(Border borderResaltar) {
		this.resaltaridFormaPagoPuntoVenta= borderResaltar;
	}

	public Boolean getMostraridFormaPagoPuntoVenta() {
		return this.mostraridFormaPagoPuntoVenta;
	}

	public void setMostraridFormaPagoPuntoVenta(Boolean mostraridFormaPagoPuntoVenta) {
		this.mostraridFormaPagoPuntoVenta= mostraridFormaPagoPuntoVenta;
	}

	public Boolean getActivaridFormaPagoPuntoVenta() {
		return this.activaridFormaPagoPuntoVenta;
	}

	public void setActivaridFormaPagoPuntoVenta(Boolean activaridFormaPagoPuntoVenta) {
		this.activaridFormaPagoPuntoVenta= activaridFormaPagoPuntoVenta;
	}

	public Border setResaltarid_empresaFormaPagoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoPuntoVentaBeanSwingJInternalFrame formapagopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//formapagopuntoventaBeanSwingJInternalFrame.jTtoolBarFormaPagoPuntoVenta.setBorder(borderResaltar);
		*/
		this.resaltarid_empresaFormaPagoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaFormaPagoPuntoVenta() {
		return this.resaltarid_empresaFormaPagoPuntoVenta;
	}

	public void setResaltarid_empresaFormaPagoPuntoVenta(Border borderResaltar) {
		this.resaltarid_empresaFormaPagoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_empresaFormaPagoPuntoVenta() {
		return this.mostrarid_empresaFormaPagoPuntoVenta;
	}

	public void setMostrarid_empresaFormaPagoPuntoVenta(Boolean mostrarid_empresaFormaPagoPuntoVenta) {
		this.mostrarid_empresaFormaPagoPuntoVenta= mostrarid_empresaFormaPagoPuntoVenta;
	}

	public Boolean getActivarid_empresaFormaPagoPuntoVenta() {
		return this.activarid_empresaFormaPagoPuntoVenta;
	}

	public void setActivarid_empresaFormaPagoPuntoVenta(Boolean activarid_empresaFormaPagoPuntoVenta) {
		this.activarid_empresaFormaPagoPuntoVenta= activarid_empresaFormaPagoPuntoVenta;
	}

	public Boolean getCargarid_empresaFormaPagoPuntoVenta() {
		return this.cargarid_empresaFormaPagoPuntoVenta;
	}

	public void setCargarid_empresaFormaPagoPuntoVenta(Boolean cargarid_empresaFormaPagoPuntoVenta) {
		this.cargarid_empresaFormaPagoPuntoVenta= cargarid_empresaFormaPagoPuntoVenta;
	}

	public Border setResaltarid_sucursalFormaPagoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoPuntoVentaBeanSwingJInternalFrame formapagopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//formapagopuntoventaBeanSwingJInternalFrame.jTtoolBarFormaPagoPuntoVenta.setBorder(borderResaltar);
		*/
		this.resaltarid_sucursalFormaPagoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalFormaPagoPuntoVenta() {
		return this.resaltarid_sucursalFormaPagoPuntoVenta;
	}

	public void setResaltarid_sucursalFormaPagoPuntoVenta(Border borderResaltar) {
		this.resaltarid_sucursalFormaPagoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_sucursalFormaPagoPuntoVenta() {
		return this.mostrarid_sucursalFormaPagoPuntoVenta;
	}

	public void setMostrarid_sucursalFormaPagoPuntoVenta(Boolean mostrarid_sucursalFormaPagoPuntoVenta) {
		this.mostrarid_sucursalFormaPagoPuntoVenta= mostrarid_sucursalFormaPagoPuntoVenta;
	}

	public Boolean getActivarid_sucursalFormaPagoPuntoVenta() {
		return this.activarid_sucursalFormaPagoPuntoVenta;
	}

	public void setActivarid_sucursalFormaPagoPuntoVenta(Boolean activarid_sucursalFormaPagoPuntoVenta) {
		this.activarid_sucursalFormaPagoPuntoVenta= activarid_sucursalFormaPagoPuntoVenta;
	}

	public Boolean getCargarid_sucursalFormaPagoPuntoVenta() {
		return this.cargarid_sucursalFormaPagoPuntoVenta;
	}

	public void setCargarid_sucursalFormaPagoPuntoVenta(Boolean cargarid_sucursalFormaPagoPuntoVenta) {
		this.cargarid_sucursalFormaPagoPuntoVenta= cargarid_sucursalFormaPagoPuntoVenta;
	}

	public Border setResaltarid_ejercicioFormaPagoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoPuntoVentaBeanSwingJInternalFrame formapagopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//formapagopuntoventaBeanSwingJInternalFrame.jTtoolBarFormaPagoPuntoVenta.setBorder(borderResaltar);
		*/
		this.resaltarid_ejercicioFormaPagoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioFormaPagoPuntoVenta() {
		return this.resaltarid_ejercicioFormaPagoPuntoVenta;
	}

	public void setResaltarid_ejercicioFormaPagoPuntoVenta(Border borderResaltar) {
		this.resaltarid_ejercicioFormaPagoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioFormaPagoPuntoVenta() {
		return this.mostrarid_ejercicioFormaPagoPuntoVenta;
	}

	public void setMostrarid_ejercicioFormaPagoPuntoVenta(Boolean mostrarid_ejercicioFormaPagoPuntoVenta) {
		this.mostrarid_ejercicioFormaPagoPuntoVenta= mostrarid_ejercicioFormaPagoPuntoVenta;
	}

	public Boolean getActivarid_ejercicioFormaPagoPuntoVenta() {
		return this.activarid_ejercicioFormaPagoPuntoVenta;
	}

	public void setActivarid_ejercicioFormaPagoPuntoVenta(Boolean activarid_ejercicioFormaPagoPuntoVenta) {
		this.activarid_ejercicioFormaPagoPuntoVenta= activarid_ejercicioFormaPagoPuntoVenta;
	}

	public Boolean getCargarid_ejercicioFormaPagoPuntoVenta() {
		return this.cargarid_ejercicioFormaPagoPuntoVenta;
	}

	public void setCargarid_ejercicioFormaPagoPuntoVenta(Boolean cargarid_ejercicioFormaPagoPuntoVenta) {
		this.cargarid_ejercicioFormaPagoPuntoVenta= cargarid_ejercicioFormaPagoPuntoVenta;
	}

	public Border setResaltarid_periodoFormaPagoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoPuntoVentaBeanSwingJInternalFrame formapagopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//formapagopuntoventaBeanSwingJInternalFrame.jTtoolBarFormaPagoPuntoVenta.setBorder(borderResaltar);
		*/
		this.resaltarid_periodoFormaPagoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoFormaPagoPuntoVenta() {
		return this.resaltarid_periodoFormaPagoPuntoVenta;
	}

	public void setResaltarid_periodoFormaPagoPuntoVenta(Border borderResaltar) {
		this.resaltarid_periodoFormaPagoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_periodoFormaPagoPuntoVenta() {
		return this.mostrarid_periodoFormaPagoPuntoVenta;
	}

	public void setMostrarid_periodoFormaPagoPuntoVenta(Boolean mostrarid_periodoFormaPagoPuntoVenta) {
		this.mostrarid_periodoFormaPagoPuntoVenta= mostrarid_periodoFormaPagoPuntoVenta;
	}

	public Boolean getActivarid_periodoFormaPagoPuntoVenta() {
		return this.activarid_periodoFormaPagoPuntoVenta;
	}

	public void setActivarid_periodoFormaPagoPuntoVenta(Boolean activarid_periodoFormaPagoPuntoVenta) {
		this.activarid_periodoFormaPagoPuntoVenta= activarid_periodoFormaPagoPuntoVenta;
	}

	public Boolean getCargarid_periodoFormaPagoPuntoVenta() {
		return this.cargarid_periodoFormaPagoPuntoVenta;
	}

	public void setCargarid_periodoFormaPagoPuntoVenta(Boolean cargarid_periodoFormaPagoPuntoVenta) {
		this.cargarid_periodoFormaPagoPuntoVenta= cargarid_periodoFormaPagoPuntoVenta;
	}

	public Border setResaltarid_factura_punto_ventaFormaPagoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoPuntoVentaBeanSwingJInternalFrame formapagopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//formapagopuntoventaBeanSwingJInternalFrame.jTtoolBarFormaPagoPuntoVenta.setBorder(borderResaltar);
		*/
		this.resaltarid_factura_punto_ventaFormaPagoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_factura_punto_ventaFormaPagoPuntoVenta() {
		return this.resaltarid_factura_punto_ventaFormaPagoPuntoVenta;
	}

	public void setResaltarid_factura_punto_ventaFormaPagoPuntoVenta(Border borderResaltar) {
		this.resaltarid_factura_punto_ventaFormaPagoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_factura_punto_ventaFormaPagoPuntoVenta() {
		return this.mostrarid_factura_punto_ventaFormaPagoPuntoVenta;
	}

	public void setMostrarid_factura_punto_ventaFormaPagoPuntoVenta(Boolean mostrarid_factura_punto_ventaFormaPagoPuntoVenta) {
		this.mostrarid_factura_punto_ventaFormaPagoPuntoVenta= mostrarid_factura_punto_ventaFormaPagoPuntoVenta;
	}

	public Boolean getActivarid_factura_punto_ventaFormaPagoPuntoVenta() {
		return this.activarid_factura_punto_ventaFormaPagoPuntoVenta;
	}

	public void setActivarid_factura_punto_ventaFormaPagoPuntoVenta(Boolean activarid_factura_punto_ventaFormaPagoPuntoVenta) {
		this.activarid_factura_punto_ventaFormaPagoPuntoVenta= activarid_factura_punto_ventaFormaPagoPuntoVenta;
	}

	public Boolean getCargarid_factura_punto_ventaFormaPagoPuntoVenta() {
		return this.cargarid_factura_punto_ventaFormaPagoPuntoVenta;
	}

	public void setCargarid_factura_punto_ventaFormaPagoPuntoVenta(Boolean cargarid_factura_punto_ventaFormaPagoPuntoVenta) {
		this.cargarid_factura_punto_ventaFormaPagoPuntoVenta= cargarid_factura_punto_ventaFormaPagoPuntoVenta;
	}

	public Border setResaltarid_tipo_forma_pagoFormaPagoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoPuntoVentaBeanSwingJInternalFrame formapagopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//formapagopuntoventaBeanSwingJInternalFrame.jTtoolBarFormaPagoPuntoVenta.setBorder(borderResaltar);
		*/
		this.resaltarid_tipo_forma_pagoFormaPagoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_forma_pagoFormaPagoPuntoVenta() {
		return this.resaltarid_tipo_forma_pagoFormaPagoPuntoVenta;
	}

	public void setResaltarid_tipo_forma_pagoFormaPagoPuntoVenta(Border borderResaltar) {
		this.resaltarid_tipo_forma_pagoFormaPagoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_tipo_forma_pagoFormaPagoPuntoVenta() {
		return this.mostrarid_tipo_forma_pagoFormaPagoPuntoVenta;
	}

	public void setMostrarid_tipo_forma_pagoFormaPagoPuntoVenta(Boolean mostrarid_tipo_forma_pagoFormaPagoPuntoVenta) {
		this.mostrarid_tipo_forma_pagoFormaPagoPuntoVenta= mostrarid_tipo_forma_pagoFormaPagoPuntoVenta;
	}

	public Boolean getActivarid_tipo_forma_pagoFormaPagoPuntoVenta() {
		return this.activarid_tipo_forma_pagoFormaPagoPuntoVenta;
	}

	public void setActivarid_tipo_forma_pagoFormaPagoPuntoVenta(Boolean activarid_tipo_forma_pagoFormaPagoPuntoVenta) {
		this.activarid_tipo_forma_pagoFormaPagoPuntoVenta= activarid_tipo_forma_pagoFormaPagoPuntoVenta;
	}

	public Boolean getCargarid_tipo_forma_pagoFormaPagoPuntoVenta() {
		return this.cargarid_tipo_forma_pagoFormaPagoPuntoVenta;
	}

	public void setCargarid_tipo_forma_pagoFormaPagoPuntoVenta(Boolean cargarid_tipo_forma_pagoFormaPagoPuntoVenta) {
		this.cargarid_tipo_forma_pagoFormaPagoPuntoVenta= cargarid_tipo_forma_pagoFormaPagoPuntoVenta;
	}

	public Border setResaltarporcentajeFormaPagoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoPuntoVentaBeanSwingJInternalFrame formapagopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//formapagopuntoventaBeanSwingJInternalFrame.jTtoolBarFormaPagoPuntoVenta.setBorder(borderResaltar);
		*/
		this.resaltarporcentajeFormaPagoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentajeFormaPagoPuntoVenta() {
		return this.resaltarporcentajeFormaPagoPuntoVenta;
	}

	public void setResaltarporcentajeFormaPagoPuntoVenta(Border borderResaltar) {
		this.resaltarporcentajeFormaPagoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarporcentajeFormaPagoPuntoVenta() {
		return this.mostrarporcentajeFormaPagoPuntoVenta;
	}

	public void setMostrarporcentajeFormaPagoPuntoVenta(Boolean mostrarporcentajeFormaPagoPuntoVenta) {
		this.mostrarporcentajeFormaPagoPuntoVenta= mostrarporcentajeFormaPagoPuntoVenta;
	}

	public Boolean getActivarporcentajeFormaPagoPuntoVenta() {
		return this.activarporcentajeFormaPagoPuntoVenta;
	}

	public void setActivarporcentajeFormaPagoPuntoVenta(Boolean activarporcentajeFormaPagoPuntoVenta) {
		this.activarporcentajeFormaPagoPuntoVenta= activarporcentajeFormaPagoPuntoVenta;
	}

	public Border setResaltarvalorFormaPagoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoPuntoVentaBeanSwingJInternalFrame formapagopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//formapagopuntoventaBeanSwingJInternalFrame.jTtoolBarFormaPagoPuntoVenta.setBorder(borderResaltar);
		*/
		this.resaltarvalorFormaPagoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorFormaPagoPuntoVenta() {
		return this.resaltarvalorFormaPagoPuntoVenta;
	}

	public void setResaltarvalorFormaPagoPuntoVenta(Border borderResaltar) {
		this.resaltarvalorFormaPagoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarvalorFormaPagoPuntoVenta() {
		return this.mostrarvalorFormaPagoPuntoVenta;
	}

	public void setMostrarvalorFormaPagoPuntoVenta(Boolean mostrarvalorFormaPagoPuntoVenta) {
		this.mostrarvalorFormaPagoPuntoVenta= mostrarvalorFormaPagoPuntoVenta;
	}

	public Boolean getActivarvalorFormaPagoPuntoVenta() {
		return this.activarvalorFormaPagoPuntoVenta;
	}

	public void setActivarvalorFormaPagoPuntoVenta(Boolean activarvalorFormaPagoPuntoVenta) {
		this.activarvalorFormaPagoPuntoVenta= activarvalorFormaPagoPuntoVenta;
	}

	public Border setResaltarfechaFormaPagoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoPuntoVentaBeanSwingJInternalFrame formapagopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//formapagopuntoventaBeanSwingJInternalFrame.jTtoolBarFormaPagoPuntoVenta.setBorder(borderResaltar);
		*/
		this.resaltarfechaFormaPagoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaFormaPagoPuntoVenta() {
		return this.resaltarfechaFormaPagoPuntoVenta;
	}

	public void setResaltarfechaFormaPagoPuntoVenta(Border borderResaltar) {
		this.resaltarfechaFormaPagoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarfechaFormaPagoPuntoVenta() {
		return this.mostrarfechaFormaPagoPuntoVenta;
	}

	public void setMostrarfechaFormaPagoPuntoVenta(Boolean mostrarfechaFormaPagoPuntoVenta) {
		this.mostrarfechaFormaPagoPuntoVenta= mostrarfechaFormaPagoPuntoVenta;
	}

	public Boolean getActivarfechaFormaPagoPuntoVenta() {
		return this.activarfechaFormaPagoPuntoVenta;
	}

	public void setActivarfechaFormaPagoPuntoVenta(Boolean activarfechaFormaPagoPuntoVenta) {
		this.activarfechaFormaPagoPuntoVenta= activarfechaFormaPagoPuntoVenta;
	}

	public Border setResaltardescripcionFormaPagoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoPuntoVentaBeanSwingJInternalFrame formapagopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//formapagopuntoventaBeanSwingJInternalFrame.jTtoolBarFormaPagoPuntoVenta.setBorder(borderResaltar);
		*/
		this.resaltardescripcionFormaPagoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionFormaPagoPuntoVenta() {
		return this.resaltardescripcionFormaPagoPuntoVenta;
	}

	public void setResaltardescripcionFormaPagoPuntoVenta(Border borderResaltar) {
		this.resaltardescripcionFormaPagoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrardescripcionFormaPagoPuntoVenta() {
		return this.mostrardescripcionFormaPagoPuntoVenta;
	}

	public void setMostrardescripcionFormaPagoPuntoVenta(Boolean mostrardescripcionFormaPagoPuntoVenta) {
		this.mostrardescripcionFormaPagoPuntoVenta= mostrardescripcionFormaPagoPuntoVenta;
	}

	public Boolean getActivardescripcionFormaPagoPuntoVenta() {
		return this.activardescripcionFormaPagoPuntoVenta;
	}

	public void setActivardescripcionFormaPagoPuntoVenta(Boolean activardescripcionFormaPagoPuntoVenta) {
		this.activardescripcionFormaPagoPuntoVenta= activardescripcionFormaPagoPuntoVenta;
	}

	public Border setResaltarfecha_inicioFormaPagoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoPuntoVentaBeanSwingJInternalFrame formapagopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//formapagopuntoventaBeanSwingJInternalFrame.jTtoolBarFormaPagoPuntoVenta.setBorder(borderResaltar);
		*/
		this.resaltarfecha_inicioFormaPagoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_inicioFormaPagoPuntoVenta() {
		return this.resaltarfecha_inicioFormaPagoPuntoVenta;
	}

	public void setResaltarfecha_inicioFormaPagoPuntoVenta(Border borderResaltar) {
		this.resaltarfecha_inicioFormaPagoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarfecha_inicioFormaPagoPuntoVenta() {
		return this.mostrarfecha_inicioFormaPagoPuntoVenta;
	}

	public void setMostrarfecha_inicioFormaPagoPuntoVenta(Boolean mostrarfecha_inicioFormaPagoPuntoVenta) {
		this.mostrarfecha_inicioFormaPagoPuntoVenta= mostrarfecha_inicioFormaPagoPuntoVenta;
	}

	public Boolean getActivarfecha_inicioFormaPagoPuntoVenta() {
		return this.activarfecha_inicioFormaPagoPuntoVenta;
	}

	public void setActivarfecha_inicioFormaPagoPuntoVenta(Boolean activarfecha_inicioFormaPagoPuntoVenta) {
		this.activarfecha_inicioFormaPagoPuntoVenta= activarfecha_inicioFormaPagoPuntoVenta;
	}

	public Border setResaltarnumero_dias_plazoFormaPagoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoPuntoVentaBeanSwingJInternalFrame formapagopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//formapagopuntoventaBeanSwingJInternalFrame.jTtoolBarFormaPagoPuntoVenta.setBorder(borderResaltar);
		*/
		this.resaltarnumero_dias_plazoFormaPagoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_dias_plazoFormaPagoPuntoVenta() {
		return this.resaltarnumero_dias_plazoFormaPagoPuntoVenta;
	}

	public void setResaltarnumero_dias_plazoFormaPagoPuntoVenta(Border borderResaltar) {
		this.resaltarnumero_dias_plazoFormaPagoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarnumero_dias_plazoFormaPagoPuntoVenta() {
		return this.mostrarnumero_dias_plazoFormaPagoPuntoVenta;
	}

	public void setMostrarnumero_dias_plazoFormaPagoPuntoVenta(Boolean mostrarnumero_dias_plazoFormaPagoPuntoVenta) {
		this.mostrarnumero_dias_plazoFormaPagoPuntoVenta= mostrarnumero_dias_plazoFormaPagoPuntoVenta;
	}

	public Boolean getActivarnumero_dias_plazoFormaPagoPuntoVenta() {
		return this.activarnumero_dias_plazoFormaPagoPuntoVenta;
	}

	public void setActivarnumero_dias_plazoFormaPagoPuntoVenta(Boolean activarnumero_dias_plazoFormaPagoPuntoVenta) {
		this.activarnumero_dias_plazoFormaPagoPuntoVenta= activarnumero_dias_plazoFormaPagoPuntoVenta;
	}

	public Border setResaltarfecha_finFormaPagoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoPuntoVentaBeanSwingJInternalFrame formapagopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//formapagopuntoventaBeanSwingJInternalFrame.jTtoolBarFormaPagoPuntoVenta.setBorder(borderResaltar);
		*/
		this.resaltarfecha_finFormaPagoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_finFormaPagoPuntoVenta() {
		return this.resaltarfecha_finFormaPagoPuntoVenta;
	}

	public void setResaltarfecha_finFormaPagoPuntoVenta(Border borderResaltar) {
		this.resaltarfecha_finFormaPagoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarfecha_finFormaPagoPuntoVenta() {
		return this.mostrarfecha_finFormaPagoPuntoVenta;
	}

	public void setMostrarfecha_finFormaPagoPuntoVenta(Boolean mostrarfecha_finFormaPagoPuntoVenta) {
		this.mostrarfecha_finFormaPagoPuntoVenta= mostrarfecha_finFormaPagoPuntoVenta;
	}

	public Boolean getActivarfecha_finFormaPagoPuntoVenta() {
		return this.activarfecha_finFormaPagoPuntoVenta;
	}

	public void setActivarfecha_finFormaPagoPuntoVenta(Boolean activarfecha_finFormaPagoPuntoVenta) {
		this.activarfecha_finFormaPagoPuntoVenta= activarfecha_finFormaPagoPuntoVenta;
	}

	public Border setResaltarid_bancoFormaPagoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoPuntoVentaBeanSwingJInternalFrame formapagopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//formapagopuntoventaBeanSwingJInternalFrame.jTtoolBarFormaPagoPuntoVenta.setBorder(borderResaltar);
		*/
		this.resaltarid_bancoFormaPagoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bancoFormaPagoPuntoVenta() {
		return this.resaltarid_bancoFormaPagoPuntoVenta;
	}

	public void setResaltarid_bancoFormaPagoPuntoVenta(Border borderResaltar) {
		this.resaltarid_bancoFormaPagoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_bancoFormaPagoPuntoVenta() {
		return this.mostrarid_bancoFormaPagoPuntoVenta;
	}

	public void setMostrarid_bancoFormaPagoPuntoVenta(Boolean mostrarid_bancoFormaPagoPuntoVenta) {
		this.mostrarid_bancoFormaPagoPuntoVenta= mostrarid_bancoFormaPagoPuntoVenta;
	}

	public Boolean getActivarid_bancoFormaPagoPuntoVenta() {
		return this.activarid_bancoFormaPagoPuntoVenta;
	}

	public void setActivarid_bancoFormaPagoPuntoVenta(Boolean activarid_bancoFormaPagoPuntoVenta) {
		this.activarid_bancoFormaPagoPuntoVenta= activarid_bancoFormaPagoPuntoVenta;
	}

	public Boolean getCargarid_bancoFormaPagoPuntoVenta() {
		return this.cargarid_bancoFormaPagoPuntoVenta;
	}

	public void setCargarid_bancoFormaPagoPuntoVenta(Boolean cargarid_bancoFormaPagoPuntoVenta) {
		this.cargarid_bancoFormaPagoPuntoVenta= cargarid_bancoFormaPagoPuntoVenta;
	}

	public Border setResaltarid_cuenta_banco_pun_venFormaPagoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoPuntoVentaBeanSwingJInternalFrame formapagopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//formapagopuntoventaBeanSwingJInternalFrame.jTtoolBarFormaPagoPuntoVenta.setBorder(borderResaltar);
		*/
		this.resaltarid_cuenta_banco_pun_venFormaPagoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_banco_pun_venFormaPagoPuntoVenta() {
		return this.resaltarid_cuenta_banco_pun_venFormaPagoPuntoVenta;
	}

	public void setResaltarid_cuenta_banco_pun_venFormaPagoPuntoVenta(Border borderResaltar) {
		this.resaltarid_cuenta_banco_pun_venFormaPagoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_banco_pun_venFormaPagoPuntoVenta() {
		return this.mostrarid_cuenta_banco_pun_venFormaPagoPuntoVenta;
	}

	public void setMostrarid_cuenta_banco_pun_venFormaPagoPuntoVenta(Boolean mostrarid_cuenta_banco_pun_venFormaPagoPuntoVenta) {
		this.mostrarid_cuenta_banco_pun_venFormaPagoPuntoVenta= mostrarid_cuenta_banco_pun_venFormaPagoPuntoVenta;
	}

	public Boolean getActivarid_cuenta_banco_pun_venFormaPagoPuntoVenta() {
		return this.activarid_cuenta_banco_pun_venFormaPagoPuntoVenta;
	}

	public void setActivarid_cuenta_banco_pun_venFormaPagoPuntoVenta(Boolean activarid_cuenta_banco_pun_venFormaPagoPuntoVenta) {
		this.activarid_cuenta_banco_pun_venFormaPagoPuntoVenta= activarid_cuenta_banco_pun_venFormaPagoPuntoVenta;
	}

	public Boolean getCargarid_cuenta_banco_pun_venFormaPagoPuntoVenta() {
		return this.cargarid_cuenta_banco_pun_venFormaPagoPuntoVenta;
	}

	public void setCargarid_cuenta_banco_pun_venFormaPagoPuntoVenta(Boolean cargarid_cuenta_banco_pun_venFormaPagoPuntoVenta) {
		this.cargarid_cuenta_banco_pun_venFormaPagoPuntoVenta= cargarid_cuenta_banco_pun_venFormaPagoPuntoVenta;
	}

	public Border setResaltarid_tipo_riesgo_chequeFormaPagoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoPuntoVentaBeanSwingJInternalFrame formapagopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//formapagopuntoventaBeanSwingJInternalFrame.jTtoolBarFormaPagoPuntoVenta.setBorder(borderResaltar);
		*/
		this.resaltarid_tipo_riesgo_chequeFormaPagoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_riesgo_chequeFormaPagoPuntoVenta() {
		return this.resaltarid_tipo_riesgo_chequeFormaPagoPuntoVenta;
	}

	public void setResaltarid_tipo_riesgo_chequeFormaPagoPuntoVenta(Border borderResaltar) {
		this.resaltarid_tipo_riesgo_chequeFormaPagoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_tipo_riesgo_chequeFormaPagoPuntoVenta() {
		return this.mostrarid_tipo_riesgo_chequeFormaPagoPuntoVenta;
	}

	public void setMostrarid_tipo_riesgo_chequeFormaPagoPuntoVenta(Boolean mostrarid_tipo_riesgo_chequeFormaPagoPuntoVenta) {
		this.mostrarid_tipo_riesgo_chequeFormaPagoPuntoVenta= mostrarid_tipo_riesgo_chequeFormaPagoPuntoVenta;
	}

	public Boolean getActivarid_tipo_riesgo_chequeFormaPagoPuntoVenta() {
		return this.activarid_tipo_riesgo_chequeFormaPagoPuntoVenta;
	}

	public void setActivarid_tipo_riesgo_chequeFormaPagoPuntoVenta(Boolean activarid_tipo_riesgo_chequeFormaPagoPuntoVenta) {
		this.activarid_tipo_riesgo_chequeFormaPagoPuntoVenta= activarid_tipo_riesgo_chequeFormaPagoPuntoVenta;
	}

	public Boolean getCargarid_tipo_riesgo_chequeFormaPagoPuntoVenta() {
		return this.cargarid_tipo_riesgo_chequeFormaPagoPuntoVenta;
	}

	public void setCargarid_tipo_riesgo_chequeFormaPagoPuntoVenta(Boolean cargarid_tipo_riesgo_chequeFormaPagoPuntoVenta) {
		this.cargarid_tipo_riesgo_chequeFormaPagoPuntoVenta= cargarid_tipo_riesgo_chequeFormaPagoPuntoVenta;
	}

	public Border setResaltarnumero_cuentaFormaPagoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoPuntoVentaBeanSwingJInternalFrame formapagopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//formapagopuntoventaBeanSwingJInternalFrame.jTtoolBarFormaPagoPuntoVenta.setBorder(borderResaltar);
		*/
		this.resaltarnumero_cuentaFormaPagoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_cuentaFormaPagoPuntoVenta() {
		return this.resaltarnumero_cuentaFormaPagoPuntoVenta;
	}

	public void setResaltarnumero_cuentaFormaPagoPuntoVenta(Border borderResaltar) {
		this.resaltarnumero_cuentaFormaPagoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarnumero_cuentaFormaPagoPuntoVenta() {
		return this.mostrarnumero_cuentaFormaPagoPuntoVenta;
	}

	public void setMostrarnumero_cuentaFormaPagoPuntoVenta(Boolean mostrarnumero_cuentaFormaPagoPuntoVenta) {
		this.mostrarnumero_cuentaFormaPagoPuntoVenta= mostrarnumero_cuentaFormaPagoPuntoVenta;
	}

	public Boolean getActivarnumero_cuentaFormaPagoPuntoVenta() {
		return this.activarnumero_cuentaFormaPagoPuntoVenta;
	}

	public void setActivarnumero_cuentaFormaPagoPuntoVenta(Boolean activarnumero_cuentaFormaPagoPuntoVenta) {
		this.activarnumero_cuentaFormaPagoPuntoVenta= activarnumero_cuentaFormaPagoPuntoVenta;
	}

	public Border setResaltarnumero_chequeFormaPagoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoPuntoVentaBeanSwingJInternalFrame formapagopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//formapagopuntoventaBeanSwingJInternalFrame.jTtoolBarFormaPagoPuntoVenta.setBorder(borderResaltar);
		*/
		this.resaltarnumero_chequeFormaPagoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_chequeFormaPagoPuntoVenta() {
		return this.resaltarnumero_chequeFormaPagoPuntoVenta;
	}

	public void setResaltarnumero_chequeFormaPagoPuntoVenta(Border borderResaltar) {
		this.resaltarnumero_chequeFormaPagoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarnumero_chequeFormaPagoPuntoVenta() {
		return this.mostrarnumero_chequeFormaPagoPuntoVenta;
	}

	public void setMostrarnumero_chequeFormaPagoPuntoVenta(Boolean mostrarnumero_chequeFormaPagoPuntoVenta) {
		this.mostrarnumero_chequeFormaPagoPuntoVenta= mostrarnumero_chequeFormaPagoPuntoVenta;
	}

	public Boolean getActivarnumero_chequeFormaPagoPuntoVenta() {
		return this.activarnumero_chequeFormaPagoPuntoVenta;
	}

	public void setActivarnumero_chequeFormaPagoPuntoVenta(Boolean activarnumero_chequeFormaPagoPuntoVenta) {
		this.activarnumero_chequeFormaPagoPuntoVenta= activarnumero_chequeFormaPagoPuntoVenta;
	}

	public Border setResaltargiradorFormaPagoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoPuntoVentaBeanSwingJInternalFrame formapagopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//formapagopuntoventaBeanSwingJInternalFrame.jTtoolBarFormaPagoPuntoVenta.setBorder(borderResaltar);
		*/
		this.resaltargiradorFormaPagoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltargiradorFormaPagoPuntoVenta() {
		return this.resaltargiradorFormaPagoPuntoVenta;
	}

	public void setResaltargiradorFormaPagoPuntoVenta(Border borderResaltar) {
		this.resaltargiradorFormaPagoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrargiradorFormaPagoPuntoVenta() {
		return this.mostrargiradorFormaPagoPuntoVenta;
	}

	public void setMostrargiradorFormaPagoPuntoVenta(Boolean mostrargiradorFormaPagoPuntoVenta) {
		this.mostrargiradorFormaPagoPuntoVenta= mostrargiradorFormaPagoPuntoVenta;
	}

	public Boolean getActivargiradorFormaPagoPuntoVenta() {
		return this.activargiradorFormaPagoPuntoVenta;
	}

	public void setActivargiradorFormaPagoPuntoVenta(Boolean activargiradorFormaPagoPuntoVenta) {
		this.activargiradorFormaPagoPuntoVenta= activargiradorFormaPagoPuntoVenta;
	}

	public Border setResaltarid_banco_tarjetaFormaPagoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoPuntoVentaBeanSwingJInternalFrame formapagopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//formapagopuntoventaBeanSwingJInternalFrame.jTtoolBarFormaPagoPuntoVenta.setBorder(borderResaltar);
		*/
		this.resaltarid_banco_tarjetaFormaPagoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_banco_tarjetaFormaPagoPuntoVenta() {
		return this.resaltarid_banco_tarjetaFormaPagoPuntoVenta;
	}

	public void setResaltarid_banco_tarjetaFormaPagoPuntoVenta(Border borderResaltar) {
		this.resaltarid_banco_tarjetaFormaPagoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_banco_tarjetaFormaPagoPuntoVenta() {
		return this.mostrarid_banco_tarjetaFormaPagoPuntoVenta;
	}

	public void setMostrarid_banco_tarjetaFormaPagoPuntoVenta(Boolean mostrarid_banco_tarjetaFormaPagoPuntoVenta) {
		this.mostrarid_banco_tarjetaFormaPagoPuntoVenta= mostrarid_banco_tarjetaFormaPagoPuntoVenta;
	}

	public Boolean getActivarid_banco_tarjetaFormaPagoPuntoVenta() {
		return this.activarid_banco_tarjetaFormaPagoPuntoVenta;
	}

	public void setActivarid_banco_tarjetaFormaPagoPuntoVenta(Boolean activarid_banco_tarjetaFormaPagoPuntoVenta) {
		this.activarid_banco_tarjetaFormaPagoPuntoVenta= activarid_banco_tarjetaFormaPagoPuntoVenta;
	}

	public Boolean getCargarid_banco_tarjetaFormaPagoPuntoVenta() {
		return this.cargarid_banco_tarjetaFormaPagoPuntoVenta;
	}

	public void setCargarid_banco_tarjetaFormaPagoPuntoVenta(Boolean cargarid_banco_tarjetaFormaPagoPuntoVenta) {
		this.cargarid_banco_tarjetaFormaPagoPuntoVenta= cargarid_banco_tarjetaFormaPagoPuntoVenta;
	}

	public Border setResaltarid_tarjeta_creditoFormaPagoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoPuntoVentaBeanSwingJInternalFrame formapagopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//formapagopuntoventaBeanSwingJInternalFrame.jTtoolBarFormaPagoPuntoVenta.setBorder(borderResaltar);
		*/
		this.resaltarid_tarjeta_creditoFormaPagoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tarjeta_creditoFormaPagoPuntoVenta() {
		return this.resaltarid_tarjeta_creditoFormaPagoPuntoVenta;
	}

	public void setResaltarid_tarjeta_creditoFormaPagoPuntoVenta(Border borderResaltar) {
		this.resaltarid_tarjeta_creditoFormaPagoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_tarjeta_creditoFormaPagoPuntoVenta() {
		return this.mostrarid_tarjeta_creditoFormaPagoPuntoVenta;
	}

	public void setMostrarid_tarjeta_creditoFormaPagoPuntoVenta(Boolean mostrarid_tarjeta_creditoFormaPagoPuntoVenta) {
		this.mostrarid_tarjeta_creditoFormaPagoPuntoVenta= mostrarid_tarjeta_creditoFormaPagoPuntoVenta;
	}

	public Boolean getActivarid_tarjeta_creditoFormaPagoPuntoVenta() {
		return this.activarid_tarjeta_creditoFormaPagoPuntoVenta;
	}

	public void setActivarid_tarjeta_creditoFormaPagoPuntoVenta(Boolean activarid_tarjeta_creditoFormaPagoPuntoVenta) {
		this.activarid_tarjeta_creditoFormaPagoPuntoVenta= activarid_tarjeta_creditoFormaPagoPuntoVenta;
	}

	public Boolean getCargarid_tarjeta_creditoFormaPagoPuntoVenta() {
		return this.cargarid_tarjeta_creditoFormaPagoPuntoVenta;
	}

	public void setCargarid_tarjeta_creditoFormaPagoPuntoVenta(Boolean cargarid_tarjeta_creditoFormaPagoPuntoVenta) {
		this.cargarid_tarjeta_creditoFormaPagoPuntoVenta= cargarid_tarjeta_creditoFormaPagoPuntoVenta;
	}

	public Border setResaltarid_tipo_interes_tarjetaFormaPagoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoPuntoVentaBeanSwingJInternalFrame formapagopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//formapagopuntoventaBeanSwingJInternalFrame.jTtoolBarFormaPagoPuntoVenta.setBorder(borderResaltar);
		*/
		this.resaltarid_tipo_interes_tarjetaFormaPagoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_interes_tarjetaFormaPagoPuntoVenta() {
		return this.resaltarid_tipo_interes_tarjetaFormaPagoPuntoVenta;
	}

	public void setResaltarid_tipo_interes_tarjetaFormaPagoPuntoVenta(Border borderResaltar) {
		this.resaltarid_tipo_interes_tarjetaFormaPagoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_tipo_interes_tarjetaFormaPagoPuntoVenta() {
		return this.mostrarid_tipo_interes_tarjetaFormaPagoPuntoVenta;
	}

	public void setMostrarid_tipo_interes_tarjetaFormaPagoPuntoVenta(Boolean mostrarid_tipo_interes_tarjetaFormaPagoPuntoVenta) {
		this.mostrarid_tipo_interes_tarjetaFormaPagoPuntoVenta= mostrarid_tipo_interes_tarjetaFormaPagoPuntoVenta;
	}

	public Boolean getActivarid_tipo_interes_tarjetaFormaPagoPuntoVenta() {
		return this.activarid_tipo_interes_tarjetaFormaPagoPuntoVenta;
	}

	public void setActivarid_tipo_interes_tarjetaFormaPagoPuntoVenta(Boolean activarid_tipo_interes_tarjetaFormaPagoPuntoVenta) {
		this.activarid_tipo_interes_tarjetaFormaPagoPuntoVenta= activarid_tipo_interes_tarjetaFormaPagoPuntoVenta;
	}

	public Boolean getCargarid_tipo_interes_tarjetaFormaPagoPuntoVenta() {
		return this.cargarid_tipo_interes_tarjetaFormaPagoPuntoVenta;
	}

	public void setCargarid_tipo_interes_tarjetaFormaPagoPuntoVenta(Boolean cargarid_tipo_interes_tarjetaFormaPagoPuntoVenta) {
		this.cargarid_tipo_interes_tarjetaFormaPagoPuntoVenta= cargarid_tipo_interes_tarjetaFormaPagoPuntoVenta;
	}

	public Border setResaltarid_tipo_pago_tarjetaFormaPagoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoPuntoVentaBeanSwingJInternalFrame formapagopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//formapagopuntoventaBeanSwingJInternalFrame.jTtoolBarFormaPagoPuntoVenta.setBorder(borderResaltar);
		*/
		this.resaltarid_tipo_pago_tarjetaFormaPagoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_pago_tarjetaFormaPagoPuntoVenta() {
		return this.resaltarid_tipo_pago_tarjetaFormaPagoPuntoVenta;
	}

	public void setResaltarid_tipo_pago_tarjetaFormaPagoPuntoVenta(Border borderResaltar) {
		this.resaltarid_tipo_pago_tarjetaFormaPagoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_tipo_pago_tarjetaFormaPagoPuntoVenta() {
		return this.mostrarid_tipo_pago_tarjetaFormaPagoPuntoVenta;
	}

	public void setMostrarid_tipo_pago_tarjetaFormaPagoPuntoVenta(Boolean mostrarid_tipo_pago_tarjetaFormaPagoPuntoVenta) {
		this.mostrarid_tipo_pago_tarjetaFormaPagoPuntoVenta= mostrarid_tipo_pago_tarjetaFormaPagoPuntoVenta;
	}

	public Boolean getActivarid_tipo_pago_tarjetaFormaPagoPuntoVenta() {
		return this.activarid_tipo_pago_tarjetaFormaPagoPuntoVenta;
	}

	public void setActivarid_tipo_pago_tarjetaFormaPagoPuntoVenta(Boolean activarid_tipo_pago_tarjetaFormaPagoPuntoVenta) {
		this.activarid_tipo_pago_tarjetaFormaPagoPuntoVenta= activarid_tipo_pago_tarjetaFormaPagoPuntoVenta;
	}

	public Boolean getCargarid_tipo_pago_tarjetaFormaPagoPuntoVenta() {
		return this.cargarid_tipo_pago_tarjetaFormaPagoPuntoVenta;
	}

	public void setCargarid_tipo_pago_tarjetaFormaPagoPuntoVenta(Boolean cargarid_tipo_pago_tarjetaFormaPagoPuntoVenta) {
		this.cargarid_tipo_pago_tarjetaFormaPagoPuntoVenta= cargarid_tipo_pago_tarjetaFormaPagoPuntoVenta;
	}

	public Border setResaltarid_conexionFormaPagoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoPuntoVentaBeanSwingJInternalFrame formapagopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//formapagopuntoventaBeanSwingJInternalFrame.jTtoolBarFormaPagoPuntoVenta.setBorder(borderResaltar);
		*/
		this.resaltarid_conexionFormaPagoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_conexionFormaPagoPuntoVenta() {
		return this.resaltarid_conexionFormaPagoPuntoVenta;
	}

	public void setResaltarid_conexionFormaPagoPuntoVenta(Border borderResaltar) {
		this.resaltarid_conexionFormaPagoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_conexionFormaPagoPuntoVenta() {
		return this.mostrarid_conexionFormaPagoPuntoVenta;
	}

	public void setMostrarid_conexionFormaPagoPuntoVenta(Boolean mostrarid_conexionFormaPagoPuntoVenta) {
		this.mostrarid_conexionFormaPagoPuntoVenta= mostrarid_conexionFormaPagoPuntoVenta;
	}

	public Boolean getActivarid_conexionFormaPagoPuntoVenta() {
		return this.activarid_conexionFormaPagoPuntoVenta;
	}

	public void setActivarid_conexionFormaPagoPuntoVenta(Boolean activarid_conexionFormaPagoPuntoVenta) {
		this.activarid_conexionFormaPagoPuntoVenta= activarid_conexionFormaPagoPuntoVenta;
	}

	public Boolean getCargarid_conexionFormaPagoPuntoVenta() {
		return this.cargarid_conexionFormaPagoPuntoVenta;
	}

	public void setCargarid_conexionFormaPagoPuntoVenta(Boolean cargarid_conexionFormaPagoPuntoVenta) {
		this.cargarid_conexionFormaPagoPuntoVenta= cargarid_conexionFormaPagoPuntoVenta;
	}

	public Border setResaltarid_mesFormaPagoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoPuntoVentaBeanSwingJInternalFrame formapagopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//formapagopuntoventaBeanSwingJInternalFrame.jTtoolBarFormaPagoPuntoVenta.setBorder(borderResaltar);
		*/
		this.resaltarid_mesFormaPagoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesFormaPagoPuntoVenta() {
		return this.resaltarid_mesFormaPagoPuntoVenta;
	}

	public void setResaltarid_mesFormaPagoPuntoVenta(Border borderResaltar) {
		this.resaltarid_mesFormaPagoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_mesFormaPagoPuntoVenta() {
		return this.mostrarid_mesFormaPagoPuntoVenta;
	}

	public void setMostrarid_mesFormaPagoPuntoVenta(Boolean mostrarid_mesFormaPagoPuntoVenta) {
		this.mostrarid_mesFormaPagoPuntoVenta= mostrarid_mesFormaPagoPuntoVenta;
	}

	public Boolean getActivarid_mesFormaPagoPuntoVenta() {
		return this.activarid_mesFormaPagoPuntoVenta;
	}

	public void setActivarid_mesFormaPagoPuntoVenta(Boolean activarid_mesFormaPagoPuntoVenta) {
		this.activarid_mesFormaPagoPuntoVenta= activarid_mesFormaPagoPuntoVenta;
	}

	public Boolean getCargarid_mesFormaPagoPuntoVenta() {
		return this.cargarid_mesFormaPagoPuntoVenta;
	}

	public void setCargarid_mesFormaPagoPuntoVenta(Boolean cargarid_mesFormaPagoPuntoVenta) {
		this.cargarid_mesFormaPagoPuntoVenta= cargarid_mesFormaPagoPuntoVenta;
	}

	public Border setResaltarnumeroFormaPagoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoPuntoVentaBeanSwingJInternalFrame formapagopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//formapagopuntoventaBeanSwingJInternalFrame.jTtoolBarFormaPagoPuntoVenta.setBorder(borderResaltar);
		*/
		this.resaltarnumeroFormaPagoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumeroFormaPagoPuntoVenta() {
		return this.resaltarnumeroFormaPagoPuntoVenta;
	}

	public void setResaltarnumeroFormaPagoPuntoVenta(Border borderResaltar) {
		this.resaltarnumeroFormaPagoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarnumeroFormaPagoPuntoVenta() {
		return this.mostrarnumeroFormaPagoPuntoVenta;
	}

	public void setMostrarnumeroFormaPagoPuntoVenta(Boolean mostrarnumeroFormaPagoPuntoVenta) {
		this.mostrarnumeroFormaPagoPuntoVenta= mostrarnumeroFormaPagoPuntoVenta;
	}

	public Boolean getActivarnumeroFormaPagoPuntoVenta() {
		return this.activarnumeroFormaPagoPuntoVenta;
	}

	public void setActivarnumeroFormaPagoPuntoVenta(Boolean activarnumeroFormaPagoPuntoVenta) {
		this.activarnumeroFormaPagoPuntoVenta= activarnumeroFormaPagoPuntoVenta;
	}

	public Border setResaltartarjeta_habienteFormaPagoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoPuntoVentaBeanSwingJInternalFrame formapagopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//formapagopuntoventaBeanSwingJInternalFrame.jTtoolBarFormaPagoPuntoVenta.setBorder(borderResaltar);
		*/
		this.resaltartarjeta_habienteFormaPagoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartarjeta_habienteFormaPagoPuntoVenta() {
		return this.resaltartarjeta_habienteFormaPagoPuntoVenta;
	}

	public void setResaltartarjeta_habienteFormaPagoPuntoVenta(Border borderResaltar) {
		this.resaltartarjeta_habienteFormaPagoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrartarjeta_habienteFormaPagoPuntoVenta() {
		return this.mostrartarjeta_habienteFormaPagoPuntoVenta;
	}

	public void setMostrartarjeta_habienteFormaPagoPuntoVenta(Boolean mostrartarjeta_habienteFormaPagoPuntoVenta) {
		this.mostrartarjeta_habienteFormaPagoPuntoVenta= mostrartarjeta_habienteFormaPagoPuntoVenta;
	}

	public Boolean getActivartarjeta_habienteFormaPagoPuntoVenta() {
		return this.activartarjeta_habienteFormaPagoPuntoVenta;
	}

	public void setActivartarjeta_habienteFormaPagoPuntoVenta(Boolean activartarjeta_habienteFormaPagoPuntoVenta) {
		this.activartarjeta_habienteFormaPagoPuntoVenta= activartarjeta_habienteFormaPagoPuntoVenta;
	}

	public Border setResaltarautorizacionFormaPagoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoPuntoVentaBeanSwingJInternalFrame formapagopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//formapagopuntoventaBeanSwingJInternalFrame.jTtoolBarFormaPagoPuntoVenta.setBorder(borderResaltar);
		*/
		this.resaltarautorizacionFormaPagoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarautorizacionFormaPagoPuntoVenta() {
		return this.resaltarautorizacionFormaPagoPuntoVenta;
	}

	public void setResaltarautorizacionFormaPagoPuntoVenta(Border borderResaltar) {
		this.resaltarautorizacionFormaPagoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarautorizacionFormaPagoPuntoVenta() {
		return this.mostrarautorizacionFormaPagoPuntoVenta;
	}

	public void setMostrarautorizacionFormaPagoPuntoVenta(Boolean mostrarautorizacionFormaPagoPuntoVenta) {
		this.mostrarautorizacionFormaPagoPuntoVenta= mostrarautorizacionFormaPagoPuntoVenta;
	}

	public Boolean getActivarautorizacionFormaPagoPuntoVenta() {
		return this.activarautorizacionFormaPagoPuntoVenta;
	}

	public void setActivarautorizacionFormaPagoPuntoVenta(Boolean activarautorizacionFormaPagoPuntoVenta) {
		this.activarautorizacionFormaPagoPuntoVenta= activarautorizacionFormaPagoPuntoVenta;
	}

	public Border setResaltarvoucherFormaPagoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoPuntoVentaBeanSwingJInternalFrame formapagopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//formapagopuntoventaBeanSwingJInternalFrame.jTtoolBarFormaPagoPuntoVenta.setBorder(borderResaltar);
		*/
		this.resaltarvoucherFormaPagoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvoucherFormaPagoPuntoVenta() {
		return this.resaltarvoucherFormaPagoPuntoVenta;
	}

	public void setResaltarvoucherFormaPagoPuntoVenta(Border borderResaltar) {
		this.resaltarvoucherFormaPagoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarvoucherFormaPagoPuntoVenta() {
		return this.mostrarvoucherFormaPagoPuntoVenta;
	}

	public void setMostrarvoucherFormaPagoPuntoVenta(Boolean mostrarvoucherFormaPagoPuntoVenta) {
		this.mostrarvoucherFormaPagoPuntoVenta= mostrarvoucherFormaPagoPuntoVenta;
	}

	public Boolean getActivarvoucherFormaPagoPuntoVenta() {
		return this.activarvoucherFormaPagoPuntoVenta;
	}

	public void setActivarvoucherFormaPagoPuntoVenta(Boolean activarvoucherFormaPagoPuntoVenta) {
		this.activarvoucherFormaPagoPuntoVenta= activarvoucherFormaPagoPuntoVenta;
	}

	public Border setResaltarloteFormaPagoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoPuntoVentaBeanSwingJInternalFrame formapagopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//formapagopuntoventaBeanSwingJInternalFrame.jTtoolBarFormaPagoPuntoVenta.setBorder(borderResaltar);
		*/
		this.resaltarloteFormaPagoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarloteFormaPagoPuntoVenta() {
		return this.resaltarloteFormaPagoPuntoVenta;
	}

	public void setResaltarloteFormaPagoPuntoVenta(Border borderResaltar) {
		this.resaltarloteFormaPagoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarloteFormaPagoPuntoVenta() {
		return this.mostrarloteFormaPagoPuntoVenta;
	}

	public void setMostrarloteFormaPagoPuntoVenta(Boolean mostrarloteFormaPagoPuntoVenta) {
		this.mostrarloteFormaPagoPuntoVenta= mostrarloteFormaPagoPuntoVenta;
	}

	public Boolean getActivarloteFormaPagoPuntoVenta() {
		return this.activarloteFormaPagoPuntoVenta;
	}

	public void setActivarloteFormaPagoPuntoVenta(Boolean activarloteFormaPagoPuntoVenta) {
		this.activarloteFormaPagoPuntoVenta= activarloteFormaPagoPuntoVenta;
	}

	public Border setResaltarcuotaFormaPagoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoPuntoVentaBeanSwingJInternalFrame formapagopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//formapagopuntoventaBeanSwingJInternalFrame.jTtoolBarFormaPagoPuntoVenta.setBorder(borderResaltar);
		*/
		this.resaltarcuotaFormaPagoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcuotaFormaPagoPuntoVenta() {
		return this.resaltarcuotaFormaPagoPuntoVenta;
	}

	public void setResaltarcuotaFormaPagoPuntoVenta(Border borderResaltar) {
		this.resaltarcuotaFormaPagoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarcuotaFormaPagoPuntoVenta() {
		return this.mostrarcuotaFormaPagoPuntoVenta;
	}

	public void setMostrarcuotaFormaPagoPuntoVenta(Boolean mostrarcuotaFormaPagoPuntoVenta) {
		this.mostrarcuotaFormaPagoPuntoVenta= mostrarcuotaFormaPagoPuntoVenta;
	}

	public Boolean getActivarcuotaFormaPagoPuntoVenta() {
		return this.activarcuotaFormaPagoPuntoVenta;
	}

	public void setActivarcuotaFormaPagoPuntoVenta(Boolean activarcuotaFormaPagoPuntoVenta) {
		this.activarcuotaFormaPagoPuntoVenta= activarcuotaFormaPagoPuntoVenta;
	}

	public Border setResaltarvalor_retencionFormaPagoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoPuntoVentaBeanSwingJInternalFrame formapagopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//formapagopuntoventaBeanSwingJInternalFrame.jTtoolBarFormaPagoPuntoVenta.setBorder(borderResaltar);
		*/
		this.resaltarvalor_retencionFormaPagoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_retencionFormaPagoPuntoVenta() {
		return this.resaltarvalor_retencionFormaPagoPuntoVenta;
	}

	public void setResaltarvalor_retencionFormaPagoPuntoVenta(Border borderResaltar) {
		this.resaltarvalor_retencionFormaPagoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarvalor_retencionFormaPagoPuntoVenta() {
		return this.mostrarvalor_retencionFormaPagoPuntoVenta;
	}

	public void setMostrarvalor_retencionFormaPagoPuntoVenta(Boolean mostrarvalor_retencionFormaPagoPuntoVenta) {
		this.mostrarvalor_retencionFormaPagoPuntoVenta= mostrarvalor_retencionFormaPagoPuntoVenta;
	}

	public Boolean getActivarvalor_retencionFormaPagoPuntoVenta() {
		return this.activarvalor_retencionFormaPagoPuntoVenta;
	}

	public void setActivarvalor_retencionFormaPagoPuntoVenta(Boolean activarvalor_retencionFormaPagoPuntoVenta) {
		this.activarvalor_retencionFormaPagoPuntoVenta= activarvalor_retencionFormaPagoPuntoVenta;
	}

	public Border setResaltarvalor_comisionFormaPagoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoPuntoVentaBeanSwingJInternalFrame formapagopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//formapagopuntoventaBeanSwingJInternalFrame.jTtoolBarFormaPagoPuntoVenta.setBorder(borderResaltar);
		*/
		this.resaltarvalor_comisionFormaPagoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_comisionFormaPagoPuntoVenta() {
		return this.resaltarvalor_comisionFormaPagoPuntoVenta;
	}

	public void setResaltarvalor_comisionFormaPagoPuntoVenta(Border borderResaltar) {
		this.resaltarvalor_comisionFormaPagoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarvalor_comisionFormaPagoPuntoVenta() {
		return this.mostrarvalor_comisionFormaPagoPuntoVenta;
	}

	public void setMostrarvalor_comisionFormaPagoPuntoVenta(Boolean mostrarvalor_comisionFormaPagoPuntoVenta) {
		this.mostrarvalor_comisionFormaPagoPuntoVenta= mostrarvalor_comisionFormaPagoPuntoVenta;
	}

	public Boolean getActivarvalor_comisionFormaPagoPuntoVenta() {
		return this.activarvalor_comisionFormaPagoPuntoVenta;
	}

	public void setActivarvalor_comisionFormaPagoPuntoVenta(Boolean activarvalor_comisionFormaPagoPuntoVenta) {
		this.activarvalor_comisionFormaPagoPuntoVenta= activarvalor_comisionFormaPagoPuntoVenta;
	}

	public Border setResaltarvalor_calculadoFormaPagoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoPuntoVentaBeanSwingJInternalFrame formapagopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//formapagopuntoventaBeanSwingJInternalFrame.jTtoolBarFormaPagoPuntoVenta.setBorder(borderResaltar);
		*/
		this.resaltarvalor_calculadoFormaPagoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_calculadoFormaPagoPuntoVenta() {
		return this.resaltarvalor_calculadoFormaPagoPuntoVenta;
	}

	public void setResaltarvalor_calculadoFormaPagoPuntoVenta(Border borderResaltar) {
		this.resaltarvalor_calculadoFormaPagoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarvalor_calculadoFormaPagoPuntoVenta() {
		return this.mostrarvalor_calculadoFormaPagoPuntoVenta;
	}

	public void setMostrarvalor_calculadoFormaPagoPuntoVenta(Boolean mostrarvalor_calculadoFormaPagoPuntoVenta) {
		this.mostrarvalor_calculadoFormaPagoPuntoVenta= mostrarvalor_calculadoFormaPagoPuntoVenta;
	}

	public Boolean getActivarvalor_calculadoFormaPagoPuntoVenta() {
		return this.activarvalor_calculadoFormaPagoPuntoVenta;
	}

	public void setActivarvalor_calculadoFormaPagoPuntoVenta(Boolean activarvalor_calculadoFormaPagoPuntoVenta) {
		this.activarvalor_calculadoFormaPagoPuntoVenta= activarvalor_calculadoFormaPagoPuntoVenta;
	}

	public Border setResaltarvalor_canceladoFormaPagoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoPuntoVentaBeanSwingJInternalFrame formapagopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//formapagopuntoventaBeanSwingJInternalFrame.jTtoolBarFormaPagoPuntoVenta.setBorder(borderResaltar);
		*/
		this.resaltarvalor_canceladoFormaPagoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_canceladoFormaPagoPuntoVenta() {
		return this.resaltarvalor_canceladoFormaPagoPuntoVenta;
	}

	public void setResaltarvalor_canceladoFormaPagoPuntoVenta(Border borderResaltar) {
		this.resaltarvalor_canceladoFormaPagoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarvalor_canceladoFormaPagoPuntoVenta() {
		return this.mostrarvalor_canceladoFormaPagoPuntoVenta;
	}

	public void setMostrarvalor_canceladoFormaPagoPuntoVenta(Boolean mostrarvalor_canceladoFormaPagoPuntoVenta) {
		this.mostrarvalor_canceladoFormaPagoPuntoVenta= mostrarvalor_canceladoFormaPagoPuntoVenta;
	}

	public Boolean getActivarvalor_canceladoFormaPagoPuntoVenta() {
		return this.activarvalor_canceladoFormaPagoPuntoVenta;
	}

	public void setActivarvalor_canceladoFormaPagoPuntoVenta(Boolean activarvalor_canceladoFormaPagoPuntoVenta) {
		this.activarvalor_canceladoFormaPagoPuntoVenta= activarvalor_canceladoFormaPagoPuntoVenta;
	}

	public Border setResaltarvalor_difiereFormaPagoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoPuntoVentaBeanSwingJInternalFrame formapagopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//formapagopuntoventaBeanSwingJInternalFrame.jTtoolBarFormaPagoPuntoVenta.setBorder(borderResaltar);
		*/
		this.resaltarvalor_difiereFormaPagoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_difiereFormaPagoPuntoVenta() {
		return this.resaltarvalor_difiereFormaPagoPuntoVenta;
	}

	public void setResaltarvalor_difiereFormaPagoPuntoVenta(Border borderResaltar) {
		this.resaltarvalor_difiereFormaPagoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarvalor_difiereFormaPagoPuntoVenta() {
		return this.mostrarvalor_difiereFormaPagoPuntoVenta;
	}

	public void setMostrarvalor_difiereFormaPagoPuntoVenta(Boolean mostrarvalor_difiereFormaPagoPuntoVenta) {
		this.mostrarvalor_difiereFormaPagoPuntoVenta= mostrarvalor_difiereFormaPagoPuntoVenta;
	}

	public Boolean getActivarvalor_difiereFormaPagoPuntoVenta() {
		return this.activarvalor_difiereFormaPagoPuntoVenta;
	}

	public void setActivarvalor_difiereFormaPagoPuntoVenta(Boolean activarvalor_difiereFormaPagoPuntoVenta) {
		this.activarvalor_difiereFormaPagoPuntoVenta= activarvalor_difiereFormaPagoPuntoVenta;
	}

	public Border setResaltarnumero_retencionFormaPagoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoPuntoVentaBeanSwingJInternalFrame formapagopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//formapagopuntoventaBeanSwingJInternalFrame.jTtoolBarFormaPagoPuntoVenta.setBorder(borderResaltar);
		*/
		this.resaltarnumero_retencionFormaPagoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_retencionFormaPagoPuntoVenta() {
		return this.resaltarnumero_retencionFormaPagoPuntoVenta;
	}

	public void setResaltarnumero_retencionFormaPagoPuntoVenta(Border borderResaltar) {
		this.resaltarnumero_retencionFormaPagoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarnumero_retencionFormaPagoPuntoVenta() {
		return this.mostrarnumero_retencionFormaPagoPuntoVenta;
	}

	public void setMostrarnumero_retencionFormaPagoPuntoVenta(Boolean mostrarnumero_retencionFormaPagoPuntoVenta) {
		this.mostrarnumero_retencionFormaPagoPuntoVenta= mostrarnumero_retencionFormaPagoPuntoVenta;
	}

	public Boolean getActivarnumero_retencionFormaPagoPuntoVenta() {
		return this.activarnumero_retencionFormaPagoPuntoVenta;
	}

	public void setActivarnumero_retencionFormaPagoPuntoVenta(Boolean activarnumero_retencionFormaPagoPuntoVenta) {
		this.activarnumero_retencionFormaPagoPuntoVenta= activarnumero_retencionFormaPagoPuntoVenta;
	}

	public Border setResaltarnumero_liquidacionFormaPagoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoPuntoVentaBeanSwingJInternalFrame formapagopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//formapagopuntoventaBeanSwingJInternalFrame.jTtoolBarFormaPagoPuntoVenta.setBorder(borderResaltar);
		*/
		this.resaltarnumero_liquidacionFormaPagoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_liquidacionFormaPagoPuntoVenta() {
		return this.resaltarnumero_liquidacionFormaPagoPuntoVenta;
	}

	public void setResaltarnumero_liquidacionFormaPagoPuntoVenta(Border borderResaltar) {
		this.resaltarnumero_liquidacionFormaPagoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarnumero_liquidacionFormaPagoPuntoVenta() {
		return this.mostrarnumero_liquidacionFormaPagoPuntoVenta;
	}

	public void setMostrarnumero_liquidacionFormaPagoPuntoVenta(Boolean mostrarnumero_liquidacionFormaPagoPuntoVenta) {
		this.mostrarnumero_liquidacionFormaPagoPuntoVenta= mostrarnumero_liquidacionFormaPagoPuntoVenta;
	}

	public Boolean getActivarnumero_liquidacionFormaPagoPuntoVenta() {
		return this.activarnumero_liquidacionFormaPagoPuntoVenta;
	}

	public void setActivarnumero_liquidacionFormaPagoPuntoVenta(Boolean activarnumero_liquidacionFormaPagoPuntoVenta) {
		this.activarnumero_liquidacionFormaPagoPuntoVenta= activarnumero_liquidacionFormaPagoPuntoVenta;
	}

	public Border setResaltarid_anioFormaPagoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoPuntoVentaBeanSwingJInternalFrame formapagopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//formapagopuntoventaBeanSwingJInternalFrame.jTtoolBarFormaPagoPuntoVenta.setBorder(borderResaltar);
		*/
		this.resaltarid_anioFormaPagoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioFormaPagoPuntoVenta() {
		return this.resaltarid_anioFormaPagoPuntoVenta;
	}

	public void setResaltarid_anioFormaPagoPuntoVenta(Border borderResaltar) {
		this.resaltarid_anioFormaPagoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_anioFormaPagoPuntoVenta() {
		return this.mostrarid_anioFormaPagoPuntoVenta;
	}

	public void setMostrarid_anioFormaPagoPuntoVenta(Boolean mostrarid_anioFormaPagoPuntoVenta) {
		this.mostrarid_anioFormaPagoPuntoVenta= mostrarid_anioFormaPagoPuntoVenta;
	}

	public Boolean getActivarid_anioFormaPagoPuntoVenta() {
		return this.activarid_anioFormaPagoPuntoVenta;
	}

	public void setActivarid_anioFormaPagoPuntoVenta(Boolean activarid_anioFormaPagoPuntoVenta) {
		this.activarid_anioFormaPagoPuntoVenta= activarid_anioFormaPagoPuntoVenta;
	}

	public Boolean getCargarid_anioFormaPagoPuntoVenta() {
		return this.cargarid_anioFormaPagoPuntoVenta;
	}

	public void setCargarid_anioFormaPagoPuntoVenta(Boolean cargarid_anioFormaPagoPuntoVenta) {
		this.cargarid_anioFormaPagoPuntoVenta= cargarid_anioFormaPagoPuntoVenta;
	}

	public Border setResaltarid_cuenta_contableFormaPagoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoPuntoVentaBeanSwingJInternalFrame formapagopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//formapagopuntoventaBeanSwingJInternalFrame.jTtoolBarFormaPagoPuntoVenta.setBorder(borderResaltar);
		*/
		this.resaltarid_cuenta_contableFormaPagoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contableFormaPagoPuntoVenta() {
		return this.resaltarid_cuenta_contableFormaPagoPuntoVenta;
	}

	public void setResaltarid_cuenta_contableFormaPagoPuntoVenta(Border borderResaltar) {
		this.resaltarid_cuenta_contableFormaPagoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contableFormaPagoPuntoVenta() {
		return this.mostrarid_cuenta_contableFormaPagoPuntoVenta;
	}

	public void setMostrarid_cuenta_contableFormaPagoPuntoVenta(Boolean mostrarid_cuenta_contableFormaPagoPuntoVenta) {
		this.mostrarid_cuenta_contableFormaPagoPuntoVenta= mostrarid_cuenta_contableFormaPagoPuntoVenta;
	}

	public Boolean getActivarid_cuenta_contableFormaPagoPuntoVenta() {
		return this.activarid_cuenta_contableFormaPagoPuntoVenta;
	}

	public void setActivarid_cuenta_contableFormaPagoPuntoVenta(Boolean activarid_cuenta_contableFormaPagoPuntoVenta) {
		this.activarid_cuenta_contableFormaPagoPuntoVenta= activarid_cuenta_contableFormaPagoPuntoVenta;
	}

	public Boolean getCargarid_cuenta_contableFormaPagoPuntoVenta() {
		return this.cargarid_cuenta_contableFormaPagoPuntoVenta;
	}

	public void setCargarid_cuenta_contableFormaPagoPuntoVenta(Boolean cargarid_cuenta_contableFormaPagoPuntoVenta) {
		this.cargarid_cuenta_contableFormaPagoPuntoVenta= cargarid_cuenta_contableFormaPagoPuntoVenta;
	}

	public Border setResaltarid_asiento_contableFormaPagoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoPuntoVentaBeanSwingJInternalFrame formapagopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//formapagopuntoventaBeanSwingJInternalFrame.jTtoolBarFormaPagoPuntoVenta.setBorder(borderResaltar);
		*/
		this.resaltarid_asiento_contableFormaPagoPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_asiento_contableFormaPagoPuntoVenta() {
		return this.resaltarid_asiento_contableFormaPagoPuntoVenta;
	}

	public void setResaltarid_asiento_contableFormaPagoPuntoVenta(Border borderResaltar) {
		this.resaltarid_asiento_contableFormaPagoPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_asiento_contableFormaPagoPuntoVenta() {
		return this.mostrarid_asiento_contableFormaPagoPuntoVenta;
	}

	public void setMostrarid_asiento_contableFormaPagoPuntoVenta(Boolean mostrarid_asiento_contableFormaPagoPuntoVenta) {
		this.mostrarid_asiento_contableFormaPagoPuntoVenta= mostrarid_asiento_contableFormaPagoPuntoVenta;
	}

	public Boolean getActivarid_asiento_contableFormaPagoPuntoVenta() {
		return this.activarid_asiento_contableFormaPagoPuntoVenta;
	}

	public void setActivarid_asiento_contableFormaPagoPuntoVenta(Boolean activarid_asiento_contableFormaPagoPuntoVenta) {
		this.activarid_asiento_contableFormaPagoPuntoVenta= activarid_asiento_contableFormaPagoPuntoVenta;
	}

	public Boolean getCargarid_asiento_contableFormaPagoPuntoVenta() {
		return this.cargarid_asiento_contableFormaPagoPuntoVenta;
	}

	public void setCargarid_asiento_contableFormaPagoPuntoVenta(Boolean cargarid_asiento_contableFormaPagoPuntoVenta) {
		this.cargarid_asiento_contableFormaPagoPuntoVenta= cargarid_asiento_contableFormaPagoPuntoVenta;
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
		
		
		this.setMostraridFormaPagoPuntoVenta(esInicial);
		this.setMostrarid_empresaFormaPagoPuntoVenta(esInicial);
		this.setMostrarid_sucursalFormaPagoPuntoVenta(esInicial);
		this.setMostrarid_ejercicioFormaPagoPuntoVenta(esInicial);
		this.setMostrarid_periodoFormaPagoPuntoVenta(esInicial);
		this.setMostrarid_factura_punto_ventaFormaPagoPuntoVenta(esInicial);
		this.setMostrarid_tipo_forma_pagoFormaPagoPuntoVenta(esInicial);
		this.setMostrarporcentajeFormaPagoPuntoVenta(esInicial);
		this.setMostrarvalorFormaPagoPuntoVenta(esInicial);
		this.setMostrarfechaFormaPagoPuntoVenta(esInicial);
		this.setMostrardescripcionFormaPagoPuntoVenta(esInicial);
		this.setMostrarfecha_inicioFormaPagoPuntoVenta(esInicial);
		this.setMostrarnumero_dias_plazoFormaPagoPuntoVenta(esInicial);
		this.setMostrarfecha_finFormaPagoPuntoVenta(esInicial);
		this.setMostrarid_bancoFormaPagoPuntoVenta(esInicial);
		this.setMostrarid_cuenta_banco_pun_venFormaPagoPuntoVenta(esInicial);
		this.setMostrarid_tipo_riesgo_chequeFormaPagoPuntoVenta(esInicial);
		this.setMostrarnumero_cuentaFormaPagoPuntoVenta(esInicial);
		this.setMostrarnumero_chequeFormaPagoPuntoVenta(esInicial);
		this.setMostrargiradorFormaPagoPuntoVenta(esInicial);
		this.setMostrarid_banco_tarjetaFormaPagoPuntoVenta(esInicial);
		this.setMostrarid_tarjeta_creditoFormaPagoPuntoVenta(esInicial);
		this.setMostrarid_tipo_interes_tarjetaFormaPagoPuntoVenta(esInicial);
		this.setMostrarid_tipo_pago_tarjetaFormaPagoPuntoVenta(esInicial);
		this.setMostrarid_conexionFormaPagoPuntoVenta(esInicial);
		this.setMostrarid_mesFormaPagoPuntoVenta(esInicial);
		this.setMostrarnumeroFormaPagoPuntoVenta(esInicial);
		this.setMostrartarjeta_habienteFormaPagoPuntoVenta(esInicial);
		this.setMostrarautorizacionFormaPagoPuntoVenta(esInicial);
		this.setMostrarvoucherFormaPagoPuntoVenta(esInicial);
		this.setMostrarloteFormaPagoPuntoVenta(esInicial);
		this.setMostrarcuotaFormaPagoPuntoVenta(esInicial);
		this.setMostrarvalor_retencionFormaPagoPuntoVenta(esInicial);
		this.setMostrarvalor_comisionFormaPagoPuntoVenta(esInicial);
		this.setMostrarvalor_calculadoFormaPagoPuntoVenta(esInicial);
		this.setMostrarvalor_canceladoFormaPagoPuntoVenta(esInicial);
		this.setMostrarvalor_difiereFormaPagoPuntoVenta(esInicial);
		this.setMostrarnumero_retencionFormaPagoPuntoVenta(esInicial);
		this.setMostrarnumero_liquidacionFormaPagoPuntoVenta(esInicial);
		this.setMostrarid_anioFormaPagoPuntoVenta(esInicial);
		this.setMostrarid_cuenta_contableFormaPagoPuntoVenta(esInicial);
		this.setMostrarid_asiento_contableFormaPagoPuntoVenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.ID)) {
				this.setMostraridFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.IDFACTURAPUNTOVENTA)) {
				this.setMostrarid_factura_punto_ventaFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.IDTIPOFORMAPAGO)) {
				this.setMostrarid_tipo_forma_pagoFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.PORCENTAJE)) {
				this.setMostrarporcentajeFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.VALOR)) {
				this.setMostrarvalorFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.FECHA)) {
				this.setMostrarfechaFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.FECHAINICIO)) {
				this.setMostrarfecha_inicioFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.NUMERODIASPLAZO)) {
				this.setMostrarnumero_dias_plazoFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.FECHAFIN)) {
				this.setMostrarfecha_finFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.IDBANCO)) {
				this.setMostrarid_bancoFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.IDCUENTABANCOPUNVEN)) {
				this.setMostrarid_cuenta_banco_pun_venFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.IDTIPORIESGOCHEQUE)) {
				this.setMostrarid_tipo_riesgo_chequeFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.NUMEROCUENTA)) {
				this.setMostrarnumero_cuentaFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.NUMEROCHEQUE)) {
				this.setMostrarnumero_chequeFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.GIRADOR)) {
				this.setMostrargiradorFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.IDBANCOTARJETA)) {
				this.setMostrarid_banco_tarjetaFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.IDTARJETACREDITO)) {
				this.setMostrarid_tarjeta_creditoFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.IDTIPOINTERESTARJETA)) {
				this.setMostrarid_tipo_interes_tarjetaFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.IDTIPOPAGOTARJETA)) {
				this.setMostrarid_tipo_pago_tarjetaFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.IDCONEXION)) {
				this.setMostrarid_conexionFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.IDMES)) {
				this.setMostrarid_mesFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.NUMERO)) {
				this.setMostrarnumeroFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.TARJETAHABIENTE)) {
				this.setMostrartarjeta_habienteFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.AUTORIZACION)) {
				this.setMostrarautorizacionFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.VOUCHER)) {
				this.setMostrarvoucherFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.LOTE)) {
				this.setMostrarloteFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.CUOTA)) {
				this.setMostrarcuotaFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.VALORRETENCION)) {
				this.setMostrarvalor_retencionFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.VALORCOMISION)) {
				this.setMostrarvalor_comisionFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.VALORCALCULADO)) {
				this.setMostrarvalor_calculadoFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.VALORCANCELADO)) {
				this.setMostrarvalor_canceladoFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.VALORDIFIERE)) {
				this.setMostrarvalor_difiereFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.NUMERORETENCION)) {
				this.setMostrarnumero_retencionFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.NUMEROLIQUIDACION)) {
				this.setMostrarnumero_liquidacionFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.IDCUENTACONTABLE)) {
				this.setMostrarid_cuenta_contableFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setMostrarid_asiento_contableFormaPagoPuntoVenta(esAsigna);
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
		
		
		this.setActivaridFormaPagoPuntoVenta(esInicial);
		this.setActivarid_empresaFormaPagoPuntoVenta(esInicial);
		this.setActivarid_sucursalFormaPagoPuntoVenta(esInicial);
		this.setActivarid_ejercicioFormaPagoPuntoVenta(esInicial);
		this.setActivarid_periodoFormaPagoPuntoVenta(esInicial);
		this.setActivarid_factura_punto_ventaFormaPagoPuntoVenta(esInicial);
		this.setActivarid_tipo_forma_pagoFormaPagoPuntoVenta(esInicial);
		this.setActivarporcentajeFormaPagoPuntoVenta(esInicial);
		this.setActivarvalorFormaPagoPuntoVenta(esInicial);
		this.setActivarfechaFormaPagoPuntoVenta(esInicial);
		this.setActivardescripcionFormaPagoPuntoVenta(esInicial);
		this.setActivarfecha_inicioFormaPagoPuntoVenta(esInicial);
		this.setActivarnumero_dias_plazoFormaPagoPuntoVenta(esInicial);
		this.setActivarfecha_finFormaPagoPuntoVenta(esInicial);
		this.setActivarid_bancoFormaPagoPuntoVenta(esInicial);
		this.setActivarid_cuenta_banco_pun_venFormaPagoPuntoVenta(esInicial);
		this.setActivarid_tipo_riesgo_chequeFormaPagoPuntoVenta(esInicial);
		this.setActivarnumero_cuentaFormaPagoPuntoVenta(esInicial);
		this.setActivarnumero_chequeFormaPagoPuntoVenta(esInicial);
		this.setActivargiradorFormaPagoPuntoVenta(esInicial);
		this.setActivarid_banco_tarjetaFormaPagoPuntoVenta(esInicial);
		this.setActivarid_tarjeta_creditoFormaPagoPuntoVenta(esInicial);
		this.setActivarid_tipo_interes_tarjetaFormaPagoPuntoVenta(esInicial);
		this.setActivarid_tipo_pago_tarjetaFormaPagoPuntoVenta(esInicial);
		this.setActivarid_conexionFormaPagoPuntoVenta(esInicial);
		this.setActivarid_mesFormaPagoPuntoVenta(esInicial);
		this.setActivarnumeroFormaPagoPuntoVenta(esInicial);
		this.setActivartarjeta_habienteFormaPagoPuntoVenta(esInicial);
		this.setActivarautorizacionFormaPagoPuntoVenta(esInicial);
		this.setActivarvoucherFormaPagoPuntoVenta(esInicial);
		this.setActivarloteFormaPagoPuntoVenta(esInicial);
		this.setActivarcuotaFormaPagoPuntoVenta(esInicial);
		this.setActivarvalor_retencionFormaPagoPuntoVenta(esInicial);
		this.setActivarvalor_comisionFormaPagoPuntoVenta(esInicial);
		this.setActivarvalor_calculadoFormaPagoPuntoVenta(esInicial);
		this.setActivarvalor_canceladoFormaPagoPuntoVenta(esInicial);
		this.setActivarvalor_difiereFormaPagoPuntoVenta(esInicial);
		this.setActivarnumero_retencionFormaPagoPuntoVenta(esInicial);
		this.setActivarnumero_liquidacionFormaPagoPuntoVenta(esInicial);
		this.setActivarid_anioFormaPagoPuntoVenta(esInicial);
		this.setActivarid_cuenta_contableFormaPagoPuntoVenta(esInicial);
		this.setActivarid_asiento_contableFormaPagoPuntoVenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.ID)) {
				this.setActivaridFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.IDFACTURAPUNTOVENTA)) {
				this.setActivarid_factura_punto_ventaFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.IDTIPOFORMAPAGO)) {
				this.setActivarid_tipo_forma_pagoFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.PORCENTAJE)) {
				this.setActivarporcentajeFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.VALOR)) {
				this.setActivarvalorFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.FECHA)) {
				this.setActivarfechaFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.FECHAINICIO)) {
				this.setActivarfecha_inicioFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.NUMERODIASPLAZO)) {
				this.setActivarnumero_dias_plazoFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.FECHAFIN)) {
				this.setActivarfecha_finFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.IDBANCO)) {
				this.setActivarid_bancoFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.IDCUENTABANCOPUNVEN)) {
				this.setActivarid_cuenta_banco_pun_venFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.IDTIPORIESGOCHEQUE)) {
				this.setActivarid_tipo_riesgo_chequeFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.NUMEROCUENTA)) {
				this.setActivarnumero_cuentaFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.NUMEROCHEQUE)) {
				this.setActivarnumero_chequeFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.GIRADOR)) {
				this.setActivargiradorFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.IDBANCOTARJETA)) {
				this.setActivarid_banco_tarjetaFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.IDTARJETACREDITO)) {
				this.setActivarid_tarjeta_creditoFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.IDTIPOINTERESTARJETA)) {
				this.setActivarid_tipo_interes_tarjetaFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.IDTIPOPAGOTARJETA)) {
				this.setActivarid_tipo_pago_tarjetaFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.IDCONEXION)) {
				this.setActivarid_conexionFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.IDMES)) {
				this.setActivarid_mesFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.NUMERO)) {
				this.setActivarnumeroFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.TARJETAHABIENTE)) {
				this.setActivartarjeta_habienteFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.AUTORIZACION)) {
				this.setActivarautorizacionFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.VOUCHER)) {
				this.setActivarvoucherFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.LOTE)) {
				this.setActivarloteFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.CUOTA)) {
				this.setActivarcuotaFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.VALORRETENCION)) {
				this.setActivarvalor_retencionFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.VALORCOMISION)) {
				this.setActivarvalor_comisionFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.VALORCALCULADO)) {
				this.setActivarvalor_calculadoFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.VALORCANCELADO)) {
				this.setActivarvalor_canceladoFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.VALORDIFIERE)) {
				this.setActivarvalor_difiereFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.NUMERORETENCION)) {
				this.setActivarnumero_retencionFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.NUMEROLIQUIDACION)) {
				this.setActivarnumero_liquidacionFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.IDANIO)) {
				this.setActivarid_anioFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.IDCUENTACONTABLE)) {
				this.setActivarid_cuenta_contableFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setActivarid_asiento_contableFormaPagoPuntoVenta(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,FormaPagoPuntoVentaBeanSwingJInternalFrame formapagopuntoventaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridFormaPagoPuntoVenta(esInicial);
		this.setResaltarid_empresaFormaPagoPuntoVenta(esInicial);
		this.setResaltarid_sucursalFormaPagoPuntoVenta(esInicial);
		this.setResaltarid_ejercicioFormaPagoPuntoVenta(esInicial);
		this.setResaltarid_periodoFormaPagoPuntoVenta(esInicial);
		this.setResaltarid_factura_punto_ventaFormaPagoPuntoVenta(esInicial);
		this.setResaltarid_tipo_forma_pagoFormaPagoPuntoVenta(esInicial);
		this.setResaltarporcentajeFormaPagoPuntoVenta(esInicial);
		this.setResaltarvalorFormaPagoPuntoVenta(esInicial);
		this.setResaltarfechaFormaPagoPuntoVenta(esInicial);
		this.setResaltardescripcionFormaPagoPuntoVenta(esInicial);
		this.setResaltarfecha_inicioFormaPagoPuntoVenta(esInicial);
		this.setResaltarnumero_dias_plazoFormaPagoPuntoVenta(esInicial);
		this.setResaltarfecha_finFormaPagoPuntoVenta(esInicial);
		this.setResaltarid_bancoFormaPagoPuntoVenta(esInicial);
		this.setResaltarid_cuenta_banco_pun_venFormaPagoPuntoVenta(esInicial);
		this.setResaltarid_tipo_riesgo_chequeFormaPagoPuntoVenta(esInicial);
		this.setResaltarnumero_cuentaFormaPagoPuntoVenta(esInicial);
		this.setResaltarnumero_chequeFormaPagoPuntoVenta(esInicial);
		this.setResaltargiradorFormaPagoPuntoVenta(esInicial);
		this.setResaltarid_banco_tarjetaFormaPagoPuntoVenta(esInicial);
		this.setResaltarid_tarjeta_creditoFormaPagoPuntoVenta(esInicial);
		this.setResaltarid_tipo_interes_tarjetaFormaPagoPuntoVenta(esInicial);
		this.setResaltarid_tipo_pago_tarjetaFormaPagoPuntoVenta(esInicial);
		this.setResaltarid_conexionFormaPagoPuntoVenta(esInicial);
		this.setResaltarid_mesFormaPagoPuntoVenta(esInicial);
		this.setResaltarnumeroFormaPagoPuntoVenta(esInicial);
		this.setResaltartarjeta_habienteFormaPagoPuntoVenta(esInicial);
		this.setResaltarautorizacionFormaPagoPuntoVenta(esInicial);
		this.setResaltarvoucherFormaPagoPuntoVenta(esInicial);
		this.setResaltarloteFormaPagoPuntoVenta(esInicial);
		this.setResaltarcuotaFormaPagoPuntoVenta(esInicial);
		this.setResaltarvalor_retencionFormaPagoPuntoVenta(esInicial);
		this.setResaltarvalor_comisionFormaPagoPuntoVenta(esInicial);
		this.setResaltarvalor_calculadoFormaPagoPuntoVenta(esInicial);
		this.setResaltarvalor_canceladoFormaPagoPuntoVenta(esInicial);
		this.setResaltarvalor_difiereFormaPagoPuntoVenta(esInicial);
		this.setResaltarnumero_retencionFormaPagoPuntoVenta(esInicial);
		this.setResaltarnumero_liquidacionFormaPagoPuntoVenta(esInicial);
		this.setResaltarid_anioFormaPagoPuntoVenta(esInicial);
		this.setResaltarid_cuenta_contableFormaPagoPuntoVenta(esInicial);
		this.setResaltarid_asiento_contableFormaPagoPuntoVenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.ID)) {
				this.setResaltaridFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.IDFACTURAPUNTOVENTA)) {
				this.setResaltarid_factura_punto_ventaFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.IDTIPOFORMAPAGO)) {
				this.setResaltarid_tipo_forma_pagoFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.PORCENTAJE)) {
				this.setResaltarporcentajeFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.VALOR)) {
				this.setResaltarvalorFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.FECHA)) {
				this.setResaltarfechaFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.FECHAINICIO)) {
				this.setResaltarfecha_inicioFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.NUMERODIASPLAZO)) {
				this.setResaltarnumero_dias_plazoFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.FECHAFIN)) {
				this.setResaltarfecha_finFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.IDBANCO)) {
				this.setResaltarid_bancoFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.IDCUENTABANCOPUNVEN)) {
				this.setResaltarid_cuenta_banco_pun_venFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.IDTIPORIESGOCHEQUE)) {
				this.setResaltarid_tipo_riesgo_chequeFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.NUMEROCUENTA)) {
				this.setResaltarnumero_cuentaFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.NUMEROCHEQUE)) {
				this.setResaltarnumero_chequeFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.GIRADOR)) {
				this.setResaltargiradorFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.IDBANCOTARJETA)) {
				this.setResaltarid_banco_tarjetaFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.IDTARJETACREDITO)) {
				this.setResaltarid_tarjeta_creditoFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.IDTIPOINTERESTARJETA)) {
				this.setResaltarid_tipo_interes_tarjetaFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.IDTIPOPAGOTARJETA)) {
				this.setResaltarid_tipo_pago_tarjetaFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.IDCONEXION)) {
				this.setResaltarid_conexionFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.IDMES)) {
				this.setResaltarid_mesFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.NUMERO)) {
				this.setResaltarnumeroFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.TARJETAHABIENTE)) {
				this.setResaltartarjeta_habienteFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.AUTORIZACION)) {
				this.setResaltarautorizacionFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.VOUCHER)) {
				this.setResaltarvoucherFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.LOTE)) {
				this.setResaltarloteFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.CUOTA)) {
				this.setResaltarcuotaFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.VALORRETENCION)) {
				this.setResaltarvalor_retencionFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.VALORCOMISION)) {
				this.setResaltarvalor_comisionFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.VALORCALCULADO)) {
				this.setResaltarvalor_calculadoFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.VALORCANCELADO)) {
				this.setResaltarvalor_canceladoFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.VALORDIFIERE)) {
				this.setResaltarvalor_difiereFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.NUMERORETENCION)) {
				this.setResaltarnumero_retencionFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.NUMEROLIQUIDACION)) {
				this.setResaltarnumero_liquidacionFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.IDCUENTACONTABLE)) {
				this.setResaltarid_cuenta_contableFormaPagoPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(FormaPagoPuntoVentaConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setResaltarid_asiento_contableFormaPagoPuntoVenta(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,FormaPagoPuntoVentaBeanSwingJInternalFrame formapagopuntoventaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdAsientoContableFormaPagoPuntoVenta=true;

	public Boolean getMostrarFK_IdAsientoContableFormaPagoPuntoVenta() {
		return this.mostrarFK_IdAsientoContableFormaPagoPuntoVenta;
	}

	public void setMostrarFK_IdAsientoContableFormaPagoPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdAsientoContableFormaPagoPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdBancoFormaPagoPuntoVenta=true;

	public Boolean getMostrarFK_IdBancoFormaPagoPuntoVenta() {
		return this.mostrarFK_IdBancoFormaPagoPuntoVenta;
	}

	public void setMostrarFK_IdBancoFormaPagoPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBancoFormaPagoPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdBancoTarjetaFormaPagoPuntoVenta=true;

	public Boolean getMostrarFK_IdBancoTarjetaFormaPagoPuntoVenta() {
		return this.mostrarFK_IdBancoTarjetaFormaPagoPuntoVenta;
	}

	public void setMostrarFK_IdBancoTarjetaFormaPagoPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBancoTarjetaFormaPagoPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdConexionFormaPagoPuntoVenta=true;

	public Boolean getMostrarFK_IdConexionFormaPagoPuntoVenta() {
		return this.mostrarFK_IdConexionFormaPagoPuntoVenta;
	}

	public void setMostrarFK_IdConexionFormaPagoPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdConexionFormaPagoPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaBancoPunVenFormaPagoPuntoVenta=true;

	public Boolean getMostrarFK_IdCuentaBancoPunVenFormaPagoPuntoVenta() {
		return this.mostrarFK_IdCuentaBancoPunVenFormaPagoPuntoVenta;
	}

	public void setMostrarFK_IdCuentaBancoPunVenFormaPagoPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaBancoPunVenFormaPagoPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableFormaPagoPuntoVenta=true;

	public Boolean getMostrarFK_IdCuentaContableFormaPagoPuntoVenta() {
		return this.mostrarFK_IdCuentaContableFormaPagoPuntoVenta;
	}

	public void setMostrarFK_IdCuentaContableFormaPagoPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableFormaPagoPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioFormaPagoPuntoVenta=true;

	public Boolean getMostrarFK_IdEjercicioFormaPagoPuntoVenta() {
		return this.mostrarFK_IdEjercicioFormaPagoPuntoVenta;
	}

	public void setMostrarFK_IdEjercicioFormaPagoPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioFormaPagoPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaFormaPagoPuntoVenta=true;

	public Boolean getMostrarFK_IdEmpresaFormaPagoPuntoVenta() {
		return this.mostrarFK_IdEmpresaFormaPagoPuntoVenta;
	}

	public void setMostrarFK_IdEmpresaFormaPagoPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaFormaPagoPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFacturaPuntoVentaFormaPagoPuntoVenta=true;

	public Boolean getMostrarFK_IdFacturaPuntoVentaFormaPagoPuntoVenta() {
		return this.mostrarFK_IdFacturaPuntoVentaFormaPagoPuntoVenta;
	}

	public void setMostrarFK_IdFacturaPuntoVentaFormaPagoPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFacturaPuntoVentaFormaPagoPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoFormaPagoPuntoVenta=true;

	public Boolean getMostrarFK_IdPeriodoFormaPagoPuntoVenta() {
		return this.mostrarFK_IdPeriodoFormaPagoPuntoVenta;
	}

	public void setMostrarFK_IdPeriodoFormaPagoPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoFormaPagoPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalFormaPagoPuntoVenta=true;

	public Boolean getMostrarFK_IdSucursalFormaPagoPuntoVenta() {
		return this.mostrarFK_IdSucursalFormaPagoPuntoVenta;
	}

	public void setMostrarFK_IdSucursalFormaPagoPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalFormaPagoPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTarjetaCreditoFormaPagoPuntoVenta=true;

	public Boolean getMostrarFK_IdTarjetaCreditoFormaPagoPuntoVenta() {
		return this.mostrarFK_IdTarjetaCreditoFormaPagoPuntoVenta;
	}

	public void setMostrarFK_IdTarjetaCreditoFormaPagoPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTarjetaCreditoFormaPagoPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoFormaPagoFormaPagoPuntoVenta=true;

	public Boolean getMostrarFK_IdTipoFormaPagoFormaPagoPuntoVenta() {
		return this.mostrarFK_IdTipoFormaPagoFormaPagoPuntoVenta;
	}

	public void setMostrarFK_IdTipoFormaPagoFormaPagoPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoFormaPagoFormaPagoPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoInteresTarjetaFormaPagoPuntoVenta=true;

	public Boolean getMostrarFK_IdTipoInteresTarjetaFormaPagoPuntoVenta() {
		return this.mostrarFK_IdTipoInteresTarjetaFormaPagoPuntoVenta;
	}

	public void setMostrarFK_IdTipoInteresTarjetaFormaPagoPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoInteresTarjetaFormaPagoPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoPagoTarjetaFormaPagoPuntoVenta=true;

	public Boolean getMostrarFK_IdTipoPagoTarjetaFormaPagoPuntoVenta() {
		return this.mostrarFK_IdTipoPagoTarjetaFormaPagoPuntoVenta;
	}

	public void setMostrarFK_IdTipoPagoTarjetaFormaPagoPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoPagoTarjetaFormaPagoPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoRiesgoChequeFormaPagoPuntoVenta=true;

	public Boolean getMostrarFK_IdTipoRiesgoChequeFormaPagoPuntoVenta() {
		return this.mostrarFK_IdTipoRiesgoChequeFormaPagoPuntoVenta;
	}

	public void setMostrarFK_IdTipoRiesgoChequeFormaPagoPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoRiesgoChequeFormaPagoPuntoVenta= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdAsientoContableFormaPagoPuntoVenta=true;

	public Boolean getActivarFK_IdAsientoContableFormaPagoPuntoVenta() {
		return this.activarFK_IdAsientoContableFormaPagoPuntoVenta;
	}

	public void setActivarFK_IdAsientoContableFormaPagoPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdAsientoContableFormaPagoPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdBancoFormaPagoPuntoVenta=true;

	public Boolean getActivarFK_IdBancoFormaPagoPuntoVenta() {
		return this.activarFK_IdBancoFormaPagoPuntoVenta;
	}

	public void setActivarFK_IdBancoFormaPagoPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdBancoFormaPagoPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdBancoTarjetaFormaPagoPuntoVenta=true;

	public Boolean getActivarFK_IdBancoTarjetaFormaPagoPuntoVenta() {
		return this.activarFK_IdBancoTarjetaFormaPagoPuntoVenta;
	}

	public void setActivarFK_IdBancoTarjetaFormaPagoPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdBancoTarjetaFormaPagoPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdConexionFormaPagoPuntoVenta=true;

	public Boolean getActivarFK_IdConexionFormaPagoPuntoVenta() {
		return this.activarFK_IdConexionFormaPagoPuntoVenta;
	}

	public void setActivarFK_IdConexionFormaPagoPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdConexionFormaPagoPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaBancoPunVenFormaPagoPuntoVenta=true;

	public Boolean getActivarFK_IdCuentaBancoPunVenFormaPagoPuntoVenta() {
		return this.activarFK_IdCuentaBancoPunVenFormaPagoPuntoVenta;
	}

	public void setActivarFK_IdCuentaBancoPunVenFormaPagoPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaBancoPunVenFormaPagoPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableFormaPagoPuntoVenta=true;

	public Boolean getActivarFK_IdCuentaContableFormaPagoPuntoVenta() {
		return this.activarFK_IdCuentaContableFormaPagoPuntoVenta;
	}

	public void setActivarFK_IdCuentaContableFormaPagoPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableFormaPagoPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioFormaPagoPuntoVenta=true;

	public Boolean getActivarFK_IdEjercicioFormaPagoPuntoVenta() {
		return this.activarFK_IdEjercicioFormaPagoPuntoVenta;
	}

	public void setActivarFK_IdEjercicioFormaPagoPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioFormaPagoPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaFormaPagoPuntoVenta=true;

	public Boolean getActivarFK_IdEmpresaFormaPagoPuntoVenta() {
		return this.activarFK_IdEmpresaFormaPagoPuntoVenta;
	}

	public void setActivarFK_IdEmpresaFormaPagoPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaFormaPagoPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdFacturaPuntoVentaFormaPagoPuntoVenta=true;

	public Boolean getActivarFK_IdFacturaPuntoVentaFormaPagoPuntoVenta() {
		return this.activarFK_IdFacturaPuntoVentaFormaPagoPuntoVenta;
	}

	public void setActivarFK_IdFacturaPuntoVentaFormaPagoPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdFacturaPuntoVentaFormaPagoPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoFormaPagoPuntoVenta=true;

	public Boolean getActivarFK_IdPeriodoFormaPagoPuntoVenta() {
		return this.activarFK_IdPeriodoFormaPagoPuntoVenta;
	}

	public void setActivarFK_IdPeriodoFormaPagoPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoFormaPagoPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalFormaPagoPuntoVenta=true;

	public Boolean getActivarFK_IdSucursalFormaPagoPuntoVenta() {
		return this.activarFK_IdSucursalFormaPagoPuntoVenta;
	}

	public void setActivarFK_IdSucursalFormaPagoPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalFormaPagoPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdTarjetaCreditoFormaPagoPuntoVenta=true;

	public Boolean getActivarFK_IdTarjetaCreditoFormaPagoPuntoVenta() {
		return this.activarFK_IdTarjetaCreditoFormaPagoPuntoVenta;
	}

	public void setActivarFK_IdTarjetaCreditoFormaPagoPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdTarjetaCreditoFormaPagoPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoFormaPagoFormaPagoPuntoVenta=true;

	public Boolean getActivarFK_IdTipoFormaPagoFormaPagoPuntoVenta() {
		return this.activarFK_IdTipoFormaPagoFormaPagoPuntoVenta;
	}

	public void setActivarFK_IdTipoFormaPagoFormaPagoPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdTipoFormaPagoFormaPagoPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoInteresTarjetaFormaPagoPuntoVenta=true;

	public Boolean getActivarFK_IdTipoInteresTarjetaFormaPagoPuntoVenta() {
		return this.activarFK_IdTipoInteresTarjetaFormaPagoPuntoVenta;
	}

	public void setActivarFK_IdTipoInteresTarjetaFormaPagoPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdTipoInteresTarjetaFormaPagoPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoPagoTarjetaFormaPagoPuntoVenta=true;

	public Boolean getActivarFK_IdTipoPagoTarjetaFormaPagoPuntoVenta() {
		return this.activarFK_IdTipoPagoTarjetaFormaPagoPuntoVenta;
	}

	public void setActivarFK_IdTipoPagoTarjetaFormaPagoPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdTipoPagoTarjetaFormaPagoPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoRiesgoChequeFormaPagoPuntoVenta=true;

	public Boolean getActivarFK_IdTipoRiesgoChequeFormaPagoPuntoVenta() {
		return this.activarFK_IdTipoRiesgoChequeFormaPagoPuntoVenta;
	}

	public void setActivarFK_IdTipoRiesgoChequeFormaPagoPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdTipoRiesgoChequeFormaPagoPuntoVenta= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdAsientoContableFormaPagoPuntoVenta=null;

	public Border getResaltarFK_IdAsientoContableFormaPagoPuntoVenta() {
		return this.resaltarFK_IdAsientoContableFormaPagoPuntoVenta;
	}

	public void setResaltarFK_IdAsientoContableFormaPagoPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdAsientoContableFormaPagoPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdAsientoContableFormaPagoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoPuntoVentaBeanSwingJInternalFrame formapagopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdAsientoContableFormaPagoPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdBancoFormaPagoPuntoVenta=null;

	public Border getResaltarFK_IdBancoFormaPagoPuntoVenta() {
		return this.resaltarFK_IdBancoFormaPagoPuntoVenta;
	}

	public void setResaltarFK_IdBancoFormaPagoPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdBancoFormaPagoPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdBancoFormaPagoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoPuntoVentaBeanSwingJInternalFrame formapagopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBancoFormaPagoPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdBancoTarjetaFormaPagoPuntoVenta=null;

	public Border getResaltarFK_IdBancoTarjetaFormaPagoPuntoVenta() {
		return this.resaltarFK_IdBancoTarjetaFormaPagoPuntoVenta;
	}

	public void setResaltarFK_IdBancoTarjetaFormaPagoPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdBancoTarjetaFormaPagoPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdBancoTarjetaFormaPagoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoPuntoVentaBeanSwingJInternalFrame formapagopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBancoTarjetaFormaPagoPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdConexionFormaPagoPuntoVenta=null;

	public Border getResaltarFK_IdConexionFormaPagoPuntoVenta() {
		return this.resaltarFK_IdConexionFormaPagoPuntoVenta;
	}

	public void setResaltarFK_IdConexionFormaPagoPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdConexionFormaPagoPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdConexionFormaPagoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoPuntoVentaBeanSwingJInternalFrame formapagopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdConexionFormaPagoPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdCuentaBancoPunVenFormaPagoPuntoVenta=null;

	public Border getResaltarFK_IdCuentaBancoPunVenFormaPagoPuntoVenta() {
		return this.resaltarFK_IdCuentaBancoPunVenFormaPagoPuntoVenta;
	}

	public void setResaltarFK_IdCuentaBancoPunVenFormaPagoPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdCuentaBancoPunVenFormaPagoPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdCuentaBancoPunVenFormaPagoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoPuntoVentaBeanSwingJInternalFrame formapagopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaBancoPunVenFormaPagoPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableFormaPagoPuntoVenta=null;

	public Border getResaltarFK_IdCuentaContableFormaPagoPuntoVenta() {
		return this.resaltarFK_IdCuentaContableFormaPagoPuntoVenta;
	}

	public void setResaltarFK_IdCuentaContableFormaPagoPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableFormaPagoPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableFormaPagoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoPuntoVentaBeanSwingJInternalFrame formapagopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableFormaPagoPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioFormaPagoPuntoVenta=null;

	public Border getResaltarFK_IdEjercicioFormaPagoPuntoVenta() {
		return this.resaltarFK_IdEjercicioFormaPagoPuntoVenta;
	}

	public void setResaltarFK_IdEjercicioFormaPagoPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdEjercicioFormaPagoPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioFormaPagoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoPuntoVentaBeanSwingJInternalFrame formapagopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioFormaPagoPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaFormaPagoPuntoVenta=null;

	public Border getResaltarFK_IdEmpresaFormaPagoPuntoVenta() {
		return this.resaltarFK_IdEmpresaFormaPagoPuntoVenta;
	}

	public void setResaltarFK_IdEmpresaFormaPagoPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdEmpresaFormaPagoPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaFormaPagoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoPuntoVentaBeanSwingJInternalFrame formapagopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaFormaPagoPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdFacturaPuntoVentaFormaPagoPuntoVenta=null;

	public Border getResaltarFK_IdFacturaPuntoVentaFormaPagoPuntoVenta() {
		return this.resaltarFK_IdFacturaPuntoVentaFormaPagoPuntoVenta;
	}

	public void setResaltarFK_IdFacturaPuntoVentaFormaPagoPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdFacturaPuntoVentaFormaPagoPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdFacturaPuntoVentaFormaPagoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoPuntoVentaBeanSwingJInternalFrame formapagopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFacturaPuntoVentaFormaPagoPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoFormaPagoPuntoVenta=null;

	public Border getResaltarFK_IdPeriodoFormaPagoPuntoVenta() {
		return this.resaltarFK_IdPeriodoFormaPagoPuntoVenta;
	}

	public void setResaltarFK_IdPeriodoFormaPagoPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdPeriodoFormaPagoPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoFormaPagoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoPuntoVentaBeanSwingJInternalFrame formapagopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoFormaPagoPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdSucursalFormaPagoPuntoVenta=null;

	public Border getResaltarFK_IdSucursalFormaPagoPuntoVenta() {
		return this.resaltarFK_IdSucursalFormaPagoPuntoVenta;
	}

	public void setResaltarFK_IdSucursalFormaPagoPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdSucursalFormaPagoPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdSucursalFormaPagoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoPuntoVentaBeanSwingJInternalFrame formapagopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalFormaPagoPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdTarjetaCreditoFormaPagoPuntoVenta=null;

	public Border getResaltarFK_IdTarjetaCreditoFormaPagoPuntoVenta() {
		return this.resaltarFK_IdTarjetaCreditoFormaPagoPuntoVenta;
	}

	public void setResaltarFK_IdTarjetaCreditoFormaPagoPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdTarjetaCreditoFormaPagoPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdTarjetaCreditoFormaPagoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoPuntoVentaBeanSwingJInternalFrame formapagopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTarjetaCreditoFormaPagoPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdTipoFormaPagoFormaPagoPuntoVenta=null;

	public Border getResaltarFK_IdTipoFormaPagoFormaPagoPuntoVenta() {
		return this.resaltarFK_IdTipoFormaPagoFormaPagoPuntoVenta;
	}

	public void setResaltarFK_IdTipoFormaPagoFormaPagoPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdTipoFormaPagoFormaPagoPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdTipoFormaPagoFormaPagoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoPuntoVentaBeanSwingJInternalFrame formapagopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoFormaPagoFormaPagoPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdTipoInteresTarjetaFormaPagoPuntoVenta=null;

	public Border getResaltarFK_IdTipoInteresTarjetaFormaPagoPuntoVenta() {
		return this.resaltarFK_IdTipoInteresTarjetaFormaPagoPuntoVenta;
	}

	public void setResaltarFK_IdTipoInteresTarjetaFormaPagoPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdTipoInteresTarjetaFormaPagoPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdTipoInteresTarjetaFormaPagoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoPuntoVentaBeanSwingJInternalFrame formapagopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoInteresTarjetaFormaPagoPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdTipoPagoTarjetaFormaPagoPuntoVenta=null;

	public Border getResaltarFK_IdTipoPagoTarjetaFormaPagoPuntoVenta() {
		return this.resaltarFK_IdTipoPagoTarjetaFormaPagoPuntoVenta;
	}

	public void setResaltarFK_IdTipoPagoTarjetaFormaPagoPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdTipoPagoTarjetaFormaPagoPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdTipoPagoTarjetaFormaPagoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoPuntoVentaBeanSwingJInternalFrame formapagopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoPagoTarjetaFormaPagoPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdTipoRiesgoChequeFormaPagoPuntoVenta=null;

	public Border getResaltarFK_IdTipoRiesgoChequeFormaPagoPuntoVenta() {
		return this.resaltarFK_IdTipoRiesgoChequeFormaPagoPuntoVenta;
	}

	public void setResaltarFK_IdTipoRiesgoChequeFormaPagoPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdTipoRiesgoChequeFormaPagoPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdTipoRiesgoChequeFormaPagoPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*FormaPagoPuntoVentaBeanSwingJInternalFrame formapagopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoRiesgoChequeFormaPagoPuntoVenta= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}