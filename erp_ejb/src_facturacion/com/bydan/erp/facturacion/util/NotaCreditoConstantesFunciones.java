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


import com.bydan.erp.facturacion.util.NotaCreditoConstantesFunciones;
import com.bydan.erp.facturacion.util.NotaCreditoParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.NotaCreditoParameterGeneral;

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
final public class NotaCreditoConstantesFunciones extends NotaCreditoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="NotaCredito";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="NotaCredito"+NotaCreditoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="NotaCreditoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="NotaCreditoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=NotaCreditoConstantesFunciones.SCHEMA+"_"+NotaCreditoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/NotaCreditoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=NotaCreditoConstantesFunciones.SCHEMA+"_"+NotaCreditoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=NotaCreditoConstantesFunciones.SCHEMA+"_"+NotaCreditoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/NotaCreditoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=NotaCreditoConstantesFunciones.SCHEMA+"_"+NotaCreditoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+NotaCreditoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/NotaCreditoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+NotaCreditoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+NotaCreditoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/NotaCreditoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+NotaCreditoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=NotaCreditoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+NotaCreditoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=NotaCreditoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+NotaCreditoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Nota Creditos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Nota Credito";
	public static final String SCLASSWEBTITULO_LOWER="Nota Credito";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="NotaCredito";
	public static final String OBJECTNAME="notacredito";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="nota_credito";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select notacredito from "+NotaCreditoConstantesFunciones.SPERSISTENCENAME+" notacredito";
	public static String QUERYSELECTNATIVE="select "+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".id,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".version_row,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".id_empresa,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".id_sucursal,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".id_ejercicio,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".id_periodo,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".id_anio,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".id_mes,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".id_usuario,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".codigo,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".numero,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".fecha_emision,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".numero_dias,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".fecha_vencimiento,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".id_moneda,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".cotizacion,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".id_empleado,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".id_formato,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".id_tipo_precio,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".id_cliente,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".id_factura,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".direccion,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".telefono,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".ruc,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".id_vendedor,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".id_responsable,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".id_estado_nota_credito,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".descripcion,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".descuento_porcentaje,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".total_iva,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".suman,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".descuento_valor,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".total_sin_iva,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".total_descuento,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".flete,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".total,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".sub_total,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".otro,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".iva,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".financiamiento,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".ice,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".otro_valor,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".retencion,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".fecha,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".es_cliente,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".id_centro_costo,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".id_tipo_cambio,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".id_transporte,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".id_transportista,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".fecha_cliente,"+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME+".fecha_autorizacion from "+NotaCreditoConstantesFunciones.SCHEMA+"."+NotaCreditoConstantesFunciones.TABLENAME;//+" as "+NotaCreditoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=true;
	
	
	protected NotaCreditoConstantesFuncionesAdditional notacreditoConstantesFuncionesAdditional=null;
	
	public NotaCreditoConstantesFuncionesAdditional getNotaCreditoConstantesFuncionesAdditional() {
		return this.notacreditoConstantesFuncionesAdditional;
	}
	
	public void setNotaCreditoConstantesFuncionesAdditional(NotaCreditoConstantesFuncionesAdditional notacreditoConstantesFuncionesAdditional) {
		try {
			this.notacreditoConstantesFuncionesAdditional=notacreditoConstantesFuncionesAdditional;
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
    public static final String CODIGO= "codigo";
    public static final String NUMEROPREIMPRESO= "numero";
    public static final String FECHAEMISION= "fecha_emision";
    public static final String NUMERODIAS= "numero_dias";
    public static final String FECHAVENCIMIENTO= "fecha_vencimiento";
    public static final String IDMONEDA= "id_moneda";
    public static final String COTIZACION= "cotizacion";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String IDFORMATO= "id_formato";
    public static final String IDTIPOPRECIO= "id_tipo_precio";
    public static final String IDCLIENTE= "id_cliente";
    public static final String IDFACTURA= "id_factura";
    public static final String DIRECCION= "direccion";
    public static final String TELEFONO= "telefono";
    public static final String RUC= "ruc";
    public static final String IDVENDEDOR= "id_vendedor";
    public static final String IDRESPONSABLE= "id_responsable";
    public static final String IDESTADONOTACREDITO= "id_estado_nota_credito";
    public static final String DESCRIPCION= "descripcion";
    public static final String DESCUENTOPORCENTAJE= "descuento_porcentaje";
    public static final String TOTALIVA= "total_iva";
    public static final String SUMAN= "suman";
    public static final String DESCUENTOVALOR= "descuento_valor";
    public static final String TOTALSINIVA= "total_sin_iva";
    public static final String TOTALDESCUENTO= "total_descuento";
    public static final String FLETE= "flete";
    public static final String TOTAL= "total";
    public static final String SUBTOTAL= "sub_total";
    public static final String OTRO= "otro";
    public static final String IVA= "iva";
    public static final String FINANCIAMIENTO= "financiamiento";
    public static final String ICE= "ice";
    public static final String OTROVALOR= "otro_valor";
    public static final String RETENCION= "retencion";
    public static final String FECHA= "fecha";
    public static final String ESCLIENTE= "es_cliente";
    public static final String IDCENTROCOSTO= "id_centro_costo";
    public static final String IDTIPOCAMBIO= "id_tipo_cambio";
    public static final String IDTRANSPORTE= "id_transporte";
    public static final String IDTRANSPORTISTA= "id_transportista";
    public static final String FECHACLIENTE= "fecha_cliente";
    public static final String FECHAAUTORIZACION= "fecha_autorizacion";
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
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NUMEROPREIMPRESO= "Nro Preimpreso";
		public static final String LABEL_NUMEROPREIMPRESO_LOWER= "Numero Pre Impreso";
    	public static final String LABEL_FECHAEMISION= "Fecha Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "Fecha Emision";
    	public static final String LABEL_NUMERODIAS= "Nro Dias";
		public static final String LABEL_NUMERODIAS_LOWER= "Numero Dias";
    	public static final String LABEL_FECHAVENCIMIENTO= "Fecha Vencimiento";
		public static final String LABEL_FECHAVENCIMIENTO_LOWER= "Fecha Vencimiento";
    	public static final String LABEL_IDMONEDA= "Moneda";
		public static final String LABEL_IDMONEDA_LOWER= "Moneda";
    	public static final String LABEL_COTIZACION= "Cotizacion";
		public static final String LABEL_COTIZACION_LOWER= "Cotizacion";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_IDFORMATO= "Formato";
		public static final String LABEL_IDFORMATO_LOWER= "Formato";
    	public static final String LABEL_IDTIPOPRECIO= "Tipo Precio";
		public static final String LABEL_IDTIPOPRECIO_LOWER= "Tipo Precio";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_IDFACTURA= "Factura";
		public static final String LABEL_IDFACTURA_LOWER= "Factura";
    	public static final String LABEL_DIRECCION= "Direccion";
		public static final String LABEL_DIRECCION_LOWER= "Direccion";
    	public static final String LABEL_TELEFONO= "Telefono";
		public static final String LABEL_TELEFONO_LOWER= "Telefono";
    	public static final String LABEL_RUC= "Ruc";
		public static final String LABEL_RUC_LOWER= "Ruc";
    	public static final String LABEL_IDVENDEDOR= "Vendedor";
		public static final String LABEL_IDVENDEDOR_LOWER= "Vendedor";
    	public static final String LABEL_IDRESPONSABLE= "Responsable";
		public static final String LABEL_IDRESPONSABLE_LOWER= "Responsable";
    	public static final String LABEL_IDESTADONOTACREDITO= "Estado";
		public static final String LABEL_IDESTADONOTACREDITO_LOWER= "Estado Nota Credito";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_DESCUENTOPORCENTAJE= "Descuento %";
		public static final String LABEL_DESCUENTOPORCENTAJE_LOWER= "Descuento Porcentaje";
    	public static final String LABEL_TOTALIVA= "Monto Con Iva";
		public static final String LABEL_TOTALIVA_LOWER= "Total Iva";
    	public static final String LABEL_SUMAN= "Suman";
		public static final String LABEL_SUMAN_LOWER= "Suman";
    	public static final String LABEL_DESCUENTOVALOR= "Dscto Valor";
		public static final String LABEL_DESCUENTOVALOR_LOWER= "Descuento Valor";
    	public static final String LABEL_TOTALSINIVA= "Monto Sin Iva";
		public static final String LABEL_TOTALSINIVA_LOWER= "Total Sin Iva";
    	public static final String LABEL_TOTALDESCUENTO= "Total Descuento";
		public static final String LABEL_TOTALDESCUENTO_LOWER= "Total Descuento";
    	public static final String LABEL_FLETE= "Flete";
		public static final String LABEL_FLETE_LOWER= "Flete";
    	public static final String LABEL_TOTAL= "Total";
		public static final String LABEL_TOTAL_LOWER= "Total";
    	public static final String LABEL_SUBTOTAL= "Sub Total";
		public static final String LABEL_SUBTOTAL_LOWER= "Sub Total";
    	public static final String LABEL_OTRO= "Otro";
		public static final String LABEL_OTRO_LOWER= "Otro";
    	public static final String LABEL_IVA= "Iva";
		public static final String LABEL_IVA_LOWER= "Iva";
    	public static final String LABEL_FINANCIAMIENTO= "Financiamiento";
		public static final String LABEL_FINANCIAMIENTO_LOWER= "Financiamiento";
    	public static final String LABEL_ICE= "Ice";
		public static final String LABEL_ICE_LOWER= "Ice";
    	public static final String LABEL_OTROVALOR= "Otro Valor";
		public static final String LABEL_OTROVALOR_LOWER= "Otro Valor";
    	public static final String LABEL_RETENCION= "Retencion";
		public static final String LABEL_RETENCION_LOWER= "Retencion";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_ESCLIENTE= "Es Cliente";
		public static final String LABEL_ESCLIENTE_LOWER= "Es Cliente";
    	public static final String LABEL_IDCENTROCOSTO= "Centro Costo";
		public static final String LABEL_IDCENTROCOSTO_LOWER= "Centro Costo";
    	public static final String LABEL_IDTIPOCAMBIO= "Tipo Cambio";
		public static final String LABEL_IDTIPOCAMBIO_LOWER= "Tipo Cambio";
    	public static final String LABEL_IDTRANSPORTE= "Transporte";
		public static final String LABEL_IDTRANSPORTE_LOWER= "Transporte";
    	public static final String LABEL_IDTRANSPORTISTA= "Transportista";
		public static final String LABEL_IDTRANSPORTISTA_LOWER= "Transportista";
    	public static final String LABEL_FECHACLIENTE= "Fecha Cliente";
		public static final String LABEL_FECHACLIENTE_LOWER= "Fecha Cliente";
    	public static final String LABEL_FECHAAUTORIZACION= "Fecha Autorizacion";
		public static final String LABEL_FECHAAUTORIZACION_LOWER= "Fecha Autorizacion";
	
		
		
		
		
		
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXDIRECCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDIRECCION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXTELEFONO=ConstantesValidacion.SREGEXCADENA_TELEFONO;
	public static final String SMENSAJEREGEXTELEFONO=ConstantesValidacion.SVALIDACIONCADENA_TELEFONO;	
	public static final String SREGEXRUC=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXRUC=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getNotaCreditoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(NotaCreditoConstantesFunciones.IDEMPRESA)) {sLabelColumna=NotaCreditoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(NotaCreditoConstantesFunciones.IDSUCURSAL)) {sLabelColumna=NotaCreditoConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(NotaCreditoConstantesFunciones.IDEJERCICIO)) {sLabelColumna=NotaCreditoConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(NotaCreditoConstantesFunciones.IDPERIODO)) {sLabelColumna=NotaCreditoConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(NotaCreditoConstantesFunciones.IDANIO)) {sLabelColumna=NotaCreditoConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(NotaCreditoConstantesFunciones.IDMES)) {sLabelColumna=NotaCreditoConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(NotaCreditoConstantesFunciones.IDUSUARIO)) {sLabelColumna=NotaCreditoConstantesFunciones.LABEL_IDUSUARIO;}
		if(sNombreColumna.equals(NotaCreditoConstantesFunciones.CODIGO)) {sLabelColumna=NotaCreditoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(NotaCreditoConstantesFunciones.NUMEROPREIMPRESO)) {sLabelColumna=NotaCreditoConstantesFunciones.LABEL_NUMEROPREIMPRESO;}
		if(sNombreColumna.equals(NotaCreditoConstantesFunciones.FECHAEMISION)) {sLabelColumna=NotaCreditoConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(NotaCreditoConstantesFunciones.NUMERODIAS)) {sLabelColumna=NotaCreditoConstantesFunciones.LABEL_NUMERODIAS;}
		if(sNombreColumna.equals(NotaCreditoConstantesFunciones.FECHAVENCIMIENTO)) {sLabelColumna=NotaCreditoConstantesFunciones.LABEL_FECHAVENCIMIENTO;}
		if(sNombreColumna.equals(NotaCreditoConstantesFunciones.IDMONEDA)) {sLabelColumna=NotaCreditoConstantesFunciones.LABEL_IDMONEDA;}
		if(sNombreColumna.equals(NotaCreditoConstantesFunciones.COTIZACION)) {sLabelColumna=NotaCreditoConstantesFunciones.LABEL_COTIZACION;}
		if(sNombreColumna.equals(NotaCreditoConstantesFunciones.IDEMPLEADO)) {sLabelColumna=NotaCreditoConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(NotaCreditoConstantesFunciones.IDFORMATO)) {sLabelColumna=NotaCreditoConstantesFunciones.LABEL_IDFORMATO;}
		if(sNombreColumna.equals(NotaCreditoConstantesFunciones.IDTIPOPRECIO)) {sLabelColumna=NotaCreditoConstantesFunciones.LABEL_IDTIPOPRECIO;}
		if(sNombreColumna.equals(NotaCreditoConstantesFunciones.IDCLIENTE)) {sLabelColumna=NotaCreditoConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(NotaCreditoConstantesFunciones.IDFACTURA)) {sLabelColumna=NotaCreditoConstantesFunciones.LABEL_IDFACTURA;}
		if(sNombreColumna.equals(NotaCreditoConstantesFunciones.DIRECCION)) {sLabelColumna=NotaCreditoConstantesFunciones.LABEL_DIRECCION;}
		if(sNombreColumna.equals(NotaCreditoConstantesFunciones.TELEFONO)) {sLabelColumna=NotaCreditoConstantesFunciones.LABEL_TELEFONO;}
		if(sNombreColumna.equals(NotaCreditoConstantesFunciones.RUC)) {sLabelColumna=NotaCreditoConstantesFunciones.LABEL_RUC;}
		if(sNombreColumna.equals(NotaCreditoConstantesFunciones.IDVENDEDOR)) {sLabelColumna=NotaCreditoConstantesFunciones.LABEL_IDVENDEDOR;}
		if(sNombreColumna.equals(NotaCreditoConstantesFunciones.IDRESPONSABLE)) {sLabelColumna=NotaCreditoConstantesFunciones.LABEL_IDRESPONSABLE;}
		if(sNombreColumna.equals(NotaCreditoConstantesFunciones.IDESTADONOTACREDITO)) {sLabelColumna=NotaCreditoConstantesFunciones.LABEL_IDESTADONOTACREDITO;}
		if(sNombreColumna.equals(NotaCreditoConstantesFunciones.DESCRIPCION)) {sLabelColumna=NotaCreditoConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(NotaCreditoConstantesFunciones.DESCUENTOPORCENTAJE)) {sLabelColumna=NotaCreditoConstantesFunciones.LABEL_DESCUENTOPORCENTAJE;}
		if(sNombreColumna.equals(NotaCreditoConstantesFunciones.TOTALIVA)) {sLabelColumna=NotaCreditoConstantesFunciones.LABEL_TOTALIVA;}
		if(sNombreColumna.equals(NotaCreditoConstantesFunciones.SUMAN)) {sLabelColumna=NotaCreditoConstantesFunciones.LABEL_SUMAN;}
		if(sNombreColumna.equals(NotaCreditoConstantesFunciones.DESCUENTOVALOR)) {sLabelColumna=NotaCreditoConstantesFunciones.LABEL_DESCUENTOVALOR;}
		if(sNombreColumna.equals(NotaCreditoConstantesFunciones.TOTALSINIVA)) {sLabelColumna=NotaCreditoConstantesFunciones.LABEL_TOTALSINIVA;}
		if(sNombreColumna.equals(NotaCreditoConstantesFunciones.TOTALDESCUENTO)) {sLabelColumna=NotaCreditoConstantesFunciones.LABEL_TOTALDESCUENTO;}
		if(sNombreColumna.equals(NotaCreditoConstantesFunciones.FLETE)) {sLabelColumna=NotaCreditoConstantesFunciones.LABEL_FLETE;}
		if(sNombreColumna.equals(NotaCreditoConstantesFunciones.TOTAL)) {sLabelColumna=NotaCreditoConstantesFunciones.LABEL_TOTAL;}
		if(sNombreColumna.equals(NotaCreditoConstantesFunciones.SUBTOTAL)) {sLabelColumna=NotaCreditoConstantesFunciones.LABEL_SUBTOTAL;}
		if(sNombreColumna.equals(NotaCreditoConstantesFunciones.OTRO)) {sLabelColumna=NotaCreditoConstantesFunciones.LABEL_OTRO;}
		if(sNombreColumna.equals(NotaCreditoConstantesFunciones.IVA)) {sLabelColumna=NotaCreditoConstantesFunciones.LABEL_IVA;}
		if(sNombreColumna.equals(NotaCreditoConstantesFunciones.FINANCIAMIENTO)) {sLabelColumna=NotaCreditoConstantesFunciones.LABEL_FINANCIAMIENTO;}
		if(sNombreColumna.equals(NotaCreditoConstantesFunciones.ICE)) {sLabelColumna=NotaCreditoConstantesFunciones.LABEL_ICE;}
		if(sNombreColumna.equals(NotaCreditoConstantesFunciones.OTROVALOR)) {sLabelColumna=NotaCreditoConstantesFunciones.LABEL_OTROVALOR;}
		if(sNombreColumna.equals(NotaCreditoConstantesFunciones.RETENCION)) {sLabelColumna=NotaCreditoConstantesFunciones.LABEL_RETENCION;}
		if(sNombreColumna.equals(NotaCreditoConstantesFunciones.FECHA)) {sLabelColumna=NotaCreditoConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(NotaCreditoConstantesFunciones.ESCLIENTE)) {sLabelColumna=NotaCreditoConstantesFunciones.LABEL_ESCLIENTE;}
		if(sNombreColumna.equals(NotaCreditoConstantesFunciones.IDCENTROCOSTO)) {sLabelColumna=NotaCreditoConstantesFunciones.LABEL_IDCENTROCOSTO;}
		if(sNombreColumna.equals(NotaCreditoConstantesFunciones.IDTIPOCAMBIO)) {sLabelColumna=NotaCreditoConstantesFunciones.LABEL_IDTIPOCAMBIO;}
		if(sNombreColumna.equals(NotaCreditoConstantesFunciones.IDTRANSPORTE)) {sLabelColumna=NotaCreditoConstantesFunciones.LABEL_IDTRANSPORTE;}
		if(sNombreColumna.equals(NotaCreditoConstantesFunciones.IDTRANSPORTISTA)) {sLabelColumna=NotaCreditoConstantesFunciones.LABEL_IDTRANSPORTISTA;}
		if(sNombreColumna.equals(NotaCreditoConstantesFunciones.FECHACLIENTE)) {sLabelColumna=NotaCreditoConstantesFunciones.LABEL_FECHACLIENTE;}
		if(sNombreColumna.equals(NotaCreditoConstantesFunciones.FECHAAUTORIZACION)) {sLabelColumna=NotaCreditoConstantesFunciones.LABEL_FECHAAUTORIZACION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getes_clienteDescripcion(NotaCredito notacredito) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!notacredito.getes_cliente()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_clienteHtmlDescripcion(NotaCredito notacredito) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(notacredito.getId(),notacredito.getes_cliente());

		return sDescripcion;
	}	
			
			
			
			
			
			
	
	public static String getNotaCreditoDescripcion(NotaCredito notacredito) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(notacredito !=null/* && notacredito.getId()!=0*/) {
			sDescripcion=notacredito.getcodigo();//notacreditonotacredito.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getNotaCreditoDescripcionDetallado(NotaCredito notacredito) {
		String sDescripcion="";
			
		sDescripcion+=NotaCreditoConstantesFunciones.ID+"=";
		sDescripcion+=notacredito.getId().toString()+",";
		sDescripcion+=NotaCreditoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=notacredito.getVersionRow().toString()+",";
		sDescripcion+=NotaCreditoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=notacredito.getid_empresa().toString()+",";
		sDescripcion+=NotaCreditoConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=notacredito.getid_sucursal().toString()+",";
		sDescripcion+=NotaCreditoConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=notacredito.getid_ejercicio().toString()+",";
		sDescripcion+=NotaCreditoConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=notacredito.getid_periodo().toString()+",";
		sDescripcion+=NotaCreditoConstantesFunciones.IDANIO+"=";
		sDescripcion+=notacredito.getid_anio().toString()+",";
		sDescripcion+=NotaCreditoConstantesFunciones.IDMES+"=";
		sDescripcion+=notacredito.getid_mes().toString()+",";
		sDescripcion+=NotaCreditoConstantesFunciones.IDUSUARIO+"=";
		sDescripcion+=notacredito.getid_usuario().toString()+",";
		sDescripcion+=NotaCreditoConstantesFunciones.CODIGO+"=";
		sDescripcion+=notacredito.getcodigo()+",";
		sDescripcion+=NotaCreditoConstantesFunciones.NUMEROPREIMPRESO+"=";
		sDescripcion+=notacredito.getnumero()+",";
		sDescripcion+=NotaCreditoConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=notacredito.getfecha_emision().toString()+",";
		sDescripcion+=NotaCreditoConstantesFunciones.NUMERODIAS+"=";
		sDescripcion+=notacredito.getnumero_dias().toString()+",";
		sDescripcion+=NotaCreditoConstantesFunciones.FECHAVENCIMIENTO+"=";
		sDescripcion+=notacredito.getfecha_vencimiento().toString()+",";
		sDescripcion+=NotaCreditoConstantesFunciones.IDMONEDA+"=";
		sDescripcion+=notacredito.getid_moneda().toString()+",";
		sDescripcion+=NotaCreditoConstantesFunciones.COTIZACION+"=";
		sDescripcion+=notacredito.getcotizacion().toString()+",";
		sDescripcion+=NotaCreditoConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=notacredito.getid_empleado().toString()+",";
		sDescripcion+=NotaCreditoConstantesFunciones.IDFORMATO+"=";
		sDescripcion+=notacredito.getid_formato().toString()+",";
		sDescripcion+=NotaCreditoConstantesFunciones.IDTIPOPRECIO+"=";
		sDescripcion+=notacredito.getid_tipo_precio().toString()+",";
		sDescripcion+=NotaCreditoConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=notacredito.getid_cliente().toString()+",";
		sDescripcion+=NotaCreditoConstantesFunciones.IDFACTURA+"=";
		sDescripcion+=notacredito.getid_factura().toString()+",";
		sDescripcion+=NotaCreditoConstantesFunciones.DIRECCION+"=";
		sDescripcion+=notacredito.getdireccion()+",";
		sDescripcion+=NotaCreditoConstantesFunciones.TELEFONO+"=";
		sDescripcion+=notacredito.gettelefono()+",";
		sDescripcion+=NotaCreditoConstantesFunciones.RUC+"=";
		sDescripcion+=notacredito.getruc()+",";
		sDescripcion+=NotaCreditoConstantesFunciones.IDVENDEDOR+"=";
		sDescripcion+=notacredito.getid_vendedor().toString()+",";
		sDescripcion+=NotaCreditoConstantesFunciones.IDRESPONSABLE+"=";
		sDescripcion+=notacredito.getid_responsable().toString()+",";
		sDescripcion+=NotaCreditoConstantesFunciones.IDESTADONOTACREDITO+"=";
		sDescripcion+=notacredito.getid_estado_nota_credito().toString()+",";
		sDescripcion+=NotaCreditoConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=notacredito.getdescripcion()+",";
		sDescripcion+=NotaCreditoConstantesFunciones.DESCUENTOPORCENTAJE+"=";
		sDescripcion+=notacredito.getdescuento_porcentaje().toString()+",";
		sDescripcion+=NotaCreditoConstantesFunciones.TOTALIVA+"=";
		sDescripcion+=notacredito.gettotal_iva().toString()+",";
		sDescripcion+=NotaCreditoConstantesFunciones.SUMAN+"=";
		sDescripcion+=notacredito.getsuman().toString()+",";
		sDescripcion+=NotaCreditoConstantesFunciones.DESCUENTOVALOR+"=";
		sDescripcion+=notacredito.getdescuento_valor().toString()+",";
		sDescripcion+=NotaCreditoConstantesFunciones.TOTALSINIVA+"=";
		sDescripcion+=notacredito.gettotal_sin_iva().toString()+",";
		sDescripcion+=NotaCreditoConstantesFunciones.TOTALDESCUENTO+"=";
		sDescripcion+=notacredito.gettotal_descuento().toString()+",";
		sDescripcion+=NotaCreditoConstantesFunciones.FLETE+"=";
		sDescripcion+=notacredito.getflete().toString()+",";
		sDescripcion+=NotaCreditoConstantesFunciones.TOTAL+"=";
		sDescripcion+=notacredito.gettotal().toString()+",";
		sDescripcion+=NotaCreditoConstantesFunciones.SUBTOTAL+"=";
		sDescripcion+=notacredito.getsub_total().toString()+",";
		sDescripcion+=NotaCreditoConstantesFunciones.OTRO+"=";
		sDescripcion+=notacredito.getotro().toString()+",";
		sDescripcion+=NotaCreditoConstantesFunciones.IVA+"=";
		sDescripcion+=notacredito.getiva().toString()+",";
		sDescripcion+=NotaCreditoConstantesFunciones.FINANCIAMIENTO+"=";
		sDescripcion+=notacredito.getfinanciamiento().toString()+",";
		sDescripcion+=NotaCreditoConstantesFunciones.ICE+"=";
		sDescripcion+=notacredito.getice().toString()+",";
		sDescripcion+=NotaCreditoConstantesFunciones.OTROVALOR+"=";
		sDescripcion+=notacredito.getotro_valor().toString()+",";
		sDescripcion+=NotaCreditoConstantesFunciones.RETENCION+"=";
		sDescripcion+=notacredito.getretencion().toString()+",";
		sDescripcion+=NotaCreditoConstantesFunciones.FECHA+"=";
		sDescripcion+=notacredito.getfecha().toString()+",";
		sDescripcion+=NotaCreditoConstantesFunciones.ESCLIENTE+"=";
		sDescripcion+=notacredito.getes_cliente().toString()+",";
		sDescripcion+=NotaCreditoConstantesFunciones.IDCENTROCOSTO+"=";
		sDescripcion+=notacredito.getid_centro_costo().toString()+",";
		sDescripcion+=NotaCreditoConstantesFunciones.IDTIPOCAMBIO+"=";
		sDescripcion+=notacredito.getid_tipo_cambio().toString()+",";
		sDescripcion+=NotaCreditoConstantesFunciones.IDTRANSPORTE+"=";
		sDescripcion+=notacredito.getid_transporte().toString()+",";
		sDescripcion+=NotaCreditoConstantesFunciones.IDTRANSPORTISTA+"=";
		sDescripcion+=notacredito.getid_transportista().toString()+",";
		sDescripcion+=NotaCreditoConstantesFunciones.FECHACLIENTE+"=";
		sDescripcion+=notacredito.getfecha_cliente().toString()+",";
		sDescripcion+=NotaCreditoConstantesFunciones.FECHAAUTORIZACION+"=";
		sDescripcion+=notacredito.getfecha_autorizacion().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setNotaCreditoDescripcion(NotaCredito notacredito,String sValor) throws Exception {			
		if(notacredito !=null) {
			notacredito.setcodigo(sValor);;//notacreditonotacredito.getcodigo().trim();
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

	public static String getFormatoDescripcion(Formato formato) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(formato!=null/*&&formato.getId()>0*/) {
			sDescripcion=FormatoConstantesFunciones.getFormatoDescripcion(formato);
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

	public static String getClienteDescripcion(Cliente cliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cliente!=null/*&&cliente.getId()>0*/) {
			sDescripcion=ClienteConstantesFunciones.getClienteDescripcion(cliente);
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

	public static String getVendedorDescripcion(Vendedor vendedor) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(vendedor!=null/*&&vendedor.getId()>0*/) {
			sDescripcion=VendedorConstantesFunciones.getVendedorDescripcion(vendedor);
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

	public static String getEstadoNotaCreditoDescripcion(EstadoNotaCredito estadonotacredito) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadonotacredito!=null/*&&estadonotacredito.getId()>0*/) {
			sDescripcion=EstadoNotaCreditoConstantesFunciones.getEstadoNotaCreditoDescripcion(estadonotacredito);
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

	public static String getTipoCambioDescripcion(TipoCambio tipocambio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipocambio!=null/*&&tipocambio.getId()>0*/) {
			sDescripcion=TipoCambioConstantesFunciones.getTipoCambioDescripcion(tipocambio);
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

	public static String getTransportistaDescripcion(Transportista transportista) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transportista!=null/*&&transportista.getId()>0*/) {
			sDescripcion=TransportistaConstantesFunciones.getTransportistaDescripcion(transportista);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorCodigo")) {
			sNombreIndice="Tipo=  Por Codigo";
		} else if(sNombreIndice.equals("BusquedaPorNumeroPreImpreso")) {
			sNombreIndice="Tipo=  Por Nro Preimpreso";
		} else if(sNombreIndice.equals("FK_IdAnio")) {
			sNombreIndice="Tipo=  Por Anio";
		} else if(sNombreIndice.equals("FK_IdCentroCosto")) {
			sNombreIndice="Tipo=  Por Centro Costo";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpleado")) {
			sNombreIndice="Tipo=  Por Empleado";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdFactura")) {
			sNombreIndice="Tipo=  Por Factura";
		} else if(sNombreIndice.equals("FK_IdFormato")) {
			sNombreIndice="Tipo=  Por Formato";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		} else if(sNombreIndice.equals("FK_IdMoneda")) {
			sNombreIndice="Tipo=  Por Moneda";
		} else if(sNombreIndice.equals("FK_IdNotaCredito")) {
			sNombreIndice="Tipo=  Por Estado";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdResponsable")) {
			sNombreIndice="Tipo=  Por Responsable";
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
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorCodigo(String codigo) {
		String sDetalleIndice=" Parametros->";
		if(codigo!=null) {sDetalleIndice+=" Codigo="+codigo;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorNumeroPreImpreso(String numero) {
		String sDetalleIndice=" Parametros->";
		if(numero!=null) {sDetalleIndice+=" Nro Preimpreso="+numero;} 

		return sDetalleIndice;
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

	public static String getDetalleIndiceFK_IdFactura(Long id_factura) {
		String sDetalleIndice=" Parametros->";
		if(id_factura!=null) {sDetalleIndice+=" Codigo Unico De Factura="+id_factura.toString();} 

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

	public static String getDetalleIndiceFK_IdNotaCredito(Long id_estado_nota_credito) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_nota_credito!=null) {sDetalleIndice+=" Codigo Unico De Estado="+id_estado_nota_credito.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosNotaCredito(NotaCredito notacredito,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		notacredito.setcodigo(notacredito.getcodigo().trim());
		notacredito.setnumero(notacredito.getnumero().trim());
		notacredito.setdireccion(notacredito.getdireccion().trim());
		notacredito.settelefono(notacredito.gettelefono().trim());
		notacredito.setruc(notacredito.getruc().trim());
		notacredito.setdescripcion(notacredito.getdescripcion().trim());
	}
	
	public static void quitarEspaciosNotaCreditos(List<NotaCredito> notacreditos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(NotaCredito notacredito: notacreditos) {
			notacredito.setcodigo(notacredito.getcodigo().trim());
			notacredito.setnumero(notacredito.getnumero().trim());
			notacredito.setdireccion(notacredito.getdireccion().trim());
			notacredito.settelefono(notacredito.gettelefono().trim());
			notacredito.setruc(notacredito.getruc().trim());
			notacredito.setdescripcion(notacredito.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresNotaCredito(NotaCredito notacredito,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && notacredito.getConCambioAuxiliar()) {
			notacredito.setIsDeleted(notacredito.getIsDeletedAuxiliar());	
			notacredito.setIsNew(notacredito.getIsNewAuxiliar());	
			notacredito.setIsChanged(notacredito.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			notacredito.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			notacredito.setIsDeletedAuxiliar(false);	
			notacredito.setIsNewAuxiliar(false);	
			notacredito.setIsChangedAuxiliar(false);
			
			notacredito.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresNotaCreditos(List<NotaCredito> notacreditos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(NotaCredito notacredito : notacreditos) {
			if(conAsignarBase && notacredito.getConCambioAuxiliar()) {
				notacredito.setIsDeleted(notacredito.getIsDeletedAuxiliar());	
				notacredito.setIsNew(notacredito.getIsNewAuxiliar());	
				notacredito.setIsChanged(notacredito.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				notacredito.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				notacredito.setIsDeletedAuxiliar(false);	
				notacredito.setIsNewAuxiliar(false);	
				notacredito.setIsChangedAuxiliar(false);
				
				notacredito.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresNotaCredito(NotaCredito notacredito,Boolean conEnteros) throws Exception  {
		notacredito.setcotizacion(0.0);
		notacredito.setdescuento_porcentaje(0.0);
		notacredito.settotal_iva(0.0);
		notacredito.setsuman(0.0);
		notacredito.setdescuento_valor(0.0);
		notacredito.settotal_sin_iva(0.0);
		notacredito.settotal_descuento(0.0);
		notacredito.setflete(0.0);
		notacredito.settotal(0.0);
		notacredito.setsub_total(0.0);
		notacredito.setotro(0.0);
		notacredito.setiva(0.0);
		notacredito.setfinanciamiento(0.0);
		notacredito.setice(0.0);
		notacredito.setotro_valor(0.0);
		notacredito.setretencion(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			notacredito.setnumero_dias(0);
		}
	}		
	
	public static void InicializarValoresNotaCreditos(List<NotaCredito> notacreditos,Boolean conEnteros) throws Exception  {
		
		for(NotaCredito notacredito: notacreditos) {
			notacredito.setcotizacion(0.0);
			notacredito.setdescuento_porcentaje(0.0);
			notacredito.settotal_iva(0.0);
			notacredito.setsuman(0.0);
			notacredito.setdescuento_valor(0.0);
			notacredito.settotal_sin_iva(0.0);
			notacredito.settotal_descuento(0.0);
			notacredito.setflete(0.0);
			notacredito.settotal(0.0);
			notacredito.setsub_total(0.0);
			notacredito.setotro(0.0);
			notacredito.setiva(0.0);
			notacredito.setfinanciamiento(0.0);
			notacredito.setice(0.0);
			notacredito.setotro_valor(0.0);
			notacredito.setretencion(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				notacredito.setnumero_dias(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaNotaCredito(List<NotaCredito> notacreditos,NotaCredito notacreditoAux) throws Exception  {
		NotaCreditoConstantesFunciones.InicializarValoresNotaCredito(notacreditoAux,true);
		
		for(NotaCredito notacredito: notacreditos) {
			if(notacredito.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			notacreditoAux.setnumero_dias(notacreditoAux.getnumero_dias()+notacredito.getnumero_dias());			
			notacreditoAux.setcotizacion(notacreditoAux.getcotizacion()+notacredito.getcotizacion());			
			notacreditoAux.setdescuento_porcentaje(notacreditoAux.getdescuento_porcentaje()+notacredito.getdescuento_porcentaje());			
			notacreditoAux.settotal_iva(notacreditoAux.gettotal_iva()+notacredito.gettotal_iva());			
			notacreditoAux.setsuman(notacreditoAux.getsuman()+notacredito.getsuman());			
			notacreditoAux.setdescuento_valor(notacreditoAux.getdescuento_valor()+notacredito.getdescuento_valor());			
			notacreditoAux.settotal_sin_iva(notacreditoAux.gettotal_sin_iva()+notacredito.gettotal_sin_iva());			
			notacreditoAux.settotal_descuento(notacreditoAux.gettotal_descuento()+notacredito.gettotal_descuento());			
			notacreditoAux.setflete(notacreditoAux.getflete()+notacredito.getflete());			
			notacreditoAux.settotal(notacreditoAux.gettotal()+notacredito.gettotal());			
			notacreditoAux.setsub_total(notacreditoAux.getsub_total()+notacredito.getsub_total());			
			notacreditoAux.setotro(notacreditoAux.getotro()+notacredito.getotro());			
			notacreditoAux.setiva(notacreditoAux.getiva()+notacredito.getiva());			
			notacreditoAux.setfinanciamiento(notacreditoAux.getfinanciamiento()+notacredito.getfinanciamiento());			
			notacreditoAux.setice(notacreditoAux.getice()+notacredito.getice());			
			notacreditoAux.setotro_valor(notacreditoAux.getotro_valor()+notacredito.getotro_valor());			
			notacreditoAux.setretencion(notacreditoAux.getretencion()+notacredito.getretencion());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNotaCredito(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=NotaCreditoConstantesFunciones.getArrayColumnasGlobalesNotaCredito(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesNotaCredito(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(NotaCreditoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(NotaCreditoConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(NotaCreditoConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(NotaCreditoConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(NotaCreditoConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(NotaCreditoConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(NotaCreditoConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(NotaCreditoConstantesFunciones.IDPERIODO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(NotaCreditoConstantesFunciones.IDUSUARIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(NotaCreditoConstantesFunciones.IDUSUARIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(NotaCreditoConstantesFunciones.IDMONEDA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(NotaCreditoConstantesFunciones.IDMONEDA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoNotaCredito(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<NotaCredito> notacreditos,NotaCredito notacredito,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(NotaCredito notacreditoAux: notacreditos) {
			if(notacreditoAux!=null && notacredito!=null) {
				if((notacreditoAux.getId()==null && notacredito.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(notacreditoAux.getId()!=null && notacredito.getId()!=null){
					if(notacreditoAux.getId().equals(notacredito.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaNotaCredito(List<NotaCredito> notacreditos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double cotizacionTotal=0.0;
		Double descuento_porcentajeTotal=0.0;
		Double total_ivaTotal=0.0;
		Double sumanTotal=0.0;
		Double descuento_valorTotal=0.0;
		Double total_sin_ivaTotal=0.0;
		Double total_descuentoTotal=0.0;
		Double fleteTotal=0.0;
		Double totalTotal=0.0;
		Double sub_totalTotal=0.0;
		Double otroTotal=0.0;
		Double ivaTotal=0.0;
		Double financiamientoTotal=0.0;
		Double iceTotal=0.0;
		Double otro_valorTotal=0.0;
		Double retencionTotal=0.0;
	
		for(NotaCredito notacredito: notacreditos) {			
			if(notacredito.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			cotizacionTotal+=notacredito.getcotizacion();
			descuento_porcentajeTotal+=notacredito.getdescuento_porcentaje();
			total_ivaTotal+=notacredito.gettotal_iva();
			sumanTotal+=notacredito.getsuman();
			descuento_valorTotal+=notacredito.getdescuento_valor();
			total_sin_ivaTotal+=notacredito.gettotal_sin_iva();
			total_descuentoTotal+=notacredito.gettotal_descuento();
			fleteTotal+=notacredito.getflete();
			totalTotal+=notacredito.gettotal();
			sub_totalTotal+=notacredito.getsub_total();
			otroTotal+=notacredito.getotro();
			ivaTotal+=notacredito.getiva();
			financiamientoTotal+=notacredito.getfinanciamiento();
			iceTotal+=notacredito.getice();
			otro_valorTotal+=notacredito.getotro_valor();
			retencionTotal+=notacredito.getretencion();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(NotaCreditoConstantesFunciones.COTIZACION);
		datoGeneral.setsDescripcion(NotaCreditoConstantesFunciones.LABEL_COTIZACION);
		datoGeneral.setdValorDouble(cotizacionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(NotaCreditoConstantesFunciones.DESCUENTOPORCENTAJE);
		datoGeneral.setsDescripcion(NotaCreditoConstantesFunciones.LABEL_DESCUENTOPORCENTAJE);
		datoGeneral.setdValorDouble(descuento_porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(NotaCreditoConstantesFunciones.TOTALIVA);
		datoGeneral.setsDescripcion(NotaCreditoConstantesFunciones.LABEL_TOTALIVA);
		datoGeneral.setdValorDouble(total_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(NotaCreditoConstantesFunciones.SUMAN);
		datoGeneral.setsDescripcion(NotaCreditoConstantesFunciones.LABEL_SUMAN);
		datoGeneral.setdValorDouble(sumanTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(NotaCreditoConstantesFunciones.DESCUENTOVALOR);
		datoGeneral.setsDescripcion(NotaCreditoConstantesFunciones.LABEL_DESCUENTOVALOR);
		datoGeneral.setdValorDouble(descuento_valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(NotaCreditoConstantesFunciones.TOTALSINIVA);
		datoGeneral.setsDescripcion(NotaCreditoConstantesFunciones.LABEL_TOTALSINIVA);
		datoGeneral.setdValorDouble(total_sin_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(NotaCreditoConstantesFunciones.TOTALDESCUENTO);
		datoGeneral.setsDescripcion(NotaCreditoConstantesFunciones.LABEL_TOTALDESCUENTO);
		datoGeneral.setdValorDouble(total_descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(NotaCreditoConstantesFunciones.FLETE);
		datoGeneral.setsDescripcion(NotaCreditoConstantesFunciones.LABEL_FLETE);
		datoGeneral.setdValorDouble(fleteTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(NotaCreditoConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(NotaCreditoConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(NotaCreditoConstantesFunciones.SUBTOTAL);
		datoGeneral.setsDescripcion(NotaCreditoConstantesFunciones.LABEL_SUBTOTAL);
		datoGeneral.setdValorDouble(sub_totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(NotaCreditoConstantesFunciones.OTRO);
		datoGeneral.setsDescripcion(NotaCreditoConstantesFunciones.LABEL_OTRO);
		datoGeneral.setdValorDouble(otroTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(NotaCreditoConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(NotaCreditoConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(NotaCreditoConstantesFunciones.FINANCIAMIENTO);
		datoGeneral.setsDescripcion(NotaCreditoConstantesFunciones.LABEL_FINANCIAMIENTO);
		datoGeneral.setdValorDouble(financiamientoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(NotaCreditoConstantesFunciones.ICE);
		datoGeneral.setsDescripcion(NotaCreditoConstantesFunciones.LABEL_ICE);
		datoGeneral.setdValorDouble(iceTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(NotaCreditoConstantesFunciones.OTROVALOR);
		datoGeneral.setsDescripcion(NotaCreditoConstantesFunciones.LABEL_OTROVALOR);
		datoGeneral.setdValorDouble(otro_valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(NotaCreditoConstantesFunciones.RETENCION);
		datoGeneral.setsDescripcion(NotaCreditoConstantesFunciones.LABEL_RETENCION);
		datoGeneral.setdValorDouble(retencionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaNotaCredito() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,NotaCreditoConstantesFunciones.LABEL_ID, NotaCreditoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoConstantesFunciones.LABEL_VERSIONROW, NotaCreditoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoConstantesFunciones.LABEL_IDEMPRESA, NotaCreditoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoConstantesFunciones.LABEL_IDSUCURSAL, NotaCreditoConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoConstantesFunciones.LABEL_IDEJERCICIO, NotaCreditoConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoConstantesFunciones.LABEL_IDPERIODO, NotaCreditoConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoConstantesFunciones.LABEL_IDANIO, NotaCreditoConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoConstantesFunciones.LABEL_IDMES, NotaCreditoConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoConstantesFunciones.LABEL_IDUSUARIO, NotaCreditoConstantesFunciones.IDUSUARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoConstantesFunciones.LABEL_CODIGO, NotaCreditoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoConstantesFunciones.LABEL_NUMEROPREIMPRESO, NotaCreditoConstantesFunciones.NUMEROPREIMPRESO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoConstantesFunciones.LABEL_FECHAEMISION, NotaCreditoConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoConstantesFunciones.LABEL_NUMERODIAS, NotaCreditoConstantesFunciones.NUMERODIAS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoConstantesFunciones.LABEL_FECHAVENCIMIENTO, NotaCreditoConstantesFunciones.FECHAVENCIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoConstantesFunciones.LABEL_IDMONEDA, NotaCreditoConstantesFunciones.IDMONEDA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoConstantesFunciones.LABEL_COTIZACION, NotaCreditoConstantesFunciones.COTIZACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoConstantesFunciones.LABEL_IDEMPLEADO, NotaCreditoConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoConstantesFunciones.LABEL_IDFORMATO, NotaCreditoConstantesFunciones.IDFORMATO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoConstantesFunciones.LABEL_IDTIPOPRECIO, NotaCreditoConstantesFunciones.IDTIPOPRECIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoConstantesFunciones.LABEL_IDCLIENTE, NotaCreditoConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoConstantesFunciones.LABEL_IDFACTURA, NotaCreditoConstantesFunciones.IDFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoConstantesFunciones.LABEL_DIRECCION, NotaCreditoConstantesFunciones.DIRECCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoConstantesFunciones.LABEL_TELEFONO, NotaCreditoConstantesFunciones.TELEFONO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoConstantesFunciones.LABEL_RUC, NotaCreditoConstantesFunciones.RUC,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoConstantesFunciones.LABEL_IDVENDEDOR, NotaCreditoConstantesFunciones.IDVENDEDOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoConstantesFunciones.LABEL_IDRESPONSABLE, NotaCreditoConstantesFunciones.IDRESPONSABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoConstantesFunciones.LABEL_IDESTADONOTACREDITO, NotaCreditoConstantesFunciones.IDESTADONOTACREDITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoConstantesFunciones.LABEL_DESCRIPCION, NotaCreditoConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoConstantesFunciones.LABEL_DESCUENTOPORCENTAJE, NotaCreditoConstantesFunciones.DESCUENTOPORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoConstantesFunciones.LABEL_TOTALIVA, NotaCreditoConstantesFunciones.TOTALIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoConstantesFunciones.LABEL_SUMAN, NotaCreditoConstantesFunciones.SUMAN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoConstantesFunciones.LABEL_DESCUENTOVALOR, NotaCreditoConstantesFunciones.DESCUENTOVALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoConstantesFunciones.LABEL_TOTALSINIVA, NotaCreditoConstantesFunciones.TOTALSINIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoConstantesFunciones.LABEL_TOTALDESCUENTO, NotaCreditoConstantesFunciones.TOTALDESCUENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoConstantesFunciones.LABEL_FLETE, NotaCreditoConstantesFunciones.FLETE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoConstantesFunciones.LABEL_TOTAL, NotaCreditoConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoConstantesFunciones.LABEL_SUBTOTAL, NotaCreditoConstantesFunciones.SUBTOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoConstantesFunciones.LABEL_OTRO, NotaCreditoConstantesFunciones.OTRO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoConstantesFunciones.LABEL_IVA, NotaCreditoConstantesFunciones.IVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoConstantesFunciones.LABEL_FINANCIAMIENTO, NotaCreditoConstantesFunciones.FINANCIAMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoConstantesFunciones.LABEL_ICE, NotaCreditoConstantesFunciones.ICE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoConstantesFunciones.LABEL_OTROVALOR, NotaCreditoConstantesFunciones.OTROVALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoConstantesFunciones.LABEL_RETENCION, NotaCreditoConstantesFunciones.RETENCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoConstantesFunciones.LABEL_FECHA, NotaCreditoConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoConstantesFunciones.LABEL_ESCLIENTE, NotaCreditoConstantesFunciones.ESCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoConstantesFunciones.LABEL_IDCENTROCOSTO, NotaCreditoConstantesFunciones.IDCENTROCOSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoConstantesFunciones.LABEL_IDTIPOCAMBIO, NotaCreditoConstantesFunciones.IDTIPOCAMBIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoConstantesFunciones.LABEL_IDTRANSPORTE, NotaCreditoConstantesFunciones.IDTRANSPORTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoConstantesFunciones.LABEL_IDTRANSPORTISTA, NotaCreditoConstantesFunciones.IDTRANSPORTISTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoConstantesFunciones.LABEL_FECHACLIENTE, NotaCreditoConstantesFunciones.FECHACLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NotaCreditoConstantesFunciones.LABEL_FECHAAUTORIZACION, NotaCreditoConstantesFunciones.FECHAAUTORIZACION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasNotaCredito() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoConstantesFunciones.IDUSUARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoConstantesFunciones.NUMEROPREIMPRESO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoConstantesFunciones.NUMERODIAS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoConstantesFunciones.FECHAVENCIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoConstantesFunciones.IDMONEDA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoConstantesFunciones.COTIZACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoConstantesFunciones.IDFORMATO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoConstantesFunciones.IDTIPOPRECIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoConstantesFunciones.IDFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoConstantesFunciones.DIRECCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoConstantesFunciones.TELEFONO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoConstantesFunciones.RUC;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoConstantesFunciones.IDVENDEDOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoConstantesFunciones.IDRESPONSABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoConstantesFunciones.IDESTADONOTACREDITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoConstantesFunciones.DESCUENTOPORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoConstantesFunciones.TOTALIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoConstantesFunciones.SUMAN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoConstantesFunciones.DESCUENTOVALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoConstantesFunciones.TOTALSINIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoConstantesFunciones.TOTALDESCUENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoConstantesFunciones.FLETE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoConstantesFunciones.SUBTOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoConstantesFunciones.OTRO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoConstantesFunciones.IVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoConstantesFunciones.FINANCIAMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoConstantesFunciones.ICE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoConstantesFunciones.OTROVALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoConstantesFunciones.RETENCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoConstantesFunciones.ESCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoConstantesFunciones.IDCENTROCOSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoConstantesFunciones.IDTIPOCAMBIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoConstantesFunciones.IDTRANSPORTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoConstantesFunciones.IDTRANSPORTISTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoConstantesFunciones.FECHACLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NotaCreditoConstantesFunciones.FECHAAUTORIZACION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarNotaCredito() throws Exception  {
		return NotaCreditoConstantesFunciones.getTiposSeleccionarNotaCredito(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarNotaCredito(Boolean conFk) throws Exception  {
		return NotaCreditoConstantesFunciones.getTiposSeleccionarNotaCredito(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarNotaCredito(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(NotaCreditoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(NotaCreditoConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(NotaCreditoConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(NotaCreditoConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(NotaCreditoConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(NotaCreditoConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoConstantesFunciones.LABEL_IDUSUARIO);
			reporte.setsDescripcion(NotaCreditoConstantesFunciones.LABEL_IDUSUARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(NotaCreditoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoConstantesFunciones.LABEL_NUMEROPREIMPRESO);
			reporte.setsDescripcion(NotaCreditoConstantesFunciones.LABEL_NUMEROPREIMPRESO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(NotaCreditoConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoConstantesFunciones.LABEL_NUMERODIAS);
			reporte.setsDescripcion(NotaCreditoConstantesFunciones.LABEL_NUMERODIAS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoConstantesFunciones.LABEL_FECHAVENCIMIENTO);
			reporte.setsDescripcion(NotaCreditoConstantesFunciones.LABEL_FECHAVENCIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoConstantesFunciones.LABEL_IDMONEDA);
			reporte.setsDescripcion(NotaCreditoConstantesFunciones.LABEL_IDMONEDA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoConstantesFunciones.LABEL_COTIZACION);
			reporte.setsDescripcion(NotaCreditoConstantesFunciones.LABEL_COTIZACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(NotaCreditoConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoConstantesFunciones.LABEL_IDFORMATO);
			reporte.setsDescripcion(NotaCreditoConstantesFunciones.LABEL_IDFORMATO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoConstantesFunciones.LABEL_IDTIPOPRECIO);
			reporte.setsDescripcion(NotaCreditoConstantesFunciones.LABEL_IDTIPOPRECIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(NotaCreditoConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoConstantesFunciones.LABEL_IDFACTURA);
			reporte.setsDescripcion(NotaCreditoConstantesFunciones.LABEL_IDFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoConstantesFunciones.LABEL_DIRECCION);
			reporte.setsDescripcion(NotaCreditoConstantesFunciones.LABEL_DIRECCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoConstantesFunciones.LABEL_TELEFONO);
			reporte.setsDescripcion(NotaCreditoConstantesFunciones.LABEL_TELEFONO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoConstantesFunciones.LABEL_RUC);
			reporte.setsDescripcion(NotaCreditoConstantesFunciones.LABEL_RUC);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoConstantesFunciones.LABEL_IDVENDEDOR);
			reporte.setsDescripcion(NotaCreditoConstantesFunciones.LABEL_IDVENDEDOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoConstantesFunciones.LABEL_IDRESPONSABLE);
			reporte.setsDescripcion(NotaCreditoConstantesFunciones.LABEL_IDRESPONSABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoConstantesFunciones.LABEL_IDESTADONOTACREDITO);
			reporte.setsDescripcion(NotaCreditoConstantesFunciones.LABEL_IDESTADONOTACREDITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(NotaCreditoConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoConstantesFunciones.LABEL_DESCUENTOPORCENTAJE);
			reporte.setsDescripcion(NotaCreditoConstantesFunciones.LABEL_DESCUENTOPORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoConstantesFunciones.LABEL_TOTALIVA);
			reporte.setsDescripcion(NotaCreditoConstantesFunciones.LABEL_TOTALIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoConstantesFunciones.LABEL_SUMAN);
			reporte.setsDescripcion(NotaCreditoConstantesFunciones.LABEL_SUMAN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoConstantesFunciones.LABEL_DESCUENTOVALOR);
			reporte.setsDescripcion(NotaCreditoConstantesFunciones.LABEL_DESCUENTOVALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoConstantesFunciones.LABEL_TOTALSINIVA);
			reporte.setsDescripcion(NotaCreditoConstantesFunciones.LABEL_TOTALSINIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoConstantesFunciones.LABEL_TOTALDESCUENTO);
			reporte.setsDescripcion(NotaCreditoConstantesFunciones.LABEL_TOTALDESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoConstantesFunciones.LABEL_FLETE);
			reporte.setsDescripcion(NotaCreditoConstantesFunciones.LABEL_FLETE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(NotaCreditoConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoConstantesFunciones.LABEL_SUBTOTAL);
			reporte.setsDescripcion(NotaCreditoConstantesFunciones.LABEL_SUBTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoConstantesFunciones.LABEL_OTRO);
			reporte.setsDescripcion(NotaCreditoConstantesFunciones.LABEL_OTRO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoConstantesFunciones.LABEL_IVA);
			reporte.setsDescripcion(NotaCreditoConstantesFunciones.LABEL_IVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoConstantesFunciones.LABEL_FINANCIAMIENTO);
			reporte.setsDescripcion(NotaCreditoConstantesFunciones.LABEL_FINANCIAMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoConstantesFunciones.LABEL_ICE);
			reporte.setsDescripcion(NotaCreditoConstantesFunciones.LABEL_ICE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoConstantesFunciones.LABEL_OTROVALOR);
			reporte.setsDescripcion(NotaCreditoConstantesFunciones.LABEL_OTROVALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoConstantesFunciones.LABEL_RETENCION);
			reporte.setsDescripcion(NotaCreditoConstantesFunciones.LABEL_RETENCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(NotaCreditoConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoConstantesFunciones.LABEL_ESCLIENTE);
			reporte.setsDescripcion(NotaCreditoConstantesFunciones.LABEL_ESCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoConstantesFunciones.LABEL_IDCENTROCOSTO);
			reporte.setsDescripcion(NotaCreditoConstantesFunciones.LABEL_IDCENTROCOSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoConstantesFunciones.LABEL_IDTIPOCAMBIO);
			reporte.setsDescripcion(NotaCreditoConstantesFunciones.LABEL_IDTIPOCAMBIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoConstantesFunciones.LABEL_IDTRANSPORTE);
			reporte.setsDescripcion(NotaCreditoConstantesFunciones.LABEL_IDTRANSPORTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoConstantesFunciones.LABEL_IDTRANSPORTISTA);
			reporte.setsDescripcion(NotaCreditoConstantesFunciones.LABEL_IDTRANSPORTISTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoConstantesFunciones.LABEL_FECHACLIENTE);
			reporte.setsDescripcion(NotaCreditoConstantesFunciones.LABEL_FECHACLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NotaCreditoConstantesFunciones.LABEL_FECHAAUTORIZACION);
			reporte.setsDescripcion(NotaCreditoConstantesFunciones.LABEL_FECHAAUTORIZACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesNotaCredito(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesNotaCredito(NotaCredito notacreditoAux) throws Exception {
		
			notacreditoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(notacreditoAux.getEmpresa()));
			notacreditoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(notacreditoAux.getSucursal()));
			notacreditoAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(notacreditoAux.getEjercicio()));
			notacreditoAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(notacreditoAux.getPeriodo()));
			notacreditoAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(notacreditoAux.getAnio()));
			notacreditoAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(notacreditoAux.getMes()));
			notacreditoAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(notacreditoAux.getUsuario()));
			notacreditoAux.setmoneda_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(notacreditoAux.getMoneda()));
			notacreditoAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(notacreditoAux.getEmpleado()));
			notacreditoAux.setformato_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(notacreditoAux.getFormato()));
			notacreditoAux.settipoprecio_descripcion(TipoPrecioConstantesFunciones.getTipoPrecioDescripcion(notacreditoAux.getTipoPrecio()));
			notacreditoAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(notacreditoAux.getCliente()));
			notacreditoAux.setfactura_descripcion(FacturaConstantesFunciones.getFacturaDescripcion(notacreditoAux.getFactura()));
			notacreditoAux.setvendedor_descripcion(VendedorConstantesFunciones.getVendedorDescripcion(notacreditoAux.getVendedor()));
			notacreditoAux.setresponsable_descripcion(ResponsableConstantesFunciones.getResponsableDescripcion(notacreditoAux.getResponsable()));
			notacreditoAux.setestadonotacredito_descripcion(EstadoNotaCreditoConstantesFunciones.getEstadoNotaCreditoDescripcion(notacreditoAux.getEstadoNotaCredito()));
			notacreditoAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(notacreditoAux.getCentroCosto()));
			notacreditoAux.settipocambio_descripcion(TipoCambioConstantesFunciones.getTipoCambioDescripcion(notacreditoAux.getTipoCambio()));
			notacreditoAux.settransporte_descripcion(TransporteConstantesFunciones.getTransporteDescripcion(notacreditoAux.getTransporte()));
			notacreditoAux.settransportista_descripcion(TransportistaConstantesFunciones.getTransportistaDescripcion(notacreditoAux.getTransportista()));		
	}
	
	public static void refrescarForeignKeysDescripcionesNotaCredito(List<NotaCredito> notacreditosTemp) throws Exception {
		for(NotaCredito notacreditoAux:notacreditosTemp) {
			
			notacreditoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(notacreditoAux.getEmpresa()));
			notacreditoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(notacreditoAux.getSucursal()));
			notacreditoAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(notacreditoAux.getEjercicio()));
			notacreditoAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(notacreditoAux.getPeriodo()));
			notacreditoAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(notacreditoAux.getAnio()));
			notacreditoAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(notacreditoAux.getMes()));
			notacreditoAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(notacreditoAux.getUsuario()));
			notacreditoAux.setmoneda_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(notacreditoAux.getMoneda()));
			notacreditoAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(notacreditoAux.getEmpleado()));
			notacreditoAux.setformato_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(notacreditoAux.getFormato()));
			notacreditoAux.settipoprecio_descripcion(TipoPrecioConstantesFunciones.getTipoPrecioDescripcion(notacreditoAux.getTipoPrecio()));
			notacreditoAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(notacreditoAux.getCliente()));
			notacreditoAux.setfactura_descripcion(FacturaConstantesFunciones.getFacturaDescripcion(notacreditoAux.getFactura()));
			notacreditoAux.setvendedor_descripcion(VendedorConstantesFunciones.getVendedorDescripcion(notacreditoAux.getVendedor()));
			notacreditoAux.setresponsable_descripcion(ResponsableConstantesFunciones.getResponsableDescripcion(notacreditoAux.getResponsable()));
			notacreditoAux.setestadonotacredito_descripcion(EstadoNotaCreditoConstantesFunciones.getEstadoNotaCreditoDescripcion(notacreditoAux.getEstadoNotaCredito()));
			notacreditoAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(notacreditoAux.getCentroCosto()));
			notacreditoAux.settipocambio_descripcion(TipoCambioConstantesFunciones.getTipoCambioDescripcion(notacreditoAux.getTipoCambio()));
			notacreditoAux.settransporte_descripcion(TransporteConstantesFunciones.getTransporteDescripcion(notacreditoAux.getTransporte()));
			notacreditoAux.settransportista_descripcion(TransportistaConstantesFunciones.getTransportistaDescripcion(notacreditoAux.getTransportista()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfNotaCredito(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
				classes.add(new Classe(Formato.class));
				classes.add(new Classe(TipoPrecio.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(Factura.class));
				classes.add(new Classe(Vendedor.class));
				classes.add(new Classe(Responsable.class));
				classes.add(new Classe(EstadoNotaCredito.class));
				classes.add(new Classe(CentroCosto.class));
				classes.add(new Classe(TipoCambio.class));
				classes.add(new Classe(Transporte.class));
				classes.add(new Classe(Transportista.class));
				
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
					if(clas.clas.equals(Formato.class)) {
						classes.add(new Classe(Formato.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoPrecio.class)) {
						classes.add(new Classe(TipoPrecio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Factura.class)) {
						classes.add(new Classe(Factura.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Vendedor.class)) {
						classes.add(new Classe(Vendedor.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Responsable.class)) {
						classes.add(new Classe(Responsable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EstadoNotaCredito.class)) {
						classes.add(new Classe(EstadoNotaCredito.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CentroCosto.class)) {
						classes.add(new Classe(CentroCosto.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoCambio.class)) {
						classes.add(new Classe(TipoCambio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Transporte.class)) {
						classes.add(new Classe(Transporte.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Transportista.class)) {
						classes.add(new Classe(Transportista.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfNotaCredito(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(TipoPrecio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoPrecio.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Factura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Factura.class)); continue;
					}

					if(Vendedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Vendedor.class)); continue;
					}

					if(Responsable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Responsable.class)); continue;
					}

					if(EstadoNotaCredito.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoNotaCredito.class)); continue;
					}

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
					}

					if(TipoCambio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCambio.class)); continue;
					}

					if(Transporte.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transporte.class)); continue;
					}

					if(Transportista.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transportista.class)); continue;
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

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(TipoPrecio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoPrecio.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Factura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Factura.class)); continue;
					}

					if(Vendedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Vendedor.class)); continue;
					}

					if(Responsable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Responsable.class)); continue;
					}

					if(EstadoNotaCredito.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoNotaCredito.class)); continue;
					}

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
					}

					if(TipoCambio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCambio.class)); continue;
					}

					if(Transporte.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transporte.class)); continue;
					}

					if(Transportista.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transportista.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfNotaCredito(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return NotaCreditoConstantesFunciones.getClassesRelationshipsOfNotaCredito(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfNotaCredito(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(DetaNotaCredito.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(DetaNotaCredito.class)) {
						classes.add(new Classe(DetaNotaCredito.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfNotaCredito(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return NotaCreditoConstantesFunciones.getClassesRelationshipsFromStringsOfNotaCredito(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfNotaCredito(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(DetaNotaCredito.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetaNotaCredito.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(DetaNotaCredito.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetaNotaCredito.class)); continue;
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
	public static void actualizarLista(NotaCredito notacredito,List<NotaCredito> notacreditos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			NotaCredito notacreditoEncontrado=null;
			
			for(NotaCredito notacreditoLocal:notacreditos) {
				if(notacreditoLocal.getId().equals(notacredito.getId())) {
					notacreditoEncontrado=notacreditoLocal;
					
					notacreditoLocal.setIsChanged(notacredito.getIsChanged());
					notacreditoLocal.setIsNew(notacredito.getIsNew());
					notacreditoLocal.setIsDeleted(notacredito.getIsDeleted());
					
					notacreditoLocal.setGeneralEntityOriginal(notacredito.getGeneralEntityOriginal());
					
					notacreditoLocal.setId(notacredito.getId());	
					notacreditoLocal.setVersionRow(notacredito.getVersionRow());	
					notacreditoLocal.setid_empresa(notacredito.getid_empresa());	
					notacreditoLocal.setid_sucursal(notacredito.getid_sucursal());	
					notacreditoLocal.setid_ejercicio(notacredito.getid_ejercicio());	
					notacreditoLocal.setid_periodo(notacredito.getid_periodo());	
					notacreditoLocal.setid_anio(notacredito.getid_anio());	
					notacreditoLocal.setid_mes(notacredito.getid_mes());	
					notacreditoLocal.setid_usuario(notacredito.getid_usuario());	
					notacreditoLocal.setcodigo(notacredito.getcodigo());	
					notacreditoLocal.setnumero(notacredito.getnumero());	
					notacreditoLocal.setfecha_emision(notacredito.getfecha_emision());	
					notacreditoLocal.setnumero_dias(notacredito.getnumero_dias());	
					notacreditoLocal.setfecha_vencimiento(notacredito.getfecha_vencimiento());	
					notacreditoLocal.setid_moneda(notacredito.getid_moneda());	
					notacreditoLocal.setcotizacion(notacredito.getcotizacion());	
					notacreditoLocal.setid_empleado(notacredito.getid_empleado());	
					notacreditoLocal.setid_formato(notacredito.getid_formato());	
					notacreditoLocal.setid_tipo_precio(notacredito.getid_tipo_precio());	
					notacreditoLocal.setid_cliente(notacredito.getid_cliente());	
					notacreditoLocal.setid_factura(notacredito.getid_factura());	
					notacreditoLocal.setdireccion(notacredito.getdireccion());	
					notacreditoLocal.settelefono(notacredito.gettelefono());	
					notacreditoLocal.setruc(notacredito.getruc());	
					notacreditoLocal.setid_vendedor(notacredito.getid_vendedor());	
					notacreditoLocal.setid_responsable(notacredito.getid_responsable());	
					notacreditoLocal.setid_estado_nota_credito(notacredito.getid_estado_nota_credito());	
					notacreditoLocal.setdescripcion(notacredito.getdescripcion());	
					notacreditoLocal.setdescuento_porcentaje(notacredito.getdescuento_porcentaje());	
					notacreditoLocal.settotal_iva(notacredito.gettotal_iva());	
					notacreditoLocal.setsuman(notacredito.getsuman());	
					notacreditoLocal.setdescuento_valor(notacredito.getdescuento_valor());	
					notacreditoLocal.settotal_sin_iva(notacredito.gettotal_sin_iva());	
					notacreditoLocal.settotal_descuento(notacredito.gettotal_descuento());	
					notacreditoLocal.setflete(notacredito.getflete());	
					notacreditoLocal.settotal(notacredito.gettotal());	
					notacreditoLocal.setsub_total(notacredito.getsub_total());	
					notacreditoLocal.setotro(notacredito.getotro());	
					notacreditoLocal.setiva(notacredito.getiva());	
					notacreditoLocal.setfinanciamiento(notacredito.getfinanciamiento());	
					notacreditoLocal.setice(notacredito.getice());	
					notacreditoLocal.setotro_valor(notacredito.getotro_valor());	
					notacreditoLocal.setretencion(notacredito.getretencion());	
					notacreditoLocal.setfecha(notacredito.getfecha());	
					notacreditoLocal.setes_cliente(notacredito.getes_cliente());	
					notacreditoLocal.setid_centro_costo(notacredito.getid_centro_costo());	
					notacreditoLocal.setid_tipo_cambio(notacredito.getid_tipo_cambio());	
					notacreditoLocal.setid_transporte(notacredito.getid_transporte());	
					notacreditoLocal.setid_transportista(notacredito.getid_transportista());	
					notacreditoLocal.setfecha_cliente(notacredito.getfecha_cliente());	
					notacreditoLocal.setfecha_autorizacion(notacredito.getfecha_autorizacion());	
					
					
					notacreditoLocal.setDetaNotaCreditos(notacredito.getDetaNotaCreditos());
					
					existe=true;
					break;
				}
			}
			
			if(!notacredito.getIsDeleted()) {
				if(!existe) {
					notacreditos.add(notacredito);
				}
			} else {
				if(notacreditoEncontrado!=null && permiteQuitar)  {
					notacreditos.remove(notacreditoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(NotaCredito notacredito,List<NotaCredito> notacreditos) throws Exception {
		try	{			
			for(NotaCredito notacreditoLocal:notacreditos) {
				if(notacreditoLocal.getId().equals(notacredito.getId())) {
					notacreditoLocal.setIsSelected(notacredito.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesNotaCredito(List<NotaCredito> notacreditosAux) throws Exception {
		//this.notacreditosAux=notacreditosAux;
		
		for(NotaCredito notacreditoAux:notacreditosAux) {
			if(notacreditoAux.getIsChanged()) {
				notacreditoAux.setIsChanged(false);
			}		
			
			if(notacreditoAux.getIsNew()) {
				notacreditoAux.setIsNew(false);
			}	
			
			if(notacreditoAux.getIsDeleted()) {
				notacreditoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesNotaCredito(NotaCredito notacreditoAux) throws Exception {
		//this.notacreditoAux=notacreditoAux;
		
			if(notacreditoAux.getIsChanged()) {
				notacreditoAux.setIsChanged(false);
			}		
			
			if(notacreditoAux.getIsNew()) {
				notacreditoAux.setIsNew(false);
			}	
			
			if(notacreditoAux.getIsDeleted()) {
				notacreditoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(NotaCredito notacreditoAsignar,NotaCredito notacredito) throws Exception {
		notacreditoAsignar.setId(notacredito.getId());	
		notacreditoAsignar.setVersionRow(notacredito.getVersionRow());	
		notacreditoAsignar.setid_empresa(notacredito.getid_empresa());
		notacreditoAsignar.setempresa_descripcion(notacredito.getempresa_descripcion());	
		notacreditoAsignar.setid_sucursal(notacredito.getid_sucursal());
		notacreditoAsignar.setsucursal_descripcion(notacredito.getsucursal_descripcion());	
		notacreditoAsignar.setid_ejercicio(notacredito.getid_ejercicio());
		notacreditoAsignar.setejercicio_descripcion(notacredito.getejercicio_descripcion());	
		notacreditoAsignar.setid_periodo(notacredito.getid_periodo());
		notacreditoAsignar.setperiodo_descripcion(notacredito.getperiodo_descripcion());	
		notacreditoAsignar.setid_anio(notacredito.getid_anio());
		notacreditoAsignar.setanio_descripcion(notacredito.getanio_descripcion());	
		notacreditoAsignar.setid_mes(notacredito.getid_mes());
		notacreditoAsignar.setmes_descripcion(notacredito.getmes_descripcion());	
		notacreditoAsignar.setid_usuario(notacredito.getid_usuario());
		notacreditoAsignar.setusuario_descripcion(notacredito.getusuario_descripcion());	
		notacreditoAsignar.setcodigo(notacredito.getcodigo());	
		notacreditoAsignar.setnumero(notacredito.getnumero());	
		notacreditoAsignar.setfecha_emision(notacredito.getfecha_emision());	
		notacreditoAsignar.setnumero_dias(notacredito.getnumero_dias());	
		notacreditoAsignar.setfecha_vencimiento(notacredito.getfecha_vencimiento());	
		notacreditoAsignar.setid_moneda(notacredito.getid_moneda());
		notacreditoAsignar.setmoneda_descripcion(notacredito.getmoneda_descripcion());	
		notacreditoAsignar.setcotizacion(notacredito.getcotizacion());	
		notacreditoAsignar.setid_empleado(notacredito.getid_empleado());
		notacreditoAsignar.setempleado_descripcion(notacredito.getempleado_descripcion());	
		notacreditoAsignar.setid_formato(notacredito.getid_formato());
		notacreditoAsignar.setformato_descripcion(notacredito.getformato_descripcion());	
		notacreditoAsignar.setid_tipo_precio(notacredito.getid_tipo_precio());
		notacreditoAsignar.settipoprecio_descripcion(notacredito.gettipoprecio_descripcion());	
		notacreditoAsignar.setid_cliente(notacredito.getid_cliente());
		notacreditoAsignar.setcliente_descripcion(notacredito.getcliente_descripcion());	
		notacreditoAsignar.setid_factura(notacredito.getid_factura());
		notacreditoAsignar.setfactura_descripcion(notacredito.getfactura_descripcion());	
		notacreditoAsignar.setdireccion(notacredito.getdireccion());	
		notacreditoAsignar.settelefono(notacredito.gettelefono());	
		notacreditoAsignar.setruc(notacredito.getruc());	
		notacreditoAsignar.setid_vendedor(notacredito.getid_vendedor());
		notacreditoAsignar.setvendedor_descripcion(notacredito.getvendedor_descripcion());	
		notacreditoAsignar.setid_responsable(notacredito.getid_responsable());
		notacreditoAsignar.setresponsable_descripcion(notacredito.getresponsable_descripcion());	
		notacreditoAsignar.setid_estado_nota_credito(notacredito.getid_estado_nota_credito());
		notacreditoAsignar.setestadonotacredito_descripcion(notacredito.getestadonotacredito_descripcion());	
		notacreditoAsignar.setdescripcion(notacredito.getdescripcion());	
		notacreditoAsignar.setdescuento_porcentaje(notacredito.getdescuento_porcentaje());	
		notacreditoAsignar.settotal_iva(notacredito.gettotal_iva());	
		notacreditoAsignar.setsuman(notacredito.getsuman());	
		notacreditoAsignar.setdescuento_valor(notacredito.getdescuento_valor());	
		notacreditoAsignar.settotal_sin_iva(notacredito.gettotal_sin_iva());	
		notacreditoAsignar.settotal_descuento(notacredito.gettotal_descuento());	
		notacreditoAsignar.setflete(notacredito.getflete());	
		notacreditoAsignar.settotal(notacredito.gettotal());	
		notacreditoAsignar.setsub_total(notacredito.getsub_total());	
		notacreditoAsignar.setotro(notacredito.getotro());	
		notacreditoAsignar.setiva(notacredito.getiva());	
		notacreditoAsignar.setfinanciamiento(notacredito.getfinanciamiento());	
		notacreditoAsignar.setice(notacredito.getice());	
		notacreditoAsignar.setotro_valor(notacredito.getotro_valor());	
		notacreditoAsignar.setretencion(notacredito.getretencion());	
		notacreditoAsignar.setfecha(notacredito.getfecha());	
		notacreditoAsignar.setes_cliente(notacredito.getes_cliente());	
		notacreditoAsignar.setid_centro_costo(notacredito.getid_centro_costo());
		notacreditoAsignar.setcentrocosto_descripcion(notacredito.getcentrocosto_descripcion());	
		notacreditoAsignar.setid_tipo_cambio(notacredito.getid_tipo_cambio());
		notacreditoAsignar.settipocambio_descripcion(notacredito.gettipocambio_descripcion());	
		notacreditoAsignar.setid_transporte(notacredito.getid_transporte());
		notacreditoAsignar.settransporte_descripcion(notacredito.gettransporte_descripcion());	
		notacreditoAsignar.setid_transportista(notacredito.getid_transportista());
		notacreditoAsignar.settransportista_descripcion(notacredito.gettransportista_descripcion());	
		notacreditoAsignar.setfecha_cliente(notacredito.getfecha_cliente());	
		notacreditoAsignar.setfecha_autorizacion(notacredito.getfecha_autorizacion());	
	}
	
	public static void inicializarNotaCredito(NotaCredito notacredito) throws Exception {
		try {
				notacredito.setId(0L);	
					
				notacredito.setid_empresa(-1L);	
				notacredito.setid_sucursal(-1L);	
				notacredito.setid_ejercicio(-1L);	
				notacredito.setid_periodo(-1L);	
				notacredito.setid_anio(null);	
				notacredito.setid_mes(null);	
				notacredito.setid_usuario(-1L);	
				notacredito.setcodigo("");	
				notacredito.setnumero("");	
				notacredito.setfecha_emision(new Date());	
				notacredito.setnumero_dias(0);	
				notacredito.setfecha_vencimiento(new Date());	
				notacredito.setid_moneda(-1L);	
				notacredito.setcotizacion(0.0);	
				notacredito.setid_empleado(-1L);	
				notacredito.setid_formato(null);	
				notacredito.setid_tipo_precio(-1L);	
				notacredito.setid_cliente(-1L);	
				notacredito.setid_factura(-1L);	
				notacredito.setdireccion("");	
				notacredito.settelefono("");	
				notacredito.setruc("");	
				notacredito.setid_vendedor(null);	
				notacredito.setid_responsable(-1L);	
				notacredito.setid_estado_nota_credito(-1L);	
				notacredito.setdescripcion("");	
				notacredito.setdescuento_porcentaje(0.0);	
				notacredito.settotal_iva(0.0);	
				notacredito.setsuman(0.0);	
				notacredito.setdescuento_valor(0.0);	
				notacredito.settotal_sin_iva(0.0);	
				notacredito.settotal_descuento(0.0);	
				notacredito.setflete(0.0);	
				notacredito.settotal(0.0);	
				notacredito.setsub_total(0.0);	
				notacredito.setotro(0.0);	
				notacredito.setiva(0.0);	
				notacredito.setfinanciamiento(0.0);	
				notacredito.setice(0.0);	
				notacredito.setotro_valor(0.0);	
				notacredito.setretencion(0.0);	
				notacredito.setfecha(new Date());	
				notacredito.setes_cliente(false);	
				notacredito.setid_centro_costo(null);	
				notacredito.setid_tipo_cambio(null);	
				notacredito.setid_transporte(null);	
				notacredito.setid_transportista(null);	
				notacredito.setfecha_cliente(new Date());	
				notacredito.setfecha_autorizacion(new Date());	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderNotaCredito(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoConstantesFunciones.LABEL_IDUSUARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoConstantesFunciones.LABEL_NUMEROPREIMPRESO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoConstantesFunciones.LABEL_NUMERODIAS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoConstantesFunciones.LABEL_FECHAVENCIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoConstantesFunciones.LABEL_IDMONEDA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoConstantesFunciones.LABEL_COTIZACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoConstantesFunciones.LABEL_IDFORMATO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoConstantesFunciones.LABEL_IDTIPOPRECIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoConstantesFunciones.LABEL_IDFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoConstantesFunciones.LABEL_DIRECCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoConstantesFunciones.LABEL_TELEFONO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoConstantesFunciones.LABEL_RUC);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoConstantesFunciones.LABEL_IDVENDEDOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoConstantesFunciones.LABEL_IDRESPONSABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoConstantesFunciones.LABEL_IDESTADONOTACREDITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoConstantesFunciones.LABEL_DESCUENTOPORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoConstantesFunciones.LABEL_TOTALIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoConstantesFunciones.LABEL_SUMAN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoConstantesFunciones.LABEL_DESCUENTOVALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoConstantesFunciones.LABEL_TOTALSINIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoConstantesFunciones.LABEL_TOTALDESCUENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoConstantesFunciones.LABEL_FLETE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoConstantesFunciones.LABEL_SUBTOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoConstantesFunciones.LABEL_OTRO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoConstantesFunciones.LABEL_IVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoConstantesFunciones.LABEL_FINANCIAMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoConstantesFunciones.LABEL_ICE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoConstantesFunciones.LABEL_OTROVALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoConstantesFunciones.LABEL_RETENCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoConstantesFunciones.LABEL_ESCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoConstantesFunciones.LABEL_IDCENTROCOSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoConstantesFunciones.LABEL_IDTIPOCAMBIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoConstantesFunciones.LABEL_IDTRANSPORTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoConstantesFunciones.LABEL_IDTRANSPORTISTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoConstantesFunciones.LABEL_FECHACLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NotaCreditoConstantesFunciones.LABEL_FECHAAUTORIZACION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataNotaCredito(String sTipo,Row row,Workbook workbook,NotaCredito notacredito,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(notacredito.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacredito.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacredito.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacredito.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacredito.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacredito.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacredito.getusuario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacredito.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacredito.getnumero());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacredito.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacredito.getnumero_dias());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacredito.getfecha_vencimiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacredito.getmoneda_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacredito.getcotizacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacredito.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacredito.getformato_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacredito.gettipoprecio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacredito.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacredito.getfactura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacredito.getdireccion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacredito.gettelefono());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacredito.getruc());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacredito.getvendedor_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacredito.getresponsable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacredito.getestadonotacredito_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacredito.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacredito.getdescuento_porcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacredito.gettotal_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacredito.getsuman());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacredito.getdescuento_valor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacredito.gettotal_sin_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacredito.gettotal_descuento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacredito.getflete());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacredito.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacredito.getsub_total());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacredito.getotro());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacredito.getiva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacredito.getfinanciamiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacredito.getice());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacredito.getotro_valor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacredito.getretencion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacredito.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(notacredito.getes_cliente()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacredito.getcentrocosto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacredito.gettipocambio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacredito.gettransporte_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacredito.gettransportista_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacredito.getfecha_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(notacredito.getfecha_autorizacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryNotaCredito=Constantes.SFINALQUERY;
	
	public String getsFinalQueryNotaCredito() {
		return this.sFinalQueryNotaCredito;
	}
	
	public void setsFinalQueryNotaCredito(String sFinalQueryNotaCredito) {
		this.sFinalQueryNotaCredito= sFinalQueryNotaCredito;
	}
	
	public Border resaltarSeleccionarNotaCredito=null;
	
	public Border setResaltarSeleccionarNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoBeanSwingJInternalFrame notacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//notacreditoBeanSwingJInternalFrame.jTtoolBarNotaCredito.setBorder(borderResaltar);
		
		this.resaltarSeleccionarNotaCredito= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarNotaCredito() {
		return this.resaltarSeleccionarNotaCredito;
	}
	
	public void setResaltarSeleccionarNotaCredito(Border borderResaltarSeleccionarNotaCredito) {
		this.resaltarSeleccionarNotaCredito= borderResaltarSeleccionarNotaCredito;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridNotaCredito=null;
	public Boolean mostraridNotaCredito=true;
	public Boolean activaridNotaCredito=true;

	public Border resaltarid_empresaNotaCredito=null;
	public Boolean mostrarid_empresaNotaCredito=true;
	public Boolean activarid_empresaNotaCredito=true;
	public Boolean cargarid_empresaNotaCredito=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaNotaCredito=false;//ConEventDepend=true

	public Border resaltarid_sucursalNotaCredito=null;
	public Boolean mostrarid_sucursalNotaCredito=true;
	public Boolean activarid_sucursalNotaCredito=true;
	public Boolean cargarid_sucursalNotaCredito=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalNotaCredito=false;//ConEventDepend=true

	public Border resaltarid_ejercicioNotaCredito=null;
	public Boolean mostrarid_ejercicioNotaCredito=true;
	public Boolean activarid_ejercicioNotaCredito=true;
	public Boolean cargarid_ejercicioNotaCredito=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioNotaCredito=false;//ConEventDepend=true

	public Border resaltarid_periodoNotaCredito=null;
	public Boolean mostrarid_periodoNotaCredito=true;
	public Boolean activarid_periodoNotaCredito=true;
	public Boolean cargarid_periodoNotaCredito=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoNotaCredito=false;//ConEventDepend=true

	public Border resaltarid_anioNotaCredito=null;
	public Boolean mostrarid_anioNotaCredito=true;
	public Boolean activarid_anioNotaCredito=false;
	public Boolean cargarid_anioNotaCredito=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioNotaCredito=false;//ConEventDepend=true

	public Border resaltarid_mesNotaCredito=null;
	public Boolean mostrarid_mesNotaCredito=true;
	public Boolean activarid_mesNotaCredito=false;
	public Boolean cargarid_mesNotaCredito=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesNotaCredito=false;//ConEventDepend=true

	public Border resaltarid_usuarioNotaCredito=null;
	public Boolean mostrarid_usuarioNotaCredito=true;
	public Boolean activarid_usuarioNotaCredito=true;
	public Boolean cargarid_usuarioNotaCredito=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_usuarioNotaCredito=false;//ConEventDepend=true

	public Border resaltarcodigoNotaCredito=null;
	public Boolean mostrarcodigoNotaCredito=true;
	public Boolean activarcodigoNotaCredito=true;

	public Border resaltarnumeroNotaCredito=null;
	public Boolean mostrarnumeroNotaCredito=true;
	public Boolean activarnumeroNotaCredito=true;

	public Border resaltarfecha_emisionNotaCredito=null;
	public Boolean mostrarfecha_emisionNotaCredito=true;
	public Boolean activarfecha_emisionNotaCredito=true;

	public Border resaltarnumero_diasNotaCredito=null;
	public Boolean mostrarnumero_diasNotaCredito=true;
	public Boolean activarnumero_diasNotaCredito=true;

	public Border resaltarfecha_vencimientoNotaCredito=null;
	public Boolean mostrarfecha_vencimientoNotaCredito=true;
	public Boolean activarfecha_vencimientoNotaCredito=true;

	public Border resaltarid_monedaNotaCredito=null;
	public Boolean mostrarid_monedaNotaCredito=true;
	public Boolean activarid_monedaNotaCredito=true;
	public Boolean cargarid_monedaNotaCredito=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_monedaNotaCredito=false;//ConEventDepend=true

	public Border resaltarcotizacionNotaCredito=null;
	public Boolean mostrarcotizacionNotaCredito=true;
	public Boolean activarcotizacionNotaCredito=true;

	public Border resaltarid_empleadoNotaCredito=null;
	public Boolean mostrarid_empleadoNotaCredito=true;
	public Boolean activarid_empleadoNotaCredito=true;
	public Boolean cargarid_empleadoNotaCredito=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoNotaCredito=false;//ConEventDepend=true

	public Border resaltarid_formatoNotaCredito=null;
	public Boolean mostrarid_formatoNotaCredito=true;
	public Boolean activarid_formatoNotaCredito=true;
	public Boolean cargarid_formatoNotaCredito=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formatoNotaCredito=false;//ConEventDepend=true

	public Border resaltarid_tipo_precioNotaCredito=null;
	public Boolean mostrarid_tipo_precioNotaCredito=true;
	public Boolean activarid_tipo_precioNotaCredito=true;
	public Boolean cargarid_tipo_precioNotaCredito=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_precioNotaCredito=false;//ConEventDepend=true

	public Border resaltarid_clienteNotaCredito=null;
	public Boolean mostrarid_clienteNotaCredito=true;
	public Boolean activarid_clienteNotaCredito=true;
	public Boolean cargarid_clienteNotaCredito=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteNotaCredito=false;//ConEventDepend=true

	public Border resaltarid_facturaNotaCredito=null;
	public Boolean mostrarid_facturaNotaCredito=true;
	public Boolean activarid_facturaNotaCredito=true;
	public Boolean cargarid_facturaNotaCredito=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_facturaNotaCredito=false;//ConEventDepend=true

	public Border resaltardireccionNotaCredito=null;
	public Boolean mostrardireccionNotaCredito=true;
	public Boolean activardireccionNotaCredito=true;

	public Border resaltartelefonoNotaCredito=null;
	public Boolean mostrartelefonoNotaCredito=true;
	public Boolean activartelefonoNotaCredito=true;

	public Border resaltarrucNotaCredito=null;
	public Boolean mostrarrucNotaCredito=true;
	public Boolean activarrucNotaCredito=true;

	public Border resaltarid_vendedorNotaCredito=null;
	public Boolean mostrarid_vendedorNotaCredito=true;
	public Boolean activarid_vendedorNotaCredito=true;
	public Boolean cargarid_vendedorNotaCredito=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_vendedorNotaCredito=false;//ConEventDepend=true

	public Border resaltarid_responsableNotaCredito=null;
	public Boolean mostrarid_responsableNotaCredito=true;
	public Boolean activarid_responsableNotaCredito=true;
	public Boolean cargarid_responsableNotaCredito=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_responsableNotaCredito=false;//ConEventDepend=true

	public Border resaltarid_estado_nota_creditoNotaCredito=null;
	public Boolean mostrarid_estado_nota_creditoNotaCredito=true;
	public Boolean activarid_estado_nota_creditoNotaCredito=true;
	public Boolean cargarid_estado_nota_creditoNotaCredito=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_nota_creditoNotaCredito=false;//ConEventDepend=true

	public Border resaltardescripcionNotaCredito=null;
	public Boolean mostrardescripcionNotaCredito=true;
	public Boolean activardescripcionNotaCredito=true;

	public Border resaltardescuento_porcentajeNotaCredito=null;
	public Boolean mostrardescuento_porcentajeNotaCredito=true;
	public Boolean activardescuento_porcentajeNotaCredito=true;

	public Border resaltartotal_ivaNotaCredito=null;
	public Boolean mostrartotal_ivaNotaCredito=true;
	public Boolean activartotal_ivaNotaCredito=true;

	public Border resaltarsumanNotaCredito=null;
	public Boolean mostrarsumanNotaCredito=true;
	public Boolean activarsumanNotaCredito=true;

	public Border resaltardescuento_valorNotaCredito=null;
	public Boolean mostrardescuento_valorNotaCredito=true;
	public Boolean activardescuento_valorNotaCredito=true;

	public Border resaltartotal_sin_ivaNotaCredito=null;
	public Boolean mostrartotal_sin_ivaNotaCredito=true;
	public Boolean activartotal_sin_ivaNotaCredito=true;

	public Border resaltartotal_descuentoNotaCredito=null;
	public Boolean mostrartotal_descuentoNotaCredito=true;
	public Boolean activartotal_descuentoNotaCredito=true;

	public Border resaltarfleteNotaCredito=null;
	public Boolean mostrarfleteNotaCredito=true;
	public Boolean activarfleteNotaCredito=true;

	public Border resaltartotalNotaCredito=null;
	public Boolean mostrartotalNotaCredito=true;
	public Boolean activartotalNotaCredito=true;

	public Border resaltarsub_totalNotaCredito=null;
	public Boolean mostrarsub_totalNotaCredito=true;
	public Boolean activarsub_totalNotaCredito=true;

	public Border resaltarotroNotaCredito=null;
	public Boolean mostrarotroNotaCredito=true;
	public Boolean activarotroNotaCredito=true;

	public Border resaltarivaNotaCredito=null;
	public Boolean mostrarivaNotaCredito=true;
	public Boolean activarivaNotaCredito=true;

	public Border resaltarfinanciamientoNotaCredito=null;
	public Boolean mostrarfinanciamientoNotaCredito=true;
	public Boolean activarfinanciamientoNotaCredito=true;

	public Border resaltariceNotaCredito=null;
	public Boolean mostrariceNotaCredito=true;
	public Boolean activariceNotaCredito=true;

	public Border resaltarotro_valorNotaCredito=null;
	public Boolean mostrarotro_valorNotaCredito=true;
	public Boolean activarotro_valorNotaCredito=true;

	public Border resaltarretencionNotaCredito=null;
	public Boolean mostrarretencionNotaCredito=true;
	public Boolean activarretencionNotaCredito=false;

	public Border resaltarfechaNotaCredito=null;
	public Boolean mostrarfechaNotaCredito=true;
	public Boolean activarfechaNotaCredito=false;

	public Border resaltares_clienteNotaCredito=null;
	public Boolean mostrares_clienteNotaCredito=true;
	public Boolean activares_clienteNotaCredito=false;

	public Border resaltarid_centro_costoNotaCredito=null;
	public Boolean mostrarid_centro_costoNotaCredito=true;
	public Boolean activarid_centro_costoNotaCredito=false;
	public Boolean cargarid_centro_costoNotaCredito=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_centro_costoNotaCredito=false;//ConEventDepend=true

	public Border resaltarid_tipo_cambioNotaCredito=null;
	public Boolean mostrarid_tipo_cambioNotaCredito=true;
	public Boolean activarid_tipo_cambioNotaCredito=false;
	public Boolean cargarid_tipo_cambioNotaCredito=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_cambioNotaCredito=false;//ConEventDepend=true

	public Border resaltarid_transporteNotaCredito=null;
	public Boolean mostrarid_transporteNotaCredito=true;
	public Boolean activarid_transporteNotaCredito=false;
	public Boolean cargarid_transporteNotaCredito=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transporteNotaCredito=false;//ConEventDepend=true

	public Border resaltarid_transportistaNotaCredito=null;
	public Boolean mostrarid_transportistaNotaCredito=true;
	public Boolean activarid_transportistaNotaCredito=false;
	public Boolean cargarid_transportistaNotaCredito=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transportistaNotaCredito=false;//ConEventDepend=true

	public Border resaltarfecha_clienteNotaCredito=null;
	public Boolean mostrarfecha_clienteNotaCredito=true;
	public Boolean activarfecha_clienteNotaCredito=false;

	public Border resaltarfecha_autorizacionNotaCredito=null;
	public Boolean mostrarfecha_autorizacionNotaCredito=true;
	public Boolean activarfecha_autorizacionNotaCredito=false;

	
	

	public Border setResaltaridNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoBeanSwingJInternalFrame notacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditoBeanSwingJInternalFrame.jTtoolBarNotaCredito.setBorder(borderResaltar);
		
		this.resaltaridNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridNotaCredito() {
		return this.resaltaridNotaCredito;
	}

	public void setResaltaridNotaCredito(Border borderResaltar) {
		this.resaltaridNotaCredito= borderResaltar;
	}

	public Boolean getMostraridNotaCredito() {
		return this.mostraridNotaCredito;
	}

	public void setMostraridNotaCredito(Boolean mostraridNotaCredito) {
		this.mostraridNotaCredito= mostraridNotaCredito;
	}

	public Boolean getActivaridNotaCredito() {
		return this.activaridNotaCredito;
	}

	public void setActivaridNotaCredito(Boolean activaridNotaCredito) {
		this.activaridNotaCredito= activaridNotaCredito;
	}

	public Border setResaltarid_empresaNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoBeanSwingJInternalFrame notacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditoBeanSwingJInternalFrame.jTtoolBarNotaCredito.setBorder(borderResaltar);
		
		this.resaltarid_empresaNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaNotaCredito() {
		return this.resaltarid_empresaNotaCredito;
	}

	public void setResaltarid_empresaNotaCredito(Border borderResaltar) {
		this.resaltarid_empresaNotaCredito= borderResaltar;
	}

	public Boolean getMostrarid_empresaNotaCredito() {
		return this.mostrarid_empresaNotaCredito;
	}

	public void setMostrarid_empresaNotaCredito(Boolean mostrarid_empresaNotaCredito) {
		this.mostrarid_empresaNotaCredito= mostrarid_empresaNotaCredito;
	}

	public Boolean getActivarid_empresaNotaCredito() {
		return this.activarid_empresaNotaCredito;
	}

	public void setActivarid_empresaNotaCredito(Boolean activarid_empresaNotaCredito) {
		this.activarid_empresaNotaCredito= activarid_empresaNotaCredito;
	}

	public Boolean getCargarid_empresaNotaCredito() {
		return this.cargarid_empresaNotaCredito;
	}

	public void setCargarid_empresaNotaCredito(Boolean cargarid_empresaNotaCredito) {
		this.cargarid_empresaNotaCredito= cargarid_empresaNotaCredito;
	}

	public Border setResaltarid_sucursalNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoBeanSwingJInternalFrame notacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditoBeanSwingJInternalFrame.jTtoolBarNotaCredito.setBorder(borderResaltar);
		
		this.resaltarid_sucursalNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalNotaCredito() {
		return this.resaltarid_sucursalNotaCredito;
	}

	public void setResaltarid_sucursalNotaCredito(Border borderResaltar) {
		this.resaltarid_sucursalNotaCredito= borderResaltar;
	}

	public Boolean getMostrarid_sucursalNotaCredito() {
		return this.mostrarid_sucursalNotaCredito;
	}

	public void setMostrarid_sucursalNotaCredito(Boolean mostrarid_sucursalNotaCredito) {
		this.mostrarid_sucursalNotaCredito= mostrarid_sucursalNotaCredito;
	}

	public Boolean getActivarid_sucursalNotaCredito() {
		return this.activarid_sucursalNotaCredito;
	}

	public void setActivarid_sucursalNotaCredito(Boolean activarid_sucursalNotaCredito) {
		this.activarid_sucursalNotaCredito= activarid_sucursalNotaCredito;
	}

	public Boolean getCargarid_sucursalNotaCredito() {
		return this.cargarid_sucursalNotaCredito;
	}

	public void setCargarid_sucursalNotaCredito(Boolean cargarid_sucursalNotaCredito) {
		this.cargarid_sucursalNotaCredito= cargarid_sucursalNotaCredito;
	}

	public Border setResaltarid_ejercicioNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoBeanSwingJInternalFrame notacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditoBeanSwingJInternalFrame.jTtoolBarNotaCredito.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioNotaCredito() {
		return this.resaltarid_ejercicioNotaCredito;
	}

	public void setResaltarid_ejercicioNotaCredito(Border borderResaltar) {
		this.resaltarid_ejercicioNotaCredito= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioNotaCredito() {
		return this.mostrarid_ejercicioNotaCredito;
	}

	public void setMostrarid_ejercicioNotaCredito(Boolean mostrarid_ejercicioNotaCredito) {
		this.mostrarid_ejercicioNotaCredito= mostrarid_ejercicioNotaCredito;
	}

	public Boolean getActivarid_ejercicioNotaCredito() {
		return this.activarid_ejercicioNotaCredito;
	}

	public void setActivarid_ejercicioNotaCredito(Boolean activarid_ejercicioNotaCredito) {
		this.activarid_ejercicioNotaCredito= activarid_ejercicioNotaCredito;
	}

	public Boolean getCargarid_ejercicioNotaCredito() {
		return this.cargarid_ejercicioNotaCredito;
	}

	public void setCargarid_ejercicioNotaCredito(Boolean cargarid_ejercicioNotaCredito) {
		this.cargarid_ejercicioNotaCredito= cargarid_ejercicioNotaCredito;
	}

	public Border setResaltarid_periodoNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoBeanSwingJInternalFrame notacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditoBeanSwingJInternalFrame.jTtoolBarNotaCredito.setBorder(borderResaltar);
		
		this.resaltarid_periodoNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoNotaCredito() {
		return this.resaltarid_periodoNotaCredito;
	}

	public void setResaltarid_periodoNotaCredito(Border borderResaltar) {
		this.resaltarid_periodoNotaCredito= borderResaltar;
	}

	public Boolean getMostrarid_periodoNotaCredito() {
		return this.mostrarid_periodoNotaCredito;
	}

	public void setMostrarid_periodoNotaCredito(Boolean mostrarid_periodoNotaCredito) {
		this.mostrarid_periodoNotaCredito= mostrarid_periodoNotaCredito;
	}

	public Boolean getActivarid_periodoNotaCredito() {
		return this.activarid_periodoNotaCredito;
	}

	public void setActivarid_periodoNotaCredito(Boolean activarid_periodoNotaCredito) {
		this.activarid_periodoNotaCredito= activarid_periodoNotaCredito;
	}

	public Boolean getCargarid_periodoNotaCredito() {
		return this.cargarid_periodoNotaCredito;
	}

	public void setCargarid_periodoNotaCredito(Boolean cargarid_periodoNotaCredito) {
		this.cargarid_periodoNotaCredito= cargarid_periodoNotaCredito;
	}

	public Border setResaltarid_anioNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoBeanSwingJInternalFrame notacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditoBeanSwingJInternalFrame.jTtoolBarNotaCredito.setBorder(borderResaltar);
		
		this.resaltarid_anioNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioNotaCredito() {
		return this.resaltarid_anioNotaCredito;
	}

	public void setResaltarid_anioNotaCredito(Border borderResaltar) {
		this.resaltarid_anioNotaCredito= borderResaltar;
	}

	public Boolean getMostrarid_anioNotaCredito() {
		return this.mostrarid_anioNotaCredito;
	}

	public void setMostrarid_anioNotaCredito(Boolean mostrarid_anioNotaCredito) {
		this.mostrarid_anioNotaCredito= mostrarid_anioNotaCredito;
	}

	public Boolean getActivarid_anioNotaCredito() {
		return this.activarid_anioNotaCredito;
	}

	public void setActivarid_anioNotaCredito(Boolean activarid_anioNotaCredito) {
		this.activarid_anioNotaCredito= activarid_anioNotaCredito;
	}

	public Boolean getCargarid_anioNotaCredito() {
		return this.cargarid_anioNotaCredito;
	}

	public void setCargarid_anioNotaCredito(Boolean cargarid_anioNotaCredito) {
		this.cargarid_anioNotaCredito= cargarid_anioNotaCredito;
	}

	public Border setResaltarid_mesNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoBeanSwingJInternalFrame notacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditoBeanSwingJInternalFrame.jTtoolBarNotaCredito.setBorder(borderResaltar);
		
		this.resaltarid_mesNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesNotaCredito() {
		return this.resaltarid_mesNotaCredito;
	}

	public void setResaltarid_mesNotaCredito(Border borderResaltar) {
		this.resaltarid_mesNotaCredito= borderResaltar;
	}

	public Boolean getMostrarid_mesNotaCredito() {
		return this.mostrarid_mesNotaCredito;
	}

	public void setMostrarid_mesNotaCredito(Boolean mostrarid_mesNotaCredito) {
		this.mostrarid_mesNotaCredito= mostrarid_mesNotaCredito;
	}

	public Boolean getActivarid_mesNotaCredito() {
		return this.activarid_mesNotaCredito;
	}

	public void setActivarid_mesNotaCredito(Boolean activarid_mesNotaCredito) {
		this.activarid_mesNotaCredito= activarid_mesNotaCredito;
	}

	public Boolean getCargarid_mesNotaCredito() {
		return this.cargarid_mesNotaCredito;
	}

	public void setCargarid_mesNotaCredito(Boolean cargarid_mesNotaCredito) {
		this.cargarid_mesNotaCredito= cargarid_mesNotaCredito;
	}

	public Border setResaltarid_usuarioNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoBeanSwingJInternalFrame notacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditoBeanSwingJInternalFrame.jTtoolBarNotaCredito.setBorder(borderResaltar);
		
		this.resaltarid_usuarioNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_usuarioNotaCredito() {
		return this.resaltarid_usuarioNotaCredito;
	}

	public void setResaltarid_usuarioNotaCredito(Border borderResaltar) {
		this.resaltarid_usuarioNotaCredito= borderResaltar;
	}

	public Boolean getMostrarid_usuarioNotaCredito() {
		return this.mostrarid_usuarioNotaCredito;
	}

	public void setMostrarid_usuarioNotaCredito(Boolean mostrarid_usuarioNotaCredito) {
		this.mostrarid_usuarioNotaCredito= mostrarid_usuarioNotaCredito;
	}

	public Boolean getActivarid_usuarioNotaCredito() {
		return this.activarid_usuarioNotaCredito;
	}

	public void setActivarid_usuarioNotaCredito(Boolean activarid_usuarioNotaCredito) {
		this.activarid_usuarioNotaCredito= activarid_usuarioNotaCredito;
	}

	public Boolean getCargarid_usuarioNotaCredito() {
		return this.cargarid_usuarioNotaCredito;
	}

	public void setCargarid_usuarioNotaCredito(Boolean cargarid_usuarioNotaCredito) {
		this.cargarid_usuarioNotaCredito= cargarid_usuarioNotaCredito;
	}

	public Border setResaltarcodigoNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoBeanSwingJInternalFrame notacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditoBeanSwingJInternalFrame.jTtoolBarNotaCredito.setBorder(borderResaltar);
		
		this.resaltarcodigoNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoNotaCredito() {
		return this.resaltarcodigoNotaCredito;
	}

	public void setResaltarcodigoNotaCredito(Border borderResaltar) {
		this.resaltarcodigoNotaCredito= borderResaltar;
	}

	public Boolean getMostrarcodigoNotaCredito() {
		return this.mostrarcodigoNotaCredito;
	}

	public void setMostrarcodigoNotaCredito(Boolean mostrarcodigoNotaCredito) {
		this.mostrarcodigoNotaCredito= mostrarcodigoNotaCredito;
	}

	public Boolean getActivarcodigoNotaCredito() {
		return this.activarcodigoNotaCredito;
	}

	public void setActivarcodigoNotaCredito(Boolean activarcodigoNotaCredito) {
		this.activarcodigoNotaCredito= activarcodigoNotaCredito;
	}

	public Border setResaltarnumeroNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoBeanSwingJInternalFrame notacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditoBeanSwingJInternalFrame.jTtoolBarNotaCredito.setBorder(borderResaltar);
		
		this.resaltarnumeroNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumeroNotaCredito() {
		return this.resaltarnumeroNotaCredito;
	}

	public void setResaltarnumeroNotaCredito(Border borderResaltar) {
		this.resaltarnumeroNotaCredito= borderResaltar;
	}

	public Boolean getMostrarnumeroNotaCredito() {
		return this.mostrarnumeroNotaCredito;
	}

	public void setMostrarnumeroNotaCredito(Boolean mostrarnumeroNotaCredito) {
		this.mostrarnumeroNotaCredito= mostrarnumeroNotaCredito;
	}

	public Boolean getActivarnumeroNotaCredito() {
		return this.activarnumeroNotaCredito;
	}

	public void setActivarnumeroNotaCredito(Boolean activarnumeroNotaCredito) {
		this.activarnumeroNotaCredito= activarnumeroNotaCredito;
	}

	public Border setResaltarfecha_emisionNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoBeanSwingJInternalFrame notacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditoBeanSwingJInternalFrame.jTtoolBarNotaCredito.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionNotaCredito() {
		return this.resaltarfecha_emisionNotaCredito;
	}

	public void setResaltarfecha_emisionNotaCredito(Border borderResaltar) {
		this.resaltarfecha_emisionNotaCredito= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionNotaCredito() {
		return this.mostrarfecha_emisionNotaCredito;
	}

	public void setMostrarfecha_emisionNotaCredito(Boolean mostrarfecha_emisionNotaCredito) {
		this.mostrarfecha_emisionNotaCredito= mostrarfecha_emisionNotaCredito;
	}

	public Boolean getActivarfecha_emisionNotaCredito() {
		return this.activarfecha_emisionNotaCredito;
	}

	public void setActivarfecha_emisionNotaCredito(Boolean activarfecha_emisionNotaCredito) {
		this.activarfecha_emisionNotaCredito= activarfecha_emisionNotaCredito;
	}

	public Border setResaltarnumero_diasNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoBeanSwingJInternalFrame notacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditoBeanSwingJInternalFrame.jTtoolBarNotaCredito.setBorder(borderResaltar);
		
		this.resaltarnumero_diasNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_diasNotaCredito() {
		return this.resaltarnumero_diasNotaCredito;
	}

	public void setResaltarnumero_diasNotaCredito(Border borderResaltar) {
		this.resaltarnumero_diasNotaCredito= borderResaltar;
	}

	public Boolean getMostrarnumero_diasNotaCredito() {
		return this.mostrarnumero_diasNotaCredito;
	}

	public void setMostrarnumero_diasNotaCredito(Boolean mostrarnumero_diasNotaCredito) {
		this.mostrarnumero_diasNotaCredito= mostrarnumero_diasNotaCredito;
	}

	public Boolean getActivarnumero_diasNotaCredito() {
		return this.activarnumero_diasNotaCredito;
	}

	public void setActivarnumero_diasNotaCredito(Boolean activarnumero_diasNotaCredito) {
		this.activarnumero_diasNotaCredito= activarnumero_diasNotaCredito;
	}

	public Border setResaltarfecha_vencimientoNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoBeanSwingJInternalFrame notacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditoBeanSwingJInternalFrame.jTtoolBarNotaCredito.setBorder(borderResaltar);
		
		this.resaltarfecha_vencimientoNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_vencimientoNotaCredito() {
		return this.resaltarfecha_vencimientoNotaCredito;
	}

	public void setResaltarfecha_vencimientoNotaCredito(Border borderResaltar) {
		this.resaltarfecha_vencimientoNotaCredito= borderResaltar;
	}

	public Boolean getMostrarfecha_vencimientoNotaCredito() {
		return this.mostrarfecha_vencimientoNotaCredito;
	}

	public void setMostrarfecha_vencimientoNotaCredito(Boolean mostrarfecha_vencimientoNotaCredito) {
		this.mostrarfecha_vencimientoNotaCredito= mostrarfecha_vencimientoNotaCredito;
	}

	public Boolean getActivarfecha_vencimientoNotaCredito() {
		return this.activarfecha_vencimientoNotaCredito;
	}

	public void setActivarfecha_vencimientoNotaCredito(Boolean activarfecha_vencimientoNotaCredito) {
		this.activarfecha_vencimientoNotaCredito= activarfecha_vencimientoNotaCredito;
	}

	public Border setResaltarid_monedaNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoBeanSwingJInternalFrame notacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditoBeanSwingJInternalFrame.jTtoolBarNotaCredito.setBorder(borderResaltar);
		
		this.resaltarid_monedaNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_monedaNotaCredito() {
		return this.resaltarid_monedaNotaCredito;
	}

	public void setResaltarid_monedaNotaCredito(Border borderResaltar) {
		this.resaltarid_monedaNotaCredito= borderResaltar;
	}

	public Boolean getMostrarid_monedaNotaCredito() {
		return this.mostrarid_monedaNotaCredito;
	}

	public void setMostrarid_monedaNotaCredito(Boolean mostrarid_monedaNotaCredito) {
		this.mostrarid_monedaNotaCredito= mostrarid_monedaNotaCredito;
	}

	public Boolean getActivarid_monedaNotaCredito() {
		return this.activarid_monedaNotaCredito;
	}

	public void setActivarid_monedaNotaCredito(Boolean activarid_monedaNotaCredito) {
		this.activarid_monedaNotaCredito= activarid_monedaNotaCredito;
	}

	public Boolean getCargarid_monedaNotaCredito() {
		return this.cargarid_monedaNotaCredito;
	}

	public void setCargarid_monedaNotaCredito(Boolean cargarid_monedaNotaCredito) {
		this.cargarid_monedaNotaCredito= cargarid_monedaNotaCredito;
	}

	public Border setResaltarcotizacionNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoBeanSwingJInternalFrame notacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditoBeanSwingJInternalFrame.jTtoolBarNotaCredito.setBorder(borderResaltar);
		
		this.resaltarcotizacionNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcotizacionNotaCredito() {
		return this.resaltarcotizacionNotaCredito;
	}

	public void setResaltarcotizacionNotaCredito(Border borderResaltar) {
		this.resaltarcotizacionNotaCredito= borderResaltar;
	}

	public Boolean getMostrarcotizacionNotaCredito() {
		return this.mostrarcotizacionNotaCredito;
	}

	public void setMostrarcotizacionNotaCredito(Boolean mostrarcotizacionNotaCredito) {
		this.mostrarcotizacionNotaCredito= mostrarcotizacionNotaCredito;
	}

	public Boolean getActivarcotizacionNotaCredito() {
		return this.activarcotizacionNotaCredito;
	}

	public void setActivarcotizacionNotaCredito(Boolean activarcotizacionNotaCredito) {
		this.activarcotizacionNotaCredito= activarcotizacionNotaCredito;
	}

	public Border setResaltarid_empleadoNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoBeanSwingJInternalFrame notacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditoBeanSwingJInternalFrame.jTtoolBarNotaCredito.setBorder(borderResaltar);
		
		this.resaltarid_empleadoNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoNotaCredito() {
		return this.resaltarid_empleadoNotaCredito;
	}

	public void setResaltarid_empleadoNotaCredito(Border borderResaltar) {
		this.resaltarid_empleadoNotaCredito= borderResaltar;
	}

	public Boolean getMostrarid_empleadoNotaCredito() {
		return this.mostrarid_empleadoNotaCredito;
	}

	public void setMostrarid_empleadoNotaCredito(Boolean mostrarid_empleadoNotaCredito) {
		this.mostrarid_empleadoNotaCredito= mostrarid_empleadoNotaCredito;
	}

	public Boolean getActivarid_empleadoNotaCredito() {
		return this.activarid_empleadoNotaCredito;
	}

	public void setActivarid_empleadoNotaCredito(Boolean activarid_empleadoNotaCredito) {
		this.activarid_empleadoNotaCredito= activarid_empleadoNotaCredito;
	}

	public Boolean getCargarid_empleadoNotaCredito() {
		return this.cargarid_empleadoNotaCredito;
	}

	public void setCargarid_empleadoNotaCredito(Boolean cargarid_empleadoNotaCredito) {
		this.cargarid_empleadoNotaCredito= cargarid_empleadoNotaCredito;
	}

	public Border setResaltarid_formatoNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoBeanSwingJInternalFrame notacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditoBeanSwingJInternalFrame.jTtoolBarNotaCredito.setBorder(borderResaltar);
		
		this.resaltarid_formatoNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formatoNotaCredito() {
		return this.resaltarid_formatoNotaCredito;
	}

	public void setResaltarid_formatoNotaCredito(Border borderResaltar) {
		this.resaltarid_formatoNotaCredito= borderResaltar;
	}

	public Boolean getMostrarid_formatoNotaCredito() {
		return this.mostrarid_formatoNotaCredito;
	}

	public void setMostrarid_formatoNotaCredito(Boolean mostrarid_formatoNotaCredito) {
		this.mostrarid_formatoNotaCredito= mostrarid_formatoNotaCredito;
	}

	public Boolean getActivarid_formatoNotaCredito() {
		return this.activarid_formatoNotaCredito;
	}

	public void setActivarid_formatoNotaCredito(Boolean activarid_formatoNotaCredito) {
		this.activarid_formatoNotaCredito= activarid_formatoNotaCredito;
	}

	public Boolean getCargarid_formatoNotaCredito() {
		return this.cargarid_formatoNotaCredito;
	}

	public void setCargarid_formatoNotaCredito(Boolean cargarid_formatoNotaCredito) {
		this.cargarid_formatoNotaCredito= cargarid_formatoNotaCredito;
	}

	public Border setResaltarid_tipo_precioNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoBeanSwingJInternalFrame notacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditoBeanSwingJInternalFrame.jTtoolBarNotaCredito.setBorder(borderResaltar);
		
		this.resaltarid_tipo_precioNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_precioNotaCredito() {
		return this.resaltarid_tipo_precioNotaCredito;
	}

	public void setResaltarid_tipo_precioNotaCredito(Border borderResaltar) {
		this.resaltarid_tipo_precioNotaCredito= borderResaltar;
	}

	public Boolean getMostrarid_tipo_precioNotaCredito() {
		return this.mostrarid_tipo_precioNotaCredito;
	}

	public void setMostrarid_tipo_precioNotaCredito(Boolean mostrarid_tipo_precioNotaCredito) {
		this.mostrarid_tipo_precioNotaCredito= mostrarid_tipo_precioNotaCredito;
	}

	public Boolean getActivarid_tipo_precioNotaCredito() {
		return this.activarid_tipo_precioNotaCredito;
	}

	public void setActivarid_tipo_precioNotaCredito(Boolean activarid_tipo_precioNotaCredito) {
		this.activarid_tipo_precioNotaCredito= activarid_tipo_precioNotaCredito;
	}

	public Boolean getCargarid_tipo_precioNotaCredito() {
		return this.cargarid_tipo_precioNotaCredito;
	}

	public void setCargarid_tipo_precioNotaCredito(Boolean cargarid_tipo_precioNotaCredito) {
		this.cargarid_tipo_precioNotaCredito= cargarid_tipo_precioNotaCredito;
	}

	public Border setResaltarid_clienteNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoBeanSwingJInternalFrame notacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditoBeanSwingJInternalFrame.jTtoolBarNotaCredito.setBorder(borderResaltar);
		
		this.resaltarid_clienteNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteNotaCredito() {
		return this.resaltarid_clienteNotaCredito;
	}

	public void setResaltarid_clienteNotaCredito(Border borderResaltar) {
		this.resaltarid_clienteNotaCredito= borderResaltar;
	}

	public Boolean getMostrarid_clienteNotaCredito() {
		return this.mostrarid_clienteNotaCredito;
	}

	public void setMostrarid_clienteNotaCredito(Boolean mostrarid_clienteNotaCredito) {
		this.mostrarid_clienteNotaCredito= mostrarid_clienteNotaCredito;
	}

	public Boolean getActivarid_clienteNotaCredito() {
		return this.activarid_clienteNotaCredito;
	}

	public void setActivarid_clienteNotaCredito(Boolean activarid_clienteNotaCredito) {
		this.activarid_clienteNotaCredito= activarid_clienteNotaCredito;
	}

	public Boolean getCargarid_clienteNotaCredito() {
		return this.cargarid_clienteNotaCredito;
	}

	public void setCargarid_clienteNotaCredito(Boolean cargarid_clienteNotaCredito) {
		this.cargarid_clienteNotaCredito= cargarid_clienteNotaCredito;
	}

	public Border setResaltarid_facturaNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoBeanSwingJInternalFrame notacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditoBeanSwingJInternalFrame.jTtoolBarNotaCredito.setBorder(borderResaltar);
		
		this.resaltarid_facturaNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_facturaNotaCredito() {
		return this.resaltarid_facturaNotaCredito;
	}

	public void setResaltarid_facturaNotaCredito(Border borderResaltar) {
		this.resaltarid_facturaNotaCredito= borderResaltar;
	}

	public Boolean getMostrarid_facturaNotaCredito() {
		return this.mostrarid_facturaNotaCredito;
	}

	public void setMostrarid_facturaNotaCredito(Boolean mostrarid_facturaNotaCredito) {
		this.mostrarid_facturaNotaCredito= mostrarid_facturaNotaCredito;
	}

	public Boolean getActivarid_facturaNotaCredito() {
		return this.activarid_facturaNotaCredito;
	}

	public void setActivarid_facturaNotaCredito(Boolean activarid_facturaNotaCredito) {
		this.activarid_facturaNotaCredito= activarid_facturaNotaCredito;
	}

	public Boolean getCargarid_facturaNotaCredito() {
		return this.cargarid_facturaNotaCredito;
	}

	public void setCargarid_facturaNotaCredito(Boolean cargarid_facturaNotaCredito) {
		this.cargarid_facturaNotaCredito= cargarid_facturaNotaCredito;
	}

	public Border setResaltardireccionNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoBeanSwingJInternalFrame notacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditoBeanSwingJInternalFrame.jTtoolBarNotaCredito.setBorder(borderResaltar);
		
		this.resaltardireccionNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardireccionNotaCredito() {
		return this.resaltardireccionNotaCredito;
	}

	public void setResaltardireccionNotaCredito(Border borderResaltar) {
		this.resaltardireccionNotaCredito= borderResaltar;
	}

	public Boolean getMostrardireccionNotaCredito() {
		return this.mostrardireccionNotaCredito;
	}

	public void setMostrardireccionNotaCredito(Boolean mostrardireccionNotaCredito) {
		this.mostrardireccionNotaCredito= mostrardireccionNotaCredito;
	}

	public Boolean getActivardireccionNotaCredito() {
		return this.activardireccionNotaCredito;
	}

	public void setActivardireccionNotaCredito(Boolean activardireccionNotaCredito) {
		this.activardireccionNotaCredito= activardireccionNotaCredito;
	}

	public Border setResaltartelefonoNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoBeanSwingJInternalFrame notacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditoBeanSwingJInternalFrame.jTtoolBarNotaCredito.setBorder(borderResaltar);
		
		this.resaltartelefonoNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartelefonoNotaCredito() {
		return this.resaltartelefonoNotaCredito;
	}

	public void setResaltartelefonoNotaCredito(Border borderResaltar) {
		this.resaltartelefonoNotaCredito= borderResaltar;
	}

	public Boolean getMostrartelefonoNotaCredito() {
		return this.mostrartelefonoNotaCredito;
	}

	public void setMostrartelefonoNotaCredito(Boolean mostrartelefonoNotaCredito) {
		this.mostrartelefonoNotaCredito= mostrartelefonoNotaCredito;
	}

	public Boolean getActivartelefonoNotaCredito() {
		return this.activartelefonoNotaCredito;
	}

	public void setActivartelefonoNotaCredito(Boolean activartelefonoNotaCredito) {
		this.activartelefonoNotaCredito= activartelefonoNotaCredito;
	}

	public Border setResaltarrucNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoBeanSwingJInternalFrame notacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditoBeanSwingJInternalFrame.jTtoolBarNotaCredito.setBorder(borderResaltar);
		
		this.resaltarrucNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarrucNotaCredito() {
		return this.resaltarrucNotaCredito;
	}

	public void setResaltarrucNotaCredito(Border borderResaltar) {
		this.resaltarrucNotaCredito= borderResaltar;
	}

	public Boolean getMostrarrucNotaCredito() {
		return this.mostrarrucNotaCredito;
	}

	public void setMostrarrucNotaCredito(Boolean mostrarrucNotaCredito) {
		this.mostrarrucNotaCredito= mostrarrucNotaCredito;
	}

	public Boolean getActivarrucNotaCredito() {
		return this.activarrucNotaCredito;
	}

	public void setActivarrucNotaCredito(Boolean activarrucNotaCredito) {
		this.activarrucNotaCredito= activarrucNotaCredito;
	}

	public Border setResaltarid_vendedorNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoBeanSwingJInternalFrame notacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditoBeanSwingJInternalFrame.jTtoolBarNotaCredito.setBorder(borderResaltar);
		
		this.resaltarid_vendedorNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_vendedorNotaCredito() {
		return this.resaltarid_vendedorNotaCredito;
	}

	public void setResaltarid_vendedorNotaCredito(Border borderResaltar) {
		this.resaltarid_vendedorNotaCredito= borderResaltar;
	}

	public Boolean getMostrarid_vendedorNotaCredito() {
		return this.mostrarid_vendedorNotaCredito;
	}

	public void setMostrarid_vendedorNotaCredito(Boolean mostrarid_vendedorNotaCredito) {
		this.mostrarid_vendedorNotaCredito= mostrarid_vendedorNotaCredito;
	}

	public Boolean getActivarid_vendedorNotaCredito() {
		return this.activarid_vendedorNotaCredito;
	}

	public void setActivarid_vendedorNotaCredito(Boolean activarid_vendedorNotaCredito) {
		this.activarid_vendedorNotaCredito= activarid_vendedorNotaCredito;
	}

	public Boolean getCargarid_vendedorNotaCredito() {
		return this.cargarid_vendedorNotaCredito;
	}

	public void setCargarid_vendedorNotaCredito(Boolean cargarid_vendedorNotaCredito) {
		this.cargarid_vendedorNotaCredito= cargarid_vendedorNotaCredito;
	}

	public Border setResaltarid_responsableNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoBeanSwingJInternalFrame notacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditoBeanSwingJInternalFrame.jTtoolBarNotaCredito.setBorder(borderResaltar);
		
		this.resaltarid_responsableNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_responsableNotaCredito() {
		return this.resaltarid_responsableNotaCredito;
	}

	public void setResaltarid_responsableNotaCredito(Border borderResaltar) {
		this.resaltarid_responsableNotaCredito= borderResaltar;
	}

	public Boolean getMostrarid_responsableNotaCredito() {
		return this.mostrarid_responsableNotaCredito;
	}

	public void setMostrarid_responsableNotaCredito(Boolean mostrarid_responsableNotaCredito) {
		this.mostrarid_responsableNotaCredito= mostrarid_responsableNotaCredito;
	}

	public Boolean getActivarid_responsableNotaCredito() {
		return this.activarid_responsableNotaCredito;
	}

	public void setActivarid_responsableNotaCredito(Boolean activarid_responsableNotaCredito) {
		this.activarid_responsableNotaCredito= activarid_responsableNotaCredito;
	}

	public Boolean getCargarid_responsableNotaCredito() {
		return this.cargarid_responsableNotaCredito;
	}

	public void setCargarid_responsableNotaCredito(Boolean cargarid_responsableNotaCredito) {
		this.cargarid_responsableNotaCredito= cargarid_responsableNotaCredito;
	}

	public Border setResaltarid_estado_nota_creditoNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoBeanSwingJInternalFrame notacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditoBeanSwingJInternalFrame.jTtoolBarNotaCredito.setBorder(borderResaltar);
		
		this.resaltarid_estado_nota_creditoNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_nota_creditoNotaCredito() {
		return this.resaltarid_estado_nota_creditoNotaCredito;
	}

	public void setResaltarid_estado_nota_creditoNotaCredito(Border borderResaltar) {
		this.resaltarid_estado_nota_creditoNotaCredito= borderResaltar;
	}

	public Boolean getMostrarid_estado_nota_creditoNotaCredito() {
		return this.mostrarid_estado_nota_creditoNotaCredito;
	}

	public void setMostrarid_estado_nota_creditoNotaCredito(Boolean mostrarid_estado_nota_creditoNotaCredito) {
		this.mostrarid_estado_nota_creditoNotaCredito= mostrarid_estado_nota_creditoNotaCredito;
	}

	public Boolean getActivarid_estado_nota_creditoNotaCredito() {
		return this.activarid_estado_nota_creditoNotaCredito;
	}

	public void setActivarid_estado_nota_creditoNotaCredito(Boolean activarid_estado_nota_creditoNotaCredito) {
		this.activarid_estado_nota_creditoNotaCredito= activarid_estado_nota_creditoNotaCredito;
	}

	public Boolean getCargarid_estado_nota_creditoNotaCredito() {
		return this.cargarid_estado_nota_creditoNotaCredito;
	}

	public void setCargarid_estado_nota_creditoNotaCredito(Boolean cargarid_estado_nota_creditoNotaCredito) {
		this.cargarid_estado_nota_creditoNotaCredito= cargarid_estado_nota_creditoNotaCredito;
	}

	public Border setResaltardescripcionNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoBeanSwingJInternalFrame notacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditoBeanSwingJInternalFrame.jTtoolBarNotaCredito.setBorder(borderResaltar);
		
		this.resaltardescripcionNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionNotaCredito() {
		return this.resaltardescripcionNotaCredito;
	}

	public void setResaltardescripcionNotaCredito(Border borderResaltar) {
		this.resaltardescripcionNotaCredito= borderResaltar;
	}

	public Boolean getMostrardescripcionNotaCredito() {
		return this.mostrardescripcionNotaCredito;
	}

	public void setMostrardescripcionNotaCredito(Boolean mostrardescripcionNotaCredito) {
		this.mostrardescripcionNotaCredito= mostrardescripcionNotaCredito;
	}

	public Boolean getActivardescripcionNotaCredito() {
		return this.activardescripcionNotaCredito;
	}

	public void setActivardescripcionNotaCredito(Boolean activardescripcionNotaCredito) {
		this.activardescripcionNotaCredito= activardescripcionNotaCredito;
	}

	public Border setResaltardescuento_porcentajeNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoBeanSwingJInternalFrame notacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditoBeanSwingJInternalFrame.jTtoolBarNotaCredito.setBorder(borderResaltar);
		
		this.resaltardescuento_porcentajeNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuento_porcentajeNotaCredito() {
		return this.resaltardescuento_porcentajeNotaCredito;
	}

	public void setResaltardescuento_porcentajeNotaCredito(Border borderResaltar) {
		this.resaltardescuento_porcentajeNotaCredito= borderResaltar;
	}

	public Boolean getMostrardescuento_porcentajeNotaCredito() {
		return this.mostrardescuento_porcentajeNotaCredito;
	}

	public void setMostrardescuento_porcentajeNotaCredito(Boolean mostrardescuento_porcentajeNotaCredito) {
		this.mostrardescuento_porcentajeNotaCredito= mostrardescuento_porcentajeNotaCredito;
	}

	public Boolean getActivardescuento_porcentajeNotaCredito() {
		return this.activardescuento_porcentajeNotaCredito;
	}

	public void setActivardescuento_porcentajeNotaCredito(Boolean activardescuento_porcentajeNotaCredito) {
		this.activardescuento_porcentajeNotaCredito= activardescuento_porcentajeNotaCredito;
	}

	public Border setResaltartotal_ivaNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoBeanSwingJInternalFrame notacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditoBeanSwingJInternalFrame.jTtoolBarNotaCredito.setBorder(borderResaltar);
		
		this.resaltartotal_ivaNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_ivaNotaCredito() {
		return this.resaltartotal_ivaNotaCredito;
	}

	public void setResaltartotal_ivaNotaCredito(Border borderResaltar) {
		this.resaltartotal_ivaNotaCredito= borderResaltar;
	}

	public Boolean getMostrartotal_ivaNotaCredito() {
		return this.mostrartotal_ivaNotaCredito;
	}

	public void setMostrartotal_ivaNotaCredito(Boolean mostrartotal_ivaNotaCredito) {
		this.mostrartotal_ivaNotaCredito= mostrartotal_ivaNotaCredito;
	}

	public Boolean getActivartotal_ivaNotaCredito() {
		return this.activartotal_ivaNotaCredito;
	}

	public void setActivartotal_ivaNotaCredito(Boolean activartotal_ivaNotaCredito) {
		this.activartotal_ivaNotaCredito= activartotal_ivaNotaCredito;
	}

	public Border setResaltarsumanNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoBeanSwingJInternalFrame notacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditoBeanSwingJInternalFrame.jTtoolBarNotaCredito.setBorder(borderResaltar);
		
		this.resaltarsumanNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsumanNotaCredito() {
		return this.resaltarsumanNotaCredito;
	}

	public void setResaltarsumanNotaCredito(Border borderResaltar) {
		this.resaltarsumanNotaCredito= borderResaltar;
	}

	public Boolean getMostrarsumanNotaCredito() {
		return this.mostrarsumanNotaCredito;
	}

	public void setMostrarsumanNotaCredito(Boolean mostrarsumanNotaCredito) {
		this.mostrarsumanNotaCredito= mostrarsumanNotaCredito;
	}

	public Boolean getActivarsumanNotaCredito() {
		return this.activarsumanNotaCredito;
	}

	public void setActivarsumanNotaCredito(Boolean activarsumanNotaCredito) {
		this.activarsumanNotaCredito= activarsumanNotaCredito;
	}

	public Border setResaltardescuento_valorNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoBeanSwingJInternalFrame notacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditoBeanSwingJInternalFrame.jTtoolBarNotaCredito.setBorder(borderResaltar);
		
		this.resaltardescuento_valorNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuento_valorNotaCredito() {
		return this.resaltardescuento_valorNotaCredito;
	}

	public void setResaltardescuento_valorNotaCredito(Border borderResaltar) {
		this.resaltardescuento_valorNotaCredito= borderResaltar;
	}

	public Boolean getMostrardescuento_valorNotaCredito() {
		return this.mostrardescuento_valorNotaCredito;
	}

	public void setMostrardescuento_valorNotaCredito(Boolean mostrardescuento_valorNotaCredito) {
		this.mostrardescuento_valorNotaCredito= mostrardescuento_valorNotaCredito;
	}

	public Boolean getActivardescuento_valorNotaCredito() {
		return this.activardescuento_valorNotaCredito;
	}

	public void setActivardescuento_valorNotaCredito(Boolean activardescuento_valorNotaCredito) {
		this.activardescuento_valorNotaCredito= activardescuento_valorNotaCredito;
	}

	public Border setResaltartotal_sin_ivaNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoBeanSwingJInternalFrame notacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditoBeanSwingJInternalFrame.jTtoolBarNotaCredito.setBorder(borderResaltar);
		
		this.resaltartotal_sin_ivaNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_sin_ivaNotaCredito() {
		return this.resaltartotal_sin_ivaNotaCredito;
	}

	public void setResaltartotal_sin_ivaNotaCredito(Border borderResaltar) {
		this.resaltartotal_sin_ivaNotaCredito= borderResaltar;
	}

	public Boolean getMostrartotal_sin_ivaNotaCredito() {
		return this.mostrartotal_sin_ivaNotaCredito;
	}

	public void setMostrartotal_sin_ivaNotaCredito(Boolean mostrartotal_sin_ivaNotaCredito) {
		this.mostrartotal_sin_ivaNotaCredito= mostrartotal_sin_ivaNotaCredito;
	}

	public Boolean getActivartotal_sin_ivaNotaCredito() {
		return this.activartotal_sin_ivaNotaCredito;
	}

	public void setActivartotal_sin_ivaNotaCredito(Boolean activartotal_sin_ivaNotaCredito) {
		this.activartotal_sin_ivaNotaCredito= activartotal_sin_ivaNotaCredito;
	}

	public Border setResaltartotal_descuentoNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoBeanSwingJInternalFrame notacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditoBeanSwingJInternalFrame.jTtoolBarNotaCredito.setBorder(borderResaltar);
		
		this.resaltartotal_descuentoNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_descuentoNotaCredito() {
		return this.resaltartotal_descuentoNotaCredito;
	}

	public void setResaltartotal_descuentoNotaCredito(Border borderResaltar) {
		this.resaltartotal_descuentoNotaCredito= borderResaltar;
	}

	public Boolean getMostrartotal_descuentoNotaCredito() {
		return this.mostrartotal_descuentoNotaCredito;
	}

	public void setMostrartotal_descuentoNotaCredito(Boolean mostrartotal_descuentoNotaCredito) {
		this.mostrartotal_descuentoNotaCredito= mostrartotal_descuentoNotaCredito;
	}

	public Boolean getActivartotal_descuentoNotaCredito() {
		return this.activartotal_descuentoNotaCredito;
	}

	public void setActivartotal_descuentoNotaCredito(Boolean activartotal_descuentoNotaCredito) {
		this.activartotal_descuentoNotaCredito= activartotal_descuentoNotaCredito;
	}

	public Border setResaltarfleteNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoBeanSwingJInternalFrame notacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditoBeanSwingJInternalFrame.jTtoolBarNotaCredito.setBorder(borderResaltar);
		
		this.resaltarfleteNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfleteNotaCredito() {
		return this.resaltarfleteNotaCredito;
	}

	public void setResaltarfleteNotaCredito(Border borderResaltar) {
		this.resaltarfleteNotaCredito= borderResaltar;
	}

	public Boolean getMostrarfleteNotaCredito() {
		return this.mostrarfleteNotaCredito;
	}

	public void setMostrarfleteNotaCredito(Boolean mostrarfleteNotaCredito) {
		this.mostrarfleteNotaCredito= mostrarfleteNotaCredito;
	}

	public Boolean getActivarfleteNotaCredito() {
		return this.activarfleteNotaCredito;
	}

	public void setActivarfleteNotaCredito(Boolean activarfleteNotaCredito) {
		this.activarfleteNotaCredito= activarfleteNotaCredito;
	}

	public Border setResaltartotalNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoBeanSwingJInternalFrame notacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditoBeanSwingJInternalFrame.jTtoolBarNotaCredito.setBorder(borderResaltar);
		
		this.resaltartotalNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalNotaCredito() {
		return this.resaltartotalNotaCredito;
	}

	public void setResaltartotalNotaCredito(Border borderResaltar) {
		this.resaltartotalNotaCredito= borderResaltar;
	}

	public Boolean getMostrartotalNotaCredito() {
		return this.mostrartotalNotaCredito;
	}

	public void setMostrartotalNotaCredito(Boolean mostrartotalNotaCredito) {
		this.mostrartotalNotaCredito= mostrartotalNotaCredito;
	}

	public Boolean getActivartotalNotaCredito() {
		return this.activartotalNotaCredito;
	}

	public void setActivartotalNotaCredito(Boolean activartotalNotaCredito) {
		this.activartotalNotaCredito= activartotalNotaCredito;
	}

	public Border setResaltarsub_totalNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoBeanSwingJInternalFrame notacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditoBeanSwingJInternalFrame.jTtoolBarNotaCredito.setBorder(borderResaltar);
		
		this.resaltarsub_totalNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsub_totalNotaCredito() {
		return this.resaltarsub_totalNotaCredito;
	}

	public void setResaltarsub_totalNotaCredito(Border borderResaltar) {
		this.resaltarsub_totalNotaCredito= borderResaltar;
	}

	public Boolean getMostrarsub_totalNotaCredito() {
		return this.mostrarsub_totalNotaCredito;
	}

	public void setMostrarsub_totalNotaCredito(Boolean mostrarsub_totalNotaCredito) {
		this.mostrarsub_totalNotaCredito= mostrarsub_totalNotaCredito;
	}

	public Boolean getActivarsub_totalNotaCredito() {
		return this.activarsub_totalNotaCredito;
	}

	public void setActivarsub_totalNotaCredito(Boolean activarsub_totalNotaCredito) {
		this.activarsub_totalNotaCredito= activarsub_totalNotaCredito;
	}

	public Border setResaltarotroNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoBeanSwingJInternalFrame notacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditoBeanSwingJInternalFrame.jTtoolBarNotaCredito.setBorder(borderResaltar);
		
		this.resaltarotroNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarotroNotaCredito() {
		return this.resaltarotroNotaCredito;
	}

	public void setResaltarotroNotaCredito(Border borderResaltar) {
		this.resaltarotroNotaCredito= borderResaltar;
	}

	public Boolean getMostrarotroNotaCredito() {
		return this.mostrarotroNotaCredito;
	}

	public void setMostrarotroNotaCredito(Boolean mostrarotroNotaCredito) {
		this.mostrarotroNotaCredito= mostrarotroNotaCredito;
	}

	public Boolean getActivarotroNotaCredito() {
		return this.activarotroNotaCredito;
	}

	public void setActivarotroNotaCredito(Boolean activarotroNotaCredito) {
		this.activarotroNotaCredito= activarotroNotaCredito;
	}

	public Border setResaltarivaNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoBeanSwingJInternalFrame notacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditoBeanSwingJInternalFrame.jTtoolBarNotaCredito.setBorder(borderResaltar);
		
		this.resaltarivaNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarivaNotaCredito() {
		return this.resaltarivaNotaCredito;
	}

	public void setResaltarivaNotaCredito(Border borderResaltar) {
		this.resaltarivaNotaCredito= borderResaltar;
	}

	public Boolean getMostrarivaNotaCredito() {
		return this.mostrarivaNotaCredito;
	}

	public void setMostrarivaNotaCredito(Boolean mostrarivaNotaCredito) {
		this.mostrarivaNotaCredito= mostrarivaNotaCredito;
	}

	public Boolean getActivarivaNotaCredito() {
		return this.activarivaNotaCredito;
	}

	public void setActivarivaNotaCredito(Boolean activarivaNotaCredito) {
		this.activarivaNotaCredito= activarivaNotaCredito;
	}

	public Border setResaltarfinanciamientoNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoBeanSwingJInternalFrame notacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditoBeanSwingJInternalFrame.jTtoolBarNotaCredito.setBorder(borderResaltar);
		
		this.resaltarfinanciamientoNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfinanciamientoNotaCredito() {
		return this.resaltarfinanciamientoNotaCredito;
	}

	public void setResaltarfinanciamientoNotaCredito(Border borderResaltar) {
		this.resaltarfinanciamientoNotaCredito= borderResaltar;
	}

	public Boolean getMostrarfinanciamientoNotaCredito() {
		return this.mostrarfinanciamientoNotaCredito;
	}

	public void setMostrarfinanciamientoNotaCredito(Boolean mostrarfinanciamientoNotaCredito) {
		this.mostrarfinanciamientoNotaCredito= mostrarfinanciamientoNotaCredito;
	}

	public Boolean getActivarfinanciamientoNotaCredito() {
		return this.activarfinanciamientoNotaCredito;
	}

	public void setActivarfinanciamientoNotaCredito(Boolean activarfinanciamientoNotaCredito) {
		this.activarfinanciamientoNotaCredito= activarfinanciamientoNotaCredito;
	}

	public Border setResaltariceNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoBeanSwingJInternalFrame notacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditoBeanSwingJInternalFrame.jTtoolBarNotaCredito.setBorder(borderResaltar);
		
		this.resaltariceNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltariceNotaCredito() {
		return this.resaltariceNotaCredito;
	}

	public void setResaltariceNotaCredito(Border borderResaltar) {
		this.resaltariceNotaCredito= borderResaltar;
	}

	public Boolean getMostrariceNotaCredito() {
		return this.mostrariceNotaCredito;
	}

	public void setMostrariceNotaCredito(Boolean mostrariceNotaCredito) {
		this.mostrariceNotaCredito= mostrariceNotaCredito;
	}

	public Boolean getActivariceNotaCredito() {
		return this.activariceNotaCredito;
	}

	public void setActivariceNotaCredito(Boolean activariceNotaCredito) {
		this.activariceNotaCredito= activariceNotaCredito;
	}

	public Border setResaltarotro_valorNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoBeanSwingJInternalFrame notacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditoBeanSwingJInternalFrame.jTtoolBarNotaCredito.setBorder(borderResaltar);
		
		this.resaltarotro_valorNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarotro_valorNotaCredito() {
		return this.resaltarotro_valorNotaCredito;
	}

	public void setResaltarotro_valorNotaCredito(Border borderResaltar) {
		this.resaltarotro_valorNotaCredito= borderResaltar;
	}

	public Boolean getMostrarotro_valorNotaCredito() {
		return this.mostrarotro_valorNotaCredito;
	}

	public void setMostrarotro_valorNotaCredito(Boolean mostrarotro_valorNotaCredito) {
		this.mostrarotro_valorNotaCredito= mostrarotro_valorNotaCredito;
	}

	public Boolean getActivarotro_valorNotaCredito() {
		return this.activarotro_valorNotaCredito;
	}

	public void setActivarotro_valorNotaCredito(Boolean activarotro_valorNotaCredito) {
		this.activarotro_valorNotaCredito= activarotro_valorNotaCredito;
	}

	public Border setResaltarretencionNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoBeanSwingJInternalFrame notacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditoBeanSwingJInternalFrame.jTtoolBarNotaCredito.setBorder(borderResaltar);
		
		this.resaltarretencionNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarretencionNotaCredito() {
		return this.resaltarretencionNotaCredito;
	}

	public void setResaltarretencionNotaCredito(Border borderResaltar) {
		this.resaltarretencionNotaCredito= borderResaltar;
	}

	public Boolean getMostrarretencionNotaCredito() {
		return this.mostrarretencionNotaCredito;
	}

	public void setMostrarretencionNotaCredito(Boolean mostrarretencionNotaCredito) {
		this.mostrarretencionNotaCredito= mostrarretencionNotaCredito;
	}

	public Boolean getActivarretencionNotaCredito() {
		return this.activarretencionNotaCredito;
	}

	public void setActivarretencionNotaCredito(Boolean activarretencionNotaCredito) {
		this.activarretencionNotaCredito= activarretencionNotaCredito;
	}

	public Border setResaltarfechaNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoBeanSwingJInternalFrame notacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditoBeanSwingJInternalFrame.jTtoolBarNotaCredito.setBorder(borderResaltar);
		
		this.resaltarfechaNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaNotaCredito() {
		return this.resaltarfechaNotaCredito;
	}

	public void setResaltarfechaNotaCredito(Border borderResaltar) {
		this.resaltarfechaNotaCredito= borderResaltar;
	}

	public Boolean getMostrarfechaNotaCredito() {
		return this.mostrarfechaNotaCredito;
	}

	public void setMostrarfechaNotaCredito(Boolean mostrarfechaNotaCredito) {
		this.mostrarfechaNotaCredito= mostrarfechaNotaCredito;
	}

	public Boolean getActivarfechaNotaCredito() {
		return this.activarfechaNotaCredito;
	}

	public void setActivarfechaNotaCredito(Boolean activarfechaNotaCredito) {
		this.activarfechaNotaCredito= activarfechaNotaCredito;
	}

	public Border setResaltares_clienteNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoBeanSwingJInternalFrame notacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditoBeanSwingJInternalFrame.jTtoolBarNotaCredito.setBorder(borderResaltar);
		
		this.resaltares_clienteNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_clienteNotaCredito() {
		return this.resaltares_clienteNotaCredito;
	}

	public void setResaltares_clienteNotaCredito(Border borderResaltar) {
		this.resaltares_clienteNotaCredito= borderResaltar;
	}

	public Boolean getMostrares_clienteNotaCredito() {
		return this.mostrares_clienteNotaCredito;
	}

	public void setMostrares_clienteNotaCredito(Boolean mostrares_clienteNotaCredito) {
		this.mostrares_clienteNotaCredito= mostrares_clienteNotaCredito;
	}

	public Boolean getActivares_clienteNotaCredito() {
		return this.activares_clienteNotaCredito;
	}

	public void setActivares_clienteNotaCredito(Boolean activares_clienteNotaCredito) {
		this.activares_clienteNotaCredito= activares_clienteNotaCredito;
	}

	public Border setResaltarid_centro_costoNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoBeanSwingJInternalFrame notacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditoBeanSwingJInternalFrame.jTtoolBarNotaCredito.setBorder(borderResaltar);
		
		this.resaltarid_centro_costoNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_centro_costoNotaCredito() {
		return this.resaltarid_centro_costoNotaCredito;
	}

	public void setResaltarid_centro_costoNotaCredito(Border borderResaltar) {
		this.resaltarid_centro_costoNotaCredito= borderResaltar;
	}

	public Boolean getMostrarid_centro_costoNotaCredito() {
		return this.mostrarid_centro_costoNotaCredito;
	}

	public void setMostrarid_centro_costoNotaCredito(Boolean mostrarid_centro_costoNotaCredito) {
		this.mostrarid_centro_costoNotaCredito= mostrarid_centro_costoNotaCredito;
	}

	public Boolean getActivarid_centro_costoNotaCredito() {
		return this.activarid_centro_costoNotaCredito;
	}

	public void setActivarid_centro_costoNotaCredito(Boolean activarid_centro_costoNotaCredito) {
		this.activarid_centro_costoNotaCredito= activarid_centro_costoNotaCredito;
	}

	public Boolean getCargarid_centro_costoNotaCredito() {
		return this.cargarid_centro_costoNotaCredito;
	}

	public void setCargarid_centro_costoNotaCredito(Boolean cargarid_centro_costoNotaCredito) {
		this.cargarid_centro_costoNotaCredito= cargarid_centro_costoNotaCredito;
	}

	public Border setResaltarid_tipo_cambioNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoBeanSwingJInternalFrame notacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditoBeanSwingJInternalFrame.jTtoolBarNotaCredito.setBorder(borderResaltar);
		
		this.resaltarid_tipo_cambioNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_cambioNotaCredito() {
		return this.resaltarid_tipo_cambioNotaCredito;
	}

	public void setResaltarid_tipo_cambioNotaCredito(Border borderResaltar) {
		this.resaltarid_tipo_cambioNotaCredito= borderResaltar;
	}

	public Boolean getMostrarid_tipo_cambioNotaCredito() {
		return this.mostrarid_tipo_cambioNotaCredito;
	}

	public void setMostrarid_tipo_cambioNotaCredito(Boolean mostrarid_tipo_cambioNotaCredito) {
		this.mostrarid_tipo_cambioNotaCredito= mostrarid_tipo_cambioNotaCredito;
	}

	public Boolean getActivarid_tipo_cambioNotaCredito() {
		return this.activarid_tipo_cambioNotaCredito;
	}

	public void setActivarid_tipo_cambioNotaCredito(Boolean activarid_tipo_cambioNotaCredito) {
		this.activarid_tipo_cambioNotaCredito= activarid_tipo_cambioNotaCredito;
	}

	public Boolean getCargarid_tipo_cambioNotaCredito() {
		return this.cargarid_tipo_cambioNotaCredito;
	}

	public void setCargarid_tipo_cambioNotaCredito(Boolean cargarid_tipo_cambioNotaCredito) {
		this.cargarid_tipo_cambioNotaCredito= cargarid_tipo_cambioNotaCredito;
	}

	public Border setResaltarid_transporteNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoBeanSwingJInternalFrame notacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditoBeanSwingJInternalFrame.jTtoolBarNotaCredito.setBorder(borderResaltar);
		
		this.resaltarid_transporteNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transporteNotaCredito() {
		return this.resaltarid_transporteNotaCredito;
	}

	public void setResaltarid_transporteNotaCredito(Border borderResaltar) {
		this.resaltarid_transporteNotaCredito= borderResaltar;
	}

	public Boolean getMostrarid_transporteNotaCredito() {
		return this.mostrarid_transporteNotaCredito;
	}

	public void setMostrarid_transporteNotaCredito(Boolean mostrarid_transporteNotaCredito) {
		this.mostrarid_transporteNotaCredito= mostrarid_transporteNotaCredito;
	}

	public Boolean getActivarid_transporteNotaCredito() {
		return this.activarid_transporteNotaCredito;
	}

	public void setActivarid_transporteNotaCredito(Boolean activarid_transporteNotaCredito) {
		this.activarid_transporteNotaCredito= activarid_transporteNotaCredito;
	}

	public Boolean getCargarid_transporteNotaCredito() {
		return this.cargarid_transporteNotaCredito;
	}

	public void setCargarid_transporteNotaCredito(Boolean cargarid_transporteNotaCredito) {
		this.cargarid_transporteNotaCredito= cargarid_transporteNotaCredito;
	}

	public Border setResaltarid_transportistaNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoBeanSwingJInternalFrame notacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditoBeanSwingJInternalFrame.jTtoolBarNotaCredito.setBorder(borderResaltar);
		
		this.resaltarid_transportistaNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transportistaNotaCredito() {
		return this.resaltarid_transportistaNotaCredito;
	}

	public void setResaltarid_transportistaNotaCredito(Border borderResaltar) {
		this.resaltarid_transportistaNotaCredito= borderResaltar;
	}

	public Boolean getMostrarid_transportistaNotaCredito() {
		return this.mostrarid_transportistaNotaCredito;
	}

	public void setMostrarid_transportistaNotaCredito(Boolean mostrarid_transportistaNotaCredito) {
		this.mostrarid_transportistaNotaCredito= mostrarid_transportistaNotaCredito;
	}

	public Boolean getActivarid_transportistaNotaCredito() {
		return this.activarid_transportistaNotaCredito;
	}

	public void setActivarid_transportistaNotaCredito(Boolean activarid_transportistaNotaCredito) {
		this.activarid_transportistaNotaCredito= activarid_transportistaNotaCredito;
	}

	public Boolean getCargarid_transportistaNotaCredito() {
		return this.cargarid_transportistaNotaCredito;
	}

	public void setCargarid_transportistaNotaCredito(Boolean cargarid_transportistaNotaCredito) {
		this.cargarid_transportistaNotaCredito= cargarid_transportistaNotaCredito;
	}

	public Border setResaltarfecha_clienteNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoBeanSwingJInternalFrame notacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditoBeanSwingJInternalFrame.jTtoolBarNotaCredito.setBorder(borderResaltar);
		
		this.resaltarfecha_clienteNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_clienteNotaCredito() {
		return this.resaltarfecha_clienteNotaCredito;
	}

	public void setResaltarfecha_clienteNotaCredito(Border borderResaltar) {
		this.resaltarfecha_clienteNotaCredito= borderResaltar;
	}

	public Boolean getMostrarfecha_clienteNotaCredito() {
		return this.mostrarfecha_clienteNotaCredito;
	}

	public void setMostrarfecha_clienteNotaCredito(Boolean mostrarfecha_clienteNotaCredito) {
		this.mostrarfecha_clienteNotaCredito= mostrarfecha_clienteNotaCredito;
	}

	public Boolean getActivarfecha_clienteNotaCredito() {
		return this.activarfecha_clienteNotaCredito;
	}

	public void setActivarfecha_clienteNotaCredito(Boolean activarfecha_clienteNotaCredito) {
		this.activarfecha_clienteNotaCredito= activarfecha_clienteNotaCredito;
	}

	public Border setResaltarfecha_autorizacionNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoBeanSwingJInternalFrame notacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//notacreditoBeanSwingJInternalFrame.jTtoolBarNotaCredito.setBorder(borderResaltar);
		
		this.resaltarfecha_autorizacionNotaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_autorizacionNotaCredito() {
		return this.resaltarfecha_autorizacionNotaCredito;
	}

	public void setResaltarfecha_autorizacionNotaCredito(Border borderResaltar) {
		this.resaltarfecha_autorizacionNotaCredito= borderResaltar;
	}

	public Boolean getMostrarfecha_autorizacionNotaCredito() {
		return this.mostrarfecha_autorizacionNotaCredito;
	}

	public void setMostrarfecha_autorizacionNotaCredito(Boolean mostrarfecha_autorizacionNotaCredito) {
		this.mostrarfecha_autorizacionNotaCredito= mostrarfecha_autorizacionNotaCredito;
	}

	public Boolean getActivarfecha_autorizacionNotaCredito() {
		return this.activarfecha_autorizacionNotaCredito;
	}

	public void setActivarfecha_autorizacionNotaCredito(Boolean activarfecha_autorizacionNotaCredito) {
		this.activarfecha_autorizacionNotaCredito= activarfecha_autorizacionNotaCredito;
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
		
		
		this.setMostraridNotaCredito(esInicial);
		this.setMostrarid_empresaNotaCredito(esInicial);
		this.setMostrarid_sucursalNotaCredito(esInicial);
		this.setMostrarid_ejercicioNotaCredito(esInicial);
		this.setMostrarid_periodoNotaCredito(esInicial);
		this.setMostrarid_anioNotaCredito(esInicial);
		this.setMostrarid_mesNotaCredito(esInicial);
		this.setMostrarid_usuarioNotaCredito(esInicial);
		this.setMostrarcodigoNotaCredito(esInicial);
		this.setMostrarnumeroNotaCredito(esInicial);
		this.setMostrarfecha_emisionNotaCredito(esInicial);
		this.setMostrarnumero_diasNotaCredito(esInicial);
		this.setMostrarfecha_vencimientoNotaCredito(esInicial);
		this.setMostrarid_monedaNotaCredito(esInicial);
		this.setMostrarcotizacionNotaCredito(esInicial);
		this.setMostrarid_empleadoNotaCredito(esInicial);
		this.setMostrarid_formatoNotaCredito(esInicial);
		this.setMostrarid_tipo_precioNotaCredito(esInicial);
		this.setMostrarid_clienteNotaCredito(esInicial);
		this.setMostrarid_facturaNotaCredito(esInicial);
		this.setMostrardireccionNotaCredito(esInicial);
		this.setMostrartelefonoNotaCredito(esInicial);
		this.setMostrarrucNotaCredito(esInicial);
		this.setMostrarid_vendedorNotaCredito(esInicial);
		this.setMostrarid_responsableNotaCredito(esInicial);
		this.setMostrarid_estado_nota_creditoNotaCredito(esInicial);
		this.setMostrardescripcionNotaCredito(esInicial);
		this.setMostrardescuento_porcentajeNotaCredito(esInicial);
		this.setMostrartotal_ivaNotaCredito(esInicial);
		this.setMostrarsumanNotaCredito(esInicial);
		this.setMostrardescuento_valorNotaCredito(esInicial);
		this.setMostrartotal_sin_ivaNotaCredito(esInicial);
		this.setMostrartotal_descuentoNotaCredito(esInicial);
		this.setMostrarfleteNotaCredito(esInicial);
		this.setMostrartotalNotaCredito(esInicial);
		this.setMostrarsub_totalNotaCredito(esInicial);
		this.setMostrarotroNotaCredito(esInicial);
		this.setMostrarivaNotaCredito(esInicial);
		this.setMostrarfinanciamientoNotaCredito(esInicial);
		this.setMostrariceNotaCredito(esInicial);
		this.setMostrarotro_valorNotaCredito(esInicial);
		this.setMostrarretencionNotaCredito(esInicial);
		this.setMostrarfechaNotaCredito(esInicial);
		this.setMostrares_clienteNotaCredito(esInicial);
		this.setMostrarid_centro_costoNotaCredito(esInicial);
		this.setMostrarid_tipo_cambioNotaCredito(esInicial);
		this.setMostrarid_transporteNotaCredito(esInicial);
		this.setMostrarid_transportistaNotaCredito(esInicial);
		this.setMostrarfecha_clienteNotaCredito(esInicial);
		this.setMostrarfecha_autorizacionNotaCredito(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(NotaCreditoConstantesFunciones.ID)) {
				this.setMostraridNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.IDMES)) {
				this.setMostrarid_mesNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.IDUSUARIO)) {
				this.setMostrarid_usuarioNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.NUMEROPREIMPRESO)) {
				this.setMostrarnumeroNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.NUMERODIAS)) {
				this.setMostrarnumero_diasNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setMostrarfecha_vencimientoNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.IDMONEDA)) {
				this.setMostrarid_monedaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.COTIZACION)) {
				this.setMostrarcotizacionNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.IDFORMATO)) {
				this.setMostrarid_formatoNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.IDTIPOPRECIO)) {
				this.setMostrarid_tipo_precioNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.IDFACTURA)) {
				this.setMostrarid_facturaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.DIRECCION)) {
				this.setMostrardireccionNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.TELEFONO)) {
				this.setMostrartelefonoNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.RUC)) {
				this.setMostrarrucNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.IDVENDEDOR)) {
				this.setMostrarid_vendedorNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.IDRESPONSABLE)) {
				this.setMostrarid_responsableNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.IDESTADONOTACREDITO)) {
				this.setMostrarid_estado_nota_creditoNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.DESCUENTOPORCENTAJE)) {
				this.setMostrardescuento_porcentajeNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.TOTALIVA)) {
				this.setMostrartotal_ivaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.SUMAN)) {
				this.setMostrarsumanNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.DESCUENTOVALOR)) {
				this.setMostrardescuento_valorNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.TOTALSINIVA)) {
				this.setMostrartotal_sin_ivaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.TOTALDESCUENTO)) {
				this.setMostrartotal_descuentoNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.FLETE)) {
				this.setMostrarfleteNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.TOTAL)) {
				this.setMostrartotalNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.SUBTOTAL)) {
				this.setMostrarsub_totalNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.OTRO)) {
				this.setMostrarotroNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.IVA)) {
				this.setMostrarivaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.FINANCIAMIENTO)) {
				this.setMostrarfinanciamientoNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.ICE)) {
				this.setMostrariceNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.OTROVALOR)) {
				this.setMostrarotro_valorNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.RETENCION)) {
				this.setMostrarretencionNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.FECHA)) {
				this.setMostrarfechaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.ESCLIENTE)) {
				this.setMostrares_clienteNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.IDCENTROCOSTO)) {
				this.setMostrarid_centro_costoNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.IDTIPOCAMBIO)) {
				this.setMostrarid_tipo_cambioNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.IDTRANSPORTE)) {
				this.setMostrarid_transporteNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.IDTRANSPORTISTA)) {
				this.setMostrarid_transportistaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.FECHACLIENTE)) {
				this.setMostrarfecha_clienteNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.FECHAAUTORIZACION)) {
				this.setMostrarfecha_autorizacionNotaCredito(esAsigna);
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
		
		
		this.setActivaridNotaCredito(esInicial);
		this.setActivarid_empresaNotaCredito(esInicial);
		this.setActivarid_sucursalNotaCredito(esInicial);
		this.setActivarid_ejercicioNotaCredito(esInicial);
		this.setActivarid_periodoNotaCredito(esInicial);
		this.setActivarid_anioNotaCredito(esInicial);
		this.setActivarid_mesNotaCredito(esInicial);
		this.setActivarid_usuarioNotaCredito(esInicial);
		this.setActivarcodigoNotaCredito(esInicial);
		this.setActivarnumeroNotaCredito(esInicial);
		this.setActivarfecha_emisionNotaCredito(esInicial);
		this.setActivarnumero_diasNotaCredito(esInicial);
		this.setActivarfecha_vencimientoNotaCredito(esInicial);
		this.setActivarid_monedaNotaCredito(esInicial);
		this.setActivarcotizacionNotaCredito(esInicial);
		this.setActivarid_empleadoNotaCredito(esInicial);
		this.setActivarid_formatoNotaCredito(esInicial);
		this.setActivarid_tipo_precioNotaCredito(esInicial);
		this.setActivarid_clienteNotaCredito(esInicial);
		this.setActivarid_facturaNotaCredito(esInicial);
		this.setActivardireccionNotaCredito(esInicial);
		this.setActivartelefonoNotaCredito(esInicial);
		this.setActivarrucNotaCredito(esInicial);
		this.setActivarid_vendedorNotaCredito(esInicial);
		this.setActivarid_responsableNotaCredito(esInicial);
		this.setActivarid_estado_nota_creditoNotaCredito(esInicial);
		this.setActivardescripcionNotaCredito(esInicial);
		this.setActivardescuento_porcentajeNotaCredito(esInicial);
		this.setActivartotal_ivaNotaCredito(esInicial);
		this.setActivarsumanNotaCredito(esInicial);
		this.setActivardescuento_valorNotaCredito(esInicial);
		this.setActivartotal_sin_ivaNotaCredito(esInicial);
		this.setActivartotal_descuentoNotaCredito(esInicial);
		this.setActivarfleteNotaCredito(esInicial);
		this.setActivartotalNotaCredito(esInicial);
		this.setActivarsub_totalNotaCredito(esInicial);
		this.setActivarotroNotaCredito(esInicial);
		this.setActivarivaNotaCredito(esInicial);
		this.setActivarfinanciamientoNotaCredito(esInicial);
		this.setActivariceNotaCredito(esInicial);
		this.setActivarotro_valorNotaCredito(esInicial);
		this.setActivarretencionNotaCredito(esInicial);
		this.setActivarfechaNotaCredito(esInicial);
		this.setActivares_clienteNotaCredito(esInicial);
		this.setActivarid_centro_costoNotaCredito(esInicial);
		this.setActivarid_tipo_cambioNotaCredito(esInicial);
		this.setActivarid_transporteNotaCredito(esInicial);
		this.setActivarid_transportistaNotaCredito(esInicial);
		this.setActivarfecha_clienteNotaCredito(esInicial);
		this.setActivarfecha_autorizacionNotaCredito(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(NotaCreditoConstantesFunciones.ID)) {
				this.setActivaridNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.IDANIO)) {
				this.setActivarid_anioNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.IDMES)) {
				this.setActivarid_mesNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.IDUSUARIO)) {
				this.setActivarid_usuarioNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.NUMEROPREIMPRESO)) {
				this.setActivarnumeroNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.NUMERODIAS)) {
				this.setActivarnumero_diasNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setActivarfecha_vencimientoNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.IDMONEDA)) {
				this.setActivarid_monedaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.COTIZACION)) {
				this.setActivarcotizacionNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.IDFORMATO)) {
				this.setActivarid_formatoNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.IDTIPOPRECIO)) {
				this.setActivarid_tipo_precioNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.IDFACTURA)) {
				this.setActivarid_facturaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.DIRECCION)) {
				this.setActivardireccionNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.TELEFONO)) {
				this.setActivartelefonoNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.RUC)) {
				this.setActivarrucNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.IDVENDEDOR)) {
				this.setActivarid_vendedorNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.IDRESPONSABLE)) {
				this.setActivarid_responsableNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.IDESTADONOTACREDITO)) {
				this.setActivarid_estado_nota_creditoNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.DESCUENTOPORCENTAJE)) {
				this.setActivardescuento_porcentajeNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.TOTALIVA)) {
				this.setActivartotal_ivaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.SUMAN)) {
				this.setActivarsumanNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.DESCUENTOVALOR)) {
				this.setActivardescuento_valorNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.TOTALSINIVA)) {
				this.setActivartotal_sin_ivaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.TOTALDESCUENTO)) {
				this.setActivartotal_descuentoNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.FLETE)) {
				this.setActivarfleteNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.TOTAL)) {
				this.setActivartotalNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.SUBTOTAL)) {
				this.setActivarsub_totalNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.OTRO)) {
				this.setActivarotroNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.IVA)) {
				this.setActivarivaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.FINANCIAMIENTO)) {
				this.setActivarfinanciamientoNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.ICE)) {
				this.setActivariceNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.OTROVALOR)) {
				this.setActivarotro_valorNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.RETENCION)) {
				this.setActivarretencionNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.FECHA)) {
				this.setActivarfechaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.ESCLIENTE)) {
				this.setActivares_clienteNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.IDCENTROCOSTO)) {
				this.setActivarid_centro_costoNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.IDTIPOCAMBIO)) {
				this.setActivarid_tipo_cambioNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.IDTRANSPORTE)) {
				this.setActivarid_transporteNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.IDTRANSPORTISTA)) {
				this.setActivarid_transportistaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.FECHACLIENTE)) {
				this.setActivarfecha_clienteNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.FECHAAUTORIZACION)) {
				this.setActivarfecha_autorizacionNotaCredito(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,NotaCreditoBeanSwingJInternalFrame notacreditoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridNotaCredito(esInicial);
		this.setResaltarid_empresaNotaCredito(esInicial);
		this.setResaltarid_sucursalNotaCredito(esInicial);
		this.setResaltarid_ejercicioNotaCredito(esInicial);
		this.setResaltarid_periodoNotaCredito(esInicial);
		this.setResaltarid_anioNotaCredito(esInicial);
		this.setResaltarid_mesNotaCredito(esInicial);
		this.setResaltarid_usuarioNotaCredito(esInicial);
		this.setResaltarcodigoNotaCredito(esInicial);
		this.setResaltarnumeroNotaCredito(esInicial);
		this.setResaltarfecha_emisionNotaCredito(esInicial);
		this.setResaltarnumero_diasNotaCredito(esInicial);
		this.setResaltarfecha_vencimientoNotaCredito(esInicial);
		this.setResaltarid_monedaNotaCredito(esInicial);
		this.setResaltarcotizacionNotaCredito(esInicial);
		this.setResaltarid_empleadoNotaCredito(esInicial);
		this.setResaltarid_formatoNotaCredito(esInicial);
		this.setResaltarid_tipo_precioNotaCredito(esInicial);
		this.setResaltarid_clienteNotaCredito(esInicial);
		this.setResaltarid_facturaNotaCredito(esInicial);
		this.setResaltardireccionNotaCredito(esInicial);
		this.setResaltartelefonoNotaCredito(esInicial);
		this.setResaltarrucNotaCredito(esInicial);
		this.setResaltarid_vendedorNotaCredito(esInicial);
		this.setResaltarid_responsableNotaCredito(esInicial);
		this.setResaltarid_estado_nota_creditoNotaCredito(esInicial);
		this.setResaltardescripcionNotaCredito(esInicial);
		this.setResaltardescuento_porcentajeNotaCredito(esInicial);
		this.setResaltartotal_ivaNotaCredito(esInicial);
		this.setResaltarsumanNotaCredito(esInicial);
		this.setResaltardescuento_valorNotaCredito(esInicial);
		this.setResaltartotal_sin_ivaNotaCredito(esInicial);
		this.setResaltartotal_descuentoNotaCredito(esInicial);
		this.setResaltarfleteNotaCredito(esInicial);
		this.setResaltartotalNotaCredito(esInicial);
		this.setResaltarsub_totalNotaCredito(esInicial);
		this.setResaltarotroNotaCredito(esInicial);
		this.setResaltarivaNotaCredito(esInicial);
		this.setResaltarfinanciamientoNotaCredito(esInicial);
		this.setResaltariceNotaCredito(esInicial);
		this.setResaltarotro_valorNotaCredito(esInicial);
		this.setResaltarretencionNotaCredito(esInicial);
		this.setResaltarfechaNotaCredito(esInicial);
		this.setResaltares_clienteNotaCredito(esInicial);
		this.setResaltarid_centro_costoNotaCredito(esInicial);
		this.setResaltarid_tipo_cambioNotaCredito(esInicial);
		this.setResaltarid_transporteNotaCredito(esInicial);
		this.setResaltarid_transportistaNotaCredito(esInicial);
		this.setResaltarfecha_clienteNotaCredito(esInicial);
		this.setResaltarfecha_autorizacionNotaCredito(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(NotaCreditoConstantesFunciones.ID)) {
				this.setResaltaridNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.IDMES)) {
				this.setResaltarid_mesNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.IDUSUARIO)) {
				this.setResaltarid_usuarioNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.NUMEROPREIMPRESO)) {
				this.setResaltarnumeroNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.NUMERODIAS)) {
				this.setResaltarnumero_diasNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setResaltarfecha_vencimientoNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.IDMONEDA)) {
				this.setResaltarid_monedaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.COTIZACION)) {
				this.setResaltarcotizacionNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.IDFORMATO)) {
				this.setResaltarid_formatoNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.IDTIPOPRECIO)) {
				this.setResaltarid_tipo_precioNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.IDFACTURA)) {
				this.setResaltarid_facturaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.DIRECCION)) {
				this.setResaltardireccionNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.TELEFONO)) {
				this.setResaltartelefonoNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.RUC)) {
				this.setResaltarrucNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.IDVENDEDOR)) {
				this.setResaltarid_vendedorNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.IDRESPONSABLE)) {
				this.setResaltarid_responsableNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.IDESTADONOTACREDITO)) {
				this.setResaltarid_estado_nota_creditoNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.DESCUENTOPORCENTAJE)) {
				this.setResaltardescuento_porcentajeNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.TOTALIVA)) {
				this.setResaltartotal_ivaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.SUMAN)) {
				this.setResaltarsumanNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.DESCUENTOVALOR)) {
				this.setResaltardescuento_valorNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.TOTALSINIVA)) {
				this.setResaltartotal_sin_ivaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.TOTALDESCUENTO)) {
				this.setResaltartotal_descuentoNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.FLETE)) {
				this.setResaltarfleteNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.TOTAL)) {
				this.setResaltartotalNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.SUBTOTAL)) {
				this.setResaltarsub_totalNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.OTRO)) {
				this.setResaltarotroNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.IVA)) {
				this.setResaltarivaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.FINANCIAMIENTO)) {
				this.setResaltarfinanciamientoNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.ICE)) {
				this.setResaltariceNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.OTROVALOR)) {
				this.setResaltarotro_valorNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.RETENCION)) {
				this.setResaltarretencionNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.FECHA)) {
				this.setResaltarfechaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.ESCLIENTE)) {
				this.setResaltares_clienteNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.IDCENTROCOSTO)) {
				this.setResaltarid_centro_costoNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.IDTIPOCAMBIO)) {
				this.setResaltarid_tipo_cambioNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.IDTRANSPORTE)) {
				this.setResaltarid_transporteNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.IDTRANSPORTISTA)) {
				this.setResaltarid_transportistaNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.FECHACLIENTE)) {
				this.setResaltarfecha_clienteNotaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(NotaCreditoConstantesFunciones.FECHAAUTORIZACION)) {
				this.setResaltarfecha_autorizacionNotaCredito(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDetaNotaCreditoNotaCredito=null;

	public Border getResaltarDetaNotaCreditoNotaCredito() {
		return this.resaltarDetaNotaCreditoNotaCredito;
	}

	public void setResaltarDetaNotaCreditoNotaCredito(Border borderResaltarDetaNotaCredito) {
		if(borderResaltarDetaNotaCredito!=null) {
			this.resaltarDetaNotaCreditoNotaCredito= borderResaltarDetaNotaCredito;
		}
	}

	public Border setResaltarDetaNotaCreditoNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoBeanSwingJInternalFrame notacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltarDetaNotaCredito=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//notacreditoBeanSwingJInternalFrame.jTtoolBarNotaCredito.setBorder(borderResaltarDetaNotaCredito);
			
		this.resaltarDetaNotaCreditoNotaCredito= borderResaltarDetaNotaCredito;

		 return borderResaltarDetaNotaCredito;
	}



	public Boolean mostrarDetaNotaCreditoNotaCredito=true;

	public Boolean getMostrarDetaNotaCreditoNotaCredito() {
		return this.mostrarDetaNotaCreditoNotaCredito;
	}

	public void setMostrarDetaNotaCreditoNotaCredito(Boolean visibilidadResaltarDetaNotaCredito) {
		this.mostrarDetaNotaCreditoNotaCredito= visibilidadResaltarDetaNotaCredito;
	}



	public Boolean activarDetaNotaCreditoNotaCredito=true;

	public Boolean gethabilitarResaltarDetaNotaCreditoNotaCredito() {
		return this.activarDetaNotaCreditoNotaCredito;
	}

	public void setActivarDetaNotaCreditoNotaCredito(Boolean habilitarResaltarDetaNotaCredito) {
		this.activarDetaNotaCreditoNotaCredito= habilitarResaltarDetaNotaCredito;
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

		this.setMostrarDetaNotaCreditoNotaCredito(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetaNotaCredito.class)) {
				this.setMostrarDetaNotaCreditoNotaCredito(esAsigna);
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

		this.setActivarDetaNotaCreditoNotaCredito(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetaNotaCredito.class)) {
				this.setActivarDetaNotaCreditoNotaCredito(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,NotaCreditoBeanSwingJInternalFrame notacreditoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDetaNotaCreditoNotaCredito(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetaNotaCredito.class)) {
				this.setResaltarDetaNotaCreditoNotaCredito(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorCodigoNotaCredito=true;

	public Boolean getMostrarBusquedaPorCodigoNotaCredito() {
		return this.mostrarBusquedaPorCodigoNotaCredito;
	}

	public void setMostrarBusquedaPorCodigoNotaCredito(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoNotaCredito= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNumeroPreImpresoNotaCredito=true;

	public Boolean getMostrarBusquedaPorNumeroPreImpresoNotaCredito() {
		return this.mostrarBusquedaPorNumeroPreImpresoNotaCredito;
	}

	public void setMostrarBusquedaPorNumeroPreImpresoNotaCredito(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNumeroPreImpresoNotaCredito= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdClienteNotaCredito=true;

	public Boolean getMostrarFK_IdClienteNotaCredito() {
		return this.mostrarFK_IdClienteNotaCredito;
	}

	public void setMostrarFK_IdClienteNotaCredito(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteNotaCredito= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioNotaCredito=true;

	public Boolean getMostrarFK_IdEjercicioNotaCredito() {
		return this.mostrarFK_IdEjercicioNotaCredito;
	}

	public void setMostrarFK_IdEjercicioNotaCredito(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioNotaCredito= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaNotaCredito=true;

	public Boolean getMostrarFK_IdEmpresaNotaCredito() {
		return this.mostrarFK_IdEmpresaNotaCredito;
	}

	public void setMostrarFK_IdEmpresaNotaCredito(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaNotaCredito= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFacturaNotaCredito=true;

	public Boolean getMostrarFK_IdFacturaNotaCredito() {
		return this.mostrarFK_IdFacturaNotaCredito;
	}

	public void setMostrarFK_IdFacturaNotaCredito(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFacturaNotaCredito= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoNotaCredito=true;

	public Boolean getMostrarFK_IdPeriodoNotaCredito() {
		return this.mostrarFK_IdPeriodoNotaCredito;
	}

	public void setMostrarFK_IdPeriodoNotaCredito(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoNotaCredito= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalNotaCredito=true;

	public Boolean getMostrarFK_IdSucursalNotaCredito() {
		return this.mostrarFK_IdSucursalNotaCredito;
	}

	public void setMostrarFK_IdSucursalNotaCredito(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalNotaCredito= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTransportistaNotaCredito=true;

	public Boolean getMostrarFK_IdTransportistaNotaCredito() {
		return this.mostrarFK_IdTransportistaNotaCredito;
	}

	public void setMostrarFK_IdTransportistaNotaCredito(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTransportistaNotaCredito= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUsuarioNotaCredito=true;

	public Boolean getMostrarFK_IdUsuarioNotaCredito() {
		return this.mostrarFK_IdUsuarioNotaCredito;
	}

	public void setMostrarFK_IdUsuarioNotaCredito(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUsuarioNotaCredito= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdVendedorNotaCredito=true;

	public Boolean getMostrarFK_IdVendedorNotaCredito() {
		return this.mostrarFK_IdVendedorNotaCredito;
	}

	public void setMostrarFK_IdVendedorNotaCredito(Boolean visibilidadResaltar) {
		this.mostrarFK_IdVendedorNotaCredito= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoNotaCredito=true;

	public Boolean getActivarBusquedaPorCodigoNotaCredito() {
		return this.activarBusquedaPorCodigoNotaCredito;
	}

	public void setActivarBusquedaPorCodigoNotaCredito(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoNotaCredito= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNumeroPreImpresoNotaCredito=true;

	public Boolean getActivarBusquedaPorNumeroPreImpresoNotaCredito() {
		return this.activarBusquedaPorNumeroPreImpresoNotaCredito;
	}

	public void setActivarBusquedaPorNumeroPreImpresoNotaCredito(Boolean habilitarResaltar) {
		this.activarBusquedaPorNumeroPreImpresoNotaCredito= habilitarResaltar;
	}

	public Boolean activarFK_IdClienteNotaCredito=true;

	public Boolean getActivarFK_IdClienteNotaCredito() {
		return this.activarFK_IdClienteNotaCredito;
	}

	public void setActivarFK_IdClienteNotaCredito(Boolean habilitarResaltar) {
		this.activarFK_IdClienteNotaCredito= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioNotaCredito=true;

	public Boolean getActivarFK_IdEjercicioNotaCredito() {
		return this.activarFK_IdEjercicioNotaCredito;
	}

	public void setActivarFK_IdEjercicioNotaCredito(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioNotaCredito= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaNotaCredito=true;

	public Boolean getActivarFK_IdEmpresaNotaCredito() {
		return this.activarFK_IdEmpresaNotaCredito;
	}

	public void setActivarFK_IdEmpresaNotaCredito(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaNotaCredito= habilitarResaltar;
	}

	public Boolean activarFK_IdFacturaNotaCredito=true;

	public Boolean getActivarFK_IdFacturaNotaCredito() {
		return this.activarFK_IdFacturaNotaCredito;
	}

	public void setActivarFK_IdFacturaNotaCredito(Boolean habilitarResaltar) {
		this.activarFK_IdFacturaNotaCredito= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoNotaCredito=true;

	public Boolean getActivarFK_IdPeriodoNotaCredito() {
		return this.activarFK_IdPeriodoNotaCredito;
	}

	public void setActivarFK_IdPeriodoNotaCredito(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoNotaCredito= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalNotaCredito=true;

	public Boolean getActivarFK_IdSucursalNotaCredito() {
		return this.activarFK_IdSucursalNotaCredito;
	}

	public void setActivarFK_IdSucursalNotaCredito(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalNotaCredito= habilitarResaltar;
	}

	public Boolean activarFK_IdTransportistaNotaCredito=true;

	public Boolean getActivarFK_IdTransportistaNotaCredito() {
		return this.activarFK_IdTransportistaNotaCredito;
	}

	public void setActivarFK_IdTransportistaNotaCredito(Boolean habilitarResaltar) {
		this.activarFK_IdTransportistaNotaCredito= habilitarResaltar;
	}

	public Boolean activarFK_IdUsuarioNotaCredito=true;

	public Boolean getActivarFK_IdUsuarioNotaCredito() {
		return this.activarFK_IdUsuarioNotaCredito;
	}

	public void setActivarFK_IdUsuarioNotaCredito(Boolean habilitarResaltar) {
		this.activarFK_IdUsuarioNotaCredito= habilitarResaltar;
	}

	public Boolean activarFK_IdVendedorNotaCredito=true;

	public Boolean getActivarFK_IdVendedorNotaCredito() {
		return this.activarFK_IdVendedorNotaCredito;
	}

	public void setActivarFK_IdVendedorNotaCredito(Boolean habilitarResaltar) {
		this.activarFK_IdVendedorNotaCredito= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoNotaCredito=null;

	public Border getResaltarBusquedaPorCodigoNotaCredito() {
		return this.resaltarBusquedaPorCodigoNotaCredito;
	}

	public void setResaltarBusquedaPorCodigoNotaCredito(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoNotaCredito= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoBeanSwingJInternalFrame notacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoNotaCredito= borderResaltar;
	}

	public Border resaltarBusquedaPorNumeroPreImpresoNotaCredito=null;

	public Border getResaltarBusquedaPorNumeroPreImpresoNotaCredito() {
		return this.resaltarBusquedaPorNumeroPreImpresoNotaCredito;
	}

	public void setResaltarBusquedaPorNumeroPreImpresoNotaCredito(Border borderResaltar) {
		this.resaltarBusquedaPorNumeroPreImpresoNotaCredito= borderResaltar;
	}

	public void setResaltarBusquedaPorNumeroPreImpresoNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoBeanSwingJInternalFrame notacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNumeroPreImpresoNotaCredito= borderResaltar;
	}

	public Border resaltarFK_IdClienteNotaCredito=null;

	public Border getResaltarFK_IdClienteNotaCredito() {
		return this.resaltarFK_IdClienteNotaCredito;
	}

	public void setResaltarFK_IdClienteNotaCredito(Border borderResaltar) {
		this.resaltarFK_IdClienteNotaCredito= borderResaltar;
	}

	public void setResaltarFK_IdClienteNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoBeanSwingJInternalFrame notacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteNotaCredito= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioNotaCredito=null;

	public Border getResaltarFK_IdEjercicioNotaCredito() {
		return this.resaltarFK_IdEjercicioNotaCredito;
	}

	public void setResaltarFK_IdEjercicioNotaCredito(Border borderResaltar) {
		this.resaltarFK_IdEjercicioNotaCredito= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoBeanSwingJInternalFrame notacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioNotaCredito= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaNotaCredito=null;

	public Border getResaltarFK_IdEmpresaNotaCredito() {
		return this.resaltarFK_IdEmpresaNotaCredito;
	}

	public void setResaltarFK_IdEmpresaNotaCredito(Border borderResaltar) {
		this.resaltarFK_IdEmpresaNotaCredito= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoBeanSwingJInternalFrame notacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaNotaCredito= borderResaltar;
	}

	public Border resaltarFK_IdFacturaNotaCredito=null;

	public Border getResaltarFK_IdFacturaNotaCredito() {
		return this.resaltarFK_IdFacturaNotaCredito;
	}

	public void setResaltarFK_IdFacturaNotaCredito(Border borderResaltar) {
		this.resaltarFK_IdFacturaNotaCredito= borderResaltar;
	}

	public void setResaltarFK_IdFacturaNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoBeanSwingJInternalFrame notacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFacturaNotaCredito= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoNotaCredito=null;

	public Border getResaltarFK_IdPeriodoNotaCredito() {
		return this.resaltarFK_IdPeriodoNotaCredito;
	}

	public void setResaltarFK_IdPeriodoNotaCredito(Border borderResaltar) {
		this.resaltarFK_IdPeriodoNotaCredito= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoBeanSwingJInternalFrame notacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoNotaCredito= borderResaltar;
	}

	public Border resaltarFK_IdSucursalNotaCredito=null;

	public Border getResaltarFK_IdSucursalNotaCredito() {
		return this.resaltarFK_IdSucursalNotaCredito;
	}

	public void setResaltarFK_IdSucursalNotaCredito(Border borderResaltar) {
		this.resaltarFK_IdSucursalNotaCredito= borderResaltar;
	}

	public void setResaltarFK_IdSucursalNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoBeanSwingJInternalFrame notacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalNotaCredito= borderResaltar;
	}

	public Border resaltarFK_IdTransportistaNotaCredito=null;

	public Border getResaltarFK_IdTransportistaNotaCredito() {
		return this.resaltarFK_IdTransportistaNotaCredito;
	}

	public void setResaltarFK_IdTransportistaNotaCredito(Border borderResaltar) {
		this.resaltarFK_IdTransportistaNotaCredito= borderResaltar;
	}

	public void setResaltarFK_IdTransportistaNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoBeanSwingJInternalFrame notacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTransportistaNotaCredito= borderResaltar;
	}

	public Border resaltarFK_IdUsuarioNotaCredito=null;

	public Border getResaltarFK_IdUsuarioNotaCredito() {
		return this.resaltarFK_IdUsuarioNotaCredito;
	}

	public void setResaltarFK_IdUsuarioNotaCredito(Border borderResaltar) {
		this.resaltarFK_IdUsuarioNotaCredito= borderResaltar;
	}

	public void setResaltarFK_IdUsuarioNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoBeanSwingJInternalFrame notacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUsuarioNotaCredito= borderResaltar;
	}

	public Border resaltarFK_IdVendedorNotaCredito=null;

	public Border getResaltarFK_IdVendedorNotaCredito() {
		return this.resaltarFK_IdVendedorNotaCredito;
	}

	public void setResaltarFK_IdVendedorNotaCredito(Border borderResaltar) {
		this.resaltarFK_IdVendedorNotaCredito= borderResaltar;
	}

	public void setResaltarFK_IdVendedorNotaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*NotaCreditoBeanSwingJInternalFrame notacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdVendedorNotaCredito= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}