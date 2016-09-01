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


import com.bydan.erp.facturacion.util.FacturaConstantesFunciones;
import com.bydan.erp.facturacion.util.FacturaParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.FacturaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.tesoreria.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class FacturaConstantesFunciones extends FacturaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Factura";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Factura"+FacturaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="FacturaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="FacturaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=FacturaConstantesFunciones.SCHEMA+"_"+FacturaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/FacturaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=FacturaConstantesFunciones.SCHEMA+"_"+FacturaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=FacturaConstantesFunciones.SCHEMA+"_"+FacturaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/FacturaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=FacturaConstantesFunciones.SCHEMA+"_"+FacturaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FacturaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/FacturaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FacturaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FacturaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/FacturaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FacturaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=FacturaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+FacturaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=FacturaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+FacturaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Facturas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Factura";
	public static final String SCLASSWEBTITULO_LOWER="Factura";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Factura";
	public static final String OBJECTNAME="factura";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="factura";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select factura from "+FacturaConstantesFunciones.SPERSISTENCENAME+" factura";
	public static String QUERYSELECTNATIVE="select "+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".id,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".version_row,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".id_empresa,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".id_sucursal,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".id_ejercicio,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".id_periodo,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".id_anio,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".id_mes,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".id_usuario,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".numero_pre_impreso,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".fecha_emision,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".numero_dias,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".fecha_vencimiento,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".id_moneda,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".cotizacion,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".id_empleado,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".id_formato,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".direccion,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".ruc,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".id_cliente,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".id_tipo_precio,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".telefono,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".id_sub_cliente,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".id_vendedor,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".id_transporte,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".id_transportista,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".orden,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".id_tipo_llamada,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".hora_inicio,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".hora_fin,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".id_tipo_factura,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".descripcion,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".cupo,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".saldo,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".documentos,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".disponible,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".porcentaje_descuento,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".total_iva,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".suman,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".descuento_valor,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".total_sin_iva,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".total_descuento,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".total_flete,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".total,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".sub_total,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".total_otro,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".ultimo_costo,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".iva,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".descuento,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".financiamiento,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".margen_utilidad,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".ice,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".anticipo,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".otros_valores,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".total_retencion,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".total_consumo_especial,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".retencion,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".id_tipo_cambio,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".es_cliente,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".id_asiento_contable,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".id_pedido,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".id_responsable,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".id_estado_fisico_factura_empresa,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".fecha,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".fecha_autorizacion,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".fecha_cliente,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".numero_documento,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".numero_dau,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".numero_referendo,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".fecha_referendo,"+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME+".aforo_referendo from "+FacturaConstantesFunciones.SCHEMA+"."+FacturaConstantesFunciones.TABLENAME;//+" as "+FacturaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=true;
	
	
	protected FacturaConstantesFuncionesAdditional facturaConstantesFuncionesAdditional=null;
	
	public FacturaConstantesFuncionesAdditional getFacturaConstantesFuncionesAdditional() {
		return this.facturaConstantesFuncionesAdditional;
	}
	
	public void setFacturaConstantesFuncionesAdditional(FacturaConstantesFuncionesAdditional facturaConstantesFuncionesAdditional) {
		try {
			this.facturaConstantesFuncionesAdditional=facturaConstantesFuncionesAdditional;
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
    public static final String NUMEROPREIMPRESO= "numero_pre_impreso";
    public static final String FECHAEMISION= "fecha_emision";
    public static final String NUMERODIAS= "numero_dias";
    public static final String FECHAVENCIMIENTO= "fecha_vencimiento";
    public static final String IDMONEDA= "id_moneda";
    public static final String COTIZACION= "cotizacion";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String IDFORMATO= "id_formato";
    public static final String DIRECCION= "direccion";
    public static final String RUC= "ruc";
    public static final String IDCLIENTE= "id_cliente";
    public static final String IDTIPOPRECIO= "id_tipo_precio";
    public static final String TELEFONO= "telefono";
    public static final String IDSUBCLIENTE= "id_sub_cliente";
    public static final String IDVENDEDOR= "id_vendedor";
    public static final String IDTRANSPORTE= "id_transporte";
    public static final String IDTRANSPORTISTA= "id_transportista";
    public static final String ORDEN= "orden";
    public static final String IDTIPOLLAMADA= "id_tipo_llamada";
    public static final String HORAINICIO= "hora_inicio";
    public static final String HORAFIN= "hora_fin";
    public static final String IDTIPOFACTURA= "id_tipo_factura";
    public static final String DESCRIPCION= "descripcion";
    public static final String CUPO= "cupo";
    public static final String SALDO= "saldo";
    public static final String DOCUMENTOS= "documentos";
    public static final String DISPONIBLE= "disponible";
    public static final String PORCENTAJEDESCUENTO= "porcentaje_descuento";
    public static final String TOTALIVA= "total_iva";
    public static final String SUMAN= "suman";
    public static final String DESCUENTOVALOR= "descuento_valor";
    public static final String TOTALSINIVA= "total_sin_iva";
    public static final String TOTALDESCUENTO= "total_descuento";
    public static final String TOTALFLETE= "total_flete";
    public static final String TOTAL= "total";
    public static final String SUBTOTAL= "sub_total";
    public static final String TOTALOTRO= "total_otro";
    public static final String ULTIMOCOSTO= "ultimo_costo";
    public static final String IVA= "iva";
    public static final String DESCUENTO= "descuento";
    public static final String FINANCIAMIENTO= "financiamiento";
    public static final String MARGENUTILIDAD= "margen_utilidad";
    public static final String ICE= "ice";
    public static final String ANTICIPO= "anticipo";
    public static final String OTROSVALORES= "otros_valores";
    public static final String TOTALRETENCION= "total_retencion";
    public static final String TOTALCONSUMOESPECIAL= "total_consumo_especial";
    public static final String RETENCION= "retencion";
    public static final String IDTIPOCAMBIO= "id_tipo_cambio";
    public static final String ESCLIENTE= "es_cliente";
    public static final String IDASIENTOCONTABLE= "id_asiento_contable";
    public static final String IDPEDIDO= "id_pedido";
    public static final String IDRESPONSABLE= "id_responsable";
    public static final String IDESTADOFISICOFACTURAEMPRESA= "id_estado_fisico_factura_empresa";
    public static final String FECHA= "fecha";
    public static final String FECHAAUTORIZACION= "fecha_autorizacion";
    public static final String FECHACLIENTE= "fecha_cliente";
    public static final String NUMERODOCUMENTO= "numero_documento";
    public static final String NUMERODAU= "numero_dau";
    public static final String NUMEROREFERENDO= "numero_referendo";
    public static final String FECHAREFERENDO= "fecha_referendo";
    public static final String AFOROREFERENDO= "aforo_referendo";
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
    	public static final String LABEL_NUMEROPREIMPRESO= "Numero Pre Impreso";
		public static final String LABEL_NUMEROPREIMPRESO_LOWER= "Numero Pre Impreso";
    	public static final String LABEL_FECHAEMISION= "Fecha Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "Fecha Emision";
    	public static final String LABEL_NUMERODIAS= "Numero Dia";
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
    	public static final String LABEL_DIRECCION= "Direccion";
		public static final String LABEL_DIRECCION_LOWER= "Direccion";
    	public static final String LABEL_RUC= "Ruc";
		public static final String LABEL_RUC_LOWER= "Ruc";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_IDTIPOPRECIO= "Tipo Precio";
		public static final String LABEL_IDTIPOPRECIO_LOWER= "Tipo Precio";
    	public static final String LABEL_TELEFONO= "Telefono";
		public static final String LABEL_TELEFONO_LOWER= "Telefono";
    	public static final String LABEL_IDSUBCLIENTE= "Contacto";
		public static final String LABEL_IDSUBCLIENTE_LOWER= "Sub Cliente";
    	public static final String LABEL_IDVENDEDOR= "Vendedor";
		public static final String LABEL_IDVENDEDOR_LOWER= "Vendedor";
    	public static final String LABEL_IDTRANSPORTE= "Transporte";
		public static final String LABEL_IDTRANSPORTE_LOWER= "Transporte";
    	public static final String LABEL_IDTRANSPORTISTA= "Transportista";
		public static final String LABEL_IDTRANSPORTISTA_LOWER= "Transportista";
    	public static final String LABEL_ORDEN= "Orden";
		public static final String LABEL_ORDEN_LOWER= "Orden";
    	public static final String LABEL_IDTIPOLLAMADA= "Tipo Llamada";
		public static final String LABEL_IDTIPOLLAMADA_LOWER= "Tipo Llamada";
    	public static final String LABEL_HORAINICIO= "Hora Inicio";
		public static final String LABEL_HORAINICIO_LOWER= "Hora Inicio";
    	public static final String LABEL_HORAFIN= "Hora Fin";
		public static final String LABEL_HORAFIN_LOWER= "Hora Fin";
    	public static final String LABEL_IDTIPOFACTURA= "Tipo Factura";
		public static final String LABEL_IDTIPOFACTURA_LOWER= "Tipo Factura";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_CUPO= "Cupo";
		public static final String LABEL_CUPO_LOWER= "Cupo";
    	public static final String LABEL_SALDO= "Saldo";
		public static final String LABEL_SALDO_LOWER= "Saldo";
    	public static final String LABEL_DOCUMENTOS= "Documentos";
		public static final String LABEL_DOCUMENTOS_LOWER= "Documentos";
    	public static final String LABEL_DISPONIBLE= "Disponible";
		public static final String LABEL_DISPONIBLE_LOWER= "Disponible";
    	public static final String LABEL_PORCENTAJEDESCUENTO= "% Descuento";
		public static final String LABEL_PORCENTAJEDESCUENTO_LOWER= "Porcentaje Descuento";
    	public static final String LABEL_TOTALIVA= "Monto Con Iva";
		public static final String LABEL_TOTALIVA_LOWER= "Total Iva";
    	public static final String LABEL_SUMAN= "Suman";
		public static final String LABEL_SUMAN_LOWER= "Suman";
    	public static final String LABEL_DESCUENTOVALOR= "Descuento Valor";
		public static final String LABEL_DESCUENTOVALOR_LOWER= "Descuento Valor";
    	public static final String LABEL_TOTALSINIVA= "Monto Sin Iva";
		public static final String LABEL_TOTALSINIVA_LOWER= "Total Sin Iva";
    	public static final String LABEL_TOTALDESCUENTO= "Total Descuento";
		public static final String LABEL_TOTALDESCUENTO_LOWER= "Total Descuento";
    	public static final String LABEL_TOTALFLETE= "Flete";
		public static final String LABEL_TOTALFLETE_LOWER= "Total Flete";
    	public static final String LABEL_TOTAL= "Total";
		public static final String LABEL_TOTAL_LOWER= "Total";
    	public static final String LABEL_SUBTOTAL= "Sub Total";
		public static final String LABEL_SUBTOTAL_LOWER= "Sub Total";
    	public static final String LABEL_TOTALOTRO= "Otros";
		public static final String LABEL_TOTALOTRO_LOWER= "Total Otro";
    	public static final String LABEL_ULTIMOCOSTO= "Ultimo Costo";
		public static final String LABEL_ULTIMOCOSTO_LOWER= "Ultimo Costo";
    	public static final String LABEL_IVA= "Iva";
		public static final String LABEL_IVA_LOWER= "Iva";
    	public static final String LABEL_DESCUENTO= "Descuento";
		public static final String LABEL_DESCUENTO_LOWER= "Descuento";
    	public static final String LABEL_FINANCIAMIENTO= "Financiamiento";
		public static final String LABEL_FINANCIAMIENTO_LOWER= "Financiamiento";
    	public static final String LABEL_MARGENUTILIDAD= "Margen Utilidad";
		public static final String LABEL_MARGENUTILIDAD_LOWER= "Margen Utilidad";
    	public static final String LABEL_ICE= "Ice";
		public static final String LABEL_ICE_LOWER= "Ice";
    	public static final String LABEL_ANTICIPO= "Anticipo";
		public static final String LABEL_ANTICIPO_LOWER= "Anticipo";
    	public static final String LABEL_OTROSVALORES= "Otros Valores";
		public static final String LABEL_OTROSVALORES_LOWER= "Otros Valores";
    	public static final String LABEL_TOTALRETENCION= "Total Retencion";
		public static final String LABEL_TOTALRETENCION_LOWER= "Total Retencion";
    	public static final String LABEL_TOTALCONSUMOESPECIAL= "Total Consumo Especial";
		public static final String LABEL_TOTALCONSUMOESPECIAL_LOWER= "Total Consumo Especial";
    	public static final String LABEL_RETENCION= "Retencion";
		public static final String LABEL_RETENCION_LOWER= "Retencion";
    	public static final String LABEL_IDTIPOCAMBIO= "Tipo Cambio";
		public static final String LABEL_IDTIPOCAMBIO_LOWER= "Tipo Cambio";
    	public static final String LABEL_ESCLIENTE= "Es Cliente";
		public static final String LABEL_ESCLIENTE_LOWER= "Es Cliente";
    	public static final String LABEL_IDASIENTOCONTABLE= "Asiento Contable";
		public static final String LABEL_IDASIENTOCONTABLE_LOWER= "Asiento Contable";
    	public static final String LABEL_IDPEDIDO= "Idpedido";
		public static final String LABEL_IDPEDIDO_LOWER= "Pedido";
    	public static final String LABEL_IDRESPONSABLE= "Responsable";
		public static final String LABEL_IDRESPONSABLE_LOWER= "Responsable";
    	public static final String LABEL_IDESTADOFISICOFACTURAEMPRESA= "Estado Fisico";
		public static final String LABEL_IDESTADOFISICOFACTURAEMPRESA_LOWER= "Estado Fisico Factura Empresa";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_FECHAAUTORIZACION= "Fecha Autorizacion";
		public static final String LABEL_FECHAAUTORIZACION_LOWER= "Fecha Autorizacion";
    	public static final String LABEL_FECHACLIENTE= "Fecha Cliente";
		public static final String LABEL_FECHACLIENTE_LOWER= "Fecha Cliente";
    	public static final String LABEL_NUMERODOCUMENTO= "Numero Documento";
		public static final String LABEL_NUMERODOCUMENTO_LOWER= "Numero Documento";
    	public static final String LABEL_NUMERODAU= "Numero Dau";
		public static final String LABEL_NUMERODAU_LOWER= "Numero Dau";
    	public static final String LABEL_NUMEROREFERENDO= "Numero Referendo";
		public static final String LABEL_NUMEROREFERENDO_LOWER= "Numero Referendo";
    	public static final String LABEL_FECHAREFERENDO= "Fecha Referendo";
		public static final String LABEL_FECHAREFERENDO_LOWER= "Fecha Referendo";
    	public static final String LABEL_AFOROREFERENDO= "Aforo Referendo";
		public static final String LABEL_AFOROREFERENDO_LOWER= "Aforo Referendo";
	
		
		
		
		
		
		
		
		
		
	public static final String SREGEXNUMERO_PRE_IMPRESO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_PRE_IMPRESO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
	public static final String SREGEXDIRECCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDIRECCION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXRUC=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXRUC=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXTELEFONO=ConstantesValidacion.SREGEXCADENA_TELEFONO;
	public static final String SMENSAJEREGEXTELEFONO=ConstantesValidacion.SVALIDACIONCADENA_TELEFONO;	
		
		
		
		
	public static final String SREGEXORDEN=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXORDEN=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXNUMERO_DOCUMENTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_DOCUMENTO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_DAU=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_DAU=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_REFERENDO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_REFERENDO=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXAFORO_REFERENDO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXAFORO_REFERENDO=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getFacturaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(FacturaConstantesFunciones.IDEMPRESA)) {sLabelColumna=FacturaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(FacturaConstantesFunciones.IDSUCURSAL)) {sLabelColumna=FacturaConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(FacturaConstantesFunciones.IDEJERCICIO)) {sLabelColumna=FacturaConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(FacturaConstantesFunciones.IDPERIODO)) {sLabelColumna=FacturaConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(FacturaConstantesFunciones.IDANIO)) {sLabelColumna=FacturaConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(FacturaConstantesFunciones.IDMES)) {sLabelColumna=FacturaConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(FacturaConstantesFunciones.IDUSUARIO)) {sLabelColumna=FacturaConstantesFunciones.LABEL_IDUSUARIO;}
		if(sNombreColumna.equals(FacturaConstantesFunciones.NUMEROPREIMPRESO)) {sLabelColumna=FacturaConstantesFunciones.LABEL_NUMEROPREIMPRESO;}
		if(sNombreColumna.equals(FacturaConstantesFunciones.FECHAEMISION)) {sLabelColumna=FacturaConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(FacturaConstantesFunciones.NUMERODIAS)) {sLabelColumna=FacturaConstantesFunciones.LABEL_NUMERODIAS;}
		if(sNombreColumna.equals(FacturaConstantesFunciones.FECHAVENCIMIENTO)) {sLabelColumna=FacturaConstantesFunciones.LABEL_FECHAVENCIMIENTO;}
		if(sNombreColumna.equals(FacturaConstantesFunciones.IDMONEDA)) {sLabelColumna=FacturaConstantesFunciones.LABEL_IDMONEDA;}
		if(sNombreColumna.equals(FacturaConstantesFunciones.COTIZACION)) {sLabelColumna=FacturaConstantesFunciones.LABEL_COTIZACION;}
		if(sNombreColumna.equals(FacturaConstantesFunciones.IDEMPLEADO)) {sLabelColumna=FacturaConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(FacturaConstantesFunciones.IDFORMATO)) {sLabelColumna=FacturaConstantesFunciones.LABEL_IDFORMATO;}
		if(sNombreColumna.equals(FacturaConstantesFunciones.DIRECCION)) {sLabelColumna=FacturaConstantesFunciones.LABEL_DIRECCION;}
		if(sNombreColumna.equals(FacturaConstantesFunciones.RUC)) {sLabelColumna=FacturaConstantesFunciones.LABEL_RUC;}
		if(sNombreColumna.equals(FacturaConstantesFunciones.IDCLIENTE)) {sLabelColumna=FacturaConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(FacturaConstantesFunciones.IDTIPOPRECIO)) {sLabelColumna=FacturaConstantesFunciones.LABEL_IDTIPOPRECIO;}
		if(sNombreColumna.equals(FacturaConstantesFunciones.TELEFONO)) {sLabelColumna=FacturaConstantesFunciones.LABEL_TELEFONO;}
		if(sNombreColumna.equals(FacturaConstantesFunciones.IDSUBCLIENTE)) {sLabelColumna=FacturaConstantesFunciones.LABEL_IDSUBCLIENTE;}
		if(sNombreColumna.equals(FacturaConstantesFunciones.IDVENDEDOR)) {sLabelColumna=FacturaConstantesFunciones.LABEL_IDVENDEDOR;}
		if(sNombreColumna.equals(FacturaConstantesFunciones.IDTRANSPORTE)) {sLabelColumna=FacturaConstantesFunciones.LABEL_IDTRANSPORTE;}
		if(sNombreColumna.equals(FacturaConstantesFunciones.IDTRANSPORTISTA)) {sLabelColumna=FacturaConstantesFunciones.LABEL_IDTRANSPORTISTA;}
		if(sNombreColumna.equals(FacturaConstantesFunciones.ORDEN)) {sLabelColumna=FacturaConstantesFunciones.LABEL_ORDEN;}
		if(sNombreColumna.equals(FacturaConstantesFunciones.IDTIPOLLAMADA)) {sLabelColumna=FacturaConstantesFunciones.LABEL_IDTIPOLLAMADA;}
		if(sNombreColumna.equals(FacturaConstantesFunciones.HORAINICIO)) {sLabelColumna=FacturaConstantesFunciones.LABEL_HORAINICIO;}
		if(sNombreColumna.equals(FacturaConstantesFunciones.HORAFIN)) {sLabelColumna=FacturaConstantesFunciones.LABEL_HORAFIN;}
		if(sNombreColumna.equals(FacturaConstantesFunciones.IDTIPOFACTURA)) {sLabelColumna=FacturaConstantesFunciones.LABEL_IDTIPOFACTURA;}
		if(sNombreColumna.equals(FacturaConstantesFunciones.DESCRIPCION)) {sLabelColumna=FacturaConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(FacturaConstantesFunciones.CUPO)) {sLabelColumna=FacturaConstantesFunciones.LABEL_CUPO;}
		if(sNombreColumna.equals(FacturaConstantesFunciones.SALDO)) {sLabelColumna=FacturaConstantesFunciones.LABEL_SALDO;}
		if(sNombreColumna.equals(FacturaConstantesFunciones.DOCUMENTOS)) {sLabelColumna=FacturaConstantesFunciones.LABEL_DOCUMENTOS;}
		if(sNombreColumna.equals(FacturaConstantesFunciones.DISPONIBLE)) {sLabelColumna=FacturaConstantesFunciones.LABEL_DISPONIBLE;}
		if(sNombreColumna.equals(FacturaConstantesFunciones.PORCENTAJEDESCUENTO)) {sLabelColumna=FacturaConstantesFunciones.LABEL_PORCENTAJEDESCUENTO;}
		if(sNombreColumna.equals(FacturaConstantesFunciones.TOTALIVA)) {sLabelColumna=FacturaConstantesFunciones.LABEL_TOTALIVA;}
		if(sNombreColumna.equals(FacturaConstantesFunciones.SUMAN)) {sLabelColumna=FacturaConstantesFunciones.LABEL_SUMAN;}
		if(sNombreColumna.equals(FacturaConstantesFunciones.DESCUENTOVALOR)) {sLabelColumna=FacturaConstantesFunciones.LABEL_DESCUENTOVALOR;}
		if(sNombreColumna.equals(FacturaConstantesFunciones.TOTALSINIVA)) {sLabelColumna=FacturaConstantesFunciones.LABEL_TOTALSINIVA;}
		if(sNombreColumna.equals(FacturaConstantesFunciones.TOTALDESCUENTO)) {sLabelColumna=FacturaConstantesFunciones.LABEL_TOTALDESCUENTO;}
		if(sNombreColumna.equals(FacturaConstantesFunciones.TOTALFLETE)) {sLabelColumna=FacturaConstantesFunciones.LABEL_TOTALFLETE;}
		if(sNombreColumna.equals(FacturaConstantesFunciones.TOTAL)) {sLabelColumna=FacturaConstantesFunciones.LABEL_TOTAL;}
		if(sNombreColumna.equals(FacturaConstantesFunciones.SUBTOTAL)) {sLabelColumna=FacturaConstantesFunciones.LABEL_SUBTOTAL;}
		if(sNombreColumna.equals(FacturaConstantesFunciones.TOTALOTRO)) {sLabelColumna=FacturaConstantesFunciones.LABEL_TOTALOTRO;}
		if(sNombreColumna.equals(FacturaConstantesFunciones.ULTIMOCOSTO)) {sLabelColumna=FacturaConstantesFunciones.LABEL_ULTIMOCOSTO;}
		if(sNombreColumna.equals(FacturaConstantesFunciones.IVA)) {sLabelColumna=FacturaConstantesFunciones.LABEL_IVA;}
		if(sNombreColumna.equals(FacturaConstantesFunciones.DESCUENTO)) {sLabelColumna=FacturaConstantesFunciones.LABEL_DESCUENTO;}
		if(sNombreColumna.equals(FacturaConstantesFunciones.FINANCIAMIENTO)) {sLabelColumna=FacturaConstantesFunciones.LABEL_FINANCIAMIENTO;}
		if(sNombreColumna.equals(FacturaConstantesFunciones.MARGENUTILIDAD)) {sLabelColumna=FacturaConstantesFunciones.LABEL_MARGENUTILIDAD;}
		if(sNombreColumna.equals(FacturaConstantesFunciones.ICE)) {sLabelColumna=FacturaConstantesFunciones.LABEL_ICE;}
		if(sNombreColumna.equals(FacturaConstantesFunciones.ANTICIPO)) {sLabelColumna=FacturaConstantesFunciones.LABEL_ANTICIPO;}
		if(sNombreColumna.equals(FacturaConstantesFunciones.OTROSVALORES)) {sLabelColumna=FacturaConstantesFunciones.LABEL_OTROSVALORES;}
		if(sNombreColumna.equals(FacturaConstantesFunciones.TOTALRETENCION)) {sLabelColumna=FacturaConstantesFunciones.LABEL_TOTALRETENCION;}
		if(sNombreColumna.equals(FacturaConstantesFunciones.TOTALCONSUMOESPECIAL)) {sLabelColumna=FacturaConstantesFunciones.LABEL_TOTALCONSUMOESPECIAL;}
		if(sNombreColumna.equals(FacturaConstantesFunciones.RETENCION)) {sLabelColumna=FacturaConstantesFunciones.LABEL_RETENCION;}
		if(sNombreColumna.equals(FacturaConstantesFunciones.IDTIPOCAMBIO)) {sLabelColumna=FacturaConstantesFunciones.LABEL_IDTIPOCAMBIO;}
		if(sNombreColumna.equals(FacturaConstantesFunciones.ESCLIENTE)) {sLabelColumna=FacturaConstantesFunciones.LABEL_ESCLIENTE;}
		if(sNombreColumna.equals(FacturaConstantesFunciones.IDASIENTOCONTABLE)) {sLabelColumna=FacturaConstantesFunciones.LABEL_IDASIENTOCONTABLE;}
		if(sNombreColumna.equals(FacturaConstantesFunciones.IDPEDIDO)) {sLabelColumna=FacturaConstantesFunciones.LABEL_IDPEDIDO;}
		if(sNombreColumna.equals(FacturaConstantesFunciones.IDRESPONSABLE)) {sLabelColumna=FacturaConstantesFunciones.LABEL_IDRESPONSABLE;}
		if(sNombreColumna.equals(FacturaConstantesFunciones.IDESTADOFISICOFACTURAEMPRESA)) {sLabelColumna=FacturaConstantesFunciones.LABEL_IDESTADOFISICOFACTURAEMPRESA;}
		if(sNombreColumna.equals(FacturaConstantesFunciones.FECHA)) {sLabelColumna=FacturaConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(FacturaConstantesFunciones.FECHAAUTORIZACION)) {sLabelColumna=FacturaConstantesFunciones.LABEL_FECHAAUTORIZACION;}
		if(sNombreColumna.equals(FacturaConstantesFunciones.FECHACLIENTE)) {sLabelColumna=FacturaConstantesFunciones.LABEL_FECHACLIENTE;}
		if(sNombreColumna.equals(FacturaConstantesFunciones.NUMERODOCUMENTO)) {sLabelColumna=FacturaConstantesFunciones.LABEL_NUMERODOCUMENTO;}
		if(sNombreColumna.equals(FacturaConstantesFunciones.NUMERODAU)) {sLabelColumna=FacturaConstantesFunciones.LABEL_NUMERODAU;}
		if(sNombreColumna.equals(FacturaConstantesFunciones.NUMEROREFERENDO)) {sLabelColumna=FacturaConstantesFunciones.LABEL_NUMEROREFERENDO;}
		if(sNombreColumna.equals(FacturaConstantesFunciones.FECHAREFERENDO)) {sLabelColumna=FacturaConstantesFunciones.LABEL_FECHAREFERENDO;}
		if(sNombreColumna.equals(FacturaConstantesFunciones.AFOROREFERENDO)) {sLabelColumna=FacturaConstantesFunciones.LABEL_AFOROREFERENDO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getes_clienteDescripcion(Factura factura) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!factura.getes_cliente()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_clienteHtmlDescripcion(Factura factura) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(factura.getId(),factura.getes_cliente());

		return sDescripcion;
	}	
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getFacturaDescripcion(Factura factura) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(factura !=null/* && factura.getId()!=0*/) {
			sDescripcion=factura.getnumero_pre_impreso();//facturafactura.getnumero_pre_impreso().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getFacturaDescripcionDetallado(Factura factura) {
		String sDescripcion="";
			
		sDescripcion+=FacturaConstantesFunciones.ID+"=";
		sDescripcion+=factura.getId().toString()+",";
		sDescripcion+=FacturaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=factura.getVersionRow().toString()+",";
		sDescripcion+=FacturaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=factura.getid_empresa().toString()+",";
		sDescripcion+=FacturaConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=factura.getid_sucursal().toString()+",";
		sDescripcion+=FacturaConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=factura.getid_ejercicio().toString()+",";
		sDescripcion+=FacturaConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=factura.getid_periodo().toString()+",";
		sDescripcion+=FacturaConstantesFunciones.IDANIO+"=";
		sDescripcion+=factura.getid_anio().toString()+",";
		sDescripcion+=FacturaConstantesFunciones.IDMES+"=";
		sDescripcion+=factura.getid_mes().toString()+",";
		sDescripcion+=FacturaConstantesFunciones.IDUSUARIO+"=";
		sDescripcion+=factura.getid_usuario().toString()+",";
		sDescripcion+=FacturaConstantesFunciones.NUMEROPREIMPRESO+"=";
		sDescripcion+=factura.getnumero_pre_impreso()+",";
		sDescripcion+=FacturaConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=factura.getfecha_emision().toString()+",";
		sDescripcion+=FacturaConstantesFunciones.NUMERODIAS+"=";
		sDescripcion+=factura.getnumero_dias().toString()+",";
		sDescripcion+=FacturaConstantesFunciones.FECHAVENCIMIENTO+"=";
		sDescripcion+=factura.getfecha_vencimiento().toString()+",";
		sDescripcion+=FacturaConstantesFunciones.IDMONEDA+"=";
		sDescripcion+=factura.getid_moneda().toString()+",";
		sDescripcion+=FacturaConstantesFunciones.COTIZACION+"=";
		sDescripcion+=factura.getcotizacion().toString()+",";
		sDescripcion+=FacturaConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=factura.getid_empleado().toString()+",";
		sDescripcion+=FacturaConstantesFunciones.IDFORMATO+"=";
		sDescripcion+=factura.getid_formato().toString()+",";
		sDescripcion+=FacturaConstantesFunciones.DIRECCION+"=";
		sDescripcion+=factura.getdireccion()+",";
		sDescripcion+=FacturaConstantesFunciones.RUC+"=";
		sDescripcion+=factura.getruc()+",";
		sDescripcion+=FacturaConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=factura.getid_cliente().toString()+",";
		sDescripcion+=FacturaConstantesFunciones.IDTIPOPRECIO+"=";
		sDescripcion+=factura.getid_tipo_precio().toString()+",";
		sDescripcion+=FacturaConstantesFunciones.TELEFONO+"=";
		sDescripcion+=factura.gettelefono()+",";
		sDescripcion+=FacturaConstantesFunciones.IDSUBCLIENTE+"=";
		sDescripcion+=factura.getid_sub_cliente().toString()+",";
		sDescripcion+=FacturaConstantesFunciones.IDVENDEDOR+"=";
		sDescripcion+=factura.getid_vendedor().toString()+",";
		sDescripcion+=FacturaConstantesFunciones.IDTRANSPORTE+"=";
		sDescripcion+=factura.getid_transporte().toString()+",";
		sDescripcion+=FacturaConstantesFunciones.IDTRANSPORTISTA+"=";
		sDescripcion+=factura.getid_transportista().toString()+",";
		sDescripcion+=FacturaConstantesFunciones.ORDEN+"=";
		sDescripcion+=factura.getorden()+",";
		sDescripcion+=FacturaConstantesFunciones.IDTIPOLLAMADA+"=";
		sDescripcion+=factura.getid_tipo_llamada().toString()+",";
		sDescripcion+=FacturaConstantesFunciones.HORAINICIO+"=";
		sDescripcion+=factura.gethora_inicio().toString()+",";
		sDescripcion+=FacturaConstantesFunciones.HORAFIN+"=";
		sDescripcion+=factura.gethora_fin().toString()+",";
		sDescripcion+=FacturaConstantesFunciones.IDTIPOFACTURA+"=";
		sDescripcion+=factura.getid_tipo_factura().toString()+",";
		sDescripcion+=FacturaConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=factura.getdescripcion()+",";
		sDescripcion+=FacturaConstantesFunciones.CUPO+"=";
		sDescripcion+=factura.getcupo().toString()+",";
		sDescripcion+=FacturaConstantesFunciones.SALDO+"=";
		sDescripcion+=factura.getsaldo().toString()+",";
		sDescripcion+=FacturaConstantesFunciones.DOCUMENTOS+"=";
		sDescripcion+=factura.getdocumentos().toString()+",";
		sDescripcion+=FacturaConstantesFunciones.DISPONIBLE+"=";
		sDescripcion+=factura.getdisponible().toString()+",";
		sDescripcion+=FacturaConstantesFunciones.PORCENTAJEDESCUENTO+"=";
		sDescripcion+=factura.getporcentaje_descuento().toString()+",";
		sDescripcion+=FacturaConstantesFunciones.TOTALIVA+"=";
		sDescripcion+=factura.gettotal_iva().toString()+",";
		sDescripcion+=FacturaConstantesFunciones.SUMAN+"=";
		sDescripcion+=factura.getsuman().toString()+",";
		sDescripcion+=FacturaConstantesFunciones.DESCUENTOVALOR+"=";
		sDescripcion+=factura.getdescuento_valor().toString()+",";
		sDescripcion+=FacturaConstantesFunciones.TOTALSINIVA+"=";
		sDescripcion+=factura.gettotal_sin_iva().toString()+",";
		sDescripcion+=FacturaConstantesFunciones.TOTALDESCUENTO+"=";
		sDescripcion+=factura.gettotal_descuento().toString()+",";
		sDescripcion+=FacturaConstantesFunciones.TOTALFLETE+"=";
		sDescripcion+=factura.gettotal_flete().toString()+",";
		sDescripcion+=FacturaConstantesFunciones.TOTAL+"=";
		sDescripcion+=factura.gettotal().toString()+",";
		sDescripcion+=FacturaConstantesFunciones.SUBTOTAL+"=";
		sDescripcion+=factura.getsub_total().toString()+",";
		sDescripcion+=FacturaConstantesFunciones.TOTALOTRO+"=";
		sDescripcion+=factura.gettotal_otro().toString()+",";
		sDescripcion+=FacturaConstantesFunciones.ULTIMOCOSTO+"=";
		sDescripcion+=factura.getultimo_costo().toString()+",";
		sDescripcion+=FacturaConstantesFunciones.IVA+"=";
		sDescripcion+=factura.getiva().toString()+",";
		sDescripcion+=FacturaConstantesFunciones.DESCUENTO+"=";
		sDescripcion+=factura.getdescuento().toString()+",";
		sDescripcion+=FacturaConstantesFunciones.FINANCIAMIENTO+"=";
		sDescripcion+=factura.getfinanciamiento().toString()+",";
		sDescripcion+=FacturaConstantesFunciones.MARGENUTILIDAD+"=";
		sDescripcion+=factura.getmargen_utilidad().toString()+",";
		sDescripcion+=FacturaConstantesFunciones.ICE+"=";
		sDescripcion+=factura.getice().toString()+",";
		sDescripcion+=FacturaConstantesFunciones.ANTICIPO+"=";
		sDescripcion+=factura.getanticipo().toString()+",";
		sDescripcion+=FacturaConstantesFunciones.OTROSVALORES+"=";
		sDescripcion+=factura.getotros_valores().toString()+",";
		sDescripcion+=FacturaConstantesFunciones.TOTALRETENCION+"=";
		sDescripcion+=factura.gettotal_retencion().toString()+",";
		sDescripcion+=FacturaConstantesFunciones.TOTALCONSUMOESPECIAL+"=";
		sDescripcion+=factura.gettotal_consumo_especial().toString()+",";
		sDescripcion+=FacturaConstantesFunciones.RETENCION+"=";
		sDescripcion+=factura.getretencion().toString()+",";
		sDescripcion+=FacturaConstantesFunciones.IDTIPOCAMBIO+"=";
		sDescripcion+=factura.getid_tipo_cambio().toString()+",";
		sDescripcion+=FacturaConstantesFunciones.ESCLIENTE+"=";
		sDescripcion+=factura.getes_cliente().toString()+",";
		sDescripcion+=FacturaConstantesFunciones.IDASIENTOCONTABLE+"=";
		sDescripcion+=factura.getid_asiento_contable().toString()+",";
		sDescripcion+=FacturaConstantesFunciones.IDPEDIDO+"=";
		sDescripcion+=factura.getid_pedido().toString()+",";
		sDescripcion+=FacturaConstantesFunciones.IDRESPONSABLE+"=";
		sDescripcion+=factura.getid_responsable().toString()+",";
		sDescripcion+=FacturaConstantesFunciones.IDESTADOFISICOFACTURAEMPRESA+"=";
		sDescripcion+=factura.getid_estado_fisico_factura_empresa().toString()+",";
		sDescripcion+=FacturaConstantesFunciones.FECHA+"=";
		sDescripcion+=factura.getfecha().toString()+",";
		sDescripcion+=FacturaConstantesFunciones.FECHAAUTORIZACION+"=";
		sDescripcion+=factura.getfecha_autorizacion().toString()+",";
		sDescripcion+=FacturaConstantesFunciones.FECHACLIENTE+"=";
		sDescripcion+=factura.getfecha_cliente().toString()+",";
		sDescripcion+=FacturaConstantesFunciones.NUMERODOCUMENTO+"=";
		sDescripcion+=factura.getnumero_documento()+",";
		sDescripcion+=FacturaConstantesFunciones.NUMERODAU+"=";
		sDescripcion+=factura.getnumero_dau()+",";
		sDescripcion+=FacturaConstantesFunciones.NUMEROREFERENDO+"=";
		sDescripcion+=factura.getnumero_referendo()+",";
		sDescripcion+=FacturaConstantesFunciones.FECHAREFERENDO+"=";
		sDescripcion+=factura.getfecha_referendo().toString()+",";
		sDescripcion+=FacturaConstantesFunciones.AFOROREFERENDO+"=";
		sDescripcion+=factura.getaforo_referendo()+",";
			
		return sDescripcion;
	}
	
	public static void setFacturaDescripcion(Factura factura,String sValor) throws Exception {			
		if(factura !=null) {
			factura.setnumero_pre_impreso(sValor);;//facturafactura.getnumero_pre_impreso().trim();
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

	public static String getClienteDescripcion(Cliente cliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cliente!=null/*&&cliente.getId()>0*/) {
			sDescripcion=ClienteConstantesFunciones.getClienteDescripcion(cliente);
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

	public static String getSubClienteDescripcion(SubCliente subcliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(subcliente!=null/*&&subcliente.getId()>0*/) {
			sDescripcion=SubClienteConstantesFunciones.getSubClienteDescripcion(subcliente);
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

	public static String getTipoLlamadaDescripcion(TipoLlamada tipollamada) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipollamada!=null/*&&tipollamada.getId()>0*/) {
			sDescripcion=TipoLlamadaConstantesFunciones.getTipoLlamadaDescripcion(tipollamada);
		}

		return sDescripcion;
	}

	public static String getTipoFacturaDescripcion(TipoFactura tipofactura) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipofactura!=null/*&&tipofactura.getId()>0*/) {
			sDescripcion=TipoFacturaConstantesFunciones.getTipoFacturaDescripcion(tipofactura);
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

	public static String getAsientoContableDescripcion(AsientoContable asientocontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(asientocontable!=null/*&&asientocontable.getId()>0*/) {
			sDescripcion=AsientoContableConstantesFunciones.getAsientoContableDescripcion(asientocontable);
		}

		return sDescripcion;
	}

	public static String getPedidoDescripcion(Pedido pedido) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(pedido!=null/*&&pedido.getId()>0*/) {
			sDescripcion=PedidoConstantesFunciones.getPedidoDescripcion(pedido);
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

	public static String getEstadoFisicoFacturaEmpresaDescripcion(EstadoFisicoFacturaEmpresa estadofisicofacturaempresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadofisicofacturaempresa!=null/*&&estadofisicofacturaempresa.getId()>0*/) {
			sDescripcion=EstadoFisicoFacturaEmpresaConstantesFunciones.getEstadoFisicoFacturaEmpresaDescripcion(estadofisicofacturaempresa);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorNumeroPreImpreso")) {
			sNombreIndice="Tipo=  Por Numero Pre Impreso";
		} else if(sNombreIndice.equals("FK_IdAnio")) {
			sNombreIndice="Tipo=  Por Anio";
		} else if(sNombreIndice.equals("FK_IdAsientoContable")) {
			sNombreIndice="Tipo=  Por Asiento Contable";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpleado")) {
			sNombreIndice="Tipo=  Por Empleado";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstadoFisicoFacturaEmpresa")) {
			sNombreIndice="Tipo=  Por Estado Fisico";
		} else if(sNombreIndice.equals("FK_IdFormato")) {
			sNombreIndice="Tipo=  Por Formato";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		} else if(sNombreIndice.equals("FK_IdMoneda")) {
			sNombreIndice="Tipo=  Por Moneda";
		} else if(sNombreIndice.equals("FK_IdPedido")) {
			sNombreIndice="Tipo=  Por Idpedido";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdResponsable")) {
			sNombreIndice="Tipo=  Por Responsable";
		} else if(sNombreIndice.equals("FK_IdSubCliente")) {
			sNombreIndice="Tipo=  Por Contacto";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoCambio")) {
			sNombreIndice="Tipo=  Por Tipo Cambio";
		} else if(sNombreIndice.equals("FK_IdTipoFactura")) {
			sNombreIndice="Tipo=  Por Tipo Factura";
		} else if(sNombreIndice.equals("FK_IdTipoLlamada")) {
			sNombreIndice="Tipo=  Por Tipo Llamada";
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

	public static String getDetalleIndiceBusquedaPorNumeroPreImpreso(String numero_pre_impreso) {
		String sDetalleIndice=" Parametros->";
		if(numero_pre_impreso!=null) {sDetalleIndice+=" Numero Pre Impreso="+numero_pre_impreso;} 

		return sDetalleIndice;
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

	public static String getDetalleIndiceFK_IdEstadoFisicoFacturaEmpresa(Long id_estado_fisico_factura_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_fisico_factura_empresa!=null) {sDetalleIndice+=" Codigo Unico De Estado Fisico="+id_estado_fisico_factura_empresa.toString();} 

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

	public static String getDetalleIndiceFK_IdPedido(Long id_pedido) {
		String sDetalleIndice=" Parametros->";
		if(id_pedido!=null) {sDetalleIndice+=" Codigo Unico De Idpedido="+id_pedido.toString();} 

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
		if(id_sub_cliente!=null) {sDetalleIndice+=" Codigo Unico De Contacto="+id_sub_cliente.toString();} 

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

	public static String getDetalleIndiceFK_IdTipoFactura(Long id_tipo_factura) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_factura!=null) {sDetalleIndice+=" Codigo Unico De Tipo Factura="+id_tipo_factura.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoLlamada(Long id_tipo_llamada) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_llamada!=null) {sDetalleIndice+=" Codigo Unico De Tipo Llamada="+id_tipo_llamada.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosFactura(Factura factura,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		factura.setnumero_pre_impreso(factura.getnumero_pre_impreso().trim());
		factura.setdireccion(factura.getdireccion().trim());
		factura.setruc(factura.getruc().trim());
		factura.settelefono(factura.gettelefono().trim());
		factura.setorden(factura.getorden().trim());
		factura.setdescripcion(factura.getdescripcion().trim());
		factura.setnumero_documento(factura.getnumero_documento().trim());
		factura.setnumero_dau(factura.getnumero_dau().trim());
		factura.setnumero_referendo(factura.getnumero_referendo().trim());
		factura.setaforo_referendo(factura.getaforo_referendo().trim());
	}
	
	public static void quitarEspaciosFacturas(List<Factura> facturas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Factura factura: facturas) {
			factura.setnumero_pre_impreso(factura.getnumero_pre_impreso().trim());
			factura.setdireccion(factura.getdireccion().trim());
			factura.setruc(factura.getruc().trim());
			factura.settelefono(factura.gettelefono().trim());
			factura.setorden(factura.getorden().trim());
			factura.setdescripcion(factura.getdescripcion().trim());
			factura.setnumero_documento(factura.getnumero_documento().trim());
			factura.setnumero_dau(factura.getnumero_dau().trim());
			factura.setnumero_referendo(factura.getnumero_referendo().trim());
			factura.setaforo_referendo(factura.getaforo_referendo().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresFactura(Factura factura,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && factura.getConCambioAuxiliar()) {
			factura.setIsDeleted(factura.getIsDeletedAuxiliar());	
			factura.setIsNew(factura.getIsNewAuxiliar());	
			factura.setIsChanged(factura.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			factura.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			factura.setIsDeletedAuxiliar(false);	
			factura.setIsNewAuxiliar(false);	
			factura.setIsChangedAuxiliar(false);
			
			factura.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresFacturas(List<Factura> facturas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Factura factura : facturas) {
			if(conAsignarBase && factura.getConCambioAuxiliar()) {
				factura.setIsDeleted(factura.getIsDeletedAuxiliar());	
				factura.setIsNew(factura.getIsNewAuxiliar());	
				factura.setIsChanged(factura.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				factura.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				factura.setIsDeletedAuxiliar(false);	
				factura.setIsNewAuxiliar(false);	
				factura.setIsChangedAuxiliar(false);
				
				factura.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresFactura(Factura factura,Boolean conEnteros) throws Exception  {
		factura.setcotizacion(0.0);
		factura.setcupo(0.0);
		factura.setsaldo(0.0);
		factura.setdocumentos(0.0);
		factura.setdisponible(0.0);
		factura.setporcentaje_descuento(0.0);
		factura.settotal_iva(0.0);
		factura.setsuman(0.0);
		factura.setdescuento_valor(0.0);
		factura.settotal_sin_iva(0.0);
		factura.settotal_descuento(0.0);
		factura.settotal_flete(0.0);
		factura.settotal(0.0);
		factura.setsub_total(0.0);
		factura.settotal_otro(0.0);
		factura.setultimo_costo(0.0);
		factura.setiva(0.0);
		factura.setdescuento(0.0);
		factura.setfinanciamiento(0.0);
		factura.setmargen_utilidad(0.0);
		factura.setice(0.0);
		factura.setanticipo(0.0);
		factura.setotros_valores(0.0);
		factura.settotal_retencion(0.0);
		factura.settotal_consumo_especial(0.0);
		factura.setretencion(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			factura.setnumero_dias(0);
		}
	}		
	
	public static void InicializarValoresFacturas(List<Factura> facturas,Boolean conEnteros) throws Exception  {
		
		for(Factura factura: facturas) {
			factura.setcotizacion(0.0);
			factura.setcupo(0.0);
			factura.setsaldo(0.0);
			factura.setdocumentos(0.0);
			factura.setdisponible(0.0);
			factura.setporcentaje_descuento(0.0);
			factura.settotal_iva(0.0);
			factura.setsuman(0.0);
			factura.setdescuento_valor(0.0);
			factura.settotal_sin_iva(0.0);
			factura.settotal_descuento(0.0);
			factura.settotal_flete(0.0);
			factura.settotal(0.0);
			factura.setsub_total(0.0);
			factura.settotal_otro(0.0);
			factura.setultimo_costo(0.0);
			factura.setiva(0.0);
			factura.setdescuento(0.0);
			factura.setfinanciamiento(0.0);
			factura.setmargen_utilidad(0.0);
			factura.setice(0.0);
			factura.setanticipo(0.0);
			factura.setotros_valores(0.0);
			factura.settotal_retencion(0.0);
			factura.settotal_consumo_especial(0.0);
			factura.setretencion(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				factura.setnumero_dias(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaFactura(List<Factura> facturas,Factura facturaAux) throws Exception  {
		FacturaConstantesFunciones.InicializarValoresFactura(facturaAux,true);
		
		for(Factura factura: facturas) {
			if(factura.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			facturaAux.setnumero_dias(facturaAux.getnumero_dias()+factura.getnumero_dias());			
			facturaAux.setcotizacion(facturaAux.getcotizacion()+factura.getcotizacion());			
			facturaAux.setcupo(facturaAux.getcupo()+factura.getcupo());			
			facturaAux.setsaldo(facturaAux.getsaldo()+factura.getsaldo());			
			facturaAux.setdocumentos(facturaAux.getdocumentos()+factura.getdocumentos());			
			facturaAux.setdisponible(facturaAux.getdisponible()+factura.getdisponible());			
			facturaAux.setporcentaje_descuento(facturaAux.getporcentaje_descuento()+factura.getporcentaje_descuento());			
			facturaAux.settotal_iva(facturaAux.gettotal_iva()+factura.gettotal_iva());			
			facturaAux.setsuman(facturaAux.getsuman()+factura.getsuman());			
			facturaAux.setdescuento_valor(facturaAux.getdescuento_valor()+factura.getdescuento_valor());			
			facturaAux.settotal_sin_iva(facturaAux.gettotal_sin_iva()+factura.gettotal_sin_iva());			
			facturaAux.settotal_descuento(facturaAux.gettotal_descuento()+factura.gettotal_descuento());			
			facturaAux.settotal_flete(facturaAux.gettotal_flete()+factura.gettotal_flete());			
			facturaAux.settotal(facturaAux.gettotal()+factura.gettotal());			
			facturaAux.setsub_total(facturaAux.getsub_total()+factura.getsub_total());			
			facturaAux.settotal_otro(facturaAux.gettotal_otro()+factura.gettotal_otro());			
			facturaAux.setultimo_costo(facturaAux.getultimo_costo()+factura.getultimo_costo());			
			facturaAux.setiva(facturaAux.getiva()+factura.getiva());			
			facturaAux.setdescuento(facturaAux.getdescuento()+factura.getdescuento());			
			facturaAux.setfinanciamiento(facturaAux.getfinanciamiento()+factura.getfinanciamiento());			
			facturaAux.setmargen_utilidad(facturaAux.getmargen_utilidad()+factura.getmargen_utilidad());			
			facturaAux.setice(facturaAux.getice()+factura.getice());			
			facturaAux.setanticipo(facturaAux.getanticipo()+factura.getanticipo());			
			facturaAux.setotros_valores(facturaAux.getotros_valores()+factura.getotros_valores());			
			facturaAux.settotal_retencion(facturaAux.gettotal_retencion()+factura.gettotal_retencion());			
			facturaAux.settotal_consumo_especial(facturaAux.gettotal_consumo_especial()+factura.gettotal_consumo_especial());			
			facturaAux.setretencion(facturaAux.getretencion()+factura.getretencion());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesFactura(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=FacturaConstantesFunciones.getArrayColumnasGlobalesFactura(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesFactura(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FacturaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FacturaConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FacturaConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FacturaConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FacturaConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FacturaConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FacturaConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FacturaConstantesFunciones.IDPERIODO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FacturaConstantesFunciones.IDUSUARIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FacturaConstantesFunciones.IDUSUARIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FacturaConstantesFunciones.IDMONEDA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FacturaConstantesFunciones.IDMONEDA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoFactura(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Factura> facturas,Factura factura,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Factura facturaAux: facturas) {
			if(facturaAux!=null && factura!=null) {
				if((facturaAux.getId()==null && factura.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(facturaAux.getId()!=null && factura.getId()!=null){
					if(facturaAux.getId().equals(factura.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaFactura(List<Factura> facturas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double cotizacionTotal=0.0;
		Double cupoTotal=0.0;
		Double saldoTotal=0.0;
		Double documentosTotal=0.0;
		Double disponibleTotal=0.0;
		Double porcentaje_descuentoTotal=0.0;
		Double total_ivaTotal=0.0;
		Double sumanTotal=0.0;
		Double descuento_valorTotal=0.0;
		Double total_sin_ivaTotal=0.0;
		Double total_descuentoTotal=0.0;
		Double total_fleteTotal=0.0;
		Double totalTotal=0.0;
		Double sub_totalTotal=0.0;
		Double total_otroTotal=0.0;
		Double ultimo_costoTotal=0.0;
		Double ivaTotal=0.0;
		Double descuentoTotal=0.0;
		Double financiamientoTotal=0.0;
		Double margen_utilidadTotal=0.0;
		Double iceTotal=0.0;
		Double anticipoTotal=0.0;
		Double otros_valoresTotal=0.0;
		Double total_retencionTotal=0.0;
		Double total_consumo_especialTotal=0.0;
		Double retencionTotal=0.0;
	
		for(Factura factura: facturas) {			
			if(factura.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			cotizacionTotal+=factura.getcotizacion();
			cupoTotal+=factura.getcupo();
			saldoTotal+=factura.getsaldo();
			documentosTotal+=factura.getdocumentos();
			disponibleTotal+=factura.getdisponible();
			porcentaje_descuentoTotal+=factura.getporcentaje_descuento();
			total_ivaTotal+=factura.gettotal_iva();
			sumanTotal+=factura.getsuman();
			descuento_valorTotal+=factura.getdescuento_valor();
			total_sin_ivaTotal+=factura.gettotal_sin_iva();
			total_descuentoTotal+=factura.gettotal_descuento();
			total_fleteTotal+=factura.gettotal_flete();
			totalTotal+=factura.gettotal();
			sub_totalTotal+=factura.getsub_total();
			total_otroTotal+=factura.gettotal_otro();
			ultimo_costoTotal+=factura.getultimo_costo();
			ivaTotal+=factura.getiva();
			descuentoTotal+=factura.getdescuento();
			financiamientoTotal+=factura.getfinanciamiento();
			margen_utilidadTotal+=factura.getmargen_utilidad();
			iceTotal+=factura.getice();
			anticipoTotal+=factura.getanticipo();
			otros_valoresTotal+=factura.getotros_valores();
			total_retencionTotal+=factura.gettotal_retencion();
			total_consumo_especialTotal+=factura.gettotal_consumo_especial();
			retencionTotal+=factura.getretencion();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaConstantesFunciones.COTIZACION);
		datoGeneral.setsDescripcion(FacturaConstantesFunciones.LABEL_COTIZACION);
		datoGeneral.setdValorDouble(cotizacionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaConstantesFunciones.CUPO);
		datoGeneral.setsDescripcion(FacturaConstantesFunciones.LABEL_CUPO);
		datoGeneral.setdValorDouble(cupoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaConstantesFunciones.SALDO);
		datoGeneral.setsDescripcion(FacturaConstantesFunciones.LABEL_SALDO);
		datoGeneral.setdValorDouble(saldoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaConstantesFunciones.DOCUMENTOS);
		datoGeneral.setsDescripcion(FacturaConstantesFunciones.LABEL_DOCUMENTOS);
		datoGeneral.setdValorDouble(documentosTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaConstantesFunciones.DISPONIBLE);
		datoGeneral.setsDescripcion(FacturaConstantesFunciones.LABEL_DISPONIBLE);
		datoGeneral.setdValorDouble(disponibleTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaConstantesFunciones.PORCENTAJEDESCUENTO);
		datoGeneral.setsDescripcion(FacturaConstantesFunciones.LABEL_PORCENTAJEDESCUENTO);
		datoGeneral.setdValorDouble(porcentaje_descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaConstantesFunciones.TOTALIVA);
		datoGeneral.setsDescripcion(FacturaConstantesFunciones.LABEL_TOTALIVA);
		datoGeneral.setdValorDouble(total_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaConstantesFunciones.SUMAN);
		datoGeneral.setsDescripcion(FacturaConstantesFunciones.LABEL_SUMAN);
		datoGeneral.setdValorDouble(sumanTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaConstantesFunciones.DESCUENTOVALOR);
		datoGeneral.setsDescripcion(FacturaConstantesFunciones.LABEL_DESCUENTOVALOR);
		datoGeneral.setdValorDouble(descuento_valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaConstantesFunciones.TOTALSINIVA);
		datoGeneral.setsDescripcion(FacturaConstantesFunciones.LABEL_TOTALSINIVA);
		datoGeneral.setdValorDouble(total_sin_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaConstantesFunciones.TOTALDESCUENTO);
		datoGeneral.setsDescripcion(FacturaConstantesFunciones.LABEL_TOTALDESCUENTO);
		datoGeneral.setdValorDouble(total_descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaConstantesFunciones.TOTALFLETE);
		datoGeneral.setsDescripcion(FacturaConstantesFunciones.LABEL_TOTALFLETE);
		datoGeneral.setdValorDouble(total_fleteTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(FacturaConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaConstantesFunciones.SUBTOTAL);
		datoGeneral.setsDescripcion(FacturaConstantesFunciones.LABEL_SUBTOTAL);
		datoGeneral.setdValorDouble(sub_totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaConstantesFunciones.TOTALOTRO);
		datoGeneral.setsDescripcion(FacturaConstantesFunciones.LABEL_TOTALOTRO);
		datoGeneral.setdValorDouble(total_otroTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaConstantesFunciones.ULTIMOCOSTO);
		datoGeneral.setsDescripcion(FacturaConstantesFunciones.LABEL_ULTIMOCOSTO);
		datoGeneral.setdValorDouble(ultimo_costoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(FacturaConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaConstantesFunciones.DESCUENTO);
		datoGeneral.setsDescripcion(FacturaConstantesFunciones.LABEL_DESCUENTO);
		datoGeneral.setdValorDouble(descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaConstantesFunciones.FINANCIAMIENTO);
		datoGeneral.setsDescripcion(FacturaConstantesFunciones.LABEL_FINANCIAMIENTO);
		datoGeneral.setdValorDouble(financiamientoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaConstantesFunciones.MARGENUTILIDAD);
		datoGeneral.setsDescripcion(FacturaConstantesFunciones.LABEL_MARGENUTILIDAD);
		datoGeneral.setdValorDouble(margen_utilidadTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaConstantesFunciones.ICE);
		datoGeneral.setsDescripcion(FacturaConstantesFunciones.LABEL_ICE);
		datoGeneral.setdValorDouble(iceTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaConstantesFunciones.ANTICIPO);
		datoGeneral.setsDescripcion(FacturaConstantesFunciones.LABEL_ANTICIPO);
		datoGeneral.setdValorDouble(anticipoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaConstantesFunciones.OTROSVALORES);
		datoGeneral.setsDescripcion(FacturaConstantesFunciones.LABEL_OTROSVALORES);
		datoGeneral.setdValorDouble(otros_valoresTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaConstantesFunciones.TOTALRETENCION);
		datoGeneral.setsDescripcion(FacturaConstantesFunciones.LABEL_TOTALRETENCION);
		datoGeneral.setdValorDouble(total_retencionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaConstantesFunciones.TOTALCONSUMOESPECIAL);
		datoGeneral.setsDescripcion(FacturaConstantesFunciones.LABEL_TOTALCONSUMOESPECIAL);
		datoGeneral.setdValorDouble(total_consumo_especialTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaConstantesFunciones.RETENCION);
		datoGeneral.setsDescripcion(FacturaConstantesFunciones.LABEL_RETENCION);
		datoGeneral.setdValorDouble(retencionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaFactura() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_ID, FacturaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_VERSIONROW, FacturaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_IDEMPRESA, FacturaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_IDSUCURSAL, FacturaConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_IDEJERCICIO, FacturaConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_IDPERIODO, FacturaConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_IDANIO, FacturaConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_IDMES, FacturaConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_IDUSUARIO, FacturaConstantesFunciones.IDUSUARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_NUMEROPREIMPRESO, FacturaConstantesFunciones.NUMEROPREIMPRESO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_FECHAEMISION, FacturaConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_NUMERODIAS, FacturaConstantesFunciones.NUMERODIAS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_FECHAVENCIMIENTO, FacturaConstantesFunciones.FECHAVENCIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_IDMONEDA, FacturaConstantesFunciones.IDMONEDA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_COTIZACION, FacturaConstantesFunciones.COTIZACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_IDEMPLEADO, FacturaConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_IDFORMATO, FacturaConstantesFunciones.IDFORMATO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_DIRECCION, FacturaConstantesFunciones.DIRECCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_RUC, FacturaConstantesFunciones.RUC,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_IDCLIENTE, FacturaConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_IDTIPOPRECIO, FacturaConstantesFunciones.IDTIPOPRECIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_TELEFONO, FacturaConstantesFunciones.TELEFONO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_IDSUBCLIENTE, FacturaConstantesFunciones.IDSUBCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_IDVENDEDOR, FacturaConstantesFunciones.IDVENDEDOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_IDTRANSPORTE, FacturaConstantesFunciones.IDTRANSPORTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_IDTRANSPORTISTA, FacturaConstantesFunciones.IDTRANSPORTISTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_ORDEN, FacturaConstantesFunciones.ORDEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_IDTIPOLLAMADA, FacturaConstantesFunciones.IDTIPOLLAMADA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_HORAINICIO, FacturaConstantesFunciones.HORAINICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_HORAFIN, FacturaConstantesFunciones.HORAFIN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_IDTIPOFACTURA, FacturaConstantesFunciones.IDTIPOFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_DESCRIPCION, FacturaConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_CUPO, FacturaConstantesFunciones.CUPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_SALDO, FacturaConstantesFunciones.SALDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_DOCUMENTOS, FacturaConstantesFunciones.DOCUMENTOS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_DISPONIBLE, FacturaConstantesFunciones.DISPONIBLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_PORCENTAJEDESCUENTO, FacturaConstantesFunciones.PORCENTAJEDESCUENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_TOTALIVA, FacturaConstantesFunciones.TOTALIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_SUMAN, FacturaConstantesFunciones.SUMAN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_DESCUENTOVALOR, FacturaConstantesFunciones.DESCUENTOVALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_TOTALSINIVA, FacturaConstantesFunciones.TOTALSINIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_TOTALDESCUENTO, FacturaConstantesFunciones.TOTALDESCUENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_TOTALFLETE, FacturaConstantesFunciones.TOTALFLETE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_TOTAL, FacturaConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_SUBTOTAL, FacturaConstantesFunciones.SUBTOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_TOTALOTRO, FacturaConstantesFunciones.TOTALOTRO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_ULTIMOCOSTO, FacturaConstantesFunciones.ULTIMOCOSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_IVA, FacturaConstantesFunciones.IVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_DESCUENTO, FacturaConstantesFunciones.DESCUENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_FINANCIAMIENTO, FacturaConstantesFunciones.FINANCIAMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_MARGENUTILIDAD, FacturaConstantesFunciones.MARGENUTILIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_ICE, FacturaConstantesFunciones.ICE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_ANTICIPO, FacturaConstantesFunciones.ANTICIPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_OTROSVALORES, FacturaConstantesFunciones.OTROSVALORES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_TOTALRETENCION, FacturaConstantesFunciones.TOTALRETENCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_TOTALCONSUMOESPECIAL, FacturaConstantesFunciones.TOTALCONSUMOESPECIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_RETENCION, FacturaConstantesFunciones.RETENCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_IDTIPOCAMBIO, FacturaConstantesFunciones.IDTIPOCAMBIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_ESCLIENTE, FacturaConstantesFunciones.ESCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_IDASIENTOCONTABLE, FacturaConstantesFunciones.IDASIENTOCONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_IDPEDIDO, FacturaConstantesFunciones.IDPEDIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_IDRESPONSABLE, FacturaConstantesFunciones.IDRESPONSABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_IDESTADOFISICOFACTURAEMPRESA, FacturaConstantesFunciones.IDESTADOFISICOFACTURAEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_FECHA, FacturaConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_FECHAAUTORIZACION, FacturaConstantesFunciones.FECHAAUTORIZACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_FECHACLIENTE, FacturaConstantesFunciones.FECHACLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_NUMERODOCUMENTO, FacturaConstantesFunciones.NUMERODOCUMENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_NUMERODAU, FacturaConstantesFunciones.NUMERODAU,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_NUMEROREFERENDO, FacturaConstantesFunciones.NUMEROREFERENDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_FECHAREFERENDO, FacturaConstantesFunciones.FECHAREFERENDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaConstantesFunciones.LABEL_AFOROREFERENDO, FacturaConstantesFunciones.AFOROREFERENDO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasFactura() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.IDUSUARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.NUMEROPREIMPRESO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.NUMERODIAS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.FECHAVENCIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.IDMONEDA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.COTIZACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.IDFORMATO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.DIRECCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.RUC;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.IDTIPOPRECIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.TELEFONO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.IDSUBCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.IDVENDEDOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.IDTRANSPORTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.IDTRANSPORTISTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.ORDEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.IDTIPOLLAMADA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.HORAINICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.HORAFIN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.IDTIPOFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.CUPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.SALDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.DOCUMENTOS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.DISPONIBLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.PORCENTAJEDESCUENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.TOTALIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.SUMAN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.DESCUENTOVALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.TOTALSINIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.TOTALDESCUENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.TOTALFLETE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.SUBTOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.TOTALOTRO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.ULTIMOCOSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.IVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.DESCUENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.FINANCIAMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.MARGENUTILIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.ICE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.ANTICIPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.OTROSVALORES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.TOTALRETENCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.TOTALCONSUMOESPECIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.RETENCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.IDTIPOCAMBIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.ESCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.IDASIENTOCONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.IDPEDIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.IDRESPONSABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.IDESTADOFISICOFACTURAEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.FECHAAUTORIZACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.FECHACLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.NUMERODOCUMENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.NUMERODAU;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.NUMEROREFERENDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.FECHAREFERENDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaConstantesFunciones.AFOROREFERENDO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFactura() throws Exception  {
		return FacturaConstantesFunciones.getTiposSeleccionarFactura(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFactura(Boolean conFk) throws Exception  {
		return FacturaConstantesFunciones.getTiposSeleccionarFactura(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFactura(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(FacturaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(FacturaConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(FacturaConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(FacturaConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(FacturaConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(FacturaConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaConstantesFunciones.LABEL_IDUSUARIO);
			reporte.setsDescripcion(FacturaConstantesFunciones.LABEL_IDUSUARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaConstantesFunciones.LABEL_NUMEROPREIMPRESO);
			reporte.setsDescripcion(FacturaConstantesFunciones.LABEL_NUMEROPREIMPRESO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(FacturaConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaConstantesFunciones.LABEL_NUMERODIAS);
			reporte.setsDescripcion(FacturaConstantesFunciones.LABEL_NUMERODIAS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaConstantesFunciones.LABEL_FECHAVENCIMIENTO);
			reporte.setsDescripcion(FacturaConstantesFunciones.LABEL_FECHAVENCIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaConstantesFunciones.LABEL_IDMONEDA);
			reporte.setsDescripcion(FacturaConstantesFunciones.LABEL_IDMONEDA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaConstantesFunciones.LABEL_COTIZACION);
			reporte.setsDescripcion(FacturaConstantesFunciones.LABEL_COTIZACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(FacturaConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaConstantesFunciones.LABEL_IDFORMATO);
			reporte.setsDescripcion(FacturaConstantesFunciones.LABEL_IDFORMATO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaConstantesFunciones.LABEL_DIRECCION);
			reporte.setsDescripcion(FacturaConstantesFunciones.LABEL_DIRECCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaConstantesFunciones.LABEL_RUC);
			reporte.setsDescripcion(FacturaConstantesFunciones.LABEL_RUC);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(FacturaConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaConstantesFunciones.LABEL_IDTIPOPRECIO);
			reporte.setsDescripcion(FacturaConstantesFunciones.LABEL_IDTIPOPRECIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaConstantesFunciones.LABEL_TELEFONO);
			reporte.setsDescripcion(FacturaConstantesFunciones.LABEL_TELEFONO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaConstantesFunciones.LABEL_IDSUBCLIENTE);
			reporte.setsDescripcion(FacturaConstantesFunciones.LABEL_IDSUBCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaConstantesFunciones.LABEL_IDVENDEDOR);
			reporte.setsDescripcion(FacturaConstantesFunciones.LABEL_IDVENDEDOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaConstantesFunciones.LABEL_IDTRANSPORTE);
			reporte.setsDescripcion(FacturaConstantesFunciones.LABEL_IDTRANSPORTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaConstantesFunciones.LABEL_IDTRANSPORTISTA);
			reporte.setsDescripcion(FacturaConstantesFunciones.LABEL_IDTRANSPORTISTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaConstantesFunciones.LABEL_ORDEN);
			reporte.setsDescripcion(FacturaConstantesFunciones.LABEL_ORDEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaConstantesFunciones.LABEL_IDTIPOLLAMADA);
			reporte.setsDescripcion(FacturaConstantesFunciones.LABEL_IDTIPOLLAMADA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		reporte=new Reporte();
		reporte.setsCodigo(FacturaConstantesFunciones.LABEL_HORAINICIO);
		reporte.setsDescripcion(FacturaConstantesFunciones.LABEL_HORAINICIO);

		arrTiposSeleccionarTodos.add(reporte);
		reporte=new Reporte();
		reporte.setsCodigo(FacturaConstantesFunciones.LABEL_HORAFIN);
		reporte.setsDescripcion(FacturaConstantesFunciones.LABEL_HORAFIN);

		arrTiposSeleccionarTodos.add(reporte);
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaConstantesFunciones.LABEL_IDTIPOFACTURA);
			reporte.setsDescripcion(FacturaConstantesFunciones.LABEL_IDTIPOFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(FacturaConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaConstantesFunciones.LABEL_CUPO);
			reporte.setsDescripcion(FacturaConstantesFunciones.LABEL_CUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaConstantesFunciones.LABEL_SALDO);
			reporte.setsDescripcion(FacturaConstantesFunciones.LABEL_SALDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaConstantesFunciones.LABEL_DOCUMENTOS);
			reporte.setsDescripcion(FacturaConstantesFunciones.LABEL_DOCUMENTOS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaConstantesFunciones.LABEL_DISPONIBLE);
			reporte.setsDescripcion(FacturaConstantesFunciones.LABEL_DISPONIBLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaConstantesFunciones.LABEL_PORCENTAJEDESCUENTO);
			reporte.setsDescripcion(FacturaConstantesFunciones.LABEL_PORCENTAJEDESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaConstantesFunciones.LABEL_TOTALIVA);
			reporte.setsDescripcion(FacturaConstantesFunciones.LABEL_TOTALIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaConstantesFunciones.LABEL_SUMAN);
			reporte.setsDescripcion(FacturaConstantesFunciones.LABEL_SUMAN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaConstantesFunciones.LABEL_DESCUENTOVALOR);
			reporte.setsDescripcion(FacturaConstantesFunciones.LABEL_DESCUENTOVALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaConstantesFunciones.LABEL_TOTALSINIVA);
			reporte.setsDescripcion(FacturaConstantesFunciones.LABEL_TOTALSINIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaConstantesFunciones.LABEL_TOTALDESCUENTO);
			reporte.setsDescripcion(FacturaConstantesFunciones.LABEL_TOTALDESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaConstantesFunciones.LABEL_TOTALFLETE);
			reporte.setsDescripcion(FacturaConstantesFunciones.LABEL_TOTALFLETE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(FacturaConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaConstantesFunciones.LABEL_SUBTOTAL);
			reporte.setsDescripcion(FacturaConstantesFunciones.LABEL_SUBTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaConstantesFunciones.LABEL_TOTALOTRO);
			reporte.setsDescripcion(FacturaConstantesFunciones.LABEL_TOTALOTRO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaConstantesFunciones.LABEL_ULTIMOCOSTO);
			reporte.setsDescripcion(FacturaConstantesFunciones.LABEL_ULTIMOCOSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaConstantesFunciones.LABEL_IVA);
			reporte.setsDescripcion(FacturaConstantesFunciones.LABEL_IVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaConstantesFunciones.LABEL_DESCUENTO);
			reporte.setsDescripcion(FacturaConstantesFunciones.LABEL_DESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaConstantesFunciones.LABEL_FINANCIAMIENTO);
			reporte.setsDescripcion(FacturaConstantesFunciones.LABEL_FINANCIAMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaConstantesFunciones.LABEL_MARGENUTILIDAD);
			reporte.setsDescripcion(FacturaConstantesFunciones.LABEL_MARGENUTILIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaConstantesFunciones.LABEL_ICE);
			reporte.setsDescripcion(FacturaConstantesFunciones.LABEL_ICE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaConstantesFunciones.LABEL_ANTICIPO);
			reporte.setsDescripcion(FacturaConstantesFunciones.LABEL_ANTICIPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaConstantesFunciones.LABEL_OTROSVALORES);
			reporte.setsDescripcion(FacturaConstantesFunciones.LABEL_OTROSVALORES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaConstantesFunciones.LABEL_TOTALRETENCION);
			reporte.setsDescripcion(FacturaConstantesFunciones.LABEL_TOTALRETENCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaConstantesFunciones.LABEL_TOTALCONSUMOESPECIAL);
			reporte.setsDescripcion(FacturaConstantesFunciones.LABEL_TOTALCONSUMOESPECIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaConstantesFunciones.LABEL_RETENCION);
			reporte.setsDescripcion(FacturaConstantesFunciones.LABEL_RETENCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaConstantesFunciones.LABEL_IDTIPOCAMBIO);
			reporte.setsDescripcion(FacturaConstantesFunciones.LABEL_IDTIPOCAMBIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaConstantesFunciones.LABEL_ESCLIENTE);
			reporte.setsDescripcion(FacturaConstantesFunciones.LABEL_ESCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaConstantesFunciones.LABEL_IDASIENTOCONTABLE);
			reporte.setsDescripcion(FacturaConstantesFunciones.LABEL_IDASIENTOCONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaConstantesFunciones.LABEL_IDPEDIDO);
			reporte.setsDescripcion(FacturaConstantesFunciones.LABEL_IDPEDIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaConstantesFunciones.LABEL_IDRESPONSABLE);
			reporte.setsDescripcion(FacturaConstantesFunciones.LABEL_IDRESPONSABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaConstantesFunciones.LABEL_IDESTADOFISICOFACTURAEMPRESA);
			reporte.setsDescripcion(FacturaConstantesFunciones.LABEL_IDESTADOFISICOFACTURAEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(FacturaConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaConstantesFunciones.LABEL_FECHAAUTORIZACION);
			reporte.setsDescripcion(FacturaConstantesFunciones.LABEL_FECHAAUTORIZACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaConstantesFunciones.LABEL_FECHACLIENTE);
			reporte.setsDescripcion(FacturaConstantesFunciones.LABEL_FECHACLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaConstantesFunciones.LABEL_NUMERODOCUMENTO);
			reporte.setsDescripcion(FacturaConstantesFunciones.LABEL_NUMERODOCUMENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaConstantesFunciones.LABEL_NUMERODAU);
			reporte.setsDescripcion(FacturaConstantesFunciones.LABEL_NUMERODAU);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaConstantesFunciones.LABEL_NUMEROREFERENDO);
			reporte.setsDescripcion(FacturaConstantesFunciones.LABEL_NUMEROREFERENDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaConstantesFunciones.LABEL_FECHAREFERENDO);
			reporte.setsDescripcion(FacturaConstantesFunciones.LABEL_FECHAREFERENDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaConstantesFunciones.LABEL_AFOROREFERENDO);
			reporte.setsDescripcion(FacturaConstantesFunciones.LABEL_AFOROREFERENDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesFactura(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesFactura(Factura facturaAux) throws Exception {
		
			facturaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(facturaAux.getEmpresa()));
			facturaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(facturaAux.getSucursal()));
			facturaAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(facturaAux.getEjercicio()));
			facturaAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(facturaAux.getPeriodo()));
			facturaAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(facturaAux.getAnio()));
			facturaAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(facturaAux.getMes()));
			facturaAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(facturaAux.getUsuario()));
			facturaAux.setmoneda_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(facturaAux.getMoneda()));
			facturaAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(facturaAux.getEmpleado()));
			facturaAux.setformato_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(facturaAux.getFormato()));
			facturaAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(facturaAux.getCliente()));
			facturaAux.settipoprecio_descripcion(TipoPrecioConstantesFunciones.getTipoPrecioDescripcion(facturaAux.getTipoPrecio()));
			facturaAux.setsubcliente_descripcion(SubClienteConstantesFunciones.getSubClienteDescripcion(facturaAux.getSubCliente()));
			facturaAux.setvendedor_descripcion(VendedorConstantesFunciones.getVendedorDescripcion(facturaAux.getVendedor()));
			facturaAux.settransporte_descripcion(TransporteConstantesFunciones.getTransporteDescripcion(facturaAux.getTransporte()));
			facturaAux.settransportista_descripcion(TransportistaConstantesFunciones.getTransportistaDescripcion(facturaAux.getTransportista()));
			facturaAux.settipollamada_descripcion(TipoLlamadaConstantesFunciones.getTipoLlamadaDescripcion(facturaAux.getTipoLlamada()));
			facturaAux.settipofactura_descripcion(TipoFacturaConstantesFunciones.getTipoFacturaDescripcion(facturaAux.getTipoFactura()));
			facturaAux.settipocambio_descripcion(TipoCambioConstantesFunciones.getTipoCambioDescripcion(facturaAux.getTipoCambio()));
			facturaAux.setasientocontable_descripcion(AsientoContableConstantesFunciones.getAsientoContableDescripcion(facturaAux.getAsientoContable()));
			facturaAux.setpedido_descripcion(PedidoConstantesFunciones.getPedidoDescripcion(facturaAux.getPedido()));
			facturaAux.setresponsable_descripcion(ResponsableConstantesFunciones.getResponsableDescripcion(facturaAux.getResponsable()));
			facturaAux.setestadofisicofacturaempresa_descripcion(EstadoFisicoFacturaEmpresaConstantesFunciones.getEstadoFisicoFacturaEmpresaDescripcion(facturaAux.getEstadoFisicoFacturaEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesFactura(List<Factura> facturasTemp) throws Exception {
		for(Factura facturaAux:facturasTemp) {
			
			facturaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(facturaAux.getEmpresa()));
			facturaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(facturaAux.getSucursal()));
			facturaAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(facturaAux.getEjercicio()));
			facturaAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(facturaAux.getPeriodo()));
			facturaAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(facturaAux.getAnio()));
			facturaAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(facturaAux.getMes()));
			facturaAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(facturaAux.getUsuario()));
			facturaAux.setmoneda_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(facturaAux.getMoneda()));
			facturaAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(facturaAux.getEmpleado()));
			facturaAux.setformato_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(facturaAux.getFormato()));
			facturaAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(facturaAux.getCliente()));
			facturaAux.settipoprecio_descripcion(TipoPrecioConstantesFunciones.getTipoPrecioDescripcion(facturaAux.getTipoPrecio()));
			facturaAux.setsubcliente_descripcion(SubClienteConstantesFunciones.getSubClienteDescripcion(facturaAux.getSubCliente()));
			facturaAux.setvendedor_descripcion(VendedorConstantesFunciones.getVendedorDescripcion(facturaAux.getVendedor()));
			facturaAux.settransporte_descripcion(TransporteConstantesFunciones.getTransporteDescripcion(facturaAux.getTransporte()));
			facturaAux.settransportista_descripcion(TransportistaConstantesFunciones.getTransportistaDescripcion(facturaAux.getTransportista()));
			facturaAux.settipollamada_descripcion(TipoLlamadaConstantesFunciones.getTipoLlamadaDescripcion(facturaAux.getTipoLlamada()));
			facturaAux.settipofactura_descripcion(TipoFacturaConstantesFunciones.getTipoFacturaDescripcion(facturaAux.getTipoFactura()));
			facturaAux.settipocambio_descripcion(TipoCambioConstantesFunciones.getTipoCambioDescripcion(facturaAux.getTipoCambio()));
			facturaAux.setasientocontable_descripcion(AsientoContableConstantesFunciones.getAsientoContableDescripcion(facturaAux.getAsientoContable()));
			facturaAux.setpedido_descripcion(PedidoConstantesFunciones.getPedidoDescripcion(facturaAux.getPedido()));
			facturaAux.setresponsable_descripcion(ResponsableConstantesFunciones.getResponsableDescripcion(facturaAux.getResponsable()));
			facturaAux.setestadofisicofacturaempresa_descripcion(EstadoFisicoFacturaEmpresaConstantesFunciones.getEstadoFisicoFacturaEmpresaDescripcion(facturaAux.getEstadoFisicoFacturaEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfFactura(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(TipoPrecio.class));
				classes.add(new Classe(SubCliente.class));
				classes.add(new Classe(Vendedor.class));
				classes.add(new Classe(Transporte.class));
				classes.add(new Classe(Transportista.class));
				classes.add(new Classe(TipoLlamada.class));
				classes.add(new Classe(TipoFactura.class));
				classes.add(new Classe(TipoCambio.class));
				classes.add(new Classe(AsientoContable.class));
				classes.add(new Classe(Pedido.class));
				classes.add(new Classe(Responsable.class));
				classes.add(new Classe(EstadoFisicoFacturaEmpresa.class));
				
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
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoPrecio.class)) {
						classes.add(new Classe(TipoPrecio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(SubCliente.class)) {
						classes.add(new Classe(SubCliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Vendedor.class)) {
						classes.add(new Classe(Vendedor.class));
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

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoLlamada.class)) {
						classes.add(new Classe(TipoLlamada.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoFactura.class)) {
						classes.add(new Classe(TipoFactura.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoCambio.class)) {
						classes.add(new Classe(TipoCambio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(AsientoContable.class)) {
						classes.add(new Classe(AsientoContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Pedido.class)) {
						classes.add(new Classe(Pedido.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Responsable.class)) {
						classes.add(new Classe(Responsable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EstadoFisicoFacturaEmpresa.class)) {
						classes.add(new Classe(EstadoFisicoFacturaEmpresa.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfFactura(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(TipoPrecio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoPrecio.class)); continue;
					}

					if(SubCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(SubCliente.class)); continue;
					}

					if(Vendedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Vendedor.class)); continue;
					}

					if(Transporte.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transporte.class)); continue;
					}

					if(Transportista.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transportista.class)); continue;
					}

					if(TipoLlamada.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoLlamada.class)); continue;
					}

					if(TipoFactura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoFactura.class)); continue;
					}

					if(TipoCambio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCambio.class)); continue;
					}

					if(AsientoContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsientoContable.class)); continue;
					}

					if(Pedido.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pedido.class)); continue;
					}

					if(Responsable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Responsable.class)); continue;
					}

					if(EstadoFisicoFacturaEmpresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoFisicoFacturaEmpresa.class)); continue;
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

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(TipoPrecio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoPrecio.class)); continue;
					}

					if(SubCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(SubCliente.class)); continue;
					}

					if(Vendedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Vendedor.class)); continue;
					}

					if(Transporte.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transporte.class)); continue;
					}

					if(Transportista.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transportista.class)); continue;
					}

					if(TipoLlamada.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoLlamada.class)); continue;
					}

					if(TipoFactura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoFactura.class)); continue;
					}

					if(TipoCambio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCambio.class)); continue;
					}

					if(AsientoContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsientoContable.class)); continue;
					}

					if(Pedido.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pedido.class)); continue;
					}

					if(Responsable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Responsable.class)); continue;
					}

					if(EstadoFisicoFacturaEmpresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoFisicoFacturaEmpresa.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfFactura(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return FacturaConstantesFunciones.getClassesRelationshipsOfFactura(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfFactura(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(DetaFormaPago.class));
				classes.add(new Classe(DetalleFactura.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(DetaFormaPago.class)) {
						classes.add(new Classe(DetaFormaPago.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleFactura.class)) {
						classes.add(new Classe(DetalleFactura.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfFactura(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return FacturaConstantesFunciones.getClassesRelationshipsFromStringsOfFactura(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfFactura(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(DetaFormaPago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetaFormaPago.class)); continue;
					}

					if(DetalleFactura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleFactura.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(DetaFormaPago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetaFormaPago.class)); continue;
					}

					if(DetalleFactura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleFactura.class)); continue;
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
	public static void actualizarLista(Factura factura,List<Factura> facturas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Factura facturaEncontrado=null;
			
			for(Factura facturaLocal:facturas) {
				if(facturaLocal.getId().equals(factura.getId())) {
					facturaEncontrado=facturaLocal;
					
					facturaLocal.setIsChanged(factura.getIsChanged());
					facturaLocal.setIsNew(factura.getIsNew());
					facturaLocal.setIsDeleted(factura.getIsDeleted());
					
					facturaLocal.setGeneralEntityOriginal(factura.getGeneralEntityOriginal());
					
					facturaLocal.setId(factura.getId());	
					facturaLocal.setVersionRow(factura.getVersionRow());	
					facturaLocal.setid_empresa(factura.getid_empresa());	
					facturaLocal.setid_sucursal(factura.getid_sucursal());	
					facturaLocal.setid_ejercicio(factura.getid_ejercicio());	
					facturaLocal.setid_periodo(factura.getid_periodo());	
					facturaLocal.setid_anio(factura.getid_anio());	
					facturaLocal.setid_mes(factura.getid_mes());	
					facturaLocal.setid_usuario(factura.getid_usuario());	
					facturaLocal.setnumero_pre_impreso(factura.getnumero_pre_impreso());	
					facturaLocal.setfecha_emision(factura.getfecha_emision());	
					facturaLocal.setnumero_dias(factura.getnumero_dias());	
					facturaLocal.setfecha_vencimiento(factura.getfecha_vencimiento());	
					facturaLocal.setid_moneda(factura.getid_moneda());	
					facturaLocal.setcotizacion(factura.getcotizacion());	
					facturaLocal.setid_empleado(factura.getid_empleado());	
					facturaLocal.setid_formato(factura.getid_formato());	
					facturaLocal.setdireccion(factura.getdireccion());	
					facturaLocal.setruc(factura.getruc());	
					facturaLocal.setid_cliente(factura.getid_cliente());	
					facturaLocal.setid_tipo_precio(factura.getid_tipo_precio());	
					facturaLocal.settelefono(factura.gettelefono());	
					facturaLocal.setid_sub_cliente(factura.getid_sub_cliente());	
					facturaLocal.setid_vendedor(factura.getid_vendedor());	
					facturaLocal.setid_transporte(factura.getid_transporte());	
					facturaLocal.setid_transportista(factura.getid_transportista());	
					facturaLocal.setorden(factura.getorden());	
					facturaLocal.setid_tipo_llamada(factura.getid_tipo_llamada());	
					facturaLocal.sethora_inicio(factura.gethora_inicio());	
					facturaLocal.sethora_fin(factura.gethora_fin());	
					facturaLocal.setid_tipo_factura(factura.getid_tipo_factura());	
					facturaLocal.setdescripcion(factura.getdescripcion());	
					facturaLocal.setcupo(factura.getcupo());	
					facturaLocal.setsaldo(factura.getsaldo());	
					facturaLocal.setdocumentos(factura.getdocumentos());	
					facturaLocal.setdisponible(factura.getdisponible());	
					facturaLocal.setporcentaje_descuento(factura.getporcentaje_descuento());	
					facturaLocal.settotal_iva(factura.gettotal_iva());	
					facturaLocal.setsuman(factura.getsuman());	
					facturaLocal.setdescuento_valor(factura.getdescuento_valor());	
					facturaLocal.settotal_sin_iva(factura.gettotal_sin_iva());	
					facturaLocal.settotal_descuento(factura.gettotal_descuento());	
					facturaLocal.settotal_flete(factura.gettotal_flete());	
					facturaLocal.settotal(factura.gettotal());	
					facturaLocal.setsub_total(factura.getsub_total());	
					facturaLocal.settotal_otro(factura.gettotal_otro());	
					facturaLocal.setultimo_costo(factura.getultimo_costo());	
					facturaLocal.setiva(factura.getiva());	
					facturaLocal.setdescuento(factura.getdescuento());	
					facturaLocal.setfinanciamiento(factura.getfinanciamiento());	
					facturaLocal.setmargen_utilidad(factura.getmargen_utilidad());	
					facturaLocal.setice(factura.getice());	
					facturaLocal.setanticipo(factura.getanticipo());	
					facturaLocal.setotros_valores(factura.getotros_valores());	
					facturaLocal.settotal_retencion(factura.gettotal_retencion());	
					facturaLocal.settotal_consumo_especial(factura.gettotal_consumo_especial());	
					facturaLocal.setretencion(factura.getretencion());	
					facturaLocal.setid_tipo_cambio(factura.getid_tipo_cambio());	
					facturaLocal.setes_cliente(factura.getes_cliente());	
					facturaLocal.setid_asiento_contable(factura.getid_asiento_contable());	
					facturaLocal.setid_pedido(factura.getid_pedido());	
					facturaLocal.setid_responsable(factura.getid_responsable());	
					facturaLocal.setid_estado_fisico_factura_empresa(factura.getid_estado_fisico_factura_empresa());	
					facturaLocal.setfecha(factura.getfecha());	
					facturaLocal.setfecha_autorizacion(factura.getfecha_autorizacion());	
					facturaLocal.setfecha_cliente(factura.getfecha_cliente());	
					facturaLocal.setnumero_documento(factura.getnumero_documento());	
					facturaLocal.setnumero_dau(factura.getnumero_dau());	
					facturaLocal.setnumero_referendo(factura.getnumero_referendo());	
					facturaLocal.setfecha_referendo(factura.getfecha_referendo());	
					facturaLocal.setaforo_referendo(factura.getaforo_referendo());	
					
					
					facturaLocal.setDetaFormaPagos(factura.getDetaFormaPagos());
					facturaLocal.setDetalleFacturas(factura.getDetalleFacturas());
					
					existe=true;
					break;
				}
			}
			
			if(!factura.getIsDeleted()) {
				if(!existe) {
					facturas.add(factura);
				}
			} else {
				if(facturaEncontrado!=null && permiteQuitar)  {
					facturas.remove(facturaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Factura factura,List<Factura> facturas) throws Exception {
		try	{			
			for(Factura facturaLocal:facturas) {
				if(facturaLocal.getId().equals(factura.getId())) {
					facturaLocal.setIsSelected(factura.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesFactura(List<Factura> facturasAux) throws Exception {
		//this.facturasAux=facturasAux;
		
		for(Factura facturaAux:facturasAux) {
			if(facturaAux.getIsChanged()) {
				facturaAux.setIsChanged(false);
			}		
			
			if(facturaAux.getIsNew()) {
				facturaAux.setIsNew(false);
			}	
			
			if(facturaAux.getIsDeleted()) {
				facturaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesFactura(Factura facturaAux) throws Exception {
		//this.facturaAux=facturaAux;
		
			if(facturaAux.getIsChanged()) {
				facturaAux.setIsChanged(false);
			}		
			
			if(facturaAux.getIsNew()) {
				facturaAux.setIsNew(false);
			}	
			
			if(facturaAux.getIsDeleted()) {
				facturaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Factura facturaAsignar,Factura factura) throws Exception {
		facturaAsignar.setId(factura.getId());	
		facturaAsignar.setVersionRow(factura.getVersionRow());	
		facturaAsignar.setid_empresa(factura.getid_empresa());
		facturaAsignar.setempresa_descripcion(factura.getempresa_descripcion());	
		facturaAsignar.setid_sucursal(factura.getid_sucursal());
		facturaAsignar.setsucursal_descripcion(factura.getsucursal_descripcion());	
		facturaAsignar.setid_ejercicio(factura.getid_ejercicio());
		facturaAsignar.setejercicio_descripcion(factura.getejercicio_descripcion());	
		facturaAsignar.setid_periodo(factura.getid_periodo());
		facturaAsignar.setperiodo_descripcion(factura.getperiodo_descripcion());	
		facturaAsignar.setid_anio(factura.getid_anio());
		facturaAsignar.setanio_descripcion(factura.getanio_descripcion());	
		facturaAsignar.setid_mes(factura.getid_mes());
		facturaAsignar.setmes_descripcion(factura.getmes_descripcion());	
		facturaAsignar.setid_usuario(factura.getid_usuario());
		facturaAsignar.setusuario_descripcion(factura.getusuario_descripcion());	
		facturaAsignar.setnumero_pre_impreso(factura.getnumero_pre_impreso());	
		facturaAsignar.setfecha_emision(factura.getfecha_emision());	
		facturaAsignar.setnumero_dias(factura.getnumero_dias());	
		facturaAsignar.setfecha_vencimiento(factura.getfecha_vencimiento());	
		facturaAsignar.setid_moneda(factura.getid_moneda());
		facturaAsignar.setmoneda_descripcion(factura.getmoneda_descripcion());	
		facturaAsignar.setcotizacion(factura.getcotizacion());	
		facturaAsignar.setid_empleado(factura.getid_empleado());
		facturaAsignar.setempleado_descripcion(factura.getempleado_descripcion());	
		facturaAsignar.setid_formato(factura.getid_formato());
		facturaAsignar.setformato_descripcion(factura.getformato_descripcion());	
		facturaAsignar.setdireccion(factura.getdireccion());	
		facturaAsignar.setruc(factura.getruc());	
		facturaAsignar.setid_cliente(factura.getid_cliente());
		facturaAsignar.setcliente_descripcion(factura.getcliente_descripcion());	
		facturaAsignar.setid_tipo_precio(factura.getid_tipo_precio());
		facturaAsignar.settipoprecio_descripcion(factura.gettipoprecio_descripcion());	
		facturaAsignar.settelefono(factura.gettelefono());	
		facturaAsignar.setid_sub_cliente(factura.getid_sub_cliente());
		facturaAsignar.setsubcliente_descripcion(factura.getsubcliente_descripcion());	
		facturaAsignar.setid_vendedor(factura.getid_vendedor());
		facturaAsignar.setvendedor_descripcion(factura.getvendedor_descripcion());	
		facturaAsignar.setid_transporte(factura.getid_transporte());
		facturaAsignar.settransporte_descripcion(factura.gettransporte_descripcion());	
		facturaAsignar.setid_transportista(factura.getid_transportista());
		facturaAsignar.settransportista_descripcion(factura.gettransportista_descripcion());	
		facturaAsignar.setorden(factura.getorden());	
		facturaAsignar.setid_tipo_llamada(factura.getid_tipo_llamada());
		facturaAsignar.settipollamada_descripcion(factura.gettipollamada_descripcion());	
		facturaAsignar.sethora_inicio(factura.gethora_inicio());	
		facturaAsignar.sethora_fin(factura.gethora_fin());	
		facturaAsignar.setid_tipo_factura(factura.getid_tipo_factura());
		facturaAsignar.settipofactura_descripcion(factura.gettipofactura_descripcion());	
		facturaAsignar.setdescripcion(factura.getdescripcion());	
		facturaAsignar.setcupo(factura.getcupo());	
		facturaAsignar.setsaldo(factura.getsaldo());	
		facturaAsignar.setdocumentos(factura.getdocumentos());	
		facturaAsignar.setdisponible(factura.getdisponible());	
		facturaAsignar.setporcentaje_descuento(factura.getporcentaje_descuento());	
		facturaAsignar.settotal_iva(factura.gettotal_iva());	
		facturaAsignar.setsuman(factura.getsuman());	
		facturaAsignar.setdescuento_valor(factura.getdescuento_valor());	
		facturaAsignar.settotal_sin_iva(factura.gettotal_sin_iva());	
		facturaAsignar.settotal_descuento(factura.gettotal_descuento());	
		facturaAsignar.settotal_flete(factura.gettotal_flete());	
		facturaAsignar.settotal(factura.gettotal());	
		facturaAsignar.setsub_total(factura.getsub_total());	
		facturaAsignar.settotal_otro(factura.gettotal_otro());	
		facturaAsignar.setultimo_costo(factura.getultimo_costo());	
		facturaAsignar.setiva(factura.getiva());	
		facturaAsignar.setdescuento(factura.getdescuento());	
		facturaAsignar.setfinanciamiento(factura.getfinanciamiento());	
		facturaAsignar.setmargen_utilidad(factura.getmargen_utilidad());	
		facturaAsignar.setice(factura.getice());	
		facturaAsignar.setanticipo(factura.getanticipo());	
		facturaAsignar.setotros_valores(factura.getotros_valores());	
		facturaAsignar.settotal_retencion(factura.gettotal_retencion());	
		facturaAsignar.settotal_consumo_especial(factura.gettotal_consumo_especial());	
		facturaAsignar.setretencion(factura.getretencion());	
		facturaAsignar.setid_tipo_cambio(factura.getid_tipo_cambio());
		facturaAsignar.settipocambio_descripcion(factura.gettipocambio_descripcion());	
		facturaAsignar.setes_cliente(factura.getes_cliente());	
		facturaAsignar.setid_asiento_contable(factura.getid_asiento_contable());
		facturaAsignar.setasientocontable_descripcion(factura.getasientocontable_descripcion());	
		facturaAsignar.setid_pedido(factura.getid_pedido());
		facturaAsignar.setpedido_descripcion(factura.getpedido_descripcion());	
		facturaAsignar.setid_responsable(factura.getid_responsable());
		facturaAsignar.setresponsable_descripcion(factura.getresponsable_descripcion());	
		facturaAsignar.setid_estado_fisico_factura_empresa(factura.getid_estado_fisico_factura_empresa());
		facturaAsignar.setestadofisicofacturaempresa_descripcion(factura.getestadofisicofacturaempresa_descripcion());	
		facturaAsignar.setfecha(factura.getfecha());	
		facturaAsignar.setfecha_autorizacion(factura.getfecha_autorizacion());	
		facturaAsignar.setfecha_cliente(factura.getfecha_cliente());	
		facturaAsignar.setnumero_documento(factura.getnumero_documento());	
		facturaAsignar.setnumero_dau(factura.getnumero_dau());	
		facturaAsignar.setnumero_referendo(factura.getnumero_referendo());	
		facturaAsignar.setfecha_referendo(factura.getfecha_referendo());	
		facturaAsignar.setaforo_referendo(factura.getaforo_referendo());	
	}
	
	public static void inicializarFactura(Factura factura) throws Exception {
		try {
				factura.setId(0L);	
					
				factura.setid_empresa(-1L);	
				factura.setid_sucursal(-1L);	
				factura.setid_ejercicio(-1L);	
				factura.setid_periodo(-1L);	
				factura.setid_anio(null);	
				factura.setid_mes(null);	
				factura.setid_usuario(-1L);	
				factura.setnumero_pre_impreso("");	
				factura.setfecha_emision(new Date());	
				factura.setnumero_dias(0);	
				factura.setfecha_vencimiento(new Date());	
				factura.setid_moneda(-1L);	
				factura.setcotizacion(0.0);	
				factura.setid_empleado(-1L);	
				factura.setid_formato(-1L);	
				factura.setdireccion("");	
				factura.setruc("");	
				factura.setid_cliente(-1L);	
				factura.setid_tipo_precio(-1L);	
				factura.settelefono("");	
				factura.setid_sub_cliente(null);	
				factura.setid_vendedor(-1L);	
				factura.setid_transporte(null);	
				factura.setid_transportista(null);	
				factura.setorden("");	
				factura.setid_tipo_llamada(-1L);	
				factura.sethora_inicio(new Time((new Date()).getTime()));	
				factura.sethora_fin(new Time((new Date()).getTime()));	
				factura.setid_tipo_factura(-1L);	
				factura.setdescripcion("");	
				factura.setcupo(0.0);	
				factura.setsaldo(0.0);	
				factura.setdocumentos(0.0);	
				factura.setdisponible(0.0);	
				factura.setporcentaje_descuento(0.0);	
				factura.settotal_iva(0.0);	
				factura.setsuman(0.0);	
				factura.setdescuento_valor(0.0);	
				factura.settotal_sin_iva(0.0);	
				factura.settotal_descuento(0.0);	
				factura.settotal_flete(0.0);	
				factura.settotal(0.0);	
				factura.setsub_total(0.0);	
				factura.settotal_otro(0.0);	
				factura.setultimo_costo(0.0);	
				factura.setiva(0.0);	
				factura.setdescuento(0.0);	
				factura.setfinanciamiento(0.0);	
				factura.setmargen_utilidad(0.0);	
				factura.setice(0.0);	
				factura.setanticipo(0.0);	
				factura.setotros_valores(0.0);	
				factura.settotal_retencion(0.0);	
				factura.settotal_consumo_especial(0.0);	
				factura.setretencion(0.0);	
				factura.setid_tipo_cambio(null);	
				factura.setes_cliente(false);	
				factura.setid_asiento_contable(null);	
				factura.setid_pedido(null);	
				factura.setid_responsable(null);	
				factura.setid_estado_fisico_factura_empresa(null);	
				factura.setfecha(new Date());	
				factura.setfecha_autorizacion(new Date());	
				factura.setfecha_cliente(new Date());	
				factura.setnumero_documento("");	
				factura.setnumero_dau("");	
				factura.setnumero_referendo("");	
				factura.setfecha_referendo(new Date());	
				factura.setaforo_referendo("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderFactura(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaConstantesFunciones.LABEL_IDUSUARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaConstantesFunciones.LABEL_NUMEROPREIMPRESO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaConstantesFunciones.LABEL_NUMERODIAS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaConstantesFunciones.LABEL_FECHAVENCIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaConstantesFunciones.LABEL_IDMONEDA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaConstantesFunciones.LABEL_COTIZACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaConstantesFunciones.LABEL_IDFORMATO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaConstantesFunciones.LABEL_DIRECCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaConstantesFunciones.LABEL_RUC);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaConstantesFunciones.LABEL_IDTIPOPRECIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaConstantesFunciones.LABEL_TELEFONO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaConstantesFunciones.LABEL_IDSUBCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaConstantesFunciones.LABEL_IDVENDEDOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaConstantesFunciones.LABEL_IDTRANSPORTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaConstantesFunciones.LABEL_IDTRANSPORTISTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaConstantesFunciones.LABEL_ORDEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaConstantesFunciones.LABEL_IDTIPOLLAMADA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaConstantesFunciones.LABEL_HORAINICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaConstantesFunciones.LABEL_HORAFIN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaConstantesFunciones.LABEL_IDTIPOFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaConstantesFunciones.LABEL_CUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaConstantesFunciones.LABEL_SALDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaConstantesFunciones.LABEL_DOCUMENTOS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaConstantesFunciones.LABEL_DISPONIBLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaConstantesFunciones.LABEL_PORCENTAJEDESCUENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaConstantesFunciones.LABEL_TOTALIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaConstantesFunciones.LABEL_SUMAN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaConstantesFunciones.LABEL_DESCUENTOVALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaConstantesFunciones.LABEL_TOTALSINIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaConstantesFunciones.LABEL_TOTALDESCUENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaConstantesFunciones.LABEL_TOTALFLETE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaConstantesFunciones.LABEL_SUBTOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaConstantesFunciones.LABEL_TOTALOTRO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaConstantesFunciones.LABEL_ULTIMOCOSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaConstantesFunciones.LABEL_IVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaConstantesFunciones.LABEL_DESCUENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaConstantesFunciones.LABEL_FINANCIAMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaConstantesFunciones.LABEL_MARGENUTILIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaConstantesFunciones.LABEL_ICE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaConstantesFunciones.LABEL_ANTICIPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaConstantesFunciones.LABEL_OTROSVALORES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaConstantesFunciones.LABEL_TOTALRETENCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaConstantesFunciones.LABEL_TOTALCONSUMOESPECIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaConstantesFunciones.LABEL_RETENCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaConstantesFunciones.LABEL_IDTIPOCAMBIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaConstantesFunciones.LABEL_ESCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaConstantesFunciones.LABEL_IDASIENTOCONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaConstantesFunciones.LABEL_IDPEDIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaConstantesFunciones.LABEL_IDRESPONSABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaConstantesFunciones.LABEL_IDESTADOFISICOFACTURAEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaConstantesFunciones.LABEL_FECHAAUTORIZACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaConstantesFunciones.LABEL_FECHACLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaConstantesFunciones.LABEL_NUMERODOCUMENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaConstantesFunciones.LABEL_NUMERODAU);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaConstantesFunciones.LABEL_NUMEROREFERENDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaConstantesFunciones.LABEL_FECHAREFERENDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaConstantesFunciones.LABEL_AFOROREFERENDO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataFactura(String sTipo,Row row,Workbook workbook,Factura factura,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(factura.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(factura.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(factura.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(factura.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(factura.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(factura.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(factura.getusuario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(factura.getnumero_pre_impreso());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(factura.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(factura.getnumero_dias());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(factura.getfecha_vencimiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(factura.getmoneda_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(factura.getcotizacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(factura.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(factura.getformato_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(factura.getdireccion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(factura.getruc());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(factura.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(factura.gettipoprecio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(factura.gettelefono());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(factura.getsubcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(factura.getvendedor_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(factura.gettransporte_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(factura.gettransportista_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(factura.getorden());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(factura.gettipollamada_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(factura.gethora_inicio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(factura.gethora_fin());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(factura.gettipofactura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(factura.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(factura.getcupo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(factura.getsaldo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(factura.getdocumentos());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(factura.getdisponible());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(factura.getporcentaje_descuento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(factura.gettotal_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(factura.getsuman());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(factura.getdescuento_valor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(factura.gettotal_sin_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(factura.gettotal_descuento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(factura.gettotal_flete());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(factura.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(factura.getsub_total());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(factura.gettotal_otro());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(factura.getultimo_costo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(factura.getiva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(factura.getdescuento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(factura.getfinanciamiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(factura.getmargen_utilidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(factura.getice());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(factura.getanticipo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(factura.getotros_valores());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(factura.gettotal_retencion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(factura.gettotal_consumo_especial());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(factura.getretencion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(factura.gettipocambio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(factura.getes_cliente()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(factura.getasientocontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(factura.getpedido_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(factura.getresponsable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(factura.getestadofisicofacturaempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(factura.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(factura.getfecha_autorizacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(factura.getfecha_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(factura.getnumero_documento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(factura.getnumero_dau());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(factura.getnumero_referendo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(factura.getfecha_referendo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(factura.getaforo_referendo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryFactura=Constantes.SFINALQUERY;
	
	public String getsFinalQueryFactura() {
		return this.sFinalQueryFactura;
	}
	
	public void setsFinalQueryFactura(String sFinalQueryFactura) {
		this.sFinalQueryFactura= sFinalQueryFactura;
	}
	
	public Border resaltarSeleccionarFactura=null;
	
	public Border setResaltarSeleccionarFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltarSeleccionarFactura= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarFactura() {
		return this.resaltarSeleccionarFactura;
	}
	
	public void setResaltarSeleccionarFactura(Border borderResaltarSeleccionarFactura) {
		this.resaltarSeleccionarFactura= borderResaltarSeleccionarFactura;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridFactura=null;
	public Boolean mostraridFactura=true;
	public Boolean activaridFactura=true;

	public Border resaltarid_empresaFactura=null;
	public Boolean mostrarid_empresaFactura=true;
	public Boolean activarid_empresaFactura=true;
	public Boolean cargarid_empresaFactura=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaFactura=false;//ConEventDepend=true

	public Border resaltarid_sucursalFactura=null;
	public Boolean mostrarid_sucursalFactura=true;
	public Boolean activarid_sucursalFactura=true;
	public Boolean cargarid_sucursalFactura=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalFactura=false;//ConEventDepend=true

	public Border resaltarid_ejercicioFactura=null;
	public Boolean mostrarid_ejercicioFactura=true;
	public Boolean activarid_ejercicioFactura=true;
	public Boolean cargarid_ejercicioFactura=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioFactura=false;//ConEventDepend=true

	public Border resaltarid_periodoFactura=null;
	public Boolean mostrarid_periodoFactura=true;
	public Boolean activarid_periodoFactura=true;
	public Boolean cargarid_periodoFactura=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoFactura=false;//ConEventDepend=true

	public Border resaltarid_anioFactura=null;
	public Boolean mostrarid_anioFactura=true;
	public Boolean activarid_anioFactura=false;
	public Boolean cargarid_anioFactura=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioFactura=false;//ConEventDepend=true

	public Border resaltarid_mesFactura=null;
	public Boolean mostrarid_mesFactura=true;
	public Boolean activarid_mesFactura=false;
	public Boolean cargarid_mesFactura=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesFactura=false;//ConEventDepend=true

	public Border resaltarid_usuarioFactura=null;
	public Boolean mostrarid_usuarioFactura=true;
	public Boolean activarid_usuarioFactura=true;
	public Boolean cargarid_usuarioFactura=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_usuarioFactura=false;//ConEventDepend=true

	public Border resaltarnumero_pre_impresoFactura=null;
	public Boolean mostrarnumero_pre_impresoFactura=true;
	public Boolean activarnumero_pre_impresoFactura=true;

	public Border resaltarfecha_emisionFactura=null;
	public Boolean mostrarfecha_emisionFactura=true;
	public Boolean activarfecha_emisionFactura=true;

	public Border resaltarnumero_diasFactura=null;
	public Boolean mostrarnumero_diasFactura=true;
	public Boolean activarnumero_diasFactura=true;

	public Border resaltarfecha_vencimientoFactura=null;
	public Boolean mostrarfecha_vencimientoFactura=true;
	public Boolean activarfecha_vencimientoFactura=true;

	public Border resaltarid_monedaFactura=null;
	public Boolean mostrarid_monedaFactura=true;
	public Boolean activarid_monedaFactura=true;
	public Boolean cargarid_monedaFactura=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_monedaFactura=false;//ConEventDepend=true

	public Border resaltarcotizacionFactura=null;
	public Boolean mostrarcotizacionFactura=true;
	public Boolean activarcotizacionFactura=true;

	public Border resaltarid_empleadoFactura=null;
	public Boolean mostrarid_empleadoFactura=true;
	public Boolean activarid_empleadoFactura=true;
	public Boolean cargarid_empleadoFactura=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoFactura=false;//ConEventDepend=true

	public Border resaltarid_formatoFactura=null;
	public Boolean mostrarid_formatoFactura=true;
	public Boolean activarid_formatoFactura=true;
	public Boolean cargarid_formatoFactura=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formatoFactura=false;//ConEventDepend=true

	public Border resaltardireccionFactura=null;
	public Boolean mostrardireccionFactura=true;
	public Boolean activardireccionFactura=true;

	public Border resaltarrucFactura=null;
	public Boolean mostrarrucFactura=true;
	public Boolean activarrucFactura=true;

	public Border resaltarid_clienteFactura=null;
	public Boolean mostrarid_clienteFactura=true;
	public Boolean activarid_clienteFactura=true;
	public Boolean cargarid_clienteFactura=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteFactura=false;//ConEventDepend=true

	public Border resaltarid_tipo_precioFactura=null;
	public Boolean mostrarid_tipo_precioFactura=true;
	public Boolean activarid_tipo_precioFactura=true;
	public Boolean cargarid_tipo_precioFactura=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_precioFactura=false;//ConEventDepend=true

	public Border resaltartelefonoFactura=null;
	public Boolean mostrartelefonoFactura=true;
	public Boolean activartelefonoFactura=true;

	public Border resaltarid_sub_clienteFactura=null;
	public Boolean mostrarid_sub_clienteFactura=true;
	public Boolean activarid_sub_clienteFactura=true;
	public Boolean cargarid_sub_clienteFactura=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sub_clienteFactura=false;//ConEventDepend=true

	public Border resaltarid_vendedorFactura=null;
	public Boolean mostrarid_vendedorFactura=true;
	public Boolean activarid_vendedorFactura=true;
	public Boolean cargarid_vendedorFactura=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_vendedorFactura=false;//ConEventDepend=true

	public Border resaltarid_transporteFactura=null;
	public Boolean mostrarid_transporteFactura=true;
	public Boolean activarid_transporteFactura=true;
	public Boolean cargarid_transporteFactura=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transporteFactura=false;//ConEventDepend=true

	public Border resaltarid_transportistaFactura=null;
	public Boolean mostrarid_transportistaFactura=true;
	public Boolean activarid_transportistaFactura=true;
	public Boolean cargarid_transportistaFactura=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transportistaFactura=false;//ConEventDepend=true

	public Border resaltarordenFactura=null;
	public Boolean mostrarordenFactura=true;
	public Boolean activarordenFactura=true;

	public Border resaltarid_tipo_llamadaFactura=null;
	public Boolean mostrarid_tipo_llamadaFactura=true;
	public Boolean activarid_tipo_llamadaFactura=true;
	public Boolean cargarid_tipo_llamadaFactura=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_llamadaFactura=false;//ConEventDepend=true

	public Border resaltarhora_inicioFactura=null;
	public Boolean mostrarhora_inicioFactura=true;
	public Boolean activarhora_inicioFactura=true;

	public Border resaltarhora_finFactura=null;
	public Boolean mostrarhora_finFactura=true;
	public Boolean activarhora_finFactura=true;

	public Border resaltarid_tipo_facturaFactura=null;
	public Boolean mostrarid_tipo_facturaFactura=true;
	public Boolean activarid_tipo_facturaFactura=true;
	public Boolean cargarid_tipo_facturaFactura=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_facturaFactura=false;//ConEventDepend=true

	public Border resaltardescripcionFactura=null;
	public Boolean mostrardescripcionFactura=true;
	public Boolean activardescripcionFactura=true;

	public Border resaltarcupoFactura=null;
	public Boolean mostrarcupoFactura=true;
	public Boolean activarcupoFactura=true;

	public Border resaltarsaldoFactura=null;
	public Boolean mostrarsaldoFactura=true;
	public Boolean activarsaldoFactura=true;

	public Border resaltardocumentosFactura=null;
	public Boolean mostrardocumentosFactura=true;
	public Boolean activardocumentosFactura=true;

	public Border resaltardisponibleFactura=null;
	public Boolean mostrardisponibleFactura=true;
	public Boolean activardisponibleFactura=true;

	public Border resaltarporcentaje_descuentoFactura=null;
	public Boolean mostrarporcentaje_descuentoFactura=true;
	public Boolean activarporcentaje_descuentoFactura=true;

	public Border resaltartotal_ivaFactura=null;
	public Boolean mostrartotal_ivaFactura=true;
	public Boolean activartotal_ivaFactura=true;

	public Border resaltarsumanFactura=null;
	public Boolean mostrarsumanFactura=true;
	public Boolean activarsumanFactura=true;

	public Border resaltardescuento_valorFactura=null;
	public Boolean mostrardescuento_valorFactura=true;
	public Boolean activardescuento_valorFactura=true;

	public Border resaltartotal_sin_ivaFactura=null;
	public Boolean mostrartotal_sin_ivaFactura=true;
	public Boolean activartotal_sin_ivaFactura=true;

	public Border resaltartotal_descuentoFactura=null;
	public Boolean mostrartotal_descuentoFactura=true;
	public Boolean activartotal_descuentoFactura=true;

	public Border resaltartotal_fleteFactura=null;
	public Boolean mostrartotal_fleteFactura=true;
	public Boolean activartotal_fleteFactura=true;

	public Border resaltartotalFactura=null;
	public Boolean mostrartotalFactura=true;
	public Boolean activartotalFactura=true;

	public Border resaltarsub_totalFactura=null;
	public Boolean mostrarsub_totalFactura=true;
	public Boolean activarsub_totalFactura=true;

	public Border resaltartotal_otroFactura=null;
	public Boolean mostrartotal_otroFactura=true;
	public Boolean activartotal_otroFactura=true;

	public Border resaltarultimo_costoFactura=null;
	public Boolean mostrarultimo_costoFactura=true;
	public Boolean activarultimo_costoFactura=true;

	public Border resaltarivaFactura=null;
	public Boolean mostrarivaFactura=true;
	public Boolean activarivaFactura=true;

	public Border resaltardescuentoFactura=null;
	public Boolean mostrardescuentoFactura=true;
	public Boolean activardescuentoFactura=true;

	public Border resaltarfinanciamientoFactura=null;
	public Boolean mostrarfinanciamientoFactura=true;
	public Boolean activarfinanciamientoFactura=true;

	public Border resaltarmargen_utilidadFactura=null;
	public Boolean mostrarmargen_utilidadFactura=true;
	public Boolean activarmargen_utilidadFactura=true;

	public Border resaltariceFactura=null;
	public Boolean mostrariceFactura=true;
	public Boolean activariceFactura=true;

	public Border resaltaranticipoFactura=null;
	public Boolean mostraranticipoFactura=true;
	public Boolean activaranticipoFactura=true;

	public Border resaltarotros_valoresFactura=null;
	public Boolean mostrarotros_valoresFactura=true;
	public Boolean activarotros_valoresFactura=true;

	public Border resaltartotal_retencionFactura=null;
	public Boolean mostrartotal_retencionFactura=true;
	public Boolean activartotal_retencionFactura=false;

	public Border resaltartotal_consumo_especialFactura=null;
	public Boolean mostrartotal_consumo_especialFactura=true;
	public Boolean activartotal_consumo_especialFactura=false;

	public Border resaltarretencionFactura=null;
	public Boolean mostrarretencionFactura=true;
	public Boolean activarretencionFactura=false;

	public Border resaltarid_tipo_cambioFactura=null;
	public Boolean mostrarid_tipo_cambioFactura=true;
	public Boolean activarid_tipo_cambioFactura=false;
	public Boolean cargarid_tipo_cambioFactura=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_cambioFactura=false;//ConEventDepend=true

	public Border resaltares_clienteFactura=null;
	public Boolean mostrares_clienteFactura=true;
	public Boolean activares_clienteFactura=false;

	public Border resaltarid_asiento_contableFactura=null;
	public Boolean mostrarid_asiento_contableFactura=true;
	public Boolean activarid_asiento_contableFactura=false;
	public Boolean cargarid_asiento_contableFactura=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_asiento_contableFactura=false;//ConEventDepend=true

	public Border resaltarid_pedidoFactura=null;
	public Boolean mostrarid_pedidoFactura=true;
	public Boolean activarid_pedidoFactura=false;
	public Boolean cargarid_pedidoFactura=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_pedidoFactura=false;//ConEventDepend=true

	public Border resaltarid_responsableFactura=null;
	public Boolean mostrarid_responsableFactura=true;
	public Boolean activarid_responsableFactura=false;
	public Boolean cargarid_responsableFactura=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_responsableFactura=false;//ConEventDepend=true

	public Border resaltarid_estado_fisico_factura_empresaFactura=null;
	public Boolean mostrarid_estado_fisico_factura_empresaFactura=true;
	public Boolean activarid_estado_fisico_factura_empresaFactura=false;
	public Boolean cargarid_estado_fisico_factura_empresaFactura=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_fisico_factura_empresaFactura=false;//ConEventDepend=true

	public Border resaltarfechaFactura=null;
	public Boolean mostrarfechaFactura=true;
	public Boolean activarfechaFactura=false;

	public Border resaltarfecha_autorizacionFactura=null;
	public Boolean mostrarfecha_autorizacionFactura=true;
	public Boolean activarfecha_autorizacionFactura=false;

	public Border resaltarfecha_clienteFactura=null;
	public Boolean mostrarfecha_clienteFactura=true;
	public Boolean activarfecha_clienteFactura=false;

	public Border resaltarnumero_documentoFactura=null;
	public Boolean mostrarnumero_documentoFactura=true;
	public Boolean activarnumero_documentoFactura=false;

	public Border resaltarnumero_dauFactura=null;
	public Boolean mostrarnumero_dauFactura=true;
	public Boolean activarnumero_dauFactura=false;

	public Border resaltarnumero_referendoFactura=null;
	public Boolean mostrarnumero_referendoFactura=true;
	public Boolean activarnumero_referendoFactura=false;

	public Border resaltarfecha_referendoFactura=null;
	public Boolean mostrarfecha_referendoFactura=true;
	public Boolean activarfecha_referendoFactura=false;

	public Border resaltaraforo_referendoFactura=null;
	public Boolean mostraraforo_referendoFactura=true;
	public Boolean activaraforo_referendoFactura=false;

	
	

	public Border setResaltaridFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltaridFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridFactura() {
		return this.resaltaridFactura;
	}

	public void setResaltaridFactura(Border borderResaltar) {
		this.resaltaridFactura= borderResaltar;
	}

	public Boolean getMostraridFactura() {
		return this.mostraridFactura;
	}

	public void setMostraridFactura(Boolean mostraridFactura) {
		this.mostraridFactura= mostraridFactura;
	}

	public Boolean getActivaridFactura() {
		return this.activaridFactura;
	}

	public void setActivaridFactura(Boolean activaridFactura) {
		this.activaridFactura= activaridFactura;
	}

	public Border setResaltarid_empresaFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltarid_empresaFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaFactura() {
		return this.resaltarid_empresaFactura;
	}

	public void setResaltarid_empresaFactura(Border borderResaltar) {
		this.resaltarid_empresaFactura= borderResaltar;
	}

	public Boolean getMostrarid_empresaFactura() {
		return this.mostrarid_empresaFactura;
	}

	public void setMostrarid_empresaFactura(Boolean mostrarid_empresaFactura) {
		this.mostrarid_empresaFactura= mostrarid_empresaFactura;
	}

	public Boolean getActivarid_empresaFactura() {
		return this.activarid_empresaFactura;
	}

	public void setActivarid_empresaFactura(Boolean activarid_empresaFactura) {
		this.activarid_empresaFactura= activarid_empresaFactura;
	}

	public Boolean getCargarid_empresaFactura() {
		return this.cargarid_empresaFactura;
	}

	public void setCargarid_empresaFactura(Boolean cargarid_empresaFactura) {
		this.cargarid_empresaFactura= cargarid_empresaFactura;
	}

	public Border setResaltarid_sucursalFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltarid_sucursalFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalFactura() {
		return this.resaltarid_sucursalFactura;
	}

	public void setResaltarid_sucursalFactura(Border borderResaltar) {
		this.resaltarid_sucursalFactura= borderResaltar;
	}

	public Boolean getMostrarid_sucursalFactura() {
		return this.mostrarid_sucursalFactura;
	}

	public void setMostrarid_sucursalFactura(Boolean mostrarid_sucursalFactura) {
		this.mostrarid_sucursalFactura= mostrarid_sucursalFactura;
	}

	public Boolean getActivarid_sucursalFactura() {
		return this.activarid_sucursalFactura;
	}

	public void setActivarid_sucursalFactura(Boolean activarid_sucursalFactura) {
		this.activarid_sucursalFactura= activarid_sucursalFactura;
	}

	public Boolean getCargarid_sucursalFactura() {
		return this.cargarid_sucursalFactura;
	}

	public void setCargarid_sucursalFactura(Boolean cargarid_sucursalFactura) {
		this.cargarid_sucursalFactura= cargarid_sucursalFactura;
	}

	public Border setResaltarid_ejercicioFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioFactura() {
		return this.resaltarid_ejercicioFactura;
	}

	public void setResaltarid_ejercicioFactura(Border borderResaltar) {
		this.resaltarid_ejercicioFactura= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioFactura() {
		return this.mostrarid_ejercicioFactura;
	}

	public void setMostrarid_ejercicioFactura(Boolean mostrarid_ejercicioFactura) {
		this.mostrarid_ejercicioFactura= mostrarid_ejercicioFactura;
	}

	public Boolean getActivarid_ejercicioFactura() {
		return this.activarid_ejercicioFactura;
	}

	public void setActivarid_ejercicioFactura(Boolean activarid_ejercicioFactura) {
		this.activarid_ejercicioFactura= activarid_ejercicioFactura;
	}

	public Boolean getCargarid_ejercicioFactura() {
		return this.cargarid_ejercicioFactura;
	}

	public void setCargarid_ejercicioFactura(Boolean cargarid_ejercicioFactura) {
		this.cargarid_ejercicioFactura= cargarid_ejercicioFactura;
	}

	public Border setResaltarid_periodoFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltarid_periodoFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoFactura() {
		return this.resaltarid_periodoFactura;
	}

	public void setResaltarid_periodoFactura(Border borderResaltar) {
		this.resaltarid_periodoFactura= borderResaltar;
	}

	public Boolean getMostrarid_periodoFactura() {
		return this.mostrarid_periodoFactura;
	}

	public void setMostrarid_periodoFactura(Boolean mostrarid_periodoFactura) {
		this.mostrarid_periodoFactura= mostrarid_periodoFactura;
	}

	public Boolean getActivarid_periodoFactura() {
		return this.activarid_periodoFactura;
	}

	public void setActivarid_periodoFactura(Boolean activarid_periodoFactura) {
		this.activarid_periodoFactura= activarid_periodoFactura;
	}

	public Boolean getCargarid_periodoFactura() {
		return this.cargarid_periodoFactura;
	}

	public void setCargarid_periodoFactura(Boolean cargarid_periodoFactura) {
		this.cargarid_periodoFactura= cargarid_periodoFactura;
	}

	public Border setResaltarid_anioFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltarid_anioFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioFactura() {
		return this.resaltarid_anioFactura;
	}

	public void setResaltarid_anioFactura(Border borderResaltar) {
		this.resaltarid_anioFactura= borderResaltar;
	}

	public Boolean getMostrarid_anioFactura() {
		return this.mostrarid_anioFactura;
	}

	public void setMostrarid_anioFactura(Boolean mostrarid_anioFactura) {
		this.mostrarid_anioFactura= mostrarid_anioFactura;
	}

	public Boolean getActivarid_anioFactura() {
		return this.activarid_anioFactura;
	}

	public void setActivarid_anioFactura(Boolean activarid_anioFactura) {
		this.activarid_anioFactura= activarid_anioFactura;
	}

	public Boolean getCargarid_anioFactura() {
		return this.cargarid_anioFactura;
	}

	public void setCargarid_anioFactura(Boolean cargarid_anioFactura) {
		this.cargarid_anioFactura= cargarid_anioFactura;
	}

	public Border setResaltarid_mesFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltarid_mesFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesFactura() {
		return this.resaltarid_mesFactura;
	}

	public void setResaltarid_mesFactura(Border borderResaltar) {
		this.resaltarid_mesFactura= borderResaltar;
	}

	public Boolean getMostrarid_mesFactura() {
		return this.mostrarid_mesFactura;
	}

	public void setMostrarid_mesFactura(Boolean mostrarid_mesFactura) {
		this.mostrarid_mesFactura= mostrarid_mesFactura;
	}

	public Boolean getActivarid_mesFactura() {
		return this.activarid_mesFactura;
	}

	public void setActivarid_mesFactura(Boolean activarid_mesFactura) {
		this.activarid_mesFactura= activarid_mesFactura;
	}

	public Boolean getCargarid_mesFactura() {
		return this.cargarid_mesFactura;
	}

	public void setCargarid_mesFactura(Boolean cargarid_mesFactura) {
		this.cargarid_mesFactura= cargarid_mesFactura;
	}

	public Border setResaltarid_usuarioFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltarid_usuarioFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_usuarioFactura() {
		return this.resaltarid_usuarioFactura;
	}

	public void setResaltarid_usuarioFactura(Border borderResaltar) {
		this.resaltarid_usuarioFactura= borderResaltar;
	}

	public Boolean getMostrarid_usuarioFactura() {
		return this.mostrarid_usuarioFactura;
	}

	public void setMostrarid_usuarioFactura(Boolean mostrarid_usuarioFactura) {
		this.mostrarid_usuarioFactura= mostrarid_usuarioFactura;
	}

	public Boolean getActivarid_usuarioFactura() {
		return this.activarid_usuarioFactura;
	}

	public void setActivarid_usuarioFactura(Boolean activarid_usuarioFactura) {
		this.activarid_usuarioFactura= activarid_usuarioFactura;
	}

	public Boolean getCargarid_usuarioFactura() {
		return this.cargarid_usuarioFactura;
	}

	public void setCargarid_usuarioFactura(Boolean cargarid_usuarioFactura) {
		this.cargarid_usuarioFactura= cargarid_usuarioFactura;
	}

	public Border setResaltarnumero_pre_impresoFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltarnumero_pre_impresoFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_pre_impresoFactura() {
		return this.resaltarnumero_pre_impresoFactura;
	}

	public void setResaltarnumero_pre_impresoFactura(Border borderResaltar) {
		this.resaltarnumero_pre_impresoFactura= borderResaltar;
	}

	public Boolean getMostrarnumero_pre_impresoFactura() {
		return this.mostrarnumero_pre_impresoFactura;
	}

	public void setMostrarnumero_pre_impresoFactura(Boolean mostrarnumero_pre_impresoFactura) {
		this.mostrarnumero_pre_impresoFactura= mostrarnumero_pre_impresoFactura;
	}

	public Boolean getActivarnumero_pre_impresoFactura() {
		return this.activarnumero_pre_impresoFactura;
	}

	public void setActivarnumero_pre_impresoFactura(Boolean activarnumero_pre_impresoFactura) {
		this.activarnumero_pre_impresoFactura= activarnumero_pre_impresoFactura;
	}

	public Border setResaltarfecha_emisionFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionFactura() {
		return this.resaltarfecha_emisionFactura;
	}

	public void setResaltarfecha_emisionFactura(Border borderResaltar) {
		this.resaltarfecha_emisionFactura= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionFactura() {
		return this.mostrarfecha_emisionFactura;
	}

	public void setMostrarfecha_emisionFactura(Boolean mostrarfecha_emisionFactura) {
		this.mostrarfecha_emisionFactura= mostrarfecha_emisionFactura;
	}

	public Boolean getActivarfecha_emisionFactura() {
		return this.activarfecha_emisionFactura;
	}

	public void setActivarfecha_emisionFactura(Boolean activarfecha_emisionFactura) {
		this.activarfecha_emisionFactura= activarfecha_emisionFactura;
	}

	public Border setResaltarnumero_diasFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltarnumero_diasFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_diasFactura() {
		return this.resaltarnumero_diasFactura;
	}

	public void setResaltarnumero_diasFactura(Border borderResaltar) {
		this.resaltarnumero_diasFactura= borderResaltar;
	}

	public Boolean getMostrarnumero_diasFactura() {
		return this.mostrarnumero_diasFactura;
	}

	public void setMostrarnumero_diasFactura(Boolean mostrarnumero_diasFactura) {
		this.mostrarnumero_diasFactura= mostrarnumero_diasFactura;
	}

	public Boolean getActivarnumero_diasFactura() {
		return this.activarnumero_diasFactura;
	}

	public void setActivarnumero_diasFactura(Boolean activarnumero_diasFactura) {
		this.activarnumero_diasFactura= activarnumero_diasFactura;
	}

	public Border setResaltarfecha_vencimientoFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltarfecha_vencimientoFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_vencimientoFactura() {
		return this.resaltarfecha_vencimientoFactura;
	}

	public void setResaltarfecha_vencimientoFactura(Border borderResaltar) {
		this.resaltarfecha_vencimientoFactura= borderResaltar;
	}

	public Boolean getMostrarfecha_vencimientoFactura() {
		return this.mostrarfecha_vencimientoFactura;
	}

	public void setMostrarfecha_vencimientoFactura(Boolean mostrarfecha_vencimientoFactura) {
		this.mostrarfecha_vencimientoFactura= mostrarfecha_vencimientoFactura;
	}

	public Boolean getActivarfecha_vencimientoFactura() {
		return this.activarfecha_vencimientoFactura;
	}

	public void setActivarfecha_vencimientoFactura(Boolean activarfecha_vencimientoFactura) {
		this.activarfecha_vencimientoFactura= activarfecha_vencimientoFactura;
	}

	public Border setResaltarid_monedaFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltarid_monedaFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_monedaFactura() {
		return this.resaltarid_monedaFactura;
	}

	public void setResaltarid_monedaFactura(Border borderResaltar) {
		this.resaltarid_monedaFactura= borderResaltar;
	}

	public Boolean getMostrarid_monedaFactura() {
		return this.mostrarid_monedaFactura;
	}

	public void setMostrarid_monedaFactura(Boolean mostrarid_monedaFactura) {
		this.mostrarid_monedaFactura= mostrarid_monedaFactura;
	}

	public Boolean getActivarid_monedaFactura() {
		return this.activarid_monedaFactura;
	}

	public void setActivarid_monedaFactura(Boolean activarid_monedaFactura) {
		this.activarid_monedaFactura= activarid_monedaFactura;
	}

	public Boolean getCargarid_monedaFactura() {
		return this.cargarid_monedaFactura;
	}

	public void setCargarid_monedaFactura(Boolean cargarid_monedaFactura) {
		this.cargarid_monedaFactura= cargarid_monedaFactura;
	}

	public Border setResaltarcotizacionFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltarcotizacionFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcotizacionFactura() {
		return this.resaltarcotizacionFactura;
	}

	public void setResaltarcotizacionFactura(Border borderResaltar) {
		this.resaltarcotizacionFactura= borderResaltar;
	}

	public Boolean getMostrarcotizacionFactura() {
		return this.mostrarcotizacionFactura;
	}

	public void setMostrarcotizacionFactura(Boolean mostrarcotizacionFactura) {
		this.mostrarcotizacionFactura= mostrarcotizacionFactura;
	}

	public Boolean getActivarcotizacionFactura() {
		return this.activarcotizacionFactura;
	}

	public void setActivarcotizacionFactura(Boolean activarcotizacionFactura) {
		this.activarcotizacionFactura= activarcotizacionFactura;
	}

	public Border setResaltarid_empleadoFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltarid_empleadoFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoFactura() {
		return this.resaltarid_empleadoFactura;
	}

	public void setResaltarid_empleadoFactura(Border borderResaltar) {
		this.resaltarid_empleadoFactura= borderResaltar;
	}

	public Boolean getMostrarid_empleadoFactura() {
		return this.mostrarid_empleadoFactura;
	}

	public void setMostrarid_empleadoFactura(Boolean mostrarid_empleadoFactura) {
		this.mostrarid_empleadoFactura= mostrarid_empleadoFactura;
	}

	public Boolean getActivarid_empleadoFactura() {
		return this.activarid_empleadoFactura;
	}

	public void setActivarid_empleadoFactura(Boolean activarid_empleadoFactura) {
		this.activarid_empleadoFactura= activarid_empleadoFactura;
	}

	public Boolean getCargarid_empleadoFactura() {
		return this.cargarid_empleadoFactura;
	}

	public void setCargarid_empleadoFactura(Boolean cargarid_empleadoFactura) {
		this.cargarid_empleadoFactura= cargarid_empleadoFactura;
	}

	public Border setResaltarid_formatoFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltarid_formatoFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formatoFactura() {
		return this.resaltarid_formatoFactura;
	}

	public void setResaltarid_formatoFactura(Border borderResaltar) {
		this.resaltarid_formatoFactura= borderResaltar;
	}

	public Boolean getMostrarid_formatoFactura() {
		return this.mostrarid_formatoFactura;
	}

	public void setMostrarid_formatoFactura(Boolean mostrarid_formatoFactura) {
		this.mostrarid_formatoFactura= mostrarid_formatoFactura;
	}

	public Boolean getActivarid_formatoFactura() {
		return this.activarid_formatoFactura;
	}

	public void setActivarid_formatoFactura(Boolean activarid_formatoFactura) {
		this.activarid_formatoFactura= activarid_formatoFactura;
	}

	public Boolean getCargarid_formatoFactura() {
		return this.cargarid_formatoFactura;
	}

	public void setCargarid_formatoFactura(Boolean cargarid_formatoFactura) {
		this.cargarid_formatoFactura= cargarid_formatoFactura;
	}

	public Border setResaltardireccionFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltardireccionFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardireccionFactura() {
		return this.resaltardireccionFactura;
	}

	public void setResaltardireccionFactura(Border borderResaltar) {
		this.resaltardireccionFactura= borderResaltar;
	}

	public Boolean getMostrardireccionFactura() {
		return this.mostrardireccionFactura;
	}

	public void setMostrardireccionFactura(Boolean mostrardireccionFactura) {
		this.mostrardireccionFactura= mostrardireccionFactura;
	}

	public Boolean getActivardireccionFactura() {
		return this.activardireccionFactura;
	}

	public void setActivardireccionFactura(Boolean activardireccionFactura) {
		this.activardireccionFactura= activardireccionFactura;
	}

	public Border setResaltarrucFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltarrucFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarrucFactura() {
		return this.resaltarrucFactura;
	}

	public void setResaltarrucFactura(Border borderResaltar) {
		this.resaltarrucFactura= borderResaltar;
	}

	public Boolean getMostrarrucFactura() {
		return this.mostrarrucFactura;
	}

	public void setMostrarrucFactura(Boolean mostrarrucFactura) {
		this.mostrarrucFactura= mostrarrucFactura;
	}

	public Boolean getActivarrucFactura() {
		return this.activarrucFactura;
	}

	public void setActivarrucFactura(Boolean activarrucFactura) {
		this.activarrucFactura= activarrucFactura;
	}

	public Border setResaltarid_clienteFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltarid_clienteFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteFactura() {
		return this.resaltarid_clienteFactura;
	}

	public void setResaltarid_clienteFactura(Border borderResaltar) {
		this.resaltarid_clienteFactura= borderResaltar;
	}

	public Boolean getMostrarid_clienteFactura() {
		return this.mostrarid_clienteFactura;
	}

	public void setMostrarid_clienteFactura(Boolean mostrarid_clienteFactura) {
		this.mostrarid_clienteFactura= mostrarid_clienteFactura;
	}

	public Boolean getActivarid_clienteFactura() {
		return this.activarid_clienteFactura;
	}

	public void setActivarid_clienteFactura(Boolean activarid_clienteFactura) {
		this.activarid_clienteFactura= activarid_clienteFactura;
	}

	public Boolean getCargarid_clienteFactura() {
		return this.cargarid_clienteFactura;
	}

	public void setCargarid_clienteFactura(Boolean cargarid_clienteFactura) {
		this.cargarid_clienteFactura= cargarid_clienteFactura;
	}

	public Border setResaltarid_tipo_precioFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltarid_tipo_precioFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_precioFactura() {
		return this.resaltarid_tipo_precioFactura;
	}

	public void setResaltarid_tipo_precioFactura(Border borderResaltar) {
		this.resaltarid_tipo_precioFactura= borderResaltar;
	}

	public Boolean getMostrarid_tipo_precioFactura() {
		return this.mostrarid_tipo_precioFactura;
	}

	public void setMostrarid_tipo_precioFactura(Boolean mostrarid_tipo_precioFactura) {
		this.mostrarid_tipo_precioFactura= mostrarid_tipo_precioFactura;
	}

	public Boolean getActivarid_tipo_precioFactura() {
		return this.activarid_tipo_precioFactura;
	}

	public void setActivarid_tipo_precioFactura(Boolean activarid_tipo_precioFactura) {
		this.activarid_tipo_precioFactura= activarid_tipo_precioFactura;
	}

	public Boolean getCargarid_tipo_precioFactura() {
		return this.cargarid_tipo_precioFactura;
	}

	public void setCargarid_tipo_precioFactura(Boolean cargarid_tipo_precioFactura) {
		this.cargarid_tipo_precioFactura= cargarid_tipo_precioFactura;
	}

	public Border setResaltartelefonoFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltartelefonoFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartelefonoFactura() {
		return this.resaltartelefonoFactura;
	}

	public void setResaltartelefonoFactura(Border borderResaltar) {
		this.resaltartelefonoFactura= borderResaltar;
	}

	public Boolean getMostrartelefonoFactura() {
		return this.mostrartelefonoFactura;
	}

	public void setMostrartelefonoFactura(Boolean mostrartelefonoFactura) {
		this.mostrartelefonoFactura= mostrartelefonoFactura;
	}

	public Boolean getActivartelefonoFactura() {
		return this.activartelefonoFactura;
	}

	public void setActivartelefonoFactura(Boolean activartelefonoFactura) {
		this.activartelefonoFactura= activartelefonoFactura;
	}

	public Border setResaltarid_sub_clienteFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltarid_sub_clienteFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sub_clienteFactura() {
		return this.resaltarid_sub_clienteFactura;
	}

	public void setResaltarid_sub_clienteFactura(Border borderResaltar) {
		this.resaltarid_sub_clienteFactura= borderResaltar;
	}

	public Boolean getMostrarid_sub_clienteFactura() {
		return this.mostrarid_sub_clienteFactura;
	}

	public void setMostrarid_sub_clienteFactura(Boolean mostrarid_sub_clienteFactura) {
		this.mostrarid_sub_clienteFactura= mostrarid_sub_clienteFactura;
	}

	public Boolean getActivarid_sub_clienteFactura() {
		return this.activarid_sub_clienteFactura;
	}

	public void setActivarid_sub_clienteFactura(Boolean activarid_sub_clienteFactura) {
		this.activarid_sub_clienteFactura= activarid_sub_clienteFactura;
	}

	public Boolean getCargarid_sub_clienteFactura() {
		return this.cargarid_sub_clienteFactura;
	}

	public void setCargarid_sub_clienteFactura(Boolean cargarid_sub_clienteFactura) {
		this.cargarid_sub_clienteFactura= cargarid_sub_clienteFactura;
	}

	public Border setResaltarid_vendedorFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltarid_vendedorFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_vendedorFactura() {
		return this.resaltarid_vendedorFactura;
	}

	public void setResaltarid_vendedorFactura(Border borderResaltar) {
		this.resaltarid_vendedorFactura= borderResaltar;
	}

	public Boolean getMostrarid_vendedorFactura() {
		return this.mostrarid_vendedorFactura;
	}

	public void setMostrarid_vendedorFactura(Boolean mostrarid_vendedorFactura) {
		this.mostrarid_vendedorFactura= mostrarid_vendedorFactura;
	}

	public Boolean getActivarid_vendedorFactura() {
		return this.activarid_vendedorFactura;
	}

	public void setActivarid_vendedorFactura(Boolean activarid_vendedorFactura) {
		this.activarid_vendedorFactura= activarid_vendedorFactura;
	}

	public Boolean getCargarid_vendedorFactura() {
		return this.cargarid_vendedorFactura;
	}

	public void setCargarid_vendedorFactura(Boolean cargarid_vendedorFactura) {
		this.cargarid_vendedorFactura= cargarid_vendedorFactura;
	}

	public Border setResaltarid_transporteFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltarid_transporteFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transporteFactura() {
		return this.resaltarid_transporteFactura;
	}

	public void setResaltarid_transporteFactura(Border borderResaltar) {
		this.resaltarid_transporteFactura= borderResaltar;
	}

	public Boolean getMostrarid_transporteFactura() {
		return this.mostrarid_transporteFactura;
	}

	public void setMostrarid_transporteFactura(Boolean mostrarid_transporteFactura) {
		this.mostrarid_transporteFactura= mostrarid_transporteFactura;
	}

	public Boolean getActivarid_transporteFactura() {
		return this.activarid_transporteFactura;
	}

	public void setActivarid_transporteFactura(Boolean activarid_transporteFactura) {
		this.activarid_transporteFactura= activarid_transporteFactura;
	}

	public Boolean getCargarid_transporteFactura() {
		return this.cargarid_transporteFactura;
	}

	public void setCargarid_transporteFactura(Boolean cargarid_transporteFactura) {
		this.cargarid_transporteFactura= cargarid_transporteFactura;
	}

	public Border setResaltarid_transportistaFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltarid_transportistaFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transportistaFactura() {
		return this.resaltarid_transportistaFactura;
	}

	public void setResaltarid_transportistaFactura(Border borderResaltar) {
		this.resaltarid_transportistaFactura= borderResaltar;
	}

	public Boolean getMostrarid_transportistaFactura() {
		return this.mostrarid_transportistaFactura;
	}

	public void setMostrarid_transportistaFactura(Boolean mostrarid_transportistaFactura) {
		this.mostrarid_transportistaFactura= mostrarid_transportistaFactura;
	}

	public Boolean getActivarid_transportistaFactura() {
		return this.activarid_transportistaFactura;
	}

	public void setActivarid_transportistaFactura(Boolean activarid_transportistaFactura) {
		this.activarid_transportistaFactura= activarid_transportistaFactura;
	}

	public Boolean getCargarid_transportistaFactura() {
		return this.cargarid_transportistaFactura;
	}

	public void setCargarid_transportistaFactura(Boolean cargarid_transportistaFactura) {
		this.cargarid_transportistaFactura= cargarid_transportistaFactura;
	}

	public Border setResaltarordenFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltarordenFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarordenFactura() {
		return this.resaltarordenFactura;
	}

	public void setResaltarordenFactura(Border borderResaltar) {
		this.resaltarordenFactura= borderResaltar;
	}

	public Boolean getMostrarordenFactura() {
		return this.mostrarordenFactura;
	}

	public void setMostrarordenFactura(Boolean mostrarordenFactura) {
		this.mostrarordenFactura= mostrarordenFactura;
	}

	public Boolean getActivarordenFactura() {
		return this.activarordenFactura;
	}

	public void setActivarordenFactura(Boolean activarordenFactura) {
		this.activarordenFactura= activarordenFactura;
	}

	public Border setResaltarid_tipo_llamadaFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltarid_tipo_llamadaFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_llamadaFactura() {
		return this.resaltarid_tipo_llamadaFactura;
	}

	public void setResaltarid_tipo_llamadaFactura(Border borderResaltar) {
		this.resaltarid_tipo_llamadaFactura= borderResaltar;
	}

	public Boolean getMostrarid_tipo_llamadaFactura() {
		return this.mostrarid_tipo_llamadaFactura;
	}

	public void setMostrarid_tipo_llamadaFactura(Boolean mostrarid_tipo_llamadaFactura) {
		this.mostrarid_tipo_llamadaFactura= mostrarid_tipo_llamadaFactura;
	}

	public Boolean getActivarid_tipo_llamadaFactura() {
		return this.activarid_tipo_llamadaFactura;
	}

	public void setActivarid_tipo_llamadaFactura(Boolean activarid_tipo_llamadaFactura) {
		this.activarid_tipo_llamadaFactura= activarid_tipo_llamadaFactura;
	}

	public Boolean getCargarid_tipo_llamadaFactura() {
		return this.cargarid_tipo_llamadaFactura;
	}

	public void setCargarid_tipo_llamadaFactura(Boolean cargarid_tipo_llamadaFactura) {
		this.cargarid_tipo_llamadaFactura= cargarid_tipo_llamadaFactura;
	}

	public Border setResaltarhora_inicioFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltarhora_inicioFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhora_inicioFactura() {
		return this.resaltarhora_inicioFactura;
	}

	public void setResaltarhora_inicioFactura(Border borderResaltar) {
		this.resaltarhora_inicioFactura= borderResaltar;
	}

	public Boolean getMostrarhora_inicioFactura() {
		return this.mostrarhora_inicioFactura;
	}

	public void setMostrarhora_inicioFactura(Boolean mostrarhora_inicioFactura) {
		this.mostrarhora_inicioFactura= mostrarhora_inicioFactura;
	}

	public Boolean getActivarhora_inicioFactura() {
		return this.activarhora_inicioFactura;
	}

	public void setActivarhora_inicioFactura(Boolean activarhora_inicioFactura) {
		this.activarhora_inicioFactura= activarhora_inicioFactura;
	}

	public Border setResaltarhora_finFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltarhora_finFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhora_finFactura() {
		return this.resaltarhora_finFactura;
	}

	public void setResaltarhora_finFactura(Border borderResaltar) {
		this.resaltarhora_finFactura= borderResaltar;
	}

	public Boolean getMostrarhora_finFactura() {
		return this.mostrarhora_finFactura;
	}

	public void setMostrarhora_finFactura(Boolean mostrarhora_finFactura) {
		this.mostrarhora_finFactura= mostrarhora_finFactura;
	}

	public Boolean getActivarhora_finFactura() {
		return this.activarhora_finFactura;
	}

	public void setActivarhora_finFactura(Boolean activarhora_finFactura) {
		this.activarhora_finFactura= activarhora_finFactura;
	}

	public Border setResaltarid_tipo_facturaFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltarid_tipo_facturaFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_facturaFactura() {
		return this.resaltarid_tipo_facturaFactura;
	}

	public void setResaltarid_tipo_facturaFactura(Border borderResaltar) {
		this.resaltarid_tipo_facturaFactura= borderResaltar;
	}

	public Boolean getMostrarid_tipo_facturaFactura() {
		return this.mostrarid_tipo_facturaFactura;
	}

	public void setMostrarid_tipo_facturaFactura(Boolean mostrarid_tipo_facturaFactura) {
		this.mostrarid_tipo_facturaFactura= mostrarid_tipo_facturaFactura;
	}

	public Boolean getActivarid_tipo_facturaFactura() {
		return this.activarid_tipo_facturaFactura;
	}

	public void setActivarid_tipo_facturaFactura(Boolean activarid_tipo_facturaFactura) {
		this.activarid_tipo_facturaFactura= activarid_tipo_facturaFactura;
	}

	public Boolean getCargarid_tipo_facturaFactura() {
		return this.cargarid_tipo_facturaFactura;
	}

	public void setCargarid_tipo_facturaFactura(Boolean cargarid_tipo_facturaFactura) {
		this.cargarid_tipo_facturaFactura= cargarid_tipo_facturaFactura;
	}

	public Border setResaltardescripcionFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltardescripcionFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionFactura() {
		return this.resaltardescripcionFactura;
	}

	public void setResaltardescripcionFactura(Border borderResaltar) {
		this.resaltardescripcionFactura= borderResaltar;
	}

	public Boolean getMostrardescripcionFactura() {
		return this.mostrardescripcionFactura;
	}

	public void setMostrardescripcionFactura(Boolean mostrardescripcionFactura) {
		this.mostrardescripcionFactura= mostrardescripcionFactura;
	}

	public Boolean getActivardescripcionFactura() {
		return this.activardescripcionFactura;
	}

	public void setActivardescripcionFactura(Boolean activardescripcionFactura) {
		this.activardescripcionFactura= activardescripcionFactura;
	}

	public Border setResaltarcupoFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltarcupoFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcupoFactura() {
		return this.resaltarcupoFactura;
	}

	public void setResaltarcupoFactura(Border borderResaltar) {
		this.resaltarcupoFactura= borderResaltar;
	}

	public Boolean getMostrarcupoFactura() {
		return this.mostrarcupoFactura;
	}

	public void setMostrarcupoFactura(Boolean mostrarcupoFactura) {
		this.mostrarcupoFactura= mostrarcupoFactura;
	}

	public Boolean getActivarcupoFactura() {
		return this.activarcupoFactura;
	}

	public void setActivarcupoFactura(Boolean activarcupoFactura) {
		this.activarcupoFactura= activarcupoFactura;
	}

	public Border setResaltarsaldoFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltarsaldoFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsaldoFactura() {
		return this.resaltarsaldoFactura;
	}

	public void setResaltarsaldoFactura(Border borderResaltar) {
		this.resaltarsaldoFactura= borderResaltar;
	}

	public Boolean getMostrarsaldoFactura() {
		return this.mostrarsaldoFactura;
	}

	public void setMostrarsaldoFactura(Boolean mostrarsaldoFactura) {
		this.mostrarsaldoFactura= mostrarsaldoFactura;
	}

	public Boolean getActivarsaldoFactura() {
		return this.activarsaldoFactura;
	}

	public void setActivarsaldoFactura(Boolean activarsaldoFactura) {
		this.activarsaldoFactura= activarsaldoFactura;
	}

	public Border setResaltardocumentosFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltardocumentosFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardocumentosFactura() {
		return this.resaltardocumentosFactura;
	}

	public void setResaltardocumentosFactura(Border borderResaltar) {
		this.resaltardocumentosFactura= borderResaltar;
	}

	public Boolean getMostrardocumentosFactura() {
		return this.mostrardocumentosFactura;
	}

	public void setMostrardocumentosFactura(Boolean mostrardocumentosFactura) {
		this.mostrardocumentosFactura= mostrardocumentosFactura;
	}

	public Boolean getActivardocumentosFactura() {
		return this.activardocumentosFactura;
	}

	public void setActivardocumentosFactura(Boolean activardocumentosFactura) {
		this.activardocumentosFactura= activardocumentosFactura;
	}

	public Border setResaltardisponibleFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltardisponibleFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardisponibleFactura() {
		return this.resaltardisponibleFactura;
	}

	public void setResaltardisponibleFactura(Border borderResaltar) {
		this.resaltardisponibleFactura= borderResaltar;
	}

	public Boolean getMostrardisponibleFactura() {
		return this.mostrardisponibleFactura;
	}

	public void setMostrardisponibleFactura(Boolean mostrardisponibleFactura) {
		this.mostrardisponibleFactura= mostrardisponibleFactura;
	}

	public Boolean getActivardisponibleFactura() {
		return this.activardisponibleFactura;
	}

	public void setActivardisponibleFactura(Boolean activardisponibleFactura) {
		this.activardisponibleFactura= activardisponibleFactura;
	}

	public Border setResaltarporcentaje_descuentoFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltarporcentaje_descuentoFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentaje_descuentoFactura() {
		return this.resaltarporcentaje_descuentoFactura;
	}

	public void setResaltarporcentaje_descuentoFactura(Border borderResaltar) {
		this.resaltarporcentaje_descuentoFactura= borderResaltar;
	}

	public Boolean getMostrarporcentaje_descuentoFactura() {
		return this.mostrarporcentaje_descuentoFactura;
	}

	public void setMostrarporcentaje_descuentoFactura(Boolean mostrarporcentaje_descuentoFactura) {
		this.mostrarporcentaje_descuentoFactura= mostrarporcentaje_descuentoFactura;
	}

	public Boolean getActivarporcentaje_descuentoFactura() {
		return this.activarporcentaje_descuentoFactura;
	}

	public void setActivarporcentaje_descuentoFactura(Boolean activarporcentaje_descuentoFactura) {
		this.activarporcentaje_descuentoFactura= activarporcentaje_descuentoFactura;
	}

	public Border setResaltartotal_ivaFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltartotal_ivaFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_ivaFactura() {
		return this.resaltartotal_ivaFactura;
	}

	public void setResaltartotal_ivaFactura(Border borderResaltar) {
		this.resaltartotal_ivaFactura= borderResaltar;
	}

	public Boolean getMostrartotal_ivaFactura() {
		return this.mostrartotal_ivaFactura;
	}

	public void setMostrartotal_ivaFactura(Boolean mostrartotal_ivaFactura) {
		this.mostrartotal_ivaFactura= mostrartotal_ivaFactura;
	}

	public Boolean getActivartotal_ivaFactura() {
		return this.activartotal_ivaFactura;
	}

	public void setActivartotal_ivaFactura(Boolean activartotal_ivaFactura) {
		this.activartotal_ivaFactura= activartotal_ivaFactura;
	}

	public Border setResaltarsumanFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltarsumanFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsumanFactura() {
		return this.resaltarsumanFactura;
	}

	public void setResaltarsumanFactura(Border borderResaltar) {
		this.resaltarsumanFactura= borderResaltar;
	}

	public Boolean getMostrarsumanFactura() {
		return this.mostrarsumanFactura;
	}

	public void setMostrarsumanFactura(Boolean mostrarsumanFactura) {
		this.mostrarsumanFactura= mostrarsumanFactura;
	}

	public Boolean getActivarsumanFactura() {
		return this.activarsumanFactura;
	}

	public void setActivarsumanFactura(Boolean activarsumanFactura) {
		this.activarsumanFactura= activarsumanFactura;
	}

	public Border setResaltardescuento_valorFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltardescuento_valorFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuento_valorFactura() {
		return this.resaltardescuento_valorFactura;
	}

	public void setResaltardescuento_valorFactura(Border borderResaltar) {
		this.resaltardescuento_valorFactura= borderResaltar;
	}

	public Boolean getMostrardescuento_valorFactura() {
		return this.mostrardescuento_valorFactura;
	}

	public void setMostrardescuento_valorFactura(Boolean mostrardescuento_valorFactura) {
		this.mostrardescuento_valorFactura= mostrardescuento_valorFactura;
	}

	public Boolean getActivardescuento_valorFactura() {
		return this.activardescuento_valorFactura;
	}

	public void setActivardescuento_valorFactura(Boolean activardescuento_valorFactura) {
		this.activardescuento_valorFactura= activardescuento_valorFactura;
	}

	public Border setResaltartotal_sin_ivaFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltartotal_sin_ivaFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_sin_ivaFactura() {
		return this.resaltartotal_sin_ivaFactura;
	}

	public void setResaltartotal_sin_ivaFactura(Border borderResaltar) {
		this.resaltartotal_sin_ivaFactura= borderResaltar;
	}

	public Boolean getMostrartotal_sin_ivaFactura() {
		return this.mostrartotal_sin_ivaFactura;
	}

	public void setMostrartotal_sin_ivaFactura(Boolean mostrartotal_sin_ivaFactura) {
		this.mostrartotal_sin_ivaFactura= mostrartotal_sin_ivaFactura;
	}

	public Boolean getActivartotal_sin_ivaFactura() {
		return this.activartotal_sin_ivaFactura;
	}

	public void setActivartotal_sin_ivaFactura(Boolean activartotal_sin_ivaFactura) {
		this.activartotal_sin_ivaFactura= activartotal_sin_ivaFactura;
	}

	public Border setResaltartotal_descuentoFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltartotal_descuentoFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_descuentoFactura() {
		return this.resaltartotal_descuentoFactura;
	}

	public void setResaltartotal_descuentoFactura(Border borderResaltar) {
		this.resaltartotal_descuentoFactura= borderResaltar;
	}

	public Boolean getMostrartotal_descuentoFactura() {
		return this.mostrartotal_descuentoFactura;
	}

	public void setMostrartotal_descuentoFactura(Boolean mostrartotal_descuentoFactura) {
		this.mostrartotal_descuentoFactura= mostrartotal_descuentoFactura;
	}

	public Boolean getActivartotal_descuentoFactura() {
		return this.activartotal_descuentoFactura;
	}

	public void setActivartotal_descuentoFactura(Boolean activartotal_descuentoFactura) {
		this.activartotal_descuentoFactura= activartotal_descuentoFactura;
	}

	public Border setResaltartotal_fleteFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltartotal_fleteFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_fleteFactura() {
		return this.resaltartotal_fleteFactura;
	}

	public void setResaltartotal_fleteFactura(Border borderResaltar) {
		this.resaltartotal_fleteFactura= borderResaltar;
	}

	public Boolean getMostrartotal_fleteFactura() {
		return this.mostrartotal_fleteFactura;
	}

	public void setMostrartotal_fleteFactura(Boolean mostrartotal_fleteFactura) {
		this.mostrartotal_fleteFactura= mostrartotal_fleteFactura;
	}

	public Boolean getActivartotal_fleteFactura() {
		return this.activartotal_fleteFactura;
	}

	public void setActivartotal_fleteFactura(Boolean activartotal_fleteFactura) {
		this.activartotal_fleteFactura= activartotal_fleteFactura;
	}

	public Border setResaltartotalFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltartotalFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalFactura() {
		return this.resaltartotalFactura;
	}

	public void setResaltartotalFactura(Border borderResaltar) {
		this.resaltartotalFactura= borderResaltar;
	}

	public Boolean getMostrartotalFactura() {
		return this.mostrartotalFactura;
	}

	public void setMostrartotalFactura(Boolean mostrartotalFactura) {
		this.mostrartotalFactura= mostrartotalFactura;
	}

	public Boolean getActivartotalFactura() {
		return this.activartotalFactura;
	}

	public void setActivartotalFactura(Boolean activartotalFactura) {
		this.activartotalFactura= activartotalFactura;
	}

	public Border setResaltarsub_totalFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltarsub_totalFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsub_totalFactura() {
		return this.resaltarsub_totalFactura;
	}

	public void setResaltarsub_totalFactura(Border borderResaltar) {
		this.resaltarsub_totalFactura= borderResaltar;
	}

	public Boolean getMostrarsub_totalFactura() {
		return this.mostrarsub_totalFactura;
	}

	public void setMostrarsub_totalFactura(Boolean mostrarsub_totalFactura) {
		this.mostrarsub_totalFactura= mostrarsub_totalFactura;
	}

	public Boolean getActivarsub_totalFactura() {
		return this.activarsub_totalFactura;
	}

	public void setActivarsub_totalFactura(Boolean activarsub_totalFactura) {
		this.activarsub_totalFactura= activarsub_totalFactura;
	}

	public Border setResaltartotal_otroFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltartotal_otroFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_otroFactura() {
		return this.resaltartotal_otroFactura;
	}

	public void setResaltartotal_otroFactura(Border borderResaltar) {
		this.resaltartotal_otroFactura= borderResaltar;
	}

	public Boolean getMostrartotal_otroFactura() {
		return this.mostrartotal_otroFactura;
	}

	public void setMostrartotal_otroFactura(Boolean mostrartotal_otroFactura) {
		this.mostrartotal_otroFactura= mostrartotal_otroFactura;
	}

	public Boolean getActivartotal_otroFactura() {
		return this.activartotal_otroFactura;
	}

	public void setActivartotal_otroFactura(Boolean activartotal_otroFactura) {
		this.activartotal_otroFactura= activartotal_otroFactura;
	}

	public Border setResaltarultimo_costoFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltarultimo_costoFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarultimo_costoFactura() {
		return this.resaltarultimo_costoFactura;
	}

	public void setResaltarultimo_costoFactura(Border borderResaltar) {
		this.resaltarultimo_costoFactura= borderResaltar;
	}

	public Boolean getMostrarultimo_costoFactura() {
		return this.mostrarultimo_costoFactura;
	}

	public void setMostrarultimo_costoFactura(Boolean mostrarultimo_costoFactura) {
		this.mostrarultimo_costoFactura= mostrarultimo_costoFactura;
	}

	public Boolean getActivarultimo_costoFactura() {
		return this.activarultimo_costoFactura;
	}

	public void setActivarultimo_costoFactura(Boolean activarultimo_costoFactura) {
		this.activarultimo_costoFactura= activarultimo_costoFactura;
	}

	public Border setResaltarivaFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltarivaFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarivaFactura() {
		return this.resaltarivaFactura;
	}

	public void setResaltarivaFactura(Border borderResaltar) {
		this.resaltarivaFactura= borderResaltar;
	}

	public Boolean getMostrarivaFactura() {
		return this.mostrarivaFactura;
	}

	public void setMostrarivaFactura(Boolean mostrarivaFactura) {
		this.mostrarivaFactura= mostrarivaFactura;
	}

	public Boolean getActivarivaFactura() {
		return this.activarivaFactura;
	}

	public void setActivarivaFactura(Boolean activarivaFactura) {
		this.activarivaFactura= activarivaFactura;
	}

	public Border setResaltardescuentoFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltardescuentoFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuentoFactura() {
		return this.resaltardescuentoFactura;
	}

	public void setResaltardescuentoFactura(Border borderResaltar) {
		this.resaltardescuentoFactura= borderResaltar;
	}

	public Boolean getMostrardescuentoFactura() {
		return this.mostrardescuentoFactura;
	}

	public void setMostrardescuentoFactura(Boolean mostrardescuentoFactura) {
		this.mostrardescuentoFactura= mostrardescuentoFactura;
	}

	public Boolean getActivardescuentoFactura() {
		return this.activardescuentoFactura;
	}

	public void setActivardescuentoFactura(Boolean activardescuentoFactura) {
		this.activardescuentoFactura= activardescuentoFactura;
	}

	public Border setResaltarfinanciamientoFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltarfinanciamientoFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfinanciamientoFactura() {
		return this.resaltarfinanciamientoFactura;
	}

	public void setResaltarfinanciamientoFactura(Border borderResaltar) {
		this.resaltarfinanciamientoFactura= borderResaltar;
	}

	public Boolean getMostrarfinanciamientoFactura() {
		return this.mostrarfinanciamientoFactura;
	}

	public void setMostrarfinanciamientoFactura(Boolean mostrarfinanciamientoFactura) {
		this.mostrarfinanciamientoFactura= mostrarfinanciamientoFactura;
	}

	public Boolean getActivarfinanciamientoFactura() {
		return this.activarfinanciamientoFactura;
	}

	public void setActivarfinanciamientoFactura(Boolean activarfinanciamientoFactura) {
		this.activarfinanciamientoFactura= activarfinanciamientoFactura;
	}

	public Border setResaltarmargen_utilidadFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltarmargen_utilidadFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmargen_utilidadFactura() {
		return this.resaltarmargen_utilidadFactura;
	}

	public void setResaltarmargen_utilidadFactura(Border borderResaltar) {
		this.resaltarmargen_utilidadFactura= borderResaltar;
	}

	public Boolean getMostrarmargen_utilidadFactura() {
		return this.mostrarmargen_utilidadFactura;
	}

	public void setMostrarmargen_utilidadFactura(Boolean mostrarmargen_utilidadFactura) {
		this.mostrarmargen_utilidadFactura= mostrarmargen_utilidadFactura;
	}

	public Boolean getActivarmargen_utilidadFactura() {
		return this.activarmargen_utilidadFactura;
	}

	public void setActivarmargen_utilidadFactura(Boolean activarmargen_utilidadFactura) {
		this.activarmargen_utilidadFactura= activarmargen_utilidadFactura;
	}

	public Border setResaltariceFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltariceFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltariceFactura() {
		return this.resaltariceFactura;
	}

	public void setResaltariceFactura(Border borderResaltar) {
		this.resaltariceFactura= borderResaltar;
	}

	public Boolean getMostrariceFactura() {
		return this.mostrariceFactura;
	}

	public void setMostrariceFactura(Boolean mostrariceFactura) {
		this.mostrariceFactura= mostrariceFactura;
	}

	public Boolean getActivariceFactura() {
		return this.activariceFactura;
	}

	public void setActivariceFactura(Boolean activariceFactura) {
		this.activariceFactura= activariceFactura;
	}

	public Border setResaltaranticipoFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltaranticipoFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaranticipoFactura() {
		return this.resaltaranticipoFactura;
	}

	public void setResaltaranticipoFactura(Border borderResaltar) {
		this.resaltaranticipoFactura= borderResaltar;
	}

	public Boolean getMostraranticipoFactura() {
		return this.mostraranticipoFactura;
	}

	public void setMostraranticipoFactura(Boolean mostraranticipoFactura) {
		this.mostraranticipoFactura= mostraranticipoFactura;
	}

	public Boolean getActivaranticipoFactura() {
		return this.activaranticipoFactura;
	}

	public void setActivaranticipoFactura(Boolean activaranticipoFactura) {
		this.activaranticipoFactura= activaranticipoFactura;
	}

	public Border setResaltarotros_valoresFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltarotros_valoresFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarotros_valoresFactura() {
		return this.resaltarotros_valoresFactura;
	}

	public void setResaltarotros_valoresFactura(Border borderResaltar) {
		this.resaltarotros_valoresFactura= borderResaltar;
	}

	public Boolean getMostrarotros_valoresFactura() {
		return this.mostrarotros_valoresFactura;
	}

	public void setMostrarotros_valoresFactura(Boolean mostrarotros_valoresFactura) {
		this.mostrarotros_valoresFactura= mostrarotros_valoresFactura;
	}

	public Boolean getActivarotros_valoresFactura() {
		return this.activarotros_valoresFactura;
	}

	public void setActivarotros_valoresFactura(Boolean activarotros_valoresFactura) {
		this.activarotros_valoresFactura= activarotros_valoresFactura;
	}

	public Border setResaltartotal_retencionFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltartotal_retencionFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_retencionFactura() {
		return this.resaltartotal_retencionFactura;
	}

	public void setResaltartotal_retencionFactura(Border borderResaltar) {
		this.resaltartotal_retencionFactura= borderResaltar;
	}

	public Boolean getMostrartotal_retencionFactura() {
		return this.mostrartotal_retencionFactura;
	}

	public void setMostrartotal_retencionFactura(Boolean mostrartotal_retencionFactura) {
		this.mostrartotal_retencionFactura= mostrartotal_retencionFactura;
	}

	public Boolean getActivartotal_retencionFactura() {
		return this.activartotal_retencionFactura;
	}

	public void setActivartotal_retencionFactura(Boolean activartotal_retencionFactura) {
		this.activartotal_retencionFactura= activartotal_retencionFactura;
	}

	public Border setResaltartotal_consumo_especialFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltartotal_consumo_especialFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_consumo_especialFactura() {
		return this.resaltartotal_consumo_especialFactura;
	}

	public void setResaltartotal_consumo_especialFactura(Border borderResaltar) {
		this.resaltartotal_consumo_especialFactura= borderResaltar;
	}

	public Boolean getMostrartotal_consumo_especialFactura() {
		return this.mostrartotal_consumo_especialFactura;
	}

	public void setMostrartotal_consumo_especialFactura(Boolean mostrartotal_consumo_especialFactura) {
		this.mostrartotal_consumo_especialFactura= mostrartotal_consumo_especialFactura;
	}

	public Boolean getActivartotal_consumo_especialFactura() {
		return this.activartotal_consumo_especialFactura;
	}

	public void setActivartotal_consumo_especialFactura(Boolean activartotal_consumo_especialFactura) {
		this.activartotal_consumo_especialFactura= activartotal_consumo_especialFactura;
	}

	public Border setResaltarretencionFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltarretencionFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarretencionFactura() {
		return this.resaltarretencionFactura;
	}

	public void setResaltarretencionFactura(Border borderResaltar) {
		this.resaltarretencionFactura= borderResaltar;
	}

	public Boolean getMostrarretencionFactura() {
		return this.mostrarretencionFactura;
	}

	public void setMostrarretencionFactura(Boolean mostrarretencionFactura) {
		this.mostrarretencionFactura= mostrarretencionFactura;
	}

	public Boolean getActivarretencionFactura() {
		return this.activarretencionFactura;
	}

	public void setActivarretencionFactura(Boolean activarretencionFactura) {
		this.activarretencionFactura= activarretencionFactura;
	}

	public Border setResaltarid_tipo_cambioFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltarid_tipo_cambioFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_cambioFactura() {
		return this.resaltarid_tipo_cambioFactura;
	}

	public void setResaltarid_tipo_cambioFactura(Border borderResaltar) {
		this.resaltarid_tipo_cambioFactura= borderResaltar;
	}

	public Boolean getMostrarid_tipo_cambioFactura() {
		return this.mostrarid_tipo_cambioFactura;
	}

	public void setMostrarid_tipo_cambioFactura(Boolean mostrarid_tipo_cambioFactura) {
		this.mostrarid_tipo_cambioFactura= mostrarid_tipo_cambioFactura;
	}

	public Boolean getActivarid_tipo_cambioFactura() {
		return this.activarid_tipo_cambioFactura;
	}

	public void setActivarid_tipo_cambioFactura(Boolean activarid_tipo_cambioFactura) {
		this.activarid_tipo_cambioFactura= activarid_tipo_cambioFactura;
	}

	public Boolean getCargarid_tipo_cambioFactura() {
		return this.cargarid_tipo_cambioFactura;
	}

	public void setCargarid_tipo_cambioFactura(Boolean cargarid_tipo_cambioFactura) {
		this.cargarid_tipo_cambioFactura= cargarid_tipo_cambioFactura;
	}

	public Border setResaltares_clienteFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltares_clienteFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_clienteFactura() {
		return this.resaltares_clienteFactura;
	}

	public void setResaltares_clienteFactura(Border borderResaltar) {
		this.resaltares_clienteFactura= borderResaltar;
	}

	public Boolean getMostrares_clienteFactura() {
		return this.mostrares_clienteFactura;
	}

	public void setMostrares_clienteFactura(Boolean mostrares_clienteFactura) {
		this.mostrares_clienteFactura= mostrares_clienteFactura;
	}

	public Boolean getActivares_clienteFactura() {
		return this.activares_clienteFactura;
	}

	public void setActivares_clienteFactura(Boolean activares_clienteFactura) {
		this.activares_clienteFactura= activares_clienteFactura;
	}

	public Border setResaltarid_asiento_contableFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltarid_asiento_contableFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_asiento_contableFactura() {
		return this.resaltarid_asiento_contableFactura;
	}

	public void setResaltarid_asiento_contableFactura(Border borderResaltar) {
		this.resaltarid_asiento_contableFactura= borderResaltar;
	}

	public Boolean getMostrarid_asiento_contableFactura() {
		return this.mostrarid_asiento_contableFactura;
	}

	public void setMostrarid_asiento_contableFactura(Boolean mostrarid_asiento_contableFactura) {
		this.mostrarid_asiento_contableFactura= mostrarid_asiento_contableFactura;
	}

	public Boolean getActivarid_asiento_contableFactura() {
		return this.activarid_asiento_contableFactura;
	}

	public void setActivarid_asiento_contableFactura(Boolean activarid_asiento_contableFactura) {
		this.activarid_asiento_contableFactura= activarid_asiento_contableFactura;
	}

	public Boolean getCargarid_asiento_contableFactura() {
		return this.cargarid_asiento_contableFactura;
	}

	public void setCargarid_asiento_contableFactura(Boolean cargarid_asiento_contableFactura) {
		this.cargarid_asiento_contableFactura= cargarid_asiento_contableFactura;
	}

	public Border setResaltarid_pedidoFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltarid_pedidoFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_pedidoFactura() {
		return this.resaltarid_pedidoFactura;
	}

	public void setResaltarid_pedidoFactura(Border borderResaltar) {
		this.resaltarid_pedidoFactura= borderResaltar;
	}

	public Boolean getMostrarid_pedidoFactura() {
		return this.mostrarid_pedidoFactura;
	}

	public void setMostrarid_pedidoFactura(Boolean mostrarid_pedidoFactura) {
		this.mostrarid_pedidoFactura= mostrarid_pedidoFactura;
	}

	public Boolean getActivarid_pedidoFactura() {
		return this.activarid_pedidoFactura;
	}

	public void setActivarid_pedidoFactura(Boolean activarid_pedidoFactura) {
		this.activarid_pedidoFactura= activarid_pedidoFactura;
	}

	public Boolean getCargarid_pedidoFactura() {
		return this.cargarid_pedidoFactura;
	}

	public void setCargarid_pedidoFactura(Boolean cargarid_pedidoFactura) {
		this.cargarid_pedidoFactura= cargarid_pedidoFactura;
	}

	public Border setResaltarid_responsableFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltarid_responsableFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_responsableFactura() {
		return this.resaltarid_responsableFactura;
	}

	public void setResaltarid_responsableFactura(Border borderResaltar) {
		this.resaltarid_responsableFactura= borderResaltar;
	}

	public Boolean getMostrarid_responsableFactura() {
		return this.mostrarid_responsableFactura;
	}

	public void setMostrarid_responsableFactura(Boolean mostrarid_responsableFactura) {
		this.mostrarid_responsableFactura= mostrarid_responsableFactura;
	}

	public Boolean getActivarid_responsableFactura() {
		return this.activarid_responsableFactura;
	}

	public void setActivarid_responsableFactura(Boolean activarid_responsableFactura) {
		this.activarid_responsableFactura= activarid_responsableFactura;
	}

	public Boolean getCargarid_responsableFactura() {
		return this.cargarid_responsableFactura;
	}

	public void setCargarid_responsableFactura(Boolean cargarid_responsableFactura) {
		this.cargarid_responsableFactura= cargarid_responsableFactura;
	}

	public Border setResaltarid_estado_fisico_factura_empresaFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltarid_estado_fisico_factura_empresaFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_fisico_factura_empresaFactura() {
		return this.resaltarid_estado_fisico_factura_empresaFactura;
	}

	public void setResaltarid_estado_fisico_factura_empresaFactura(Border borderResaltar) {
		this.resaltarid_estado_fisico_factura_empresaFactura= borderResaltar;
	}

	public Boolean getMostrarid_estado_fisico_factura_empresaFactura() {
		return this.mostrarid_estado_fisico_factura_empresaFactura;
	}

	public void setMostrarid_estado_fisico_factura_empresaFactura(Boolean mostrarid_estado_fisico_factura_empresaFactura) {
		this.mostrarid_estado_fisico_factura_empresaFactura= mostrarid_estado_fisico_factura_empresaFactura;
	}

	public Boolean getActivarid_estado_fisico_factura_empresaFactura() {
		return this.activarid_estado_fisico_factura_empresaFactura;
	}

	public void setActivarid_estado_fisico_factura_empresaFactura(Boolean activarid_estado_fisico_factura_empresaFactura) {
		this.activarid_estado_fisico_factura_empresaFactura= activarid_estado_fisico_factura_empresaFactura;
	}

	public Boolean getCargarid_estado_fisico_factura_empresaFactura() {
		return this.cargarid_estado_fisico_factura_empresaFactura;
	}

	public void setCargarid_estado_fisico_factura_empresaFactura(Boolean cargarid_estado_fisico_factura_empresaFactura) {
		this.cargarid_estado_fisico_factura_empresaFactura= cargarid_estado_fisico_factura_empresaFactura;
	}

	public Border setResaltarfechaFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltarfechaFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaFactura() {
		return this.resaltarfechaFactura;
	}

	public void setResaltarfechaFactura(Border borderResaltar) {
		this.resaltarfechaFactura= borderResaltar;
	}

	public Boolean getMostrarfechaFactura() {
		return this.mostrarfechaFactura;
	}

	public void setMostrarfechaFactura(Boolean mostrarfechaFactura) {
		this.mostrarfechaFactura= mostrarfechaFactura;
	}

	public Boolean getActivarfechaFactura() {
		return this.activarfechaFactura;
	}

	public void setActivarfechaFactura(Boolean activarfechaFactura) {
		this.activarfechaFactura= activarfechaFactura;
	}

	public Border setResaltarfecha_autorizacionFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltarfecha_autorizacionFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_autorizacionFactura() {
		return this.resaltarfecha_autorizacionFactura;
	}

	public void setResaltarfecha_autorizacionFactura(Border borderResaltar) {
		this.resaltarfecha_autorizacionFactura= borderResaltar;
	}

	public Boolean getMostrarfecha_autorizacionFactura() {
		return this.mostrarfecha_autorizacionFactura;
	}

	public void setMostrarfecha_autorizacionFactura(Boolean mostrarfecha_autorizacionFactura) {
		this.mostrarfecha_autorizacionFactura= mostrarfecha_autorizacionFactura;
	}

	public Boolean getActivarfecha_autorizacionFactura() {
		return this.activarfecha_autorizacionFactura;
	}

	public void setActivarfecha_autorizacionFactura(Boolean activarfecha_autorizacionFactura) {
		this.activarfecha_autorizacionFactura= activarfecha_autorizacionFactura;
	}

	public Border setResaltarfecha_clienteFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltarfecha_clienteFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_clienteFactura() {
		return this.resaltarfecha_clienteFactura;
	}

	public void setResaltarfecha_clienteFactura(Border borderResaltar) {
		this.resaltarfecha_clienteFactura= borderResaltar;
	}

	public Boolean getMostrarfecha_clienteFactura() {
		return this.mostrarfecha_clienteFactura;
	}

	public void setMostrarfecha_clienteFactura(Boolean mostrarfecha_clienteFactura) {
		this.mostrarfecha_clienteFactura= mostrarfecha_clienteFactura;
	}

	public Boolean getActivarfecha_clienteFactura() {
		return this.activarfecha_clienteFactura;
	}

	public void setActivarfecha_clienteFactura(Boolean activarfecha_clienteFactura) {
		this.activarfecha_clienteFactura= activarfecha_clienteFactura;
	}

	public Border setResaltarnumero_documentoFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltarnumero_documentoFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_documentoFactura() {
		return this.resaltarnumero_documentoFactura;
	}

	public void setResaltarnumero_documentoFactura(Border borderResaltar) {
		this.resaltarnumero_documentoFactura= borderResaltar;
	}

	public Boolean getMostrarnumero_documentoFactura() {
		return this.mostrarnumero_documentoFactura;
	}

	public void setMostrarnumero_documentoFactura(Boolean mostrarnumero_documentoFactura) {
		this.mostrarnumero_documentoFactura= mostrarnumero_documentoFactura;
	}

	public Boolean getActivarnumero_documentoFactura() {
		return this.activarnumero_documentoFactura;
	}

	public void setActivarnumero_documentoFactura(Boolean activarnumero_documentoFactura) {
		this.activarnumero_documentoFactura= activarnumero_documentoFactura;
	}

	public Border setResaltarnumero_dauFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltarnumero_dauFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_dauFactura() {
		return this.resaltarnumero_dauFactura;
	}

	public void setResaltarnumero_dauFactura(Border borderResaltar) {
		this.resaltarnumero_dauFactura= borderResaltar;
	}

	public Boolean getMostrarnumero_dauFactura() {
		return this.mostrarnumero_dauFactura;
	}

	public void setMostrarnumero_dauFactura(Boolean mostrarnumero_dauFactura) {
		this.mostrarnumero_dauFactura= mostrarnumero_dauFactura;
	}

	public Boolean getActivarnumero_dauFactura() {
		return this.activarnumero_dauFactura;
	}

	public void setActivarnumero_dauFactura(Boolean activarnumero_dauFactura) {
		this.activarnumero_dauFactura= activarnumero_dauFactura;
	}

	public Border setResaltarnumero_referendoFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltarnumero_referendoFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_referendoFactura() {
		return this.resaltarnumero_referendoFactura;
	}

	public void setResaltarnumero_referendoFactura(Border borderResaltar) {
		this.resaltarnumero_referendoFactura= borderResaltar;
	}

	public Boolean getMostrarnumero_referendoFactura() {
		return this.mostrarnumero_referendoFactura;
	}

	public void setMostrarnumero_referendoFactura(Boolean mostrarnumero_referendoFactura) {
		this.mostrarnumero_referendoFactura= mostrarnumero_referendoFactura;
	}

	public Boolean getActivarnumero_referendoFactura() {
		return this.activarnumero_referendoFactura;
	}

	public void setActivarnumero_referendoFactura(Boolean activarnumero_referendoFactura) {
		this.activarnumero_referendoFactura= activarnumero_referendoFactura;
	}

	public Border setResaltarfecha_referendoFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltarfecha_referendoFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_referendoFactura() {
		return this.resaltarfecha_referendoFactura;
	}

	public void setResaltarfecha_referendoFactura(Border borderResaltar) {
		this.resaltarfecha_referendoFactura= borderResaltar;
	}

	public Boolean getMostrarfecha_referendoFactura() {
		return this.mostrarfecha_referendoFactura;
	}

	public void setMostrarfecha_referendoFactura(Boolean mostrarfecha_referendoFactura) {
		this.mostrarfecha_referendoFactura= mostrarfecha_referendoFactura;
	}

	public Boolean getActivarfecha_referendoFactura() {
		return this.activarfecha_referendoFactura;
	}

	public void setActivarfecha_referendoFactura(Boolean activarfecha_referendoFactura) {
		this.activarfecha_referendoFactura= activarfecha_referendoFactura;
	}

	public Border setResaltaraforo_referendoFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltar);
		
		this.resaltaraforo_referendoFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaraforo_referendoFactura() {
		return this.resaltaraforo_referendoFactura;
	}

	public void setResaltaraforo_referendoFactura(Border borderResaltar) {
		this.resaltaraforo_referendoFactura= borderResaltar;
	}

	public Boolean getMostraraforo_referendoFactura() {
		return this.mostraraforo_referendoFactura;
	}

	public void setMostraraforo_referendoFactura(Boolean mostraraforo_referendoFactura) {
		this.mostraraforo_referendoFactura= mostraraforo_referendoFactura;
	}

	public Boolean getActivaraforo_referendoFactura() {
		return this.activaraforo_referendoFactura;
	}

	public void setActivaraforo_referendoFactura(Boolean activaraforo_referendoFactura) {
		this.activaraforo_referendoFactura= activaraforo_referendoFactura;
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
		
		
		this.setMostraridFactura(esInicial);
		this.setMostrarid_empresaFactura(esInicial);
		this.setMostrarid_sucursalFactura(esInicial);
		this.setMostrarid_ejercicioFactura(esInicial);
		this.setMostrarid_periodoFactura(esInicial);
		this.setMostrarid_anioFactura(esInicial);
		this.setMostrarid_mesFactura(esInicial);
		this.setMostrarid_usuarioFactura(esInicial);
		this.setMostrarnumero_pre_impresoFactura(esInicial);
		this.setMostrarfecha_emisionFactura(esInicial);
		this.setMostrarnumero_diasFactura(esInicial);
		this.setMostrarfecha_vencimientoFactura(esInicial);
		this.setMostrarid_monedaFactura(esInicial);
		this.setMostrarcotizacionFactura(esInicial);
		this.setMostrarid_empleadoFactura(esInicial);
		this.setMostrarid_formatoFactura(esInicial);
		this.setMostrardireccionFactura(esInicial);
		this.setMostrarrucFactura(esInicial);
		this.setMostrarid_clienteFactura(esInicial);
		this.setMostrarid_tipo_precioFactura(esInicial);
		this.setMostrartelefonoFactura(esInicial);
		this.setMostrarid_sub_clienteFactura(esInicial);
		this.setMostrarid_vendedorFactura(esInicial);
		this.setMostrarid_transporteFactura(esInicial);
		this.setMostrarid_transportistaFactura(esInicial);
		this.setMostrarordenFactura(esInicial);
		this.setMostrarid_tipo_llamadaFactura(esInicial);
		this.setMostrarhora_inicioFactura(esInicial);
		this.setMostrarhora_finFactura(esInicial);
		this.setMostrarid_tipo_facturaFactura(esInicial);
		this.setMostrardescripcionFactura(esInicial);
		this.setMostrarcupoFactura(esInicial);
		this.setMostrarsaldoFactura(esInicial);
		this.setMostrardocumentosFactura(esInicial);
		this.setMostrardisponibleFactura(esInicial);
		this.setMostrarporcentaje_descuentoFactura(esInicial);
		this.setMostrartotal_ivaFactura(esInicial);
		this.setMostrarsumanFactura(esInicial);
		this.setMostrardescuento_valorFactura(esInicial);
		this.setMostrartotal_sin_ivaFactura(esInicial);
		this.setMostrartotal_descuentoFactura(esInicial);
		this.setMostrartotal_fleteFactura(esInicial);
		this.setMostrartotalFactura(esInicial);
		this.setMostrarsub_totalFactura(esInicial);
		this.setMostrartotal_otroFactura(esInicial);
		this.setMostrarultimo_costoFactura(esInicial);
		this.setMostrarivaFactura(esInicial);
		this.setMostrardescuentoFactura(esInicial);
		this.setMostrarfinanciamientoFactura(esInicial);
		this.setMostrarmargen_utilidadFactura(esInicial);
		this.setMostrariceFactura(esInicial);
		this.setMostraranticipoFactura(esInicial);
		this.setMostrarotros_valoresFactura(esInicial);
		this.setMostrartotal_retencionFactura(esInicial);
		this.setMostrartotal_consumo_especialFactura(esInicial);
		this.setMostrarretencionFactura(esInicial);
		this.setMostrarid_tipo_cambioFactura(esInicial);
		this.setMostrares_clienteFactura(esInicial);
		this.setMostrarid_asiento_contableFactura(esInicial);
		this.setMostrarid_pedidoFactura(esInicial);
		this.setMostrarid_responsableFactura(esInicial);
		this.setMostrarid_estado_fisico_factura_empresaFactura(esInicial);
		this.setMostrarfechaFactura(esInicial);
		this.setMostrarfecha_autorizacionFactura(esInicial);
		this.setMostrarfecha_clienteFactura(esInicial);
		this.setMostrarnumero_documentoFactura(esInicial);
		this.setMostrarnumero_dauFactura(esInicial);
		this.setMostrarnumero_referendoFactura(esInicial);
		this.setMostrarfecha_referendoFactura(esInicial);
		this.setMostraraforo_referendoFactura(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FacturaConstantesFunciones.ID)) {
				this.setMostraridFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IDMES)) {
				this.setMostrarid_mesFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IDUSUARIO)) {
				this.setMostrarid_usuarioFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.NUMEROPREIMPRESO)) {
				this.setMostrarnumero_pre_impresoFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.NUMERODIAS)) {
				this.setMostrarnumero_diasFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setMostrarfecha_vencimientoFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IDMONEDA)) {
				this.setMostrarid_monedaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.COTIZACION)) {
				this.setMostrarcotizacionFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IDFORMATO)) {
				this.setMostrarid_formatoFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.DIRECCION)) {
				this.setMostrardireccionFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.RUC)) {
				this.setMostrarrucFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IDTIPOPRECIO)) {
				this.setMostrarid_tipo_precioFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.TELEFONO)) {
				this.setMostrartelefonoFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IDSUBCLIENTE)) {
				this.setMostrarid_sub_clienteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IDVENDEDOR)) {
				this.setMostrarid_vendedorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IDTRANSPORTE)) {
				this.setMostrarid_transporteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IDTRANSPORTISTA)) {
				this.setMostrarid_transportistaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.ORDEN)) {
				this.setMostrarordenFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IDTIPOLLAMADA)) {
				this.setMostrarid_tipo_llamadaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.HORAINICIO)) {
				this.setMostrarhora_inicioFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.HORAFIN)) {
				this.setMostrarhora_finFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IDTIPOFACTURA)) {
				this.setMostrarid_tipo_facturaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.CUPO)) {
				this.setMostrarcupoFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.SALDO)) {
				this.setMostrarsaldoFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.DOCUMENTOS)) {
				this.setMostrardocumentosFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.DISPONIBLE)) {
				this.setMostrardisponibleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.PORCENTAJEDESCUENTO)) {
				this.setMostrarporcentaje_descuentoFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.TOTALIVA)) {
				this.setMostrartotal_ivaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.SUMAN)) {
				this.setMostrarsumanFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.DESCUENTOVALOR)) {
				this.setMostrardescuento_valorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.TOTALSINIVA)) {
				this.setMostrartotal_sin_ivaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.TOTALDESCUENTO)) {
				this.setMostrartotal_descuentoFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.TOTALFLETE)) {
				this.setMostrartotal_fleteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.TOTAL)) {
				this.setMostrartotalFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.SUBTOTAL)) {
				this.setMostrarsub_totalFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.TOTALOTRO)) {
				this.setMostrartotal_otroFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.ULTIMOCOSTO)) {
				this.setMostrarultimo_costoFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IVA)) {
				this.setMostrarivaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.DESCUENTO)) {
				this.setMostrardescuentoFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.FINANCIAMIENTO)) {
				this.setMostrarfinanciamientoFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.MARGENUTILIDAD)) {
				this.setMostrarmargen_utilidadFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.ICE)) {
				this.setMostrariceFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.ANTICIPO)) {
				this.setMostraranticipoFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.OTROSVALORES)) {
				this.setMostrarotros_valoresFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.TOTALRETENCION)) {
				this.setMostrartotal_retencionFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.TOTALCONSUMOESPECIAL)) {
				this.setMostrartotal_consumo_especialFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.RETENCION)) {
				this.setMostrarretencionFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IDTIPOCAMBIO)) {
				this.setMostrarid_tipo_cambioFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.ESCLIENTE)) {
				this.setMostrares_clienteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setMostrarid_asiento_contableFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IDPEDIDO)) {
				this.setMostrarid_pedidoFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IDRESPONSABLE)) {
				this.setMostrarid_responsableFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IDESTADOFISICOFACTURAEMPRESA)) {
				this.setMostrarid_estado_fisico_factura_empresaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.FECHA)) {
				this.setMostrarfechaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.FECHAAUTORIZACION)) {
				this.setMostrarfecha_autorizacionFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.FECHACLIENTE)) {
				this.setMostrarfecha_clienteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.NUMERODOCUMENTO)) {
				this.setMostrarnumero_documentoFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.NUMERODAU)) {
				this.setMostrarnumero_dauFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.NUMEROREFERENDO)) {
				this.setMostrarnumero_referendoFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.FECHAREFERENDO)) {
				this.setMostrarfecha_referendoFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.AFOROREFERENDO)) {
				this.setMostraraforo_referendoFactura(esAsigna);
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
		
		
		this.setActivaridFactura(esInicial);
		this.setActivarid_empresaFactura(esInicial);
		this.setActivarid_sucursalFactura(esInicial);
		this.setActivarid_ejercicioFactura(esInicial);
		this.setActivarid_periodoFactura(esInicial);
		this.setActivarid_anioFactura(esInicial);
		this.setActivarid_mesFactura(esInicial);
		this.setActivarid_usuarioFactura(esInicial);
		this.setActivarnumero_pre_impresoFactura(esInicial);
		this.setActivarfecha_emisionFactura(esInicial);
		this.setActivarnumero_diasFactura(esInicial);
		this.setActivarfecha_vencimientoFactura(esInicial);
		this.setActivarid_monedaFactura(esInicial);
		this.setActivarcotizacionFactura(esInicial);
		this.setActivarid_empleadoFactura(esInicial);
		this.setActivarid_formatoFactura(esInicial);
		this.setActivardireccionFactura(esInicial);
		this.setActivarrucFactura(esInicial);
		this.setActivarid_clienteFactura(esInicial);
		this.setActivarid_tipo_precioFactura(esInicial);
		this.setActivartelefonoFactura(esInicial);
		this.setActivarid_sub_clienteFactura(esInicial);
		this.setActivarid_vendedorFactura(esInicial);
		this.setActivarid_transporteFactura(esInicial);
		this.setActivarid_transportistaFactura(esInicial);
		this.setActivarordenFactura(esInicial);
		this.setActivarid_tipo_llamadaFactura(esInicial);
		this.setActivarhora_inicioFactura(esInicial);
		this.setActivarhora_finFactura(esInicial);
		this.setActivarid_tipo_facturaFactura(esInicial);
		this.setActivardescripcionFactura(esInicial);
		this.setActivarcupoFactura(esInicial);
		this.setActivarsaldoFactura(esInicial);
		this.setActivardocumentosFactura(esInicial);
		this.setActivardisponibleFactura(esInicial);
		this.setActivarporcentaje_descuentoFactura(esInicial);
		this.setActivartotal_ivaFactura(esInicial);
		this.setActivarsumanFactura(esInicial);
		this.setActivardescuento_valorFactura(esInicial);
		this.setActivartotal_sin_ivaFactura(esInicial);
		this.setActivartotal_descuentoFactura(esInicial);
		this.setActivartotal_fleteFactura(esInicial);
		this.setActivartotalFactura(esInicial);
		this.setActivarsub_totalFactura(esInicial);
		this.setActivartotal_otroFactura(esInicial);
		this.setActivarultimo_costoFactura(esInicial);
		this.setActivarivaFactura(esInicial);
		this.setActivardescuentoFactura(esInicial);
		this.setActivarfinanciamientoFactura(esInicial);
		this.setActivarmargen_utilidadFactura(esInicial);
		this.setActivariceFactura(esInicial);
		this.setActivaranticipoFactura(esInicial);
		this.setActivarotros_valoresFactura(esInicial);
		this.setActivartotal_retencionFactura(esInicial);
		this.setActivartotal_consumo_especialFactura(esInicial);
		this.setActivarretencionFactura(esInicial);
		this.setActivarid_tipo_cambioFactura(esInicial);
		this.setActivares_clienteFactura(esInicial);
		this.setActivarid_asiento_contableFactura(esInicial);
		this.setActivarid_pedidoFactura(esInicial);
		this.setActivarid_responsableFactura(esInicial);
		this.setActivarid_estado_fisico_factura_empresaFactura(esInicial);
		this.setActivarfechaFactura(esInicial);
		this.setActivarfecha_autorizacionFactura(esInicial);
		this.setActivarfecha_clienteFactura(esInicial);
		this.setActivarnumero_documentoFactura(esInicial);
		this.setActivarnumero_dauFactura(esInicial);
		this.setActivarnumero_referendoFactura(esInicial);
		this.setActivarfecha_referendoFactura(esInicial);
		this.setActivaraforo_referendoFactura(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FacturaConstantesFunciones.ID)) {
				this.setActivaridFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IDANIO)) {
				this.setActivarid_anioFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IDMES)) {
				this.setActivarid_mesFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IDUSUARIO)) {
				this.setActivarid_usuarioFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.NUMEROPREIMPRESO)) {
				this.setActivarnumero_pre_impresoFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.NUMERODIAS)) {
				this.setActivarnumero_diasFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setActivarfecha_vencimientoFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IDMONEDA)) {
				this.setActivarid_monedaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.COTIZACION)) {
				this.setActivarcotizacionFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IDFORMATO)) {
				this.setActivarid_formatoFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.DIRECCION)) {
				this.setActivardireccionFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.RUC)) {
				this.setActivarrucFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IDTIPOPRECIO)) {
				this.setActivarid_tipo_precioFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.TELEFONO)) {
				this.setActivartelefonoFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IDSUBCLIENTE)) {
				this.setActivarid_sub_clienteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IDVENDEDOR)) {
				this.setActivarid_vendedorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IDTRANSPORTE)) {
				this.setActivarid_transporteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IDTRANSPORTISTA)) {
				this.setActivarid_transportistaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.ORDEN)) {
				this.setActivarordenFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IDTIPOLLAMADA)) {
				this.setActivarid_tipo_llamadaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.HORAINICIO)) {
				this.setActivarhora_inicioFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.HORAFIN)) {
				this.setActivarhora_finFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IDTIPOFACTURA)) {
				this.setActivarid_tipo_facturaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.CUPO)) {
				this.setActivarcupoFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.SALDO)) {
				this.setActivarsaldoFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.DOCUMENTOS)) {
				this.setActivardocumentosFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.DISPONIBLE)) {
				this.setActivardisponibleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.PORCENTAJEDESCUENTO)) {
				this.setActivarporcentaje_descuentoFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.TOTALIVA)) {
				this.setActivartotal_ivaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.SUMAN)) {
				this.setActivarsumanFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.DESCUENTOVALOR)) {
				this.setActivardescuento_valorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.TOTALSINIVA)) {
				this.setActivartotal_sin_ivaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.TOTALDESCUENTO)) {
				this.setActivartotal_descuentoFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.TOTALFLETE)) {
				this.setActivartotal_fleteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.TOTAL)) {
				this.setActivartotalFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.SUBTOTAL)) {
				this.setActivarsub_totalFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.TOTALOTRO)) {
				this.setActivartotal_otroFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.ULTIMOCOSTO)) {
				this.setActivarultimo_costoFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IVA)) {
				this.setActivarivaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.DESCUENTO)) {
				this.setActivardescuentoFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.FINANCIAMIENTO)) {
				this.setActivarfinanciamientoFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.MARGENUTILIDAD)) {
				this.setActivarmargen_utilidadFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.ICE)) {
				this.setActivariceFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.ANTICIPO)) {
				this.setActivaranticipoFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.OTROSVALORES)) {
				this.setActivarotros_valoresFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.TOTALRETENCION)) {
				this.setActivartotal_retencionFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.TOTALCONSUMOESPECIAL)) {
				this.setActivartotal_consumo_especialFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.RETENCION)) {
				this.setActivarretencionFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IDTIPOCAMBIO)) {
				this.setActivarid_tipo_cambioFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.ESCLIENTE)) {
				this.setActivares_clienteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setActivarid_asiento_contableFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IDPEDIDO)) {
				this.setActivarid_pedidoFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IDRESPONSABLE)) {
				this.setActivarid_responsableFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IDESTADOFISICOFACTURAEMPRESA)) {
				this.setActivarid_estado_fisico_factura_empresaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.FECHA)) {
				this.setActivarfechaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.FECHAAUTORIZACION)) {
				this.setActivarfecha_autorizacionFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.FECHACLIENTE)) {
				this.setActivarfecha_clienteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.NUMERODOCUMENTO)) {
				this.setActivarnumero_documentoFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.NUMERODAU)) {
				this.setActivarnumero_dauFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.NUMEROREFERENDO)) {
				this.setActivarnumero_referendoFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.FECHAREFERENDO)) {
				this.setActivarfecha_referendoFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.AFOROREFERENDO)) {
				this.setActivaraforo_referendoFactura(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridFactura(esInicial);
		this.setResaltarid_empresaFactura(esInicial);
		this.setResaltarid_sucursalFactura(esInicial);
		this.setResaltarid_ejercicioFactura(esInicial);
		this.setResaltarid_periodoFactura(esInicial);
		this.setResaltarid_anioFactura(esInicial);
		this.setResaltarid_mesFactura(esInicial);
		this.setResaltarid_usuarioFactura(esInicial);
		this.setResaltarnumero_pre_impresoFactura(esInicial);
		this.setResaltarfecha_emisionFactura(esInicial);
		this.setResaltarnumero_diasFactura(esInicial);
		this.setResaltarfecha_vencimientoFactura(esInicial);
		this.setResaltarid_monedaFactura(esInicial);
		this.setResaltarcotizacionFactura(esInicial);
		this.setResaltarid_empleadoFactura(esInicial);
		this.setResaltarid_formatoFactura(esInicial);
		this.setResaltardireccionFactura(esInicial);
		this.setResaltarrucFactura(esInicial);
		this.setResaltarid_clienteFactura(esInicial);
		this.setResaltarid_tipo_precioFactura(esInicial);
		this.setResaltartelefonoFactura(esInicial);
		this.setResaltarid_sub_clienteFactura(esInicial);
		this.setResaltarid_vendedorFactura(esInicial);
		this.setResaltarid_transporteFactura(esInicial);
		this.setResaltarid_transportistaFactura(esInicial);
		this.setResaltarordenFactura(esInicial);
		this.setResaltarid_tipo_llamadaFactura(esInicial);
		this.setResaltarhora_inicioFactura(esInicial);
		this.setResaltarhora_finFactura(esInicial);
		this.setResaltarid_tipo_facturaFactura(esInicial);
		this.setResaltardescripcionFactura(esInicial);
		this.setResaltarcupoFactura(esInicial);
		this.setResaltarsaldoFactura(esInicial);
		this.setResaltardocumentosFactura(esInicial);
		this.setResaltardisponibleFactura(esInicial);
		this.setResaltarporcentaje_descuentoFactura(esInicial);
		this.setResaltartotal_ivaFactura(esInicial);
		this.setResaltarsumanFactura(esInicial);
		this.setResaltardescuento_valorFactura(esInicial);
		this.setResaltartotal_sin_ivaFactura(esInicial);
		this.setResaltartotal_descuentoFactura(esInicial);
		this.setResaltartotal_fleteFactura(esInicial);
		this.setResaltartotalFactura(esInicial);
		this.setResaltarsub_totalFactura(esInicial);
		this.setResaltartotal_otroFactura(esInicial);
		this.setResaltarultimo_costoFactura(esInicial);
		this.setResaltarivaFactura(esInicial);
		this.setResaltardescuentoFactura(esInicial);
		this.setResaltarfinanciamientoFactura(esInicial);
		this.setResaltarmargen_utilidadFactura(esInicial);
		this.setResaltariceFactura(esInicial);
		this.setResaltaranticipoFactura(esInicial);
		this.setResaltarotros_valoresFactura(esInicial);
		this.setResaltartotal_retencionFactura(esInicial);
		this.setResaltartotal_consumo_especialFactura(esInicial);
		this.setResaltarretencionFactura(esInicial);
		this.setResaltarid_tipo_cambioFactura(esInicial);
		this.setResaltares_clienteFactura(esInicial);
		this.setResaltarid_asiento_contableFactura(esInicial);
		this.setResaltarid_pedidoFactura(esInicial);
		this.setResaltarid_responsableFactura(esInicial);
		this.setResaltarid_estado_fisico_factura_empresaFactura(esInicial);
		this.setResaltarfechaFactura(esInicial);
		this.setResaltarfecha_autorizacionFactura(esInicial);
		this.setResaltarfecha_clienteFactura(esInicial);
		this.setResaltarnumero_documentoFactura(esInicial);
		this.setResaltarnumero_dauFactura(esInicial);
		this.setResaltarnumero_referendoFactura(esInicial);
		this.setResaltarfecha_referendoFactura(esInicial);
		this.setResaltaraforo_referendoFactura(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FacturaConstantesFunciones.ID)) {
				this.setResaltaridFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IDMES)) {
				this.setResaltarid_mesFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IDUSUARIO)) {
				this.setResaltarid_usuarioFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.NUMEROPREIMPRESO)) {
				this.setResaltarnumero_pre_impresoFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.NUMERODIAS)) {
				this.setResaltarnumero_diasFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setResaltarfecha_vencimientoFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IDMONEDA)) {
				this.setResaltarid_monedaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.COTIZACION)) {
				this.setResaltarcotizacionFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IDFORMATO)) {
				this.setResaltarid_formatoFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.DIRECCION)) {
				this.setResaltardireccionFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.RUC)) {
				this.setResaltarrucFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IDTIPOPRECIO)) {
				this.setResaltarid_tipo_precioFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.TELEFONO)) {
				this.setResaltartelefonoFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IDSUBCLIENTE)) {
				this.setResaltarid_sub_clienteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IDVENDEDOR)) {
				this.setResaltarid_vendedorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IDTRANSPORTE)) {
				this.setResaltarid_transporteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IDTRANSPORTISTA)) {
				this.setResaltarid_transportistaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.ORDEN)) {
				this.setResaltarordenFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IDTIPOLLAMADA)) {
				this.setResaltarid_tipo_llamadaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.HORAINICIO)) {
				this.setResaltarhora_inicioFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.HORAFIN)) {
				this.setResaltarhora_finFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IDTIPOFACTURA)) {
				this.setResaltarid_tipo_facturaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.CUPO)) {
				this.setResaltarcupoFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.SALDO)) {
				this.setResaltarsaldoFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.DOCUMENTOS)) {
				this.setResaltardocumentosFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.DISPONIBLE)) {
				this.setResaltardisponibleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.PORCENTAJEDESCUENTO)) {
				this.setResaltarporcentaje_descuentoFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.TOTALIVA)) {
				this.setResaltartotal_ivaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.SUMAN)) {
				this.setResaltarsumanFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.DESCUENTOVALOR)) {
				this.setResaltardescuento_valorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.TOTALSINIVA)) {
				this.setResaltartotal_sin_ivaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.TOTALDESCUENTO)) {
				this.setResaltartotal_descuentoFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.TOTALFLETE)) {
				this.setResaltartotal_fleteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.TOTAL)) {
				this.setResaltartotalFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.SUBTOTAL)) {
				this.setResaltarsub_totalFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.TOTALOTRO)) {
				this.setResaltartotal_otroFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.ULTIMOCOSTO)) {
				this.setResaltarultimo_costoFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IVA)) {
				this.setResaltarivaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.DESCUENTO)) {
				this.setResaltardescuentoFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.FINANCIAMIENTO)) {
				this.setResaltarfinanciamientoFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.MARGENUTILIDAD)) {
				this.setResaltarmargen_utilidadFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.ICE)) {
				this.setResaltariceFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.ANTICIPO)) {
				this.setResaltaranticipoFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.OTROSVALORES)) {
				this.setResaltarotros_valoresFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.TOTALRETENCION)) {
				this.setResaltartotal_retencionFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.TOTALCONSUMOESPECIAL)) {
				this.setResaltartotal_consumo_especialFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.RETENCION)) {
				this.setResaltarretencionFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IDTIPOCAMBIO)) {
				this.setResaltarid_tipo_cambioFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.ESCLIENTE)) {
				this.setResaltares_clienteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setResaltarid_asiento_contableFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IDPEDIDO)) {
				this.setResaltarid_pedidoFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IDRESPONSABLE)) {
				this.setResaltarid_responsableFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.IDESTADOFISICOFACTURAEMPRESA)) {
				this.setResaltarid_estado_fisico_factura_empresaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.FECHA)) {
				this.setResaltarfechaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.FECHAAUTORIZACION)) {
				this.setResaltarfecha_autorizacionFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.FECHACLIENTE)) {
				this.setResaltarfecha_clienteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.NUMERODOCUMENTO)) {
				this.setResaltarnumero_documentoFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.NUMERODAU)) {
				this.setResaltarnumero_dauFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.NUMEROREFERENDO)) {
				this.setResaltarnumero_referendoFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.FECHAREFERENDO)) {
				this.setResaltarfecha_referendoFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaConstantesFunciones.AFOROREFERENDO)) {
				this.setResaltaraforo_referendoFactura(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDetaFormaPagoFactura=null;

	public Border getResaltarDetaFormaPagoFactura() {
		return this.resaltarDetaFormaPagoFactura;
	}

	public void setResaltarDetaFormaPagoFactura(Border borderResaltarDetaFormaPago) {
		if(borderResaltarDetaFormaPago!=null) {
			this.resaltarDetaFormaPagoFactura= borderResaltarDetaFormaPago;
		}
	}

	public Border setResaltarDetaFormaPagoFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltarDetaFormaPago=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltarDetaFormaPago);
			
		this.resaltarDetaFormaPagoFactura= borderResaltarDetaFormaPago;

		 return borderResaltarDetaFormaPago;
	}



	public Boolean mostrarDetaFormaPagoFactura=true;

	public Boolean getMostrarDetaFormaPagoFactura() {
		return this.mostrarDetaFormaPagoFactura;
	}

	public void setMostrarDetaFormaPagoFactura(Boolean visibilidadResaltarDetaFormaPago) {
		this.mostrarDetaFormaPagoFactura= visibilidadResaltarDetaFormaPago;
	}



	public Boolean activarDetaFormaPagoFactura=true;

	public Boolean gethabilitarResaltarDetaFormaPagoFactura() {
		return this.activarDetaFormaPagoFactura;
	}

	public void setActivarDetaFormaPagoFactura(Boolean habilitarResaltarDetaFormaPago) {
		this.activarDetaFormaPagoFactura= habilitarResaltarDetaFormaPago;
	}


	public Border resaltarDetalleFacturaFactura=null;

	public Border getResaltarDetalleFacturaFactura() {
		return this.resaltarDetalleFacturaFactura;
	}

	public void setResaltarDetalleFacturaFactura(Border borderResaltarDetalleFactura) {
		if(borderResaltarDetalleFactura!=null) {
			this.resaltarDetalleFacturaFactura= borderResaltarDetalleFactura;
		}
	}

	public Border setResaltarDetalleFacturaFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltarDetalleFactura=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//facturaBeanSwingJInternalFrame.jTtoolBarFactura.setBorder(borderResaltarDetalleFactura);
			
		this.resaltarDetalleFacturaFactura= borderResaltarDetalleFactura;

		 return borderResaltarDetalleFactura;
	}



	public Boolean mostrarDetalleFacturaFactura=true;

	public Boolean getMostrarDetalleFacturaFactura() {
		return this.mostrarDetalleFacturaFactura;
	}

	public void setMostrarDetalleFacturaFactura(Boolean visibilidadResaltarDetalleFactura) {
		this.mostrarDetalleFacturaFactura= visibilidadResaltarDetalleFactura;
	}



	public Boolean activarDetalleFacturaFactura=true;

	public Boolean gethabilitarResaltarDetalleFacturaFactura() {
		return this.activarDetalleFacturaFactura;
	}

	public void setActivarDetalleFacturaFactura(Boolean habilitarResaltarDetalleFactura) {
		this.activarDetalleFacturaFactura= habilitarResaltarDetalleFactura;
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

		this.setMostrarDetaFormaPagoFactura(esInicial);
		this.setMostrarDetalleFacturaFactura(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetaFormaPago.class)) {
				this.setMostrarDetaFormaPagoFactura(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetalleFactura.class)) {
				this.setMostrarDetalleFacturaFactura(esAsigna);
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

		this.setActivarDetaFormaPagoFactura(esInicial);
		this.setActivarDetalleFacturaFactura(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetaFormaPago.class)) {
				this.setActivarDetaFormaPagoFactura(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetalleFactura.class)) {
				this.setActivarDetalleFacturaFactura(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDetaFormaPagoFactura(esInicial);
		this.setResaltarDetalleFacturaFactura(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetaFormaPago.class)) {
				this.setResaltarDetaFormaPagoFactura(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetalleFactura.class)) {
				this.setResaltarDetalleFacturaFactura(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorNumeroPreImpresoFactura=true;

	public Boolean getMostrarBusquedaPorNumeroPreImpresoFactura() {
		return this.mostrarBusquedaPorNumeroPreImpresoFactura;
	}

	public void setMostrarBusquedaPorNumeroPreImpresoFactura(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNumeroPreImpresoFactura= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdClienteFactura=true;

	public Boolean getMostrarFK_IdClienteFactura() {
		return this.mostrarFK_IdClienteFactura;
	}

	public void setMostrarFK_IdClienteFactura(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteFactura= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioFactura=true;

	public Boolean getMostrarFK_IdEjercicioFactura() {
		return this.mostrarFK_IdEjercicioFactura;
	}

	public void setMostrarFK_IdEjercicioFactura(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioFactura= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaFactura=true;

	public Boolean getMostrarFK_IdEmpresaFactura() {
		return this.mostrarFK_IdEmpresaFactura;
	}

	public void setMostrarFK_IdEmpresaFactura(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaFactura= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstadoFisicoFacturaEmpresaFactura=true;

	public Boolean getMostrarFK_IdEstadoFisicoFacturaEmpresaFactura() {
		return this.mostrarFK_IdEstadoFisicoFacturaEmpresaFactura;
	}

	public void setMostrarFK_IdEstadoFisicoFacturaEmpresaFactura(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstadoFisicoFacturaEmpresaFactura= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPedidoFactura=true;

	public Boolean getMostrarFK_IdPedidoFactura() {
		return this.mostrarFK_IdPedidoFactura;
	}

	public void setMostrarFK_IdPedidoFactura(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPedidoFactura= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoFactura=true;

	public Boolean getMostrarFK_IdPeriodoFactura() {
		return this.mostrarFK_IdPeriodoFactura;
	}

	public void setMostrarFK_IdPeriodoFactura(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoFactura= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdResponsableFactura=true;

	public Boolean getMostrarFK_IdResponsableFactura() {
		return this.mostrarFK_IdResponsableFactura;
	}

	public void setMostrarFK_IdResponsableFactura(Boolean visibilidadResaltar) {
		this.mostrarFK_IdResponsableFactura= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSubClienteFactura=true;

	public Boolean getMostrarFK_IdSubClienteFactura() {
		return this.mostrarFK_IdSubClienteFactura;
	}

	public void setMostrarFK_IdSubClienteFactura(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSubClienteFactura= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalFactura=true;

	public Boolean getMostrarFK_IdSucursalFactura() {
		return this.mostrarFK_IdSucursalFactura;
	}

	public void setMostrarFK_IdSucursalFactura(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalFactura= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTransportistaFactura=true;

	public Boolean getMostrarFK_IdTransportistaFactura() {
		return this.mostrarFK_IdTransportistaFactura;
	}

	public void setMostrarFK_IdTransportistaFactura(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTransportistaFactura= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUsuarioFactura=true;

	public Boolean getMostrarFK_IdUsuarioFactura() {
		return this.mostrarFK_IdUsuarioFactura;
	}

	public void setMostrarFK_IdUsuarioFactura(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUsuarioFactura= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdVendedorFactura=true;

	public Boolean getMostrarFK_IdVendedorFactura() {
		return this.mostrarFK_IdVendedorFactura;
	}

	public void setMostrarFK_IdVendedorFactura(Boolean visibilidadResaltar) {
		this.mostrarFK_IdVendedorFactura= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorNumeroPreImpresoFactura=true;

	public Boolean getActivarBusquedaPorNumeroPreImpresoFactura() {
		return this.activarBusquedaPorNumeroPreImpresoFactura;
	}

	public void setActivarBusquedaPorNumeroPreImpresoFactura(Boolean habilitarResaltar) {
		this.activarBusquedaPorNumeroPreImpresoFactura= habilitarResaltar;
	}

	public Boolean activarFK_IdClienteFactura=true;

	public Boolean getActivarFK_IdClienteFactura() {
		return this.activarFK_IdClienteFactura;
	}

	public void setActivarFK_IdClienteFactura(Boolean habilitarResaltar) {
		this.activarFK_IdClienteFactura= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioFactura=true;

	public Boolean getActivarFK_IdEjercicioFactura() {
		return this.activarFK_IdEjercicioFactura;
	}

	public void setActivarFK_IdEjercicioFactura(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioFactura= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaFactura=true;

	public Boolean getActivarFK_IdEmpresaFactura() {
		return this.activarFK_IdEmpresaFactura;
	}

	public void setActivarFK_IdEmpresaFactura(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaFactura= habilitarResaltar;
	}

	public Boolean activarFK_IdEstadoFisicoFacturaEmpresaFactura=true;

	public Boolean getActivarFK_IdEstadoFisicoFacturaEmpresaFactura() {
		return this.activarFK_IdEstadoFisicoFacturaEmpresaFactura;
	}

	public void setActivarFK_IdEstadoFisicoFacturaEmpresaFactura(Boolean habilitarResaltar) {
		this.activarFK_IdEstadoFisicoFacturaEmpresaFactura= habilitarResaltar;
	}

	public Boolean activarFK_IdPedidoFactura=true;

	public Boolean getActivarFK_IdPedidoFactura() {
		return this.activarFK_IdPedidoFactura;
	}

	public void setActivarFK_IdPedidoFactura(Boolean habilitarResaltar) {
		this.activarFK_IdPedidoFactura= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoFactura=true;

	public Boolean getActivarFK_IdPeriodoFactura() {
		return this.activarFK_IdPeriodoFactura;
	}

	public void setActivarFK_IdPeriodoFactura(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoFactura= habilitarResaltar;
	}

	public Boolean activarFK_IdResponsableFactura=true;

	public Boolean getActivarFK_IdResponsableFactura() {
		return this.activarFK_IdResponsableFactura;
	}

	public void setActivarFK_IdResponsableFactura(Boolean habilitarResaltar) {
		this.activarFK_IdResponsableFactura= habilitarResaltar;
	}

	public Boolean activarFK_IdSubClienteFactura=true;

	public Boolean getActivarFK_IdSubClienteFactura() {
		return this.activarFK_IdSubClienteFactura;
	}

	public void setActivarFK_IdSubClienteFactura(Boolean habilitarResaltar) {
		this.activarFK_IdSubClienteFactura= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalFactura=true;

	public Boolean getActivarFK_IdSucursalFactura() {
		return this.activarFK_IdSucursalFactura;
	}

	public void setActivarFK_IdSucursalFactura(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalFactura= habilitarResaltar;
	}

	public Boolean activarFK_IdTransportistaFactura=true;

	public Boolean getActivarFK_IdTransportistaFactura() {
		return this.activarFK_IdTransportistaFactura;
	}

	public void setActivarFK_IdTransportistaFactura(Boolean habilitarResaltar) {
		this.activarFK_IdTransportistaFactura= habilitarResaltar;
	}

	public Boolean activarFK_IdUsuarioFactura=true;

	public Boolean getActivarFK_IdUsuarioFactura() {
		return this.activarFK_IdUsuarioFactura;
	}

	public void setActivarFK_IdUsuarioFactura(Boolean habilitarResaltar) {
		this.activarFK_IdUsuarioFactura= habilitarResaltar;
	}

	public Boolean activarFK_IdVendedorFactura=true;

	public Boolean getActivarFK_IdVendedorFactura() {
		return this.activarFK_IdVendedorFactura;
	}

	public void setActivarFK_IdVendedorFactura(Boolean habilitarResaltar) {
		this.activarFK_IdVendedorFactura= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorNumeroPreImpresoFactura=null;

	public Border getResaltarBusquedaPorNumeroPreImpresoFactura() {
		return this.resaltarBusquedaPorNumeroPreImpresoFactura;
	}

	public void setResaltarBusquedaPorNumeroPreImpresoFactura(Border borderResaltar) {
		this.resaltarBusquedaPorNumeroPreImpresoFactura= borderResaltar;
	}

	public void setResaltarBusquedaPorNumeroPreImpresoFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNumeroPreImpresoFactura= borderResaltar;
	}

	public Border resaltarFK_IdClienteFactura=null;

	public Border getResaltarFK_IdClienteFactura() {
		return this.resaltarFK_IdClienteFactura;
	}

	public void setResaltarFK_IdClienteFactura(Border borderResaltar) {
		this.resaltarFK_IdClienteFactura= borderResaltar;
	}

	public void setResaltarFK_IdClienteFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteFactura= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioFactura=null;

	public Border getResaltarFK_IdEjercicioFactura() {
		return this.resaltarFK_IdEjercicioFactura;
	}

	public void setResaltarFK_IdEjercicioFactura(Border borderResaltar) {
		this.resaltarFK_IdEjercicioFactura= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioFactura= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaFactura=null;

	public Border getResaltarFK_IdEmpresaFactura() {
		return this.resaltarFK_IdEmpresaFactura;
	}

	public void setResaltarFK_IdEmpresaFactura(Border borderResaltar) {
		this.resaltarFK_IdEmpresaFactura= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaFactura= borderResaltar;
	}

	public Border resaltarFK_IdEstadoFisicoFacturaEmpresaFactura=null;

	public Border getResaltarFK_IdEstadoFisicoFacturaEmpresaFactura() {
		return this.resaltarFK_IdEstadoFisicoFacturaEmpresaFactura;
	}

	public void setResaltarFK_IdEstadoFisicoFacturaEmpresaFactura(Border borderResaltar) {
		this.resaltarFK_IdEstadoFisicoFacturaEmpresaFactura= borderResaltar;
	}

	public void setResaltarFK_IdEstadoFisicoFacturaEmpresaFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstadoFisicoFacturaEmpresaFactura= borderResaltar;
	}

	public Border resaltarFK_IdPedidoFactura=null;

	public Border getResaltarFK_IdPedidoFactura() {
		return this.resaltarFK_IdPedidoFactura;
	}

	public void setResaltarFK_IdPedidoFactura(Border borderResaltar) {
		this.resaltarFK_IdPedidoFactura= borderResaltar;
	}

	public void setResaltarFK_IdPedidoFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPedidoFactura= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoFactura=null;

	public Border getResaltarFK_IdPeriodoFactura() {
		return this.resaltarFK_IdPeriodoFactura;
	}

	public void setResaltarFK_IdPeriodoFactura(Border borderResaltar) {
		this.resaltarFK_IdPeriodoFactura= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoFactura= borderResaltar;
	}

	public Border resaltarFK_IdResponsableFactura=null;

	public Border getResaltarFK_IdResponsableFactura() {
		return this.resaltarFK_IdResponsableFactura;
	}

	public void setResaltarFK_IdResponsableFactura(Border borderResaltar) {
		this.resaltarFK_IdResponsableFactura= borderResaltar;
	}

	public void setResaltarFK_IdResponsableFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdResponsableFactura= borderResaltar;
	}

	public Border resaltarFK_IdSubClienteFactura=null;

	public Border getResaltarFK_IdSubClienteFactura() {
		return this.resaltarFK_IdSubClienteFactura;
	}

	public void setResaltarFK_IdSubClienteFactura(Border borderResaltar) {
		this.resaltarFK_IdSubClienteFactura= borderResaltar;
	}

	public void setResaltarFK_IdSubClienteFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSubClienteFactura= borderResaltar;
	}

	public Border resaltarFK_IdSucursalFactura=null;

	public Border getResaltarFK_IdSucursalFactura() {
		return this.resaltarFK_IdSucursalFactura;
	}

	public void setResaltarFK_IdSucursalFactura(Border borderResaltar) {
		this.resaltarFK_IdSucursalFactura= borderResaltar;
	}

	public void setResaltarFK_IdSucursalFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalFactura= borderResaltar;
	}

	public Border resaltarFK_IdTransportistaFactura=null;

	public Border getResaltarFK_IdTransportistaFactura() {
		return this.resaltarFK_IdTransportistaFactura;
	}

	public void setResaltarFK_IdTransportistaFactura(Border borderResaltar) {
		this.resaltarFK_IdTransportistaFactura= borderResaltar;
	}

	public void setResaltarFK_IdTransportistaFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTransportistaFactura= borderResaltar;
	}

	public Border resaltarFK_IdUsuarioFactura=null;

	public Border getResaltarFK_IdUsuarioFactura() {
		return this.resaltarFK_IdUsuarioFactura;
	}

	public void setResaltarFK_IdUsuarioFactura(Border borderResaltar) {
		this.resaltarFK_IdUsuarioFactura= borderResaltar;
	}

	public void setResaltarFK_IdUsuarioFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUsuarioFactura= borderResaltar;
	}

	public Border resaltarFK_IdVendedorFactura=null;

	public Border getResaltarFK_IdVendedorFactura() {
		return this.resaltarFK_IdVendedorFactura;
	}

	public void setResaltarFK_IdVendedorFactura(Border borderResaltar) {
		this.resaltarFK_IdVendedorFactura= borderResaltar;
	}

	public void setResaltarFK_IdVendedorFactura(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaBeanSwingJInternalFrame facturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdVendedorFactura= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}