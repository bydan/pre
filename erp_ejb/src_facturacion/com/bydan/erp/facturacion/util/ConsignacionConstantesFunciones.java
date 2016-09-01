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
package com.bydan.erp.facturacion.util;

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


import com.bydan.erp.facturacion.util.ConsignacionConstantesFunciones;
import com.bydan.erp.facturacion.util.ConsignacionParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.ConsignacionParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.comisiones.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ConsignacionConstantesFunciones extends ConsignacionConstantesFuncionesAdditional {		
	
	
	
	public static String S_TIPOREPORTE_EXTRA="";
	
	//USADO MAS EN RELACIONADO PARA MANTENIMIENTO MAESTRO-DETALLE
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOS=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOS;
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOS=Constantes.ISWING_TAMANIOMINIMO_TABLADATOS;
	
	//PARA TABLA RELACIONES(DESCRIPCION HEIGHTPE_REL_TAB)
	public static Integer ALTO_TABPANE_RELACIONES=260 + Funciones2.getValorProporcion(Constantes.ISWING_ALTO_TABPANE,0);
	
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
	public static final String SNOMBREOPCION="Consignacion";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Consignacion"+ConsignacionConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ConsignacionHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ConsignacionHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ConsignacionConstantesFunciones.SCHEMA+"_"+ConsignacionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ConsignacionHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ConsignacionConstantesFunciones.SCHEMA+"_"+ConsignacionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ConsignacionConstantesFunciones.SCHEMA+"_"+ConsignacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ConsignacionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ConsignacionConstantesFunciones.SCHEMA+"_"+ConsignacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ConsignacionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ConsignacionHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ConsignacionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ConsignacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ConsignacionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ConsignacionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ConsignacionConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ConsignacionConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ConsignacionConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ConsignacionConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Consignacions";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Consignacion";
	public static final String SCLASSWEBTITULO_LOWER="Consignacion";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Consignacion";
	public static final String OBJECTNAME="consignacion";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="consignacion";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select consignacion from "+ConsignacionConstantesFunciones.SPERSISTENCENAME+" consignacion";
	public static String QUERYSELECTNATIVE="select "+ConsignacionConstantesFunciones.SCHEMA+"."+ConsignacionConstantesFunciones.TABLENAME+".id,"+ConsignacionConstantesFunciones.SCHEMA+"."+ConsignacionConstantesFunciones.TABLENAME+".version_row,"+ConsignacionConstantesFunciones.SCHEMA+"."+ConsignacionConstantesFunciones.TABLENAME+".id_empresa,"+ConsignacionConstantesFunciones.SCHEMA+"."+ConsignacionConstantesFunciones.TABLENAME+".id_sucursal,"+ConsignacionConstantesFunciones.SCHEMA+"."+ConsignacionConstantesFunciones.TABLENAME+".id_ejercicio,"+ConsignacionConstantesFunciones.SCHEMA+"."+ConsignacionConstantesFunciones.TABLENAME+".id_periodo,"+ConsignacionConstantesFunciones.SCHEMA+"."+ConsignacionConstantesFunciones.TABLENAME+".id_anio,"+ConsignacionConstantesFunciones.SCHEMA+"."+ConsignacionConstantesFunciones.TABLENAME+".id_mes,"+ConsignacionConstantesFunciones.SCHEMA+"."+ConsignacionConstantesFunciones.TABLENAME+".id_usuario,"+ConsignacionConstantesFunciones.SCHEMA+"."+ConsignacionConstantesFunciones.TABLENAME+".numero,"+ConsignacionConstantesFunciones.SCHEMA+"."+ConsignacionConstantesFunciones.TABLENAME+".numero_autorizacion,"+ConsignacionConstantesFunciones.SCHEMA+"."+ConsignacionConstantesFunciones.TABLENAME+".fecha_emision,"+ConsignacionConstantesFunciones.SCHEMA+"."+ConsignacionConstantesFunciones.TABLENAME+".fecha_vencimiento,"+ConsignacionConstantesFunciones.SCHEMA+"."+ConsignacionConstantesFunciones.TABLENAME+".id_moneda,"+ConsignacionConstantesFunciones.SCHEMA+"."+ConsignacionConstantesFunciones.TABLENAME+".cotizacion,"+ConsignacionConstantesFunciones.SCHEMA+"."+ConsignacionConstantesFunciones.TABLENAME+".id_empleado,"+ConsignacionConstantesFunciones.SCHEMA+"."+ConsignacionConstantesFunciones.TABLENAME+".id_tipo_precio,"+ConsignacionConstantesFunciones.SCHEMA+"."+ConsignacionConstantesFunciones.TABLENAME+".id_formato,"+ConsignacionConstantesFunciones.SCHEMA+"."+ConsignacionConstantesFunciones.TABLENAME+".direccion,"+ConsignacionConstantesFunciones.SCHEMA+"."+ConsignacionConstantesFunciones.TABLENAME+".id_cliente,"+ConsignacionConstantesFunciones.SCHEMA+"."+ConsignacionConstantesFunciones.TABLENAME+".telefono,"+ConsignacionConstantesFunciones.SCHEMA+"."+ConsignacionConstantesFunciones.TABLENAME+".ruc,"+ConsignacionConstantesFunciones.SCHEMA+"."+ConsignacionConstantesFunciones.TABLENAME+".id_sub_cliente,"+ConsignacionConstantesFunciones.SCHEMA+"."+ConsignacionConstantesFunciones.TABLENAME+".id_consignatario,"+ConsignacionConstantesFunciones.SCHEMA+"."+ConsignacionConstantesFunciones.TABLENAME+".id_vendedor,"+ConsignacionConstantesFunciones.SCHEMA+"."+ConsignacionConstantesFunciones.TABLENAME+".descripcion,"+ConsignacionConstantesFunciones.SCHEMA+"."+ConsignacionConstantesFunciones.TABLENAME+".id_estado_pedido,"+ConsignacionConstantesFunciones.SCHEMA+"."+ConsignacionConstantesFunciones.TABLENAME+".descuento_porcentaje,"+ConsignacionConstantesFunciones.SCHEMA+"."+ConsignacionConstantesFunciones.TABLENAME+".total_con_iva,"+ConsignacionConstantesFunciones.SCHEMA+"."+ConsignacionConstantesFunciones.TABLENAME+".suman,"+ConsignacionConstantesFunciones.SCHEMA+"."+ConsignacionConstantesFunciones.TABLENAME+".descuento_valor,"+ConsignacionConstantesFunciones.SCHEMA+"."+ConsignacionConstantesFunciones.TABLENAME+".total_sin_iva,"+ConsignacionConstantesFunciones.SCHEMA+"."+ConsignacionConstantesFunciones.TABLENAME+".total_descuento,"+ConsignacionConstantesFunciones.SCHEMA+"."+ConsignacionConstantesFunciones.TABLENAME+".flete,"+ConsignacionConstantesFunciones.SCHEMA+"."+ConsignacionConstantesFunciones.TABLENAME+".total,"+ConsignacionConstantesFunciones.SCHEMA+"."+ConsignacionConstantesFunciones.TABLENAME+".subtotal,"+ConsignacionConstantesFunciones.SCHEMA+"."+ConsignacionConstantesFunciones.TABLENAME+".otro,"+ConsignacionConstantesFunciones.SCHEMA+"."+ConsignacionConstantesFunciones.TABLENAME+".financiamiento,"+ConsignacionConstantesFunciones.SCHEMA+"."+ConsignacionConstantesFunciones.TABLENAME+".iva,"+ConsignacionConstantesFunciones.SCHEMA+"."+ConsignacionConstantesFunciones.TABLENAME+".ice,"+ConsignacionConstantesFunciones.SCHEMA+"."+ConsignacionConstantesFunciones.TABLENAME+".monto_retencion,"+ConsignacionConstantesFunciones.SCHEMA+"."+ConsignacionConstantesFunciones.TABLENAME+".id_tipo_cambio,"+ConsignacionConstantesFunciones.SCHEMA+"."+ConsignacionConstantesFunciones.TABLENAME+".numero_fue,"+ConsignacionConstantesFunciones.SCHEMA+"."+ConsignacionConstantesFunciones.TABLENAME+".id_zona,"+ConsignacionConstantesFunciones.SCHEMA+"."+ConsignacionConstantesFunciones.TABLENAME+".fecha,"+ConsignacionConstantesFunciones.SCHEMA+"."+ConsignacionConstantesFunciones.TABLENAME+".id_centro_costo,"+ConsignacionConstantesFunciones.SCHEMA+"."+ConsignacionConstantesFunciones.TABLENAME+".fecha_servidor,"+ConsignacionConstantesFunciones.SCHEMA+"."+ConsignacionConstantesFunciones.TABLENAME+".id_responsable,"+ConsignacionConstantesFunciones.SCHEMA+"."+ConsignacionConstantesFunciones.TABLENAME+".hora_inicio,"+ConsignacionConstantesFunciones.SCHEMA+"."+ConsignacionConstantesFunciones.TABLENAME+".hora_fin,"+ConsignacionConstantesFunciones.SCHEMA+"."+ConsignacionConstantesFunciones.TABLENAME+".id_transportista,"+ConsignacionConstantesFunciones.SCHEMA+"."+ConsignacionConstantesFunciones.TABLENAME+".id_transporte from "+ConsignacionConstantesFunciones.SCHEMA+"."+ConsignacionConstantesFunciones.TABLENAME;//+" as "+ConsignacionConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=true;
	
	
	protected ConsignacionConstantesFuncionesAdditional consignacionConstantesFuncionesAdditional=null;
	
	public ConsignacionConstantesFuncionesAdditional getConsignacionConstantesFuncionesAdditional() {
		return this.consignacionConstantesFuncionesAdditional;
	}
	
	public void setConsignacionConstantesFuncionesAdditional(ConsignacionConstantesFuncionesAdditional consignacionConstantesFuncionesAdditional) {
		try {
			this.consignacionConstantesFuncionesAdditional=consignacionConstantesFuncionesAdditional;
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
    public static final String IDUSUARIO= "id_usuario";
    public static final String NUMERO= "numero";
    public static final String NUMEROAUTORIZACION= "numero_autorizacion";
    public static final String FECHAEMISION= "fecha_emision";
    public static final String FECHAVENCIMIENTO= "fecha_vencimiento";
    public static final String IDMONEDA= "id_moneda";
    public static final String COTIZACION= "cotizacion";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String IDTIPOPRECIO= "id_tipo_precio";
    public static final String IDFORMATO= "id_formato";
    public static final String DIRECCION= "direccion";
    public static final String IDCLIENTE= "id_cliente";
    public static final String TELEFONO= "telefono";
    public static final String RUC= "ruc";
    public static final String IDSUBCLIENTE= "id_sub_cliente";
    public static final String IDCONSIGNATARIO= "id_consignatario";
    public static final String IDVENDEDOR= "id_vendedor";
    public static final String DESCRIPCION= "descripcion";
    public static final String IDESTADOPEDIDO= "id_estado_pedido";
    public static final String DESCUENTOPORCENTAJE= "descuento_porcentaje";
    public static final String TOTALCONIVA= "total_con_iva";
    public static final String SUMAN= "suman";
    public static final String DESCUENTOVALOR= "descuento_valor";
    public static final String TOTALSINIVA= "total_sin_iva";
    public static final String TOTALDESCUENTO= "total_descuento";
    public static final String FLETE= "flete";
    public static final String TOTAL= "total";
    public static final String SUBTOTAL= "subtotal";
    public static final String OTRO= "otro";
    public static final String FINANCIAMIENTO= "financiamiento";
    public static final String IVA= "iva";
    public static final String ICE= "ice";
    public static final String MONTORETENCION= "monto_retencion";
    public static final String IDTIPOCAMBIO= "id_tipo_cambio";
    public static final String NUMEROFUE= "numero_fue";
    public static final String IDZONA= "id_zona";
    public static final String FECHA= "fecha";
    public static final String IDCENTROCOSTO= "id_centro_costo";
    public static final String FECHASERVIDOR= "fecha_servidor";
    public static final String IDRESPONSABLE= "id_responsable";
    public static final String HORAINICIO= "hora_inicio";
    public static final String HORAFIN= "hora_fin";
    public static final String IDTRANSPORTISTA= "id_transportista";
    public static final String IDTRANSPORTE= "id_transporte";
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
    	public static final String LABEL_IDUSUARIO= "Usuario";
		public static final String LABEL_IDUSUARIO_LOWER= "Usuario";
    	public static final String LABEL_NUMERO= "Numero";
		public static final String LABEL_NUMERO_LOWER= "Numero";
    	public static final String LABEL_NUMEROAUTORIZACION= "Numero PreImpreso";
		public static final String LABEL_NUMEROAUTORIZACION_LOWER= "Numero Autorizacion";
    	public static final String LABEL_FECHAEMISION= "Fecha Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "Fecha Emision";
    	public static final String LABEL_FECHAVENCIMIENTO= "Fecha Vencimiento";
		public static final String LABEL_FECHAVENCIMIENTO_LOWER= "Fecha Vencimiento";
    	public static final String LABEL_IDMONEDA= "Moneda";
		public static final String LABEL_IDMONEDA_LOWER= "Moneda";
    	public static final String LABEL_COTIZACION= "Cotizacion";
		public static final String LABEL_COTIZACION_LOWER= "Cotizacion";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_IDTIPOPRECIO= "Tipo Precio";
		public static final String LABEL_IDTIPOPRECIO_LOWER= "Tipo Precio";
    	public static final String LABEL_IDFORMATO= "Formato";
		public static final String LABEL_IDFORMATO_LOWER= "Formato";
    	public static final String LABEL_DIRECCION= "Direccion";
		public static final String LABEL_DIRECCION_LOWER= "Direccion";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_TELEFONO= "Telefono";
		public static final String LABEL_TELEFONO_LOWER= "Telefono";
    	public static final String LABEL_RUC= "Ruc";
		public static final String LABEL_RUC_LOWER= "Ruc";
    	public static final String LABEL_IDSUBCLIENTE= "Sub Cliente";
		public static final String LABEL_IDSUBCLIENTE_LOWER= "Sub Cliente";
    	public static final String LABEL_IDCONSIGNATARIO= "Consignatario";
		public static final String LABEL_IDCONSIGNATARIO_LOWER= "Consignatario";
    	public static final String LABEL_IDVENDEDOR= "Vendedor";
		public static final String LABEL_IDVENDEDOR_LOWER= "Vendedor";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_IDESTADOPEDIDO= "Estado Pedido";
		public static final String LABEL_IDESTADOPEDIDO_LOWER= "Estado Pedido";
    	public static final String LABEL_DESCUENTOPORCENTAJE= "Dscto %";
		public static final String LABEL_DESCUENTOPORCENTAJE_LOWER= "Dscto %";
    	public static final String LABEL_TOTALCONIVA= "Monto Con Iva";
		public static final String LABEL_TOTALCONIVA_LOWER= "Total Con Iva";
    	public static final String LABEL_SUMAN= "Suman";
		public static final String LABEL_SUMAN_LOWER= "Suman";
    	public static final String LABEL_DESCUENTOVALOR= "Dscto General";
		public static final String LABEL_DESCUENTOVALOR_LOWER= "Descuento";
    	public static final String LABEL_TOTALSINIVA= "Monto Sin Iva";
		public static final String LABEL_TOTALSINIVA_LOWER= "Total Sin Iva";
    	public static final String LABEL_TOTALDESCUENTO= "Total Descuento";
		public static final String LABEL_TOTALDESCUENTO_LOWER= "Total Descuento";
    	public static final String LABEL_FLETE= "Flete";
		public static final String LABEL_FLETE_LOWER= "Flete";
    	public static final String LABEL_TOTAL= "Total";
		public static final String LABEL_TOTAL_LOWER= "Total";
    	public static final String LABEL_SUBTOTAL= "Subtotal";
		public static final String LABEL_SUBTOTAL_LOWER= "Subtotal";
    	public static final String LABEL_OTRO= "Otro";
		public static final String LABEL_OTRO_LOWER= "Otro";
    	public static final String LABEL_FINANCIAMIENTO= "Financiamiento";
		public static final String LABEL_FINANCIAMIENTO_LOWER= "Financiamiento";
    	public static final String LABEL_IVA= "Iva";
		public static final String LABEL_IVA_LOWER= "Iva";
    	public static final String LABEL_ICE= "Ice";
		public static final String LABEL_ICE_LOWER= "Ice";
    	public static final String LABEL_MONTORETENCION= "Monto Retencion";
		public static final String LABEL_MONTORETENCION_LOWER= "Monto Reten";
    	public static final String LABEL_IDTIPOCAMBIO= "Tipo Cambio";
		public static final String LABEL_IDTIPOCAMBIO_LOWER= "Tipo Cambio";
    	public static final String LABEL_NUMEROFUE= "Numero Fue";
		public static final String LABEL_NUMEROFUE_LOWER= "Numero Fue";
    	public static final String LABEL_IDZONA= "Zona";
		public static final String LABEL_IDZONA_LOWER= "Zona";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_IDCENTROCOSTO= "Centro Costo";
		public static final String LABEL_IDCENTROCOSTO_LOWER= "Centro Costo";
    	public static final String LABEL_FECHASERVIDOR= "Fecha Servidor";
		public static final String LABEL_FECHASERVIDOR_LOWER= "Fecha Servidor";
    	public static final String LABEL_IDRESPONSABLE= "Responsable";
		public static final String LABEL_IDRESPONSABLE_LOWER= "Responsable";
    	public static final String LABEL_HORAINICIO= "Hora Inicio";
		public static final String LABEL_HORAINICIO_LOWER= "Hora Inicio";
    	public static final String LABEL_HORAFIN= "Hora Fin";
		public static final String LABEL_HORAFIN_LOWER= "Hora Fin";
    	public static final String LABEL_IDTRANSPORTISTA= "Transportista";
		public static final String LABEL_IDTRANSPORTISTA_LOWER= "Transportista";
    	public static final String LABEL_IDTRANSPORTE= "Transporte";
		public static final String LABEL_IDTRANSPORTE_LOWER= "Transporte";
	
		
		
		
		
		
		
		
		
		
	public static final String SREGEXNUMERO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_AUTORIZACION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_AUTORIZACION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
	public static final String SREGEXDIRECCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDIRECCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXTELEFONO=ConstantesValidacion.SREGEXCADENA_TELEFONO;
	public static final String SMENSAJEREGEXTELEFONO=ConstantesValidacion.SVALIDACIONCADENA_TELEFONO;	
	public static final String SREGEXRUC=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXRUC=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXNUMERO_FUE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_FUE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
		
	
	public static String getConsignacionLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ConsignacionConstantesFunciones.IDEMPRESA)) {sLabelColumna=ConsignacionConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ConsignacionConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ConsignacionConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ConsignacionConstantesFunciones.IDEJERCICIO)) {sLabelColumna=ConsignacionConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(ConsignacionConstantesFunciones.IDPERIODO)) {sLabelColumna=ConsignacionConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(ConsignacionConstantesFunciones.IDANIO)) {sLabelColumna=ConsignacionConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(ConsignacionConstantesFunciones.IDMES)) {sLabelColumna=ConsignacionConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(ConsignacionConstantesFunciones.IDUSUARIO)) {sLabelColumna=ConsignacionConstantesFunciones.LABEL_IDUSUARIO;}
		if(sNombreColumna.equals(ConsignacionConstantesFunciones.NUMERO)) {sLabelColumna=ConsignacionConstantesFunciones.LABEL_NUMERO;}
		if(sNombreColumna.equals(ConsignacionConstantesFunciones.NUMEROAUTORIZACION)) {sLabelColumna=ConsignacionConstantesFunciones.LABEL_NUMEROAUTORIZACION;}
		if(sNombreColumna.equals(ConsignacionConstantesFunciones.FECHAEMISION)) {sLabelColumna=ConsignacionConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(ConsignacionConstantesFunciones.FECHAVENCIMIENTO)) {sLabelColumna=ConsignacionConstantesFunciones.LABEL_FECHAVENCIMIENTO;}
		if(sNombreColumna.equals(ConsignacionConstantesFunciones.IDMONEDA)) {sLabelColumna=ConsignacionConstantesFunciones.LABEL_IDMONEDA;}
		if(sNombreColumna.equals(ConsignacionConstantesFunciones.COTIZACION)) {sLabelColumna=ConsignacionConstantesFunciones.LABEL_COTIZACION;}
		if(sNombreColumna.equals(ConsignacionConstantesFunciones.IDEMPLEADO)) {sLabelColumna=ConsignacionConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(ConsignacionConstantesFunciones.IDTIPOPRECIO)) {sLabelColumna=ConsignacionConstantesFunciones.LABEL_IDTIPOPRECIO;}
		if(sNombreColumna.equals(ConsignacionConstantesFunciones.IDFORMATO)) {sLabelColumna=ConsignacionConstantesFunciones.LABEL_IDFORMATO;}
		if(sNombreColumna.equals(ConsignacionConstantesFunciones.DIRECCION)) {sLabelColumna=ConsignacionConstantesFunciones.LABEL_DIRECCION;}
		if(sNombreColumna.equals(ConsignacionConstantesFunciones.IDCLIENTE)) {sLabelColumna=ConsignacionConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(ConsignacionConstantesFunciones.TELEFONO)) {sLabelColumna=ConsignacionConstantesFunciones.LABEL_TELEFONO;}
		if(sNombreColumna.equals(ConsignacionConstantesFunciones.RUC)) {sLabelColumna=ConsignacionConstantesFunciones.LABEL_RUC;}
		if(sNombreColumna.equals(ConsignacionConstantesFunciones.IDSUBCLIENTE)) {sLabelColumna=ConsignacionConstantesFunciones.LABEL_IDSUBCLIENTE;}
		if(sNombreColumna.equals(ConsignacionConstantesFunciones.IDCONSIGNATARIO)) {sLabelColumna=ConsignacionConstantesFunciones.LABEL_IDCONSIGNATARIO;}
		if(sNombreColumna.equals(ConsignacionConstantesFunciones.IDVENDEDOR)) {sLabelColumna=ConsignacionConstantesFunciones.LABEL_IDVENDEDOR;}
		if(sNombreColumna.equals(ConsignacionConstantesFunciones.DESCRIPCION)) {sLabelColumna=ConsignacionConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(ConsignacionConstantesFunciones.IDESTADOPEDIDO)) {sLabelColumna=ConsignacionConstantesFunciones.LABEL_IDESTADOPEDIDO;}
		if(sNombreColumna.equals(ConsignacionConstantesFunciones.DESCUENTOPORCENTAJE)) {sLabelColumna=ConsignacionConstantesFunciones.LABEL_DESCUENTOPORCENTAJE;}
		if(sNombreColumna.equals(ConsignacionConstantesFunciones.TOTALCONIVA)) {sLabelColumna=ConsignacionConstantesFunciones.LABEL_TOTALCONIVA;}
		if(sNombreColumna.equals(ConsignacionConstantesFunciones.SUMAN)) {sLabelColumna=ConsignacionConstantesFunciones.LABEL_SUMAN;}
		if(sNombreColumna.equals(ConsignacionConstantesFunciones.DESCUENTOVALOR)) {sLabelColumna=ConsignacionConstantesFunciones.LABEL_DESCUENTOVALOR;}
		if(sNombreColumna.equals(ConsignacionConstantesFunciones.TOTALSINIVA)) {sLabelColumna=ConsignacionConstantesFunciones.LABEL_TOTALSINIVA;}
		if(sNombreColumna.equals(ConsignacionConstantesFunciones.TOTALDESCUENTO)) {sLabelColumna=ConsignacionConstantesFunciones.LABEL_TOTALDESCUENTO;}
		if(sNombreColumna.equals(ConsignacionConstantesFunciones.FLETE)) {sLabelColumna=ConsignacionConstantesFunciones.LABEL_FLETE;}
		if(sNombreColumna.equals(ConsignacionConstantesFunciones.TOTAL)) {sLabelColumna=ConsignacionConstantesFunciones.LABEL_TOTAL;}
		if(sNombreColumna.equals(ConsignacionConstantesFunciones.SUBTOTAL)) {sLabelColumna=ConsignacionConstantesFunciones.LABEL_SUBTOTAL;}
		if(sNombreColumna.equals(ConsignacionConstantesFunciones.OTRO)) {sLabelColumna=ConsignacionConstantesFunciones.LABEL_OTRO;}
		if(sNombreColumna.equals(ConsignacionConstantesFunciones.FINANCIAMIENTO)) {sLabelColumna=ConsignacionConstantesFunciones.LABEL_FINANCIAMIENTO;}
		if(sNombreColumna.equals(ConsignacionConstantesFunciones.IVA)) {sLabelColumna=ConsignacionConstantesFunciones.LABEL_IVA;}
		if(sNombreColumna.equals(ConsignacionConstantesFunciones.ICE)) {sLabelColumna=ConsignacionConstantesFunciones.LABEL_ICE;}
		if(sNombreColumna.equals(ConsignacionConstantesFunciones.MONTORETENCION)) {sLabelColumna=ConsignacionConstantesFunciones.LABEL_MONTORETENCION;}
		if(sNombreColumna.equals(ConsignacionConstantesFunciones.IDTIPOCAMBIO)) {sLabelColumna=ConsignacionConstantesFunciones.LABEL_IDTIPOCAMBIO;}
		if(sNombreColumna.equals(ConsignacionConstantesFunciones.NUMEROFUE)) {sLabelColumna=ConsignacionConstantesFunciones.LABEL_NUMEROFUE;}
		if(sNombreColumna.equals(ConsignacionConstantesFunciones.IDZONA)) {sLabelColumna=ConsignacionConstantesFunciones.LABEL_IDZONA;}
		if(sNombreColumna.equals(ConsignacionConstantesFunciones.FECHA)) {sLabelColumna=ConsignacionConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(ConsignacionConstantesFunciones.IDCENTROCOSTO)) {sLabelColumna=ConsignacionConstantesFunciones.LABEL_IDCENTROCOSTO;}
		if(sNombreColumna.equals(ConsignacionConstantesFunciones.FECHASERVIDOR)) {sLabelColumna=ConsignacionConstantesFunciones.LABEL_FECHASERVIDOR;}
		if(sNombreColumna.equals(ConsignacionConstantesFunciones.IDRESPONSABLE)) {sLabelColumna=ConsignacionConstantesFunciones.LABEL_IDRESPONSABLE;}
		if(sNombreColumna.equals(ConsignacionConstantesFunciones.HORAINICIO)) {sLabelColumna=ConsignacionConstantesFunciones.LABEL_HORAINICIO;}
		if(sNombreColumna.equals(ConsignacionConstantesFunciones.HORAFIN)) {sLabelColumna=ConsignacionConstantesFunciones.LABEL_HORAFIN;}
		if(sNombreColumna.equals(ConsignacionConstantesFunciones.IDTRANSPORTISTA)) {sLabelColumna=ConsignacionConstantesFunciones.LABEL_IDTRANSPORTISTA;}
		if(sNombreColumna.equals(ConsignacionConstantesFunciones.IDTRANSPORTE)) {sLabelColumna=ConsignacionConstantesFunciones.LABEL_IDTRANSPORTE;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getConsignacionDescripcion(Consignacion consignacion) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(consignacion !=null/* && consignacion.getId()!=0*/) {
			if(consignacion.getId()!=null) {
				sDescripcion=consignacion.getId().toString();
			}//consignacionconsignacion.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getConsignacionDescripcionDetallado(Consignacion consignacion) {
		String sDescripcion="";
			
		sDescripcion+=ConsignacionConstantesFunciones.ID+"=";
		sDescripcion+=consignacion.getId().toString()+",";
		sDescripcion+=ConsignacionConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=consignacion.getVersionRow().toString()+",";
		sDescripcion+=ConsignacionConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=consignacion.getid_empresa().toString()+",";
		sDescripcion+=ConsignacionConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=consignacion.getid_sucursal().toString()+",";
		sDescripcion+=ConsignacionConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=consignacion.getid_ejercicio().toString()+",";
		sDescripcion+=ConsignacionConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=consignacion.getid_periodo().toString()+",";
		sDescripcion+=ConsignacionConstantesFunciones.IDANIO+"=";
		sDescripcion+=consignacion.getid_anio().toString()+",";
		sDescripcion+=ConsignacionConstantesFunciones.IDMES+"=";
		sDescripcion+=consignacion.getid_mes().toString()+",";
		sDescripcion+=ConsignacionConstantesFunciones.IDUSUARIO+"=";
		sDescripcion+=consignacion.getid_usuario().toString()+",";
		sDescripcion+=ConsignacionConstantesFunciones.NUMERO+"=";
		sDescripcion+=consignacion.getnumero()+",";
		sDescripcion+=ConsignacionConstantesFunciones.NUMEROAUTORIZACION+"=";
		sDescripcion+=consignacion.getnumero_autorizacion()+",";
		sDescripcion+=ConsignacionConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=consignacion.getfecha_emision().toString()+",";
		sDescripcion+=ConsignacionConstantesFunciones.FECHAVENCIMIENTO+"=";
		sDescripcion+=consignacion.getfecha_vencimiento().toString()+",";
		sDescripcion+=ConsignacionConstantesFunciones.IDMONEDA+"=";
		sDescripcion+=consignacion.getid_moneda().toString()+",";
		sDescripcion+=ConsignacionConstantesFunciones.COTIZACION+"=";
		sDescripcion+=consignacion.getcotizacion().toString()+",";
		sDescripcion+=ConsignacionConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=consignacion.getid_empleado().toString()+",";
		sDescripcion+=ConsignacionConstantesFunciones.IDTIPOPRECIO+"=";
		sDescripcion+=consignacion.getid_tipo_precio().toString()+",";
		sDescripcion+=ConsignacionConstantesFunciones.IDFORMATO+"=";
		sDescripcion+=consignacion.getid_formato().toString()+",";
		sDescripcion+=ConsignacionConstantesFunciones.DIRECCION+"=";
		sDescripcion+=consignacion.getdireccion()+",";
		sDescripcion+=ConsignacionConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=consignacion.getid_cliente().toString()+",";
		sDescripcion+=ConsignacionConstantesFunciones.TELEFONO+"=";
		sDescripcion+=consignacion.gettelefono()+",";
		sDescripcion+=ConsignacionConstantesFunciones.RUC+"=";
		sDescripcion+=consignacion.getruc()+",";
		sDescripcion+=ConsignacionConstantesFunciones.IDSUBCLIENTE+"=";
		sDescripcion+=consignacion.getid_sub_cliente().toString()+",";
		sDescripcion+=ConsignacionConstantesFunciones.IDCONSIGNATARIO+"=";
		sDescripcion+=consignacion.getid_consignatario().toString()+",";
		sDescripcion+=ConsignacionConstantesFunciones.IDVENDEDOR+"=";
		sDescripcion+=consignacion.getid_vendedor().toString()+",";
		sDescripcion+=ConsignacionConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=consignacion.getdescripcion()+",";
		sDescripcion+=ConsignacionConstantesFunciones.IDESTADOPEDIDO+"=";
		sDescripcion+=consignacion.getid_estado_pedido().toString()+",";
		sDescripcion+=ConsignacionConstantesFunciones.DESCUENTOPORCENTAJE+"=";
		sDescripcion+=consignacion.getdescuento_porcentaje().toString()+",";
		sDescripcion+=ConsignacionConstantesFunciones.TOTALCONIVA+"=";
		sDescripcion+=consignacion.gettotal_con_iva().toString()+",";
		sDescripcion+=ConsignacionConstantesFunciones.SUMAN+"=";
		sDescripcion+=consignacion.getsuman().toString()+",";
		sDescripcion+=ConsignacionConstantesFunciones.DESCUENTOVALOR+"=";
		sDescripcion+=consignacion.getdescuento_valor().toString()+",";
		sDescripcion+=ConsignacionConstantesFunciones.TOTALSINIVA+"=";
		sDescripcion+=consignacion.gettotal_sin_iva().toString()+",";
		sDescripcion+=ConsignacionConstantesFunciones.TOTALDESCUENTO+"=";
		sDescripcion+=consignacion.gettotal_descuento().toString()+",";
		sDescripcion+=ConsignacionConstantesFunciones.FLETE+"=";
		sDescripcion+=consignacion.getflete().toString()+",";
		sDescripcion+=ConsignacionConstantesFunciones.TOTAL+"=";
		sDescripcion+=consignacion.gettotal().toString()+",";
		sDescripcion+=ConsignacionConstantesFunciones.SUBTOTAL+"=";
		sDescripcion+=consignacion.getsubtotal().toString()+",";
		sDescripcion+=ConsignacionConstantesFunciones.OTRO+"=";
		sDescripcion+=consignacion.getotro().toString()+",";
		sDescripcion+=ConsignacionConstantesFunciones.FINANCIAMIENTO+"=";
		sDescripcion+=consignacion.getfinanciamiento().toString()+",";
		sDescripcion+=ConsignacionConstantesFunciones.IVA+"=";
		sDescripcion+=consignacion.getiva().toString()+",";
		sDescripcion+=ConsignacionConstantesFunciones.ICE+"=";
		sDescripcion+=consignacion.getice().toString()+",";
		sDescripcion+=ConsignacionConstantesFunciones.MONTORETENCION+"=";
		sDescripcion+=consignacion.getmonto_retencion().toString()+",";
		sDescripcion+=ConsignacionConstantesFunciones.IDTIPOCAMBIO+"=";
		sDescripcion+=consignacion.getid_tipo_cambio().toString()+",";
		sDescripcion+=ConsignacionConstantesFunciones.NUMEROFUE+"=";
		sDescripcion+=consignacion.getnumero_fue()+",";
		sDescripcion+=ConsignacionConstantesFunciones.IDZONA+"=";
		sDescripcion+=consignacion.getid_zona().toString()+",";
		sDescripcion+=ConsignacionConstantesFunciones.FECHA+"=";
		sDescripcion+=consignacion.getfecha().toString()+",";
		sDescripcion+=ConsignacionConstantesFunciones.IDCENTROCOSTO+"=";
		sDescripcion+=consignacion.getid_centro_costo().toString()+",";
		sDescripcion+=ConsignacionConstantesFunciones.FECHASERVIDOR+"=";
		sDescripcion+=consignacion.getfecha_servidor().toString()+",";
		sDescripcion+=ConsignacionConstantesFunciones.IDRESPONSABLE+"=";
		sDescripcion+=consignacion.getid_responsable().toString()+",";
		sDescripcion+=ConsignacionConstantesFunciones.HORAINICIO+"=";
		sDescripcion+=consignacion.gethora_inicio().toString()+",";
		sDescripcion+=ConsignacionConstantesFunciones.HORAFIN+"=";
		sDescripcion+=consignacion.gethora_fin().toString()+",";
		sDescripcion+=ConsignacionConstantesFunciones.IDTRANSPORTISTA+"=";
		sDescripcion+=consignacion.getid_transportista().toString()+",";
		sDescripcion+=ConsignacionConstantesFunciones.IDTRANSPORTE+"=";
		sDescripcion+=consignacion.getid_transporte().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setConsignacionDescripcion(Consignacion consignacion,String sValor) throws Exception {			
		if(consignacion !=null) {
			//consignacionconsignacion.getId().toString();
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

	public static String getUsuarioDescripcion(Usuario usuario) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(usuario!=null/*&&usuario.getId()>0*/) {
			sDescripcion=UsuarioConstantesFunciones.getUsuarioDescripcion(usuario);
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

	public static String getTipoPrecioDescripcion(TipoPrecio tipoprecio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoprecio!=null/*&&tipoprecio.getId()>0*/) {
			sDescripcion=TipoPrecioConstantesFunciones.getTipoPrecioDescripcion(tipoprecio);
		}

		return sDescripcion;
	}

	public static String getFormatoDescripcion(Formato formato) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(formato!=null/*&&formato.getId()>0*/) {
			sDescripcion=FormatoConstantesFunciones.getFormatoDescripcion(formato);
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

	public static String getSubClienteDescripcion(SubCliente subcliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(subcliente!=null/*&&subcliente.getId()>0*/) {
			sDescripcion=SubClienteConstantesFunciones.getSubClienteDescripcion(subcliente);
		}

		return sDescripcion;
	}

	public static String getConsignatarioDescripcion(Consignatario consignatario) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(consignatario!=null/*&&consignatario.getId()>0*/) {
			sDescripcion=ConsignatarioConstantesFunciones.getConsignatarioDescripcion(consignatario);
		}

		return sDescripcion;
	}

	public static String getVendedorDescripcion(Vendedor vendedor) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(vendedor!=null/*&&vendedor.getId()>0*/) {
			sDescripcion=VendedorConstantesFunciones.getVendedorDescripcion(vendedor);
		}

		return sDescripcion;
	}

	public static String getEstadoPedidoDescripcion(EstadoPedido estadopedido) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadopedido!=null/*&&estadopedido.getId()>0*/) {
			sDescripcion=EstadoPedidoConstantesFunciones.getEstadoPedidoDescripcion(estadopedido);
		}

		return sDescripcion;
	}

	public static String getTipoCambioDescripcion(TipoCambio tipocambio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipocambio!=null/*&&tipocambio.getId()>0*/) {
			sDescripcion=TipoCambioConstantesFunciones.getTipoCambioDescripcion(tipocambio);
		}

		return sDescripcion;
	}

	public static String getZonaDescripcion(Zona zona) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(zona!=null/*&&zona.getId()>0*/) {
			sDescripcion=ZonaConstantesFunciones.getZonaDescripcion(zona);
		}

		return sDescripcion;
	}

	public static String getCentroCostoDescripcion(CentroCosto centrocosto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(centrocosto!=null/*&&centrocosto.getId()>0*/) {
			sDescripcion=CentroCostoConstantesFunciones.getCentroCostoDescripcion(centrocosto);
		}

		return sDescripcion;
	}

	public static String getResponsableDescripcion(Responsable responsable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(responsable!=null/*&&responsable.getId()>0*/) {
			sDescripcion=ResponsableConstantesFunciones.getResponsableDescripcion(responsable);
		}

		return sDescripcion;
	}

	public static String getTransportistaDescripcion(Transportista transportista) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transportista!=null/*&&transportista.getId()>0*/) {
			sDescripcion=TransportistaConstantesFunciones.getTransportistaDescripcion(transportista);
		}

		return sDescripcion;
	}

	public static String getTransporteDescripcion(Transporte transporte) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transporte!=null/*&&transporte.getId()>0*/) {
			sDescripcion=TransporteConstantesFunciones.getTransporteDescripcion(transporte);
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
		} else if(sNombreIndice.equals("FK_IdCentroCosto")) {
			sNombreIndice="Tipo=  Por Centro Costo";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
		} else if(sNombreIndice.equals("FK_IdConsignatario")) {
			sNombreIndice="Tipo=  Por Consignatario";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpleado")) {
			sNombreIndice="Tipo=  Por Empleado";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstadoPedido")) {
			sNombreIndice="Tipo=  Por Estado Pedido";
		} else if(sNombreIndice.equals("FK_IdFormato")) {
			sNombreIndice="Tipo=  Por Formato";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		} else if(sNombreIndice.equals("FK_IdMoneda")) {
			sNombreIndice="Tipo=  Por Moneda";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdResponsable")) {
			sNombreIndice="Tipo=  Por Responsable";
		} else if(sNombreIndice.equals("FK_IdSubCliente")) {
			sNombreIndice="Tipo=  Por Sub Cliente";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoCambio")) {
			sNombreIndice="Tipo=  Por Tipo Cambio";
		} else if(sNombreIndice.equals("FK_IdTipoPrecio")) {
			sNombreIndice="Tipo=  Por Tipo Precio";
		} else if(sNombreIndice.equals("FK_IdTransporte")) {
			sNombreIndice="Tipo=  Por Transporte";
		} else if(sNombreIndice.equals("FK_IdTransportista")) {
			sNombreIndice="Tipo=  Por Transportista";
		} else if(sNombreIndice.equals("FK_IdUsuario")) {
			sNombreIndice="Tipo=  Por Usuario";
		} else if(sNombreIndice.equals("FK_IdVendedor")) {
			sNombreIndice="Tipo=  Por Vendedor";
		} else if(sNombreIndice.equals("FK_IdZona")) {
			sNombreIndice="Tipo=  Por Zona";
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

	public static String getDetalleIndiceFK_IdCentroCosto(Long id_centro_costo) {
		String sDetalleIndice=" Parametros->";
		if(id_centro_costo!=null) {sDetalleIndice+=" Codigo Unico De Centro Costo="+id_centro_costo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCliente(Long id_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_cliente!=null) {sDetalleIndice+=" Codigo Unico De Cliente="+id_cliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdConsignatario(Long id_consignatario) {
		String sDetalleIndice=" Parametros->";
		if(id_consignatario!=null) {sDetalleIndice+=" Codigo Unico De Consignatario="+id_consignatario.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEjercicio(Long id_ejercicio) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpleado(Long id_empleado) {
		String sDetalleIndice=" Parametros->";
		if(id_empleado!=null) {sDetalleIndice+=" Codigo Unico De Empleado="+id_empleado.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEstadoPedido(Long id_estado_pedido) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_pedido!=null) {sDetalleIndice+=" Codigo Unico De Estado Pedido="+id_estado_pedido.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdFormato(Long id_formato) {
		String sDetalleIndice=" Parametros->";
		if(id_formato!=null) {sDetalleIndice+=" Codigo Unico De Formato="+id_formato.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMes(Long id_mes) {
		String sDetalleIndice=" Parametros->";
		if(id_mes!=null) {sDetalleIndice+=" Codigo Unico De Mes="+id_mes.toString();} 

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

	public static String getDetalleIndiceFK_IdResponsable(Long id_responsable) {
		String sDetalleIndice=" Parametros->";
		if(id_responsable!=null) {sDetalleIndice+=" Codigo Unico De Responsable="+id_responsable.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSubCliente(Long id_sub_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_sub_cliente!=null) {sDetalleIndice+=" Codigo Unico De Sub Cliente="+id_sub_cliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoCambio(Long id_tipo_cambio) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_cambio!=null) {sDetalleIndice+=" Codigo Unico De Tipo Cambio="+id_tipo_cambio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoPrecio(Long id_tipo_precio) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_precio!=null) {sDetalleIndice+=" Codigo Unico De Tipo Precio="+id_tipo_precio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransporte(Long id_transporte) {
		String sDetalleIndice=" Parametros->";
		if(id_transporte!=null) {sDetalleIndice+=" Codigo Unico De Transporte="+id_transporte.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransportista(Long id_transportista) {
		String sDetalleIndice=" Parametros->";
		if(id_transportista!=null) {sDetalleIndice+=" Codigo Unico De Transportista="+id_transportista.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdUsuario(Long id_usuario) {
		String sDetalleIndice=" Parametros->";
		if(id_usuario!=null) {sDetalleIndice+=" Codigo Unico De Usuario="+id_usuario.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdVendedor(Long id_vendedor) {
		String sDetalleIndice=" Parametros->";
		if(id_vendedor!=null) {sDetalleIndice+=" Codigo Unico De Vendedor="+id_vendedor.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdZona(Long id_zona) {
		String sDetalleIndice=" Parametros->";
		if(id_zona!=null) {sDetalleIndice+=" Codigo Unico De Zona="+id_zona.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosConsignacion(Consignacion consignacion,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		consignacion.setnumero(consignacion.getnumero().trim());
		consignacion.setnumero_autorizacion(consignacion.getnumero_autorizacion().trim());
		consignacion.setdireccion(consignacion.getdireccion().trim());
		consignacion.settelefono(consignacion.gettelefono().trim());
		consignacion.setruc(consignacion.getruc().trim());
		consignacion.setdescripcion(consignacion.getdescripcion().trim());
		consignacion.setnumero_fue(consignacion.getnumero_fue().trim());
	}
	
	public static void quitarEspaciosConsignacions(List<Consignacion> consignacions,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Consignacion consignacion: consignacions) {
			consignacion.setnumero(consignacion.getnumero().trim());
			consignacion.setnumero_autorizacion(consignacion.getnumero_autorizacion().trim());
			consignacion.setdireccion(consignacion.getdireccion().trim());
			consignacion.settelefono(consignacion.gettelefono().trim());
			consignacion.setruc(consignacion.getruc().trim());
			consignacion.setdescripcion(consignacion.getdescripcion().trim());
			consignacion.setnumero_fue(consignacion.getnumero_fue().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresConsignacion(Consignacion consignacion,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && consignacion.getConCambioAuxiliar()) {
			consignacion.setIsDeleted(consignacion.getIsDeletedAuxiliar());	
			consignacion.setIsNew(consignacion.getIsNewAuxiliar());	
			consignacion.setIsChanged(consignacion.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			consignacion.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			consignacion.setIsDeletedAuxiliar(false);	
			consignacion.setIsNewAuxiliar(false);	
			consignacion.setIsChangedAuxiliar(false);
			
			consignacion.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresConsignacions(List<Consignacion> consignacions,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Consignacion consignacion : consignacions) {
			if(conAsignarBase && consignacion.getConCambioAuxiliar()) {
				consignacion.setIsDeleted(consignacion.getIsDeletedAuxiliar());	
				consignacion.setIsNew(consignacion.getIsNewAuxiliar());	
				consignacion.setIsChanged(consignacion.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				consignacion.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				consignacion.setIsDeletedAuxiliar(false);	
				consignacion.setIsNewAuxiliar(false);	
				consignacion.setIsChangedAuxiliar(false);
				
				consignacion.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresConsignacion(Consignacion consignacion,Boolean conEnteros) throws Exception  {
		consignacion.setcotizacion(0.0);
		consignacion.setdescuento_porcentaje(0.0);
		consignacion.settotal_con_iva(0.0);
		consignacion.setsuman(0.0);
		consignacion.setdescuento_valor(0.0);
		consignacion.settotal_sin_iva(0.0);
		consignacion.settotal_descuento(0.0);
		consignacion.setflete(0.0);
		consignacion.settotal(0.0);
		consignacion.setsubtotal(0.0);
		consignacion.setotro(0.0);
		consignacion.setfinanciamiento(0.0);
		consignacion.setiva(0.0);
		consignacion.setice(0.0);
		consignacion.setmonto_retencion(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresConsignacions(List<Consignacion> consignacions,Boolean conEnteros) throws Exception  {
		
		for(Consignacion consignacion: consignacions) {
			consignacion.setcotizacion(0.0);
			consignacion.setdescuento_porcentaje(0.0);
			consignacion.settotal_con_iva(0.0);
			consignacion.setsuman(0.0);
			consignacion.setdescuento_valor(0.0);
			consignacion.settotal_sin_iva(0.0);
			consignacion.settotal_descuento(0.0);
			consignacion.setflete(0.0);
			consignacion.settotal(0.0);
			consignacion.setsubtotal(0.0);
			consignacion.setotro(0.0);
			consignacion.setfinanciamiento(0.0);
			consignacion.setiva(0.0);
			consignacion.setice(0.0);
			consignacion.setmonto_retencion(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaConsignacion(List<Consignacion> consignacions,Consignacion consignacionAux) throws Exception  {
		ConsignacionConstantesFunciones.InicializarValoresConsignacion(consignacionAux,true);
		
		for(Consignacion consignacion: consignacions) {
			if(consignacion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			consignacionAux.setcotizacion(consignacionAux.getcotizacion()+consignacion.getcotizacion());			
			consignacionAux.setdescuento_porcentaje(consignacionAux.getdescuento_porcentaje()+consignacion.getdescuento_porcentaje());			
			consignacionAux.settotal_con_iva(consignacionAux.gettotal_con_iva()+consignacion.gettotal_con_iva());			
			consignacionAux.setsuman(consignacionAux.getsuman()+consignacion.getsuman());			
			consignacionAux.setdescuento_valor(consignacionAux.getdescuento_valor()+consignacion.getdescuento_valor());			
			consignacionAux.settotal_sin_iva(consignacionAux.gettotal_sin_iva()+consignacion.gettotal_sin_iva());			
			consignacionAux.settotal_descuento(consignacionAux.gettotal_descuento()+consignacion.gettotal_descuento());			
			consignacionAux.setflete(consignacionAux.getflete()+consignacion.getflete());			
			consignacionAux.settotal(consignacionAux.gettotal()+consignacion.gettotal());			
			consignacionAux.setsubtotal(consignacionAux.getsubtotal()+consignacion.getsubtotal());			
			consignacionAux.setotro(consignacionAux.getotro()+consignacion.getotro());			
			consignacionAux.setfinanciamiento(consignacionAux.getfinanciamiento()+consignacion.getfinanciamiento());			
			consignacionAux.setiva(consignacionAux.getiva()+consignacion.getiva());			
			consignacionAux.setice(consignacionAux.getice()+consignacion.getice());			
			consignacionAux.setmonto_retencion(consignacionAux.getmonto_retencion()+consignacion.getmonto_retencion());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesConsignacion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ConsignacionConstantesFunciones.getArrayColumnasGlobalesConsignacion(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesConsignacion(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ConsignacionConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ConsignacionConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ConsignacionConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ConsignacionConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ConsignacionConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ConsignacionConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ConsignacionConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ConsignacionConstantesFunciones.IDPERIODO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ConsignacionConstantesFunciones.IDUSUARIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ConsignacionConstantesFunciones.IDUSUARIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ConsignacionConstantesFunciones.IDMONEDA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ConsignacionConstantesFunciones.IDMONEDA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoConsignacion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Consignacion> consignacions,Consignacion consignacion,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Consignacion consignacionAux: consignacions) {
			if(consignacionAux!=null && consignacion!=null) {
				if((consignacionAux.getId()==null && consignacion.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(consignacionAux.getId()!=null && consignacion.getId()!=null){
					if(consignacionAux.getId().equals(consignacion.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaConsignacion(List<Consignacion> consignacions) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double cotizacionTotal=0.0;
		Double descuento_porcentajeTotal=0.0;
		Double total_con_ivaTotal=0.0;
		Double sumanTotal=0.0;
		Double descuento_valorTotal=0.0;
		Double total_sin_ivaTotal=0.0;
		Double total_descuentoTotal=0.0;
		Double fleteTotal=0.0;
		Double totalTotal=0.0;
		Double subtotalTotal=0.0;
		Double otroTotal=0.0;
		Double financiamientoTotal=0.0;
		Double ivaTotal=0.0;
		Double iceTotal=0.0;
		Double monto_retencionTotal=0.0;
	
		for(Consignacion consignacion: consignacions) {			
			if(consignacion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			cotizacionTotal+=consignacion.getcotizacion();
			descuento_porcentajeTotal+=consignacion.getdescuento_porcentaje();
			total_con_ivaTotal+=consignacion.gettotal_con_iva();
			sumanTotal+=consignacion.getsuman();
			descuento_valorTotal+=consignacion.getdescuento_valor();
			total_sin_ivaTotal+=consignacion.gettotal_sin_iva();
			total_descuentoTotal+=consignacion.gettotal_descuento();
			fleteTotal+=consignacion.getflete();
			totalTotal+=consignacion.gettotal();
			subtotalTotal+=consignacion.getsubtotal();
			otroTotal+=consignacion.getotro();
			financiamientoTotal+=consignacion.getfinanciamiento();
			ivaTotal+=consignacion.getiva();
			iceTotal+=consignacion.getice();
			monto_retencionTotal+=consignacion.getmonto_retencion();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ConsignacionConstantesFunciones.COTIZACION);
		datoGeneral.setsDescripcion(ConsignacionConstantesFunciones.LABEL_COTIZACION);
		datoGeneral.setdValorDouble(cotizacionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ConsignacionConstantesFunciones.DESCUENTOPORCENTAJE);
		datoGeneral.setsDescripcion(ConsignacionConstantesFunciones.LABEL_DESCUENTOPORCENTAJE);
		datoGeneral.setdValorDouble(descuento_porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ConsignacionConstantesFunciones.TOTALCONIVA);
		datoGeneral.setsDescripcion(ConsignacionConstantesFunciones.LABEL_TOTALCONIVA);
		datoGeneral.setdValorDouble(total_con_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ConsignacionConstantesFunciones.SUMAN);
		datoGeneral.setsDescripcion(ConsignacionConstantesFunciones.LABEL_SUMAN);
		datoGeneral.setdValorDouble(sumanTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ConsignacionConstantesFunciones.DESCUENTOVALOR);
		datoGeneral.setsDescripcion(ConsignacionConstantesFunciones.LABEL_DESCUENTOVALOR);
		datoGeneral.setdValorDouble(descuento_valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ConsignacionConstantesFunciones.TOTALSINIVA);
		datoGeneral.setsDescripcion(ConsignacionConstantesFunciones.LABEL_TOTALSINIVA);
		datoGeneral.setdValorDouble(total_sin_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ConsignacionConstantesFunciones.TOTALDESCUENTO);
		datoGeneral.setsDescripcion(ConsignacionConstantesFunciones.LABEL_TOTALDESCUENTO);
		datoGeneral.setdValorDouble(total_descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ConsignacionConstantesFunciones.FLETE);
		datoGeneral.setsDescripcion(ConsignacionConstantesFunciones.LABEL_FLETE);
		datoGeneral.setdValorDouble(fleteTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ConsignacionConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(ConsignacionConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ConsignacionConstantesFunciones.SUBTOTAL);
		datoGeneral.setsDescripcion(ConsignacionConstantesFunciones.LABEL_SUBTOTAL);
		datoGeneral.setdValorDouble(subtotalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ConsignacionConstantesFunciones.OTRO);
		datoGeneral.setsDescripcion(ConsignacionConstantesFunciones.LABEL_OTRO);
		datoGeneral.setdValorDouble(otroTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ConsignacionConstantesFunciones.FINANCIAMIENTO);
		datoGeneral.setsDescripcion(ConsignacionConstantesFunciones.LABEL_FINANCIAMIENTO);
		datoGeneral.setdValorDouble(financiamientoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ConsignacionConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(ConsignacionConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ConsignacionConstantesFunciones.ICE);
		datoGeneral.setsDescripcion(ConsignacionConstantesFunciones.LABEL_ICE);
		datoGeneral.setdValorDouble(iceTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ConsignacionConstantesFunciones.MONTORETENCION);
		datoGeneral.setsDescripcion(ConsignacionConstantesFunciones.LABEL_MONTORETENCION);
		datoGeneral.setdValorDouble(monto_retencionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaConsignacion() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ConsignacionConstantesFunciones.LABEL_ID, ConsignacionConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsignacionConstantesFunciones.LABEL_VERSIONROW, ConsignacionConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsignacionConstantesFunciones.LABEL_IDEMPRESA, ConsignacionConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsignacionConstantesFunciones.LABEL_IDSUCURSAL, ConsignacionConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsignacionConstantesFunciones.LABEL_IDEJERCICIO, ConsignacionConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsignacionConstantesFunciones.LABEL_IDPERIODO, ConsignacionConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsignacionConstantesFunciones.LABEL_IDANIO, ConsignacionConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsignacionConstantesFunciones.LABEL_IDMES, ConsignacionConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsignacionConstantesFunciones.LABEL_IDUSUARIO, ConsignacionConstantesFunciones.IDUSUARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsignacionConstantesFunciones.LABEL_NUMERO, ConsignacionConstantesFunciones.NUMERO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsignacionConstantesFunciones.LABEL_NUMEROAUTORIZACION, ConsignacionConstantesFunciones.NUMEROAUTORIZACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsignacionConstantesFunciones.LABEL_FECHAEMISION, ConsignacionConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsignacionConstantesFunciones.LABEL_FECHAVENCIMIENTO, ConsignacionConstantesFunciones.FECHAVENCIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsignacionConstantesFunciones.LABEL_IDMONEDA, ConsignacionConstantesFunciones.IDMONEDA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsignacionConstantesFunciones.LABEL_COTIZACION, ConsignacionConstantesFunciones.COTIZACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsignacionConstantesFunciones.LABEL_IDEMPLEADO, ConsignacionConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsignacionConstantesFunciones.LABEL_IDTIPOPRECIO, ConsignacionConstantesFunciones.IDTIPOPRECIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsignacionConstantesFunciones.LABEL_IDFORMATO, ConsignacionConstantesFunciones.IDFORMATO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsignacionConstantesFunciones.LABEL_DIRECCION, ConsignacionConstantesFunciones.DIRECCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsignacionConstantesFunciones.LABEL_IDCLIENTE, ConsignacionConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsignacionConstantesFunciones.LABEL_TELEFONO, ConsignacionConstantesFunciones.TELEFONO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsignacionConstantesFunciones.LABEL_RUC, ConsignacionConstantesFunciones.RUC,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsignacionConstantesFunciones.LABEL_IDSUBCLIENTE, ConsignacionConstantesFunciones.IDSUBCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsignacionConstantesFunciones.LABEL_IDCONSIGNATARIO, ConsignacionConstantesFunciones.IDCONSIGNATARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsignacionConstantesFunciones.LABEL_IDVENDEDOR, ConsignacionConstantesFunciones.IDVENDEDOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsignacionConstantesFunciones.LABEL_DESCRIPCION, ConsignacionConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsignacionConstantesFunciones.LABEL_IDESTADOPEDIDO, ConsignacionConstantesFunciones.IDESTADOPEDIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsignacionConstantesFunciones.LABEL_DESCUENTOPORCENTAJE, ConsignacionConstantesFunciones.DESCUENTOPORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsignacionConstantesFunciones.LABEL_TOTALCONIVA, ConsignacionConstantesFunciones.TOTALCONIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsignacionConstantesFunciones.LABEL_SUMAN, ConsignacionConstantesFunciones.SUMAN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsignacionConstantesFunciones.LABEL_DESCUENTOVALOR, ConsignacionConstantesFunciones.DESCUENTOVALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsignacionConstantesFunciones.LABEL_TOTALSINIVA, ConsignacionConstantesFunciones.TOTALSINIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsignacionConstantesFunciones.LABEL_TOTALDESCUENTO, ConsignacionConstantesFunciones.TOTALDESCUENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsignacionConstantesFunciones.LABEL_FLETE, ConsignacionConstantesFunciones.FLETE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsignacionConstantesFunciones.LABEL_TOTAL, ConsignacionConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsignacionConstantesFunciones.LABEL_SUBTOTAL, ConsignacionConstantesFunciones.SUBTOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsignacionConstantesFunciones.LABEL_OTRO, ConsignacionConstantesFunciones.OTRO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsignacionConstantesFunciones.LABEL_FINANCIAMIENTO, ConsignacionConstantesFunciones.FINANCIAMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsignacionConstantesFunciones.LABEL_IVA, ConsignacionConstantesFunciones.IVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsignacionConstantesFunciones.LABEL_ICE, ConsignacionConstantesFunciones.ICE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsignacionConstantesFunciones.LABEL_MONTORETENCION, ConsignacionConstantesFunciones.MONTORETENCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsignacionConstantesFunciones.LABEL_IDTIPOCAMBIO, ConsignacionConstantesFunciones.IDTIPOCAMBIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsignacionConstantesFunciones.LABEL_NUMEROFUE, ConsignacionConstantesFunciones.NUMEROFUE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsignacionConstantesFunciones.LABEL_IDZONA, ConsignacionConstantesFunciones.IDZONA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsignacionConstantesFunciones.LABEL_FECHA, ConsignacionConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsignacionConstantesFunciones.LABEL_IDCENTROCOSTO, ConsignacionConstantesFunciones.IDCENTROCOSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsignacionConstantesFunciones.LABEL_FECHASERVIDOR, ConsignacionConstantesFunciones.FECHASERVIDOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsignacionConstantesFunciones.LABEL_IDRESPONSABLE, ConsignacionConstantesFunciones.IDRESPONSABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsignacionConstantesFunciones.LABEL_HORAINICIO, ConsignacionConstantesFunciones.HORAINICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsignacionConstantesFunciones.LABEL_HORAFIN, ConsignacionConstantesFunciones.HORAFIN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsignacionConstantesFunciones.LABEL_IDTRANSPORTISTA, ConsignacionConstantesFunciones.IDTRANSPORTISTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsignacionConstantesFunciones.LABEL_IDTRANSPORTE, ConsignacionConstantesFunciones.IDTRANSPORTE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasConsignacion() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ConsignacionConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsignacionConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsignacionConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsignacionConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsignacionConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsignacionConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsignacionConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsignacionConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsignacionConstantesFunciones.IDUSUARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsignacionConstantesFunciones.NUMERO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsignacionConstantesFunciones.NUMEROAUTORIZACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsignacionConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsignacionConstantesFunciones.FECHAVENCIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsignacionConstantesFunciones.IDMONEDA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsignacionConstantesFunciones.COTIZACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsignacionConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsignacionConstantesFunciones.IDTIPOPRECIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsignacionConstantesFunciones.IDFORMATO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsignacionConstantesFunciones.DIRECCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsignacionConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsignacionConstantesFunciones.TELEFONO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsignacionConstantesFunciones.RUC;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsignacionConstantesFunciones.IDSUBCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsignacionConstantesFunciones.IDCONSIGNATARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsignacionConstantesFunciones.IDVENDEDOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsignacionConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsignacionConstantesFunciones.IDESTADOPEDIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsignacionConstantesFunciones.DESCUENTOPORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsignacionConstantesFunciones.TOTALCONIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsignacionConstantesFunciones.SUMAN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsignacionConstantesFunciones.DESCUENTOVALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsignacionConstantesFunciones.TOTALSINIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsignacionConstantesFunciones.TOTALDESCUENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsignacionConstantesFunciones.FLETE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsignacionConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsignacionConstantesFunciones.SUBTOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsignacionConstantesFunciones.OTRO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsignacionConstantesFunciones.FINANCIAMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsignacionConstantesFunciones.IVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsignacionConstantesFunciones.ICE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsignacionConstantesFunciones.MONTORETENCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsignacionConstantesFunciones.IDTIPOCAMBIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsignacionConstantesFunciones.NUMEROFUE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsignacionConstantesFunciones.IDZONA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsignacionConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsignacionConstantesFunciones.IDCENTROCOSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsignacionConstantesFunciones.FECHASERVIDOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsignacionConstantesFunciones.IDRESPONSABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsignacionConstantesFunciones.HORAINICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsignacionConstantesFunciones.HORAFIN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsignacionConstantesFunciones.IDTRANSPORTISTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsignacionConstantesFunciones.IDTRANSPORTE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarConsignacion() throws Exception  {
		return ConsignacionConstantesFunciones.getTiposSeleccionarConsignacion(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarConsignacion(Boolean conFk) throws Exception  {
		return ConsignacionConstantesFunciones.getTiposSeleccionarConsignacion(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarConsignacion(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsignacionConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ConsignacionConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsignacionConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ConsignacionConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsignacionConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(ConsignacionConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsignacionConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(ConsignacionConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsignacionConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(ConsignacionConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsignacionConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(ConsignacionConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsignacionConstantesFunciones.LABEL_IDUSUARIO);
			reporte.setsDescripcion(ConsignacionConstantesFunciones.LABEL_IDUSUARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsignacionConstantesFunciones.LABEL_NUMERO);
			reporte.setsDescripcion(ConsignacionConstantesFunciones.LABEL_NUMERO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsignacionConstantesFunciones.LABEL_NUMEROAUTORIZACION);
			reporte.setsDescripcion(ConsignacionConstantesFunciones.LABEL_NUMEROAUTORIZACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsignacionConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(ConsignacionConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsignacionConstantesFunciones.LABEL_FECHAVENCIMIENTO);
			reporte.setsDescripcion(ConsignacionConstantesFunciones.LABEL_FECHAVENCIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsignacionConstantesFunciones.LABEL_IDMONEDA);
			reporte.setsDescripcion(ConsignacionConstantesFunciones.LABEL_IDMONEDA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsignacionConstantesFunciones.LABEL_COTIZACION);
			reporte.setsDescripcion(ConsignacionConstantesFunciones.LABEL_COTIZACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsignacionConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(ConsignacionConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsignacionConstantesFunciones.LABEL_IDTIPOPRECIO);
			reporte.setsDescripcion(ConsignacionConstantesFunciones.LABEL_IDTIPOPRECIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsignacionConstantesFunciones.LABEL_IDFORMATO);
			reporte.setsDescripcion(ConsignacionConstantesFunciones.LABEL_IDFORMATO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsignacionConstantesFunciones.LABEL_DIRECCION);
			reporte.setsDescripcion(ConsignacionConstantesFunciones.LABEL_DIRECCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsignacionConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(ConsignacionConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsignacionConstantesFunciones.LABEL_TELEFONO);
			reporte.setsDescripcion(ConsignacionConstantesFunciones.LABEL_TELEFONO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsignacionConstantesFunciones.LABEL_RUC);
			reporte.setsDescripcion(ConsignacionConstantesFunciones.LABEL_RUC);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsignacionConstantesFunciones.LABEL_IDSUBCLIENTE);
			reporte.setsDescripcion(ConsignacionConstantesFunciones.LABEL_IDSUBCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsignacionConstantesFunciones.LABEL_IDCONSIGNATARIO);
			reporte.setsDescripcion(ConsignacionConstantesFunciones.LABEL_IDCONSIGNATARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsignacionConstantesFunciones.LABEL_IDVENDEDOR);
			reporte.setsDescripcion(ConsignacionConstantesFunciones.LABEL_IDVENDEDOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsignacionConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(ConsignacionConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsignacionConstantesFunciones.LABEL_IDESTADOPEDIDO);
			reporte.setsDescripcion(ConsignacionConstantesFunciones.LABEL_IDESTADOPEDIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsignacionConstantesFunciones.LABEL_DESCUENTOPORCENTAJE);
			reporte.setsDescripcion(ConsignacionConstantesFunciones.LABEL_DESCUENTOPORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsignacionConstantesFunciones.LABEL_TOTALCONIVA);
			reporte.setsDescripcion(ConsignacionConstantesFunciones.LABEL_TOTALCONIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsignacionConstantesFunciones.LABEL_SUMAN);
			reporte.setsDescripcion(ConsignacionConstantesFunciones.LABEL_SUMAN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsignacionConstantesFunciones.LABEL_DESCUENTOVALOR);
			reporte.setsDescripcion(ConsignacionConstantesFunciones.LABEL_DESCUENTOVALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsignacionConstantesFunciones.LABEL_TOTALSINIVA);
			reporte.setsDescripcion(ConsignacionConstantesFunciones.LABEL_TOTALSINIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsignacionConstantesFunciones.LABEL_TOTALDESCUENTO);
			reporte.setsDescripcion(ConsignacionConstantesFunciones.LABEL_TOTALDESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsignacionConstantesFunciones.LABEL_FLETE);
			reporte.setsDescripcion(ConsignacionConstantesFunciones.LABEL_FLETE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsignacionConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(ConsignacionConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsignacionConstantesFunciones.LABEL_SUBTOTAL);
			reporte.setsDescripcion(ConsignacionConstantesFunciones.LABEL_SUBTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsignacionConstantesFunciones.LABEL_OTRO);
			reporte.setsDescripcion(ConsignacionConstantesFunciones.LABEL_OTRO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsignacionConstantesFunciones.LABEL_FINANCIAMIENTO);
			reporte.setsDescripcion(ConsignacionConstantesFunciones.LABEL_FINANCIAMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsignacionConstantesFunciones.LABEL_IVA);
			reporte.setsDescripcion(ConsignacionConstantesFunciones.LABEL_IVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsignacionConstantesFunciones.LABEL_ICE);
			reporte.setsDescripcion(ConsignacionConstantesFunciones.LABEL_ICE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsignacionConstantesFunciones.LABEL_MONTORETENCION);
			reporte.setsDescripcion(ConsignacionConstantesFunciones.LABEL_MONTORETENCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsignacionConstantesFunciones.LABEL_IDTIPOCAMBIO);
			reporte.setsDescripcion(ConsignacionConstantesFunciones.LABEL_IDTIPOCAMBIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsignacionConstantesFunciones.LABEL_NUMEROFUE);
			reporte.setsDescripcion(ConsignacionConstantesFunciones.LABEL_NUMEROFUE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsignacionConstantesFunciones.LABEL_IDZONA);
			reporte.setsDescripcion(ConsignacionConstantesFunciones.LABEL_IDZONA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsignacionConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(ConsignacionConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsignacionConstantesFunciones.LABEL_IDCENTROCOSTO);
			reporte.setsDescripcion(ConsignacionConstantesFunciones.LABEL_IDCENTROCOSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsignacionConstantesFunciones.LABEL_FECHASERVIDOR);
			reporte.setsDescripcion(ConsignacionConstantesFunciones.LABEL_FECHASERVIDOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsignacionConstantesFunciones.LABEL_IDRESPONSABLE);
			reporte.setsDescripcion(ConsignacionConstantesFunciones.LABEL_IDRESPONSABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		reporte=new Reporte();
		reporte.setsCodigo(ConsignacionConstantesFunciones.LABEL_HORAINICIO);
		reporte.setsDescripcion(ConsignacionConstantesFunciones.LABEL_HORAINICIO);

		arrTiposSeleccionarTodos.add(reporte);
		reporte=new Reporte();
		reporte.setsCodigo(ConsignacionConstantesFunciones.LABEL_HORAFIN);
		reporte.setsDescripcion(ConsignacionConstantesFunciones.LABEL_HORAFIN);

		arrTiposSeleccionarTodos.add(reporte);
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsignacionConstantesFunciones.LABEL_IDTRANSPORTISTA);
			reporte.setsDescripcion(ConsignacionConstantesFunciones.LABEL_IDTRANSPORTISTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsignacionConstantesFunciones.LABEL_IDTRANSPORTE);
			reporte.setsDescripcion(ConsignacionConstantesFunciones.LABEL_IDTRANSPORTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesConsignacion(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesConsignacion(Consignacion consignacionAux) throws Exception {
		
			consignacionAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(consignacionAux.getEmpresa()));
			consignacionAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(consignacionAux.getSucursal()));
			consignacionAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(consignacionAux.getEjercicio()));
			consignacionAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(consignacionAux.getPeriodo()));
			consignacionAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(consignacionAux.getAnio()));
			consignacionAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(consignacionAux.getMes()));
			consignacionAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(consignacionAux.getUsuario()));
			consignacionAux.setmoneda_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(consignacionAux.getMoneda()));
			consignacionAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(consignacionAux.getEmpleado()));
			consignacionAux.settipoprecio_descripcion(TipoPrecioConstantesFunciones.getTipoPrecioDescripcion(consignacionAux.getTipoPrecio()));
			consignacionAux.setformato_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(consignacionAux.getFormato()));
			consignacionAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(consignacionAux.getCliente()));
			consignacionAux.setsubcliente_descripcion(SubClienteConstantesFunciones.getSubClienteDescripcion(consignacionAux.getSubCliente()));
			consignacionAux.setconsignatario_descripcion(ConsignatarioConstantesFunciones.getConsignatarioDescripcion(consignacionAux.getConsignatario()));
			consignacionAux.setvendedor_descripcion(VendedorConstantesFunciones.getVendedorDescripcion(consignacionAux.getVendedor()));
			consignacionAux.setestadopedido_descripcion(EstadoPedidoConstantesFunciones.getEstadoPedidoDescripcion(consignacionAux.getEstadoPedido()));
			consignacionAux.settipocambio_descripcion(TipoCambioConstantesFunciones.getTipoCambioDescripcion(consignacionAux.getTipoCambio()));
			consignacionAux.setzona_descripcion(ZonaConstantesFunciones.getZonaDescripcion(consignacionAux.getZona()));
			consignacionAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(consignacionAux.getCentroCosto()));
			consignacionAux.setresponsable_descripcion(ResponsableConstantesFunciones.getResponsableDescripcion(consignacionAux.getResponsable()));
			consignacionAux.settransportista_descripcion(TransportistaConstantesFunciones.getTransportistaDescripcion(consignacionAux.getTransportista()));
			consignacionAux.settransporte_descripcion(TransporteConstantesFunciones.getTransporteDescripcion(consignacionAux.getTransporte()));		
	}
	
	public static void refrescarForeignKeysDescripcionesConsignacion(List<Consignacion> consignacionsTemp) throws Exception {
		for(Consignacion consignacionAux:consignacionsTemp) {
			
			consignacionAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(consignacionAux.getEmpresa()));
			consignacionAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(consignacionAux.getSucursal()));
			consignacionAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(consignacionAux.getEjercicio()));
			consignacionAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(consignacionAux.getPeriodo()));
			consignacionAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(consignacionAux.getAnio()));
			consignacionAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(consignacionAux.getMes()));
			consignacionAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(consignacionAux.getUsuario()));
			consignacionAux.setmoneda_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(consignacionAux.getMoneda()));
			consignacionAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(consignacionAux.getEmpleado()));
			consignacionAux.settipoprecio_descripcion(TipoPrecioConstantesFunciones.getTipoPrecioDescripcion(consignacionAux.getTipoPrecio()));
			consignacionAux.setformato_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(consignacionAux.getFormato()));
			consignacionAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(consignacionAux.getCliente()));
			consignacionAux.setsubcliente_descripcion(SubClienteConstantesFunciones.getSubClienteDescripcion(consignacionAux.getSubCliente()));
			consignacionAux.setconsignatario_descripcion(ConsignatarioConstantesFunciones.getConsignatarioDescripcion(consignacionAux.getConsignatario()));
			consignacionAux.setvendedor_descripcion(VendedorConstantesFunciones.getVendedorDescripcion(consignacionAux.getVendedor()));
			consignacionAux.setestadopedido_descripcion(EstadoPedidoConstantesFunciones.getEstadoPedidoDescripcion(consignacionAux.getEstadoPedido()));
			consignacionAux.settipocambio_descripcion(TipoCambioConstantesFunciones.getTipoCambioDescripcion(consignacionAux.getTipoCambio()));
			consignacionAux.setzona_descripcion(ZonaConstantesFunciones.getZonaDescripcion(consignacionAux.getZona()));
			consignacionAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(consignacionAux.getCentroCosto()));
			consignacionAux.setresponsable_descripcion(ResponsableConstantesFunciones.getResponsableDescripcion(consignacionAux.getResponsable()));
			consignacionAux.settransportista_descripcion(TransportistaConstantesFunciones.getTransportistaDescripcion(consignacionAux.getTransportista()));
			consignacionAux.settransporte_descripcion(TransporteConstantesFunciones.getTransporteDescripcion(consignacionAux.getTransporte()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfConsignacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Mes.class));
				classes.add(new Classe(Usuario.class));
				classes.add(new Classe(Moneda.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(TipoPrecio.class));
				classes.add(new Classe(Formato.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(SubCliente.class));
				classes.add(new Classe(Consignatario.class));
				classes.add(new Classe(Vendedor.class));
				classes.add(new Classe(EstadoPedido.class));
				classes.add(new Classe(TipoCambio.class));
				classes.add(new Classe(Zona.class));
				classes.add(new Classe(CentroCosto.class));
				classes.add(new Classe(Responsable.class));
				classes.add(new Classe(Transportista.class));
				classes.add(new Classe(Transporte.class));
				
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
					if(clas.clas.equals(Usuario.class)) {
						classes.add(new Classe(Usuario.class));
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
					if(clas.clas.equals(TipoPrecio.class)) {
						classes.add(new Classe(TipoPrecio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Formato.class)) {
						classes.add(new Classe(Formato.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(SubCliente.class)) {
						classes.add(new Classe(SubCliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Consignatario.class)) {
						classes.add(new Classe(Consignatario.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Vendedor.class)) {
						classes.add(new Classe(Vendedor.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EstadoPedido.class)) {
						classes.add(new Classe(EstadoPedido.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoCambio.class)) {
						classes.add(new Classe(TipoCambio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Zona.class)) {
						classes.add(new Classe(Zona.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CentroCosto.class)) {
						classes.add(new Classe(CentroCosto.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Responsable.class)) {
						classes.add(new Classe(Responsable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Transportista.class)) {
						classes.add(new Classe(Transportista.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Transporte.class)) {
						classes.add(new Classe(Transporte.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfConsignacion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}

					if(Moneda.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Moneda.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(TipoPrecio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoPrecio.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(SubCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(SubCliente.class)); continue;
					}

					if(Consignatario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Consignatario.class)); continue;
					}

					if(Vendedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Vendedor.class)); continue;
					}

					if(EstadoPedido.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoPedido.class)); continue;
					}

					if(TipoCambio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCambio.class)); continue;
					}

					if(Zona.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Zona.class)); continue;
					}

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
					}

					if(Responsable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Responsable.class)); continue;
					}

					if(Transportista.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transportista.class)); continue;
					}

					if(Transporte.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transporte.class)); continue;
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

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}

					if(Moneda.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Moneda.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(TipoPrecio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoPrecio.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(SubCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(SubCliente.class)); continue;
					}

					if(Consignatario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Consignatario.class)); continue;
					}

					if(Vendedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Vendedor.class)); continue;
					}

					if(EstadoPedido.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoPedido.class)); continue;
					}

					if(TipoCambio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCambio.class)); continue;
					}

					if(Zona.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Zona.class)); continue;
					}

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
					}

					if(Responsable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Responsable.class)); continue;
					}

					if(Transportista.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transportista.class)); continue;
					}

					if(Transporte.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transporte.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfConsignacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ConsignacionConstantesFunciones.getClassesRelationshipsOfConsignacion(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfConsignacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(DetalleConsignacion.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleConsignacion.class)) {
						classes.add(new Classe(DetalleConsignacion.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfConsignacion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ConsignacionConstantesFunciones.getClassesRelationshipsFromStringsOfConsignacion(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfConsignacion(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleConsignacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleConsignacion.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleConsignacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleConsignacion.class)); continue;
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
	public static void actualizarLista(Consignacion consignacion,List<Consignacion> consignacions,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Consignacion consignacionEncontrado=null;
			
			for(Consignacion consignacionLocal:consignacions) {
				if(consignacionLocal.getId().equals(consignacion.getId())) {
					consignacionEncontrado=consignacionLocal;
					
					consignacionLocal.setIsChanged(consignacion.getIsChanged());
					consignacionLocal.setIsNew(consignacion.getIsNew());
					consignacionLocal.setIsDeleted(consignacion.getIsDeleted());
					
					consignacionLocal.setGeneralEntityOriginal(consignacion.getGeneralEntityOriginal());
					
					consignacionLocal.setId(consignacion.getId());	
					consignacionLocal.setVersionRow(consignacion.getVersionRow());	
					consignacionLocal.setid_empresa(consignacion.getid_empresa());	
					consignacionLocal.setid_sucursal(consignacion.getid_sucursal());	
					consignacionLocal.setid_ejercicio(consignacion.getid_ejercicio());	
					consignacionLocal.setid_periodo(consignacion.getid_periodo());	
					consignacionLocal.setid_anio(consignacion.getid_anio());	
					consignacionLocal.setid_mes(consignacion.getid_mes());	
					consignacionLocal.setid_usuario(consignacion.getid_usuario());	
					consignacionLocal.setnumero(consignacion.getnumero());	
					consignacionLocal.setnumero_autorizacion(consignacion.getnumero_autorizacion());	
					consignacionLocal.setfecha_emision(consignacion.getfecha_emision());	
					consignacionLocal.setfecha_vencimiento(consignacion.getfecha_vencimiento());	
					consignacionLocal.setid_moneda(consignacion.getid_moneda());	
					consignacionLocal.setcotizacion(consignacion.getcotizacion());	
					consignacionLocal.setid_empleado(consignacion.getid_empleado());	
					consignacionLocal.setid_tipo_precio(consignacion.getid_tipo_precio());	
					consignacionLocal.setid_formato(consignacion.getid_formato());	
					consignacionLocal.setdireccion(consignacion.getdireccion());	
					consignacionLocal.setid_cliente(consignacion.getid_cliente());	
					consignacionLocal.settelefono(consignacion.gettelefono());	
					consignacionLocal.setruc(consignacion.getruc());	
					consignacionLocal.setid_sub_cliente(consignacion.getid_sub_cliente());	
					consignacionLocal.setid_consignatario(consignacion.getid_consignatario());	
					consignacionLocal.setid_vendedor(consignacion.getid_vendedor());	
					consignacionLocal.setdescripcion(consignacion.getdescripcion());	
					consignacionLocal.setid_estado_pedido(consignacion.getid_estado_pedido());	
					consignacionLocal.setdescuento_porcentaje(consignacion.getdescuento_porcentaje());	
					consignacionLocal.settotal_con_iva(consignacion.gettotal_con_iva());	
					consignacionLocal.setsuman(consignacion.getsuman());	
					consignacionLocal.setdescuento_valor(consignacion.getdescuento_valor());	
					consignacionLocal.settotal_sin_iva(consignacion.gettotal_sin_iva());	
					consignacionLocal.settotal_descuento(consignacion.gettotal_descuento());	
					consignacionLocal.setflete(consignacion.getflete());	
					consignacionLocal.settotal(consignacion.gettotal());	
					consignacionLocal.setsubtotal(consignacion.getsubtotal());	
					consignacionLocal.setotro(consignacion.getotro());	
					consignacionLocal.setfinanciamiento(consignacion.getfinanciamiento());	
					consignacionLocal.setiva(consignacion.getiva());	
					consignacionLocal.setice(consignacion.getice());	
					consignacionLocal.setmonto_retencion(consignacion.getmonto_retencion());	
					consignacionLocal.setid_tipo_cambio(consignacion.getid_tipo_cambio());	
					consignacionLocal.setnumero_fue(consignacion.getnumero_fue());	
					consignacionLocal.setid_zona(consignacion.getid_zona());	
					consignacionLocal.setfecha(consignacion.getfecha());	
					consignacionLocal.setid_centro_costo(consignacion.getid_centro_costo());	
					consignacionLocal.setfecha_servidor(consignacion.getfecha_servidor());	
					consignacionLocal.setid_responsable(consignacion.getid_responsable());	
					consignacionLocal.sethora_inicio(consignacion.gethora_inicio());	
					consignacionLocal.sethora_fin(consignacion.gethora_fin());	
					consignacionLocal.setid_transportista(consignacion.getid_transportista());	
					consignacionLocal.setid_transporte(consignacion.getid_transporte());	
					
					
					consignacionLocal.setDetalleConsignacions(consignacion.getDetalleConsignacions());
					
					existe=true;
					break;
				}
			}
			
			if(!consignacion.getIsDeleted()) {
				if(!existe) {
					consignacions.add(consignacion);
				}
			} else {
				if(consignacionEncontrado!=null && permiteQuitar)  {
					consignacions.remove(consignacionEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Consignacion consignacion,List<Consignacion> consignacions) throws Exception {
		try	{			
			for(Consignacion consignacionLocal:consignacions) {
				if(consignacionLocal.getId().equals(consignacion.getId())) {
					consignacionLocal.setIsSelected(consignacion.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesConsignacion(List<Consignacion> consignacionsAux) throws Exception {
		//this.consignacionsAux=consignacionsAux;
		
		for(Consignacion consignacionAux:consignacionsAux) {
			if(consignacionAux.getIsChanged()) {
				consignacionAux.setIsChanged(false);
			}		
			
			if(consignacionAux.getIsNew()) {
				consignacionAux.setIsNew(false);
			}	
			
			if(consignacionAux.getIsDeleted()) {
				consignacionAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesConsignacion(Consignacion consignacionAux) throws Exception {
		//this.consignacionAux=consignacionAux;
		
			if(consignacionAux.getIsChanged()) {
				consignacionAux.setIsChanged(false);
			}		
			
			if(consignacionAux.getIsNew()) {
				consignacionAux.setIsNew(false);
			}	
			
			if(consignacionAux.getIsDeleted()) {
				consignacionAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Consignacion consignacionAsignar,Consignacion consignacion) throws Exception {
		consignacionAsignar.setId(consignacion.getId());	
		consignacionAsignar.setVersionRow(consignacion.getVersionRow());	
		consignacionAsignar.setid_empresa(consignacion.getid_empresa());
		consignacionAsignar.setempresa_descripcion(consignacion.getempresa_descripcion());	
		consignacionAsignar.setid_sucursal(consignacion.getid_sucursal());
		consignacionAsignar.setsucursal_descripcion(consignacion.getsucursal_descripcion());	
		consignacionAsignar.setid_ejercicio(consignacion.getid_ejercicio());
		consignacionAsignar.setejercicio_descripcion(consignacion.getejercicio_descripcion());	
		consignacionAsignar.setid_periodo(consignacion.getid_periodo());
		consignacionAsignar.setperiodo_descripcion(consignacion.getperiodo_descripcion());	
		consignacionAsignar.setid_anio(consignacion.getid_anio());
		consignacionAsignar.setanio_descripcion(consignacion.getanio_descripcion());	
		consignacionAsignar.setid_mes(consignacion.getid_mes());
		consignacionAsignar.setmes_descripcion(consignacion.getmes_descripcion());	
		consignacionAsignar.setid_usuario(consignacion.getid_usuario());
		consignacionAsignar.setusuario_descripcion(consignacion.getusuario_descripcion());	
		consignacionAsignar.setnumero(consignacion.getnumero());	
		consignacionAsignar.setnumero_autorizacion(consignacion.getnumero_autorizacion());	
		consignacionAsignar.setfecha_emision(consignacion.getfecha_emision());	
		consignacionAsignar.setfecha_vencimiento(consignacion.getfecha_vencimiento());	
		consignacionAsignar.setid_moneda(consignacion.getid_moneda());
		consignacionAsignar.setmoneda_descripcion(consignacion.getmoneda_descripcion());	
		consignacionAsignar.setcotizacion(consignacion.getcotizacion());	
		consignacionAsignar.setid_empleado(consignacion.getid_empleado());
		consignacionAsignar.setempleado_descripcion(consignacion.getempleado_descripcion());	
		consignacionAsignar.setid_tipo_precio(consignacion.getid_tipo_precio());
		consignacionAsignar.settipoprecio_descripcion(consignacion.gettipoprecio_descripcion());	
		consignacionAsignar.setid_formato(consignacion.getid_formato());
		consignacionAsignar.setformato_descripcion(consignacion.getformato_descripcion());	
		consignacionAsignar.setdireccion(consignacion.getdireccion());	
		consignacionAsignar.setid_cliente(consignacion.getid_cliente());
		consignacionAsignar.setcliente_descripcion(consignacion.getcliente_descripcion());	
		consignacionAsignar.settelefono(consignacion.gettelefono());	
		consignacionAsignar.setruc(consignacion.getruc());	
		consignacionAsignar.setid_sub_cliente(consignacion.getid_sub_cliente());
		consignacionAsignar.setsubcliente_descripcion(consignacion.getsubcliente_descripcion());	
		consignacionAsignar.setid_consignatario(consignacion.getid_consignatario());
		consignacionAsignar.setconsignatario_descripcion(consignacion.getconsignatario_descripcion());	
		consignacionAsignar.setid_vendedor(consignacion.getid_vendedor());
		consignacionAsignar.setvendedor_descripcion(consignacion.getvendedor_descripcion());	
		consignacionAsignar.setdescripcion(consignacion.getdescripcion());	
		consignacionAsignar.setid_estado_pedido(consignacion.getid_estado_pedido());
		consignacionAsignar.setestadopedido_descripcion(consignacion.getestadopedido_descripcion());	
		consignacionAsignar.setdescuento_porcentaje(consignacion.getdescuento_porcentaje());	
		consignacionAsignar.settotal_con_iva(consignacion.gettotal_con_iva());	
		consignacionAsignar.setsuman(consignacion.getsuman());	
		consignacionAsignar.setdescuento_valor(consignacion.getdescuento_valor());	
		consignacionAsignar.settotal_sin_iva(consignacion.gettotal_sin_iva());	
		consignacionAsignar.settotal_descuento(consignacion.gettotal_descuento());	
		consignacionAsignar.setflete(consignacion.getflete());	
		consignacionAsignar.settotal(consignacion.gettotal());	
		consignacionAsignar.setsubtotal(consignacion.getsubtotal());	
		consignacionAsignar.setotro(consignacion.getotro());	
		consignacionAsignar.setfinanciamiento(consignacion.getfinanciamiento());	
		consignacionAsignar.setiva(consignacion.getiva());	
		consignacionAsignar.setice(consignacion.getice());	
		consignacionAsignar.setmonto_retencion(consignacion.getmonto_retencion());	
		consignacionAsignar.setid_tipo_cambio(consignacion.getid_tipo_cambio());
		consignacionAsignar.settipocambio_descripcion(consignacion.gettipocambio_descripcion());	
		consignacionAsignar.setnumero_fue(consignacion.getnumero_fue());	
		consignacionAsignar.setid_zona(consignacion.getid_zona());
		consignacionAsignar.setzona_descripcion(consignacion.getzona_descripcion());	
		consignacionAsignar.setfecha(consignacion.getfecha());	
		consignacionAsignar.setid_centro_costo(consignacion.getid_centro_costo());
		consignacionAsignar.setcentrocosto_descripcion(consignacion.getcentrocosto_descripcion());	
		consignacionAsignar.setfecha_servidor(consignacion.getfecha_servidor());	
		consignacionAsignar.setid_responsable(consignacion.getid_responsable());
		consignacionAsignar.setresponsable_descripcion(consignacion.getresponsable_descripcion());	
		consignacionAsignar.sethora_inicio(consignacion.gethora_inicio());	
		consignacionAsignar.sethora_fin(consignacion.gethora_fin());	
		consignacionAsignar.setid_transportista(consignacion.getid_transportista());
		consignacionAsignar.settransportista_descripcion(consignacion.gettransportista_descripcion());	
		consignacionAsignar.setid_transporte(consignacion.getid_transporte());
		consignacionAsignar.settransporte_descripcion(consignacion.gettransporte_descripcion());	
	}
	
	public static void inicializarConsignacion(Consignacion consignacion) throws Exception {
		try {
				consignacion.setId(0L);	
					
				consignacion.setid_empresa(-1L);	
				consignacion.setid_sucursal(-1L);	
				consignacion.setid_ejercicio(-1L);	
				consignacion.setid_periodo(-1L);	
				consignacion.setid_anio(null);	
				consignacion.setid_mes(null);	
				consignacion.setid_usuario(-1L);	
				consignacion.setnumero("");	
				consignacion.setnumero_autorizacion("");	
				consignacion.setfecha_emision(new Date());	
				consignacion.setfecha_vencimiento(new Date());	
				consignacion.setid_moneda(-1L);	
				consignacion.setcotizacion(0.0);	
				consignacion.setid_empleado(-1L);	
				consignacion.setid_tipo_precio(-1L);	
				consignacion.setid_formato(null);	
				consignacion.setdireccion("");	
				consignacion.setid_cliente(-1L);	
				consignacion.settelefono("");	
				consignacion.setruc("");	
				consignacion.setid_sub_cliente(null);	
				consignacion.setid_consignatario(-1L);	
				consignacion.setid_vendedor(null);	
				consignacion.setdescripcion("");	
				consignacion.setid_estado_pedido(1L);	
				consignacion.setdescuento_porcentaje(0.0);	
				consignacion.settotal_con_iva(0.0);	
				consignacion.setsuman(0.0);	
				consignacion.setdescuento_valor(0.0);	
				consignacion.settotal_sin_iva(0.0);	
				consignacion.settotal_descuento(0.0);	
				consignacion.setflete(0.0);	
				consignacion.settotal(0.0);	
				consignacion.setsubtotal(0.0);	
				consignacion.setotro(0.0);	
				consignacion.setfinanciamiento(0.0);	
				consignacion.setiva(0.0);	
				consignacion.setice(0.0);	
				consignacion.setmonto_retencion(0.0);	
				consignacion.setid_tipo_cambio(null);	
				consignacion.setnumero_fue("");	
				consignacion.setid_zona(null);	
				consignacion.setfecha(new Date());	
				consignacion.setid_centro_costo(null);	
				consignacion.setfecha_servidor(new Date());	
				consignacion.setid_responsable(null);	
				consignacion.sethora_inicio(new Time((new Date()).getTime()));	
				consignacion.sethora_fin(new Time((new Date()).getTime()));	
				consignacion.setid_transportista(null);	
				consignacion.setid_transporte(-1L);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderConsignacion(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsignacionConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsignacionConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsignacionConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsignacionConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsignacionConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsignacionConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsignacionConstantesFunciones.LABEL_IDUSUARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsignacionConstantesFunciones.LABEL_NUMERO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsignacionConstantesFunciones.LABEL_NUMEROAUTORIZACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsignacionConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsignacionConstantesFunciones.LABEL_FECHAVENCIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsignacionConstantesFunciones.LABEL_IDMONEDA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsignacionConstantesFunciones.LABEL_COTIZACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsignacionConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsignacionConstantesFunciones.LABEL_IDTIPOPRECIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsignacionConstantesFunciones.LABEL_IDFORMATO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsignacionConstantesFunciones.LABEL_DIRECCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsignacionConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsignacionConstantesFunciones.LABEL_TELEFONO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsignacionConstantesFunciones.LABEL_RUC);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsignacionConstantesFunciones.LABEL_IDSUBCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsignacionConstantesFunciones.LABEL_IDCONSIGNATARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsignacionConstantesFunciones.LABEL_IDVENDEDOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsignacionConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsignacionConstantesFunciones.LABEL_IDESTADOPEDIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsignacionConstantesFunciones.LABEL_DESCUENTOPORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsignacionConstantesFunciones.LABEL_TOTALCONIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsignacionConstantesFunciones.LABEL_SUMAN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsignacionConstantesFunciones.LABEL_DESCUENTOVALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsignacionConstantesFunciones.LABEL_TOTALSINIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsignacionConstantesFunciones.LABEL_TOTALDESCUENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsignacionConstantesFunciones.LABEL_FLETE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsignacionConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsignacionConstantesFunciones.LABEL_SUBTOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsignacionConstantesFunciones.LABEL_OTRO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsignacionConstantesFunciones.LABEL_FINANCIAMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsignacionConstantesFunciones.LABEL_IVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsignacionConstantesFunciones.LABEL_ICE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsignacionConstantesFunciones.LABEL_MONTORETENCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsignacionConstantesFunciones.LABEL_IDTIPOCAMBIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsignacionConstantesFunciones.LABEL_NUMEROFUE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsignacionConstantesFunciones.LABEL_IDZONA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsignacionConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsignacionConstantesFunciones.LABEL_IDCENTROCOSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsignacionConstantesFunciones.LABEL_FECHASERVIDOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsignacionConstantesFunciones.LABEL_IDRESPONSABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsignacionConstantesFunciones.LABEL_HORAINICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsignacionConstantesFunciones.LABEL_HORAFIN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsignacionConstantesFunciones.LABEL_IDTRANSPORTISTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsignacionConstantesFunciones.LABEL_IDTRANSPORTE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataConsignacion(String sTipo,Row row,Workbook workbook,Consignacion consignacion,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(consignacion.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consignacion.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consignacion.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consignacion.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consignacion.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consignacion.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consignacion.getusuario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consignacion.getnumero());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consignacion.getnumero_autorizacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consignacion.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consignacion.getfecha_vencimiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consignacion.getmoneda_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consignacion.getcotizacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consignacion.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consignacion.gettipoprecio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consignacion.getformato_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consignacion.getdireccion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consignacion.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consignacion.gettelefono());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consignacion.getruc());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consignacion.getsubcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consignacion.getconsignatario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consignacion.getvendedor_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consignacion.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consignacion.getestadopedido_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consignacion.getdescuento_porcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consignacion.gettotal_con_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consignacion.getsuman());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consignacion.getdescuento_valor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consignacion.gettotal_sin_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consignacion.gettotal_descuento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consignacion.getflete());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consignacion.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consignacion.getsubtotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consignacion.getotro());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consignacion.getfinanciamiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consignacion.getiva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consignacion.getice());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consignacion.getmonto_retencion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consignacion.gettipocambio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consignacion.getnumero_fue());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consignacion.getzona_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consignacion.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consignacion.getcentrocosto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consignacion.getfecha_servidor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consignacion.getresponsable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consignacion.gethora_inicio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consignacion.gethora_fin());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consignacion.gettransportista_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consignacion.gettransporte_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryConsignacion=Constantes.SFINALQUERY;
	
	public String getsFinalQueryConsignacion() {
		return this.sFinalQueryConsignacion;
	}
	
	public void setsFinalQueryConsignacion(String sFinalQueryConsignacion) {
		this.sFinalQueryConsignacion= sFinalQueryConsignacion;
	}
	
	public Border resaltarSeleccionarConsignacion=null;
	
	public Border setResaltarSeleccionarConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//consignacionBeanSwingJInternalFrame.jTtoolBarConsignacion.setBorder(borderResaltar);
		
		this.resaltarSeleccionarConsignacion= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarConsignacion() {
		return this.resaltarSeleccionarConsignacion;
	}
	
	public void setResaltarSeleccionarConsignacion(Border borderResaltarSeleccionarConsignacion) {
		this.resaltarSeleccionarConsignacion= borderResaltarSeleccionarConsignacion;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridConsignacion=null;
	public Boolean mostraridConsignacion=true;
	public Boolean activaridConsignacion=true;

	public Border resaltarid_empresaConsignacion=null;
	public Boolean mostrarid_empresaConsignacion=true;
	public Boolean activarid_empresaConsignacion=true;
	public Boolean cargarid_empresaConsignacion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaConsignacion=false;//ConEventDepend=true

	public Border resaltarid_sucursalConsignacion=null;
	public Boolean mostrarid_sucursalConsignacion=true;
	public Boolean activarid_sucursalConsignacion=true;
	public Boolean cargarid_sucursalConsignacion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalConsignacion=false;//ConEventDepend=true

	public Border resaltarid_ejercicioConsignacion=null;
	public Boolean mostrarid_ejercicioConsignacion=true;
	public Boolean activarid_ejercicioConsignacion=true;
	public Boolean cargarid_ejercicioConsignacion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioConsignacion=false;//ConEventDepend=true

	public Border resaltarid_periodoConsignacion=null;
	public Boolean mostrarid_periodoConsignacion=true;
	public Boolean activarid_periodoConsignacion=true;
	public Boolean cargarid_periodoConsignacion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoConsignacion=false;//ConEventDepend=true

	public Border resaltarid_anioConsignacion=null;
	public Boolean mostrarid_anioConsignacion=true;
	public Boolean activarid_anioConsignacion=false;
	public Boolean cargarid_anioConsignacion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioConsignacion=false;//ConEventDepend=true

	public Border resaltarid_mesConsignacion=null;
	public Boolean mostrarid_mesConsignacion=true;
	public Boolean activarid_mesConsignacion=false;
	public Boolean cargarid_mesConsignacion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesConsignacion=false;//ConEventDepend=true

	public Border resaltarid_usuarioConsignacion=null;
	public Boolean mostrarid_usuarioConsignacion=true;
	public Boolean activarid_usuarioConsignacion=true;
	public Boolean cargarid_usuarioConsignacion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_usuarioConsignacion=false;//ConEventDepend=true

	public Border resaltarnumeroConsignacion=null;
	public Boolean mostrarnumeroConsignacion=true;
	public Boolean activarnumeroConsignacion=true;

	public Border resaltarnumero_autorizacionConsignacion=null;
	public Boolean mostrarnumero_autorizacionConsignacion=true;
	public Boolean activarnumero_autorizacionConsignacion=true;

	public Border resaltarfecha_emisionConsignacion=null;
	public Boolean mostrarfecha_emisionConsignacion=true;
	public Boolean activarfecha_emisionConsignacion=true;

	public Border resaltarfecha_vencimientoConsignacion=null;
	public Boolean mostrarfecha_vencimientoConsignacion=true;
	public Boolean activarfecha_vencimientoConsignacion=true;

	public Border resaltarid_monedaConsignacion=null;
	public Boolean mostrarid_monedaConsignacion=true;
	public Boolean activarid_monedaConsignacion=true;
	public Boolean cargarid_monedaConsignacion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_monedaConsignacion=false;//ConEventDepend=true

	public Border resaltarcotizacionConsignacion=null;
	public Boolean mostrarcotizacionConsignacion=true;
	public Boolean activarcotizacionConsignacion=true;

	public Border resaltarid_empleadoConsignacion=null;
	public Boolean mostrarid_empleadoConsignacion=true;
	public Boolean activarid_empleadoConsignacion=true;
	public Boolean cargarid_empleadoConsignacion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoConsignacion=false;//ConEventDepend=true

	public Border resaltarid_tipo_precioConsignacion=null;
	public Boolean mostrarid_tipo_precioConsignacion=true;
	public Boolean activarid_tipo_precioConsignacion=true;
	public Boolean cargarid_tipo_precioConsignacion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_precioConsignacion=false;//ConEventDepend=true

	public Border resaltarid_formatoConsignacion=null;
	public Boolean mostrarid_formatoConsignacion=true;
	public Boolean activarid_formatoConsignacion=true;
	public Boolean cargarid_formatoConsignacion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formatoConsignacion=false;//ConEventDepend=true

	public Border resaltardireccionConsignacion=null;
	public Boolean mostrardireccionConsignacion=true;
	public Boolean activardireccionConsignacion=true;

	public Border resaltarid_clienteConsignacion=null;
	public Boolean mostrarid_clienteConsignacion=true;
	public Boolean activarid_clienteConsignacion=true;
	public Boolean cargarid_clienteConsignacion=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteConsignacion=false;//ConEventDepend=true

	public Border resaltartelefonoConsignacion=null;
	public Boolean mostrartelefonoConsignacion=true;
	public Boolean activartelefonoConsignacion=true;

	public Border resaltarrucConsignacion=null;
	public Boolean mostrarrucConsignacion=true;
	public Boolean activarrucConsignacion=true;

	public Border resaltarid_sub_clienteConsignacion=null;
	public Boolean mostrarid_sub_clienteConsignacion=true;
	public Boolean activarid_sub_clienteConsignacion=true;
	public Boolean cargarid_sub_clienteConsignacion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sub_clienteConsignacion=false;//ConEventDepend=true

	public Border resaltarid_consignatarioConsignacion=null;
	public Boolean mostrarid_consignatarioConsignacion=true;
	public Boolean activarid_consignatarioConsignacion=true;
	public Boolean cargarid_consignatarioConsignacion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_consignatarioConsignacion=false;//ConEventDepend=true

	public Border resaltarid_vendedorConsignacion=null;
	public Boolean mostrarid_vendedorConsignacion=true;
	public Boolean activarid_vendedorConsignacion=true;
	public Boolean cargarid_vendedorConsignacion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_vendedorConsignacion=false;//ConEventDepend=true

	public Border resaltardescripcionConsignacion=null;
	public Boolean mostrardescripcionConsignacion=true;
	public Boolean activardescripcionConsignacion=true;

	public Border resaltarid_estado_pedidoConsignacion=null;
	public Boolean mostrarid_estado_pedidoConsignacion=true;
	public Boolean activarid_estado_pedidoConsignacion=true;
	public Boolean cargarid_estado_pedidoConsignacion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_pedidoConsignacion=false;//ConEventDepend=true

	public Border resaltardescuento_porcentajeConsignacion=null;
	public Boolean mostrardescuento_porcentajeConsignacion=true;
	public Boolean activardescuento_porcentajeConsignacion=true;

	public Border resaltartotal_con_ivaConsignacion=null;
	public Boolean mostrartotal_con_ivaConsignacion=true;
	public Boolean activartotal_con_ivaConsignacion=true;

	public Border resaltarsumanConsignacion=null;
	public Boolean mostrarsumanConsignacion=true;
	public Boolean activarsumanConsignacion=true;

	public Border resaltardescuento_valorConsignacion=null;
	public Boolean mostrardescuento_valorConsignacion=true;
	public Boolean activardescuento_valorConsignacion=true;

	public Border resaltartotal_sin_ivaConsignacion=null;
	public Boolean mostrartotal_sin_ivaConsignacion=true;
	public Boolean activartotal_sin_ivaConsignacion=true;

	public Border resaltartotal_descuentoConsignacion=null;
	public Boolean mostrartotal_descuentoConsignacion=true;
	public Boolean activartotal_descuentoConsignacion=true;

	public Border resaltarfleteConsignacion=null;
	public Boolean mostrarfleteConsignacion=true;
	public Boolean activarfleteConsignacion=true;

	public Border resaltartotalConsignacion=null;
	public Boolean mostrartotalConsignacion=true;
	public Boolean activartotalConsignacion=true;

	public Border resaltarsubtotalConsignacion=null;
	public Boolean mostrarsubtotalConsignacion=true;
	public Boolean activarsubtotalConsignacion=true;

	public Border resaltarotroConsignacion=null;
	public Boolean mostrarotroConsignacion=true;
	public Boolean activarotroConsignacion=true;

	public Border resaltarfinanciamientoConsignacion=null;
	public Boolean mostrarfinanciamientoConsignacion=true;
	public Boolean activarfinanciamientoConsignacion=true;

	public Border resaltarivaConsignacion=null;
	public Boolean mostrarivaConsignacion=true;
	public Boolean activarivaConsignacion=false;

	public Border resaltariceConsignacion=null;
	public Boolean mostrariceConsignacion=true;
	public Boolean activariceConsignacion=false;

	public Border resaltarmonto_retencionConsignacion=null;
	public Boolean mostrarmonto_retencionConsignacion=true;
	public Boolean activarmonto_retencionConsignacion=false;

	public Border resaltarid_tipo_cambioConsignacion=null;
	public Boolean mostrarid_tipo_cambioConsignacion=true;
	public Boolean activarid_tipo_cambioConsignacion=false;
	public Boolean cargarid_tipo_cambioConsignacion=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_cambioConsignacion=false;//ConEventDepend=true

	public Border resaltarnumero_fueConsignacion=null;
	public Boolean mostrarnumero_fueConsignacion=true;
	public Boolean activarnumero_fueConsignacion=false;

	public Border resaltarid_zonaConsignacion=null;
	public Boolean mostrarid_zonaConsignacion=true;
	public Boolean activarid_zonaConsignacion=false;
	public Boolean cargarid_zonaConsignacion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_zonaConsignacion=false;//ConEventDepend=true

	public Border resaltarfechaConsignacion=null;
	public Boolean mostrarfechaConsignacion=true;
	public Boolean activarfechaConsignacion=false;

	public Border resaltarid_centro_costoConsignacion=null;
	public Boolean mostrarid_centro_costoConsignacion=true;
	public Boolean activarid_centro_costoConsignacion=false;
	public Boolean cargarid_centro_costoConsignacion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_centro_costoConsignacion=false;//ConEventDepend=true

	public Border resaltarfecha_servidorConsignacion=null;
	public Boolean mostrarfecha_servidorConsignacion=true;
	public Boolean activarfecha_servidorConsignacion=false;

	public Border resaltarid_responsableConsignacion=null;
	public Boolean mostrarid_responsableConsignacion=true;
	public Boolean activarid_responsableConsignacion=false;
	public Boolean cargarid_responsableConsignacion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_responsableConsignacion=false;//ConEventDepend=true

	public Border resaltarhora_inicioConsignacion=null;
	public Boolean mostrarhora_inicioConsignacion=true;
	public Boolean activarhora_inicioConsignacion=false;

	public Border resaltarhora_finConsignacion=null;
	public Boolean mostrarhora_finConsignacion=true;
	public Boolean activarhora_finConsignacion=false;

	public Border resaltarid_transportistaConsignacion=null;
	public Boolean mostrarid_transportistaConsignacion=true;
	public Boolean activarid_transportistaConsignacion=false;
	public Boolean cargarid_transportistaConsignacion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transportistaConsignacion=false;//ConEventDepend=true

	public Border resaltarid_transporteConsignacion=null;
	public Boolean mostrarid_transporteConsignacion=true;
	public Boolean activarid_transporteConsignacion=false;
	public Boolean cargarid_transporteConsignacion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transporteConsignacion=false;//ConEventDepend=true

	
	

	public Border setResaltaridConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consignacionBeanSwingJInternalFrame.jTtoolBarConsignacion.setBorder(borderResaltar);
		
		this.resaltaridConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridConsignacion() {
		return this.resaltaridConsignacion;
	}

	public void setResaltaridConsignacion(Border borderResaltar) {
		this.resaltaridConsignacion= borderResaltar;
	}

	public Boolean getMostraridConsignacion() {
		return this.mostraridConsignacion;
	}

	public void setMostraridConsignacion(Boolean mostraridConsignacion) {
		this.mostraridConsignacion= mostraridConsignacion;
	}

	public Boolean getActivaridConsignacion() {
		return this.activaridConsignacion;
	}

	public void setActivaridConsignacion(Boolean activaridConsignacion) {
		this.activaridConsignacion= activaridConsignacion;
	}

	public Border setResaltarid_empresaConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consignacionBeanSwingJInternalFrame.jTtoolBarConsignacion.setBorder(borderResaltar);
		
		this.resaltarid_empresaConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaConsignacion() {
		return this.resaltarid_empresaConsignacion;
	}

	public void setResaltarid_empresaConsignacion(Border borderResaltar) {
		this.resaltarid_empresaConsignacion= borderResaltar;
	}

	public Boolean getMostrarid_empresaConsignacion() {
		return this.mostrarid_empresaConsignacion;
	}

	public void setMostrarid_empresaConsignacion(Boolean mostrarid_empresaConsignacion) {
		this.mostrarid_empresaConsignacion= mostrarid_empresaConsignacion;
	}

	public Boolean getActivarid_empresaConsignacion() {
		return this.activarid_empresaConsignacion;
	}

	public void setActivarid_empresaConsignacion(Boolean activarid_empresaConsignacion) {
		this.activarid_empresaConsignacion= activarid_empresaConsignacion;
	}

	public Boolean getCargarid_empresaConsignacion() {
		return this.cargarid_empresaConsignacion;
	}

	public void setCargarid_empresaConsignacion(Boolean cargarid_empresaConsignacion) {
		this.cargarid_empresaConsignacion= cargarid_empresaConsignacion;
	}

	public Border setResaltarid_sucursalConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consignacionBeanSwingJInternalFrame.jTtoolBarConsignacion.setBorder(borderResaltar);
		
		this.resaltarid_sucursalConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalConsignacion() {
		return this.resaltarid_sucursalConsignacion;
	}

	public void setResaltarid_sucursalConsignacion(Border borderResaltar) {
		this.resaltarid_sucursalConsignacion= borderResaltar;
	}

	public Boolean getMostrarid_sucursalConsignacion() {
		return this.mostrarid_sucursalConsignacion;
	}

	public void setMostrarid_sucursalConsignacion(Boolean mostrarid_sucursalConsignacion) {
		this.mostrarid_sucursalConsignacion= mostrarid_sucursalConsignacion;
	}

	public Boolean getActivarid_sucursalConsignacion() {
		return this.activarid_sucursalConsignacion;
	}

	public void setActivarid_sucursalConsignacion(Boolean activarid_sucursalConsignacion) {
		this.activarid_sucursalConsignacion= activarid_sucursalConsignacion;
	}

	public Boolean getCargarid_sucursalConsignacion() {
		return this.cargarid_sucursalConsignacion;
	}

	public void setCargarid_sucursalConsignacion(Boolean cargarid_sucursalConsignacion) {
		this.cargarid_sucursalConsignacion= cargarid_sucursalConsignacion;
	}

	public Border setResaltarid_ejercicioConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consignacionBeanSwingJInternalFrame.jTtoolBarConsignacion.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioConsignacion() {
		return this.resaltarid_ejercicioConsignacion;
	}

	public void setResaltarid_ejercicioConsignacion(Border borderResaltar) {
		this.resaltarid_ejercicioConsignacion= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioConsignacion() {
		return this.mostrarid_ejercicioConsignacion;
	}

	public void setMostrarid_ejercicioConsignacion(Boolean mostrarid_ejercicioConsignacion) {
		this.mostrarid_ejercicioConsignacion= mostrarid_ejercicioConsignacion;
	}

	public Boolean getActivarid_ejercicioConsignacion() {
		return this.activarid_ejercicioConsignacion;
	}

	public void setActivarid_ejercicioConsignacion(Boolean activarid_ejercicioConsignacion) {
		this.activarid_ejercicioConsignacion= activarid_ejercicioConsignacion;
	}

	public Boolean getCargarid_ejercicioConsignacion() {
		return this.cargarid_ejercicioConsignacion;
	}

	public void setCargarid_ejercicioConsignacion(Boolean cargarid_ejercicioConsignacion) {
		this.cargarid_ejercicioConsignacion= cargarid_ejercicioConsignacion;
	}

	public Border setResaltarid_periodoConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consignacionBeanSwingJInternalFrame.jTtoolBarConsignacion.setBorder(borderResaltar);
		
		this.resaltarid_periodoConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoConsignacion() {
		return this.resaltarid_periodoConsignacion;
	}

	public void setResaltarid_periodoConsignacion(Border borderResaltar) {
		this.resaltarid_periodoConsignacion= borderResaltar;
	}

	public Boolean getMostrarid_periodoConsignacion() {
		return this.mostrarid_periodoConsignacion;
	}

	public void setMostrarid_periodoConsignacion(Boolean mostrarid_periodoConsignacion) {
		this.mostrarid_periodoConsignacion= mostrarid_periodoConsignacion;
	}

	public Boolean getActivarid_periodoConsignacion() {
		return this.activarid_periodoConsignacion;
	}

	public void setActivarid_periodoConsignacion(Boolean activarid_periodoConsignacion) {
		this.activarid_periodoConsignacion= activarid_periodoConsignacion;
	}

	public Boolean getCargarid_periodoConsignacion() {
		return this.cargarid_periodoConsignacion;
	}

	public void setCargarid_periodoConsignacion(Boolean cargarid_periodoConsignacion) {
		this.cargarid_periodoConsignacion= cargarid_periodoConsignacion;
	}

	public Border setResaltarid_anioConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consignacionBeanSwingJInternalFrame.jTtoolBarConsignacion.setBorder(borderResaltar);
		
		this.resaltarid_anioConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioConsignacion() {
		return this.resaltarid_anioConsignacion;
	}

	public void setResaltarid_anioConsignacion(Border borderResaltar) {
		this.resaltarid_anioConsignacion= borderResaltar;
	}

	public Boolean getMostrarid_anioConsignacion() {
		return this.mostrarid_anioConsignacion;
	}

	public void setMostrarid_anioConsignacion(Boolean mostrarid_anioConsignacion) {
		this.mostrarid_anioConsignacion= mostrarid_anioConsignacion;
	}

	public Boolean getActivarid_anioConsignacion() {
		return this.activarid_anioConsignacion;
	}

	public void setActivarid_anioConsignacion(Boolean activarid_anioConsignacion) {
		this.activarid_anioConsignacion= activarid_anioConsignacion;
	}

	public Boolean getCargarid_anioConsignacion() {
		return this.cargarid_anioConsignacion;
	}

	public void setCargarid_anioConsignacion(Boolean cargarid_anioConsignacion) {
		this.cargarid_anioConsignacion= cargarid_anioConsignacion;
	}

	public Border setResaltarid_mesConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consignacionBeanSwingJInternalFrame.jTtoolBarConsignacion.setBorder(borderResaltar);
		
		this.resaltarid_mesConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesConsignacion() {
		return this.resaltarid_mesConsignacion;
	}

	public void setResaltarid_mesConsignacion(Border borderResaltar) {
		this.resaltarid_mesConsignacion= borderResaltar;
	}

	public Boolean getMostrarid_mesConsignacion() {
		return this.mostrarid_mesConsignacion;
	}

	public void setMostrarid_mesConsignacion(Boolean mostrarid_mesConsignacion) {
		this.mostrarid_mesConsignacion= mostrarid_mesConsignacion;
	}

	public Boolean getActivarid_mesConsignacion() {
		return this.activarid_mesConsignacion;
	}

	public void setActivarid_mesConsignacion(Boolean activarid_mesConsignacion) {
		this.activarid_mesConsignacion= activarid_mesConsignacion;
	}

	public Boolean getCargarid_mesConsignacion() {
		return this.cargarid_mesConsignacion;
	}

	public void setCargarid_mesConsignacion(Boolean cargarid_mesConsignacion) {
		this.cargarid_mesConsignacion= cargarid_mesConsignacion;
	}

	public Border setResaltarid_usuarioConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consignacionBeanSwingJInternalFrame.jTtoolBarConsignacion.setBorder(borderResaltar);
		
		this.resaltarid_usuarioConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_usuarioConsignacion() {
		return this.resaltarid_usuarioConsignacion;
	}

	public void setResaltarid_usuarioConsignacion(Border borderResaltar) {
		this.resaltarid_usuarioConsignacion= borderResaltar;
	}

	public Boolean getMostrarid_usuarioConsignacion() {
		return this.mostrarid_usuarioConsignacion;
	}

	public void setMostrarid_usuarioConsignacion(Boolean mostrarid_usuarioConsignacion) {
		this.mostrarid_usuarioConsignacion= mostrarid_usuarioConsignacion;
	}

	public Boolean getActivarid_usuarioConsignacion() {
		return this.activarid_usuarioConsignacion;
	}

	public void setActivarid_usuarioConsignacion(Boolean activarid_usuarioConsignacion) {
		this.activarid_usuarioConsignacion= activarid_usuarioConsignacion;
	}

	public Boolean getCargarid_usuarioConsignacion() {
		return this.cargarid_usuarioConsignacion;
	}

	public void setCargarid_usuarioConsignacion(Boolean cargarid_usuarioConsignacion) {
		this.cargarid_usuarioConsignacion= cargarid_usuarioConsignacion;
	}

	public Border setResaltarnumeroConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consignacionBeanSwingJInternalFrame.jTtoolBarConsignacion.setBorder(borderResaltar);
		
		this.resaltarnumeroConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumeroConsignacion() {
		return this.resaltarnumeroConsignacion;
	}

	public void setResaltarnumeroConsignacion(Border borderResaltar) {
		this.resaltarnumeroConsignacion= borderResaltar;
	}

	public Boolean getMostrarnumeroConsignacion() {
		return this.mostrarnumeroConsignacion;
	}

	public void setMostrarnumeroConsignacion(Boolean mostrarnumeroConsignacion) {
		this.mostrarnumeroConsignacion= mostrarnumeroConsignacion;
	}

	public Boolean getActivarnumeroConsignacion() {
		return this.activarnumeroConsignacion;
	}

	public void setActivarnumeroConsignacion(Boolean activarnumeroConsignacion) {
		this.activarnumeroConsignacion= activarnumeroConsignacion;
	}

	public Border setResaltarnumero_autorizacionConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consignacionBeanSwingJInternalFrame.jTtoolBarConsignacion.setBorder(borderResaltar);
		
		this.resaltarnumero_autorizacionConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_autorizacionConsignacion() {
		return this.resaltarnumero_autorizacionConsignacion;
	}

	public void setResaltarnumero_autorizacionConsignacion(Border borderResaltar) {
		this.resaltarnumero_autorizacionConsignacion= borderResaltar;
	}

	public Boolean getMostrarnumero_autorizacionConsignacion() {
		return this.mostrarnumero_autorizacionConsignacion;
	}

	public void setMostrarnumero_autorizacionConsignacion(Boolean mostrarnumero_autorizacionConsignacion) {
		this.mostrarnumero_autorizacionConsignacion= mostrarnumero_autorizacionConsignacion;
	}

	public Boolean getActivarnumero_autorizacionConsignacion() {
		return this.activarnumero_autorizacionConsignacion;
	}

	public void setActivarnumero_autorizacionConsignacion(Boolean activarnumero_autorizacionConsignacion) {
		this.activarnumero_autorizacionConsignacion= activarnumero_autorizacionConsignacion;
	}

	public Border setResaltarfecha_emisionConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consignacionBeanSwingJInternalFrame.jTtoolBarConsignacion.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionConsignacion() {
		return this.resaltarfecha_emisionConsignacion;
	}

	public void setResaltarfecha_emisionConsignacion(Border borderResaltar) {
		this.resaltarfecha_emisionConsignacion= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionConsignacion() {
		return this.mostrarfecha_emisionConsignacion;
	}

	public void setMostrarfecha_emisionConsignacion(Boolean mostrarfecha_emisionConsignacion) {
		this.mostrarfecha_emisionConsignacion= mostrarfecha_emisionConsignacion;
	}

	public Boolean getActivarfecha_emisionConsignacion() {
		return this.activarfecha_emisionConsignacion;
	}

	public void setActivarfecha_emisionConsignacion(Boolean activarfecha_emisionConsignacion) {
		this.activarfecha_emisionConsignacion= activarfecha_emisionConsignacion;
	}

	public Border setResaltarfecha_vencimientoConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consignacionBeanSwingJInternalFrame.jTtoolBarConsignacion.setBorder(borderResaltar);
		
		this.resaltarfecha_vencimientoConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_vencimientoConsignacion() {
		return this.resaltarfecha_vencimientoConsignacion;
	}

	public void setResaltarfecha_vencimientoConsignacion(Border borderResaltar) {
		this.resaltarfecha_vencimientoConsignacion= borderResaltar;
	}

	public Boolean getMostrarfecha_vencimientoConsignacion() {
		return this.mostrarfecha_vencimientoConsignacion;
	}

	public void setMostrarfecha_vencimientoConsignacion(Boolean mostrarfecha_vencimientoConsignacion) {
		this.mostrarfecha_vencimientoConsignacion= mostrarfecha_vencimientoConsignacion;
	}

	public Boolean getActivarfecha_vencimientoConsignacion() {
		return this.activarfecha_vencimientoConsignacion;
	}

	public void setActivarfecha_vencimientoConsignacion(Boolean activarfecha_vencimientoConsignacion) {
		this.activarfecha_vencimientoConsignacion= activarfecha_vencimientoConsignacion;
	}

	public Border setResaltarid_monedaConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consignacionBeanSwingJInternalFrame.jTtoolBarConsignacion.setBorder(borderResaltar);
		
		this.resaltarid_monedaConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_monedaConsignacion() {
		return this.resaltarid_monedaConsignacion;
	}

	public void setResaltarid_monedaConsignacion(Border borderResaltar) {
		this.resaltarid_monedaConsignacion= borderResaltar;
	}

	public Boolean getMostrarid_monedaConsignacion() {
		return this.mostrarid_monedaConsignacion;
	}

	public void setMostrarid_monedaConsignacion(Boolean mostrarid_monedaConsignacion) {
		this.mostrarid_monedaConsignacion= mostrarid_monedaConsignacion;
	}

	public Boolean getActivarid_monedaConsignacion() {
		return this.activarid_monedaConsignacion;
	}

	public void setActivarid_monedaConsignacion(Boolean activarid_monedaConsignacion) {
		this.activarid_monedaConsignacion= activarid_monedaConsignacion;
	}

	public Boolean getCargarid_monedaConsignacion() {
		return this.cargarid_monedaConsignacion;
	}

	public void setCargarid_monedaConsignacion(Boolean cargarid_monedaConsignacion) {
		this.cargarid_monedaConsignacion= cargarid_monedaConsignacion;
	}

	public Border setResaltarcotizacionConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consignacionBeanSwingJInternalFrame.jTtoolBarConsignacion.setBorder(borderResaltar);
		
		this.resaltarcotizacionConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcotizacionConsignacion() {
		return this.resaltarcotizacionConsignacion;
	}

	public void setResaltarcotizacionConsignacion(Border borderResaltar) {
		this.resaltarcotizacionConsignacion= borderResaltar;
	}

	public Boolean getMostrarcotizacionConsignacion() {
		return this.mostrarcotizacionConsignacion;
	}

	public void setMostrarcotizacionConsignacion(Boolean mostrarcotizacionConsignacion) {
		this.mostrarcotizacionConsignacion= mostrarcotizacionConsignacion;
	}

	public Boolean getActivarcotizacionConsignacion() {
		return this.activarcotizacionConsignacion;
	}

	public void setActivarcotizacionConsignacion(Boolean activarcotizacionConsignacion) {
		this.activarcotizacionConsignacion= activarcotizacionConsignacion;
	}

	public Border setResaltarid_empleadoConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consignacionBeanSwingJInternalFrame.jTtoolBarConsignacion.setBorder(borderResaltar);
		
		this.resaltarid_empleadoConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoConsignacion() {
		return this.resaltarid_empleadoConsignacion;
	}

	public void setResaltarid_empleadoConsignacion(Border borderResaltar) {
		this.resaltarid_empleadoConsignacion= borderResaltar;
	}

	public Boolean getMostrarid_empleadoConsignacion() {
		return this.mostrarid_empleadoConsignacion;
	}

	public void setMostrarid_empleadoConsignacion(Boolean mostrarid_empleadoConsignacion) {
		this.mostrarid_empleadoConsignacion= mostrarid_empleadoConsignacion;
	}

	public Boolean getActivarid_empleadoConsignacion() {
		return this.activarid_empleadoConsignacion;
	}

	public void setActivarid_empleadoConsignacion(Boolean activarid_empleadoConsignacion) {
		this.activarid_empleadoConsignacion= activarid_empleadoConsignacion;
	}

	public Boolean getCargarid_empleadoConsignacion() {
		return this.cargarid_empleadoConsignacion;
	}

	public void setCargarid_empleadoConsignacion(Boolean cargarid_empleadoConsignacion) {
		this.cargarid_empleadoConsignacion= cargarid_empleadoConsignacion;
	}

	public Border setResaltarid_tipo_precioConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consignacionBeanSwingJInternalFrame.jTtoolBarConsignacion.setBorder(borderResaltar);
		
		this.resaltarid_tipo_precioConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_precioConsignacion() {
		return this.resaltarid_tipo_precioConsignacion;
	}

	public void setResaltarid_tipo_precioConsignacion(Border borderResaltar) {
		this.resaltarid_tipo_precioConsignacion= borderResaltar;
	}

	public Boolean getMostrarid_tipo_precioConsignacion() {
		return this.mostrarid_tipo_precioConsignacion;
	}

	public void setMostrarid_tipo_precioConsignacion(Boolean mostrarid_tipo_precioConsignacion) {
		this.mostrarid_tipo_precioConsignacion= mostrarid_tipo_precioConsignacion;
	}

	public Boolean getActivarid_tipo_precioConsignacion() {
		return this.activarid_tipo_precioConsignacion;
	}

	public void setActivarid_tipo_precioConsignacion(Boolean activarid_tipo_precioConsignacion) {
		this.activarid_tipo_precioConsignacion= activarid_tipo_precioConsignacion;
	}

	public Boolean getCargarid_tipo_precioConsignacion() {
		return this.cargarid_tipo_precioConsignacion;
	}

	public void setCargarid_tipo_precioConsignacion(Boolean cargarid_tipo_precioConsignacion) {
		this.cargarid_tipo_precioConsignacion= cargarid_tipo_precioConsignacion;
	}

	public Border setResaltarid_formatoConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consignacionBeanSwingJInternalFrame.jTtoolBarConsignacion.setBorder(borderResaltar);
		
		this.resaltarid_formatoConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formatoConsignacion() {
		return this.resaltarid_formatoConsignacion;
	}

	public void setResaltarid_formatoConsignacion(Border borderResaltar) {
		this.resaltarid_formatoConsignacion= borderResaltar;
	}

	public Boolean getMostrarid_formatoConsignacion() {
		return this.mostrarid_formatoConsignacion;
	}

	public void setMostrarid_formatoConsignacion(Boolean mostrarid_formatoConsignacion) {
		this.mostrarid_formatoConsignacion= mostrarid_formatoConsignacion;
	}

	public Boolean getActivarid_formatoConsignacion() {
		return this.activarid_formatoConsignacion;
	}

	public void setActivarid_formatoConsignacion(Boolean activarid_formatoConsignacion) {
		this.activarid_formatoConsignacion= activarid_formatoConsignacion;
	}

	public Boolean getCargarid_formatoConsignacion() {
		return this.cargarid_formatoConsignacion;
	}

	public void setCargarid_formatoConsignacion(Boolean cargarid_formatoConsignacion) {
		this.cargarid_formatoConsignacion= cargarid_formatoConsignacion;
	}

	public Border setResaltardireccionConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consignacionBeanSwingJInternalFrame.jTtoolBarConsignacion.setBorder(borderResaltar);
		
		this.resaltardireccionConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardireccionConsignacion() {
		return this.resaltardireccionConsignacion;
	}

	public void setResaltardireccionConsignacion(Border borderResaltar) {
		this.resaltardireccionConsignacion= borderResaltar;
	}

	public Boolean getMostrardireccionConsignacion() {
		return this.mostrardireccionConsignacion;
	}

	public void setMostrardireccionConsignacion(Boolean mostrardireccionConsignacion) {
		this.mostrardireccionConsignacion= mostrardireccionConsignacion;
	}

	public Boolean getActivardireccionConsignacion() {
		return this.activardireccionConsignacion;
	}

	public void setActivardireccionConsignacion(Boolean activardireccionConsignacion) {
		this.activardireccionConsignacion= activardireccionConsignacion;
	}

	public Border setResaltarid_clienteConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consignacionBeanSwingJInternalFrame.jTtoolBarConsignacion.setBorder(borderResaltar);
		
		this.resaltarid_clienteConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteConsignacion() {
		return this.resaltarid_clienteConsignacion;
	}

	public void setResaltarid_clienteConsignacion(Border borderResaltar) {
		this.resaltarid_clienteConsignacion= borderResaltar;
	}

	public Boolean getMostrarid_clienteConsignacion() {
		return this.mostrarid_clienteConsignacion;
	}

	public void setMostrarid_clienteConsignacion(Boolean mostrarid_clienteConsignacion) {
		this.mostrarid_clienteConsignacion= mostrarid_clienteConsignacion;
	}

	public Boolean getActivarid_clienteConsignacion() {
		return this.activarid_clienteConsignacion;
	}

	public void setActivarid_clienteConsignacion(Boolean activarid_clienteConsignacion) {
		this.activarid_clienteConsignacion= activarid_clienteConsignacion;
	}

	public Boolean getCargarid_clienteConsignacion() {
		return this.cargarid_clienteConsignacion;
	}

	public void setCargarid_clienteConsignacion(Boolean cargarid_clienteConsignacion) {
		this.cargarid_clienteConsignacion= cargarid_clienteConsignacion;
	}

	public Border setResaltartelefonoConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consignacionBeanSwingJInternalFrame.jTtoolBarConsignacion.setBorder(borderResaltar);
		
		this.resaltartelefonoConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartelefonoConsignacion() {
		return this.resaltartelefonoConsignacion;
	}

	public void setResaltartelefonoConsignacion(Border borderResaltar) {
		this.resaltartelefonoConsignacion= borderResaltar;
	}

	public Boolean getMostrartelefonoConsignacion() {
		return this.mostrartelefonoConsignacion;
	}

	public void setMostrartelefonoConsignacion(Boolean mostrartelefonoConsignacion) {
		this.mostrartelefonoConsignacion= mostrartelefonoConsignacion;
	}

	public Boolean getActivartelefonoConsignacion() {
		return this.activartelefonoConsignacion;
	}

	public void setActivartelefonoConsignacion(Boolean activartelefonoConsignacion) {
		this.activartelefonoConsignacion= activartelefonoConsignacion;
	}

	public Border setResaltarrucConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consignacionBeanSwingJInternalFrame.jTtoolBarConsignacion.setBorder(borderResaltar);
		
		this.resaltarrucConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarrucConsignacion() {
		return this.resaltarrucConsignacion;
	}

	public void setResaltarrucConsignacion(Border borderResaltar) {
		this.resaltarrucConsignacion= borderResaltar;
	}

	public Boolean getMostrarrucConsignacion() {
		return this.mostrarrucConsignacion;
	}

	public void setMostrarrucConsignacion(Boolean mostrarrucConsignacion) {
		this.mostrarrucConsignacion= mostrarrucConsignacion;
	}

	public Boolean getActivarrucConsignacion() {
		return this.activarrucConsignacion;
	}

	public void setActivarrucConsignacion(Boolean activarrucConsignacion) {
		this.activarrucConsignacion= activarrucConsignacion;
	}

	public Border setResaltarid_sub_clienteConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consignacionBeanSwingJInternalFrame.jTtoolBarConsignacion.setBorder(borderResaltar);
		
		this.resaltarid_sub_clienteConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sub_clienteConsignacion() {
		return this.resaltarid_sub_clienteConsignacion;
	}

	public void setResaltarid_sub_clienteConsignacion(Border borderResaltar) {
		this.resaltarid_sub_clienteConsignacion= borderResaltar;
	}

	public Boolean getMostrarid_sub_clienteConsignacion() {
		return this.mostrarid_sub_clienteConsignacion;
	}

	public void setMostrarid_sub_clienteConsignacion(Boolean mostrarid_sub_clienteConsignacion) {
		this.mostrarid_sub_clienteConsignacion= mostrarid_sub_clienteConsignacion;
	}

	public Boolean getActivarid_sub_clienteConsignacion() {
		return this.activarid_sub_clienteConsignacion;
	}

	public void setActivarid_sub_clienteConsignacion(Boolean activarid_sub_clienteConsignacion) {
		this.activarid_sub_clienteConsignacion= activarid_sub_clienteConsignacion;
	}

	public Boolean getCargarid_sub_clienteConsignacion() {
		return this.cargarid_sub_clienteConsignacion;
	}

	public void setCargarid_sub_clienteConsignacion(Boolean cargarid_sub_clienteConsignacion) {
		this.cargarid_sub_clienteConsignacion= cargarid_sub_clienteConsignacion;
	}

	public Border setResaltarid_consignatarioConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consignacionBeanSwingJInternalFrame.jTtoolBarConsignacion.setBorder(borderResaltar);
		
		this.resaltarid_consignatarioConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_consignatarioConsignacion() {
		return this.resaltarid_consignatarioConsignacion;
	}

	public void setResaltarid_consignatarioConsignacion(Border borderResaltar) {
		this.resaltarid_consignatarioConsignacion= borderResaltar;
	}

	public Boolean getMostrarid_consignatarioConsignacion() {
		return this.mostrarid_consignatarioConsignacion;
	}

	public void setMostrarid_consignatarioConsignacion(Boolean mostrarid_consignatarioConsignacion) {
		this.mostrarid_consignatarioConsignacion= mostrarid_consignatarioConsignacion;
	}

	public Boolean getActivarid_consignatarioConsignacion() {
		return this.activarid_consignatarioConsignacion;
	}

	public void setActivarid_consignatarioConsignacion(Boolean activarid_consignatarioConsignacion) {
		this.activarid_consignatarioConsignacion= activarid_consignatarioConsignacion;
	}

	public Boolean getCargarid_consignatarioConsignacion() {
		return this.cargarid_consignatarioConsignacion;
	}

	public void setCargarid_consignatarioConsignacion(Boolean cargarid_consignatarioConsignacion) {
		this.cargarid_consignatarioConsignacion= cargarid_consignatarioConsignacion;
	}

	public Border setResaltarid_vendedorConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consignacionBeanSwingJInternalFrame.jTtoolBarConsignacion.setBorder(borderResaltar);
		
		this.resaltarid_vendedorConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_vendedorConsignacion() {
		return this.resaltarid_vendedorConsignacion;
	}

	public void setResaltarid_vendedorConsignacion(Border borderResaltar) {
		this.resaltarid_vendedorConsignacion= borderResaltar;
	}

	public Boolean getMostrarid_vendedorConsignacion() {
		return this.mostrarid_vendedorConsignacion;
	}

	public void setMostrarid_vendedorConsignacion(Boolean mostrarid_vendedorConsignacion) {
		this.mostrarid_vendedorConsignacion= mostrarid_vendedorConsignacion;
	}

	public Boolean getActivarid_vendedorConsignacion() {
		return this.activarid_vendedorConsignacion;
	}

	public void setActivarid_vendedorConsignacion(Boolean activarid_vendedorConsignacion) {
		this.activarid_vendedorConsignacion= activarid_vendedorConsignacion;
	}

	public Boolean getCargarid_vendedorConsignacion() {
		return this.cargarid_vendedorConsignacion;
	}

	public void setCargarid_vendedorConsignacion(Boolean cargarid_vendedorConsignacion) {
		this.cargarid_vendedorConsignacion= cargarid_vendedorConsignacion;
	}

	public Border setResaltardescripcionConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consignacionBeanSwingJInternalFrame.jTtoolBarConsignacion.setBorder(borderResaltar);
		
		this.resaltardescripcionConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionConsignacion() {
		return this.resaltardescripcionConsignacion;
	}

	public void setResaltardescripcionConsignacion(Border borderResaltar) {
		this.resaltardescripcionConsignacion= borderResaltar;
	}

	public Boolean getMostrardescripcionConsignacion() {
		return this.mostrardescripcionConsignacion;
	}

	public void setMostrardescripcionConsignacion(Boolean mostrardescripcionConsignacion) {
		this.mostrardescripcionConsignacion= mostrardescripcionConsignacion;
	}

	public Boolean getActivardescripcionConsignacion() {
		return this.activardescripcionConsignacion;
	}

	public void setActivardescripcionConsignacion(Boolean activardescripcionConsignacion) {
		this.activardescripcionConsignacion= activardescripcionConsignacion;
	}

	public Border setResaltarid_estado_pedidoConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consignacionBeanSwingJInternalFrame.jTtoolBarConsignacion.setBorder(borderResaltar);
		
		this.resaltarid_estado_pedidoConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_pedidoConsignacion() {
		return this.resaltarid_estado_pedidoConsignacion;
	}

	public void setResaltarid_estado_pedidoConsignacion(Border borderResaltar) {
		this.resaltarid_estado_pedidoConsignacion= borderResaltar;
	}

	public Boolean getMostrarid_estado_pedidoConsignacion() {
		return this.mostrarid_estado_pedidoConsignacion;
	}

	public void setMostrarid_estado_pedidoConsignacion(Boolean mostrarid_estado_pedidoConsignacion) {
		this.mostrarid_estado_pedidoConsignacion= mostrarid_estado_pedidoConsignacion;
	}

	public Boolean getActivarid_estado_pedidoConsignacion() {
		return this.activarid_estado_pedidoConsignacion;
	}

	public void setActivarid_estado_pedidoConsignacion(Boolean activarid_estado_pedidoConsignacion) {
		this.activarid_estado_pedidoConsignacion= activarid_estado_pedidoConsignacion;
	}

	public Boolean getCargarid_estado_pedidoConsignacion() {
		return this.cargarid_estado_pedidoConsignacion;
	}

	public void setCargarid_estado_pedidoConsignacion(Boolean cargarid_estado_pedidoConsignacion) {
		this.cargarid_estado_pedidoConsignacion= cargarid_estado_pedidoConsignacion;
	}

	public Border setResaltardescuento_porcentajeConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consignacionBeanSwingJInternalFrame.jTtoolBarConsignacion.setBorder(borderResaltar);
		
		this.resaltardescuento_porcentajeConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuento_porcentajeConsignacion() {
		return this.resaltardescuento_porcentajeConsignacion;
	}

	public void setResaltardescuento_porcentajeConsignacion(Border borderResaltar) {
		this.resaltardescuento_porcentajeConsignacion= borderResaltar;
	}

	public Boolean getMostrardescuento_porcentajeConsignacion() {
		return this.mostrardescuento_porcentajeConsignacion;
	}

	public void setMostrardescuento_porcentajeConsignacion(Boolean mostrardescuento_porcentajeConsignacion) {
		this.mostrardescuento_porcentajeConsignacion= mostrardescuento_porcentajeConsignacion;
	}

	public Boolean getActivardescuento_porcentajeConsignacion() {
		return this.activardescuento_porcentajeConsignacion;
	}

	public void setActivardescuento_porcentajeConsignacion(Boolean activardescuento_porcentajeConsignacion) {
		this.activardescuento_porcentajeConsignacion= activardescuento_porcentajeConsignacion;
	}

	public Border setResaltartotal_con_ivaConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consignacionBeanSwingJInternalFrame.jTtoolBarConsignacion.setBorder(borderResaltar);
		
		this.resaltartotal_con_ivaConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_con_ivaConsignacion() {
		return this.resaltartotal_con_ivaConsignacion;
	}

	public void setResaltartotal_con_ivaConsignacion(Border borderResaltar) {
		this.resaltartotal_con_ivaConsignacion= borderResaltar;
	}

	public Boolean getMostrartotal_con_ivaConsignacion() {
		return this.mostrartotal_con_ivaConsignacion;
	}

	public void setMostrartotal_con_ivaConsignacion(Boolean mostrartotal_con_ivaConsignacion) {
		this.mostrartotal_con_ivaConsignacion= mostrartotal_con_ivaConsignacion;
	}

	public Boolean getActivartotal_con_ivaConsignacion() {
		return this.activartotal_con_ivaConsignacion;
	}

	public void setActivartotal_con_ivaConsignacion(Boolean activartotal_con_ivaConsignacion) {
		this.activartotal_con_ivaConsignacion= activartotal_con_ivaConsignacion;
	}

	public Border setResaltarsumanConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consignacionBeanSwingJInternalFrame.jTtoolBarConsignacion.setBorder(borderResaltar);
		
		this.resaltarsumanConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsumanConsignacion() {
		return this.resaltarsumanConsignacion;
	}

	public void setResaltarsumanConsignacion(Border borderResaltar) {
		this.resaltarsumanConsignacion= borderResaltar;
	}

	public Boolean getMostrarsumanConsignacion() {
		return this.mostrarsumanConsignacion;
	}

	public void setMostrarsumanConsignacion(Boolean mostrarsumanConsignacion) {
		this.mostrarsumanConsignacion= mostrarsumanConsignacion;
	}

	public Boolean getActivarsumanConsignacion() {
		return this.activarsumanConsignacion;
	}

	public void setActivarsumanConsignacion(Boolean activarsumanConsignacion) {
		this.activarsumanConsignacion= activarsumanConsignacion;
	}

	public Border setResaltardescuento_valorConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consignacionBeanSwingJInternalFrame.jTtoolBarConsignacion.setBorder(borderResaltar);
		
		this.resaltardescuento_valorConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuento_valorConsignacion() {
		return this.resaltardescuento_valorConsignacion;
	}

	public void setResaltardescuento_valorConsignacion(Border borderResaltar) {
		this.resaltardescuento_valorConsignacion= borderResaltar;
	}

	public Boolean getMostrardescuento_valorConsignacion() {
		return this.mostrardescuento_valorConsignacion;
	}

	public void setMostrardescuento_valorConsignacion(Boolean mostrardescuento_valorConsignacion) {
		this.mostrardescuento_valorConsignacion= mostrardescuento_valorConsignacion;
	}

	public Boolean getActivardescuento_valorConsignacion() {
		return this.activardescuento_valorConsignacion;
	}

	public void setActivardescuento_valorConsignacion(Boolean activardescuento_valorConsignacion) {
		this.activardescuento_valorConsignacion= activardescuento_valorConsignacion;
	}

	public Border setResaltartotal_sin_ivaConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consignacionBeanSwingJInternalFrame.jTtoolBarConsignacion.setBorder(borderResaltar);
		
		this.resaltartotal_sin_ivaConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_sin_ivaConsignacion() {
		return this.resaltartotal_sin_ivaConsignacion;
	}

	public void setResaltartotal_sin_ivaConsignacion(Border borderResaltar) {
		this.resaltartotal_sin_ivaConsignacion= borderResaltar;
	}

	public Boolean getMostrartotal_sin_ivaConsignacion() {
		return this.mostrartotal_sin_ivaConsignacion;
	}

	public void setMostrartotal_sin_ivaConsignacion(Boolean mostrartotal_sin_ivaConsignacion) {
		this.mostrartotal_sin_ivaConsignacion= mostrartotal_sin_ivaConsignacion;
	}

	public Boolean getActivartotal_sin_ivaConsignacion() {
		return this.activartotal_sin_ivaConsignacion;
	}

	public void setActivartotal_sin_ivaConsignacion(Boolean activartotal_sin_ivaConsignacion) {
		this.activartotal_sin_ivaConsignacion= activartotal_sin_ivaConsignacion;
	}

	public Border setResaltartotal_descuentoConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consignacionBeanSwingJInternalFrame.jTtoolBarConsignacion.setBorder(borderResaltar);
		
		this.resaltartotal_descuentoConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_descuentoConsignacion() {
		return this.resaltartotal_descuentoConsignacion;
	}

	public void setResaltartotal_descuentoConsignacion(Border borderResaltar) {
		this.resaltartotal_descuentoConsignacion= borderResaltar;
	}

	public Boolean getMostrartotal_descuentoConsignacion() {
		return this.mostrartotal_descuentoConsignacion;
	}

	public void setMostrartotal_descuentoConsignacion(Boolean mostrartotal_descuentoConsignacion) {
		this.mostrartotal_descuentoConsignacion= mostrartotal_descuentoConsignacion;
	}

	public Boolean getActivartotal_descuentoConsignacion() {
		return this.activartotal_descuentoConsignacion;
	}

	public void setActivartotal_descuentoConsignacion(Boolean activartotal_descuentoConsignacion) {
		this.activartotal_descuentoConsignacion= activartotal_descuentoConsignacion;
	}

	public Border setResaltarfleteConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consignacionBeanSwingJInternalFrame.jTtoolBarConsignacion.setBorder(borderResaltar);
		
		this.resaltarfleteConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfleteConsignacion() {
		return this.resaltarfleteConsignacion;
	}

	public void setResaltarfleteConsignacion(Border borderResaltar) {
		this.resaltarfleteConsignacion= borderResaltar;
	}

	public Boolean getMostrarfleteConsignacion() {
		return this.mostrarfleteConsignacion;
	}

	public void setMostrarfleteConsignacion(Boolean mostrarfleteConsignacion) {
		this.mostrarfleteConsignacion= mostrarfleteConsignacion;
	}

	public Boolean getActivarfleteConsignacion() {
		return this.activarfleteConsignacion;
	}

	public void setActivarfleteConsignacion(Boolean activarfleteConsignacion) {
		this.activarfleteConsignacion= activarfleteConsignacion;
	}

	public Border setResaltartotalConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consignacionBeanSwingJInternalFrame.jTtoolBarConsignacion.setBorder(borderResaltar);
		
		this.resaltartotalConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalConsignacion() {
		return this.resaltartotalConsignacion;
	}

	public void setResaltartotalConsignacion(Border borderResaltar) {
		this.resaltartotalConsignacion= borderResaltar;
	}

	public Boolean getMostrartotalConsignacion() {
		return this.mostrartotalConsignacion;
	}

	public void setMostrartotalConsignacion(Boolean mostrartotalConsignacion) {
		this.mostrartotalConsignacion= mostrartotalConsignacion;
	}

	public Boolean getActivartotalConsignacion() {
		return this.activartotalConsignacion;
	}

	public void setActivartotalConsignacion(Boolean activartotalConsignacion) {
		this.activartotalConsignacion= activartotalConsignacion;
	}

	public Border setResaltarsubtotalConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consignacionBeanSwingJInternalFrame.jTtoolBarConsignacion.setBorder(borderResaltar);
		
		this.resaltarsubtotalConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsubtotalConsignacion() {
		return this.resaltarsubtotalConsignacion;
	}

	public void setResaltarsubtotalConsignacion(Border borderResaltar) {
		this.resaltarsubtotalConsignacion= borderResaltar;
	}

	public Boolean getMostrarsubtotalConsignacion() {
		return this.mostrarsubtotalConsignacion;
	}

	public void setMostrarsubtotalConsignacion(Boolean mostrarsubtotalConsignacion) {
		this.mostrarsubtotalConsignacion= mostrarsubtotalConsignacion;
	}

	public Boolean getActivarsubtotalConsignacion() {
		return this.activarsubtotalConsignacion;
	}

	public void setActivarsubtotalConsignacion(Boolean activarsubtotalConsignacion) {
		this.activarsubtotalConsignacion= activarsubtotalConsignacion;
	}

	public Border setResaltarotroConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consignacionBeanSwingJInternalFrame.jTtoolBarConsignacion.setBorder(borderResaltar);
		
		this.resaltarotroConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarotroConsignacion() {
		return this.resaltarotroConsignacion;
	}

	public void setResaltarotroConsignacion(Border borderResaltar) {
		this.resaltarotroConsignacion= borderResaltar;
	}

	public Boolean getMostrarotroConsignacion() {
		return this.mostrarotroConsignacion;
	}

	public void setMostrarotroConsignacion(Boolean mostrarotroConsignacion) {
		this.mostrarotroConsignacion= mostrarotroConsignacion;
	}

	public Boolean getActivarotroConsignacion() {
		return this.activarotroConsignacion;
	}

	public void setActivarotroConsignacion(Boolean activarotroConsignacion) {
		this.activarotroConsignacion= activarotroConsignacion;
	}

	public Border setResaltarfinanciamientoConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consignacionBeanSwingJInternalFrame.jTtoolBarConsignacion.setBorder(borderResaltar);
		
		this.resaltarfinanciamientoConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfinanciamientoConsignacion() {
		return this.resaltarfinanciamientoConsignacion;
	}

	public void setResaltarfinanciamientoConsignacion(Border borderResaltar) {
		this.resaltarfinanciamientoConsignacion= borderResaltar;
	}

	public Boolean getMostrarfinanciamientoConsignacion() {
		return this.mostrarfinanciamientoConsignacion;
	}

	public void setMostrarfinanciamientoConsignacion(Boolean mostrarfinanciamientoConsignacion) {
		this.mostrarfinanciamientoConsignacion= mostrarfinanciamientoConsignacion;
	}

	public Boolean getActivarfinanciamientoConsignacion() {
		return this.activarfinanciamientoConsignacion;
	}

	public void setActivarfinanciamientoConsignacion(Boolean activarfinanciamientoConsignacion) {
		this.activarfinanciamientoConsignacion= activarfinanciamientoConsignacion;
	}

	public Border setResaltarivaConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consignacionBeanSwingJInternalFrame.jTtoolBarConsignacion.setBorder(borderResaltar);
		
		this.resaltarivaConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarivaConsignacion() {
		return this.resaltarivaConsignacion;
	}

	public void setResaltarivaConsignacion(Border borderResaltar) {
		this.resaltarivaConsignacion= borderResaltar;
	}

	public Boolean getMostrarivaConsignacion() {
		return this.mostrarivaConsignacion;
	}

	public void setMostrarivaConsignacion(Boolean mostrarivaConsignacion) {
		this.mostrarivaConsignacion= mostrarivaConsignacion;
	}

	public Boolean getActivarivaConsignacion() {
		return this.activarivaConsignacion;
	}

	public void setActivarivaConsignacion(Boolean activarivaConsignacion) {
		this.activarivaConsignacion= activarivaConsignacion;
	}

	public Border setResaltariceConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consignacionBeanSwingJInternalFrame.jTtoolBarConsignacion.setBorder(borderResaltar);
		
		this.resaltariceConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltariceConsignacion() {
		return this.resaltariceConsignacion;
	}

	public void setResaltariceConsignacion(Border borderResaltar) {
		this.resaltariceConsignacion= borderResaltar;
	}

	public Boolean getMostrariceConsignacion() {
		return this.mostrariceConsignacion;
	}

	public void setMostrariceConsignacion(Boolean mostrariceConsignacion) {
		this.mostrariceConsignacion= mostrariceConsignacion;
	}

	public Boolean getActivariceConsignacion() {
		return this.activariceConsignacion;
	}

	public void setActivariceConsignacion(Boolean activariceConsignacion) {
		this.activariceConsignacion= activariceConsignacion;
	}

	public Border setResaltarmonto_retencionConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consignacionBeanSwingJInternalFrame.jTtoolBarConsignacion.setBorder(borderResaltar);
		
		this.resaltarmonto_retencionConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmonto_retencionConsignacion() {
		return this.resaltarmonto_retencionConsignacion;
	}

	public void setResaltarmonto_retencionConsignacion(Border borderResaltar) {
		this.resaltarmonto_retencionConsignacion= borderResaltar;
	}

	public Boolean getMostrarmonto_retencionConsignacion() {
		return this.mostrarmonto_retencionConsignacion;
	}

	public void setMostrarmonto_retencionConsignacion(Boolean mostrarmonto_retencionConsignacion) {
		this.mostrarmonto_retencionConsignacion= mostrarmonto_retencionConsignacion;
	}

	public Boolean getActivarmonto_retencionConsignacion() {
		return this.activarmonto_retencionConsignacion;
	}

	public void setActivarmonto_retencionConsignacion(Boolean activarmonto_retencionConsignacion) {
		this.activarmonto_retencionConsignacion= activarmonto_retencionConsignacion;
	}

	public Border setResaltarid_tipo_cambioConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consignacionBeanSwingJInternalFrame.jTtoolBarConsignacion.setBorder(borderResaltar);
		
		this.resaltarid_tipo_cambioConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_cambioConsignacion() {
		return this.resaltarid_tipo_cambioConsignacion;
	}

	public void setResaltarid_tipo_cambioConsignacion(Border borderResaltar) {
		this.resaltarid_tipo_cambioConsignacion= borderResaltar;
	}

	public Boolean getMostrarid_tipo_cambioConsignacion() {
		return this.mostrarid_tipo_cambioConsignacion;
	}

	public void setMostrarid_tipo_cambioConsignacion(Boolean mostrarid_tipo_cambioConsignacion) {
		this.mostrarid_tipo_cambioConsignacion= mostrarid_tipo_cambioConsignacion;
	}

	public Boolean getActivarid_tipo_cambioConsignacion() {
		return this.activarid_tipo_cambioConsignacion;
	}

	public void setActivarid_tipo_cambioConsignacion(Boolean activarid_tipo_cambioConsignacion) {
		this.activarid_tipo_cambioConsignacion= activarid_tipo_cambioConsignacion;
	}

	public Boolean getCargarid_tipo_cambioConsignacion() {
		return this.cargarid_tipo_cambioConsignacion;
	}

	public void setCargarid_tipo_cambioConsignacion(Boolean cargarid_tipo_cambioConsignacion) {
		this.cargarid_tipo_cambioConsignacion= cargarid_tipo_cambioConsignacion;
	}

	public Border setResaltarnumero_fueConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consignacionBeanSwingJInternalFrame.jTtoolBarConsignacion.setBorder(borderResaltar);
		
		this.resaltarnumero_fueConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_fueConsignacion() {
		return this.resaltarnumero_fueConsignacion;
	}

	public void setResaltarnumero_fueConsignacion(Border borderResaltar) {
		this.resaltarnumero_fueConsignacion= borderResaltar;
	}

	public Boolean getMostrarnumero_fueConsignacion() {
		return this.mostrarnumero_fueConsignacion;
	}

	public void setMostrarnumero_fueConsignacion(Boolean mostrarnumero_fueConsignacion) {
		this.mostrarnumero_fueConsignacion= mostrarnumero_fueConsignacion;
	}

	public Boolean getActivarnumero_fueConsignacion() {
		return this.activarnumero_fueConsignacion;
	}

	public void setActivarnumero_fueConsignacion(Boolean activarnumero_fueConsignacion) {
		this.activarnumero_fueConsignacion= activarnumero_fueConsignacion;
	}

	public Border setResaltarid_zonaConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consignacionBeanSwingJInternalFrame.jTtoolBarConsignacion.setBorder(borderResaltar);
		
		this.resaltarid_zonaConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_zonaConsignacion() {
		return this.resaltarid_zonaConsignacion;
	}

	public void setResaltarid_zonaConsignacion(Border borderResaltar) {
		this.resaltarid_zonaConsignacion= borderResaltar;
	}

	public Boolean getMostrarid_zonaConsignacion() {
		return this.mostrarid_zonaConsignacion;
	}

	public void setMostrarid_zonaConsignacion(Boolean mostrarid_zonaConsignacion) {
		this.mostrarid_zonaConsignacion= mostrarid_zonaConsignacion;
	}

	public Boolean getActivarid_zonaConsignacion() {
		return this.activarid_zonaConsignacion;
	}

	public void setActivarid_zonaConsignacion(Boolean activarid_zonaConsignacion) {
		this.activarid_zonaConsignacion= activarid_zonaConsignacion;
	}

	public Boolean getCargarid_zonaConsignacion() {
		return this.cargarid_zonaConsignacion;
	}

	public void setCargarid_zonaConsignacion(Boolean cargarid_zonaConsignacion) {
		this.cargarid_zonaConsignacion= cargarid_zonaConsignacion;
	}

	public Border setResaltarfechaConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consignacionBeanSwingJInternalFrame.jTtoolBarConsignacion.setBorder(borderResaltar);
		
		this.resaltarfechaConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaConsignacion() {
		return this.resaltarfechaConsignacion;
	}

	public void setResaltarfechaConsignacion(Border borderResaltar) {
		this.resaltarfechaConsignacion= borderResaltar;
	}

	public Boolean getMostrarfechaConsignacion() {
		return this.mostrarfechaConsignacion;
	}

	public void setMostrarfechaConsignacion(Boolean mostrarfechaConsignacion) {
		this.mostrarfechaConsignacion= mostrarfechaConsignacion;
	}

	public Boolean getActivarfechaConsignacion() {
		return this.activarfechaConsignacion;
	}

	public void setActivarfechaConsignacion(Boolean activarfechaConsignacion) {
		this.activarfechaConsignacion= activarfechaConsignacion;
	}

	public Border setResaltarid_centro_costoConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consignacionBeanSwingJInternalFrame.jTtoolBarConsignacion.setBorder(borderResaltar);
		
		this.resaltarid_centro_costoConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_centro_costoConsignacion() {
		return this.resaltarid_centro_costoConsignacion;
	}

	public void setResaltarid_centro_costoConsignacion(Border borderResaltar) {
		this.resaltarid_centro_costoConsignacion= borderResaltar;
	}

	public Boolean getMostrarid_centro_costoConsignacion() {
		return this.mostrarid_centro_costoConsignacion;
	}

	public void setMostrarid_centro_costoConsignacion(Boolean mostrarid_centro_costoConsignacion) {
		this.mostrarid_centro_costoConsignacion= mostrarid_centro_costoConsignacion;
	}

	public Boolean getActivarid_centro_costoConsignacion() {
		return this.activarid_centro_costoConsignacion;
	}

	public void setActivarid_centro_costoConsignacion(Boolean activarid_centro_costoConsignacion) {
		this.activarid_centro_costoConsignacion= activarid_centro_costoConsignacion;
	}

	public Boolean getCargarid_centro_costoConsignacion() {
		return this.cargarid_centro_costoConsignacion;
	}

	public void setCargarid_centro_costoConsignacion(Boolean cargarid_centro_costoConsignacion) {
		this.cargarid_centro_costoConsignacion= cargarid_centro_costoConsignacion;
	}

	public Border setResaltarfecha_servidorConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consignacionBeanSwingJInternalFrame.jTtoolBarConsignacion.setBorder(borderResaltar);
		
		this.resaltarfecha_servidorConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_servidorConsignacion() {
		return this.resaltarfecha_servidorConsignacion;
	}

	public void setResaltarfecha_servidorConsignacion(Border borderResaltar) {
		this.resaltarfecha_servidorConsignacion= borderResaltar;
	}

	public Boolean getMostrarfecha_servidorConsignacion() {
		return this.mostrarfecha_servidorConsignacion;
	}

	public void setMostrarfecha_servidorConsignacion(Boolean mostrarfecha_servidorConsignacion) {
		this.mostrarfecha_servidorConsignacion= mostrarfecha_servidorConsignacion;
	}

	public Boolean getActivarfecha_servidorConsignacion() {
		return this.activarfecha_servidorConsignacion;
	}

	public void setActivarfecha_servidorConsignacion(Boolean activarfecha_servidorConsignacion) {
		this.activarfecha_servidorConsignacion= activarfecha_servidorConsignacion;
	}

	public Border setResaltarid_responsableConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consignacionBeanSwingJInternalFrame.jTtoolBarConsignacion.setBorder(borderResaltar);
		
		this.resaltarid_responsableConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_responsableConsignacion() {
		return this.resaltarid_responsableConsignacion;
	}

	public void setResaltarid_responsableConsignacion(Border borderResaltar) {
		this.resaltarid_responsableConsignacion= borderResaltar;
	}

	public Boolean getMostrarid_responsableConsignacion() {
		return this.mostrarid_responsableConsignacion;
	}

	public void setMostrarid_responsableConsignacion(Boolean mostrarid_responsableConsignacion) {
		this.mostrarid_responsableConsignacion= mostrarid_responsableConsignacion;
	}

	public Boolean getActivarid_responsableConsignacion() {
		return this.activarid_responsableConsignacion;
	}

	public void setActivarid_responsableConsignacion(Boolean activarid_responsableConsignacion) {
		this.activarid_responsableConsignacion= activarid_responsableConsignacion;
	}

	public Boolean getCargarid_responsableConsignacion() {
		return this.cargarid_responsableConsignacion;
	}

	public void setCargarid_responsableConsignacion(Boolean cargarid_responsableConsignacion) {
		this.cargarid_responsableConsignacion= cargarid_responsableConsignacion;
	}

	public Border setResaltarhora_inicioConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consignacionBeanSwingJInternalFrame.jTtoolBarConsignacion.setBorder(borderResaltar);
		
		this.resaltarhora_inicioConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhora_inicioConsignacion() {
		return this.resaltarhora_inicioConsignacion;
	}

	public void setResaltarhora_inicioConsignacion(Border borderResaltar) {
		this.resaltarhora_inicioConsignacion= borderResaltar;
	}

	public Boolean getMostrarhora_inicioConsignacion() {
		return this.mostrarhora_inicioConsignacion;
	}

	public void setMostrarhora_inicioConsignacion(Boolean mostrarhora_inicioConsignacion) {
		this.mostrarhora_inicioConsignacion= mostrarhora_inicioConsignacion;
	}

	public Boolean getActivarhora_inicioConsignacion() {
		return this.activarhora_inicioConsignacion;
	}

	public void setActivarhora_inicioConsignacion(Boolean activarhora_inicioConsignacion) {
		this.activarhora_inicioConsignacion= activarhora_inicioConsignacion;
	}

	public Border setResaltarhora_finConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consignacionBeanSwingJInternalFrame.jTtoolBarConsignacion.setBorder(borderResaltar);
		
		this.resaltarhora_finConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhora_finConsignacion() {
		return this.resaltarhora_finConsignacion;
	}

	public void setResaltarhora_finConsignacion(Border borderResaltar) {
		this.resaltarhora_finConsignacion= borderResaltar;
	}

	public Boolean getMostrarhora_finConsignacion() {
		return this.mostrarhora_finConsignacion;
	}

	public void setMostrarhora_finConsignacion(Boolean mostrarhora_finConsignacion) {
		this.mostrarhora_finConsignacion= mostrarhora_finConsignacion;
	}

	public Boolean getActivarhora_finConsignacion() {
		return this.activarhora_finConsignacion;
	}

	public void setActivarhora_finConsignacion(Boolean activarhora_finConsignacion) {
		this.activarhora_finConsignacion= activarhora_finConsignacion;
	}

	public Border setResaltarid_transportistaConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consignacionBeanSwingJInternalFrame.jTtoolBarConsignacion.setBorder(borderResaltar);
		
		this.resaltarid_transportistaConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transportistaConsignacion() {
		return this.resaltarid_transportistaConsignacion;
	}

	public void setResaltarid_transportistaConsignacion(Border borderResaltar) {
		this.resaltarid_transportistaConsignacion= borderResaltar;
	}

	public Boolean getMostrarid_transportistaConsignacion() {
		return this.mostrarid_transportistaConsignacion;
	}

	public void setMostrarid_transportistaConsignacion(Boolean mostrarid_transportistaConsignacion) {
		this.mostrarid_transportistaConsignacion= mostrarid_transportistaConsignacion;
	}

	public Boolean getActivarid_transportistaConsignacion() {
		return this.activarid_transportistaConsignacion;
	}

	public void setActivarid_transportistaConsignacion(Boolean activarid_transportistaConsignacion) {
		this.activarid_transportistaConsignacion= activarid_transportistaConsignacion;
	}

	public Boolean getCargarid_transportistaConsignacion() {
		return this.cargarid_transportistaConsignacion;
	}

	public void setCargarid_transportistaConsignacion(Boolean cargarid_transportistaConsignacion) {
		this.cargarid_transportistaConsignacion= cargarid_transportistaConsignacion;
	}

	public Border setResaltarid_transporteConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consignacionBeanSwingJInternalFrame.jTtoolBarConsignacion.setBorder(borderResaltar);
		
		this.resaltarid_transporteConsignacion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transporteConsignacion() {
		return this.resaltarid_transporteConsignacion;
	}

	public void setResaltarid_transporteConsignacion(Border borderResaltar) {
		this.resaltarid_transporteConsignacion= borderResaltar;
	}

	public Boolean getMostrarid_transporteConsignacion() {
		return this.mostrarid_transporteConsignacion;
	}

	public void setMostrarid_transporteConsignacion(Boolean mostrarid_transporteConsignacion) {
		this.mostrarid_transporteConsignacion= mostrarid_transporteConsignacion;
	}

	public Boolean getActivarid_transporteConsignacion() {
		return this.activarid_transporteConsignacion;
	}

	public void setActivarid_transporteConsignacion(Boolean activarid_transporteConsignacion) {
		this.activarid_transporteConsignacion= activarid_transporteConsignacion;
	}

	public Boolean getCargarid_transporteConsignacion() {
		return this.cargarid_transporteConsignacion;
	}

	public void setCargarid_transporteConsignacion(Boolean cargarid_transporteConsignacion) {
		this.cargarid_transporteConsignacion= cargarid_transporteConsignacion;
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
		
		
		this.setMostraridConsignacion(esInicial);
		this.setMostrarid_empresaConsignacion(esInicial);
		this.setMostrarid_sucursalConsignacion(esInicial);
		this.setMostrarid_ejercicioConsignacion(esInicial);
		this.setMostrarid_periodoConsignacion(esInicial);
		this.setMostrarid_anioConsignacion(esInicial);
		this.setMostrarid_mesConsignacion(esInicial);
		this.setMostrarid_usuarioConsignacion(esInicial);
		this.setMostrarnumeroConsignacion(esInicial);
		this.setMostrarnumero_autorizacionConsignacion(esInicial);
		this.setMostrarfecha_emisionConsignacion(esInicial);
		this.setMostrarfecha_vencimientoConsignacion(esInicial);
		this.setMostrarid_monedaConsignacion(esInicial);
		this.setMostrarcotizacionConsignacion(esInicial);
		this.setMostrarid_empleadoConsignacion(esInicial);
		this.setMostrarid_tipo_precioConsignacion(esInicial);
		this.setMostrarid_formatoConsignacion(esInicial);
		this.setMostrardireccionConsignacion(esInicial);
		this.setMostrarid_clienteConsignacion(esInicial);
		this.setMostrartelefonoConsignacion(esInicial);
		this.setMostrarrucConsignacion(esInicial);
		this.setMostrarid_sub_clienteConsignacion(esInicial);
		this.setMostrarid_consignatarioConsignacion(esInicial);
		this.setMostrarid_vendedorConsignacion(esInicial);
		this.setMostrardescripcionConsignacion(esInicial);
		this.setMostrarid_estado_pedidoConsignacion(esInicial);
		this.setMostrardescuento_porcentajeConsignacion(esInicial);
		this.setMostrartotal_con_ivaConsignacion(esInicial);
		this.setMostrarsumanConsignacion(esInicial);
		this.setMostrardescuento_valorConsignacion(esInicial);
		this.setMostrartotal_sin_ivaConsignacion(esInicial);
		this.setMostrartotal_descuentoConsignacion(esInicial);
		this.setMostrarfleteConsignacion(esInicial);
		this.setMostrartotalConsignacion(esInicial);
		this.setMostrarsubtotalConsignacion(esInicial);
		this.setMostrarotroConsignacion(esInicial);
		this.setMostrarfinanciamientoConsignacion(esInicial);
		this.setMostrarivaConsignacion(esInicial);
		this.setMostrariceConsignacion(esInicial);
		this.setMostrarmonto_retencionConsignacion(esInicial);
		this.setMostrarid_tipo_cambioConsignacion(esInicial);
		this.setMostrarnumero_fueConsignacion(esInicial);
		this.setMostrarid_zonaConsignacion(esInicial);
		this.setMostrarfechaConsignacion(esInicial);
		this.setMostrarid_centro_costoConsignacion(esInicial);
		this.setMostrarfecha_servidorConsignacion(esInicial);
		this.setMostrarid_responsableConsignacion(esInicial);
		this.setMostrarhora_inicioConsignacion(esInicial);
		this.setMostrarhora_finConsignacion(esInicial);
		this.setMostrarid_transportistaConsignacion(esInicial);
		this.setMostrarid_transporteConsignacion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ConsignacionConstantesFunciones.ID)) {
				this.setMostraridConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.IDMES)) {
				this.setMostrarid_mesConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.IDUSUARIO)) {
				this.setMostrarid_usuarioConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.NUMERO)) {
				this.setMostrarnumeroConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.NUMEROAUTORIZACION)) {
				this.setMostrarnumero_autorizacionConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setMostrarfecha_vencimientoConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.IDMONEDA)) {
				this.setMostrarid_monedaConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.COTIZACION)) {
				this.setMostrarcotizacionConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.IDTIPOPRECIO)) {
				this.setMostrarid_tipo_precioConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.IDFORMATO)) {
				this.setMostrarid_formatoConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.DIRECCION)) {
				this.setMostrardireccionConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.TELEFONO)) {
				this.setMostrartelefonoConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.RUC)) {
				this.setMostrarrucConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.IDSUBCLIENTE)) {
				this.setMostrarid_sub_clienteConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.IDCONSIGNATARIO)) {
				this.setMostrarid_consignatarioConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.IDVENDEDOR)) {
				this.setMostrarid_vendedorConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.IDESTADOPEDIDO)) {
				this.setMostrarid_estado_pedidoConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.DESCUENTOPORCENTAJE)) {
				this.setMostrardescuento_porcentajeConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.TOTALCONIVA)) {
				this.setMostrartotal_con_ivaConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.SUMAN)) {
				this.setMostrarsumanConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.DESCUENTOVALOR)) {
				this.setMostrardescuento_valorConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.TOTALSINIVA)) {
				this.setMostrartotal_sin_ivaConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.TOTALDESCUENTO)) {
				this.setMostrartotal_descuentoConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.FLETE)) {
				this.setMostrarfleteConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.TOTAL)) {
				this.setMostrartotalConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.SUBTOTAL)) {
				this.setMostrarsubtotalConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.OTRO)) {
				this.setMostrarotroConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.FINANCIAMIENTO)) {
				this.setMostrarfinanciamientoConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.IVA)) {
				this.setMostrarivaConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.ICE)) {
				this.setMostrariceConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.MONTORETENCION)) {
				this.setMostrarmonto_retencionConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.IDTIPOCAMBIO)) {
				this.setMostrarid_tipo_cambioConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.NUMEROFUE)) {
				this.setMostrarnumero_fueConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.IDZONA)) {
				this.setMostrarid_zonaConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.FECHA)) {
				this.setMostrarfechaConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.IDCENTROCOSTO)) {
				this.setMostrarid_centro_costoConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.FECHASERVIDOR)) {
				this.setMostrarfecha_servidorConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.IDRESPONSABLE)) {
				this.setMostrarid_responsableConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.HORAINICIO)) {
				this.setMostrarhora_inicioConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.HORAFIN)) {
				this.setMostrarhora_finConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.IDTRANSPORTISTA)) {
				this.setMostrarid_transportistaConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.IDTRANSPORTE)) {
				this.setMostrarid_transporteConsignacion(esAsigna);
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
		
		
		this.setActivaridConsignacion(esInicial);
		this.setActivarid_empresaConsignacion(esInicial);
		this.setActivarid_sucursalConsignacion(esInicial);
		this.setActivarid_ejercicioConsignacion(esInicial);
		this.setActivarid_periodoConsignacion(esInicial);
		this.setActivarid_anioConsignacion(esInicial);
		this.setActivarid_mesConsignacion(esInicial);
		this.setActivarid_usuarioConsignacion(esInicial);
		this.setActivarnumeroConsignacion(esInicial);
		this.setActivarnumero_autorizacionConsignacion(esInicial);
		this.setActivarfecha_emisionConsignacion(esInicial);
		this.setActivarfecha_vencimientoConsignacion(esInicial);
		this.setActivarid_monedaConsignacion(esInicial);
		this.setActivarcotizacionConsignacion(esInicial);
		this.setActivarid_empleadoConsignacion(esInicial);
		this.setActivarid_tipo_precioConsignacion(esInicial);
		this.setActivarid_formatoConsignacion(esInicial);
		this.setActivardireccionConsignacion(esInicial);
		this.setActivarid_clienteConsignacion(esInicial);
		this.setActivartelefonoConsignacion(esInicial);
		this.setActivarrucConsignacion(esInicial);
		this.setActivarid_sub_clienteConsignacion(esInicial);
		this.setActivarid_consignatarioConsignacion(esInicial);
		this.setActivarid_vendedorConsignacion(esInicial);
		this.setActivardescripcionConsignacion(esInicial);
		this.setActivarid_estado_pedidoConsignacion(esInicial);
		this.setActivardescuento_porcentajeConsignacion(esInicial);
		this.setActivartotal_con_ivaConsignacion(esInicial);
		this.setActivarsumanConsignacion(esInicial);
		this.setActivardescuento_valorConsignacion(esInicial);
		this.setActivartotal_sin_ivaConsignacion(esInicial);
		this.setActivartotal_descuentoConsignacion(esInicial);
		this.setActivarfleteConsignacion(esInicial);
		this.setActivartotalConsignacion(esInicial);
		this.setActivarsubtotalConsignacion(esInicial);
		this.setActivarotroConsignacion(esInicial);
		this.setActivarfinanciamientoConsignacion(esInicial);
		this.setActivarivaConsignacion(esInicial);
		this.setActivariceConsignacion(esInicial);
		this.setActivarmonto_retencionConsignacion(esInicial);
		this.setActivarid_tipo_cambioConsignacion(esInicial);
		this.setActivarnumero_fueConsignacion(esInicial);
		this.setActivarid_zonaConsignacion(esInicial);
		this.setActivarfechaConsignacion(esInicial);
		this.setActivarid_centro_costoConsignacion(esInicial);
		this.setActivarfecha_servidorConsignacion(esInicial);
		this.setActivarid_responsableConsignacion(esInicial);
		this.setActivarhora_inicioConsignacion(esInicial);
		this.setActivarhora_finConsignacion(esInicial);
		this.setActivarid_transportistaConsignacion(esInicial);
		this.setActivarid_transporteConsignacion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ConsignacionConstantesFunciones.ID)) {
				this.setActivaridConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.IDANIO)) {
				this.setActivarid_anioConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.IDMES)) {
				this.setActivarid_mesConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.IDUSUARIO)) {
				this.setActivarid_usuarioConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.NUMERO)) {
				this.setActivarnumeroConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.NUMEROAUTORIZACION)) {
				this.setActivarnumero_autorizacionConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setActivarfecha_vencimientoConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.IDMONEDA)) {
				this.setActivarid_monedaConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.COTIZACION)) {
				this.setActivarcotizacionConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.IDTIPOPRECIO)) {
				this.setActivarid_tipo_precioConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.IDFORMATO)) {
				this.setActivarid_formatoConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.DIRECCION)) {
				this.setActivardireccionConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.TELEFONO)) {
				this.setActivartelefonoConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.RUC)) {
				this.setActivarrucConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.IDSUBCLIENTE)) {
				this.setActivarid_sub_clienteConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.IDCONSIGNATARIO)) {
				this.setActivarid_consignatarioConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.IDVENDEDOR)) {
				this.setActivarid_vendedorConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.IDESTADOPEDIDO)) {
				this.setActivarid_estado_pedidoConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.DESCUENTOPORCENTAJE)) {
				this.setActivardescuento_porcentajeConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.TOTALCONIVA)) {
				this.setActivartotal_con_ivaConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.SUMAN)) {
				this.setActivarsumanConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.DESCUENTOVALOR)) {
				this.setActivardescuento_valorConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.TOTALSINIVA)) {
				this.setActivartotal_sin_ivaConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.TOTALDESCUENTO)) {
				this.setActivartotal_descuentoConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.FLETE)) {
				this.setActivarfleteConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.TOTAL)) {
				this.setActivartotalConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.SUBTOTAL)) {
				this.setActivarsubtotalConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.OTRO)) {
				this.setActivarotroConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.FINANCIAMIENTO)) {
				this.setActivarfinanciamientoConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.IVA)) {
				this.setActivarivaConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.ICE)) {
				this.setActivariceConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.MONTORETENCION)) {
				this.setActivarmonto_retencionConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.IDTIPOCAMBIO)) {
				this.setActivarid_tipo_cambioConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.NUMEROFUE)) {
				this.setActivarnumero_fueConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.IDZONA)) {
				this.setActivarid_zonaConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.FECHA)) {
				this.setActivarfechaConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.IDCENTROCOSTO)) {
				this.setActivarid_centro_costoConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.FECHASERVIDOR)) {
				this.setActivarfecha_servidorConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.IDRESPONSABLE)) {
				this.setActivarid_responsableConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.HORAINICIO)) {
				this.setActivarhora_inicioConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.HORAFIN)) {
				this.setActivarhora_finConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.IDTRANSPORTISTA)) {
				this.setActivarid_transportistaConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.IDTRANSPORTE)) {
				this.setActivarid_transporteConsignacion(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridConsignacion(esInicial);
		this.setResaltarid_empresaConsignacion(esInicial);
		this.setResaltarid_sucursalConsignacion(esInicial);
		this.setResaltarid_ejercicioConsignacion(esInicial);
		this.setResaltarid_periodoConsignacion(esInicial);
		this.setResaltarid_anioConsignacion(esInicial);
		this.setResaltarid_mesConsignacion(esInicial);
		this.setResaltarid_usuarioConsignacion(esInicial);
		this.setResaltarnumeroConsignacion(esInicial);
		this.setResaltarnumero_autorizacionConsignacion(esInicial);
		this.setResaltarfecha_emisionConsignacion(esInicial);
		this.setResaltarfecha_vencimientoConsignacion(esInicial);
		this.setResaltarid_monedaConsignacion(esInicial);
		this.setResaltarcotizacionConsignacion(esInicial);
		this.setResaltarid_empleadoConsignacion(esInicial);
		this.setResaltarid_tipo_precioConsignacion(esInicial);
		this.setResaltarid_formatoConsignacion(esInicial);
		this.setResaltardireccionConsignacion(esInicial);
		this.setResaltarid_clienteConsignacion(esInicial);
		this.setResaltartelefonoConsignacion(esInicial);
		this.setResaltarrucConsignacion(esInicial);
		this.setResaltarid_sub_clienteConsignacion(esInicial);
		this.setResaltarid_consignatarioConsignacion(esInicial);
		this.setResaltarid_vendedorConsignacion(esInicial);
		this.setResaltardescripcionConsignacion(esInicial);
		this.setResaltarid_estado_pedidoConsignacion(esInicial);
		this.setResaltardescuento_porcentajeConsignacion(esInicial);
		this.setResaltartotal_con_ivaConsignacion(esInicial);
		this.setResaltarsumanConsignacion(esInicial);
		this.setResaltardescuento_valorConsignacion(esInicial);
		this.setResaltartotal_sin_ivaConsignacion(esInicial);
		this.setResaltartotal_descuentoConsignacion(esInicial);
		this.setResaltarfleteConsignacion(esInicial);
		this.setResaltartotalConsignacion(esInicial);
		this.setResaltarsubtotalConsignacion(esInicial);
		this.setResaltarotroConsignacion(esInicial);
		this.setResaltarfinanciamientoConsignacion(esInicial);
		this.setResaltarivaConsignacion(esInicial);
		this.setResaltariceConsignacion(esInicial);
		this.setResaltarmonto_retencionConsignacion(esInicial);
		this.setResaltarid_tipo_cambioConsignacion(esInicial);
		this.setResaltarnumero_fueConsignacion(esInicial);
		this.setResaltarid_zonaConsignacion(esInicial);
		this.setResaltarfechaConsignacion(esInicial);
		this.setResaltarid_centro_costoConsignacion(esInicial);
		this.setResaltarfecha_servidorConsignacion(esInicial);
		this.setResaltarid_responsableConsignacion(esInicial);
		this.setResaltarhora_inicioConsignacion(esInicial);
		this.setResaltarhora_finConsignacion(esInicial);
		this.setResaltarid_transportistaConsignacion(esInicial);
		this.setResaltarid_transporteConsignacion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ConsignacionConstantesFunciones.ID)) {
				this.setResaltaridConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.IDMES)) {
				this.setResaltarid_mesConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.IDUSUARIO)) {
				this.setResaltarid_usuarioConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.NUMERO)) {
				this.setResaltarnumeroConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.NUMEROAUTORIZACION)) {
				this.setResaltarnumero_autorizacionConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setResaltarfecha_vencimientoConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.IDMONEDA)) {
				this.setResaltarid_monedaConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.COTIZACION)) {
				this.setResaltarcotizacionConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.IDTIPOPRECIO)) {
				this.setResaltarid_tipo_precioConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.IDFORMATO)) {
				this.setResaltarid_formatoConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.DIRECCION)) {
				this.setResaltardireccionConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.TELEFONO)) {
				this.setResaltartelefonoConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.RUC)) {
				this.setResaltarrucConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.IDSUBCLIENTE)) {
				this.setResaltarid_sub_clienteConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.IDCONSIGNATARIO)) {
				this.setResaltarid_consignatarioConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.IDVENDEDOR)) {
				this.setResaltarid_vendedorConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.IDESTADOPEDIDO)) {
				this.setResaltarid_estado_pedidoConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.DESCUENTOPORCENTAJE)) {
				this.setResaltardescuento_porcentajeConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.TOTALCONIVA)) {
				this.setResaltartotal_con_ivaConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.SUMAN)) {
				this.setResaltarsumanConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.DESCUENTOVALOR)) {
				this.setResaltardescuento_valorConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.TOTALSINIVA)) {
				this.setResaltartotal_sin_ivaConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.TOTALDESCUENTO)) {
				this.setResaltartotal_descuentoConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.FLETE)) {
				this.setResaltarfleteConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.TOTAL)) {
				this.setResaltartotalConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.SUBTOTAL)) {
				this.setResaltarsubtotalConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.OTRO)) {
				this.setResaltarotroConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.FINANCIAMIENTO)) {
				this.setResaltarfinanciamientoConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.IVA)) {
				this.setResaltarivaConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.ICE)) {
				this.setResaltariceConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.MONTORETENCION)) {
				this.setResaltarmonto_retencionConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.IDTIPOCAMBIO)) {
				this.setResaltarid_tipo_cambioConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.NUMEROFUE)) {
				this.setResaltarnumero_fueConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.IDZONA)) {
				this.setResaltarid_zonaConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.FECHA)) {
				this.setResaltarfechaConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.IDCENTROCOSTO)) {
				this.setResaltarid_centro_costoConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.FECHASERVIDOR)) {
				this.setResaltarfecha_servidorConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.IDRESPONSABLE)) {
				this.setResaltarid_responsableConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.HORAINICIO)) {
				this.setResaltarhora_inicioConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.HORAFIN)) {
				this.setResaltarhora_finConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.IDTRANSPORTISTA)) {
				this.setResaltarid_transportistaConsignacion(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsignacionConstantesFunciones.IDTRANSPORTE)) {
				this.setResaltarid_transporteConsignacion(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDetalleConsignacionConsignacion=null;

	public Border getResaltarDetalleConsignacionConsignacion() {
		return this.resaltarDetalleConsignacionConsignacion;
	}

	public void setResaltarDetalleConsignacionConsignacion(Border borderResaltarDetalleConsignacion) {
		if(borderResaltarDetalleConsignacion!=null) {
			this.resaltarDetalleConsignacionConsignacion= borderResaltarDetalleConsignacion;
		}
	}

	public Border setResaltarDetalleConsignacionConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltarDetalleConsignacion=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//consignacionBeanSwingJInternalFrame.jTtoolBarConsignacion.setBorder(borderResaltarDetalleConsignacion);
			
		this.resaltarDetalleConsignacionConsignacion= borderResaltarDetalleConsignacion;

		 return borderResaltarDetalleConsignacion;
	}



	public Boolean mostrarDetalleConsignacionConsignacion=true;

	public Boolean getMostrarDetalleConsignacionConsignacion() {
		return this.mostrarDetalleConsignacionConsignacion;
	}

	public void setMostrarDetalleConsignacionConsignacion(Boolean visibilidadResaltarDetalleConsignacion) {
		this.mostrarDetalleConsignacionConsignacion= visibilidadResaltarDetalleConsignacion;
	}



	public Boolean activarDetalleConsignacionConsignacion=true;

	public Boolean gethabilitarResaltarDetalleConsignacionConsignacion() {
		return this.activarDetalleConsignacionConsignacion;
	}

	public void setActivarDetalleConsignacionConsignacion(Boolean habilitarResaltarDetalleConsignacion) {
		this.activarDetalleConsignacionConsignacion= habilitarResaltarDetalleConsignacion;
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

		this.setMostrarDetalleConsignacionConsignacion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleConsignacion.class)) {
				this.setMostrarDetalleConsignacionConsignacion(esAsigna);
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

		this.setActivarDetalleConsignacionConsignacion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleConsignacion.class)) {
				this.setActivarDetalleConsignacionConsignacion(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDetalleConsignacionConsignacion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleConsignacion.class)) {
				this.setResaltarDetalleConsignacionConsignacion(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdCentroCostoConsignacion=true;

	public Boolean getMostrarFK_IdCentroCostoConsignacion() {
		return this.mostrarFK_IdCentroCostoConsignacion;
	}

	public void setMostrarFK_IdCentroCostoConsignacion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCentroCostoConsignacion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdClienteConsignacion=true;

	public Boolean getMostrarFK_IdClienteConsignacion() {
		return this.mostrarFK_IdClienteConsignacion;
	}

	public void setMostrarFK_IdClienteConsignacion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteConsignacion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdConsignatarioConsignacion=true;

	public Boolean getMostrarFK_IdConsignatarioConsignacion() {
		return this.mostrarFK_IdConsignatarioConsignacion;
	}

	public void setMostrarFK_IdConsignatarioConsignacion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdConsignatarioConsignacion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioConsignacion=true;

	public Boolean getMostrarFK_IdEjercicioConsignacion() {
		return this.mostrarFK_IdEjercicioConsignacion;
	}

	public void setMostrarFK_IdEjercicioConsignacion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioConsignacion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpleadoConsignacion=true;

	public Boolean getMostrarFK_IdEmpleadoConsignacion() {
		return this.mostrarFK_IdEmpleadoConsignacion;
	}

	public void setMostrarFK_IdEmpleadoConsignacion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoConsignacion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaConsignacion=true;

	public Boolean getMostrarFK_IdEmpresaConsignacion() {
		return this.mostrarFK_IdEmpresaConsignacion;
	}

	public void setMostrarFK_IdEmpresaConsignacion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaConsignacion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstadoPedidoConsignacion=true;

	public Boolean getMostrarFK_IdEstadoPedidoConsignacion() {
		return this.mostrarFK_IdEstadoPedidoConsignacion;
	}

	public void setMostrarFK_IdEstadoPedidoConsignacion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstadoPedidoConsignacion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFormatoConsignacion=true;

	public Boolean getMostrarFK_IdFormatoConsignacion() {
		return this.mostrarFK_IdFormatoConsignacion;
	}

	public void setMostrarFK_IdFormatoConsignacion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFormatoConsignacion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdMonedaConsignacion=true;

	public Boolean getMostrarFK_IdMonedaConsignacion() {
		return this.mostrarFK_IdMonedaConsignacion;
	}

	public void setMostrarFK_IdMonedaConsignacion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdMonedaConsignacion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoConsignacion=true;

	public Boolean getMostrarFK_IdPeriodoConsignacion() {
		return this.mostrarFK_IdPeriodoConsignacion;
	}

	public void setMostrarFK_IdPeriodoConsignacion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoConsignacion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdResponsableConsignacion=true;

	public Boolean getMostrarFK_IdResponsableConsignacion() {
		return this.mostrarFK_IdResponsableConsignacion;
	}

	public void setMostrarFK_IdResponsableConsignacion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdResponsableConsignacion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSubClienteConsignacion=true;

	public Boolean getMostrarFK_IdSubClienteConsignacion() {
		return this.mostrarFK_IdSubClienteConsignacion;
	}

	public void setMostrarFK_IdSubClienteConsignacion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSubClienteConsignacion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalConsignacion=true;

	public Boolean getMostrarFK_IdSucursalConsignacion() {
		return this.mostrarFK_IdSucursalConsignacion;
	}

	public void setMostrarFK_IdSucursalConsignacion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalConsignacion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoCambioConsignacion=true;

	public Boolean getMostrarFK_IdTipoCambioConsignacion() {
		return this.mostrarFK_IdTipoCambioConsignacion;
	}

	public void setMostrarFK_IdTipoCambioConsignacion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoCambioConsignacion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoPrecioConsignacion=true;

	public Boolean getMostrarFK_IdTipoPrecioConsignacion() {
		return this.mostrarFK_IdTipoPrecioConsignacion;
	}

	public void setMostrarFK_IdTipoPrecioConsignacion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoPrecioConsignacion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTransporteConsignacion=true;

	public Boolean getMostrarFK_IdTransporteConsignacion() {
		return this.mostrarFK_IdTransporteConsignacion;
	}

	public void setMostrarFK_IdTransporteConsignacion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTransporteConsignacion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTransportistaConsignacion=true;

	public Boolean getMostrarFK_IdTransportistaConsignacion() {
		return this.mostrarFK_IdTransportistaConsignacion;
	}

	public void setMostrarFK_IdTransportistaConsignacion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTransportistaConsignacion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUsuarioConsignacion=true;

	public Boolean getMostrarFK_IdUsuarioConsignacion() {
		return this.mostrarFK_IdUsuarioConsignacion;
	}

	public void setMostrarFK_IdUsuarioConsignacion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUsuarioConsignacion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdVendedorConsignacion=true;

	public Boolean getMostrarFK_IdVendedorConsignacion() {
		return this.mostrarFK_IdVendedorConsignacion;
	}

	public void setMostrarFK_IdVendedorConsignacion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdVendedorConsignacion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdZonaConsignacion=true;

	public Boolean getMostrarFK_IdZonaConsignacion() {
		return this.mostrarFK_IdZonaConsignacion;
	}

	public void setMostrarFK_IdZonaConsignacion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdZonaConsignacion= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdCentroCostoConsignacion=true;

	public Boolean getActivarFK_IdCentroCostoConsignacion() {
		return this.activarFK_IdCentroCostoConsignacion;
	}

	public void setActivarFK_IdCentroCostoConsignacion(Boolean habilitarResaltar) {
		this.activarFK_IdCentroCostoConsignacion= habilitarResaltar;
	}

	public Boolean activarFK_IdClienteConsignacion=true;

	public Boolean getActivarFK_IdClienteConsignacion() {
		return this.activarFK_IdClienteConsignacion;
	}

	public void setActivarFK_IdClienteConsignacion(Boolean habilitarResaltar) {
		this.activarFK_IdClienteConsignacion= habilitarResaltar;
	}

	public Boolean activarFK_IdConsignatarioConsignacion=true;

	public Boolean getActivarFK_IdConsignatarioConsignacion() {
		return this.activarFK_IdConsignatarioConsignacion;
	}

	public void setActivarFK_IdConsignatarioConsignacion(Boolean habilitarResaltar) {
		this.activarFK_IdConsignatarioConsignacion= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioConsignacion=true;

	public Boolean getActivarFK_IdEjercicioConsignacion() {
		return this.activarFK_IdEjercicioConsignacion;
	}

	public void setActivarFK_IdEjercicioConsignacion(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioConsignacion= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpleadoConsignacion=true;

	public Boolean getActivarFK_IdEmpleadoConsignacion() {
		return this.activarFK_IdEmpleadoConsignacion;
	}

	public void setActivarFK_IdEmpleadoConsignacion(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoConsignacion= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaConsignacion=true;

	public Boolean getActivarFK_IdEmpresaConsignacion() {
		return this.activarFK_IdEmpresaConsignacion;
	}

	public void setActivarFK_IdEmpresaConsignacion(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaConsignacion= habilitarResaltar;
	}

	public Boolean activarFK_IdEstadoPedidoConsignacion=true;

	public Boolean getActivarFK_IdEstadoPedidoConsignacion() {
		return this.activarFK_IdEstadoPedidoConsignacion;
	}

	public void setActivarFK_IdEstadoPedidoConsignacion(Boolean habilitarResaltar) {
		this.activarFK_IdEstadoPedidoConsignacion= habilitarResaltar;
	}

	public Boolean activarFK_IdFormatoConsignacion=true;

	public Boolean getActivarFK_IdFormatoConsignacion() {
		return this.activarFK_IdFormatoConsignacion;
	}

	public void setActivarFK_IdFormatoConsignacion(Boolean habilitarResaltar) {
		this.activarFK_IdFormatoConsignacion= habilitarResaltar;
	}

	public Boolean activarFK_IdMonedaConsignacion=true;

	public Boolean getActivarFK_IdMonedaConsignacion() {
		return this.activarFK_IdMonedaConsignacion;
	}

	public void setActivarFK_IdMonedaConsignacion(Boolean habilitarResaltar) {
		this.activarFK_IdMonedaConsignacion= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoConsignacion=true;

	public Boolean getActivarFK_IdPeriodoConsignacion() {
		return this.activarFK_IdPeriodoConsignacion;
	}

	public void setActivarFK_IdPeriodoConsignacion(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoConsignacion= habilitarResaltar;
	}

	public Boolean activarFK_IdResponsableConsignacion=true;

	public Boolean getActivarFK_IdResponsableConsignacion() {
		return this.activarFK_IdResponsableConsignacion;
	}

	public void setActivarFK_IdResponsableConsignacion(Boolean habilitarResaltar) {
		this.activarFK_IdResponsableConsignacion= habilitarResaltar;
	}

	public Boolean activarFK_IdSubClienteConsignacion=true;

	public Boolean getActivarFK_IdSubClienteConsignacion() {
		return this.activarFK_IdSubClienteConsignacion;
	}

	public void setActivarFK_IdSubClienteConsignacion(Boolean habilitarResaltar) {
		this.activarFK_IdSubClienteConsignacion= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalConsignacion=true;

	public Boolean getActivarFK_IdSucursalConsignacion() {
		return this.activarFK_IdSucursalConsignacion;
	}

	public void setActivarFK_IdSucursalConsignacion(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalConsignacion= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoCambioConsignacion=true;

	public Boolean getActivarFK_IdTipoCambioConsignacion() {
		return this.activarFK_IdTipoCambioConsignacion;
	}

	public void setActivarFK_IdTipoCambioConsignacion(Boolean habilitarResaltar) {
		this.activarFK_IdTipoCambioConsignacion= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoPrecioConsignacion=true;

	public Boolean getActivarFK_IdTipoPrecioConsignacion() {
		return this.activarFK_IdTipoPrecioConsignacion;
	}

	public void setActivarFK_IdTipoPrecioConsignacion(Boolean habilitarResaltar) {
		this.activarFK_IdTipoPrecioConsignacion= habilitarResaltar;
	}

	public Boolean activarFK_IdTransporteConsignacion=true;

	public Boolean getActivarFK_IdTransporteConsignacion() {
		return this.activarFK_IdTransporteConsignacion;
	}

	public void setActivarFK_IdTransporteConsignacion(Boolean habilitarResaltar) {
		this.activarFK_IdTransporteConsignacion= habilitarResaltar;
	}

	public Boolean activarFK_IdTransportistaConsignacion=true;

	public Boolean getActivarFK_IdTransportistaConsignacion() {
		return this.activarFK_IdTransportistaConsignacion;
	}

	public void setActivarFK_IdTransportistaConsignacion(Boolean habilitarResaltar) {
		this.activarFK_IdTransportistaConsignacion= habilitarResaltar;
	}

	public Boolean activarFK_IdUsuarioConsignacion=true;

	public Boolean getActivarFK_IdUsuarioConsignacion() {
		return this.activarFK_IdUsuarioConsignacion;
	}

	public void setActivarFK_IdUsuarioConsignacion(Boolean habilitarResaltar) {
		this.activarFK_IdUsuarioConsignacion= habilitarResaltar;
	}

	public Boolean activarFK_IdVendedorConsignacion=true;

	public Boolean getActivarFK_IdVendedorConsignacion() {
		return this.activarFK_IdVendedorConsignacion;
	}

	public void setActivarFK_IdVendedorConsignacion(Boolean habilitarResaltar) {
		this.activarFK_IdVendedorConsignacion= habilitarResaltar;
	}

	public Boolean activarFK_IdZonaConsignacion=true;

	public Boolean getActivarFK_IdZonaConsignacion() {
		return this.activarFK_IdZonaConsignacion;
	}

	public void setActivarFK_IdZonaConsignacion(Boolean habilitarResaltar) {
		this.activarFK_IdZonaConsignacion= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdCentroCostoConsignacion=null;

	public Border getResaltarFK_IdCentroCostoConsignacion() {
		return this.resaltarFK_IdCentroCostoConsignacion;
	}

	public void setResaltarFK_IdCentroCostoConsignacion(Border borderResaltar) {
		this.resaltarFK_IdCentroCostoConsignacion= borderResaltar;
	}

	public void setResaltarFK_IdCentroCostoConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCentroCostoConsignacion= borderResaltar;
	}

	public Border resaltarFK_IdClienteConsignacion=null;

	public Border getResaltarFK_IdClienteConsignacion() {
		return this.resaltarFK_IdClienteConsignacion;
	}

	public void setResaltarFK_IdClienteConsignacion(Border borderResaltar) {
		this.resaltarFK_IdClienteConsignacion= borderResaltar;
	}

	public void setResaltarFK_IdClienteConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteConsignacion= borderResaltar;
	}

	public Border resaltarFK_IdConsignatarioConsignacion=null;

	public Border getResaltarFK_IdConsignatarioConsignacion() {
		return this.resaltarFK_IdConsignatarioConsignacion;
	}

	public void setResaltarFK_IdConsignatarioConsignacion(Border borderResaltar) {
		this.resaltarFK_IdConsignatarioConsignacion= borderResaltar;
	}

	public void setResaltarFK_IdConsignatarioConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdConsignatarioConsignacion= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioConsignacion=null;

	public Border getResaltarFK_IdEjercicioConsignacion() {
		return this.resaltarFK_IdEjercicioConsignacion;
	}

	public void setResaltarFK_IdEjercicioConsignacion(Border borderResaltar) {
		this.resaltarFK_IdEjercicioConsignacion= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioConsignacion= borderResaltar;
	}

	public Border resaltarFK_IdEmpleadoConsignacion=null;

	public Border getResaltarFK_IdEmpleadoConsignacion() {
		return this.resaltarFK_IdEmpleadoConsignacion;
	}

	public void setResaltarFK_IdEmpleadoConsignacion(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoConsignacion= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoConsignacion= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaConsignacion=null;

	public Border getResaltarFK_IdEmpresaConsignacion() {
		return this.resaltarFK_IdEmpresaConsignacion;
	}

	public void setResaltarFK_IdEmpresaConsignacion(Border borderResaltar) {
		this.resaltarFK_IdEmpresaConsignacion= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaConsignacion= borderResaltar;
	}

	public Border resaltarFK_IdEstadoPedidoConsignacion=null;

	public Border getResaltarFK_IdEstadoPedidoConsignacion() {
		return this.resaltarFK_IdEstadoPedidoConsignacion;
	}

	public void setResaltarFK_IdEstadoPedidoConsignacion(Border borderResaltar) {
		this.resaltarFK_IdEstadoPedidoConsignacion= borderResaltar;
	}

	public void setResaltarFK_IdEstadoPedidoConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstadoPedidoConsignacion= borderResaltar;
	}

	public Border resaltarFK_IdFormatoConsignacion=null;

	public Border getResaltarFK_IdFormatoConsignacion() {
		return this.resaltarFK_IdFormatoConsignacion;
	}

	public void setResaltarFK_IdFormatoConsignacion(Border borderResaltar) {
		this.resaltarFK_IdFormatoConsignacion= borderResaltar;
	}

	public void setResaltarFK_IdFormatoConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFormatoConsignacion= borderResaltar;
	}

	public Border resaltarFK_IdMonedaConsignacion=null;

	public Border getResaltarFK_IdMonedaConsignacion() {
		return this.resaltarFK_IdMonedaConsignacion;
	}

	public void setResaltarFK_IdMonedaConsignacion(Border borderResaltar) {
		this.resaltarFK_IdMonedaConsignacion= borderResaltar;
	}

	public void setResaltarFK_IdMonedaConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdMonedaConsignacion= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoConsignacion=null;

	public Border getResaltarFK_IdPeriodoConsignacion() {
		return this.resaltarFK_IdPeriodoConsignacion;
	}

	public void setResaltarFK_IdPeriodoConsignacion(Border borderResaltar) {
		this.resaltarFK_IdPeriodoConsignacion= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoConsignacion= borderResaltar;
	}

	public Border resaltarFK_IdResponsableConsignacion=null;

	public Border getResaltarFK_IdResponsableConsignacion() {
		return this.resaltarFK_IdResponsableConsignacion;
	}

	public void setResaltarFK_IdResponsableConsignacion(Border borderResaltar) {
		this.resaltarFK_IdResponsableConsignacion= borderResaltar;
	}

	public void setResaltarFK_IdResponsableConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdResponsableConsignacion= borderResaltar;
	}

	public Border resaltarFK_IdSubClienteConsignacion=null;

	public Border getResaltarFK_IdSubClienteConsignacion() {
		return this.resaltarFK_IdSubClienteConsignacion;
	}

	public void setResaltarFK_IdSubClienteConsignacion(Border borderResaltar) {
		this.resaltarFK_IdSubClienteConsignacion= borderResaltar;
	}

	public void setResaltarFK_IdSubClienteConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSubClienteConsignacion= borderResaltar;
	}

	public Border resaltarFK_IdSucursalConsignacion=null;

	public Border getResaltarFK_IdSucursalConsignacion() {
		return this.resaltarFK_IdSucursalConsignacion;
	}

	public void setResaltarFK_IdSucursalConsignacion(Border borderResaltar) {
		this.resaltarFK_IdSucursalConsignacion= borderResaltar;
	}

	public void setResaltarFK_IdSucursalConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalConsignacion= borderResaltar;
	}

	public Border resaltarFK_IdTipoCambioConsignacion=null;

	public Border getResaltarFK_IdTipoCambioConsignacion() {
		return this.resaltarFK_IdTipoCambioConsignacion;
	}

	public void setResaltarFK_IdTipoCambioConsignacion(Border borderResaltar) {
		this.resaltarFK_IdTipoCambioConsignacion= borderResaltar;
	}

	public void setResaltarFK_IdTipoCambioConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoCambioConsignacion= borderResaltar;
	}

	public Border resaltarFK_IdTipoPrecioConsignacion=null;

	public Border getResaltarFK_IdTipoPrecioConsignacion() {
		return this.resaltarFK_IdTipoPrecioConsignacion;
	}

	public void setResaltarFK_IdTipoPrecioConsignacion(Border borderResaltar) {
		this.resaltarFK_IdTipoPrecioConsignacion= borderResaltar;
	}

	public void setResaltarFK_IdTipoPrecioConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoPrecioConsignacion= borderResaltar;
	}

	public Border resaltarFK_IdTransporteConsignacion=null;

	public Border getResaltarFK_IdTransporteConsignacion() {
		return this.resaltarFK_IdTransporteConsignacion;
	}

	public void setResaltarFK_IdTransporteConsignacion(Border borderResaltar) {
		this.resaltarFK_IdTransporteConsignacion= borderResaltar;
	}

	public void setResaltarFK_IdTransporteConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTransporteConsignacion= borderResaltar;
	}

	public Border resaltarFK_IdTransportistaConsignacion=null;

	public Border getResaltarFK_IdTransportistaConsignacion() {
		return this.resaltarFK_IdTransportistaConsignacion;
	}

	public void setResaltarFK_IdTransportistaConsignacion(Border borderResaltar) {
		this.resaltarFK_IdTransportistaConsignacion= borderResaltar;
	}

	public void setResaltarFK_IdTransportistaConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTransportistaConsignacion= borderResaltar;
	}

	public Border resaltarFK_IdUsuarioConsignacion=null;

	public Border getResaltarFK_IdUsuarioConsignacion() {
		return this.resaltarFK_IdUsuarioConsignacion;
	}

	public void setResaltarFK_IdUsuarioConsignacion(Border borderResaltar) {
		this.resaltarFK_IdUsuarioConsignacion= borderResaltar;
	}

	public void setResaltarFK_IdUsuarioConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUsuarioConsignacion= borderResaltar;
	}

	public Border resaltarFK_IdVendedorConsignacion=null;

	public Border getResaltarFK_IdVendedorConsignacion() {
		return this.resaltarFK_IdVendedorConsignacion;
	}

	public void setResaltarFK_IdVendedorConsignacion(Border borderResaltar) {
		this.resaltarFK_IdVendedorConsignacion= borderResaltar;
	}

	public void setResaltarFK_IdVendedorConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdVendedorConsignacion= borderResaltar;
	}

	public Border resaltarFK_IdZonaConsignacion=null;

	public Border getResaltarFK_IdZonaConsignacion() {
		return this.resaltarFK_IdZonaConsignacion;
	}

	public void setResaltarFK_IdZonaConsignacion(Border borderResaltar) {
		this.resaltarFK_IdZonaConsignacion= borderResaltar;
	}

	public void setResaltarFK_IdZonaConsignacion(ParametroGeneralUsuario parametroGeneralUsuario/*ConsignacionBeanSwingJInternalFrame consignacionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdZonaConsignacion= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}